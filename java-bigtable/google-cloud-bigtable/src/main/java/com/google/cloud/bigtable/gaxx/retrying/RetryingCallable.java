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

import com.google.api.core.InternalApi;
import com.google.api.gax.retrying.RetryingExecutorWithContext;
import com.google.api.gax.retrying.RetryingFuture;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.common.base.Preconditions;

// TODO: remove this once ApiResultRetryAlgorithm is added to gax.
/**
 * A UnaryCallable that will keep issuing calls to an inner callable until it succeeds or times out.
 */
@InternalApi
public class RetryingCallable<RequestT, ResponseT> extends UnaryCallable<RequestT, ResponseT> {
  private final ApiCallContext callContextPrototype;
  private final UnaryCallable<RequestT, ResponseT> callable;
  private final RetryingExecutorWithContext<ResponseT> executor;

  public RetryingCallable(
      ApiCallContext callContextPrototype,
      UnaryCallable<RequestT, ResponseT> callable,
      RetryingExecutorWithContext<ResponseT> executor) {
    this.callContextPrototype = (ApiCallContext) Preconditions.checkNotNull(callContextPrototype);
    this.callable = (UnaryCallable) Preconditions.checkNotNull(callable);
    this.executor = (RetryingExecutorWithContext) Preconditions.checkNotNull(executor);
  }

  public RetryingFuture<ResponseT> futureCall(RequestT request, ApiCallContext inputContext) {
    ApiCallContext context = this.callContextPrototype.nullToSelf(inputContext);
    AttemptCallable<RequestT, ResponseT> retryCallable =
        new AttemptCallable(this.callable, request, context);
    RetryingFuture<ResponseT> retryingFuture =
        this.executor.createFuture(retryCallable, inputContext);
    retryCallable.setExternalFuture(retryingFuture);
    retryCallable.call();
    return retryingFuture;
  }

  public String toString() {
    return String.format("retrying(%s)", this.callable);
  }
}
