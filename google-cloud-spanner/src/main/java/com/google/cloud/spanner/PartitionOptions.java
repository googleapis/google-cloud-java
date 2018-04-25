/*
 * Copyright 2017 Google LLC
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

package com.google.cloud.spanner;

import com.google.common.base.Preconditions;

import java.io.Serializable;
import java.util.Objects;

/**
 * Defines the configuration for the number and size of partitions returned from
 * {@link BatchReadOnlyTransaction#partitionRead},
 * {@link BatchReadOnlyTransaction#partitionReadUsingIndex} and
 * {@link BatchReadOnlyTransaction#partitionQuery}
 *
 * <p>Note: these options may not be honored based on the other parameters in the request.
 */
public class PartitionOptions implements Serializable {

  private static final long serialVersionUID = 8067099123096783931L;

  private final long partitionSizeBytes;
  private final long maxPartitions;

  private PartitionOptions(Builder builder) {
    partitionSizeBytes = builder.partitionSizeBytes;
    maxPartitions = builder.maxPartitions;
  }

  /** Builder for {@code PartitionOptions} instance. */
  public static class Builder {

    private long partitionSizeBytes;
    private long maxPartitions;

    private Builder() {}

    /**
     * The desired data size for each partition generated. This is only a hint. The actual size of
     * each partition may be smaller or larger than this size request.
     *
     * @param partitionSizeBytes configuration for size of the partitions returned
     */
    public Builder setPartitionSizeBytes(long partitionSizeBytes) {
      Preconditions.checkArgument(partitionSizeBytes > 0,
          "Invalid partitionSizeBytes: " + partitionSizeBytes);
      this.partitionSizeBytes = partitionSizeBytes;
      return this;
    }

    /*
     * The desired maximum number of partitions to return. For example, this may be set to the
     * number of workers available. This is only a hint and may provide differene results based on
     * the request.
     *
     * @param maxPartitions configuration for count of the partitions returned
     */
    public Builder setMaxPartitions(long maxPartitions) {
      Preconditions.checkArgument(maxPartitions > 0,
          "Invalid maxPartitions: " + maxPartitions);
      this.maxPartitions = maxPartitions;
      return this;
    }

    public PartitionOptions build() {
      return new PartitionOptions(this);
    }
  }

  public static PartitionOptions getDefaultInstance() {
    return newBuilder().build();
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  /** Returns the size of the partition in bytes. */
  public long getPartitionSizeBytes() {
    return partitionSizeBytes;
  }

  /** Returns the maximum number of partitions to be created. */
  public long getMaxPartitions() {
    return maxPartitions;
  }

  void appendToProto(com.google.spanner.v1.PartitionOptions.Builder proto) {
    if (partitionSizeBytes > 0) {
      proto.setPartitionSizeBytes(partitionSizeBytes);
    }
    if (maxPartitions > 0) {
      proto.setMaxPartitions(maxPartitions);
    }
  }

  @Override
  public String toString() {
    return String.format(
        "partitionSizeBytes: %s, maxPartitions: %s", getPartitionSizeBytes(), getMaxPartitions());
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    PartitionOptions that = (PartitionOptions) o;
    return Objects.equals(getMaxPartitions(), that.getMaxPartitions())
        && Objects.equals(getPartitionSizeBytes(), that.getPartitionSizeBytes());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getMaxPartitions(), getPartitionSizeBytes());
  }
}
