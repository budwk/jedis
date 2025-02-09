package com.budwk.jedis.commands;

import java.util.List;

import com.budwk.jedis.Response;
import com.budwk.jedis.args.ListDirection;
import com.budwk.jedis.args.ListPosition;
import com.budwk.jedis.params.LPosParams;
import com.budwk.jedis.util.KeyValue;

public interface ListPipelineBinaryCommands {

  Response<Long> rpush(byte[] key, byte[]... args);

  Response<Long> lpush(byte[] key, byte[]... args);

  Response<Long> llen(byte[] key);

  Response<List<byte[]>> lrange(byte[] key, long start, long stop);

  Response<String> ltrim(byte[] key, long start, long stop);

  Response<byte[]> lindex(byte[] key, long index);

  Response<String> lset(byte[] key, long index, byte[] value);

  Response<Long> lrem(byte[] key, long count, byte[] value);

  Response<byte[]> lpop(byte[] key);

  Response<List<byte[]>> lpop(byte[] key, int count);

  Response<Long> lpos(byte[] key, byte[] element);

  Response<Long> lpos(byte[] key, byte[] element, LPosParams params);

  Response<List<Long>> lpos(byte[] key, byte[] element, LPosParams params, long count);

  Response<byte[]> rpop(byte[] key);

  Response<List<byte[]>> rpop(byte[] key, int count);

  Response<Long> linsert(byte[] key, ListPosition where, byte[] pivot, byte[] value);

  Response<Long> lpushx(byte[] key, byte[]... args);

  Response<Long> rpushx(byte[] key, byte[]... args);

  Response<List<byte[]>> blpop(int timeout, byte[]... keys);

  Response<List<byte[]>> blpop(double timeout, byte[]... keys);

  Response<List<byte[]>> brpop(int timeout, byte[]... keys);

  Response<List<byte[]>> brpop(double timeout, byte[]... keys);

  Response<byte[]> rpoplpush(byte[] srckey, byte[] dstkey);

  Response<byte[]> brpoplpush(byte[] source, byte[] destination, int timeout);

  Response<byte[]> lmove(byte[] srcKey, byte[] dstKey, ListDirection from, ListDirection to);

  Response<byte[]> blmove(byte[] srcKey, byte[] dstKey, ListDirection from, ListDirection to, double timeout);

  Response<KeyValue<byte[], List<byte[]>>> lmpop(ListDirection direction, byte[]... keys);

  Response<KeyValue<byte[], List<byte[]>>> lmpop(ListDirection direction, int count, byte[]... keys);

  Response<KeyValue<byte[], List<byte[]>>> blmpop(long timeout, ListDirection direction, byte[]... keys);

  Response<KeyValue<byte[], List<byte[]>>> blmpop(long timeout, ListDirection direction, int count, byte[]... keys);
}
