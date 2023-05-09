package com.budwk.jedis.search;

import static com.budwk.jedis.search.SearchProtocol.SearchKeyword.LIMITED;

import com.budwk.jedis.CommandArguments;
import com.budwk.jedis.params.IParams;

public class FTProfileParams implements IParams {

  private boolean limited;

  public FTProfileParams() {
  }

  public static FTProfileParams profileParams() {
    return new FTProfileParams();
  }

  /**
   * Removes details of {@code reader} iterator.
   */
  public FTProfileParams limited() {
    this.limited = true;
    return this;
  }

  @Override
  public void addParams(CommandArguments args) {

    if (limited) {
      args.add(LIMITED);
    }
  }
}
