/*
 * Copyright 2025 Google LLC
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

import static com.google.cloud.spanner.XGoogSpannerRequestId.REQUEST_ID_CALL_OPTIONS_KEY;
import static com.google.cloud.spanner.XGoogSpannerRequestId.REQUEST_ID_HEADER_KEY;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import com.google.cloud.grpc.GcpManagedChannel;
import com.google.cloud.spanner.XGoogSpannerRequestId;
import io.grpc.CallOptions;
import io.grpc.Channel;
import io.grpc.ClientCall;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.MethodDescriptor.Marshaller;
import java.io.InputStream;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/** Unit tests for {@link RequestIdInterceptor}. */
@RunWith(JUnit4.class)
public class RequestIdInterceptorTest {

  // Pattern to parse request ID: version.randProcessId.clientId.channelId.requestId.attempt
  private static final Pattern REQUEST_ID_PATTERN =
      Pattern.compile("^(\\d)\\.([0-9a-z]{16})\\.(\\d+)\\.(\\d+)\\.(\\d+)\\.(\\d+)$");

  @Test
  public void testInterceptorSetsRequestIdHeader() {
    RequestIdInterceptor interceptor = new RequestIdInterceptor();
    XGoogSpannerRequestId requestId = XGoogSpannerRequestId.of(1, 2, 3, 0);
    CallOptions callOptions =
        CallOptions.DEFAULT.withOption(REQUEST_ID_CALL_OPTIONS_KEY, requestId);

    AtomicReference<Metadata> capturedHeaders = new AtomicReference<>();

    Channel fakeChannel =
        new FakeChannel() {
          @Override
          public <ReqT, RespT> ClientCall<ReqT, RespT> newCall(
              MethodDescriptor<ReqT, RespT> methodDescriptor, CallOptions callOptions) {
            return new FakeClientCall<ReqT, RespT>() {
              @Override
              public void start(Listener<RespT> responseListener, Metadata headers) {
                capturedHeaders.set(headers);
              }
            };
          }
        };

    MethodDescriptor<String, String> methodDescriptor = createMethodDescriptor();
    ClientCall<String, String> call =
        interceptor.interceptCall(methodDescriptor, callOptions, fakeChannel);
    call.start(new NoOpListener<>(), new Metadata());

    assertNotNull(capturedHeaders.get());
    String headerValue = capturedHeaders.get().get(REQUEST_ID_HEADER_KEY);
    assertNotNull(headerValue);

    // Verify the header matches the expected pattern with attempt incremented to 1.
    Matcher matcher = REQUEST_ID_PATTERN.matcher(headerValue);
    assertTrue("Header value should match request ID pattern", matcher.matches());
    // Attempt should be 1 (incremented from 0).
    assertTrue("Attempt should be 1", headerValue.endsWith(".1"));
  }

