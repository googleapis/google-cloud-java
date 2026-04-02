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
import java.util.Objects;
import javax.annotation.concurrent.Immutable;
import org.checkerframework.checker.nullness.qual.Nullable;

/**
 * Produce a new {@link RangeSpec} relative to the provided {@code offset} and {@code prev}, where
 * the RangeSpec will have a maxLength set to the lesser of {@code prev.maxLength} and {@code
 * this.maxLength}.
 *
 * <p>Instances of this class are immutable and thread safe.
 *
 * @since 2.51.0 This new api is in preview and is subject to breaking changes.
 */
@BetaApi
@Immutable
public final class MaxLengthRangeSpecFunction extends RangeSpecFunction {
  static final MaxLengthRangeSpecFunction INSTANCE = new MaxLengthRangeSpecFunction(0);
  private final long maxLength;

  MaxLengthRangeSpecFunction(long maxLength) {
    this.maxLength = maxLength;
  }

  /**
   * The maximum maxLength for any RangeSpec returned from {@link #apply(long, RangeSpec)}
   *
   * <p><i>Default:</i> {@code 0} -- no max length
   *
   * @see #withMaxLength(long)
   * @see RangeSpec#maxLength()
   * @since 2.51.0 This new api is in preview and is subject to breaking changes.
   */
  public long getMaxLength() {
    return maxLength;
  }

  /**
   * Return an instance with the {@code maxLength} set to the specified value.
   *
   * <p><i>Default:</i> {@code 0} -- no max length
   *
   * @param maxLength The number of bytes a {@link RangeSpec}s maxLength should be limited to. Must
   *     be &gt; {@code 0}.
   * @see #getMaxLength()
   * @see RangeSpec#maxLength()
   * @since 2.51.0 This new api is in preview and is subject to breaking changes.
   */
  public MaxLengthRangeSpecFunction withMaxLength(long maxLength) {
    checkArgument(maxLength >= 0, "maxLength >= 0 (%s >= 0)", maxLength);
    return new MaxLengthRangeSpecFunction(maxLength);
  }

  /**
   * Produce a new {@link RangeSpec} relative to the provided {@code offset} and {@code prev}, where
   * the RangeSpec will have a maxLength set to the lesser of {@code prev.maxLength} and {@code
   * this.maxLength}.
   */
  @Override
  RangeSpec apply(long offset, @Nullable RangeSpec prev) {
    if (prev == null || !prev.maxLength().isPresent()) {
      return RangeSpec.of(offset, maxLength);
    }
    long limit = prev.maxLength().getAsLong();
    return RangeSpec.of(offset, Math.min(limit, maxLength));
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof MaxLengthRangeSpecFunction)) {
      return false;
    }
    MaxLengthRangeSpecFunction that = (MaxLengthRangeSpecFunction) o;
    return maxLength == that.maxLength;
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(maxLength);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this).add("maxLength", maxLength).toString();
  }
}
