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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.google.api.core.NanoClock;
import com.google.api.gax.retrying.ExponentialRetryAlgorithm;
import com.google.api.gax.retrying.RetryAlgorithm;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.retrying.TimedAttemptSettings;
import com.google.api.gax.rpc.StatusCode.Code;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.common.collect.Sets;
import java.time.Duration;
import java.util.Collections;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ApiResultRetryAlgorithmTest {

  @Test
  void testShouldRetryNoContext() {
    ApiException nonRetryable =
        new ApiException(null, new FakeStatusCode(Code.INTERNAL), /* retryable= */ false);
    ApiException retryable =
        new ApiException(null, new FakeStatusCode(Code.UNAVAILABLE), /* retryable= */ true);

    ApiResultRetryAlgorithm<String> algorithm = new ApiResultRetryAlgorithm<>();
    assertFalse(algorithm.shouldRetry(nonRetryable, null));
    assertTrue(algorithm.shouldRetry(retryable, null));
  }

  @Test
  void testShouldRetryWithContextWithoutRetryableCodes() {
    ApiCallContext context =
        mock(ApiCallContext.class, Mockito.withSettings().withoutAnnotations());
    // No retryable codes in the call context, means that the retry algorithm should fall back to
    // its default implementation.
    when(context.getRetryableCodes()).thenReturn(null);

    ApiException nonRetryable =
        new ApiException(null, new FakeStatusCode(Code.UNAVAILABLE), /* retryable= */ false);
    ApiException retryable =
        new ApiException(null, new FakeStatusCode(Code.UNAVAILABLE), /* retryable= */ true);

    ApiResultRetryAlgorithm<String> algorithm = new ApiResultRetryAlgorithm<>();
    assertFalse(algorithm.shouldRetry(context, nonRetryable, null));
    assertTrue(algorithm.shouldRetry(context, retryable, null));
  }

  @Test
  void testShouldRetryWithContextWithRetryableCodes() {
    ApiCallContext context =
        mock(ApiCallContext.class, Mockito.withSettings().withoutAnnotations());
    when(context.getRetryableCodes())
        .thenReturn(
            Sets.newHashSet(StatusCode.Code.DEADLINE_EXCEEDED, StatusCode.Code.UNAVAILABLE));

    StatusCode unavailable = mock(StatusCode.class, Mockito.withSettings().withoutAnnotations());
    when(unavailable.getCode()).thenReturn(Code.UNAVAILABLE);
    StatusCode dataLoss = mock(StatusCode.class, Mockito.withSettings().withoutAnnotations());
    when(dataLoss.getCode()).thenReturn(Code.DATA_LOSS);

    // The return value of isRetryable() will be ignored, as UNAVAILABLE has been added as a
    // retryable code to the call context.
    ApiException unavailableException =
        new ApiException(null, new FakeStatusCode(Code.UNAVAILABLE), /* retryable= */ false);
    ApiException dataLossException =
        new ApiException(null, new FakeStatusCode(Code.DATA_LOSS), /* retryable= */ true);

    ApiResultRetryAlgorithm<String> algorithm = new ApiResultRetryAlgorithm<>();
    assertTrue(algorithm.shouldRetry(context, unavailableException, null));
    assertFalse(algorithm.shouldRetry(context, dataLossException, null));
  }

  @Test
  void testShouldRetryWithContextWithEmptyRetryableCodes() {
    ApiCallContext context =
        mock(ApiCallContext.class, Mockito.withSettings().withoutAnnotations());
    // This will effectively make the RPC non-retryable.
    when(context.getRetryableCodes()).thenReturn(Collections.<Code>emptySet());

    ApiException unavailableException =
        new ApiException(null, new FakeStatusCode(Code.UNAVAILABLE), /* retryable= */ true);

    ApiResultRetryAlgorithm<String> algorithm = new ApiResultRetryAlgorithm<>();
    assertFalse(algorithm.shouldRetry(context, unavailableException, null));
  }

  @Test
  void testRotationRetryWithNonRetryableSettings_maxAttemptsOne() {
    ApiCallContext context =
        mock(ApiCallContext.class, Mockito.withSettings().withoutAnnotations());
    when(context.getRetryableCodes()).thenReturn(Collections.emptySet());

    RetrySettings settings =
        RetrySettings.newBuilder()
            .setMaxAttempts(1)
            .setInitialRpcTimeoutDuration(Duration.ofSeconds(10))
            .setMaxRpcTimeoutDuration(Duration.ofSeconds(10))
            .setTotalTimeoutDuration(Duration.ofSeconds(10))
            .build();

    ApiResultRetryAlgorithm<String> resultAlgorithm = new ApiResultRetryAlgorithm<>();
    ExponentialRetryAlgorithm timedAlgorithm =
        new ExponentialRetryAlgorithm(settings, NanoClock.getDefaultClock());
    RetryAlgorithm<String> retryAlgorithm = new RetryAlgorithm<>(resultAlgorithm, timedAlgorithm);

    TimedAttemptSettings firstAttempt = retryAlgorithm.createFirstAttempt(context);
    UnauthenticatedException rotationEx =
        new UnauthenticatedException(
            "Expired cert", null, new FakeStatusCode(Code.UNAUTHENTICATED), /* retryable= */ true);

    // First rotation failure: grants immediate free retry without incrementing attemptCount
    TimedAttemptSettings nextAttempt =
        retryAlgorithm.createNextAttempt(context, rotationEx, null, firstAttempt);
    assertNotNull(nextAttempt);
    assertEquals(Duration.ZERO, nextAttempt.getRetryDelayDuration());
    assertEquals(Duration.ZERO, nextAttempt.getRandomizedRetryDelayDuration());
    assertEquals(0, nextAttempt.getAttemptCount());
    assertEquals(1, nextAttempt.getOverallAttemptCount());
    assertTrue(retryAlgorithm.shouldRetry(context, rotationEx, null, nextAttempt));

    // Second consecutive failure: overallAttemptCount (1) != attemptCount (0), so no free retry
    TimedAttemptSettings thirdAttempt =
        retryAlgorithm.createNextAttempt(context, rotationEx, null, nextAttempt);
    assertNotNull(thirdAttempt);
    assertEquals(1, thirdAttempt.getAttemptCount());
    assertEquals(2, thirdAttempt.getOverallAttemptCount());
    assertFalse(retryAlgorithm.shouldRetry(context, rotationEx, null, thirdAttempt));
  }

  @Test
  void testRotationRetryWithNonRetryableSettings_zeroMaxAttemptsZeroTotalTimeout() {
    ApiCallContext context =
        mock(ApiCallContext.class, Mockito.withSettings().withoutAnnotations());
    when(context.getRetryableCodes()).thenReturn(Collections.emptySet());

    RetrySettings settings =
        RetrySettings.newBuilder().setMaxAttempts(0).setTotalTimeoutDuration(Duration.ZERO).build();

    ApiResultRetryAlgorithm<String> resultAlgorithm = new ApiResultRetryAlgorithm<>();
    ExponentialRetryAlgorithm timedAlgorithm =
        new ExponentialRetryAlgorithm(settings, NanoClock.getDefaultClock());
    RetryAlgorithm<String> retryAlgorithm = new RetryAlgorithm<>(resultAlgorithm, timedAlgorithm);

    TimedAttemptSettings firstAttempt = retryAlgorithm.createFirstAttempt(context);
    UnauthenticatedException rotationEx =
        new UnauthenticatedException(
            "Expired cert", null, new FakeStatusCode(Code.UNAUTHENTICATED), /* retryable= */ true);

    TimedAttemptSettings nextAttempt =
        retryAlgorithm.createNextAttempt(context, rotationEx, null, firstAttempt);
    assertNotNull(nextAttempt);
    assertEquals(1, nextAttempt.getGlobalSettings().getMaxAttempts());
    assertEquals(0, nextAttempt.getAttemptCount());
    assertEquals(1, nextAttempt.getOverallAttemptCount());
    assertTrue(retryAlgorithm.shouldRetry(context, rotationEx, null, nextAttempt));

    // Subsequent failure is rejected
    TimedAttemptSettings thirdAttempt =
        retryAlgorithm.createNextAttempt(context, rotationEx, null, nextAttempt);
    assertNotNull(thirdAttempt);
    assertFalse(retryAlgorithm.shouldRetry(context, rotationEx, null, thirdAttempt));
  }

  @Test
  void testRotationRetryAfterTransientErrorPreservesRemainingBudget() {
    ApiCallContext context =
        mock(ApiCallContext.class, Mockito.withSettings().withoutAnnotations());
    when(context.getRetryableCodes()).thenReturn(Sets.newHashSet(Code.UNAVAILABLE));

    RetrySettings settings =
        RetrySettings.newBuilder()
            .setMaxAttempts(3)
            .setInitialRetryDelayDuration(Duration.ofMillis(100))
            .setRetryDelayMultiplier(2.0)
            .setMaxRetryDelayDuration(Duration.ofSeconds(1))
            .setTotalTimeoutDuration(Duration.ofSeconds(30))
            .build();

    ApiResultRetryAlgorithm<String> resultAlgorithm = new ApiResultRetryAlgorithm<>();
    ExponentialRetryAlgorithm timedAlgorithm =
        new ExponentialRetryAlgorithm(settings, NanoClock.getDefaultClock());
    RetryAlgorithm<String> retryAlgorithm = new RetryAlgorithm<>(resultAlgorithm, timedAlgorithm);

    TimedAttemptSettings attempt0 = retryAlgorithm.createFirstAttempt(context);
    ApiException unavailableEx =
        new ApiException(null, new FakeStatusCode(Code.UNAVAILABLE), /* retryable= */ true);
    UnauthenticatedException rotationEx =
        new UnauthenticatedException(
            "Expired cert", null, new FakeStatusCode(Code.UNAUTHENTICATED), /* retryable= */ true);

    // Attempt 0 fails with UNAVAILABLE -> normal retry (attemptCount = 1, overallAttemptCount = 1)
    TimedAttemptSettings attempt1 =
        retryAlgorithm.createNextAttempt(context, unavailableEx, null, attempt0);
    assertEquals(1, attempt1.getAttemptCount());
    assertEquals(1, attempt1.getOverallAttemptCount());
    assertTrue(retryAlgorithm.shouldRetry(context, unavailableEx, null, attempt1));

    // Attempt 1 fails with rotation 401 -> free zero-delay retry (attemptCount = 1,
    // overallAttemptCount = 2)
    TimedAttemptSettings attempt2 =
        retryAlgorithm.createNextAttempt(context, rotationEx, null, attempt1);
    assertEquals(Duration.ZERO, attempt2.getRetryDelayDuration());
    assertEquals(1, attempt2.getAttemptCount());
    assertEquals(2, attempt2.getOverallAttemptCount());
    assertTrue(retryAlgorithm.shouldRetry(context, rotationEx, null, attempt2));

    // Attempt 2 fails with UNAVAILABLE -> normal retry still allowed (attemptCount = 2 <
    // maxAttempts = 3)
    TimedAttemptSettings attempt3 =
        retryAlgorithm.createNextAttempt(context, unavailableEx, null, attempt2);
    assertEquals(2, attempt3.getAttemptCount());
    assertEquals(3, attempt3.getOverallAttemptCount());
    assertTrue(retryAlgorithm.shouldRetry(context, unavailableEx, null, attempt3));
  }
}
