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

import static com.google.cloud.storage.GrpcUtils.contextWithBucketName;

import com.google.api.core.SettableApiFuture;
import com.google.api.gax.grpc.GrpcCallContext;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiStreamObserver;
import com.google.api.gax.rpc.ClientStreamingCallable;
import com.google.api.gax.rpc.ErrorDetails;
import com.google.api.gax.rpc.OutOfRangeException;
import com.google.cloud.storage.ChunkSegmenter.ChunkSegment;
import com.google.cloud.storage.Conversions.Decoder;
import com.google.cloud.storage.Crc32cValue.Crc32cLengthKnown;
import com.google.cloud.storage.Retrying.RetrierWithAlg;
import com.google.cloud.storage.UnbufferedWritableByteChannelSession.UnbufferedWritableByteChannel;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.ImmutableList;
import com.google.protobuf.ByteString;
import com.google.storage.v2.ChecksummedData;
import com.google.storage.v2.ObjectChecksums;
import com.google.storage.v2.WriteObjectRequest;
import com.google.storage.v2.WriteObjectResponse;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.function.Supplier;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

final class GapicUnbufferedChunkedResumableWritableByteChannel
    implements UnbufferedWritableByteChannel {

  private final SettableApiFuture<WriteObjectResponse> resultFuture;
  private final ChunkSegmenter chunkSegmenter;
  private final ClientStreamingCallable<WriteObjectRequest, WriteObjectResponse> write;

  private final String bucketName;
  private final WriteCtx<ResumableWrite> writeCtx;
  private final RetrierWithAlg retrier;
  private final Supplier<GrpcCallContext> baseContextSupplier;

  private volatile boolean open = true;
  private boolean finished = false;

  GapicUnbufferedChunkedResumableWritableByteChannel(
      SettableApiFuture<WriteObjectResponse> resultFuture,
      @NonNull ChunkSegmenter chunkSegmenter,
      ClientStreamingCallable<WriteObjectRequest, WriteObjectResponse> write,
      WriteCtx<ResumableWrite> writeCtx,
      RetrierWithAlg retrier,
      Supplier<GrpcCallContext> baseContextSupplier) {
    this.resultFuture = resultFuture;
    this.chunkSegmenter = chunkSegmenter;
    this.write = write;
    this.bucketName = writeCtx.getRequestFactory().bucketName();
    this.writeCtx = writeCtx;
    this.retrier = retrier;
    this.baseContextSupplier = baseContextSupplier;
  }

  @Override
  public long write(ByteBuffer[] srcs, int srcsOffset, int srcsLength) throws IOException {
    return internalWrite(srcs, srcsOffset, srcsLength, false);
  }

  @Override
  public long writeAndClose(ByteBuffer[] srcs, int srcsOffset, int srcsLength) throws IOException {
    long write = internalWrite(srcs, srcsOffset, srcsLength, true);
    close();
    return write;
  }

  @Override
  public boolean isOpen() {
    return open;
  }

  @Override
  public void close() throws IOException {
    if (open && !finished) {
      WriteObjectRequest message = finishMessage(true);
      try {
        flush(ImmutableList.of(message), null, true);
        finished = true;
      } catch (RuntimeException e) {
        resultFuture.setException(e);
        throw e;
      }
    }
    open = false;
  }

  private long internalWrite(ByteBuffer[] srcs, int srcsOffset, int srcsLength, boolean finalize)
      throws ClosedChannelException {
    if (!open) {
      throw new ClosedChannelException();
    }

    long begin = writeCtx.getConfirmedBytes().get();
    RewindableContent content = RewindableContent.of(srcs, srcsOffset, srcsLength);
    ChunkSegment[] data = chunkSegmenter.segmentBuffers(srcs, srcsOffset, srcsLength, finalize);
    if (data.length == 0) {
      return 0;
    }
    // we consumed some bytes from srcs, flag our content as dirty since we aren't writing
    // those bytes to implicitly flag as dirty.
    content.flagDirty();

    List<WriteObjectRequest> messages = new ArrayList<>();

    boolean first = true;
    for (ChunkSegment datum : data) {
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
      WriteObjectRequest.Builder builder =
          writeCtx
              .newRequestBuilder()
              .clearWriteObjectSpec()
              .clearObjectChecksums()
              .setWriteOffset(offset)
              .setChecksummedData(checksummedData.build());
      if (!first) {
        builder.clearUploadId();
      }
      if (!datum.isOnlyFullBlocks()) {
        builder.setFinishWrite(true);
        if (cumulative != null) {
          builder.setObjectChecksums(
              ObjectChecksums.newBuilder().setCrc32C(cumulative.getValue()).build());
        }
        finished = true;
      }

      WriteObjectRequest build = builder.build();
      first = false;
      messages.add(build);
    }
    if (finalize && !finished) {
      messages.add(finishMessage(first));
      finished = true;
    }

    try {
      flush(messages, content, finalize);
    } catch (RuntimeException e) {
      resultFuture.setException(e);
      throw e;
    }

    long end = writeCtx.getConfirmedBytes().get();

    long bytesConsumed = end - begin;
    return bytesConsumed;
  }

  @NonNull
  private WriteObjectRequest finishMessage(boolean first) {
    long offset = writeCtx.getTotalSentBytes().get();
    Crc32cLengthKnown crc32cValue = writeCtx.getCumulativeCrc32c().get();

    WriteObjectRequest.Builder b =
        writeCtx.newRequestBuilder().setFinishWrite(true).setWriteOffset(offset);
    if (!first) {
      b.clearUploadId();
    }
    if (crc32cValue != null) {
      b.setObjectChecksums(ObjectChecksums.newBuilder().setCrc32C(crc32cValue.getValue()).build());
    }
    WriteObjectRequest message = b.build();
    return message;
  }

  private void flush(
      @NonNull List<WriteObjectRequest> segments,
      @Nullable RewindableContent content,
      boolean finalizing) {
    GrpcCallContext internalContext = contextWithBucketName(bucketName, baseContextSupplier.get());
    ClientStreamingCallable<WriteObjectRequest, WriteObjectResponse> callable =
        write.withDefaultCallContext(internalContext);

    retrier.run(
        () -> {
          Observer observer = new Observer(content, finalizing, segments, internalContext);
          ApiStreamObserver<WriteObjectRequest> write = callable.clientStreamingCall(observer);

          for (WriteObjectRequest message : segments) {
            write.onNext(message);
          }
          write.onCompleted();
          try {
            observer.await();
          } catch (Throwable t) {
            t.addSuppressed(new AsyncStorageTaskException());
            throw t;
          }
          return null;
        },
        Decoder.identity());
  }

  @VisibleForTesting
  WriteCtx<?> getWriteCtx() {
    return writeCtx;
  }

  class Observer implements ApiStreamObserver<WriteObjectResponse> {

    private final RewindableContent content;
    private final boolean finalizing;
    private final List<WriteObjectRequest> segments;
    private final GrpcCallContext context;

    private final SettableApiFuture<Void> invocationHandle;
    private volatile WriteObjectResponse last;

    Observer(
        @Nullable RewindableContent content,
        boolean finalizing,
        @NonNull List<WriteObjectRequest> segments,
        GrpcCallContext context) {
      this.content = content;
      this.finalizing = finalizing;
      this.segments = segments;
      this.context = context;
      this.invocationHandle = SettableApiFuture.create();
    }

    @Override
    public void onNext(WriteObjectResponse value) {
      last = value;
    }

    @Override
    public void onError(Throwable t) {
      if (t instanceof OutOfRangeException) {
        OutOfRangeException oore = (OutOfRangeException) t;
        open = false;
        ErrorDetails ed = oore.getErrorDetails();
        if (!(ed != null
            && ed.getErrorInfo() != null
            && ed.getErrorInfo().getReason().equals("GRPC_MISMATCHED_UPLOAD_SIZE"))) {
          StorageException storageException =
              UploadFailureScenario.SCENARIO_5.toStorageException(segments, null, context, oore);
          invocationHandle.setException(storageException);
          return;
        }
      }
      if (t instanceof ApiException) {
        // use StorageExceptions logic to translate from ApiException to our status codes ensuring
        // things fall in line with our retry handlers.
        // This is suboptimal, as it will initialize a second exception, however this is the
        // unusual case, and it should not cause a significant overhead given its rarity.
        StorageException tmp = StorageException.asStorageException((ApiException) t);
        StorageException storageException =
            UploadFailureScenario.toStorageException(
                tmp.getCode(), tmp.getMessage(), tmp.getReason(), segments, null, context, t);
        invocationHandle.setException(storageException);
      }
    }

    @Override
    public void onCompleted() {
      try {
        if (last == null) {
          throw new StorageException(
              0, "onComplete without preceding onNext, unable to determine success.");
        } else if (!finalizing && last.hasPersistedSize()) { // incremental
          long totalSentBytes = writeCtx.getTotalSentBytes().get();
          long persistedSize = last.getPersistedSize();

          if (totalSentBytes == persistedSize) {
            writeCtx.getConfirmedBytes().set(persistedSize);
          } else if (persistedSize < totalSentBytes) {
            long delta = totalSentBytes - persistedSize;
            // rewind our content and any state that my have run ahead of the actual ack'd bytes
            content.rewindTo(delta);
            writeCtx.getTotalSentBytes().set(persistedSize);
            writeCtx.getConfirmedBytes().set(persistedSize);
          } else {
            throw UploadFailureScenario.SCENARIO_7.toStorageException(
                segments, last, context, null);
          }
        } else if (finalizing && last.hasResource()) {
          long totalSentBytes = writeCtx.getTotalSentBytes().get();
          long finalSize = last.getResource().getSize();
          if (totalSentBytes == finalSize) {
            writeCtx.getConfirmedBytes().set(finalSize);
            resultFuture.set(last);
          } else if (finalSize < totalSentBytes) {
            throw UploadFailureScenario.SCENARIO_4_1.toStorageException(
                segments, last, context, null);
          } else {
            throw UploadFailureScenario.SCENARIO_4_2.toStorageException(
                segments, last, context, null);
          }
        } else if (!finalizing && last.hasResource()) {
          throw UploadFailureScenario.SCENARIO_1.toStorageException(segments, last, context, null);
        } else if (finalizing && last.hasPersistedSize()) {
          long totalSentBytes = writeCtx.getTotalSentBytes().get();
          long persistedSize = last.getPersistedSize();
          if (persistedSize < totalSentBytes) {
            throw UploadFailureScenario.SCENARIO_3.toStorageException(
                segments, last, context, null);
          } else {
            throw UploadFailureScenario.SCENARIO_2.toStorageException(
                segments, last, context, null);
          }
        } else {
          throw UploadFailureScenario.SCENARIO_0.toStorageException(segments, last, context, null);
        }
      } catch (Throwable se) {
        open = false;
        invocationHandle.setException(se);
      } finally {
        invocationHandle.set(null);
      }
    }

    void await() {
      try {
        invocationHandle.get();
      } catch (InterruptedException | ExecutionException e) {
        if (e.getCause() instanceof RuntimeException) {
          throw (RuntimeException) e.getCause();
        } else {
          throw new RuntimeException(e);
        }
      }
    }
  }
}
