/*
 * Copyright 2016 Google LLC
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

import com.google.api.gax.retrying.RetryingExecutorWithContext;
import com.google.api.gax.retrying.RetryingFuture;
import com.google.common.base.Preconditions;

/**
 * A UnaryCallable that will keep issuing calls to an inner callable until it succeeds or times out.
 *
 * <p>Package-private for internal use.
 */
class RetryingCallable<RequestT, ResponseT> extends UnaryCallable<RequestT, ResponseT> {
  private final ApiCallContext callContextPrototype;
  private final UnaryCallable<RequestT, ResponseT> callable;
  private final RetryingExecutorWithContext<ResponseT> executor;

  private final RequestMutator<RequestT> requestMutator;

  RetryingCallable(
      ApiCallContext callContextPrototype,
      UnaryCallable<RequestT, ResponseT> callable,
      RetryingExecutorWithContext<ResponseT> executor) {
    this(callContextPrototype, callable, executor, null);
  }

  RetryingCallable(
      ApiCallContext callContextPrototype,
      UnaryCallable<RequestT, ResponseT> callable,
      RetryingExecutorWithContext<ResponseT> executor,
      RequestMutator<RequestT> requestMutator) {
    this.callContextPrototype = Preconditions.checkNotNull(callContextPrototype);
    this.callable = Preconditions.checkNotNull(callable);
    this.executor = Preconditions.checkNotNull(executor);
    this.requestMutator = requestMutator;
  }

  @Override
  public RetryingFuture<ResponseT> futureCall(RequestT request, ApiCallContext inputContext) {
    ApiCallContext context = callContextPrototype.nullToSelf(inputContext);
    RequestT modifiedRequest = request;
    if (this.requestMutator != null) {
      modifiedRequest = requestMutator.apply(request);
    }
    AttemptCallable<RequestT, ResponseT> retryCallable =
        new AttemptCallable<>(callable, modifiedRequest, context);

    RetryingFuture<ResponseT> retryingFuture = executor.createFuture(retryCallable, inputContext);
    retryCallable.setExternalFuture(retryingFuture);
    retryCallable.call();

    return retryingFuture;
  }

  @Override
  public String toString() {
    return String.format("retrying(%s)", callable);
  }
}
