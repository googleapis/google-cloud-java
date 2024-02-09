/*
 * Copyright 2023 Google LLC
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

package com.google.cloud.discoveryengine.v1beta.stub;

import static com.google.cloud.discoveryengine.v1beta.DataStoreServiceClient.ListDataStoresPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.discoveryengine.v1beta.CreateDataStoreMetadata;
import com.google.cloud.discoveryengine.v1beta.CreateDataStoreRequest;
import com.google.cloud.discoveryengine.v1beta.DataStore;
import com.google.cloud.discoveryengine.v1beta.DeleteDataStoreMetadata;
import com.google.cloud.discoveryengine.v1beta.DeleteDataStoreRequest;
import com.google.cloud.discoveryengine.v1beta.GetDataStoreRequest;
import com.google.cloud.discoveryengine.v1beta.ListDataStoresRequest;
import com.google.cloud.discoveryengine.v1beta.ListDataStoresResponse;
import com.google.cloud.discoveryengine.v1beta.UpdateDataStoreRequest;
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
 * gRPC stub implementation for the DataStoreService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GrpcDataStoreServiceStub extends DataStoreServiceStub {
  private static final MethodDescriptor<CreateDataStoreRequest, Operation>
      createDataStoreMethodDescriptor =
          MethodDescriptor.<CreateDataStoreRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.discoveryengine.v1beta.DataStoreService/CreateDataStore")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateDataStoreRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetDataStoreRequest, DataStore>
      getDataStoreMethodDescriptor =
          MethodDescriptor.<GetDataStoreRequest, DataStore>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.discoveryengine.v1beta.DataStoreService/GetDataStore")
              .setRequestMarshaller(ProtoUtils.marshaller(GetDataStoreRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(DataStore.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListDataStoresRequest, ListDataStoresResponse>
      listDataStoresMethodDescriptor =
          MethodDescriptor.<ListDataStoresRequest, ListDataStoresResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.discoveryengine.v1beta.DataStoreService/ListDataStores")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListDataStoresRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListDataStoresResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteDataStoreRequest, Operation>
      deleteDataStoreMethodDescriptor =
          MethodDescriptor.<DeleteDataStoreRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.discoveryengine.v1beta.DataStoreService/DeleteDataStore")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteDataStoreRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateDataStoreRequest, DataStore>
      updateDataStoreMethodDescriptor =
          MethodDescriptor.<UpdateDataStoreRequest, DataStore>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.discoveryengine.v1beta.DataStoreService/UpdateDataStore")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateDataStoreRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(DataStore.getDefaultInstance()))
              .build();

  private final UnaryCallable<CreateDataStoreRequest, Operation> createDataStoreCallable;
  private final OperationCallable<CreateDataStoreRequest, DataStore, CreateDataStoreMetadata>
      createDataStoreOperationCallable;
  private final UnaryCallable<GetDataStoreRequest, DataStore> getDataStoreCallable;
  private final UnaryCallable<ListDataStoresRequest, ListDataStoresResponse> listDataStoresCallable;
  private final UnaryCallable<ListDataStoresRequest, ListDataStoresPagedResponse>
      listDataStoresPagedCallable;
  private final UnaryCallable<DeleteDataStoreRequest, Operation> deleteDataStoreCallable;
  private final OperationCallable<DeleteDataStoreRequest, Empty, DeleteDataStoreMetadata>
      deleteDataStoreOperationCallable;
  private final UnaryCallable<UpdateDataStoreRequest, DataStore> updateDataStoreCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcDataStoreServiceStub create(DataStoreServiceStubSettings settings)
      throws IOException {
    return new GrpcDataStoreServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcDataStoreServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcDataStoreServiceStub(
        DataStoreServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcDataStoreServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcDataStoreServiceStub(
        DataStoreServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcDataStoreServiceStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcDataStoreServiceStub(
      DataStoreServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcDataStoreServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcDataStoreServiceStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcDataStoreServiceStub(
      DataStoreServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<CreateDataStoreRequest, Operation> createDataStoreTransportSettings =
        GrpcCallSettings.<CreateDataStoreRequest, Operation>newBuilder()
            .setMethodDescriptor(createDataStoreMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetDataStoreRequest, DataStore> getDataStoreTransportSettings =
        GrpcCallSettings.<GetDataStoreRequest, DataStore>newBuilder()
            .setMethodDescriptor(getDataStoreMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListDataStoresRequest, ListDataStoresResponse>
        listDataStoresTransportSettings =
            GrpcCallSettings.<ListDataStoresRequest, ListDataStoresResponse>newBuilder()
                .setMethodDescriptor(listDataStoresMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<DeleteDataStoreRequest, Operation> deleteDataStoreTransportSettings =
        GrpcCallSettings.<DeleteDataStoreRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteDataStoreMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateDataStoreRequest, DataStore> updateDataStoreTransportSettings =
        GrpcCallSettings.<UpdateDataStoreRequest, DataStore>newBuilder()
            .setMethodDescriptor(updateDataStoreMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("data_store.name", String.valueOf(request.getDataStore().getName()));
                  return builder.build();
                })
            .build();

    this.createDataStoreCallable =
        callableFactory.createUnaryCallable(
            createDataStoreTransportSettings, settings.createDataStoreSettings(), clientContext);
    this.createDataStoreOperationCallable =
        callableFactory.createOperationCallable(
            createDataStoreTransportSettings,
            settings.createDataStoreOperationSettings(),
            clientContext,
            operationsStub);
    this.getDataStoreCallable =
        callableFactory.createUnaryCallable(
            getDataStoreTransportSettings, settings.getDataStoreSettings(), clientContext);
    this.listDataStoresCallable =
        callableFactory.createUnaryCallable(
            listDataStoresTransportSettings, settings.listDataStoresSettings(), clientContext);
    this.listDataStoresPagedCallable =
        callableFactory.createPagedCallable(
            listDataStoresTransportSettings, settings.listDataStoresSettings(), clientContext);
    this.deleteDataStoreCallable =
        callableFactory.createUnaryCallable(
            deleteDataStoreTransportSettings, settings.deleteDataStoreSettings(), clientContext);
    this.deleteDataStoreOperationCallable =
        callableFactory.createOperationCallable(
            deleteDataStoreTransportSettings,
            settings.deleteDataStoreOperationSettings(),
            clientContext,
            operationsStub);
    this.updateDataStoreCallable =
        callableFactory.createUnaryCallable(
            updateDataStoreTransportSettings, settings.updateDataStoreSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<CreateDataStoreRequest, Operation> createDataStoreCallable() {
    return createDataStoreCallable;
  }

  @Override
  public OperationCallable<CreateDataStoreRequest, DataStore, CreateDataStoreMetadata>
      createDataStoreOperationCallable() {
    return createDataStoreOperationCallable;
  }

  @Override
  public UnaryCallable<GetDataStoreRequest, DataStore> getDataStoreCallable() {
    return getDataStoreCallable;
  }

  @Override
  public UnaryCallable<ListDataStoresRequest, ListDataStoresResponse> listDataStoresCallable() {
    return listDataStoresCallable;
  }

  @Override
  public UnaryCallable<ListDataStoresRequest, ListDataStoresPagedResponse>
      listDataStoresPagedCallable() {
    return listDataStoresPagedCallable;
  }

  @Override
  public UnaryCallable<DeleteDataStoreRequest, Operation> deleteDataStoreCallable() {
    return deleteDataStoreCallable;
  }

  @Override
  public OperationCallable<DeleteDataStoreRequest, Empty, DeleteDataStoreMetadata>
      deleteDataStoreOperationCallable() {
    return deleteDataStoreOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateDataStoreRequest, DataStore> updateDataStoreCallable() {
    return updateDataStoreCallable;
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
