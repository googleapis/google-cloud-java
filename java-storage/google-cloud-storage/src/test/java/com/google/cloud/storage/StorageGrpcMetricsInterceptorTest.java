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

import static com.google.common.truth.Truth.assertThat;

import com.google.api.core.ApiClock;
import com.google.api.gax.grpc.GrpcInterceptorProvider;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.cloud.NoCredentials;
import com.google.common.collect.ImmutableList;
import io.grpc.Attributes;
import io.grpc.CallOptions;
import io.grpc.Channel;
import io.grpc.ClientCall;
import io.grpc.ClientInterceptor;
import io.grpc.Grpc;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.Status;
import io.opentelemetry.api.metrics.DoubleHistogram;
import io.opentelemetry.api.metrics.DoubleHistogramBuilder;
import io.opentelemetry.api.metrics.Meter;
import io.opentelemetry.api.metrics.MeterBuilder;
import io.opentelemetry.api.metrics.MeterProvider;
import io.opentelemetry.context.Context;
import io.opentelemetry.context.ContextKey;
import io.opentelemetry.context.Scope;
import io.opentelemetry.sdk.metrics.SdkMeterProvider;
import io.opentelemetry.sdk.metrics.data.HistogramPointData;
import io.opentelemetry.sdk.metrics.data.MetricData;
import io.opentelemetry.sdk.testing.exporter.InMemoryMetricReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;
import java.util.Collection;
import java.util.Collections;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public final class StorageGrpcMetricsInterceptorTest {

  private static final MethodDescriptor<Void, Void> READ_OBJECT_METHOD =
      createMethodDescriptor(
          MethodDescriptor.MethodType.SERVER_STREAMING, "google.storage.v2.Storage/ReadObject");

  private static final MethodDescriptor<Void, Void> WRITE_OBJECT_METHOD =
      createMethodDescriptor(
          MethodDescriptor.MethodType.CLIENT_STREAMING, "google.storage.v2.Storage/WriteObject");

  private static final MethodDescriptor<Void, Void> GET_BUCKET_METHOD =
      createMethodDescriptor(
          MethodDescriptor.MethodType.UNARY, "google.storage.v2.Storage/GetBucket");

  private static final MethodDescriptor<Void, Void> DELETE_OBJECT_METHOD =
      createMethodDescriptor(
          MethodDescriptor.MethodType.UNARY, "google.storage.v2.Storage/DeleteObject");

  private static MethodDescriptor<Void, Void> createMethodDescriptor(
      MethodDescriptor.MethodType type, String fullMethodName) {
    return MethodDescriptor.<Void, Void>newBuilder()
        .setType(type)
        .setFullMethodName(fullMethodName)
        .setRequestMarshaller(new NoopMarshaller())
        .setResponseMarshaller(new NoopMarshaller())
        .build();
  }

  private InMemoryMetricReader reader;
  private SdkMeterProvider meterProvider;
  private FakeClock clock;

  @Before
  public void setUp() {
    reader = InMemoryMetricReader.create();
    meterProvider = SdkMeterProvider.builder().registerMetricReader(reader).build();
    clock = new FakeClock();
  }

  @Test
  public void interceptCall_recordsFullMethodNameAcrossOperations() {
    StorageClientMetrics metrics = StorageClientMetrics.create(meterProvider, true, false);
    StorageGrpcMetricsInterceptor interceptor =
        new StorageGrpcMetricsInterceptor(metrics, clock, "storage.googleapis.com");

    for (MethodDescriptor<Void, Void> method :
        ImmutableList.of(
            READ_OBJECT_METHOD, WRITE_OBJECT_METHOD, GET_BUCKET_METHOD, DELETE_OBJECT_METHOD)) {
      TestClientCall<Void, Void> testCall = new TestClientCall<>(Attributes.EMPTY);
      TestChannel testChannel = new TestChannel(testCall, "storage.googleapis.com");
      ClientCall<Void, Void> call =
          interceptor.interceptCall(method, CallOptions.DEFAULT, testChannel);
      call.start(new TestListener<>(), new Metadata());
      testCall.close(Status.OK, new Metadata());
    }

    MetricData rpcDurationData =
        reader.collectAllMetrics().stream()
            .filter(m -> m.getName().equals(StorageClientMetrics.METRIC_RPC_CLIENT_CALL_DURATION))
            .findFirst()
            .orElse(null);

    assertThat(rpcDurationData).isNotNull();
    assertThat(
            rpcDurationData.getHistogramData().getPoints().stream()
                .map(p -> p.getAttributes().get(StorageClientMetrics.KEY_RPC_METHOD)))
        .containsExactly(
            "google.storage.v2.Storage/ReadObject",
            "google.storage.v2.Storage/WriteObject",
            "google.storage.v2.Storage/GetBucket",
            "google.storage.v2.Storage/DeleteObject");
  }

  @Test
  public void isDirectPathIp_ipv4AndIpv6() throws Exception {
    assertThat(StorageGrpcMetricsInterceptor.isDirectPathIp(InetAddress.getByName("34.126.0.1")))
        .isTrue();
    assertThat(StorageGrpcMetricsInterceptor.isDirectPathIp(InetAddress.getByName("34.126.63.254")))
        .isTrue();
    assertThat(StorageGrpcMetricsInterceptor.isDirectPathIp(InetAddress.getByName("34.126.64.1")))
        .isFalse();
    assertThat(StorageGrpcMetricsInterceptor.isDirectPathIp(InetAddress.getByName("35.190.1.1")))
        .isFalse();
    assertThat(StorageGrpcMetricsInterceptor.isDirectPathIp(InetAddress.getByName("142.250.1.1")))
        .isFalse();

    assertThat(
            StorageGrpcMetricsInterceptor.isDirectPathIp(
                InetAddress.getByName("2001:4860:8040:0000:0000:0000:0000:0001")))
        .isTrue();
    assertThat(
            StorageGrpcMetricsInterceptor.isDirectPathIp(
                InetAddress.getByName("2001:4860:8040:ffff:ffff:ffff:ffff:ffff")))
        .isTrue();
    assertThat(
            StorageGrpcMetricsInterceptor.isDirectPathIp(
                InetAddress.getByName("2001:4860:8041::1")))
        .isTrue();
    assertThat(
            StorageGrpcMetricsInterceptor.isDirectPathIp(
                InetAddress.getByName("2001:4860:8044::1")))
        .isFalse();
    assertThat(
            StorageGrpcMetricsInterceptor.isDirectPathIp(
                InetAddress.getByName("2001:4860:8080:0000:0000:0000:0000:0001")))
        .isFalse();
    assertThat(
            StorageGrpcMetricsInterceptor.isDirectPathIp(
                InetAddress.getByName("2607:f8b0:4005:805::200e")))
        .isFalse();
  }

  @Test
  public void detectNetworkPath_cases() throws Exception {
    Attributes directPathAttrs =
        Attributes.newBuilder()
            .set(
                Grpc.TRANSPORT_ATTR_REMOTE_ADDR,
                new InetSocketAddress(InetAddress.getByName("34.126.1.2"), 443))
            .build();
    assertThat(StorageGrpcMetricsInterceptor.detectNetworkPath(directPathAttrs))
        .isEqualTo(StorageClientMetrics.NETWORK_PATH_DIRECTPATH);

    Attributes cloudPathAttrs =
        Attributes.newBuilder()
            .set(
                Grpc.TRANSPORT_ATTR_REMOTE_ADDR,
                new InetSocketAddress(InetAddress.getByName("142.250.1.1"), 443))
            .build();
    assertThat(StorageGrpcMetricsInterceptor.detectNetworkPath(cloudPathAttrs))
        .isEqualTo(StorageClientMetrics.NETWORK_PATH_CLOUDPATH);

    assertThat(StorageGrpcMetricsInterceptor.detectNetworkPath(Attributes.EMPTY))
        .isEqualTo(StorageClientMetrics.NETWORK_PATH_UNKNOWN);
    assertThat(StorageGrpcMetricsInterceptor.detectNetworkPath(null))
        .isEqualTo(StorageClientMetrics.NETWORK_PATH_UNKNOWN);
  }

  @Test
  public void interceptCall_unaryCallSuccess_recordsMetricWithErrorTypeOk() throws Exception {
    StorageClientMetrics metrics = StorageClientMetrics.create(meterProvider, true, false);
    StorageGrpcMetricsInterceptor interceptor =
        new StorageGrpcMetricsInterceptor(metrics, clock, "https://storage.googleapis.com");

    Attributes callAttrs =
        Attributes.newBuilder()
            .set(
                Grpc.TRANSPORT_ATTR_REMOTE_ADDR,
                new InetSocketAddress(InetAddress.getByName("142.250.1.1"), 443))
            .build();
    TestClientCall<Void, Void> testCall = new TestClientCall<>(callAttrs);
    TestChannel testChannel = new TestChannel(testCall, "storage.googleapis.com:443");

    ClientCall<Void, Void> call =
        interceptor.interceptCall(READ_OBJECT_METHOD, CallOptions.DEFAULT, testChannel);
    TestListener<Void> listener = new TestListener<>();
    call.start(listener, new Metadata());

    clock.advanceNanos(500_000_000L); // 0.5s
    testCall.close(Status.OK, new Metadata());

    Collection<MetricData> metricData = reader.collectAllMetrics();
    MetricData rpcDurationData =
        metricData.stream()
            .filter(m -> m.getName().equals(StorageClientMetrics.METRIC_RPC_CLIENT_CALL_DURATION))
            .findFirst()
            .orElse(null);

    assertThat(rpcDurationData).isNotNull();
    assertThat(rpcDurationData.getHistogramData().getPoints()).hasSize(1);
    HistogramPointData point = rpcDurationData.getHistogramData().getPoints().iterator().next();
    assertThat(point.getCount()).isEqualTo(1L);
    assertThat(point.getSum()).isWithin(1e-6).of(0.5);

    io.opentelemetry.api.common.Attributes attrs = point.getAttributes();
    assertThat(attrs.get(StorageClientMetrics.KEY_RPC_SYSTEM_NAME)).isEqualTo("grpc");
    assertThat(attrs.get(StorageClientMetrics.KEY_RPC_METHOD))
        .isEqualTo("google.storage.v2.Storage/ReadObject");
    assertThat(attrs.get(StorageClientMetrics.KEY_RPC_RESPONSE_STATUS_CODE)).isEqualTo("OK");
    assertThat(attrs.get(StorageClientMetrics.KEY_NETWORK_PATH))
        .isEqualTo(StorageClientMetrics.NETWORK_PATH_CLOUDPATH);
    assertThat(attrs.get(StorageClientMetrics.KEY_SERVER_ADDRESS))
        .isEqualTo("storage.googleapis.com");
    assertThat(attrs.get(StorageClientMetrics.KEY_ERROR_TYPE)).isEqualTo("OK");
  }

  @Test
  public void interceptCall_callFails_recordsErrorType() throws Exception {
    StorageClientMetrics metrics = StorageClientMetrics.create(meterProvider, true, false);
    StorageGrpcMetricsInterceptor interceptor =
        new StorageGrpcMetricsInterceptor(metrics, clock, "storage.googleapis.com");

    TestClientCall<Void, Void> testCall = new TestClientCall<>(Attributes.EMPTY);
    TestChannel testChannel = new TestChannel(testCall, "storage.googleapis.com");

    ClientCall<Void, Void> call =
        interceptor.interceptCall(READ_OBJECT_METHOD, CallOptions.DEFAULT, testChannel);
    call.start(new TestListener<>(), new Metadata());

    clock.advanceNanos(100_000_000L); // 0.1s
    testCall.close(Status.NOT_FOUND, new Metadata());

    Collection<MetricData> metricData = reader.collectAllMetrics();
    MetricData rpcDurationData =
        metricData.stream()
            .filter(m -> m.getName().equals(StorageClientMetrics.METRIC_RPC_CLIENT_CALL_DURATION))
            .findFirst()
            .orElse(null);

    assertThat(rpcDurationData).isNotNull();
    HistogramPointData point = rpcDurationData.getHistogramData().getPoints().iterator().next();
    assertThat(point.getAttributes().get(StorageClientMetrics.KEY_RPC_RESPONSE_STATUS_CODE))
        .isEqualTo("NOT_FOUND");
    assertThat(point.getAttributes().get(StorageClientMetrics.KEY_ERROR_TYPE))
        .isEqualTo("NOT_FOUND");
    assertThat(point.getAttributes().get(StorageClientMetrics.KEY_SERVER_ADDRESS))
        .isEqualTo("storage.googleapis.com");
  }

  @Test
  public void interceptCall_disabledMetrics_doesNotRecord() {
    StorageClientMetrics metrics = StorageClientMetrics.create(meterProvider, false, false);
    StorageGrpcMetricsInterceptor interceptor =
        new StorageGrpcMetricsInterceptor(metrics, clock, "storage.googleapis.com");

    TestClientCall<Void, Void> testCall = new TestClientCall<>(Attributes.EMPTY);
    TestChannel testChannel = new TestChannel(testCall, "storage.googleapis.com");

    ClientCall<Void, Void> call =
        interceptor.interceptCall(READ_OBJECT_METHOD, CallOptions.DEFAULT, testChannel);
    call.start(new TestListener<>(), new Metadata());
    testCall.close(Status.OK, new Metadata());

    assertThat(reader.collectAllMetrics()).isEmpty();
  }

  @Test
  public void interceptCall_nullDefaultEndpoint_fallsBackToChannelAuthority() {
    StorageClientMetrics metrics = StorageClientMetrics.create(meterProvider, true, false);
    StorageGrpcMetricsInterceptor interceptor =
        new StorageGrpcMetricsInterceptor(metrics, clock, null);

    TestClientCall<Void, Void> testCall = new TestClientCall<>(Attributes.EMPTY);
    TestChannel testChannel = new TestChannel(testCall, "storage.googleapis.com:443");

    ClientCall<Void, Void> call =
        interceptor.interceptCall(READ_OBJECT_METHOD, CallOptions.DEFAULT, testChannel);
    call.start(new TestListener<>(), new Metadata());
    testCall.close(Status.OK, new Metadata());

    MetricData rpcDurationData =
        reader.collectAllMetrics().stream()
            .filter(m -> m.getName().equals(StorageClientMetrics.METRIC_RPC_CLIENT_CALL_DURATION))
            .findFirst()
            .orElse(null);

    assertThat(rpcDurationData).isNotNull();
    HistogramPointData point = rpcDurationData.getHistogramData().getPoints().iterator().next();
    assertThat(point.getAttributes().get(StorageClientMetrics.KEY_SERVER_ADDRESS))
        .isEqualTo("storage.googleapis.com");
  }

  @Test
  public void googleC2pEndpoint_setsUnknownWhenRemoteAddrAbsent() {
    StorageClientMetrics metrics = StorageClientMetrics.create(meterProvider, true, false);
    StorageGrpcMetricsInterceptor interceptor =
        new StorageGrpcMetricsInterceptor(
            metrics, clock, "  google-c2p:///storage.googleapis.com  ");

    TestClientCall<Void, Void> testCall = new TestClientCall<>(Attributes.EMPTY);
    TestChannel testChannel = new TestChannel(testCall, "storage.googleapis.com");

    ClientCall<Void, Void> call =
        interceptor.interceptCall(READ_OBJECT_METHOD, CallOptions.DEFAULT, testChannel);
    call.start(new TestListener<>(), new Metadata());
    testCall.close(Status.OK, new Metadata());

    MetricData rpcDurationData =
        reader.collectAllMetrics().stream()
            .filter(m -> m.getName().equals(StorageClientMetrics.METRIC_RPC_CLIENT_CALL_DURATION))
            .findFirst()
            .orElse(null);

    assertThat(rpcDurationData).isNotNull();
    HistogramPointData point = rpcDurationData.getHistogramData().getPoints().iterator().next();
    assertThat(point.getAttributes().get(StorageClientMetrics.KEY_NETWORK_PATH))
        .isEqualTo(StorageClientMetrics.NETWORK_PATH_UNKNOWN);
    assertThat(point.getAttributes().get(StorageClientMetrics.KEY_SERVER_ADDRESS))
        .isEqualTo("storage.googleapis.com");
  }

  @Test
  public void interceptCall_statusWithNetworkCause_recordsCauseErrorType() {
    StorageClientMetrics metrics = StorageClientMetrics.create(meterProvider, true, false);
    StorageGrpcMetricsInterceptor interceptor =
        new StorageGrpcMetricsInterceptor(metrics, clock, "storage.googleapis.com");

    TestClientCall<Void, Void> testCall = new TestClientCall<>(Attributes.EMPTY);
    TestChannel testChannel = new TestChannel(testCall, "storage.googleapis.com");

    ClientCall<Void, Void> call =
        interceptor.interceptCall(READ_OBJECT_METHOD, CallOptions.DEFAULT, testChannel);
    call.start(new TestListener<>(), new Metadata());
    testCall.close(
        Status.UNAVAILABLE.withCause(new UnknownHostException("storage.googleapis.com")),
        new Metadata());

    MetricData rpcDurationData =
        reader.collectAllMetrics().stream()
            .filter(m -> m.getName().equals(StorageClientMetrics.METRIC_RPC_CLIENT_CALL_DURATION))
            .findFirst()
            .orElse(null);

    assertThat(rpcDurationData).isNotNull();
    HistogramPointData point = rpcDurationData.getHistogramData().getPoints().iterator().next();
    assertThat(point.getAttributes().get(StorageClientMetrics.KEY_RPC_RESPONSE_STATUS_CODE))
        .isEqualTo("UNAVAILABLE");
    assertThat(point.getAttributes().get(StorageClientMetrics.KEY_ERROR_TYPE))
        .isEqualTo(StorageErrorTypeMapper.STATUS_DNS_FAILURE);
  }

  @Test
  public void interceptCall_duplicateOnClose_recordsOnlyOnce() {
    StorageClientMetrics metrics = StorageClientMetrics.create(meterProvider, true, false);
    StorageGrpcMetricsInterceptor interceptor =
        new StorageGrpcMetricsInterceptor(metrics, clock, "storage.googleapis.com");

    TestClientCall<Void, Void> testCall = new TestClientCall<>(Attributes.EMPTY);
    TestChannel testChannel = new TestChannel(testCall, "storage.googleapis.com");

    ClientCall<Void, Void> call =
        interceptor.interceptCall(READ_OBJECT_METHOD, CallOptions.DEFAULT, testChannel);
    call.start(new TestListener<>(), new Metadata());
    testCall.close(Status.OK, new Metadata());
    testCall.close(Status.OK, new Metadata());

    MetricData rpcDurationData =
        reader.collectAllMetrics().stream()
            .filter(m -> m.getName().equals(StorageClientMetrics.METRIC_RPC_CLIENT_CALL_DURATION))
            .findFirst()
            .orElse(null);

    assertThat(rpcDurationData).isNotNull();
    assertThat(rpcDurationData.getHistogramData().getPoints()).hasSize(1);
    HistogramPointData point = rpcDurationData.getHistogramData().getPoints().iterator().next();
    assertThat(point.getCount()).isEqualTo(1L);
  }

  @Test
  public void interceptCall_withStorageMetricsContext_propagatesContext() {
    StorageClientMetrics metrics = StorageClientMetrics.create(meterProvider, true, false);
    StorageGrpcMetricsInterceptor interceptor =
        new StorageGrpcMetricsInterceptor(metrics, clock, "storage.googleapis.com");

    StorageMetricsContext metricsContext = StorageMetricsContext.create("ReadObject");
    CallOptions callOptions = metricsContext.attach(CallOptions.DEFAULT);

    TestClientCall<Void, Void> testCall = new TestClientCall<>(Attributes.EMPTY);
    TestChannel testChannel = new TestChannel(testCall, "storage.googleapis.com");

    ClientCall<Void, Void> call =
        interceptor.interceptCall(READ_OBJECT_METHOD, callOptions, testChannel);
    call.start(new TestListener<>(), new Metadata());
    testCall.close(Status.OK, new Metadata());

    MetricData rpcDurationData =
        reader.collectAllMetrics().stream()
            .filter(m -> m.getName().equals(StorageClientMetrics.METRIC_RPC_CLIENT_CALL_DURATION))
            .findFirst()
            .orElse(null);

    assertThat(rpcDurationData).isNotNull();
    assertThat(rpcDurationData.getHistogramData().getPoints()).hasSize(1);
  }

  @Test
  public void interceptCall_withoutStorageMetricsContext_asyncOnCloseUsesCallerContext()
      throws Exception {
    ContextKey<String> testKey = ContextKey.named("caller-trace-key");
    Context callerContext = Context.root().with(testKey, "caller-trace-value");
    Context callbackThreadContext = Context.root().with(testKey, "callback-thread-value");

    AtomicReference<Context> recordedContext = new AtomicReference<>();
    DoubleHistogram mockHistogram = Mockito.mock(DoubleHistogram.class);
    Mockito.doAnswer(
            invocation -> {
              recordedContext.set(invocation.getArgument(2));
              return null;
            })
        .when(mockHistogram)
        .record(
            Mockito.anyDouble(),
            Mockito.any(io.opentelemetry.api.common.Attributes.class),
            Mockito.any(Context.class));

    DoubleHistogramBuilder mockHistBuilder =
        Mockito.mock(DoubleHistogramBuilder.class, Mockito.RETURNS_SELF);
    Mockito.when(mockHistBuilder.build()).thenReturn(mockHistogram);
    Mockito.when(mockHistBuilder.ofLongs())
        .thenReturn(
            Mockito.mock(
                io.opentelemetry.api.metrics.LongHistogramBuilder.class,
                Mockito.RETURNS_DEEP_STUBS));

    Meter mockMeter = Mockito.mock(Meter.class, Mockito.RETURNS_DEEP_STUBS);
    Mockito.when(mockMeter.histogramBuilder(Mockito.anyString())).thenReturn(mockHistBuilder);

    MeterBuilder mockMeterBuilder = Mockito.mock(MeterBuilder.class, Mockito.RETURNS_SELF);
    Mockito.when(mockMeterBuilder.build()).thenReturn(mockMeter);

    MeterProvider mockMeterProvider = Mockito.mock(MeterProvider.class);
    Mockito.when(mockMeterProvider.meterBuilder(Mockito.anyString())).thenReturn(mockMeterBuilder);

    StorageClientMetrics metrics = StorageClientMetrics.create(mockMeterProvider, true, false);
    StorageGrpcMetricsInterceptor interceptor =
        new StorageGrpcMetricsInterceptor(metrics, clock, "storage.googleapis.com");

    TestClientCall<Void, Void> testCall = new TestClientCall<>(Attributes.EMPTY);
    TestChannel testChannel = new TestChannel(testCall, "storage.googleapis.com");

    final ClientCall<Void, Void> call;
    try (Scope ignored = callerContext.makeCurrent()) {
      call = interceptor.interceptCall(READ_OBJECT_METHOD, CallOptions.DEFAULT, testChannel);
    }
    call.start(new TestListener<>(), new Metadata());

    CountDownLatch latch = new CountDownLatch(1);
    Thread asyncCallbackThread =
        new Thread(
            () -> {
              try (Scope ignored = callbackThreadContext.makeCurrent()) {
                testCall.close(Status.OK, new Metadata());
              } finally {
                latch.countDown();
              }
            });
    asyncCallbackThread.start();
    assertThat(latch.await(5, TimeUnit.SECONDS)).isTrue();

    assertThat(recordedContext.get()).isSameInstanceAs(callerContext);
    assertThat(recordedContext.get().get(testKey)).isEqualTo("caller-trace-value");
  }

  @Test
  public void grpcStorageOptions_interceptorProviderWiring() throws Exception {
    GrpcStorageOptions defaultOptions =
        StorageOptions.grpc()
            .setProjectId("test-project")
            .setCredentials(NoCredentials.getInstance())
            .setEnableOtelMetrics(true)
            .setMeterProvider(meterProvider)
            .build();
    InstantiatingGrpcChannelProvider defaultChannelProvider =
        (InstantiatingGrpcChannelProvider)
            defaultOptions.getStorageSettings().getTransportChannelProvider();
    GrpcInterceptorProvider defaultInterceptorProvider =
        extractInterceptorProvider(defaultChannelProvider);
    assertThat(defaultInterceptorProvider).isNotNull();
    assertThat(defaultInterceptorProvider.getInterceptors()).hasSize(1);
    assertThat(defaultInterceptorProvider.getInterceptors().get(0))
        .isInstanceOf(StorageGrpcMetricsInterceptor.class);

    GrpcStorageOptions nullProviderOptions =
        StorageOptions.grpc()
            .setProjectId("test-project")
            .setCredentials(NoCredentials.getInstance())
            .setEnableOtelMetrics(true)
            .setMeterProvider(meterProvider)
            .build();
    Field providerField = GrpcStorageOptions.class.getDeclaredField("grpcInterceptorProvider");
    providerField.setAccessible(true);
    providerField.set(nullProviderOptions, null);
    InstantiatingGrpcChannelProvider nullChannelProvider =
        (InstantiatingGrpcChannelProvider)
            nullProviderOptions.getStorageSettings().getTransportChannelProvider();
    GrpcInterceptorProvider nullCombinedProvider = extractInterceptorProvider(nullChannelProvider);
    assertThat(nullCombinedProvider).isNotNull();
    assertThat(nullCombinedProvider.getInterceptors()).hasSize(1);
    assertThat(nullCombinedProvider.getInterceptors().get(0))
        .isInstanceOf(StorageGrpcMetricsInterceptor.class);

    AtomicBoolean customCalled = new AtomicBoolean(false);
    ClientInterceptor customInterceptor =
        new ClientInterceptor() {
          @Override
          public <ReqT, RespT> ClientCall<ReqT, RespT> interceptCall(
              MethodDescriptor<ReqT, RespT> method, CallOptions callOptions, Channel next) {
            customCalled.set(true);
            return next.newCall(method, callOptions);
          }
        };

    GrpcStorageOptions customOptions =
        StorageOptions.grpc()
            .setProjectId("test-project")
            .setCredentials(NoCredentials.getInstance())
            .setEnableOtelMetrics(true)
            .setMeterProvider(meterProvider)
            .setGrpcInterceptorProvider(() -> ImmutableList.of(customInterceptor))
            .build();
    InstantiatingGrpcChannelProvider customChannelProvider =
        (InstantiatingGrpcChannelProvider)
            customOptions.getStorageSettings().getTransportChannelProvider();
    GrpcInterceptorProvider combinedProvider = extractInterceptorProvider(customChannelProvider);
    assertThat(combinedProvider).isNotNull();
    assertThat(combinedProvider.getInterceptors()).hasSize(2);
    assertThat(combinedProvider.getInterceptors().get(0)).isSameInstanceAs(customInterceptor);
    assertThat(combinedProvider.getInterceptors().get(1))
        .isInstanceOf(StorageGrpcMetricsInterceptor.class);

    GrpcStorageOptions emptyCustomOptions =
        StorageOptions.grpc()
            .setProjectId("test-project")
            .setCredentials(NoCredentials.getInstance())
            .setEnableOtelMetrics(true)
            .setMeterProvider(meterProvider)
            .setGrpcInterceptorProvider(Collections::emptyList)
            .build();
    InstantiatingGrpcChannelProvider emptyCustomChannelProvider =
        (InstantiatingGrpcChannelProvider)
            emptyCustomOptions.getStorageSettings().getTransportChannelProvider();
    GrpcInterceptorProvider emptyCombinedProvider =
        extractInterceptorProvider(emptyCustomChannelProvider);
    assertThat(emptyCombinedProvider).isNotNull();
    assertThat(emptyCombinedProvider.getInterceptors()).hasSize(1);
    assertThat(emptyCombinedProvider.getInterceptors().get(0))
        .isInstanceOf(StorageGrpcMetricsInterceptor.class);
    assertThat(customCalled.get()).isFalse();
  }

  private static GrpcInterceptorProvider extractInterceptorProvider(
      InstantiatingGrpcChannelProvider channelProvider) throws Exception {
    Field field = InstantiatingGrpcChannelProvider.class.getDeclaredField("interceptorProvider");
    field.setAccessible(true);
    return (GrpcInterceptorProvider) field.get(channelProvider);
  }

  private static final class TestClientCall<ReqT, RespT> extends ClientCall<ReqT, RespT> {
    private Listener<RespT> listener;
    private final Attributes attributes;

    TestClientCall(Attributes attributes) {
      this.attributes = attributes;
    }

    @Override
    public void start(Listener<RespT> responseListener, Metadata headers) {
      this.listener = responseListener;
    }

    @Override
    public void request(int numMessages) {}

    @Override
    public void cancel(String message, Throwable cause) {}

    @Override
    public void halfClose() {}

    @Override
    public void sendMessage(ReqT message) {}

    @Override
    public Attributes getAttributes() {
      return attributes;
    }

    void close(Status status, Metadata trailers) {
      if (listener != null) {
        listener.onClose(status, trailers);
      }
    }
  }

  private static final class TestChannel extends Channel {
    private final TestClientCall<?, ?> call;
    private final String authority;

    TestChannel(TestClientCall<?, ?> call, String authority) {
      this.call = call;
      this.authority = authority;
    }

    @SuppressWarnings("unchecked")
    @Override
    public <RequestT, ResponseT> ClientCall<RequestT, ResponseT> newCall(
        MethodDescriptor<RequestT, ResponseT> methodDescriptor, CallOptions callOptions) {
      return (ClientCall<RequestT, ResponseT>) call;
    }

    @Override
    public String authority() {
      return authority;
    }
  }

  private static final class TestListener<RespT> extends ClientCall.Listener<RespT> {}

  private static final class NoopMarshaller implements MethodDescriptor.Marshaller<Void> {
    @Override
    public InputStream stream(Void value) {
      return new ByteArrayInputStream(new byte[0]);
    }

    @Override
    public Void parse(InputStream stream) {
      return null;
    }
  }

  private static final class FakeClock implements ApiClock {
    private final AtomicLong nanos = new AtomicLong(1_000_000_000L);

    @Override
    public long nanoTime() {
      return nanos.get();
    }

    @Override
    public long millisTime() {
      return nanos.get() / 1_000_000L;
    }

    void advanceNanos(long amount) {
      nanos.addAndGet(amount);
    }
  }
}
