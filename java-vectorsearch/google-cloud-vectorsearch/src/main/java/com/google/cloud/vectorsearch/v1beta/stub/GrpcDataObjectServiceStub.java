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

package com.google.cloud.vectorsearch.v1beta.stub;

import static com.google.cloud.vectorsearch.v1beta.DataObjectServiceClient.ListLocationsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.cloud.vectorsearch.v1beta.BatchCreateDataObjectsRequest;
import com.google.cloud.vectorsearch.v1beta.BatchCreateDataObjectsResponse;
import com.google.cloud.vectorsearch.v1beta.BatchDeleteDataObjectsRequest;
import com.google.cloud.vectorsearch.v1beta.BatchUpdateDataObjectsRequest;
import com.google.cloud.vectorsearch.v1beta.BatchUpdateDataObjectsResponse;
import com.google.cloud.vectorsearch.v1beta.CreateDataObjectRequest;
import com.google.cloud.vectorsearch.v1beta.DataObject;
import com.google.cloud.vectorsearch.v1beta.DeleteDataObjectRequest;
import com.google.cloud.vectorsearch.v1beta.GetDataObjectRequest;
import com.google.cloud.vectorsearch.v1beta.UpdateDataObjectRequest;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.protobuf.Empty;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the DataObjectService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GrpcDataObjectServiceStub extends DataObjectServiceStub {
  private static final MethodDescriptor<CreateDataObjectRequest, DataObject>
      createDataObjectMethodDescriptor =
          MethodDescriptor.<CreateDataObjectRequest, DataObject>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.vectorsearch.v1beta.DataObjectService/CreateDataObject")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateDataObjectRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(DataObject.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<
          BatchCreateDataObjectsRequest, BatchCreateDataObjectsResponse>
      batchCreateDataObjectsMethodDescriptor =
          MethodDescriptor
              .<BatchCreateDataObjectsRequest, BatchCreateDataObjectsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.vectorsearch.v1beta.DataObjectService/BatchCreateDataObjects")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(BatchCreateDataObjectsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(BatchCreateDataObjectsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetDataObjectRequest, DataObject>
      getDataObjectMethodDescriptor =
          MethodDescriptor.<GetDataObjectRequest, DataObject>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.vectorsearch.v1beta.DataObjectService/GetDataObject")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetDataObjectRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(DataObject.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<UpdateDataObjectRequest, DataObject>
      updateDataObjectMethodDescriptor =
          MethodDescriptor.<UpdateDataObjectRequest, DataObject>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.vectorsearch.v1beta.DataObjectService/UpdateDataObject")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateDataObjectRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(DataObject.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<
          BatchUpdateDataObjectsRequest, BatchUpdateDataObjectsResponse>
      batchUpdateDataObjectsMethodDescriptor =
          MethodDescriptor
              .<BatchUpdateDataObjectsRequest, BatchUpdateDataObjectsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.vectorsearch.v1beta.DataObjectService/BatchUpdateDataObjects")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(BatchUpdateDataObjectsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(BatchUpdateDataObjectsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteDataObjectRequest, Empty>
      deleteDataObjectMethodDescriptor =
          MethodDescriptor.<DeleteDataObjectRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.vectorsearch.v1beta.DataObjectService/DeleteDataObject")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteDataObjectRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<BatchDeleteDataObjectsRequest, Empty>
      batchDeleteDataObjectsMethodDescriptor =
          MethodDescriptor.<BatchDeleteDataObjectsRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.vectorsearch.v1beta.DataObjectService/BatchDeleteDataObjects")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(BatchDeleteDataObjectsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .setSampledToLocalTracing(true)
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
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetLocationRequest, Location> getLocationMethodDescriptor =
      MethodDescriptor.<GetLocationRequest, Location>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.location.Locations/GetLocation")
          .setRequestMarshaller(ProtoUtils.marshaller(GetLocationRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Location.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private final UnaryCallable<CreateDataObjectRequest, DataObject> createDataObjectCallable;
  private final UnaryCallable<BatchCreateDataObjectsRequest, BatchCreateDataObjectsResponse>
      batchCreateDataObjectsCallable;
  private final UnaryCallable<GetDataObjectRequest, DataObject> getDataObjectCallable;
  private final UnaryCallable<UpdateDataObjectRequest, DataObject> updateDataObjectCallable;
  private final UnaryCallable<BatchUpdateDataObjectsRequest, BatchUpdateDataObjectsResponse>
      batchUpdateDataObjectsCallable;
  private final UnaryCallable<DeleteDataObjectRequest, Empty> deleteDataObjectCallable;
  private final UnaryCallable<BatchDeleteDataObjectsRequest, Empty> batchDeleteDataObjectsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<GetLocationRequest, Location> getLocationCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcDataObjectServiceStub create(DataObjectServiceStubSettings settings)
      throws IOException {
    return new GrpcDataObjectServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcDataObjectServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcDataObjectServiceStub(
        DataObjectServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcDataObjectServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcDataObjectServiceStub(
        DataObjectServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcDataObjectServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcDataObjectServiceStub(
      DataObjectServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcDataObjectServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcDataObjectServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcDataObjectServiceStub(
      DataObjectServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<CreateDataObjectRequest, DataObject> createDataObjectTransportSettings =
        GrpcCallSettings.<CreateDataObjectRequest, DataObject>newBuilder()
            .setMethodDescriptor(createDataObjectMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<BatchCreateDataObjectsRequest, BatchCreateDataObjectsResponse>
        batchCreateDataObjectsTransportSettings =
            GrpcCallSettings
                .<BatchCreateDataObjectsRequest, BatchCreateDataObjectsResponse>newBuilder()
                .setMethodDescriptor(batchCreateDataObjectsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetDataObjectRequest, DataObject> getDataObjectTransportSettings =
        GrpcCallSettings.<GetDataObjectRequest, DataObject>newBuilder()
            .setMethodDescriptor(getDataObjectMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateDataObjectRequest, DataObject> updateDataObjectTransportSettings =
        GrpcCallSettings.<UpdateDataObjectRequest, DataObject>newBuilder()
            .setMethodDescriptor(updateDataObjectMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(
                      "data_object.name", String.valueOf(request.getDataObject().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<BatchUpdateDataObjectsRequest, BatchUpdateDataObjectsResponse>
        batchUpdateDataObjectsTransportSettings =
            GrpcCallSettings
                .<BatchUpdateDataObjectsRequest, BatchUpdateDataObjectsResponse>newBuilder()
                .setMethodDescriptor(batchUpdateDataObjectsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<DeleteDataObjectRequest, Empty> deleteDataObjectTransportSettings =
        GrpcCallSettings.<DeleteDataObjectRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteDataObjectMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<BatchDeleteDataObjectsRequest, Empty> batchDeleteDataObjectsTransportSettings =
        GrpcCallSettings.<BatchDeleteDataObjectsRequest, Empty>newBuilder()
            .setMethodDescriptor(batchDeleteDataObjectsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListLocationsRequest, ListLocationsResponse> listLocationsTransportSettings =
        GrpcCallSettings.<ListLocationsRequest, ListLocationsResponse>newBuilder()
            .setMethodDescriptor(listLocationsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetLocationRequest, Location> getLocationTransportSettings =
        GrpcCallSettings.<GetLocationRequest, Location>newBuilder()
            .setMethodDescriptor(getLocationMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();

    this.createDataObjectCallable =
        callableFactory.createUnaryCallable(
            createDataObjectTransportSettings, settings.createDataObjectSettings(), clientContext);
    this.batchCreateDataObjectsCallable =
        callableFactory.createUnaryCallable(
            batchCreateDataObjectsTransportSettings,
            settings.batchCreateDataObjectsSettings(),
            clientContext);
    this.getDataObjectCallable =
        callableFactory.createUnaryCallable(
            getDataObjectTransportSettings, settings.getDataObjectSettings(), clientContext);
    this.updateDataObjectCallable =
        callableFactory.createUnaryCallable(
            updateDataObjectTransportSettings, settings.updateDataObjectSettings(), clientContext);
    this.batchUpdateDataObjectsCallable =
        callableFactory.createUnaryCallable(
            batchUpdateDataObjectsTransportSettings,
            settings.batchUpdateDataObjectsSettings(),
            clientContext);
    this.deleteDataObjectCallable =
        callableFactory.createUnaryCallable(
            deleteDataObjectTransportSettings, settings.deleteDataObjectSettings(), clientContext);
    this.batchDeleteDataObjectsCallable =
        callableFactory.createUnaryCallable(
            batchDeleteDataObjectsTransportSettings,
            settings.batchDeleteDataObjectsSettings(),
            clientContext);
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
  public UnaryCallable<CreateDataObjectRequest, DataObject> createDataObjectCallable() {
    return createDataObjectCallable;
  }

  @Override
  public UnaryCallable<BatchCreateDataObjectsRequest, BatchCreateDataObjectsResponse>
      batchCreateDataObjectsCallable() {
    return batchCreateDataObjectsCallable;
  }

  @Override
  public UnaryCallable<GetDataObjectRequest, DataObject> getDataObjectCallable() {
    return getDataObjectCallable;
  }

  @Override
  public UnaryCallable<UpdateDataObjectRequest, DataObject> updateDataObjectCallable() {
    return updateDataObjectCallable;
  }

  @Override
  public UnaryCallable<BatchUpdateDataObjectsRequest, BatchUpdateDataObjectsResponse>
      batchUpdateDataObjectsCallable() {
    return batchUpdateDataObjectsCallable;
  }

  @Override
  public UnaryCallable<DeleteDataObjectRequest, Empty> deleteDataObjectCallable() {
    return deleteDataObjectCallable;
  }

  @Override
  public UnaryCallable<BatchDeleteDataObjectsRequest, Empty> batchDeleteDataObjectsCallable() {
    return batchDeleteDataObjectsCallable;
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
