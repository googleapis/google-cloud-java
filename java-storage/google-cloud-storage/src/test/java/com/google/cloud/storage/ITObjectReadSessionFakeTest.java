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
import static com.google.cloud.storage.PackagePrivateMethodWorkarounds.maybeGetStorageDataClient;
import static com.google.cloud.storage.TestUtils.GRPC_STATUS_DETAILS_KEY;
import static com.google.cloud.storage.TestUtils.apiException;
import static com.google.cloud.storage.TestUtils.assertAll;
import static com.google.cloud.storage.TestUtils.getChecksummedData;
import static com.google.cloud.storage.TestUtils.xxd;
import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth.assertWithMessage;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.fail;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.grpc.GrpcCallContext;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.AbortedException;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.DataLossException;
import com.google.api.gax.rpc.OutOfRangeException;
import com.google.api.gax.rpc.UnavailableException;
import com.google.cloud.storage.Crc32cValue.Crc32cLengthKnown;
import com.google.cloud.storage.Hasher.UncheckedChecksumMismatchException;
import com.google.cloud.storage.OtelStorageDecorator.OtelDecoratingBlobReadSession;
import com.google.cloud.storage.Storage.BlobSourceOption;
import com.google.cloud.storage.StorageDataClient.FastOpenObjectReadSession;
import com.google.cloud.storage.ZeroCopySupport.DisposableByteString;
import com.google.cloud.storage.it.ChecksummedTestContent;
import com.google.cloud.storage.it.GrpcPlainRequestLoggingInterceptor;
import com.google.cloud.storage.it.GrpcRequestAuditing;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.hash.Hashing;
import com.google.common.io.BaseEncoding;
import com.google.common.io.ByteStreams;
import com.google.common.truth.Correspondence;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import com.google.protobuf.Any;
import com.google.protobuf.ByteString;
import com.google.protobuf.TextFormat;
import com.google.rpc.DebugInfo;
import com.google.storage.v2.BidiReadHandle;
import com.google.storage.v2.BidiReadObjectError;
import com.google.storage.v2.BidiReadObjectRedirectedError;
import com.google.storage.v2.BidiReadObjectRequest;
import com.google.storage.v2.BidiReadObjectResponse;
import com.google.storage.v2.BidiReadObjectSpec;
import com.google.storage.v2.BucketName;
import com.google.storage.v2.ChecksummedData;
import com.google.storage.v2.CommonObjectRequestParams;
import com.google.storage.v2.Object;
import com.google.storage.v2.ObjectRangeData;
import com.google.storage.v2.ReadRange;
import com.google.storage.v2.ReadRangeError;
import com.google.storage.v2.StorageGrpc.StorageImplBase;
import io.grpc.Metadata;
import io.grpc.Status;
import io.grpc.Status.Code;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ScatteringByteChannel;
import java.nio.channels.WritableByteChannel;
import java.security.Key;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.crypto.spec.SecretKeySpec;
import org.junit.Test;
import org.junit.function.ThrowingRunnable;

public final class ITObjectReadSessionFakeTest {

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
  private static final BidiReadObjectResponse RES_OPEN =
      BidiReadObjectResponse.newBuilder().setMetadata(METADATA).build();
  private static final byte[] ALL_OBJECT_BYTES = DataGenerator.base64Characters().genBytes(64);
  private static final Metadata.Key<String> X_GOOG_REQUEST_PARAMS =
      Metadata.Key.of("x-goog-request-params", Metadata.ASCII_STRING_MARSHALLER);
  private static final Metadata.Key<String> X_GOOG_GCS_IDEMPOTENCY_TOKEN =
      Metadata.Key.of("x-goog-gcs-idempotency-token", Metadata.ASCII_STRING_MARSHALLER);
  private static final Metadata.Key<String> X_GOOG_USER_PROJECT =
      Metadata.Key.of("x-goog-user-project", Metadata.ASCII_STRING_MARSHALLER);
  private static final Correspondence<String, UUID> IS_UUID =
      Correspondence.transforming(UUID::fromString, "is a UUID");

  /**
   *
   *
   * <ol>
   *   <li>Open blob descriptor
   *   <li>attempt to read bytes 10-20
   *   <li>server responds with a redirect
   *   <li>expect a new stream open with the specified redirect token, read handle and pending read
   *       of bytes 10-20
   * </ol>
   */
  @Test
  public void bidiReadObjectRedirectedError() throws Exception {

    String routingToken = UUID.randomUUID().toString();
    BidiReadHandle readHandle =
        BidiReadHandle.newBuilder()
            .setHandle(ByteString.copyFromUtf8(UUID.randomUUID().toString()))
            .build();
    BidiReadObjectRequest req2 = read(1, 10, 10);
    BidiReadObjectRequest req3 =
        BidiReadObjectRequest.newBuilder()
            .setReadObjectSpec(
                BidiReadObjectSpec.newBuilder()
                    .setBucket(METADATA.getBucket())
                    .setObject(METADATA.getName())
                    .setGeneration(1)
                    .setReadHandle(readHandle)
                    .setRoutingToken(routingToken)
                    .build())
            .addReadRanges(getReadRange(1, 10, 10))
            .build();

    ChecksummedTestContent content = ChecksummedTestContent.of(ALL_OBJECT_BYTES, 10, 10);
    BidiReadObjectResponse res2 =
        BidiReadObjectResponse.newBuilder()
            .setMetadata(METADATA)
            .addObjectDataRanges(
                ObjectRangeData.newBuilder()
                    .setChecksummedData(content.asChecksummedData())
                    .setReadRange(getReadRange(1, 10, 10))
                    .setRangeEnd(true)
                    .build())
            .build();

    FakeStorage fake =
        FakeStorage.of(
            ImmutableMap.of(
                REQ_OPEN,
                respond -> respond.onNext(RES_OPEN),
                req2,
                respond -> {
                  BidiReadObjectRedirectedError redirect =
                      BidiReadObjectRedirectedError.newBuilder()
                          .setReadHandle(readHandle)
                          .setRoutingToken(routingToken)
                          .build();

                  com.google.rpc.Status grpcStatusDetails =
                      com.google.rpc.Status.newBuilder()
                          .setCode(com.google.rpc.Code.UNAVAILABLE_VALUE)
                          .setMessage("redirect")
                          .addDetails(Any.pack(redirect))
                          .build();

                  Metadata trailers = new Metadata();
                  trailers.put(GRPC_STATUS_DETAILS_KEY, grpcStatusDetails);
                  StatusRuntimeException statusRuntimeException =
                      Status.UNAVAILABLE.withDescription("redirect").asRuntimeException(trailers);
                  respond.onError(statusRuntimeException);
                },
                req3,
                respond -> respond.onNext(res2)));

    try (FakeServer fakeServer = FakeServer.of(fake);
        Storage storage = fakeServer.getGrpcStorageOptions().toBuilder().build().getService()) {

      BlobId id = BlobId.of("b", "o");
      ApiFuture<BlobReadSession> futureBlobDescriptor = storage.blobReadSession(id);

      try (BlobReadSession bd = futureBlobDescriptor.get(5, TimeUnit.SECONDS)) {
        byte[] actual =
            bd.readAs(ReadProjectionConfigs.asFutureBytes().withRangeSpec(RangeSpec.of(10L, 10L)))
                .get(1, TimeUnit.SECONDS);

        assertThat(xxd(actual)).isEqualTo(xxd(content.getBytes()));
      }
    }
  }

  /**
   *
   *
   * <ol>
   *   <li>Attempt to open blob descriptor
   *   <li>server responds with a redirect
   *   <li>expect a new stream open with the specified redirect token
   * </ol>
   */
  @Test
  public void bidiReadObjectRedirectedError_onOpen() throws Exception {
    String routingToken = UUID.randomUUID().toString();
    BidiReadHandle readHandle =
        BidiReadHandle.newBuilder()
            .setHandle(ByteString.copyFromUtf8(UUID.randomUUID().toString()))
            .build();
    BidiReadObjectRequest req2 =
        BidiReadObjectRequest.newBuilder()
            .setReadObjectSpec(
                BidiReadObjectSpec.newBuilder()
                    .setBucket(METADATA.getBucket())
                    .setObject(METADATA.getName())
                    .setReadHandle(readHandle)
                    .setRoutingToken(routingToken)
                    .build())
            .build();

    BidiReadObjectResponse res1 =
        BidiReadObjectResponse.newBuilder()
            .setMetadata(Object.newBuilder().setBucket("b").setName("o").setGeneration(1).build())
            .build();

    FakeStorage fake =
        FakeStorage.of(
            ImmutableMap.of(
                REQ_OPEN,
                respond -> {
                  BidiReadObjectRedirectedError redirect =
                      BidiReadObjectRedirectedError.newBuilder()
                          .setReadHandle(readHandle)
                          .setRoutingToken(routingToken)
                          .build();

                  com.google.rpc.Status grpcStatusDetails =
                      com.google.rpc.Status.newBuilder()
                          .setCode(com.google.rpc.Code.UNAVAILABLE_VALUE)
                          .setMessage("redirect")
                          .addDetails(Any.pack(redirect))
                          .build();

                  Metadata trailers = new Metadata();
                  trailers.put(GRPC_STATUS_DETAILS_KEY, grpcStatusDetails);
                  StatusRuntimeException statusRuntimeException =
                      Status.UNAVAILABLE.withDescription("redirect").asRuntimeException(trailers);
                  respond.onError(statusRuntimeException);
                },
                req2,
                respond -> respond.onNext(res1)));

    try (FakeServer fakeServer = FakeServer.of(fake);
        Storage storage =
            fakeServer.getGrpcStorageOptions().toBuilder()
                .setGrpcInterceptorProvider(
                    GrpcPlainRequestLoggingInterceptor.getInterceptorProvider())
                .build()
                .getService()) {

      BlobId id = BlobId.of("b", "o");
      ApiFuture<BlobReadSession> futureBlobDescriptor = storage.blobReadSession(id);

      try (BlobReadSession bd = futureBlobDescriptor.get(5, TimeUnit.SECONDS)) {
        assertThat(bd).isNotNull();
      }
    }
  }

