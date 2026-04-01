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

import static com.google.cloud.storage.TestUtils.apiException;
import static com.google.cloud.storage.TestUtils.assertAll;
import static com.google.cloud.storage.TestUtils.defaultRetryingDeps;
import static com.google.cloud.storage.TestUtils.xxd;
import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth.assertWithMessage;
import static org.junit.Assert.assertThrows;

import com.google.api.core.ApiFuture;
import com.google.api.core.SettableApiFuture;
import com.google.api.gax.grpc.GrpcCallContext;
import com.google.api.gax.retrying.ResultRetryAlgorithm;
import com.google.api.gax.retrying.TimedAttemptSettings;
import com.google.api.gax.rpc.ApiExceptions;
import com.google.api.gax.rpc.UnavailableException;
import com.google.cloud.storage.BufferedWritableByteChannelSession.BufferedWritableByteChannel;
import com.google.cloud.storage.Conversions.Decoder;
import com.google.cloud.storage.Retrying.DefaultRetrier;
import com.google.cloud.storage.SyncAndUploadUnbufferedWritableByteChannel.Alg;
import com.google.cloud.storage.SyncAndUploadUnbufferedWritableByteChannel.RequestStream;
import com.google.cloud.storage.SyncAndUploadUnbufferedWritableByteChannel.ResponseStream;
import com.google.cloud.storage.UnbufferedWritableByteChannelSession.UnbufferedWritableByteChannel;
import com.google.cloud.storage.UnifiedOpts.Opts;
import com.google.cloud.storage.it.ChecksummedTestContent;
import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.primitives.Ints;
import com.google.protobuf.ByteString;
import com.google.protobuf.Message;
import com.google.protobuf.TextFormat;
import com.google.storage.v2.ChecksummedData;
import com.google.storage.v2.Object;
import com.google.storage.v2.ObjectChecksums;
import com.google.storage.v2.QueryWriteStatusRequest;
import com.google.storage.v2.QueryWriteStatusResponse;
import com.google.storage.v2.StartResumableWriteRequest;
import com.google.storage.v2.StartResumableWriteResponse;
import com.google.storage.v2.StorageClient;
import com.google.storage.v2.StorageGrpc.StorageImplBase;
import com.google.storage.v2.WriteObjectRequest;
import com.google.storage.v2.WriteObjectResponse;
import com.google.storage.v2.WriteObjectSpec;
import io.grpc.Status;
import io.grpc.Status.Code;
import io.grpc.stub.StreamObserver;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import net.jqwik.api.Arbitraries;
import net.jqwik.api.Arbitrary;
import net.jqwik.api.Combinators;
import net.jqwik.api.Example;
import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import net.jqwik.api.Provide;
import net.jqwik.api.RandomDistribution;
import net.jqwik.api.Tuple;
import net.jqwik.api.arbitraries.IntegerArbitrary;
import net.jqwik.api.lifecycle.AfterContainer;
import net.jqwik.api.lifecycle.AfterProperty;
import net.jqwik.api.lifecycle.BeforeContainer;
import net.jqwik.api.lifecycle.BeforeProperty;
import net.jqwik.api.lifecycle.BeforeTry;
import org.checkerframework.checker.nullness.qual.NonNull;

public class ITSyncAndUploadUnbufferedWritableByteChannelPropertyTest {

  private static Path tmpFolder;
  private static RecoveryFileManager recoveryFileManager;
  private FailureInducingStorageImpl failureInducingStorage;
  private FakeServer server;
  private GrpcStorageImpl storage;

  @BeforeContainer
  static void beforeContainer() throws IOException {
    tmpFolder =
        Files.createTempDirectory(
            ITSyncAndUploadUnbufferedWritableByteChannelPropertyTest.class.getSimpleName());
    recoveryFileManager = RecoveryFileManager.of(ImmutableList.of(tmpFolder));
  }

  @AfterContainer
  static void afterContainer() throws IOException {
    if (tmpFolder != null) {
      TestUtils.rmDashRf(tmpFolder);
    }
  }

  @BeforeProperty
  void beforeProperty() throws IOException {
    failureInducingStorage = new FailureInducingStorageImpl();
    server = FakeServer.of(failureInducingStorage);
    storage = (GrpcStorageImpl) server.getGrpcStorageOptions().getService();
  }

  @AfterProperty
  void afterProperty() throws Exception {
    // use try-with-resources to do the close dance
    try (AutoCloseable ignore1 = server;
        AutoCloseable ignore2 = storage) {
      storage = null;
      server = null;
    }
  }

  @BeforeTry
  void beforeTry() {
    failureInducingStorage.reset();
  }

