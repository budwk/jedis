package com.budwk.jedis.exceptions;

import com.budwk.jedis.HostAndPort;

/**
 * Umbrella exception class representing all redirection replies from Redis.
 *
 * @see JedisAskDataException
 * @see JedisMovedDataException
 */
public class JedisRedirectionException extends JedisDataException {

  private static final long serialVersionUID = 3878126572474819403L;

  private final HostAndPort targetNode;
  private final int slot;

  public JedisRedirectionException(String message, HostAndPort targetNode, int slot) {
    super(message);
    this.targetNode = targetNode;
    this.slot = slot;
  }

  public JedisRedirectionException(Throwable cause, HostAndPort targetNode, int slot) {
    super(cause);
    this.targetNode = targetNode;
    this.slot = slot;
  }

  public JedisRedirectionException(String message, Throwable cause, HostAndPort targetNode, int slot) {
    super(message, cause);
    this.targetNode = targetNode;
    this.slot = slot;
  }

  public final HostAndPort getTargetNode() {
    return targetNode;
  }

  public final int getSlot() {
    return slot;
  }
}
