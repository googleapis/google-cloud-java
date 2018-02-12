/*
 * Copyright 2018 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.bigtable.data.v2.wrappers;

import com.google.common.base.Preconditions;
import com.google.protobuf.ByteString;
import javax.annotation.Nonnull;

/**
 * Range API.
 *
 * <p>This base class represents the API for all ranges in the Cloud Bigtable client. It is an
 * immutable class, so all of its modification methods return ne instances. It's intended to support
 * fluent DSLs. For example:
 *
 * <pre>{@code
 * // A Range that encloses all strings
 * ByteStringRange.unbounded();
 *
 * // Range that includes all strings including "begin" up until "end"
 * ByteStringRange.unbounded().of("start", "end");
 *
 * // Create a Bytestring range with an unbounded start and the inclusive end "end"
 * ByteStringRange.unbounded().endClosed("end");
 * }</pre>
 */
abstract class Range<T, R extends Range<T, R>> {
  public enum BoundType {
    OPEN,
    CLOSED,
    UNBOUNDED
  }

  final BoundType startBound;
  final T start;
  final BoundType endBound;
  final T end;

  Range() {
    this(BoundType.UNBOUNDED, null, BoundType.UNBOUNDED, null);
  }

  Range(BoundType startBound, T start, BoundType endBound, T end) {
    this.startBound = startBound;
    this.start = start;
    this.endBound = endBound;
    this.end = end;
  }

  /**
   * Creates a new {@link Range} with the specified inclusive start and the specified exclusive end.
   */
  public R of(@Nonnull T startClosed, @Nonnull T endOpen) {
    return newInstanceSafe(BoundType.CLOSED, startClosed, BoundType.OPEN, endOpen);
  }

  /** Creates a new {@link Range} with an unbounded start and the current end. */
  public R startUnbounded() {
    return newInstanceSafe(BoundType.UNBOUNDED, null, endBound, end);
  }

  /** Creates a new {@link Range} with the specified exclusive start and the current end. */
  public R startOpen(@Nonnull T start) {
    return newInstanceSafe(BoundType.OPEN, start, endBound, end);
  }

  /** Creates a new {@link Range} with the specified inclusive start and the current end. */
  public R startClosed(@Nonnull T start) {
    return newInstanceSafe(BoundType.CLOSED, start, endBound, end);
  }

  /** Creates a new {@link Range} with the current start and an unbounded end. */
  public R endUnbounded() {
    return newInstanceSafe(startBound, start, BoundType.UNBOUNDED, null);
  }

  /** Creates a new {@link Range} with the specified exclusive end and the current start. */
  public R endOpen(@Nonnull T end) {
    return newInstanceSafe(startBound, start, BoundType.OPEN, end);
  }

  /** Creates a new {@link Range} with the specified inclusive end and the current start. */
  public R endClosed(@Nonnull T end) {
    return newInstanceSafe(startBound, start, BoundType.CLOSED, end);
  }

  /** Gets the current start {@link BoundType}. */
  public BoundType getStartBound() {
    return startBound;
  }

  /**
   * Gets the current start value.
   *
   * @throws IllegalStateException If the current {@link #getStartBound()} is {@link
   *     BoundType#UNBOUNDED}.
   */
  public T getStart() {
    Preconditions.checkState(startBound != BoundType.UNBOUNDED, "Start is unbounded");
    return start;
  }

  /** Gets the current end {@link BoundType}. */
  public BoundType getEndBound() {
    return endBound;
  }

  /**
   * Gets the current end value.
   *
   * @throws IllegalStateException If the current {@link #getEndBound()} is {@link
   *     BoundType#UNBOUNDED}.
   */
  public T getEnd() {
    Preconditions.checkState(endBound != BoundType.UNBOUNDED, "End is unbounded");
    return end;
  }

  R newInstanceSafe(BoundType startBound, T start, BoundType endBound, T end) {
    if (startBound != BoundType.UNBOUNDED) {
      Preconditions.checkNotNull(start, "Bounded start can't be null.");
    }
    if (endBound != BoundType.UNBOUNDED) {
      Preconditions.checkNotNull(end, "Bounded end can't be null");
    }
    return newInstance(startBound, start, endBound, end);
  }
  /**
   * Extension point for subclasses to override. This allows subclasses to maintain chainability.
   */
  abstract R newInstance(BoundType startBound, T start, BoundType endBound, T end);

