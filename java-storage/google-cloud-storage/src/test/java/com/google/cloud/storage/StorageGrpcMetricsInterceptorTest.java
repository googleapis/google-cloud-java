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
import static com.google.common.truth.Truth.assertWithMessage;

import com.google.api.core.ApiClock;
import com.google.api.gax.grpc.GrpcInterceptorProvider;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.cloud.NoCredentials;
import com.google.common.collect.ImmutableList;
import com.google.storage.v2.BidiWriteObjectRequest;
import com.google.storage.v2.BidiWriteObjectResponse;
import com.google.storage.v2.ReadObjectRequest;
import com.google.storage.v2.StorageGrpc;
import com.google.storage.v2.WriteObjectRequest;
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
import io.opentelemetry.api.metrics.LongHistogramBuilder;
import io.opentelemetry.api.metrics.Meter;
import io.opentelemetry.api.metrics.MeterBuilder;
import io.opentelemetry.api.metrics.MeterProvider;
import io.opentelemetry.context.Context;
import io.opentelemetry.context.ContextKey;
import io.opentelemetry.context.Scope;
import io.opentelemetry.sdk.metrics.SdkMeterProvider;
import io.opentelemetry.sdk.metrics.data.HistogramPointData;
import io.opentelemetry.sdk.metrics.data.LongPointData;
import io.opentelemetry.sdk.metrics.data.MetricData;
import io.opentelemetry.sdk.testing.exporter.InMemoryMetricReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;
import javax.net.ssl.SSLException;
import javax.security.sasl.AuthenticationException;
import org.jspecify.annotations.Nullable;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public final class StorageGrpcMetricsInterceptorTest {

  private static final MethodDescriptor<Void, Void> READ_OBJECT_METHOD =
      MethodDescriptor.<Void, Void>newBuilder()
          .setType(MethodDescriptor.MethodType.SERVER_STREAMING)
          .setFullMethodName("google.storage.v2.Storage/ReadObject")
          .setRequestMarshaller(new NoopMarshaller())
          .setResponseMarshaller(new NoopMarshaller())
          .build();

  private InMemoryMetricReader reader;
  private SdkMeterProvider meterProvider;
  private FakeClock clock;
  private StorageClientMetrics metrics;
  private StorageGrpcMetricsInterceptor interceptor;

  @Before
  public void setUp() {
    reader = InMemoryMetricReader.create();
    meterProvider = SdkMeterProvider.builder().registerMetricReader(reader).build();
    clock = new FakeClock();
    metrics =
        StorageOptions.grpc()
            .setProjectId("test-project")
            .setCredentials(NoCredentials.getInstance())
            .setEnableOtelMetrics(true)
            .setMeterProvider(meterProvider)
            .build()
            .getStorageClientMetrics();
    interceptor = new StorageGrpcMetricsInterceptor(metrics, clock);
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
        .isTrue();
    assertThat(
            StorageGrpcMetricsInterceptor.isDirectPathIp(
                InetAddress.getByName("2001:4860:807f::1")))
        .isTrue();
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
  public void defaultOperationName_cases() {
    assertThat(StorageGrpcMetricsInterceptor.defaultOperationName("BidiReadObject"))
        .isEqualTo("ReadObject");
    assertThat(StorageGrpcMetricsInterceptor.defaultOperationName("BidiWriteObject"))
        .isEqualTo("WriteObject");
    assertThat(StorageGrpcMetricsInterceptor.defaultOperationName("StartResumableWrite"))
        .isEqualTo("WriteObject");
    assertThat(StorageGrpcMetricsInterceptor.defaultOperationName("QueryWriteStatus"))
        .isEqualTo("WriteObject");
    assertThat(StorageGrpcMetricsInterceptor.defaultOperationName("ReadObject"))
        .isEqualTo("ReadObject");
    assertThat(StorageGrpcMetricsInterceptor.defaultOperationName("GetBucket"))
        .isEqualTo("GetBucket");
    assertThat(StorageGrpcMetricsInterceptor.defaultOperationName("")).isEqualTo("UNKNOWN");
    assertThat(StorageGrpcMetricsInterceptor.defaultOperationName(null)).isEqualTo("UNKNOWN");
  }

  @Test
  public void isWriteFlush_cases() {
    assertThat(
            StorageGrpcMetricsInterceptor.isWriteFlush(
                BidiWriteObjectRequest.newBuilder().setFlush(true).build()))
        .isTrue();
    assertThat(
            StorageGrpcMetricsInterceptor.isWriteFlush(
                BidiWriteObjectRequest.newBuilder().setFinishWrite(true).build()))
        .isTrue();
    assertThat(
            StorageGrpcMetricsInterceptor.isWriteFlush(
                BidiWriteObjectRequest.newBuilder().setStateLookup(true).build()))
        .isFalse();
    assertThat(
            StorageGrpcMetricsInterceptor.isWriteFlush(BidiWriteObjectRequest.getDefaultInstance()))
        .isFalse();
    assertThat(
            StorageGrpcMetricsInterceptor.isWriteFlush(
                WriteObjectRequest.newBuilder().setFinishWrite(true).build()))
        .isTrue();
    assertThat(StorageGrpcMetricsInterceptor.isWriteFlush(WriteObjectRequest.getDefaultInstance()))
        .isFalse();
    assertThat(StorageGrpcMetricsInterceptor.isWriteFlush(ReadObjectRequest.getDefaultInstance()))
        .isFalse();
    assertThat(StorageGrpcMetricsInterceptor.isWriteFlush(null)).isFalse();
  }

  @Test
  public void interceptCall_unaryCallSuccess_recordsMetricWithErrorTypeOk() throws Exception {
    Attributes callAttrs =
        Attributes.newBuilder()
            .set(
                Grpc.TRANSPORT_ATTR_REMOTE_ADDR,
                new InetSocketAddress(InetAddress.getByName("142.250.1.1"), 443))
            .build();
    TestClientCall<Void, Void> testCall = new TestClientCall<>(callAttrs);
    TestChannel testChannel = new TestChannel(testCall);

    ClientCall<Void, Void> call =
        interceptor.interceptCall(READ_OBJECT_METHOD, CallOptions.DEFAULT, testChannel);
    TestListener<Void> listener = new TestListener<>();
    call.start(listener, new Metadata());

    clock.advanceNanos(200_000_000L); // 0.2s: first response message triggers TTFB
    testCall.deliverMessage(null);
    clock.advanceNanos(150_000_000L); // 0.35s: second message must not record TTFB again
    testCall.deliverMessage(null);
    clock.advanceNanos(150_000_000L); // 0.5s total duration
    testCall.close(Status.OK, new Metadata());

    MetricData rpcDurationData = findMetric(StorageClientMetrics.METRIC_RPC_CLIENT_CALL_DURATION);

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

    MetricData ttfbData = findMetric(StorageClientMetrics.METRIC_GCP_STORAGE_CLIENT_TTFB);
    assertThat(ttfbData).isNotNull();
    assertThat(ttfbData.getHistogramData().getPoints()).hasSize(1);
    HistogramPointData ttfbPoint = ttfbData.getHistogramData().getPoints().iterator().next();
    assertThat(ttfbPoint.getCount()).isEqualTo(1L);
    assertThat(ttfbPoint.getSum()).isWithin(1e-6).of(0.2);
    assertThat(ttfbPoint.getAttributes())
        .isEqualTo(
            io.opentelemetry.api.common.Attributes.builder()
                .put(
                    StorageClientMetrics.KEY_GCP_CLIENT_SERVICE,
                    StorageClientMetrics.SERVICE_STORAGE)
                .put(StorageClientMetrics.KEY_GCP_CLIENT_VERSION, StorageOptions.version())
                .put(
                    StorageClientMetrics.KEY_GCP_CLIENT_ARTIFACT,
                    StorageClientMetrics.ARTIFACT_STORAGE)
                .put(StorageClientMetrics.KEY_RPC_SYSTEM_NAME, "grpc")
                .put(StorageClientMetrics.KEY_GCP_STORAGE_OPERATION, "ReadObject")
                .put(
                    StorageClientMetrics.KEY_NETWORK_PATH,
                    StorageClientMetrics.NETWORK_PATH_CLOUDPATH)
                .put(StorageClientMetrics.KEY_SERVER_ADDRESS, "storage.googleapis.com")
                .build());
  }

  @Test
  public void interceptCall_bidiWriteObject_recordsTtfbFromFlush() {
    TestClientCall<BidiWriteObjectRequest, BidiWriteObjectResponse> writeCall =
        new TestClientCall<>(Attributes.EMPTY);
    TestChannel writeChannel = new TestChannel(writeCall);

    ClientCall<BidiWriteObjectRequest, BidiWriteObjectResponse> call =
        interceptor.interceptCall(
            StorageGrpc.getBidiWriteObjectMethod(), CallOptions.DEFAULT, writeChannel);
    call.start(new TestListener<>(), new Metadata());

    clock.advanceNanos(100_000_000L); // t = 0.10s: flush re-anchors ttfbStartNanos
    call.sendMessage(BidiWriteObjectRequest.newBuilder().setFlush(true).build());

    clock.advanceNanos(100_000_000L); // t = 0.20s: trailing non-flush chunk must not re-anchor
    call.sendMessage(BidiWriteObjectRequest.getDefaultInstance());

    clock.advanceNanos(150_000_000L); // t = 0.35s: first server ack -> TTFB = 0.35 - 0.10 = 0.25s
    writeCall.deliverMessage(BidiWriteObjectResponse.getDefaultInstance());
    writeCall.close(Status.OK, new Metadata());

    MetricData ttfbData = findMetric(StorageClientMetrics.METRIC_GCP_STORAGE_CLIENT_TTFB);
    assertThat(ttfbData).isNotNull();
    assertThat(ttfbData.getHistogramData().getPoints()).hasSize(1);
    HistogramPointData ttfbPoint = ttfbData.getHistogramData().getPoints().iterator().next();
    assertThat(ttfbPoint.getCount()).isEqualTo(1L);
    assertThat(ttfbPoint.getSum()).isWithin(1e-6).of(0.25);
    assertThat(ttfbPoint.getAttributes().get(StorageClientMetrics.KEY_GCP_STORAGE_OPERATION))
        .isEqualTo("WriteObject");
    assertThat(ttfbPoint.getAttributes().get(StorageClientMetrics.KEY_RPC_SYSTEM_NAME))
        .isEqualTo("grpc");
    assertThat(ttfbPoint.getAttributes().get(StorageClientMetrics.KEY_SERVER_ADDRESS))
        .isEqualTo("storage.googleapis.com");
  }

  @Test
  public void interceptCall_callFails_recordsErrorType() {
    TestClientCall<Void, Void> testCall = new TestClientCall<>(Attributes.EMPTY);
    TestChannel testChannel = new TestChannel(testCall);

    ClientCall<Void, Void> call =
        interceptor.interceptCall(READ_OBJECT_METHOD, CallOptions.DEFAULT, testChannel);
    call.start(new TestListener<>(), new Metadata());

    clock.advanceNanos(100_000_000L); // 0.1s
    testCall.close(Status.NOT_FOUND, new Metadata());

    MetricData rpcDurationData = findMetric(StorageClientMetrics.METRIC_RPC_CLIENT_CALL_DURATION);

    assertThat(rpcDurationData).isNotNull();
    HistogramPointData point = rpcDurationData.getHistogramData().getPoints().iterator().next();
    assertThat(point.getAttributes().get(StorageClientMetrics.KEY_RPC_RESPONSE_STATUS_CODE))
        .isEqualTo("NOT_FOUND");
    assertThat(point.getAttributes().get(StorageClientMetrics.KEY_ERROR_TYPE))
        .isEqualTo("NOT_FOUND");
    assertThat(point.getAttributes().get(StorageClientMetrics.KEY_SERVER_ADDRESS))
        .isEqualTo("storage.googleapis.com");

    assertThat(findMetric(StorageClientMetrics.METRIC_GCP_STORAGE_CLIENT_TTFB)).isNull();
    assertThat(findMetric(StorageClientMetrics.METRIC_GCP_STORAGE_CLIENT_REQUEST_ACTIVE)).isNull();
  }

  @Test
  public void interceptCall_requestActive_tracksInFlightAndBalancesOnClose() {
    StorageGrpcMetricsInterceptor debugInterceptor = createDebugInterceptor();

    TestClientCall<Void, Void> okCall = new TestClientCall<>(Attributes.EMPTY);
    ClientCall<Void, Void> wrappedOk =
        debugInterceptor.interceptCall(
            READ_OBJECT_METHOD, CallOptions.DEFAULT, new TestChannel(okCall));
    wrappedOk.start(new TestListener<>(), new Metadata());

    LongPointData inFlightPoint = requestActivePoint();
    assertThat(inFlightPoint.getValue()).isEqualTo(1L);
    assertThat(inFlightPoint.getAttributes())
        .isEqualTo(
            io.opentelemetry.api.common.Attributes.builder()
                .put(
                    StorageClientMetrics.KEY_GCP_CLIENT_SERVICE,
                    StorageClientMetrics.SERVICE_STORAGE)
                .put(StorageClientMetrics.KEY_GCP_CLIENT_VERSION, StorageOptions.version())
                .put(
                    StorageClientMetrics.KEY_GCP_CLIENT_ARTIFACT,
                    StorageClientMetrics.ARTIFACT_STORAGE)
                .put(StorageClientMetrics.KEY_RPC_SYSTEM_NAME, "grpc")
                .put(StorageClientMetrics.KEY_SERVER_ADDRESS, "storage.googleapis.com")
                .put(StorageClientMetrics.KEY_GCP_STORAGE_OPERATION, "ReadObject")
                .build());

    // Start a second concurrent call and close both (OK + error) to verify gauge returns to 0.
    TestClientCall<Void, Void> errCall = new TestClientCall<>(Attributes.EMPTY);
    ClientCall<Void, Void> wrappedErr =
        debugInterceptor.interceptCall(
            READ_OBJECT_METHOD, CallOptions.DEFAULT, new TestChannel(errCall));
    wrappedErr.start(new TestListener<>(), new Metadata());
    assertThat(requestActivePoint().getValue()).isEqualTo(2L);

    okCall.close(Status.OK, new Metadata());
    errCall.close(Status.UNAVAILABLE, new Metadata());
    assertThat(requestActivePoint().getValue()).isEqualTo(0L);
  }

  @Test
  public void decodeServerDurationSeconds_cases() {
    Object[][] cases = {
      {"valid 125ms", encodeServerStats(0, 0, 125_000_000L), 0.125},
      {
        "raw LE wire bytes 250ms",
        new byte[] {0, 0, (byte) 0x80, (byte) 0xB2, (byte) 0xE6, 0x0E, 0, 0, 0, 0},
        0.25
      },
      {"valid 0ns", encodeServerStats(0, 0, 0L), 0.0},
      {"absent trailer", null, -1.0},
      {"too short (9 bytes)", new byte[9], -1.0},
      {"too long (11 bytes)", new byte[11], -1.0},
      {"wrong version", encodeServerStats(1, 0, 125_000_000L), -1.0},
      {"wrong field id", encodeServerStats(0, 1, 125_000_000L), -1.0},
      {"negative nanos overflow", encodeServerStats(0, 0, Long.MIN_VALUE), -1.0},
    };
    for (Object[] testCase : cases) {
      String label = (String) testCase[0];
      byte[] payload = (byte[]) testCase[1];
      double expected = (double) testCase[2];
      Metadata trailers = new Metadata();
      if (payload != null) {
        trailers.put(StorageGrpcMetricsInterceptor.GRPC_SERVER_STATS_BIN_KEY, payload);
      }
      assertWithMessage(label)
          .that(StorageGrpcMetricsInterceptor.decodeServerDurationSeconds(trailers))
          .isWithin(1e-9)
          .of(expected);
    }
  }

  @Test
  public void interceptCall_serverDuration_recordsWhenDebugEnabledAndValidTrailerPresent()
      throws Exception {
    Attributes directPathAttrs =
        Attributes.newBuilder()
            .set(
                Grpc.TRANSPORT_ATTR_REMOTE_ADDR,
                new InetSocketAddress(InetAddress.getByName("34.126.1.2"), 443))
            .build();
    Metadata validTrailers = new Metadata();
    validTrailers.put(
        StorageGrpcMetricsInterceptor.GRPC_SERVER_STATS_BIN_KEY,
        encodeServerStats(0, 0, 250_000_000L));

    // Debug disabled: must not record server.duration even when trailer is present.
    TestClientCall<Void, Void> standardCall = new TestClientCall<>(directPathAttrs);
    interceptor
        .interceptCall(READ_OBJECT_METHOD, CallOptions.DEFAULT, new TestChannel(standardCall))
        .start(new TestListener<>(), new Metadata());
    standardCall.close(Status.OK, validTrailers);
    assertThat(findMetric(StorageClientMetrics.METRIC_GCP_STORAGE_CLIENT_SERVER_DURATION)).isNull();

    // Debug enabled: records exact 7-key server.duration on valid 10-byte trailer; skips absent.
    StorageGrpcMetricsInterceptor debugInterceptor = createDebugInterceptor();

    TestClientCall<Void, Void> noTrailerCall = new TestClientCall<>(directPathAttrs);
    debugInterceptor
        .interceptCall(READ_OBJECT_METHOD, CallOptions.DEFAULT, new TestChannel(noTrailerCall))
        .start(new TestListener<>(), new Metadata());
    noTrailerCall.close(Status.OK, new Metadata());
    assertThat(findMetric(StorageClientMetrics.METRIC_GCP_STORAGE_CLIENT_SERVER_DURATION)).isNull();

    TestClientCall<Void, Void> withTrailerCall = new TestClientCall<>(directPathAttrs);
    debugInterceptor
        .interceptCall(READ_OBJECT_METHOD, CallOptions.DEFAULT, new TestChannel(withTrailerCall))
        .start(new TestListener<>(), new Metadata());
    withTrailerCall.close(Status.OK, validTrailers);

    MetricData serverDuration =
        findMetric(StorageClientMetrics.METRIC_GCP_STORAGE_CLIENT_SERVER_DURATION);
    assertThat(serverDuration).isNotNull();
    assertThat(serverDuration.getHistogramData().getPoints()).hasSize(1);
    HistogramPointData point = serverDuration.getHistogramData().getPoints().iterator().next();
    assertThat(point.getCount()).isEqualTo(1L);
    assertThat(point.getSum()).isWithin(1e-6).of(0.25);
    assertThat(point.getAttributes())
        .isEqualTo(
            io.opentelemetry.api.common.Attributes.builder()
                .put(
                    StorageClientMetrics.KEY_GCP_CLIENT_SERVICE,
                    StorageClientMetrics.SERVICE_STORAGE)
                .put(StorageClientMetrics.KEY_GCP_CLIENT_VERSION, StorageOptions.version())
                .put(
                    StorageClientMetrics.KEY_GCP_CLIENT_ARTIFACT,
                    StorageClientMetrics.ARTIFACT_STORAGE)
                .put(StorageClientMetrics.KEY_RPC_SYSTEM_NAME, "grpc")
                .put(StorageClientMetrics.KEY_SERVER_ADDRESS, "storage.googleapis.com")
                .put(StorageClientMetrics.KEY_GCP_STORAGE_OPERATION, "ReadObject")
                .put(
                    StorageClientMetrics.KEY_NETWORK_PATH,
                    StorageClientMetrics.NETWORK_PATH_DIRECTPATH)
                .build());
  }

  @Test
  public void interceptCall_serverUnreached_directPathAndCloudPathRules() throws Exception {
    Attributes directPathAttrs =
        Attributes.newBuilder()
            .set(
                Grpc.TRANSPORT_ATTR_REMOTE_ADDR,
                new InetSocketAddress(InetAddress.getByName("34.126.1.2"), 443))
            .build();
    Attributes cloudPathAttrs =
        Attributes.newBuilder()
            .set(
                Grpc.TRANSPORT_ATTR_REMOTE_ADDR,
                new InetSocketAddress(InetAddress.getByName("142.250.1.1"), 443))
            .build();
    Metadata headerWithUploadId = new Metadata();
    headerWithUploadId.put(StorageGrpcMetricsInterceptor.UPLOADER_UPLOAD_ID_KEY, "upload-1");
    Metadata headerWithEmptyUploadId = new Metadata();
    headerWithEmptyUploadId.put(StorageGrpcMetricsInterceptor.UPLOADER_UPLOAD_ID_KEY, "");
    Metadata trailerWithStats = new Metadata();
    trailerWithStats.put(
        StorageGrpcMetricsInterceptor.GRPC_SERVER_STATS_BIN_KEY,
        encodeServerStats(0, 0, 50_000_000L));
    Metadata trailerNonEmpty = new Metadata();
    trailerNonEmpty.put(Metadata.Key.of("x-custom-trailer", Metadata.ASCII_STRING_MARSHALLER), "v");

    // DirectPath & unknown: only pre-server errors with no headers/trailers/stats/OK are unreached.
    assertServerUnreached(
        "dp connection error",
        directPathAttrs,
        null,
        new Metadata(),
        Status.UNAVAILABLE.withCause(new IOException("connect failed")),
        StorageClientMetrics.NETWORK_PATH_DIRECTPATH,
        StorageErrorTypeMapper.STATUS_CONNECTION_ERROR);
    assertServerUnreached(
        "dp dns failure",
        directPathAttrs,
        null,
        new Metadata(),
        Status.UNAVAILABLE.withCause(new UnknownHostException("dns")),
        StorageClientMetrics.NETWORK_PATH_DIRECTPATH,
        StorageErrorTypeMapper.STATUS_DNS_FAILURE);
    assertServerUnreached(
        "dp tls failure",
        directPathAttrs,
        null,
        new Metadata(),
        Status.UNAVAILABLE.withCause(new SSLException("tls")),
        StorageClientMetrics.NETWORK_PATH_DIRECTPATH,
        StorageErrorTypeMapper.STATUS_TLS_FAILURE);
    assertServerUnreached(
        "dp authentication error",
        directPathAttrs,
        null,
        new Metadata(),
        Status.UNAUTHENTICATED.withCause(new AuthenticationException("token failed")),
        StorageClientMetrics.NETWORK_PATH_DIRECTPATH,
        StorageErrorTypeMapper.STATUS_AUTHENTICATION_ERROR);
    assertServerUnreached(
        "unknown path pre-connect error",
        Attributes.EMPTY,
        null,
        new Metadata(),
        Status.UNAVAILABLE.withCause(new IOException("connection refused")),
        StorageClientMetrics.NETWORK_PATH_UNKNOWN,
        StorageErrorTypeMapper.STATUS_CONNECTION_ERROR);
    assertServerUnreached(
        "dp bare UNAVAILABLE not pre-server",
        directPathAttrs,
        null,
        new Metadata(),
        Status.UNAVAILABLE,
        null,
        null);
    assertServerUnreached(
        "dp connection error after headers received",
        directPathAttrs,
        new Metadata(),
        new Metadata(),
        Status.UNAVAILABLE.withCause(new IOException("reset")),
        null,
        null);
    assertServerUnreached(
        "dp connection error with non-empty trailers",
        directPathAttrs,
        null,
        trailerNonEmpty,
        Status.UNAVAILABLE.withCause(new IOException("reset")),
        null,
        null);
    assertServerUnreached(
        "dp OK without headers", directPathAttrs, null, new Metadata(), Status.OK, null, null);

    // CloudPath: unreached when no stats-bin and no x-guploader-uploadid, excluding client aborts.
    assertServerUnreached(
        "cp UNAVAILABLE without markers",
        cloudPathAttrs,
        null,
        new Metadata(),
        Status.UNAVAILABLE,
        StorageClientMetrics.NETWORK_PATH_CLOUDPATH,
        StorageErrorTypeMapper.STATUS_UNAVAILABLE);
    assertServerUnreached(
        "cp empty upload id header treated as absent",
        cloudPathAttrs,
        headerWithEmptyUploadId,
        new Metadata(),
        Status.UNAVAILABLE,
        StorageClientMetrics.NETWORK_PATH_CLOUDPATH,
        StorageErrorTypeMapper.STATUS_UNAVAILABLE);
    assertServerUnreached(
        "cp reached via header upload id",
        cloudPathAttrs,
        headerWithUploadId,
        new Metadata(),
        Status.UNAVAILABLE,
        null,
        null);
    assertServerUnreached(
        "cp reached via trailer upload id",
        cloudPathAttrs,
        null,
        headerWithUploadId,
        Status.UNAVAILABLE,
        null,
        null);
    assertServerUnreached(
        "cp reached via server stats bin",
        cloudPathAttrs,
        null,
        trailerWithStats,
        Status.UNAVAILABLE,
        null,
        null);
    assertServerUnreached(
        "cp CANCELLED ambiguous abort",
        cloudPathAttrs,
        null,
        new Metadata(),
        Status.CANCELLED,
        null,
        null);
    assertServerUnreached(
        "cp DEADLINE_EXCEEDED ambiguous abort",
        cloudPathAttrs,
        null,
        new Metadata(),
        Status.DEADLINE_EXCEEDED,
        null,
        null);
    assertServerUnreached(
        "cp TIMEOUT ambiguous abort",
        cloudPathAttrs,
        null,
        new Metadata(),
        Status.UNAVAILABLE.withCause(new TimeoutException("timed out")),
        null,
        null);
  }

  @Test
  public void interceptCall_withStorageMetricsContext_propagatesContextAndFeedsNetworkPath()
      throws Exception {
    StorageMetricsContext metricsContext = metrics.createContext("CustomOperation");
    CallOptions callOptions = metricsContext.attach(CallOptions.DEFAULT);

    Attributes directPathAttrs =
        Attributes.newBuilder()
            .set(
                Grpc.TRANSPORT_ATTR_REMOTE_ADDR,
                new InetSocketAddress(InetAddress.getByName("34.126.1.2"), 443))
            .build();
    TestClientCall<Void, Void> testCall = new TestClientCall<>(directPathAttrs);
    TestChannel testChannel = new TestChannel(testCall);

    ClientCall<Void, Void> call =
        interceptor.interceptCall(READ_OBJECT_METHOD, callOptions, testChannel);
    call.start(new TestListener<>(), new Metadata());
    clock.advanceNanos(150_000_000L);
    testCall.deliverMessage(null);
    testCall.close(Status.OK, new Metadata());

    metricsContext.recordAttemptSuccess(metrics);

    MetricData rpcDurationData = findMetric(StorageClientMetrics.METRIC_RPC_CLIENT_CALL_DURATION);
    assertThat(rpcDurationData).isNotNull();
    assertThat(rpcDurationData.getHistogramData().getPoints()).hasSize(1);
    HistogramPointData durationPoint =
        rpcDurationData.getHistogramData().getPoints().iterator().next();
    assertThat(durationPoint.getAttributes().get(StorageClientMetrics.KEY_NETWORK_PATH))
        .isEqualTo(StorageClientMetrics.NETWORK_PATH_DIRECTPATH);

    MetricData ttfbData = findMetric(StorageClientMetrics.METRIC_GCP_STORAGE_CLIENT_TTFB);
    assertThat(ttfbData).isNotNull();
    assertThat(ttfbData.getHistogramData().getPoints()).hasSize(1);
    HistogramPointData ttfbPoint = ttfbData.getHistogramData().getPoints().iterator().next();
    assertThat(ttfbPoint.getSum()).isWithin(1e-6).of(0.15);
    assertThat(ttfbPoint.getAttributes().get(StorageClientMetrics.KEY_GCP_STORAGE_OPERATION))
        .isEqualTo("CustomOperation");
    assertThat(ttfbPoint.getAttributes().get(StorageClientMetrics.KEY_NETWORK_PATH))
        .isEqualTo(StorageClientMetrics.NETWORK_PATH_DIRECTPATH);

    MetricData attemptsData = findMetric(StorageClientMetrics.METRIC_GCP_STORAGE_CLIENT_ATTEMPTS);
    assertThat(attemptsData).isNotNull();
    assertThat(
            attemptsData
                .getLongSumData()
                .getPoints()
                .iterator()
                .next()
                .getAttributes()
                .get(StorageClientMetrics.KEY_NETWORK_PATH))
        .isEqualTo(StorageClientMetrics.NETWORK_PATH_DIRECTPATH);
  }

  @Test
  public void interceptCall_streamingReadOnHeaders_setsNetworkPathBeforeOnClose() throws Exception {
    StorageMetricsContext metricsContext = metrics.createContext("ReadObject");
    CallOptions callOptions = metricsContext.attach(CallOptions.DEFAULT);

    Attributes directPathAttrs =
        Attributes.newBuilder()
            .set(
                Grpc.TRANSPORT_ATTR_REMOTE_ADDR,
                new InetSocketAddress(InetAddress.getByName("34.126.0.1"), 443))
            .build();
    TestClientCall<Void, Void> testCall = new TestClientCall<>(directPathAttrs);
    TestChannel testChannel = new TestChannel(testCall);

    ClientCall<Void, Void> call =
        interceptor.interceptCall(READ_OBJECT_METHOD, callOptions, testChannel);
    TestListener<Void> listener = new TestListener<>();
    call.start(listener, new Metadata());

    // Simulate streaming ReadObject where headers arrive and the attempt completes before onClose
    testCall.receiveHeaders(new Metadata());
    assertThat(listener.headersReceived).isTrue();
    metricsContext.recordAttemptSuccess(metrics);

    MetricData attemptsData = findMetric(StorageClientMetrics.METRIC_GCP_STORAGE_CLIENT_ATTEMPTS);
    assertThat(attemptsData).isNotNull();
    assertThat(
            attemptsData
                .getLongSumData()
                .getPoints()
                .iterator()
                .next()
                .getAttributes()
                .get(StorageClientMetrics.KEY_NETWORK_PATH))
        .isEqualTo(StorageClientMetrics.NETWORK_PATH_DIRECTPATH);
  }

  @Test
  public void interceptCall_withoutStorageMetricsContext_asyncOnCloseUsesCallerContext()
      throws Exception {
    ContextKey<String> testKey = ContextKey.named("caller-trace-key");
    Context callerContext = Context.root().with(testKey, "caller-trace-value");
    Context callbackThreadContext = Context.root().with(testKey, "callback-thread-value");

    List<Context> recordedContexts = Collections.synchronizedList(new ArrayList<>());
    DoubleHistogram mockHistogram = Mockito.mock(DoubleHistogram.class);
    Mockito.doAnswer(
            invocation -> {
              recordedContexts.add(invocation.getArgument(2));
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
        .thenReturn(Mockito.mock(LongHistogramBuilder.class, Mockito.RETURNS_DEEP_STUBS));

    Meter mockMeter = Mockito.mock(Meter.class, Mockito.RETURNS_DEEP_STUBS);
    Mockito.when(mockMeter.histogramBuilder(Mockito.anyString())).thenReturn(mockHistBuilder);

    MeterBuilder mockMeterBuilder = Mockito.mock(MeterBuilder.class, Mockito.RETURNS_SELF);
    Mockito.when(mockMeterBuilder.build()).thenReturn(mockMeter);

    MeterProvider mockMeterProvider = Mockito.mock(MeterProvider.class);
    Mockito.when(mockMeterProvider.meterBuilder(Mockito.anyString())).thenReturn(mockMeterBuilder);

    StorageClientMetrics mockClientMetrics =
        StorageOptions.grpc()
            .setProjectId("test-project")
            .setCredentials(NoCredentials.getInstance())
            .setEnableOtelMetrics(true)
            .setMeterProvider(mockMeterProvider)
            .build()
            .getStorageClientMetrics();
    StorageGrpcMetricsInterceptor mockInterceptor =
        new StorageGrpcMetricsInterceptor(mockClientMetrics, clock);

    TestClientCall<Void, Void> testCall = new TestClientCall<>(Attributes.EMPTY);
    TestChannel testChannel = new TestChannel(testCall);

    final ClientCall<Void, Void> call;
    try (Scope ignored = callerContext.makeCurrent()) {
      call = mockInterceptor.interceptCall(READ_OBJECT_METHOD, CallOptions.DEFAULT, testChannel);
    }
    call.start(new TestListener<>(), new Metadata());

    CountDownLatch latch = new CountDownLatch(1);
    Thread asyncCallbackThread =
        new Thread(
            () -> {
              try (Scope ignored = callbackThreadContext.makeCurrent()) {
                testCall.deliverMessage(null);
                testCall.close(Status.OK, new Metadata());
              } finally {
                latch.countDown();
              }
            });
    asyncCallbackThread.start();
    assertThat(latch.await(5, TimeUnit.SECONDS)).isTrue();

    assertThat(recordedContexts).hasSize(2);
    for (Context ctx : recordedContexts) {
      assertThat(ctx).isSameInstanceAs(callerContext);
      assertThat(ctx.get(testKey)).isEqualTo("caller-trace-value");
    }
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

    ClientInterceptor customInterceptor = StorageGrpcMetricsInterceptorTest::passthroughCall;

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

    GrpcInterceptorProvider userProvider = () -> ImmutableList.of(customInterceptor);
    GrpcStorageOptions disabledCustomOptions =
        StorageOptions.grpc()
            .setProjectId("test-project")
            .setCredentials(NoCredentials.getInstance())
            .setEnableOtelMetrics(false)
            .setGrpcInterceptorProvider(userProvider)
            .build();
    InstantiatingGrpcChannelProvider disabledCustomChannelProvider =
        (InstantiatingGrpcChannelProvider)
            disabledCustomOptions.getStorageSettings().getTransportChannelProvider();
    GrpcInterceptorProvider disabledCustomExtracted =
        extractInterceptorProvider(disabledCustomChannelProvider);
    assertThat(disabledCustomExtracted).isSameInstanceAs(userProvider);
    assertThat(disabledCustomExtracted.getInterceptors()).containsExactly(customInterceptor);

    GrpcStorageOptions disabledDefaultOptions =
        StorageOptions.grpc()
            .setProjectId("test-project")
            .setCredentials(NoCredentials.getInstance())
            .setEnableOtelMetrics(false)
            .build();
    InstantiatingGrpcChannelProvider disabledDefaultChannelProvider =
        (InstantiatingGrpcChannelProvider)
            disabledDefaultOptions.getStorageSettings().getTransportChannelProvider();
    assertThat(extractInterceptorProvider(disabledDefaultChannelProvider)).isNull();
  }

  private void assertServerUnreached(
      String label,
      Attributes attrs,
      @Nullable Metadata headers,
      Metadata trailers,
      Status status,
      @Nullable String expectedNetworkPath,
      @Nullable String expectedErrorType) {
    InMemoryMetricReader caseReader = InMemoryMetricReader.create();
    SdkMeterProvider caseProvider =
        SdkMeterProvider.builder().registerMetricReader(caseReader).build();
    StorageClientMetrics caseMetrics =
        StorageOptions.grpc()
            .setProjectId("test-project")
            .setCredentials(NoCredentials.getInstance())
            .setEnableOtelMetrics(true)
            .setMeterProvider(caseProvider)
            .build()
            .getStorageClientMetrics();
    TestClientCall<Void, Void> testCall = new TestClientCall<>(attrs);
    new StorageGrpcMetricsInterceptor(caseMetrics, clock)
        .interceptCall(READ_OBJECT_METHOD, CallOptions.DEFAULT, new TestChannel(testCall))
        .start(new TestListener<>(), new Metadata());
    if (headers != null) {
      testCall.receiveHeaders(headers);
    }
    testCall.close(status, trailers);

    MetricData unreached =
        findMetric(caseReader, StorageClientMetrics.METRIC_GCP_STORAGE_CLIENT_SERVER_UNREACHED);
    if (expectedErrorType == null) {
      assertWithMessage(label).that(unreached).isNull();
      return;
    }
    assertWithMessage(label).that(unreached).isNotNull();
    assertWithMessage(label).that(unreached.getUnit()).isEqualTo("{request}");
    assertWithMessage(label).that(unreached.getLongSumData().getPoints()).hasSize(1);
    LongPointData point = unreached.getLongSumData().getPoints().iterator().next();
    assertWithMessage(label).that(point.getValue()).isEqualTo(1L);
    assertWithMessage(label)
        .that(point.getAttributes())
        .isEqualTo(
            io.opentelemetry.api.common.Attributes.builder()
                .put(
                    StorageClientMetrics.KEY_GCP_CLIENT_SERVICE,
                    StorageClientMetrics.SERVICE_STORAGE)
                .put(StorageClientMetrics.KEY_GCP_CLIENT_VERSION, StorageOptions.version())
                .put(
                    StorageClientMetrics.KEY_GCP_CLIENT_ARTIFACT,
                    StorageClientMetrics.ARTIFACT_STORAGE)
                .put(StorageClientMetrics.KEY_RPC_SYSTEM_NAME, "grpc")
                .put(StorageClientMetrics.KEY_SERVER_ADDRESS, "storage.googleapis.com")
                .put(StorageClientMetrics.KEY_GCP_STORAGE_OPERATION, "ReadObject")
                .put(StorageClientMetrics.KEY_NETWORK_PATH, expectedNetworkPath)
                .put(StorageClientMetrics.KEY_ERROR_TYPE, expectedErrorType)
                .build());
  }

  private StorageGrpcMetricsInterceptor createDebugInterceptor() {
    StorageClientMetrics debugMetrics =
        StorageOptions.grpc()
            .setProjectId("test-project")
            .setCredentials(NoCredentials.getInstance())
            .setEnableOtelMetrics(true)
            .setEnableOtelDebugMetrics(true)
            .setMeterProvider(meterProvider)
            .build()
            .getStorageClientMetrics();
    return new StorageGrpcMetricsInterceptor(debugMetrics, clock);
  }

  private static byte[] encodeServerStats(int version, int fieldId, long nanos) {
    return ByteBuffer.allocate(10)
        .order(ByteOrder.LITTLE_ENDIAN)
        .put((byte) version)
        .put((byte) fieldId)
        .putLong(nanos)
        .array();
  }

  private LongPointData requestActivePoint() {
    MetricData metric = findMetric(StorageClientMetrics.METRIC_GCP_STORAGE_CLIENT_REQUEST_ACTIVE);
    assertThat(metric).isNotNull();
    assertThat(metric.getLongSumData().getPoints()).hasSize(1);
    return metric.getLongSumData().getPoints().iterator().next();
  }

  private @Nullable MetricData findMetric(String name) {
    return findMetric(reader, name);
  }

  private static @Nullable MetricData findMetric(InMemoryMetricReader metricReader, String name) {
    return metricReader.collectAllMetrics().stream()
        .filter(m -> m.getName().equals(name))
        .findFirst()
        .orElse(null);
  }

  private static <ReqT, RespT> ClientCall<ReqT, RespT> passthroughCall(
      MethodDescriptor<ReqT, RespT> method, CallOptions callOptions, Channel next) {
    return next.newCall(method, callOptions);
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

    void receiveHeaders(Metadata headers) {
      if (listener != null) {
        listener.onHeaders(headers);
      }
    }

    void deliverMessage(@Nullable RespT message) {
      if (listener != null) {
        listener.onMessage(message);
      }
    }

    void close(Status status, Metadata trailers) {
      if (listener != null) {
        listener.onClose(status, trailers);
      }
    }
  }

  private static final class TestChannel extends Channel {
    private final TestClientCall<?, ?> call;

    TestChannel(TestClientCall<?, ?> call) {
      this.call = call;
    }

    @SuppressWarnings("unchecked")
    @Override
    public <RequestT, ResponseT> ClientCall<RequestT, ResponseT> newCall(
        MethodDescriptor<RequestT, ResponseT> methodDescriptor, CallOptions callOptions) {
      return (ClientCall<RequestT, ResponseT>) call;
    }

    @Override
    public String authority() {
      return "storage.googleapis.com";
    }
  }

  private static final class TestListener<RespT> extends ClientCall.Listener<RespT> {
    boolean headersReceived = false;

    @Override
    public void onHeaders(Metadata headers) {
      headersReceived = true;
    }
  }

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
