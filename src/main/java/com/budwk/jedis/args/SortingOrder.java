package com.budwk.jedis.args;

import com.budwk.jedis.util.SafeEncoder;

public enum SortingOrder implements Rawable {

  ASC, DESC;

  private final byte[] raw;

  private SortingOrder() {
    raw = SafeEncoder.encode(this.name());
  }

  @Override
  public byte[] getRaw() {
    return raw;
  }
}
