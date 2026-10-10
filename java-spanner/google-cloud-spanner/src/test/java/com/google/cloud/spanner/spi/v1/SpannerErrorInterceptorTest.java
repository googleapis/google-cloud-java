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

import static com.google.cloud.spanner.XGoogSpannerRequestId.REQUEST_ID_HEADER_KEY;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import com.google.rpc.LocalizedMessage;
import com.google.rpc.ResourceInfo;
import com.google.rpc.RetryInfo;
import io.grpc.CallOptions;
import io.grpc.Channel;
import io.grpc.ClientCall;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.MethodDescriptor.Marshaller;
import io.grpc.Status;
import io.grpc.protobuf.ProtoUtils;
import java.io.InputStream;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/** Unit tests for {@link SpannerErrorInterceptor}. */
@RunWith(JUnit4.class)
public class SpannerErrorInterceptorTest {

  private static final Metadata.Key<LocalizedMessage> LOCALIZED_MESSAGE_KEY =
      ProtoUtils.keyForProto(LocalizedMessage.getDefaultInstance());
  private static final Metadata.Key<ResourceInfo> RESOURCE_INFO_KEY =
      ProtoUtils.keyForProto(ResourceInfo.getDefaultInstance());
  private static final Metadata.Key<RetryInfo> RETRY_INFO_KEY =
      ProtoUtils.keyForProto(RetryInfo.getDefaultInstance());

  private SpannerErrorInterceptor interceptor;

  @Before
  public void setUp() {
    interceptor = new SpannerErrorInterceptor();
  }

  @Test
  public void testOkStatusPassesThroughUnmodified() {
    MethodDescriptor<String, String> methodDescriptor = createMethodDescriptor();
    FakeChannel channel = new FakeChannel();
    ClientCall<String, String> call =
        interceptor.interceptCall(methodDescriptor, CallOptions.DEFAULT, channel);

    CapturingListener<String> responseListener = new CapturingListener<>();
    call.start(responseListener, new Metadata());

    Metadata trailers = new Metadata();
    channel.lastListener.onClose(Status.OK, trailers);

    assertTrue(responseListener.closed.get());
    assertEquals(Status.Code.OK, responseListener.closedStatus.get().getCode());
  }

  @Test
  public void testRetryableInternalErrorTranslatedToUnavailable() {
    MethodDescriptor<String, String> methodDescriptor = createMethodDescriptor();
    FakeChannel channel = new FakeChannel();
    ClientCall<String, String> call =
        interceptor.interceptCall(methodDescriptor, CallOptions.DEFAULT, channel);

    CapturingListener<String> responseListener = new CapturingListener<>();
    call.start(responseListener, new Metadata());

    Status internalError =
        Status.INTERNAL.withDescription(
            "HTTP/2 error code: INTERNAL_ERROR\nReceived unexpected EOS on Data frame");
    channel.lastListener.onClose(internalError, new Metadata());

    assertTrue(responseListener.closed.get());
    assertEquals(Status.Code.UNAVAILABLE, responseListener.closedStatus.get().getCode());
    assertTrue(
        responseListener
            .closedStatus
            .get()
            .getDescription()
            .contains("Received unexpected EOS on Data frame"));
  }

  @Test
  public void testTrailersAugmentStatusDescription() {
    MethodDescriptor<String, String> methodDescriptor = createMethodDescriptor();
    FakeChannel channel = new FakeChannel();
    ClientCall<String, String> call =
        interceptor.interceptCall(methodDescriptor, CallOptions.DEFAULT, channel);

    CapturingListener<String> responseListener = new CapturingListener<>();
    call.start(responseListener, new Metadata());

    Metadata trailers = new Metadata();
    LocalizedMessage localizedMessage =
        LocalizedMessage.newBuilder()
            .setLocale("en-US")
            .setMessage("Detailed user facing error message")
            .build();
    trailers.put(LOCALIZED_MESSAGE_KEY, localizedMessage);

    ResourceInfo resourceInfo =
        ResourceInfo.newBuilder()
            .setResourceType("type.googleapis.com/google.spanner.v1.Database")
            .setResourceName("projects/p/instances/i/databases/d")
            .setDescription("Database resource description")
            .build();
    trailers.put(RESOURCE_INFO_KEY, resourceInfo);

    RetryInfo retryInfo =
        RetryInfo.newBuilder()
            .setRetryDelay(com.google.protobuf.Duration.newBuilder().setSeconds(5).build())
            .build();
    trailers.put(RETRY_INFO_KEY, retryInfo);

    Status errorStatus = Status.NOT_FOUND.withDescription("Original error");
    channel.lastListener.onClose(errorStatus, trailers);

    assertTrue(responseListener.closed.get());
    assertEquals(Status.Code.NOT_FOUND, responseListener.closedStatus.get().getCode());
    String description = responseListener.closedStatus.get().getDescription();
    assertNotNull(description);
    assertTrue(description.contains("Detailed user facing error message"));
    assertTrue(description.contains("Database resource description"));
    assertTrue(description.contains("retry_delay"));
  }

