package com.budwk.jedis.args;

import com.budwk.jedis.util.SafeEncoder;

/**
 * Direction for {@code LMOVE} and {@code BLMOVE} command.
 */
public enum ListDirection implements Rawable {

  LEFT, RIGHT;

  private final byte[] raw;

  private ListDirection() {
    raw = SafeEncoder.encode(name());
  }

  @Override
  public byte[] getRaw() {
    return raw;
  }
}
