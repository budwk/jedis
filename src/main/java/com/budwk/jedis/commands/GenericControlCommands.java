package com.budwk.jedis.commands;

import java.util.List;
import com.budwk.jedis.Module;
import com.budwk.jedis.params.FailoverParams;

public interface GenericControlCommands extends ConfigCommands, ScriptingControlCommands, SlowlogCommands {

  String failover();

  String failover(FailoverParams failoverParams);

  String failoverAbort();

  List<Module> moduleList();
}
