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

import com.google.api.core.BetaApi;
import com.google.common.base.MoreObjects;
import java.util.Objects;
import java.util.OptionalLong;
import javax.annotation.concurrent.Immutable;
import org.checkerframework.checker.nullness.qual.NonNull;

/**
 * Defines a range with a begin offset and optional maximum length.
 *
 * @since 2.51.0 This new api is in preview and is subject to breaking changes.
 */
@BetaApi
@Immutable
public abstract class RangeSpec {
  // seal this class to extension
  private RangeSpec() {}

  /**
   * The beginning of the range.
   *
   * @since 2.51.0 This new api is in preview and is subject to breaking changes.
   */
  @BetaApi
  public abstract long begin();

  /**
   * The max length of the range if defined.
   *
   * @see RangeSpecWithMaxLength
   * @since 2.51.0 This new api is in preview and is subject to breaking changes.
   */
  @BetaApi
  public abstract OptionalLong maxLength();

  /**
   * Create a new instance of {@link RangeSpec} keeping {@code this.begin()} and with {@code
   * maxLength} as its new maxLength.
   *
   * @since 2.51.0 This new api is in preview and is subject to breaking changes.
   */
  @NonNull
  @BetaApi
  public abstract RangeSpec withMaxLength(long maxLength);

  /**
   * {@inheritDoc}
   *
   * @since 2.51.0 This new api is in preview and is subject to breaking changes.
   */
  @Override
  public abstract boolean equals(Object o);

  /**
   * {@inheritDoc}
   *
   * @since 2.51.0 This new api is in preview and is subject to breaking changes.
   */
  @Override
  public abstract int hashCode();

  /**
   * {@inheritDoc}
   *
   * @since 2.51.0 This new api is in preview and is subject to breaking changes.
   */
  @Override
  public abstract String toString();

  /**
   * Create a new RangeSpec with the provided {@code begin}.
   *
   * @param begin The beginning of the range, must be >= 0
   * @throws IllegalArgumentException if begin is &lt; 0
   * @since 2.51.0 This new api is in preview and is subject to breaking changes.
   */
  @NonNull
  @BetaApi
  public static RangeSpec beginAt(long begin) {
    checkArgument(begin >= 0, "range being must be >= 0 (range begin = %s)", begin);
    return new RangeSpecWithoutLimit(begin);
  }

  /**
   * Create a new RangeSpec with the provided {@code begin} and {@code maxLength}.
   *
   * @param begin The beginning of the range, must be >= 0
   * @param maxLength The max length of the range, must be >= 0. 0 means no limit.
   * @throws IllegalArgumentException if begin is &lt; 0, or if maxLength is &lt; 0
   * @since 2.51.0 This new api is in preview and is subject to breaking changes.
   */
  @NonNull
  @BetaApi
  public static RangeSpec of(long begin, long maxLength) {
    checkArgument(begin >= 0, "range being must be >= 0 (range begin = %s)", begin);
    checkArgument(maxLength >= 0, "range maxLength must be >= 0 (range maxLength = %s)", maxLength);
    if (maxLength == 0) {
      return new RangeSpecWithoutLimit(begin);
    }
    return new RangeSpecWithMaxLength(begin, maxLength);
  }

  /**
   * A RangeSpec that represents to read from {@code 0} to {@code EOF}
   *
   * @since 2.51.0 This new api is in preview and is subject to breaking changes.
   */
  @NonNull
  @BetaApi
  public static RangeSpec all() {
    return RangeSpecWithoutLimit.ALL;
  }

  static final class RangeSpecWithoutLimit extends RangeSpec {
    private static final RangeSpecWithoutLimit ALL = new RangeSpecWithoutLimit(0);
    private final long begin;

    private RangeSpecWithoutLimit(long begin) {
      this.begin = begin;
    }

    @Override
    public long begin() {
      return begin;
    }

    @Override
    public OptionalLong maxLength() {
      return OptionalLong.empty();
    }

    @Override
    @NonNull
    public RangeSpec withMaxLength(long maxLength) {
      checkArgument(maxLength >= 0, "range maxLength must be >= 0 (range limit = %s)", maxLength);
      return new RangeSpecWithMaxLength(begin, maxLength);
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (!(o instanceof RangeSpecWithoutLimit)) {
        return false;
      }
      RangeSpecWithoutLimit that = (RangeSpecWithoutLimit) o;
      return begin == that.begin;
    }

    @Override
    public int hashCode() {
      return Objects.hashCode(begin);
    }

    @Override
    public String toString() {
      return MoreObjects.toStringHelper(this).add("begin", begin).toString();
    }
  }

  static final class RangeSpecWithMaxLength extends RangeSpec {
    private final long begin;
    private final long maxLength;

    private RangeSpecWithMaxLength(long begin, long maxLength) {
      this.begin = begin;
      this.maxLength = maxLength;
    }

    @Override
    public long begin() {
      return begin;
    }

    @Override
    public OptionalLong maxLength() {
      return OptionalLong.of(maxLength);
    }

    @Override
    @NonNull
    public RangeSpec withMaxLength(long maxLength) {
      checkArgument(maxLength >= 0, "range maxLength must be >= 0 (range limit = %s)", maxLength);
      return new RangeSpecWithMaxLength(begin, maxLength);
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (!(o instanceof RangeSpecWithMaxLength)) {
        return false;
      }
      RangeSpecWithMaxLength that = (RangeSpecWithMaxLength) o;
      return begin == that.begin && maxLength == that.maxLength;
    }

    @Override
    public int hashCode() {
      return Objects.hash(begin, maxLength);
    }

    @Override
    public String toString() {
      return MoreObjects.toStringHelper(RangeSpec.class)
          .add("begin", begin)
          .add("maxLength", maxLength)
          .toString();
    }
  }
}
