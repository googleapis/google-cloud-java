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
 * Same as {@link ResultRetryAlgorithmWithContext}, but without methods that accept a {@link
 * RetryingContext}. Use {@link ResultRetryAlgorithmWithContext} instead of this interface when
 * possible.
 */
public interface ResultRetryAlgorithm<ResponseT> {
  /**
   * Same as {@link ResultRetryAlgorithmWithContext#createNextAttempt(RetryingContext, Throwable,
   * Object, TimedAttemptSettings)}, but without a {@link RetryingContext}.
   *
   * <p>Use {@link ResultRetryAlgorithmWithContext#createNextAttempt(RetryingContext, Throwable,
   * Object, TimedAttemptSettings)} instead of this method when possible.
   */
  TimedAttemptSettings createNextAttempt(
      Throwable prevThrowable, ResponseT prevResponse, TimedAttemptSettings prevSettings);

  /**
   * Same as {@link ResultRetryAlgorithmWithContext#shouldRetry(Throwable, Object)}, but without a
   * {@link RetryingContext}.
   *
   * <p>Use {@link ResultRetryAlgorithmWithContext#shouldRetry(RetryingContext, Throwable, Object)}
   * instead of this method when possible.
   */
  boolean shouldRetry(Throwable prevThrowable, ResponseT prevResponse) throws CancellationException;
}
