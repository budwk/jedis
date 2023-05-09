package com.budwk.jedis.params;

import static com.budwk.jedis.Protocol.Keyword.LIMIT;
import static com.budwk.jedis.Protocol.Keyword.MAXLEN;
import static com.budwk.jedis.Protocol.Keyword.MINID;
import static com.budwk.jedis.Protocol.Keyword.NOMKSTREAM;
import static com.budwk.jedis.util.SafeEncoder.encode;

import java.util.Arrays;
import com.budwk.jedis.CommandArguments;
import com.budwk.jedis.Protocol;
import com.budwk.jedis.StreamEntryID;

public class XAddParams implements IParams {

  private static final byte[] NEW_ENTRY = encode(StreamEntryID.NEW_ENTRY.toString());

  private byte[] id;

  private Long maxLen;

  private boolean approximateTrimming;

  private boolean exactTrimming;

  private boolean nomkstream;

  private String minId;

  private Long limit;

  public static XAddParams xAddParams() {
    return new XAddParams();
  }

  public XAddParams noMkStream() {
    this.nomkstream = true;
    return this;
  }

  public XAddParams id(byte[] id) {
    this.id = Arrays.copyOf(id, id.length);
    return this;
  }

  public XAddParams id(String id) {
    this.id = encode(id);
    return this;
  }

  public XAddParams id(StreamEntryID id) {
    return id(id.toString());
  }

  public XAddParams id(long time, long sequence) {
    return id(time + "-" + sequence);
  }

  public XAddParams id(long time) {
    return id(time + "-*");
  }

  public XAddParams maxLen(long maxLen) {
    this.maxLen = maxLen;
    return this;
  }

  public XAddParams minId(String minId) {
    this.minId = minId;
    return this;
  }

  public XAddParams approximateTrimming() {
    this.approximateTrimming = true;
    return this;
  }

  public XAddParams exactTrimming() {
    this.exactTrimming = true;
    return this;
  }

  public XAddParams limit(long limit) {
    this.limit = limit;
    return this;
  }

  @Override
  public void addParams(CommandArguments args) {

    if (nomkstream) {
      args.add(NOMKSTREAM.getRaw());
    }

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

      args.add(encode(minId));
    }

    if (limit != null) {
      args.add(LIMIT.getRaw());
      args.add(Protocol.toByteArray(limit));
    }

    args.add(id != null ? id : NEW_ENTRY);
  }
}
