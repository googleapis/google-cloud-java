/*
 * Copyright 2025 Google LLC
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

import static com.google.cloud.storage.BidiUploadTestUtils.makeRedirect;
import static com.google.cloud.storage.BidiUploadTestUtils.packRedirectIntoAbortedException;
import static com.google.cloud.storage.BidiUploadTestUtils.timestampNow;
import static com.google.cloud.storage.ByteSizeConstants._2MiB;
import static com.google.cloud.storage.StorageV2ProtoUtils.fmtProto;
import static com.google.cloud.storage.TestUtils.assertAll;
import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertThrows;

import com.google.api.core.ApiFuture;
import com.google.api.core.SettableApiFuture;
import com.google.api.gax.grpc.GrpcCallContext;
import com.google.api.gax.rpc.AbortedException;
import com.google.cloud.storage.BidiUploadState.AppendableUploadState;
import com.google.cloud.storage.BlobAppendableUpload.AppendableUploadWriteableByteChannel;
import com.google.cloud.storage.BlobAppendableUploadConfig.CloseAction;
import com.google.cloud.storage.Storage.BlobField;
import com.google.cloud.storage.it.ChecksummedTestContent;
import com.google.common.collect.ImmutableMap;
import com.google.protobuf.Any;
import com.google.protobuf.ByteString;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Message;
import com.google.protobuf.TextFormat;
import com.google.rpc.Code;
import com.google.rpc.DebugInfo;
import com.google.storage.v2.AppendObjectSpec;
import com.google.storage.v2.BidiWriteHandle;
import com.google.storage.v2.BidiWriteObjectRequest;
import com.google.storage.v2.BidiWriteObjectResponse;
import com.google.storage.v2.BucketName;
import com.google.storage.v2.ChecksummedData;
import com.google.storage.v2.GetObjectRequest;
import com.google.storage.v2.Object;
import com.google.storage.v2.ObjectChecksums;
import com.google.storage.v2.StorageGrpc;
import com.google.storage.v2.WriteObjectSpec;
import io.grpc.Metadata;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.time.Duration;
import java.util.Collection;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.junit.Ignore;
import org.junit.Test;

public class ITAppendableUploadFakeTest {
  private static final byte[] ALL_OBJECT_BYTES = DataGenerator.base64Characters().genBytes(64);

  private static final Object METADATA =
      Object.newBuilder()
          .setBucket(BucketName.format("_", "b"))
          .setName("o")
          .setGeneration(1)
          .setSize(_2MiB)
          .build();
  private static final BidiWriteObjectRequest REQ_OPEN =
      BidiWriteObjectRequest.newBuilder()
          .setWriteObjectSpec(
              WriteObjectSpec.newBuilder()
                  .setResource(
                      Object.newBuilder()
                          .setBucket(METADATA.getBucket())
                          .setName(METADATA.getName()))
                  .setAppendable(true)
                  .build())
          .setChecksummedData(
              ChecksummedData.newBuilder().setContent(ByteString.copyFromUtf8("ABCDE")).build())
          .build();

  private static final BlobAppendableUploadConfig UPLOAD_CONFIG =
      BlobAppendableUploadConfig.of()
          .withFlushPolicy(FlushPolicy.maxFlushSize(3))
          .withCloseAction(CloseAction.FINALIZE_WHEN_CLOSING);

  private static final ChecksummedTestContent content =
      ChecksummedTestContent.of(ALL_OBJECT_BYTES, 0, 10);
  private static final ObjectChecksums checksums =
      ObjectChecksums.newBuilder().setCrc32C(content.getCrc32c()).build();
  private static final BidiWriteObjectRequest flushLookup =
      BidiWriteObjectRequest.newBuilder().setFlush(true).setStateLookup(true).build();
  private static final BidiWriteObjectRequest abc = incrementalRequest(0, "ABC");
  private static final BidiWriteObjectRequest def = incrementalRequest(3, "DEF");
  private static final BidiWriteObjectRequest ghi = incrementalRequest(6, "GHI");
  private static final BidiWriteObjectRequest j = incrementalRequest(9, "J");
  private static final BidiWriteObjectRequest j_flush =
      j.toBuilder().mergeFrom(flushLookup).build();
  private static final BidiWriteObjectRequest j_finish =
      j.toBuilder().setFinishWrite(true).setObjectChecksums(checksums).build();
  private static final BidiWriteObjectRequest finish_10 =
      BidiWriteObjectRequest.newBuilder()
          .setWriteOffset(10)
          .setFinishWrite(true)
          .setObjectChecksums(checksums)
          .build();

  private static final BidiWriteObjectRequest open_abc =
      REQ_OPEN.toBuilder().mergeFrom(abc).build();
  private static final BidiWriteObjectResponse res_abc =
      BidiWriteObjectResponse.newBuilder()
          .setResource(
              Object.newBuilder()
                  .setName(METADATA.getName())
                  .setBucket(METADATA.getBucket())
                  .setGeneration(METADATA.getGeneration())
                  .setSize(3)
                  .setChecksums(
                      ObjectChecksums.newBuilder()
                          .setCrc32C(content.slice(0, 3).getCrc32c())
                          .build())
                  // real object would have some extra fields like metageneration and storage
                  // class
                  .build())
          .build();
  private static final BidiWriteObjectRequest reconnect =
      BidiWriteObjectRequest.newBuilder()
          .setAppendObjectSpec(
              AppendObjectSpec.newBuilder()
                  .setBucket(METADATA.getBucket())
                  .setObject(METADATA.getName())
                  .setGeneration(METADATA.getGeneration())
                  .build())
          .setStateLookup(true)
          .build();
  private static final BidiWriteObjectResponse resource_10 =
      BidiWriteObjectResponse.newBuilder()
          .setResource(
              Object.newBuilder()
                  .setName(METADATA.getName())
                  .setBucket(METADATA.getBucket())
                  .setGeneration(METADATA.getGeneration())
                  .setSize(10)
                  .setChecksums(checksums)
                  .setFinalizeTime(timestampNow())
                  // real object would have some extra fields like metageneration and storage
                  // class
                  .build())
          .build();
  public static final GetObjectRequest get_generation_mask =
      GetObjectRequest.newBuilder()
          .setObject(METADATA.getName())
          .setBucket(METADATA.getBucket())
          .setReadMask(FieldMask.newBuilder().addPaths(BlobField.GENERATION.getGrpcName()).build())
          .build();

  private static final ChunkSegmenter smallSegmenter =
      new ChunkSegmenter(Hasher.enabled(), ByteStringStrategy.copy(), 3, 3);

  @Test
  public void bidiWriteObjectRedirectedError_maxAttempts() throws Exception {
    String routingToken1 = "routingToken1";
    String routingToken2 = "routingToken2";
    String routingToken3 = "routingToken3";
    String routingToken4 = "routingToken4";
    String routingToken5 = "routingToken5";

    BidiWriteHandle writeHandle =
        BidiWriteHandle.newBuilder()
            .setHandle(ByteString.copyFromUtf8(UUID.randomUUID().toString()))
            .build();

    BidiWriteObjectRequest redirectReconcile =
        BidiWriteObjectRequest.newBuilder()
            .setAppendObjectSpec(
                AppendObjectSpec.newBuilder()
                    .setBucket(METADATA.getBucket())
                    .setObject(METADATA.getName())
                    .setGeneration(METADATA.getGeneration())
                    .setWriteHandle(writeHandle)
                    .build())
            .setStateLookup(true)
            .build();

    BidiWriteObjectRequest redirectRequest1 =
        BidiUploadTestUtils.withRedirectToken(redirectReconcile, routingToken1);
    BidiWriteObjectRequest redirectRequest2 =
        BidiUploadTestUtils.withRedirectToken(redirectReconcile, routingToken2);
    BidiWriteObjectRequest redirectRequest3 =
        BidiUploadTestUtils.withRedirectToken(redirectReconcile, routingToken3);
    BidiWriteObjectRequest redirectRequest4 =
        BidiUploadTestUtils.withRedirectToken(redirectReconcile, routingToken4);

    AtomicInteger redirectCounter = new AtomicInteger();
    FakeStorage fake =
        FakeStorage.of(
            ImmutableMap.of(
                BidiUploadTestUtils.withFlushAndStateLookup(open_abc),
                respond -> {
                  BidiWriteObjectResponse.Builder b = res_abc.toBuilder();
                  b.setWriteHandle(writeHandle);
                  BidiWriteObjectResponse resAbcWithHandle = b.build();
                  respond.onNext(resAbcWithHandle);
                },
                BidiUploadTestUtils.withFlushAndStateLookup(def),
                respond -> {
                  redirectCounter.getAndIncrement();
                  respond.onError(packRedirectIntoAbortedException(makeRedirect(routingToken1)));
                },
                redirectRequest1,
                respond -> {
                  redirectCounter.getAndIncrement();
                  respond.onError(packRedirectIntoAbortedException(makeRedirect(routingToken2)));
                },
                redirectRequest2,
                respond -> {
                  redirectCounter.getAndIncrement();
                  respond.onError(packRedirectIntoAbortedException(makeRedirect(routingToken3)));
                },
                redirectRequest3,
                respond -> {
                  redirectCounter.getAndIncrement();
                  respond.onError(packRedirectIntoAbortedException(makeRedirect(routingToken4)));
                },
                redirectRequest4,
                respond -> {
                  redirectCounter.getAndIncrement();
                  respond.onError(packRedirectIntoAbortedException(makeRedirect(routingToken5)));
                }));

    try (FakeServer fakeServer = FakeServer.of(fake);
        Storage storage =
            fakeServer.getGrpcStorageOptions().toBuilder()
                .setRetrySettings(
                    fakeServer.getGrpcStorageOptions().getRetrySettings().toBuilder()
                        .setRetryDelayMultiplier(1.0)
                        .setInitialRetryDelayDuration(Duration.ofMillis(10))
                        .build())
                .build()
                .getService()) {

      BlobId id = BlobId.of("b", "o");
      BlobAppendableUploadConfig config =
          BlobAppendableUploadConfig.of()
              .withFlushPolicy(FlushPolicy.maxFlushSize(3))
              .withCloseAction(CloseAction.CLOSE_WITHOUT_FINALIZING);
      BlobAppendableUpload b =
          storage.blobAppendableUpload(BlobInfo.newBuilder(id).build(), config);
      IOException ioe =
          assertThrows(
              IOException.class,
              () -> {
                AppendableUploadWriteableByteChannel channel = b.open();
                ByteBuffer wrap = ByteBuffer.wrap(content.getBytes());
                Buffers.emptyTo(wrap, channel);
                channel.close();
              });

      assertAll(
          () -> assertThat(redirectCounter.get()).isEqualTo(4),
          () -> {
            ExecutionException ee =
                assertThrows(
                    ExecutionException.class, () -> b.getResult().get(3, TimeUnit.SECONDS));
            assertThat(ee).hasCauseThat().isInstanceOf(StorageException.class);
            assertThat(ee).hasCauseThat().hasCauseThat().isInstanceOf(AbortedException.class);
          },
          () -> assertThat(ioe).hasCauseThat().isInstanceOf(StorageException.class),
          () -> assertThat(ioe).hasCauseThat().hasCauseThat().isInstanceOf(AbortedException.class));
    }
  }

  /**
   * We use a small segmenter (3 byte segments) and flush "ABCDEFGHIJ". We make sure that this
   * resolves to segments of "ABC"/"DEF"/"GHI"/"J".
   */
  @Test
  public void testFlushMultipleSegments() throws Exception {

    FakeStorage fake =
        FakeStorage.of(
            ImmutableMap.of(
                open_abc,
                respond -> {},
                def,
                respond -> {},
                ghi,
                respond -> {},
                j_flush,
                respond -> respond.onNext(incrementalResponse(10)),
                finish_10,
                respond -> {
                  respond.onNext(resource_10);
                  respond.onCompleted();
                }));

    runTestFlushMultipleSegments(fake);
  }

  /**
   * We use a small segmenter and flush "ABCDEFGHIJ", which will resolve to "ABC"/"DEF"/"GHI"/"J".
   * While flushing "GHI" we get a retryable error. We make sure that the retry loop handles
   * skipping the already-ack'd messages (i.e. "ABC" and "DEF") by using a map to count how many
   * times the fake server sees those messages, and throwing an error if it sees them more than
   * once.
   */
  @Test
  public void testFlushMultipleSegments_failsHalfway() throws Exception {
    Map<BidiWriteObjectRequest, Integer> map = new ConcurrentHashMap<>();
    Consumer<StreamObserver<BidiWriteObjectResponse>> finish10Respond =
        maxRetries(j_finish, resource_10, map, 1);
    FakeStorage fake =
        FakeStorage.of(
            ImmutableMap.of(
                open_abc,
                maxRetries(open_abc, res_abc, map, 1),
                def,
                maxRetries(def, map, 1),
                ghi,
                retryableErrorOnce(ghi, map, 2),
                reconnect,
                maxRetries(reconnect, incrementalResponse(6), map, 1),
                j_finish,
                respond -> {
                  finish10Respond.accept(respond);
                  respond.onCompleted();
                }),
            ImmutableMap.of(
                get_generation_mask,
                Object.newBuilder().setGeneration(METADATA.getGeneration()).build()));

    runTestFlushMultipleSegments(fake);

    assertThat(map)
        .isEqualTo(
            ImmutableMap.of(
                open_abc, 1,
                def, 1,
                ghi, 2,
                reconnect, 1,
                j_finish, 1));
  }

  /**
   * We use a small segmenter and flush "ABCDEFGHIJ", which will resolve to "ABC"/"DEF"/"GHI"/"J"
   * While flushing "GHI" we get a retryable error, and the response on the reconnect indicates that
   * there was a partial flush (i.e. only "G" got flushed). The retry loop handles skipping the "G"
   * and only sending "HI", and updating the offsets accordingly.
   */
  @Test
  @Ignore("messages splitting")
  public void testFlushMultipleSegments_failsHalfway_partialFlush() throws Exception {
    BidiWriteHandle writeHandle =
        BidiWriteHandle.newBuilder()
            .setHandle(ByteString.copyFromUtf8(UUID.randomUUID().toString()))
            .build();

    ChunkSegmenter smallSegmenter =
        new ChunkSegmenter(Hasher.enabled(), ByteStringStrategy.copy(), 3, 3);

    BidiWriteObjectRequest req1 =
        REQ_OPEN.toBuilder()
            .setChecksummedData(
                ChecksummedData.newBuilder().setContent(ByteString.copyFromUtf8("ABC")))
            .build();

    BidiWriteObjectResponse res1 =
        BidiWriteObjectResponse.newBuilder()
            .setResource(
                Object.newBuilder()
                    .setName(METADATA.getName())
                    .setBucket(METADATA.getBucket())
                    .setGeneration(METADATA.getGeneration())
                    .setSize(3)
                    // real object would have some extra fields like metageneration and storage
                    // class
                    .build())
            .setWriteHandle(writeHandle)
            .build();

    BidiWriteObjectRequest req2 = incrementalRequest(3, "DEF");
    BidiWriteObjectRequest req3 = incrementalRequest(6, "GHI");

    BidiWriteObjectRequest reconnect =
        BidiWriteObjectRequest.newBuilder()
            .setAppendObjectSpec(
                AppendObjectSpec.newBuilder()
                    .setBucket(METADATA.getBucket())
                    .setObject(METADATA.getName())
                    .setGeneration(METADATA.getGeneration())
                    .build())
            .setFlush(true)
            .setStateLookup(true)
            .build();

    BidiWriteObjectRequest req4 = incrementalRequest(7, "HI");

    BidiWriteObjectRequest req5 = incrementalRequest(9, "J", true);
    BidiWriteObjectRequest req6 = finishMessage(10);

    BidiWriteObjectResponse last =
        BidiWriteObjectResponse.newBuilder()
            .setResource(
                Object.newBuilder()
                    .setName(METADATA.getName())
                    .setBucket(METADATA.getBucket())
                    .setGeneration(METADATA.getGeneration())
                    .setSize(10)
                    .setFinalizeTime(timestampNow())
                    // real object would have some extra fields like metageneration and storage
                    // class
                    .build())
            .build();
    Map<BidiWriteObjectRequest, Integer> map = new HashMap<>();

    FakeStorage fake =
        FakeStorage.of(
            ImmutableMap.of(
                req1,
                maxRetries(req1, null, map, 1),
                req2,
                maxRetries(req2, null, map, 1),
                req3,
                retryableErrorOnce(req3, null, map, 1),
                reconnect,
                maxRetries(reconnect, incrementalResponse(7), map, 1),
                req4,
                maxRetries(req4, null, map, 1),
                req5,
                maxRetries(req5, incrementalResponse(10), map, 1),
                req6,
                maxRetries(req6, last, map, 1)),
            ImmutableMap.of(
                GetObjectRequest.newBuilder()
                    .setObject(METADATA.getName())
                    .setBucket(METADATA.getBucket())
                    .setReadMask(
                        (FieldMask.newBuilder()
                            .addPaths(Storage.BlobField.GENERATION.getGrpcName())
                            .build()))
                    .build(),
                Object.newBuilder().setGeneration(METADATA.getGeneration()).build()));

    try (FakeServer fakeServer = FakeServer.of(fake);
        GrpcStorageImpl storage =
            (GrpcStorageImpl) fakeServer.getGrpcStorageOptions().toBuilder().build().getService()) {
      SettableApiFuture<BidiWriteObjectResponse> done = SettableApiFuture.create();
      BidiAppendableUnbufferedWritableByteChannel channel =
          new BidiAppendableUnbufferedWritableByteChannel(
              new BidiUploadStreamingStream(
                  BidiUploadState.appendableNew(
                      BidiWriteObjectRequest.newBuilder()
                          .setWriteObjectSpec(
                              WriteObjectSpec.newBuilder()
                                  .setResource(
                                      Object.newBuilder()
                                          .setBucket(METADATA.getBucket())
                                          .setName(METADATA.getName()))
                                  .setAppendable(true)
                                  .build())
                          .build(),
                      GrpcCallContext::createDefault,
                      32,
                      SettableApiFuture.create(),
                      Crc32cValue.zero()),
                  storage.storageDataClient.executor,
                  storage.storageClient.bidiWriteObjectCallable(),
                  3,
                  storage.storageDataClient.retryContextProvider.create()),
              smallSegmenter,
              3,
              0);
      ChecksummedTestContent content = ChecksummedTestContent.of(ALL_OBJECT_BYTES, 0, 10);
      StorageChannelUtils.blockingEmptyTo(ByteBuffer.wrap(content.getBytes()), channel);
      channel.nextWriteShouldFinalize();
      channel.close();
      assertThat(done.get(777, TimeUnit.MILLISECONDS).getResource().getSize()).isEqualTo(10);

      assertThat(map.get(req1)).isEqualTo(1);
      assertThat(map.get(req2)).isEqualTo(1);
      assertThat(map.get(req3)).isEqualTo(1);
      assertThat(map.get(req4)).isEqualTo(1);
      assertThat(map.get(req5)).isEqualTo(1);
    }
  }

  /**
   * In this test, we use a small chunk segmenter that makes 3 byte segments, and do two flushes of
   * multiple segments (one with "ABC"/"DEF"/"GHI"/"J" and one with "KLM"/"NOP"/"QRS"/T"). The first
   * one flushes normally, but the second one gets a retryable error halfway through, and the result
   * of that retryable error indicates that a partial flush occurred. The retry loop handles
   * skipping the partially ack'd bytes. This test is just to assure that the {@code begin} variable
   * in the channel works properly
   */
  @Test
  @Ignore("partial message eviction")
  public void testFlushMultipleSegmentsTwice_firstSucceeds_secondFailsHalfway_partialFlush()
      throws Exception {
    BidiWriteHandle writeHandle =
        BidiWriteHandle.newBuilder()
            .setHandle(ByteString.copyFromUtf8(UUID.randomUUID().toString()))
            .build();

    ChunkSegmenter smallSegmenter =
        new ChunkSegmenter(Hasher.enabled(), ByteStringStrategy.copy(), 3, 3);

    BidiWriteObjectRequest req1 =
        REQ_OPEN.toBuilder()
            .setChecksummedData(
                ChecksummedData.newBuilder().setContent(ByteString.copyFromUtf8("ABC")))
            .build();

    BidiWriteObjectResponse res1 =
        BidiWriteObjectResponse.newBuilder()
            .setResource(
                Object.newBuilder()
                    .setName(METADATA.getName())
                    .setBucket(METADATA.getBucket())
                    .setGeneration(METADATA.getGeneration())
                    .setSize(10)
                    // real object would have some extra fields like metageneration and storage
                    // class
                    .build())
            .setWriteHandle(writeHandle)
            .build();

    BidiWriteObjectRequest req2 = incrementalRequest(10, "KLM");
    BidiWriteObjectRequest req3 = incrementalRequest(13, "NOP");

    BidiWriteObjectRequest reconnect =
        BidiWriteObjectRequest.newBuilder()
            .setAppendObjectSpec(
                AppendObjectSpec.newBuilder()
                    .setBucket(METADATA.getBucket())
                    .setObject(METADATA.getName())
                    .setGeneration(METADATA.getGeneration())
                    .setWriteHandle(writeHandle)
                    .build())
            .setFlush(true)
            .setStateLookup(true)
            .build();

    BidiWriteObjectRequest req4 = incrementalRequest(14, "OP");

    BidiWriteObjectRequest req5 = incrementalRequest(16, "QRS");
    BidiWriteObjectRequest req6 = incrementalRequest(19, "T", true);
    BidiWriteObjectRequest req7 = finishMessage(20);

    BidiWriteObjectResponse last =
        BidiWriteObjectResponse.newBuilder()
            .setResource(
                Object.newBuilder()
                    .setName(METADATA.getName())
                    .setBucket(METADATA.getBucket())
                    .setGeneration(METADATA.getGeneration())
                    .setSize(20)
                    .setFinalizeTime(timestampNow())
                    // real object would have some extra fields like metageneration and storage
                    // class
                    .build())
            .build();
    Map<BidiWriteObjectRequest, Integer> map = new HashMap<>();

    FakeStorage fake =
        FakeStorage.of(
            ImmutableMap
                .<BidiWriteObjectRequest, Consumer<StreamObserver<BidiWriteObjectResponse>>>
                    builder()
                .putAll(
                    ImmutableMap.of(
                        req1,
                        respond -> {},
                        incrementalRequest(3, "DEF"),
                        respond -> {},
                        incrementalRequest(6, "GHI"),
                        respond -> {},
                        incrementalRequest(9, "J", true),
                        respond -> respond.onNext(res1),
                        req2,
                        maxRetries(req2, null, map, 1),
                        req3,
                        retryableErrorOnce(req3, null, map, 1),
                        reconnect,
                        maxRetries(reconnect, incrementalResponse(14), map, 1),
                        req4,
                        maxRetries(req4, null, map, 1),
                        req5,
                        maxRetries(req5, null, map, 1),
                        req6,
                        maxRetries(req6, incrementalResponse(20), map, 1)))
                .putAll(ImmutableMap.of(req7, maxRetries(req7, last, map, 1)))
                .build());

    try (FakeServer fakeServer = FakeServer.of(fake);
        GrpcStorageImpl storage =
            (GrpcStorageImpl) fakeServer.getGrpcStorageOptions().toBuilder().build().getService()) {
      SettableApiFuture<BidiWriteObjectResponse> done = SettableApiFuture.create();
      BidiAppendableUnbufferedWritableByteChannel channel =
          new BidiAppendableUnbufferedWritableByteChannel(
              new BidiUploadStreamingStream(
                  BidiUploadState.appendableNew(
                      BidiWriteObjectRequest.newBuilder()
                          .setWriteObjectSpec(
                              WriteObjectSpec.newBuilder()
                                  .setResource(
                                      Object.newBuilder()
                                          .setBucket(METADATA.getBucket())
                                          .setName(METADATA.getName()))
                                  .setAppendable(true)
                                  .build())
                          .build(),
                      GrpcCallContext::createDefault,
                      32,
                      SettableApiFuture.create(),
                      Crc32cValue.zero()),
                  storage.storageDataClient.executor,
                  storage.storageClient.bidiWriteObjectCallable(),
                  3,
                  storage.storageDataClient.retryContextProvider.create()),
              smallSegmenter,
              3,
              0);
      ChecksummedTestContent content1 = ChecksummedTestContent.of(ALL_OBJECT_BYTES, 0, 10);
      ChecksummedTestContent content2 = ChecksummedTestContent.of(ALL_OBJECT_BYTES, 10, 10);
      StorageChannelUtils.blockingEmptyTo(ByteBuffer.wrap(content1.getBytes()), channel);
      StorageChannelUtils.blockingEmptyTo(ByteBuffer.wrap(content2.getBytes()), channel);
      channel.nextWriteShouldFinalize();
      channel.close();
      assertThat(done.get(777, TimeUnit.MILLISECONDS).getResource().getSize()).isEqualTo(20);

      assertThat(map.get(reconnect)).isEqualTo(1);
      assertThat(map.get(req2)).isEqualTo(1);
      assertThat(map.get(req3)).isEqualTo(1);
      assertThat(map.get(req4)).isEqualTo(1);
      assertThat(map.get(req5)).isEqualTo(1);
      assertThat(map.get(req6)).isEqualTo(1);
      assertThat(map.get(req7)).isEqualTo(1);
    }
  }

  /**
   * If we get a 200 response with a partial success halfway through a flush of multiple segments,
   * the next segment after the partial success will hit a server-side error due to having a larger
   * write offset than the current persisted size. We retry this error and the retry loop handles
   * skipping the partially ack'd bytes
   */
  @Test
  /*
  @Ignore("Ignore until the new implementation handles partial message consumption. \n"
      + "[0:3] + [3:3] + [6:3] -> 8\n"
      + "Today we only replay whole messages")
  */
  @Ignore("messages splitting")
  public void testFlushMultipleSegments_200ResponsePartialFlushHalfway() throws Exception {
    BidiWriteHandle writeHandle =
        BidiWriteHandle.newBuilder()
            .setHandle(ByteString.copyFromUtf8(UUID.randomUUID().toString()))
            .build();

    ChunkSegmenter smallSegmenter =
        new ChunkSegmenter(Hasher.enabled(), ByteStringStrategy.copy(), 3, 3);

    BidiWriteObjectRequest req1 =
        REQ_OPEN.toBuilder()
            .setChecksummedData(
                ChecksummedData.newBuilder().setContent(ByteString.copyFromUtf8("ABC")))
            .build();

    BidiWriteObjectResponse res1 =
        BidiWriteObjectResponse.newBuilder()
            .setResource(
                Object.newBuilder()
                    .setName(METADATA.getName())
                    .setBucket(METADATA.getBucket())
                    .setGeneration(METADATA.getGeneration())
                    .setSize(8)
                    // real object would have some extra fields like metageneration and storage
                    // class
                    .build())
            .setWriteHandle(writeHandle)
            .build();

    BidiWriteObjectRequest req2 = incrementalRequest(3, "DEF");
    BidiWriteObjectRequest req3 = incrementalRequest(6, "GHI");

    BidiWriteObjectRequest reconnect =
        BidiWriteObjectRequest.newBuilder()
            .setAppendObjectSpec(
                AppendObjectSpec.newBuilder()
                    .setBucket(METADATA.getBucket())
                    .setObject(METADATA.getName())
                    .setGeneration(METADATA.getGeneration())
                    .setWriteHandle(writeHandle)
                    .build())
            .setFlush(true)
            .setStateLookup(true)
            .build();

    BidiWriteObjectRequest req4 = incrementalRequest(9, "J", true);

    BidiWriteObjectRequest req5 = incrementalRequest(8, "I");
    BidiWriteObjectRequest req6 = finishMessage(10);

    BidiWriteObjectResponse last =
        BidiWriteObjectResponse.newBuilder()
            .setResource(
                Object.newBuilder()
                    .setName(METADATA.getName())
                    .setBucket(METADATA.getBucket())
                    .setGeneration(METADATA.getGeneration())
                    .setSize(10)
                    .setFinalizeTime(timestampNow())
                    // real object would have some extra fields like metageneration and storage
                    // class
                    .build())
            .build();
    Map<BidiWriteObjectRequest, Integer> map = new HashMap<>();

    FakeStorage fake =
        FakeStorage.of(
            ImmutableMap.of(
                req1,
                maxRetries(req1, null, map, 1),
                req2,
                maxRetries(req2, null, map, 1),
                req3,
                maxRetries(req3, null, map, 1),
                req4,
                respond -> {
                  map.putIfAbsent(req4, 0);
                  int attempts = map.get(req4) + 1;
                  map.put(req4, attempts);
                  if (attempts == 1) {
                    respond.onNext(res1);
                  } else if (attempts == 2) {
                    respond.onNext(incrementalResponse(10));
                  }
                },
                reconnect,
                maxRetries(reconnect, incrementalResponse(8), map, 1),
                req5,
                maxRetries(req5, null, map, 1),
                req6,
                maxRetries(req6, last, map, 1)));

    try (FakeServer fakeServer = FakeServer.of(fake);
        GrpcStorageImpl storage =
            (GrpcStorageImpl) fakeServer.getGrpcStorageOptions().getService()) {
      BidiWriteObjectRequest initial =
          BidiWriteObjectRequest.newBuilder()
              .setWriteObjectSpec(
                  WriteObjectSpec.newBuilder()
                      .setResource(
                          Object.newBuilder()
                              .setBucket(METADATA.getBucket())
                              .setName(METADATA.getName()))
                      .setAppendable(true)
                      .build())
              .build();
      AppendableUploadState uploadState =
          BidiUploadState.appendableNew(
              initial,
              GrpcCallContext::createDefault,
              32,
              SettableApiFuture.create(),
              Crc32cValue.zero());
      BidiUploadStreamingStream stream =
          new BidiUploadStreamingStream(
              uploadState,
              storage.storageDataClient.executor,
              storage.storageClient.bidiWriteObjectCallable(),
              3,
              storage.storageDataClient.retryContextProvider.create());
      BidiAppendableUnbufferedWritableByteChannel channel =
          new BidiAppendableUnbufferedWritableByteChannel(stream, smallSegmenter, 3, 0);
      ChecksummedTestContent content = ChecksummedTestContent.of(ALL_OBJECT_BYTES, 0, 10);
      StorageChannelUtils.blockingEmptyTo(ByteBuffer.wrap(content.getBytes()), channel);
      channel.nextWriteShouldFinalize();
      channel.close();
      assertThat(stream.getResultFuture().get(777, TimeUnit.MILLISECONDS).getResource().getSize())
          .isEqualTo(10);

      assertThat(map.get(req1)).isEqualTo(1);
      assertThat(map.get(req2)).isEqualTo(1);
      assertThat(map.get(req3)).isEqualTo(1);
      assertThat(map.get(req4)).isEqualTo(2);
      assertThat(map.get(req5)).isEqualTo(1);
      assertThat(map.get(req6)).isEqualTo(1);
      assertThat(map.get(reconnect)).isEqualTo(1);
    }
  }

  @Test
  public void crc32cWorks() throws Exception {
    byte[] b = new byte[25];
    DataGenerator.base64Characters().fill(b, 0, 20);
    DataGenerator.base64Characters().fill(b, 20, 5);
    ChecksummedTestContent abcde = ChecksummedTestContent.of(b, 0, 5);
    ChecksummedTestContent fghij = ChecksummedTestContent.of(b, 5, 5);
    ChecksummedTestContent klmno = ChecksummedTestContent.of(b, 10, 5);
    ChecksummedTestContent pqrst = ChecksummedTestContent.of(b, 15, 5);
    ChecksummedTestContent all = ChecksummedTestContent.of(b);

    BidiWriteObjectRequest req1 =
        BidiWriteObjectRequest.newBuilder()
            .setWriteOffset(0)
            .setWriteObjectSpec(REQ_OPEN.getWriteObjectSpec())
            .setChecksummedData(abcde.asChecksummedData())
            .setFlush(true)
            .setStateLookup(true)
            .build();
    BidiWriteObjectResponse res1 = incrementalResponse(5);

    BidiWriteObjectRequest req2 =
        BidiWriteObjectRequest.newBuilder()
            .setWriteOffset(5)
            .setChecksummedData(fghij.asChecksummedData())
            .setFlush(true)
            .setStateLookup(true)
            .build();
    BidiWriteObjectResponse res2 = incrementalResponse(10);
    BidiWriteObjectRequest req3 =
        BidiWriteObjectRequest.newBuilder()
            .setWriteOffset(10)
            .setChecksummedData(klmno.asChecksummedData())
            .setFlush(true)
            .setStateLookup(true)
            .build();
    BidiWriteObjectResponse res3 = incrementalResponse(15);
    BidiWriteObjectRequest req4 =
        BidiWriteObjectRequest.newBuilder()
            .setWriteOffset(15)
            .setChecksummedData(pqrst.asChecksummedData())
            .setFlush(true)
            .setStateLookup(true)
            .build();
    BidiWriteObjectResponse res4 = incrementalResponse(20);
    BidiWriteObjectRequest req5 =
        BidiWriteObjectRequest.newBuilder()
            .setWriteOffset(20)
            .setChecksummedData(abcde.asChecksummedData())
            .setFlush(true)
            .setStateLookup(true)
            .build();
    BidiWriteObjectResponse res5 = incrementalResponse(25);
    BidiWriteObjectRequest req6 =
        BidiWriteObjectRequest.newBuilder()
            .setWriteOffset(25)
            .setFinishWrite(true)
            .setObjectChecksums(ObjectChecksums.newBuilder().setCrc32C(all.getCrc32c()).build())
            .build();
    BidiWriteObjectResponse res6 =
        BidiWriteObjectResponse.newBuilder()
            .setResource(
                Object.newBuilder()
                    .setName(METADATA.getName())
                    .setBucket(METADATA.getBucket())
                    .setGeneration(METADATA.getGeneration())
                    .setSize(25)
                    .setFinalizeTime(timestampNow())
                    .setChecksums(ObjectChecksums.newBuilder().setCrc32C(all.getCrc32c()).build())
                    // real object would have some extra fields like metageneration and storage
                    // class
                    .build())
            .build();

    FakeStorage fake =
        FakeStorage.of(
            ImmutableMap.of(
                req1,
                respond -> respond.onNext(res1),
                req2,
                respond -> respond.onNext(res2),
                req3,
                respond -> respond.onNext(res3),
                req4,
                respond -> respond.onNext(res4),
                req5,
                respond -> respond.onNext(res5),
                req6,
                respond -> {
                  respond.onNext(res6);
                  respond.onCompleted();
                }));
    try (FakeServer fakeServer = FakeServer.of(fake);
        Storage storage = fakeServer.getGrpcStorageOptions().toBuilder().build().getService()) {
      BlobId id = BlobId.of("b", "o");

      BlobAppendableUploadConfig config =
          BlobAppendableUploadConfig.of()
              .withFlushPolicy(FlushPolicy.maxFlushSize(5))
              .withCloseAction(CloseAction.FINALIZE_WHEN_CLOSING);
      BlobAppendableUpload upload =
          storage.blobAppendableUpload(BlobInfo.newBuilder(id).build(), config);
      try (AppendableUploadWriteableByteChannel channel = upload.open()) {
        StorageChannelUtils.blockingEmptyTo(ByteBuffer.wrap(b), channel);
      }
      ApiFuture<BlobInfo> result = upload.getResult();
      result.get(5, TimeUnit.SECONDS);
    }
  }

  /**
   * If a stream is held open for an extended period (i.e. longer than the configured retry timeout)
   * and the server returns an error, we want to make sure the currently pending request is able to
   * be retried. To accomplish this, the retry context needs to reset it's attempt elapsed timer
   * each time a successful response from the server is received.
   *
   * <p>This test simulates (using our {@link TestApiClock} the server pausing 60 seconds before
   * delivering an ACK. After the ACK, we raise an Unavailable error, the client's retries should be
   * able to handle this and pick up where it left off.
   */
  @Test
  public void
      receivingASuccessfulMessageOnTheStreamShouldResetTheElapsedTimerForRetryBudgetCalculation()
          throws Exception {

    TestApiClock testClock = TestApiClock.of(0, TestApiClock.addExact(Duration.ofSeconds(1)));
    FakeStorage fake =
        FakeStorage.of(
            ImmutableMap.of(
                flush(open_abc),
                respond -> respond.onNext(res_abc),
                flush(def),
                respond -> {
                  // when receiving the second message, simulate it taking one minute to process
                  testClock.advance(Duration.ofMinutes(1));
                  // then return the incremental response before erroring with a retryable error
                  respond.onNext(incrementalResponse(6));
                  respond.onError(TestUtils.apiException(Status.Code.UNAVAILABLE, "Unavailable"));
                },
                reconnect,
                respond -> {
                  BidiWriteObjectResponse.Builder b = res_abc.toBuilder();
                  b.getResourceBuilder()
                      .setSize(6)
                      .setChecksums(
                          ObjectChecksums.newBuilder()
                              .setCrc32C(content.slice(0, 6).getCrc32c())
                              .build());
                  respond.onNext(b.build());
                },
                flush(ghi),
                respond -> respond.onNext(incrementalResponse(9)),
                j_finish,
                respond -> respond.onNext(resource_10)));
    try (FakeServer fakeServer = FakeServer.of(fake);
        Storage storage =
            fakeServer.getGrpcStorageOptions().toBuilder()
                .setClock(testClock)
                .build()
                .getService()) {
      BlobId id = BlobId.of("b", "o");

      BlobAppendableUpload upload =
          storage.blobAppendableUpload(BlobInfo.newBuilder(id).build(), UPLOAD_CONFIG);
      try (AppendableUploadWriteableByteChannel channel = upload.open()) {
        StorageChannelUtils.blockingEmptyTo(content.asByteBuffer(), channel);
      }
      ApiFuture<BlobInfo> result = upload.getResult();
      result.get(5, TimeUnit.SECONDS);
    }
  }

  private static Consumer<StreamObserver<BidiWriteObjectResponse>> maxRetries(
      @NonNull BidiWriteObjectRequest req,
      Map<@NonNull BidiWriteObjectRequest, Integer> retryMap,
      int maxAttempts) {
    return maxRetries(req, null, retryMap, maxAttempts);
  }

  private static Consumer<StreamObserver<BidiWriteObjectResponse>> maxRetries(
      @NonNull BidiWriteObjectRequest req,
      @Nullable BidiWriteObjectResponse res,
      @NonNull Map<@NonNull BidiWriteObjectRequest, Integer> retryMap,
      int maxAttempts) {
    return respond -> {
      int attempts = retryMap.compute(req, (r, count) -> count == null ? 1 : count + 1);
      if (attempts > maxAttempts) {
        DebugInfo details =
            DebugInfo.newBuilder().setDetail(TextFormat.printer().shortDebugString(req)).build();

        com.google.rpc.Status grpcStatusDetails =
            com.google.rpc.Status.newBuilder()
                .setCode(com.google.rpc.Code.ABORTED_VALUE)
                .setMessage("details")
                .addDetails(Any.pack(details))
                .build();

        Metadata trailers = new Metadata();
        trailers.put(TestUtils.GRPC_STATUS_DETAILS_KEY, grpcStatusDetails);
        StatusRuntimeException t =
            Status.ABORTED
                .withDescription(
                    String.format(
                        Locale.US,
                        "request received %d times, but only allowed %d times",
                        attempts,
                        maxAttempts))
                .asRuntimeException(trailers);
        respond.onError(t);
      } else {
        if (res != null) {
          respond.onNext(res);
        }
      }
    };
  }

  private static Consumer<StreamObserver<BidiWriteObjectResponse>> retryableErrorOnce(
      @NonNull BidiWriteObjectRequest req,
      @NonNull Map<@NonNull BidiWriteObjectRequest, Integer> retryMap,
      int maxAttempts) {
    return retryableErrorOnce(req, null, retryMap, maxAttempts);
  }

  private static Consumer<StreamObserver<BidiWriteObjectResponse>> retryableErrorOnce(
      @NonNull BidiWriteObjectRequest req,
      @Nullable BidiWriteObjectResponse res,
      @NonNull Map<@NonNull BidiWriteObjectRequest, Integer> retryMap,
      int maxAttempts) {
    return respond -> {
      int attempts = retryMap.compute(req, (r, count) -> count == null ? 1 : count + 1);
      if (attempts == 1) {
        respond.onError(Status.INTERNAL.asRuntimeException());
      } else if (attempts > maxAttempts) {
        respond.onError(
            Status.ABORTED
                .withDescription("retryableErrorOnce method exceeded max retries in fake")
                .asRuntimeException());
      } else {
        if (res != null) {
          respond.onNext(res);
        }
      }
    };
  }

  private static BidiWriteObjectRequest incrementalRequest(
      long offset, String content, boolean flush) {
    BidiWriteObjectRequest.Builder builder =
        BidiWriteObjectRequest.newBuilder()
            .setWriteOffset(offset)
            .setChecksummedData(ChecksummedTestContent.of(content).asChecksummedData());

    if (flush) {
      builder.setFlush(true).setStateLookup(true);
    }
    return builder.build();
  }

  private static BidiWriteObjectRequest incrementalRequest(long offset, String content) {
    return incrementalRequest(offset, content, false);
  }

  private static BidiWriteObjectResponse incrementalResponse(long perSize) {
    return BidiWriteObjectResponse.newBuilder().setPersistedSize(perSize).build();
  }

  private static BidiWriteObjectRequest finishMessage(long offset) {
    return BidiWriteObjectRequest.newBuilder().setWriteOffset(offset).setFinishWrite(true).build();
  }

  private static BidiWriteObjectRequest flush(BidiWriteObjectRequest req) {
    return req.toBuilder().setStateLookup(true).setFlush(true).build();
  }

  private static void runTestFlushMultipleSegments(FakeStorage fake) throws Exception {
    try (FakeServer fakeServer = FakeServer.of(fake);
        GrpcStorageImpl storage =
            (GrpcStorageImpl) fakeServer.getGrpcStorageOptions().getService()) {

      BidiWriteObjectRequest initialRequest =
          BidiWriteObjectRequest.newBuilder()
              .setWriteObjectSpec(
                  WriteObjectSpec.newBuilder()
                      .setResource(
                          Object.newBuilder()
                              .setBucket(METADATA.getBucket())
                              .setName(METADATA.getName()))
                      .setAppendable(true)
                      .build())
              .build();
      AppendableUploadState state =
          BidiUploadState.appendableNew(
              initialRequest,
              GrpcCallContext::createDefault,
              32,
              SettableApiFuture.create(),
              Crc32cValue.zero());
      BidiUploadStreamingStream stream =
          new BidiUploadStreamingStream(
              state,
              storage.storageDataClient.executor,
              storage.storageClient.bidiWriteObjectCallable(),
              3,
              storage.storageDataClient.retryContextProvider.create());
      BidiAppendableUnbufferedWritableByteChannel channel =
          new BidiAppendableUnbufferedWritableByteChannel(stream, smallSegmenter, 32, 0);
      StorageChannelUtils.blockingEmptyTo(ByteBuffer.wrap(content.getBytes()), channel);
      channel.nextWriteShouldFinalize();
      channel.close();
      BidiWriteObjectResponse response = stream.getResultFuture().get(777, TimeUnit.MILLISECONDS);
      assertThat(response.getResource().getSize()).isEqualTo(10);
      assertThat(response.getResource().getChecksums().getCrc32C()).isEqualTo(content.getCrc32c());
    }
  }

  static final class FakeStorage extends StorageGrpc.StorageImplBase {

    private final Map<BidiWriteObjectRequest, Consumer<StreamObserver<BidiWriteObjectResponse>>> db;
    private final Map<GetObjectRequest, Object> getdb;

    private FakeStorage(
        Map<BidiWriteObjectRequest, Consumer<StreamObserver<BidiWriteObjectResponse>>> db) {
      this(db, ImmutableMap.of());
    }

    private FakeStorage(
        Map<BidiWriteObjectRequest, Consumer<StreamObserver<BidiWriteObjectResponse>>> db,
        Map<GetObjectRequest, Object> getdb) {
      this.db = db;
      this.getdb = getdb;
    }

    @Override
    public void getObject(GetObjectRequest request, StreamObserver<Object> responseObserver) {
      if (getdb.containsKey(request)) {
        Object resp = getdb.get(request);
        if (resp.getGeneration() == 0) {
          responseObserver.onError(TestUtils.apiException(Status.Code.NOT_FOUND, "not found"));
        } else {
          responseObserver.onNext(getdb.get(request));
          responseObserver.onCompleted();
        }
      } else {
        responseObserver.onError(unexpectedRequest(request, getdb.keySet()));
      }
    }

    @Override
    public StreamObserver<BidiWriteObjectRequest> bidiWriteObject(
        StreamObserver<BidiWriteObjectResponse> respond) {
      return new AbstractObserver(respond) {
        @Override
        public void onNext(BidiWriteObjectRequest req) {
          if (db.containsKey(req)) {
            db.get(req).accept(respond);
          } else {
            respond.onError(unexpectedRequest(req, db.keySet()));
          }
        }
      };
    }

    static @NonNull StatusRuntimeException unexpectedRequest(
        Message req, Collection<? extends Message> messages) {
      DebugInfo details =
          DebugInfo.newBuilder().setDetail(TextFormat.printer().shortDebugString(req)).build();

      com.google.rpc.Status grpcStatusDetails =
          com.google.rpc.Status.newBuilder()
              .setCode(Code.UNIMPLEMENTED_VALUE)
              .setMessage("details")
              .addDetails(Any.pack(details))
              .build();

      Metadata trailers = new Metadata();
      trailers.put(TestUtils.GRPC_STATUS_DETAILS_KEY, grpcStatusDetails);
      StringBuilder sb = new StringBuilder();
      sb.append("Unexpected request.").append("\n");
      sb.append("  actual: ").append("\n    ").append(fmtProto(req)).append("\n");
      sb.append("  expected one of: ");
      sb.append(
          messages.stream()
              .map(StorageV2ProtoUtils::fmtProto)
              .collect(Collectors.joining(",\n    ", "[\n    ", "\n  ]")));
      return Status.UNIMPLEMENTED.withDescription(sb.toString()).asRuntimeException(trailers);
    }

    static FakeStorage of(
        Map<BidiWriteObjectRequest, Consumer<StreamObserver<BidiWriteObjectResponse>>> db) {
      return new FakeStorage(db);
    }

    static FakeStorage of(
        Map<BidiWriteObjectRequest, Consumer<StreamObserver<BidiWriteObjectResponse>>> db,
        Map<GetObjectRequest, Object> getdb) {
      return new FakeStorage(db, getdb);
    }
  }

  abstract static class AbstractObserver implements StreamObserver<BidiWriteObjectRequest> {

    protected final StreamObserver<BidiWriteObjectResponse> respond;

    private AbstractObserver(StreamObserver<BidiWriteObjectResponse> respond) {
      this.respond = respond;
    }

    @Override
    public void onError(Throwable t) {
      respond.onError(t);
    }

    @Override
    public void onCompleted() {
      respond.onCompleted();
    }
  }
}
