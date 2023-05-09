package com.budwk.jedis.bloom.commands;

public interface RedisBloomCommands extends BloomFilterCommands, CuckooFilterCommands,
    CountMinSketchCommands, TopKFilterCommands, TDigestSketchCommands {

}
