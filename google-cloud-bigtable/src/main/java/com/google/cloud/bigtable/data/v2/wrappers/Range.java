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
 * <p>This base class represents the API for all ranges in the Cloud Bigtable client. Please note
 * this mutable type. It's intended to support fluent DSLs.For example:
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
 *
 * // Ranges are mutable, so take care to clone them to get a new instance
 * ByteStringRange r1 = ByteStringRange.of("a", "z");
 * ByteStringRange r2 = r1.clone().endUnbounded();
 * }</pre>
 */
abstract class Range<T, R extends Range<T, R>> {
  public enum BoundType {
    OPEN,
    CLOSED,
    UNBOUNDED
  }

  private BoundType startBound;
  private T start;
  private BoundType endBound;
  private T end;

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
    return startClosed(startClosed).endOpen(endOpen);
  }

  /** Creates a new {@link Range} with an unbounded start and the current end. */
  public R startUnbounded() {
    this.start = null;
    this.startBound = BoundType.UNBOUNDED;
    return thisT();
  }

  /** Creates a new {@link Range} with the specified exclusive start and the current end. */
  public R startOpen(@Nonnull T start) {
    this.start = Preconditions.checkNotNull(start, "Start can't be null");
    this.startBound = BoundType.OPEN;
    return thisT();
  }

  /** Creates a new {@link Range} with the specified inclusive start and the current end. */
  public R startClosed(@Nonnull T start) {
    this.start = Preconditions.checkNotNull(start, "Start can't be null");
    this.startBound = BoundType.CLOSED;
    return thisT();
  }

  /** Creates a new {@link Range} with the current start and an unbounded end. */
  public R endUnbounded() {
    this.end = null;
    this.endBound = BoundType.UNBOUNDED;
    return thisT();
  }

  /** Creates a new {@link Range} with the specified exclusive end and the current start. */
  public R endOpen(@Nonnull T end) {
    this.end = Preconditions.checkNotNull(end, "End can't be null");
    this.endBound = BoundType.OPEN;
    return thisT();
  }

  /** Creates a new {@link Range} with the specified inclusive end and the current start. */
  public R endClosed(@Nonnull T end) {
    this.end = Preconditions.checkNotNull(end, "End can't be null");
    this.endBound = BoundType.CLOSED;
    return thisT();
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

  @SuppressWarnings("unchecked")
  private R thisT() {
    return (R) this;
  }

  /** Abstract specialization of a {@link Range} for timestamps. */
  abstract static class AbstractTimestampRange<R extends AbstractTimestampRange<R>>
      extends Range<Long, R> implements Cloneable {
    AbstractTimestampRange() {
      super();
    }

    AbstractTimestampRange(BoundType startBound, Long start, BoundType endBound, Long end) {
      super(startBound, start, endBound, end);
    }

    @SuppressWarnings("unchecked")
    @Override
    protected R clone() {
      try {
        return (R) super.clone();
      } catch (CloneNotSupportedException e) {
        throw new RuntimeException("should never happen", e);
      }
    }
  }

  /**
   * Abstract specialization of a {@link Range} for {@link ByteString}s. Allows for easy interop
   * with simple Strings.
   */
  abstract static class AbstractByteStringRange<R extends AbstractByteStringRange<R>>
      extends Range<ByteString, R> implements Cloneable {
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
      return of(wrap(startClosed), wrap(endOpen));
    }

    /** Creates a new {@link Range} with the specified exclusive start and the current end. */
    public R startOpen(String start) {
      return startOpen(wrap(start));
    }

    /** Creates a new {@link Range} with the specified inclusive start and the current end. */
    public R startClosed(String start) {
      return startClosed(wrap(start));
    }

    /** Creates a new {@link Range} with the specified exclusive end and the current start. */
    public R endOpen(String end) {
      return endOpen(wrap(end));
    }

    /** Creates a new {@link Range} with the specified inclusive end and the current start. */
    public R endClosed(String end) {
      return endClosed(wrap(end));
    }

    @SuppressWarnings("unchecked")
    @Override
    protected R clone() {
      try {
        return (R) super.clone();
      } catch (CloneNotSupportedException e) {
        throw new RuntimeException("should never happen", e);
      }
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
  }
}
