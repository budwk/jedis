package com.budwk.jedis.commands;

import com.budwk.jedis.Response;

public interface HyperLogLogPipelineBinaryCommands {

  Response<Long> pfadd(byte[] key, byte[]... elements);

  Response<String> pfmerge(byte[] destkey, byte[]... sourcekeys);

  Response<Long> pfcount(byte[] key);

  Response<Long> pfcount(byte[]... keys);

}
