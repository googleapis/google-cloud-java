/*
 * Copyright 2021 Google LLC
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

package com.google.cloud.logging;

import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.math.LongMath.checkedAdd;
import static com.google.common.math.LongMath.checkedSubtract;

import com.google.protobuf.Timestamp;
import com.google.protobuf.util.Timestamps;
import java.time.Instant;

/**
 * A utility class that provides conversions between:
 *
 * <ul>
 *   <li>Protobuf's {@link Timestamp} and {@link java.time.Instant}
 * </ul>
 *
 * The class complements conversion methods that are currently not supported in the published
 * protobuf-java-util. After migrating protobuf-java-util to Java 8 this class can be removed.
 *
 * @see <a href=
 *     "https://mvnrepository.com/artifact/com.google.protobuf/protobuf-java-util">protobuf-java-util</a>
 */
class JavaTimeConversions {
  static final long NANOS_PER_SECOND = 1000000000;

  private JavaTimeConversions() {}

  /**
   * Converts a protobuf {@link Timestamp} to a {@link java.time.Instant}.
   *
   * @throws IllegalArgumentException if the given {@link Timestamp} is not valid. See {@link
   *     Timestamps#isValid}.
   */
  public static Instant toJavaInstant(Timestamp timestamp) {
    checkNotNull(timestamp);
    timestamp = normalizedTimestamp(timestamp.getSeconds(), timestamp.getNanos());
    return Instant.ofEpochSecond(timestamp.getSeconds(), timestamp.getNanos());
  }

  /**
   * Converts a {@link java.time.Instant} to a protobuf {@link Timestamp}.
   *
   * @throws IllegalArgumentException if the given {@link java.time.Instant} cannot legally fit into
   *     a {@link Timestamp}. See {@link Timestamps#isValid}.
   */
  public static Timestamp toProtoTimestamp(Instant instant) {
    checkNotNull(instant);
    return normalizedTimestamp(instant.getEpochSecond(), instant.getNano());
  }

  /** Exposes {@link Timestamps#normalizedTimestamp} internal method. */
  static Timestamp normalizedTimestamp(long seconds, int nanos) {
    if (nanos <= -NANOS_PER_SECOND || nanos >= NANOS_PER_SECOND) {
      seconds = checkedAdd(seconds, nanos / NANOS_PER_SECOND);
      nanos = (int) (nanos % NANOS_PER_SECOND);
    }
    if (nanos < 0) {
      nanos =
          (int)
              (nanos + NANOS_PER_SECOND); // no overflow since nanos is negative (and we're adding)
      seconds = checkedSubtract(seconds, 1);
    }
    Timestamp timestamp = Timestamp.newBuilder().setSeconds(seconds).setNanos(nanos).build();
    return Timestamps.checkValid(timestamp);
  }
}