  @Example
  void emptyObject() throws Exception {
    Scenario scenario = Scenario.of("empty", 0, 0, 256, 256, FailuresQueue.empty());
    testUploads(scenario);
  }

  @Example
  void requestStream_halfClosedToUnavailable_positive() {
    UnavailableException unavailableException =
        assertThrows(
            UnavailableException.class,
            () ->
                RequestStream.halfClosedToUnavailable(
                    () -> {
                      throw new IllegalStateException("asdf half-closed fdsa");
                    }));
    assertThat(unavailableException)
        .hasCauseThat()
        .hasMessageThat()
        .isEqualTo("asdf half-closed fdsa");
  }

  @Example
  void requestStream_halfClosedToUnavailable_negative() {
    IllegalStateException illegalStateException =
        assertThrows(
            IllegalStateException.class,
            () ->
                RequestStream.halfClosedToUnavailable(
                    () -> {
                      throw new IllegalStateException("blah");
                    }));
    assertThat(illegalStateException).hasMessageThat().isEqualTo("blah");
  }

  @Example
  void alg_shouldSetResultFutureIfNotRetryable() {
    SettableApiFuture<WriteObjectResponse> resultFuture = SettableApiFuture.create();
    Alg alg =
        new Alg((ResultRetryAlgorithmAdapter) (prevThrowable, prevResponse) -> false, resultFuture);

    ForcedFailure ff = new ForcedFailure("should not be retried");
    boolean shouldRetry = alg.shouldRetry(ff, null);
    assertThat(shouldRetry).isFalse();
    assertThat(resultFuture.isDone()).isTrue();
    ExecutionException runtimeException = assertThrows(ExecutionException.class, resultFuture::get);
    assertThat(runtimeException).hasCauseThat().hasMessageThat().isEqualTo("should not be retried");
  }

  @Example
  void alg_shouldNotSetResultFutureIfRetryable() {
    SettableApiFuture<WriteObjectResponse> resultFuture = SettableApiFuture.create();
    Alg alg =
        new Alg((ResultRetryAlgorithmAdapter) (prevThrowable, prevResponse) -> true, resultFuture);

    ForcedFailure ff = new ForcedFailure("can be retried");
    boolean shouldRetry = alg.shouldRetry(ff, null);
    assertThat(shouldRetry).isTrue();
    assertThat(resultFuture.isDone()).isFalse();
  }

  @Example
  void responseStream_onComplete_lastMessageWithResourceMustResolveResultFuture()
      throws ExecutionException, InterruptedException {
    SettableApiFuture<WriteObjectResponse> resultFuture = SettableApiFuture.create();

    ResponseStream responseStream = new ResponseStream(resultFuture);

    Object fake = Object.newBuilder().setName("fake").build();
    WriteObjectResponse response = WriteObjectResponse.newBuilder().setResource(fake).build();
    responseStream.onNext(response);

    assertThat(resultFuture.isDone()).isFalse();
    responseStream.onCompleted();
    assertThat(resultFuture.isDone()).isTrue();
    assertThat(resultFuture.get()).isEqualTo(response);
  }

  @Example
  void responseStream_onComplete_lastMessageWithoutResourceDoesNotResolveResultFuture() {
    SettableApiFuture<WriteObjectResponse> resultFuture = SettableApiFuture.create();

    ResponseStream responseStream = new ResponseStream(resultFuture);

    WriteObjectResponse response = WriteObjectResponse.newBuilder().setPersistedSize(3).build();
    responseStream.onNext(response);

    assertThat(resultFuture.isDone()).isFalse();
    responseStream.onCompleted();
    assertThat(resultFuture.isDone()).isFalse();
  }

  @Example
  void responseStream_await_yields_onComplete() throws ExecutionException, InterruptedException {
    SettableApiFuture<WriteObjectResponse> resultFuture = SettableApiFuture.create();

    ResponseStream responseStream = new ResponseStream(resultFuture);

    ExecutorService executorService = Executors.newSingleThreadExecutor();
    try {
      Future<String> submit =
          executorService.submit(
              () -> {
                responseStream.await();
                return "Success";
              });

      Object fake = Object.newBuilder().setName("fake").build();
      WriteObjectResponse response = WriteObjectResponse.newBuilder().setResource(fake).build();
      responseStream.onNext(response);
      responseStream.onCompleted();

      assertThat(submit.get()).isEqualTo("Success");
    } finally {
      executorService.shutdownNow();
    }
  }

