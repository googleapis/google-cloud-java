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
import com.google.cloud.storage.ChunkSegmenter.ChunkSegment;
import com.google.cloud.storage.Crc32cValue.Crc32cLengthKnown;
import com.google.cloud.storage.UnbufferedWritableByteChannelSession.UnbufferedWritableByteChannel;
import com.google.cloud.storage.WriteCtx.SimpleWriteObjectRequestBuilderFactory;
import com.google.common.collect.ImmutableList;
import com.google.protobuf.ByteString;
import com.google.storage.v2.ChecksummedData;
import com.google.storage.v2.ObjectChecksums;
import com.google.storage.v2.WriteObjectRequest;
import com.google.storage.v2.WriteObjectResponse;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.util.concurrent.ExecutionException;
import org.checkerframework.checker.nullness.qual.NonNull;

final class GapicUnbufferedDirectWritableByteChannel implements UnbufferedWritableByteChannel {

  private final SettableApiFuture<WriteObjectResponse> resultFuture;
  private final ChunkSegmenter chunkSegmenter;
  private final ClientStreamingCallable<WriteObjectRequest, WriteObjectResponse> write;

  private final WriteCtx<SimpleWriteObjectRequestBuilderFactory> writeCtx;

  private final Observer responseObserver;
  private volatile ApiStreamObserver<WriteObjectRequest> stream;

  private boolean open = true;
  private boolean first = true;
  private boolean finished = false;
  private volatile WriteObjectRequest lastWrittenRequest;

  GapicUnbufferedDirectWritableByteChannel(
      SettableApiFuture<WriteObjectResponse> resultFuture,
      ChunkSegmenter chunkSegmenter,
      ClientStreamingCallable<WriteObjectRequest, WriteObjectResponse> write,
      WriteCtx<SimpleWriteObjectRequestBuilderFactory> writeCtx) {
    String bucketName = writeCtx.getRequestFactory().bucketName();
    this.resultFuture = resultFuture;
    this.chunkSegmenter = chunkSegmenter;

    GrpcCallContext internalContext =
        contextWithBucketName(bucketName, GrpcCallContext.createDefault());
    this.write = write.withDefaultCallContext(internalContext);

    this.writeCtx = writeCtx;
    this.responseObserver = new Observer(internalContext);
  }

  @Override
  public long write(ByteBuffer[] srcs, int srcsOffset, int srcsLength) throws IOException {
    if (!open) {
      throw new ClosedChannelException();
    }

    ChunkSegment[] data = chunkSegmenter.segmentBuffers(srcs, srcsOffset, srcsLength);
    if (data.length == 0) {
      return 0;
    }

    try {
      ApiStreamObserver<WriteObjectRequest> openedStream = openedStream();
      int bytesConsumed = 0;
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
        WriteObjectRequest.Builder builder = writeCtx.newRequestBuilder();
        if (!first) {
          builder.clearWriteObjectSpec();
          builder.clearObjectChecksums();
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

        WriteObjectRequest build = builder.build();
        first = false;
        bytesConsumed += contentSize;
        lastWrittenRequest = build;
        openedStream.onNext(build);
      }
      return bytesConsumed;
    } catch (RuntimeException e) {
      resultFuture.setException(e);
      throw e;
    }
  }

  @Override
  public boolean isOpen() {
    return open;
  }

  @Override
  public void close() throws IOException {
    ApiStreamObserver<WriteObjectRequest> openedStream = openedStream();
    if (!finished) {
      WriteObjectRequest message = finishMessage();
      lastWrittenRequest = message;
      try {
        openedStream.onNext(message);
        openedStream.onCompleted();
        finished = true;
      } catch (RuntimeException e) {
        resultFuture.setException(e);
        throw e;
      }
    } else {
      try {
        openedStream.onCompleted();
      } catch (RuntimeException e) {
        resultFuture.setException(e);
        throw e;
      }
    }
    open = false;
    responseObserver.await();
  }

