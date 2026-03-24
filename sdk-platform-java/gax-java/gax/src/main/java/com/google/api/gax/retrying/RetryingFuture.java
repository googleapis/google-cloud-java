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

import com.google.api.core.ApiFuture;
import java.util.concurrent.Callable;

/**
 * Represents a retrying future. This is a facade hiding all the complications of an
 * asynchronous/synchronous execution of a retriable task.
 *
 * <p>This interface is for advanced/internal use only.
 *
 * @param <ResponseT> response type
 */
public interface RetryingFuture<ResponseT> extends ApiFuture<ResponseT> {
  /**
   * Sets the attempt in a form of a future. This future represents a concrete retry attempt,
   * potentially scheduled for execution in a some form of {@link
   * java.util.concurrent.ScheduledExecutorService}, or an already completed future if the attempts
   * are executed synchronously.
   *
   * @param attemptFuture the attempt future
   */
  void setAttemptFuture(ApiFuture<ResponseT> attemptFuture);

  /** Returns callable tracked by this future. */
  Callable<ResponseT> getCallable();

  /** Returns current (active) attempt settings. */
  TimedAttemptSettings getAttemptSettings();

  /**
   * Returns latest completed attempt result or {@code null} if the first attempt hasn't completed
   * yet.
   *
   * <p>This method is for internal/advanced use only.
   *
   * <p>If not null, the returned value is guaranteed to be an already completed future, so {@link
   * ApiFuture#isDone()} will always be {@code true} and {@link ApiFuture#get()} will always be
   * non-blocking.
   *
   * <p>In case if the whole retrying future is completed, this method returns the same result as
   * the retrying future itself.
   *
   * <p>The number of attempt results may be (and usually is) lower than the number of actual
   * attempts, since only a completed attempt has a result and not all attempts complete (some of
   * the service attempts, needed for proper execution of the actual attempts).
   *
   * <p>For each execution the following invariants hold:
   *
   * <ul>
   *   <li>If the first attempt hasn't completed yet, this method returns {@code null}.
   *   <li>Right after completion of each attempt this method starts returning a new already
   *       completed future, which represents the result of the latest completed attempt.
   *   <li>If it was the last attempt, the events happen in the following order: 1) the attempt
   *       future completes; 2) the whole retrying future completes; 3) this method starts returning
   *       a new already completed future, which represents the result of the last completed
   *       attempt.
   *   <li>After completion of the whole retrying future this method always returns exactly same
   *       future object.
   * </ul>
   */
  ApiFuture<ResponseT> peekAttemptResult();

  /**
   * Returns the current (active on the moment of the execution of this method) attempt result
   * future, allowing to track progress of the retrying future execution.
   *
   * <p>Adding direct executor (same thread) callbacks to the future returned by this method is
   * strongly not recommended, since the future is resolved under retrying future's internal lock
   * and may affect the whole retrying process. Adding separate thread callbacks is ok.
   *
   * <p>This method is for internal/advanced use only.
   *
   * <p>The returned future completes right after the corresponding attempt which it tracks, so
   * calling {@link ApiFuture#get()} is potentially a blocking operation. This method returns
   * exactly same future object until it completes (meaning that the corresponding attempt has
   * completed). If there is another attempt made after completion of the current attempt, the
   * subsequent call to this method will return a new future which will track the new attempt.
   *
   * <p>In case if the whole retrying future is completed, this method returns the same result as
   * the retrying future itself.
   *
   * <p>The returned future is non-cancellable, so calling {@link ApiFuture#cancel(boolean)} will
   * have no effect and will always return {@code false}.
   *
   * <p>The number of attempt results may be (and usually is) lower than the number of actual
   * attempts, since only a completed attempt has a result and not all attempts complete (some of
   * the service attempts, needed for proper execution of the actual attempts).
   *
   * <p>For each execution the following invariants hold:
   *
   * <ul>
   *   <li>The future returned by this method completes soon after the attempt it tracks.
   *   <li>If it was the last attempt, the futures complete in the following order: 1) the attempt
   *       future; 2) the whole retrying future; 3) the attempt result future returned by this
   *       method.
   *   <li>After completion of the whole retrying future this method always returns exactly same
   *       future object.
   * </ul>
   */
  ApiFuture<ResponseT> getAttemptResult();
}
