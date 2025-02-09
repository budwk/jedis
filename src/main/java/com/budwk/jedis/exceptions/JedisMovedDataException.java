package com.budwk.jedis.exceptions;

import com.budwk.jedis.HostAndPort;

/**
 * {@code -MOVED} reply from Redis.
 */
public class JedisMovedDataException extends JedisRedirectionException {

  private static final long serialVersionUID = 3878126572474819403L;

  public JedisMovedDataException(String message, HostAndPort targetNode, int slot) {
    super(message, targetNode, slot);
  }

  public JedisMovedDataException(Throwable cause, HostAndPort targetNode, int slot) {
    super(cause, targetNode, slot);
  }

  public JedisMovedDataException(String message, Throwable cause, HostAndPort targetNode, int slot) {
    super(message, cause, targetNode, slot);
  }
}
