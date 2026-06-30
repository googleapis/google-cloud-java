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

import static com.google.cloud.storage.GrpcUtils.contextWithBucketName;

import com.google.api.core.SettableApiFuture;
import com.google.api.gax.grpc.GrpcCallContext;
import com.google.api.gax.grpc.GrpcStatusCode;
import com.google.api.gax.retrying.ResultRetryAlgorithm;
import com.google.api.gax.retrying.TimedAttemptSettings;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.ApiStreamObserver;
import com.google.api.gax.rpc.ClientStreamingCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.storage.ChunkSegmenter.ChunkSegment;
import com.google.cloud.storage.Conversions.Decoder;
import com.google.cloud.storage.Crc32cValue.Crc32cLengthKnown;
import com.google.cloud.storage.Retrying.Retrier;
import com.google.cloud.storage.UnbufferedWritableByteChannelSession.UnbufferedWritableByteChannel;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.protobuf.ByteString;
import com.google.storage.v2.ChecksummedData;
import com.google.storage.v2.Object;
import com.google.storage.v2.ObjectChecksums;
import com.google.storage.v2.QueryWriteStatusRequest;
import com.google.storage.v2.QueryWriteStatusResponse;
import com.google.storage.v2.WriteObjectRequest;
import com.google.storage.v2.WriteObjectResponse;
import io.grpc.Status.Code;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.GatheringByteChannel;
import java.nio.channels.SeekableByteChannel;
import java.util.Arrays;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

final class SyncAndUploadUnbufferedWritableByteChannel implements UnbufferedWritableByteChannel {

  private final ClientStreamingCallable<WriteObjectRequest, WriteObjectResponse> write;
  private final UnaryCallable<QueryWriteStatusRequest, QueryWriteStatusResponse> query;
  private final SettableApiFuture<WriteObjectResponse> resultFuture;
  private final ChunkSegmenter chunkSegmenter;
  private final WriteCtx<ResumableWrite> writeCtx;
  private final Retrier retrier;
  private final ResultRetryAlgorithm<?> alg;
  private final RecoveryFile rf;

  private final String uploadId;
  private final BufferHandle copyBuffer;

  /* --- running state --- */
  private final RequestStream stream;

  private boolean open;
  private @Nullable GatheringByteChannel sync;
  private boolean first;
  private boolean finished;

  SyncAndUploadUnbufferedWritableByteChannel(
      ClientStreamingCallable<WriteObjectRequest, WriteObjectResponse> write,
      UnaryCallable<QueryWriteStatusRequest, QueryWriteStatusResponse> query,
      SettableApiFuture<WriteObjectResponse> resultFuture,
      ChunkSegmenter chunkSegmenter,
      Retrier retrier,
      ResultRetryAlgorithm<?> alg,
      WriteCtx<ResumableWrite> writeCtx,
      RecoveryFile rf,
      BufferHandle copyBuffer) {
    this.write =
        write.withDefaultCallContext(
            contextWithBucketName(
                writeCtx.getRequestFactory().bucketName(), GrpcCallContext.createDefault()));
    this.query = query;
    this.resultFuture = resultFuture;
    this.chunkSegmenter = chunkSegmenter;
    this.writeCtx = writeCtx;
    this.retrier = retrier;
    this.alg = new Alg(alg, resultFuture);
    this.rf = rf;
    this.uploadId = writeCtx.newRequestBuilder().getUploadId();
    this.copyBuffer = copyBuffer;
    this.stream = new RequestStream(this.write, resultFuture);
    this.open = true;
    this.first = true;
    this.finished = false;
  }

  @SuppressWarnings("resource")
  @Override
  public long write(ByteBuffer[] srcs, int offset, int length) throws IOException {
    if (!open) {
      throw new ClosedChannelException();
    }
    ByteBuffer[] duplicates =
        Arrays.stream(srcs, offset, offset + length)
            .map(ByteBuffer::duplicate)
            .toArray(ByteBuffer[]::new);
    long prevWritten = writeCtx.getTotalSentBytes().get();
    long syncWritten = openSync().write(duplicates);
    long goalSize = Math.addExact(prevWritten, syncWritten);
    ChunkSegment[] segments = chunkSegmenter.segmentBuffers(srcs, offset, length);
    doUpload(false, segments, goalSize);
    return syncWritten;
  }

