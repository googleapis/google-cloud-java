/*
 * Copyright 2024 Google LLC
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

import static com.google.cloud.storage.ByteSizeConstants._2MiB;
import static com.google.cloud.storage.TestUtils.assertAll;
import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertThrows;

import com.google.api.core.ApiFuture;
import com.google.api.core.NanoClock;
import com.google.api.core.SettableApiFuture;
import com.google.api.gax.grpc.GrpcCallContext;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.BidiStreamingCallable;
import com.google.api.gax.rpc.ClientStream;
import com.google.api.gax.rpc.ClientStreamReadyObserver;
import com.google.api.gax.rpc.ResponseObserver;
import com.google.cloud.storage.Backoff.Jitterer;
import com.google.cloud.storage.BaseObjectReadSessionStreamRead.AccumulatingRead;
import com.google.cloud.storage.BaseObjectReadSessionStreamRead.StreamingRead;
import com.google.cloud.storage.GrpcUtils.ZeroCopyBidiStreamingCallable;
import com.google.cloud.storage.ResponseContentLifecycleHandle.ChildRef;
import com.google.cloud.storage.RetryContext.OnFailure;
import com.google.cloud.storage.RetryContext.OnSuccess;
import com.google.cloud.storage.RetryContext.RetryContextProvider;
import com.google.cloud.storage.RetryContextTest.BlockingOnSuccess;
import com.google.cloud.storage.Retrying.RetryingDependencies;
import com.google.protobuf.ByteString;
import com.google.storage.v2.BidiReadObjectRequest;
import com.google.storage.v2.BidiReadObjectResponse;
import com.google.storage.v2.BidiReadObjectSpec;
import com.google.storage.v2.BucketName;
import com.google.storage.v2.Object;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Function;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public final class ObjectReadSessionStreamTest {

  private static final Object METADATA =
      Object.newBuilder()
          .setBucket(BucketName.format("_", "b"))
          .setName("o")
          .setGeneration(1)
          .setSize(_2MiB)
          .build();
  private static final BidiReadObjectRequest REQ_OPEN =
      BidiReadObjectRequest.newBuilder()
          .setReadObjectSpec(
              BidiReadObjectSpec.newBuilder()
                  .setBucket(METADATA.getBucket())
                  .setObject(METADATA.getName())
                  .build())
          .build();

  private static ScheduledExecutorService exec;

  private final RetrySettings retrySettings = RetrySettings.newBuilder().build();
  private final ObjectReadSessionState state =
      new ObjectReadSessionState(GrpcCallContext.createDefault(), REQ_OPEN);
  private final RetryContextProvider retryContextProvider =
      () ->
          RetryContext.of(
              exec,
              RetryingDependencies.simple(NanoClock.getDefaultClock(), retrySettings),
              Retrying.alwaysRetry(),
              Jitterer.noJitter());
  private final ZeroCopyBidiStreamingCallable<BidiReadObjectRequest, BidiReadObjectResponse>
      callable =
          new ZeroCopyBidiStreamingCallable<>(
              new BidiStreamingCallable<BidiReadObjectRequest, BidiReadObjectResponse>() {
                @Override
                public ClientStream<BidiReadObjectRequest> internalCall(
                    ResponseObserver<BidiReadObjectResponse> responseObserver,
                    ClientStreamReadyObserver<BidiReadObjectRequest> onReady,
                    ApiCallContext context) {
                  return new ClientStream<BidiReadObjectRequest>() {
                    @Override
                    public void send(BidiReadObjectRequest request) {}

                    @Override
                    public void closeSendWithError(Throwable t) {}

                    @Override
                    public void closeSend() {
                      responseObserver.onComplete();
                    }

                    @Override
                    public boolean isSendReady() {
                      return true;
                    }
                  };
                }
              },
              ResponseContentLifecycleManager.noopBidiReadObjectResponse());

  @BeforeClass
  public static void beforeClass() {
    exec = Executors.newSingleThreadScheduledExecutor();
  }

  @AfterClass
  public static void afterClass() throws Exception {
    if (exec != null) {
      exec.shutdownNow();
      assertThat(exec.awaitTermination(5, TimeUnit.SECONDS)).isTrue();
    }
  }

  @Test
  public void streamRestartShouldNotSendARequestIfAllReadsAreInBackoff() {
    RetryContext read1RetryContext = retryContextProvider.create();
    TestObjectReadSessionStreamRead read1 =
        new TestObjectReadSessionStreamRead(1, RangeSpec.of(1, 2), read1RetryContext);
    state.putOutstandingRead(1, read1);

    RetryContext streamRetryContext = retryContextProvider.create();
    try (ObjectReadSessionStream stream =
        ObjectReadSessionStream.create(exec, callable, state, streamRetryContext)) {
      BlockingOnSuccess blockingOnSuccess = new BlockingOnSuccess();
      read1RetryContext.recordError(
          new RuntimeException("read1err"), blockingOnSuccess, RetryContextTest.failOnFailure());

      stream.restart();
      blockingOnSuccess.release();
    }
  }

  @Test
  public void streamRestartShouldSendARequestIfReadsAreNotInBackoff() {
    RetryContext read1RetryContext = retryContextProvider.create();
    TestObjectReadSessionStreamRead read1 =
        new TestObjectReadSessionStreamRead(1, RangeSpec.of(1, 2), read1RetryContext);
    read1.readyToSend = true;
    state.putOutstandingRead(1, read1);

    RetryContext streamRetryContext = retryContextProvider.create();
    try (ObjectReadSessionStream stream =
        ObjectReadSessionStream.create(exec, callable, state, streamRetryContext)) {
      stream.restart();
    }
  }

  @Test
  public void attemptingToRestartStreamThatIsAlreadyActiveThrows() {

    RetryContext streamRetryContext = retryContextProvider.create();
    try (ObjectReadSessionStream stream =
        ObjectReadSessionStream.create(exec, callable, state, streamRetryContext)) {
      stream.send(REQ_OPEN);

      IllegalStateException ise = assertThrows(IllegalStateException.class, stream::restart);
      assertThat(ise).hasMessageThat().contains("already active");
    }
  }

  @Test
  public void sendErrorsIfNotOpen() throws Exception {

    RetryContext streamRetryContext = retryContextProvider.create();
    ObjectReadSessionStream stream =
        ObjectReadSessionStream.create(exec, callable, state, streamRetryContext);
    assertThat(stream.isOpen()).isTrue();
    stream.close();

    assertAll(
        () -> {
          IllegalStateException ise =
              assertThrows(IllegalStateException.class, () -> stream.send(REQ_OPEN));
          assertThat(ise).hasMessageThat().isEqualTo("Stream closed");
        },
        () -> assertThat(stream.isOpen()).isFalse());
  }

  @Test
  public void closingShouldFailPendingReads() throws Exception {

    TestObjectReadSessionStreamRead read1 = TestObjectReadSessionStreamRead.of();
    TestObjectReadSessionStreamRead read2 = TestObjectReadSessionStreamRead.of();
    TestObjectReadSessionStreamRead read3 = TestObjectReadSessionStreamRead.of();
    state.putOutstandingRead(read1.readId, read1);
    state.putOutstandingRead(read2.readId, read2);
    state.putOutstandingRead(read3.readId, read3);

    RetryContext streamRetryContext = retryContextProvider.create();
    ObjectReadSessionStream stream =
        ObjectReadSessionStream.create(exec, callable, state, streamRetryContext);
    ApiFuture<Void> closeAsync = stream.closeAsync();
    TestUtils.await(closeAsync, 5, TimeUnit.SECONDS);

    assertAll(
        () -> {
          Throwable t1 = read1.fail.get(2, TimeUnit.SECONDS);
          // t1.printStackTrace(System.out);
          assertThat(t1).isInstanceOf(StorageException.class);
          assertThat(t1).hasCauseThat().isInstanceOf(AsyncSessionClosedException.class);
        },
        () -> {
          Throwable t2 = read2.fail.get(2, TimeUnit.SECONDS);
          // t2.printStackTrace(System.err);
          assertThat(t2).isInstanceOf(StorageException.class);
          assertThat(t2).hasCauseThat().isInstanceOf(AsyncSessionClosedException.class);
        },
        () -> {
          Throwable t3 = read3.fail.get(2, TimeUnit.SECONDS);
          // t3.printStackTrace(System.out);
          assertThat(t3).isInstanceOf(StorageException.class);
          assertThat(t3).hasCauseThat().isInstanceOf(AsyncSessionClosedException.class);
        });
  }

  @Test
  public void streamingRead_mustCloseQueuedResponsesWhenFailed() throws Exception {
    try (StreamingRead read1 =
        ObjectReadSessionStreamRead.streamingRead(
            1, RangeSpec.all(), Hasher.enabled(), RetryContext.neverRetry())) {
      state.putOutstandingRead(1, read1);
      ObjectReadSessionStream stream =
          ObjectReadSessionStream.create(exec, callable, state, RetryContext.neverRetry());

      ByteString bytes1 = ByteString.copyFrom(DataGenerator.base64Characters().genBytes(9));
      ByteString bytes2 = ByteString.copyFrom(DataGenerator.base64Characters().genBytes(9));

      AtomicBoolean bytes1Close = new AtomicBoolean(false);
      AtomicBoolean bytes2Close = new AtomicBoolean(false);

      try (ResponseContentLifecycleHandle<ByteString> handle =
          ResponseContentLifecycleHandle.create(
              bytes1, () -> bytes1Close.compareAndSet(false, true))) {
        read1.accept(handle.borrow(Function.identity()));
      }
      try (ResponseContentLifecycleHandle<ByteString> handle =
          ResponseContentLifecycleHandle.create(
              bytes2, () -> bytes2Close.compareAndSet(false, true))) {
        read1.accept(handle.borrow(Function.identity()));
      }

      // read some bytes, causing leftovers to be populated
      read1.read(ByteBuffer.allocate(1));
      stream.close();

      // call read again to observe the async close that happens
      IOException ioe = assertThrows(IOException.class, () -> read1.read(ByteBuffer.allocate(32)));

      assertAll(
          () -> assertThat(bytes1Close.get()).isTrue(),
          () -> assertThat(bytes2Close.get()).isTrue(),
          () -> assertThat(read1.acceptingBytes()).isFalse(),
          () -> assertThat(ioe).hasCauseThat().isInstanceOf(StorageException.class),
          () -> assertThat(ioe).hasCauseThat().hasMessageThat().contains("Parent stream shutdown"));
    }
  }

  @Test
  public void accumulatingRead_mustCloseQueuedResponsesWhenFailed() throws Exception {
    try (AccumulatingRead<byte[]> read1 =
        ObjectReadSessionStreamRead.createByteArrayAccumulatingRead(
            1, RangeSpec.all(), Hasher.enabled(), RetryContext.neverRetry())) {
      state.putOutstandingRead(1, read1);
      ObjectReadSessionStream stream =
          ObjectReadSessionStream.create(exec, callable, state, RetryContext.neverRetry());

      ByteString bytes1 = ByteString.copyFrom(DataGenerator.base64Characters().genBytes(9));
      ByteString bytes2 = ByteString.copyFrom(DataGenerator.base64Characters().genBytes(9));

      AtomicBoolean bytes1Close = new AtomicBoolean(false);
      AtomicBoolean bytes2Close = new AtomicBoolean(false);

      try (ResponseContentLifecycleHandle<ByteString> handle =
          ResponseContentLifecycleHandle.create(
              bytes1, () -> bytes1Close.compareAndSet(false, true))) {
        read1.accept(handle.borrow(Function.identity()));
      }
      try (ResponseContentLifecycleHandle<ByteString> handle =
          ResponseContentLifecycleHandle.create(
              bytes2, () -> bytes2Close.compareAndSet(false, true))) {
        read1.accept(handle.borrow(Function.identity()));
      }

      stream.close();

      StorageException se =
          assertThrows(StorageException.class, () -> TestUtils.await(read1, 2, TimeUnit.SECONDS));
      assertAll(
          () -> assertThat(bytes1Close.get()).isTrue(),
          () -> assertThat(bytes2Close.get()).isTrue(),
          () -> assertThat(read1.acceptingBytes()).isFalse(),
          () -> assertThat(se).hasMessageThat().contains("Parent stream shutdown"),
          () -> assertThat(se).hasCauseThat().isInstanceOf(AsyncSessionClosedException.class));
    }
  }

  static class TestObjectReadSessionStreamRead
      extends BaseObjectReadSessionStreamRead<java.lang.Object> {

    private static final AtomicLong readIdSeq = new AtomicLong(1);
    protected final long readId;
    private boolean readyToSend = false;
    private final SettableApiFuture<Throwable> fail = SettableApiFuture.create();

    TestObjectReadSessionStreamRead(long readId, RangeSpec rangeSpec, RetryContext retryContext) {
      super(
          rangeSpec,
          new AtomicLong(rangeSpec.begin()),
          retryContext,
          IOAutoCloseable.noOp(),
          false);
      this.readId = readId;
    }

    @Override
    long readId() {
      return readId;
    }

    @Override
    public java.lang.Object project() {
      return this;
    }

    @Override
    public boolean acceptingBytes() {
      return false;
    }

    @Override
    public void accept(ChildRef childRef) {}

    @Override
    public void eof() {}

    @Override
    public ApiFuture<Throwable> fail(Throwable t) {
      fail.set(t);
      return fail;
    }

    @Override
    public Hasher hasher() {
      return Hasher.enabled();
    }

    @Override
    public TestObjectReadSessionStreamRead withNewReadId(long newReadId) {
      return null;
    }

    @Override
    public <T extends Throwable> void recordError(
        T t, OnSuccess onSuccess, OnFailure<T> onFailure) {}

    @Override
    public boolean readyToSend() {
      return readyToSend;
    }

    @Override
    public void internalClose() throws IOException {}

    static TestObjectReadSessionStreamRead of() {
      long id = readIdSeq.getAndIncrement();
      return new TestObjectReadSessionStreamRead(
          id, RangeSpec.of(0, 10), RetryContext.neverRetry());
    }
  }
}
