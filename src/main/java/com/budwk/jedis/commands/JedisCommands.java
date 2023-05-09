package com.budwk.jedis.commands;

public interface JedisCommands extends KeyCommands, StringCommands, ListCommands, HashCommands,
    SetCommands, SortedSetCommands, GeoCommands, HyperLogLogCommands, StreamCommands,
    ScriptingKeyCommands, FunctionCommands {
}
