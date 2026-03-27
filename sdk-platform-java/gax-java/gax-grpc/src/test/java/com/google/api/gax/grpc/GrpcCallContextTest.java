/*
 * Copyright 2017 Google LLC
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 *
 *     * Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above
 * copyright notice, this list of conditions and the following disclaimer
 * in the documentation and/or other materials provided with the
 * distribution.
 *     * Neither the name of Google LLC nor the names of its
 * contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 * OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package com.google.api.gax.grpc;

import static com.google.api.gax.util.TimeConversionTestUtils.testDurationMethod;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeCallContext;
import com.google.api.gax.rpc.testing.FakeChannel;
import com.google.api.gax.rpc.testing.FakeTransportChannel;
import com.google.api.gax.tracing.ApiTracer;
import com.google.auth.Credentials;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.common.collect.ImmutableMap;
import com.google.common.truth.Truth;
import io.grpc.CallCredentials;
import io.grpc.CallOptions;
import io.grpc.ManagedChannel;
import io.grpc.Metadata.Key;
import io.grpc.auth.MoreCallCredentials;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class GrpcCallContextTest {

  @Test
  void testNullToSelfWrongType() {
    try {
      GrpcCallContext.createDefault().nullToSelf(FakeCallContext.createDefault());
      Assertions.fail("GrpcCallContext should have thrown an exception");
    } catch (IllegalArgumentException expected) {
      Truth.assertThat(expected)
          .hasMessageThat()
          .contains("context must be an instance of GrpcCallContext");
    }
  }

  @Test
  void testWithCredentials() {
    Credentials credentials = Mockito.mock(Credentials.class);
    GrpcCallContext emptyContext = GrpcCallContext.createDefault();
    assertNull(emptyContext.getCallOptions().getCredentials());
    GrpcCallContext context = emptyContext.withCredentials(credentials);
    assertNotNull(context.getCallOptions().getCredentials());
  }

  @Test
  void testWithTransportChannel() {
    ManagedChannel channel = Mockito.mock(ManagedChannel.class);
    GrpcCallContext context =
        GrpcCallContext.createDefault().withTransportChannel(GrpcTransportChannel.create(channel));
    Truth.assertThat(context.getChannel()).isSameInstanceAs(channel);
  }

  @Test
  void testWithTransportChannelWrongType() {
    FakeChannel channel = new FakeChannel();
    try {
      GrpcCallContext.createDefault().withTransportChannel(FakeTransportChannel.create(channel));
      Assertions.fail("GrpcCallContext should have thrown an exception");
    } catch (IllegalArgumentException expected) {
      Truth.assertThat(expected).hasMessageThat().contains("Expected GrpcTransportChannel");
    }
  }

  @Test
  void testWithTransportChannelIsDirectPath() {
    ManagedChannel channel = Mockito.mock(ManagedChannel.class);
    Credentials credentials = Mockito.mock(GoogleCredentials.class);
    GrpcCallContext context = GrpcCallContext.createDefault().withCredentials(credentials);
    assertNotNull(context.getCallOptions().getCredentials());
    context =
        context.withTransportChannel(
            GrpcTransportChannel.newBuilder()
                .setDirectPath(true)
                .setManagedChannel(channel)
                .build());
    assertNull(context.getCallOptions().getCredentials());

    // Call credentials from the call options will be stripped.
    context.withCallOptions(
        CallOptions.DEFAULT.withCallCredentials(MoreCallCredentials.from(credentials)));
    assertNull(context.getCallOptions().getCredentials());
  }

  @Test
  void testMergeWrongType() {
    try {
      GrpcCallContext.createDefault().merge(FakeCallContext.createDefault());
      Assertions.fail("GrpcCallContext should have thrown an exception");
    } catch (IllegalArgumentException expected) {
      Truth.assertThat(expected)
          .hasMessageThat()
          .contains("context must be an instance of " + "GrpcCallContext");
    }
  }

  @Test
  void testWithRequestParamsDynamicHeaderOption() {
    String encodedRequestParams = "param1=value&param2.param3=value23";
    GrpcCallContext context =
        GrpcCallContext.createDefault().withRequestParamsDynamicHeaderOption(encodedRequestParams);

    Map<Key<String>, String> headers =
        CallOptionsUtil.getDynamicHeadersOption(context.getCallOptions());

    assertEquals(
        ImmutableMap.of(CallOptionsUtil.REQUEST_PARAMS_HEADER_KEY, encodedRequestParams), headers);
  }

  @Test
  public void testWithTimeout() {
    final long millis = 15;
    GrpcCallContext context = GrpcCallContext.createDefault();
    testDurationMethod(
        millis,
        jt -> context.withTimeoutDuration(jt),
        tt -> context.withTimeout(tt),
        c -> c.getTimeoutDuration(),
        c -> c.getTimeout());
  }

  @Test
  void testWithNegativeTimeout() {
    assertNull(
        GrpcCallContext.createDefault()
            .withTimeoutDuration(java.time.Duration.ofSeconds(-1L))
            .getTimeoutDuration());
  }

  @Test
  void testWithZeroTimeout() {
    assertNull(
        GrpcCallContext.createDefault()
            .withTimeoutDuration(java.time.Duration.ofSeconds(0L))
            .getTimeoutDuration());
  }

  @Test
  void testWithShorterTimeout() {
    GrpcCallContext ctxWithLongTimeout =
        GrpcCallContext.createDefault().withTimeoutDuration(java.time.Duration.ofSeconds(10));

    // Sanity check
    Truth.assertThat(ctxWithLongTimeout.getTimeoutDuration())
        .isEqualTo(java.time.Duration.ofSeconds(10));

    // Shorten the timeout and make sure it changed
    GrpcCallContext ctxWithShorterTimeout =
        ctxWithLongTimeout.withTimeoutDuration(java.time.Duration.ofSeconds(5));
    Truth.assertThat(ctxWithShorterTimeout.getTimeoutDuration())
        .isEqualTo(java.time.Duration.ofSeconds(5));
  }

  @Test
  void testWithLongerTimeout() {
    GrpcCallContext ctxWithShortTimeout =
        GrpcCallContext.createDefault().withTimeoutDuration(java.time.Duration.ofSeconds(5));

    // Sanity check
    Truth.assertThat(ctxWithShortTimeout.getTimeoutDuration())
        .isEqualTo(java.time.Duration.ofSeconds(5));

    // Try to extend the timeout and verify that it was ignored
    GrpcCallContext ctxWithUnchangedTimeout =
        ctxWithShortTimeout.withTimeoutDuration(java.time.Duration.ofSeconds(10));
    Truth.assertThat(ctxWithUnchangedTimeout.getTimeoutDuration())
        .isEqualTo(java.time.Duration.ofSeconds(5));
  }

  @Test
  void testMergeWithNullTimeout() {
    java.time.Duration timeout = java.time.Duration.ofSeconds(10);
    GrpcCallContext baseContext = GrpcCallContext.createDefault().withTimeoutDuration(timeout);

    GrpcCallContext defaultOverlay = GrpcCallContext.createDefault();
    Truth.assertThat(baseContext.merge(defaultOverlay).getTimeoutDuration()).isEqualTo(timeout);

    java.time.Duration callContextTimeout = null;
    GrpcCallContext explicitNullOverlay =
        GrpcCallContext.createDefault().withTimeoutDuration(callContextTimeout);
    Truth.assertThat(baseContext.merge(explicitNullOverlay).getTimeoutDuration())
        .isEqualTo(timeout);
  }

  @Test
  void testMergeWithTimeout() {
    java.time.Duration timeout = java.time.Duration.ofSeconds(19);
    GrpcCallContext ctx1 = GrpcCallContext.createDefault();
    GrpcCallContext ctx2 = GrpcCallContext.createDefault().withTimeoutDuration(timeout);

    Truth.assertThat(ctx1.merge(ctx2).getTimeoutDuration()).isEqualTo(timeout);
  }

  @Test
  void testWithStreamingWaitTimeout() {
    final long millis = 15;
    GrpcCallContext context = GrpcCallContext.createDefault();
    testDurationMethod(
        millis,
        jt -> context.withStreamWaitTimeoutDuration(jt),
        tt -> context.withStreamWaitTimeout(tt),
        c -> c.getStreamWaitTimeoutDuration(),
        c -> c.getStreamWaitTimeout());
  }

  @Test
  void testMergeWithNullStreamingWaitTimeout() {
    java.time.Duration timeout = java.time.Duration.ofSeconds(10);
    GrpcCallContext baseContext =
        GrpcCallContext.createDefault().withStreamWaitTimeoutDuration(timeout);

    GrpcCallContext defaultOverlay = GrpcCallContext.createDefault();
    Truth.assertThat(baseContext.merge(defaultOverlay).getStreamWaitTimeoutDuration())
        .isEqualTo(timeout);

    java.time.Duration streamWaitTimeout = null;
    GrpcCallContext explicitNullOverlay =
        GrpcCallContext.createDefault().withStreamWaitTimeoutDuration(streamWaitTimeout);
    Truth.assertThat(baseContext.merge(explicitNullOverlay).getStreamWaitTimeoutDuration())
        .isEqualTo(timeout);
  }

  @Test
  void testWithZeroStreamingWaitTimeout() {
    java.time.Duration timeout = java.time.Duration.ZERO;
    Truth.assertThat(
            GrpcCallContext.createDefault()
                .withStreamWaitTimeoutDuration(timeout)
                .getStreamWaitTimeoutDuration())
        .isEqualTo(timeout);
  }

  @Test
  void testMergeWithStreamingWaitTimeout() {
    java.time.Duration timeout = java.time.Duration.ofSeconds(19);
    GrpcCallContext ctx1 = GrpcCallContext.createDefault();
    GrpcCallContext ctx2 = GrpcCallContext.createDefault().withStreamWaitTimeoutDuration(timeout);

    Truth.assertThat(ctx1.merge(ctx2).getStreamWaitTimeoutDuration()).isEqualTo(timeout);
  }

  @Test
  void testWithStreamingIdleTimeout() {
    final long millis = 15;
    GrpcCallContext context = GrpcCallContext.createDefault();
    testDurationMethod(
        millis,
        jt -> context.withStreamIdleTimeoutDuration(jt),
        tt -> context.withStreamIdleTimeout(tt),
        c -> c.getStreamIdleTimeoutDuration(),
        c -> c.getStreamIdleTimeout());
  }

  @Test
  void testMergeWithNullStreamingIdleTimeout() {
    java.time.Duration timeout = java.time.Duration.ofSeconds(10);
    GrpcCallContext baseContext =
        GrpcCallContext.createDefault().withStreamIdleTimeoutDuration(timeout);

    GrpcCallContext defaultOverlay = GrpcCallContext.createDefault();
    Truth.assertThat(baseContext.merge(defaultOverlay).getStreamIdleTimeoutDuration())
        .isEqualTo(timeout);

    java.time.Duration idleTimeout = null;
    GrpcCallContext explicitNullOverlay =
        GrpcCallContext.createDefault().withStreamIdleTimeoutDuration(idleTimeout);
    Truth.assertThat(baseContext.merge(explicitNullOverlay).getStreamIdleTimeoutDuration())
        .isEqualTo(timeout);
  }

  @Test
  void testWithZeroStreamingIdleTimeout() {
    java.time.Duration timeout = java.time.Duration.ZERO;
    Truth.assertThat(
            GrpcCallContext.createDefault()
                .withStreamIdleTimeoutDuration(timeout)
                .getStreamIdleTimeoutDuration())
        .isEqualTo(timeout);
  }

  @Test
  void testMergeWithStreamingIdleTimeout() {
    java.time.Duration timeout = java.time.Duration.ofSeconds(19);
    GrpcCallContext ctx1 = GrpcCallContext.createDefault();
    GrpcCallContext ctx2 = GrpcCallContext.createDefault().withStreamIdleTimeoutDuration(timeout);

    Truth.assertThat(ctx1.merge(ctx2).getStreamIdleTimeoutDuration()).isEqualTo(timeout);
  }

  @Test
  void testMergeWithCustomCallOptions() {
    CallOptions.Key<String> key = CallOptions.Key.createWithDefault("somekey", "somedefault");
    GrpcCallContext ctx1 = GrpcCallContext.createDefault();
    GrpcCallContext ctx2 =
        GrpcCallContext.createDefault()
            .withCallOptions(CallOptions.DEFAULT.withOption(key, "somevalue"));

    GrpcCallContext merged = (GrpcCallContext) ctx1.merge(ctx2);
    Truth.assertThat(merged.getCallOptions().getOption(key))
        .isNotEqualTo(ctx1.getCallOptions().getOption(key));
    Truth.assertThat(merged.getCallOptions().getOption(key))
        .isEqualTo(ctx2.getCallOptions().getOption(key));
  }

  @Test
  void testMergeWithIsDirectPath() {
    ManagedChannel channel = Mockito.mock(ManagedChannel.class);
    CallCredentials callCredentials = Mockito.mock(CallCredentials.class);
    GrpcCallContext ctx1 =
        GrpcCallContext.createDefault()
            .withCallOptions(CallOptions.DEFAULT.withCallCredentials(callCredentials));
    GrpcCallContext ctx2 =
        GrpcCallContext.createDefault()
            .withTransportChannel(
                GrpcTransportChannel.newBuilder()
                    .setDirectPath(true)
                    .setManagedChannel(channel)
                    .build());

    GrpcCallContext merged = (GrpcCallContext) ctx1.merge(ctx2);
    assertNull(merged.getCallOptions().getCredentials());
  }

  @Test
  void testWithExtraHeaders() {
    Map<String, List<String>> extraHeaders =
        createTestExtraHeaders("key1", "value1", "key1", "value2");
    GrpcCallContext ctx = GrpcCallContext.createDefault().withExtraHeaders(extraHeaders);
    Map<String, List<String>> moreExtraHeaders =
        createTestExtraHeaders("key1", "value2", "key2", "value2");
    ctx = ctx.withExtraHeaders(moreExtraHeaders);
    Map<String, List<String>> gotExtraHeaders = ctx.getExtraHeaders();
    Map<String, List<String>> expectedExtraHeaders =
        createTestExtraHeaders(
            "key1", "value1", "key1", "value2", "key1", "value2", "key2", "value2");
    Truth.assertThat(gotExtraHeaders).containsExactlyEntriesIn(expectedExtraHeaders);
  }

  @Test
  void testMergeWithExtraHeaders() {
    Map<String, List<String>> extraHeaders1 =
        createTestExtraHeaders("key1", "value1", "key1", "value2");
    GrpcCallContext ctx1 = GrpcCallContext.createDefault().withExtraHeaders(extraHeaders1);
    Map<String, List<String>> extraHeaders2 =
        createTestExtraHeaders("key1", "value2", "key2", "value2");
    GrpcCallContext ctx2 = GrpcCallContext.createDefault().withExtraHeaders(extraHeaders2);
    ApiCallContext mergedApiCallContext = ctx1.merge(ctx2);
    Truth.assertThat(mergedApiCallContext).isInstanceOf(GrpcCallContext.class);
    GrpcCallContext mergedGrpcCallContext = (GrpcCallContext) mergedApiCallContext;
    Map<String, List<String>> gotExtraHeaders = mergedGrpcCallContext.getExtraHeaders();
    Map<String, List<String>> expectedExtraHeaders =
        createTestExtraHeaders(
            "key1", "value1", "key1", "value2", "key1", "value2", "key2", "value2");
    Truth.assertThat(gotExtraHeaders).containsExactlyEntriesIn(expectedExtraHeaders);
  }

  @Test
  void testMergeWithTracer() {
    ApiTracer explicitTracer = Mockito.mock(ApiTracer.class);
    GrpcCallContext ctxWithExplicitTracer =
        GrpcCallContext.createDefault().withTracer(explicitTracer);

    GrpcCallContext ctxWithDefaultTracer = GrpcCallContext.createDefault();
    ApiTracer defaultTracer = ctxWithDefaultTracer.getTracer();

    // Explicit tracer overrides the default tracer.
    Truth.assertThat(ctxWithDefaultTracer.merge(ctxWithExplicitTracer).getTracer())
        .isSameInstanceAs(explicitTracer);

    // Default tracer does not override an explicit tracer.
    Truth.assertThat(ctxWithExplicitTracer.merge(ctxWithDefaultTracer).getTracer())
        .isSameInstanceAs(explicitTracer);

    // Default tracer does not override another default tracer.
    Truth.assertThat(ctxWithDefaultTracer.merge(GrpcCallContext.createDefault()).getTracer())
        .isSameInstanceAs(defaultTracer);
  }

  @Test
  void testWithRetrySettings() {
    RetrySettings retrySettings = Mockito.mock(RetrySettings.class);
    GrpcCallContext emptyContext = GrpcCallContext.createDefault();
    assertNull(emptyContext.getRetrySettings());
    GrpcCallContext context = emptyContext.withRetrySettings(retrySettings);
    assertNotNull(context.getRetrySettings());
  }

  @Test
  void testWithRetryableCodes() {
    Set<StatusCode.Code> codes = Collections.singleton(StatusCode.Code.UNAVAILABLE);
    GrpcCallContext emptyContext = GrpcCallContext.createDefault();
    assertNull(emptyContext.getRetryableCodes());
    GrpcCallContext context = emptyContext.withRetryableCodes(codes);
    assertNotNull(context.getRetryableCodes());
  }

  @Test
  void testWithOptions() {
    GrpcCallContext emptyCallContext = GrpcCallContext.createDefault();
    ApiCallContext.Key<String> contextKey1 = ApiCallContext.Key.create("testKey1");
    ApiCallContext.Key<String> contextKey2 = ApiCallContext.Key.create("testKey2");
    String testContext1 = "test1";
    String testContext2 = "test2";
    String testContextOverwrite = "test1Overwrite";
    GrpcCallContext context =
        emptyCallContext
            .withOption(contextKey1, testContext1)
            .withOption(contextKey2, testContext2);
    assertEquals(testContext1, context.getOption(contextKey1));
    assertEquals(testContext2, context.getOption(contextKey2));
    GrpcCallContext newContext = context.withOption(contextKey1, testContextOverwrite);
    assertEquals(testContextOverwrite, newContext.getOption(contextKey1));
  }

  @Test
  void testMergeOptions() throws IOException {
    GrpcCallContext emptyCallContext = GrpcCallContext.createDefault();
    ApiCallContext.Key<String> contextKey1 = ApiCallContext.Key.create("testKey1");
    ApiCallContext.Key<String> contextKey2 = ApiCallContext.Key.create("testKey2");
    ApiCallContext.Key<String> contextKey3 = ApiCallContext.Key.create("testKey3");
    String testContext1 = "test1";
    String testContext2 = "test2";
    String testContext3 = "test3";
    String testContextOverwrite = "test1Overwrite";
    GrpcCallContext context1 =
        emptyCallContext
            .withOption(contextKey1, testContext1)
            .withOption(contextKey2, testContext2);
    GrpcCallContext context2 =
        emptyCallContext
            .withOption(contextKey1, testContextOverwrite)
            .withOption(contextKey3, testContext3);
    ApiCallContext mergedContext = context1.merge(context2);
    assertEquals(testContextOverwrite, mergedContext.getOption(contextKey1));
    assertEquals(testContext2, mergedContext.getOption(contextKey2));
    assertEquals(testContext3, mergedContext.getOption(contextKey3));
  }

  private static Map<String, List<String>> createTestExtraHeaders(String... keyValues) {
    Map<String, List<String>> extraHeaders = new HashMap<>();
    for (int i = 0; i < keyValues.length; i += 2) {
      String key = keyValues[i];
      String value = keyValues[i + 1];
      if (!extraHeaders.containsKey(key)) {
        extraHeaders.put(key, new ArrayList<String>());
      }
      extraHeaders.get(key).add(value);
    }
    return extraHeaders;
  }
}
