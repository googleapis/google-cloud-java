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

package com.google.cloud.vmmigration.v1;

import static com.google.cloud.vmmigration.v1.VmMigrationClient.ListCloneJobsPagedResponse;
import static com.google.cloud.vmmigration.v1.VmMigrationClient.ListCutoverJobsPagedResponse;
import static com.google.cloud.vmmigration.v1.VmMigrationClient.ListDatacenterConnectorsPagedResponse;
import static com.google.cloud.vmmigration.v1.VmMigrationClient.ListGroupsPagedResponse;
import static com.google.cloud.vmmigration.v1.VmMigrationClient.ListMigratingVmsPagedResponse;
import static com.google.cloud.vmmigration.v1.VmMigrationClient.ListSourcesPagedResponse;
import static com.google.cloud.vmmigration.v1.VmMigrationClient.ListTargetProjectsPagedResponse;
import static com.google.cloud.vmmigration.v1.VmMigrationClient.ListUtilizationReportsPagedResponse;

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
import com.google.cloud.vmmigration.v1.stub.VmMigrationStubSettings;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link VmMigrationClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (vmmigration.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getSource to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * VmMigrationSettings.Builder vmMigrationSettingsBuilder = VmMigrationSettings.newBuilder();
 * vmMigrationSettingsBuilder
 *     .getSourceSettings()
 *     .setRetrySettings(
 *         vmMigrationSettingsBuilder.getSourceSettings().getRetrySettings().toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * VmMigrationSettings vmMigrationSettings = vmMigrationSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class VmMigrationSettings extends ClientSettings<VmMigrationSettings> {

  /** Returns the object with the settings used for calls to listSources. */
  public PagedCallSettings<ListSourcesRequest, ListSourcesResponse, ListSourcesPagedResponse>
      listSourcesSettings() {
    return ((VmMigrationStubSettings) getStubSettings()).listSourcesSettings();
  }

  /** Returns the object with the settings used for calls to getSource. */
  public UnaryCallSettings<GetSourceRequest, Source> getSourceSettings() {
    return ((VmMigrationStubSettings) getStubSettings()).getSourceSettings();
  }

  /** Returns the object with the settings used for calls to createSource. */
  public UnaryCallSettings<CreateSourceRequest, Operation> createSourceSettings() {
    return ((VmMigrationStubSettings) getStubSettings()).createSourceSettings();
  }

  /** Returns the object with the settings used for calls to createSource. */
  public OperationCallSettings<CreateSourceRequest, Source, OperationMetadata>
      createSourceOperationSettings() {
    return ((VmMigrationStubSettings) getStubSettings()).createSourceOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateSource. */
  public UnaryCallSettings<UpdateSourceRequest, Operation> updateSourceSettings() {
    return ((VmMigrationStubSettings) getStubSettings()).updateSourceSettings();
  }

  /** Returns the object with the settings used for calls to updateSource. */
  public OperationCallSettings<UpdateSourceRequest, Source, OperationMetadata>
      updateSourceOperationSettings() {
    return ((VmMigrationStubSettings) getStubSettings()).updateSourceOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteSource. */
  public UnaryCallSettings<DeleteSourceRequest, Operation> deleteSourceSettings() {
    return ((VmMigrationStubSettings) getStubSettings()).deleteSourceSettings();
  }

  /** Returns the object with the settings used for calls to deleteSource. */
  public OperationCallSettings<DeleteSourceRequest, Empty, OperationMetadata>
      deleteSourceOperationSettings() {
    return ((VmMigrationStubSettings) getStubSettings()).deleteSourceOperationSettings();
  }

  /** Returns the object with the settings used for calls to fetchInventory. */
  public UnaryCallSettings<FetchInventoryRequest, FetchInventoryResponse> fetchInventorySettings() {
    return ((VmMigrationStubSettings) getStubSettings()).fetchInventorySettings();
  }

  /** Returns the object with the settings used for calls to listUtilizationReports. */
  public PagedCallSettings<
          ListUtilizationReportsRequest,
          ListUtilizationReportsResponse,
          ListUtilizationReportsPagedResponse>
      listUtilizationReportsSettings() {
    return ((VmMigrationStubSettings) getStubSettings()).listUtilizationReportsSettings();
  }

  /** Returns the object with the settings used for calls to getUtilizationReport. */
  public UnaryCallSettings<GetUtilizationReportRequest, UtilizationReport>
      getUtilizationReportSettings() {
    return ((VmMigrationStubSettings) getStubSettings()).getUtilizationReportSettings();
  }

  /** Returns the object with the settings used for calls to createUtilizationReport. */
  public UnaryCallSettings<CreateUtilizationReportRequest, Operation>
      createUtilizationReportSettings() {
    return ((VmMigrationStubSettings) getStubSettings()).createUtilizationReportSettings();
  }

  /** Returns the object with the settings used for calls to createUtilizationReport. */
  public OperationCallSettings<CreateUtilizationReportRequest, UtilizationReport, OperationMetadata>
      createUtilizationReportOperationSettings() {
    return ((VmMigrationStubSettings) getStubSettings()).createUtilizationReportOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteUtilizationReport. */
  public UnaryCallSettings<DeleteUtilizationReportRequest, Operation>
      deleteUtilizationReportSettings() {
    return ((VmMigrationStubSettings) getStubSettings()).deleteUtilizationReportSettings();
  }

  /** Returns the object with the settings used for calls to deleteUtilizationReport. */
  public OperationCallSettings<DeleteUtilizationReportRequest, Empty, OperationMetadata>
      deleteUtilizationReportOperationSettings() {
    return ((VmMigrationStubSettings) getStubSettings()).deleteUtilizationReportOperationSettings();
  }

  /** Returns the object with the settings used for calls to listDatacenterConnectors. */
  public PagedCallSettings<
          ListDatacenterConnectorsRequest,
          ListDatacenterConnectorsResponse,
          ListDatacenterConnectorsPagedResponse>
      listDatacenterConnectorsSettings() {
    return ((VmMigrationStubSettings) getStubSettings()).listDatacenterConnectorsSettings();
  }

  /** Returns the object with the settings used for calls to getDatacenterConnector. */
  public UnaryCallSettings<GetDatacenterConnectorRequest, DatacenterConnector>
      getDatacenterConnectorSettings() {
    return ((VmMigrationStubSettings) getStubSettings()).getDatacenterConnectorSettings();
  }

  /** Returns the object with the settings used for calls to createDatacenterConnector. */
  public UnaryCallSettings<CreateDatacenterConnectorRequest, Operation>
      createDatacenterConnectorSettings() {
    return ((VmMigrationStubSettings) getStubSettings()).createDatacenterConnectorSettings();
  }

  /** Returns the object with the settings used for calls to createDatacenterConnector. */
  public OperationCallSettings<
          CreateDatacenterConnectorRequest, DatacenterConnector, OperationMetadata>
      createDatacenterConnectorOperationSettings() {
    return ((VmMigrationStubSettings) getStubSettings())
        .createDatacenterConnectorOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteDatacenterConnector. */
  public UnaryCallSettings<DeleteDatacenterConnectorRequest, Operation>
      deleteDatacenterConnectorSettings() {
    return ((VmMigrationStubSettings) getStubSettings()).deleteDatacenterConnectorSettings();
  }

  /** Returns the object with the settings used for calls to deleteDatacenterConnector. */
  public OperationCallSettings<DeleteDatacenterConnectorRequest, Empty, OperationMetadata>
      deleteDatacenterConnectorOperationSettings() {
    return ((VmMigrationStubSettings) getStubSettings())
        .deleteDatacenterConnectorOperationSettings();
  }

  /** Returns the object with the settings used for calls to upgradeAppliance. */
  public UnaryCallSettings<UpgradeApplianceRequest, Operation> upgradeApplianceSettings() {
    return ((VmMigrationStubSettings) getStubSettings()).upgradeApplianceSettings();
  }

  /** Returns the object with the settings used for calls to upgradeAppliance. */
  public OperationCallSettings<UpgradeApplianceRequest, UpgradeApplianceResponse, OperationMetadata>
      upgradeApplianceOperationSettings() {
    return ((VmMigrationStubSettings) getStubSettings()).upgradeApplianceOperationSettings();
  }

  /** Returns the object with the settings used for calls to createMigratingVm. */
  public UnaryCallSettings<CreateMigratingVmRequest, Operation> createMigratingVmSettings() {
    return ((VmMigrationStubSettings) getStubSettings()).createMigratingVmSettings();
  }

  /** Returns the object with the settings used for calls to createMigratingVm. */
  public OperationCallSettings<CreateMigratingVmRequest, MigratingVm, OperationMetadata>
      createMigratingVmOperationSettings() {
    return ((VmMigrationStubSettings) getStubSettings()).createMigratingVmOperationSettings();
  }

  /** Returns the object with the settings used for calls to listMigratingVms. */
  public PagedCallSettings<
          ListMigratingVmsRequest, ListMigratingVmsResponse, ListMigratingVmsPagedResponse>
      listMigratingVmsSettings() {
    return ((VmMigrationStubSettings) getStubSettings()).listMigratingVmsSettings();
  }

  /** Returns the object with the settings used for calls to getMigratingVm. */
  public UnaryCallSettings<GetMigratingVmRequest, MigratingVm> getMigratingVmSettings() {
    return ((VmMigrationStubSettings) getStubSettings()).getMigratingVmSettings();
  }

  /** Returns the object with the settings used for calls to updateMigratingVm. */
  public UnaryCallSettings<UpdateMigratingVmRequest, Operation> updateMigratingVmSettings() {
    return ((VmMigrationStubSettings) getStubSettings()).updateMigratingVmSettings();
  }

  /** Returns the object with the settings used for calls to updateMigratingVm. */
  public OperationCallSettings<UpdateMigratingVmRequest, MigratingVm, OperationMetadata>
      updateMigratingVmOperationSettings() {
    return ((VmMigrationStubSettings) getStubSettings()).updateMigratingVmOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteMigratingVm. */
  public UnaryCallSettings<DeleteMigratingVmRequest, Operation> deleteMigratingVmSettings() {
    return ((VmMigrationStubSettings) getStubSettings()).deleteMigratingVmSettings();
  }

  /** Returns the object with the settings used for calls to deleteMigratingVm. */
  public OperationCallSettings<DeleteMigratingVmRequest, Empty, OperationMetadata>
      deleteMigratingVmOperationSettings() {
    return ((VmMigrationStubSettings) getStubSettings()).deleteMigratingVmOperationSettings();
  }

  /** Returns the object with the settings used for calls to startMigration. */
  public UnaryCallSettings<StartMigrationRequest, Operation> startMigrationSettings() {
    return ((VmMigrationStubSettings) getStubSettings()).startMigrationSettings();
  }

  /** Returns the object with the settings used for calls to startMigration. */
  public OperationCallSettings<StartMigrationRequest, StartMigrationResponse, OperationMetadata>
      startMigrationOperationSettings() {
    return ((VmMigrationStubSettings) getStubSettings()).startMigrationOperationSettings();
  }

  /** Returns the object with the settings used for calls to resumeMigration. */
  public UnaryCallSettings<ResumeMigrationRequest, Operation> resumeMigrationSettings() {
    return ((VmMigrationStubSettings) getStubSettings()).resumeMigrationSettings();
  }

  /** Returns the object with the settings used for calls to resumeMigration. */
  public OperationCallSettings<ResumeMigrationRequest, ResumeMigrationResponse, OperationMetadata>
      resumeMigrationOperationSettings() {
    return ((VmMigrationStubSettings) getStubSettings()).resumeMigrationOperationSettings();
  }

  /** Returns the object with the settings used for calls to pauseMigration. */
  public UnaryCallSettings<PauseMigrationRequest, Operation> pauseMigrationSettings() {
    return ((VmMigrationStubSettings) getStubSettings()).pauseMigrationSettings();
  }

  /** Returns the object with the settings used for calls to pauseMigration. */
  public OperationCallSettings<PauseMigrationRequest, PauseMigrationResponse, OperationMetadata>
      pauseMigrationOperationSettings() {
    return ((VmMigrationStubSettings) getStubSettings()).pauseMigrationOperationSettings();
  }

  /** Returns the object with the settings used for calls to finalizeMigration. */
  public UnaryCallSettings<FinalizeMigrationRequest, Operation> finalizeMigrationSettings() {
    return ((VmMigrationStubSettings) getStubSettings()).finalizeMigrationSettings();
  }

  /** Returns the object with the settings used for calls to finalizeMigration. */
  public OperationCallSettings<
          FinalizeMigrationRequest, FinalizeMigrationResponse, OperationMetadata>
      finalizeMigrationOperationSettings() {
    return ((VmMigrationStubSettings) getStubSettings()).finalizeMigrationOperationSettings();
  }

  /** Returns the object with the settings used for calls to createCloneJob. */
  public UnaryCallSettings<CreateCloneJobRequest, Operation> createCloneJobSettings() {
    return ((VmMigrationStubSettings) getStubSettings()).createCloneJobSettings();
  }

  /** Returns the object with the settings used for calls to createCloneJob. */
  public OperationCallSettings<CreateCloneJobRequest, CloneJob, OperationMetadata>
      createCloneJobOperationSettings() {
    return ((VmMigrationStubSettings) getStubSettings()).createCloneJobOperationSettings();
  }

  /** Returns the object with the settings used for calls to cancelCloneJob. */
  public UnaryCallSettings<CancelCloneJobRequest, Operation> cancelCloneJobSettings() {
    return ((VmMigrationStubSettings) getStubSettings()).cancelCloneJobSettings();
  }

  /** Returns the object with the settings used for calls to cancelCloneJob. */
  public OperationCallSettings<CancelCloneJobRequest, CancelCloneJobResponse, OperationMetadata>
      cancelCloneJobOperationSettings() {
    return ((VmMigrationStubSettings) getStubSettings()).cancelCloneJobOperationSettings();
  }

  /** Returns the object with the settings used for calls to listCloneJobs. */
  public PagedCallSettings<ListCloneJobsRequest, ListCloneJobsResponse, ListCloneJobsPagedResponse>
      listCloneJobsSettings() {
    return ((VmMigrationStubSettings) getStubSettings()).listCloneJobsSettings();
  }

  /** Returns the object with the settings used for calls to getCloneJob. */
  public UnaryCallSettings<GetCloneJobRequest, CloneJob> getCloneJobSettings() {
    return ((VmMigrationStubSettings) getStubSettings()).getCloneJobSettings();
  }

  /** Returns the object with the settings used for calls to createCutoverJob. */
  public UnaryCallSettings<CreateCutoverJobRequest, Operation> createCutoverJobSettings() {
    return ((VmMigrationStubSettings) getStubSettings()).createCutoverJobSettings();
  }

  /** Returns the object with the settings used for calls to createCutoverJob. */
  public OperationCallSettings<CreateCutoverJobRequest, CutoverJob, OperationMetadata>
      createCutoverJobOperationSettings() {
    return ((VmMigrationStubSettings) getStubSettings()).createCutoverJobOperationSettings();
  }

  /** Returns the object with the settings used for calls to cancelCutoverJob. */
  public UnaryCallSettings<CancelCutoverJobRequest, Operation> cancelCutoverJobSettings() {
    return ((VmMigrationStubSettings) getStubSettings()).cancelCutoverJobSettings();
  }

  /** Returns the object with the settings used for calls to cancelCutoverJob. */
  public OperationCallSettings<CancelCutoverJobRequest, CancelCutoverJobResponse, OperationMetadata>
      cancelCutoverJobOperationSettings() {
    return ((VmMigrationStubSettings) getStubSettings()).cancelCutoverJobOperationSettings();
  }

  /** Returns the object with the settings used for calls to listCutoverJobs. */
  public PagedCallSettings<
          ListCutoverJobsRequest, ListCutoverJobsResponse, ListCutoverJobsPagedResponse>
      listCutoverJobsSettings() {
    return ((VmMigrationStubSettings) getStubSettings()).listCutoverJobsSettings();
  }

  /** Returns the object with the settings used for calls to getCutoverJob. */
  public UnaryCallSettings<GetCutoverJobRequest, CutoverJob> getCutoverJobSettings() {
    return ((VmMigrationStubSettings) getStubSettings()).getCutoverJobSettings();
  }

  /** Returns the object with the settings used for calls to listGroups. */
  public PagedCallSettings<ListGroupsRequest, ListGroupsResponse, ListGroupsPagedResponse>
      listGroupsSettings() {
    return ((VmMigrationStubSettings) getStubSettings()).listGroupsSettings();
  }

  /** Returns the object with the settings used for calls to getGroup. */
  public UnaryCallSettings<GetGroupRequest, Group> getGroupSettings() {
    return ((VmMigrationStubSettings) getStubSettings()).getGroupSettings();
  }

  /** Returns the object with the settings used for calls to createGroup. */
  public UnaryCallSettings<CreateGroupRequest, Operation> createGroupSettings() {
    return ((VmMigrationStubSettings) getStubSettings()).createGroupSettings();
  }

  /** Returns the object with the settings used for calls to createGroup. */
  public OperationCallSettings<CreateGroupRequest, Group, OperationMetadata>
      createGroupOperationSettings() {
    return ((VmMigrationStubSettings) getStubSettings()).createGroupOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateGroup. */
  public UnaryCallSettings<UpdateGroupRequest, Operation> updateGroupSettings() {
    return ((VmMigrationStubSettings) getStubSettings()).updateGroupSettings();
  }

  /** Returns the object with the settings used for calls to updateGroup. */
  public OperationCallSettings<UpdateGroupRequest, Group, OperationMetadata>
      updateGroupOperationSettings() {
    return ((VmMigrationStubSettings) getStubSettings()).updateGroupOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteGroup. */
  public UnaryCallSettings<DeleteGroupRequest, Operation> deleteGroupSettings() {
    return ((VmMigrationStubSettings) getStubSettings()).deleteGroupSettings();
  }

  /** Returns the object with the settings used for calls to deleteGroup. */
  public OperationCallSettings<DeleteGroupRequest, Empty, OperationMetadata>
      deleteGroupOperationSettings() {
    return ((VmMigrationStubSettings) getStubSettings()).deleteGroupOperationSettings();
  }

  /** Returns the object with the settings used for calls to addGroupMigration. */
  public UnaryCallSettings<AddGroupMigrationRequest, Operation> addGroupMigrationSettings() {
    return ((VmMigrationStubSettings) getStubSettings()).addGroupMigrationSettings();
  }

  /** Returns the object with the settings used for calls to addGroupMigration. */
  public OperationCallSettings<
          AddGroupMigrationRequest, AddGroupMigrationResponse, OperationMetadata>
      addGroupMigrationOperationSettings() {
    return ((VmMigrationStubSettings) getStubSettings()).addGroupMigrationOperationSettings();
  }

  /** Returns the object with the settings used for calls to removeGroupMigration. */
  public UnaryCallSettings<RemoveGroupMigrationRequest, Operation> removeGroupMigrationSettings() {
    return ((VmMigrationStubSettings) getStubSettings()).removeGroupMigrationSettings();
  }

  /** Returns the object with the settings used for calls to removeGroupMigration. */
  public OperationCallSettings<
          RemoveGroupMigrationRequest, RemoveGroupMigrationResponse, OperationMetadata>
      removeGroupMigrationOperationSettings() {
    return ((VmMigrationStubSettings) getStubSettings()).removeGroupMigrationOperationSettings();
  }

  /** Returns the object with the settings used for calls to listTargetProjects. */
  public PagedCallSettings<
          ListTargetProjectsRequest, ListTargetProjectsResponse, ListTargetProjectsPagedResponse>
      listTargetProjectsSettings() {
    return ((VmMigrationStubSettings) getStubSettings()).listTargetProjectsSettings();
  }

  /** Returns the object with the settings used for calls to getTargetProject. */
  public UnaryCallSettings<GetTargetProjectRequest, TargetProject> getTargetProjectSettings() {
    return ((VmMigrationStubSettings) getStubSettings()).getTargetProjectSettings();
  }

  /** Returns the object with the settings used for calls to createTargetProject. */
  public UnaryCallSettings<CreateTargetProjectRequest, Operation> createTargetProjectSettings() {
    return ((VmMigrationStubSettings) getStubSettings()).createTargetProjectSettings();
  }

  /** Returns the object with the settings used for calls to createTargetProject. */
  public OperationCallSettings<CreateTargetProjectRequest, TargetProject, OperationMetadata>
      createTargetProjectOperationSettings() {
    return ((VmMigrationStubSettings) getStubSettings()).createTargetProjectOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateTargetProject. */
  public UnaryCallSettings<UpdateTargetProjectRequest, Operation> updateTargetProjectSettings() {
    return ((VmMigrationStubSettings) getStubSettings()).updateTargetProjectSettings();
  }

  /** Returns the object with the settings used for calls to updateTargetProject. */
  public OperationCallSettings<UpdateTargetProjectRequest, TargetProject, OperationMetadata>
      updateTargetProjectOperationSettings() {
    return ((VmMigrationStubSettings) getStubSettings()).updateTargetProjectOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteTargetProject. */
  public UnaryCallSettings<DeleteTargetProjectRequest, Operation> deleteTargetProjectSettings() {
    return ((VmMigrationStubSettings) getStubSettings()).deleteTargetProjectSettings();
  }

  /** Returns the object with the settings used for calls to deleteTargetProject. */
  public OperationCallSettings<DeleteTargetProjectRequest, Empty, OperationMetadata>
      deleteTargetProjectOperationSettings() {
    return ((VmMigrationStubSettings) getStubSettings()).deleteTargetProjectOperationSettings();
  }

  public static final VmMigrationSettings create(VmMigrationStubSettings stub) throws IOException {
    return new VmMigrationSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return VmMigrationStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return VmMigrationStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return VmMigrationStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return VmMigrationStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return VmMigrationStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return VmMigrationStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return VmMigrationStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return VmMigrationStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected VmMigrationSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for VmMigrationSettings. */
  public static class Builder extends ClientSettings.Builder<VmMigrationSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(VmMigrationStubSettings.newBuilder(clientContext));
    }

    protected Builder(VmMigrationSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(VmMigrationStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(VmMigrationStubSettings.newBuilder());
    }

    @BetaApi
    private static Builder createHttpJsonDefault() {
      return new Builder(VmMigrationStubSettings.newHttpJsonBuilder());
    }

    public VmMigrationStubSettings.Builder getStubSettingsBuilder() {
      return ((VmMigrationStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to fetchInventory. */
    public UnaryCallSettings.Builder<FetchInventoryRequest, FetchInventoryResponse>
        fetchInventorySettings() {
      return getStubSettingsBuilder().fetchInventorySettings();
    }

    /** Returns the builder for the settings used for calls to listUtilizationReports. */
    public PagedCallSettings.Builder<
            ListUtilizationReportsRequest,
            ListUtilizationReportsResponse,
            ListUtilizationReportsPagedResponse>
        listUtilizationReportsSettings() {
      return getStubSettingsBuilder().listUtilizationReportsSettings();
    }

    /** Returns the builder for the settings used for calls to getUtilizationReport. */
    public UnaryCallSettings.Builder<GetUtilizationReportRequest, UtilizationReport>
        getUtilizationReportSettings() {
      return getStubSettingsBuilder().getUtilizationReportSettings();
    }

    /** Returns the builder for the settings used for calls to createUtilizationReport. */
    public UnaryCallSettings.Builder<CreateUtilizationReportRequest, Operation>
        createUtilizationReportSettings() {
      return getStubSettingsBuilder().createUtilizationReportSettings();
    }

    /** Returns the builder for the settings used for calls to createUtilizationReport. */
    public OperationCallSettings.Builder<
            CreateUtilizationReportRequest, UtilizationReport, OperationMetadata>
        createUtilizationReportOperationSettings() {
      return getStubSettingsBuilder().createUtilizationReportOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteUtilizationReport. */
    public UnaryCallSettings.Builder<DeleteUtilizationReportRequest, Operation>
        deleteUtilizationReportSettings() {
      return getStubSettingsBuilder().deleteUtilizationReportSettings();
    }

    /** Returns the builder for the settings used for calls to deleteUtilizationReport. */
    public OperationCallSettings.Builder<DeleteUtilizationReportRequest, Empty, OperationMetadata>
        deleteUtilizationReportOperationSettings() {
      return getStubSettingsBuilder().deleteUtilizationReportOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listDatacenterConnectors. */
    public PagedCallSettings.Builder<
            ListDatacenterConnectorsRequest,
            ListDatacenterConnectorsResponse,
            ListDatacenterConnectorsPagedResponse>
        listDatacenterConnectorsSettings() {
      return getStubSettingsBuilder().listDatacenterConnectorsSettings();
    }

    /** Returns the builder for the settings used for calls to getDatacenterConnector. */
    public UnaryCallSettings.Builder<GetDatacenterConnectorRequest, DatacenterConnector>
        getDatacenterConnectorSettings() {
      return getStubSettingsBuilder().getDatacenterConnectorSettings();
    }

    /** Returns the builder for the settings used for calls to createDatacenterConnector. */
    public UnaryCallSettings.Builder<CreateDatacenterConnectorRequest, Operation>
        createDatacenterConnectorSettings() {
      return getStubSettingsBuilder().createDatacenterConnectorSettings();
    }

    /** Returns the builder for the settings used for calls to createDatacenterConnector. */
    public OperationCallSettings.Builder<
            CreateDatacenterConnectorRequest, DatacenterConnector, OperationMetadata>
        createDatacenterConnectorOperationSettings() {
      return getStubSettingsBuilder().createDatacenterConnectorOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteDatacenterConnector. */
    public UnaryCallSettings.Builder<DeleteDatacenterConnectorRequest, Operation>
        deleteDatacenterConnectorSettings() {
      return getStubSettingsBuilder().deleteDatacenterConnectorSettings();
    }

    /** Returns the builder for the settings used for calls to deleteDatacenterConnector. */
    public OperationCallSettings.Builder<DeleteDatacenterConnectorRequest, Empty, OperationMetadata>
        deleteDatacenterConnectorOperationSettings() {
      return getStubSettingsBuilder().deleteDatacenterConnectorOperationSettings();
    }

    /** Returns the builder for the settings used for calls to upgradeAppliance. */
    public UnaryCallSettings.Builder<UpgradeApplianceRequest, Operation>
        upgradeApplianceSettings() {
      return getStubSettingsBuilder().upgradeApplianceSettings();
    }

    /** Returns the builder for the settings used for calls to upgradeAppliance. */
    public OperationCallSettings.Builder<
            UpgradeApplianceRequest, UpgradeApplianceResponse, OperationMetadata>
        upgradeApplianceOperationSettings() {
      return getStubSettingsBuilder().upgradeApplianceOperationSettings();
    }

    /** Returns the builder for the settings used for calls to createMigratingVm. */
    public UnaryCallSettings.Builder<CreateMigratingVmRequest, Operation>
        createMigratingVmSettings() {
      return getStubSettingsBuilder().createMigratingVmSettings();
    }

    /** Returns the builder for the settings used for calls to createMigratingVm. */
    public OperationCallSettings.Builder<CreateMigratingVmRequest, MigratingVm, OperationMetadata>
        createMigratingVmOperationSettings() {
      return getStubSettingsBuilder().createMigratingVmOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listMigratingVms. */
    public PagedCallSettings.Builder<
            ListMigratingVmsRequest, ListMigratingVmsResponse, ListMigratingVmsPagedResponse>
        listMigratingVmsSettings() {
      return getStubSettingsBuilder().listMigratingVmsSettings();
    }

    /** Returns the builder for the settings used for calls to getMigratingVm. */
    public UnaryCallSettings.Builder<GetMigratingVmRequest, MigratingVm> getMigratingVmSettings() {
      return getStubSettingsBuilder().getMigratingVmSettings();
    }

    /** Returns the builder for the settings used for calls to updateMigratingVm. */
    public UnaryCallSettings.Builder<UpdateMigratingVmRequest, Operation>
        updateMigratingVmSettings() {
      return getStubSettingsBuilder().updateMigratingVmSettings();
    }

    /** Returns the builder for the settings used for calls to updateMigratingVm. */
    public OperationCallSettings.Builder<UpdateMigratingVmRequest, MigratingVm, OperationMetadata>
        updateMigratingVmOperationSettings() {
      return getStubSettingsBuilder().updateMigratingVmOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteMigratingVm. */
    public UnaryCallSettings.Builder<DeleteMigratingVmRequest, Operation>
        deleteMigratingVmSettings() {
      return getStubSettingsBuilder().deleteMigratingVmSettings();
    }

    /** Returns the builder for the settings used for calls to deleteMigratingVm. */
    public OperationCallSettings.Builder<DeleteMigratingVmRequest, Empty, OperationMetadata>
        deleteMigratingVmOperationSettings() {
      return getStubSettingsBuilder().deleteMigratingVmOperationSettings();
    }

    /** Returns the builder for the settings used for calls to startMigration. */
    public UnaryCallSettings.Builder<StartMigrationRequest, Operation> startMigrationSettings() {
      return getStubSettingsBuilder().startMigrationSettings();
    }

    /** Returns the builder for the settings used for calls to startMigration. */
    public OperationCallSettings.Builder<
            StartMigrationRequest, StartMigrationResponse, OperationMetadata>
        startMigrationOperationSettings() {
      return getStubSettingsBuilder().startMigrationOperationSettings();
    }

    /** Returns the builder for the settings used for calls to resumeMigration. */
    public UnaryCallSettings.Builder<ResumeMigrationRequest, Operation> resumeMigrationSettings() {
      return getStubSettingsBuilder().resumeMigrationSettings();
    }

    /** Returns the builder for the settings used for calls to resumeMigration. */
    public OperationCallSettings.Builder<
            ResumeMigrationRequest, ResumeMigrationResponse, OperationMetadata>
        resumeMigrationOperationSettings() {
      return getStubSettingsBuilder().resumeMigrationOperationSettings();
    }

    /** Returns the builder for the settings used for calls to pauseMigration. */
    public UnaryCallSettings.Builder<PauseMigrationRequest, Operation> pauseMigrationSettings() {
      return getStubSettingsBuilder().pauseMigrationSettings();
    }

    /** Returns the builder for the settings used for calls to pauseMigration. */
    public OperationCallSettings.Builder<
            PauseMigrationRequest, PauseMigrationResponse, OperationMetadata>
        pauseMigrationOperationSettings() {
      return getStubSettingsBuilder().pauseMigrationOperationSettings();
    }

    /** Returns the builder for the settings used for calls to finalizeMigration. */
    public UnaryCallSettings.Builder<FinalizeMigrationRequest, Operation>
        finalizeMigrationSettings() {
      return getStubSettingsBuilder().finalizeMigrationSettings();
    }

    /** Returns the builder for the settings used for calls to finalizeMigration. */
    public OperationCallSettings.Builder<
            FinalizeMigrationRequest, FinalizeMigrationResponse, OperationMetadata>
        finalizeMigrationOperationSettings() {
      return getStubSettingsBuilder().finalizeMigrationOperationSettings();
    }

    /** Returns the builder for the settings used for calls to createCloneJob. */
    public UnaryCallSettings.Builder<CreateCloneJobRequest, Operation> createCloneJobSettings() {
      return getStubSettingsBuilder().createCloneJobSettings();
    }

    /** Returns the builder for the settings used for calls to createCloneJob. */
    public OperationCallSettings.Builder<CreateCloneJobRequest, CloneJob, OperationMetadata>
        createCloneJobOperationSettings() {
      return getStubSettingsBuilder().createCloneJobOperationSettings();
    }

    /** Returns the builder for the settings used for calls to cancelCloneJob. */
    public UnaryCallSettings.Builder<CancelCloneJobRequest, Operation> cancelCloneJobSettings() {
      return getStubSettingsBuilder().cancelCloneJobSettings();
    }

    /** Returns the builder for the settings used for calls to cancelCloneJob. */
    public OperationCallSettings.Builder<
            CancelCloneJobRequest, CancelCloneJobResponse, OperationMetadata>
        cancelCloneJobOperationSettings() {
      return getStubSettingsBuilder().cancelCloneJobOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listCloneJobs. */
    public PagedCallSettings.Builder<
            ListCloneJobsRequest, ListCloneJobsResponse, ListCloneJobsPagedResponse>
        listCloneJobsSettings() {
      return getStubSettingsBuilder().listCloneJobsSettings();
    }

    /** Returns the builder for the settings used for calls to getCloneJob. */
    public UnaryCallSettings.Builder<GetCloneJobRequest, CloneJob> getCloneJobSettings() {
      return getStubSettingsBuilder().getCloneJobSettings();
    }

    /** Returns the builder for the settings used for calls to createCutoverJob. */
    public UnaryCallSettings.Builder<CreateCutoverJobRequest, Operation>
        createCutoverJobSettings() {
      return getStubSettingsBuilder().createCutoverJobSettings();
    }

    /** Returns the builder for the settings used for calls to createCutoverJob. */
    public OperationCallSettings.Builder<CreateCutoverJobRequest, CutoverJob, OperationMetadata>
        createCutoverJobOperationSettings() {
      return getStubSettingsBuilder().createCutoverJobOperationSettings();
    }

    /** Returns the builder for the settings used for calls to cancelCutoverJob. */
    public UnaryCallSettings.Builder<CancelCutoverJobRequest, Operation>
        cancelCutoverJobSettings() {
      return getStubSettingsBuilder().cancelCutoverJobSettings();
    }

    /** Returns the builder for the settings used for calls to cancelCutoverJob. */
    public OperationCallSettings.Builder<
            CancelCutoverJobRequest, CancelCutoverJobResponse, OperationMetadata>
        cancelCutoverJobOperationSettings() {
      return getStubSettingsBuilder().cancelCutoverJobOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listCutoverJobs. */
    public PagedCallSettings.Builder<
            ListCutoverJobsRequest, ListCutoverJobsResponse, ListCutoverJobsPagedResponse>
        listCutoverJobsSettings() {
      return getStubSettingsBuilder().listCutoverJobsSettings();
    }

    /** Returns the builder for the settings used for calls to getCutoverJob. */
    public UnaryCallSettings.Builder<GetCutoverJobRequest, CutoverJob> getCutoverJobSettings() {
      return getStubSettingsBuilder().getCutoverJobSettings();
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

    /** Returns the builder for the settings used for calls to addGroupMigration. */
    public UnaryCallSettings.Builder<AddGroupMigrationRequest, Operation>
        addGroupMigrationSettings() {
      return getStubSettingsBuilder().addGroupMigrationSettings();
    }

    /** Returns the builder for the settings used for calls to addGroupMigration. */
    public OperationCallSettings.Builder<
            AddGroupMigrationRequest, AddGroupMigrationResponse, OperationMetadata>
        addGroupMigrationOperationSettings() {
      return getStubSettingsBuilder().addGroupMigrationOperationSettings();
    }

    /** Returns the builder for the settings used for calls to removeGroupMigration. */
    public UnaryCallSettings.Builder<RemoveGroupMigrationRequest, Operation>
        removeGroupMigrationSettings() {
      return getStubSettingsBuilder().removeGroupMigrationSettings();
    }

    /** Returns the builder for the settings used for calls to removeGroupMigration. */
    public OperationCallSettings.Builder<
            RemoveGroupMigrationRequest, RemoveGroupMigrationResponse, OperationMetadata>
        removeGroupMigrationOperationSettings() {
      return getStubSettingsBuilder().removeGroupMigrationOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listTargetProjects. */
    public PagedCallSettings.Builder<
            ListTargetProjectsRequest, ListTargetProjectsResponse, ListTargetProjectsPagedResponse>
        listTargetProjectsSettings() {
      return getStubSettingsBuilder().listTargetProjectsSettings();
    }

    /** Returns the builder for the settings used for calls to getTargetProject. */
    public UnaryCallSettings.Builder<GetTargetProjectRequest, TargetProject>
        getTargetProjectSettings() {
      return getStubSettingsBuilder().getTargetProjectSettings();
    }

    /** Returns the builder for the settings used for calls to createTargetProject. */
    public UnaryCallSettings.Builder<CreateTargetProjectRequest, Operation>
        createTargetProjectSettings() {
      return getStubSettingsBuilder().createTargetProjectSettings();
    }

    /** Returns the builder for the settings used for calls to createTargetProject. */
    public OperationCallSettings.Builder<
            CreateTargetProjectRequest, TargetProject, OperationMetadata>
        createTargetProjectOperationSettings() {
      return getStubSettingsBuilder().createTargetProjectOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateTargetProject. */
    public UnaryCallSettings.Builder<UpdateTargetProjectRequest, Operation>
        updateTargetProjectSettings() {
      return getStubSettingsBuilder().updateTargetProjectSettings();
    }

    /** Returns the builder for the settings used for calls to updateTargetProject. */
    public OperationCallSettings.Builder<
            UpdateTargetProjectRequest, TargetProject, OperationMetadata>
        updateTargetProjectOperationSettings() {
      return getStubSettingsBuilder().updateTargetProjectOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteTargetProject. */
    public UnaryCallSettings.Builder<DeleteTargetProjectRequest, Operation>
        deleteTargetProjectSettings() {
      return getStubSettingsBuilder().deleteTargetProjectSettings();
    }

    /** Returns the builder for the settings used for calls to deleteTargetProject. */
    public OperationCallSettings.Builder<DeleteTargetProjectRequest, Empty, OperationMetadata>
        deleteTargetProjectOperationSettings() {
      return getStubSettingsBuilder().deleteTargetProjectOperationSettings();
    }

    @Override
    public VmMigrationSettings build() throws IOException {
      return new VmMigrationSettings(this);
    }
  }
}
