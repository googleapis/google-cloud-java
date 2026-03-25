/*
 * Copyright 2018 Google LLC
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

import com.google.api.core.InternalApi;
import java.util.concurrent.CancellationException;

/**
 * The streaming retry algorithm, which makes decision based either on the thrown exception and the
 * execution time settings of the previous attempt. This extends {@link RetryAlgorithm} to take
 * additional information (provided by {@code ServerStreamingAttemptCallable}) into account.
 *
 * <p>This class is thread-safe.
 *
 * <p>Internal use only - public for technical reasons.
 */
@InternalApi("For internal use only")
public final class StreamingRetryAlgorithm<ResponseT> extends RetryAlgorithm<ResponseT> {

  /**
   * Instances that are created using this constructor will ignore the {@link RetryingContext} that
   * is passed in to the retrying methods. Use {@link
   * #StreamingRetryAlgorithm(ResultRetryAlgorithmWithContext, TimedRetryAlgorithmWithContext)} to
   * create an instance that will respect the {@link RetryingContext}.
   *
   * @deprecated use {@link #StreamingRetryAlgorithm(ResultRetryAlgorithmWithContext,
   *     TimedRetryAlgorithmWithContext)} instead
   */
  @Deprecated
  public StreamingRetryAlgorithm(
      ResultRetryAlgorithm<ResponseT> resultAlgorithm, TimedRetryAlgorithm timedAlgorithm) {
    super(resultAlgorithm, timedAlgorithm);
  }

  /**
   * Creates a {@link StreamingRetryAlgorithm} that will use the settings (if any) in the {@link
   * RetryingContext} that is passed in to the retrying methods.
   */
  public StreamingRetryAlgorithm(
      ResultRetryAlgorithmWithContext<ResponseT> resultAlgorithm,
      TimedRetryAlgorithmWithContext timedAlgorithm) {
    super(resultAlgorithm, timedAlgorithm);
  }

  /**
   * {@inheritDoc}
   *
   * <p>The attempt settings will be reset if the stream attempt produced any messages.
   */
  @Override
  public TimedAttemptSettings createNextAttempt(
      Throwable previousThrowable,
      ResponseT previousResponse,
      TimedAttemptSettings previousSettings) {
    return createNextAttempt(null, previousThrowable, previousResponse, previousSettings);
  }

  /**
   * {@inheritDoc}
   *
   * <p>The attempt settings will be reset if the stream attempt produced any messages.
   */
  @Override
  public TimedAttemptSettings createNextAttempt(
      RetryingContext context,
      Throwable previousThrowable,
      ResponseT previousResponse,
      TimedAttemptSettings previousSettings) {

    if (previousThrowable instanceof ServerStreamingAttemptException) {
      ServerStreamingAttemptException attemptException =
          (ServerStreamingAttemptException) previousThrowable;
      previousThrowable = previousThrowable.getCause();

      // If we have made progress in the last attempt, then reset the delays
      if (attemptException.hasSeenResponses()) {
        previousSettings =
            createFirstAttempt(context).toBuilder()
                .setFirstAttemptStartTimeNanos(previousSettings.getFirstAttemptStartTimeNanos())
                .setOverallAttemptCount(previousSettings.getOverallAttemptCount())
                .build();
      }
    }

    return super.createNextAttempt(context, previousThrowable, previousResponse, previousSettings);
  }

  /**
   * {@inheritDoc}
   *
   * <p>Ensures retries are only scheduled if the {@link StreamResumptionStrategy} in the {@code
   * ServerStreamingAttemptCallable} supports it.
   */
  @Override
  public boolean shouldRetry(
      Throwable previousThrowable,
      ResponseT previousResponse,
      TimedAttemptSettings nextAttemptSettings)
      throws CancellationException {
    return shouldRetry(null, previousThrowable, previousResponse, nextAttemptSettings);
  }

  /**
   * {@inheritDoc}
   *
   * <p>Schedules retries only if the {@link StreamResumptionStrategy} in the {@code
   * ServerStreamingAttemptCallable} supports it.
   */
  @Override
  public boolean shouldRetry(
      RetryingContext context,
      Throwable previousThrowable,
      ResponseT previousResponse,
      TimedAttemptSettings nextAttemptSettings)
      throws CancellationException {

    // Unwrap
    if (previousThrowable instanceof ServerStreamingAttemptException) {
      ServerStreamingAttemptException attemptException =
          (ServerStreamingAttemptException) previousThrowable;
      previousThrowable = previousThrowable.getCause();

      if (!attemptException.canResume()) {
        return false;
      }
    }

    return super.shouldRetry(context, previousThrowable, previousResponse, nextAttemptSettings);
  }
}