  @Test
  public void bidiReadObjectRedirectedError_maxRedirectAttempts() throws Exception {
    AtomicInteger reqCounter = new AtomicInteger(0);
    StorageImplBase fake =
        new StorageImplBase() {
          @Override
          public StreamObserver<BidiReadObjectRequest> bidiReadObject(
              StreamObserver<BidiReadObjectResponse> responseObserver) {
            return new AbstractObserver(responseObserver) {
              @Override
              public void onNext(BidiReadObjectRequest value) {
                int requestCount = reqCounter.incrementAndGet();
                BidiReadObjectRedirectedError redirect =
                    BidiReadObjectRedirectedError.newBuilder()
                        .setReadHandle(
                            BidiReadHandle.newBuilder()
                                .setHandle(
                                    ByteString.copyFromUtf8(
                                        String.format("handle-%03d", requestCount)))
                                .build())
                        .setRoutingToken(String.format("token-%03d", requestCount))
                        .build();

                com.google.rpc.Status grpcStatusDetails =
                    com.google.rpc.Status.newBuilder()
                        .setCode(com.google.rpc.Code.UNAVAILABLE_VALUE)
                        .setMessage(String.format("redirect %03d", requestCount))
                        .addDetails(Any.pack(redirect))
                        .build();

                Metadata trailers = new Metadata();
                trailers.put(GRPC_STATUS_DETAILS_KEY, grpcStatusDetails);
                StatusRuntimeException statusRuntimeException =
                    Status.UNAVAILABLE
                        .withDescription(String.format("redirect %03d", requestCount))
                        .asRuntimeException(trailers);
                respond.onError(statusRuntimeException);
              }
            };
          }
        };

    try (FakeServer fakeServer = FakeServer.of(fake);
        Storage storage = fakeServer.getGrpcStorageOptions().toBuilder().build().getService()) {

      BlobId id = BlobId.of("b", "o");
      ApiFuture<BlobReadSession> futureBlobDescriptor =
          storage.blobReadSession(id, BlobSourceOption.userProject("user-project"));

      StorageException se =
          assertThrows(
              StorageException.class,
              () -> {
                try {
                  futureBlobDescriptor.get(5, TimeUnit.SECONDS);
                } catch (ExecutionException e) {
                  throw e.getCause();
                }
              });

      assertThat(se.getCode()).isEqualTo(503);
      assertThat(se).hasCauseThat().isInstanceOf(UnavailableException.class);
      assertThat(reqCounter.get()).isEqualTo(4);
    }
  }

  @Test
  public void bidiReadObjectError() throws Exception {

    ChecksummedTestContent content2 = ChecksummedTestContent.of(ALL_OBJECT_BYTES, 10, 5);
    BidiReadObjectRequest req2 = read(1, 10, 10);
    BidiReadObjectResponse res2 =
        BidiReadObjectResponse.newBuilder()
            .addObjectDataRanges(
                ObjectRangeData.newBuilder()
                    .setChecksummedData(content2.asChecksummedData())
                    .setReadRange(getReadRange(1, 10, 5))
                    .build())
            .build();
    BidiReadObjectError err2 =
        BidiReadObjectError.newBuilder()
            .addReadRangeErrors(
                ReadRangeError.newBuilder()
                    .setReadId(1)
                    .setStatus(
                        com.google.rpc.Status.newBuilder()
                            .setCode(com.google.rpc.Code.ABORTED_VALUE)
                            .build())
                    .build())
            .build();

    ChecksummedTestContent content3 = ChecksummedTestContent.of(ALL_OBJECT_BYTES, 15, 5);
    BidiReadObjectRequest req3 =
        BidiReadObjectRequest.newBuilder()
            .setReadObjectSpec(
                BidiReadObjectSpec.newBuilder()
                    .setBucket(METADATA.getBucket())
                    .setObject(METADATA.getName())
                    .setGeneration(1)
                    .build())
            .addReadRanges(getReadRange(2, 15, 5))
            .build();
    BidiReadObjectResponse res3 =
        BidiReadObjectResponse.newBuilder()
            .setMetadata(METADATA)
            .addObjectDataRanges(
                ObjectRangeData.newBuilder()
                    .setChecksummedData(content3.asChecksummedData())
                    .setReadRange(getReadRange(2, 15, 5))
                    .setRangeEnd(true)
                    .build())
            .build();

    FakeStorage fake =
        FakeStorage.of(
            ImmutableMap.of(
                REQ_OPEN,
                respond -> respond.onNext(RES_OPEN),
                req2,
                respond -> {
                  com.google.rpc.Status grpcStatusDetails =
                      com.google.rpc.Status.newBuilder()
                          .setCode(com.google.rpc.Code.UNAVAILABLE_VALUE)
                          .setMessage("fail read_id: 1")
                          .addDetails(Any.pack(err2))
                          .build();

                  Metadata trailers = new Metadata();
                  trailers.put(GRPC_STATUS_DETAILS_KEY, grpcStatusDetails);
                  StatusRuntimeException statusRuntimeException =
                      Status.UNAVAILABLE.withDescription("redirect").asRuntimeException(trailers);
                  respond.onNext(res2);
                  respond.onError(statusRuntimeException);
                },
                req3,
                respond -> respond.onNext(res3)));

    try (FakeServer fakeServer = FakeServer.of(fake);
        Storage storage = fakeServer.getGrpcStorageOptions().toBuilder().build().getService()) {

      BlobId id = BlobId.of("b", "o");
      ApiFuture<BlobReadSession> futureBlobDescriptor = storage.blobReadSession(id);

      try (BlobReadSession bd = futureBlobDescriptor.get(5, TimeUnit.SECONDS)) {
        StorageException se =
            assertThrows(
                StorageException.class,
                () -> {
                  try {
                    ApiFuture<byte[]> future =
                        bd.readAs(
                            ReadProjectionConfigs.asFutureBytes()
                                .withRangeSpec(RangeSpec.of(10L, 10L)));
                    future.get(5, TimeUnit.SECONDS);
                  } catch (ExecutionException e) {
                    throw e.getCause();
                  }
                });
        assertThat(se).hasCauseThat().isInstanceOf(AbortedException.class);
        byte[] actual =
            bd.readAs(ReadProjectionConfigs.asFutureBytes().withRangeSpec(RangeSpec.of(15L, 5L)))
                .get(2, TimeUnit.SECONDS);
        assertThat(actual).hasLength(5);
        assertThat(xxd(actual)).isEqualTo(xxd(content3.getBytes()));
      }
    }
  }

  @Test
  public void expectRetryForRangeWithFailedChecksumValidation() throws Exception {

    ChecksummedTestContent expected = ChecksummedTestContent.of(ALL_OBJECT_BYTES, 10, 20);

    ChecksummedTestContent content2_1 = ChecksummedTestContent.of(ALL_OBJECT_BYTES, 10, 10);
    ChecksummedTestContent content2_2 = ChecksummedTestContent.of(ALL_OBJECT_BYTES, 20, 10);
    BidiReadObjectRequest req2 = read(1, 10, 20);
    BidiReadObjectResponse res2_1 =
        BidiReadObjectResponse.newBuilder()
            .addObjectDataRanges(
                ObjectRangeData.newBuilder()
                    .setChecksummedData(content2_1.asChecksummedData())
                    .setReadRange(getReadRange(1, 10, 10))
                    .build())
            .build();
    BidiReadObjectResponse res2_2 =
        BidiReadObjectResponse.newBuilder()
            .setMetadata(METADATA)
            .addObjectDataRanges(
                ObjectRangeData.newBuilder()
                    .setChecksummedData(content2_2.asChecksummedData().toBuilder().setCrc32C(1))
                    .setReadRange(getReadRange(1, 20, 10))
                    .setRangeEnd(true)
                    .build())
            .build();

    BidiReadObjectRequest req3 = read(2, 20, 10);
    BidiReadObjectResponse res3 =
        BidiReadObjectResponse.newBuilder()
            .setMetadata(METADATA)
            .addObjectDataRanges(
                ObjectRangeData.newBuilder()
                    .setChecksummedData(content2_2.asChecksummedData())
                    .setReadRange(getReadRange(2, 20, 10))
                    .setRangeEnd(true)
                    .build())
            .build();

    FakeStorage fake =
        FakeStorage.of(
            ImmutableMap.of(
                REQ_OPEN,
                respond -> respond.onNext(RES_OPEN),
                req2,
                respond -> {
                  respond.onNext(res2_1);
                  respond.onNext(res2_2);
                },
                req3,
                respond -> respond.onNext(res3)));

    runTestAgainstFakeServer(fake, RangeSpec.of(10L, 20L), expected);
  }