  @Example
  void responseStream_await_yields_onError() throws ExecutionException, InterruptedException {
    SettableApiFuture<WriteObjectResponse> resultFuture = SettableApiFuture.create();

    ResponseStream responseStream = new ResponseStream(resultFuture);

    ExecutorService executorService = Executors.newSingleThreadExecutor();
    try {
      Future<String> submit =
          executorService.submit(
              () -> {
                try {
                  responseStream.await();
                } catch (ForcedFailure ff) {
                  return "Success";
                }
                return "Fail";
              });

      RuntimeException re = new ForcedFailure("error");
      responseStream.onError(re);

      assertThat(submit.get()).isEqualTo("Success");
    } finally {
      executorService.shutdownNow();
    }
  }

  @Example
  void debug() throws Exception {
    testUploads(
        Scenario.of(
            "object--853610591",
            11428,
            1353,
            196608,
            32768,
            new FailuresQueue(
                ImmutableList.of(FailureOffset.of(0), FailureOffset.of(0), FailureOffset.of(0)))));
  }

  //  25 tries leads to ~0m:30s of runtime
  // 250 tries leads to ~6m:00s of runtime
  @Property(tries = 25)
  void testUploads(@ForAll("scenario") Scenario s) throws Exception {

    StorageClient storageClient = storage.storageClient;
    BlobInfo info = BlobInfo.newBuilder("buck", s.objectName).build();
    try (RecoveryFile rf = s.recoveryFileManager.newRecoveryFile(info)) {
      SettableApiFuture<WriteObjectResponse> resultFuture = SettableApiFuture.create();

      ApiFuture<ResumableWrite> f =
          storage.startResumableWrite(
              GrpcCallContext.createDefault(),
              storage.getWriteObjectRequest(info, Opts.empty()),
              Opts.empty());
      ResumableWrite resumableWrite = ApiExceptions.callAndTranslateApiException(f);

      UploadCtx uploadCtx =
          failureInducingStorage.data.get(UploadId.of(resumableWrite.getRes().getUploadId()));

      uploadCtx.failuresQueue = s.failuresQueue;

      SyncAndUploadUnbufferedWritableByteChannel syncAndUpload =
          new SyncAndUploadUnbufferedWritableByteChannel(
              storageClient.writeObjectCallable(),
              storageClient.queryWriteStatusCallable(),
              resultFuture,
              s.chunkSegmenter,
              // TestUtils.defaultRetrier(),
              new DefaultRetrier(UnaryOperator.identity(), defaultRetryingDeps()),
              StorageRetryStrategy.getDefaultStorageRetryStrategy().getIdempotentHandler(),
              WriteCtx.of(resumableWrite, s.chunkSegmenter.getHasher()),
              rf,
              s.copyBuffer);
      try (BufferedWritableByteChannel w = s.buffered(syncAndUpload)) {
        for (ByteString dataFrame : s.dataFrames) {
          w.write(dataFrame.asReadOnlyByteBuffer());
        }
      }

      WriteObjectResponse response = resultFuture.get(1, TimeUnit.SECONDS);
      assertThat(response.hasResource()).isTrue();
      Object resource = response.getResource();

      ByteString actual =
          uploadCtx.parts.stream()
              .filter(WriteObjectRequest::hasChecksummedData)
              .map(wor -> wor.getChecksummedData().getContent())
              .reduce(ByteString.empty(), ByteString::concat);
      ByteString expected = s.dataFrames.stream().reduce(ByteString.empty(), ByteString::concat);
      assertAll(
          () -> assertThat(uploadCtx.getLength()).isEqualTo(s.objectSize),
          () -> assertThat(resource.getSize()).isEqualTo(s.objectSize),
          () -> assertThat(xxd(actual)).isEqualTo(xxd(expected)));
    }
  }

