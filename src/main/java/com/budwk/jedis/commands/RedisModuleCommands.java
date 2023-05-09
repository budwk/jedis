package com.budwk.jedis.commands;

import com.budwk.jedis.timeseries.RedisTimeSeriesCommands;
import com.budwk.jedis.bloom.commands.RedisBloomCommands;
import com.budwk.jedis.graph.RedisGraphCommands;
import com.budwk.jedis.json.RedisJsonCommands;
import com.budwk.jedis.search.RediSearchCommands;

public interface RedisModuleCommands extends
    RediSearchCommands,
    RedisJsonCommands,
        RedisTimeSeriesCommands,
    RedisBloomCommands,
    RedisGraphCommands {

}