  @Test
  public void objectRangeData_offset_notAligned_lt() throws Exception {

    ChecksummedTestContent expected = ChecksummedTestContent.of(ALL_OBJECT_BYTES, 10, 20);

    ChecksummedTestContent content2 = ChecksummedTestContent.of(ALL_OBJECT_BYTES, 9, 20);
    BidiReadObjectRequest req2 = read(1, 10, 20);
    BidiReadObjectResponse res2 =
        BidiReadObjectResponse.newBuilder()
            .addObjectDataRanges(
                ObjectRangeData.newBuilder()
                    .setChecksummedData(content2.asChecksummedData())
                    .setReadRange(getReadRange(1, 9, content2))
                    .setRangeEnd(true)
                    .build())
            .build();

    ChecksummedTestContent content3 = ChecksummedTestContent.of(ALL_OBJECT_BYTES, 29, 1);
    BidiReadObjectRequest req3 = read(2, 29, 1);
    BidiReadObjectResponse res3 =
        BidiReadObjectResponse.newBuilder()
            .setMetadata(METADATA)
            .addObjectDataRanges(
                ObjectRangeData.newBuilder()
                    .setChecksummedData(content3.asChecksummedData())
                    .setReadRange(getReadRange(2, 29, content3))
                    .setRangeEnd(true)
                    .build())
            .build();

    ImmutableMap<BidiReadObjectRequest, BidiReadObjectResponse> db =
        ImmutableMap.<BidiReadObjectRequest, BidiReadObjectResponse>builder()
            .put(REQ_OPEN, RES_OPEN)
            .put(req2, res2)
            .put(req3, res3)
            .buildOrThrow();

    runTestAgainstFakeServer(FakeStorage.from(db), RangeSpec.of(10L, 20L), expected);
  }

  @Test
  public void objectRangeData_offset_notAligned_gt() throws Exception {

    ChecksummedTestContent expected = ChecksummedTestContent.of(ALL_OBJECT_BYTES, 10, 20);

    ChecksummedTestContent content2 = ChecksummedTestContent.of(ALL_OBJECT_BYTES, 11, 20);
    BidiReadObjectRequest req2 = read(1, 10, 20);
    BidiReadObjectResponse res2 =
        BidiReadObjectResponse.newBuilder()
            .addObjectDataRanges(
                ObjectRangeData.newBuilder()
                    .setChecksummedData(content2.asChecksummedData())
                    .setReadRange(getReadRange(1, 11, content2))
                    .setRangeEnd(true)
                    .build())
            .build();

    ChecksummedTestContent content3 = ChecksummedTestContent.of(ALL_OBJECT_BYTES, 10, 20);
    BidiReadObjectRequest req3 = read(2, 10, 20);
    BidiReadObjectResponse res3 =
        BidiReadObjectResponse.newBuilder()
            .setMetadata(METADATA)
            .addObjectDataRanges(
                ObjectRangeData.newBuilder()
                    .setChecksummedData(content3.asChecksummedData())
                    .setReadRange(getReadRange(2, 10, content3))
                    .setRangeEnd(true)
                    .build())
            .build();

    ImmutableMap<BidiReadObjectRequest, BidiReadObjectResponse> db =
        ImmutableMap.<BidiReadObjectRequest, BidiReadObjectResponse>builder()
            .put(REQ_OPEN, RES_OPEN)
            .put(req2, res2)
            .put(req3, res3)
            .buildOrThrow();

    runTestAgainstFakeServer(FakeStorage.from(db), RangeSpec.of(10L, 20L), expected);
  }

  @Test
  public void readRange_retrySettingsApplicable_attempt() throws Exception {

    AtomicInteger reqCounter = new AtomicInteger(0);
    StorageImplBase fake =
        new StorageImplBase() {
          @Override
          public StreamObserver<BidiReadObjectRequest> bidiReadObject(
              StreamObserver<BidiReadObjectResponse> responseObserver) {
            return new AbstractObserver(responseObserver) {
              @Override
              public void onNext(BidiReadObjectRequest request) {
                int reqCount = reqCounter.getAndIncrement();
                if (request.equals(REQ_OPEN)) {
                  respond.onNext(RES_OPEN);
                } else {

                  BidiReadObjectResponse.Builder b = BidiReadObjectResponse.newBuilder();
                  request.getReadRangesList().stream()
                      .map(r -> r.toBuilder().setReadLength(1).build())
                      .map(
                          r ->
                              ObjectRangeData.newBuilder()
                                  .setReadRange(r)
                                  .setChecksummedData(
                                      ChecksummedData.newBuilder()
                                          .setContent(ByteString.copyFrom(new byte[] {'A'}))
                                          // explicitly send a bad checksum to induce failure
                                          .setCrc32C(reqCount)
                                          .build())
                                  .build())
                      .forEach(b::addObjectDataRanges);

                  respond.onNext(b.build());
                }
              }
            };
          }
        };

    try (FakeServer fakeServer = FakeServer.of(fake);
        Storage storage =
            fakeServer.getGrpcStorageOptions().toBuilder()
                .setRetrySettings(RetrySettings.newBuilder().setMaxAttempts(3).build())
                .build()
                .getService()) {

      BlobId id = BlobId.of("b", "o");
      ApiFuture<BlobReadSession> futureBlobDescriptor = storage.blobReadSession(id);
      try (BlobReadSession bd = futureBlobDescriptor.get(5, TimeUnit.SECONDS)) {
        ApiFuture<byte[]> future =
            bd.readAs(ReadProjectionConfigs.asFutureBytes().withRangeSpec(RangeSpec.of(10L, 10L)));

        StorageException se =
            assertThrows(
                StorageException.class, () -> TestUtils.await(future, 5, TimeUnit.SECONDS));
        assertThat(se).hasCauseThat().isInstanceOf(DataLossException.class);
        DataLossException dataLossException = (DataLossException) se.getCause();
        assertThat(dataLossException).isInstanceOf(UncheckedChecksumMismatchException.class);
        String suppressedMessages = TestUtils.messagesToText(se);
        assertAll(
            () ->
                assertThat(suppressedMessages)
                    .contains("Operation failed to complete within attempt budget"),
            () ->
                assertThat(suppressedMessages)
                    .contains(
                        "Mismatch checksum value. Expected crc32c{0x00000001} actual"
                            + " crc32c{0xe16dcdee}"),
            () ->
                assertThat(suppressedMessages)
                    .contains(
                        "Mismatch checksum value. Expected crc32c{0x00000002} actual"
                            + " crc32c{0xe16dcdee}"),
            () -> assertThat(suppressedMessages).contains("Asynchronous task failed"));
      }
    }
  }

  @Test
  public void retrySettingsApplicable_objectRangeData_offset_notAligned_gt() throws Exception {

    ChecksummedTestContent content2 = ChecksummedTestContent.of(ALL_OBJECT_BYTES, 11, 20);
    BidiReadObjectRequest req2 = read(1, 10, 20);
    BidiReadObjectResponse res2 =
        BidiReadObjectResponse.newBuilder()
            .addObjectDataRanges(
                ObjectRangeData.newBuilder()
                    .setChecksummedData(content2.asChecksummedData())
                    .setReadRange(getReadRange(1, 11, content2))
                    .setRangeEnd(true)
                    .build())
            .build();

    ChecksummedTestContent content3 = ChecksummedTestContent.of(ALL_OBJECT_BYTES, 12, 20);
    BidiReadObjectRequest req3 = read(2, 10, 20);
    BidiReadObjectResponse res3 =
        BidiReadObjectResponse.newBuilder()
            .addObjectDataRanges(
                ObjectRangeData.newBuilder()
                    .setChecksummedData(content3.asChecksummedData())
                    .setReadRange(getReadRange(2, 12, content3))
                    .setRangeEnd(true)
                    .build())
            .build();

    ImmutableMap<BidiReadObjectRequest, BidiReadObjectResponse> db =
        ImmutableMap.<BidiReadObjectRequest, BidiReadObjectResponse>builder()
            .put(REQ_OPEN, RES_OPEN)
            .put(req2, res2)
            .put(req3, res3)
            .buildOrThrow();

    try (FakeServer fakeServer = FakeServer.of(FakeStorage.from(db));
        Storage storage =
            fakeServer.getGrpcStorageOptions().toBuilder()
                .setRetrySettings(RetrySettings.newBuilder().setMaxAttempts(2).build())
                .build()
                .getService()) {

      BlobId id = BlobId.of("b", "o");
      ApiFuture<BlobReadSession> futureObjectDescriptor = storage.blobReadSession(id);

      try (BlobReadSession bd = futureObjectDescriptor.get(5, TimeUnit.SECONDS)) {
        ApiFuture<byte[]> future =
            bd.readAs(ReadProjectionConfigs.asFutureBytes().withRangeSpec(RangeSpec.of(10L, 20L)));

        StorageException se =
            assertThrows(
                StorageException.class, () -> TestUtils.await(future, 5, TimeUnit.SECONDS));
        assertThat(se).hasCauseThat().isInstanceOf(OutOfRangeException.class);
        String suppressedMessages = TestUtils.messagesToText(se);
        assertAll(
            () ->
                assertThat(suppressedMessages)
                    .contains("Operation failed to complete within attempt budget"),
            () ->
                assertThat(suppressedMessages)
                    .contains("position = 10, readRange.read_offset = 11"),
            () -> assertThat(suppressedMessages).contains("Asynchronous task failed"));
      }
    }
  }