  @Example
  void multipleRetriesAgainstFakeServer() throws Exception {
    ChecksummedTestContent content =
        ChecksummedTestContent.of(DataGenerator.base64Characters().genBytes(17));

    String uploadId = UUID.randomUUID().toString();
    StartResumableWriteRequest reqStart =
        StartResumableWriteRequest.newBuilder()
            .setWriteObjectSpec(
                WriteObjectSpec.newBuilder()
                    .setResource(
                        Object.newBuilder().setBucket("projects/_/buckets/b").setName("o").build())
                    .build())
            .build();
    StartResumableWriteResponse resStart =
        StartResumableWriteResponse.newBuilder().setUploadId(uploadId).build();
    QueryWriteStatusRequest reqQuery =
        QueryWriteStatusRequest.newBuilder().setUploadId(uploadId).build();
    QueryWriteStatusResponse resQuery =
        QueryWriteStatusResponse.newBuilder().setPersistedSize(8).build();
    WriteObjectRequest reqWrite0 =
        WriteObjectRequest.newBuilder()
            .setUploadId(uploadId)
            .setWriteOffset(0)
            .setChecksummedData(content.slice(0, 2).asChecksummedData())
            .build();
    WriteObjectRequest reqWrite2 =
        WriteObjectRequest.newBuilder()
            .setWriteOffset(2)
            .setChecksummedData(content.slice(2, 2).asChecksummedData())
            .build();
    WriteObjectRequest reqWrite4 =
        WriteObjectRequest.newBuilder()
            .setWriteOffset(4)
            .setChecksummedData(content.slice(4, 2).asChecksummedData())
            .build();
    WriteObjectRequest reqWrite6 =
        WriteObjectRequest.newBuilder()
            .setWriteOffset(6)
            .setChecksummedData(content.slice(6, 2).asChecksummedData())
            .build();
    WriteObjectRequest reqWrite8 =
        WriteObjectRequest.newBuilder()
            .setWriteOffset(8)
            .setChecksummedData(content.slice(8, 2).asChecksummedData())
            .build();
    WriteObjectRequest reqWrite8WithUploadId = reqWrite8.toBuilder().setUploadId(uploadId).build();
    WriteObjectRequest reqWrite10 =
        WriteObjectRequest.newBuilder()
            .setWriteOffset(10)
            .setChecksummedData(content.slice(10, 2).asChecksummedData())
            .build();
    WriteObjectRequest reqWrite12 =
        WriteObjectRequest.newBuilder()
            .setWriteOffset(12)
            .setChecksummedData(content.slice(12, 2).asChecksummedData())
            .build();
    WriteObjectRequest reqWrite14 =
        WriteObjectRequest.newBuilder()
            .setWriteOffset(14)
            .setChecksummedData(content.slice(14, 2).asChecksummedData())
            .build();
    WriteObjectRequest reqWrite16 =
        WriteObjectRequest.newBuilder()
            .setWriteOffset(16)
            .setChecksummedData(content.slice(16, 1).asChecksummedData())
            .build();
    WriteObjectRequest reqFinish =
        WriteObjectRequest.newBuilder()
            .setFinishWrite(true)
            .setObjectChecksums(ObjectChecksums.newBuilder().setCrc32C(content.getCrc32c()).build())
            .mergeFrom(reqWrite16)
            .build();
    WriteObjectResponse resFinish =
        WriteObjectResponse.newBuilder()
            .setResource(
                reqStart.getWriteObjectSpec().getResource().toBuilder()
                    .setGeneration(1)
                    .setSize(17)
                    .setChecksums(
                        ObjectChecksums.newBuilder()
                            .setCrc32C(content.getCrc32c())
                            .setMd5Hash(content.getMd5Bytes())
                            .build())
                    .build())
            .build();
    ImmutableSet<WriteObjectRequest> allReqWrite =
        ImmutableSet.of(
            reqWrite0,
            reqWrite2,
            reqWrite4,
            reqWrite6,
            reqWrite8,
            reqWrite10,
            reqWrite12,
            reqWrite14,
            reqWrite16);

    AtomicInteger retryCount = new AtomicInteger(0);
    StorageImplBase service =
        new StorageImplBase() {
          @Override
          public void startResumableWrite(
              StartResumableWriteRequest req, StreamObserver<StartResumableWriteResponse> respond) {
            if (req.equals(reqStart)) {
              respond.onNext(resStart);
              respond.onCompleted();
            } else {
              unexpected(respond, req);
            }
          }

          @Override
          public void queryWriteStatus(
              QueryWriteStatusRequest req, StreamObserver<QueryWriteStatusResponse> respond) {
            if (req.equals(reqQuery)) {
              respond.onNext(resQuery);
              respond.onCompleted();
            } else {
              unexpected(respond, req);
            }
          }

          @Override
          public StreamObserver<WriteObjectRequest> writeObject(
              StreamObserver<WriteObjectResponse> respond) {
            return new StreamObserver<WriteObjectRequest>() {
              @Override
              public void onNext(WriteObjectRequest value) {
                if (value.equals(reqFinish)) {
                  respond.onNext(resFinish);
                  respond.onCompleted();
                } else if (value.equals(reqWrite10)) {
                  int i = retryCount.get();
                  if (i < 2) {
                    respond.onError(apiException(Code.UNAVAILABLE, "{Unavailable}"));
                  }
                } else if (value.equals(reqWrite8WithUploadId)) {
                  retryCount.incrementAndGet();
                } else if (allReqWrite.contains(value)) {
                  // do nothing
                } else {
                  unexpected(respond, value);
                }
              }

              @Override
              public void onError(Throwable t) {}

              @Override
              public void onCompleted() {}
            };
          }

          private void unexpected(StreamObserver<?> respond, Message msg) {
            respond.onError(
                apiException(
                    Code.UNIMPLEMENTED,
                    "Unexpected request { " + TextFormat.printer().shortDebugString(msg) + " }"));
          }
        };
    try (FakeServer fakeServer = FakeServer.of(service);
        GrpcStorageImpl storage =
            (GrpcStorageImpl) fakeServer.getGrpcStorageOptions().getService()) {

      BlobInfo info = BlobInfo.newBuilder("b", "o").build();
      SettableApiFuture<WriteObjectResponse> resultFuture = SettableApiFuture.create();
      BufferHandle recoverBufferHandle = BufferHandle.allocate(2);
      ChunkSegmenter chunkSegmenter =
          new ChunkSegmenter(Hasher.enabled(), ByteStringStrategy.copy(), 2, 2);
      SyncAndUploadUnbufferedWritableByteChannel syncAndUpload =
          new SyncAndUploadUnbufferedWritableByteChannel(
              storage.storageClient.writeObjectCallable(),
              storage.storageClient.queryWriteStatusCallable(),
              resultFuture,
              chunkSegmenter,
              new DefaultRetrier(UnaryOperator.identity(), storage.getOptions()),
              StorageRetryStrategy.getDefaultStorageRetryStrategy().getIdempotentHandler(),
              WriteCtx.of(
                  new ResumableWrite(
                      reqStart,
                      resStart,
                      id -> reqWrite0.toBuilder().clearWriteObjectSpec().setUploadId(id).build()),
                  chunkSegmenter.getHasher()),
              recoveryFileManager.newRecoveryFile(info),
              recoverBufferHandle);
      try (BufferedWritableByteChannel w =
          StorageByteChannels.writable()
              .createSynchronized(
                  new DefaultBufferedWritableByteChannel(recoverBufferHandle, syncAndUpload))) {
        w.write(ByteBuffer.wrap(content.getBytes()));
      }

      Decoder<WriteObjectResponse, BlobInfo> decoder =
          Conversions.grpc().blobInfo().compose(WriteObjectResponse::getResource);
      BlobInfo actual = decoder.decode(resultFuture.get(3, TimeUnit.SECONDS));
      assertThat(actual.getSize()).isEqualTo(content.getBytes().length);
      assertThat(actual.getCrc32c()).isEqualTo(content.getCrc32cBase64());
    }
  }

