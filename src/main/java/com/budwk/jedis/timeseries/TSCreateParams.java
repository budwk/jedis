package com.budwk.jedis.timeseries;

import static com.budwk.jedis.Protocol.toByteArray;

import java.util.LinkedHashMap;
import java.util.Map;
import com.budwk.jedis.CommandArguments;
import com.budwk.jedis.params.IParams;

/**
 * Represents optional arguments of TS.CREATE command.
 */
public class TSCreateParams implements IParams {

  private Long retentionPeriod;
  private boolean uncompressed;
  private boolean compressed;
  private Long chunkSize;
  private DuplicatePolicy duplicatePolicy;
  private Map<String, String> labels;

  public TSCreateParams() {
  }

  public static TSCreateParams createParams() {
    return new TSCreateParams();
  }

  public TSCreateParams retention(long retentionPeriod) {
    this.retentionPeriod = retentionPeriod;
    return this;
  }

  public TSCreateParams uncompressed() {
    this.uncompressed = true;
    return this;
  }

  public TSCreateParams compressed() {
    this.compressed = true;
    return this;
  }

  public TSCreateParams chunkSize(long chunkSize) {
    this.chunkSize = chunkSize;
    return this;
  }

  public TSCreateParams duplicatePolicy(DuplicatePolicy duplicatePolicy) {
    this.duplicatePolicy = duplicatePolicy;
    return this;
  }

  /**
   * Set label-value pairs
   *
   * @param labels label-value pairs
   * @return the object itself
   */
  public TSCreateParams labels(Map<String, String> labels) {
    this.labels = labels;
    return this;
  }

  /**
   * Add label-value pair. Multiple pairs can be added through chaining.
   */
  public TSCreateParams label(String label, String value) {
    if (this.labels == null) {
      this.labels = new LinkedHashMap<>();
    }
    this.labels.put(label, value);
    return this;
  }

  @Override
  public void addParams(CommandArguments args) {

    if (retentionPeriod != null) {
      args.add(TimeSeriesProtocol.TimeSeriesKeyword.RETENTION).add(toByteArray(retentionPeriod));
    }

    if (uncompressed) {
      args.add(TimeSeriesProtocol.TimeSeriesKeyword.ENCODING).add(TimeSeriesProtocol.TimeSeriesKeyword.UNCOMPRESSED);
    } else if (compressed) {
      args.add(TimeSeriesProtocol.TimeSeriesKeyword.ENCODING).add(TimeSeriesProtocol.TimeSeriesKeyword.COMPRESSED);
    }

    if (chunkSize != null) {
      args.add(TimeSeriesProtocol.TimeSeriesKeyword.CHUNK_SIZE).add(toByteArray(chunkSize));
    }

    if (duplicatePolicy != null) {
      args.add(TimeSeriesProtocol.TimeSeriesKeyword.DUPLICATE_POLICY).add(duplicatePolicy);
    }

    if (labels != null) {
      args.add(TimeSeriesProtocol.TimeSeriesKeyword.LABELS);
      labels.entrySet().forEach((entry) -> args.add(entry.getKey()).add(entry.getValue()));
    }
  }
}