  @Test
  public void validateReadRemovedFromStateWhenFailed() throws Exception {

    BidiReadObjectRequest req2 = read(1, 10, 20);
    BidiReadObjectResponse res2 =
        BidiReadObjectResponse.newBuilder()
            .addObjectDataRanges(
                ObjectRangeData.newBuilder()
                    .setReadRange(req2.getReadRangesList().get(0))
                    .setChecksummedData(
                        ChecksummedData.newBuilder()
                            .setContent(ByteString.copyFrom(new byte[] {'A'}))
                            // explicitly send a bad checksum to induce failure
                            .setCrc32C(1)
                            .build())
                    .build())
            .build();

    FakeStorage fake = FakeStorage.from(ImmutableMap.of(REQ_OPEN, RES_OPEN, req2, res2));

    try (FakeServer fakeServer = FakeServer.of(fake);
        Storage storage =
            fakeServer.getGrpcStorageOptions().toBuilder()
                .setRetrySettings(RetrySettings.newBuilder().setMaxAttempts(1).build())
                .build()
                .getService()) {

      BlobId id = BlobId.of("b", "o");
      ApiFuture<BlobReadSession> futureObjectDescriptor = storage.blobReadSession(id);

      try (BlobReadSession bd = futureObjectDescriptor.get(5, TimeUnit.SECONDS)) {
        ObjectReadSessionImpl orsi = getObjectReadSessionImpl(bd);

        ApiFuture<byte[]> future =
            bd.readAs(ReadProjectionConfigs.asFutureBytes().withRangeSpec(RangeSpec.of(10L, 20L)));
        ExecutionException ee =
            assertThrows(ExecutionException.class, () -> future.get(5, TimeUnit.SECONDS));

        assertThat(ee)
            .hasCauseThat()
            .hasCauseThat()
            .isInstanceOf(UncheckedChecksumMismatchException.class);

        ObjectReadSessionStreamRead<?> outstandingRead = orsi.state.getOutstandingRead(1L);
        assertThat(outstandingRead).isNull();
      }
    }
  }

  @Test
  public void requestOptionsShouldBePresentInRequest() throws Exception {

    String keyB64 = "JVzfVl8NLD9FjedFuStegjRfES5ll5zc59CIXw572OA=";
    Key key = new SecretKeySpec(BaseEncoding.base64().decode(keyB64), "AES256");
    byte[] keySha256 = Hashing.sha256().hashBytes(key.getEncoded()).asBytes();
    BidiReadObjectRequest reqOpen =
        BidiReadObjectRequest.newBuilder()
            .setReadObjectSpec(
                BidiReadObjectSpec.newBuilder()
                    .setBucket(METADATA.getBucket())
                    .setObject(METADATA.getName())
                    .setIfGenerationMatch(1)
                    .setIfGenerationNotMatch(2)
                    .setIfMetagenerationMatch(3)
                    .setIfMetagenerationNotMatch(4)
                    .setCommonObjectRequestParams(
                        CommonObjectRequestParams.newBuilder()
                            .setEncryptionAlgorithm("AES256")
                            .setEncryptionKeyBytes(ByteString.copyFrom(key.getEncoded()))
                            .setEncryptionKeySha256Bytes(ByteString.copyFrom(keySha256))))
            .build();
    BidiReadObjectResponse resOpen =
        BidiReadObjectResponse.newBuilder().setMetadata(METADATA).build();

    FakeStorage fake = FakeStorage.from(ImmutableMap.of(reqOpen, resOpen));

    GrpcRequestAuditing requestAuditing = new GrpcRequestAuditing();
    try (FakeServer fakeServer = FakeServer.of(fake);
        Storage storage =
            fakeServer.getGrpcStorageOptions().toBuilder()
                .setRetrySettings(RetrySettings.newBuilder().setMaxAttempts(1).build())
                .setGrpcInterceptorProvider(
                    () ->
                        ImmutableList.of(
                            requestAuditing, GrpcPlainRequestLoggingInterceptor.getInstance()))
                .build()
                .getService()) {

      BlobId id = BlobId.of("b", "o");
      ApiFuture<BlobReadSession> futureObjectDescriptor =
          storage.blobReadSession(
              id,
              BlobSourceOption.generationMatch(1),
              BlobSourceOption.generationNotMatch(2),
              BlobSourceOption.metagenerationMatch(3),
              BlobSourceOption.metagenerationNotMatch(4),
              BlobSourceOption.decryptionKey(key),
              BlobSourceOption.userProject("my-awesome-project"));

      try (BlobReadSession bd = futureObjectDescriptor.get(5, TimeUnit.SECONDS)) {
        // by the time we reach here the test has already passed/failed
        assertAll(
            () -> assertThat(bd).isNotNull(),
            () ->
                requestAuditing
                    .assertRequestHeader(X_GOOG_REQUEST_PARAMS)
                    .contains("bucket=" + METADATA.getBucket()),
            () -> requestAuditing.assertRequestHeader(X_GOOG_GCS_IDEMPOTENCY_TOKEN).hasSize(1),
            () -> {
              // make sure we get a UUID in our header
              requestAuditing
                  .assertRequestHeader(X_GOOG_GCS_IDEMPOTENCY_TOKEN)
                  .comparingElementsUsing(IS_UUID)
                  .doesNotContain(UUID.randomUUID());
            },
            () ->
                requestAuditing
                    .assertRequestHeader(X_GOOG_USER_PROJECT)
                    .contains("my-awesome-project"));
      }
    }
  }

  @Test
  public void failedStreamRestartShouldFailAllPendingReads() throws Exception {
    final Set<BidiReadObjectRequest> reads = Collections.synchronizedSet(new HashSet<>());
    StorageImplBase fakeStorage =
        new StorageImplBase() {
          @Override
          public StreamObserver<BidiReadObjectRequest> bidiReadObject(
              StreamObserver<BidiReadObjectResponse> responseObserver) {
            return new AbstractObserver(responseObserver) {
              @Override
              public void onNext(BidiReadObjectRequest request) {
                if (request.equals(REQ_OPEN)) {
                  respond.onNext(RES_OPEN);
                  return;
                }

                reads.add(request);

                if (reads.size() == 3) {
                  respond.onError(Status.UNAVAILABLE.asRuntimeException());
                }
              }
            };
          }
        };

    try (FakeServer fakeServer = FakeServer.of(fakeStorage);
        Storage storage =
            fakeServer.getGrpcStorageOptions().toBuilder()
                .setRetrySettings(RetrySettings.newBuilder().setMaxAttempts(1).build())
                .build()
                .getService()) {

      BlobId id = BlobId.of("b", "o");
      ApiFuture<BlobReadSession> futureObjectDescriptor = storage.blobReadSession(id);

      try (BlobReadSession bd = futureObjectDescriptor.get(5, TimeUnit.SECONDS)) {
        ApiFuture<byte[]> f1 =
            bd.readAs(ReadProjectionConfigs.asFutureBytes().withRangeSpec(RangeSpec.of(1, 1)));
        ApiFuture<byte[]> f2 =
            bd.readAs(ReadProjectionConfigs.asFutureBytes().withRangeSpec(RangeSpec.of(2, 2)));
        ApiFuture<byte[]> f3 =
            bd.readAs(ReadProjectionConfigs.asFutureBytes().withRangeSpec(RangeSpec.of(3, 3)));

        List<byte[]> successful =
            ApiFutures.successfulAsList(ImmutableList.of(f1, f2, f3)).get(5, TimeUnit.SECONDS);
        assertThat(successful).isEqualTo(Lists.newArrayList(null, null, null));

        assertAll(
            () -> {
              Set<String> readRanges =
                  reads.stream()
                      .map(BidiReadObjectRequest::getReadRangesList)
                      .flatMap(Collection::stream)
                      .map(ITObjectReadSessionFakeTest::fmt)
                      .collect(Collectors.toSet());
              Set<String> expected =
                  Stream.of(getReadRange(1, 1, 1), getReadRange(2, 2, 2), getReadRange(3, 3, 3))
                      .map(ITObjectReadSessionFakeTest::fmt)
                      .collect(Collectors.toSet());
              assertThat(readRanges).isEqualTo(expected);
            },
            assert503(f1),
            assert503(f2),
            assert503(f3));
      }
    }
  }

