package com.budwk.jedis.bloom;

import static com.budwk.jedis.Protocol.toByteArray;
import static com.budwk.jedis.bloom.RedisBloomProtocol.RedisBloomKeyword.CAPACITY;
import static com.budwk.jedis.bloom.RedisBloomProtocol.RedisBloomKeyword.ERROR;
import static com.budwk.jedis.bloom.RedisBloomProtocol.RedisBloomKeyword.EXPANSION;
import static com.budwk.jedis.bloom.RedisBloomProtocol.RedisBloomKeyword.NOCREATE;
import static com.budwk.jedis.bloom.RedisBloomProtocol.RedisBloomKeyword.NONSCALING;

import com.budwk.jedis.params.IParams;
import com.budwk.jedis.CommandArguments;

// [CAPACITY {cap}] [ERROR {error}] [EXPANSION {expansion}] [NOCREATE] [NONSCALING]
public class BFInsertParams implements IParams {

  private Long capacity;
  private Double errorRate;
  private Integer expansion;
  private boolean noCreate = false;
  private boolean nonScaling = false;

  public static BFInsertParams insertParams() {
    return new BFInsertParams();
  }

  public BFInsertParams capacity(long capacity) {
    this.capacity = capacity;
    return this;
  }

  public BFInsertParams error(double errorRate) {
    this.errorRate = errorRate;
    return this;
  }

  public BFInsertParams expansion(int expansion) {
    this.expansion = expansion;
    return this;
  }

  public BFInsertParams noCreate() {
    this.noCreate = true;
    return this;
  }

  public BFInsertParams nonScaling() {
    this.nonScaling = true;
    return this;
  }

  @Override
  public void addParams(CommandArguments args) {
    if (capacity != null) {
      args.add(CAPACITY).add(toByteArray(capacity));
    }
    if (errorRate != null) {
      args.add(ERROR).add(toByteArray(errorRate));
    }
    if (expansion != null) {
      args.add(EXPANSION).add(toByteArray(expansion));
    }
    if (noCreate) {
      args.add(NOCREATE);
    }
    if (nonScaling) {
      args.add(NONSCALING);
    }
  }
}
