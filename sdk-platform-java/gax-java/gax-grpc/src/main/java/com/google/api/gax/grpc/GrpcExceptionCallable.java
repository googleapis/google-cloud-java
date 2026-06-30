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
package com.google.api.gax.grpc;

import static com.google.common.util.concurrent.MoreExecutors.directExecutor;

import com.google.api.core.AbstractApiFuture;
import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutureCallback;
import com.google.api.core.ApiFutures;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.common.base.Preconditions;
import java.util.Set;
import java.util.concurrent.CancellationException;

/**
 * Transforms all {@code Throwable}s thrown during a call into an instance of {@link ApiException}.
 *
 * <p>Package-private for internal use.
 */
class GrpcExceptionCallable<RequestT, ResponseT> extends UnaryCallable<RequestT, ResponseT> {
  private final UnaryCallable<RequestT, ResponseT> callable;
  private final GrpcApiExceptionFactory exceptionFactory;

  GrpcExceptionCallable(
      UnaryCallable<RequestT, ResponseT> callable, Set<StatusCode.Code> retryableCodes) {
    this.callable = Preconditions.checkNotNull(callable);
    this.exceptionFactory = new GrpcApiExceptionFactory(retryableCodes);
  }

  @Override
  public ApiFuture<ResponseT> futureCall(RequestT request, ApiCallContext inputContext) {
    GrpcCallContext context = GrpcCallContext.createDefault().nullToSelf(inputContext);
    ApiFuture<ResponseT> innerCallFuture = callable.futureCall(request, context);
    ExceptionTransformingFuture transformingFuture =
        new ExceptionTransformingFuture(innerCallFuture);
    ApiFutures.addCallback(innerCallFuture, transformingFuture, directExecutor());
    return transformingFuture;
  }

  private class ExceptionTransformingFuture extends AbstractApiFuture<ResponseT>
      implements ApiFutureCallback<ResponseT> {
    private ApiFuture<ResponseT> innerCallFuture;
    private volatile boolean cancelled = false;

    public ExceptionTransformingFuture(ApiFuture<ResponseT> innerCallFuture) {
      this.innerCallFuture = innerCallFuture;
    }

    @Override
    protected void interruptTask() {
      cancelled = true;
      innerCallFuture.cancel(true);
    }

    @Override
    public void onSuccess(ResponseT r) {
      super.set(r);
    }

    @Override
    public void onFailure(Throwable throwable) {
      if (throwable instanceof CancellationException && cancelled) {
        // this just circled around, so ignore.
        return;
      } else {
        setException(exceptionFactory.create(throwable));
      }
    }
  }
}
