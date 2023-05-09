package com.budwk.jedis.timeseries;

import com.budwk.jedis.CommandArguments;
import com.budwk.jedis.params.IParams;

/**
 * Represents optional arguments of TS.GET command.
 */
public class TSGetParams implements IParams {

  private boolean latest;

  public static TSGetParams getParams() {
    return new TSGetParams();
  }

  public TSGetParams latest() {
    this.latest = true;
    return this;
  }

  @Override
  public void addParams(CommandArguments args) {
    if (latest) {
      args.add(TimeSeriesProtocol.TimeSeriesKeyword.LATEST);
    }
  }
}
