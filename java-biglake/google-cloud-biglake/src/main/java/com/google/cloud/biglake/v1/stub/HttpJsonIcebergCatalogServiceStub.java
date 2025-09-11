/*
 * Copyright 2025 Google LLC
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

package com.google.cloud.biglake.v1.stub;

import static com.google.cloud.biglake.v1.IcebergCatalogServiceClient.ListIcebergCatalogsPagedResponse;

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
import com.google.cloud.biglake.v1.CreateIcebergCatalogRequest;
import com.google.cloud.biglake.v1.FailoverIcebergCatalogRequest;
import com.google.cloud.biglake.v1.FailoverIcebergCatalogResponse;
import com.google.cloud.biglake.v1.GetIcebergCatalogRequest;
import com.google.cloud.biglake.v1.IcebergCatalog;
import com.google.cloud.biglake.v1.ListIcebergCatalogsRequest;
import com.google.cloud.biglake.v1.ListIcebergCatalogsResponse;
import com.google.cloud.biglake.v1.UpdateIcebergCatalogRequest;
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
 * REST stub implementation for the IcebergCatalogService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class HttpJsonIcebergCatalogServiceStub extends IcebergCatalogServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<GetIcebergCatalogRequest, IcebergCatalog>
      getIcebergCatalogMethodDescriptor =
          ApiMethodDescriptor.<GetIcebergCatalogRequest, IcebergCatalog>newBuilder()
              .setFullMethodName("google.cloud.biglake.v1.IcebergCatalogService/GetIcebergCatalog")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetIcebergCatalogRequest>newBuilder()
                      .setPath(
                          "/iceberg/v1/restcatalog/extensions/{name=projects/*/catalogs/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetIcebergCatalogRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetIcebergCatalogRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<IcebergCatalog>newBuilder()
                      .setDefaultInstance(IcebergCatalog.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListIcebergCatalogsRequest, ListIcebergCatalogsResponse>
      listIcebergCatalogsMethodDescriptor =
          ApiMethodDescriptor.<ListIcebergCatalogsRequest, ListIcebergCatalogsResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.biglake.v1.IcebergCatalogService/ListIcebergCatalogs")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListIcebergCatalogsRequest>newBuilder()
                      .setPath(
                          "/iceberg/v1/restcatalog/extensions/{parent=projects/*}/catalogs",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListIcebergCatalogsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListIcebergCatalogsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "view", request.getViewValue());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListIcebergCatalogsResponse>newBuilder()
                      .setDefaultInstance(ListIcebergCatalogsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateIcebergCatalogRequest, IcebergCatalog>
      updateIcebergCatalogMethodDescriptor =
          ApiMethodDescriptor.<UpdateIcebergCatalogRequest, IcebergCatalog>newBuilder()
              .setFullMethodName(
                  "google.cloud.biglake.v1.IcebergCatalogService/UpdateIcebergCatalog")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateIcebergCatalogRequest>newBuilder()
                      .setPath(
                          "/iceberg/v1/restcatalog/extensions/{icebergCatalog.name=projects/*/catalogs/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateIcebergCatalogRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields,
                                "icebergCatalog.name",
                                request.getIcebergCatalog().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateIcebergCatalogRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("icebergCatalog", request.getIcebergCatalog(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<IcebergCatalog>newBuilder()
                      .setDefaultInstance(IcebergCatalog.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateIcebergCatalogRequest, IcebergCatalog>
      createIcebergCatalogMethodDescriptor =
          ApiMethodDescriptor.<CreateIcebergCatalogRequest, IcebergCatalog>newBuilder()
              .setFullMethodName(
                  "google.cloud.biglake.v1.IcebergCatalogService/CreateIcebergCatalog")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateIcebergCatalogRequest>newBuilder()
                      .setPath(
                          "/iceberg/v1/restcatalog/extensions/{parent=projects/*}/catalogs",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateIcebergCatalogRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateIcebergCatalogRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "icebergCatalogId", request.getIcebergCatalogId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("icebergCatalog", request.getIcebergCatalog(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<IcebergCatalog>newBuilder()
                      .setDefaultInstance(IcebergCatalog.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          FailoverIcebergCatalogRequest, FailoverIcebergCatalogResponse>
      failoverIcebergCatalogMethodDescriptor =
          ApiMethodDescriptor
              .<FailoverIcebergCatalogRequest, FailoverIcebergCatalogResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.biglake.v1.IcebergCatalogService/FailoverIcebergCatalog")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<FailoverIcebergCatalogRequest>newBuilder()
                      .setPath(
                          "/iceberg/v1/restcatalog/extensions/{name=projects/*/catalogs/*}:failover",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<FailoverIcebergCatalogRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<FailoverIcebergCatalogRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearName().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<FailoverIcebergCatalogResponse>newBuilder()
                      .setDefaultInstance(FailoverIcebergCatalogResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<GetIcebergCatalogRequest, IcebergCatalog> getIcebergCatalogCallable;
  private final UnaryCallable<ListIcebergCatalogsRequest, ListIcebergCatalogsResponse>
      listIcebergCatalogsCallable;
  private final UnaryCallable<ListIcebergCatalogsRequest, ListIcebergCatalogsPagedResponse>
      listIcebergCatalogsPagedCallable;
  private final UnaryCallable<UpdateIcebergCatalogRequest, IcebergCatalog>
      updateIcebergCatalogCallable;
  private final UnaryCallable<CreateIcebergCatalogRequest, IcebergCatalog>
      createIcebergCatalogCallable;
  private final UnaryCallable<FailoverIcebergCatalogRequest, FailoverIcebergCatalogResponse>
      failoverIcebergCatalogCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonIcebergCatalogServiceStub create(
      IcebergCatalogServiceStubSettings settings) throws IOException {
    return new HttpJsonIcebergCatalogServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonIcebergCatalogServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonIcebergCatalogServiceStub(
        IcebergCatalogServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonIcebergCatalogServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonIcebergCatalogServiceStub(
        IcebergCatalogServiceStubSettings.newHttpJsonBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonIcebergCatalogServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonIcebergCatalogServiceStub(
      IcebergCatalogServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonIcebergCatalogServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonIcebergCatalogServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonIcebergCatalogServiceStub(
      IcebergCatalogServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<GetIcebergCatalogRequest, IcebergCatalog>
        getIcebergCatalogTransportSettings =
            HttpJsonCallSettings.<GetIcebergCatalogRequest, IcebergCatalog>newBuilder()
                .setMethodDescriptor(getIcebergCatalogMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ListIcebergCatalogsRequest, ListIcebergCatalogsResponse>
        listIcebergCatalogsTransportSettings =
            HttpJsonCallSettings
                .<ListIcebergCatalogsRequest, ListIcebergCatalogsResponse>newBuilder()
                .setMethodDescriptor(listIcebergCatalogsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<UpdateIcebergCatalogRequest, IcebergCatalog>
        updateIcebergCatalogTransportSettings =
            HttpJsonCallSettings.<UpdateIcebergCatalogRequest, IcebergCatalog>newBuilder()
                .setMethodDescriptor(updateIcebergCatalogMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "iceberg_catalog.name",
                          String.valueOf(request.getIcebergCatalog().getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<CreateIcebergCatalogRequest, IcebergCatalog>
        createIcebergCatalogTransportSettings =
            HttpJsonCallSettings.<CreateIcebergCatalogRequest, IcebergCatalog>newBuilder()
                .setMethodDescriptor(createIcebergCatalogMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<FailoverIcebergCatalogRequest, FailoverIcebergCatalogResponse>
        failoverIcebergCatalogTransportSettings =
            HttpJsonCallSettings
                .<FailoverIcebergCatalogRequest, FailoverIcebergCatalogResponse>newBuilder()
                .setMethodDescriptor(failoverIcebergCatalogMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();

    this.getIcebergCatalogCallable =
        callableFactory.createUnaryCallable(
            getIcebergCatalogTransportSettings,
            settings.getIcebergCatalogSettings(),
            clientContext);
    this.listIcebergCatalogsCallable =
        callableFactory.createUnaryCallable(
            listIcebergCatalogsTransportSettings,
            settings.listIcebergCatalogsSettings(),
            clientContext);
    this.listIcebergCatalogsPagedCallable =
        callableFactory.createPagedCallable(
            listIcebergCatalogsTransportSettings,
            settings.listIcebergCatalogsSettings(),
            clientContext);
    this.updateIcebergCatalogCallable =
        callableFactory.createUnaryCallable(
            updateIcebergCatalogTransportSettings,
            settings.updateIcebergCatalogSettings(),
            clientContext);
    this.createIcebergCatalogCallable =
        callableFactory.createUnaryCallable(
            createIcebergCatalogTransportSettings,
            settings.createIcebergCatalogSettings(),
            clientContext);
    this.failoverIcebergCatalogCallable =
        callableFactory.createUnaryCallable(
            failoverIcebergCatalogTransportSettings,
            settings.failoverIcebergCatalogSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(getIcebergCatalogMethodDescriptor);
    methodDescriptors.add(listIcebergCatalogsMethodDescriptor);
    methodDescriptors.add(updateIcebergCatalogMethodDescriptor);
    methodDescriptors.add(createIcebergCatalogMethodDescriptor);
    methodDescriptors.add(failoverIcebergCatalogMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<GetIcebergCatalogRequest, IcebergCatalog> getIcebergCatalogCallable() {
    return getIcebergCatalogCallable;
  }

  @Override
  public UnaryCallable<ListIcebergCatalogsRequest, ListIcebergCatalogsResponse>
      listIcebergCatalogsCallable() {
    return listIcebergCatalogsCallable;
  }

  @Override
  public UnaryCallable<ListIcebergCatalogsRequest, ListIcebergCatalogsPagedResponse>
      listIcebergCatalogsPagedCallable() {
    return listIcebergCatalogsPagedCallable;
  }

  @Override
  public UnaryCallable<UpdateIcebergCatalogRequest, IcebergCatalog> updateIcebergCatalogCallable() {
    return updateIcebergCatalogCallable;
  }

  @Override
  public UnaryCallable<CreateIcebergCatalogRequest, IcebergCatalog> createIcebergCatalogCallable() {
    return createIcebergCatalogCallable;
  }

  @Override
  public UnaryCallable<FailoverIcebergCatalogRequest, FailoverIcebergCatalogResponse>
      failoverIcebergCatalogCallable() {
    return failoverIcebergCatalogCallable;
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
