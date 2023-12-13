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

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.InternalApi;
import com.google.api.gax.retrying.NonCancellableFuture;
import com.google.api.gax.retrying.RetryingFuture;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.common.base.Preconditions;
import java.util.concurrent.Callable;
import org.threeten.bp.Duration;

// TODO: remove this once ApiResultRetryAlgorithm is added to gax.
/**
 * A callable representing an attempt to make an RPC call. This class is used from {@link
 * RetryingCallable}.
 *
 * @param <RequestT> request type
 * @param <ResponseT> response type
 */
@InternalApi
public class AttemptCallable<RequestT, ResponseT> implements Callable<ResponseT> {
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
      Duration rpcTimeout = externalFuture.getAttemptSettings().getRpcTimeout();
      if (!rpcTimeout.isZero() && callContext.getTimeout() == null) {
        callContext = callContext.withTimeout(rpcTimeout);
      }

      externalFuture.setAttemptFuture(new NonCancellableFuture<ResponseT>());
      if (externalFuture.isDone()) {
        return null;
      }

      callContext
          .getTracer()
          .attemptStarted(request, externalFuture.getAttemptSettings().getOverallAttemptCount());

      ApiFuture<ResponseT> internalFuture = callable.futureCall(request, callContext);
      externalFuture.setAttemptFuture(internalFuture);
    } catch (Throwable e) {
      externalFuture.setAttemptFuture(ApiFutures.<ResponseT>immediateFailedFuture(e));
    }

    return null;
  }
}
