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

package com.google.cloud.edgecontainer.v1.stub;

import static com.google.cloud.edgecontainer.v1.EdgeContainerClient.ListClustersPagedResponse;
import static com.google.cloud.edgecontainer.v1.EdgeContainerClient.ListMachinesPagedResponse;
import static com.google.cloud.edgecontainer.v1.EdgeContainerClient.ListNodePoolsPagedResponse;
import static com.google.cloud.edgecontainer.v1.EdgeContainerClient.ListVpnConnectionsPagedResponse;

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
import com.google.api.gax.longrunning.OperationSnapshot;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.edgecontainer.v1.Cluster;
import com.google.cloud.edgecontainer.v1.CreateClusterRequest;
import com.google.cloud.edgecontainer.v1.CreateNodePoolRequest;
import com.google.cloud.edgecontainer.v1.CreateVpnConnectionRequest;
import com.google.cloud.edgecontainer.v1.DeleteClusterRequest;
import com.google.cloud.edgecontainer.v1.DeleteNodePoolRequest;
import com.google.cloud.edgecontainer.v1.DeleteVpnConnectionRequest;
import com.google.cloud.edgecontainer.v1.GenerateAccessTokenRequest;
import com.google.cloud.edgecontainer.v1.GenerateAccessTokenResponse;
import com.google.cloud.edgecontainer.v1.GetClusterRequest;
import com.google.cloud.edgecontainer.v1.GetMachineRequest;
import com.google.cloud.edgecontainer.v1.GetNodePoolRequest;
import com.google.cloud.edgecontainer.v1.GetVpnConnectionRequest;
import com.google.cloud.edgecontainer.v1.ListClustersRequest;
import com.google.cloud.edgecontainer.v1.ListClustersResponse;
import com.google.cloud.edgecontainer.v1.ListMachinesRequest;
import com.google.cloud.edgecontainer.v1.ListMachinesResponse;
import com.google.cloud.edgecontainer.v1.ListNodePoolsRequest;
import com.google.cloud.edgecontainer.v1.ListNodePoolsResponse;
import com.google.cloud.edgecontainer.v1.ListVpnConnectionsRequest;
import com.google.cloud.edgecontainer.v1.ListVpnConnectionsResponse;
import com.google.cloud.edgecontainer.v1.Machine;
import com.google.cloud.edgecontainer.v1.NodePool;
import com.google.cloud.edgecontainer.v1.OperationMetadata;
import com.google.cloud.edgecontainer.v1.UpdateClusterRequest;
import com.google.cloud.edgecontainer.v1.UpdateNodePoolRequest;
import com.google.cloud.edgecontainer.v1.VpnConnection;
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
 * REST stub implementation for the EdgeContainer service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
