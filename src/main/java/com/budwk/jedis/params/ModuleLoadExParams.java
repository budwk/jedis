package com.budwk.jedis.params;

import static com.budwk.jedis.Protocol.Keyword.ARGS;
import static com.budwk.jedis.Protocol.Keyword.CONFIG;

import java.util.ArrayList;
import java.util.List;

import com.budwk.jedis.CommandArguments;
import com.budwk.jedis.util.KeyValue;

public class ModuleLoadExParams implements IParams {

  private final List<KeyValue<String, String>> configs = new ArrayList<>();
  private final List<String> args = new ArrayList<>();

  public ModuleLoadExParams() {
  }

  public ModuleLoadExParams moduleLoadexParams() {
    return new ModuleLoadExParams();
  }

  public ModuleLoadExParams config(String name, String value) {
    this.configs.add(KeyValue.of(name, value));
    return this;
  }

  public ModuleLoadExParams arg(String arg) {
    this.args.add(arg);
    return this;
  }

  @Override
  public void addParams(CommandArguments args) {

    this.configs.forEach(kv -> args.add(CONFIG).add(kv.getKey()).add(kv.getValue()));

    if (!this.args.isEmpty()) {
      args.add(ARGS).addObjects(this.args);
    }
  }
}
