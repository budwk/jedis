package com.budwk.jedis.args;

import com.budwk.jedis.util.SafeEncoder;

/**
 * The options for {@code BITCOUNT} command.
 */
public enum BitCountOption implements Rawable {

  BYTE, BIT;

  private final byte[] raw;

  private BitCountOption() {
    raw = SafeEncoder.encode(name());
  }

  @Override
  public byte[] getRaw() {
    return raw;
  }
}
