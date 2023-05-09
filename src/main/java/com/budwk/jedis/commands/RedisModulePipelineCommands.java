package com.budwk.jedis.commands;

import com.budwk.jedis.timeseries.RedisTimeSeriesPipelineCommands;
import com.budwk.jedis.bloom.commands.RedisBloomPipelineCommands;
import com.budwk.jedis.graph.RedisGraphPipelineCommands;
import com.budwk.jedis.json.RedisJsonPipelineCommands;
import com.budwk.jedis.search.RediSearchPipelineCommands;

public interface RedisModulePipelineCommands extends
    RediSearchPipelineCommands,
    RedisJsonPipelineCommands,
        RedisTimeSeriesPipelineCommands,
    RedisBloomPipelineCommands,
    RedisGraphPipelineCommands {

}
