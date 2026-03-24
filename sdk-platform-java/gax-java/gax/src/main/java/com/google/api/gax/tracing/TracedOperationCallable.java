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
import com.google.api.core.ApiFutures;
import com.google.api.core.InternalApi;
import com.google.api.gax.longrunning.OperationFuture;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.tracing.ApiTracerFactory.OperationType;
import com.google.common.util.concurrent.MoreExecutors;
import javax.annotation.Nonnull;

/**
 * This callable wraps a {@link OperationCallable} in a {@link ApiTracer}.
 *
 * <p>For internal use only.
 */
@InternalApi("For internal use by google-cloud-java clients only")
public class TracedOperationCallable<RequestT, ResponseT, MetadataT>
    extends OperationCallable<RequestT, ResponseT, MetadataT> {

  private @Nonnull OperationCallable<RequestT, ResponseT, MetadataT> innerCallable;
  private @Nonnull ApiTracerFactory tracerFactory;
  private @Nonnull SpanName spanName;

  public TracedOperationCallable(
      @Nonnull OperationCallable<RequestT, ResponseT, MetadataT> innerCallable,
      @Nonnull ApiTracerFactory tracerFactory,
      @Nonnull SpanName spanName) {
    this.innerCallable = innerCallable;
    this.tracerFactory = tracerFactory;
    this.spanName = spanName;
  }

  /**
   * Wrap the initial start polling logical operations in a single parent trace using a {@link
   * OperationType#LongRunning} {@link ApiTracer}.
   */
  @Override
  public OperationFuture<ResponseT, MetadataT> futureCall(
      RequestT request, ApiCallContext context) {

    ApiTracer tracer =
        tracerFactory.newTracer(context.getTracer(), spanName, OperationType.LongRunning);
    TraceFinisher<ResponseT> finisher = new TraceFinisher<>(tracer);

    try {
      context = context.withTracer(tracer);
      OperationFuture<ResponseT, MetadataT> future = innerCallable.futureCall(request, context);
      ApiFutures.addCallback(future, finisher, MoreExecutors.directExecutor());

      return future;
    } catch (RuntimeException e) {
      finisher.onFailure(e);
      throw e;
    }
  }

  /**
   * Wrap the polling logical operations in a single parent trace using a {@link
   * OperationType#LongRunning} {@link ApiTracer}.
   */
  @Override
  public OperationFuture<ResponseT, MetadataT> resumeFutureCall(
      String operationName, ApiCallContext context) {
    ApiTracer tracer =
        tracerFactory.newTracer(context.getTracer(), spanName, OperationType.LongRunning);
    TraceFinisher<ResponseT> finisher = new TraceFinisher<>(tracer);

    try {
      context = context.withTracer(tracer);
      OperationFuture<ResponseT, MetadataT> future =
          innerCallable.resumeFutureCall(operationName, context);

      ApiFutures.addCallback(future, finisher, MoreExecutors.directExecutor());
      return future;
    } catch (RuntimeException e) {
      finisher.onFailure(e);
      throw e;
    }
  }

  /** Wrap operation cancellation in a {@link OperationType#Unary} trace. */
  @Override
  public ApiFuture<Void> cancel(String operationName, ApiCallContext context) {
    SpanName cancelSpanName =
        SpanName.of(spanName.getClientName(), spanName.getMethodName() + ".Cancel");

    ApiTracer tracer =
        tracerFactory.newTracer(context.getTracer(), cancelSpanName, OperationType.Unary);
    TraceFinisher<Void> finisher = new TraceFinisher<>(tracer);

    try {
      context = context.withTracer(tracer);
      ApiFuture<Void> future = innerCallable.cancel(operationName, context);
      ApiFutures.addCallback(future, finisher, MoreExecutors.directExecutor());
      return future;
    } catch (RuntimeException e) {
      finisher.onFailure(e);
      throw e;
    }
  }
}
