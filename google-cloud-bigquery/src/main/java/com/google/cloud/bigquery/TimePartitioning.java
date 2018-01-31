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

  private TimePartitioning(Type type, Long expirationMs) {
    this.type = checkNotNull(type);
    this.expirationMs = expirationMs;
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

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("type", type)
        .add("expirationMs", expirationMs)
        .toString();
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, expirationMs);
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
  public static TimePartitioning of(Type type) {
    return new TimePartitioning(type, null);
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
    return new TimePartitioning(type, expirationMs);
  }

  com.google.api.services.bigquery.model.TimePartitioning toPb() {
    com.google.api.services.bigquery.model.TimePartitioning partitioningPb =
        new com.google.api.services.bigquery.model.TimePartitioning();
    partitioningPb.setType(type.name());
    partitioningPb.setExpirationMs(expirationMs);
    return partitioningPb;
  }

  static TimePartitioning fromPb(
      com.google.api.services.bigquery.model.TimePartitioning partitioningPb) {
    return new TimePartitioning(
        Type.valueOf(partitioningPb.getType()), partitioningPb.getExpirationMs());
  }
}
