package com.budwk.jedis.bloom;

import static com.budwk.jedis.Protocol.toByteArray;
import static com.budwk.jedis.bloom.RedisBloomProtocol.RedisBloomKeyword.COMPRESSION;
import static com.budwk.jedis.bloom.RedisBloomProtocol.RedisBloomKeyword.OVERRIDE;

import com.budwk.jedis.params.IParams;
import com.budwk.jedis.CommandArguments;

public class TDigestMergeParams implements IParams {

  private Integer compression;
  private boolean override = false;

  public static TDigestMergeParams mergeParams() {
    return new TDigestMergeParams();
  }

  public TDigestMergeParams compression(int compression) {
    this.compression = compression;
    return this;
  }

  public TDigestMergeParams override() {
    this.override = true;
    return this;
  }

  @Override
  public void addParams(CommandArguments args) {
    if (compression != null) {
      args.add(COMPRESSION).add(toByteArray(compression));
    }
    if (override) {
      args.add(OVERRIDE);
    }
  }
}
