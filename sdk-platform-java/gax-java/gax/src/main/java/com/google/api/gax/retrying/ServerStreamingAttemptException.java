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

/**
 * A wrapper exception thrown by {@code ServerStreamingAttemptCallable} to communicate additional
 * context to the {@link StreamingRetryAlgorithm} and to pass the original cancellation stack trace
 * to {@code RetryingServerStreamingCallable}.
 *
 * <p>For internal use only - public for technical reasons.
 */
@InternalApi
public class ServerStreamingAttemptException extends RuntimeException {
  private final boolean canResume;
  private final boolean seenResponses;

  public ServerStreamingAttemptException(
      Throwable cause, boolean canResume, boolean seenResponses) {
    super(cause.getMessage(), cause);
    this.canResume = canResume;
    this.seenResponses = seenResponses;
  }

  /** If the {@link StreamResumptionStrategy} supports resuming after this error. */
  public boolean canResume() {
    return canResume;
  }

  /**
   * If the current RPC attempt has seen any streamed messages. This is used as a signal by {@link
   * StreamingRetryAlgorithm} to reset timers.
   */
  public boolean hasSeenResponses() {
    return seenResponses;
  }
}