  /** Abstract specialization of a {@link Range} for timestamps. */
  abstract static class AbstractTimestampRange<R extends AbstractTimestampRange<R>>
      extends Range<Long, R> {
    AbstractTimestampRange() {
      super();
    }

    AbstractTimestampRange(BoundType startBound, Long start, BoundType endBound, Long end) {
      super(startBound, start, endBound, end);
    }
  }

  /**
   * Abstract specialization of a {@link Range} for {@link ByteString}s. Allows for easy interop
   * with simple Strings.
   */
  abstract static class AbstractByteStringRange<R extends AbstractByteStringRange<R>>
      extends Range<ByteString, R> {
    AbstractByteStringRange() {
      this(BoundType.UNBOUNDED, null, BoundType.UNBOUNDED, null);
    }

    AbstractByteStringRange(
        BoundType startBound, ByteString start, BoundType endBound, ByteString end) {
      super(startBound, start, endBound, end);
    }

    /**
     * Creates a new {@link Range} with the specified inclusive start and the specified exclusive
     * end.
     */
    public R of(String startClosed, String endOpen) {
      return newInstanceSafe(BoundType.CLOSED, wrap(startClosed), BoundType.OPEN, wrap(endOpen));
    }

    /** Creates a new {@link Range} with the specified exclusive start and the current end. */
    public R startOpen(String start) {
      return newInstanceSafe(BoundType.OPEN, wrap(start), endBound, end);
    }

    /** Creates a new {@link Range} with the specified inclusive start and the current end. */
    public R startClosed(String start) {
      return newInstanceSafe(BoundType.CLOSED, wrap(start), endBound, end);
    }

    /** Creates a new {@link Range} with the specified exclusive end and the current start. */
    public R endOpen(String end) {
      return newInstanceSafe(startBound, start, BoundType.OPEN, wrap(end));
    }

    /** Creates a new {@link Range} with the specified inclusive end and the current start. */
    public R endClosed(String end) {
      return newInstanceSafe(startBound, start, BoundType.CLOSED, wrap(end));
    }

    static ByteString wrap(String str) {
      return ByteString.copyFromUtf8(str);
    }
  }

  /** Concrete Range for timestamps */
  public static final class TimestampRange extends AbstractTimestampRange<TimestampRange> {
    public static TimestampRange unbounded() {
      return new TimestampRange(BoundType.UNBOUNDED, null, BoundType.UNBOUNDED, null);
    }

    public static TimestampRange create(long closedStart, long openEnd) {
      return new TimestampRange(BoundType.CLOSED, closedStart, BoundType.OPEN, openEnd);
    }

    private TimestampRange(BoundType startBound, Long start, BoundType endBound, Long end) {
      super(startBound, start, endBound, end);
    }

    @Override
    TimestampRange newInstance(BoundType startBound, Long start, BoundType endBound, Long end) {
      return new TimestampRange(startBound, start, endBound, end);
    }
  }

  /** Concrete Range for ByteStrings */
  public static final class ByteStringRange extends AbstractByteStringRange<ByteStringRange> {
    public static ByteStringRange unbounded() {
      return new ByteStringRange(BoundType.UNBOUNDED, null, BoundType.UNBOUNDED, null);
    }

    public static ByteStringRange create(ByteString closedStart, ByteString openEnd) {
      return new ByteStringRange(BoundType.CLOSED, closedStart, BoundType.OPEN, openEnd);
    }

    public static ByteStringRange create(String closedStart, String openEnd) {
      return new ByteStringRange(
          BoundType.CLOSED, wrap(closedStart), BoundType.OPEN, wrap(openEnd));
    }

    private ByteStringRange(
        BoundType startBound, ByteString start, BoundType endBound, ByteString end) {
      super(startBound, start, endBound, end);
    }

    @Override
    ByteStringRange newInstance(
        BoundType startBound, ByteString start, BoundType endBound, ByteString end) {
      return new ByteStringRange(startBound, start, endBound, end);
    }
  }
}
