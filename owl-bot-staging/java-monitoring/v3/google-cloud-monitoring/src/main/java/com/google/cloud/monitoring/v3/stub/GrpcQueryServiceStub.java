/*
 * Copyright 2022 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.monitoring.v3.stub;

import static com.google.cloud.monitoring.v3.QueryServiceClient.QueryTimeSeriesPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.common.collect.ImmutableMap;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.monitoring.v3.QueryTimeSeriesRequest;
import com.google.monitoring.v3.QueryTimeSeriesResponse;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the QueryService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcQueryServiceStub extends QueryServiceStub {
  private static final MethodDescriptor<QueryTimeSeriesRequest, QueryTimeSeriesResponse>
      queryTimeSeriesMethodDescriptor =
          MethodDescriptor.<QueryTimeSeriesRequest, QueryTimeSeriesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.monitoring.v3.QueryService/QueryTimeSeries")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(QueryTimeSeriesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(QueryTimeSeriesResponse.getDefaultInstance()))
              .build();

  private final UnaryCallable<QueryTimeSeriesRequest, QueryTimeSeriesResponse>
      queryTimeSeriesCallable;
  private final UnaryCallable<QueryTimeSeriesRequest, QueryTimeSeriesPagedResponse>
      queryTimeSeriesPagedCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcQueryServiceStub create(QueryServiceStubSettings settings)
      throws IOException {
    return new GrpcQueryServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcQueryServiceStub create(ClientContext clientContext) throws IOException {
    return new GrpcQueryServiceStub(QueryServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcQueryServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcQueryServiceStub(
        QueryServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcQueryServiceStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcQueryServiceStub(QueryServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcQueryServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcQueryServiceStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcQueryServiceStub(
      QueryServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<QueryTimeSeriesRequest, QueryTimeSeriesResponse>
        queryTimeSeriesTransportSettings =
            GrpcCallSettings.<QueryTimeSeriesRequest, QueryTimeSeriesResponse>newBuilder()
                .setMethodDescriptor(queryTimeSeriesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
                    })
                .build();

    this.queryTimeSeriesCallable =
        callableFactory.createUnaryCallable(
            queryTimeSeriesTransportSettings, settings.queryTimeSeriesSettings(), clientContext);
    this.queryTimeSeriesPagedCallable =
        callableFactory.createPagedCallable(
            queryTimeSeriesTransportSettings, settings.queryTimeSeriesSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<QueryTimeSeriesRequest, QueryTimeSeriesResponse> queryTimeSeriesCallable() {
    return queryTimeSeriesCallable;
  }

  @Override
  public UnaryCallable<QueryTimeSeriesRequest, QueryTimeSeriesPagedResponse>
      queryTimeSeriesPagedCallable() {
    return queryTimeSeriesPagedCallable;
  }

  @Override
  public final void close() {
    try {
      backgroundResources.close();
    } catch (RuntimeException e) {
      throw e;
    } catch (Exception e) {
      throw new IllegalStateException("Failed to close resource", e);
    }
  }

  @Override
  public void shutdown() {
    backgroundResources.shutdown();
  }

  @Override
  public boolean isShutdown() {
    return backgroundResources.isShutdown();
  }

  @Override
  public boolean isTerminated() {
    return backgroundResources.isTerminated();
  }

  @Override
  public void shutdownNow() {
    backgroundResources.shutdownNow();
  }

  @Override
  public boolean awaitTermination(long duration, TimeUnit unit) throws InterruptedException {
    return backgroundResources.awaitTermination(duration, unit);
  }
}
