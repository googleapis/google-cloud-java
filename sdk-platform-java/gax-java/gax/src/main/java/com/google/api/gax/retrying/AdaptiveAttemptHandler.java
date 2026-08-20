/*
 * Copyright 2026 Google LLC
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
import com.google.api.core.InternalApi;
import com.google.api.gax.rpc.ApiCallContext;
import org.jspecify.annotations.NullMarked;

/**
 * Handler implemented by stateful/adaptive operations to control attempt execution and asynchronous
 * error recovery under {@link AdaptiveRetryingCallable}.
 *
 * @param <ResponseT> response type
 */
@InternalApi
@NullMarked
public interface AdaptiveAttemptHandler<ResponseT> {

  /**
   * Starts or resumes an attempt asynchronously.
   *
   * @param attemptContext the context for this attempt, with configured rpcTimeout
   * @return future that completes when the attempt succeeds or the overall operation finishes
   */
  ApiFuture<ResponseT> startAttempt(ApiCallContext attemptContext);

  /**
   * Called when an attempt fails. Allows the handler to perform asynchronous recovery (e.g.
   * querying server status, resynchronizing offsets, rewinding stream buffers) before the next
   * attempt is scheduled.
   *
   * @param previousThrowable the error that caused the attempt to fail
   * @param attemptContext the call context
   * @return future resolving to true if recovery succeeded and retry should proceed, or false /
   *     exceptional future if unrecoverable
   */
  ApiFuture<Boolean> onAttemptFailure(Throwable previousThrowable, ApiCallContext attemptContext);
}