  @Override
  public boolean isOpen() {
    return open;
  }

  @Override
  public void close() throws IOException {
    if (!open) {
      return;
    }
    try {
      doUpload(true, new ChunkSegment[0], writeCtx.getTotalSentBytes().get());
      rf.close();
    } finally {
      open = false;
    }
  }

  private GatheringByteChannel openSync() throws IOException {
    if (sync == null) {
      sync = rf.syncingChannel();
    }
    return sync;
  }

  private WriteObjectRequest processSegment(ChunkSegment segment, boolean updateCumulativeCrc32c) {
    WriteObjectRequest.Builder builder = writeCtx.newRequestBuilder();
    if (!first) {
      builder.clearUploadId().clearWriteObjectSpec().clearObjectChecksums();
    } else {
      first = false;
    }

    Crc32cLengthKnown crc32c = segment.getCrc32c();
    ByteString b = segment.getB();
    int contentSize = b.size();

    // update ctx state that tracks overall progress
    if (updateCumulativeCrc32c) {
      writeCtx
          .getCumulativeCrc32c()
          .accumulateAndGet(crc32c, chunkSegmenter.getHasher()::nullSafeConcat);
    }
    // resolve current offset and set next
    long offset = writeCtx.getTotalSentBytes().getAndAdd(contentSize);

    ChecksummedData.Builder checksummedData = ChecksummedData.newBuilder().setContent(b);
    if (crc32c != null) {
      checksummedData.setCrc32C(crc32c.getValue());
    }
    builder.setWriteOffset(offset).setChecksummedData(checksummedData.build());

    if (!segment.isOnlyFullBlocks()) {
      finishMessage(builder);
      finished = true;
    }

    WriteObjectRequest build = builder.build();
    return build;
  }

  @NonNull
  private WriteObjectRequest finishMessage() {
    long offset = writeCtx.getTotalSentBytes().get();

    WriteObjectRequest.Builder b = writeCtx.newRequestBuilder().setWriteOffset(offset);

    WriteObjectRequest message = finishMessage(b).build();
    return message;
  }

  private WriteObjectRequest.Builder finishMessage(WriteObjectRequest.Builder b) {
    Crc32cLengthKnown crc32cValue = writeCtx.getCumulativeCrc32c().get();
    b.setFinishWrite(true);
    if (crc32cValue != null) {
      b.setObjectChecksums(ObjectChecksums.newBuilder().setCrc32C(crc32cValue.getValue()).build());
    }
    return b;
  }

