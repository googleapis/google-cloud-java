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

package com.google.shopping.merchant.lfp.v1beta.stub;

import static com.google.shopping.merchant.lfp.v1beta.LfpStoreServiceClient.ListLfpStoresPagedResponse;

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
import com.google.shopping.merchant.lfp.v1beta.DeleteLfpStoreRequest;
import com.google.shopping.merchant.lfp.v1beta.GetLfpStoreRequest;
import com.google.shopping.merchant.lfp.v1beta.InsertLfpStoreRequest;
import com.google.shopping.merchant.lfp.v1beta.LfpStore;
import com.google.shopping.merchant.lfp.v1beta.ListLfpStoresRequest;
import com.google.shopping.merchant.lfp.v1beta.ListLfpStoresResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * REST stub implementation for the LfpStoreService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class HttpJsonLfpStoreServiceStub extends LfpStoreServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<GetLfpStoreRequest, LfpStore>
      getLfpStoreMethodDescriptor =
          ApiMethodDescriptor.<GetLfpStoreRequest, LfpStore>newBuilder()
              .setFullMethodName("google.shopping.merchant.lfp.v1beta.LfpStoreService/GetLfpStore")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetLfpStoreRequest>newBuilder()
                      .setPath(
                          "/lfp/v1beta/{name=accounts/*/lfpStores/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetLfpStoreRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetLfpStoreRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<LfpStore>newBuilder()
                      .setDefaultInstance(LfpStore.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<InsertLfpStoreRequest, LfpStore>
      insertLfpStoreMethodDescriptor =
          ApiMethodDescriptor.<InsertLfpStoreRequest, LfpStore>newBuilder()
              .setFullMethodName(
                  "google.shopping.merchant.lfp.v1beta.LfpStoreService/InsertLfpStore")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<InsertLfpStoreRequest>newBuilder()
                      .setPath(
                          "/lfp/v1beta/{parent=accounts/*}/lfpStores:insert",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<InsertLfpStoreRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<InsertLfpStoreRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("lfpStore", request.getLfpStore(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<LfpStore>newBuilder()
                      .setDefaultInstance(LfpStore.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteLfpStoreRequest, Empty>
      deleteLfpStoreMethodDescriptor =
          ApiMethodDescriptor.<DeleteLfpStoreRequest, Empty>newBuilder()
              .setFullMethodName(
                  "google.shopping.merchant.lfp.v1beta.LfpStoreService/DeleteLfpStore")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteLfpStoreRequest>newBuilder()
                      .setPath(
                          "/lfp/v1beta/{name=accounts/*/lfpStores/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteLfpStoreRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteLfpStoreRequest> serializer =
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

  private static final ApiMethodDescriptor<ListLfpStoresRequest, ListLfpStoresResponse>
      listLfpStoresMethodDescriptor =
          ApiMethodDescriptor.<ListLfpStoresRequest, ListLfpStoresResponse>newBuilder()
              .setFullMethodName(
                  "google.shopping.merchant.lfp.v1beta.LfpStoreService/ListLfpStores")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListLfpStoresRequest>newBuilder()
                      .setPath(
                          "/lfp/v1beta/{parent=accounts/*}/lfpStores",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListLfpStoresRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListLfpStoresRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(
                                fields, "targetAccount", request.getTargetAccount());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListLfpStoresResponse>newBuilder()
                      .setDefaultInstance(ListLfpStoresResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<GetLfpStoreRequest, LfpStore> getLfpStoreCallable;
  private final UnaryCallable<InsertLfpStoreRequest, LfpStore> insertLfpStoreCallable;
  private final UnaryCallable<DeleteLfpStoreRequest, Empty> deleteLfpStoreCallable;
  private final UnaryCallable<ListLfpStoresRequest, ListLfpStoresResponse> listLfpStoresCallable;
  private final UnaryCallable<ListLfpStoresRequest, ListLfpStoresPagedResponse>
      listLfpStoresPagedCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonLfpStoreServiceStub create(LfpStoreServiceStubSettings settings)
      throws IOException {
    return new HttpJsonLfpStoreServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonLfpStoreServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonLfpStoreServiceStub(
        LfpStoreServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonLfpStoreServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonLfpStoreServiceStub(
        LfpStoreServiceStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonLfpStoreServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonLfpStoreServiceStub(
      LfpStoreServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonLfpStoreServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonLfpStoreServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonLfpStoreServiceStub(
      LfpStoreServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<GetLfpStoreRequest, LfpStore> getLfpStoreTransportSettings =
        HttpJsonCallSettings.<GetLfpStoreRequest, LfpStore>newBuilder()
            .setMethodDescriptor(getLfpStoreMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<InsertLfpStoreRequest, LfpStore> insertLfpStoreTransportSettings =
        HttpJsonCallSettings.<InsertLfpStoreRequest, LfpStore>newBuilder()
            .setMethodDescriptor(insertLfpStoreMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeleteLfpStoreRequest, Empty> deleteLfpStoreTransportSettings =
        HttpJsonCallSettings.<DeleteLfpStoreRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteLfpStoreMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListLfpStoresRequest, ListLfpStoresResponse>
        listLfpStoresTransportSettings =
            HttpJsonCallSettings.<ListLfpStoresRequest, ListLfpStoresResponse>newBuilder()
                .setMethodDescriptor(listLfpStoresMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();

    this.getLfpStoreCallable =
        callableFactory.createUnaryCallable(
            getLfpStoreTransportSettings, settings.getLfpStoreSettings(), clientContext);
    this.insertLfpStoreCallable =
        callableFactory.createUnaryCallable(
            insertLfpStoreTransportSettings, settings.insertLfpStoreSettings(), clientContext);
    this.deleteLfpStoreCallable =
        callableFactory.createUnaryCallable(
            deleteLfpStoreTransportSettings, settings.deleteLfpStoreSettings(), clientContext);
    this.listLfpStoresCallable =
        callableFactory.createUnaryCallable(
            listLfpStoresTransportSettings, settings.listLfpStoresSettings(), clientContext);
    this.listLfpStoresPagedCallable =
        callableFactory.createPagedCallable(
            listLfpStoresTransportSettings, settings.listLfpStoresSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(getLfpStoreMethodDescriptor);
    methodDescriptors.add(insertLfpStoreMethodDescriptor);
    methodDescriptors.add(deleteLfpStoreMethodDescriptor);
    methodDescriptors.add(listLfpStoresMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<GetLfpStoreRequest, LfpStore> getLfpStoreCallable() {
    return getLfpStoreCallable;
  }

  @Override
  public UnaryCallable<InsertLfpStoreRequest, LfpStore> insertLfpStoreCallable() {
    return insertLfpStoreCallable;
  }

  @Override
  public UnaryCallable<DeleteLfpStoreRequest, Empty> deleteLfpStoreCallable() {
    return deleteLfpStoreCallable;
  }

  @Override
  public UnaryCallable<ListLfpStoresRequest, ListLfpStoresResponse> listLfpStoresCallable() {
    return listLfpStoresCallable;
  }

  @Override
  public UnaryCallable<ListLfpStoresRequest, ListLfpStoresPagedResponse>
      listLfpStoresPagedCallable() {
    return listLfpStoresPagedCallable;
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
