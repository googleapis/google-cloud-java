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

package com.google.cloud.spanner;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import com.google.api.gax.core.GaxProperties;
import com.google.api.gax.grpc.GrpcCallContext;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ServerStream;
import com.google.api.gax.rpc.StatusCode.Code;
import com.google.api.gax.tracing.ApiTracerFactory;
import com.google.cloud.NoCredentials;
import com.google.cloud.grpc.GcpManagedChannel;
import com.google.cloud.spanner.SpannerOptions.CallContextConfigurator;
import com.google.cloud.spanner.SpannerOptions.SpannerCallContextTimeoutConfigurator;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.protobuf.Value;
import com.google.rpc.RetryInfo;
import com.google.spanner.v1.BatchWriteRequest;
import com.google.spanner.v1.BatchWriteResponse;
import com.google.spanner.v1.RequestOptions;
import com.google.spanner.v1.SpannerGrpc;
import io.grpc.CallOptions;
import io.grpc.Channel;
import io.grpc.ClientCall;
import io.grpc.ClientInterceptor;
import io.grpc.Context;
import io.grpc.ForwardingServerCall;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.Server;
import io.grpc.ServerCall;
import io.grpc.ServerCallHandler;
import io.grpc.ServerInterceptor;
import io.grpc.ServerInterceptors;
import io.grpc.Status;
import io.grpc.netty.shaded.io.grpc.netty.NettyServerBuilder;
import io.grpc.protobuf.ProtoUtils;
import io.opencensus.trace.Tracing;
import io.opentelemetry.api.OpenTelemetry;
import io.opentelemetry.api.common.AttributeKey;
import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.sdk.OpenTelemetrySdk;
import io.opentelemetry.sdk.metrics.SdkMeterProvider;
import io.opentelemetry.sdk.metrics.SdkMeterProviderBuilder;
import io.opentelemetry.sdk.metrics.data.LongPointData;
import io.opentelemetry.sdk.metrics.data.MetricData;
import io.opentelemetry.sdk.testing.exporter.InMemoryMetricReader;
import io.opentelemetry.sdk.testing.exporter.InMemorySpanExporter;
import io.opentelemetry.sdk.trace.SdkTracerProvider;
import io.opentelemetry.sdk.trace.data.EventData;
import io.opentelemetry.sdk.trace.data.SpanData;
import io.opentelemetry.sdk.trace.export.SimpleSpanProcessor;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.InetSocketAddress;
import java.time.Duration;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * End-to-end mock-server tests for {@link DatabaseClient#batchWriteAtLeastOnce} covering automatic
 * retry, transparent stream resumption, request IDs, custom stub settings, and built-in metrics.
 */
@RunWith(JUnit4.class)
public class BatchWriteRetryMockServerTest {

  private static final com.google.rpc.Status STATUS_OK =
      com.google.rpc.Status.newBuilder().setCode(com.google.rpc.Code.OK_VALUE).build();
  private static final com.google.rpc.Status STATUS_ABORTED =
      com.google.rpc.Status.newBuilder().setCode(com.google.rpc.Code.ABORTED_VALUE).build();

  private static final Metadata.Key<String> ROUTE_TO_LEADER_KEY =
      Metadata.Key.of("x-goog-spanner-route-to-leader", Metadata.ASCII_STRING_MARSHALLER);
  private static final Metadata.Key<String> SERVER_TIMING_KEY =
      Metadata.Key.of("server-timing", Metadata.ASCII_STRING_MARSHALLER);

  private static final List<MutationGroup> FOUR_GROUPS =
      ImmutableList.of(
          MutationGroup.of(Mutation.newInsertBuilder("T").set("K").to("k0").build()),
          MutationGroup.of(Mutation.newInsertBuilder("T").set("K").to("k1").build()),
          MutationGroup.of(Mutation.newInsertBuilder("T").set("K").to("k2").build()),
          MutationGroup.of(Mutation.newInsertBuilder("T").set("K").to("k3").build()));

  private MockSpannerServiceImpl mockSpanner;
  private Server server;
  private List<XGoogSpannerRequestId> capturedBatchWriteRequestIds;
  private List<String> capturedRouteToLeaderHeaders;
  private volatile String serverTimingHeaderToSend;
  private InMemoryMetricReader metricReader;
  private Map<String, String> clientMetricAttributes;
  private Spanner spanner;
  private DatabaseClient client;

  @Before
  public void setUp() throws Exception {
    mockSpanner = new MockSpannerServiceImpl();
    mockSpanner.setAbortProbability(0.0);
    capturedBatchWriteRequestIds = new CopyOnWriteArrayList<>();
    capturedRouteToLeaderHeaders = new CopyOnWriteArrayList<>();

    ServerInterceptor headerCaptureInterceptor =
        new ServerInterceptor() {
          @Override
          public <ReqT, RespT> ServerCall.Listener<ReqT> interceptCall(
              ServerCall<ReqT, RespT> call, Metadata headers, ServerCallHandler<ReqT, RespT> next) {
            if ("google.spanner.v1.Spanner/BatchWrite"
                .equals(call.getMethodDescriptor().getFullMethodName())) {
              String reqId = headers.get(XGoogSpannerRequestId.REQUEST_ID_HEADER_KEY);
              if (reqId != null) {
                capturedBatchWriteRequestIds.add(XGoogSpannerRequestId.of(reqId));
              }
              String rtl = headers.get(ROUTE_TO_LEADER_KEY);
              if (rtl != null) {
                capturedRouteToLeaderHeaders.add(rtl);
              }
              String serverTiming = serverTimingHeaderToSend;
              if (serverTiming != null) {
                return next.startCall(
                    new ForwardingServerCall.SimpleForwardingServerCall<ReqT, RespT>(call) {
                      @Override
                      public void sendHeaders(Metadata responseHeaders) {
                        responseHeaders.put(SERVER_TIMING_KEY, serverTiming);
                        super.sendHeaders(responseHeaders);
                      }
                    },
                    headers);
              }
            }
            return next.startCall(call, headers);
          }
        };

    InetSocketAddress address = new InetSocketAddress("localhost", 0);
    server =
        NettyServerBuilder.forAddress(address)
            .addService(ServerInterceptors.intercept(mockSpanner, headerCaptureInterceptor))
            .build()
            .start();

    clientMetricAttributes =
        ImmutableMap.of(
            BuiltInMetricsConstant.CLIENT_NAME_KEY.getKey(),
            "spanner-java/",
            BuiltInMetricsConstant.CLIENT_UID_KEY.getKey(),
            "test-uid",
            BuiltInMetricsConstant.PROJECT_ID_KEY.getKey(),
            "test-project",
            BuiltInMetricsConstant.DIRECT_PATH_ENABLED_KEY.getKey(),
            "false");

    spanner = createSpanner(fastRetrySettings(10));
    client = spanner.getDatabaseClient(DatabaseId.of("test-project", "i", "d"));
  }

  @After
  public void tearDown() throws Exception {
    serverTimingHeaderToSend = null;
    if (spanner != null) {
      spanner.close();
    }
    if (metricReader != null) {
      metricReader.close();
    }
    if (server != null) {
      server.shutdown();
      server.awaitTermination(10, TimeUnit.SECONDS);
    }
  }

  private Spanner createSpanner(RetrySettings batchWriteRetrySettings) throws IOException {
    if (metricReader != null) {
      metricReader.close();
    }
    metricReader = InMemoryMetricReader.create();
    SdkMeterProviderBuilder meterProvider =
        SdkMeterProvider.builder().registerMetricReader(metricReader);
    BuiltInMetricsConstant.getAllViews().forEach(meterProvider::registerView);
    OpenTelemetry openTelemetry =
        OpenTelemetrySdk.builder().setMeterProvider(meterProvider.build()).build();

    ApiTracerFactory metricsTracerFactory =
        new BuiltInMetricsTracerFactory(
            new BuiltInMetricsRecorder(openTelemetry, BuiltInMetricsConstant.METER_NAME),
            clientMetricAttributes,
            new TraceWrapper(
                Tracing.getTracer(),
                openTelemetry.getTracer(
                    MetricRegistryConstants.INSTRUMENTATION_SCOPE,
                    GaxProperties.getLibraryVersion(getClass())),
                true));

    SpannerOptions.Builder builder =
        SpannerOptions.newBuilder()
            .setProjectId("test-project")
            .setHost("http://localhost:" + server.getPort())
            .setChannelConfigurator(ManagedChannelBuilder::usePlaintext)
            .setCredentials(NoCredentials.getInstance())
            .setBuiltInMetricsEnabled(false)
            .setApiTracerFactory(metricsTracerFactory)
            .setNumChannels(2);
    builder
        .getSpannerStubSettingsBuilder()
        .batchWriteSettings()
        .setRetrySettings(batchWriteRetrySettings);
    return builder.build().getService();
  }

  private static RetrySettings fastRetrySettings(int maxAttempts) {
    return RetrySettings.newBuilder()
        .setInitialRetryDelayDuration(Duration.ofMillis(5))
        .setRetryDelayMultiplier(1.3)
        .setMaxRetryDelayDuration(Duration.ofMillis(20))
        .setMaxAttempts(maxAttempts)
        .setInitialRpcTimeoutDuration(Duration.ofSeconds(30))
        .setRpcTimeoutMultiplier(1.0)
        .setMaxRpcTimeoutDuration(Duration.ofSeconds(30))
        .setTotalTimeoutDuration(Duration.ofSeconds(30))
        .build();
  }

  @Test
  public void emptyMutationGroupsShortCircuitsWithZeroRpcs() {
    ServerStream<BatchWriteResponse> stream = client.batchWriteAtLeastOnce(Collections.emptyList());
    assertThat(ImmutableList.copyOf(stream)).isEmpty();
    assertThat(mockSpanner.getRequestsOfType(BatchWriteRequest.class)).isEmpty();
    assertThat(capturedBatchWriteRequestIds).isEmpty();
  }

  @Test
  public void retriesMidStreamUnavailableAndPrematureEofAndRecordsMetricsAndRequestIds() {
    AtomicInteger attempt = new AtomicInteger();
    mockSpanner.setBatchWriteHandler((request, responseObserver) -> {
      int current = attempt.incrementAndGet();
      if (current == 1) {
        // Attempt 1: ack index 0 (OK) and index 2 (ABORTED), then fail UNAVAILABLE.
        assertEquals(4, request.getMutationGroupsCount());
        responseObserver.onNext(
            BatchWriteResponse.newBuilder().setStatus(STATUS_OK).addIndexes(0).build());
        responseObserver.onNext(
            BatchWriteResponse.newBuilder().setStatus(STATUS_ABORTED).addIndexes(2).build());
        responseObserver.onError(Status.UNAVAILABLE.withDescription("reset").asRuntimeException());
      } else if (current == 2) {
        // Attempt 2: remaining are [k1, k3]. Ack relative index 1 (original 3), then premature EOF!
        assertEquals(2, request.getMutationGroupsCount());
        responseObserver.onNext(
            BatchWriteResponse.newBuilder().setStatus(STATUS_OK).addIndexes(1).build());
        responseObserver.onCompleted();
      } else {
        // Attempt 3: remaining is [k1]. Ack relative index 0 (original 1) and finish.
        assertEquals(1, request.getMutationGroupsCount());
        responseObserver.onNext(
            BatchWriteResponse.newBuilder().setStatus(STATUS_OK).addIndexes(0).build());
        responseObserver.onCompleted();
      }
    });

    ServerStream<BatchWriteResponse> stream =
        client.batchWriteAtLeastOnce(
            FOUR_GROUPS, Options.tag("bw-retry-tag"), Options.excludeTxnFromChangeStreams());
    List<BatchWriteResponse> responses = new ArrayList<>();
    for (BatchWriteResponse response : stream) {
      responses.add(response);
    }

    assertThat(responses).hasSize(4);
    assertThat(responses.get(0).getIndexesList()).containsExactly(0);
    assertEquals(STATUS_OK, responses.get(0).getStatus());
    assertThat(responses.get(1).getIndexesList()).containsExactly(2);
    assertEquals(STATUS_ABORTED, responses.get(1).getStatus());
    assertThat(responses.get(2).getIndexesList()).containsExactly(3);
    assertEquals(STATUS_OK, responses.get(2).getStatus());
    assertThat(responses.get(3).getIndexesList()).containsExactly(1);
    assertEquals(STATUS_OK, responses.get(3).getStatus());

    // Verify all 3 requests preserved metadata and carried route-to-leader header.
    List<BatchWriteRequest> requests = mockSpanner.getRequestsOfType(BatchWriteRequest.class);
    assertThat(requests).hasSize(3);
    for (BatchWriteRequest req : requests) {
      assertEquals("bw-retry-tag", req.getRequestOptions().getTransactionTag());
      assertTrue(req.getExcludeTxnFromChangeStreams());
    }
    assertThat(capturedRouteToLeaderHeaders).containsExactly("true", "true", "true");

    // Verify XGoogSpannerRequestId kept the same nth_request and incremented attempt 1 -> 2 -> 3.
    assertThat(capturedBatchWriteRequestIds).hasSize(3);
    long nthRequest = capturedBatchWriteRequestIds.get(0).getNthRequest();
    assertEquals(1L, capturedBatchWriteRequestIds.get(0).getAttempt());
    assertEquals(nthRequest, capturedBatchWriteRequestIds.get(1).getNthRequest());
    assertEquals(2L, capturedBatchWriteRequestIds.get(1).getAttempt());
    assertEquals(nthRequest, capturedBatchWriteRequestIds.get(2).getNthRequest());
    assertEquals(3L, capturedBatchWriteRequestIds.get(2).getAttempt());

    // Verify built-in metrics: 1 operation (OK), 3 attempts (2 UNAVAILABLE + 1 OK).
    Attributes okAttrs = expectedAttributes("OK");
    Attributes unavailableAttrs = expectedAttributes("UNAVAILABLE");

    MetricData opCount = getMetricData(BuiltInMetricsConstant.OPERATION_COUNT_NAME);
    assertEquals(1L, getLongSumValue(opCount, okAttrs));

    MetricData opLatency = getMetricData(BuiltInMetricsConstant.OPERATION_LATENCIES_NAME);
    assertTrue(hasHistogramPoint(opLatency, okAttrs));

    MetricData attemptCount = getMetricData(BuiltInMetricsConstant.ATTEMPT_COUNT_NAME);
    assertEquals(2L, getLongSumValue(attemptCount, unavailableAttrs));
    assertEquals(1L, getLongSumValue(attemptCount, okAttrs));

    MetricData attemptLatency = getMetricData(BuiltInMetricsConstant.ATTEMPT_LATENCIES_NAME);
    assertTrue(hasHistogramPoint(attemptLatency, unavailableAttrs));
    assertTrue(hasHistogramPoint(attemptLatency, okAttrs));
  }

  @Test
  public void earlyCancelRecordsCancelledOperationAndAttemptMetrics() throws Exception {
    CountDownLatch firstResponseSent = new CountDownLatch(1);
    mockSpanner.setBatchWriteHandler((request, responseObserver) -> {
      responseObserver.onNext(
          BatchWriteResponse.newBuilder().setStatus(STATUS_OK).addIndexes(0).build());
      firstResponseSent.countDown();
      // Intentionally keep stream open until client cancels.
    });

    ServerStream<BatchWriteResponse> stream = client.batchWriteAtLeastOnce(FOUR_GROUPS);
    Iterator<BatchWriteResponse> it = stream.iterator();
    assertTrue(firstResponseSent.await(5, TimeUnit.SECONDS));
    assertTrue(it.hasNext());
    assertThat(it.next().getIndexesList()).containsExactly(0);

    stream.cancel();
    assertFalse(it.hasNext());

    Attributes cancelledAttrs = expectedAttributes("CANCELLED");
    MetricData opCount =
        waitForMetricPoint(BuiltInMetricsConstant.OPERATION_COUNT_NAME, cancelledAttrs);
    assertEquals(1L, getLongSumValue(opCount, cancelledAttrs));

    MetricData attemptCount =
        waitForMetricPoint(BuiltInMetricsConstant.ATTEMPT_COUNT_NAME, cancelledAttrs);
    assertEquals(1L, getLongSumValue(attemptCount, cancelledAttrs));
  }

  @Test
  public void customMaxAttemptsOneDisablesRetries() throws Exception {
    spanner.close();
    spanner = createSpanner(fastRetrySettings(1));
    client = spanner.getDatabaseClient(DatabaseId.of("test-project", "i", "d"));

    mockSpanner.setBatchWriteHandler((request, responseObserver) ->
        responseObserver.onError(
            Status.UNAVAILABLE.withDescription("fail once").asRuntimeException()));

    ServerStream<BatchWriteResponse> stream = client.batchWriteAtLeastOnce(FOUR_GROUPS);
    ApiException ex = assertThrows(ApiException.class, () -> ImmutableList.copyOf(stream));
    assertEquals(Code.UNAVAILABLE, ex.getStatusCode().getCode());
    assertThat(mockSpanner.getRequestsOfType(BatchWriteRequest.class)).hasSize(1);
  }

  @Test
  public void abandonedStreamIsCancelledPromptlyOnSpannerClose() throws Exception {
    CountDownLatch streamOpened = new CountDownLatch(1);
    mockSpanner.setBatchWriteHandler((request, responseObserver) -> {
      responseObserver.onNext(
          BatchWriteResponse.newBuilder().setStatus(STATUS_OK).addIndexes(0).build());
      streamOpened.countDown();
      // Intentionally keep stream open; consumer abandons it without calling cancel().
    });

    client.batchWriteAtLeastOnce(FOUR_GROUPS);
    assertTrue(streamOpened.await(5, TimeUnit.SECONDS));

    long closeStartNanos = System.nanoTime();
    spanner.close();
    spanner = null;
    long closeElapsedMillis = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - closeStartNanos);

    // Must cancel the abandoned stream promptly rather than blocking for the 10s shutdown timeout.
    assertThat(closeElapsedMillis).isLessThan(5000L);

    Attributes cancelledAttrs = expectedAttributes("CANCELLED");
    MetricData opCount =
        waitForMetricPoint(BuiltInMetricsConstant.OPERATION_COUNT_NAME, cancelledAttrs);
    assertEquals(1L, getLongSumValue(opCount, cancelledAttrs));
  }

  @Test
  public void grpcGcpModeRotatesActualPhysicalChannelOnRetry() throws Exception {
    List<Integer> batchWriteChannelIds = new CopyOnWriteArrayList<>();
    SpannerOptions.Builder builder =
        SpannerOptions.newBuilder()
            .setProjectId("test-project")
            .setHost("http://localhost:" + server.getPort())
            .setCredentials(NoCredentials.getInstance())
            .setBuiltInMetricsEnabled(false)
            .enableGrpcGcpExtension()
            .setNumChannels(2)
            .setChannelConfigurator(channelBuilder ->
                channelBuilder
                    .usePlaintext()
                    .intercept(
                        new ClientInterceptor() {
                          @Override
                          public <ReqT, RespT> ClientCall<ReqT, RespT> interceptCall(
                              MethodDescriptor<ReqT, RespT> method,
                              CallOptions callOptions,
                              Channel next) {
                            if (SpannerGrpc.getBatchWriteMethod()
                                .getFullMethodName()
                                .equals(method.getFullMethodName())) {
                              Integer channelId =
                                  callOptions.getOption(GcpManagedChannel.CHANNEL_ID_KEY);
                              if (channelId != null) {
                                batchWriteChannelIds.add(channelId);
                              }
                            }
                            return next.newCall(method, callOptions);
                          }
                        }));
    builder
        .getSpannerStubSettingsBuilder()
        .batchWriteSettings()
        .setRetrySettings(fastRetrySettings(5));

    AtomicInteger attempt = new AtomicInteger();
    mockSpanner.setBatchWriteHandler((request, responseObserver) -> {
      if (attempt.incrementAndGet() == 1) {
        responseObserver.onError(
            Status.UNAVAILABLE.withDescription("channel failure").asRuntimeException());
      } else {
        for (int i = 0; i < request.getMutationGroupsCount(); i++) {
          responseObserver.onNext(
              BatchWriteResponse.newBuilder().setStatus(STATUS_OK).addIndexes(i).build());
        }
        responseObserver.onCompleted();
      }
    });

    try (Spanner grpcGcpSpanner = builder.build().getService()) {
      DatabaseClient grpcGcpClient =
          grpcGcpSpanner.getDatabaseClient(DatabaseId.of("test-project", "i", "d"));
      List<BatchWriteResponse> responses =
          ImmutableList.copyOf(grpcGcpClient.batchWriteAtLeastOnce(FOUR_GROUPS));
      assertThat(responses).hasSize(4);
    }

    assertThat(batchWriteChannelIds).hasSize(2);
    assertNotEquals(
        "Expected grpc-gcp retry to rotate away from the failed channel",
        batchWriteChannelIds.get(0),
        batchWriteChannelIds.get(1));
  }

  @Test
  public void nonGrpcGcpModeDoesNotLeakChannelUsageOrSingleUseCounters() throws Exception {
    SpannerOptions.Builder builder =
        SpannerOptions.newBuilder()
            .setProjectId("test-project")
            .setHost("http://localhost:" + server.getPort())
            .setChannelConfigurator(ManagedChannelBuilder::usePlaintext)
            .setCredentials(NoCredentials.getInstance())
            .setBuiltInMetricsEnabled(false)
            .disableGrpcGcpExtension()
            .setNumChannels(2);
    builder
        .getSpannerStubSettingsBuilder()
        .batchWriteSettings()
        .setRetrySettings(fastRetrySettings(5));

    mockSpanner.setBatchWriteHandler((request, responseObserver) -> {
      for (int i = 0; i < request.getMutationGroupsCount(); i++) {
        responseObserver.onNext(
            BatchWriteResponse.newBuilder().setStatus(STATUS_OK).addIndexes(i).build());
      }
      responseObserver.onCompleted();
    });

    try (Spanner nonGrpcGcpSpanner = builder.build().getService()) {
      DatabaseClient nonGrpcGcpClient =
          nonGrpcGcpSpanner.getDatabaseClient(DatabaseId.of("test-project", "i", "d"));

      // Run more BatchWrite calls than numChannels (2) to prove channelUsage and
      // numCurrentSingleUseTransactions are never leaked.
      for (int i = 0; i < 5; i++) {
        List<BatchWriteResponse> responses =
            ImmutableList.copyOf(nonGrpcGcpClient.batchWriteAtLeastOnce(FOUR_GROUPS));
        assertThat(responses).hasSize(4);
      }

      assertTrue(nonGrpcGcpClient instanceof DatabaseClientImpl);
      MultiplexedSessionDatabaseClient muxClient =
          ((DatabaseClientImpl) nonGrpcGcpClient).multiplexedSessionDatabaseClient;

      Field counterField =
          MultiplexedSessionDatabaseClient.class.getDeclaredField(
              "numCurrentSingleUseTransactions");
      counterField.setAccessible(true);
      AtomicInteger singleUseCounter = (AtomicInteger) counterField.get(muxClient);
      assertEquals(0, singleUseCounter.get());

      Field channelUsageField =
          MultiplexedSessionDatabaseClient.class.getDeclaredField("channelUsage");
      channelUsageField.setAccessible(true);
      BitSet channelUsage = (BitSet) channelUsageField.get(muxClient);
      synchronized (channelUsage) {
        assertEquals(0, channelUsage.cardinality());
      }
    }
  }

  @Test
  public void emptyRetryableCodesDisablesRetries() {
    SpannerOptions.Builder builder =
        SpannerOptions.newBuilder()
            .setProjectId("test-project")
            .setHost("http://localhost:" + server.getPort())
            .setChannelConfigurator(ManagedChannelBuilder::usePlaintext)
            .setCredentials(NoCredentials.getInstance())
            .setBuiltInMetricsEnabled(false);
    builder
        .getSpannerStubSettingsBuilder()
        .batchWriteSettings()
        .setRetryableCodes(Collections.emptySet());

    mockSpanner.setBatchWriteHandler((request, responseObserver) ->
        responseObserver.onError(
            Status.UNAVAILABLE.withDescription("should not retry").asRuntimeException()));

    try (Spanner noRetrySpanner = builder.build().getService()) {
      DatabaseClient noRetryClient =
          noRetrySpanner.getDatabaseClient(DatabaseId.of("test-project", "i", "d"));
      ServerStream<BatchWriteResponse> stream = noRetryClient.batchWriteAtLeastOnce(FOUR_GROUPS);
      ApiException ex = assertThrows(ApiException.class, () -> ImmutableList.copyOf(stream));
      assertEquals(Code.UNAVAILABLE, ex.getStatusCode().getCode());
    }
    assertThat(mockSpanner.getRequestsOfType(BatchWriteRequest.class)).hasSize(1);
  }

  @Test
  public void partialRetrySettingsOverridePreservesBatchWriteDefaults() {
    SpannerOptions.Builder builder =
        SpannerOptions.newBuilder()
            .setProjectId("test-project")
            .setCredentials(NoCredentials.getInstance());
    RetrySettings partialOverride =
        builder.getSpannerStubSettingsBuilder().batchWriteSettings().getRetrySettings().toBuilder()
            .setTotalTimeoutDuration(Duration.ofMinutes(5))
            .build();
    builder.getSpannerStubSettingsBuilder().batchWriteSettings().setRetrySettings(partialOverride);

    SpannerOptions options = builder.build();
    RetrySettings effective =
        options.getSpannerStubSettings().batchWriteSettings().getRetrySettings();
    assertEquals(Duration.ofMinutes(5), effective.getTotalTimeoutDuration());
    assertEquals(Duration.ofMillis(100), effective.getInitialRetryDelayDuration());
    assertEquals(1.3, effective.getRetryDelayMultiplier(), 0.0001);
    assertEquals(Duration.ofSeconds(60), effective.getMaxRetryDelayDuration());
    assertEquals(10, effective.getMaxAttempts());
    assertEquals(Duration.ofHours(1), effective.getInitialRpcTimeoutDuration());
    assertEquals(1.0, effective.getRpcTimeoutMultiplier(), 0.0001);
    assertEquals(Duration.ofHours(1), effective.getMaxRpcTimeoutDuration());
    assertThat(options.getSpannerStubSettings().batchWriteSettings().getRetryableCodes())
        .containsExactly(Code.UNAVAILABLE, Code.RESOURCE_EXHAUSTED);

    // Round-tripping through toBuilder() must preserve explicit empty retryableCodes.
    SpannerOptions.Builder rebuiltBuilder = options.toBuilder();
    rebuiltBuilder
        .getSpannerStubSettingsBuilder()
        .batchWriteSettings()
        .setRetryableCodes(Collections.emptySet());
    SpannerOptions rebuilt = rebuiltBuilder.build().toBuilder().build();
    assertThat(rebuilt.getSpannerStubSettings().batchWriteSettings().getRetryableCodes()).isEmpty();
  }

  private Spanner createTracingSpanner(InMemorySpanExporter spanExporter) {
    SdkTracerProvider tracerProvider =
        SdkTracerProvider.builder()
            .addSpanProcessor(SimpleSpanProcessor.create(spanExporter))
            .build();
    OpenTelemetry openTelemetry =
        OpenTelemetrySdk.builder().setTracerProvider(tracerProvider).build();
    SpannerOptions.Builder builder =
        SpannerOptions.newBuilder()
            .setProjectId("test-project")
            .setHost("http://localhost:" + server.getPort())
            .setChannelConfigurator(ManagedChannelBuilder::usePlaintext)
            .setCredentials(NoCredentials.getInstance())
            .setBuiltInMetricsEnabled(false)
            .setOpenTelemetry(openTelemetry)
            .setEnableApiTracing(false)
            .setNumChannels(2);
    builder
        .getSpannerStubSettingsBuilder()
        .batchWriteSettings()
        .setRetrySettings(fastRetrySettings(5));
    return builder.build().getService();
  }

  @Test
  public void tracingSpanCoversRetriesRecordsResumeEventAndServerTimingAttributes()
      throws Exception {
    SpannerOptions.resetActiveTracingFramework();
    SpannerOptions.enableOpenTelemetryTraces();
    InMemorySpanExporter spanExporter = InMemorySpanExporter.create();
    serverTimingHeaderToSend = "gfet4t7; dur=17, afe; dur=6";

    CountDownLatch attempt2Started = new CountDownLatch(1);
    CountDownLatch allowAttempt2Finish = new CountDownLatch(1);
    AtomicInteger attempt = new AtomicInteger();
    mockSpanner.setBatchWriteHandler((request, responseObserver) -> {
      if (attempt.incrementAndGet() == 1) {
        responseObserver.onNext(
            BatchWriteResponse.newBuilder().setStatus(STATUS_OK).addIndexes(0).build());
        responseObserver.onError(
            Status.UNAVAILABLE.withDescription("transient").asRuntimeException());
      } else {
        attempt2Started.countDown();
        try {
          assertTrue(allowAttempt2Finish.await(5, TimeUnit.SECONDS));
        } catch (InterruptedException e) {
          Thread.currentThread().interrupt();
        }
        for (int i = 0; i < request.getMutationGroupsCount(); i++) {
          responseObserver.onNext(
              BatchWriteResponse.newBuilder().setStatus(STATUS_OK).addIndexes(i).build());
        }
        responseObserver.onCompleted();
      }
    });

    try (Spanner tracingSpanner = createTracingSpanner(spanExporter)) {
      DatabaseClient tracingClient =
          tracingSpanner.getDatabaseClient(DatabaseId.of("test-project", "i", "d"));
      ServerStream<BatchWriteResponse> stream = tracingClient.batchWriteAtLeastOnce(FOUR_GROUPS);

      // Consume the first response (from attempt 1) and wait until retry attempt 2 is active.
      Iterator<BatchWriteResponse> it = stream.iterator();
      assertTrue(it.hasNext());
      assertThat(it.next().getIndexesList()).containsExactly(0);
      assertTrue(attempt2Started.await(5, TimeUnit.SECONDS));

      // Neither span may have ended prematurely while the stream and retries are still active.
      List<String> finishedMidStream =
          spanExporter.getFinishedSpanItems().stream()
              .map(SpanData::getName)
              .collect(Collectors.toList());
      assertThat(finishedMidStream).doesNotContain("CloudSpannerOperation.BatchWrite");
      assertThat(finishedMidStream).doesNotContain("CloudSpanner.ReadWriteTransaction");

      // Unblock attempt 2 and drain remaining responses.
      allowAttempt2Finish.countDown();
      List<Integer> remainingIndexes = new ArrayList<>();
      while (it.hasNext()) {
        remainingIndexes.addAll(it.next().getIndexesList());
      }
      assertThat(remainingIndexes).containsExactly(1, 2, 3);

      SpanData batchWriteSpan = findFinishedSpan(spanExporter, "CloudSpannerOperation.BatchWrite");
      SpanData txSpan = findFinishedSpan(spanExporter, "CloudSpanner.ReadWriteTransaction");
      assertEquals(txSpan.getSpanId(), batchWriteSpan.getParentSpanId());
      assertEquals(
          io.opentelemetry.api.trace.StatusCode.UNSET, batchWriteSpan.getStatus().getStatusCode());
      assertEquals(io.opentelemetry.api.trace.StatusCode.UNSET, txSpan.getStatus().getStatusCode());

      // Verify "Resuming BatchWrite stream" event was recorded on the retry attempt.
      EventData resumeEvent =
          batchWriteSpan.getEvents().stream()
              .filter(e -> "Resuming BatchWrite stream".equals(e.getName()))
              .findFirst()
              .orElse(null);
      assertNotNull("Expected Resuming BatchWrite stream span event", resumeEvent);
      assertEquals(
          Long.valueOf(2L), resumeEvent.getAttributes().get(AttributeKey.longKey("attempt")));
      assertEquals(
          Long.valueOf(3L),
          resumeEvent.getAttributes().get(AttributeKey.longKey("remaining_mutation_groups")));

      // Verify HeaderInterceptor recorded server-timing and request-id attributes on the open span.
      assertEquals(
          "17.0", batchWriteSpan.getAttributes().get(AttributeKey.stringKey("gfe_latency")));
      assertEquals(
          "6.0", batchWriteSpan.getAttributes().get(AttributeKey.stringKey("afe_latency")));
      assertNotNull(
          batchWriteSpan
              .getAttributes()
              .get(AttributeKey.stringKey(XGoogSpannerRequestId.REQUEST_ID_HEADER_NAME)));
    } finally {
      SpannerOptions.resetActiveTracingFramework();
    }
  }

  @Test
  public void tracingSpanRecordsTerminalErrorStatus() {
    SpannerOptions.resetActiveTracingFramework();
    SpannerOptions.enableOpenTelemetryTraces();
    InMemorySpanExporter spanExporter = InMemorySpanExporter.create();

    mockSpanner.setBatchWriteHandler((request, responseObserver) ->
        responseObserver.onError(
            Status.INVALID_ARGUMENT.withDescription("bad mutation").asRuntimeException()));

    try (Spanner tracingSpanner = createTracingSpanner(spanExporter)) {
      DatabaseClient tracingClient =
          tracingSpanner.getDatabaseClient(DatabaseId.of("test-project", "i", "d"));
      ServerStream<BatchWriteResponse> stream = tracingClient.batchWriteAtLeastOnce(FOUR_GROUPS);
      ApiException ex = assertThrows(ApiException.class, () -> ImmutableList.copyOf(stream));
      assertEquals(Code.INVALID_ARGUMENT, ex.getStatusCode().getCode());

      SpanData batchWriteSpan = findFinishedSpan(spanExporter, "CloudSpannerOperation.BatchWrite");
      SpanData txSpan = findFinishedSpan(spanExporter, "CloudSpanner.ReadWriteTransaction");
      assertEquals(
          io.opentelemetry.api.trace.StatusCode.ERROR, batchWriteSpan.getStatus().getStatusCode());
      assertEquals("INVALID_ARGUMENT", batchWriteSpan.getStatus().getDescription());
      assertEquals(io.opentelemetry.api.trace.StatusCode.ERROR, txSpan.getStatus().getStatusCode());
      assertEquals("INVALID_ARGUMENT", txSpan.getStatus().getDescription());
    } finally {
      SpannerOptions.resetActiveTracingFramework();
    }
  }

  @Test
  public void emptyMutationGroupsRecordsSpanWithZeroRpcs() {
    SpannerOptions.resetActiveTracingFramework();
    SpannerOptions.enableOpenTelemetryTraces();
    InMemorySpanExporter spanExporter = InMemorySpanExporter.create();

    try (Spanner tracingSpanner = createTracingSpanner(spanExporter)) {
      DatabaseClient tracingClient =
          tracingSpanner.getDatabaseClient(DatabaseId.of("test-project", "i", "d"));
      ServerStream<BatchWriteResponse> stream =
          tracingClient.batchWriteAtLeastOnce(Collections.emptyList());
      assertThat(ImmutableList.copyOf(stream)).isEmpty();
      assertThat(mockSpanner.getRequestsOfType(BatchWriteRequest.class)).isEmpty();

      SpanData txSpan = findFinishedSpan(spanExporter, "CloudSpanner.ReadWriteTransaction");
      assertEquals(io.opentelemetry.api.trace.StatusCode.UNSET, txSpan.getStatus().getStatusCode());
    } finally {
      SpannerOptions.resetActiveTracingFramework();
    }
  }

  @Test
  public void contextDeadlineExpirationRecordsDeadlineExceededInAttemptAndOperationMetrics()
      throws Exception {
    CountDownLatch streamOpened = new CountDownLatch(1);
    mockSpanner.setBatchWriteHandler((request, responseObserver) -> {
      streamOpened.countDown();
      // Keep stream open until gRPC context deadline expires.
    });

    ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
    Context.CancellableContext deadlineCtx =
        Context.current().withDeadlineAfter(150, TimeUnit.MILLISECONDS, scheduler);
    try {
      ServerStream<BatchWriteResponse> stream;
      Context prev = deadlineCtx.attach();
      try {
        stream = client.batchWriteAtLeastOnce(FOUR_GROUPS);
      } finally {
        deadlineCtx.detach(prev);
      }
      assertTrue(streamOpened.await(5, TimeUnit.SECONDS));

      ApiException ex = assertThrows(ApiException.class, () -> ImmutableList.copyOf(stream));
      assertEquals(Code.DEADLINE_EXCEEDED, ex.getStatusCode().getCode());

      Attributes deadlineAttrs = expectedAttributes("DEADLINE_EXCEEDED");
      Attributes cancelledAttrs = expectedAttributes("CANCELLED");

      MetricData opCount =
          waitForMetricPoint(BuiltInMetricsConstant.OPERATION_COUNT_NAME, deadlineAttrs);
      assertEquals(1L, getLongSumValue(opCount, deadlineAttrs));
      assertEquals(0L, getLongSumValue(opCount, cancelledAttrs));

      MetricData attemptCount =
          waitForMetricPoint(BuiltInMetricsConstant.ATTEMPT_COUNT_NAME, deadlineAttrs);
      assertEquals(1L, getLongSumValue(attemptCount, deadlineAttrs));
      assertEquals(0L, getLongSumValue(attemptCount, cancelledAttrs));
    } finally {
      deadlineCtx.close();
      scheduler.shutdownNow();
    }
  }

  @Test
  public void clientContextMergedWithDefaultAndPreservedAcrossRetries() {
    RequestOptions.ClientContext defaultClientContext =
        RequestOptions.ClientContext.newBuilder()
            .putSecureContext(
                "default_key", Value.newBuilder().setStringValue("default_val").build())
            .putSecureContext(
                "shared_key", Value.newBuilder().setStringValue("from_default").build())
            .build();
    RequestOptions.ClientContext rpcClientContext =
        RequestOptions.ClientContext.newBuilder()
            .putSecureContext("shared_key", Value.newBuilder().setStringValue("from_rpc").build())
            .putSecureContext("rpc_key", Value.newBuilder().setStringValue("rpc_val").build())
            .build();

    SpannerOptions.Builder builder =
        SpannerOptions.newBuilder()
            .setProjectId("test-project")
            .setHost("http://localhost:" + server.getPort())
            .setChannelConfigurator(ManagedChannelBuilder::usePlaintext)
            .setCredentials(NoCredentials.getInstance())
            .setBuiltInMetricsEnabled(false)
            .setDefaultClientContext(defaultClientContext);
    builder
        .getSpannerStubSettingsBuilder()
        .batchWriteSettings()
        .setRetrySettings(fastRetrySettings(5));

    AtomicInteger attempt = new AtomicInteger();
    mockSpanner.setBatchWriteHandler((request, responseObserver) -> {
      if (attempt.incrementAndGet() == 1) {
        responseObserver.onError(
            Status.UNAVAILABLE.withDescription("retry once").asRuntimeException());
      } else {
        for (int i = 0; i < request.getMutationGroupsCount(); i++) {
          responseObserver.onNext(
              BatchWriteResponse.newBuilder().setStatus(STATUS_OK).addIndexes(i).build());
        }
        responseObserver.onCompleted();
      }
    });

    try (Spanner ctxSpanner = builder.build().getService()) {
      DatabaseClient ctxClient =
          ctxSpanner.getDatabaseClient(DatabaseId.of("test-project", "i", "d"));
      List<BatchWriteResponse> responses =
          ImmutableList.copyOf(
              ctxClient.batchWriteAtLeastOnce(
                  FOUR_GROUPS,
                  Options.clientContext(rpcClientContext),
                  Options.excludeTxnFromChangeStreams()));
      assertThat(responses).hasSize(4);
    }

    List<BatchWriteRequest> requests = mockSpanner.getRequestsOfType(BatchWriteRequest.class);
    assertThat(requests).hasSize(2);
    for (BatchWriteRequest req : requests) {
      assertTrue(req.getExcludeTxnFromChangeStreams());
      RequestOptions.ClientContext actualContext = req.getRequestOptions().getClientContext();
      assertEquals(
          "default_val", actualContext.getSecureContextOrThrow("default_key").getStringValue());
      assertEquals(
          "from_rpc", actualContext.getSecureContextOrThrow("shared_key").getStringValue());
      assertEquals("rpc_val", actualContext.getSecureContextOrThrow("rpc_key").getStringValue());
    }
  }

  @Test
  public void singleUseIterableMutationGroupsIsTraversedOnlyOnce() {
    mockSpanner.setBatchWriteHandler((request, responseObserver) -> {
      for (int i = 0; i < request.getMutationGroupsCount(); i++) {
        responseObserver.onNext(
            BatchWriteResponse.newBuilder().setStatus(STATUS_OK).addIndexes(i).build());
      }
      responseObserver.onCompleted();
    });

    AtomicInteger iteratorCalls = new AtomicInteger();
    Iterable<MutationGroup> singlePass =
        () -> {
          if (iteratorCalls.incrementAndGet() > 1) {
            throw new IllegalStateException("Single-use Iterable traversed more than once");
          }
          return FOUR_GROUPS.iterator();
        };

    List<BatchWriteResponse> responses =
        ImmutableList.copyOf(client.batchWriteAtLeastOnce(singlePass));
    assertThat(responses).hasSize(4);
    assertEquals(1, iteratorCalls.get());
  }

  @Test
  public void perRpcCallContextConfiguratorOverridesRetrySettingsRetryableCodesAndTimeout()
      throws Exception {
    // 1. Override RetrySettings (maxAttempts=2) and retryableCodes (ABORTED) per RPC via
    // CALL_CONTEXT_CONFIGURATOR_KEY.
    AtomicInteger attempt = new AtomicInteger();
    mockSpanner.setBatchWriteHandler((request, responseObserver) -> {
      if (attempt.incrementAndGet() == 1) {
        responseObserver.onError(
            Status.ABORTED.withDescription("transient abort").asRuntimeException());
      } else {
        for (int i = 0; i < request.getMutationGroupsCount(); i++) {
          responseObserver.onNext(
              BatchWriteResponse.newBuilder().setStatus(STATUS_OK).addIndexes(i).build());
        }
        responseObserver.onCompleted();
      }
    });

    CallContextConfigurator retryOverride =
        new CallContextConfigurator() {
          @Override
          public <ReqT, RespT> ApiCallContext configure(
              ApiCallContext context, ReqT request, MethodDescriptor<ReqT, RespT> method) {
            if (method == SpannerGrpc.getBatchWriteMethod()) {
              return context
                  .withRetrySettings(fastRetrySettings(2))
                  .withRetryableCodes(ImmutableSet.of(Code.ABORTED));
            }
            return null;
          }
        };

    Context retryCtx =
        Context.current().withValue(SpannerOptions.CALL_CONTEXT_CONFIGURATOR_KEY, retryOverride);
    List<BatchWriteResponse> responses =
        retryCtx.call(() -> ImmutableList.copyOf(client.batchWriteAtLeastOnce(FOUR_GROUPS)));
    assertThat(responses).hasSize(4);
    assertEquals(2, attempt.get());

    // 2. Verify SpannerCallContextTimeoutConfigurator.withBatchWriteTimeoutDuration enforces
    // per-RPC timeout on a stalled stream.
    mockSpanner.setBatchWriteHandler((request, responseObserver) -> {
      // Intentionally stall until per-RPC timeout fires.
    });
    Context timeoutCtx =
        Context.current()
            .withValue(
                SpannerOptions.CALL_CONTEXT_CONFIGURATOR_KEY,
                SpannerCallContextTimeoutConfigurator.create()
                    .withBatchWriteTimeoutDuration(Duration.ofMillis(150)));
    ApiException timeoutEx =
        assertThrows(
            ApiException.class,
            () ->
                timeoutCtx.call(
                    () -> ImmutableList.copyOf(client.batchWriteAtLeastOnce(FOUR_GROUPS))));
    assertEquals(Code.DEADLINE_EXCEEDED, timeoutEx.getStatusCode().getCode());
  }

  @Test
  public void perRpcCallOptionsDeadlineFailsImmediatelyWhenRetryDelayExceedsDeadline() {
    Metadata.Key<RetryInfo> retryInfoKey = ProtoUtils.keyForProto(RetryInfo.getDefaultInstance());
    Metadata trailers = new Metadata();
    trailers.put(
        retryInfoKey,
        RetryInfo.newBuilder()
            .setRetryDelay(com.google.protobuf.Duration.newBuilder().setSeconds(60).build())
            .build());
    mockSpanner.setBatchWriteHandler((request, responseObserver) ->
        responseObserver.onError(
            Status.RESOURCE_EXHAUSTED.withDescription("throttled").asRuntimeException(trailers)));

    CallContextConfigurator deadlineConfigurator =
        new CallContextConfigurator() {
          @Override
          public <ReqT, RespT> ApiCallContext configure(
              ApiCallContext context, ReqT request, MethodDescriptor<ReqT, RespT> method) {
            if (method == SpannerGrpc.getBatchWriteMethod()) {
              return GrpcCallContext.createDefault()
                  .withCallOptions(CallOptions.DEFAULT.withDeadlineAfter(3, TimeUnit.SECONDS));
            }
            return null;
          }
        };

    Context ctx =
        Context.current()
            .withValue(SpannerOptions.CALL_CONTEXT_CONFIGURATOR_KEY, deadlineConfigurator);
    long startNanos = System.nanoTime();
    ApiException ex =
        assertThrows(
            ApiException.class,
            () -> ctx.call(() -> ImmutableList.copyOf(client.batchWriteAtLeastOnce(FOUR_GROUPS))));
    long elapsedMillis = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startNanos);

    assertEquals(Code.DEADLINE_EXCEEDED, ex.getStatusCode().getCode());
    assertThat(elapsedMillis).isLessThan(2000L);
    assertThat(mockSpanner.getRequestsOfType(BatchWriteRequest.class)).hasSize(1);
  }

  @Test
  public void preCancelledContextSkipsAttemptMetricsAndPopulatesOperationResourceAttributes() {
    Context.CancellableContext cancelledCtx = Context.current().withCancellation();
    cancelledCtx.cancel(null);
    try {
      ServerStream<BatchWriteResponse> stream;
      Context prev = cancelledCtx.attach();
      try {
        stream = client.batchWriteAtLeastOnce(FOUR_GROUPS);
      } finally {
        cancelledCtx.detach(prev);
      }
      ApiException ex = assertThrows(ApiException.class, () -> ImmutableList.copyOf(stream));
      assertEquals(Code.CANCELLED, ex.getStatusCode().getCode());
    } finally {
      cancelledCtx.close();
    }

    assertThat(mockSpanner.getRequestsOfType(BatchWriteRequest.class)).isEmpty();

    Attributes cancelledAttrs = expectedAttributes("CANCELLED");
    MetricData opCount =
        waitForMetricPoint(BuiltInMetricsConstant.OPERATION_COUNT_NAME, cancelledAttrs);
    assertEquals(1L, getLongSumValue(opCount, cancelledAttrs));

    // No RPC ever hit the wire, so no BatchWrite attempt or gfe_header_missing_count metric should
    // be recorded.
    for (MetricData md : metricReader.collectAllMetrics()) {
      if (md.getName()
          .equals(
              BuiltInMetricsConstant.METER_NAME
                  + "/"
                  + BuiltInMetricsConstant.ATTEMPT_COUNT_NAME)) {
        for (LongPointData point : md.getLongSumData().getPoints()) {
          assertNotEquals(
              "Expected no BatchWrite attempt metric for pre-cancelled context",
              "Spanner.BatchWrite",
              point.getAttributes().get(BuiltInMetricsConstant.METHOD_KEY));
        }
      }
      if (md.getName()
          .equals(
              BuiltInMetricsConstant.METER_NAME
                  + "/"
                  + BuiltInMetricsConstant.GFE_CONNECTIVITY_ERROR_NAME)) {
        for (LongPointData point : md.getLongSumData().getPoints()) {
          assertNotEquals(
              "Expected no BatchWrite gfe_connectivity_error_count for pre-cancelled context",
              "Spanner.BatchWrite",
              point.getAttributes().get(BuiltInMetricsConstant.METHOD_KEY));
        }
      }
    }
  }

  @Test
  public void corruptedIndexOnAttemptZeroFlushesAttemptAndOperationMetricsWithFullAttributes() {
    serverTimingHeaderToSend = "gfet4t7; dur=14";
    mockSpanner.setBatchWriteHandler((request, responseObserver) -> {
      // Emit out-of-bounds index 99 and keep stream open so client cancellation drives onClose.
      responseObserver.onNext(
          BatchWriteResponse.newBuilder().setStatus(STATUS_OK).addIndexes(99).build());
    });

    ServerStream<BatchWriteResponse> stream = client.batchWriteAtLeastOnce(FOUR_GROUPS);
    ApiException ex = assertThrows(ApiException.class, () -> ImmutableList.copyOf(stream));
    assertEquals(Code.INTERNAL, ex.getStatusCode().getCode());

    Attributes internalAttrs = expectedAttributes("INTERNAL");
    MetricData opCount =
        waitForMetricPoint(BuiltInMetricsConstant.OPERATION_COUNT_NAME, internalAttrs);
    assertEquals(1L, getLongSumValue(opCount, internalAttrs));

    MetricData attemptCount =
        waitForMetricPoint(BuiltInMetricsConstant.ATTEMPT_COUNT_NAME, internalAttrs);
    assertEquals(1L, getLongSumValue(attemptCount, internalAttrs));

    MetricData gfeLatency = getMetricData(BuiltInMetricsConstant.GFE_LATENCIES_NAME);
    assertTrue(hasHistogramPoint(gfeLatency, internalAttrs));
  }

  @Test
  public void mutableListClearedDuringDelayedSessionCreationDoesNotAffectBatchWriteOrLeakSpan()
      throws Exception {
    // Verify materializeMutationGroups defensively copies mutable lists, avoids extra copies for
    // ImmutableList, and handles null.
    assertTrue(SessionImpl.materializeMutationGroups(null).isEmpty());
    assertSame(FOUR_GROUPS, SessionImpl.materializeMutationGroups(FOUR_GROUPS));
    List<MutationGroup> mutableCopy = new ArrayList<>(FOUR_GROUPS);
    List<MutationGroup> materialized = SessionImpl.materializeMutationGroups(mutableCopy);
    mutableCopy.clear();
    assertEquals(4, materialized.size());

    SpannerOptions.resetActiveTracingFramework();
    SpannerOptions.enableOpenTelemetryTraces();
    InMemorySpanExporter spanExporter = InMemorySpanExporter.create();

    mockSpanner.setBatchWriteHandler((request, responseObserver) -> {
      for (int i = 0; i < request.getMutationGroupsCount(); i++) {
        responseObserver.onNext(
            BatchWriteResponse.newBuilder().setStatus(STATUS_OK).addIndexes(i).build());
      }
      responseObserver.onCompleted();
    });

    CountDownLatch materializedLatch = new CountDownLatch(1);
    List<MutationGroup> callerMutableList =
        new ArrayList<MutationGroup>(FOUR_GROUPS) {
          @Override
          public Object[] toArray() {
            Object[] result = super.toArray();
            materializedLatch.countDown();
            return result;
          }

          @Override
          public Iterator<MutationGroup> iterator() {
            materializedLatch.countDown();
            return super.iterator();
          }
        };

    ExecutorService executor = Executors.newSingleThreadExecutor();
    mockSpanner.freeze();
    try (Spanner tracingSpanner = createTracingSpanner(spanExporter)) {
      DatabaseClient tracingClient =
          tracingSpanner.getDatabaseClient(DatabaseId.of("test-project", "i", "d"));

      Future<List<BatchWriteResponse>> future =
          executor.submit(
              () -> ImmutableList.copyOf(tracingClient.batchWriteAtLeastOnce(callerMutableList)));

      assertTrue(materializedLatch.await(5, TimeUnit.SECONDS));
      // Mutate and clear the caller's list while initial session creation is still blocked.
      callerMutableList.clear();
      mockSpanner.unfreeze();

      List<BatchWriteResponse> responses = future.get(10, TimeUnit.SECONDS);
      assertThat(responses).hasSize(4);

      List<BatchWriteRequest> requests = mockSpanner.getRequestsOfType(BatchWriteRequest.class);
      assertThat(requests).hasSize(1);
      assertEquals(4, requests.get(0).getMutationGroupsCount());

      SpanData batchWriteSpan = findFinishedSpan(spanExporter, "CloudSpannerOperation.BatchWrite");
      SpanData txSpan = findFinishedSpan(spanExporter, "CloudSpanner.ReadWriteTransaction");
      assertEquals(txSpan.getSpanId(), batchWriteSpan.getParentSpanId());
    } finally {
      mockSpanner.unfreeze();
      executor.shutdownNow();
      SpannerOptions.resetActiveTracingFramework();
    }
  }

  private static SpanData findFinishedSpan(InMemorySpanExporter spanExporter, String spanName) {
    return spanExporter.getFinishedSpanItems().stream()
        .filter(s -> spanName.equals(s.getName()))
        .findFirst()
        .orElseThrow(() ->
            new AssertionError(
                "Expected span '"
                    + spanName
                    + "', found: "
                    + spanExporter.getFinishedSpanItems().stream()
                        .map(SpanData::getName)
                        .collect(Collectors.toList())));
  }

  private Attributes expectedAttributes(String status) {
    return Attributes.builder()
        .put(BuiltInMetricsConstant.PROJECT_ID_KEY, "test-project")
        .put(BuiltInMetricsConstant.CLIENT_NAME_KEY, "spanner-java/")
        .put(BuiltInMetricsConstant.CLIENT_UID_KEY, "test-uid")
        .put(BuiltInMetricsConstant.INSTANCE_ID_KEY, "i")
        .put(BuiltInMetricsConstant.DATABASE_KEY, "d")
        .put(BuiltInMetricsConstant.DIRECT_PATH_ENABLED_KEY, "false")
        .put(BuiltInMetricsConstant.DIRECT_PATH_USED_KEY, "false")
        .put(BuiltInMetricsConstant.METHOD_KEY, "Spanner.BatchWrite")
        .put(BuiltInMetricsConstant.STATUS_KEY, status)
        .build();
  }

  private MetricData waitForMetricPoint(String metricName, Attributes expected) {
    String fullMetricName = BuiltInMetricsConstant.METER_NAME + "/" + metricName;
    for (int i = 0; i < 1000; i++) {
      Collection<MetricData> allMetrics = metricReader.collectAllMetrics();
      for (MetricData md : allMetrics) {
        if (md.getName().equals(fullMetricName) && getLongSumValue(md, expected) > 0) {
          return md;
        }
      }
      try {
        Thread.sleep(5);
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
        throw new RuntimeException(e);
      }
    }
    fail("MetricData point missing for " + fullMetricName + " with attributes " + expected);
    return null;
  }

  private MetricData getMetricData(String metricName) {
    String fullMetricName = BuiltInMetricsConstant.METER_NAME + "/" + metricName;
    for (int i = 0; i < 1000; i++) {
      Collection<MetricData> allMetrics = metricReader.collectAllMetrics();
      List<MetricData> matches =
          allMetrics.stream()
              .filter(md -> md.getName().equals(fullMetricName))
              .collect(Collectors.toList());
      if (!matches.isEmpty()) {
        assertNotNull(matches.get(0));
        return matches.get(0);
      }
      try {
        Thread.sleep(2);
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
        throw new RuntimeException(e);
      }
    }
    fail("MetricData missing for " + fullMetricName);
    return null;
  }

  private static long getLongSumValue(MetricData metricData, Attributes expected) {
    return metricData.getLongSumData().getPoints().stream()
        .filter(pd -> pd.getAttributes().equals(expected))
        .map(LongPointData::getValue)
        .findFirst()
        .orElse(0L);
  }

  private static boolean hasHistogramPoint(MetricData metricData, Attributes expected) {
    return metricData.getHistogramData().getPoints().stream()
        .anyMatch(pd -> pd.getAttributes().equals(expected) && pd.getCount() > 0);
  }
}
