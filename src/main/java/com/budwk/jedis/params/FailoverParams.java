package com.budwk.jedis.params;

import static com.budwk.jedis.Protocol.Keyword.FORCE;
import static com.budwk.jedis.Protocol.Keyword.TIMEOUT;
import static com.budwk.jedis.Protocol.Keyword.TO;
import static com.budwk.jedis.Protocol.toByteArray;

import com.budwk.jedis.CommandArguments;
import com.budwk.jedis.HostAndPort;

public class FailoverParams implements IParams {

  private HostAndPort to;

  private boolean force;

  private Long timeout;

  public static FailoverParams failoverParams() {
    return new FailoverParams();
  }

  public FailoverParams to(String host, int port) {
    return to(new HostAndPort(host, port));
  }

  public FailoverParams to(HostAndPort to) {
    this.to = to;
    return this;
  }

  /**
   * WARNING: FORCE option can be used only if both TO and TIMEOUT options are specified.
   */
  public FailoverParams force() {
    this.force = true;
    return this;
  }

  public FailoverParams timeout(long timeout) {
    this.timeout = timeout;
    return this;
  }

  @Override
  public void addParams(CommandArguments args) {

    if (to != null) {
      args.add(TO);
      args.add(to.getHost()).add(toByteArray(to.getPort()));
    }

    if (force) {
      if (to == null || timeout == null) {
        throw new IllegalStateException("ERR FAILOVER with force option requires both a timeout and target HOST and IP.");
      }
      args.add(FORCE);
    }

    if (timeout != null) {
      args.add(TIMEOUT).add(toByteArray(timeout));
    }

  }
}
