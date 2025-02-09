package com.budwk.jedis.commands;

import java.util.List;
import com.budwk.jedis.args.FlushMode;
import com.budwk.jedis.util.KeyValue;

public interface SampleKeyedCommands {

  long waitReplicas(String sampleKey, int replicas, long timeout);

  KeyValue<Long, Long> waitAOF(String sampleKey, long numLocal, long numReplicas, long timeout);

  Object eval(String script, String sampleKey);

  Object evalsha(String sha1, String sampleKey);

  Boolean scriptExists(String sha1, String sampleKey);

  List<Boolean> scriptExists(String sampleKey, String... sha1s);

  String scriptLoad(String script, String sampleKey);

  String scriptFlush(String sampleKey);

  String scriptFlush(String sampleKey, FlushMode flushMode);

  String scriptKill(String sampleKey);
}
