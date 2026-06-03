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
 * A callable representing an attempt to make an RPC call. This class is used from {@link
 * RetryingCallable}.
 *
 * <p>Package-private for internal use.
 *
 * @param <RequestT> request type
 * @param <ResponseT> response type
 */
class AttemptCallable<RequestT, ResponseT> implements Callable<ResponseT> {
  private final UnaryCallable<RequestT, ResponseT> callable;
  private final RequestT request;
  private final ApiCallContext originalCallContext;

  private volatile RetryingFuture<ResponseT> externalFuture;

  AttemptCallable(
      UnaryCallable<RequestT, ResponseT> callable, RequestT request, ApiCallContext callContext) {
    this.callable = Preconditions.checkNotNull(callable);
    this.request = Preconditions.checkNotNull(request);
    this.originalCallContext = Preconditions.checkNotNull(callContext);
  }

  public void setExternalFuture(RetryingFuture<ResponseT> externalFuture) {
    this.externalFuture = Preconditions.checkNotNull(externalFuture);
  }

  @Override
  public ResponseT call() {
    ApiCallContext callContext = originalCallContext;

    try {
      // Set the RPC timeout if the caller did not provide their own.
      java.time.Duration rpcTimeout = externalFuture.getAttemptSettings().getRpcTimeoutDuration();
      if (!rpcTimeout.isZero() && callContext.getTimeoutDuration() == null) {
        callContext = callContext.withTimeoutDuration(rpcTimeout);
      }

      externalFuture.setAttemptFuture(new NonCancellableFuture<ResponseT>());
      if (externalFuture.isDone()) {
        return null;
      }

      callContext
          .getTracer()
          .attemptStarted(request, externalFuture.getAttemptSettings().getOverallAttemptCount());

      ApiFuture<ResponseT> internalFuture = callable.futureCall(request, callContext);
      ApiFuture<ResponseT> mappedFuture = new ExceptionMappingFuture<>(internalFuture, callContext);
      externalFuture.setAttemptFuture(mappedFuture);
    } catch (Throwable e) {
      externalFuture.setAttemptFuture(ApiFutures.<ResponseT>immediateFailedFuture(e));
    }

    return null;
  }

  private static class ExceptionMappingFuture<ResponseT>
      extends com.google.api.core.ForwardingApiFuture<ResponseT> {
    private final ApiCallContext context;

    ExceptionMappingFuture(ApiFuture<ResponseT> delegate, ApiCallContext context) {
      super(delegate);
      this.context = context;
    }

    @Override
    public ResponseT get() throws InterruptedException, java.util.concurrent.ExecutionException {
      try {
        return super.get();
      } catch (java.util.concurrent.ExecutionException e) {
        throw new java.util.concurrent.ExecutionException(mapException(e.getCause()));
      }
    }

    @Override
    public ResponseT get(long timeout, java.util.concurrent.TimeUnit unit)
        throws InterruptedException, java.util.concurrent.ExecutionException, java.util.concurrent.TimeoutException {
      try {
        return super.get(timeout, unit);
      } catch (java.util.concurrent.ExecutionException e) {
        throw new java.util.concurrent.ExecutionException(mapException(e.getCause()));
      }
    }

    private Throwable mapException(Throwable cause) {
      if (cause instanceof UnauthenticatedException) {
        TransportChannel transportChannel = context.getTransportChannel();
        if (transportChannel != null && transportChannel.shouldRefresh()) {
          transportChannel.refresh();
          UnauthenticatedException causeEx = (UnauthenticatedException) cause;
          return new UnauthenticatedException(
              causeEx.getMessage(),
              causeEx.getCause(),
              causeEx.getStatusCode(),
              true, // isRetryable = true
              causeEx.getErrorDetails());
        }
      }
      return cause;
    }
  }
}