  // todo: in the future this should also interrupt and fail any child streams.
  //   for example, when an individual range is streamed and we don't want backpressure
  //   from the consumer to slow down the network stream of all reads.
  @Test
  public void closingBlobDescriptorShouldFailAllPendingReads() throws Exception {
    BidiReadObjectRequest req2 = read(1, 1, 1);
    BidiReadObjectResponse res2 =
        BidiReadObjectResponse.newBuilder()
            .addObjectDataRanges(
                ObjectRangeData.newBuilder()
                    .setReadRange(req2.getReadRangesList().get(0))
                    .setChecksummedData(
                        getChecksummedData(ByteString.copyFromUtf8("A"), Hasher.enabled()))
                    .setRangeEnd(true))
            .build();
    final Set<BidiReadObjectRequest> reads = Collections.synchronizedSet(new HashSet<>());
    StorageImplBase fakeStorage =
        new StorageImplBase() {
          @Override
          public StreamObserver<BidiReadObjectRequest> bidiReadObject(
              StreamObserver<BidiReadObjectResponse> responseObserver) {
            return new AbstractObserver(responseObserver) {
              @Override
              public void onNext(BidiReadObjectRequest request) {
                if (request.equals(REQ_OPEN)) {
                  respond.onNext(RES_OPEN);
                  return;
                } else if (request.equals(req2)) {
                  respond.onNext(res2);
                }
                reads.add(request);
              }
            };
          }
        };

    try (FakeServer fakeServer = FakeServer.of(fakeStorage);
        Storage storage =
            fakeServer.getGrpcStorageOptions().toBuilder()
                .setRetrySettings(RetrySettings.newBuilder().setMaxAttempts(1).build())
                .build()
                .getService()) {

      BlobId id = BlobId.of("b", "o");
      ApiFuture<BlobReadSession> futureObjectDescriptor = storage.blobReadSession(id);

      try (BlobReadSession bd = futureObjectDescriptor.get(5, TimeUnit.SECONDS)) {
        // issue three different range reads
        ApiFuture<byte[]> f1 =
            bd.readAs(ReadProjectionConfigs.asFutureBytes().withRangeSpec(RangeSpec.of(1, 1)));
        ApiFuture<byte[]> f2 =
            bd.readAs(ReadProjectionConfigs.asFutureBytes().withRangeSpec(RangeSpec.of(2, 2)));
        ApiFuture<byte[]> f3 =
            bd.readAs(ReadProjectionConfigs.asFutureBytes().withRangeSpec(RangeSpec.of(3, 3)));

        // make sure the first read succeeded
        byte[] actual = TestUtils.await(f1, 5, TimeUnit.SECONDS);

        // close the "parent"
        bd.close();

        assertAll(
            () -> {
              // make sure all three ranges were sent to the server
              Set<String> readRanges =
                  reads.stream()
                      .map(BidiReadObjectRequest::getReadRangesList)
                      .flatMap(Collection::stream)
                      .map(ITObjectReadSessionFakeTest::fmt)
                      .collect(Collectors.toSet());
              Set<String> expected =
                  Stream.of(getReadRange(1, 1, 1), getReadRange(2, 2, 2), getReadRange(3, 3, 3))
                      .map(ITObjectReadSessionFakeTest::fmt)
                      .collect(Collectors.toSet());
              assertThat(readRanges).isEqualTo(expected);
            },
            () -> {
              assertThat(ByteString.copyFrom(actual)).isEqualTo(ByteString.copyFromUtf8("A"));
            },
            // make sure the other two pending reads fail
            assertStatusCodeIs(f2, 0),
            assertStatusCodeIs(f3, 0),
            () -> {
              // the futures are already verified to be resolved based on the two previous
              // assertions get them again for our additional assertions
              ExecutionException ee2 = assertThrows(ExecutionException.class, f2::get);
              ExecutionException ee3 = assertThrows(ExecutionException.class, f3::get);
              StorageException se2 = (StorageException) ee2.getCause();
              StorageException se3 = (StorageException) ee3.getCause();

              assertAll(
                  () -> assertThat(se2).isNotSameInstanceAs(se3),
                  () ->
                      assertThat(se2)
                          .hasCauseThat()
                          .isInstanceOf(AsyncSessionClosedException.class),
                  () ->
                      assertThat(se3)
                          .hasCauseThat()
                          .isInstanceOf(AsyncSessionClosedException.class));
            });
      }
    }
  }

  @Test
  public void streaming() throws Exception {
    ChecksummedTestContent testContent =
        ChecksummedTestContent.of(DataGenerator.base64Characters().genBytes(_2MiB));
    BidiReadObjectRequest req2 =
        BidiReadObjectRequest.newBuilder().addReadRanges(getReadRange(1, 0, 0)).build();

    BidiReadObjectResponse res2 =
        BidiReadObjectResponse.newBuilder()
            .addObjectDataRanges(
                ObjectRangeData.newBuilder()
                    .setReadRange(getReadRange(1, 0, _2MiB))
                    .setRangeEnd(true)
                    .setChecksummedData(testContent.asChecksummedData()))
            .build();

    FakeStorage fake =
        FakeStorage.of(
            ImmutableMap.of(
                REQ_OPEN,
                respond -> respond.onNext(RES_OPEN),
                req2,
                respond -> respond.onNext(res2)));

    try (FakeServer fakeServer = FakeServer.of(fake);
        Storage storage =
            fakeServer.getGrpcStorageOptions().toBuilder()
                .setGrpcInterceptorProvider(
                    GrpcPlainRequestLoggingInterceptor.getInterceptorProvider())
                .build()
                .getService()) {

      BlobId id = BlobId.of("b", "o");
      ApiFuture<BlobReadSession> futureBlobDescriptor = storage.blobReadSession(id);

      ByteArrayOutputStream baos = new ByteArrayOutputStream();
      try (BlobReadSession bd = futureBlobDescriptor.get(5, TimeUnit.SECONDS);
          ScatteringByteChannel c = bd.readAs(ReadProjectionConfigs.asChannel())) {
        ByteStreams.copy(c, Channels.newChannel(baos));
      }

      byte[] actual = baos.toByteArray();
      assertThat(xxd(actual)).isEqualTo(xxd(testContent.getBytes()));
    }
  }

  @Test
  public void retryableErrorWhileOpeningIsRetried() throws Exception {
    AtomicInteger reqCounter = new AtomicInteger(0);
    FakeStorage fake =
        FakeStorage.of(
            ImmutableMap.of(
                REQ_OPEN,
                respond -> {
                  int i = reqCounter.incrementAndGet();
                  if (i <= 1) {
                    ApiException apiException =
                        apiException(Code.UNAVAILABLE, String.format("{unavailable %d}", i));
                    respond.onError(apiException);
                  } else {
                    respond.onNext(RES_OPEN);
                  }
                }));

    try (FakeServer fakeServer = FakeServer.of(fake);
        Storage storage =
            fakeServer.getGrpcStorageOptions().toBuilder()
                .setRetrySettings(RetrySettings.newBuilder().setMaxAttempts(3).build())
                .build()
                .getService()) {

      BlobId id = BlobId.of("b", "o");
      ApiFuture<BlobReadSession> futureBlobDescriptor = storage.blobReadSession(id);
      try (BlobReadSession bd = futureBlobDescriptor.get(20, TimeUnit.SECONDS)) {
        assertThat(bd).isNotNull();
      }
    }
  }

  @Test
  public void onCompleteWithoutAValue() throws Exception {
    // I'm not sure if this is something that can actually happen in practice, but is being here
    // to ensure it's at least accounted for, rather than a null pointer exception or something else
    // equally cryptic.
    FakeStorage fake = FakeStorage.of(ImmutableMap.of(REQ_OPEN, StreamObserver::onCompleted));

    try (FakeServer fakeServer = FakeServer.of(fake);
        Storage storage =
            fakeServer.getGrpcStorageOptions().toBuilder()
                .setRetrySettings(RetrySettings.newBuilder().setMaxAttempts(3).build())
                .build()
                .getService()) {

      BlobId id = BlobId.of("b", "o");
      ApiFuture<BlobReadSession> futureBlobDescriptor = storage.blobReadSession(id);
      ExecutionException ee =
          assertThrows(
              ExecutionException.class, () -> futureBlobDescriptor.get(20, TimeUnit.SECONDS));
      assertAll(
          () -> assertThat(ee).hasCauseThat().isInstanceOf(StorageException.class),
          () ->
              assertThat(ee).hasCauseThat().hasCauseThat().isInstanceOf(UnavailableException.class),
          () -> assertThat(((StorageException) ee.getCause()).getCode()).isEqualTo(0),
          () -> {
            String messages = TestUtils.messagesToText(ee.getCause());
            assertThat(messages).contains("Unretryable error");
          });
    }
  }

