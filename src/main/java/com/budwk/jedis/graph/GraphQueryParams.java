package com.budwk.jedis.graph;

import java.util.HashMap;
import java.util.Map;

import com.budwk.jedis.exceptions.JedisException;
import com.budwk.jedis.params.IParams;
import com.budwk.jedis.CommandArguments;

public class GraphQueryParams implements IParams {

  private boolean readonly;
  private String query;
  private Map<String, Object> params;
  private Long timeout;

  /**
   * Query string must be set later.
   */
  public GraphQueryParams() {
  }

  /**
   * Query string must be set later.
   */
  public static GraphQueryParams queryParams() {
    return new GraphQueryParams();
  }

  public GraphQueryParams(String query) {
    this.query = query;
  }

  public static GraphQueryParams queryParams(String query) {
    return new GraphQueryParams(query);
  }

  public GraphQueryParams readonly() {
    return readonly(true);
  }

  public GraphQueryParams readonly(boolean readonly) {
    this.readonly = readonly;
    return this;
  }

  public GraphQueryParams query(String queryStr) {
    this.query = queryStr;
    return this;
  }

  public GraphQueryParams params(Map<String, Object> params) {
    this.params = params;
    return this;
  }

  public GraphQueryParams addParam(String key, Object value) {
    if (this.params == null) this.params = new HashMap<>();
    this.params.put(key, value);
    return this;
  }

  public GraphQueryParams timeout(long timeout) {
    this.timeout = timeout;
    return this;
  }

  @Override
  public void addParams(CommandArguments args) {
    if (query == null) throw new JedisException("Query string must be set.");

    if (params == null) {
      args.add(query);
    } else {
      args.add(RedisGraphQueryUtil.prepareQuery(query, params));
    }

    args.add(GraphProtocol.GraphKeyword.__COMPACT);

    if (timeout != null) {
      args.add(GraphProtocol.GraphKeyword.TIMEOUT).add(timeout).blocking();
    }
  }

  public boolean isReadonly() {
    return readonly;
  }

  @Deprecated
  public CommandArguments getArguments(String graphName) {
    return new CommandArguments(!readonly ? GraphProtocol.GraphCommand.QUERY : GraphProtocol.GraphCommand.RO_QUERY)
        .key(graphName).addParams(this);
  }
}
