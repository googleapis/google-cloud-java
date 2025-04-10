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
import static com.google.cloud.oracledatabase.v1.OracleDatabaseClient.ListDbNodesPagedResponse;
import static com.google.cloud.oracledatabase.v1.OracleDatabaseClient.ListDbServersPagedResponse;
import static com.google.cloud.oracledatabase.v1.OracleDatabaseClient.ListDbSystemShapesPagedResponse;
import static com.google.cloud.oracledatabase.v1.OracleDatabaseClient.ListEntitlementsPagedResponse;
import static com.google.cloud.oracledatabase.v1.OracleDatabaseClient.ListGiVersionsPagedResponse;
import static com.google.cloud.oracledatabase.v1.OracleDatabaseClient.ListLocationsPagedResponse;

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
import com.google.cloud.oracledatabase.v1.DeleteAutonomousDatabaseRequest;
import com.google.cloud.oracledatabase.v1.DeleteCloudExadataInfrastructureRequest;
import com.google.cloud.oracledatabase.v1.DeleteCloudVmClusterRequest;
import com.google.cloud.oracledatabase.v1.GenerateAutonomousDatabaseWalletRequest;
import com.google.cloud.oracledatabase.v1.GenerateAutonomousDatabaseWalletResponse;
import com.google.cloud.oracledatabase.v1.GetAutonomousDatabaseRequest;
import com.google.cloud.oracledatabase.v1.GetCloudExadataInfrastructureRequest;
import com.google.cloud.oracledatabase.v1.GetCloudVmClusterRequest;
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
import com.google.cloud.oracledatabase.v1.ListDbNodesRequest;
import com.google.cloud.oracledatabase.v1.ListDbNodesResponse;
import com.google.cloud.oracledatabase.v1.ListDbServersRequest;
import com.google.cloud.oracledatabase.v1.ListDbServersResponse;
import com.google.cloud.oracledatabase.v1.ListDbSystemShapesRequest;
import com.google.cloud.oracledatabase.v1.ListDbSystemShapesResponse;
import com.google.cloud.oracledatabase.v1.ListEntitlementsRequest;
import com.google.cloud.oracledatabase.v1.ListEntitlementsResponse;
import com.google.cloud.oracledatabase.v1.ListGiVersionsRequest;
import com.google.cloud.oracledatabase.v1.ListGiVersionsResponse;
import com.google.cloud.oracledatabase.v1.OperationMetadata;
import com.google.cloud.oracledatabase.v1.RestartAutonomousDatabaseRequest;
import com.google.cloud.oracledatabase.v1.RestoreAutonomousDatabaseRequest;
import com.google.cloud.oracledatabase.v1.StartAutonomousDatabaseRequest;
import com.google.cloud.oracledatabase.v1.StopAutonomousDatabaseRequest;
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
          .add(AutonomousDatabase.getDescriptor())
          .add(CloudExadataInfrastructure.getDescriptor())
          .add(OperationMetadata.getDescriptor())
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
        OracleDatabaseStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonOracleDatabaseStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonOracleDatabaseStub(
        OracleDatabaseStubSettings.newBuilder().build(), clientContext, callableFactory);
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
    methodDescriptors.add(listDbSystemShapesMethodDescriptor);
    methodDescriptors.add(listAutonomousDatabasesMethodDescriptor);
    methodDescriptors.add(getAutonomousDatabaseMethodDescriptor);
    methodDescriptors.add(createAutonomousDatabaseMethodDescriptor);
    methodDescriptors.add(deleteAutonomousDatabaseMethodDescriptor);
    methodDescriptors.add(restoreAutonomousDatabaseMethodDescriptor);
    methodDescriptors.add(generateAutonomousDatabaseWalletMethodDescriptor);
    methodDescriptors.add(listAutonomousDbVersionsMethodDescriptor);
    methodDescriptors.add(listAutonomousDatabaseCharacterSetsMethodDescriptor);
    methodDescriptors.add(listAutonomousDatabaseBackupsMethodDescriptor);
    methodDescriptors.add(stopAutonomousDatabaseMethodDescriptor);
    methodDescriptors.add(startAutonomousDatabaseMethodDescriptor);
    methodDescriptors.add(restartAutonomousDatabaseMethodDescriptor);
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
