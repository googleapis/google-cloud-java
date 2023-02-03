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

package com.google.cloud.gkemulticloud.v1;

import static com.google.cloud.gkemulticloud.v1.AzureClustersClient.ListAzureClientsPagedResponse;
import static com.google.cloud.gkemulticloud.v1.AzureClustersClient.ListAzureClustersPagedResponse;
import static com.google.cloud.gkemulticloud.v1.AzureClustersClient.ListAzureNodePoolsPagedResponse;

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
import com.google.cloud.gkemulticloud.v1.stub.AzureClustersStubSettings;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link AzureClustersClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (gkemulticloud.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getAzureClient to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * AzureClustersSettings.Builder azureClustersSettingsBuilder = AzureClustersSettings.newBuilder();
 * azureClustersSettingsBuilder
 *     .getAzureClientSettings()
 *     .setRetrySettings(
 *         azureClustersSettingsBuilder
 *             .getAzureClientSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * AzureClustersSettings azureClustersSettings = azureClustersSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class AzureClustersSettings extends ClientSettings<AzureClustersSettings> {

  /** Returns the object with the settings used for calls to createAzureClient. */
  public UnaryCallSettings<CreateAzureClientRequest, Operation> createAzureClientSettings() {
    return ((AzureClustersStubSettings) getStubSettings()).createAzureClientSettings();
  }

  /** Returns the object with the settings used for calls to createAzureClient. */
  public OperationCallSettings<CreateAzureClientRequest, AzureClient, OperationMetadata>
      createAzureClientOperationSettings() {
    return ((AzureClustersStubSettings) getStubSettings()).createAzureClientOperationSettings();
  }

  /** Returns the object with the settings used for calls to getAzureClient. */
  public UnaryCallSettings<GetAzureClientRequest, AzureClient> getAzureClientSettings() {
    return ((AzureClustersStubSettings) getStubSettings()).getAzureClientSettings();
  }

  /** Returns the object with the settings used for calls to listAzureClients. */
  public PagedCallSettings<
          ListAzureClientsRequest, ListAzureClientsResponse, ListAzureClientsPagedResponse>
      listAzureClientsSettings() {
    return ((AzureClustersStubSettings) getStubSettings()).listAzureClientsSettings();
  }

  /** Returns the object with the settings used for calls to deleteAzureClient. */
  public UnaryCallSettings<DeleteAzureClientRequest, Operation> deleteAzureClientSettings() {
    return ((AzureClustersStubSettings) getStubSettings()).deleteAzureClientSettings();
  }

  /** Returns the object with the settings used for calls to deleteAzureClient. */
  public OperationCallSettings<DeleteAzureClientRequest, Empty, OperationMetadata>
      deleteAzureClientOperationSettings() {
    return ((AzureClustersStubSettings) getStubSettings()).deleteAzureClientOperationSettings();
  }

  /** Returns the object with the settings used for calls to createAzureCluster. */
  public UnaryCallSettings<CreateAzureClusterRequest, Operation> createAzureClusterSettings() {
    return ((AzureClustersStubSettings) getStubSettings()).createAzureClusterSettings();
  }

  /** Returns the object with the settings used for calls to createAzureCluster. */
  public OperationCallSettings<CreateAzureClusterRequest, AzureCluster, OperationMetadata>
      createAzureClusterOperationSettings() {
    return ((AzureClustersStubSettings) getStubSettings()).createAzureClusterOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateAzureCluster. */
  public UnaryCallSettings<UpdateAzureClusterRequest, Operation> updateAzureClusterSettings() {
    return ((AzureClustersStubSettings) getStubSettings()).updateAzureClusterSettings();
  }

  /** Returns the object with the settings used for calls to updateAzureCluster. */
  public OperationCallSettings<UpdateAzureClusterRequest, AzureCluster, OperationMetadata>
      updateAzureClusterOperationSettings() {
    return ((AzureClustersStubSettings) getStubSettings()).updateAzureClusterOperationSettings();
  }

  /** Returns the object with the settings used for calls to getAzureCluster. */
  public UnaryCallSettings<GetAzureClusterRequest, AzureCluster> getAzureClusterSettings() {
    return ((AzureClustersStubSettings) getStubSettings()).getAzureClusterSettings();
  }

  /** Returns the object with the settings used for calls to listAzureClusters. */
  public PagedCallSettings<
          ListAzureClustersRequest, ListAzureClustersResponse, ListAzureClustersPagedResponse>
      listAzureClustersSettings() {
    return ((AzureClustersStubSettings) getStubSettings()).listAzureClustersSettings();
  }

  /** Returns the object with the settings used for calls to deleteAzureCluster. */
  public UnaryCallSettings<DeleteAzureClusterRequest, Operation> deleteAzureClusterSettings() {
    return ((AzureClustersStubSettings) getStubSettings()).deleteAzureClusterSettings();
  }

  /** Returns the object with the settings used for calls to deleteAzureCluster. */
  public OperationCallSettings<DeleteAzureClusterRequest, Empty, OperationMetadata>
      deleteAzureClusterOperationSettings() {
    return ((AzureClustersStubSettings) getStubSettings()).deleteAzureClusterOperationSettings();
  }

  /** Returns the object with the settings used for calls to generateAzureAccessToken. */
  public UnaryCallSettings<GenerateAzureAccessTokenRequest, GenerateAzureAccessTokenResponse>
      generateAzureAccessTokenSettings() {
    return ((AzureClustersStubSettings) getStubSettings()).generateAzureAccessTokenSettings();
  }

  /** Returns the object with the settings used for calls to createAzureNodePool. */
  public UnaryCallSettings<CreateAzureNodePoolRequest, Operation> createAzureNodePoolSettings() {
    return ((AzureClustersStubSettings) getStubSettings()).createAzureNodePoolSettings();
  }

  /** Returns the object with the settings used for calls to createAzureNodePool. */
  public OperationCallSettings<CreateAzureNodePoolRequest, AzureNodePool, OperationMetadata>
      createAzureNodePoolOperationSettings() {
    return ((AzureClustersStubSettings) getStubSettings()).createAzureNodePoolOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateAzureNodePool. */
  public UnaryCallSettings<UpdateAzureNodePoolRequest, Operation> updateAzureNodePoolSettings() {
    return ((AzureClustersStubSettings) getStubSettings()).updateAzureNodePoolSettings();
  }

  /** Returns the object with the settings used for calls to updateAzureNodePool. */
  public OperationCallSettings<UpdateAzureNodePoolRequest, AzureNodePool, OperationMetadata>
      updateAzureNodePoolOperationSettings() {
    return ((AzureClustersStubSettings) getStubSettings()).updateAzureNodePoolOperationSettings();
  }

  /** Returns the object with the settings used for calls to getAzureNodePool. */
  public UnaryCallSettings<GetAzureNodePoolRequest, AzureNodePool> getAzureNodePoolSettings() {
    return ((AzureClustersStubSettings) getStubSettings()).getAzureNodePoolSettings();
  }

  /** Returns the object with the settings used for calls to listAzureNodePools. */
  public PagedCallSettings<
          ListAzureNodePoolsRequest, ListAzureNodePoolsResponse, ListAzureNodePoolsPagedResponse>
      listAzureNodePoolsSettings() {
    return ((AzureClustersStubSettings) getStubSettings()).listAzureNodePoolsSettings();
  }

  /** Returns the object with the settings used for calls to deleteAzureNodePool. */
  public UnaryCallSettings<DeleteAzureNodePoolRequest, Operation> deleteAzureNodePoolSettings() {
    return ((AzureClustersStubSettings) getStubSettings()).deleteAzureNodePoolSettings();
  }

  /** Returns the object with the settings used for calls to deleteAzureNodePool. */
  public OperationCallSettings<DeleteAzureNodePoolRequest, Empty, OperationMetadata>
      deleteAzureNodePoolOperationSettings() {
    return ((AzureClustersStubSettings) getStubSettings()).deleteAzureNodePoolOperationSettings();
  }

  /** Returns the object with the settings used for calls to getAzureServerConfig. */
  public UnaryCallSettings<GetAzureServerConfigRequest, AzureServerConfig>
      getAzureServerConfigSettings() {
    return ((AzureClustersStubSettings) getStubSettings()).getAzureServerConfigSettings();
  }

  public static final AzureClustersSettings create(AzureClustersStubSettings stub)
      throws IOException {
    return new AzureClustersSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return AzureClustersStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return AzureClustersStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return AzureClustersStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return AzureClustersStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return AzureClustersStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return AzureClustersStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return AzureClustersStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return AzureClustersStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected AzureClustersSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for AzureClustersSettings. */
  public static class Builder extends ClientSettings.Builder<AzureClustersSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(AzureClustersStubSettings.newBuilder(clientContext));
    }

    protected Builder(AzureClustersSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(AzureClustersStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(AzureClustersStubSettings.newBuilder());
    }

    @BetaApi
    private static Builder createHttpJsonDefault() {
      return new Builder(AzureClustersStubSettings.newHttpJsonBuilder());
    }

    public AzureClustersStubSettings.Builder getStubSettingsBuilder() {
      return ((AzureClustersStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to createAzureClient. */
    public UnaryCallSettings.Builder<CreateAzureClientRequest, Operation>
        createAzureClientSettings() {
      return getStubSettingsBuilder().createAzureClientSettings();
    }

    /** Returns the builder for the settings used for calls to createAzureClient. */
    public OperationCallSettings.Builder<CreateAzureClientRequest, AzureClient, OperationMetadata>
        createAzureClientOperationSettings() {
      return getStubSettingsBuilder().createAzureClientOperationSettings();
    }

    /** Returns the builder for the settings used for calls to getAzureClient. */
    public UnaryCallSettings.Builder<GetAzureClientRequest, AzureClient> getAzureClientSettings() {
      return getStubSettingsBuilder().getAzureClientSettings();
    }

    /** Returns the builder for the settings used for calls to listAzureClients. */
    public PagedCallSettings.Builder<
            ListAzureClientsRequest, ListAzureClientsResponse, ListAzureClientsPagedResponse>
        listAzureClientsSettings() {
      return getStubSettingsBuilder().listAzureClientsSettings();
    }

    /** Returns the builder for the settings used for calls to deleteAzureClient. */
    public UnaryCallSettings.Builder<DeleteAzureClientRequest, Operation>
        deleteAzureClientSettings() {
      return getStubSettingsBuilder().deleteAzureClientSettings();
    }

    /** Returns the builder for the settings used for calls to deleteAzureClient. */
    public OperationCallSettings.Builder<DeleteAzureClientRequest, Empty, OperationMetadata>
        deleteAzureClientOperationSettings() {
      return getStubSettingsBuilder().deleteAzureClientOperationSettings();
    }

    /** Returns the builder for the settings used for calls to createAzureCluster. */
    public UnaryCallSettings.Builder<CreateAzureClusterRequest, Operation>
        createAzureClusterSettings() {
      return getStubSettingsBuilder().createAzureClusterSettings();
    }

    /** Returns the builder for the settings used for calls to createAzureCluster. */
    public OperationCallSettings.Builder<CreateAzureClusterRequest, AzureCluster, OperationMetadata>
        createAzureClusterOperationSettings() {
      return getStubSettingsBuilder().createAzureClusterOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateAzureCluster. */
    public UnaryCallSettings.Builder<UpdateAzureClusterRequest, Operation>
        updateAzureClusterSettings() {
      return getStubSettingsBuilder().updateAzureClusterSettings();
    }

    /** Returns the builder for the settings used for calls to updateAzureCluster. */
    public OperationCallSettings.Builder<UpdateAzureClusterRequest, AzureCluster, OperationMetadata>
        updateAzureClusterOperationSettings() {
      return getStubSettingsBuilder().updateAzureClusterOperationSettings();
    }

    /** Returns the builder for the settings used for calls to getAzureCluster. */
    public UnaryCallSettings.Builder<GetAzureClusterRequest, AzureCluster>
        getAzureClusterSettings() {
      return getStubSettingsBuilder().getAzureClusterSettings();
    }

    /** Returns the builder for the settings used for calls to listAzureClusters. */
    public PagedCallSettings.Builder<
            ListAzureClustersRequest, ListAzureClustersResponse, ListAzureClustersPagedResponse>
        listAzureClustersSettings() {
      return getStubSettingsBuilder().listAzureClustersSettings();
    }

    /** Returns the builder for the settings used for calls to deleteAzureCluster. */
    public UnaryCallSettings.Builder<DeleteAzureClusterRequest, Operation>
        deleteAzureClusterSettings() {
      return getStubSettingsBuilder().deleteAzureClusterSettings();
    }

    /** Returns the builder for the settings used for calls to deleteAzureCluster. */
    public OperationCallSettings.Builder<DeleteAzureClusterRequest, Empty, OperationMetadata>
        deleteAzureClusterOperationSettings() {
      return getStubSettingsBuilder().deleteAzureClusterOperationSettings();
    }

    /** Returns the builder for the settings used for calls to generateAzureAccessToken. */
    public UnaryCallSettings.Builder<
            GenerateAzureAccessTokenRequest, GenerateAzureAccessTokenResponse>
        generateAzureAccessTokenSettings() {
      return getStubSettingsBuilder().generateAzureAccessTokenSettings();
    }

    /** Returns the builder for the settings used for calls to createAzureNodePool. */
    public UnaryCallSettings.Builder<CreateAzureNodePoolRequest, Operation>
        createAzureNodePoolSettings() {
      return getStubSettingsBuilder().createAzureNodePoolSettings();
    }

    /** Returns the builder for the settings used for calls to createAzureNodePool. */
    public OperationCallSettings.Builder<
            CreateAzureNodePoolRequest, AzureNodePool, OperationMetadata>
        createAzureNodePoolOperationSettings() {
      return getStubSettingsBuilder().createAzureNodePoolOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateAzureNodePool. */
    public UnaryCallSettings.Builder<UpdateAzureNodePoolRequest, Operation>
        updateAzureNodePoolSettings() {
      return getStubSettingsBuilder().updateAzureNodePoolSettings();
    }

    /** Returns the builder for the settings used for calls to updateAzureNodePool. */
    public OperationCallSettings.Builder<
            UpdateAzureNodePoolRequest, AzureNodePool, OperationMetadata>
        updateAzureNodePoolOperationSettings() {
      return getStubSettingsBuilder().updateAzureNodePoolOperationSettings();
    }

    /** Returns the builder for the settings used for calls to getAzureNodePool. */
    public UnaryCallSettings.Builder<GetAzureNodePoolRequest, AzureNodePool>
        getAzureNodePoolSettings() {
      return getStubSettingsBuilder().getAzureNodePoolSettings();
    }

    /** Returns the builder for the settings used for calls to listAzureNodePools. */
    public PagedCallSettings.Builder<
            ListAzureNodePoolsRequest, ListAzureNodePoolsResponse, ListAzureNodePoolsPagedResponse>
        listAzureNodePoolsSettings() {
      return getStubSettingsBuilder().listAzureNodePoolsSettings();
    }

    /** Returns the builder for the settings used for calls to deleteAzureNodePool. */
    public UnaryCallSettings.Builder<DeleteAzureNodePoolRequest, Operation>
        deleteAzureNodePoolSettings() {
      return getStubSettingsBuilder().deleteAzureNodePoolSettings();
    }

    /** Returns the builder for the settings used for calls to deleteAzureNodePool. */
    public OperationCallSettings.Builder<DeleteAzureNodePoolRequest, Empty, OperationMetadata>
        deleteAzureNodePoolOperationSettings() {
      return getStubSettingsBuilder().deleteAzureNodePoolOperationSettings();
    }

    /** Returns the builder for the settings used for calls to getAzureServerConfig. */
    public UnaryCallSettings.Builder<GetAzureServerConfigRequest, AzureServerConfig>
        getAzureServerConfigSettings() {
      return getStubSettingsBuilder().getAzureServerConfigSettings();
    }

    @Override
    public AzureClustersSettings build() throws IOException {
      return new AzureClustersSettings(this);
    }
  }
}
