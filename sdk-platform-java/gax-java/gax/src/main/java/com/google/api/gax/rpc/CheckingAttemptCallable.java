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
package com.google.api.gax.rpc;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.retrying.NonCancellableFuture;
import com.google.api.gax.retrying.RetryingFuture;
import com.google.common.base.Preconditions;
import java.util.concurrent.Callable;

/**
 * A callable representing an attempt to check the status of something by issuing a call to a
 * UnaryCallable. This class is used from {@link RecheckingCallable}.
 *
 * <p>Package-private for internal use.
 *
 * @param <RequestT> request type
 * @param <ResponseT> response type
 */
class CheckingAttemptCallable<RequestT, ResponseT> implements Callable<ResponseT> {
  private final UnaryCallable<RequestT, ResponseT> callable;
  private final ApiCallContext originalCallContext;

  private volatile RetryingFuture<ResponseT> externalFuture;

  CheckingAttemptCallable(UnaryCallable<RequestT, ResponseT> callable, ApiCallContext callContext) {
    this.callable = Preconditions.checkNotNull(callable);
    this.originalCallContext = Preconditions.checkNotNull(callContext);
  }

  public void setExternalFuture(RetryingFuture<ResponseT> externalFuture) {
    this.externalFuture = Preconditions.checkNotNull(externalFuture);
  }

  @Override
  public ResponseT call() {
    ApiCallContext callContext = originalCallContext;

    try {
      java.time.Duration rpcTimeout = externalFuture.getAttemptSettings().getRpcTimeoutDuration();
      if (!rpcTimeout.isZero()) {
        callContext = callContext.withTimeoutDuration(rpcTimeout);
      }

      externalFuture.setAttemptFuture(new NonCancellableFuture<ResponseT>());
      if (externalFuture.isDone()) {
        return null;
      }

      callContext
          .getTracer()
          .attemptStarted(externalFuture.getAttemptSettings().getOverallAttemptCount());

      // NOTE: The callable here is an OperationCheckingCallable, which will compose its own
      // request using a resolved operation name and ignore anything that we pass here for the
      // request.
      ApiFuture<ResponseT> internalFuture = callable.futureCall(null, callContext);
      externalFuture.setAttemptFuture(internalFuture);
    } catch (Throwable e) {
      externalFuture.setAttemptFuture(ApiFutures.<ResponseT>immediateFailedFuture(e));
    }

    return null;
  }
}
