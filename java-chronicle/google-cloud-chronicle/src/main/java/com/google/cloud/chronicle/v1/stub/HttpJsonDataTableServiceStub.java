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

package com.google.cloud.chronicle.v1.stub;

import static com.google.cloud.chronicle.v1.DataTableServiceClient.ListDataTableRowsPagedResponse;
import static com.google.cloud.chronicle.v1.DataTableServiceClient.ListDataTablesPagedResponse;

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
import com.google.cloud.chronicle.v1.BulkCreateDataTableRowsRequest;
import com.google.cloud.chronicle.v1.BulkCreateDataTableRowsResponse;
import com.google.cloud.chronicle.v1.BulkGetDataTableRowsRequest;
import com.google.cloud.chronicle.v1.BulkGetDataTableRowsResponse;
import com.google.cloud.chronicle.v1.BulkReplaceDataTableRowsRequest;
import com.google.cloud.chronicle.v1.BulkReplaceDataTableRowsResponse;
import com.google.cloud.chronicle.v1.BulkUpdateDataTableRowsRequest;
import com.google.cloud.chronicle.v1.BulkUpdateDataTableRowsResponse;
import com.google.cloud.chronicle.v1.CreateDataTableRequest;
import com.google.cloud.chronicle.v1.CreateDataTableRowRequest;
import com.google.cloud.chronicle.v1.DataTable;
import com.google.cloud.chronicle.v1.DataTableOperationErrors;
import com.google.cloud.chronicle.v1.DataTableRow;
import com.google.cloud.chronicle.v1.DeleteDataTableRequest;
import com.google.cloud.chronicle.v1.DeleteDataTableRowRequest;
import com.google.cloud.chronicle.v1.GetDataTableOperationErrorsRequest;
import com.google.cloud.chronicle.v1.GetDataTableRequest;
import com.google.cloud.chronicle.v1.GetDataTableRowRequest;
import com.google.cloud.chronicle.v1.ListDataTableRowsRequest;
import com.google.cloud.chronicle.v1.ListDataTableRowsResponse;
import com.google.cloud.chronicle.v1.ListDataTablesRequest;
import com.google.cloud.chronicle.v1.ListDataTablesResponse;
import com.google.cloud.chronicle.v1.UpdateDataTableRequest;
import com.google.cloud.chronicle.v1.UpdateDataTableRowRequest;
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
 * REST stub implementation for the DataTableService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class HttpJsonDataTableServiceStub extends DataTableServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<CreateDataTableRequest, DataTable>
      createDataTableMethodDescriptor =
          ApiMethodDescriptor.<CreateDataTableRequest, DataTable>newBuilder()
              .setFullMethodName("google.cloud.chronicle.v1.DataTableService/CreateDataTable")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateDataTableRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/instances/*}/dataTables",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateDataTableRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateDataTableRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "dataTableId", request.getDataTableId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("dataTable", request.getDataTable(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<DataTable>newBuilder()
                      .setDefaultInstance(DataTable.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListDataTablesRequest, ListDataTablesResponse>
      listDataTablesMethodDescriptor =
          ApiMethodDescriptor.<ListDataTablesRequest, ListDataTablesResponse>newBuilder()
              .setFullMethodName("google.cloud.chronicle.v1.DataTableService/ListDataTables")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListDataTablesRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/instances/*}/dataTables",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListDataTablesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListDataTablesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "orderBy", request.getOrderBy());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListDataTablesResponse>newBuilder()
                      .setDefaultInstance(ListDataTablesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetDataTableRequest, DataTable>
      getDataTableMethodDescriptor =
          ApiMethodDescriptor.<GetDataTableRequest, DataTable>newBuilder()
              .setFullMethodName("google.cloud.chronicle.v1.DataTableService/GetDataTable")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetDataTableRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/instances/*/dataTables/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetDataTableRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetDataTableRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<DataTable>newBuilder()
                      .setDefaultInstance(DataTable.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateDataTableRequest, DataTable>
      updateDataTableMethodDescriptor =
          ApiMethodDescriptor.<UpdateDataTableRequest, DataTable>newBuilder()
              .setFullMethodName("google.cloud.chronicle.v1.DataTableService/UpdateDataTable")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateDataTableRequest>newBuilder()
                      .setPath(
                          "/v1/{dataTable.name=projects/*/locations/*/instances/*/dataTables/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateDataTableRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "dataTable.name", request.getDataTable().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateDataTableRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("dataTable", request.getDataTable(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<DataTable>newBuilder()
                      .setDefaultInstance(DataTable.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteDataTableRequest, Empty>
      deleteDataTableMethodDescriptor =
          ApiMethodDescriptor.<DeleteDataTableRequest, Empty>newBuilder()
              .setFullMethodName("google.cloud.chronicle.v1.DataTableService/DeleteDataTable")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteDataTableRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/instances/*/dataTables/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteDataTableRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteDataTableRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "force", request.getForce());
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

  private static final ApiMethodDescriptor<CreateDataTableRowRequest, DataTableRow>
      createDataTableRowMethodDescriptor =
          ApiMethodDescriptor.<CreateDataTableRowRequest, DataTableRow>newBuilder()
              .setFullMethodName("google.cloud.chronicle.v1.DataTableService/CreateDataTableRow")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateDataTableRowRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/instances/*/dataTables/*}/dataTableRows",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateDataTableRowRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateDataTableRowRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("dataTableRow", request.getDataTableRow(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<DataTableRow>newBuilder()
                      .setDefaultInstance(DataTableRow.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateDataTableRowRequest, DataTableRow>
      updateDataTableRowMethodDescriptor =
          ApiMethodDescriptor.<UpdateDataTableRowRequest, DataTableRow>newBuilder()
              .setFullMethodName("google.cloud.chronicle.v1.DataTableService/UpdateDataTableRow")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateDataTableRowRequest>newBuilder()
                      .setPath(
                          "/v1/{dataTableRow.name=projects/*/locations/*/instances/*/dataTables/*/dataTableRows/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateDataTableRowRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "dataTableRow.name", request.getDataTableRow().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateDataTableRowRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("dataTableRow", request.getDataTableRow(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<DataTableRow>newBuilder()
                      .setDefaultInstance(DataTableRow.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListDataTableRowsRequest, ListDataTableRowsResponse>
      listDataTableRowsMethodDescriptor =
          ApiMethodDescriptor.<ListDataTableRowsRequest, ListDataTableRowsResponse>newBuilder()
              .setFullMethodName("google.cloud.chronicle.v1.DataTableService/ListDataTableRows")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListDataTableRowsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/instances/*/dataTables/*}/dataTableRows",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListDataTableRowsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListDataTableRowsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "orderBy", request.getOrderBy());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListDataTableRowsResponse>newBuilder()
                      .setDefaultInstance(ListDataTableRowsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetDataTableRowRequest, DataTableRow>
      getDataTableRowMethodDescriptor =
          ApiMethodDescriptor.<GetDataTableRowRequest, DataTableRow>newBuilder()
              .setFullMethodName("google.cloud.chronicle.v1.DataTableService/GetDataTableRow")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetDataTableRowRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/instances/*/dataTables/*/dataTableRows/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetDataTableRowRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetDataTableRowRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<DataTableRow>newBuilder()
                      .setDefaultInstance(DataTableRow.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteDataTableRowRequest, Empty>
      deleteDataTableRowMethodDescriptor =
          ApiMethodDescriptor.<DeleteDataTableRowRequest, Empty>newBuilder()
              .setFullMethodName("google.cloud.chronicle.v1.DataTableService/DeleteDataTableRow")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteDataTableRowRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/instances/*/dataTables/*/dataTableRows/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteDataTableRowRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteDataTableRowRequest> serializer =
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
          BulkCreateDataTableRowsRequest, BulkCreateDataTableRowsResponse>
      bulkCreateDataTableRowsMethodDescriptor =
          ApiMethodDescriptor
              .<BulkCreateDataTableRowsRequest, BulkCreateDataTableRowsResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.chronicle.v1.DataTableService/BulkCreateDataTableRows")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BulkCreateDataTableRowsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/instances/*/dataTables/*}/dataTableRows:bulkCreate",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BulkCreateDataTableRowsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BulkCreateDataTableRowsRequest> serializer =
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
                  ProtoMessageResponseParser.<BulkCreateDataTableRowsResponse>newBuilder()
                      .setDefaultInstance(BulkCreateDataTableRowsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          BulkGetDataTableRowsRequest, BulkGetDataTableRowsResponse>
      bulkGetDataTableRowsMethodDescriptor =
          ApiMethodDescriptor
              .<BulkGetDataTableRowsRequest, BulkGetDataTableRowsResponse>newBuilder()
              .setFullMethodName("google.cloud.chronicle.v1.DataTableService/BulkGetDataTableRows")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BulkGetDataTableRowsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/instances/*/dataTables/*}/dataTableRows:bulkGet",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BulkGetDataTableRowsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BulkGetDataTableRowsRequest> serializer =
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
                  ProtoMessageResponseParser.<BulkGetDataTableRowsResponse>newBuilder()
                      .setDefaultInstance(BulkGetDataTableRowsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          BulkReplaceDataTableRowsRequest, BulkReplaceDataTableRowsResponse>
      bulkReplaceDataTableRowsMethodDescriptor =
          ApiMethodDescriptor
              .<BulkReplaceDataTableRowsRequest, BulkReplaceDataTableRowsResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.chronicle.v1.DataTableService/BulkReplaceDataTableRows")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BulkReplaceDataTableRowsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/instances/*/dataTables/*}/dataTableRows:bulkReplace",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BulkReplaceDataTableRowsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BulkReplaceDataTableRowsRequest> serializer =
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
                  ProtoMessageResponseParser.<BulkReplaceDataTableRowsResponse>newBuilder()
                      .setDefaultInstance(BulkReplaceDataTableRowsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          BulkUpdateDataTableRowsRequest, BulkUpdateDataTableRowsResponse>
      bulkUpdateDataTableRowsMethodDescriptor =
          ApiMethodDescriptor
              .<BulkUpdateDataTableRowsRequest, BulkUpdateDataTableRowsResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.chronicle.v1.DataTableService/BulkUpdateDataTableRows")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BulkUpdateDataTableRowsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/instances/*/dataTables/*}/dataTableRows:bulkUpdate",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BulkUpdateDataTableRowsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BulkUpdateDataTableRowsRequest> serializer =
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
                  ProtoMessageResponseParser.<BulkUpdateDataTableRowsResponse>newBuilder()
                      .setDefaultInstance(BulkUpdateDataTableRowsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          GetDataTableOperationErrorsRequest, DataTableOperationErrors>
      getDataTableOperationErrorsMethodDescriptor =
          ApiMethodDescriptor
              .<GetDataTableOperationErrorsRequest, DataTableOperationErrors>newBuilder()
              .setFullMethodName(
                  "google.cloud.chronicle.v1.DataTableService/GetDataTableOperationErrors")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetDataTableOperationErrorsRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/instances/*/dataTableOperationErrors/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetDataTableOperationErrorsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetDataTableOperationErrorsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<DataTableOperationErrors>newBuilder()
                      .setDefaultInstance(DataTableOperationErrors.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<CreateDataTableRequest, DataTable> createDataTableCallable;
  private final UnaryCallable<ListDataTablesRequest, ListDataTablesResponse> listDataTablesCallable;
  private final UnaryCallable<ListDataTablesRequest, ListDataTablesPagedResponse>
      listDataTablesPagedCallable;
  private final UnaryCallable<GetDataTableRequest, DataTable> getDataTableCallable;
  private final UnaryCallable<UpdateDataTableRequest, DataTable> updateDataTableCallable;
  private final UnaryCallable<DeleteDataTableRequest, Empty> deleteDataTableCallable;
  private final UnaryCallable<CreateDataTableRowRequest, DataTableRow> createDataTableRowCallable;
  private final UnaryCallable<UpdateDataTableRowRequest, DataTableRow> updateDataTableRowCallable;
  private final UnaryCallable<ListDataTableRowsRequest, ListDataTableRowsResponse>
      listDataTableRowsCallable;
  private final UnaryCallable<ListDataTableRowsRequest, ListDataTableRowsPagedResponse>
      listDataTableRowsPagedCallable;
  private final UnaryCallable<GetDataTableRowRequest, DataTableRow> getDataTableRowCallable;
  private final UnaryCallable<DeleteDataTableRowRequest, Empty> deleteDataTableRowCallable;
  private final UnaryCallable<BulkCreateDataTableRowsRequest, BulkCreateDataTableRowsResponse>
      bulkCreateDataTableRowsCallable;
  private final UnaryCallable<BulkGetDataTableRowsRequest, BulkGetDataTableRowsResponse>
      bulkGetDataTableRowsCallable;
  private final UnaryCallable<BulkReplaceDataTableRowsRequest, BulkReplaceDataTableRowsResponse>
      bulkReplaceDataTableRowsCallable;
  private final UnaryCallable<BulkUpdateDataTableRowsRequest, BulkUpdateDataTableRowsResponse>
      bulkUpdateDataTableRowsCallable;
  private final UnaryCallable<GetDataTableOperationErrorsRequest, DataTableOperationErrors>
      getDataTableOperationErrorsCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonDataTableServiceStub create(DataTableServiceStubSettings settings)
      throws IOException {
    return new HttpJsonDataTableServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonDataTableServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonDataTableServiceStub(
        DataTableServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonDataTableServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonDataTableServiceStub(
        DataTableServiceStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonDataTableServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonDataTableServiceStub(
      DataTableServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonDataTableServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonDataTableServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonDataTableServiceStub(
      DataTableServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<CreateDataTableRequest, DataTable> createDataTableTransportSettings =
        HttpJsonCallSettings.<CreateDataTableRequest, DataTable>newBuilder()
            .setMethodDescriptor(createDataTableMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getParent())
            .build();
    HttpJsonCallSettings<ListDataTablesRequest, ListDataTablesResponse>
        listDataTablesTransportSettings =
            HttpJsonCallSettings.<ListDataTablesRequest, ListDataTablesResponse>newBuilder()
                .setMethodDescriptor(listDataTablesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<GetDataTableRequest, DataTable> getDataTableTransportSettings =
        HttpJsonCallSettings.<GetDataTableRequest, DataTable>newBuilder()
            .setMethodDescriptor(getDataTableMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    HttpJsonCallSettings<UpdateDataTableRequest, DataTable> updateDataTableTransportSettings =
        HttpJsonCallSettings.<UpdateDataTableRequest, DataTable>newBuilder()
            .setMethodDescriptor(updateDataTableMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("data_table.name", String.valueOf(request.getDataTable().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeleteDataTableRequest, Empty> deleteDataTableTransportSettings =
        HttpJsonCallSettings.<DeleteDataTableRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteDataTableMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    HttpJsonCallSettings<CreateDataTableRowRequest, DataTableRow>
        createDataTableRowTransportSettings =
            HttpJsonCallSettings.<CreateDataTableRowRequest, DataTableRow>newBuilder()
                .setMethodDescriptor(createDataTableRowMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<UpdateDataTableRowRequest, DataTableRow>
        updateDataTableRowTransportSettings =
            HttpJsonCallSettings.<UpdateDataTableRowRequest, DataTableRow>newBuilder()
                .setMethodDescriptor(updateDataTableRowMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "data_table_row.name",
                          String.valueOf(request.getDataTableRow().getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ListDataTableRowsRequest, ListDataTableRowsResponse>
        listDataTableRowsTransportSettings =
            HttpJsonCallSettings.<ListDataTableRowsRequest, ListDataTableRowsResponse>newBuilder()
                .setMethodDescriptor(listDataTableRowsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<GetDataTableRowRequest, DataTableRow> getDataTableRowTransportSettings =
        HttpJsonCallSettings.<GetDataTableRowRequest, DataTableRow>newBuilder()
            .setMethodDescriptor(getDataTableRowMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    HttpJsonCallSettings<DeleteDataTableRowRequest, Empty> deleteDataTableRowTransportSettings =
        HttpJsonCallSettings.<DeleteDataTableRowRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteDataTableRowMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    HttpJsonCallSettings<BulkCreateDataTableRowsRequest, BulkCreateDataTableRowsResponse>
        bulkCreateDataTableRowsTransportSettings =
            HttpJsonCallSettings
                .<BulkCreateDataTableRowsRequest, BulkCreateDataTableRowsResponse>newBuilder()
                .setMethodDescriptor(bulkCreateDataTableRowsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<BulkGetDataTableRowsRequest, BulkGetDataTableRowsResponse>
        bulkGetDataTableRowsTransportSettings =
            HttpJsonCallSettings
                .<BulkGetDataTableRowsRequest, BulkGetDataTableRowsResponse>newBuilder()
                .setMethodDescriptor(bulkGetDataTableRowsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<BulkReplaceDataTableRowsRequest, BulkReplaceDataTableRowsResponse>
        bulkReplaceDataTableRowsTransportSettings =
            HttpJsonCallSettings
                .<BulkReplaceDataTableRowsRequest, BulkReplaceDataTableRowsResponse>newBuilder()
                .setMethodDescriptor(bulkReplaceDataTableRowsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<BulkUpdateDataTableRowsRequest, BulkUpdateDataTableRowsResponse>
        bulkUpdateDataTableRowsTransportSettings =
            HttpJsonCallSettings
                .<BulkUpdateDataTableRowsRequest, BulkUpdateDataTableRowsResponse>newBuilder()
                .setMethodDescriptor(bulkUpdateDataTableRowsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<GetDataTableOperationErrorsRequest, DataTableOperationErrors>
        getDataTableOperationErrorsTransportSettings =
            HttpJsonCallSettings
                .<GetDataTableOperationErrorsRequest, DataTableOperationErrors>newBuilder()
                .setMethodDescriptor(getDataTableOperationErrorsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();

    this.createDataTableCallable =
        callableFactory.createUnaryCallable(
            createDataTableTransportSettings, settings.createDataTableSettings(), clientContext);
    this.listDataTablesCallable =
        callableFactory.createUnaryCallable(
            listDataTablesTransportSettings, settings.listDataTablesSettings(), clientContext);
    this.listDataTablesPagedCallable =
        callableFactory.createPagedCallable(
            listDataTablesTransportSettings, settings.listDataTablesSettings(), clientContext);
    this.getDataTableCallable =
        callableFactory.createUnaryCallable(
            getDataTableTransportSettings, settings.getDataTableSettings(), clientContext);
    this.updateDataTableCallable =
        callableFactory.createUnaryCallable(
            updateDataTableTransportSettings, settings.updateDataTableSettings(), clientContext);
    this.deleteDataTableCallable =
        callableFactory.createUnaryCallable(
            deleteDataTableTransportSettings, settings.deleteDataTableSettings(), clientContext);
    this.createDataTableRowCallable =
        callableFactory.createUnaryCallable(
            createDataTableRowTransportSettings,
            settings.createDataTableRowSettings(),
            clientContext);
    this.updateDataTableRowCallable =
        callableFactory.createUnaryCallable(
            updateDataTableRowTransportSettings,
            settings.updateDataTableRowSettings(),
            clientContext);
    this.listDataTableRowsCallable =
        callableFactory.createUnaryCallable(
            listDataTableRowsTransportSettings,
            settings.listDataTableRowsSettings(),
            clientContext);
    this.listDataTableRowsPagedCallable =
        callableFactory.createPagedCallable(
            listDataTableRowsTransportSettings,
            settings.listDataTableRowsSettings(),
            clientContext);
    this.getDataTableRowCallable =
        callableFactory.createUnaryCallable(
            getDataTableRowTransportSettings, settings.getDataTableRowSettings(), clientContext);
    this.deleteDataTableRowCallable =
        callableFactory.createUnaryCallable(
            deleteDataTableRowTransportSettings,
            settings.deleteDataTableRowSettings(),
            clientContext);
    this.bulkCreateDataTableRowsCallable =
        callableFactory.createUnaryCallable(
            bulkCreateDataTableRowsTransportSettings,
            settings.bulkCreateDataTableRowsSettings(),
            clientContext);
    this.bulkGetDataTableRowsCallable =
        callableFactory.createUnaryCallable(
            bulkGetDataTableRowsTransportSettings,
            settings.bulkGetDataTableRowsSettings(),
            clientContext);
    this.bulkReplaceDataTableRowsCallable =
        callableFactory.createUnaryCallable(
            bulkReplaceDataTableRowsTransportSettings,
            settings.bulkReplaceDataTableRowsSettings(),
            clientContext);
    this.bulkUpdateDataTableRowsCallable =
        callableFactory.createUnaryCallable(
            bulkUpdateDataTableRowsTransportSettings,
            settings.bulkUpdateDataTableRowsSettings(),
            clientContext);
    this.getDataTableOperationErrorsCallable =
        callableFactory.createUnaryCallable(
            getDataTableOperationErrorsTransportSettings,
            settings.getDataTableOperationErrorsSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(createDataTableMethodDescriptor);
    methodDescriptors.add(listDataTablesMethodDescriptor);
    methodDescriptors.add(getDataTableMethodDescriptor);
    methodDescriptors.add(updateDataTableMethodDescriptor);
    methodDescriptors.add(deleteDataTableMethodDescriptor);
    methodDescriptors.add(createDataTableRowMethodDescriptor);
    methodDescriptors.add(updateDataTableRowMethodDescriptor);
    methodDescriptors.add(listDataTableRowsMethodDescriptor);
    methodDescriptors.add(getDataTableRowMethodDescriptor);
    methodDescriptors.add(deleteDataTableRowMethodDescriptor);
    methodDescriptors.add(bulkCreateDataTableRowsMethodDescriptor);
    methodDescriptors.add(bulkGetDataTableRowsMethodDescriptor);
    methodDescriptors.add(bulkReplaceDataTableRowsMethodDescriptor);
    methodDescriptors.add(bulkUpdateDataTableRowsMethodDescriptor);
    methodDescriptors.add(getDataTableOperationErrorsMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<CreateDataTableRequest, DataTable> createDataTableCallable() {
    return createDataTableCallable;
  }

  @Override
  public UnaryCallable<ListDataTablesRequest, ListDataTablesResponse> listDataTablesCallable() {
    return listDataTablesCallable;
  }

  @Override
  public UnaryCallable<ListDataTablesRequest, ListDataTablesPagedResponse>
      listDataTablesPagedCallable() {
    return listDataTablesPagedCallable;
  }

  @Override
  public UnaryCallable<GetDataTableRequest, DataTable> getDataTableCallable() {
    return getDataTableCallable;
  }

  @Override
  public UnaryCallable<UpdateDataTableRequest, DataTable> updateDataTableCallable() {
    return updateDataTableCallable;
  }

  @Override
  public UnaryCallable<DeleteDataTableRequest, Empty> deleteDataTableCallable() {
    return deleteDataTableCallable;
  }

  @Override
  public UnaryCallable<CreateDataTableRowRequest, DataTableRow> createDataTableRowCallable() {
    return createDataTableRowCallable;
  }

  @Override
  public UnaryCallable<UpdateDataTableRowRequest, DataTableRow> updateDataTableRowCallable() {
    return updateDataTableRowCallable;
  }

  @Override
  public UnaryCallable<ListDataTableRowsRequest, ListDataTableRowsResponse>
      listDataTableRowsCallable() {
    return listDataTableRowsCallable;
  }

  @Override
  public UnaryCallable<ListDataTableRowsRequest, ListDataTableRowsPagedResponse>
      listDataTableRowsPagedCallable() {
    return listDataTableRowsPagedCallable;
  }

  @Override
  public UnaryCallable<GetDataTableRowRequest, DataTableRow> getDataTableRowCallable() {
    return getDataTableRowCallable;
  }

  @Override
  public UnaryCallable<DeleteDataTableRowRequest, Empty> deleteDataTableRowCallable() {
    return deleteDataTableRowCallable;
  }

  @Override
  public UnaryCallable<BulkCreateDataTableRowsRequest, BulkCreateDataTableRowsResponse>
      bulkCreateDataTableRowsCallable() {
    return bulkCreateDataTableRowsCallable;
  }

  @Override
  public UnaryCallable<BulkGetDataTableRowsRequest, BulkGetDataTableRowsResponse>
      bulkGetDataTableRowsCallable() {
    return bulkGetDataTableRowsCallable;
  }

  @Override
  public UnaryCallable<BulkReplaceDataTableRowsRequest, BulkReplaceDataTableRowsResponse>
      bulkReplaceDataTableRowsCallable() {
    return bulkReplaceDataTableRowsCallable;
  }

  @Override
  public UnaryCallable<BulkUpdateDataTableRowsRequest, BulkUpdateDataTableRowsResponse>
      bulkUpdateDataTableRowsCallable() {
    return bulkUpdateDataTableRowsCallable;
  }

  @Override
  public UnaryCallable<GetDataTableOperationErrorsRequest, DataTableOperationErrors>
      getDataTableOperationErrorsCallable() {
    return getDataTableOperationErrorsCallable;
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
