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

import static com.google.cloud.storage.TestUtils.apiException;
import static com.google.cloud.storage.TestUtils.getChecksummedData;
import static com.google.cloud.storage.TestUtils.xxd;
import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertThrows;

import com.google.api.core.ApiFutures;
import com.google.api.gax.retrying.BasicResultRetryAlgorithm;
import com.google.api.gax.retrying.ResultRetryAlgorithm;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.DataLossException;
import com.google.cloud.storage.ChannelSession.UnbufferedReadSession;
import com.google.cloud.storage.GrpcUtils.ZeroCopyServerStreamingCallable;
import com.google.cloud.storage.Retrying.Retrier;
import com.google.cloud.storage.UnbufferedReadableByteChannelSession.UnbufferedReadableByteChannel;
import com.google.common.collect.ImmutableList;
import com.google.common.hash.Hashing;
import com.google.protobuf.ByteString;
import com.google.storage.v2.ContentRange;
import com.google.storage.v2.Object;
import com.google.storage.v2.ObjectChecksums;
import com.google.storage.v2.ReadObjectRequest;
import com.google.storage.v2.ReadObjectResponse;
import com.google.storage.v2.StorageClient;
import com.google.storage.v2.StorageGrpc;
import io.grpc.Status.Code;
import io.grpc.stub.StreamObserver;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.Test;

public final class ITGapicUnbufferedReadableByteChannelTest {
  private final byte[] bytes = DataGenerator.base64Characters().genBytes(40);
  private final ByteString data1 = ByteString.copyFrom(bytes, 0, 10);
  private final ByteString data2 = ByteString.copyFrom(bytes, 10, 10);
  private final ByteString data3 = ByteString.copyFrom(bytes, 20, 10);
  private final ByteString data4 = ByteString.copyFrom(bytes, 30, 10);

  private final String objectName = "name";
  private final Object expectedResult =
      Object.newBuilder()
          .setName(objectName)
          .setGeneration(3L)
          .setContentType("application/octet-stream")
          .build();

  private final ReadObjectRequest req1 =
      ReadObjectRequest.newBuilder().setObject(objectName).setReadOffset(0).build();
  private final ReadObjectRequest req2 =
      req1.toBuilder().setGeneration(3L).setReadOffset(20).build();
  private final ReadObjectResponse resp1 =
      ReadObjectResponse.newBuilder()
          .setMetadata(expectedResult)
          .setContentRange(ContentRange.newBuilder().setStart(0).build())
          .setObjectChecksums(
              ObjectChecksums.newBuilder().setCrc32C(Hashing.crc32c().hashBytes(bytes).asInt()))
          .setChecksummedData(getChecksummedData(data1, Hasher.enabled()))
          .build();
  private final ReadObjectResponse resp2 =
      ReadObjectResponse.newBuilder()
          .setChecksummedData(getChecksummedData(data2, Hasher.enabled()))
          .build();
  private final ReadObjectResponse resp3 =
      ReadObjectResponse.newBuilder()
          .setMetadata(expectedResult)
          .setContentRange(ContentRange.newBuilder().setStart(20).build())
          .setObjectChecksums(
              ObjectChecksums.newBuilder().setCrc32C(Hashing.crc32c().hashBytes(bytes).asInt()))
          .setChecksummedData(getChecksummedData(data3, Hasher.enabled()))
          .build();
  private final ReadObjectResponse resp4 =
      ReadObjectResponse.newBuilder()
          .setChecksummedData(getChecksummedData(data4, Hasher.enabled()))
          .build();

  /** Define a Storage service that will always return an error during the first readObject */
  private final StorageGrpc.StorageImplBase fakeStorage =
      new StorageGrpc.StorageImplBase() {
        @Override
        public void readObject(
            ReadObjectRequest request, StreamObserver<ReadObjectResponse> responseObserver) {
          if (request.equals(req1)) {
            responseObserver.onNext(resp1);
            responseObserver.onNext(resp2);
            responseObserver.onError(apiException(Code.DATA_LOSS));
          } else if (request.equals(req2)) {
            responseObserver.onNext(resp3);
            responseObserver.onNext(resp4);
            responseObserver.onCompleted();
          } else {
            responseObserver.onError(apiException(Code.PERMISSION_DENIED));
          }
        }
      };

