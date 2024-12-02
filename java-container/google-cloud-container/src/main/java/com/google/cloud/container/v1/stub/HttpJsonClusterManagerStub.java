/*
 * Copyright 2024 Google LLC
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

package com.google.cloud.container.v1.stub;

import static com.google.cloud.container.v1.ClusterManagerClient.ListUsableSubnetworksPagedResponse;

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
import com.google.container.v1.CancelOperationRequest;
import com.google.container.v1.CheckAutopilotCompatibilityRequest;
import com.google.container.v1.CheckAutopilotCompatibilityResponse;
import com.google.container.v1.Cluster;
import com.google.container.v1.CompleteIPRotationRequest;
import com.google.container.v1.CompleteNodePoolUpgradeRequest;
import com.google.container.v1.CreateClusterRequest;
import com.google.container.v1.CreateNodePoolRequest;
import com.google.container.v1.DeleteClusterRequest;
import com.google.container.v1.DeleteNodePoolRequest;
import com.google.container.v1.GetClusterRequest;
import com.google.container.v1.GetJSONWebKeysRequest;
import com.google.container.v1.GetJSONWebKeysResponse;
import com.google.container.v1.GetNodePoolRequest;
import com.google.container.v1.GetOperationRequest;
import com.google.container.v1.GetServerConfigRequest;
import com.google.container.v1.ListClustersRequest;
import com.google.container.v1.ListClustersResponse;
import com.google.container.v1.ListNodePoolsRequest;
import com.google.container.v1.ListNodePoolsResponse;
import com.google.container.v1.ListOperationsRequest;
import com.google.container.v1.ListOperationsResponse;
import com.google.container.v1.ListUsableSubnetworksRequest;
import com.google.container.v1.ListUsableSubnetworksResponse;
import com.google.container.v1.NodePool;
import com.google.container.v1.Operation;
import com.google.container.v1.RollbackNodePoolUpgradeRequest;
import com.google.container.v1.ServerConfig;
import com.google.container.v1.SetAddonsConfigRequest;
import com.google.container.v1.SetLabelsRequest;
import com.google.container.v1.SetLegacyAbacRequest;
import com.google.container.v1.SetLocationsRequest;
import com.google.container.v1.SetLoggingServiceRequest;
import com.google.container.v1.SetMaintenancePolicyRequest;
import com.google.container.v1.SetMasterAuthRequest;
import com.google.container.v1.SetMonitoringServiceRequest;
import com.google.container.v1.SetNetworkPolicyRequest;
import com.google.container.v1.SetNodePoolAutoscalingRequest;
import com.google.container.v1.SetNodePoolManagementRequest;
import com.google.container.v1.SetNodePoolSizeRequest;
import com.google.container.v1.StartIPRotationRequest;
import com.google.container.v1.UpdateClusterRequest;
import com.google.container.v1.UpdateMasterRequest;
import com.google.container.v1.UpdateNodePoolRequest;
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
 * REST stub implementation for the ClusterManager service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class HttpJsonClusterManagerStub extends ClusterManagerStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<ListClustersRequest, ListClustersResponse>
      listClustersMethodDescriptor =
          ApiMethodDescriptor.<ListClustersRequest, ListClustersResponse>newBuilder()
              .setFullMethodName("google.container.v1.ClusterManager/ListClusters")
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
                            serializer.putPathParam(fields, "projectId", request.getProjectId());
                            serializer.putPathParam(fields, "zone", request.getZone());
                            return fields;
                          })
                      .setAdditionalPaths("/v1/projects/{projectId}/zones/{zone}/clusters")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListClustersRequest> serializer =
                                ProtoRestSerializer.create();
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
          .setFullMethodName("google.container.v1.ClusterManager/GetCluster")
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
                        serializer.putPathParam(fields, "clusterId", request.getClusterId());
                        serializer.putPathParam(fields, "name", request.getName());
                        serializer.putPathParam(fields, "projectId", request.getProjectId());
                        serializer.putPathParam(fields, "zone", request.getZone());
                        return fields;
                      })
                  .setAdditionalPaths("/v1/projects/{projectId}/zones/{zone}/clusters/{clusterId}")
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
              .setFullMethodName("google.container.v1.ClusterManager/CreateCluster")
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
                            serializer.putPathParam(fields, "projectId", request.getProjectId());
                            serializer.putPathParam(fields, "zone", request.getZone());
                            return fields;
                          })
                      .setAdditionalPaths("/v1/projects/{projectId}/zones/{zone}/clusters")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateClusterRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "*",
                                      request
                                          .toBuilder()
                                          .clearParent()
                                          .clearProjectId()
                                          .clearZone()
                                          .build(),
                                      true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateClusterRequest, Operation>
      updateClusterMethodDescriptor =
          ApiMethodDescriptor.<UpdateClusterRequest, Operation>newBuilder()
              .setFullMethodName("google.container.v1.ClusterManager/UpdateCluster")
              .setHttpMethod("PUT")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateClusterRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/clusters/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateClusterRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "clusterId", request.getClusterId());
                            serializer.putPathParam(fields, "name", request.getName());
                            serializer.putPathParam(fields, "projectId", request.getProjectId());
                            serializer.putPathParam(fields, "zone", request.getZone());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/projects/{projectId}/zones/{zone}/clusters/{clusterId}")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateClusterRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "*",
                                      request
                                          .toBuilder()
                                          .clearClusterId()
                                          .clearName()
                                          .clearProjectId()
                                          .clearZone()
                                          .build(),
                                      true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateNodePoolRequest, Operation>
      updateNodePoolMethodDescriptor =
          ApiMethodDescriptor.<UpdateNodePoolRequest, Operation>newBuilder()
              .setFullMethodName("google.container.v1.ClusterManager/UpdateNodePool")
              .setHttpMethod("PUT")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateNodePoolRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/clusters/*/nodePools/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateNodePoolRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "clusterId", request.getClusterId());
                            serializer.putPathParam(fields, "name", request.getName());
                            serializer.putPathParam(fields, "nodePoolId", request.getNodePoolId());
                            serializer.putPathParam(fields, "projectId", request.getProjectId());
                            serializer.putPathParam(fields, "zone", request.getZone());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/projects/{projectId}/zones/{zone}/clusters/{clusterId}/nodePools/{nodePoolId}/update")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateNodePoolRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "*",
                                      request
                                          .toBuilder()
                                          .clearClusterId()
                                          .clearName()
                                          .clearNodePoolId()
                                          .clearProjectId()
                                          .clearZone()
                                          .build(),
                                      true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<SetNodePoolAutoscalingRequest, Operation>
      setNodePoolAutoscalingMethodDescriptor =
          ApiMethodDescriptor.<SetNodePoolAutoscalingRequest, Operation>newBuilder()
              .setFullMethodName("google.container.v1.ClusterManager/SetNodePoolAutoscaling")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SetNodePoolAutoscalingRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/clusters/*/nodePools/*}:setAutoscaling",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SetNodePoolAutoscalingRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "clusterId", request.getClusterId());
                            serializer.putPathParam(fields, "name", request.getName());
                            serializer.putPathParam(fields, "nodePoolId", request.getNodePoolId());
                            serializer.putPathParam(fields, "projectId", request.getProjectId());
                            serializer.putPathParam(fields, "zone", request.getZone());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/projects/{projectId}/zones/{zone}/clusters/{clusterId}/nodePools/{nodePoolId}/autoscaling")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SetNodePoolAutoscalingRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "*",
                                      request
                                          .toBuilder()
                                          .clearClusterId()
                                          .clearName()
                                          .clearNodePoolId()
                                          .clearProjectId()
                                          .clearZone()
                                          .build(),
                                      true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<SetLoggingServiceRequest, Operation>
      setLoggingServiceMethodDescriptor =
          ApiMethodDescriptor.<SetLoggingServiceRequest, Operation>newBuilder()
              .setFullMethodName("google.container.v1.ClusterManager/SetLoggingService")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SetLoggingServiceRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/clusters/*}:setLogging",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SetLoggingServiceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "clusterId", request.getClusterId());
                            serializer.putPathParam(fields, "name", request.getName());
                            serializer.putPathParam(fields, "projectId", request.getProjectId());
                            serializer.putPathParam(fields, "zone", request.getZone());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/projects/{projectId}/zones/{zone}/clusters/{clusterId}/logging")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SetLoggingServiceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "*",
                                      request
                                          .toBuilder()
                                          .clearClusterId()
                                          .clearName()
                                          .clearProjectId()
                                          .clearZone()
                                          .build(),
                                      true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<SetMonitoringServiceRequest, Operation>
      setMonitoringServiceMethodDescriptor =
          ApiMethodDescriptor.<SetMonitoringServiceRequest, Operation>newBuilder()
              .setFullMethodName("google.container.v1.ClusterManager/SetMonitoringService")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SetMonitoringServiceRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/clusters/*}:setMonitoring",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SetMonitoringServiceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "clusterId", request.getClusterId());
                            serializer.putPathParam(fields, "name", request.getName());
                            serializer.putPathParam(fields, "projectId", request.getProjectId());
                            serializer.putPathParam(fields, "zone", request.getZone());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/projects/{projectId}/zones/{zone}/clusters/{clusterId}/monitoring")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SetMonitoringServiceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "*",
                                      request
                                          .toBuilder()
                                          .clearClusterId()
                                          .clearName()
                                          .clearProjectId()
                                          .clearZone()
                                          .build(),
                                      true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<SetAddonsConfigRequest, Operation>
      setAddonsConfigMethodDescriptor =
          ApiMethodDescriptor.<SetAddonsConfigRequest, Operation>newBuilder()
              .setFullMethodName("google.container.v1.ClusterManager/SetAddonsConfig")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SetAddonsConfigRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/clusters/*}:setAddons",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SetAddonsConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "clusterId", request.getClusterId());
                            serializer.putPathParam(fields, "name", request.getName());
                            serializer.putPathParam(fields, "projectId", request.getProjectId());
                            serializer.putPathParam(fields, "zone", request.getZone());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/projects/{projectId}/zones/{zone}/clusters/{clusterId}/addons")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SetAddonsConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "*",
                                      request
                                          .toBuilder()
                                          .clearClusterId()
                                          .clearName()
                                          .clearProjectId()
                                          .clearZone()
                                          .build(),
                                      true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<SetLocationsRequest, Operation>
      setLocationsMethodDescriptor =
          ApiMethodDescriptor.<SetLocationsRequest, Operation>newBuilder()
              .setFullMethodName("google.container.v1.ClusterManager/SetLocations")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SetLocationsRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/clusters/*}:setLocations",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SetLocationsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "clusterId", request.getClusterId());
                            serializer.putPathParam(fields, "name", request.getName());
                            serializer.putPathParam(fields, "projectId", request.getProjectId());
                            serializer.putPathParam(fields, "zone", request.getZone());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/projects/{projectId}/zones/{zone}/clusters/{clusterId}/locations")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SetLocationsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "*",
                                      request
                                          .toBuilder()
                                          .clearClusterId()
                                          .clearName()
                                          .clearProjectId()
                                          .clearZone()
                                          .build(),
                                      true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateMasterRequest, Operation>
      updateMasterMethodDescriptor =
          ApiMethodDescriptor.<UpdateMasterRequest, Operation>newBuilder()
              .setFullMethodName("google.container.v1.ClusterManager/UpdateMaster")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateMasterRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/clusters/*}:updateMaster",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateMasterRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "clusterId", request.getClusterId());
                            serializer.putPathParam(fields, "name", request.getName());
                            serializer.putPathParam(fields, "projectId", request.getProjectId());
                            serializer.putPathParam(fields, "zone", request.getZone());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/projects/{projectId}/zones/{zone}/clusters/{clusterId}/master")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateMasterRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "*",
                                      request
                                          .toBuilder()
                                          .clearClusterId()
                                          .clearName()
                                          .clearProjectId()
                                          .clearZone()
                                          .build(),
                                      true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<SetMasterAuthRequest, Operation>
      setMasterAuthMethodDescriptor =
          ApiMethodDescriptor.<SetMasterAuthRequest, Operation>newBuilder()
              .setFullMethodName("google.container.v1.ClusterManager/SetMasterAuth")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SetMasterAuthRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/clusters/*}:setMasterAuth",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SetMasterAuthRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "clusterId", request.getClusterId());
                            serializer.putPathParam(fields, "name", request.getName());
                            serializer.putPathParam(fields, "projectId", request.getProjectId());
                            serializer.putPathParam(fields, "zone", request.getZone());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/projects/{projectId}/zones/{zone}/clusters/{clusterId}:setMasterAuth")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SetMasterAuthRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "*",
                                      request
                                          .toBuilder()
                                          .clearClusterId()
                                          .clearName()
                                          .clearProjectId()
                                          .clearZone()
                                          .build(),
                                      true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteClusterRequest, Operation>
      deleteClusterMethodDescriptor =
          ApiMethodDescriptor.<DeleteClusterRequest, Operation>newBuilder()
              .setFullMethodName("google.container.v1.ClusterManager/DeleteCluster")
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
                            serializer.putPathParam(fields, "clusterId", request.getClusterId());
                            serializer.putPathParam(fields, "name", request.getName());
                            serializer.putPathParam(fields, "projectId", request.getProjectId());
                            serializer.putPathParam(fields, "zone", request.getZone());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/projects/{projectId}/zones/{zone}/clusters/{clusterId}")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteClusterRequest> serializer =
                                ProtoRestSerializer.create();
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
              .build();

  private static final ApiMethodDescriptor<ListOperationsRequest, ListOperationsResponse>
      listOperationsMethodDescriptor =
          ApiMethodDescriptor.<ListOperationsRequest, ListOperationsResponse>newBuilder()
              .setFullMethodName("google.container.v1.ClusterManager/ListOperations")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListOperationsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/operations",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListOperationsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            serializer.putPathParam(fields, "projectId", request.getProjectId());
                            serializer.putPathParam(fields, "zone", request.getZone());
                            return fields;
                          })
                      .setAdditionalPaths("/v1/projects/{projectId}/zones/{zone}/operations")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListOperationsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListOperationsResponse>newBuilder()
                      .setDefaultInstance(ListOperationsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetOperationRequest, Operation>
      getOperationMethodDescriptor =
          ApiMethodDescriptor.<GetOperationRequest, Operation>newBuilder()
              .setFullMethodName("google.container.v1.ClusterManager/GetOperation")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetOperationRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/operations/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetOperationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            serializer.putPathParam(
                                fields, "operationId", request.getOperationId());
                            serializer.putPathParam(fields, "projectId", request.getProjectId());
                            serializer.putPathParam(fields, "zone", request.getZone());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/projects/{projectId}/zones/{zone}/operations/{operationId}")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetOperationRequest> serializer =
                                ProtoRestSerializer.create();
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
              .build();

  private static final ApiMethodDescriptor<CancelOperationRequest, Empty>
      cancelOperationMethodDescriptor =
          ApiMethodDescriptor.<CancelOperationRequest, Empty>newBuilder()
              .setFullMethodName("google.container.v1.ClusterManager/CancelOperation")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CancelOperationRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/operations/*}:cancel",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CancelOperationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            serializer.putPathParam(
                                fields, "operationId", request.getOperationId());
                            serializer.putPathParam(fields, "projectId", request.getProjectId());
                            serializer.putPathParam(fields, "zone", request.getZone());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/projects/{projectId}/zones/{zone}/operations/{operationId}:cancel")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CancelOperationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "*",
                                      request
                                          .toBuilder()
                                          .clearName()
                                          .clearOperationId()
                                          .clearProjectId()
                                          .clearZone()
                                          .build(),
                                      true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Empty>newBuilder()
                      .setDefaultInstance(Empty.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetServerConfigRequest, ServerConfig>
      getServerConfigMethodDescriptor =
          ApiMethodDescriptor.<GetServerConfigRequest, ServerConfig>newBuilder()
              .setFullMethodName("google.container.v1.ClusterManager/GetServerConfig")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetServerConfigRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*}/serverConfig",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetServerConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            serializer.putPathParam(fields, "projectId", request.getProjectId());
                            serializer.putPathParam(fields, "zone", request.getZone());
                            return fields;
                          })
                      .setAdditionalPaths("/v1/projects/{projectId}/zones/{zone}/serverconfig")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetServerConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ServerConfig>newBuilder()
                      .setDefaultInstance(ServerConfig.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetJSONWebKeysRequest, GetJSONWebKeysResponse>
      getJSONWebKeysMethodDescriptor =
          ApiMethodDescriptor.<GetJSONWebKeysRequest, GetJSONWebKeysResponse>newBuilder()
              .setFullMethodName("google.container.v1.ClusterManager/GetJSONWebKeys")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetJSONWebKeysRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/clusters/*}/jwks",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetJSONWebKeysRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetJSONWebKeysRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<GetJSONWebKeysResponse>newBuilder()
                      .setDefaultInstance(GetJSONWebKeysResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListNodePoolsRequest, ListNodePoolsResponse>
      listNodePoolsMethodDescriptor =
          ApiMethodDescriptor.<ListNodePoolsRequest, ListNodePoolsResponse>newBuilder()
              .setFullMethodName("google.container.v1.ClusterManager/ListNodePools")
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
                            serializer.putPathParam(fields, "clusterId", request.getClusterId());
                            serializer.putPathParam(fields, "parent", request.getParent());
                            serializer.putPathParam(fields, "projectId", request.getProjectId());
                            serializer.putPathParam(fields, "zone", request.getZone());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/projects/{projectId}/zones/{zone}/clusters/{clusterId}/nodePools")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListNodePoolsRequest> serializer =
                                ProtoRestSerializer.create();
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
              .setFullMethodName("google.container.v1.ClusterManager/GetNodePool")
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
                            serializer.putPathParam(fields, "clusterId", request.getClusterId());
                            serializer.putPathParam(fields, "name", request.getName());
                            serializer.putPathParam(fields, "nodePoolId", request.getNodePoolId());
                            serializer.putPathParam(fields, "projectId", request.getProjectId());
                            serializer.putPathParam(fields, "zone", request.getZone());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/projects/{projectId}/zones/{zone}/clusters/{clusterId}/nodePools/{nodePoolId}")
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
              .setFullMethodName("google.container.v1.ClusterManager/CreateNodePool")
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
                            serializer.putPathParam(fields, "clusterId", request.getClusterId());
                            serializer.putPathParam(fields, "parent", request.getParent());
                            serializer.putPathParam(fields, "projectId", request.getProjectId());
                            serializer.putPathParam(fields, "zone", request.getZone());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/projects/{projectId}/zones/{zone}/clusters/{clusterId}/nodePools")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateNodePoolRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "*",
                                      request
                                          .toBuilder()
                                          .clearClusterId()
                                          .clearParent()
                                          .clearProjectId()
                                          .clearZone()
                                          .build(),
                                      true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteNodePoolRequest, Operation>
      deleteNodePoolMethodDescriptor =
          ApiMethodDescriptor.<DeleteNodePoolRequest, Operation>newBuilder()
              .setFullMethodName("google.container.v1.ClusterManager/DeleteNodePool")
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
                            serializer.putPathParam(fields, "clusterId", request.getClusterId());
                            serializer.putPathParam(fields, "name", request.getName());
                            serializer.putPathParam(fields, "nodePoolId", request.getNodePoolId());
                            serializer.putPathParam(fields, "projectId", request.getProjectId());
                            serializer.putPathParam(fields, "zone", request.getZone());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/projects/{projectId}/zones/{zone}/clusters/{clusterId}/nodePools/{nodePoolId}")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteNodePoolRequest> serializer =
                                ProtoRestSerializer.create();
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
              .build();

  private static final ApiMethodDescriptor<CompleteNodePoolUpgradeRequest, Empty>
      completeNodePoolUpgradeMethodDescriptor =
          ApiMethodDescriptor.<CompleteNodePoolUpgradeRequest, Empty>newBuilder()
              .setFullMethodName("google.container.v1.ClusterManager/CompleteNodePoolUpgrade")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CompleteNodePoolUpgradeRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/clusters/*/nodePools/*}:completeUpgrade",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CompleteNodePoolUpgradeRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CompleteNodePoolUpgradeRequest> serializer =
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
                  ProtoMessageResponseParser.<Empty>newBuilder()
                      .setDefaultInstance(Empty.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<RollbackNodePoolUpgradeRequest, Operation>
      rollbackNodePoolUpgradeMethodDescriptor =
          ApiMethodDescriptor.<RollbackNodePoolUpgradeRequest, Operation>newBuilder()
              .setFullMethodName("google.container.v1.ClusterManager/RollbackNodePoolUpgrade")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<RollbackNodePoolUpgradeRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/clusters/*/nodePools/*}:rollback",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<RollbackNodePoolUpgradeRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "clusterId", request.getClusterId());
                            serializer.putPathParam(fields, "name", request.getName());
                            serializer.putPathParam(fields, "nodePoolId", request.getNodePoolId());
                            serializer.putPathParam(fields, "projectId", request.getProjectId());
                            serializer.putPathParam(fields, "zone", request.getZone());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/projects/{projectId}/zones/{zone}/clusters/{clusterId}/nodePools/{nodePoolId}:rollback")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<RollbackNodePoolUpgradeRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "*",
                                      request
                                          .toBuilder()
                                          .clearClusterId()
                                          .clearName()
                                          .clearNodePoolId()
                                          .clearProjectId()
                                          .clearZone()
                                          .build(),
                                      true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<SetNodePoolManagementRequest, Operation>
      setNodePoolManagementMethodDescriptor =
          ApiMethodDescriptor.<SetNodePoolManagementRequest, Operation>newBuilder()
              .setFullMethodName("google.container.v1.ClusterManager/SetNodePoolManagement")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SetNodePoolManagementRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/clusters/*/nodePools/*}:setManagement",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SetNodePoolManagementRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "clusterId", request.getClusterId());
                            serializer.putPathParam(fields, "name", request.getName());
                            serializer.putPathParam(fields, "nodePoolId", request.getNodePoolId());
                            serializer.putPathParam(fields, "projectId", request.getProjectId());
                            serializer.putPathParam(fields, "zone", request.getZone());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/projects/{projectId}/zones/{zone}/clusters/{clusterId}/nodePools/{nodePoolId}/setManagement")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SetNodePoolManagementRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "*",
                                      request
                                          .toBuilder()
                                          .clearClusterId()
                                          .clearName()
                                          .clearNodePoolId()
                                          .clearProjectId()
                                          .clearZone()
                                          .build(),
                                      true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<SetLabelsRequest, Operation> setLabelsMethodDescriptor =
      ApiMethodDescriptor.<SetLabelsRequest, Operation>newBuilder()
          .setFullMethodName("google.container.v1.ClusterManager/SetLabels")
          .setHttpMethod("POST")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<SetLabelsRequest>newBuilder()
                  .setPath(
                      "/v1/{name=projects/*/locations/*/clusters/*}:setResourceLabels",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<SetLabelsRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "clusterId", request.getClusterId());
                        serializer.putPathParam(fields, "name", request.getName());
                        serializer.putPathParam(fields, "projectId", request.getProjectId());
                        serializer.putPathParam(fields, "zone", request.getZone());
                        return fields;
                      })
                  .setAdditionalPaths(
                      "/v1/projects/{projectId}/zones/{zone}/clusters/{clusterId}/resourceLabels")
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<SetLabelsRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(
                      request ->
                          ProtoRestSerializer.create()
                              .toBody(
                                  "*",
                                  request
                                      .toBuilder()
                                      .clearClusterId()
                                      .clearName()
                                      .clearProjectId()
                                      .clearZone()
                                      .build(),
                                  true))
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Operation>newBuilder()
                  .setDefaultInstance(Operation.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<SetLegacyAbacRequest, Operation>
      setLegacyAbacMethodDescriptor =
          ApiMethodDescriptor.<SetLegacyAbacRequest, Operation>newBuilder()
              .setFullMethodName("google.container.v1.ClusterManager/SetLegacyAbac")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SetLegacyAbacRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/clusters/*}:setLegacyAbac",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SetLegacyAbacRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "clusterId", request.getClusterId());
                            serializer.putPathParam(fields, "name", request.getName());
                            serializer.putPathParam(fields, "projectId", request.getProjectId());
                            serializer.putPathParam(fields, "zone", request.getZone());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/projects/{projectId}/zones/{zone}/clusters/{clusterId}/legacyAbac")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SetLegacyAbacRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "*",
                                      request
                                          .toBuilder()
                                          .clearClusterId()
                                          .clearName()
                                          .clearProjectId()
                                          .clearZone()
                                          .build(),
                                      true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<StartIPRotationRequest, Operation>
      startIPRotationMethodDescriptor =
          ApiMethodDescriptor.<StartIPRotationRequest, Operation>newBuilder()
              .setFullMethodName("google.container.v1.ClusterManager/StartIPRotation")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<StartIPRotationRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/clusters/*}:startIpRotation",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<StartIPRotationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "clusterId", request.getClusterId());
                            serializer.putPathParam(fields, "name", request.getName());
                            serializer.putPathParam(fields, "projectId", request.getProjectId());
                            serializer.putPathParam(fields, "zone", request.getZone());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/projects/{projectId}/zones/{zone}/clusters/{clusterId}:startIpRotation")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<StartIPRotationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "*",
                                      request
                                          .toBuilder()
                                          .clearClusterId()
                                          .clearName()
                                          .clearProjectId()
                                          .clearZone()
                                          .build(),
                                      true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CompleteIPRotationRequest, Operation>
      completeIPRotationMethodDescriptor =
          ApiMethodDescriptor.<CompleteIPRotationRequest, Operation>newBuilder()
              .setFullMethodName("google.container.v1.ClusterManager/CompleteIPRotation")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CompleteIPRotationRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/clusters/*}:completeIpRotation",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CompleteIPRotationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "clusterId", request.getClusterId());
                            serializer.putPathParam(fields, "name", request.getName());
                            serializer.putPathParam(fields, "projectId", request.getProjectId());
                            serializer.putPathParam(fields, "zone", request.getZone());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/projects/{projectId}/zones/{zone}/clusters/{clusterId}:completeIpRotation")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CompleteIPRotationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "*",
                                      request
                                          .toBuilder()
                                          .clearClusterId()
                                          .clearName()
                                          .clearProjectId()
                                          .clearZone()
                                          .build(),
                                      true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<SetNodePoolSizeRequest, Operation>
      setNodePoolSizeMethodDescriptor =
          ApiMethodDescriptor.<SetNodePoolSizeRequest, Operation>newBuilder()
              .setFullMethodName("google.container.v1.ClusterManager/SetNodePoolSize")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SetNodePoolSizeRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/clusters/*/nodePools/*}:setSize",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SetNodePoolSizeRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "clusterId", request.getClusterId());
                            serializer.putPathParam(fields, "name", request.getName());
                            serializer.putPathParam(fields, "nodePoolId", request.getNodePoolId());
                            serializer.putPathParam(fields, "projectId", request.getProjectId());
                            serializer.putPathParam(fields, "zone", request.getZone());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/projects/{projectId}/zones/{zone}/clusters/{clusterId}/nodePools/{nodePoolId}/setSize")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SetNodePoolSizeRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "*",
                                      request
                                          .toBuilder()
                                          .clearClusterId()
                                          .clearName()
                                          .clearNodePoolId()
                                          .clearProjectId()
                                          .clearZone()
                                          .build(),
                                      true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<SetNetworkPolicyRequest, Operation>
      setNetworkPolicyMethodDescriptor =
          ApiMethodDescriptor.<SetNetworkPolicyRequest, Operation>newBuilder()
              .setFullMethodName("google.container.v1.ClusterManager/SetNetworkPolicy")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SetNetworkPolicyRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/clusters/*}:setNetworkPolicy",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SetNetworkPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "clusterId", request.getClusterId());
                            serializer.putPathParam(fields, "name", request.getName());
                            serializer.putPathParam(fields, "projectId", request.getProjectId());
                            serializer.putPathParam(fields, "zone", request.getZone());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/projects/{projectId}/zones/{zone}/clusters/{clusterId}:setNetworkPolicy")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SetNetworkPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "*",
                                      request
                                          .toBuilder()
                                          .clearClusterId()
                                          .clearName()
                                          .clearProjectId()
                                          .clearZone()
                                          .build(),
                                      true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<SetMaintenancePolicyRequest, Operation>
      setMaintenancePolicyMethodDescriptor =
          ApiMethodDescriptor.<SetMaintenancePolicyRequest, Operation>newBuilder()
              .setFullMethodName("google.container.v1.ClusterManager/SetMaintenancePolicy")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SetMaintenancePolicyRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/clusters/*}:setMaintenancePolicy",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SetMaintenancePolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "clusterId", request.getClusterId());
                            serializer.putPathParam(fields, "name", request.getName());
                            serializer.putPathParam(fields, "projectId", request.getProjectId());
                            serializer.putPathParam(fields, "zone", request.getZone());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/projects/{projectId}/zones/{zone}/clusters/{clusterId}:setMaintenancePolicy")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SetMaintenancePolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "*",
                                      request
                                          .toBuilder()
                                          .clearClusterId()
                                          .clearName()
                                          .clearProjectId()
                                          .clearZone()
                                          .build(),
                                      true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListUsableSubnetworksRequest, ListUsableSubnetworksResponse>
      listUsableSubnetworksMethodDescriptor =
          ApiMethodDescriptor
              .<ListUsableSubnetworksRequest, ListUsableSubnetworksResponse>newBuilder()
              .setFullMethodName("google.container.v1.ClusterManager/ListUsableSubnetworks")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListUsableSubnetworksRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*}/aggregated/usableSubnetworks",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListUsableSubnetworksRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListUsableSubnetworksRequest> serializer =
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
                  ProtoMessageResponseParser.<ListUsableSubnetworksResponse>newBuilder()
                      .setDefaultInstance(ListUsableSubnetworksResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          CheckAutopilotCompatibilityRequest, CheckAutopilotCompatibilityResponse>
      checkAutopilotCompatibilityMethodDescriptor =
          ApiMethodDescriptor
              .<CheckAutopilotCompatibilityRequest, CheckAutopilotCompatibilityResponse>newBuilder()
              .setFullMethodName("google.container.v1.ClusterManager/CheckAutopilotCompatibility")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CheckAutopilotCompatibilityRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/clusters/*}:checkAutopilotCompatibility",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CheckAutopilotCompatibilityRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CheckAutopilotCompatibilityRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<CheckAutopilotCompatibilityResponse>newBuilder()
                      .setDefaultInstance(CheckAutopilotCompatibilityResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<ListClustersRequest, ListClustersResponse> listClustersCallable;
  private final UnaryCallable<GetClusterRequest, Cluster> getClusterCallable;
  private final UnaryCallable<CreateClusterRequest, Operation> createClusterCallable;
  private final UnaryCallable<UpdateClusterRequest, Operation> updateClusterCallable;
  private final UnaryCallable<UpdateNodePoolRequest, Operation> updateNodePoolCallable;
  private final UnaryCallable<SetNodePoolAutoscalingRequest, Operation>
      setNodePoolAutoscalingCallable;
  private final UnaryCallable<SetLoggingServiceRequest, Operation> setLoggingServiceCallable;
  private final UnaryCallable<SetMonitoringServiceRequest, Operation> setMonitoringServiceCallable;
  private final UnaryCallable<SetAddonsConfigRequest, Operation> setAddonsConfigCallable;
  private final UnaryCallable<SetLocationsRequest, Operation> setLocationsCallable;
  private final UnaryCallable<UpdateMasterRequest, Operation> updateMasterCallable;
  private final UnaryCallable<SetMasterAuthRequest, Operation> setMasterAuthCallable;
  private final UnaryCallable<DeleteClusterRequest, Operation> deleteClusterCallable;
  private final UnaryCallable<ListOperationsRequest, ListOperationsResponse> listOperationsCallable;
  private final UnaryCallable<GetOperationRequest, Operation> getOperationCallable;
  private final UnaryCallable<CancelOperationRequest, Empty> cancelOperationCallable;
  private final UnaryCallable<GetServerConfigRequest, ServerConfig> getServerConfigCallable;
  private final UnaryCallable<GetJSONWebKeysRequest, GetJSONWebKeysResponse> getJSONWebKeysCallable;
  private final UnaryCallable<ListNodePoolsRequest, ListNodePoolsResponse> listNodePoolsCallable;
  private final UnaryCallable<GetNodePoolRequest, NodePool> getNodePoolCallable;
  private final UnaryCallable<CreateNodePoolRequest, Operation> createNodePoolCallable;
  private final UnaryCallable<DeleteNodePoolRequest, Operation> deleteNodePoolCallable;
  private final UnaryCallable<CompleteNodePoolUpgradeRequest, Empty>
      completeNodePoolUpgradeCallable;
  private final UnaryCallable<RollbackNodePoolUpgradeRequest, Operation>
      rollbackNodePoolUpgradeCallable;
  private final UnaryCallable<SetNodePoolManagementRequest, Operation>
      setNodePoolManagementCallable;
  private final UnaryCallable<SetLabelsRequest, Operation> setLabelsCallable;
  private final UnaryCallable<SetLegacyAbacRequest, Operation> setLegacyAbacCallable;
  private final UnaryCallable<StartIPRotationRequest, Operation> startIPRotationCallable;
  private final UnaryCallable<CompleteIPRotationRequest, Operation> completeIPRotationCallable;
  private final UnaryCallable<SetNodePoolSizeRequest, Operation> setNodePoolSizeCallable;
  private final UnaryCallable<SetNetworkPolicyRequest, Operation> setNetworkPolicyCallable;
  private final UnaryCallable<SetMaintenancePolicyRequest, Operation> setMaintenancePolicyCallable;
  private final UnaryCallable<ListUsableSubnetworksRequest, ListUsableSubnetworksResponse>
      listUsableSubnetworksCallable;
  private final UnaryCallable<ListUsableSubnetworksRequest, ListUsableSubnetworksPagedResponse>
      listUsableSubnetworksPagedCallable;
  private final UnaryCallable<
          CheckAutopilotCompatibilityRequest, CheckAutopilotCompatibilityResponse>
      checkAutopilotCompatibilityCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonClusterManagerStub create(ClusterManagerStubSettings settings)
      throws IOException {
    return new HttpJsonClusterManagerStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonClusterManagerStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonClusterManagerStub(
        ClusterManagerStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonClusterManagerStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonClusterManagerStub(
        ClusterManagerStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonClusterManagerStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonClusterManagerStub(
      ClusterManagerStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonClusterManagerCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonClusterManagerStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonClusterManagerStub(
      ClusterManagerStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<ListClustersRequest, ListClustersResponse> listClustersTransportSettings =
        HttpJsonCallSettings.<ListClustersRequest, ListClustersResponse>newBuilder()
            .setMethodDescriptor(listClustersMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  builder.add("project_id", String.valueOf(request.getProjectId()));
                  builder.add("zone", String.valueOf(request.getZone()));
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
                  builder.add("cluster_id", String.valueOf(request.getClusterId()));
                  builder.add("name", String.valueOf(request.getName()));
                  builder.add("project_id", String.valueOf(request.getProjectId()));
                  builder.add("zone", String.valueOf(request.getZone()));
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
                  builder.add("project_id", String.valueOf(request.getProjectId()));
                  builder.add("zone", String.valueOf(request.getZone()));
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
                  builder.add("cluster_id", String.valueOf(request.getClusterId()));
                  builder.add("name", String.valueOf(request.getName()));
                  builder.add("project_id", String.valueOf(request.getProjectId()));
                  builder.add("zone", String.valueOf(request.getZone()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<UpdateNodePoolRequest, Operation> updateNodePoolTransportSettings =
        HttpJsonCallSettings.<UpdateNodePoolRequest, Operation>newBuilder()
            .setMethodDescriptor(updateNodePoolMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("cluster_id", String.valueOf(request.getClusterId()));
                  builder.add("name", String.valueOf(request.getName()));
                  builder.add("node_pool_id", String.valueOf(request.getNodePoolId()));
                  builder.add("project_id", String.valueOf(request.getProjectId()));
                  builder.add("zone", String.valueOf(request.getZone()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<SetNodePoolAutoscalingRequest, Operation>
        setNodePoolAutoscalingTransportSettings =
            HttpJsonCallSettings.<SetNodePoolAutoscalingRequest, Operation>newBuilder()
                .setMethodDescriptor(setNodePoolAutoscalingMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("cluster_id", String.valueOf(request.getClusterId()));
                      builder.add("name", String.valueOf(request.getName()));
                      builder.add("node_pool_id", String.valueOf(request.getNodePoolId()));
                      builder.add("project_id", String.valueOf(request.getProjectId()));
                      builder.add("zone", String.valueOf(request.getZone()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<SetLoggingServiceRequest, Operation> setLoggingServiceTransportSettings =
        HttpJsonCallSettings.<SetLoggingServiceRequest, Operation>newBuilder()
            .setMethodDescriptor(setLoggingServiceMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("cluster_id", String.valueOf(request.getClusterId()));
                  builder.add("name", String.valueOf(request.getName()));
                  builder.add("project_id", String.valueOf(request.getProjectId()));
                  builder.add("zone", String.valueOf(request.getZone()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<SetMonitoringServiceRequest, Operation>
        setMonitoringServiceTransportSettings =
            HttpJsonCallSettings.<SetMonitoringServiceRequest, Operation>newBuilder()
                .setMethodDescriptor(setMonitoringServiceMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("cluster_id", String.valueOf(request.getClusterId()));
                      builder.add("name", String.valueOf(request.getName()));
                      builder.add("project_id", String.valueOf(request.getProjectId()));
                      builder.add("zone", String.valueOf(request.getZone()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<SetAddonsConfigRequest, Operation> setAddonsConfigTransportSettings =
        HttpJsonCallSettings.<SetAddonsConfigRequest, Operation>newBuilder()
            .setMethodDescriptor(setAddonsConfigMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("cluster_id", String.valueOf(request.getClusterId()));
                  builder.add("name", String.valueOf(request.getName()));
                  builder.add("project_id", String.valueOf(request.getProjectId()));
                  builder.add("zone", String.valueOf(request.getZone()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<SetLocationsRequest, Operation> setLocationsTransportSettings =
        HttpJsonCallSettings.<SetLocationsRequest, Operation>newBuilder()
            .setMethodDescriptor(setLocationsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("cluster_id", String.valueOf(request.getClusterId()));
                  builder.add("name", String.valueOf(request.getName()));
                  builder.add("project_id", String.valueOf(request.getProjectId()));
                  builder.add("zone", String.valueOf(request.getZone()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<UpdateMasterRequest, Operation> updateMasterTransportSettings =
        HttpJsonCallSettings.<UpdateMasterRequest, Operation>newBuilder()
            .setMethodDescriptor(updateMasterMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("cluster_id", String.valueOf(request.getClusterId()));
                  builder.add("name", String.valueOf(request.getName()));
                  builder.add("project_id", String.valueOf(request.getProjectId()));
                  builder.add("zone", String.valueOf(request.getZone()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<SetMasterAuthRequest, Operation> setMasterAuthTransportSettings =
        HttpJsonCallSettings.<SetMasterAuthRequest, Operation>newBuilder()
            .setMethodDescriptor(setMasterAuthMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("cluster_id", String.valueOf(request.getClusterId()));
                  builder.add("name", String.valueOf(request.getName()));
                  builder.add("project_id", String.valueOf(request.getProjectId()));
                  builder.add("zone", String.valueOf(request.getZone()));
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
                  builder.add("cluster_id", String.valueOf(request.getClusterId()));
                  builder.add("name", String.valueOf(request.getName()));
                  builder.add("project_id", String.valueOf(request.getProjectId()));
                  builder.add("zone", String.valueOf(request.getZone()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListOperationsRequest, ListOperationsResponse>
        listOperationsTransportSettings =
            HttpJsonCallSettings.<ListOperationsRequest, ListOperationsResponse>newBuilder()
                .setMethodDescriptor(listOperationsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      builder.add("project_id", String.valueOf(request.getProjectId()));
                      builder.add("zone", String.valueOf(request.getZone()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetOperationRequest, Operation> getOperationTransportSettings =
        HttpJsonCallSettings.<GetOperationRequest, Operation>newBuilder()
            .setMethodDescriptor(getOperationMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  builder.add("operation_id", String.valueOf(request.getOperationId()));
                  builder.add("project_id", String.valueOf(request.getProjectId()));
                  builder.add("zone", String.valueOf(request.getZone()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<CancelOperationRequest, Empty> cancelOperationTransportSettings =
        HttpJsonCallSettings.<CancelOperationRequest, Empty>newBuilder()
            .setMethodDescriptor(cancelOperationMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  builder.add("operation_id", String.valueOf(request.getOperationId()));
                  builder.add("project_id", String.valueOf(request.getProjectId()));
                  builder.add("zone", String.valueOf(request.getZone()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<GetServerConfigRequest, ServerConfig> getServerConfigTransportSettings =
        HttpJsonCallSettings.<GetServerConfigRequest, ServerConfig>newBuilder()
            .setMethodDescriptor(getServerConfigMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  builder.add("project_id", String.valueOf(request.getProjectId()));
                  builder.add("zone", String.valueOf(request.getZone()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<GetJSONWebKeysRequest, GetJSONWebKeysResponse>
        getJSONWebKeysTransportSettings =
            HttpJsonCallSettings.<GetJSONWebKeysRequest, GetJSONWebKeysResponse>newBuilder()
                .setMethodDescriptor(getJSONWebKeysMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ListNodePoolsRequest, ListNodePoolsResponse>
        listNodePoolsTransportSettings =
            HttpJsonCallSettings.<ListNodePoolsRequest, ListNodePoolsResponse>newBuilder()
                .setMethodDescriptor(listNodePoolsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("cluster_id", String.valueOf(request.getClusterId()));
                      builder.add("parent", String.valueOf(request.getParent()));
                      builder.add("project_id", String.valueOf(request.getProjectId()));
                      builder.add("zone", String.valueOf(request.getZone()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetNodePoolRequest, NodePool> getNodePoolTransportSettings =
        HttpJsonCallSettings.<GetNodePoolRequest, NodePool>newBuilder()
            .setMethodDescriptor(getNodePoolMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("cluster_id", String.valueOf(request.getClusterId()));
                  builder.add("name", String.valueOf(request.getName()));
                  builder.add("node_pool_id", String.valueOf(request.getNodePoolId()));
                  builder.add("project_id", String.valueOf(request.getProjectId()));
                  builder.add("zone", String.valueOf(request.getZone()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<CreateNodePoolRequest, Operation> createNodePoolTransportSettings =
        HttpJsonCallSettings.<CreateNodePoolRequest, Operation>newBuilder()
            .setMethodDescriptor(createNodePoolMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("cluster_id", String.valueOf(request.getClusterId()));
                  builder.add("parent", String.valueOf(request.getParent()));
                  builder.add("project_id", String.valueOf(request.getProjectId()));
                  builder.add("zone", String.valueOf(request.getZone()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeleteNodePoolRequest, Operation> deleteNodePoolTransportSettings =
        HttpJsonCallSettings.<DeleteNodePoolRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteNodePoolMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("cluster_id", String.valueOf(request.getClusterId()));
                  builder.add("name", String.valueOf(request.getName()));
                  builder.add("node_pool_id", String.valueOf(request.getNodePoolId()));
                  builder.add("project_id", String.valueOf(request.getProjectId()));
                  builder.add("zone", String.valueOf(request.getZone()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<CompleteNodePoolUpgradeRequest, Empty>
        completeNodePoolUpgradeTransportSettings =
            HttpJsonCallSettings.<CompleteNodePoolUpgradeRequest, Empty>newBuilder()
                .setMethodDescriptor(completeNodePoolUpgradeMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<RollbackNodePoolUpgradeRequest, Operation>
        rollbackNodePoolUpgradeTransportSettings =
            HttpJsonCallSettings.<RollbackNodePoolUpgradeRequest, Operation>newBuilder()
                .setMethodDescriptor(rollbackNodePoolUpgradeMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("cluster_id", String.valueOf(request.getClusterId()));
                      builder.add("name", String.valueOf(request.getName()));
                      builder.add("node_pool_id", String.valueOf(request.getNodePoolId()));
                      builder.add("project_id", String.valueOf(request.getProjectId()));
                      builder.add("zone", String.valueOf(request.getZone()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<SetNodePoolManagementRequest, Operation>
        setNodePoolManagementTransportSettings =
            HttpJsonCallSettings.<SetNodePoolManagementRequest, Operation>newBuilder()
                .setMethodDescriptor(setNodePoolManagementMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("cluster_id", String.valueOf(request.getClusterId()));
                      builder.add("name", String.valueOf(request.getName()));
                      builder.add("node_pool_id", String.valueOf(request.getNodePoolId()));
                      builder.add("project_id", String.valueOf(request.getProjectId()));
                      builder.add("zone", String.valueOf(request.getZone()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<SetLabelsRequest, Operation> setLabelsTransportSettings =
        HttpJsonCallSettings.<SetLabelsRequest, Operation>newBuilder()
            .setMethodDescriptor(setLabelsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("cluster_id", String.valueOf(request.getClusterId()));
                  builder.add("name", String.valueOf(request.getName()));
                  builder.add("project_id", String.valueOf(request.getProjectId()));
                  builder.add("zone", String.valueOf(request.getZone()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<SetLegacyAbacRequest, Operation> setLegacyAbacTransportSettings =
        HttpJsonCallSettings.<SetLegacyAbacRequest, Operation>newBuilder()
            .setMethodDescriptor(setLegacyAbacMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("cluster_id", String.valueOf(request.getClusterId()));
                  builder.add("name", String.valueOf(request.getName()));
                  builder.add("project_id", String.valueOf(request.getProjectId()));
                  builder.add("zone", String.valueOf(request.getZone()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<StartIPRotationRequest, Operation> startIPRotationTransportSettings =
        HttpJsonCallSettings.<StartIPRotationRequest, Operation>newBuilder()
            .setMethodDescriptor(startIPRotationMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("cluster_id", String.valueOf(request.getClusterId()));
                  builder.add("name", String.valueOf(request.getName()));
                  builder.add("project_id", String.valueOf(request.getProjectId()));
                  builder.add("zone", String.valueOf(request.getZone()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<CompleteIPRotationRequest, Operation> completeIPRotationTransportSettings =
        HttpJsonCallSettings.<CompleteIPRotationRequest, Operation>newBuilder()
            .setMethodDescriptor(completeIPRotationMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("cluster_id", String.valueOf(request.getClusterId()));
                  builder.add("name", String.valueOf(request.getName()));
                  builder.add("project_id", String.valueOf(request.getProjectId()));
                  builder.add("zone", String.valueOf(request.getZone()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<SetNodePoolSizeRequest, Operation> setNodePoolSizeTransportSettings =
        HttpJsonCallSettings.<SetNodePoolSizeRequest, Operation>newBuilder()
            .setMethodDescriptor(setNodePoolSizeMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("cluster_id", String.valueOf(request.getClusterId()));
                  builder.add("name", String.valueOf(request.getName()));
                  builder.add("node_pool_id", String.valueOf(request.getNodePoolId()));
                  builder.add("project_id", String.valueOf(request.getProjectId()));
                  builder.add("zone", String.valueOf(request.getZone()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<SetNetworkPolicyRequest, Operation> setNetworkPolicyTransportSettings =
        HttpJsonCallSettings.<SetNetworkPolicyRequest, Operation>newBuilder()
            .setMethodDescriptor(setNetworkPolicyMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("cluster_id", String.valueOf(request.getClusterId()));
                  builder.add("name", String.valueOf(request.getName()));
                  builder.add("project_id", String.valueOf(request.getProjectId()));
                  builder.add("zone", String.valueOf(request.getZone()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<SetMaintenancePolicyRequest, Operation>
        setMaintenancePolicyTransportSettings =
            HttpJsonCallSettings.<SetMaintenancePolicyRequest, Operation>newBuilder()
                .setMethodDescriptor(setMaintenancePolicyMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("cluster_id", String.valueOf(request.getClusterId()));
                      builder.add("name", String.valueOf(request.getName()));
                      builder.add("project_id", String.valueOf(request.getProjectId()));
                      builder.add("zone", String.valueOf(request.getZone()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ListUsableSubnetworksRequest, ListUsableSubnetworksResponse>
        listUsableSubnetworksTransportSettings =
            HttpJsonCallSettings
                .<ListUsableSubnetworksRequest, ListUsableSubnetworksResponse>newBuilder()
                .setMethodDescriptor(listUsableSubnetworksMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<CheckAutopilotCompatibilityRequest, CheckAutopilotCompatibilityResponse>
        checkAutopilotCompatibilityTransportSettings =
            HttpJsonCallSettings
                .<CheckAutopilotCompatibilityRequest, CheckAutopilotCompatibilityResponse>
                    newBuilder()
                .setMethodDescriptor(checkAutopilotCompatibilityMethodDescriptor)
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
    this.getClusterCallable =
        callableFactory.createUnaryCallable(
            getClusterTransportSettings, settings.getClusterSettings(), clientContext);
    this.createClusterCallable =
        callableFactory.createUnaryCallable(
            createClusterTransportSettings, settings.createClusterSettings(), clientContext);
    this.updateClusterCallable =
        callableFactory.createUnaryCallable(
            updateClusterTransportSettings, settings.updateClusterSettings(), clientContext);
    this.updateNodePoolCallable =
        callableFactory.createUnaryCallable(
            updateNodePoolTransportSettings, settings.updateNodePoolSettings(), clientContext);
    this.setNodePoolAutoscalingCallable =
        callableFactory.createUnaryCallable(
            setNodePoolAutoscalingTransportSettings,
            settings.setNodePoolAutoscalingSettings(),
            clientContext);
    this.setLoggingServiceCallable =
        callableFactory.createUnaryCallable(
            setLoggingServiceTransportSettings,
            settings.setLoggingServiceSettings(),
            clientContext);
    this.setMonitoringServiceCallable =
        callableFactory.createUnaryCallable(
            setMonitoringServiceTransportSettings,
            settings.setMonitoringServiceSettings(),
            clientContext);
    this.setAddonsConfigCallable =
        callableFactory.createUnaryCallable(
            setAddonsConfigTransportSettings, settings.setAddonsConfigSettings(), clientContext);
    this.setLocationsCallable =
        callableFactory.createUnaryCallable(
            setLocationsTransportSettings, settings.setLocationsSettings(), clientContext);
    this.updateMasterCallable =
        callableFactory.createUnaryCallable(
            updateMasterTransportSettings, settings.updateMasterSettings(), clientContext);
    this.setMasterAuthCallable =
        callableFactory.createUnaryCallable(
            setMasterAuthTransportSettings, settings.setMasterAuthSettings(), clientContext);
    this.deleteClusterCallable =
        callableFactory.createUnaryCallable(
            deleteClusterTransportSettings, settings.deleteClusterSettings(), clientContext);
    this.listOperationsCallable =
        callableFactory.createUnaryCallable(
            listOperationsTransportSettings, settings.listOperationsSettings(), clientContext);
    this.getOperationCallable =
        callableFactory.createUnaryCallable(
            getOperationTransportSettings, settings.getOperationSettings(), clientContext);
    this.cancelOperationCallable =
        callableFactory.createUnaryCallable(
            cancelOperationTransportSettings, settings.cancelOperationSettings(), clientContext);
    this.getServerConfigCallable =
        callableFactory.createUnaryCallable(
            getServerConfigTransportSettings, settings.getServerConfigSettings(), clientContext);
    this.getJSONWebKeysCallable =
        callableFactory.createUnaryCallable(
            getJSONWebKeysTransportSettings, settings.getJSONWebKeysSettings(), clientContext);
    this.listNodePoolsCallable =
        callableFactory.createUnaryCallable(
            listNodePoolsTransportSettings, settings.listNodePoolsSettings(), clientContext);
    this.getNodePoolCallable =
        callableFactory.createUnaryCallable(
            getNodePoolTransportSettings, settings.getNodePoolSettings(), clientContext);
    this.createNodePoolCallable =
        callableFactory.createUnaryCallable(
            createNodePoolTransportSettings, settings.createNodePoolSettings(), clientContext);
    this.deleteNodePoolCallable =
        callableFactory.createUnaryCallable(
            deleteNodePoolTransportSettings, settings.deleteNodePoolSettings(), clientContext);
    this.completeNodePoolUpgradeCallable =
        callableFactory.createUnaryCallable(
            completeNodePoolUpgradeTransportSettings,
            settings.completeNodePoolUpgradeSettings(),
            clientContext);
    this.rollbackNodePoolUpgradeCallable =
        callableFactory.createUnaryCallable(
            rollbackNodePoolUpgradeTransportSettings,
            settings.rollbackNodePoolUpgradeSettings(),
            clientContext);
    this.setNodePoolManagementCallable =
        callableFactory.createUnaryCallable(
            setNodePoolManagementTransportSettings,
            settings.setNodePoolManagementSettings(),
            clientContext);
    this.setLabelsCallable =
        callableFactory.createUnaryCallable(
            setLabelsTransportSettings, settings.setLabelsSettings(), clientContext);
    this.setLegacyAbacCallable =
        callableFactory.createUnaryCallable(
            setLegacyAbacTransportSettings, settings.setLegacyAbacSettings(), clientContext);
    this.startIPRotationCallable =
        callableFactory.createUnaryCallable(
            startIPRotationTransportSettings, settings.startIPRotationSettings(), clientContext);
    this.completeIPRotationCallable =
        callableFactory.createUnaryCallable(
            completeIPRotationTransportSettings,
            settings.completeIPRotationSettings(),
            clientContext);
    this.setNodePoolSizeCallable =
        callableFactory.createUnaryCallable(
            setNodePoolSizeTransportSettings, settings.setNodePoolSizeSettings(), clientContext);
    this.setNetworkPolicyCallable =
        callableFactory.createUnaryCallable(
            setNetworkPolicyTransportSettings, settings.setNetworkPolicySettings(), clientContext);
    this.setMaintenancePolicyCallable =
        callableFactory.createUnaryCallable(
            setMaintenancePolicyTransportSettings,
            settings.setMaintenancePolicySettings(),
            clientContext);
    this.listUsableSubnetworksCallable =
        callableFactory.createUnaryCallable(
            listUsableSubnetworksTransportSettings,
            settings.listUsableSubnetworksSettings(),
            clientContext);
    this.listUsableSubnetworksPagedCallable =
        callableFactory.createPagedCallable(
            listUsableSubnetworksTransportSettings,
            settings.listUsableSubnetworksSettings(),
            clientContext);
    this.checkAutopilotCompatibilityCallable =
        callableFactory.createUnaryCallable(
            checkAutopilotCompatibilityTransportSettings,
            settings.checkAutopilotCompatibilitySettings(),
            clientContext);

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
    methodDescriptors.add(updateNodePoolMethodDescriptor);
    methodDescriptors.add(setNodePoolAutoscalingMethodDescriptor);
    methodDescriptors.add(setLoggingServiceMethodDescriptor);
    methodDescriptors.add(setMonitoringServiceMethodDescriptor);
    methodDescriptors.add(setAddonsConfigMethodDescriptor);
    methodDescriptors.add(setLocationsMethodDescriptor);
    methodDescriptors.add(updateMasterMethodDescriptor);
    methodDescriptors.add(setMasterAuthMethodDescriptor);
    methodDescriptors.add(deleteClusterMethodDescriptor);
    methodDescriptors.add(listOperationsMethodDescriptor);
    methodDescriptors.add(getOperationMethodDescriptor);
    methodDescriptors.add(cancelOperationMethodDescriptor);
    methodDescriptors.add(getServerConfigMethodDescriptor);
    methodDescriptors.add(getJSONWebKeysMethodDescriptor);
    methodDescriptors.add(listNodePoolsMethodDescriptor);
    methodDescriptors.add(getNodePoolMethodDescriptor);
    methodDescriptors.add(createNodePoolMethodDescriptor);
    methodDescriptors.add(deleteNodePoolMethodDescriptor);
    methodDescriptors.add(completeNodePoolUpgradeMethodDescriptor);
    methodDescriptors.add(rollbackNodePoolUpgradeMethodDescriptor);
    methodDescriptors.add(setNodePoolManagementMethodDescriptor);
    methodDescriptors.add(setLabelsMethodDescriptor);
    methodDescriptors.add(setLegacyAbacMethodDescriptor);
    methodDescriptors.add(startIPRotationMethodDescriptor);
    methodDescriptors.add(completeIPRotationMethodDescriptor);
    methodDescriptors.add(setNodePoolSizeMethodDescriptor);
    methodDescriptors.add(setNetworkPolicyMethodDescriptor);
    methodDescriptors.add(setMaintenancePolicyMethodDescriptor);
    methodDescriptors.add(listUsableSubnetworksMethodDescriptor);
    methodDescriptors.add(checkAutopilotCompatibilityMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<ListClustersRequest, ListClustersResponse> listClustersCallable() {
    return listClustersCallable;
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
  public UnaryCallable<UpdateClusterRequest, Operation> updateClusterCallable() {
    return updateClusterCallable;
  }

  @Override
  public UnaryCallable<UpdateNodePoolRequest, Operation> updateNodePoolCallable() {
    return updateNodePoolCallable;
  }

  @Override
  public UnaryCallable<SetNodePoolAutoscalingRequest, Operation> setNodePoolAutoscalingCallable() {
    return setNodePoolAutoscalingCallable;
  }

  @Override
  public UnaryCallable<SetLoggingServiceRequest, Operation> setLoggingServiceCallable() {
    return setLoggingServiceCallable;
  }

  @Override
  public UnaryCallable<SetMonitoringServiceRequest, Operation> setMonitoringServiceCallable() {
    return setMonitoringServiceCallable;
  }

  @Override
  public UnaryCallable<SetAddonsConfigRequest, Operation> setAddonsConfigCallable() {
    return setAddonsConfigCallable;
  }

  @Override
  public UnaryCallable<SetLocationsRequest, Operation> setLocationsCallable() {
    return setLocationsCallable;
  }

  @Override
  public UnaryCallable<UpdateMasterRequest, Operation> updateMasterCallable() {
    return updateMasterCallable;
  }

  @Override
  public UnaryCallable<SetMasterAuthRequest, Operation> setMasterAuthCallable() {
    return setMasterAuthCallable;
  }

  @Override
  public UnaryCallable<DeleteClusterRequest, Operation> deleteClusterCallable() {
    return deleteClusterCallable;
  }

  @Override
  public UnaryCallable<ListOperationsRequest, ListOperationsResponse> listOperationsCallable() {
    return listOperationsCallable;
  }

  @Override
  public UnaryCallable<GetOperationRequest, Operation> getOperationCallable() {
    return getOperationCallable;
  }

  @Override
  public UnaryCallable<CancelOperationRequest, Empty> cancelOperationCallable() {
    return cancelOperationCallable;
  }

  @Override
  public UnaryCallable<GetServerConfigRequest, ServerConfig> getServerConfigCallable() {
    return getServerConfigCallable;
  }

  @Override
  public UnaryCallable<GetJSONWebKeysRequest, GetJSONWebKeysResponse> getJSONWebKeysCallable() {
    return getJSONWebKeysCallable;
  }

  @Override
  public UnaryCallable<ListNodePoolsRequest, ListNodePoolsResponse> listNodePoolsCallable() {
    return listNodePoolsCallable;
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
  public UnaryCallable<DeleteNodePoolRequest, Operation> deleteNodePoolCallable() {
    return deleteNodePoolCallable;
  }

  @Override
  public UnaryCallable<CompleteNodePoolUpgradeRequest, Empty> completeNodePoolUpgradeCallable() {
    return completeNodePoolUpgradeCallable;
  }

  @Override
  public UnaryCallable<RollbackNodePoolUpgradeRequest, Operation>
      rollbackNodePoolUpgradeCallable() {
    return rollbackNodePoolUpgradeCallable;
  }

  @Override
  public UnaryCallable<SetNodePoolManagementRequest, Operation> setNodePoolManagementCallable() {
    return setNodePoolManagementCallable;
  }

  @Override
  public UnaryCallable<SetLabelsRequest, Operation> setLabelsCallable() {
    return setLabelsCallable;
  }

  @Override
  public UnaryCallable<SetLegacyAbacRequest, Operation> setLegacyAbacCallable() {
    return setLegacyAbacCallable;
  }

  @Override
  public UnaryCallable<StartIPRotationRequest, Operation> startIPRotationCallable() {
    return startIPRotationCallable;
  }

  @Override
  public UnaryCallable<CompleteIPRotationRequest, Operation> completeIPRotationCallable() {
    return completeIPRotationCallable;
  }

  @Override
  public UnaryCallable<SetNodePoolSizeRequest, Operation> setNodePoolSizeCallable() {
    return setNodePoolSizeCallable;
  }

  @Override
  public UnaryCallable<SetNetworkPolicyRequest, Operation> setNetworkPolicyCallable() {
    return setNetworkPolicyCallable;
  }

  @Override
  public UnaryCallable<SetMaintenancePolicyRequest, Operation> setMaintenancePolicyCallable() {
    return setMaintenancePolicyCallable;
  }

  @Override
  public UnaryCallable<ListUsableSubnetworksRequest, ListUsableSubnetworksResponse>
      listUsableSubnetworksCallable() {
    return listUsableSubnetworksCallable;
  }

  @Override
  public UnaryCallable<ListUsableSubnetworksRequest, ListUsableSubnetworksPagedResponse>
      listUsableSubnetworksPagedCallable() {
    return listUsableSubnetworksPagedCallable;
  }

  @Override
  public UnaryCallable<CheckAutopilotCompatibilityRequest, CheckAutopilotCompatibilityResponse>
      checkAutopilotCompatibilityCallable() {
    return checkAutopilotCompatibilityCallable;
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
