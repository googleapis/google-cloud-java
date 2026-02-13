/*
 * Copyright 2020 Google LLC
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

package com.google.cloud.bigquery.storage.v1beta2.stub.readrows;

import static com.google.common.util.concurrent.MoreExecutors.directExecutor;

import com.google.api.core.ApiFutureCallback;
import com.google.api.core.ApiFutures;
import com.google.api.gax.retrying.RetryingFuture;
import com.google.api.gax.retrying.ScheduledRetryingExecutor;
import com.google.api.gax.retrying.ServerStreamingAttemptException;
import com.google.api.gax.retrying.StreamResumptionStrategy;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.ResponseObserver;
import com.google.api.gax.rpc.ServerStreamingCallable;
import com.google.cloud.bigquery.storage.v1beta2.ReadRowsRequest;
import com.google.cloud.bigquery.storage.v1beta2.ReadRowsResponse;

public final class ReadRowsRetryingCallable
    extends ServerStreamingCallable<ReadRowsRequest, ReadRowsResponse> {

  private final ApiCallContext context;
  private final ServerStreamingCallable<ReadRowsRequest, ReadRowsResponse> innerCallable;
  private final ScheduledRetryingExecutor<Void> executor;
  private final StreamResumptionStrategy<ReadRowsRequest, ReadRowsResponse>
      resumptionStrategyPrototype;

  public ReadRowsRetryingCallable(
      ApiCallContext context,
      ServerStreamingCallable<ReadRowsRequest, ReadRowsResponse> innerCallable,
      ScheduledRetryingExecutor<Void> executor,
      StreamResumptionStrategy<ReadRowsRequest, ReadRowsResponse> resumptionStrategyPrototype) {
    this.context = context;
    this.innerCallable = innerCallable;
    this.executor = executor;
    this.resumptionStrategyPrototype = resumptionStrategyPrototype;
  }

  @Override
  public void call(
      ReadRowsRequest request,
      final ResponseObserver<ReadRowsResponse> responseObserver,
      ApiCallContext context) {
    ApiCallContext actualContext = this.context.merge(context);
    ReadRowsAttemptCallable attemptCallable =
        new ReadRowsAttemptCallable(
            innerCallable,
            resumptionStrategyPrototype.createNew(),
            request,
            actualContext,
            responseObserver);

    RetryingFuture<Void> retryingFuture = executor.createFuture(attemptCallable, actualContext);
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
