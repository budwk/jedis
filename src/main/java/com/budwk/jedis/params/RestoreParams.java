package com.budwk.jedis.params;

import static com.budwk.jedis.Protocol.Keyword.ABSTTL;
import static com.budwk.jedis.Protocol.Keyword.FREQ;
import static com.budwk.jedis.Protocol.Keyword.IDLETIME;
import static com.budwk.jedis.Protocol.Keyword.REPLACE;

import com.budwk.jedis.CommandArguments;
import com.budwk.jedis.Protocol;

public class RestoreParams implements IParams {

  private boolean replace;

  private boolean absTtl;

  private Long idleTime;

  private Long frequency;

  public static RestoreParams restoreParams() {
    return new RestoreParams();
  }

  public RestoreParams replace() {
    this.replace = true;
    return this;
  }

  public RestoreParams absTtl() {
    this.absTtl = true;
    return this;
  }

  public RestoreParams idleTime(long idleTime) {
    this.idleTime = idleTime;
    return this;
  }

  public RestoreParams frequency(long frequency) {
    this.frequency = frequency;
    return this;
  }

  @Override
  public void addParams(CommandArguments args) {
    if (replace) {
      args.add(REPLACE.getRaw());
    }

    if (absTtl) {
      args.add(ABSTTL.getRaw());
    }

    if (idleTime != null) {
      args.add(IDLETIME.getRaw());
      args.add(Protocol.toByteArray(idleTime));
    }

    if (frequency != null) {
      args.add(FREQ.getRaw());
      args.add(Protocol.toByteArray(frequency));
    }
  }
}
