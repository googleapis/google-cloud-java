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
import static org.junit.Assert.assertThrows;

import com.google.api.gax.grpc.GrpcStatusCode;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ErrorDetails;
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
import com.google.cloud.bigtable.data.v2.FakeServiceBuilder;
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
import com.google.cloud.bigtable.data.v2.models.TableId;
import com.google.common.base.Stopwatch;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Queues;
import com.google.protobuf.Any;
import com.google.rpc.RetryInfo;
import io.grpc.ForwardingServerCall;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.Server;
import io.grpc.ServerCall;
import io.grpc.ServerCallHandler;
import io.grpc.ServerInterceptor;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;
import java.io.IOException;
import java.time.Duration;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class RetryInfoTest {

  private static final Metadata.Key<byte[]> ERROR_DETAILS_KEY =
      Metadata.Key.of("grpc-status-details-bin", Metadata.BINARY_BYTE_MARSHALLER);

  private final Set<String> methods = new HashSet<>();

  private FakeBigtableService service;
  private Server server;
  private BigtableDataClient client;
  private BigtableDataSettings.Builder settings;

  private AtomicInteger attemptCounter = new AtomicInteger();
  private com.google.protobuf.Duration defaultDelay =
      com.google.protobuf.Duration.newBuilder().setSeconds(2).setNanos(0).build();

  @Before
  public void setUp() throws IOException {
    service = new FakeBigtableService();

    ServerInterceptor serverInterceptor =
        new ServerInterceptor() {
          @Override
          public <ReqT, RespT> ServerCall.Listener<ReqT> interceptCall(
              ServerCall<ReqT, RespT> serverCall,
              Metadata metadata,
              ServerCallHandler<ReqT, RespT> serverCallHandler) {
            return serverCallHandler.startCall(
                new ForwardingServerCall.SimpleForwardingServerCall<ReqT, RespT>(serverCall) {
                  @Override
                  public void close(Status status, Metadata trailers) {
                    if (trailers.containsKey(ERROR_DETAILS_KEY)) {
                      methods.add(serverCall.getMethodDescriptor().getBareMethodName());
                    }
                    super.close(status, trailers);
                  }
                },
                metadata);
          }
        };
    server = FakeServiceBuilder.create(service).intercept(serverInterceptor).start();

    settings =
        BigtableDataSettings.newBuilderForEmulator(server.getPort())
            .setProjectId("fake-project")
            .setInstanceId("fake-instance");

    this.client = BigtableDataClient.create(settings.build());
  }

  @After
  public void tearDown() {
    if (client != null) {
      client.close();
    }
    if (server != null) {
      server.shutdown();
    }
  }

  @Test
  public void testAllMethods() {
    // Verify retry info is handled correctly for all the methods in data API.
    verifyRetryInfoIsUsed(() -> client.readRow(TableId.of("table"), "row"), true);

    attemptCounter.set(0);
    verifyRetryInfoIsUsed(
        () -> client.readRows(Query.create(TableId.of("table"))).iterator().hasNext(), true);

    attemptCounter.set(0);
    verifyRetryInfoIsUsed(
        () ->
            client.bulkMutateRows(
                BulkMutation.create(TableId.of("fake-table"))
                    .add(RowMutationEntry.create("row-key-1").setCell("cf", "q", "v"))),
        true);

    attemptCounter.set(0);
    verifyRetryInfoIsUsed(
        () ->
            client.mutateRow(
                RowMutation.create(TableId.of("fake-table"), "key").setCell("cf", "q", "v")),
        true);

    attemptCounter.set(0);
    verifyRetryInfoIsUsed(() -> client.sampleRowKeys(TableId.of("table")), true);

    attemptCounter.set(0);
    verifyRetryInfoIsUsed(
        () ->
            client.checkAndMutateRow(
                ConditionalRowMutation.create("table", "key")
                    .condition(Filters.FILTERS.value().regex("old-value"))
                    .then(Mutation.create().setCell("cf", "q", "v"))),
        true);

    attemptCounter.set(0);
    verifyRetryInfoIsUsed(
        () ->
            client.readModifyWriteRow(
                ReadModifyWriteRow.create("table", "row").append("cf", "q", "v")),
        true);

    attemptCounter.set(0);
    verifyRetryInfoIsUsed(
        () -> client.readChangeStream(ReadChangeStreamQuery.create("table")).iterator().hasNext(),
        true);

    attemptCounter.set(0);
    verifyRetryInfoIsUsed(
        () -> client.generateInitialChangeStreamPartitions("table").iterator().hasNext(), true);

    // Verify that the new data API methods are tested or excluded. This is enforced by
    // introspecting grpc
    // method descriptors.
    Set<String> expected =
        BigtableGrpc.getServiceDescriptor().getMethods().stream()
            .map(MethodDescriptor::getBareMethodName)
            .collect(Collectors.toSet());

    // Exclude methods that don't support retry info
    methods.add("PingAndWarm");

    assertThat(methods).containsExactlyElementsIn(expected);
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
  public void testReadRowServerNotReturningRetryInfo() {
    verifyNoRetryInfo(() -> client.readRow("table", "row"), true);
  }

  @Test
  public void testReadRowServerNotReturningRetryInfoClientDisabledHandling() throws IOException {
    settings.stubSettings().setEnableRetryInfo(false);

    try (BigtableDataClient newClient = BigtableDataClient.create(settings.build())) {
      verifyNoRetryInfo(() -> newClient.readRow("table", "row"), true);
    }
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
  public void testReadRowsServerNotReturningRetryInfo() {
    verifyNoRetryInfo(() -> client.readRows(Query.create("table")).iterator().hasNext(), true);
  }

  @Test
  public void testReadRowsServerNotReturningRetryInfoClientDisabledHandling() throws IOException {
    settings.stubSettings().setEnableRetryInfo(false);

    try (BigtableDataClient newClient = BigtableDataClient.create(settings.build())) {
      verifyNoRetryInfo(() -> newClient.readRows(Query.create("table")).iterator().hasNext(), true);
    }
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
  public void testMutateRowsServerNotReturningRetryInfo() {
    verifyNoRetryInfo(
        () ->
            client.bulkMutateRows(
                BulkMutation.create("fake-table")
                    .add(RowMutationEntry.create("row-key-1").setCell("cf", "q", "v"))),
        true);
  }

  @Test
  public void testMutateRowsServerNotReturningRetryInfoClientDisabledHandling() throws IOException {
    settings.stubSettings().setEnableRetryInfo(false);

    try (BigtableDataClient newClient = BigtableDataClient.create(settings.build())) {
      verifyNoRetryInfo(
          () ->
              newClient.bulkMutateRows(
                  BulkMutation.create("fake-table")
                      .add(RowMutationEntry.create("row-key-1").setCell("cf", "q", "v"))),
          true);
    }
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
  public void testMutateRowServerNotReturningRetryInfo() {
    verifyNoRetryInfo(
        () -> client.mutateRow(RowMutation.create("table", "key").setCell("cf", "q", "v")), true);
  }

  @Test
  public void testMutateRowServerNotReturningRetryInfoClientDisabledHandling() throws IOException {
    settings.stubSettings().setEnableRetryInfo(false);

    try (BigtableDataClient newClient = BigtableDataClient.create(settings.build())) {
      verifyNoRetryInfo(
          () -> newClient.mutateRow(RowMutation.create("table", "key").setCell("cf", "q", "v")),
          true);
    }
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
  public void testSampleRowKeysServerNotReturningRetryInfo() {
    verifyNoRetryInfo(() -> client.sampleRowKeys("table"), true);
  }

  @Test
  public void testSampleRowKeysServerNotReturningRetryInfoClientDisabledHandling()
      throws IOException {
    settings.stubSettings().setEnableRetryInfo(false);

    try (BigtableDataClient newClient = BigtableDataClient.create(settings.build())) {
      verifyNoRetryInfo(() -> newClient.sampleRowKeys("table"), true);
    }
  }

  @Test
  public void testCheckAndMutateDisableRetryInfo() throws IOException {
    settings.stubSettings().setEnableRetryInfo(false);

    try (BigtableDataClient client = BigtableDataClient.create(settings.build())) {
      ApiException exception = enqueueNonRetryableExceptionWithDelay(defaultDelay);
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
  public void testCheckAndMutateServerNotReturningRetryInfo() {
    verifyNoRetryInfo(
        () ->
            client.checkAndMutateRow(
                ConditionalRowMutation.create("table", "key")
                    .condition(Filters.FILTERS.value().regex("old-value"))
                    .then(Mutation.create().setCell("cf", "q", "v"))),
        false);
  }

  @Test
  public void testCheckAndMutateServerNotReturningRetryInfoClientDisabledHandling()
      throws IOException {
    settings.stubSettings().setEnableRetryInfo(false);

    try (BigtableDataClient newClient = BigtableDataClient.create(settings.build())) {
      verifyNoRetryInfo(
          () ->
              newClient.checkAndMutateRow(
                  ConditionalRowMutation.create("table", "key")
                      .condition(Filters.FILTERS.value().regex("old-value"))
                      .then(Mutation.create().setCell("cf", "q", "v"))),
          false);
    }
  }

  @Test
  public void testReadModifyWriteDisableRetryInfo() throws IOException {
    settings.stubSettings().setEnableRetryInfo(false);

    try (BigtableDataClient client = BigtableDataClient.create(settings.build())) {
      ApiException exception = enqueueNonRetryableExceptionWithDelay(defaultDelay);
      try {
        client.readModifyWriteRow(ReadModifyWriteRow.create("table", "row").append("cf", "q", "v"));
      } catch (ApiException e) {
        assertThat(e.getStatusCode()).isEqualTo(exception.getStatusCode());
      }
      assertThat(attemptCounter.get()).isEqualTo(1);
    }
  }

  @Test
  public void testReadModifyWriteServerNotReturningRetryInfo() {
    verifyNoRetryInfo(
        () ->
            client.readModifyWriteRow(
                ReadModifyWriteRow.create("table", "row").append("cf", "q", "v")),
        false);
  }

  @Test
  public void testReadModifyWriteNotReturningRetryInfoClientDisabledHandling() throws IOException {
    settings.stubSettings().setEnableRetryInfo(false);

    try (BigtableDataClient newClient = BigtableDataClient.create(settings.build())) {
      verifyNoRetryInfo(
          () ->
              newClient.readModifyWriteRow(
                  ReadModifyWriteRow.create("table", "row").append("cf", "q", "v")),
          false);
    }
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
  public void testReadChangeStreamServerNotReturningRetryInfo() {
    verifyNoRetryInfo(
        () -> client.readChangeStream(ReadChangeStreamQuery.create("table")).iterator().hasNext(),
        true);
  }

  @Test
  public void testReadChangeStreamNotReturningRetryInfoClientDisabledHandling() throws IOException {
    settings.stubSettings().setEnableRetryInfo(false);

    try (BigtableDataClient newClient = BigtableDataClient.create(settings.build())) {
      verifyNoRetryInfo(
          () ->
              newClient
                  .readChangeStream(ReadChangeStreamQuery.create("table"))
                  .iterator()
                  .hasNext(),
          true,
          com.google.protobuf.Duration.newBuilder().setSeconds(5).setNanos(0).build());
    }
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

  @Test
  public void testGenerateInitialChangeStreamServerNotReturningRetryInfo() {
    verifyNoRetryInfo(
        () -> client.generateInitialChangeStreamPartitions("table").iterator().hasNext(), true);
  }

  @Test
  public void testGenerateInitialChangeStreamServerNotReturningRetryInfoClientDisabledHandling()
      throws IOException {
    settings.stubSettings().setEnableRetryInfo(false);

    try (BigtableDataClient newClient = BigtableDataClient.create(settings.build())) {
      verifyNoRetryInfo(
          () -> newClient.generateInitialChangeStreamPartitions("table").iterator().hasNext(),
          true);
    }
  }

  // Test the case where server returns retry info and client enables handling of retry info
  private void verifyRetryInfoIsUsed(Runnable runnable, boolean retryableError) {
    if (retryableError) {
      enqueueRetryableExceptionWithDelay(defaultDelay);
    } else {
      enqueueNonRetryableExceptionWithDelay(defaultDelay);
    }
    Stopwatch stopwatch = Stopwatch.createStarted();
    runnable.run();
    stopwatch.stop();

    assertThat(attemptCounter.get()).isEqualTo(2);
    assertThat(stopwatch.elapsed()).isAtLeast(Duration.ofSeconds(defaultDelay.getSeconds()));
  }

  // Test the case where server returns retry info but client disabled handling of retry info
  private void verifyRetryInfoCanBeDisabled(Runnable runnable) {
    enqueueRetryableExceptionWithDelay(defaultDelay);
    Stopwatch stopwatch = Stopwatch.createStarted();
    runnable.run();
    stopwatch.stop();

    assertThat(attemptCounter.get()).isEqualTo(2);
    assertThat(stopwatch.elapsed()).isLessThan(Duration.ofSeconds(defaultDelay.getSeconds()));

    attemptCounter.set(0);
    ApiException expectedApiException = enqueueNonRetryableExceptionWithDelay(defaultDelay);
    ApiException actualException =
        assertThrows("non retryable operations should fail", ApiException.class, runnable::run);
    if (actualException instanceof MutateRowsException) {
      assertThat(
              ((MutateRowsException) actualException)
                  .getFailedMutations()
                  .get(0)
                  .getError()
                  .getStatusCode())
          .isEqualTo(expectedApiException.getStatusCode());
    } else {
      assertThat(actualException.getStatusCode()).isEqualTo(expectedApiException.getStatusCode());
    }
    assertThat(attemptCounter.get()).isEqualTo(1);
  }

  // Test the case where server does not return retry info
  private void verifyNoRetryInfo(Runnable runnable, boolean operationRetryable) {
    verifyNoRetryInfo(runnable, operationRetryable, defaultDelay);
  }

  // individual test can override the default delay
  private void verifyNoRetryInfo(
      Runnable runnable, boolean operationRetryable, com.google.protobuf.Duration delay) {
    enqueueRetryableExceptionNoRetryInfo();

    if (!operationRetryable) {
      assertThrows("non retryable operation should fail", ApiException.class, runnable::run);
      assertThat(attemptCounter.get()).isEqualTo(1);
    } else {
      Stopwatch stopwatch = Stopwatch.createStarted();
      runnable.run();
      stopwatch.stop();

      assertThat(attemptCounter.get()).isEqualTo(2);
      assertThat(stopwatch.elapsed()).isLessThan(Duration.ofSeconds(delay.getSeconds()));
    }

    attemptCounter.set(0);

    ApiException expectedApiException = enqueueNonRetryableExceptionNoRetryInfo();

    ApiException actualApiException =
        assertThrows("non retryable error should fail", ApiException.class, runnable::run);
    if (actualApiException instanceof MutateRowsException) {
      assertThat(
              ((MutateRowsException) actualApiException)
                  .getFailedMutations()
                  .get(0)
                  .getError()
                  .getStatusCode())
          .isEqualTo(expectedApiException.getStatusCode());
    } else {
      assertThat(actualApiException.getStatusCode())
          .isEqualTo(expectedApiException.getStatusCode());
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

  private void enqueueRetryableExceptionNoRetryInfo() {
    ApiException exception =
        new UnavailableException(
            new StatusRuntimeException(Status.UNAVAILABLE),
            GrpcStatusCode.of(Status.Code.UNAVAILABLE),
            true);
    service.expectations.add(exception);
  }

  private ApiException enqueueNonRetryableExceptionNoRetryInfo() {
    ApiException exception =
        new InternalException(
            new StatusRuntimeException(Status.INTERNAL),
            GrpcStatusCode.of(Status.Code.INTERNAL),
            false);

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
