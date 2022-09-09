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

package com.google.cloud.dialogflow.v2.stub;

import static com.google.cloud.dialogflow.v2.EntityTypesClient.ListEntityTypesPagedResponse;
import static com.google.cloud.dialogflow.v2.EntityTypesClient.ListLocationsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.dialogflow.v2.BatchCreateEntitiesRequest;
import com.google.cloud.dialogflow.v2.BatchDeleteEntitiesRequest;
import com.google.cloud.dialogflow.v2.BatchDeleteEntityTypesRequest;
import com.google.cloud.dialogflow.v2.BatchUpdateEntitiesRequest;
import com.google.cloud.dialogflow.v2.BatchUpdateEntityTypesRequest;
import com.google.cloud.dialogflow.v2.BatchUpdateEntityTypesResponse;
import com.google.cloud.dialogflow.v2.CreateEntityTypeRequest;
import com.google.cloud.dialogflow.v2.DeleteEntityTypeRequest;
import com.google.cloud.dialogflow.v2.EntityType;
import com.google.cloud.dialogflow.v2.GetEntityTypeRequest;
import com.google.cloud.dialogflow.v2.ListEntityTypesRequest;
import com.google.cloud.dialogflow.v2.ListEntityTypesResponse;
import com.google.cloud.dialogflow.v2.UpdateEntityTypeRequest;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.common.collect.ImmutableMap;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.protobuf.Empty;
import com.google.protobuf.Struct;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the EntityTypes service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcEntityTypesStub extends EntityTypesStub {
  private static final MethodDescriptor<ListEntityTypesRequest, ListEntityTypesResponse>
      listEntityTypesMethodDescriptor =
          MethodDescriptor.<ListEntityTypesRequest, ListEntityTypesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dialogflow.v2.EntityTypes/ListEntityTypes")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListEntityTypesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListEntityTypesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetEntityTypeRequest, EntityType>
      getEntityTypeMethodDescriptor =
          MethodDescriptor.<GetEntityTypeRequest, EntityType>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dialogflow.v2.EntityTypes/GetEntityType")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetEntityTypeRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(EntityType.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateEntityTypeRequest, EntityType>
      createEntityTypeMethodDescriptor =
          MethodDescriptor.<CreateEntityTypeRequest, EntityType>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dialogflow.v2.EntityTypes/CreateEntityType")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateEntityTypeRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(EntityType.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateEntityTypeRequest, EntityType>
      updateEntityTypeMethodDescriptor =
          MethodDescriptor.<UpdateEntityTypeRequest, EntityType>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dialogflow.v2.EntityTypes/UpdateEntityType")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateEntityTypeRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(EntityType.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteEntityTypeRequest, Empty>
      deleteEntityTypeMethodDescriptor =
          MethodDescriptor.<DeleteEntityTypeRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dialogflow.v2.EntityTypes/DeleteEntityType")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteEntityTypeRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<BatchUpdateEntityTypesRequest, Operation>
      batchUpdateEntityTypesMethodDescriptor =
          MethodDescriptor.<BatchUpdateEntityTypesRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dialogflow.v2.EntityTypes/BatchUpdateEntityTypes")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(BatchUpdateEntityTypesRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<BatchDeleteEntityTypesRequest, Operation>
      batchDeleteEntityTypesMethodDescriptor =
          MethodDescriptor.<BatchDeleteEntityTypesRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dialogflow.v2.EntityTypes/BatchDeleteEntityTypes")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(BatchDeleteEntityTypesRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<BatchCreateEntitiesRequest, Operation>
      batchCreateEntitiesMethodDescriptor =
          MethodDescriptor.<BatchCreateEntitiesRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dialogflow.v2.EntityTypes/BatchCreateEntities")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(BatchCreateEntitiesRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<BatchUpdateEntitiesRequest, Operation>
      batchUpdateEntitiesMethodDescriptor =
          MethodDescriptor.<BatchUpdateEntitiesRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dialogflow.v2.EntityTypes/BatchUpdateEntities")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(BatchUpdateEntitiesRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<BatchDeleteEntitiesRequest, Operation>
      batchDeleteEntitiesMethodDescriptor =
          MethodDescriptor.<BatchDeleteEntitiesRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dialogflow.v2.EntityTypes/BatchDeleteEntities")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(BatchDeleteEntitiesRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
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

  private final UnaryCallable<ListEntityTypesRequest, ListEntityTypesResponse>
      listEntityTypesCallable;
  private final UnaryCallable<ListEntityTypesRequest, ListEntityTypesPagedResponse>
      listEntityTypesPagedCallable;
  private final UnaryCallable<GetEntityTypeRequest, EntityType> getEntityTypeCallable;
  private final UnaryCallable<CreateEntityTypeRequest, EntityType> createEntityTypeCallable;
  private final UnaryCallable<UpdateEntityTypeRequest, EntityType> updateEntityTypeCallable;
  private final UnaryCallable<DeleteEntityTypeRequest, Empty> deleteEntityTypeCallable;
  private final UnaryCallable<BatchUpdateEntityTypesRequest, Operation>
      batchUpdateEntityTypesCallable;
  private final OperationCallable<
          BatchUpdateEntityTypesRequest, BatchUpdateEntityTypesResponse, Struct>
      batchUpdateEntityTypesOperationCallable;
  private final UnaryCallable<BatchDeleteEntityTypesRequest, Operation>
      batchDeleteEntityTypesCallable;
  private final OperationCallable<BatchDeleteEntityTypesRequest, Empty, Struct>
      batchDeleteEntityTypesOperationCallable;
  private final UnaryCallable<BatchCreateEntitiesRequest, Operation> batchCreateEntitiesCallable;
  private final OperationCallable<BatchCreateEntitiesRequest, Empty, Struct>
      batchCreateEntitiesOperationCallable;
  private final UnaryCallable<BatchUpdateEntitiesRequest, Operation> batchUpdateEntitiesCallable;
  private final OperationCallable<BatchUpdateEntitiesRequest, Empty, Struct>
      batchUpdateEntitiesOperationCallable;
  private final UnaryCallable<BatchDeleteEntitiesRequest, Operation> batchDeleteEntitiesCallable;
  private final OperationCallable<BatchDeleteEntitiesRequest, Empty, Struct>
      batchDeleteEntitiesOperationCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<GetLocationRequest, Location> getLocationCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcEntityTypesStub create(EntityTypesStubSettings settings)
      throws IOException {
    return new GrpcEntityTypesStub(settings, ClientContext.create(settings));
  }

  public static final GrpcEntityTypesStub create(ClientContext clientContext) throws IOException {
    return new GrpcEntityTypesStub(EntityTypesStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcEntityTypesStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcEntityTypesStub(
        EntityTypesStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcEntityTypesStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcEntityTypesStub(EntityTypesStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcEntityTypesCallableFactory());
  }

  /**
   * Constructs an instance of GrpcEntityTypesStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcEntityTypesStub(
      EntityTypesStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<ListEntityTypesRequest, ListEntityTypesResponse>
        listEntityTypesTransportSettings =
            GrpcCallSettings.<ListEntityTypesRequest, ListEntityTypesResponse>newBuilder()
                .setMethodDescriptor(listEntityTypesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<GetEntityTypeRequest, EntityType> getEntityTypeTransportSettings =
        GrpcCallSettings.<GetEntityTypeRequest, EntityType>newBuilder()
            .setMethodDescriptor(getEntityTypeMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<CreateEntityTypeRequest, EntityType> createEntityTypeTransportSettings =
        GrpcCallSettings.<CreateEntityTypeRequest, EntityType>newBuilder()
            .setMethodDescriptor(createEntityTypeMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<UpdateEntityTypeRequest, EntityType> updateEntityTypeTransportSettings =
        GrpcCallSettings.<UpdateEntityTypeRequest, EntityType>newBuilder()
            .setMethodDescriptor(updateEntityTypeMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("entity_type.name", String.valueOf(request.getEntityType().getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<DeleteEntityTypeRequest, Empty> deleteEntityTypeTransportSettings =
        GrpcCallSettings.<DeleteEntityTypeRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteEntityTypeMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<BatchUpdateEntityTypesRequest, Operation>
        batchUpdateEntityTypesTransportSettings =
            GrpcCallSettings.<BatchUpdateEntityTypesRequest, Operation>newBuilder()
                .setMethodDescriptor(batchUpdateEntityTypesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<BatchDeleteEntityTypesRequest, Operation>
        batchDeleteEntityTypesTransportSettings =
            GrpcCallSettings.<BatchDeleteEntityTypesRequest, Operation>newBuilder()
                .setMethodDescriptor(batchDeleteEntityTypesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<BatchCreateEntitiesRequest, Operation> batchCreateEntitiesTransportSettings =
        GrpcCallSettings.<BatchCreateEntitiesRequest, Operation>newBuilder()
            .setMethodDescriptor(batchCreateEntitiesMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<BatchUpdateEntitiesRequest, Operation> batchUpdateEntitiesTransportSettings =
        GrpcCallSettings.<BatchUpdateEntitiesRequest, Operation>newBuilder()
            .setMethodDescriptor(batchUpdateEntitiesMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<BatchDeleteEntitiesRequest, Operation> batchDeleteEntitiesTransportSettings =
        GrpcCallSettings.<BatchDeleteEntitiesRequest, Operation>newBuilder()
            .setMethodDescriptor(batchDeleteEntitiesMethodDescriptor)
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

    this.listEntityTypesCallable =
        callableFactory.createUnaryCallable(
            listEntityTypesTransportSettings, settings.listEntityTypesSettings(), clientContext);
    this.listEntityTypesPagedCallable =
        callableFactory.createPagedCallable(
            listEntityTypesTransportSettings, settings.listEntityTypesSettings(), clientContext);
    this.getEntityTypeCallable =
        callableFactory.createUnaryCallable(
            getEntityTypeTransportSettings, settings.getEntityTypeSettings(), clientContext);
    this.createEntityTypeCallable =
        callableFactory.createUnaryCallable(
            createEntityTypeTransportSettings, settings.createEntityTypeSettings(), clientContext);
    this.updateEntityTypeCallable =
        callableFactory.createUnaryCallable(
            updateEntityTypeTransportSettings, settings.updateEntityTypeSettings(), clientContext);
    this.deleteEntityTypeCallable =
        callableFactory.createUnaryCallable(
            deleteEntityTypeTransportSettings, settings.deleteEntityTypeSettings(), clientContext);
    this.batchUpdateEntityTypesCallable =
        callableFactory.createUnaryCallable(
            batchUpdateEntityTypesTransportSettings,
            settings.batchUpdateEntityTypesSettings(),
            clientContext);
    this.batchUpdateEntityTypesOperationCallable =
        callableFactory.createOperationCallable(
            batchUpdateEntityTypesTransportSettings,
            settings.batchUpdateEntityTypesOperationSettings(),
            clientContext,
            operationsStub);
    this.batchDeleteEntityTypesCallable =
        callableFactory.createUnaryCallable(
            batchDeleteEntityTypesTransportSettings,
            settings.batchDeleteEntityTypesSettings(),
            clientContext);
    this.batchDeleteEntityTypesOperationCallable =
        callableFactory.createOperationCallable(
            batchDeleteEntityTypesTransportSettings,
            settings.batchDeleteEntityTypesOperationSettings(),
            clientContext,
            operationsStub);
    this.batchCreateEntitiesCallable =
        callableFactory.createUnaryCallable(
            batchCreateEntitiesTransportSettings,
            settings.batchCreateEntitiesSettings(),
            clientContext);
    this.batchCreateEntitiesOperationCallable =
        callableFactory.createOperationCallable(
            batchCreateEntitiesTransportSettings,
            settings.batchCreateEntitiesOperationSettings(),
            clientContext,
            operationsStub);
    this.batchUpdateEntitiesCallable =
        callableFactory.createUnaryCallable(
            batchUpdateEntitiesTransportSettings,
            settings.batchUpdateEntitiesSettings(),
            clientContext);
    this.batchUpdateEntitiesOperationCallable =
        callableFactory.createOperationCallable(
            batchUpdateEntitiesTransportSettings,
            settings.batchUpdateEntitiesOperationSettings(),
            clientContext,
            operationsStub);
    this.batchDeleteEntitiesCallable =
        callableFactory.createUnaryCallable(
            batchDeleteEntitiesTransportSettings,
            settings.batchDeleteEntitiesSettings(),
            clientContext);
    this.batchDeleteEntitiesOperationCallable =
        callableFactory.createOperationCallable(
            batchDeleteEntitiesTransportSettings,
            settings.batchDeleteEntitiesOperationSettings(),
            clientContext,
            operationsStub);
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
  public UnaryCallable<ListEntityTypesRequest, ListEntityTypesResponse> listEntityTypesCallable() {
    return listEntityTypesCallable;
  }

  @Override
  public UnaryCallable<ListEntityTypesRequest, ListEntityTypesPagedResponse>
      listEntityTypesPagedCallable() {
    return listEntityTypesPagedCallable;
  }

  @Override
  public UnaryCallable<GetEntityTypeRequest, EntityType> getEntityTypeCallable() {
    return getEntityTypeCallable;
  }

  @Override
  public UnaryCallable<CreateEntityTypeRequest, EntityType> createEntityTypeCallable() {
    return createEntityTypeCallable;
  }

  @Override
  public UnaryCallable<UpdateEntityTypeRequest, EntityType> updateEntityTypeCallable() {
    return updateEntityTypeCallable;
  }

  @Override
  public UnaryCallable<DeleteEntityTypeRequest, Empty> deleteEntityTypeCallable() {
    return deleteEntityTypeCallable;
  }

  @Override
  public UnaryCallable<BatchUpdateEntityTypesRequest, Operation> batchUpdateEntityTypesCallable() {
    return batchUpdateEntityTypesCallable;
  }

  @Override
  public OperationCallable<BatchUpdateEntityTypesRequest, BatchUpdateEntityTypesResponse, Struct>
      batchUpdateEntityTypesOperationCallable() {
    return batchUpdateEntityTypesOperationCallable;
  }

  @Override
  public UnaryCallable<BatchDeleteEntityTypesRequest, Operation> batchDeleteEntityTypesCallable() {
    return batchDeleteEntityTypesCallable;
  }

  @Override
  public OperationCallable<BatchDeleteEntityTypesRequest, Empty, Struct>
      batchDeleteEntityTypesOperationCallable() {
    return batchDeleteEntityTypesOperationCallable;
  }

  @Override
  public UnaryCallable<BatchCreateEntitiesRequest, Operation> batchCreateEntitiesCallable() {
    return batchCreateEntitiesCallable;
  }

  @Override
  public OperationCallable<BatchCreateEntitiesRequest, Empty, Struct>
      batchCreateEntitiesOperationCallable() {
    return batchCreateEntitiesOperationCallable;
  }

  @Override
  public UnaryCallable<BatchUpdateEntitiesRequest, Operation> batchUpdateEntitiesCallable() {
    return batchUpdateEntitiesCallable;
  }

  @Override
  public OperationCallable<BatchUpdateEntitiesRequest, Empty, Struct>
      batchUpdateEntitiesOperationCallable() {
    return batchUpdateEntitiesOperationCallable;
  }

  @Override
  public UnaryCallable<BatchDeleteEntitiesRequest, Operation> batchDeleteEntitiesCallable() {
    return batchDeleteEntitiesCallable;
  }

  @Override
  public OperationCallable<BatchDeleteEntitiesRequest, Empty, Struct>
      batchDeleteEntitiesOperationCallable() {
    return batchDeleteEntitiesOperationCallable;
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
