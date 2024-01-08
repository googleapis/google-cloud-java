/*
 * Copyright 2023 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.bigtable.data.v2.stub;

import static com.google.common.truth.Truth.assertThat;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GrpcStatusCode;
import com.google.api.gax.grpc.GrpcTransportChannel;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ErrorDetails;
import com.google.api.gax.rpc.FixedTransportChannelProvider;
import com.google.api.gax.rpc.InternalException;
import com.google.api.gax.rpc.UnavailableException;
import com.google.bigtable.v2.BigtableGrpc;
import com.google.bigtable.v2.CheckAndMutateRowRequest;
import com.google.bigtable.v2.CheckAndMutateRowResponse;
import com.google.bigtable.v2.GenerateInitialChangeStreamPartitionsRequest;
import com.google.bigtable.v2.GenerateInitialChangeStreamPartitionsResponse;
import com.google.bigtable.v2.MutateRowRequest;
import com.google.bigtable.v2.MutateRowResponse;
import com.google.bigtable.v2.MutateRowsRequest;
import com.google.bigtable.v2.MutateRowsResponse;
import com.google.bigtable.v2.ReadChangeStreamRequest;
import com.google.bigtable.v2.ReadChangeStreamResponse;
import com.google.bigtable.v2.ReadModifyWriteRowRequest;
import com.google.bigtable.v2.ReadModifyWriteRowResponse;
import com.google.bigtable.v2.ReadRowsRequest;
import com.google.bigtable.v2.ReadRowsResponse;
import com.google.bigtable.v2.SampleRowKeysRequest;
import com.google.bigtable.v2.SampleRowKeysResponse;
import com.google.cloud.bigtable.data.v2.BigtableDataClient;
import com.google.cloud.bigtable.data.v2.BigtableDataSettings;
import com.google.cloud.bigtable.data.v2.models.BulkMutation;
import com.google.cloud.bigtable.data.v2.models.ConditionalRowMutation;
import com.google.cloud.bigtable.data.v2.models.Filters;
import com.google.cloud.bigtable.data.v2.models.MutateRowsException;
import com.google.cloud.bigtable.data.v2.models.Mutation;
import com.google.cloud.bigtable.data.v2.models.Query;
import com.google.cloud.bigtable.data.v2.models.ReadChangeStreamQuery;
import com.google.cloud.bigtable.data.v2.models.ReadModifyWriteRow;
import com.google.cloud.bigtable.data.v2.models.RowMutation;
import com.google.cloud.bigtable.data.v2.models.RowMutationEntry;
import com.google.common.base.Stopwatch;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Queues;
import com.google.protobuf.Any;
import com.google.rpc.RetryInfo;
import io.grpc.Metadata;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;
import io.grpc.testing.GrpcServerRule;
import java.io.IOException;
import java.time.Duration;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class RetryInfoTest {

  @Rule public GrpcServerRule serverRule = new GrpcServerRule();

  private static final Metadata.Key<byte[]> ERROR_DETAILS_KEY =
      Metadata.Key.of("grpc-status-details-bin", Metadata.BINARY_BYTE_MARSHALLER);

  private FakeBigtableService service;
  private BigtableDataClient client;
  private BigtableDataSettings.Builder settings;

  private AtomicInteger attemptCounter = new AtomicInteger();
  private com.google.protobuf.Duration delay =
      com.google.protobuf.Duration.newBuilder().setSeconds(2).setNanos(0).build();

  @Before
  public void setUp() throws IOException {
    service = new FakeBigtableService();
    serverRule.getServiceRegistry().addService(service);

    settings =
        BigtableDataSettings.newBuilder()
            .setProjectId("fake-project")
            .setInstanceId("fake-instance")
            .setCredentialsProvider(NoCredentialsProvider.create());

    settings
        .stubSettings()
        .setTransportChannelProvider(
            FixedTransportChannelProvider.create(
                GrpcTransportChannel.create(serverRule.getChannel())))
        // channel priming doesn't work with FixedTransportChannelProvider. Disable it for the test
        .setRefreshingChannel(false)
        .build();

    this.client = BigtableDataClient.create(settings.build());
  }

  @Test
  public void testReadRow() {
    verifyRetryInfoIsUsed(() -> client.readRow("table", "row"), true);
  }

  @Test
  public void testReadRowNonRetryableErrorWithRetryInfo() {
    verifyRetryInfoIsUsed(() -> client.readRow("table", "row"), false);
  }

  @Test
  public void testReadRowDisableRetryInfo() throws IOException {
    settings.stubSettings().setEnableRetryInfo(false);

    try (BigtableDataClient newClient = BigtableDataClient.create(settings.build())) {
      verifyRetryInfoCanBeDisabled(() -> newClient.readRow("table", "row"));
    }
  }

  @Test
  public void testReadRows() {
    verifyRetryInfoIsUsed(() -> client.readRows(Query.create("table")).iterator().hasNext(), true);
  }

  @Test
  public void testReadRowsNonRetraybleErrorWithRetryInfo() {
    verifyRetryInfoIsUsed(() -> client.readRows(Query.create("table")).iterator().hasNext(), false);
  }

  @Test
  public void testReadRowsDisableRetryInfo() throws IOException {
    settings.stubSettings().setEnableRetryInfo(false);

    try (BigtableDataClient newClient = BigtableDataClient.create(settings.build())) {
      verifyRetryInfoCanBeDisabled(
          () -> newClient.readRows(Query.create("table")).iterator().hasNext());
    }
  }

  @Test
  public void testMutateRows() {
    verifyRetryInfoIsUsed(
        () ->
            client.bulkMutateRows(
                BulkMutation.create("fake-table")
                    .add(RowMutationEntry.create("row-key-1").setCell("cf", "q", "v"))),
        true);
  }

  @Test
  public void testMutateRowsNonRetryableErrorWithRetryInfo() {
    verifyRetryInfoIsUsed(
        () ->
            client.bulkMutateRows(
                BulkMutation.create("fake-table")
                    .add(RowMutationEntry.create("row-key-1").setCell("cf", "q", "v"))),
        false);
  }

  @Test
  public void testMutateRowsDisableRetryInfo() throws IOException {
    settings.stubSettings().setEnableRetryInfo(false);

    try (BigtableDataClient newClient = BigtableDataClient.create(settings.build())) {
      verifyRetryInfoCanBeDisabled(
          () ->
              newClient.bulkMutateRows(
                  BulkMutation.create("fake-table")
                      .add(RowMutationEntry.create("row-key-1").setCell("cf", "q", "v"))));
    }
  }

  @Test
  public void testMutateRow() {
    verifyRetryInfoIsUsed(
        () -> client.mutateRow(RowMutation.create("table", "key").setCell("cf", "q", "v")), true);
  }

  @Test
  public void testMutateRowNonRetryableErrorWithRetryInfo() {
    verifyRetryInfoIsUsed(
        () -> client.mutateRow(RowMutation.create("table", "key").setCell("cf", "q", "v")), false);
  }

  @Test
  public void testMutateRowDisableRetryInfo() throws IOException {
    settings.stubSettings().setEnableRetryInfo(false);

    try (BigtableDataClient newClient = BigtableDataClient.create(settings.build())) {

      verifyRetryInfoCanBeDisabled(
          () -> newClient.mutateRow(RowMutation.create("table", "key").setCell("cf", "q", "v")));
    }
  }

  @Test
  public void testSampleRowKeys() {
    verifyRetryInfoIsUsed(() -> client.sampleRowKeys("table"), true);
  }

  @Test
  public void testSampleRowKeysNonRetryableErrorWithRetryInfo() {
    verifyRetryInfoIsUsed(() -> client.sampleRowKeys("table"), false);
  }

  @Test
  public void testSampleRowKeysDisableRetryInfo() throws IOException {
    settings.stubSettings().setEnableRetryInfo(false);

    try (BigtableDataClient newClient = BigtableDataClient.create(settings.build())) {
      verifyRetryInfoCanBeDisabled(() -> newClient.sampleRowKeys("table"));
    }
  }

  @Test
  public void testCheckAndMutateRow() {
    verifyRetryInfoIsUsed(
        () ->
            client.checkAndMutateRow(
                ConditionalRowMutation.create("table", "key")
                    .condition(Filters.FILTERS.value().regex("old-value"))
                    .then(Mutation.create().setCell("cf", "q", "v"))),
        true);
  }

  @Test
  public void testCheckAndMutateDisableRetryInfo() throws IOException {
    settings.stubSettings().setEnableRetryInfo(false);

    try (BigtableDataClient client = BigtableDataClient.create(settings.build())) {
      ApiException exception = enqueueNonRetryableExceptionWithDelay(delay);
      try {
        client.checkAndMutateRow(
            ConditionalRowMutation.create("table", "key")
                .condition(Filters.FILTERS.value().regex("old-value"))
                .then(Mutation.create().setCell("cf", "q", "v")));
      } catch (ApiException e) {
        assertThat(e.getStatusCode()).isEqualTo(exception.getStatusCode());
      }
      assertThat(attemptCounter.get()).isEqualTo(1);
    }
  }

  @Test
  public void testReadModifyWrite() {
    verifyRetryInfoIsUsed(
        () ->
            client.readModifyWriteRow(
                ReadModifyWriteRow.create("table", "row").append("cf", "q", "v")),
        true);
  }

  @Test
  public void testReadModifyWriteDisableRetryInfo() throws IOException {
    settings.stubSettings().setEnableRetryInfo(false);

    try (BigtableDataClient client = BigtableDataClient.create(settings.build())) {
      ApiException exception = enqueueNonRetryableExceptionWithDelay(delay);
      try {
        client.readModifyWriteRow(ReadModifyWriteRow.create("table", "row").append("cf", "q", "v"));
      } catch (ApiException e) {
        assertThat(e.getStatusCode()).isEqualTo(exception.getStatusCode());
      }
      assertThat(attemptCounter.get()).isEqualTo(1);
    }
  }

  @Test
  public void testReadChangeStream() {
    verifyRetryInfoIsUsed(
        () -> client.readChangeStream(ReadChangeStreamQuery.create("table")).iterator().hasNext(),
        true);
  }

  @Test
  public void testReadChangeStreamNonRetryableErrorWithRetryInfo() {
    verifyRetryInfoIsUsed(
        () -> client.readChangeStream(ReadChangeStreamQuery.create("table")).iterator().hasNext(),
        false);
  }

  @Test
  public void testReadChangeStreamDisableRetryInfo() throws IOException {
    settings.stubSettings().setEnableRetryInfo(false);

    try (BigtableDataClient newClient = BigtableDataClient.create(settings.build())) {
      verifyRetryInfoCanBeDisabled(
          () ->
              newClient
                  .readChangeStream(ReadChangeStreamQuery.create("table"))
                  .iterator()
                  .hasNext());
    }
  }

  @Test
  public void testGenerateInitialChangeStreamPartition() {
    verifyRetryInfoIsUsed(
        () -> client.generateInitialChangeStreamPartitions("table").iterator().hasNext(), true);
  }

  @Test
  public void testGenerateInitialChangeStreamPartitionNonRetryableError() {
    verifyRetryInfoIsUsed(
        () -> client.generateInitialChangeStreamPartitions("table").iterator().hasNext(), false);
  }

  @Test
  public void testGenerateInitialChangeStreamPartitionDisableRetryInfo() throws IOException {
    settings.stubSettings().setEnableRetryInfo(false);

    try (BigtableDataClient newClient = BigtableDataClient.create(settings.build())) {
      verifyRetryInfoCanBeDisabled(
          () -> newClient.generateInitialChangeStreamPartitions("table").iterator().hasNext());
    }
  }

  private void verifyRetryInfoIsUsed(Runnable runnable, boolean retryableError) {
    if (retryableError) {
      enqueueRetryableExceptionWithDelay(delay);
    } else {
      enqueueNonRetryableExceptionWithDelay(delay);
    }
    Stopwatch stopwatch = Stopwatch.createStarted();
    runnable.run();
    stopwatch.stop();

    assertThat(attemptCounter.get()).isEqualTo(2);
    assertThat(stopwatch.elapsed()).isAtLeast(Duration.ofSeconds(delay.getSeconds()));
  }

  private void verifyRetryInfoCanBeDisabled(Runnable runnable) {
    enqueueRetryableExceptionWithDelay(delay);
    Stopwatch stopwatch = Stopwatch.createStarted();
    runnable.run();
    stopwatch.stop();

    assertThat(attemptCounter.get()).isEqualTo(2);
    assertThat(stopwatch.elapsed()).isLessThan(Duration.ofSeconds(delay.getSeconds()));

    attemptCounter.set(0);
    ApiException exception = enqueueNonRetryableExceptionWithDelay(delay);
    try {
      runnable.run();
    } catch (ApiException e) {
      if (e instanceof MutateRowsException) {
        assertThat(((MutateRowsException) e).getFailedMutations().get(0).getError().getStatusCode())
            .isEqualTo(exception.getStatusCode());
      } else {
        assertThat(e.getStatusCode()).isEqualTo(exception.getStatusCode());
      }
    }
    assertThat(attemptCounter.get()).isEqualTo(1);
  }

  private void enqueueRetryableExceptionWithDelay(com.google.protobuf.Duration delay) {
    Metadata trailers = new Metadata();
    RetryInfo retryInfo = RetryInfo.newBuilder().setRetryDelay(delay).build();
    ErrorDetails errorDetails =
        ErrorDetails.builder().setRawErrorMessages(ImmutableList.of(Any.pack(retryInfo))).build();
    byte[] status =
        com.google.rpc.Status.newBuilder().addDetails(Any.pack(retryInfo)).build().toByteArray();
    trailers.put(ERROR_DETAILS_KEY, status);

    ApiException exception =
        new UnavailableException(
            new StatusRuntimeException(Status.UNAVAILABLE, trailers),
            GrpcStatusCode.of(Status.Code.UNAVAILABLE),
            true,
            errorDetails);

    service.expectations.add(exception);
  }

  private ApiException enqueueNonRetryableExceptionWithDelay(com.google.protobuf.Duration delay) {
    Metadata trailers = new Metadata();
    RetryInfo retryInfo = RetryInfo.newBuilder().setRetryDelay(delay).build();
    ErrorDetails errorDetails =
        ErrorDetails.builder().setRawErrorMessages(ImmutableList.of(Any.pack(retryInfo))).build();
    byte[] status =
        com.google.rpc.Status.newBuilder().addDetails(Any.pack(retryInfo)).build().toByteArray();
    trailers.put(ERROR_DETAILS_KEY, status);

    ApiException exception =
        new InternalException(
            new StatusRuntimeException(Status.INTERNAL, trailers),
            GrpcStatusCode.of(Status.Code.INTERNAL),
            false,
            errorDetails);

    service.expectations.add(exception);

    return exception;
  }

  private class FakeBigtableService extends BigtableGrpc.BigtableImplBase {
    Queue<Exception> expectations = Queues.newArrayDeque();

    @Override
    public void readRows(
        ReadRowsRequest request, StreamObserver<ReadRowsResponse> responseObserver) {
      attemptCounter.incrementAndGet();
      if (expectations.isEmpty()) {
        responseObserver.onNext(ReadRowsResponse.getDefaultInstance());
        responseObserver.onCompleted();
      } else {
        Exception expectedRpc = expectations.poll();
        responseObserver.onError(expectedRpc);
      }
    }

    @Override
    public void mutateRow(
        MutateRowRequest request, StreamObserver<MutateRowResponse> responseObserver) {
      attemptCounter.incrementAndGet();
      if (expectations.isEmpty()) {
        responseObserver.onNext(MutateRowResponse.getDefaultInstance());
        responseObserver.onCompleted();
      } else {
        Exception expectedRpc = expectations.poll();
        responseObserver.onError(expectedRpc);
      }
    }

    @Override
    public void mutateRows(
        MutateRowsRequest request, StreamObserver<MutateRowsResponse> responseObserver) {
      attemptCounter.incrementAndGet();
      if (expectations.isEmpty()) {
        MutateRowsResponse.Builder builder = MutateRowsResponse.newBuilder();
        for (int i = 0; i < request.getEntriesCount(); i++) {
          builder.addEntriesBuilder().setIndex(i);
        }
        responseObserver.onNext(builder.build());
        responseObserver.onCompleted();
      } else {
        Exception expectedRpc = expectations.poll();
        responseObserver.onError(expectedRpc);
      }
    }

    @Override
    public void sampleRowKeys(
        SampleRowKeysRequest request, StreamObserver<SampleRowKeysResponse> responseObserver) {
      attemptCounter.incrementAndGet();
      if (expectations.isEmpty()) {
        responseObserver.onNext(SampleRowKeysResponse.getDefaultInstance());
        responseObserver.onCompleted();
      } else {
        Exception expectedRpc = expectations.poll();
        responseObserver.onError(expectedRpc);
      }
    }

    @Override
    public void checkAndMutateRow(
        CheckAndMutateRowRequest request,
        StreamObserver<CheckAndMutateRowResponse> responseObserver) {
      attemptCounter.incrementAndGet();
      if (expectations.isEmpty()) {
        responseObserver.onNext(CheckAndMutateRowResponse.getDefaultInstance());
        responseObserver.onCompleted();
      } else {
        Exception expectedRpc = expectations.poll();
        responseObserver.onError(expectedRpc);
      }
    }

    @Override
    public void readModifyWriteRow(
        ReadModifyWriteRowRequest request,
        StreamObserver<ReadModifyWriteRowResponse> responseObserver) {
      attemptCounter.incrementAndGet();
      if (expectations.isEmpty()) {
        responseObserver.onNext(ReadModifyWriteRowResponse.getDefaultInstance());
        responseObserver.onCompleted();
      } else {
        Exception expectedRpc = expectations.poll();
        responseObserver.onError(expectedRpc);
      }
    }

    @Override
    public void generateInitialChangeStreamPartitions(
        GenerateInitialChangeStreamPartitionsRequest request,
        StreamObserver<GenerateInitialChangeStreamPartitionsResponse> responseObserver) {
      attemptCounter.incrementAndGet();
      if (expectations.isEmpty()) {
        responseObserver.onNext(GenerateInitialChangeStreamPartitionsResponse.getDefaultInstance());
        responseObserver.onCompleted();
      } else {
        Exception expectedRpc = expectations.poll();
        responseObserver.onError(expectedRpc);
      }
    }

    @Override
    public void readChangeStream(
        ReadChangeStreamRequest request,
        StreamObserver<ReadChangeStreamResponse> responseObserver) {
      attemptCounter.incrementAndGet();
      if (expectations.isEmpty()) {
        responseObserver.onNext(
            ReadChangeStreamResponse.newBuilder()
                .setCloseStream(ReadChangeStreamResponse.CloseStream.getDefaultInstance())
                .build());
        responseObserver.onCompleted();
      } else {
        Exception expectedRpc = expectations.poll();
        responseObserver.onError(expectedRpc);
      }
    }
  }
}
