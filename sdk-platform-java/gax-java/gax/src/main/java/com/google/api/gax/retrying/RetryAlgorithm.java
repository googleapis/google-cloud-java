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
package com.google.api.gax.retrying;

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.api.core.BetaApi;
import java.util.concurrent.CancellationException;

/**
 * The retry algorithm, which makes decision based either on the thrown exception or the returned
 * response, and the execution time settings of the previous attempt.
 *
 * <p>This class is thread-safe.
 *
 * @param <ResponseT> response type
 */
public class RetryAlgorithm<ResponseT> {
  private final ResultRetryAlgorithm<ResponseT> resultAlgorithm;
  private final TimedRetryAlgorithm timedAlgorithm;
  private final ResultRetryAlgorithmWithContext<ResponseT> resultAlgorithmWithContext;
  private final TimedRetryAlgorithmWithContext timedAlgorithmWithContext;

  /**
   * Creates a new retry algorithm instance, which uses thrown exception or returned response and
   * timed algorithms to make a decision. The result algorithm has higher priority than the timed
   * algorithm.
   *
   * <p>Instances that are created using this constructor will ignore the {@link RetryingContext}
   * that is passed in to the retrying methods. Use {@link
   * #RetryAlgorithm(ResultRetryAlgorithmWithContext, TimedRetryAlgorithmWithContext)} to create an
   * instance that will respect the {@link RetryingContext}.
   *
   * @param resultAlgorithm result algorithm to use
   * @param timedAlgorithm timed algorithm to use
   * @deprecated use {@link RetryAlgorithm#RetryAlgorithm(ResultRetryAlgorithmWithContext,
   *     TimedRetryAlgorithmWithContext)} instead
   */
  @Deprecated
  public RetryAlgorithm(
      ResultRetryAlgorithm<ResponseT> resultAlgorithm, TimedRetryAlgorithm timedAlgorithm) {
    this.resultAlgorithm = checkNotNull(resultAlgorithm);
    this.timedAlgorithm = checkNotNull(timedAlgorithm);
    this.resultAlgorithmWithContext = null;
    this.timedAlgorithmWithContext = null;
  }

  /**
   * Creates a new retry algorithm instance, which uses thrown exception or returned response and
   * timed algorithms to make a decision. The result algorithm has higher priority than the timed
   * algorithm.
   *
   * @param resultAlgorithm result algorithm to use
   * @param timedAlgorithm timed algorithm to use
   */
  public RetryAlgorithm(
      ResultRetryAlgorithmWithContext<ResponseT> resultAlgorithm,
      TimedRetryAlgorithmWithContext timedAlgorithm) {
    this.resultAlgorithm = null;
    this.timedAlgorithm = null;
    this.resultAlgorithmWithContext = checkNotNull(resultAlgorithm);
    this.timedAlgorithmWithContext = checkNotNull(timedAlgorithm);
  }

  /**
   * Creates a first attempt {@link TimedAttemptSettings}.
   *
   * @return first attempt settings
   * @deprecated use {@link #createFirstAttempt(RetryingContext)} instead
   */
  @Deprecated
  public TimedAttemptSettings createFirstAttempt() {
    return createFirstAttempt(null);
  }

  /**
   * Creates a first attempt {@link TimedAttemptSettings}.
   *
   * @param context the {@link RetryingContext} that can be used to get the initial {@link
   *     RetrySettings}
   * @return first attempt settings
   */
  public TimedAttemptSettings createFirstAttempt(RetryingContext context) {
    if (timedAlgorithmWithContext != null && context != null) {
      return timedAlgorithmWithContext.createFirstAttempt(context);
    }
    return getTimedAlgorithm().createFirstAttempt();
  }

  /**
   * Creates a next attempt {@link TimedAttemptSettings}. This method will return first non-null
   * value, returned by either result or timed retry algorithms in that particular order.
   *
   * @param previousThrowable exception thrown by the previous attempt or null if a result was
   *     returned instead
   * @param previousResponse response returned by the previous attempt or null if an exception was
   *     thrown instead
   * @param previousSettings previous attempt settings
   * @return next attempt settings, can be {@code null}, if no there should be no new attempt
   * @deprecated use {@link #createNextAttempt(RetryingContext, Throwable, Object,
   *     TimedAttemptSettings)} instead
   */
  @Deprecated
  public TimedAttemptSettings createNextAttempt(
      Throwable previousThrowable,
      ResponseT previousResponse,
      TimedAttemptSettings previousSettings) {
    return createNextAttempt(null, previousThrowable, previousResponse, previousSettings);
  }

