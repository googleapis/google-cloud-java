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

package com.google.cloud.devtools.cloudbuild.v2;

import static com.google.cloud.devtools.cloudbuild.v2.RepositoryManagerClient.FetchLinkableRepositoriesPagedResponse;
import static com.google.cloud.devtools.cloudbuild.v2.RepositoryManagerClient.ListConnectionsPagedResponse;
import static com.google.cloud.devtools.cloudbuild.v2.RepositoryManagerClient.ListRepositoriesPagedResponse;

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
import com.google.cloud.devtools.cloudbuild.v2.stub.RepositoryManagerStubSettings;
import com.google.cloudbuild.v2.BatchCreateRepositoriesRequest;
import com.google.cloudbuild.v2.BatchCreateRepositoriesResponse;
import com.google.cloudbuild.v2.Connection;
import com.google.cloudbuild.v2.CreateConnectionRequest;
import com.google.cloudbuild.v2.CreateRepositoryRequest;
import com.google.cloudbuild.v2.DeleteConnectionRequest;
import com.google.cloudbuild.v2.DeleteRepositoryRequest;
import com.google.cloudbuild.v2.FetchGitRefsRequest;
import com.google.cloudbuild.v2.FetchGitRefsResponse;
import com.google.cloudbuild.v2.FetchLinkableRepositoriesRequest;
import com.google.cloudbuild.v2.FetchLinkableRepositoriesResponse;
import com.google.cloudbuild.v2.FetchReadTokenRequest;
import com.google.cloudbuild.v2.FetchReadTokenResponse;
import com.google.cloudbuild.v2.FetchReadWriteTokenRequest;
import com.google.cloudbuild.v2.FetchReadWriteTokenResponse;
import com.google.cloudbuild.v2.GetConnectionRequest;
import com.google.cloudbuild.v2.GetRepositoryRequest;
import com.google.cloudbuild.v2.ListConnectionsRequest;
import com.google.cloudbuild.v2.ListConnectionsResponse;
import com.google.cloudbuild.v2.ListRepositoriesRequest;
import com.google.cloudbuild.v2.ListRepositoriesResponse;
import com.google.cloudbuild.v2.OperationMetadata;
import com.google.cloudbuild.v2.Repository;
import com.google.cloudbuild.v2.UpdateConnectionRequest;
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
 * Settings class to configure an instance of {@link RepositoryManagerClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (cloudbuild.googleapis.com) and default port (443) are used.
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
 * RepositoryManagerSettings.Builder repositoryManagerSettingsBuilder =
 *     RepositoryManagerSettings.newBuilder();
 * repositoryManagerSettingsBuilder
 *     .getConnectionSettings()
 *     .setRetrySettings(
 *         repositoryManagerSettingsBuilder
 *             .getConnectionSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * RepositoryManagerSettings repositoryManagerSettings = repositoryManagerSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class RepositoryManagerSettings extends ClientSettings<RepositoryManagerSettings> {

  /** Returns the object with the settings used for calls to createConnection. */
  public UnaryCallSettings<CreateConnectionRequest, Operation> createConnectionSettings() {
    return ((RepositoryManagerStubSettings) getStubSettings()).createConnectionSettings();
  }

  /** Returns the object with the settings used for calls to createConnection. */
  public OperationCallSettings<CreateConnectionRequest, Connection, OperationMetadata>
      createConnectionOperationSettings() {
    return ((RepositoryManagerStubSettings) getStubSettings()).createConnectionOperationSettings();
  }

  /** Returns the object with the settings used for calls to getConnection. */
  public UnaryCallSettings<GetConnectionRequest, Connection> getConnectionSettings() {
    return ((RepositoryManagerStubSettings) getStubSettings()).getConnectionSettings();
  }

  /** Returns the object with the settings used for calls to listConnections. */
  public PagedCallSettings<
          ListConnectionsRequest, ListConnectionsResponse, ListConnectionsPagedResponse>
      listConnectionsSettings() {
    return ((RepositoryManagerStubSettings) getStubSettings()).listConnectionsSettings();
  }

  /** Returns the object with the settings used for calls to updateConnection. */
  public UnaryCallSettings<UpdateConnectionRequest, Operation> updateConnectionSettings() {
    return ((RepositoryManagerStubSettings) getStubSettings()).updateConnectionSettings();
  }

  /** Returns the object with the settings used for calls to updateConnection. */
  public OperationCallSettings<UpdateConnectionRequest, Connection, OperationMetadata>
      updateConnectionOperationSettings() {
    return ((RepositoryManagerStubSettings) getStubSettings()).updateConnectionOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteConnection. */
  public UnaryCallSettings<DeleteConnectionRequest, Operation> deleteConnectionSettings() {
    return ((RepositoryManagerStubSettings) getStubSettings()).deleteConnectionSettings();
  }

  /** Returns the object with the settings used for calls to deleteConnection. */
  public OperationCallSettings<DeleteConnectionRequest, Empty, OperationMetadata>
      deleteConnectionOperationSettings() {
    return ((RepositoryManagerStubSettings) getStubSettings()).deleteConnectionOperationSettings();
  }

  /** Returns the object with the settings used for calls to createRepository. */
  public UnaryCallSettings<CreateRepositoryRequest, Operation> createRepositorySettings() {
    return ((RepositoryManagerStubSettings) getStubSettings()).createRepositorySettings();
  }

  /** Returns the object with the settings used for calls to createRepository. */
  public OperationCallSettings<CreateRepositoryRequest, Repository, OperationMetadata>
      createRepositoryOperationSettings() {
    return ((RepositoryManagerStubSettings) getStubSettings()).createRepositoryOperationSettings();
  }

  /** Returns the object with the settings used for calls to batchCreateRepositories. */
  public UnaryCallSettings<BatchCreateRepositoriesRequest, Operation>
      batchCreateRepositoriesSettings() {
    return ((RepositoryManagerStubSettings) getStubSettings()).batchCreateRepositoriesSettings();
  }

  /** Returns the object with the settings used for calls to batchCreateRepositories. */
  public OperationCallSettings<
          BatchCreateRepositoriesRequest, BatchCreateRepositoriesResponse, OperationMetadata>
      batchCreateRepositoriesOperationSettings() {
    return ((RepositoryManagerStubSettings) getStubSettings())
        .batchCreateRepositoriesOperationSettings();
  }

  /** Returns the object with the settings used for calls to getRepository. */
  public UnaryCallSettings<GetRepositoryRequest, Repository> getRepositorySettings() {
    return ((RepositoryManagerStubSettings) getStubSettings()).getRepositorySettings();
  }

  /** Returns the object with the settings used for calls to listRepositories. */
  public PagedCallSettings<
          ListRepositoriesRequest, ListRepositoriesResponse, ListRepositoriesPagedResponse>
      listRepositoriesSettings() {
    return ((RepositoryManagerStubSettings) getStubSettings()).listRepositoriesSettings();
  }

  /** Returns the object with the settings used for calls to deleteRepository. */
  public UnaryCallSettings<DeleteRepositoryRequest, Operation> deleteRepositorySettings() {
    return ((RepositoryManagerStubSettings) getStubSettings()).deleteRepositorySettings();
  }

  /** Returns the object with the settings used for calls to deleteRepository. */
  public OperationCallSettings<DeleteRepositoryRequest, Empty, OperationMetadata>
      deleteRepositoryOperationSettings() {
    return ((RepositoryManagerStubSettings) getStubSettings()).deleteRepositoryOperationSettings();
  }

  /** Returns the object with the settings used for calls to fetchReadWriteToken. */
  public UnaryCallSettings<FetchReadWriteTokenRequest, FetchReadWriteTokenResponse>
      fetchReadWriteTokenSettings() {
    return ((RepositoryManagerStubSettings) getStubSettings()).fetchReadWriteTokenSettings();
  }

  /** Returns the object with the settings used for calls to fetchReadToken. */
  public UnaryCallSettings<FetchReadTokenRequest, FetchReadTokenResponse> fetchReadTokenSettings() {
    return ((RepositoryManagerStubSettings) getStubSettings()).fetchReadTokenSettings();
  }

  /** Returns the object with the settings used for calls to fetchLinkableRepositories. */
  public PagedCallSettings<
          FetchLinkableRepositoriesRequest,
          FetchLinkableRepositoriesResponse,
          FetchLinkableRepositoriesPagedResponse>
      fetchLinkableRepositoriesSettings() {
    return ((RepositoryManagerStubSettings) getStubSettings()).fetchLinkableRepositoriesSettings();
  }

  /** Returns the object with the settings used for calls to fetchGitRefs. */
  public UnaryCallSettings<FetchGitRefsRequest, FetchGitRefsResponse> fetchGitRefsSettings() {
    return ((RepositoryManagerStubSettings) getStubSettings()).fetchGitRefsSettings();
  }

  /** Returns the object with the settings used for calls to setIamPolicy. */
  public UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings() {
    return ((RepositoryManagerStubSettings) getStubSettings()).setIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to getIamPolicy. */
  public UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings() {
    return ((RepositoryManagerStubSettings) getStubSettings()).getIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to testIamPermissions. */
  public UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings() {
    return ((RepositoryManagerStubSettings) getStubSettings()).testIamPermissionsSettings();
  }

  public static final RepositoryManagerSettings create(RepositoryManagerStubSettings stub)
      throws IOException {
    return new RepositoryManagerSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return RepositoryManagerStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return RepositoryManagerStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return RepositoryManagerStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return RepositoryManagerStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return RepositoryManagerStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return RepositoryManagerStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return RepositoryManagerStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return RepositoryManagerStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected RepositoryManagerSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for RepositoryManagerSettings. */
  public static class Builder extends ClientSettings.Builder<RepositoryManagerSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(RepositoryManagerStubSettings.newBuilder(clientContext));
    }

    protected Builder(RepositoryManagerSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(RepositoryManagerStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(RepositoryManagerStubSettings.newBuilder());
    }

    @BetaApi
    private static Builder createHttpJsonDefault() {
      return new Builder(RepositoryManagerStubSettings.newHttpJsonBuilder());
    }

    public RepositoryManagerStubSettings.Builder getStubSettingsBuilder() {
      return ((RepositoryManagerStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to getConnection. */
    public UnaryCallSettings.Builder<GetConnectionRequest, Connection> getConnectionSettings() {
      return getStubSettingsBuilder().getConnectionSettings();
    }

    /** Returns the builder for the settings used for calls to listConnections. */
    public PagedCallSettings.Builder<
            ListConnectionsRequest, ListConnectionsResponse, ListConnectionsPagedResponse>
        listConnectionsSettings() {
      return getStubSettingsBuilder().listConnectionsSettings();
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

    /** Returns the builder for the settings used for calls to createRepository. */
    public UnaryCallSettings.Builder<CreateRepositoryRequest, Operation>
        createRepositorySettings() {
      return getStubSettingsBuilder().createRepositorySettings();
    }

    /** Returns the builder for the settings used for calls to createRepository. */
    public OperationCallSettings.Builder<CreateRepositoryRequest, Repository, OperationMetadata>
        createRepositoryOperationSettings() {
      return getStubSettingsBuilder().createRepositoryOperationSettings();
    }

    /** Returns the builder for the settings used for calls to batchCreateRepositories. */
    public UnaryCallSettings.Builder<BatchCreateRepositoriesRequest, Operation>
        batchCreateRepositoriesSettings() {
      return getStubSettingsBuilder().batchCreateRepositoriesSettings();
    }

    /** Returns the builder for the settings used for calls to batchCreateRepositories. */
    public OperationCallSettings.Builder<
            BatchCreateRepositoriesRequest, BatchCreateRepositoriesResponse, OperationMetadata>
        batchCreateRepositoriesOperationSettings() {
      return getStubSettingsBuilder().batchCreateRepositoriesOperationSettings();
    }

    /** Returns the builder for the settings used for calls to getRepository. */
    public UnaryCallSettings.Builder<GetRepositoryRequest, Repository> getRepositorySettings() {
      return getStubSettingsBuilder().getRepositorySettings();
    }

    /** Returns the builder for the settings used for calls to listRepositories. */
    public PagedCallSettings.Builder<
            ListRepositoriesRequest, ListRepositoriesResponse, ListRepositoriesPagedResponse>
        listRepositoriesSettings() {
      return getStubSettingsBuilder().listRepositoriesSettings();
    }

    /** Returns the builder for the settings used for calls to deleteRepository. */
    public UnaryCallSettings.Builder<DeleteRepositoryRequest, Operation>
        deleteRepositorySettings() {
      return getStubSettingsBuilder().deleteRepositorySettings();
    }

    /** Returns the builder for the settings used for calls to deleteRepository. */
    public OperationCallSettings.Builder<DeleteRepositoryRequest, Empty, OperationMetadata>
        deleteRepositoryOperationSettings() {
      return getStubSettingsBuilder().deleteRepositoryOperationSettings();
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

    /** Returns the builder for the settings used for calls to fetchLinkableRepositories. */
    public PagedCallSettings.Builder<
            FetchLinkableRepositoriesRequest,
            FetchLinkableRepositoriesResponse,
            FetchLinkableRepositoriesPagedResponse>
        fetchLinkableRepositoriesSettings() {
      return getStubSettingsBuilder().fetchLinkableRepositoriesSettings();
    }

    /** Returns the builder for the settings used for calls to fetchGitRefs. */
    public UnaryCallSettings.Builder<FetchGitRefsRequest, FetchGitRefsResponse>
        fetchGitRefsSettings() {
      return getStubSettingsBuilder().fetchGitRefsSettings();
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
    public RepositoryManagerSettings build() throws IOException {
      return new RepositoryManagerSettings(this);
    }
  }
}