  @Test
  public void testInterceptorUpdatesChannelIdFromGrpcGcp() {
    RequestIdInterceptor interceptor = new RequestIdInterceptor();

    // Start with channel ID 0 (placeholder when DCP is enabled).
    XGoogSpannerRequestId requestId = XGoogSpannerRequestId.of(1, 0, 3, 0);

    // Simulate grpc-gcp setting the actual channel ID (0-based) in CallOptions.
    int gcpChannelId = 5; // grpc-gcp channel IDs are 0-based.
    CallOptions callOptions =
        CallOptions.DEFAULT
            .withOption(REQUEST_ID_CALL_OPTIONS_KEY, requestId)
            .withOption(GcpManagedChannel.CHANNEL_ID_KEY, gcpChannelId);

    AtomicReference<Metadata> capturedHeaders = new AtomicReference<>();

    Channel fakeChannel =
        new FakeChannel() {
          @Override
          public <ReqT, RespT> ClientCall<ReqT, RespT> newCall(
              MethodDescriptor<ReqT, RespT> methodDescriptor, CallOptions callOptions) {
            return new FakeClientCall<ReqT, RespT>() {
              @Override
              public void start(Listener<RespT> responseListener, Metadata headers) {
                capturedHeaders.set(headers);
              }
            };
          }
        };

    MethodDescriptor<String, String> methodDescriptor = createMethodDescriptor();
    ClientCall<String, String> call =
        interceptor.interceptCall(methodDescriptor, callOptions, fakeChannel);
    call.start(new NoOpListener<>(), new Metadata());

    assertNotNull(capturedHeaders.get());
    String headerValue = capturedHeaders.get().get(REQUEST_ID_HEADER_KEY);
    assertNotNull(headerValue);

    // Parse the header and verify the channel ID was updated.
    // Expected channel ID in header is gcpChannelId + 1 = 6.
    Matcher matcher = REQUEST_ID_PATTERN.matcher(headerValue);
    assertTrue("Header value should match request ID pattern", matcher.matches());
    String channelIdStr = matcher.group(4);
    // Channel ID should be gcpChannelId + 1 = 6.
    assertTrue(
        "Channel ID should be " + (gcpChannelId + 1),
        channelIdStr.equals(String.valueOf(gcpChannelId + 1)));
  }

  @Test
  public void testInterceptorDoesNotUpdateChannelIdWhenNotProvided() {
    RequestIdInterceptor interceptor = new RequestIdInterceptor();

    // Start with a specific channel ID.
    long originalChannelId = 3;
    XGoogSpannerRequestId requestId = XGoogSpannerRequestId.of(1, originalChannelId, 5, 0);

    // No CHANNEL_ID_KEY set in CallOptions (grpc-gcp not used or not available).
    CallOptions callOptions =
        CallOptions.DEFAULT.withOption(REQUEST_ID_CALL_OPTIONS_KEY, requestId);

    AtomicReference<Metadata> capturedHeaders = new AtomicReference<>();

    Channel fakeChannel =
        new FakeChannel() {
          @Override
          public <ReqT, RespT> ClientCall<ReqT, RespT> newCall(
              MethodDescriptor<ReqT, RespT> methodDescriptor, CallOptions callOptions) {
            return new FakeClientCall<ReqT, RespT>() {
              @Override
              public void start(Listener<RespT> responseListener, Metadata headers) {
                capturedHeaders.set(headers);
              }
            };
          }
        };

    MethodDescriptor<String, String> methodDescriptor = createMethodDescriptor();
    ClientCall<String, String> call =
        interceptor.interceptCall(methodDescriptor, callOptions, fakeChannel);
    call.start(new NoOpListener<>(), new Metadata());

    assertNotNull(capturedHeaders.get());
    String headerValue = capturedHeaders.get().get(REQUEST_ID_HEADER_KEY);
    assertNotNull(headerValue);

    // Parse the header and verify the channel ID remained unchanged.
    Matcher matcher = REQUEST_ID_PATTERN.matcher(headerValue);
    assertTrue("Header value should match request ID pattern", matcher.matches());
    String channelIdStr = matcher.group(4);
    // Channel ID should remain 3.
    assertTrue(
        "Channel ID should remain " + originalChannelId,
        channelIdStr.equals(String.valueOf(originalChannelId)));
  }

