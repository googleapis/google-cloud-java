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

package com.google.cloud.gkebackup.v1.stub;

import static com.google.cloud.gkebackup.v1.BackupForGKEClient.ListBackupPlansPagedResponse;
import static com.google.cloud.gkebackup.v1.BackupForGKEClient.ListBackupsPagedResponse;
import static com.google.cloud.gkebackup.v1.BackupForGKEClient.ListRestorePlansPagedResponse;
import static com.google.cloud.gkebackup.v1.BackupForGKEClient.ListRestoresPagedResponse;
import static com.google.cloud.gkebackup.v1.BackupForGKEClient.ListVolumeBackupsPagedResponse;
import static com.google.cloud.gkebackup.v1.BackupForGKEClient.ListVolumeRestoresPagedResponse;

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
import com.google.cloud.gkebackup.v1.Backup;
import com.google.cloud.gkebackup.v1.BackupPlan;
import com.google.cloud.gkebackup.v1.CreateBackupPlanRequest;
import com.google.cloud.gkebackup.v1.CreateBackupRequest;
import com.google.cloud.gkebackup.v1.CreateRestorePlanRequest;
import com.google.cloud.gkebackup.v1.CreateRestoreRequest;
import com.google.cloud.gkebackup.v1.DeleteBackupPlanRequest;
import com.google.cloud.gkebackup.v1.DeleteBackupRequest;
import com.google.cloud.gkebackup.v1.DeleteRestorePlanRequest;
import com.google.cloud.gkebackup.v1.DeleteRestoreRequest;
import com.google.cloud.gkebackup.v1.GetBackupPlanRequest;
import com.google.cloud.gkebackup.v1.GetBackupRequest;
import com.google.cloud.gkebackup.v1.GetRestorePlanRequest;
import com.google.cloud.gkebackup.v1.GetRestoreRequest;
import com.google.cloud.gkebackup.v1.GetVolumeBackupRequest;
import com.google.cloud.gkebackup.v1.GetVolumeRestoreRequest;
import com.google.cloud.gkebackup.v1.ListBackupPlansRequest;
import com.google.cloud.gkebackup.v1.ListBackupPlansResponse;
import com.google.cloud.gkebackup.v1.ListBackupsRequest;
import com.google.cloud.gkebackup.v1.ListBackupsResponse;
import com.google.cloud.gkebackup.v1.ListRestorePlansRequest;
import com.google.cloud.gkebackup.v1.ListRestorePlansResponse;
import com.google.cloud.gkebackup.v1.ListRestoresRequest;
import com.google.cloud.gkebackup.v1.ListRestoresResponse;
import com.google.cloud.gkebackup.v1.ListVolumeBackupsRequest;
import com.google.cloud.gkebackup.v1.ListVolumeBackupsResponse;
import com.google.cloud.gkebackup.v1.ListVolumeRestoresRequest;
import com.google.cloud.gkebackup.v1.ListVolumeRestoresResponse;
import com.google.cloud.gkebackup.v1.OperationMetadata;
import com.google.cloud.gkebackup.v1.Restore;
import com.google.cloud.gkebackup.v1.RestorePlan;
import com.google.cloud.gkebackup.v1.UpdateBackupPlanRequest;
import com.google.cloud.gkebackup.v1.UpdateBackupRequest;
import com.google.cloud.gkebackup.v1.UpdateRestorePlanRequest;
import com.google.cloud.gkebackup.v1.UpdateRestoreRequest;
import com.google.cloud.gkebackup.v1.VolumeBackup;
import com.google.cloud.gkebackup.v1.VolumeRestore;
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
 * REST stub implementation for the BackupForGKE service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
