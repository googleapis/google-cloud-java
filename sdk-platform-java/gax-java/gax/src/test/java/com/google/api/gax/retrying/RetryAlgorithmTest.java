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
package com.google.api.gax.retrying;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

@SuppressWarnings({"unchecked", "deprecation"})
class RetryAlgorithmTest {

  @Test
  void testCreateFirstAttempt() {
    TimedRetryAlgorithm timedAlgorithm = mock(TimedRetryAlgorithm.class);
    RetryAlgorithm<Void> algorithm =
        new RetryAlgorithm<>(mock(ResultRetryAlgorithm.class), timedAlgorithm);

    algorithm.createFirstAttempt();
    verify(timedAlgorithm).createFirstAttempt();
  }

  @Test
  void testCreateFirstAttemptWithUnusedContext() {
    TimedRetryAlgorithm timedAlgorithm = mock(TimedRetryAlgorithm.class);
    RetryAlgorithm<Void> algorithm =
        new RetryAlgorithm<>(mock(ResultRetryAlgorithm.class), timedAlgorithm);

    RetryingContext context = mock(RetryingContext.class);
    algorithm.createFirstAttempt(context);
    verify(timedAlgorithm).createFirstAttempt();
  }

  @Test
  void testCreateFirstAttemptWithContext() {
    TimedRetryAlgorithmWithContext timedAlgorithm = mock(TimedRetryAlgorithmWithContext.class);
    RetryAlgorithm<Void> algorithm =
        new RetryAlgorithm<>(mock(ResultRetryAlgorithmWithContext.class), timedAlgorithm);

    RetryingContext context = mock(RetryingContext.class);
    algorithm.createFirstAttempt(context);
    verify(timedAlgorithm).createFirstAttempt(context);
  }

  @Test
  void testCreateFirstAttemptWithNullContext() {
    TimedRetryAlgorithmWithContext timedAlgorithm = mock(TimedRetryAlgorithmWithContext.class);
    RetryAlgorithm<Void> algorithm =
        new RetryAlgorithm<>(mock(ResultRetryAlgorithmWithContext.class), timedAlgorithm);

    algorithm.createFirstAttempt(null);
    verify(timedAlgorithm).createFirstAttempt();
  }

  @Test
  void testNextAttempt() {
    ResultRetryAlgorithm<Object> resultAlgorithm = mock(ResultRetryAlgorithm.class);
    TimedRetryAlgorithm timedAlgorithm = mock(TimedRetryAlgorithm.class);
    RetryAlgorithm<Object> algorithm = new RetryAlgorithm<>(resultAlgorithm, timedAlgorithm);

    Throwable previousThrowable = new Throwable();
    Object previousResult = new Object();
    TimedAttemptSettings previousSettings = mock(TimedAttemptSettings.class);

    algorithm.createNextAttempt(previousThrowable, previousResult, previousSettings);
    verify(resultAlgorithm).shouldRetry(previousThrowable, previousResult);
  }

  @Test
  void testNextAttemptWithContext() {
    ResultRetryAlgorithmWithContext<Object> resultAlgorithm =
        mock(ResultRetryAlgorithmWithContext.class);
    TimedRetryAlgorithmWithContext timedAlgorithm = mock(TimedRetryAlgorithmWithContext.class);
    RetryAlgorithm<Object> algorithm = new RetryAlgorithm<>(resultAlgorithm, timedAlgorithm);

    RetryingContext context = mock(RetryingContext.class);
    Throwable previousThrowable = new Throwable();
    Object previousResult = new Object();
    TimedAttemptSettings previousSettings = mock(TimedAttemptSettings.class);

    algorithm.createNextAttempt(context, previousThrowable, previousResult, previousSettings);
    verify(resultAlgorithm).shouldRetry(context, previousThrowable, previousResult);
  }

  @Test
  void testShouldRetry() {
    ResultRetryAlgorithm<Object> resultAlgorithm = mock(ResultRetryAlgorithm.class);
    TimedRetryAlgorithm timedAlgorithm = mock(TimedRetryAlgorithm.class);
    RetryAlgorithm<Object> algorithm = new RetryAlgorithm<>(resultAlgorithm, timedAlgorithm);

    Throwable previousThrowable = new Throwable();
    Object previousResult = new Object();
    TimedAttemptSettings previousSettings = mock(TimedAttemptSettings.class);

    algorithm.shouldRetry(previousThrowable, previousResult, previousSettings);
    verify(resultAlgorithm).shouldRetry(previousThrowable, previousResult);
  }

