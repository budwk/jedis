package com.budwk.jedis.args;

import com.budwk.jedis.util.SafeEncoder;

/**
 * Bit operations for {@code BITOP} command.
 */
public enum BitOP implements Rawable {

  AND, OR, XOR, NOT;

  private final byte[] raw;

  private BitOP() {
    raw = SafeEncoder.encode(name());
  }

  @Override
  public byte[] getRaw() {
    return raw;
  }
}
