/*
 * Copyright 2024 Google LLC
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

package com.google.cloud.storage;

import com.google.api.core.ApiClock;
import com.google.common.base.MoreObjects;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.function.LongUnaryOperator;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

/** "Test" {@link ApiClock} that allows control of time advancement and by how much. */
final class TestApiClock implements ApiClock {

  private static final long NANOS_PER_MILLI = TimeUnit.MILLISECONDS.toNanos(1);
  private final long beginNs;
  private final LongUnaryOperator tick;

  @Nullable private LongUnaryOperator next;
  private long prevNs;

  private TestApiClock(long beginNs, LongUnaryOperator tick) {
    this.beginNs = beginNs;
    this.tick = tick;
    this.prevNs = beginNs;
  }

  @Override
  public long nanoTime() {
    final long ret;
    if (next != null) {
      ret = next.applyAsLong(prevNs);
      next = null;
    } else {
      ret = tick.applyAsLong(prevNs);
    }
    prevNs = ret;
    return ret;
  }

  @Override
  public long millisTime() {
    return nanoTime() / NANOS_PER_MILLI;
  }

  public void advance(long nanos) {
    next = addExact(nanos);
  }

  public void advance(Duration d) {
    advance(d.toNanos());
  }

  public void advance(LongUnaryOperator op) {
    if (next == null) {
      next = op;
    } else {
      next = next.andThen(op);
    }
  }

  public void reset() {
    prevNs = beginNs;
    next = null;
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("beginNs", Duration.ofNanos(beginNs))
        .add("prevNs", Duration.ofNanos(prevNs))
        .add("tick", tick)
        .add("next", next)
        .toString();
  }

  public static TestApiClock tickBy(long begin, Duration d) {
    return of(begin, addExact(d));
  }

  public static TestApiClock of() {
    return of(0L, addExact(1L));
  }

  /**
   * @param tick Given the previous nanoseconds of the clock generate the new nanoseconds
   */
  public static TestApiClock of(long beginNs, LongUnaryOperator tick) {
    return new TestApiClock(beginNs, tick);
  }

  static LongUnaryOperator addExact(Duration amountToAdd) {
    return new AddExact(amountToAdd.toNanos());
  }

  static LongUnaryOperator addExact(long amountToAdd) {
    return new AddExact(amountToAdd);
  }

  private static final class AddExact implements LongUnaryOperator {
    private final long amountToAdd;

    private AddExact(long amountToAdd) {
      this.amountToAdd = amountToAdd;
    }

    @Override
    public long applyAsLong(long operand) {
      return Math.addExact(operand, amountToAdd);
    }

    @Override
    @NonNull
    public LongUnaryOperator andThen(@NonNull LongUnaryOperator after) {
      return new AndThen(after);
    }

    @Override
    public String toString() {
      return MoreObjects.toStringHelper(this)
          .add("amountToAdd", Duration.ofNanos(amountToAdd))
          .toString();
    }

    private final class AndThen implements LongUnaryOperator {
      private final LongUnaryOperator then;

      private AndThen(LongUnaryOperator then) {
        this.then = then;
      }

      @Override
      public long applyAsLong(long operand) {
        return then.applyAsLong(AddExact.this.applyAsLong(operand));
      }

      @Override
      public String toString() {
        return MoreObjects.toStringHelper(this)
            .add("before", AddExact.this)
            .add("then", then)
            .toString();
      }
    }
  }
}
