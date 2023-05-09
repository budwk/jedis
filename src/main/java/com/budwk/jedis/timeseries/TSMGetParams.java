package com.budwk.jedis.timeseries;

import com.budwk.jedis.CommandArguments;
import com.budwk.jedis.params.IParams;

/**
 * Represents optional arguments of TS.MGET command.
 */
public class TSMGetParams implements IParams {

  private boolean latest;

  private boolean withLabels;
  private String[] selectedLabels;

  public static TSMGetParams multiGetParams() {
    return new TSMGetParams();
  }

  public TSMGetParams latest() {
    this.latest = true;
    return this;
  }

  public TSMGetParams withLabels(boolean withLabels) {
    this.withLabels = withLabels;
    return this;
  }

  public TSMGetParams withLabels() {
    return withLabels(true);
  }

  public TSMGetParams selectedLabels(String... labels) {
    this.selectedLabels = labels;
    return this;
  }

  @Override
  public void addParams(CommandArguments args) {
    if (latest) {
      args.add(TimeSeriesProtocol.TimeSeriesKeyword.LATEST);
    }

    if (withLabels) {
      args.add(TimeSeriesProtocol.TimeSeriesKeyword.WITHLABELS);
    } else if (selectedLabels != null) {
      args.add(TimeSeriesProtocol.TimeSeriesKeyword.SELECTED_LABELS);
      for (String label : selectedLabels) {
        args.add(label);
      }
    }
  }
}