@BetaApi
public class HttpJsonBackupForGKEStub extends BackupForGKEStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder()
          .add(BackupPlan.getDescriptor())
          .add(Empty.getDescriptor())
          .add(Restore.getDescriptor())
          .add(RestorePlan.getDescriptor())
          .add(Backup.getDescriptor())
          .add(OperationMetadata.getDescriptor())
          .build();

  private static final ApiMethodDescriptor<CreateBackupPlanRequest, Operation>
      createBackupPlanMethodDescriptor =
          ApiMethodDescriptor.<CreateBackupPlanRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.gkebackup.v1.BackupForGKE/CreateBackupPlan")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateBackupPlanRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/backupPlans",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateBackupPlanRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateBackupPlanRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "backupPlanId", request.getBackupPlanId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("backupPlan", request.getBackupPlan(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateBackupPlanRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<ListBackupPlansRequest, ListBackupPlansResponse>
      listBackupPlansMethodDescriptor =
          ApiMethodDescriptor.<ListBackupPlansRequest, ListBackupPlansResponse>newBuilder()
              .setFullMethodName("google.cloud.gkebackup.v1.BackupForGKE/ListBackupPlans")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListBackupPlansRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/backupPlans",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListBackupPlansRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListBackupPlansRequest> serializer =
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
                  ProtoMessageResponseParser.<ListBackupPlansResponse>newBuilder()
                      .setDefaultInstance(ListBackupPlansResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetBackupPlanRequest, BackupPlan>
      getBackupPlanMethodDescriptor =
          ApiMethodDescriptor.<GetBackupPlanRequest, BackupPlan>newBuilder()
              .setFullMethodName("google.cloud.gkebackup.v1.BackupForGKE/GetBackupPlan")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetBackupPlanRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/backupPlans/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetBackupPlanRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetBackupPlanRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<BackupPlan>newBuilder()
                      .setDefaultInstance(BackupPlan.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateBackupPlanRequest, Operation>
      updateBackupPlanMethodDescriptor =
          ApiMethodDescriptor.<UpdateBackupPlanRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.gkebackup.v1.BackupForGKE/UpdateBackupPlan")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateBackupPlanRequest>newBuilder()
                      .setPath(
                          "/v1/{backupPlan.name=projects/*/locations/*/backupPlans/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateBackupPlanRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "backupPlan.name", request.getBackupPlan().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateBackupPlanRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("backupPlan", request.getBackupPlan(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateBackupPlanRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeleteBackupPlanRequest, Operation>
      deleteBackupPlanMethodDescriptor =
          ApiMethodDescriptor.<DeleteBackupPlanRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.gkebackup.v1.BackupForGKE/DeleteBackupPlan")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteBackupPlanRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/backupPlans/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteBackupPlanRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteBackupPlanRequest> serializer =
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
                  (DeleteBackupPlanRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<CreateBackupRequest, Operation>
      createBackupMethodDescriptor =
          ApiMethodDescriptor.<CreateBackupRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.gkebackup.v1.BackupForGKE/CreateBackup")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateBackupRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/backupPlans/*}/backups",
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

  private static final ApiMethodDescriptor<ListBackupsRequest, ListBackupsResponse>
      listBackupsMethodDescriptor =
          ApiMethodDescriptor.<ListBackupsRequest, ListBackupsResponse>newBuilder()
              .setFullMethodName("google.cloud.gkebackup.v1.BackupForGKE/ListBackups")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListBackupsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/backupPlans/*}/backups",
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
          .setFullMethodName("google.cloud.gkebackup.v1.BackupForGKE/GetBackup")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetBackupRequest>newBuilder()
                  .setPath(
                      "/v1/{name=projects/*/locations/*/backupPlans/*/backups/*}",
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

  private static final ApiMethodDescriptor<UpdateBackupRequest, Operation>
      updateBackupMethodDescriptor =
          ApiMethodDescriptor.<UpdateBackupRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.gkebackup.v1.BackupForGKE/UpdateBackup")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateBackupRequest>newBuilder()
                      .setPath(
                          "/v1/{backup.name=projects/*/locations/*/backupPlans/*/backups/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateBackupRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "backup.name", request.getBackup().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateBackupRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
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
                  (UpdateBackupRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeleteBackupRequest, Operation>
      deleteBackupMethodDescriptor =
          ApiMethodDescriptor.<DeleteBackupRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.gkebackup.v1.BackupForGKE/DeleteBackup")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteBackupRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/backupPlans/*/backups/*}",
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
                            serializer.putQueryParam(fields, "etag", request.getEtag());
                            serializer.putQueryParam(fields, "force", request.getForce());
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

  private static final ApiMethodDescriptor<ListVolumeBackupsRequest, ListVolumeBackupsResponse>
      listVolumeBackupsMethodDescriptor =
          ApiMethodDescriptor.<ListVolumeBackupsRequest, ListVolumeBackupsResponse>newBuilder()
              .setFullMethodName("google.cloud.gkebackup.v1.BackupForGKE/ListVolumeBackups")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListVolumeBackupsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/backupPlans/*/backups/*}/volumeBackups",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListVolumeBackupsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListVolumeBackupsRequest> serializer =
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
                  ProtoMessageResponseParser.<ListVolumeBackupsResponse>newBuilder()
                      .setDefaultInstance(ListVolumeBackupsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetVolumeBackupRequest, VolumeBackup>
      getVolumeBackupMethodDescriptor =
          ApiMethodDescriptor.<GetVolumeBackupRequest, VolumeBackup>newBuilder()
              .setFullMethodName("google.cloud.gkebackup.v1.BackupForGKE/GetVolumeBackup")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetVolumeBackupRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/backupPlans/*/backups/*/volumeBackups/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetVolumeBackupRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetVolumeBackupRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<VolumeBackup>newBuilder()
                      .setDefaultInstance(VolumeBackup.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateRestorePlanRequest, Operation>
      createRestorePlanMethodDescriptor =
          ApiMethodDescriptor.<CreateRestorePlanRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.gkebackup.v1.BackupForGKE/CreateRestorePlan")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateRestorePlanRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/restorePlans",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateRestorePlanRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateRestorePlanRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "restorePlanId", request.getRestorePlanId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("restorePlan", request.getRestorePlan(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateRestorePlanRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<ListRestorePlansRequest, ListRestorePlansResponse>
      listRestorePlansMethodDescriptor =
          ApiMethodDescriptor.<ListRestorePlansRequest, ListRestorePlansResponse>newBuilder()
              .setFullMethodName("google.cloud.gkebackup.v1.BackupForGKE/ListRestorePlans")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListRestorePlansRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/restorePlans",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListRestorePlansRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListRestorePlansRequest> serializer =
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
                  ProtoMessageResponseParser.<ListRestorePlansResponse>newBuilder()
                      .setDefaultInstance(ListRestorePlansResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetRestorePlanRequest, RestorePlan>
      getRestorePlanMethodDescriptor =
          ApiMethodDescriptor.<GetRestorePlanRequest, RestorePlan>newBuilder()
              .setFullMethodName("google.cloud.gkebackup.v1.BackupForGKE/GetRestorePlan")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetRestorePlanRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/restorePlans/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetRestorePlanRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetRestorePlanRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<RestorePlan>newBuilder()
                      .setDefaultInstance(RestorePlan.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateRestorePlanRequest, Operation>
      updateRestorePlanMethodDescriptor =
          ApiMethodDescriptor.<UpdateRestorePlanRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.gkebackup.v1.BackupForGKE/UpdateRestorePlan")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateRestorePlanRequest>newBuilder()
                      .setPath(
                          "/v1/{restorePlan.name=projects/*/locations/*/restorePlans/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateRestorePlanRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "restorePlan.name", request.getRestorePlan().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateRestorePlanRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("restorePlan", request.getRestorePlan(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateRestorePlanRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeleteRestorePlanRequest, Operation>
      deleteRestorePlanMethodDescriptor =
          ApiMethodDescriptor.<DeleteRestorePlanRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.gkebackup.v1.BackupForGKE/DeleteRestorePlan")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteRestorePlanRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/restorePlans/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteRestorePlanRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteRestorePlanRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "etag", request.getEtag());
                            serializer.putQueryParam(fields, "force", request.getForce());
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
                  (DeleteRestorePlanRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<CreateRestoreRequest, Operation>
      createRestoreMethodDescriptor =
          ApiMethodDescriptor.<CreateRestoreRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.gkebackup.v1.BackupForGKE/CreateRestore")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateRestoreRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/restorePlans/*}/restores",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateRestoreRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateRestoreRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "restoreId", request.getRestoreId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("restore", request.getRestore(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateRestoreRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<ListRestoresRequest, ListRestoresResponse>
      listRestoresMethodDescriptor =
          ApiMethodDescriptor.<ListRestoresRequest, ListRestoresResponse>newBuilder()
              .setFullMethodName("google.cloud.gkebackup.v1.BackupForGKE/ListRestores")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListRestoresRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/restorePlans/*}/restores",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListRestoresRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListRestoresRequest> serializer =
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
                  ProtoMessageResponseParser.<ListRestoresResponse>newBuilder()
                      .setDefaultInstance(ListRestoresResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetRestoreRequest, Restore> getRestoreMethodDescriptor =
      ApiMethodDescriptor.<GetRestoreRequest, Restore>newBuilder()
          .setFullMethodName("google.cloud.gkebackup.v1.BackupForGKE/GetRestore")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetRestoreRequest>newBuilder()
                  .setPath(
                      "/v1/{name=projects/*/locations/*/restorePlans/*/restores/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetRestoreRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetRestoreRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Restore>newBuilder()
                  .setDefaultInstance(Restore.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<UpdateRestoreRequest, Operation>
      updateRestoreMethodDescriptor =
          ApiMethodDescriptor.<UpdateRestoreRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.gkebackup.v1.BackupForGKE/UpdateRestore")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateRestoreRequest>newBuilder()
                      .setPath(
                          "/v1/{restore.name=projects/*/locations/*/restorePlans/*/restores/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateRestoreRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "restore.name", request.getRestore().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateRestoreRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("restore", request.getRestore(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateRestoreRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeleteRestoreRequest, Operation>
      deleteRestoreMethodDescriptor =
          ApiMethodDescriptor.<DeleteRestoreRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.gkebackup.v1.BackupForGKE/DeleteRestore")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteRestoreRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/restorePlans/*/restores/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteRestoreRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteRestoreRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "etag", request.getEtag());
                            serializer.putQueryParam(fields, "force", request.getForce());
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
                  (DeleteRestoreRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<ListVolumeRestoresRequest, ListVolumeRestoresResponse>
      listVolumeRestoresMethodDescriptor =
          ApiMethodDescriptor.<ListVolumeRestoresRequest, ListVolumeRestoresResponse>newBuilder()
              .setFullMethodName("google.cloud.gkebackup.v1.BackupForGKE/ListVolumeRestores")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListVolumeRestoresRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/restorePlans/*/restores/*}/volumeRestores",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListVolumeRestoresRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListVolumeRestoresRequest> serializer =
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
                  ProtoMessageResponseParser.<ListVolumeRestoresResponse>newBuilder()
                      .setDefaultInstance(ListVolumeRestoresResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetVolumeRestoreRequest, VolumeRestore>
      getVolumeRestoreMethodDescriptor =
          ApiMethodDescriptor.<GetVolumeRestoreRequest, VolumeRestore>newBuilder()
              .setFullMethodName("google.cloud.gkebackup.v1.BackupForGKE/GetVolumeRestore")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetVolumeRestoreRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/restorePlans/*/restores/*/volumeRestores/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetVolumeRestoreRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetVolumeRestoreRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<VolumeRestore>newBuilder()
                      .setDefaultInstance(VolumeRestore.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<CreateBackupPlanRequest, Operation> createBackupPlanCallable;
  private final OperationCallable<CreateBackupPlanRequest, BackupPlan, OperationMetadata>
      createBackupPlanOperationCallable;
  private final UnaryCallable<ListBackupPlansRequest, ListBackupPlansResponse>
      listBackupPlansCallable;
  private final UnaryCallable<ListBackupPlansRequest, ListBackupPlansPagedResponse>
      listBackupPlansPagedCallable;
  private final UnaryCallable<GetBackupPlanRequest, BackupPlan> getBackupPlanCallable;
  private final UnaryCallable<UpdateBackupPlanRequest, Operation> updateBackupPlanCallable;
  private final OperationCallable<UpdateBackupPlanRequest, BackupPlan, OperationMetadata>
      updateBackupPlanOperationCallable;
  private final UnaryCallable<DeleteBackupPlanRequest, Operation> deleteBackupPlanCallable;
  private final OperationCallable<DeleteBackupPlanRequest, Empty, OperationMetadata>
      deleteBackupPlanOperationCallable;
  private final UnaryCallable<CreateBackupRequest, Operation> createBackupCallable;
  private final OperationCallable<CreateBackupRequest, Backup, OperationMetadata>
      createBackupOperationCallable;
  private final UnaryCallable<ListBackupsRequest, ListBackupsResponse> listBackupsCallable;
  private final UnaryCallable<ListBackupsRequest, ListBackupsPagedResponse>
      listBackupsPagedCallable;
  private final UnaryCallable<GetBackupRequest, Backup> getBackupCallable;
  private final UnaryCallable<UpdateBackupRequest, Operation> updateBackupCallable;
  private final OperationCallable<UpdateBackupRequest, Backup, OperationMetadata>
      updateBackupOperationCallable;
  private final UnaryCallable<DeleteBackupRequest, Operation> deleteBackupCallable;
  private final OperationCallable<DeleteBackupRequest, Empty, OperationMetadata>
      deleteBackupOperationCallable;
  private final UnaryCallable<ListVolumeBackupsRequest, ListVolumeBackupsResponse>
      listVolumeBackupsCallable;
  private final UnaryCallable<ListVolumeBackupsRequest, ListVolumeBackupsPagedResponse>
      listVolumeBackupsPagedCallable;
  private final UnaryCallable<GetVolumeBackupRequest, VolumeBackup> getVolumeBackupCallable;
  private final UnaryCallable<CreateRestorePlanRequest, Operation> createRestorePlanCallable;
  private final OperationCallable<CreateRestorePlanRequest, RestorePlan, OperationMetadata>
      createRestorePlanOperationCallable;
  private final UnaryCallable<ListRestorePlansRequest, ListRestorePlansResponse>
      listRestorePlansCallable;
  private final UnaryCallable<ListRestorePlansRequest, ListRestorePlansPagedResponse>
      listRestorePlansPagedCallable;
  private final UnaryCallable<GetRestorePlanRequest, RestorePlan> getRestorePlanCallable;
  private final UnaryCallable<UpdateRestorePlanRequest, Operation> updateRestorePlanCallable;
  private final OperationCallable<UpdateRestorePlanRequest, RestorePlan, OperationMetadata>
      updateRestorePlanOperationCallable;
  private final UnaryCallable<DeleteRestorePlanRequest, Operation> deleteRestorePlanCallable;
  private final OperationCallable<DeleteRestorePlanRequest, Empty, OperationMetadata>
      deleteRestorePlanOperationCallable;
  private final UnaryCallable<CreateRestoreRequest, Operation> createRestoreCallable;
  private final OperationCallable<CreateRestoreRequest, Restore, OperationMetadata>
      createRestoreOperationCallable;
  private final UnaryCallable<ListRestoresRequest, ListRestoresResponse> listRestoresCallable;
  private final UnaryCallable<ListRestoresRequest, ListRestoresPagedResponse>
      listRestoresPagedCallable;
  private final UnaryCallable<GetRestoreRequest, Restore> getRestoreCallable;
  private final UnaryCallable<UpdateRestoreRequest, Operation> updateRestoreCallable;
  private final OperationCallable<UpdateRestoreRequest, Restore, OperationMetadata>
      updateRestoreOperationCallable;
  private final UnaryCallable<DeleteRestoreRequest, Operation> deleteRestoreCallable;
  private final OperationCallable<DeleteRestoreRequest, Empty, OperationMetadata>
      deleteRestoreOperationCallable;
  private final UnaryCallable<ListVolumeRestoresRequest, ListVolumeRestoresResponse>
      listVolumeRestoresCallable;
  private final UnaryCallable<ListVolumeRestoresRequest, ListVolumeRestoresPagedResponse>
      listVolumeRestoresPagedCallable;
  private final UnaryCallable<GetVolumeRestoreRequest, VolumeRestore> getVolumeRestoreCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonBackupForGKEStub create(BackupForGKEStubSettings settings)
      throws IOException {
    return new HttpJsonBackupForGKEStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonBackupForGKEStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonBackupForGKEStub(
        BackupForGKEStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonBackupForGKEStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonBackupForGKEStub(
        BackupForGKEStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonBackupForGKEStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonBackupForGKEStub(BackupForGKEStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonBackupForGKECallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonBackupForGKEStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonBackupForGKEStub(
      BackupForGKEStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.httpJsonOperationsStub =
        HttpJsonOperationsStub.create(clientContext, callableFactory, typeRegistry);

    HttpJsonCallSettings<CreateBackupPlanRequest, Operation> createBackupPlanTransportSettings =
        HttpJsonCallSettings.<CreateBackupPlanRequest, Operation>newBuilder()
            .setMethodDescriptor(createBackupPlanMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ListBackupPlansRequest, ListBackupPlansResponse>
        listBackupPlansTransportSettings =
            HttpJsonCallSettings.<ListBackupPlansRequest, ListBackupPlansResponse>newBuilder()
                .setMethodDescriptor(listBackupPlansMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GetBackupPlanRequest, BackupPlan> getBackupPlanTransportSettings =
        HttpJsonCallSettings.<GetBackupPlanRequest, BackupPlan>newBuilder()
            .setMethodDescriptor(getBackupPlanMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<UpdateBackupPlanRequest, Operation> updateBackupPlanTransportSettings =
        HttpJsonCallSettings.<UpdateBackupPlanRequest, Operation>newBuilder()
            .setMethodDescriptor(updateBackupPlanMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<DeleteBackupPlanRequest, Operation> deleteBackupPlanTransportSettings =
        HttpJsonCallSettings.<DeleteBackupPlanRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteBackupPlanMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<CreateBackupRequest, Operation> createBackupTransportSettings =
        HttpJsonCallSettings.<CreateBackupRequest, Operation>newBuilder()
            .setMethodDescriptor(createBackupMethodDescriptor)
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
    HttpJsonCallSettings<UpdateBackupRequest, Operation> updateBackupTransportSettings =
        HttpJsonCallSettings.<UpdateBackupRequest, Operation>newBuilder()
            .setMethodDescriptor(updateBackupMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<DeleteBackupRequest, Operation> deleteBackupTransportSettings =
        HttpJsonCallSettings.<DeleteBackupRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteBackupMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ListVolumeBackupsRequest, ListVolumeBackupsResponse>
        listVolumeBackupsTransportSettings =
            HttpJsonCallSettings.<ListVolumeBackupsRequest, ListVolumeBackupsResponse>newBuilder()
                .setMethodDescriptor(listVolumeBackupsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GetVolumeBackupRequest, VolumeBackup> getVolumeBackupTransportSettings =
        HttpJsonCallSettings.<GetVolumeBackupRequest, VolumeBackup>newBuilder()
            .setMethodDescriptor(getVolumeBackupMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<CreateRestorePlanRequest, Operation> createRestorePlanTransportSettings =
        HttpJsonCallSettings.<CreateRestorePlanRequest, Operation>newBuilder()
            .setMethodDescriptor(createRestorePlanMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ListRestorePlansRequest, ListRestorePlansResponse>
        listRestorePlansTransportSettings =
            HttpJsonCallSettings.<ListRestorePlansRequest, ListRestorePlansResponse>newBuilder()
                .setMethodDescriptor(listRestorePlansMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GetRestorePlanRequest, RestorePlan> getRestorePlanTransportSettings =
        HttpJsonCallSettings.<GetRestorePlanRequest, RestorePlan>newBuilder()
            .setMethodDescriptor(getRestorePlanMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<UpdateRestorePlanRequest, Operation> updateRestorePlanTransportSettings =
        HttpJsonCallSettings.<UpdateRestorePlanRequest, Operation>newBuilder()
            .setMethodDescriptor(updateRestorePlanMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<DeleteRestorePlanRequest, Operation> deleteRestorePlanTransportSettings =
        HttpJsonCallSettings.<DeleteRestorePlanRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteRestorePlanMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<CreateRestoreRequest, Operation> createRestoreTransportSettings =
        HttpJsonCallSettings.<CreateRestoreRequest, Operation>newBuilder()
            .setMethodDescriptor(createRestoreMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ListRestoresRequest, ListRestoresResponse> listRestoresTransportSettings =
        HttpJsonCallSettings.<ListRestoresRequest, ListRestoresResponse>newBuilder()
            .setMethodDescriptor(listRestoresMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<GetRestoreRequest, Restore> getRestoreTransportSettings =
        HttpJsonCallSettings.<GetRestoreRequest, Restore>newBuilder()
            .setMethodDescriptor(getRestoreMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<UpdateRestoreRequest, Operation> updateRestoreTransportSettings =
        HttpJsonCallSettings.<UpdateRestoreRequest, Operation>newBuilder()
            .setMethodDescriptor(updateRestoreMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<DeleteRestoreRequest, Operation> deleteRestoreTransportSettings =
        HttpJsonCallSettings.<DeleteRestoreRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteRestoreMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ListVolumeRestoresRequest, ListVolumeRestoresResponse>
        listVolumeRestoresTransportSettings =
            HttpJsonCallSettings.<ListVolumeRestoresRequest, ListVolumeRestoresResponse>newBuilder()
                .setMethodDescriptor(listVolumeRestoresMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GetVolumeRestoreRequest, VolumeRestore> getVolumeRestoreTransportSettings =
        HttpJsonCallSettings.<GetVolumeRestoreRequest, VolumeRestore>newBuilder()
            .setMethodDescriptor(getVolumeRestoreMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();

    this.createBackupPlanCallable =
        callableFactory.createUnaryCallable(
            createBackupPlanTransportSettings, settings.createBackupPlanSettings(), clientContext);
    this.createBackupPlanOperationCallable =
        callableFactory.createOperationCallable(
            createBackupPlanTransportSettings,
            settings.createBackupPlanOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.listBackupPlansCallable =
        callableFactory.createUnaryCallable(
            listBackupPlansTransportSettings, settings.listBackupPlansSettings(), clientContext);
    this.listBackupPlansPagedCallable =
        callableFactory.createPagedCallable(
            listBackupPlansTransportSettings, settings.listBackupPlansSettings(), clientContext);
    this.getBackupPlanCallable =
        callableFactory.createUnaryCallable(
            getBackupPlanTransportSettings, settings.getBackupPlanSettings(), clientContext);
    this.updateBackupPlanCallable =
        callableFactory.createUnaryCallable(
            updateBackupPlanTransportSettings, settings.updateBackupPlanSettings(), clientContext);
    this.updateBackupPlanOperationCallable =
        callableFactory.createOperationCallable(
            updateBackupPlanTransportSettings,
            settings.updateBackupPlanOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.deleteBackupPlanCallable =
        callableFactory.createUnaryCallable(
            deleteBackupPlanTransportSettings, settings.deleteBackupPlanSettings(), clientContext);
    this.deleteBackupPlanOperationCallable =
        callableFactory.createOperationCallable(
            deleteBackupPlanTransportSettings,
            settings.deleteBackupPlanOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.createBackupCallable =
        callableFactory.createUnaryCallable(
            createBackupTransportSettings, settings.createBackupSettings(), clientContext);
    this.createBackupOperationCallable =
        callableFactory.createOperationCallable(
            createBackupTransportSettings,
            settings.createBackupOperationSettings(),
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
    this.updateBackupCallable =
        callableFactory.createUnaryCallable(
            updateBackupTransportSettings, settings.updateBackupSettings(), clientContext);
    this.updateBackupOperationCallable =
        callableFactory.createOperationCallable(
            updateBackupTransportSettings,
            settings.updateBackupOperationSettings(),
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
    this.listVolumeBackupsCallable =
        callableFactory.createUnaryCallable(
            listVolumeBackupsTransportSettings,
            settings.listVolumeBackupsSettings(),
            clientContext);
    this.listVolumeBackupsPagedCallable =
        callableFactory.createPagedCallable(
            listVolumeBackupsTransportSettings,
            settings.listVolumeBackupsSettings(),
            clientContext);
    this.getVolumeBackupCallable =
        callableFactory.createUnaryCallable(
            getVolumeBackupTransportSettings, settings.getVolumeBackupSettings(), clientContext);
    this.createRestorePlanCallable =
        callableFactory.createUnaryCallable(
            createRestorePlanTransportSettings,
            settings.createRestorePlanSettings(),
            clientContext);
    this.createRestorePlanOperationCallable =
        callableFactory.createOperationCallable(
            createRestorePlanTransportSettings,
            settings.createRestorePlanOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.listRestorePlansCallable =
        callableFactory.createUnaryCallable(
            listRestorePlansTransportSettings, settings.listRestorePlansSettings(), clientContext);
    this.listRestorePlansPagedCallable =
        callableFactory.createPagedCallable(
            listRestorePlansTransportSettings, settings.listRestorePlansSettings(), clientContext);
    this.getRestorePlanCallable =
        callableFactory.createUnaryCallable(
            getRestorePlanTransportSettings, settings.getRestorePlanSettings(), clientContext);
    this.updateRestorePlanCallable =
        callableFactory.createUnaryCallable(
            updateRestorePlanTransportSettings,
            settings.updateRestorePlanSettings(),
            clientContext);
    this.updateRestorePlanOperationCallable =
        callableFactory.createOperationCallable(
            updateRestorePlanTransportSettings,
            settings.updateRestorePlanOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.deleteRestorePlanCallable =
        callableFactory.createUnaryCallable(
            deleteRestorePlanTransportSettings,
            settings.deleteRestorePlanSettings(),
            clientContext);
    this.deleteRestorePlanOperationCallable =
        callableFactory.createOperationCallable(
            deleteRestorePlanTransportSettings,
            settings.deleteRestorePlanOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.createRestoreCallable =
        callableFactory.createUnaryCallable(
            createRestoreTransportSettings, settings.createRestoreSettings(), clientContext);
    this.createRestoreOperationCallable =
        callableFactory.createOperationCallable(
            createRestoreTransportSettings,
            settings.createRestoreOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.listRestoresCallable =
        callableFactory.createUnaryCallable(
            listRestoresTransportSettings, settings.listRestoresSettings(), clientContext);
    this.listRestoresPagedCallable =
        callableFactory.createPagedCallable(
            listRestoresTransportSettings, settings.listRestoresSettings(), clientContext);
    this.getRestoreCallable =
        callableFactory.createUnaryCallable(
            getRestoreTransportSettings, settings.getRestoreSettings(), clientContext);
    this.updateRestoreCallable =
        callableFactory.createUnaryCallable(
            updateRestoreTransportSettings, settings.updateRestoreSettings(), clientContext);
    this.updateRestoreOperationCallable =
        callableFactory.createOperationCallable(
            updateRestoreTransportSettings,
            settings.updateRestoreOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.deleteRestoreCallable =
        callableFactory.createUnaryCallable(
            deleteRestoreTransportSettings, settings.deleteRestoreSettings(), clientContext);
    this.deleteRestoreOperationCallable =
        callableFactory.createOperationCallable(
            deleteRestoreTransportSettings,
            settings.deleteRestoreOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.listVolumeRestoresCallable =
        callableFactory.createUnaryCallable(
            listVolumeRestoresTransportSettings,
            settings.listVolumeRestoresSettings(),
            clientContext);
    this.listVolumeRestoresPagedCallable =
        callableFactory.createPagedCallable(
            listVolumeRestoresTransportSettings,
            settings.listVolumeRestoresSettings(),
            clientContext);
    this.getVolumeRestoreCallable =
        callableFactory.createUnaryCallable(
            getVolumeRestoreTransportSettings, settings.getVolumeRestoreSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(createBackupPlanMethodDescriptor);
    methodDescriptors.add(listBackupPlansMethodDescriptor);
    methodDescriptors.add(getBackupPlanMethodDescriptor);
    methodDescriptors.add(updateBackupPlanMethodDescriptor);
    methodDescriptors.add(deleteBackupPlanMethodDescriptor);
    methodDescriptors.add(createBackupMethodDescriptor);
    methodDescriptors.add(listBackupsMethodDescriptor);
    methodDescriptors.add(getBackupMethodDescriptor);
    methodDescriptors.add(updateBackupMethodDescriptor);
    methodDescriptors.add(deleteBackupMethodDescriptor);
    methodDescriptors.add(listVolumeBackupsMethodDescriptor);
    methodDescriptors.add(getVolumeBackupMethodDescriptor);
    methodDescriptors.add(createRestorePlanMethodDescriptor);
    methodDescriptors.add(listRestorePlansMethodDescriptor);
    methodDescriptors.add(getRestorePlanMethodDescriptor);
    methodDescriptors.add(updateRestorePlanMethodDescriptor);
    methodDescriptors.add(deleteRestorePlanMethodDescriptor);
    methodDescriptors.add(createRestoreMethodDescriptor);
    methodDescriptors.add(listRestoresMethodDescriptor);
    methodDescriptors.add(getRestoreMethodDescriptor);
    methodDescriptors.add(updateRestoreMethodDescriptor);
    methodDescriptors.add(deleteRestoreMethodDescriptor);
    methodDescriptors.add(listVolumeRestoresMethodDescriptor);
    methodDescriptors.add(getVolumeRestoreMethodDescriptor);
    return methodDescriptors;
  }

  public HttpJsonOperationsStub getHttpJsonOperationsStub() {
    return httpJsonOperationsStub;
  }

  @Override
  public UnaryCallable<CreateBackupPlanRequest, Operation> createBackupPlanCallable() {
    return createBackupPlanCallable;
  }

  @Override
  public OperationCallable<CreateBackupPlanRequest, BackupPlan, OperationMetadata>
      createBackupPlanOperationCallable() {
    return createBackupPlanOperationCallable;
  }

  @Override
  public UnaryCallable<ListBackupPlansRequest, ListBackupPlansResponse> listBackupPlansCallable() {
    return listBackupPlansCallable;
  }

  @Override
  public UnaryCallable<ListBackupPlansRequest, ListBackupPlansPagedResponse>
      listBackupPlansPagedCallable() {
    return listBackupPlansPagedCallable;
  }

  @Override
  public UnaryCallable<GetBackupPlanRequest, BackupPlan> getBackupPlanCallable() {
    return getBackupPlanCallable;
  }

  @Override
  public UnaryCallable<UpdateBackupPlanRequest, Operation> updateBackupPlanCallable() {
    return updateBackupPlanCallable;
  }

  @Override
  public OperationCallable<UpdateBackupPlanRequest, BackupPlan, OperationMetadata>
      updateBackupPlanOperationCallable() {
    return updateBackupPlanOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteBackupPlanRequest, Operation> deleteBackupPlanCallable() {
    return deleteBackupPlanCallable;
  }

  @Override
  public OperationCallable<DeleteBackupPlanRequest, Empty, OperationMetadata>
      deleteBackupPlanOperationCallable() {
    return deleteBackupPlanOperationCallable;
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
  public UnaryCallable<UpdateBackupRequest, Operation> updateBackupCallable() {
    return updateBackupCallable;
  }

  @Override
  public OperationCallable<UpdateBackupRequest, Backup, OperationMetadata>
      updateBackupOperationCallable() {
    return updateBackupOperationCallable;
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
  public UnaryCallable<ListVolumeBackupsRequest, ListVolumeBackupsResponse>
      listVolumeBackupsCallable() {
    return listVolumeBackupsCallable;
  }

  @Override
  public UnaryCallable<ListVolumeBackupsRequest, ListVolumeBackupsPagedResponse>
      listVolumeBackupsPagedCallable() {
    return listVolumeBackupsPagedCallable;
  }

  @Override
  public UnaryCallable<GetVolumeBackupRequest, VolumeBackup> getVolumeBackupCallable() {
    return getVolumeBackupCallable;
  }

  @Override
  public UnaryCallable<CreateRestorePlanRequest, Operation> createRestorePlanCallable() {
    return createRestorePlanCallable;
  }

  @Override
  public OperationCallable<CreateRestorePlanRequest, RestorePlan, OperationMetadata>
      createRestorePlanOperationCallable() {
    return createRestorePlanOperationCallable;
  }

  @Override
  public UnaryCallable<ListRestorePlansRequest, ListRestorePlansResponse>
      listRestorePlansCallable() {
    return listRestorePlansCallable;
  }

  @Override
  public UnaryCallable<ListRestorePlansRequest, ListRestorePlansPagedResponse>
      listRestorePlansPagedCallable() {
    return listRestorePlansPagedCallable;
  }

  @Override
  public UnaryCallable<GetRestorePlanRequest, RestorePlan> getRestorePlanCallable() {
    return getRestorePlanCallable;
  }

  @Override
  public UnaryCallable<UpdateRestorePlanRequest, Operation> updateRestorePlanCallable() {
    return updateRestorePlanCallable;
  }

  @Override
  public OperationCallable<UpdateRestorePlanRequest, RestorePlan, OperationMetadata>
      updateRestorePlanOperationCallable() {
    return updateRestorePlanOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteRestorePlanRequest, Operation> deleteRestorePlanCallable() {
    return deleteRestorePlanCallable;
  }

  @Override
  public OperationCallable<DeleteRestorePlanRequest, Empty, OperationMetadata>
      deleteRestorePlanOperationCallable() {
    return deleteRestorePlanOperationCallable;
  }

  @Override
  public UnaryCallable<CreateRestoreRequest, Operation> createRestoreCallable() {
    return createRestoreCallable;
  }

  @Override
  public OperationCallable<CreateRestoreRequest, Restore, OperationMetadata>
      createRestoreOperationCallable() {
    return createRestoreOperationCallable;
  }

  @Override
  public UnaryCallable<ListRestoresRequest, ListRestoresResponse> listRestoresCallable() {
    return listRestoresCallable;
  }

  @Override
  public UnaryCallable<ListRestoresRequest, ListRestoresPagedResponse> listRestoresPagedCallable() {
    return listRestoresPagedCallable;
  }

  @Override
  public UnaryCallable<GetRestoreRequest, Restore> getRestoreCallable() {
    return getRestoreCallable;
  }

  @Override
  public UnaryCallable<UpdateRestoreRequest, Operation> updateRestoreCallable() {
    return updateRestoreCallable;
  }

  @Override
  public OperationCallable<UpdateRestoreRequest, Restore, OperationMetadata>
      updateRestoreOperationCallable() {
    return updateRestoreOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteRestoreRequest, Operation> deleteRestoreCallable() {
    return deleteRestoreCallable;
  }

  @Override
  public OperationCallable<DeleteRestoreRequest, Empty, OperationMetadata>
      deleteRestoreOperationCallable() {
    return deleteRestoreOperationCallable;
  }

  @Override
  public UnaryCallable<ListVolumeRestoresRequest, ListVolumeRestoresResponse>
      listVolumeRestoresCallable() {
    return listVolumeRestoresCallable;
  }

  @Override
  public UnaryCallable<ListVolumeRestoresRequest, ListVolumeRestoresPagedResponse>
      listVolumeRestoresPagedCallable() {
    return listVolumeRestoresPagedCallable;
  }

  @Override
  public UnaryCallable<GetVolumeRestoreRequest, VolumeRestore> getVolumeRestoreCallable() {
    return getVolumeRestoreCallable;
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
