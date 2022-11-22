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

package com.google.cloud.vmwareengine.v1.stub;

import static com.google.cloud.vmwareengine.v1.VmwareEngineClient.ListClustersPagedResponse;
import static com.google.cloud.vmwareengine.v1.VmwareEngineClient.ListHcxActivationKeysPagedResponse;
import static com.google.cloud.vmwareengine.v1.VmwareEngineClient.ListLocationsPagedResponse;
import static com.google.cloud.vmwareengine.v1.VmwareEngineClient.ListNetworkPoliciesPagedResponse;
import static com.google.cloud.vmwareengine.v1.VmwareEngineClient.ListNodeTypesPagedResponse;
import static com.google.cloud.vmwareengine.v1.VmwareEngineClient.ListPrivateCloudsPagedResponse;
import static com.google.cloud.vmwareengine.v1.VmwareEngineClient.ListSubnetsPagedResponse;
import static com.google.cloud.vmwareengine.v1.VmwareEngineClient.ListVmwareEngineNetworksPagedResponse;

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
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.cloud.vmwareengine.v1.Cluster;
import com.google.cloud.vmwareengine.v1.CreateClusterRequest;
import com.google.cloud.vmwareengine.v1.CreateHcxActivationKeyRequest;
import com.google.cloud.vmwareengine.v1.CreateNetworkPolicyRequest;
import com.google.cloud.vmwareengine.v1.CreatePrivateCloudRequest;
import com.google.cloud.vmwareengine.v1.CreateVmwareEngineNetworkRequest;
import com.google.cloud.vmwareengine.v1.Credentials;
import com.google.cloud.vmwareengine.v1.DeleteClusterRequest;
import com.google.cloud.vmwareengine.v1.DeleteNetworkPolicyRequest;
import com.google.cloud.vmwareengine.v1.DeletePrivateCloudRequest;
import com.google.cloud.vmwareengine.v1.DeleteVmwareEngineNetworkRequest;
import com.google.cloud.vmwareengine.v1.GetClusterRequest;
import com.google.cloud.vmwareengine.v1.GetHcxActivationKeyRequest;
import com.google.cloud.vmwareengine.v1.GetNetworkPolicyRequest;
import com.google.cloud.vmwareengine.v1.GetNodeTypeRequest;
import com.google.cloud.vmwareengine.v1.GetPrivateCloudRequest;
import com.google.cloud.vmwareengine.v1.GetVmwareEngineNetworkRequest;
import com.google.cloud.vmwareengine.v1.HcxActivationKey;
import com.google.cloud.vmwareengine.v1.ListClustersRequest;
import com.google.cloud.vmwareengine.v1.ListClustersResponse;
import com.google.cloud.vmwareengine.v1.ListHcxActivationKeysRequest;
import com.google.cloud.vmwareengine.v1.ListHcxActivationKeysResponse;
import com.google.cloud.vmwareengine.v1.ListNetworkPoliciesRequest;
import com.google.cloud.vmwareengine.v1.ListNetworkPoliciesResponse;
import com.google.cloud.vmwareengine.v1.ListNodeTypesRequest;
import com.google.cloud.vmwareengine.v1.ListNodeTypesResponse;
import com.google.cloud.vmwareengine.v1.ListPrivateCloudsRequest;
import com.google.cloud.vmwareengine.v1.ListPrivateCloudsResponse;
import com.google.cloud.vmwareengine.v1.ListSubnetsRequest;
import com.google.cloud.vmwareengine.v1.ListSubnetsResponse;
import com.google.cloud.vmwareengine.v1.ListVmwareEngineNetworksRequest;
import com.google.cloud.vmwareengine.v1.ListVmwareEngineNetworksResponse;
import com.google.cloud.vmwareengine.v1.NetworkPolicy;
import com.google.cloud.vmwareengine.v1.NodeType;
import com.google.cloud.vmwareengine.v1.OperationMetadata;
import com.google.cloud.vmwareengine.v1.PrivateCloud;
import com.google.cloud.vmwareengine.v1.ResetNsxCredentialsRequest;
import com.google.cloud.vmwareengine.v1.ResetVcenterCredentialsRequest;
import com.google.cloud.vmwareengine.v1.ShowNsxCredentialsRequest;
import com.google.cloud.vmwareengine.v1.ShowVcenterCredentialsRequest;
import com.google.cloud.vmwareengine.v1.UndeletePrivateCloudRequest;
import com.google.cloud.vmwareengine.v1.UpdateClusterRequest;
import com.google.cloud.vmwareengine.v1.UpdateNetworkPolicyRequest;
import com.google.cloud.vmwareengine.v1.UpdatePrivateCloudRequest;
import com.google.cloud.vmwareengine.v1.UpdateVmwareEngineNetworkRequest;
import com.google.cloud.vmwareengine.v1.VmwareEngineNetwork;
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
 * REST stub implementation for the VmwareEngine service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
