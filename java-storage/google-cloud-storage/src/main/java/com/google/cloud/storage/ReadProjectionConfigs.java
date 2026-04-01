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

import com.google.api.core.ApiFuture;
import com.google.api.core.BetaApi;
import com.google.cloud.storage.Storage.BlobSourceOption;
import com.google.cloud.storage.ZeroCopySupport.DisposableByteString;
import java.nio.channels.ScatteringByteChannel;
import java.nio.channels.SeekableByteChannel;

/**
 * Factory class to select {@link ReadProjectionConfig}s.
 *
 * <p>There are multiple projections which can be used to access the content of a {@link BlobInfo}
 * in Google Cloud Storage.
 *
 * @see Storage#blobReadSession(BlobId, BlobSourceOption...)
 * @see BlobReadSession
 * @see ReadProjectionConfig
 * @since 2.51.0 This new api is in preview and is subject to breaking changes.
 */
@BetaApi
public final class ReadProjectionConfigs {

  private ReadProjectionConfigs() {}

  abstract static class BaseConfig<Projection, Read extends ObjectReadSessionStreamRead<Projection>>
      extends ReadProjectionConfig<Projection> {

    BaseConfig() {}

    abstract Read newRead(long readId, RetryContext retryContext);

    @Override
    ProjectionType getType() {
      return ProjectionType.STREAM_READ;
    }
  }

  /**
   * Read a range as a non-blocking {@link ScatteringByteChannel}.
   *
   * <p>The returned channel will be non-blocking for all read calls. If bytes have not yet
   * asynchronously been delivered from Google Cloud Storage the method will return rather than
   * waiting for the bytes to arrive.
   *
   * <p>The resulting {@link ScatteringByteChannel} MUST be {@link ScatteringByteChannel#close()
   * close()}ed to avoid leaking memory
   *
   * @see ReadAsChannel
   * @see ScatteringByteChannel
   * @since 2.51.0 This new api is in preview and is subject to breaking changes.
   */
  @BetaApi
  public static ReadAsChannel asChannel() {
    return ReadAsChannel.INSTANCE;
  }

  /**
   * Read a range of {@code byte}s as an {@link ApiFuture}{@code <byte[]>}
   *
   * <p>The entire range will be accumulated in memory before the future will resolve.
   *
   * <p>If you do not want the entire range accumulated in memory, please use one of the other
   * {@link ReadProjectionConfig}s available.
   *
   * @see ApiFuture
   * @since 2.51.0 This new api is in preview and is subject to breaking changes.
   */
  @BetaApi
  public static ReadAsFutureBytes asFutureBytes() {
    return ReadAsFutureBytes.INSTANCE;
  }

  /**
   * Read a range of {@code byte}s as an {@link ApiFuture}{@code <}{@link
   * DisposableByteString}{@code >}
   *
   * <p>The resulting {@link DisposableByteString} MUST be {@link DisposableByteString#close()
   * close()}ed to avoid leaking memory
   *
   * <p>The entire range will be accumulated in memory before the future will resolve.
   *
   * <p>If you do not want the entire range accumulated in memory, please use one of the other
   * {@link ReadProjectionConfig}s available.
   *
   * @see ApiFuture
   * @see com.google.protobuf.ByteString
   * @since 2.51.0 This new api is in preview and is subject to breaking changes.
   */
  @BetaApi
  public static ReadAsFutureByteString asFutureByteString() {
    return ReadAsFutureByteString.INSTANCE;
  }

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
   * @see SeekableByteChannel
   * @since 2.51.0 This new api is in preview and is subject to breaking changes.
   */
  @BetaApi
  public static ReadAsSeekableChannel asSeekableChannel() {
    return ReadAsSeekableChannel.INSTANCE;
  }
}
