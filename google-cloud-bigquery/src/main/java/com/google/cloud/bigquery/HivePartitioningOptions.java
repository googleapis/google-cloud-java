/*
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.bigquery;

import com.google.common.base.MoreObjects;
import java.util.Objects;

/** HivePartitioningOptions currently supported types include: AVRO, CSV, JSON, ORC and Parquet. */
public final class HivePartitioningOptions {

  private final String mode;
  private final String sourceUriPrefix;

  public static final class Builder {

    private String mode;
    private String sourceUriPrefix;

    private Builder() {}

    private Builder(HivePartitioningOptions options) {
      this.mode = options.mode;
      this.sourceUriPrefix = options.sourceUriPrefix;
    }

    /**
     * [Optional] When set, what mode of hive partitioning to use when reading data. Two modes are
     * supported. (1) AUTO: automatically infer partition key name(s) and type(s). (2) STRINGS:
     * automatically infer partition key name(s). All types are interpreted as strings. Not all
     * storage formats support hive partitioning. Requesting hive partitioning on an unsupported
     * format will lead to an error. Currently supported types include: AVRO, CSV, JSON, ORC and
     * Parquet.
     */
    public Builder setMode(String mode) {
      this.mode = mode;
      return this;
    }

    /**
     * [Optional] When hive partition detection is requested, a common prefix for all source uris
     * should be supplied. The prefix must end immediately before the partition key encoding begins.
     * For example, consider files following this data layout.
     * gs://bucket/path_to_table/dt=2019-01-01/country=BR/id=7/file.avro
     * gs://bucket/path_to_table/dt=2018-12-31/country=CA/id=3/file.avro When hive partitioning is
     * requested with either AUTO or STRINGS detection, the common prefix can be either of
     * gs://bucket/path_to_table or gs://bucket/path_to_table/ (trailing slash does not matter).
     */
    public Builder setSourceUriPrefix(String sourceUriPrefix) {
      this.sourceUriPrefix = sourceUriPrefix;
      return this;
    }

    /** Creates a {@link HivePartitioningOptions} object. */
    public HivePartitioningOptions build() {
      return new HivePartitioningOptions(this);
    }
  }

  private HivePartitioningOptions(Builder builder) {
    this.mode = builder.mode;
    this.sourceUriPrefix = builder.sourceUriPrefix;
  }

  /* Returns the mode of hive partitioning */
  public String getMode() {
    return mode;
  }

  /* Returns the sourceUriPrefix of hive partitioning */
  public String getSourceUriPrefix() {
    return sourceUriPrefix;
  }

  /** Returns a builder for the {@link HivePartitioningOptions} object. */
  public Builder toBuilder() {
    return new Builder(this);
  }

  /** Returns a builder for the {@link HivePartitioningOptions} object. */
  public static Builder newBuilder() {
    return new Builder();
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("mode", mode)
        .add("sourceUriPrefix", sourceUriPrefix)
        .toString();
  }

  @Override
  public boolean equals(Object obj) {
    return obj == this
        || obj != null
            && obj.getClass().equals(HivePartitioningOptions.class)
            && Objects.equals(mode, ((HivePartitioningOptions) obj).getMode())
            && Objects.equals(
                sourceUriPrefix, ((HivePartitioningOptions) obj).getSourceUriPrefix());
  }

  @Override
  public int hashCode() {
    return Objects.hash(mode, sourceUriPrefix);
  }

  com.google.api.services.bigquery.model.HivePartitioningOptions toPb() {
    com.google.api.services.bigquery.model.HivePartitioningOptions options =
        new com.google.api.services.bigquery.model.HivePartitioningOptions();
    options.setMode(mode);
    options.setSourceUriPrefix(sourceUriPrefix);
    return options;
  }

  static HivePartitioningOptions fromPb(
      com.google.api.services.bigquery.model.HivePartitioningOptions options) {
    Builder builder = newBuilder();
    if (options.getMode() != null) {
      builder.setMode(options.getMode());
    }
    if (options.getSourceUriPrefix() != null) {
      builder.setSourceUriPrefix(options.getSourceUriPrefix());
    }
    return builder.build();
  }
}
