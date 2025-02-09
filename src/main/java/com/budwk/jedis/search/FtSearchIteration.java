package com.budwk.jedis.search;

import java.util.Collection;
import java.util.function.IntFunction;

import com.budwk.jedis.providers.ConnectionProvider;
import com.budwk.jedis.CommandArguments;
import com.budwk.jedis.util.JedisCommandIterationBase;

public class FtSearchIteration extends JedisCommandIterationBase<SearchResult, Document> {

  private int batchStart;
  private final int batchSize;
  private final IntFunction<CommandArguments> args;

  /**
   * {@link FTSearchParams#limit(int, int)} will be ignored.
   */
  public FtSearchIteration(ConnectionProvider connectionProvider, int batchSize, String indexName, String query, FTSearchParams params) {
    super(connectionProvider, new SearchResult.SearchResultBuilder(!params.getNoContent(), params.getWithScores(), false, true));
    this.batchSize = batchSize;
    this.args = (limitFirst) -> new CommandArguments(SearchProtocol.SearchCommand.SEARCH)
        .add(indexName).add(query).addParams(params.limit(limitFirst, this.batchSize));
  }

  /**
   * {@link Query#limit(java.lang.Integer, java.lang.Integer)} will be ignored.
   */
  public FtSearchIteration(ConnectionProvider connectionProvider, int batchSize, String indexName, Query query) {
    super(connectionProvider, new SearchResult.SearchResultBuilder(!query.getNoContent(), query.getWithScores(), query.getWithPayloads(), true));
    this.batchSize = batchSize;
    this.args = (limitFirst) -> new CommandArguments(SearchProtocol.SearchCommand.SEARCH)
        .add(indexName).addParams(query.limit(limitFirst, this.batchSize));
  }

  @Override
  protected boolean isNodeCompleted(SearchResult reply) {
    return batchStart >= reply.getTotalResults() - batchSize;
  }

  @Override
  protected CommandArguments initCommandArguments() {
    batchStart = 0;
    return args.apply(batchStart);
  }

  @Override
  protected CommandArguments nextCommandArguments(SearchResult lastReply) {
    batchStart += batchSize;
    return args.apply(batchStart);
  }

  @Override
  protected Collection<Document> convertBatchToData(SearchResult batch) {
    return batch.getDocuments();
  }
}
