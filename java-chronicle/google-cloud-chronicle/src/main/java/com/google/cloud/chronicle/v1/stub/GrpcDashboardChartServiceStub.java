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
import com.google.cloud.chronicle.v1.BatchGetDashboardChartsRequest;
import com.google.cloud.chronicle.v1.BatchGetDashboardChartsResponse;
import com.google.cloud.chronicle.v1.DashboardChart;
import com.google.cloud.chronicle.v1.GetDashboardChartRequest;
import com.google.longrunning.stub.GrpcOperationsStub;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the DashboardChartService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@NullMarked
@Generated("by gapic-generator-java")
public class GrpcDashboardChartServiceStub extends DashboardChartServiceStub {
  private static final MethodDescriptor<GetDashboardChartRequest, DashboardChart>
      getDashboardChartMethodDescriptor =
          MethodDescriptor.<GetDashboardChartRequest, DashboardChart>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.chronicle.v1.DashboardChartService/GetDashboardChart")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetDashboardChartRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(DashboardChart.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<
          BatchGetDashboardChartsRequest, BatchGetDashboardChartsResponse>
      batchGetDashboardChartsMethodDescriptor =
          MethodDescriptor
              .<BatchGetDashboardChartsRequest, BatchGetDashboardChartsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.chronicle.v1.DashboardChartService/BatchGetDashboardCharts")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(BatchGetDashboardChartsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(BatchGetDashboardChartsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private final UnaryCallable<GetDashboardChartRequest, DashboardChart> getDashboardChartCallable;
  private final UnaryCallable<BatchGetDashboardChartsRequest, BatchGetDashboardChartsResponse>
      batchGetDashboardChartsCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcDashboardChartServiceStub create(
      DashboardChartServiceStubSettings settings) throws IOException {
    return new GrpcDashboardChartServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcDashboardChartServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcDashboardChartServiceStub(
        DashboardChartServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcDashboardChartServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcDashboardChartServiceStub(
        DashboardChartServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcDashboardChartServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcDashboardChartServiceStub(
      DashboardChartServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcDashboardChartServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcDashboardChartServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcDashboardChartServiceStub(
      DashboardChartServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<GetDashboardChartRequest, DashboardChart> getDashboardChartTransportSettings =
        GrpcCallSettings.<GetDashboardChartRequest, DashboardChart>newBuilder()
            .setMethodDescriptor(getDashboardChartMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    GrpcCallSettings<BatchGetDashboardChartsRequest, BatchGetDashboardChartsResponse>
        batchGetDashboardChartsTransportSettings =
            GrpcCallSettings
                .<BatchGetDashboardChartsRequest, BatchGetDashboardChartsResponse>newBuilder()
                .setMethodDescriptor(batchGetDashboardChartsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();

    this.getDashboardChartCallable =
        callableFactory.createUnaryCallable(
            getDashboardChartTransportSettings,
            settings.getDashboardChartSettings(),
            clientContext);
    this.batchGetDashboardChartsCallable =
        callableFactory.createUnaryCallable(
            batchGetDashboardChartsTransportSettings,
            settings.batchGetDashboardChartsSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<GetDashboardChartRequest, DashboardChart> getDashboardChartCallable() {
    return getDashboardChartCallable;
  }

  @Override
  public UnaryCallable<BatchGetDashboardChartsRequest, BatchGetDashboardChartsResponse>
      batchGetDashboardChartsCallable() {
    return batchGetDashboardChartsCallable;
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