  @Test
  public void readRetriesAreProperlyOrdered_readLargerThanMessageSize()
      throws IOException, ExecutionException, InterruptedException, TimeoutException {
    try (FakeServer server = FakeServer.of(fakeStorage);
        StorageClient storageClient = StorageClient.create(server.storageSettings())) {
      Retrier retrier = TestUtils.retrierFromStorageOptions(server.getGrpcStorageOptions());

      UnbufferedReadableByteChannelSession<Object> session =
          new UnbufferedReadSession<>(
              ApiFutures.immediateFuture(req1),
              (start, resultFuture) ->
                  new GapicUnbufferedReadableByteChannel(
                      resultFuture,
                      new ZeroCopyServerStreamingCallable<>(
                          storageClient.readObjectCallable(),
                          ResponseContentLifecycleManager.noop()),
                      start,
                      Hasher.noop(),
                      retrier,
                      retryOnly(DataLossException.class)));
      byte[] actualBytes = new byte[40];
      try (UnbufferedReadableByteChannel c = session.open()) {
        c.read(ByteBuffer.wrap(actualBytes));
      }
      Object actualResult = session.getResult().get(1000, TimeUnit.MILLISECONDS);
      assertThat(actualResult).isEqualTo(expectedResult);
      assertThat(actualBytes).isEqualTo(bytes);
    }
  }

  @Test
  public void readRetriesAreProperlyOrdered_readSmallerThanMessageSize()
      throws IOException, ExecutionException, InterruptedException, TimeoutException {
    try (FakeServer server = FakeServer.of(fakeStorage);
        StorageClient storageClient = StorageClient.create(server.storageSettings())) {
      Retrier retrier = TestUtils.retrierFromStorageOptions(server.getGrpcStorageOptions());

      UnbufferedReadableByteChannelSession<Object> session =
          new UnbufferedReadSession<>(
              ApiFutures.immediateFuture(req1),
              (start, resultFuture) ->
                  new GapicUnbufferedReadableByteChannel(
                      resultFuture,
                      new ZeroCopyServerStreamingCallable<>(
                          storageClient.readObjectCallable(),
                          ResponseContentLifecycleManager.noop()),
                      start,
                      Hasher.noop(),
                      retrier,
                      retryOnly(DataLossException.class)));
      byte[] actualBytes = new byte[40];
      ImmutableList<ByteBuffer> buffers = TestUtils.subDivide(actualBytes, 2);
      try (UnbufferedReadableByteChannel c = session.open()) {
        for (ByteBuffer buf : buffers) {
          c.read(buf);
        }
      }
      Object actualResult = session.getResult().get(1000, TimeUnit.MILLISECONDS);
      assertThat(actualResult).isEqualTo(expectedResult);
      assertThat(actualBytes).isEqualTo(bytes);
    }
  }

  @Test
  public void ioException_if_generation_changes() throws IOException, InterruptedException {
    StorageGrpc.StorageImplBase fakeStorage =
        new StorageGrpc.StorageImplBase() {

          final AtomicInteger invocationCount = new AtomicInteger(0);

          @Override
          public void readObject(
              ReadObjectRequest request, StreamObserver<ReadObjectResponse> responseObserver) {
            int count = invocationCount.getAndIncrement();
            if (request.equals(req1)) {
              if (count == 0) {
                responseObserver.onNext(resp1);
                responseObserver.onNext(resp2);
                responseObserver.onError(apiException(Code.DATA_LOSS));
              }
            } else if (request.equals(req2)) {
              ReadObjectResponse.Builder builder = resp3.toBuilder();
              // increment the generation, as if it had been updated between initial read and retry
              builder.getMetadataBuilder().setGeneration(expectedResult.getGeneration() + 1);
              responseObserver.onNext(builder.build());
              responseObserver.onNext(resp4);
              responseObserver.onCompleted();
            } else {
              responseObserver.onError(apiException(Code.PERMISSION_DENIED));
            }
          }
        };

    try (FakeServer server = FakeServer.of(fakeStorage);
        StorageClient storageClient = StorageClient.create(server.storageSettings())) {
      Retrier retrier = TestUtils.retrierFromStorageOptions(server.getGrpcStorageOptions());

      UnbufferedReadableByteChannelSession<Object> session =
          new UnbufferedReadSession<>(
              ApiFutures.immediateFuture(req1),
              (start, resultFuture) ->
                  new GapicUnbufferedReadableByteChannel(
                      resultFuture,
                      new ZeroCopyServerStreamingCallable<>(
                          storageClient.readObjectCallable(),
                          ResponseContentLifecycleManager.noop()),
                      start,
                      Hasher.noop(),
                      retrier,
                      retryOnly(DataLossException.class)));
      byte[] actualBytes = new byte[40];
      try (UnbufferedReadableByteChannel c = session.open()) {
        IOException ioException =
            assertThrows(IOException.class, () -> c.read(ByteBuffer.wrap(actualBytes)));

        assertThat(ioException).hasMessageThat().containsMatch(".*Generation.*3.*4.*");
      }
    }
  }