@BetaApi
public class HttpJsonEdgeContainerStub extends EdgeContainerStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder()
          .add(Empty.getDescriptor())
          .add(NodePool.getDescriptor())
          .add(Cluster.getDescriptor())
          .add(OperationMetadata.getDescriptor())
          .add(VpnConnection.getDescriptor())
          .build();

  private static final ApiMethodDescriptor<ListClustersRequest, ListClustersResponse>
      listClustersMethodDescriptor =
          ApiMethodDescriptor.<ListClustersRequest, ListClustersResponse>newBuilder()
              .setFullMethodName("google.cloud.edgecontainer.v1.EdgeContainer/ListClusters")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListClustersRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/clusters",
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
          .setFullMethodName("google.cloud.edgecontainer.v1.EdgeContainer/GetCluster")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetClusterRequest>newBuilder()
                  .setPath(
                      "/v1/{name=projects/*/locations/*/clusters/*}",
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
              .setFullMethodName("google.cloud.edgecontainer.v1.EdgeContainer/CreateCluster")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateClusterRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/clusters",
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
              .setFullMethodName("google.cloud.edgecontainer.v1.EdgeContainer/UpdateCluster")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateClusterRequest>newBuilder()
                      .setPath(
                          "/v1/{cluster.name=projects/*/locations/*/clusters/*}",
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
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
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

  private static final ApiMethodDescriptor<DeleteClusterRequest, Operation>
      deleteClusterMethodDescriptor =
          ApiMethodDescriptor.<DeleteClusterRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.edgecontainer.v1.EdgeContainer/DeleteCluster")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteClusterRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/clusters/*}",
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
                  (DeleteClusterRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<GenerateAccessTokenRequest, GenerateAccessTokenResponse>
      generateAccessTokenMethodDescriptor =
          ApiMethodDescriptor.<GenerateAccessTokenRequest, GenerateAccessTokenResponse>newBuilder()
              .setFullMethodName("google.cloud.edgecontainer.v1.EdgeContainer/GenerateAccessToken")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GenerateAccessTokenRequest>newBuilder()
                      .setPath(
                          "/v1/{cluster=projects/*/locations/*/clusters/*}:generateAccessToken",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GenerateAccessTokenRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "cluster", request.getCluster());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GenerateAccessTokenRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<GenerateAccessTokenResponse>newBuilder()
                      .setDefaultInstance(GenerateAccessTokenResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListNodePoolsRequest, ListNodePoolsResponse>
      listNodePoolsMethodDescriptor =
          ApiMethodDescriptor.<ListNodePoolsRequest, ListNodePoolsResponse>newBuilder()
              .setFullMethodName("google.cloud.edgecontainer.v1.EdgeContainer/ListNodePools")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListNodePoolsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/clusters/*}/nodePools",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListNodePoolsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListNodePoolsRequest> serializer =
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
                  ProtoMessageResponseParser.<ListNodePoolsResponse>newBuilder()
                      .setDefaultInstance(ListNodePoolsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetNodePoolRequest, NodePool>
      getNodePoolMethodDescriptor =
          ApiMethodDescriptor.<GetNodePoolRequest, NodePool>newBuilder()
              .setFullMethodName("google.cloud.edgecontainer.v1.EdgeContainer/GetNodePool")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetNodePoolRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/clusters/*/nodePools/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetNodePoolRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetNodePoolRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<NodePool>newBuilder()
                      .setDefaultInstance(NodePool.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateNodePoolRequest, Operation>
      createNodePoolMethodDescriptor =
          ApiMethodDescriptor.<CreateNodePoolRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.edgecontainer.v1.EdgeContainer/CreateNodePool")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateNodePoolRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/clusters/*}/nodePools",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateNodePoolRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateNodePoolRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "nodePoolId", request.getNodePoolId());
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("nodePool", request.getNodePool(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateNodePoolRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<UpdateNodePoolRequest, Operation>
      updateNodePoolMethodDescriptor =
          ApiMethodDescriptor.<UpdateNodePoolRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.edgecontainer.v1.EdgeContainer/UpdateNodePool")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateNodePoolRequest>newBuilder()
                      .setPath(
                          "/v1/{nodePool.name=projects/*/locations/*/clusters/*/nodePools/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateNodePoolRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "nodePool.name", request.getNodePool().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateNodePoolRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("nodePool", request.getNodePool(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateNodePoolRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeleteNodePoolRequest, Operation>
      deleteNodePoolMethodDescriptor =
          ApiMethodDescriptor.<DeleteNodePoolRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.edgecontainer.v1.EdgeContainer/DeleteNodePool")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteNodePoolRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/clusters/*/nodePools/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteNodePoolRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteNodePoolRequest> serializer =
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
                  (DeleteNodePoolRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<ListMachinesRequest, ListMachinesResponse>
      listMachinesMethodDescriptor =
          ApiMethodDescriptor.<ListMachinesRequest, ListMachinesResponse>newBuilder()
              .setFullMethodName("google.cloud.edgecontainer.v1.EdgeContainer/ListMachines")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListMachinesRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/machines",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListMachinesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListMachinesRequest> serializer =
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
                  ProtoMessageResponseParser.<ListMachinesResponse>newBuilder()
                      .setDefaultInstance(ListMachinesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetMachineRequest, Machine> getMachineMethodDescriptor =
      ApiMethodDescriptor.<GetMachineRequest, Machine>newBuilder()
          .setFullMethodName("google.cloud.edgecontainer.v1.EdgeContainer/GetMachine")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetMachineRequest>newBuilder()
                  .setPath(
                      "/v1/{name=projects/*/locations/*/machines/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetMachineRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetMachineRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Machine>newBuilder()
                  .setDefaultInstance(Machine.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<ListVpnConnectionsRequest, ListVpnConnectionsResponse>
      listVpnConnectionsMethodDescriptor =
          ApiMethodDescriptor.<ListVpnConnectionsRequest, ListVpnConnectionsResponse>newBuilder()
              .setFullMethodName("google.cloud.edgecontainer.v1.EdgeContainer/ListVpnConnections")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListVpnConnectionsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/vpnConnections",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListVpnConnectionsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListVpnConnectionsRequest> serializer =
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
                  ProtoMessageResponseParser.<ListVpnConnectionsResponse>newBuilder()
                      .setDefaultInstance(ListVpnConnectionsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetVpnConnectionRequest, VpnConnection>
      getVpnConnectionMethodDescriptor =
          ApiMethodDescriptor.<GetVpnConnectionRequest, VpnConnection>newBuilder()
              .setFullMethodName("google.cloud.edgecontainer.v1.EdgeContainer/GetVpnConnection")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetVpnConnectionRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/vpnConnections/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetVpnConnectionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetVpnConnectionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<VpnConnection>newBuilder()
                      .setDefaultInstance(VpnConnection.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateVpnConnectionRequest, Operation>
      createVpnConnectionMethodDescriptor =
          ApiMethodDescriptor.<CreateVpnConnectionRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.edgecontainer.v1.EdgeContainer/CreateVpnConnection")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateVpnConnectionRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/vpnConnections",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateVpnConnectionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateVpnConnectionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(
                                fields, "vpnConnectionId", request.getVpnConnectionId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("vpnConnection", request.getVpnConnection(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateVpnConnectionRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeleteVpnConnectionRequest, Operation>
      deleteVpnConnectionMethodDescriptor =
          ApiMethodDescriptor.<DeleteVpnConnectionRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.edgecontainer.v1.EdgeContainer/DeleteVpnConnection")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteVpnConnectionRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/vpnConnections/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteVpnConnectionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteVpnConnectionRequest> serializer =
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
                  (DeleteVpnConnectionRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
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
  private final UnaryCallable<DeleteClusterRequest, Operation> deleteClusterCallable;
  private final OperationCallable<DeleteClusterRequest, Empty, OperationMetadata>
      deleteClusterOperationCallable;
  private final UnaryCallable<GenerateAccessTokenRequest, GenerateAccessTokenResponse>
      generateAccessTokenCallable;
  private final UnaryCallable<ListNodePoolsRequest, ListNodePoolsResponse> listNodePoolsCallable;
  private final UnaryCallable<ListNodePoolsRequest, ListNodePoolsPagedResponse>
      listNodePoolsPagedCallable;
  private final UnaryCallable<GetNodePoolRequest, NodePool> getNodePoolCallable;
  private final UnaryCallable<CreateNodePoolRequest, Operation> createNodePoolCallable;
  private final OperationCallable<CreateNodePoolRequest, NodePool, OperationMetadata>
      createNodePoolOperationCallable;
  private final UnaryCallable<UpdateNodePoolRequest, Operation> updateNodePoolCallable;
  private final OperationCallable<UpdateNodePoolRequest, NodePool, OperationMetadata>
      updateNodePoolOperationCallable;
  private final UnaryCallable<DeleteNodePoolRequest, Operation> deleteNodePoolCallable;
  private final OperationCallable<DeleteNodePoolRequest, Empty, OperationMetadata>
      deleteNodePoolOperationCallable;
  private final UnaryCallable<ListMachinesRequest, ListMachinesResponse> listMachinesCallable;
  private final UnaryCallable<ListMachinesRequest, ListMachinesPagedResponse>
      listMachinesPagedCallable;
  private final UnaryCallable<GetMachineRequest, Machine> getMachineCallable;
  private final UnaryCallable<ListVpnConnectionsRequest, ListVpnConnectionsResponse>
      listVpnConnectionsCallable;
  private final UnaryCallable<ListVpnConnectionsRequest, ListVpnConnectionsPagedResponse>
      listVpnConnectionsPagedCallable;
  private final UnaryCallable<GetVpnConnectionRequest, VpnConnection> getVpnConnectionCallable;
  private final UnaryCallable<CreateVpnConnectionRequest, Operation> createVpnConnectionCallable;
  private final OperationCallable<CreateVpnConnectionRequest, VpnConnection, OperationMetadata>
      createVpnConnectionOperationCallable;
  private final UnaryCallable<DeleteVpnConnectionRequest, Operation> deleteVpnConnectionCallable;
  private final OperationCallable<DeleteVpnConnectionRequest, Empty, OperationMetadata>
      deleteVpnConnectionOperationCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonEdgeContainerStub create(EdgeContainerStubSettings settings)
      throws IOException {
    return new HttpJsonEdgeContainerStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonEdgeContainerStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonEdgeContainerStub(
        EdgeContainerStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonEdgeContainerStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonEdgeContainerStub(
        EdgeContainerStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonEdgeContainerStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonEdgeContainerStub(
      EdgeContainerStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonEdgeContainerCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonEdgeContainerStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonEdgeContainerStub(
      EdgeContainerStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.httpJsonOperationsStub =
        HttpJsonOperationsStub.create(clientContext, callableFactory, typeRegistry);

    HttpJsonCallSettings<ListClustersRequest, ListClustersResponse> listClustersTransportSettings =
        HttpJsonCallSettings.<ListClustersRequest, ListClustersResponse>newBuilder()
            .setMethodDescriptor(listClustersMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<GetClusterRequest, Cluster> getClusterTransportSettings =
        HttpJsonCallSettings.<GetClusterRequest, Cluster>newBuilder()
            .setMethodDescriptor(getClusterMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<CreateClusterRequest, Operation> createClusterTransportSettings =
        HttpJsonCallSettings.<CreateClusterRequest, Operation>newBuilder()
            .setMethodDescriptor(createClusterMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<UpdateClusterRequest, Operation> updateClusterTransportSettings =
        HttpJsonCallSettings.<UpdateClusterRequest, Operation>newBuilder()
            .setMethodDescriptor(updateClusterMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<DeleteClusterRequest, Operation> deleteClusterTransportSettings =
        HttpJsonCallSettings.<DeleteClusterRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteClusterMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<GenerateAccessTokenRequest, GenerateAccessTokenResponse>
        generateAccessTokenTransportSettings =
            HttpJsonCallSettings
                .<GenerateAccessTokenRequest, GenerateAccessTokenResponse>newBuilder()
                .setMethodDescriptor(generateAccessTokenMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<ListNodePoolsRequest, ListNodePoolsResponse>
        listNodePoolsTransportSettings =
            HttpJsonCallSettings.<ListNodePoolsRequest, ListNodePoolsResponse>newBuilder()
                .setMethodDescriptor(listNodePoolsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GetNodePoolRequest, NodePool> getNodePoolTransportSettings =
        HttpJsonCallSettings.<GetNodePoolRequest, NodePool>newBuilder()
            .setMethodDescriptor(getNodePoolMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<CreateNodePoolRequest, Operation> createNodePoolTransportSettings =
        HttpJsonCallSettings.<CreateNodePoolRequest, Operation>newBuilder()
            .setMethodDescriptor(createNodePoolMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<UpdateNodePoolRequest, Operation> updateNodePoolTransportSettings =
        HttpJsonCallSettings.<UpdateNodePoolRequest, Operation>newBuilder()
            .setMethodDescriptor(updateNodePoolMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<DeleteNodePoolRequest, Operation> deleteNodePoolTransportSettings =
        HttpJsonCallSettings.<DeleteNodePoolRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteNodePoolMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ListMachinesRequest, ListMachinesResponse> listMachinesTransportSettings =
        HttpJsonCallSettings.<ListMachinesRequest, ListMachinesResponse>newBuilder()
            .setMethodDescriptor(listMachinesMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<GetMachineRequest, Machine> getMachineTransportSettings =
        HttpJsonCallSettings.<GetMachineRequest, Machine>newBuilder()
            .setMethodDescriptor(getMachineMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ListVpnConnectionsRequest, ListVpnConnectionsResponse>
        listVpnConnectionsTransportSettings =
            HttpJsonCallSettings.<ListVpnConnectionsRequest, ListVpnConnectionsResponse>newBuilder()
                .setMethodDescriptor(listVpnConnectionsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GetVpnConnectionRequest, VpnConnection> getVpnConnectionTransportSettings =
        HttpJsonCallSettings.<GetVpnConnectionRequest, VpnConnection>newBuilder()
            .setMethodDescriptor(getVpnConnectionMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<CreateVpnConnectionRequest, Operation>
        createVpnConnectionTransportSettings =
            HttpJsonCallSettings.<CreateVpnConnectionRequest, Operation>newBuilder()
                .setMethodDescriptor(createVpnConnectionMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<DeleteVpnConnectionRequest, Operation>
        deleteVpnConnectionTransportSettings =
            HttpJsonCallSettings.<DeleteVpnConnectionRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteVpnConnectionMethodDescriptor)
                .setTypeRegistry(typeRegistry)
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
    this.deleteClusterCallable =
        callableFactory.createUnaryCallable(
            deleteClusterTransportSettings, settings.deleteClusterSettings(), clientContext);
    this.deleteClusterOperationCallable =
        callableFactory.createOperationCallable(
            deleteClusterTransportSettings,
            settings.deleteClusterOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.generateAccessTokenCallable =
        callableFactory.createUnaryCallable(
            generateAccessTokenTransportSettings,
            settings.generateAccessTokenSettings(),
            clientContext);
    this.listNodePoolsCallable =
        callableFactory.createUnaryCallable(
            listNodePoolsTransportSettings, settings.listNodePoolsSettings(), clientContext);
    this.listNodePoolsPagedCallable =
        callableFactory.createPagedCallable(
            listNodePoolsTransportSettings, settings.listNodePoolsSettings(), clientContext);
    this.getNodePoolCallable =
        callableFactory.createUnaryCallable(
            getNodePoolTransportSettings, settings.getNodePoolSettings(), clientContext);
    this.createNodePoolCallable =
        callableFactory.createUnaryCallable(
            createNodePoolTransportSettings, settings.createNodePoolSettings(), clientContext);
    this.createNodePoolOperationCallable =
        callableFactory.createOperationCallable(
            createNodePoolTransportSettings,
            settings.createNodePoolOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.updateNodePoolCallable =
        callableFactory.createUnaryCallable(
            updateNodePoolTransportSettings, settings.updateNodePoolSettings(), clientContext);
    this.updateNodePoolOperationCallable =
        callableFactory.createOperationCallable(
            updateNodePoolTransportSettings,
            settings.updateNodePoolOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.deleteNodePoolCallable =
        callableFactory.createUnaryCallable(
            deleteNodePoolTransportSettings, settings.deleteNodePoolSettings(), clientContext);
    this.deleteNodePoolOperationCallable =
        callableFactory.createOperationCallable(
            deleteNodePoolTransportSettings,
            settings.deleteNodePoolOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.listMachinesCallable =
        callableFactory.createUnaryCallable(
            listMachinesTransportSettings, settings.listMachinesSettings(), clientContext);
    this.listMachinesPagedCallable =
        callableFactory.createPagedCallable(
            listMachinesTransportSettings, settings.listMachinesSettings(), clientContext);
    this.getMachineCallable =
        callableFactory.createUnaryCallable(
            getMachineTransportSettings, settings.getMachineSettings(), clientContext);
    this.listVpnConnectionsCallable =
        callableFactory.createUnaryCallable(
            listVpnConnectionsTransportSettings,
            settings.listVpnConnectionsSettings(),
            clientContext);
    this.listVpnConnectionsPagedCallable =
        callableFactory.createPagedCallable(
            listVpnConnectionsTransportSettings,
            settings.listVpnConnectionsSettings(),
            clientContext);
    this.getVpnConnectionCallable =
        callableFactory.createUnaryCallable(
            getVpnConnectionTransportSettings, settings.getVpnConnectionSettings(), clientContext);
    this.createVpnConnectionCallable =
        callableFactory.createUnaryCallable(
            createVpnConnectionTransportSettings,
            settings.createVpnConnectionSettings(),
            clientContext);
    this.createVpnConnectionOperationCallable =
        callableFactory.createOperationCallable(
            createVpnConnectionTransportSettings,
            settings.createVpnConnectionOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.deleteVpnConnectionCallable =
        callableFactory.createUnaryCallable(
            deleteVpnConnectionTransportSettings,
            settings.deleteVpnConnectionSettings(),
            clientContext);
    this.deleteVpnConnectionOperationCallable =
        callableFactory.createOperationCallable(
            deleteVpnConnectionTransportSettings,
            settings.deleteVpnConnectionOperationSettings(),
            clientContext,
            httpJsonOperationsStub);

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
    methodDescriptors.add(deleteClusterMethodDescriptor);
    methodDescriptors.add(generateAccessTokenMethodDescriptor);
    methodDescriptors.add(listNodePoolsMethodDescriptor);
    methodDescriptors.add(getNodePoolMethodDescriptor);
    methodDescriptors.add(createNodePoolMethodDescriptor);
    methodDescriptors.add(updateNodePoolMethodDescriptor);
    methodDescriptors.add(deleteNodePoolMethodDescriptor);
    methodDescriptors.add(listMachinesMethodDescriptor);
    methodDescriptors.add(getMachineMethodDescriptor);
    methodDescriptors.add(listVpnConnectionsMethodDescriptor);
    methodDescriptors.add(getVpnConnectionMethodDescriptor);
    methodDescriptors.add(createVpnConnectionMethodDescriptor);
    methodDescriptors.add(deleteVpnConnectionMethodDescriptor);
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
  public UnaryCallable<DeleteClusterRequest, Operation> deleteClusterCallable() {
    return deleteClusterCallable;
  }

  @Override
  public OperationCallable<DeleteClusterRequest, Empty, OperationMetadata>
      deleteClusterOperationCallable() {
    return deleteClusterOperationCallable;
  }

  @Override
  public UnaryCallable<GenerateAccessTokenRequest, GenerateAccessTokenResponse>
      generateAccessTokenCallable() {
    return generateAccessTokenCallable;
  }

  @Override
  public UnaryCallable<ListNodePoolsRequest, ListNodePoolsResponse> listNodePoolsCallable() {
    return listNodePoolsCallable;
  }

  @Override
  public UnaryCallable<ListNodePoolsRequest, ListNodePoolsPagedResponse>
      listNodePoolsPagedCallable() {
    return listNodePoolsPagedCallable;
  }

  @Override
  public UnaryCallable<GetNodePoolRequest, NodePool> getNodePoolCallable() {
    return getNodePoolCallable;
  }

  @Override
  public UnaryCallable<CreateNodePoolRequest, Operation> createNodePoolCallable() {
    return createNodePoolCallable;
  }

  @Override
  public OperationCallable<CreateNodePoolRequest, NodePool, OperationMetadata>
      createNodePoolOperationCallable() {
    return createNodePoolOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateNodePoolRequest, Operation> updateNodePoolCallable() {
    return updateNodePoolCallable;
  }

  @Override
  public OperationCallable<UpdateNodePoolRequest, NodePool, OperationMetadata>
      updateNodePoolOperationCallable() {
    return updateNodePoolOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteNodePoolRequest, Operation> deleteNodePoolCallable() {
    return deleteNodePoolCallable;
  }

  @Override
  public OperationCallable<DeleteNodePoolRequest, Empty, OperationMetadata>
      deleteNodePoolOperationCallable() {
    return deleteNodePoolOperationCallable;
  }

  @Override
  public UnaryCallable<ListMachinesRequest, ListMachinesResponse> listMachinesCallable() {
    return listMachinesCallable;
  }

  @Override
  public UnaryCallable<ListMachinesRequest, ListMachinesPagedResponse> listMachinesPagedCallable() {
    return listMachinesPagedCallable;
  }

  @Override
  public UnaryCallable<GetMachineRequest, Machine> getMachineCallable() {
    return getMachineCallable;
  }

  @Override
  public UnaryCallable<ListVpnConnectionsRequest, ListVpnConnectionsResponse>
      listVpnConnectionsCallable() {
    return listVpnConnectionsCallable;
  }

  @Override
  public UnaryCallable<ListVpnConnectionsRequest, ListVpnConnectionsPagedResponse>
      listVpnConnectionsPagedCallable() {
    return listVpnConnectionsPagedCallable;
  }

  @Override
  public UnaryCallable<GetVpnConnectionRequest, VpnConnection> getVpnConnectionCallable() {
    return getVpnConnectionCallable;
  }

  @Override
  public UnaryCallable<CreateVpnConnectionRequest, Operation> createVpnConnectionCallable() {
    return createVpnConnectionCallable;
  }

  @Override
  public OperationCallable<CreateVpnConnectionRequest, VpnConnection, OperationMetadata>
      createVpnConnectionOperationCallable() {
    return createVpnConnectionOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteVpnConnectionRequest, Operation> deleteVpnConnectionCallable() {
    return deleteVpnConnectionCallable;
  }

  @Override
  public OperationCallable<DeleteVpnConnectionRequest, Empty, OperationMetadata>
      deleteVpnConnectionOperationCallable() {
    return deleteVpnConnectionOperationCallable;
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
