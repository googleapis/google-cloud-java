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

import static com.google.cloud.storage.ByteSizeConstants._16MiB;
import static com.google.cloud.storage.ByteSizeConstants._2MiB;
import static com.google.cloud.storage.ByteSizeConstants._4MiB;

import com.google.api.core.BetaApi;
import com.google.api.core.InternalExtensionOnly;
import com.google.cloud.storage.BufferedWritableByteChannelSession.BufferedWritableByteChannel;
import com.google.cloud.storage.UnbufferedWritableByteChannelSession.UnbufferedWritableByteChannel;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import java.util.Objects;
import javax.annotation.concurrent.Immutable;

/**
 * Base class used for flush policies which are responsible for configuring an upload channel's
 * behavior with regard to flushes.
 *
 * <p>Instances of this class and all its subclasses are immutable and thread safe.
 *
 * @since 2.51.0 This new api is in preview and is subject to breaking changes.
 */
@BetaApi
@Immutable
@InternalExtensionOnly
public abstract class FlushPolicy {

  private FlushPolicy() {}

  /**
   * Default instance factory method for {@link MaxFlushSizeFlushPolicy}.
   *
   * @since 2.51.0 This new api is in preview and is subject to breaking changes.
   */
  @BetaApi
  public static MaxFlushSizeFlushPolicy maxFlushSize() {
    return MaxFlushSizeFlushPolicy.INSTANCE;
  }

  /**
   * Alias for {@link FlushPolicy#maxFlushSize() FlushPolicy.maxFlushSize()}{@code .}{@link
   * MaxFlushSizeFlushPolicy#withMaxFlushSize(int) withMaxFlushSize(int)}
   *
   * @since 2.51.0 This new api is in preview and is subject to breaking changes.
   */
  @BetaApi
  public static MaxFlushSizeFlushPolicy maxFlushSize(int maxFlushSize) {
    return maxFlushSize().withMaxFlushSize(maxFlushSize);
  }

  /**
   * Default instance factory method for {@link MinFlushSizeFlushPolicy}.
   *
   * <p><i>Default:</i> logically equivalent to the following:
   *
   * <pre>
   * {@link #minFlushSize(int) FlushPolicy.minFlushSize}(4 * 1024 * 1024)
   *     .{@link MinFlushSizeFlushPolicy#withMaxPendingBytes(long) withMaxPendingBytes}(16 * 1024 * 1024)
   * </pre>
   *
   * @since 2.51.0 This new api is in preview and is subject to breaking changes.
   */
  @BetaApi
  public static MinFlushSizeFlushPolicy minFlushSize() {
    return MinFlushSizeFlushPolicy.INSTANCE;
  }

  /**
   * Alias for {@link FlushPolicy#minFlushSize() FlushPolicy.minFlushSize()}{@code .}{@link
   * MinFlushSizeFlushPolicy#withMinFlushSize(int) withMinFlushSize(int)}
   *
   * @since 2.51.0 This new api is in preview and is subject to breaking changes.
   */
  @BetaApi
  public static MinFlushSizeFlushPolicy minFlushSize(int minFlushSize) {
    return minFlushSize().withMinFlushSize(minFlushSize);
  }

  abstract BufferedWritableByteChannel createBufferedChannel(
      UnbufferedWritableByteChannel unbuffered, boolean blocking);

  abstract long getMaxPendingBytes();

  @Override
  public abstract boolean equals(Object obj);

  @Override
  public abstract int hashCode();

  @Override
  public abstract String toString();

  /**
   * Define a {@link FlushPolicy} where a max number of bytes will be flushed to GCS per flush.
   *
   * <p>If there are not enough bytes to trigger a flush, they will be held in memory until there
   * are enough bytes, or an explicit flush is performed by closing the channel. If more bytes are
   * provided than the configured {@code maxFlushSize}, multiple flushes will be performed.
   *
   * <p>Instances of this class are immutable and thread safe.
   *
   * <p>Instead of this, strategy use {@link FlushPolicy#minFlushSize()}{@code .}{@link
   * MinFlushSizeFlushPolicy#withMaxPendingBytes(long) withMaxPendingBytes(long)}
   *
   * @since 2.51.0 This new api is in preview and is subject to breaking changes.
   */
  @Immutable
  @BetaApi
  public static final class MaxFlushSizeFlushPolicy extends FlushPolicy {
    private static final MaxFlushSizeFlushPolicy INSTANCE = new MaxFlushSizeFlushPolicy(_2MiB);

    private final int maxFlushSize;

    private MaxFlushSizeFlushPolicy(int maxFlushSize) {
      this.maxFlushSize = maxFlushSize;
    }

    /**
     * The maximum number of bytes to include in each automatic flush
     *
     * <p><i>Default:</i> {@code 2097152 (2 MiB)}
     *
     * @see #withMaxFlushSize(int)
     */
    @BetaApi
    public int getMaxFlushSize() {
      return maxFlushSize;
    }

