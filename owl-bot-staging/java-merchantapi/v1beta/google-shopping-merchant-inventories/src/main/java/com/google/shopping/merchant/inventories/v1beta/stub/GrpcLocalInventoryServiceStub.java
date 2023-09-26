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

package com.google.shopping.merchant.inventories.v1beta.stub;

import static com.google.shopping.merchant.inventories.v1beta.LocalInventoryServiceClient.ListLocalInventoriesPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.protobuf.Empty;
import com.google.shopping.merchant.inventories.v1beta.DeleteLocalInventoryRequest;
import com.google.shopping.merchant.inventories.v1beta.InsertLocalInventoryRequest;
import com.google.shopping.merchant.inventories.v1beta.ListLocalInventoriesRequest;
import com.google.shopping.merchant.inventories.v1beta.ListLocalInventoriesResponse;
import com.google.shopping.merchant.inventories.v1beta.LocalInventory;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the LocalInventoryService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GrpcLocalInventoryServiceStub extends LocalInventoryServiceStub {
  private static final MethodDescriptor<ListLocalInventoriesRequest, ListLocalInventoriesResponse>
      listLocalInventoriesMethodDescriptor =
          MethodDescriptor.<ListLocalInventoriesRequest, ListLocalInventoriesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.shopping.merchant.inventories.v1beta.LocalInventoryService/ListLocalInventories")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListLocalInventoriesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListLocalInventoriesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<InsertLocalInventoryRequest, LocalInventory>
      insertLocalInventoryMethodDescriptor =
          MethodDescriptor.<InsertLocalInventoryRequest, LocalInventory>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.shopping.merchant.inventories.v1beta.LocalInventoryService/InsertLocalInventory")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(InsertLocalInventoryRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(LocalInventory.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteLocalInventoryRequest, Empty>
      deleteLocalInventoryMethodDescriptor =
          MethodDescriptor.<DeleteLocalInventoryRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.shopping.merchant.inventories.v1beta.LocalInventoryService/DeleteLocalInventory")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteLocalInventoryRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private final UnaryCallable<ListLocalInventoriesRequest, ListLocalInventoriesResponse>
      listLocalInventoriesCallable;
  private final UnaryCallable<ListLocalInventoriesRequest, ListLocalInventoriesPagedResponse>
      listLocalInventoriesPagedCallable;
  private final UnaryCallable<InsertLocalInventoryRequest, LocalInventory>
      insertLocalInventoryCallable;
  private final UnaryCallable<DeleteLocalInventoryRequest, Empty> deleteLocalInventoryCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcLocalInventoryServiceStub create(
      LocalInventoryServiceStubSettings settings) throws IOException {
    return new GrpcLocalInventoryServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcLocalInventoryServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcLocalInventoryServiceStub(
        LocalInventoryServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcLocalInventoryServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcLocalInventoryServiceStub(
        LocalInventoryServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcLocalInventoryServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcLocalInventoryServiceStub(
      LocalInventoryServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcLocalInventoryServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcLocalInventoryServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcLocalInventoryServiceStub(
      LocalInventoryServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<ListLocalInventoriesRequest, ListLocalInventoriesResponse>
        listLocalInventoriesTransportSettings =
            GrpcCallSettings.<ListLocalInventoriesRequest, ListLocalInventoriesResponse>newBuilder()
                .setMethodDescriptor(listLocalInventoriesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<InsertLocalInventoryRequest, LocalInventory>
        insertLocalInventoryTransportSettings =
            GrpcCallSettings.<InsertLocalInventoryRequest, LocalInventory>newBuilder()
                .setMethodDescriptor(insertLocalInventoryMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<DeleteLocalInventoryRequest, Empty> deleteLocalInventoryTransportSettings =
        GrpcCallSettings.<DeleteLocalInventoryRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteLocalInventoryMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();

    this.listLocalInventoriesCallable =
        callableFactory.createUnaryCallable(
            listLocalInventoriesTransportSettings,
            settings.listLocalInventoriesSettings(),
            clientContext);
    this.listLocalInventoriesPagedCallable =
        callableFactory.createPagedCallable(
            listLocalInventoriesTransportSettings,
            settings.listLocalInventoriesSettings(),
            clientContext);
    this.insertLocalInventoryCallable =
        callableFactory.createUnaryCallable(
            insertLocalInventoryTransportSettings,
            settings.insertLocalInventorySettings(),
            clientContext);
    this.deleteLocalInventoryCallable =
        callableFactory.createUnaryCallable(
            deleteLocalInventoryTransportSettings,
            settings.deleteLocalInventorySettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<ListLocalInventoriesRequest, ListLocalInventoriesResponse>
      listLocalInventoriesCallable() {
    return listLocalInventoriesCallable;
  }

  @Override
  public UnaryCallable<ListLocalInventoriesRequest, ListLocalInventoriesPagedResponse>
      listLocalInventoriesPagedCallable() {
    return listLocalInventoriesPagedCallable;
  }

  @Override
  public UnaryCallable<InsertLocalInventoryRequest, LocalInventory> insertLocalInventoryCallable() {
    return insertLocalInventoryCallable;
  }

  @Override
  public UnaryCallable<DeleteLocalInventoryRequest, Empty> deleteLocalInventoryCallable() {
    return deleteLocalInventoryCallable;
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
