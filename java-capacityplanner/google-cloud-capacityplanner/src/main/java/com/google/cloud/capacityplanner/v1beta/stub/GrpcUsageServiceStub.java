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

package com.google.cloud.capacityplanner.v1beta.stub;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.capacityplanner.v1beta.ExportForecastsRequest;
import com.google.cloud.capacityplanner.v1beta.ExportForecastsResponse;
import com.google.cloud.capacityplanner.v1beta.ExportReservationsUsageRequest;
import com.google.cloud.capacityplanner.v1beta.ExportReservationsUsageResponse;
import com.google.cloud.capacityplanner.v1beta.ExportUsageHistoriesRequest;
import com.google.cloud.capacityplanner.v1beta.ExportUsageHistoriesResponse;
import com.google.cloud.capacityplanner.v1beta.OperationMetadata;
import com.google.cloud.capacityplanner.v1beta.QueryForecastsRequest;
import com.google.cloud.capacityplanner.v1beta.QueryForecastsResponse;
import com.google.cloud.capacityplanner.v1beta.QueryReservationsRequest;
import com.google.cloud.capacityplanner.v1beta.QueryReservationsResponse;
import com.google.cloud.capacityplanner.v1beta.QueryUsageHistoriesRequest;
import com.google.cloud.capacityplanner.v1beta.QueryUsageHistoriesResponse;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.GrpcOperationsStub;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the UsageService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GrpcUsageServiceStub extends UsageServiceStub {
  private static final MethodDescriptor<QueryUsageHistoriesRequest, QueryUsageHistoriesResponse>
      queryUsageHistoriesMethodDescriptor =
          MethodDescriptor.<QueryUsageHistoriesRequest, QueryUsageHistoriesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.capacityplanner.v1beta.UsageService/QueryUsageHistories")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(QueryUsageHistoriesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(QueryUsageHistoriesResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<QueryForecastsRequest, QueryForecastsResponse>
      queryForecastsMethodDescriptor =
          MethodDescriptor.<QueryForecastsRequest, QueryForecastsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.capacityplanner.v1beta.UsageService/QueryForecasts")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(QueryForecastsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(QueryForecastsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<QueryReservationsRequest, QueryReservationsResponse>
      queryReservationsMethodDescriptor =
          MethodDescriptor.<QueryReservationsRequest, QueryReservationsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.capacityplanner.v1beta.UsageService/QueryReservations")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(QueryReservationsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(QueryReservationsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ExportUsageHistoriesRequest, Operation>
      exportUsageHistoriesMethodDescriptor =
          MethodDescriptor.<ExportUsageHistoriesRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.capacityplanner.v1beta.UsageService/ExportUsageHistories")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ExportUsageHistoriesRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ExportForecastsRequest, Operation>
      exportForecastsMethodDescriptor =
          MethodDescriptor.<ExportForecastsRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.capacityplanner.v1beta.UsageService/ExportForecasts")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ExportForecastsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ExportReservationsUsageRequest, Operation>
      exportReservationsUsageMethodDescriptor =
          MethodDescriptor.<ExportReservationsUsageRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.capacityplanner.v1beta.UsageService/ExportReservationsUsage")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ExportReservationsUsageRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private final UnaryCallable<QueryUsageHistoriesRequest, QueryUsageHistoriesResponse>
      queryUsageHistoriesCallable;
  private final UnaryCallable<QueryForecastsRequest, QueryForecastsResponse> queryForecastsCallable;
  private final UnaryCallable<QueryReservationsRequest, QueryReservationsResponse>
      queryReservationsCallable;
  private final UnaryCallable<ExportUsageHistoriesRequest, Operation> exportUsageHistoriesCallable;
  private final OperationCallable<
          ExportUsageHistoriesRequest, ExportUsageHistoriesResponse, OperationMetadata>
      exportUsageHistoriesOperationCallable;
  private final UnaryCallable<ExportForecastsRequest, Operation> exportForecastsCallable;
  private final OperationCallable<
          ExportForecastsRequest, ExportForecastsResponse, OperationMetadata>
      exportForecastsOperationCallable;
  private final UnaryCallable<ExportReservationsUsageRequest, Operation>
      exportReservationsUsageCallable;
  private final OperationCallable<
          ExportReservationsUsageRequest, ExportReservationsUsageResponse, OperationMetadata>
      exportReservationsUsageOperationCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcUsageServiceStub create(UsageServiceStubSettings settings)
      throws IOException {
    return new GrpcUsageServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcUsageServiceStub create(ClientContext clientContext) throws IOException {
    return new GrpcUsageServiceStub(UsageServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcUsageServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcUsageServiceStub(
        UsageServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcUsageServiceStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcUsageServiceStub(UsageServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcUsageServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcUsageServiceStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcUsageServiceStub(
      UsageServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<QueryUsageHistoriesRequest, QueryUsageHistoriesResponse>
        queryUsageHistoriesTransportSettings =
            GrpcCallSettings.<QueryUsageHistoriesRequest, QueryUsageHistoriesResponse>newBuilder()
                .setMethodDescriptor(queryUsageHistoriesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<QueryForecastsRequest, QueryForecastsResponse>
        queryForecastsTransportSettings =
            GrpcCallSettings.<QueryForecastsRequest, QueryForecastsResponse>newBuilder()
                .setMethodDescriptor(queryForecastsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<QueryReservationsRequest, QueryReservationsResponse>
        queryReservationsTransportSettings =
            GrpcCallSettings.<QueryReservationsRequest, QueryReservationsResponse>newBuilder()
                .setMethodDescriptor(queryReservationsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ExportUsageHistoriesRequest, Operation> exportUsageHistoriesTransportSettings =
        GrpcCallSettings.<ExportUsageHistoriesRequest, Operation>newBuilder()
            .setMethodDescriptor(exportUsageHistoriesMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ExportForecastsRequest, Operation> exportForecastsTransportSettings =
        GrpcCallSettings.<ExportForecastsRequest, Operation>newBuilder()
            .setMethodDescriptor(exportForecastsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ExportReservationsUsageRequest, Operation>
        exportReservationsUsageTransportSettings =
            GrpcCallSettings.<ExportReservationsUsageRequest, Operation>newBuilder()
                .setMethodDescriptor(exportReservationsUsageMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();

    this.queryUsageHistoriesCallable =
        callableFactory.createUnaryCallable(
            queryUsageHistoriesTransportSettings,
            settings.queryUsageHistoriesSettings(),
            clientContext);
    this.queryForecastsCallable =
        callableFactory.createUnaryCallable(
            queryForecastsTransportSettings, settings.queryForecastsSettings(), clientContext);
    this.queryReservationsCallable =
        callableFactory.createUnaryCallable(
            queryReservationsTransportSettings,
            settings.queryReservationsSettings(),
            clientContext);
    this.exportUsageHistoriesCallable =
        callableFactory.createUnaryCallable(
            exportUsageHistoriesTransportSettings,
            settings.exportUsageHistoriesSettings(),
            clientContext);
    this.exportUsageHistoriesOperationCallable =
        callableFactory.createOperationCallable(
            exportUsageHistoriesTransportSettings,
            settings.exportUsageHistoriesOperationSettings(),
            clientContext,
            operationsStub);
    this.exportForecastsCallable =
        callableFactory.createUnaryCallable(
            exportForecastsTransportSettings, settings.exportForecastsSettings(), clientContext);
    this.exportForecastsOperationCallable =
        callableFactory.createOperationCallable(
            exportForecastsTransportSettings,
            settings.exportForecastsOperationSettings(),
            clientContext,
            operationsStub);
    this.exportReservationsUsageCallable =
        callableFactory.createUnaryCallable(
            exportReservationsUsageTransportSettings,
            settings.exportReservationsUsageSettings(),
            clientContext);
    this.exportReservationsUsageOperationCallable =
        callableFactory.createOperationCallable(
            exportReservationsUsageTransportSettings,
            settings.exportReservationsUsageOperationSettings(),
            clientContext,
            operationsStub);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<QueryUsageHistoriesRequest, QueryUsageHistoriesResponse>
      queryUsageHistoriesCallable() {
    return queryUsageHistoriesCallable;
  }

  @Override
  public UnaryCallable<QueryForecastsRequest, QueryForecastsResponse> queryForecastsCallable() {
    return queryForecastsCallable;
  }

  @Override
  public UnaryCallable<QueryReservationsRequest, QueryReservationsResponse>
      queryReservationsCallable() {
    return queryReservationsCallable;
  }

  @Override
  public UnaryCallable<ExportUsageHistoriesRequest, Operation> exportUsageHistoriesCallable() {
    return exportUsageHistoriesCallable;
  }

  @Override
  public OperationCallable<
          ExportUsageHistoriesRequest, ExportUsageHistoriesResponse, OperationMetadata>
      exportUsageHistoriesOperationCallable() {
    return exportUsageHistoriesOperationCallable;
  }

  @Override
  public UnaryCallable<ExportForecastsRequest, Operation> exportForecastsCallable() {
    return exportForecastsCallable;
  }

  @Override
  public OperationCallable<ExportForecastsRequest, ExportForecastsResponse, OperationMetadata>
      exportForecastsOperationCallable() {
    return exportForecastsOperationCallable;
  }

  @Override
  public UnaryCallable<ExportReservationsUsageRequest, Operation>
      exportReservationsUsageCallable() {
    return exportReservationsUsageCallable;
  }

  @Override
  public OperationCallable<
          ExportReservationsUsageRequest, ExportReservationsUsageResponse, OperationMetadata>
      exportReservationsUsageOperationCallable() {
    return exportReservationsUsageOperationCallable;
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