  @NonNull
  private WriteObjectRequest finishMessage() {
    long offset = writeCtx.getTotalSentBytes().get();
    Crc32cLengthKnown crc32cValue = writeCtx.getCumulativeCrc32c().get();

    WriteObjectRequest.Builder b = writeCtx.newRequestBuilder();
    if (!first) {
      b.clearWriteObjectSpec();
      b.clearObjectChecksums();
      first = false;
    }
    b.setFinishWrite(true).setWriteOffset(offset);
    if (crc32cValue != null) {
      b.setObjectChecksums(ObjectChecksums.newBuilder().setCrc32C(crc32cValue.getValue()).build());
    }
    return b.build();
  }

  private ApiStreamObserver<WriteObjectRequest> openedStream() {
    if (stream == null) {
      synchronized (this) {
        if (stream == null) {
          stream = write.clientStreamingCall(responseObserver);
        }
      }
    }
    return stream;
  }

  class Observer implements ApiStreamObserver<WriteObjectResponse> {

    private final GrpcCallContext context;

    private final SettableApiFuture<Void> invocationHandle;
    private volatile WriteObjectResponse last;

    Observer(GrpcCallContext context) {
      this.context = context;
      this.invocationHandle = SettableApiFuture.create();
    }

    @Override
    public void onNext(WriteObjectResponse value) {
      last = value;
    }

    /**
     * observed exceptions so far
     *
     * <ol>
     *   <li>{@link com.google.api.gax.rpc.OutOfRangeException}
     *   <li>{@link com.google.api.gax.rpc.AlreadyExistsException}
     *   <li>{@link io.grpc.StatusRuntimeException}
     * </ol>
     */
    @Override
    public void onError(Throwable t) {
      if (t instanceof ApiException) {
        // use StorageExceptions logic to translate from ApiException to our status codes ensuring
        // things fall in line with our retry handlers.
        // This is suboptimal, as it will initialize a second exception, however this is the
        // unusual case, and it should not cause a significant overhead given its rarity.
        StorageException tmp = StorageException.asStorageException((ApiException) t);
        StorageException storageException =
            UploadFailureScenario.toStorageException(
                tmp.getCode(), tmp.getMessage(), tmp.getReason(), getRequests(), null, context, t);
        invocationHandle.setException(storageException);
      } else {
        invocationHandle.setException(t);
      }
    }

    @Override
    public void onCompleted() {
      try {
        if (last == null) {
          throw new StorageException(
              0, "onComplete without preceding onNext, unable to determine success.");
        } else if (last.hasResource()) {
          long totalSentBytes = writeCtx.getTotalSentBytes().get();
          long finalSize = last.getResource().getSize();
          if (totalSentBytes == finalSize) {
            writeCtx.getConfirmedBytes().set(finalSize);
            resultFuture.set(last);
          } else if (finalSize < totalSentBytes) {
            throw UploadFailureScenario.SCENARIO_4_1.toStorageException(
                getRequests(), last, context, null);
          } else {
            throw UploadFailureScenario.SCENARIO_4_2.toStorageException(
                getRequests(), last, context, null);
          }
        } else {
          throw UploadFailureScenario.SCENARIO_0.toStorageException(
              getRequests(), last, context, null);
        }
      } catch (Throwable se) {
        open = false;
        invocationHandle.setException(se);
      } finally {
        invocationHandle.set(null);
      }
    }

    private @NonNull ImmutableList<@NonNull WriteObjectRequest> getRequests() {
      if (lastWrittenRequest == null) {
        return ImmutableList.of();
      } else {
        return ImmutableList.of(lastWrittenRequest);
      }
    }

    void await() {
      try {
        invocationHandle.get();
      } catch (InterruptedException | ExecutionException e) {
        RuntimeException runtimeException;
        if (e.getCause() instanceof RuntimeException) {
          runtimeException = (RuntimeException) e.getCause();
        } else {
          runtimeException = new RuntimeException(e);
        }
        runtimeException.addSuppressed(new AsyncStorageTaskException());
        throw runtimeException;
      }
    }
  }
}
