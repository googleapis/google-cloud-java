/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.biglake.hive.v1beta.stub;

import static com.google.cloud.biglake.hive.v1beta.HiveMetastoreServiceClient.ListHiveCatalogsPagedResponse;
import static com.google.cloud.biglake.hive.v1beta.HiveMetastoreServiceClient.ListHiveDatabasesPagedResponse;
import static com.google.cloud.biglake.hive.v1beta.HiveMetastoreServiceClient.ListHiveTablesPagedResponse;

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
import com.google.api.gax.rpc.ServerStreamingCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.biglake.hive.v1beta.BatchCreatePartitionsRequest;
import com.google.cloud.biglake.hive.v1beta.BatchCreatePartitionsResponse;
import com.google.cloud.biglake.hive.v1beta.BatchDeletePartitionsRequest;
import com.google.cloud.biglake.hive.v1beta.BatchUpdatePartitionsRequest;
import com.google.cloud.biglake.hive.v1beta.BatchUpdatePartitionsResponse;
import com.google.cloud.biglake.hive.v1beta.CreateHiveCatalogRequest;
import com.google.cloud.biglake.hive.v1beta.CreateHiveDatabaseRequest;
import com.google.cloud.biglake.hive.v1beta.CreateHiveTableRequest;
import com.google.cloud.biglake.hive.v1beta.DeleteHiveCatalogRequest;
import com.google.cloud.biglake.hive.v1beta.DeleteHiveDatabaseRequest;
import com.google.cloud.biglake.hive.v1beta.DeleteHiveTableRequest;
import com.google.cloud.biglake.hive.v1beta.GetHiveCatalogRequest;
import com.google.cloud.biglake.hive.v1beta.GetHiveDatabaseRequest;
import com.google.cloud.biglake.hive.v1beta.GetHiveTableRequest;
import com.google.cloud.biglake.hive.v1beta.HiveCatalog;
import com.google.cloud.biglake.hive.v1beta.HiveDatabase;
import com.google.cloud.biglake.hive.v1beta.HiveTable;
import com.google.cloud.biglake.hive.v1beta.ListHiveCatalogsRequest;
import com.google.cloud.biglake.hive.v1beta.ListHiveCatalogsResponse;
import com.google.cloud.biglake.hive.v1beta.ListHiveDatabasesRequest;
import com.google.cloud.biglake.hive.v1beta.ListHiveDatabasesResponse;
import com.google.cloud.biglake.hive.v1beta.ListHiveTablesRequest;
import com.google.cloud.biglake.hive.v1beta.ListHiveTablesResponse;
import com.google.cloud.biglake.hive.v1beta.ListPartitionsRequest;
import com.google.cloud.biglake.hive.v1beta.ListPartitionsResponse;
import com.google.cloud.biglake.hive.v1beta.UpdateHiveCatalogRequest;
import com.google.cloud.biglake.hive.v1beta.UpdateHiveDatabaseRequest;
import com.google.cloud.biglake.hive.v1beta.UpdateHiveTableRequest;
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
 * REST stub implementation for the HiveMetastoreService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class HttpJsonHiveMetastoreServiceStub extends HiveMetastoreServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<CreateHiveCatalogRequest, HiveCatalog>
      createHiveCatalogMethodDescriptor =
          ApiMethodDescriptor.<CreateHiveCatalogRequest, HiveCatalog>newBuilder()
              .setFullMethodName(
                  "google.cloud.biglake.hive.v1beta.HiveMetastoreService/CreateHiveCatalog")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateHiveCatalogRequest>newBuilder()
                      .setPath(
                          "/hive/v1beta/{parent=projects/*}/catalogs",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateHiveCatalogRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateHiveCatalogRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "hiveCatalogId", request.getHiveCatalogId());
                            serializer.putQueryParam(
                                fields, "primaryLocation", request.getPrimaryLocation());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("hiveCatalog", request.getHiveCatalog(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<HiveCatalog>newBuilder()
                      .setDefaultInstance(HiveCatalog.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetHiveCatalogRequest, HiveCatalog>
      getHiveCatalogMethodDescriptor =
          ApiMethodDescriptor.<GetHiveCatalogRequest, HiveCatalog>newBuilder()
              .setFullMethodName(
                  "google.cloud.biglake.hive.v1beta.HiveMetastoreService/GetHiveCatalog")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetHiveCatalogRequest>newBuilder()
                      .setPath(
                          "/hive/v1beta/{name=projects/*/catalogs/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetHiveCatalogRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetHiveCatalogRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<HiveCatalog>newBuilder()
                      .setDefaultInstance(HiveCatalog.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListHiveCatalogsRequest, ListHiveCatalogsResponse>
      listHiveCatalogsMethodDescriptor =
          ApiMethodDescriptor.<ListHiveCatalogsRequest, ListHiveCatalogsResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.biglake.hive.v1beta.HiveMetastoreService/ListHiveCatalogs")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListHiveCatalogsRequest>newBuilder()
                      .setPath(
                          "/hive/v1beta/{parent=projects/*}/catalogs",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListHiveCatalogsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListHiveCatalogsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListHiveCatalogsResponse>newBuilder()
                      .setDefaultInstance(ListHiveCatalogsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateHiveCatalogRequest, HiveCatalog>
      updateHiveCatalogMethodDescriptor =
          ApiMethodDescriptor.<UpdateHiveCatalogRequest, HiveCatalog>newBuilder()
              .setFullMethodName(
                  "google.cloud.biglake.hive.v1beta.HiveMetastoreService/UpdateHiveCatalog")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateHiveCatalogRequest>newBuilder()
                      .setPath(
                          "/hive/v1beta/{hiveCatalog.name=projects/*/catalogs/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateHiveCatalogRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "hiveCatalog.name", request.getHiveCatalog().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateHiveCatalogRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("hiveCatalog", request.getHiveCatalog(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<HiveCatalog>newBuilder()
                      .setDefaultInstance(HiveCatalog.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteHiveCatalogRequest, Empty>
      deleteHiveCatalogMethodDescriptor =
          ApiMethodDescriptor.<DeleteHiveCatalogRequest, Empty>newBuilder()
              .setFullMethodName(
                  "google.cloud.biglake.hive.v1beta.HiveMetastoreService/DeleteHiveCatalog")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteHiveCatalogRequest>newBuilder()
                      .setPath(
                          "/hive/v1beta/{name=projects/*/catalogs/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteHiveCatalogRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteHiveCatalogRequest> serializer =
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

  private static final ApiMethodDescriptor<CreateHiveDatabaseRequest, HiveDatabase>
      createHiveDatabaseMethodDescriptor =
          ApiMethodDescriptor.<CreateHiveDatabaseRequest, HiveDatabase>newBuilder()
              .setFullMethodName(
                  "google.cloud.biglake.hive.v1beta.HiveMetastoreService/CreateHiveDatabase")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateHiveDatabaseRequest>newBuilder()
                      .setPath(
                          "/hive/v1beta/{parent=projects/*/catalogs/*}/databases",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateHiveDatabaseRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateHiveDatabaseRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "hiveDatabaseId", request.getHiveDatabaseId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("hiveDatabase", request.getHiveDatabase(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<HiveDatabase>newBuilder()
                      .setDefaultInstance(HiveDatabase.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetHiveDatabaseRequest, HiveDatabase>
      getHiveDatabaseMethodDescriptor =
          ApiMethodDescriptor.<GetHiveDatabaseRequest, HiveDatabase>newBuilder()
              .setFullMethodName(
                  "google.cloud.biglake.hive.v1beta.HiveMetastoreService/GetHiveDatabase")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetHiveDatabaseRequest>newBuilder()
                      .setPath(
                          "/hive/v1beta/{name=projects/*/catalogs/*/databases/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetHiveDatabaseRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetHiveDatabaseRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<HiveDatabase>newBuilder()
                      .setDefaultInstance(HiveDatabase.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListHiveDatabasesRequest, ListHiveDatabasesResponse>
      listHiveDatabasesMethodDescriptor =
          ApiMethodDescriptor.<ListHiveDatabasesRequest, ListHiveDatabasesResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.biglake.hive.v1beta.HiveMetastoreService/ListHiveDatabases")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListHiveDatabasesRequest>newBuilder()
                      .setPath(
                          "/hive/v1beta/{parent=projects/*/catalogs/*}/databases",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListHiveDatabasesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListHiveDatabasesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListHiveDatabasesResponse>newBuilder()
                      .setDefaultInstance(ListHiveDatabasesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateHiveDatabaseRequest, HiveDatabase>
      updateHiveDatabaseMethodDescriptor =
          ApiMethodDescriptor.<UpdateHiveDatabaseRequest, HiveDatabase>newBuilder()
              .setFullMethodName(
                  "google.cloud.biglake.hive.v1beta.HiveMetastoreService/UpdateHiveDatabase")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateHiveDatabaseRequest>newBuilder()
                      .setPath(
                          "/hive/v1beta/{hiveDatabase.name=projects/*/catalogs/*/databases/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateHiveDatabaseRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "hiveDatabase.name", request.getHiveDatabase().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateHiveDatabaseRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("hiveDatabase", request.getHiveDatabase(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<HiveDatabase>newBuilder()
                      .setDefaultInstance(HiveDatabase.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteHiveDatabaseRequest, Empty>
      deleteHiveDatabaseMethodDescriptor =
          ApiMethodDescriptor.<DeleteHiveDatabaseRequest, Empty>newBuilder()
              .setFullMethodName(
                  "google.cloud.biglake.hive.v1beta.HiveMetastoreService/DeleteHiveDatabase")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteHiveDatabaseRequest>newBuilder()
                      .setPath(
                          "/hive/v1beta/{name=projects/*/catalogs/*/databases/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteHiveDatabaseRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteHiveDatabaseRequest> serializer =
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

  private static final ApiMethodDescriptor<CreateHiveTableRequest, HiveTable>
      createHiveTableMethodDescriptor =
          ApiMethodDescriptor.<CreateHiveTableRequest, HiveTable>newBuilder()
              .setFullMethodName(
                  "google.cloud.biglake.hive.v1beta.HiveMetastoreService/CreateHiveTable")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateHiveTableRequest>newBuilder()
                      .setPath(
                          "/hive/v1beta/{parent=projects/*/catalogs/*/databases/*}/tables",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateHiveTableRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateHiveTableRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "hiveTableId", request.getHiveTableId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("hiveTable", request.getHiveTable(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<HiveTable>newBuilder()
                      .setDefaultInstance(HiveTable.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetHiveTableRequest, HiveTable>
      getHiveTableMethodDescriptor =
          ApiMethodDescriptor.<GetHiveTableRequest, HiveTable>newBuilder()
              .setFullMethodName(
                  "google.cloud.biglake.hive.v1beta.HiveMetastoreService/GetHiveTable")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetHiveTableRequest>newBuilder()
                      .setPath(
                          "/hive/v1beta/{name=projects/*/catalogs/*/databases/*/tables/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetHiveTableRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetHiveTableRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<HiveTable>newBuilder()
                      .setDefaultInstance(HiveTable.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListHiveTablesRequest, ListHiveTablesResponse>
      listHiveTablesMethodDescriptor =
          ApiMethodDescriptor.<ListHiveTablesRequest, ListHiveTablesResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.biglake.hive.v1beta.HiveMetastoreService/ListHiveTables")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListHiveTablesRequest>newBuilder()
                      .setPath(
                          "/hive/v1beta/{parent=projects/*/catalogs/*/databases/*}/tables",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListHiveTablesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListHiveTablesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListHiveTablesResponse>newBuilder()
                      .setDefaultInstance(ListHiveTablesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateHiveTableRequest, HiveTable>
      updateHiveTableMethodDescriptor =
          ApiMethodDescriptor.<UpdateHiveTableRequest, HiveTable>newBuilder()
              .setFullMethodName(
                  "google.cloud.biglake.hive.v1beta.HiveMetastoreService/UpdateHiveTable")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateHiveTableRequest>newBuilder()
                      .setPath(
                          "/hive/v1beta/{hiveTable.name=projects/*/catalogs/*/databases/*/tables/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateHiveTableRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "hiveTable.name", request.getHiveTable().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateHiveTableRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("hiveTable", request.getHiveTable(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<HiveTable>newBuilder()
                      .setDefaultInstance(HiveTable.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteHiveTableRequest, Empty>
      deleteHiveTableMethodDescriptor =
          ApiMethodDescriptor.<DeleteHiveTableRequest, Empty>newBuilder()
              .setFullMethodName(
                  "google.cloud.biglake.hive.v1beta.HiveMetastoreService/DeleteHiveTable")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteHiveTableRequest>newBuilder()
                      .setPath(
                          "/hive/v1beta/{name=projects/*/catalogs/*/databases/*/tables/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteHiveTableRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteHiveTableRequest> serializer =
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

  private static final ApiMethodDescriptor<
          BatchCreatePartitionsRequest, BatchCreatePartitionsResponse>
      batchCreatePartitionsMethodDescriptor =
          ApiMethodDescriptor
              .<BatchCreatePartitionsRequest, BatchCreatePartitionsResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.biglake.hive.v1beta.HiveMetastoreService/BatchCreatePartitions")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BatchCreatePartitionsRequest>newBuilder()
                      .setPath(
                          "/hive/v1beta/{parent=projects/*/catalogs/*/databases/*/tables/*}/partitions:batchCreate",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchCreatePartitionsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchCreatePartitionsRequest> serializer =
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
                  ProtoMessageResponseParser.<BatchCreatePartitionsResponse>newBuilder()
                      .setDefaultInstance(BatchCreatePartitionsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<BatchDeletePartitionsRequest, Empty>
      batchDeletePartitionsMethodDescriptor =
          ApiMethodDescriptor.<BatchDeletePartitionsRequest, Empty>newBuilder()
              .setFullMethodName(
                  "google.cloud.biglake.hive.v1beta.HiveMetastoreService/BatchDeletePartitions")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BatchDeletePartitionsRequest>newBuilder()
                      .setPath(
                          "/hive/v1beta/{parent=projects/*/catalogs/*/databases/*/tables/*}/partitions:batchDelete",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchDeletePartitionsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchDeletePartitionsRequest> serializer =
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
                  ProtoMessageResponseParser.<Empty>newBuilder()
                      .setDefaultInstance(Empty.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          BatchUpdatePartitionsRequest, BatchUpdatePartitionsResponse>
      batchUpdatePartitionsMethodDescriptor =
          ApiMethodDescriptor
              .<BatchUpdatePartitionsRequest, BatchUpdatePartitionsResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.biglake.hive.v1beta.HiveMetastoreService/BatchUpdatePartitions")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BatchUpdatePartitionsRequest>newBuilder()
                      .setPath(
                          "/hive/v1beta/{parent=projects/*/catalogs/*/databases/*/tables/*}/partitions:batchUpdate",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchUpdatePartitionsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchUpdatePartitionsRequest> serializer =
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
                  ProtoMessageResponseParser.<BatchUpdatePartitionsResponse>newBuilder()
                      .setDefaultInstance(BatchUpdatePartitionsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListPartitionsRequest, ListPartitionsResponse>
      listPartitionsMethodDescriptor =
          ApiMethodDescriptor.<ListPartitionsRequest, ListPartitionsResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.biglake.hive.v1beta.HiveMetastoreService/ListPartitions")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.SERVER_STREAMING)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListPartitionsRequest>newBuilder()
                      .setPath(
                          "/hive/v1beta/{parent=projects/*/catalogs/*/databases/*/tables/*}/partitions:list",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListPartitionsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListPartitionsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListPartitionsResponse>newBuilder()
                      .setDefaultInstance(ListPartitionsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<CreateHiveCatalogRequest, HiveCatalog> createHiveCatalogCallable;
  private final UnaryCallable<GetHiveCatalogRequest, HiveCatalog> getHiveCatalogCallable;
  private final UnaryCallable<ListHiveCatalogsRequest, ListHiveCatalogsResponse>
      listHiveCatalogsCallable;
  private final UnaryCallable<ListHiveCatalogsRequest, ListHiveCatalogsPagedResponse>
      listHiveCatalogsPagedCallable;
  private final UnaryCallable<UpdateHiveCatalogRequest, HiveCatalog> updateHiveCatalogCallable;
  private final UnaryCallable<DeleteHiveCatalogRequest, Empty> deleteHiveCatalogCallable;
  private final UnaryCallable<CreateHiveDatabaseRequest, HiveDatabase> createHiveDatabaseCallable;
  private final UnaryCallable<GetHiveDatabaseRequest, HiveDatabase> getHiveDatabaseCallable;
  private final UnaryCallable<ListHiveDatabasesRequest, ListHiveDatabasesResponse>
      listHiveDatabasesCallable;
  private final UnaryCallable<ListHiveDatabasesRequest, ListHiveDatabasesPagedResponse>
      listHiveDatabasesPagedCallable;
  private final UnaryCallable<UpdateHiveDatabaseRequest, HiveDatabase> updateHiveDatabaseCallable;
  private final UnaryCallable<DeleteHiveDatabaseRequest, Empty> deleteHiveDatabaseCallable;
  private final UnaryCallable<CreateHiveTableRequest, HiveTable> createHiveTableCallable;
  private final UnaryCallable<GetHiveTableRequest, HiveTable> getHiveTableCallable;
  private final UnaryCallable<ListHiveTablesRequest, ListHiveTablesResponse> listHiveTablesCallable;
  private final UnaryCallable<ListHiveTablesRequest, ListHiveTablesPagedResponse>
      listHiveTablesPagedCallable;
  private final UnaryCallable<UpdateHiveTableRequest, HiveTable> updateHiveTableCallable;
  private final UnaryCallable<DeleteHiveTableRequest, Empty> deleteHiveTableCallable;
  private final UnaryCallable<BatchCreatePartitionsRequest, BatchCreatePartitionsResponse>
      batchCreatePartitionsCallable;
  private final UnaryCallable<BatchDeletePartitionsRequest, Empty> batchDeletePartitionsCallable;
  private final UnaryCallable<BatchUpdatePartitionsRequest, BatchUpdatePartitionsResponse>
      batchUpdatePartitionsCallable;
  private final ServerStreamingCallable<ListPartitionsRequest, ListPartitionsResponse>
      listPartitionsCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonHiveMetastoreServiceStub create(
      HiveMetastoreServiceStubSettings settings) throws IOException {
    return new HttpJsonHiveMetastoreServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonHiveMetastoreServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonHiveMetastoreServiceStub(
        HiveMetastoreServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonHiveMetastoreServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonHiveMetastoreServiceStub(
        HiveMetastoreServiceStubSettings.newHttpJsonBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonHiveMetastoreServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonHiveMetastoreServiceStub(
      HiveMetastoreServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonHiveMetastoreServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonHiveMetastoreServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonHiveMetastoreServiceStub(
      HiveMetastoreServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<CreateHiveCatalogRequest, HiveCatalog> createHiveCatalogTransportSettings =
        HttpJsonCallSettings.<CreateHiveCatalogRequest, HiveCatalog>newBuilder()
            .setMethodDescriptor(createHiveCatalogMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<GetHiveCatalogRequest, HiveCatalog> getHiveCatalogTransportSettings =
        HttpJsonCallSettings.<GetHiveCatalogRequest, HiveCatalog>newBuilder()
            .setMethodDescriptor(getHiveCatalogMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListHiveCatalogsRequest, ListHiveCatalogsResponse>
        listHiveCatalogsTransportSettings =
            HttpJsonCallSettings.<ListHiveCatalogsRequest, ListHiveCatalogsResponse>newBuilder()
                .setMethodDescriptor(listHiveCatalogsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<UpdateHiveCatalogRequest, HiveCatalog> updateHiveCatalogTransportSettings =
        HttpJsonCallSettings.<UpdateHiveCatalogRequest, HiveCatalog>newBuilder()
            .setMethodDescriptor(updateHiveCatalogMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(
                      "hive_catalog.name", String.valueOf(request.getHiveCatalog().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeleteHiveCatalogRequest, Empty> deleteHiveCatalogTransportSettings =
        HttpJsonCallSettings.<DeleteHiveCatalogRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteHiveCatalogMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<CreateHiveDatabaseRequest, HiveDatabase>
        createHiveDatabaseTransportSettings =
            HttpJsonCallSettings.<CreateHiveDatabaseRequest, HiveDatabase>newBuilder()
                .setMethodDescriptor(createHiveDatabaseMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetHiveDatabaseRequest, HiveDatabase> getHiveDatabaseTransportSettings =
        HttpJsonCallSettings.<GetHiveDatabaseRequest, HiveDatabase>newBuilder()
            .setMethodDescriptor(getHiveDatabaseMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListHiveDatabasesRequest, ListHiveDatabasesResponse>
        listHiveDatabasesTransportSettings =
            HttpJsonCallSettings.<ListHiveDatabasesRequest, ListHiveDatabasesResponse>newBuilder()
                .setMethodDescriptor(listHiveDatabasesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<UpdateHiveDatabaseRequest, HiveDatabase>
        updateHiveDatabaseTransportSettings =
            HttpJsonCallSettings.<UpdateHiveDatabaseRequest, HiveDatabase>newBuilder()
                .setMethodDescriptor(updateHiveDatabaseMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "hive_database.name",
                          String.valueOf(request.getHiveDatabase().getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<DeleteHiveDatabaseRequest, Empty> deleteHiveDatabaseTransportSettings =
        HttpJsonCallSettings.<DeleteHiveDatabaseRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteHiveDatabaseMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<CreateHiveTableRequest, HiveTable> createHiveTableTransportSettings =
        HttpJsonCallSettings.<CreateHiveTableRequest, HiveTable>newBuilder()
            .setMethodDescriptor(createHiveTableMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<GetHiveTableRequest, HiveTable> getHiveTableTransportSettings =
        HttpJsonCallSettings.<GetHiveTableRequest, HiveTable>newBuilder()
            .setMethodDescriptor(getHiveTableMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListHiveTablesRequest, ListHiveTablesResponse>
        listHiveTablesTransportSettings =
            HttpJsonCallSettings.<ListHiveTablesRequest, ListHiveTablesResponse>newBuilder()
                .setMethodDescriptor(listHiveTablesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<UpdateHiveTableRequest, HiveTable> updateHiveTableTransportSettings =
        HttpJsonCallSettings.<UpdateHiveTableRequest, HiveTable>newBuilder()
            .setMethodDescriptor(updateHiveTableMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("hive_table.name", String.valueOf(request.getHiveTable().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeleteHiveTableRequest, Empty> deleteHiveTableTransportSettings =
        HttpJsonCallSettings.<DeleteHiveTableRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteHiveTableMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<BatchCreatePartitionsRequest, BatchCreatePartitionsResponse>
        batchCreatePartitionsTransportSettings =
            HttpJsonCallSettings
                .<BatchCreatePartitionsRequest, BatchCreatePartitionsResponse>newBuilder()
                .setMethodDescriptor(batchCreatePartitionsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<BatchDeletePartitionsRequest, Empty>
        batchDeletePartitionsTransportSettings =
            HttpJsonCallSettings.<BatchDeletePartitionsRequest, Empty>newBuilder()
                .setMethodDescriptor(batchDeletePartitionsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<BatchUpdatePartitionsRequest, BatchUpdatePartitionsResponse>
        batchUpdatePartitionsTransportSettings =
            HttpJsonCallSettings
                .<BatchUpdatePartitionsRequest, BatchUpdatePartitionsResponse>newBuilder()
                .setMethodDescriptor(batchUpdatePartitionsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ListPartitionsRequest, ListPartitionsResponse>
        listPartitionsTransportSettings =
            HttpJsonCallSettings.<ListPartitionsRequest, ListPartitionsResponse>newBuilder()
                .setMethodDescriptor(listPartitionsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();

    this.createHiveCatalogCallable =
        callableFactory.createUnaryCallable(
            createHiveCatalogTransportSettings,
            settings.createHiveCatalogSettings(),
            clientContext);
    this.getHiveCatalogCallable =
        callableFactory.createUnaryCallable(
            getHiveCatalogTransportSettings, settings.getHiveCatalogSettings(), clientContext);
    this.listHiveCatalogsCallable =
        callableFactory.createUnaryCallable(
            listHiveCatalogsTransportSettings, settings.listHiveCatalogsSettings(), clientContext);
    this.listHiveCatalogsPagedCallable =
        callableFactory.createPagedCallable(
            listHiveCatalogsTransportSettings, settings.listHiveCatalogsSettings(), clientContext);
    this.updateHiveCatalogCallable =
        callableFactory.createUnaryCallable(
            updateHiveCatalogTransportSettings,
            settings.updateHiveCatalogSettings(),
            clientContext);
    this.deleteHiveCatalogCallable =
        callableFactory.createUnaryCallable(
            deleteHiveCatalogTransportSettings,
            settings.deleteHiveCatalogSettings(),
            clientContext);
    this.createHiveDatabaseCallable =
        callableFactory.createUnaryCallable(
            createHiveDatabaseTransportSettings,
            settings.createHiveDatabaseSettings(),
            clientContext);
    this.getHiveDatabaseCallable =
        callableFactory.createUnaryCallable(
            getHiveDatabaseTransportSettings, settings.getHiveDatabaseSettings(), clientContext);
    this.listHiveDatabasesCallable =
        callableFactory.createUnaryCallable(
            listHiveDatabasesTransportSettings,
            settings.listHiveDatabasesSettings(),
            clientContext);
    this.listHiveDatabasesPagedCallable =
        callableFactory.createPagedCallable(
            listHiveDatabasesTransportSettings,
            settings.listHiveDatabasesSettings(),
            clientContext);
    this.updateHiveDatabaseCallable =
        callableFactory.createUnaryCallable(
            updateHiveDatabaseTransportSettings,
            settings.updateHiveDatabaseSettings(),
            clientContext);
    this.deleteHiveDatabaseCallable =
        callableFactory.createUnaryCallable(
            deleteHiveDatabaseTransportSettings,
            settings.deleteHiveDatabaseSettings(),
            clientContext);
    this.createHiveTableCallable =
        callableFactory.createUnaryCallable(
            createHiveTableTransportSettings, settings.createHiveTableSettings(), clientContext);
    this.getHiveTableCallable =
        callableFactory.createUnaryCallable(
            getHiveTableTransportSettings, settings.getHiveTableSettings(), clientContext);
    this.listHiveTablesCallable =
        callableFactory.createUnaryCallable(
            listHiveTablesTransportSettings, settings.listHiveTablesSettings(), clientContext);
    this.listHiveTablesPagedCallable =
        callableFactory.createPagedCallable(
            listHiveTablesTransportSettings, settings.listHiveTablesSettings(), clientContext);
    this.updateHiveTableCallable =
        callableFactory.createUnaryCallable(
            updateHiveTableTransportSettings, settings.updateHiveTableSettings(), clientContext);
    this.deleteHiveTableCallable =
        callableFactory.createUnaryCallable(
            deleteHiveTableTransportSettings, settings.deleteHiveTableSettings(), clientContext);
    this.batchCreatePartitionsCallable =
        callableFactory.createUnaryCallable(
            batchCreatePartitionsTransportSettings,
            settings.batchCreatePartitionsSettings(),
            clientContext);
    this.batchDeletePartitionsCallable =
        callableFactory.createUnaryCallable(
            batchDeletePartitionsTransportSettings,
            settings.batchDeletePartitionsSettings(),
            clientContext);
    this.batchUpdatePartitionsCallable =
        callableFactory.createUnaryCallable(
            batchUpdatePartitionsTransportSettings,
            settings.batchUpdatePartitionsSettings(),
            clientContext);
    this.listPartitionsCallable =
        callableFactory.createServerStreamingCallable(
            listPartitionsTransportSettings, settings.listPartitionsSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(createHiveCatalogMethodDescriptor);
    methodDescriptors.add(getHiveCatalogMethodDescriptor);
    methodDescriptors.add(listHiveCatalogsMethodDescriptor);
    methodDescriptors.add(updateHiveCatalogMethodDescriptor);
    methodDescriptors.add(deleteHiveCatalogMethodDescriptor);
    methodDescriptors.add(createHiveDatabaseMethodDescriptor);
    methodDescriptors.add(getHiveDatabaseMethodDescriptor);
    methodDescriptors.add(listHiveDatabasesMethodDescriptor);
    methodDescriptors.add(updateHiveDatabaseMethodDescriptor);
    methodDescriptors.add(deleteHiveDatabaseMethodDescriptor);
    methodDescriptors.add(createHiveTableMethodDescriptor);
    methodDescriptors.add(getHiveTableMethodDescriptor);
    methodDescriptors.add(listHiveTablesMethodDescriptor);
    methodDescriptors.add(updateHiveTableMethodDescriptor);
    methodDescriptors.add(deleteHiveTableMethodDescriptor);
    methodDescriptors.add(batchCreatePartitionsMethodDescriptor);
    methodDescriptors.add(batchDeletePartitionsMethodDescriptor);
    methodDescriptors.add(batchUpdatePartitionsMethodDescriptor);
    methodDescriptors.add(listPartitionsMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<CreateHiveCatalogRequest, HiveCatalog> createHiveCatalogCallable() {
    return createHiveCatalogCallable;
  }

  @Override
  public UnaryCallable<GetHiveCatalogRequest, HiveCatalog> getHiveCatalogCallable() {
    return getHiveCatalogCallable;
  }

  @Override
  public UnaryCallable<ListHiveCatalogsRequest, ListHiveCatalogsResponse>
      listHiveCatalogsCallable() {
    return listHiveCatalogsCallable;
  }

  @Override
  public UnaryCallable<ListHiveCatalogsRequest, ListHiveCatalogsPagedResponse>
      listHiveCatalogsPagedCallable() {
    return listHiveCatalogsPagedCallable;
  }

  @Override
  public UnaryCallable<UpdateHiveCatalogRequest, HiveCatalog> updateHiveCatalogCallable() {
    return updateHiveCatalogCallable;
  }

  @Override
  public UnaryCallable<DeleteHiveCatalogRequest, Empty> deleteHiveCatalogCallable() {
    return deleteHiveCatalogCallable;
  }

  @Override
  public UnaryCallable<CreateHiveDatabaseRequest, HiveDatabase> createHiveDatabaseCallable() {
    return createHiveDatabaseCallable;
  }

  @Override
  public UnaryCallable<GetHiveDatabaseRequest, HiveDatabase> getHiveDatabaseCallable() {
    return getHiveDatabaseCallable;
  }

  @Override
  public UnaryCallable<ListHiveDatabasesRequest, ListHiveDatabasesResponse>
      listHiveDatabasesCallable() {
    return listHiveDatabasesCallable;
  }

  @Override
  public UnaryCallable<ListHiveDatabasesRequest, ListHiveDatabasesPagedResponse>
      listHiveDatabasesPagedCallable() {
    return listHiveDatabasesPagedCallable;
  }

  @Override
  public UnaryCallable<UpdateHiveDatabaseRequest, HiveDatabase> updateHiveDatabaseCallable() {
    return updateHiveDatabaseCallable;
  }

  @Override
  public UnaryCallable<DeleteHiveDatabaseRequest, Empty> deleteHiveDatabaseCallable() {
    return deleteHiveDatabaseCallable;
  }

  @Override
  public UnaryCallable<CreateHiveTableRequest, HiveTable> createHiveTableCallable() {
    return createHiveTableCallable;
  }

  @Override
  public UnaryCallable<GetHiveTableRequest, HiveTable> getHiveTableCallable() {
    return getHiveTableCallable;
  }

  @Override
  public UnaryCallable<ListHiveTablesRequest, ListHiveTablesResponse> listHiveTablesCallable() {
    return listHiveTablesCallable;
  }

  @Override
  public UnaryCallable<ListHiveTablesRequest, ListHiveTablesPagedResponse>
      listHiveTablesPagedCallable() {
    return listHiveTablesPagedCallable;
  }

  @Override
  public UnaryCallable<UpdateHiveTableRequest, HiveTable> updateHiveTableCallable() {
    return updateHiveTableCallable;
  }

  @Override
  public UnaryCallable<DeleteHiveTableRequest, Empty> deleteHiveTableCallable() {
    return deleteHiveTableCallable;
  }

  @Override
  public UnaryCallable<BatchCreatePartitionsRequest, BatchCreatePartitionsResponse>
      batchCreatePartitionsCallable() {
    return batchCreatePartitionsCallable;
  }

  @Override
  public UnaryCallable<BatchDeletePartitionsRequest, Empty> batchDeletePartitionsCallable() {
    return batchDeletePartitionsCallable;
  }

  @Override
  public UnaryCallable<BatchUpdatePartitionsRequest, BatchUpdatePartitionsResponse>
      batchUpdatePartitionsCallable() {
    return batchUpdatePartitionsCallable;
  }

  @Override
  public ServerStreamingCallable<ListPartitionsRequest, ListPartitionsResponse>
      listPartitionsCallable() {
    return listPartitionsCallable;
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
