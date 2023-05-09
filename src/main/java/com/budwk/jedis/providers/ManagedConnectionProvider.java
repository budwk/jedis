package com.budwk.jedis.providers;

import com.budwk.jedis.CommandArguments;
import com.budwk.jedis.Connection;

public class ManagedConnectionProvider implements ConnectionProvider {

  private Connection connection;

  public final void setConnection(Connection connection) {
    this.connection = connection;
  }

  @Override
  public void close() {
  }

  @Override
  public final Connection getConnection() {
    return connection;
  }

  @Override
  public final Connection getConnection(CommandArguments args) {
    return connection;
  }
}
