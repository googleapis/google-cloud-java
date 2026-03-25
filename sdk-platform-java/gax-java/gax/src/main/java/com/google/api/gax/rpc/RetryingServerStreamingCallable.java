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
package com.google.api.gax.rpc;

import static com.google.common.util.concurrent.MoreExecutors.directExecutor;

import com.google.api.core.ApiFutureCallback;
import com.google.api.core.ApiFutures;
import com.google.api.gax.retrying.RetryingFuture;
import com.google.api.gax.retrying.ScheduledRetryingExecutor;
import com.google.api.gax.retrying.ServerStreamingAttemptException;
import com.google.api.gax.retrying.StreamResumptionStrategy;

/**
 * A ServerStreamingCallable that implements resumable retries.
 *
 * <p>Wraps a request, a {@link ResponseObserver} and an inner {@link ServerStreamingCallable} and
 * coordinates retries between them. When the inner callable throws an error, this class will
 * schedule retries using the configured {@link ScheduledRetryingExecutor}.
 *
 * <p>Streams can be resumed using a {@link StreamResumptionStrategy}. The {@link
 * StreamResumptionStrategy} is notified of incoming responses and is expected to track the progress
 * of the stream. Upon receiving an error, the {@link StreamResumptionStrategy} is asked to modify
 * the original request to resume the stream.
 *
 * <p>Package-private for internal use.
 */
final class RetryingServerStreamingCallable<RequestT, ResponseT>
    extends ServerStreamingCallable<RequestT, ResponseT> {

  private final ServerStreamingCallable<RequestT, ResponseT> innerCallable;
  private final ScheduledRetryingExecutor<Void> executor;
  private final StreamResumptionStrategy<RequestT, ResponseT> resumptionStrategyPrototype;

  RetryingServerStreamingCallable(
      ServerStreamingCallable<RequestT, ResponseT> innerCallable,
      ScheduledRetryingExecutor<Void> executor,
      StreamResumptionStrategy<RequestT, ResponseT> resumptionStrategyPrototype) {
    this.innerCallable = innerCallable;
    this.executor = executor;
    this.resumptionStrategyPrototype = resumptionStrategyPrototype;
  }

  @Override
  public void call(
      RequestT request,
      final ResponseObserver<ResponseT> responseObserver,
      ApiCallContext context) {

    ServerStreamingAttemptCallable<RequestT, ResponseT> attemptCallable =
        new ServerStreamingAttemptCallable<>(
            innerCallable,
            resumptionStrategyPrototype.createNew(),
            request,
            context,
            responseObserver);

    RetryingFuture<Void> retryingFuture = executor.createFuture(attemptCallable, context);
    attemptCallable.setExternalFuture(retryingFuture);
    attemptCallable.start();

    // Bridge the future result back to the external responseObserver
    ApiFutures.addCallback(
        retryingFuture,
        new ApiFutureCallback<Void>() {
          @Override
          public void onFailure(Throwable throwable) {
            // Make sure to unwrap the underlying ApiException
            if (throwable instanceof ServerStreamingAttemptException) {
              throwable = throwable.getCause();
            }
            responseObserver.onError(throwable);
          }

          @Override
          public void onSuccess(Void ignored) {
            responseObserver.onComplete();
          }
        },
        directExecutor());
  }
}
