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

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GaxProperties;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.GrpcTransportChannel;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.grpc.ProtoOperationTransformers;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.HttpJsonTransportChannel;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
import com.google.api.gax.longrunning.OperationSnapshot;
import com.google.api.gax.longrunning.OperationTimedPollAlgorithm;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallSettings;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.PagedListDescriptor;
import com.google.api.gax.rpc.PagedListResponseFactory;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.StubSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
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
import com.google.cloud.vmwareengine.v1.Subnet;
import com.google.cloud.vmwareengine.v1.UndeletePrivateCloudRequest;
import com.google.cloud.vmwareengine.v1.UpdateClusterRequest;
import com.google.cloud.vmwareengine.v1.UpdateNetworkPolicyRequest;
import com.google.cloud.vmwareengine.v1.UpdatePrivateCloudRequest;
import com.google.cloud.vmwareengine.v1.UpdateVmwareEngineNetworkRequest;
import com.google.cloud.vmwareengine.v1.VmwareEngineNetwork;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;
import org.threeten.bp.Duration;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link VmwareEngineStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (vmwareengine.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getPrivateCloud to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * VmwareEngineStubSettings.Builder vmwareEngineSettingsBuilder =
 *     VmwareEngineStubSettings.newBuilder();
 * vmwareEngineSettingsBuilder
 *     .getPrivateCloudSettings()
 *     .setRetrySettings(
 *         vmwareEngineSettingsBuilder.getPrivateCloudSettings().getRetrySettings().toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * VmwareEngineStubSettings vmwareEngineSettings = vmwareEngineSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class VmwareEngineStubSettings extends StubSettings<VmwareEngineStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final PagedCallSettings<
          ListPrivateCloudsRequest, ListPrivateCloudsResponse, ListPrivateCloudsPagedResponse>
      listPrivateCloudsSettings;
  private final UnaryCallSettings<GetPrivateCloudRequest, PrivateCloud> getPrivateCloudSettings;
  private final UnaryCallSettings<CreatePrivateCloudRequest, Operation> createPrivateCloudSettings;
  private final OperationCallSettings<CreatePrivateCloudRequest, PrivateCloud, OperationMetadata>
      createPrivateCloudOperationSettings;
  private final UnaryCallSettings<UpdatePrivateCloudRequest, Operation> updatePrivateCloudSettings;
  private final OperationCallSettings<UpdatePrivateCloudRequest, PrivateCloud, OperationMetadata>
      updatePrivateCloudOperationSettings;
  private final UnaryCallSettings<DeletePrivateCloudRequest, Operation> deletePrivateCloudSettings;
  private final OperationCallSettings<DeletePrivateCloudRequest, PrivateCloud, OperationMetadata>
      deletePrivateCloudOperationSettings;
  private final UnaryCallSettings<UndeletePrivateCloudRequest, Operation>
      undeletePrivateCloudSettings;
  private final OperationCallSettings<UndeletePrivateCloudRequest, PrivateCloud, OperationMetadata>
      undeletePrivateCloudOperationSettings;
  private final PagedCallSettings<
          ListClustersRequest, ListClustersResponse, ListClustersPagedResponse>
      listClustersSettings;
  private final UnaryCallSettings<GetClusterRequest, Cluster> getClusterSettings;
  private final UnaryCallSettings<CreateClusterRequest, Operation> createClusterSettings;
  private final OperationCallSettings<CreateClusterRequest, Cluster, OperationMetadata>
      createClusterOperationSettings;
  private final UnaryCallSettings<UpdateClusterRequest, Operation> updateClusterSettings;
  private final OperationCallSettings<UpdateClusterRequest, Cluster, OperationMetadata>
      updateClusterOperationSettings;
  private final UnaryCallSettings<DeleteClusterRequest, Operation> deleteClusterSettings;
  private final OperationCallSettings<DeleteClusterRequest, Empty, OperationMetadata>
      deleteClusterOperationSettings;
  private final PagedCallSettings<ListSubnetsRequest, ListSubnetsResponse, ListSubnetsPagedResponse>
      listSubnetsSettings;
  private final PagedCallSettings<
          ListNodeTypesRequest, ListNodeTypesResponse, ListNodeTypesPagedResponse>
      listNodeTypesSettings;
  private final UnaryCallSettings<GetNodeTypeRequest, NodeType> getNodeTypeSettings;
  private final UnaryCallSettings<ShowNsxCredentialsRequest, Credentials>
      showNsxCredentialsSettings;
  private final UnaryCallSettings<ShowVcenterCredentialsRequest, Credentials>
      showVcenterCredentialsSettings;
  private final UnaryCallSettings<ResetNsxCredentialsRequest, Operation>
      resetNsxCredentialsSettings;
  private final OperationCallSettings<ResetNsxCredentialsRequest, PrivateCloud, OperationMetadata>
      resetNsxCredentialsOperationSettings;
  private final UnaryCallSettings<ResetVcenterCredentialsRequest, Operation>
      resetVcenterCredentialsSettings;
  private final OperationCallSettings<
          ResetVcenterCredentialsRequest, PrivateCloud, OperationMetadata>
      resetVcenterCredentialsOperationSettings;
  private final UnaryCallSettings<CreateHcxActivationKeyRequest, Operation>
      createHcxActivationKeySettings;
  private final OperationCallSettings<
          CreateHcxActivationKeyRequest, HcxActivationKey, OperationMetadata>
      createHcxActivationKeyOperationSettings;
  private final PagedCallSettings<
          ListHcxActivationKeysRequest,
          ListHcxActivationKeysResponse,
          ListHcxActivationKeysPagedResponse>
      listHcxActivationKeysSettings;
  private final UnaryCallSettings<GetHcxActivationKeyRequest, HcxActivationKey>
      getHcxActivationKeySettings;
  private final UnaryCallSettings<GetNetworkPolicyRequest, NetworkPolicy> getNetworkPolicySettings;
  private final PagedCallSettings<
          ListNetworkPoliciesRequest, ListNetworkPoliciesResponse, ListNetworkPoliciesPagedResponse>
      listNetworkPoliciesSettings;
  private final UnaryCallSettings<CreateNetworkPolicyRequest, Operation>
      createNetworkPolicySettings;
  private final OperationCallSettings<CreateNetworkPolicyRequest, NetworkPolicy, OperationMetadata>
      createNetworkPolicyOperationSettings;
  private final UnaryCallSettings<UpdateNetworkPolicyRequest, Operation>
      updateNetworkPolicySettings;
  private final OperationCallSettings<UpdateNetworkPolicyRequest, NetworkPolicy, OperationMetadata>
      updateNetworkPolicyOperationSettings;
  private final UnaryCallSettings<DeleteNetworkPolicyRequest, Operation>
      deleteNetworkPolicySettings;
  private final OperationCallSettings<DeleteNetworkPolicyRequest, Empty, OperationMetadata>
      deleteNetworkPolicyOperationSettings;
  private final UnaryCallSettings<CreateVmwareEngineNetworkRequest, Operation>
      createVmwareEngineNetworkSettings;
  private final OperationCallSettings<
          CreateVmwareEngineNetworkRequest, VmwareEngineNetwork, OperationMetadata>
      createVmwareEngineNetworkOperationSettings;
  private final UnaryCallSettings<UpdateVmwareEngineNetworkRequest, Operation>
      updateVmwareEngineNetworkSettings;
  private final OperationCallSettings<
          UpdateVmwareEngineNetworkRequest, VmwareEngineNetwork, OperationMetadata>
      updateVmwareEngineNetworkOperationSettings;
  private final UnaryCallSettings<DeleteVmwareEngineNetworkRequest, Operation>
      deleteVmwareEngineNetworkSettings;
  private final OperationCallSettings<DeleteVmwareEngineNetworkRequest, Empty, OperationMetadata>
      deleteVmwareEngineNetworkOperationSettings;
  private final UnaryCallSettings<GetVmwareEngineNetworkRequest, VmwareEngineNetwork>
      getVmwareEngineNetworkSettings;
  private final PagedCallSettings<
          ListVmwareEngineNetworksRequest,
          ListVmwareEngineNetworksResponse,
          ListVmwareEngineNetworksPagedResponse>
      listVmwareEngineNetworksSettings;
  private final PagedCallSettings<
          ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings;
  private final UnaryCallSettings<GetLocationRequest, Location> getLocationSettings;
  private final UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings;
  private final UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings;
  private final UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings;

  private static final PagedListDescriptor<
          ListPrivateCloudsRequest, ListPrivateCloudsResponse, PrivateCloud>
      LIST_PRIVATE_CLOUDS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListPrivateCloudsRequest, ListPrivateCloudsResponse, PrivateCloud>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListPrivateCloudsRequest injectToken(
                ListPrivateCloudsRequest payload, String token) {
              return ListPrivateCloudsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListPrivateCloudsRequest injectPageSize(
                ListPrivateCloudsRequest payload, int pageSize) {
              return ListPrivateCloudsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListPrivateCloudsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListPrivateCloudsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<PrivateCloud> extractResources(ListPrivateCloudsResponse payload) {
              return payload.getPrivateCloudsList() == null
                  ? ImmutableList.<PrivateCloud>of()
                  : payload.getPrivateCloudsList();
            }
          };

  private static final PagedListDescriptor<ListClustersRequest, ListClustersResponse, Cluster>
      LIST_CLUSTERS_PAGE_STR_DESC =
          new PagedListDescriptor<ListClustersRequest, ListClustersResponse, Cluster>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListClustersRequest injectToken(ListClustersRequest payload, String token) {
              return ListClustersRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListClustersRequest injectPageSize(ListClustersRequest payload, int pageSize) {
              return ListClustersRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListClustersRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListClustersResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Cluster> extractResources(ListClustersResponse payload) {
              return payload.getClustersList() == null
                  ? ImmutableList.<Cluster>of()
                  : payload.getClustersList();
            }
          };

  private static final PagedListDescriptor<ListSubnetsRequest, ListSubnetsResponse, Subnet>
      LIST_SUBNETS_PAGE_STR_DESC =
          new PagedListDescriptor<ListSubnetsRequest, ListSubnetsResponse, Subnet>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListSubnetsRequest injectToken(ListSubnetsRequest payload, String token) {
              return ListSubnetsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListSubnetsRequest injectPageSize(ListSubnetsRequest payload, int pageSize) {
              return ListSubnetsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListSubnetsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListSubnetsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Subnet> extractResources(ListSubnetsResponse payload) {
              return payload.getSubnetsList() == null
                  ? ImmutableList.<Subnet>of()
                  : payload.getSubnetsList();
            }
          };

  private static final PagedListDescriptor<ListNodeTypesRequest, ListNodeTypesResponse, NodeType>
      LIST_NODE_TYPES_PAGE_STR_DESC =
          new PagedListDescriptor<ListNodeTypesRequest, ListNodeTypesResponse, NodeType>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListNodeTypesRequest injectToken(ListNodeTypesRequest payload, String token) {
              return ListNodeTypesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListNodeTypesRequest injectPageSize(ListNodeTypesRequest payload, int pageSize) {
              return ListNodeTypesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListNodeTypesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListNodeTypesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<NodeType> extractResources(ListNodeTypesResponse payload) {
              return payload.getNodeTypesList() == null
                  ? ImmutableList.<NodeType>of()
                  : payload.getNodeTypesList();
            }
          };

  private static final PagedListDescriptor<
          ListHcxActivationKeysRequest, ListHcxActivationKeysResponse, HcxActivationKey>
      LIST_HCX_ACTIVATION_KEYS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListHcxActivationKeysRequest, ListHcxActivationKeysResponse, HcxActivationKey>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListHcxActivationKeysRequest injectToken(
                ListHcxActivationKeysRequest payload, String token) {
              return ListHcxActivationKeysRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListHcxActivationKeysRequest injectPageSize(
                ListHcxActivationKeysRequest payload, int pageSize) {
              return ListHcxActivationKeysRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListHcxActivationKeysRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListHcxActivationKeysResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<HcxActivationKey> extractResources(
                ListHcxActivationKeysResponse payload) {
              return payload.getHcxActivationKeysList() == null
                  ? ImmutableList.<HcxActivationKey>of()
                  : payload.getHcxActivationKeysList();
            }
          };

  private static final PagedListDescriptor<
          ListNetworkPoliciesRequest, ListNetworkPoliciesResponse, NetworkPolicy>
      LIST_NETWORK_POLICIES_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListNetworkPoliciesRequest, ListNetworkPoliciesResponse, NetworkPolicy>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListNetworkPoliciesRequest injectToken(
                ListNetworkPoliciesRequest payload, String token) {
              return ListNetworkPoliciesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListNetworkPoliciesRequest injectPageSize(
                ListNetworkPoliciesRequest payload, int pageSize) {
              return ListNetworkPoliciesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListNetworkPoliciesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListNetworkPoliciesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<NetworkPolicy> extractResources(ListNetworkPoliciesResponse payload) {
              return payload.getNetworkPoliciesList() == null
                  ? ImmutableList.<NetworkPolicy>of()
                  : payload.getNetworkPoliciesList();
            }
          };

  private static final PagedListDescriptor<
          ListVmwareEngineNetworksRequest, ListVmwareEngineNetworksResponse, VmwareEngineNetwork>
      LIST_VMWARE_ENGINE_NETWORKS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListVmwareEngineNetworksRequest,
              ListVmwareEngineNetworksResponse,
              VmwareEngineNetwork>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListVmwareEngineNetworksRequest injectToken(
                ListVmwareEngineNetworksRequest payload, String token) {
              return ListVmwareEngineNetworksRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public ListVmwareEngineNetworksRequest injectPageSize(
                ListVmwareEngineNetworksRequest payload, int pageSize) {
              return ListVmwareEngineNetworksRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListVmwareEngineNetworksRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListVmwareEngineNetworksResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<VmwareEngineNetwork> extractResources(
                ListVmwareEngineNetworksResponse payload) {
              return payload.getVmwareEngineNetworksList() == null
                  ? ImmutableList.<VmwareEngineNetwork>of()
                  : payload.getVmwareEngineNetworksList();
            }
          };

  private static final PagedListDescriptor<ListLocationsRequest, ListLocationsResponse, Location>
      LIST_LOCATIONS_PAGE_STR_DESC =
          new PagedListDescriptor<ListLocationsRequest, ListLocationsResponse, Location>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListLocationsRequest injectToken(ListLocationsRequest payload, String token) {
              return ListLocationsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListLocationsRequest injectPageSize(ListLocationsRequest payload, int pageSize) {
              return ListLocationsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListLocationsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListLocationsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Location> extractResources(ListLocationsResponse payload) {
              return payload.getLocationsList() == null
                  ? ImmutableList.<Location>of()
                  : payload.getLocationsList();
            }
          };

  private static final PagedListResponseFactory<
          ListPrivateCloudsRequest, ListPrivateCloudsResponse, ListPrivateCloudsPagedResponse>
      LIST_PRIVATE_CLOUDS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListPrivateCloudsRequest,
              ListPrivateCloudsResponse,
              ListPrivateCloudsPagedResponse>() {
            @Override
            public ApiFuture<ListPrivateCloudsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListPrivateCloudsRequest, ListPrivateCloudsResponse> callable,
                ListPrivateCloudsRequest request,
                ApiCallContext context,
                ApiFuture<ListPrivateCloudsResponse> futureResponse) {
              PageContext<ListPrivateCloudsRequest, ListPrivateCloudsResponse, PrivateCloud>
                  pageContext =
                      PageContext.create(
                          callable, LIST_PRIVATE_CLOUDS_PAGE_STR_DESC, request, context);
              return ListPrivateCloudsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListClustersRequest, ListClustersResponse, ListClustersPagedResponse>
      LIST_CLUSTERS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListClustersRequest, ListClustersResponse, ListClustersPagedResponse>() {
            @Override
            public ApiFuture<ListClustersPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListClustersRequest, ListClustersResponse> callable,
                ListClustersRequest request,
                ApiCallContext context,
                ApiFuture<ListClustersResponse> futureResponse) {
              PageContext<ListClustersRequest, ListClustersResponse, Cluster> pageContext =
                  PageContext.create(callable, LIST_CLUSTERS_PAGE_STR_DESC, request, context);
              return ListClustersPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListSubnetsRequest, ListSubnetsResponse, ListSubnetsPagedResponse>
      LIST_SUBNETS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListSubnetsRequest, ListSubnetsResponse, ListSubnetsPagedResponse>() {
            @Override
            public ApiFuture<ListSubnetsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListSubnetsRequest, ListSubnetsResponse> callable,
                ListSubnetsRequest request,
                ApiCallContext context,
                ApiFuture<ListSubnetsResponse> futureResponse) {
              PageContext<ListSubnetsRequest, ListSubnetsResponse, Subnet> pageContext =
                  PageContext.create(callable, LIST_SUBNETS_PAGE_STR_DESC, request, context);
              return ListSubnetsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListNodeTypesRequest, ListNodeTypesResponse, ListNodeTypesPagedResponse>
      LIST_NODE_TYPES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListNodeTypesRequest, ListNodeTypesResponse, ListNodeTypesPagedResponse>() {
            @Override
            public ApiFuture<ListNodeTypesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListNodeTypesRequest, ListNodeTypesResponse> callable,
                ListNodeTypesRequest request,
                ApiCallContext context,
                ApiFuture<ListNodeTypesResponse> futureResponse) {
              PageContext<ListNodeTypesRequest, ListNodeTypesResponse, NodeType> pageContext =
                  PageContext.create(callable, LIST_NODE_TYPES_PAGE_STR_DESC, request, context);
              return ListNodeTypesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListHcxActivationKeysRequest,
          ListHcxActivationKeysResponse,
          ListHcxActivationKeysPagedResponse>
      LIST_HCX_ACTIVATION_KEYS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListHcxActivationKeysRequest,
              ListHcxActivationKeysResponse,
              ListHcxActivationKeysPagedResponse>() {
            @Override
            public ApiFuture<ListHcxActivationKeysPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListHcxActivationKeysRequest, ListHcxActivationKeysResponse> callable,
                ListHcxActivationKeysRequest request,
                ApiCallContext context,
                ApiFuture<ListHcxActivationKeysResponse> futureResponse) {
              PageContext<
                      ListHcxActivationKeysRequest, ListHcxActivationKeysResponse, HcxActivationKey>
                  pageContext =
                      PageContext.create(
                          callable, LIST_HCX_ACTIVATION_KEYS_PAGE_STR_DESC, request, context);
              return ListHcxActivationKeysPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListNetworkPoliciesRequest, ListNetworkPoliciesResponse, ListNetworkPoliciesPagedResponse>
      LIST_NETWORK_POLICIES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListNetworkPoliciesRequest,
              ListNetworkPoliciesResponse,
              ListNetworkPoliciesPagedResponse>() {
            @Override
            public ApiFuture<ListNetworkPoliciesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListNetworkPoliciesRequest, ListNetworkPoliciesResponse> callable,
                ListNetworkPoliciesRequest request,
                ApiCallContext context,
                ApiFuture<ListNetworkPoliciesResponse> futureResponse) {
              PageContext<ListNetworkPoliciesRequest, ListNetworkPoliciesResponse, NetworkPolicy>
                  pageContext =
                      PageContext.create(
                          callable, LIST_NETWORK_POLICIES_PAGE_STR_DESC, request, context);
              return ListNetworkPoliciesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListVmwareEngineNetworksRequest,
          ListVmwareEngineNetworksResponse,
          ListVmwareEngineNetworksPagedResponse>
      LIST_VMWARE_ENGINE_NETWORKS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListVmwareEngineNetworksRequest,
              ListVmwareEngineNetworksResponse,
              ListVmwareEngineNetworksPagedResponse>() {
            @Override
            public ApiFuture<ListVmwareEngineNetworksPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListVmwareEngineNetworksRequest, ListVmwareEngineNetworksResponse>
                    callable,
                ListVmwareEngineNetworksRequest request,
                ApiCallContext context,
                ApiFuture<ListVmwareEngineNetworksResponse> futureResponse) {
              PageContext<
                      ListVmwareEngineNetworksRequest,
                      ListVmwareEngineNetworksResponse,
                      VmwareEngineNetwork>
                  pageContext =
                      PageContext.create(
                          callable, LIST_VMWARE_ENGINE_NETWORKS_PAGE_STR_DESC, request, context);
              return ListVmwareEngineNetworksPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      LIST_LOCATIONS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>() {
            @Override
            public ApiFuture<ListLocationsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListLocationsRequest, ListLocationsResponse> callable,
                ListLocationsRequest request,
                ApiCallContext context,
                ApiFuture<ListLocationsResponse> futureResponse) {
              PageContext<ListLocationsRequest, ListLocationsResponse, Location> pageContext =
                  PageContext.create(callable, LIST_LOCATIONS_PAGE_STR_DESC, request, context);
              return ListLocationsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to listPrivateClouds. */
  public PagedCallSettings<
          ListPrivateCloudsRequest, ListPrivateCloudsResponse, ListPrivateCloudsPagedResponse>
      listPrivateCloudsSettings() {
    return listPrivateCloudsSettings;
  }

  /** Returns the object with the settings used for calls to getPrivateCloud. */
  public UnaryCallSettings<GetPrivateCloudRequest, PrivateCloud> getPrivateCloudSettings() {
    return getPrivateCloudSettings;
  }

  /** Returns the object with the settings used for calls to createPrivateCloud. */
  public UnaryCallSettings<CreatePrivateCloudRequest, Operation> createPrivateCloudSettings() {
    return createPrivateCloudSettings;
  }

  /** Returns the object with the settings used for calls to createPrivateCloud. */
  public OperationCallSettings<CreatePrivateCloudRequest, PrivateCloud, OperationMetadata>
      createPrivateCloudOperationSettings() {
    return createPrivateCloudOperationSettings;
  }

  /** Returns the object with the settings used for calls to updatePrivateCloud. */
  public UnaryCallSettings<UpdatePrivateCloudRequest, Operation> updatePrivateCloudSettings() {
    return updatePrivateCloudSettings;
  }

  /** Returns the object with the settings used for calls to updatePrivateCloud. */
  public OperationCallSettings<UpdatePrivateCloudRequest, PrivateCloud, OperationMetadata>
      updatePrivateCloudOperationSettings() {
    return updatePrivateCloudOperationSettings;
  }

  /** Returns the object with the settings used for calls to deletePrivateCloud. */
  public UnaryCallSettings<DeletePrivateCloudRequest, Operation> deletePrivateCloudSettings() {
    return deletePrivateCloudSettings;
  }

  /** Returns the object with the settings used for calls to deletePrivateCloud. */
  public OperationCallSettings<DeletePrivateCloudRequest, PrivateCloud, OperationMetadata>
      deletePrivateCloudOperationSettings() {
    return deletePrivateCloudOperationSettings;
  }

  /** Returns the object with the settings used for calls to undeletePrivateCloud. */
  public UnaryCallSettings<UndeletePrivateCloudRequest, Operation> undeletePrivateCloudSettings() {
    return undeletePrivateCloudSettings;
  }

  /** Returns the object with the settings used for calls to undeletePrivateCloud. */
  public OperationCallSettings<UndeletePrivateCloudRequest, PrivateCloud, OperationMetadata>
      undeletePrivateCloudOperationSettings() {
    return undeletePrivateCloudOperationSettings;
  }

  /** Returns the object with the settings used for calls to listClusters. */
  public PagedCallSettings<ListClustersRequest, ListClustersResponse, ListClustersPagedResponse>
      listClustersSettings() {
    return listClustersSettings;
  }

  /** Returns the object with the settings used for calls to getCluster. */
  public UnaryCallSettings<GetClusterRequest, Cluster> getClusterSettings() {
    return getClusterSettings;
  }

  /** Returns the object with the settings used for calls to createCluster. */
  public UnaryCallSettings<CreateClusterRequest, Operation> createClusterSettings() {
    return createClusterSettings;
  }

  /** Returns the object with the settings used for calls to createCluster. */
  public OperationCallSettings<CreateClusterRequest, Cluster, OperationMetadata>
      createClusterOperationSettings() {
    return createClusterOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateCluster. */
  public UnaryCallSettings<UpdateClusterRequest, Operation> updateClusterSettings() {
    return updateClusterSettings;
  }

  /** Returns the object with the settings used for calls to updateCluster. */
  public OperationCallSettings<UpdateClusterRequest, Cluster, OperationMetadata>
      updateClusterOperationSettings() {
    return updateClusterOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteCluster. */
  public UnaryCallSettings<DeleteClusterRequest, Operation> deleteClusterSettings() {
    return deleteClusterSettings;
  }

  /** Returns the object with the settings used for calls to deleteCluster. */
  public OperationCallSettings<DeleteClusterRequest, Empty, OperationMetadata>
      deleteClusterOperationSettings() {
    return deleteClusterOperationSettings;
  }

  /** Returns the object with the settings used for calls to listSubnets. */
  public PagedCallSettings<ListSubnetsRequest, ListSubnetsResponse, ListSubnetsPagedResponse>
      listSubnetsSettings() {
    return listSubnetsSettings;
  }

  /** Returns the object with the settings used for calls to listNodeTypes. */
  public PagedCallSettings<ListNodeTypesRequest, ListNodeTypesResponse, ListNodeTypesPagedResponse>
      listNodeTypesSettings() {
    return listNodeTypesSettings;
  }

  /** Returns the object with the settings used for calls to getNodeType. */
  public UnaryCallSettings<GetNodeTypeRequest, NodeType> getNodeTypeSettings() {
    return getNodeTypeSettings;
  }

  /** Returns the object with the settings used for calls to showNsxCredentials. */
  public UnaryCallSettings<ShowNsxCredentialsRequest, Credentials> showNsxCredentialsSettings() {
    return showNsxCredentialsSettings;
  }

  /** Returns the object with the settings used for calls to showVcenterCredentials. */
  public UnaryCallSettings<ShowVcenterCredentialsRequest, Credentials>
      showVcenterCredentialsSettings() {
    return showVcenterCredentialsSettings;
  }

  /** Returns the object with the settings used for calls to resetNsxCredentials. */
  public UnaryCallSettings<ResetNsxCredentialsRequest, Operation> resetNsxCredentialsSettings() {
    return resetNsxCredentialsSettings;
  }

  /** Returns the object with the settings used for calls to resetNsxCredentials. */
  public OperationCallSettings<ResetNsxCredentialsRequest, PrivateCloud, OperationMetadata>
      resetNsxCredentialsOperationSettings() {
    return resetNsxCredentialsOperationSettings;
  }

  /** Returns the object with the settings used for calls to resetVcenterCredentials. */
  public UnaryCallSettings<ResetVcenterCredentialsRequest, Operation>
      resetVcenterCredentialsSettings() {
    return resetVcenterCredentialsSettings;
  }

  /** Returns the object with the settings used for calls to resetVcenterCredentials. */
  public OperationCallSettings<ResetVcenterCredentialsRequest, PrivateCloud, OperationMetadata>
      resetVcenterCredentialsOperationSettings() {
    return resetVcenterCredentialsOperationSettings;
  }

  /** Returns the object with the settings used for calls to createHcxActivationKey. */
  public UnaryCallSettings<CreateHcxActivationKeyRequest, Operation>
      createHcxActivationKeySettings() {
    return createHcxActivationKeySettings;
  }

  /** Returns the object with the settings used for calls to createHcxActivationKey. */
  public OperationCallSettings<CreateHcxActivationKeyRequest, HcxActivationKey, OperationMetadata>
      createHcxActivationKeyOperationSettings() {
    return createHcxActivationKeyOperationSettings;
  }

  /** Returns the object with the settings used for calls to listHcxActivationKeys. */
  public PagedCallSettings<
          ListHcxActivationKeysRequest,
          ListHcxActivationKeysResponse,
          ListHcxActivationKeysPagedResponse>
      listHcxActivationKeysSettings() {
    return listHcxActivationKeysSettings;
  }

  /** Returns the object with the settings used for calls to getHcxActivationKey. */
  public UnaryCallSettings<GetHcxActivationKeyRequest, HcxActivationKey>
      getHcxActivationKeySettings() {
    return getHcxActivationKeySettings;
  }

  /** Returns the object with the settings used for calls to getNetworkPolicy. */
  public UnaryCallSettings<GetNetworkPolicyRequest, NetworkPolicy> getNetworkPolicySettings() {
    return getNetworkPolicySettings;
  }

  /** Returns the object with the settings used for calls to listNetworkPolicies. */
  public PagedCallSettings<
          ListNetworkPoliciesRequest, ListNetworkPoliciesResponse, ListNetworkPoliciesPagedResponse>
      listNetworkPoliciesSettings() {
    return listNetworkPoliciesSettings;
  }

  /** Returns the object with the settings used for calls to createNetworkPolicy. */
  public UnaryCallSettings<CreateNetworkPolicyRequest, Operation> createNetworkPolicySettings() {
    return createNetworkPolicySettings;
  }

  /** Returns the object with the settings used for calls to createNetworkPolicy. */
  public OperationCallSettings<CreateNetworkPolicyRequest, NetworkPolicy, OperationMetadata>
      createNetworkPolicyOperationSettings() {
    return createNetworkPolicyOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateNetworkPolicy. */
  public UnaryCallSettings<UpdateNetworkPolicyRequest, Operation> updateNetworkPolicySettings() {
    return updateNetworkPolicySettings;
  }

  /** Returns the object with the settings used for calls to updateNetworkPolicy. */
  public OperationCallSettings<UpdateNetworkPolicyRequest, NetworkPolicy, OperationMetadata>
      updateNetworkPolicyOperationSettings() {
    return updateNetworkPolicyOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteNetworkPolicy. */
  public UnaryCallSettings<DeleteNetworkPolicyRequest, Operation> deleteNetworkPolicySettings() {
    return deleteNetworkPolicySettings;
  }

  /** Returns the object with the settings used for calls to deleteNetworkPolicy. */
  public OperationCallSettings<DeleteNetworkPolicyRequest, Empty, OperationMetadata>
      deleteNetworkPolicyOperationSettings() {
    return deleteNetworkPolicyOperationSettings;
  }

  /** Returns the object with the settings used for calls to createVmwareEngineNetwork. */
  public UnaryCallSettings<CreateVmwareEngineNetworkRequest, Operation>
      createVmwareEngineNetworkSettings() {
    return createVmwareEngineNetworkSettings;
  }

  /** Returns the object with the settings used for calls to createVmwareEngineNetwork. */
  public OperationCallSettings<
          CreateVmwareEngineNetworkRequest, VmwareEngineNetwork, OperationMetadata>
      createVmwareEngineNetworkOperationSettings() {
    return createVmwareEngineNetworkOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateVmwareEngineNetwork. */
  public UnaryCallSettings<UpdateVmwareEngineNetworkRequest, Operation>
      updateVmwareEngineNetworkSettings() {
    return updateVmwareEngineNetworkSettings;
  }

  /** Returns the object with the settings used for calls to updateVmwareEngineNetwork. */
  public OperationCallSettings<
          UpdateVmwareEngineNetworkRequest, VmwareEngineNetwork, OperationMetadata>
      updateVmwareEngineNetworkOperationSettings() {
    return updateVmwareEngineNetworkOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteVmwareEngineNetwork. */
  public UnaryCallSettings<DeleteVmwareEngineNetworkRequest, Operation>
      deleteVmwareEngineNetworkSettings() {
    return deleteVmwareEngineNetworkSettings;
  }

  /** Returns the object with the settings used for calls to deleteVmwareEngineNetwork. */
  public OperationCallSettings<DeleteVmwareEngineNetworkRequest, Empty, OperationMetadata>
      deleteVmwareEngineNetworkOperationSettings() {
    return deleteVmwareEngineNetworkOperationSettings;
  }

  /** Returns the object with the settings used for calls to getVmwareEngineNetwork. */
  public UnaryCallSettings<GetVmwareEngineNetworkRequest, VmwareEngineNetwork>
      getVmwareEngineNetworkSettings() {
    return getVmwareEngineNetworkSettings;
  }

  /** Returns the object with the settings used for calls to listVmwareEngineNetworks. */
  public PagedCallSettings<
          ListVmwareEngineNetworksRequest,
          ListVmwareEngineNetworksResponse,
          ListVmwareEngineNetworksPagedResponse>
      listVmwareEngineNetworksSettings() {
    return listVmwareEngineNetworksSettings;
  }

  /** Returns the object with the settings used for calls to listLocations. */
  public PagedCallSettings<ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings() {
    return listLocationsSettings;
  }

  /** Returns the object with the settings used for calls to getLocation. */
  public UnaryCallSettings<GetLocationRequest, Location> getLocationSettings() {
    return getLocationSettings;
  }

  /** Returns the object with the settings used for calls to setIamPolicy. */
  public UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings() {
    return setIamPolicySettings;
  }

  /** Returns the object with the settings used for calls to getIamPolicy. */
  public UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings() {
    return getIamPolicySettings;
  }

  /** Returns the object with the settings used for calls to testIamPermissions. */
  public UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings() {
    return testIamPermissionsSettings;
  }

  public VmwareEngineStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcVmwareEngineStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonVmwareEngineStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return "vmwareengine.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "vmwareengine.mtls.googleapis.com:443";
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return DEFAULT_SERVICE_SCOPES;
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return GoogleCredentialsProvider.newBuilder()
        .setScopesToApply(DEFAULT_SERVICE_SCOPES)
        .setUseJwtAccessWithScope(true);
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return InstantiatingGrpcChannelProvider.newBuilder()
        .setMaxInboundMessageSize(Integer.MAX_VALUE);
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return InstantiatingHttpJsonChannelProvider.newBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return defaultGrpcTransportProviderBuilder().build();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultGrpcApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(VmwareEngineStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(VmwareEngineStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return VmwareEngineStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
  }

  /** Returns a new gRPC builder for this class. */
  public static Builder newBuilder() {
    return Builder.createDefault();
  }

  /** Returns a new REST builder for this class. */
  public static Builder newHttpJsonBuilder() {
    return Builder.createHttpJsonDefault();
  }

  /** Returns a new builder for this class. */
  public static Builder newBuilder(ClientContext clientContext) {
    return new Builder(clientContext);
  }

  /** Returns a builder containing all the values of this settings class. */
  public Builder toBuilder() {
    return new Builder(this);
  }

  protected VmwareEngineStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    listPrivateCloudsSettings = settingsBuilder.listPrivateCloudsSettings().build();
    getPrivateCloudSettings = settingsBuilder.getPrivateCloudSettings().build();
    createPrivateCloudSettings = settingsBuilder.createPrivateCloudSettings().build();
    createPrivateCloudOperationSettings =
        settingsBuilder.createPrivateCloudOperationSettings().build();
    updatePrivateCloudSettings = settingsBuilder.updatePrivateCloudSettings().build();
    updatePrivateCloudOperationSettings =
        settingsBuilder.updatePrivateCloudOperationSettings().build();
    deletePrivateCloudSettings = settingsBuilder.deletePrivateCloudSettings().build();
    deletePrivateCloudOperationSettings =
        settingsBuilder.deletePrivateCloudOperationSettings().build();
    undeletePrivateCloudSettings = settingsBuilder.undeletePrivateCloudSettings().build();
    undeletePrivateCloudOperationSettings =
        settingsBuilder.undeletePrivateCloudOperationSettings().build();
    listClustersSettings = settingsBuilder.listClustersSettings().build();
    getClusterSettings = settingsBuilder.getClusterSettings().build();
    createClusterSettings = settingsBuilder.createClusterSettings().build();
    createClusterOperationSettings = settingsBuilder.createClusterOperationSettings().build();
    updateClusterSettings = settingsBuilder.updateClusterSettings().build();
    updateClusterOperationSettings = settingsBuilder.updateClusterOperationSettings().build();
    deleteClusterSettings = settingsBuilder.deleteClusterSettings().build();
    deleteClusterOperationSettings = settingsBuilder.deleteClusterOperationSettings().build();
    listSubnetsSettings = settingsBuilder.listSubnetsSettings().build();
    listNodeTypesSettings = settingsBuilder.listNodeTypesSettings().build();
    getNodeTypeSettings = settingsBuilder.getNodeTypeSettings().build();
    showNsxCredentialsSettings = settingsBuilder.showNsxCredentialsSettings().build();
    showVcenterCredentialsSettings = settingsBuilder.showVcenterCredentialsSettings().build();
    resetNsxCredentialsSettings = settingsBuilder.resetNsxCredentialsSettings().build();
    resetNsxCredentialsOperationSettings =
        settingsBuilder.resetNsxCredentialsOperationSettings().build();
    resetVcenterCredentialsSettings = settingsBuilder.resetVcenterCredentialsSettings().build();
    resetVcenterCredentialsOperationSettings =
        settingsBuilder.resetVcenterCredentialsOperationSettings().build();
    createHcxActivationKeySettings = settingsBuilder.createHcxActivationKeySettings().build();
    createHcxActivationKeyOperationSettings =
        settingsBuilder.createHcxActivationKeyOperationSettings().build();
    listHcxActivationKeysSettings = settingsBuilder.listHcxActivationKeysSettings().build();
    getHcxActivationKeySettings = settingsBuilder.getHcxActivationKeySettings().build();
    getNetworkPolicySettings = settingsBuilder.getNetworkPolicySettings().build();
    listNetworkPoliciesSettings = settingsBuilder.listNetworkPoliciesSettings().build();
    createNetworkPolicySettings = settingsBuilder.createNetworkPolicySettings().build();
    createNetworkPolicyOperationSettings =
        settingsBuilder.createNetworkPolicyOperationSettings().build();
    updateNetworkPolicySettings = settingsBuilder.updateNetworkPolicySettings().build();
    updateNetworkPolicyOperationSettings =
        settingsBuilder.updateNetworkPolicyOperationSettings().build();
    deleteNetworkPolicySettings = settingsBuilder.deleteNetworkPolicySettings().build();
    deleteNetworkPolicyOperationSettings =
        settingsBuilder.deleteNetworkPolicyOperationSettings().build();
    createVmwareEngineNetworkSettings = settingsBuilder.createVmwareEngineNetworkSettings().build();
    createVmwareEngineNetworkOperationSettings =
        settingsBuilder.createVmwareEngineNetworkOperationSettings().build();
    updateVmwareEngineNetworkSettings = settingsBuilder.updateVmwareEngineNetworkSettings().build();
    updateVmwareEngineNetworkOperationSettings =
        settingsBuilder.updateVmwareEngineNetworkOperationSettings().build();
    deleteVmwareEngineNetworkSettings = settingsBuilder.deleteVmwareEngineNetworkSettings().build();
    deleteVmwareEngineNetworkOperationSettings =
        settingsBuilder.deleteVmwareEngineNetworkOperationSettings().build();
    getVmwareEngineNetworkSettings = settingsBuilder.getVmwareEngineNetworkSettings().build();
    listVmwareEngineNetworksSettings = settingsBuilder.listVmwareEngineNetworksSettings().build();
    listLocationsSettings = settingsBuilder.listLocationsSettings().build();
    getLocationSettings = settingsBuilder.getLocationSettings().build();
    setIamPolicySettings = settingsBuilder.setIamPolicySettings().build();
    getIamPolicySettings = settingsBuilder.getIamPolicySettings().build();
    testIamPermissionsSettings = settingsBuilder.testIamPermissionsSettings().build();
  }

  /** Builder for VmwareEngineStubSettings. */
  public static class Builder extends StubSettings.Builder<VmwareEngineStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final PagedCallSettings.Builder<
            ListPrivateCloudsRequest, ListPrivateCloudsResponse, ListPrivateCloudsPagedResponse>
        listPrivateCloudsSettings;
    private final UnaryCallSettings.Builder<GetPrivateCloudRequest, PrivateCloud>
        getPrivateCloudSettings;
    private final UnaryCallSettings.Builder<CreatePrivateCloudRequest, Operation>
        createPrivateCloudSettings;
    private final OperationCallSettings.Builder<
            CreatePrivateCloudRequest, PrivateCloud, OperationMetadata>
        createPrivateCloudOperationSettings;
    private final UnaryCallSettings.Builder<UpdatePrivateCloudRequest, Operation>
        updatePrivateCloudSettings;
    private final OperationCallSettings.Builder<
            UpdatePrivateCloudRequest, PrivateCloud, OperationMetadata>
        updatePrivateCloudOperationSettings;
    private final UnaryCallSettings.Builder<DeletePrivateCloudRequest, Operation>
        deletePrivateCloudSettings;
    private final OperationCallSettings.Builder<
            DeletePrivateCloudRequest, PrivateCloud, OperationMetadata>
        deletePrivateCloudOperationSettings;
    private final UnaryCallSettings.Builder<UndeletePrivateCloudRequest, Operation>
        undeletePrivateCloudSettings;
    private final OperationCallSettings.Builder<
            UndeletePrivateCloudRequest, PrivateCloud, OperationMetadata>
        undeletePrivateCloudOperationSettings;
    private final PagedCallSettings.Builder<
            ListClustersRequest, ListClustersResponse, ListClustersPagedResponse>
        listClustersSettings;
    private final UnaryCallSettings.Builder<GetClusterRequest, Cluster> getClusterSettings;
    private final UnaryCallSettings.Builder<CreateClusterRequest, Operation> createClusterSettings;
    private final OperationCallSettings.Builder<CreateClusterRequest, Cluster, OperationMetadata>
        createClusterOperationSettings;
    private final UnaryCallSettings.Builder<UpdateClusterRequest, Operation> updateClusterSettings;
    private final OperationCallSettings.Builder<UpdateClusterRequest, Cluster, OperationMetadata>
        updateClusterOperationSettings;
    private final UnaryCallSettings.Builder<DeleteClusterRequest, Operation> deleteClusterSettings;
    private final OperationCallSettings.Builder<DeleteClusterRequest, Empty, OperationMetadata>
        deleteClusterOperationSettings;
    private final PagedCallSettings.Builder<
            ListSubnetsRequest, ListSubnetsResponse, ListSubnetsPagedResponse>
        listSubnetsSettings;
    private final PagedCallSettings.Builder<
            ListNodeTypesRequest, ListNodeTypesResponse, ListNodeTypesPagedResponse>
        listNodeTypesSettings;
    private final UnaryCallSettings.Builder<GetNodeTypeRequest, NodeType> getNodeTypeSettings;
    private final UnaryCallSettings.Builder<ShowNsxCredentialsRequest, Credentials>
        showNsxCredentialsSettings;
    private final UnaryCallSettings.Builder<ShowVcenterCredentialsRequest, Credentials>
        showVcenterCredentialsSettings;
    private final UnaryCallSettings.Builder<ResetNsxCredentialsRequest, Operation>
        resetNsxCredentialsSettings;
    private final OperationCallSettings.Builder<
            ResetNsxCredentialsRequest, PrivateCloud, OperationMetadata>
        resetNsxCredentialsOperationSettings;
    private final UnaryCallSettings.Builder<ResetVcenterCredentialsRequest, Operation>
        resetVcenterCredentialsSettings;
    private final OperationCallSettings.Builder<
            ResetVcenterCredentialsRequest, PrivateCloud, OperationMetadata>
        resetVcenterCredentialsOperationSettings;
    private final UnaryCallSettings.Builder<CreateHcxActivationKeyRequest, Operation>
        createHcxActivationKeySettings;
    private final OperationCallSettings.Builder<
            CreateHcxActivationKeyRequest, HcxActivationKey, OperationMetadata>
        createHcxActivationKeyOperationSettings;
    private final PagedCallSettings.Builder<
            ListHcxActivationKeysRequest,
            ListHcxActivationKeysResponse,
            ListHcxActivationKeysPagedResponse>
        listHcxActivationKeysSettings;
    private final UnaryCallSettings.Builder<GetHcxActivationKeyRequest, HcxActivationKey>
        getHcxActivationKeySettings;
    private final UnaryCallSettings.Builder<GetNetworkPolicyRequest, NetworkPolicy>
        getNetworkPolicySettings;
    private final PagedCallSettings.Builder<
            ListNetworkPoliciesRequest,
            ListNetworkPoliciesResponse,
            ListNetworkPoliciesPagedResponse>
        listNetworkPoliciesSettings;
    private final UnaryCallSettings.Builder<CreateNetworkPolicyRequest, Operation>
        createNetworkPolicySettings;
    private final OperationCallSettings.Builder<
            CreateNetworkPolicyRequest, NetworkPolicy, OperationMetadata>
        createNetworkPolicyOperationSettings;
    private final UnaryCallSettings.Builder<UpdateNetworkPolicyRequest, Operation>
        updateNetworkPolicySettings;
    private final OperationCallSettings.Builder<
            UpdateNetworkPolicyRequest, NetworkPolicy, OperationMetadata>
        updateNetworkPolicyOperationSettings;
    private final UnaryCallSettings.Builder<DeleteNetworkPolicyRequest, Operation>
        deleteNetworkPolicySettings;
    private final OperationCallSettings.Builder<
            DeleteNetworkPolicyRequest, Empty, OperationMetadata>
        deleteNetworkPolicyOperationSettings;
    private final UnaryCallSettings.Builder<CreateVmwareEngineNetworkRequest, Operation>
        createVmwareEngineNetworkSettings;
    private final OperationCallSettings.Builder<
            CreateVmwareEngineNetworkRequest, VmwareEngineNetwork, OperationMetadata>
        createVmwareEngineNetworkOperationSettings;
    private final UnaryCallSettings.Builder<UpdateVmwareEngineNetworkRequest, Operation>
        updateVmwareEngineNetworkSettings;
    private final OperationCallSettings.Builder<
            UpdateVmwareEngineNetworkRequest, VmwareEngineNetwork, OperationMetadata>
        updateVmwareEngineNetworkOperationSettings;
    private final UnaryCallSettings.Builder<DeleteVmwareEngineNetworkRequest, Operation>
        deleteVmwareEngineNetworkSettings;
    private final OperationCallSettings.Builder<
            DeleteVmwareEngineNetworkRequest, Empty, OperationMetadata>
        deleteVmwareEngineNetworkOperationSettings;
    private final UnaryCallSettings.Builder<GetVmwareEngineNetworkRequest, VmwareEngineNetwork>
        getVmwareEngineNetworkSettings;
    private final PagedCallSettings.Builder<
            ListVmwareEngineNetworksRequest,
            ListVmwareEngineNetworksResponse,
            ListVmwareEngineNetworksPagedResponse>
        listVmwareEngineNetworksSettings;
    private final PagedCallSettings.Builder<
            ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
        listLocationsSettings;
    private final UnaryCallSettings.Builder<GetLocationRequest, Location> getLocationSettings;
    private final UnaryCallSettings.Builder<SetIamPolicyRequest, Policy> setIamPolicySettings;
    private final UnaryCallSettings.Builder<GetIamPolicyRequest, Policy> getIamPolicySettings;
    private final UnaryCallSettings.Builder<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put(
          "retry_policy_0_codes",
          ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList(StatusCode.Code.UNAVAILABLE)));
      definitions.put(
          "no_retry_1_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      RETRYABLE_CODE_DEFINITIONS = definitions.build();
    }

    private static final ImmutableMap<String, RetrySettings> RETRY_PARAM_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, RetrySettings> definitions = ImmutableMap.builder();
      RetrySettings settings = null;
      settings =
          RetrySettings.newBuilder()
              .setInitialRetryDelay(Duration.ofMillis(1000L))
              .setRetryDelayMultiplier(1.3)
              .setMaxRetryDelay(Duration.ofMillis(10000L))
              .setInitialRpcTimeout(Duration.ofMillis(120000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(120000L))
              .setTotalTimeout(Duration.ofMillis(120000L))
              .build();
      definitions.put("retry_policy_0_params", settings);
      settings =
          RetrySettings.newBuilder()
              .setInitialRpcTimeout(Duration.ofMillis(120000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(120000L))
              .setTotalTimeout(Duration.ofMillis(120000L))
              .build();
      definitions.put("no_retry_1_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      listPrivateCloudsSettings = PagedCallSettings.newBuilder(LIST_PRIVATE_CLOUDS_PAGE_STR_FACT);
      getPrivateCloudSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createPrivateCloudSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createPrivateCloudOperationSettings = OperationCallSettings.newBuilder();
      updatePrivateCloudSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updatePrivateCloudOperationSettings = OperationCallSettings.newBuilder();
      deletePrivateCloudSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deletePrivateCloudOperationSettings = OperationCallSettings.newBuilder();
      undeletePrivateCloudSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      undeletePrivateCloudOperationSettings = OperationCallSettings.newBuilder();
      listClustersSettings = PagedCallSettings.newBuilder(LIST_CLUSTERS_PAGE_STR_FACT);
      getClusterSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createClusterSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createClusterOperationSettings = OperationCallSettings.newBuilder();
      updateClusterSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateClusterOperationSettings = OperationCallSettings.newBuilder();
      deleteClusterSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteClusterOperationSettings = OperationCallSettings.newBuilder();
      listSubnetsSettings = PagedCallSettings.newBuilder(LIST_SUBNETS_PAGE_STR_FACT);
      listNodeTypesSettings = PagedCallSettings.newBuilder(LIST_NODE_TYPES_PAGE_STR_FACT);
      getNodeTypeSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      showNsxCredentialsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      showVcenterCredentialsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      resetNsxCredentialsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      resetNsxCredentialsOperationSettings = OperationCallSettings.newBuilder();
      resetVcenterCredentialsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      resetVcenterCredentialsOperationSettings = OperationCallSettings.newBuilder();
      createHcxActivationKeySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createHcxActivationKeyOperationSettings = OperationCallSettings.newBuilder();
      listHcxActivationKeysSettings =
          PagedCallSettings.newBuilder(LIST_HCX_ACTIVATION_KEYS_PAGE_STR_FACT);
      getHcxActivationKeySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getNetworkPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listNetworkPoliciesSettings =
          PagedCallSettings.newBuilder(LIST_NETWORK_POLICIES_PAGE_STR_FACT);
      createNetworkPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createNetworkPolicyOperationSettings = OperationCallSettings.newBuilder();
      updateNetworkPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateNetworkPolicyOperationSettings = OperationCallSettings.newBuilder();
      deleteNetworkPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteNetworkPolicyOperationSettings = OperationCallSettings.newBuilder();
      createVmwareEngineNetworkSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createVmwareEngineNetworkOperationSettings = OperationCallSettings.newBuilder();
      updateVmwareEngineNetworkSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateVmwareEngineNetworkOperationSettings = OperationCallSettings.newBuilder();
      deleteVmwareEngineNetworkSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteVmwareEngineNetworkOperationSettings = OperationCallSettings.newBuilder();
      getVmwareEngineNetworkSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listVmwareEngineNetworksSettings =
          PagedCallSettings.newBuilder(LIST_VMWARE_ENGINE_NETWORKS_PAGE_STR_FACT);
      listLocationsSettings = PagedCallSettings.newBuilder(LIST_LOCATIONS_PAGE_STR_FACT);
      getLocationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      setIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      testIamPermissionsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listPrivateCloudsSettings,
              getPrivateCloudSettings,
              createPrivateCloudSettings,
              updatePrivateCloudSettings,
              deletePrivateCloudSettings,
              undeletePrivateCloudSettings,
              listClustersSettings,
              getClusterSettings,
              createClusterSettings,
              updateClusterSettings,
              deleteClusterSettings,
              listSubnetsSettings,
              listNodeTypesSettings,
              getNodeTypeSettings,
              showNsxCredentialsSettings,
              showVcenterCredentialsSettings,
              resetNsxCredentialsSettings,
              resetVcenterCredentialsSettings,
              createHcxActivationKeySettings,
              listHcxActivationKeysSettings,
              getHcxActivationKeySettings,
              getNetworkPolicySettings,
              listNetworkPoliciesSettings,
              createNetworkPolicySettings,
              updateNetworkPolicySettings,
              deleteNetworkPolicySettings,
              createVmwareEngineNetworkSettings,
              updateVmwareEngineNetworkSettings,
              deleteVmwareEngineNetworkSettings,
              getVmwareEngineNetworkSettings,
              listVmwareEngineNetworksSettings,
              listLocationsSettings,
              getLocationSettings,
              setIamPolicySettings,
              getIamPolicySettings,
              testIamPermissionsSettings);
      initDefaults(this);
    }

    protected Builder(VmwareEngineStubSettings settings) {
      super(settings);

      listPrivateCloudsSettings = settings.listPrivateCloudsSettings.toBuilder();
      getPrivateCloudSettings = settings.getPrivateCloudSettings.toBuilder();
      createPrivateCloudSettings = settings.createPrivateCloudSettings.toBuilder();
      createPrivateCloudOperationSettings =
          settings.createPrivateCloudOperationSettings.toBuilder();
      updatePrivateCloudSettings = settings.updatePrivateCloudSettings.toBuilder();
      updatePrivateCloudOperationSettings =
          settings.updatePrivateCloudOperationSettings.toBuilder();
      deletePrivateCloudSettings = settings.deletePrivateCloudSettings.toBuilder();
      deletePrivateCloudOperationSettings =
          settings.deletePrivateCloudOperationSettings.toBuilder();
      undeletePrivateCloudSettings = settings.undeletePrivateCloudSettings.toBuilder();
      undeletePrivateCloudOperationSettings =
          settings.undeletePrivateCloudOperationSettings.toBuilder();
      listClustersSettings = settings.listClustersSettings.toBuilder();
      getClusterSettings = settings.getClusterSettings.toBuilder();
      createClusterSettings = settings.createClusterSettings.toBuilder();
      createClusterOperationSettings = settings.createClusterOperationSettings.toBuilder();
      updateClusterSettings = settings.updateClusterSettings.toBuilder();
      updateClusterOperationSettings = settings.updateClusterOperationSettings.toBuilder();
      deleteClusterSettings = settings.deleteClusterSettings.toBuilder();
      deleteClusterOperationSettings = settings.deleteClusterOperationSettings.toBuilder();
      listSubnetsSettings = settings.listSubnetsSettings.toBuilder();
      listNodeTypesSettings = settings.listNodeTypesSettings.toBuilder();
      getNodeTypeSettings = settings.getNodeTypeSettings.toBuilder();
      showNsxCredentialsSettings = settings.showNsxCredentialsSettings.toBuilder();
      showVcenterCredentialsSettings = settings.showVcenterCredentialsSettings.toBuilder();
      resetNsxCredentialsSettings = settings.resetNsxCredentialsSettings.toBuilder();
      resetNsxCredentialsOperationSettings =
          settings.resetNsxCredentialsOperationSettings.toBuilder();
      resetVcenterCredentialsSettings = settings.resetVcenterCredentialsSettings.toBuilder();
      resetVcenterCredentialsOperationSettings =
          settings.resetVcenterCredentialsOperationSettings.toBuilder();
      createHcxActivationKeySettings = settings.createHcxActivationKeySettings.toBuilder();
      createHcxActivationKeyOperationSettings =
          settings.createHcxActivationKeyOperationSettings.toBuilder();
      listHcxActivationKeysSettings = settings.listHcxActivationKeysSettings.toBuilder();
      getHcxActivationKeySettings = settings.getHcxActivationKeySettings.toBuilder();
      getNetworkPolicySettings = settings.getNetworkPolicySettings.toBuilder();
      listNetworkPoliciesSettings = settings.listNetworkPoliciesSettings.toBuilder();
      createNetworkPolicySettings = settings.createNetworkPolicySettings.toBuilder();
      createNetworkPolicyOperationSettings =
          settings.createNetworkPolicyOperationSettings.toBuilder();
      updateNetworkPolicySettings = settings.updateNetworkPolicySettings.toBuilder();
      updateNetworkPolicyOperationSettings =
          settings.updateNetworkPolicyOperationSettings.toBuilder();
      deleteNetworkPolicySettings = settings.deleteNetworkPolicySettings.toBuilder();
      deleteNetworkPolicyOperationSettings =
          settings.deleteNetworkPolicyOperationSettings.toBuilder();
      createVmwareEngineNetworkSettings = settings.createVmwareEngineNetworkSettings.toBuilder();
      createVmwareEngineNetworkOperationSettings =
          settings.createVmwareEngineNetworkOperationSettings.toBuilder();
      updateVmwareEngineNetworkSettings = settings.updateVmwareEngineNetworkSettings.toBuilder();
      updateVmwareEngineNetworkOperationSettings =
          settings.updateVmwareEngineNetworkOperationSettings.toBuilder();
      deleteVmwareEngineNetworkSettings = settings.deleteVmwareEngineNetworkSettings.toBuilder();
      deleteVmwareEngineNetworkOperationSettings =
          settings.deleteVmwareEngineNetworkOperationSettings.toBuilder();
      getVmwareEngineNetworkSettings = settings.getVmwareEngineNetworkSettings.toBuilder();
      listVmwareEngineNetworksSettings = settings.listVmwareEngineNetworksSettings.toBuilder();
      listLocationsSettings = settings.listLocationsSettings.toBuilder();
      getLocationSettings = settings.getLocationSettings.toBuilder();
      setIamPolicySettings = settings.setIamPolicySettings.toBuilder();
      getIamPolicySettings = settings.getIamPolicySettings.toBuilder();
      testIamPermissionsSettings = settings.testIamPermissionsSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listPrivateCloudsSettings,
              getPrivateCloudSettings,
              createPrivateCloudSettings,
              updatePrivateCloudSettings,
              deletePrivateCloudSettings,
              undeletePrivateCloudSettings,
              listClustersSettings,
              getClusterSettings,
              createClusterSettings,
              updateClusterSettings,
              deleteClusterSettings,
              listSubnetsSettings,
              listNodeTypesSettings,
              getNodeTypeSettings,
              showNsxCredentialsSettings,
              showVcenterCredentialsSettings,
              resetNsxCredentialsSettings,
              resetVcenterCredentialsSettings,
              createHcxActivationKeySettings,
              listHcxActivationKeysSettings,
              getHcxActivationKeySettings,
              getNetworkPolicySettings,
              listNetworkPoliciesSettings,
              createNetworkPolicySettings,
              updateNetworkPolicySettings,
              deleteNetworkPolicySettings,
              createVmwareEngineNetworkSettings,
              updateVmwareEngineNetworkSettings,
              deleteVmwareEngineNetworkSettings,
              getVmwareEngineNetworkSettings,
              listVmwareEngineNetworksSettings,
              listLocationsSettings,
              getLocationSettings,
              setIamPolicySettings,
              getIamPolicySettings,
              testIamPermissionsSettings);
    }

    private static Builder createDefault() {
      Builder builder = new Builder(((ClientContext) null));

      builder.setTransportChannelProvider(defaultTransportChannelProvider());
      builder.setCredentialsProvider(defaultCredentialsProviderBuilder().build());
      builder.setInternalHeaderProvider(defaultApiClientHeaderProviderBuilder().build());
      builder.setEndpoint(getDefaultEndpoint());
      builder.setMtlsEndpoint(getDefaultMtlsEndpoint());
      builder.setSwitchToMtlsEndpointAllowed(true);

      return initDefaults(builder);
    }

    private static Builder createHttpJsonDefault() {
      Builder builder = new Builder(((ClientContext) null));

      builder.setTransportChannelProvider(defaultHttpJsonTransportProviderBuilder().build());
      builder.setCredentialsProvider(defaultCredentialsProviderBuilder().build());
      builder.setInternalHeaderProvider(defaultHttpJsonApiClientHeaderProviderBuilder().build());
      builder.setEndpoint(getDefaultEndpoint());
      builder.setMtlsEndpoint(getDefaultMtlsEndpoint());
      builder.setSwitchToMtlsEndpointAllowed(true);

      return initDefaults(builder);
    }

    private static Builder initDefaults(Builder builder) {
      builder
          .listPrivateCloudsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getPrivateCloudSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createPrivateCloudSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .updatePrivateCloudSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .deletePrivateCloudSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .undeletePrivateCloudSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .listClustersSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getClusterSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createClusterSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .updateClusterSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .deleteClusterSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .listSubnetsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listNodeTypesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getNodeTypeSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .showNsxCredentialsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .showVcenterCredentialsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .resetNsxCredentialsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .resetVcenterCredentialsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .createHcxActivationKeySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .listHcxActivationKeysSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getHcxActivationKeySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getNetworkPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listNetworkPoliciesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createNetworkPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .updateNetworkPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .deleteNetworkPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .createVmwareEngineNetworkSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .updateVmwareEngineNetworkSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .deleteVmwareEngineNetworkSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .getVmwareEngineNetworkSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listVmwareEngineNetworksSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listLocationsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .getLocationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .setIamPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .getIamPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .testIamPermissionsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .createPrivateCloudOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreatePrivateCloudRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(PrivateCloud.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .updatePrivateCloudOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdatePrivateCloudRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(PrivateCloud.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .deletePrivateCloudOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeletePrivateCloudRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(PrivateCloud.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .undeletePrivateCloudOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UndeletePrivateCloudRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(PrivateCloud.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .createClusterOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateClusterRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Cluster.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .updateClusterOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateClusterRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Cluster.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .deleteClusterOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteClusterRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .resetNsxCredentialsOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<ResetNsxCredentialsRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(PrivateCloud.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .resetVcenterCredentialsOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<ResetVcenterCredentialsRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(PrivateCloud.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .createHcxActivationKeyOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateHcxActivationKeyRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(HcxActivationKey.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .createNetworkPolicyOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateNetworkPolicyRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(NetworkPolicy.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .updateNetworkPolicyOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateNetworkPolicyRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(NetworkPolicy.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .deleteNetworkPolicyOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteNetworkPolicyRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .createVmwareEngineNetworkOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateVmwareEngineNetworkRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(VmwareEngineNetwork.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .updateVmwareEngineNetworkOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateVmwareEngineNetworkRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(VmwareEngineNetwork.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .deleteVmwareEngineNetworkOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteVmwareEngineNetworkRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      return builder;
    }

    /**
     * Applies the given settings updater function to all of the unary API methods in this service.
     *
     * <p>Note: This method does not support applying settings to streaming methods.
     */
    public Builder applyToAllUnaryMethods(
        ApiFunction<UnaryCallSettings.Builder<?, ?>, Void> settingsUpdater) {
      super.applyToAllUnaryMethods(unaryMethodSettingsBuilders, settingsUpdater);
      return this;
    }

    public ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders() {
      return unaryMethodSettingsBuilders;
    }

    /** Returns the builder for the settings used for calls to listPrivateClouds. */
    public PagedCallSettings.Builder<
            ListPrivateCloudsRequest, ListPrivateCloudsResponse, ListPrivateCloudsPagedResponse>
        listPrivateCloudsSettings() {
      return listPrivateCloudsSettings;
    }

    /** Returns the builder for the settings used for calls to getPrivateCloud. */
    public UnaryCallSettings.Builder<GetPrivateCloudRequest, PrivateCloud>
        getPrivateCloudSettings() {
      return getPrivateCloudSettings;
    }

    /** Returns the builder for the settings used for calls to createPrivateCloud. */
    public UnaryCallSettings.Builder<CreatePrivateCloudRequest, Operation>
        createPrivateCloudSettings() {
      return createPrivateCloudSettings;
    }

    /** Returns the builder for the settings used for calls to createPrivateCloud. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<CreatePrivateCloudRequest, PrivateCloud, OperationMetadata>
        createPrivateCloudOperationSettings() {
      return createPrivateCloudOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updatePrivateCloud. */
    public UnaryCallSettings.Builder<UpdatePrivateCloudRequest, Operation>
        updatePrivateCloudSettings() {
      return updatePrivateCloudSettings;
    }

    /** Returns the builder for the settings used for calls to updatePrivateCloud. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<UpdatePrivateCloudRequest, PrivateCloud, OperationMetadata>
        updatePrivateCloudOperationSettings() {
      return updatePrivateCloudOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deletePrivateCloud. */
    public UnaryCallSettings.Builder<DeletePrivateCloudRequest, Operation>
        deletePrivateCloudSettings() {
      return deletePrivateCloudSettings;
    }

    /** Returns the builder for the settings used for calls to deletePrivateCloud. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<DeletePrivateCloudRequest, PrivateCloud, OperationMetadata>
        deletePrivateCloudOperationSettings() {
      return deletePrivateCloudOperationSettings;
    }

    /** Returns the builder for the settings used for calls to undeletePrivateCloud. */
    public UnaryCallSettings.Builder<UndeletePrivateCloudRequest, Operation>
        undeletePrivateCloudSettings() {
      return undeletePrivateCloudSettings;
    }

    /** Returns the builder for the settings used for calls to undeletePrivateCloud. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            UndeletePrivateCloudRequest, PrivateCloud, OperationMetadata>
        undeletePrivateCloudOperationSettings() {
      return undeletePrivateCloudOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listClusters. */
    public PagedCallSettings.Builder<
            ListClustersRequest, ListClustersResponse, ListClustersPagedResponse>
        listClustersSettings() {
      return listClustersSettings;
    }

    /** Returns the builder for the settings used for calls to getCluster. */
    public UnaryCallSettings.Builder<GetClusterRequest, Cluster> getClusterSettings() {
      return getClusterSettings;
    }

    /** Returns the builder for the settings used for calls to createCluster. */
    public UnaryCallSettings.Builder<CreateClusterRequest, Operation> createClusterSettings() {
      return createClusterSettings;
    }

    /** Returns the builder for the settings used for calls to createCluster. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<CreateClusterRequest, Cluster, OperationMetadata>
        createClusterOperationSettings() {
      return createClusterOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateCluster. */
    public UnaryCallSettings.Builder<UpdateClusterRequest, Operation> updateClusterSettings() {
      return updateClusterSettings;
    }

    /** Returns the builder for the settings used for calls to updateCluster. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<UpdateClusterRequest, Cluster, OperationMetadata>
        updateClusterOperationSettings() {
      return updateClusterOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteCluster. */
    public UnaryCallSettings.Builder<DeleteClusterRequest, Operation> deleteClusterSettings() {
      return deleteClusterSettings;
    }

    /** Returns the builder for the settings used for calls to deleteCluster. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<DeleteClusterRequest, Empty, OperationMetadata>
        deleteClusterOperationSettings() {
      return deleteClusterOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listSubnets. */
    public PagedCallSettings.Builder<
            ListSubnetsRequest, ListSubnetsResponse, ListSubnetsPagedResponse>
        listSubnetsSettings() {
      return listSubnetsSettings;
    }

    /** Returns the builder for the settings used for calls to listNodeTypes. */
    public PagedCallSettings.Builder<
            ListNodeTypesRequest, ListNodeTypesResponse, ListNodeTypesPagedResponse>
        listNodeTypesSettings() {
      return listNodeTypesSettings;
    }

    /** Returns the builder for the settings used for calls to getNodeType. */
    public UnaryCallSettings.Builder<GetNodeTypeRequest, NodeType> getNodeTypeSettings() {
      return getNodeTypeSettings;
    }

    /** Returns the builder for the settings used for calls to showNsxCredentials. */
    public UnaryCallSettings.Builder<ShowNsxCredentialsRequest, Credentials>
        showNsxCredentialsSettings() {
      return showNsxCredentialsSettings;
    }

    /** Returns the builder for the settings used for calls to showVcenterCredentials. */
    public UnaryCallSettings.Builder<ShowVcenterCredentialsRequest, Credentials>
        showVcenterCredentialsSettings() {
      return showVcenterCredentialsSettings;
    }

    /** Returns the builder for the settings used for calls to resetNsxCredentials. */
    public UnaryCallSettings.Builder<ResetNsxCredentialsRequest, Operation>
        resetNsxCredentialsSettings() {
      return resetNsxCredentialsSettings;
    }

    /** Returns the builder for the settings used for calls to resetNsxCredentials. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            ResetNsxCredentialsRequest, PrivateCloud, OperationMetadata>
        resetNsxCredentialsOperationSettings() {
      return resetNsxCredentialsOperationSettings;
    }

    /** Returns the builder for the settings used for calls to resetVcenterCredentials. */
    public UnaryCallSettings.Builder<ResetVcenterCredentialsRequest, Operation>
        resetVcenterCredentialsSettings() {
      return resetVcenterCredentialsSettings;
    }

    /** Returns the builder for the settings used for calls to resetVcenterCredentials. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            ResetVcenterCredentialsRequest, PrivateCloud, OperationMetadata>
        resetVcenterCredentialsOperationSettings() {
      return resetVcenterCredentialsOperationSettings;
    }

    /** Returns the builder for the settings used for calls to createHcxActivationKey. */
    public UnaryCallSettings.Builder<CreateHcxActivationKeyRequest, Operation>
        createHcxActivationKeySettings() {
      return createHcxActivationKeySettings;
    }

    /** Returns the builder for the settings used for calls to createHcxActivationKey. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            CreateHcxActivationKeyRequest, HcxActivationKey, OperationMetadata>
        createHcxActivationKeyOperationSettings() {
      return createHcxActivationKeyOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listHcxActivationKeys. */
    public PagedCallSettings.Builder<
            ListHcxActivationKeysRequest,
            ListHcxActivationKeysResponse,
            ListHcxActivationKeysPagedResponse>
        listHcxActivationKeysSettings() {
      return listHcxActivationKeysSettings;
    }

    /** Returns the builder for the settings used for calls to getHcxActivationKey. */
    public UnaryCallSettings.Builder<GetHcxActivationKeyRequest, HcxActivationKey>
        getHcxActivationKeySettings() {
      return getHcxActivationKeySettings;
    }

    /** Returns the builder for the settings used for calls to getNetworkPolicy. */
    public UnaryCallSettings.Builder<GetNetworkPolicyRequest, NetworkPolicy>
        getNetworkPolicySettings() {
      return getNetworkPolicySettings;
    }

    /** Returns the builder for the settings used for calls to listNetworkPolicies. */
    public PagedCallSettings.Builder<
            ListNetworkPoliciesRequest,
            ListNetworkPoliciesResponse,
            ListNetworkPoliciesPagedResponse>
        listNetworkPoliciesSettings() {
      return listNetworkPoliciesSettings;
    }

    /** Returns the builder for the settings used for calls to createNetworkPolicy. */
    public UnaryCallSettings.Builder<CreateNetworkPolicyRequest, Operation>
        createNetworkPolicySettings() {
      return createNetworkPolicySettings;
    }

    /** Returns the builder for the settings used for calls to createNetworkPolicy. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            CreateNetworkPolicyRequest, NetworkPolicy, OperationMetadata>
        createNetworkPolicyOperationSettings() {
      return createNetworkPolicyOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateNetworkPolicy. */
    public UnaryCallSettings.Builder<UpdateNetworkPolicyRequest, Operation>
        updateNetworkPolicySettings() {
      return updateNetworkPolicySettings;
    }

    /** Returns the builder for the settings used for calls to updateNetworkPolicy. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            UpdateNetworkPolicyRequest, NetworkPolicy, OperationMetadata>
        updateNetworkPolicyOperationSettings() {
      return updateNetworkPolicyOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteNetworkPolicy. */
    public UnaryCallSettings.Builder<DeleteNetworkPolicyRequest, Operation>
        deleteNetworkPolicySettings() {
      return deleteNetworkPolicySettings;
    }

    /** Returns the builder for the settings used for calls to deleteNetworkPolicy. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<DeleteNetworkPolicyRequest, Empty, OperationMetadata>
        deleteNetworkPolicyOperationSettings() {
      return deleteNetworkPolicyOperationSettings;
    }

    /** Returns the builder for the settings used for calls to createVmwareEngineNetwork. */
    public UnaryCallSettings.Builder<CreateVmwareEngineNetworkRequest, Operation>
        createVmwareEngineNetworkSettings() {
      return createVmwareEngineNetworkSettings;
    }

    /** Returns the builder for the settings used for calls to createVmwareEngineNetwork. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            CreateVmwareEngineNetworkRequest, VmwareEngineNetwork, OperationMetadata>
        createVmwareEngineNetworkOperationSettings() {
      return createVmwareEngineNetworkOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateVmwareEngineNetwork. */
    public UnaryCallSettings.Builder<UpdateVmwareEngineNetworkRequest, Operation>
        updateVmwareEngineNetworkSettings() {
      return updateVmwareEngineNetworkSettings;
    }

    /** Returns the builder for the settings used for calls to updateVmwareEngineNetwork. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            UpdateVmwareEngineNetworkRequest, VmwareEngineNetwork, OperationMetadata>
        updateVmwareEngineNetworkOperationSettings() {
      return updateVmwareEngineNetworkOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteVmwareEngineNetwork. */
    public UnaryCallSettings.Builder<DeleteVmwareEngineNetworkRequest, Operation>
        deleteVmwareEngineNetworkSettings() {
      return deleteVmwareEngineNetworkSettings;
    }

    /** Returns the builder for the settings used for calls to deleteVmwareEngineNetwork. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<DeleteVmwareEngineNetworkRequest, Empty, OperationMetadata>
        deleteVmwareEngineNetworkOperationSettings() {
      return deleteVmwareEngineNetworkOperationSettings;
    }

    /** Returns the builder for the settings used for calls to getVmwareEngineNetwork. */
    public UnaryCallSettings.Builder<GetVmwareEngineNetworkRequest, VmwareEngineNetwork>
        getVmwareEngineNetworkSettings() {
      return getVmwareEngineNetworkSettings;
    }

    /** Returns the builder for the settings used for calls to listVmwareEngineNetworks. */
    public PagedCallSettings.Builder<
            ListVmwareEngineNetworksRequest,
            ListVmwareEngineNetworksResponse,
            ListVmwareEngineNetworksPagedResponse>
        listVmwareEngineNetworksSettings() {
      return listVmwareEngineNetworksSettings;
    }

    /** Returns the builder for the settings used for calls to listLocations. */
    public PagedCallSettings.Builder<
            ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
        listLocationsSettings() {
      return listLocationsSettings;
    }

    /** Returns the builder for the settings used for calls to getLocation. */
    public UnaryCallSettings.Builder<GetLocationRequest, Location> getLocationSettings() {
      return getLocationSettings;
    }

    /** Returns the builder for the settings used for calls to setIamPolicy. */
    public UnaryCallSettings.Builder<SetIamPolicyRequest, Policy> setIamPolicySettings() {
      return setIamPolicySettings;
    }

    /** Returns the builder for the settings used for calls to getIamPolicy. */
    public UnaryCallSettings.Builder<GetIamPolicyRequest, Policy> getIamPolicySettings() {
      return getIamPolicySettings;
    }

    /** Returns the builder for the settings used for calls to testIamPermissions. */
    public UnaryCallSettings.Builder<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsSettings() {
      return testIamPermissionsSettings;
    }

    @Override
    public VmwareEngineStubSettings build() throws IOException {
      return new VmwareEngineStubSettings(this);
    }
  }
}
