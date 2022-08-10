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

package com.google.cloud.recommendationengine.v1beta1.stub;

import static com.google.cloud.recommendationengine.v1beta1.CatalogServiceClient.ListCatalogItemsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.recommendationengine.v1beta1.CatalogItem;
import com.google.cloud.recommendationengine.v1beta1.CreateCatalogItemRequest;
import com.google.cloud.recommendationengine.v1beta1.DeleteCatalogItemRequest;
import com.google.cloud.recommendationengine.v1beta1.GetCatalogItemRequest;
import com.google.cloud.recommendationengine.v1beta1.ImportCatalogItemsRequest;
import com.google.cloud.recommendationengine.v1beta1.ImportCatalogItemsResponse;
import com.google.cloud.recommendationengine.v1beta1.ImportMetadata;
import com.google.cloud.recommendationengine.v1beta1.ListCatalogItemsRequest;
import com.google.cloud.recommendationengine.v1beta1.ListCatalogItemsResponse;
import com.google.cloud.recommendationengine.v1beta1.UpdateCatalogItemRequest;
import com.google.common.collect.ImmutableMap;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.protobuf.Empty;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the CatalogService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GrpcCatalogServiceStub extends CatalogServiceStub {
  private static final MethodDescriptor<CreateCatalogItemRequest, CatalogItem>
      createCatalogItemMethodDescriptor =
          MethodDescriptor.<CreateCatalogItemRequest, CatalogItem>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.recommendationengine.v1beta1.CatalogService/CreateCatalogItem")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateCatalogItemRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(CatalogItem.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetCatalogItemRequest, CatalogItem>
      getCatalogItemMethodDescriptor =
          MethodDescriptor.<GetCatalogItemRequest, CatalogItem>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.recommendationengine.v1beta1.CatalogService/GetCatalogItem")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetCatalogItemRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(CatalogItem.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListCatalogItemsRequest, ListCatalogItemsResponse>
      listCatalogItemsMethodDescriptor =
          MethodDescriptor.<ListCatalogItemsRequest, ListCatalogItemsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.recommendationengine.v1beta1.CatalogService/ListCatalogItems")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListCatalogItemsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListCatalogItemsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateCatalogItemRequest, CatalogItem>
      updateCatalogItemMethodDescriptor =
          MethodDescriptor.<UpdateCatalogItemRequest, CatalogItem>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.recommendationengine.v1beta1.CatalogService/UpdateCatalogItem")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateCatalogItemRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(CatalogItem.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteCatalogItemRequest, Empty>
      deleteCatalogItemMethodDescriptor =
          MethodDescriptor.<DeleteCatalogItemRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.recommendationengine.v1beta1.CatalogService/DeleteCatalogItem")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteCatalogItemRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ImportCatalogItemsRequest, Operation>
      importCatalogItemsMethodDescriptor =
          MethodDescriptor.<ImportCatalogItemsRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.recommendationengine.v1beta1.CatalogService/ImportCatalogItems")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ImportCatalogItemsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private final UnaryCallable<CreateCatalogItemRequest, CatalogItem> createCatalogItemCallable;
  private final UnaryCallable<GetCatalogItemRequest, CatalogItem> getCatalogItemCallable;
  private final UnaryCallable<ListCatalogItemsRequest, ListCatalogItemsResponse>
      listCatalogItemsCallable;
  private final UnaryCallable<ListCatalogItemsRequest, ListCatalogItemsPagedResponse>
      listCatalogItemsPagedCallable;
  private final UnaryCallable<UpdateCatalogItemRequest, CatalogItem> updateCatalogItemCallable;
  private final UnaryCallable<DeleteCatalogItemRequest, Empty> deleteCatalogItemCallable;
  private final UnaryCallable<ImportCatalogItemsRequest, Operation> importCatalogItemsCallable;
  private final OperationCallable<
          ImportCatalogItemsRequest, ImportCatalogItemsResponse, ImportMetadata>
      importCatalogItemsOperationCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcCatalogServiceStub create(CatalogServiceStubSettings settings)
      throws IOException {
    return new GrpcCatalogServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcCatalogServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcCatalogServiceStub(
        CatalogServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcCatalogServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcCatalogServiceStub(
        CatalogServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcCatalogServiceStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcCatalogServiceStub(CatalogServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcCatalogServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcCatalogServiceStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcCatalogServiceStub(
      CatalogServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<CreateCatalogItemRequest, CatalogItem> createCatalogItemTransportSettings =
        GrpcCallSettings.<CreateCatalogItemRequest, CatalogItem>newBuilder()
            .setMethodDescriptor(createCatalogItemMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<GetCatalogItemRequest, CatalogItem> getCatalogItemTransportSettings =
        GrpcCallSettings.<GetCatalogItemRequest, CatalogItem>newBuilder()
            .setMethodDescriptor(getCatalogItemMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<ListCatalogItemsRequest, ListCatalogItemsResponse>
        listCatalogItemsTransportSettings =
            GrpcCallSettings.<ListCatalogItemsRequest, ListCatalogItemsResponse>newBuilder()
                .setMethodDescriptor(listCatalogItemsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<UpdateCatalogItemRequest, CatalogItem> updateCatalogItemTransportSettings =
        GrpcCallSettings.<UpdateCatalogItemRequest, CatalogItem>newBuilder()
            .setMethodDescriptor(updateCatalogItemMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<DeleteCatalogItemRequest, Empty> deleteCatalogItemTransportSettings =
        GrpcCallSettings.<DeleteCatalogItemRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteCatalogItemMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<ImportCatalogItemsRequest, Operation> importCatalogItemsTransportSettings =
        GrpcCallSettings.<ImportCatalogItemsRequest, Operation>newBuilder()
            .setMethodDescriptor(importCatalogItemsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();

    this.createCatalogItemCallable =
        callableFactory.createUnaryCallable(
            createCatalogItemTransportSettings,
            settings.createCatalogItemSettings(),
            clientContext);
    this.getCatalogItemCallable =
        callableFactory.createUnaryCallable(
            getCatalogItemTransportSettings, settings.getCatalogItemSettings(), clientContext);
    this.listCatalogItemsCallable =
        callableFactory.createUnaryCallable(
            listCatalogItemsTransportSettings, settings.listCatalogItemsSettings(), clientContext);
    this.listCatalogItemsPagedCallable =
        callableFactory.createPagedCallable(
            listCatalogItemsTransportSettings, settings.listCatalogItemsSettings(), clientContext);
    this.updateCatalogItemCallable =
        callableFactory.createUnaryCallable(
            updateCatalogItemTransportSettings,
            settings.updateCatalogItemSettings(),
            clientContext);
    this.deleteCatalogItemCallable =
        callableFactory.createUnaryCallable(
            deleteCatalogItemTransportSettings,
            settings.deleteCatalogItemSettings(),
            clientContext);
    this.importCatalogItemsCallable =
        callableFactory.createUnaryCallable(
            importCatalogItemsTransportSettings,
            settings.importCatalogItemsSettings(),
            clientContext);
    this.importCatalogItemsOperationCallable =
        callableFactory.createOperationCallable(
            importCatalogItemsTransportSettings,
            settings.importCatalogItemsOperationSettings(),
            clientContext,
            operationsStub);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<CreateCatalogItemRequest, CatalogItem> createCatalogItemCallable() {
    return createCatalogItemCallable;
  }

  @Override
  public UnaryCallable<GetCatalogItemRequest, CatalogItem> getCatalogItemCallable() {
    return getCatalogItemCallable;
  }

  @Override
  public UnaryCallable<ListCatalogItemsRequest, ListCatalogItemsResponse>
      listCatalogItemsCallable() {
    return listCatalogItemsCallable;
  }

  @Override
  public UnaryCallable<ListCatalogItemsRequest, ListCatalogItemsPagedResponse>
      listCatalogItemsPagedCallable() {
    return listCatalogItemsPagedCallable;
  }

  @Override
  public UnaryCallable<UpdateCatalogItemRequest, CatalogItem> updateCatalogItemCallable() {
    return updateCatalogItemCallable;
  }

  @Override
  public UnaryCallable<DeleteCatalogItemRequest, Empty> deleteCatalogItemCallable() {
    return deleteCatalogItemCallable;
  }

  @Override
  public UnaryCallable<ImportCatalogItemsRequest, Operation> importCatalogItemsCallable() {
    return importCatalogItemsCallable;
  }

  @Override
  public OperationCallable<ImportCatalogItemsRequest, ImportCatalogItemsResponse, ImportMetadata>
      importCatalogItemsOperationCallable() {
    return importCatalogItemsOperationCallable;
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
