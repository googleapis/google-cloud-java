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

package com.google.cloud.dataplex.v1.stub;

import static com.google.cloud.dataplex.v1.DataScanServiceClient.ListDataScanJobsPagedResponse;
import static com.google.cloud.dataplex.v1.DataScanServiceClient.ListDataScansPagedResponse;
import static com.google.cloud.dataplex.v1.DataScanServiceClient.ListLocationsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.dataplex.v1.CreateDataScanRequest;
import com.google.cloud.dataplex.v1.DataScan;
import com.google.cloud.dataplex.v1.DataScanJob;
import com.google.cloud.dataplex.v1.DeleteDataScanRequest;
import com.google.cloud.dataplex.v1.GetDataScanJobRequest;
import com.google.cloud.dataplex.v1.GetDataScanRequest;
import com.google.cloud.dataplex.v1.ListDataScanJobsRequest;
import com.google.cloud.dataplex.v1.ListDataScanJobsResponse;
import com.google.cloud.dataplex.v1.ListDataScansRequest;
import com.google.cloud.dataplex.v1.ListDataScansResponse;
import com.google.cloud.dataplex.v1.OperationMetadata;
import com.google.cloud.dataplex.v1.RunDataScanRequest;
import com.google.cloud.dataplex.v1.RunDataScanResponse;
import com.google.cloud.dataplex.v1.UpdateDataScanRequest;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.common.collect.ImmutableMap;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.protobuf.Empty;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the DataScanService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcDataScanServiceStub extends DataScanServiceStub {
  private static final MethodDescriptor<CreateDataScanRequest, Operation>
      createDataScanMethodDescriptor =
          MethodDescriptor.<CreateDataScanRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dataplex.v1.DataScanService/CreateDataScan")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateDataScanRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateDataScanRequest, Operation>
      updateDataScanMethodDescriptor =
          MethodDescriptor.<UpdateDataScanRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dataplex.v1.DataScanService/UpdateDataScan")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateDataScanRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteDataScanRequest, Operation>
      deleteDataScanMethodDescriptor =
          MethodDescriptor.<DeleteDataScanRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dataplex.v1.DataScanService/DeleteDataScan")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteDataScanRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetDataScanRequest, DataScan> getDataScanMethodDescriptor =
      MethodDescriptor.<GetDataScanRequest, DataScan>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.dataplex.v1.DataScanService/GetDataScan")
          .setRequestMarshaller(ProtoUtils.marshaller(GetDataScanRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(DataScan.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<ListDataScansRequest, ListDataScansResponse>
      listDataScansMethodDescriptor =
          MethodDescriptor.<ListDataScansRequest, ListDataScansResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dataplex.v1.DataScanService/ListDataScans")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListDataScansRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListDataScansResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<RunDataScanRequest, RunDataScanResponse>
      runDataScanMethodDescriptor =
          MethodDescriptor.<RunDataScanRequest, RunDataScanResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dataplex.v1.DataScanService/RunDataScan")
              .setRequestMarshaller(ProtoUtils.marshaller(RunDataScanRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(RunDataScanResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetDataScanJobRequest, DataScanJob>
      getDataScanJobMethodDescriptor =
          MethodDescriptor.<GetDataScanJobRequest, DataScanJob>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dataplex.v1.DataScanService/GetDataScanJob")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetDataScanJobRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(DataScanJob.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListDataScanJobsRequest, ListDataScanJobsResponse>
      listDataScanJobsMethodDescriptor =
          MethodDescriptor.<ListDataScanJobsRequest, ListDataScanJobsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dataplex.v1.DataScanService/ListDataScanJobs")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListDataScanJobsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListDataScanJobsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListLocationsRequest, ListLocationsResponse>
      listLocationsMethodDescriptor =
          MethodDescriptor.<ListLocationsRequest, ListLocationsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.location.Locations/ListLocations")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListLocationsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListLocationsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetLocationRequest, Location> getLocationMethodDescriptor =
      MethodDescriptor.<GetLocationRequest, Location>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.location.Locations/GetLocation")
          .setRequestMarshaller(ProtoUtils.marshaller(GetLocationRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Location.getDefaultInstance()))
          .build();

  private final UnaryCallable<CreateDataScanRequest, Operation> createDataScanCallable;
  private final OperationCallable<CreateDataScanRequest, DataScan, OperationMetadata>
      createDataScanOperationCallable;
  private final UnaryCallable<UpdateDataScanRequest, Operation> updateDataScanCallable;
  private final OperationCallable<UpdateDataScanRequest, DataScan, OperationMetadata>
      updateDataScanOperationCallable;
  private final UnaryCallable<DeleteDataScanRequest, Operation> deleteDataScanCallable;
  private final OperationCallable<DeleteDataScanRequest, Empty, OperationMetadata>
      deleteDataScanOperationCallable;
  private final UnaryCallable<GetDataScanRequest, DataScan> getDataScanCallable;
  private final UnaryCallable<ListDataScansRequest, ListDataScansResponse> listDataScansCallable;
  private final UnaryCallable<ListDataScansRequest, ListDataScansPagedResponse>
      listDataScansPagedCallable;
  private final UnaryCallable<RunDataScanRequest, RunDataScanResponse> runDataScanCallable;
  private final UnaryCallable<GetDataScanJobRequest, DataScanJob> getDataScanJobCallable;
  private final UnaryCallable<ListDataScanJobsRequest, ListDataScanJobsResponse>
      listDataScanJobsCallable;
  private final UnaryCallable<ListDataScanJobsRequest, ListDataScanJobsPagedResponse>
      listDataScanJobsPagedCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<GetLocationRequest, Location> getLocationCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcDataScanServiceStub create(DataScanServiceStubSettings settings)
      throws IOException {
    return new GrpcDataScanServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcDataScanServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcDataScanServiceStub(
        DataScanServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcDataScanServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcDataScanServiceStub(
        DataScanServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcDataScanServiceStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcDataScanServiceStub(
      DataScanServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcDataScanServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcDataScanServiceStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcDataScanServiceStub(
      DataScanServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<CreateDataScanRequest, Operation> createDataScanTransportSettings =
        GrpcCallSettings.<CreateDataScanRequest, Operation>newBuilder()
            .setMethodDescriptor(createDataScanMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<UpdateDataScanRequest, Operation> updateDataScanTransportSettings =
        GrpcCallSettings.<UpdateDataScanRequest, Operation>newBuilder()
            .setMethodDescriptor(updateDataScanMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("data_scan.name", String.valueOf(request.getDataScan().getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<DeleteDataScanRequest, Operation> deleteDataScanTransportSettings =
        GrpcCallSettings.<DeleteDataScanRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteDataScanMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<GetDataScanRequest, DataScan> getDataScanTransportSettings =
        GrpcCallSettings.<GetDataScanRequest, DataScan>newBuilder()
            .setMethodDescriptor(getDataScanMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<ListDataScansRequest, ListDataScansResponse> listDataScansTransportSettings =
        GrpcCallSettings.<ListDataScansRequest, ListDataScansResponse>newBuilder()
            .setMethodDescriptor(listDataScansMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<RunDataScanRequest, RunDataScanResponse> runDataScanTransportSettings =
        GrpcCallSettings.<RunDataScanRequest, RunDataScanResponse>newBuilder()
            .setMethodDescriptor(runDataScanMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<GetDataScanJobRequest, DataScanJob> getDataScanJobTransportSettings =
        GrpcCallSettings.<GetDataScanJobRequest, DataScanJob>newBuilder()
            .setMethodDescriptor(getDataScanJobMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<ListDataScanJobsRequest, ListDataScanJobsResponse>
        listDataScanJobsTransportSettings =
            GrpcCallSettings.<ListDataScanJobsRequest, ListDataScanJobsResponse>newBuilder()
                .setMethodDescriptor(listDataScanJobsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<ListLocationsRequest, ListLocationsResponse> listLocationsTransportSettings =
        GrpcCallSettings.<ListLocationsRequest, ListLocationsResponse>newBuilder()
            .setMethodDescriptor(listLocationsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<GetLocationRequest, Location> getLocationTransportSettings =
        GrpcCallSettings.<GetLocationRequest, Location>newBuilder()
            .setMethodDescriptor(getLocationMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();

    this.createDataScanCallable =
        callableFactory.createUnaryCallable(
            createDataScanTransportSettings, settings.createDataScanSettings(), clientContext);
    this.createDataScanOperationCallable =
        callableFactory.createOperationCallable(
            createDataScanTransportSettings,
            settings.createDataScanOperationSettings(),
            clientContext,
            operationsStub);
    this.updateDataScanCallable =
        callableFactory.createUnaryCallable(
            updateDataScanTransportSettings, settings.updateDataScanSettings(), clientContext);
    this.updateDataScanOperationCallable =
        callableFactory.createOperationCallable(
            updateDataScanTransportSettings,
            settings.updateDataScanOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteDataScanCallable =
        callableFactory.createUnaryCallable(
            deleteDataScanTransportSettings, settings.deleteDataScanSettings(), clientContext);
    this.deleteDataScanOperationCallable =
        callableFactory.createOperationCallable(
            deleteDataScanTransportSettings,
            settings.deleteDataScanOperationSettings(),
            clientContext,
            operationsStub);
    this.getDataScanCallable =
        callableFactory.createUnaryCallable(
            getDataScanTransportSettings, settings.getDataScanSettings(), clientContext);
    this.listDataScansCallable =
        callableFactory.createUnaryCallable(
            listDataScansTransportSettings, settings.listDataScansSettings(), clientContext);
    this.listDataScansPagedCallable =
        callableFactory.createPagedCallable(
            listDataScansTransportSettings, settings.listDataScansSettings(), clientContext);
    this.runDataScanCallable =
        callableFactory.createUnaryCallable(
            runDataScanTransportSettings, settings.runDataScanSettings(), clientContext);
    this.getDataScanJobCallable =
        callableFactory.createUnaryCallable(
            getDataScanJobTransportSettings, settings.getDataScanJobSettings(), clientContext);
    this.listDataScanJobsCallable =
        callableFactory.createUnaryCallable(
            listDataScanJobsTransportSettings, settings.listDataScanJobsSettings(), clientContext);
    this.listDataScanJobsPagedCallable =
        callableFactory.createPagedCallable(
            listDataScanJobsTransportSettings, settings.listDataScanJobsSettings(), clientContext);
    this.listLocationsCallable =
        callableFactory.createUnaryCallable(
            listLocationsTransportSettings, settings.listLocationsSettings(), clientContext);
    this.listLocationsPagedCallable =
        callableFactory.createPagedCallable(
            listLocationsTransportSettings, settings.listLocationsSettings(), clientContext);
    this.getLocationCallable =
        callableFactory.createUnaryCallable(
            getLocationTransportSettings, settings.getLocationSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<CreateDataScanRequest, Operation> createDataScanCallable() {
    return createDataScanCallable;
  }

  @Override
  public OperationCallable<CreateDataScanRequest, DataScan, OperationMetadata>
      createDataScanOperationCallable() {
    return createDataScanOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateDataScanRequest, Operation> updateDataScanCallable() {
    return updateDataScanCallable;
  }

  @Override
  public OperationCallable<UpdateDataScanRequest, DataScan, OperationMetadata>
      updateDataScanOperationCallable() {
    return updateDataScanOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteDataScanRequest, Operation> deleteDataScanCallable() {
    return deleteDataScanCallable;
  }

  @Override
  public OperationCallable<DeleteDataScanRequest, Empty, OperationMetadata>
      deleteDataScanOperationCallable() {
    return deleteDataScanOperationCallable;
  }

  @Override
  public UnaryCallable<GetDataScanRequest, DataScan> getDataScanCallable() {
    return getDataScanCallable;
  }

  @Override
  public UnaryCallable<ListDataScansRequest, ListDataScansResponse> listDataScansCallable() {
    return listDataScansCallable;
  }

  @Override
  public UnaryCallable<ListDataScansRequest, ListDataScansPagedResponse>
      listDataScansPagedCallable() {
    return listDataScansPagedCallable;
  }

  @Override
  public UnaryCallable<RunDataScanRequest, RunDataScanResponse> runDataScanCallable() {
    return runDataScanCallable;
  }

  @Override
  public UnaryCallable<GetDataScanJobRequest, DataScanJob> getDataScanJobCallable() {
    return getDataScanJobCallable;
  }

  @Override
  public UnaryCallable<ListDataScanJobsRequest, ListDataScanJobsResponse>
      listDataScanJobsCallable() {
    return listDataScanJobsCallable;
  }

  @Override
  public UnaryCallable<ListDataScanJobsRequest, ListDataScanJobsPagedResponse>
      listDataScanJobsPagedCallable() {
    return listDataScanJobsPagedCallable;
  }

  @Override
  public UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable() {
    return listLocationsCallable;
  }

  @Override
  public UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable() {
    return listLocationsPagedCallable;
  }

  @Override
  public UnaryCallable<GetLocationRequest, Location> getLocationCallable() {
    return getLocationCallable;
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
