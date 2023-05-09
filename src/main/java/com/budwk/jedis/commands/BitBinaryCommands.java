package com.budwk.jedis.commands;

import java.util.List;

import com.budwk.jedis.args.BitCountOption;
import com.budwk.jedis.args.BitOP;
import com.budwk.jedis.params.BitPosParams;

public interface BitBinaryCommands {

  boolean setbit(byte[] key, long offset, boolean value);

  boolean getbit(byte[] key, long offset);

  long bitcount(byte[] key);

  long bitcount(byte[] key, long start, long end);

  long bitcount(byte[] key, long start, long end, BitCountOption option);

  long bitpos(byte[] key, boolean value);

  long bitpos(byte[] key, boolean value, BitPosParams params);

  List<Long> bitfield(byte[] key, byte[]... arguments);

  List<Long> bitfieldReadonly(byte[] key, byte[]... arguments);

  long bitop(BitOP op, byte[] destKey, byte[]... srcKeys);
}
