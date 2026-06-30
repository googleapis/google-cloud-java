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

import static java.util.Objects.requireNonNull;

import com.google.api.core.ApiFuture;
import com.google.api.core.SettableApiFuture;
import com.google.api.services.storage.model.StorageObject;
import com.google.cloud.storage.ChannelSession.BufferedWriteSession;
import com.google.cloud.storage.ChannelSession.UnbufferedWriteSession;
import com.google.cloud.storage.Retrying.RetrierWithAlg;
import com.google.cloud.storage.UnbufferedWritableByteChannelSession.UnbufferedWritableByteChannel;
import java.nio.ByteBuffer;
import java.util.function.BiFunction;
import java.util.function.LongConsumer;
import org.checkerframework.checker.nullness.qual.NonNull;

final class HttpWritableByteChannelSessionBuilder {

  private static final int DEFAULT_BUFFER_CAPACITY = ByteSizeConstants._16MiB;
  @NonNull private final HttpClientContext httpClientContext;

  HttpWritableByteChannelSessionBuilder(@NonNull HttpClientContext httpClientContext) {
    this.httpClientContext =
        requireNonNull(httpClientContext, "httpClientContext must be non null");
  }

  /**
   * The build {@link WritableByteChannelSession} will perform a "Resumable" upload.
   *
   * <p>A "Resumable" upload will sync the transmitted data with GCS upon each individual flush and
   * when the channel is closed.
   *
   * <p>If an error is returned the individual flush can be transparently retried.
   */
  ResumableUploadBuilder resumable() {
    return new ResumableUploadBuilder(httpClientContext);
  }

  static final class ResumableUploadBuilder {

    @NonNull private final HttpClientContext httpClientContext;
    private RetrierWithAlg retrier;
    private LongConsumer committedBytesCallback;
    private Hasher hasher;

    ResumableUploadBuilder(@NonNull HttpClientContext httpClientContext) {
      this.httpClientContext = httpClientContext;
      this.retrier = RetrierWithAlg.attemptOnce();
      this.committedBytesCallback = l -> {};
      this.hasher = Hasher.defaultHasher();
    }

    ResumableUploadBuilder setCommittedBytesCallback(@NonNull LongConsumer committedBytesCallback) {
      this.committedBytesCallback =
          requireNonNull(committedBytesCallback, "committedBytesCallback must be non null");
      return this;
    }

    ResumableUploadBuilder withRetryConfig(@NonNull RetrierWithAlg retrier) {
      this.retrier = requireNonNull(retrier, "retrier must be non null");
      return this;
    }

    ResumableUploadBuilder setHasher(@NonNull Hasher hasher) {
      this.hasher = requireNonNull(hasher, "hasher must be non null");
      return this;
    }

    /**
     * Do not apply any intermediate buffering. Any call to {@link
     * java.nio.channels.WritableByteChannel#write(ByteBuffer)} will be segmented as is and sent to
     * GCS.
     *
     * <p>Note: this is considered an advanced API, and should not be used in circumstances in which
     * control of {@link ByteBuffer}s sent to {@code write} is not self-contained.
     */
    UnbufferedResumableUploadBuilder unbuffered() {
      return new UnbufferedResumableUploadBuilder();
    }

    /** Buffer up to {@link #DEFAULT_BUFFER_CAPACITY} worth of bytes before attempting to flush */
    BufferedResumableUploadBuilder buffered() {
      return buffered(BufferHandle.allocate(DEFAULT_BUFFER_CAPACITY));
    }

    /**
     * Buffer using {@code byteBuffer} worth of space before attempting to flush.
     *
     * <p>The provided {@link ByteBuffer} <i>should</i> be aligned with GCSs block size of <a
     * target="_blank" rel="noopener noreferrer"
     * href="https://cloud.google.com/storage/docs/performing-resumable-uploads#chunked-upload">256
     * KiB</a>.
     */
    BufferedResumableUploadBuilder buffered(ByteBuffer byteBuffer) {
      return buffered(BufferHandle.handleOf(byteBuffer));
    }

    BufferedResumableUploadBuilder buffered(BufferHandle bufferHandle) {
      return new BufferedResumableUploadBuilder(bufferHandle);
    }

    private BiFunction<
            JsonResumableWrite, SettableApiFuture<StorageObject>, UnbufferedWritableByteChannel>
        bindFunction() {
      // it is theoretically possible that the setter methods for the following variables could
      // be called again between when this method is invoked and the resulting function is invoked.
      // To ensure we are using the specified values at the point in time they are bound to the
      // function read them into local variables which will be closed over rather than the class
      // fields.
      RetrierWithAlg boundRetrier = retrier;
      return (start, resultFuture) ->
          new ApiaryUnbufferedWritableByteChannel(
              httpClientContext, boundRetrier, start, resultFuture, committedBytesCallback);
    }

    final class UnbufferedResumableUploadBuilder {

      private ApiFuture<JsonResumableWrite> start;

      /**
       * Set the Future which will contain the ResumableWrite information necessary to open the
       * Write stream.
       */
      UnbufferedResumableUploadBuilder setStartAsync(ApiFuture<JsonResumableWrite> start) {
        this.start = requireNonNull(start, "start must be non null");
        return this;
      }

      UnbufferedWritableByteChannelSession<StorageObject> build() {
        return new UnbufferedWriteSession<>(
            requireNonNull(start, "start must be non null"),
            bindFunction().andThen(StorageByteChannels.writable()::createSynchronized));
      }
    }

    final class BufferedResumableUploadBuilder {

      private final BufferHandle bufferHandle;

      private ApiFuture<JsonResumableWrite> start;

      BufferedResumableUploadBuilder(BufferHandle bufferHandle) {
        this.bufferHandle = bufferHandle;
      }

      /**
       * Set the Future which will contain the ResumableWrite information necessary to open the
       * Write stream.
       */
      BufferedResumableUploadBuilder setStartAsync(ApiFuture<JsonResumableWrite> start) {
        this.start = requireNonNull(start, "start must be non null");
        return this;
      }

      BufferedWritableByteChannelSession<StorageObject> build() {
        return new BufferedWriteSession<>(
            requireNonNull(start, "start must be non null"),
            bindFunction()
                .andThen(c -> new DefaultBufferedWritableByteChannel(bufferHandle, c))
                .andThen(StorageByteChannels.writable()::createSynchronized));
      }
    }
  }
}
