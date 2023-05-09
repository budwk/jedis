package com.budwk.jedis.commands;

import java.util.List;
import com.budwk.jedis.args.FlushMode;

public interface ScriptingControlCommands {

  Boolean scriptExists(String sha1);

  List<Boolean> scriptExists(String... sha1);

  Boolean scriptExists(byte[] sha1);

  List<Boolean> scriptExists(byte[]... sha1);

  String scriptLoad(String script);

  byte[] scriptLoad(byte[] script);

  String scriptFlush();

  String scriptFlush(FlushMode flushMode);

  String scriptKill();

}
