package com.budwk.jedis;

import java.util.Set;

import com.budwk.jedis.providers.SentineledConnectionProvider;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

public class JedisSentineled extends UnifiedJedis {

  /**
   * This constructor is here for easier transition from {@link JedisSentinelPool#JedisSentinelPool(
   * java.lang.String, java.util.Set, JedisClientConfig, JedisClientConfig)}.
   *
   * @deprecated Use {@link #JedisSentineled(java.lang.String, JedisClientConfig,
   * java.util.Set, JedisClientConfig)}.
   */
  @Deprecated
  // Legacy
  public JedisSentineled(String masterName, Set<HostAndPort> sentinels,
      final JedisClientConfig masterClientConfig, final JedisClientConfig sentinelClientConfig) {
    this(masterName, masterClientConfig, sentinels, sentinelClientConfig);
  }

  public JedisSentineled(String masterName, final JedisClientConfig masterClientConfig,
      Set<HostAndPort> sentinels, final JedisClientConfig sentinelClientConfig) {
    this(new SentineledConnectionProvider(masterName, masterClientConfig, sentinels, sentinelClientConfig));
  }

  /**
   * This constructor is here for easier transition from {@link JedisSentinelPool#JedisSentinelPool(
   * java.lang.String, java.util.Set, org.apache.commons.pool2.impl.GenericObjectPoolConfig,
   * JedisClientConfig, JedisClientConfig)}.
   *
   * @deprecated Use {@link #JedisSentineled(java.lang.String, JedisClientConfig,
   * org.apache.commons.pool2.impl.GenericObjectPoolConfig, java.util.Set, JedisClientConfig)}.
   */
  @Deprecated
  // Legacy
  public JedisSentineled(String masterName, Set<HostAndPort> sentinels,
      final GenericObjectPoolConfig<Connection> poolConfig, final JedisClientConfig masterClientConfig,
      final JedisClientConfig sentinelClientConfig) {
    this(masterName, masterClientConfig, poolConfig, sentinels, sentinelClientConfig);
  }

  public JedisSentineled(String masterName, final JedisClientConfig masterClientConfig,
      final GenericObjectPoolConfig<Connection> poolConfig,
      Set<HostAndPort> sentinels, final JedisClientConfig sentinelClientConfig) {
    this(new SentineledConnectionProvider(masterName, masterClientConfig, poolConfig, sentinels, sentinelClientConfig));
  }

  public JedisSentineled(SentineledConnectionProvider sentineledConnectionProvider) {
    super(sentineledConnectionProvider);
  }

  public HostAndPort getCurrentMaster() {
    return ((SentineledConnectionProvider) provider).getCurrentMaster();
  }
}
