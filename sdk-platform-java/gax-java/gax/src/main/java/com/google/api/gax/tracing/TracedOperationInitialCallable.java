/*
 * Copyright 2019 Google LLC
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
package com.google.api.gax.tracing;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutureCallback;
import com.google.api.core.ApiFutures;
import com.google.api.gax.longrunning.OperationSnapshot;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.common.util.concurrent.MoreExecutors;

/**
 * Traces the initial RPC of a long running operation.
 *
 * <p>It will trace it like a child unary RPC and will also contribute to the parent tracer (created
 * by {@link TracedOperationCallable}) the result of the call.
 */
public class TracedOperationInitialCallable<RequestT>
    extends TracedUnaryCallable<RequestT, OperationSnapshot> {

  public TracedOperationInitialCallable(
      UnaryCallable<RequestT, OperationSnapshot> innerCallable,
      ApiTracerFactory tracedFactory,
      SpanName spanName) {
    super(innerCallable, tracedFactory, spanName);
  }

  @Override
  public ApiFuture<OperationSnapshot> futureCall(RequestT request, ApiCallContext context) {
    InitialCallableFinisher finisher = new InitialCallableFinisher(context.getTracer());

    try {
      ApiFuture<OperationSnapshot> future = super.futureCall(request, context);
      ApiFutures.addCallback(future, finisher, MoreExecutors.directExecutor());

      return future;
    } catch (RuntimeException e) {
      finisher.onFailure(e);
      throw e;
    }
  }

  private static class InitialCallableFinisher implements ApiFutureCallback<OperationSnapshot> {
    private final ApiTracer operationTracer;

    private InitialCallableFinisher(ApiTracer operationTracer) {
      this.operationTracer = operationTracer;
    }

    @Override
    public void onSuccess(OperationSnapshot result) {
      operationTracer.lroStartSucceeded();
    }

    @Override
    public void onFailure(Throwable t) {
      operationTracer.lroStartFailed(t);
    }
  }
}