  /**
   * Create a read that will attempt to read a range as a channel and read another range as an
   * accumulated byte array.
   *
   * <p>Because a channel could block, this should result in two streams being opened against the
   * server.
   *
   * <p>validate that two streams are opened and that getting the accumulated byte array can succeed
   * while the channel hasn't been fully consumed.
   */
  @Test
  public void blobDescriptorTransparentlyForksStreamIfNeeded() throws Exception {
    ChecksummedTestContent content = ChecksummedTestContent.of(ALL_OBJECT_BYTES, 10, 20);
    ChecksummedTestContent content1 = ChecksummedTestContent.of(content.getBytes(), 0, 10);
    ChecksummedTestContent content2 = ChecksummedTestContent.of(content.getBytes(), 10, 10);
    BidiReadObjectRequest req2 = read(1, 10, 20);
    BidiReadObjectResponse res2_1 =
        BidiReadObjectResponse.newBuilder()
            .addObjectDataRanges(
                ObjectRangeData.newBuilder()
                    .setChecksummedData(content1.asChecksummedData())
                    .setReadRange(getReadRange(1, 10, content1))
                    .build())
            .build();
    BidiReadObjectResponse res2_2 =
        BidiReadObjectResponse.newBuilder()
            .addObjectDataRanges(
                ObjectRangeData.newBuilder()
                    .setChecksummedData(content2.asChecksummedData())
                    .setReadRange(getReadRange(1, 20, content2))
                    .setRangeEnd(true)
                    .build())
            .build();

    BidiReadObjectRequest req3 =
        read(2, 10, 20).toBuilder()
            .setReadObjectSpec(
                BidiReadObjectSpec.newBuilder()
                    .setBucket(METADATA.getBucket())
                    .setObject(METADATA.getName())
                    .setGeneration(METADATA.getGeneration())
                    .build())
            .build();
    BidiReadObjectResponse res3 =
        BidiReadObjectResponse.newBuilder()
            .addObjectDataRanges(
                ObjectRangeData.newBuilder()
                    .setChecksummedData(content.asChecksummedData())
                    .setReadRange(getReadRange(2, 10, content))
                    .setRangeEnd(true)
                    .build())
            .build();

    AtomicInteger bidiReadObjectCount = new AtomicInteger();
    CountDownLatch cdl = new CountDownLatch(1);

    StorageImplBase fakeStorage =
        new StorageImplBase() {
          @Override
          public StreamObserver<BidiReadObjectRequest> bidiReadObject(
              StreamObserver<BidiReadObjectResponse> respond) {
            bidiReadObjectCount.getAndIncrement();
            return new StreamObserver<BidiReadObjectRequest>() {
              @Override
              public void onNext(BidiReadObjectRequest request) {
                if (request.equals(REQ_OPEN)) {
                  respond.onNext(RES_OPEN);
                } else if (request.equals(req2)) {
                  // respond with the first half of the bytes, then wait for the second request to
                  // be received before sending the second half.
                  respond.onNext(res2_1);
                  try {
                    cdl.await();
                  } catch (InterruptedException e) {
                    respond.onError(TestUtils.apiException(Code.UNIMPLEMENTED, e.getMessage()));
                  }
                  respond.onNext(res2_2);
                  respond.onCompleted();
                } else if (request.equals(req3)) {
                  respond.onNext(res3);
                  respond.onCompleted();
                  // signal the second request was received
                  cdl.countDown();
                } else {
                  respond.onError(TestUtils.apiException(Code.UNIMPLEMENTED, "Unexpected request"));
                }
              }

              @Override
              public void onError(Throwable t) {
                System.out.println("ITObjectReadSessionFakeTest.onError");
                respond.onError(t);
              }

              @Override
              public void onCompleted() {
                System.out.println("ITObjectReadSessionFakeTest.onCompleted");
                respond.onCompleted();
              }
            };
          }
        };
    try (FakeServer fakeServer = FakeServer.of(fakeStorage);
        Storage storage =
            fakeServer.getGrpcStorageOptions().toBuilder()
                .setRetrySettings(RetrySettings.newBuilder().setMaxAttempts(1).build())
                .build()
                .getService()) {

      BlobId id = BlobId.of("b", "o");
      ApiFuture<BlobReadSession> futureObjectDescriptor = storage.blobReadSession(id);

      ByteBuffer buf = ByteBuffer.allocate(50);
      byte[] bytes = new byte[0];
      Exception caught = null;
      try (BlobReadSession bd = futureObjectDescriptor.get(5, TimeUnit.SECONDS)) {
        try (ScatteringByteChannel c =
            bd.readAs(ReadProjectionConfigs.asChannel().withRangeSpec(RangeSpec.of(10L, 20L)))) {
          buf.limit(5);
          Buffers.fillFrom(buf, c);
          buf.limit(buf.capacity());
          ApiFuture<byte[]> future =
              bd.readAs(
                  ReadProjectionConfigs.asFutureBytes().withRangeSpec(RangeSpec.of(10L, 20L)));
          bytes = future.get(3, TimeUnit.SECONDS);
          Buffers.fillFrom(buf, c);
        }
      } catch (Exception e) {
        // stash off any runtime failure so we can still do our assertions to help determine
        // the true failure
        caught = e;
      } finally {
        final byte[] finalBytes = bytes;
        final Exception finalCaught = caught;
        assertAll(
            () -> assertThat(bidiReadObjectCount.get()).isEqualTo(2),
            () ->
                assertWithMessage("Channel bytes missmatch")
                    .that(xxd(buf))
                    .isEqualTo(xxd(content.getBytes())),
            () ->
                assertWithMessage("Future bytes missmatch")
                    .that(xxd(finalBytes))
                    .isEqualTo(xxd(content.getBytes())),
            () -> {
              if (finalCaught != null) {
                throw new Exception("exception during test", finalCaught);
              }
            });
      }
    }
  }

  @Test
  public void gettingSessionFromFastOpenKeepsTheSessionOpenUntilClosed() throws Exception {
    ChecksummedTestContent expected = ChecksummedTestContent.of(ALL_OBJECT_BYTES, 10, 30);

    ChecksummedTestContent content1 = ChecksummedTestContent.of(ALL_OBJECT_BYTES, 10, 10);
    ChecksummedTestContent content2 = ChecksummedTestContent.of(ALL_OBJECT_BYTES, 20, 10);
    ChecksummedTestContent content3 = ChecksummedTestContent.of(ALL_OBJECT_BYTES, 30, 10);
    BidiReadObjectRequest req1 =
        BidiReadObjectRequest.newBuilder()
            .setReadObjectSpec(
                BidiReadObjectSpec.newBuilder()
                    .setBucket(METADATA.getBucket())
                    .setObject(METADATA.getName())
                    .build())
            .addReadRanges(getReadRange(1, 10, 10))
            .build();
    BidiReadObjectResponse res1 =
        BidiReadObjectResponse.newBuilder()
            .setMetadata(METADATA)
            .addObjectDataRanges(
                ObjectRangeData.newBuilder()
                    .setReadRange(getReadRange(1, 10, content1))
                    .setChecksummedData(content1.asChecksummedData())
                    .setRangeEnd(true)
                    .build())
            .build();

    BidiReadObjectRequest req2 = read(2, 20, 10);
    BidiReadObjectResponse res2 =
        BidiReadObjectResponse.newBuilder()
            .addObjectDataRanges(
                ObjectRangeData.newBuilder()
                    .setReadRange(getReadRange(2, 20, content2))
                    .setChecksummedData(content2.asChecksummedData())
                    .setRangeEnd(true)
                    .build())
            .build();
    BidiReadObjectRequest req3 = read(3, 30, 10);
    BidiReadObjectResponse res3 =
        BidiReadObjectResponse.newBuilder()
            .addObjectDataRanges(
                ObjectRangeData.newBuilder()
                    .setReadRange(getReadRange(3, 30, content3))
                    .setChecksummedData(content3.asChecksummedData())
                    .setRangeEnd(true)
                    .build())
            .build();

    ImmutableMap<BidiReadObjectRequest, BidiReadObjectResponse> db =
        ImmutableMap.<BidiReadObjectRequest, BidiReadObjectResponse>builder()
            .put(req1, res1)
            .put(req2, res2)
            .put(req3, res3)
            .buildOrThrow();

    FakeStorage fakeStorage = FakeStorage.from(db);

    try (FakeServer fakeServer = FakeServer.of(fakeStorage);
        Storage storage =
            fakeServer.getGrpcStorageOptions().toBuilder()
                .setRetrySettings(RetrySettings.newBuilder().setMaxAttempts(1).build())
                .build()
                .getService()) {
      StorageDataClient dataClient = maybeGetStorageDataClient(storage);
      assertThat(dataClient).isNotNull();

      BidiReadObjectRequest req =
          BidiReadObjectRequest.newBuilder()
              .setReadObjectSpec(
                  BidiReadObjectSpec.newBuilder()
                      .setBucket(METADATA.getBucket())
                      .setObject(METADATA.getName())
                      .build())
              .build();

      ApiFuture<FastOpenObjectReadSession<ApiFuture<DisposableByteString>>> future =
          dataClient.fastOpenReadSession(
              req,
              GrpcCallContext.createDefault(),
              ReadProjectionConfigs.asFutureByteString().withRangeSpec(RangeSpec.of(10, 10)));

      ByteString bytes = ByteString.empty();
      Exception caught = null;

      try (FastOpenObjectReadSession<ApiFuture<DisposableByteString>> fastOpenChannel =
              future.get(5, TimeUnit.SECONDS);
          ObjectReadSession session = fastOpenChannel.getSession()) {
        ApiFuture<DisposableByteString> futureBytes1 = fastOpenChannel.getProjection();
        try (DisposableByteString disposableByteString = futureBytes1.get()) {
          bytes = bytes.concat(disposableByteString.byteString());
        }

        ApiFuture<DisposableByteString> futureBytes2 =
            session.readAs(
                ReadProjectionConfigs.asFutureByteString().withRangeSpec(RangeSpec.of(20L, 10L)));
        try (DisposableByteString disposableByteString = futureBytes2.get()) {
          bytes = bytes.concat(disposableByteString.byteString());
        }

        ApiFuture<DisposableByteString> futureBytes3 =
            session.readAs(
                ReadProjectionConfigs.asFutureByteString().withRangeSpec(RangeSpec.of(30L, 10L)));
        try (DisposableByteString disposableByteString = futureBytes3.get()) {
          bytes = bytes.concat(disposableByteString.byteString());
        }

      } catch (Exception e) {
        // stash off any runtime failure so we can still do our assertions to help determine
        // the true failure
        caught = e;
      } finally {
        final ByteString finalBytes = bytes;
        final Exception finalCaught = caught;
        assertAll(
            () -> assertThat(xxd(finalBytes)).isEqualTo(xxd(expected.getBytes())),
            () -> {
              if (finalCaught != null) {
                throw new Exception("exception during test", finalCaught);
              }
            });
      }
    }
  }

