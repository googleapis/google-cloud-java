/*
 * Copyright 2025 Google LLC
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

import com.google.api.core.BetaApi;
import com.google.common.base.MoreObjects;
import com.google.common.math.DoubleMath;
import java.math.RoundingMode;
import java.util.Objects;
import java.util.OptionalLong;
import javax.annotation.concurrent.Immutable;

/**
 * Produce a new {@link RangeSpec} relative to the provided {@code offset} and {@code prev}. Scaling
 * up the maxLength if a sequential match.
 *
 * <p>Instances of this class are immutable and thread safe.
 *
 * @since 2.51.0 This new api is in preview and is subject to breaking changes.
 */
@BetaApi
@Immutable
public final class LinearExponentialRangeSpecFunction extends RangeSpecFunction {

  static final LinearExponentialRangeSpecFunction INSTANCE =
      new LinearExponentialRangeSpecFunction(ByteSizeConstants._2MiB, 4.0d);
  private final long initialMaxLength;
  private final double maxLengthScalar;

  private LinearExponentialRangeSpecFunction(long initialMaxLength, double maxLengthScalar) {
    this.initialMaxLength = initialMaxLength;
    this.maxLengthScalar = maxLengthScalar;
  }

  /**
   * Initial maxLength a {@link RangeSpec}s maxLength should be set to if no previous maxLength is
   * specified, or if the provided offset is not a sequential match.
   *
   * <p><i>Default:</i> {@code 2097152 (2 MiB)}
   *
   * @see #withInitialMaxLength(long)
   * @see RangeSpec#maxLength()
   * @since 2.51.0 This new api is in preview and is subject to breaking changes.
   */
  public long getInitialMaxLength() {
    return initialMaxLength;
  }

  /**
   * Return an instance with the {@code initialMaxLength} set to the specified value.
   *
   * <p><i>Default:</i> {@code 2097152 (2 MiB)}
   *
   * @param initialMaxLength The number of bytes a {@link RangeSpec}s maxLength should be set to if
   *     no previous maxLength is specified, or if the provided offset is not a sequential match.
   *     Must be &gt; {@code 0}.
   * @see #getInitialMaxLength()
   * @see RangeSpec#maxLength()
   * @since 2.51.0 This new api is in preview and is subject to breaking changes.
   */
  public LinearExponentialRangeSpecFunction withInitialMaxLength(long initialMaxLength) {
    checkArgument(initialMaxLength > 0, "initialMaxLength > 0 (%s > 0)", initialMaxLength);
    return new LinearExponentialRangeSpecFunction(initialMaxLength, maxLengthScalar);
  }

  /**
   * The scalar value used to scale the max length of a {@link RangeSpec} when the provided offset
   * is a sequential match.
   *
   * <p><i>Default:</i> {@code 4.0}
   *
   * @see #withMaxLengthScalar(double)
   * @see RangeSpec#maxLength()
   * @since 2.51.0 This new api is in preview and is subject to breaking changes.
   */
  public double getMaxLengthScalar() {
    return maxLengthScalar;
  }

  /**
   * Return an instance with the {@code maxLengthScalar} set to the specified value.
   *
   * <p><i>Default:</i> {@code 4.0}
   *
   * @param maxLengthScalar The scalar to apply to the max length of a previous {@link RangeSpec}
   *     when the provided offset is a sequential match. Must be $gt;= {@code 1.0}.
   * @see #getMaxLengthScalar()
   * @see RangeSpec#maxLength()
   * @since 2.51.0 This new api is in preview and is subject to breaking changes.
   */
  public LinearExponentialRangeSpecFunction withMaxLengthScalar(double maxLengthScalar) {
    checkArgument(maxLengthScalar >= 1.0, "maxLengthScalar >= 1.0 (%s >= 1.0)", maxLengthScalar);
    return new LinearExponentialRangeSpecFunction(initialMaxLength, maxLengthScalar);
  }

  /**
   * Produce a new {@link RangeSpec} relative to the provided {@code offset} and {@code prev}.
   *
   * <p>If {@code prev} is null, a {@code RangeSpec} beginning at {@code offset} and maxLength set
   * to {@link #getInitialMaxLength()}. If {@code offset == (prev.begin + prev.maxLength)} create a
   * new {@code RangeSpec} beginning at {@code offset} and maxLength set to {@code prev.maxLength *
   * maxLengthScalar}
   */
  @Override
  RangeSpec apply(long offset, RangeSpec prev) {
    if (prev == null) {
      return RangeSpec.of(offset, initialMaxLength);
    }

    OptionalLong maybeMaxLength = prev.maxLength();
    long maxLength;
    if (maybeMaxLength.isPresent()) {
      maxLength = maybeMaxLength.getAsLong();

      long expectedOffset = prev.begin() + maxLength;
      if (offset != expectedOffset) {
        return RangeSpec.of(offset, initialMaxLength);
      }

    } else {
      maxLength = Long.MAX_VALUE;
    }

    long scaleReadSize = scaleMaxLength(maxLength, maxLengthScalar);

    return RangeSpec.of(offset, scaleReadSize);
  }

  private static long scaleMaxLength(long lastReadSize, double rangeMaxLengthScalar) {
    double scaled = lastReadSize * rangeMaxLengthScalar;
    if (Double.isInfinite(scaled)) {
      return Long.MAX_VALUE;
    }
    return DoubleMath.roundToLong(scaled, RoundingMode.HALF_EVEN);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof LinearExponentialRangeSpecFunction)) {
      return false;
    }
    LinearExponentialRangeSpecFunction that = (LinearExponentialRangeSpecFunction) o;
    return initialMaxLength == that.initialMaxLength
        && Double.compare(maxLengthScalar, that.maxLengthScalar) == 0;
  }

  @Override
  public int hashCode() {
    return Objects.hash(initialMaxLength, maxLengthScalar);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("initialMaxLength", initialMaxLength)
        .add("rangeMaxLengthScalar", maxLengthScalar)
        .toString();
  }
}
