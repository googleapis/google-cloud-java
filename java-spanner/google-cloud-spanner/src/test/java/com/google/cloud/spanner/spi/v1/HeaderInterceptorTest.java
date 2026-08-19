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

package com.google.cloud.spanner.spi.v1;

import static com.google.api.gax.grpc.GrpcCallContext.TRACER_KEY;
import static com.google.cloud.spanner.XGoogSpannerRequestId.REQUEST_ID_HEADER_KEY;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import com.google.cloud.spanner.CompositeTracer;
import com.google.cloud.spanner.SpannerRpcMetrics;
import com.google.common.collect.ImmutableList;
import io.grpc.CallOptions;
import io.grpc.Channel;
import io.grpc.ClientCall;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.MethodDescriptor.Marshaller;
import io.grpc.Status;
import io.opentelemetry.api.OpenTelemetry;
import java.io.InputStream;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/** Unit tests for {@link HeaderInterceptor}. */
@RunWith(JUnit4.class)
public class HeaderInterceptorTest {

  private static final Metadata.Key<String> SERVER_TIMING_HEADER_KEY =
      Metadata.Key.of("server-timing", Metadata.ASCII_STRING_MARSHALLER);
  private static final Metadata.Key<String> GOOGLE_CLOUD_RESOURCE_PREFIX_KEY =
      Metadata.Key.of("google-cloud-resource-prefix", Metadata.ASCII_STRING_MARSHALLER);

  private HeaderInterceptor interceptor;

  @Before
  public void setUp() {
    interceptor = new HeaderInterceptor(new SpannerRpcMetrics(OpenTelemetry.noop()));
    RequestIdTargetTracker.clear();
  }

  @After
  public void tearDown() {
    RequestIdTargetTracker.clear();
  }

  @Test
  public void testPerCallLatencyIsolation() {
    TestCompositeTracer tracer1 = new TestCompositeTracer();
    TestCompositeTracer tracer2 = new TestCompositeTracer();

    CallOptions callOptions1 = CallOptions.DEFAULT.withOption(TRACER_KEY, tracer1);
    CallOptions callOptions2 = CallOptions.DEFAULT.withOption(TRACER_KEY, tracer2);

    MethodDescriptor<String, String> methodDescriptor = createMethodDescriptor();
    FakeChannel channel = new FakeChannel();

    ClientCall<String, String> call1 =
        interceptor.interceptCall(methodDescriptor, callOptions1, channel);
    ClientCall<String, String> call2 =
        interceptor.interceptCall(methodDescriptor, callOptions2, channel);

    Metadata headers1 = createDefaultHeaders("1.0000000000000001.1.1.1.1");
    Metadata headers2 = createDefaultHeaders("1.0000000000000002.1.1.2.1");

    CapturingListener<String> responseListener1 = new CapturingListener<>();
    CapturingListener<String> responseListener2 = new CapturingListener<>();

    call1.start(responseListener1, headers1);
    call2.start(responseListener2, headers2);

    Metadata responseHeaders1 = new Metadata();
    responseHeaders1.put(SERVER_TIMING_HEADER_KEY, "gfet4t7; dur=123.45, afe; dur=67.89");

    Metadata responseHeaders2 = new Metadata();
    responseHeaders2.put(SERVER_TIMING_HEADER_KEY, "gfet4t7; dur=999.0, afe; dur=888.0");

    // Interleave headers: call1 then call2
    channel.lastListener.onHeaders(responseHeaders2); // Call 2 listener
    channel.capturedListeners.get(0).onHeaders(responseHeaders1); // Call 1 listener

    // Close call 2 first, then call 1
    channel.lastListener.onClose(Status.OK, new Metadata());
    channel.capturedListeners.get(0).onClose(Status.OK, new Metadata());

    // Verify Call 1 received its own latencies, not Call 2's
    assertEquals(Float.valueOf(123.45f), tracer1.recordedGfeLatency);
    assertEquals(Float.valueOf(67.89f), tracer1.recordedAfeLatency);

    // Verify Call 2 received its own latencies
    assertEquals(Float.valueOf(999.0f), tracer2.recordedGfeLatency);
    assertEquals(Float.valueOf(888.0f), tracer2.recordedAfeLatency);

    assertTrue(responseListener1.closed.get());
    assertTrue(responseListener2.closed.get());
  }