  @Test
  public void expectRetryForRangeWithFailedChecksumValidation_channel() throws Exception {
    ChecksummedTestContent expected = ChecksummedTestContent.of(ALL_OBJECT_BYTES, 10, 20);

    ChecksummedTestContent content2_1 = ChecksummedTestContent.of(ALL_OBJECT_BYTES, 10, 10);
    ChecksummedTestContent content2_2 = ChecksummedTestContent.of(ALL_OBJECT_BYTES, 20, 10);
    BidiReadObjectRequest req2 = read(1, 10, 20);
    BidiReadObjectResponse res2_1 =
        BidiReadObjectResponse.newBuilder()
            .addObjectDataRanges(
                ObjectRangeData.newBuilder()
                    .setChecksummedData(content2_1.asChecksummedData())
                    .setReadRange(getReadRange(1, 10, 10))
                    .build())
            .build();
    BidiReadObjectResponse res2_2 =
        BidiReadObjectResponse.newBuilder()
            .setMetadata(METADATA)
            .addObjectDataRanges(
                ObjectRangeData.newBuilder()
                    .setChecksummedData(content2_2.asChecksummedData().toBuilder().setCrc32C(1))
                    .setReadRange(getReadRange(1, 20, 10))
                    .setRangeEnd(true)
                    .build())
            .build();

    BidiReadObjectRequest req3 =
        BidiReadObjectRequest.newBuilder().addReadRanges(getReadRange(2, 20, 10)).build();
    BidiReadObjectResponse res3 =
        BidiReadObjectResponse.newBuilder()
            .addObjectDataRanges(
                ObjectRangeData.newBuilder()
                    .setChecksummedData(content2_2.asChecksummedData())
                    .setReadRange(getReadRange(2, 20, 10))
                    .setRangeEnd(true)
                    .build())
            .build();

    FakeStorage fake =
        FakeStorage.of(
            ImmutableMap.of(
                REQ_OPEN,
                respond -> respond.onNext(RES_OPEN),
                req2,
                respond -> {
                  respond.onNext(res2_1);
                  respond.onNext(res2_2);
                },
                req3,
                respond -> respond.onNext(res3)));

    try (FakeServer fakeServer = FakeServer.of(fake);
        Storage storage = fakeServer.getGrpcStorageOptions().getService()) {

      BlobId id = BlobId.of("b", "o");
      ApiFuture<BlobReadSession> futureObjectDescriptor = storage.blobReadSession(id);

      try (BlobReadSession bd = futureObjectDescriptor.get(5, TimeUnit.SECONDS)) {

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try (ScatteringByteChannel r =
                bd.readAs(ReadProjectionConfigs.asChannel().withRangeSpec(RangeSpec.of(10L, 20L)));
            WritableByteChannel w = Channels.newChannel(baos)) {
          ByteStreams.copy(r, w);
        }

        byte[] actual = baos.toByteArray();
        Crc32cLengthKnown actualCrc32c = Hasher.enabled().hash(ByteBuffer.wrap(actual));

        byte[] expectedBytes = expected.getBytes();
        Crc32cLengthKnown expectedCrc32c =
            Crc32cValue.of(expected.getCrc32c(), expectedBytes.length);

        assertAll(
            () -> assertThat(actual).hasLength(expectedBytes.length),
            () -> assertThat(xxd(actual)).isEqualTo(xxd(expectedBytes)),
            () -> assertThat(actualCrc32c).isEqualTo(expectedCrc32c));
      }
    }
  }

