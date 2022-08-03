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
import com.google.api.core.ApiFutureCallback;
import com.google.api.core.ApiFutures;
import com.google.api.core.InternalApi;
import com.google.api.gax.grpc.GrpcResponseMetadata;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.bigtable.v2.ResponseParams;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.protobuf.InvalidProtocolBufferException;
import io.grpc.Metadata;
import javax.annotation.Nonnull;

/**
 * This callable will:
 * <li>- Inject a {@link GrpcResponseMetadata} to access the headers returned by gRPC methods upon
 *     completion. The {@link BigtableTracer} will process metrics that were injected in the
 *     header/trailer and publish them to OpenCensus. If {@link GrpcResponseMetadata#getMetadata()}
 *     returned null, it probably means that the request has never reached GFE, and it'll increment
 *     the gfe_header_missing_counter in this case.
 * <li>-This class will also access trailers from {@link GrpcResponseMetadata} to record zone and
 *     cluster ids.
 * <li>This class is considered an internal implementation detail and not meant to be used by
 *     applications.
 */
@InternalApi
public class BigtableTracerUnaryCallable<RequestT, ResponseT>
    extends UnaryCallable<RequestT, ResponseT> {

  private final UnaryCallable<RequestT, ResponseT> innerCallable;

  public BigtableTracerUnaryCallable(@Nonnull UnaryCallable<RequestT, ResponseT> innerCallable) {
    this.innerCallable = Preconditions.checkNotNull(innerCallable, "Inner callable must be set");
  }

  @Override
  public ApiFuture futureCall(RequestT request, ApiCallContext context) {
    // tracer should always be an instance of BigtableTracer
    if (context.getTracer() instanceof BigtableTracer) {
      final GrpcResponseMetadata responseMetadata = new GrpcResponseMetadata();
      final ApiCallContext contextWithResponseMetadata = responseMetadata.addHandlers(context);
      BigtableTracerUnaryCallback callback =
          new BigtableTracerUnaryCallback((BigtableTracer) context.getTracer(), responseMetadata);
      ApiFuture<ResponseT> future = innerCallable.futureCall(request, contextWithResponseMetadata);
      ApiFutures.addCallback(future, callback, MoreExecutors.directExecutor());
      return future;
    } else {
      return innerCallable.futureCall(request, context);
    }
  }

  class BigtableTracerUnaryCallback<ResponseT> implements ApiFutureCallback<ResponseT> {

    private final BigtableTracer tracer;
    private final GrpcResponseMetadata responseMetadata;

    BigtableTracerUnaryCallback(BigtableTracer tracer, GrpcResponseMetadata responseMetadata) {
      this.tracer = tracer;
      this.responseMetadata = responseMetadata;
    }

    @Override
    public void onFailure(Throwable throwable) {
      Metadata metadata = responseMetadata.getMetadata();
      Long latency = Util.getGfeLatency(metadata);
      tracer.recordGfeMetadata(latency, throwable);
      try {
        // Check both headers and trailers because in different environments the metadata
        // could be returned in headers or trailers
        if (metadata != null) {
          byte[] trailers = metadata.get(Util.METADATA_KEY);
          if (trailers == null) {
            Metadata trailingMetadata = responseMetadata.getTrailingMetadata();
            if (trailingMetadata != null) {
              trailers = trailingMetadata.get(Util.METADATA_KEY);
            }
          }
          // If the response is terminated abnormally and we didn't get location information in
          // trailers or headers, skip setting the locations
          if (trailers != null) {
            ResponseParams decodedTrailers = ResponseParams.parseFrom(trailers);
            tracer.setLocations(decodedTrailers.getZoneId(), decodedTrailers.getClusterId());
          }
        }
      } catch (InvalidProtocolBufferException e) {
      }
    }

    @Override
    public void onSuccess(ResponseT response) {
      Metadata metadata = responseMetadata.getMetadata();
      Long latency = Util.getGfeLatency(metadata);
      tracer.recordGfeMetadata(latency, null);
      try {
        // Check both headers and trailers because in different environments the metadata
        // could be returned in headers or trailers
        if (metadata != null) {
          byte[] trailers = metadata.get(Util.METADATA_KEY);
          if (trailers == null) {
            Metadata trailingMetadata = responseMetadata.getTrailingMetadata();
            if (trailingMetadata != null) {
              trailers = trailingMetadata.get(Util.METADATA_KEY);
            }
          }
          // If the response is terminated abnormally and we didn't get location information in
          // trailers or headers, skip setting the locations
          if (trailers != null) {
            ResponseParams decodedTrailers = ResponseParams.parseFrom(trailers);
            tracer.setLocations(decodedTrailers.getZoneId(), decodedTrailers.getClusterId());
          }
        }
      } catch (InvalidProtocolBufferException e) {
      }
    }
  }
}