  @SuppressWarnings("ConstantValue")
  private void doUpload(boolean closing, ChunkSegment[] segments, long goalSize) {
    AtomicBoolean recover = new AtomicBoolean(false);
    retrier.run(
        alg,
        () -> {
          if (closing && sync != null) {
            sync.close();
          }
          boolean shouldRecover = recover.getAndSet(true);
          // each ChunkSegment will always have its checksum computed, but if a retry happens, and
          // we need to rewind and build a new ChunkSegment, we don't want to add it to the
          // cumulativeCrc32c value because that will make it appear as the bytes are duplicated.
          // If we send "ABCD", get an error and find only "AB" to have been persisted, we don't
          // want to add "CD" to the cumulative crc32c as that would be equivalent to "ABCDCD".
          boolean updateCumulativeCrc32c = !shouldRecover;
          if (!shouldRecover) {
            for (ChunkSegment segment : segments) {
              WriteObjectRequest writeObjectRequest =
                  processSegment(segment, updateCumulativeCrc32c);
              stream.onNext(writeObjectRequest);
            }

            if (closing && !finished) {
              WriteObjectRequest message = finishMessage();
              stream.onNext(message);
              finished = true;
            }

            if (closing) {
              stream.onCompleted();
            }
          } else {
            if (sync != null) {
              sync.close();
              sync = null;
            }
            stream.reset();

            QueryWriteStatusRequest req =
                QueryWriteStatusRequest.newBuilder().setUploadId(uploadId).build();
            QueryWriteStatusResponse resp = query.call(req);
            // if the response has a resource the session completed, no need to re-upload
            if (!resp.hasResource()) {
              long persistedSize = resp.getPersistedSize();

              if (persistedSize != goalSize) {

                // rewind our context
                finished = false;
                first = true;
                writeCtx.getTotalSentBytes().set(persistedSize);
                writeCtx.getConfirmedBytes().set(persistedSize);
                // intentionally do not modify the cumulativeCrc32c value
                // this will stay in the state in sync with what has been written to disk
                // when we recover, checksum the individual message but not the cumulative

                try (SeekableByteChannel reader = rf.reader()) {
                  reader.position(persistedSize);
                  ByteBuffer buf = copyBuffer.get();
                  // clear before read, in case an error was thrown before
                  buf.clear();
                  while (Buffers.fillFrom(buf, reader) != -1) {
                    buf.flip();
                    while (buf.hasRemaining()) {
                      ChunkSegment[] recoverySegments = chunkSegmenter.segmentBuffer(buf);
                      for (ChunkSegment segment : recoverySegments) {
                        WriteObjectRequest writeObjectRequest =
                            processSegment(segment, updateCumulativeCrc32c);
                        stream.onNext(writeObjectRequest);
                      }
                    }
                    buf.clear();
                  }
                }
                if (closing && !finished) {
                  WriteObjectRequest message = finishMessage();
                  stream.onNext(message);
                  finished = true;
                }
                if (closing || finished) {
                  stream.onCompleted();
                }
                recover.compareAndSet(true, false);
              }
            } else {
              Object resource = resp.getResource();
              resultFuture.set(WriteObjectResponse.newBuilder().setResource(resource).build());
            }
          }
          long newWritten = writeCtx.getTotalSentBytes().get();
          Preconditions.checkState(
              newWritten == goalSize, "newWritten == goalSize (%s == %s)", newWritten, goalSize);
          return null;
        },
        Decoder.identity());
  }

  @VisibleForTesting
  static final class RequestStream implements ApiStreamObserver<WriteObjectRequest> {
    private static final ApiException CLIENT_RESET_ERROR =
        ApiExceptionFactory.createException(null, GrpcStatusCode.of(Code.ABORTED), false);

    private final ClientStreamingCallable<WriteObjectRequest, WriteObjectResponse> write;
    private final SettableApiFuture<WriteObjectResponse> resultFuture;

    private volatile StreamPair streamPair;

    private RequestStream(
        ClientStreamingCallable<WriteObjectRequest, WriteObjectResponse> write,
        SettableApiFuture<WriteObjectResponse> resultFuture) {
      this.write = write;
      this.resultFuture = resultFuture;
    }

    @Override
    public void onNext(WriteObjectRequest value) {
      StreamPair pair = ensureOpen();
      Throwable err = pair.getResponseStream().error;
      if (err != null) {
        reset();
        throw StorageException.coalesce(err);
      }

      halfClosedToUnavailable(() -> pair.getRequestStream().onNext(value));
    }

    @Override
    public void onError(Throwable t) {
      try {
        halfClosedToUnavailable(() -> ensureOpen().getRequestStream().onError(t));
      } finally {
        streamPair = null;
      }
    }

    @Override
    public void onCompleted() {
      StreamPair pair = ensureOpen();
      Throwable err = pair.getResponseStream().error;
      if (err != null) {
        reset();
        throw StorageException.coalesce(err);
      }

      halfClosedToUnavailable(pair.getRequestStream()::onCompleted);
      pair.getResponseStream().await();
    }