    /**
     * Return an instance with the {@code maxFlushSize} set to the specified value.
     *
     * <p><i>Default:</i> {@code 2097152 (2 MiB)}
     *
     * @param maxFlushSize The number of bytes to buffer before flushing.
     * @return The new instance
     * @see #getMaxFlushSize()
     */
    @BetaApi
    public MaxFlushSizeFlushPolicy withMaxFlushSize(int maxFlushSize) {
      Preconditions.checkArgument(maxFlushSize >= 0, "maxFlushSize >= 0 (%s >= 0)", maxFlushSize);
      if (this.maxFlushSize == maxFlushSize) {
        return this;
      }
      return new MaxFlushSizeFlushPolicy(maxFlushSize);
    }

    @Override
    BufferedWritableByteChannel createBufferedChannel(
        UnbufferedWritableByteChannel unbuffered, boolean blocking) {
      return new DefaultBufferedWritableByteChannel(
          BufferHandle.allocate(maxFlushSize), unbuffered, blocking);
    }

    @Override
    long getMaxPendingBytes() {
      return maxFlushSize;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (!(o instanceof MaxFlushSizeFlushPolicy)) {
        return false;
      }
      MaxFlushSizeFlushPolicy that = (MaxFlushSizeFlushPolicy) o;
      return maxFlushSize == that.maxFlushSize;
    }

    @Override
    public int hashCode() {
      return Objects.hashCode(maxFlushSize);
    }

    @Override
    public String toString() {
      return MoreObjects.toStringHelper(this).add("maxFlushSize", maxFlushSize).toString();
    }
  }

  /**
   * Define a {@link FlushPolicy} where a min number of bytes will be required before a flush GCS
   * happens.
   *
   * <p>If there are not enough bytes to trigger a flush, they will be held in memory until there
   * are enough bytes, or an explicit flush is performed by closing the channel.
   *
   * <p>Instances of this class are immutable and thread safe.
   *
   * @since 2.51.0 This new api is in preview and is subject to breaking changes.
   */
  @Immutable
  @BetaApi
  public static final class MinFlushSizeFlushPolicy extends FlushPolicy {
    private static final MinFlushSizeFlushPolicy INSTANCE =
        new MinFlushSizeFlushPolicy(_4MiB, _16MiB);

    private final int minFlushSize;
    private final long maxPendingBytes;

    private MinFlushSizeFlushPolicy(int minFlushSize, long maxPendingBytes) {
      this.minFlushSize = minFlushSize;
      this.maxPendingBytes = maxPendingBytes;
    }

    /**
     * The minimum number of bytes to include in each automatic flush
     *
     * <p><i>Default:</i> {@code 4194304 (4 MiB)}
     *
     * @see #withMinFlushSize(int)
     */
    @BetaApi
    public int getMinFlushSize() {
      return minFlushSize;
    }

    /**
     * Return an instance with the {@code minFlushSize} set to the specified value.
     *
     * <p><i>Default:</i> {@code 4194304 (4 MiB)}
     *
     * @param minFlushSize The number of bytes to buffer before flushing.
     * @return The new instance
     * @see #getMinFlushSize()
     */
    @BetaApi
    public MinFlushSizeFlushPolicy withMinFlushSize(int minFlushSize) {
      Preconditions.checkArgument(minFlushSize >= 0, "minFlushSize >= 0 (%s >= 0)", minFlushSize);
      if (this.minFlushSize == minFlushSize) {
        return this;
      }
      return new MinFlushSizeFlushPolicy(minFlushSize, maxPendingBytes);
    }

    @BetaApi
    public long getMaxPendingBytes() {
      return maxPendingBytes;
    }

    @BetaApi
    public MinFlushSizeFlushPolicy withMaxPendingBytes(long maxPendingBytes) {
      Preconditions.checkArgument(
          maxPendingBytes >= 0, "maxPendingBytes >= 0 (%s >= 0)", maxPendingBytes);
      Preconditions.checkArgument(
          maxPendingBytes >= minFlushSize,
          "maxPendingBytes >= minFlushSize (%s >= %s",
          maxPendingBytes,
          minFlushSize);
      if (this.maxPendingBytes == maxPendingBytes) {
        return this;
      }
      return new MinFlushSizeFlushPolicy(minFlushSize, maxPendingBytes);
    }

    @Override
    BufferedWritableByteChannel createBufferedChannel(
        UnbufferedWritableByteChannel unbuffered, boolean blocking) {
      return new MinFlushBufferedWritableByteChannel(
          BufferHandle.allocate(minFlushSize), unbuffered, blocking);
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (!(o instanceof MinFlushSizeFlushPolicy)) {
        return false;
      }
      MinFlushSizeFlushPolicy that = (MinFlushSizeFlushPolicy) o;
      return minFlushSize == that.minFlushSize && maxPendingBytes == that.maxPendingBytes;
    }

    @Override
    public int hashCode() {
      return Objects.hash(minFlushSize, maxPendingBytes);
    }

    @Override
    public String toString() {
      return MoreObjects.toStringHelper(this)
          .add("minFlushSize", minFlushSize)
          .add("maxPendingBytes", maxPendingBytes)
          .toString();
    }
  }
}
