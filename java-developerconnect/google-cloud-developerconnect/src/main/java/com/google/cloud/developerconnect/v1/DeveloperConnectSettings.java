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

package com.google.cloud.developerconnect.v1;

import static com.google.cloud.developerconnect.v1.DeveloperConnectClient.FetchGitRefsPagedResponse;
import static com.google.cloud.developerconnect.v1.DeveloperConnectClient.FetchLinkableGitRepositoriesPagedResponse;
import static com.google.cloud.developerconnect.v1.DeveloperConnectClient.ListConnectionsPagedResponse;
import static com.google.cloud.developerconnect.v1.DeveloperConnectClient.ListGitRepositoryLinksPagedResponse;
import static com.google.cloud.developerconnect.v1.DeveloperConnectClient.ListLocationsPagedResponse;

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
import com.google.cloud.developerconnect.v1.stub.DeveloperConnectStubSettings;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link DeveloperConnectClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (developerconnect.googleapis.com) and default port (443) are
 *       used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getConnection to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * DeveloperConnectSettings.Builder developerConnectSettingsBuilder =
 *     DeveloperConnectSettings.newBuilder();
 * developerConnectSettingsBuilder
 *     .getConnectionSettings()
 *     .setRetrySettings(
 *         developerConnectSettingsBuilder
 *             .getConnectionSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * DeveloperConnectSettings developerConnectSettings = developerConnectSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class DeveloperConnectSettings extends ClientSettings<DeveloperConnectSettings> {

  /** Returns the object with the settings used for calls to listConnections. */
  public PagedCallSettings<
          ListConnectionsRequest, ListConnectionsResponse, ListConnectionsPagedResponse>
      listConnectionsSettings() {
    return ((DeveloperConnectStubSettings) getStubSettings()).listConnectionsSettings();
  }

  /** Returns the object with the settings used for calls to getConnection. */
  public UnaryCallSettings<GetConnectionRequest, Connection> getConnectionSettings() {
    return ((DeveloperConnectStubSettings) getStubSettings()).getConnectionSettings();
  }

  /** Returns the object with the settings used for calls to createConnection. */
  public UnaryCallSettings<CreateConnectionRequest, Operation> createConnectionSettings() {
    return ((DeveloperConnectStubSettings) getStubSettings()).createConnectionSettings();
  }

  /** Returns the object with the settings used for calls to createConnection. */
  public OperationCallSettings<CreateConnectionRequest, Connection, OperationMetadata>
      createConnectionOperationSettings() {
    return ((DeveloperConnectStubSettings) getStubSettings()).createConnectionOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateConnection. */
  public UnaryCallSettings<UpdateConnectionRequest, Operation> updateConnectionSettings() {
    return ((DeveloperConnectStubSettings) getStubSettings()).updateConnectionSettings();
  }

  /** Returns the object with the settings used for calls to updateConnection. */
  public OperationCallSettings<UpdateConnectionRequest, Connection, OperationMetadata>
      updateConnectionOperationSettings() {
    return ((DeveloperConnectStubSettings) getStubSettings()).updateConnectionOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteConnection. */
  public UnaryCallSettings<DeleteConnectionRequest, Operation> deleteConnectionSettings() {
    return ((DeveloperConnectStubSettings) getStubSettings()).deleteConnectionSettings();
  }

  /** Returns the object with the settings used for calls to deleteConnection. */
  public OperationCallSettings<DeleteConnectionRequest, Empty, OperationMetadata>
      deleteConnectionOperationSettings() {
    return ((DeveloperConnectStubSettings) getStubSettings()).deleteConnectionOperationSettings();
  }

  /** Returns the object with the settings used for calls to createGitRepositoryLink. */
  public UnaryCallSettings<CreateGitRepositoryLinkRequest, Operation>
      createGitRepositoryLinkSettings() {
    return ((DeveloperConnectStubSettings) getStubSettings()).createGitRepositoryLinkSettings();
  }

  /** Returns the object with the settings used for calls to createGitRepositoryLink. */
  public OperationCallSettings<CreateGitRepositoryLinkRequest, GitRepositoryLink, OperationMetadata>
      createGitRepositoryLinkOperationSettings() {
    return ((DeveloperConnectStubSettings) getStubSettings())
        .createGitRepositoryLinkOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteGitRepositoryLink. */
  public UnaryCallSettings<DeleteGitRepositoryLinkRequest, Operation>
      deleteGitRepositoryLinkSettings() {
    return ((DeveloperConnectStubSettings) getStubSettings()).deleteGitRepositoryLinkSettings();
  }

  /** Returns the object with the settings used for calls to deleteGitRepositoryLink. */
  public OperationCallSettings<DeleteGitRepositoryLinkRequest, Empty, OperationMetadata>
      deleteGitRepositoryLinkOperationSettings() {
    return ((DeveloperConnectStubSettings) getStubSettings())
        .deleteGitRepositoryLinkOperationSettings();
  }

  /** Returns the object with the settings used for calls to listGitRepositoryLinks. */
  public PagedCallSettings<
          ListGitRepositoryLinksRequest,
          ListGitRepositoryLinksResponse,
          ListGitRepositoryLinksPagedResponse>
      listGitRepositoryLinksSettings() {
    return ((DeveloperConnectStubSettings) getStubSettings()).listGitRepositoryLinksSettings();
  }

  /** Returns the object with the settings used for calls to getGitRepositoryLink. */
  public UnaryCallSettings<GetGitRepositoryLinkRequest, GitRepositoryLink>
      getGitRepositoryLinkSettings() {
    return ((DeveloperConnectStubSettings) getStubSettings()).getGitRepositoryLinkSettings();
  }

  /** Returns the object with the settings used for calls to fetchReadWriteToken. */
  public UnaryCallSettings<FetchReadWriteTokenRequest, FetchReadWriteTokenResponse>
      fetchReadWriteTokenSettings() {
    return ((DeveloperConnectStubSettings) getStubSettings()).fetchReadWriteTokenSettings();
  }

  /** Returns the object with the settings used for calls to fetchReadToken. */
  public UnaryCallSettings<FetchReadTokenRequest, FetchReadTokenResponse> fetchReadTokenSettings() {
    return ((DeveloperConnectStubSettings) getStubSettings()).fetchReadTokenSettings();
  }

  /** Returns the object with the settings used for calls to fetchLinkableGitRepositories. */
  public PagedCallSettings<
          FetchLinkableGitRepositoriesRequest,
          FetchLinkableGitRepositoriesResponse,
          FetchLinkableGitRepositoriesPagedResponse>
      fetchLinkableGitRepositoriesSettings() {
    return ((DeveloperConnectStubSettings) getStubSettings())
        .fetchLinkableGitRepositoriesSettings();
  }

  /** Returns the object with the settings used for calls to fetchGitHubInstallations. */
  public UnaryCallSettings<FetchGitHubInstallationsRequest, FetchGitHubInstallationsResponse>
      fetchGitHubInstallationsSettings() {
    return ((DeveloperConnectStubSettings) getStubSettings()).fetchGitHubInstallationsSettings();
  }

  /** Returns the object with the settings used for calls to fetchGitRefs. */
  public PagedCallSettings<FetchGitRefsRequest, FetchGitRefsResponse, FetchGitRefsPagedResponse>
      fetchGitRefsSettings() {
    return ((DeveloperConnectStubSettings) getStubSettings()).fetchGitRefsSettings();
  }

  /** Returns the object with the settings used for calls to listLocations. */
  public PagedCallSettings<ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings() {
    return ((DeveloperConnectStubSettings) getStubSettings()).listLocationsSettings();
  }

  /** Returns the object with the settings used for calls to getLocation. */
  public UnaryCallSettings<GetLocationRequest, Location> getLocationSettings() {
    return ((DeveloperConnectStubSettings) getStubSettings()).getLocationSettings();
  }

  public static final DeveloperConnectSettings create(DeveloperConnectStubSettings stub)
      throws IOException {
    return new DeveloperConnectSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return DeveloperConnectStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return DeveloperConnectStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return DeveloperConnectStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return DeveloperConnectStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return DeveloperConnectStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return DeveloperConnectStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return DeveloperConnectStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return DeveloperConnectStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected DeveloperConnectSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for DeveloperConnectSettings. */
  public static class Builder extends ClientSettings.Builder<DeveloperConnectSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(DeveloperConnectStubSettings.newBuilder(clientContext));
    }

    protected Builder(DeveloperConnectSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(DeveloperConnectStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(DeveloperConnectStubSettings.newBuilder());
    }

    private static Builder createHttpJsonDefault() {
      return new Builder(DeveloperConnectStubSettings.newHttpJsonBuilder());
    }

    public DeveloperConnectStubSettings.Builder getStubSettingsBuilder() {
      return ((DeveloperConnectStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to listConnections. */
    public PagedCallSettings.Builder<
            ListConnectionsRequest, ListConnectionsResponse, ListConnectionsPagedResponse>
        listConnectionsSettings() {
      return getStubSettingsBuilder().listConnectionsSettings();
    }

    /** Returns the builder for the settings used for calls to getConnection. */
    public UnaryCallSettings.Builder<GetConnectionRequest, Connection> getConnectionSettings() {
      return getStubSettingsBuilder().getConnectionSettings();
    }

    /** Returns the builder for the settings used for calls to createConnection. */
    public UnaryCallSettings.Builder<CreateConnectionRequest, Operation>
        createConnectionSettings() {
      return getStubSettingsBuilder().createConnectionSettings();
    }

    /** Returns the builder for the settings used for calls to createConnection. */
    public OperationCallSettings.Builder<CreateConnectionRequest, Connection, OperationMetadata>
        createConnectionOperationSettings() {
      return getStubSettingsBuilder().createConnectionOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateConnection. */
    public UnaryCallSettings.Builder<UpdateConnectionRequest, Operation>
        updateConnectionSettings() {
      return getStubSettingsBuilder().updateConnectionSettings();
    }

    /** Returns the builder for the settings used for calls to updateConnection. */
    public OperationCallSettings.Builder<UpdateConnectionRequest, Connection, OperationMetadata>
        updateConnectionOperationSettings() {
      return getStubSettingsBuilder().updateConnectionOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteConnection. */
    public UnaryCallSettings.Builder<DeleteConnectionRequest, Operation>
        deleteConnectionSettings() {
      return getStubSettingsBuilder().deleteConnectionSettings();
    }

    /** Returns the builder for the settings used for calls to deleteConnection. */
    public OperationCallSettings.Builder<DeleteConnectionRequest, Empty, OperationMetadata>
        deleteConnectionOperationSettings() {
      return getStubSettingsBuilder().deleteConnectionOperationSettings();
    }

    /** Returns the builder for the settings used for calls to createGitRepositoryLink. */
    public UnaryCallSettings.Builder<CreateGitRepositoryLinkRequest, Operation>
        createGitRepositoryLinkSettings() {
      return getStubSettingsBuilder().createGitRepositoryLinkSettings();
    }

    /** Returns the builder for the settings used for calls to createGitRepositoryLink. */
    public OperationCallSettings.Builder<
            CreateGitRepositoryLinkRequest, GitRepositoryLink, OperationMetadata>
        createGitRepositoryLinkOperationSettings() {
      return getStubSettingsBuilder().createGitRepositoryLinkOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteGitRepositoryLink. */
    public UnaryCallSettings.Builder<DeleteGitRepositoryLinkRequest, Operation>
        deleteGitRepositoryLinkSettings() {
      return getStubSettingsBuilder().deleteGitRepositoryLinkSettings();
    }

    /** Returns the builder for the settings used for calls to deleteGitRepositoryLink. */
    public OperationCallSettings.Builder<DeleteGitRepositoryLinkRequest, Empty, OperationMetadata>
        deleteGitRepositoryLinkOperationSettings() {
      return getStubSettingsBuilder().deleteGitRepositoryLinkOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listGitRepositoryLinks. */
    public PagedCallSettings.Builder<
            ListGitRepositoryLinksRequest,
            ListGitRepositoryLinksResponse,
            ListGitRepositoryLinksPagedResponse>
        listGitRepositoryLinksSettings() {
      return getStubSettingsBuilder().listGitRepositoryLinksSettings();
    }

    /** Returns the builder for the settings used for calls to getGitRepositoryLink. */
    public UnaryCallSettings.Builder<GetGitRepositoryLinkRequest, GitRepositoryLink>
        getGitRepositoryLinkSettings() {
      return getStubSettingsBuilder().getGitRepositoryLinkSettings();
    }

    /** Returns the builder for the settings used for calls to fetchReadWriteToken. */
    public UnaryCallSettings.Builder<FetchReadWriteTokenRequest, FetchReadWriteTokenResponse>
        fetchReadWriteTokenSettings() {
      return getStubSettingsBuilder().fetchReadWriteTokenSettings();
    }

    /** Returns the builder for the settings used for calls to fetchReadToken. */
    public UnaryCallSettings.Builder<FetchReadTokenRequest, FetchReadTokenResponse>
        fetchReadTokenSettings() {
      return getStubSettingsBuilder().fetchReadTokenSettings();
    }

    /** Returns the builder for the settings used for calls to fetchLinkableGitRepositories. */
    public PagedCallSettings.Builder<
            FetchLinkableGitRepositoriesRequest,
            FetchLinkableGitRepositoriesResponse,
            FetchLinkableGitRepositoriesPagedResponse>
        fetchLinkableGitRepositoriesSettings() {
      return getStubSettingsBuilder().fetchLinkableGitRepositoriesSettings();
    }

    /** Returns the builder for the settings used for calls to fetchGitHubInstallations. */
    public UnaryCallSettings.Builder<
            FetchGitHubInstallationsRequest, FetchGitHubInstallationsResponse>
        fetchGitHubInstallationsSettings() {
      return getStubSettingsBuilder().fetchGitHubInstallationsSettings();
    }

    /** Returns the builder for the settings used for calls to fetchGitRefs. */
    public PagedCallSettings.Builder<
            FetchGitRefsRequest, FetchGitRefsResponse, FetchGitRefsPagedResponse>
        fetchGitRefsSettings() {
      return getStubSettingsBuilder().fetchGitRefsSettings();
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

    @Override
    public DeveloperConnectSettings build() throws IOException {
      return new DeveloperConnectSettings(this);
    }
  }
}