@BetaApi
public class HttpJsonVmwareEngineStub extends VmwareEngineStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder()
          .add(Cluster.getDescriptor())
          .add(Empty.getDescriptor())
          .add(OperationMetadata.getDescriptor())
          .add(PrivateCloud.getDescriptor())
          .add(HcxActivationKey.getDescriptor())
          .add(VmwareEngineNetwork.getDescriptor())
          .add(NetworkPolicy.getDescriptor())
          .build();

  private static final ApiMethodDescriptor<ListPrivateCloudsRequest, ListPrivateCloudsResponse>
      listPrivateCloudsMethodDescriptor =
          ApiMethodDescriptor.<ListPrivateCloudsRequest, ListPrivateCloudsResponse>newBuilder()
              .setFullMethodName("google.cloud.vmwareengine.v1.VmwareEngine/ListPrivateClouds")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListPrivateCloudsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/privateClouds",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListPrivateCloudsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListPrivateCloudsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "orderBy", request.getOrderBy());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListPrivateCloudsResponse>newBuilder()
                      .setDefaultInstance(ListPrivateCloudsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetPrivateCloudRequest, PrivateCloud>
      getPrivateCloudMethodDescriptor =
          ApiMethodDescriptor.<GetPrivateCloudRequest, PrivateCloud>newBuilder()
              .setFullMethodName("google.cloud.vmwareengine.v1.VmwareEngine/GetPrivateCloud")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetPrivateCloudRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/privateClouds/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetPrivateCloudRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetPrivateCloudRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<PrivateCloud>newBuilder()
                      .setDefaultInstance(PrivateCloud.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreatePrivateCloudRequest, Operation>
      createPrivateCloudMethodDescriptor =
          ApiMethodDescriptor.<CreatePrivateCloudRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.vmwareengine.v1.VmwareEngine/CreatePrivateCloud")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreatePrivateCloudRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/privateClouds",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreatePrivateCloudRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreatePrivateCloudRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "privateCloudId", request.getPrivateCloudId());
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(
                                fields, "validateOnly", request.getValidateOnly());
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("privateCloud", request.getPrivateCloud(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreatePrivateCloudRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<UpdatePrivateCloudRequest, Operation>
      updatePrivateCloudMethodDescriptor =
          ApiMethodDescriptor.<UpdatePrivateCloudRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.vmwareengine.v1.VmwareEngine/UpdatePrivateCloud")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdatePrivateCloudRequest>newBuilder()
                      .setPath(
                          "/v1/{privateCloud.name=projects/*/locations/*/privateClouds/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdatePrivateCloudRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "privateCloud.name", request.getPrivateCloud().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdatePrivateCloudRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("privateCloud", request.getPrivateCloud(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdatePrivateCloudRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeletePrivateCloudRequest, Operation>
      deletePrivateCloudMethodDescriptor =
          ApiMethodDescriptor.<DeletePrivateCloudRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.vmwareengine.v1.VmwareEngine/DeletePrivateCloud")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeletePrivateCloudRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/privateClouds/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeletePrivateCloudRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeletePrivateCloudRequest> serializer =
                                ProtoRestSerializer.create();
                            if (request.hasDelayHours()) {
                              serializer.putQueryParam(
                                  fields, "delayHours", request.getDelayHours());
                            }
                            serializer.putQueryParam(fields, "force", request.getForce());
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
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
                  (DeletePrivateCloudRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<UndeletePrivateCloudRequest, Operation>
      undeletePrivateCloudMethodDescriptor =
          ApiMethodDescriptor.<UndeletePrivateCloudRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.vmwareengine.v1.VmwareEngine/UndeletePrivateCloud")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UndeletePrivateCloudRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/privateClouds/*}:undelete",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UndeletePrivateCloudRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UndeletePrivateCloudRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearName().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UndeletePrivateCloudRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<ListClustersRequest, ListClustersResponse>
      listClustersMethodDescriptor =
          ApiMethodDescriptor.<ListClustersRequest, ListClustersResponse>newBuilder()
              .setFullMethodName("google.cloud.vmwareengine.v1.VmwareEngine/ListClusters")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListClustersRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/privateClouds/*}/clusters",
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
          .setFullMethodName("google.cloud.vmwareengine.v1.VmwareEngine/GetCluster")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetClusterRequest>newBuilder()
                  .setPath(
                      "/v1/{name=projects/*/locations/*/privateClouds/*/clusters/*}",
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
              .setFullMethodName("google.cloud.vmwareengine.v1.VmwareEngine/CreateCluster")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateClusterRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/privateClouds/*}/clusters",
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
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("cluster", request.getCluster(), false))
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
              .setFullMethodName("google.cloud.vmwareengine.v1.VmwareEngine/UpdateCluster")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateClusterRequest>newBuilder()
                      .setPath(
                          "/v1/{cluster.name=projects/*/locations/*/privateClouds/*/clusters/*}",
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
                            serializer.putQueryParam(
                                fields, "validateOnly", request.getValidateOnly());
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("cluster", request.getCluster(), false))
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
              .setFullMethodName("google.cloud.vmwareengine.v1.VmwareEngine/DeleteCluster")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteClusterRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/privateClouds/*/clusters/*}",
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

  private static final ApiMethodDescriptor<ListSubnetsRequest, ListSubnetsResponse>
      listSubnetsMethodDescriptor =
          ApiMethodDescriptor.<ListSubnetsRequest, ListSubnetsResponse>newBuilder()
              .setFullMethodName("google.cloud.vmwareengine.v1.VmwareEngine/ListSubnets")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListSubnetsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/privateClouds/*}/subnets",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListSubnetsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListSubnetsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListSubnetsResponse>newBuilder()
                      .setDefaultInstance(ListSubnetsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListNodeTypesRequest, ListNodeTypesResponse>
      listNodeTypesMethodDescriptor =
          ApiMethodDescriptor.<ListNodeTypesRequest, ListNodeTypesResponse>newBuilder()
              .setFullMethodName("google.cloud.vmwareengine.v1.VmwareEngine/ListNodeTypes")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListNodeTypesRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/nodeTypes",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListNodeTypesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListNodeTypesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListNodeTypesResponse>newBuilder()
                      .setDefaultInstance(ListNodeTypesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetNodeTypeRequest, NodeType>
      getNodeTypeMethodDescriptor =
          ApiMethodDescriptor.<GetNodeTypeRequest, NodeType>newBuilder()
              .setFullMethodName("google.cloud.vmwareengine.v1.VmwareEngine/GetNodeType")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetNodeTypeRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/nodeTypes/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetNodeTypeRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetNodeTypeRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<NodeType>newBuilder()
                      .setDefaultInstance(NodeType.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ShowNsxCredentialsRequest, Credentials>
      showNsxCredentialsMethodDescriptor =
          ApiMethodDescriptor.<ShowNsxCredentialsRequest, Credentials>newBuilder()
              .setFullMethodName("google.cloud.vmwareengine.v1.VmwareEngine/ShowNsxCredentials")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ShowNsxCredentialsRequest>newBuilder()
                      .setPath(
                          "/v1/{privateCloud=projects/*/locations/*/privateClouds/*}:showNsxCredentials",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ShowNsxCredentialsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "privateCloud", request.getPrivateCloud());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ShowNsxCredentialsRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Credentials>newBuilder()
                      .setDefaultInstance(Credentials.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ShowVcenterCredentialsRequest, Credentials>
      showVcenterCredentialsMethodDescriptor =
          ApiMethodDescriptor.<ShowVcenterCredentialsRequest, Credentials>newBuilder()
              .setFullMethodName("google.cloud.vmwareengine.v1.VmwareEngine/ShowVcenterCredentials")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ShowVcenterCredentialsRequest>newBuilder()
                      .setPath(
                          "/v1/{privateCloud=projects/*/locations/*/privateClouds/*}:showVcenterCredentials",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ShowVcenterCredentialsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "privateCloud", request.getPrivateCloud());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ShowVcenterCredentialsRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Credentials>newBuilder()
                      .setDefaultInstance(Credentials.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ResetNsxCredentialsRequest, Operation>
      resetNsxCredentialsMethodDescriptor =
          ApiMethodDescriptor.<ResetNsxCredentialsRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.vmwareengine.v1.VmwareEngine/ResetNsxCredentials")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ResetNsxCredentialsRequest>newBuilder()
                      .setPath(
                          "/v1/{privateCloud=projects/*/locations/*/privateClouds/*}:resetNsxCredentials",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ResetNsxCredentialsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "privateCloud", request.getPrivateCloud());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ResetNsxCredentialsRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "*", request.toBuilder().clearPrivateCloud().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (ResetNsxCredentialsRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<ResetVcenterCredentialsRequest, Operation>
      resetVcenterCredentialsMethodDescriptor =
          ApiMethodDescriptor.<ResetVcenterCredentialsRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.vmwareengine.v1.VmwareEngine/ResetVcenterCredentials")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ResetVcenterCredentialsRequest>newBuilder()
                      .setPath(
                          "/v1/{privateCloud=projects/*/locations/*/privateClouds/*}:resetVcenterCredentials",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ResetVcenterCredentialsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "privateCloud", request.getPrivateCloud());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ResetVcenterCredentialsRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "*", request.toBuilder().clearPrivateCloud().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (ResetVcenterCredentialsRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<CreateHcxActivationKeyRequest, Operation>
      createHcxActivationKeyMethodDescriptor =
          ApiMethodDescriptor.<CreateHcxActivationKeyRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.vmwareengine.v1.VmwareEngine/CreateHcxActivationKey")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateHcxActivationKeyRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/privateClouds/*}/hcxActivationKeys",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateHcxActivationKeyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateHcxActivationKeyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "hcxActivationKeyId", request.getHcxActivationKeyId());
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("hcxActivationKey", request.getHcxActivationKey(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateHcxActivationKeyRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<
          ListHcxActivationKeysRequest, ListHcxActivationKeysResponse>
      listHcxActivationKeysMethodDescriptor =
          ApiMethodDescriptor
              .<ListHcxActivationKeysRequest, ListHcxActivationKeysResponse>newBuilder()
              .setFullMethodName("google.cloud.vmwareengine.v1.VmwareEngine/ListHcxActivationKeys")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListHcxActivationKeysRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/privateClouds/*}/hcxActivationKeys",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListHcxActivationKeysRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListHcxActivationKeysRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListHcxActivationKeysResponse>newBuilder()
                      .setDefaultInstance(ListHcxActivationKeysResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetHcxActivationKeyRequest, HcxActivationKey>
      getHcxActivationKeyMethodDescriptor =
          ApiMethodDescriptor.<GetHcxActivationKeyRequest, HcxActivationKey>newBuilder()
              .setFullMethodName("google.cloud.vmwareengine.v1.VmwareEngine/GetHcxActivationKey")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetHcxActivationKeyRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/privateClouds/*/hcxActivationKeys/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetHcxActivationKeyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetHcxActivationKeyRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<HcxActivationKey>newBuilder()
                      .setDefaultInstance(HcxActivationKey.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetNetworkPolicyRequest, NetworkPolicy>
      getNetworkPolicyMethodDescriptor =
          ApiMethodDescriptor.<GetNetworkPolicyRequest, NetworkPolicy>newBuilder()
              .setFullMethodName("google.cloud.vmwareengine.v1.VmwareEngine/GetNetworkPolicy")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetNetworkPolicyRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/networkPolicies/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetNetworkPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetNetworkPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<NetworkPolicy>newBuilder()
                      .setDefaultInstance(NetworkPolicy.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListNetworkPoliciesRequest, ListNetworkPoliciesResponse>
      listNetworkPoliciesMethodDescriptor =
          ApiMethodDescriptor.<ListNetworkPoliciesRequest, ListNetworkPoliciesResponse>newBuilder()
              .setFullMethodName("google.cloud.vmwareengine.v1.VmwareEngine/ListNetworkPolicies")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListNetworkPoliciesRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/networkPolicies",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListNetworkPoliciesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListNetworkPoliciesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "orderBy", request.getOrderBy());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListNetworkPoliciesResponse>newBuilder()
                      .setDefaultInstance(ListNetworkPoliciesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateNetworkPolicyRequest, Operation>
      createNetworkPolicyMethodDescriptor =
          ApiMethodDescriptor.<CreateNetworkPolicyRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.vmwareengine.v1.VmwareEngine/CreateNetworkPolicy")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateNetworkPolicyRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/networkPolicies",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateNetworkPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateNetworkPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "networkPolicyId", request.getNetworkPolicyId());
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("networkPolicy", request.getNetworkPolicy(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateNetworkPolicyRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<UpdateNetworkPolicyRequest, Operation>
      updateNetworkPolicyMethodDescriptor =
          ApiMethodDescriptor.<UpdateNetworkPolicyRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.vmwareengine.v1.VmwareEngine/UpdateNetworkPolicy")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateNetworkPolicyRequest>newBuilder()
                      .setPath(
                          "/v1/{networkPolicy.name=projects/*/locations/*/networkPolicies/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateNetworkPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "networkPolicy.name", request.getNetworkPolicy().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateNetworkPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("networkPolicy", request.getNetworkPolicy(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateNetworkPolicyRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeleteNetworkPolicyRequest, Operation>
      deleteNetworkPolicyMethodDescriptor =
          ApiMethodDescriptor.<DeleteNetworkPolicyRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.vmwareengine.v1.VmwareEngine/DeleteNetworkPolicy")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteNetworkPolicyRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/networkPolicies/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteNetworkPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteNetworkPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
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
                  (DeleteNetworkPolicyRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<CreateVmwareEngineNetworkRequest, Operation>
      createVmwareEngineNetworkMethodDescriptor =
          ApiMethodDescriptor.<CreateVmwareEngineNetworkRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.vmwareengine.v1.VmwareEngine/CreateVmwareEngineNetwork")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateVmwareEngineNetworkRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/vmwareEngineNetworks",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateVmwareEngineNetworkRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateVmwareEngineNetworkRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(
                                fields,
                                "vmwareEngineNetworkId",
                                request.getVmwareEngineNetworkId());
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "vmwareEngineNetwork",
                                      request.getVmwareEngineNetwork(),
                                      false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateVmwareEngineNetworkRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<UpdateVmwareEngineNetworkRequest, Operation>
      updateVmwareEngineNetworkMethodDescriptor =
          ApiMethodDescriptor.<UpdateVmwareEngineNetworkRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.vmwareengine.v1.VmwareEngine/UpdateVmwareEngineNetwork")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateVmwareEngineNetworkRequest>newBuilder()
                      .setPath(
                          "/v1/{vmwareEngineNetwork.name=projects/*/locations/*/vmwareEngineNetworks/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateVmwareEngineNetworkRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields,
                                "vmwareEngineNetwork.name",
                                request.getVmwareEngineNetwork().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateVmwareEngineNetworkRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "vmwareEngineNetwork",
                                      request.getVmwareEngineNetwork(),
                                      false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateVmwareEngineNetworkRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeleteVmwareEngineNetworkRequest, Operation>
      deleteVmwareEngineNetworkMethodDescriptor =
          ApiMethodDescriptor.<DeleteVmwareEngineNetworkRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.vmwareengine.v1.VmwareEngine/DeleteVmwareEngineNetwork")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteVmwareEngineNetworkRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/vmwareEngineNetworks/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteVmwareEngineNetworkRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteVmwareEngineNetworkRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "etag", request.getEtag());
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
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
                  (DeleteVmwareEngineNetworkRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<GetVmwareEngineNetworkRequest, VmwareEngineNetwork>
      getVmwareEngineNetworkMethodDescriptor =
          ApiMethodDescriptor.<GetVmwareEngineNetworkRequest, VmwareEngineNetwork>newBuilder()
              .setFullMethodName("google.cloud.vmwareengine.v1.VmwareEngine/GetVmwareEngineNetwork")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetVmwareEngineNetworkRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/vmwareEngineNetworks/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetVmwareEngineNetworkRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetVmwareEngineNetworkRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<VmwareEngineNetwork>newBuilder()
                      .setDefaultInstance(VmwareEngineNetwork.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListVmwareEngineNetworksRequest, ListVmwareEngineNetworksResponse>
      listVmwareEngineNetworksMethodDescriptor =
          ApiMethodDescriptor
              .<ListVmwareEngineNetworksRequest, ListVmwareEngineNetworksResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.vmwareengine.v1.VmwareEngine/ListVmwareEngineNetworks")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListVmwareEngineNetworksRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/vmwareEngineNetworks",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListVmwareEngineNetworksRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListVmwareEngineNetworksRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "orderBy", request.getOrderBy());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListVmwareEngineNetworksResponse>newBuilder()
                      .setDefaultInstance(ListVmwareEngineNetworksResponse.getDefaultInstance())
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
                          "/v1/{resource=projects/*/locations/*/privateClouds/*}:setIamPolicy",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SetIamPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "resource", request.getResource());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/{resource=projects/*/locations/*/privateClouds/*/clusters/*}:setIamPolicy",
                          "/v1/{resource=projects/*/locations/*/privateClouds/*/hcxActivationKeys/*}:setIamPolicy")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SetIamPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearResource().build(), false))
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
                          "/v1/{resource=projects/*/locations/*/privateClouds/*}:getIamPolicy",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetIamPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "resource", request.getResource());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/{resource=projects/*/locations/*/privateClouds/*/clusters/*}:getIamPolicy",
                          "/v1/{resource=projects/*/locations/*/privateClouds/*/hcxActivationKeys/*}:getIamPolicy")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetIamPolicyRequest> serializer =
                                ProtoRestSerializer.create();
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
                          "/v1/{resource=projects/*/locations/*/privateClouds/*}:testIamPermissions",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<TestIamPermissionsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "resource", request.getResource());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/{resource=projects/*/locations/*/privateClouds/*/clusters/*}:testIamPermissions",
                          "/v1/{resource=projects/*/locations/*/privateClouds/*/hcxActivationKeys/*}:testIamPermissions")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<TestIamPermissionsRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearResource().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<TestIamPermissionsResponse>newBuilder()
                      .setDefaultInstance(TestIamPermissionsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<ListPrivateCloudsRequest, ListPrivateCloudsResponse>
      listPrivateCloudsCallable;
  private final UnaryCallable<ListPrivateCloudsRequest, ListPrivateCloudsPagedResponse>
      listPrivateCloudsPagedCallable;
  private final UnaryCallable<GetPrivateCloudRequest, PrivateCloud> getPrivateCloudCallable;
  private final UnaryCallable<CreatePrivateCloudRequest, Operation> createPrivateCloudCallable;
  private final OperationCallable<CreatePrivateCloudRequest, PrivateCloud, OperationMetadata>
      createPrivateCloudOperationCallable;
  private final UnaryCallable<UpdatePrivateCloudRequest, Operation> updatePrivateCloudCallable;
  private final OperationCallable<UpdatePrivateCloudRequest, PrivateCloud, OperationMetadata>
      updatePrivateCloudOperationCallable;
  private final UnaryCallable<DeletePrivateCloudRequest, Operation> deletePrivateCloudCallable;
  private final OperationCallable<DeletePrivateCloudRequest, PrivateCloud, OperationMetadata>
      deletePrivateCloudOperationCallable;
  private final UnaryCallable<UndeletePrivateCloudRequest, Operation> undeletePrivateCloudCallable;
  private final OperationCallable<UndeletePrivateCloudRequest, PrivateCloud, OperationMetadata>
      undeletePrivateCloudOperationCallable;
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
  private final UnaryCallable<ListSubnetsRequest, ListSubnetsResponse> listSubnetsCallable;
  private final UnaryCallable<ListSubnetsRequest, ListSubnetsPagedResponse>
      listSubnetsPagedCallable;
  private final UnaryCallable<ListNodeTypesRequest, ListNodeTypesResponse> listNodeTypesCallable;
  private final UnaryCallable<ListNodeTypesRequest, ListNodeTypesPagedResponse>
      listNodeTypesPagedCallable;
  private final UnaryCallable<GetNodeTypeRequest, NodeType> getNodeTypeCallable;
  private final UnaryCallable<ShowNsxCredentialsRequest, Credentials> showNsxCredentialsCallable;
  private final UnaryCallable<ShowVcenterCredentialsRequest, Credentials>
      showVcenterCredentialsCallable;
  private final UnaryCallable<ResetNsxCredentialsRequest, Operation> resetNsxCredentialsCallable;
  private final OperationCallable<ResetNsxCredentialsRequest, PrivateCloud, OperationMetadata>
      resetNsxCredentialsOperationCallable;
  private final UnaryCallable<ResetVcenterCredentialsRequest, Operation>
      resetVcenterCredentialsCallable;
  private final OperationCallable<ResetVcenterCredentialsRequest, PrivateCloud, OperationMetadata>
      resetVcenterCredentialsOperationCallable;
  private final UnaryCallable<CreateHcxActivationKeyRequest, Operation>
      createHcxActivationKeyCallable;
  private final OperationCallable<
          CreateHcxActivationKeyRequest, HcxActivationKey, OperationMetadata>
      createHcxActivationKeyOperationCallable;
  private final UnaryCallable<ListHcxActivationKeysRequest, ListHcxActivationKeysResponse>
      listHcxActivationKeysCallable;
  private final UnaryCallable<ListHcxActivationKeysRequest, ListHcxActivationKeysPagedResponse>
      listHcxActivationKeysPagedCallable;
  private final UnaryCallable<GetHcxActivationKeyRequest, HcxActivationKey>
      getHcxActivationKeyCallable;
  private final UnaryCallable<GetNetworkPolicyRequest, NetworkPolicy> getNetworkPolicyCallable;
  private final UnaryCallable<ListNetworkPoliciesRequest, ListNetworkPoliciesResponse>
      listNetworkPoliciesCallable;
  private final UnaryCallable<ListNetworkPoliciesRequest, ListNetworkPoliciesPagedResponse>
      listNetworkPoliciesPagedCallable;
  private final UnaryCallable<CreateNetworkPolicyRequest, Operation> createNetworkPolicyCallable;
  private final OperationCallable<CreateNetworkPolicyRequest, NetworkPolicy, OperationMetadata>
      createNetworkPolicyOperationCallable;
  private final UnaryCallable<UpdateNetworkPolicyRequest, Operation> updateNetworkPolicyCallable;
  private final OperationCallable<UpdateNetworkPolicyRequest, NetworkPolicy, OperationMetadata>
      updateNetworkPolicyOperationCallable;
  private final UnaryCallable<DeleteNetworkPolicyRequest, Operation> deleteNetworkPolicyCallable;
  private final OperationCallable<DeleteNetworkPolicyRequest, Empty, OperationMetadata>
      deleteNetworkPolicyOperationCallable;
  private final UnaryCallable<CreateVmwareEngineNetworkRequest, Operation>
      createVmwareEngineNetworkCallable;
  private final OperationCallable<
          CreateVmwareEngineNetworkRequest, VmwareEngineNetwork, OperationMetadata>
      createVmwareEngineNetworkOperationCallable;
  private final UnaryCallable<UpdateVmwareEngineNetworkRequest, Operation>
      updateVmwareEngineNetworkCallable;
  private final OperationCallable<
          UpdateVmwareEngineNetworkRequest, VmwareEngineNetwork, OperationMetadata>
      updateVmwareEngineNetworkOperationCallable;
  private final UnaryCallable<DeleteVmwareEngineNetworkRequest, Operation>
      deleteVmwareEngineNetworkCallable;
  private final OperationCallable<DeleteVmwareEngineNetworkRequest, Empty, OperationMetadata>
      deleteVmwareEngineNetworkOperationCallable;
  private final UnaryCallable<GetVmwareEngineNetworkRequest, VmwareEngineNetwork>
      getVmwareEngineNetworkCallable;
  private final UnaryCallable<ListVmwareEngineNetworksRequest, ListVmwareEngineNetworksResponse>
      listVmwareEngineNetworksCallable;
  private final UnaryCallable<
          ListVmwareEngineNetworksRequest, ListVmwareEngineNetworksPagedResponse>
      listVmwareEngineNetworksPagedCallable;
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

  public static final HttpJsonVmwareEngineStub create(VmwareEngineStubSettings settings)
      throws IOException {
    return new HttpJsonVmwareEngineStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonVmwareEngineStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonVmwareEngineStub(
        VmwareEngineStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonVmwareEngineStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonVmwareEngineStub(
        VmwareEngineStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonVmwareEngineStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonVmwareEngineStub(VmwareEngineStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonVmwareEngineCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonVmwareEngineStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonVmwareEngineStub(
      VmwareEngineStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.httpJsonOperationsStub =
        HttpJsonOperationsStub.create(clientContext, callableFactory, typeRegistry);

    HttpJsonCallSettings<ListPrivateCloudsRequest, ListPrivateCloudsResponse>
        listPrivateCloudsTransportSettings =
            HttpJsonCallSettings.<ListPrivateCloudsRequest, ListPrivateCloudsResponse>newBuilder()
                .setMethodDescriptor(listPrivateCloudsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GetPrivateCloudRequest, PrivateCloud> getPrivateCloudTransportSettings =
        HttpJsonCallSettings.<GetPrivateCloudRequest, PrivateCloud>newBuilder()
            .setMethodDescriptor(getPrivateCloudMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<CreatePrivateCloudRequest, Operation> createPrivateCloudTransportSettings =
        HttpJsonCallSettings.<CreatePrivateCloudRequest, Operation>newBuilder()
            .setMethodDescriptor(createPrivateCloudMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<UpdatePrivateCloudRequest, Operation> updatePrivateCloudTransportSettings =
        HttpJsonCallSettings.<UpdatePrivateCloudRequest, Operation>newBuilder()
            .setMethodDescriptor(updatePrivateCloudMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<DeletePrivateCloudRequest, Operation> deletePrivateCloudTransportSettings =
        HttpJsonCallSettings.<DeletePrivateCloudRequest, Operation>newBuilder()
            .setMethodDescriptor(deletePrivateCloudMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<UndeletePrivateCloudRequest, Operation>
        undeletePrivateCloudTransportSettings =
            HttpJsonCallSettings.<UndeletePrivateCloudRequest, Operation>newBuilder()
                .setMethodDescriptor(undeletePrivateCloudMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
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
    HttpJsonCallSettings<ListSubnetsRequest, ListSubnetsResponse> listSubnetsTransportSettings =
        HttpJsonCallSettings.<ListSubnetsRequest, ListSubnetsResponse>newBuilder()
            .setMethodDescriptor(listSubnetsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ListNodeTypesRequest, ListNodeTypesResponse>
        listNodeTypesTransportSettings =
            HttpJsonCallSettings.<ListNodeTypesRequest, ListNodeTypesResponse>newBuilder()
                .setMethodDescriptor(listNodeTypesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GetNodeTypeRequest, NodeType> getNodeTypeTransportSettings =
        HttpJsonCallSettings.<GetNodeTypeRequest, NodeType>newBuilder()
            .setMethodDescriptor(getNodeTypeMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ShowNsxCredentialsRequest, Credentials>
        showNsxCredentialsTransportSettings =
            HttpJsonCallSettings.<ShowNsxCredentialsRequest, Credentials>newBuilder()
                .setMethodDescriptor(showNsxCredentialsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<ShowVcenterCredentialsRequest, Credentials>
        showVcenterCredentialsTransportSettings =
            HttpJsonCallSettings.<ShowVcenterCredentialsRequest, Credentials>newBuilder()
                .setMethodDescriptor(showVcenterCredentialsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<ResetNsxCredentialsRequest, Operation>
        resetNsxCredentialsTransportSettings =
            HttpJsonCallSettings.<ResetNsxCredentialsRequest, Operation>newBuilder()
                .setMethodDescriptor(resetNsxCredentialsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<ResetVcenterCredentialsRequest, Operation>
        resetVcenterCredentialsTransportSettings =
            HttpJsonCallSettings.<ResetVcenterCredentialsRequest, Operation>newBuilder()
                .setMethodDescriptor(resetVcenterCredentialsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<CreateHcxActivationKeyRequest, Operation>
        createHcxActivationKeyTransportSettings =
            HttpJsonCallSettings.<CreateHcxActivationKeyRequest, Operation>newBuilder()
                .setMethodDescriptor(createHcxActivationKeyMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<ListHcxActivationKeysRequest, ListHcxActivationKeysResponse>
        listHcxActivationKeysTransportSettings =
            HttpJsonCallSettings
                .<ListHcxActivationKeysRequest, ListHcxActivationKeysResponse>newBuilder()
                .setMethodDescriptor(listHcxActivationKeysMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GetHcxActivationKeyRequest, HcxActivationKey>
        getHcxActivationKeyTransportSettings =
            HttpJsonCallSettings.<GetHcxActivationKeyRequest, HcxActivationKey>newBuilder()
                .setMethodDescriptor(getHcxActivationKeyMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GetNetworkPolicyRequest, NetworkPolicy> getNetworkPolicyTransportSettings =
        HttpJsonCallSettings.<GetNetworkPolicyRequest, NetworkPolicy>newBuilder()
            .setMethodDescriptor(getNetworkPolicyMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ListNetworkPoliciesRequest, ListNetworkPoliciesResponse>
        listNetworkPoliciesTransportSettings =
            HttpJsonCallSettings
                .<ListNetworkPoliciesRequest, ListNetworkPoliciesResponse>newBuilder()
                .setMethodDescriptor(listNetworkPoliciesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<CreateNetworkPolicyRequest, Operation>
        createNetworkPolicyTransportSettings =
            HttpJsonCallSettings.<CreateNetworkPolicyRequest, Operation>newBuilder()
                .setMethodDescriptor(createNetworkPolicyMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<UpdateNetworkPolicyRequest, Operation>
        updateNetworkPolicyTransportSettings =
            HttpJsonCallSettings.<UpdateNetworkPolicyRequest, Operation>newBuilder()
                .setMethodDescriptor(updateNetworkPolicyMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<DeleteNetworkPolicyRequest, Operation>
        deleteNetworkPolicyTransportSettings =
            HttpJsonCallSettings.<DeleteNetworkPolicyRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteNetworkPolicyMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<CreateVmwareEngineNetworkRequest, Operation>
        createVmwareEngineNetworkTransportSettings =
            HttpJsonCallSettings.<CreateVmwareEngineNetworkRequest, Operation>newBuilder()
                .setMethodDescriptor(createVmwareEngineNetworkMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<UpdateVmwareEngineNetworkRequest, Operation>
        updateVmwareEngineNetworkTransportSettings =
            HttpJsonCallSettings.<UpdateVmwareEngineNetworkRequest, Operation>newBuilder()
                .setMethodDescriptor(updateVmwareEngineNetworkMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<DeleteVmwareEngineNetworkRequest, Operation>
        deleteVmwareEngineNetworkTransportSettings =
            HttpJsonCallSettings.<DeleteVmwareEngineNetworkRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteVmwareEngineNetworkMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GetVmwareEngineNetworkRequest, VmwareEngineNetwork>
        getVmwareEngineNetworkTransportSettings =
            HttpJsonCallSettings.<GetVmwareEngineNetworkRequest, VmwareEngineNetwork>newBuilder()
                .setMethodDescriptor(getVmwareEngineNetworkMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<ListVmwareEngineNetworksRequest, ListVmwareEngineNetworksResponse>
        listVmwareEngineNetworksTransportSettings =
            HttpJsonCallSettings
                .<ListVmwareEngineNetworksRequest, ListVmwareEngineNetworksResponse>newBuilder()
                .setMethodDescriptor(listVmwareEngineNetworksMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<ListLocationsRequest, ListLocationsResponse>
        listLocationsTransportSettings =
            HttpJsonCallSettings.<ListLocationsRequest, ListLocationsResponse>newBuilder()
                .setMethodDescriptor(listLocationsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GetLocationRequest, Location> getLocationTransportSettings =
        HttpJsonCallSettings.<GetLocationRequest, Location>newBuilder()
            .setMethodDescriptor(getLocationMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<SetIamPolicyRequest, Policy> setIamPolicyTransportSettings =
        HttpJsonCallSettings.<SetIamPolicyRequest, Policy>newBuilder()
            .setMethodDescriptor(setIamPolicyMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<GetIamPolicyRequest, Policy> getIamPolicyTransportSettings =
        HttpJsonCallSettings.<GetIamPolicyRequest, Policy>newBuilder()
            .setMethodDescriptor(getIamPolicyMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsTransportSettings =
            HttpJsonCallSettings.<TestIamPermissionsRequest, TestIamPermissionsResponse>newBuilder()
                .setMethodDescriptor(testIamPermissionsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();

    this.listPrivateCloudsCallable =
        callableFactory.createUnaryCallable(
            listPrivateCloudsTransportSettings,
            settings.listPrivateCloudsSettings(),
            clientContext);
    this.listPrivateCloudsPagedCallable =
        callableFactory.createPagedCallable(
            listPrivateCloudsTransportSettings,
            settings.listPrivateCloudsSettings(),
            clientContext);
    this.getPrivateCloudCallable =
        callableFactory.createUnaryCallable(
            getPrivateCloudTransportSettings, settings.getPrivateCloudSettings(), clientContext);
    this.createPrivateCloudCallable =
        callableFactory.createUnaryCallable(
            createPrivateCloudTransportSettings,
            settings.createPrivateCloudSettings(),
            clientContext);
    this.createPrivateCloudOperationCallable =
        callableFactory.createOperationCallable(
            createPrivateCloudTransportSettings,
            settings.createPrivateCloudOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.updatePrivateCloudCallable =
        callableFactory.createUnaryCallable(
            updatePrivateCloudTransportSettings,
            settings.updatePrivateCloudSettings(),
            clientContext);
    this.updatePrivateCloudOperationCallable =
        callableFactory.createOperationCallable(
            updatePrivateCloudTransportSettings,
            settings.updatePrivateCloudOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.deletePrivateCloudCallable =
        callableFactory.createUnaryCallable(
            deletePrivateCloudTransportSettings,
            settings.deletePrivateCloudSettings(),
            clientContext);
    this.deletePrivateCloudOperationCallable =
        callableFactory.createOperationCallable(
            deletePrivateCloudTransportSettings,
            settings.deletePrivateCloudOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.undeletePrivateCloudCallable =
        callableFactory.createUnaryCallable(
            undeletePrivateCloudTransportSettings,
            settings.undeletePrivateCloudSettings(),
            clientContext);
    this.undeletePrivateCloudOperationCallable =
        callableFactory.createOperationCallable(
            undeletePrivateCloudTransportSettings,
            settings.undeletePrivateCloudOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
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
    this.listSubnetsCallable =
        callableFactory.createUnaryCallable(
            listSubnetsTransportSettings, settings.listSubnetsSettings(), clientContext);
    this.listSubnetsPagedCallable =
        callableFactory.createPagedCallable(
            listSubnetsTransportSettings, settings.listSubnetsSettings(), clientContext);
    this.listNodeTypesCallable =
        callableFactory.createUnaryCallable(
            listNodeTypesTransportSettings, settings.listNodeTypesSettings(), clientContext);
    this.listNodeTypesPagedCallable =
        callableFactory.createPagedCallable(
            listNodeTypesTransportSettings, settings.listNodeTypesSettings(), clientContext);
    this.getNodeTypeCallable =
        callableFactory.createUnaryCallable(
            getNodeTypeTransportSettings, settings.getNodeTypeSettings(), clientContext);
    this.showNsxCredentialsCallable =
        callableFactory.createUnaryCallable(
            showNsxCredentialsTransportSettings,
            settings.showNsxCredentialsSettings(),
            clientContext);
    this.showVcenterCredentialsCallable =
        callableFactory.createUnaryCallable(
            showVcenterCredentialsTransportSettings,
            settings.showVcenterCredentialsSettings(),
            clientContext);
    this.resetNsxCredentialsCallable =
        callableFactory.createUnaryCallable(
            resetNsxCredentialsTransportSettings,
            settings.resetNsxCredentialsSettings(),
            clientContext);
    this.resetNsxCredentialsOperationCallable =
        callableFactory.createOperationCallable(
            resetNsxCredentialsTransportSettings,
            settings.resetNsxCredentialsOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.resetVcenterCredentialsCallable =
        callableFactory.createUnaryCallable(
            resetVcenterCredentialsTransportSettings,
            settings.resetVcenterCredentialsSettings(),
            clientContext);
    this.resetVcenterCredentialsOperationCallable =
        callableFactory.createOperationCallable(
            resetVcenterCredentialsTransportSettings,
            settings.resetVcenterCredentialsOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.createHcxActivationKeyCallable =
        callableFactory.createUnaryCallable(
            createHcxActivationKeyTransportSettings,
            settings.createHcxActivationKeySettings(),
            clientContext);
    this.createHcxActivationKeyOperationCallable =
        callableFactory.createOperationCallable(
            createHcxActivationKeyTransportSettings,
            settings.createHcxActivationKeyOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.listHcxActivationKeysCallable =
        callableFactory.createUnaryCallable(
            listHcxActivationKeysTransportSettings,
            settings.listHcxActivationKeysSettings(),
            clientContext);
    this.listHcxActivationKeysPagedCallable =
        callableFactory.createPagedCallable(
            listHcxActivationKeysTransportSettings,
            settings.listHcxActivationKeysSettings(),
            clientContext);
    this.getHcxActivationKeyCallable =
        callableFactory.createUnaryCallable(
            getHcxActivationKeyTransportSettings,
            settings.getHcxActivationKeySettings(),
            clientContext);
    this.getNetworkPolicyCallable =
        callableFactory.createUnaryCallable(
            getNetworkPolicyTransportSettings, settings.getNetworkPolicySettings(), clientContext);
    this.listNetworkPoliciesCallable =
        callableFactory.createUnaryCallable(
            listNetworkPoliciesTransportSettings,
            settings.listNetworkPoliciesSettings(),
            clientContext);
    this.listNetworkPoliciesPagedCallable =
        callableFactory.createPagedCallable(
            listNetworkPoliciesTransportSettings,
            settings.listNetworkPoliciesSettings(),
            clientContext);
    this.createNetworkPolicyCallable =
        callableFactory.createUnaryCallable(
            createNetworkPolicyTransportSettings,
            settings.createNetworkPolicySettings(),
            clientContext);
    this.createNetworkPolicyOperationCallable =
        callableFactory.createOperationCallable(
            createNetworkPolicyTransportSettings,
            settings.createNetworkPolicyOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.updateNetworkPolicyCallable =
        callableFactory.createUnaryCallable(
            updateNetworkPolicyTransportSettings,
            settings.updateNetworkPolicySettings(),
            clientContext);
    this.updateNetworkPolicyOperationCallable =
        callableFactory.createOperationCallable(
            updateNetworkPolicyTransportSettings,
            settings.updateNetworkPolicyOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.deleteNetworkPolicyCallable =
        callableFactory.createUnaryCallable(
            deleteNetworkPolicyTransportSettings,
            settings.deleteNetworkPolicySettings(),
            clientContext);
    this.deleteNetworkPolicyOperationCallable =
        callableFactory.createOperationCallable(
            deleteNetworkPolicyTransportSettings,
            settings.deleteNetworkPolicyOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.createVmwareEngineNetworkCallable =
        callableFactory.createUnaryCallable(
            createVmwareEngineNetworkTransportSettings,
            settings.createVmwareEngineNetworkSettings(),
            clientContext);
    this.createVmwareEngineNetworkOperationCallable =
        callableFactory.createOperationCallable(
            createVmwareEngineNetworkTransportSettings,
            settings.createVmwareEngineNetworkOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.updateVmwareEngineNetworkCallable =
        callableFactory.createUnaryCallable(
            updateVmwareEngineNetworkTransportSettings,
            settings.updateVmwareEngineNetworkSettings(),
            clientContext);
    this.updateVmwareEngineNetworkOperationCallable =
        callableFactory.createOperationCallable(
            updateVmwareEngineNetworkTransportSettings,
            settings.updateVmwareEngineNetworkOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.deleteVmwareEngineNetworkCallable =
        callableFactory.createUnaryCallable(
            deleteVmwareEngineNetworkTransportSettings,
            settings.deleteVmwareEngineNetworkSettings(),
            clientContext);
    this.deleteVmwareEngineNetworkOperationCallable =
        callableFactory.createOperationCallable(
            deleteVmwareEngineNetworkTransportSettings,
            settings.deleteVmwareEngineNetworkOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.getVmwareEngineNetworkCallable =
        callableFactory.createUnaryCallable(
            getVmwareEngineNetworkTransportSettings,
            settings.getVmwareEngineNetworkSettings(),
            clientContext);
    this.listVmwareEngineNetworksCallable =
        callableFactory.createUnaryCallable(
            listVmwareEngineNetworksTransportSettings,
            settings.listVmwareEngineNetworksSettings(),
            clientContext);
    this.listVmwareEngineNetworksPagedCallable =
        callableFactory.createPagedCallable(
            listVmwareEngineNetworksTransportSettings,
            settings.listVmwareEngineNetworksSettings(),
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
    methodDescriptors.add(listPrivateCloudsMethodDescriptor);
    methodDescriptors.add(getPrivateCloudMethodDescriptor);
    methodDescriptors.add(createPrivateCloudMethodDescriptor);
    methodDescriptors.add(updatePrivateCloudMethodDescriptor);
    methodDescriptors.add(deletePrivateCloudMethodDescriptor);
    methodDescriptors.add(undeletePrivateCloudMethodDescriptor);
    methodDescriptors.add(listClustersMethodDescriptor);
    methodDescriptors.add(getClusterMethodDescriptor);
    methodDescriptors.add(createClusterMethodDescriptor);
    methodDescriptors.add(updateClusterMethodDescriptor);
    methodDescriptors.add(deleteClusterMethodDescriptor);
    methodDescriptors.add(listSubnetsMethodDescriptor);
    methodDescriptors.add(listNodeTypesMethodDescriptor);
    methodDescriptors.add(getNodeTypeMethodDescriptor);
    methodDescriptors.add(showNsxCredentialsMethodDescriptor);
    methodDescriptors.add(showVcenterCredentialsMethodDescriptor);
    methodDescriptors.add(resetNsxCredentialsMethodDescriptor);
    methodDescriptors.add(resetVcenterCredentialsMethodDescriptor);
    methodDescriptors.add(createHcxActivationKeyMethodDescriptor);
    methodDescriptors.add(listHcxActivationKeysMethodDescriptor);
    methodDescriptors.add(getHcxActivationKeyMethodDescriptor);
    methodDescriptors.add(getNetworkPolicyMethodDescriptor);
    methodDescriptors.add(listNetworkPoliciesMethodDescriptor);
    methodDescriptors.add(createNetworkPolicyMethodDescriptor);
    methodDescriptors.add(updateNetworkPolicyMethodDescriptor);
    methodDescriptors.add(deleteNetworkPolicyMethodDescriptor);
    methodDescriptors.add(createVmwareEngineNetworkMethodDescriptor);
    methodDescriptors.add(updateVmwareEngineNetworkMethodDescriptor);
    methodDescriptors.add(deleteVmwareEngineNetworkMethodDescriptor);
    methodDescriptors.add(getVmwareEngineNetworkMethodDescriptor);
    methodDescriptors.add(listVmwareEngineNetworksMethodDescriptor);
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
  public UnaryCallable<ListPrivateCloudsRequest, ListPrivateCloudsResponse>
      listPrivateCloudsCallable() {
    return listPrivateCloudsCallable;
  }

  @Override
  public UnaryCallable<ListPrivateCloudsRequest, ListPrivateCloudsPagedResponse>
      listPrivateCloudsPagedCallable() {
    return listPrivateCloudsPagedCallable;
  }

  @Override
  public UnaryCallable<GetPrivateCloudRequest, PrivateCloud> getPrivateCloudCallable() {
    return getPrivateCloudCallable;
  }

  @Override
  public UnaryCallable<CreatePrivateCloudRequest, Operation> createPrivateCloudCallable() {
    return createPrivateCloudCallable;
  }

  @Override
  public OperationCallable<CreatePrivateCloudRequest, PrivateCloud, OperationMetadata>
      createPrivateCloudOperationCallable() {
    return createPrivateCloudOperationCallable;
  }

  @Override
  public UnaryCallable<UpdatePrivateCloudRequest, Operation> updatePrivateCloudCallable() {
    return updatePrivateCloudCallable;
  }

  @Override
  public OperationCallable<UpdatePrivateCloudRequest, PrivateCloud, OperationMetadata>
      updatePrivateCloudOperationCallable() {
    return updatePrivateCloudOperationCallable;
  }

  @Override
  public UnaryCallable<DeletePrivateCloudRequest, Operation> deletePrivateCloudCallable() {
    return deletePrivateCloudCallable;
  }

  @Override
  public OperationCallable<DeletePrivateCloudRequest, PrivateCloud, OperationMetadata>
      deletePrivateCloudOperationCallable() {
    return deletePrivateCloudOperationCallable;
  }

  @Override
  public UnaryCallable<UndeletePrivateCloudRequest, Operation> undeletePrivateCloudCallable() {
    return undeletePrivateCloudCallable;
  }

  @Override
  public OperationCallable<UndeletePrivateCloudRequest, PrivateCloud, OperationMetadata>
      undeletePrivateCloudOperationCallable() {
    return undeletePrivateCloudOperationCallable;
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
  public UnaryCallable<ListSubnetsRequest, ListSubnetsResponse> listSubnetsCallable() {
    return listSubnetsCallable;
  }

  @Override
  public UnaryCallable<ListSubnetsRequest, ListSubnetsPagedResponse> listSubnetsPagedCallable() {
    return listSubnetsPagedCallable;
  }

  @Override
  public UnaryCallable<ListNodeTypesRequest, ListNodeTypesResponse> listNodeTypesCallable() {
    return listNodeTypesCallable;
  }

  @Override
  public UnaryCallable<ListNodeTypesRequest, ListNodeTypesPagedResponse>
      listNodeTypesPagedCallable() {
    return listNodeTypesPagedCallable;
  }

  @Override
  public UnaryCallable<GetNodeTypeRequest, NodeType> getNodeTypeCallable() {
    return getNodeTypeCallable;
  }

  @Override
  public UnaryCallable<ShowNsxCredentialsRequest, Credentials> showNsxCredentialsCallable() {
    return showNsxCredentialsCallable;
  }

  @Override
  public UnaryCallable<ShowVcenterCredentialsRequest, Credentials>
      showVcenterCredentialsCallable() {
    return showVcenterCredentialsCallable;
  }

  @Override
  public UnaryCallable<ResetNsxCredentialsRequest, Operation> resetNsxCredentialsCallable() {
    return resetNsxCredentialsCallable;
  }

  @Override
  public OperationCallable<ResetNsxCredentialsRequest, PrivateCloud, OperationMetadata>
      resetNsxCredentialsOperationCallable() {
    return resetNsxCredentialsOperationCallable;
  }

  @Override
  public UnaryCallable<ResetVcenterCredentialsRequest, Operation>
      resetVcenterCredentialsCallable() {
    return resetVcenterCredentialsCallable;
  }

  @Override
  public OperationCallable<ResetVcenterCredentialsRequest, PrivateCloud, OperationMetadata>
      resetVcenterCredentialsOperationCallable() {
    return resetVcenterCredentialsOperationCallable;
  }

  @Override
  public UnaryCallable<CreateHcxActivationKeyRequest, Operation> createHcxActivationKeyCallable() {
    return createHcxActivationKeyCallable;
  }

  @Override
  public OperationCallable<CreateHcxActivationKeyRequest, HcxActivationKey, OperationMetadata>
      createHcxActivationKeyOperationCallable() {
    return createHcxActivationKeyOperationCallable;
  }

  @Override
  public UnaryCallable<ListHcxActivationKeysRequest, ListHcxActivationKeysResponse>
      listHcxActivationKeysCallable() {
    return listHcxActivationKeysCallable;
  }

  @Override
  public UnaryCallable<ListHcxActivationKeysRequest, ListHcxActivationKeysPagedResponse>
      listHcxActivationKeysPagedCallable() {
    return listHcxActivationKeysPagedCallable;
  }

  @Override
  public UnaryCallable<GetHcxActivationKeyRequest, HcxActivationKey> getHcxActivationKeyCallable() {
    return getHcxActivationKeyCallable;
  }

  @Override
  public UnaryCallable<GetNetworkPolicyRequest, NetworkPolicy> getNetworkPolicyCallable() {
    return getNetworkPolicyCallable;
  }

  @Override
  public UnaryCallable<ListNetworkPoliciesRequest, ListNetworkPoliciesResponse>
      listNetworkPoliciesCallable() {
    return listNetworkPoliciesCallable;
  }

  @Override
  public UnaryCallable<ListNetworkPoliciesRequest, ListNetworkPoliciesPagedResponse>
      listNetworkPoliciesPagedCallable() {
    return listNetworkPoliciesPagedCallable;
  }

  @Override
  public UnaryCallable<CreateNetworkPolicyRequest, Operation> createNetworkPolicyCallable() {
    return createNetworkPolicyCallable;
  }

  @Override
  public OperationCallable<CreateNetworkPolicyRequest, NetworkPolicy, OperationMetadata>
      createNetworkPolicyOperationCallable() {
    return createNetworkPolicyOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateNetworkPolicyRequest, Operation> updateNetworkPolicyCallable() {
    return updateNetworkPolicyCallable;
  }

  @Override
  public OperationCallable<UpdateNetworkPolicyRequest, NetworkPolicy, OperationMetadata>
      updateNetworkPolicyOperationCallable() {
    return updateNetworkPolicyOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteNetworkPolicyRequest, Operation> deleteNetworkPolicyCallable() {
    return deleteNetworkPolicyCallable;
  }

  @Override
  public OperationCallable<DeleteNetworkPolicyRequest, Empty, OperationMetadata>
      deleteNetworkPolicyOperationCallable() {
    return deleteNetworkPolicyOperationCallable;
  }

  @Override
  public UnaryCallable<CreateVmwareEngineNetworkRequest, Operation>
      createVmwareEngineNetworkCallable() {
    return createVmwareEngineNetworkCallable;
  }

  @Override
  public OperationCallable<CreateVmwareEngineNetworkRequest, VmwareEngineNetwork, OperationMetadata>
      createVmwareEngineNetworkOperationCallable() {
    return createVmwareEngineNetworkOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateVmwareEngineNetworkRequest, Operation>
      updateVmwareEngineNetworkCallable() {
    return updateVmwareEngineNetworkCallable;
  }

  @Override
  public OperationCallable<UpdateVmwareEngineNetworkRequest, VmwareEngineNetwork, OperationMetadata>
      updateVmwareEngineNetworkOperationCallable() {
    return updateVmwareEngineNetworkOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteVmwareEngineNetworkRequest, Operation>
      deleteVmwareEngineNetworkCallable() {
    return deleteVmwareEngineNetworkCallable;
  }

  @Override
  public OperationCallable<DeleteVmwareEngineNetworkRequest, Empty, OperationMetadata>
      deleteVmwareEngineNetworkOperationCallable() {
    return deleteVmwareEngineNetworkOperationCallable;
  }

  @Override
  public UnaryCallable<GetVmwareEngineNetworkRequest, VmwareEngineNetwork>
      getVmwareEngineNetworkCallable() {
    return getVmwareEngineNetworkCallable;
  }

  @Override
  public UnaryCallable<ListVmwareEngineNetworksRequest, ListVmwareEngineNetworksResponse>
      listVmwareEngineNetworksCallable() {
    return listVmwareEngineNetworksCallable;
  }

  @Override
  public UnaryCallable<ListVmwareEngineNetworksRequest, ListVmwareEngineNetworksPagedResponse>
      listVmwareEngineNetworksPagedCallable() {
    return listVmwareEngineNetworksPagedCallable;
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