  static List<ByteString> dataFrames(long length, int segmentLength) {
    // todo: rethink this
    Random rand = new Random(length);
    ArrayList<ByteString> segments = new ArrayList<>();

    int i = 0;
    for (; i < length; i += segmentLength) {
      long remaining = length - i;
      int size = Math.toIntExact(Math.min(remaining, segmentLength));
      byte[] bytes = DataGenerator.rand(rand).genBytes(size);
      if (size > 4) {
        byte[] byteArray = Ints.toByteArray(i);
        ByteString offset = ByteString.copyFrom(byteArray);
        ByteString concat = offset.concat(ByteString.copyFrom(bytes, 4, bytes.length - 4));
        segments.add(concat);
      } else {
        segments.add(ByteString.copyFrom(bytes));
      }
    }

    return ImmutableList.copyOf(segments);
  }

  @Provide("scenario")
  static Arbitrary<Scenario> scenarioArbitrary() {
    // 1. choose an alignment quantum
    return alignmentQuantumArbitrary()
        .flatMap(
            quantum ->
                Combinators.combine(
                        Arbitraries.just(quantum),
                        // 2. choose a segment size between 1 and 8 times the quantum
                        ints().between(1, 8).map(mult -> quantum * mult))
                    .as(Tuple::of))
        .flatMap(
            t -> {
              int segmentSize = t.get2();
              return Combinators.combine(
                      Arbitraries.just(t.get1()),
                      Arbitraries.just(segmentSize),
                      // 3. choose an object size between 0 and 32 time segment size
                      //   this helps keep the maximum number of rights relatively low and
                      //   proportional with the size of the object
                      ints().between(0, 32 * segmentSize))
                  .as(Tuple::of);
            })
        .flatMap(
            t -> {
              int quantum = t.get1();
              int objectSize = t.get3();
              // if the object isn't 0 bytes, set our min write size to be 1
              int minWriteSize = Math.min(1, objectSize);

              // determine how many quantum will make up the full object
              // we want to align failures to quantum boundaries like GCS does
              int quantumCount = objectSize / quantum;
              return Combinators.combine(
                      Arbitraries.just(quantum),
                      Arbitraries.just(t.get2()),
                      Arbitraries.just(objectSize),
                      ints().between(minWriteSize, objectSize),
                      // 4. generate between 0 and 3 failure offsets
                      ints()
                          .between(0, quantumCount)
                          .map(i -> FailureOffset.of((long) i * quantum))
                          .list()
                          .ofMinSize(0)
                          .ofMaxSize(3)
                          .map(FailuresQueue::new))
                  .as(Tuple::of);
            })
        .map(
            t -> {
              // 5. Construct our scenario from the generated values
              int quantum = t.get1();
              int segmentSize = t.get2();
              int objectSize = t.get3();
              int writeSize = t.get4();
              return Scenario.of(
                  String.format(Locale.US, "object-%d", t.hashCode()),
                  objectSize,
                  writeSize,
                  segmentSize,
                  quantum,
                  t.get5());
            })
        // The way we're defining things there aren't critical edge cases. Let jqwik know, so it
        // can be smarter about generation, evaluation and shrinking
        .withoutEdgeCases();
  }

