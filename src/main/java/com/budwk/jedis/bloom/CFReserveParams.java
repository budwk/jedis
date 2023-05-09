package com.budwk.jedis.bloom;

import static com.budwk.jedis.Protocol.toByteArray;
import static com.budwk.jedis.bloom.RedisBloomProtocol.RedisBloomKeyword.BUCKETSIZE;
import static com.budwk.jedis.bloom.RedisBloomProtocol.RedisBloomKeyword.EXPANSION;
import static com.budwk.jedis.bloom.RedisBloomProtocol.RedisBloomKeyword.MAXITERATIONS;

import com.budwk.jedis.params.IParams;
import com.budwk.jedis.CommandArguments;

// [BUCKETSIZE {bucketsize}] [MAXITERATIONS {maxiterations}] [EXPANSION {expansion}]
public class CFReserveParams implements IParams {

  private Long bucketSize;
  private Integer maxIterations;
  private Integer expansion;

  public static CFReserveParams reserveParams() {
    return new CFReserveParams();
  }

  public CFReserveParams bucketSize(long bucketSize) {
    this.bucketSize = bucketSize;
    return this;
  }

  public CFReserveParams maxIterations(int maxIterations) {
    this.maxIterations = maxIterations;
    return this;
  }

  public CFReserveParams expansion(int expansion) {
    this.expansion = expansion;
    return this;
  }

  @Override
  public void addParams(CommandArguments args) {
    if (bucketSize != null) {
      args.add(BUCKETSIZE).add(toByteArray(bucketSize));
    }
    if (maxIterations != null) {
      args.add(MAXITERATIONS).add(toByteArray(maxIterations));
    }
    if (expansion != null) {
      args.add(EXPANSION).add(toByteArray(expansion));
    }
  }
}
