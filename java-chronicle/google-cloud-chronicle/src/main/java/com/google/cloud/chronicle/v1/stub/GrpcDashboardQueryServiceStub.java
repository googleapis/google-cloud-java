/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.chronicle.v1.stub;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.chronicle.v1.DashboardQuery;
import com.google.cloud.chronicle.v1.ExecuteDashboardQueryRequest;
import com.google.cloud.chronicle.v1.ExecuteDashboardQueryResponse;
import com.google.cloud.chronicle.v1.GetDashboardQueryRequest;
import com.google.longrunning.stub.GrpcOperationsStub;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the DashboardQueryService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@NullMarked
@Generated("by gapic-generator-java")
public class GrpcDashboardQueryServiceStub extends DashboardQueryServiceStub {
  private static final MethodDescriptor<GetDashboardQueryRequest, DashboardQuery>
      getDashboardQueryMethodDescriptor =
          MethodDescriptor.<GetDashboardQueryRequest, DashboardQuery>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.chronicle.v1.DashboardQueryService/GetDashboardQuery")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetDashboardQueryRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(DashboardQuery.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ExecuteDashboardQueryRequest, ExecuteDashboardQueryResponse>
      executeDashboardQueryMethodDescriptor =
          MethodDescriptor.<ExecuteDashboardQueryRequest, ExecuteDashboardQueryResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.chronicle.v1.DashboardQueryService/ExecuteDashboardQuery")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ExecuteDashboardQueryRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ExecuteDashboardQueryResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private final UnaryCallable<GetDashboardQueryRequest, DashboardQuery> getDashboardQueryCallable;
  private final UnaryCallable<ExecuteDashboardQueryRequest, ExecuteDashboardQueryResponse>
      executeDashboardQueryCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcDashboardQueryServiceStub create(
      DashboardQueryServiceStubSettings settings) throws IOException {
    return new GrpcDashboardQueryServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcDashboardQueryServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcDashboardQueryServiceStub(
        DashboardQueryServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcDashboardQueryServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcDashboardQueryServiceStub(
        DashboardQueryServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcDashboardQueryServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcDashboardQueryServiceStub(
      DashboardQueryServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcDashboardQueryServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcDashboardQueryServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcDashboardQueryServiceStub(
      DashboardQueryServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<GetDashboardQueryRequest, DashboardQuery> getDashboardQueryTransportSettings =
        GrpcCallSettings.<GetDashboardQueryRequest, DashboardQuery>newBuilder()
            .setMethodDescriptor(getDashboardQueryMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    GrpcCallSettings<ExecuteDashboardQueryRequest, ExecuteDashboardQueryResponse>
        executeDashboardQueryTransportSettings =
            GrpcCallSettings
                .<ExecuteDashboardQueryRequest, ExecuteDashboardQueryResponse>newBuilder()
                .setMethodDescriptor(executeDashboardQueryMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();

    this.getDashboardQueryCallable =
        callableFactory.createUnaryCallable(
            getDashboardQueryTransportSettings,
            settings.getDashboardQuerySettings(),
            clientContext);
    this.executeDashboardQueryCallable =
        callableFactory.createUnaryCallable(
            executeDashboardQueryTransportSettings,
            settings.executeDashboardQuerySettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<GetDashboardQueryRequest, DashboardQuery> getDashboardQueryCallable() {
    return getDashboardQueryCallable;
  }

  @Override
  public UnaryCallable<ExecuteDashboardQueryRequest, ExecuteDashboardQueryResponse>
      executeDashboardQueryCallable() {
    return executeDashboardQueryCallable;
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
