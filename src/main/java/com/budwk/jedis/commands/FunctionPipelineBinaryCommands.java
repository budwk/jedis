package com.budwk.jedis.commands;

import com.budwk.jedis.Response;
import com.budwk.jedis.args.FlushMode;
import com.budwk.jedis.args.FunctionRestorePolicy;

import java.util.List;

public interface FunctionPipelineBinaryCommands {

  Response<Object> fcall(byte[] name, List<byte[]> keys, List<byte[]> args);

  Response<Object> fcallReadonly(byte[] name, List<byte[]> keys, List<byte[]> args);

  Response<String> functionDelete(byte[] libraryName);

  Response<byte[]> functionDump();

  Response<String> functionFlush();

  Response<String> functionFlush(FlushMode mode);

  Response<String> functionKill();

  Response<List<Object>> functionListBinary();

  Response<List<Object>> functionList(byte[] libraryNamePattern);

  Response<List<Object>> functionListWithCodeBinary();

  Response<List<Object>> functionListWithCode(byte[] libraryNamePattern);

  Response<String> functionLoad(byte[] functionCode);

  Response<String> functionLoadReplace(byte[] functionCode);

  Response<String> functionRestore(byte[] serializedValue);

  Response<String> functionRestore(byte[] serializedValue, FunctionRestorePolicy policy);

  Response<Object> functionStatsBinary();
}
