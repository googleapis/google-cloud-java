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
import com.google.api.gax.rpc.BidiStreamingCallable;
import com.google.api.gax.rpc.ClientStream;
import com.google.api.gax.rpc.ClientStreamReadyObserver;
import com.google.api.gax.rpc.ResponseObserver;
import com.google.api.gax.tracing.ApiTracerFactory.OperationType;
import com.google.common.base.Preconditions;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.Nonnull;

/**
 * A wrapper callable that will wrap a callable chain in a trace.
 *
 * <p>For internal use only.
 */
@BetaApi("The surface for tracing is not stable and might change in the future")
@InternalApi("For internal use by google-cloud-java clients only")
public class TracedBidiCallable<RequestT, ResponseT>
    extends BidiStreamingCallable<RequestT, ResponseT> {

  @Nonnull private final ApiTracerFactory tracerFactory;
  @Nonnull private final SpanName spanName;
  @Nonnull private final BidiStreamingCallable<RequestT, ResponseT> innerCallable;

  public TracedBidiCallable(
      @Nonnull BidiStreamingCallable<RequestT, ResponseT> innerCallable,
      @Nonnull ApiTracerFactory tracerFactory,
      @Nonnull SpanName spanName) {
    this.tracerFactory = Preconditions.checkNotNull(tracerFactory, "tracerFactory can't be null");
    this.spanName = Preconditions.checkNotNull(spanName, "spanName can't be null");
    this.innerCallable = Preconditions.checkNotNull(innerCallable, "innerCallable can't be null");
  }

  @Override
  public ClientStream<RequestT> internalCall(
      ResponseObserver<ResponseT> responseObserver,
      ClientStreamReadyObserver<RequestT> onReady,
      ApiCallContext context) {

    ApiTracer tracer =
        tracerFactory.newTracer(context.getTracer(), spanName, OperationType.BidiStreaming);
    context = context.withTracer(tracer);

    AtomicBoolean wasCancelled = new AtomicBoolean();

    ResponseObserver<ResponseT> tracedObserver =
        new TracedResponseObserver<>(tracer, responseObserver, wasCancelled);
    ClientStreamReadyObserver<RequestT> tracedReadyObserver =
        new TracedClientStreamReadyObserver<>(tracer, onReady, wasCancelled);

    try {
      ClientStream<RequestT> clientStream =
          innerCallable.internalCall(tracedObserver, tracedReadyObserver, context);
      return new TracingClientStream<>(tracer, clientStream, wasCancelled);
    } catch (RuntimeException e) {
      tracer.operationFailed(e);
      throw e;
    }
  }

  private static class TracedClientStreamReadyObserver<RequestT>
      implements ClientStreamReadyObserver<RequestT> {
    private final ApiTracer tracer;
    private final ClientStreamReadyObserver<RequestT> innerObserver;
    private final AtomicBoolean wasCancelled;

    TracedClientStreamReadyObserver(
        ApiTracer tracer,
        ClientStreamReadyObserver<RequestT> innerObserver,
        AtomicBoolean wasCancelled) {
      this.tracer = tracer;
      this.innerObserver = innerObserver;
      this.wasCancelled = wasCancelled;
    }

    @Override
    public void onReady(ClientStream<RequestT> stream) {
      innerObserver.onReady(new TracingClientStream<>(tracer, stream, wasCancelled));
    }
  }

  /** {@link ClientStream} wrapper that annotates traces with sent messages. */
  private static class TracingClientStream<RequestT> implements ClientStream<RequestT> {
    private final ApiTracer tracer;
    private final ClientStream<RequestT> innerStream;
    private final AtomicBoolean wasCancelled;

    private TracingClientStream(
        ApiTracer tracer, ClientStream<RequestT> innerStream, AtomicBoolean wasCancelled) {
      this.tracer = tracer;
      this.innerStream = innerStream;
      this.wasCancelled = wasCancelled;
    }

    @Override
    public void send(RequestT request) {
      tracer.requestSent();
      innerStream.send(request);
    }

    @Override
    public void closeSendWithError(Throwable t) {
      if (t == null) {
        t = new CancellationException();
      }
      wasCancelled.set(true);
      innerStream.closeSendWithError(t);
    }

    @Override
    public void closeSend() {
      innerStream.closeSend();
    }

    @Override
    public boolean isSendReady() {
      return innerStream.isSendReady();
    }
  }
}
