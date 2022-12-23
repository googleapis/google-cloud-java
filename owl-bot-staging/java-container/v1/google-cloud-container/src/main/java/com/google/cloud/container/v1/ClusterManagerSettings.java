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

package com.google.cloud.container.v1;

import static com.google.cloud.container.v1.ClusterManagerClient.ListUsableSubnetworksPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ClientSettings;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.StubSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.container.v1.stub.ClusterManagerStubSettings;
import com.google.container.v1.CancelOperationRequest;
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
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link ClusterManagerClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (container.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of listClusters to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * ClusterManagerSettings.Builder clusterManagerSettingsBuilder =
 *     ClusterManagerSettings.newBuilder();
 * clusterManagerSettingsBuilder
 *     .listClustersSettings()
 *     .setRetrySettings(
 *         clusterManagerSettingsBuilder.listClustersSettings().getRetrySettings().toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * ClusterManagerSettings clusterManagerSettings = clusterManagerSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class ClusterManagerSettings extends ClientSettings<ClusterManagerSettings> {

  /** Returns the object with the settings used for calls to listClusters. */
  public UnaryCallSettings<ListClustersRequest, ListClustersResponse> listClustersSettings() {
    return ((ClusterManagerStubSettings) getStubSettings()).listClustersSettings();
  }

  /** Returns the object with the settings used for calls to getCluster. */
  public UnaryCallSettings<GetClusterRequest, Cluster> getClusterSettings() {
    return ((ClusterManagerStubSettings) getStubSettings()).getClusterSettings();
  }

  /** Returns the object with the settings used for calls to createCluster. */
  public UnaryCallSettings<CreateClusterRequest, Operation> createClusterSettings() {
    return ((ClusterManagerStubSettings) getStubSettings()).createClusterSettings();
  }

  /** Returns the object with the settings used for calls to updateCluster. */
  public UnaryCallSettings<UpdateClusterRequest, Operation> updateClusterSettings() {
    return ((ClusterManagerStubSettings) getStubSettings()).updateClusterSettings();
  }

  /** Returns the object with the settings used for calls to updateNodePool. */
  public UnaryCallSettings<UpdateNodePoolRequest, Operation> updateNodePoolSettings() {
    return ((ClusterManagerStubSettings) getStubSettings()).updateNodePoolSettings();
  }

  /** Returns the object with the settings used for calls to setNodePoolAutoscaling. */
  public UnaryCallSettings<SetNodePoolAutoscalingRequest, Operation>
      setNodePoolAutoscalingSettings() {
    return ((ClusterManagerStubSettings) getStubSettings()).setNodePoolAutoscalingSettings();
  }

  /** Returns the object with the settings used for calls to setLoggingService. */
  public UnaryCallSettings<SetLoggingServiceRequest, Operation> setLoggingServiceSettings() {
    return ((ClusterManagerStubSettings) getStubSettings()).setLoggingServiceSettings();
  }

  /** Returns the object with the settings used for calls to setMonitoringService. */
  public UnaryCallSettings<SetMonitoringServiceRequest, Operation> setMonitoringServiceSettings() {
    return ((ClusterManagerStubSettings) getStubSettings()).setMonitoringServiceSettings();
  }

  /** Returns the object with the settings used for calls to setAddonsConfig. */
  public UnaryCallSettings<SetAddonsConfigRequest, Operation> setAddonsConfigSettings() {
    return ((ClusterManagerStubSettings) getStubSettings()).setAddonsConfigSettings();
  }

  /**
   * Returns the object with the settings used for calls to setLocations.
   *
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public UnaryCallSettings<SetLocationsRequest, Operation> setLocationsSettings() {
    return ((ClusterManagerStubSettings) getStubSettings()).setLocationsSettings();
  }

  /** Returns the object with the settings used for calls to updateMaster. */
  public UnaryCallSettings<UpdateMasterRequest, Operation> updateMasterSettings() {
    return ((ClusterManagerStubSettings) getStubSettings()).updateMasterSettings();
  }

  /** Returns the object with the settings used for calls to setMasterAuth. */
  public UnaryCallSettings<SetMasterAuthRequest, Operation> setMasterAuthSettings() {
    return ((ClusterManagerStubSettings) getStubSettings()).setMasterAuthSettings();
  }

  /** Returns the object with the settings used for calls to deleteCluster. */
  public UnaryCallSettings<DeleteClusterRequest, Operation> deleteClusterSettings() {
    return ((ClusterManagerStubSettings) getStubSettings()).deleteClusterSettings();
  }

  /** Returns the object with the settings used for calls to listOperations. */
  public UnaryCallSettings<ListOperationsRequest, ListOperationsResponse> listOperationsSettings() {
    return ((ClusterManagerStubSettings) getStubSettings()).listOperationsSettings();
  }

  /** Returns the object with the settings used for calls to get. */
  public UnaryCallSettings<GetOperationRequest, Operation> getOperationSettings() {
    return ((ClusterManagerStubSettings) getStubSettings()).getOperationSettings();
  }

  /** Returns the object with the settings used for calls to cancel. */
  public UnaryCallSettings<CancelOperationRequest, Empty> cancelOperationSettings() {
    return ((ClusterManagerStubSettings) getStubSettings()).cancelOperationSettings();
  }

  /** Returns the object with the settings used for calls to getServerConfig. */
  public UnaryCallSettings<GetServerConfigRequest, ServerConfig> getServerConfigSettings() {
    return ((ClusterManagerStubSettings) getStubSettings()).getServerConfigSettings();
  }

  /** Returns the object with the settings used for calls to getJSONWebKeys. */
  public UnaryCallSettings<GetJSONWebKeysRequest, GetJSONWebKeysResponse> getJSONWebKeysSettings() {
    return ((ClusterManagerStubSettings) getStubSettings()).getJSONWebKeysSettings();
  }

  /** Returns the object with the settings used for calls to listNodePools. */
  public UnaryCallSettings<ListNodePoolsRequest, ListNodePoolsResponse> listNodePoolsSettings() {
    return ((ClusterManagerStubSettings) getStubSettings()).listNodePoolsSettings();
  }

  /** Returns the object with the settings used for calls to getNodePool. */
  public UnaryCallSettings<GetNodePoolRequest, NodePool> getNodePoolSettings() {
    return ((ClusterManagerStubSettings) getStubSettings()).getNodePoolSettings();
  }

  /** Returns the object with the settings used for calls to createNodePool. */
  public UnaryCallSettings<CreateNodePoolRequest, Operation> createNodePoolSettings() {
    return ((ClusterManagerStubSettings) getStubSettings()).createNodePoolSettings();
  }

  /** Returns the object with the settings used for calls to deleteNodePool. */
  public UnaryCallSettings<DeleteNodePoolRequest, Operation> deleteNodePoolSettings() {
    return ((ClusterManagerStubSettings) getStubSettings()).deleteNodePoolSettings();
  }

  /** Returns the object with the settings used for calls to completeNodePoolUpgrade. */
  public UnaryCallSettings<CompleteNodePoolUpgradeRequest, Empty>
      completeNodePoolUpgradeSettings() {
    return ((ClusterManagerStubSettings) getStubSettings()).completeNodePoolUpgradeSettings();
  }

  /** Returns the object with the settings used for calls to rollbackNodePoolUpgrade. */
  public UnaryCallSettings<RollbackNodePoolUpgradeRequest, Operation>
      rollbackNodePoolUpgradeSettings() {
    return ((ClusterManagerStubSettings) getStubSettings()).rollbackNodePoolUpgradeSettings();
  }

  /** Returns the object with the settings used for calls to setNodePoolManagement. */
  public UnaryCallSettings<SetNodePoolManagementRequest, Operation>
      setNodePoolManagementSettings() {
    return ((ClusterManagerStubSettings) getStubSettings()).setNodePoolManagementSettings();
  }

  /** Returns the object with the settings used for calls to setLabels. */
  public UnaryCallSettings<SetLabelsRequest, Operation> setLabelsSettings() {
    return ((ClusterManagerStubSettings) getStubSettings()).setLabelsSettings();
  }

  /** Returns the object with the settings used for calls to setLegacyAbac. */
  public UnaryCallSettings<SetLegacyAbacRequest, Operation> setLegacyAbacSettings() {
    return ((ClusterManagerStubSettings) getStubSettings()).setLegacyAbacSettings();
  }

  /** Returns the object with the settings used for calls to startIPRotation. */
  public UnaryCallSettings<StartIPRotationRequest, Operation> startIPRotationSettings() {
    return ((ClusterManagerStubSettings) getStubSettings()).startIPRotationSettings();
  }

  /** Returns the object with the settings used for calls to completeIPRotation. */
  public UnaryCallSettings<CompleteIPRotationRequest, Operation> completeIPRotationSettings() {
    return ((ClusterManagerStubSettings) getStubSettings()).completeIPRotationSettings();
  }

  /** Returns the object with the settings used for calls to setNodePoolSize. */
  public UnaryCallSettings<SetNodePoolSizeRequest, Operation> setNodePoolSizeSettings() {
    return ((ClusterManagerStubSettings) getStubSettings()).setNodePoolSizeSettings();
  }

  /** Returns the object with the settings used for calls to setNetworkPolicy. */
  public UnaryCallSettings<SetNetworkPolicyRequest, Operation> setNetworkPolicySettings() {
    return ((ClusterManagerStubSettings) getStubSettings()).setNetworkPolicySettings();
  }

  /** Returns the object with the settings used for calls to setMaintenancePolicy. */
  public UnaryCallSettings<SetMaintenancePolicyRequest, Operation> setMaintenancePolicySettings() {
    return ((ClusterManagerStubSettings) getStubSettings()).setMaintenancePolicySettings();
  }

  /** Returns the object with the settings used for calls to listUsableSubnetworks. */
  public PagedCallSettings<
          ListUsableSubnetworksRequest,
          ListUsableSubnetworksResponse,
          ListUsableSubnetworksPagedResponse>
      listUsableSubnetworksSettings() {
    return ((ClusterManagerStubSettings) getStubSettings()).listUsableSubnetworksSettings();
  }

  public static final ClusterManagerSettings create(ClusterManagerStubSettings stub)
      throws IOException {
    return new ClusterManagerSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return ClusterManagerStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return ClusterManagerStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return ClusterManagerStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return ClusterManagerStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return ClusterManagerStubSettings.defaultGrpcTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return ClusterManagerStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ClusterManagerStubSettings.defaultApiClientHeaderProviderBuilder();
  }

  /** Returns a new builder for this class. */
  public static Builder newBuilder() {
    return Builder.createDefault();
  }

  /** Returns a new builder for this class. */
  public static Builder newBuilder(ClientContext clientContext) {
    return new Builder(clientContext);
  }

  /** Returns a builder containing all the values of this settings class. */
  public Builder toBuilder() {
    return new Builder(this);
  }

  protected ClusterManagerSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for ClusterManagerSettings. */
  public static class Builder extends ClientSettings.Builder<ClusterManagerSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(ClusterManagerStubSettings.newBuilder(clientContext));
    }

    protected Builder(ClusterManagerSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(ClusterManagerStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(ClusterManagerStubSettings.newBuilder());
    }

    public ClusterManagerStubSettings.Builder getStubSettingsBuilder() {
      return ((ClusterManagerStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to listClusters. */
    public UnaryCallSettings.Builder<ListClustersRequest, ListClustersResponse>
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

    /** Returns the builder for the settings used for calls to updateCluster. */
    public UnaryCallSettings.Builder<UpdateClusterRequest, Operation> updateClusterSettings() {
      return getStubSettingsBuilder().updateClusterSettings();
    }

    /** Returns the builder for the settings used for calls to updateNodePool. */
    public UnaryCallSettings.Builder<UpdateNodePoolRequest, Operation> updateNodePoolSettings() {
      return getStubSettingsBuilder().updateNodePoolSettings();
    }

    /** Returns the builder for the settings used for calls to setNodePoolAutoscaling. */
    public UnaryCallSettings.Builder<SetNodePoolAutoscalingRequest, Operation>
        setNodePoolAutoscalingSettings() {
      return getStubSettingsBuilder().setNodePoolAutoscalingSettings();
    }

    /** Returns the builder for the settings used for calls to setLoggingService. */
    public UnaryCallSettings.Builder<SetLoggingServiceRequest, Operation>
        setLoggingServiceSettings() {
      return getStubSettingsBuilder().setLoggingServiceSettings();
    }

    /** Returns the builder for the settings used for calls to setMonitoringService. */
    public UnaryCallSettings.Builder<SetMonitoringServiceRequest, Operation>
        setMonitoringServiceSettings() {
      return getStubSettingsBuilder().setMonitoringServiceSettings();
    }

    /** Returns the builder for the settings used for calls to setAddonsConfig. */
    public UnaryCallSettings.Builder<SetAddonsConfigRequest, Operation> setAddonsConfigSettings() {
      return getStubSettingsBuilder().setAddonsConfigSettings();
    }

    /**
     * Returns the builder for the settings used for calls to setLocations.
     *
     * @deprecated This method is deprecated and will be removed in the next major version update.
     */
    @Deprecated
    public UnaryCallSettings.Builder<SetLocationsRequest, Operation> setLocationsSettings() {
      return getStubSettingsBuilder().setLocationsSettings();
    }

    /** Returns the builder for the settings used for calls to updateMaster. */
    public UnaryCallSettings.Builder<UpdateMasterRequest, Operation> updateMasterSettings() {
      return getStubSettingsBuilder().updateMasterSettings();
    }

    /** Returns the builder for the settings used for calls to setMasterAuth. */
    public UnaryCallSettings.Builder<SetMasterAuthRequest, Operation> setMasterAuthSettings() {
      return getStubSettingsBuilder().setMasterAuthSettings();
    }

    /** Returns the builder for the settings used for calls to deleteCluster. */
    public UnaryCallSettings.Builder<DeleteClusterRequest, Operation> deleteClusterSettings() {
      return getStubSettingsBuilder().deleteClusterSettings();
    }

    /** Returns the builder for the settings used for calls to listOperations. */
    public UnaryCallSettings.Builder<ListOperationsRequest, ListOperationsResponse>
        listOperationsSettings() {
      return getStubSettingsBuilder().listOperationsSettings();
    }

    /** Returns the builder for the settings used for calls to get. */
    public UnaryCallSettings.Builder<GetOperationRequest, Operation> getOperationSettings() {
      return getStubSettingsBuilder().getOperationSettings();
    }

    /** Returns the builder for the settings used for calls to cancel. */
    public UnaryCallSettings.Builder<CancelOperationRequest, Empty> cancelOperationSettings() {
      return getStubSettingsBuilder().cancelOperationSettings();
    }

    /** Returns the builder for the settings used for calls to getServerConfig. */
    public UnaryCallSettings.Builder<GetServerConfigRequest, ServerConfig>
        getServerConfigSettings() {
      return getStubSettingsBuilder().getServerConfigSettings();
    }

    /** Returns the builder for the settings used for calls to getJSONWebKeys. */
    public UnaryCallSettings.Builder<GetJSONWebKeysRequest, GetJSONWebKeysResponse>
        getJSONWebKeysSettings() {
      return getStubSettingsBuilder().getJSONWebKeysSettings();
    }

    /** Returns the builder for the settings used for calls to listNodePools. */
    public UnaryCallSettings.Builder<ListNodePoolsRequest, ListNodePoolsResponse>
        listNodePoolsSettings() {
      return getStubSettingsBuilder().listNodePoolsSettings();
    }

    /** Returns the builder for the settings used for calls to getNodePool. */
    public UnaryCallSettings.Builder<GetNodePoolRequest, NodePool> getNodePoolSettings() {
      return getStubSettingsBuilder().getNodePoolSettings();
    }

    /** Returns the builder for the settings used for calls to createNodePool. */
    public UnaryCallSettings.Builder<CreateNodePoolRequest, Operation> createNodePoolSettings() {
      return getStubSettingsBuilder().createNodePoolSettings();
    }

    /** Returns the builder for the settings used for calls to deleteNodePool. */
    public UnaryCallSettings.Builder<DeleteNodePoolRequest, Operation> deleteNodePoolSettings() {
      return getStubSettingsBuilder().deleteNodePoolSettings();
    }

    /** Returns the builder for the settings used for calls to completeNodePoolUpgrade. */
    public UnaryCallSettings.Builder<CompleteNodePoolUpgradeRequest, Empty>
        completeNodePoolUpgradeSettings() {
      return getStubSettingsBuilder().completeNodePoolUpgradeSettings();
    }

    /** Returns the builder for the settings used for calls to rollbackNodePoolUpgrade. */
    public UnaryCallSettings.Builder<RollbackNodePoolUpgradeRequest, Operation>
        rollbackNodePoolUpgradeSettings() {
      return getStubSettingsBuilder().rollbackNodePoolUpgradeSettings();
    }

    /** Returns the builder for the settings used for calls to setNodePoolManagement. */
    public UnaryCallSettings.Builder<SetNodePoolManagementRequest, Operation>
        setNodePoolManagementSettings() {
      return getStubSettingsBuilder().setNodePoolManagementSettings();
    }

    /** Returns the builder for the settings used for calls to setLabels. */
    public UnaryCallSettings.Builder<SetLabelsRequest, Operation> setLabelsSettings() {
      return getStubSettingsBuilder().setLabelsSettings();
    }

    /** Returns the builder for the settings used for calls to setLegacyAbac. */
    public UnaryCallSettings.Builder<SetLegacyAbacRequest, Operation> setLegacyAbacSettings() {
      return getStubSettingsBuilder().setLegacyAbacSettings();
    }

    /** Returns the builder for the settings used for calls to startIPRotation. */
    public UnaryCallSettings.Builder<StartIPRotationRequest, Operation> startIPRotationSettings() {
      return getStubSettingsBuilder().startIPRotationSettings();
    }

    /** Returns the builder for the settings used for calls to completeIPRotation. */
    public UnaryCallSettings.Builder<CompleteIPRotationRequest, Operation>
        completeIPRotationSettings() {
      return getStubSettingsBuilder().completeIPRotationSettings();
    }

    /** Returns the builder for the settings used for calls to setNodePoolSize. */
    public UnaryCallSettings.Builder<SetNodePoolSizeRequest, Operation> setNodePoolSizeSettings() {
      return getStubSettingsBuilder().setNodePoolSizeSettings();
    }

    /** Returns the builder for the settings used for calls to setNetworkPolicy. */
    public UnaryCallSettings.Builder<SetNetworkPolicyRequest, Operation>
        setNetworkPolicySettings() {
      return getStubSettingsBuilder().setNetworkPolicySettings();
    }

    /** Returns the builder for the settings used for calls to setMaintenancePolicy. */
    public UnaryCallSettings.Builder<SetMaintenancePolicyRequest, Operation>
        setMaintenancePolicySettings() {
      return getStubSettingsBuilder().setMaintenancePolicySettings();
    }

    /** Returns the builder for the settings used for calls to listUsableSubnetworks. */
    public PagedCallSettings.Builder<
            ListUsableSubnetworksRequest,
            ListUsableSubnetworksResponse,
            ListUsableSubnetworksPagedResponse>
        listUsableSubnetworksSettings() {
      return getStubSettingsBuilder().listUsableSubnetworksSettings();
    }

    @Override
    public ClusterManagerSettings build() throws IOException {
      return new ClusterManagerSettings(this);
    }
  }
}
