/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.bigtable.data.v2.internal.csm.tracers;

import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth.assertWithMessage;
import static com.google.common.truth.extensions.proto.ProtoTruth.assertThat;

import com.google.api.gax.tracing.BaseApiTracerFactory;
import com.google.bigtable.v2.CloseSessionRequest;
import com.google.bigtable.v2.ClusterInformation;
import com.google.bigtable.v2.ErrorResponse;
import com.google.bigtable.v2.OpenFakeSessionRequest;
import com.google.bigtable.v2.OpenFakeSessionRequest.Action;
import com.google.bigtable.v2.OpenFakeSessionRequest.ActionList;
import com.google.bigtable.v2.OpenSessionRequest;
import com.google.bigtable.v2.OpenSessionResponse;
import com.google.bigtable.v2.SessionFakeScriptedRequest;
import com.google.bigtable.v2.SessionFakeScriptedResponse;
import com.google.bigtable.v2.SessionRequestStats;
import com.google.bigtable.v2.VirtualRpcResponse;
import com.google.cloud.bigtable.data.v2.internal.api.InstanceName;
import com.google.cloud.bigtable.data.v2.internal.api.UnaryResponseFuture;
import com.google.cloud.bigtable.data.v2.internal.channels.ChannelPool;
import com.google.cloud.bigtable.data.v2.internal.channels.SingleChannelPool;
import com.google.cloud.bigtable.data.v2.internal.csm.MetricRegistry;
import com.google.cloud.bigtable.data.v2.internal.csm.MetricRegistry.RecorderRegistry;
import com.google.cloud.bigtable.data.v2.internal.csm.MetricsImpl;
import com.google.cloud.bigtable.data.v2.internal.csm.attributes.ClientInfo;
import com.google.cloud.bigtable.data.v2.internal.csm.attributes.MethodInfo;
import com.google.cloud.bigtable.data.v2.internal.middleware.RetryingVRpc;
import com.google.cloud.bigtable.data.v2.internal.middleware.VRpc;
import com.google.cloud.bigtable.data.v2.internal.session.FakeDescriptor;
import com.google.cloud.bigtable.data.v2.internal.session.Session;
import com.google.cloud.bigtable.data.v2.internal.session.SessionFactory;
import com.google.cloud.bigtable.data.v2.internal.session.SessionImpl;
import com.google.cloud.bigtable.data.v2.internal.session.SessionPoolInfo;
import com.google.cloud.bigtable.data.v2.internal.session.fake.FakeServiceBuilder;
import com.google.cloud.bigtable.data.v2.internal.session.fake.FakeSessionListener;
import com.google.cloud.bigtable.data.v2.internal.session.fake.FakeSessionService;
import com.google.cloud.bigtable.data.v2.internal.session.fake.PeerInfoInterceptor;
import com.google.common.base.Stopwatch;
import com.google.common.base.Suppliers;
import com.google.common.collect.Range;
import com.google.common.truth.Correspondence;
import com.google.protobuf.ByteString;
import com.google.protobuf.util.Durations;
import com.google.rpc.Code;
import com.google.rpc.RetryInfo;
import io.grpc.CallOptions;
import io.grpc.Deadline;
import io.grpc.Grpc;
import io.grpc.InsecureChannelCredentials;
import io.grpc.Metadata;
import io.grpc.Server;
import io.opencensus.stats.Stats;
import io.opencensus.tags.Tags;
import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.sdk.OpenTelemetrySdk;
import io.opentelemetry.sdk.metrics.SdkMeterProvider;
import io.opentelemetry.sdk.metrics.data.HistogramPointData;
import io.opentelemetry.sdk.metrics.data.LongPointData;
import io.opentelemetry.sdk.metrics.data.MetricData;
import io.opentelemetry.sdk.testing.exporter.InMemoryMetricReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import javax.annotation.Nullable;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class VRpcTracerTest {
  private static final Correspondence<MetricData, String> METRIC_DATA_BY_NAME =
      Correspondence.transforming(MetricData::getName, "MetricData name");

  private ScheduledExecutorService executor;

  private Server server;
  private ChannelPool channelPool;
  private SessionPoolInfo poolInfo;

  private MetricRegistry metricRegistry;
  private RecorderRegistry recorderRegistry;
  private InMemoryMetricReader metricReader;
  private MetricsImpl metrics;
  private Session session;
  private final FakeSessionListener sessionListener = new FakeSessionListener();

  private final String clusterId = "fake-cluster";
  private final String zoneId = "us-east1-a";

  @BeforeEach
  void setUp() throws IOException {
    executor = Executors.newScheduledThreadPool(4);
    server =
        FakeServiceBuilder.create(new FakeSessionService(executor))
            .intercept(new PeerInfoInterceptor())
            .start();
    channelPool =
        new SingleChannelPool(
            Suppliers.ofInstance(
                Grpc.newChannelBuilderForAddress(
                        "localhost", server.getPort(), InsecureChannelCredentials.create())
                    .build()));
    channelPool.start();
    ClientInfo clientInfo =
        ClientInfo.builder()
            .setAppProfileId("default")
            .setInstanceName(InstanceName.parse("projects/fake-project/instances/fake-instance"))
            .build();
    poolInfo = SessionPoolInfo.create(clientInfo, FakeDescriptor.FAKE_SESSION, "fake-pool");

    metricReader = InMemoryMetricReader.create();
    OpenTelemetrySdk otel =
        OpenTelemetrySdk.builder()
            .setMeterProvider(SdkMeterProvider.builder().registerMetricReader(metricReader).build())
            .build();

    metricRegistry = new MetricRegistry();
    recorderRegistry = metricRegistry.newInternalRecorderRegistry(otel.getMeterProvider());

    metrics =
        new MetricsImpl(
            metricRegistry,
            clientInfo,
            BaseApiTracerFactory.getInstance(),
            otel,
            null,
            Tags.getTagger(),
            Stats.getStatsRecorder(),
            executor);

    // TODO: extract this out to a SimpleSessionPoolImpl that simply wraps a single Session
    SessionFactory sessionFactory =
        new SessionFactory(
            channelPool, FakeDescriptor.FAKE_SESSION.getMethodDescriptor(), CallOptions.DEFAULT);
    session = new SessionImpl(metrics, poolInfo, 0, sessionFactory.createNew());
  }

  @AfterEach
  void tearDown() {
    if (session != null) {
      session.close(
          CloseSessionRequest.newBuilder()
              .setReason(CloseSessionRequest.CloseSessionReason.CLOSE_SESSION_REASON_USER)
              .setDescription("test closed session")
              .build());
    }
    channelPool.close();
    metrics.close();
    server.shutdownNow();
    executor.shutdownNow();
  }

  @Test
  public void operationLatencyTest() throws Exception {
    // Set up a session to return 1 error response with a retry delay and 1 vrpc response.
    com.google.protobuf.Duration retryDelay = Durations.fromMillis(50);
    OpenSessionRequest openSessionRequest =
        OpenSessionRequest.newBuilder()
            .setPayload(
                OpenFakeSessionRequest.newBuilder()
                    .putVrpcActions(
                        0,
                        ActionList.newBuilder()
                            .addActions(createErrorResponse(Code.UNAVAILABLE_VALUE, retryDelay, 1))
                            .addActions(createResponse(2, clusterId, zoneId))
                            .build())
                    .build()
                    .toByteString())
            .build();
    session.start(openSessionRequest, new Metadata(), sessionListener);
    sessionListener.popUntil(OpenSessionResponse.class);

    // Test
    CompletableFuture<?> opFinished = new CompletableFuture<>();
    Stopwatch stopwatch = Stopwatch.createStarted();
    RetryingVRpc<SessionFakeScriptedRequest, SessionFakeScriptedResponse> retrying =
        new RetryingVRpc<>(() -> session.newCall(FakeDescriptor.SCRIPTED), executor);
    UnaryResponseFuture<SessionFakeScriptedResponse> userFuture = new UnaryResponseFuture<>();
    MethodInfo methodInfo =
        MethodInfo.builder().setName("Bigtable.ReadRow").setStreaming(false).build();
    VRpcTracer tracer =
        new VRpcTracerImpl(
            recorderRegistry, poolInfo, methodInfo, Deadline.after(1, TimeUnit.MINUTES)) {
          @Override
          public void onOperationFinish(VRpc.VRpcResult result) {
            super.onOperationFinish(result);
            // operation finished is called after listener.close() which means that userFuture gets
            // resolved before tracer.onOperationFinish is called. Set a opFinished future here so
            // the elapsed time includes everything.
            opFinished.complete(null);
          }
        };
    retrying.start(
        SessionFakeScriptedRequest.newBuilder().setTag(0).build(),
        VRpc.VRpcCallContext.create(Deadline.after(1, TimeUnit.MINUTES), true, tracer),
        userFuture);
    SessionFakeScriptedResponse response = userFuture.get();
    assertThat(response).isEqualToDefaultInstance();
    opFinished.get();
    long maxOpLatency = stopwatch.elapsed(TimeUnit.MILLISECONDS);

    long operationLatencies =
        getMetricValue(
            metricReader,
            "bigtable.googleapis.com/internal/client/operation_latencies",
            Attributes.empty());

    assertThat(operationLatencies).isIn(Range.closed(Durations.toMillis(retryDelay), maxOpLatency));
  }

  @Test
  public void attemptLatencyTest() throws Exception {
    // Set up a session that returns an error response with a retry delay and a vrpc response.
    com.google.protobuf.Duration retryDelay = Durations.fromMillis(50);
    OpenSessionRequest openSessionRequest =
        OpenSessionRequest.newBuilder()
            .setPayload(
                OpenFakeSessionRequest.newBuilder()
                    .putVrpcActions(
                        0,
                        ActionList.newBuilder()
                            .addActions(createErrorResponse(Code.UNAVAILABLE_VALUE, retryDelay, 1))
                            .addActions(createResponse(2, clusterId, zoneId))
                            .build())
                    .build()
                    .toByteString())
            .build();
    session.start(openSessionRequest, new Metadata(), sessionListener);
    sessionListener.popUntil(OpenSessionResponse.class);

    // Test
    Stopwatch stopwatch = Stopwatch.createStarted();
    AtomicLong maxAttemptLatency = new AtomicLong();
    DelayedVRpc<SessionFakeScriptedRequest, SessionFakeScriptedResponse> delayedVRpc =
        new DelayedVRpc<>(
            () -> new RetryingVRpc<>(() -> session.newCall(FakeDescriptor.SCRIPTED), executor));
    UnaryResponseFuture<SessionFakeScriptedResponse> userFuture = new UnaryResponseFuture<>();
    MethodInfo methodInfo =
        MethodInfo.builder().setName("Bigtable.ReadRow").setStreaming(false).build();
    VRpcTracer tracer =
        new VRpcTracerImpl(
            recorderRegistry, poolInfo, methodInfo, Deadline.after(1, TimeUnit.MINUTES)) {
          @Override
          public void onAttemptFinish(VRpc.VRpcResult result) {
            super.onAttemptFinish(result);
            if (!result.getStatus().isOk()) {
              maxAttemptLatency.set(stopwatch.elapsed(TimeUnit.MILLISECONDS));
            }
          }
        };
    delayedVRpc.start(
        SessionFakeScriptedRequest.newBuilder().setTag(0).build(),
        VRpc.VRpcCallContext.create(Deadline.after(1, TimeUnit.MINUTES), true, tracer),
        userFuture);

    long sessionDelay = 5L;
    Thread.sleep(sessionDelay);
    delayedVRpc.execute();

    SessionFakeScriptedResponse response = userFuture.get();
    assertThat(response).isEqualToDefaultInstance();

    long firstAttemptLatency =
        getMetricValue(
            metricReader,
            "bigtable.googleapis.com/internal/client/attempt_latencies",
            Attributes.builder().put("status", Code.UNAVAILABLE.name()).build());
    assertThat(firstAttemptLatency).isIn(Range.closed(sessionDelay, maxAttemptLatency.get()));
  }

  @Test
  public void retryCountTest() throws Exception {
    //  Set up a session to return 2 error responses and a VRpc response.
    com.google.protobuf.Duration retryDelay = Durations.fromMillis(0);
    OpenSessionRequest openSessionRequest =
        OpenSessionRequest.newBuilder()
            .setPayload(
                OpenFakeSessionRequest.newBuilder()
                    .putVrpcActions(
                        0,
                        ActionList.newBuilder()
                            .addActions(createErrorResponse(Code.UNAVAILABLE_VALUE, retryDelay, 1))
                            .addActions(createErrorResponse(Code.UNAVAILABLE_VALUE, retryDelay, 2))
                            .addActions(createResponse(3, clusterId, zoneId))
                            .build())
                    .build()
                    .toByteString())
            .build();
    session.start(openSessionRequest, new Metadata(), sessionListener);
    sessionListener.popUntil(OpenSessionResponse.class);

    // Test
    RetryingVRpc<SessionFakeScriptedRequest, SessionFakeScriptedResponse> retrying =
        new RetryingVRpc<>(() -> session.newCall(FakeDescriptor.SCRIPTED), executor);
    UnaryResponseFuture<SessionFakeScriptedResponse> f = new UnaryResponseFuture<>();
    CompletableFuture<?> opFinished = new CompletableFuture<>();
    MethodInfo methodInfo =
        MethodInfo.builder().setName("Bigtable.ReadRow").setStreaming(false).build();
    VRpcTracer tracer =
        new VRpcTracerImpl(
            recorderRegistry, poolInfo, methodInfo, Deadline.after(1, TimeUnit.MINUTES)) {
          @Override
          public void onOperationFinish(VRpc.VRpcResult result) {
            super.onOperationFinish(result);
            opFinished.complete(null);
          }
        };
    retrying.start(
        SessionFakeScriptedRequest.newBuilder().setTag(0).build(),
        VRpc.VRpcCallContext.create(Deadline.after(1, TimeUnit.MINUTES), true, tracer),
        f);
    SessionFakeScriptedResponse response = f.get();
    assertThat(response).isEqualToDefaultInstance();
    opFinished.get();

    long retryCount =
        getMetricValue(
            metricReader,
            "bigtable.googleapis.com/internal/client/retry_count",
            Attributes.empty());
    assertThat(retryCount).isEqualTo(2);
  }

  @Test
  public void clientBlockingLatencySessionDelayTest() throws Exception {
    // Set up a session that returns a VRpc response after a fake delay
    FakeSessionListener sessionListener = new FakeSessionListener();
    OpenSessionRequest openSessionRequest =
        OpenSessionRequest.newBuilder()
            .setPayload(
                OpenFakeSessionRequest.newBuilder()
                    .putVrpcActions(
                        0,
                        ActionList.newBuilder()
                            .addActions(createResponse(1, clusterId, zoneId))
                            .build())
                    .build()
                    .toByteString())
            .build();
    session.start(openSessionRequest, new Metadata(), sessionListener);

    // Test
    DelayedVRpc<SessionFakeScriptedRequest, SessionFakeScriptedResponse> delayedVRpc =
        new DelayedVRpc<>(
            () -> new RetryingVRpc<>(() -> session.newCall(FakeDescriptor.SCRIPTED), executor));
    UnaryResponseFuture<SessionFakeScriptedResponse> f = new UnaryResponseFuture<>();
    CompletableFuture<?> attemptFinished = new CompletableFuture<>();
    MethodInfo methodInfo =
        MethodInfo.builder().setName("Bigtable.ReadRow").setStreaming(false).build();
    VRpcTracer tracer =
        new VRpcTracerImpl(
            recorderRegistry, poolInfo, methodInfo, Deadline.after(1, TimeUnit.MINUTES)) {
          @Override
          public void onAttemptFinish(VRpc.VRpcResult result) {
            super.onAttemptFinish(result);
            attemptFinished.complete(null);
          }
        };
    assertThat(sessionListener.popNext(Duration.ofSeconds(2)))
        .isInstanceOf(OpenSessionResponse.class);

    delayedVRpc.start(
        SessionFakeScriptedRequest.newBuilder().setTag(0).build(),
        VRpc.VRpcCallContext.create(Deadline.after(1, TimeUnit.MINUTES), true, tracer),
        f);
    long sessionDelay = 200;
    Thread.sleep(sessionDelay);
    delayedVRpc.execute();

    SessionFakeScriptedResponse response = f.get();
    assertThat(response).isEqualToDefaultInstance();
    attemptFinished.get();

    long clientBlockingLatency =
        getMetricValue(
            metricReader,
            "bigtable.googleapis.com/internal/client/throttling_latencies",
            Attributes.empty());

    assertThat(clientBlockingLatency).isAtLeast(sessionDelay);
  }

  private Action createErrorResponse(
      int errorCode, com.google.protobuf.Duration retryDelay, long rpcId) {
    com.google.rpc.Status status =
        com.google.rpc.Status.newBuilder().setCode(errorCode).setMessage("fake error").build();
    ErrorResponse errorResponse =
        ErrorResponse.newBuilder()
            .setRpcId(rpcId)
            .setStatus(status)
            .setRetryInfo(RetryInfo.newBuilder().setRetryDelay(retryDelay).build())
            .setClusterInfo(ClusterInformation.getDefaultInstance())
            .build();
    return Action.newBuilder().setErrorResponse(errorResponse).build();
  }

  private Action createResponse(long rpcId, String clusterId, String zoneId) {
    VirtualRpcResponse response =
        VirtualRpcResponse.newBuilder()
            .setRpcId(rpcId)
            .setClusterInfo(
                ClusterInformation.newBuilder().setClusterId(clusterId).setZoneId(zoneId).build())
            .setStats(SessionRequestStats.getDefaultInstance())
            .setPayload(ByteString.EMPTY)
            .build();

    return Action.newBuilder().setResponse(response).build();
  }

  // Get the metric value that matches any of the attributes in the attribute map
  private static long getMetricValue(
      InMemoryMetricReader reader, String metricName, Attributes attributes) {
    Collection<MetricData> allMetricData = reader.collectAllMetrics();
    List<MetricData> matchingMetadata =
        allMetricData.stream()
            .filter(md -> METRIC_DATA_BY_NAME.compare(md, metricName))
            .collect(Collectors.toList());
    assertWithMessage(
            "Found multiple MetricData with the same name: %s, in: %s",
            metricName, matchingMetadata)
        .that(matchingMetadata.size())
        .isAtMost(1);

    if (!matchingMetadata.isEmpty()) {
      MetricData metricData = matchingMetadata.get(0);

      Collection<?> points =
          metricData.getData().getPoints().stream()
              .filter(
                  pd ->
                      pd.getAttributes()
                          .asMap()
                          .entrySet()
                          .containsAll(attributes.asMap().entrySet()))
              .collect(Collectors.toList());

      assertWithMessage("ambiguous labels matched too many points").that(points).hasSize(1);

      switch (metricData.getType()) {
        case HISTOGRAM:
          HistogramPointData hd = (HistogramPointData) points.iterator().next();
          return (long) hd.getSum() / hd.getCount();
        case LONG_SUM:
          LongPointData ld = (LongPointData) points.iterator().next();
          return ld.getValue();
        default:
          return 0;
      }
    }

    // MetricData was not found, assert on original collection to get a descriptive error message
    assertThat(allMetricData).comparingElementsUsing(METRIC_DATA_BY_NAME).contains(metricName);
    throw new IllegalStateException(
        "MetricData was missing then appeared, this should never happen");
  }

  static class DelayedVRpc<ReqT, RespT> implements VRpc<ReqT, RespT> {

    private final Supplier<VRpc<ReqT, RespT>> supplier;

    private ReqT req;
    private VRpcCallContext ctx;
    private VRpcListener<RespT> listener;

    DelayedVRpc(Supplier<VRpc<ReqT, RespT>> supplier) {
      this.supplier = supplier;
    }

    @Override
    public void start(ReqT req, VRpcCallContext ctx, VRpcListener<RespT> listener) {
      this.req = req;
      this.ctx = ctx;
      this.listener = listener;
    }

    @Override
    public void cancel(@Nullable String message, @Nullable Throwable cause) {
      throw new UnsupportedOperationException();
    }

    @Override
    public void requestNext() {
      throw new UnsupportedOperationException();
    }

    public void execute() {
      supplier.get().start(req, ctx, listener);
    }
  }
}
