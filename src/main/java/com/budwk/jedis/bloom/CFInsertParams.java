package com.budwk.jedis.bloom;

import static com.budwk.jedis.Protocol.toByteArray;
import static com.budwk.jedis.bloom.RedisBloomProtocol.RedisBloomKeyword.CAPACITY;
import static com.budwk.jedis.bloom.RedisBloomProtocol.RedisBloomKeyword.NOCREATE;

import com.budwk.jedis.params.IParams;
import com.budwk.jedis.CommandArguments;

// [CAPACITY {capacity}] [NOCREATE]
public class CFInsertParams implements IParams {

  private Long capacity;
  private boolean noCreate = false;

  public static CFInsertParams insertParams() {
    return new CFInsertParams();
  }

  public CFInsertParams capacity(long capacity) {
    this.capacity = capacity;
    return this;
  }

  public CFInsertParams noCreate() {
    this.noCreate = true;
    return this;
  }

  @Override
  public void addParams(CommandArguments args) {
    if (capacity != null) {
      args.add(CAPACITY).add(toByteArray(capacity));
    }
    if (noCreate) {
      args.add(NOCREATE);
    }
  }
}
