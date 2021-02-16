/*
 * Copyright 2020 Google LLC
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

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.RequestParamsExtractor;
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
                    new RequestParamsExtractor<ListEntityTypesRequest>() {
                      @Override
                      public Map<String, String> extract(ListEntityTypesRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("parent", String.valueOf(request.getParent()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<GetEntityTypeRequest, EntityType> getEntityTypeTransportSettings =
        GrpcCallSettings.<GetEntityTypeRequest, EntityType>newBuilder()
            .setMethodDescriptor(getEntityTypeMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<GetEntityTypeRequest>() {
                  @Override
                  public Map<String, String> extract(GetEntityTypeRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<CreateEntityTypeRequest, EntityType> createEntityTypeTransportSettings =
        GrpcCallSettings.<CreateEntityTypeRequest, EntityType>newBuilder()
            .setMethodDescriptor(createEntityTypeMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<CreateEntityTypeRequest>() {
                  @Override
                  public Map<String, String> extract(CreateEntityTypeRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("parent", String.valueOf(request.getParent()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<UpdateEntityTypeRequest, EntityType> updateEntityTypeTransportSettings =
        GrpcCallSettings.<UpdateEntityTypeRequest, EntityType>newBuilder()
            .setMethodDescriptor(updateEntityTypeMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<UpdateEntityTypeRequest>() {
                  @Override
                  public Map<String, String> extract(UpdateEntityTypeRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put(
                        "entity_type.name", String.valueOf(request.getEntityType().getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<DeleteEntityTypeRequest, Empty> deleteEntityTypeTransportSettings =
        GrpcCallSettings.<DeleteEntityTypeRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteEntityTypeMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<DeleteEntityTypeRequest>() {
                  @Override
                  public Map<String, String> extract(DeleteEntityTypeRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<BatchUpdateEntityTypesRequest, Operation>
        batchUpdateEntityTypesTransportSettings =
            GrpcCallSettings.<BatchUpdateEntityTypesRequest, Operation>newBuilder()
                .setMethodDescriptor(batchUpdateEntityTypesMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<BatchUpdateEntityTypesRequest>() {
                      @Override
                      public Map<String, String> extract(BatchUpdateEntityTypesRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("parent", String.valueOf(request.getParent()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<BatchDeleteEntityTypesRequest, Operation>
        batchDeleteEntityTypesTransportSettings =
            GrpcCallSettings.<BatchDeleteEntityTypesRequest, Operation>newBuilder()
                .setMethodDescriptor(batchDeleteEntityTypesMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<BatchDeleteEntityTypesRequest>() {
                      @Override
                      public Map<String, String> extract(BatchDeleteEntityTypesRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("parent", String.valueOf(request.getParent()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<BatchCreateEntitiesRequest, Operation> batchCreateEntitiesTransportSettings =
        GrpcCallSettings.<BatchCreateEntitiesRequest, Operation>newBuilder()
            .setMethodDescriptor(batchCreateEntitiesMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<BatchCreateEntitiesRequest>() {
                  @Override
                  public Map<String, String> extract(BatchCreateEntitiesRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("parent", String.valueOf(request.getParent()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<BatchUpdateEntitiesRequest, Operation> batchUpdateEntitiesTransportSettings =
        GrpcCallSettings.<BatchUpdateEntitiesRequest, Operation>newBuilder()
            .setMethodDescriptor(batchUpdateEntitiesMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<BatchUpdateEntitiesRequest>() {
                  @Override
                  public Map<String, String> extract(BatchUpdateEntitiesRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("parent", String.valueOf(request.getParent()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<BatchDeleteEntitiesRequest, Operation> batchDeleteEntitiesTransportSettings =
        GrpcCallSettings.<BatchDeleteEntitiesRequest, Operation>newBuilder()
            .setMethodDescriptor(batchDeleteEntitiesMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<BatchDeleteEntitiesRequest>() {
                  @Override
                  public Map<String, String> extract(BatchDeleteEntitiesRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("parent", String.valueOf(request.getParent()));
                    return params.build();
                  }
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

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  public UnaryCallable<ListEntityTypesRequest, ListEntityTypesResponse> listEntityTypesCallable() {
    return listEntityTypesCallable;
  }

  public UnaryCallable<ListEntityTypesRequest, ListEntityTypesPagedResponse>
      listEntityTypesPagedCallable() {
    return listEntityTypesPagedCallable;
  }

  public UnaryCallable<GetEntityTypeRequest, EntityType> getEntityTypeCallable() {
    return getEntityTypeCallable;
  }

  public UnaryCallable<CreateEntityTypeRequest, EntityType> createEntityTypeCallable() {
    return createEntityTypeCallable;
  }

  public UnaryCallable<UpdateEntityTypeRequest, EntityType> updateEntityTypeCallable() {
    return updateEntityTypeCallable;
  }

  public UnaryCallable<DeleteEntityTypeRequest, Empty> deleteEntityTypeCallable() {
    return deleteEntityTypeCallable;
  }

  public UnaryCallable<BatchUpdateEntityTypesRequest, Operation> batchUpdateEntityTypesCallable() {
    return batchUpdateEntityTypesCallable;
  }

  public OperationCallable<BatchUpdateEntityTypesRequest, BatchUpdateEntityTypesResponse, Struct>
      batchUpdateEntityTypesOperationCallable() {
    return batchUpdateEntityTypesOperationCallable;
  }

  public UnaryCallable<BatchDeleteEntityTypesRequest, Operation> batchDeleteEntityTypesCallable() {
    return batchDeleteEntityTypesCallable;
  }

  public OperationCallable<BatchDeleteEntityTypesRequest, Empty, Struct>
      batchDeleteEntityTypesOperationCallable() {
    return batchDeleteEntityTypesOperationCallable;
  }

  public UnaryCallable<BatchCreateEntitiesRequest, Operation> batchCreateEntitiesCallable() {
    return batchCreateEntitiesCallable;
  }

  public OperationCallable<BatchCreateEntitiesRequest, Empty, Struct>
      batchCreateEntitiesOperationCallable() {
    return batchCreateEntitiesOperationCallable;
  }

  public UnaryCallable<BatchUpdateEntitiesRequest, Operation> batchUpdateEntitiesCallable() {
    return batchUpdateEntitiesCallable;
  }

  public OperationCallable<BatchUpdateEntitiesRequest, Empty, Struct>
      batchUpdateEntitiesOperationCallable() {
    return batchUpdateEntitiesOperationCallable;
  }

  public UnaryCallable<BatchDeleteEntitiesRequest, Operation> batchDeleteEntitiesCallable() {
    return batchDeleteEntitiesCallable;
  }

  public OperationCallable<BatchDeleteEntitiesRequest, Empty, Struct>
      batchDeleteEntitiesOperationCallable() {
    return batchDeleteEntitiesOperationCallable;
  }

  @Override
  public final void close() {
    shutdown();
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