    private StreamPair ensureOpen() {
      if (streamPair == null) {
        ResponseStream responseStream = new ResponseStream(resultFuture);
        ApiStreamObserver<WriteObjectRequest> requestStream =
            write.clientStreamingCall(responseStream);
        streamPair = new StreamPair(requestStream, responseStream);
      }
      return streamPair;
    }

    private void reset() {
      if (streamPair != null && streamPair.getRequestStream() != null) {
        streamPair.getRequestStream().onError(CLIENT_RESET_ERROR);
      }
      streamPair = null;
    }

    /**
     * If the stream is in the process of closing (usually due to error) and we call a method on it
     * we will receive an IllegalStateException. A stream being half closed is not a terminal state
     * for our upload operation. Attempt to detect and translate it into an UNAVAILABLE error we can
     * retry.
     */
    static void halfClosedToUnavailable(Runnable r) {
      try {
        r.run();
      } catch (IllegalStateException ise) {
        String message = ise.getMessage();
        if (message != null && message.contains("half-closed")) {
          throw ApiExceptionFactory.createException(ise, GrpcStatusCode.of(Code.UNAVAILABLE), true);
        } else {
          throw ise;
        }
      }
    }
  }

  @VisibleForTesting
  static final class ResponseStream implements ApiStreamObserver<WriteObjectResponse> {
    private final SettableApiFuture<Void> invocationHandle;
    private final SettableApiFuture<WriteObjectResponse> resultFuture;

    private volatile WriteObjectResponse last;
    private volatile Throwable error;

    @VisibleForTesting
    ResponseStream(SettableApiFuture<WriteObjectResponse> resultFuture) {
      this.resultFuture = resultFuture;
      this.invocationHandle = SettableApiFuture.create();
    }

    @Override
    public void onNext(WriteObjectResponse value) {
      last = value;
      error = null;
    }

    @Override
    public void onError(Throwable t) {
      error = t;
      invocationHandle.setException(t);
    }

    @Override
    public void onCompleted() {
      if (last != null && last.hasResource()) {
        resultFuture.set(last);
      }
      invocationHandle.set(null);
    }

    void await() {
      // ApiExceptions.callAndTranslateApiException(invocationHandle);
      ApiFutureUtils.await(invocationHandle);
    }
  }

  @VisibleForTesting
  static final class Alg implements ResultRetryAlgorithm<WriteObjectResponse> {

    private final ResultRetryAlgorithm<WriteObjectResponse> delegate;
    private final SettableApiFuture<WriteObjectResponse> resultFuture;

    @VisibleForTesting
    @SuppressWarnings("unchecked")
    Alg(ResultRetryAlgorithm<?> delegate, SettableApiFuture<WriteObjectResponse> resultFuture) {
      this.delegate = (ResultRetryAlgorithm<WriteObjectResponse>) delegate;
      this.resultFuture = resultFuture;
    }

    @Override
    public TimedAttemptSettings createNextAttempt(
        Throwable prevThrowable,
        WriteObjectResponse prevResponse,
        TimedAttemptSettings prevSettings) {
      return delegate.createNextAttempt(prevThrowable, prevResponse, prevSettings);
    }

    @Override
    public boolean shouldRetry(Throwable prevThrowable, WriteObjectResponse prevResponse)
        throws CancellationException {
      boolean shouldRetry = delegate.shouldRetry(prevThrowable, prevResponse);
      if (!shouldRetry && prevThrowable != null) {
        resultFuture.setException(prevThrowable);
      }
      return shouldRetry;
    }
  }

  private static final class StreamPair {
    private final ApiStreamObserver<WriteObjectRequest> requestStream;
    private final ResponseStream responseStream;

    private StreamPair(
        ApiStreamObserver<WriteObjectRequest> requestStream, ResponseStream responseStream) {
      this.requestStream = requestStream;
      this.responseStream = responseStream;
    }

    public ApiStreamObserver<WriteObjectRequest> getRequestStream() {
      return requestStream;
    }

    public ResponseStream getResponseStream() {
      return responseStream;
    }
  }
}
