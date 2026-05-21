/*
 * Copyright 2023 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.bigtable.gaxx.retrying;

import static com.google.common.util.concurrent.MoreExecutors.directExecutor;

import com.google.api.core.ApiFutureCallback;
import com.google.api.core.ApiFutures;
import com.google.api.core.InternalApi;
import com.google.api.gax.retrying.RetryingFuture;
import com.google.api.gax.retrying.ScheduledRetryingExecutor;
import com.google.api.gax.retrying.ServerStreamingAttemptException;
import com.google.api.gax.retrying.StreamResumptionStrategy;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.ResponseObserver;
import com.google.api.gax.rpc.ServerStreamingCallable;

// TODO: remove this once ApiResultRetryAlgorithm is added to gax.
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
 */
@InternalApi
public final class RetryingServerStreamingCallable<RequestT, ResponseT>
    extends ServerStreamingCallable<RequestT, ResponseT> {

  private final ServerStreamingCallable<RequestT, ResponseT> innerCallable;
  private final ScheduledRetryingExecutor<Void> executor;
  private final StreamResumptionStrategy<RequestT, ResponseT> resumptionStrategyPrototype;

  public RetryingServerStreamingCallable(
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
