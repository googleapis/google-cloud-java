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

import com.google.cloud.ByteArray;
import javax.annotation.Nullable;

/**
 * An interface for binding a {@link Value} in some context. Users of the Cloud Spanner client
 * library never create a {@code ValueBinder} directly; instead this interface is returned from
 * other parts of the library involved in {@code Value} construction. For example, {@link
 * Mutation.WriteBuilder#set(String)} returns a binder to bind a column value, and {@code
 * Statement#bind(String)} returns a binder to bind a parameter to a value.
 *
 * <p>{@code ValueBinder} subclasses typically carry state and are therefore not thread-safe,
 * although the core implementation itself is thread-safe.
 */
public abstract class ValueBinder<R> {
  /**
   * Intentionally package-protected constructor; only the Cloud Spanner library can create
   * instances.
   */
  ValueBinder() {}

  /**
   * Subclasses should implement this method to handle value binding.
   *
   * <p>This method is intentionally package-protected rather than protected; the internal API is
   * subject to change.
   *
   * @param value the newly bound value
   * @return the object to return from the bind call ({@code to(...)}
   */
  abstract R handle(Value value);

  /** Binds to {@code Value.bool(value)} */
  public R to(boolean value) {
    return handle(Value.bool(value));
  }

  /** Binds to {@code Value.bool(value)} */
  public R to(@Nullable Boolean value) {
    return handle(Value.bool(value));
  }

  /** Binds to {@code Value.int64(value)} */
  public R to(long value) {
    return handle(Value.int64(value));
  }

  /** Binds to {@code Value.int64(value)} */
  public R to(@Nullable Long value) {
    return handle(Value.int64(value));
  }

  /** Binds to {@code Value.float64(value)} */
  public R to(double value) {
    return handle(Value.float64(value));
  }

  /** Binds to {@code Value.float64(value)} */
  public R to(@Nullable Double value) {
    return handle(Value.float64(value));
  }

  /** Binds to {@code Value.string(value)} */
  public R to(@Nullable String value) {
    return handle(Value.string(value));
  }

  /** Binds to {@code Value.bytes(value)} */
  public R to(@Nullable ByteArray value) {
    return handle(Value.bytes(value));
  }

  /** Binds to {@code Value.timestamp(value)} */
  public R to(@Nullable Timestamp value) {
    return handle(Value.timestamp(value));
  }

  /** Binds to {@code Value.date(value)} */
  public R to(@Nullable Date value) {
    return handle(Value.date(value));
  }

  /** Binds to {@code Value.boolArray(values)} */
  public R toBoolArray(@Nullable boolean[] values) {
    return handle(Value.boolArray(values));
  }

  /** Binds to {@code Value.boolArray(values, int, pos)} */
  public R toBoolArray(@Nullable boolean[] values, int pos, int length) {
    return handle(Value.boolArray(values, pos, length));
  }

  /** Binds to {@code Value.boolArray(values)} */
  public R toBoolArray(@Nullable Iterable<Boolean> values) {
    return handle(Value.boolArray(values));
  }

  /** Binds to {@code Value.int64Array(values)} */
  public R toInt64Array(@Nullable long[] values) {
    return handle(Value.int64Array(values));
  }

  /** Binds to {@code Value.int64Array(values, pos, length)} */
  public R toInt64Array(@Nullable long[] values, int pos, int length) {
    return handle(Value.int64Array(values, pos, length));
  }

  /** Binds to {@code Value.int64Array(values)} */
  public R toInt64Array(@Nullable Iterable<Long> values) {
    return handle(Value.int64Array(values));
  }

  /** Binds to {@code Value.float64Array(values)} */
  public R toFloat64Array(@Nullable double[] values) {
    return handle(Value.float64Array(values));
  }

  /** Binds to {@code Value.float64Array(values, pos, length)} */
  public R toFloat64Array(@Nullable double[] values, int pos, int length) {
    return handle(Value.float64Array(values, pos, length));
  }

  /** Binds to {@code Value.float64Array(values)} */
  public R toFloat64Array(@Nullable Iterable<Double> values) {
    return handle(Value.float64Array(values));
  }

  /** Binds to {@code Value.stringArray(values)} */
  public R toStringArray(@Nullable Iterable<String> values) {
    return handle(Value.stringArray(values));
  }

  /** Binds to {@code Value.bytesArray(values)} */
  public R toBytesArray(@Nullable Iterable<ByteArray> values) {
    return handle(Value.bytesArray(values));
  }

  /** Binds to {@code Value.timestampArray(values)} */
  public R toTimestampArray(@Nullable Iterable<Timestamp> values) {
    return handle(Value.timestampArray(values));
  }

  /** Binds to {@code Value.dateArray(values)} */
  public R toDateArray(@Nullable Iterable<Date> values) {
    return handle(Value.dateArray(values));
  }
}
