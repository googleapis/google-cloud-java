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
import com.google.api.core.InternalApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.httpjson.ApiMethodDescriptor;
import com.google.api.gax.httpjson.HttpJsonCallSettings;
import com.google.api.gax.httpjson.HttpJsonStubCallableFactory;
import com.google.api.gax.httpjson.ProtoMessageRequestFormatter;
import com.google.api.gax.httpjson.ProtoMessageResponseParser;
import com.google.api.gax.httpjson.ProtoRestSerializer;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.protobuf.Empty;
import com.google.protobuf.TypeRegistry;
import com.google.shopping.merchant.inventories.v1beta.DeleteLocalInventoryRequest;
import com.google.shopping.merchant.inventories.v1beta.InsertLocalInventoryRequest;
import com.google.shopping.merchant.inventories.v1beta.ListLocalInventoriesRequest;
import com.google.shopping.merchant.inventories.v1beta.ListLocalInventoriesResponse;
import com.google.shopping.merchant.inventories.v1beta.LocalInventory;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * REST stub implementation for the LocalInventoryService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class HttpJsonLocalInventoryServiceStub extends LocalInventoryServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<
          ListLocalInventoriesRequest, ListLocalInventoriesResponse>
      listLocalInventoriesMethodDescriptor =
          ApiMethodDescriptor
              .<ListLocalInventoriesRequest, ListLocalInventoriesResponse>newBuilder()
              .setFullMethodName(
                  "google.shopping.merchant.inventories.v1beta.LocalInventoryService/ListLocalInventories")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListLocalInventoriesRequest>newBuilder()
                      .setPath(
                          "/inventories/v1beta/{parent=accounts/*/products/*}/localInventories",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListLocalInventoriesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListLocalInventoriesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListLocalInventoriesResponse>newBuilder()
                      .setDefaultInstance(ListLocalInventoriesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<InsertLocalInventoryRequest, LocalInventory>
      insertLocalInventoryMethodDescriptor =
          ApiMethodDescriptor.<InsertLocalInventoryRequest, LocalInventory>newBuilder()
              .setFullMethodName(
                  "google.shopping.merchant.inventories.v1beta.LocalInventoryService/InsertLocalInventory")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<InsertLocalInventoryRequest>newBuilder()
                      .setPath(
                          "/inventories/v1beta/{parent=accounts/*/products/*}/localInventories:insert",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<InsertLocalInventoryRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<InsertLocalInventoryRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("localInventory", request.getLocalInventory(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<LocalInventory>newBuilder()
                      .setDefaultInstance(LocalInventory.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteLocalInventoryRequest, Empty>
      deleteLocalInventoryMethodDescriptor =
          ApiMethodDescriptor.<DeleteLocalInventoryRequest, Empty>newBuilder()
              .setFullMethodName(
                  "google.shopping.merchant.inventories.v1beta.LocalInventoryService/DeleteLocalInventory")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteLocalInventoryRequest>newBuilder()
                      .setPath(
                          "/inventories/v1beta/{name=accounts/*/products/*/localInventories/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteLocalInventoryRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteLocalInventoryRequest> serializer =
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

  private final UnaryCallable<ListLocalInventoriesRequest, ListLocalInventoriesResponse>
      listLocalInventoriesCallable;
  private final UnaryCallable<ListLocalInventoriesRequest, ListLocalInventoriesPagedResponse>
      listLocalInventoriesPagedCallable;
  private final UnaryCallable<InsertLocalInventoryRequest, LocalInventory>
      insertLocalInventoryCallable;
  private final UnaryCallable<DeleteLocalInventoryRequest, Empty> deleteLocalInventoryCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonLocalInventoryServiceStub create(
      LocalInventoryServiceStubSettings settings) throws IOException {
    return new HttpJsonLocalInventoryServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonLocalInventoryServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonLocalInventoryServiceStub(
        LocalInventoryServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonLocalInventoryServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonLocalInventoryServiceStub(
        LocalInventoryServiceStubSettings.newHttpJsonBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonLocalInventoryServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonLocalInventoryServiceStub(
      LocalInventoryServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonLocalInventoryServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonLocalInventoryServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonLocalInventoryServiceStub(
      LocalInventoryServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<ListLocalInventoriesRequest, ListLocalInventoriesResponse>
        listLocalInventoriesTransportSettings =
            HttpJsonCallSettings
                .<ListLocalInventoriesRequest, ListLocalInventoriesResponse>newBuilder()
                .setMethodDescriptor(listLocalInventoriesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<InsertLocalInventoryRequest, LocalInventory>
        insertLocalInventoryTransportSettings =
            HttpJsonCallSettings.<InsertLocalInventoryRequest, LocalInventory>newBuilder()
                .setMethodDescriptor(insertLocalInventoryMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<DeleteLocalInventoryRequest, Empty> deleteLocalInventoryTransportSettings =
        HttpJsonCallSettings.<DeleteLocalInventoryRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteLocalInventoryMethodDescriptor)
            .setTypeRegistry(typeRegistry)
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

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(listLocalInventoriesMethodDescriptor);
    methodDescriptors.add(insertLocalInventoryMethodDescriptor);
    methodDescriptors.add(deleteLocalInventoryMethodDescriptor);
    return methodDescriptors;
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
