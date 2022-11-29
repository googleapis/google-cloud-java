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

package com.google.cloud.vmwareengine.v1;

import static com.google.cloud.vmwareengine.v1.VmwareEngineClient.ListClustersPagedResponse;
import static com.google.cloud.vmwareengine.v1.VmwareEngineClient.ListHcxActivationKeysPagedResponse;
import static com.google.cloud.vmwareengine.v1.VmwareEngineClient.ListLocationsPagedResponse;
import static com.google.cloud.vmwareengine.v1.VmwareEngineClient.ListNetworkPoliciesPagedResponse;
import static com.google.cloud.vmwareengine.v1.VmwareEngineClient.ListNodeTypesPagedResponse;
import static com.google.cloud.vmwareengine.v1.VmwareEngineClient.ListPrivateCloudsPagedResponse;
import static com.google.cloud.vmwareengine.v1.VmwareEngineClient.ListSubnetsPagedResponse;
import static com.google.cloud.vmwareengine.v1.VmwareEngineClient.ListVmwareEngineNetworksPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ClientSettings;
import com.google.api.gax.rpc.OperationCallSettings;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.cloud.vmwareengine.v1.stub.VmwareEngineStubSettings;
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

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link VmwareEngineClient}.
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
 * VmwareEngineSettings.Builder vmwareEngineSettingsBuilder = VmwareEngineSettings.newBuilder();
 * vmwareEngineSettingsBuilder
 *     .getPrivateCloudSettings()
 *     .setRetrySettings(
 *         vmwareEngineSettingsBuilder.getPrivateCloudSettings().getRetrySettings().toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * VmwareEngineSettings vmwareEngineSettings = vmwareEngineSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class VmwareEngineSettings extends ClientSettings<VmwareEngineSettings> {

  /** Returns the object with the settings used for calls to listPrivateClouds. */
  public PagedCallSettings<
          ListPrivateCloudsRequest, ListPrivateCloudsResponse, ListPrivateCloudsPagedResponse>
      listPrivateCloudsSettings() {
    return ((VmwareEngineStubSettings) getStubSettings()).listPrivateCloudsSettings();
  }

  /** Returns the object with the settings used for calls to getPrivateCloud. */
  public UnaryCallSettings<GetPrivateCloudRequest, PrivateCloud> getPrivateCloudSettings() {
    return ((VmwareEngineStubSettings) getStubSettings()).getPrivateCloudSettings();
  }

  /** Returns the object with the settings used for calls to createPrivateCloud. */
  public UnaryCallSettings<CreatePrivateCloudRequest, Operation> createPrivateCloudSettings() {
    return ((VmwareEngineStubSettings) getStubSettings()).createPrivateCloudSettings();
  }

  /** Returns the object with the settings used for calls to createPrivateCloud. */
  public OperationCallSettings<CreatePrivateCloudRequest, PrivateCloud, OperationMetadata>
      createPrivateCloudOperationSettings() {
    return ((VmwareEngineStubSettings) getStubSettings()).createPrivateCloudOperationSettings();
  }

  /** Returns the object with the settings used for calls to updatePrivateCloud. */
  public UnaryCallSettings<UpdatePrivateCloudRequest, Operation> updatePrivateCloudSettings() {
    return ((VmwareEngineStubSettings) getStubSettings()).updatePrivateCloudSettings();
  }

  /** Returns the object with the settings used for calls to updatePrivateCloud. */
  public OperationCallSettings<UpdatePrivateCloudRequest, PrivateCloud, OperationMetadata>
      updatePrivateCloudOperationSettings() {
    return ((VmwareEngineStubSettings) getStubSettings()).updatePrivateCloudOperationSettings();
  }

  /** Returns the object with the settings used for calls to deletePrivateCloud. */
  public UnaryCallSettings<DeletePrivateCloudRequest, Operation> deletePrivateCloudSettings() {
    return ((VmwareEngineStubSettings) getStubSettings()).deletePrivateCloudSettings();
  }

  /** Returns the object with the settings used for calls to deletePrivateCloud. */
  public OperationCallSettings<DeletePrivateCloudRequest, PrivateCloud, OperationMetadata>
      deletePrivateCloudOperationSettings() {
    return ((VmwareEngineStubSettings) getStubSettings()).deletePrivateCloudOperationSettings();
  }

  /** Returns the object with the settings used for calls to undeletePrivateCloud. */
  public UnaryCallSettings<UndeletePrivateCloudRequest, Operation> undeletePrivateCloudSettings() {
    return ((VmwareEngineStubSettings) getStubSettings()).undeletePrivateCloudSettings();
  }

  /** Returns the object with the settings used for calls to undeletePrivateCloud. */
  public OperationCallSettings<UndeletePrivateCloudRequest, PrivateCloud, OperationMetadata>
      undeletePrivateCloudOperationSettings() {
    return ((VmwareEngineStubSettings) getStubSettings()).undeletePrivateCloudOperationSettings();
  }

  /** Returns the object with the settings used for calls to listClusters. */
  public PagedCallSettings<ListClustersRequest, ListClustersResponse, ListClustersPagedResponse>
      listClustersSettings() {
    return ((VmwareEngineStubSettings) getStubSettings()).listClustersSettings();
  }

  /** Returns the object with the settings used for calls to getCluster. */
  public UnaryCallSettings<GetClusterRequest, Cluster> getClusterSettings() {
    return ((VmwareEngineStubSettings) getStubSettings()).getClusterSettings();
  }

  /** Returns the object with the settings used for calls to createCluster. */
  public UnaryCallSettings<CreateClusterRequest, Operation> createClusterSettings() {
    return ((VmwareEngineStubSettings) getStubSettings()).createClusterSettings();
  }

  /** Returns the object with the settings used for calls to createCluster. */
  public OperationCallSettings<CreateClusterRequest, Cluster, OperationMetadata>
      createClusterOperationSettings() {
    return ((VmwareEngineStubSettings) getStubSettings()).createClusterOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateCluster. */
  public UnaryCallSettings<UpdateClusterRequest, Operation> updateClusterSettings() {
    return ((VmwareEngineStubSettings) getStubSettings()).updateClusterSettings();
  }

  /** Returns the object with the settings used for calls to updateCluster. */
  public OperationCallSettings<UpdateClusterRequest, Cluster, OperationMetadata>
      updateClusterOperationSettings() {
    return ((VmwareEngineStubSettings) getStubSettings()).updateClusterOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteCluster. */
  public UnaryCallSettings<DeleteClusterRequest, Operation> deleteClusterSettings() {
    return ((VmwareEngineStubSettings) getStubSettings()).deleteClusterSettings();
  }

  /** Returns the object with the settings used for calls to deleteCluster. */
  public OperationCallSettings<DeleteClusterRequest, Empty, OperationMetadata>
      deleteClusterOperationSettings() {
    return ((VmwareEngineStubSettings) getStubSettings()).deleteClusterOperationSettings();
  }

  /** Returns the object with the settings used for calls to listSubnets. */
  public PagedCallSettings<ListSubnetsRequest, ListSubnetsResponse, ListSubnetsPagedResponse>
      listSubnetsSettings() {
    return ((VmwareEngineStubSettings) getStubSettings()).listSubnetsSettings();
  }

  /** Returns the object with the settings used for calls to listNodeTypes. */
  public PagedCallSettings<ListNodeTypesRequest, ListNodeTypesResponse, ListNodeTypesPagedResponse>
      listNodeTypesSettings() {
    return ((VmwareEngineStubSettings) getStubSettings()).listNodeTypesSettings();
  }

  /** Returns the object with the settings used for calls to getNodeType. */
  public UnaryCallSettings<GetNodeTypeRequest, NodeType> getNodeTypeSettings() {
    return ((VmwareEngineStubSettings) getStubSettings()).getNodeTypeSettings();
  }

  /** Returns the object with the settings used for calls to showNsxCredentials. */
  public UnaryCallSettings<ShowNsxCredentialsRequest, Credentials> showNsxCredentialsSettings() {
    return ((VmwareEngineStubSettings) getStubSettings()).showNsxCredentialsSettings();
  }

  /** Returns the object with the settings used for calls to showVcenterCredentials. */
  public UnaryCallSettings<ShowVcenterCredentialsRequest, Credentials>
      showVcenterCredentialsSettings() {
    return ((VmwareEngineStubSettings) getStubSettings()).showVcenterCredentialsSettings();
  }

  /** Returns the object with the settings used for calls to resetNsxCredentials. */
  public UnaryCallSettings<ResetNsxCredentialsRequest, Operation> resetNsxCredentialsSettings() {
    return ((VmwareEngineStubSettings) getStubSettings()).resetNsxCredentialsSettings();
  }

  /** Returns the object with the settings used for calls to resetNsxCredentials. */
  public OperationCallSettings<ResetNsxCredentialsRequest, PrivateCloud, OperationMetadata>
      resetNsxCredentialsOperationSettings() {
    return ((VmwareEngineStubSettings) getStubSettings()).resetNsxCredentialsOperationSettings();
  }

  /** Returns the object with the settings used for calls to resetVcenterCredentials. */
  public UnaryCallSettings<ResetVcenterCredentialsRequest, Operation>
      resetVcenterCredentialsSettings() {
    return ((VmwareEngineStubSettings) getStubSettings()).resetVcenterCredentialsSettings();
  }

  /** Returns the object with the settings used for calls to resetVcenterCredentials. */
  public OperationCallSettings<ResetVcenterCredentialsRequest, PrivateCloud, OperationMetadata>
      resetVcenterCredentialsOperationSettings() {
    return ((VmwareEngineStubSettings) getStubSettings())
        .resetVcenterCredentialsOperationSettings();
  }

  /** Returns the object with the settings used for calls to createHcxActivationKey. */
  public UnaryCallSettings<CreateHcxActivationKeyRequest, Operation>
      createHcxActivationKeySettings() {
    return ((VmwareEngineStubSettings) getStubSettings()).createHcxActivationKeySettings();
  }

  /** Returns the object with the settings used for calls to createHcxActivationKey. */
  public OperationCallSettings<CreateHcxActivationKeyRequest, HcxActivationKey, OperationMetadata>
      createHcxActivationKeyOperationSettings() {
    return ((VmwareEngineStubSettings) getStubSettings()).createHcxActivationKeyOperationSettings();
  }

  /** Returns the object with the settings used for calls to listHcxActivationKeys. */
  public PagedCallSettings<
          ListHcxActivationKeysRequest,
          ListHcxActivationKeysResponse,
          ListHcxActivationKeysPagedResponse>
      listHcxActivationKeysSettings() {
    return ((VmwareEngineStubSettings) getStubSettings()).listHcxActivationKeysSettings();
  }

  /** Returns the object with the settings used for calls to getHcxActivationKey. */
  public UnaryCallSettings<GetHcxActivationKeyRequest, HcxActivationKey>
      getHcxActivationKeySettings() {
    return ((VmwareEngineStubSettings) getStubSettings()).getHcxActivationKeySettings();
  }

  /** Returns the object with the settings used for calls to getNetworkPolicy. */
  public UnaryCallSettings<GetNetworkPolicyRequest, NetworkPolicy> getNetworkPolicySettings() {
    return ((VmwareEngineStubSettings) getStubSettings()).getNetworkPolicySettings();
  }

  /** Returns the object with the settings used for calls to listNetworkPolicies. */
  public PagedCallSettings<
          ListNetworkPoliciesRequest, ListNetworkPoliciesResponse, ListNetworkPoliciesPagedResponse>
      listNetworkPoliciesSettings() {
    return ((VmwareEngineStubSettings) getStubSettings()).listNetworkPoliciesSettings();
  }

  /** Returns the object with the settings used for calls to createNetworkPolicy. */
  public UnaryCallSettings<CreateNetworkPolicyRequest, Operation> createNetworkPolicySettings() {
    return ((VmwareEngineStubSettings) getStubSettings()).createNetworkPolicySettings();
  }

  /** Returns the object with the settings used for calls to createNetworkPolicy. */
  public OperationCallSettings<CreateNetworkPolicyRequest, NetworkPolicy, OperationMetadata>
      createNetworkPolicyOperationSettings() {
    return ((VmwareEngineStubSettings) getStubSettings()).createNetworkPolicyOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateNetworkPolicy. */
  public UnaryCallSettings<UpdateNetworkPolicyRequest, Operation> updateNetworkPolicySettings() {
    return ((VmwareEngineStubSettings) getStubSettings()).updateNetworkPolicySettings();
  }

  /** Returns the object with the settings used for calls to updateNetworkPolicy. */
  public OperationCallSettings<UpdateNetworkPolicyRequest, NetworkPolicy, OperationMetadata>
      updateNetworkPolicyOperationSettings() {
    return ((VmwareEngineStubSettings) getStubSettings()).updateNetworkPolicyOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteNetworkPolicy. */
  public UnaryCallSettings<DeleteNetworkPolicyRequest, Operation> deleteNetworkPolicySettings() {
    return ((VmwareEngineStubSettings) getStubSettings()).deleteNetworkPolicySettings();
  }

  /** Returns the object with the settings used for calls to deleteNetworkPolicy. */
  public OperationCallSettings<DeleteNetworkPolicyRequest, Empty, OperationMetadata>
      deleteNetworkPolicyOperationSettings() {
    return ((VmwareEngineStubSettings) getStubSettings()).deleteNetworkPolicyOperationSettings();
  }

  /** Returns the object with the settings used for calls to createVmwareEngineNetwork. */
  public UnaryCallSettings<CreateVmwareEngineNetworkRequest, Operation>
      createVmwareEngineNetworkSettings() {
    return ((VmwareEngineStubSettings) getStubSettings()).createVmwareEngineNetworkSettings();
  }

  /** Returns the object with the settings used for calls to createVmwareEngineNetwork. */
  public OperationCallSettings<
          CreateVmwareEngineNetworkRequest, VmwareEngineNetwork, OperationMetadata>
      createVmwareEngineNetworkOperationSettings() {
    return ((VmwareEngineStubSettings) getStubSettings())
        .createVmwareEngineNetworkOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateVmwareEngineNetwork. */
  public UnaryCallSettings<UpdateVmwareEngineNetworkRequest, Operation>
      updateVmwareEngineNetworkSettings() {
    return ((VmwareEngineStubSettings) getStubSettings()).updateVmwareEngineNetworkSettings();
  }

  /** Returns the object with the settings used for calls to updateVmwareEngineNetwork. */
  public OperationCallSettings<
          UpdateVmwareEngineNetworkRequest, VmwareEngineNetwork, OperationMetadata>
      updateVmwareEngineNetworkOperationSettings() {
    return ((VmwareEngineStubSettings) getStubSettings())
        .updateVmwareEngineNetworkOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteVmwareEngineNetwork. */
  public UnaryCallSettings<DeleteVmwareEngineNetworkRequest, Operation>
      deleteVmwareEngineNetworkSettings() {
    return ((VmwareEngineStubSettings) getStubSettings()).deleteVmwareEngineNetworkSettings();
  }

  /** Returns the object with the settings used for calls to deleteVmwareEngineNetwork. */
  public OperationCallSettings<DeleteVmwareEngineNetworkRequest, Empty, OperationMetadata>
      deleteVmwareEngineNetworkOperationSettings() {
    return ((VmwareEngineStubSettings) getStubSettings())
        .deleteVmwareEngineNetworkOperationSettings();
  }

  /** Returns the object with the settings used for calls to getVmwareEngineNetwork. */
  public UnaryCallSettings<GetVmwareEngineNetworkRequest, VmwareEngineNetwork>
      getVmwareEngineNetworkSettings() {
    return ((VmwareEngineStubSettings) getStubSettings()).getVmwareEngineNetworkSettings();
  }

  /** Returns the object with the settings used for calls to listVmwareEngineNetworks. */
  public PagedCallSettings<
          ListVmwareEngineNetworksRequest,
          ListVmwareEngineNetworksResponse,
          ListVmwareEngineNetworksPagedResponse>
      listVmwareEngineNetworksSettings() {
    return ((VmwareEngineStubSettings) getStubSettings()).listVmwareEngineNetworksSettings();
  }

  /** Returns the object with the settings used for calls to listLocations. */
  public PagedCallSettings<ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings() {
    return ((VmwareEngineStubSettings) getStubSettings()).listLocationsSettings();
  }

  /** Returns the object with the settings used for calls to getLocation. */
  public UnaryCallSettings<GetLocationRequest, Location> getLocationSettings() {
    return ((VmwareEngineStubSettings) getStubSettings()).getLocationSettings();
  }

  /** Returns the object with the settings used for calls to setIamPolicy. */
  public UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings() {
    return ((VmwareEngineStubSettings) getStubSettings()).setIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to getIamPolicy. */
  public UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings() {
    return ((VmwareEngineStubSettings) getStubSettings()).getIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to testIamPermissions. */
  public UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings() {
    return ((VmwareEngineStubSettings) getStubSettings()).testIamPermissionsSettings();
  }

  public static final VmwareEngineSettings create(VmwareEngineStubSettings stub)
      throws IOException {
    return new VmwareEngineSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return VmwareEngineStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return VmwareEngineStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return VmwareEngineStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return VmwareEngineStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return VmwareEngineStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return VmwareEngineStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return VmwareEngineStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return VmwareEngineStubSettings.defaultApiClientHeaderProviderBuilder();
  }

  /** Returns a new gRPC builder for this class. */
  public static Builder newBuilder() {
    return Builder.createDefault();
  }

  /** Returns a new REST builder for this class. */
  @BetaApi
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

  protected VmwareEngineSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for VmwareEngineSettings. */
  public static class Builder extends ClientSettings.Builder<VmwareEngineSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(VmwareEngineStubSettings.newBuilder(clientContext));
    }

    protected Builder(VmwareEngineSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(VmwareEngineStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(VmwareEngineStubSettings.newBuilder());
    }

    @BetaApi
    private static Builder createHttpJsonDefault() {
      return new Builder(VmwareEngineStubSettings.newHttpJsonBuilder());
    }

    public VmwareEngineStubSettings.Builder getStubSettingsBuilder() {
      return ((VmwareEngineStubSettings.Builder) getStubSettings());
    }

    /**
     * Applies the given settings updater function to all of the unary API methods in this service.
     *
     * <p>Note: This method does not support applying settings to streaming methods.
     */
    public Builder applyToAllUnaryMethods(
        ApiFunction<UnaryCallSettings.Builder<?, ?>, Void> settingsUpdater) {
      super.applyToAllUnaryMethods(
          getStubSettingsBuilder().unaryMethodSettingsBuilders(), settingsUpdater);
      return this;
    }

    /** Returns the builder for the settings used for calls to listPrivateClouds. */
    public PagedCallSettings.Builder<
            ListPrivateCloudsRequest, ListPrivateCloudsResponse, ListPrivateCloudsPagedResponse>
        listPrivateCloudsSettings() {
      return getStubSettingsBuilder().listPrivateCloudsSettings();
    }

    /** Returns the builder for the settings used for calls to getPrivateCloud. */
    public UnaryCallSettings.Builder<GetPrivateCloudRequest, PrivateCloud>
        getPrivateCloudSettings() {
      return getStubSettingsBuilder().getPrivateCloudSettings();
    }

    /** Returns the builder for the settings used for calls to createPrivateCloud. */
    public UnaryCallSettings.Builder<CreatePrivateCloudRequest, Operation>
        createPrivateCloudSettings() {
      return getStubSettingsBuilder().createPrivateCloudSettings();
    }

    /** Returns the builder for the settings used for calls to createPrivateCloud. */
    public OperationCallSettings.Builder<CreatePrivateCloudRequest, PrivateCloud, OperationMetadata>
        createPrivateCloudOperationSettings() {
      return getStubSettingsBuilder().createPrivateCloudOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updatePrivateCloud. */
    public UnaryCallSettings.Builder<UpdatePrivateCloudRequest, Operation>
        updatePrivateCloudSettings() {
      return getStubSettingsBuilder().updatePrivateCloudSettings();
    }

    /** Returns the builder for the settings used for calls to updatePrivateCloud. */
    public OperationCallSettings.Builder<UpdatePrivateCloudRequest, PrivateCloud, OperationMetadata>
        updatePrivateCloudOperationSettings() {
      return getStubSettingsBuilder().updatePrivateCloudOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deletePrivateCloud. */
    public UnaryCallSettings.Builder<DeletePrivateCloudRequest, Operation>
        deletePrivateCloudSettings() {
      return getStubSettingsBuilder().deletePrivateCloudSettings();
    }

    /** Returns the builder for the settings used for calls to deletePrivateCloud. */
    public OperationCallSettings.Builder<DeletePrivateCloudRequest, PrivateCloud, OperationMetadata>
        deletePrivateCloudOperationSettings() {
      return getStubSettingsBuilder().deletePrivateCloudOperationSettings();
    }

    /** Returns the builder for the settings used for calls to undeletePrivateCloud. */
    public UnaryCallSettings.Builder<UndeletePrivateCloudRequest, Operation>
        undeletePrivateCloudSettings() {
      return getStubSettingsBuilder().undeletePrivateCloudSettings();
    }

    /** Returns the builder for the settings used for calls to undeletePrivateCloud. */
    public OperationCallSettings.Builder<
            UndeletePrivateCloudRequest, PrivateCloud, OperationMetadata>
        undeletePrivateCloudOperationSettings() {
      return getStubSettingsBuilder().undeletePrivateCloudOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listClusters. */
    public PagedCallSettings.Builder<
            ListClustersRequest, ListClustersResponse, ListClustersPagedResponse>
        listClustersSettings() {
      return getStubSettingsBuilder().listClustersSettings();
    }

    /** Returns the builder for the settings used for calls to getCluster. */
    public UnaryCallSettings.Builder<GetClusterRequest, Cluster> getClusterSettings() {
      return getStubSettingsBuilder().getClusterSettings();
    }

    /** Returns the builder for the settings used for calls to createCluster. */
    public UnaryCallSettings.Builder<CreateClusterRequest, Operation> createClusterSettings() {
      return getStubSettingsBuilder().createClusterSettings();
    }

    /** Returns the builder for the settings used for calls to createCluster. */
    public OperationCallSettings.Builder<CreateClusterRequest, Cluster, OperationMetadata>
        createClusterOperationSettings() {
      return getStubSettingsBuilder().createClusterOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateCluster. */
    public UnaryCallSettings.Builder<UpdateClusterRequest, Operation> updateClusterSettings() {
      return getStubSettingsBuilder().updateClusterSettings();
    }

    /** Returns the builder for the settings used for calls to updateCluster. */
    public OperationCallSettings.Builder<UpdateClusterRequest, Cluster, OperationMetadata>
        updateClusterOperationSettings() {
      return getStubSettingsBuilder().updateClusterOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteCluster. */
    public UnaryCallSettings.Builder<DeleteClusterRequest, Operation> deleteClusterSettings() {
      return getStubSettingsBuilder().deleteClusterSettings();
    }

    /** Returns the builder for the settings used for calls to deleteCluster. */
    public OperationCallSettings.Builder<DeleteClusterRequest, Empty, OperationMetadata>
        deleteClusterOperationSettings() {
      return getStubSettingsBuilder().deleteClusterOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listSubnets. */
    public PagedCallSettings.Builder<
            ListSubnetsRequest, ListSubnetsResponse, ListSubnetsPagedResponse>
        listSubnetsSettings() {
      return getStubSettingsBuilder().listSubnetsSettings();
    }

    /** Returns the builder for the settings used for calls to listNodeTypes. */
    public PagedCallSettings.Builder<
            ListNodeTypesRequest, ListNodeTypesResponse, ListNodeTypesPagedResponse>
        listNodeTypesSettings() {
      return getStubSettingsBuilder().listNodeTypesSettings();
    }

    /** Returns the builder for the settings used for calls to getNodeType. */
    public UnaryCallSettings.Builder<GetNodeTypeRequest, NodeType> getNodeTypeSettings() {
      return getStubSettingsBuilder().getNodeTypeSettings();
    }

    /** Returns the builder for the settings used for calls to showNsxCredentials. */
    public UnaryCallSettings.Builder<ShowNsxCredentialsRequest, Credentials>
        showNsxCredentialsSettings() {
      return getStubSettingsBuilder().showNsxCredentialsSettings();
    }

    /** Returns the builder for the settings used for calls to showVcenterCredentials. */
    public UnaryCallSettings.Builder<ShowVcenterCredentialsRequest, Credentials>
        showVcenterCredentialsSettings() {
      return getStubSettingsBuilder().showVcenterCredentialsSettings();
    }

    /** Returns the builder for the settings used for calls to resetNsxCredentials. */
    public UnaryCallSettings.Builder<ResetNsxCredentialsRequest, Operation>
        resetNsxCredentialsSettings() {
      return getStubSettingsBuilder().resetNsxCredentialsSettings();
    }

    /** Returns the builder for the settings used for calls to resetNsxCredentials. */
    public OperationCallSettings.Builder<
            ResetNsxCredentialsRequest, PrivateCloud, OperationMetadata>
        resetNsxCredentialsOperationSettings() {
      return getStubSettingsBuilder().resetNsxCredentialsOperationSettings();
    }

    /** Returns the builder for the settings used for calls to resetVcenterCredentials. */
    public UnaryCallSettings.Builder<ResetVcenterCredentialsRequest, Operation>
        resetVcenterCredentialsSettings() {
      return getStubSettingsBuilder().resetVcenterCredentialsSettings();
    }

    /** Returns the builder for the settings used for calls to resetVcenterCredentials. */
    public OperationCallSettings.Builder<
            ResetVcenterCredentialsRequest, PrivateCloud, OperationMetadata>
        resetVcenterCredentialsOperationSettings() {
      return getStubSettingsBuilder().resetVcenterCredentialsOperationSettings();
    }

    /** Returns the builder for the settings used for calls to createHcxActivationKey. */
    public UnaryCallSettings.Builder<CreateHcxActivationKeyRequest, Operation>
        createHcxActivationKeySettings() {
      return getStubSettingsBuilder().createHcxActivationKeySettings();
    }

    /** Returns the builder for the settings used for calls to createHcxActivationKey. */
    public OperationCallSettings.Builder<
            CreateHcxActivationKeyRequest, HcxActivationKey, OperationMetadata>
        createHcxActivationKeyOperationSettings() {
      return getStubSettingsBuilder().createHcxActivationKeyOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listHcxActivationKeys. */
    public PagedCallSettings.Builder<
            ListHcxActivationKeysRequest,
            ListHcxActivationKeysResponse,
            ListHcxActivationKeysPagedResponse>
        listHcxActivationKeysSettings() {
      return getStubSettingsBuilder().listHcxActivationKeysSettings();
    }

    /** Returns the builder for the settings used for calls to getHcxActivationKey. */
    public UnaryCallSettings.Builder<GetHcxActivationKeyRequest, HcxActivationKey>
        getHcxActivationKeySettings() {
      return getStubSettingsBuilder().getHcxActivationKeySettings();
    }

    /** Returns the builder for the settings used for calls to getNetworkPolicy. */
    public UnaryCallSettings.Builder<GetNetworkPolicyRequest, NetworkPolicy>
        getNetworkPolicySettings() {
      return getStubSettingsBuilder().getNetworkPolicySettings();
    }

    /** Returns the builder for the settings used for calls to listNetworkPolicies. */
    public PagedCallSettings.Builder<
            ListNetworkPoliciesRequest,
            ListNetworkPoliciesResponse,
            ListNetworkPoliciesPagedResponse>
        listNetworkPoliciesSettings() {
      return getStubSettingsBuilder().listNetworkPoliciesSettings();
    }

    /** Returns the builder for the settings used for calls to createNetworkPolicy. */
    public UnaryCallSettings.Builder<CreateNetworkPolicyRequest, Operation>
        createNetworkPolicySettings() {
      return getStubSettingsBuilder().createNetworkPolicySettings();
    }

    /** Returns the builder for the settings used for calls to createNetworkPolicy. */
    public OperationCallSettings.Builder<
            CreateNetworkPolicyRequest, NetworkPolicy, OperationMetadata>
        createNetworkPolicyOperationSettings() {
      return getStubSettingsBuilder().createNetworkPolicyOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateNetworkPolicy. */
    public UnaryCallSettings.Builder<UpdateNetworkPolicyRequest, Operation>
        updateNetworkPolicySettings() {
      return getStubSettingsBuilder().updateNetworkPolicySettings();
    }

    /** Returns the builder for the settings used for calls to updateNetworkPolicy. */
    public OperationCallSettings.Builder<
            UpdateNetworkPolicyRequest, NetworkPolicy, OperationMetadata>
        updateNetworkPolicyOperationSettings() {
      return getStubSettingsBuilder().updateNetworkPolicyOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteNetworkPolicy. */
    public UnaryCallSettings.Builder<DeleteNetworkPolicyRequest, Operation>
        deleteNetworkPolicySettings() {
      return getStubSettingsBuilder().deleteNetworkPolicySettings();
    }

    /** Returns the builder for the settings used for calls to deleteNetworkPolicy. */
    public OperationCallSettings.Builder<DeleteNetworkPolicyRequest, Empty, OperationMetadata>
        deleteNetworkPolicyOperationSettings() {
      return getStubSettingsBuilder().deleteNetworkPolicyOperationSettings();
    }

    /** Returns the builder for the settings used for calls to createVmwareEngineNetwork. */
    public UnaryCallSettings.Builder<CreateVmwareEngineNetworkRequest, Operation>
        createVmwareEngineNetworkSettings() {
      return getStubSettingsBuilder().createVmwareEngineNetworkSettings();
    }

    /** Returns the builder for the settings used for calls to createVmwareEngineNetwork. */
    public OperationCallSettings.Builder<
            CreateVmwareEngineNetworkRequest, VmwareEngineNetwork, OperationMetadata>
        createVmwareEngineNetworkOperationSettings() {
      return getStubSettingsBuilder().createVmwareEngineNetworkOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateVmwareEngineNetwork. */
    public UnaryCallSettings.Builder<UpdateVmwareEngineNetworkRequest, Operation>
        updateVmwareEngineNetworkSettings() {
      return getStubSettingsBuilder().updateVmwareEngineNetworkSettings();
    }

    /** Returns the builder for the settings used for calls to updateVmwareEngineNetwork. */
    public OperationCallSettings.Builder<
            UpdateVmwareEngineNetworkRequest, VmwareEngineNetwork, OperationMetadata>
        updateVmwareEngineNetworkOperationSettings() {
      return getStubSettingsBuilder().updateVmwareEngineNetworkOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteVmwareEngineNetwork. */
    public UnaryCallSettings.Builder<DeleteVmwareEngineNetworkRequest, Operation>
        deleteVmwareEngineNetworkSettings() {
      return getStubSettingsBuilder().deleteVmwareEngineNetworkSettings();
    }

    /** Returns the builder for the settings used for calls to deleteVmwareEngineNetwork. */
    public OperationCallSettings.Builder<DeleteVmwareEngineNetworkRequest, Empty, OperationMetadata>
        deleteVmwareEngineNetworkOperationSettings() {
      return getStubSettingsBuilder().deleteVmwareEngineNetworkOperationSettings();
    }

    /** Returns the builder for the settings used for calls to getVmwareEngineNetwork. */
    public UnaryCallSettings.Builder<GetVmwareEngineNetworkRequest, VmwareEngineNetwork>
        getVmwareEngineNetworkSettings() {
      return getStubSettingsBuilder().getVmwareEngineNetworkSettings();
    }

    /** Returns the builder for the settings used for calls to listVmwareEngineNetworks. */
    public PagedCallSettings.Builder<
            ListVmwareEngineNetworksRequest,
            ListVmwareEngineNetworksResponse,
            ListVmwareEngineNetworksPagedResponse>
        listVmwareEngineNetworksSettings() {
      return getStubSettingsBuilder().listVmwareEngineNetworksSettings();
    }

    /** Returns the builder for the settings used for calls to listLocations. */
    public PagedCallSettings.Builder<
            ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
        listLocationsSettings() {
      return getStubSettingsBuilder().listLocationsSettings();
    }

    /** Returns the builder for the settings used for calls to getLocation. */
    public UnaryCallSettings.Builder<GetLocationRequest, Location> getLocationSettings() {
      return getStubSettingsBuilder().getLocationSettings();
    }

    /** Returns the builder for the settings used for calls to setIamPolicy. */
    public UnaryCallSettings.Builder<SetIamPolicyRequest, Policy> setIamPolicySettings() {
      return getStubSettingsBuilder().setIamPolicySettings();
    }

    /** Returns the builder for the settings used for calls to getIamPolicy. */
    public UnaryCallSettings.Builder<GetIamPolicyRequest, Policy> getIamPolicySettings() {
      return getStubSettingsBuilder().getIamPolicySettings();
    }

    /** Returns the builder for the settings used for calls to testIamPermissions. */
    public UnaryCallSettings.Builder<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsSettings() {
      return getStubSettingsBuilder().testIamPermissionsSettings();
    }

    @Override
    public VmwareEngineSettings build() throws IOException {
      return new VmwareEngineSettings(this);
    }
  }
}
