/*
 * Copyright 2021 Google LLC
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
package com.google.api.gax.rpc;

import static com.google.common.truth.Truth.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.google.api.core.ApiClock;
import com.google.api.gax.retrying.BasicResultRetryAlgorithm;
import com.google.api.gax.retrying.ExponentialRetryAlgorithm;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.retrying.RetryingContext;
import com.google.api.gax.retrying.ServerStreamingAttemptException;
import com.google.api.gax.retrying.StreamingRetryAlgorithm;
import com.google.api.gax.retrying.TimedAttemptSettings;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class StreamingRetryAlgorithmTest {
  private static final RetrySettings DEFAULT_RETRY_SETTINGS =
      RetrySettings.newBuilder()
          .setInitialRetryDelayDuration(java.time.Duration.ofMillis(10L))
          .setInitialRpcTimeoutDuration(java.time.Duration.ofMillis(100L))
          .setMaxAttempts(10)
          .setMaxRetryDelayDuration(java.time.Duration.ofSeconds(10L))
          .setMaxRpcTimeoutDuration(java.time.Duration.ofSeconds(30L))
          .setRetryDelayMultiplier(1.4)
          .setRpcTimeoutMultiplier(1.5)
          .setTotalTimeoutDuration(java.time.Duration.ofMinutes(10L))
          .build();

  private static final RetrySettings CONTEXT_RETRY_SETTINGS =
      RetrySettings.newBuilder()
          .setInitialRetryDelayDuration(java.time.Duration.ofMillis(20L))
          .setInitialRpcTimeoutDuration(java.time.Duration.ofMillis(200L))
          .setMaxAttempts(10)
          .setMaxRetryDelayDuration(java.time.Duration.ofSeconds(20L))
          .setMaxRpcTimeoutDuration(java.time.Duration.ofSeconds(60L))
          .setRetryDelayMultiplier(2.4)
          .setRpcTimeoutMultiplier(2.5)
          .setTotalTimeoutDuration(java.time.Duration.ofMinutes(20L))
          .build();

  @Test
  void testFirstAttemptUsesDefaultSettings() {
    RetryingContext context = mock(RetryingContext.class);
    BasicResultRetryAlgorithm<String> resultAlgorithm = new BasicResultRetryAlgorithm<>();
    ExponentialRetryAlgorithm timedAlgorithm =
        new ExponentialRetryAlgorithm(DEFAULT_RETRY_SETTINGS, mock(ApiClock.class));

    StreamingRetryAlgorithm<String> algorithm =
        new StreamingRetryAlgorithm<>(resultAlgorithm, timedAlgorithm);

    TimedAttemptSettings attempt = algorithm.createFirstAttempt(context);
    assertThat(attempt.getGlobalSettings()).isSameInstanceAs(DEFAULT_RETRY_SETTINGS);
    assertThat(attempt.getRpcTimeoutDuration())
        .isEqualTo(DEFAULT_RETRY_SETTINGS.getInitialRpcTimeoutDuration());
  }

  @Test
  void testFirstAttemptUsesContextSettings() {
    RetryingContext context = mock(RetryingContext.class);
    when(context.getRetrySettings()).thenReturn(CONTEXT_RETRY_SETTINGS);
    BasicResultRetryAlgorithm<String> resultAlgorithm = new BasicResultRetryAlgorithm<>();
    ExponentialRetryAlgorithm timedAlgorithm =
        new ExponentialRetryAlgorithm(DEFAULT_RETRY_SETTINGS, mock(ApiClock.class));

    StreamingRetryAlgorithm<String> algorithm =
        new StreamingRetryAlgorithm<>(resultAlgorithm, timedAlgorithm);

    TimedAttemptSettings attempt = algorithm.createFirstAttempt(context);
    assertThat(attempt.getGlobalSettings()).isSameInstanceAs(CONTEXT_RETRY_SETTINGS);
    assertThat(attempt.getRpcTimeoutDuration())
        .isEqualTo(CONTEXT_RETRY_SETTINGS.getInitialRpcTimeoutDuration());
  }

  @Test
  void testNextAttemptReturnsNullWhenShouldNotRetry() {
    RetryingContext context = mock(RetryingContext.class);
    @SuppressWarnings("unchecked")
    BasicResultRetryAlgorithm<String> resultAlgorithm = mock(BasicResultRetryAlgorithm.class);
    UnavailableException exception = mock(UnavailableException.class);
    when(resultAlgorithm.shouldRetry(context, exception, null)).thenReturn(false);
    ExponentialRetryAlgorithm timedAlgorithm =
        new ExponentialRetryAlgorithm(DEFAULT_RETRY_SETTINGS, mock(ApiClock.class));

    StreamingRetryAlgorithm<String> algorithm =
        new StreamingRetryAlgorithm<>(resultAlgorithm, timedAlgorithm);

    TimedAttemptSettings attempt =
        algorithm.createNextAttempt(context, exception, null, mock(TimedAttemptSettings.class));
    assertThat(attempt).isNull();

    TimedAttemptSettings attemptWithoutContext =
        algorithm.createNextAttempt(exception, null, mock(TimedAttemptSettings.class));
    assertThat(attemptWithoutContext).isNull();
  }

  @Test
  void testNextAttemptReturnsResultAlgorithmSettingsWhenShouldRetry() {
    RetryingContext context = mock(RetryingContext.class);
    @SuppressWarnings("unchecked")
    BasicResultRetryAlgorithm<String> resultAlgorithm = mock(BasicResultRetryAlgorithm.class);
    UnavailableException exception = mock(UnavailableException.class);
    when(resultAlgorithm.shouldRetry(context, exception, null)).thenReturn(true);
    TimedAttemptSettings next = mock(TimedAttemptSettings.class);
    when(resultAlgorithm.createNextAttempt(
            Mockito.eq(context),
            Mockito.eq(exception),
            Mockito.<String>isNull(),
            any(TimedAttemptSettings.class)))
        .thenReturn(next);
    ExponentialRetryAlgorithm timedAlgorithm =
        new ExponentialRetryAlgorithm(DEFAULT_RETRY_SETTINGS, mock(ApiClock.class));

    StreamingRetryAlgorithm<String> algorithm =
        new StreamingRetryAlgorithm<>(resultAlgorithm, timedAlgorithm);

    TimedAttemptSettings first = algorithm.createFirstAttempt(context);
    TimedAttemptSettings attempt = algorithm.createNextAttempt(context, exception, null, first);
    assertThat(attempt).isSameInstanceAs(next);
  }

  @Test
  void testNextAttemptResetsTimedSettings() {
    RetryingContext context = mock(RetryingContext.class);
    BasicResultRetryAlgorithm<String> resultAlgorithm = new BasicResultRetryAlgorithm<>();

    ServerStreamingAttemptException exception = mock(ServerStreamingAttemptException.class);
    when(exception.canResume()).thenReturn(true);
    when(exception.hasSeenResponses()).thenReturn(true);
    UnavailableException cause = mock(UnavailableException.class);
    when(exception.getCause()).thenReturn(cause);

    ExponentialRetryAlgorithm timedAlgorithm =
        new ExponentialRetryAlgorithm(DEFAULT_RETRY_SETTINGS, mock(ApiClock.class));
    StreamingRetryAlgorithm<String> algorithm =
        new StreamingRetryAlgorithm<>(resultAlgorithm, timedAlgorithm);

    TimedAttemptSettings first = algorithm.createFirstAttempt(context);
    TimedAttemptSettings second =
        algorithm.createNextAttempt(context, mock(Exception.class), null, first);
    TimedAttemptSettings third = algorithm.createNextAttempt(context, exception, null, second);
    assertThat(third.getFirstAttemptStartTimeNanos())
        .isEqualTo(first.getFirstAttemptStartTimeNanos());
    // The timeout values are reset to the second call.
    assertThat(third.getRpcTimeoutDuration()).isEqualTo(second.getRpcTimeoutDuration());
  }

  @Test
  void testShouldNotRetryIfAttemptIsNonResumable() {
    RetryingContext context = mock(RetryingContext.class);

    ServerStreamingAttemptException exception = mock(ServerStreamingAttemptException.class);
    when(exception.canResume()).thenReturn(false);
    UnavailableException cause = mock(UnavailableException.class);
    when(exception.getCause()).thenReturn(cause);

    BasicResultRetryAlgorithm<String> resultAlgorithm = new BasicResultRetryAlgorithm<>();

    ExponentialRetryAlgorithm timedAlgorithm =
        new ExponentialRetryAlgorithm(DEFAULT_RETRY_SETTINGS, mock(ApiClock.class));
    StreamingRetryAlgorithm<String> algorithm =
        new StreamingRetryAlgorithm<>(resultAlgorithm, timedAlgorithm);

    // This should return false because the attempt exception indicates that it is non-resumable.
    boolean shouldRetry =
        algorithm.shouldRetry(context, exception, null, mock(TimedAttemptSettings.class));
    assertThat(shouldRetry).isFalse();

    boolean shouldRetryWithoutContext =
        algorithm.shouldRetry(exception, null, mock(TimedAttemptSettings.class));
    assertThat(shouldRetryWithoutContext).isFalse();
  }

  @Test
  void testShouldRetryIfAllSayYes() {
    RetryingContext context = mock(RetryingContext.class);

    ServerStreamingAttemptException exception = mock(ServerStreamingAttemptException.class);
    when(exception.canResume()).thenReturn(true);
    UnavailableException cause = mock(UnavailableException.class);
    when(exception.getCause()).thenReturn(cause);

    BasicResultRetryAlgorithm<String> resultAlgorithm = new BasicResultRetryAlgorithm<>();

    ExponentialRetryAlgorithm timedAlgorithm = mock(ExponentialRetryAlgorithm.class);
    when(timedAlgorithm.shouldRetry(Mockito.eq(context), any(TimedAttemptSettings.class)))
        .thenReturn(true);
    StreamingRetryAlgorithm<String> algorithm =
        new StreamingRetryAlgorithm<>(resultAlgorithm, timedAlgorithm);

    boolean shouldRetry =
        algorithm.shouldRetry(context, exception, null, mock(TimedAttemptSettings.class));
    assertThat(shouldRetry).isTrue();
  }
}