  /**
   * Define a test where multiple reads for the same session will be performed, and some of those
   * reads cause OUT_OF_RANGE errors.
   *
   * <p>An OUT_OF_RANGE error is delivered as a stream level status, which means any reads which
   * share a stream must be restarted while the read that caused the OUT_OF_RANGE should be failed.
   *
   * <p>Verify this behavior for both channel based and future byte[] based.
   */
  @Test
  public void serverOutOfRangeIsNotRetried() throws Exception {
    ChecksummedTestContent expected = ChecksummedTestContent.of(ALL_OBJECT_BYTES, 10, 20);

    BidiReadObjectResponse dataResp =
        BidiReadObjectResponse.newBuilder()
            .addObjectDataRanges(
                ObjectRangeData.newBuilder()
                    .setChecksummedData(expected.asChecksummedData())
                    .setReadRange(getReadRange(0, 10, 20))
                    .setRangeEnd(true)
                    .build())
            .build();

    AtomicInteger bidiReadObjectCount = new AtomicInteger();
    ExecutorService exec =
        Executors.newCachedThreadPool(
            new ThreadFactoryBuilder().setDaemon(true).setNameFormat("exec-%d").build());

    // The test will submit 4 different reads to the server, we want to wait until all 4 are
    // received by the server before sending any responses.
    CountDownLatch serverWaitCdl = new CountDownLatch(4);
    // Then, we want the test to wait for all read responses to be returned from the server before
    // beginning assertions.
    CountDownLatch testWaitCdl = new CountDownLatch(4);

    StorageImplBase fakeStorage =
        new StorageImplBase() {
          @Override
          public StreamObserver<BidiReadObjectRequest> bidiReadObject(
              StreamObserver<BidiReadObjectResponse> respond) {
            bidiReadObjectCount.getAndIncrement();
            return new StreamObserver<BidiReadObjectRequest>() {
              @Override
              public void onNext(BidiReadObjectRequest request) {
                if (request.equals(REQ_OPEN)) {
                  respond.onNext(RES_OPEN);
                } else if (request.getReadRangesList().get(0).getReadOffset() == 10) {
                  exec.submit(
                      () -> {
                        try {
                          // when receiving a request on the stream for the valid range
                          // send it to a background thread that will wait for all reads to be setup
                          serverWaitCdl.await();
                          BidiReadObjectResponse.Builder b = dataResp.toBuilder();
                          ReadRange readRange = request.getReadRangesList().get(0);
                          ObjectRangeData.Builder bb = dataResp.getObjectDataRanges(0).toBuilder();
                          bb.getReadRangeBuilder().setReadId(readRange.getReadId());
                          b.setObjectDataRanges(0, bb.build());
                          respond.onNext(b.build());
                          testWaitCdl.countDown();
                        } catch (InterruptedException e) {
                          respond.onError(
                              TestUtils.apiException(Code.UNIMPLEMENTED, e.getMessage()));
                        }
                      });
                } else if (bidiReadObjectCount.getAndIncrement() >= 1) {
                  Optional<ReadRange> readRange = request.getReadRangesList().stream().findFirst();
                  String message =
                      String.format(
                          Locale.US,
                          "OUT_OF_RANGE read_offset = %d",
                          readRange.map(ReadRange::getReadOffset).orElse(0L));
                  long readId = readRange.map(ReadRange::getReadId).orElse(0L);

                  BidiReadObjectError err2 =
                      BidiReadObjectError.newBuilder()
                          .addReadRangeErrors(
                              ReadRangeError.newBuilder()
                                  .setReadId(readId)
                                  .setStatus(
                                      com.google.rpc.Status.newBuilder()
                                          .setCode(com.google.rpc.Code.OUT_OF_RANGE_VALUE)
                                          .build())
                                  .build())
                          .build();

                  com.google.rpc.Status grpcStatusDetails =
                      com.google.rpc.Status.newBuilder()
                          .setCode(com.google.rpc.Code.UNAVAILABLE_VALUE)
                          .setMessage("fail read_id: " + readId)
                          .addDetails(Any.pack(err2))
                          .addDetails(
                              Any.pack(
                                  DebugInfo.newBuilder()
                                      .setDetail(message)
                                      .addStackEntries(
                                          TextFormat.printer().shortDebugString(request))
                                      .build()))
                          .build();

                  Metadata trailers = new Metadata();
                  trailers.put(GRPC_STATUS_DETAILS_KEY, grpcStatusDetails);
                  StatusRuntimeException statusRuntimeException =
                      Status.OUT_OF_RANGE.withDescription(message).asRuntimeException(trailers);
                  respond.onError(statusRuntimeException);
                  testWaitCdl.countDown();
                } else {
                  respond.onError(
                      apiException(
                          Code.UNIMPLEMENTED,
                          "Unexpected request { "
                              + TextFormat.printer().shortDebugString(request)
                              + " }"));
                }
              }

              @Override
              public void onError(Throwable t) {
                respond.onError(t);
              }

              @Override
              public void onCompleted() {
                respond.onCompleted();
              }
            };
          }
        };
    try (FakeServer fakeServer = FakeServer.of(fakeStorage);
        Storage storage = fakeServer.getGrpcStorageOptions().getService()) {

      BlobId id = BlobId.of("b", "o");

      // define the number of seconds our futures are willing to wait before timeout.
      // In general everything should resolve in a small number of millis, this is more of a
      // safeguard to prevent the whole suite hanging if there is an issue.
      int timeoutSeconds = 5;
      try (BlobReadSession session =
          storage.blobReadSession(id).get(timeoutSeconds, TimeUnit.SECONDS)) {

        ApiFuture<byte[]> expectSuccessFuture =
            session.readAs(
                ReadProjectionConfigs.asFutureBytes().withRangeSpec(RangeSpec.of(10, 20)));
        serverWaitCdl.countDown();

        ApiFuture<byte[]> expectFailureFuture =
            session.readAs(
                ReadProjectionConfigs.asFutureBytes().withRangeSpec(RangeSpec.beginAt(37)));
        serverWaitCdl.countDown();

        ReadAsChannel readAsChannel = ReadProjectionConfigs.asChannel();
        Future<byte[]> expectSuccessChannel =
            exec.submit(
                () -> {
                  try (ScatteringByteChannel succeed =
                      session.readAs(readAsChannel.withRangeSpec(RangeSpec.of(10, 20)))) {
                    serverWaitCdl.countDown();
                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    ByteStreams.copy(succeed, Channels.newChannel(baos));
                    return baos.toByteArray();
                  }
                });

        Future<Integer> expectFailureChannel =
            exec.submit(
                () -> {
                  try (ScatteringByteChannel fail =
                      session.readAs(readAsChannel.withRangeSpec(RangeSpec.beginAt(39)))) {
                    serverWaitCdl.countDown();
                    int read;
                    do {
                      read = fail.read(ByteBuffer.allocate(1));
                    } while (read == 0);
                    return read;
                  }
                });

        boolean await = testWaitCdl.await(timeoutSeconds, TimeUnit.SECONDS);
        assertThat(await).isTrue();
        ExecutionException exceptionFromFuture =
            assertThrows(
                ExecutionException.class,
                () -> expectFailureFuture.get(timeoutSeconds, TimeUnit.SECONDS));
        byte[] bytesFromFuture = expectSuccessFuture.get(timeoutSeconds, TimeUnit.SECONDS);
        ExecutionException finalExceptionFromChannel =
            assertThrows(
                ExecutionException.class,
                () -> expectFailureChannel.get(timeoutSeconds, TimeUnit.SECONDS));
        byte[] bytesFromChannel = expectSuccessChannel.get(timeoutSeconds, TimeUnit.SECONDS);

        assertAll(
            () ->
                assertThat(exceptionFromFuture) // ExecutionException
                    .hasCauseThat() // StorageException
                    .hasCauseThat()
                    .isInstanceOf(OutOfRangeException.class),
            () ->
                assertThat(finalExceptionFromChannel) // ExecutionException
                    .hasCauseThat() // IOException
                    .hasCauseThat() // StorageException
                    .hasCauseThat()
                    .isInstanceOf(OutOfRangeException.class),
            () -> assertThat(xxd(bytesFromFuture)).isEqualTo(xxd(expected.getBytes())),
            () -> assertThat(xxd(bytesFromChannel)).isEqualTo(xxd(expected.getBytes())));
      }
    }
  }

  private static void runTestAgainstFakeServer(
      FakeStorage fakeStorage, RangeSpec range, ChecksummedTestContent expected) throws Exception {

    try (FakeServer fakeServer = FakeServer.of(fakeStorage);
        Storage storage = fakeServer.getGrpcStorageOptions().getService()) {

      BlobId id = BlobId.of("b", "o");
      ApiFuture<BlobReadSession> futureObjectDescriptor = storage.blobReadSession(id);

      try (BlobReadSession bd = futureObjectDescriptor.get(5, TimeUnit.SECONDS)) {
        ApiFuture<byte[]> future =
            bd.readAs(ReadProjectionConfigs.asFutureBytes().withRangeSpec(range));

        byte[] actual = future.get(5, TimeUnit.SECONDS);
        Crc32cLengthKnown actualCrc32c = Hasher.enabled().hash(ByteBuffer.wrap(actual));

        byte[] expectedBytes = expected.getBytes();
        Crc32cLengthKnown expectedCrc32c =
            Crc32cValue.of(expected.getCrc32c(), expectedBytes.length);

        assertAll(
            () -> assertThat(actual).hasLength(expectedBytes.length),
            () -> assertThat(xxd(actual)).isEqualTo(xxd(expectedBytes)),
            () -> assertThat(actualCrc32c).isEqualTo(expectedCrc32c));
      }
    }
  }

  static BidiReadObjectRequest read(int readId, int readOffset, int readLength) {
    return BidiReadObjectRequest.newBuilder()
        .addReadRanges(getReadRange(readId, readOffset, readLength))
        .build();
  }

  static ReadRange getReadRange(int readId, int readOffset, ChecksummedTestContent content) {
    return getReadRange(readId, readOffset, content.asChecksummedData().getContent().size());
  }

  static ReadRange getReadRange(int readId, int readOffset, int readLength) {
    return ReadRange.newBuilder()
        .setReadId(readId)
        .setReadOffset(readOffset)
        .setReadLength(readLength)
        .build();
  }

  static ThrowingRunnable assert503(ApiFuture<?> f) {
    return assertStatusCodeIs(f, 503);
  }

  static ThrowingRunnable assertStatusCodeIs(ApiFuture<?> f, int expected) {
    return () -> {
      StorageException se =
          assertThrows(StorageException.class, () -> TestUtils.await(f, 5, TimeUnit.SECONDS));
      assertThat(se.getCode()).isEqualTo(expected);
    };
  }

  static String fmt(ReadRange r) {
    return String.format(
        "ReadRange{id: %d, offset: %d, length: %d}",
        r.getReadId(), r.getReadOffset(), r.getReadLength());
  }

  static ObjectReadSessionImpl getObjectReadSessionImpl(BlobReadSession bd) {
    ObjectReadSessionImpl orsi = null;
    if (bd instanceof OtelDecoratingBlobReadSession) {
      OtelDecoratingBlobReadSession odbrs = (OtelDecoratingBlobReadSession) bd;
      bd = odbrs.delegate;
    }
    if (bd instanceof BlobReadSessionAdapter) {
      BlobReadSessionAdapter brsa = (BlobReadSessionAdapter) bd;
      ObjectReadSession session = brsa.session;
      if (session instanceof ObjectReadSessionImpl) {
        orsi = (ObjectReadSessionImpl) session;
      }
    }
    if (orsi == null) {
      fail("unable to locate state for validation");
    }
    return orsi;
  }

  static final class FakeStorage extends StorageImplBase {

    private final Map<BidiReadObjectRequest, Consumer<StreamObserver<BidiReadObjectResponse>>> db;

    private FakeStorage(
        Map<BidiReadObjectRequest, Consumer<StreamObserver<BidiReadObjectResponse>>> db) {
      this.db = db;
    }

    @Override
    public StreamObserver<BidiReadObjectRequest> bidiReadObject(
        StreamObserver<BidiReadObjectResponse> respond) {
      return new AbstractObserver(respond) {
        @Override
        public void onNext(BidiReadObjectRequest req) {
          if (db.containsKey(req)) {
            db.get(req).accept(respond);
          } else {
            respond.onError(TestUtils.apiException(Code.UNIMPLEMENTED, "Unexpected request"));
          }
        }
      };
    }

    static FakeStorage of(
        Map<BidiReadObjectRequest, Consumer<StreamObserver<BidiReadObjectResponse>>> db) {
      return new FakeStorage(db);
    }

    static FakeStorage from(Map<BidiReadObjectRequest, BidiReadObjectResponse> db) {
      return new FakeStorage(Maps.transformValues(db, resp -> (respond) -> respond.onNext(resp)));
    }
  }

  abstract static class AbstractObserver implements StreamObserver<BidiReadObjectRequest> {

    protected final StreamObserver<BidiReadObjectResponse> respond;

    private AbstractObserver(StreamObserver<BidiReadObjectResponse> respond) {
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