  @Test
  public void testLatencyNotPollutedWhenSecondCallHasNoHeader() {
    TestCompositeTracer tracer1 = new TestCompositeTracer();
    TestCompositeTracer tracer2 = new TestCompositeTracer();

    CallOptions callOptions1 = CallOptions.DEFAULT.withOption(TRACER_KEY, tracer1);
    CallOptions callOptions2 = CallOptions.DEFAULT.withOption(TRACER_KEY, tracer2);

    MethodDescriptor<String, String> methodDescriptor = createMethodDescriptor();
    FakeChannel channel = new FakeChannel();

    ClientCall<String, String> call1 =
        interceptor.interceptCall(methodDescriptor, callOptions1, channel);
    ClientCall<String, String> call2 =
        interceptor.interceptCall(methodDescriptor, callOptions2, channel);

    Metadata headers1 = createDefaultHeaders("1.0000000000000001.1.1.1.1");
    Metadata headers2 = createDefaultHeaders("1.0000000000000002.1.1.2.1");

    CapturingListener<String> responseListener1 = new CapturingListener<>();
    CapturingListener<String> responseListener2 = new CapturingListener<>();

    call1.start(responseListener1, headers1);
    call2.start(responseListener2, headers2);

    Metadata responseHeaders1 = new Metadata();
    responseHeaders1.put(SERVER_TIMING_HEADER_KEY, "gfet4t7; dur=150.0");

    Metadata responseHeaders2 = new Metadata(); // No server-timing header

    channel.capturedListeners.get(0).onHeaders(responseHeaders1);
    channel.capturedListeners.get(1).onHeaders(responseHeaders2);

    channel.capturedListeners.get(1).onClose(Status.OK, new Metadata());
    channel.capturedListeners.get(0).onClose(Status.OK, new Metadata());

    assertEquals(Float.valueOf(150.0f), tracer1.recordedGfeLatency);
    assertNull(tracer2.recordedGfeLatency);
    assertNull(tracer2.recordedAfeLatency);
  }

  @Test
  public void testOnCloseGuaranteesDownstreamNotificationEvenOnException() {
    TestCompositeTracer throwingTracer =
        new TestCompositeTracer() {
          @Override
          public void recordServerTimingHeaderMetrics(
              Float gfeLatency, Float afeLatency, boolean isDirectPathUsed, boolean isAfeEnabled) {
            throw new RuntimeException("Simulated metric recording failure");
          }
        };

    CallOptions callOptions = CallOptions.DEFAULT.withOption(TRACER_KEY, throwingTracer);
    MethodDescriptor<String, String> methodDescriptor = createMethodDescriptor();
    FakeChannel channel = new FakeChannel();

    String requestId = "1.0000000000000001.1.1.1.1";
    RequestIdTargetTracker.record(requestId, "test-database", "endpoint-1", 100L, false);
    assertNotNull(RequestIdTargetTracker.get(requestId));

    ClientCall<String, String> call =
        interceptor.interceptCall(methodDescriptor, callOptions, channel);
    CapturingListener<String> responseListener = new CapturingListener<>();
    call.start(responseListener, createDefaultHeaders(requestId));

    // Deliver onClose - even though metric recording throws, onClose must propagate downstream
    channel.lastListener.onClose(Status.OK, new Metadata());

    assertTrue(
        "Downstream listener must receive onClose despite metric recording error",
        responseListener.closed.get());
    assertEquals(Status.OK, responseListener.closedStatus.get());

    // RequestIdTargetTracker must still be cleaned up in finally block
    assertNull(
        "RequestIdTargetTracker must clean up tracking entry in finally",
        RequestIdTargetTracker.get(requestId));
  }

  @Test
  public void testOnHeadersGuaranteesDownstreamNotificationEvenOnException() {
    MethodDescriptor<String, String> methodDescriptor = createMethodDescriptor();
    FakeChannel channel = new FakeChannel();

    ClientCall<String, String> call =
        interceptor.interceptCall(methodDescriptor, CallOptions.DEFAULT, channel);
    CapturingListener<String> responseListener = new CapturingListener<>();
    call.start(responseListener, createDefaultHeaders("1.0000000000000001.1.1.1.1"));

    Metadata corruptedHeaders = new Metadata();
    corruptedHeaders.put(SERVER_TIMING_HEADER_KEY, "gfet4t7; dur=invalid_number");

    channel.lastListener.onHeaders(corruptedHeaders);

    assertTrue(
        "Downstream listener must receive onHeaders despite parsing anomaly",
        responseListener.headersReceived.get());
  }

