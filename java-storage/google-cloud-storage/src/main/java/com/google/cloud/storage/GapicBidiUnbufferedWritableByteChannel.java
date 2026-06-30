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
import static com.google.cloud.storage.Utils.nullSafeList;

import com.google.api.core.SettableApiFuture;
import com.google.api.gax.grpc.GrpcCallContext;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiStreamObserver;
import com.google.api.gax.rpc.BidiStreamingCallable;
import com.google.api.gax.rpc.ErrorDetails;
import com.google.api.gax.rpc.OutOfRangeException;
import com.google.cloud.storage.ChunkSegmenter.ChunkSegment;
import com.google.cloud.storage.Conversions.Decoder;
import com.google.cloud.storage.Crc32cValue.Crc32cLengthKnown;
import com.google.cloud.storage.Retrying.RetrierWithAlg;
import com.google.cloud.storage.UnbufferedWritableByteChannelSession.UnbufferedWritableByteChannel;
import com.google.common.annotations.VisibleForTesting;
import com.google.protobuf.ByteString;
import com.google.storage.v2.BidiWriteObjectRequest;
import com.google.storage.v2.BidiWriteObjectResponse;
import com.google.storage.v2.ChecksummedData;
import com.google.storage.v2.ObjectChecksums;
import io.grpc.Status;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.function.Supplier;
import org.checkerframework.checker.nullness.qual.NonNull;

final class GapicBidiUnbufferedWritableByteChannel implements UnbufferedWritableByteChannel {
  private final BidiStreamingCallable<BidiWriteObjectRequest, BidiWriteObjectResponse> write;
  private final RetrierWithAlg retrier;
  private final SettableApiFuture<BidiWriteObjectResponse> resultFuture;
  private final ChunkSegmenter chunkSegmenter;

  private final BidiWriteCtx<BidiResumableWrite> writeCtx;
  private final GrpcCallContext context;
  private final BidiObserver responseObserver;

  private volatile ApiStreamObserver<BidiWriteObjectRequest> stream;
  private boolean open = true;
  private boolean first = true;
  private boolean finished = false;
  private volatile BidiWriteObjectRequest lastWrittenRequest;
  private volatile RewindableContent currentContent;

  GapicBidiUnbufferedWritableByteChannel(
      BidiStreamingCallable<BidiWriteObjectRequest, BidiWriteObjectResponse> write,
      RetrierWithAlg retrier,
      SettableApiFuture<BidiWriteObjectResponse> resultFuture,
      ChunkSegmenter chunkSegmenter,
      BidiWriteCtx<BidiResumableWrite> writeCtx,
      Supplier<GrpcCallContext> baseContextSupplier) {
    this.write = write;
    this.retrier = retrier;
    this.resultFuture = resultFuture;
    this.chunkSegmenter = chunkSegmenter;

    this.writeCtx = writeCtx;
    this.responseObserver = new BidiObserver();
    String bucketName = writeCtx.getRequestFactory().bucketName();
    this.context = contextWithBucketName(bucketName, baseContextSupplier.get());
  }

  @Override
  public long write(ByteBuffer[] srcs, int srcsOffset, int srcsLength) throws IOException {
    return internalWrite(srcs, srcsOffset, srcsLength, false);
  }

