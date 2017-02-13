/*
 * Copyright 2017 Google Inc. All Rights Reserved.
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

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.base.Preconditions.checkState;

import com.google.protobuf.Duration;
import com.google.protobuf.util.Durations;
import com.google.spanner.v1.TransactionOptions;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * Defines how Cloud Spanner will choose a timestamp for a read-only transaction or a single
 * read/query.
 *
 * <p>The types of timestamp bound are:
 *
 * <ul>
 *   <li>Strong (the default).
 *   <li>Bounded staleness.
 *   <li>Exact staleness.
 * </ul>
 *
 * <p>If the Cloud Spanner database to be read is geographically distributed, stale read-only
 * transactions can execute more quickly than strong or read-write transactions, because they are
 * able to execute far from the leader replica.
 *
 * <p>Each type of timestamp bound is discussed in detail below.
 *
 * <h3>Strong reads</h3>
 *
 * <p>Strong reads are guaranteed to see the effects of all transactions that have committed before
 * the start of the read. Furthermore, all rows yielded by a single read are consistent with each
 * other - if any part of the read observes a transaction, all parts of the read see the
 * transaction.
 *
 * <p>Strong reads are not repeatable: two consecutive strong read-only transactions might return
 * inconsistent results if there are concurrent writes. If consistency across reads is required, the
 * reads should be executed within a transaction or at an exact read timestamp.
 *
 * <p>Use {@link #strong()} to create a bound of this type.
 *
 * <h3>Exact Staleness</h3>
 *
 * <p>These timestamp bounds execute reads at a user-specified timestamp. Reads at a timestamp are
 * guaranteed to see a consistent prefix of the global transaction history: they observe
 * modifications done by all transactions with a commit timestamp less than or equal to the read
 * timestamp, and observe none of the modifications done by transactions with a larger commit
 * timestamp. They will block until all conflicting transactions that may be assigned commit
 * timestamps less than or equal to the read timestamp have finished.
 *
 * <p>The timestamp can either be expressed as an absolute Cloud Spanner commit timestamp or a
 * staleness relative to the current time.
 *
 * <p>These modes do not require a "negotiation phase" to pick a timestamp. As a result, they
 * execute slightly faster than the equivalent boundedly stale concurrency modes. On the other hand,
 * boundedly stale reads usually return fresher results.
 *
 * <p>Use {@link #ofReadTimestamp(Timestamp)} and {@link #ofExactStaleness(long, TimeUnit)} to
 * create a bound of this type.
 *
 * <h3>Bounded Staleness</h3>
 *
 * <p>Bounded staleness modes allow Cloud Spanner to pick the read timestamp, subject to a
 * user-provided staleness bound. Cloud Spanner chooses the newest timestamp within the staleness
 * bound that allows execution of the reads at the closest available replica without blocking.
 *
 * <p>All rows yielded are consistent with each other -- if any part of the read observes a
 * transaction, all parts of the read see the transaction. Boundedly stale reads are not repeatable:
 * two stale reads, even if they use the same staleness bound, can execute at different timestamps
 * and thus return inconsistent results.
 *
 * <p>Boundedly stale reads execute in two phases: the first phase negotiates a timestamp among all
 * replicas needed to serve the read. In the second phase, reads are executed at the negotiated
 * timestamp.
 *
 * <p>As a result of the two phase execution, bounded staleness reads are usually a little slower
 * than comparable exact staleness reads. However, they are typically able to return fresher
 * results, and are more likely to execute at the closest replica.
 *
 * <p>Because the timestamp negotiation requires up-front knowledge of which rows will be read, it
 * can only be used with single-use reads and single-use read-only transactions.
 *
 * <p>Use {@link #ofMinReadTimestamp(Timestamp)} and {@link #ofMaxStaleness(long, TimeUnit)} to
 * create a bound of this type.
 *
 * <h3>Old Read Timestamps and Garbage Collection</h3>
 *
 * <p>Cloud Spanner continuously garbage collects deleted and overwritten data in the background to
 * reclaim storage space. This process is known as "version GC". By default, version GC reclaims
 * versions after they are four hours old. Because of this, Cloud Spanner cannot perform reads at
 * read timestamps more than four hours in the past. This restriction also applies to in-progress
 * reads and/or SQL queries whose timestamp become too old while executing. Reads and SQL queries
 * with too-old read timestamps fail with the error {@link ErrorCode#FAILED_PRECONDITION}.
 *
 * @see Session#singleUse(TimestampBound)
 * @see Session#singleUseReadOnlyTransaction(TimestampBound)
 * @see Session#readOnlyTransaction(TimestampBound)
 */
