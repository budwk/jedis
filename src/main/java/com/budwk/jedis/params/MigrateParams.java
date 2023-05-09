package com.budwk.jedis.params;

import static com.budwk.jedis.Protocol.Keyword.AUTH;
import static com.budwk.jedis.Protocol.Keyword.AUTH2;
import static com.budwk.jedis.Protocol.Keyword.COPY;
import static com.budwk.jedis.Protocol.Keyword.REPLACE;

import com.budwk.jedis.CommandArguments;

public class MigrateParams implements IParams {

  private boolean copy = false;
  private boolean replace = false;
  private String username = null;
  private String passowrd = null;

  public MigrateParams() {
  }

  public static MigrateParams migrateParams() {
    return new MigrateParams();
  }

  public MigrateParams copy() {
    this.copy = true;
    return this;
  }

  public MigrateParams replace() {
    this.replace = true;
    return this;
  }

  public MigrateParams auth(String password) {
    this.passowrd = password;
    return this;
  }

  public MigrateParams auth2(String username, String password) {
    this.username = username;
    this.passowrd = password;
    return this;
  }

  @Override
  public void addParams(CommandArguments args) {
    if (copy) {
      args.add(COPY);
    }
    if (replace) {
      args.add(REPLACE);
    }
    if (username != null) {
      args.add(AUTH2).add(username).add(passowrd);
    } else if (passowrd != null) {
      args.add(AUTH).add(passowrd);
    }
  }
}
