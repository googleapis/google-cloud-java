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

import java.util.concurrent.CancellationException;

/**
 * A basic implementation of {@link ResultRetryAlgorithm}. Using this implementation would mean that
 * all exceptions should be retried, all responses should be accepted (including {@code null}) and
 * no retrying process should ever be canceled.
 *
 * @param <ResponseT> attempt response type
 */
public class BasicResultRetryAlgorithm<ResponseT>
    implements ResultRetryAlgorithmWithContext<ResponseT> {
  /**
   * Always returns null, indicating that this algorithm does not provide any specific settings for
   * the next attempt.
   */
  @Override
  public TimedAttemptSettings createNextAttempt(
      Throwable previousThrowable,
      ResponseT previousResponse,
      TimedAttemptSettings previousSettings) {
    return null;
  }

  /**
   * Always returns null, indicating that this algorithm does not provide any specific settings for
   * the next attempt.
   */
  @Override
  public TimedAttemptSettings createNextAttempt(
      RetryingContext context,
      Throwable previousThrowable,
      ResponseT previousResponse,
      TimedAttemptSettings previousSettings) {
    return createNextAttempt(previousThrowable, previousResponse, previousSettings);
  }

  /**
   * Returns {@code true} if an exception was thrown ({@code previousThrowable != null}), {@code
   * false} otherwise.
   */
  @Override
  public boolean shouldRetry(Throwable previousThrowable, ResponseT previousResponse) {
    return previousThrowable != null;
  }

  /**
   * Returns {@code true} if an exception was thrown ({@code previousThrowable != null}), {@code
   * false} otherwise.
   */
  @Override
  public boolean shouldRetry(
      RetryingContext context, Throwable previousThrowable, ResponseT previousResponse)
      throws CancellationException {
    return shouldRetry(previousThrowable, previousResponse);
  }
}