  static Arbitrary<Integer> alignmentQuantumArbitrary() {
    // 16..256KiB
    return ints().between(4, 18).map(i -> Math.toIntExact((long) Math.pow(2, i)));
  }

  @NonNull
  private static IntegerArbitrary ints() {
    return Arbitraries.integers().withDistribution(RandomDistribution.uniform());
  }

  private static String fmt(int i) {
    return String.format(Locale.US, "% 10d (0x%08x)", i, i);
  }

  private static final class Scenario {
    private final String toString;
    private final String objectName;
    private final long objectSize;
    private final ChunkSegmenter chunkSegmenter;
    private final BufferHandle bufferHandle;
    private final BufferHandle copyBuffer;
    private final FailuresQueue failuresQueue;
    private final RecoveryFileManager recoveryFileManager;
    private final List<ByteString> dataFrames;

    private Scenario(
        String toString,
        String objectName,
        long objectSize,
        ChunkSegmenter chunkSegmenter,
        BufferHandle bufferHandle,
        BufferHandle copyBuffer,
        FailuresQueue failuresQueue,
        RecoveryFileManager recoveryFileManager,
        List<ByteString> dataFrames) {
      this.toString = toString;
      this.objectName = objectName;
      this.objectSize = objectSize;
      this.chunkSegmenter = chunkSegmenter;
      this.bufferHandle = bufferHandle;
      this.copyBuffer = copyBuffer;
      this.failuresQueue = failuresQueue;
      this.recoveryFileManager = recoveryFileManager;
      this.dataFrames = dataFrames;
    }

    BufferedWritableByteChannel buffered(UnbufferedWritableByteChannel c) {
      return StorageByteChannels.writable()
          .createSynchronized(new DefaultBufferedWritableByteChannel(bufferHandle, c));
    }

    public static Scenario of(
        String objectName,
        long objectSize,
        int writeSize,
        int segmentSize,
        int quantum,
        FailuresQueue failuresQueue) {

      List<FailureOffset> nonQuantumAligned =
          failuresQueue.statuses.stream()
              .filter(f -> f.getOffset() % quantum != 0)
              .collect(Collectors.toList());
      assertWithMessage("Failure offsets not quantum aligned (quantum=%s)", fmt(quantum))
          .that(nonQuantumAligned)
          .isEmpty();
      List<ByteString> dataFrames = dataFrames(objectSize, writeSize);
      return new Scenario(
          MoreObjects.toStringHelper(Scenario.class)
              .add("\n  objectName", objectName)
              .add("\n  objectSize", objectSize)
              .add("\n  writeSize", writeSize)
              .add("\n  segmentSize", segmentSize)
              .add("\n  quantum", quantum)
              .add("\n  dataFrames.size()", dataFrames.size())
              .add("\n  failuresQueue", failuresQueue)
              .addValue("\n")
              .toString(),
          objectName,
          objectSize,
          new ChunkSegmenter(Hasher.enabled(), ByteStringStrategy.copy(), segmentSize, quantum),
          BufferHandle.allocate(segmentSize),
          BufferHandle.allocate(segmentSize),
          failuresQueue,
          ITSyncAndUploadUnbufferedWritableByteChannelPropertyTest.recoveryFileManager,
          dataFrames);
    }

    @Override
    public String toString() {
      return toString;
    }
  }

  private static final class UploadId {
    private final String id;

    private UploadId(String id) {
      this.id = id;
    }

