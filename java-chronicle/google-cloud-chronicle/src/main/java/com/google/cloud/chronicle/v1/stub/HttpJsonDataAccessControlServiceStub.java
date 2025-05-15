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

package com.google.cloud.chronicle.v1.stub;

import static com.google.cloud.chronicle.v1.DataAccessControlServiceClient.ListDataAccessLabelsPagedResponse;
import static com.google.cloud.chronicle.v1.DataAccessControlServiceClient.ListDataAccessScopesPagedResponse;

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
import com.google.cloud.chronicle.v1.CreateDataAccessLabelRequest;
import com.google.cloud.chronicle.v1.CreateDataAccessScopeRequest;
import com.google.cloud.chronicle.v1.DataAccessLabel;
import com.google.cloud.chronicle.v1.DataAccessScope;
import com.google.cloud.chronicle.v1.DeleteDataAccessLabelRequest;
import com.google.cloud.chronicle.v1.DeleteDataAccessScopeRequest;
import com.google.cloud.chronicle.v1.GetDataAccessLabelRequest;
import com.google.cloud.chronicle.v1.GetDataAccessScopeRequest;
import com.google.cloud.chronicle.v1.ListDataAccessLabelsRequest;
import com.google.cloud.chronicle.v1.ListDataAccessLabelsResponse;
import com.google.cloud.chronicle.v1.ListDataAccessScopesRequest;
import com.google.cloud.chronicle.v1.ListDataAccessScopesResponse;
import com.google.cloud.chronicle.v1.UpdateDataAccessLabelRequest;
import com.google.cloud.chronicle.v1.UpdateDataAccessScopeRequest;
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
 * REST stub implementation for the DataAccessControlService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class HttpJsonDataAccessControlServiceStub extends DataAccessControlServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<CreateDataAccessLabelRequest, DataAccessLabel>
      createDataAccessLabelMethodDescriptor =
          ApiMethodDescriptor.<CreateDataAccessLabelRequest, DataAccessLabel>newBuilder()
              .setFullMethodName(
                  "google.cloud.chronicle.v1.DataAccessControlService/CreateDataAccessLabel")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateDataAccessLabelRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/instances/*}/dataAccessLabels",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateDataAccessLabelRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateDataAccessLabelRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "dataAccessLabelId", request.getDataAccessLabelId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("dataAccessLabel", request.getDataAccessLabel(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<DataAccessLabel>newBuilder()
                      .setDefaultInstance(DataAccessLabel.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetDataAccessLabelRequest, DataAccessLabel>
      getDataAccessLabelMethodDescriptor =
          ApiMethodDescriptor.<GetDataAccessLabelRequest, DataAccessLabel>newBuilder()
              .setFullMethodName(
                  "google.cloud.chronicle.v1.DataAccessControlService/GetDataAccessLabel")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetDataAccessLabelRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/instances/*/dataAccessLabels/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetDataAccessLabelRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetDataAccessLabelRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<DataAccessLabel>newBuilder()
                      .setDefaultInstance(DataAccessLabel.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListDataAccessLabelsRequest, ListDataAccessLabelsResponse>
      listDataAccessLabelsMethodDescriptor =
          ApiMethodDescriptor
              .<ListDataAccessLabelsRequest, ListDataAccessLabelsResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.chronicle.v1.DataAccessControlService/ListDataAccessLabels")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListDataAccessLabelsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/instances/*}/dataAccessLabels",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListDataAccessLabelsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListDataAccessLabelsRequest> serializer =
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
                  ProtoMessageResponseParser.<ListDataAccessLabelsResponse>newBuilder()
                      .setDefaultInstance(ListDataAccessLabelsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateDataAccessLabelRequest, DataAccessLabel>
      updateDataAccessLabelMethodDescriptor =
          ApiMethodDescriptor.<UpdateDataAccessLabelRequest, DataAccessLabel>newBuilder()
              .setFullMethodName(
                  "google.cloud.chronicle.v1.DataAccessControlService/UpdateDataAccessLabel")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateDataAccessLabelRequest>newBuilder()
                      .setPath(
                          "/v1/{dataAccessLabel.name=projects/*/locations/*/instances/*/dataAccessLabels/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateDataAccessLabelRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields,
                                "dataAccessLabel.name",
                                request.getDataAccessLabel().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateDataAccessLabelRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("dataAccessLabel", request.getDataAccessLabel(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<DataAccessLabel>newBuilder()
                      .setDefaultInstance(DataAccessLabel.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteDataAccessLabelRequest, Empty>
      deleteDataAccessLabelMethodDescriptor =
          ApiMethodDescriptor.<DeleteDataAccessLabelRequest, Empty>newBuilder()
              .setFullMethodName(
                  "google.cloud.chronicle.v1.DataAccessControlService/DeleteDataAccessLabel")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteDataAccessLabelRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/instances/*/dataAccessLabels/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteDataAccessLabelRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteDataAccessLabelRequest> serializer =
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

  private static final ApiMethodDescriptor<CreateDataAccessScopeRequest, DataAccessScope>
      createDataAccessScopeMethodDescriptor =
          ApiMethodDescriptor.<CreateDataAccessScopeRequest, DataAccessScope>newBuilder()
              .setFullMethodName(
                  "google.cloud.chronicle.v1.DataAccessControlService/CreateDataAccessScope")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateDataAccessScopeRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/instances/*}/dataAccessScopes",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateDataAccessScopeRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateDataAccessScopeRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "dataAccessScopeId", request.getDataAccessScopeId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("dataAccessScope", request.getDataAccessScope(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<DataAccessScope>newBuilder()
                      .setDefaultInstance(DataAccessScope.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetDataAccessScopeRequest, DataAccessScope>
      getDataAccessScopeMethodDescriptor =
          ApiMethodDescriptor.<GetDataAccessScopeRequest, DataAccessScope>newBuilder()
              .setFullMethodName(
                  "google.cloud.chronicle.v1.DataAccessControlService/GetDataAccessScope")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetDataAccessScopeRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/instances/*/dataAccessScopes/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetDataAccessScopeRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetDataAccessScopeRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<DataAccessScope>newBuilder()
                      .setDefaultInstance(DataAccessScope.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListDataAccessScopesRequest, ListDataAccessScopesResponse>
      listDataAccessScopesMethodDescriptor =
          ApiMethodDescriptor
              .<ListDataAccessScopesRequest, ListDataAccessScopesResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.chronicle.v1.DataAccessControlService/ListDataAccessScopes")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListDataAccessScopesRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/instances/*}/dataAccessScopes",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListDataAccessScopesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListDataAccessScopesRequest> serializer =
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
                  ProtoMessageResponseParser.<ListDataAccessScopesResponse>newBuilder()
                      .setDefaultInstance(ListDataAccessScopesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateDataAccessScopeRequest, DataAccessScope>
      updateDataAccessScopeMethodDescriptor =
          ApiMethodDescriptor.<UpdateDataAccessScopeRequest, DataAccessScope>newBuilder()
              .setFullMethodName(
                  "google.cloud.chronicle.v1.DataAccessControlService/UpdateDataAccessScope")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateDataAccessScopeRequest>newBuilder()
                      .setPath(
                          "/v1/{dataAccessScope.name=projects/*/locations/*/instances/*/dataAccessScopes/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateDataAccessScopeRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields,
                                "dataAccessScope.name",
                                request.getDataAccessScope().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateDataAccessScopeRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("dataAccessScope", request.getDataAccessScope(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<DataAccessScope>newBuilder()
                      .setDefaultInstance(DataAccessScope.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteDataAccessScopeRequest, Empty>
      deleteDataAccessScopeMethodDescriptor =
          ApiMethodDescriptor.<DeleteDataAccessScopeRequest, Empty>newBuilder()
              .setFullMethodName(
                  "google.cloud.chronicle.v1.DataAccessControlService/DeleteDataAccessScope")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteDataAccessScopeRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/instances/*/dataAccessScopes/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteDataAccessScopeRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteDataAccessScopeRequest> serializer =
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

  private final UnaryCallable<CreateDataAccessLabelRequest, DataAccessLabel>
      createDataAccessLabelCallable;
  private final UnaryCallable<GetDataAccessLabelRequest, DataAccessLabel>
      getDataAccessLabelCallable;
  private final UnaryCallable<ListDataAccessLabelsRequest, ListDataAccessLabelsResponse>
      listDataAccessLabelsCallable;
  private final UnaryCallable<ListDataAccessLabelsRequest, ListDataAccessLabelsPagedResponse>
      listDataAccessLabelsPagedCallable;
  private final UnaryCallable<UpdateDataAccessLabelRequest, DataAccessLabel>
      updateDataAccessLabelCallable;
  private final UnaryCallable<DeleteDataAccessLabelRequest, Empty> deleteDataAccessLabelCallable;
  private final UnaryCallable<CreateDataAccessScopeRequest, DataAccessScope>
      createDataAccessScopeCallable;
  private final UnaryCallable<GetDataAccessScopeRequest, DataAccessScope>
      getDataAccessScopeCallable;
  private final UnaryCallable<ListDataAccessScopesRequest, ListDataAccessScopesResponse>
      listDataAccessScopesCallable;
  private final UnaryCallable<ListDataAccessScopesRequest, ListDataAccessScopesPagedResponse>
      listDataAccessScopesPagedCallable;
  private final UnaryCallable<UpdateDataAccessScopeRequest, DataAccessScope>
      updateDataAccessScopeCallable;
  private final UnaryCallable<DeleteDataAccessScopeRequest, Empty> deleteDataAccessScopeCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonDataAccessControlServiceStub create(
      DataAccessControlServiceStubSettings settings) throws IOException {
    return new HttpJsonDataAccessControlServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonDataAccessControlServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonDataAccessControlServiceStub(
        DataAccessControlServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonDataAccessControlServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonDataAccessControlServiceStub(
        DataAccessControlServiceStubSettings.newHttpJsonBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonDataAccessControlServiceStub, using the given settings. This
   * is protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonDataAccessControlServiceStub(
      DataAccessControlServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonDataAccessControlServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonDataAccessControlServiceStub, using the given settings. This
   * is protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonDataAccessControlServiceStub(
      DataAccessControlServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<CreateDataAccessLabelRequest, DataAccessLabel>
        createDataAccessLabelTransportSettings =
            HttpJsonCallSettings.<CreateDataAccessLabelRequest, DataAccessLabel>newBuilder()
                .setMethodDescriptor(createDataAccessLabelMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetDataAccessLabelRequest, DataAccessLabel>
        getDataAccessLabelTransportSettings =
            HttpJsonCallSettings.<GetDataAccessLabelRequest, DataAccessLabel>newBuilder()
                .setMethodDescriptor(getDataAccessLabelMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ListDataAccessLabelsRequest, ListDataAccessLabelsResponse>
        listDataAccessLabelsTransportSettings =
            HttpJsonCallSettings
                .<ListDataAccessLabelsRequest, ListDataAccessLabelsResponse>newBuilder()
                .setMethodDescriptor(listDataAccessLabelsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<UpdateDataAccessLabelRequest, DataAccessLabel>
        updateDataAccessLabelTransportSettings =
            HttpJsonCallSettings.<UpdateDataAccessLabelRequest, DataAccessLabel>newBuilder()
                .setMethodDescriptor(updateDataAccessLabelMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "data_access_label.name",
                          String.valueOf(request.getDataAccessLabel().getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<DeleteDataAccessLabelRequest, Empty>
        deleteDataAccessLabelTransportSettings =
            HttpJsonCallSettings.<DeleteDataAccessLabelRequest, Empty>newBuilder()
                .setMethodDescriptor(deleteDataAccessLabelMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<CreateDataAccessScopeRequest, DataAccessScope>
        createDataAccessScopeTransportSettings =
            HttpJsonCallSettings.<CreateDataAccessScopeRequest, DataAccessScope>newBuilder()
                .setMethodDescriptor(createDataAccessScopeMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetDataAccessScopeRequest, DataAccessScope>
        getDataAccessScopeTransportSettings =
            HttpJsonCallSettings.<GetDataAccessScopeRequest, DataAccessScope>newBuilder()
                .setMethodDescriptor(getDataAccessScopeMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ListDataAccessScopesRequest, ListDataAccessScopesResponse>
        listDataAccessScopesTransportSettings =
            HttpJsonCallSettings
                .<ListDataAccessScopesRequest, ListDataAccessScopesResponse>newBuilder()
                .setMethodDescriptor(listDataAccessScopesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<UpdateDataAccessScopeRequest, DataAccessScope>
        updateDataAccessScopeTransportSettings =
            HttpJsonCallSettings.<UpdateDataAccessScopeRequest, DataAccessScope>newBuilder()
                .setMethodDescriptor(updateDataAccessScopeMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "data_access_scope.name",
                          String.valueOf(request.getDataAccessScope().getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<DeleteDataAccessScopeRequest, Empty>
        deleteDataAccessScopeTransportSettings =
            HttpJsonCallSettings.<DeleteDataAccessScopeRequest, Empty>newBuilder()
                .setMethodDescriptor(deleteDataAccessScopeMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();

    this.createDataAccessLabelCallable =
        callableFactory.createUnaryCallable(
            createDataAccessLabelTransportSettings,
            settings.createDataAccessLabelSettings(),
            clientContext);
    this.getDataAccessLabelCallable =
        callableFactory.createUnaryCallable(
            getDataAccessLabelTransportSettings,
            settings.getDataAccessLabelSettings(),
            clientContext);
    this.listDataAccessLabelsCallable =
        callableFactory.createUnaryCallable(
            listDataAccessLabelsTransportSettings,
            settings.listDataAccessLabelsSettings(),
            clientContext);
    this.listDataAccessLabelsPagedCallable =
        callableFactory.createPagedCallable(
            listDataAccessLabelsTransportSettings,
            settings.listDataAccessLabelsSettings(),
            clientContext);
    this.updateDataAccessLabelCallable =
        callableFactory.createUnaryCallable(
            updateDataAccessLabelTransportSettings,
            settings.updateDataAccessLabelSettings(),
            clientContext);
    this.deleteDataAccessLabelCallable =
        callableFactory.createUnaryCallable(
            deleteDataAccessLabelTransportSettings,
            settings.deleteDataAccessLabelSettings(),
            clientContext);
    this.createDataAccessScopeCallable =
        callableFactory.createUnaryCallable(
            createDataAccessScopeTransportSettings,
            settings.createDataAccessScopeSettings(),
            clientContext);
    this.getDataAccessScopeCallable =
        callableFactory.createUnaryCallable(
            getDataAccessScopeTransportSettings,
            settings.getDataAccessScopeSettings(),
            clientContext);
    this.listDataAccessScopesCallable =
        callableFactory.createUnaryCallable(
            listDataAccessScopesTransportSettings,
            settings.listDataAccessScopesSettings(),
            clientContext);
    this.listDataAccessScopesPagedCallable =
        callableFactory.createPagedCallable(
            listDataAccessScopesTransportSettings,
            settings.listDataAccessScopesSettings(),
            clientContext);
    this.updateDataAccessScopeCallable =
        callableFactory.createUnaryCallable(
            updateDataAccessScopeTransportSettings,
            settings.updateDataAccessScopeSettings(),
            clientContext);
    this.deleteDataAccessScopeCallable =
        callableFactory.createUnaryCallable(
            deleteDataAccessScopeTransportSettings,
            settings.deleteDataAccessScopeSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(createDataAccessLabelMethodDescriptor);
    methodDescriptors.add(getDataAccessLabelMethodDescriptor);
    methodDescriptors.add(listDataAccessLabelsMethodDescriptor);
    methodDescriptors.add(updateDataAccessLabelMethodDescriptor);
    methodDescriptors.add(deleteDataAccessLabelMethodDescriptor);
    methodDescriptors.add(createDataAccessScopeMethodDescriptor);
    methodDescriptors.add(getDataAccessScopeMethodDescriptor);
    methodDescriptors.add(listDataAccessScopesMethodDescriptor);
    methodDescriptors.add(updateDataAccessScopeMethodDescriptor);
    methodDescriptors.add(deleteDataAccessScopeMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<CreateDataAccessLabelRequest, DataAccessLabel>
      createDataAccessLabelCallable() {
    return createDataAccessLabelCallable;
  }

  @Override
  public UnaryCallable<GetDataAccessLabelRequest, DataAccessLabel> getDataAccessLabelCallable() {
    return getDataAccessLabelCallable;
  }

  @Override
  public UnaryCallable<ListDataAccessLabelsRequest, ListDataAccessLabelsResponse>
      listDataAccessLabelsCallable() {
    return listDataAccessLabelsCallable;
  }

  @Override
  public UnaryCallable<ListDataAccessLabelsRequest, ListDataAccessLabelsPagedResponse>
      listDataAccessLabelsPagedCallable() {
    return listDataAccessLabelsPagedCallable;
  }

  @Override
  public UnaryCallable<UpdateDataAccessLabelRequest, DataAccessLabel>
      updateDataAccessLabelCallable() {
    return updateDataAccessLabelCallable;
  }

  @Override
  public UnaryCallable<DeleteDataAccessLabelRequest, Empty> deleteDataAccessLabelCallable() {
    return deleteDataAccessLabelCallable;
  }

  @Override
  public UnaryCallable<CreateDataAccessScopeRequest, DataAccessScope>
      createDataAccessScopeCallable() {
    return createDataAccessScopeCallable;
  }

  @Override
  public UnaryCallable<GetDataAccessScopeRequest, DataAccessScope> getDataAccessScopeCallable() {
    return getDataAccessScopeCallable;
  }

  @Override
  public UnaryCallable<ListDataAccessScopesRequest, ListDataAccessScopesResponse>
      listDataAccessScopesCallable() {
    return listDataAccessScopesCallable;
  }

  @Override
  public UnaryCallable<ListDataAccessScopesRequest, ListDataAccessScopesPagedResponse>
      listDataAccessScopesPagedCallable() {
    return listDataAccessScopesPagedCallable;
  }

  @Override
  public UnaryCallable<UpdateDataAccessScopeRequest, DataAccessScope>
      updateDataAccessScopeCallable() {
    return updateDataAccessScopeCallable;
  }

  @Override
  public UnaryCallable<DeleteDataAccessScopeRequest, Empty> deleteDataAccessScopeCallable() {
    return deleteDataAccessScopeCallable;
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
