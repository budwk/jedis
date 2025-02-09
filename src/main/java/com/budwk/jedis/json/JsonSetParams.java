package com.budwk.jedis.json;

import com.budwk.jedis.params.IParams;
import com.budwk.jedis.CommandArguments;

public class JsonSetParams implements IParams {

  private boolean nx = false;
  private boolean xx = false;

  public JsonSetParams() {
  }

  public static JsonSetParams jsonSetParams() {
    return new JsonSetParams();
  }

  public JsonSetParams nx() {
    this.nx = true;
    this.xx = false;
    return this;
  }

  public JsonSetParams xx() {
    this.nx = false;
    this.xx = true;
    return this;
  }

  @Override
  public void addParams(CommandArguments args) {
    if (nx) {
      args.add("NX");
    }
    if (xx) {
      args.add("XX");
    }
  }
}
