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

import com.google.protobuf.ByteString;
import javax.annotation.Nullable;

/**
 * Simple value object to represent a range of values with an inclusive start and an exclusive end.
 * Both endpoints can be null to represent positive/negative infinity.
 */
public class Range<T> {
  @Nullable private final T start;
  @Nullable private final T end;

  private Range(T start, T end) {
    this.start = start;
    this.end = end;
  }

  /** Creates an unbounded {@link Range}. */
  public static <T> Range<T> unbounded() {
    return new Range<>(null, null);
  }

  /** Creates a bounded {@link Range}. */
  public static <T> Range<T> of(T start, T end) {
    return new Range<>(start, end);
  }

  public static Range<ByteString> ofUtf8ByteStrings(String start, String end) {
    ByteString startByteString;
    if (start == null) {
      startByteString = null;
    } else {
      startByteString = ByteString.copyFromUtf8(start);
    }

    ByteString endByteString;
    if (end == null) {
      endByteString = null;
    } else {
      endByteString = ByteString.copyFromUtf8(end);
    }

    return of(startByteString, endByteString);
  }

  /** Creates a new {@link Range} with the specified start and the current end. */
  public Range<T> withStart(T start) {
    return new Range<>(start, end);
  }

  /** Creates a new {@link Range} with the specified end and the current start. */
  public Range<T> withEnd(T end) {
    return new Range<>(start, end);
  }

  /** Gets the start of the {@link Range} (inclusive). */
  public T getStart() {
    return start;
  }

  /** Gets the end of the {@link Range} (exclusive). */
  public T getEnd() {
    return end;
  }
}
