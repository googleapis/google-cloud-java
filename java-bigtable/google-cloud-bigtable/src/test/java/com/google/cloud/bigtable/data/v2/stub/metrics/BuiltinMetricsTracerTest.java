/*
 * Copyright 2022 Google LLC
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
package com.google.cloud.bigtable.data.v2.stub.metrics;

import static com.google.api.gax.tracing.ApiTracerFactory.OperationType;
import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.timeout;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.google.api.client.util.Lists;
import com.google.api.core.ApiFunction;
import com.google.api.core.SettableApiFuture;
import com.google.api.gax.batching.Batcher;
import com.google.api.gax.batching.BatchingException;
import com.google.api.gax.batching.BatchingSettings;
import com.google.api.gax.batching.FlowControlSettings;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.NotFoundException;
import com.google.api.gax.rpc.ResponseObserver;
import com.google.api.gax.rpc.StreamController;
import com.google.api.gax.tracing.SpanName;
import com.google.bigtable.v2.BigtableGrpc;
import com.google.bigtable.v2.MutateRowRequest;
import com.google.bigtable.v2.MutateRowResponse;
import com.google.bigtable.v2.MutateRowsRequest;
import com.google.bigtable.v2.MutateRowsResponse;
import com.google.bigtable.v2.ReadRowsRequest;
import com.google.bigtable.v2.ReadRowsResponse;
import com.google.bigtable.v2.ResponseParams;
import com.google.cloud.bigtable.data.v2.BigtableDataSettings;
import com.google.cloud.bigtable.data.v2.FakeServiceBuilder;
import com.google.cloud.bigtable.data.v2.models.Query;
import com.google.cloud.bigtable.data.v2.models.Row;
import com.google.cloud.bigtable.data.v2.models.RowMutation;
import com.google.cloud.bigtable.data.v2.models.RowMutationEntry;
import com.google.cloud.bigtable.data.v2.stub.EnhancedBigtableStub;
import com.google.cloud.bigtable.data.v2.stub.EnhancedBigtableStubSettings;
import com.google.cloud.bigtable.stats.StatsRecorderWrapper;
import com.google.common.base.Stopwatch;
import com.google.common.collect.Range;
import com.google.protobuf.ByteString;
import com.google.protobuf.BytesValue;
import com.google.protobuf.StringValue;
import io.grpc.CallOptions;
import io.grpc.Channel;
import io.grpc.ClientCall;
import io.grpc.ClientInterceptor;
import io.grpc.ForwardingClientCall;
import io.grpc.ForwardingServerCall;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.Server;
import io.grpc.ServerCall;
import io.grpc.ServerCallHandler;
import io.grpc.ServerInterceptor;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.ServerCallStreamObserver;
import io.grpc.stub.StreamObserver;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.mockito.stubbing.Answer;
import org.threeten.bp.Duration;

@RunWith(JUnit4.class)
public class BuiltinMetricsTracerTest {
  private static final String PROJECT_ID = "fake-project";
  private static final String INSTANCE_ID = "fake-instance";
  private static final String APP_PROFILE_ID = "default";
  private static final String TABLE_ID = "fake-table";

  private static final String BAD_TABLE_ID = "non-exist-table";
  private static final String ZONE = "us-west-1";
  private static final String CLUSTER = "cluster-0";
  private static final long FAKE_SERVER_TIMING = 50;
  private static final long SERVER_LATENCY = 100;
  private static final long APPLICATION_LATENCY = 200;
  private static final long SLEEP_VARIABILITY = 15;

  private static final long CHANNEL_BLOCKING_LATENCY = 75;

  @Rule public final MockitoRule mockitoRule = MockitoJUnit.rule();

  private final FakeService fakeService = new FakeService();
  private Server server;

  private EnhancedBigtableStub stub;

  @Mock private BuiltinMetricsTracerFactory mockFactory;
  @Mock private StatsRecorderWrapper statsRecorderWrapper;

  @Captor private ArgumentCaptor<String> status;
  @Captor private ArgumentCaptor<String> tableId;
  @Captor private ArgumentCaptor<String> zone;
  @Captor private ArgumentCaptor<String> cluster;

  private int batchElementCount = 2;

  @Before
  public void setUp() throws Exception {
    // Add an interceptor to add server-timing in headers
    ServerInterceptor trailersInterceptor =
        new ServerInterceptor() {
          @Override
          public <ReqT, RespT> ServerCall.Listener<ReqT> interceptCall(
              ServerCall<ReqT, RespT> serverCall,
              Metadata metadata,
              ServerCallHandler<ReqT, RespT> serverCallHandler) {
            return serverCallHandler.startCall(
                new ForwardingServerCall.SimpleForwardingServerCall<ReqT, RespT>(serverCall) {
                  @Override
                  public void sendHeaders(Metadata headers) {
                    headers.put(
                        Metadata.Key.of("server-timing", Metadata.ASCII_STRING_MARSHALLER),
                        String.format("gfet4t7; dur=%d", FAKE_SERVER_TIMING));

                    ResponseParams params =
                        ResponseParams.newBuilder().setZoneId(ZONE).setClusterId(CLUSTER).build();
                    byte[] byteArray = params.toByteArray();
                    headers.put(Util.LOCATION_METADATA_KEY, byteArray);

                    super.sendHeaders(headers);
                  }
                },
                metadata);
          }
        };

    ClientInterceptor clientInterceptor =
        new ClientInterceptor() {
          @Override
          public <ReqT, RespT> ClientCall<ReqT, RespT> interceptCall(
              MethodDescriptor<ReqT, RespT> methodDescriptor,
              CallOptions callOptions,
              Channel channel) {
            return new ForwardingClientCall.SimpleForwardingClientCall<ReqT, RespT>(
                channel.newCall(methodDescriptor, callOptions)) {
              @Override
              public void sendMessage(ReqT message) {
                try {
                  Thread.sleep(CHANNEL_BLOCKING_LATENCY);
                } catch (InterruptedException e) {
                  throw new RuntimeException(e);
                }
                super.sendMessage(message);
              }
            };
          }
        };

    server = FakeServiceBuilder.create(fakeService).intercept(trailersInterceptor).start();

    BigtableDataSettings settings =
        BigtableDataSettings.newBuilderForEmulator(server.getPort())
            .setProjectId(PROJECT_ID)
            .setInstanceId(INSTANCE_ID)
            .setAppProfileId(APP_PROFILE_ID)
            .build();
    EnhancedBigtableStubSettings.Builder stubSettingsBuilder =
        settings.getStubSettings().toBuilder();
    stubSettingsBuilder
        .mutateRowSettings()
        .retrySettings()
        .setInitialRetryDelay(Duration.ofMillis(200));

    stubSettingsBuilder
        .bulkMutateRowsSettings()
        .setBatchingSettings(
            // Each batch has 2 mutations, batch has 1 in-flight request, disable auto flush by
            // setting the delay to 1 hour.
            BatchingSettings.newBuilder()
                .setElementCountThreshold((long) batchElementCount)
                .setRequestByteThreshold(1000L)
                .setDelayThreshold(Duration.ofHours(1))
                .setFlowControlSettings(
                    FlowControlSettings.newBuilder()
                        .setMaxOutstandingElementCount((long) batchElementCount + 1)
                        .setMaxOutstandingRequestBytes(1001L)
                        .build())
                .build());
    stubSettingsBuilder.setTracerFactory(mockFactory);

    InstantiatingGrpcChannelProvider.Builder channelProvider =
        ((InstantiatingGrpcChannelProvider) stubSettingsBuilder.getTransportChannelProvider())
            .toBuilder();

    @SuppressWarnings("rawtypes")
    final ApiFunction<ManagedChannelBuilder, ManagedChannelBuilder> oldConfigurator =
        channelProvider.getChannelConfigurator();

    channelProvider.setChannelConfigurator(
        (builder) -> {
          if (oldConfigurator != null) {
            builder = oldConfigurator.apply(builder);
          }
          return builder.intercept(clientInterceptor);
        });
    stubSettingsBuilder.setTransportChannelProvider(channelProvider.build());

    EnhancedBigtableStubSettings stubSettings = stubSettingsBuilder.build();
    stub = new EnhancedBigtableStub(stubSettings, ClientContext.create(stubSettings));
  }

  @After
  public void tearDown() {
    stub.close();
    server.shutdown();
  }

  @Test
  public void testReadRowsOperationLatencies() {
    when(mockFactory.newTracer(any(), any(), any()))
        .thenAnswer(
            (Answer<BuiltinMetricsTracer>)
                invocationOnMock ->
                    new BuiltinMetricsTracer(
                        OperationType.ServerStreaming,
                        SpanName.of("Bigtable", "ReadRows"),
                        statsRecorderWrapper));
    ArgumentCaptor<Long> operationLatency = ArgumentCaptor.forClass(Long.class);

    Stopwatch stopwatch = Stopwatch.createStarted();
    Lists.newArrayList(stub.readRowsCallable().call(Query.create(TABLE_ID)).iterator());
    long elapsed = stopwatch.elapsed(TimeUnit.MILLISECONDS);

    verify(statsRecorderWrapper).putOperationLatencies(operationLatency.capture());
    // verify record operation is only called once
    verify(statsRecorderWrapper)
        .recordOperation(status.capture(), tableId.capture(), zone.capture(), cluster.capture());

    assertThat(operationLatency.getValue()).isIn(Range.closed(SERVER_LATENCY, elapsed));
    assertThat(status.getAllValues()).containsExactly("OK");
    assertThat(tableId.getAllValues()).containsExactly(TABLE_ID);
    assertThat(zone.getAllValues()).containsExactly(ZONE);
    assertThat(cluster.getAllValues()).containsExactly(CLUSTER);
  }

  @Test
  public void testGfeMetrics() {
    when(mockFactory.newTracer(any(), any(), any()))
        .thenAnswer(
            (Answer<BuiltinMetricsTracer>)
                invocationOnMock ->
                    new BuiltinMetricsTracer(
                        OperationType.ServerStreaming,
                        SpanName.of("Bigtable", "ReadRows"),
                        statsRecorderWrapper));
    ArgumentCaptor<Long> gfeLatency = ArgumentCaptor.forClass(Long.class);
    ArgumentCaptor<Long> gfeMissingHeaders = ArgumentCaptor.forClass(Long.class);

    Lists.newArrayList(stub.readRowsCallable().call(Query.create(TABLE_ID)));

    // Verify record attempt are called multiple times
    verify(statsRecorderWrapper, times(fakeService.getAttemptCounter().get()))
        .recordAttempt(status.capture(), tableId.capture(), zone.capture(), cluster.capture());

    // The request was retried and gfe latency is only recorded in the retry attempt
    verify(statsRecorderWrapper).putGfeLatencies(gfeLatency.capture());
    assertThat(gfeLatency.getValue()).isEqualTo(FAKE_SERVER_TIMING);

    // The first time the request was retried, it'll increment missing header counter
    verify(statsRecorderWrapper, times(fakeService.getAttemptCounter().get()))
        .putGfeMissingHeaders(gfeMissingHeaders.capture());
    assertThat(gfeMissingHeaders.getAllValues()).containsExactly(1L, 0L);

    assertThat(status.getAllValues()).containsExactly("UNAVAILABLE", "OK");
    assertThat(tableId.getAllValues()).containsExactly(TABLE_ID, TABLE_ID);
    assertThat(zone.getAllValues()).containsExactly("global", ZONE);
    assertThat(cluster.getAllValues()).containsExactly("unspecified", CLUSTER);
  }

  @Test
  public void testReadRowsApplicationLatencyWithAutoFlowControl() throws Exception {
    when(mockFactory.newTracer(any(), any(), any()))
        .thenAnswer(
            (Answer<BuiltinMetricsTracer>)
                invocationOnMock ->
                    new BuiltinMetricsTracer(
                        OperationType.ServerStreaming,
                        SpanName.of("Bigtable", "ReadRows"),
                        statsRecorderWrapper));

    ArgumentCaptor<Long> applicationLatency = ArgumentCaptor.forClass(Long.class);
    ArgumentCaptor<Long> operationLatency = ArgumentCaptor.forClass(Long.class);

    final SettableApiFuture future = SettableApiFuture.create();
    final AtomicInteger counter = new AtomicInteger(0);
    // For auto flow control, application latency is the time application spent in onResponse.
    stub.readRowsCallable()
        .call(
            Query.create(TABLE_ID),
            new ResponseObserver<Row>() {
              @Override
              public void onStart(StreamController streamController) {}

              @Override
              public void onResponse(Row row) {
                try {
                  counter.getAndIncrement();
                  Thread.sleep(APPLICATION_LATENCY);
                } catch (InterruptedException e) {
                }
              }

              @Override
              public void onError(Throwable throwable) {
                future.setException(throwable);
              }

              @Override
              public void onComplete() {
                future.set(null);
              }
            });
    future.get();

    verify(statsRecorderWrapper).putApplicationLatencies(applicationLatency.capture());
    verify(statsRecorderWrapper).putOperationLatencies(operationLatency.capture());
    verify(statsRecorderWrapper)
        .recordOperation(status.capture(), tableId.capture(), zone.capture(), cluster.capture());

    assertThat(counter.get()).isEqualTo(fakeService.getResponseCounter().get());
    // Thread.sleep might not sleep for the requested amount depending on the interrupt period
    // defined by the OS.
    // On linux this is ~1ms but on windows may be as high as 15-20ms.
    assertThat(applicationLatency.getValue())
        .isAtLeast((APPLICATION_LATENCY - SLEEP_VARIABILITY) * counter.get());
    assertThat(applicationLatency.getValue())
        .isAtMost(operationLatency.getValue() - SERVER_LATENCY);
  }

  @Test
  public void testReadRowsApplicationLatencyWithManualFlowControl() throws Exception {
    when(mockFactory.newTracer(any(), any(), any()))
        .thenAnswer(
            (Answer<BuiltinMetricsTracer>)
                invocationOnMock ->
                    new BuiltinMetricsTracer(
                        OperationType.ServerStreaming,
                        SpanName.of("Bigtable", "ReadRows"),
                        statsRecorderWrapper));

    ArgumentCaptor<Long> applicationLatency = ArgumentCaptor.forClass(Long.class);
    ArgumentCaptor<Long> operationLatency = ArgumentCaptor.forClass(Long.class);
    int counter = 0;

    Iterator<Row> rows = stub.readRowsCallable().call(Query.create(TABLE_ID)).iterator();

    while (rows.hasNext()) {
      counter++;
      Thread.sleep(APPLICATION_LATENCY);
      rows.next();
    }

    verify(statsRecorderWrapper).putApplicationLatencies(applicationLatency.capture());
    verify(statsRecorderWrapper).putOperationLatencies(operationLatency.capture());
    verify(statsRecorderWrapper)
        .recordOperation(status.capture(), tableId.capture(), zone.capture(), cluster.capture());

    // For manual flow control, the last application latency shouldn't count, because at that point
    // the server already sent back all the responses.
    assertThat(counter).isEqualTo(fakeService.getResponseCounter().get());
    assertThat(applicationLatency.getValue())
        .isAtLeast(APPLICATION_LATENCY * (counter - 1) - SERVER_LATENCY);
    assertThat(applicationLatency.getValue())
        .isAtMost(operationLatency.getValue() - SERVER_LATENCY);
  }

  @Test
  public void testRetryCount() {
    when(mockFactory.newTracer(any(), any(), any()))
        .thenAnswer(
            (Answer<BuiltinMetricsTracer>)
                invocationOnMock ->
                    new BuiltinMetricsTracer(
                        OperationType.ServerStreaming,
                        SpanName.of("Bigtable", "MutateRow"),
                        statsRecorderWrapper));

    ArgumentCaptor<Integer> retryCount = ArgumentCaptor.forClass(Integer.class);

    stub.mutateRowCallable()
        .call(RowMutation.create(TABLE_ID, "random-row").setCell("cf", "q", "value"));

    // In TracedUnaryCallable, we create a future and add a TraceFinisher to the callback. Main
    // thread is blocked on waiting for the future to be completed. When onComplete is called on
    // the grpc thread, the future is completed, however we might not have enough time for
    // TraceFinisher to run. Add a 1 second time out to wait for the callback. This shouldn't have
    // any impact on production code.
    verify(statsRecorderWrapper, timeout(1000)).putRetryCount(retryCount.capture());

    assertThat(retryCount.getValue()).isEqualTo(fakeService.getAttemptCounter().get() - 1);
  }

  @Test
  public void testMutateRowAttemptsTagValues() {
    when(mockFactory.newTracer(any(), any(), any()))
        .thenReturn(
            new BuiltinMetricsTracer(
                OperationType.Unary, SpanName.of("Bigtable", "MutateRow"), statsRecorderWrapper));

    stub.mutateRowCallable()
        .call(RowMutation.create(TABLE_ID, "random-row").setCell("cf", "q", "value"));

    // Set a timeout to reduce flakiness of this test. BasicRetryingFuture will set
    // attempt succeeded and set the response which will call complete() in AbstractFuture which
    // calls releaseWaiters(). onOperationComplete() is called in TracerFinisher which will be
    // called after the mutateRow call is returned. So there's a race between when the call returns
    // and when the record() is called in onOperationCompletion().
    verify(statsRecorderWrapper, timeout(50).times(fakeService.getAttemptCounter().get()))
        .recordAttempt(status.capture(), tableId.capture(), zone.capture(), cluster.capture());
    assertThat(zone.getAllValues()).containsExactly("global", "global", ZONE);
    assertThat(cluster.getAllValues()).containsExactly("unspecified", "unspecified", CLUSTER);
    assertThat(status.getAllValues()).containsExactly("UNAVAILABLE", "UNAVAILABLE", "OK");
    assertThat(tableId.getAllValues()).containsExactly(TABLE_ID, TABLE_ID, TABLE_ID);
  }

  @Test
  public void testMutateRowsPartialError() throws InterruptedException {
    int numMutations = 6;
    when(mockFactory.newTracer(any(), any(), any()))
        .thenReturn(
            new BuiltinMetricsTracer(
                OperationType.Unary, SpanName.of("Bigtable", "MutateRows"), statsRecorderWrapper));

    Batcher<RowMutationEntry, Void> batcher = stub.newMutateRowsBatcher(TABLE_ID, null);
    for (int i = 0; i < numMutations; i++) {
      String key = i % 2 == 0 ? "key" : "fail-key";
      batcher.add(RowMutationEntry.create(key).setCell("f", "q", "v"));
    }

    assertThrows(BatchingException.class, () -> batcher.close());

    int expectedNumRequests = numMutations / batchElementCount;
    verify(statsRecorderWrapper, timeout(100).times(expectedNumRequests))
        .recordAttempt(status.capture(), tableId.capture(), zone.capture(), cluster.capture());

    assertThat(zone.getAllValues()).containsExactly(ZONE, ZONE, ZONE);
    assertThat(cluster.getAllValues()).containsExactly(CLUSTER, CLUSTER, CLUSTER);
    assertThat(status.getAllValues()).containsExactly("OK", "OK", "OK");
  }

  @Test
  public void testMutateRowsRpcError() {
    int numMutations = 6;
    when(mockFactory.newTracer(any(), any(), any()))
        .thenReturn(
            new BuiltinMetricsTracer(
                OperationType.Unary, SpanName.of("Bigtable", "MutateRows"), statsRecorderWrapper));

    Batcher<RowMutationEntry, Void> batcher = stub.newMutateRowsBatcher(BAD_TABLE_ID, null);
    for (int i = 0; i < numMutations; i++) {
      batcher.add(RowMutationEntry.create("key").setCell("f", "q", "v"));
    }

    assertThrows(BatchingException.class, () -> batcher.close());

    int expectedNumRequests = numMutations / batchElementCount;
    verify(statsRecorderWrapper, timeout(100).times(expectedNumRequests))
        .recordAttempt(status.capture(), tableId.capture(), zone.capture(), cluster.capture());

    assertThat(zone.getAllValues()).containsExactly("global", "global", "global");
    assertThat(cluster.getAllValues()).containsExactly("unspecified", "unspecified", "unspecified");
    assertThat(status.getAllValues()).containsExactly("NOT_FOUND", "NOT_FOUND", "NOT_FOUND");
  }

  @Test
  public void testReadRowsAttemptsTagValues() {
    when(mockFactory.newTracer(any(), any(), any()))
        .thenReturn(
            new BuiltinMetricsTracer(
                OperationType.ServerStreaming,
                SpanName.of("Bigtable", "ReadRows"),
                statsRecorderWrapper));

    Lists.newArrayList(stub.readRowsCallable().call(Query.create("fake-table")).iterator());

    // Set a timeout to reduce flakiness of this test. BasicRetryingFuture will set
    // attempt succeeded and set the response which will call complete() in AbstractFuture which
    // calls releaseWaiters(). onOperationComplete() is called in TracerFinisher which will be
    // called after the mutateRow call is returned. So there's a race between when the call returns
    // and when the record() is called in onOperationCompletion().
    verify(statsRecorderWrapper, timeout(50).times(fakeService.getAttemptCounter().get()))
        .recordAttempt(status.capture(), tableId.capture(), zone.capture(), cluster.capture());
    assertThat(zone.getAllValues()).containsExactly("global", ZONE);
    assertThat(cluster.getAllValues()).containsExactly("unspecified", CLUSTER);
    assertThat(status.getAllValues()).containsExactly("UNAVAILABLE", "OK");
  }

  @Test
  public void testBatchBlockingLatencies() throws InterruptedException {
    when(mockFactory.newTracer(any(), any(), any()))
        .thenReturn(
            new BuiltinMetricsTracer(
                OperationType.Unary, SpanName.of("Bigtable", "MutateRows"), statsRecorderWrapper));
    try (Batcher<RowMutationEntry, Void> batcher = stub.newMutateRowsBatcher(TABLE_ID, null)) {
      for (int i = 0; i < 6; i++) {
        batcher.add(RowMutationEntry.create("key").setCell("f", "q", "v"));
      }

      // closing the batcher to trigger the third flush
      batcher.close();

      int expectedNumRequests = 6 / batchElementCount;
      ArgumentCaptor<Long> throttledTime = ArgumentCaptor.forClass(Long.class);
      verify(statsRecorderWrapper, timeout(1000).times(expectedNumRequests))
          .putClientBlockingLatencies(throttledTime.capture());

      // After the first request is sent, batcher will block on add because of the server latency.
      // Blocking latency should be around server latency.
      assertThat(throttledTime.getAllValues().get(1)).isAtLeast(SERVER_LATENCY - 10);
      assertThat(throttledTime.getAllValues().get(2)).isAtLeast(SERVER_LATENCY - 10);

      verify(statsRecorderWrapper, timeout(100).times(expectedNumRequests))
          .recordAttempt(status.capture(), tableId.capture(), zone.capture(), cluster.capture());

      assertThat(zone.getAllValues()).containsExactly(ZONE, ZONE, ZONE);
      assertThat(cluster.getAllValues()).containsExactly(CLUSTER, CLUSTER, CLUSTER);
    }
  }

  @Test
  public void testQueuedOnChannelServerStreamLatencies() throws InterruptedException {
    when(mockFactory.newTracer(any(), any(), any()))
        .thenReturn(
            new BuiltinMetricsTracer(
                OperationType.ServerStreaming,
                SpanName.of("Bigtable", "ReadRows"),
                statsRecorderWrapper));

    stub.readRowsCallable().all().call(Query.create(TABLE_ID));

    ArgumentCaptor<Long> blockedTime = ArgumentCaptor.forClass(Long.class);

    verify(statsRecorderWrapper, timeout(1000).times(fakeService.attemptCounter.get()))
        .putClientBlockingLatencies(blockedTime.capture());

    assertThat(blockedTime.getAllValues().get(1)).isAtLeast(CHANNEL_BLOCKING_LATENCY);
  }

  @Test
  public void testQueuedOnChannelUnaryLatencies() throws InterruptedException {
    when(mockFactory.newTracer(any(), any(), any()))
        .thenReturn(
            new BuiltinMetricsTracer(
                OperationType.Unary, SpanName.of("Bigtable", "MutateRow"), statsRecorderWrapper));
    stub.mutateRowCallable().call(RowMutation.create(TABLE_ID, "a-key").setCell("f", "q", "v"));

    ArgumentCaptor<Long> blockedTime = ArgumentCaptor.forClass(Long.class);

    verify(statsRecorderWrapper, timeout(1000).times(fakeService.attemptCounter.get()))
        .putClientBlockingLatencies(blockedTime.capture());

    assertThat(blockedTime.getAllValues().get(1)).isAtLeast(CHANNEL_BLOCKING_LATENCY);
    assertThat(blockedTime.getAllValues().get(2)).isAtLeast(CHANNEL_BLOCKING_LATENCY);
  }

  @Test
  public void testPermanentFailure() {
    when(mockFactory.newTracer(any(), any(), any()))
        .thenReturn(
            new BuiltinMetricsTracer(
                OperationType.ServerStreaming,
                SpanName.of("Bigtable", "ReadRows"),
                statsRecorderWrapper));

    try {
      Lists.newArrayList(stub.readRowsCallable().call(Query.create(BAD_TABLE_ID)).iterator());
      Assert.fail("Request should throw not found error");
    } catch (NotFoundException e) {
    }

    ArgumentCaptor<Long> attemptLatency = ArgumentCaptor.forClass(Long.class);
    ArgumentCaptor<Long> operationLatency = ArgumentCaptor.forClass(Long.class);

    verify(statsRecorderWrapper, timeout(50)).putAttemptLatencies(attemptLatency.capture());
    verify(statsRecorderWrapper, timeout(50)).putOperationLatencies(operationLatency.capture());
    verify(statsRecorderWrapper, timeout(50))
        .recordAttempt(status.capture(), tableId.capture(), zone.capture(), cluster.capture());

    assertThat(status.getValue()).isEqualTo("NOT_FOUND");
    assertThat(tableId.getValue()).isEqualTo(BAD_TABLE_ID);
    assertThat(cluster.getValue()).isEqualTo("unspecified");
    assertThat(zone.getValue()).isEqualTo("global");
  }

  private static class FakeService extends BigtableGrpc.BigtableImplBase {

    static List<ReadRowsResponse> createFakeResponse() {
      List<ReadRowsResponse> responses = new ArrayList<>();
      for (int i = 0; i < 4; i++) {
        responses.add(
            ReadRowsResponse.newBuilder()
                .addChunks(
                    ReadRowsResponse.CellChunk.newBuilder()
                        .setRowKey(ByteString.copyFromUtf8("fake-key-" + i))
                        .setFamilyName(StringValue.of("cf"))
                        .setQualifier(
                            BytesValue.newBuilder().setValue(ByteString.copyFromUtf8("q")))
                        .setTimestampMicros(1_000)
                        .setValue(
                            ByteString.copyFromUtf8(
                                String.join("", Collections.nCopies(1024 * 1024, "A"))))
                        .setCommitRow(true))
                .build());
      }
      return responses;
    }

    private final AtomicInteger attemptCounter = new AtomicInteger(0);
    private final AtomicInteger responseCounter = new AtomicInteger(0);
    private final Iterator<ReadRowsResponse> source = createFakeResponse().listIterator();

    @Override
    public void readRows(
        ReadRowsRequest request, StreamObserver<ReadRowsResponse> responseObserver) {
      if (request.getTableName().contains(BAD_TABLE_ID)) {
        responseObserver.onError(new StatusRuntimeException(Status.NOT_FOUND));
        return;
      }
      final AtomicBoolean done = new AtomicBoolean();
      final ServerCallStreamObserver<ReadRowsResponse> target =
          (ServerCallStreamObserver<ReadRowsResponse>) responseObserver;
      try {
        Thread.sleep(SERVER_LATENCY);
      } catch (InterruptedException e) {
      }
      if (attemptCounter.getAndIncrement() == 0) {
        target.onError(new StatusRuntimeException(Status.UNAVAILABLE));
        return;
      }

      // Only return the next response when the buffer is emptied for testing manual flow control.
      // The fake service won't keep calling onNext unless it received an onRequest event from
      // the application thread
      target.setOnReadyHandler(
          () -> {
            while (target.isReady() && source.hasNext()) {
              responseCounter.getAndIncrement();
              target.onNext(source.next());
            }
            if (!source.hasNext() && done.compareAndSet(false, true)) {
              target.onCompleted();
            }
          });
    }

    @Override
    public void mutateRow(
        MutateRowRequest request, StreamObserver<MutateRowResponse> responseObserver) {
      if (attemptCounter.getAndIncrement() < 2) {
        responseObserver.onError(new StatusRuntimeException(Status.UNAVAILABLE));
        return;
      }
      responseObserver.onNext(MutateRowResponse.getDefaultInstance());
      responseObserver.onCompleted();
    }

    @Override
    public void mutateRows(
        MutateRowsRequest request, StreamObserver<MutateRowsResponse> responseObserver) {
      if (request.getTableName().contains(BAD_TABLE_ID)) {
        responseObserver.onError(new StatusRuntimeException(Status.NOT_FOUND));
        return;
      }
      try {
        Thread.sleep(SERVER_LATENCY);
      } catch (InterruptedException e) {
      }
      MutateRowsResponse.Builder builder = MutateRowsResponse.newBuilder();
      for (int i = 0; i < request.getEntriesCount(); i++) {
        if (request
            .getEntries(i)
            .getRowKey()
            .toString(Charset.availableCharsets().get("UTF-8"))
            .startsWith("fail")) {
          builder
              .addEntriesBuilder()
              .setIndex(i)
              .setStatus(
                  com.google.rpc.Status.newBuilder()
                      .setCode(com.google.rpc.Code.PERMISSION_DENIED_VALUE)
                      .build());
          continue;
        }
        builder.addEntriesBuilder().setIndex(i);
      }
      responseObserver.onNext(builder.build());
      responseObserver.onCompleted();
    }

    public AtomicInteger getAttemptCounter() {
      return attemptCounter;
    }

    public AtomicInteger getResponseCounter() {
      return responseCounter;
    }
  }
}
