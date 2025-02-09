package com.budwk.jedis.args;

import com.budwk.jedis.util.SafeEncoder;

/**
 * Client pause supported modes.
 */
public enum ClientPauseMode implements Rawable {

  ALL, WRITE;

  private final byte[] raw;

  private ClientPauseMode() {
    raw = SafeEncoder.encode(name());
  }

  @Override
  public byte[] getRaw() {
    return raw;
  }
}
