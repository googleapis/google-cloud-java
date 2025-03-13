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

import static com.google.cloud.bigtable.data.v2.stub.metrics.BuiltinMetricsConstants.APPLICATION_BLOCKING_LATENCIES_NAME;
import static com.google.cloud.bigtable.data.v2.stub.metrics.BuiltinMetricsConstants.ATTEMPT_LATENCIES_NAME;
import static com.google.cloud.bigtable.data.v2.stub.metrics.BuiltinMetricsConstants.CLIENT_BLOCKING_LATENCIES_NAME;
import static com.google.cloud.bigtable.data.v2.stub.metrics.BuiltinMetricsConstants.CLIENT_NAME_KEY;
import static com.google.cloud.bigtable.data.v2.stub.metrics.BuiltinMetricsConstants.CLUSTER_ID_KEY;
import static com.google.cloud.bigtable.data.v2.stub.metrics.BuiltinMetricsConstants.CONNECTIVITY_ERROR_COUNT_NAME;
import static com.google.cloud.bigtable.data.v2.stub.metrics.BuiltinMetricsConstants.FIRST_RESPONSE_LATENCIES_NAME;
import static com.google.cloud.bigtable.data.v2.stub.metrics.BuiltinMetricsConstants.METHOD_KEY;
import static com.google.cloud.bigtable.data.v2.stub.metrics.BuiltinMetricsConstants.OPERATION_LATENCIES_NAME;
import static com.google.cloud.bigtable.data.v2.stub.metrics.BuiltinMetricsConstants.REMAINING_DEADLINE_NAME;
import static com.google.cloud.bigtable.data.v2.stub.metrics.BuiltinMetricsConstants.RETRY_COUNT_NAME;
import static com.google.cloud.bigtable.data.v2.stub.metrics.BuiltinMetricsConstants.SERVER_LATENCIES_NAME;
import static com.google.cloud.bigtable.data.v2.stub.metrics.BuiltinMetricsConstants.STATUS_KEY;
import static com.google.cloud.bigtable.data.v2.stub.metrics.BuiltinMetricsConstants.STREAMING_KEY;
import static com.google.cloud.bigtable.data.v2.stub.metrics.BuiltinMetricsConstants.TABLE_ID_KEY;
import static com.google.cloud.bigtable.data.v2.stub.metrics.BuiltinMetricsConstants.ZONE_ID_KEY;
import static com.google.cloud.bigtable.data.v2.stub.metrics.BuiltinMetricsTestUtils.getAggregatedValue;
import static com.google.cloud.bigtable.data.v2.stub.metrics.BuiltinMetricsTestUtils.getMetricData;
import static com.google.cloud.bigtable.data.v2.stub.metrics.BuiltinMetricsTestUtils.verifyAttributes;
import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth.assertWithMessage;

import com.google.api.client.util.Lists;
import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
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
import com.google.bigtable.v2.BigtableGrpc;
import com.google.bigtable.v2.MutateRowRequest;
import com.google.bigtable.v2.MutateRowResponse;
import com.google.bigtable.v2.MutateRowsRequest;
import com.google.bigtable.v2.MutateRowsResponse;
import com.google.bigtable.v2.ReadRowsRequest;
import com.google.bigtable.v2.ReadRowsResponse;
import com.google.bigtable.v2.ResponseParams;
import com.google.cloud.bigtable.Version;
import com.google.cloud.bigtable.data.v2.BigtableDataSettings;
import com.google.cloud.bigtable.data.v2.FakeServiceBuilder;
import com.google.cloud.bigtable.data.v2.models.AuthorizedViewId;
import com.google.cloud.bigtable.data.v2.models.Query;
import com.google.cloud.bigtable.data.v2.models.Row;
import com.google.cloud.bigtable.data.v2.models.RowMutation;
import com.google.cloud.bigtable.data.v2.models.RowMutationEntry;
import com.google.cloud.bigtable.data.v2.models.TableId;
import com.google.cloud.bigtable.data.v2.stub.EnhancedBigtableStub;
import com.google.cloud.bigtable.data.v2.stub.EnhancedBigtableStubSettings;
import com.google.common.base.Stopwatch;
import com.google.common.collect.Range;
import com.google.protobuf.ByteString;
import com.google.protobuf.BytesValue;
import com.google.protobuf.StringValue;
import io.grpc.ForwardingServerCall;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Metadata;
import io.grpc.ProxiedSocketAddress;
import io.grpc.ProxyDetector;
import io.grpc.Server;
import io.grpc.ServerCall;
import io.grpc.ServerCallHandler;
import io.grpc.ServerInterceptor;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.ServerCallStreamObserver;
import io.grpc.stub.StreamObserver;
import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.sdk.OpenTelemetrySdk;
import io.opentelemetry.sdk.metrics.InstrumentSelector;
import io.opentelemetry.sdk.metrics.SdkMeterProvider;
import io.opentelemetry.sdk.metrics.SdkMeterProviderBuilder;
import io.opentelemetry.sdk.metrics.View;
import io.opentelemetry.sdk.metrics.data.HistogramPointData;
import io.opentelemetry.sdk.metrics.data.MetricData;
import io.opentelemetry.sdk.testing.exporter.InMemoryMetricReader;
import java.io.IOException;
import java.net.SocketAddress;
import java.nio.charset.Charset;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import javax.annotation.Nullable;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

