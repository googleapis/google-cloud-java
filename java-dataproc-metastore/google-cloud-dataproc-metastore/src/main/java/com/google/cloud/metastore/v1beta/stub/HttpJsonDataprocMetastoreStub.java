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

package com.google.cloud.metastore.v1beta.stub;

import static com.google.cloud.metastore.v1beta.DataprocMetastoreClient.ListBackupsPagedResponse;
import static com.google.cloud.metastore.v1beta.DataprocMetastoreClient.ListMetadataImportsPagedResponse;
import static com.google.cloud.metastore.v1beta.DataprocMetastoreClient.ListServicesPagedResponse;

import com.google.api.core.BetaApi;
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
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.metastore.v1beta.AlterMetadataResourceLocationRequest;
import com.google.cloud.metastore.v1beta.AlterMetadataResourceLocationResponse;
import com.google.cloud.metastore.v1beta.Backup;
import com.google.cloud.metastore.v1beta.CreateBackupRequest;
import com.google.cloud.metastore.v1beta.CreateMetadataImportRequest;
import com.google.cloud.metastore.v1beta.CreateServiceRequest;
import com.google.cloud.metastore.v1beta.DeleteBackupRequest;
import com.google.cloud.metastore.v1beta.DeleteServiceRequest;
import com.google.cloud.metastore.v1beta.ExportMetadataRequest;
import com.google.cloud.metastore.v1beta.GetBackupRequest;
import com.google.cloud.metastore.v1beta.GetMetadataImportRequest;
import com.google.cloud.metastore.v1beta.GetServiceRequest;
import com.google.cloud.metastore.v1beta.ListBackupsRequest;
import com.google.cloud.metastore.v1beta.ListBackupsResponse;
import com.google.cloud.metastore.v1beta.ListMetadataImportsRequest;
import com.google.cloud.metastore.v1beta.ListMetadataImportsResponse;
import com.google.cloud.metastore.v1beta.ListServicesRequest;
import com.google.cloud.metastore.v1beta.ListServicesResponse;
import com.google.cloud.metastore.v1beta.MetadataExport;
import com.google.cloud.metastore.v1beta.MetadataImport;
import com.google.cloud.metastore.v1beta.MoveTableToDatabaseRequest;
import com.google.cloud.metastore.v1beta.MoveTableToDatabaseResponse;
import com.google.cloud.metastore.v1beta.OperationMetadata;
import com.google.cloud.metastore.v1beta.QueryMetadataRequest;
import com.google.cloud.metastore.v1beta.QueryMetadataResponse;
import com.google.cloud.metastore.v1beta.RemoveIamPolicyRequest;
import com.google.cloud.metastore.v1beta.RemoveIamPolicyResponse;
import com.google.cloud.metastore.v1beta.Restore;
import com.google.cloud.metastore.v1beta.RestoreServiceRequest;
import com.google.cloud.metastore.v1beta.Service;
import com.google.cloud.metastore.v1beta.UpdateMetadataImportRequest;
import com.google.cloud.metastore.v1beta.UpdateServiceRequest;
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
 * REST stub implementation for the DataprocMetastore service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class HttpJsonDataprocMetastoreStub extends DataprocMetastoreStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder()
          .add(OperationMetadata.getDescriptor())
          .add(Empty.getDescriptor())
          .add(MetadataImport.getDescriptor())
          .add(MoveTableToDatabaseResponse.getDescriptor())
          .add(AlterMetadataResourceLocationResponse.getDescriptor())
          .add(QueryMetadataResponse.getDescriptor())
          .add(Restore.getDescriptor())
          .add(Service.getDescriptor())
          .add(Backup.getDescriptor())
          .add(MetadataExport.getDescriptor())
          .build();

  private static final ApiMethodDescriptor<ListServicesRequest, ListServicesResponse>
      listServicesMethodDescriptor =
          ApiMethodDescriptor.<ListServicesRequest, ListServicesResponse>newBuilder()
              .setFullMethodName("google.cloud.metastore.v1beta.DataprocMetastore/ListServices")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListServicesRequest>newBuilder()
                      .setPath(
                          "/v1beta/{parent=projects/*/locations/*}/services",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListServicesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListServicesRequest> serializer =
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
                  ProtoMessageResponseParser.<ListServicesResponse>newBuilder()
                      .setDefaultInstance(ListServicesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetServiceRequest, Service> getServiceMethodDescriptor =
      ApiMethodDescriptor.<GetServiceRequest, Service>newBuilder()
          .setFullMethodName("google.cloud.metastore.v1beta.DataprocMetastore/GetService")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetServiceRequest>newBuilder()
                  .setPath(
                      "/v1beta/{name=projects/*/locations/*/services/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetServiceRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetServiceRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Service>newBuilder()
                  .setDefaultInstance(Service.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<CreateServiceRequest, Operation>
      createServiceMethodDescriptor =
          ApiMethodDescriptor.<CreateServiceRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.metastore.v1beta.DataprocMetastore/CreateService")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateServiceRequest>newBuilder()
                      .setPath(
                          "/v1beta/{parent=projects/*/locations/*}/services",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateServiceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateServiceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "serviceId", request.getServiceId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("service", request.getService(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateServiceRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<UpdateServiceRequest, Operation>
      updateServiceMethodDescriptor =
          ApiMethodDescriptor.<UpdateServiceRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.metastore.v1beta.DataprocMetastore/UpdateService")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateServiceRequest>newBuilder()
                      .setPath(
                          "/v1beta/{service.name=projects/*/locations/*/services/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateServiceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "service.name", request.getService().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateServiceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("service", request.getService(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateServiceRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeleteServiceRequest, Operation>
      deleteServiceMethodDescriptor =
          ApiMethodDescriptor.<DeleteServiceRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.metastore.v1beta.DataprocMetastore/DeleteService")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteServiceRequest>newBuilder()
                      .setPath(
                          "/v1beta/{name=projects/*/locations/*/services/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteServiceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteServiceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
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
                  (DeleteServiceRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<ListMetadataImportsRequest, ListMetadataImportsResponse>
      listMetadataImportsMethodDescriptor =
          ApiMethodDescriptor.<ListMetadataImportsRequest, ListMetadataImportsResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.metastore.v1beta.DataprocMetastore/ListMetadataImports")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListMetadataImportsRequest>newBuilder()
                      .setPath(
                          "/v1beta/{parent=projects/*/locations/*/services/*}/metadataImports",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListMetadataImportsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListMetadataImportsRequest> serializer =
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
                  ProtoMessageResponseParser.<ListMetadataImportsResponse>newBuilder()
                      .setDefaultInstance(ListMetadataImportsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetMetadataImportRequest, MetadataImport>
      getMetadataImportMethodDescriptor =
          ApiMethodDescriptor.<GetMetadataImportRequest, MetadataImport>newBuilder()
              .setFullMethodName(
                  "google.cloud.metastore.v1beta.DataprocMetastore/GetMetadataImport")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetMetadataImportRequest>newBuilder()
                      .setPath(
                          "/v1beta/{name=projects/*/locations/*/services/*/metadataImports/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetMetadataImportRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetMetadataImportRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<MetadataImport>newBuilder()
                      .setDefaultInstance(MetadataImport.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateMetadataImportRequest, Operation>
      createMetadataImportMethodDescriptor =
          ApiMethodDescriptor.<CreateMetadataImportRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.metastore.v1beta.DataprocMetastore/CreateMetadataImport")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateMetadataImportRequest>newBuilder()
                      .setPath(
                          "/v1beta/{parent=projects/*/locations/*/services/*}/metadataImports",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateMetadataImportRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateMetadataImportRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "metadataImportId", request.getMetadataImportId());
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("metadataImport", request.getMetadataImport(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateMetadataImportRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<UpdateMetadataImportRequest, Operation>
      updateMetadataImportMethodDescriptor =
          ApiMethodDescriptor.<UpdateMetadataImportRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.metastore.v1beta.DataprocMetastore/UpdateMetadataImport")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateMetadataImportRequest>newBuilder()
                      .setPath(
                          "/v1beta/{metadataImport.name=projects/*/locations/*/services/*/metadataImports/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateMetadataImportRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields,
                                "metadataImport.name",
                                request.getMetadataImport().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateMetadataImportRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("metadataImport", request.getMetadataImport(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateMetadataImportRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<ExportMetadataRequest, Operation>
      exportMetadataMethodDescriptor =
          ApiMethodDescriptor.<ExportMetadataRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.metastore.v1beta.DataprocMetastore/ExportMetadata")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ExportMetadataRequest>newBuilder()
                      .setPath(
                          "/v1beta/{service=projects/*/locations/*/services/*}:exportMetadata",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ExportMetadataRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "service", request.getService());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ExportMetadataRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearService().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (ExportMetadataRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<RestoreServiceRequest, Operation>
      restoreServiceMethodDescriptor =
          ApiMethodDescriptor.<RestoreServiceRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.metastore.v1beta.DataprocMetastore/RestoreService")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<RestoreServiceRequest>newBuilder()
                      .setPath(
                          "/v1beta/{service=projects/*/locations/*/services/*}:restore",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<RestoreServiceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "service", request.getService());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<RestoreServiceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearService().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (RestoreServiceRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<ListBackupsRequest, ListBackupsResponse>
      listBackupsMethodDescriptor =
          ApiMethodDescriptor.<ListBackupsRequest, ListBackupsResponse>newBuilder()
              .setFullMethodName("google.cloud.metastore.v1beta.DataprocMetastore/ListBackups")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListBackupsRequest>newBuilder()
                      .setPath(
                          "/v1beta/{parent=projects/*/locations/*/services/*}/backups",
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
                            serializer.putQueryParam(fields, "orderBy", request.getOrderBy());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
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

  private static final ApiMethodDescriptor<GetBackupRequest, Backup> getBackupMethodDescriptor =
      ApiMethodDescriptor.<GetBackupRequest, Backup>newBuilder()
          .setFullMethodName("google.cloud.metastore.v1beta.DataprocMetastore/GetBackup")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetBackupRequest>newBuilder()
                  .setPath(
                      "/v1beta/{name=projects/*/locations/*/services/*/backups/*}",
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

  private static final ApiMethodDescriptor<CreateBackupRequest, Operation>
      createBackupMethodDescriptor =
          ApiMethodDescriptor.<CreateBackupRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.metastore.v1beta.DataprocMetastore/CreateBackup")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateBackupRequest>newBuilder()
                      .setPath(
                          "/v1beta/{parent=projects/*/locations/*/services/*}/backups",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateBackupRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateBackupRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "backupId", request.getBackupId());
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("backup", request.getBackup(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateBackupRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeleteBackupRequest, Operation>
      deleteBackupMethodDescriptor =
          ApiMethodDescriptor.<DeleteBackupRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.metastore.v1beta.DataprocMetastore/DeleteBackup")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteBackupRequest>newBuilder()
                      .setPath(
                          "/v1beta/{name=projects/*/locations/*/services/*/backups/*}",
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
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
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
                  (DeleteBackupRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<RemoveIamPolicyRequest, RemoveIamPolicyResponse>
      removeIamPolicyMethodDescriptor =
          ApiMethodDescriptor.<RemoveIamPolicyRequest, RemoveIamPolicyResponse>newBuilder()
              .setFullMethodName("google.cloud.metastore.v1beta.DataprocMetastore/RemoveIamPolicy")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<RemoveIamPolicyRequest>newBuilder()
                      .setPath(
                          "/v1beta/{resource=projects/*/locations/*/services/*/**}:removeIamPolicy",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<RemoveIamPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "resource", request.getResource());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<RemoveIamPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearResource().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<RemoveIamPolicyResponse>newBuilder()
                      .setDefaultInstance(RemoveIamPolicyResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<QueryMetadataRequest, Operation>
      queryMetadataMethodDescriptor =
          ApiMethodDescriptor.<QueryMetadataRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.metastore.v1beta.DataprocMetastore/QueryMetadata")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<QueryMetadataRequest>newBuilder()
                      .setPath(
                          "/v1beta/{service=projects/*/locations/*/services/*}:queryMetadata",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<QueryMetadataRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "service", request.getService());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<QueryMetadataRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearService().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (QueryMetadataRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<MoveTableToDatabaseRequest, Operation>
      moveTableToDatabaseMethodDescriptor =
          ApiMethodDescriptor.<MoveTableToDatabaseRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.metastore.v1beta.DataprocMetastore/MoveTableToDatabase")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<MoveTableToDatabaseRequest>newBuilder()
                      .setPath(
                          "/v1beta/{service=projects/*/locations/*/services/*}:moveTableToDatabase",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<MoveTableToDatabaseRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "service", request.getService());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<MoveTableToDatabaseRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearService().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (MoveTableToDatabaseRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<AlterMetadataResourceLocationRequest, Operation>
      alterMetadataResourceLocationMethodDescriptor =
          ApiMethodDescriptor.<AlterMetadataResourceLocationRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.metastore.v1beta.DataprocMetastore/AlterMetadataResourceLocation")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<AlterMetadataResourceLocationRequest>newBuilder()
                      .setPath(
                          "/v1beta/{service=projects/*/locations/*/services/*}:alterLocation",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<AlterMetadataResourceLocationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "service", request.getService());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<AlterMetadataResourceLocationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearService().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (AlterMetadataResourceLocationRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private final UnaryCallable<ListServicesRequest, ListServicesResponse> listServicesCallable;
  private final UnaryCallable<ListServicesRequest, ListServicesPagedResponse>
      listServicesPagedCallable;
  private final UnaryCallable<GetServiceRequest, Service> getServiceCallable;
  private final UnaryCallable<CreateServiceRequest, Operation> createServiceCallable;
  private final OperationCallable<CreateServiceRequest, Service, OperationMetadata>
      createServiceOperationCallable;
  private final UnaryCallable<UpdateServiceRequest, Operation> updateServiceCallable;
  private final OperationCallable<UpdateServiceRequest, Service, OperationMetadata>
      updateServiceOperationCallable;
  private final UnaryCallable<DeleteServiceRequest, Operation> deleteServiceCallable;
  private final OperationCallable<DeleteServiceRequest, Empty, OperationMetadata>
      deleteServiceOperationCallable;
  private final UnaryCallable<ListMetadataImportsRequest, ListMetadataImportsResponse>
      listMetadataImportsCallable;
  private final UnaryCallable<ListMetadataImportsRequest, ListMetadataImportsPagedResponse>
      listMetadataImportsPagedCallable;
  private final UnaryCallable<GetMetadataImportRequest, MetadataImport> getMetadataImportCallable;
  private final UnaryCallable<CreateMetadataImportRequest, Operation> createMetadataImportCallable;
  private final OperationCallable<CreateMetadataImportRequest, MetadataImport, OperationMetadata>
      createMetadataImportOperationCallable;
  private final UnaryCallable<UpdateMetadataImportRequest, Operation> updateMetadataImportCallable;
  private final OperationCallable<UpdateMetadataImportRequest, MetadataImport, OperationMetadata>
      updateMetadataImportOperationCallable;
  private final UnaryCallable<ExportMetadataRequest, Operation> exportMetadataCallable;
  private final OperationCallable<ExportMetadataRequest, MetadataExport, OperationMetadata>
      exportMetadataOperationCallable;
  private final UnaryCallable<RestoreServiceRequest, Operation> restoreServiceCallable;
  private final OperationCallable<RestoreServiceRequest, Restore, OperationMetadata>
      restoreServiceOperationCallable;
  private final UnaryCallable<ListBackupsRequest, ListBackupsResponse> listBackupsCallable;
  private final UnaryCallable<ListBackupsRequest, ListBackupsPagedResponse>
      listBackupsPagedCallable;
  private final UnaryCallable<GetBackupRequest, Backup> getBackupCallable;
  private final UnaryCallable<CreateBackupRequest, Operation> createBackupCallable;
  private final OperationCallable<CreateBackupRequest, Backup, OperationMetadata>
      createBackupOperationCallable;
  private final UnaryCallable<DeleteBackupRequest, Operation> deleteBackupCallable;
  private final OperationCallable<DeleteBackupRequest, Empty, OperationMetadata>
      deleteBackupOperationCallable;
  private final UnaryCallable<RemoveIamPolicyRequest, RemoveIamPolicyResponse>
      removeIamPolicyCallable;
  private final UnaryCallable<QueryMetadataRequest, Operation> queryMetadataCallable;
  private final OperationCallable<QueryMetadataRequest, QueryMetadataResponse, OperationMetadata>
      queryMetadataOperationCallable;
  private final UnaryCallable<MoveTableToDatabaseRequest, Operation> moveTableToDatabaseCallable;
  private final OperationCallable<
          MoveTableToDatabaseRequest, MoveTableToDatabaseResponse, OperationMetadata>
      moveTableToDatabaseOperationCallable;
  private final UnaryCallable<AlterMetadataResourceLocationRequest, Operation>
      alterMetadataResourceLocationCallable;
  private final OperationCallable<
          AlterMetadataResourceLocationRequest,
          AlterMetadataResourceLocationResponse,
          OperationMetadata>
      alterMetadataResourceLocationOperationCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonDataprocMetastoreStub create(DataprocMetastoreStubSettings settings)
      throws IOException {
    return new HttpJsonDataprocMetastoreStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonDataprocMetastoreStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonDataprocMetastoreStub(
        DataprocMetastoreStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonDataprocMetastoreStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonDataprocMetastoreStub(
        DataprocMetastoreStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonDataprocMetastoreStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonDataprocMetastoreStub(
      DataprocMetastoreStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonDataprocMetastoreCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonDataprocMetastoreStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonDataprocMetastoreStub(
      DataprocMetastoreStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.httpJsonOperationsStub =
        HttpJsonOperationsStub.create(clientContext, callableFactory, typeRegistry);

    HttpJsonCallSettings<ListServicesRequest, ListServicesResponse> listServicesTransportSettings =
        HttpJsonCallSettings.<ListServicesRequest, ListServicesResponse>newBuilder()
            .setMethodDescriptor(listServicesMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<GetServiceRequest, Service> getServiceTransportSettings =
        HttpJsonCallSettings.<GetServiceRequest, Service>newBuilder()
            .setMethodDescriptor(getServiceMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<CreateServiceRequest, Operation> createServiceTransportSettings =
        HttpJsonCallSettings.<CreateServiceRequest, Operation>newBuilder()
            .setMethodDescriptor(createServiceMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<UpdateServiceRequest, Operation> updateServiceTransportSettings =
        HttpJsonCallSettings.<UpdateServiceRequest, Operation>newBuilder()
            .setMethodDescriptor(updateServiceMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<DeleteServiceRequest, Operation> deleteServiceTransportSettings =
        HttpJsonCallSettings.<DeleteServiceRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteServiceMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ListMetadataImportsRequest, ListMetadataImportsResponse>
        listMetadataImportsTransportSettings =
            HttpJsonCallSettings
                .<ListMetadataImportsRequest, ListMetadataImportsResponse>newBuilder()
                .setMethodDescriptor(listMetadataImportsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GetMetadataImportRequest, MetadataImport>
        getMetadataImportTransportSettings =
            HttpJsonCallSettings.<GetMetadataImportRequest, MetadataImport>newBuilder()
                .setMethodDescriptor(getMetadataImportMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<CreateMetadataImportRequest, Operation>
        createMetadataImportTransportSettings =
            HttpJsonCallSettings.<CreateMetadataImportRequest, Operation>newBuilder()
                .setMethodDescriptor(createMetadataImportMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<UpdateMetadataImportRequest, Operation>
        updateMetadataImportTransportSettings =
            HttpJsonCallSettings.<UpdateMetadataImportRequest, Operation>newBuilder()
                .setMethodDescriptor(updateMetadataImportMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<ExportMetadataRequest, Operation> exportMetadataTransportSettings =
        HttpJsonCallSettings.<ExportMetadataRequest, Operation>newBuilder()
            .setMethodDescriptor(exportMetadataMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<RestoreServiceRequest, Operation> restoreServiceTransportSettings =
        HttpJsonCallSettings.<RestoreServiceRequest, Operation>newBuilder()
            .setMethodDescriptor(restoreServiceMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ListBackupsRequest, ListBackupsResponse> listBackupsTransportSettings =
        HttpJsonCallSettings.<ListBackupsRequest, ListBackupsResponse>newBuilder()
            .setMethodDescriptor(listBackupsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<GetBackupRequest, Backup> getBackupTransportSettings =
        HttpJsonCallSettings.<GetBackupRequest, Backup>newBuilder()
            .setMethodDescriptor(getBackupMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<CreateBackupRequest, Operation> createBackupTransportSettings =
        HttpJsonCallSettings.<CreateBackupRequest, Operation>newBuilder()
            .setMethodDescriptor(createBackupMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<DeleteBackupRequest, Operation> deleteBackupTransportSettings =
        HttpJsonCallSettings.<DeleteBackupRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteBackupMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<RemoveIamPolicyRequest, RemoveIamPolicyResponse>
        removeIamPolicyTransportSettings =
            HttpJsonCallSettings.<RemoveIamPolicyRequest, RemoveIamPolicyResponse>newBuilder()
                .setMethodDescriptor(removeIamPolicyMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<QueryMetadataRequest, Operation> queryMetadataTransportSettings =
        HttpJsonCallSettings.<QueryMetadataRequest, Operation>newBuilder()
            .setMethodDescriptor(queryMetadataMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<MoveTableToDatabaseRequest, Operation>
        moveTableToDatabaseTransportSettings =
            HttpJsonCallSettings.<MoveTableToDatabaseRequest, Operation>newBuilder()
                .setMethodDescriptor(moveTableToDatabaseMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<AlterMetadataResourceLocationRequest, Operation>
        alterMetadataResourceLocationTransportSettings =
            HttpJsonCallSettings.<AlterMetadataResourceLocationRequest, Operation>newBuilder()
                .setMethodDescriptor(alterMetadataResourceLocationMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();

    this.listServicesCallable =
        callableFactory.createUnaryCallable(
            listServicesTransportSettings, settings.listServicesSettings(), clientContext);
    this.listServicesPagedCallable =
        callableFactory.createPagedCallable(
            listServicesTransportSettings, settings.listServicesSettings(), clientContext);
    this.getServiceCallable =
        callableFactory.createUnaryCallable(
            getServiceTransportSettings, settings.getServiceSettings(), clientContext);
    this.createServiceCallable =
        callableFactory.createUnaryCallable(
            createServiceTransportSettings, settings.createServiceSettings(), clientContext);
    this.createServiceOperationCallable =
        callableFactory.createOperationCallable(
            createServiceTransportSettings,
            settings.createServiceOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.updateServiceCallable =
        callableFactory.createUnaryCallable(
            updateServiceTransportSettings, settings.updateServiceSettings(), clientContext);
    this.updateServiceOperationCallable =
        callableFactory.createOperationCallable(
            updateServiceTransportSettings,
            settings.updateServiceOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.deleteServiceCallable =
        callableFactory.createUnaryCallable(
            deleteServiceTransportSettings, settings.deleteServiceSettings(), clientContext);
    this.deleteServiceOperationCallable =
        callableFactory.createOperationCallable(
            deleteServiceTransportSettings,
            settings.deleteServiceOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.listMetadataImportsCallable =
        callableFactory.createUnaryCallable(
            listMetadataImportsTransportSettings,
            settings.listMetadataImportsSettings(),
            clientContext);
    this.listMetadataImportsPagedCallable =
        callableFactory.createPagedCallable(
            listMetadataImportsTransportSettings,
            settings.listMetadataImportsSettings(),
            clientContext);
    this.getMetadataImportCallable =
        callableFactory.createUnaryCallable(
            getMetadataImportTransportSettings,
            settings.getMetadataImportSettings(),
            clientContext);
    this.createMetadataImportCallable =
        callableFactory.createUnaryCallable(
            createMetadataImportTransportSettings,
            settings.createMetadataImportSettings(),
            clientContext);
    this.createMetadataImportOperationCallable =
        callableFactory.createOperationCallable(
            createMetadataImportTransportSettings,
            settings.createMetadataImportOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.updateMetadataImportCallable =
        callableFactory.createUnaryCallable(
            updateMetadataImportTransportSettings,
            settings.updateMetadataImportSettings(),
            clientContext);
    this.updateMetadataImportOperationCallable =
        callableFactory.createOperationCallable(
            updateMetadataImportTransportSettings,
            settings.updateMetadataImportOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.exportMetadataCallable =
        callableFactory.createUnaryCallable(
            exportMetadataTransportSettings, settings.exportMetadataSettings(), clientContext);
    this.exportMetadataOperationCallable =
        callableFactory.createOperationCallable(
            exportMetadataTransportSettings,
            settings.exportMetadataOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.restoreServiceCallable =
        callableFactory.createUnaryCallable(
            restoreServiceTransportSettings, settings.restoreServiceSettings(), clientContext);
    this.restoreServiceOperationCallable =
        callableFactory.createOperationCallable(
            restoreServiceTransportSettings,
            settings.restoreServiceOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.listBackupsCallable =
        callableFactory.createUnaryCallable(
            listBackupsTransportSettings, settings.listBackupsSettings(), clientContext);
    this.listBackupsPagedCallable =
        callableFactory.createPagedCallable(
            listBackupsTransportSettings, settings.listBackupsSettings(), clientContext);
    this.getBackupCallable =
        callableFactory.createUnaryCallable(
            getBackupTransportSettings, settings.getBackupSettings(), clientContext);
    this.createBackupCallable =
        callableFactory.createUnaryCallable(
            createBackupTransportSettings, settings.createBackupSettings(), clientContext);
    this.createBackupOperationCallable =
        callableFactory.createOperationCallable(
            createBackupTransportSettings,
            settings.createBackupOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.deleteBackupCallable =
        callableFactory.createUnaryCallable(
            deleteBackupTransportSettings, settings.deleteBackupSettings(), clientContext);
    this.deleteBackupOperationCallable =
        callableFactory.createOperationCallable(
            deleteBackupTransportSettings,
            settings.deleteBackupOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.removeIamPolicyCallable =
        callableFactory.createUnaryCallable(
            removeIamPolicyTransportSettings, settings.removeIamPolicySettings(), clientContext);
    this.queryMetadataCallable =
        callableFactory.createUnaryCallable(
            queryMetadataTransportSettings, settings.queryMetadataSettings(), clientContext);
    this.queryMetadataOperationCallable =
        callableFactory.createOperationCallable(
            queryMetadataTransportSettings,
            settings.queryMetadataOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.moveTableToDatabaseCallable =
        callableFactory.createUnaryCallable(
            moveTableToDatabaseTransportSettings,
            settings.moveTableToDatabaseSettings(),
            clientContext);
    this.moveTableToDatabaseOperationCallable =
        callableFactory.createOperationCallable(
            moveTableToDatabaseTransportSettings,
            settings.moveTableToDatabaseOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.alterMetadataResourceLocationCallable =
        callableFactory.createUnaryCallable(
            alterMetadataResourceLocationTransportSettings,
            settings.alterMetadataResourceLocationSettings(),
            clientContext);
    this.alterMetadataResourceLocationOperationCallable =
        callableFactory.createOperationCallable(
            alterMetadataResourceLocationTransportSettings,
            settings.alterMetadataResourceLocationOperationSettings(),
            clientContext,
            httpJsonOperationsStub);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(listServicesMethodDescriptor);
    methodDescriptors.add(getServiceMethodDescriptor);
    methodDescriptors.add(createServiceMethodDescriptor);
    methodDescriptors.add(updateServiceMethodDescriptor);
    methodDescriptors.add(deleteServiceMethodDescriptor);
    methodDescriptors.add(listMetadataImportsMethodDescriptor);
    methodDescriptors.add(getMetadataImportMethodDescriptor);
    methodDescriptors.add(createMetadataImportMethodDescriptor);
    methodDescriptors.add(updateMetadataImportMethodDescriptor);
    methodDescriptors.add(exportMetadataMethodDescriptor);
    methodDescriptors.add(restoreServiceMethodDescriptor);
    methodDescriptors.add(listBackupsMethodDescriptor);
    methodDescriptors.add(getBackupMethodDescriptor);
    methodDescriptors.add(createBackupMethodDescriptor);
    methodDescriptors.add(deleteBackupMethodDescriptor);
    methodDescriptors.add(removeIamPolicyMethodDescriptor);
    methodDescriptors.add(queryMetadataMethodDescriptor);
    methodDescriptors.add(moveTableToDatabaseMethodDescriptor);
    methodDescriptors.add(alterMetadataResourceLocationMethodDescriptor);
    return methodDescriptors;
  }

  public HttpJsonOperationsStub getHttpJsonOperationsStub() {
    return httpJsonOperationsStub;
  }

  @Override
  public UnaryCallable<ListServicesRequest, ListServicesResponse> listServicesCallable() {
    return listServicesCallable;
  }

  @Override
  public UnaryCallable<ListServicesRequest, ListServicesPagedResponse> listServicesPagedCallable() {
    return listServicesPagedCallable;
  }

  @Override
  public UnaryCallable<GetServiceRequest, Service> getServiceCallable() {
    return getServiceCallable;
  }

  @Override
  public UnaryCallable<CreateServiceRequest, Operation> createServiceCallable() {
    return createServiceCallable;
  }

  @Override
  public OperationCallable<CreateServiceRequest, Service, OperationMetadata>
      createServiceOperationCallable() {
    return createServiceOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateServiceRequest, Operation> updateServiceCallable() {
    return updateServiceCallable;
  }

  @Override
  public OperationCallable<UpdateServiceRequest, Service, OperationMetadata>
      updateServiceOperationCallable() {
    return updateServiceOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteServiceRequest, Operation> deleteServiceCallable() {
    return deleteServiceCallable;
  }

  @Override
  public OperationCallable<DeleteServiceRequest, Empty, OperationMetadata>
      deleteServiceOperationCallable() {
    return deleteServiceOperationCallable;
  }

  @Override
  public UnaryCallable<ListMetadataImportsRequest, ListMetadataImportsResponse>
      listMetadataImportsCallable() {
    return listMetadataImportsCallable;
  }

  @Override
  public UnaryCallable<ListMetadataImportsRequest, ListMetadataImportsPagedResponse>
      listMetadataImportsPagedCallable() {
    return listMetadataImportsPagedCallable;
  }

  @Override
  public UnaryCallable<GetMetadataImportRequest, MetadataImport> getMetadataImportCallable() {
    return getMetadataImportCallable;
  }

  @Override
  public UnaryCallable<CreateMetadataImportRequest, Operation> createMetadataImportCallable() {
    return createMetadataImportCallable;
  }

  @Override
  public OperationCallable<CreateMetadataImportRequest, MetadataImport, OperationMetadata>
      createMetadataImportOperationCallable() {
    return createMetadataImportOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateMetadataImportRequest, Operation> updateMetadataImportCallable() {
    return updateMetadataImportCallable;
  }

  @Override
  public OperationCallable<UpdateMetadataImportRequest, MetadataImport, OperationMetadata>
      updateMetadataImportOperationCallable() {
    return updateMetadataImportOperationCallable;
  }

  @Override
  public UnaryCallable<ExportMetadataRequest, Operation> exportMetadataCallable() {
    return exportMetadataCallable;
  }

  @Override
  public OperationCallable<ExportMetadataRequest, MetadataExport, OperationMetadata>
      exportMetadataOperationCallable() {
    return exportMetadataOperationCallable;
  }

  @Override
  public UnaryCallable<RestoreServiceRequest, Operation> restoreServiceCallable() {
    return restoreServiceCallable;
  }

  @Override
  public OperationCallable<RestoreServiceRequest, Restore, OperationMetadata>
      restoreServiceOperationCallable() {
    return restoreServiceOperationCallable;
  }

  @Override
  public UnaryCallable<ListBackupsRequest, ListBackupsResponse> listBackupsCallable() {
    return listBackupsCallable;
  }

  @Override
  public UnaryCallable<ListBackupsRequest, ListBackupsPagedResponse> listBackupsPagedCallable() {
    return listBackupsPagedCallable;
  }

  @Override
  public UnaryCallable<GetBackupRequest, Backup> getBackupCallable() {
    return getBackupCallable;
  }

  @Override
  public UnaryCallable<CreateBackupRequest, Operation> createBackupCallable() {
    return createBackupCallable;
  }

  @Override
  public OperationCallable<CreateBackupRequest, Backup, OperationMetadata>
      createBackupOperationCallable() {
    return createBackupOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteBackupRequest, Operation> deleteBackupCallable() {
    return deleteBackupCallable;
  }

  @Override
  public OperationCallable<DeleteBackupRequest, Empty, OperationMetadata>
      deleteBackupOperationCallable() {
    return deleteBackupOperationCallable;
  }

  @Override
  public UnaryCallable<RemoveIamPolicyRequest, RemoveIamPolicyResponse> removeIamPolicyCallable() {
    return removeIamPolicyCallable;
  }

  @Override
  public UnaryCallable<QueryMetadataRequest, Operation> queryMetadataCallable() {
    return queryMetadataCallable;
  }

  @Override
  public OperationCallable<QueryMetadataRequest, QueryMetadataResponse, OperationMetadata>
      queryMetadataOperationCallable() {
    return queryMetadataOperationCallable;
  }

  @Override
  public UnaryCallable<MoveTableToDatabaseRequest, Operation> moveTableToDatabaseCallable() {
    return moveTableToDatabaseCallable;
  }

  @Override
  public OperationCallable<
          MoveTableToDatabaseRequest, MoveTableToDatabaseResponse, OperationMetadata>
      moveTableToDatabaseOperationCallable() {
    return moveTableToDatabaseOperationCallable;
  }

  @Override
  public UnaryCallable<AlterMetadataResourceLocationRequest, Operation>
      alterMetadataResourceLocationCallable() {
    return alterMetadataResourceLocationCallable;
  }

  @Override
  public OperationCallable<
          AlterMetadataResourceLocationRequest,
          AlterMetadataResourceLocationResponse,
          OperationMetadata>
      alterMetadataResourceLocationOperationCallable() {
    return alterMetadataResourceLocationOperationCallable;
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