  @Test
  public void testCallWithoutRequestIdDoesNotThrowException() {
    TestCompositeTracer tracer = new TestCompositeTracer();
    CallOptions callOptions = CallOptions.DEFAULT.withOption(TRACER_KEY, tracer);
    MethodDescriptor<String, String> methodDescriptor = createMethodDescriptor();
    FakeChannel channel = new FakeChannel();

    ClientCall<String, String> call =
        interceptor.interceptCall(methodDescriptor, callOptions, channel);
    CapturingListener<String> responseListener = new CapturingListener<>();

    // Start with headers that do NOT contain REQUEST_ID_HEADER_KEY
    Metadata headersWithoutRequestId = new Metadata();
    headersWithoutRequestId.put(
        GOOGLE_CLOUD_RESOURCE_PREFIX_KEY,
        "projects/test-project/instances/test-instance/databases/test-database");
    call.start(responseListener, headersWithoutRequestId);

    Metadata responseHeaders = new Metadata();
    responseHeaders.put(SERVER_TIMING_HEADER_KEY, "gfet4t7; dur=45.0, afe; dur=20.0");
    channel.lastListener.onHeaders(responseHeaders);
    channel.lastListener.onClose(Status.OK, new Metadata());

    assertEquals(Float.valueOf(45.0f), tracer.recordedGfeLatency);
    assertEquals(Float.valueOf(20.0f), tracer.recordedAfeLatency);
    assertTrue(responseListener.closed.get());
    assertEquals(Status.OK, responseListener.closedStatus.get());
  }

  private static Metadata createDefaultHeaders(String requestId) {
    Metadata headers = new Metadata();
    headers.put(REQUEST_ID_HEADER_KEY, requestId);
    headers.put(
        GOOGLE_CLOUD_RESOURCE_PREFIX_KEY,
        "projects/test-project/instances/test-instance/databases/test-database");
    return headers;
  }

  private static MethodDescriptor<String, String> createMethodDescriptor() {
    return MethodDescriptor.<String, String>newBuilder()
        .setType(MethodDescriptor.MethodType.UNARY)
        .setFullMethodName("google.spanner.v1.Spanner/ExecuteSql")
        .setRequestMarshaller(new FakeMarshaller<>())
        .setResponseMarshaller(new FakeMarshaller<>())
        .build();
  }

  private static class TestCompositeTracer extends CompositeTracer {
    Float recordedGfeLatency;
    Float recordedAfeLatency;

    TestCompositeTracer() {
      super(ImmutableList.of());
    }

    @Override
    public void recordServerTimingHeaderMetrics(
        Float gfeLatency, Float afeLatency, boolean isDirectPathUsed, boolean isAfeEnabled) {
      this.recordedGfeLatency = gfeLatency;
      this.recordedAfeLatency = afeLatency;
    }
  }

  private static class FakeMarshaller<T> implements Marshaller<T> {
    @Override
    public InputStream stream(T value) {
      return null;
    }

    @Override
    public T parse(InputStream stream) {
      return null;
    }
  }

  private static class FakeChannel extends Channel {
    final List<ClientCall.Listener<?>> capturedListeners = new CopyOnWriteArrayList<>();
    ClientCall.Listener<?> lastListener;

    @Override
    public String authority() {
      return "fake-authority";
    }

    @Override
    public <ReqT, RespT> ClientCall<ReqT, RespT> newCall(
        MethodDescriptor<ReqT, RespT> methodDescriptor, CallOptions callOptions) {
      return new ClientCall<ReqT, RespT>() {
        @Override
        public void start(Listener<RespT> responseListener, Metadata headers) {
          capturedListeners.add(responseListener);
          lastListener = responseListener;
        }

        @Override
        public void request(int numMessages) {}

        @Override
        public void cancel(String message, Throwable cause) {}

        @Override
        public void halfClose() {}

        @Override
        public void sendMessage(ReqT message) {}
      };
    }
  }

  private static class CapturingListener<T> extends ClientCall.Listener<T> {
    final AtomicBoolean headersReceived = new AtomicBoolean(false);
    final AtomicBoolean closed = new AtomicBoolean(false);
    final AtomicReference<Status> closedStatus = new AtomicReference<>();

    @Override
    public void onHeaders(Metadata headers) {
      headersReceived.set(true);
    }

    @Override
    public void onClose(Status status, Metadata trailers) {
      closed.set(true);
      closedStatus.set(status);
    }
  }
}
