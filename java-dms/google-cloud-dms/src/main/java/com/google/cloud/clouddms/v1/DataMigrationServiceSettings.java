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

package com.google.cloud.clouddms.v1;

import static com.google.cloud.clouddms.v1.DataMigrationServiceClient.DescribeDatabaseEntitiesPagedResponse;
import static com.google.cloud.clouddms.v1.DataMigrationServiceClient.FetchStaticIpsPagedResponse;
import static com.google.cloud.clouddms.v1.DataMigrationServiceClient.ListConnectionProfilesPagedResponse;
import static com.google.cloud.clouddms.v1.DataMigrationServiceClient.ListConversionWorkspacesPagedResponse;
import static com.google.cloud.clouddms.v1.DataMigrationServiceClient.ListMappingRulesPagedResponse;
import static com.google.cloud.clouddms.v1.DataMigrationServiceClient.ListMigrationJobsPagedResponse;
import static com.google.cloud.clouddms.v1.DataMigrationServiceClient.ListPrivateConnectionsPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ClientSettings;
import com.google.api.gax.rpc.OperationCallSettings;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.clouddms.v1.stub.DataMigrationServiceStubSettings;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link DataMigrationServiceClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (datamigration.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getMigrationJob to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * DataMigrationServiceSettings.Builder dataMigrationServiceSettingsBuilder =
 *     DataMigrationServiceSettings.newBuilder();
 * dataMigrationServiceSettingsBuilder
 *     .getMigrationJobSettings()
 *     .setRetrySettings(
 *         dataMigrationServiceSettingsBuilder
 *             .getMigrationJobSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * DataMigrationServiceSettings dataMigrationServiceSettings =
 *     dataMigrationServiceSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class DataMigrationServiceSettings extends ClientSettings<DataMigrationServiceSettings> {

  /** Returns the object with the settings used for calls to listMigrationJobs. */
  public PagedCallSettings<
          ListMigrationJobsRequest, ListMigrationJobsResponse, ListMigrationJobsPagedResponse>
      listMigrationJobsSettings() {
    return ((DataMigrationServiceStubSettings) getStubSettings()).listMigrationJobsSettings();
  }

  /** Returns the object with the settings used for calls to getMigrationJob. */
  public UnaryCallSettings<GetMigrationJobRequest, MigrationJob> getMigrationJobSettings() {
    return ((DataMigrationServiceStubSettings) getStubSettings()).getMigrationJobSettings();
  }

  /** Returns the object with the settings used for calls to createMigrationJob. */
  public UnaryCallSettings<CreateMigrationJobRequest, Operation> createMigrationJobSettings() {
    return ((DataMigrationServiceStubSettings) getStubSettings()).createMigrationJobSettings();
  }

  /** Returns the object with the settings used for calls to createMigrationJob. */
  public OperationCallSettings<CreateMigrationJobRequest, MigrationJob, OperationMetadata>
      createMigrationJobOperationSettings() {
    return ((DataMigrationServiceStubSettings) getStubSettings())
        .createMigrationJobOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateMigrationJob. */
  public UnaryCallSettings<UpdateMigrationJobRequest, Operation> updateMigrationJobSettings() {
    return ((DataMigrationServiceStubSettings) getStubSettings()).updateMigrationJobSettings();
  }

  /** Returns the object with the settings used for calls to updateMigrationJob. */
  public OperationCallSettings<UpdateMigrationJobRequest, MigrationJob, OperationMetadata>
      updateMigrationJobOperationSettings() {
    return ((DataMigrationServiceStubSettings) getStubSettings())
        .updateMigrationJobOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteMigrationJob. */
  public UnaryCallSettings<DeleteMigrationJobRequest, Operation> deleteMigrationJobSettings() {
    return ((DataMigrationServiceStubSettings) getStubSettings()).deleteMigrationJobSettings();
  }

  /** Returns the object with the settings used for calls to deleteMigrationJob. */
  public OperationCallSettings<DeleteMigrationJobRequest, Empty, OperationMetadata>
      deleteMigrationJobOperationSettings() {
    return ((DataMigrationServiceStubSettings) getStubSettings())
        .deleteMigrationJobOperationSettings();
  }

  /** Returns the object with the settings used for calls to startMigrationJob. */
  public UnaryCallSettings<StartMigrationJobRequest, Operation> startMigrationJobSettings() {
    return ((DataMigrationServiceStubSettings) getStubSettings()).startMigrationJobSettings();
  }

  /** Returns the object with the settings used for calls to startMigrationJob. */
  public OperationCallSettings<StartMigrationJobRequest, MigrationJob, OperationMetadata>
      startMigrationJobOperationSettings() {
    return ((DataMigrationServiceStubSettings) getStubSettings())
        .startMigrationJobOperationSettings();
  }

  /** Returns the object with the settings used for calls to stopMigrationJob. */
  public UnaryCallSettings<StopMigrationJobRequest, Operation> stopMigrationJobSettings() {
    return ((DataMigrationServiceStubSettings) getStubSettings()).stopMigrationJobSettings();
  }

  /** Returns the object with the settings used for calls to stopMigrationJob. */
  public OperationCallSettings<StopMigrationJobRequest, MigrationJob, OperationMetadata>
      stopMigrationJobOperationSettings() {
    return ((DataMigrationServiceStubSettings) getStubSettings())
        .stopMigrationJobOperationSettings();
  }

  /** Returns the object with the settings used for calls to resumeMigrationJob. */
  public UnaryCallSettings<ResumeMigrationJobRequest, Operation> resumeMigrationJobSettings() {
    return ((DataMigrationServiceStubSettings) getStubSettings()).resumeMigrationJobSettings();
  }

  /** Returns the object with the settings used for calls to resumeMigrationJob. */
  public OperationCallSettings<ResumeMigrationJobRequest, MigrationJob, OperationMetadata>
      resumeMigrationJobOperationSettings() {
    return ((DataMigrationServiceStubSettings) getStubSettings())
        .resumeMigrationJobOperationSettings();
  }

  /** Returns the object with the settings used for calls to promoteMigrationJob. */
  public UnaryCallSettings<PromoteMigrationJobRequest, Operation> promoteMigrationJobSettings() {
    return ((DataMigrationServiceStubSettings) getStubSettings()).promoteMigrationJobSettings();
  }

  /** Returns the object with the settings used for calls to promoteMigrationJob. */
  public OperationCallSettings<PromoteMigrationJobRequest, MigrationJob, OperationMetadata>
      promoteMigrationJobOperationSettings() {
    return ((DataMigrationServiceStubSettings) getStubSettings())
        .promoteMigrationJobOperationSettings();
  }

  /** Returns the object with the settings used for calls to verifyMigrationJob. */
  public UnaryCallSettings<VerifyMigrationJobRequest, Operation> verifyMigrationJobSettings() {
    return ((DataMigrationServiceStubSettings) getStubSettings()).verifyMigrationJobSettings();
  }

  /** Returns the object with the settings used for calls to verifyMigrationJob. */
  public OperationCallSettings<VerifyMigrationJobRequest, MigrationJob, OperationMetadata>
      verifyMigrationJobOperationSettings() {
    return ((DataMigrationServiceStubSettings) getStubSettings())
        .verifyMigrationJobOperationSettings();
  }

  /** Returns the object with the settings used for calls to restartMigrationJob. */
  public UnaryCallSettings<RestartMigrationJobRequest, Operation> restartMigrationJobSettings() {
    return ((DataMigrationServiceStubSettings) getStubSettings()).restartMigrationJobSettings();
  }

  /** Returns the object with the settings used for calls to restartMigrationJob. */
  public OperationCallSettings<RestartMigrationJobRequest, MigrationJob, OperationMetadata>
      restartMigrationJobOperationSettings() {
    return ((DataMigrationServiceStubSettings) getStubSettings())
        .restartMigrationJobOperationSettings();
  }

  /** Returns the object with the settings used for calls to generateSshScript. */
  public UnaryCallSettings<GenerateSshScriptRequest, SshScript> generateSshScriptSettings() {
    return ((DataMigrationServiceStubSettings) getStubSettings()).generateSshScriptSettings();
  }

  /** Returns the object with the settings used for calls to generateTcpProxyScript. */
  public UnaryCallSettings<GenerateTcpProxyScriptRequest, TcpProxyScript>
      generateTcpProxyScriptSettings() {
    return ((DataMigrationServiceStubSettings) getStubSettings()).generateTcpProxyScriptSettings();
  }

  /** Returns the object with the settings used for calls to listConnectionProfiles. */
  public PagedCallSettings<
          ListConnectionProfilesRequest,
          ListConnectionProfilesResponse,
          ListConnectionProfilesPagedResponse>
      listConnectionProfilesSettings() {
    return ((DataMigrationServiceStubSettings) getStubSettings()).listConnectionProfilesSettings();
  }

  /** Returns the object with the settings used for calls to getConnectionProfile. */
  public UnaryCallSettings<GetConnectionProfileRequest, ConnectionProfile>
      getConnectionProfileSettings() {
    return ((DataMigrationServiceStubSettings) getStubSettings()).getConnectionProfileSettings();
  }

  /** Returns the object with the settings used for calls to createConnectionProfile. */
  public UnaryCallSettings<CreateConnectionProfileRequest, Operation>
      createConnectionProfileSettings() {
    return ((DataMigrationServiceStubSettings) getStubSettings()).createConnectionProfileSettings();
  }

  /** Returns the object with the settings used for calls to createConnectionProfile. */
  public OperationCallSettings<CreateConnectionProfileRequest, ConnectionProfile, OperationMetadata>
      createConnectionProfileOperationSettings() {
    return ((DataMigrationServiceStubSettings) getStubSettings())
        .createConnectionProfileOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateConnectionProfile. */
  public UnaryCallSettings<UpdateConnectionProfileRequest, Operation>
      updateConnectionProfileSettings() {
    return ((DataMigrationServiceStubSettings) getStubSettings()).updateConnectionProfileSettings();
  }

  /** Returns the object with the settings used for calls to updateConnectionProfile. */
  public OperationCallSettings<UpdateConnectionProfileRequest, ConnectionProfile, OperationMetadata>
      updateConnectionProfileOperationSettings() {
    return ((DataMigrationServiceStubSettings) getStubSettings())
        .updateConnectionProfileOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteConnectionProfile. */
  public UnaryCallSettings<DeleteConnectionProfileRequest, Operation>
      deleteConnectionProfileSettings() {
    return ((DataMigrationServiceStubSettings) getStubSettings()).deleteConnectionProfileSettings();
  }

  /** Returns the object with the settings used for calls to deleteConnectionProfile. */
  public OperationCallSettings<DeleteConnectionProfileRequest, Empty, OperationMetadata>
      deleteConnectionProfileOperationSettings() {
    return ((DataMigrationServiceStubSettings) getStubSettings())
        .deleteConnectionProfileOperationSettings();
  }

  /** Returns the object with the settings used for calls to createPrivateConnection. */
  public UnaryCallSettings<CreatePrivateConnectionRequest, Operation>
      createPrivateConnectionSettings() {
    return ((DataMigrationServiceStubSettings) getStubSettings()).createPrivateConnectionSettings();
  }

  /** Returns the object with the settings used for calls to createPrivateConnection. */
  public OperationCallSettings<CreatePrivateConnectionRequest, PrivateConnection, OperationMetadata>
      createPrivateConnectionOperationSettings() {
    return ((DataMigrationServiceStubSettings) getStubSettings())
        .createPrivateConnectionOperationSettings();
  }

  /** Returns the object with the settings used for calls to getPrivateConnection. */
  public UnaryCallSettings<GetPrivateConnectionRequest, PrivateConnection>
      getPrivateConnectionSettings() {
    return ((DataMigrationServiceStubSettings) getStubSettings()).getPrivateConnectionSettings();
  }

  /** Returns the object with the settings used for calls to listPrivateConnections. */
  public PagedCallSettings<
          ListPrivateConnectionsRequest,
          ListPrivateConnectionsResponse,
          ListPrivateConnectionsPagedResponse>
      listPrivateConnectionsSettings() {
    return ((DataMigrationServiceStubSettings) getStubSettings()).listPrivateConnectionsSettings();
  }

  /** Returns the object with the settings used for calls to deletePrivateConnection. */
  public UnaryCallSettings<DeletePrivateConnectionRequest, Operation>
      deletePrivateConnectionSettings() {
    return ((DataMigrationServiceStubSettings) getStubSettings()).deletePrivateConnectionSettings();
  }

  /** Returns the object with the settings used for calls to deletePrivateConnection. */
  public OperationCallSettings<DeletePrivateConnectionRequest, Empty, OperationMetadata>
      deletePrivateConnectionOperationSettings() {
    return ((DataMigrationServiceStubSettings) getStubSettings())
        .deletePrivateConnectionOperationSettings();
  }

  /** Returns the object with the settings used for calls to getConversionWorkspace. */
  public UnaryCallSettings<GetConversionWorkspaceRequest, ConversionWorkspace>
      getConversionWorkspaceSettings() {
    return ((DataMigrationServiceStubSettings) getStubSettings()).getConversionWorkspaceSettings();
  }

  /** Returns the object with the settings used for calls to listConversionWorkspaces. */
  public PagedCallSettings<
          ListConversionWorkspacesRequest,
          ListConversionWorkspacesResponse,
          ListConversionWorkspacesPagedResponse>
      listConversionWorkspacesSettings() {
    return ((DataMigrationServiceStubSettings) getStubSettings())
        .listConversionWorkspacesSettings();
  }

  /** Returns the object with the settings used for calls to createConversionWorkspace. */
  public UnaryCallSettings<CreateConversionWorkspaceRequest, Operation>
      createConversionWorkspaceSettings() {
    return ((DataMigrationServiceStubSettings) getStubSettings())
        .createConversionWorkspaceSettings();
  }

  /** Returns the object with the settings used for calls to createConversionWorkspace. */
  public OperationCallSettings<
          CreateConversionWorkspaceRequest, ConversionWorkspace, OperationMetadata>
      createConversionWorkspaceOperationSettings() {
    return ((DataMigrationServiceStubSettings) getStubSettings())
        .createConversionWorkspaceOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateConversionWorkspace. */
  public UnaryCallSettings<UpdateConversionWorkspaceRequest, Operation>
      updateConversionWorkspaceSettings() {
    return ((DataMigrationServiceStubSettings) getStubSettings())
        .updateConversionWorkspaceSettings();
  }

  /** Returns the object with the settings used for calls to updateConversionWorkspace. */
  public OperationCallSettings<
          UpdateConversionWorkspaceRequest, ConversionWorkspace, OperationMetadata>
      updateConversionWorkspaceOperationSettings() {
    return ((DataMigrationServiceStubSettings) getStubSettings())
        .updateConversionWorkspaceOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteConversionWorkspace. */
  public UnaryCallSettings<DeleteConversionWorkspaceRequest, Operation>
      deleteConversionWorkspaceSettings() {
    return ((DataMigrationServiceStubSettings) getStubSettings())
        .deleteConversionWorkspaceSettings();
  }

  /** Returns the object with the settings used for calls to deleteConversionWorkspace. */
  public OperationCallSettings<DeleteConversionWorkspaceRequest, Empty, OperationMetadata>
      deleteConversionWorkspaceOperationSettings() {
    return ((DataMigrationServiceStubSettings) getStubSettings())
        .deleteConversionWorkspaceOperationSettings();
  }

  /** Returns the object with the settings used for calls to createMappingRule. */
  public UnaryCallSettings<CreateMappingRuleRequest, MappingRule> createMappingRuleSettings() {
    return ((DataMigrationServiceStubSettings) getStubSettings()).createMappingRuleSettings();
  }

  /** Returns the object with the settings used for calls to deleteMappingRule. */
  public UnaryCallSettings<DeleteMappingRuleRequest, Empty> deleteMappingRuleSettings() {
    return ((DataMigrationServiceStubSettings) getStubSettings()).deleteMappingRuleSettings();
  }

  /** Returns the object with the settings used for calls to listMappingRules. */
  public PagedCallSettings<
          ListMappingRulesRequest, ListMappingRulesResponse, ListMappingRulesPagedResponse>
      listMappingRulesSettings() {
    return ((DataMigrationServiceStubSettings) getStubSettings()).listMappingRulesSettings();
  }

  /** Returns the object with the settings used for calls to getMappingRule. */
  public UnaryCallSettings<GetMappingRuleRequest, MappingRule> getMappingRuleSettings() {
    return ((DataMigrationServiceStubSettings) getStubSettings()).getMappingRuleSettings();
  }

  /** Returns the object with the settings used for calls to seedConversionWorkspace. */
  public UnaryCallSettings<SeedConversionWorkspaceRequest, Operation>
      seedConversionWorkspaceSettings() {
    return ((DataMigrationServiceStubSettings) getStubSettings()).seedConversionWorkspaceSettings();
  }

  /** Returns the object with the settings used for calls to seedConversionWorkspace. */
  public OperationCallSettings<
          SeedConversionWorkspaceRequest, ConversionWorkspace, OperationMetadata>
      seedConversionWorkspaceOperationSettings() {
    return ((DataMigrationServiceStubSettings) getStubSettings())
        .seedConversionWorkspaceOperationSettings();
  }

  /** Returns the object with the settings used for calls to importMappingRules. */
  public UnaryCallSettings<ImportMappingRulesRequest, Operation> importMappingRulesSettings() {
    return ((DataMigrationServiceStubSettings) getStubSettings()).importMappingRulesSettings();
  }

  /** Returns the object with the settings used for calls to importMappingRules. */
  public OperationCallSettings<ImportMappingRulesRequest, ConversionWorkspace, OperationMetadata>
      importMappingRulesOperationSettings() {
    return ((DataMigrationServiceStubSettings) getStubSettings())
        .importMappingRulesOperationSettings();
  }

  /** Returns the object with the settings used for calls to convertConversionWorkspace. */
  public UnaryCallSettings<ConvertConversionWorkspaceRequest, Operation>
      convertConversionWorkspaceSettings() {
    return ((DataMigrationServiceStubSettings) getStubSettings())
        .convertConversionWorkspaceSettings();
  }

  /** Returns the object with the settings used for calls to convertConversionWorkspace. */
  public OperationCallSettings<
          ConvertConversionWorkspaceRequest, ConversionWorkspace, OperationMetadata>
      convertConversionWorkspaceOperationSettings() {
    return ((DataMigrationServiceStubSettings) getStubSettings())
        .convertConversionWorkspaceOperationSettings();
  }

  /** Returns the object with the settings used for calls to commitConversionWorkspace. */
  public UnaryCallSettings<CommitConversionWorkspaceRequest, Operation>
      commitConversionWorkspaceSettings() {
    return ((DataMigrationServiceStubSettings) getStubSettings())
        .commitConversionWorkspaceSettings();
  }

  /** Returns the object with the settings used for calls to commitConversionWorkspace. */
  public OperationCallSettings<
          CommitConversionWorkspaceRequest, ConversionWorkspace, OperationMetadata>
      commitConversionWorkspaceOperationSettings() {
    return ((DataMigrationServiceStubSettings) getStubSettings())
        .commitConversionWorkspaceOperationSettings();
  }

  /** Returns the object with the settings used for calls to rollbackConversionWorkspace. */
  public UnaryCallSettings<RollbackConversionWorkspaceRequest, Operation>
      rollbackConversionWorkspaceSettings() {
    return ((DataMigrationServiceStubSettings) getStubSettings())
        .rollbackConversionWorkspaceSettings();
  }

  /** Returns the object with the settings used for calls to rollbackConversionWorkspace. */
  public OperationCallSettings<
          RollbackConversionWorkspaceRequest, ConversionWorkspace, OperationMetadata>
      rollbackConversionWorkspaceOperationSettings() {
    return ((DataMigrationServiceStubSettings) getStubSettings())
        .rollbackConversionWorkspaceOperationSettings();
  }

  /** Returns the object with the settings used for calls to applyConversionWorkspace. */
  public UnaryCallSettings<ApplyConversionWorkspaceRequest, Operation>
      applyConversionWorkspaceSettings() {
    return ((DataMigrationServiceStubSettings) getStubSettings())
        .applyConversionWorkspaceSettings();
  }

  /** Returns the object with the settings used for calls to applyConversionWorkspace. */
  public OperationCallSettings<
          ApplyConversionWorkspaceRequest, ConversionWorkspace, OperationMetadata>
      applyConversionWorkspaceOperationSettings() {
    return ((DataMigrationServiceStubSettings) getStubSettings())
        .applyConversionWorkspaceOperationSettings();
  }

  /** Returns the object with the settings used for calls to describeDatabaseEntities. */
  public PagedCallSettings<
          DescribeDatabaseEntitiesRequest,
          DescribeDatabaseEntitiesResponse,
          DescribeDatabaseEntitiesPagedResponse>
      describeDatabaseEntitiesSettings() {
    return ((DataMigrationServiceStubSettings) getStubSettings())
        .describeDatabaseEntitiesSettings();
  }

  /** Returns the object with the settings used for calls to searchBackgroundJobs. */
  public UnaryCallSettings<SearchBackgroundJobsRequest, SearchBackgroundJobsResponse>
      searchBackgroundJobsSettings() {
    return ((DataMigrationServiceStubSettings) getStubSettings()).searchBackgroundJobsSettings();
  }

  /**
   * Returns the object with the settings used for calls to describeConversionWorkspaceRevisions.
   */
  public UnaryCallSettings<
          DescribeConversionWorkspaceRevisionsRequest, DescribeConversionWorkspaceRevisionsResponse>
      describeConversionWorkspaceRevisionsSettings() {
    return ((DataMigrationServiceStubSettings) getStubSettings())
        .describeConversionWorkspaceRevisionsSettings();
  }

  /** Returns the object with the settings used for calls to fetchStaticIps. */
  public PagedCallSettings<
          FetchStaticIpsRequest, FetchStaticIpsResponse, FetchStaticIpsPagedResponse>
      fetchStaticIpsSettings() {
    return ((DataMigrationServiceStubSettings) getStubSettings()).fetchStaticIpsSettings();
  }

  public static final DataMigrationServiceSettings create(DataMigrationServiceStubSettings stub)
      throws IOException {
    return new DataMigrationServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return DataMigrationServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return DataMigrationServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return DataMigrationServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return DataMigrationServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return DataMigrationServiceStubSettings.defaultGrpcTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return DataMigrationServiceStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return DataMigrationServiceStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected DataMigrationServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for DataMigrationServiceSettings. */
  public static class Builder
      extends ClientSettings.Builder<DataMigrationServiceSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(DataMigrationServiceStubSettings.newBuilder(clientContext));
    }

    protected Builder(DataMigrationServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(DataMigrationServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(DataMigrationServiceStubSettings.newBuilder());
    }

    public DataMigrationServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((DataMigrationServiceStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to listMigrationJobs. */
    public PagedCallSettings.Builder<
            ListMigrationJobsRequest, ListMigrationJobsResponse, ListMigrationJobsPagedResponse>
        listMigrationJobsSettings() {
      return getStubSettingsBuilder().listMigrationJobsSettings();
    }

    /** Returns the builder for the settings used for calls to getMigrationJob. */
    public UnaryCallSettings.Builder<GetMigrationJobRequest, MigrationJob>
        getMigrationJobSettings() {
      return getStubSettingsBuilder().getMigrationJobSettings();
    }

    /** Returns the builder for the settings used for calls to createMigrationJob. */
    public UnaryCallSettings.Builder<CreateMigrationJobRequest, Operation>
        createMigrationJobSettings() {
      return getStubSettingsBuilder().createMigrationJobSettings();
    }

    /** Returns the builder for the settings used for calls to createMigrationJob. */
    public OperationCallSettings.Builder<CreateMigrationJobRequest, MigrationJob, OperationMetadata>
        createMigrationJobOperationSettings() {
      return getStubSettingsBuilder().createMigrationJobOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateMigrationJob. */
    public UnaryCallSettings.Builder<UpdateMigrationJobRequest, Operation>
        updateMigrationJobSettings() {
      return getStubSettingsBuilder().updateMigrationJobSettings();
    }

    /** Returns the builder for the settings used for calls to updateMigrationJob. */
    public OperationCallSettings.Builder<UpdateMigrationJobRequest, MigrationJob, OperationMetadata>
        updateMigrationJobOperationSettings() {
      return getStubSettingsBuilder().updateMigrationJobOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteMigrationJob. */
    public UnaryCallSettings.Builder<DeleteMigrationJobRequest, Operation>
        deleteMigrationJobSettings() {
      return getStubSettingsBuilder().deleteMigrationJobSettings();
    }

    /** Returns the builder for the settings used for calls to deleteMigrationJob. */
    public OperationCallSettings.Builder<DeleteMigrationJobRequest, Empty, OperationMetadata>
        deleteMigrationJobOperationSettings() {
      return getStubSettingsBuilder().deleteMigrationJobOperationSettings();
    }

    /** Returns the builder for the settings used for calls to startMigrationJob. */
    public UnaryCallSettings.Builder<StartMigrationJobRequest, Operation>
        startMigrationJobSettings() {
      return getStubSettingsBuilder().startMigrationJobSettings();
    }

    /** Returns the builder for the settings used for calls to startMigrationJob. */
    public OperationCallSettings.Builder<StartMigrationJobRequest, MigrationJob, OperationMetadata>
        startMigrationJobOperationSettings() {
      return getStubSettingsBuilder().startMigrationJobOperationSettings();
    }

    /** Returns the builder for the settings used for calls to stopMigrationJob. */
    public UnaryCallSettings.Builder<StopMigrationJobRequest, Operation>
        stopMigrationJobSettings() {
      return getStubSettingsBuilder().stopMigrationJobSettings();
    }

    /** Returns the builder for the settings used for calls to stopMigrationJob. */
    public OperationCallSettings.Builder<StopMigrationJobRequest, MigrationJob, OperationMetadata>
        stopMigrationJobOperationSettings() {
      return getStubSettingsBuilder().stopMigrationJobOperationSettings();
    }

    /** Returns the builder for the settings used for calls to resumeMigrationJob. */
    public UnaryCallSettings.Builder<ResumeMigrationJobRequest, Operation>
        resumeMigrationJobSettings() {
      return getStubSettingsBuilder().resumeMigrationJobSettings();
    }

    /** Returns the builder for the settings used for calls to resumeMigrationJob. */
    public OperationCallSettings.Builder<ResumeMigrationJobRequest, MigrationJob, OperationMetadata>
        resumeMigrationJobOperationSettings() {
      return getStubSettingsBuilder().resumeMigrationJobOperationSettings();
    }

    /** Returns the builder for the settings used for calls to promoteMigrationJob. */
    public UnaryCallSettings.Builder<PromoteMigrationJobRequest, Operation>
        promoteMigrationJobSettings() {
      return getStubSettingsBuilder().promoteMigrationJobSettings();
    }

    /** Returns the builder for the settings used for calls to promoteMigrationJob. */
    public OperationCallSettings.Builder<
            PromoteMigrationJobRequest, MigrationJob, OperationMetadata>
        promoteMigrationJobOperationSettings() {
      return getStubSettingsBuilder().promoteMigrationJobOperationSettings();
    }

    /** Returns the builder for the settings used for calls to verifyMigrationJob. */
    public UnaryCallSettings.Builder<VerifyMigrationJobRequest, Operation>
        verifyMigrationJobSettings() {
      return getStubSettingsBuilder().verifyMigrationJobSettings();
    }

    /** Returns the builder for the settings used for calls to verifyMigrationJob. */
    public OperationCallSettings.Builder<VerifyMigrationJobRequest, MigrationJob, OperationMetadata>
        verifyMigrationJobOperationSettings() {
      return getStubSettingsBuilder().verifyMigrationJobOperationSettings();
    }

    /** Returns the builder for the settings used for calls to restartMigrationJob. */
    public UnaryCallSettings.Builder<RestartMigrationJobRequest, Operation>
        restartMigrationJobSettings() {
      return getStubSettingsBuilder().restartMigrationJobSettings();
    }

    /** Returns the builder for the settings used for calls to restartMigrationJob. */
    public OperationCallSettings.Builder<
            RestartMigrationJobRequest, MigrationJob, OperationMetadata>
        restartMigrationJobOperationSettings() {
      return getStubSettingsBuilder().restartMigrationJobOperationSettings();
    }

    /** Returns the builder for the settings used for calls to generateSshScript. */
    public UnaryCallSettings.Builder<GenerateSshScriptRequest, SshScript>
        generateSshScriptSettings() {
      return getStubSettingsBuilder().generateSshScriptSettings();
    }

    /** Returns the builder for the settings used for calls to generateTcpProxyScript. */
    public UnaryCallSettings.Builder<GenerateTcpProxyScriptRequest, TcpProxyScript>
        generateTcpProxyScriptSettings() {
      return getStubSettingsBuilder().generateTcpProxyScriptSettings();
    }

    /** Returns the builder for the settings used for calls to listConnectionProfiles. */
    public PagedCallSettings.Builder<
            ListConnectionProfilesRequest,
            ListConnectionProfilesResponse,
            ListConnectionProfilesPagedResponse>
        listConnectionProfilesSettings() {
      return getStubSettingsBuilder().listConnectionProfilesSettings();
    }

    /** Returns the builder for the settings used for calls to getConnectionProfile. */
    public UnaryCallSettings.Builder<GetConnectionProfileRequest, ConnectionProfile>
        getConnectionProfileSettings() {
      return getStubSettingsBuilder().getConnectionProfileSettings();
    }

    /** Returns the builder for the settings used for calls to createConnectionProfile. */
    public UnaryCallSettings.Builder<CreateConnectionProfileRequest, Operation>
        createConnectionProfileSettings() {
      return getStubSettingsBuilder().createConnectionProfileSettings();
    }

    /** Returns the builder for the settings used for calls to createConnectionProfile. */
    public OperationCallSettings.Builder<
            CreateConnectionProfileRequest, ConnectionProfile, OperationMetadata>
        createConnectionProfileOperationSettings() {
      return getStubSettingsBuilder().createConnectionProfileOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateConnectionProfile. */
    public UnaryCallSettings.Builder<UpdateConnectionProfileRequest, Operation>
        updateConnectionProfileSettings() {
      return getStubSettingsBuilder().updateConnectionProfileSettings();
    }

    /** Returns the builder for the settings used for calls to updateConnectionProfile. */
    public OperationCallSettings.Builder<
            UpdateConnectionProfileRequest, ConnectionProfile, OperationMetadata>
        updateConnectionProfileOperationSettings() {
      return getStubSettingsBuilder().updateConnectionProfileOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteConnectionProfile. */
    public UnaryCallSettings.Builder<DeleteConnectionProfileRequest, Operation>
        deleteConnectionProfileSettings() {
      return getStubSettingsBuilder().deleteConnectionProfileSettings();
    }

    /** Returns the builder for the settings used for calls to deleteConnectionProfile. */
    public OperationCallSettings.Builder<DeleteConnectionProfileRequest, Empty, OperationMetadata>
        deleteConnectionProfileOperationSettings() {
      return getStubSettingsBuilder().deleteConnectionProfileOperationSettings();
    }

    /** Returns the builder for the settings used for calls to createPrivateConnection. */
    public UnaryCallSettings.Builder<CreatePrivateConnectionRequest, Operation>
        createPrivateConnectionSettings() {
      return getStubSettingsBuilder().createPrivateConnectionSettings();
    }

    /** Returns the builder for the settings used for calls to createPrivateConnection. */
    public OperationCallSettings.Builder<
            CreatePrivateConnectionRequest, PrivateConnection, OperationMetadata>
        createPrivateConnectionOperationSettings() {
      return getStubSettingsBuilder().createPrivateConnectionOperationSettings();
    }

    /** Returns the builder for the settings used for calls to getPrivateConnection. */
    public UnaryCallSettings.Builder<GetPrivateConnectionRequest, PrivateConnection>
        getPrivateConnectionSettings() {
      return getStubSettingsBuilder().getPrivateConnectionSettings();
    }

    /** Returns the builder for the settings used for calls to listPrivateConnections. */
    public PagedCallSettings.Builder<
            ListPrivateConnectionsRequest,
            ListPrivateConnectionsResponse,
            ListPrivateConnectionsPagedResponse>
        listPrivateConnectionsSettings() {
      return getStubSettingsBuilder().listPrivateConnectionsSettings();
    }

    /** Returns the builder for the settings used for calls to deletePrivateConnection. */
    public UnaryCallSettings.Builder<DeletePrivateConnectionRequest, Operation>
        deletePrivateConnectionSettings() {
      return getStubSettingsBuilder().deletePrivateConnectionSettings();
    }

    /** Returns the builder for the settings used for calls to deletePrivateConnection. */
    public OperationCallSettings.Builder<DeletePrivateConnectionRequest, Empty, OperationMetadata>
        deletePrivateConnectionOperationSettings() {
      return getStubSettingsBuilder().deletePrivateConnectionOperationSettings();
    }

    /** Returns the builder for the settings used for calls to getConversionWorkspace. */
    public UnaryCallSettings.Builder<GetConversionWorkspaceRequest, ConversionWorkspace>
        getConversionWorkspaceSettings() {
      return getStubSettingsBuilder().getConversionWorkspaceSettings();
    }

    /** Returns the builder for the settings used for calls to listConversionWorkspaces. */
    public PagedCallSettings.Builder<
            ListConversionWorkspacesRequest,
            ListConversionWorkspacesResponse,
            ListConversionWorkspacesPagedResponse>
        listConversionWorkspacesSettings() {
      return getStubSettingsBuilder().listConversionWorkspacesSettings();
    }

    /** Returns the builder for the settings used for calls to createConversionWorkspace. */
    public UnaryCallSettings.Builder<CreateConversionWorkspaceRequest, Operation>
        createConversionWorkspaceSettings() {
      return getStubSettingsBuilder().createConversionWorkspaceSettings();
    }

    /** Returns the builder for the settings used for calls to createConversionWorkspace. */
    public OperationCallSettings.Builder<
            CreateConversionWorkspaceRequest, ConversionWorkspace, OperationMetadata>
        createConversionWorkspaceOperationSettings() {
      return getStubSettingsBuilder().createConversionWorkspaceOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateConversionWorkspace. */
    public UnaryCallSettings.Builder<UpdateConversionWorkspaceRequest, Operation>
        updateConversionWorkspaceSettings() {
      return getStubSettingsBuilder().updateConversionWorkspaceSettings();
    }

    /** Returns the builder for the settings used for calls to updateConversionWorkspace. */
    public OperationCallSettings.Builder<
            UpdateConversionWorkspaceRequest, ConversionWorkspace, OperationMetadata>
        updateConversionWorkspaceOperationSettings() {
      return getStubSettingsBuilder().updateConversionWorkspaceOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteConversionWorkspace. */
    public UnaryCallSettings.Builder<DeleteConversionWorkspaceRequest, Operation>
        deleteConversionWorkspaceSettings() {
      return getStubSettingsBuilder().deleteConversionWorkspaceSettings();
    }

    /** Returns the builder for the settings used for calls to deleteConversionWorkspace. */
    public OperationCallSettings.Builder<DeleteConversionWorkspaceRequest, Empty, OperationMetadata>
        deleteConversionWorkspaceOperationSettings() {
      return getStubSettingsBuilder().deleteConversionWorkspaceOperationSettings();
    }

    /** Returns the builder for the settings used for calls to createMappingRule. */
    public UnaryCallSettings.Builder<CreateMappingRuleRequest, MappingRule>
        createMappingRuleSettings() {
      return getStubSettingsBuilder().createMappingRuleSettings();
    }

    /** Returns the builder for the settings used for calls to deleteMappingRule. */
    public UnaryCallSettings.Builder<DeleteMappingRuleRequest, Empty> deleteMappingRuleSettings() {
      return getStubSettingsBuilder().deleteMappingRuleSettings();
    }

    /** Returns the builder for the settings used for calls to listMappingRules. */
    public PagedCallSettings.Builder<
            ListMappingRulesRequest, ListMappingRulesResponse, ListMappingRulesPagedResponse>
        listMappingRulesSettings() {
      return getStubSettingsBuilder().listMappingRulesSettings();
    }

    /** Returns the builder for the settings used for calls to getMappingRule. */
    public UnaryCallSettings.Builder<GetMappingRuleRequest, MappingRule> getMappingRuleSettings() {
      return getStubSettingsBuilder().getMappingRuleSettings();
    }

    /** Returns the builder for the settings used for calls to seedConversionWorkspace. */
    public UnaryCallSettings.Builder<SeedConversionWorkspaceRequest, Operation>
        seedConversionWorkspaceSettings() {
      return getStubSettingsBuilder().seedConversionWorkspaceSettings();
    }

    /** Returns the builder for the settings used for calls to seedConversionWorkspace. */
    public OperationCallSettings.Builder<
            SeedConversionWorkspaceRequest, ConversionWorkspace, OperationMetadata>
        seedConversionWorkspaceOperationSettings() {
      return getStubSettingsBuilder().seedConversionWorkspaceOperationSettings();
    }

    /** Returns the builder for the settings used for calls to importMappingRules. */
    public UnaryCallSettings.Builder<ImportMappingRulesRequest, Operation>
        importMappingRulesSettings() {
      return getStubSettingsBuilder().importMappingRulesSettings();
    }

    /** Returns the builder for the settings used for calls to importMappingRules. */
    public OperationCallSettings.Builder<
            ImportMappingRulesRequest, ConversionWorkspace, OperationMetadata>
        importMappingRulesOperationSettings() {
      return getStubSettingsBuilder().importMappingRulesOperationSettings();
    }

    /** Returns the builder for the settings used for calls to convertConversionWorkspace. */
    public UnaryCallSettings.Builder<ConvertConversionWorkspaceRequest, Operation>
        convertConversionWorkspaceSettings() {
      return getStubSettingsBuilder().convertConversionWorkspaceSettings();
    }

    /** Returns the builder for the settings used for calls to convertConversionWorkspace. */
    public OperationCallSettings.Builder<
            ConvertConversionWorkspaceRequest, ConversionWorkspace, OperationMetadata>
        convertConversionWorkspaceOperationSettings() {
      return getStubSettingsBuilder().convertConversionWorkspaceOperationSettings();
    }

    /** Returns the builder for the settings used for calls to commitConversionWorkspace. */
    public UnaryCallSettings.Builder<CommitConversionWorkspaceRequest, Operation>
        commitConversionWorkspaceSettings() {
      return getStubSettingsBuilder().commitConversionWorkspaceSettings();
    }

    /** Returns the builder for the settings used for calls to commitConversionWorkspace. */
    public OperationCallSettings.Builder<
            CommitConversionWorkspaceRequest, ConversionWorkspace, OperationMetadata>
        commitConversionWorkspaceOperationSettings() {
      return getStubSettingsBuilder().commitConversionWorkspaceOperationSettings();
    }

    /** Returns the builder for the settings used for calls to rollbackConversionWorkspace. */
    public UnaryCallSettings.Builder<RollbackConversionWorkspaceRequest, Operation>
        rollbackConversionWorkspaceSettings() {
      return getStubSettingsBuilder().rollbackConversionWorkspaceSettings();
    }

    /** Returns the builder for the settings used for calls to rollbackConversionWorkspace. */
    public OperationCallSettings.Builder<
            RollbackConversionWorkspaceRequest, ConversionWorkspace, OperationMetadata>
        rollbackConversionWorkspaceOperationSettings() {
      return getStubSettingsBuilder().rollbackConversionWorkspaceOperationSettings();
    }

    /** Returns the builder for the settings used for calls to applyConversionWorkspace. */
    public UnaryCallSettings.Builder<ApplyConversionWorkspaceRequest, Operation>
        applyConversionWorkspaceSettings() {
      return getStubSettingsBuilder().applyConversionWorkspaceSettings();
    }

    /** Returns the builder for the settings used for calls to applyConversionWorkspace. */
    public OperationCallSettings.Builder<
            ApplyConversionWorkspaceRequest, ConversionWorkspace, OperationMetadata>
        applyConversionWorkspaceOperationSettings() {
      return getStubSettingsBuilder().applyConversionWorkspaceOperationSettings();
    }

    /** Returns the builder for the settings used for calls to describeDatabaseEntities. */
    public PagedCallSettings.Builder<
            DescribeDatabaseEntitiesRequest,
            DescribeDatabaseEntitiesResponse,
            DescribeDatabaseEntitiesPagedResponse>
        describeDatabaseEntitiesSettings() {
      return getStubSettingsBuilder().describeDatabaseEntitiesSettings();
    }

    /** Returns the builder for the settings used for calls to searchBackgroundJobs. */
    public UnaryCallSettings.Builder<SearchBackgroundJobsRequest, SearchBackgroundJobsResponse>
        searchBackgroundJobsSettings() {
      return getStubSettingsBuilder().searchBackgroundJobsSettings();
    }

    /**
     * Returns the builder for the settings used for calls to describeConversionWorkspaceRevisions.
     */
    public UnaryCallSettings.Builder<
            DescribeConversionWorkspaceRevisionsRequest,
            DescribeConversionWorkspaceRevisionsResponse>
        describeConversionWorkspaceRevisionsSettings() {
      return getStubSettingsBuilder().describeConversionWorkspaceRevisionsSettings();
    }

    /** Returns the builder for the settings used for calls to fetchStaticIps. */
    public PagedCallSettings.Builder<
            FetchStaticIpsRequest, FetchStaticIpsResponse, FetchStaticIpsPagedResponse>
        fetchStaticIpsSettings() {
      return getStubSettingsBuilder().fetchStaticIpsSettings();
    }

    @Override
    public DataMigrationServiceSettings build() throws IOException {
      return new DataMigrationServiceSettings(this);
    }
  }
}
