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

package com.google.cloud.edgecontainer.v1;

import static com.google.cloud.edgecontainer.v1.EdgeContainerClient.ListClustersPagedResponse;
import static com.google.cloud.edgecontainer.v1.EdgeContainerClient.ListMachinesPagedResponse;
import static com.google.cloud.edgecontainer.v1.EdgeContainerClient.ListNodePoolsPagedResponse;
import static com.google.cloud.edgecontainer.v1.EdgeContainerClient.ListVpnConnectionsPagedResponse;

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
import com.google.api.gax.rpc.StubSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.edgecontainer.v1.stub.EdgeContainerStubSettings;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link EdgeContainerClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (edgecontainer.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getCluster to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * EdgeContainerSettings.Builder edgeContainerSettingsBuilder = EdgeContainerSettings.newBuilder();
 * edgeContainerSettingsBuilder
 *     .getClusterSettings()
 *     .setRetrySettings(
 *         edgeContainerSettingsBuilder.getClusterSettings().getRetrySettings().toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * EdgeContainerSettings edgeContainerSettings = edgeContainerSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class EdgeContainerSettings extends ClientSettings<EdgeContainerSettings> {

  /** Returns the object with the settings used for calls to listClusters. */
  public PagedCallSettings<ListClustersRequest, ListClustersResponse, ListClustersPagedResponse>
      listClustersSettings() {
    return ((EdgeContainerStubSettings) getStubSettings()).listClustersSettings();
  }

  /** Returns the object with the settings used for calls to getCluster. */
  public UnaryCallSettings<GetClusterRequest, Cluster> getClusterSettings() {
    return ((EdgeContainerStubSettings) getStubSettings()).getClusterSettings();
  }

  /** Returns the object with the settings used for calls to createCluster. */
  public UnaryCallSettings<CreateClusterRequest, Operation> createClusterSettings() {
    return ((EdgeContainerStubSettings) getStubSettings()).createClusterSettings();
  }

  /** Returns the object with the settings used for calls to createCluster. */
  public OperationCallSettings<CreateClusterRequest, Cluster, OperationMetadata>
      createClusterOperationSettings() {
    return ((EdgeContainerStubSettings) getStubSettings()).createClusterOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateCluster. */
  public UnaryCallSettings<UpdateClusterRequest, Operation> updateClusterSettings() {
    return ((EdgeContainerStubSettings) getStubSettings()).updateClusterSettings();
  }

  /** Returns the object with the settings used for calls to updateCluster. */
  public OperationCallSettings<UpdateClusterRequest, Cluster, OperationMetadata>
      updateClusterOperationSettings() {
    return ((EdgeContainerStubSettings) getStubSettings()).updateClusterOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteCluster. */
  public UnaryCallSettings<DeleteClusterRequest, Operation> deleteClusterSettings() {
    return ((EdgeContainerStubSettings) getStubSettings()).deleteClusterSettings();
  }

  /** Returns the object with the settings used for calls to deleteCluster. */
  public OperationCallSettings<DeleteClusterRequest, Empty, OperationMetadata>
      deleteClusterOperationSettings() {
    return ((EdgeContainerStubSettings) getStubSettings()).deleteClusterOperationSettings();
  }

  /** Returns the object with the settings used for calls to generateAccessToken. */
  public UnaryCallSettings<GenerateAccessTokenRequest, GenerateAccessTokenResponse>
      generateAccessTokenSettings() {
    return ((EdgeContainerStubSettings) getStubSettings()).generateAccessTokenSettings();
  }

  /** Returns the object with the settings used for calls to listNodePools. */
  public PagedCallSettings<ListNodePoolsRequest, ListNodePoolsResponse, ListNodePoolsPagedResponse>
      listNodePoolsSettings() {
    return ((EdgeContainerStubSettings) getStubSettings()).listNodePoolsSettings();
  }

  /** Returns the object with the settings used for calls to getNodePool. */
  public UnaryCallSettings<GetNodePoolRequest, NodePool> getNodePoolSettings() {
    return ((EdgeContainerStubSettings) getStubSettings()).getNodePoolSettings();
  }

  /** Returns the object with the settings used for calls to createNodePool. */
  public UnaryCallSettings<CreateNodePoolRequest, Operation> createNodePoolSettings() {
    return ((EdgeContainerStubSettings) getStubSettings()).createNodePoolSettings();
  }

  /** Returns the object with the settings used for calls to createNodePool. */
  public OperationCallSettings<CreateNodePoolRequest, NodePool, OperationMetadata>
      createNodePoolOperationSettings() {
    return ((EdgeContainerStubSettings) getStubSettings()).createNodePoolOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateNodePool. */
  public UnaryCallSettings<UpdateNodePoolRequest, Operation> updateNodePoolSettings() {
    return ((EdgeContainerStubSettings) getStubSettings()).updateNodePoolSettings();
  }

  /** Returns the object with the settings used for calls to updateNodePool. */
  public OperationCallSettings<UpdateNodePoolRequest, NodePool, OperationMetadata>
      updateNodePoolOperationSettings() {
    return ((EdgeContainerStubSettings) getStubSettings()).updateNodePoolOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteNodePool. */
  public UnaryCallSettings<DeleteNodePoolRequest, Operation> deleteNodePoolSettings() {
    return ((EdgeContainerStubSettings) getStubSettings()).deleteNodePoolSettings();
  }

  /** Returns the object with the settings used for calls to deleteNodePool. */
  public OperationCallSettings<DeleteNodePoolRequest, Empty, OperationMetadata>
      deleteNodePoolOperationSettings() {
    return ((EdgeContainerStubSettings) getStubSettings()).deleteNodePoolOperationSettings();
  }

  /** Returns the object with the settings used for calls to listMachines. */
  public PagedCallSettings<ListMachinesRequest, ListMachinesResponse, ListMachinesPagedResponse>
      listMachinesSettings() {
    return ((EdgeContainerStubSettings) getStubSettings()).listMachinesSettings();
  }

  /** Returns the object with the settings used for calls to getMachine. */
  public UnaryCallSettings<GetMachineRequest, Machine> getMachineSettings() {
    return ((EdgeContainerStubSettings) getStubSettings()).getMachineSettings();
  }

  /** Returns the object with the settings used for calls to listVpnConnections. */
  public PagedCallSettings<
          ListVpnConnectionsRequest, ListVpnConnectionsResponse, ListVpnConnectionsPagedResponse>
      listVpnConnectionsSettings() {
    return ((EdgeContainerStubSettings) getStubSettings()).listVpnConnectionsSettings();
  }

  /** Returns the object with the settings used for calls to getVpnConnection. */
  public UnaryCallSettings<GetVpnConnectionRequest, VpnConnection> getVpnConnectionSettings() {
    return ((EdgeContainerStubSettings) getStubSettings()).getVpnConnectionSettings();
  }

  /** Returns the object with the settings used for calls to createVpnConnection. */
  public UnaryCallSettings<CreateVpnConnectionRequest, Operation> createVpnConnectionSettings() {
    return ((EdgeContainerStubSettings) getStubSettings()).createVpnConnectionSettings();
  }

  /** Returns the object with the settings used for calls to createVpnConnection. */
  public OperationCallSettings<CreateVpnConnectionRequest, VpnConnection, OperationMetadata>
      createVpnConnectionOperationSettings() {
    return ((EdgeContainerStubSettings) getStubSettings()).createVpnConnectionOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteVpnConnection. */
  public UnaryCallSettings<DeleteVpnConnectionRequest, Operation> deleteVpnConnectionSettings() {
    return ((EdgeContainerStubSettings) getStubSettings()).deleteVpnConnectionSettings();
  }

  /** Returns the object with the settings used for calls to deleteVpnConnection. */
  public OperationCallSettings<DeleteVpnConnectionRequest, Empty, OperationMetadata>
      deleteVpnConnectionOperationSettings() {
    return ((EdgeContainerStubSettings) getStubSettings()).deleteVpnConnectionOperationSettings();
  }

  public static final EdgeContainerSettings create(EdgeContainerStubSettings stub)
      throws IOException {
    return new EdgeContainerSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return EdgeContainerStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return EdgeContainerStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return EdgeContainerStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return EdgeContainerStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return EdgeContainerStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return EdgeContainerStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return EdgeContainerStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return EdgeContainerStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected EdgeContainerSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for EdgeContainerSettings. */
  public static class Builder extends ClientSettings.Builder<EdgeContainerSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(EdgeContainerStubSettings.newBuilder(clientContext));
    }

    protected Builder(EdgeContainerSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(EdgeContainerStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(EdgeContainerStubSettings.newBuilder());
    }

    @BetaApi
    private static Builder createHttpJsonDefault() {
      return new Builder(EdgeContainerStubSettings.newHttpJsonBuilder());
    }

    public EdgeContainerStubSettings.Builder getStubSettingsBuilder() {
      return ((EdgeContainerStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to generateAccessToken. */
    public UnaryCallSettings.Builder<GenerateAccessTokenRequest, GenerateAccessTokenResponse>
        generateAccessTokenSettings() {
      return getStubSettingsBuilder().generateAccessTokenSettings();
    }

    /** Returns the builder for the settings used for calls to listNodePools. */
    public PagedCallSettings.Builder<
            ListNodePoolsRequest, ListNodePoolsResponse, ListNodePoolsPagedResponse>
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

    /** Returns the builder for the settings used for calls to createNodePool. */
    public OperationCallSettings.Builder<CreateNodePoolRequest, NodePool, OperationMetadata>
        createNodePoolOperationSettings() {
      return getStubSettingsBuilder().createNodePoolOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateNodePool. */
    public UnaryCallSettings.Builder<UpdateNodePoolRequest, Operation> updateNodePoolSettings() {
      return getStubSettingsBuilder().updateNodePoolSettings();
    }

    /** Returns the builder for the settings used for calls to updateNodePool. */
    public OperationCallSettings.Builder<UpdateNodePoolRequest, NodePool, OperationMetadata>
        updateNodePoolOperationSettings() {
      return getStubSettingsBuilder().updateNodePoolOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteNodePool. */
    public UnaryCallSettings.Builder<DeleteNodePoolRequest, Operation> deleteNodePoolSettings() {
      return getStubSettingsBuilder().deleteNodePoolSettings();
    }

    /** Returns the builder for the settings used for calls to deleteNodePool. */
    public OperationCallSettings.Builder<DeleteNodePoolRequest, Empty, OperationMetadata>
        deleteNodePoolOperationSettings() {
      return getStubSettingsBuilder().deleteNodePoolOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listMachines. */
    public PagedCallSettings.Builder<
            ListMachinesRequest, ListMachinesResponse, ListMachinesPagedResponse>
        listMachinesSettings() {
      return getStubSettingsBuilder().listMachinesSettings();
    }

    /** Returns the builder for the settings used for calls to getMachine. */
    public UnaryCallSettings.Builder<GetMachineRequest, Machine> getMachineSettings() {
      return getStubSettingsBuilder().getMachineSettings();
    }

    /** Returns the builder for the settings used for calls to listVpnConnections. */
    public PagedCallSettings.Builder<
            ListVpnConnectionsRequest, ListVpnConnectionsResponse, ListVpnConnectionsPagedResponse>
        listVpnConnectionsSettings() {
      return getStubSettingsBuilder().listVpnConnectionsSettings();
    }

    /** Returns the builder for the settings used for calls to getVpnConnection. */
    public UnaryCallSettings.Builder<GetVpnConnectionRequest, VpnConnection>
        getVpnConnectionSettings() {
      return getStubSettingsBuilder().getVpnConnectionSettings();
    }

    /** Returns the builder for the settings used for calls to createVpnConnection. */
    public UnaryCallSettings.Builder<CreateVpnConnectionRequest, Operation>
        createVpnConnectionSettings() {
      return getStubSettingsBuilder().createVpnConnectionSettings();
    }

    /** Returns the builder for the settings used for calls to createVpnConnection. */
    public OperationCallSettings.Builder<
            CreateVpnConnectionRequest, VpnConnection, OperationMetadata>
        createVpnConnectionOperationSettings() {
      return getStubSettingsBuilder().createVpnConnectionOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteVpnConnection. */
    public UnaryCallSettings.Builder<DeleteVpnConnectionRequest, Operation>
        deleteVpnConnectionSettings() {
      return getStubSettingsBuilder().deleteVpnConnectionSettings();
    }

    /** Returns the builder for the settings used for calls to deleteVpnConnection. */
    public OperationCallSettings.Builder<DeleteVpnConnectionRequest, Empty, OperationMetadata>
        deleteVpnConnectionOperationSettings() {
      return getStubSettingsBuilder().deleteVpnConnectionOperationSettings();
    }

    @Override
    public EdgeContainerSettings build() throws IOException {
      return new EdgeContainerSettings(this);
    }
  }
}
