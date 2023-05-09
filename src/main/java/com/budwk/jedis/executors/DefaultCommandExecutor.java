package com.budwk.jedis.executors;

import com.budwk.jedis.CommandObject;
import com.budwk.jedis.Connection;
import com.budwk.jedis.util.IOUtils;
import com.budwk.jedis.providers.ConnectionProvider;

public class DefaultCommandExecutor implements CommandExecutor {

  protected final ConnectionProvider provider;

  public DefaultCommandExecutor(ConnectionProvider provider) {
    this.provider = provider;
  }

  @Override
  public void close() {
    IOUtils.closeQuietly(this.provider);
  }

  @Override
  public final <T> T executeCommand(CommandObject<T> commandObject) {
    try (Connection connection = provider.getConnection(commandObject.getArguments())) {
      return connection.executeCommand(commandObject);
    }
  }
}