public final class TimestampBound {
  private static final TimestampBound STRONG_BOUND = new TimestampBound(Mode.STRONG, null, null);
  private static final TransactionOptions.ReadOnly STRONG_PROTO =
      TransactionOptions.ReadOnly.newBuilder().setStrong(true).build();

  private final Mode mode;
  private final Timestamp timestamp;
  private final Duration staleness;

  private TimestampBound(Mode mode, Timestamp timestamp, Duration staleness) {
    this.mode = mode;
    this.timestamp = timestamp;
    this.staleness = staleness;
  }

  /**
   * Returns a timestamp bound that will perform reads and queries at a timestamp where all
   * previously committed transactions are visible.
   */
  public static TimestampBound strong() {
    return STRONG_BOUND;
  }

  /**
   * Returns a timestamp bound that will perform reads and queries at the given timestamp. Unlike
   * other modes, reads at a specific timestamp are repeatable; the same read at the same timestamp
   * always returns the same data. If the timestamp is in the future, the read will block until the
   * specified timestamp, modulo the read's deadline.
   *
   * <p>This mode is useful for large scale consistent reads such as mapreduces, or for coordinating
   * many reads against a consistent snapshot of the data.
   */
  public static TimestampBound ofReadTimestamp(Timestamp timestamp) {
    return new TimestampBound(Mode.READ_TIMESTAMP, checkNotNull(timestamp), null);
  }

  /**
   * Returns a timestamp bound that will perform reads and queries at a timestamp chosen to be at
   * least {@code timestamp}. This is useful for requesting fresher data than some previous read, or
   * data that is fresh enough to observe the effects of some previously committed transaction whose
   * timestamp is known.
   *
   * <p>Note that this option can only be used in single-use reads and single-use read-only
   * transactions.
   */
  public static TimestampBound ofMinReadTimestamp(Timestamp timestamp) {
    return new TimestampBound(Mode.MIN_READ_TIMESTAMP, checkNotNull(timestamp), null);
  }

  /**
   * Returns a timestamp bound that will perform reads and queries at an exact staleness. The
   * timestamp is chosen soon after the read is started.
   *
   * <p>Guarantees that all writes that have committed more than the specified number of seconds ago
   * are visible. Because Cloud Spanner chooses the exact timestamp, this mode works even if the
   * client's local clock is substantially skewed from Cloud Spanner commit timestamps.
   *
   * <p>Useful for reading at nearby replicas without the distributed timestamp negotiation overhead
   * of {@link #ofMaxStaleness(long, TimeUnit)}.
   */
  public static TimestampBound ofExactStaleness(long num, TimeUnit units) {
    checkStaleness(num);
    return new TimestampBound(Mode.EXACT_STALENESS, null, createDuration(num, units));
  }

  /**
   * Returns a timestamp bound that will perform reads and queries at a timestamp chosen to be at
   * most {@code num units} stale. This guarantees that all writes that have committed more than the
   * specified number of seconds ago are visible. Because Cloud Spanner chooses the exact timestamp,
   * this mode works even if the client's local clock is substantially skewed from Cloud Spanner
   * commit timestamps.
   *
   * <p>Useful for reading the freshest data available at a nearby replica, while bounding the
   * possible staleness if the local replica has fallen behind.
   *
   * <p>Note that this option can only be used in single-use reads and single-use read-only
   * transactions.
   */
  public static TimestampBound ofMaxStaleness(long num, TimeUnit units) {
    checkStaleness(num);
    return new TimestampBound(Mode.MAX_STALENESS, null, createDuration(num, units));
  }

  /**
   * The type of timestamp bound. See the class documentation of {@link TimestampBound} for a
   * detailed discussion of the various modes.
   */
  public enum Mode {
    STRONG,
    READ_TIMESTAMP,
    MIN_READ_TIMESTAMP,
    EXACT_STALENESS,
    MAX_STALENESS,
  }

  public Mode getMode() {
    return mode;
  }

  /**
   * Returns the timestamp at which reads will be performed.
   *
   * @throws IllegalStateException if {@code mode() != Mode.EXACT_TIMESTAMP}
   * @see #ofReadTimestamp(Timestamp)
   */
  public Timestamp getReadTimestamp() {
    checkMode(Mode.READ_TIMESTAMP);
    return timestamp;
  }

