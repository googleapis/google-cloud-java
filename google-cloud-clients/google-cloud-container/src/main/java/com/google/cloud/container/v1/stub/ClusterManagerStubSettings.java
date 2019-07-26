/*
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.container.v1.stub;

import com.google.api.core.ApiFunction;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GaxProperties;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.GrpcTransportChannel;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.StubSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.container.v1.CancelOperationRequest;
import com.google.container.v1.Cluster;
import com.google.container.v1.CompleteIPRotationRequest;
import com.google.container.v1.CreateClusterRequest;
import com.google.container.v1.CreateNodePoolRequest;
import com.google.container.v1.DeleteClusterRequest;
import com.google.container.v1.DeleteNodePoolRequest;
import com.google.container.v1.GetClusterRequest;
import com.google.container.v1.GetNodePoolRequest;
import com.google.container.v1.GetOperationRequest;
import com.google.container.v1.GetServerConfigRequest;
import com.google.container.v1.ListClustersRequest;
import com.google.container.v1.ListClustersResponse;
import com.google.container.v1.ListNodePoolsRequest;
import com.google.container.v1.ListNodePoolsResponse;
import com.google.container.v1.ListOperationsRequest;
import com.google.container.v1.ListOperationsResponse;
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
import org.threeten.bp.Duration;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * Settings class to configure an instance of {@link ClusterManagerStub}.
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
 * <pre>
 * <code>
 * ClusterManagerStubSettings.Builder clusterManagerSettingsBuilder =
 *     ClusterManagerStubSettings.newBuilder();
 * clusterManagerSettingsBuilder.listClustersSettings().getRetrySettings().toBuilder()
 *     .setTotalTimeout(Duration.ofSeconds(30));
 * ClusterManagerStubSettings clusterManagerSettings = clusterManagerSettingsBuilder.build();
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class ClusterManagerStubSettings extends StubSettings<ClusterManagerStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final UnaryCallSettings<ListClustersRequest, ListClustersResponse> listClustersSettings;
  private final UnaryCallSettings<GetClusterRequest, Cluster> getClusterSettings;
  private final UnaryCallSettings<CreateClusterRequest, Operation> createClusterSettings;
  private final UnaryCallSettings<UpdateClusterRequest, Operation> updateClusterSettings;
  private final UnaryCallSettings<UpdateNodePoolRequest, Operation> updateNodePoolSettings;
  private final UnaryCallSettings<SetNodePoolAutoscalingRequest, Operation>
      setNodePoolAutoscalingSettings;
  private final UnaryCallSettings<SetLoggingServiceRequest, Operation> setLoggingServiceSettings;
  private final UnaryCallSettings<SetMonitoringServiceRequest, Operation>
      setMonitoringServiceSettings;
  private final UnaryCallSettings<SetAddonsConfigRequest, Operation> setAddonsConfigSettings;
  private final UnaryCallSettings<SetLocationsRequest, Operation> setLocationsSettings;
  private final UnaryCallSettings<UpdateMasterRequest, Operation> updateMasterSettings;
  private final UnaryCallSettings<SetMasterAuthRequest, Operation> setMasterAuthSettings;
  private final UnaryCallSettings<DeleteClusterRequest, Operation> deleteClusterSettings;
  private final UnaryCallSettings<ListOperationsRequest, ListOperationsResponse>
      listOperationsSettings;
  private final UnaryCallSettings<GetOperationRequest, Operation> getOperationSettings;
  private final UnaryCallSettings<CancelOperationRequest, Empty> cancelOperationSettings;
  private final UnaryCallSettings<GetServerConfigRequest, ServerConfig> getServerConfigSettings;
  private final UnaryCallSettings<ListNodePoolsRequest, ListNodePoolsResponse>
      listNodePoolsSettings;
  private final UnaryCallSettings<GetNodePoolRequest, NodePool> getNodePoolSettings;
  private final UnaryCallSettings<CreateNodePoolRequest, Operation> createNodePoolSettings;
  private final UnaryCallSettings<DeleteNodePoolRequest, Operation> deleteNodePoolSettings;
  private final UnaryCallSettings<RollbackNodePoolUpgradeRequest, Operation>
      rollbackNodePoolUpgradeSettings;
  private final UnaryCallSettings<SetNodePoolManagementRequest, Operation>
      setNodePoolManagementSettings;
  private final UnaryCallSettings<SetLabelsRequest, Operation> setLabelsSettings;
  private final UnaryCallSettings<SetLegacyAbacRequest, Operation> setLegacyAbacSettings;
  private final UnaryCallSettings<StartIPRotationRequest, Operation> startIPRotationSettings;
  private final UnaryCallSettings<CompleteIPRotationRequest, Operation> completeIPRotationSettings;
  private final UnaryCallSettings<SetNodePoolSizeRequest, Operation> setNodePoolSizeSettings;
  private final UnaryCallSettings<SetNetworkPolicyRequest, Operation> setNetworkPolicySettings;
  private final UnaryCallSettings<SetMaintenancePolicyRequest, Operation>
      setMaintenancePolicySettings;

  /** Returns the object with the settings used for calls to listClusters. */
  public UnaryCallSettings<ListClustersRequest, ListClustersResponse> listClustersSettings() {
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

  /** Returns the object with the settings used for calls to updateCluster. */
  public UnaryCallSettings<UpdateClusterRequest, Operation> updateClusterSettings() {
    return updateClusterSettings;
  }

  /** Returns the object with the settings used for calls to updateNodePool. */
  public UnaryCallSettings<UpdateNodePoolRequest, Operation> updateNodePoolSettings() {
    return updateNodePoolSettings;
  }

  /** Returns the object with the settings used for calls to setNodePoolAutoscaling. */
  public UnaryCallSettings<SetNodePoolAutoscalingRequest, Operation>
      setNodePoolAutoscalingSettings() {
    return setNodePoolAutoscalingSettings;
  }

  /** Returns the object with the settings used for calls to setLoggingService. */
  public UnaryCallSettings<SetLoggingServiceRequest, Operation> setLoggingServiceSettings() {
    return setLoggingServiceSettings;
  }

  /** Returns the object with the settings used for calls to setMonitoringService. */
  public UnaryCallSettings<SetMonitoringServiceRequest, Operation> setMonitoringServiceSettings() {
    return setMonitoringServiceSettings;
  }

  /** Returns the object with the settings used for calls to setAddonsConfig. */
  public UnaryCallSettings<SetAddonsConfigRequest, Operation> setAddonsConfigSettings() {
    return setAddonsConfigSettings;
  }

  /** Returns the object with the settings used for calls to setLocations. */
  public UnaryCallSettings<SetLocationsRequest, Operation> setLocationsSettings() {
    return setLocationsSettings;
  }

  /** Returns the object with the settings used for calls to updateMaster. */
  public UnaryCallSettings<UpdateMasterRequest, Operation> updateMasterSettings() {
    return updateMasterSettings;
  }

  /** Returns the object with the settings used for calls to setMasterAuth. */
  public UnaryCallSettings<SetMasterAuthRequest, Operation> setMasterAuthSettings() {
    return setMasterAuthSettings;
  }

  /** Returns the object with the settings used for calls to deleteCluster. */
  public UnaryCallSettings<DeleteClusterRequest, Operation> deleteClusterSettings() {
    return deleteClusterSettings;
  }

  /** Returns the object with the settings used for calls to listOperations. */
  public UnaryCallSettings<ListOperationsRequest, ListOperationsResponse> listOperationsSettings() {
    return listOperationsSettings;
  }

  /** Returns the object with the settings used for calls to getOperation. */
  public UnaryCallSettings<GetOperationRequest, Operation> getOperationSettings() {
    return getOperationSettings;
  }

  /** Returns the object with the settings used for calls to cancelOperation. */
  public UnaryCallSettings<CancelOperationRequest, Empty> cancelOperationSettings() {
    return cancelOperationSettings;
  }

  /** Returns the object with the settings used for calls to getServerConfig. */
  public UnaryCallSettings<GetServerConfigRequest, ServerConfig> getServerConfigSettings() {
    return getServerConfigSettings;
  }

  /** Returns the object with the settings used for calls to listNodePools. */
  public UnaryCallSettings<ListNodePoolsRequest, ListNodePoolsResponse> listNodePoolsSettings() {
    return listNodePoolsSettings;
  }

  /** Returns the object with the settings used for calls to getNodePool. */
  public UnaryCallSettings<GetNodePoolRequest, NodePool> getNodePoolSettings() {
    return getNodePoolSettings;
  }

  /** Returns the object with the settings used for calls to createNodePool. */
  public UnaryCallSettings<CreateNodePoolRequest, Operation> createNodePoolSettings() {
    return createNodePoolSettings;
  }

  /** Returns the object with the settings used for calls to deleteNodePool. */
  public UnaryCallSettings<DeleteNodePoolRequest, Operation> deleteNodePoolSettings() {
    return deleteNodePoolSettings;
  }

  /** Returns the object with the settings used for calls to rollbackNodePoolUpgrade. */
  public UnaryCallSettings<RollbackNodePoolUpgradeRequest, Operation>
      rollbackNodePoolUpgradeSettings() {
    return rollbackNodePoolUpgradeSettings;
  }

  /** Returns the object with the settings used for calls to setNodePoolManagement. */
  public UnaryCallSettings<SetNodePoolManagementRequest, Operation>
      setNodePoolManagementSettings() {
    return setNodePoolManagementSettings;
  }

  /** Returns the object with the settings used for calls to setLabels. */
  public UnaryCallSettings<SetLabelsRequest, Operation> setLabelsSettings() {
    return setLabelsSettings;
  }

  /** Returns the object with the settings used for calls to setLegacyAbac. */
  public UnaryCallSettings<SetLegacyAbacRequest, Operation> setLegacyAbacSettings() {
    return setLegacyAbacSettings;
  }

  /** Returns the object with the settings used for calls to startIPRotation. */
  public UnaryCallSettings<StartIPRotationRequest, Operation> startIPRotationSettings() {
    return startIPRotationSettings;
  }

  /** Returns the object with the settings used for calls to completeIPRotation. */
  public UnaryCallSettings<CompleteIPRotationRequest, Operation> completeIPRotationSettings() {
    return completeIPRotationSettings;
  }

  /** Returns the object with the settings used for calls to setNodePoolSize. */
  public UnaryCallSettings<SetNodePoolSizeRequest, Operation> setNodePoolSizeSettings() {
    return setNodePoolSizeSettings;
  }

  /** Returns the object with the settings used for calls to setNetworkPolicy. */
  public UnaryCallSettings<SetNetworkPolicyRequest, Operation> setNetworkPolicySettings() {
    return setNetworkPolicySettings;
  }

  /** Returns the object with the settings used for calls to setMaintenancePolicy. */
  public UnaryCallSettings<SetMaintenancePolicyRequest, Operation> setMaintenancePolicySettings() {
    return setMaintenancePolicySettings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public ClusterManagerStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcClusterManagerStub.create(this);
    } else {
      throw new UnsupportedOperationException(
          "Transport not supported: " + getTransportChannelProvider().getTransportName());
    }
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return "container.googleapis.com:443";
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return DEFAULT_SERVICE_SCOPES;
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return GoogleCredentialsProvider.newBuilder().setScopesToApply(DEFAULT_SERVICE_SCOPES);
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return InstantiatingGrpcChannelProvider.newBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return defaultGrpcTransportProviderBuilder().build();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(ClusterManagerStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
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

  protected ClusterManagerStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    listClustersSettings = settingsBuilder.listClustersSettings().build();
    getClusterSettings = settingsBuilder.getClusterSettings().build();
    createClusterSettings = settingsBuilder.createClusterSettings().build();
    updateClusterSettings = settingsBuilder.updateClusterSettings().build();
    updateNodePoolSettings = settingsBuilder.updateNodePoolSettings().build();
    setNodePoolAutoscalingSettings = settingsBuilder.setNodePoolAutoscalingSettings().build();
    setLoggingServiceSettings = settingsBuilder.setLoggingServiceSettings().build();
    setMonitoringServiceSettings = settingsBuilder.setMonitoringServiceSettings().build();
    setAddonsConfigSettings = settingsBuilder.setAddonsConfigSettings().build();
    setLocationsSettings = settingsBuilder.setLocationsSettings().build();
    updateMasterSettings = settingsBuilder.updateMasterSettings().build();
    setMasterAuthSettings = settingsBuilder.setMasterAuthSettings().build();
    deleteClusterSettings = settingsBuilder.deleteClusterSettings().build();
    listOperationsSettings = settingsBuilder.listOperationsSettings().build();
    getOperationSettings = settingsBuilder.getOperationSettings().build();
    cancelOperationSettings = settingsBuilder.cancelOperationSettings().build();
    getServerConfigSettings = settingsBuilder.getServerConfigSettings().build();
    listNodePoolsSettings = settingsBuilder.listNodePoolsSettings().build();
    getNodePoolSettings = settingsBuilder.getNodePoolSettings().build();
    createNodePoolSettings = settingsBuilder.createNodePoolSettings().build();
    deleteNodePoolSettings = settingsBuilder.deleteNodePoolSettings().build();
    rollbackNodePoolUpgradeSettings = settingsBuilder.rollbackNodePoolUpgradeSettings().build();
    setNodePoolManagementSettings = settingsBuilder.setNodePoolManagementSettings().build();
    setLabelsSettings = settingsBuilder.setLabelsSettings().build();
    setLegacyAbacSettings = settingsBuilder.setLegacyAbacSettings().build();
    startIPRotationSettings = settingsBuilder.startIPRotationSettings().build();
    completeIPRotationSettings = settingsBuilder.completeIPRotationSettings().build();
    setNodePoolSizeSettings = settingsBuilder.setNodePoolSizeSettings().build();
    setNetworkPolicySettings = settingsBuilder.setNetworkPolicySettings().build();
    setMaintenancePolicySettings = settingsBuilder.setMaintenancePolicySettings().build();
  }

  /** Builder for ClusterManagerStubSettings. */
  public static class Builder extends StubSettings.Builder<ClusterManagerStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;

    private final UnaryCallSettings.Builder<ListClustersRequest, ListClustersResponse>
        listClustersSettings;
    private final UnaryCallSettings.Builder<GetClusterRequest, Cluster> getClusterSettings;
    private final UnaryCallSettings.Builder<CreateClusterRequest, Operation> createClusterSettings;
    private final UnaryCallSettings.Builder<UpdateClusterRequest, Operation> updateClusterSettings;
    private final UnaryCallSettings.Builder<UpdateNodePoolRequest, Operation>
        updateNodePoolSettings;
    private final UnaryCallSettings.Builder<SetNodePoolAutoscalingRequest, Operation>
        setNodePoolAutoscalingSettings;
    private final UnaryCallSettings.Builder<SetLoggingServiceRequest, Operation>
        setLoggingServiceSettings;
    private final UnaryCallSettings.Builder<SetMonitoringServiceRequest, Operation>
        setMonitoringServiceSettings;
    private final UnaryCallSettings.Builder<SetAddonsConfigRequest, Operation>
        setAddonsConfigSettings;
    private final UnaryCallSettings.Builder<SetLocationsRequest, Operation> setLocationsSettings;
    private final UnaryCallSettings.Builder<UpdateMasterRequest, Operation> updateMasterSettings;
    private final UnaryCallSettings.Builder<SetMasterAuthRequest, Operation> setMasterAuthSettings;
    private final UnaryCallSettings.Builder<DeleteClusterRequest, Operation> deleteClusterSettings;
    private final UnaryCallSettings.Builder<ListOperationsRequest, ListOperationsResponse>
        listOperationsSettings;
    private final UnaryCallSettings.Builder<GetOperationRequest, Operation> getOperationSettings;
    private final UnaryCallSettings.Builder<CancelOperationRequest, Empty> cancelOperationSettings;
    private final UnaryCallSettings.Builder<GetServerConfigRequest, ServerConfig>
        getServerConfigSettings;
    private final UnaryCallSettings.Builder<ListNodePoolsRequest, ListNodePoolsResponse>
        listNodePoolsSettings;
    private final UnaryCallSettings.Builder<GetNodePoolRequest, NodePool> getNodePoolSettings;
    private final UnaryCallSettings.Builder<CreateNodePoolRequest, Operation>
        createNodePoolSettings;
    private final UnaryCallSettings.Builder<DeleteNodePoolRequest, Operation>
        deleteNodePoolSettings;
    private final UnaryCallSettings.Builder<RollbackNodePoolUpgradeRequest, Operation>
        rollbackNodePoolUpgradeSettings;
    private final UnaryCallSettings.Builder<SetNodePoolManagementRequest, Operation>
        setNodePoolManagementSettings;
    private final UnaryCallSettings.Builder<SetLabelsRequest, Operation> setLabelsSettings;
    private final UnaryCallSettings.Builder<SetLegacyAbacRequest, Operation> setLegacyAbacSettings;
    private final UnaryCallSettings.Builder<StartIPRotationRequest, Operation>
        startIPRotationSettings;
    private final UnaryCallSettings.Builder<CompleteIPRotationRequest, Operation>
        completeIPRotationSettings;
    private final UnaryCallSettings.Builder<SetNodePoolSizeRequest, Operation>
        setNodePoolSizeSettings;
    private final UnaryCallSettings.Builder<SetNetworkPolicyRequest, Operation>
        setNetworkPolicySettings;
    private final UnaryCallSettings.Builder<SetMaintenancePolicyRequest, Operation>
        setMaintenancePolicySettings;

    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put(
          "idempotent",
          ImmutableSet.copyOf(
              Lists.<StatusCode.Code>newArrayList(
                  StatusCode.Code.DEADLINE_EXCEEDED, StatusCode.Code.UNAVAILABLE)));
      definitions.put("non_idempotent", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      RETRYABLE_CODE_DEFINITIONS = definitions.build();
    }

    private static final ImmutableMap<String, RetrySettings> RETRY_PARAM_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, RetrySettings> definitions = ImmutableMap.builder();
      RetrySettings settings = null;
      settings =
          RetrySettings.newBuilder()
              .setInitialRetryDelay(Duration.ofMillis(100L))
              .setRetryDelayMultiplier(1.3)
              .setMaxRetryDelay(Duration.ofMillis(60000L))
              .setInitialRpcTimeout(Duration.ofMillis(20000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(20000L))
              .setTotalTimeout(Duration.ofMillis(600000L))
              .build();
      definitions.put("default", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this((ClientContext) null);
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      listClustersSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      getClusterSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      createClusterSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      updateClusterSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      updateNodePoolSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      setNodePoolAutoscalingSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      setLoggingServiceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      setMonitoringServiceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      setAddonsConfigSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      setLocationsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      updateMasterSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      setMasterAuthSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      deleteClusterSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      listOperationsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      getOperationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      cancelOperationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      getServerConfigSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      listNodePoolsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      getNodePoolSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      createNodePoolSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      deleteNodePoolSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      rollbackNodePoolUpgradeSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      setNodePoolManagementSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      setLabelsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      setLegacyAbacSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      startIPRotationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      completeIPRotationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      setNodePoolSizeSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      setNetworkPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      setMaintenancePolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listClustersSettings,
              getClusterSettings,
              createClusterSettings,
              updateClusterSettings,
              updateNodePoolSettings,
              setNodePoolAutoscalingSettings,
              setLoggingServiceSettings,
              setMonitoringServiceSettings,
              setAddonsConfigSettings,
              setLocationsSettings,
              updateMasterSettings,
              setMasterAuthSettings,
              deleteClusterSettings,
              listOperationsSettings,
              getOperationSettings,
              cancelOperationSettings,
              getServerConfigSettings,
              listNodePoolsSettings,
              getNodePoolSettings,
              createNodePoolSettings,
              deleteNodePoolSettings,
              rollbackNodePoolUpgradeSettings,
              setNodePoolManagementSettings,
              setLabelsSettings,
              setLegacyAbacSettings,
              startIPRotationSettings,
              completeIPRotationSettings,
              setNodePoolSizeSettings,
              setNetworkPolicySettings,
              setMaintenancePolicySettings);

      initDefaults(this);
    }

    private static Builder createDefault() {
      Builder builder = new Builder((ClientContext) null);
      builder.setTransportChannelProvider(defaultTransportChannelProvider());
      builder.setCredentialsProvider(defaultCredentialsProviderBuilder().build());
      builder.setInternalHeaderProvider(defaultApiClientHeaderProviderBuilder().build());
      builder.setEndpoint(getDefaultEndpoint());
      return initDefaults(builder);
    }

    private static Builder initDefaults(Builder builder) {

      builder
          .listClustersSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .getClusterSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .createClusterSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .updateClusterSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .updateNodePoolSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .setNodePoolAutoscalingSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .setLoggingServiceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .setMonitoringServiceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .setAddonsConfigSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .setLocationsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .updateMasterSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .setMasterAuthSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .deleteClusterSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .listOperationsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .getOperationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .cancelOperationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .getServerConfigSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .listNodePoolsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .getNodePoolSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .createNodePoolSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .deleteNodePoolSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .rollbackNodePoolUpgradeSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .setNodePoolManagementSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .setLabelsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .setLegacyAbacSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .startIPRotationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .completeIPRotationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .setNodePoolSizeSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .setNetworkPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .setMaintenancePolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      return builder;
    }

    protected Builder(ClusterManagerStubSettings settings) {
      super(settings);

      listClustersSettings = settings.listClustersSettings.toBuilder();
      getClusterSettings = settings.getClusterSettings.toBuilder();
      createClusterSettings = settings.createClusterSettings.toBuilder();
      updateClusterSettings = settings.updateClusterSettings.toBuilder();
      updateNodePoolSettings = settings.updateNodePoolSettings.toBuilder();
      setNodePoolAutoscalingSettings = settings.setNodePoolAutoscalingSettings.toBuilder();
      setLoggingServiceSettings = settings.setLoggingServiceSettings.toBuilder();
      setMonitoringServiceSettings = settings.setMonitoringServiceSettings.toBuilder();
      setAddonsConfigSettings = settings.setAddonsConfigSettings.toBuilder();
      setLocationsSettings = settings.setLocationsSettings.toBuilder();
      updateMasterSettings = settings.updateMasterSettings.toBuilder();
      setMasterAuthSettings = settings.setMasterAuthSettings.toBuilder();
      deleteClusterSettings = settings.deleteClusterSettings.toBuilder();
      listOperationsSettings = settings.listOperationsSettings.toBuilder();
      getOperationSettings = settings.getOperationSettings.toBuilder();
      cancelOperationSettings = settings.cancelOperationSettings.toBuilder();
      getServerConfigSettings = settings.getServerConfigSettings.toBuilder();
      listNodePoolsSettings = settings.listNodePoolsSettings.toBuilder();
      getNodePoolSettings = settings.getNodePoolSettings.toBuilder();
      createNodePoolSettings = settings.createNodePoolSettings.toBuilder();
      deleteNodePoolSettings = settings.deleteNodePoolSettings.toBuilder();
      rollbackNodePoolUpgradeSettings = settings.rollbackNodePoolUpgradeSettings.toBuilder();
      setNodePoolManagementSettings = settings.setNodePoolManagementSettings.toBuilder();
      setLabelsSettings = settings.setLabelsSettings.toBuilder();
      setLegacyAbacSettings = settings.setLegacyAbacSettings.toBuilder();
      startIPRotationSettings = settings.startIPRotationSettings.toBuilder();
      completeIPRotationSettings = settings.completeIPRotationSettings.toBuilder();
      setNodePoolSizeSettings = settings.setNodePoolSizeSettings.toBuilder();
      setNetworkPolicySettings = settings.setNetworkPolicySettings.toBuilder();
      setMaintenancePolicySettings = settings.setMaintenancePolicySettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listClustersSettings,
              getClusterSettings,
              createClusterSettings,
              updateClusterSettings,
              updateNodePoolSettings,
              setNodePoolAutoscalingSettings,
              setLoggingServiceSettings,
              setMonitoringServiceSettings,
              setAddonsConfigSettings,
              setLocationsSettings,
              updateMasterSettings,
              setMasterAuthSettings,
              deleteClusterSettings,
              listOperationsSettings,
              getOperationSettings,
              cancelOperationSettings,
              getServerConfigSettings,
              listNodePoolsSettings,
              getNodePoolSettings,
              createNodePoolSettings,
              deleteNodePoolSettings,
              rollbackNodePoolUpgradeSettings,
              setNodePoolManagementSettings,
              setLabelsSettings,
              setLegacyAbacSettings,
              startIPRotationSettings,
              completeIPRotationSettings,
              setNodePoolSizeSettings,
              setNetworkPolicySettings,
              setMaintenancePolicySettings);
    }

    // NEXT_MAJOR_VER: remove 'throws Exception'
    /**
     * Applies the given settings updater function to all of the unary API methods in this service.
     *
     * <p>Note: This method does not support applying settings to streaming methods.
     */
    public Builder applyToAllUnaryMethods(
        ApiFunction<UnaryCallSettings.Builder<?, ?>, Void> settingsUpdater) throws Exception {
      super.applyToAllUnaryMethods(unaryMethodSettingsBuilders, settingsUpdater);
      return this;
    }

    public ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders() {
      return unaryMethodSettingsBuilders;
    }

    /** Returns the builder for the settings used for calls to listClusters. */
    public UnaryCallSettings.Builder<ListClustersRequest, ListClustersResponse>
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

    /** Returns the builder for the settings used for calls to updateCluster. */
    public UnaryCallSettings.Builder<UpdateClusterRequest, Operation> updateClusterSettings() {
      return updateClusterSettings;
    }

    /** Returns the builder for the settings used for calls to updateNodePool. */
    public UnaryCallSettings.Builder<UpdateNodePoolRequest, Operation> updateNodePoolSettings() {
      return updateNodePoolSettings;
    }

    /** Returns the builder for the settings used for calls to setNodePoolAutoscaling. */
    public UnaryCallSettings.Builder<SetNodePoolAutoscalingRequest, Operation>
        setNodePoolAutoscalingSettings() {
      return setNodePoolAutoscalingSettings;
    }

    /** Returns the builder for the settings used for calls to setLoggingService. */
    public UnaryCallSettings.Builder<SetLoggingServiceRequest, Operation>
        setLoggingServiceSettings() {
      return setLoggingServiceSettings;
    }

    /** Returns the builder for the settings used for calls to setMonitoringService. */
    public UnaryCallSettings.Builder<SetMonitoringServiceRequest, Operation>
        setMonitoringServiceSettings() {
      return setMonitoringServiceSettings;
    }

    /** Returns the builder for the settings used for calls to setAddonsConfig. */
    public UnaryCallSettings.Builder<SetAddonsConfigRequest, Operation> setAddonsConfigSettings() {
      return setAddonsConfigSettings;
    }

    /** Returns the builder for the settings used for calls to setLocations. */
    public UnaryCallSettings.Builder<SetLocationsRequest, Operation> setLocationsSettings() {
      return setLocationsSettings;
    }

    /** Returns the builder for the settings used for calls to updateMaster. */
    public UnaryCallSettings.Builder<UpdateMasterRequest, Operation> updateMasterSettings() {
      return updateMasterSettings;
    }

    /** Returns the builder for the settings used for calls to setMasterAuth. */
    public UnaryCallSettings.Builder<SetMasterAuthRequest, Operation> setMasterAuthSettings() {
      return setMasterAuthSettings;
    }

    /** Returns the builder for the settings used for calls to deleteCluster. */
    public UnaryCallSettings.Builder<DeleteClusterRequest, Operation> deleteClusterSettings() {
      return deleteClusterSettings;
    }

    /** Returns the builder for the settings used for calls to listOperations. */
    public UnaryCallSettings.Builder<ListOperationsRequest, ListOperationsResponse>
        listOperationsSettings() {
      return listOperationsSettings;
    }

    /** Returns the builder for the settings used for calls to getOperation. */
    public UnaryCallSettings.Builder<GetOperationRequest, Operation> getOperationSettings() {
      return getOperationSettings;
    }

    /** Returns the builder for the settings used for calls to cancelOperation. */
    public UnaryCallSettings.Builder<CancelOperationRequest, Empty> cancelOperationSettings() {
      return cancelOperationSettings;
    }

    /** Returns the builder for the settings used for calls to getServerConfig. */
    public UnaryCallSettings.Builder<GetServerConfigRequest, ServerConfig>
        getServerConfigSettings() {
      return getServerConfigSettings;
    }

    /** Returns the builder for the settings used for calls to listNodePools. */
    public UnaryCallSettings.Builder<ListNodePoolsRequest, ListNodePoolsResponse>
        listNodePoolsSettings() {
      return listNodePoolsSettings;
    }

    /** Returns the builder for the settings used for calls to getNodePool. */
    public UnaryCallSettings.Builder<GetNodePoolRequest, NodePool> getNodePoolSettings() {
      return getNodePoolSettings;
    }

    /** Returns the builder for the settings used for calls to createNodePool. */
    public UnaryCallSettings.Builder<CreateNodePoolRequest, Operation> createNodePoolSettings() {
      return createNodePoolSettings;
    }

    /** Returns the builder for the settings used for calls to deleteNodePool. */
    public UnaryCallSettings.Builder<DeleteNodePoolRequest, Operation> deleteNodePoolSettings() {
      return deleteNodePoolSettings;
    }

    /** Returns the builder for the settings used for calls to rollbackNodePoolUpgrade. */
    public UnaryCallSettings.Builder<RollbackNodePoolUpgradeRequest, Operation>
        rollbackNodePoolUpgradeSettings() {
      return rollbackNodePoolUpgradeSettings;
    }

    /** Returns the builder for the settings used for calls to setNodePoolManagement. */
    public UnaryCallSettings.Builder<SetNodePoolManagementRequest, Operation>
        setNodePoolManagementSettings() {
      return setNodePoolManagementSettings;
    }

    /** Returns the builder for the settings used for calls to setLabels. */
    public UnaryCallSettings.Builder<SetLabelsRequest, Operation> setLabelsSettings() {
      return setLabelsSettings;
    }

    /** Returns the builder for the settings used for calls to setLegacyAbac. */
    public UnaryCallSettings.Builder<SetLegacyAbacRequest, Operation> setLegacyAbacSettings() {
      return setLegacyAbacSettings;
    }

    /** Returns the builder for the settings used for calls to startIPRotation. */
    public UnaryCallSettings.Builder<StartIPRotationRequest, Operation> startIPRotationSettings() {
      return startIPRotationSettings;
    }

    /** Returns the builder for the settings used for calls to completeIPRotation. */
    public UnaryCallSettings.Builder<CompleteIPRotationRequest, Operation>
        completeIPRotationSettings() {
      return completeIPRotationSettings;
    }

    /** Returns the builder for the settings used for calls to setNodePoolSize. */
    public UnaryCallSettings.Builder<SetNodePoolSizeRequest, Operation> setNodePoolSizeSettings() {
      return setNodePoolSizeSettings;
    }

    /** Returns the builder for the settings used for calls to setNetworkPolicy. */
    public UnaryCallSettings.Builder<SetNetworkPolicyRequest, Operation>
        setNetworkPolicySettings() {
      return setNetworkPolicySettings;
    }

    /** Returns the builder for the settings used for calls to setMaintenancePolicy. */
    public UnaryCallSettings.Builder<SetMaintenancePolicyRequest, Operation>
        setMaintenancePolicySettings() {
      return setMaintenancePolicySettings;
    }

    @Override
    public ClusterManagerStubSettings build() throws IOException {
      return new ClusterManagerStubSettings(this);
    }
  }
}
