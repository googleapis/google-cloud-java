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
package com.google.cloud.bigtable.data.v2.stub.metrics;

import com.google.api.core.InternalApi;
import com.google.api.gax.grpc.GrpcCallContext;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.ResponseObserver;
import com.google.api.gax.rpc.ServerStreamingCallable;
import com.google.api.gax.rpc.StreamController;
import com.google.cloud.bigtable.data.v2.stub.MetadataExtractorInterceptor;
import com.google.cloud.bigtable.data.v2.stub.SafeResponseObserver;
import com.google.common.base.Preconditions;
import com.google.common.base.Stopwatch;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nonnull;

/**
 * This class is considered an internal implementation detail and not meant to be used by
 * applications.
 */
@InternalApi
public class BigtableTracerStreamingCallable<RequestT, ResponseT>
    extends ServerStreamingCallable<RequestT, ResponseT> {

  private final ServerStreamingCallable<RequestT, ResponseT> innerCallable;

  public BigtableTracerStreamingCallable(
      @Nonnull ServerStreamingCallable<RequestT, ResponseT> callable) {
    this.innerCallable = Preconditions.checkNotNull(callable, "Inner callable must be set");
  }

  @Override
  public void call(
      RequestT request, ResponseObserver<ResponseT> responseObserver, ApiCallContext context) {
    GrpcCallContext grpcCtx = (GrpcCallContext) context;

    MetadataExtractorInterceptor metadataExtractor = new MetadataExtractorInterceptor();
    grpcCtx = metadataExtractor.injectInto(grpcCtx);

    // tracer should always be an instance of bigtable tracer
    if (context.getTracer() instanceof BigtableTracer) {
      BigtableTracer tracer = (BigtableTracer) context.getTracer();
      tracer.setSidebandData(metadataExtractor.getSidebandData());
      grpcCtx =
          grpcCtx.withCallOptions(
              grpcCtx
                  .getCallOptions()
                  .withStreamTracerFactory(new BigtableGrpcStreamTracer.Factory(tracer)));

      BigtableTracerResponseObserver<ResponseT> innerObserver =
          new BigtableTracerResponseObserver<>(responseObserver, tracer);
      if (context.getRetrySettings() != null) {
        tracer.setTotalTimeoutDuration(context.getRetrySettings().getTotalTimeoutDuration());
      }
      innerCallable.call(request, innerObserver, grpcCtx);
    } else {
      innerCallable.call(request, responseObserver, grpcCtx);
    }
  }

  private class BigtableTracerResponseObserver<ResponseT> extends SafeResponseObserver<ResponseT> {
    private final BigtableTracer tracer;
    private final ResponseObserver<ResponseT> outerObserver;

    BigtableTracerResponseObserver(ResponseObserver<ResponseT> observer, BigtableTracer tracer) {
      super(observer);

      this.tracer = tracer;
      this.outerObserver = observer;
    }

    @Override
    protected void onStartImpl(final StreamController controller) {
      TracedStreamController tracedController = new TracedStreamController(controller, tracer);
      outerObserver.onStart(tracedController);
    }

    @Override
    protected void onResponseImpl(ResponseT response) {
      Stopwatch stopwatch = Stopwatch.createStarted();
      outerObserver.onResponse(response);
      tracer.afterResponse(stopwatch.elapsed(TimeUnit.MILLISECONDS));
    }

    @Override
    protected void onErrorImpl(Throwable t) {
      outerObserver.onError(t);
    }

    @Override
    protected void onCompleteImpl() {
      outerObserver.onComplete();
    }
  }

  private class TracedStreamController implements StreamController {
    private final StreamController innerController;
    private final BigtableTracer tracer;

    TracedStreamController(StreamController innerController, BigtableTracer tracer) {
      this.innerController = innerController;
      this.tracer = tracer;
    }

    @Override
    public void cancel() {
      innerController.cancel();
    }

    @Override
    public void disableAutoInboundFlowControl() {
      tracer.disableFlowControl();
      innerController.disableAutoInboundFlowControl();
    }

    @Override
    public void request(int i) {
      tracer.onRequest(i);
      innerController.request(i);
    }
  }
}
