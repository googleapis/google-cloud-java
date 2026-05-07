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

package com.google.devicesandservices.health.v4.stub;

import static com.google.devicesandservices.health.v4.DataPointsServiceClient.ListDataPointsPagedResponse;
import static com.google.devicesandservices.health.v4.DataPointsServiceClient.ReconcileDataPointsPagedResponse;
import static com.google.devicesandservices.health.v4.DataPointsServiceClient.RollUpDataPointsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.devicesandservices.health.v4.BatchDeleteDataPointsOperationMetadata;
import com.google.devicesandservices.health.v4.BatchDeleteDataPointsRequest;
import com.google.devicesandservices.health.v4.BatchDeleteDataPointsResponse;
import com.google.devicesandservices.health.v4.CreateDataPointOperationMetadata;
import com.google.devicesandservices.health.v4.CreateDataPointRequest;
import com.google.devicesandservices.health.v4.DailyRollUpDataPointsRequest;
import com.google.devicesandservices.health.v4.DailyRollUpDataPointsResponse;
import com.google.devicesandservices.health.v4.DataPoint;
import com.google.devicesandservices.health.v4.ExportExerciseTcxRequest;
import com.google.devicesandservices.health.v4.ExportExerciseTcxResponse;
import com.google.devicesandservices.health.v4.GetDataPointRequest;
import com.google.devicesandservices.health.v4.ListDataPointsRequest;
import com.google.devicesandservices.health.v4.ListDataPointsResponse;
import com.google.devicesandservices.health.v4.ReconcileDataPointsRequest;
import com.google.devicesandservices.health.v4.ReconcileDataPointsResponse;
import com.google.devicesandservices.health.v4.RollUpDataPointsRequest;
import com.google.devicesandservices.health.v4.RollUpDataPointsResponse;
import com.google.devicesandservices.health.v4.UpdateDataPointOperationMetadata;
import com.google.devicesandservices.health.v4.UpdateDataPointRequest;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.GrpcOperationsStub;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the DataPointsService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcDataPointsServiceStub extends DataPointsServiceStub {
  private static final MethodDescriptor<GetDataPointRequest, DataPoint>
      getDataPointMethodDescriptor =
          MethodDescriptor.<GetDataPointRequest, DataPoint>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.devicesandservices.health.v4.DataPointsService/GetDataPoint")
              .setRequestMarshaller(ProtoUtils.marshaller(GetDataPointRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(DataPoint.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ListDataPointsRequest, ListDataPointsResponse>
      listDataPointsMethodDescriptor =
          MethodDescriptor.<ListDataPointsRequest, ListDataPointsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.devicesandservices.health.v4.DataPointsService/ListDataPoints")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListDataPointsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListDataPointsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<CreateDataPointRequest, Operation>
      createDataPointMethodDescriptor =
          MethodDescriptor.<CreateDataPointRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.devicesandservices.health.v4.DataPointsService/CreateDataPoint")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateDataPointRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<UpdateDataPointRequest, Operation>
      updateDataPointMethodDescriptor =
          MethodDescriptor.<UpdateDataPointRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.devicesandservices.health.v4.DataPointsService/UpdateDataPoint")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateDataPointRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<BatchDeleteDataPointsRequest, Operation>
      batchDeleteDataPointsMethodDescriptor =
          MethodDescriptor.<BatchDeleteDataPointsRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.devicesandservices.health.v4.DataPointsService/BatchDeleteDataPoints")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(BatchDeleteDataPointsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ReconcileDataPointsRequest, ReconcileDataPointsResponse>
      reconcileDataPointsMethodDescriptor =
          MethodDescriptor.<ReconcileDataPointsRequest, ReconcileDataPointsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.devicesandservices.health.v4.DataPointsService/ReconcileDataPoints")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ReconcileDataPointsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ReconcileDataPointsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<RollUpDataPointsRequest, RollUpDataPointsResponse>
      rollUpDataPointsMethodDescriptor =
          MethodDescriptor.<RollUpDataPointsRequest, RollUpDataPointsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.devicesandservices.health.v4.DataPointsService/RollUpDataPoints")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(RollUpDataPointsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(RollUpDataPointsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DailyRollUpDataPointsRequest, DailyRollUpDataPointsResponse>
      dailyRollUpDataPointsMethodDescriptor =
          MethodDescriptor.<DailyRollUpDataPointsRequest, DailyRollUpDataPointsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.devicesandservices.health.v4.DataPointsService/DailyRollUpDataPoints")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DailyRollUpDataPointsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(DailyRollUpDataPointsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ExportExerciseTcxRequest, ExportExerciseTcxResponse>
      exportExerciseTcxMethodDescriptor =
          MethodDescriptor.<ExportExerciseTcxRequest, ExportExerciseTcxResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.devicesandservices.health.v4.DataPointsService/ExportExerciseTcx")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ExportExerciseTcxRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ExportExerciseTcxResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private final UnaryCallable<GetDataPointRequest, DataPoint> getDataPointCallable;
  private final UnaryCallable<ListDataPointsRequest, ListDataPointsResponse> listDataPointsCallable;
  private final UnaryCallable<ListDataPointsRequest, ListDataPointsPagedResponse>
      listDataPointsPagedCallable;
  private final UnaryCallable<CreateDataPointRequest, Operation> createDataPointCallable;
  private final OperationCallable<
          CreateDataPointRequest, DataPoint, CreateDataPointOperationMetadata>
      createDataPointOperationCallable;
  private final UnaryCallable<UpdateDataPointRequest, Operation> updateDataPointCallable;
  private final OperationCallable<
          UpdateDataPointRequest, DataPoint, UpdateDataPointOperationMetadata>
      updateDataPointOperationCallable;
  private final UnaryCallable<BatchDeleteDataPointsRequest, Operation>
      batchDeleteDataPointsCallable;
  private final OperationCallable<
          BatchDeleteDataPointsRequest,
          BatchDeleteDataPointsResponse,
          BatchDeleteDataPointsOperationMetadata>
      batchDeleteDataPointsOperationCallable;
  private final UnaryCallable<ReconcileDataPointsRequest, ReconcileDataPointsResponse>
      reconcileDataPointsCallable;
  private final UnaryCallable<ReconcileDataPointsRequest, ReconcileDataPointsPagedResponse>
      reconcileDataPointsPagedCallable;
  private final UnaryCallable<RollUpDataPointsRequest, RollUpDataPointsResponse>
      rollUpDataPointsCallable;
  private final UnaryCallable<RollUpDataPointsRequest, RollUpDataPointsPagedResponse>
      rollUpDataPointsPagedCallable;
  private final UnaryCallable<DailyRollUpDataPointsRequest, DailyRollUpDataPointsResponse>
      dailyRollUpDataPointsCallable;
  private final UnaryCallable<ExportExerciseTcxRequest, ExportExerciseTcxResponse>
      exportExerciseTcxCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcDataPointsServiceStub create(DataPointsServiceStubSettings settings)
      throws IOException {
    return new GrpcDataPointsServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcDataPointsServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcDataPointsServiceStub(
        DataPointsServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcDataPointsServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcDataPointsServiceStub(
        DataPointsServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcDataPointsServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcDataPointsServiceStub(
      DataPointsServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcDataPointsServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcDataPointsServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcDataPointsServiceStub(
      DataPointsServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<GetDataPointRequest, DataPoint> getDataPointTransportSettings =
        GrpcCallSettings.<GetDataPointRequest, DataPoint>newBuilder()
            .setMethodDescriptor(getDataPointMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    GrpcCallSettings<ListDataPointsRequest, ListDataPointsResponse>
        listDataPointsTransportSettings =
            GrpcCallSettings.<ListDataPointsRequest, ListDataPointsResponse>newBuilder()
                .setMethodDescriptor(listDataPointsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    GrpcCallSettings<CreateDataPointRequest, Operation> createDataPointTransportSettings =
        GrpcCallSettings.<CreateDataPointRequest, Operation>newBuilder()
            .setMethodDescriptor(createDataPointMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getParent())
            .build();
    GrpcCallSettings<UpdateDataPointRequest, Operation> updateDataPointTransportSettings =
        GrpcCallSettings.<UpdateDataPointRequest, Operation>newBuilder()
            .setMethodDescriptor(updateDataPointMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("data_point.name", String.valueOf(request.getDataPoint().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<BatchDeleteDataPointsRequest, Operation>
        batchDeleteDataPointsTransportSettings =
            GrpcCallSettings.<BatchDeleteDataPointsRequest, Operation>newBuilder()
                .setMethodDescriptor(batchDeleteDataPointsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    GrpcCallSettings<ReconcileDataPointsRequest, ReconcileDataPointsResponse>
        reconcileDataPointsTransportSettings =
            GrpcCallSettings.<ReconcileDataPointsRequest, ReconcileDataPointsResponse>newBuilder()
                .setMethodDescriptor(reconcileDataPointsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<RollUpDataPointsRequest, RollUpDataPointsResponse>
        rollUpDataPointsTransportSettings =
            GrpcCallSettings.<RollUpDataPointsRequest, RollUpDataPointsResponse>newBuilder()
                .setMethodDescriptor(rollUpDataPointsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    GrpcCallSettings<DailyRollUpDataPointsRequest, DailyRollUpDataPointsResponse>
        dailyRollUpDataPointsTransportSettings =
            GrpcCallSettings
                .<DailyRollUpDataPointsRequest, DailyRollUpDataPointsResponse>newBuilder()
                .setMethodDescriptor(dailyRollUpDataPointsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    GrpcCallSettings<ExportExerciseTcxRequest, ExportExerciseTcxResponse>
        exportExerciseTcxTransportSettings =
            GrpcCallSettings.<ExportExerciseTcxRequest, ExportExerciseTcxResponse>newBuilder()
                .setMethodDescriptor(exportExerciseTcxMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();

    this.getDataPointCallable =
        callableFactory.createUnaryCallable(
            getDataPointTransportSettings, settings.getDataPointSettings(), clientContext);
    this.listDataPointsCallable =
        callableFactory.createUnaryCallable(
            listDataPointsTransportSettings, settings.listDataPointsSettings(), clientContext);
    this.listDataPointsPagedCallable =
        callableFactory.createPagedCallable(
            listDataPointsTransportSettings, settings.listDataPointsSettings(), clientContext);
    this.createDataPointCallable =
        callableFactory.createUnaryCallable(
            createDataPointTransportSettings, settings.createDataPointSettings(), clientContext);
    this.createDataPointOperationCallable =
        callableFactory.createOperationCallable(
            createDataPointTransportSettings,
            settings.createDataPointOperationSettings(),
            clientContext,
            operationsStub);
    this.updateDataPointCallable =
        callableFactory.createUnaryCallable(
            updateDataPointTransportSettings, settings.updateDataPointSettings(), clientContext);
    this.updateDataPointOperationCallable =
        callableFactory.createOperationCallable(
            updateDataPointTransportSettings,
            settings.updateDataPointOperationSettings(),
            clientContext,
            operationsStub);
    this.batchDeleteDataPointsCallable =
        callableFactory.createUnaryCallable(
            batchDeleteDataPointsTransportSettings,
            settings.batchDeleteDataPointsSettings(),
            clientContext);
    this.batchDeleteDataPointsOperationCallable =
        callableFactory.createOperationCallable(
            batchDeleteDataPointsTransportSettings,
            settings.batchDeleteDataPointsOperationSettings(),
            clientContext,
            operationsStub);
    this.reconcileDataPointsCallable =
        callableFactory.createUnaryCallable(
            reconcileDataPointsTransportSettings,
            settings.reconcileDataPointsSettings(),
            clientContext);
    this.reconcileDataPointsPagedCallable =
        callableFactory.createPagedCallable(
            reconcileDataPointsTransportSettings,
            settings.reconcileDataPointsSettings(),
            clientContext);
    this.rollUpDataPointsCallable =
        callableFactory.createUnaryCallable(
            rollUpDataPointsTransportSettings, settings.rollUpDataPointsSettings(), clientContext);
    this.rollUpDataPointsPagedCallable =
        callableFactory.createPagedCallable(
            rollUpDataPointsTransportSettings, settings.rollUpDataPointsSettings(), clientContext);
    this.dailyRollUpDataPointsCallable =
        callableFactory.createUnaryCallable(
            dailyRollUpDataPointsTransportSettings,
            settings.dailyRollUpDataPointsSettings(),
            clientContext);
    this.exportExerciseTcxCallable =
        callableFactory.createUnaryCallable(
            exportExerciseTcxTransportSettings,
            settings.exportExerciseTcxSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<GetDataPointRequest, DataPoint> getDataPointCallable() {
    return getDataPointCallable;
  }

  @Override
  public UnaryCallable<ListDataPointsRequest, ListDataPointsResponse> listDataPointsCallable() {
    return listDataPointsCallable;
  }

  @Override
  public UnaryCallable<ListDataPointsRequest, ListDataPointsPagedResponse>
      listDataPointsPagedCallable() {
    return listDataPointsPagedCallable;
  }

  @Override
  public UnaryCallable<CreateDataPointRequest, Operation> createDataPointCallable() {
    return createDataPointCallable;
  }

  @Override
  public OperationCallable<CreateDataPointRequest, DataPoint, CreateDataPointOperationMetadata>
      createDataPointOperationCallable() {
    return createDataPointOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateDataPointRequest, Operation> updateDataPointCallable() {
    return updateDataPointCallable;
  }

  @Override
  public OperationCallable<UpdateDataPointRequest, DataPoint, UpdateDataPointOperationMetadata>
      updateDataPointOperationCallable() {
    return updateDataPointOperationCallable;
  }

  @Override
  public UnaryCallable<BatchDeleteDataPointsRequest, Operation> batchDeleteDataPointsCallable() {
    return batchDeleteDataPointsCallable;
  }

  @Override
  public OperationCallable<
          BatchDeleteDataPointsRequest,
          BatchDeleteDataPointsResponse,
          BatchDeleteDataPointsOperationMetadata>
      batchDeleteDataPointsOperationCallable() {
    return batchDeleteDataPointsOperationCallable;
  }

  @Override
  public UnaryCallable<ReconcileDataPointsRequest, ReconcileDataPointsResponse>
      reconcileDataPointsCallable() {
    return reconcileDataPointsCallable;
  }

  @Override
  public UnaryCallable<ReconcileDataPointsRequest, ReconcileDataPointsPagedResponse>
      reconcileDataPointsPagedCallable() {
    return reconcileDataPointsPagedCallable;
  }

  @Override
  public UnaryCallable<RollUpDataPointsRequest, RollUpDataPointsResponse>
      rollUpDataPointsCallable() {
    return rollUpDataPointsCallable;
  }

  @Override
  public UnaryCallable<RollUpDataPointsRequest, RollUpDataPointsPagedResponse>
      rollUpDataPointsPagedCallable() {
    return rollUpDataPointsPagedCallable;
  }

  @Override
  public UnaryCallable<DailyRollUpDataPointsRequest, DailyRollUpDataPointsResponse>
      dailyRollUpDataPointsCallable() {
    return dailyRollUpDataPointsCallable;
  }

  @Override
  public UnaryCallable<ExportExerciseTcxRequest, ExportExerciseTcxResponse>
      exportExerciseTcxCallable() {
    return exportExerciseTcxCallable;
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
