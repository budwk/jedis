package com.budwk.jedis.args;

/**
 * Byte array representation of arguments to write in socket input stream.
 */
public interface Rawable {

  /**
   * Get byte array.
   * @return binary
   */
  byte[] getRaw();
}
