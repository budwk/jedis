package com.budwk.jedis.executors;

import com.budwk.jedis.CommandObject;

public interface CommandExecutor extends AutoCloseable {

  <T> T executeCommand(CommandObject<T> commandObject);

  default <T> T broadcastCommand(CommandObject<T> commandObject) {
    return executeCommand(commandObject);
  }
}
