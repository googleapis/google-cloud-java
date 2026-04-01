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
import com.google.api.gax.rpc.BidiStreamingCallable;
import com.google.cloud.storage.ChannelSession.BufferedWriteSession;
import com.google.cloud.storage.Retrying.RetrierWithAlg;
import com.google.cloud.storage.UnbufferedWritableByteChannelSession.UnbufferedWritableByteChannel;
import com.google.storage.v2.BidiWriteObjectRequest;
import com.google.storage.v2.BidiWriteObjectResponse;
import com.google.storage.v2.ServiceConstants.Values;
import java.nio.ByteBuffer;
import java.util.function.BiFunction;

final class GapicBidiWritableByteChannelSessionBuilder {

  private final BidiStreamingCallable<BidiWriteObjectRequest, BidiWriteObjectResponse> write;
  private Hasher hasher;
  private ByteStringStrategy byteStringStrategy;

  GapicBidiWritableByteChannelSessionBuilder(
      BidiStreamingCallable<BidiWriteObjectRequest, BidiWriteObjectResponse> write) {
    this.write = write;
    this.hasher = Hasher.noop();
    this.byteStringStrategy = ByteStringStrategy.copy();
  }

  /**
   * Set the {@link Hasher} to apply to the bytes passing through the built session's channel.
   *
   * <p>Default: {@link Hasher#noop()}
   *
   * @see Hasher#enabled()
   * @see Hasher#noop()
   */
  GapicBidiWritableByteChannelSessionBuilder setHasher(Hasher hasher) {
    this.hasher = requireNonNull(hasher, "hasher must be non null");
    return this;
  }

  /**
   * Set the {@link ByteStringStrategy} to be used when constructing {@link
   * com.google.protobuf.ByteString ByteString}s from {@link ByteBuffer}s.
   *
   * <p>Default: {@link ByteStringStrategy#copy()}
   *
   * <p>Note: usage of {@link ByteStringStrategy#noCopy()} requires that any {@link ByteBuffer}
   * passed to the session's channel not be modified while {@link
   * java.nio.channels.WritableByteChannel#write(ByteBuffer)} is processing.
   *
   * @see ByteStringStrategy#copy()
   * @see ByteStringStrategy#noCopy()
   */
  GapicBidiWritableByteChannelSessionBuilder setByteStringStrategy(
      ByteStringStrategy byteStringStrategy) {
    this.byteStringStrategy =
        requireNonNull(byteStringStrategy, "byteStringStrategy must be non null");
    return this;
  }

  GapicBidiWritableByteChannelSessionBuilder.ResumableUploadBuilder resumable() {
    return new GapicBidiWritableByteChannelSessionBuilder.ResumableUploadBuilder();
  }

  final class ResumableUploadBuilder {

    private RetrierWithAlg retrier;

    ResumableUploadBuilder() {
      this.retrier = RetrierWithAlg.attemptOnce();
    }

    ResumableUploadBuilder withRetryConfig(RetrierWithAlg retrier) {
      this.retrier = requireNonNull(retrier, "retrier must be non null");
      return this;
    }

    /**
     * Buffer using {@code byteBuffer} worth of space before attempting to flush.
     *
     * <p>The provided {@link ByteBuffer} <i>should</i> be aligned with GCSs block size of <a
     * target="_blank"
     * href="https://cloud.google.com/storage/docs/performing-resumable-uploads#chunked-upload">256
     * KiB</a>.
     */
    BufferedResumableUploadBuilder buffered(ByteBuffer byteBuffer) {
      return buffered(BufferHandle.handleOf(byteBuffer));
    }

    BufferedResumableUploadBuilder buffered(BufferHandle bufferHandle) {
      return new BufferedResumableUploadBuilder(bufferHandle);
    }

    final class BufferedResumableUploadBuilder {

      private final BufferHandle bufferHandle;

      private ApiFuture<BidiResumableWrite> start;

      BufferedResumableUploadBuilder(BufferHandle bufferHandle) {
        this.bufferHandle = bufferHandle;
      }

      /**
       * Set the Future which will contain the ResumableWrite information necessary to open the
       * Write stream.
       */
      BufferedResumableUploadBuilder setStartAsync(ApiFuture<BidiResumableWrite> start) {
        this.start = requireNonNull(start, "start must be non null");
        return this;
      }

      BufferedWritableByteChannelSession<BidiWriteObjectResponse> build() {
        // it is theoretically possible that the setter methods for the following variables could
        // be called again between when this method is invoked and the resulting function is
        // invoked.
        // To ensure we are using the specified values at the point in time they are bound to the
        // function read them into local variables which will be closed over rather than the class
        // fields.
        ByteStringStrategy boundStrategy = byteStringStrategy;
        Hasher boundHasher = hasher;
        RetrierWithAlg boundRetrier = retrier;
        return new BufferedWriteSession<>(
            requireNonNull(start, "start must be non null"),
            ((BiFunction<
                        BidiResumableWrite,
                        SettableApiFuture<BidiWriteObjectResponse>,
                        UnbufferedWritableByteChannel>)
                    (start, resultFuture) ->
                        new GapicBidiUnbufferedWritableByteChannel(
                            write,
                            boundRetrier,
                            resultFuture,
                            new ChunkSegmenter(
                                boundHasher, boundStrategy, Values.MAX_WRITE_CHUNK_BYTES_VALUE),
                            new BidiWriteCtx<>(start),
                            Retrying::newCallContext))
                .andThen(c -> new DefaultBufferedWritableByteChannel(bufferHandle, c))
                .andThen(StorageByteChannels.writable()::createSynchronized));
      }
    }
  }
}