  @Test
  public void ifCrc32cMismatchIndividualMessage_restartFromCorrectOffset()
      throws IOException, InterruptedException {
    StorageGrpc.StorageImplBase fakeStorage =
        new StorageGrpc.StorageImplBase() {
          @Override
          public void readObject(
              ReadObjectRequest request, StreamObserver<ReadObjectResponse> responseObserver) {
            if (request.equals(req1)) {
              responseObserver.onNext(resp1);
              responseObserver.onNext(resp2);
              ReadObjectResponse.Builder b = resp3.toBuilder();
              // set a bad checksum value
              b.getChecksummedDataBuilder().setCrc32C(1);
              responseObserver.onNext(b.build());
            } else if (request.equals(req2)) {
              responseObserver.onNext(resp3);
              responseObserver.onNext(resp4);
              responseObserver.onCompleted();
            } else {
              responseObserver.onError(apiException(Code.PERMISSION_DENIED));
            }
          }
        };
    try (FakeServer server = FakeServer.of(fakeStorage);
        StorageClient storageClient = StorageClient.create(server.storageSettings())) {
      Retrier retrier = TestUtils.retrierFromStorageOptions(server.getGrpcStorageOptions());

      UnbufferedReadableByteChannelSession<Object> session =
          new UnbufferedReadSession<>(
              ApiFutures.immediateFuture(req1),
              (start, resultFuture) ->
                  new GapicUnbufferedReadableByteChannel(
                      resultFuture,
                      new ZeroCopyServerStreamingCallable<>(
                          storageClient.readObjectCallable(),
                          ResponseContentLifecycleManager.noop()),
                      start,
                      Hasher.enabled(),
                      retrier,
                      retryOnly(DataLossException.class)));
      byte[] actualBytes = new byte[40];
      try (UnbufferedReadableByteChannel c = session.open()) {
        int read = c.read(ByteBuffer.wrap(actualBytes));

        assertThat(read).isEqualTo(40);
        assertThat(xxd(actualBytes)).isEqualTo(xxd(bytes));
      }
    }
  }

  @Test
  public void overRead_handledProperly() throws IOException, InterruptedException {
    StorageGrpc.StorageImplBase fakeStorage =
        new StorageGrpc.StorageImplBase() {
          @Override
          public void readObject(
              ReadObjectRequest request, StreamObserver<ReadObjectResponse> responseObserver) {
            responseObserver.onNext(resp1);
            responseObserver.onNext(resp2);
            responseObserver.onNext(resp3);
            responseObserver.onNext(resp4);
            responseObserver.onCompleted();
          }
        };
    try (FakeServer server = FakeServer.of(fakeStorage);
        StorageClient storageClient = StorageClient.create(server.storageSettings())) {
      Retrier retrier = TestUtils.retrierFromStorageOptions(server.getGrpcStorageOptions());

      UnbufferedReadableByteChannelSession<Object> session =
          new UnbufferedReadSession<>(
              ApiFutures.immediateFuture(req1),
              (start, resultFuture) ->
                  new GapicUnbufferedReadableByteChannel(
                      resultFuture,
                      new ZeroCopyServerStreamingCallable<>(
                          storageClient.readObjectCallable(),
                          ResponseContentLifecycleManager.noop()),
                      start,
                      Hasher.noop(),
                      retrier,
                      retryOnly(DataLossException.class)));
      byte[] actualBytes = new byte[41];
      //noinspection resource
      UnbufferedReadableByteChannel c = session.open();
      ByteBuffer buf = ByteBuffer.wrap(actualBytes);
      int read1 = c.read(buf);
      assertThat(read1).isAtLeast(1);
      int read2 = c.read(buf);
      assertThat(read2).isEqualTo(-1);
      assertThrows(ClosedChannelException.class, () -> c.read(buf));
    }
  }

  private static <E extends ApiException> ResultRetryAlgorithm<?> retryOnly(Class<E> c) {
    return new BasicResultRetryAlgorithm<java.lang.Object>() {
      @Override
      public boolean shouldRetry(Throwable previousThrowable, java.lang.Object previousResponse) {
        return previousThrowable instanceof StorageException
            && c.isAssignableFrom(previousThrowable.getCause().getClass());
      }
    };
  }
}