  @Test
  public void testRequestIdCopiedToTrailersIfPresentInHeaders() {
    MethodDescriptor<String, String> methodDescriptor = createMethodDescriptor();
    FakeChannel channel = new FakeChannel();
    ClientCall<String, String> call =
        interceptor.interceptCall(methodDescriptor, CallOptions.DEFAULT, channel);

    CapturingListener<String> responseListener = new CapturingListener<>();
    Metadata headers = new Metadata();
    String requestId = "1.0000000000000001.1.1.1.1";
    headers.put(REQUEST_ID_HEADER_KEY, requestId);
    call.start(responseListener, headers);

    Metadata trailers = new Metadata();
    channel.lastListener.onClose(Status.DEADLINE_EXCEEDED, trailers);

    assertTrue(responseListener.closed.get());
    assertEquals(requestId, responseListener.closedTrailers.get().get(REQUEST_ID_HEADER_KEY));
  }

  @Test
  public void testOnCloseGuaranteesDownstreamNotificationEvenOnUnexpectedException() {
    MethodDescriptor<String, String> methodDescriptor = createMethodDescriptor();
    FakeChannel channel = new FakeChannel();
    ClientCall<String, String> call =
        interceptor.interceptCall(methodDescriptor, CallOptions.DEFAULT, channel);

    CapturingListener<String> responseListener = new CapturingListener<>();
    Metadata headers = new Metadata();
    headers.put(REQUEST_ID_HEADER_KEY, "1.0000000000000001.1.1.1.1");
    call.start(responseListener, headers);

    // Create trailers with invalid binary protobuf payload for LocalizedMessage
    Metadata trailers = new Metadata();
    Metadata.Key<byte[]> rawBinaryKey =
        Metadata.Key.of("google.rpc.localizedmessage-bin", Metadata.BINARY_BYTE_MARSHALLER);
    trailers.put(rawBinaryKey, new byte[] {(byte) 0xFF, (byte) 0xFF, (byte) 0xFF});

    // Deliver onClose - must not throw and must reach downstream listener
    channel.lastListener.onClose(Status.DATA_LOSS.withDescription("Data loss error"), trailers);

    assertTrue(
        "Downstream listener must receive onClose despite unexpected exception in interceptor",
        responseListener.closed.get());
    assertEquals(Status.Code.DATA_LOSS, responseListener.closedStatus.get().getCode());
  }

  private static MethodDescriptor<String, String> createMethodDescriptor() {
    return MethodDescriptor.<String, String>newBuilder()
        .setType(MethodDescriptor.MethodType.UNARY)
        .setFullMethodName("google.spanner.v1.Spanner/ExecuteSql")
        .setRequestMarshaller(new FakeMarshaller<>())
        .setResponseMarshaller(new FakeMarshaller<>())
        .build();
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
    final AtomicBoolean closed = new AtomicBoolean(false);
    final AtomicReference<Status> closedStatus = new AtomicReference<>();
    final AtomicReference<Metadata> closedTrailers = new AtomicReference<>();

    @Override
    public void onHeaders(Metadata headers) {}

    @Override
    public void onClose(Status status, Metadata trailers) {
      closed.set(true);
      closedStatus.set(status);
      closedTrailers.set(trailers);
    }
  }
}
