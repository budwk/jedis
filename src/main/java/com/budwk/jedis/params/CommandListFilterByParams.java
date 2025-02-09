package com.budwk.jedis.params;

import com.budwk.jedis.exceptions.JedisDataException;
import com.budwk.jedis.CommandArguments;

import static com.budwk.jedis.Protocol.Keyword.FILTERBY;
import static com.budwk.jedis.Protocol.Keyword.MODULE;
import static com.budwk.jedis.Protocol.Keyword.ACLCAT;
import static com.budwk.jedis.Protocol.Keyword.PATTERN;

public class CommandListFilterByParams implements IParams {
  private String moduleName;
  private String category;
  private String pattern;

  public static CommandListFilterByParams commandListFilterByParams() {
    return new CommandListFilterByParams();
  }

  public CommandListFilterByParams filterByModule(String moduleName) {
    this.moduleName = moduleName;
    return this;
  }

  public CommandListFilterByParams filterByAclCat(String category) {
    this.category = category;
    return this;
  }

  public CommandListFilterByParams filterByPattern(String pattern) {
    this.pattern = pattern;
    return this;
  }

  @Override
  public void addParams(CommandArguments args) {
    args.add(FILTERBY);

    if (moduleName != null && category == null && pattern == null) {
      args.add(MODULE);
      args.add(moduleName);
    } else if (moduleName == null && category != null && pattern == null) {
      args.add(ACLCAT);
      args.add(category);
    } else if (moduleName == null && category == null && pattern != null) {
      args.add(PATTERN);
      args.add(pattern);
    } else {
      throw new JedisDataException("Must choose exactly one filter");
    }
  }
}
