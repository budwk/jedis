package com.budwk.jedis.params;

import static com.budwk.jedis.Protocol.Keyword.LIMIT;
import static com.budwk.jedis.Protocol.Keyword.MAXLEN;
import static com.budwk.jedis.Protocol.Keyword.MINID;

import com.budwk.jedis.CommandArguments;
import com.budwk.jedis.Protocol;
import com.budwk.jedis.util.SafeEncoder;

public class XTrimParams implements IParams {

  private Long maxLen;

  private boolean approximateTrimming;

  private boolean exactTrimming;

  private String minId;

  private Long limit;

  public static XTrimParams xTrimParams() {
    return new XTrimParams();
  }


  public XTrimParams maxLen(long maxLen) {
    this.maxLen = maxLen;
    return this;
  }

  public XTrimParams minId(String minId) {
    this.minId = minId;
    return this;
  }

  public XTrimParams approximateTrimming() {
    this.approximateTrimming = true;
    return this;
  }

  public XTrimParams exactTrimming() {
    this.exactTrimming = true;
    return this;
  }

  public XTrimParams limit(long limit) {
    this.limit = limit;
    return this;
  }

  @Override
  public void addParams(CommandArguments args) {
    if (maxLen != null) {
      args.add(MAXLEN.getRaw());

      if (approximateTrimming) {
        args.add(Protocol.BYTES_TILDE);
      } else if (exactTrimming) {
        args.add(Protocol.BYTES_EQUAL);
      }

      args.add(Protocol.toByteArray(maxLen));
    } else if (minId != null) {
      args.add(MINID.getRaw());

      if (approximateTrimming) {
        args.add(Protocol.BYTES_TILDE);
      } else if (exactTrimming) {
        args.add(Protocol.BYTES_EQUAL);
      }

      args.add(SafeEncoder.encode(minId));
    }

    if (limit != null) {
      args.add(LIMIT.getRaw());
      args.add(Protocol.toByteArray(limit));
    }
  }
}