    private static UploadId of(String id) {
      return new UploadId(id);
    }

    @Override
    public boolean equals(java.lang.Object o) {
      if (this == o) {
        return true;
      }
      if (!(o instanceof UploadId)) {
        return false;
      }
      UploadId uploadId = (UploadId) o;
      return Objects.equals(id, uploadId.id);
    }

    @Override
    public int hashCode() {
      return Objects.hash(id);
    }

    @Override
    public String toString() {
      return MoreObjects.toStringHelper(this).add("id", id).toString();
    }
  }

  private static final class UploadCtx {
    private final UploadId id;
    private final StartResumableWriteRequest req;

    private final List<WriteObjectRequest> parts;

    private FailuresQueue failuresQueue;
    private long length;

    private UploadCtx(UploadId id, StartResumableWriteRequest req) {
      this.id = id;
      this.req = req;
      this.parts = Collections.synchronizedList(new ArrayList<>());
    }

    public static UploadCtx of(UploadId id, StartResumableWriteRequest req) {
      return new UploadCtx(id, req);
    }

    UploadId getId() {
      return id;
    }

    StartResumableWriteRequest getReq() {
      return req;
    }

    void addPart(WriteObjectRequest req) {
      length += req.getChecksummedData().getContent().size();
      parts.add(req);
    }

    long getLength() {
      return length;
    }

    boolean finishWrite() {
      if (!parts.isEmpty()) {
        return parts.get(parts.size() - 1).getFinishWrite();
      } else {
        return false;
      }
    }

    public Code consume(WriteObjectRequest req) {
      if (failuresQueue != null) {
        FailureOffset peek = failuresQueue.pending.peekFirst();
        if (peek != null) {
          if (req.hasChecksummedData()) {
            long writeOffset = req.getWriteOffset();
            ByteString content = req.getChecksummedData().getContent();
            int size = content.size();
            boolean applies = writeOffset <= peek.offset && peek.offset < writeOffset + size;
            if (applies) {
              int subLength = Math.toIntExact(Math.subtractExact(peek.offset, writeOffset));
              ByteString substring = content.substring(0, subLength);
              WriteObjectRequest.Builder b = req.toBuilder();
              b.getChecksummedDataBuilder().setContent(substring);
              b.clearFinishWrite();
              failuresQueue.pending.pop();
              length += substring.size();
              parts.add(b.build());
              return peek.getStatus();
            }
          }
        }
      }
      addPart(req);
      return Code.OK;
    }
  }

  private static final class FailuresQueue {

    private final List<FailureOffset> statuses;

    private final Deque<FailureOffset> pending;

    private FailuresQueue(List<FailureOffset> statuses) {
      this.statuses = ImmutableList.sortedCopyOf(FailureOffset.COMP, statuses);
      ArrayDeque<FailureOffset> tmp = new ArrayDeque<>();
      this.statuses.forEach(tmp::addLast);
      this.pending = tmp;
    }

    @Override
    public String toString() {
      return MoreObjects.toStringHelper(this).add("statuses", statuses).toString();
    }

    static FailuresQueue empty() {
      return new FailuresQueue(ImmutableList.of());
    }
  }

  private static final class FailureOffset implements Comparable<FailureOffset> {
    private static final Comparator<FailureOffset> COMP =
        Comparator.comparing(FailureOffset::getOffset);
    private final long offset;
    private final Status.Code status;

    private FailureOffset(long offset, Code status) {
      this.offset = offset;
      this.status = status;
    }

    public long getOffset() {
      return offset;
    }

    public Code getStatus() {
      return status;
    }

    @Override
    public int compareTo(FailureOffset o) {
      return COMP.compare(this, o);
    }

    @Override
    public String toString() {
      return MoreObjects.toStringHelper(this)
          .add("offset", offset)
          .add("status", status)
          .toString();
    }

    private static FailureOffset of(long offset) {
      return new FailureOffset(offset, Code.INTERNAL);
    }
  }

  private static final class FailureInducingStorageImpl extends StorageImplBase {

    private final Map<UploadId, UploadCtx> data;

    public FailureInducingStorageImpl() {
      this.data = Collections.synchronizedMap(new HashMap<>());
    }

    void reset() {
      data.clear();
    }

    @Override
    public void startResumableWrite(
        StartResumableWriteRequest request,
        StreamObserver<StartResumableWriteResponse> responseObserver) {
      UploadId id = UploadId.of(UUID.randomUUID().toString());
      data.put(id, UploadCtx.of(id, request));
      StartResumableWriteResponse startResumableWriteResponse =
          StartResumableWriteResponse.newBuilder().setUploadId(id.id).build();
      responseObserver.onNext(startResumableWriteResponse);
      responseObserver.onCompleted();
    }

