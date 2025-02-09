package com.budwk.jedis;

import com.budwk.jedis.util.Pool;
import org.apache.commons.pool2.PooledObjectFactory;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

public class ConnectionPool extends Pool<Connection> {

  public ConnectionPool(HostAndPort hostAndPort, JedisClientConfig clientConfig) {
    this(new ConnectionFactory(hostAndPort, clientConfig));
  }

  public ConnectionPool(PooledObjectFactory<Connection> factory) {
    super(factory);
  }

  public ConnectionPool(HostAndPort hostAndPort, JedisClientConfig clientConfig,
      GenericObjectPoolConfig<Connection> poolConfig) {
    this(new ConnectionFactory(hostAndPort, clientConfig), poolConfig);
  }

  public ConnectionPool(PooledObjectFactory<Connection> factory,
      GenericObjectPoolConfig<Connection> poolConfig) {
    super(factory, poolConfig);
  }

  @Override
  public Connection getResource() {
    Connection conn = super.getResource();
    conn.setHandlingPool(this);
    return conn;
  }
}
