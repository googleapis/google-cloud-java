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

package com.google.cloud.firestore.v1.stub;

import static com.google.cloud.firestore.v1.FirestoreAdminClient.ListFieldsPagedResponse;
import static com.google.cloud.firestore.v1.FirestoreAdminClient.ListIndexesPagedResponse;

import com.google.api.HttpRule;
import com.google.api.core.InternalApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.httpjson.ApiMethodDescriptor;
import com.google.api.gax.httpjson.HttpJsonCallSettings;
import com.google.api.gax.httpjson.HttpJsonOperationSnapshot;
import com.google.api.gax.httpjson.HttpJsonStubCallableFactory;
import com.google.api.gax.httpjson.ProtoMessageRequestFormatter;
import com.google.api.gax.httpjson.ProtoMessageResponseParser;
import com.google.api.gax.httpjson.ProtoRestSerializer;
import com.google.api.gax.httpjson.longrunning.stub.HttpJsonOperationsStub;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.api.pathtemplate.PathTemplate;
import com.google.common.collect.ImmutableMap;
import com.google.firestore.admin.v1.Backup;
import com.google.firestore.admin.v1.BackupSchedule;
import com.google.firestore.admin.v1.BulkDeleteDocumentsMetadata;
import com.google.firestore.admin.v1.BulkDeleteDocumentsRequest;
import com.google.firestore.admin.v1.BulkDeleteDocumentsResponse;
import com.google.firestore.admin.v1.CloneDatabaseMetadata;
import com.google.firestore.admin.v1.CloneDatabaseRequest;
import com.google.firestore.admin.v1.CreateBackupScheduleRequest;
import com.google.firestore.admin.v1.CreateDatabaseMetadata;
import com.google.firestore.admin.v1.CreateDatabaseRequest;
import com.google.firestore.admin.v1.CreateIndexRequest;
import com.google.firestore.admin.v1.CreateUserCredsRequest;
import com.google.firestore.admin.v1.Database;
import com.google.firestore.admin.v1.DeleteBackupRequest;
import com.google.firestore.admin.v1.DeleteBackupScheduleRequest;
import com.google.firestore.admin.v1.DeleteDatabaseMetadata;
import com.google.firestore.admin.v1.DeleteDatabaseRequest;
import com.google.firestore.admin.v1.DeleteIndexRequest;
import com.google.firestore.admin.v1.DeleteUserCredsRequest;
import com.google.firestore.admin.v1.DisableUserCredsRequest;
import com.google.firestore.admin.v1.EnableUserCredsRequest;
import com.google.firestore.admin.v1.ExportDocumentsMetadata;
import com.google.firestore.admin.v1.ExportDocumentsRequest;
import com.google.firestore.admin.v1.ExportDocumentsResponse;
import com.google.firestore.admin.v1.Field;
import com.google.firestore.admin.v1.FieldOperationMetadata;
import com.google.firestore.admin.v1.GetBackupRequest;
import com.google.firestore.admin.v1.GetBackupScheduleRequest;
import com.google.firestore.admin.v1.GetDatabaseRequest;
import com.google.firestore.admin.v1.GetFieldRequest;
import com.google.firestore.admin.v1.GetIndexRequest;
import com.google.firestore.admin.v1.GetUserCredsRequest;
import com.google.firestore.admin.v1.ImportDocumentsMetadata;
import com.google.firestore.admin.v1.ImportDocumentsRequest;
import com.google.firestore.admin.v1.Index;
import com.google.firestore.admin.v1.IndexOperationMetadata;
import com.google.firestore.admin.v1.ListBackupSchedulesRequest;
import com.google.firestore.admin.v1.ListBackupSchedulesResponse;
import com.google.firestore.admin.v1.ListBackupsRequest;
import com.google.firestore.admin.v1.ListBackupsResponse;
import com.google.firestore.admin.v1.ListDatabasesRequest;
import com.google.firestore.admin.v1.ListDatabasesResponse;
import com.google.firestore.admin.v1.ListFieldsRequest;
import com.google.firestore.admin.v1.ListFieldsResponse;
import com.google.firestore.admin.v1.ListIndexesRequest;
import com.google.firestore.admin.v1.ListIndexesResponse;
import com.google.firestore.admin.v1.ListUserCredsRequest;
import com.google.firestore.admin.v1.ListUserCredsResponse;
import com.google.firestore.admin.v1.ResetUserPasswordRequest;
import com.google.firestore.admin.v1.RestoreDatabaseMetadata;
import com.google.firestore.admin.v1.RestoreDatabaseRequest;
import com.google.firestore.admin.v1.UpdateBackupScheduleRequest;
import com.google.firestore.admin.v1.UpdateDatabaseMetadata;
import com.google.firestore.admin.v1.UpdateDatabaseRequest;
import com.google.firestore.admin.v1.UpdateFieldRequest;
import com.google.firestore.admin.v1.UserCreds;
import com.google.longrunning.Operation;
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
 * REST stub implementation for the FirestoreAdmin service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class HttpJsonFirestoreAdminStub extends FirestoreAdminStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder()
          .add(ExportDocumentsResponse.getDescriptor())
          .add(Field.getDescriptor())
          .add(RestoreDatabaseMetadata.getDescriptor())
          .add(ImportDocumentsMetadata.getDescriptor())
          .add(Database.getDescriptor())
          .add(FieldOperationMetadata.getDescriptor())
          .add(BulkDeleteDocumentsResponse.getDescriptor())
          .add(DeleteDatabaseMetadata.getDescriptor())
          .add(BulkDeleteDocumentsMetadata.getDescriptor())
          .add(UpdateDatabaseMetadata.getDescriptor())
          .add(Empty.getDescriptor())
          .add(Index.getDescriptor())
          .add(CreateDatabaseMetadata.getDescriptor())
          .add(ExportDocumentsMetadata.getDescriptor())
          .add(CloneDatabaseMetadata.getDescriptor())
          .add(IndexOperationMetadata.getDescriptor())
          .build();

  private static final ApiMethodDescriptor<CreateIndexRequest, Operation>
      createIndexMethodDescriptor =
          ApiMethodDescriptor.<CreateIndexRequest, Operation>newBuilder()
              .setFullMethodName("google.firestore.admin.v1.FirestoreAdmin/CreateIndex")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateIndexRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/databases/*/collectionGroups/*}/indexes",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateIndexRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateIndexRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("index", request.getIndex(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateIndexRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<ListIndexesRequest, ListIndexesResponse>
      listIndexesMethodDescriptor =
          ApiMethodDescriptor.<ListIndexesRequest, ListIndexesResponse>newBuilder()
              .setFullMethodName("google.firestore.admin.v1.FirestoreAdmin/ListIndexes")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListIndexesRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/databases/*/collectionGroups/*}/indexes",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListIndexesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListIndexesRequest> serializer =
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
                  ProtoMessageResponseParser.<ListIndexesResponse>newBuilder()
                      .setDefaultInstance(ListIndexesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetIndexRequest, Index> getIndexMethodDescriptor =
      ApiMethodDescriptor.<GetIndexRequest, Index>newBuilder()
          .setFullMethodName("google.firestore.admin.v1.FirestoreAdmin/GetIndex")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetIndexRequest>newBuilder()
                  .setPath(
                      "/v1/{name=projects/*/databases/*/collectionGroups/*/indexes/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetIndexRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetIndexRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Index>newBuilder()
                  .setDefaultInstance(Index.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<DeleteIndexRequest, Empty> deleteIndexMethodDescriptor =
      ApiMethodDescriptor.<DeleteIndexRequest, Empty>newBuilder()
          .setFullMethodName("google.firestore.admin.v1.FirestoreAdmin/DeleteIndex")
          .setHttpMethod("DELETE")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<DeleteIndexRequest>newBuilder()
                  .setPath(
                      "/v1/{name=projects/*/databases/*/collectionGroups/*/indexes/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<DeleteIndexRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<DeleteIndexRequest> serializer =
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

  private static final ApiMethodDescriptor<GetFieldRequest, Field> getFieldMethodDescriptor =
      ApiMethodDescriptor.<GetFieldRequest, Field>newBuilder()
          .setFullMethodName("google.firestore.admin.v1.FirestoreAdmin/GetField")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetFieldRequest>newBuilder()
                  .setPath(
                      "/v1/{name=projects/*/databases/*/collectionGroups/*/fields/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetFieldRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetFieldRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Field>newBuilder()
                  .setDefaultInstance(Field.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<UpdateFieldRequest, Operation>
      updateFieldMethodDescriptor =
          ApiMethodDescriptor.<UpdateFieldRequest, Operation>newBuilder()
              .setFullMethodName("google.firestore.admin.v1.FirestoreAdmin/UpdateField")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateFieldRequest>newBuilder()
                      .setPath(
                          "/v1/{field.name=projects/*/databases/*/collectionGroups/*/fields/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateFieldRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "field.name", request.getField().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateFieldRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("field", request.getField(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateFieldRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<ListFieldsRequest, ListFieldsResponse>
      listFieldsMethodDescriptor =
          ApiMethodDescriptor.<ListFieldsRequest, ListFieldsResponse>newBuilder()
              .setFullMethodName("google.firestore.admin.v1.FirestoreAdmin/ListFields")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListFieldsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/databases/*/collectionGroups/*}/fields",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListFieldsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListFieldsRequest> serializer =
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
                  ProtoMessageResponseParser.<ListFieldsResponse>newBuilder()
                      .setDefaultInstance(ListFieldsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ExportDocumentsRequest, Operation>
      exportDocumentsMethodDescriptor =
          ApiMethodDescriptor.<ExportDocumentsRequest, Operation>newBuilder()
              .setFullMethodName("google.firestore.admin.v1.FirestoreAdmin/ExportDocuments")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ExportDocumentsRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/databases/*}:exportDocuments",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ExportDocumentsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ExportDocumentsRequest> serializer =
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
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (ExportDocumentsRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<ImportDocumentsRequest, Operation>
      importDocumentsMethodDescriptor =
          ApiMethodDescriptor.<ImportDocumentsRequest, Operation>newBuilder()
              .setFullMethodName("google.firestore.admin.v1.FirestoreAdmin/ImportDocuments")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ImportDocumentsRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/databases/*}:importDocuments",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ImportDocumentsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ImportDocumentsRequest> serializer =
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
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (ImportDocumentsRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<BulkDeleteDocumentsRequest, Operation>
      bulkDeleteDocumentsMethodDescriptor =
          ApiMethodDescriptor.<BulkDeleteDocumentsRequest, Operation>newBuilder()
              .setFullMethodName("google.firestore.admin.v1.FirestoreAdmin/BulkDeleteDocuments")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BulkDeleteDocumentsRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/databases/*}:bulkDeleteDocuments",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BulkDeleteDocumentsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BulkDeleteDocumentsRequest> serializer =
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
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (BulkDeleteDocumentsRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<CreateDatabaseRequest, Operation>
      createDatabaseMethodDescriptor =
          ApiMethodDescriptor.<CreateDatabaseRequest, Operation>newBuilder()
              .setFullMethodName("google.firestore.admin.v1.FirestoreAdmin/CreateDatabase")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateDatabaseRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*}/databases",
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
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateDatabaseRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<GetDatabaseRequest, Database>
      getDatabaseMethodDescriptor =
          ApiMethodDescriptor.<GetDatabaseRequest, Database>newBuilder()
              .setFullMethodName("google.firestore.admin.v1.FirestoreAdmin/GetDatabase")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetDatabaseRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/databases/*}",
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
              .setFullMethodName("google.firestore.admin.v1.FirestoreAdmin/ListDatabases")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListDatabasesRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*}/databases",
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
                            serializer.putQueryParam(
                                fields, "showDeleted", request.getShowDeleted());
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

  private static final ApiMethodDescriptor<UpdateDatabaseRequest, Operation>
      updateDatabaseMethodDescriptor =
          ApiMethodDescriptor.<UpdateDatabaseRequest, Operation>newBuilder()
              .setFullMethodName("google.firestore.admin.v1.FirestoreAdmin/UpdateDatabase")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateDatabaseRequest>newBuilder()
                      .setPath(
                          "/v1/{database.name=projects/*/databases/*}",
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
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateDatabaseRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeleteDatabaseRequest, Operation>
      deleteDatabaseMethodDescriptor =
          ApiMethodDescriptor.<DeleteDatabaseRequest, Operation>newBuilder()
              .setFullMethodName("google.firestore.admin.v1.FirestoreAdmin/DeleteDatabase")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteDatabaseRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/databases/*}",
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
                            serializer.putQueryParam(fields, "etag", request.getEtag());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (DeleteDatabaseRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<CreateUserCredsRequest, UserCreds>
      createUserCredsMethodDescriptor =
          ApiMethodDescriptor.<CreateUserCredsRequest, UserCreds>newBuilder()
              .setFullMethodName("google.firestore.admin.v1.FirestoreAdmin/CreateUserCreds")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateUserCredsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/databases/*}/userCreds",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateUserCredsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateUserCredsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "userCredsId", request.getUserCredsId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("userCreds", request.getUserCreds(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<UserCreds>newBuilder()
                      .setDefaultInstance(UserCreds.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetUserCredsRequest, UserCreds>
      getUserCredsMethodDescriptor =
          ApiMethodDescriptor.<GetUserCredsRequest, UserCreds>newBuilder()
              .setFullMethodName("google.firestore.admin.v1.FirestoreAdmin/GetUserCreds")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetUserCredsRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/databases/*/userCreds/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetUserCredsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetUserCredsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<UserCreds>newBuilder()
                      .setDefaultInstance(UserCreds.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListUserCredsRequest, ListUserCredsResponse>
      listUserCredsMethodDescriptor =
          ApiMethodDescriptor.<ListUserCredsRequest, ListUserCredsResponse>newBuilder()
              .setFullMethodName("google.firestore.admin.v1.FirestoreAdmin/ListUserCreds")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListUserCredsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/databases/*}/userCreds",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListUserCredsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListUserCredsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListUserCredsResponse>newBuilder()
                      .setDefaultInstance(ListUserCredsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<EnableUserCredsRequest, UserCreds>
      enableUserCredsMethodDescriptor =
          ApiMethodDescriptor.<EnableUserCredsRequest, UserCreds>newBuilder()
              .setFullMethodName("google.firestore.admin.v1.FirestoreAdmin/EnableUserCreds")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<EnableUserCredsRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/databases/*/userCreds/*}:enable",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<EnableUserCredsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<EnableUserCredsRequest> serializer =
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
                  ProtoMessageResponseParser.<UserCreds>newBuilder()
                      .setDefaultInstance(UserCreds.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DisableUserCredsRequest, UserCreds>
      disableUserCredsMethodDescriptor =
          ApiMethodDescriptor.<DisableUserCredsRequest, UserCreds>newBuilder()
              .setFullMethodName("google.firestore.admin.v1.FirestoreAdmin/DisableUserCreds")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DisableUserCredsRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/databases/*/userCreds/*}:disable",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DisableUserCredsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DisableUserCredsRequest> serializer =
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
                  ProtoMessageResponseParser.<UserCreds>newBuilder()
                      .setDefaultInstance(UserCreds.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ResetUserPasswordRequest, UserCreds>
      resetUserPasswordMethodDescriptor =
          ApiMethodDescriptor.<ResetUserPasswordRequest, UserCreds>newBuilder()
              .setFullMethodName("google.firestore.admin.v1.FirestoreAdmin/ResetUserPassword")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ResetUserPasswordRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/databases/*/userCreds/*}:resetPassword",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ResetUserPasswordRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ResetUserPasswordRequest> serializer =
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
                  ProtoMessageResponseParser.<UserCreds>newBuilder()
                      .setDefaultInstance(UserCreds.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteUserCredsRequest, Empty>
      deleteUserCredsMethodDescriptor =
          ApiMethodDescriptor.<DeleteUserCredsRequest, Empty>newBuilder()
              .setFullMethodName("google.firestore.admin.v1.FirestoreAdmin/DeleteUserCreds")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteUserCredsRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/databases/*/userCreds/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteUserCredsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteUserCredsRequest> serializer =
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

  private static final ApiMethodDescriptor<GetBackupRequest, Backup> getBackupMethodDescriptor =
      ApiMethodDescriptor.<GetBackupRequest, Backup>newBuilder()
          .setFullMethodName("google.firestore.admin.v1.FirestoreAdmin/GetBackup")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetBackupRequest>newBuilder()
                  .setPath(
                      "/v1/{name=projects/*/locations/*/backups/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetBackupRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetBackupRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Backup>newBuilder()
                  .setDefaultInstance(Backup.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<ListBackupsRequest, ListBackupsResponse>
      listBackupsMethodDescriptor =
          ApiMethodDescriptor.<ListBackupsRequest, ListBackupsResponse>newBuilder()
              .setFullMethodName("google.firestore.admin.v1.FirestoreAdmin/ListBackups")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListBackupsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/backups",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListBackupsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListBackupsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListBackupsResponse>newBuilder()
                      .setDefaultInstance(ListBackupsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteBackupRequest, Empty>
      deleteBackupMethodDescriptor =
          ApiMethodDescriptor.<DeleteBackupRequest, Empty>newBuilder()
              .setFullMethodName("google.firestore.admin.v1.FirestoreAdmin/DeleteBackup")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteBackupRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/backups/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteBackupRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteBackupRequest> serializer =
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

  private static final ApiMethodDescriptor<RestoreDatabaseRequest, Operation>
      restoreDatabaseMethodDescriptor =
          ApiMethodDescriptor.<RestoreDatabaseRequest, Operation>newBuilder()
              .setFullMethodName("google.firestore.admin.v1.FirestoreAdmin/RestoreDatabase")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<RestoreDatabaseRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*}/databases:restore",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<RestoreDatabaseRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<RestoreDatabaseRequest> serializer =
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
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (RestoreDatabaseRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<CreateBackupScheduleRequest, BackupSchedule>
      createBackupScheduleMethodDescriptor =
          ApiMethodDescriptor.<CreateBackupScheduleRequest, BackupSchedule>newBuilder()
              .setFullMethodName("google.firestore.admin.v1.FirestoreAdmin/CreateBackupSchedule")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateBackupScheduleRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/databases/*}/backupSchedules",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateBackupScheduleRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateBackupScheduleRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("backupSchedule", request.getBackupSchedule(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<BackupSchedule>newBuilder()
                      .setDefaultInstance(BackupSchedule.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetBackupScheduleRequest, BackupSchedule>
      getBackupScheduleMethodDescriptor =
          ApiMethodDescriptor.<GetBackupScheduleRequest, BackupSchedule>newBuilder()
              .setFullMethodName("google.firestore.admin.v1.FirestoreAdmin/GetBackupSchedule")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetBackupScheduleRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/databases/*/backupSchedules/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetBackupScheduleRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetBackupScheduleRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<BackupSchedule>newBuilder()
                      .setDefaultInstance(BackupSchedule.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListBackupSchedulesRequest, ListBackupSchedulesResponse>
      listBackupSchedulesMethodDescriptor =
          ApiMethodDescriptor.<ListBackupSchedulesRequest, ListBackupSchedulesResponse>newBuilder()
              .setFullMethodName("google.firestore.admin.v1.FirestoreAdmin/ListBackupSchedules")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListBackupSchedulesRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/databases/*}/backupSchedules",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListBackupSchedulesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListBackupSchedulesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListBackupSchedulesResponse>newBuilder()
                      .setDefaultInstance(ListBackupSchedulesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateBackupScheduleRequest, BackupSchedule>
      updateBackupScheduleMethodDescriptor =
          ApiMethodDescriptor.<UpdateBackupScheduleRequest, BackupSchedule>newBuilder()
              .setFullMethodName("google.firestore.admin.v1.FirestoreAdmin/UpdateBackupSchedule")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateBackupScheduleRequest>newBuilder()
                      .setPath(
                          "/v1/{backupSchedule.name=projects/*/databases/*/backupSchedules/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateBackupScheduleRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields,
                                "backupSchedule.name",
                                request.getBackupSchedule().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateBackupScheduleRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("backupSchedule", request.getBackupSchedule(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<BackupSchedule>newBuilder()
                      .setDefaultInstance(BackupSchedule.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteBackupScheduleRequest, Empty>
      deleteBackupScheduleMethodDescriptor =
          ApiMethodDescriptor.<DeleteBackupScheduleRequest, Empty>newBuilder()
              .setFullMethodName("google.firestore.admin.v1.FirestoreAdmin/DeleteBackupSchedule")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteBackupScheduleRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/databases/*/backupSchedules/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteBackupScheduleRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteBackupScheduleRequest> serializer =
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

  private static final ApiMethodDescriptor<CloneDatabaseRequest, Operation>
      cloneDatabaseMethodDescriptor =
          ApiMethodDescriptor.<CloneDatabaseRequest, Operation>newBuilder()
              .setFullMethodName("google.firestore.admin.v1.FirestoreAdmin/CloneDatabase")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CloneDatabaseRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*}/databases:clone",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CloneDatabaseRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CloneDatabaseRequest> serializer =
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
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CloneDatabaseRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private final UnaryCallable<CreateIndexRequest, Operation> createIndexCallable;
  private final OperationCallable<CreateIndexRequest, Index, IndexOperationMetadata>
      createIndexOperationCallable;
  private final UnaryCallable<ListIndexesRequest, ListIndexesResponse> listIndexesCallable;
  private final UnaryCallable<ListIndexesRequest, ListIndexesPagedResponse>
      listIndexesPagedCallable;
  private final UnaryCallable<GetIndexRequest, Index> getIndexCallable;
  private final UnaryCallable<DeleteIndexRequest, Empty> deleteIndexCallable;
  private final UnaryCallable<GetFieldRequest, Field> getFieldCallable;
  private final UnaryCallable<UpdateFieldRequest, Operation> updateFieldCallable;
  private final OperationCallable<UpdateFieldRequest, Field, FieldOperationMetadata>
      updateFieldOperationCallable;
  private final UnaryCallable<ListFieldsRequest, ListFieldsResponse> listFieldsCallable;
  private final UnaryCallable<ListFieldsRequest, ListFieldsPagedResponse> listFieldsPagedCallable;
  private final UnaryCallable<ExportDocumentsRequest, Operation> exportDocumentsCallable;
  private final OperationCallable<
          ExportDocumentsRequest, ExportDocumentsResponse, ExportDocumentsMetadata>
      exportDocumentsOperationCallable;
  private final UnaryCallable<ImportDocumentsRequest, Operation> importDocumentsCallable;
  private final OperationCallable<ImportDocumentsRequest, Empty, ImportDocumentsMetadata>
      importDocumentsOperationCallable;
  private final UnaryCallable<BulkDeleteDocumentsRequest, Operation> bulkDeleteDocumentsCallable;
  private final OperationCallable<
          BulkDeleteDocumentsRequest, BulkDeleteDocumentsResponse, BulkDeleteDocumentsMetadata>
      bulkDeleteDocumentsOperationCallable;
  private final UnaryCallable<CreateDatabaseRequest, Operation> createDatabaseCallable;
  private final OperationCallable<CreateDatabaseRequest, Database, CreateDatabaseMetadata>
      createDatabaseOperationCallable;
  private final UnaryCallable<GetDatabaseRequest, Database> getDatabaseCallable;
  private final UnaryCallable<ListDatabasesRequest, ListDatabasesResponse> listDatabasesCallable;
  private final UnaryCallable<UpdateDatabaseRequest, Operation> updateDatabaseCallable;
  private final OperationCallable<UpdateDatabaseRequest, Database, UpdateDatabaseMetadata>
      updateDatabaseOperationCallable;
  private final UnaryCallable<DeleteDatabaseRequest, Operation> deleteDatabaseCallable;
  private final OperationCallable<DeleteDatabaseRequest, Database, DeleteDatabaseMetadata>
      deleteDatabaseOperationCallable;
  private final UnaryCallable<CreateUserCredsRequest, UserCreds> createUserCredsCallable;
  private final UnaryCallable<GetUserCredsRequest, UserCreds> getUserCredsCallable;
  private final UnaryCallable<ListUserCredsRequest, ListUserCredsResponse> listUserCredsCallable;
  private final UnaryCallable<EnableUserCredsRequest, UserCreds> enableUserCredsCallable;
  private final UnaryCallable<DisableUserCredsRequest, UserCreds> disableUserCredsCallable;
  private final UnaryCallable<ResetUserPasswordRequest, UserCreds> resetUserPasswordCallable;
  private final UnaryCallable<DeleteUserCredsRequest, Empty> deleteUserCredsCallable;
  private final UnaryCallable<GetBackupRequest, Backup> getBackupCallable;
  private final UnaryCallable<ListBackupsRequest, ListBackupsResponse> listBackupsCallable;
  private final UnaryCallable<DeleteBackupRequest, Empty> deleteBackupCallable;
  private final UnaryCallable<RestoreDatabaseRequest, Operation> restoreDatabaseCallable;
  private final OperationCallable<RestoreDatabaseRequest, Database, RestoreDatabaseMetadata>
      restoreDatabaseOperationCallable;
  private final UnaryCallable<CreateBackupScheduleRequest, BackupSchedule>
      createBackupScheduleCallable;
  private final UnaryCallable<GetBackupScheduleRequest, BackupSchedule> getBackupScheduleCallable;
  private final UnaryCallable<ListBackupSchedulesRequest, ListBackupSchedulesResponse>
      listBackupSchedulesCallable;
  private final UnaryCallable<UpdateBackupScheduleRequest, BackupSchedule>
      updateBackupScheduleCallable;
  private final UnaryCallable<DeleteBackupScheduleRequest, Empty> deleteBackupScheduleCallable;
  private final UnaryCallable<CloneDatabaseRequest, Operation> cloneDatabaseCallable;
  private final OperationCallable<CloneDatabaseRequest, Database, CloneDatabaseMetadata>
      cloneDatabaseOperationCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  private static final PathTemplate CLONE_DATABASE_0_PATH_TEMPLATE =
      PathTemplate.create("projects/{project_id=*}/**");
  private static final PathTemplate CLONE_DATABASE_1_PATH_TEMPLATE =
      PathTemplate.create("projects/*/databases/{database_id=*}/**");

  public static final HttpJsonFirestoreAdminStub create(FirestoreAdminStubSettings settings)
      throws IOException {
    return new HttpJsonFirestoreAdminStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonFirestoreAdminStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonFirestoreAdminStub(
        FirestoreAdminStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonFirestoreAdminStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonFirestoreAdminStub(
        FirestoreAdminStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonFirestoreAdminStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonFirestoreAdminStub(
      FirestoreAdminStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonFirestoreAdminCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonFirestoreAdminStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonFirestoreAdminStub(
      FirestoreAdminStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.httpJsonOperationsStub =
        HttpJsonOperationsStub.create(
            clientContext,
            callableFactory,
            typeRegistry,
            ImmutableMap.<String, HttpRule>builder()
                .put(
                    "google.longrunning.Operations.CancelOperation",
                    HttpRule.newBuilder()
                        .setPost("/v1/{name=projects/*/databases/*/operations/*}:cancel")
                        .build())
                .put(
                    "google.longrunning.Operations.DeleteOperation",
                    HttpRule.newBuilder()
                        .setDelete("/v1/{name=projects/*/databases/*/operations/*}")
                        .build())
                .put(
                    "google.longrunning.Operations.GetOperation",
                    HttpRule.newBuilder()
                        .setGet("/v1/{name=projects/*/databases/*/operations/*}")
                        .build())
                .put(
                    "google.longrunning.Operations.ListOperations",
                    HttpRule.newBuilder()
                        .setGet("/v1/{name=projects/*/databases/*}/operations")
                        .build())
                .build());

    HttpJsonCallSettings<CreateIndexRequest, Operation> createIndexTransportSettings =
        HttpJsonCallSettings.<CreateIndexRequest, Operation>newBuilder()
            .setMethodDescriptor(createIndexMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListIndexesRequest, ListIndexesResponse> listIndexesTransportSettings =
        HttpJsonCallSettings.<ListIndexesRequest, ListIndexesResponse>newBuilder()
            .setMethodDescriptor(listIndexesMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<GetIndexRequest, Index> getIndexTransportSettings =
        HttpJsonCallSettings.<GetIndexRequest, Index>newBuilder()
            .setMethodDescriptor(getIndexMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeleteIndexRequest, Empty> deleteIndexTransportSettings =
        HttpJsonCallSettings.<DeleteIndexRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteIndexMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<GetFieldRequest, Field> getFieldTransportSettings =
        HttpJsonCallSettings.<GetFieldRequest, Field>newBuilder()
            .setMethodDescriptor(getFieldMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<UpdateFieldRequest, Operation> updateFieldTransportSettings =
        HttpJsonCallSettings.<UpdateFieldRequest, Operation>newBuilder()
            .setMethodDescriptor(updateFieldMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("field.name", String.valueOf(request.getField().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListFieldsRequest, ListFieldsResponse> listFieldsTransportSettings =
        HttpJsonCallSettings.<ListFieldsRequest, ListFieldsResponse>newBuilder()
            .setMethodDescriptor(listFieldsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ExportDocumentsRequest, Operation> exportDocumentsTransportSettings =
        HttpJsonCallSettings.<ExportDocumentsRequest, Operation>newBuilder()
            .setMethodDescriptor(exportDocumentsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ImportDocumentsRequest, Operation> importDocumentsTransportSettings =
        HttpJsonCallSettings.<ImportDocumentsRequest, Operation>newBuilder()
            .setMethodDescriptor(importDocumentsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<BulkDeleteDocumentsRequest, Operation>
        bulkDeleteDocumentsTransportSettings =
            HttpJsonCallSettings.<BulkDeleteDocumentsRequest, Operation>newBuilder()
                .setMethodDescriptor(bulkDeleteDocumentsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<CreateDatabaseRequest, Operation> createDatabaseTransportSettings =
        HttpJsonCallSettings.<CreateDatabaseRequest, Operation>newBuilder()
            .setMethodDescriptor(createDatabaseMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
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
    HttpJsonCallSettings<UpdateDatabaseRequest, Operation> updateDatabaseTransportSettings =
        HttpJsonCallSettings.<UpdateDatabaseRequest, Operation>newBuilder()
            .setMethodDescriptor(updateDatabaseMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("database.name", String.valueOf(request.getDatabase().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeleteDatabaseRequest, Operation> deleteDatabaseTransportSettings =
        HttpJsonCallSettings.<DeleteDatabaseRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteDatabaseMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<CreateUserCredsRequest, UserCreds> createUserCredsTransportSettings =
        HttpJsonCallSettings.<CreateUserCredsRequest, UserCreds>newBuilder()
            .setMethodDescriptor(createUserCredsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<GetUserCredsRequest, UserCreds> getUserCredsTransportSettings =
        HttpJsonCallSettings.<GetUserCredsRequest, UserCreds>newBuilder()
            .setMethodDescriptor(getUserCredsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListUserCredsRequest, ListUserCredsResponse>
        listUserCredsTransportSettings =
            HttpJsonCallSettings.<ListUserCredsRequest, ListUserCredsResponse>newBuilder()
                .setMethodDescriptor(listUserCredsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<EnableUserCredsRequest, UserCreds> enableUserCredsTransportSettings =
        HttpJsonCallSettings.<EnableUserCredsRequest, UserCreds>newBuilder()
            .setMethodDescriptor(enableUserCredsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DisableUserCredsRequest, UserCreds> disableUserCredsTransportSettings =
        HttpJsonCallSettings.<DisableUserCredsRequest, UserCreds>newBuilder()
            .setMethodDescriptor(disableUserCredsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ResetUserPasswordRequest, UserCreds> resetUserPasswordTransportSettings =
        HttpJsonCallSettings.<ResetUserPasswordRequest, UserCreds>newBuilder()
            .setMethodDescriptor(resetUserPasswordMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeleteUserCredsRequest, Empty> deleteUserCredsTransportSettings =
        HttpJsonCallSettings.<DeleteUserCredsRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteUserCredsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<GetBackupRequest, Backup> getBackupTransportSettings =
        HttpJsonCallSettings.<GetBackupRequest, Backup>newBuilder()
            .setMethodDescriptor(getBackupMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListBackupsRequest, ListBackupsResponse> listBackupsTransportSettings =
        HttpJsonCallSettings.<ListBackupsRequest, ListBackupsResponse>newBuilder()
            .setMethodDescriptor(listBackupsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeleteBackupRequest, Empty> deleteBackupTransportSettings =
        HttpJsonCallSettings.<DeleteBackupRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteBackupMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<RestoreDatabaseRequest, Operation> restoreDatabaseTransportSettings =
        HttpJsonCallSettings.<RestoreDatabaseRequest, Operation>newBuilder()
            .setMethodDescriptor(restoreDatabaseMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<CreateBackupScheduleRequest, BackupSchedule>
        createBackupScheduleTransportSettings =
            HttpJsonCallSettings.<CreateBackupScheduleRequest, BackupSchedule>newBuilder()
                .setMethodDescriptor(createBackupScheduleMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetBackupScheduleRequest, BackupSchedule>
        getBackupScheduleTransportSettings =
            HttpJsonCallSettings.<GetBackupScheduleRequest, BackupSchedule>newBuilder()
                .setMethodDescriptor(getBackupScheduleMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ListBackupSchedulesRequest, ListBackupSchedulesResponse>
        listBackupSchedulesTransportSettings =
            HttpJsonCallSettings
                .<ListBackupSchedulesRequest, ListBackupSchedulesResponse>newBuilder()
                .setMethodDescriptor(listBackupSchedulesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<UpdateBackupScheduleRequest, BackupSchedule>
        updateBackupScheduleTransportSettings =
            HttpJsonCallSettings.<UpdateBackupScheduleRequest, BackupSchedule>newBuilder()
                .setMethodDescriptor(updateBackupScheduleMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "backup_schedule.name",
                          String.valueOf(request.getBackupSchedule().getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<DeleteBackupScheduleRequest, Empty> deleteBackupScheduleTransportSettings =
        HttpJsonCallSettings.<DeleteBackupScheduleRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteBackupScheduleMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<CloneDatabaseRequest, Operation> cloneDatabaseTransportSettings =
        HttpJsonCallSettings.<CloneDatabaseRequest, Operation>newBuilder()
            .setMethodDescriptor(cloneDatabaseMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  if (request.getPitrSnapshot() != null) {
                    builder.add(
                        request.getPitrSnapshot().getDatabase(),
                        "project_id",
                        CLONE_DATABASE_0_PATH_TEMPLATE);
                  }
                  if (request.getPitrSnapshot() != null) {
                    builder.add(
                        request.getPitrSnapshot().getDatabase(),
                        "database_id",
                        CLONE_DATABASE_1_PATH_TEMPLATE);
                  }
                  return builder.build();
                })
            .build();

    this.createIndexCallable =
        callableFactory.createUnaryCallable(
            createIndexTransportSettings, settings.createIndexSettings(), clientContext);
    this.createIndexOperationCallable =
        callableFactory.createOperationCallable(
            createIndexTransportSettings,
            settings.createIndexOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.listIndexesCallable =
        callableFactory.createUnaryCallable(
            listIndexesTransportSettings, settings.listIndexesSettings(), clientContext);
    this.listIndexesPagedCallable =
        callableFactory.createPagedCallable(
            listIndexesTransportSettings, settings.listIndexesSettings(), clientContext);
    this.getIndexCallable =
        callableFactory.createUnaryCallable(
            getIndexTransportSettings, settings.getIndexSettings(), clientContext);
    this.deleteIndexCallable =
        callableFactory.createUnaryCallable(
            deleteIndexTransportSettings, settings.deleteIndexSettings(), clientContext);
    this.getFieldCallable =
        callableFactory.createUnaryCallable(
            getFieldTransportSettings, settings.getFieldSettings(), clientContext);
    this.updateFieldCallable =
        callableFactory.createUnaryCallable(
            updateFieldTransportSettings, settings.updateFieldSettings(), clientContext);
    this.updateFieldOperationCallable =
        callableFactory.createOperationCallable(
            updateFieldTransportSettings,
            settings.updateFieldOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.listFieldsCallable =
        callableFactory.createUnaryCallable(
            listFieldsTransportSettings, settings.listFieldsSettings(), clientContext);
    this.listFieldsPagedCallable =
        callableFactory.createPagedCallable(
            listFieldsTransportSettings, settings.listFieldsSettings(), clientContext);
    this.exportDocumentsCallable =
        callableFactory.createUnaryCallable(
            exportDocumentsTransportSettings, settings.exportDocumentsSettings(), clientContext);
    this.exportDocumentsOperationCallable =
        callableFactory.createOperationCallable(
            exportDocumentsTransportSettings,
            settings.exportDocumentsOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.importDocumentsCallable =
        callableFactory.createUnaryCallable(
            importDocumentsTransportSettings, settings.importDocumentsSettings(), clientContext);
    this.importDocumentsOperationCallable =
        callableFactory.createOperationCallable(
            importDocumentsTransportSettings,
            settings.importDocumentsOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.bulkDeleteDocumentsCallable =
        callableFactory.createUnaryCallable(
            bulkDeleteDocumentsTransportSettings,
            settings.bulkDeleteDocumentsSettings(),
            clientContext);
    this.bulkDeleteDocumentsOperationCallable =
        callableFactory.createOperationCallable(
            bulkDeleteDocumentsTransportSettings,
            settings.bulkDeleteDocumentsOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.createDatabaseCallable =
        callableFactory.createUnaryCallable(
            createDatabaseTransportSettings, settings.createDatabaseSettings(), clientContext);
    this.createDatabaseOperationCallable =
        callableFactory.createOperationCallable(
            createDatabaseTransportSettings,
            settings.createDatabaseOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.getDatabaseCallable =
        callableFactory.createUnaryCallable(
            getDatabaseTransportSettings, settings.getDatabaseSettings(), clientContext);
    this.listDatabasesCallable =
        callableFactory.createUnaryCallable(
            listDatabasesTransportSettings, settings.listDatabasesSettings(), clientContext);
    this.updateDatabaseCallable =
        callableFactory.createUnaryCallable(
            updateDatabaseTransportSettings, settings.updateDatabaseSettings(), clientContext);
    this.updateDatabaseOperationCallable =
        callableFactory.createOperationCallable(
            updateDatabaseTransportSettings,
            settings.updateDatabaseOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.deleteDatabaseCallable =
        callableFactory.createUnaryCallable(
            deleteDatabaseTransportSettings, settings.deleteDatabaseSettings(), clientContext);
    this.deleteDatabaseOperationCallable =
        callableFactory.createOperationCallable(
            deleteDatabaseTransportSettings,
            settings.deleteDatabaseOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.createUserCredsCallable =
        callableFactory.createUnaryCallable(
            createUserCredsTransportSettings, settings.createUserCredsSettings(), clientContext);
    this.getUserCredsCallable =
        callableFactory.createUnaryCallable(
            getUserCredsTransportSettings, settings.getUserCredsSettings(), clientContext);
    this.listUserCredsCallable =
        callableFactory.createUnaryCallable(
            listUserCredsTransportSettings, settings.listUserCredsSettings(), clientContext);
    this.enableUserCredsCallable =
        callableFactory.createUnaryCallable(
            enableUserCredsTransportSettings, settings.enableUserCredsSettings(), clientContext);
    this.disableUserCredsCallable =
        callableFactory.createUnaryCallable(
            disableUserCredsTransportSettings, settings.disableUserCredsSettings(), clientContext);
    this.resetUserPasswordCallable =
        callableFactory.createUnaryCallable(
            resetUserPasswordTransportSettings,
            settings.resetUserPasswordSettings(),
            clientContext);
    this.deleteUserCredsCallable =
        callableFactory.createUnaryCallable(
            deleteUserCredsTransportSettings, settings.deleteUserCredsSettings(), clientContext);
    this.getBackupCallable =
        callableFactory.createUnaryCallable(
            getBackupTransportSettings, settings.getBackupSettings(), clientContext);
    this.listBackupsCallable =
        callableFactory.createUnaryCallable(
            listBackupsTransportSettings, settings.listBackupsSettings(), clientContext);
    this.deleteBackupCallable =
        callableFactory.createUnaryCallable(
            deleteBackupTransportSettings, settings.deleteBackupSettings(), clientContext);
    this.restoreDatabaseCallable =
        callableFactory.createUnaryCallable(
            restoreDatabaseTransportSettings, settings.restoreDatabaseSettings(), clientContext);
    this.restoreDatabaseOperationCallable =
        callableFactory.createOperationCallable(
            restoreDatabaseTransportSettings,
            settings.restoreDatabaseOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.createBackupScheduleCallable =
        callableFactory.createUnaryCallable(
            createBackupScheduleTransportSettings,
            settings.createBackupScheduleSettings(),
            clientContext);
    this.getBackupScheduleCallable =
        callableFactory.createUnaryCallable(
            getBackupScheduleTransportSettings,
            settings.getBackupScheduleSettings(),
            clientContext);
    this.listBackupSchedulesCallable =
        callableFactory.createUnaryCallable(
            listBackupSchedulesTransportSettings,
            settings.listBackupSchedulesSettings(),
            clientContext);
    this.updateBackupScheduleCallable =
        callableFactory.createUnaryCallable(
            updateBackupScheduleTransportSettings,
            settings.updateBackupScheduleSettings(),
            clientContext);
    this.deleteBackupScheduleCallable =
        callableFactory.createUnaryCallable(
            deleteBackupScheduleTransportSettings,
            settings.deleteBackupScheduleSettings(),
            clientContext);
    this.cloneDatabaseCallable =
        callableFactory.createUnaryCallable(
            cloneDatabaseTransportSettings, settings.cloneDatabaseSettings(), clientContext);
    this.cloneDatabaseOperationCallable =
        callableFactory.createOperationCallable(
            cloneDatabaseTransportSettings,
            settings.cloneDatabaseOperationSettings(),
            clientContext,
            httpJsonOperationsStub);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(createIndexMethodDescriptor);
    methodDescriptors.add(listIndexesMethodDescriptor);
    methodDescriptors.add(getIndexMethodDescriptor);
    methodDescriptors.add(deleteIndexMethodDescriptor);
    methodDescriptors.add(getFieldMethodDescriptor);
    methodDescriptors.add(updateFieldMethodDescriptor);
    methodDescriptors.add(listFieldsMethodDescriptor);
    methodDescriptors.add(exportDocumentsMethodDescriptor);
    methodDescriptors.add(importDocumentsMethodDescriptor);
    methodDescriptors.add(bulkDeleteDocumentsMethodDescriptor);
    methodDescriptors.add(createDatabaseMethodDescriptor);
    methodDescriptors.add(getDatabaseMethodDescriptor);
    methodDescriptors.add(listDatabasesMethodDescriptor);
    methodDescriptors.add(updateDatabaseMethodDescriptor);
    methodDescriptors.add(deleteDatabaseMethodDescriptor);
    methodDescriptors.add(createUserCredsMethodDescriptor);
    methodDescriptors.add(getUserCredsMethodDescriptor);
    methodDescriptors.add(listUserCredsMethodDescriptor);
    methodDescriptors.add(enableUserCredsMethodDescriptor);
    methodDescriptors.add(disableUserCredsMethodDescriptor);
    methodDescriptors.add(resetUserPasswordMethodDescriptor);
    methodDescriptors.add(deleteUserCredsMethodDescriptor);
    methodDescriptors.add(getBackupMethodDescriptor);
    methodDescriptors.add(listBackupsMethodDescriptor);
    methodDescriptors.add(deleteBackupMethodDescriptor);
    methodDescriptors.add(restoreDatabaseMethodDescriptor);
    methodDescriptors.add(createBackupScheduleMethodDescriptor);
    methodDescriptors.add(getBackupScheduleMethodDescriptor);
    methodDescriptors.add(listBackupSchedulesMethodDescriptor);
    methodDescriptors.add(updateBackupScheduleMethodDescriptor);
    methodDescriptors.add(deleteBackupScheduleMethodDescriptor);
    methodDescriptors.add(cloneDatabaseMethodDescriptor);
    return methodDescriptors;
  }

  public HttpJsonOperationsStub getHttpJsonOperationsStub() {
    return httpJsonOperationsStub;
  }

  @Override
  public UnaryCallable<CreateIndexRequest, Operation> createIndexCallable() {
    return createIndexCallable;
  }

  @Override
  public OperationCallable<CreateIndexRequest, Index, IndexOperationMetadata>
      createIndexOperationCallable() {
    return createIndexOperationCallable;
  }

  @Override
  public UnaryCallable<ListIndexesRequest, ListIndexesResponse> listIndexesCallable() {
    return listIndexesCallable;
  }

  @Override
  public UnaryCallable<ListIndexesRequest, ListIndexesPagedResponse> listIndexesPagedCallable() {
    return listIndexesPagedCallable;
  }

  @Override
  public UnaryCallable<GetIndexRequest, Index> getIndexCallable() {
    return getIndexCallable;
  }

  @Override
  public UnaryCallable<DeleteIndexRequest, Empty> deleteIndexCallable() {
    return deleteIndexCallable;
  }

  @Override
  public UnaryCallable<GetFieldRequest, Field> getFieldCallable() {
    return getFieldCallable;
  }

  @Override
  public UnaryCallable<UpdateFieldRequest, Operation> updateFieldCallable() {
    return updateFieldCallable;
  }

  @Override
  public OperationCallable<UpdateFieldRequest, Field, FieldOperationMetadata>
      updateFieldOperationCallable() {
    return updateFieldOperationCallable;
  }

  @Override
  public UnaryCallable<ListFieldsRequest, ListFieldsResponse> listFieldsCallable() {
    return listFieldsCallable;
  }

  @Override
  public UnaryCallable<ListFieldsRequest, ListFieldsPagedResponse> listFieldsPagedCallable() {
    return listFieldsPagedCallable;
  }

  @Override
  public UnaryCallable<ExportDocumentsRequest, Operation> exportDocumentsCallable() {
    return exportDocumentsCallable;
  }

  @Override
  public OperationCallable<ExportDocumentsRequest, ExportDocumentsResponse, ExportDocumentsMetadata>
      exportDocumentsOperationCallable() {
    return exportDocumentsOperationCallable;
  }

  @Override
  public UnaryCallable<ImportDocumentsRequest, Operation> importDocumentsCallable() {
    return importDocumentsCallable;
  }

  @Override
  public OperationCallable<ImportDocumentsRequest, Empty, ImportDocumentsMetadata>
      importDocumentsOperationCallable() {
    return importDocumentsOperationCallable;
  }

  @Override
  public UnaryCallable<BulkDeleteDocumentsRequest, Operation> bulkDeleteDocumentsCallable() {
    return bulkDeleteDocumentsCallable;
  }

  @Override
  public OperationCallable<
          BulkDeleteDocumentsRequest, BulkDeleteDocumentsResponse, BulkDeleteDocumentsMetadata>
      bulkDeleteDocumentsOperationCallable() {
    return bulkDeleteDocumentsOperationCallable;
  }

  @Override
  public UnaryCallable<CreateDatabaseRequest, Operation> createDatabaseCallable() {
    return createDatabaseCallable;
  }

  @Override
  public OperationCallable<CreateDatabaseRequest, Database, CreateDatabaseMetadata>
      createDatabaseOperationCallable() {
    return createDatabaseOperationCallable;
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
  public UnaryCallable<UpdateDatabaseRequest, Operation> updateDatabaseCallable() {
    return updateDatabaseCallable;
  }

  @Override
  public OperationCallable<UpdateDatabaseRequest, Database, UpdateDatabaseMetadata>
      updateDatabaseOperationCallable() {
    return updateDatabaseOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteDatabaseRequest, Operation> deleteDatabaseCallable() {
    return deleteDatabaseCallable;
  }

  @Override
  public OperationCallable<DeleteDatabaseRequest, Database, DeleteDatabaseMetadata>
      deleteDatabaseOperationCallable() {
    return deleteDatabaseOperationCallable;
  }

  @Override
  public UnaryCallable<CreateUserCredsRequest, UserCreds> createUserCredsCallable() {
    return createUserCredsCallable;
  }

  @Override
  public UnaryCallable<GetUserCredsRequest, UserCreds> getUserCredsCallable() {
    return getUserCredsCallable;
  }

  @Override
  public UnaryCallable<ListUserCredsRequest, ListUserCredsResponse> listUserCredsCallable() {
    return listUserCredsCallable;
  }

  @Override
  public UnaryCallable<EnableUserCredsRequest, UserCreds> enableUserCredsCallable() {
    return enableUserCredsCallable;
  }

  @Override
  public UnaryCallable<DisableUserCredsRequest, UserCreds> disableUserCredsCallable() {
    return disableUserCredsCallable;
  }

  @Override
  public UnaryCallable<ResetUserPasswordRequest, UserCreds> resetUserPasswordCallable() {
    return resetUserPasswordCallable;
  }

  @Override
  public UnaryCallable<DeleteUserCredsRequest, Empty> deleteUserCredsCallable() {
    return deleteUserCredsCallable;
  }

  @Override
  public UnaryCallable<GetBackupRequest, Backup> getBackupCallable() {
    return getBackupCallable;
  }

  @Override
  public UnaryCallable<ListBackupsRequest, ListBackupsResponse> listBackupsCallable() {
    return listBackupsCallable;
  }

  @Override
  public UnaryCallable<DeleteBackupRequest, Empty> deleteBackupCallable() {
    return deleteBackupCallable;
  }

  @Override
  public UnaryCallable<RestoreDatabaseRequest, Operation> restoreDatabaseCallable() {
    return restoreDatabaseCallable;
  }

  @Override
  public OperationCallable<RestoreDatabaseRequest, Database, RestoreDatabaseMetadata>
      restoreDatabaseOperationCallable() {
    return restoreDatabaseOperationCallable;
  }

  @Override
  public UnaryCallable<CreateBackupScheduleRequest, BackupSchedule> createBackupScheduleCallable() {
    return createBackupScheduleCallable;
  }

  @Override
  public UnaryCallable<GetBackupScheduleRequest, BackupSchedule> getBackupScheduleCallable() {
    return getBackupScheduleCallable;
  }

  @Override
  public UnaryCallable<ListBackupSchedulesRequest, ListBackupSchedulesResponse>
      listBackupSchedulesCallable() {
    return listBackupSchedulesCallable;
  }

  @Override
  public UnaryCallable<UpdateBackupScheduleRequest, BackupSchedule> updateBackupScheduleCallable() {
    return updateBackupScheduleCallable;
  }

  @Override
  public UnaryCallable<DeleteBackupScheduleRequest, Empty> deleteBackupScheduleCallable() {
    return deleteBackupScheduleCallable;
  }

  @Override
  public UnaryCallable<CloneDatabaseRequest, Operation> cloneDatabaseCallable() {
    return cloneDatabaseCallable;
  }

  @Override
  public OperationCallable<CloneDatabaseRequest, Database, CloneDatabaseMetadata>
      cloneDatabaseOperationCallable() {
    return cloneDatabaseOperationCallable;
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
