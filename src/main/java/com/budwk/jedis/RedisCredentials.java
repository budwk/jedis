package com.budwk.jedis;

public interface RedisCredentials {

  /**
   * @return Redis ACL user
   */
  default String getUser() {
    return null;
  }

  default char[] getPassword() {
    return null;
  }
}
