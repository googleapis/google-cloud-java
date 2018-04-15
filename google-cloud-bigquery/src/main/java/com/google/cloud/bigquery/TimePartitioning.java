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

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.api.core.BetaApi;
import com.google.common.base.MoreObjects;

import java.io.Serializable;
import java.util.Objects;

/**
 * Objects of this class allow to configure table partitioning based on time. By dividing a large
 * table into smaller partitions, you can improve query performance and reduce the number of bytes
 * billed by restricting the amount of data scanned.
 *
 * @see <a href="https://cloud.google.com/bigquery/docs/partitioned-tables">Partitioned Tables</a>
 */
public final class TimePartitioning implements Serializable {

  private static final long serialVersionUID = -8565064035346940951L;

  private final Type type;
  private final Long expirationMs;
  private final Boolean requirePartitionFilter;
  private final String field;

  /**
   * The type of time partitioning. Currently, the only type supported is {@code DAY}, which will
   * generate one partition per day based on data loading time.
   */
  public enum Type {

    /**
     * Table is partitioned per day, based on data loading time.
     */
    DAY
  }

  /**
   * A builder for {@code TimePartitioning} objects.
   */
  public abstract static class Builder {
    abstract Builder setType(Type type);

    /**
     * Sets the number of milliseconds for which to keep the storage for a partition. When expired,
     * the storage for the partition is reclaimed.
     */
    public abstract Builder setExpirationMs(long expirationMs);

    /**
     * Sets whether queries over this table require a partition where clause.
     */
    @BetaApi
    public abstract Builder setRequirePartitionFilter(boolean requirePartitionFilter);

    /**
     * Sets the field to partition the table by. If not set, the table is partitioned by pseudo
     * column '_PARTITIONTIME'.
     */
    @BetaApi
    public abstract Builder setField(String field);

    public abstract TimePartitioning build();
  }

  static class BuilderImpl extends Builder {

    private Type type;
    private Long expirationMs;
    private Boolean requirePartitionFilter;
    private String field;

    BuilderImpl() {}

    BuilderImpl(TimePartitioning tp) {
      this.type = tp.getType();
      this.expirationMs = tp.getExpirationMs();
      this.requirePartitionFilter = tp.getRequirePartitionFilter();
      this.field = tp.getField();
    }

    BuilderImpl(com.google.api.services.bigquery.model.TimePartitioning tp) {
      this.type = Type.valueOf(tp.getType());
      this.expirationMs = tp.getExpirationMs();
      this.requirePartitionFilter = tp.getRequirePartitionFilter();
      this.field = tp.getField();
    }

    @Override
    Builder setType(Type type) {
      this.type = type;
      return this;
    }

    @Override
    public Builder setExpirationMs(long expirationMs) {
      this.expirationMs = expirationMs;
      return this;
    }

    @Override
    public Builder setRequirePartitionFilter(boolean requirePartitionFilter) {
      this.requirePartitionFilter = requirePartitionFilter;
      return this;
    }

    @Override
    public Builder setField(String field) {
      this.field = field;
      return this;
    }

    @Override
    public TimePartitioning build() {
      return new TimePartitioning(this);
    }
  }

  private TimePartitioning(BuilderImpl builder) {
    this.type = checkNotNull(builder.type);
    this.expirationMs = builder.expirationMs;
    this.requirePartitionFilter = builder.requirePartitionFilter;
    this.field = builder.field;
  }


  /**
   * Returns the time partitioning type. Currently, the only type supported is {@link Type#DAY},
   * which will generate one partition per day based on data loading time.
   */
  public Type getType() {
    return type;
  }


  /**
   * Returns the number of milliseconds for which to keep the storage for a partition. When expired,
   * the storage for the partition is reclaimed.
   */
  public Long getExpirationMs() {
    return expirationMs;
  }


  /**
   * If not set, the table is partitioned by pseudo column '_PARTITIONTIME'; if set, the table is
   * partitioned by this field.
   */
  public String getField() {
    return field;
  }


  /**
   * If set to true, queries over this table require a partition filter (that can be used for
   * partition elimination) to be specified.
   */
  public Boolean getRequirePartitionFilter() {
    return requirePartitionFilter;
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("type", type)
        .add("expirationMs", expirationMs)
        .add("requirePartitionFilter", requirePartitionFilter)
        .add("field", field)
        .toString();
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, expirationMs, requirePartitionFilter, field);
  }

  @Override
  public boolean equals(Object obj) {
    return obj == this
        || obj instanceof TimePartitioning
        && Objects.equals(toPb(), ((TimePartitioning) obj).toPb());
  }

  /**
   * Returns a {@code TimePartitioning} object given the time partitioning type. Currently, the only
   * type supported is {@link Type#DAY}, which will generate one partition per day based on data
   * loading time.
   */
  public static Builder newBuilder(Type type) {
    return new BuilderImpl().setType(type);
  }

  /**
   * Returns a {@code TimePartitioning} object given the time partitioning type. Currently, the only
   * type supported is {@link Type#DAY}, which will generate one partition per day based on data
   * loading time.
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
    partitioningPb.setType(type.name());
    partitioningPb.setExpirationMs(expirationMs);
    partitioningPb.setRequirePartitionFilter(requirePartitionFilter);
    partitioningPb.setField(field);
    return partitioningPb;
  }

  static TimePartitioning fromPb(
      com.google.api.services.bigquery.model.TimePartitioning partitioningPb) {
    return new BuilderImpl(partitioningPb).build();
  }
}
