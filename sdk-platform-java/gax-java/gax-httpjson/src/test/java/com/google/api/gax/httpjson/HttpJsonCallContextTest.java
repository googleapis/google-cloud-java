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
package com.google.api.gax.httpjson;

import static com.google.api.gax.util.TimeConversionTestUtils.testDurationMethod;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeCallContext;
import com.google.api.gax.rpc.testing.FakeChannel;
import com.google.api.gax.rpc.testing.FakeTransportChannel;
import com.google.api.gax.tracing.ApiTracer;
import com.google.auth.Credentials;
import com.google.common.collect.ImmutableMap;
import com.google.common.truth.Truth;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class HttpJsonCallContextTest {

  @Test
  void testNullToSelfWrongType() {
    IllegalArgumentException actual =
        assertThrows(
            IllegalArgumentException.class,
            () -> HttpJsonCallContext.createDefault().nullToSelf(FakeCallContext.createDefault()));
    assertTrue(actual.getMessage().contains("context must be an instance of HttpJsonCallContext"));
  }

  @Test
  void testWithCredentials() {
    Credentials credentials = Mockito.mock(Credentials.class);
    HttpJsonCallContext emptyContext = HttpJsonCallContext.createDefault();
    assertNull(emptyContext.getCredentials());
    HttpJsonCallContext context = emptyContext.withCredentials(credentials);
    assertNotNull(context.getCredentials());
  }

  @Test
  void testWithTransportChannel() {
    ManagedHttpJsonChannel channel = Mockito.mock(ManagedHttpJsonChannel.class);

    HttpJsonCallContext context =
        HttpJsonCallContext.createDefault()
            .withTransportChannel(
                HttpJsonTransportChannel.newBuilder().setManagedChannel(channel).build());
    Truth.assertThat(context.getChannel()).isSameInstanceAs(channel);
  }

  @Test
  void testWithTransportChannelWrongType() {
    try {
      FakeChannel channel = new FakeChannel();
      HttpJsonCallContext.createDefault()
          .withTransportChannel(FakeTransportChannel.create(channel));
      Assertions.fail("HttpJsonCallContext should have thrown an exception");
    } catch (IllegalArgumentException expected) {
      Truth.assertThat(expected).hasMessageThat().contains("Expected HttpJsonTransportChannel");
    }
  }

  @Test
  void testMergeWrongType() {
    try {
      HttpJsonCallContext.createDefault().merge(FakeCallContext.createDefault());
      Assertions.fail("HttpJsonCallContext should have thrown an exception");
    } catch (IllegalArgumentException expected) {
      Truth.assertThat(expected)
          .hasMessageThat()
          .contains("context must be an instance of HttpJsonCallContext");
    }
  }

  @Test
  void testStreamIdleTimeout() {
    final long millis = 3;
    final HttpJsonCallContext defaultContext = HttpJsonCallContext.createDefault();
    testDurationMethod(
        millis,
        jt -> defaultContext.withStreamIdleTimeoutDuration(jt),
        tt -> defaultContext.withStreamIdleTimeout(tt),
        c -> c.getStreamIdleTimeoutDuration(),
        c -> c.getStreamIdleTimeout());
  }

  @Test
  public void testStreamWaitTimeout() {
    final long millis = 3;
    final HttpJsonCallContext defaultContext = HttpJsonCallContext.createDefault();
    testDurationMethod(
        millis,
        jt -> defaultContext.withStreamWaitTimeoutDuration(jt),
        tt -> defaultContext.withStreamWaitTimeout(tt),
        c -> c.getStreamWaitTimeoutDuration(),
        c -> c.getStreamWaitTimeout());
  }

  @Test
  public void testTimeout() {
    final long millis = 3;
    final HttpJsonCallContext defaultContext = HttpJsonCallContext.createDefault();
    testDurationMethod(
        millis,
        jt -> defaultContext.withTimeoutDuration(jt),
        tt -> defaultContext.withTimeout(tt),
        c -> c.getTimeoutDuration(),
        c -> c.getTimeout());
  }

  @Test
  public void testNullTimeout() {
    final HttpJsonCallContext defaultContext = HttpJsonCallContext.createDefault();
    testDurationMethod(
        null,
        jt -> defaultContext.withTimeoutDuration(jt),
        tt -> defaultContext.withTimeout(tt),
        c -> c.getTimeoutDuration(),
        c -> c.getTimeout());
  }

  @Test
  void testWithNegativeTimeout() {
    assertNull(
        HttpJsonCallContext.createDefault()
            .withTimeoutDuration(java.time.Duration.ofSeconds(-1L))
            .getTimeoutDuration());
  }

  @Test
  void testWithZeroTimeout() {
    assertNull(
        HttpJsonCallContext.createDefault()
            .withTimeoutDuration(java.time.Duration.ofSeconds(0L))
            .getTimeoutDuration());
  }

  @Test
  void testWithShorterTimeout() {
    HttpJsonCallContext ctxWithLongTimeout =
        HttpJsonCallContext.createDefault().withTimeoutDuration(java.time.Duration.ofSeconds(10));

    // Sanity check
    Truth.assertThat(ctxWithLongTimeout.getTimeoutDuration())
        .isEqualTo(java.time.Duration.ofSeconds(10));

    // Shorten the timeout and make sure it changed
    HttpJsonCallContext ctxWithShorterTimeout =
        ctxWithLongTimeout.withTimeoutDuration(java.time.Duration.ofSeconds(5));
    Truth.assertThat(ctxWithShorterTimeout.getTimeoutDuration())
        .isEqualTo(java.time.Duration.ofSeconds(5));
  }

  @Test
  void testWithLongerTimeout() {
    HttpJsonCallContext ctxWithShortTimeout =
        HttpJsonCallContext.createDefault().withTimeoutDuration(java.time.Duration.ofSeconds(5));

    // Sanity check
    Truth.assertThat(ctxWithShortTimeout.getTimeoutDuration())
        .isEqualTo(java.time.Duration.ofSeconds(5));

    // Try to extend the timeout and verify that it was ignored
    HttpJsonCallContext ctxWithUnchangedTimeout =
        ctxWithShortTimeout.withTimeoutDuration(java.time.Duration.ofSeconds(10));
    Truth.assertThat(ctxWithUnchangedTimeout.getTimeoutDuration())
        .isEqualTo(java.time.Duration.ofSeconds(5));
  }

  @Test
  void testMergeWithNullTimeout() {
    java.time.Duration timeout = java.time.Duration.ofSeconds(10);
    HttpJsonCallContext baseContext =
        HttpJsonCallContext.createDefault().withTimeoutDuration(timeout);

    HttpJsonCallContext defaultOverlay = HttpJsonCallContext.createDefault();
    Truth.assertThat(baseContext.merge(defaultOverlay).getTimeoutDuration()).isEqualTo(timeout);

    java.time.Duration callContextTimeout = null;
    HttpJsonCallContext explicitNullOverlay =
        HttpJsonCallContext.createDefault().withTimeoutDuration(callContextTimeout);
    Truth.assertThat(baseContext.merge(explicitNullOverlay).getTimeoutDuration())
        .isEqualTo(timeout);
  }

  @Test
  void testMergeWithTimeout() {
    java.time.Duration timeout = java.time.Duration.ofSeconds(19);
    HttpJsonCallContext ctx1 = HttpJsonCallContext.createDefault();
    HttpJsonCallContext ctx2 = HttpJsonCallContext.createDefault().withTimeoutDuration(timeout);

    Truth.assertThat(ctx1.merge(ctx2).getTimeoutDuration()).isEqualTo(timeout);
  }

  @Test
  void testMergeWithTracer() {
    ApiTracer explicitTracer = Mockito.mock(ApiTracer.class);
    HttpJsonCallContext ctxWithExplicitTracer =
        HttpJsonCallContext.createDefault().withTracer(explicitTracer);

    HttpJsonCallContext ctxWithDefaultTracer = HttpJsonCallContext.createDefault();
    ApiTracer defaultTracer = ctxWithDefaultTracer.getTracer();

    // Explicit tracer overrides the default tracer.
    Truth.assertThat(ctxWithDefaultTracer.merge(ctxWithExplicitTracer).getTracer())
        .isSameInstanceAs(explicitTracer);

    // Default tracer does not override an explicit tracer.
    Truth.assertThat(ctxWithExplicitTracer.merge(ctxWithDefaultTracer).getTracer())
        .isSameInstanceAs(explicitTracer);

    // Default tracer does not override another default tracer.
    Truth.assertThat(ctxWithDefaultTracer.merge(HttpJsonCallContext.createDefault()).getTracer())
        .isSameInstanceAs(defaultTracer);
  }

  @Test
  void testWithRetrySettings() {
    RetrySettings retrySettings = Mockito.mock(RetrySettings.class);
    HttpJsonCallContext emptyContext = HttpJsonCallContext.createDefault();
    assertNull(emptyContext.getRetrySettings());
    HttpJsonCallContext context = emptyContext.withRetrySettings(retrySettings);
    assertNotNull(context.getRetrySettings());
  }

  @Test
  void testWithRetryableCodes() {
    Set<StatusCode.Code> codes = Collections.singleton(StatusCode.Code.UNAVAILABLE);
    HttpJsonCallContext emptyContext = HttpJsonCallContext.createDefault();
    assertNull(emptyContext.getRetryableCodes());
    HttpJsonCallContext context = emptyContext.withRetryableCodes(codes);
    assertNotNull(context.getRetryableCodes());
  }

  @Test
  void testWithExtraHeaders() {
    Map<String, List<String>> headers = ImmutableMap.of("k", Arrays.asList("v"));
    ApiCallContext emptyContext = HttpJsonCallContext.createDefault();
    assertTrue(emptyContext.getExtraHeaders().isEmpty());
    ApiCallContext context = emptyContext.withExtraHeaders(headers);
    assertEquals(headers, context.getExtraHeaders());
  }

  @Test
  void testWithOptions() {
    ApiCallContext emptyCallContext = HttpJsonCallContext.createDefault();
    ApiCallContext.Key<String> contextKey1 = ApiCallContext.Key.create("testKey1");
    ApiCallContext.Key<String> contextKey2 = ApiCallContext.Key.create("testKey2");
    String testContext1 = "test1";
    String testContext2 = "test2";
    String testContextOverwrite = "test1Overwrite";
    ApiCallContext context =
        emptyCallContext
            .withOption(contextKey1, testContext1)
            .withOption(contextKey2, testContext2);
    assertEquals(testContext1, context.getOption(contextKey1));
    assertEquals(testContext2, context.getOption(contextKey2));
    ApiCallContext newContext = context.withOption(contextKey1, testContextOverwrite);
    assertEquals(testContextOverwrite, newContext.getOption(contextKey1));
  }

  @Test
  void testMergeOptions() {
    ApiCallContext emptyCallContext = HttpJsonCallContext.createDefault();
    ApiCallContext.Key<String> contextKey1 = ApiCallContext.Key.create("testKey1");
    ApiCallContext.Key<String> contextKey2 = ApiCallContext.Key.create("testKey2");
    ApiCallContext.Key<String> contextKey3 = ApiCallContext.Key.create("testKey3");
    String testContext1 = "test1";
    String testContext2 = "test2";
    String testContext3 = "test3";
    String testContextOverwrite = "test1Overwrite";
    ApiCallContext context1 =
        emptyCallContext
            .withOption(contextKey1, testContext1)
            .withOption(contextKey2, testContext2);
    ApiCallContext context2 =
        emptyCallContext
            .withOption(contextKey1, testContextOverwrite)
            .withOption(contextKey3, testContext3);
    ApiCallContext mergedContext = context1.merge(context2);
    assertEquals(testContextOverwrite, mergedContext.getOption(contextKey1));
    assertEquals(testContext2, mergedContext.getOption(contextKey2));
    assertEquals(testContext3, mergedContext.getOption(contextKey3));
  }
}
