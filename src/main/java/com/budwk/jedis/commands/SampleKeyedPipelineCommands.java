package com.budwk.jedis.commands;

import java.util.List;
import com.budwk.jedis.Response;
import com.budwk.jedis.args.FlushMode;
import com.budwk.jedis.util.KeyValue;

public interface SampleKeyedPipelineCommands {

  Response<Long> waitReplicas(String sampleKey, int replicas, long timeout);

  Response<KeyValue<Long, Long>> waitAOF(String sampleKey, long numLocal, long numReplicas, long timeout);

  Response<Object> eval(String script, String sampleKey);

  Response<Object> evalsha(String sha1, String sampleKey);
//
//  Response<Boolean> scriptExists(String sha1, String sampleKey);

  Response<List<Boolean>> scriptExists(String sampleKey, String... sha1);

  Response<String> scriptLoad(String script, String sampleKey);

  Response<String> scriptFlush(String sampleKey);

  Response<String> scriptFlush(String sampleKey, FlushMode flushMode);

  Response<String> scriptKill(String sampleKey);
}
