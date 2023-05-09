package com.budwk.jedis.search.aggr;

import java.util.Collection;

import com.budwk.jedis.providers.ConnectionProvider;
import com.budwk.jedis.search.SearchBuilderFactory;
import com.budwk.jedis.CommandArguments;
import com.budwk.jedis.search.SearchProtocol;
import com.budwk.jedis.util.JedisCommandIterationBase;

public class FtAggregateIteration extends JedisCommandIterationBase<AggregationResult, Row> {

  private final String indexName;
  private final CommandArguments args;

  /**
   * {@link AggregationBuilder#cursor(int, long) CURSOR} must be set.
   * @param connectionProvider connection provider
   * @param indexName index name
   * @param aggr cursor must be set
   */
  public FtAggregateIteration(ConnectionProvider connectionProvider, String indexName, AggregationBuilder aggr) {
    super(connectionProvider, SearchBuilderFactory.SEARCH_AGGREGATION_RESULT_WITH_CURSOR);
    if (!aggr.isWithCursor()) throw new IllegalArgumentException("cursor must be set");
    this.indexName = indexName;
    this.args = new CommandArguments(SearchProtocol.SearchCommand.AGGREGATE).add(this.indexName).addObjects(aggr.getArgs());
  }

  @Override
  protected boolean isNodeCompleted(AggregationResult reply) {
    return reply.getCursorId() == 0L;
  }

  @Override
  protected CommandArguments initCommandArguments() {
    return args;
  }

  @Override
  protected CommandArguments nextCommandArguments(AggregationResult lastReply) {
    return new CommandArguments(SearchProtocol.SearchCommand.CURSOR).add(SearchProtocol.SearchKeyword.READ)
        .add(indexName).add(lastReply.getCursorId());
  }

  @Override
  protected Collection<Row> convertBatchToData(AggregationResult batch) {
    return batch.getRows();
  }
}
