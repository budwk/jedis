package com.budwk.jedis;

public interface JedisBroadcastAndRoundRobinConfig {

  public enum RediSearchMode {
    DEFAULT, LIGHT;
  }

  RediSearchMode getRediSearchModeInCluster();
}
