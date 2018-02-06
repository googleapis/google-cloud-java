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

/**
 * Range API.
 *
 * <p>This base class represents the API for all ranges in the Cloud Bigtable client.
 */
abstract class Range<T, R extends Range<T, R>> {
  public enum BoundType {
    OPEN,
    CLOSED,
    UNBOUNDED
  }

  protected final BoundType startBound;
  protected final T start;
  protected final BoundType endBound;
  protected final T end;

  protected Range() {
    this(BoundType.UNBOUNDED, null, BoundType.UNBOUNDED, null);
  }

  protected Range(BoundType startBound, T start, BoundType endBound, T end) {
    this.start = start;
    this.startBound = startBound;
    this.end = end;
    this.endBound = endBound;
  }

  /**
   * Creates a new {@link Range} with the specified inclusive start and the spcified exclusive end.
   */
  public R of(T startClosed, T endOpen) {
    return newInstance(BoundType.CLOSED, startClosed, BoundType.OPEN, endOpen);
  }

  /** Creates a new {@link Range} with the specified exclusive start and the current end. */
  public R startOpen(T start) {
    return newInstance(BoundType.OPEN, start, endBound, end);
  }

  /** Creates a new {@link Range} with the specified inclusive start and the current end. */
  public R startClosed(T start) {
    return newInstance(BoundType.CLOSED, start, endBound, end);
  }

  /** Creates a new {@link Range} with the specified exclusive end and the current start. */
  public R endOpen(T end) {
    return newInstance(startBound, start, BoundType.OPEN, end);
  }

  /** Creates a new {@link Range} with the specified inclusive end and the current start. */
  public R endClosed(T end) {
    return newInstance(startBound, start, BoundType.CLOSED, end);
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

  /**
   * Extension point for subclasses to override. This allows subclasses to maintain chainability.
   */
  protected abstract R newInstance(BoundType startBound, T start, BoundType endBound, T end);

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
     * Creates a new {@link Range} with the specified inclusive start and the spcified exclusive
     * end.
     */
    public R of(String startClosed, String endOpen) {
      return newInstance(BoundType.CLOSED, wrap(startClosed), BoundType.OPEN, wrap(endOpen));
    }

    /** Creates a new {@link Range} with the specified exclusive start and the current end. */
    public R startOpen(String start) {
      return newInstance(BoundType.OPEN, wrap(start), endBound, end);
    }

    /** Creates a new {@link Range} with the specified inclusive start and the current end. */
    public R startClosed(String start) {
      return newInstance(BoundType.CLOSED, wrap(start), endBound, end);
    }

    /** Creates a new {@link Range} with the specified exclusive end and the current start. */
    public R endOpen(String end) {
      return newInstance(getStartBound(), start, BoundType.OPEN, wrap(end));
    }

    /** Creates a new {@link Range} with the specified inclusive end and the current start. */
    public R endClosed(String end) {
      return newInstance(startBound, start, BoundType.CLOSED, wrap(end));
    }

    static ByteString wrap(String str) {
      return ByteString.copyFromUtf8(str);
    }
  }

  /** Concrete Range for timestamps */
  public static class TimestampRange extends AbstractTimestampRange<TimestampRange> {
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
    protected TimestampRange newInstance(
        BoundType startBound, Long start, BoundType endBound, Long end) {
      return new TimestampRange(startBound, start, endBound, end);
    }
  }

  /** Concrete Range for ByteStrings */
  public static class ByteStringRange extends AbstractByteStringRange<ByteStringRange> {
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
    protected ByteStringRange newInstance(
        BoundType startBound, ByteString start, BoundType endBound, ByteString end) {
      return new ByteStringRange(startBound, start, endBound, end);
    }
  }
}
