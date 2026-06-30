/*
 * Copyright 2022 Google LLC
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
import com.google.api.core.ApiFutures;
import com.google.api.core.InternalApi;
import com.google.api.core.SettableApiFuture;
import com.google.api.gax.retrying.ResultRetryAlgorithm;
import com.google.api.gax.rpc.ClientStreamingCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.storage.ChannelSession.BufferedWriteSession;
import com.google.cloud.storage.ChannelSession.UnbufferedWriteSession;
import com.google.cloud.storage.Retrying.Retrier;
import com.google.cloud.storage.Retrying.RetrierWithAlg;
import com.google.cloud.storage.UnbufferedWritableByteChannelSession.UnbufferedWritableByteChannel;
import com.google.cloud.storage.WriteCtx.WriteObjectRequestBuilderFactory;
import com.google.storage.v2.QueryWriteStatusRequest;
import com.google.storage.v2.QueryWriteStatusResponse;
import com.google.storage.v2.ServiceConstants.Values;
import com.google.storage.v2.WriteObjectRequest;
import com.google.storage.v2.WriteObjectResponse;
import java.nio.ByteBuffer;
import java.util.function.BiFunction;
import org.checkerframework.checker.nullness.qual.NonNull;

final class GapicWritableByteChannelSessionBuilder {

  private static final int DEFAULT_BUFFER_CAPACITY = ByteSizeConstants._16MiB;
  private final ClientStreamingCallable<WriteObjectRequest, WriteObjectResponse> write;
  private Hasher hasher;
  private ByteStringStrategy byteStringStrategy;

  GapicWritableByteChannelSessionBuilder(
      ClientStreamingCallable<WriteObjectRequest, WriteObjectResponse> write) {
    this.write = write;
    this.hasher = Hasher.defaultHasher();
    this.byteStringStrategy = ByteStringStrategy.copy();
  }

  /**
   * Set the {@link Hasher} to apply to the bytes passing through the built session's channel.
   *
   * <p>Default: {@link Hasher#defaultHasher()}
   *
   * @see Hasher#enabled()
   * @see Hasher#noop()
   */
  GapicWritableByteChannelSessionBuilder setHasher(Hasher hasher) {
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
  GapicWritableByteChannelSessionBuilder setByteStringStrategy(
      ByteStringStrategy byteStringStrategy) {
    this.byteStringStrategy =
        requireNonNull(byteStringStrategy, "byteStringStrategy must be non null");
    return this;
  }

  /**
   * The built {@link WritableByteChannelSession} will perform a "Direct" upload.
   *
   * <p>A "Direct" upload will only sync the transmitted data with GCS when the channel is closed.
   * If an error is returned the entire upload will need to be attempted again.
   */
  DirectUploadBuilder direct() {
    return new DirectUploadBuilder();
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
    return new ResumableUploadBuilder();
  }

  JournalingResumableUploadBuilder journaling() {
    return new JournalingResumableUploadBuilder();
  }

  private @NonNull ChunkSegmenter getChunkSegmenter() {
    // it is theoretically possible that the setter methods for the following variables could
    // be called again between when this method is invoked and the resulting function is invoked.
    // To ensure we are using the specified values at the point in time they are bound to the
    // function read them into local variables which will be closed over rather than the class
    // fields.
    ByteStringStrategy boundStrategy = byteStringStrategy;
    Hasher boundHasher = hasher;
    return new ChunkSegmenter(boundHasher, boundStrategy, Values.MAX_WRITE_CHUNK_BYTES_VALUE);
  }

  private static <StartT>
      BiFunction<StartT, SettableApiFuture<WriteObjectResponse>, UnbufferedWritableByteChannel>
          lift(
              BiFunction<
                      StartT, SettableApiFuture<WriteObjectResponse>, UnbufferedWritableByteChannel>
                  func) {
    return func;
  }

  final class DirectUploadBuilder {

    /**
     * Do not apply any intermediate buffering. Any call to {@link
     * java.nio.channels.WritableByteChannel#write(ByteBuffer)} will be segmented as is and sent to
     * GCS.
     *
     * <p>Note: this is considered an advanced API, and should not be used in circumstances in which
     * control of {@link ByteBuffer}s sent to {@code write} is not self-contained.
     */
    UnbufferedDirectUploadBuilder unbuffered() {
      return new UnbufferedDirectUploadBuilder();
    }

    /** Buffer up to {@link #DEFAULT_BUFFER_CAPACITY} worth of bytes before attempting to flush */
    BufferedDirectUploadBuilder buffered() {
      return buffered(BufferHandle.allocate(DEFAULT_BUFFER_CAPACITY));
    }

    /**
     * Buffer using {@code byteBuffer} worth of space before attempting to flush.
     *
     * <p>The provided {@link ByteBuffer} <i>should</i> be aligned with GCSs block size of <a
     * target="_blank"
     * href="https://cloud.google.com/storage/docs/performing-resumable-uploads#chunked-upload">256
     * KiB</a> if mu
     */
    BufferedDirectUploadBuilder buffered(ByteBuffer byteBuffer) {
      return buffered(BufferHandle.handleOf(byteBuffer));
    }

    BufferedDirectUploadBuilder buffered(BufferHandle bufferHandle) {
      return new BufferedDirectUploadBuilder(bufferHandle);
    }

    final class UnbufferedDirectUploadBuilder {

      private WriteObjectRequest req;

      /** Specify the {@link WriteObjectRequest} which will be used to start the Write stream. */
      UnbufferedDirectUploadBuilder setRequest(WriteObjectRequest req) {
        this.req = requireNonNull(req, "req must be non null");
        return this;
      }

      UnbufferedWritableByteChannelSession<WriteObjectResponse> build() {
        ChunkSegmenter chunkSegmenter = getChunkSegmenter();
        return new UnbufferedWriteSession<>(
            ApiFutures.immediateFuture(requireNonNull(req, "req must be non null")),
            lift((WriteObjectRequest start, SettableApiFuture<WriteObjectResponse> resultFuture) ->
                    new GapicUnbufferedDirectWritableByteChannel(
                        resultFuture,
                        chunkSegmenter,
                        write,
                        WriteCtx.of(
                            WriteObjectRequestBuilderFactory.simple(start),
                            chunkSegmenter.getHasher())))
                .andThen(StorageByteChannels.writable()::createSynchronized));
      }
    }

    final class BufferedDirectUploadBuilder {

      private final BufferHandle bufferHandle;
      private WriteObjectRequest req;

      BufferedDirectUploadBuilder(BufferHandle bufferHandle) {
        this.bufferHandle = bufferHandle;
      }

      /** Specify the {@link WriteObjectRequest} which will be used to start the Write stream. */
      BufferedDirectUploadBuilder setRequest(WriteObjectRequest req) {
        this.req = requireNonNull(req, "req must be non null");
        return this;
      }

      BufferedWritableByteChannelSession<WriteObjectResponse> build() {
        ChunkSegmenter chunkSegmenter = getChunkSegmenter();
        return new BufferedWriteSession<>(
            ApiFutures.immediateFuture(requireNonNull(req, "req must be non null")),
            lift((WriteObjectRequest start, SettableApiFuture<WriteObjectResponse> resultFuture) ->
                    new GapicUnbufferedDirectWritableByteChannel(
                        resultFuture,
                        chunkSegmenter,
                        write,
                        WriteCtx.of(
                            WriteObjectRequestBuilderFactory.simple(start),
                            chunkSegmenter.getHasher())))
                .andThen(c -> new DefaultBufferedWritableByteChannel(bufferHandle, c))
                .andThen(StorageByteChannels.writable()::createSynchronized));
      }
    }
  }

  final class ResumableUploadBuilder {

    private RetrierWithAlg retrier;
    private boolean fsyncEvery;

    ResumableUploadBuilder() {
      this.retrier = RetrierWithAlg.attemptOnce();
      this.fsyncEvery = true;
    }

    ResumableUploadBuilder withRetryConfig(RetrierWithAlg retrier) {
      this.retrier = requireNonNull(retrier, "deps must be non null");
      return this;
    }

    @InternalApi
    ResumableUploadBuilder setFsyncEvery(boolean fsyncEvery) {
      this.fsyncEvery = fsyncEvery;
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

    final class UnbufferedResumableUploadBuilder {

      private ApiFuture<ResumableWrite> start;

      /**
       * Set the Future which will contain the ResumableWrite information necessary to open the
       * Write stream.
       */
      UnbufferedResumableUploadBuilder setStartAsync(ApiFuture<ResumableWrite> start) {
        this.start = requireNonNull(start, "start must be non null");
        return this;
      }

      UnbufferedWritableByteChannelSession<WriteObjectResponse> build() {
        RetrierWithAlg boundRetrier = retrier;
        ChunkSegmenter chunkSegmenter = getChunkSegmenter();
        return new UnbufferedWriteSession<>(
            requireNonNull(start, "start must be non null"),
            lift((ResumableWrite start, SettableApiFuture<WriteObjectResponse> result) -> {
                  if (fsyncEvery) {
                    return new GapicUnbufferedChunkedResumableWritableByteChannel(
                        result,
                        chunkSegmenter,
                        write,
                        WriteCtx.of(start, chunkSegmenter.getHasher()),
                        boundRetrier,
                        Retrying::newCallContext);
                  } else {
                    return new GapicUnbufferedFinalizeOnCloseResumableWritableByteChannel(
                        result,
                        chunkSegmenter,
                        write,
                        WriteCtx.of(start, chunkSegmenter.getHasher()));
                  }
                })
                .andThen(StorageByteChannels.writable()::createSynchronized));
      }
    }

    final class BufferedResumableUploadBuilder {

      private final BufferHandle bufferHandle;

      private ApiFuture<ResumableWrite> start;

      BufferedResumableUploadBuilder(BufferHandle bufferHandle) {
        this.bufferHandle = bufferHandle;
      }

      /**
       * Set the Future which will contain the ResumableWrite information necessary to open the
       * Write stream.
       */
      BufferedResumableUploadBuilder setStartAsync(ApiFuture<ResumableWrite> start) {
        this.start = requireNonNull(start, "start must be non null");
        return this;
      }

      BufferedWritableByteChannelSession<WriteObjectResponse> build() {
        ChunkSegmenter chunkSegmenter = getChunkSegmenter();
        return new BufferedWriteSession<>(
            requireNonNull(start, "start must be non null"),
            lift((ResumableWrite start, SettableApiFuture<WriteObjectResponse> result) -> {
                  if (fsyncEvery) {
                    return new GapicUnbufferedChunkedResumableWritableByteChannel(
                        result,
                        chunkSegmenter,
                        write,
                        WriteCtx.of(start, chunkSegmenter.getHasher()),
                        retrier,
                        Retrying::newCallContext);
                  } else {
                    return new GapicUnbufferedFinalizeOnCloseResumableWritableByteChannel(
                        result,
                        chunkSegmenter,
                        write,
                        WriteCtx.of(start, chunkSegmenter.getHasher()));
                  }
                })
                .andThen(c -> new DefaultBufferedWritableByteChannel(bufferHandle, c))
                .andThen(StorageByteChannels.writable()::createSynchronized));
      }
    }
  }

  final class JournalingResumableUploadBuilder {

    private Retrier retrier;
    private ResultRetryAlgorithm<?> alg;
    private BufferHandle bufferHandle;
    private BufferHandle recoveryBuffer;
    private RecoveryFile recoveryFile;
    private UnaryCallable<QueryWriteStatusRequest, QueryWriteStatusResponse> query;

    JournalingResumableUploadBuilder() {
      this.retrier = Retrier.attemptOnce();
      this.alg = Retrying.neverRetry();
    }

    JournalingResumableUploadBuilder withRetryConfig(
        Retrier retrier,
        ResultRetryAlgorithm<?> alg,
        UnaryCallable<QueryWriteStatusRequest, QueryWriteStatusResponse> query) {
      this.retrier = requireNonNull(retrier, "retrier must be non null");
      this.alg = requireNonNull(alg, "alg must be non null");
      this.query = requireNonNull(query, "query must be non null");
      return this;
    }

    JournalingResumableUploadBuilder withBuffer(BufferHandle bufferHandle) {
      this.bufferHandle = requireNonNull(bufferHandle, "bufferHandle must be non null");
      return this;
    }

    JournalingResumableUploadBuilder withRecoveryBuffer(BufferHandle bufferHandle) {
      this.recoveryBuffer = requireNonNull(bufferHandle, "bufferHandle must be non null");
      return this;
    }

    JournalingResumableUploadBuilder withRecoveryFile(RecoveryFile recoveryFile) {
      this.recoveryFile = requireNonNull(recoveryFile, "recoveryFile must be non null");
      return this;
    }

    /**
     * Set the Future which will contain the ResumableWrite information necessary to open the Write
     * stream.
     */
    BuildableJournalingResumableUploadBuilder setStartAsync(
        ApiFuture<WriteCtx<ResumableWrite>> start) {
      requireNonNull(start, "start must be non null");
      return new BuildableJournalingResumableUploadBuilder(start);
    }

    final class BuildableJournalingResumableUploadBuilder {
      private final ApiFuture<WriteCtx<ResumableWrite>> start;

      private BuildableJournalingResumableUploadBuilder(ApiFuture<WriteCtx<ResumableWrite>> start) {
        this.start = start;
      }

      BufferedWritableByteChannelSession<WriteObjectResponse> build() {
        return new BufferedWriteSession<>(
            requireNonNull(start, "start must be non null"),
            bindFunction()
                .andThen(c -> new DefaultBufferedWritableByteChannel(bufferHandle, c))
                .andThen(StorageByteChannels.writable()::createSynchronized));
      }

      private BiFunction<
              WriteCtx<ResumableWrite>,
              SettableApiFuture<WriteObjectResponse>,
              UnbufferedWritableByteChannel>
          bindFunction() {
        // it is theoretically possible that the setter methods for the following variables could
        // be called again between when this method is invoked and the resulting function is
        // invoked.
        // To ensure we are using the specified values at the point in time they are bound to the
        // function read them into local variables which will be closed over rather than the class
        // fields.
        Retrier boundRetrier = JournalingResumableUploadBuilder.this.retrier;
        ResultRetryAlgorithm<?> alg = JournalingResumableUploadBuilder.this.alg;
        BufferHandle recoveryBuffer = JournalingResumableUploadBuilder.this.recoveryBuffer;
        RecoveryFile recoveryFile = JournalingResumableUploadBuilder.this.recoveryFile;
        UnaryCallable<QueryWriteStatusRequest, QueryWriteStatusResponse> query =
            JournalingResumableUploadBuilder.this.query;
        ByteStringStrategy boundStrategy = byteStringStrategy;
        Hasher boundHasher = hasher;
        return (writeCtx, resultFuture) ->
            new SyncAndUploadUnbufferedWritableByteChannel(
                write,
                query,
                resultFuture,
                new ChunkSegmenter(boundHasher, boundStrategy, Values.MAX_WRITE_CHUNK_BYTES_VALUE),
                boundRetrier,
                alg,
                writeCtx,
                recoveryFile,
                recoveryBuffer);
      }
    }
  }
}
