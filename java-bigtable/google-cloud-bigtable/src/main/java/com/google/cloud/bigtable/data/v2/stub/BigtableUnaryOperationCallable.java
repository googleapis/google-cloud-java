/*
 * Copyright 2024 Google LLC
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
package com.google.cloud.bigtable.data.v2.stub;

import com.google.api.core.AbstractApiFuture;
import com.google.api.core.ApiFuture;
import com.google.api.gax.grpc.GrpcStatusCode;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.InternalException;
import com.google.api.gax.rpc.ResponseObserver;
import com.google.api.gax.rpc.ServerStreamingCallable;
import com.google.api.gax.rpc.StreamController;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.api.gax.tracing.ApiTracerFactory;
import com.google.api.gax.tracing.SpanName;
import com.google.cloud.bigtable.data.v2.stub.metrics.BigtableTracer;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.Futures;
import io.grpc.Status;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Helper to convert a fake {@link ServerStreamingCallable} (ie only up to 1 response) into a {@link
 * UnaryCallable}. It is intended to be the outermost callable of a chain.
 *
 * <p>Responsibilities:
 *
 * <ul>
 *   <li>Operation level metrics
 *   <li>Configuring the default call context
 *   <li>Converting the result to a future
 */
class BigtableUnaryOperationCallable<ReqT, RespT> extends UnaryCallable<ReqT, RespT> {
  private static final Logger LOGGER =
      Logger.getLogger(BigtableUnaryOperationCallable.class.getName());
  Logger logger = LOGGER;

  private final ServerStreamingCallable<ReqT, RespT> inner;
  private final ApiCallContext defaultCallContext;
  private final ApiTracerFactory tracerFactory;
  private final SpanName spanName;
  private final boolean allowNoResponse;

  public BigtableUnaryOperationCallable(
      ServerStreamingCallable<ReqT, RespT> inner,
      ApiCallContext defaultCallContext,
      ApiTracerFactory tracerFactory,
      SpanName spanName,
      boolean allowNoResponse) {
    this.inner = inner;
    this.defaultCallContext = defaultCallContext;
    this.tracerFactory = tracerFactory;
    this.spanName = spanName;
    this.allowNoResponse = allowNoResponse;
  }

  @Override
  public ApiFuture<RespT> futureCall(ReqT req, ApiCallContext apiCallContext) {
    apiCallContext = defaultCallContext.merge(apiCallContext);

    BigtableTracer apiTracer =
        (BigtableTracer)
            tracerFactory.newTracer(
                apiCallContext.getTracer(), spanName, ApiTracerFactory.OperationType.Unary);

    apiCallContext = apiCallContext.withTracer(apiTracer);

    UnaryFuture f = new UnaryFuture(apiTracer, allowNoResponse);
    inner.call(req, f, apiCallContext);
    return f;
  }

  class UnaryFuture extends AbstractApiFuture<RespT> implements ResponseObserver<RespT> {
    private final BigtableTracer tracer;
    private final boolean allowNoResponse;

    private StreamController controller;
    private final AtomicBoolean upstreamCancelled = new AtomicBoolean();

    private UnaryFuture(BigtableTracer tracer, boolean allowNoResponse) {
      this.tracer = Preconditions.checkNotNull(tracer, "tracer can't be null");
      this.allowNoResponse = allowNoResponse;
    }

    @Override
    public void onStart(StreamController controller) {
      this.controller = controller;
      controller.disableAutoInboundFlowControl();
      // Request 2 to detect protocol bugs
      controller.request(2);
    }

    /**
     * Immediately cancel the future state and try to cancel the underlying operation. Will return
     * false if the future is already resolved.
     */
    @Override
    public boolean cancel(boolean mayInterruptIfRunning) {
      if (super.cancel(mayInterruptIfRunning)) {
        cancelUpstream();
        return true;
      }
      return false;
    }

    private void cancelUpstream() {
      if (upstreamCancelled.compareAndSet(false, true)) {
        controller.cancel();
      }
    }

    @Override
    public void onResponse(RespT resp) {
      tracer.responseReceived();

      if (set(resp)) {
        tracer.operationFinishEarly();
        return;
      }

      // At this point we are guaranteed that the future has been resolved. However we need to check
      // why.
      // We know it's not because it was resolved with the current response. Moreover, since the
      // future
      // is resolved, our only means to flag the error is to log.
      // So there are 3 possibilities:
      // 1. user cancelled the future
      // 2. this is an extra response and the previous one resolved the future
      // 3. we got a response after the rpc failed (this should never happen and would be a bad bug)

      if (isCancelled()) {
        return;
      }

      try {
        RespT prev = Futures.getDone(this);
        String msg =
            String.format(
                "Received response after future is resolved for a %s unary operation. previous: %s, New response: %s",
                spanName, prev, resp);
        logger.log(Level.WARNING, msg);
      } catch (ExecutionException e) {
        // Should never happen
        String msg =
            String.format(
                "Received response after future resolved as a failure for a %s unary operation. New response: %s",
                spanName, resp);
        logger.log(Level.WARNING, msg, e.getCause());
      }

      cancelUpstream();
    }

    @Override
    public void onError(Throwable throwable) {
      if (this.setException(throwable)) {
        tracer.operationFailed(throwable);
      } else if (isCancelled()) {
        tracer.operationCancelled();
      } else {
        // At this point the has been resolved, so we ignore the error
        tracer.operationSucceeded();
      }
    }

    @Override
    public void onComplete() {
      if (allowNoResponse && set(null)) {
        tracer.operationSucceeded();
        return;

        // Under normal circumstances the future wouldve been resolved in onResponse or via
        // set(null) if it expected for
        // the rpc to not have a response. So if aren't done, the only reason is that we didn't get
        // a response
        // but were expecting one
      } else if (!isDone()) {
        String msg = spanName + " unary operation completed without a response message";
        InternalException e =
            new InternalException(msg, null, GrpcStatusCode.of(Status.Code.INTERNAL), false);

        if (setException(e)) {
          tracer.operationFailed(e);
          return;
        }
      }

      // check cancellation race
      if (isCancelled()) {
        tracer.operationCancelled();
        return;
      }

      tracer.operationSucceeded();
    }
  }
}
