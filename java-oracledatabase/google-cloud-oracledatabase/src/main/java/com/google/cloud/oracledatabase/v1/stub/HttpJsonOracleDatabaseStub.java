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

package com.google.cloud.oracledatabase.v1.stub;

import static com.google.cloud.oracledatabase.v1.OracleDatabaseClient.ListAutonomousDatabaseBackupsPagedResponse;
import static com.google.cloud.oracledatabase.v1.OracleDatabaseClient.ListAutonomousDatabaseCharacterSetsPagedResponse;
import static com.google.cloud.oracledatabase.v1.OracleDatabaseClient.ListAutonomousDatabasesPagedResponse;
import static com.google.cloud.oracledatabase.v1.OracleDatabaseClient.ListAutonomousDbVersionsPagedResponse;
import static com.google.cloud.oracledatabase.v1.OracleDatabaseClient.ListCloudExadataInfrastructuresPagedResponse;
import static com.google.cloud.oracledatabase.v1.OracleDatabaseClient.ListCloudVmClustersPagedResponse;
import static com.google.cloud.oracledatabase.v1.OracleDatabaseClient.ListDatabaseCharacterSetsPagedResponse;
import static com.google.cloud.oracledatabase.v1.OracleDatabaseClient.ListDatabasesPagedResponse;
import static com.google.cloud.oracledatabase.v1.OracleDatabaseClient.ListDbNodesPagedResponse;
import static com.google.cloud.oracledatabase.v1.OracleDatabaseClient.ListDbServersPagedResponse;
import static com.google.cloud.oracledatabase.v1.OracleDatabaseClient.ListDbSystemInitialStorageSizesPagedResponse;
import static com.google.cloud.oracledatabase.v1.OracleDatabaseClient.ListDbSystemShapesPagedResponse;
import static com.google.cloud.oracledatabase.v1.OracleDatabaseClient.ListDbSystemsPagedResponse;
import static com.google.cloud.oracledatabase.v1.OracleDatabaseClient.ListDbVersionsPagedResponse;
import static com.google.cloud.oracledatabase.v1.OracleDatabaseClient.ListEntitlementsPagedResponse;
import static com.google.cloud.oracledatabase.v1.OracleDatabaseClient.ListExadbVmClustersPagedResponse;
import static com.google.cloud.oracledatabase.v1.OracleDatabaseClient.ListExascaleDbStorageVaultsPagedResponse;
import static com.google.cloud.oracledatabase.v1.OracleDatabaseClient.ListGiVersionsPagedResponse;
import static com.google.cloud.oracledatabase.v1.OracleDatabaseClient.ListLocationsPagedResponse;
import static com.google.cloud.oracledatabase.v1.OracleDatabaseClient.ListMinorVersionsPagedResponse;
import static com.google.cloud.oracledatabase.v1.OracleDatabaseClient.ListOdbNetworksPagedResponse;
import static com.google.cloud.oracledatabase.v1.OracleDatabaseClient.ListOdbSubnetsPagedResponse;
import static com.google.cloud.oracledatabase.v1.OracleDatabaseClient.ListPluggableDatabasesPagedResponse;

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
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.cloud.oracledatabase.v1.AutonomousDatabase;
import com.google.cloud.oracledatabase.v1.CloudExadataInfrastructure;
import com.google.cloud.oracledatabase.v1.CloudVmCluster;
import com.google.cloud.oracledatabase.v1.CreateAutonomousDatabaseRequest;
import com.google.cloud.oracledatabase.v1.CreateCloudExadataInfrastructureRequest;
import com.google.cloud.oracledatabase.v1.CreateCloudVmClusterRequest;
import com.google.cloud.oracledatabase.v1.CreateDbSystemRequest;
import com.google.cloud.oracledatabase.v1.CreateExadbVmClusterRequest;
import com.google.cloud.oracledatabase.v1.CreateExascaleDbStorageVaultRequest;
import com.google.cloud.oracledatabase.v1.CreateOdbNetworkRequest;
import com.google.cloud.oracledatabase.v1.CreateOdbSubnetRequest;
import com.google.cloud.oracledatabase.v1.Database;
import com.google.cloud.oracledatabase.v1.DbSystem;
import com.google.cloud.oracledatabase.v1.DeleteAutonomousDatabaseRequest;
import com.google.cloud.oracledatabase.v1.DeleteCloudExadataInfrastructureRequest;
import com.google.cloud.oracledatabase.v1.DeleteCloudVmClusterRequest;
import com.google.cloud.oracledatabase.v1.DeleteDbSystemRequest;
import com.google.cloud.oracledatabase.v1.DeleteExadbVmClusterRequest;
import com.google.cloud.oracledatabase.v1.DeleteExascaleDbStorageVaultRequest;
import com.google.cloud.oracledatabase.v1.DeleteOdbNetworkRequest;
import com.google.cloud.oracledatabase.v1.DeleteOdbSubnetRequest;
import com.google.cloud.oracledatabase.v1.ExadbVmCluster;
import com.google.cloud.oracledatabase.v1.ExascaleDbStorageVault;
import com.google.cloud.oracledatabase.v1.FailoverAutonomousDatabaseRequest;
import com.google.cloud.oracledatabase.v1.GenerateAutonomousDatabaseWalletRequest;
import com.google.cloud.oracledatabase.v1.GenerateAutonomousDatabaseWalletResponse;
import com.google.cloud.oracledatabase.v1.GetAutonomousDatabaseRequest;
import com.google.cloud.oracledatabase.v1.GetCloudExadataInfrastructureRequest;
import com.google.cloud.oracledatabase.v1.GetCloudVmClusterRequest;
import com.google.cloud.oracledatabase.v1.GetDatabaseRequest;
import com.google.cloud.oracledatabase.v1.GetDbSystemRequest;
import com.google.cloud.oracledatabase.v1.GetExadbVmClusterRequest;
import com.google.cloud.oracledatabase.v1.GetExascaleDbStorageVaultRequest;
import com.google.cloud.oracledatabase.v1.GetOdbNetworkRequest;
import com.google.cloud.oracledatabase.v1.GetOdbSubnetRequest;
import com.google.cloud.oracledatabase.v1.GetPluggableDatabaseRequest;
import com.google.cloud.oracledatabase.v1.ListAutonomousDatabaseBackupsRequest;
import com.google.cloud.oracledatabase.v1.ListAutonomousDatabaseBackupsResponse;
import com.google.cloud.oracledatabase.v1.ListAutonomousDatabaseCharacterSetsRequest;
import com.google.cloud.oracledatabase.v1.ListAutonomousDatabaseCharacterSetsResponse;
import com.google.cloud.oracledatabase.v1.ListAutonomousDatabasesRequest;
import com.google.cloud.oracledatabase.v1.ListAutonomousDatabasesResponse;
import com.google.cloud.oracledatabase.v1.ListAutonomousDbVersionsRequest;
import com.google.cloud.oracledatabase.v1.ListAutonomousDbVersionsResponse;
import com.google.cloud.oracledatabase.v1.ListCloudExadataInfrastructuresRequest;
import com.google.cloud.oracledatabase.v1.ListCloudExadataInfrastructuresResponse;
import com.google.cloud.oracledatabase.v1.ListCloudVmClustersRequest;
import com.google.cloud.oracledatabase.v1.ListCloudVmClustersResponse;
import com.google.cloud.oracledatabase.v1.ListDatabaseCharacterSetsRequest;
import com.google.cloud.oracledatabase.v1.ListDatabaseCharacterSetsResponse;
import com.google.cloud.oracledatabase.v1.ListDatabasesRequest;
import com.google.cloud.oracledatabase.v1.ListDatabasesResponse;
import com.google.cloud.oracledatabase.v1.ListDbNodesRequest;
import com.google.cloud.oracledatabase.v1.ListDbNodesResponse;
import com.google.cloud.oracledatabase.v1.ListDbServersRequest;
import com.google.cloud.oracledatabase.v1.ListDbServersResponse;
import com.google.cloud.oracledatabase.v1.ListDbSystemInitialStorageSizesRequest;
import com.google.cloud.oracledatabase.v1.ListDbSystemInitialStorageSizesResponse;
import com.google.cloud.oracledatabase.v1.ListDbSystemShapesRequest;
import com.google.cloud.oracledatabase.v1.ListDbSystemShapesResponse;
import com.google.cloud.oracledatabase.v1.ListDbSystemsRequest;
import com.google.cloud.oracledatabase.v1.ListDbSystemsResponse;
import com.google.cloud.oracledatabase.v1.ListDbVersionsRequest;
import com.google.cloud.oracledatabase.v1.ListDbVersionsResponse;
import com.google.cloud.oracledatabase.v1.ListEntitlementsRequest;
import com.google.cloud.oracledatabase.v1.ListEntitlementsResponse;
import com.google.cloud.oracledatabase.v1.ListExadbVmClustersRequest;
import com.google.cloud.oracledatabase.v1.ListExadbVmClustersResponse;
import com.google.cloud.oracledatabase.v1.ListExascaleDbStorageVaultsRequest;
import com.google.cloud.oracledatabase.v1.ListExascaleDbStorageVaultsResponse;
import com.google.cloud.oracledatabase.v1.ListGiVersionsRequest;
import com.google.cloud.oracledatabase.v1.ListGiVersionsResponse;
import com.google.cloud.oracledatabase.v1.ListMinorVersionsRequest;
import com.google.cloud.oracledatabase.v1.ListMinorVersionsResponse;
import com.google.cloud.oracledatabase.v1.ListOdbNetworksRequest;
import com.google.cloud.oracledatabase.v1.ListOdbNetworksResponse;
import com.google.cloud.oracledatabase.v1.ListOdbSubnetsRequest;
import com.google.cloud.oracledatabase.v1.ListOdbSubnetsResponse;
import com.google.cloud.oracledatabase.v1.ListPluggableDatabasesRequest;
import com.google.cloud.oracledatabase.v1.ListPluggableDatabasesResponse;
import com.google.cloud.oracledatabase.v1.OdbNetwork;
import com.google.cloud.oracledatabase.v1.OdbSubnet;
import com.google.cloud.oracledatabase.v1.OperationMetadata;
import com.google.cloud.oracledatabase.v1.PluggableDatabase;
import com.google.cloud.oracledatabase.v1.RemoveVirtualMachineExadbVmClusterRequest;
import com.google.cloud.oracledatabase.v1.RestartAutonomousDatabaseRequest;
import com.google.cloud.oracledatabase.v1.RestoreAutonomousDatabaseRequest;
import com.google.cloud.oracledatabase.v1.StartAutonomousDatabaseRequest;
import com.google.cloud.oracledatabase.v1.StopAutonomousDatabaseRequest;
import com.google.cloud.oracledatabase.v1.SwitchoverAutonomousDatabaseRequest;
import com.google.cloud.oracledatabase.v1.UpdateAutonomousDatabaseRequest;
import com.google.cloud.oracledatabase.v1.UpdateExadbVmClusterRequest;
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
 * REST stub implementation for the OracleDatabase service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class HttpJsonOracleDatabaseStub extends OracleDatabaseStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder()
          .add(CloudVmCluster.getDescriptor())
          .add(Empty.getDescriptor())
          .add(OdbNetwork.getDescriptor())
          .add(AutonomousDatabase.getDescriptor())
          .add(ExadbVmCluster.getDescriptor())
          .add(CloudExadataInfrastructure.getDescriptor())
          .add(ExascaleDbStorageVault.getDescriptor())
          .add(OperationMetadata.getDescriptor())
          .add(OdbSubnet.getDescriptor())
          .add(DbSystem.getDescriptor())
          .build();

  private static final ApiMethodDescriptor<
          ListCloudExadataInfrastructuresRequest, ListCloudExadataInfrastructuresResponse>
      listCloudExadataInfrastructuresMethodDescriptor =
          ApiMethodDescriptor
              .<ListCloudExadataInfrastructuresRequest, ListCloudExadataInfrastructuresResponse>
                  newBuilder()
              .setFullMethodName(
                  "google.cloud.oracledatabase.v1.OracleDatabase/ListCloudExadataInfrastructures")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListCloudExadataInfrastructuresRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/cloudExadataInfrastructures",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListCloudExadataInfrastructuresRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListCloudExadataInfrastructuresRequest> serializer =
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
                  ProtoMessageResponseParser.<ListCloudExadataInfrastructuresResponse>newBuilder()
                      .setDefaultInstance(
                          ListCloudExadataInfrastructuresResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          GetCloudExadataInfrastructureRequest, CloudExadataInfrastructure>
      getCloudExadataInfrastructureMethodDescriptor =
          ApiMethodDescriptor
              .<GetCloudExadataInfrastructureRequest, CloudExadataInfrastructure>newBuilder()
              .setFullMethodName(
                  "google.cloud.oracledatabase.v1.OracleDatabase/GetCloudExadataInfrastructure")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetCloudExadataInfrastructureRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/cloudExadataInfrastructures/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetCloudExadataInfrastructureRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetCloudExadataInfrastructureRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<CloudExadataInfrastructure>newBuilder()
                      .setDefaultInstance(CloudExadataInfrastructure.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateCloudExadataInfrastructureRequest, Operation>
      createCloudExadataInfrastructureMethodDescriptor =
          ApiMethodDescriptor.<CreateCloudExadataInfrastructureRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.oracledatabase.v1.OracleDatabase/CreateCloudExadataInfrastructure")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateCloudExadataInfrastructureRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/cloudExadataInfrastructures",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateCloudExadataInfrastructureRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateCloudExadataInfrastructureRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields,
                                "cloudExadataInfrastructureId",
                                request.getCloudExadataInfrastructureId());
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "cloudExadataInfrastructure",
                                      request.getCloudExadataInfrastructure(),
                                      true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateCloudExadataInfrastructureRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeleteCloudExadataInfrastructureRequest, Operation>
      deleteCloudExadataInfrastructureMethodDescriptor =
          ApiMethodDescriptor.<DeleteCloudExadataInfrastructureRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.oracledatabase.v1.OracleDatabase/DeleteCloudExadataInfrastructure")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteCloudExadataInfrastructureRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/cloudExadataInfrastructures/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteCloudExadataInfrastructureRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteCloudExadataInfrastructureRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "force", request.getForce());
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
                  (DeleteCloudExadataInfrastructureRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<ListCloudVmClustersRequest, ListCloudVmClustersResponse>
      listCloudVmClustersMethodDescriptor =
          ApiMethodDescriptor.<ListCloudVmClustersRequest, ListCloudVmClustersResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.oracledatabase.v1.OracleDatabase/ListCloudVmClusters")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListCloudVmClustersRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/cloudVmClusters",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListCloudVmClustersRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListCloudVmClustersRequest> serializer =
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
                  ProtoMessageResponseParser.<ListCloudVmClustersResponse>newBuilder()
                      .setDefaultInstance(ListCloudVmClustersResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetCloudVmClusterRequest, CloudVmCluster>
      getCloudVmClusterMethodDescriptor =
          ApiMethodDescriptor.<GetCloudVmClusterRequest, CloudVmCluster>newBuilder()
              .setFullMethodName("google.cloud.oracledatabase.v1.OracleDatabase/GetCloudVmCluster")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetCloudVmClusterRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/cloudVmClusters/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetCloudVmClusterRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetCloudVmClusterRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<CloudVmCluster>newBuilder()
                      .setDefaultInstance(CloudVmCluster.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateCloudVmClusterRequest, Operation>
      createCloudVmClusterMethodDescriptor =
          ApiMethodDescriptor.<CreateCloudVmClusterRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.oracledatabase.v1.OracleDatabase/CreateCloudVmCluster")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateCloudVmClusterRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/cloudVmClusters",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateCloudVmClusterRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateCloudVmClusterRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "cloudVmClusterId", request.getCloudVmClusterId());
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("cloudVmCluster", request.getCloudVmCluster(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateCloudVmClusterRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeleteCloudVmClusterRequest, Operation>
      deleteCloudVmClusterMethodDescriptor =
          ApiMethodDescriptor.<DeleteCloudVmClusterRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.oracledatabase.v1.OracleDatabase/DeleteCloudVmCluster")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteCloudVmClusterRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/cloudVmClusters/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteCloudVmClusterRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteCloudVmClusterRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "force", request.getForce());
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
                  (DeleteCloudVmClusterRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<ListEntitlementsRequest, ListEntitlementsResponse>
      listEntitlementsMethodDescriptor =
          ApiMethodDescriptor.<ListEntitlementsRequest, ListEntitlementsResponse>newBuilder()
              .setFullMethodName("google.cloud.oracledatabase.v1.OracleDatabase/ListEntitlements")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListEntitlementsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/entitlements",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListEntitlementsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListEntitlementsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListEntitlementsResponse>newBuilder()
                      .setDefaultInstance(ListEntitlementsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListDbServersRequest, ListDbServersResponse>
      listDbServersMethodDescriptor =
          ApiMethodDescriptor.<ListDbServersRequest, ListDbServersResponse>newBuilder()
              .setFullMethodName("google.cloud.oracledatabase.v1.OracleDatabase/ListDbServers")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListDbServersRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/cloudExadataInfrastructures/*}/dbServers",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListDbServersRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListDbServersRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListDbServersResponse>newBuilder()
                      .setDefaultInstance(ListDbServersResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListDbNodesRequest, ListDbNodesResponse>
      listDbNodesMethodDescriptor =
          ApiMethodDescriptor.<ListDbNodesRequest, ListDbNodesResponse>newBuilder()
              .setFullMethodName("google.cloud.oracledatabase.v1.OracleDatabase/ListDbNodes")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListDbNodesRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/cloudVmClusters/*}/dbNodes",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListDbNodesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/{parent=projects/*/locations/*/exadbVmClusters/*}/dbNodes")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListDbNodesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListDbNodesResponse>newBuilder()
                      .setDefaultInstance(ListDbNodesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListGiVersionsRequest, ListGiVersionsResponse>
      listGiVersionsMethodDescriptor =
          ApiMethodDescriptor.<ListGiVersionsRequest, ListGiVersionsResponse>newBuilder()
              .setFullMethodName("google.cloud.oracledatabase.v1.OracleDatabase/ListGiVersions")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListGiVersionsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/giVersions",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListGiVersionsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListGiVersionsRequest> serializer =
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
                  ProtoMessageResponseParser.<ListGiVersionsResponse>newBuilder()
                      .setDefaultInstance(ListGiVersionsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListMinorVersionsRequest, ListMinorVersionsResponse>
      listMinorVersionsMethodDescriptor =
          ApiMethodDescriptor.<ListMinorVersionsRequest, ListMinorVersionsResponse>newBuilder()
              .setFullMethodName("google.cloud.oracledatabase.v1.OracleDatabase/ListMinorVersions")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListMinorVersionsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/giVersions/*}/minorVersions",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListMinorVersionsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListMinorVersionsRequest> serializer =
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
                  ProtoMessageResponseParser.<ListMinorVersionsResponse>newBuilder()
                      .setDefaultInstance(ListMinorVersionsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListDbSystemShapesRequest, ListDbSystemShapesResponse>
      listDbSystemShapesMethodDescriptor =
          ApiMethodDescriptor.<ListDbSystemShapesRequest, ListDbSystemShapesResponse>newBuilder()
              .setFullMethodName("google.cloud.oracledatabase.v1.OracleDatabase/ListDbSystemShapes")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListDbSystemShapesRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/dbSystemShapes",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListDbSystemShapesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListDbSystemShapesRequest> serializer =
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
                  ProtoMessageResponseParser.<ListDbSystemShapesResponse>newBuilder()
                      .setDefaultInstance(ListDbSystemShapesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListAutonomousDatabasesRequest, ListAutonomousDatabasesResponse>
      listAutonomousDatabasesMethodDescriptor =
          ApiMethodDescriptor
              .<ListAutonomousDatabasesRequest, ListAutonomousDatabasesResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.oracledatabase.v1.OracleDatabase/ListAutonomousDatabases")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListAutonomousDatabasesRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/autonomousDatabases",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListAutonomousDatabasesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListAutonomousDatabasesRequest> serializer =
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
                  ProtoMessageResponseParser.<ListAutonomousDatabasesResponse>newBuilder()
                      .setDefaultInstance(ListAutonomousDatabasesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetAutonomousDatabaseRequest, AutonomousDatabase>
      getAutonomousDatabaseMethodDescriptor =
          ApiMethodDescriptor.<GetAutonomousDatabaseRequest, AutonomousDatabase>newBuilder()
              .setFullMethodName(
                  "google.cloud.oracledatabase.v1.OracleDatabase/GetAutonomousDatabase")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetAutonomousDatabaseRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/autonomousDatabases/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetAutonomousDatabaseRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetAutonomousDatabaseRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<AutonomousDatabase>newBuilder()
                      .setDefaultInstance(AutonomousDatabase.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateAutonomousDatabaseRequest, Operation>
      createAutonomousDatabaseMethodDescriptor =
          ApiMethodDescriptor.<CreateAutonomousDatabaseRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.oracledatabase.v1.OracleDatabase/CreateAutonomousDatabase")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateAutonomousDatabaseRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/autonomousDatabases",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateAutonomousDatabaseRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateAutonomousDatabaseRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "autonomousDatabaseId", request.getAutonomousDatabaseId());
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "autonomousDatabase", request.getAutonomousDatabase(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateAutonomousDatabaseRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<UpdateAutonomousDatabaseRequest, Operation>
      updateAutonomousDatabaseMethodDescriptor =
          ApiMethodDescriptor.<UpdateAutonomousDatabaseRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.oracledatabase.v1.OracleDatabase/UpdateAutonomousDatabase")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateAutonomousDatabaseRequest>newBuilder()
                      .setPath(
                          "/v1/{autonomousDatabase.name=projects/*/locations/*/autonomousDatabases/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateAutonomousDatabaseRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields,
                                "autonomousDatabase.name",
                                request.getAutonomousDatabase().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateAutonomousDatabaseRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "autonomousDatabase", request.getAutonomousDatabase(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateAutonomousDatabaseRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeleteAutonomousDatabaseRequest, Operation>
      deleteAutonomousDatabaseMethodDescriptor =
          ApiMethodDescriptor.<DeleteAutonomousDatabaseRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.oracledatabase.v1.OracleDatabase/DeleteAutonomousDatabase")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteAutonomousDatabaseRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/autonomousDatabases/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteAutonomousDatabaseRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteAutonomousDatabaseRequest> serializer =
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
                  (DeleteAutonomousDatabaseRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<RestoreAutonomousDatabaseRequest, Operation>
      restoreAutonomousDatabaseMethodDescriptor =
          ApiMethodDescriptor.<RestoreAutonomousDatabaseRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.oracledatabase.v1.OracleDatabase/RestoreAutonomousDatabase")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<RestoreAutonomousDatabaseRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/autonomousDatabases/*}:restore",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<RestoreAutonomousDatabaseRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<RestoreAutonomousDatabaseRequest> serializer =
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
                  (RestoreAutonomousDatabaseRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<
          GenerateAutonomousDatabaseWalletRequest, GenerateAutonomousDatabaseWalletResponse>
      generateAutonomousDatabaseWalletMethodDescriptor =
          ApiMethodDescriptor
              .<GenerateAutonomousDatabaseWalletRequest, GenerateAutonomousDatabaseWalletResponse>
                  newBuilder()
              .setFullMethodName(
                  "google.cloud.oracledatabase.v1.OracleDatabase/GenerateAutonomousDatabaseWallet")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GenerateAutonomousDatabaseWalletRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/autonomousDatabases/*}:generateWallet",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GenerateAutonomousDatabaseWalletRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GenerateAutonomousDatabaseWalletRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearName().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<GenerateAutonomousDatabaseWalletResponse>newBuilder()
                      .setDefaultInstance(
                          GenerateAutonomousDatabaseWalletResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListAutonomousDbVersionsRequest, ListAutonomousDbVersionsResponse>
      listAutonomousDbVersionsMethodDescriptor =
          ApiMethodDescriptor
              .<ListAutonomousDbVersionsRequest, ListAutonomousDbVersionsResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.oracledatabase.v1.OracleDatabase/ListAutonomousDbVersions")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListAutonomousDbVersionsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/autonomousDbVersions",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListAutonomousDbVersionsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListAutonomousDbVersionsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListAutonomousDbVersionsResponse>newBuilder()
                      .setDefaultInstance(ListAutonomousDbVersionsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListAutonomousDatabaseCharacterSetsRequest, ListAutonomousDatabaseCharacterSetsResponse>
      listAutonomousDatabaseCharacterSetsMethodDescriptor =
          ApiMethodDescriptor
              .<ListAutonomousDatabaseCharacterSetsRequest,
                  ListAutonomousDatabaseCharacterSetsResponse>
                  newBuilder()
              .setFullMethodName(
                  "google.cloud.oracledatabase.v1.OracleDatabase/ListAutonomousDatabaseCharacterSets")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<ListAutonomousDatabaseCharacterSetsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/autonomousDatabaseCharacterSets",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListAutonomousDatabaseCharacterSetsRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListAutonomousDatabaseCharacterSetsRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser
                      .<ListAutonomousDatabaseCharacterSetsResponse>newBuilder()
                      .setDefaultInstance(
                          ListAutonomousDatabaseCharacterSetsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListAutonomousDatabaseBackupsRequest, ListAutonomousDatabaseBackupsResponse>
      listAutonomousDatabaseBackupsMethodDescriptor =
          ApiMethodDescriptor
              .<ListAutonomousDatabaseBackupsRequest, ListAutonomousDatabaseBackupsResponse>
                  newBuilder()
              .setFullMethodName(
                  "google.cloud.oracledatabase.v1.OracleDatabase/ListAutonomousDatabaseBackups")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListAutonomousDatabaseBackupsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/autonomousDatabaseBackups",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListAutonomousDatabaseBackupsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListAutonomousDatabaseBackupsRequest> serializer =
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
                  ProtoMessageResponseParser.<ListAutonomousDatabaseBackupsResponse>newBuilder()
                      .setDefaultInstance(
                          ListAutonomousDatabaseBackupsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<StopAutonomousDatabaseRequest, Operation>
      stopAutonomousDatabaseMethodDescriptor =
          ApiMethodDescriptor.<StopAutonomousDatabaseRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.oracledatabase.v1.OracleDatabase/StopAutonomousDatabase")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<StopAutonomousDatabaseRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/autonomousDatabases/*}:stop",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<StopAutonomousDatabaseRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<StopAutonomousDatabaseRequest> serializer =
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
                  (StopAutonomousDatabaseRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<StartAutonomousDatabaseRequest, Operation>
      startAutonomousDatabaseMethodDescriptor =
          ApiMethodDescriptor.<StartAutonomousDatabaseRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.oracledatabase.v1.OracleDatabase/StartAutonomousDatabase")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<StartAutonomousDatabaseRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/autonomousDatabases/*}:start",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<StartAutonomousDatabaseRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<StartAutonomousDatabaseRequest> serializer =
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
                  (StartAutonomousDatabaseRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<RestartAutonomousDatabaseRequest, Operation>
      restartAutonomousDatabaseMethodDescriptor =
          ApiMethodDescriptor.<RestartAutonomousDatabaseRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.oracledatabase.v1.OracleDatabase/RestartAutonomousDatabase")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<RestartAutonomousDatabaseRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/autonomousDatabases/*}:restart",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<RestartAutonomousDatabaseRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<RestartAutonomousDatabaseRequest> serializer =
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
                  (RestartAutonomousDatabaseRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<SwitchoverAutonomousDatabaseRequest, Operation>
      switchoverAutonomousDatabaseMethodDescriptor =
          ApiMethodDescriptor.<SwitchoverAutonomousDatabaseRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.oracledatabase.v1.OracleDatabase/SwitchoverAutonomousDatabase")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SwitchoverAutonomousDatabaseRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/autonomousDatabases/*}:switchover",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SwitchoverAutonomousDatabaseRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SwitchoverAutonomousDatabaseRequest> serializer =
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
                  (SwitchoverAutonomousDatabaseRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<FailoverAutonomousDatabaseRequest, Operation>
      failoverAutonomousDatabaseMethodDescriptor =
          ApiMethodDescriptor.<FailoverAutonomousDatabaseRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.oracledatabase.v1.OracleDatabase/FailoverAutonomousDatabase")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<FailoverAutonomousDatabaseRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/autonomousDatabases/*}:failover",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<FailoverAutonomousDatabaseRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<FailoverAutonomousDatabaseRequest> serializer =
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
                  (FailoverAutonomousDatabaseRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<ListOdbNetworksRequest, ListOdbNetworksResponse>
      listOdbNetworksMethodDescriptor =
          ApiMethodDescriptor.<ListOdbNetworksRequest, ListOdbNetworksResponse>newBuilder()
              .setFullMethodName("google.cloud.oracledatabase.v1.OracleDatabase/ListOdbNetworks")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListOdbNetworksRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/odbNetworks",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListOdbNetworksRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListOdbNetworksRequest> serializer =
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
                  ProtoMessageResponseParser.<ListOdbNetworksResponse>newBuilder()
                      .setDefaultInstance(ListOdbNetworksResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetOdbNetworkRequest, OdbNetwork>
      getOdbNetworkMethodDescriptor =
          ApiMethodDescriptor.<GetOdbNetworkRequest, OdbNetwork>newBuilder()
              .setFullMethodName("google.cloud.oracledatabase.v1.OracleDatabase/GetOdbNetwork")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetOdbNetworkRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/odbNetworks/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetOdbNetworkRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetOdbNetworkRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<OdbNetwork>newBuilder()
                      .setDefaultInstance(OdbNetwork.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateOdbNetworkRequest, Operation>
      createOdbNetworkMethodDescriptor =
          ApiMethodDescriptor.<CreateOdbNetworkRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.oracledatabase.v1.OracleDatabase/CreateOdbNetwork")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateOdbNetworkRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/odbNetworks",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateOdbNetworkRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateOdbNetworkRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "odbNetworkId", request.getOdbNetworkId());
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("odbNetwork", request.getOdbNetwork(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateOdbNetworkRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeleteOdbNetworkRequest, Operation>
      deleteOdbNetworkMethodDescriptor =
          ApiMethodDescriptor.<DeleteOdbNetworkRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.oracledatabase.v1.OracleDatabase/DeleteOdbNetwork")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteOdbNetworkRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/odbNetworks/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteOdbNetworkRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteOdbNetworkRequest> serializer =
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
                  (DeleteOdbNetworkRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<ListOdbSubnetsRequest, ListOdbSubnetsResponse>
      listOdbSubnetsMethodDescriptor =
          ApiMethodDescriptor.<ListOdbSubnetsRequest, ListOdbSubnetsResponse>newBuilder()
              .setFullMethodName("google.cloud.oracledatabase.v1.OracleDatabase/ListOdbSubnets")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListOdbSubnetsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/odbNetworks/*}/odbSubnets",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListOdbSubnetsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListOdbSubnetsRequest> serializer =
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
                  ProtoMessageResponseParser.<ListOdbSubnetsResponse>newBuilder()
                      .setDefaultInstance(ListOdbSubnetsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetOdbSubnetRequest, OdbSubnet>
      getOdbSubnetMethodDescriptor =
          ApiMethodDescriptor.<GetOdbSubnetRequest, OdbSubnet>newBuilder()
              .setFullMethodName("google.cloud.oracledatabase.v1.OracleDatabase/GetOdbSubnet")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetOdbSubnetRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/odbNetworks/*/odbSubnets/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetOdbSubnetRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetOdbSubnetRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<OdbSubnet>newBuilder()
                      .setDefaultInstance(OdbSubnet.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateOdbSubnetRequest, Operation>
      createOdbSubnetMethodDescriptor =
          ApiMethodDescriptor.<CreateOdbSubnetRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.oracledatabase.v1.OracleDatabase/CreateOdbSubnet")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateOdbSubnetRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/odbNetworks/*}/odbSubnets",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateOdbSubnetRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateOdbSubnetRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "odbSubnetId", request.getOdbSubnetId());
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("odbSubnet", request.getOdbSubnet(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateOdbSubnetRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeleteOdbSubnetRequest, Operation>
      deleteOdbSubnetMethodDescriptor =
          ApiMethodDescriptor.<DeleteOdbSubnetRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.oracledatabase.v1.OracleDatabase/DeleteOdbSubnet")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteOdbSubnetRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/odbNetworks/*/odbSubnets/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteOdbSubnetRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteOdbSubnetRequest> serializer =
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
                  (DeleteOdbSubnetRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<ListExadbVmClustersRequest, ListExadbVmClustersResponse>
      listExadbVmClustersMethodDescriptor =
          ApiMethodDescriptor.<ListExadbVmClustersRequest, ListExadbVmClustersResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.oracledatabase.v1.OracleDatabase/ListExadbVmClusters")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListExadbVmClustersRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/exadbVmClusters",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListExadbVmClustersRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListExadbVmClustersRequest> serializer =
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
                  ProtoMessageResponseParser.<ListExadbVmClustersResponse>newBuilder()
                      .setDefaultInstance(ListExadbVmClustersResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetExadbVmClusterRequest, ExadbVmCluster>
      getExadbVmClusterMethodDescriptor =
          ApiMethodDescriptor.<GetExadbVmClusterRequest, ExadbVmCluster>newBuilder()
              .setFullMethodName("google.cloud.oracledatabase.v1.OracleDatabase/GetExadbVmCluster")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetExadbVmClusterRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/exadbVmClusters/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetExadbVmClusterRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetExadbVmClusterRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ExadbVmCluster>newBuilder()
                      .setDefaultInstance(ExadbVmCluster.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateExadbVmClusterRequest, Operation>
      createExadbVmClusterMethodDescriptor =
          ApiMethodDescriptor.<CreateExadbVmClusterRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.oracledatabase.v1.OracleDatabase/CreateExadbVmCluster")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateExadbVmClusterRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/exadbVmClusters",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateExadbVmClusterRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateExadbVmClusterRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "exadbVmClusterId", request.getExadbVmClusterId());
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("exadbVmCluster", request.getExadbVmCluster(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateExadbVmClusterRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeleteExadbVmClusterRequest, Operation>
      deleteExadbVmClusterMethodDescriptor =
          ApiMethodDescriptor.<DeleteExadbVmClusterRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.oracledatabase.v1.OracleDatabase/DeleteExadbVmCluster")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteExadbVmClusterRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/exadbVmClusters/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteExadbVmClusterRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteExadbVmClusterRequest> serializer =
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
                  (DeleteExadbVmClusterRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<UpdateExadbVmClusterRequest, Operation>
      updateExadbVmClusterMethodDescriptor =
          ApiMethodDescriptor.<UpdateExadbVmClusterRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.oracledatabase.v1.OracleDatabase/UpdateExadbVmCluster")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateExadbVmClusterRequest>newBuilder()
                      .setPath(
                          "/v1/{exadbVmCluster.name=projects/*/locations/*/exadbVmClusters/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateExadbVmClusterRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields,
                                "exadbVmCluster.name",
                                request.getExadbVmCluster().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateExadbVmClusterRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("exadbVmCluster", request.getExadbVmCluster(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateExadbVmClusterRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<RemoveVirtualMachineExadbVmClusterRequest, Operation>
      removeVirtualMachineExadbVmClusterMethodDescriptor =
          ApiMethodDescriptor.<RemoveVirtualMachineExadbVmClusterRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.oracledatabase.v1.OracleDatabase/RemoveVirtualMachineExadbVmCluster")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<RemoveVirtualMachineExadbVmClusterRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/exadbVmClusters/*}:removeVirtualMachine",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<RemoveVirtualMachineExadbVmClusterRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<RemoveVirtualMachineExadbVmClusterRequest>
                                serializer = ProtoRestSerializer.create();
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
                  (RemoveVirtualMachineExadbVmClusterRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<
          ListExascaleDbStorageVaultsRequest, ListExascaleDbStorageVaultsResponse>
      listExascaleDbStorageVaultsMethodDescriptor =
          ApiMethodDescriptor
              .<ListExascaleDbStorageVaultsRequest, ListExascaleDbStorageVaultsResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.oracledatabase.v1.OracleDatabase/ListExascaleDbStorageVaults")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListExascaleDbStorageVaultsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/exascaleDbStorageVaults",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListExascaleDbStorageVaultsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListExascaleDbStorageVaultsRequest> serializer =
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
                  ProtoMessageResponseParser.<ListExascaleDbStorageVaultsResponse>newBuilder()
                      .setDefaultInstance(ListExascaleDbStorageVaultsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetExascaleDbStorageVaultRequest, ExascaleDbStorageVault>
      getExascaleDbStorageVaultMethodDescriptor =
          ApiMethodDescriptor.<GetExascaleDbStorageVaultRequest, ExascaleDbStorageVault>newBuilder()
              .setFullMethodName(
                  "google.cloud.oracledatabase.v1.OracleDatabase/GetExascaleDbStorageVault")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetExascaleDbStorageVaultRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/exascaleDbStorageVaults/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetExascaleDbStorageVaultRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetExascaleDbStorageVaultRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ExascaleDbStorageVault>newBuilder()
                      .setDefaultInstance(ExascaleDbStorageVault.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateExascaleDbStorageVaultRequest, Operation>
      createExascaleDbStorageVaultMethodDescriptor =
          ApiMethodDescriptor.<CreateExascaleDbStorageVaultRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.oracledatabase.v1.OracleDatabase/CreateExascaleDbStorageVault")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateExascaleDbStorageVaultRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/exascaleDbStorageVaults",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateExascaleDbStorageVaultRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateExascaleDbStorageVaultRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields,
                                "exascaleDbStorageVaultId",
                                request.getExascaleDbStorageVaultId());
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "exascaleDbStorageVault",
                                      request.getExascaleDbStorageVault(),
                                      true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateExascaleDbStorageVaultRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeleteExascaleDbStorageVaultRequest, Operation>
      deleteExascaleDbStorageVaultMethodDescriptor =
          ApiMethodDescriptor.<DeleteExascaleDbStorageVaultRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.oracledatabase.v1.OracleDatabase/DeleteExascaleDbStorageVault")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteExascaleDbStorageVaultRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/exascaleDbStorageVaults/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteExascaleDbStorageVaultRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteExascaleDbStorageVaultRequest> serializer =
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
                  (DeleteExascaleDbStorageVaultRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<
          ListDbSystemInitialStorageSizesRequest, ListDbSystemInitialStorageSizesResponse>
      listDbSystemInitialStorageSizesMethodDescriptor =
          ApiMethodDescriptor
              .<ListDbSystemInitialStorageSizesRequest, ListDbSystemInitialStorageSizesResponse>
                  newBuilder()
              .setFullMethodName(
                  "google.cloud.oracledatabase.v1.OracleDatabase/ListDbSystemInitialStorageSizes")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListDbSystemInitialStorageSizesRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/dbSystemInitialStorageSizes",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListDbSystemInitialStorageSizesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListDbSystemInitialStorageSizesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListDbSystemInitialStorageSizesResponse>newBuilder()
                      .setDefaultInstance(
                          ListDbSystemInitialStorageSizesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListDatabasesRequest, ListDatabasesResponse>
      listDatabasesMethodDescriptor =
          ApiMethodDescriptor.<ListDatabasesRequest, ListDatabasesResponse>newBuilder()
              .setFullMethodName("google.cloud.oracledatabase.v1.OracleDatabase/ListDatabases")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListDatabasesRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/databases",
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

  private static final ApiMethodDescriptor<GetDatabaseRequest, Database>
      getDatabaseMethodDescriptor =
          ApiMethodDescriptor.<GetDatabaseRequest, Database>newBuilder()
              .setFullMethodName("google.cloud.oracledatabase.v1.OracleDatabase/GetDatabase")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetDatabaseRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/databases/*}",
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

  private static final ApiMethodDescriptor<
          ListPluggableDatabasesRequest, ListPluggableDatabasesResponse>
      listPluggableDatabasesMethodDescriptor =
          ApiMethodDescriptor
              .<ListPluggableDatabasesRequest, ListPluggableDatabasesResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.oracledatabase.v1.OracleDatabase/ListPluggableDatabases")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListPluggableDatabasesRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/pluggableDatabases",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListPluggableDatabasesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListPluggableDatabasesRequest> serializer =
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
                  ProtoMessageResponseParser.<ListPluggableDatabasesResponse>newBuilder()
                      .setDefaultInstance(ListPluggableDatabasesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetPluggableDatabaseRequest, PluggableDatabase>
      getPluggableDatabaseMethodDescriptor =
          ApiMethodDescriptor.<GetPluggableDatabaseRequest, PluggableDatabase>newBuilder()
              .setFullMethodName(
                  "google.cloud.oracledatabase.v1.OracleDatabase/GetPluggableDatabase")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetPluggableDatabaseRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/pluggableDatabases/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetPluggableDatabaseRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetPluggableDatabaseRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<PluggableDatabase>newBuilder()
                      .setDefaultInstance(PluggableDatabase.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListDbSystemsRequest, ListDbSystemsResponse>
      listDbSystemsMethodDescriptor =
          ApiMethodDescriptor.<ListDbSystemsRequest, ListDbSystemsResponse>newBuilder()
              .setFullMethodName("google.cloud.oracledatabase.v1.OracleDatabase/ListDbSystems")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListDbSystemsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/dbSystems",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListDbSystemsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListDbSystemsRequest> serializer =
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
                  ProtoMessageResponseParser.<ListDbSystemsResponse>newBuilder()
                      .setDefaultInstance(ListDbSystemsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetDbSystemRequest, DbSystem>
      getDbSystemMethodDescriptor =
          ApiMethodDescriptor.<GetDbSystemRequest, DbSystem>newBuilder()
              .setFullMethodName("google.cloud.oracledatabase.v1.OracleDatabase/GetDbSystem")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetDbSystemRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/dbSystems/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetDbSystemRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetDbSystemRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<DbSystem>newBuilder()
                      .setDefaultInstance(DbSystem.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateDbSystemRequest, Operation>
      createDbSystemMethodDescriptor =
          ApiMethodDescriptor.<CreateDbSystemRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.oracledatabase.v1.OracleDatabase/CreateDbSystem")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateDbSystemRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/dbSystems",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateDbSystemRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateDbSystemRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "dbSystemId", request.getDbSystemId());
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("dbSystem", request.getDbSystem(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateDbSystemRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeleteDbSystemRequest, Operation>
      deleteDbSystemMethodDescriptor =
          ApiMethodDescriptor.<DeleteDbSystemRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.oracledatabase.v1.OracleDatabase/DeleteDbSystem")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteDbSystemRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/dbSystems/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteDbSystemRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteDbSystemRequest> serializer =
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
                  (DeleteDbSystemRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<ListDbVersionsRequest, ListDbVersionsResponse>
      listDbVersionsMethodDescriptor =
          ApiMethodDescriptor.<ListDbVersionsRequest, ListDbVersionsResponse>newBuilder()
              .setFullMethodName("google.cloud.oracledatabase.v1.OracleDatabase/ListDbVersions")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListDbVersionsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/dbVersions",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListDbVersionsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListDbVersionsRequest> serializer =
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
                  ProtoMessageResponseParser.<ListDbVersionsResponse>newBuilder()
                      .setDefaultInstance(ListDbVersionsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListDatabaseCharacterSetsRequest, ListDatabaseCharacterSetsResponse>
      listDatabaseCharacterSetsMethodDescriptor =
          ApiMethodDescriptor
              .<ListDatabaseCharacterSetsRequest, ListDatabaseCharacterSetsResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.oracledatabase.v1.OracleDatabase/ListDatabaseCharacterSets")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListDatabaseCharacterSetsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/databaseCharacterSets",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListDatabaseCharacterSetsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListDatabaseCharacterSetsRequest> serializer =
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
                  ProtoMessageResponseParser.<ListDatabaseCharacterSetsResponse>newBuilder()
                      .setDefaultInstance(ListDatabaseCharacterSetsResponse.getDefaultInstance())
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

  private final UnaryCallable<
          ListCloudExadataInfrastructuresRequest, ListCloudExadataInfrastructuresResponse>
      listCloudExadataInfrastructuresCallable;
  private final UnaryCallable<
          ListCloudExadataInfrastructuresRequest, ListCloudExadataInfrastructuresPagedResponse>
      listCloudExadataInfrastructuresPagedCallable;
  private final UnaryCallable<GetCloudExadataInfrastructureRequest, CloudExadataInfrastructure>
      getCloudExadataInfrastructureCallable;
  private final UnaryCallable<CreateCloudExadataInfrastructureRequest, Operation>
      createCloudExadataInfrastructureCallable;
  private final OperationCallable<
          CreateCloudExadataInfrastructureRequest, CloudExadataInfrastructure, OperationMetadata>
      createCloudExadataInfrastructureOperationCallable;
  private final UnaryCallable<DeleteCloudExadataInfrastructureRequest, Operation>
      deleteCloudExadataInfrastructureCallable;
  private final OperationCallable<DeleteCloudExadataInfrastructureRequest, Empty, OperationMetadata>
      deleteCloudExadataInfrastructureOperationCallable;
  private final UnaryCallable<ListCloudVmClustersRequest, ListCloudVmClustersResponse>
      listCloudVmClustersCallable;
  private final UnaryCallable<ListCloudVmClustersRequest, ListCloudVmClustersPagedResponse>
      listCloudVmClustersPagedCallable;
  private final UnaryCallable<GetCloudVmClusterRequest, CloudVmCluster> getCloudVmClusterCallable;
  private final UnaryCallable<CreateCloudVmClusterRequest, Operation> createCloudVmClusterCallable;
  private final OperationCallable<CreateCloudVmClusterRequest, CloudVmCluster, OperationMetadata>
      createCloudVmClusterOperationCallable;
  private final UnaryCallable<DeleteCloudVmClusterRequest, Operation> deleteCloudVmClusterCallable;
  private final OperationCallable<DeleteCloudVmClusterRequest, Empty, OperationMetadata>
      deleteCloudVmClusterOperationCallable;
  private final UnaryCallable<ListEntitlementsRequest, ListEntitlementsResponse>
      listEntitlementsCallable;
  private final UnaryCallable<ListEntitlementsRequest, ListEntitlementsPagedResponse>
      listEntitlementsPagedCallable;
  private final UnaryCallable<ListDbServersRequest, ListDbServersResponse> listDbServersCallable;
  private final UnaryCallable<ListDbServersRequest, ListDbServersPagedResponse>
      listDbServersPagedCallable;
  private final UnaryCallable<ListDbNodesRequest, ListDbNodesResponse> listDbNodesCallable;
  private final UnaryCallable<ListDbNodesRequest, ListDbNodesPagedResponse>
      listDbNodesPagedCallable;
  private final UnaryCallable<ListGiVersionsRequest, ListGiVersionsResponse> listGiVersionsCallable;
  private final UnaryCallable<ListGiVersionsRequest, ListGiVersionsPagedResponse>
      listGiVersionsPagedCallable;
  private final UnaryCallable<ListMinorVersionsRequest, ListMinorVersionsResponse>
      listMinorVersionsCallable;
  private final UnaryCallable<ListMinorVersionsRequest, ListMinorVersionsPagedResponse>
      listMinorVersionsPagedCallable;
  private final UnaryCallable<ListDbSystemShapesRequest, ListDbSystemShapesResponse>
      listDbSystemShapesCallable;
  private final UnaryCallable<ListDbSystemShapesRequest, ListDbSystemShapesPagedResponse>
      listDbSystemShapesPagedCallable;
  private final UnaryCallable<ListAutonomousDatabasesRequest, ListAutonomousDatabasesResponse>
      listAutonomousDatabasesCallable;
  private final UnaryCallable<ListAutonomousDatabasesRequest, ListAutonomousDatabasesPagedResponse>
      listAutonomousDatabasesPagedCallable;
  private final UnaryCallable<GetAutonomousDatabaseRequest, AutonomousDatabase>
      getAutonomousDatabaseCallable;
  private final UnaryCallable<CreateAutonomousDatabaseRequest, Operation>
      createAutonomousDatabaseCallable;
  private final OperationCallable<
          CreateAutonomousDatabaseRequest, AutonomousDatabase, OperationMetadata>
      createAutonomousDatabaseOperationCallable;
  private final UnaryCallable<UpdateAutonomousDatabaseRequest, Operation>
      updateAutonomousDatabaseCallable;
  private final OperationCallable<
          UpdateAutonomousDatabaseRequest, AutonomousDatabase, OperationMetadata>
      updateAutonomousDatabaseOperationCallable;
  private final UnaryCallable<DeleteAutonomousDatabaseRequest, Operation>
      deleteAutonomousDatabaseCallable;
  private final OperationCallable<DeleteAutonomousDatabaseRequest, Empty, OperationMetadata>
      deleteAutonomousDatabaseOperationCallable;
  private final UnaryCallable<RestoreAutonomousDatabaseRequest, Operation>
      restoreAutonomousDatabaseCallable;
  private final OperationCallable<
          RestoreAutonomousDatabaseRequest, AutonomousDatabase, OperationMetadata>
      restoreAutonomousDatabaseOperationCallable;
  private final UnaryCallable<
          GenerateAutonomousDatabaseWalletRequest, GenerateAutonomousDatabaseWalletResponse>
      generateAutonomousDatabaseWalletCallable;
  private final UnaryCallable<ListAutonomousDbVersionsRequest, ListAutonomousDbVersionsResponse>
      listAutonomousDbVersionsCallable;
  private final UnaryCallable<
          ListAutonomousDbVersionsRequest, ListAutonomousDbVersionsPagedResponse>
      listAutonomousDbVersionsPagedCallable;
  private final UnaryCallable<
          ListAutonomousDatabaseCharacterSetsRequest, ListAutonomousDatabaseCharacterSetsResponse>
      listAutonomousDatabaseCharacterSetsCallable;
  private final UnaryCallable<
          ListAutonomousDatabaseCharacterSetsRequest,
          ListAutonomousDatabaseCharacterSetsPagedResponse>
      listAutonomousDatabaseCharacterSetsPagedCallable;
  private final UnaryCallable<
          ListAutonomousDatabaseBackupsRequest, ListAutonomousDatabaseBackupsResponse>
      listAutonomousDatabaseBackupsCallable;
  private final UnaryCallable<
          ListAutonomousDatabaseBackupsRequest, ListAutonomousDatabaseBackupsPagedResponse>
      listAutonomousDatabaseBackupsPagedCallable;
  private final UnaryCallable<StopAutonomousDatabaseRequest, Operation>
      stopAutonomousDatabaseCallable;
  private final OperationCallable<
          StopAutonomousDatabaseRequest, AutonomousDatabase, OperationMetadata>
      stopAutonomousDatabaseOperationCallable;
  private final UnaryCallable<StartAutonomousDatabaseRequest, Operation>
      startAutonomousDatabaseCallable;
  private final OperationCallable<
          StartAutonomousDatabaseRequest, AutonomousDatabase, OperationMetadata>
      startAutonomousDatabaseOperationCallable;
  private final UnaryCallable<RestartAutonomousDatabaseRequest, Operation>
      restartAutonomousDatabaseCallable;
  private final OperationCallable<
          RestartAutonomousDatabaseRequest, AutonomousDatabase, OperationMetadata>
      restartAutonomousDatabaseOperationCallable;
  private final UnaryCallable<SwitchoverAutonomousDatabaseRequest, Operation>
      switchoverAutonomousDatabaseCallable;
  private final OperationCallable<
          SwitchoverAutonomousDatabaseRequest, AutonomousDatabase, OperationMetadata>
      switchoverAutonomousDatabaseOperationCallable;
  private final UnaryCallable<FailoverAutonomousDatabaseRequest, Operation>
      failoverAutonomousDatabaseCallable;
  private final OperationCallable<
          FailoverAutonomousDatabaseRequest, AutonomousDatabase, OperationMetadata>
      failoverAutonomousDatabaseOperationCallable;
  private final UnaryCallable<ListOdbNetworksRequest, ListOdbNetworksResponse>
      listOdbNetworksCallable;
  private final UnaryCallable<ListOdbNetworksRequest, ListOdbNetworksPagedResponse>
      listOdbNetworksPagedCallable;
  private final UnaryCallable<GetOdbNetworkRequest, OdbNetwork> getOdbNetworkCallable;
  private final UnaryCallable<CreateOdbNetworkRequest, Operation> createOdbNetworkCallable;
  private final OperationCallable<CreateOdbNetworkRequest, OdbNetwork, OperationMetadata>
      createOdbNetworkOperationCallable;
  private final UnaryCallable<DeleteOdbNetworkRequest, Operation> deleteOdbNetworkCallable;
  private final OperationCallable<DeleteOdbNetworkRequest, Empty, OperationMetadata>
      deleteOdbNetworkOperationCallable;
  private final UnaryCallable<ListOdbSubnetsRequest, ListOdbSubnetsResponse> listOdbSubnetsCallable;
  private final UnaryCallable<ListOdbSubnetsRequest, ListOdbSubnetsPagedResponse>
      listOdbSubnetsPagedCallable;
  private final UnaryCallable<GetOdbSubnetRequest, OdbSubnet> getOdbSubnetCallable;
  private final UnaryCallable<CreateOdbSubnetRequest, Operation> createOdbSubnetCallable;
  private final OperationCallable<CreateOdbSubnetRequest, OdbSubnet, OperationMetadata>
      createOdbSubnetOperationCallable;
  private final UnaryCallable<DeleteOdbSubnetRequest, Operation> deleteOdbSubnetCallable;
  private final OperationCallable<DeleteOdbSubnetRequest, Empty, OperationMetadata>
      deleteOdbSubnetOperationCallable;
  private final UnaryCallable<ListExadbVmClustersRequest, ListExadbVmClustersResponse>
      listExadbVmClustersCallable;
  private final UnaryCallable<ListExadbVmClustersRequest, ListExadbVmClustersPagedResponse>
      listExadbVmClustersPagedCallable;
  private final UnaryCallable<GetExadbVmClusterRequest, ExadbVmCluster> getExadbVmClusterCallable;
  private final UnaryCallable<CreateExadbVmClusterRequest, Operation> createExadbVmClusterCallable;
  private final OperationCallable<CreateExadbVmClusterRequest, ExadbVmCluster, OperationMetadata>
      createExadbVmClusterOperationCallable;
  private final UnaryCallable<DeleteExadbVmClusterRequest, Operation> deleteExadbVmClusterCallable;
  private final OperationCallable<DeleteExadbVmClusterRequest, Empty, OperationMetadata>
      deleteExadbVmClusterOperationCallable;
  private final UnaryCallable<UpdateExadbVmClusterRequest, Operation> updateExadbVmClusterCallable;
  private final OperationCallable<UpdateExadbVmClusterRequest, ExadbVmCluster, OperationMetadata>
      updateExadbVmClusterOperationCallable;
  private final UnaryCallable<RemoveVirtualMachineExadbVmClusterRequest, Operation>
      removeVirtualMachineExadbVmClusterCallable;
  private final OperationCallable<
          RemoveVirtualMachineExadbVmClusterRequest, ExadbVmCluster, OperationMetadata>
      removeVirtualMachineExadbVmClusterOperationCallable;
  private final UnaryCallable<
          ListExascaleDbStorageVaultsRequest, ListExascaleDbStorageVaultsResponse>
      listExascaleDbStorageVaultsCallable;
  private final UnaryCallable<
          ListExascaleDbStorageVaultsRequest, ListExascaleDbStorageVaultsPagedResponse>
      listExascaleDbStorageVaultsPagedCallable;
  private final UnaryCallable<GetExascaleDbStorageVaultRequest, ExascaleDbStorageVault>
      getExascaleDbStorageVaultCallable;
  private final UnaryCallable<CreateExascaleDbStorageVaultRequest, Operation>
      createExascaleDbStorageVaultCallable;
  private final OperationCallable<
          CreateExascaleDbStorageVaultRequest, ExascaleDbStorageVault, OperationMetadata>
      createExascaleDbStorageVaultOperationCallable;
  private final UnaryCallable<DeleteExascaleDbStorageVaultRequest, Operation>
      deleteExascaleDbStorageVaultCallable;
  private final OperationCallable<DeleteExascaleDbStorageVaultRequest, Empty, OperationMetadata>
      deleteExascaleDbStorageVaultOperationCallable;
  private final UnaryCallable<
          ListDbSystemInitialStorageSizesRequest, ListDbSystemInitialStorageSizesResponse>
      listDbSystemInitialStorageSizesCallable;
  private final UnaryCallable<
          ListDbSystemInitialStorageSizesRequest, ListDbSystemInitialStorageSizesPagedResponse>
      listDbSystemInitialStorageSizesPagedCallable;
  private final UnaryCallable<ListDatabasesRequest, ListDatabasesResponse> listDatabasesCallable;
  private final UnaryCallable<ListDatabasesRequest, ListDatabasesPagedResponse>
      listDatabasesPagedCallable;
  private final UnaryCallable<GetDatabaseRequest, Database> getDatabaseCallable;
  private final UnaryCallable<ListPluggableDatabasesRequest, ListPluggableDatabasesResponse>
      listPluggableDatabasesCallable;
  private final UnaryCallable<ListPluggableDatabasesRequest, ListPluggableDatabasesPagedResponse>
      listPluggableDatabasesPagedCallable;
  private final UnaryCallable<GetPluggableDatabaseRequest, PluggableDatabase>
      getPluggableDatabaseCallable;
  private final UnaryCallable<ListDbSystemsRequest, ListDbSystemsResponse> listDbSystemsCallable;
  private final UnaryCallable<ListDbSystemsRequest, ListDbSystemsPagedResponse>
      listDbSystemsPagedCallable;
  private final UnaryCallable<GetDbSystemRequest, DbSystem> getDbSystemCallable;
  private final UnaryCallable<CreateDbSystemRequest, Operation> createDbSystemCallable;
  private final OperationCallable<CreateDbSystemRequest, DbSystem, OperationMetadata>
      createDbSystemOperationCallable;
  private final UnaryCallable<DeleteDbSystemRequest, Operation> deleteDbSystemCallable;
  private final OperationCallable<DeleteDbSystemRequest, Empty, OperationMetadata>
      deleteDbSystemOperationCallable;
  private final UnaryCallable<ListDbVersionsRequest, ListDbVersionsResponse> listDbVersionsCallable;
  private final UnaryCallable<ListDbVersionsRequest, ListDbVersionsPagedResponse>
      listDbVersionsPagedCallable;
  private final UnaryCallable<ListDatabaseCharacterSetsRequest, ListDatabaseCharacterSetsResponse>
      listDatabaseCharacterSetsCallable;
  private final UnaryCallable<
          ListDatabaseCharacterSetsRequest, ListDatabaseCharacterSetsPagedResponse>
      listDatabaseCharacterSetsPagedCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<GetLocationRequest, Location> getLocationCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonOracleDatabaseStub create(OracleDatabaseStubSettings settings)
      throws IOException {
    return new HttpJsonOracleDatabaseStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonOracleDatabaseStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonOracleDatabaseStub(
        OracleDatabaseStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonOracleDatabaseStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonOracleDatabaseStub(
        OracleDatabaseStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonOracleDatabaseStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonOracleDatabaseStub(
      OracleDatabaseStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonOracleDatabaseCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonOracleDatabaseStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonOracleDatabaseStub(
      OracleDatabaseStubSettings settings,
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

    HttpJsonCallSettings<
            ListCloudExadataInfrastructuresRequest, ListCloudExadataInfrastructuresResponse>
        listCloudExadataInfrastructuresTransportSettings =
            HttpJsonCallSettings
                .<ListCloudExadataInfrastructuresRequest, ListCloudExadataInfrastructuresResponse>
                    newBuilder()
                .setMethodDescriptor(listCloudExadataInfrastructuresMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetCloudExadataInfrastructureRequest, CloudExadataInfrastructure>
        getCloudExadataInfrastructureTransportSettings =
            HttpJsonCallSettings
                .<GetCloudExadataInfrastructureRequest, CloudExadataInfrastructure>newBuilder()
                .setMethodDescriptor(getCloudExadataInfrastructureMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<CreateCloudExadataInfrastructureRequest, Operation>
        createCloudExadataInfrastructureTransportSettings =
            HttpJsonCallSettings.<CreateCloudExadataInfrastructureRequest, Operation>newBuilder()
                .setMethodDescriptor(createCloudExadataInfrastructureMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<DeleteCloudExadataInfrastructureRequest, Operation>
        deleteCloudExadataInfrastructureTransportSettings =
            HttpJsonCallSettings.<DeleteCloudExadataInfrastructureRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteCloudExadataInfrastructureMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ListCloudVmClustersRequest, ListCloudVmClustersResponse>
        listCloudVmClustersTransportSettings =
            HttpJsonCallSettings
                .<ListCloudVmClustersRequest, ListCloudVmClustersResponse>newBuilder()
                .setMethodDescriptor(listCloudVmClustersMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetCloudVmClusterRequest, CloudVmCluster>
        getCloudVmClusterTransportSettings =
            HttpJsonCallSettings.<GetCloudVmClusterRequest, CloudVmCluster>newBuilder()
                .setMethodDescriptor(getCloudVmClusterMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<CreateCloudVmClusterRequest, Operation>
        createCloudVmClusterTransportSettings =
            HttpJsonCallSettings.<CreateCloudVmClusterRequest, Operation>newBuilder()
                .setMethodDescriptor(createCloudVmClusterMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<DeleteCloudVmClusterRequest, Operation>
        deleteCloudVmClusterTransportSettings =
            HttpJsonCallSettings.<DeleteCloudVmClusterRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteCloudVmClusterMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ListEntitlementsRequest, ListEntitlementsResponse>
        listEntitlementsTransportSettings =
            HttpJsonCallSettings.<ListEntitlementsRequest, ListEntitlementsResponse>newBuilder()
                .setMethodDescriptor(listEntitlementsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ListDbServersRequest, ListDbServersResponse>
        listDbServersTransportSettings =
            HttpJsonCallSettings.<ListDbServersRequest, ListDbServersResponse>newBuilder()
                .setMethodDescriptor(listDbServersMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ListDbNodesRequest, ListDbNodesResponse> listDbNodesTransportSettings =
        HttpJsonCallSettings.<ListDbNodesRequest, ListDbNodesResponse>newBuilder()
            .setMethodDescriptor(listDbNodesMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListGiVersionsRequest, ListGiVersionsResponse>
        listGiVersionsTransportSettings =
            HttpJsonCallSettings.<ListGiVersionsRequest, ListGiVersionsResponse>newBuilder()
                .setMethodDescriptor(listGiVersionsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ListMinorVersionsRequest, ListMinorVersionsResponse>
        listMinorVersionsTransportSettings =
            HttpJsonCallSettings.<ListMinorVersionsRequest, ListMinorVersionsResponse>newBuilder()
                .setMethodDescriptor(listMinorVersionsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ListDbSystemShapesRequest, ListDbSystemShapesResponse>
        listDbSystemShapesTransportSettings =
            HttpJsonCallSettings.<ListDbSystemShapesRequest, ListDbSystemShapesResponse>newBuilder()
                .setMethodDescriptor(listDbSystemShapesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ListAutonomousDatabasesRequest, ListAutonomousDatabasesResponse>
        listAutonomousDatabasesTransportSettings =
            HttpJsonCallSettings
                .<ListAutonomousDatabasesRequest, ListAutonomousDatabasesResponse>newBuilder()
                .setMethodDescriptor(listAutonomousDatabasesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetAutonomousDatabaseRequest, AutonomousDatabase>
        getAutonomousDatabaseTransportSettings =
            HttpJsonCallSettings.<GetAutonomousDatabaseRequest, AutonomousDatabase>newBuilder()
                .setMethodDescriptor(getAutonomousDatabaseMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<CreateAutonomousDatabaseRequest, Operation>
        createAutonomousDatabaseTransportSettings =
            HttpJsonCallSettings.<CreateAutonomousDatabaseRequest, Operation>newBuilder()
                .setMethodDescriptor(createAutonomousDatabaseMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<UpdateAutonomousDatabaseRequest, Operation>
        updateAutonomousDatabaseTransportSettings =
            HttpJsonCallSettings.<UpdateAutonomousDatabaseRequest, Operation>newBuilder()
                .setMethodDescriptor(updateAutonomousDatabaseMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "autonomous_database.name",
                          String.valueOf(request.getAutonomousDatabase().getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<DeleteAutonomousDatabaseRequest, Operation>
        deleteAutonomousDatabaseTransportSettings =
            HttpJsonCallSettings.<DeleteAutonomousDatabaseRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteAutonomousDatabaseMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<RestoreAutonomousDatabaseRequest, Operation>
        restoreAutonomousDatabaseTransportSettings =
            HttpJsonCallSettings.<RestoreAutonomousDatabaseRequest, Operation>newBuilder()
                .setMethodDescriptor(restoreAutonomousDatabaseMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<
            GenerateAutonomousDatabaseWalletRequest, GenerateAutonomousDatabaseWalletResponse>
        generateAutonomousDatabaseWalletTransportSettings =
            HttpJsonCallSettings
                .<GenerateAutonomousDatabaseWalletRequest, GenerateAutonomousDatabaseWalletResponse>
                    newBuilder()
                .setMethodDescriptor(generateAutonomousDatabaseWalletMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ListAutonomousDbVersionsRequest, ListAutonomousDbVersionsResponse>
        listAutonomousDbVersionsTransportSettings =
            HttpJsonCallSettings
                .<ListAutonomousDbVersionsRequest, ListAutonomousDbVersionsResponse>newBuilder()
                .setMethodDescriptor(listAutonomousDbVersionsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<
            ListAutonomousDatabaseCharacterSetsRequest, ListAutonomousDatabaseCharacterSetsResponse>
        listAutonomousDatabaseCharacterSetsTransportSettings =
            HttpJsonCallSettings
                .<ListAutonomousDatabaseCharacterSetsRequest,
                    ListAutonomousDatabaseCharacterSetsResponse>
                    newBuilder()
                .setMethodDescriptor(listAutonomousDatabaseCharacterSetsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<
            ListAutonomousDatabaseBackupsRequest, ListAutonomousDatabaseBackupsResponse>
        listAutonomousDatabaseBackupsTransportSettings =
            HttpJsonCallSettings
                .<ListAutonomousDatabaseBackupsRequest, ListAutonomousDatabaseBackupsResponse>
                    newBuilder()
                .setMethodDescriptor(listAutonomousDatabaseBackupsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<StopAutonomousDatabaseRequest, Operation>
        stopAutonomousDatabaseTransportSettings =
            HttpJsonCallSettings.<StopAutonomousDatabaseRequest, Operation>newBuilder()
                .setMethodDescriptor(stopAutonomousDatabaseMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<StartAutonomousDatabaseRequest, Operation>
        startAutonomousDatabaseTransportSettings =
            HttpJsonCallSettings.<StartAutonomousDatabaseRequest, Operation>newBuilder()
                .setMethodDescriptor(startAutonomousDatabaseMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<RestartAutonomousDatabaseRequest, Operation>
        restartAutonomousDatabaseTransportSettings =
            HttpJsonCallSettings.<RestartAutonomousDatabaseRequest, Operation>newBuilder()
                .setMethodDescriptor(restartAutonomousDatabaseMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<SwitchoverAutonomousDatabaseRequest, Operation>
        switchoverAutonomousDatabaseTransportSettings =
            HttpJsonCallSettings.<SwitchoverAutonomousDatabaseRequest, Operation>newBuilder()
                .setMethodDescriptor(switchoverAutonomousDatabaseMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<FailoverAutonomousDatabaseRequest, Operation>
        failoverAutonomousDatabaseTransportSettings =
            HttpJsonCallSettings.<FailoverAutonomousDatabaseRequest, Operation>newBuilder()
                .setMethodDescriptor(failoverAutonomousDatabaseMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ListOdbNetworksRequest, ListOdbNetworksResponse>
        listOdbNetworksTransportSettings =
            HttpJsonCallSettings.<ListOdbNetworksRequest, ListOdbNetworksResponse>newBuilder()
                .setMethodDescriptor(listOdbNetworksMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetOdbNetworkRequest, OdbNetwork> getOdbNetworkTransportSettings =
        HttpJsonCallSettings.<GetOdbNetworkRequest, OdbNetwork>newBuilder()
            .setMethodDescriptor(getOdbNetworkMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<CreateOdbNetworkRequest, Operation> createOdbNetworkTransportSettings =
        HttpJsonCallSettings.<CreateOdbNetworkRequest, Operation>newBuilder()
            .setMethodDescriptor(createOdbNetworkMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeleteOdbNetworkRequest, Operation> deleteOdbNetworkTransportSettings =
        HttpJsonCallSettings.<DeleteOdbNetworkRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteOdbNetworkMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListOdbSubnetsRequest, ListOdbSubnetsResponse>
        listOdbSubnetsTransportSettings =
            HttpJsonCallSettings.<ListOdbSubnetsRequest, ListOdbSubnetsResponse>newBuilder()
                .setMethodDescriptor(listOdbSubnetsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetOdbSubnetRequest, OdbSubnet> getOdbSubnetTransportSettings =
        HttpJsonCallSettings.<GetOdbSubnetRequest, OdbSubnet>newBuilder()
            .setMethodDescriptor(getOdbSubnetMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<CreateOdbSubnetRequest, Operation> createOdbSubnetTransportSettings =
        HttpJsonCallSettings.<CreateOdbSubnetRequest, Operation>newBuilder()
            .setMethodDescriptor(createOdbSubnetMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeleteOdbSubnetRequest, Operation> deleteOdbSubnetTransportSettings =
        HttpJsonCallSettings.<DeleteOdbSubnetRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteOdbSubnetMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListExadbVmClustersRequest, ListExadbVmClustersResponse>
        listExadbVmClustersTransportSettings =
            HttpJsonCallSettings
                .<ListExadbVmClustersRequest, ListExadbVmClustersResponse>newBuilder()
                .setMethodDescriptor(listExadbVmClustersMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetExadbVmClusterRequest, ExadbVmCluster>
        getExadbVmClusterTransportSettings =
            HttpJsonCallSettings.<GetExadbVmClusterRequest, ExadbVmCluster>newBuilder()
                .setMethodDescriptor(getExadbVmClusterMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<CreateExadbVmClusterRequest, Operation>
        createExadbVmClusterTransportSettings =
            HttpJsonCallSettings.<CreateExadbVmClusterRequest, Operation>newBuilder()
                .setMethodDescriptor(createExadbVmClusterMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<DeleteExadbVmClusterRequest, Operation>
        deleteExadbVmClusterTransportSettings =
            HttpJsonCallSettings.<DeleteExadbVmClusterRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteExadbVmClusterMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<UpdateExadbVmClusterRequest, Operation>
        updateExadbVmClusterTransportSettings =
            HttpJsonCallSettings.<UpdateExadbVmClusterRequest, Operation>newBuilder()
                .setMethodDescriptor(updateExadbVmClusterMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "exadb_vm_cluster.name",
                          String.valueOf(request.getExadbVmCluster().getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<RemoveVirtualMachineExadbVmClusterRequest, Operation>
        removeVirtualMachineExadbVmClusterTransportSettings =
            HttpJsonCallSettings.<RemoveVirtualMachineExadbVmClusterRequest, Operation>newBuilder()
                .setMethodDescriptor(removeVirtualMachineExadbVmClusterMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ListExascaleDbStorageVaultsRequest, ListExascaleDbStorageVaultsResponse>
        listExascaleDbStorageVaultsTransportSettings =
            HttpJsonCallSettings
                .<ListExascaleDbStorageVaultsRequest, ListExascaleDbStorageVaultsResponse>
                    newBuilder()
                .setMethodDescriptor(listExascaleDbStorageVaultsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetExascaleDbStorageVaultRequest, ExascaleDbStorageVault>
        getExascaleDbStorageVaultTransportSettings =
            HttpJsonCallSettings
                .<GetExascaleDbStorageVaultRequest, ExascaleDbStorageVault>newBuilder()
                .setMethodDescriptor(getExascaleDbStorageVaultMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<CreateExascaleDbStorageVaultRequest, Operation>
        createExascaleDbStorageVaultTransportSettings =
            HttpJsonCallSettings.<CreateExascaleDbStorageVaultRequest, Operation>newBuilder()
                .setMethodDescriptor(createExascaleDbStorageVaultMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<DeleteExascaleDbStorageVaultRequest, Operation>
        deleteExascaleDbStorageVaultTransportSettings =
            HttpJsonCallSettings.<DeleteExascaleDbStorageVaultRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteExascaleDbStorageVaultMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<
            ListDbSystemInitialStorageSizesRequest, ListDbSystemInitialStorageSizesResponse>
        listDbSystemInitialStorageSizesTransportSettings =
            HttpJsonCallSettings
                .<ListDbSystemInitialStorageSizesRequest, ListDbSystemInitialStorageSizesResponse>
                    newBuilder()
                .setMethodDescriptor(listDbSystemInitialStorageSizesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
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
    HttpJsonCallSettings<ListPluggableDatabasesRequest, ListPluggableDatabasesResponse>
        listPluggableDatabasesTransportSettings =
            HttpJsonCallSettings
                .<ListPluggableDatabasesRequest, ListPluggableDatabasesResponse>newBuilder()
                .setMethodDescriptor(listPluggableDatabasesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetPluggableDatabaseRequest, PluggableDatabase>
        getPluggableDatabaseTransportSettings =
            HttpJsonCallSettings.<GetPluggableDatabaseRequest, PluggableDatabase>newBuilder()
                .setMethodDescriptor(getPluggableDatabaseMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ListDbSystemsRequest, ListDbSystemsResponse>
        listDbSystemsTransportSettings =
            HttpJsonCallSettings.<ListDbSystemsRequest, ListDbSystemsResponse>newBuilder()
                .setMethodDescriptor(listDbSystemsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetDbSystemRequest, DbSystem> getDbSystemTransportSettings =
        HttpJsonCallSettings.<GetDbSystemRequest, DbSystem>newBuilder()
            .setMethodDescriptor(getDbSystemMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<CreateDbSystemRequest, Operation> createDbSystemTransportSettings =
        HttpJsonCallSettings.<CreateDbSystemRequest, Operation>newBuilder()
            .setMethodDescriptor(createDbSystemMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeleteDbSystemRequest, Operation> deleteDbSystemTransportSettings =
        HttpJsonCallSettings.<DeleteDbSystemRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteDbSystemMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListDbVersionsRequest, ListDbVersionsResponse>
        listDbVersionsTransportSettings =
            HttpJsonCallSettings.<ListDbVersionsRequest, ListDbVersionsResponse>newBuilder()
                .setMethodDescriptor(listDbVersionsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ListDatabaseCharacterSetsRequest, ListDatabaseCharacterSetsResponse>
        listDatabaseCharacterSetsTransportSettings =
            HttpJsonCallSettings
                .<ListDatabaseCharacterSetsRequest, ListDatabaseCharacterSetsResponse>newBuilder()
                .setMethodDescriptor(listDatabaseCharacterSetsMethodDescriptor)
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

    this.listCloudExadataInfrastructuresCallable =
        callableFactory.createUnaryCallable(
            listCloudExadataInfrastructuresTransportSettings,
            settings.listCloudExadataInfrastructuresSettings(),
            clientContext);
    this.listCloudExadataInfrastructuresPagedCallable =
        callableFactory.createPagedCallable(
            listCloudExadataInfrastructuresTransportSettings,
            settings.listCloudExadataInfrastructuresSettings(),
            clientContext);
    this.getCloudExadataInfrastructureCallable =
        callableFactory.createUnaryCallable(
            getCloudExadataInfrastructureTransportSettings,
            settings.getCloudExadataInfrastructureSettings(),
            clientContext);
    this.createCloudExadataInfrastructureCallable =
        callableFactory.createUnaryCallable(
            createCloudExadataInfrastructureTransportSettings,
            settings.createCloudExadataInfrastructureSettings(),
            clientContext);
    this.createCloudExadataInfrastructureOperationCallable =
        callableFactory.createOperationCallable(
            createCloudExadataInfrastructureTransportSettings,
            settings.createCloudExadataInfrastructureOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.deleteCloudExadataInfrastructureCallable =
        callableFactory.createUnaryCallable(
            deleteCloudExadataInfrastructureTransportSettings,
            settings.deleteCloudExadataInfrastructureSettings(),
            clientContext);
    this.deleteCloudExadataInfrastructureOperationCallable =
        callableFactory.createOperationCallable(
            deleteCloudExadataInfrastructureTransportSettings,
            settings.deleteCloudExadataInfrastructureOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.listCloudVmClustersCallable =
        callableFactory.createUnaryCallable(
            listCloudVmClustersTransportSettings,
            settings.listCloudVmClustersSettings(),
            clientContext);
    this.listCloudVmClustersPagedCallable =
        callableFactory.createPagedCallable(
            listCloudVmClustersTransportSettings,
            settings.listCloudVmClustersSettings(),
            clientContext);
    this.getCloudVmClusterCallable =
        callableFactory.createUnaryCallable(
            getCloudVmClusterTransportSettings,
            settings.getCloudVmClusterSettings(),
            clientContext);
    this.createCloudVmClusterCallable =
        callableFactory.createUnaryCallable(
            createCloudVmClusterTransportSettings,
            settings.createCloudVmClusterSettings(),
            clientContext);
    this.createCloudVmClusterOperationCallable =
        callableFactory.createOperationCallable(
            createCloudVmClusterTransportSettings,
            settings.createCloudVmClusterOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.deleteCloudVmClusterCallable =
        callableFactory.createUnaryCallable(
            deleteCloudVmClusterTransportSettings,
            settings.deleteCloudVmClusterSettings(),
            clientContext);
    this.deleteCloudVmClusterOperationCallable =
        callableFactory.createOperationCallable(
            deleteCloudVmClusterTransportSettings,
            settings.deleteCloudVmClusterOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.listEntitlementsCallable =
        callableFactory.createUnaryCallable(
            listEntitlementsTransportSettings, settings.listEntitlementsSettings(), clientContext);
    this.listEntitlementsPagedCallable =
        callableFactory.createPagedCallable(
            listEntitlementsTransportSettings, settings.listEntitlementsSettings(), clientContext);
    this.listDbServersCallable =
        callableFactory.createUnaryCallable(
            listDbServersTransportSettings, settings.listDbServersSettings(), clientContext);
    this.listDbServersPagedCallable =
        callableFactory.createPagedCallable(
            listDbServersTransportSettings, settings.listDbServersSettings(), clientContext);
    this.listDbNodesCallable =
        callableFactory.createUnaryCallable(
            listDbNodesTransportSettings, settings.listDbNodesSettings(), clientContext);
    this.listDbNodesPagedCallable =
        callableFactory.createPagedCallable(
            listDbNodesTransportSettings, settings.listDbNodesSettings(), clientContext);
    this.listGiVersionsCallable =
        callableFactory.createUnaryCallable(
            listGiVersionsTransportSettings, settings.listGiVersionsSettings(), clientContext);
    this.listGiVersionsPagedCallable =
        callableFactory.createPagedCallable(
            listGiVersionsTransportSettings, settings.listGiVersionsSettings(), clientContext);
    this.listMinorVersionsCallable =
        callableFactory.createUnaryCallable(
            listMinorVersionsTransportSettings,
            settings.listMinorVersionsSettings(),
            clientContext);
    this.listMinorVersionsPagedCallable =
        callableFactory.createPagedCallable(
            listMinorVersionsTransportSettings,
            settings.listMinorVersionsSettings(),
            clientContext);
    this.listDbSystemShapesCallable =
        callableFactory.createUnaryCallable(
            listDbSystemShapesTransportSettings,
            settings.listDbSystemShapesSettings(),
            clientContext);
    this.listDbSystemShapesPagedCallable =
        callableFactory.createPagedCallable(
            listDbSystemShapesTransportSettings,
            settings.listDbSystemShapesSettings(),
            clientContext);
    this.listAutonomousDatabasesCallable =
        callableFactory.createUnaryCallable(
            listAutonomousDatabasesTransportSettings,
            settings.listAutonomousDatabasesSettings(),
            clientContext);
    this.listAutonomousDatabasesPagedCallable =
        callableFactory.createPagedCallable(
            listAutonomousDatabasesTransportSettings,
            settings.listAutonomousDatabasesSettings(),
            clientContext);
    this.getAutonomousDatabaseCallable =
        callableFactory.createUnaryCallable(
            getAutonomousDatabaseTransportSettings,
            settings.getAutonomousDatabaseSettings(),
            clientContext);
    this.createAutonomousDatabaseCallable =
        callableFactory.createUnaryCallable(
            createAutonomousDatabaseTransportSettings,
            settings.createAutonomousDatabaseSettings(),
            clientContext);
    this.createAutonomousDatabaseOperationCallable =
        callableFactory.createOperationCallable(
            createAutonomousDatabaseTransportSettings,
            settings.createAutonomousDatabaseOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.updateAutonomousDatabaseCallable =
        callableFactory.createUnaryCallable(
            updateAutonomousDatabaseTransportSettings,
            settings.updateAutonomousDatabaseSettings(),
            clientContext);
    this.updateAutonomousDatabaseOperationCallable =
        callableFactory.createOperationCallable(
            updateAutonomousDatabaseTransportSettings,
            settings.updateAutonomousDatabaseOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.deleteAutonomousDatabaseCallable =
        callableFactory.createUnaryCallable(
            deleteAutonomousDatabaseTransportSettings,
            settings.deleteAutonomousDatabaseSettings(),
            clientContext);
    this.deleteAutonomousDatabaseOperationCallable =
        callableFactory.createOperationCallable(
            deleteAutonomousDatabaseTransportSettings,
            settings.deleteAutonomousDatabaseOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.restoreAutonomousDatabaseCallable =
        callableFactory.createUnaryCallable(
            restoreAutonomousDatabaseTransportSettings,
            settings.restoreAutonomousDatabaseSettings(),
            clientContext);
    this.restoreAutonomousDatabaseOperationCallable =
        callableFactory.createOperationCallable(
            restoreAutonomousDatabaseTransportSettings,
            settings.restoreAutonomousDatabaseOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.generateAutonomousDatabaseWalletCallable =
        callableFactory.createUnaryCallable(
            generateAutonomousDatabaseWalletTransportSettings,
            settings.generateAutonomousDatabaseWalletSettings(),
            clientContext);
    this.listAutonomousDbVersionsCallable =
        callableFactory.createUnaryCallable(
            listAutonomousDbVersionsTransportSettings,
            settings.listAutonomousDbVersionsSettings(),
            clientContext);
    this.listAutonomousDbVersionsPagedCallable =
        callableFactory.createPagedCallable(
            listAutonomousDbVersionsTransportSettings,
            settings.listAutonomousDbVersionsSettings(),
            clientContext);
    this.listAutonomousDatabaseCharacterSetsCallable =
        callableFactory.createUnaryCallable(
            listAutonomousDatabaseCharacterSetsTransportSettings,
            settings.listAutonomousDatabaseCharacterSetsSettings(),
            clientContext);
    this.listAutonomousDatabaseCharacterSetsPagedCallable =
        callableFactory.createPagedCallable(
            listAutonomousDatabaseCharacterSetsTransportSettings,
            settings.listAutonomousDatabaseCharacterSetsSettings(),
            clientContext);
    this.listAutonomousDatabaseBackupsCallable =
        callableFactory.createUnaryCallable(
            listAutonomousDatabaseBackupsTransportSettings,
            settings.listAutonomousDatabaseBackupsSettings(),
            clientContext);
    this.listAutonomousDatabaseBackupsPagedCallable =
        callableFactory.createPagedCallable(
            listAutonomousDatabaseBackupsTransportSettings,
            settings.listAutonomousDatabaseBackupsSettings(),
            clientContext);
    this.stopAutonomousDatabaseCallable =
        callableFactory.createUnaryCallable(
            stopAutonomousDatabaseTransportSettings,
            settings.stopAutonomousDatabaseSettings(),
            clientContext);
    this.stopAutonomousDatabaseOperationCallable =
        callableFactory.createOperationCallable(
            stopAutonomousDatabaseTransportSettings,
            settings.stopAutonomousDatabaseOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.startAutonomousDatabaseCallable =
        callableFactory.createUnaryCallable(
            startAutonomousDatabaseTransportSettings,
            settings.startAutonomousDatabaseSettings(),
            clientContext);
    this.startAutonomousDatabaseOperationCallable =
        callableFactory.createOperationCallable(
            startAutonomousDatabaseTransportSettings,
            settings.startAutonomousDatabaseOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.restartAutonomousDatabaseCallable =
        callableFactory.createUnaryCallable(
            restartAutonomousDatabaseTransportSettings,
            settings.restartAutonomousDatabaseSettings(),
            clientContext);
    this.restartAutonomousDatabaseOperationCallable =
        callableFactory.createOperationCallable(
            restartAutonomousDatabaseTransportSettings,
            settings.restartAutonomousDatabaseOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.switchoverAutonomousDatabaseCallable =
        callableFactory.createUnaryCallable(
            switchoverAutonomousDatabaseTransportSettings,
            settings.switchoverAutonomousDatabaseSettings(),
            clientContext);
    this.switchoverAutonomousDatabaseOperationCallable =
        callableFactory.createOperationCallable(
            switchoverAutonomousDatabaseTransportSettings,
            settings.switchoverAutonomousDatabaseOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.failoverAutonomousDatabaseCallable =
        callableFactory.createUnaryCallable(
            failoverAutonomousDatabaseTransportSettings,
            settings.failoverAutonomousDatabaseSettings(),
            clientContext);
    this.failoverAutonomousDatabaseOperationCallable =
        callableFactory.createOperationCallable(
            failoverAutonomousDatabaseTransportSettings,
            settings.failoverAutonomousDatabaseOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.listOdbNetworksCallable =
        callableFactory.createUnaryCallable(
            listOdbNetworksTransportSettings, settings.listOdbNetworksSettings(), clientContext);
    this.listOdbNetworksPagedCallable =
        callableFactory.createPagedCallable(
            listOdbNetworksTransportSettings, settings.listOdbNetworksSettings(), clientContext);
    this.getOdbNetworkCallable =
        callableFactory.createUnaryCallable(
            getOdbNetworkTransportSettings, settings.getOdbNetworkSettings(), clientContext);
    this.createOdbNetworkCallable =
        callableFactory.createUnaryCallable(
            createOdbNetworkTransportSettings, settings.createOdbNetworkSettings(), clientContext);
    this.createOdbNetworkOperationCallable =
        callableFactory.createOperationCallable(
            createOdbNetworkTransportSettings,
            settings.createOdbNetworkOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.deleteOdbNetworkCallable =
        callableFactory.createUnaryCallable(
            deleteOdbNetworkTransportSettings, settings.deleteOdbNetworkSettings(), clientContext);
    this.deleteOdbNetworkOperationCallable =
        callableFactory.createOperationCallable(
            deleteOdbNetworkTransportSettings,
            settings.deleteOdbNetworkOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.listOdbSubnetsCallable =
        callableFactory.createUnaryCallable(
            listOdbSubnetsTransportSettings, settings.listOdbSubnetsSettings(), clientContext);
    this.listOdbSubnetsPagedCallable =
        callableFactory.createPagedCallable(
            listOdbSubnetsTransportSettings, settings.listOdbSubnetsSettings(), clientContext);
    this.getOdbSubnetCallable =
        callableFactory.createUnaryCallable(
            getOdbSubnetTransportSettings, settings.getOdbSubnetSettings(), clientContext);
    this.createOdbSubnetCallable =
        callableFactory.createUnaryCallable(
            createOdbSubnetTransportSettings, settings.createOdbSubnetSettings(), clientContext);
    this.createOdbSubnetOperationCallable =
        callableFactory.createOperationCallable(
            createOdbSubnetTransportSettings,
            settings.createOdbSubnetOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.deleteOdbSubnetCallable =
        callableFactory.createUnaryCallable(
            deleteOdbSubnetTransportSettings, settings.deleteOdbSubnetSettings(), clientContext);
    this.deleteOdbSubnetOperationCallable =
        callableFactory.createOperationCallable(
            deleteOdbSubnetTransportSettings,
            settings.deleteOdbSubnetOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.listExadbVmClustersCallable =
        callableFactory.createUnaryCallable(
            listExadbVmClustersTransportSettings,
            settings.listExadbVmClustersSettings(),
            clientContext);
    this.listExadbVmClustersPagedCallable =
        callableFactory.createPagedCallable(
            listExadbVmClustersTransportSettings,
            settings.listExadbVmClustersSettings(),
            clientContext);
    this.getExadbVmClusterCallable =
        callableFactory.createUnaryCallable(
            getExadbVmClusterTransportSettings,
            settings.getExadbVmClusterSettings(),
            clientContext);
    this.createExadbVmClusterCallable =
        callableFactory.createUnaryCallable(
            createExadbVmClusterTransportSettings,
            settings.createExadbVmClusterSettings(),
            clientContext);
    this.createExadbVmClusterOperationCallable =
        callableFactory.createOperationCallable(
            createExadbVmClusterTransportSettings,
            settings.createExadbVmClusterOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.deleteExadbVmClusterCallable =
        callableFactory.createUnaryCallable(
            deleteExadbVmClusterTransportSettings,
            settings.deleteExadbVmClusterSettings(),
            clientContext);
    this.deleteExadbVmClusterOperationCallable =
        callableFactory.createOperationCallable(
            deleteExadbVmClusterTransportSettings,
            settings.deleteExadbVmClusterOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.updateExadbVmClusterCallable =
        callableFactory.createUnaryCallable(
            updateExadbVmClusterTransportSettings,
            settings.updateExadbVmClusterSettings(),
            clientContext);
    this.updateExadbVmClusterOperationCallable =
        callableFactory.createOperationCallable(
            updateExadbVmClusterTransportSettings,
            settings.updateExadbVmClusterOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.removeVirtualMachineExadbVmClusterCallable =
        callableFactory.createUnaryCallable(
            removeVirtualMachineExadbVmClusterTransportSettings,
            settings.removeVirtualMachineExadbVmClusterSettings(),
            clientContext);
    this.removeVirtualMachineExadbVmClusterOperationCallable =
        callableFactory.createOperationCallable(
            removeVirtualMachineExadbVmClusterTransportSettings,
            settings.removeVirtualMachineExadbVmClusterOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.listExascaleDbStorageVaultsCallable =
        callableFactory.createUnaryCallable(
            listExascaleDbStorageVaultsTransportSettings,
            settings.listExascaleDbStorageVaultsSettings(),
            clientContext);
    this.listExascaleDbStorageVaultsPagedCallable =
        callableFactory.createPagedCallable(
            listExascaleDbStorageVaultsTransportSettings,
            settings.listExascaleDbStorageVaultsSettings(),
            clientContext);
    this.getExascaleDbStorageVaultCallable =
        callableFactory.createUnaryCallable(
            getExascaleDbStorageVaultTransportSettings,
            settings.getExascaleDbStorageVaultSettings(),
            clientContext);
    this.createExascaleDbStorageVaultCallable =
        callableFactory.createUnaryCallable(
            createExascaleDbStorageVaultTransportSettings,
            settings.createExascaleDbStorageVaultSettings(),
            clientContext);
    this.createExascaleDbStorageVaultOperationCallable =
        callableFactory.createOperationCallable(
            createExascaleDbStorageVaultTransportSettings,
            settings.createExascaleDbStorageVaultOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.deleteExascaleDbStorageVaultCallable =
        callableFactory.createUnaryCallable(
            deleteExascaleDbStorageVaultTransportSettings,
            settings.deleteExascaleDbStorageVaultSettings(),
            clientContext);
    this.deleteExascaleDbStorageVaultOperationCallable =
        callableFactory.createOperationCallable(
            deleteExascaleDbStorageVaultTransportSettings,
            settings.deleteExascaleDbStorageVaultOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.listDbSystemInitialStorageSizesCallable =
        callableFactory.createUnaryCallable(
            listDbSystemInitialStorageSizesTransportSettings,
            settings.listDbSystemInitialStorageSizesSettings(),
            clientContext);
    this.listDbSystemInitialStorageSizesPagedCallable =
        callableFactory.createPagedCallable(
            listDbSystemInitialStorageSizesTransportSettings,
            settings.listDbSystemInitialStorageSizesSettings(),
            clientContext);
    this.listDatabasesCallable =
        callableFactory.createUnaryCallable(
            listDatabasesTransportSettings, settings.listDatabasesSettings(), clientContext);
    this.listDatabasesPagedCallable =
        callableFactory.createPagedCallable(
            listDatabasesTransportSettings, settings.listDatabasesSettings(), clientContext);
    this.getDatabaseCallable =
        callableFactory.createUnaryCallable(
            getDatabaseTransportSettings, settings.getDatabaseSettings(), clientContext);
    this.listPluggableDatabasesCallable =
        callableFactory.createUnaryCallable(
            listPluggableDatabasesTransportSettings,
            settings.listPluggableDatabasesSettings(),
            clientContext);
    this.listPluggableDatabasesPagedCallable =
        callableFactory.createPagedCallable(
            listPluggableDatabasesTransportSettings,
            settings.listPluggableDatabasesSettings(),
            clientContext);
    this.getPluggableDatabaseCallable =
        callableFactory.createUnaryCallable(
            getPluggableDatabaseTransportSettings,
            settings.getPluggableDatabaseSettings(),
            clientContext);
    this.listDbSystemsCallable =
        callableFactory.createUnaryCallable(
            listDbSystemsTransportSettings, settings.listDbSystemsSettings(), clientContext);
    this.listDbSystemsPagedCallable =
        callableFactory.createPagedCallable(
            listDbSystemsTransportSettings, settings.listDbSystemsSettings(), clientContext);
    this.getDbSystemCallable =
        callableFactory.createUnaryCallable(
            getDbSystemTransportSettings, settings.getDbSystemSettings(), clientContext);
    this.createDbSystemCallable =
        callableFactory.createUnaryCallable(
            createDbSystemTransportSettings, settings.createDbSystemSettings(), clientContext);
    this.createDbSystemOperationCallable =
        callableFactory.createOperationCallable(
            createDbSystemTransportSettings,
            settings.createDbSystemOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.deleteDbSystemCallable =
        callableFactory.createUnaryCallable(
            deleteDbSystemTransportSettings, settings.deleteDbSystemSettings(), clientContext);
    this.deleteDbSystemOperationCallable =
        callableFactory.createOperationCallable(
            deleteDbSystemTransportSettings,
            settings.deleteDbSystemOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.listDbVersionsCallable =
        callableFactory.createUnaryCallable(
            listDbVersionsTransportSettings, settings.listDbVersionsSettings(), clientContext);
    this.listDbVersionsPagedCallable =
        callableFactory.createPagedCallable(
            listDbVersionsTransportSettings, settings.listDbVersionsSettings(), clientContext);
    this.listDatabaseCharacterSetsCallable =
        callableFactory.createUnaryCallable(
            listDatabaseCharacterSetsTransportSettings,
            settings.listDatabaseCharacterSetsSettings(),
            clientContext);
    this.listDatabaseCharacterSetsPagedCallable =
        callableFactory.createPagedCallable(
            listDatabaseCharacterSetsTransportSettings,
            settings.listDatabaseCharacterSetsSettings(),
            clientContext);
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
    methodDescriptors.add(listCloudExadataInfrastructuresMethodDescriptor);
    methodDescriptors.add(getCloudExadataInfrastructureMethodDescriptor);
    methodDescriptors.add(createCloudExadataInfrastructureMethodDescriptor);
    methodDescriptors.add(deleteCloudExadataInfrastructureMethodDescriptor);
    methodDescriptors.add(listCloudVmClustersMethodDescriptor);
    methodDescriptors.add(getCloudVmClusterMethodDescriptor);
    methodDescriptors.add(createCloudVmClusterMethodDescriptor);
    methodDescriptors.add(deleteCloudVmClusterMethodDescriptor);
    methodDescriptors.add(listEntitlementsMethodDescriptor);
    methodDescriptors.add(listDbServersMethodDescriptor);
    methodDescriptors.add(listDbNodesMethodDescriptor);
    methodDescriptors.add(listGiVersionsMethodDescriptor);
    methodDescriptors.add(listMinorVersionsMethodDescriptor);
    methodDescriptors.add(listDbSystemShapesMethodDescriptor);
    methodDescriptors.add(listAutonomousDatabasesMethodDescriptor);
    methodDescriptors.add(getAutonomousDatabaseMethodDescriptor);
    methodDescriptors.add(createAutonomousDatabaseMethodDescriptor);
    methodDescriptors.add(updateAutonomousDatabaseMethodDescriptor);
    methodDescriptors.add(deleteAutonomousDatabaseMethodDescriptor);
    methodDescriptors.add(restoreAutonomousDatabaseMethodDescriptor);
    methodDescriptors.add(generateAutonomousDatabaseWalletMethodDescriptor);
    methodDescriptors.add(listAutonomousDbVersionsMethodDescriptor);
    methodDescriptors.add(listAutonomousDatabaseCharacterSetsMethodDescriptor);
    methodDescriptors.add(listAutonomousDatabaseBackupsMethodDescriptor);
    methodDescriptors.add(stopAutonomousDatabaseMethodDescriptor);
    methodDescriptors.add(startAutonomousDatabaseMethodDescriptor);
    methodDescriptors.add(restartAutonomousDatabaseMethodDescriptor);
    methodDescriptors.add(switchoverAutonomousDatabaseMethodDescriptor);
    methodDescriptors.add(failoverAutonomousDatabaseMethodDescriptor);
    methodDescriptors.add(listOdbNetworksMethodDescriptor);
    methodDescriptors.add(getOdbNetworkMethodDescriptor);
    methodDescriptors.add(createOdbNetworkMethodDescriptor);
    methodDescriptors.add(deleteOdbNetworkMethodDescriptor);
    methodDescriptors.add(listOdbSubnetsMethodDescriptor);
    methodDescriptors.add(getOdbSubnetMethodDescriptor);
    methodDescriptors.add(createOdbSubnetMethodDescriptor);
    methodDescriptors.add(deleteOdbSubnetMethodDescriptor);
    methodDescriptors.add(listExadbVmClustersMethodDescriptor);
    methodDescriptors.add(getExadbVmClusterMethodDescriptor);
    methodDescriptors.add(createExadbVmClusterMethodDescriptor);
    methodDescriptors.add(deleteExadbVmClusterMethodDescriptor);
    methodDescriptors.add(updateExadbVmClusterMethodDescriptor);
    methodDescriptors.add(removeVirtualMachineExadbVmClusterMethodDescriptor);
    methodDescriptors.add(listExascaleDbStorageVaultsMethodDescriptor);
    methodDescriptors.add(getExascaleDbStorageVaultMethodDescriptor);
    methodDescriptors.add(createExascaleDbStorageVaultMethodDescriptor);
    methodDescriptors.add(deleteExascaleDbStorageVaultMethodDescriptor);
    methodDescriptors.add(listDbSystemInitialStorageSizesMethodDescriptor);
    methodDescriptors.add(listDatabasesMethodDescriptor);
    methodDescriptors.add(getDatabaseMethodDescriptor);
    methodDescriptors.add(listPluggableDatabasesMethodDescriptor);
    methodDescriptors.add(getPluggableDatabaseMethodDescriptor);
    methodDescriptors.add(listDbSystemsMethodDescriptor);
    methodDescriptors.add(getDbSystemMethodDescriptor);
    methodDescriptors.add(createDbSystemMethodDescriptor);
    methodDescriptors.add(deleteDbSystemMethodDescriptor);
    methodDescriptors.add(listDbVersionsMethodDescriptor);
    methodDescriptors.add(listDatabaseCharacterSetsMethodDescriptor);
    methodDescriptors.add(listLocationsMethodDescriptor);
    methodDescriptors.add(getLocationMethodDescriptor);
    return methodDescriptors;
  }

  public HttpJsonOperationsStub getHttpJsonOperationsStub() {
    return httpJsonOperationsStub;
  }

  @Override
  public UnaryCallable<
          ListCloudExadataInfrastructuresRequest, ListCloudExadataInfrastructuresResponse>
      listCloudExadataInfrastructuresCallable() {
    return listCloudExadataInfrastructuresCallable;
  }

  @Override
  public UnaryCallable<
          ListCloudExadataInfrastructuresRequest, ListCloudExadataInfrastructuresPagedResponse>
      listCloudExadataInfrastructuresPagedCallable() {
    return listCloudExadataInfrastructuresPagedCallable;
  }

  @Override
  public UnaryCallable<GetCloudExadataInfrastructureRequest, CloudExadataInfrastructure>
      getCloudExadataInfrastructureCallable() {
    return getCloudExadataInfrastructureCallable;
  }

  @Override
  public UnaryCallable<CreateCloudExadataInfrastructureRequest, Operation>
      createCloudExadataInfrastructureCallable() {
    return createCloudExadataInfrastructureCallable;
  }

  @Override
  public OperationCallable<
          CreateCloudExadataInfrastructureRequest, CloudExadataInfrastructure, OperationMetadata>
      createCloudExadataInfrastructureOperationCallable() {
    return createCloudExadataInfrastructureOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteCloudExadataInfrastructureRequest, Operation>
      deleteCloudExadataInfrastructureCallable() {
    return deleteCloudExadataInfrastructureCallable;
  }

  @Override
  public OperationCallable<DeleteCloudExadataInfrastructureRequest, Empty, OperationMetadata>
      deleteCloudExadataInfrastructureOperationCallable() {
    return deleteCloudExadataInfrastructureOperationCallable;
  }

  @Override
  public UnaryCallable<ListCloudVmClustersRequest, ListCloudVmClustersResponse>
      listCloudVmClustersCallable() {
    return listCloudVmClustersCallable;
  }

  @Override
  public UnaryCallable<ListCloudVmClustersRequest, ListCloudVmClustersPagedResponse>
      listCloudVmClustersPagedCallable() {
    return listCloudVmClustersPagedCallable;
  }

  @Override
  public UnaryCallable<GetCloudVmClusterRequest, CloudVmCluster> getCloudVmClusterCallable() {
    return getCloudVmClusterCallable;
  }

  @Override
  public UnaryCallable<CreateCloudVmClusterRequest, Operation> createCloudVmClusterCallable() {
    return createCloudVmClusterCallable;
  }

  @Override
  public OperationCallable<CreateCloudVmClusterRequest, CloudVmCluster, OperationMetadata>
      createCloudVmClusterOperationCallable() {
    return createCloudVmClusterOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteCloudVmClusterRequest, Operation> deleteCloudVmClusterCallable() {
    return deleteCloudVmClusterCallable;
  }

  @Override
  public OperationCallable<DeleteCloudVmClusterRequest, Empty, OperationMetadata>
      deleteCloudVmClusterOperationCallable() {
    return deleteCloudVmClusterOperationCallable;
  }

  @Override
  public UnaryCallable<ListEntitlementsRequest, ListEntitlementsResponse>
      listEntitlementsCallable() {
    return listEntitlementsCallable;
  }

  @Override
  public UnaryCallable<ListEntitlementsRequest, ListEntitlementsPagedResponse>
      listEntitlementsPagedCallable() {
    return listEntitlementsPagedCallable;
  }

  @Override
  public UnaryCallable<ListDbServersRequest, ListDbServersResponse> listDbServersCallable() {
    return listDbServersCallable;
  }

  @Override
  public UnaryCallable<ListDbServersRequest, ListDbServersPagedResponse>
      listDbServersPagedCallable() {
    return listDbServersPagedCallable;
  }

  @Override
  public UnaryCallable<ListDbNodesRequest, ListDbNodesResponse> listDbNodesCallable() {
    return listDbNodesCallable;
  }

  @Override
  public UnaryCallable<ListDbNodesRequest, ListDbNodesPagedResponse> listDbNodesPagedCallable() {
    return listDbNodesPagedCallable;
  }

  @Override
  public UnaryCallable<ListGiVersionsRequest, ListGiVersionsResponse> listGiVersionsCallable() {
    return listGiVersionsCallable;
  }

  @Override
  public UnaryCallable<ListGiVersionsRequest, ListGiVersionsPagedResponse>
      listGiVersionsPagedCallable() {
    return listGiVersionsPagedCallable;
  }

  @Override
  public UnaryCallable<ListMinorVersionsRequest, ListMinorVersionsResponse>
      listMinorVersionsCallable() {
    return listMinorVersionsCallable;
  }

  @Override
  public UnaryCallable<ListMinorVersionsRequest, ListMinorVersionsPagedResponse>
      listMinorVersionsPagedCallable() {
    return listMinorVersionsPagedCallable;
  }

  @Override
  public UnaryCallable<ListDbSystemShapesRequest, ListDbSystemShapesResponse>
      listDbSystemShapesCallable() {
    return listDbSystemShapesCallable;
  }

  @Override
  public UnaryCallable<ListDbSystemShapesRequest, ListDbSystemShapesPagedResponse>
      listDbSystemShapesPagedCallable() {
    return listDbSystemShapesPagedCallable;
  }

  @Override
  public UnaryCallable<ListAutonomousDatabasesRequest, ListAutonomousDatabasesResponse>
      listAutonomousDatabasesCallable() {
    return listAutonomousDatabasesCallable;
  }

  @Override
  public UnaryCallable<ListAutonomousDatabasesRequest, ListAutonomousDatabasesPagedResponse>
      listAutonomousDatabasesPagedCallable() {
    return listAutonomousDatabasesPagedCallable;
  }

  @Override
  public UnaryCallable<GetAutonomousDatabaseRequest, AutonomousDatabase>
      getAutonomousDatabaseCallable() {
    return getAutonomousDatabaseCallable;
  }

  @Override
  public UnaryCallable<CreateAutonomousDatabaseRequest, Operation>
      createAutonomousDatabaseCallable() {
    return createAutonomousDatabaseCallable;
  }

  @Override
  public OperationCallable<CreateAutonomousDatabaseRequest, AutonomousDatabase, OperationMetadata>
      createAutonomousDatabaseOperationCallable() {
    return createAutonomousDatabaseOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateAutonomousDatabaseRequest, Operation>
      updateAutonomousDatabaseCallable() {
    return updateAutonomousDatabaseCallable;
  }

  @Override
  public OperationCallable<UpdateAutonomousDatabaseRequest, AutonomousDatabase, OperationMetadata>
      updateAutonomousDatabaseOperationCallable() {
    return updateAutonomousDatabaseOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteAutonomousDatabaseRequest, Operation>
      deleteAutonomousDatabaseCallable() {
    return deleteAutonomousDatabaseCallable;
  }

  @Override
  public OperationCallable<DeleteAutonomousDatabaseRequest, Empty, OperationMetadata>
      deleteAutonomousDatabaseOperationCallable() {
    return deleteAutonomousDatabaseOperationCallable;
  }

  @Override
  public UnaryCallable<RestoreAutonomousDatabaseRequest, Operation>
      restoreAutonomousDatabaseCallable() {
    return restoreAutonomousDatabaseCallable;
  }

  @Override
  public OperationCallable<RestoreAutonomousDatabaseRequest, AutonomousDatabase, OperationMetadata>
      restoreAutonomousDatabaseOperationCallable() {
    return restoreAutonomousDatabaseOperationCallable;
  }

  @Override
  public UnaryCallable<
          GenerateAutonomousDatabaseWalletRequest, GenerateAutonomousDatabaseWalletResponse>
      generateAutonomousDatabaseWalletCallable() {
    return generateAutonomousDatabaseWalletCallable;
  }

  @Override
  public UnaryCallable<ListAutonomousDbVersionsRequest, ListAutonomousDbVersionsResponse>
      listAutonomousDbVersionsCallable() {
    return listAutonomousDbVersionsCallable;
  }

  @Override
  public UnaryCallable<ListAutonomousDbVersionsRequest, ListAutonomousDbVersionsPagedResponse>
      listAutonomousDbVersionsPagedCallable() {
    return listAutonomousDbVersionsPagedCallable;
  }

  @Override
  public UnaryCallable<
          ListAutonomousDatabaseCharacterSetsRequest, ListAutonomousDatabaseCharacterSetsResponse>
      listAutonomousDatabaseCharacterSetsCallable() {
    return listAutonomousDatabaseCharacterSetsCallable;
  }

  @Override
  public UnaryCallable<
          ListAutonomousDatabaseCharacterSetsRequest,
          ListAutonomousDatabaseCharacterSetsPagedResponse>
      listAutonomousDatabaseCharacterSetsPagedCallable() {
    return listAutonomousDatabaseCharacterSetsPagedCallable;
  }

  @Override
  public UnaryCallable<ListAutonomousDatabaseBackupsRequest, ListAutonomousDatabaseBackupsResponse>
      listAutonomousDatabaseBackupsCallable() {
    return listAutonomousDatabaseBackupsCallable;
  }

  @Override
  public UnaryCallable<
          ListAutonomousDatabaseBackupsRequest, ListAutonomousDatabaseBackupsPagedResponse>
      listAutonomousDatabaseBackupsPagedCallable() {
    return listAutonomousDatabaseBackupsPagedCallable;
  }

  @Override
  public UnaryCallable<StopAutonomousDatabaseRequest, Operation> stopAutonomousDatabaseCallable() {
    return stopAutonomousDatabaseCallable;
  }

  @Override
  public OperationCallable<StopAutonomousDatabaseRequest, AutonomousDatabase, OperationMetadata>
      stopAutonomousDatabaseOperationCallable() {
    return stopAutonomousDatabaseOperationCallable;
  }

  @Override
  public UnaryCallable<StartAutonomousDatabaseRequest, Operation>
      startAutonomousDatabaseCallable() {
    return startAutonomousDatabaseCallable;
  }

  @Override
  public OperationCallable<StartAutonomousDatabaseRequest, AutonomousDatabase, OperationMetadata>
      startAutonomousDatabaseOperationCallable() {
    return startAutonomousDatabaseOperationCallable;
  }

  @Override
  public UnaryCallable<RestartAutonomousDatabaseRequest, Operation>
      restartAutonomousDatabaseCallable() {
    return restartAutonomousDatabaseCallable;
  }

  @Override
  public OperationCallable<RestartAutonomousDatabaseRequest, AutonomousDatabase, OperationMetadata>
      restartAutonomousDatabaseOperationCallable() {
    return restartAutonomousDatabaseOperationCallable;
  }

  @Override
  public UnaryCallable<SwitchoverAutonomousDatabaseRequest, Operation>
      switchoverAutonomousDatabaseCallable() {
    return switchoverAutonomousDatabaseCallable;
  }

  @Override
  public OperationCallable<
          SwitchoverAutonomousDatabaseRequest, AutonomousDatabase, OperationMetadata>
      switchoverAutonomousDatabaseOperationCallable() {
    return switchoverAutonomousDatabaseOperationCallable;
  }

  @Override
  public UnaryCallable<FailoverAutonomousDatabaseRequest, Operation>
      failoverAutonomousDatabaseCallable() {
    return failoverAutonomousDatabaseCallable;
  }

  @Override
  public OperationCallable<FailoverAutonomousDatabaseRequest, AutonomousDatabase, OperationMetadata>
      failoverAutonomousDatabaseOperationCallable() {
    return failoverAutonomousDatabaseOperationCallable;
  }

  @Override
  public UnaryCallable<ListOdbNetworksRequest, ListOdbNetworksResponse> listOdbNetworksCallable() {
    return listOdbNetworksCallable;
  }

  @Override
  public UnaryCallable<ListOdbNetworksRequest, ListOdbNetworksPagedResponse>
      listOdbNetworksPagedCallable() {
    return listOdbNetworksPagedCallable;
  }

  @Override
  public UnaryCallable<GetOdbNetworkRequest, OdbNetwork> getOdbNetworkCallable() {
    return getOdbNetworkCallable;
  }

  @Override
  public UnaryCallable<CreateOdbNetworkRequest, Operation> createOdbNetworkCallable() {
    return createOdbNetworkCallable;
  }

  @Override
  public OperationCallable<CreateOdbNetworkRequest, OdbNetwork, OperationMetadata>
      createOdbNetworkOperationCallable() {
    return createOdbNetworkOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteOdbNetworkRequest, Operation> deleteOdbNetworkCallable() {
    return deleteOdbNetworkCallable;
  }

  @Override
  public OperationCallable<DeleteOdbNetworkRequest, Empty, OperationMetadata>
      deleteOdbNetworkOperationCallable() {
    return deleteOdbNetworkOperationCallable;
  }

  @Override
  public UnaryCallable<ListOdbSubnetsRequest, ListOdbSubnetsResponse> listOdbSubnetsCallable() {
    return listOdbSubnetsCallable;
  }

  @Override
  public UnaryCallable<ListOdbSubnetsRequest, ListOdbSubnetsPagedResponse>
      listOdbSubnetsPagedCallable() {
    return listOdbSubnetsPagedCallable;
  }

  @Override
  public UnaryCallable<GetOdbSubnetRequest, OdbSubnet> getOdbSubnetCallable() {
    return getOdbSubnetCallable;
  }

  @Override
  public UnaryCallable<CreateOdbSubnetRequest, Operation> createOdbSubnetCallable() {
    return createOdbSubnetCallable;
  }

  @Override
  public OperationCallable<CreateOdbSubnetRequest, OdbSubnet, OperationMetadata>
      createOdbSubnetOperationCallable() {
    return createOdbSubnetOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteOdbSubnetRequest, Operation> deleteOdbSubnetCallable() {
    return deleteOdbSubnetCallable;
  }

  @Override
  public OperationCallable<DeleteOdbSubnetRequest, Empty, OperationMetadata>
      deleteOdbSubnetOperationCallable() {
    return deleteOdbSubnetOperationCallable;
  }

  @Override
  public UnaryCallable<ListExadbVmClustersRequest, ListExadbVmClustersResponse>
      listExadbVmClustersCallable() {
    return listExadbVmClustersCallable;
  }

  @Override
  public UnaryCallable<ListExadbVmClustersRequest, ListExadbVmClustersPagedResponse>
      listExadbVmClustersPagedCallable() {
    return listExadbVmClustersPagedCallable;
  }

  @Override
  public UnaryCallable<GetExadbVmClusterRequest, ExadbVmCluster> getExadbVmClusterCallable() {
    return getExadbVmClusterCallable;
  }

  @Override
  public UnaryCallable<CreateExadbVmClusterRequest, Operation> createExadbVmClusterCallable() {
    return createExadbVmClusterCallable;
  }

  @Override
  public OperationCallable<CreateExadbVmClusterRequest, ExadbVmCluster, OperationMetadata>
      createExadbVmClusterOperationCallable() {
    return createExadbVmClusterOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteExadbVmClusterRequest, Operation> deleteExadbVmClusterCallable() {
    return deleteExadbVmClusterCallable;
  }

  @Override
  public OperationCallable<DeleteExadbVmClusterRequest, Empty, OperationMetadata>
      deleteExadbVmClusterOperationCallable() {
    return deleteExadbVmClusterOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateExadbVmClusterRequest, Operation> updateExadbVmClusterCallable() {
    return updateExadbVmClusterCallable;
  }

  @Override
  public OperationCallable<UpdateExadbVmClusterRequest, ExadbVmCluster, OperationMetadata>
      updateExadbVmClusterOperationCallable() {
    return updateExadbVmClusterOperationCallable;
  }

  @Override
  public UnaryCallable<RemoveVirtualMachineExadbVmClusterRequest, Operation>
      removeVirtualMachineExadbVmClusterCallable() {
    return removeVirtualMachineExadbVmClusterCallable;
  }

  @Override
  public OperationCallable<
          RemoveVirtualMachineExadbVmClusterRequest, ExadbVmCluster, OperationMetadata>
      removeVirtualMachineExadbVmClusterOperationCallable() {
    return removeVirtualMachineExadbVmClusterOperationCallable;
  }

  @Override
  public UnaryCallable<ListExascaleDbStorageVaultsRequest, ListExascaleDbStorageVaultsResponse>
      listExascaleDbStorageVaultsCallable() {
    return listExascaleDbStorageVaultsCallable;
  }

  @Override
  public UnaryCallable<ListExascaleDbStorageVaultsRequest, ListExascaleDbStorageVaultsPagedResponse>
      listExascaleDbStorageVaultsPagedCallable() {
    return listExascaleDbStorageVaultsPagedCallable;
  }

  @Override
  public UnaryCallable<GetExascaleDbStorageVaultRequest, ExascaleDbStorageVault>
      getExascaleDbStorageVaultCallable() {
    return getExascaleDbStorageVaultCallable;
  }

  @Override
  public UnaryCallable<CreateExascaleDbStorageVaultRequest, Operation>
      createExascaleDbStorageVaultCallable() {
    return createExascaleDbStorageVaultCallable;
  }

  @Override
  public OperationCallable<
          CreateExascaleDbStorageVaultRequest, ExascaleDbStorageVault, OperationMetadata>
      createExascaleDbStorageVaultOperationCallable() {
    return createExascaleDbStorageVaultOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteExascaleDbStorageVaultRequest, Operation>
      deleteExascaleDbStorageVaultCallable() {
    return deleteExascaleDbStorageVaultCallable;
  }

  @Override
  public OperationCallable<DeleteExascaleDbStorageVaultRequest, Empty, OperationMetadata>
      deleteExascaleDbStorageVaultOperationCallable() {
    return deleteExascaleDbStorageVaultOperationCallable;
  }

  @Override
  public UnaryCallable<
          ListDbSystemInitialStorageSizesRequest, ListDbSystemInitialStorageSizesResponse>
      listDbSystemInitialStorageSizesCallable() {
    return listDbSystemInitialStorageSizesCallable;
  }

  @Override
  public UnaryCallable<
          ListDbSystemInitialStorageSizesRequest, ListDbSystemInitialStorageSizesPagedResponse>
      listDbSystemInitialStorageSizesPagedCallable() {
    return listDbSystemInitialStorageSizesPagedCallable;
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
  public UnaryCallable<GetDatabaseRequest, Database> getDatabaseCallable() {
    return getDatabaseCallable;
  }

  @Override
  public UnaryCallable<ListPluggableDatabasesRequest, ListPluggableDatabasesResponse>
      listPluggableDatabasesCallable() {
    return listPluggableDatabasesCallable;
  }

  @Override
  public UnaryCallable<ListPluggableDatabasesRequest, ListPluggableDatabasesPagedResponse>
      listPluggableDatabasesPagedCallable() {
    return listPluggableDatabasesPagedCallable;
  }

  @Override
  public UnaryCallable<GetPluggableDatabaseRequest, PluggableDatabase>
      getPluggableDatabaseCallable() {
    return getPluggableDatabaseCallable;
  }

  @Override
  public UnaryCallable<ListDbSystemsRequest, ListDbSystemsResponse> listDbSystemsCallable() {
    return listDbSystemsCallable;
  }

  @Override
  public UnaryCallable<ListDbSystemsRequest, ListDbSystemsPagedResponse>
      listDbSystemsPagedCallable() {
    return listDbSystemsPagedCallable;
  }

  @Override
  public UnaryCallable<GetDbSystemRequest, DbSystem> getDbSystemCallable() {
    return getDbSystemCallable;
  }

  @Override
  public UnaryCallable<CreateDbSystemRequest, Operation> createDbSystemCallable() {
    return createDbSystemCallable;
  }

  @Override
  public OperationCallable<CreateDbSystemRequest, DbSystem, OperationMetadata>
      createDbSystemOperationCallable() {
    return createDbSystemOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteDbSystemRequest, Operation> deleteDbSystemCallable() {
    return deleteDbSystemCallable;
  }

  @Override
  public OperationCallable<DeleteDbSystemRequest, Empty, OperationMetadata>
      deleteDbSystemOperationCallable() {
    return deleteDbSystemOperationCallable;
  }

  @Override
  public UnaryCallable<ListDbVersionsRequest, ListDbVersionsResponse> listDbVersionsCallable() {
    return listDbVersionsCallable;
  }

  @Override
  public UnaryCallable<ListDbVersionsRequest, ListDbVersionsPagedResponse>
      listDbVersionsPagedCallable() {
    return listDbVersionsPagedCallable;
  }

  @Override
  public UnaryCallable<ListDatabaseCharacterSetsRequest, ListDatabaseCharacterSetsResponse>
      listDatabaseCharacterSetsCallable() {
    return listDatabaseCharacterSetsCallable;
  }

  @Override
  public UnaryCallable<ListDatabaseCharacterSetsRequest, ListDatabaseCharacterSetsPagedResponse>
      listDatabaseCharacterSetsPagedCallable() {
    return listDatabaseCharacterSetsPagedCallable;
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
