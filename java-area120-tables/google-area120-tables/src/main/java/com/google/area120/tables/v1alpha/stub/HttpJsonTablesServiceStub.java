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

package com.google.area120.tables.v1alpha.stub;

import static com.google.area120.tables.v1alpha.TablesServiceClient.ListRowsPagedResponse;
import static com.google.area120.tables.v1alpha.TablesServiceClient.ListTablesPagedResponse;
import static com.google.area120.tables.v1alpha.TablesServiceClient.ListWorkspacesPagedResponse;

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
import com.google.api.gax.rpc.UnaryCallable;
import com.google.area120.tables.v1alpha1.BatchCreateRowsRequest;
import com.google.area120.tables.v1alpha1.BatchCreateRowsResponse;
import com.google.area120.tables.v1alpha1.BatchDeleteRowsRequest;
import com.google.area120.tables.v1alpha1.BatchUpdateRowsRequest;
import com.google.area120.tables.v1alpha1.BatchUpdateRowsResponse;
import com.google.area120.tables.v1alpha1.CreateRowRequest;
import com.google.area120.tables.v1alpha1.DeleteRowRequest;
import com.google.area120.tables.v1alpha1.GetRowRequest;
import com.google.area120.tables.v1alpha1.GetTableRequest;
import com.google.area120.tables.v1alpha1.GetWorkspaceRequest;
import com.google.area120.tables.v1alpha1.ListRowsRequest;
import com.google.area120.tables.v1alpha1.ListRowsResponse;
import com.google.area120.tables.v1alpha1.ListTablesRequest;
import com.google.area120.tables.v1alpha1.ListTablesResponse;
import com.google.area120.tables.v1alpha1.ListWorkspacesRequest;
import com.google.area120.tables.v1alpha1.ListWorkspacesResponse;
import com.google.area120.tables.v1alpha1.Row;
import com.google.area120.tables.v1alpha1.Table;
import com.google.area120.tables.v1alpha1.UpdateRowRequest;
import com.google.area120.tables.v1alpha1.Workspace;
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
 * REST stub implementation for the TablesService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class HttpJsonTablesServiceStub extends TablesServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<GetTableRequest, Table> getTableMethodDescriptor =
      ApiMethodDescriptor.<GetTableRequest, Table>newBuilder()
          .setFullMethodName("google.area120.tables.v1alpha1.TablesService/GetTable")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetTableRequest>newBuilder()
                  .setPath(
                      "/v1alpha1/{name=tables/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetTableRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetTableRequest> serializer =
                            ProtoRestSerializer.create();
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Table>newBuilder()
                  .setDefaultInstance(Table.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<ListTablesRequest, ListTablesResponse>
      listTablesMethodDescriptor =
          ApiMethodDescriptor.<ListTablesRequest, ListTablesResponse>newBuilder()
              .setFullMethodName("google.area120.tables.v1alpha1.TablesService/ListTables")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListTablesRequest>newBuilder()
                      .setPath(
                          "/v1alpha1/tables",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListTablesRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListTablesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListTablesResponse>newBuilder()
                      .setDefaultInstance(ListTablesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetWorkspaceRequest, Workspace>
      getWorkspaceMethodDescriptor =
          ApiMethodDescriptor.<GetWorkspaceRequest, Workspace>newBuilder()
              .setFullMethodName("google.area120.tables.v1alpha1.TablesService/GetWorkspace")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetWorkspaceRequest>newBuilder()
                      .setPath(
                          "/v1alpha1/{name=workspaces/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetWorkspaceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetWorkspaceRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Workspace>newBuilder()
                      .setDefaultInstance(Workspace.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListWorkspacesRequest, ListWorkspacesResponse>
      listWorkspacesMethodDescriptor =
          ApiMethodDescriptor.<ListWorkspacesRequest, ListWorkspacesResponse>newBuilder()
              .setFullMethodName("google.area120.tables.v1alpha1.TablesService/ListWorkspaces")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListWorkspacesRequest>newBuilder()
                      .setPath(
                          "/v1alpha1/workspaces",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListWorkspacesRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListWorkspacesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListWorkspacesResponse>newBuilder()
                      .setDefaultInstance(ListWorkspacesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetRowRequest, Row> getRowMethodDescriptor =
      ApiMethodDescriptor.<GetRowRequest, Row>newBuilder()
          .setFullMethodName("google.area120.tables.v1alpha1.TablesService/GetRow")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetRowRequest>newBuilder()
                  .setPath(
                      "/v1alpha1/{name=tables/*/rows/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetRowRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetRowRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "view", request.getView());
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Row>newBuilder()
                  .setDefaultInstance(Row.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<ListRowsRequest, ListRowsResponse>
      listRowsMethodDescriptor =
          ApiMethodDescriptor.<ListRowsRequest, ListRowsResponse>newBuilder()
              .setFullMethodName("google.area120.tables.v1alpha1.TablesService/ListRows")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListRowsRequest>newBuilder()
                      .setPath(
                          "/v1alpha1/{parent=tables/*}/rows",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListRowsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListRowsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "view", request.getView());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListRowsResponse>newBuilder()
                      .setDefaultInstance(ListRowsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateRowRequest, Row> createRowMethodDescriptor =
      ApiMethodDescriptor.<CreateRowRequest, Row>newBuilder()
          .setFullMethodName("google.area120.tables.v1alpha1.TablesService/CreateRow")
          .setHttpMethod("POST")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<CreateRowRequest>newBuilder()
                  .setPath(
                      "/v1alpha1/{parent=tables/*}/rows",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<CreateRowRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "parent", request.getParent());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<CreateRowRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "view", request.getView());
                        return fields;
                      })
                  .setRequestBodyExtractor(
                      request ->
                          ProtoRestSerializer.create().toBody("row", request.getRow(), false))
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Row>newBuilder()
                  .setDefaultInstance(Row.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<BatchCreateRowsRequest, BatchCreateRowsResponse>
      batchCreateRowsMethodDescriptor =
          ApiMethodDescriptor.<BatchCreateRowsRequest, BatchCreateRowsResponse>newBuilder()
              .setFullMethodName("google.area120.tables.v1alpha1.TablesService/BatchCreateRows")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BatchCreateRowsRequest>newBuilder()
                      .setPath(
                          "/v1alpha1/{parent=tables/*}/rows:batchCreate",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchCreateRowsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchCreateRowsRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearParent().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<BatchCreateRowsResponse>newBuilder()
                      .setDefaultInstance(BatchCreateRowsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateRowRequest, Row> updateRowMethodDescriptor =
      ApiMethodDescriptor.<UpdateRowRequest, Row>newBuilder()
          .setFullMethodName("google.area120.tables.v1alpha1.TablesService/UpdateRow")
          .setHttpMethod("PATCH")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<UpdateRowRequest>newBuilder()
                  .setPath(
                      "/v1alpha1/{row.name=tables/*/rows/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<UpdateRowRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "row.name", request.getRow().getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<UpdateRowRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                        serializer.putQueryParam(fields, "view", request.getView());
                        return fields;
                      })
                  .setRequestBodyExtractor(
                      request ->
                          ProtoRestSerializer.create().toBody("row", request.getRow(), false))
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Row>newBuilder()
                  .setDefaultInstance(Row.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<BatchUpdateRowsRequest, BatchUpdateRowsResponse>
      batchUpdateRowsMethodDescriptor =
          ApiMethodDescriptor.<BatchUpdateRowsRequest, BatchUpdateRowsResponse>newBuilder()
              .setFullMethodName("google.area120.tables.v1alpha1.TablesService/BatchUpdateRows")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BatchUpdateRowsRequest>newBuilder()
                      .setPath(
                          "/v1alpha1/{parent=tables/*}/rows:batchUpdate",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchUpdateRowsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchUpdateRowsRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearParent().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<BatchUpdateRowsResponse>newBuilder()
                      .setDefaultInstance(BatchUpdateRowsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteRowRequest, Empty> deleteRowMethodDescriptor =
      ApiMethodDescriptor.<DeleteRowRequest, Empty>newBuilder()
          .setFullMethodName("google.area120.tables.v1alpha1.TablesService/DeleteRow")
          .setHttpMethod("DELETE")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<DeleteRowRequest>newBuilder()
                  .setPath(
                      "/v1alpha1/{name=tables/*/rows/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<DeleteRowRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<DeleteRowRequest> serializer =
                            ProtoRestSerializer.create();
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

  private static final ApiMethodDescriptor<BatchDeleteRowsRequest, Empty>
      batchDeleteRowsMethodDescriptor =
          ApiMethodDescriptor.<BatchDeleteRowsRequest, Empty>newBuilder()
              .setFullMethodName("google.area120.tables.v1alpha1.TablesService/BatchDeleteRows")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BatchDeleteRowsRequest>newBuilder()
                      .setPath(
                          "/v1alpha1/{parent=tables/*}/rows:batchDelete",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchDeleteRowsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchDeleteRowsRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearParent().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Empty>newBuilder()
                      .setDefaultInstance(Empty.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<GetTableRequest, Table> getTableCallable;
  private final UnaryCallable<ListTablesRequest, ListTablesResponse> listTablesCallable;
  private final UnaryCallable<ListTablesRequest, ListTablesPagedResponse> listTablesPagedCallable;
  private final UnaryCallable<GetWorkspaceRequest, Workspace> getWorkspaceCallable;
  private final UnaryCallable<ListWorkspacesRequest, ListWorkspacesResponse> listWorkspacesCallable;
  private final UnaryCallable<ListWorkspacesRequest, ListWorkspacesPagedResponse>
      listWorkspacesPagedCallable;
  private final UnaryCallable<GetRowRequest, Row> getRowCallable;
  private final UnaryCallable<ListRowsRequest, ListRowsResponse> listRowsCallable;
  private final UnaryCallable<ListRowsRequest, ListRowsPagedResponse> listRowsPagedCallable;
  private final UnaryCallable<CreateRowRequest, Row> createRowCallable;
  private final UnaryCallable<BatchCreateRowsRequest, BatchCreateRowsResponse>
      batchCreateRowsCallable;
  private final UnaryCallable<UpdateRowRequest, Row> updateRowCallable;
  private final UnaryCallable<BatchUpdateRowsRequest, BatchUpdateRowsResponse>
      batchUpdateRowsCallable;
  private final UnaryCallable<DeleteRowRequest, Empty> deleteRowCallable;
  private final UnaryCallable<BatchDeleteRowsRequest, Empty> batchDeleteRowsCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonTablesServiceStub create(TablesServiceStubSettings settings)
      throws IOException {
    return new HttpJsonTablesServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonTablesServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonTablesServiceStub(
        TablesServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonTablesServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonTablesServiceStub(
        TablesServiceStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonTablesServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonTablesServiceStub(
      TablesServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonTablesServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonTablesServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonTablesServiceStub(
      TablesServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<GetTableRequest, Table> getTableTransportSettings =
        HttpJsonCallSettings.<GetTableRequest, Table>newBuilder()
            .setMethodDescriptor(getTableMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ListTablesRequest, ListTablesResponse> listTablesTransportSettings =
        HttpJsonCallSettings.<ListTablesRequest, ListTablesResponse>newBuilder()
            .setMethodDescriptor(listTablesMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<GetWorkspaceRequest, Workspace> getWorkspaceTransportSettings =
        HttpJsonCallSettings.<GetWorkspaceRequest, Workspace>newBuilder()
            .setMethodDescriptor(getWorkspaceMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ListWorkspacesRequest, ListWorkspacesResponse>
        listWorkspacesTransportSettings =
            HttpJsonCallSettings.<ListWorkspacesRequest, ListWorkspacesResponse>newBuilder()
                .setMethodDescriptor(listWorkspacesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GetRowRequest, Row> getRowTransportSettings =
        HttpJsonCallSettings.<GetRowRequest, Row>newBuilder()
            .setMethodDescriptor(getRowMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ListRowsRequest, ListRowsResponse> listRowsTransportSettings =
        HttpJsonCallSettings.<ListRowsRequest, ListRowsResponse>newBuilder()
            .setMethodDescriptor(listRowsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<CreateRowRequest, Row> createRowTransportSettings =
        HttpJsonCallSettings.<CreateRowRequest, Row>newBuilder()
            .setMethodDescriptor(createRowMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<BatchCreateRowsRequest, BatchCreateRowsResponse>
        batchCreateRowsTransportSettings =
            HttpJsonCallSettings.<BatchCreateRowsRequest, BatchCreateRowsResponse>newBuilder()
                .setMethodDescriptor(batchCreateRowsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<UpdateRowRequest, Row> updateRowTransportSettings =
        HttpJsonCallSettings.<UpdateRowRequest, Row>newBuilder()
            .setMethodDescriptor(updateRowMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<BatchUpdateRowsRequest, BatchUpdateRowsResponse>
        batchUpdateRowsTransportSettings =
            HttpJsonCallSettings.<BatchUpdateRowsRequest, BatchUpdateRowsResponse>newBuilder()
                .setMethodDescriptor(batchUpdateRowsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<DeleteRowRequest, Empty> deleteRowTransportSettings =
        HttpJsonCallSettings.<DeleteRowRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteRowMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<BatchDeleteRowsRequest, Empty> batchDeleteRowsTransportSettings =
        HttpJsonCallSettings.<BatchDeleteRowsRequest, Empty>newBuilder()
            .setMethodDescriptor(batchDeleteRowsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();

    this.getTableCallable =
        callableFactory.createUnaryCallable(
            getTableTransportSettings, settings.getTableSettings(), clientContext);
    this.listTablesCallable =
        callableFactory.createUnaryCallable(
            listTablesTransportSettings, settings.listTablesSettings(), clientContext);
    this.listTablesPagedCallable =
        callableFactory.createPagedCallable(
            listTablesTransportSettings, settings.listTablesSettings(), clientContext);
    this.getWorkspaceCallable =
        callableFactory.createUnaryCallable(
            getWorkspaceTransportSettings, settings.getWorkspaceSettings(), clientContext);
    this.listWorkspacesCallable =
        callableFactory.createUnaryCallable(
            listWorkspacesTransportSettings, settings.listWorkspacesSettings(), clientContext);
    this.listWorkspacesPagedCallable =
        callableFactory.createPagedCallable(
            listWorkspacesTransportSettings, settings.listWorkspacesSettings(), clientContext);
    this.getRowCallable =
        callableFactory.createUnaryCallable(
            getRowTransportSettings, settings.getRowSettings(), clientContext);
    this.listRowsCallable =
        callableFactory.createUnaryCallable(
            listRowsTransportSettings, settings.listRowsSettings(), clientContext);
    this.listRowsPagedCallable =
        callableFactory.createPagedCallable(
            listRowsTransportSettings, settings.listRowsSettings(), clientContext);
    this.createRowCallable =
        callableFactory.createUnaryCallable(
            createRowTransportSettings, settings.createRowSettings(), clientContext);
    this.batchCreateRowsCallable =
        callableFactory.createUnaryCallable(
            batchCreateRowsTransportSettings, settings.batchCreateRowsSettings(), clientContext);
    this.updateRowCallable =
        callableFactory.createUnaryCallable(
            updateRowTransportSettings, settings.updateRowSettings(), clientContext);
    this.batchUpdateRowsCallable =
        callableFactory.createUnaryCallable(
            batchUpdateRowsTransportSettings, settings.batchUpdateRowsSettings(), clientContext);
    this.deleteRowCallable =
        callableFactory.createUnaryCallable(
            deleteRowTransportSettings, settings.deleteRowSettings(), clientContext);
    this.batchDeleteRowsCallable =
        callableFactory.createUnaryCallable(
            batchDeleteRowsTransportSettings, settings.batchDeleteRowsSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(getTableMethodDescriptor);
    methodDescriptors.add(listTablesMethodDescriptor);
    methodDescriptors.add(getWorkspaceMethodDescriptor);
    methodDescriptors.add(listWorkspacesMethodDescriptor);
    methodDescriptors.add(getRowMethodDescriptor);
    methodDescriptors.add(listRowsMethodDescriptor);
    methodDescriptors.add(createRowMethodDescriptor);
    methodDescriptors.add(batchCreateRowsMethodDescriptor);
    methodDescriptors.add(updateRowMethodDescriptor);
    methodDescriptors.add(batchUpdateRowsMethodDescriptor);
    methodDescriptors.add(deleteRowMethodDescriptor);
    methodDescriptors.add(batchDeleteRowsMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<GetTableRequest, Table> getTableCallable() {
    return getTableCallable;
  }

  @Override
  public UnaryCallable<ListTablesRequest, ListTablesResponse> listTablesCallable() {
    return listTablesCallable;
  }

  @Override
  public UnaryCallable<ListTablesRequest, ListTablesPagedResponse> listTablesPagedCallable() {
    return listTablesPagedCallable;
  }

  @Override
  public UnaryCallable<GetWorkspaceRequest, Workspace> getWorkspaceCallable() {
    return getWorkspaceCallable;
  }

  @Override
  public UnaryCallable<ListWorkspacesRequest, ListWorkspacesResponse> listWorkspacesCallable() {
    return listWorkspacesCallable;
  }

  @Override
  public UnaryCallable<ListWorkspacesRequest, ListWorkspacesPagedResponse>
      listWorkspacesPagedCallable() {
    return listWorkspacesPagedCallable;
  }

  @Override
  public UnaryCallable<GetRowRequest, Row> getRowCallable() {
    return getRowCallable;
  }

  @Override
  public UnaryCallable<ListRowsRequest, ListRowsResponse> listRowsCallable() {
    return listRowsCallable;
  }

  @Override
  public UnaryCallable<ListRowsRequest, ListRowsPagedResponse> listRowsPagedCallable() {
    return listRowsPagedCallable;
  }

  @Override
  public UnaryCallable<CreateRowRequest, Row> createRowCallable() {
    return createRowCallable;
  }

  @Override
  public UnaryCallable<BatchCreateRowsRequest, BatchCreateRowsResponse> batchCreateRowsCallable() {
    return batchCreateRowsCallable;
  }

  @Override
  public UnaryCallable<UpdateRowRequest, Row> updateRowCallable() {
    return updateRowCallable;
  }

  @Override
  public UnaryCallable<BatchUpdateRowsRequest, BatchUpdateRowsResponse> batchUpdateRowsCallable() {
    return batchUpdateRowsCallable;
  }

  @Override
  public UnaryCallable<DeleteRowRequest, Empty> deleteRowCallable() {
    return deleteRowCallable;
  }

  @Override
  public UnaryCallable<BatchDeleteRowsRequest, Empty> batchDeleteRowsCallable() {
    return batchDeleteRowsCallable;
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
