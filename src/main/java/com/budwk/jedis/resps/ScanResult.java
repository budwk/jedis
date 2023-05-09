package com.budwk.jedis.resps;

import java.util.List;

import com.budwk.jedis.params.ScanParams;

import com.budwk.jedis.util.SafeEncoder;

public class ScanResult<T> {
  private byte[] cursor;
  private List<T> results;

  public ScanResult(String cursor, List<T> results) {
    this(SafeEncoder.encode(cursor), results);
  }

  public ScanResult(byte[] cursor, List<T> results) {
    this.cursor = cursor;
    this.results = results;
  }

  /**
   * Returns the new value of the cursor
   * @return the new cursor value. {@link ScanParams#SCAN_POINTER_START} when a complete iteration has finished
   */
  public String getCursor() {
    return SafeEncoder.encode(cursor);
  }

  /**
   * Is the iteration complete. I.e. was the complete dataset scanned.
   * @return {@code true} if the iteration is complete
   */
  public boolean isCompleteIteration() {
    return ScanParams.SCAN_POINTER_START.equals(getCursor());
  }

  public byte[] getCursorAsBytes() {
    return cursor;
  }

  /**
   * The scan results from the current call.
   * @return the scan results
   */
  public List<T> getResult() {
    return results;
  }
}
