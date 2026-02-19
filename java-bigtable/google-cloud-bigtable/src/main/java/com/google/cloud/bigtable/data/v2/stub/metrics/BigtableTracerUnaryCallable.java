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

import com.google.api.core.ApiFuture;
import com.google.api.core.InternalApi;
import com.google.api.gax.grpc.GrpcCallContext;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.bigtable.data.v2.stub.MetadataExtractorInterceptor;
import com.google.common.base.Preconditions;
import javax.annotation.Nonnull;

/**
 * This class is considered an internal implementation detail and not meant to be used by
 * applications.
 */
@InternalApi
public class BigtableTracerUnaryCallable<RequestT, ResponseT>
    extends UnaryCallable<RequestT, ResponseT> {

  private final UnaryCallable<RequestT, ResponseT> innerCallable;

  public BigtableTracerUnaryCallable(@Nonnull UnaryCallable<RequestT, ResponseT> innerCallable) {
    this.innerCallable = Preconditions.checkNotNull(innerCallable, "Inner callable must be set");
  }

  @Override
  public ApiFuture<ResponseT> futureCall(RequestT request, ApiCallContext context) {
    MetadataExtractorInterceptor interceptor = new MetadataExtractorInterceptor();
    GrpcCallContext grpcCtx = interceptor.injectInto((GrpcCallContext) context);

    // tracer should always be an instance of BigtableTracer
    if (context.getTracer() instanceof BigtableTracer) {
      BigtableTracer tracer = (BigtableTracer) context.getTracer();
      tracer.setSidebandData(interceptor.getSidebandData());

      grpcCtx =
          grpcCtx.withCallOptions(
              grpcCtx
                  .getCallOptions()
                  .withStreamTracerFactory(new BigtableGrpcStreamTracer.Factory(tracer)));

      if (context.getRetrySettings() != null) {
        tracer.setTotalTimeoutDuration(context.getRetrySettings().getTotalTimeoutDuration());
      }
    }
    return innerCallable.futureCall(request, grpcCtx);
  }
}