  /**
   * Returns the minimum timestamp at which reads will be performed.
   *
   * @throws IllegalStateException if {@code mode() != Mode.MIN_READ_TIMESTAMP}
   * @see #ofMinReadTimestamp(Timestamp)
   */
  public Timestamp getMinReadTimestamp() {
    checkMode(Mode.MIN_READ_TIMESTAMP);
    return timestamp;
  }

  /**
   * Returns the exact staleness, in the units requested, at which reads will be performed.
   *
   * @throws IllegalStateException if {@code mode() != Mode.EXACT_STALENESS}
   * @see #ofExactStaleness(long, java.util.concurrent.TimeUnit)
   */
  public long getExactStaleness(TimeUnit units) {
    checkMode(Mode.EXACT_STALENESS);
    return durationToUnits(staleness, units);
  }

  /**
   * Returns the maximum staleness, in the units requested, at which reads will be performed.
   *
   * @throws IllegalStateException if {@code mode() != Mode.MAX_STALENESS}
   * @see #ofMaxStaleness(long, java.util.concurrent.TimeUnit)
   */
  public long getMaxStaleness(TimeUnit units) {
    checkMode(Mode.MAX_STALENESS);
    return durationToUnits(staleness, units);
  }

  StringBuilder toString(StringBuilder b) {
    // TODO(user): Convert all internal toString(StringBuilder) methods to return StringBuilder.
    switch (mode) {
      case STRONG:
        return b.append("strong");
      case READ_TIMESTAMP:
        return timestamp.toString(b.append("exact_timestamp: "));
      case MIN_READ_TIMESTAMP:
        return timestamp.toString(b.append("min_read_timestamp: "));
      case EXACT_STALENESS:
        return b.append("exact_staleness: ").append(Durations.toString(staleness));
      case MAX_STALENESS:
        return b.append("max_staleness: ").append(Durations.toString(staleness));
      default:
        throw new AssertionError("Unexpected mode: " + mode);
    }
  }

  @Override
  public String toString() {
    return toString(new StringBuilder()).toString();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TimestampBound that = (TimestampBound) o;
    return mode == that.mode
        && Objects.equals(staleness, that.staleness)
        && Objects.equals(timestamp, that.timestamp);
  }

  @Override
  public int hashCode() {
    return Objects.hash(mode, timestamp, staleness);
  }

  TransactionOptions.ReadOnly toProto() {
    // TODO(user): Use full proto as the internal representation if we eliminate Timestamp.
    if (mode == Mode.STRONG) {
      return STRONG_PROTO;
    }
    TransactionOptions.ReadOnly.Builder builder = TransactionOptions.ReadOnly.newBuilder();
    applyToBuilder(builder);
    return builder.build();
  }

  TransactionOptions.ReadOnly.Builder applyToBuilder(TransactionOptions.ReadOnly.Builder builder) {
    switch (mode) {
      case STRONG:
        return builder.setStrong(true);
      case READ_TIMESTAMP:
        return builder.setReadTimestamp(timestamp.toProto());
      case MIN_READ_TIMESTAMP:
        return builder.setMinReadTimestamp(timestamp.toProto());
      case EXACT_STALENESS:
        return builder.setExactStaleness(staleness);
      case MAX_STALENESS:
        return builder.setMaxStaleness(staleness);
      default:
        throw new AssertionError("Unexpected mode: " + mode);
    }
  }

  private static void checkStaleness(double num) {
    checkArgument(num >= 0, "Staleness cannot be negative");
  }

  private void checkMode(Mode requiredMode) {
    checkState(mode == requiredMode, "Invalid call for mode %s", mode);
  }

  private static Duration createDuration(long num, TimeUnit units) {
    switch (units) {
      case NANOSECONDS:
        return Durations.fromNanos(num);
      case MICROSECONDS:
        return Durations.fromMicros(num);
      default:
        return Durations.fromMillis(units.toMillis(num));
    }
  }

  private static long durationToUnits(Duration duration, TimeUnit units) {
    // TODO(user): Handle overflow.
    switch (units) {
      case NANOSECONDS:
        return Durations.toNanos(duration);
      case MICROSECONDS:
        return Durations.toMicros(duration);
      default:
        return units.convert(Durations.toMillis(duration), TimeUnit.MILLISECONDS);
    }
  }
}
