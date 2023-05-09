package com.budwk.jedis.args;

import com.budwk.jedis.commands.ClusterCommands;
import com.budwk.jedis.util.SafeEncoder;

/**
 * Enumeration of cluster failover options.
 * <p>
 * Used by {@link ClusterCommands#clusterFailover(ClusterFailoverOption)}.
 */
public enum ClusterFailoverOption implements Rawable {

  FORCE, TAKEOVER;

  private final byte[] raw;

  private ClusterFailoverOption() {
    this.raw = SafeEncoder.encode(name());
  }

  @Override
  public byte[] getRaw() {
    return raw;
  }
}
