package com.budwk.jedis.params;

import static com.budwk.jedis.Protocol.Keyword.AGGREGATE;
import static com.budwk.jedis.Protocol.Keyword.WEIGHTS;

import java.util.ArrayList;
import java.util.List;

import com.budwk.jedis.CommandArguments;
import com.budwk.jedis.args.Rawable;
import com.budwk.jedis.util.SafeEncoder;

public class ZParams implements IParams {

  public enum Aggregate implements Rawable {

    SUM, MIN, MAX;

    private final byte[] raw;

    private Aggregate() {
      raw = SafeEncoder.encode(name());
    }

    @Override
    public byte[] getRaw() {
      return raw;
    }
  }

  private final List<Object> params = new ArrayList<>();

  public ZParams weights(final double... weights) {
    params.add(WEIGHTS);
    for (final double weight : weights) {
      params.add(weight);
    }

    return this;
  }

  public ZParams aggregate(final Aggregate aggregate) {
    params.add(AGGREGATE);
    params.add(aggregate);
    return this;
  }

  @Override
  public void addParams(CommandArguments args) {
    params.forEach(param -> args.add(param));
  }
}
