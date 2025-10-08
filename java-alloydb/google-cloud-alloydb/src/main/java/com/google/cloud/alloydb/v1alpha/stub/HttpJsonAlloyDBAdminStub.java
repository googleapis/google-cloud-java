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

package com.google.cloud.alloydb.v1alpha.stub;

import static com.google.cloud.alloydb.v1alpha.AlloyDBAdminClient.ListBackupsPagedResponse;
import static com.google.cloud.alloydb.v1alpha.AlloyDBAdminClient.ListClustersPagedResponse;
import static com.google.cloud.alloydb.v1alpha.AlloyDBAdminClient.ListDatabasesPagedResponse;
import static com.google.cloud.alloydb.v1alpha.AlloyDBAdminClient.ListInstancesPagedResponse;
import static com.google.cloud.alloydb.v1alpha.AlloyDBAdminClient.ListLocationsPagedResponse;
import static com.google.cloud.alloydb.v1alpha.AlloyDBAdminClient.ListSupportedDatabaseFlagsPagedResponse;
import static com.google.cloud.alloydb.v1alpha.AlloyDBAdminClient.ListUsersPagedResponse;

import com.google.api.HttpRule;
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
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.alloydb.v1alpha.Backup;
import com.google.cloud.alloydb.v1alpha.BatchCreateInstancesRequest;
import com.google.cloud.alloydb.v1alpha.BatchCreateInstancesResponse;
import com.google.cloud.alloydb.v1alpha.Cluster;
import com.google.cloud.alloydb.v1alpha.ConnectionInfo;
import com.google.cloud.alloydb.v1alpha.CreateBackupRequest;
import com.google.cloud.alloydb.v1alpha.CreateClusterRequest;
import com.google.cloud.alloydb.v1alpha.CreateDatabaseRequest;
import com.google.cloud.alloydb.v1alpha.CreateInstanceRequest;
import com.google.cloud.alloydb.v1alpha.CreateSecondaryClusterRequest;
import com.google.cloud.alloydb.v1alpha.CreateSecondaryInstanceRequest;
import com.google.cloud.alloydb.v1alpha.CreateUserRequest;
import com.google.cloud.alloydb.v1alpha.Database;
import com.google.cloud.alloydb.v1alpha.DeleteBackupRequest;
import com.google.cloud.alloydb.v1alpha.DeleteClusterRequest;
import com.google.cloud.alloydb.v1alpha.DeleteInstanceRequest;
import com.google.cloud.alloydb.v1alpha.DeleteUserRequest;
import com.google.cloud.alloydb.v1alpha.ExecuteSqlRequest;
import com.google.cloud.alloydb.v1alpha.ExecuteSqlResponse;
import com.google.cloud.alloydb.v1alpha.ExportClusterRequest;
import com.google.cloud.alloydb.v1alpha.ExportClusterResponse;
import com.google.cloud.alloydb.v1alpha.FailoverInstanceRequest;
import com.google.cloud.alloydb.v1alpha.GenerateClientCertificateRequest;
import com.google.cloud.alloydb.v1alpha.GenerateClientCertificateResponse;
import com.google.cloud.alloydb.v1alpha.GetBackupRequest;
import com.google.cloud.alloydb.v1alpha.GetClusterRequest;
import com.google.cloud.alloydb.v1alpha.GetConnectionInfoRequest;
import com.google.cloud.alloydb.v1alpha.GetInstanceRequest;
import com.google.cloud.alloydb.v1alpha.GetUserRequest;
import com.google.cloud.alloydb.v1alpha.ImportClusterRequest;
import com.google.cloud.alloydb.v1alpha.ImportClusterResponse;
import com.google.cloud.alloydb.v1alpha.InjectFaultRequest;
import com.google.cloud.alloydb.v1alpha.Instance;
import com.google.cloud.alloydb.v1alpha.ListBackupsRequest;
import com.google.cloud.alloydb.v1alpha.ListBackupsResponse;
import com.google.cloud.alloydb.v1alpha.ListClustersRequest;
import com.google.cloud.alloydb.v1alpha.ListClustersResponse;
import com.google.cloud.alloydb.v1alpha.ListDatabasesRequest;
import com.google.cloud.alloydb.v1alpha.ListDatabasesResponse;
import com.google.cloud.alloydb.v1alpha.ListInstancesRequest;
import com.google.cloud.alloydb.v1alpha.ListInstancesResponse;
import com.google.cloud.alloydb.v1alpha.ListSupportedDatabaseFlagsRequest;
import com.google.cloud.alloydb.v1alpha.ListSupportedDatabaseFlagsResponse;
import com.google.cloud.alloydb.v1alpha.ListUsersRequest;
import com.google.cloud.alloydb.v1alpha.ListUsersResponse;
import com.google.cloud.alloydb.v1alpha.OperationMetadata;
import com.google.cloud.alloydb.v1alpha.PromoteClusterRequest;
import com.google.cloud.alloydb.v1alpha.RestartInstanceRequest;
import com.google.cloud.alloydb.v1alpha.RestoreClusterRequest;
import com.google.cloud.alloydb.v1alpha.SwitchoverClusterRequest;
import com.google.cloud.alloydb.v1alpha.UpdateBackupRequest;
import com.google.cloud.alloydb.v1alpha.UpdateClusterRequest;
import com.google.cloud.alloydb.v1alpha.UpdateInstanceRequest;
import com.google.cloud.alloydb.v1alpha.UpdateUserRequest;
import com.google.cloud.alloydb.v1alpha.UpgradeClusterRequest;
import com.google.cloud.alloydb.v1alpha.UpgradeClusterResponse;
import com.google.cloud.alloydb.v1alpha.User;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.common.collect.ImmutableMap;
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
 * REST stub implementation for the AlloyDBAdmin service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class HttpJsonAlloyDBAdminStub extends AlloyDBAdminStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder()
          .add(UpgradeClusterResponse.getDescriptor())
          .add(Empty.getDescriptor())
          .add(BatchCreateInstancesResponse.getDescriptor())
          .add(OperationMetadata.getDescriptor())
          .add(Instance.getDescriptor())
          .add(ImportClusterResponse.getDescriptor())
          .add(ExportClusterResponse.getDescriptor())
          .add(Backup.getDescriptor())
          .add(Cluster.getDescriptor())
          .build();

  private static final ApiMethodDescriptor<ListClustersRequest, ListClustersResponse>
      listClustersMethodDescriptor =
          ApiMethodDescriptor.<ListClustersRequest, ListClustersResponse>newBuilder()
              .setFullMethodName("google.cloud.alloydb.v1alpha.AlloyDBAdmin/ListClusters")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListClustersRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{parent=projects/*/locations/*}/clusters",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListClustersRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListClustersRequest> serializer =
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
                  ProtoMessageResponseParser.<ListClustersResponse>newBuilder()
                      .setDefaultInstance(ListClustersResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetClusterRequest, Cluster> getClusterMethodDescriptor =
      ApiMethodDescriptor.<GetClusterRequest, Cluster>newBuilder()
          .setFullMethodName("google.cloud.alloydb.v1alpha.AlloyDBAdmin/GetCluster")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetClusterRequest>newBuilder()
                  .setPath(
                      "/v1alpha/{name=projects/*/locations/*/clusters/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetClusterRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetClusterRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "view", request.getViewValue());
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Cluster>newBuilder()
                  .setDefaultInstance(Cluster.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<CreateClusterRequest, Operation>
      createClusterMethodDescriptor =
          ApiMethodDescriptor.<CreateClusterRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.alloydb.v1alpha.AlloyDBAdmin/CreateCluster")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateClusterRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{parent=projects/*/locations/*}/clusters",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateClusterRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateClusterRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "clusterId", request.getClusterId());
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(
                                fields, "validateOnly", request.getValidateOnly());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("cluster", request.getCluster(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateClusterRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<UpdateClusterRequest, Operation>
      updateClusterMethodDescriptor =
          ApiMethodDescriptor.<UpdateClusterRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.alloydb.v1alpha.AlloyDBAdmin/UpdateCluster")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateClusterRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{cluster.name=projects/*/locations/*/clusters/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateClusterRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "cluster.name", request.getCluster().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateClusterRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "allowMissing", request.getAllowMissing());
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
                                  .toBody("cluster", request.getCluster(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateClusterRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<ExportClusterRequest, Operation>
      exportClusterMethodDescriptor =
          ApiMethodDescriptor.<ExportClusterRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.alloydb.v1alpha.AlloyDBAdmin/ExportCluster")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ExportClusterRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{name=projects/*/locations/*/clusters/*}:export",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ExportClusterRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ExportClusterRequest> serializer =
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
                  (ExportClusterRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<ImportClusterRequest, Operation>
      importClusterMethodDescriptor =
          ApiMethodDescriptor.<ImportClusterRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.alloydb.v1alpha.AlloyDBAdmin/ImportCluster")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ImportClusterRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{name=projects/*/locations/*/clusters/*}:import",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ImportClusterRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ImportClusterRequest> serializer =
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
                  (ImportClusterRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<UpgradeClusterRequest, Operation>
      upgradeClusterMethodDescriptor =
          ApiMethodDescriptor.<UpgradeClusterRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.alloydb.v1alpha.AlloyDBAdmin/UpgradeCluster")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpgradeClusterRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{name=projects/*/locations/*/clusters/*}:upgrade",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpgradeClusterRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpgradeClusterRequest> serializer =
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
                  (UpgradeClusterRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeleteClusterRequest, Operation>
      deleteClusterMethodDescriptor =
          ApiMethodDescriptor.<DeleteClusterRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.alloydb.v1alpha.AlloyDBAdmin/DeleteCluster")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteClusterRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{name=projects/*/locations/*/clusters/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteClusterRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteClusterRequest> serializer =
                                ProtoRestSerializer.create();
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
                  (DeleteClusterRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<PromoteClusterRequest, Operation>
      promoteClusterMethodDescriptor =
          ApiMethodDescriptor.<PromoteClusterRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.alloydb.v1alpha.AlloyDBAdmin/PromoteCluster")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<PromoteClusterRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{name=projects/*/locations/*/clusters/*}:promote",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<PromoteClusterRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<PromoteClusterRequest> serializer =
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
                  (PromoteClusterRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<SwitchoverClusterRequest, Operation>
      switchoverClusterMethodDescriptor =
          ApiMethodDescriptor.<SwitchoverClusterRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.alloydb.v1alpha.AlloyDBAdmin/SwitchoverCluster")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SwitchoverClusterRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{name=projects/*/locations/*/clusters/*}:switchover",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SwitchoverClusterRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SwitchoverClusterRequest> serializer =
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
                  (SwitchoverClusterRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<RestoreClusterRequest, Operation>
      restoreClusterMethodDescriptor =
          ApiMethodDescriptor.<RestoreClusterRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.alloydb.v1alpha.AlloyDBAdmin/RestoreCluster")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<RestoreClusterRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{parent=projects/*/locations/*}/clusters:restore",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<RestoreClusterRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<RestoreClusterRequest> serializer =
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
                  (RestoreClusterRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<CreateSecondaryClusterRequest, Operation>
      createSecondaryClusterMethodDescriptor =
          ApiMethodDescriptor.<CreateSecondaryClusterRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.alloydb.v1alpha.AlloyDBAdmin/CreateSecondaryCluster")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateSecondaryClusterRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{parent=projects/*/locations/*}/clusters:createsecondary",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateSecondaryClusterRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateSecondaryClusterRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "clusterId", request.getClusterId());
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(
                                fields, "validateOnly", request.getValidateOnly());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("cluster", request.getCluster(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateSecondaryClusterRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<ListInstancesRequest, ListInstancesResponse>
      listInstancesMethodDescriptor =
          ApiMethodDescriptor.<ListInstancesRequest, ListInstancesResponse>newBuilder()
              .setFullMethodName("google.cloud.alloydb.v1alpha.AlloyDBAdmin/ListInstances")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListInstancesRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{parent=projects/*/locations/*/clusters/*}/instances",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListInstancesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListInstancesRequest> serializer =
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
                  ProtoMessageResponseParser.<ListInstancesResponse>newBuilder()
                      .setDefaultInstance(ListInstancesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetInstanceRequest, Instance>
      getInstanceMethodDescriptor =
          ApiMethodDescriptor.<GetInstanceRequest, Instance>newBuilder()
              .setFullMethodName("google.cloud.alloydb.v1alpha.AlloyDBAdmin/GetInstance")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetInstanceRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{name=projects/*/locations/*/clusters/*/instances/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetInstanceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetInstanceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "view", request.getViewValue());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Instance>newBuilder()
                      .setDefaultInstance(Instance.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateInstanceRequest, Operation>
      createInstanceMethodDescriptor =
          ApiMethodDescriptor.<CreateInstanceRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.alloydb.v1alpha.AlloyDBAdmin/CreateInstance")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateInstanceRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{parent=projects/*/locations/*/clusters/*}/instances",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateInstanceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateInstanceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "instanceId", request.getInstanceId());
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(
                                fields, "validateOnly", request.getValidateOnly());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("instance", request.getInstance(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateInstanceRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<CreateSecondaryInstanceRequest, Operation>
      createSecondaryInstanceMethodDescriptor =
          ApiMethodDescriptor.<CreateSecondaryInstanceRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.alloydb.v1alpha.AlloyDBAdmin/CreateSecondaryInstance")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateSecondaryInstanceRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{parent=projects/*/locations/*/clusters/*}/instances:createsecondary",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateSecondaryInstanceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateSecondaryInstanceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "instanceId", request.getInstanceId());
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(
                                fields, "validateOnly", request.getValidateOnly());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("instance", request.getInstance(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateSecondaryInstanceRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<BatchCreateInstancesRequest, Operation>
      batchCreateInstancesMethodDescriptor =
          ApiMethodDescriptor.<BatchCreateInstancesRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.alloydb.v1alpha.AlloyDBAdmin/BatchCreateInstances")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BatchCreateInstancesRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{parent=projects/*/locations/*/clusters/*}/instances:batchCreate",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchCreateInstancesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchCreateInstancesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("requests", request.getRequests(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (BatchCreateInstancesRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<UpdateInstanceRequest, Operation>
      updateInstanceMethodDescriptor =
          ApiMethodDescriptor.<UpdateInstanceRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.alloydb.v1alpha.AlloyDBAdmin/UpdateInstance")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateInstanceRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{instance.name=projects/*/locations/*/clusters/*/instances/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateInstanceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "instance.name", request.getInstance().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateInstanceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "allowMissing", request.getAllowMissing());
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
                                  .toBody("instance", request.getInstance(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateInstanceRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeleteInstanceRequest, Operation>
      deleteInstanceMethodDescriptor =
          ApiMethodDescriptor.<DeleteInstanceRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.alloydb.v1alpha.AlloyDBAdmin/DeleteInstance")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteInstanceRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{name=projects/*/locations/*/clusters/*/instances/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteInstanceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteInstanceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "etag", request.getEtag());
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
                  (DeleteInstanceRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<FailoverInstanceRequest, Operation>
      failoverInstanceMethodDescriptor =
          ApiMethodDescriptor.<FailoverInstanceRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.alloydb.v1alpha.AlloyDBAdmin/FailoverInstance")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<FailoverInstanceRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{name=projects/*/locations/*/clusters/*/instances/*}:failover",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<FailoverInstanceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<FailoverInstanceRequest> serializer =
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
                  (FailoverInstanceRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<InjectFaultRequest, Operation>
      injectFaultMethodDescriptor =
          ApiMethodDescriptor.<InjectFaultRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.alloydb.v1alpha.AlloyDBAdmin/InjectFault")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<InjectFaultRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{name=projects/*/locations/*/clusters/*/instances/*}:injectFault",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<InjectFaultRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<InjectFaultRequest> serializer =
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
                  (InjectFaultRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<RestartInstanceRequest, Operation>
      restartInstanceMethodDescriptor =
          ApiMethodDescriptor.<RestartInstanceRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.alloydb.v1alpha.AlloyDBAdmin/RestartInstance")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<RestartInstanceRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{name=projects/*/locations/*/clusters/*/instances/*}:restart",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<RestartInstanceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<RestartInstanceRequest> serializer =
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
                  (RestartInstanceRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<ExecuteSqlRequest, ExecuteSqlResponse>
      executeSqlMethodDescriptor =
          ApiMethodDescriptor.<ExecuteSqlRequest, ExecuteSqlResponse>newBuilder()
              .setFullMethodName("google.cloud.alloydb.v1alpha.AlloyDBAdmin/ExecuteSql")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ExecuteSqlRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{instance=projects/*/locations/*/clusters/*/instances/*}:executeSql",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ExecuteSqlRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "instance", request.getInstance());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ExecuteSqlRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearInstance().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ExecuteSqlResponse>newBuilder()
                      .setDefaultInstance(ExecuteSqlResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListBackupsRequest, ListBackupsResponse>
      listBackupsMethodDescriptor =
          ApiMethodDescriptor.<ListBackupsRequest, ListBackupsResponse>newBuilder()
              .setFullMethodName("google.cloud.alloydb.v1alpha.AlloyDBAdmin/ListBackups")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListBackupsRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{parent=projects/*/locations/*}/backups",
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
          .setFullMethodName("google.cloud.alloydb.v1alpha.AlloyDBAdmin/GetBackup")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetBackupRequest>newBuilder()
                  .setPath(
                      "/v1alpha/{name=projects/*/locations/*/backups/*}",
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
              .setFullMethodName("google.cloud.alloydb.v1alpha.AlloyDBAdmin/CreateBackup")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateBackupRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{parent=projects/*/locations/*}/backups",
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
                            serializer.putQueryParam(
                                fields, "validateOnly", request.getValidateOnly());
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

  private static final ApiMethodDescriptor<UpdateBackupRequest, Operation>
      updateBackupMethodDescriptor =
          ApiMethodDescriptor.<UpdateBackupRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.alloydb.v1alpha.AlloyDBAdmin/UpdateBackup")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateBackupRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{backup.name=projects/*/locations/*/backups/*}",
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
                            serializer.putQueryParam(
                                fields, "allowMissing", request.getAllowMissing());
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
              .setFullMethodName("google.cloud.alloydb.v1alpha.AlloyDBAdmin/DeleteBackup")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteBackupRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{name=projects/*/locations/*/backups/*}",
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
                  (DeleteBackupRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<
          ListSupportedDatabaseFlagsRequest, ListSupportedDatabaseFlagsResponse>
      listSupportedDatabaseFlagsMethodDescriptor =
          ApiMethodDescriptor
              .<ListSupportedDatabaseFlagsRequest, ListSupportedDatabaseFlagsResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.alloydb.v1alpha.AlloyDBAdmin/ListSupportedDatabaseFlags")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListSupportedDatabaseFlagsRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{parent=projects/*/locations/*}/supportedDatabaseFlags",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListSupportedDatabaseFlagsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListSupportedDatabaseFlagsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "scope", request.getScopeValue());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListSupportedDatabaseFlagsResponse>newBuilder()
                      .setDefaultInstance(ListSupportedDatabaseFlagsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          GenerateClientCertificateRequest, GenerateClientCertificateResponse>
      generateClientCertificateMethodDescriptor =
          ApiMethodDescriptor
              .<GenerateClientCertificateRequest, GenerateClientCertificateResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.alloydb.v1alpha.AlloyDBAdmin/GenerateClientCertificate")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GenerateClientCertificateRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{parent=projects/*/locations/*/clusters/*}:generateClientCertificate",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GenerateClientCertificateRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GenerateClientCertificateRequest> serializer =
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
                  ProtoMessageResponseParser.<GenerateClientCertificateResponse>newBuilder()
                      .setDefaultInstance(GenerateClientCertificateResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetConnectionInfoRequest, ConnectionInfo>
      getConnectionInfoMethodDescriptor =
          ApiMethodDescriptor.<GetConnectionInfoRequest, ConnectionInfo>newBuilder()
              .setFullMethodName("google.cloud.alloydb.v1alpha.AlloyDBAdmin/GetConnectionInfo")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetConnectionInfoRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{parent=projects/*/locations/*/clusters/*/instances/*}/connectionInfo",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetConnectionInfoRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetConnectionInfoRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ConnectionInfo>newBuilder()
                      .setDefaultInstance(ConnectionInfo.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListUsersRequest, ListUsersResponse>
      listUsersMethodDescriptor =
          ApiMethodDescriptor.<ListUsersRequest, ListUsersResponse>newBuilder()
              .setFullMethodName("google.cloud.alloydb.v1alpha.AlloyDBAdmin/ListUsers")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListUsersRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{parent=projects/*/locations/*/clusters/*}/users",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListUsersRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListUsersRequest> serializer =
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
                  ProtoMessageResponseParser.<ListUsersResponse>newBuilder()
                      .setDefaultInstance(ListUsersResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetUserRequest, User> getUserMethodDescriptor =
      ApiMethodDescriptor.<GetUserRequest, User>newBuilder()
          .setFullMethodName("google.cloud.alloydb.v1alpha.AlloyDBAdmin/GetUser")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetUserRequest>newBuilder()
                  .setPath(
                      "/v1alpha/{name=projects/*/locations/*/clusters/*/users/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetUserRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetUserRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<User>newBuilder()
                  .setDefaultInstance(User.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<CreateUserRequest, User> createUserMethodDescriptor =
      ApiMethodDescriptor.<CreateUserRequest, User>newBuilder()
          .setFullMethodName("google.cloud.alloydb.v1alpha.AlloyDBAdmin/CreateUser")
          .setHttpMethod("POST")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<CreateUserRequest>newBuilder()
                  .setPath(
                      "/v1alpha/{parent=projects/*/locations/*/clusters/*}/users",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<CreateUserRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "parent", request.getParent());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<CreateUserRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "requestId", request.getRequestId());
                        serializer.putQueryParam(fields, "userId", request.getUserId());
                        serializer.putQueryParam(fields, "validateOnly", request.getValidateOnly());
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(
                      request ->
                          ProtoRestSerializer.create().toBody("user", request.getUser(), true))
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<User>newBuilder()
                  .setDefaultInstance(User.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<UpdateUserRequest, User> updateUserMethodDescriptor =
      ApiMethodDescriptor.<UpdateUserRequest, User>newBuilder()
          .setFullMethodName("google.cloud.alloydb.v1alpha.AlloyDBAdmin/UpdateUser")
          .setHttpMethod("PATCH")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<UpdateUserRequest>newBuilder()
                  .setPath(
                      "/v1alpha/{user.name=projects/*/locations/*/clusters/*/users/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<UpdateUserRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "user.name", request.getUser().getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<UpdateUserRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "allowMissing", request.getAllowMissing());
                        serializer.putQueryParam(fields, "requestId", request.getRequestId());
                        serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                        serializer.putQueryParam(fields, "validateOnly", request.getValidateOnly());
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(
                      request ->
                          ProtoRestSerializer.create().toBody("user", request.getUser(), true))
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<User>newBuilder()
                  .setDefaultInstance(User.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<DeleteUserRequest, Empty> deleteUserMethodDescriptor =
      ApiMethodDescriptor.<DeleteUserRequest, Empty>newBuilder()
          .setFullMethodName("google.cloud.alloydb.v1alpha.AlloyDBAdmin/DeleteUser")
          .setHttpMethod("DELETE")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<DeleteUserRequest>newBuilder()
                  .setPath(
                      "/v1alpha/{name=projects/*/locations/*/clusters/*/users/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<DeleteUserRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<DeleteUserRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "requestId", request.getRequestId());
                        serializer.putQueryParam(fields, "validateOnly", request.getValidateOnly());
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

  private static final ApiMethodDescriptor<ListDatabasesRequest, ListDatabasesResponse>
      listDatabasesMethodDescriptor =
          ApiMethodDescriptor.<ListDatabasesRequest, ListDatabasesResponse>newBuilder()
              .setFullMethodName("google.cloud.alloydb.v1alpha.AlloyDBAdmin/ListDatabases")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListDatabasesRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{parent=projects/*/locations/*/clusters/*}/databases",
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
                            serializer.putQueryParam(fields, "filter", request.getFilter());
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

  private static final ApiMethodDescriptor<CreateDatabaseRequest, Database>
      createDatabaseMethodDescriptor =
          ApiMethodDescriptor.<CreateDatabaseRequest, Database>newBuilder()
              .setFullMethodName("google.cloud.alloydb.v1alpha.AlloyDBAdmin/CreateDatabase")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateDatabaseRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{parent=projects/*/locations/*/clusters/*}/databases",
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

  private static final ApiMethodDescriptor<ListLocationsRequest, ListLocationsResponse>
      listLocationsMethodDescriptor =
          ApiMethodDescriptor.<ListLocationsRequest, ListLocationsResponse>newBuilder()
              .setFullMethodName("google.cloud.location.Locations/ListLocations")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListLocationsRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{name=projects/*}/locations",
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
                          "/v1alpha/{name=projects/*/locations/*}",
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

  private final UnaryCallable<ListClustersRequest, ListClustersResponse> listClustersCallable;
  private final UnaryCallable<ListClustersRequest, ListClustersPagedResponse>
      listClustersPagedCallable;
  private final UnaryCallable<GetClusterRequest, Cluster> getClusterCallable;
  private final UnaryCallable<CreateClusterRequest, Operation> createClusterCallable;
  private final OperationCallable<CreateClusterRequest, Cluster, OperationMetadata>
      createClusterOperationCallable;
  private final UnaryCallable<UpdateClusterRequest, Operation> updateClusterCallable;
  private final OperationCallable<UpdateClusterRequest, Cluster, OperationMetadata>
      updateClusterOperationCallable;
  private final UnaryCallable<ExportClusterRequest, Operation> exportClusterCallable;
  private final OperationCallable<ExportClusterRequest, ExportClusterResponse, OperationMetadata>
      exportClusterOperationCallable;
  private final UnaryCallable<ImportClusterRequest, Operation> importClusterCallable;
  private final OperationCallable<ImportClusterRequest, ImportClusterResponse, OperationMetadata>
      importClusterOperationCallable;
  private final UnaryCallable<UpgradeClusterRequest, Operation> upgradeClusterCallable;
  private final OperationCallable<UpgradeClusterRequest, UpgradeClusterResponse, OperationMetadata>
      upgradeClusterOperationCallable;
  private final UnaryCallable<DeleteClusterRequest, Operation> deleteClusterCallable;
  private final OperationCallable<DeleteClusterRequest, Empty, OperationMetadata>
      deleteClusterOperationCallable;
  private final UnaryCallable<PromoteClusterRequest, Operation> promoteClusterCallable;
  private final OperationCallable<PromoteClusterRequest, Cluster, OperationMetadata>
      promoteClusterOperationCallable;
  private final UnaryCallable<SwitchoverClusterRequest, Operation> switchoverClusterCallable;
  private final OperationCallable<SwitchoverClusterRequest, Cluster, OperationMetadata>
      switchoverClusterOperationCallable;
  private final UnaryCallable<RestoreClusterRequest, Operation> restoreClusterCallable;
  private final OperationCallable<RestoreClusterRequest, Cluster, OperationMetadata>
      restoreClusterOperationCallable;
  private final UnaryCallable<CreateSecondaryClusterRequest, Operation>
      createSecondaryClusterCallable;
  private final OperationCallable<CreateSecondaryClusterRequest, Cluster, OperationMetadata>
      createSecondaryClusterOperationCallable;
  private final UnaryCallable<ListInstancesRequest, ListInstancesResponse> listInstancesCallable;
  private final UnaryCallable<ListInstancesRequest, ListInstancesPagedResponse>
      listInstancesPagedCallable;
  private final UnaryCallable<GetInstanceRequest, Instance> getInstanceCallable;
  private final UnaryCallable<CreateInstanceRequest, Operation> createInstanceCallable;
  private final OperationCallable<CreateInstanceRequest, Instance, OperationMetadata>
      createInstanceOperationCallable;
  private final UnaryCallable<CreateSecondaryInstanceRequest, Operation>
      createSecondaryInstanceCallable;
  private final OperationCallable<CreateSecondaryInstanceRequest, Instance, OperationMetadata>
      createSecondaryInstanceOperationCallable;
  private final UnaryCallable<BatchCreateInstancesRequest, Operation> batchCreateInstancesCallable;
  private final OperationCallable<
          BatchCreateInstancesRequest, BatchCreateInstancesResponse, OperationMetadata>
      batchCreateInstancesOperationCallable;
  private final UnaryCallable<UpdateInstanceRequest, Operation> updateInstanceCallable;
  private final OperationCallable<UpdateInstanceRequest, Instance, OperationMetadata>
      updateInstanceOperationCallable;
  private final UnaryCallable<DeleteInstanceRequest, Operation> deleteInstanceCallable;
  private final OperationCallable<DeleteInstanceRequest, Empty, OperationMetadata>
      deleteInstanceOperationCallable;
  private final UnaryCallable<FailoverInstanceRequest, Operation> failoverInstanceCallable;
  private final OperationCallable<FailoverInstanceRequest, Instance, OperationMetadata>
      failoverInstanceOperationCallable;
  private final UnaryCallable<InjectFaultRequest, Operation> injectFaultCallable;
  private final OperationCallable<InjectFaultRequest, Instance, OperationMetadata>
      injectFaultOperationCallable;
  private final UnaryCallable<RestartInstanceRequest, Operation> restartInstanceCallable;
  private final OperationCallable<RestartInstanceRequest, Instance, OperationMetadata>
      restartInstanceOperationCallable;
  private final UnaryCallable<ExecuteSqlRequest, ExecuteSqlResponse> executeSqlCallable;
  private final UnaryCallable<ListBackupsRequest, ListBackupsResponse> listBackupsCallable;
  private final UnaryCallable<ListBackupsRequest, ListBackupsPagedResponse>
      listBackupsPagedCallable;
  private final UnaryCallable<GetBackupRequest, Backup> getBackupCallable;
  private final UnaryCallable<CreateBackupRequest, Operation> createBackupCallable;
  private final OperationCallable<CreateBackupRequest, Backup, OperationMetadata>
      createBackupOperationCallable;
  private final UnaryCallable<UpdateBackupRequest, Operation> updateBackupCallable;
  private final OperationCallable<UpdateBackupRequest, Backup, OperationMetadata>
      updateBackupOperationCallable;
  private final UnaryCallable<DeleteBackupRequest, Operation> deleteBackupCallable;
  private final OperationCallable<DeleteBackupRequest, Empty, OperationMetadata>
      deleteBackupOperationCallable;
  private final UnaryCallable<ListSupportedDatabaseFlagsRequest, ListSupportedDatabaseFlagsResponse>
      listSupportedDatabaseFlagsCallable;
  private final UnaryCallable<
          ListSupportedDatabaseFlagsRequest, ListSupportedDatabaseFlagsPagedResponse>
      listSupportedDatabaseFlagsPagedCallable;
  private final UnaryCallable<GenerateClientCertificateRequest, GenerateClientCertificateResponse>
      generateClientCertificateCallable;
  private final UnaryCallable<GetConnectionInfoRequest, ConnectionInfo> getConnectionInfoCallable;
  private final UnaryCallable<ListUsersRequest, ListUsersResponse> listUsersCallable;
  private final UnaryCallable<ListUsersRequest, ListUsersPagedResponse> listUsersPagedCallable;
  private final UnaryCallable<GetUserRequest, User> getUserCallable;
  private final UnaryCallable<CreateUserRequest, User> createUserCallable;
  private final UnaryCallable<UpdateUserRequest, User> updateUserCallable;
  private final UnaryCallable<DeleteUserRequest, Empty> deleteUserCallable;
  private final UnaryCallable<ListDatabasesRequest, ListDatabasesResponse> listDatabasesCallable;
  private final UnaryCallable<ListDatabasesRequest, ListDatabasesPagedResponse>
      listDatabasesPagedCallable;
  private final UnaryCallable<CreateDatabaseRequest, Database> createDatabaseCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<GetLocationRequest, Location> getLocationCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonAlloyDBAdminStub create(AlloyDBAdminStubSettings settings)
      throws IOException {
    return new HttpJsonAlloyDBAdminStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonAlloyDBAdminStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonAlloyDBAdminStub(
        AlloyDBAdminStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonAlloyDBAdminStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonAlloyDBAdminStub(
        AlloyDBAdminStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonAlloyDBAdminStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonAlloyDBAdminStub(AlloyDBAdminStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonAlloyDBAdminCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonAlloyDBAdminStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonAlloyDBAdminStub(
      AlloyDBAdminStubSettings settings,
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
                        .setPost("/v1alpha/{name=projects/*/locations/*/operations/*}:cancel")
                        .build())
                .put(
                    "google.longrunning.Operations.DeleteOperation",
                    HttpRule.newBuilder()
                        .setDelete("/v1alpha/{name=projects/*/locations/*/operations/*}")
                        .build())
                .put(
                    "google.longrunning.Operations.GetOperation",
                    HttpRule.newBuilder()
                        .setGet("/v1alpha/{name=projects/*/locations/*/operations/*}")
                        .build())
                .put(
                    "google.longrunning.Operations.ListOperations",
                    HttpRule.newBuilder()
                        .setGet("/v1alpha/{name=projects/*/locations/*}/operations")
                        .build())
                .build());

    HttpJsonCallSettings<ListClustersRequest, ListClustersResponse> listClustersTransportSettings =
        HttpJsonCallSettings.<ListClustersRequest, ListClustersResponse>newBuilder()
            .setMethodDescriptor(listClustersMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<GetClusterRequest, Cluster> getClusterTransportSettings =
        HttpJsonCallSettings.<GetClusterRequest, Cluster>newBuilder()
            .setMethodDescriptor(getClusterMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<CreateClusterRequest, Operation> createClusterTransportSettings =
        HttpJsonCallSettings.<CreateClusterRequest, Operation>newBuilder()
            .setMethodDescriptor(createClusterMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<UpdateClusterRequest, Operation> updateClusterTransportSettings =
        HttpJsonCallSettings.<UpdateClusterRequest, Operation>newBuilder()
            .setMethodDescriptor(updateClusterMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("cluster.name", String.valueOf(request.getCluster().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ExportClusterRequest, Operation> exportClusterTransportSettings =
        HttpJsonCallSettings.<ExportClusterRequest, Operation>newBuilder()
            .setMethodDescriptor(exportClusterMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ImportClusterRequest, Operation> importClusterTransportSettings =
        HttpJsonCallSettings.<ImportClusterRequest, Operation>newBuilder()
            .setMethodDescriptor(importClusterMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<UpgradeClusterRequest, Operation> upgradeClusterTransportSettings =
        HttpJsonCallSettings.<UpgradeClusterRequest, Operation>newBuilder()
            .setMethodDescriptor(upgradeClusterMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeleteClusterRequest, Operation> deleteClusterTransportSettings =
        HttpJsonCallSettings.<DeleteClusterRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteClusterMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<PromoteClusterRequest, Operation> promoteClusterTransportSettings =
        HttpJsonCallSettings.<PromoteClusterRequest, Operation>newBuilder()
            .setMethodDescriptor(promoteClusterMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<SwitchoverClusterRequest, Operation> switchoverClusterTransportSettings =
        HttpJsonCallSettings.<SwitchoverClusterRequest, Operation>newBuilder()
            .setMethodDescriptor(switchoverClusterMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<RestoreClusterRequest, Operation> restoreClusterTransportSettings =
        HttpJsonCallSettings.<RestoreClusterRequest, Operation>newBuilder()
            .setMethodDescriptor(restoreClusterMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<CreateSecondaryClusterRequest, Operation>
        createSecondaryClusterTransportSettings =
            HttpJsonCallSettings.<CreateSecondaryClusterRequest, Operation>newBuilder()
                .setMethodDescriptor(createSecondaryClusterMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ListInstancesRequest, ListInstancesResponse>
        listInstancesTransportSettings =
            HttpJsonCallSettings.<ListInstancesRequest, ListInstancesResponse>newBuilder()
                .setMethodDescriptor(listInstancesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetInstanceRequest, Instance> getInstanceTransportSettings =
        HttpJsonCallSettings.<GetInstanceRequest, Instance>newBuilder()
            .setMethodDescriptor(getInstanceMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<CreateInstanceRequest, Operation> createInstanceTransportSettings =
        HttpJsonCallSettings.<CreateInstanceRequest, Operation>newBuilder()
            .setMethodDescriptor(createInstanceMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<CreateSecondaryInstanceRequest, Operation>
        createSecondaryInstanceTransportSettings =
            HttpJsonCallSettings.<CreateSecondaryInstanceRequest, Operation>newBuilder()
                .setMethodDescriptor(createSecondaryInstanceMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<BatchCreateInstancesRequest, Operation>
        batchCreateInstancesTransportSettings =
            HttpJsonCallSettings.<BatchCreateInstancesRequest, Operation>newBuilder()
                .setMethodDescriptor(batchCreateInstancesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<UpdateInstanceRequest, Operation> updateInstanceTransportSettings =
        HttpJsonCallSettings.<UpdateInstanceRequest, Operation>newBuilder()
            .setMethodDescriptor(updateInstanceMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("instance.name", String.valueOf(request.getInstance().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeleteInstanceRequest, Operation> deleteInstanceTransportSettings =
        HttpJsonCallSettings.<DeleteInstanceRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteInstanceMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<FailoverInstanceRequest, Operation> failoverInstanceTransportSettings =
        HttpJsonCallSettings.<FailoverInstanceRequest, Operation>newBuilder()
            .setMethodDescriptor(failoverInstanceMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<InjectFaultRequest, Operation> injectFaultTransportSettings =
        HttpJsonCallSettings.<InjectFaultRequest, Operation>newBuilder()
            .setMethodDescriptor(injectFaultMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<RestartInstanceRequest, Operation> restartInstanceTransportSettings =
        HttpJsonCallSettings.<RestartInstanceRequest, Operation>newBuilder()
            .setMethodDescriptor(restartInstanceMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ExecuteSqlRequest, ExecuteSqlResponse> executeSqlTransportSettings =
        HttpJsonCallSettings.<ExecuteSqlRequest, ExecuteSqlResponse>newBuilder()
            .setMethodDescriptor(executeSqlMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("instance", String.valueOf(request.getInstance()));
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
    HttpJsonCallSettings<CreateBackupRequest, Operation> createBackupTransportSettings =
        HttpJsonCallSettings.<CreateBackupRequest, Operation>newBuilder()
            .setMethodDescriptor(createBackupMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
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
    HttpJsonCallSettings<ListSupportedDatabaseFlagsRequest, ListSupportedDatabaseFlagsResponse>
        listSupportedDatabaseFlagsTransportSettings =
            HttpJsonCallSettings
                .<ListSupportedDatabaseFlagsRequest, ListSupportedDatabaseFlagsResponse>newBuilder()
                .setMethodDescriptor(listSupportedDatabaseFlagsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GenerateClientCertificateRequest, GenerateClientCertificateResponse>
        generateClientCertificateTransportSettings =
            HttpJsonCallSettings
                .<GenerateClientCertificateRequest, GenerateClientCertificateResponse>newBuilder()
                .setMethodDescriptor(generateClientCertificateMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetConnectionInfoRequest, ConnectionInfo>
        getConnectionInfoTransportSettings =
            HttpJsonCallSettings.<GetConnectionInfoRequest, ConnectionInfo>newBuilder()
                .setMethodDescriptor(getConnectionInfoMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ListUsersRequest, ListUsersResponse> listUsersTransportSettings =
        HttpJsonCallSettings.<ListUsersRequest, ListUsersResponse>newBuilder()
            .setMethodDescriptor(listUsersMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<GetUserRequest, User> getUserTransportSettings =
        HttpJsonCallSettings.<GetUserRequest, User>newBuilder()
            .setMethodDescriptor(getUserMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<CreateUserRequest, User> createUserTransportSettings =
        HttpJsonCallSettings.<CreateUserRequest, User>newBuilder()
            .setMethodDescriptor(createUserMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<UpdateUserRequest, User> updateUserTransportSettings =
        HttpJsonCallSettings.<UpdateUserRequest, User>newBuilder()
            .setMethodDescriptor(updateUserMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("user.name", String.valueOf(request.getUser().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeleteUserRequest, Empty> deleteUserTransportSettings =
        HttpJsonCallSettings.<DeleteUserRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteUserMethodDescriptor)
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

    this.listClustersCallable =
        callableFactory.createUnaryCallable(
            listClustersTransportSettings, settings.listClustersSettings(), clientContext);
    this.listClustersPagedCallable =
        callableFactory.createPagedCallable(
            listClustersTransportSettings, settings.listClustersSettings(), clientContext);
    this.getClusterCallable =
        callableFactory.createUnaryCallable(
            getClusterTransportSettings, settings.getClusterSettings(), clientContext);
    this.createClusterCallable =
        callableFactory.createUnaryCallable(
            createClusterTransportSettings, settings.createClusterSettings(), clientContext);
    this.createClusterOperationCallable =
        callableFactory.createOperationCallable(
            createClusterTransportSettings,
            settings.createClusterOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.updateClusterCallable =
        callableFactory.createUnaryCallable(
            updateClusterTransportSettings, settings.updateClusterSettings(), clientContext);
    this.updateClusterOperationCallable =
        callableFactory.createOperationCallable(
            updateClusterTransportSettings,
            settings.updateClusterOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.exportClusterCallable =
        callableFactory.createUnaryCallable(
            exportClusterTransportSettings, settings.exportClusterSettings(), clientContext);
    this.exportClusterOperationCallable =
        callableFactory.createOperationCallable(
            exportClusterTransportSettings,
            settings.exportClusterOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.importClusterCallable =
        callableFactory.createUnaryCallable(
            importClusterTransportSettings, settings.importClusterSettings(), clientContext);
    this.importClusterOperationCallable =
        callableFactory.createOperationCallable(
            importClusterTransportSettings,
            settings.importClusterOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.upgradeClusterCallable =
        callableFactory.createUnaryCallable(
            upgradeClusterTransportSettings, settings.upgradeClusterSettings(), clientContext);
    this.upgradeClusterOperationCallable =
        callableFactory.createOperationCallable(
            upgradeClusterTransportSettings,
            settings.upgradeClusterOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.deleteClusterCallable =
        callableFactory.createUnaryCallable(
            deleteClusterTransportSettings, settings.deleteClusterSettings(), clientContext);
    this.deleteClusterOperationCallable =
        callableFactory.createOperationCallable(
            deleteClusterTransportSettings,
            settings.deleteClusterOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.promoteClusterCallable =
        callableFactory.createUnaryCallable(
            promoteClusterTransportSettings, settings.promoteClusterSettings(), clientContext);
    this.promoteClusterOperationCallable =
        callableFactory.createOperationCallable(
            promoteClusterTransportSettings,
            settings.promoteClusterOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.switchoverClusterCallable =
        callableFactory.createUnaryCallable(
            switchoverClusterTransportSettings,
            settings.switchoverClusterSettings(),
            clientContext);
    this.switchoverClusterOperationCallable =
        callableFactory.createOperationCallable(
            switchoverClusterTransportSettings,
            settings.switchoverClusterOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.restoreClusterCallable =
        callableFactory.createUnaryCallable(
            restoreClusterTransportSettings, settings.restoreClusterSettings(), clientContext);
    this.restoreClusterOperationCallable =
        callableFactory.createOperationCallable(
            restoreClusterTransportSettings,
            settings.restoreClusterOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.createSecondaryClusterCallable =
        callableFactory.createUnaryCallable(
            createSecondaryClusterTransportSettings,
            settings.createSecondaryClusterSettings(),
            clientContext);
    this.createSecondaryClusterOperationCallable =
        callableFactory.createOperationCallable(
            createSecondaryClusterTransportSettings,
            settings.createSecondaryClusterOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.listInstancesCallable =
        callableFactory.createUnaryCallable(
            listInstancesTransportSettings, settings.listInstancesSettings(), clientContext);
    this.listInstancesPagedCallable =
        callableFactory.createPagedCallable(
            listInstancesTransportSettings, settings.listInstancesSettings(), clientContext);
    this.getInstanceCallable =
        callableFactory.createUnaryCallable(
            getInstanceTransportSettings, settings.getInstanceSettings(), clientContext);
    this.createInstanceCallable =
        callableFactory.createUnaryCallable(
            createInstanceTransportSettings, settings.createInstanceSettings(), clientContext);
    this.createInstanceOperationCallable =
        callableFactory.createOperationCallable(
            createInstanceTransportSettings,
            settings.createInstanceOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.createSecondaryInstanceCallable =
        callableFactory.createUnaryCallable(
            createSecondaryInstanceTransportSettings,
            settings.createSecondaryInstanceSettings(),
            clientContext);
    this.createSecondaryInstanceOperationCallable =
        callableFactory.createOperationCallable(
            createSecondaryInstanceTransportSettings,
            settings.createSecondaryInstanceOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.batchCreateInstancesCallable =
        callableFactory.createUnaryCallable(
            batchCreateInstancesTransportSettings,
            settings.batchCreateInstancesSettings(),
            clientContext);
    this.batchCreateInstancesOperationCallable =
        callableFactory.createOperationCallable(
            batchCreateInstancesTransportSettings,
            settings.batchCreateInstancesOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.updateInstanceCallable =
        callableFactory.createUnaryCallable(
            updateInstanceTransportSettings, settings.updateInstanceSettings(), clientContext);
    this.updateInstanceOperationCallable =
        callableFactory.createOperationCallable(
            updateInstanceTransportSettings,
            settings.updateInstanceOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.deleteInstanceCallable =
        callableFactory.createUnaryCallable(
            deleteInstanceTransportSettings, settings.deleteInstanceSettings(), clientContext);
    this.deleteInstanceOperationCallable =
        callableFactory.createOperationCallable(
            deleteInstanceTransportSettings,
            settings.deleteInstanceOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.failoverInstanceCallable =
        callableFactory.createUnaryCallable(
            failoverInstanceTransportSettings, settings.failoverInstanceSettings(), clientContext);
    this.failoverInstanceOperationCallable =
        callableFactory.createOperationCallable(
            failoverInstanceTransportSettings,
            settings.failoverInstanceOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.injectFaultCallable =
        callableFactory.createUnaryCallable(
            injectFaultTransportSettings, settings.injectFaultSettings(), clientContext);
    this.injectFaultOperationCallable =
        callableFactory.createOperationCallable(
            injectFaultTransportSettings,
            settings.injectFaultOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.restartInstanceCallable =
        callableFactory.createUnaryCallable(
            restartInstanceTransportSettings, settings.restartInstanceSettings(), clientContext);
    this.restartInstanceOperationCallable =
        callableFactory.createOperationCallable(
            restartInstanceTransportSettings,
            settings.restartInstanceOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.executeSqlCallable =
        callableFactory.createUnaryCallable(
            executeSqlTransportSettings, settings.executeSqlSettings(), clientContext);
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
    this.listSupportedDatabaseFlagsCallable =
        callableFactory.createUnaryCallable(
            listSupportedDatabaseFlagsTransportSettings,
            settings.listSupportedDatabaseFlagsSettings(),
            clientContext);
    this.listSupportedDatabaseFlagsPagedCallable =
        callableFactory.createPagedCallable(
            listSupportedDatabaseFlagsTransportSettings,
            settings.listSupportedDatabaseFlagsSettings(),
            clientContext);
    this.generateClientCertificateCallable =
        callableFactory.createUnaryCallable(
            generateClientCertificateTransportSettings,
            settings.generateClientCertificateSettings(),
            clientContext);
    this.getConnectionInfoCallable =
        callableFactory.createUnaryCallable(
            getConnectionInfoTransportSettings,
            settings.getConnectionInfoSettings(),
            clientContext);
    this.listUsersCallable =
        callableFactory.createUnaryCallable(
            listUsersTransportSettings, settings.listUsersSettings(), clientContext);
    this.listUsersPagedCallable =
        callableFactory.createPagedCallable(
            listUsersTransportSettings, settings.listUsersSettings(), clientContext);
    this.getUserCallable =
        callableFactory.createUnaryCallable(
            getUserTransportSettings, settings.getUserSettings(), clientContext);
    this.createUserCallable =
        callableFactory.createUnaryCallable(
            createUserTransportSettings, settings.createUserSettings(), clientContext);
    this.updateUserCallable =
        callableFactory.createUnaryCallable(
            updateUserTransportSettings, settings.updateUserSettings(), clientContext);
    this.deleteUserCallable =
        callableFactory.createUnaryCallable(
            deleteUserTransportSettings, settings.deleteUserSettings(), clientContext);
    this.listDatabasesCallable =
        callableFactory.createUnaryCallable(
            listDatabasesTransportSettings, settings.listDatabasesSettings(), clientContext);
    this.listDatabasesPagedCallable =
        callableFactory.createPagedCallable(
            listDatabasesTransportSettings, settings.listDatabasesSettings(), clientContext);
    this.createDatabaseCallable =
        callableFactory.createUnaryCallable(
            createDatabaseTransportSettings, settings.createDatabaseSettings(), clientContext);
    this.listLocationsCallable =
        callableFactory.createUnaryCallable(
            listLocationsTransportSettings, settings.listLocationsSettings(), clientContext);
    this.listLocationsPagedCallable =
        callableFactory.createPagedCallable(
            listLocationsTransportSettings, settings.listLocationsSettings(), clientContext);
    this.getLocationCallable =
        callableFactory.createUnaryCallable(
            getLocationTransportSettings, settings.getLocationSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(listClustersMethodDescriptor);
    methodDescriptors.add(getClusterMethodDescriptor);
    methodDescriptors.add(createClusterMethodDescriptor);
    methodDescriptors.add(updateClusterMethodDescriptor);
    methodDescriptors.add(exportClusterMethodDescriptor);
    methodDescriptors.add(importClusterMethodDescriptor);
    methodDescriptors.add(upgradeClusterMethodDescriptor);
    methodDescriptors.add(deleteClusterMethodDescriptor);
    methodDescriptors.add(promoteClusterMethodDescriptor);
    methodDescriptors.add(switchoverClusterMethodDescriptor);
    methodDescriptors.add(restoreClusterMethodDescriptor);
    methodDescriptors.add(createSecondaryClusterMethodDescriptor);
    methodDescriptors.add(listInstancesMethodDescriptor);
    methodDescriptors.add(getInstanceMethodDescriptor);
    methodDescriptors.add(createInstanceMethodDescriptor);
    methodDescriptors.add(createSecondaryInstanceMethodDescriptor);
    methodDescriptors.add(batchCreateInstancesMethodDescriptor);
    methodDescriptors.add(updateInstanceMethodDescriptor);
    methodDescriptors.add(deleteInstanceMethodDescriptor);
    methodDescriptors.add(failoverInstanceMethodDescriptor);
    methodDescriptors.add(injectFaultMethodDescriptor);
    methodDescriptors.add(restartInstanceMethodDescriptor);
    methodDescriptors.add(executeSqlMethodDescriptor);
    methodDescriptors.add(listBackupsMethodDescriptor);
    methodDescriptors.add(getBackupMethodDescriptor);
    methodDescriptors.add(createBackupMethodDescriptor);
    methodDescriptors.add(updateBackupMethodDescriptor);
    methodDescriptors.add(deleteBackupMethodDescriptor);
    methodDescriptors.add(listSupportedDatabaseFlagsMethodDescriptor);
    methodDescriptors.add(generateClientCertificateMethodDescriptor);
    methodDescriptors.add(getConnectionInfoMethodDescriptor);
    methodDescriptors.add(listUsersMethodDescriptor);
    methodDescriptors.add(getUserMethodDescriptor);
    methodDescriptors.add(createUserMethodDescriptor);
    methodDescriptors.add(updateUserMethodDescriptor);
    methodDescriptors.add(deleteUserMethodDescriptor);
    methodDescriptors.add(listDatabasesMethodDescriptor);
    methodDescriptors.add(createDatabaseMethodDescriptor);
    methodDescriptors.add(listLocationsMethodDescriptor);
    methodDescriptors.add(getLocationMethodDescriptor);
    return methodDescriptors;
  }

  public HttpJsonOperationsStub getHttpJsonOperationsStub() {
    return httpJsonOperationsStub;
  }

  @Override
  public UnaryCallable<ListClustersRequest, ListClustersResponse> listClustersCallable() {
    return listClustersCallable;
  }

  @Override
  public UnaryCallable<ListClustersRequest, ListClustersPagedResponse> listClustersPagedCallable() {
    return listClustersPagedCallable;
  }

  @Override
  public UnaryCallable<GetClusterRequest, Cluster> getClusterCallable() {
    return getClusterCallable;
  }

  @Override
  public UnaryCallable<CreateClusterRequest, Operation> createClusterCallable() {
    return createClusterCallable;
  }

  @Override
  public OperationCallable<CreateClusterRequest, Cluster, OperationMetadata>
      createClusterOperationCallable() {
    return createClusterOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateClusterRequest, Operation> updateClusterCallable() {
    return updateClusterCallable;
  }

  @Override
  public OperationCallable<UpdateClusterRequest, Cluster, OperationMetadata>
      updateClusterOperationCallable() {
    return updateClusterOperationCallable;
  }

  @Override
  public UnaryCallable<ExportClusterRequest, Operation> exportClusterCallable() {
    return exportClusterCallable;
  }

  @Override
  public OperationCallable<ExportClusterRequest, ExportClusterResponse, OperationMetadata>
      exportClusterOperationCallable() {
    return exportClusterOperationCallable;
  }

  @Override
  public UnaryCallable<ImportClusterRequest, Operation> importClusterCallable() {
    return importClusterCallable;
  }

  @Override
  public OperationCallable<ImportClusterRequest, ImportClusterResponse, OperationMetadata>
      importClusterOperationCallable() {
    return importClusterOperationCallable;
  }

  @Override
  public UnaryCallable<UpgradeClusterRequest, Operation> upgradeClusterCallable() {
    return upgradeClusterCallable;
  }

  @Override
  public OperationCallable<UpgradeClusterRequest, UpgradeClusterResponse, OperationMetadata>
      upgradeClusterOperationCallable() {
    return upgradeClusterOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteClusterRequest, Operation> deleteClusterCallable() {
    return deleteClusterCallable;
  }

  @Override
  public OperationCallable<DeleteClusterRequest, Empty, OperationMetadata>
      deleteClusterOperationCallable() {
    return deleteClusterOperationCallable;
  }

  @Override
  public UnaryCallable<PromoteClusterRequest, Operation> promoteClusterCallable() {
    return promoteClusterCallable;
  }

  @Override
  public OperationCallable<PromoteClusterRequest, Cluster, OperationMetadata>
      promoteClusterOperationCallable() {
    return promoteClusterOperationCallable;
  }

  @Override
  public UnaryCallable<SwitchoverClusterRequest, Operation> switchoverClusterCallable() {
    return switchoverClusterCallable;
  }

  @Override
  public OperationCallable<SwitchoverClusterRequest, Cluster, OperationMetadata>
      switchoverClusterOperationCallable() {
    return switchoverClusterOperationCallable;
  }

  @Override
  public UnaryCallable<RestoreClusterRequest, Operation> restoreClusterCallable() {
    return restoreClusterCallable;
  }

  @Override
  public OperationCallable<RestoreClusterRequest, Cluster, OperationMetadata>
      restoreClusterOperationCallable() {
    return restoreClusterOperationCallable;
  }

  @Override
  public UnaryCallable<CreateSecondaryClusterRequest, Operation> createSecondaryClusterCallable() {
    return createSecondaryClusterCallable;
  }

  @Override
  public OperationCallable<CreateSecondaryClusterRequest, Cluster, OperationMetadata>
      createSecondaryClusterOperationCallable() {
    return createSecondaryClusterOperationCallable;
  }

  @Override
  public UnaryCallable<ListInstancesRequest, ListInstancesResponse> listInstancesCallable() {
    return listInstancesCallable;
  }

  @Override
  public UnaryCallable<ListInstancesRequest, ListInstancesPagedResponse>
      listInstancesPagedCallable() {
    return listInstancesPagedCallable;
  }

  @Override
  public UnaryCallable<GetInstanceRequest, Instance> getInstanceCallable() {
    return getInstanceCallable;
  }

  @Override
  public UnaryCallable<CreateInstanceRequest, Operation> createInstanceCallable() {
    return createInstanceCallable;
  }

  @Override
  public OperationCallable<CreateInstanceRequest, Instance, OperationMetadata>
      createInstanceOperationCallable() {
    return createInstanceOperationCallable;
  }

  @Override
  public UnaryCallable<CreateSecondaryInstanceRequest, Operation>
      createSecondaryInstanceCallable() {
    return createSecondaryInstanceCallable;
  }

  @Override
  public OperationCallable<CreateSecondaryInstanceRequest, Instance, OperationMetadata>
      createSecondaryInstanceOperationCallable() {
    return createSecondaryInstanceOperationCallable;
  }

  @Override
  public UnaryCallable<BatchCreateInstancesRequest, Operation> batchCreateInstancesCallable() {
    return batchCreateInstancesCallable;
  }

  @Override
  public OperationCallable<
          BatchCreateInstancesRequest, BatchCreateInstancesResponse, OperationMetadata>
      batchCreateInstancesOperationCallable() {
    return batchCreateInstancesOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateInstanceRequest, Operation> updateInstanceCallable() {
    return updateInstanceCallable;
  }

  @Override
  public OperationCallable<UpdateInstanceRequest, Instance, OperationMetadata>
      updateInstanceOperationCallable() {
    return updateInstanceOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteInstanceRequest, Operation> deleteInstanceCallable() {
    return deleteInstanceCallable;
  }

  @Override
  public OperationCallable<DeleteInstanceRequest, Empty, OperationMetadata>
      deleteInstanceOperationCallable() {
    return deleteInstanceOperationCallable;
  }

  @Override
  public UnaryCallable<FailoverInstanceRequest, Operation> failoverInstanceCallable() {
    return failoverInstanceCallable;
  }

  @Override
  public OperationCallable<FailoverInstanceRequest, Instance, OperationMetadata>
      failoverInstanceOperationCallable() {
    return failoverInstanceOperationCallable;
  }

  @Override
  public UnaryCallable<InjectFaultRequest, Operation> injectFaultCallable() {
    return injectFaultCallable;
  }

  @Override
  public OperationCallable<InjectFaultRequest, Instance, OperationMetadata>
      injectFaultOperationCallable() {
    return injectFaultOperationCallable;
  }

  @Override
  public UnaryCallable<RestartInstanceRequest, Operation> restartInstanceCallable() {
    return restartInstanceCallable;
  }

  @Override
  public OperationCallable<RestartInstanceRequest, Instance, OperationMetadata>
      restartInstanceOperationCallable() {
    return restartInstanceOperationCallable;
  }

  @Override
  public UnaryCallable<ExecuteSqlRequest, ExecuteSqlResponse> executeSqlCallable() {
    return executeSqlCallable;
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
  public UnaryCallable<ListSupportedDatabaseFlagsRequest, ListSupportedDatabaseFlagsResponse>
      listSupportedDatabaseFlagsCallable() {
    return listSupportedDatabaseFlagsCallable;
  }

  @Override
  public UnaryCallable<ListSupportedDatabaseFlagsRequest, ListSupportedDatabaseFlagsPagedResponse>
      listSupportedDatabaseFlagsPagedCallable() {
    return listSupportedDatabaseFlagsPagedCallable;
  }

  @Override
  public UnaryCallable<GenerateClientCertificateRequest, GenerateClientCertificateResponse>
      generateClientCertificateCallable() {
    return generateClientCertificateCallable;
  }

  @Override
  public UnaryCallable<GetConnectionInfoRequest, ConnectionInfo> getConnectionInfoCallable() {
    return getConnectionInfoCallable;
  }

  @Override
  public UnaryCallable<ListUsersRequest, ListUsersResponse> listUsersCallable() {
    return listUsersCallable;
  }

  @Override
  public UnaryCallable<ListUsersRequest, ListUsersPagedResponse> listUsersPagedCallable() {
    return listUsersPagedCallable;
  }

  @Override
  public UnaryCallable<GetUserRequest, User> getUserCallable() {
    return getUserCallable;
  }

  @Override
  public UnaryCallable<CreateUserRequest, User> createUserCallable() {
    return createUserCallable;
  }

  @Override
  public UnaryCallable<UpdateUserRequest, User> updateUserCallable() {
    return updateUserCallable;
  }

  @Override
  public UnaryCallable<DeleteUserRequest, Empty> deleteUserCallable() {
    return deleteUserCallable;
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
  public UnaryCallable<CreateDatabaseRequest, Database> createDatabaseCallable() {
    return createDatabaseCallable;
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
