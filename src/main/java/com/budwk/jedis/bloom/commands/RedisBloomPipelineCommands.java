package com.budwk.jedis.bloom.commands;

public interface RedisBloomPipelineCommands extends BloomFilterPipelineCommands,
    CuckooFilterPipelineCommands, CountMinSketchPipelineCommands, TopKFilterPipelineCommands,
    TDigestSketchPipelineCommands {

}
