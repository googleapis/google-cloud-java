/*
 * Copyright 2023 Google LLC
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

import static com.google.cloud.vmwareengine.v1.VmwareEngineClient.FetchNetworkPolicyExternalAddressesPagedResponse;
import static com.google.cloud.vmwareengine.v1.VmwareEngineClient.ListClustersPagedResponse;
import static com.google.cloud.vmwareengine.v1.VmwareEngineClient.ListExternalAccessRulesPagedResponse;
import static com.google.cloud.vmwareengine.v1.VmwareEngineClient.ListExternalAddressesPagedResponse;
import static com.google.cloud.vmwareengine.v1.VmwareEngineClient.ListHcxActivationKeysPagedResponse;
import static com.google.cloud.vmwareengine.v1.VmwareEngineClient.ListLocationsPagedResponse;
import static com.google.cloud.vmwareengine.v1.VmwareEngineClient.ListLoggingServersPagedResponse;
import static com.google.cloud.vmwareengine.v1.VmwareEngineClient.ListManagementDnsZoneBindingsPagedResponse;
import static com.google.cloud.vmwareengine.v1.VmwareEngineClient.ListNetworkPeeringsPagedResponse;
import static com.google.cloud.vmwareengine.v1.VmwareEngineClient.ListNetworkPoliciesPagedResponse;
import static com.google.cloud.vmwareengine.v1.VmwareEngineClient.ListNodeTypesPagedResponse;
import static com.google.cloud.vmwareengine.v1.VmwareEngineClient.ListNodesPagedResponse;
import static com.google.cloud.vmwareengine.v1.VmwareEngineClient.ListPeeringRoutesPagedResponse;
import static com.google.cloud.vmwareengine.v1.VmwareEngineClient.ListPrivateCloudsPagedResponse;
import static com.google.cloud.vmwareengine.v1.VmwareEngineClient.ListPrivateConnectionPeeringRoutesPagedResponse;
import static com.google.cloud.vmwareengine.v1.VmwareEngineClient.ListPrivateConnectionsPagedResponse;
import static com.google.cloud.vmwareengine.v1.VmwareEngineClient.ListSubnetsPagedResponse;
import static com.google.cloud.vmwareengine.v1.VmwareEngineClient.ListVmwareEngineNetworksPagedResponse;

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
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.cloud.vmwareengine.v1.Cluster;
import com.google.cloud.vmwareengine.v1.CreateClusterRequest;
import com.google.cloud.vmwareengine.v1.CreateExternalAccessRuleRequest;
import com.google.cloud.vmwareengine.v1.CreateExternalAddressRequest;
import com.google.cloud.vmwareengine.v1.CreateHcxActivationKeyRequest;
import com.google.cloud.vmwareengine.v1.CreateLoggingServerRequest;
import com.google.cloud.vmwareengine.v1.CreateManagementDnsZoneBindingRequest;
import com.google.cloud.vmwareengine.v1.CreateNetworkPeeringRequest;
import com.google.cloud.vmwareengine.v1.CreateNetworkPolicyRequest;
import com.google.cloud.vmwareengine.v1.CreatePrivateCloudRequest;
import com.google.cloud.vmwareengine.v1.CreatePrivateConnectionRequest;
import com.google.cloud.vmwareengine.v1.CreateVmwareEngineNetworkRequest;
import com.google.cloud.vmwareengine.v1.Credentials;
import com.google.cloud.vmwareengine.v1.DeleteClusterRequest;
import com.google.cloud.vmwareengine.v1.DeleteExternalAccessRuleRequest;
import com.google.cloud.vmwareengine.v1.DeleteExternalAddressRequest;
import com.google.cloud.vmwareengine.v1.DeleteLoggingServerRequest;
import com.google.cloud.vmwareengine.v1.DeleteManagementDnsZoneBindingRequest;
import com.google.cloud.vmwareengine.v1.DeleteNetworkPeeringRequest;
import com.google.cloud.vmwareengine.v1.DeleteNetworkPolicyRequest;
import com.google.cloud.vmwareengine.v1.DeletePrivateCloudRequest;
import com.google.cloud.vmwareengine.v1.DeletePrivateConnectionRequest;
import com.google.cloud.vmwareengine.v1.DeleteVmwareEngineNetworkRequest;
import com.google.cloud.vmwareengine.v1.DnsBindPermission;
import com.google.cloud.vmwareengine.v1.DnsForwarding;
import com.google.cloud.vmwareengine.v1.ExternalAccessRule;
import com.google.cloud.vmwareengine.v1.ExternalAddress;
import com.google.cloud.vmwareengine.v1.FetchNetworkPolicyExternalAddressesRequest;
import com.google.cloud.vmwareengine.v1.FetchNetworkPolicyExternalAddressesResponse;
import com.google.cloud.vmwareengine.v1.GetClusterRequest;
import com.google.cloud.vmwareengine.v1.GetDnsBindPermissionRequest;
import com.google.cloud.vmwareengine.v1.GetDnsForwardingRequest;
import com.google.cloud.vmwareengine.v1.GetExternalAccessRuleRequest;
import com.google.cloud.vmwareengine.v1.GetExternalAddressRequest;
import com.google.cloud.vmwareengine.v1.GetHcxActivationKeyRequest;
import com.google.cloud.vmwareengine.v1.GetLoggingServerRequest;
import com.google.cloud.vmwareengine.v1.GetManagementDnsZoneBindingRequest;
import com.google.cloud.vmwareengine.v1.GetNetworkPeeringRequest;
import com.google.cloud.vmwareengine.v1.GetNetworkPolicyRequest;
import com.google.cloud.vmwareengine.v1.GetNodeRequest;
import com.google.cloud.vmwareengine.v1.GetNodeTypeRequest;
import com.google.cloud.vmwareengine.v1.GetPrivateCloudRequest;
import com.google.cloud.vmwareengine.v1.GetPrivateConnectionRequest;
import com.google.cloud.vmwareengine.v1.GetSubnetRequest;
import com.google.cloud.vmwareengine.v1.GetVmwareEngineNetworkRequest;
import com.google.cloud.vmwareengine.v1.GrantDnsBindPermissionRequest;
import com.google.cloud.vmwareengine.v1.HcxActivationKey;
import com.google.cloud.vmwareengine.v1.ListClustersRequest;
import com.google.cloud.vmwareengine.v1.ListClustersResponse;
import com.google.cloud.vmwareengine.v1.ListExternalAccessRulesRequest;
import com.google.cloud.vmwareengine.v1.ListExternalAccessRulesResponse;
import com.google.cloud.vmwareengine.v1.ListExternalAddressesRequest;
import com.google.cloud.vmwareengine.v1.ListExternalAddressesResponse;
import com.google.cloud.vmwareengine.v1.ListHcxActivationKeysRequest;
import com.google.cloud.vmwareengine.v1.ListHcxActivationKeysResponse;
import com.google.cloud.vmwareengine.v1.ListLoggingServersRequest;
import com.google.cloud.vmwareengine.v1.ListLoggingServersResponse;
import com.google.cloud.vmwareengine.v1.ListManagementDnsZoneBindingsRequest;
import com.google.cloud.vmwareengine.v1.ListManagementDnsZoneBindingsResponse;
import com.google.cloud.vmwareengine.v1.ListNetworkPeeringsRequest;
import com.google.cloud.vmwareengine.v1.ListNetworkPeeringsResponse;
import com.google.cloud.vmwareengine.v1.ListNetworkPoliciesRequest;
import com.google.cloud.vmwareengine.v1.ListNetworkPoliciesResponse;
import com.google.cloud.vmwareengine.v1.ListNodeTypesRequest;
import com.google.cloud.vmwareengine.v1.ListNodeTypesResponse;
import com.google.cloud.vmwareengine.v1.ListNodesRequest;
import com.google.cloud.vmwareengine.v1.ListNodesResponse;
import com.google.cloud.vmwareengine.v1.ListPeeringRoutesRequest;
import com.google.cloud.vmwareengine.v1.ListPeeringRoutesResponse;
import com.google.cloud.vmwareengine.v1.ListPrivateCloudsRequest;
import com.google.cloud.vmwareengine.v1.ListPrivateCloudsResponse;
import com.google.cloud.vmwareengine.v1.ListPrivateConnectionPeeringRoutesRequest;
import com.google.cloud.vmwareengine.v1.ListPrivateConnectionPeeringRoutesResponse;
import com.google.cloud.vmwareengine.v1.ListPrivateConnectionsRequest;
import com.google.cloud.vmwareengine.v1.ListPrivateConnectionsResponse;
import com.google.cloud.vmwareengine.v1.ListSubnetsRequest;
import com.google.cloud.vmwareengine.v1.ListSubnetsResponse;
import com.google.cloud.vmwareengine.v1.ListVmwareEngineNetworksRequest;
import com.google.cloud.vmwareengine.v1.ListVmwareEngineNetworksResponse;
import com.google.cloud.vmwareengine.v1.LoggingServer;
import com.google.cloud.vmwareengine.v1.ManagementDnsZoneBinding;
import com.google.cloud.vmwareengine.v1.NetworkPeering;
import com.google.cloud.vmwareengine.v1.NetworkPolicy;
import com.google.cloud.vmwareengine.v1.Node;
import com.google.cloud.vmwareengine.v1.NodeType;
import com.google.cloud.vmwareengine.v1.OperationMetadata;
import com.google.cloud.vmwareengine.v1.PrivateCloud;
import com.google.cloud.vmwareengine.v1.PrivateConnection;
import com.google.cloud.vmwareengine.v1.RepairManagementDnsZoneBindingRequest;
import com.google.cloud.vmwareengine.v1.ResetNsxCredentialsRequest;
import com.google.cloud.vmwareengine.v1.ResetVcenterCredentialsRequest;
import com.google.cloud.vmwareengine.v1.RevokeDnsBindPermissionRequest;
import com.google.cloud.vmwareengine.v1.ShowNsxCredentialsRequest;
import com.google.cloud.vmwareengine.v1.ShowVcenterCredentialsRequest;
import com.google.cloud.vmwareengine.v1.Subnet;
import com.google.cloud.vmwareengine.v1.UndeletePrivateCloudRequest;
import com.google.cloud.vmwareengine.v1.UpdateClusterRequest;
import com.google.cloud.vmwareengine.v1.UpdateDnsForwardingRequest;
import com.google.cloud.vmwareengine.v1.UpdateExternalAccessRuleRequest;
import com.google.cloud.vmwareengine.v1.UpdateExternalAddressRequest;
import com.google.cloud.vmwareengine.v1.UpdateLoggingServerRequest;
import com.google.cloud.vmwareengine.v1.UpdateManagementDnsZoneBindingRequest;
import com.google.cloud.vmwareengine.v1.UpdateNetworkPeeringRequest;
import com.google.cloud.vmwareengine.v1.UpdateNetworkPolicyRequest;
import com.google.cloud.vmwareengine.v1.UpdatePrivateCloudRequest;
import com.google.cloud.vmwareengine.v1.UpdatePrivateConnectionRequest;
import com.google.cloud.vmwareengine.v1.UpdateSubnetRequest;
import com.google.cloud.vmwareengine.v1.UpdateVmwareEngineNetworkRequest;
import com.google.cloud.vmwareengine.v1.VmwareEngineNetwork;
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
 * REST stub implementation for the VmwareEngine service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
@BetaApi
public class HttpJsonVmwareEngineStub extends VmwareEngineStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder()
          .add(ExternalAddress.getDescriptor())
          .add(Subnet.getDescriptor())
          .add(ManagementDnsZoneBinding.getDescriptor())
          .add(DnsForwarding.getDescriptor())
          .add(NetworkPeering.getDescriptor())
          .add(PrivateCloud.getDescriptor())
          .add(ExternalAccessRule.getDescriptor())
          .add(NetworkPolicy.getDescriptor())
          .add(Cluster.getDescriptor())
          .add(DnsBindPermission.getDescriptor())
          .add(Empty.getDescriptor())
          .add(PrivateConnection.getDescriptor())
          .add(OperationMetadata.getDescriptor())
          .add(HcxActivationKey.getDescriptor())
          .add(LoggingServer.getDescriptor())
          .add(VmwareEngineNetwork.getDescriptor())
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
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
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
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
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
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("privateCloud", request.getPrivateCloud(), true))
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
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("privateCloud", request.getPrivateCloud(), true))
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

  private static final ApiMethodDescriptor<ListNodesRequest, ListNodesResponse>
      listNodesMethodDescriptor =
          ApiMethodDescriptor.<ListNodesRequest, ListNodesResponse>newBuilder()
              .setFullMethodName("google.cloud.vmwareengine.v1.VmwareEngine/ListNodes")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListNodesRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/privateClouds/*/clusters/*}/nodes",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListNodesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListNodesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListNodesResponse>newBuilder()
                      .setDefaultInstance(ListNodesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetNodeRequest, Node> getNodeMethodDescriptor =
      ApiMethodDescriptor.<GetNodeRequest, Node>newBuilder()
          .setFullMethodName("google.cloud.vmwareengine.v1.VmwareEngine/GetNode")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetNodeRequest>newBuilder()
                  .setPath(
                      "/v1/{name=projects/*/locations/*/privateClouds/*/clusters/*/nodes/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetNodeRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetNodeRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Node>newBuilder()
                  .setDefaultInstance(Node.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<
          ListExternalAddressesRequest, ListExternalAddressesResponse>
      listExternalAddressesMethodDescriptor =
          ApiMethodDescriptor
              .<ListExternalAddressesRequest, ListExternalAddressesResponse>newBuilder()
              .setFullMethodName("google.cloud.vmwareengine.v1.VmwareEngine/ListExternalAddresses")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListExternalAddressesRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/privateClouds/*}/externalAddresses",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListExternalAddressesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListExternalAddressesRequest> serializer =
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
                  ProtoMessageResponseParser.<ListExternalAddressesResponse>newBuilder()
                      .setDefaultInstance(ListExternalAddressesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          FetchNetworkPolicyExternalAddressesRequest, FetchNetworkPolicyExternalAddressesResponse>
      fetchNetworkPolicyExternalAddressesMethodDescriptor =
          ApiMethodDescriptor
              .<FetchNetworkPolicyExternalAddressesRequest,
                  FetchNetworkPolicyExternalAddressesResponse>
                  newBuilder()
              .setFullMethodName(
                  "google.cloud.vmwareengine.v1.VmwareEngine/FetchNetworkPolicyExternalAddresses")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<FetchNetworkPolicyExternalAddressesRequest>newBuilder()
                      .setPath(
                          "/v1/{networkPolicy=projects/*/locations/*/networkPolicies/*}:fetchExternalAddresses",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<FetchNetworkPolicyExternalAddressesRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "networkPolicy", request.getNetworkPolicy());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<FetchNetworkPolicyExternalAddressesRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser
                      .<FetchNetworkPolicyExternalAddressesResponse>newBuilder()
                      .setDefaultInstance(
                          FetchNetworkPolicyExternalAddressesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetExternalAddressRequest, ExternalAddress>
      getExternalAddressMethodDescriptor =
          ApiMethodDescriptor.<GetExternalAddressRequest, ExternalAddress>newBuilder()
              .setFullMethodName("google.cloud.vmwareengine.v1.VmwareEngine/GetExternalAddress")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetExternalAddressRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/privateClouds/*/externalAddresses/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetExternalAddressRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetExternalAddressRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ExternalAddress>newBuilder()
                      .setDefaultInstance(ExternalAddress.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateExternalAddressRequest, Operation>
      createExternalAddressMethodDescriptor =
          ApiMethodDescriptor.<CreateExternalAddressRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.vmwareengine.v1.VmwareEngine/CreateExternalAddress")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateExternalAddressRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/privateClouds/*}/externalAddresses",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateExternalAddressRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateExternalAddressRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "externalAddressId", request.getExternalAddressId());
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("externalAddress", request.getExternalAddress(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateExternalAddressRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<UpdateExternalAddressRequest, Operation>
      updateExternalAddressMethodDescriptor =
          ApiMethodDescriptor.<UpdateExternalAddressRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.vmwareengine.v1.VmwareEngine/UpdateExternalAddress")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateExternalAddressRequest>newBuilder()
                      .setPath(
                          "/v1/{externalAddress.name=projects/*/locations/*/privateClouds/*/externalAddresses/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateExternalAddressRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields,
                                "externalAddress.name",
                                request.getExternalAddress().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateExternalAddressRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("externalAddress", request.getExternalAddress(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateExternalAddressRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeleteExternalAddressRequest, Operation>
      deleteExternalAddressMethodDescriptor =
          ApiMethodDescriptor.<DeleteExternalAddressRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.vmwareengine.v1.VmwareEngine/DeleteExternalAddress")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteExternalAddressRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/privateClouds/*/externalAddresses/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteExternalAddressRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteExternalAddressRequest> serializer =
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
                  (DeleteExternalAddressRequest request, Operation response) ->
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
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
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

  private static final ApiMethodDescriptor<GetSubnetRequest, Subnet> getSubnetMethodDescriptor =
      ApiMethodDescriptor.<GetSubnetRequest, Subnet>newBuilder()
          .setFullMethodName("google.cloud.vmwareengine.v1.VmwareEngine/GetSubnet")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetSubnetRequest>newBuilder()
                  .setPath(
                      "/v1/{name=projects/*/locations/*/privateClouds/*/subnets/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetSubnetRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetSubnetRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Subnet>newBuilder()
                  .setDefaultInstance(Subnet.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<UpdateSubnetRequest, Operation>
      updateSubnetMethodDescriptor =
          ApiMethodDescriptor.<UpdateSubnetRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.vmwareengine.v1.VmwareEngine/UpdateSubnet")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateSubnetRequest>newBuilder()
                      .setPath(
                          "/v1/{subnet.name=projects/*/locations/*/privateClouds/*/subnets/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateSubnetRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "subnet.name", request.getSubnet().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateSubnetRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("subnet", request.getSubnet(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateSubnetRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<
          ListExternalAccessRulesRequest, ListExternalAccessRulesResponse>
      listExternalAccessRulesMethodDescriptor =
          ApiMethodDescriptor
              .<ListExternalAccessRulesRequest, ListExternalAccessRulesResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.vmwareengine.v1.VmwareEngine/ListExternalAccessRules")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListExternalAccessRulesRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/networkPolicies/*}/externalAccessRules",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListExternalAccessRulesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListExternalAccessRulesRequest> serializer =
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
                  ProtoMessageResponseParser.<ListExternalAccessRulesResponse>newBuilder()
                      .setDefaultInstance(ListExternalAccessRulesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetExternalAccessRuleRequest, ExternalAccessRule>
      getExternalAccessRuleMethodDescriptor =
          ApiMethodDescriptor.<GetExternalAccessRuleRequest, ExternalAccessRule>newBuilder()
              .setFullMethodName("google.cloud.vmwareengine.v1.VmwareEngine/GetExternalAccessRule")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetExternalAccessRuleRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/networkPolicies/*/externalAccessRules/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetExternalAccessRuleRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetExternalAccessRuleRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ExternalAccessRule>newBuilder()
                      .setDefaultInstance(ExternalAccessRule.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateExternalAccessRuleRequest, Operation>
      createExternalAccessRuleMethodDescriptor =
          ApiMethodDescriptor.<CreateExternalAccessRuleRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.vmwareengine.v1.VmwareEngine/CreateExternalAccessRule")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateExternalAccessRuleRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/networkPolicies/*}/externalAccessRules",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateExternalAccessRuleRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateExternalAccessRuleRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "externalAccessRuleId", request.getExternalAccessRuleId());
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "externalAccessRule", request.getExternalAccessRule(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateExternalAccessRuleRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<UpdateExternalAccessRuleRequest, Operation>
      updateExternalAccessRuleMethodDescriptor =
          ApiMethodDescriptor.<UpdateExternalAccessRuleRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.vmwareengine.v1.VmwareEngine/UpdateExternalAccessRule")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateExternalAccessRuleRequest>newBuilder()
                      .setPath(
                          "/v1/{externalAccessRule.name=projects/*/locations/*/networkPolicies/*/externalAccessRules/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateExternalAccessRuleRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields,
                                "externalAccessRule.name",
                                request.getExternalAccessRule().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateExternalAccessRuleRequest> serializer =
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
                                      "externalAccessRule", request.getExternalAccessRule(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateExternalAccessRuleRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeleteExternalAccessRuleRequest, Operation>
      deleteExternalAccessRuleMethodDescriptor =
          ApiMethodDescriptor.<DeleteExternalAccessRuleRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.vmwareengine.v1.VmwareEngine/DeleteExternalAccessRule")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteExternalAccessRuleRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/networkPolicies/*/externalAccessRules/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteExternalAccessRuleRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteExternalAccessRuleRequest> serializer =
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
                  (DeleteExternalAccessRuleRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<ListLoggingServersRequest, ListLoggingServersResponse>
      listLoggingServersMethodDescriptor =
          ApiMethodDescriptor.<ListLoggingServersRequest, ListLoggingServersResponse>newBuilder()
              .setFullMethodName("google.cloud.vmwareengine.v1.VmwareEngine/ListLoggingServers")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListLoggingServersRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/privateClouds/*}/loggingServers",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListLoggingServersRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListLoggingServersRequest> serializer =
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
                  ProtoMessageResponseParser.<ListLoggingServersResponse>newBuilder()
                      .setDefaultInstance(ListLoggingServersResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetLoggingServerRequest, LoggingServer>
      getLoggingServerMethodDescriptor =
          ApiMethodDescriptor.<GetLoggingServerRequest, LoggingServer>newBuilder()
              .setFullMethodName("google.cloud.vmwareengine.v1.VmwareEngine/GetLoggingServer")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetLoggingServerRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/privateClouds/*/loggingServers/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetLoggingServerRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetLoggingServerRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<LoggingServer>newBuilder()
                      .setDefaultInstance(LoggingServer.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateLoggingServerRequest, Operation>
      createLoggingServerMethodDescriptor =
          ApiMethodDescriptor.<CreateLoggingServerRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.vmwareengine.v1.VmwareEngine/CreateLoggingServer")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateLoggingServerRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/privateClouds/*}/loggingServers",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateLoggingServerRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateLoggingServerRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "loggingServerId", request.getLoggingServerId());
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("loggingServer", request.getLoggingServer(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateLoggingServerRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<UpdateLoggingServerRequest, Operation>
      updateLoggingServerMethodDescriptor =
          ApiMethodDescriptor.<UpdateLoggingServerRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.vmwareengine.v1.VmwareEngine/UpdateLoggingServer")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateLoggingServerRequest>newBuilder()
                      .setPath(
                          "/v1/{loggingServer.name=projects/*/locations/*/privateClouds/*/loggingServers/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateLoggingServerRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "loggingServer.name", request.getLoggingServer().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateLoggingServerRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("loggingServer", request.getLoggingServer(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateLoggingServerRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeleteLoggingServerRequest, Operation>
      deleteLoggingServerMethodDescriptor =
          ApiMethodDescriptor.<DeleteLoggingServerRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.vmwareengine.v1.VmwareEngine/DeleteLoggingServer")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteLoggingServerRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/privateClouds/*/loggingServers/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteLoggingServerRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteLoggingServerRequest> serializer =
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
                  (DeleteLoggingServerRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
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
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
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
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
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
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
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
                            serializer.putQueryParam(fields, "username", request.getUsername());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
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
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "*", request.toBuilder().clearPrivateCloud().build(), true))
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
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "*", request.toBuilder().clearPrivateCloud().build(), true))
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

  private static final ApiMethodDescriptor<GetDnsForwardingRequest, DnsForwarding>
      getDnsForwardingMethodDescriptor =
          ApiMethodDescriptor.<GetDnsForwardingRequest, DnsForwarding>newBuilder()
              .setFullMethodName("google.cloud.vmwareengine.v1.VmwareEngine/GetDnsForwarding")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetDnsForwardingRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/privateClouds/*/dnsForwarding}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetDnsForwardingRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetDnsForwardingRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<DnsForwarding>newBuilder()
                      .setDefaultInstance(DnsForwarding.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateDnsForwardingRequest, Operation>
      updateDnsForwardingMethodDescriptor =
          ApiMethodDescriptor.<UpdateDnsForwardingRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.vmwareengine.v1.VmwareEngine/UpdateDnsForwarding")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateDnsForwardingRequest>newBuilder()
                      .setPath(
                          "/v1/{dnsForwarding.name=projects/*/locations/*/privateClouds/*/dnsForwarding}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateDnsForwardingRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "dnsForwarding.name", request.getDnsForwarding().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateDnsForwardingRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("dnsForwarding", request.getDnsForwarding(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateDnsForwardingRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<GetNetworkPeeringRequest, NetworkPeering>
      getNetworkPeeringMethodDescriptor =
          ApiMethodDescriptor.<GetNetworkPeeringRequest, NetworkPeering>newBuilder()
              .setFullMethodName("google.cloud.vmwareengine.v1.VmwareEngine/GetNetworkPeering")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetNetworkPeeringRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/networkPeerings/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetNetworkPeeringRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetNetworkPeeringRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<NetworkPeering>newBuilder()
                      .setDefaultInstance(NetworkPeering.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListNetworkPeeringsRequest, ListNetworkPeeringsResponse>
      listNetworkPeeringsMethodDescriptor =
          ApiMethodDescriptor.<ListNetworkPeeringsRequest, ListNetworkPeeringsResponse>newBuilder()
              .setFullMethodName("google.cloud.vmwareengine.v1.VmwareEngine/ListNetworkPeerings")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListNetworkPeeringsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/networkPeerings",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListNetworkPeeringsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListNetworkPeeringsRequest> serializer =
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
                  ProtoMessageResponseParser.<ListNetworkPeeringsResponse>newBuilder()
                      .setDefaultInstance(ListNetworkPeeringsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateNetworkPeeringRequest, Operation>
      createNetworkPeeringMethodDescriptor =
          ApiMethodDescriptor.<CreateNetworkPeeringRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.vmwareengine.v1.VmwareEngine/CreateNetworkPeering")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateNetworkPeeringRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/networkPeerings",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateNetworkPeeringRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateNetworkPeeringRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "networkPeeringId", request.getNetworkPeeringId());
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("networkPeering", request.getNetworkPeering(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateNetworkPeeringRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeleteNetworkPeeringRequest, Operation>
      deleteNetworkPeeringMethodDescriptor =
          ApiMethodDescriptor.<DeleteNetworkPeeringRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.vmwareengine.v1.VmwareEngine/DeleteNetworkPeering")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteNetworkPeeringRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/networkPeerings/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteNetworkPeeringRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteNetworkPeeringRequest> serializer =
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
                  (DeleteNetworkPeeringRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<UpdateNetworkPeeringRequest, Operation>
      updateNetworkPeeringMethodDescriptor =
          ApiMethodDescriptor.<UpdateNetworkPeeringRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.vmwareengine.v1.VmwareEngine/UpdateNetworkPeering")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateNetworkPeeringRequest>newBuilder()
                      .setPath(
                          "/v1/{networkPeering.name=projects/*/locations/*/networkPeerings/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateNetworkPeeringRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields,
                                "networkPeering.name",
                                request.getNetworkPeering().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateNetworkPeeringRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("networkPeering", request.getNetworkPeering(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateNetworkPeeringRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<ListPeeringRoutesRequest, ListPeeringRoutesResponse>
      listPeeringRoutesMethodDescriptor =
          ApiMethodDescriptor.<ListPeeringRoutesRequest, ListPeeringRoutesResponse>newBuilder()
              .setFullMethodName("google.cloud.vmwareengine.v1.VmwareEngine/ListPeeringRoutes")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListPeeringRoutesRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/networkPeerings/*}/peeringRoutes",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListPeeringRoutesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListPeeringRoutesRequest> serializer =
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
                  ProtoMessageResponseParser.<ListPeeringRoutesResponse>newBuilder()
                      .setDefaultInstance(ListPeeringRoutesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
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
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("hcxActivationKey", request.getHcxActivationKey(), true))
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
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
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
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
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
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
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
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
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
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("networkPolicy", request.getNetworkPolicy(), true))
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
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("networkPolicy", request.getNetworkPolicy(), true))
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
                  (DeleteNetworkPolicyRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<
          ListManagementDnsZoneBindingsRequest, ListManagementDnsZoneBindingsResponse>
      listManagementDnsZoneBindingsMethodDescriptor =
          ApiMethodDescriptor
              .<ListManagementDnsZoneBindingsRequest, ListManagementDnsZoneBindingsResponse>
                  newBuilder()
              .setFullMethodName(
                  "google.cloud.vmwareengine.v1.VmwareEngine/ListManagementDnsZoneBindings")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListManagementDnsZoneBindingsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/privateClouds/*}/managementDnsZoneBindings",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListManagementDnsZoneBindingsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListManagementDnsZoneBindingsRequest> serializer =
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
                  ProtoMessageResponseParser.<ListManagementDnsZoneBindingsResponse>newBuilder()
                      .setDefaultInstance(
                          ListManagementDnsZoneBindingsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          GetManagementDnsZoneBindingRequest, ManagementDnsZoneBinding>
      getManagementDnsZoneBindingMethodDescriptor =
          ApiMethodDescriptor
              .<GetManagementDnsZoneBindingRequest, ManagementDnsZoneBinding>newBuilder()
              .setFullMethodName(
                  "google.cloud.vmwareengine.v1.VmwareEngine/GetManagementDnsZoneBinding")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetManagementDnsZoneBindingRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/privateClouds/*/managementDnsZoneBindings/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetManagementDnsZoneBindingRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetManagementDnsZoneBindingRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ManagementDnsZoneBinding>newBuilder()
                      .setDefaultInstance(ManagementDnsZoneBinding.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateManagementDnsZoneBindingRequest, Operation>
      createManagementDnsZoneBindingMethodDescriptor =
          ApiMethodDescriptor.<CreateManagementDnsZoneBindingRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.vmwareengine.v1.VmwareEngine/CreateManagementDnsZoneBinding")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateManagementDnsZoneBindingRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/privateClouds/*}/managementDnsZoneBindings",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateManagementDnsZoneBindingRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateManagementDnsZoneBindingRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields,
                                "managementDnsZoneBindingId",
                                request.getManagementDnsZoneBindingId());
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "managementDnsZoneBinding",
                                      request.getManagementDnsZoneBinding(),
                                      true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateManagementDnsZoneBindingRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<UpdateManagementDnsZoneBindingRequest, Operation>
      updateManagementDnsZoneBindingMethodDescriptor =
          ApiMethodDescriptor.<UpdateManagementDnsZoneBindingRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.vmwareengine.v1.VmwareEngine/UpdateManagementDnsZoneBinding")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateManagementDnsZoneBindingRequest>newBuilder()
                      .setPath(
                          "/v1/{managementDnsZoneBinding.name=projects/*/locations/*/privateClouds/*/managementDnsZoneBindings/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateManagementDnsZoneBindingRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields,
                                "managementDnsZoneBinding.name",
                                request.getManagementDnsZoneBinding().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateManagementDnsZoneBindingRequest> serializer =
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
                                      "managementDnsZoneBinding",
                                      request.getManagementDnsZoneBinding(),
                                      true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateManagementDnsZoneBindingRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeleteManagementDnsZoneBindingRequest, Operation>
      deleteManagementDnsZoneBindingMethodDescriptor =
          ApiMethodDescriptor.<DeleteManagementDnsZoneBindingRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.vmwareengine.v1.VmwareEngine/DeleteManagementDnsZoneBinding")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteManagementDnsZoneBindingRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/privateClouds/*/managementDnsZoneBindings/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteManagementDnsZoneBindingRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteManagementDnsZoneBindingRequest> serializer =
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
                  (DeleteManagementDnsZoneBindingRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<RepairManagementDnsZoneBindingRequest, Operation>
      repairManagementDnsZoneBindingMethodDescriptor =
          ApiMethodDescriptor.<RepairManagementDnsZoneBindingRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.vmwareengine.v1.VmwareEngine/RepairManagementDnsZoneBinding")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<RepairManagementDnsZoneBindingRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/privateClouds/*/managementDnsZoneBindings/*}:repair",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<RepairManagementDnsZoneBindingRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<RepairManagementDnsZoneBindingRequest> serializer =
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
                  (RepairManagementDnsZoneBindingRequest request, Operation response) ->
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
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "vmwareEngineNetwork",
                                      request.getVmwareEngineNetwork(),
                                      true))
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
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "vmwareEngineNetwork",
                                      request.getVmwareEngineNetwork(),
                                      true))
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
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
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
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
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

  private static final ApiMethodDescriptor<CreatePrivateConnectionRequest, Operation>
      createPrivateConnectionMethodDescriptor =
          ApiMethodDescriptor.<CreatePrivateConnectionRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.vmwareengine.v1.VmwareEngine/CreatePrivateConnection")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreatePrivateConnectionRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/privateConnections",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreatePrivateConnectionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreatePrivateConnectionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "privateConnectionId", request.getPrivateConnectionId());
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "privateConnection", request.getPrivateConnection(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreatePrivateConnectionRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<GetPrivateConnectionRequest, PrivateConnection>
      getPrivateConnectionMethodDescriptor =
          ApiMethodDescriptor.<GetPrivateConnectionRequest, PrivateConnection>newBuilder()
              .setFullMethodName("google.cloud.vmwareengine.v1.VmwareEngine/GetPrivateConnection")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetPrivateConnectionRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/privateConnections/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetPrivateConnectionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetPrivateConnectionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<PrivateConnection>newBuilder()
                      .setDefaultInstance(PrivateConnection.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListPrivateConnectionsRequest, ListPrivateConnectionsResponse>
      listPrivateConnectionsMethodDescriptor =
          ApiMethodDescriptor
              .<ListPrivateConnectionsRequest, ListPrivateConnectionsResponse>newBuilder()
              .setFullMethodName("google.cloud.vmwareengine.v1.VmwareEngine/ListPrivateConnections")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListPrivateConnectionsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/privateConnections",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListPrivateConnectionsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListPrivateConnectionsRequest> serializer =
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
                  ProtoMessageResponseParser.<ListPrivateConnectionsResponse>newBuilder()
                      .setDefaultInstance(ListPrivateConnectionsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdatePrivateConnectionRequest, Operation>
      updatePrivateConnectionMethodDescriptor =
          ApiMethodDescriptor.<UpdatePrivateConnectionRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.vmwareengine.v1.VmwareEngine/UpdatePrivateConnection")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdatePrivateConnectionRequest>newBuilder()
                      .setPath(
                          "/v1/{privateConnection.name=projects/*/locations/*/privateConnections/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdatePrivateConnectionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields,
                                "privateConnection.name",
                                request.getPrivateConnection().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdatePrivateConnectionRequest> serializer =
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
                                      "privateConnection", request.getPrivateConnection(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdatePrivateConnectionRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeletePrivateConnectionRequest, Operation>
      deletePrivateConnectionMethodDescriptor =
          ApiMethodDescriptor.<DeletePrivateConnectionRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.vmwareengine.v1.VmwareEngine/DeletePrivateConnection")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeletePrivateConnectionRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/privateConnections/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeletePrivateConnectionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeletePrivateConnectionRequest> serializer =
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
                  (DeletePrivateConnectionRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<
          ListPrivateConnectionPeeringRoutesRequest, ListPrivateConnectionPeeringRoutesResponse>
      listPrivateConnectionPeeringRoutesMethodDescriptor =
          ApiMethodDescriptor
              .<ListPrivateConnectionPeeringRoutesRequest,
                  ListPrivateConnectionPeeringRoutesResponse>
                  newBuilder()
              .setFullMethodName(
                  "google.cloud.vmwareengine.v1.VmwareEngine/ListPrivateConnectionPeeringRoutes")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<ListPrivateConnectionPeeringRoutesRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/privateConnections/*}/peeringRoutes",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListPrivateConnectionPeeringRoutesRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListPrivateConnectionPeeringRoutesRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser
                      .<ListPrivateConnectionPeeringRoutesResponse>newBuilder()
                      .setDefaultInstance(
                          ListPrivateConnectionPeeringRoutesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GrantDnsBindPermissionRequest, Operation>
      grantDnsBindPermissionMethodDescriptor =
          ApiMethodDescriptor.<GrantDnsBindPermissionRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.vmwareengine.v1.VmwareEngine/GrantDnsBindPermission")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GrantDnsBindPermissionRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/dnsBindPermission}:grant",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GrantDnsBindPermissionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GrantDnsBindPermissionRequest> serializer =
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
                  (GrantDnsBindPermissionRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<GetDnsBindPermissionRequest, DnsBindPermission>
      getDnsBindPermissionMethodDescriptor =
          ApiMethodDescriptor.<GetDnsBindPermissionRequest, DnsBindPermission>newBuilder()
              .setFullMethodName("google.cloud.vmwareengine.v1.VmwareEngine/GetDnsBindPermission")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetDnsBindPermissionRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/dnsBindPermission}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetDnsBindPermissionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetDnsBindPermissionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<DnsBindPermission>newBuilder()
                      .setDefaultInstance(DnsBindPermission.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<RevokeDnsBindPermissionRequest, Operation>
      revokeDnsBindPermissionMethodDescriptor =
          ApiMethodDescriptor.<RevokeDnsBindPermissionRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.vmwareengine.v1.VmwareEngine/RevokeDnsBindPermission")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<RevokeDnsBindPermissionRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/dnsBindPermission}:revoke",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<RevokeDnsBindPermissionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<RevokeDnsBindPermissionRequest> serializer =
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
                  (RevokeDnsBindPermissionRequest request, Operation response) ->
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
  private final UnaryCallable<ListNodesRequest, ListNodesResponse> listNodesCallable;
  private final UnaryCallable<ListNodesRequest, ListNodesPagedResponse> listNodesPagedCallable;
  private final UnaryCallable<GetNodeRequest, Node> getNodeCallable;
  private final UnaryCallable<ListExternalAddressesRequest, ListExternalAddressesResponse>
      listExternalAddressesCallable;
  private final UnaryCallable<ListExternalAddressesRequest, ListExternalAddressesPagedResponse>
      listExternalAddressesPagedCallable;
  private final UnaryCallable<
          FetchNetworkPolicyExternalAddressesRequest, FetchNetworkPolicyExternalAddressesResponse>
      fetchNetworkPolicyExternalAddressesCallable;
  private final UnaryCallable<
          FetchNetworkPolicyExternalAddressesRequest,
          FetchNetworkPolicyExternalAddressesPagedResponse>
      fetchNetworkPolicyExternalAddressesPagedCallable;
  private final UnaryCallable<GetExternalAddressRequest, ExternalAddress>
      getExternalAddressCallable;
  private final UnaryCallable<CreateExternalAddressRequest, Operation>
      createExternalAddressCallable;
  private final OperationCallable<CreateExternalAddressRequest, ExternalAddress, OperationMetadata>
      createExternalAddressOperationCallable;
  private final UnaryCallable<UpdateExternalAddressRequest, Operation>
      updateExternalAddressCallable;
  private final OperationCallable<UpdateExternalAddressRequest, ExternalAddress, OperationMetadata>
      updateExternalAddressOperationCallable;
  private final UnaryCallable<DeleteExternalAddressRequest, Operation>
      deleteExternalAddressCallable;
  private final OperationCallable<DeleteExternalAddressRequest, Empty, OperationMetadata>
      deleteExternalAddressOperationCallable;
  private final UnaryCallable<ListSubnetsRequest, ListSubnetsResponse> listSubnetsCallable;
  private final UnaryCallable<ListSubnetsRequest, ListSubnetsPagedResponse>
      listSubnetsPagedCallable;
  private final UnaryCallable<GetSubnetRequest, Subnet> getSubnetCallable;
  private final UnaryCallable<UpdateSubnetRequest, Operation> updateSubnetCallable;
  private final OperationCallable<UpdateSubnetRequest, Subnet, OperationMetadata>
      updateSubnetOperationCallable;
  private final UnaryCallable<ListExternalAccessRulesRequest, ListExternalAccessRulesResponse>
      listExternalAccessRulesCallable;
  private final UnaryCallable<ListExternalAccessRulesRequest, ListExternalAccessRulesPagedResponse>
      listExternalAccessRulesPagedCallable;
  private final UnaryCallable<GetExternalAccessRuleRequest, ExternalAccessRule>
      getExternalAccessRuleCallable;
  private final UnaryCallable<CreateExternalAccessRuleRequest, Operation>
      createExternalAccessRuleCallable;
  private final OperationCallable<
          CreateExternalAccessRuleRequest, ExternalAccessRule, OperationMetadata>
      createExternalAccessRuleOperationCallable;
  private final UnaryCallable<UpdateExternalAccessRuleRequest, Operation>
      updateExternalAccessRuleCallable;
  private final OperationCallable<
          UpdateExternalAccessRuleRequest, ExternalAccessRule, OperationMetadata>
      updateExternalAccessRuleOperationCallable;
  private final UnaryCallable<DeleteExternalAccessRuleRequest, Operation>
      deleteExternalAccessRuleCallable;
  private final OperationCallable<DeleteExternalAccessRuleRequest, Empty, OperationMetadata>
      deleteExternalAccessRuleOperationCallable;
  private final UnaryCallable<ListLoggingServersRequest, ListLoggingServersResponse>
      listLoggingServersCallable;
  private final UnaryCallable<ListLoggingServersRequest, ListLoggingServersPagedResponse>
      listLoggingServersPagedCallable;
  private final UnaryCallable<GetLoggingServerRequest, LoggingServer> getLoggingServerCallable;
  private final UnaryCallable<CreateLoggingServerRequest, Operation> createLoggingServerCallable;
  private final OperationCallable<CreateLoggingServerRequest, LoggingServer, OperationMetadata>
      createLoggingServerOperationCallable;
  private final UnaryCallable<UpdateLoggingServerRequest, Operation> updateLoggingServerCallable;
  private final OperationCallable<UpdateLoggingServerRequest, LoggingServer, OperationMetadata>
      updateLoggingServerOperationCallable;
  private final UnaryCallable<DeleteLoggingServerRequest, Operation> deleteLoggingServerCallable;
  private final OperationCallable<DeleteLoggingServerRequest, Empty, OperationMetadata>
      deleteLoggingServerOperationCallable;
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
  private final UnaryCallable<GetDnsForwardingRequest, DnsForwarding> getDnsForwardingCallable;
  private final UnaryCallable<UpdateDnsForwardingRequest, Operation> updateDnsForwardingCallable;
  private final OperationCallable<UpdateDnsForwardingRequest, DnsForwarding, OperationMetadata>
      updateDnsForwardingOperationCallable;
  private final UnaryCallable<GetNetworkPeeringRequest, NetworkPeering> getNetworkPeeringCallable;
  private final UnaryCallable<ListNetworkPeeringsRequest, ListNetworkPeeringsResponse>
      listNetworkPeeringsCallable;
  private final UnaryCallable<ListNetworkPeeringsRequest, ListNetworkPeeringsPagedResponse>
      listNetworkPeeringsPagedCallable;
  private final UnaryCallable<CreateNetworkPeeringRequest, Operation> createNetworkPeeringCallable;
  private final OperationCallable<CreateNetworkPeeringRequest, NetworkPeering, OperationMetadata>
      createNetworkPeeringOperationCallable;
  private final UnaryCallable<DeleteNetworkPeeringRequest, Operation> deleteNetworkPeeringCallable;
  private final OperationCallable<DeleteNetworkPeeringRequest, Empty, OperationMetadata>
      deleteNetworkPeeringOperationCallable;
  private final UnaryCallable<UpdateNetworkPeeringRequest, Operation> updateNetworkPeeringCallable;
  private final OperationCallable<UpdateNetworkPeeringRequest, NetworkPeering, OperationMetadata>
      updateNetworkPeeringOperationCallable;
  private final UnaryCallable<ListPeeringRoutesRequest, ListPeeringRoutesResponse>
      listPeeringRoutesCallable;
  private final UnaryCallable<ListPeeringRoutesRequest, ListPeeringRoutesPagedResponse>
      listPeeringRoutesPagedCallable;
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
  private final UnaryCallable<
          ListManagementDnsZoneBindingsRequest, ListManagementDnsZoneBindingsResponse>
      listManagementDnsZoneBindingsCallable;
  private final UnaryCallable<
          ListManagementDnsZoneBindingsRequest, ListManagementDnsZoneBindingsPagedResponse>
      listManagementDnsZoneBindingsPagedCallable;
  private final UnaryCallable<GetManagementDnsZoneBindingRequest, ManagementDnsZoneBinding>
      getManagementDnsZoneBindingCallable;
  private final UnaryCallable<CreateManagementDnsZoneBindingRequest, Operation>
      createManagementDnsZoneBindingCallable;
  private final OperationCallable<
          CreateManagementDnsZoneBindingRequest, ManagementDnsZoneBinding, OperationMetadata>
      createManagementDnsZoneBindingOperationCallable;
  private final UnaryCallable<UpdateManagementDnsZoneBindingRequest, Operation>
      updateManagementDnsZoneBindingCallable;
  private final OperationCallable<
          UpdateManagementDnsZoneBindingRequest, ManagementDnsZoneBinding, OperationMetadata>
      updateManagementDnsZoneBindingOperationCallable;
  private final UnaryCallable<DeleteManagementDnsZoneBindingRequest, Operation>
      deleteManagementDnsZoneBindingCallable;
  private final OperationCallable<DeleteManagementDnsZoneBindingRequest, Empty, OperationMetadata>
      deleteManagementDnsZoneBindingOperationCallable;
  private final UnaryCallable<RepairManagementDnsZoneBindingRequest, Operation>
      repairManagementDnsZoneBindingCallable;
  private final OperationCallable<
          RepairManagementDnsZoneBindingRequest, ManagementDnsZoneBinding, OperationMetadata>
      repairManagementDnsZoneBindingOperationCallable;
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
  private final UnaryCallable<CreatePrivateConnectionRequest, Operation>
      createPrivateConnectionCallable;
  private final OperationCallable<
          CreatePrivateConnectionRequest, PrivateConnection, OperationMetadata>
      createPrivateConnectionOperationCallable;
  private final UnaryCallable<GetPrivateConnectionRequest, PrivateConnection>
      getPrivateConnectionCallable;
  private final UnaryCallable<ListPrivateConnectionsRequest, ListPrivateConnectionsResponse>
      listPrivateConnectionsCallable;
  private final UnaryCallable<ListPrivateConnectionsRequest, ListPrivateConnectionsPagedResponse>
      listPrivateConnectionsPagedCallable;
  private final UnaryCallable<UpdatePrivateConnectionRequest, Operation>
      updatePrivateConnectionCallable;
  private final OperationCallable<
          UpdatePrivateConnectionRequest, PrivateConnection, OperationMetadata>
      updatePrivateConnectionOperationCallable;
  private final UnaryCallable<DeletePrivateConnectionRequest, Operation>
      deletePrivateConnectionCallable;
  private final OperationCallable<DeletePrivateConnectionRequest, Empty, OperationMetadata>
      deletePrivateConnectionOperationCallable;
  private final UnaryCallable<
          ListPrivateConnectionPeeringRoutesRequest, ListPrivateConnectionPeeringRoutesResponse>
      listPrivateConnectionPeeringRoutesCallable;
  private final UnaryCallable<
          ListPrivateConnectionPeeringRoutesRequest,
          ListPrivateConnectionPeeringRoutesPagedResponse>
      listPrivateConnectionPeeringRoutesPagedCallable;
  private final UnaryCallable<GrantDnsBindPermissionRequest, Operation>
      grantDnsBindPermissionCallable;
  private final OperationCallable<
          GrantDnsBindPermissionRequest, DnsBindPermission, OperationMetadata>
      grantDnsBindPermissionOperationCallable;
  private final UnaryCallable<GetDnsBindPermissionRequest, DnsBindPermission>
      getDnsBindPermissionCallable;
  private final UnaryCallable<RevokeDnsBindPermissionRequest, Operation>
      revokeDnsBindPermissionCallable;
  private final OperationCallable<
          RevokeDnsBindPermissionRequest, DnsBindPermission, OperationMetadata>
      revokeDnsBindPermissionOperationCallable;
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
        HttpJsonOperationsStub.create(
            clientContext,
            callableFactory,
            typeRegistry,
            ImmutableMap.<String, HttpRule>builder()
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

    HttpJsonCallSettings<ListPrivateCloudsRequest, ListPrivateCloudsResponse>
        listPrivateCloudsTransportSettings =
            HttpJsonCallSettings.<ListPrivateCloudsRequest, ListPrivateCloudsResponse>newBuilder()
                .setMethodDescriptor(listPrivateCloudsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetPrivateCloudRequest, PrivateCloud> getPrivateCloudTransportSettings =
        HttpJsonCallSettings.<GetPrivateCloudRequest, PrivateCloud>newBuilder()
            .setMethodDescriptor(getPrivateCloudMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<CreatePrivateCloudRequest, Operation> createPrivateCloudTransportSettings =
        HttpJsonCallSettings.<CreatePrivateCloudRequest, Operation>newBuilder()
            .setMethodDescriptor(createPrivateCloudMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<UpdatePrivateCloudRequest, Operation> updatePrivateCloudTransportSettings =
        HttpJsonCallSettings.<UpdatePrivateCloudRequest, Operation>newBuilder()
            .setMethodDescriptor(updatePrivateCloudMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(
                      "private_cloud.name", String.valueOf(request.getPrivateCloud().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeletePrivateCloudRequest, Operation> deletePrivateCloudTransportSettings =
        HttpJsonCallSettings.<DeletePrivateCloudRequest, Operation>newBuilder()
            .setMethodDescriptor(deletePrivateCloudMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<UndeletePrivateCloudRequest, Operation>
        undeletePrivateCloudTransportSettings =
            HttpJsonCallSettings.<UndeletePrivateCloudRequest, Operation>newBuilder()
                .setMethodDescriptor(undeletePrivateCloudMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
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
    HttpJsonCallSettings<ListNodesRequest, ListNodesResponse> listNodesTransportSettings =
        HttpJsonCallSettings.<ListNodesRequest, ListNodesResponse>newBuilder()
            .setMethodDescriptor(listNodesMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<GetNodeRequest, Node> getNodeTransportSettings =
        HttpJsonCallSettings.<GetNodeRequest, Node>newBuilder()
            .setMethodDescriptor(getNodeMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListExternalAddressesRequest, ListExternalAddressesResponse>
        listExternalAddressesTransportSettings =
            HttpJsonCallSettings
                .<ListExternalAddressesRequest, ListExternalAddressesResponse>newBuilder()
                .setMethodDescriptor(listExternalAddressesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<
            FetchNetworkPolicyExternalAddressesRequest, FetchNetworkPolicyExternalAddressesResponse>
        fetchNetworkPolicyExternalAddressesTransportSettings =
            HttpJsonCallSettings
                .<FetchNetworkPolicyExternalAddressesRequest,
                    FetchNetworkPolicyExternalAddressesResponse>
                    newBuilder()
                .setMethodDescriptor(fetchNetworkPolicyExternalAddressesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("network_policy", String.valueOf(request.getNetworkPolicy()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetExternalAddressRequest, ExternalAddress>
        getExternalAddressTransportSettings =
            HttpJsonCallSettings.<GetExternalAddressRequest, ExternalAddress>newBuilder()
                .setMethodDescriptor(getExternalAddressMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<CreateExternalAddressRequest, Operation>
        createExternalAddressTransportSettings =
            HttpJsonCallSettings.<CreateExternalAddressRequest, Operation>newBuilder()
                .setMethodDescriptor(createExternalAddressMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<UpdateExternalAddressRequest, Operation>
        updateExternalAddressTransportSettings =
            HttpJsonCallSettings.<UpdateExternalAddressRequest, Operation>newBuilder()
                .setMethodDescriptor(updateExternalAddressMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "external_address.name",
                          String.valueOf(request.getExternalAddress().getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<DeleteExternalAddressRequest, Operation>
        deleteExternalAddressTransportSettings =
            HttpJsonCallSettings.<DeleteExternalAddressRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteExternalAddressMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ListSubnetsRequest, ListSubnetsResponse> listSubnetsTransportSettings =
        HttpJsonCallSettings.<ListSubnetsRequest, ListSubnetsResponse>newBuilder()
            .setMethodDescriptor(listSubnetsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<GetSubnetRequest, Subnet> getSubnetTransportSettings =
        HttpJsonCallSettings.<GetSubnetRequest, Subnet>newBuilder()
            .setMethodDescriptor(getSubnetMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<UpdateSubnetRequest, Operation> updateSubnetTransportSettings =
        HttpJsonCallSettings.<UpdateSubnetRequest, Operation>newBuilder()
            .setMethodDescriptor(updateSubnetMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("subnet.name", String.valueOf(request.getSubnet().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListExternalAccessRulesRequest, ListExternalAccessRulesResponse>
        listExternalAccessRulesTransportSettings =
            HttpJsonCallSettings
                .<ListExternalAccessRulesRequest, ListExternalAccessRulesResponse>newBuilder()
                .setMethodDescriptor(listExternalAccessRulesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetExternalAccessRuleRequest, ExternalAccessRule>
        getExternalAccessRuleTransportSettings =
            HttpJsonCallSettings.<GetExternalAccessRuleRequest, ExternalAccessRule>newBuilder()
                .setMethodDescriptor(getExternalAccessRuleMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<CreateExternalAccessRuleRequest, Operation>
        createExternalAccessRuleTransportSettings =
            HttpJsonCallSettings.<CreateExternalAccessRuleRequest, Operation>newBuilder()
                .setMethodDescriptor(createExternalAccessRuleMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<UpdateExternalAccessRuleRequest, Operation>
        updateExternalAccessRuleTransportSettings =
            HttpJsonCallSettings.<UpdateExternalAccessRuleRequest, Operation>newBuilder()
                .setMethodDescriptor(updateExternalAccessRuleMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "external_access_rule.name",
                          String.valueOf(request.getExternalAccessRule().getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<DeleteExternalAccessRuleRequest, Operation>
        deleteExternalAccessRuleTransportSettings =
            HttpJsonCallSettings.<DeleteExternalAccessRuleRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteExternalAccessRuleMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ListLoggingServersRequest, ListLoggingServersResponse>
        listLoggingServersTransportSettings =
            HttpJsonCallSettings.<ListLoggingServersRequest, ListLoggingServersResponse>newBuilder()
                .setMethodDescriptor(listLoggingServersMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetLoggingServerRequest, LoggingServer> getLoggingServerTransportSettings =
        HttpJsonCallSettings.<GetLoggingServerRequest, LoggingServer>newBuilder()
            .setMethodDescriptor(getLoggingServerMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<CreateLoggingServerRequest, Operation>
        createLoggingServerTransportSettings =
            HttpJsonCallSettings.<CreateLoggingServerRequest, Operation>newBuilder()
                .setMethodDescriptor(createLoggingServerMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<UpdateLoggingServerRequest, Operation>
        updateLoggingServerTransportSettings =
            HttpJsonCallSettings.<UpdateLoggingServerRequest, Operation>newBuilder()
                .setMethodDescriptor(updateLoggingServerMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "logging_server.name",
                          String.valueOf(request.getLoggingServer().getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<DeleteLoggingServerRequest, Operation>
        deleteLoggingServerTransportSettings =
            HttpJsonCallSettings.<DeleteLoggingServerRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteLoggingServerMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ListNodeTypesRequest, ListNodeTypesResponse>
        listNodeTypesTransportSettings =
            HttpJsonCallSettings.<ListNodeTypesRequest, ListNodeTypesResponse>newBuilder()
                .setMethodDescriptor(listNodeTypesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetNodeTypeRequest, NodeType> getNodeTypeTransportSettings =
        HttpJsonCallSettings.<GetNodeTypeRequest, NodeType>newBuilder()
            .setMethodDescriptor(getNodeTypeMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ShowNsxCredentialsRequest, Credentials>
        showNsxCredentialsTransportSettings =
            HttpJsonCallSettings.<ShowNsxCredentialsRequest, Credentials>newBuilder()
                .setMethodDescriptor(showNsxCredentialsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("private_cloud", String.valueOf(request.getPrivateCloud()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ShowVcenterCredentialsRequest, Credentials>
        showVcenterCredentialsTransportSettings =
            HttpJsonCallSettings.<ShowVcenterCredentialsRequest, Credentials>newBuilder()
                .setMethodDescriptor(showVcenterCredentialsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("private_cloud", String.valueOf(request.getPrivateCloud()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ResetNsxCredentialsRequest, Operation>
        resetNsxCredentialsTransportSettings =
            HttpJsonCallSettings.<ResetNsxCredentialsRequest, Operation>newBuilder()
                .setMethodDescriptor(resetNsxCredentialsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("private_cloud", String.valueOf(request.getPrivateCloud()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ResetVcenterCredentialsRequest, Operation>
        resetVcenterCredentialsTransportSettings =
            HttpJsonCallSettings.<ResetVcenterCredentialsRequest, Operation>newBuilder()
                .setMethodDescriptor(resetVcenterCredentialsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("private_cloud", String.valueOf(request.getPrivateCloud()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetDnsForwardingRequest, DnsForwarding> getDnsForwardingTransportSettings =
        HttpJsonCallSettings.<GetDnsForwardingRequest, DnsForwarding>newBuilder()
            .setMethodDescriptor(getDnsForwardingMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<UpdateDnsForwardingRequest, Operation>
        updateDnsForwardingTransportSettings =
            HttpJsonCallSettings.<UpdateDnsForwardingRequest, Operation>newBuilder()
                .setMethodDescriptor(updateDnsForwardingMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "dns_forwarding.name",
                          String.valueOf(request.getDnsForwarding().getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetNetworkPeeringRequest, NetworkPeering>
        getNetworkPeeringTransportSettings =
            HttpJsonCallSettings.<GetNetworkPeeringRequest, NetworkPeering>newBuilder()
                .setMethodDescriptor(getNetworkPeeringMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ListNetworkPeeringsRequest, ListNetworkPeeringsResponse>
        listNetworkPeeringsTransportSettings =
            HttpJsonCallSettings
                .<ListNetworkPeeringsRequest, ListNetworkPeeringsResponse>newBuilder()
                .setMethodDescriptor(listNetworkPeeringsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<CreateNetworkPeeringRequest, Operation>
        createNetworkPeeringTransportSettings =
            HttpJsonCallSettings.<CreateNetworkPeeringRequest, Operation>newBuilder()
                .setMethodDescriptor(createNetworkPeeringMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<DeleteNetworkPeeringRequest, Operation>
        deleteNetworkPeeringTransportSettings =
            HttpJsonCallSettings.<DeleteNetworkPeeringRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteNetworkPeeringMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<UpdateNetworkPeeringRequest, Operation>
        updateNetworkPeeringTransportSettings =
            HttpJsonCallSettings.<UpdateNetworkPeeringRequest, Operation>newBuilder()
                .setMethodDescriptor(updateNetworkPeeringMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "network_peering.name",
                          String.valueOf(request.getNetworkPeering().getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ListPeeringRoutesRequest, ListPeeringRoutesResponse>
        listPeeringRoutesTransportSettings =
            HttpJsonCallSettings.<ListPeeringRoutesRequest, ListPeeringRoutesResponse>newBuilder()
                .setMethodDescriptor(listPeeringRoutesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<CreateHcxActivationKeyRequest, Operation>
        createHcxActivationKeyTransportSettings =
            HttpJsonCallSettings.<CreateHcxActivationKeyRequest, Operation>newBuilder()
                .setMethodDescriptor(createHcxActivationKeyMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ListHcxActivationKeysRequest, ListHcxActivationKeysResponse>
        listHcxActivationKeysTransportSettings =
            HttpJsonCallSettings
                .<ListHcxActivationKeysRequest, ListHcxActivationKeysResponse>newBuilder()
                .setMethodDescriptor(listHcxActivationKeysMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetHcxActivationKeyRequest, HcxActivationKey>
        getHcxActivationKeyTransportSettings =
            HttpJsonCallSettings.<GetHcxActivationKeyRequest, HcxActivationKey>newBuilder()
                .setMethodDescriptor(getHcxActivationKeyMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetNetworkPolicyRequest, NetworkPolicy> getNetworkPolicyTransportSettings =
        HttpJsonCallSettings.<GetNetworkPolicyRequest, NetworkPolicy>newBuilder()
            .setMethodDescriptor(getNetworkPolicyMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListNetworkPoliciesRequest, ListNetworkPoliciesResponse>
        listNetworkPoliciesTransportSettings =
            HttpJsonCallSettings
                .<ListNetworkPoliciesRequest, ListNetworkPoliciesResponse>newBuilder()
                .setMethodDescriptor(listNetworkPoliciesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<CreateNetworkPolicyRequest, Operation>
        createNetworkPolicyTransportSettings =
            HttpJsonCallSettings.<CreateNetworkPolicyRequest, Operation>newBuilder()
                .setMethodDescriptor(createNetworkPolicyMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<UpdateNetworkPolicyRequest, Operation>
        updateNetworkPolicyTransportSettings =
            HttpJsonCallSettings.<UpdateNetworkPolicyRequest, Operation>newBuilder()
                .setMethodDescriptor(updateNetworkPolicyMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "network_policy.name",
                          String.valueOf(request.getNetworkPolicy().getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<DeleteNetworkPolicyRequest, Operation>
        deleteNetworkPolicyTransportSettings =
            HttpJsonCallSettings.<DeleteNetworkPolicyRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteNetworkPolicyMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<
            ListManagementDnsZoneBindingsRequest, ListManagementDnsZoneBindingsResponse>
        listManagementDnsZoneBindingsTransportSettings =
            HttpJsonCallSettings
                .<ListManagementDnsZoneBindingsRequest, ListManagementDnsZoneBindingsResponse>
                    newBuilder()
                .setMethodDescriptor(listManagementDnsZoneBindingsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetManagementDnsZoneBindingRequest, ManagementDnsZoneBinding>
        getManagementDnsZoneBindingTransportSettings =
            HttpJsonCallSettings
                .<GetManagementDnsZoneBindingRequest, ManagementDnsZoneBinding>newBuilder()
                .setMethodDescriptor(getManagementDnsZoneBindingMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<CreateManagementDnsZoneBindingRequest, Operation>
        createManagementDnsZoneBindingTransportSettings =
            HttpJsonCallSettings.<CreateManagementDnsZoneBindingRequest, Operation>newBuilder()
                .setMethodDescriptor(createManagementDnsZoneBindingMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<UpdateManagementDnsZoneBindingRequest, Operation>
        updateManagementDnsZoneBindingTransportSettings =
            HttpJsonCallSettings.<UpdateManagementDnsZoneBindingRequest, Operation>newBuilder()
                .setMethodDescriptor(updateManagementDnsZoneBindingMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "management_dns_zone_binding.name",
                          String.valueOf(request.getManagementDnsZoneBinding().getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<DeleteManagementDnsZoneBindingRequest, Operation>
        deleteManagementDnsZoneBindingTransportSettings =
            HttpJsonCallSettings.<DeleteManagementDnsZoneBindingRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteManagementDnsZoneBindingMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<RepairManagementDnsZoneBindingRequest, Operation>
        repairManagementDnsZoneBindingTransportSettings =
            HttpJsonCallSettings.<RepairManagementDnsZoneBindingRequest, Operation>newBuilder()
                .setMethodDescriptor(repairManagementDnsZoneBindingMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<CreateVmwareEngineNetworkRequest, Operation>
        createVmwareEngineNetworkTransportSettings =
            HttpJsonCallSettings.<CreateVmwareEngineNetworkRequest, Operation>newBuilder()
                .setMethodDescriptor(createVmwareEngineNetworkMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<UpdateVmwareEngineNetworkRequest, Operation>
        updateVmwareEngineNetworkTransportSettings =
            HttpJsonCallSettings.<UpdateVmwareEngineNetworkRequest, Operation>newBuilder()
                .setMethodDescriptor(updateVmwareEngineNetworkMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "vmware_engine_network.name",
                          String.valueOf(request.getVmwareEngineNetwork().getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<DeleteVmwareEngineNetworkRequest, Operation>
        deleteVmwareEngineNetworkTransportSettings =
            HttpJsonCallSettings.<DeleteVmwareEngineNetworkRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteVmwareEngineNetworkMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetVmwareEngineNetworkRequest, VmwareEngineNetwork>
        getVmwareEngineNetworkTransportSettings =
            HttpJsonCallSettings.<GetVmwareEngineNetworkRequest, VmwareEngineNetwork>newBuilder()
                .setMethodDescriptor(getVmwareEngineNetworkMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ListVmwareEngineNetworksRequest, ListVmwareEngineNetworksResponse>
        listVmwareEngineNetworksTransportSettings =
            HttpJsonCallSettings
                .<ListVmwareEngineNetworksRequest, ListVmwareEngineNetworksResponse>newBuilder()
                .setMethodDescriptor(listVmwareEngineNetworksMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<CreatePrivateConnectionRequest, Operation>
        createPrivateConnectionTransportSettings =
            HttpJsonCallSettings.<CreatePrivateConnectionRequest, Operation>newBuilder()
                .setMethodDescriptor(createPrivateConnectionMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetPrivateConnectionRequest, PrivateConnection>
        getPrivateConnectionTransportSettings =
            HttpJsonCallSettings.<GetPrivateConnectionRequest, PrivateConnection>newBuilder()
                .setMethodDescriptor(getPrivateConnectionMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ListPrivateConnectionsRequest, ListPrivateConnectionsResponse>
        listPrivateConnectionsTransportSettings =
            HttpJsonCallSettings
                .<ListPrivateConnectionsRequest, ListPrivateConnectionsResponse>newBuilder()
                .setMethodDescriptor(listPrivateConnectionsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<UpdatePrivateConnectionRequest, Operation>
        updatePrivateConnectionTransportSettings =
            HttpJsonCallSettings.<UpdatePrivateConnectionRequest, Operation>newBuilder()
                .setMethodDescriptor(updatePrivateConnectionMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "private_connection.name",
                          String.valueOf(request.getPrivateConnection().getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<DeletePrivateConnectionRequest, Operation>
        deletePrivateConnectionTransportSettings =
            HttpJsonCallSettings.<DeletePrivateConnectionRequest, Operation>newBuilder()
                .setMethodDescriptor(deletePrivateConnectionMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<
            ListPrivateConnectionPeeringRoutesRequest, ListPrivateConnectionPeeringRoutesResponse>
        listPrivateConnectionPeeringRoutesTransportSettings =
            HttpJsonCallSettings
                .<ListPrivateConnectionPeeringRoutesRequest,
                    ListPrivateConnectionPeeringRoutesResponse>
                    newBuilder()
                .setMethodDescriptor(listPrivateConnectionPeeringRoutesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GrantDnsBindPermissionRequest, Operation>
        grantDnsBindPermissionTransportSettings =
            HttpJsonCallSettings.<GrantDnsBindPermissionRequest, Operation>newBuilder()
                .setMethodDescriptor(grantDnsBindPermissionMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetDnsBindPermissionRequest, DnsBindPermission>
        getDnsBindPermissionTransportSettings =
            HttpJsonCallSettings.<GetDnsBindPermissionRequest, DnsBindPermission>newBuilder()
                .setMethodDescriptor(getDnsBindPermissionMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<RevokeDnsBindPermissionRequest, Operation>
        revokeDnsBindPermissionTransportSettings =
            HttpJsonCallSettings.<RevokeDnsBindPermissionRequest, Operation>newBuilder()
                .setMethodDescriptor(revokeDnsBindPermissionMethodDescriptor)
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
    this.listNodesCallable =
        callableFactory.createUnaryCallable(
            listNodesTransportSettings, settings.listNodesSettings(), clientContext);
    this.listNodesPagedCallable =
        callableFactory.createPagedCallable(
            listNodesTransportSettings, settings.listNodesSettings(), clientContext);
    this.getNodeCallable =
        callableFactory.createUnaryCallable(
            getNodeTransportSettings, settings.getNodeSettings(), clientContext);
    this.listExternalAddressesCallable =
        callableFactory.createUnaryCallable(
            listExternalAddressesTransportSettings,
            settings.listExternalAddressesSettings(),
            clientContext);
    this.listExternalAddressesPagedCallable =
        callableFactory.createPagedCallable(
            listExternalAddressesTransportSettings,
            settings.listExternalAddressesSettings(),
            clientContext);
    this.fetchNetworkPolicyExternalAddressesCallable =
        callableFactory.createUnaryCallable(
            fetchNetworkPolicyExternalAddressesTransportSettings,
            settings.fetchNetworkPolicyExternalAddressesSettings(),
            clientContext);
    this.fetchNetworkPolicyExternalAddressesPagedCallable =
        callableFactory.createPagedCallable(
            fetchNetworkPolicyExternalAddressesTransportSettings,
            settings.fetchNetworkPolicyExternalAddressesSettings(),
            clientContext);
    this.getExternalAddressCallable =
        callableFactory.createUnaryCallable(
            getExternalAddressTransportSettings,
            settings.getExternalAddressSettings(),
            clientContext);
    this.createExternalAddressCallable =
        callableFactory.createUnaryCallable(
            createExternalAddressTransportSettings,
            settings.createExternalAddressSettings(),
            clientContext);
    this.createExternalAddressOperationCallable =
        callableFactory.createOperationCallable(
            createExternalAddressTransportSettings,
            settings.createExternalAddressOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.updateExternalAddressCallable =
        callableFactory.createUnaryCallable(
            updateExternalAddressTransportSettings,
            settings.updateExternalAddressSettings(),
            clientContext);
    this.updateExternalAddressOperationCallable =
        callableFactory.createOperationCallable(
            updateExternalAddressTransportSettings,
            settings.updateExternalAddressOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.deleteExternalAddressCallable =
        callableFactory.createUnaryCallable(
            deleteExternalAddressTransportSettings,
            settings.deleteExternalAddressSettings(),
            clientContext);
    this.deleteExternalAddressOperationCallable =
        callableFactory.createOperationCallable(
            deleteExternalAddressTransportSettings,
            settings.deleteExternalAddressOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.listSubnetsCallable =
        callableFactory.createUnaryCallable(
            listSubnetsTransportSettings, settings.listSubnetsSettings(), clientContext);
    this.listSubnetsPagedCallable =
        callableFactory.createPagedCallable(
            listSubnetsTransportSettings, settings.listSubnetsSettings(), clientContext);
    this.getSubnetCallable =
        callableFactory.createUnaryCallable(
            getSubnetTransportSettings, settings.getSubnetSettings(), clientContext);
    this.updateSubnetCallable =
        callableFactory.createUnaryCallable(
            updateSubnetTransportSettings, settings.updateSubnetSettings(), clientContext);
    this.updateSubnetOperationCallable =
        callableFactory.createOperationCallable(
            updateSubnetTransportSettings,
            settings.updateSubnetOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.listExternalAccessRulesCallable =
        callableFactory.createUnaryCallable(
            listExternalAccessRulesTransportSettings,
            settings.listExternalAccessRulesSettings(),
            clientContext);
    this.listExternalAccessRulesPagedCallable =
        callableFactory.createPagedCallable(
            listExternalAccessRulesTransportSettings,
            settings.listExternalAccessRulesSettings(),
            clientContext);
    this.getExternalAccessRuleCallable =
        callableFactory.createUnaryCallable(
            getExternalAccessRuleTransportSettings,
            settings.getExternalAccessRuleSettings(),
            clientContext);
    this.createExternalAccessRuleCallable =
        callableFactory.createUnaryCallable(
            createExternalAccessRuleTransportSettings,
            settings.createExternalAccessRuleSettings(),
            clientContext);
    this.createExternalAccessRuleOperationCallable =
        callableFactory.createOperationCallable(
            createExternalAccessRuleTransportSettings,
            settings.createExternalAccessRuleOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.updateExternalAccessRuleCallable =
        callableFactory.createUnaryCallable(
            updateExternalAccessRuleTransportSettings,
            settings.updateExternalAccessRuleSettings(),
            clientContext);
    this.updateExternalAccessRuleOperationCallable =
        callableFactory.createOperationCallable(
            updateExternalAccessRuleTransportSettings,
            settings.updateExternalAccessRuleOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.deleteExternalAccessRuleCallable =
        callableFactory.createUnaryCallable(
            deleteExternalAccessRuleTransportSettings,
            settings.deleteExternalAccessRuleSettings(),
            clientContext);
    this.deleteExternalAccessRuleOperationCallable =
        callableFactory.createOperationCallable(
            deleteExternalAccessRuleTransportSettings,
            settings.deleteExternalAccessRuleOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.listLoggingServersCallable =
        callableFactory.createUnaryCallable(
            listLoggingServersTransportSettings,
            settings.listLoggingServersSettings(),
            clientContext);
    this.listLoggingServersPagedCallable =
        callableFactory.createPagedCallable(
            listLoggingServersTransportSettings,
            settings.listLoggingServersSettings(),
            clientContext);
    this.getLoggingServerCallable =
        callableFactory.createUnaryCallable(
            getLoggingServerTransportSettings, settings.getLoggingServerSettings(), clientContext);
    this.createLoggingServerCallable =
        callableFactory.createUnaryCallable(
            createLoggingServerTransportSettings,
            settings.createLoggingServerSettings(),
            clientContext);
    this.createLoggingServerOperationCallable =
        callableFactory.createOperationCallable(
            createLoggingServerTransportSettings,
            settings.createLoggingServerOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.updateLoggingServerCallable =
        callableFactory.createUnaryCallable(
            updateLoggingServerTransportSettings,
            settings.updateLoggingServerSettings(),
            clientContext);
    this.updateLoggingServerOperationCallable =
        callableFactory.createOperationCallable(
            updateLoggingServerTransportSettings,
            settings.updateLoggingServerOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.deleteLoggingServerCallable =
        callableFactory.createUnaryCallable(
            deleteLoggingServerTransportSettings,
            settings.deleteLoggingServerSettings(),
            clientContext);
    this.deleteLoggingServerOperationCallable =
        callableFactory.createOperationCallable(
            deleteLoggingServerTransportSettings,
            settings.deleteLoggingServerOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
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
    this.getDnsForwardingCallable =
        callableFactory.createUnaryCallable(
            getDnsForwardingTransportSettings, settings.getDnsForwardingSettings(), clientContext);
    this.updateDnsForwardingCallable =
        callableFactory.createUnaryCallable(
            updateDnsForwardingTransportSettings,
            settings.updateDnsForwardingSettings(),
            clientContext);
    this.updateDnsForwardingOperationCallable =
        callableFactory.createOperationCallable(
            updateDnsForwardingTransportSettings,
            settings.updateDnsForwardingOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.getNetworkPeeringCallable =
        callableFactory.createUnaryCallable(
            getNetworkPeeringTransportSettings,
            settings.getNetworkPeeringSettings(),
            clientContext);
    this.listNetworkPeeringsCallable =
        callableFactory.createUnaryCallable(
            listNetworkPeeringsTransportSettings,
            settings.listNetworkPeeringsSettings(),
            clientContext);
    this.listNetworkPeeringsPagedCallable =
        callableFactory.createPagedCallable(
            listNetworkPeeringsTransportSettings,
            settings.listNetworkPeeringsSettings(),
            clientContext);
    this.createNetworkPeeringCallable =
        callableFactory.createUnaryCallable(
            createNetworkPeeringTransportSettings,
            settings.createNetworkPeeringSettings(),
            clientContext);
    this.createNetworkPeeringOperationCallable =
        callableFactory.createOperationCallable(
            createNetworkPeeringTransportSettings,
            settings.createNetworkPeeringOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.deleteNetworkPeeringCallable =
        callableFactory.createUnaryCallable(
            deleteNetworkPeeringTransportSettings,
            settings.deleteNetworkPeeringSettings(),
            clientContext);
    this.deleteNetworkPeeringOperationCallable =
        callableFactory.createOperationCallable(
            deleteNetworkPeeringTransportSettings,
            settings.deleteNetworkPeeringOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.updateNetworkPeeringCallable =
        callableFactory.createUnaryCallable(
            updateNetworkPeeringTransportSettings,
            settings.updateNetworkPeeringSettings(),
            clientContext);
    this.updateNetworkPeeringOperationCallable =
        callableFactory.createOperationCallable(
            updateNetworkPeeringTransportSettings,
            settings.updateNetworkPeeringOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.listPeeringRoutesCallable =
        callableFactory.createUnaryCallable(
            listPeeringRoutesTransportSettings,
            settings.listPeeringRoutesSettings(),
            clientContext);
    this.listPeeringRoutesPagedCallable =
        callableFactory.createPagedCallable(
            listPeeringRoutesTransportSettings,
            settings.listPeeringRoutesSettings(),
            clientContext);
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
    this.listManagementDnsZoneBindingsCallable =
        callableFactory.createUnaryCallable(
            listManagementDnsZoneBindingsTransportSettings,
            settings.listManagementDnsZoneBindingsSettings(),
            clientContext);
    this.listManagementDnsZoneBindingsPagedCallable =
        callableFactory.createPagedCallable(
            listManagementDnsZoneBindingsTransportSettings,
            settings.listManagementDnsZoneBindingsSettings(),
            clientContext);
    this.getManagementDnsZoneBindingCallable =
        callableFactory.createUnaryCallable(
            getManagementDnsZoneBindingTransportSettings,
            settings.getManagementDnsZoneBindingSettings(),
            clientContext);
    this.createManagementDnsZoneBindingCallable =
        callableFactory.createUnaryCallable(
            createManagementDnsZoneBindingTransportSettings,
            settings.createManagementDnsZoneBindingSettings(),
            clientContext);
    this.createManagementDnsZoneBindingOperationCallable =
        callableFactory.createOperationCallable(
            createManagementDnsZoneBindingTransportSettings,
            settings.createManagementDnsZoneBindingOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.updateManagementDnsZoneBindingCallable =
        callableFactory.createUnaryCallable(
            updateManagementDnsZoneBindingTransportSettings,
            settings.updateManagementDnsZoneBindingSettings(),
            clientContext);
    this.updateManagementDnsZoneBindingOperationCallable =
        callableFactory.createOperationCallable(
            updateManagementDnsZoneBindingTransportSettings,
            settings.updateManagementDnsZoneBindingOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.deleteManagementDnsZoneBindingCallable =
        callableFactory.createUnaryCallable(
            deleteManagementDnsZoneBindingTransportSettings,
            settings.deleteManagementDnsZoneBindingSettings(),
            clientContext);
    this.deleteManagementDnsZoneBindingOperationCallable =
        callableFactory.createOperationCallable(
            deleteManagementDnsZoneBindingTransportSettings,
            settings.deleteManagementDnsZoneBindingOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.repairManagementDnsZoneBindingCallable =
        callableFactory.createUnaryCallable(
            repairManagementDnsZoneBindingTransportSettings,
            settings.repairManagementDnsZoneBindingSettings(),
            clientContext);
    this.repairManagementDnsZoneBindingOperationCallable =
        callableFactory.createOperationCallable(
            repairManagementDnsZoneBindingTransportSettings,
            settings.repairManagementDnsZoneBindingOperationSettings(),
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
    this.createPrivateConnectionCallable =
        callableFactory.createUnaryCallable(
            createPrivateConnectionTransportSettings,
            settings.createPrivateConnectionSettings(),
            clientContext);
    this.createPrivateConnectionOperationCallable =
        callableFactory.createOperationCallable(
            createPrivateConnectionTransportSettings,
            settings.createPrivateConnectionOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.getPrivateConnectionCallable =
        callableFactory.createUnaryCallable(
            getPrivateConnectionTransportSettings,
            settings.getPrivateConnectionSettings(),
            clientContext);
    this.listPrivateConnectionsCallable =
        callableFactory.createUnaryCallable(
            listPrivateConnectionsTransportSettings,
            settings.listPrivateConnectionsSettings(),
            clientContext);
    this.listPrivateConnectionsPagedCallable =
        callableFactory.createPagedCallable(
            listPrivateConnectionsTransportSettings,
            settings.listPrivateConnectionsSettings(),
            clientContext);
    this.updatePrivateConnectionCallable =
        callableFactory.createUnaryCallable(
            updatePrivateConnectionTransportSettings,
            settings.updatePrivateConnectionSettings(),
            clientContext);
    this.updatePrivateConnectionOperationCallable =
        callableFactory.createOperationCallable(
            updatePrivateConnectionTransportSettings,
            settings.updatePrivateConnectionOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.deletePrivateConnectionCallable =
        callableFactory.createUnaryCallable(
            deletePrivateConnectionTransportSettings,
            settings.deletePrivateConnectionSettings(),
            clientContext);
    this.deletePrivateConnectionOperationCallable =
        callableFactory.createOperationCallable(
            deletePrivateConnectionTransportSettings,
            settings.deletePrivateConnectionOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.listPrivateConnectionPeeringRoutesCallable =
        callableFactory.createUnaryCallable(
            listPrivateConnectionPeeringRoutesTransportSettings,
            settings.listPrivateConnectionPeeringRoutesSettings(),
            clientContext);
    this.listPrivateConnectionPeeringRoutesPagedCallable =
        callableFactory.createPagedCallable(
            listPrivateConnectionPeeringRoutesTransportSettings,
            settings.listPrivateConnectionPeeringRoutesSettings(),
            clientContext);
    this.grantDnsBindPermissionCallable =
        callableFactory.createUnaryCallable(
            grantDnsBindPermissionTransportSettings,
            settings.grantDnsBindPermissionSettings(),
            clientContext);
    this.grantDnsBindPermissionOperationCallable =
        callableFactory.createOperationCallable(
            grantDnsBindPermissionTransportSettings,
            settings.grantDnsBindPermissionOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.getDnsBindPermissionCallable =
        callableFactory.createUnaryCallable(
            getDnsBindPermissionTransportSettings,
            settings.getDnsBindPermissionSettings(),
            clientContext);
    this.revokeDnsBindPermissionCallable =
        callableFactory.createUnaryCallable(
            revokeDnsBindPermissionTransportSettings,
            settings.revokeDnsBindPermissionSettings(),
            clientContext);
    this.revokeDnsBindPermissionOperationCallable =
        callableFactory.createOperationCallable(
            revokeDnsBindPermissionTransportSettings,
            settings.revokeDnsBindPermissionOperationSettings(),
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
    methodDescriptors.add(listNodesMethodDescriptor);
    methodDescriptors.add(getNodeMethodDescriptor);
    methodDescriptors.add(listExternalAddressesMethodDescriptor);
    methodDescriptors.add(fetchNetworkPolicyExternalAddressesMethodDescriptor);
    methodDescriptors.add(getExternalAddressMethodDescriptor);
    methodDescriptors.add(createExternalAddressMethodDescriptor);
    methodDescriptors.add(updateExternalAddressMethodDescriptor);
    methodDescriptors.add(deleteExternalAddressMethodDescriptor);
    methodDescriptors.add(listSubnetsMethodDescriptor);
    methodDescriptors.add(getSubnetMethodDescriptor);
    methodDescriptors.add(updateSubnetMethodDescriptor);
    methodDescriptors.add(listExternalAccessRulesMethodDescriptor);
    methodDescriptors.add(getExternalAccessRuleMethodDescriptor);
    methodDescriptors.add(createExternalAccessRuleMethodDescriptor);
    methodDescriptors.add(updateExternalAccessRuleMethodDescriptor);
    methodDescriptors.add(deleteExternalAccessRuleMethodDescriptor);
    methodDescriptors.add(listLoggingServersMethodDescriptor);
    methodDescriptors.add(getLoggingServerMethodDescriptor);
    methodDescriptors.add(createLoggingServerMethodDescriptor);
    methodDescriptors.add(updateLoggingServerMethodDescriptor);
    methodDescriptors.add(deleteLoggingServerMethodDescriptor);
    methodDescriptors.add(listNodeTypesMethodDescriptor);
    methodDescriptors.add(getNodeTypeMethodDescriptor);
    methodDescriptors.add(showNsxCredentialsMethodDescriptor);
    methodDescriptors.add(showVcenterCredentialsMethodDescriptor);
    methodDescriptors.add(resetNsxCredentialsMethodDescriptor);
    methodDescriptors.add(resetVcenterCredentialsMethodDescriptor);
    methodDescriptors.add(getDnsForwardingMethodDescriptor);
    methodDescriptors.add(updateDnsForwardingMethodDescriptor);
    methodDescriptors.add(getNetworkPeeringMethodDescriptor);
    methodDescriptors.add(listNetworkPeeringsMethodDescriptor);
    methodDescriptors.add(createNetworkPeeringMethodDescriptor);
    methodDescriptors.add(deleteNetworkPeeringMethodDescriptor);
    methodDescriptors.add(updateNetworkPeeringMethodDescriptor);
    methodDescriptors.add(listPeeringRoutesMethodDescriptor);
    methodDescriptors.add(createHcxActivationKeyMethodDescriptor);
    methodDescriptors.add(listHcxActivationKeysMethodDescriptor);
    methodDescriptors.add(getHcxActivationKeyMethodDescriptor);
    methodDescriptors.add(getNetworkPolicyMethodDescriptor);
    methodDescriptors.add(listNetworkPoliciesMethodDescriptor);
    methodDescriptors.add(createNetworkPolicyMethodDescriptor);
    methodDescriptors.add(updateNetworkPolicyMethodDescriptor);
    methodDescriptors.add(deleteNetworkPolicyMethodDescriptor);
    methodDescriptors.add(listManagementDnsZoneBindingsMethodDescriptor);
    methodDescriptors.add(getManagementDnsZoneBindingMethodDescriptor);
    methodDescriptors.add(createManagementDnsZoneBindingMethodDescriptor);
    methodDescriptors.add(updateManagementDnsZoneBindingMethodDescriptor);
    methodDescriptors.add(deleteManagementDnsZoneBindingMethodDescriptor);
    methodDescriptors.add(repairManagementDnsZoneBindingMethodDescriptor);
    methodDescriptors.add(createVmwareEngineNetworkMethodDescriptor);
    methodDescriptors.add(updateVmwareEngineNetworkMethodDescriptor);
    methodDescriptors.add(deleteVmwareEngineNetworkMethodDescriptor);
    methodDescriptors.add(getVmwareEngineNetworkMethodDescriptor);
    methodDescriptors.add(listVmwareEngineNetworksMethodDescriptor);
    methodDescriptors.add(createPrivateConnectionMethodDescriptor);
    methodDescriptors.add(getPrivateConnectionMethodDescriptor);
    methodDescriptors.add(listPrivateConnectionsMethodDescriptor);
    methodDescriptors.add(updatePrivateConnectionMethodDescriptor);
    methodDescriptors.add(deletePrivateConnectionMethodDescriptor);
    methodDescriptors.add(listPrivateConnectionPeeringRoutesMethodDescriptor);
    methodDescriptors.add(grantDnsBindPermissionMethodDescriptor);
    methodDescriptors.add(getDnsBindPermissionMethodDescriptor);
    methodDescriptors.add(revokeDnsBindPermissionMethodDescriptor);
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
  public UnaryCallable<ListNodesRequest, ListNodesResponse> listNodesCallable() {
    return listNodesCallable;
  }

  @Override
  public UnaryCallable<ListNodesRequest, ListNodesPagedResponse> listNodesPagedCallable() {
    return listNodesPagedCallable;
  }

  @Override
  public UnaryCallable<GetNodeRequest, Node> getNodeCallable() {
    return getNodeCallable;
  }

  @Override
  public UnaryCallable<ListExternalAddressesRequest, ListExternalAddressesResponse>
      listExternalAddressesCallable() {
    return listExternalAddressesCallable;
  }

  @Override
  public UnaryCallable<ListExternalAddressesRequest, ListExternalAddressesPagedResponse>
      listExternalAddressesPagedCallable() {
    return listExternalAddressesPagedCallable;
  }

  @Override
  public UnaryCallable<
          FetchNetworkPolicyExternalAddressesRequest, FetchNetworkPolicyExternalAddressesResponse>
      fetchNetworkPolicyExternalAddressesCallable() {
    return fetchNetworkPolicyExternalAddressesCallable;
  }

  @Override
  public UnaryCallable<
          FetchNetworkPolicyExternalAddressesRequest,
          FetchNetworkPolicyExternalAddressesPagedResponse>
      fetchNetworkPolicyExternalAddressesPagedCallable() {
    return fetchNetworkPolicyExternalAddressesPagedCallable;
  }

  @Override
  public UnaryCallable<GetExternalAddressRequest, ExternalAddress> getExternalAddressCallable() {
    return getExternalAddressCallable;
  }

  @Override
  public UnaryCallable<CreateExternalAddressRequest, Operation> createExternalAddressCallable() {
    return createExternalAddressCallable;
  }

  @Override
  public OperationCallable<CreateExternalAddressRequest, ExternalAddress, OperationMetadata>
      createExternalAddressOperationCallable() {
    return createExternalAddressOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateExternalAddressRequest, Operation> updateExternalAddressCallable() {
    return updateExternalAddressCallable;
  }

  @Override
  public OperationCallable<UpdateExternalAddressRequest, ExternalAddress, OperationMetadata>
      updateExternalAddressOperationCallable() {
    return updateExternalAddressOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteExternalAddressRequest, Operation> deleteExternalAddressCallable() {
    return deleteExternalAddressCallable;
  }

  @Override
  public OperationCallable<DeleteExternalAddressRequest, Empty, OperationMetadata>
      deleteExternalAddressOperationCallable() {
    return deleteExternalAddressOperationCallable;
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
  public UnaryCallable<GetSubnetRequest, Subnet> getSubnetCallable() {
    return getSubnetCallable;
  }

  @Override
  public UnaryCallable<UpdateSubnetRequest, Operation> updateSubnetCallable() {
    return updateSubnetCallable;
  }

  @Override
  public OperationCallable<UpdateSubnetRequest, Subnet, OperationMetadata>
      updateSubnetOperationCallable() {
    return updateSubnetOperationCallable;
  }

  @Override
  public UnaryCallable<ListExternalAccessRulesRequest, ListExternalAccessRulesResponse>
      listExternalAccessRulesCallable() {
    return listExternalAccessRulesCallable;
  }

  @Override
  public UnaryCallable<ListExternalAccessRulesRequest, ListExternalAccessRulesPagedResponse>
      listExternalAccessRulesPagedCallable() {
    return listExternalAccessRulesPagedCallable;
  }

  @Override
  public UnaryCallable<GetExternalAccessRuleRequest, ExternalAccessRule>
      getExternalAccessRuleCallable() {
    return getExternalAccessRuleCallable;
  }

  @Override
  public UnaryCallable<CreateExternalAccessRuleRequest, Operation>
      createExternalAccessRuleCallable() {
    return createExternalAccessRuleCallable;
  }

  @Override
  public OperationCallable<CreateExternalAccessRuleRequest, ExternalAccessRule, OperationMetadata>
      createExternalAccessRuleOperationCallable() {
    return createExternalAccessRuleOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateExternalAccessRuleRequest, Operation>
      updateExternalAccessRuleCallable() {
    return updateExternalAccessRuleCallable;
  }

  @Override
  public OperationCallable<UpdateExternalAccessRuleRequest, ExternalAccessRule, OperationMetadata>
      updateExternalAccessRuleOperationCallable() {
    return updateExternalAccessRuleOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteExternalAccessRuleRequest, Operation>
      deleteExternalAccessRuleCallable() {
    return deleteExternalAccessRuleCallable;
  }

  @Override
  public OperationCallable<DeleteExternalAccessRuleRequest, Empty, OperationMetadata>
      deleteExternalAccessRuleOperationCallable() {
    return deleteExternalAccessRuleOperationCallable;
  }

  @Override
  public UnaryCallable<ListLoggingServersRequest, ListLoggingServersResponse>
      listLoggingServersCallable() {
    return listLoggingServersCallable;
  }

  @Override
  public UnaryCallable<ListLoggingServersRequest, ListLoggingServersPagedResponse>
      listLoggingServersPagedCallable() {
    return listLoggingServersPagedCallable;
  }

  @Override
  public UnaryCallable<GetLoggingServerRequest, LoggingServer> getLoggingServerCallable() {
    return getLoggingServerCallable;
  }

  @Override
  public UnaryCallable<CreateLoggingServerRequest, Operation> createLoggingServerCallable() {
    return createLoggingServerCallable;
  }

  @Override
  public OperationCallable<CreateLoggingServerRequest, LoggingServer, OperationMetadata>
      createLoggingServerOperationCallable() {
    return createLoggingServerOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateLoggingServerRequest, Operation> updateLoggingServerCallable() {
    return updateLoggingServerCallable;
  }

  @Override
  public OperationCallable<UpdateLoggingServerRequest, LoggingServer, OperationMetadata>
      updateLoggingServerOperationCallable() {
    return updateLoggingServerOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteLoggingServerRequest, Operation> deleteLoggingServerCallable() {
    return deleteLoggingServerCallable;
  }

  @Override
  public OperationCallable<DeleteLoggingServerRequest, Empty, OperationMetadata>
      deleteLoggingServerOperationCallable() {
    return deleteLoggingServerOperationCallable;
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
  public UnaryCallable<GetDnsForwardingRequest, DnsForwarding> getDnsForwardingCallable() {
    return getDnsForwardingCallable;
  }

  @Override
  public UnaryCallable<UpdateDnsForwardingRequest, Operation> updateDnsForwardingCallable() {
    return updateDnsForwardingCallable;
  }

  @Override
  public OperationCallable<UpdateDnsForwardingRequest, DnsForwarding, OperationMetadata>
      updateDnsForwardingOperationCallable() {
    return updateDnsForwardingOperationCallable;
  }

  @Override
  public UnaryCallable<GetNetworkPeeringRequest, NetworkPeering> getNetworkPeeringCallable() {
    return getNetworkPeeringCallable;
  }

  @Override
  public UnaryCallable<ListNetworkPeeringsRequest, ListNetworkPeeringsResponse>
      listNetworkPeeringsCallable() {
    return listNetworkPeeringsCallable;
  }

  @Override
  public UnaryCallable<ListNetworkPeeringsRequest, ListNetworkPeeringsPagedResponse>
      listNetworkPeeringsPagedCallable() {
    return listNetworkPeeringsPagedCallable;
  }

  @Override
  public UnaryCallable<CreateNetworkPeeringRequest, Operation> createNetworkPeeringCallable() {
    return createNetworkPeeringCallable;
  }

  @Override
  public OperationCallable<CreateNetworkPeeringRequest, NetworkPeering, OperationMetadata>
      createNetworkPeeringOperationCallable() {
    return createNetworkPeeringOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteNetworkPeeringRequest, Operation> deleteNetworkPeeringCallable() {
    return deleteNetworkPeeringCallable;
  }

  @Override
  public OperationCallable<DeleteNetworkPeeringRequest, Empty, OperationMetadata>
      deleteNetworkPeeringOperationCallable() {
    return deleteNetworkPeeringOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateNetworkPeeringRequest, Operation> updateNetworkPeeringCallable() {
    return updateNetworkPeeringCallable;
  }

  @Override
  public OperationCallable<UpdateNetworkPeeringRequest, NetworkPeering, OperationMetadata>
      updateNetworkPeeringOperationCallable() {
    return updateNetworkPeeringOperationCallable;
  }

  @Override
  public UnaryCallable<ListPeeringRoutesRequest, ListPeeringRoutesResponse>
      listPeeringRoutesCallable() {
    return listPeeringRoutesCallable;
  }

  @Override
  public UnaryCallable<ListPeeringRoutesRequest, ListPeeringRoutesPagedResponse>
      listPeeringRoutesPagedCallable() {
    return listPeeringRoutesPagedCallable;
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
  public UnaryCallable<ListManagementDnsZoneBindingsRequest, ListManagementDnsZoneBindingsResponse>
      listManagementDnsZoneBindingsCallable() {
    return listManagementDnsZoneBindingsCallable;
  }

  @Override
  public UnaryCallable<
          ListManagementDnsZoneBindingsRequest, ListManagementDnsZoneBindingsPagedResponse>
      listManagementDnsZoneBindingsPagedCallable() {
    return listManagementDnsZoneBindingsPagedCallable;
  }

  @Override
  public UnaryCallable<GetManagementDnsZoneBindingRequest, ManagementDnsZoneBinding>
      getManagementDnsZoneBindingCallable() {
    return getManagementDnsZoneBindingCallable;
  }

  @Override
  public UnaryCallable<CreateManagementDnsZoneBindingRequest, Operation>
      createManagementDnsZoneBindingCallable() {
    return createManagementDnsZoneBindingCallable;
  }

  @Override
  public OperationCallable<
          CreateManagementDnsZoneBindingRequest, ManagementDnsZoneBinding, OperationMetadata>
      createManagementDnsZoneBindingOperationCallable() {
    return createManagementDnsZoneBindingOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateManagementDnsZoneBindingRequest, Operation>
      updateManagementDnsZoneBindingCallable() {
    return updateManagementDnsZoneBindingCallable;
  }

  @Override
  public OperationCallable<
          UpdateManagementDnsZoneBindingRequest, ManagementDnsZoneBinding, OperationMetadata>
      updateManagementDnsZoneBindingOperationCallable() {
    return updateManagementDnsZoneBindingOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteManagementDnsZoneBindingRequest, Operation>
      deleteManagementDnsZoneBindingCallable() {
    return deleteManagementDnsZoneBindingCallable;
  }

  @Override
  public OperationCallable<DeleteManagementDnsZoneBindingRequest, Empty, OperationMetadata>
      deleteManagementDnsZoneBindingOperationCallable() {
    return deleteManagementDnsZoneBindingOperationCallable;
  }

  @Override
  public UnaryCallable<RepairManagementDnsZoneBindingRequest, Operation>
      repairManagementDnsZoneBindingCallable() {
    return repairManagementDnsZoneBindingCallable;
  }

  @Override
  public OperationCallable<
          RepairManagementDnsZoneBindingRequest, ManagementDnsZoneBinding, OperationMetadata>
      repairManagementDnsZoneBindingOperationCallable() {
    return repairManagementDnsZoneBindingOperationCallable;
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
  public UnaryCallable<CreatePrivateConnectionRequest, Operation>
      createPrivateConnectionCallable() {
    return createPrivateConnectionCallable;
  }

  @Override
  public OperationCallable<CreatePrivateConnectionRequest, PrivateConnection, OperationMetadata>
      createPrivateConnectionOperationCallable() {
    return createPrivateConnectionOperationCallable;
  }

  @Override
  public UnaryCallable<GetPrivateConnectionRequest, PrivateConnection>
      getPrivateConnectionCallable() {
    return getPrivateConnectionCallable;
  }

  @Override
  public UnaryCallable<ListPrivateConnectionsRequest, ListPrivateConnectionsResponse>
      listPrivateConnectionsCallable() {
    return listPrivateConnectionsCallable;
  }

  @Override
  public UnaryCallable<ListPrivateConnectionsRequest, ListPrivateConnectionsPagedResponse>
      listPrivateConnectionsPagedCallable() {
    return listPrivateConnectionsPagedCallable;
  }

  @Override
  public UnaryCallable<UpdatePrivateConnectionRequest, Operation>
      updatePrivateConnectionCallable() {
    return updatePrivateConnectionCallable;
  }

  @Override
  public OperationCallable<UpdatePrivateConnectionRequest, PrivateConnection, OperationMetadata>
      updatePrivateConnectionOperationCallable() {
    return updatePrivateConnectionOperationCallable;
  }

  @Override
  public UnaryCallable<DeletePrivateConnectionRequest, Operation>
      deletePrivateConnectionCallable() {
    return deletePrivateConnectionCallable;
  }

  @Override
  public OperationCallable<DeletePrivateConnectionRequest, Empty, OperationMetadata>
      deletePrivateConnectionOperationCallable() {
    return deletePrivateConnectionOperationCallable;
  }

  @Override
  public UnaryCallable<
          ListPrivateConnectionPeeringRoutesRequest, ListPrivateConnectionPeeringRoutesResponse>
      listPrivateConnectionPeeringRoutesCallable() {
    return listPrivateConnectionPeeringRoutesCallable;
  }

  @Override
  public UnaryCallable<
          ListPrivateConnectionPeeringRoutesRequest,
          ListPrivateConnectionPeeringRoutesPagedResponse>
      listPrivateConnectionPeeringRoutesPagedCallable() {
    return listPrivateConnectionPeeringRoutesPagedCallable;
  }

  @Override
  public UnaryCallable<GrantDnsBindPermissionRequest, Operation> grantDnsBindPermissionCallable() {
    return grantDnsBindPermissionCallable;
  }

  @Override
  public OperationCallable<GrantDnsBindPermissionRequest, DnsBindPermission, OperationMetadata>
      grantDnsBindPermissionOperationCallable() {
    return grantDnsBindPermissionOperationCallable;
  }

  @Override
  public UnaryCallable<GetDnsBindPermissionRequest, DnsBindPermission>
      getDnsBindPermissionCallable() {
    return getDnsBindPermissionCallable;
  }

  @Override
  public UnaryCallable<RevokeDnsBindPermissionRequest, Operation>
      revokeDnsBindPermissionCallable() {
    return revokeDnsBindPermissionCallable;
  }

  @Override
  public OperationCallable<RevokeDnsBindPermissionRequest, DnsBindPermission, OperationMetadata>
      revokeDnsBindPermissionOperationCallable() {
    return revokeDnsBindPermissionOperationCallable;
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
