/*
 * Copyright 2024 Google LLC
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

import static com.google.shopping.merchant.inventories.v1beta.RegionalInventoryServiceClient.ListRegionalInventoriesPagedResponse;

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
import com.google.shopping.merchant.inventories.v1beta.DeleteRegionalInventoryRequest;
import com.google.shopping.merchant.inventories.v1beta.InsertRegionalInventoryRequest;
import com.google.shopping.merchant.inventories.v1beta.ListRegionalInventoriesRequest;
import com.google.shopping.merchant.inventories.v1beta.ListRegionalInventoriesResponse;
import com.google.shopping.merchant.inventories.v1beta.RegionalInventory;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the RegionalInventoryService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GrpcRegionalInventoryServiceStub extends RegionalInventoryServiceStub {
  private static final MethodDescriptor<
          ListRegionalInventoriesRequest, ListRegionalInventoriesResponse>
      listRegionalInventoriesMethodDescriptor =
          MethodDescriptor
              .<ListRegionalInventoriesRequest, ListRegionalInventoriesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.shopping.merchant.inventories.v1beta.RegionalInventoryService/ListRegionalInventories")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListRegionalInventoriesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListRegionalInventoriesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<InsertRegionalInventoryRequest, RegionalInventory>
      insertRegionalInventoryMethodDescriptor =
          MethodDescriptor.<InsertRegionalInventoryRequest, RegionalInventory>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.shopping.merchant.inventories.v1beta.RegionalInventoryService/InsertRegionalInventory")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(InsertRegionalInventoryRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(RegionalInventory.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteRegionalInventoryRequest, Empty>
      deleteRegionalInventoryMethodDescriptor =
          MethodDescriptor.<DeleteRegionalInventoryRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.shopping.merchant.inventories.v1beta.RegionalInventoryService/DeleteRegionalInventory")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteRegionalInventoryRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private final UnaryCallable<ListRegionalInventoriesRequest, ListRegionalInventoriesResponse>
      listRegionalInventoriesCallable;
  private final UnaryCallable<ListRegionalInventoriesRequest, ListRegionalInventoriesPagedResponse>
      listRegionalInventoriesPagedCallable;
  private final UnaryCallable<InsertRegionalInventoryRequest, RegionalInventory>
      insertRegionalInventoryCallable;
  private final UnaryCallable<DeleteRegionalInventoryRequest, Empty>
      deleteRegionalInventoryCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcRegionalInventoryServiceStub create(
      RegionalInventoryServiceStubSettings settings) throws IOException {
    return new GrpcRegionalInventoryServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcRegionalInventoryServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcRegionalInventoryServiceStub(
        RegionalInventoryServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcRegionalInventoryServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcRegionalInventoryServiceStub(
        RegionalInventoryServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcRegionalInventoryServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcRegionalInventoryServiceStub(
      RegionalInventoryServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcRegionalInventoryServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcRegionalInventoryServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcRegionalInventoryServiceStub(
      RegionalInventoryServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<ListRegionalInventoriesRequest, ListRegionalInventoriesResponse>
        listRegionalInventoriesTransportSettings =
            GrpcCallSettings
                .<ListRegionalInventoriesRequest, ListRegionalInventoriesResponse>newBuilder()
                .setMethodDescriptor(listRegionalInventoriesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<InsertRegionalInventoryRequest, RegionalInventory>
        insertRegionalInventoryTransportSettings =
            GrpcCallSettings.<InsertRegionalInventoryRequest, RegionalInventory>newBuilder()
                .setMethodDescriptor(insertRegionalInventoryMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<DeleteRegionalInventoryRequest, Empty>
        deleteRegionalInventoryTransportSettings =
            GrpcCallSettings.<DeleteRegionalInventoryRequest, Empty>newBuilder()
                .setMethodDescriptor(deleteRegionalInventoryMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();

    this.listRegionalInventoriesCallable =
        callableFactory.createUnaryCallable(
            listRegionalInventoriesTransportSettings,
            settings.listRegionalInventoriesSettings(),
            clientContext);
    this.listRegionalInventoriesPagedCallable =
        callableFactory.createPagedCallable(
            listRegionalInventoriesTransportSettings,
            settings.listRegionalInventoriesSettings(),
            clientContext);
    this.insertRegionalInventoryCallable =
        callableFactory.createUnaryCallable(
            insertRegionalInventoryTransportSettings,
            settings.insertRegionalInventorySettings(),
            clientContext);
    this.deleteRegionalInventoryCallable =
        callableFactory.createUnaryCallable(
            deleteRegionalInventoryTransportSettings,
            settings.deleteRegionalInventorySettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<ListRegionalInventoriesRequest, ListRegionalInventoriesResponse>
      listRegionalInventoriesCallable() {
    return listRegionalInventoriesCallable;
  }

  @Override
  public UnaryCallable<ListRegionalInventoriesRequest, ListRegionalInventoriesPagedResponse>
      listRegionalInventoriesPagedCallable() {
    return listRegionalInventoriesPagedCallable;
  }

  @Override
  public UnaryCallable<InsertRegionalInventoryRequest, RegionalInventory>
      insertRegionalInventoryCallable() {
    return insertRegionalInventoryCallable;
  }

  @Override
  public UnaryCallable<DeleteRegionalInventoryRequest, Empty> deleteRegionalInventoryCallable() {
    return deleteRegionalInventoryCallable;
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
