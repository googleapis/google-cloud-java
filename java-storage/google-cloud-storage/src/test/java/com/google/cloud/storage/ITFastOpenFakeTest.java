/*
 * Copyright 2026 Google LLC
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
import static com.google.cloud.storage.ITObjectReadSessionFakeTest.getReadRange;
import static com.google.cloud.storage.ITObjectReadSessionFakeTest.read;
import static com.google.cloud.storage.PackagePrivateMethodWorkarounds.maybeGetStorageDataClient;
import static com.google.cloud.storage.TestUtils.GRPC_STATUS_DETAILS_KEY;
import static com.google.cloud.storage.TestUtils.xxd;
import static com.google.common.truth.Truth.assertThat;
import static java.util.concurrent.TimeUnit.SECONDS;
import static java.util.stream.Collectors.toList;
import static org.junit.Assert.assertThrows;

import com.google.api.core.ApiFuture;
import com.google.api.gax.grpc.GrpcCallContext;
import com.google.api.gax.rpc.OutOfRangeException;
import com.google.cloud.storage.ITObjectReadSessionFakeTest.FakeStorage;
import com.google.cloud.storage.ReadProjectionConfigs.BaseConfig;
import com.google.cloud.storage.Storage.BlobSourceOption;
import com.google.cloud.storage.it.ChecksummedTestContent;
import com.google.cloud.storage.otel.TestExporter;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.protobuf.Any;
import com.google.storage.v2.BidiReadObjectError;
import com.google.storage.v2.BidiReadObjectRequest;
import com.google.storage.v2.BidiReadObjectResponse;
import com.google.storage.v2.BidiReadObjectSpec;
import com.google.storage.v2.BucketName;
import com.google.storage.v2.Object;
import com.google.storage.v2.ObjectRangeData;
import com.google.storage.v2.ReadRangeError;
import io.grpc.Metadata;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import io.opentelemetry.api.trace.StatusCode;
import io.opentelemetry.sdk.OpenTelemetrySdk;
import io.opentelemetry.sdk.trace.SdkTracerProvider;
import io.opentelemetry.sdk.trace.data.SpanData;
import io.opentelemetry.sdk.trace.export.SimpleSpanProcessor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;
import org.junit.Test;

public final class ITFastOpenFakeTest {

  private static final byte[] ALL_OBJECT_BYTES = DataGenerator.base64Characters().genBytes(64);
  private static final Object METADATA =
      Object.newBuilder()
          .setBucket(BucketName.format("_", "b"))
          .setName("o")
          .setGeneration(1)
          .setSize(_2MiB)
          .build();
  private static final GrpcCallContext CTX = GrpcCallContext.createDefault();
  private static final BlobId BLOB_ID = BlobId.of("b", "o");

  private static final BidiReadObjectRequest OPEN =
      BidiReadObjectRequest.newBuilder()
          .setReadObjectSpec(
              BidiReadObjectSpec.newBuilder()
                  .setBucket(METADATA.getBucket())
                  .setObject(METADATA.getName())
                  .build())
          .build();
  private static final BidiReadObjectRequest OPEN_WITH_READ_OF_10_TO_20 =
      OPEN.toBuilder().addReadRanges(getReadRange(1, 10, 10)).build();

  private static final ReadAsFutureBytes READ_10_TO_20 =
      ReadProjectionConfigs.asFutureBytes().withRangeSpec(RangeSpec.of(10, 10));
  private static final ReadAsFutureBytes READ_20_TO_30 =
      ReadProjectionConfigs.asFutureBytes().withRangeSpec(RangeSpec.of(20, 10));

  /** Every request the fake server received, in order. */
  private final List<BidiReadObjectRequest> requestsReceived =
      Collections.synchronizedList(new ArrayList<>());

  @Test
  public void openRequest_includesTheFastOpenRead() throws Exception {
    FakeStorage server =
        fakeServer(ImmutableMap.of(OPEN_WITH_READ_OF_10_TO_20, metadataAndBytes(1, 10, 10)));

    try (FakeServer fakeServer = FakeServer.of(server);
        Storage storage = fakeServer.getGrpcStorageOptions().getService()) {
      StorageDataClient dataClient = maybeGetStorageDataClient(storage);

      ObjectReadSession session =
          dataClient.readSession(OPEN, CTX, ImmutableList.of(READ_10_TO_20)).get(5, SECONDS);
      session.close();
    }

    assertThat(requestsReceived).containsExactly(OPEN_WITH_READ_OF_10_TO_20);
  }

  @Test
  public void openRequest_withoutFastOpenReads_isUnchanged() throws Exception {
    FakeStorage server = fakeServer(ImmutableMap.of(OPEN, metadataOnly()));

    try (FakeServer fakeServer = FakeServer.of(server);
        Storage storage = fakeServer.getGrpcStorageOptions().getService()) {
      StorageDataClient dataClient = maybeGetStorageDataClient(storage);

      ObjectReadSession session =
          dataClient.readSession(OPEN, CTX, ImmutableList.of()).get(5, SECONDS);
      session.close();
    }

    assertThat(requestsReceived).containsExactly(OPEN);
  }

  @Test
  public void readAs_withTheFastOpenConfig_doesNotSendAnotherRequest() throws Exception {
    FakeStorage server =
        fakeServer(ImmutableMap.of(OPEN_WITH_READ_OF_10_TO_20, metadataAndBytes(1, 10, 10)));

    try (FakeServer fakeServer = FakeServer.of(server);
        Storage storage = fakeServer.getGrpcStorageOptions().getService()) {
      StorageDataClient dataClient = maybeGetStorageDataClient(storage);

      try (ObjectReadSession session =
          dataClient.readSession(OPEN, CTX, ImmutableList.of(READ_10_TO_20)).get(5, SECONDS)) {
        byte[] actual = session.readAs(READ_10_TO_20).get(2, SECONDS);
        assertThat(xxd(actual)).isEqualTo(xxd(slice(10, 10)));
      }
    }

    assertThat(requestsReceived).containsExactly(OPEN_WITH_READ_OF_10_TO_20);
  }

  @Test
  public void readAs_withTheFastOpenConfigAgain_sendsANewRead() throws Exception {
    BidiReadObjectRequest secondReadOf10To20 = read(2, 10, 10);
    FakeStorage server =
        fakeServer(
            ImmutableMap.of(
                OPEN_WITH_READ_OF_10_TO_20, metadataAndBytes(1, 10, 10),
                secondReadOf10To20, bytes(2, 10, 10)));

    try (FakeServer fakeServer = FakeServer.of(server);
        Storage storage = fakeServer.getGrpcStorageOptions().getService()) {
      StorageDataClient dataClient = maybeGetStorageDataClient(storage);

      try (ObjectReadSession session =
          dataClient.readSession(OPEN, CTX, ImmutableList.of(READ_10_TO_20)).get(5, SECONDS)) {
        byte[] fastOpen = session.readAs(READ_10_TO_20).get(2, SECONDS);
        byte[] second = session.readAs(READ_10_TO_20).get(2, SECONDS);
        assertThat(xxd(fastOpen)).isEqualTo(xxd(slice(10, 10)));
        assertThat(xxd(second)).isEqualTo(xxd(slice(10, 10)));
      }
    }

    assertThat(requestsReceived)
        .containsExactly(OPEN_WITH_READ_OF_10_TO_20, secondReadOf10To20)
        .inOrder();
  }

  @Test
  public void readAs_withADifferentConfig_sendsANewRead_andKeepsTheFastOpenRead() throws Exception {
    BidiReadObjectRequest readOf20To30 = read(2, 20, 10);
    FakeStorage server =
        fakeServer(
            ImmutableMap.of(
                OPEN_WITH_READ_OF_10_TO_20, metadataAndBytes(1, 10, 10),
                readOf20To30, bytes(2, 20, 10)));

    try (FakeServer fakeServer = FakeServer.of(server);
        Storage storage = fakeServer.getGrpcStorageOptions().getService()) {
      StorageDataClient dataClient = maybeGetStorageDataClient(storage);

      try (ObjectReadSession session =
          dataClient.readSession(OPEN, CTX, ImmutableList.of(READ_10_TO_20)).get(5, SECONDS)) {
        byte[] other = session.readAs(READ_20_TO_30).get(2, SECONDS);
        byte[] fastOpen = session.readAs(READ_10_TO_20).get(2, SECONDS);
        assertThat(xxd(other)).isEqualTo(xxd(slice(20, 10)));
        assertThat(xxd(fastOpen)).isEqualTo(xxd(slice(10, 10)));
      }
    }

    assertThat(requestsReceived)
        .containsExactly(OPEN_WITH_READ_OF_10_TO_20, readOf20To30)
        .inOrder();
  }

  @Test
  public void readAs_withAWrappedFastOpenConfig_isServedFromTheFastOpenRead() throws Exception {
    BidiReadObjectRequest secondReadOf10To20 = read(2, 10, 10);
    FakeStorage server =
        fakeServer(
            ImmutableMap.of(
                OPEN_WITH_READ_OF_10_TO_20, metadataAndBytes(1, 10, 10),
                secondReadOf10To20, bytes(2, 10, 10)));
    WrappedConfig wrapped = new WrappedConfig(READ_10_TO_20);

    try (FakeServer fakeServer = FakeServer.of(server);
        Storage storage = fakeServer.getGrpcStorageOptions().getService()) {
      StorageDataClient dataClient = maybeGetStorageDataClient(storage);

      try (ObjectReadSession session =
          dataClient.readSession(OPEN, CTX, ImmutableList.of(READ_10_TO_20)).get(5, SECONDS)) {
        ApiFuture<byte[]> fastOpenFuture = session.readAs(wrapped);
        assertThat(wrapped.claimed).containsExactly(fastOpenFuture);
        byte[] fastOpen = fastOpenFuture.get(2, SECONDS);
        byte[] second = session.readAs(wrapped).get(2, SECONDS);
        assertThat(wrapped.claimed).containsExactly(fastOpenFuture);
        assertThat(xxd(fastOpen)).isEqualTo(xxd(slice(10, 10)));
        assertThat(xxd(second)).isEqualTo(xxd(slice(10, 10)));
      }
    }

    assertThat(requestsReceived)
        .containsExactly(OPEN_WITH_READ_OF_10_TO_20, secondReadOf10To20)
        .inOrder();
  }

  @Test
  public void close_withAnUnclaimedFastOpenRead_closesTheSession() throws Exception {
    FakeStorage server =
        fakeServer(ImmutableMap.of(OPEN_WITH_READ_OF_10_TO_20, metadataAndBytes(1, 10, 10)));

    try (FakeServer fakeServer = FakeServer.of(server);
        Storage storage = fakeServer.getGrpcStorageOptions().getService()) {
      StorageDataClient dataClient = maybeGetStorageDataClient(storage);

      ObjectReadSession session =
          dataClient.readSession(OPEN, CTX, ImmutableList.of(READ_10_TO_20)).get(5, SECONDS);
      session.close();

      assertThrows(IllegalStateException.class, () -> session.readAs(READ_10_TO_20));
    }

    assertThat(requestsReceived).containsExactly(OPEN_WITH_READ_OF_10_TO_20);
  }

  @Test
  public void readSession_withMoreThanOneFastOpenConfig_isRejected() throws Exception {
    FakeStorage server = fakeServer(ImmutableMap.of());

    try (FakeServer fakeServer = FakeServer.of(server);
        Storage storage = fakeServer.getGrpcStorageOptions().getService()) {
      StorageDataClient dataClient = maybeGetStorageDataClient(storage);

      assertThrows(
          IllegalArgumentException.class,
          () -> dataClient.readSession(OPEN, CTX, ImmutableList.of(READ_10_TO_20, READ_20_TO_30)));
    }

    assertThat(requestsReceived).isEmpty();
  }

  @Test
  public void readSession_withASeekableChannelConfig_isRejected() throws Exception {
    FakeStorage server = fakeServer(ImmutableMap.of());

    try (FakeServer fakeServer = FakeServer.of(server);
        Storage storage = fakeServer.getGrpcStorageOptions().getService()) {
      StorageDataClient dataClient = maybeGetStorageDataClient(storage);

      assertThrows(
          IllegalArgumentException.class,
          () ->
              dataClient.readSession(
                  OPEN, CTX, ImmutableList.of(ReadProjectionConfigs.asSeekableChannel())));
    }

    assertThat(requestsReceived).isEmpty();
  }

  @Test
  public void open_whenTheServerFailsTheStreamWithOutOfRange_failsWithoutRetrying()
      throws Exception {
    FakeStorage server =
        FakeStorage.of(
            ImmutableMap.of(
                OPEN_WITH_READ_OF_10_TO_20,
                client -> {
                  requestsReceived.add(OPEN_WITH_READ_OF_10_TO_20);
                  client.onError(Status.OUT_OF_RANGE.asRuntimeException());
                }));

    try (FakeServer fakeServer = FakeServer.of(server);
        Storage storage = fakeServer.getGrpcStorageOptions().getService()) {
      StorageDataClient dataClient = maybeGetStorageDataClient(storage);

      ApiFuture<ObjectReadSession> open =
          dataClient.readSession(OPEN, CTX, ImmutableList.of(READ_10_TO_20));

      ExecutionException e = assertThrows(ExecutionException.class, () -> open.get(5, SECONDS));
      // the error the server returned is somewhere in the chain of causes
      assertThat(
              Throwables.getCausalChain(e).stream()
                  .<Class<?>>map(Throwable::getClass)
                  .collect(toList()))
          .contains(OutOfRangeException.class);
    }

    assertThat(requestsReceived).containsExactly(OPEN_WITH_READ_OF_10_TO_20);
  }

  @Test
  public void open_whenTheServerRejectsOnlyTheFastOpenRange_reopensWithoutItAndReadAsFails()
      throws Exception {
    FakeStorage server = rejectsOnlyTheFastOpenRange();

    try (FakeServer fakeServer = FakeServer.of(server);
        Storage storage = fakeServer.getGrpcStorageOptions().getService()) {
      StorageDataClient dataClient = maybeGetStorageDataClient(storage);

      try (ObjectReadSession session =
          dataClient.readSession(OPEN, CTX, ImmutableList.of(READ_10_TO_20)).get(10, SECONDS)) {
        ApiFuture<byte[]> read = session.readAs(READ_10_TO_20);

        ExecutionException e = assertThrows(ExecutionException.class, () -> read.get(5, SECONDS));
        assertThat(
                Throwables.getCausalChain(e).stream()
                    .<Class<?>>map(Throwable::getClass)
                    .collect(toList()))
            .contains(OutOfRangeException.class);
      }
    }

    assertThat(requestsReceived).containsExactly(OPEN_WITH_READ_OF_10_TO_20, OPEN).inOrder();
  }

  @Test
  public void open_whenTheConnectionDropsBeforeAnyReply_retriesWithTheSameRange() throws Exception {
    AtomicInteger attempts = new AtomicInteger();
    FakeStorage server =
        FakeStorage.of(
            ImmutableMap.of(
                OPEN_WITH_READ_OF_10_TO_20,
                client -> {
                  requestsReceived.add(OPEN_WITH_READ_OF_10_TO_20);
                  if (attempts.getAndIncrement() == 0) {
                    client.onError(Status.UNAVAILABLE.asRuntimeException());
                  } else {
                    client.onNext(metadataAndBytes(1, 10, 10));
                  }
                }));

    try (FakeServer fakeServer = FakeServer.of(server);
        Storage storage = fakeServer.getGrpcStorageOptions().getService()) {
      StorageDataClient dataClient = maybeGetStorageDataClient(storage);

      try (ObjectReadSession session =
          dataClient.readSession(OPEN, CTX, ImmutableList.of(READ_10_TO_20)).get(10, SECONDS)) {
        byte[] actual = session.readAs(READ_10_TO_20).get(5, SECONDS);
        assertThat(xxd(actual)).isEqualTo(xxd(slice(10, 10)));
      }
    }

    assertThat(requestsReceived)
        .containsExactly(OPEN_WITH_READ_OF_10_TO_20, OPEN_WITH_READ_OF_10_TO_20)
        .inOrder();
  }

  @Test
  public void open_whenTheConnectionDropsHalfway_fetchesOnlyTheRestOfTheRange() throws Exception {
    // the first reply has bytes 10-15 only, it is not the end of the range
    BidiReadObjectResponse bytes10To15 = metadataAndBytes(1, 10, 5);
    BidiReadObjectResponse firstReply =
        bytes10To15.toBuilder()
            .setObjectDataRanges(
                0, bytes10To15.getObjectDataRanges(0).toBuilder().setRangeEnd(false))
            .build();
    // after the first reply the session knows the object's generation, so a re-open pins it
    BidiReadObjectRequest reopenForBytes15To20 =
        OPEN.toBuilder()
            .setReadObjectSpec(OPEN.getReadObjectSpec().toBuilder().setGeneration(1))
            .addReadRanges(getReadRange(1, 15, 5))
            .build();
    FakeStorage server =
        FakeStorage.of(
            ImmutableMap.of(
                OPEN_WITH_READ_OF_10_TO_20,
                client -> {
                  requestsReceived.add(OPEN_WITH_READ_OF_10_TO_20);
                  client.onNext(firstReply);
                  client.onError(Status.UNAVAILABLE.asRuntimeException());
                },
                reopenForBytes15To20,
                client -> {
                  requestsReceived.add(reopenForBytes15To20);
                  client.onNext(metadataAndBytes(1, 15, 5));
                }));

    try (FakeServer fakeServer = FakeServer.of(server);
        Storage storage = fakeServer.getGrpcStorageOptions().getService()) {
      StorageDataClient dataClient = maybeGetStorageDataClient(storage);

      try (ObjectReadSession session =
          dataClient.readSession(OPEN, CTX, ImmutableList.of(READ_10_TO_20)).get(10, SECONDS)) {
        byte[] actual = session.readAs(READ_10_TO_20).get(10, SECONDS);
        assertThat(xxd(actual)).isEqualTo(xxd(slice(10, 10)));
      }
    }

    assertThat(requestsReceived)
        .containsExactly(OPEN_WITH_READ_OF_10_TO_20, reopenForBytes15To20)
        .inOrder();
  }

  @Test
  public void blobReadSession_withAFastOpenConfig_doesNotSendAnotherRequest() throws Exception {
    FakeStorage server =
        fakeServer(ImmutableMap.of(OPEN_WITH_READ_OF_10_TO_20, metadataAndBytes(1, 10, 10)));

    try (FakeServer fakeServer = FakeServer.of(server);
        Storage storage = fakeServer.getGrpcStorageOptions().getService()) {
      try (BlobReadSession session =
          storage.blobReadSession(BLOB_ID, READ_10_TO_20).get(5, SECONDS)) {
        byte[] actual = session.readAs(READ_10_TO_20).get(2, SECONDS);
        assertThat(xxd(actual)).isEqualTo(xxd(slice(10, 10)));
      }
    }

    assertThat(requestsReceived).containsExactly(OPEN_WITH_READ_OF_10_TO_20);
  }

  @Test
  public void blobReadSession_withTracing_doesNotSendAnotherRequest_andEndsTheSpans()
      throws Exception {
    FakeStorage server =
        fakeServer(ImmutableMap.of(OPEN_WITH_READ_OF_10_TO_20, metadataAndBytes(1, 10, 10)));
    TestExporter exporter = new TestExporter();
    OpenTelemetrySdk otel =
        OpenTelemetrySdk.builder()
            .setTracerProvider(
                SdkTracerProvider.builder()
                    .addSpanProcessor(SimpleSpanProcessor.create(exporter))
                    .build())
            .build();

    try (FakeServer fakeServer = FakeServer.of(server);
        Storage storage =
            fakeServer.getGrpcStorageOptions().toBuilder()
                .setOpenTelemetry(otel)
                .build()
                .getService()) {
      try (BlobReadSession session =
          storage.blobReadSession(BLOB_ID, READ_10_TO_20).get(5, SECONDS)) {
        byte[] actual = session.readAs(READ_10_TO_20).get(2, SECONDS);
        assertThat(xxd(actual)).isEqualTo(xxd(slice(10, 10)));
      }
    }

    assertThat(requestsReceived).containsExactly(OPEN_WITH_READ_OF_10_TO_20);
    List<String> endedSpans =
        exporter.getExportedSpans().stream().map(SpanData::getName).collect(toList());
    assertThat(endedSpans)
        .containsAtLeast(
            "com.google.cloud.storage.Storage/blobReadSession",
            "com.google.cloud.storage.Storage/blobReadSession/readAs");
  }

  @Test
  public void blobReadSession_withTracing_whenTheFastOpenReadFails_recordsTheErrorOnReadAs()
      throws Exception {
    FakeStorage server = rejectsOnlyTheFastOpenRange();
    TestExporter exporter = new TestExporter();
    OpenTelemetrySdk otel =
        OpenTelemetrySdk.builder()
            .setTracerProvider(
                SdkTracerProvider.builder()
                    .addSpanProcessor(SimpleSpanProcessor.create(exporter))
                    .build())
            .build();

    try (FakeServer fakeServer = FakeServer.of(server);
        Storage storage =
            fakeServer.getGrpcStorageOptions().toBuilder()
                .setOpenTelemetry(otel)
                .build()
                .getService()) {
      try (BlobReadSession session =
          storage.blobReadSession(BLOB_ID, READ_10_TO_20).get(10, SECONDS)) {
        ApiFuture<byte[]> read = session.readAs(READ_10_TO_20);
        assertThrows(ExecutionException.class, () -> read.get(5, SECONDS));
      }
    }

    List<StatusCode> readAsStatus =
        exporter.getExportedSpans().stream()
            .filter(
                s -> s.getName().equals("com.google.cloud.storage.Storage/blobReadSession/readAs"))
            .map(s -> s.getStatus().getStatusCode())
            .collect(toList());
    assertThat(readAsStatus).containsExactly(StatusCode.ERROR);
  }

  @Test
  public void blobReadSession_withANullFastOpenConfig_isAPlainOpen() throws Exception {
    FakeStorage server = fakeServer(ImmutableMap.of(OPEN, metadataOnly()));

    try (FakeServer fakeServer = FakeServer.of(server);
        Storage storage = fakeServer.getGrpcStorageOptions().getService()) {
      BlobReadSession session =
          storage.blobReadSession(BLOB_ID, (ReadAsFutureBytes) null).get(5, SECONDS);
      session.close();
    }

    assertThat(requestsReceived).containsExactly(OPEN);
  }

  @Test
  public void blobReadSession_withASeekableChannelConfig_isRejected() throws Exception {
    FakeStorage server = fakeServer(ImmutableMap.of());

    try (FakeServer fakeServer = FakeServer.of(server);
        Storage storage = fakeServer.getGrpcStorageOptions().getService()) {
      IllegalArgumentException e =
          assertThrows(
              IllegalArgumentException.class,
              () -> storage.blobReadSession(BLOB_ID, ReadProjectionConfigs.asSeekableChannel()));
      assertThat(e).hasMessageThat().startsWith("fastOpenConfig must be");
    }

    assertThat(requestsReceived).isEmpty();
  }

  @Test
  public void blobReadSession_whenTheFastOpenReadIsOutOfRange_failsTheOpen() throws Exception {
    FakeStorage server =
        FakeStorage.of(
            ImmutableMap.of(
                OPEN_WITH_READ_OF_10_TO_20,
                client -> {
                  requestsReceived.add(OPEN_WITH_READ_OF_10_TO_20);
                  client.onError(Status.OUT_OF_RANGE.asRuntimeException());
                }));

    try (FakeServer fakeServer = FakeServer.of(server);
        Storage storage = fakeServer.getGrpcStorageOptions().getService()) {
      ApiFuture<BlobReadSession> open = storage.blobReadSession(BLOB_ID, READ_10_TO_20);

      ExecutionException e = assertThrows(ExecutionException.class, () -> open.get(5, SECONDS));
      assertThat(e).hasCauseThat().isInstanceOf(StorageException.class);
      assertThat(((StorageException) e.getCause()).getCode()).isEqualTo(400);
    }

    assertThat(requestsReceived).containsExactly(OPEN_WITH_READ_OF_10_TO_20);
  }

  @Test
  public void blobReadSession_withAFastOpenConfig_stillAppliesBlobSourceOptions() throws Exception {
    BidiReadObjectRequest openWithGenerationMatchAndRead =
        OPEN_WITH_READ_OF_10_TO_20.toBuilder()
            .setReadObjectSpec(OPEN.getReadObjectSpec().toBuilder().setIfGenerationMatch(1))
            .build();
    FakeStorage server =
        fakeServer(ImmutableMap.of(openWithGenerationMatchAndRead, metadataAndBytes(1, 10, 10)));

    try (FakeServer fakeServer = FakeServer.of(server);
        Storage storage = fakeServer.getGrpcStorageOptions().getService()) {
      BlobReadSession session =
          storage
              .blobReadSession(BLOB_ID, READ_10_TO_20, BlobSourceOption.generationMatch(1))
              .get(5, SECONDS);
      session.close();
    }

    assertThat(requestsReceived).containsExactly(openWithGenerationMatchAndRead);
  }

  /**
   * A fake server that answers each request in {@code responses} and adds it to {@link
   * #requestsReceived}. Any other request is answered with an error.
   */
  private FakeStorage fakeServer(Map<BidiReadObjectRequest, BidiReadObjectResponse> responses) {
    ImmutableMap.Builder<BidiReadObjectRequest, Consumer<StreamObserver<BidiReadObjectResponse>>>
        behaviour = ImmutableMap.builder();
    responses.forEach(
        (request, response) ->
            behaviour.put(
                request,
                client -> {
                  requestsReceived.add(request);
                  client.onNext(response);
                }));
    return FakeStorage.of(behaviour.buildOrThrow());
  }

  private static BidiReadObjectResponse metadataOnly() {
    return BidiReadObjectResponse.newBuilder().setMetadata(METADATA).build();
  }

  /**
   * A fake server that fails the open with an OUT_OF_RANGE that names only the fast open read (read
   * id 1), as the server reports a bad range on a bidi read, and accepts the plain re-open.
   */
  private FakeStorage rejectsOnlyTheFastOpenRange() {
    BidiReadObjectError rangeError =
        BidiReadObjectError.newBuilder()
            .addReadRangeErrors(
                ReadRangeError.newBuilder()
                    .setReadId(1)
                    .setStatus(
                        com.google.rpc.Status.newBuilder()
                            .setCode(com.google.rpc.Code.OUT_OF_RANGE_VALUE)))
            .build();
    Metadata trailers = new Metadata();
    trailers.put(
        GRPC_STATUS_DETAILS_KEY,
        com.google.rpc.Status.newBuilder()
            .setCode(com.google.rpc.Code.OUT_OF_RANGE_VALUE)
            .addDetails(Any.pack(rangeError))
            .build());
    return FakeStorage.of(
        ImmutableMap.of(
            OPEN_WITH_READ_OF_10_TO_20,
            client -> {
              requestsReceived.add(OPEN_WITH_READ_OF_10_TO_20);
              client.onError(Status.OUT_OF_RANGE.asRuntimeException(trailers));
            },
            OPEN,
            client -> {
              requestsReceived.add(OPEN);
              client.onNext(metadataOnly());
            }));
  }

  /** The response to an open request that has a read of {@code [offset, offset + length)}. */
  private static BidiReadObjectResponse metadataAndBytes(int readId, int offset, int length) {
    return BidiReadObjectResponse.newBuilder()
        .setMetadata(METADATA)
        .addObjectDataRanges(
            ObjectRangeData.newBuilder()
                .setChecksummedData(
                    ChecksummedTestContent.of(ALL_OBJECT_BYTES, offset, length).asChecksummedData())
                .setReadRange(getReadRange(readId, offset, length))
                .setRangeEnd(true))
        .build();
  }

  /** The response to a read request of {@code [offset, offset + length)}. */
  private static BidiReadObjectResponse bytes(int readId, int offset, int length) {
    return metadataAndBytes(readId, offset, length).toBuilder().clearMetadata().build();
  }

  private static byte[] slice(int offset, int length) {
    return Arrays.copyOfRange(ALL_OBJECT_BYTES, offset, offset + length);
  }

  /** Wraps a config the way tracing does, and records each fast open hit. */
  private static final class WrappedConfig extends ReadProjectionConfig<ApiFuture<byte[]>> {
    private final ReadAsFutureBytes delegate;
    private final List<ApiFuture<byte[]>> claimed = new ArrayList<>();

    private WrappedConfig(ReadAsFutureBytes delegate) {
      this.delegate = delegate;
    }

    @Override
    BaseConfig<ApiFuture<byte[]>, ?> cast() {
      return delegate.cast();
    }

    @Override
    ProjectionType getType() {
      return delegate.getType();
    }

    @Override
    ReadProjectionConfig<ApiFuture<byte[]>> unwrap() {
      return delegate;
    }

    @Override
    void onFastOpenReadClaimed(ApiFuture<byte[]> projection) {
      claimed.add(projection);
    }
  }
}