    @Override
    public StreamObserver<WriteObjectRequest> writeObject(
        StreamObserver<WriteObjectResponse> responseObserver) {
      return new FailureInducingWriteObjectRequestObserver(responseObserver, data);
    }

    @Override
    public void queryWriteStatus(
        QueryWriteStatusRequest queryWriteStatusRequest,
        StreamObserver<QueryWriteStatusResponse> responseObserver) {
      UploadId uploadId = UploadId.of(queryWriteStatusRequest.getUploadId());
      UploadCtx ctx;
      if (data.containsKey(uploadId)) {
        ctx = data.get(uploadId);
      } else {
        responseObserver.onError(Code.NOT_FOUND.toStatus().asRuntimeException());
        return;
      }
      QueryWriteStatusResponse.Builder b = QueryWriteStatusResponse.newBuilder();
      if (ctx.finishWrite()) {
        b.setResource(
            ctx.getReq().getWriteObjectSpec().getResource().toBuilder()
                .setSize(ctx.getLength())
                .setGeneration(1)
                .setMetageneration(1)
                .build());
      } else {
        b.setPersistedSize(ctx.getLength());
      }
      QueryWriteStatusResponse queryWriteStatusResponse = b.build();
      responseObserver.onNext(queryWriteStatusResponse);
      responseObserver.onCompleted();
    }
  }

  private static final class FailureInducingWriteObjectRequestObserver
      implements StreamObserver<WriteObjectRequest> {
    private final StreamObserver<WriteObjectResponse> responseObserver;
    private final Map<UploadId, UploadCtx> data;

    private UploadCtx ctx;
    private boolean errored;

    public FailureInducingWriteObjectRequestObserver(
        StreamObserver<WriteObjectResponse> responseObserver, Map<UploadId, UploadCtx> data) {
      this.data = data;
      this.responseObserver = responseObserver;
      this.ctx = null;
      this.errored = false;
    }

    @Override
    public void onNext(WriteObjectRequest writeObjectRequest) {
      if (writeObjectRequest.hasChecksummedData()) {
        ChecksummedData checksummedData = writeObjectRequest.getChecksummedData();
        if (!checksummedData.hasCrc32C()) {
          errored = true;
          sendFailure("no crc32c value specified");
          return;
        }
        if (!checksummedData.getContent().isEmpty() && checksummedData.getCrc32C() == 0) {
          errored = true;
          sendFailure("crc32c value of 0 with non-empty content");
          return;
        }
      }
      if (writeObjectRequest.hasObjectChecksums()
          && !writeObjectRequest.getObjectChecksums().hasCrc32C()) {
        errored = true;
        sendFailure("missing object_checksums.crc32c");
        return;
      }
      if (ctx == null) {
        UploadId uploadId = UploadId.of(writeObjectRequest.getUploadId());
        if (data.containsKey(uploadId)) {
          ctx = data.get(uploadId);
        } else {
          errored = true;
          responseObserver.onError(Code.NOT_FOUND.toStatus().asRuntimeException());
          return;
        }
      }
      Status.Code ret = ctx.consume(writeObjectRequest);
      if (ret != Code.OK) {
        errored = true;
        responseObserver.onError(ret.toStatus().asRuntimeException());
      }
    }

    @Override
    public void onError(Throwable throwable) {
      if (errored) {
        return;
      }
      responseObserver.onError(throwable);
    }

    @Override
    public void onCompleted() {
      if (errored) {
        return;
      }
      WriteObjectResponse resp =
          WriteObjectResponse.newBuilder()
              .setResource(
                  ctx.getReq().getWriteObjectSpec().getResource().toBuilder()
                      .setSize(ctx.getLength())
                      .setGeneration(1)
                      .setMetageneration(1)
                      .build())
              .build();
      responseObserver.onNext(resp);
      responseObserver.onCompleted();
    }

    private void sendFailure(String description) {
      responseObserver.onError(
          Code.INVALID_ARGUMENT.toStatus().withDescription(description).asRuntimeException());
    }
  }

  @FunctionalInterface
  private interface ResultRetryAlgorithmAdapter extends ResultRetryAlgorithm<java.lang.Object> {

    @Override
    default TimedAttemptSettings createNextAttempt(
        Throwable prevThrowable, java.lang.Object prevResponse, TimedAttemptSettings prevSettings) {
      return null;
    }
  }

  private static final class ForcedFailure extends RuntimeException {
    public ForcedFailure(String message) {
      super(message);
    }
  }
}
