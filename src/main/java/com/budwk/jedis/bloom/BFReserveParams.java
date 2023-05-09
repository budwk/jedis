package com.budwk.jedis.bloom;

import static com.budwk.jedis.Protocol.toByteArray;
import static com.budwk.jedis.bloom.RedisBloomProtocol.RedisBloomKeyword.EXPANSION;
import static com.budwk.jedis.bloom.RedisBloomProtocol.RedisBloomKeyword.NONSCALING;

import com.budwk.jedis.params.IParams;
import com.budwk.jedis.CommandArguments;

public class BFReserveParams implements IParams {

  private Integer expansion;
  private boolean nonScaling = false;

  public static BFReserveParams reserveParams() {
    return new BFReserveParams();
  }

  public BFReserveParams expansion(int expansion) {
    this.expansion = expansion;
    return this;
  }

  public BFReserveParams nonScaling() {
    this.nonScaling = true;
    return this;
  }

  @Override
  public void addParams(CommandArguments args) {
    if (expansion != null) {
      args.add(EXPANSION).add(toByteArray(expansion));
    }
    if (nonScaling) {
      args.add(NONSCALING);
    }
  }
}
