package com.budwk.jedis.providers;

import java.util.Collections;
import java.util.Map;
import com.budwk.jedis.CommandArguments;
import com.budwk.jedis.Connection;

public interface ConnectionProvider extends AutoCloseable {

  Connection getConnection();

  Connection getConnection(CommandArguments args);

  default Map<?, ?> getConnectionMap() {
    final Connection c = getConnection();
    return Collections.singletonMap(c.toString(), c);
  }
}
