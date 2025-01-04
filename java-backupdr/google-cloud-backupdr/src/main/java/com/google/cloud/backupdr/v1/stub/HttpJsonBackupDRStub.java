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

package com.google.cloud.backupdr.v1.stub;

import static com.google.cloud.backupdr.v1.BackupDRClient.FetchUsableBackupVaultsPagedResponse;
import static com.google.cloud.backupdr.v1.BackupDRClient.ListBackupPlanAssociationsPagedResponse;
import static com.google.cloud.backupdr.v1.BackupDRClient.ListBackupPlansPagedResponse;
import static com.google.cloud.backupdr.v1.BackupDRClient.ListBackupVaultsPagedResponse;
import static com.google.cloud.backupdr.v1.BackupDRClient.ListBackupsPagedResponse;
import static com.google.cloud.backupdr.v1.BackupDRClient.ListDataSourcesPagedResponse;
import static com.google.cloud.backupdr.v1.BackupDRClient.ListLocationsPagedResponse;
import static com.google.cloud.backupdr.v1.BackupDRClient.ListManagementServersPagedResponse;

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
import com.google.cloud.backupdr.v1.Backup;
import com.google.cloud.backupdr.v1.BackupPlan;
import com.google.cloud.backupdr.v1.BackupPlanAssociation;
import com.google.cloud.backupdr.v1.BackupVault;
import com.google.cloud.backupdr.v1.CreateBackupPlanAssociationRequest;
import com.google.cloud.backupdr.v1.CreateBackupPlanRequest;
import com.google.cloud.backupdr.v1.CreateBackupVaultRequest;
import com.google.cloud.backupdr.v1.CreateManagementServerRequest;
import com.google.cloud.backupdr.v1.DataSource;
import com.google.cloud.backupdr.v1.DeleteBackupPlanAssociationRequest;
import com.google.cloud.backupdr.v1.DeleteBackupPlanRequest;
import com.google.cloud.backupdr.v1.DeleteBackupRequest;
import com.google.cloud.backupdr.v1.DeleteBackupVaultRequest;
import com.google.cloud.backupdr.v1.DeleteManagementServerRequest;
import com.google.cloud.backupdr.v1.FetchUsableBackupVaultsRequest;
import com.google.cloud.backupdr.v1.FetchUsableBackupVaultsResponse;
import com.google.cloud.backupdr.v1.GetBackupPlanAssociationRequest;
import com.google.cloud.backupdr.v1.GetBackupPlanRequest;
import com.google.cloud.backupdr.v1.GetBackupRequest;
import com.google.cloud.backupdr.v1.GetBackupVaultRequest;
import com.google.cloud.backupdr.v1.GetDataSourceRequest;
import com.google.cloud.backupdr.v1.GetManagementServerRequest;
import com.google.cloud.backupdr.v1.ListBackupPlanAssociationsRequest;
import com.google.cloud.backupdr.v1.ListBackupPlanAssociationsResponse;
import com.google.cloud.backupdr.v1.ListBackupPlansRequest;
import com.google.cloud.backupdr.v1.ListBackupPlansResponse;
import com.google.cloud.backupdr.v1.ListBackupVaultsRequest;
import com.google.cloud.backupdr.v1.ListBackupVaultsResponse;
import com.google.cloud.backupdr.v1.ListBackupsRequest;
import com.google.cloud.backupdr.v1.ListBackupsResponse;
import com.google.cloud.backupdr.v1.ListDataSourcesRequest;
import com.google.cloud.backupdr.v1.ListDataSourcesResponse;
import com.google.cloud.backupdr.v1.ListManagementServersRequest;
import com.google.cloud.backupdr.v1.ListManagementServersResponse;
import com.google.cloud.backupdr.v1.ManagementServer;
import com.google.cloud.backupdr.v1.OperationMetadata;
import com.google.cloud.backupdr.v1.RestoreBackupRequest;
import com.google.cloud.backupdr.v1.RestoreBackupResponse;
import com.google.cloud.backupdr.v1.TriggerBackupRequest;
import com.google.cloud.backupdr.v1.UpdateBackupRequest;
import com.google.cloud.backupdr.v1.UpdateBackupVaultRequest;
import com.google.cloud.backupdr.v1.UpdateDataSourceRequest;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.common.collect.ImmutableMap;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
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
 * REST stub implementation for the BackupDR service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class HttpJsonBackupDRStub extends BackupDRStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder()
          .add(ManagementServer.getDescriptor())
          .add(OperationMetadata.getDescriptor())
          .add(Empty.getDescriptor())
          .add(BackupVault.getDescriptor())
          .add(Backup.getDescriptor())
          .add(DataSource.getDescriptor())
          .add(BackupPlan.getDescriptor())
          .add(RestoreBackupResponse.getDescriptor())
          .add(BackupPlanAssociation.getDescriptor())
          .build();

  private static final ApiMethodDescriptor<
          ListManagementServersRequest, ListManagementServersResponse>
      listManagementServersMethodDescriptor =
          ApiMethodDescriptor
              .<ListManagementServersRequest, ListManagementServersResponse>newBuilder()
              .setFullMethodName("google.cloud.backupdr.v1.BackupDR/ListManagementServers")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListManagementServersRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/managementServers",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListManagementServersRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListManagementServersRequest> serializer =
                                ProtoRestSerializer.create();
                            if (request.hasFilter()) {
                              serializer.putQueryParam(fields, "filter", request.getFilter());
                            }
                            if (request.hasOrderBy()) {
                              serializer.putQueryParam(fields, "orderBy", request.getOrderBy());
                            }
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListManagementServersResponse>newBuilder()
                      .setDefaultInstance(ListManagementServersResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetManagementServerRequest, ManagementServer>
      getManagementServerMethodDescriptor =
          ApiMethodDescriptor.<GetManagementServerRequest, ManagementServer>newBuilder()
              .setFullMethodName("google.cloud.backupdr.v1.BackupDR/GetManagementServer")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetManagementServerRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/managementServers/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetManagementServerRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetManagementServerRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ManagementServer>newBuilder()
                      .setDefaultInstance(ManagementServer.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateManagementServerRequest, Operation>
      createManagementServerMethodDescriptor =
          ApiMethodDescriptor.<CreateManagementServerRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.backupdr.v1.BackupDR/CreateManagementServer")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateManagementServerRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/managementServers",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateManagementServerRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateManagementServerRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "managementServerId", request.getManagementServerId());
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("managementServer", request.getManagementServer(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateManagementServerRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeleteManagementServerRequest, Operation>
      deleteManagementServerMethodDescriptor =
          ApiMethodDescriptor.<DeleteManagementServerRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.backupdr.v1.BackupDR/DeleteManagementServer")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteManagementServerRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/managementServers/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteManagementServerRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteManagementServerRequest> serializer =
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
                  (DeleteManagementServerRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<CreateBackupVaultRequest, Operation>
      createBackupVaultMethodDescriptor =
          ApiMethodDescriptor.<CreateBackupVaultRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.backupdr.v1.BackupDR/CreateBackupVault")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateBackupVaultRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/backupVaults",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateBackupVaultRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateBackupVaultRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "backupVaultId", request.getBackupVaultId());
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(
                                fields, "validateOnly", request.getValidateOnly());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("backupVault", request.getBackupVault(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateBackupVaultRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<ListBackupVaultsRequest, ListBackupVaultsResponse>
      listBackupVaultsMethodDescriptor =
          ApiMethodDescriptor.<ListBackupVaultsRequest, ListBackupVaultsResponse>newBuilder()
              .setFullMethodName("google.cloud.backupdr.v1.BackupDR/ListBackupVaults")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListBackupVaultsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/backupVaults",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListBackupVaultsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListBackupVaultsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "orderBy", request.getOrderBy());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "view", request.getViewValue());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListBackupVaultsResponse>newBuilder()
                      .setDefaultInstance(ListBackupVaultsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          FetchUsableBackupVaultsRequest, FetchUsableBackupVaultsResponse>
      fetchUsableBackupVaultsMethodDescriptor =
          ApiMethodDescriptor
              .<FetchUsableBackupVaultsRequest, FetchUsableBackupVaultsResponse>newBuilder()
              .setFullMethodName("google.cloud.backupdr.v1.BackupDR/FetchUsableBackupVaults")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<FetchUsableBackupVaultsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/backupVaults:fetchUsable",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<FetchUsableBackupVaultsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<FetchUsableBackupVaultsRequest> serializer =
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
                  ProtoMessageResponseParser.<FetchUsableBackupVaultsResponse>newBuilder()
                      .setDefaultInstance(FetchUsableBackupVaultsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetBackupVaultRequest, BackupVault>
      getBackupVaultMethodDescriptor =
          ApiMethodDescriptor.<GetBackupVaultRequest, BackupVault>newBuilder()
              .setFullMethodName("google.cloud.backupdr.v1.BackupDR/GetBackupVault")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetBackupVaultRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/backupVaults/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetBackupVaultRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetBackupVaultRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "view", request.getViewValue());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<BackupVault>newBuilder()
                      .setDefaultInstance(BackupVault.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateBackupVaultRequest, Operation>
      updateBackupVaultMethodDescriptor =
          ApiMethodDescriptor.<UpdateBackupVaultRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.backupdr.v1.BackupDR/UpdateBackupVault")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateBackupVaultRequest>newBuilder()
                      .setPath(
                          "/v1/{backupVault.name=projects/*/locations/*/backupVaults/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateBackupVaultRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "backupVault.name", request.getBackupVault().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateBackupVaultRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "force", request.getForce());
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(
                                fields, "validateOnly", request.getValidateOnly());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("backupVault", request.getBackupVault(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateBackupVaultRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeleteBackupVaultRequest, Operation>
      deleteBackupVaultMethodDescriptor =
          ApiMethodDescriptor.<DeleteBackupVaultRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.backupdr.v1.BackupDR/DeleteBackupVault")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteBackupVaultRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/backupVaults/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteBackupVaultRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteBackupVaultRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "allowMissing", request.getAllowMissing());
                            serializer.putQueryParam(fields, "etag", request.getEtag());
                            serializer.putQueryParam(fields, "force", request.getForce());
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(
                                fields, "validateOnly", request.getValidateOnly());
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
                  (DeleteBackupVaultRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<ListDataSourcesRequest, ListDataSourcesResponse>
      listDataSourcesMethodDescriptor =
          ApiMethodDescriptor.<ListDataSourcesRequest, ListDataSourcesResponse>newBuilder()
              .setFullMethodName("google.cloud.backupdr.v1.BackupDR/ListDataSources")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListDataSourcesRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/backupVaults/*}/dataSources",
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
                  ProtoMessageResponseParser.<ListDataSourcesResponse>newBuilder()
                      .setDefaultInstance(ListDataSourcesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetDataSourceRequest, DataSource>
      getDataSourceMethodDescriptor =
          ApiMethodDescriptor.<GetDataSourceRequest, DataSource>newBuilder()
              .setFullMethodName("google.cloud.backupdr.v1.BackupDR/GetDataSource")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetDataSourceRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/backupVaults/*/dataSources/*}",
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

  private static final ApiMethodDescriptor<UpdateDataSourceRequest, Operation>
      updateDataSourceMethodDescriptor =
          ApiMethodDescriptor.<UpdateDataSourceRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.backupdr.v1.BackupDR/UpdateDataSource")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateDataSourceRequest>newBuilder()
                      .setPath(
                          "/v1/{dataSource.name=projects/*/locations/*/backupVaults/*/dataSources/*}",
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
                            serializer.putQueryParam(
                                fields, "allowMissing", request.getAllowMissing());
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
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
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateDataSourceRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<ListBackupsRequest, ListBackupsResponse>
      listBackupsMethodDescriptor =
          ApiMethodDescriptor.<ListBackupsRequest, ListBackupsResponse>newBuilder()
              .setFullMethodName("google.cloud.backupdr.v1.BackupDR/ListBackups")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListBackupsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/backupVaults/*/dataSources/*}/backups",
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
                            serializer.putQueryParam(fields, "view", request.getViewValue());
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
          .setFullMethodName("google.cloud.backupdr.v1.BackupDR/GetBackup")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetBackupRequest>newBuilder()
                  .setPath(
                      "/v1/{name=projects/*/locations/*/backupVaults/*/dataSources/*/backups/*}",
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
                        serializer.putQueryParam(fields, "view", request.getViewValue());
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
              .setFullMethodName("google.cloud.backupdr.v1.BackupDR/UpdateBackup")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateBackupRequest>newBuilder()
                      .setPath(
                          "/v1/{backup.name=projects/*/locations/*/backupVaults/*/dataSources/*/backups/*}",
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
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
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
              .setFullMethodName("google.cloud.backupdr.v1.BackupDR/DeleteBackup")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteBackupRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/backupVaults/*/dataSources/*/backups/*}",
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

  private static final ApiMethodDescriptor<RestoreBackupRequest, Operation>
      restoreBackupMethodDescriptor =
          ApiMethodDescriptor.<RestoreBackupRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.backupdr.v1.BackupDR/RestoreBackup")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<RestoreBackupRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/backupVaults/*/dataSources/*/backups/*}:restore",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<RestoreBackupRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<RestoreBackupRequest> serializer =
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
                  (RestoreBackupRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<CreateBackupPlanRequest, Operation>
      createBackupPlanMethodDescriptor =
          ApiMethodDescriptor.<CreateBackupPlanRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.backupdr.v1.BackupDR/CreateBackupPlan")
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
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
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

  private static final ApiMethodDescriptor<GetBackupPlanRequest, BackupPlan>
      getBackupPlanMethodDescriptor =
          ApiMethodDescriptor.<GetBackupPlanRequest, BackupPlan>newBuilder()
              .setFullMethodName("google.cloud.backupdr.v1.BackupDR/GetBackupPlan")
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

  private static final ApiMethodDescriptor<ListBackupPlansRequest, ListBackupPlansResponse>
      listBackupPlansMethodDescriptor =
          ApiMethodDescriptor.<ListBackupPlansRequest, ListBackupPlansResponse>newBuilder()
              .setFullMethodName("google.cloud.backupdr.v1.BackupDR/ListBackupPlans")
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

  private static final ApiMethodDescriptor<DeleteBackupPlanRequest, Operation>
      deleteBackupPlanMethodDescriptor =
          ApiMethodDescriptor.<DeleteBackupPlanRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.backupdr.v1.BackupDR/DeleteBackupPlan")
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
                  (DeleteBackupPlanRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<CreateBackupPlanAssociationRequest, Operation>
      createBackupPlanAssociationMethodDescriptor =
          ApiMethodDescriptor.<CreateBackupPlanAssociationRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.backupdr.v1.BackupDR/CreateBackupPlanAssociation")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateBackupPlanAssociationRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/backupPlanAssociations",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateBackupPlanAssociationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateBackupPlanAssociationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields,
                                "backupPlanAssociationId",
                                request.getBackupPlanAssociationId());
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "backupPlanAssociation",
                                      request.getBackupPlanAssociation(),
                                      true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateBackupPlanAssociationRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<GetBackupPlanAssociationRequest, BackupPlanAssociation>
      getBackupPlanAssociationMethodDescriptor =
          ApiMethodDescriptor.<GetBackupPlanAssociationRequest, BackupPlanAssociation>newBuilder()
              .setFullMethodName("google.cloud.backupdr.v1.BackupDR/GetBackupPlanAssociation")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetBackupPlanAssociationRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/backupPlanAssociations/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetBackupPlanAssociationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetBackupPlanAssociationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<BackupPlanAssociation>newBuilder()
                      .setDefaultInstance(BackupPlanAssociation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListBackupPlanAssociationsRequest, ListBackupPlanAssociationsResponse>
      listBackupPlanAssociationsMethodDescriptor =
          ApiMethodDescriptor
              .<ListBackupPlanAssociationsRequest, ListBackupPlanAssociationsResponse>newBuilder()
              .setFullMethodName("google.cloud.backupdr.v1.BackupDR/ListBackupPlanAssociations")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListBackupPlanAssociationsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/backupPlanAssociations",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListBackupPlanAssociationsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListBackupPlanAssociationsRequest> serializer =
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
                  ProtoMessageResponseParser.<ListBackupPlanAssociationsResponse>newBuilder()
                      .setDefaultInstance(ListBackupPlanAssociationsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteBackupPlanAssociationRequest, Operation>
      deleteBackupPlanAssociationMethodDescriptor =
          ApiMethodDescriptor.<DeleteBackupPlanAssociationRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.backupdr.v1.BackupDR/DeleteBackupPlanAssociation")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteBackupPlanAssociationRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/backupPlanAssociations/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteBackupPlanAssociationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteBackupPlanAssociationRequest> serializer =
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
                  (DeleteBackupPlanAssociationRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<TriggerBackupRequest, Operation>
      triggerBackupMethodDescriptor =
          ApiMethodDescriptor.<TriggerBackupRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.backupdr.v1.BackupDR/TriggerBackup")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<TriggerBackupRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/backupPlanAssociations/*}:triggerBackup",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<TriggerBackupRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<TriggerBackupRequest> serializer =
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
                  (TriggerBackupRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<ListLocationsRequest, ListLocationsResponse>
      listLocationsMethodDescriptor =
          ApiMethodDescriptor.<ListLocationsRequest, ListLocationsResponse>newBuilder()
              .setFullMethodName("google.cloud.location.Locations/ListLocations")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListLocationsRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*}/locations",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListLocationsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListLocationsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListLocationsResponse>newBuilder()
                      .setDefaultInstance(ListLocationsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetLocationRequest, Location>
      getLocationMethodDescriptor =
          ApiMethodDescriptor.<GetLocationRequest, Location>newBuilder()
              .setFullMethodName("google.cloud.location.Locations/GetLocation")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetLocationRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetLocationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetLocationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Location>newBuilder()
                      .setDefaultInstance(Location.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<SetIamPolicyRequest, Policy>
      setIamPolicyMethodDescriptor =
          ApiMethodDescriptor.<SetIamPolicyRequest, Policy>newBuilder()
              .setFullMethodName("google.iam.v1.IAMPolicy/SetIamPolicy")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SetIamPolicyRequest>newBuilder()
                      .setPath(
                          "/v1/{resource=projects/*/locations/*/managementServers/*}:setIamPolicy",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SetIamPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "resource", request.getResource());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SetIamPolicyRequest> serializer =
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
                  ProtoMessageResponseParser.<Policy>newBuilder()
                      .setDefaultInstance(Policy.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetIamPolicyRequest, Policy>
      getIamPolicyMethodDescriptor =
          ApiMethodDescriptor.<GetIamPolicyRequest, Policy>newBuilder()
              .setFullMethodName("google.iam.v1.IAMPolicy/GetIamPolicy")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetIamPolicyRequest>newBuilder()
                      .setPath(
                          "/v1/{resource=projects/*/locations/*/managementServers/*}:getIamPolicy",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetIamPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "resource", request.getResource());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetIamPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Policy>newBuilder()
                      .setDefaultInstance(Policy.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsMethodDescriptor =
          ApiMethodDescriptor.<TestIamPermissionsRequest, TestIamPermissionsResponse>newBuilder()
              .setFullMethodName("google.iam.v1.IAMPolicy/TestIamPermissions")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<TestIamPermissionsRequest>newBuilder()
                      .setPath(
                          "/v1/{resource=projects/*/locations/*/managementServers/*}:testIamPermissions",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<TestIamPermissionsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "resource", request.getResource());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<TestIamPermissionsRequest> serializer =
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
                  ProtoMessageResponseParser.<TestIamPermissionsResponse>newBuilder()
                      .setDefaultInstance(TestIamPermissionsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<ListManagementServersRequest, ListManagementServersResponse>
      listManagementServersCallable;
  private final UnaryCallable<ListManagementServersRequest, ListManagementServersPagedResponse>
      listManagementServersPagedCallable;
  private final UnaryCallable<GetManagementServerRequest, ManagementServer>
      getManagementServerCallable;
  private final UnaryCallable<CreateManagementServerRequest, Operation>
      createManagementServerCallable;
  private final OperationCallable<
          CreateManagementServerRequest, ManagementServer, OperationMetadata>
      createManagementServerOperationCallable;
  private final UnaryCallable<DeleteManagementServerRequest, Operation>
      deleteManagementServerCallable;
  private final OperationCallable<DeleteManagementServerRequest, Empty, OperationMetadata>
      deleteManagementServerOperationCallable;
  private final UnaryCallable<CreateBackupVaultRequest, Operation> createBackupVaultCallable;
  private final OperationCallable<CreateBackupVaultRequest, BackupVault, OperationMetadata>
      createBackupVaultOperationCallable;
  private final UnaryCallable<ListBackupVaultsRequest, ListBackupVaultsResponse>
      listBackupVaultsCallable;
  private final UnaryCallable<ListBackupVaultsRequest, ListBackupVaultsPagedResponse>
      listBackupVaultsPagedCallable;
  private final UnaryCallable<FetchUsableBackupVaultsRequest, FetchUsableBackupVaultsResponse>
      fetchUsableBackupVaultsCallable;
  private final UnaryCallable<FetchUsableBackupVaultsRequest, FetchUsableBackupVaultsPagedResponse>
      fetchUsableBackupVaultsPagedCallable;
  private final UnaryCallable<GetBackupVaultRequest, BackupVault> getBackupVaultCallable;
  private final UnaryCallable<UpdateBackupVaultRequest, Operation> updateBackupVaultCallable;
  private final OperationCallable<UpdateBackupVaultRequest, BackupVault, OperationMetadata>
      updateBackupVaultOperationCallable;
  private final UnaryCallable<DeleteBackupVaultRequest, Operation> deleteBackupVaultCallable;
  private final OperationCallable<DeleteBackupVaultRequest, Empty, OperationMetadata>
      deleteBackupVaultOperationCallable;
  private final UnaryCallable<ListDataSourcesRequest, ListDataSourcesResponse>
      listDataSourcesCallable;
  private final UnaryCallable<ListDataSourcesRequest, ListDataSourcesPagedResponse>
      listDataSourcesPagedCallable;
  private final UnaryCallable<GetDataSourceRequest, DataSource> getDataSourceCallable;
  private final UnaryCallable<UpdateDataSourceRequest, Operation> updateDataSourceCallable;
  private final OperationCallable<UpdateDataSourceRequest, DataSource, OperationMetadata>
      updateDataSourceOperationCallable;
  private final UnaryCallable<ListBackupsRequest, ListBackupsResponse> listBackupsCallable;
  private final UnaryCallable<ListBackupsRequest, ListBackupsPagedResponse>
      listBackupsPagedCallable;
  private final UnaryCallable<GetBackupRequest, Backup> getBackupCallable;
  private final UnaryCallable<UpdateBackupRequest, Operation> updateBackupCallable;
  private final OperationCallable<UpdateBackupRequest, Backup, OperationMetadata>
      updateBackupOperationCallable;
  private final UnaryCallable<DeleteBackupRequest, Operation> deleteBackupCallable;
  private final OperationCallable<DeleteBackupRequest, Backup, OperationMetadata>
      deleteBackupOperationCallable;
  private final UnaryCallable<RestoreBackupRequest, Operation> restoreBackupCallable;
  private final OperationCallable<RestoreBackupRequest, RestoreBackupResponse, OperationMetadata>
      restoreBackupOperationCallable;
  private final UnaryCallable<CreateBackupPlanRequest, Operation> createBackupPlanCallable;
  private final OperationCallable<CreateBackupPlanRequest, BackupPlan, OperationMetadata>
      createBackupPlanOperationCallable;
  private final UnaryCallable<GetBackupPlanRequest, BackupPlan> getBackupPlanCallable;
  private final UnaryCallable<ListBackupPlansRequest, ListBackupPlansResponse>
      listBackupPlansCallable;
  private final UnaryCallable<ListBackupPlansRequest, ListBackupPlansPagedResponse>
      listBackupPlansPagedCallable;
  private final UnaryCallable<DeleteBackupPlanRequest, Operation> deleteBackupPlanCallable;
  private final OperationCallable<DeleteBackupPlanRequest, Empty, OperationMetadata>
      deleteBackupPlanOperationCallable;
  private final UnaryCallable<CreateBackupPlanAssociationRequest, Operation>
      createBackupPlanAssociationCallable;
  private final OperationCallable<
          CreateBackupPlanAssociationRequest, BackupPlanAssociation, OperationMetadata>
      createBackupPlanAssociationOperationCallable;
  private final UnaryCallable<GetBackupPlanAssociationRequest, BackupPlanAssociation>
      getBackupPlanAssociationCallable;
  private final UnaryCallable<ListBackupPlanAssociationsRequest, ListBackupPlanAssociationsResponse>
      listBackupPlanAssociationsCallable;
  private final UnaryCallable<
          ListBackupPlanAssociationsRequest, ListBackupPlanAssociationsPagedResponse>
      listBackupPlanAssociationsPagedCallable;
  private final UnaryCallable<DeleteBackupPlanAssociationRequest, Operation>
      deleteBackupPlanAssociationCallable;
  private final OperationCallable<DeleteBackupPlanAssociationRequest, Empty, OperationMetadata>
      deleteBackupPlanAssociationOperationCallable;
  private final UnaryCallable<TriggerBackupRequest, Operation> triggerBackupCallable;
  private final OperationCallable<TriggerBackupRequest, BackupPlanAssociation, OperationMetadata>
      triggerBackupOperationCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<GetLocationRequest, Location> getLocationCallable;
  private final UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable;
  private final UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable;
  private final UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonBackupDRStub create(BackupDRStubSettings settings)
      throws IOException {
    return new HttpJsonBackupDRStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonBackupDRStub create(ClientContext clientContext) throws IOException {
    return new HttpJsonBackupDRStub(
        BackupDRStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonBackupDRStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonBackupDRStub(
        BackupDRStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonBackupDRStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonBackupDRStub(BackupDRStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonBackupDRCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonBackupDRStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonBackupDRStub(
      BackupDRStubSettings settings,
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
                        .setPost("/v1/{name=projects/*/locations/*/operations/*}:cancel")
                        .build())
                .put(
                    "google.longrunning.Operations.DeleteOperation",
                    HttpRule.newBuilder()
                        .setDelete("/v1/{name=projects/*/locations/*/operations/*}")
                        .build())
                .put(
                    "google.longrunning.Operations.GetOperation",
                    HttpRule.newBuilder()
                        .setGet("/v1/{name=projects/*/locations/*/operations/*}")
                        .build())
                .put(
                    "google.longrunning.Operations.ListOperations",
                    HttpRule.newBuilder()
                        .setGet("/v1/{name=projects/*/locations/*}/operations")
                        .build())
                .build());

    HttpJsonCallSettings<ListManagementServersRequest, ListManagementServersResponse>
        listManagementServersTransportSettings =
            HttpJsonCallSettings
                .<ListManagementServersRequest, ListManagementServersResponse>newBuilder()
                .setMethodDescriptor(listManagementServersMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetManagementServerRequest, ManagementServer>
        getManagementServerTransportSettings =
            HttpJsonCallSettings.<GetManagementServerRequest, ManagementServer>newBuilder()
                .setMethodDescriptor(getManagementServerMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<CreateManagementServerRequest, Operation>
        createManagementServerTransportSettings =
            HttpJsonCallSettings.<CreateManagementServerRequest, Operation>newBuilder()
                .setMethodDescriptor(createManagementServerMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<DeleteManagementServerRequest, Operation>
        deleteManagementServerTransportSettings =
            HttpJsonCallSettings.<DeleteManagementServerRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteManagementServerMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<CreateBackupVaultRequest, Operation> createBackupVaultTransportSettings =
        HttpJsonCallSettings.<CreateBackupVaultRequest, Operation>newBuilder()
            .setMethodDescriptor(createBackupVaultMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListBackupVaultsRequest, ListBackupVaultsResponse>
        listBackupVaultsTransportSettings =
            HttpJsonCallSettings.<ListBackupVaultsRequest, ListBackupVaultsResponse>newBuilder()
                .setMethodDescriptor(listBackupVaultsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<FetchUsableBackupVaultsRequest, FetchUsableBackupVaultsResponse>
        fetchUsableBackupVaultsTransportSettings =
            HttpJsonCallSettings
                .<FetchUsableBackupVaultsRequest, FetchUsableBackupVaultsResponse>newBuilder()
                .setMethodDescriptor(fetchUsableBackupVaultsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetBackupVaultRequest, BackupVault> getBackupVaultTransportSettings =
        HttpJsonCallSettings.<GetBackupVaultRequest, BackupVault>newBuilder()
            .setMethodDescriptor(getBackupVaultMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<UpdateBackupVaultRequest, Operation> updateBackupVaultTransportSettings =
        HttpJsonCallSettings.<UpdateBackupVaultRequest, Operation>newBuilder()
            .setMethodDescriptor(updateBackupVaultMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(
                      "backup_vault.name", String.valueOf(request.getBackupVault().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeleteBackupVaultRequest, Operation> deleteBackupVaultTransportSettings =
        HttpJsonCallSettings.<DeleteBackupVaultRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteBackupVaultMethodDescriptor)
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
    HttpJsonCallSettings<UpdateDataSourceRequest, Operation> updateDataSourceTransportSettings =
        HttpJsonCallSettings.<UpdateDataSourceRequest, Operation>newBuilder()
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
    HttpJsonCallSettings<UpdateBackupRequest, Operation> updateBackupTransportSettings =
        HttpJsonCallSettings.<UpdateBackupRequest, Operation>newBuilder()
            .setMethodDescriptor(updateBackupMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("backup.name", String.valueOf(request.getBackup().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeleteBackupRequest, Operation> deleteBackupTransportSettings =
        HttpJsonCallSettings.<DeleteBackupRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteBackupMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<RestoreBackupRequest, Operation> restoreBackupTransportSettings =
        HttpJsonCallSettings.<RestoreBackupRequest, Operation>newBuilder()
            .setMethodDescriptor(restoreBackupMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<CreateBackupPlanRequest, Operation> createBackupPlanTransportSettings =
        HttpJsonCallSettings.<CreateBackupPlanRequest, Operation>newBuilder()
            .setMethodDescriptor(createBackupPlanMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<GetBackupPlanRequest, BackupPlan> getBackupPlanTransportSettings =
        HttpJsonCallSettings.<GetBackupPlanRequest, BackupPlan>newBuilder()
            .setMethodDescriptor(getBackupPlanMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListBackupPlansRequest, ListBackupPlansResponse>
        listBackupPlansTransportSettings =
            HttpJsonCallSettings.<ListBackupPlansRequest, ListBackupPlansResponse>newBuilder()
                .setMethodDescriptor(listBackupPlansMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<DeleteBackupPlanRequest, Operation> deleteBackupPlanTransportSettings =
        HttpJsonCallSettings.<DeleteBackupPlanRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteBackupPlanMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<CreateBackupPlanAssociationRequest, Operation>
        createBackupPlanAssociationTransportSettings =
            HttpJsonCallSettings.<CreateBackupPlanAssociationRequest, Operation>newBuilder()
                .setMethodDescriptor(createBackupPlanAssociationMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetBackupPlanAssociationRequest, BackupPlanAssociation>
        getBackupPlanAssociationTransportSettings =
            HttpJsonCallSettings
                .<GetBackupPlanAssociationRequest, BackupPlanAssociation>newBuilder()
                .setMethodDescriptor(getBackupPlanAssociationMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ListBackupPlanAssociationsRequest, ListBackupPlanAssociationsResponse>
        listBackupPlanAssociationsTransportSettings =
            HttpJsonCallSettings
                .<ListBackupPlanAssociationsRequest, ListBackupPlanAssociationsResponse>newBuilder()
                .setMethodDescriptor(listBackupPlanAssociationsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<DeleteBackupPlanAssociationRequest, Operation>
        deleteBackupPlanAssociationTransportSettings =
            HttpJsonCallSettings.<DeleteBackupPlanAssociationRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteBackupPlanAssociationMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<TriggerBackupRequest, Operation> triggerBackupTransportSettings =
        HttpJsonCallSettings.<TriggerBackupRequest, Operation>newBuilder()
            .setMethodDescriptor(triggerBackupMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListLocationsRequest, ListLocationsResponse>
        listLocationsTransportSettings =
            HttpJsonCallSettings.<ListLocationsRequest, ListLocationsResponse>newBuilder()
                .setMethodDescriptor(listLocationsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetLocationRequest, Location> getLocationTransportSettings =
        HttpJsonCallSettings.<GetLocationRequest, Location>newBuilder()
            .setMethodDescriptor(getLocationMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<SetIamPolicyRequest, Policy> setIamPolicyTransportSettings =
        HttpJsonCallSettings.<SetIamPolicyRequest, Policy>newBuilder()
            .setMethodDescriptor(setIamPolicyMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("resource", String.valueOf(request.getResource()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<GetIamPolicyRequest, Policy> getIamPolicyTransportSettings =
        HttpJsonCallSettings.<GetIamPolicyRequest, Policy>newBuilder()
            .setMethodDescriptor(getIamPolicyMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("resource", String.valueOf(request.getResource()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsTransportSettings =
            HttpJsonCallSettings.<TestIamPermissionsRequest, TestIamPermissionsResponse>newBuilder()
                .setMethodDescriptor(testIamPermissionsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("resource", String.valueOf(request.getResource()));
                      return builder.build();
                    })
                .build();

    this.listManagementServersCallable =
        callableFactory.createUnaryCallable(
            listManagementServersTransportSettings,
            settings.listManagementServersSettings(),
            clientContext);
    this.listManagementServersPagedCallable =
        callableFactory.createPagedCallable(
            listManagementServersTransportSettings,
            settings.listManagementServersSettings(),
            clientContext);
    this.getManagementServerCallable =
        callableFactory.createUnaryCallable(
            getManagementServerTransportSettings,
            settings.getManagementServerSettings(),
            clientContext);
    this.createManagementServerCallable =
        callableFactory.createUnaryCallable(
            createManagementServerTransportSettings,
            settings.createManagementServerSettings(),
            clientContext);
    this.createManagementServerOperationCallable =
        callableFactory.createOperationCallable(
            createManagementServerTransportSettings,
            settings.createManagementServerOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.deleteManagementServerCallable =
        callableFactory.createUnaryCallable(
            deleteManagementServerTransportSettings,
            settings.deleteManagementServerSettings(),
            clientContext);
    this.deleteManagementServerOperationCallable =
        callableFactory.createOperationCallable(
            deleteManagementServerTransportSettings,
            settings.deleteManagementServerOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.createBackupVaultCallable =
        callableFactory.createUnaryCallable(
            createBackupVaultTransportSettings,
            settings.createBackupVaultSettings(),
            clientContext);
    this.createBackupVaultOperationCallable =
        callableFactory.createOperationCallable(
            createBackupVaultTransportSettings,
            settings.createBackupVaultOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.listBackupVaultsCallable =
        callableFactory.createUnaryCallable(
            listBackupVaultsTransportSettings, settings.listBackupVaultsSettings(), clientContext);
    this.listBackupVaultsPagedCallable =
        callableFactory.createPagedCallable(
            listBackupVaultsTransportSettings, settings.listBackupVaultsSettings(), clientContext);
    this.fetchUsableBackupVaultsCallable =
        callableFactory.createUnaryCallable(
            fetchUsableBackupVaultsTransportSettings,
            settings.fetchUsableBackupVaultsSettings(),
            clientContext);
    this.fetchUsableBackupVaultsPagedCallable =
        callableFactory.createPagedCallable(
            fetchUsableBackupVaultsTransportSettings,
            settings.fetchUsableBackupVaultsSettings(),
            clientContext);
    this.getBackupVaultCallable =
        callableFactory.createUnaryCallable(
            getBackupVaultTransportSettings, settings.getBackupVaultSettings(), clientContext);
    this.updateBackupVaultCallable =
        callableFactory.createUnaryCallable(
            updateBackupVaultTransportSettings,
            settings.updateBackupVaultSettings(),
            clientContext);
    this.updateBackupVaultOperationCallable =
        callableFactory.createOperationCallable(
            updateBackupVaultTransportSettings,
            settings.updateBackupVaultOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.deleteBackupVaultCallable =
        callableFactory.createUnaryCallable(
            deleteBackupVaultTransportSettings,
            settings.deleteBackupVaultSettings(),
            clientContext);
    this.deleteBackupVaultOperationCallable =
        callableFactory.createOperationCallable(
            deleteBackupVaultTransportSettings,
            settings.deleteBackupVaultOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.listDataSourcesCallable =
        callableFactory.createUnaryCallable(
            listDataSourcesTransportSettings, settings.listDataSourcesSettings(), clientContext);
    this.listDataSourcesPagedCallable =
        callableFactory.createPagedCallable(
            listDataSourcesTransportSettings, settings.listDataSourcesSettings(), clientContext);
    this.getDataSourceCallable =
        callableFactory.createUnaryCallable(
            getDataSourceTransportSettings, settings.getDataSourceSettings(), clientContext);
    this.updateDataSourceCallable =
        callableFactory.createUnaryCallable(
            updateDataSourceTransportSettings, settings.updateDataSourceSettings(), clientContext);
    this.updateDataSourceOperationCallable =
        callableFactory.createOperationCallable(
            updateDataSourceTransportSettings,
            settings.updateDataSourceOperationSettings(),
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
    this.restoreBackupCallable =
        callableFactory.createUnaryCallable(
            restoreBackupTransportSettings, settings.restoreBackupSettings(), clientContext);
    this.restoreBackupOperationCallable =
        callableFactory.createOperationCallable(
            restoreBackupTransportSettings,
            settings.restoreBackupOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.createBackupPlanCallable =
        callableFactory.createUnaryCallable(
            createBackupPlanTransportSettings, settings.createBackupPlanSettings(), clientContext);
    this.createBackupPlanOperationCallable =
        callableFactory.createOperationCallable(
            createBackupPlanTransportSettings,
            settings.createBackupPlanOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.getBackupPlanCallable =
        callableFactory.createUnaryCallable(
            getBackupPlanTransportSettings, settings.getBackupPlanSettings(), clientContext);
    this.listBackupPlansCallable =
        callableFactory.createUnaryCallable(
            listBackupPlansTransportSettings, settings.listBackupPlansSettings(), clientContext);
    this.listBackupPlansPagedCallable =
        callableFactory.createPagedCallable(
            listBackupPlansTransportSettings, settings.listBackupPlansSettings(), clientContext);
    this.deleteBackupPlanCallable =
        callableFactory.createUnaryCallable(
            deleteBackupPlanTransportSettings, settings.deleteBackupPlanSettings(), clientContext);
    this.deleteBackupPlanOperationCallable =
        callableFactory.createOperationCallable(
            deleteBackupPlanTransportSettings,
            settings.deleteBackupPlanOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.createBackupPlanAssociationCallable =
        callableFactory.createUnaryCallable(
            createBackupPlanAssociationTransportSettings,
            settings.createBackupPlanAssociationSettings(),
            clientContext);
    this.createBackupPlanAssociationOperationCallable =
        callableFactory.createOperationCallable(
            createBackupPlanAssociationTransportSettings,
            settings.createBackupPlanAssociationOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.getBackupPlanAssociationCallable =
        callableFactory.createUnaryCallable(
            getBackupPlanAssociationTransportSettings,
            settings.getBackupPlanAssociationSettings(),
            clientContext);
    this.listBackupPlanAssociationsCallable =
        callableFactory.createUnaryCallable(
            listBackupPlanAssociationsTransportSettings,
            settings.listBackupPlanAssociationsSettings(),
            clientContext);
    this.listBackupPlanAssociationsPagedCallable =
        callableFactory.createPagedCallable(
            listBackupPlanAssociationsTransportSettings,
            settings.listBackupPlanAssociationsSettings(),
            clientContext);
    this.deleteBackupPlanAssociationCallable =
        callableFactory.createUnaryCallable(
            deleteBackupPlanAssociationTransportSettings,
            settings.deleteBackupPlanAssociationSettings(),
            clientContext);
    this.deleteBackupPlanAssociationOperationCallable =
        callableFactory.createOperationCallable(
            deleteBackupPlanAssociationTransportSettings,
            settings.deleteBackupPlanAssociationOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.triggerBackupCallable =
        callableFactory.createUnaryCallable(
            triggerBackupTransportSettings, settings.triggerBackupSettings(), clientContext);
    this.triggerBackupOperationCallable =
        callableFactory.createOperationCallable(
            triggerBackupTransportSettings,
            settings.triggerBackupOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.listLocationsCallable =
        callableFactory.createUnaryCallable(
            listLocationsTransportSettings, settings.listLocationsSettings(), clientContext);
    this.listLocationsPagedCallable =
        callableFactory.createPagedCallable(
            listLocationsTransportSettings, settings.listLocationsSettings(), clientContext);
    this.getLocationCallable =
        callableFactory.createUnaryCallable(
            getLocationTransportSettings, settings.getLocationSettings(), clientContext);
    this.setIamPolicyCallable =
        callableFactory.createUnaryCallable(
            setIamPolicyTransportSettings, settings.setIamPolicySettings(), clientContext);
    this.getIamPolicyCallable =
        callableFactory.createUnaryCallable(
            getIamPolicyTransportSettings, settings.getIamPolicySettings(), clientContext);
    this.testIamPermissionsCallable =
        callableFactory.createUnaryCallable(
            testIamPermissionsTransportSettings,
            settings.testIamPermissionsSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(listManagementServersMethodDescriptor);
    methodDescriptors.add(getManagementServerMethodDescriptor);
    methodDescriptors.add(createManagementServerMethodDescriptor);
    methodDescriptors.add(deleteManagementServerMethodDescriptor);
    methodDescriptors.add(createBackupVaultMethodDescriptor);
    methodDescriptors.add(listBackupVaultsMethodDescriptor);
    methodDescriptors.add(fetchUsableBackupVaultsMethodDescriptor);
    methodDescriptors.add(getBackupVaultMethodDescriptor);
    methodDescriptors.add(updateBackupVaultMethodDescriptor);
    methodDescriptors.add(deleteBackupVaultMethodDescriptor);
    methodDescriptors.add(listDataSourcesMethodDescriptor);
    methodDescriptors.add(getDataSourceMethodDescriptor);
    methodDescriptors.add(updateDataSourceMethodDescriptor);
    methodDescriptors.add(listBackupsMethodDescriptor);
    methodDescriptors.add(getBackupMethodDescriptor);
    methodDescriptors.add(updateBackupMethodDescriptor);
    methodDescriptors.add(deleteBackupMethodDescriptor);
    methodDescriptors.add(restoreBackupMethodDescriptor);
    methodDescriptors.add(createBackupPlanMethodDescriptor);
    methodDescriptors.add(getBackupPlanMethodDescriptor);
    methodDescriptors.add(listBackupPlansMethodDescriptor);
    methodDescriptors.add(deleteBackupPlanMethodDescriptor);
    methodDescriptors.add(createBackupPlanAssociationMethodDescriptor);
    methodDescriptors.add(getBackupPlanAssociationMethodDescriptor);
    methodDescriptors.add(listBackupPlanAssociationsMethodDescriptor);
    methodDescriptors.add(deleteBackupPlanAssociationMethodDescriptor);
    methodDescriptors.add(triggerBackupMethodDescriptor);
    methodDescriptors.add(listLocationsMethodDescriptor);
    methodDescriptors.add(getLocationMethodDescriptor);
    methodDescriptors.add(setIamPolicyMethodDescriptor);
    methodDescriptors.add(getIamPolicyMethodDescriptor);
    methodDescriptors.add(testIamPermissionsMethodDescriptor);
    return methodDescriptors;
  }

  public HttpJsonOperationsStub getHttpJsonOperationsStub() {
    return httpJsonOperationsStub;
  }

  @Override
  public UnaryCallable<ListManagementServersRequest, ListManagementServersResponse>
      listManagementServersCallable() {
    return listManagementServersCallable;
  }

  @Override
  public UnaryCallable<ListManagementServersRequest, ListManagementServersPagedResponse>
      listManagementServersPagedCallable() {
    return listManagementServersPagedCallable;
  }

  @Override
  public UnaryCallable<GetManagementServerRequest, ManagementServer> getManagementServerCallable() {
    return getManagementServerCallable;
  }

  @Override
  public UnaryCallable<CreateManagementServerRequest, Operation> createManagementServerCallable() {
    return createManagementServerCallable;
  }

  @Override
  public OperationCallable<CreateManagementServerRequest, ManagementServer, OperationMetadata>
      createManagementServerOperationCallable() {
    return createManagementServerOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteManagementServerRequest, Operation> deleteManagementServerCallable() {
    return deleteManagementServerCallable;
  }

  @Override
  public OperationCallable<DeleteManagementServerRequest, Empty, OperationMetadata>
      deleteManagementServerOperationCallable() {
    return deleteManagementServerOperationCallable;
  }

  @Override
  public UnaryCallable<CreateBackupVaultRequest, Operation> createBackupVaultCallable() {
    return createBackupVaultCallable;
  }

  @Override
  public OperationCallable<CreateBackupVaultRequest, BackupVault, OperationMetadata>
      createBackupVaultOperationCallable() {
    return createBackupVaultOperationCallable;
  }

  @Override
  public UnaryCallable<ListBackupVaultsRequest, ListBackupVaultsResponse>
      listBackupVaultsCallable() {
    return listBackupVaultsCallable;
  }

  @Override
  public UnaryCallable<ListBackupVaultsRequest, ListBackupVaultsPagedResponse>
      listBackupVaultsPagedCallable() {
    return listBackupVaultsPagedCallable;
  }

  @Override
  public UnaryCallable<FetchUsableBackupVaultsRequest, FetchUsableBackupVaultsResponse>
      fetchUsableBackupVaultsCallable() {
    return fetchUsableBackupVaultsCallable;
  }

  @Override
  public UnaryCallable<FetchUsableBackupVaultsRequest, FetchUsableBackupVaultsPagedResponse>
      fetchUsableBackupVaultsPagedCallable() {
    return fetchUsableBackupVaultsPagedCallable;
  }

  @Override
  public UnaryCallable<GetBackupVaultRequest, BackupVault> getBackupVaultCallable() {
    return getBackupVaultCallable;
  }

  @Override
  public UnaryCallable<UpdateBackupVaultRequest, Operation> updateBackupVaultCallable() {
    return updateBackupVaultCallable;
  }

  @Override
  public OperationCallable<UpdateBackupVaultRequest, BackupVault, OperationMetadata>
      updateBackupVaultOperationCallable() {
    return updateBackupVaultOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteBackupVaultRequest, Operation> deleteBackupVaultCallable() {
    return deleteBackupVaultCallable;
  }

  @Override
  public OperationCallable<DeleteBackupVaultRequest, Empty, OperationMetadata>
      deleteBackupVaultOperationCallable() {
    return deleteBackupVaultOperationCallable;
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
  public UnaryCallable<GetDataSourceRequest, DataSource> getDataSourceCallable() {
    return getDataSourceCallable;
  }

  @Override
  public UnaryCallable<UpdateDataSourceRequest, Operation> updateDataSourceCallable() {
    return updateDataSourceCallable;
  }

  @Override
  public OperationCallable<UpdateDataSourceRequest, DataSource, OperationMetadata>
      updateDataSourceOperationCallable() {
    return updateDataSourceOperationCallable;
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
  public OperationCallable<DeleteBackupRequest, Backup, OperationMetadata>
      deleteBackupOperationCallable() {
    return deleteBackupOperationCallable;
  }

  @Override
  public UnaryCallable<RestoreBackupRequest, Operation> restoreBackupCallable() {
    return restoreBackupCallable;
  }

  @Override
  public OperationCallable<RestoreBackupRequest, RestoreBackupResponse, OperationMetadata>
      restoreBackupOperationCallable() {
    return restoreBackupOperationCallable;
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
  public UnaryCallable<GetBackupPlanRequest, BackupPlan> getBackupPlanCallable() {
    return getBackupPlanCallable;
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
  public UnaryCallable<DeleteBackupPlanRequest, Operation> deleteBackupPlanCallable() {
    return deleteBackupPlanCallable;
  }

  @Override
  public OperationCallable<DeleteBackupPlanRequest, Empty, OperationMetadata>
      deleteBackupPlanOperationCallable() {
    return deleteBackupPlanOperationCallable;
  }

  @Override
  public UnaryCallable<CreateBackupPlanAssociationRequest, Operation>
      createBackupPlanAssociationCallable() {
    return createBackupPlanAssociationCallable;
  }

  @Override
  public OperationCallable<
          CreateBackupPlanAssociationRequest, BackupPlanAssociation, OperationMetadata>
      createBackupPlanAssociationOperationCallable() {
    return createBackupPlanAssociationOperationCallable;
  }

  @Override
  public UnaryCallable<GetBackupPlanAssociationRequest, BackupPlanAssociation>
      getBackupPlanAssociationCallable() {
    return getBackupPlanAssociationCallable;
  }

  @Override
  public UnaryCallable<ListBackupPlanAssociationsRequest, ListBackupPlanAssociationsResponse>
      listBackupPlanAssociationsCallable() {
    return listBackupPlanAssociationsCallable;
  }

  @Override
  public UnaryCallable<ListBackupPlanAssociationsRequest, ListBackupPlanAssociationsPagedResponse>
      listBackupPlanAssociationsPagedCallable() {
    return listBackupPlanAssociationsPagedCallable;
  }

  @Override
  public UnaryCallable<DeleteBackupPlanAssociationRequest, Operation>
      deleteBackupPlanAssociationCallable() {
    return deleteBackupPlanAssociationCallable;
  }

  @Override
  public OperationCallable<DeleteBackupPlanAssociationRequest, Empty, OperationMetadata>
      deleteBackupPlanAssociationOperationCallable() {
    return deleteBackupPlanAssociationOperationCallable;
  }

  @Override
  public UnaryCallable<TriggerBackupRequest, Operation> triggerBackupCallable() {
    return triggerBackupCallable;
  }

  @Override
  public OperationCallable<TriggerBackupRequest, BackupPlanAssociation, OperationMetadata>
      triggerBackupOperationCallable() {
    return triggerBackupOperationCallable;
  }

  @Override
  public UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable() {
    return listLocationsCallable;
  }

  @Override
  public UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable() {
    return listLocationsPagedCallable;
  }

  @Override
  public UnaryCallable<GetLocationRequest, Location> getLocationCallable() {
    return getLocationCallable;
  }

  @Override
  public UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable() {
    return setIamPolicyCallable;
  }

  @Override
  public UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable() {
    return getIamPolicyCallable;
  }

  @Override
  public UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable() {
    return testIamPermissionsCallable;
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