@RunWith(JUnit4.class)
public class BuiltinMetricsTracerTest {
  private static final String PROJECT_ID = "fake-project";
  private static final String INSTANCE_ID = "fake-instance";
  private static final String APP_PROFILE_ID = "default";
  private static final String TABLE = "fake-table";

  private static final String BAD_TABLE_ID = "non-exist-table";
  private static final String FIRST_RESPONSE_TABLE_ID = "first-response";
  private static final String ZONE = "us-west-1";
  private static final String CLUSTER = "cluster-0";
  private static final long FAKE_SERVER_TIMING = 50;
  private static final long SERVER_LATENCY = 100;
  private static final long APPLICATION_LATENCY = 200;
  private static final long SLEEP_VARIABILITY = 15;
  private static final String CLIENT_NAME = "java-bigtable/" + Version.VERSION;
  private static final Duration CHANNEL_BLOCKING_LATENCY = Duration.ofMillis(200);

  @Rule public final MockitoRule mockitoRule = MockitoJUnit.rule();

  private final FakeService fakeService = new FakeService();
  private Server server;

  private EnhancedBigtableStub stub;

  private int batchElementCount = 2;

  private Attributes baseAttributes;

  private InMemoryMetricReader metricReader;

  private DelayProxyDetector delayProxyDetector;