  @Override
  public long writeAndClose(ByteBuffer[] srcs, int offset, int length) throws IOException {
    long written = internalWrite(srcs, offset, length, true);
    close();
    return written;
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
      if (!finished) {
        BidiWriteObjectRequest message = finishMessage();
        lastWrittenRequest = message;
        flush(Collections.singletonList(message));
      } else {
        if (stream != null) {
          stream.onCompleted();
          responseObserver.await();
        }
      }
    } finally {
      open = false;
      stream = null;
      lastWrittenRequest = null;
    }
  }

  @VisibleForTesting
  BidiWriteCtx<BidiResumableWrite> getWriteCtx() {
    return writeCtx;
  }

  private long internalWrite(ByteBuffer[] srcs, int srcsOffset, int srcsLength, boolean finalize)
      throws ClosedChannelException {
    if (!open) {
      throw new ClosedChannelException();
    }

    long begin = writeCtx.getConfirmedBytes().get();
    currentContent = RewindableContent.of(srcs, srcsOffset, srcsLength);
    ChunkSegment[] data = chunkSegmenter.segmentBuffers(srcs, srcsOffset, srcsLength, finalize);
    if (data.length == 0) {
      currentContent = null;
      return 0;
    }

    List<BidiWriteObjectRequest> messages = new ArrayList<>();

    for (int i = 0; i < data.length; i++) {
      ChunkSegment datum = data[i];
      Crc32cLengthKnown crc32c = datum.getCrc32c();
      ByteString b = datum.getB();
      int contentSize = b.size();
      long offset = writeCtx.getTotalSentBytes().getAndAdd(contentSize);
      Crc32cLengthKnown cumulative =
          writeCtx
              .getCumulativeCrc32c()
              .accumulateAndGet(crc32c, chunkSegmenter.getHasher()::nullSafeConcat);
      ChecksummedData.Builder checksummedData = ChecksummedData.newBuilder().setContent(b);
      if (crc32c != null) {
        checksummedData.setCrc32C(crc32c.getValue());
      }
      BidiWriteObjectRequest.Builder builder = writeCtx.newRequestBuilder();
      if (!first) {
        builder.clearUploadId();
        builder.clearObjectChecksums();
      } else {
        first = false;
      }
      builder.setWriteOffset(offset).setChecksummedData(checksummedData.build());
      if (!datum.isOnlyFullBlocks()) {
        builder.setFinishWrite(true);
        if (cumulative != null) {
          builder.setObjectChecksums(
              ObjectChecksums.newBuilder().setCrc32C(cumulative.getValue()).build());
        }
        finished = true;
      }

      if (i == data.length - 1 && !finished) {
        if (finalize) {
          builder.setFinishWrite(true);
          finished = true;
        } else {
          builder.setFlush(true).setStateLookup(true);
        }
      }

      BidiWriteObjectRequest build = builder.build();
      messages.add(build);
    }
    if (finalize && !finished) {
      messages.add(finishMessage());
      finished = true;
    }

    try {
      flush(messages);
    } catch (RuntimeException e) {
      open = false;
      resultFuture.setException(e);
      throw e;
    }

    long end = writeCtx.getConfirmedBytes().get();

    long bytesConsumed = end - begin;
    return bytesConsumed;
  }

  @NonNull
  private BidiWriteObjectRequest finishMessage() {
    long offset = writeCtx.getTotalSentBytes().get();
    Crc32cLengthKnown crc32cValue = writeCtx.getCumulativeCrc32c().get();

    BidiWriteObjectRequest.Builder b = writeCtx.newRequestBuilder();
    if (!first) {
      b.clearUploadId().clearObjectChecksums();
    }
    b.setFinishWrite(true).setWriteOffset(offset);
    if (crc32cValue != null) {
      b.setObjectChecksums(ObjectChecksums.newBuilder().setCrc32C(crc32cValue.getValue()).build());
    }
    BidiWriteObjectRequest message = b.build();
    return message;
  }

  private ApiStreamObserver<BidiWriteObjectRequest> openedStream() {
    if (stream == null) {
      synchronized (this) {
        if (stream == null) {
          responseObserver.reset();
          stream =
              new GracefulOutboundStream(this.write.bidiStreamingCall(responseObserver, context));
        }
      }
    }
    return stream;
  }

  private void flush(@NonNull List<BidiWriteObjectRequest> segments) {
    retrier.run(
        () -> {
          try {
            ApiStreamObserver<BidiWriteObjectRequest> opened = openedStream();
            for (BidiWriteObjectRequest message : segments) {
              opened.onNext(message);
              lastWrittenRequest = message;
            }
            if (lastWrittenRequest.getFinishWrite()) {
              opened.onCompleted();
            }
            responseObserver.await();
            return null;
          } catch (Throwable t) {
            stream = null;
            first = true;
            t.addSuppressed(new AsyncStorageTaskException());
            throw t;
          }
        },
        Decoder.identity());
  }

  private class BidiObserver implements ApiStreamObserver<BidiWriteObjectResponse> {

    private final Semaphore sem;
    private volatile BidiWriteObjectResponse last;
    private volatile StorageException clientDetectedError;
    private volatile RuntimeException previousError;

    private BidiObserver() {
      this.sem = new Semaphore(0);
    }

    @Override
    public void onNext(BidiWriteObjectResponse value) {
      boolean finalizing = lastWrittenRequest.getFinishWrite();
      if (!finalizing && value.hasPersistedSize()) { // incremental
        long totalSentBytes = writeCtx.getTotalSentBytes().get();
        long persistedSize = value.getPersistedSize();

        if (totalSentBytes == persistedSize) {
          writeCtx.getConfirmedBytes().set(persistedSize);
          ok(value);
        } else if (persistedSize < totalSentBytes) {
          long delta = totalSentBytes - persistedSize;
          // rewind our content and any state that my have run ahead of the actual ack'd bytes
          currentContent.rewindTo(delta);
          writeCtx.getTotalSentBytes().set(persistedSize);
          writeCtx.getConfirmedBytes().set(persistedSize);
          ok(value);
        } else {
          clientDetectedError(
              UploadFailureScenario.SCENARIO_7.toStorageException(
                  nullSafeList(lastWrittenRequest), value, context, null));
        }
      } else if (finalizing && value.hasResource()) {
        long totalSentBytes = writeCtx.getTotalSentBytes().get();
        long finalSize = value.getResource().getSize();
        if (totalSentBytes == finalSize) {
          writeCtx.getConfirmedBytes().set(finalSize);
          ok(value);
        } else if (finalSize < totalSentBytes) {
          clientDetectedError(
              UploadFailureScenario.SCENARIO_4_1.toStorageException(
                  nullSafeList(lastWrittenRequest), value, context, null));
        } else {
          clientDetectedError(
              UploadFailureScenario.SCENARIO_4_2.toStorageException(
                  nullSafeList(lastWrittenRequest), value, context, null));
        }
      } else if (!finalizing && value.hasResource()) {
        clientDetectedError(
            UploadFailureScenario.SCENARIO_1.toStorageException(
                nullSafeList(lastWrittenRequest), value, context, null));
      } else if (finalizing && value.hasPersistedSize()) {
        long totalSentBytes = writeCtx.getTotalSentBytes().get();
        long persistedSize = value.getPersistedSize();
        // if a flush: true, state_lookup: true message is in the stream along with a
        // finish_write: true, GCS can respond with the incremental update, gracefully handle this
        // message
        if (totalSentBytes == persistedSize) {
          writeCtx.getConfirmedBytes().set(persistedSize);
        } else if (persistedSize < totalSentBytes) {
          clientDetectedError(
              UploadFailureScenario.SCENARIO_3.toStorageException(
                  nullSafeList(lastWrittenRequest), value, context, null));
        } else {
          clientDetectedError(
              UploadFailureScenario.SCENARIO_2.toStorageException(
                  nullSafeList(lastWrittenRequest), value, context, null));
        }
      } else {
        clientDetectedError(
            UploadFailureScenario.SCENARIO_0.toStorageException(
                nullSafeList(lastWrittenRequest), value, context, null));
      }
    }

    @Override
    public void onError(Throwable t) {
      if (t instanceof OutOfRangeException) {
        OutOfRangeException oore = (OutOfRangeException) t;
        ErrorDetails ed = oore.getErrorDetails();
        if (!(ed != null
            && ed.getErrorInfo() != null
            && ed.getErrorInfo().getReason().equals("GRPC_MISMATCHED_UPLOAD_SIZE"))) {
          clientDetectedError(
              UploadFailureScenario.SCENARIO_5.toStorageException(
                  nullSafeList(lastWrittenRequest), null, context, oore));
          return;
        }
      }
      if (t instanceof ApiException) {
        // use StorageExceptions logic to translate from ApiException to our status codes ensuring
        // things fall in line with our retry handlers.
        // This is suboptimal, as it will initialize a second exception, however this is the
        // unusual case, and it should not cause a significant overhead given its rarity.
        StorageException tmp = StorageException.asStorageException((ApiException) t);
        previousError =
            UploadFailureScenario.toStorageException(
                tmp.getCode(),
                tmp.getMessage(),
                tmp.getReason(),
                nullSafeList(lastWrittenRequest),
                null,
                context,
                t);
        sem.release();
      } else if (t instanceof RuntimeException) {
        previousError = (RuntimeException) t;
        sem.release();
      }
    }

    @Override
    public void onCompleted() {
      if (last != null && last.hasResource()) {
        resultFuture.set(last);
      }
      sem.release();
    }

    private void ok(BidiWriteObjectResponse value) {
      last = value;
      sem.release();
    }

    private void clientDetectedError(StorageException storageException) {
      open = false;
      clientDetectedError = storageException;
      // yes, check that previousError is not the same instance as e
      if (previousError != null && previousError != storageException) {
        storageException.addSuppressed(previousError);
        previousError = null;
      }
      if (previousError == null) {
        previousError = storageException;
      }
      sem.release();
    }

    void await() {
      try {
        sem.acquire();
      } catch (InterruptedException e) {
        if (e.getCause() instanceof RuntimeException) {
          throw (RuntimeException) e.getCause();
        } else {
          throw new RuntimeException(e);
        }
      }
      StorageException e = clientDetectedError;
      RuntimeException err = previousError;
      clientDetectedError = null;
      previousError = null;
      if ((e != null || err != null) && stream != null) {
        if (lastWrittenRequest != null && lastWrittenRequest.getFinishWrite()) {
          stream.onCompleted();
        } else {
          stream.onError(Status.CANCELLED.asRuntimeException());
        }
      }
      if (e != null) {
        throw e;
      }
      if (err != null) {
        throw err;
      }
    }

    public void reset() {
      sem.drainPermits();
      last = null;
      clientDetectedError = null;
      previousError = null;
    }
  }

  /**
   * Prevent "already half-closed" if we previously called onComplete but then detect an error and
   * call onError
   */
  private static final class GracefulOutboundStream
      implements ApiStreamObserver<BidiWriteObjectRequest> {

    private final ApiStreamObserver<BidiWriteObjectRequest> delegate;
    private volatile boolean closing;

    private GracefulOutboundStream(ApiStreamObserver<BidiWriteObjectRequest> delegate) {
      this.delegate = delegate;
      this.closing = false;
    }

    @Override
    public void onNext(BidiWriteObjectRequest value) {
      delegate.onNext(value);
    }

    @Override
    public void onError(Throwable t) {
      if (closing) {
        return;
      }
      closing = true;
      delegate.onError(t);
    }

    @Override
    public void onCompleted() {
      if (closing) {
        return;
      }
      closing = true;
      delegate.onCompleted();
    }
  }
}
