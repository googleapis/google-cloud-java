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
import com.google.api.core.InternalApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.httpjson.ApiMethodDescriptor;
import com.google.api.gax.httpjson.HttpJsonCallSettings;
import com.google.api.gax.httpjson.HttpJsonOperationSnapshot;
import com.google.api.gax.httpjson.HttpJsonStubCallableFactory;
import com.google.api.gax.httpjson.ProtoMessageRequestFormatter;
import com.google.api.gax.httpjson.ProtoMessageResponseParser;
import com.google.api.gax.httpjson.ProtoRestSerializer;
import com.google.api.gax.httpjson.longrunning.stub.HttpJsonOperationsStub;
import com.google.api.gax.longrunning.OperationSnapshot;
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
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import com.google.protobuf.TypeRegistry;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * REST stub implementation for the CatalogService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class HttpJsonCatalogServiceStub extends CatalogServiceStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder()
          .add(ImportCatalogItemsResponse.getDescriptor())
          .add(ImportMetadata.getDescriptor())
          .build();

  private static final ApiMethodDescriptor<CreateCatalogItemRequest, CatalogItem>
      createCatalogItemMethodDescriptor =
          ApiMethodDescriptor.<CreateCatalogItemRequest, CatalogItem>newBuilder()
              .setFullMethodName(
                  "google.cloud.recommendationengine.v1beta1.CatalogService/CreateCatalogItem")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateCatalogItemRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{parent=projects/*/locations/*/catalogs/*}/catalogItems",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateCatalogItemRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateCatalogItemRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("catalogItem", request.getCatalogItem(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<CatalogItem>newBuilder()
                      .setDefaultInstance(CatalogItem.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetCatalogItemRequest, CatalogItem>
      getCatalogItemMethodDescriptor =
          ApiMethodDescriptor.<GetCatalogItemRequest, CatalogItem>newBuilder()
              .setFullMethodName(
                  "google.cloud.recommendationengine.v1beta1.CatalogService/GetCatalogItem")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetCatalogItemRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{name=projects/*/locations/*/catalogs/*/catalogItems/**}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetCatalogItemRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetCatalogItemRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<CatalogItem>newBuilder()
                      .setDefaultInstance(CatalogItem.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListCatalogItemsRequest, ListCatalogItemsResponse>
      listCatalogItemsMethodDescriptor =
          ApiMethodDescriptor.<ListCatalogItemsRequest, ListCatalogItemsResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.recommendationengine.v1beta1.CatalogService/ListCatalogItems")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListCatalogItemsRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{parent=projects/*/locations/*/catalogs/*}/catalogItems",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListCatalogItemsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListCatalogItemsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListCatalogItemsResponse>newBuilder()
                      .setDefaultInstance(ListCatalogItemsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateCatalogItemRequest, CatalogItem>
      updateCatalogItemMethodDescriptor =
          ApiMethodDescriptor.<UpdateCatalogItemRequest, CatalogItem>newBuilder()
              .setFullMethodName(
                  "google.cloud.recommendationengine.v1beta1.CatalogService/UpdateCatalogItem")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateCatalogItemRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{name=projects/*/locations/*/catalogs/*/catalogItems/**}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateCatalogItemRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateCatalogItemRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("catalogItem", request.getCatalogItem(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<CatalogItem>newBuilder()
                      .setDefaultInstance(CatalogItem.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteCatalogItemRequest, Empty>
      deleteCatalogItemMethodDescriptor =
          ApiMethodDescriptor.<DeleteCatalogItemRequest, Empty>newBuilder()
              .setFullMethodName(
                  "google.cloud.recommendationengine.v1beta1.CatalogService/DeleteCatalogItem")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteCatalogItemRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{name=projects/*/locations/*/catalogs/*/catalogItems/**}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteCatalogItemRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteCatalogItemRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Empty>newBuilder()
                      .setDefaultInstance(Empty.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ImportCatalogItemsRequest, Operation>
      importCatalogItemsMethodDescriptor =
          ApiMethodDescriptor.<ImportCatalogItemsRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.recommendationengine.v1beta1.CatalogService/ImportCatalogItems")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ImportCatalogItemsRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{parent=projects/*/locations/*/catalogs/*}/catalogItems:import",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ImportCatalogItemsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ImportCatalogItemsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearParent().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (ImportCatalogItemsRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
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
  private final HttpJsonOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonCatalogServiceStub create(CatalogServiceStubSettings settings)
      throws IOException {
    return new HttpJsonCatalogServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonCatalogServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonCatalogServiceStub(
        CatalogServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonCatalogServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonCatalogServiceStub(
        CatalogServiceStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonCatalogServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonCatalogServiceStub(
      CatalogServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonCatalogServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonCatalogServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonCatalogServiceStub(
      CatalogServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.httpJsonOperationsStub =
        HttpJsonOperationsStub.create(clientContext, callableFactory, typeRegistry);

    HttpJsonCallSettings<CreateCatalogItemRequest, CatalogItem> createCatalogItemTransportSettings =
        HttpJsonCallSettings.<CreateCatalogItemRequest, CatalogItem>newBuilder()
            .setMethodDescriptor(createCatalogItemMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<GetCatalogItemRequest, CatalogItem> getCatalogItemTransportSettings =
        HttpJsonCallSettings.<GetCatalogItemRequest, CatalogItem>newBuilder()
            .setMethodDescriptor(getCatalogItemMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ListCatalogItemsRequest, ListCatalogItemsResponse>
        listCatalogItemsTransportSettings =
            HttpJsonCallSettings.<ListCatalogItemsRequest, ListCatalogItemsResponse>newBuilder()
                .setMethodDescriptor(listCatalogItemsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<UpdateCatalogItemRequest, CatalogItem> updateCatalogItemTransportSettings =
        HttpJsonCallSettings.<UpdateCatalogItemRequest, CatalogItem>newBuilder()
            .setMethodDescriptor(updateCatalogItemMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<DeleteCatalogItemRequest, Empty> deleteCatalogItemTransportSettings =
        HttpJsonCallSettings.<DeleteCatalogItemRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteCatalogItemMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ImportCatalogItemsRequest, Operation> importCatalogItemsTransportSettings =
        HttpJsonCallSettings.<ImportCatalogItemsRequest, Operation>newBuilder()
            .setMethodDescriptor(importCatalogItemsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
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
            httpJsonOperationsStub);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(createCatalogItemMethodDescriptor);
    methodDescriptors.add(getCatalogItemMethodDescriptor);
    methodDescriptors.add(listCatalogItemsMethodDescriptor);
    methodDescriptors.add(updateCatalogItemMethodDescriptor);
    methodDescriptors.add(deleteCatalogItemMethodDescriptor);
    methodDescriptors.add(importCatalogItemsMethodDescriptor);
    return methodDescriptors;
  }

  public HttpJsonOperationsStub getHttpJsonOperationsStub() {
    return httpJsonOperationsStub;
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