  @Before
  public void setUp() throws Exception {
    metricReader = InMemoryMetricReader.create();

    baseAttributes =
        Attributes.builder()
            .put(BuiltinMetricsConstants.BIGTABLE_PROJECT_ID_KEY, PROJECT_ID)
            .put(BuiltinMetricsConstants.INSTANCE_ID_KEY, INSTANCE_ID)
            .put(BuiltinMetricsConstants.APP_PROFILE_KEY, APP_PROFILE_ID)
            .build();

    SdkMeterProviderBuilder meterProvider =
        SdkMeterProvider.builder().registerMetricReader(metricReader);

    for (Map.Entry<InstrumentSelector, View> entry :
        BuiltinMetricsConstants.getAllViews().entrySet()) {
      meterProvider.registerView(entry.getKey(), entry.getValue());
    }

    OpenTelemetrySdk otel =
        OpenTelemetrySdk.builder().setMeterProvider(meterProvider.build()).build();
    BuiltinMetricsTracerFactory facotry = BuiltinMetricsTracerFactory.create(otel, baseAttributes);

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

    server = FakeServiceBuilder.create(fakeService).intercept(trailersInterceptor).start();

    BigtableDataSettings settings =
        BigtableDataSettings.newBuilderForEmulator(server.getPort())
            .setProjectId(PROJECT_ID)
            .setInstanceId(INSTANCE_ID)
            .setAppProfileId(APP_PROFILE_ID)
            .setRefreshingChannel(false)
            .build();
    EnhancedBigtableStubSettings.Builder stubSettingsBuilder =
        settings.getStubSettings().toBuilder();
    stubSettingsBuilder
        .mutateRowSettings()
        .retrySettings()
        .setInitialRetryDelayDuration(java.time.Duration.ofMillis(200));

    stubSettingsBuilder
        .readRowsSettings()
        .retrySettings()
        .setTotalTimeoutDuration(Duration.ofMillis(9000))
        .setMaxRpcTimeoutDuration(Duration.ofMillis(9000))
        .setRpcTimeoutMultiplier(1)
        .setInitialRpcTimeoutDuration(Duration.ofMillis(6000))
        .setInitialRetryDelayDuration(Duration.ofMillis(10))
        .setRetryDelayMultiplier(1)
        .setMaxRetryDelayDuration(Duration.ofMillis(10));

    stubSettingsBuilder
        .bulkMutateRowsSettings()
        .setBatchingSettings(
            // Each batch has 2 mutations, batch has 1 in-flight request, disable auto flush by
            // setting the delay to 1 hour.
            BatchingSettings.newBuilder()
                .setElementCountThreshold((long) batchElementCount)
                .setRequestByteThreshold(1000L)
                .setDelayThresholdDuration(java.time.Duration.ofHours(1))
                .setFlowControlSettings(
                    FlowControlSettings.newBuilder()
                        .setMaxOutstandingElementCount((long) batchElementCount + 1)
                        .setMaxOutstandingRequestBytes(1001L)
                        .build())
                .build());

    stubSettingsBuilder.setTracerFactory(facotry);

    InstantiatingGrpcChannelProvider.Builder channelProvider =
        ((InstantiatingGrpcChannelProvider) stubSettingsBuilder.getTransportChannelProvider())
            .toBuilder();

    @SuppressWarnings("rawtypes")
    final ApiFunction<ManagedChannelBuilder, ManagedChannelBuilder> oldConfigurator =
        channelProvider.getChannelConfigurator();

    delayProxyDetector = new DelayProxyDetector();

    channelProvider.setChannelConfigurator(
        (builder) -> {
          if (oldConfigurator != null) {
            builder = oldConfigurator.apply(builder);
          }
          return builder.proxyDetector(delayProxyDetector);
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
    Stopwatch stopwatch = Stopwatch.createStarted();
    Lists.newArrayList(stub.readRowsCallable().call(Query.create(TABLE)).iterator());
    long elapsed = stopwatch.elapsed(TimeUnit.MILLISECONDS);

    Attributes expectedAttributes =
        baseAttributes
            .toBuilder()
            .put(STATUS_KEY, "OK")
            .put(TABLE_ID_KEY, TABLE)
            .put(ZONE_ID_KEY, ZONE)
            .put(CLUSTER_ID_KEY, CLUSTER)
            .put(METHOD_KEY, "Bigtable.ReadRows")
            .put(STREAMING_KEY, true)
            .put(CLIENT_NAME_KEY, CLIENT_NAME)
            .build();

    MetricData metricData = getMetricData(metricReader, OPERATION_LATENCIES_NAME);

    long value = getAggregatedValue(metricData, expectedAttributes);
    assertThat(value).isIn(Range.closed(SERVER_LATENCY, elapsed));
  }

  @Test
  public void testReadRowsOperationLatenciesOnAuthorizedView() {
    String authorizedViewId = "test-authorized-view-id";
    Stopwatch stopwatch = Stopwatch.createStarted();
    Lists.newArrayList(
        stub.readRowsCallable().call(Query.create(AuthorizedViewId.of(TABLE, authorizedViewId))));
    long elapsed = stopwatch.elapsed(TimeUnit.MILLISECONDS);

    Attributes expectedAttributes =
        baseAttributes
            .toBuilder()
            .put(STATUS_KEY, "OK")
            .put(TABLE_ID_KEY, TABLE)
            .put(ZONE_ID_KEY, ZONE)
            .put(CLUSTER_ID_KEY, CLUSTER)
            .put(METHOD_KEY, "Bigtable.ReadRows")
            .put(STREAMING_KEY, true)
            .put(CLIENT_NAME_KEY, CLIENT_NAME)
            .build();

    MetricData metricData = getMetricData(metricReader, OPERATION_LATENCIES_NAME);
    long value = getAggregatedValue(metricData, expectedAttributes);
    assertThat(value).isIn(Range.closed(SERVER_LATENCY, elapsed));
  }

  @Test
  public void testFirstResponseLatencies() {
    Stopwatch firstResponseTimer = Stopwatch.createStarted();
    stub.readRowsCallable()
        .call(
            Query.create(FIRST_RESPONSE_TABLE_ID),
            new ResponseObserver<Row>() {
              @Override
              public void onStart(StreamController controller) {}

              @Override
              public void onResponse(Row response) {
                // Server sends back 2 responses for this test
                if (firstResponseTimer.isRunning()) {
                  firstResponseTimer.stop();
                }
                try {
                  Thread.sleep(100);
                } catch (InterruptedException e) {
                }
              }

              @Override
              public void onError(Throwable t) {}

              @Override
              public void onComplete() {}
            });

    Attributes expectedAttributes =
        baseAttributes
            .toBuilder()
            .put(STATUS_KEY, "OK")
            .put(TABLE_ID_KEY, FIRST_RESPONSE_TABLE_ID)
            .put(ZONE_ID_KEY, ZONE)
            .put(CLUSTER_ID_KEY, CLUSTER)
            .put(METHOD_KEY, "Bigtable.ReadRows")
            .put(CLIENT_NAME_KEY, CLIENT_NAME)
            .build();

    MetricData metricData = getMetricData(metricReader, FIRST_RESPONSE_LATENCIES_NAME);

    long value = getAggregatedValue(metricData, expectedAttributes);
    assertThat(value).isAtMost(firstResponseTimer.elapsed(TimeUnit.MILLISECONDS));
  }

  @Test
  public void testGfeMetrics() {
    Lists.newArrayList(stub.readRowsCallable().call(Query.create(TABLE)));

    Attributes expectedAttributes =
        baseAttributes
            .toBuilder()
            .put(STATUS_KEY, "OK")
            .put(TABLE_ID_KEY, TABLE)
            .put(ZONE_ID_KEY, ZONE)
            .put(CLUSTER_ID_KEY, CLUSTER)
            .put(CLIENT_NAME_KEY, CLIENT_NAME)
            .put(METHOD_KEY, "Bigtable.ReadRows")
            .build();

    MetricData serverLatenciesMetricData = getMetricData(metricReader, SERVER_LATENCIES_NAME);

    long serverLatencies = getAggregatedValue(serverLatenciesMetricData, expectedAttributes);
    assertThat(serverLatencies).isEqualTo(FAKE_SERVER_TIMING);

    MetricData connectivityErrorCountMetricData =
        getMetricData(metricReader, CONNECTIVITY_ERROR_COUNT_NAME);
    Attributes expected1 =
        baseAttributes
            .toBuilder()
            .put(STATUS_KEY, "UNAVAILABLE")
            .put(TABLE_ID_KEY, TABLE)
            .put(ZONE_ID_KEY, "global")
            .put(CLUSTER_ID_KEY, "<unspecified>")
            .put(METHOD_KEY, "Bigtable.ReadRows")
            .put(CLIENT_NAME_KEY, CLIENT_NAME)
            .build();
    Attributes expected2 =
        baseAttributes
            .toBuilder()
            .put(STATUS_KEY, "OK")
            .put(TABLE_ID_KEY, TABLE)
            .put(ZONE_ID_KEY, ZONE)
            .put(CLUSTER_ID_KEY, CLUSTER)
            .put(METHOD_KEY, "Bigtable.ReadRows")
            .put(CLIENT_NAME_KEY, CLIENT_NAME)
            .build();

    verifyAttributes(connectivityErrorCountMetricData, expected1);
    verifyAttributes(connectivityErrorCountMetricData, expected2);

    assertThat(getAggregatedValue(connectivityErrorCountMetricData, expected1)).isEqualTo(1);
    assertThat(getAggregatedValue(connectivityErrorCountMetricData, expected2)).isEqualTo(0);
  }

  @Test
  public void testReadRowsApplicationLatencyWithAutoFlowControl() throws Exception {
    final SettableApiFuture future = SettableApiFuture.create();
    final AtomicInteger counter = new AtomicInteger(0);
    // For auto flow control, application latency is the time application spent in onResponse.
    stub.readRowsCallable()
        .call(
            Query.create(TABLE),
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

    assertThat(counter.get()).isEqualTo(fakeService.getResponseCounter().get());

    MetricData applicationLatency =
        getMetricData(metricReader, APPLICATION_BLOCKING_LATENCIES_NAME);

    Attributes expectedAttributes =
        baseAttributes
            .toBuilder()
            .put(TABLE_ID_KEY, TABLE)
            .put(ZONE_ID_KEY, ZONE)
            .put(CLUSTER_ID_KEY, CLUSTER)
            .put(CLIENT_NAME_KEY, CLIENT_NAME)
            .put(METHOD_KEY, "Bigtable.ReadRows")
            .build();
    long value = getAggregatedValue(applicationLatency, expectedAttributes);

    assertThat(value).isAtLeast((APPLICATION_LATENCY - SLEEP_VARIABILITY) * counter.get());

    MetricData operationLatency = getMetricData(metricReader, OPERATION_LATENCIES_NAME);
    long operationLatencyValue =
        getAggregatedValue(
            operationLatency,
            expectedAttributes.toBuilder().put(STATUS_KEY, "OK").put(STREAMING_KEY, true).build());
    assertThat(value).isAtMost(operationLatencyValue - SERVER_LATENCY);
  }

  @Test
  public void testReadRowsApplicationLatencyWithManualFlowControl() throws Exception {
    int counter = 0;

    Iterator<Row> rows = stub.readRowsCallable().call(Query.create(TABLE)).iterator();

    while (rows.hasNext()) {
      counter++;
      Thread.sleep(APPLICATION_LATENCY);
      rows.next();
    }

    MetricData applicationLatency =
        getMetricData(metricReader, APPLICATION_BLOCKING_LATENCIES_NAME);

    Attributes expectedAttributes =
        baseAttributes
            .toBuilder()
            .put(TABLE_ID_KEY, TABLE)
            .put(ZONE_ID_KEY, ZONE)
            .put(CLUSTER_ID_KEY, CLUSTER)
            .put(CLIENT_NAME_KEY, CLIENT_NAME)
            .put(METHOD_KEY, "Bigtable.ReadRows")
            .build();

    long value = getAggregatedValue(applicationLatency, expectedAttributes);
    // For manual flow control, the last application latency shouldn't count, because at that
    // point the server already sent back all the responses.
    assertThat(counter).isEqualTo(fakeService.getResponseCounter().get());
    assertThat(value).isAtLeast(APPLICATION_LATENCY * (counter - 1) - SERVER_LATENCY);

    MetricData operationLatency = getMetricData(metricReader, OPERATION_LATENCIES_NAME);
    long operationLatencyValue =
        getAggregatedValue(
            operationLatency,
            expectedAttributes.toBuilder().put(STATUS_KEY, "OK").put(STREAMING_KEY, true).build());
    assertThat(value).isAtMost(operationLatencyValue - SERVER_LATENCY);
  }

  @Test
  public void testRetryCount() throws InterruptedException {
    stub.mutateRowCallable()
        .call(RowMutation.create(TABLE, "random-row").setCell("cf", "q", "value"));

    MetricData metricData = getMetricData(metricReader, RETRY_COUNT_NAME);
    Attributes expectedAttributes =
        baseAttributes
            .toBuilder()
            .put(TABLE_ID_KEY, TABLE)
            .put(ZONE_ID_KEY, ZONE)
            .put(CLUSTER_ID_KEY, CLUSTER)
            .put(CLIENT_NAME_KEY, CLIENT_NAME)
            .put(METHOD_KEY, "Bigtable.MutateRow")
            .put(STATUS_KEY, "OK")
            .build();

    long value = getAggregatedValue(metricData, expectedAttributes);
    assertThat(value).isEqualTo(fakeService.getAttemptCounter().get() - 1);
  }

  @Test
  public void testMutateRowAttemptsTagValues() {
    stub.mutateRowCallable()
        .call(RowMutation.create(TABLE, "random-row").setCell("cf", "q", "value"));

    MetricData metricData = getMetricData(metricReader, ATTEMPT_LATENCIES_NAME);

    Attributes expected1 =
        baseAttributes
            .toBuilder()
            .put(STATUS_KEY, "UNAVAILABLE")
            .put(TABLE_ID_KEY, TABLE)
            .put(ZONE_ID_KEY, "global")
            .put(CLUSTER_ID_KEY, "<unspecified>")
            .put(METHOD_KEY, "Bigtable.MutateRow")
            .put(CLIENT_NAME_KEY, CLIENT_NAME)
            .put(STREAMING_KEY, false)
            .build();

    Attributes expected2 =
        baseAttributes
            .toBuilder()
            .put(STATUS_KEY, "OK")
            .put(TABLE_ID_KEY, TABLE)
            .put(ZONE_ID_KEY, ZONE)
            .put(CLUSTER_ID_KEY, CLUSTER)
            .put(METHOD_KEY, "Bigtable.MutateRow")
            .put(CLIENT_NAME_KEY, CLIENT_NAME)
            .put(STREAMING_KEY, false)
            .build();

    verifyAttributes(metricData, expected1);
    verifyAttributes(metricData, expected2);
  }

  @Test
  public void testMutateRowsPartialError() throws InterruptedException {
    Batcher<RowMutationEntry, Void> batcher = stub.newMutateRowsBatcher(TableId.of(TABLE), null);
    int numMutations = 6;
    for (int i = 0; i < numMutations; i++) {
      String key = i % 2 == 0 ? "key" : "fail-key";
      batcher.add(RowMutationEntry.create(key).setCell("f", "q", "v"));
    }

    Assert.assertThrows(BatchingException.class, batcher::close);

    MetricData metricData = getMetricData(metricReader, ATTEMPT_LATENCIES_NAME);

    Attributes expected =
        baseAttributes
            .toBuilder()
            .put(STATUS_KEY, "OK")
            .put(TABLE_ID_KEY, TABLE)
            .put(ZONE_ID_KEY, ZONE)
            .put(CLUSTER_ID_KEY, CLUSTER)
            .put(METHOD_KEY, "Bigtable.MutateRows")
            .put(CLIENT_NAME_KEY, CLIENT_NAME)
            .put(STREAMING_KEY, false)
            .build();

    verifyAttributes(metricData, expected);
  }

  @Test
  public void testMutateRowsRpcError() {
    Batcher<RowMutationEntry, Void> batcher =
        stub.newMutateRowsBatcher(TableId.of(BAD_TABLE_ID), null);
    int numMutations = 6;
    for (int i = 0; i < numMutations; i++) {
      String key = i % 2 == 0 ? "key" : "fail-key";
      batcher.add(RowMutationEntry.create(key).setCell("f", "q", "v"));
    }

    Assert.assertThrows(BatchingException.class, batcher::close);

    MetricData metricData = getMetricData(metricReader, ATTEMPT_LATENCIES_NAME);

    Attributes expected =
        baseAttributes
            .toBuilder()
            .put(STATUS_KEY, "NOT_FOUND")
            .put(TABLE_ID_KEY, BAD_TABLE_ID)
            .put(ZONE_ID_KEY, "global")
            .put(CLUSTER_ID_KEY, "<unspecified>")
            .put(METHOD_KEY, "Bigtable.MutateRows")
            .put(CLIENT_NAME_KEY, CLIENT_NAME)
            .put(STREAMING_KEY, false)
            .build();

    verifyAttributes(metricData, expected);
  }

  @Test
  public void testReadRowsAttemptsTagValues() {
    Lists.newArrayList(stub.readRowsCallable().call(Query.create("fake-table")).iterator());

    MetricData metricData = getMetricData(metricReader, ATTEMPT_LATENCIES_NAME);

    Attributes expected1 =
        baseAttributes
            .toBuilder()
            .put(STATUS_KEY, "UNAVAILABLE")
            .put(TABLE_ID_KEY, TABLE)
            .put(ZONE_ID_KEY, "global")
            .put(CLUSTER_ID_KEY, "<unspecified>")
            .put(METHOD_KEY, "Bigtable.ReadRows")
            .put(CLIENT_NAME_KEY, CLIENT_NAME)
            .put(STREAMING_KEY, true)
            .build();

    Attributes expected2 =
        baseAttributes
            .toBuilder()
            .put(STATUS_KEY, "OK")
            .put(TABLE_ID_KEY, TABLE)
            .put(ZONE_ID_KEY, ZONE)
            .put(CLUSTER_ID_KEY, CLUSTER)
            .put(METHOD_KEY, "Bigtable.ReadRows")
            .put(CLIENT_NAME_KEY, CLIENT_NAME)
            .put(STREAMING_KEY, true)
            .build();

    verifyAttributes(metricData, expected1);
    verifyAttributes(metricData, expected2);
  }

  @Test
  public void testBatchBlockingLatencies() throws InterruptedException {
    try (Batcher<RowMutationEntry, Void> batcher = stub.newMutateRowsBatcher(TABLE, null)) {
      for (int i = 0; i < 6; i++) {
        batcher.add(RowMutationEntry.create("key").setCell("f", "q", "v"));
      }

      // closing the batcher to trigger the third flush
      batcher.close();

      int expectedNumRequests = 6 / batchElementCount;

      MetricData applicationLatency = getMetricData(metricReader, CLIENT_BLOCKING_LATENCIES_NAME);

      Attributes expectedAttributes =
          baseAttributes
              .toBuilder()
              .put(TABLE_ID_KEY, TABLE)
              .put(ZONE_ID_KEY, ZONE)
              .put(CLUSTER_ID_KEY, CLUSTER)
              .put(METHOD_KEY, "Bigtable.MutateRows")
              .put(CLIENT_NAME_KEY, CLIENT_NAME)
              .build();

      long value = getAggregatedValue(applicationLatency, expectedAttributes);
      // After the first request is sent, batcher will block on add because of the server latency.
      // Blocking latency should be around server latency. So each data point would be at least
      // (SERVER_LATENCY - 10).
      long expected = (SERVER_LATENCY - 10) * (expectedNumRequests - 1) / expectedNumRequests;
      assertThat(value).isAtLeast(expected);
    }
  }

  @Test
  public void testQueuedOnChannelServerStreamLatencies() throws Exception {
    ApiFuture<List<Row>> f = stub.readRowsCallable().all().futureCall(Query.create(TABLE));
    Duration proxyDelayPriorTest = delayProxyDetector.getCurrentDelayUsed();
    f.get();

    MetricData clientLatency = getMetricData(metricReader, CLIENT_BLOCKING_LATENCIES_NAME);

    Attributes attributes =
        baseAttributes
            .toBuilder()
            .put(TABLE_ID_KEY, TABLE)
            .put(CLUSTER_ID_KEY, CLUSTER)
            .put(ZONE_ID_KEY, ZONE)
            .put(METHOD_KEY, "Bigtable.ReadRows")
            .put(CLIENT_NAME_KEY, CLIENT_NAME)
            .build();

    Duration value = Duration.ofMillis(getAggregatedValue(clientLatency, attributes));
    assertThat(value).isAtLeast(CHANNEL_BLOCKING_LATENCY.minus(proxyDelayPriorTest));
  }

  @Test
  public void testQueuedOnChannelUnaryLatencies() throws Exception {
    ApiFuture<Void> f =
        stub.mutateRowCallable()
            .futureCall(RowMutation.create(TABLE, "a-key").setCell("f", "q", "v"));
    Duration proxyDelayPriorTest = delayProxyDetector.getCurrentDelayUsed();
    f.get();

    MetricData clientLatency = getMetricData(metricReader, CLIENT_BLOCKING_LATENCIES_NAME);

    Attributes attributes =
        baseAttributes
            .toBuilder()
            .put(TABLE_ID_KEY, TABLE)
            .put(CLUSTER_ID_KEY, CLUSTER)
            .put(ZONE_ID_KEY, ZONE)
            .put(METHOD_KEY, "Bigtable.MutateRow")
            .put(CLIENT_NAME_KEY, CLIENT_NAME)
            .build();

    Duration actual = Duration.ofMillis(getAggregatedValue(clientLatency, attributes));
    assertThat(actual).isAtLeast(CHANNEL_BLOCKING_LATENCY.minus(proxyDelayPriorTest));
  }

  @Test
  public void testPermanentFailure() {
    try {
      Lists.newArrayList(stub.readRowsCallable().call(Query.create(BAD_TABLE_ID)).iterator());
      Assert.fail("Request should throw not found error");
    } catch (NotFoundException e) {
    }

    MetricData attemptLatency = getMetricData(metricReader, ATTEMPT_LATENCIES_NAME);

    Attributes expected =
        baseAttributes
            .toBuilder()
            .put(STATUS_KEY, "NOT_FOUND")
            .put(TABLE_ID_KEY, BAD_TABLE_ID)
            .put(CLUSTER_ID_KEY, "<unspecified>")
            .put(ZONE_ID_KEY, "global")
            .put(STREAMING_KEY, true)
            .put(METHOD_KEY, "Bigtable.ReadRows")
            .put(CLIENT_NAME_KEY, CLIENT_NAME)
            .build();

    verifyAttributes(attemptLatency, expected);

    MetricData opLatency = getMetricData(metricReader, OPERATION_LATENCIES_NAME);
    verifyAttributes(opLatency, expected);
  }

  @Test
  public void testRemainingDeadline() {
    stub.readRowsCallable().all().call(Query.create(TABLE));
    MetricData deadlineMetric = getMetricData(metricReader, REMAINING_DEADLINE_NAME);

    Attributes retryAttributes =
        baseAttributes
            .toBuilder()
            .put(STATUS_KEY, "UNAVAILABLE")
            .put(TABLE_ID_KEY, TABLE)
            .put(METHOD_KEY, "Bigtable.ReadRows")
            .put(ZONE_ID_KEY, "global")
            .put(CLUSTER_ID_KEY, "<unspecified>")
            .put(STREAMING_KEY, true)
            .put(CLIENT_NAME_KEY, CLIENT_NAME)
            .build();
    HistogramPointData retryHistogramPointData =
        deadlineMetric.getHistogramData().getPoints().stream()
            .filter(pd -> pd.getAttributes().equals(retryAttributes))
            .collect(Collectors.toList())
            .get(0);

    double retryRemainingDeadline = retryHistogramPointData.getSum();
    // The retry remaining deadline should be equivalent to the original timeout.
    assertThat(retryRemainingDeadline).isEqualTo(9000);

    Attributes okAttributes =
        baseAttributes
            .toBuilder()
            .put(STATUS_KEY, "OK")
            .put(TABLE_ID_KEY, TABLE)
            .put(ZONE_ID_KEY, ZONE)
            .put(CLUSTER_ID_KEY, CLUSTER)
            .put(METHOD_KEY, "Bigtable.ReadRows")
            .put(STREAMING_KEY, true)
            .put(CLIENT_NAME_KEY, CLIENT_NAME)
            .build();
    HistogramPointData okHistogramPointData =
        deadlineMetric.getHistogramData().getPoints().stream()
            .filter(pd -> pd.getAttributes().equals(okAttributes))
            .collect(Collectors.toList())
            .get(0);

    double okRemainingDeadline = okHistogramPointData.getSum();
    // first attempt latency + retry delay
    double expected = 9000 - SERVER_LATENCY - CHANNEL_BLOCKING_LATENCY.toMillis() - 10;
    assertThat(okRemainingDeadline).isIn(Range.closed(expected - 500, expected + 10));
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
      if (request.getTableName().contains(FIRST_RESPONSE_TABLE_ID)) {
        responseObserver.onNext(source.next());
        responseObserver.onNext(source.next());
        responseObserver.onCompleted();
        return;
      }
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

  class DelayProxyDetector implements ProxyDetector {
    private volatile Instant lastProxyDelay = null;

    @Nullable
    @Override
    public ProxiedSocketAddress proxyFor(SocketAddress socketAddress) throws IOException {
      lastProxyDelay = Instant.now();
      try {
        Thread.sleep(CHANNEL_BLOCKING_LATENCY.toMillis());
      } catch (InterruptedException e) {

      }
      return null;
    }

    Duration getCurrentDelayUsed() {
      Instant local = lastProxyDelay;
      // If the delay was never injected
      if (local == null) {
        return Duration.ZERO;
      }
      Duration duration = Duration.between(local, Instant.now());

      assertWithMessage("test burned through all channel blocking latency during setup")
          .that(duration)
          .isLessThan(CHANNEL_BLOCKING_LATENCY);

      return duration;
    }
  }
}
