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

package com.google.cloud.bigquery.biglake.v1.stub;

import static com.google.cloud.bigquery.biglake.v1.MetastoreServiceClient.ListCatalogsPagedResponse;
import static com.google.cloud.bigquery.biglake.v1.MetastoreServiceClient.ListDatabasesPagedResponse;
import static com.google.cloud.bigquery.biglake.v1.MetastoreServiceClient.ListTablesPagedResponse;

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
import com.google.cloud.bigquery.biglake.v1.Catalog;
import com.google.cloud.bigquery.biglake.v1.CreateCatalogRequest;
import com.google.cloud.bigquery.biglake.v1.CreateDatabaseRequest;
import com.google.cloud.bigquery.biglake.v1.CreateTableRequest;
import com.google.cloud.bigquery.biglake.v1.Database;
import com.google.cloud.bigquery.biglake.v1.DeleteCatalogRequest;
import com.google.cloud.bigquery.biglake.v1.DeleteDatabaseRequest;
import com.google.cloud.bigquery.biglake.v1.DeleteTableRequest;
import com.google.cloud.bigquery.biglake.v1.GetCatalogRequest;
import com.google.cloud.bigquery.biglake.v1.GetDatabaseRequest;
import com.google.cloud.bigquery.biglake.v1.GetTableRequest;
import com.google.cloud.bigquery.biglake.v1.ListCatalogsRequest;
import com.google.cloud.bigquery.biglake.v1.ListCatalogsResponse;
import com.google.cloud.bigquery.biglake.v1.ListDatabasesRequest;
import com.google.cloud.bigquery.biglake.v1.ListDatabasesResponse;
import com.google.cloud.bigquery.biglake.v1.ListTablesRequest;
import com.google.cloud.bigquery.biglake.v1.ListTablesResponse;
import com.google.cloud.bigquery.biglake.v1.RenameTableRequest;
import com.google.cloud.bigquery.biglake.v1.Table;
import com.google.cloud.bigquery.biglake.v1.UpdateDatabaseRequest;
import com.google.cloud.bigquery.biglake.v1.UpdateTableRequest;
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
 * REST stub implementation for the MetastoreService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
