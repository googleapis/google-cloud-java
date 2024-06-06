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

package com.google.shopping.merchant.datasources.v1beta.stub;

import static com.google.shopping.merchant.datasources.v1beta.DataSourcesServiceClient.ListDataSourcesPagedResponse;

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
import com.google.shopping.merchant.datasources.v1beta.CreateDataSourceRequest;
import com.google.shopping.merchant.datasources.v1beta.DataSource;
import com.google.shopping.merchant.datasources.v1beta.DeleteDataSourceRequest;
import com.google.shopping.merchant.datasources.v1beta.FetchDataSourceRequest;
import com.google.shopping.merchant.datasources.v1beta.GetDataSourceRequest;
import com.google.shopping.merchant.datasources.v1beta.ListDataSourcesRequest;
import com.google.shopping.merchant.datasources.v1beta.ListDataSourcesResponse;
import com.google.shopping.merchant.datasources.v1beta.UpdateDataSourceRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * REST stub implementation for the DataSourcesService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class HttpJsonDataSourcesServiceStub extends DataSourcesServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<GetDataSourceRequest, DataSource>
      getDataSourceMethodDescriptor =
          ApiMethodDescriptor.<GetDataSourceRequest, DataSource>newBuilder()
              .setFullMethodName(
                  "google.shopping.merchant.datasources.v1beta.DataSourcesService/GetDataSource")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetDataSourceRequest>newBuilder()
                      .setPath(
                          "/datasources/v1beta/{name=accounts/*/dataSources/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetDataSourceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetDataSourceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<DataSource>newBuilder()
                      .setDefaultInstance(DataSource.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListDataSourcesRequest, ListDataSourcesResponse>
      listDataSourcesMethodDescriptor =
          ApiMethodDescriptor.<ListDataSourcesRequest, ListDataSourcesResponse>newBuilder()
              .setFullMethodName(
                  "google.shopping.merchant.datasources.v1beta.DataSourcesService/ListDataSources")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListDataSourcesRequest>newBuilder()
                      .setPath(
                          "/datasources/v1beta/{parent=accounts/*}/dataSources",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListDataSourcesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListDataSourcesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListDataSourcesResponse>newBuilder()
                      .setDefaultInstance(ListDataSourcesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateDataSourceRequest, DataSource>
      createDataSourceMethodDescriptor =
          ApiMethodDescriptor.<CreateDataSourceRequest, DataSource>newBuilder()
              .setFullMethodName(
                  "google.shopping.merchant.datasources.v1beta.DataSourcesService/CreateDataSource")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateDataSourceRequest>newBuilder()
                      .setPath(
                          "/datasources/v1beta/{parent=accounts/*}/dataSources",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateDataSourceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateDataSourceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("dataSource", request.getDataSource(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<DataSource>newBuilder()
                      .setDefaultInstance(DataSource.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateDataSourceRequest, DataSource>
      updateDataSourceMethodDescriptor =
          ApiMethodDescriptor.<UpdateDataSourceRequest, DataSource>newBuilder()
              .setFullMethodName(
                  "google.shopping.merchant.datasources.v1beta.DataSourcesService/UpdateDataSource")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateDataSourceRequest>newBuilder()
                      .setPath(
                          "/datasources/v1beta/{dataSource.name=accounts/*/dataSources/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateDataSourceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "dataSource.name", request.getDataSource().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateDataSourceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("dataSource", request.getDataSource(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<DataSource>newBuilder()
                      .setDefaultInstance(DataSource.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteDataSourceRequest, Empty>
      deleteDataSourceMethodDescriptor =
          ApiMethodDescriptor.<DeleteDataSourceRequest, Empty>newBuilder()
              .setFullMethodName(
                  "google.shopping.merchant.datasources.v1beta.DataSourcesService/DeleteDataSource")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteDataSourceRequest>newBuilder()
                      .setPath(
                          "/datasources/v1beta/{name=accounts/*/dataSources/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteDataSourceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteDataSourceRequest> serializer =
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

  private static final ApiMethodDescriptor<FetchDataSourceRequest, Empty>
      fetchDataSourceMethodDescriptor =
          ApiMethodDescriptor.<FetchDataSourceRequest, Empty>newBuilder()
              .setFullMethodName(
                  "google.shopping.merchant.datasources.v1beta.DataSourcesService/FetchDataSource")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<FetchDataSourceRequest>newBuilder()
                      .setPath(
                          "/datasources/v1beta/{name=accounts/*/dataSources/*}:fetch",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<FetchDataSourceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<FetchDataSourceRequest> serializer =
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
                  ProtoMessageResponseParser.<Empty>newBuilder()
                      .setDefaultInstance(Empty.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<GetDataSourceRequest, DataSource> getDataSourceCallable;
  private final UnaryCallable<ListDataSourcesRequest, ListDataSourcesResponse>
      listDataSourcesCallable;
  private final UnaryCallable<ListDataSourcesRequest, ListDataSourcesPagedResponse>
      listDataSourcesPagedCallable;
  private final UnaryCallable<CreateDataSourceRequest, DataSource> createDataSourceCallable;
  private final UnaryCallable<UpdateDataSourceRequest, DataSource> updateDataSourceCallable;
  private final UnaryCallable<DeleteDataSourceRequest, Empty> deleteDataSourceCallable;
  private final UnaryCallable<FetchDataSourceRequest, Empty> fetchDataSourceCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonDataSourcesServiceStub create(DataSourcesServiceStubSettings settings)
      throws IOException {
    return new HttpJsonDataSourcesServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonDataSourcesServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonDataSourcesServiceStub(
        DataSourcesServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonDataSourcesServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonDataSourcesServiceStub(
        DataSourcesServiceStubSettings.newHttpJsonBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonDataSourcesServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonDataSourcesServiceStub(
      DataSourcesServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonDataSourcesServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonDataSourcesServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonDataSourcesServiceStub(
      DataSourcesServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<GetDataSourceRequest, DataSource> getDataSourceTransportSettings =
        HttpJsonCallSettings.<GetDataSourceRequest, DataSource>newBuilder()
            .setMethodDescriptor(getDataSourceMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListDataSourcesRequest, ListDataSourcesResponse>
        listDataSourcesTransportSettings =
            HttpJsonCallSettings.<ListDataSourcesRequest, ListDataSourcesResponse>newBuilder()
                .setMethodDescriptor(listDataSourcesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<CreateDataSourceRequest, DataSource> createDataSourceTransportSettings =
        HttpJsonCallSettings.<CreateDataSourceRequest, DataSource>newBuilder()
            .setMethodDescriptor(createDataSourceMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<UpdateDataSourceRequest, DataSource> updateDataSourceTransportSettings =
        HttpJsonCallSettings.<UpdateDataSourceRequest, DataSource>newBuilder()
            .setMethodDescriptor(updateDataSourceMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(
                      "data_source.name", String.valueOf(request.getDataSource().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeleteDataSourceRequest, Empty> deleteDataSourceTransportSettings =
        HttpJsonCallSettings.<DeleteDataSourceRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteDataSourceMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<FetchDataSourceRequest, Empty> fetchDataSourceTransportSettings =
        HttpJsonCallSettings.<FetchDataSourceRequest, Empty>newBuilder()
            .setMethodDescriptor(fetchDataSourceMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();

    this.getDataSourceCallable =
        callableFactory.createUnaryCallable(
            getDataSourceTransportSettings, settings.getDataSourceSettings(), clientContext);
    this.listDataSourcesCallable =
        callableFactory.createUnaryCallable(
            listDataSourcesTransportSettings, settings.listDataSourcesSettings(), clientContext);
    this.listDataSourcesPagedCallable =
        callableFactory.createPagedCallable(
            listDataSourcesTransportSettings, settings.listDataSourcesSettings(), clientContext);
    this.createDataSourceCallable =
        callableFactory.createUnaryCallable(
            createDataSourceTransportSettings, settings.createDataSourceSettings(), clientContext);
    this.updateDataSourceCallable =
        callableFactory.createUnaryCallable(
            updateDataSourceTransportSettings, settings.updateDataSourceSettings(), clientContext);
    this.deleteDataSourceCallable =
        callableFactory.createUnaryCallable(
            deleteDataSourceTransportSettings, settings.deleteDataSourceSettings(), clientContext);
    this.fetchDataSourceCallable =
        callableFactory.createUnaryCallable(
            fetchDataSourceTransportSettings, settings.fetchDataSourceSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(getDataSourceMethodDescriptor);
    methodDescriptors.add(listDataSourcesMethodDescriptor);
    methodDescriptors.add(createDataSourceMethodDescriptor);
    methodDescriptors.add(updateDataSourceMethodDescriptor);
    methodDescriptors.add(deleteDataSourceMethodDescriptor);
    methodDescriptors.add(fetchDataSourceMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<GetDataSourceRequest, DataSource> getDataSourceCallable() {
    return getDataSourceCallable;
  }

  @Override
  public UnaryCallable<ListDataSourcesRequest, ListDataSourcesResponse> listDataSourcesCallable() {
    return listDataSourcesCallable;
  }

  @Override
  public UnaryCallable<ListDataSourcesRequest, ListDataSourcesPagedResponse>
      listDataSourcesPagedCallable() {
    return listDataSourcesPagedCallable;
  }

  @Override
  public UnaryCallable<CreateDataSourceRequest, DataSource> createDataSourceCallable() {
    return createDataSourceCallable;
  }

  @Override
  public UnaryCallable<UpdateDataSourceRequest, DataSource> updateDataSourceCallable() {
    return updateDataSourceCallable;
  }

  @Override
  public UnaryCallable<DeleteDataSourceRequest, Empty> deleteDataSourceCallable() {
    return deleteDataSourceCallable;
  }

  @Override
  public UnaryCallable<FetchDataSourceRequest, Empty> fetchDataSourceCallable() {
    return fetchDataSourceCallable;
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
