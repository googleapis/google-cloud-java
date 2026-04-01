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

import static java.util.Objects.requireNonNull;

import com.google.api.core.BetaApi;
import com.google.common.base.MoreObjects;
import java.nio.channels.SeekableByteChannel;
import java.util.Objects;
import javax.annotation.concurrent.Immutable;

/**
 * Read from the object as a {@link SeekableByteChannel}
 *
 * <p>The returned channel will be non-blocking for all read calls. If bytes have not yet
 * asynchronously been delivered from Google Cloud Storage the method will return rather than
 * waiting for the bytes to arrive.
 *
 * <p>The resulting {@link SeekableByteChannel} MUST be {@link SeekableByteChannel#close()
 * close()}ed to avoid leaking memory
 *
 * <p>Instances of this class are immutable and thread safe.
 *
 * @see ReadProjectionConfigs#asSeekableChannel()
 * @see BlobReadSession#readAs(ReadProjectionConfig)
 * @see SeekableByteChannel
 * @since 2.51.0 This new api is in preview and is subject to breaking changes.
 */
@BetaApi
@Immutable
public final class ReadAsSeekableChannel extends ReadProjectionConfig<SeekableByteChannel> {

  static final ReadAsSeekableChannel INSTANCE =
      new ReadAsSeekableChannel(Hasher.enabled(), LinearExponentialRangeSpecFunction.INSTANCE);

  private final Hasher hasher;
  private final RangeSpecFunction rangeSpecFunction;

  private ReadAsSeekableChannel(Hasher hasher, RangeSpecFunction rangeSpecFunction) {
    this.hasher = hasher;
    this.rangeSpecFunction = rangeSpecFunction;
  }

  /**
   * Get the {@link RangeSpecFunction} this instance will use to generate {@link RangeSpec}s for
   * reading from an object.
   *
   * <p><i>Default:</i> {@link RangeSpecFunction#linearExponential()}
   *
   * @since 2.51.0 This new api is in preview and is subject to breaking changes.
   */
  @BetaApi
  public RangeSpecFunction getRangeSpecFunction() {
    return rangeSpecFunction;
  }

  /**
   * Return an instance with the {@code rangeSpecFunction} set to the specified value.
   *
   * <p><i>Default:</i> {@link RangeSpecFunction#linearExponential()}
   *
   * @param rangeSpecFunction The {@link RangeSpecFunction} to use to generate {@link RangeSpec}s
   *     for reading from an object.
   * @see #getRangeSpecFunction()
   * @since 2.51.0 This new api is in preview and is subject to breaking changes.
   */
  @BetaApi
  public ReadAsSeekableChannel withRangeSpecFunction(RangeSpecFunction rangeSpecFunction) {
    requireNonNull(rangeSpecFunction, "rangeSpecFunction must be non null");
    return new ReadAsSeekableChannel(hasher, rangeSpecFunction);
  }

  /**
   * Whether crc32c validation will be performed for bytes returned by Google Cloud Storage
   *
   * <p><i>Default:</i> {@code true}
   *
   * @since 2.51.0 This new api is in preview and is subject to breaking changes.
   */
  @BetaApi
  boolean getCrc32cValidationEnabled() {
    return Hasher.enabled().equals(hasher);
  }

  /**
   * Return an instance with crc32c validation enabled based on {@code enabled}.
   *
   * <p><i>Default:</i> {@code true}
   *
   * @param enabled Whether crc32c validation will be performed for bytes returned by Google Cloud
   *     Storage
   * @since 2.51.0 This new api is in preview and is subject to breaking changes.
   */
  @BetaApi
  ReadAsSeekableChannel withCrc32cValidationEnabled(boolean enabled) {
    if (enabled && Hasher.enabled().equals(hasher)) {
      return this;
    } else if (!enabled && Hasher.noop().equals(hasher)) {
      return this;
    }
    return new ReadAsSeekableChannel(enabled ? Hasher.enabled() : Hasher.noop(), rangeSpecFunction);
  }

  @Override
  SeekableByteChannel project(ObjectReadSession session, IOAutoCloseable closeAlongWith) {
    return StorageByteChannels.seekable(
        new ObjectReadSessionSeekableByteChannel(session, this, closeAlongWith));
  }

  @Override
  ProjectionType getType() {
    return ProjectionType.SESSION_USER;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof ReadAsSeekableChannel)) {
      return false;
    }
    ReadAsSeekableChannel that = (ReadAsSeekableChannel) o;
    return Objects.equals(rangeSpecFunction, that.rangeSpecFunction);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(rangeSpecFunction);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this).add("rangeSpecFunction", rangeSpecFunction).toString();
  }
}
