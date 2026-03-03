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

import com.google.api.core.BetaApi;
import com.google.api.core.InternalApi;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.ApiStreamObserver;
import com.google.api.gax.rpc.ClientStreamingCallable;
import com.google.api.gax.tracing.ApiTracerFactory.OperationType;
import com.google.common.base.Preconditions;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.Nonnull;

/**
 * A wrapper callable that will wrap a callable chain in a trace.
 *
 * <p>This can be safely called from multiple threads. However the request {@link ApiStreamObserver}
 * can only be used from a single thread.
 *
 * <p>For internal use only.
 */
@BetaApi("The surface for tracing is not stable and might change in the future")
@InternalApi
public class TracedClientStreamingCallable<RequestT, ResponseT>
    extends ClientStreamingCallable<RequestT, ResponseT> {
  private final ClientStreamingCallable<RequestT, ResponseT> innerCallable;
  private final ApiTracerFactory tracerFactory;
  private final SpanName spanName;

  public TracedClientStreamingCallable(
      @Nonnull ClientStreamingCallable<RequestT, ResponseT> innerCallable,
      @Nonnull ApiTracerFactory tracerFactory,
      @Nonnull SpanName spanName) {
    this.tracerFactory = Preconditions.checkNotNull(tracerFactory, "tracerFactory can't be null");
    this.spanName = Preconditions.checkNotNull(spanName, "spanName can't be null");
    this.innerCallable = Preconditions.checkNotNull(innerCallable, "innerCallable can't be null");
  }

  @Override
  public ApiStreamObserver<RequestT> clientStreamingCall(
      ApiStreamObserver<ResponseT> responseObserver, ApiCallContext context) {

    ApiTracer tracer =
        tracerFactory.newTracer(context.getTracer(), spanName, OperationType.ClientStreaming);
    context = context.withTracer(tracer);

    // Shared state that allows the response observer to know that the error it received was
    // triggered by a caller initiated cancellation.
    AtomicReference<Throwable> cancellationCauseHolder = new AtomicReference<>(null);

    try {
      ApiStreamObserver<ResponseT> innerResponseObserver =
          new TracedResponseObserver<>(tracer, responseObserver, cancellationCauseHolder);

      ApiStreamObserver<RequestT> innerRequestObserver =
          innerCallable.clientStreamingCall(innerResponseObserver, context);

      return new TracedRequestObserver<>(tracer, innerRequestObserver, cancellationCauseHolder);
    } catch (RuntimeException e) {
      tracer.operationFailed(e);
      throw e;
    }
  }

  /** {@link ApiStreamObserver} wrapper to annotate the current trace with sent message. */
  private static class TracedRequestObserver<RequestT> implements ApiStreamObserver<RequestT> {
    private final ApiTracer tracer;
    private final ApiStreamObserver<RequestT> innerObserver;
    private final AtomicReference<Throwable> cancellationCauseHolder;

    TracedRequestObserver(
        @Nonnull ApiTracer tracer,
        @Nonnull ApiStreamObserver<RequestT> innerObserver,
        @Nonnull AtomicReference<Throwable> cancellationCauseHolder) {
      this.tracer = Preconditions.checkNotNull(tracer, "tracer can't be null");
      this.innerObserver = Preconditions.checkNotNull(innerObserver, "innerObserver can't be null");
      this.cancellationCauseHolder =
          Preconditions.checkNotNull(
              cancellationCauseHolder, "cancellationCauseHolder can't be null");
    }

    @Override
    public void onNext(RequestT value) {
      tracer.requestSent();
      innerObserver.onNext(value);
    }

    @Override
    public void onError(Throwable throwable) {
      if (throwable == null) {
        throwable = new CancellationException("Cancelled without a cause");
      }
      // NOTE: Calling onError will eventually cancel the entire stream. So we just set a flag now
      // and trace later in the TracedResponseObserver.
      cancellationCauseHolder.compareAndSet(null, throwable);
      innerObserver.onError(throwable);
    }

    @Override
    public void onCompleted() {
      // TODO(igorbernstein2): consider tracing request stream completion.
      innerObserver.onCompleted();
    }
  }

  /**
   * {@link ApiStreamObserver} wrapper to annotate the current trace with received messages and to
   * close the current trace upon completion of the RPC.
   */
  private static class TracedResponseObserver<RequestT> implements ApiStreamObserver<RequestT> {
    @Nonnull private final ApiTracer tracer;
    @Nonnull private final ApiStreamObserver<RequestT> innerObserver;
    @Nonnull private final AtomicReference<Throwable> cancellationCauseHolder;

    TracedResponseObserver(
        @Nonnull ApiTracer tracer,
        @Nonnull ApiStreamObserver<RequestT> innerObserver,
        @Nonnull AtomicReference<Throwable> cancellationCauseHolder) {
      this.tracer = Preconditions.checkNotNull(tracer, "tracer can't be null");
      this.innerObserver = Preconditions.checkNotNull(innerObserver, "innerObserver can't be null");
      this.cancellationCauseHolder = cancellationCauseHolder;
    }

    @Override
    public void onNext(RequestT value) {
      tracer.responseReceived();
      innerObserver.onNext(value);
    }

    @Override
    public void onError(Throwable t) {
      Throwable cancellationCause = cancellationCauseHolder.get();
      if (cancellationCause != null) {
        tracer.operationCancelled();
      } else {
        tracer.operationFailed(t);
      }
      innerObserver.onError(t);
    }

    @Override
    public void onCompleted() {
      tracer.operationSucceeded();
      innerObserver.onCompleted();
    }
  }
}
