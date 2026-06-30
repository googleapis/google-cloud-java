/*
 * Copyright 2023 Google LLC
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

import com.google.common.base.MoreObjects;
import java.time.Duration;
import java.util.Objects;

/**
 * Convenience class to encapsulate the concept of a throughput value.
 *
 * <p>Given a number of bytes and a duration compute the number of bytes per second.
 */
final class Throughput {

  private static final double NANOS_PER_SECOND = 1_000_000_000d;
  private final long numBytes;
  private final Duration duration;

  // TODO: is there a efficient way we can limit precision without having to use BigDecimal?
  //   Realistically, we don't need precision smaller than 1 byte per microsecond, leading to
  //   6 digits past the decimal of needed precision.
  private final double bytesPerSecond;

  private Throughput(long numBytes, Duration duration) {
    this.numBytes = numBytes;
    this.duration = duration;
    this.bytesPerSecond = numBytes / (duration.toNanos() / NANOS_PER_SECOND);
  }

  public long getNumBytes() {
    return numBytes;
  }

  public Duration getDuration() {
    return duration;
  }

  public double toBps() {
    return bytesPerSecond;
  }

  public Throughput plus(Throughput other) {
    return new Throughput(this.numBytes + other.numBytes, this.duration.plus(other.duration));
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Throughput)) {
      return false;
    }
    Throughput that = (Throughput) o;
    return Double.compare(that.bytesPerSecond, bytesPerSecond) == 0;
  }

  @Override
  public int hashCode() {
    return Objects.hash(bytesPerSecond);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this).add("bytesPerSecond", bytesPerSecond).toString();
  }

  public static Throughput zero() {
    return new Throughput(0, Duration.ZERO);
  }

  public static Throughput of(long numBytes, Duration duration) {
    return new Throughput(numBytes, duration);
  }

  public static Throughput bytesPerSecond(long numBytes) {
    return new Throughput(numBytes, Duration.ofSeconds(1));
  }
}
