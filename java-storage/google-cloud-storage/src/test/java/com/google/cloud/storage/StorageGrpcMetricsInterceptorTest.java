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
import io.grpc.CallOptions;
import io.grpc.Channel;
import io.grpc.ClientCall;
import io.grpc.Grpc;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.Status;
import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.sdk.metrics.SdkMeterProvider;
import io.opentelemetry.sdk.metrics.data.HistogramPointData;
import io.opentelemetry.sdk.metrics.data.MetricData;
import io.opentelemetry.sdk.testing.exporter.InMemoryMetricReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicLong;
import org.junit.Before;
import org.junit.Test;

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

  @Before
  public void setUp() {
    reader = InMemoryMetricReader.create();
    meterProvider = SdkMeterProvider.builder().registerMetricReader(reader).build();
    clock = new FakeClock();
  }

  @Test
  public void extractShortMethodName_variousInputs() {
    assertThat(
            StorageGrpcMetricsInterceptor.extractShortMethodName(
                "google.storage.v2.Storage/ReadObject"))
        .isEqualTo("ReadObject");
    assertThat(StorageGrpcMetricsInterceptor.extractShortMethodName("ReadObject"))
        .isEqualTo("ReadObject");
    assertThat(StorageGrpcMetricsInterceptor.extractShortMethodName("a/b/c")).isEqualTo("c");
    assertThat(StorageGrpcMetricsInterceptor.extractShortMethodName(null)).isEqualTo("UNKNOWN");
    assertThat(StorageGrpcMetricsInterceptor.extractShortMethodName("")).isEqualTo("UNKNOWN");
    assertThat(StorageGrpcMetricsInterceptor.extractShortMethodName("/")).isEqualTo("/");
  }

  @Test
  public void isDirectPathIp_ipv4AndIpv6() throws Exception {
    assertThat(StorageGrpcMetricsInterceptor.isDirectPathIp(InetAddress.getByName("34.126.0.1")))
        .isTrue();
    assertThat(StorageGrpcMetricsInterceptor.isDirectPathIp(InetAddress.getByName("34.126.63.254")))
        .isTrue();
    assertThat(StorageGrpcMetricsInterceptor.isDirectPathIp(InetAddress.getByName("34.126.64.1")))
        .isFalse();
    assertThat(StorageGrpcMetricsInterceptor.isDirectPathIp(InetAddress.getByName("142.250.1.1")))
        .isFalse();

    assertThat(
            StorageGrpcMetricsInterceptor.isDirectPathIp(
                InetAddress.getByName("2001:4860:8040:0000:0000:0000:0000:0001")))
        .isTrue();
    assertThat(
            StorageGrpcMetricsInterceptor.isDirectPathIp(
                InetAddress.getByName("2001:4860:807f:ffff:ffff:ffff:ffff:ffff")))
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
    io.grpc.Attributes directPathAttrs =
        io.grpc.Attributes.newBuilder()
            .set(
                Grpc.TRANSPORT_ATTR_REMOTE_ADDR,
                new InetSocketAddress(InetAddress.getByName("34.126.1.2"), 443))
            .build();
    assertThat(StorageGrpcMetricsInterceptor.detectNetworkPath(directPathAttrs, null))
        .isEqualTo(StorageClientMetrics.NETWORK_PATH_DIRECTPATH);

    io.grpc.Attributes cloudPathAttrs =
        io.grpc.Attributes.newBuilder()
            .set(
                Grpc.TRANSPORT_ATTR_REMOTE_ADDR,
                new InetSocketAddress(InetAddress.getByName("142.250.1.1"), 443))
            .build();
    assertThat(StorageGrpcMetricsInterceptor.detectNetworkPath(cloudPathAttrs, null))
        .isEqualTo(StorageClientMetrics.NETWORK_PATH_CLOUDPATH);

    assertThat(
            StorageGrpcMetricsInterceptor.detectNetworkPath(
                null, "google-c2p:///storage.googleapis.com"))
        .isEqualTo(StorageClientMetrics.NETWORK_PATH_DIRECTPATH);
    assertThat(
            StorageGrpcMetricsInterceptor.detectNetworkPath(null, "https://storage.googleapis.com"))
        .isEqualTo(StorageClientMetrics.NETWORK_PATH_UNKNOWN);
    assertThat(StorageGrpcMetricsInterceptor.detectNetworkPath(null, null))
        .isEqualTo(StorageClientMetrics.NETWORK_PATH_UNKNOWN);
  }

  @Test
  public void interceptCall_unaryCallSuccess_recordsMetricWithErrorTypeOk() throws Exception {
    StorageClientMetrics metrics = StorageClientMetrics.create(meterProvider, true, false);
    StorageGrpcMetricsInterceptor interceptor =
        new StorageGrpcMetricsInterceptor(metrics, clock, "https://storage.googleapis.com");

    io.grpc.Attributes callAttrs =
        io.grpc.Attributes.newBuilder()
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

    Attributes attrs = point.getAttributes();
    assertThat(attrs.get(StorageClientMetrics.KEY_RPC_SYSTEM_NAME)).isEqualTo("grpc");
    assertThat(attrs.get(StorageClientMetrics.KEY_RPC_METHOD)).isEqualTo("ReadObject");
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

    TestClientCall<Void, Void> testCall = new TestClientCall<>(io.grpc.Attributes.EMPTY);
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

    TestClientCall<Void, Void> testCall = new TestClientCall<>(io.grpc.Attributes.EMPTY);
    TestChannel testChannel = new TestChannel(testCall, "storage.googleapis.com");

    ClientCall<Void, Void> call =
        interceptor.interceptCall(READ_OBJECT_METHOD, CallOptions.DEFAULT, testChannel);
    call.start(new TestListener<>(), new Metadata());
    testCall.close(Status.OK, new Metadata());

    assertThat(reader.collectAllMetrics()).isEmpty();
  }

  private static final class TestClientCall<ReqT, RespT> extends ClientCall<ReqT, RespT> {
    private Listener<RespT> listener;
    private final io.grpc.Attributes attributes;

    TestClientCall(io.grpc.Attributes attributes) {
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
    public io.grpc.Attributes getAttributes() {
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
