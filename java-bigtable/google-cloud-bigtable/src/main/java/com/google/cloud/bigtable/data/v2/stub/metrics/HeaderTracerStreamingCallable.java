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
import com.google.api.gax.grpc.GrpcResponseMetadata;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.ResponseObserver;
import com.google.api.gax.rpc.ServerStreamingCallable;
import com.google.api.gax.rpc.StreamController;
import com.google.common.base.Preconditions;
import io.grpc.Metadata;
import javax.annotation.Nonnull;

/**
 * This callable will inject a {@link GrpcResponseMetadata} to access the headers and trailers
 * returned by gRPC methods upon completion. The {@link HeaderTracer} will process metrics that were
 * injected in the header/trailer and publish them to OpenCensus. If {@link
 * GrpcResponseMetadata#getMetadata()} returned null, it probably means that the request has never
 * reached GFE, and it'll increment the gfe_header_missing_counter in this case.
 *
 * <p>If GFE metrics are not registered in {@link RpcViews}, skip injecting GrpcResponseMetadata.
 * This is for the case where direct path is enabled, all the requests won't go through GFE and
 * therefore won't have the server-timing header.
 *
 * <p>This class is considered an internal implementation detail and not meant to be used by
 * applications.
 */
@InternalApi
public class HeaderTracerStreamingCallable<RequestT, ResponseT>
    extends ServerStreamingCallable<RequestT, ResponseT> {

  private final ServerStreamingCallable<RequestT, ResponseT> innerCallable;
  private final HeaderTracer headerTracer;
  private final String spanName;

  public HeaderTracerStreamingCallable(
      @Nonnull ServerStreamingCallable<RequestT, ResponseT> callable,
      @Nonnull HeaderTracer headerTracer,
      @Nonnull String spanName) {
    this.innerCallable = Preconditions.checkNotNull(callable, "Inner callable must be set");
    this.headerTracer = Preconditions.checkNotNull(headerTracer, "HeaderTracer must be set");
    this.spanName = Preconditions.checkNotNull(spanName, "Span name must be set");
  }

  @Override
  public void call(
      RequestT request, ResponseObserver<ResponseT> responseObserver, ApiCallContext context) {
    final GrpcResponseMetadata responseMetadata = new GrpcResponseMetadata();
    if (RpcViews.isGfeMetricsRegistered()) {
      HeaderTracerResponseObserver<ResponseT> innerObserver =
          new HeaderTracerResponseObserver<>(
              responseObserver, headerTracer, responseMetadata, spanName);
      innerCallable.call(request, innerObserver, responseMetadata.addHandlers(context));
    } else {
      innerCallable.call(request, responseObserver, context);
    }
  }

  private class HeaderTracerResponseObserver<ResponseT> implements ResponseObserver<ResponseT> {

    private ResponseObserver<ResponseT> outerObserver;
    private HeaderTracer headerTracer;
    private GrpcResponseMetadata responseMetadata;
    private String spanName;

    HeaderTracerResponseObserver(
        ResponseObserver<ResponseT> observer,
        HeaderTracer headerTracer,
        GrpcResponseMetadata metadata,
        String spanName) {
      this.outerObserver = observer;
      this.headerTracer = headerTracer;
      this.responseMetadata = metadata;
      this.spanName = spanName;
    }

    @Override
    public void onStart(final StreamController controller) {
      outerObserver.onStart(controller);
    }

    @Override
    public void onResponse(ResponseT response) {
      outerObserver.onResponse(response);
    }

    @Override
    public void onError(Throwable t) {
      // server-timing metric will be added through GrpcResponseMetadata#onHeaders(Metadata),
      // so it's not checking trailing metadata here.
      Metadata metadata = responseMetadata.getMetadata();
      if (metadata != null) {
        headerTracer.recordGfeMetadata(metadata, spanName);
      } else {
        headerTracer.recordGfeMissingHeader(spanName);
      }
      outerObserver.onError(t);
    }

    @Override
    public void onComplete() {
      Metadata metadata = responseMetadata.getMetadata();
      if (metadata != null) {
        headerTracer.recordGfeMetadata(metadata, spanName);
      } else {
        headerTracer.recordGfeMissingHeader(spanName);
      }
      outerObserver.onComplete();
    }
  }
}
