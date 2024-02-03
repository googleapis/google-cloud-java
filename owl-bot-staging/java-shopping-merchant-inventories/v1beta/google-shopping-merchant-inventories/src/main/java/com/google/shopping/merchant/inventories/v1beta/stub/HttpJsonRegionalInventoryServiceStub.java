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

import static com.google.shopping.merchant.inventories.v1beta.RegionalInventoryServiceClient.ListRegionalInventoriesPagedResponse;

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
import com.google.shopping.merchant.inventories.v1beta.DeleteRegionalInventoryRequest;
import com.google.shopping.merchant.inventories.v1beta.InsertRegionalInventoryRequest;
import com.google.shopping.merchant.inventories.v1beta.ListRegionalInventoriesRequest;
import com.google.shopping.merchant.inventories.v1beta.ListRegionalInventoriesResponse;
import com.google.shopping.merchant.inventories.v1beta.RegionalInventory;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * REST stub implementation for the RegionalInventoryService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class HttpJsonRegionalInventoryServiceStub extends RegionalInventoryServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<
          ListRegionalInventoriesRequest, ListRegionalInventoriesResponse>
      listRegionalInventoriesMethodDescriptor =
          ApiMethodDescriptor
              .<ListRegionalInventoriesRequest, ListRegionalInventoriesResponse>newBuilder()
              .setFullMethodName(
                  "google.shopping.merchant.inventories.v1beta.RegionalInventoryService/ListRegionalInventories")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListRegionalInventoriesRequest>newBuilder()
                      .setPath(
                          "/inventories/v1beta/{parent=accounts/*/products/*}/regionalInventories",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListRegionalInventoriesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListRegionalInventoriesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListRegionalInventoriesResponse>newBuilder()
                      .setDefaultInstance(ListRegionalInventoriesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<InsertRegionalInventoryRequest, RegionalInventory>
      insertRegionalInventoryMethodDescriptor =
          ApiMethodDescriptor.<InsertRegionalInventoryRequest, RegionalInventory>newBuilder()
              .setFullMethodName(
                  "google.shopping.merchant.inventories.v1beta.RegionalInventoryService/InsertRegionalInventory")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<InsertRegionalInventoryRequest>newBuilder()
                      .setPath(
                          "/inventories/v1beta/{parent=accounts/*/products/*}/regionalInventories:insert",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<InsertRegionalInventoryRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<InsertRegionalInventoryRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "regionalInventory", request.getRegionalInventory(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<RegionalInventory>newBuilder()
                      .setDefaultInstance(RegionalInventory.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteRegionalInventoryRequest, Empty>
      deleteRegionalInventoryMethodDescriptor =
          ApiMethodDescriptor.<DeleteRegionalInventoryRequest, Empty>newBuilder()
              .setFullMethodName(
                  "google.shopping.merchant.inventories.v1beta.RegionalInventoryService/DeleteRegionalInventory")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteRegionalInventoryRequest>newBuilder()
                      .setPath(
                          "/inventories/v1beta/{name=accounts/*/products/*/regionalInventories/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteRegionalInventoryRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteRegionalInventoryRequest> serializer =
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

  private final UnaryCallable<ListRegionalInventoriesRequest, ListRegionalInventoriesResponse>
      listRegionalInventoriesCallable;
  private final UnaryCallable<ListRegionalInventoriesRequest, ListRegionalInventoriesPagedResponse>
      listRegionalInventoriesPagedCallable;
  private final UnaryCallable<InsertRegionalInventoryRequest, RegionalInventory>
      insertRegionalInventoryCallable;
  private final UnaryCallable<DeleteRegionalInventoryRequest, Empty>
      deleteRegionalInventoryCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonRegionalInventoryServiceStub create(
      RegionalInventoryServiceStubSettings settings) throws IOException {
    return new HttpJsonRegionalInventoryServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonRegionalInventoryServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonRegionalInventoryServiceStub(
        RegionalInventoryServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonRegionalInventoryServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonRegionalInventoryServiceStub(
        RegionalInventoryServiceStubSettings.newHttpJsonBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonRegionalInventoryServiceStub, using the given settings. This
   * is protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonRegionalInventoryServiceStub(
      RegionalInventoryServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonRegionalInventoryServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonRegionalInventoryServiceStub, using the given settings. This
   * is protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonRegionalInventoryServiceStub(
      RegionalInventoryServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<ListRegionalInventoriesRequest, ListRegionalInventoriesResponse>
        listRegionalInventoriesTransportSettings =
            HttpJsonCallSettings
                .<ListRegionalInventoriesRequest, ListRegionalInventoriesResponse>newBuilder()
                .setMethodDescriptor(listRegionalInventoriesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<InsertRegionalInventoryRequest, RegionalInventory>
        insertRegionalInventoryTransportSettings =
            HttpJsonCallSettings.<InsertRegionalInventoryRequest, RegionalInventory>newBuilder()
                .setMethodDescriptor(insertRegionalInventoryMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<DeleteRegionalInventoryRequest, Empty>
        deleteRegionalInventoryTransportSettings =
            HttpJsonCallSettings.<DeleteRegionalInventoryRequest, Empty>newBuilder()
                .setMethodDescriptor(deleteRegionalInventoryMethodDescriptor)
                .setTypeRegistry(typeRegistry)
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

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(listRegionalInventoriesMethodDescriptor);
    methodDescriptors.add(insertRegionalInventoryMethodDescriptor);
    methodDescriptors.add(deleteRegionalInventoryMethodDescriptor);
    return methodDescriptors;
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
