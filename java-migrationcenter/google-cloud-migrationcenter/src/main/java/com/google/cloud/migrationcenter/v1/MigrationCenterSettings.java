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

package com.google.cloud.migrationcenter.v1;

import static com.google.cloud.migrationcenter.v1.MigrationCenterClient.ListAssetsPagedResponse;
import static com.google.cloud.migrationcenter.v1.MigrationCenterClient.ListErrorFramesPagedResponse;
import static com.google.cloud.migrationcenter.v1.MigrationCenterClient.ListGroupsPagedResponse;
import static com.google.cloud.migrationcenter.v1.MigrationCenterClient.ListImportDataFilesPagedResponse;
import static com.google.cloud.migrationcenter.v1.MigrationCenterClient.ListImportJobsPagedResponse;
import static com.google.cloud.migrationcenter.v1.MigrationCenterClient.ListLocationsPagedResponse;
import static com.google.cloud.migrationcenter.v1.MigrationCenterClient.ListPreferenceSetsPagedResponse;
import static com.google.cloud.migrationcenter.v1.MigrationCenterClient.ListReportConfigsPagedResponse;
import static com.google.cloud.migrationcenter.v1.MigrationCenterClient.ListReportsPagedResponse;
import static com.google.cloud.migrationcenter.v1.MigrationCenterClient.ListSourcesPagedResponse;

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
import com.google.cloud.migrationcenter.v1.stub.MigrationCenterStubSettings;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link MigrationCenterClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (migrationcenter.googleapis.com) and default port (443) are
 *       used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getAsset to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * MigrationCenterSettings.Builder migrationCenterSettingsBuilder =
 *     MigrationCenterSettings.newBuilder();
 * migrationCenterSettingsBuilder
 *     .getAssetSettings()
 *     .setRetrySettings(
 *         migrationCenterSettingsBuilder
 *             .getAssetSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * MigrationCenterSettings migrationCenterSettings = migrationCenterSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class MigrationCenterSettings extends ClientSettings<MigrationCenterSettings> {

  /** Returns the object with the settings used for calls to listAssets. */
  public PagedCallSettings<ListAssetsRequest, ListAssetsResponse, ListAssetsPagedResponse>
      listAssetsSettings() {
    return ((MigrationCenterStubSettings) getStubSettings()).listAssetsSettings();
  }

  /** Returns the object with the settings used for calls to getAsset. */
  public UnaryCallSettings<GetAssetRequest, Asset> getAssetSettings() {
    return ((MigrationCenterStubSettings) getStubSettings()).getAssetSettings();
  }

  /** Returns the object with the settings used for calls to updateAsset. */
  public UnaryCallSettings<UpdateAssetRequest, Asset> updateAssetSettings() {
    return ((MigrationCenterStubSettings) getStubSettings()).updateAssetSettings();
  }

  /** Returns the object with the settings used for calls to batchUpdateAssets. */
  public UnaryCallSettings<BatchUpdateAssetsRequest, BatchUpdateAssetsResponse>
      batchUpdateAssetsSettings() {
    return ((MigrationCenterStubSettings) getStubSettings()).batchUpdateAssetsSettings();
  }

  /** Returns the object with the settings used for calls to deleteAsset. */
  public UnaryCallSettings<DeleteAssetRequest, Empty> deleteAssetSettings() {
    return ((MigrationCenterStubSettings) getStubSettings()).deleteAssetSettings();
  }

  /** Returns the object with the settings used for calls to batchDeleteAssets. */
  public UnaryCallSettings<BatchDeleteAssetsRequest, Empty> batchDeleteAssetsSettings() {
    return ((MigrationCenterStubSettings) getStubSettings()).batchDeleteAssetsSettings();
  }

  /** Returns the object with the settings used for calls to reportAssetFrames. */
  public UnaryCallSettings<ReportAssetFramesRequest, ReportAssetFramesResponse>
      reportAssetFramesSettings() {
    return ((MigrationCenterStubSettings) getStubSettings()).reportAssetFramesSettings();
  }

  /** Returns the object with the settings used for calls to aggregateAssetsValues. */
  public UnaryCallSettings<AggregateAssetsValuesRequest, AggregateAssetsValuesResponse>
      aggregateAssetsValuesSettings() {
    return ((MigrationCenterStubSettings) getStubSettings()).aggregateAssetsValuesSettings();
  }

  /** Returns the object with the settings used for calls to createImportJob. */
  public UnaryCallSettings<CreateImportJobRequest, Operation> createImportJobSettings() {
    return ((MigrationCenterStubSettings) getStubSettings()).createImportJobSettings();
  }

  /** Returns the object with the settings used for calls to createImportJob. */
  public OperationCallSettings<CreateImportJobRequest, ImportJob, OperationMetadata>
      createImportJobOperationSettings() {
    return ((MigrationCenterStubSettings) getStubSettings()).createImportJobOperationSettings();
  }

  /** Returns the object with the settings used for calls to listImportJobs. */
  public PagedCallSettings<
          ListImportJobsRequest, ListImportJobsResponse, ListImportJobsPagedResponse>
      listImportJobsSettings() {
    return ((MigrationCenterStubSettings) getStubSettings()).listImportJobsSettings();
  }

  /** Returns the object with the settings used for calls to getImportJob. */
  public UnaryCallSettings<GetImportJobRequest, ImportJob> getImportJobSettings() {
    return ((MigrationCenterStubSettings) getStubSettings()).getImportJobSettings();
  }

  /** Returns the object with the settings used for calls to deleteImportJob. */
  public UnaryCallSettings<DeleteImportJobRequest, Operation> deleteImportJobSettings() {
    return ((MigrationCenterStubSettings) getStubSettings()).deleteImportJobSettings();
  }

  /** Returns the object with the settings used for calls to deleteImportJob. */
  public OperationCallSettings<DeleteImportJobRequest, Empty, OperationMetadata>
      deleteImportJobOperationSettings() {
    return ((MigrationCenterStubSettings) getStubSettings()).deleteImportJobOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateImportJob. */
  public UnaryCallSettings<UpdateImportJobRequest, Operation> updateImportJobSettings() {
    return ((MigrationCenterStubSettings) getStubSettings()).updateImportJobSettings();
  }

  /** Returns the object with the settings used for calls to updateImportJob. */
  public OperationCallSettings<UpdateImportJobRequest, ImportJob, OperationMetadata>
      updateImportJobOperationSettings() {
    return ((MigrationCenterStubSettings) getStubSettings()).updateImportJobOperationSettings();
  }

  /** Returns the object with the settings used for calls to validateImportJob. */
  public UnaryCallSettings<ValidateImportJobRequest, Operation> validateImportJobSettings() {
    return ((MigrationCenterStubSettings) getStubSettings()).validateImportJobSettings();
  }

  /** Returns the object with the settings used for calls to validateImportJob. */
  public OperationCallSettings<ValidateImportJobRequest, Empty, OperationMetadata>
      validateImportJobOperationSettings() {
    return ((MigrationCenterStubSettings) getStubSettings()).validateImportJobOperationSettings();
  }

  /** Returns the object with the settings used for calls to runImportJob. */
  public UnaryCallSettings<RunImportJobRequest, Operation> runImportJobSettings() {
    return ((MigrationCenterStubSettings) getStubSettings()).runImportJobSettings();
  }

  /** Returns the object with the settings used for calls to runImportJob. */
  public OperationCallSettings<RunImportJobRequest, Empty, OperationMetadata>
      runImportJobOperationSettings() {
    return ((MigrationCenterStubSettings) getStubSettings()).runImportJobOperationSettings();
  }

  /** Returns the object with the settings used for calls to getImportDataFile. */
  public UnaryCallSettings<GetImportDataFileRequest, ImportDataFile> getImportDataFileSettings() {
    return ((MigrationCenterStubSettings) getStubSettings()).getImportDataFileSettings();
  }

  /** Returns the object with the settings used for calls to listImportDataFiles. */
  public PagedCallSettings<
          ListImportDataFilesRequest, ListImportDataFilesResponse, ListImportDataFilesPagedResponse>
      listImportDataFilesSettings() {
    return ((MigrationCenterStubSettings) getStubSettings()).listImportDataFilesSettings();
  }

  /** Returns the object with the settings used for calls to createImportDataFile. */
  public UnaryCallSettings<CreateImportDataFileRequest, Operation> createImportDataFileSettings() {
    return ((MigrationCenterStubSettings) getStubSettings()).createImportDataFileSettings();
  }

  /** Returns the object with the settings used for calls to createImportDataFile. */
  public OperationCallSettings<CreateImportDataFileRequest, ImportDataFile, OperationMetadata>
      createImportDataFileOperationSettings() {
    return ((MigrationCenterStubSettings) getStubSettings())
        .createImportDataFileOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteImportDataFile. */
  public UnaryCallSettings<DeleteImportDataFileRequest, Operation> deleteImportDataFileSettings() {
    return ((MigrationCenterStubSettings) getStubSettings()).deleteImportDataFileSettings();
  }

  /** Returns the object with the settings used for calls to deleteImportDataFile. */
  public OperationCallSettings<DeleteImportDataFileRequest, Empty, OperationMetadata>
      deleteImportDataFileOperationSettings() {
    return ((MigrationCenterStubSettings) getStubSettings())
        .deleteImportDataFileOperationSettings();
  }

  /** Returns the object with the settings used for calls to listGroups. */
  public PagedCallSettings<ListGroupsRequest, ListGroupsResponse, ListGroupsPagedResponse>
      listGroupsSettings() {
    return ((MigrationCenterStubSettings) getStubSettings()).listGroupsSettings();
  }

  /** Returns the object with the settings used for calls to getGroup. */
  public UnaryCallSettings<GetGroupRequest, Group> getGroupSettings() {
    return ((MigrationCenterStubSettings) getStubSettings()).getGroupSettings();
  }

  /** Returns the object with the settings used for calls to createGroup. */
  public UnaryCallSettings<CreateGroupRequest, Operation> createGroupSettings() {
    return ((MigrationCenterStubSettings) getStubSettings()).createGroupSettings();
  }

  /** Returns the object with the settings used for calls to createGroup. */
  public OperationCallSettings<CreateGroupRequest, Group, OperationMetadata>
      createGroupOperationSettings() {
    return ((MigrationCenterStubSettings) getStubSettings()).createGroupOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateGroup. */
  public UnaryCallSettings<UpdateGroupRequest, Operation> updateGroupSettings() {
    return ((MigrationCenterStubSettings) getStubSettings()).updateGroupSettings();
  }

  /** Returns the object with the settings used for calls to updateGroup. */
  public OperationCallSettings<UpdateGroupRequest, Group, OperationMetadata>
      updateGroupOperationSettings() {
    return ((MigrationCenterStubSettings) getStubSettings()).updateGroupOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteGroup. */
  public UnaryCallSettings<DeleteGroupRequest, Operation> deleteGroupSettings() {
    return ((MigrationCenterStubSettings) getStubSettings()).deleteGroupSettings();
  }

  /** Returns the object with the settings used for calls to deleteGroup. */
  public OperationCallSettings<DeleteGroupRequest, Empty, OperationMetadata>
      deleteGroupOperationSettings() {
    return ((MigrationCenterStubSettings) getStubSettings()).deleteGroupOperationSettings();
  }

  /** Returns the object with the settings used for calls to addAssetsToGroup. */
  public UnaryCallSettings<AddAssetsToGroupRequest, Operation> addAssetsToGroupSettings() {
    return ((MigrationCenterStubSettings) getStubSettings()).addAssetsToGroupSettings();
  }

  /** Returns the object with the settings used for calls to addAssetsToGroup. */
  public OperationCallSettings<AddAssetsToGroupRequest, Group, OperationMetadata>
      addAssetsToGroupOperationSettings() {
    return ((MigrationCenterStubSettings) getStubSettings()).addAssetsToGroupOperationSettings();
  }

  /** Returns the object with the settings used for calls to removeAssetsFromGroup. */
  public UnaryCallSettings<RemoveAssetsFromGroupRequest, Operation>
      removeAssetsFromGroupSettings() {
    return ((MigrationCenterStubSettings) getStubSettings()).removeAssetsFromGroupSettings();
  }

  /** Returns the object with the settings used for calls to removeAssetsFromGroup. */
  public OperationCallSettings<RemoveAssetsFromGroupRequest, Group, OperationMetadata>
      removeAssetsFromGroupOperationSettings() {
    return ((MigrationCenterStubSettings) getStubSettings())
        .removeAssetsFromGroupOperationSettings();
  }

  /** Returns the object with the settings used for calls to listErrorFrames. */
  public PagedCallSettings<
          ListErrorFramesRequest, ListErrorFramesResponse, ListErrorFramesPagedResponse>
      listErrorFramesSettings() {
    return ((MigrationCenterStubSettings) getStubSettings()).listErrorFramesSettings();
  }

  /** Returns the object with the settings used for calls to getErrorFrame. */
  public UnaryCallSettings<GetErrorFrameRequest, ErrorFrame> getErrorFrameSettings() {
    return ((MigrationCenterStubSettings) getStubSettings()).getErrorFrameSettings();
  }

  /** Returns the object with the settings used for calls to listSources. */
  public PagedCallSettings<ListSourcesRequest, ListSourcesResponse, ListSourcesPagedResponse>
      listSourcesSettings() {
    return ((MigrationCenterStubSettings) getStubSettings()).listSourcesSettings();
  }

  /** Returns the object with the settings used for calls to getSource. */
  public UnaryCallSettings<GetSourceRequest, Source> getSourceSettings() {
    return ((MigrationCenterStubSettings) getStubSettings()).getSourceSettings();
  }

  /** Returns the object with the settings used for calls to createSource. */
  public UnaryCallSettings<CreateSourceRequest, Operation> createSourceSettings() {
    return ((MigrationCenterStubSettings) getStubSettings()).createSourceSettings();
  }

  /** Returns the object with the settings used for calls to createSource. */
  public OperationCallSettings<CreateSourceRequest, Source, OperationMetadata>
      createSourceOperationSettings() {
    return ((MigrationCenterStubSettings) getStubSettings()).createSourceOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateSource. */
  public UnaryCallSettings<UpdateSourceRequest, Operation> updateSourceSettings() {
    return ((MigrationCenterStubSettings) getStubSettings()).updateSourceSettings();
  }

  /** Returns the object with the settings used for calls to updateSource. */
  public OperationCallSettings<UpdateSourceRequest, Source, OperationMetadata>
      updateSourceOperationSettings() {
    return ((MigrationCenterStubSettings) getStubSettings()).updateSourceOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteSource. */
  public UnaryCallSettings<DeleteSourceRequest, Operation> deleteSourceSettings() {
    return ((MigrationCenterStubSettings) getStubSettings()).deleteSourceSettings();
  }

  /** Returns the object with the settings used for calls to deleteSource. */
  public OperationCallSettings<DeleteSourceRequest, Empty, OperationMetadata>
      deleteSourceOperationSettings() {
    return ((MigrationCenterStubSettings) getStubSettings()).deleteSourceOperationSettings();
  }

  /** Returns the object with the settings used for calls to listPreferenceSets. */
  public PagedCallSettings<
          ListPreferenceSetsRequest, ListPreferenceSetsResponse, ListPreferenceSetsPagedResponse>
      listPreferenceSetsSettings() {
    return ((MigrationCenterStubSettings) getStubSettings()).listPreferenceSetsSettings();
  }

  /** Returns the object with the settings used for calls to getPreferenceSet. */
  public UnaryCallSettings<GetPreferenceSetRequest, PreferenceSet> getPreferenceSetSettings() {
    return ((MigrationCenterStubSettings) getStubSettings()).getPreferenceSetSettings();
  }

  /** Returns the object with the settings used for calls to createPreferenceSet. */
  public UnaryCallSettings<CreatePreferenceSetRequest, Operation> createPreferenceSetSettings() {
    return ((MigrationCenterStubSettings) getStubSettings()).createPreferenceSetSettings();
  }

  /** Returns the object with the settings used for calls to createPreferenceSet. */
  public OperationCallSettings<CreatePreferenceSetRequest, PreferenceSet, OperationMetadata>
      createPreferenceSetOperationSettings() {
    return ((MigrationCenterStubSettings) getStubSettings()).createPreferenceSetOperationSettings();
  }

  /** Returns the object with the settings used for calls to updatePreferenceSet. */
  public UnaryCallSettings<UpdatePreferenceSetRequest, Operation> updatePreferenceSetSettings() {
    return ((MigrationCenterStubSettings) getStubSettings()).updatePreferenceSetSettings();
  }

  /** Returns the object with the settings used for calls to updatePreferenceSet. */
  public OperationCallSettings<UpdatePreferenceSetRequest, PreferenceSet, OperationMetadata>
      updatePreferenceSetOperationSettings() {
    return ((MigrationCenterStubSettings) getStubSettings()).updatePreferenceSetOperationSettings();
  }

  /** Returns the object with the settings used for calls to deletePreferenceSet. */
  public UnaryCallSettings<DeletePreferenceSetRequest, Operation> deletePreferenceSetSettings() {
    return ((MigrationCenterStubSettings) getStubSettings()).deletePreferenceSetSettings();
  }

  /** Returns the object with the settings used for calls to deletePreferenceSet. */
  public OperationCallSettings<DeletePreferenceSetRequest, Empty, OperationMetadata>
      deletePreferenceSetOperationSettings() {
    return ((MigrationCenterStubSettings) getStubSettings()).deletePreferenceSetOperationSettings();
  }

  /** Returns the object with the settings used for calls to getSettings. */
  public UnaryCallSettings<GetSettingsRequest, Settings> getSettingsSettings() {
    return ((MigrationCenterStubSettings) getStubSettings()).getSettingsSettings();
  }

  /** Returns the object with the settings used for calls to updateSettings. */
  public UnaryCallSettings<UpdateSettingsRequest, Operation> updateSettingsSettings() {
    return ((MigrationCenterStubSettings) getStubSettings()).updateSettingsSettings();
  }

  /** Returns the object with the settings used for calls to updateSettings. */
  public OperationCallSettings<UpdateSettingsRequest, Settings, OperationMetadata>
      updateSettingsOperationSettings() {
    return ((MigrationCenterStubSettings) getStubSettings()).updateSettingsOperationSettings();
  }

  /** Returns the object with the settings used for calls to createReportConfig. */
  public UnaryCallSettings<CreateReportConfigRequest, Operation> createReportConfigSettings() {
    return ((MigrationCenterStubSettings) getStubSettings()).createReportConfigSettings();
  }

  /** Returns the object with the settings used for calls to createReportConfig. */
  public OperationCallSettings<CreateReportConfigRequest, ReportConfig, OperationMetadata>
      createReportConfigOperationSettings() {
    return ((MigrationCenterStubSettings) getStubSettings()).createReportConfigOperationSettings();
  }

  /** Returns the object with the settings used for calls to getReportConfig. */
  public UnaryCallSettings<GetReportConfigRequest, ReportConfig> getReportConfigSettings() {
    return ((MigrationCenterStubSettings) getStubSettings()).getReportConfigSettings();
  }

  /** Returns the object with the settings used for calls to listReportConfigs. */
  public PagedCallSettings<
          ListReportConfigsRequest, ListReportConfigsResponse, ListReportConfigsPagedResponse>
      listReportConfigsSettings() {
    return ((MigrationCenterStubSettings) getStubSettings()).listReportConfigsSettings();
  }

  /** Returns the object with the settings used for calls to deleteReportConfig. */
  public UnaryCallSettings<DeleteReportConfigRequest, Operation> deleteReportConfigSettings() {
    return ((MigrationCenterStubSettings) getStubSettings()).deleteReportConfigSettings();
  }

  /** Returns the object with the settings used for calls to deleteReportConfig. */
  public OperationCallSettings<DeleteReportConfigRequest, Empty, OperationMetadata>
      deleteReportConfigOperationSettings() {
    return ((MigrationCenterStubSettings) getStubSettings()).deleteReportConfigOperationSettings();
  }

  /** Returns the object with the settings used for calls to createReport. */
  public UnaryCallSettings<CreateReportRequest, Operation> createReportSettings() {
    return ((MigrationCenterStubSettings) getStubSettings()).createReportSettings();
  }

  /** Returns the object with the settings used for calls to createReport. */
  public OperationCallSettings<CreateReportRequest, Report, OperationMetadata>
      createReportOperationSettings() {
    return ((MigrationCenterStubSettings) getStubSettings()).createReportOperationSettings();
  }

  /** Returns the object with the settings used for calls to getReport. */
  public UnaryCallSettings<GetReportRequest, Report> getReportSettings() {
    return ((MigrationCenterStubSettings) getStubSettings()).getReportSettings();
  }

  /** Returns the object with the settings used for calls to listReports. */
  public PagedCallSettings<ListReportsRequest, ListReportsResponse, ListReportsPagedResponse>
      listReportsSettings() {
    return ((MigrationCenterStubSettings) getStubSettings()).listReportsSettings();
  }

  /** Returns the object with the settings used for calls to deleteReport. */
  public UnaryCallSettings<DeleteReportRequest, Operation> deleteReportSettings() {
    return ((MigrationCenterStubSettings) getStubSettings()).deleteReportSettings();
  }

  /** Returns the object with the settings used for calls to deleteReport. */
  public OperationCallSettings<DeleteReportRequest, Empty, OperationMetadata>
      deleteReportOperationSettings() {
    return ((MigrationCenterStubSettings) getStubSettings()).deleteReportOperationSettings();
  }

  /** Returns the object with the settings used for calls to listLocations. */
  public PagedCallSettings<ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings() {
    return ((MigrationCenterStubSettings) getStubSettings()).listLocationsSettings();
  }

  /** Returns the object with the settings used for calls to getLocation. */
  public UnaryCallSettings<GetLocationRequest, Location> getLocationSettings() {
    return ((MigrationCenterStubSettings) getStubSettings()).getLocationSettings();
  }

  public static final MigrationCenterSettings create(MigrationCenterStubSettings stub)
      throws IOException {
    return new MigrationCenterSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return MigrationCenterStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return MigrationCenterStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return MigrationCenterStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return MigrationCenterStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return MigrationCenterStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return MigrationCenterStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return MigrationCenterStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return MigrationCenterStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected MigrationCenterSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for MigrationCenterSettings. */
  public static class Builder extends ClientSettings.Builder<MigrationCenterSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(MigrationCenterStubSettings.newBuilder(clientContext));
    }

    protected Builder(MigrationCenterSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(MigrationCenterStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(MigrationCenterStubSettings.newBuilder());
    }

    @BetaApi
    private static Builder createHttpJsonDefault() {
      return new Builder(MigrationCenterStubSettings.newHttpJsonBuilder());
    }

    public MigrationCenterStubSettings.Builder getStubSettingsBuilder() {
      return ((MigrationCenterStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to listAssets. */
    public PagedCallSettings.Builder<ListAssetsRequest, ListAssetsResponse, ListAssetsPagedResponse>
        listAssetsSettings() {
      return getStubSettingsBuilder().listAssetsSettings();
    }

    /** Returns the builder for the settings used for calls to getAsset. */
    public UnaryCallSettings.Builder<GetAssetRequest, Asset> getAssetSettings() {
      return getStubSettingsBuilder().getAssetSettings();
    }

    /** Returns the builder for the settings used for calls to updateAsset. */
    public UnaryCallSettings.Builder<UpdateAssetRequest, Asset> updateAssetSettings() {
      return getStubSettingsBuilder().updateAssetSettings();
    }

    /** Returns the builder for the settings used for calls to batchUpdateAssets. */
    public UnaryCallSettings.Builder<BatchUpdateAssetsRequest, BatchUpdateAssetsResponse>
        batchUpdateAssetsSettings() {
      return getStubSettingsBuilder().batchUpdateAssetsSettings();
    }

    /** Returns the builder for the settings used for calls to deleteAsset. */
    public UnaryCallSettings.Builder<DeleteAssetRequest, Empty> deleteAssetSettings() {
      return getStubSettingsBuilder().deleteAssetSettings();
    }

    /** Returns the builder for the settings used for calls to batchDeleteAssets. */
    public UnaryCallSettings.Builder<BatchDeleteAssetsRequest, Empty> batchDeleteAssetsSettings() {
      return getStubSettingsBuilder().batchDeleteAssetsSettings();
    }

    /** Returns the builder for the settings used for calls to reportAssetFrames. */
    public UnaryCallSettings.Builder<ReportAssetFramesRequest, ReportAssetFramesResponse>
        reportAssetFramesSettings() {
      return getStubSettingsBuilder().reportAssetFramesSettings();
    }

    /** Returns the builder for the settings used for calls to aggregateAssetsValues. */
    public UnaryCallSettings.Builder<AggregateAssetsValuesRequest, AggregateAssetsValuesResponse>
        aggregateAssetsValuesSettings() {
      return getStubSettingsBuilder().aggregateAssetsValuesSettings();
    }

    /** Returns the builder for the settings used for calls to createImportJob. */
    public UnaryCallSettings.Builder<CreateImportJobRequest, Operation> createImportJobSettings() {
      return getStubSettingsBuilder().createImportJobSettings();
    }

    /** Returns the builder for the settings used for calls to createImportJob. */
    public OperationCallSettings.Builder<CreateImportJobRequest, ImportJob, OperationMetadata>
        createImportJobOperationSettings() {
      return getStubSettingsBuilder().createImportJobOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listImportJobs. */
    public PagedCallSettings.Builder<
            ListImportJobsRequest, ListImportJobsResponse, ListImportJobsPagedResponse>
        listImportJobsSettings() {
      return getStubSettingsBuilder().listImportJobsSettings();
    }

    /** Returns the builder for the settings used for calls to getImportJob. */
    public UnaryCallSettings.Builder<GetImportJobRequest, ImportJob> getImportJobSettings() {
      return getStubSettingsBuilder().getImportJobSettings();
    }

    /** Returns the builder for the settings used for calls to deleteImportJob. */
    public UnaryCallSettings.Builder<DeleteImportJobRequest, Operation> deleteImportJobSettings() {
      return getStubSettingsBuilder().deleteImportJobSettings();
    }

    /** Returns the builder for the settings used for calls to deleteImportJob. */
    public OperationCallSettings.Builder<DeleteImportJobRequest, Empty, OperationMetadata>
        deleteImportJobOperationSettings() {
      return getStubSettingsBuilder().deleteImportJobOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateImportJob. */
    public UnaryCallSettings.Builder<UpdateImportJobRequest, Operation> updateImportJobSettings() {
      return getStubSettingsBuilder().updateImportJobSettings();
    }

    /** Returns the builder for the settings used for calls to updateImportJob. */
    public OperationCallSettings.Builder<UpdateImportJobRequest, ImportJob, OperationMetadata>
        updateImportJobOperationSettings() {
      return getStubSettingsBuilder().updateImportJobOperationSettings();
    }

    /** Returns the builder for the settings used for calls to validateImportJob. */
    public UnaryCallSettings.Builder<ValidateImportJobRequest, Operation>
        validateImportJobSettings() {
      return getStubSettingsBuilder().validateImportJobSettings();
    }

    /** Returns the builder for the settings used for calls to validateImportJob. */
    public OperationCallSettings.Builder<ValidateImportJobRequest, Empty, OperationMetadata>
        validateImportJobOperationSettings() {
      return getStubSettingsBuilder().validateImportJobOperationSettings();
    }

    /** Returns the builder for the settings used for calls to runImportJob. */
    public UnaryCallSettings.Builder<RunImportJobRequest, Operation> runImportJobSettings() {
      return getStubSettingsBuilder().runImportJobSettings();
    }

    /** Returns the builder for the settings used for calls to runImportJob. */
    public OperationCallSettings.Builder<RunImportJobRequest, Empty, OperationMetadata>
        runImportJobOperationSettings() {
      return getStubSettingsBuilder().runImportJobOperationSettings();
    }

    /** Returns the builder for the settings used for calls to getImportDataFile. */
    public UnaryCallSettings.Builder<GetImportDataFileRequest, ImportDataFile>
        getImportDataFileSettings() {
      return getStubSettingsBuilder().getImportDataFileSettings();
    }

    /** Returns the builder for the settings used for calls to listImportDataFiles. */
    public PagedCallSettings.Builder<
            ListImportDataFilesRequest,
            ListImportDataFilesResponse,
            ListImportDataFilesPagedResponse>
        listImportDataFilesSettings() {
      return getStubSettingsBuilder().listImportDataFilesSettings();
    }

    /** Returns the builder for the settings used for calls to createImportDataFile. */
    public UnaryCallSettings.Builder<CreateImportDataFileRequest, Operation>
        createImportDataFileSettings() {
      return getStubSettingsBuilder().createImportDataFileSettings();
    }

    /** Returns the builder for the settings used for calls to createImportDataFile. */
    public OperationCallSettings.Builder<
            CreateImportDataFileRequest, ImportDataFile, OperationMetadata>
        createImportDataFileOperationSettings() {
      return getStubSettingsBuilder().createImportDataFileOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteImportDataFile. */
    public UnaryCallSettings.Builder<DeleteImportDataFileRequest, Operation>
        deleteImportDataFileSettings() {
      return getStubSettingsBuilder().deleteImportDataFileSettings();
    }

    /** Returns the builder for the settings used for calls to deleteImportDataFile. */
    public OperationCallSettings.Builder<DeleteImportDataFileRequest, Empty, OperationMetadata>
        deleteImportDataFileOperationSettings() {
      return getStubSettingsBuilder().deleteImportDataFileOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listGroups. */
    public PagedCallSettings.Builder<ListGroupsRequest, ListGroupsResponse, ListGroupsPagedResponse>
        listGroupsSettings() {
      return getStubSettingsBuilder().listGroupsSettings();
    }

    /** Returns the builder for the settings used for calls to getGroup. */
    public UnaryCallSettings.Builder<GetGroupRequest, Group> getGroupSettings() {
      return getStubSettingsBuilder().getGroupSettings();
    }

    /** Returns the builder for the settings used for calls to createGroup. */
    public UnaryCallSettings.Builder<CreateGroupRequest, Operation> createGroupSettings() {
      return getStubSettingsBuilder().createGroupSettings();
    }

    /** Returns the builder for the settings used for calls to createGroup. */
    public OperationCallSettings.Builder<CreateGroupRequest, Group, OperationMetadata>
        createGroupOperationSettings() {
      return getStubSettingsBuilder().createGroupOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateGroup. */
    public UnaryCallSettings.Builder<UpdateGroupRequest, Operation> updateGroupSettings() {
      return getStubSettingsBuilder().updateGroupSettings();
    }

    /** Returns the builder for the settings used for calls to updateGroup. */
    public OperationCallSettings.Builder<UpdateGroupRequest, Group, OperationMetadata>
        updateGroupOperationSettings() {
      return getStubSettingsBuilder().updateGroupOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteGroup. */
    public UnaryCallSettings.Builder<DeleteGroupRequest, Operation> deleteGroupSettings() {
      return getStubSettingsBuilder().deleteGroupSettings();
    }

    /** Returns the builder for the settings used for calls to deleteGroup. */
    public OperationCallSettings.Builder<DeleteGroupRequest, Empty, OperationMetadata>
        deleteGroupOperationSettings() {
      return getStubSettingsBuilder().deleteGroupOperationSettings();
    }

    /** Returns the builder for the settings used for calls to addAssetsToGroup. */
    public UnaryCallSettings.Builder<AddAssetsToGroupRequest, Operation>
        addAssetsToGroupSettings() {
      return getStubSettingsBuilder().addAssetsToGroupSettings();
    }

    /** Returns the builder for the settings used for calls to addAssetsToGroup. */
    public OperationCallSettings.Builder<AddAssetsToGroupRequest, Group, OperationMetadata>
        addAssetsToGroupOperationSettings() {
      return getStubSettingsBuilder().addAssetsToGroupOperationSettings();
    }

    /** Returns the builder for the settings used for calls to removeAssetsFromGroup. */
    public UnaryCallSettings.Builder<RemoveAssetsFromGroupRequest, Operation>
        removeAssetsFromGroupSettings() {
      return getStubSettingsBuilder().removeAssetsFromGroupSettings();
    }

    /** Returns the builder for the settings used for calls to removeAssetsFromGroup. */
    public OperationCallSettings.Builder<RemoveAssetsFromGroupRequest, Group, OperationMetadata>
        removeAssetsFromGroupOperationSettings() {
      return getStubSettingsBuilder().removeAssetsFromGroupOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listErrorFrames. */
    public PagedCallSettings.Builder<
            ListErrorFramesRequest, ListErrorFramesResponse, ListErrorFramesPagedResponse>
        listErrorFramesSettings() {
      return getStubSettingsBuilder().listErrorFramesSettings();
    }

    /** Returns the builder for the settings used for calls to getErrorFrame. */
    public UnaryCallSettings.Builder<GetErrorFrameRequest, ErrorFrame> getErrorFrameSettings() {
      return getStubSettingsBuilder().getErrorFrameSettings();
    }

    /** Returns the builder for the settings used for calls to listSources. */
    public PagedCallSettings.Builder<
            ListSourcesRequest, ListSourcesResponse, ListSourcesPagedResponse>
        listSourcesSettings() {
      return getStubSettingsBuilder().listSourcesSettings();
    }

    /** Returns the builder for the settings used for calls to getSource. */
    public UnaryCallSettings.Builder<GetSourceRequest, Source> getSourceSettings() {
      return getStubSettingsBuilder().getSourceSettings();
    }

    /** Returns the builder for the settings used for calls to createSource. */
    public UnaryCallSettings.Builder<CreateSourceRequest, Operation> createSourceSettings() {
      return getStubSettingsBuilder().createSourceSettings();
    }

    /** Returns the builder for the settings used for calls to createSource. */
    public OperationCallSettings.Builder<CreateSourceRequest, Source, OperationMetadata>
        createSourceOperationSettings() {
      return getStubSettingsBuilder().createSourceOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateSource. */
    public UnaryCallSettings.Builder<UpdateSourceRequest, Operation> updateSourceSettings() {
      return getStubSettingsBuilder().updateSourceSettings();
    }

    /** Returns the builder for the settings used for calls to updateSource. */
    public OperationCallSettings.Builder<UpdateSourceRequest, Source, OperationMetadata>
        updateSourceOperationSettings() {
      return getStubSettingsBuilder().updateSourceOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteSource. */
    public UnaryCallSettings.Builder<DeleteSourceRequest, Operation> deleteSourceSettings() {
      return getStubSettingsBuilder().deleteSourceSettings();
    }

    /** Returns the builder for the settings used for calls to deleteSource. */
    public OperationCallSettings.Builder<DeleteSourceRequest, Empty, OperationMetadata>
        deleteSourceOperationSettings() {
      return getStubSettingsBuilder().deleteSourceOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listPreferenceSets. */
    public PagedCallSettings.Builder<
            ListPreferenceSetsRequest, ListPreferenceSetsResponse, ListPreferenceSetsPagedResponse>
        listPreferenceSetsSettings() {
      return getStubSettingsBuilder().listPreferenceSetsSettings();
    }

    /** Returns the builder for the settings used for calls to getPreferenceSet. */
    public UnaryCallSettings.Builder<GetPreferenceSetRequest, PreferenceSet>
        getPreferenceSetSettings() {
      return getStubSettingsBuilder().getPreferenceSetSettings();
    }

    /** Returns the builder for the settings used for calls to createPreferenceSet. */
    public UnaryCallSettings.Builder<CreatePreferenceSetRequest, Operation>
        createPreferenceSetSettings() {
      return getStubSettingsBuilder().createPreferenceSetSettings();
    }

    /** Returns the builder for the settings used for calls to createPreferenceSet. */
    public OperationCallSettings.Builder<
            CreatePreferenceSetRequest, PreferenceSet, OperationMetadata>
        createPreferenceSetOperationSettings() {
      return getStubSettingsBuilder().createPreferenceSetOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updatePreferenceSet. */
    public UnaryCallSettings.Builder<UpdatePreferenceSetRequest, Operation>
        updatePreferenceSetSettings() {
      return getStubSettingsBuilder().updatePreferenceSetSettings();
    }

    /** Returns the builder for the settings used for calls to updatePreferenceSet. */
    public OperationCallSettings.Builder<
            UpdatePreferenceSetRequest, PreferenceSet, OperationMetadata>
        updatePreferenceSetOperationSettings() {
      return getStubSettingsBuilder().updatePreferenceSetOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deletePreferenceSet. */
    public UnaryCallSettings.Builder<DeletePreferenceSetRequest, Operation>
        deletePreferenceSetSettings() {
      return getStubSettingsBuilder().deletePreferenceSetSettings();
    }

    /** Returns the builder for the settings used for calls to deletePreferenceSet. */
    public OperationCallSettings.Builder<DeletePreferenceSetRequest, Empty, OperationMetadata>
        deletePreferenceSetOperationSettings() {
      return getStubSettingsBuilder().deletePreferenceSetOperationSettings();
    }

    /** Returns the builder for the settings used for calls to getSettings. */
    public UnaryCallSettings.Builder<GetSettingsRequest, Settings> getSettingsSettings() {
      return getStubSettingsBuilder().getSettingsSettings();
    }

    /** Returns the builder for the settings used for calls to updateSettings. */
    public UnaryCallSettings.Builder<UpdateSettingsRequest, Operation> updateSettingsSettings() {
      return getStubSettingsBuilder().updateSettingsSettings();
    }

    /** Returns the builder for the settings used for calls to updateSettings. */
    public OperationCallSettings.Builder<UpdateSettingsRequest, Settings, OperationMetadata>
        updateSettingsOperationSettings() {
      return getStubSettingsBuilder().updateSettingsOperationSettings();
    }

    /** Returns the builder for the settings used for calls to createReportConfig. */
    public UnaryCallSettings.Builder<CreateReportConfigRequest, Operation>
        createReportConfigSettings() {
      return getStubSettingsBuilder().createReportConfigSettings();
    }

    /** Returns the builder for the settings used for calls to createReportConfig. */
    public OperationCallSettings.Builder<CreateReportConfigRequest, ReportConfig, OperationMetadata>
        createReportConfigOperationSettings() {
      return getStubSettingsBuilder().createReportConfigOperationSettings();
    }

    /** Returns the builder for the settings used for calls to getReportConfig. */
    public UnaryCallSettings.Builder<GetReportConfigRequest, ReportConfig>
        getReportConfigSettings() {
      return getStubSettingsBuilder().getReportConfigSettings();
    }

    /** Returns the builder for the settings used for calls to listReportConfigs. */
    public PagedCallSettings.Builder<
            ListReportConfigsRequest, ListReportConfigsResponse, ListReportConfigsPagedResponse>
        listReportConfigsSettings() {
      return getStubSettingsBuilder().listReportConfigsSettings();
    }

    /** Returns the builder for the settings used for calls to deleteReportConfig. */
    public UnaryCallSettings.Builder<DeleteReportConfigRequest, Operation>
        deleteReportConfigSettings() {
      return getStubSettingsBuilder().deleteReportConfigSettings();
    }

    /** Returns the builder for the settings used for calls to deleteReportConfig. */
    public OperationCallSettings.Builder<DeleteReportConfigRequest, Empty, OperationMetadata>
        deleteReportConfigOperationSettings() {
      return getStubSettingsBuilder().deleteReportConfigOperationSettings();
    }

    /** Returns the builder for the settings used for calls to createReport. */
    public UnaryCallSettings.Builder<CreateReportRequest, Operation> createReportSettings() {
      return getStubSettingsBuilder().createReportSettings();
    }

    /** Returns the builder for the settings used for calls to createReport. */
    public OperationCallSettings.Builder<CreateReportRequest, Report, OperationMetadata>
        createReportOperationSettings() {
      return getStubSettingsBuilder().createReportOperationSettings();
    }

    /** Returns the builder for the settings used for calls to getReport. */
    public UnaryCallSettings.Builder<GetReportRequest, Report> getReportSettings() {
      return getStubSettingsBuilder().getReportSettings();
    }

    /** Returns the builder for the settings used for calls to listReports. */
    public PagedCallSettings.Builder<
            ListReportsRequest, ListReportsResponse, ListReportsPagedResponse>
        listReportsSettings() {
      return getStubSettingsBuilder().listReportsSettings();
    }

    /** Returns the builder for the settings used for calls to deleteReport. */
    public UnaryCallSettings.Builder<DeleteReportRequest, Operation> deleteReportSettings() {
      return getStubSettingsBuilder().deleteReportSettings();
    }

    /** Returns the builder for the settings used for calls to deleteReport. */
    public OperationCallSettings.Builder<DeleteReportRequest, Empty, OperationMetadata>
        deleteReportOperationSettings() {
      return getStubSettingsBuilder().deleteReportOperationSettings();
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
    public MigrationCenterSettings build() throws IOException {
      return new MigrationCenterSettings(this);
    }
  }
}
