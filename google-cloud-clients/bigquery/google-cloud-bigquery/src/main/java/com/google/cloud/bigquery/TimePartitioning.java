/*
 * Copyright 2016 Google LLC
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

import static com.google.common.base.MoreObjects.firstNonNull;

import com.google.api.client.util.Data;
import com.google.api.core.BetaApi;
import com.google.auto.value.AutoValue;
import java.io.Serializable;
import javax.annotation.Nullable;

/**
 * Objects of this class allow to configure table partitioning based on time. By dividing a large
 * table into smaller partitions, you can improve query performance and reduce the number of bytes
 * billed by restricting the amount of data scanned.
 *
 * @see <a href="https://cloud.google.com/bigquery/docs/partitioned-tables">Partitioned Tables</a>
 */
@AutoValue
public abstract class TimePartitioning implements Serializable {

  private static final long serialVersionUID = -8565064035346940951L;

  /**
   * The type of time partitioning. Currently, the only type supported is {@code DAY}, which will
   * generate one partition per day based on data loading time.
   */
  public enum Type {

    /** Table is partitioned per day, based on data loading time. */
    DAY
  }

  TimePartitioning() {
    // Users cannot extend this, but AutoValue can.
  }

  /**
   * Returns the time partitioning type. Currently, the only type supported is {@link Type#DAY},
   * which will generate one partition per day based on data loading time.
   */
  public abstract Type getType();

  /**
   * Returns the number of milliseconds for which to keep the storage for a partition. When expired,
   * the storage for the partition is reclaimed. If null, the partion does not expire.
   */
  @Nullable
  public abstract Long getExpirationMs();

  /**
   * If not set, the table is partitioned by pseudo column '_PARTITIONTIME'; if set, the table is
   * partitioned by this field.
   */
  @BetaApi
  @Nullable
  public abstract String getField();

  /**
   * If set to true, queries over this table require a partition filter (that can be used for
   * partition elimination) to be specified.
   */
  @BetaApi
  @Nullable
  public abstract Boolean getRequirePartitionFilter();

  public abstract Builder toBuilder();

  @AutoValue.Builder
  public abstract static class Builder {
    abstract Builder setType(Type type);

    public abstract Builder setExpirationMs(Long expirationMs);

    @BetaApi
    public abstract Builder setRequirePartitionFilter(Boolean requirePartitionFilter);

    @BetaApi
    public abstract Builder setField(String field);

    public abstract TimePartitioning build();
  }

  /**
   * Returns a {@code TimePartitioning} object given the time partitioning type. Currently, the only
   * type supported is {@link Type#DAY}, which will generate one partition per day based on data
   * loading time.
   */
  public static Builder newBuilder(Type type) {
    return new AutoValue_TimePartitioning.Builder().setType(type);
  }

  /**
   * Returns a {@code TimePartitioning} object given the time partitioning type. Currently, the only
   * type supported is {@link Type#DAY}, which will generate one partition per day based on data
   * loading time. The partitions will not expire.
   */
  public static TimePartitioning of(Type type) {
    return newBuilder(type).build();
  }

  /**
   * Returns a {@code TimePartitioning} object given the time partitioning type and the partition's
   * expiration in milliseconds.
   *
   * @param type the time partitioning type. Currently, the only type supported is {@link Type#DAY},
   *     which will generate one partition per day based on data loading time.
   * @param expirationMs the number of milliseconds for which to keep the storage for a partition
   */
  public static TimePartitioning of(Type type, long expirationMs) {
    return newBuilder(type).setExpirationMs(expirationMs).build();
  }

  com.google.api.services.bigquery.model.TimePartitioning toPb() {
    com.google.api.services.bigquery.model.TimePartitioning partitioningPb =
        new com.google.api.services.bigquery.model.TimePartitioning();
    partitioningPb.setType(getType().name());
    partitioningPb.setExpirationMs(firstNonNull(getExpirationMs(), Data.NULL_LONG));
    partitioningPb.setRequirePartitionFilter(getRequirePartitionFilter());
    partitioningPb.setField(getField());
    return partitioningPb;
  }

  static TimePartitioning fromPb(
      com.google.api.services.bigquery.model.TimePartitioning partitioningPb) {
    Long expirationMs = partitioningPb.getExpirationMs();
    if (Data.isNull(expirationMs)) {
      expirationMs = null;
    }
    return newBuilder(Type.valueOf(partitioningPb.getType()))
        .setExpirationMs(expirationMs)
        .setField(partitioningPb.getField())
        .setRequirePartitionFilter(partitioningPb.getRequirePartitionFilter())
        .build();
  }
}