  @Test
  void testShouldRetry_usesTimedAlgorithm() {
    ResultRetryAlgorithm<Object> resultAlgorithm = mock(ResultRetryAlgorithm.class);
    TimedRetryAlgorithm timedAlgorithm = mock(TimedRetryAlgorithm.class);
    RetryAlgorithm<Object> algorithm = new RetryAlgorithm<>(resultAlgorithm, timedAlgorithm);

    Throwable previousThrowable = new Throwable();
    Object previousResult = new Object();
    TimedAttemptSettings previousSettings = mock(TimedAttemptSettings.class);
    when(resultAlgorithm.shouldRetry(previousThrowable, previousResult)).thenReturn(true);

    algorithm.shouldRetry(previousThrowable, previousResult, previousSettings);
    verify(timedAlgorithm).shouldRetry(previousSettings);
  }

  @Test
  void testShouldRetryWithContext() {
    ResultRetryAlgorithmWithContext<Object> resultAlgorithm =
        mock(ResultRetryAlgorithmWithContext.class);
    TimedRetryAlgorithmWithContext timedAlgorithm = mock(TimedRetryAlgorithmWithContext.class);
    RetryAlgorithm<Object> algorithm = new RetryAlgorithm<>(resultAlgorithm, timedAlgorithm);

    RetryingContext context = mock(RetryingContext.class);
    Throwable previousThrowable = new Throwable();
    Object previousResult = new Object();
    TimedAttemptSettings previousSettings = mock(TimedAttemptSettings.class);

    algorithm.shouldRetry(context, previousThrowable, previousResult, previousSettings);
    verify(resultAlgorithm).shouldRetry(context, previousThrowable, previousResult);
  }

  @Test
  void testShouldRetryWithContext_usesTimedAlgorithm() {
    ResultRetryAlgorithmWithContext<Object> resultAlgorithm =
        mock(ResultRetryAlgorithmWithContext.class);
    TimedRetryAlgorithmWithContext timedAlgorithm = mock(TimedRetryAlgorithmWithContext.class);
    RetryAlgorithm<Object> algorithm = new RetryAlgorithm<>(resultAlgorithm, timedAlgorithm);

    RetryingContext context = mock(RetryingContext.class);
    Throwable previousThrowable = new Throwable();
    Object previousResult = new Object();
    TimedAttemptSettings previousSettings = mock(TimedAttemptSettings.class);
    when(resultAlgorithm.shouldRetry(context, previousThrowable, previousResult)).thenReturn(true);

    algorithm.shouldRetry(context, previousThrowable, previousResult, previousSettings);
    verify(timedAlgorithm).shouldRetry(context, previousSettings);
  }

  @Test
  void testShouldRetry_noPreviousSettings() {
    ResultRetryAlgorithm<Object> resultAlgorithm = mock(ResultRetryAlgorithm.class);
    TimedRetryAlgorithm timedAlgorithm = mock(TimedRetryAlgorithm.class);
    RetryAlgorithm<Object> algorithm = new RetryAlgorithm<>(resultAlgorithm, timedAlgorithm);

    Throwable previousThrowable = new Throwable();
    Object previousResult = new Object();
    when(resultAlgorithm.shouldRetry(previousThrowable, previousResult)).thenReturn(true);

    assertFalse(algorithm.shouldRetry(previousThrowable, previousResult, null));
  }

  @Test
  void testShouldRetryWithContext_noPreviousSettings() {
    ResultRetryAlgorithmWithContext<Object> resultAlgorithm =
        mock(ResultRetryAlgorithmWithContext.class);
    TimedRetryAlgorithmWithContext timedAlgorithm = mock(TimedRetryAlgorithmWithContext.class);
    RetryAlgorithm<Object> algorithm = new RetryAlgorithm<>(resultAlgorithm, timedAlgorithm);

    RetryingContext context = mock(RetryingContext.class);
    Throwable previousThrowable = new Throwable();
    Object previousResult = new Object();

    assertFalse(algorithm.shouldRetry(context, previousThrowable, previousResult, null));
  }
}