@BetaApi
public class HttpJsonMetastoreServiceStub extends MetastoreServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<CreateCatalogRequest, Catalog>
      createCatalogMethodDescriptor =
          ApiMethodDescriptor.<CreateCatalogRequest, Catalog>newBuilder()
              .setFullMethodName("google.cloud.bigquery.biglake.v1.MetastoreService/CreateCatalog")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateCatalogRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/catalogs",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateCatalogRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateCatalogRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "catalogId", request.getCatalogId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("catalog", request.getCatalog(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Catalog>newBuilder()
                      .setDefaultInstance(Catalog.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteCatalogRequest, Catalog>
      deleteCatalogMethodDescriptor =
          ApiMethodDescriptor.<DeleteCatalogRequest, Catalog>newBuilder()
              .setFullMethodName("google.cloud.bigquery.biglake.v1.MetastoreService/DeleteCatalog")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteCatalogRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/catalogs/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteCatalogRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteCatalogRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Catalog>newBuilder()
                      .setDefaultInstance(Catalog.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetCatalogRequest, Catalog> getCatalogMethodDescriptor =
      ApiMethodDescriptor.<GetCatalogRequest, Catalog>newBuilder()
          .setFullMethodName("google.cloud.bigquery.biglake.v1.MetastoreService/GetCatalog")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetCatalogRequest>newBuilder()
                  .setPath(
                      "/v1/{name=projects/*/locations/*/catalogs/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetCatalogRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetCatalogRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Catalog>newBuilder()
                  .setDefaultInstance(Catalog.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<ListCatalogsRequest, ListCatalogsResponse>
      listCatalogsMethodDescriptor =
          ApiMethodDescriptor.<ListCatalogsRequest, ListCatalogsResponse>newBuilder()
              .setFullMethodName("google.cloud.bigquery.biglake.v1.MetastoreService/ListCatalogs")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListCatalogsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/catalogs",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListCatalogsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListCatalogsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListCatalogsResponse>newBuilder()
                      .setDefaultInstance(ListCatalogsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateDatabaseRequest, Database>
      createDatabaseMethodDescriptor =
          ApiMethodDescriptor.<CreateDatabaseRequest, Database>newBuilder()
              .setFullMethodName("google.cloud.bigquery.biglake.v1.MetastoreService/CreateDatabase")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateDatabaseRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/catalogs/*}/databases",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateDatabaseRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateDatabaseRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "databaseId", request.getDatabaseId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("database", request.getDatabase(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Database>newBuilder()
                      .setDefaultInstance(Database.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteDatabaseRequest, Database>
      deleteDatabaseMethodDescriptor =
          ApiMethodDescriptor.<DeleteDatabaseRequest, Database>newBuilder()
              .setFullMethodName("google.cloud.bigquery.biglake.v1.MetastoreService/DeleteDatabase")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteDatabaseRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/catalogs/*/databases/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteDatabaseRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteDatabaseRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Database>newBuilder()
                      .setDefaultInstance(Database.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateDatabaseRequest, Database>
      updateDatabaseMethodDescriptor =
          ApiMethodDescriptor.<UpdateDatabaseRequest, Database>newBuilder()
              .setFullMethodName("google.cloud.bigquery.biglake.v1.MetastoreService/UpdateDatabase")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateDatabaseRequest>newBuilder()
                      .setPath(
                          "/v1/{database.name=projects/*/locations/*/catalogs/*/databases/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateDatabaseRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "database.name", request.getDatabase().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateDatabaseRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("database", request.getDatabase(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Database>newBuilder()
                      .setDefaultInstance(Database.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetDatabaseRequest, Database>
      getDatabaseMethodDescriptor =
          ApiMethodDescriptor.<GetDatabaseRequest, Database>newBuilder()
              .setFullMethodName("google.cloud.bigquery.biglake.v1.MetastoreService/GetDatabase")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetDatabaseRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/catalogs/*/databases/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetDatabaseRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetDatabaseRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Database>newBuilder()
                      .setDefaultInstance(Database.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListDatabasesRequest, ListDatabasesResponse>
      listDatabasesMethodDescriptor =
          ApiMethodDescriptor.<ListDatabasesRequest, ListDatabasesResponse>newBuilder()
              .setFullMethodName("google.cloud.bigquery.biglake.v1.MetastoreService/ListDatabases")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListDatabasesRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/catalogs/*}/databases",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListDatabasesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListDatabasesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListDatabasesResponse>newBuilder()
                      .setDefaultInstance(ListDatabasesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateTableRequest, Table> createTableMethodDescriptor =
      ApiMethodDescriptor.<CreateTableRequest, Table>newBuilder()
          .setFullMethodName("google.cloud.bigquery.biglake.v1.MetastoreService/CreateTable")
          .setHttpMethod("POST")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<CreateTableRequest>newBuilder()
                  .setPath(
                      "/v1/{parent=projects/*/locations/*/catalogs/*/databases/*}/tables",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<CreateTableRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "parent", request.getParent());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<CreateTableRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "tableId", request.getTableId());
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(
                      request ->
                          ProtoRestSerializer.create().toBody("table", request.getTable(), true))
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Table>newBuilder()
                  .setDefaultInstance(Table.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<DeleteTableRequest, Table> deleteTableMethodDescriptor =
      ApiMethodDescriptor.<DeleteTableRequest, Table>newBuilder()
          .setFullMethodName("google.cloud.bigquery.biglake.v1.MetastoreService/DeleteTable")
          .setHttpMethod("DELETE")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<DeleteTableRequest>newBuilder()
                  .setPath(
                      "/v1/{name=projects/*/locations/*/catalogs/*/databases/*/tables/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<DeleteTableRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<DeleteTableRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
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

  private static final ApiMethodDescriptor<UpdateTableRequest, Table> updateTableMethodDescriptor =
      ApiMethodDescriptor.<UpdateTableRequest, Table>newBuilder()
          .setFullMethodName("google.cloud.bigquery.biglake.v1.MetastoreService/UpdateTable")
          .setHttpMethod("PATCH")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<UpdateTableRequest>newBuilder()
                  .setPath(
                      "/v1/{table.name=projects/*/locations/*/catalogs/*/databases/*/tables/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<UpdateTableRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "table.name", request.getTable().getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<UpdateTableRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(
                      request ->
                          ProtoRestSerializer.create().toBody("table", request.getTable(), true))
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Table>newBuilder()
                  .setDefaultInstance(Table.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<RenameTableRequest, Table> renameTableMethodDescriptor =
      ApiMethodDescriptor.<RenameTableRequest, Table>newBuilder()
          .setFullMethodName("google.cloud.bigquery.biglake.v1.MetastoreService/RenameTable")
          .setHttpMethod("POST")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<RenameTableRequest>newBuilder()
                  .setPath(
                      "/v1/{name=projects/*/locations/*/catalogs/*/databases/*/tables/*}:rename",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<RenameTableRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<RenameTableRequest> serializer =
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
              ProtoMessageResponseParser.<Table>newBuilder()
                  .setDefaultInstance(Table.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<GetTableRequest, Table> getTableMethodDescriptor =
      ApiMethodDescriptor.<GetTableRequest, Table>newBuilder()
          .setFullMethodName("google.cloud.bigquery.biglake.v1.MetastoreService/GetTable")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetTableRequest>newBuilder()
                  .setPath(
                      "/v1/{name=projects/*/locations/*/catalogs/*/databases/*/tables/*}",
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
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
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
              .setFullMethodName("google.cloud.bigquery.biglake.v1.MetastoreService/ListTables")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListTablesRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/catalogs/*/databases/*}/tables",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListTablesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListTablesRequest> serializer =
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
                  ProtoMessageResponseParser.<ListTablesResponse>newBuilder()
                      .setDefaultInstance(ListTablesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<CreateCatalogRequest, Catalog> createCatalogCallable;
  private final UnaryCallable<DeleteCatalogRequest, Catalog> deleteCatalogCallable;
  private final UnaryCallable<GetCatalogRequest, Catalog> getCatalogCallable;
  private final UnaryCallable<ListCatalogsRequest, ListCatalogsResponse> listCatalogsCallable;
  private final UnaryCallable<ListCatalogsRequest, ListCatalogsPagedResponse>
      listCatalogsPagedCallable;
  private final UnaryCallable<CreateDatabaseRequest, Database> createDatabaseCallable;
  private final UnaryCallable<DeleteDatabaseRequest, Database> deleteDatabaseCallable;
  private final UnaryCallable<UpdateDatabaseRequest, Database> updateDatabaseCallable;
  private final UnaryCallable<GetDatabaseRequest, Database> getDatabaseCallable;
  private final UnaryCallable<ListDatabasesRequest, ListDatabasesResponse> listDatabasesCallable;
  private final UnaryCallable<ListDatabasesRequest, ListDatabasesPagedResponse>
      listDatabasesPagedCallable;
  private final UnaryCallable<CreateTableRequest, Table> createTableCallable;
  private final UnaryCallable<DeleteTableRequest, Table> deleteTableCallable;
  private final UnaryCallable<UpdateTableRequest, Table> updateTableCallable;
  private final UnaryCallable<RenameTableRequest, Table> renameTableCallable;
  private final UnaryCallable<GetTableRequest, Table> getTableCallable;
  private final UnaryCallable<ListTablesRequest, ListTablesResponse> listTablesCallable;
  private final UnaryCallable<ListTablesRequest, ListTablesPagedResponse> listTablesPagedCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonMetastoreServiceStub create(MetastoreServiceStubSettings settings)
      throws IOException {
    return new HttpJsonMetastoreServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonMetastoreServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonMetastoreServiceStub(
        MetastoreServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonMetastoreServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonMetastoreServiceStub(
        MetastoreServiceStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonMetastoreServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonMetastoreServiceStub(
      MetastoreServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonMetastoreServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonMetastoreServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonMetastoreServiceStub(
      MetastoreServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<CreateCatalogRequest, Catalog> createCatalogTransportSettings =
        HttpJsonCallSettings.<CreateCatalogRequest, Catalog>newBuilder()
            .setMethodDescriptor(createCatalogMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeleteCatalogRequest, Catalog> deleteCatalogTransportSettings =
        HttpJsonCallSettings.<DeleteCatalogRequest, Catalog>newBuilder()
            .setMethodDescriptor(deleteCatalogMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<GetCatalogRequest, Catalog> getCatalogTransportSettings =
        HttpJsonCallSettings.<GetCatalogRequest, Catalog>newBuilder()
            .setMethodDescriptor(getCatalogMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListCatalogsRequest, ListCatalogsResponse> listCatalogsTransportSettings =
        HttpJsonCallSettings.<ListCatalogsRequest, ListCatalogsResponse>newBuilder()
            .setMethodDescriptor(listCatalogsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<CreateDatabaseRequest, Database> createDatabaseTransportSettings =
        HttpJsonCallSettings.<CreateDatabaseRequest, Database>newBuilder()
            .setMethodDescriptor(createDatabaseMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeleteDatabaseRequest, Database> deleteDatabaseTransportSettings =
        HttpJsonCallSettings.<DeleteDatabaseRequest, Database>newBuilder()
            .setMethodDescriptor(deleteDatabaseMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<UpdateDatabaseRequest, Database> updateDatabaseTransportSettings =
        HttpJsonCallSettings.<UpdateDatabaseRequest, Database>newBuilder()
            .setMethodDescriptor(updateDatabaseMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("database.name", String.valueOf(request.getDatabase().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<GetDatabaseRequest, Database> getDatabaseTransportSettings =
        HttpJsonCallSettings.<GetDatabaseRequest, Database>newBuilder()
            .setMethodDescriptor(getDatabaseMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListDatabasesRequest, ListDatabasesResponse>
        listDatabasesTransportSettings =
            HttpJsonCallSettings.<ListDatabasesRequest, ListDatabasesResponse>newBuilder()
                .setMethodDescriptor(listDatabasesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<CreateTableRequest, Table> createTableTransportSettings =
        HttpJsonCallSettings.<CreateTableRequest, Table>newBuilder()
            .setMethodDescriptor(createTableMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeleteTableRequest, Table> deleteTableTransportSettings =
        HttpJsonCallSettings.<DeleteTableRequest, Table>newBuilder()
            .setMethodDescriptor(deleteTableMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<UpdateTableRequest, Table> updateTableTransportSettings =
        HttpJsonCallSettings.<UpdateTableRequest, Table>newBuilder()
            .setMethodDescriptor(updateTableMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("table.name", String.valueOf(request.getTable().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<RenameTableRequest, Table> renameTableTransportSettings =
        HttpJsonCallSettings.<RenameTableRequest, Table>newBuilder()
            .setMethodDescriptor(renameTableMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<GetTableRequest, Table> getTableTransportSettings =
        HttpJsonCallSettings.<GetTableRequest, Table>newBuilder()
            .setMethodDescriptor(getTableMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListTablesRequest, ListTablesResponse> listTablesTransportSettings =
        HttpJsonCallSettings.<ListTablesRequest, ListTablesResponse>newBuilder()
            .setMethodDescriptor(listTablesMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();

    this.createCatalogCallable =
        callableFactory.createUnaryCallable(
            createCatalogTransportSettings, settings.createCatalogSettings(), clientContext);
    this.deleteCatalogCallable =
        callableFactory.createUnaryCallable(
            deleteCatalogTransportSettings, settings.deleteCatalogSettings(), clientContext);
    this.getCatalogCallable =
        callableFactory.createUnaryCallable(
            getCatalogTransportSettings, settings.getCatalogSettings(), clientContext);
    this.listCatalogsCallable =
        callableFactory.createUnaryCallable(
            listCatalogsTransportSettings, settings.listCatalogsSettings(), clientContext);
    this.listCatalogsPagedCallable =
        callableFactory.createPagedCallable(
            listCatalogsTransportSettings, settings.listCatalogsSettings(), clientContext);
    this.createDatabaseCallable =
        callableFactory.createUnaryCallable(
            createDatabaseTransportSettings, settings.createDatabaseSettings(), clientContext);
    this.deleteDatabaseCallable =
        callableFactory.createUnaryCallable(
            deleteDatabaseTransportSettings, settings.deleteDatabaseSettings(), clientContext);
    this.updateDatabaseCallable =
        callableFactory.createUnaryCallable(
            updateDatabaseTransportSettings, settings.updateDatabaseSettings(), clientContext);
    this.getDatabaseCallable =
        callableFactory.createUnaryCallable(
            getDatabaseTransportSettings, settings.getDatabaseSettings(), clientContext);
    this.listDatabasesCallable =
        callableFactory.createUnaryCallable(
            listDatabasesTransportSettings, settings.listDatabasesSettings(), clientContext);
    this.listDatabasesPagedCallable =
        callableFactory.createPagedCallable(
            listDatabasesTransportSettings, settings.listDatabasesSettings(), clientContext);
    this.createTableCallable =
        callableFactory.createUnaryCallable(
            createTableTransportSettings, settings.createTableSettings(), clientContext);
    this.deleteTableCallable =
        callableFactory.createUnaryCallable(
            deleteTableTransportSettings, settings.deleteTableSettings(), clientContext);
    this.updateTableCallable =
        callableFactory.createUnaryCallable(
            updateTableTransportSettings, settings.updateTableSettings(), clientContext);
    this.renameTableCallable =
        callableFactory.createUnaryCallable(
            renameTableTransportSettings, settings.renameTableSettings(), clientContext);
    this.getTableCallable =
        callableFactory.createUnaryCallable(
            getTableTransportSettings, settings.getTableSettings(), clientContext);
    this.listTablesCallable =
        callableFactory.createUnaryCallable(
            listTablesTransportSettings, settings.listTablesSettings(), clientContext);
    this.listTablesPagedCallable =
        callableFactory.createPagedCallable(
            listTablesTransportSettings, settings.listTablesSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(createCatalogMethodDescriptor);
    methodDescriptors.add(deleteCatalogMethodDescriptor);
    methodDescriptors.add(getCatalogMethodDescriptor);
    methodDescriptors.add(listCatalogsMethodDescriptor);
    methodDescriptors.add(createDatabaseMethodDescriptor);
    methodDescriptors.add(deleteDatabaseMethodDescriptor);
    methodDescriptors.add(updateDatabaseMethodDescriptor);
    methodDescriptors.add(getDatabaseMethodDescriptor);
    methodDescriptors.add(listDatabasesMethodDescriptor);
    methodDescriptors.add(createTableMethodDescriptor);
    methodDescriptors.add(deleteTableMethodDescriptor);
    methodDescriptors.add(updateTableMethodDescriptor);
    methodDescriptors.add(renameTableMethodDescriptor);
    methodDescriptors.add(getTableMethodDescriptor);
    methodDescriptors.add(listTablesMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<CreateCatalogRequest, Catalog> createCatalogCallable() {
    return createCatalogCallable;
  }

  @Override
  public UnaryCallable<DeleteCatalogRequest, Catalog> deleteCatalogCallable() {
    return deleteCatalogCallable;
  }

  @Override
  public UnaryCallable<GetCatalogRequest, Catalog> getCatalogCallable() {
    return getCatalogCallable;
  }

  @Override
  public UnaryCallable<ListCatalogsRequest, ListCatalogsResponse> listCatalogsCallable() {
    return listCatalogsCallable;
  }

  @Override
  public UnaryCallable<ListCatalogsRequest, ListCatalogsPagedResponse> listCatalogsPagedCallable() {
    return listCatalogsPagedCallable;
  }

  @Override
  public UnaryCallable<CreateDatabaseRequest, Database> createDatabaseCallable() {
    return createDatabaseCallable;
  }

  @Override
  public UnaryCallable<DeleteDatabaseRequest, Database> deleteDatabaseCallable() {
    return deleteDatabaseCallable;
  }

  @Override
  public UnaryCallable<UpdateDatabaseRequest, Database> updateDatabaseCallable() {
    return updateDatabaseCallable;
  }

  @Override
  public UnaryCallable<GetDatabaseRequest, Database> getDatabaseCallable() {
    return getDatabaseCallable;
  }

  @Override
  public UnaryCallable<ListDatabasesRequest, ListDatabasesResponse> listDatabasesCallable() {
    return listDatabasesCallable;
  }

  @Override
  public UnaryCallable<ListDatabasesRequest, ListDatabasesPagedResponse>
      listDatabasesPagedCallable() {
    return listDatabasesPagedCallable;
  }

  @Override
  public UnaryCallable<CreateTableRequest, Table> createTableCallable() {
    return createTableCallable;
  }

  @Override
  public UnaryCallable<DeleteTableRequest, Table> deleteTableCallable() {
    return deleteTableCallable;
  }

  @Override
  public UnaryCallable<UpdateTableRequest, Table> updateTableCallable() {
    return updateTableCallable;
  }

  @Override
  public UnaryCallable<RenameTableRequest, Table> renameTableCallable() {
    return renameTableCallable;
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
