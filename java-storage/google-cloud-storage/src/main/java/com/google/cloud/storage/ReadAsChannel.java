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
import com.google.cloud.storage.BaseObjectReadSessionStreamRead.StreamingRead;
import com.google.cloud.storage.ReadProjectionConfigs.BaseConfig;
import com.google.common.base.MoreObjects;
import java.nio.channels.ScatteringByteChannel;
import java.util.Objects;
import javax.annotation.concurrent.Immutable;

/**
 * Read a range of {@code byte}s as a non-blocking {@link ScatteringByteChannel}
 *
 * <p>The returned channel will be non-blocking for all read calls. If bytes have not yet
 * asynchronously been delivered from Google Cloud Storage the method will return rather than
 * waiting for the bytes to arrive.
 *
 * <p>The resulting {@link ScatteringByteChannel} MUST be {@link ScatteringByteChannel#close()
 * close()}ed to avoid leaking memory
 *
 * <p>Instances of this class are immutable and thread safe.
 *
 * @see ReadProjectionConfigs#asChannel()
 * @see BlobReadSession#readAs(ReadProjectionConfig)
 * @see ScatteringByteChannel
 * @since 2.51.0 This new api is in preview and is subject to breaking changes.
 */
@BetaApi
@Immutable
public final class ReadAsChannel extends BaseConfig<ScatteringByteChannel, StreamingRead> {
  static final ReadAsChannel INSTANCE = new ReadAsChannel(RangeSpec.all(), Hasher.enabled());

  private final RangeSpec range;
  private final Hasher hasher;

  private ReadAsChannel(RangeSpec range, Hasher hasher) {
    super();
    this.range = range;
    this.hasher = hasher;
  }

  /**
   * The {@link RangeSpec} to be used for any read using this instance.
   *
   * <p><i>Default:</i> {@link RangeSpec#all()}
   *
   * @since 2.51.0 This new api is in preview and is subject to breaking changes.
   */
  @BetaApi
  public RangeSpec getRange() {
    return range;
  }

  /**
   * Return an instance with the {@link RangeSpec} set to the specified value.
   *
   * <p><i>Default:</i> {@link RangeSpec#all()}
   *
   * @param range The {@link RangeSpec} to be used for any read using the returned instance. Must be
   *     non-null.
   * @see #getRange()
   * @since 2.51.0 This new api is in preview and is subject to breaking changes.
   */
  @BetaApi
  public ReadAsChannel withRangeSpec(RangeSpec range) {
    requireNonNull(range, "range must be non null");
    if (this.range.equals(range)) {
      return this;
    }
    return new ReadAsChannel(range, hasher);
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
  ReadAsChannel withCrc32cValidationEnabled(boolean enabled) {
    if (enabled && Hasher.enabled().equals(hasher)) {
      return this;
    } else if (!enabled && Hasher.noop().equals(hasher)) {
      return this;
    }
    return new ReadAsChannel(range, enabled ? Hasher.enabled() : Hasher.noop());
  }

  @Override
  BaseConfig<ScatteringByteChannel, ?> cast() {
    return this;
  }

  @Override
  StreamingRead newRead(long readId, RetryContext retryContext) {
    return ObjectReadSessionStreamRead.streamingRead(readId, range, hasher, retryContext);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof ReadAsChannel)) {
      return false;
    }
    ReadAsChannel that = (ReadAsChannel) o;
    return Objects.equals(range, that.range) && Objects.equals(hasher, that.hasher);
  }

  @Override
  public int hashCode() {
    return Objects.hash(range, hasher);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("range", range)
        .add("crc32cValidationEnabled", getCrc32cValidationEnabled())
        .toString();
  }
}
