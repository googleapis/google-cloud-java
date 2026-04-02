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

import static com.google.common.base.Preconditions.checkArgument;

import java.util.Locale;

/**
 * Shrink wraps a beginning, offset and ending for tracking state of an individual invocation of
 * {@link #read}
 */
final class ReadCursor {
  private final long begin;
  private long position;
  private final long end;

  ReadCursor(long begin, long end) {
    this.end = end;
    this.begin = begin;
    this.position = begin;
  }

  public boolean hasRemaining() {
    return remaining() > 0;
  }

  public long remaining() {
    return end - position;
  }

  public void advance(long incr) {
    checkArgument(incr >= 0);
    position += incr;
  }

  public long read() {
    return position - begin;
  }

  public long begin() {
    return begin;
  }

  public long position() {
    return position;
  }

  public long end() {
    return end;
  }

  @Override
  public String toString() {
    return String.format(
        Locale.US, "ReadCursor{begin=%d, position=%d, end=%d}", begin, position, end);
  }
}