  /**
   * Creates a next attempt {@link TimedAttemptSettings}. This method will return first non-null
   * value, returned by either result or timed retry algorithms in that particular order.
   *
   * @param context the {@link RetryingContext} that can be used to determine the {@link
   *     RetrySettings} for the next attempt
   * @param previousThrowable exception thrown by the previous attempt or null if a result was
   *     returned instead
   * @param previousResponse response returned by the previous attempt or null if an exception was
   *     thrown instead
   * @param previousSettings previous attempt settings
   * @return next attempt settings, can be {@code null}, if there should be no new attempt
   */
  public TimedAttemptSettings createNextAttempt(
      RetryingContext context,
      Throwable previousThrowable,
      ResponseT previousResponse,
      TimedAttemptSettings previousSettings) {
    // a small optimization that avoids calling relatively heavy methods
    // like timedAlgorithm.createNextAttempt(), when it is not necessary.
    if (!shouldRetryBasedOnResult(context, previousThrowable, previousResponse)) {
      return null;
    }

    TimedAttemptSettings newSettings =
        createNextAttemptBasedOnResult(
            context, previousThrowable, previousResponse, previousSettings);
    if (newSettings == null) {
      newSettings = createNextAttemptBasedOnTiming(context, previousSettings);
    }
    return newSettings;
  }

  private TimedAttemptSettings createNextAttemptBasedOnResult(
      RetryingContext context,
      Throwable previousThrowable,
      ResponseT previousResponse,
      TimedAttemptSettings previousSettings) {
    if (resultAlgorithmWithContext != null && context != null) {
      return resultAlgorithmWithContext.createNextAttempt(
          context, previousThrowable, previousResponse, previousSettings);
    }
    return getResultAlgorithm()
        .createNextAttempt(previousThrowable, previousResponse, previousSettings);
  }

  private TimedAttemptSettings createNextAttemptBasedOnTiming(
      RetryingContext context, TimedAttemptSettings previousSettings) {
    if (timedAlgorithmWithContext != null && context != null) {
      return timedAlgorithmWithContext.createNextAttempt(context, previousSettings);
    }
    return getTimedAlgorithm().createNextAttempt(previousSettings);
  }

  /**
   * Returns {@code true} if another attempt should be made, or {@code false} otherwise.
   *
   * @param previousThrowable exception thrown by the previous attempt or null if a result was
   *     returned instead
   * @param previousResponse response returned by the previous attempt or null if an exception was
   *     thrown instead
   * @param nextAttemptSettings attempt settings, which will be used for the next attempt, if
   *     accepted
   * @throws CancellationException if the retrying process should be canceled
   * @return {@code true} if another attempt should be made, or {@code false} otherwise
   * @deprecated use {@link #shouldRetry(RetryingContext, Throwable, Object, TimedAttemptSettings)}
   *     instead
   */
  @Deprecated
  public boolean shouldRetry(
      Throwable previousThrowable,
      ResponseT previousResponse,
      TimedAttemptSettings nextAttemptSettings)
      throws CancellationException {
    return shouldRetry(null, previousThrowable, previousResponse, nextAttemptSettings);
  }

  /**
   * Returns {@code true} if another attempt should be made, or {@code false} otherwise.
   *
   * @param context the {@link RetryingContext} that can be used to determine whether another
   *     attempt should be made
   * @param previousThrowable exception thrown by the previous attempt or null if a result was
   *     returned instead
   * @param previousResponse response returned by the previous attempt or null if an exception was
   *     thrown instead
   * @param nextAttemptSettings attempt settings, which will be used for the next attempt, if
   *     accepted
   * @throws CancellationException if the retrying process should be cancelled
   * @return {@code true} if another attempt should be made, or {@code false} otherwise
   */
  public boolean shouldRetry(
      RetryingContext context,
      Throwable previousThrowable,
      ResponseT previousResponse,
      TimedAttemptSettings nextAttemptSettings)
      throws CancellationException {
    return shouldRetryBasedOnResult(context, previousThrowable, previousResponse)
        && shouldRetryBasedOnTiming(context, nextAttemptSettings);
  }

  boolean shouldRetryBasedOnResult(
      RetryingContext context, Throwable previousThrowable, ResponseT previousResponse) {
    if (resultAlgorithmWithContext != null && context != null) {
      return resultAlgorithmWithContext.shouldRetry(context, previousThrowable, previousResponse);
    }
    return getResultAlgorithm().shouldRetry(previousThrowable, previousResponse);
  }

  private boolean shouldRetryBasedOnTiming(
      RetryingContext context, TimedAttemptSettings nextAttemptSettings) {
    if (nextAttemptSettings == null) {
      return false;
    }
    if (timedAlgorithmWithContext != null && context != null) {
      return timedAlgorithmWithContext.shouldRetry(context, nextAttemptSettings);
    }
    return getTimedAlgorithm().shouldRetry(nextAttemptSettings);
  }

  @BetaApi("Surface for inspecting the a RetryAlgorithm is not yet stable")
  public ResultRetryAlgorithm<ResponseT> getResultAlgorithm() {
    return resultAlgorithmWithContext != null ? resultAlgorithmWithContext : resultAlgorithm;
  }

  @BetaApi("Surface for inspecting the a RetryAlgorithm is not yet stable")
  public TimedRetryAlgorithm getTimedAlgorithm() {
    return timedAlgorithmWithContext != null ? timedAlgorithmWithContext : timedAlgorithm;
  }
}
