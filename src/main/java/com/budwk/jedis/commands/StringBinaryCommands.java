package com.budwk.jedis.commands;

import java.util.List;

import com.budwk.jedis.params.GetExParams;
import com.budwk.jedis.params.SetParams;
import com.budwk.jedis.params.StrAlgoLCSParams;
import com.budwk.jedis.params.LCSParams;
import com.budwk.jedis.resps.LCSMatchResult;

public interface StringBinaryCommands extends BitBinaryCommands {

  String set(byte[] key, byte[] value);

  String set(byte[] key, byte[] value, SetParams params);

  byte[] get(byte[] key);

  /**
   * WARNING: {@link SetParams#get()} MUST NOT be used with this method.
   */
  byte[] setGet(byte[] key, byte[] value, SetParams params);

  byte[] getDel(byte[] key);

  byte[] getEx(byte[] key, GetExParams params);

  long setrange(byte[] key, long offset, byte[] value);

  byte[] getrange(byte[] key, long startOffset, long endOffset);

  byte[] getSet(byte[] key, byte[] value);

  long setnx(byte[] key, byte[] value);

  String setex(byte[] key, long seconds, byte[] value);

  String psetex(byte[] key, long milliseconds, byte[] value);

  List<byte[]> mget(byte[]... keys);

  String mset(byte[]... keysvalues);

  long msetnx(byte[]... keysvalues);

  long incr(byte[] key);

  long incrBy(byte[] key, long increment);

  double incrByFloat(byte[] key, double increment);

  long decr(byte[] key);

  long decrBy(byte[] key, long decrement);

  long append(byte[] key, byte[] value);

  byte[] substr(byte[] key, int start, int end);

  long strlen(byte[] key);

  /**
   * @deprecated STRALGO LCS command will be removed from Redis 7.
   * {@link StringBinaryCommands#lcs(byte[], byte[], LCSParams) LCS} can be used instead of this method.
   */
  @Deprecated
  LCSMatchResult strAlgoLCSKeys(byte[] keyA, byte[] keyB, StrAlgoLCSParams params);

  /**
   * Calculate the longest common subsequence of keyA and keyB.
   * @param keyA
   * @param keyB
   * @param params
   * @return According to LCSParams to decide to return content to fill LCSMatchResult.
   */
  LCSMatchResult lcs(byte[] keyA, byte[] keyB, LCSParams params);
}