  @Test
  public void testInterceptorOverridesChannelIdWhenGrpcGcpProvides() {
    RequestIdInterceptor interceptor = new RequestIdInterceptor();

    // Start with a non-zero channel ID.
    long originalChannelId = 3;
    XGoogSpannerRequestId requestId = XGoogSpannerRequestId.of(1, originalChannelId, 5, 0);

    // Simulate grpc-gcp setting a different channel ID.
    int gcpChannelId = 7;
    CallOptions callOptions =
        CallOptions.DEFAULT
            .withOption(REQUEST_ID_CALL_OPTIONS_KEY, requestId)
            .withOption(GcpManagedChannel.CHANNEL_ID_KEY, gcpChannelId);

    AtomicReference<Metadata> capturedHeaders = new AtomicReference<>();

    Channel fakeChannel =
        new FakeChannel() {
          @Override
          public <ReqT, RespT> ClientCall<ReqT, RespT> newCall(
              MethodDescriptor<ReqT, RespT> methodDescriptor, CallOptions callOptions) {
            return new FakeClientCall<ReqT, RespT>() {
              @Override
              public void start(Listener<RespT> responseListener, Metadata headers) {
                capturedHeaders.set(headers);
              }
            };
          }
        };

    MethodDescriptor<String, String> methodDescriptor = createMethodDescriptor();
    ClientCall<String, String> call =
        interceptor.interceptCall(methodDescriptor, callOptions, fakeChannel);
    call.start(new NoOpListener<>(), new Metadata());

    assertNotNull(capturedHeaders.get());
    String headerValue = capturedHeaders.get().get(REQUEST_ID_HEADER_KEY);
    assertNotNull(headerValue);

    // Parse the header and verify the channel ID WAS updated to grpc-gcp's value.
    Matcher matcher = REQUEST_ID_PATTERN.matcher(headerValue);
    assertTrue("Header value should match request ID pattern", matcher.matches());
    String channelIdStr = matcher.group(4);
    // Channel ID should be gcpChannelId + 1 = 8 (grpc-gcp's channel ID overrides the original).
    assertTrue(
        "Channel ID should be " + (gcpChannelId + 1) + " but was " + channelIdStr,
        channelIdStr.equals(String.valueOf(gcpChannelId + 1)));
  }

  @Test
  public void testInterceptorWithNoRequestId() {
    RequestIdInterceptor interceptor = new RequestIdInterceptor();

    // No request ID in CallOptions.
    CallOptions callOptions = CallOptions.DEFAULT;

    AtomicReference<Metadata> capturedHeaders = new AtomicReference<>();

    Channel fakeChannel =
        new FakeChannel() {
          @Override
          public <ReqT, RespT> ClientCall<ReqT, RespT> newCall(
              MethodDescriptor<ReqT, RespT> methodDescriptor, CallOptions callOptions) {
            return new FakeClientCall<ReqT, RespT>() {
              @Override
              public void start(Listener<RespT> responseListener, Metadata headers) {
                capturedHeaders.set(headers);
              }
            };
          }
        };

    MethodDescriptor<String, String> methodDescriptor = createMethodDescriptor();
    ClientCall<String, String> call =
        interceptor.interceptCall(methodDescriptor, callOptions, fakeChannel);
    call.start(new NoOpListener<>(), new Metadata());

    assertNotNull(capturedHeaders.get());
    // No request ID header should be set.
    assertNull(capturedHeaders.get().get(REQUEST_ID_HEADER_KEY));
  }

  private static MethodDescriptor<String, String> createMethodDescriptor() {
    return MethodDescriptor.<String, String>newBuilder()
        .setType(MethodDescriptor.MethodType.UNARY)
        .setFullMethodName("test/method")
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

  private abstract static class FakeChannel extends Channel {
    @Override
    public String authority() {
      return "fake-authority";
    }
  }

  private abstract static class FakeClientCall<ReqT, RespT> extends ClientCall<ReqT, RespT> {
    @Override
    public void start(Listener<RespT> responseListener, Metadata headers) {}

    @Override
    public void request(int numMessages) {}

    @Override
    public void cancel(String message, Throwable cause) {}

    @Override
    public void halfClose() {}

    @Override
    public void sendMessage(ReqT message) {}
  }

  private static class NoOpListener<T> extends ClientCall.Listener<T> {
    @Override
    public void onMessage(T message) {}

    @Override
    public void onHeaders(Metadata headers) {}

    @Override
    public void onClose(io.grpc.Status status, Metadata trailers) {}

    @Override
    public void onReady() {}
  }
}
