/*
 * Copyright 2025 Google LLC
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

package com.google.cloud.vmmigration.v1.stub;

import static com.google.cloud.vmmigration.v1.VmMigrationClient.FetchStorageInventoryPagedResponse;
import static com.google.cloud.vmmigration.v1.VmMigrationClient.ListCloneJobsPagedResponse;
import static com.google.cloud.vmmigration.v1.VmMigrationClient.ListCutoverJobsPagedResponse;
import static com.google.cloud.vmmigration.v1.VmMigrationClient.ListDatacenterConnectorsPagedResponse;
import static com.google.cloud.vmmigration.v1.VmMigrationClient.ListDiskMigrationJobsPagedResponse;
import static com.google.cloud.vmmigration.v1.VmMigrationClient.ListGroupsPagedResponse;
import static com.google.cloud.vmmigration.v1.VmMigrationClient.ListImageImportJobsPagedResponse;
import static com.google.cloud.vmmigration.v1.VmMigrationClient.ListImageImportsPagedResponse;
import static com.google.cloud.vmmigration.v1.VmMigrationClient.ListLocationsPagedResponse;
import static com.google.cloud.vmmigration.v1.VmMigrationClient.ListMigratingVmsPagedResponse;
import static com.google.cloud.vmmigration.v1.VmMigrationClient.ListReplicationCyclesPagedResponse;
import static com.google.cloud.vmmigration.v1.VmMigrationClient.ListSourcesPagedResponse;
import static com.google.cloud.vmmigration.v1.VmMigrationClient.ListTargetProjectsPagedResponse;
import static com.google.cloud.vmmigration.v1.VmMigrationClient.ListUtilizationReportsPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.BetaApi;
import com.google.api.core.ObsoleteApi;
import com.google.api.gax.core.GaxProperties;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.GrpcTransportChannel;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.grpc.ProtoOperationTransformers;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.HttpJsonTransportChannel;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
import com.google.api.gax.longrunning.OperationSnapshot;
import com.google.api.gax.longrunning.OperationTimedPollAlgorithm;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallSettings;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.PagedListDescriptor;
import com.google.api.gax.rpc.PagedListResponseFactory;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.StubSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.cloud.vmmigration.v1.AddGroupMigrationRequest;
import com.google.cloud.vmmigration.v1.AddGroupMigrationResponse;
import com.google.cloud.vmmigration.v1.CancelCloneJobRequest;
import com.google.cloud.vmmigration.v1.CancelCloneJobResponse;
import com.google.cloud.vmmigration.v1.CancelCutoverJobRequest;
import com.google.cloud.vmmigration.v1.CancelCutoverJobResponse;
import com.google.cloud.vmmigration.v1.CancelDiskMigrationJobRequest;
import com.google.cloud.vmmigration.v1.CancelDiskMigrationJobResponse;
import com.google.cloud.vmmigration.v1.CancelImageImportJobRequest;
import com.google.cloud.vmmigration.v1.CancelImageImportJobResponse;
import com.google.cloud.vmmigration.v1.CloneJob;
import com.google.cloud.vmmigration.v1.CreateCloneJobRequest;
import com.google.cloud.vmmigration.v1.CreateCutoverJobRequest;
import com.google.cloud.vmmigration.v1.CreateDatacenterConnectorRequest;
import com.google.cloud.vmmigration.v1.CreateDiskMigrationJobRequest;
import com.google.cloud.vmmigration.v1.CreateGroupRequest;
import com.google.cloud.vmmigration.v1.CreateImageImportRequest;
import com.google.cloud.vmmigration.v1.CreateMigratingVmRequest;
import com.google.cloud.vmmigration.v1.CreateSourceRequest;
import com.google.cloud.vmmigration.v1.CreateTargetProjectRequest;
import com.google.cloud.vmmigration.v1.CreateUtilizationReportRequest;
import com.google.cloud.vmmigration.v1.CutoverJob;
import com.google.cloud.vmmigration.v1.DatacenterConnector;
import com.google.cloud.vmmigration.v1.DeleteDatacenterConnectorRequest;
import com.google.cloud.vmmigration.v1.DeleteDiskMigrationJobRequest;
import com.google.cloud.vmmigration.v1.DeleteGroupRequest;
import com.google.cloud.vmmigration.v1.DeleteImageImportRequest;
import com.google.cloud.vmmigration.v1.DeleteMigratingVmRequest;
import com.google.cloud.vmmigration.v1.DeleteSourceRequest;
import com.google.cloud.vmmigration.v1.DeleteTargetProjectRequest;
import com.google.cloud.vmmigration.v1.DeleteUtilizationReportRequest;
import com.google.cloud.vmmigration.v1.DiskMigrationJob;
import com.google.cloud.vmmigration.v1.ExtendMigrationRequest;
import com.google.cloud.vmmigration.v1.ExtendMigrationResponse;
import com.google.cloud.vmmigration.v1.FetchInventoryRequest;
import com.google.cloud.vmmigration.v1.FetchInventoryResponse;
import com.google.cloud.vmmigration.v1.FetchStorageInventoryRequest;
import com.google.cloud.vmmigration.v1.FetchStorageInventoryResponse;
import com.google.cloud.vmmigration.v1.FinalizeMigrationRequest;
import com.google.cloud.vmmigration.v1.FinalizeMigrationResponse;
import com.google.cloud.vmmigration.v1.GetCloneJobRequest;
import com.google.cloud.vmmigration.v1.GetCutoverJobRequest;
import com.google.cloud.vmmigration.v1.GetDatacenterConnectorRequest;
import com.google.cloud.vmmigration.v1.GetDiskMigrationJobRequest;
import com.google.cloud.vmmigration.v1.GetGroupRequest;
import com.google.cloud.vmmigration.v1.GetImageImportJobRequest;
import com.google.cloud.vmmigration.v1.GetImageImportRequest;
import com.google.cloud.vmmigration.v1.GetMigratingVmRequest;
import com.google.cloud.vmmigration.v1.GetReplicationCycleRequest;
import com.google.cloud.vmmigration.v1.GetSourceRequest;
import com.google.cloud.vmmigration.v1.GetTargetProjectRequest;
import com.google.cloud.vmmigration.v1.GetUtilizationReportRequest;
import com.google.cloud.vmmigration.v1.Group;
import com.google.cloud.vmmigration.v1.ImageImport;
import com.google.cloud.vmmigration.v1.ImageImportJob;
import com.google.cloud.vmmigration.v1.ListCloneJobsRequest;
import com.google.cloud.vmmigration.v1.ListCloneJobsResponse;
import com.google.cloud.vmmigration.v1.ListCutoverJobsRequest;
import com.google.cloud.vmmigration.v1.ListCutoverJobsResponse;
import com.google.cloud.vmmigration.v1.ListDatacenterConnectorsRequest;
import com.google.cloud.vmmigration.v1.ListDatacenterConnectorsResponse;
import com.google.cloud.vmmigration.v1.ListDiskMigrationJobsRequest;
import com.google.cloud.vmmigration.v1.ListDiskMigrationJobsResponse;
import com.google.cloud.vmmigration.v1.ListGroupsRequest;
import com.google.cloud.vmmigration.v1.ListGroupsResponse;
import com.google.cloud.vmmigration.v1.ListImageImportJobsRequest;
import com.google.cloud.vmmigration.v1.ListImageImportJobsResponse;
import com.google.cloud.vmmigration.v1.ListImageImportsRequest;
import com.google.cloud.vmmigration.v1.ListImageImportsResponse;
import com.google.cloud.vmmigration.v1.ListMigratingVmsRequest;
import com.google.cloud.vmmigration.v1.ListMigratingVmsResponse;
import com.google.cloud.vmmigration.v1.ListReplicationCyclesRequest;
import com.google.cloud.vmmigration.v1.ListReplicationCyclesResponse;
import com.google.cloud.vmmigration.v1.ListSourcesRequest;
import com.google.cloud.vmmigration.v1.ListSourcesResponse;
import com.google.cloud.vmmigration.v1.ListTargetProjectsRequest;
import com.google.cloud.vmmigration.v1.ListTargetProjectsResponse;
import com.google.cloud.vmmigration.v1.ListUtilizationReportsRequest;
import com.google.cloud.vmmigration.v1.ListUtilizationReportsResponse;
import com.google.cloud.vmmigration.v1.MigratingVm;
import com.google.cloud.vmmigration.v1.OperationMetadata;
import com.google.cloud.vmmigration.v1.PauseMigrationRequest;
import com.google.cloud.vmmigration.v1.PauseMigrationResponse;
import com.google.cloud.vmmigration.v1.RemoveGroupMigrationRequest;
import com.google.cloud.vmmigration.v1.RemoveGroupMigrationResponse;
import com.google.cloud.vmmigration.v1.ReplicationCycle;
import com.google.cloud.vmmigration.v1.ResumeMigrationRequest;
import com.google.cloud.vmmigration.v1.ResumeMigrationResponse;
import com.google.cloud.vmmigration.v1.RunDiskMigrationJobRequest;
import com.google.cloud.vmmigration.v1.RunDiskMigrationJobResponse;
import com.google.cloud.vmmigration.v1.Source;
import com.google.cloud.vmmigration.v1.SourceStorageResource;
import com.google.cloud.vmmigration.v1.StartMigrationRequest;
import com.google.cloud.vmmigration.v1.StartMigrationResponse;
import com.google.cloud.vmmigration.v1.TargetProject;
import com.google.cloud.vmmigration.v1.UpdateDiskMigrationJobRequest;
import com.google.cloud.vmmigration.v1.UpdateGroupRequest;
import com.google.cloud.vmmigration.v1.UpdateMigratingVmRequest;
import com.google.cloud.vmmigration.v1.UpdateSourceRequest;
import com.google.cloud.vmmigration.v1.UpdateTargetProjectRequest;
import com.google.cloud.vmmigration.v1.UpgradeApplianceRequest;
import com.google.cloud.vmmigration.v1.UpgradeApplianceResponse;
import com.google.cloud.vmmigration.v1.UtilizationReport;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link VmMigrationStub}.
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
 * <p>For example, to set the
 * [RetrySettings](https://cloud.google.com/java/docs/reference/gax/latest/com.google.api.gax.retrying.RetrySettings)
 * of getSource:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * VmMigrationStubSettings.Builder vmMigrationSettingsBuilder =
 *     VmMigrationStubSettings.newBuilder();
 * vmMigrationSettingsBuilder
 *     .getSourceSettings()
 *     .setRetrySettings(
 *         vmMigrationSettingsBuilder
 *             .getSourceSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setInitialRetryDelayDuration(Duration.ofSeconds(1))
 *             .setInitialRpcTimeoutDuration(Duration.ofSeconds(5))
 *             .setMaxAttempts(5)
 *             .setMaxRetryDelayDuration(Duration.ofSeconds(30))
 *             .setMaxRpcTimeoutDuration(Duration.ofSeconds(60))
 *             .setRetryDelayMultiplier(1.3)
 *             .setRpcTimeoutMultiplier(1.5)
 *             .setTotalTimeoutDuration(Duration.ofSeconds(300))
 *             .build());
 * VmMigrationStubSettings vmMigrationSettings = vmMigrationSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://github.com/googleapis/google-cloud-java/blob/main/docs/client_retries.md) for
 * additional support in setting retries.
 *
 * <p>To configure the RetrySettings of a Long Running Operation method, create an
 * OperationTimedPollAlgorithm object and update the RPC's polling algorithm. For example, to
 * configure the RetrySettings for createSource:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * VmMigrationStubSettings.Builder vmMigrationSettingsBuilder =
 *     VmMigrationStubSettings.newBuilder();
 * TimedRetryAlgorithm timedRetryAlgorithm =
 *     OperationalTimedPollAlgorithm.create(
 *         RetrySettings.newBuilder()
 *             .setInitialRetryDelayDuration(Duration.ofMillis(500))
 *             .setRetryDelayMultiplier(1.5)
 *             .setMaxRetryDelayDuration(Duration.ofMillis(5000))
 *             .setTotalTimeoutDuration(Duration.ofHours(24))
 *             .build());
 * vmMigrationSettingsBuilder
 *     .createClusterOperationSettings()
 *     .setPollingAlgorithm(timedRetryAlgorithm)
 *     .build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class VmMigrationStubSettings extends StubSettings<VmMigrationStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final PagedCallSettings<ListSourcesRequest, ListSourcesResponse, ListSourcesPagedResponse>
      listSourcesSettings;
  private final UnaryCallSettings<GetSourceRequest, Source> getSourceSettings;
  private final UnaryCallSettings<CreateSourceRequest, Operation> createSourceSettings;
  private final OperationCallSettings<CreateSourceRequest, Source, OperationMetadata>
      createSourceOperationSettings;
  private final UnaryCallSettings<UpdateSourceRequest, Operation> updateSourceSettings;
  private final OperationCallSettings<UpdateSourceRequest, Source, OperationMetadata>
      updateSourceOperationSettings;
  private final UnaryCallSettings<DeleteSourceRequest, Operation> deleteSourceSettings;
  private final OperationCallSettings<DeleteSourceRequest, Empty, OperationMetadata>
      deleteSourceOperationSettings;
  private final UnaryCallSettings<FetchInventoryRequest, FetchInventoryResponse>
      fetchInventorySettings;
  private final PagedCallSettings<
          FetchStorageInventoryRequest,
          FetchStorageInventoryResponse,
          FetchStorageInventoryPagedResponse>
      fetchStorageInventorySettings;
  private final PagedCallSettings<
          ListUtilizationReportsRequest,
          ListUtilizationReportsResponse,
          ListUtilizationReportsPagedResponse>
      listUtilizationReportsSettings;
  private final UnaryCallSettings<GetUtilizationReportRequest, UtilizationReport>
      getUtilizationReportSettings;
  private final UnaryCallSettings<CreateUtilizationReportRequest, Operation>
      createUtilizationReportSettings;
  private final OperationCallSettings<
          CreateUtilizationReportRequest, UtilizationReport, OperationMetadata>
      createUtilizationReportOperationSettings;
  private final UnaryCallSettings<DeleteUtilizationReportRequest, Operation>
      deleteUtilizationReportSettings;
  private final OperationCallSettings<DeleteUtilizationReportRequest, Empty, OperationMetadata>
      deleteUtilizationReportOperationSettings;
  private final PagedCallSettings<
          ListDatacenterConnectorsRequest,
          ListDatacenterConnectorsResponse,
          ListDatacenterConnectorsPagedResponse>
      listDatacenterConnectorsSettings;
  private final UnaryCallSettings<GetDatacenterConnectorRequest, DatacenterConnector>
      getDatacenterConnectorSettings;
  private final UnaryCallSettings<CreateDatacenterConnectorRequest, Operation>
      createDatacenterConnectorSettings;
  private final OperationCallSettings<
          CreateDatacenterConnectorRequest, DatacenterConnector, OperationMetadata>
      createDatacenterConnectorOperationSettings;
  private final UnaryCallSettings<DeleteDatacenterConnectorRequest, Operation>
      deleteDatacenterConnectorSettings;
  private final OperationCallSettings<DeleteDatacenterConnectorRequest, Empty, OperationMetadata>
      deleteDatacenterConnectorOperationSettings;
  private final UnaryCallSettings<UpgradeApplianceRequest, Operation> upgradeApplianceSettings;
  private final OperationCallSettings<
          UpgradeApplianceRequest, UpgradeApplianceResponse, OperationMetadata>
      upgradeApplianceOperationSettings;
  private final UnaryCallSettings<CreateMigratingVmRequest, Operation> createMigratingVmSettings;
  private final OperationCallSettings<CreateMigratingVmRequest, MigratingVm, OperationMetadata>
      createMigratingVmOperationSettings;
  private final PagedCallSettings<
          ListMigratingVmsRequest, ListMigratingVmsResponse, ListMigratingVmsPagedResponse>
      listMigratingVmsSettings;
  private final UnaryCallSettings<GetMigratingVmRequest, MigratingVm> getMigratingVmSettings;
  private final UnaryCallSettings<UpdateMigratingVmRequest, Operation> updateMigratingVmSettings;
  private final OperationCallSettings<UpdateMigratingVmRequest, MigratingVm, OperationMetadata>
      updateMigratingVmOperationSettings;
  private final UnaryCallSettings<DeleteMigratingVmRequest, Operation> deleteMigratingVmSettings;
  private final OperationCallSettings<DeleteMigratingVmRequest, Empty, OperationMetadata>
      deleteMigratingVmOperationSettings;
  private final UnaryCallSettings<StartMigrationRequest, Operation> startMigrationSettings;
  private final OperationCallSettings<
          StartMigrationRequest, StartMigrationResponse, OperationMetadata>
      startMigrationOperationSettings;
  private final UnaryCallSettings<ResumeMigrationRequest, Operation> resumeMigrationSettings;
  private final OperationCallSettings<
          ResumeMigrationRequest, ResumeMigrationResponse, OperationMetadata>
      resumeMigrationOperationSettings;
  private final UnaryCallSettings<PauseMigrationRequest, Operation> pauseMigrationSettings;
  private final OperationCallSettings<
          PauseMigrationRequest, PauseMigrationResponse, OperationMetadata>
      pauseMigrationOperationSettings;
  private final UnaryCallSettings<FinalizeMigrationRequest, Operation> finalizeMigrationSettings;
  private final OperationCallSettings<
          FinalizeMigrationRequest, FinalizeMigrationResponse, OperationMetadata>
      finalizeMigrationOperationSettings;
  private final UnaryCallSettings<ExtendMigrationRequest, Operation> extendMigrationSettings;
  private final OperationCallSettings<
          ExtendMigrationRequest, ExtendMigrationResponse, OperationMetadata>
      extendMigrationOperationSettings;
  private final UnaryCallSettings<CreateCloneJobRequest, Operation> createCloneJobSettings;
  private final OperationCallSettings<CreateCloneJobRequest, CloneJob, OperationMetadata>
      createCloneJobOperationSettings;
  private final UnaryCallSettings<CancelCloneJobRequest, Operation> cancelCloneJobSettings;
  private final OperationCallSettings<
          CancelCloneJobRequest, CancelCloneJobResponse, OperationMetadata>
      cancelCloneJobOperationSettings;
  private final PagedCallSettings<
          ListCloneJobsRequest, ListCloneJobsResponse, ListCloneJobsPagedResponse>
      listCloneJobsSettings;
  private final UnaryCallSettings<GetCloneJobRequest, CloneJob> getCloneJobSettings;
  private final UnaryCallSettings<CreateCutoverJobRequest, Operation> createCutoverJobSettings;
  private final OperationCallSettings<CreateCutoverJobRequest, CutoverJob, OperationMetadata>
      createCutoverJobOperationSettings;
  private final UnaryCallSettings<CancelCutoverJobRequest, Operation> cancelCutoverJobSettings;
  private final OperationCallSettings<
          CancelCutoverJobRequest, CancelCutoverJobResponse, OperationMetadata>
      cancelCutoverJobOperationSettings;
  private final PagedCallSettings<
          ListCutoverJobsRequest, ListCutoverJobsResponse, ListCutoverJobsPagedResponse>
      listCutoverJobsSettings;
  private final UnaryCallSettings<GetCutoverJobRequest, CutoverJob> getCutoverJobSettings;
  private final PagedCallSettings<ListGroupsRequest, ListGroupsResponse, ListGroupsPagedResponse>
      listGroupsSettings;
  private final UnaryCallSettings<GetGroupRequest, Group> getGroupSettings;
  private final UnaryCallSettings<CreateGroupRequest, Operation> createGroupSettings;
  private final OperationCallSettings<CreateGroupRequest, Group, OperationMetadata>
      createGroupOperationSettings;
  private final UnaryCallSettings<UpdateGroupRequest, Operation> updateGroupSettings;
  private final OperationCallSettings<UpdateGroupRequest, Group, OperationMetadata>
      updateGroupOperationSettings;
  private final UnaryCallSettings<DeleteGroupRequest, Operation> deleteGroupSettings;
  private final OperationCallSettings<DeleteGroupRequest, Empty, OperationMetadata>
      deleteGroupOperationSettings;
  private final UnaryCallSettings<AddGroupMigrationRequest, Operation> addGroupMigrationSettings;
  private final OperationCallSettings<
          AddGroupMigrationRequest, AddGroupMigrationResponse, OperationMetadata>
      addGroupMigrationOperationSettings;
  private final UnaryCallSettings<RemoveGroupMigrationRequest, Operation>
      removeGroupMigrationSettings;
  private final OperationCallSettings<
          RemoveGroupMigrationRequest, RemoveGroupMigrationResponse, OperationMetadata>
      removeGroupMigrationOperationSettings;
  private final PagedCallSettings<
          ListTargetProjectsRequest, ListTargetProjectsResponse, ListTargetProjectsPagedResponse>
      listTargetProjectsSettings;
  private final UnaryCallSettings<GetTargetProjectRequest, TargetProject> getTargetProjectSettings;
  private final UnaryCallSettings<CreateTargetProjectRequest, Operation>
      createTargetProjectSettings;
  private final OperationCallSettings<CreateTargetProjectRequest, TargetProject, OperationMetadata>
      createTargetProjectOperationSettings;
  private final UnaryCallSettings<UpdateTargetProjectRequest, Operation>
      updateTargetProjectSettings;
  private final OperationCallSettings<UpdateTargetProjectRequest, TargetProject, OperationMetadata>
      updateTargetProjectOperationSettings;
  private final UnaryCallSettings<DeleteTargetProjectRequest, Operation>
      deleteTargetProjectSettings;
  private final OperationCallSettings<DeleteTargetProjectRequest, Empty, OperationMetadata>
      deleteTargetProjectOperationSettings;
  private final PagedCallSettings<
          ListReplicationCyclesRequest,
          ListReplicationCyclesResponse,
          ListReplicationCyclesPagedResponse>
      listReplicationCyclesSettings;
  private final UnaryCallSettings<GetReplicationCycleRequest, ReplicationCycle>
      getReplicationCycleSettings;
  private final PagedCallSettings<
          ListImageImportsRequest, ListImageImportsResponse, ListImageImportsPagedResponse>
      listImageImportsSettings;
  private final UnaryCallSettings<GetImageImportRequest, ImageImport> getImageImportSettings;
  private final UnaryCallSettings<CreateImageImportRequest, Operation> createImageImportSettings;
  private final OperationCallSettings<CreateImageImportRequest, ImageImport, OperationMetadata>
      createImageImportOperationSettings;
  private final UnaryCallSettings<DeleteImageImportRequest, Operation> deleteImageImportSettings;
  private final OperationCallSettings<DeleteImageImportRequest, Empty, OperationMetadata>
      deleteImageImportOperationSettings;
  private final PagedCallSettings<
          ListImageImportJobsRequest, ListImageImportJobsResponse, ListImageImportJobsPagedResponse>
      listImageImportJobsSettings;
  private final UnaryCallSettings<GetImageImportJobRequest, ImageImportJob>
      getImageImportJobSettings;
  private final UnaryCallSettings<CancelImageImportJobRequest, Operation>
      cancelImageImportJobSettings;
  private final OperationCallSettings<
          CancelImageImportJobRequest, CancelImageImportJobResponse, OperationMetadata>
      cancelImageImportJobOperationSettings;
  private final UnaryCallSettings<CreateDiskMigrationJobRequest, Operation>
      createDiskMigrationJobSettings;
  private final OperationCallSettings<
          CreateDiskMigrationJobRequest, DiskMigrationJob, OperationMetadata>
      createDiskMigrationJobOperationSettings;
  private final PagedCallSettings<
          ListDiskMigrationJobsRequest,
          ListDiskMigrationJobsResponse,
          ListDiskMigrationJobsPagedResponse>
      listDiskMigrationJobsSettings;
  private final UnaryCallSettings<GetDiskMigrationJobRequest, DiskMigrationJob>
      getDiskMigrationJobSettings;
  private final UnaryCallSettings<UpdateDiskMigrationJobRequest, Operation>
      updateDiskMigrationJobSettings;
  private final OperationCallSettings<
          UpdateDiskMigrationJobRequest, DiskMigrationJob, OperationMetadata>
      updateDiskMigrationJobOperationSettings;
  private final UnaryCallSettings<DeleteDiskMigrationJobRequest, Operation>
      deleteDiskMigrationJobSettings;
  private final OperationCallSettings<DeleteDiskMigrationJobRequest, Empty, OperationMetadata>
      deleteDiskMigrationJobOperationSettings;
  private final UnaryCallSettings<RunDiskMigrationJobRequest, Operation>
      runDiskMigrationJobSettings;
  private final OperationCallSettings<
          RunDiskMigrationJobRequest, RunDiskMigrationJobResponse, OperationMetadata>
      runDiskMigrationJobOperationSettings;
  private final UnaryCallSettings<CancelDiskMigrationJobRequest, Operation>
      cancelDiskMigrationJobSettings;
  private final OperationCallSettings<
          CancelDiskMigrationJobRequest, CancelDiskMigrationJobResponse, OperationMetadata>
      cancelDiskMigrationJobOperationSettings;
  private final PagedCallSettings<
          ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings;
  private final UnaryCallSettings<GetLocationRequest, Location> getLocationSettings;

  private static final PagedListDescriptor<ListSourcesRequest, ListSourcesResponse, Source>
      LIST_SOURCES_PAGE_STR_DESC =
          new PagedListDescriptor<ListSourcesRequest, ListSourcesResponse, Source>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListSourcesRequest injectToken(ListSourcesRequest payload, String token) {
              return ListSourcesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListSourcesRequest injectPageSize(ListSourcesRequest payload, int pageSize) {
              return ListSourcesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListSourcesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListSourcesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Source> extractResources(ListSourcesResponse payload) {
              return payload.getSourcesList();
            }
          };

  private static final PagedListDescriptor<
          FetchStorageInventoryRequest, FetchStorageInventoryResponse, SourceStorageResource>
      FETCH_STORAGE_INVENTORY_PAGE_STR_DESC =
          new PagedListDescriptor<
              FetchStorageInventoryRequest,
              FetchStorageInventoryResponse,
              SourceStorageResource>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public FetchStorageInventoryRequest injectToken(
                FetchStorageInventoryRequest payload, String token) {
              return FetchStorageInventoryRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public FetchStorageInventoryRequest injectPageSize(
                FetchStorageInventoryRequest payload, int pageSize) {
              return FetchStorageInventoryRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(FetchStorageInventoryRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(FetchStorageInventoryResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<SourceStorageResource> extractResources(
                FetchStorageInventoryResponse payload) {
              return payload.getResourcesList();
            }
          };

  private static final PagedListDescriptor<
          ListUtilizationReportsRequest, ListUtilizationReportsResponse, UtilizationReport>
      LIST_UTILIZATION_REPORTS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListUtilizationReportsRequest, ListUtilizationReportsResponse, UtilizationReport>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListUtilizationReportsRequest injectToken(
                ListUtilizationReportsRequest payload, String token) {
              return ListUtilizationReportsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListUtilizationReportsRequest injectPageSize(
                ListUtilizationReportsRequest payload, int pageSize) {
              return ListUtilizationReportsRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListUtilizationReportsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListUtilizationReportsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<UtilizationReport> extractResources(
                ListUtilizationReportsResponse payload) {
              return payload.getUtilizationReportsList();
            }
          };

  private static final PagedListDescriptor<
          ListDatacenterConnectorsRequest, ListDatacenterConnectorsResponse, DatacenterConnector>
      LIST_DATACENTER_CONNECTORS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListDatacenterConnectorsRequest,
              ListDatacenterConnectorsResponse,
              DatacenterConnector>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListDatacenterConnectorsRequest injectToken(
                ListDatacenterConnectorsRequest payload, String token) {
              return ListDatacenterConnectorsRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public ListDatacenterConnectorsRequest injectPageSize(
                ListDatacenterConnectorsRequest payload, int pageSize) {
              return ListDatacenterConnectorsRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListDatacenterConnectorsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListDatacenterConnectorsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<DatacenterConnector> extractResources(
                ListDatacenterConnectorsResponse payload) {
              return payload.getDatacenterConnectorsList();
            }
          };

  private static final PagedListDescriptor<
          ListMigratingVmsRequest, ListMigratingVmsResponse, MigratingVm>
      LIST_MIGRATING_VMS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListMigratingVmsRequest, ListMigratingVmsResponse, MigratingVm>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListMigratingVmsRequest injectToken(
                ListMigratingVmsRequest payload, String token) {
              return ListMigratingVmsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListMigratingVmsRequest injectPageSize(
                ListMigratingVmsRequest payload, int pageSize) {
              return ListMigratingVmsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListMigratingVmsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListMigratingVmsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<MigratingVm> extractResources(ListMigratingVmsResponse payload) {
              return payload.getMigratingVmsList();
            }
          };

  private static final PagedListDescriptor<ListCloneJobsRequest, ListCloneJobsResponse, CloneJob>
      LIST_CLONE_JOBS_PAGE_STR_DESC =
          new PagedListDescriptor<ListCloneJobsRequest, ListCloneJobsResponse, CloneJob>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListCloneJobsRequest injectToken(ListCloneJobsRequest payload, String token) {
              return ListCloneJobsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListCloneJobsRequest injectPageSize(ListCloneJobsRequest payload, int pageSize) {
              return ListCloneJobsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListCloneJobsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListCloneJobsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<CloneJob> extractResources(ListCloneJobsResponse payload) {
              return payload.getCloneJobsList();
            }
          };

  private static final PagedListDescriptor<
          ListCutoverJobsRequest, ListCutoverJobsResponse, CutoverJob>
      LIST_CUTOVER_JOBS_PAGE_STR_DESC =
          new PagedListDescriptor<ListCutoverJobsRequest, ListCutoverJobsResponse, CutoverJob>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListCutoverJobsRequest injectToken(
                ListCutoverJobsRequest payload, String token) {
              return ListCutoverJobsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListCutoverJobsRequest injectPageSize(
                ListCutoverJobsRequest payload, int pageSize) {
              return ListCutoverJobsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListCutoverJobsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListCutoverJobsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<CutoverJob> extractResources(ListCutoverJobsResponse payload) {
              return payload.getCutoverJobsList();
            }
          };

  private static final PagedListDescriptor<ListGroupsRequest, ListGroupsResponse, Group>
      LIST_GROUPS_PAGE_STR_DESC =
          new PagedListDescriptor<ListGroupsRequest, ListGroupsResponse, Group>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListGroupsRequest injectToken(ListGroupsRequest payload, String token) {
              return ListGroupsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListGroupsRequest injectPageSize(ListGroupsRequest payload, int pageSize) {
              return ListGroupsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListGroupsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListGroupsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Group> extractResources(ListGroupsResponse payload) {
              return payload.getGroupsList();
            }
          };

  private static final PagedListDescriptor<
          ListTargetProjectsRequest, ListTargetProjectsResponse, TargetProject>
      LIST_TARGET_PROJECTS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListTargetProjectsRequest, ListTargetProjectsResponse, TargetProject>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListTargetProjectsRequest injectToken(
                ListTargetProjectsRequest payload, String token) {
              return ListTargetProjectsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListTargetProjectsRequest injectPageSize(
                ListTargetProjectsRequest payload, int pageSize) {
              return ListTargetProjectsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListTargetProjectsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListTargetProjectsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<TargetProject> extractResources(ListTargetProjectsResponse payload) {
              return payload.getTargetProjectsList();
            }
          };

  private static final PagedListDescriptor<
          ListReplicationCyclesRequest, ListReplicationCyclesResponse, ReplicationCycle>
      LIST_REPLICATION_CYCLES_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListReplicationCyclesRequest, ListReplicationCyclesResponse, ReplicationCycle>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListReplicationCyclesRequest injectToken(
                ListReplicationCyclesRequest payload, String token) {
              return ListReplicationCyclesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListReplicationCyclesRequest injectPageSize(
                ListReplicationCyclesRequest payload, int pageSize) {
              return ListReplicationCyclesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListReplicationCyclesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListReplicationCyclesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<ReplicationCycle> extractResources(
                ListReplicationCyclesResponse payload) {
              return payload.getReplicationCyclesList();
            }
          };

  private static final PagedListDescriptor<
          ListImageImportsRequest, ListImageImportsResponse, ImageImport>
      LIST_IMAGE_IMPORTS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListImageImportsRequest, ListImageImportsResponse, ImageImport>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListImageImportsRequest injectToken(
                ListImageImportsRequest payload, String token) {
              return ListImageImportsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListImageImportsRequest injectPageSize(
                ListImageImportsRequest payload, int pageSize) {
              return ListImageImportsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListImageImportsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListImageImportsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<ImageImport> extractResources(ListImageImportsResponse payload) {
              return payload.getImageImportsList();
            }
          };

  private static final PagedListDescriptor<
          ListImageImportJobsRequest, ListImageImportJobsResponse, ImageImportJob>
      LIST_IMAGE_IMPORT_JOBS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListImageImportJobsRequest, ListImageImportJobsResponse, ImageImportJob>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListImageImportJobsRequest injectToken(
                ListImageImportJobsRequest payload, String token) {
              return ListImageImportJobsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListImageImportJobsRequest injectPageSize(
                ListImageImportJobsRequest payload, int pageSize) {
              return ListImageImportJobsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListImageImportJobsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListImageImportJobsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<ImageImportJob> extractResources(ListImageImportJobsResponse payload) {
              return payload.getImageImportJobsList();
            }
          };

  private static final PagedListDescriptor<
          ListDiskMigrationJobsRequest, ListDiskMigrationJobsResponse, DiskMigrationJob>
      LIST_DISK_MIGRATION_JOBS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListDiskMigrationJobsRequest, ListDiskMigrationJobsResponse, DiskMigrationJob>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListDiskMigrationJobsRequest injectToken(
                ListDiskMigrationJobsRequest payload, String token) {
              return ListDiskMigrationJobsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListDiskMigrationJobsRequest injectPageSize(
                ListDiskMigrationJobsRequest payload, int pageSize) {
              return ListDiskMigrationJobsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListDiskMigrationJobsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListDiskMigrationJobsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<DiskMigrationJob> extractResources(
                ListDiskMigrationJobsResponse payload) {
              return payload.getDiskMigrationJobsList();
            }
          };

  private static final PagedListDescriptor<ListLocationsRequest, ListLocationsResponse, Location>
      LIST_LOCATIONS_PAGE_STR_DESC =
          new PagedListDescriptor<ListLocationsRequest, ListLocationsResponse, Location>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListLocationsRequest injectToken(ListLocationsRequest payload, String token) {
              return ListLocationsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListLocationsRequest injectPageSize(ListLocationsRequest payload, int pageSize) {
              return ListLocationsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListLocationsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListLocationsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Location> extractResources(ListLocationsResponse payload) {
              return payload.getLocationsList();
            }
          };

  private static final PagedListResponseFactory<
          ListSourcesRequest, ListSourcesResponse, ListSourcesPagedResponse>
      LIST_SOURCES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListSourcesRequest, ListSourcesResponse, ListSourcesPagedResponse>() {
            @Override
            public ApiFuture<ListSourcesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListSourcesRequest, ListSourcesResponse> callable,
                ListSourcesRequest request,
                ApiCallContext context,
                ApiFuture<ListSourcesResponse> futureResponse) {
              PageContext<ListSourcesRequest, ListSourcesResponse, Source> pageContext =
                  PageContext.create(callable, LIST_SOURCES_PAGE_STR_DESC, request, context);
              return ListSourcesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          FetchStorageInventoryRequest,
          FetchStorageInventoryResponse,
          FetchStorageInventoryPagedResponse>
      FETCH_STORAGE_INVENTORY_PAGE_STR_FACT =
          new PagedListResponseFactory<
              FetchStorageInventoryRequest,
              FetchStorageInventoryResponse,
              FetchStorageInventoryPagedResponse>() {
            @Override
            public ApiFuture<FetchStorageInventoryPagedResponse> getFuturePagedResponse(
                UnaryCallable<FetchStorageInventoryRequest, FetchStorageInventoryResponse> callable,
                FetchStorageInventoryRequest request,
                ApiCallContext context,
                ApiFuture<FetchStorageInventoryResponse> futureResponse) {
              PageContext<
                      FetchStorageInventoryRequest,
                      FetchStorageInventoryResponse,
                      SourceStorageResource>
                  pageContext =
                      PageContext.create(
                          callable, FETCH_STORAGE_INVENTORY_PAGE_STR_DESC, request, context);
              return FetchStorageInventoryPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListUtilizationReportsRequest,
          ListUtilizationReportsResponse,
          ListUtilizationReportsPagedResponse>
      LIST_UTILIZATION_REPORTS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListUtilizationReportsRequest,
              ListUtilizationReportsResponse,
              ListUtilizationReportsPagedResponse>() {
            @Override
            public ApiFuture<ListUtilizationReportsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListUtilizationReportsRequest, ListUtilizationReportsResponse>
                    callable,
                ListUtilizationReportsRequest request,
                ApiCallContext context,
                ApiFuture<ListUtilizationReportsResponse> futureResponse) {
              PageContext<
                      ListUtilizationReportsRequest,
                      ListUtilizationReportsResponse,
                      UtilizationReport>
                  pageContext =
                      PageContext.create(
                          callable, LIST_UTILIZATION_REPORTS_PAGE_STR_DESC, request, context);
              return ListUtilizationReportsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListDatacenterConnectorsRequest,
          ListDatacenterConnectorsResponse,
          ListDatacenterConnectorsPagedResponse>
      LIST_DATACENTER_CONNECTORS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListDatacenterConnectorsRequest,
              ListDatacenterConnectorsResponse,
              ListDatacenterConnectorsPagedResponse>() {
            @Override
            public ApiFuture<ListDatacenterConnectorsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListDatacenterConnectorsRequest, ListDatacenterConnectorsResponse>
                    callable,
                ListDatacenterConnectorsRequest request,
                ApiCallContext context,
                ApiFuture<ListDatacenterConnectorsResponse> futureResponse) {
              PageContext<
                      ListDatacenterConnectorsRequest,
                      ListDatacenterConnectorsResponse,
                      DatacenterConnector>
                  pageContext =
                      PageContext.create(
                          callable, LIST_DATACENTER_CONNECTORS_PAGE_STR_DESC, request, context);
              return ListDatacenterConnectorsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListMigratingVmsRequest, ListMigratingVmsResponse, ListMigratingVmsPagedResponse>
      LIST_MIGRATING_VMS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListMigratingVmsRequest, ListMigratingVmsResponse, ListMigratingVmsPagedResponse>() {
            @Override
            public ApiFuture<ListMigratingVmsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListMigratingVmsRequest, ListMigratingVmsResponse> callable,
                ListMigratingVmsRequest request,
                ApiCallContext context,
                ApiFuture<ListMigratingVmsResponse> futureResponse) {
              PageContext<ListMigratingVmsRequest, ListMigratingVmsResponse, MigratingVm>
                  pageContext =
                      PageContext.create(
                          callable, LIST_MIGRATING_VMS_PAGE_STR_DESC, request, context);
              return ListMigratingVmsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListCloneJobsRequest, ListCloneJobsResponse, ListCloneJobsPagedResponse>
      LIST_CLONE_JOBS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListCloneJobsRequest, ListCloneJobsResponse, ListCloneJobsPagedResponse>() {
            @Override
            public ApiFuture<ListCloneJobsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListCloneJobsRequest, ListCloneJobsResponse> callable,
                ListCloneJobsRequest request,
                ApiCallContext context,
                ApiFuture<ListCloneJobsResponse> futureResponse) {
              PageContext<ListCloneJobsRequest, ListCloneJobsResponse, CloneJob> pageContext =
                  PageContext.create(callable, LIST_CLONE_JOBS_PAGE_STR_DESC, request, context);
              return ListCloneJobsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListCutoverJobsRequest, ListCutoverJobsResponse, ListCutoverJobsPagedResponse>
      LIST_CUTOVER_JOBS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListCutoverJobsRequest, ListCutoverJobsResponse, ListCutoverJobsPagedResponse>() {
            @Override
            public ApiFuture<ListCutoverJobsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListCutoverJobsRequest, ListCutoverJobsResponse> callable,
                ListCutoverJobsRequest request,
                ApiCallContext context,
                ApiFuture<ListCutoverJobsResponse> futureResponse) {
              PageContext<ListCutoverJobsRequest, ListCutoverJobsResponse, CutoverJob> pageContext =
                  PageContext.create(callable, LIST_CUTOVER_JOBS_PAGE_STR_DESC, request, context);
              return ListCutoverJobsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListGroupsRequest, ListGroupsResponse, ListGroupsPagedResponse>
      LIST_GROUPS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListGroupsRequest, ListGroupsResponse, ListGroupsPagedResponse>() {
            @Override
            public ApiFuture<ListGroupsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListGroupsRequest, ListGroupsResponse> callable,
                ListGroupsRequest request,
                ApiCallContext context,
                ApiFuture<ListGroupsResponse> futureResponse) {
              PageContext<ListGroupsRequest, ListGroupsResponse, Group> pageContext =
                  PageContext.create(callable, LIST_GROUPS_PAGE_STR_DESC, request, context);
              return ListGroupsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListTargetProjectsRequest, ListTargetProjectsResponse, ListTargetProjectsPagedResponse>
      LIST_TARGET_PROJECTS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListTargetProjectsRequest,
              ListTargetProjectsResponse,
              ListTargetProjectsPagedResponse>() {
            @Override
            public ApiFuture<ListTargetProjectsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListTargetProjectsRequest, ListTargetProjectsResponse> callable,
                ListTargetProjectsRequest request,
                ApiCallContext context,
                ApiFuture<ListTargetProjectsResponse> futureResponse) {
              PageContext<ListTargetProjectsRequest, ListTargetProjectsResponse, TargetProject>
                  pageContext =
                      PageContext.create(
                          callable, LIST_TARGET_PROJECTS_PAGE_STR_DESC, request, context);
              return ListTargetProjectsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListReplicationCyclesRequest,
          ListReplicationCyclesResponse,
          ListReplicationCyclesPagedResponse>
      LIST_REPLICATION_CYCLES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListReplicationCyclesRequest,
              ListReplicationCyclesResponse,
              ListReplicationCyclesPagedResponse>() {
            @Override
            public ApiFuture<ListReplicationCyclesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListReplicationCyclesRequest, ListReplicationCyclesResponse> callable,
                ListReplicationCyclesRequest request,
                ApiCallContext context,
                ApiFuture<ListReplicationCyclesResponse> futureResponse) {
              PageContext<
                      ListReplicationCyclesRequest, ListReplicationCyclesResponse, ReplicationCycle>
                  pageContext =
                      PageContext.create(
                          callable, LIST_REPLICATION_CYCLES_PAGE_STR_DESC, request, context);
              return ListReplicationCyclesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListImageImportsRequest, ListImageImportsResponse, ListImageImportsPagedResponse>
      LIST_IMAGE_IMPORTS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListImageImportsRequest, ListImageImportsResponse, ListImageImportsPagedResponse>() {
            @Override
            public ApiFuture<ListImageImportsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListImageImportsRequest, ListImageImportsResponse> callable,
                ListImageImportsRequest request,
                ApiCallContext context,
                ApiFuture<ListImageImportsResponse> futureResponse) {
              PageContext<ListImageImportsRequest, ListImageImportsResponse, ImageImport>
                  pageContext =
                      PageContext.create(
                          callable, LIST_IMAGE_IMPORTS_PAGE_STR_DESC, request, context);
              return ListImageImportsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListImageImportJobsRequest, ListImageImportJobsResponse, ListImageImportJobsPagedResponse>
      LIST_IMAGE_IMPORT_JOBS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListImageImportJobsRequest,
              ListImageImportJobsResponse,
              ListImageImportJobsPagedResponse>() {
            @Override
            public ApiFuture<ListImageImportJobsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListImageImportJobsRequest, ListImageImportJobsResponse> callable,
                ListImageImportJobsRequest request,
                ApiCallContext context,
                ApiFuture<ListImageImportJobsResponse> futureResponse) {
              PageContext<ListImageImportJobsRequest, ListImageImportJobsResponse, ImageImportJob>
                  pageContext =
                      PageContext.create(
                          callable, LIST_IMAGE_IMPORT_JOBS_PAGE_STR_DESC, request, context);
              return ListImageImportJobsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListDiskMigrationJobsRequest,
          ListDiskMigrationJobsResponse,
          ListDiskMigrationJobsPagedResponse>
      LIST_DISK_MIGRATION_JOBS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListDiskMigrationJobsRequest,
              ListDiskMigrationJobsResponse,
              ListDiskMigrationJobsPagedResponse>() {
            @Override
            public ApiFuture<ListDiskMigrationJobsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListDiskMigrationJobsRequest, ListDiskMigrationJobsResponse> callable,
                ListDiskMigrationJobsRequest request,
                ApiCallContext context,
                ApiFuture<ListDiskMigrationJobsResponse> futureResponse) {
              PageContext<
                      ListDiskMigrationJobsRequest, ListDiskMigrationJobsResponse, DiskMigrationJob>
                  pageContext =
                      PageContext.create(
                          callable, LIST_DISK_MIGRATION_JOBS_PAGE_STR_DESC, request, context);
              return ListDiskMigrationJobsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      LIST_LOCATIONS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>() {
            @Override
            public ApiFuture<ListLocationsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListLocationsRequest, ListLocationsResponse> callable,
                ListLocationsRequest request,
                ApiCallContext context,
                ApiFuture<ListLocationsResponse> futureResponse) {
              PageContext<ListLocationsRequest, ListLocationsResponse, Location> pageContext =
                  PageContext.create(callable, LIST_LOCATIONS_PAGE_STR_DESC, request, context);
              return ListLocationsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to listSources. */
  public PagedCallSettings<ListSourcesRequest, ListSourcesResponse, ListSourcesPagedResponse>
      listSourcesSettings() {
    return listSourcesSettings;
  }

  /** Returns the object with the settings used for calls to getSource. */
  public UnaryCallSettings<GetSourceRequest, Source> getSourceSettings() {
    return getSourceSettings;
  }

  /** Returns the object with the settings used for calls to createSource. */
  public UnaryCallSettings<CreateSourceRequest, Operation> createSourceSettings() {
    return createSourceSettings;
  }

  /** Returns the object with the settings used for calls to createSource. */
  public OperationCallSettings<CreateSourceRequest, Source, OperationMetadata>
      createSourceOperationSettings() {
    return createSourceOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateSource. */
  public UnaryCallSettings<UpdateSourceRequest, Operation> updateSourceSettings() {
    return updateSourceSettings;
  }

  /** Returns the object with the settings used for calls to updateSource. */
  public OperationCallSettings<UpdateSourceRequest, Source, OperationMetadata>
      updateSourceOperationSettings() {
    return updateSourceOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteSource. */
  public UnaryCallSettings<DeleteSourceRequest, Operation> deleteSourceSettings() {
    return deleteSourceSettings;
  }

  /** Returns the object with the settings used for calls to deleteSource. */
  public OperationCallSettings<DeleteSourceRequest, Empty, OperationMetadata>
      deleteSourceOperationSettings() {
    return deleteSourceOperationSettings;
  }

  /** Returns the object with the settings used for calls to fetchInventory. */
  public UnaryCallSettings<FetchInventoryRequest, FetchInventoryResponse> fetchInventorySettings() {
    return fetchInventorySettings;
  }

  /** Returns the object with the settings used for calls to fetchStorageInventory. */
  public PagedCallSettings<
          FetchStorageInventoryRequest,
          FetchStorageInventoryResponse,
          FetchStorageInventoryPagedResponse>
      fetchStorageInventorySettings() {
    return fetchStorageInventorySettings;
  }

  /** Returns the object with the settings used for calls to listUtilizationReports. */
  public PagedCallSettings<
          ListUtilizationReportsRequest,
          ListUtilizationReportsResponse,
          ListUtilizationReportsPagedResponse>
      listUtilizationReportsSettings() {
    return listUtilizationReportsSettings;
  }

  /** Returns the object with the settings used for calls to getUtilizationReport. */
  public UnaryCallSettings<GetUtilizationReportRequest, UtilizationReport>
      getUtilizationReportSettings() {
    return getUtilizationReportSettings;
  }

  /** Returns the object with the settings used for calls to createUtilizationReport. */
  public UnaryCallSettings<CreateUtilizationReportRequest, Operation>
      createUtilizationReportSettings() {
    return createUtilizationReportSettings;
  }

  /** Returns the object with the settings used for calls to createUtilizationReport. */
  public OperationCallSettings<CreateUtilizationReportRequest, UtilizationReport, OperationMetadata>
      createUtilizationReportOperationSettings() {
    return createUtilizationReportOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteUtilizationReport. */
  public UnaryCallSettings<DeleteUtilizationReportRequest, Operation>
      deleteUtilizationReportSettings() {
    return deleteUtilizationReportSettings;
  }

  /** Returns the object with the settings used for calls to deleteUtilizationReport. */
  public OperationCallSettings<DeleteUtilizationReportRequest, Empty, OperationMetadata>
      deleteUtilizationReportOperationSettings() {
    return deleteUtilizationReportOperationSettings;
  }

  /** Returns the object with the settings used for calls to listDatacenterConnectors. */
  public PagedCallSettings<
          ListDatacenterConnectorsRequest,
          ListDatacenterConnectorsResponse,
          ListDatacenterConnectorsPagedResponse>
      listDatacenterConnectorsSettings() {
    return listDatacenterConnectorsSettings;
  }

  /** Returns the object with the settings used for calls to getDatacenterConnector. */
  public UnaryCallSettings<GetDatacenterConnectorRequest, DatacenterConnector>
      getDatacenterConnectorSettings() {
    return getDatacenterConnectorSettings;
  }

  /** Returns the object with the settings used for calls to createDatacenterConnector. */
  public UnaryCallSettings<CreateDatacenterConnectorRequest, Operation>
      createDatacenterConnectorSettings() {
    return createDatacenterConnectorSettings;
  }

  /** Returns the object with the settings used for calls to createDatacenterConnector. */
  public OperationCallSettings<
          CreateDatacenterConnectorRequest, DatacenterConnector, OperationMetadata>
      createDatacenterConnectorOperationSettings() {
    return createDatacenterConnectorOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteDatacenterConnector. */
  public UnaryCallSettings<DeleteDatacenterConnectorRequest, Operation>
      deleteDatacenterConnectorSettings() {
    return deleteDatacenterConnectorSettings;
  }

  /** Returns the object with the settings used for calls to deleteDatacenterConnector. */
  public OperationCallSettings<DeleteDatacenterConnectorRequest, Empty, OperationMetadata>
      deleteDatacenterConnectorOperationSettings() {
    return deleteDatacenterConnectorOperationSettings;
  }

  /** Returns the object with the settings used for calls to upgradeAppliance. */
  public UnaryCallSettings<UpgradeApplianceRequest, Operation> upgradeApplianceSettings() {
    return upgradeApplianceSettings;
  }

  /** Returns the object with the settings used for calls to upgradeAppliance. */
  public OperationCallSettings<UpgradeApplianceRequest, UpgradeApplianceResponse, OperationMetadata>
      upgradeApplianceOperationSettings() {
    return upgradeApplianceOperationSettings;
  }

  /** Returns the object with the settings used for calls to createMigratingVm. */
  public UnaryCallSettings<CreateMigratingVmRequest, Operation> createMigratingVmSettings() {
    return createMigratingVmSettings;
  }

  /** Returns the object with the settings used for calls to createMigratingVm. */
  public OperationCallSettings<CreateMigratingVmRequest, MigratingVm, OperationMetadata>
      createMigratingVmOperationSettings() {
    return createMigratingVmOperationSettings;
  }

  /** Returns the object with the settings used for calls to listMigratingVms. */
  public PagedCallSettings<
          ListMigratingVmsRequest, ListMigratingVmsResponse, ListMigratingVmsPagedResponse>
      listMigratingVmsSettings() {
    return listMigratingVmsSettings;
  }

  /** Returns the object with the settings used for calls to getMigratingVm. */
  public UnaryCallSettings<GetMigratingVmRequest, MigratingVm> getMigratingVmSettings() {
    return getMigratingVmSettings;
  }

  /** Returns the object with the settings used for calls to updateMigratingVm. */
  public UnaryCallSettings<UpdateMigratingVmRequest, Operation> updateMigratingVmSettings() {
    return updateMigratingVmSettings;
  }

  /** Returns the object with the settings used for calls to updateMigratingVm. */
  public OperationCallSettings<UpdateMigratingVmRequest, MigratingVm, OperationMetadata>
      updateMigratingVmOperationSettings() {
    return updateMigratingVmOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteMigratingVm. */
  public UnaryCallSettings<DeleteMigratingVmRequest, Operation> deleteMigratingVmSettings() {
    return deleteMigratingVmSettings;
  }

  /** Returns the object with the settings used for calls to deleteMigratingVm. */
  public OperationCallSettings<DeleteMigratingVmRequest, Empty, OperationMetadata>
      deleteMigratingVmOperationSettings() {
    return deleteMigratingVmOperationSettings;
  }

  /** Returns the object with the settings used for calls to startMigration. */
  public UnaryCallSettings<StartMigrationRequest, Operation> startMigrationSettings() {
    return startMigrationSettings;
  }

  /** Returns the object with the settings used for calls to startMigration. */
  public OperationCallSettings<StartMigrationRequest, StartMigrationResponse, OperationMetadata>
      startMigrationOperationSettings() {
    return startMigrationOperationSettings;
  }

  /** Returns the object with the settings used for calls to resumeMigration. */
  public UnaryCallSettings<ResumeMigrationRequest, Operation> resumeMigrationSettings() {
    return resumeMigrationSettings;
  }

  /** Returns the object with the settings used for calls to resumeMigration. */
  public OperationCallSettings<ResumeMigrationRequest, ResumeMigrationResponse, OperationMetadata>
      resumeMigrationOperationSettings() {
    return resumeMigrationOperationSettings;
  }

  /** Returns the object with the settings used for calls to pauseMigration. */
  public UnaryCallSettings<PauseMigrationRequest, Operation> pauseMigrationSettings() {
    return pauseMigrationSettings;
  }

  /** Returns the object with the settings used for calls to pauseMigration. */
  public OperationCallSettings<PauseMigrationRequest, PauseMigrationResponse, OperationMetadata>
      pauseMigrationOperationSettings() {
    return pauseMigrationOperationSettings;
  }

  /** Returns the object with the settings used for calls to finalizeMigration. */
  public UnaryCallSettings<FinalizeMigrationRequest, Operation> finalizeMigrationSettings() {
    return finalizeMigrationSettings;
  }

  /** Returns the object with the settings used for calls to finalizeMigration. */
  public OperationCallSettings<
          FinalizeMigrationRequest, FinalizeMigrationResponse, OperationMetadata>
      finalizeMigrationOperationSettings() {
    return finalizeMigrationOperationSettings;
  }

  /** Returns the object with the settings used for calls to extendMigration. */
  public UnaryCallSettings<ExtendMigrationRequest, Operation> extendMigrationSettings() {
    return extendMigrationSettings;
  }

  /** Returns the object with the settings used for calls to extendMigration. */
  public OperationCallSettings<ExtendMigrationRequest, ExtendMigrationResponse, OperationMetadata>
      extendMigrationOperationSettings() {
    return extendMigrationOperationSettings;
  }

  /** Returns the object with the settings used for calls to createCloneJob. */
  public UnaryCallSettings<CreateCloneJobRequest, Operation> createCloneJobSettings() {
    return createCloneJobSettings;
  }

  /** Returns the object with the settings used for calls to createCloneJob. */
  public OperationCallSettings<CreateCloneJobRequest, CloneJob, OperationMetadata>
      createCloneJobOperationSettings() {
    return createCloneJobOperationSettings;
  }

  /** Returns the object with the settings used for calls to cancelCloneJob. */
  public UnaryCallSettings<CancelCloneJobRequest, Operation> cancelCloneJobSettings() {
    return cancelCloneJobSettings;
  }

  /** Returns the object with the settings used for calls to cancelCloneJob. */
  public OperationCallSettings<CancelCloneJobRequest, CancelCloneJobResponse, OperationMetadata>
      cancelCloneJobOperationSettings() {
    return cancelCloneJobOperationSettings;
  }

  /** Returns the object with the settings used for calls to listCloneJobs. */
  public PagedCallSettings<ListCloneJobsRequest, ListCloneJobsResponse, ListCloneJobsPagedResponse>
      listCloneJobsSettings() {
    return listCloneJobsSettings;
  }

  /** Returns the object with the settings used for calls to getCloneJob. */
  public UnaryCallSettings<GetCloneJobRequest, CloneJob> getCloneJobSettings() {
    return getCloneJobSettings;
  }

  /** Returns the object with the settings used for calls to createCutoverJob. */
  public UnaryCallSettings<CreateCutoverJobRequest, Operation> createCutoverJobSettings() {
    return createCutoverJobSettings;
  }

  /** Returns the object with the settings used for calls to createCutoverJob. */
  public OperationCallSettings<CreateCutoverJobRequest, CutoverJob, OperationMetadata>
      createCutoverJobOperationSettings() {
    return createCutoverJobOperationSettings;
  }

  /** Returns the object with the settings used for calls to cancelCutoverJob. */
  public UnaryCallSettings<CancelCutoverJobRequest, Operation> cancelCutoverJobSettings() {
    return cancelCutoverJobSettings;
  }

  /** Returns the object with the settings used for calls to cancelCutoverJob. */
  public OperationCallSettings<CancelCutoverJobRequest, CancelCutoverJobResponse, OperationMetadata>
      cancelCutoverJobOperationSettings() {
    return cancelCutoverJobOperationSettings;
  }

  /** Returns the object with the settings used for calls to listCutoverJobs. */
  public PagedCallSettings<
          ListCutoverJobsRequest, ListCutoverJobsResponse, ListCutoverJobsPagedResponse>
      listCutoverJobsSettings() {
    return listCutoverJobsSettings;
  }

  /** Returns the object with the settings used for calls to getCutoverJob. */
  public UnaryCallSettings<GetCutoverJobRequest, CutoverJob> getCutoverJobSettings() {
    return getCutoverJobSettings;
  }

  /** Returns the object with the settings used for calls to listGroups. */
  public PagedCallSettings<ListGroupsRequest, ListGroupsResponse, ListGroupsPagedResponse>
      listGroupsSettings() {
    return listGroupsSettings;
  }

  /** Returns the object with the settings used for calls to getGroup. */
  public UnaryCallSettings<GetGroupRequest, Group> getGroupSettings() {
    return getGroupSettings;
  }

  /** Returns the object with the settings used for calls to createGroup. */
  public UnaryCallSettings<CreateGroupRequest, Operation> createGroupSettings() {
    return createGroupSettings;
  }

  /** Returns the object with the settings used for calls to createGroup. */
  public OperationCallSettings<CreateGroupRequest, Group, OperationMetadata>
      createGroupOperationSettings() {
    return createGroupOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateGroup. */
  public UnaryCallSettings<UpdateGroupRequest, Operation> updateGroupSettings() {
    return updateGroupSettings;
  }

  /** Returns the object with the settings used for calls to updateGroup. */
  public OperationCallSettings<UpdateGroupRequest, Group, OperationMetadata>
      updateGroupOperationSettings() {
    return updateGroupOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteGroup. */
  public UnaryCallSettings<DeleteGroupRequest, Operation> deleteGroupSettings() {
    return deleteGroupSettings;
  }

  /** Returns the object with the settings used for calls to deleteGroup. */
  public OperationCallSettings<DeleteGroupRequest, Empty, OperationMetadata>
      deleteGroupOperationSettings() {
    return deleteGroupOperationSettings;
  }

  /** Returns the object with the settings used for calls to addGroupMigration. */
  public UnaryCallSettings<AddGroupMigrationRequest, Operation> addGroupMigrationSettings() {
    return addGroupMigrationSettings;
  }

  /** Returns the object with the settings used for calls to addGroupMigration. */
  public OperationCallSettings<
          AddGroupMigrationRequest, AddGroupMigrationResponse, OperationMetadata>
      addGroupMigrationOperationSettings() {
    return addGroupMigrationOperationSettings;
  }

  /** Returns the object with the settings used for calls to removeGroupMigration. */
  public UnaryCallSettings<RemoveGroupMigrationRequest, Operation> removeGroupMigrationSettings() {
    return removeGroupMigrationSettings;
  }

  /** Returns the object with the settings used for calls to removeGroupMigration. */
  public OperationCallSettings<
          RemoveGroupMigrationRequest, RemoveGroupMigrationResponse, OperationMetadata>
      removeGroupMigrationOperationSettings() {
    return removeGroupMigrationOperationSettings;
  }

  /** Returns the object with the settings used for calls to listTargetProjects. */
  public PagedCallSettings<
          ListTargetProjectsRequest, ListTargetProjectsResponse, ListTargetProjectsPagedResponse>
      listTargetProjectsSettings() {
    return listTargetProjectsSettings;
  }

  /** Returns the object with the settings used for calls to getTargetProject. */
  public UnaryCallSettings<GetTargetProjectRequest, TargetProject> getTargetProjectSettings() {
    return getTargetProjectSettings;
  }

  /** Returns the object with the settings used for calls to createTargetProject. */
  public UnaryCallSettings<CreateTargetProjectRequest, Operation> createTargetProjectSettings() {
    return createTargetProjectSettings;
  }

  /** Returns the object with the settings used for calls to createTargetProject. */
  public OperationCallSettings<CreateTargetProjectRequest, TargetProject, OperationMetadata>
      createTargetProjectOperationSettings() {
    return createTargetProjectOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateTargetProject. */
  public UnaryCallSettings<UpdateTargetProjectRequest, Operation> updateTargetProjectSettings() {
    return updateTargetProjectSettings;
  }

  /** Returns the object with the settings used for calls to updateTargetProject. */
  public OperationCallSettings<UpdateTargetProjectRequest, TargetProject, OperationMetadata>
      updateTargetProjectOperationSettings() {
    return updateTargetProjectOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteTargetProject. */
  public UnaryCallSettings<DeleteTargetProjectRequest, Operation> deleteTargetProjectSettings() {
    return deleteTargetProjectSettings;
  }

  /** Returns the object with the settings used for calls to deleteTargetProject. */
  public OperationCallSettings<DeleteTargetProjectRequest, Empty, OperationMetadata>
      deleteTargetProjectOperationSettings() {
    return deleteTargetProjectOperationSettings;
  }

  /** Returns the object with the settings used for calls to listReplicationCycles. */
  public PagedCallSettings<
          ListReplicationCyclesRequest,
          ListReplicationCyclesResponse,
          ListReplicationCyclesPagedResponse>
      listReplicationCyclesSettings() {
    return listReplicationCyclesSettings;
  }

  /** Returns the object with the settings used for calls to getReplicationCycle. */
  public UnaryCallSettings<GetReplicationCycleRequest, ReplicationCycle>
      getReplicationCycleSettings() {
    return getReplicationCycleSettings;
  }

  /** Returns the object with the settings used for calls to listImageImports. */
  public PagedCallSettings<
          ListImageImportsRequest, ListImageImportsResponse, ListImageImportsPagedResponse>
      listImageImportsSettings() {
    return listImageImportsSettings;
  }

  /** Returns the object with the settings used for calls to getImageImport. */
  public UnaryCallSettings<GetImageImportRequest, ImageImport> getImageImportSettings() {
    return getImageImportSettings;
  }

  /** Returns the object with the settings used for calls to createImageImport. */
  public UnaryCallSettings<CreateImageImportRequest, Operation> createImageImportSettings() {
    return createImageImportSettings;
  }

  /** Returns the object with the settings used for calls to createImageImport. */
  public OperationCallSettings<CreateImageImportRequest, ImageImport, OperationMetadata>
      createImageImportOperationSettings() {
    return createImageImportOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteImageImport. */
  public UnaryCallSettings<DeleteImageImportRequest, Operation> deleteImageImportSettings() {
    return deleteImageImportSettings;
  }

  /** Returns the object with the settings used for calls to deleteImageImport. */
  public OperationCallSettings<DeleteImageImportRequest, Empty, OperationMetadata>
      deleteImageImportOperationSettings() {
    return deleteImageImportOperationSettings;
  }

  /** Returns the object with the settings used for calls to listImageImportJobs. */
  public PagedCallSettings<
          ListImageImportJobsRequest, ListImageImportJobsResponse, ListImageImportJobsPagedResponse>
      listImageImportJobsSettings() {
    return listImageImportJobsSettings;
  }

  /** Returns the object with the settings used for calls to getImageImportJob. */
  public UnaryCallSettings<GetImageImportJobRequest, ImageImportJob> getImageImportJobSettings() {
    return getImageImportJobSettings;
  }

  /** Returns the object with the settings used for calls to cancelImageImportJob. */
  public UnaryCallSettings<CancelImageImportJobRequest, Operation> cancelImageImportJobSettings() {
    return cancelImageImportJobSettings;
  }

  /** Returns the object with the settings used for calls to cancelImageImportJob. */
  public OperationCallSettings<
          CancelImageImportJobRequest, CancelImageImportJobResponse, OperationMetadata>
      cancelImageImportJobOperationSettings() {
    return cancelImageImportJobOperationSettings;
  }

  /** Returns the object with the settings used for calls to createDiskMigrationJob. */
  public UnaryCallSettings<CreateDiskMigrationJobRequest, Operation>
      createDiskMigrationJobSettings() {
    return createDiskMigrationJobSettings;
  }

  /** Returns the object with the settings used for calls to createDiskMigrationJob. */
  public OperationCallSettings<CreateDiskMigrationJobRequest, DiskMigrationJob, OperationMetadata>
      createDiskMigrationJobOperationSettings() {
    return createDiskMigrationJobOperationSettings;
  }

  /** Returns the object with the settings used for calls to listDiskMigrationJobs. */
  public PagedCallSettings<
          ListDiskMigrationJobsRequest,
          ListDiskMigrationJobsResponse,
          ListDiskMigrationJobsPagedResponse>
      listDiskMigrationJobsSettings() {
    return listDiskMigrationJobsSettings;
  }

  /** Returns the object with the settings used for calls to getDiskMigrationJob. */
  public UnaryCallSettings<GetDiskMigrationJobRequest, DiskMigrationJob>
      getDiskMigrationJobSettings() {
    return getDiskMigrationJobSettings;
  }

  /** Returns the object with the settings used for calls to updateDiskMigrationJob. */
  public UnaryCallSettings<UpdateDiskMigrationJobRequest, Operation>
      updateDiskMigrationJobSettings() {
    return updateDiskMigrationJobSettings;
  }

  /** Returns the object with the settings used for calls to updateDiskMigrationJob. */
  public OperationCallSettings<UpdateDiskMigrationJobRequest, DiskMigrationJob, OperationMetadata>
      updateDiskMigrationJobOperationSettings() {
    return updateDiskMigrationJobOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteDiskMigrationJob. */
  public UnaryCallSettings<DeleteDiskMigrationJobRequest, Operation>
      deleteDiskMigrationJobSettings() {
    return deleteDiskMigrationJobSettings;
  }

  /** Returns the object with the settings used for calls to deleteDiskMigrationJob. */
  public OperationCallSettings<DeleteDiskMigrationJobRequest, Empty, OperationMetadata>
      deleteDiskMigrationJobOperationSettings() {
    return deleteDiskMigrationJobOperationSettings;
  }

  /** Returns the object with the settings used for calls to runDiskMigrationJob. */
  public UnaryCallSettings<RunDiskMigrationJobRequest, Operation> runDiskMigrationJobSettings() {
    return runDiskMigrationJobSettings;
  }

  /** Returns the object with the settings used for calls to runDiskMigrationJob. */
  public OperationCallSettings<
          RunDiskMigrationJobRequest, RunDiskMigrationJobResponse, OperationMetadata>
      runDiskMigrationJobOperationSettings() {
    return runDiskMigrationJobOperationSettings;
  }

  /** Returns the object with the settings used for calls to cancelDiskMigrationJob. */
  public UnaryCallSettings<CancelDiskMigrationJobRequest, Operation>
      cancelDiskMigrationJobSettings() {
    return cancelDiskMigrationJobSettings;
  }

  /** Returns the object with the settings used for calls to cancelDiskMigrationJob. */
  public OperationCallSettings<
          CancelDiskMigrationJobRequest, CancelDiskMigrationJobResponse, OperationMetadata>
      cancelDiskMigrationJobOperationSettings() {
    return cancelDiskMigrationJobOperationSettings;
  }

  /** Returns the object with the settings used for calls to listLocations. */
  public PagedCallSettings<ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings() {
    return listLocationsSettings;
  }

  /** Returns the object with the settings used for calls to getLocation. */
  public UnaryCallSettings<GetLocationRequest, Location> getLocationSettings() {
    return getLocationSettings;
  }

  public VmMigrationStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcVmMigrationStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonVmMigrationStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns the default service name. */
  @Override
  public String getServiceName() {
    return "vmmigration";
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  @ObsoleteApi("Use getEndpoint() instead")
  public static String getDefaultEndpoint() {
    return "vmmigration.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "vmmigration.mtls.googleapis.com:443";
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return DEFAULT_SERVICE_SCOPES;
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return GoogleCredentialsProvider.newBuilder()
        .setScopesToApply(DEFAULT_SERVICE_SCOPES)
        .setUseJwtAccessWithScope(true);
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return InstantiatingGrpcChannelProvider.newBuilder()
        .setMaxInboundMessageSize(Integer.MAX_VALUE);
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return InstantiatingHttpJsonChannelProvider.newBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return defaultGrpcTransportProviderBuilder().build();
  }

  public static ApiClientHeaderProvider.Builder defaultGrpcApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(VmMigrationStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(VmMigrationStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return VmMigrationStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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

  protected VmMigrationStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    listSourcesSettings = settingsBuilder.listSourcesSettings().build();
    getSourceSettings = settingsBuilder.getSourceSettings().build();
    createSourceSettings = settingsBuilder.createSourceSettings().build();
    createSourceOperationSettings = settingsBuilder.createSourceOperationSettings().build();
    updateSourceSettings = settingsBuilder.updateSourceSettings().build();
    updateSourceOperationSettings = settingsBuilder.updateSourceOperationSettings().build();
    deleteSourceSettings = settingsBuilder.deleteSourceSettings().build();
    deleteSourceOperationSettings = settingsBuilder.deleteSourceOperationSettings().build();
    fetchInventorySettings = settingsBuilder.fetchInventorySettings().build();
    fetchStorageInventorySettings = settingsBuilder.fetchStorageInventorySettings().build();
    listUtilizationReportsSettings = settingsBuilder.listUtilizationReportsSettings().build();
    getUtilizationReportSettings = settingsBuilder.getUtilizationReportSettings().build();
    createUtilizationReportSettings = settingsBuilder.createUtilizationReportSettings().build();
    createUtilizationReportOperationSettings =
        settingsBuilder.createUtilizationReportOperationSettings().build();
    deleteUtilizationReportSettings = settingsBuilder.deleteUtilizationReportSettings().build();
    deleteUtilizationReportOperationSettings =
        settingsBuilder.deleteUtilizationReportOperationSettings().build();
    listDatacenterConnectorsSettings = settingsBuilder.listDatacenterConnectorsSettings().build();
    getDatacenterConnectorSettings = settingsBuilder.getDatacenterConnectorSettings().build();
    createDatacenterConnectorSettings = settingsBuilder.createDatacenterConnectorSettings().build();
    createDatacenterConnectorOperationSettings =
        settingsBuilder.createDatacenterConnectorOperationSettings().build();
    deleteDatacenterConnectorSettings = settingsBuilder.deleteDatacenterConnectorSettings().build();
    deleteDatacenterConnectorOperationSettings =
        settingsBuilder.deleteDatacenterConnectorOperationSettings().build();
    upgradeApplianceSettings = settingsBuilder.upgradeApplianceSettings().build();
    upgradeApplianceOperationSettings = settingsBuilder.upgradeApplianceOperationSettings().build();
    createMigratingVmSettings = settingsBuilder.createMigratingVmSettings().build();
    createMigratingVmOperationSettings =
        settingsBuilder.createMigratingVmOperationSettings().build();
    listMigratingVmsSettings = settingsBuilder.listMigratingVmsSettings().build();
    getMigratingVmSettings = settingsBuilder.getMigratingVmSettings().build();
    updateMigratingVmSettings = settingsBuilder.updateMigratingVmSettings().build();
    updateMigratingVmOperationSettings =
        settingsBuilder.updateMigratingVmOperationSettings().build();
    deleteMigratingVmSettings = settingsBuilder.deleteMigratingVmSettings().build();
    deleteMigratingVmOperationSettings =
        settingsBuilder.deleteMigratingVmOperationSettings().build();
    startMigrationSettings = settingsBuilder.startMigrationSettings().build();
    startMigrationOperationSettings = settingsBuilder.startMigrationOperationSettings().build();
    resumeMigrationSettings = settingsBuilder.resumeMigrationSettings().build();
    resumeMigrationOperationSettings = settingsBuilder.resumeMigrationOperationSettings().build();
    pauseMigrationSettings = settingsBuilder.pauseMigrationSettings().build();
    pauseMigrationOperationSettings = settingsBuilder.pauseMigrationOperationSettings().build();
    finalizeMigrationSettings = settingsBuilder.finalizeMigrationSettings().build();
    finalizeMigrationOperationSettings =
        settingsBuilder.finalizeMigrationOperationSettings().build();
    extendMigrationSettings = settingsBuilder.extendMigrationSettings().build();
    extendMigrationOperationSettings = settingsBuilder.extendMigrationOperationSettings().build();
    createCloneJobSettings = settingsBuilder.createCloneJobSettings().build();
    createCloneJobOperationSettings = settingsBuilder.createCloneJobOperationSettings().build();
    cancelCloneJobSettings = settingsBuilder.cancelCloneJobSettings().build();
    cancelCloneJobOperationSettings = settingsBuilder.cancelCloneJobOperationSettings().build();
    listCloneJobsSettings = settingsBuilder.listCloneJobsSettings().build();
    getCloneJobSettings = settingsBuilder.getCloneJobSettings().build();
    createCutoverJobSettings = settingsBuilder.createCutoverJobSettings().build();
    createCutoverJobOperationSettings = settingsBuilder.createCutoverJobOperationSettings().build();
    cancelCutoverJobSettings = settingsBuilder.cancelCutoverJobSettings().build();
    cancelCutoverJobOperationSettings = settingsBuilder.cancelCutoverJobOperationSettings().build();
    listCutoverJobsSettings = settingsBuilder.listCutoverJobsSettings().build();
    getCutoverJobSettings = settingsBuilder.getCutoverJobSettings().build();
    listGroupsSettings = settingsBuilder.listGroupsSettings().build();
    getGroupSettings = settingsBuilder.getGroupSettings().build();
    createGroupSettings = settingsBuilder.createGroupSettings().build();
    createGroupOperationSettings = settingsBuilder.createGroupOperationSettings().build();
    updateGroupSettings = settingsBuilder.updateGroupSettings().build();
    updateGroupOperationSettings = settingsBuilder.updateGroupOperationSettings().build();
    deleteGroupSettings = settingsBuilder.deleteGroupSettings().build();
    deleteGroupOperationSettings = settingsBuilder.deleteGroupOperationSettings().build();
    addGroupMigrationSettings = settingsBuilder.addGroupMigrationSettings().build();
    addGroupMigrationOperationSettings =
        settingsBuilder.addGroupMigrationOperationSettings().build();
    removeGroupMigrationSettings = settingsBuilder.removeGroupMigrationSettings().build();
    removeGroupMigrationOperationSettings =
        settingsBuilder.removeGroupMigrationOperationSettings().build();
    listTargetProjectsSettings = settingsBuilder.listTargetProjectsSettings().build();
    getTargetProjectSettings = settingsBuilder.getTargetProjectSettings().build();
    createTargetProjectSettings = settingsBuilder.createTargetProjectSettings().build();
    createTargetProjectOperationSettings =
        settingsBuilder.createTargetProjectOperationSettings().build();
    updateTargetProjectSettings = settingsBuilder.updateTargetProjectSettings().build();
    updateTargetProjectOperationSettings =
        settingsBuilder.updateTargetProjectOperationSettings().build();
    deleteTargetProjectSettings = settingsBuilder.deleteTargetProjectSettings().build();
    deleteTargetProjectOperationSettings =
        settingsBuilder.deleteTargetProjectOperationSettings().build();
    listReplicationCyclesSettings = settingsBuilder.listReplicationCyclesSettings().build();
    getReplicationCycleSettings = settingsBuilder.getReplicationCycleSettings().build();
    listImageImportsSettings = settingsBuilder.listImageImportsSettings().build();
    getImageImportSettings = settingsBuilder.getImageImportSettings().build();
    createImageImportSettings = settingsBuilder.createImageImportSettings().build();
    createImageImportOperationSettings =
        settingsBuilder.createImageImportOperationSettings().build();
    deleteImageImportSettings = settingsBuilder.deleteImageImportSettings().build();
    deleteImageImportOperationSettings =
        settingsBuilder.deleteImageImportOperationSettings().build();
    listImageImportJobsSettings = settingsBuilder.listImageImportJobsSettings().build();
    getImageImportJobSettings = settingsBuilder.getImageImportJobSettings().build();
    cancelImageImportJobSettings = settingsBuilder.cancelImageImportJobSettings().build();
    cancelImageImportJobOperationSettings =
        settingsBuilder.cancelImageImportJobOperationSettings().build();
    createDiskMigrationJobSettings = settingsBuilder.createDiskMigrationJobSettings().build();
    createDiskMigrationJobOperationSettings =
        settingsBuilder.createDiskMigrationJobOperationSettings().build();
    listDiskMigrationJobsSettings = settingsBuilder.listDiskMigrationJobsSettings().build();
    getDiskMigrationJobSettings = settingsBuilder.getDiskMigrationJobSettings().build();
    updateDiskMigrationJobSettings = settingsBuilder.updateDiskMigrationJobSettings().build();
    updateDiskMigrationJobOperationSettings =
        settingsBuilder.updateDiskMigrationJobOperationSettings().build();
    deleteDiskMigrationJobSettings = settingsBuilder.deleteDiskMigrationJobSettings().build();
    deleteDiskMigrationJobOperationSettings =
        settingsBuilder.deleteDiskMigrationJobOperationSettings().build();
    runDiskMigrationJobSettings = settingsBuilder.runDiskMigrationJobSettings().build();
    runDiskMigrationJobOperationSettings =
        settingsBuilder.runDiskMigrationJobOperationSettings().build();
    cancelDiskMigrationJobSettings = settingsBuilder.cancelDiskMigrationJobSettings().build();
    cancelDiskMigrationJobOperationSettings =
        settingsBuilder.cancelDiskMigrationJobOperationSettings().build();
    listLocationsSettings = settingsBuilder.listLocationsSettings().build();
    getLocationSettings = settingsBuilder.getLocationSettings().build();
  }

  /** Builder for VmMigrationStubSettings. */
  public static class Builder extends StubSettings.Builder<VmMigrationStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final PagedCallSettings.Builder<
            ListSourcesRequest, ListSourcesResponse, ListSourcesPagedResponse>
        listSourcesSettings;
    private final UnaryCallSettings.Builder<GetSourceRequest, Source> getSourceSettings;
    private final UnaryCallSettings.Builder<CreateSourceRequest, Operation> createSourceSettings;
    private final OperationCallSettings.Builder<CreateSourceRequest, Source, OperationMetadata>
        createSourceOperationSettings;
    private final UnaryCallSettings.Builder<UpdateSourceRequest, Operation> updateSourceSettings;
    private final OperationCallSettings.Builder<UpdateSourceRequest, Source, OperationMetadata>
        updateSourceOperationSettings;
    private final UnaryCallSettings.Builder<DeleteSourceRequest, Operation> deleteSourceSettings;
    private final OperationCallSettings.Builder<DeleteSourceRequest, Empty, OperationMetadata>
        deleteSourceOperationSettings;
    private final UnaryCallSettings.Builder<FetchInventoryRequest, FetchInventoryResponse>
        fetchInventorySettings;
    private final PagedCallSettings.Builder<
            FetchStorageInventoryRequest,
            FetchStorageInventoryResponse,
            FetchStorageInventoryPagedResponse>
        fetchStorageInventorySettings;
    private final PagedCallSettings.Builder<
            ListUtilizationReportsRequest,
            ListUtilizationReportsResponse,
            ListUtilizationReportsPagedResponse>
        listUtilizationReportsSettings;
    private final UnaryCallSettings.Builder<GetUtilizationReportRequest, UtilizationReport>
        getUtilizationReportSettings;
    private final UnaryCallSettings.Builder<CreateUtilizationReportRequest, Operation>
        createUtilizationReportSettings;
    private final OperationCallSettings.Builder<
            CreateUtilizationReportRequest, UtilizationReport, OperationMetadata>
        createUtilizationReportOperationSettings;
    private final UnaryCallSettings.Builder<DeleteUtilizationReportRequest, Operation>
        deleteUtilizationReportSettings;
    private final OperationCallSettings.Builder<
            DeleteUtilizationReportRequest, Empty, OperationMetadata>
        deleteUtilizationReportOperationSettings;
    private final PagedCallSettings.Builder<
            ListDatacenterConnectorsRequest,
            ListDatacenterConnectorsResponse,
            ListDatacenterConnectorsPagedResponse>
        listDatacenterConnectorsSettings;
    private final UnaryCallSettings.Builder<GetDatacenterConnectorRequest, DatacenterConnector>
        getDatacenterConnectorSettings;
    private final UnaryCallSettings.Builder<CreateDatacenterConnectorRequest, Operation>
        createDatacenterConnectorSettings;
    private final OperationCallSettings.Builder<
            CreateDatacenterConnectorRequest, DatacenterConnector, OperationMetadata>
        createDatacenterConnectorOperationSettings;
    private final UnaryCallSettings.Builder<DeleteDatacenterConnectorRequest, Operation>
        deleteDatacenterConnectorSettings;
    private final OperationCallSettings.Builder<
            DeleteDatacenterConnectorRequest, Empty, OperationMetadata>
        deleteDatacenterConnectorOperationSettings;
    private final UnaryCallSettings.Builder<UpgradeApplianceRequest, Operation>
        upgradeApplianceSettings;
    private final OperationCallSettings.Builder<
            UpgradeApplianceRequest, UpgradeApplianceResponse, OperationMetadata>
        upgradeApplianceOperationSettings;
    private final UnaryCallSettings.Builder<CreateMigratingVmRequest, Operation>
        createMigratingVmSettings;
    private final OperationCallSettings.Builder<
            CreateMigratingVmRequest, MigratingVm, OperationMetadata>
        createMigratingVmOperationSettings;
    private final PagedCallSettings.Builder<
            ListMigratingVmsRequest, ListMigratingVmsResponse, ListMigratingVmsPagedResponse>
        listMigratingVmsSettings;
    private final UnaryCallSettings.Builder<GetMigratingVmRequest, MigratingVm>
        getMigratingVmSettings;
    private final UnaryCallSettings.Builder<UpdateMigratingVmRequest, Operation>
        updateMigratingVmSettings;
    private final OperationCallSettings.Builder<
            UpdateMigratingVmRequest, MigratingVm, OperationMetadata>
        updateMigratingVmOperationSettings;
    private final UnaryCallSettings.Builder<DeleteMigratingVmRequest, Operation>
        deleteMigratingVmSettings;
    private final OperationCallSettings.Builder<DeleteMigratingVmRequest, Empty, OperationMetadata>
        deleteMigratingVmOperationSettings;
    private final UnaryCallSettings.Builder<StartMigrationRequest, Operation>
        startMigrationSettings;
    private final OperationCallSettings.Builder<
            StartMigrationRequest, StartMigrationResponse, OperationMetadata>
        startMigrationOperationSettings;
    private final UnaryCallSettings.Builder<ResumeMigrationRequest, Operation>
        resumeMigrationSettings;
    private final OperationCallSettings.Builder<
            ResumeMigrationRequest, ResumeMigrationResponse, OperationMetadata>
        resumeMigrationOperationSettings;
    private final UnaryCallSettings.Builder<PauseMigrationRequest, Operation>
        pauseMigrationSettings;
    private final OperationCallSettings.Builder<
            PauseMigrationRequest, PauseMigrationResponse, OperationMetadata>
        pauseMigrationOperationSettings;
    private final UnaryCallSettings.Builder<FinalizeMigrationRequest, Operation>
        finalizeMigrationSettings;
    private final OperationCallSettings.Builder<
            FinalizeMigrationRequest, FinalizeMigrationResponse, OperationMetadata>
        finalizeMigrationOperationSettings;
    private final UnaryCallSettings.Builder<ExtendMigrationRequest, Operation>
        extendMigrationSettings;
    private final OperationCallSettings.Builder<
            ExtendMigrationRequest, ExtendMigrationResponse, OperationMetadata>
        extendMigrationOperationSettings;
    private final UnaryCallSettings.Builder<CreateCloneJobRequest, Operation>
        createCloneJobSettings;
    private final OperationCallSettings.Builder<CreateCloneJobRequest, CloneJob, OperationMetadata>
        createCloneJobOperationSettings;
    private final UnaryCallSettings.Builder<CancelCloneJobRequest, Operation>
        cancelCloneJobSettings;
    private final OperationCallSettings.Builder<
            CancelCloneJobRequest, CancelCloneJobResponse, OperationMetadata>
        cancelCloneJobOperationSettings;
    private final PagedCallSettings.Builder<
            ListCloneJobsRequest, ListCloneJobsResponse, ListCloneJobsPagedResponse>
        listCloneJobsSettings;
    private final UnaryCallSettings.Builder<GetCloneJobRequest, CloneJob> getCloneJobSettings;
    private final UnaryCallSettings.Builder<CreateCutoverJobRequest, Operation>
        createCutoverJobSettings;
    private final OperationCallSettings.Builder<
            CreateCutoverJobRequest, CutoverJob, OperationMetadata>
        createCutoverJobOperationSettings;
    private final UnaryCallSettings.Builder<CancelCutoverJobRequest, Operation>
        cancelCutoverJobSettings;
    private final OperationCallSettings.Builder<
            CancelCutoverJobRequest, CancelCutoverJobResponse, OperationMetadata>
        cancelCutoverJobOperationSettings;
    private final PagedCallSettings.Builder<
            ListCutoverJobsRequest, ListCutoverJobsResponse, ListCutoverJobsPagedResponse>
        listCutoverJobsSettings;
    private final UnaryCallSettings.Builder<GetCutoverJobRequest, CutoverJob> getCutoverJobSettings;
    private final PagedCallSettings.Builder<
            ListGroupsRequest, ListGroupsResponse, ListGroupsPagedResponse>
        listGroupsSettings;
    private final UnaryCallSettings.Builder<GetGroupRequest, Group> getGroupSettings;
    private final UnaryCallSettings.Builder<CreateGroupRequest, Operation> createGroupSettings;
    private final OperationCallSettings.Builder<CreateGroupRequest, Group, OperationMetadata>
        createGroupOperationSettings;
    private final UnaryCallSettings.Builder<UpdateGroupRequest, Operation> updateGroupSettings;
    private final OperationCallSettings.Builder<UpdateGroupRequest, Group, OperationMetadata>
        updateGroupOperationSettings;
    private final UnaryCallSettings.Builder<DeleteGroupRequest, Operation> deleteGroupSettings;
    private final OperationCallSettings.Builder<DeleteGroupRequest, Empty, OperationMetadata>
        deleteGroupOperationSettings;
    private final UnaryCallSettings.Builder<AddGroupMigrationRequest, Operation>
        addGroupMigrationSettings;
    private final OperationCallSettings.Builder<
            AddGroupMigrationRequest, AddGroupMigrationResponse, OperationMetadata>
        addGroupMigrationOperationSettings;
    private final UnaryCallSettings.Builder<RemoveGroupMigrationRequest, Operation>
        removeGroupMigrationSettings;
    private final OperationCallSettings.Builder<
            RemoveGroupMigrationRequest, RemoveGroupMigrationResponse, OperationMetadata>
        removeGroupMigrationOperationSettings;
    private final PagedCallSettings.Builder<
            ListTargetProjectsRequest, ListTargetProjectsResponse, ListTargetProjectsPagedResponse>
        listTargetProjectsSettings;
    private final UnaryCallSettings.Builder<GetTargetProjectRequest, TargetProject>
        getTargetProjectSettings;
    private final UnaryCallSettings.Builder<CreateTargetProjectRequest, Operation>
        createTargetProjectSettings;
    private final OperationCallSettings.Builder<
            CreateTargetProjectRequest, TargetProject, OperationMetadata>
        createTargetProjectOperationSettings;
    private final UnaryCallSettings.Builder<UpdateTargetProjectRequest, Operation>
        updateTargetProjectSettings;
    private final OperationCallSettings.Builder<
            UpdateTargetProjectRequest, TargetProject, OperationMetadata>
        updateTargetProjectOperationSettings;
    private final UnaryCallSettings.Builder<DeleteTargetProjectRequest, Operation>
        deleteTargetProjectSettings;
    private final OperationCallSettings.Builder<
            DeleteTargetProjectRequest, Empty, OperationMetadata>
        deleteTargetProjectOperationSettings;
    private final PagedCallSettings.Builder<
            ListReplicationCyclesRequest,
            ListReplicationCyclesResponse,
            ListReplicationCyclesPagedResponse>
        listReplicationCyclesSettings;
    private final UnaryCallSettings.Builder<GetReplicationCycleRequest, ReplicationCycle>
        getReplicationCycleSettings;
    private final PagedCallSettings.Builder<
            ListImageImportsRequest, ListImageImportsResponse, ListImageImportsPagedResponse>
        listImageImportsSettings;
    private final UnaryCallSettings.Builder<GetImageImportRequest, ImageImport>
        getImageImportSettings;
    private final UnaryCallSettings.Builder<CreateImageImportRequest, Operation>
        createImageImportSettings;
    private final OperationCallSettings.Builder<
            CreateImageImportRequest, ImageImport, OperationMetadata>
        createImageImportOperationSettings;
    private final UnaryCallSettings.Builder<DeleteImageImportRequest, Operation>
        deleteImageImportSettings;
    private final OperationCallSettings.Builder<DeleteImageImportRequest, Empty, OperationMetadata>
        deleteImageImportOperationSettings;
    private final PagedCallSettings.Builder<
            ListImageImportJobsRequest,
            ListImageImportJobsResponse,
            ListImageImportJobsPagedResponse>
        listImageImportJobsSettings;
    private final UnaryCallSettings.Builder<GetImageImportJobRequest, ImageImportJob>
        getImageImportJobSettings;
    private final UnaryCallSettings.Builder<CancelImageImportJobRequest, Operation>
        cancelImageImportJobSettings;
    private final OperationCallSettings.Builder<
            CancelImageImportJobRequest, CancelImageImportJobResponse, OperationMetadata>
        cancelImageImportJobOperationSettings;
    private final UnaryCallSettings.Builder<CreateDiskMigrationJobRequest, Operation>
        createDiskMigrationJobSettings;
    private final OperationCallSettings.Builder<
            CreateDiskMigrationJobRequest, DiskMigrationJob, OperationMetadata>
        createDiskMigrationJobOperationSettings;
    private final PagedCallSettings.Builder<
            ListDiskMigrationJobsRequest,
            ListDiskMigrationJobsResponse,
            ListDiskMigrationJobsPagedResponse>
        listDiskMigrationJobsSettings;
    private final UnaryCallSettings.Builder<GetDiskMigrationJobRequest, DiskMigrationJob>
        getDiskMigrationJobSettings;
    private final UnaryCallSettings.Builder<UpdateDiskMigrationJobRequest, Operation>
        updateDiskMigrationJobSettings;
    private final OperationCallSettings.Builder<
            UpdateDiskMigrationJobRequest, DiskMigrationJob, OperationMetadata>
        updateDiskMigrationJobOperationSettings;
    private final UnaryCallSettings.Builder<DeleteDiskMigrationJobRequest, Operation>
        deleteDiskMigrationJobSettings;
    private final OperationCallSettings.Builder<
            DeleteDiskMigrationJobRequest, Empty, OperationMetadata>
        deleteDiskMigrationJobOperationSettings;
    private final UnaryCallSettings.Builder<RunDiskMigrationJobRequest, Operation>
        runDiskMigrationJobSettings;
    private final OperationCallSettings.Builder<
            RunDiskMigrationJobRequest, RunDiskMigrationJobResponse, OperationMetadata>
        runDiskMigrationJobOperationSettings;
    private final UnaryCallSettings.Builder<CancelDiskMigrationJobRequest, Operation>
        cancelDiskMigrationJobSettings;
    private final OperationCallSettings.Builder<
            CancelDiskMigrationJobRequest, CancelDiskMigrationJobResponse, OperationMetadata>
        cancelDiskMigrationJobOperationSettings;
    private final PagedCallSettings.Builder<
            ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
        listLocationsSettings;
    private final UnaryCallSettings.Builder<GetLocationRequest, Location> getLocationSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put(
          "no_retry_0_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      definitions.put(
          "no_retry_2_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      definitions.put(
          "no_retry_1_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      RETRYABLE_CODE_DEFINITIONS = definitions.build();
    }

    private static final ImmutableMap<String, RetrySettings> RETRY_PARAM_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, RetrySettings> definitions = ImmutableMap.builder();
      RetrySettings settings = null;
      settings =
          RetrySettings.newBuilder()
              .setInitialRpcTimeoutDuration(Duration.ofMillis(60000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeoutDuration(Duration.ofMillis(60000L))
              .setTotalTimeoutDuration(Duration.ofMillis(60000L))
              .build();
      definitions.put("no_retry_0_params", settings);
      settings =
          RetrySettings.newBuilder()
              .setInitialRpcTimeoutDuration(Duration.ofMillis(900000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeoutDuration(Duration.ofMillis(900000L))
              .setTotalTimeoutDuration(Duration.ofMillis(900000L))
              .build();
      definitions.put("no_retry_2_params", settings);
      settings =
          RetrySettings.newBuilder()
              .setInitialRpcTimeoutDuration(Duration.ofMillis(300000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeoutDuration(Duration.ofMillis(300000L))
              .setTotalTimeoutDuration(Duration.ofMillis(300000L))
              .build();
      definitions.put("no_retry_1_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      listSourcesSettings = PagedCallSettings.newBuilder(LIST_SOURCES_PAGE_STR_FACT);
      getSourceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createSourceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createSourceOperationSettings = OperationCallSettings.newBuilder();
      updateSourceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateSourceOperationSettings = OperationCallSettings.newBuilder();
      deleteSourceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteSourceOperationSettings = OperationCallSettings.newBuilder();
      fetchInventorySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      fetchStorageInventorySettings =
          PagedCallSettings.newBuilder(FETCH_STORAGE_INVENTORY_PAGE_STR_FACT);
      listUtilizationReportsSettings =
          PagedCallSettings.newBuilder(LIST_UTILIZATION_REPORTS_PAGE_STR_FACT);
      getUtilizationReportSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createUtilizationReportSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createUtilizationReportOperationSettings = OperationCallSettings.newBuilder();
      deleteUtilizationReportSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteUtilizationReportOperationSettings = OperationCallSettings.newBuilder();
      listDatacenterConnectorsSettings =
          PagedCallSettings.newBuilder(LIST_DATACENTER_CONNECTORS_PAGE_STR_FACT);
      getDatacenterConnectorSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createDatacenterConnectorSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createDatacenterConnectorOperationSettings = OperationCallSettings.newBuilder();
      deleteDatacenterConnectorSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteDatacenterConnectorOperationSettings = OperationCallSettings.newBuilder();
      upgradeApplianceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      upgradeApplianceOperationSettings = OperationCallSettings.newBuilder();
      createMigratingVmSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createMigratingVmOperationSettings = OperationCallSettings.newBuilder();
      listMigratingVmsSettings = PagedCallSettings.newBuilder(LIST_MIGRATING_VMS_PAGE_STR_FACT);
      getMigratingVmSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateMigratingVmSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateMigratingVmOperationSettings = OperationCallSettings.newBuilder();
      deleteMigratingVmSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteMigratingVmOperationSettings = OperationCallSettings.newBuilder();
      startMigrationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      startMigrationOperationSettings = OperationCallSettings.newBuilder();
      resumeMigrationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      resumeMigrationOperationSettings = OperationCallSettings.newBuilder();
      pauseMigrationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      pauseMigrationOperationSettings = OperationCallSettings.newBuilder();
      finalizeMigrationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      finalizeMigrationOperationSettings = OperationCallSettings.newBuilder();
      extendMigrationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      extendMigrationOperationSettings = OperationCallSettings.newBuilder();
      createCloneJobSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createCloneJobOperationSettings = OperationCallSettings.newBuilder();
      cancelCloneJobSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      cancelCloneJobOperationSettings = OperationCallSettings.newBuilder();
      listCloneJobsSettings = PagedCallSettings.newBuilder(LIST_CLONE_JOBS_PAGE_STR_FACT);
      getCloneJobSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createCutoverJobSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createCutoverJobOperationSettings = OperationCallSettings.newBuilder();
      cancelCutoverJobSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      cancelCutoverJobOperationSettings = OperationCallSettings.newBuilder();
      listCutoverJobsSettings = PagedCallSettings.newBuilder(LIST_CUTOVER_JOBS_PAGE_STR_FACT);
      getCutoverJobSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listGroupsSettings = PagedCallSettings.newBuilder(LIST_GROUPS_PAGE_STR_FACT);
      getGroupSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createGroupSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createGroupOperationSettings = OperationCallSettings.newBuilder();
      updateGroupSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateGroupOperationSettings = OperationCallSettings.newBuilder();
      deleteGroupSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteGroupOperationSettings = OperationCallSettings.newBuilder();
      addGroupMigrationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      addGroupMigrationOperationSettings = OperationCallSettings.newBuilder();
      removeGroupMigrationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      removeGroupMigrationOperationSettings = OperationCallSettings.newBuilder();
      listTargetProjectsSettings = PagedCallSettings.newBuilder(LIST_TARGET_PROJECTS_PAGE_STR_FACT);
      getTargetProjectSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createTargetProjectSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createTargetProjectOperationSettings = OperationCallSettings.newBuilder();
      updateTargetProjectSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateTargetProjectOperationSettings = OperationCallSettings.newBuilder();
      deleteTargetProjectSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteTargetProjectOperationSettings = OperationCallSettings.newBuilder();
      listReplicationCyclesSettings =
          PagedCallSettings.newBuilder(LIST_REPLICATION_CYCLES_PAGE_STR_FACT);
      getReplicationCycleSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listImageImportsSettings = PagedCallSettings.newBuilder(LIST_IMAGE_IMPORTS_PAGE_STR_FACT);
      getImageImportSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createImageImportSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createImageImportOperationSettings = OperationCallSettings.newBuilder();
      deleteImageImportSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteImageImportOperationSettings = OperationCallSettings.newBuilder();
      listImageImportJobsSettings =
          PagedCallSettings.newBuilder(LIST_IMAGE_IMPORT_JOBS_PAGE_STR_FACT);
      getImageImportJobSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      cancelImageImportJobSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      cancelImageImportJobOperationSettings = OperationCallSettings.newBuilder();
      createDiskMigrationJobSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createDiskMigrationJobOperationSettings = OperationCallSettings.newBuilder();
      listDiskMigrationJobsSettings =
          PagedCallSettings.newBuilder(LIST_DISK_MIGRATION_JOBS_PAGE_STR_FACT);
      getDiskMigrationJobSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateDiskMigrationJobSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateDiskMigrationJobOperationSettings = OperationCallSettings.newBuilder();
      deleteDiskMigrationJobSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteDiskMigrationJobOperationSettings = OperationCallSettings.newBuilder();
      runDiskMigrationJobSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      runDiskMigrationJobOperationSettings = OperationCallSettings.newBuilder();
      cancelDiskMigrationJobSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      cancelDiskMigrationJobOperationSettings = OperationCallSettings.newBuilder();
      listLocationsSettings = PagedCallSettings.newBuilder(LIST_LOCATIONS_PAGE_STR_FACT);
      getLocationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listSourcesSettings,
              getSourceSettings,
              createSourceSettings,
              updateSourceSettings,
              deleteSourceSettings,
              fetchInventorySettings,
              fetchStorageInventorySettings,
              listUtilizationReportsSettings,
              getUtilizationReportSettings,
              createUtilizationReportSettings,
              deleteUtilizationReportSettings,
              listDatacenterConnectorsSettings,
              getDatacenterConnectorSettings,
              createDatacenterConnectorSettings,
              deleteDatacenterConnectorSettings,
              upgradeApplianceSettings,
              createMigratingVmSettings,
              listMigratingVmsSettings,
              getMigratingVmSettings,
              updateMigratingVmSettings,
              deleteMigratingVmSettings,
              startMigrationSettings,
              resumeMigrationSettings,
              pauseMigrationSettings,
              finalizeMigrationSettings,
              extendMigrationSettings,
              createCloneJobSettings,
              cancelCloneJobSettings,
              listCloneJobsSettings,
              getCloneJobSettings,
              createCutoverJobSettings,
              cancelCutoverJobSettings,
              listCutoverJobsSettings,
              getCutoverJobSettings,
              listGroupsSettings,
              getGroupSettings,
              createGroupSettings,
              updateGroupSettings,
              deleteGroupSettings,
              addGroupMigrationSettings,
              removeGroupMigrationSettings,
              listTargetProjectsSettings,
              getTargetProjectSettings,
              createTargetProjectSettings,
              updateTargetProjectSettings,
              deleteTargetProjectSettings,
              listReplicationCyclesSettings,
              getReplicationCycleSettings,
              listImageImportsSettings,
              getImageImportSettings,
              createImageImportSettings,
              deleteImageImportSettings,
              listImageImportJobsSettings,
              getImageImportJobSettings,
              cancelImageImportJobSettings,
              createDiskMigrationJobSettings,
              listDiskMigrationJobsSettings,
              getDiskMigrationJobSettings,
              updateDiskMigrationJobSettings,
              deleteDiskMigrationJobSettings,
              runDiskMigrationJobSettings,
              cancelDiskMigrationJobSettings,
              listLocationsSettings,
              getLocationSettings);
      initDefaults(this);
    }

    protected Builder(VmMigrationStubSettings settings) {
      super(settings);

      listSourcesSettings = settings.listSourcesSettings.toBuilder();
      getSourceSettings = settings.getSourceSettings.toBuilder();
      createSourceSettings = settings.createSourceSettings.toBuilder();
      createSourceOperationSettings = settings.createSourceOperationSettings.toBuilder();
      updateSourceSettings = settings.updateSourceSettings.toBuilder();
      updateSourceOperationSettings = settings.updateSourceOperationSettings.toBuilder();
      deleteSourceSettings = settings.deleteSourceSettings.toBuilder();
      deleteSourceOperationSettings = settings.deleteSourceOperationSettings.toBuilder();
      fetchInventorySettings = settings.fetchInventorySettings.toBuilder();
      fetchStorageInventorySettings = settings.fetchStorageInventorySettings.toBuilder();
      listUtilizationReportsSettings = settings.listUtilizationReportsSettings.toBuilder();
      getUtilizationReportSettings = settings.getUtilizationReportSettings.toBuilder();
      createUtilizationReportSettings = settings.createUtilizationReportSettings.toBuilder();
      createUtilizationReportOperationSettings =
          settings.createUtilizationReportOperationSettings.toBuilder();
      deleteUtilizationReportSettings = settings.deleteUtilizationReportSettings.toBuilder();
      deleteUtilizationReportOperationSettings =
          settings.deleteUtilizationReportOperationSettings.toBuilder();
      listDatacenterConnectorsSettings = settings.listDatacenterConnectorsSettings.toBuilder();
      getDatacenterConnectorSettings = settings.getDatacenterConnectorSettings.toBuilder();
      createDatacenterConnectorSettings = settings.createDatacenterConnectorSettings.toBuilder();
      createDatacenterConnectorOperationSettings =
          settings.createDatacenterConnectorOperationSettings.toBuilder();
      deleteDatacenterConnectorSettings = settings.deleteDatacenterConnectorSettings.toBuilder();
      deleteDatacenterConnectorOperationSettings =
          settings.deleteDatacenterConnectorOperationSettings.toBuilder();
      upgradeApplianceSettings = settings.upgradeApplianceSettings.toBuilder();
      upgradeApplianceOperationSettings = settings.upgradeApplianceOperationSettings.toBuilder();
      createMigratingVmSettings = settings.createMigratingVmSettings.toBuilder();
      createMigratingVmOperationSettings = settings.createMigratingVmOperationSettings.toBuilder();
      listMigratingVmsSettings = settings.listMigratingVmsSettings.toBuilder();
      getMigratingVmSettings = settings.getMigratingVmSettings.toBuilder();
      updateMigratingVmSettings = settings.updateMigratingVmSettings.toBuilder();
      updateMigratingVmOperationSettings = settings.updateMigratingVmOperationSettings.toBuilder();
      deleteMigratingVmSettings = settings.deleteMigratingVmSettings.toBuilder();
      deleteMigratingVmOperationSettings = settings.deleteMigratingVmOperationSettings.toBuilder();
      startMigrationSettings = settings.startMigrationSettings.toBuilder();
      startMigrationOperationSettings = settings.startMigrationOperationSettings.toBuilder();
      resumeMigrationSettings = settings.resumeMigrationSettings.toBuilder();
      resumeMigrationOperationSettings = settings.resumeMigrationOperationSettings.toBuilder();
      pauseMigrationSettings = settings.pauseMigrationSettings.toBuilder();
      pauseMigrationOperationSettings = settings.pauseMigrationOperationSettings.toBuilder();
      finalizeMigrationSettings = settings.finalizeMigrationSettings.toBuilder();
      finalizeMigrationOperationSettings = settings.finalizeMigrationOperationSettings.toBuilder();
      extendMigrationSettings = settings.extendMigrationSettings.toBuilder();
      extendMigrationOperationSettings = settings.extendMigrationOperationSettings.toBuilder();
      createCloneJobSettings = settings.createCloneJobSettings.toBuilder();
      createCloneJobOperationSettings = settings.createCloneJobOperationSettings.toBuilder();
      cancelCloneJobSettings = settings.cancelCloneJobSettings.toBuilder();
      cancelCloneJobOperationSettings = settings.cancelCloneJobOperationSettings.toBuilder();
      listCloneJobsSettings = settings.listCloneJobsSettings.toBuilder();
      getCloneJobSettings = settings.getCloneJobSettings.toBuilder();
      createCutoverJobSettings = settings.createCutoverJobSettings.toBuilder();
      createCutoverJobOperationSettings = settings.createCutoverJobOperationSettings.toBuilder();
      cancelCutoverJobSettings = settings.cancelCutoverJobSettings.toBuilder();
      cancelCutoverJobOperationSettings = settings.cancelCutoverJobOperationSettings.toBuilder();
      listCutoverJobsSettings = settings.listCutoverJobsSettings.toBuilder();
      getCutoverJobSettings = settings.getCutoverJobSettings.toBuilder();
      listGroupsSettings = settings.listGroupsSettings.toBuilder();
      getGroupSettings = settings.getGroupSettings.toBuilder();
      createGroupSettings = settings.createGroupSettings.toBuilder();
      createGroupOperationSettings = settings.createGroupOperationSettings.toBuilder();
      updateGroupSettings = settings.updateGroupSettings.toBuilder();
      updateGroupOperationSettings = settings.updateGroupOperationSettings.toBuilder();
      deleteGroupSettings = settings.deleteGroupSettings.toBuilder();
      deleteGroupOperationSettings = settings.deleteGroupOperationSettings.toBuilder();
      addGroupMigrationSettings = settings.addGroupMigrationSettings.toBuilder();
      addGroupMigrationOperationSettings = settings.addGroupMigrationOperationSettings.toBuilder();
      removeGroupMigrationSettings = settings.removeGroupMigrationSettings.toBuilder();
      removeGroupMigrationOperationSettings =
          settings.removeGroupMigrationOperationSettings.toBuilder();
      listTargetProjectsSettings = settings.listTargetProjectsSettings.toBuilder();
      getTargetProjectSettings = settings.getTargetProjectSettings.toBuilder();
      createTargetProjectSettings = settings.createTargetProjectSettings.toBuilder();
      createTargetProjectOperationSettings =
          settings.createTargetProjectOperationSettings.toBuilder();
      updateTargetProjectSettings = settings.updateTargetProjectSettings.toBuilder();
      updateTargetProjectOperationSettings =
          settings.updateTargetProjectOperationSettings.toBuilder();
      deleteTargetProjectSettings = settings.deleteTargetProjectSettings.toBuilder();
      deleteTargetProjectOperationSettings =
          settings.deleteTargetProjectOperationSettings.toBuilder();
      listReplicationCyclesSettings = settings.listReplicationCyclesSettings.toBuilder();
      getReplicationCycleSettings = settings.getReplicationCycleSettings.toBuilder();
      listImageImportsSettings = settings.listImageImportsSettings.toBuilder();
      getImageImportSettings = settings.getImageImportSettings.toBuilder();
      createImageImportSettings = settings.createImageImportSettings.toBuilder();
      createImageImportOperationSettings = settings.createImageImportOperationSettings.toBuilder();
      deleteImageImportSettings = settings.deleteImageImportSettings.toBuilder();
      deleteImageImportOperationSettings = settings.deleteImageImportOperationSettings.toBuilder();
      listImageImportJobsSettings = settings.listImageImportJobsSettings.toBuilder();
      getImageImportJobSettings = settings.getImageImportJobSettings.toBuilder();
      cancelImageImportJobSettings = settings.cancelImageImportJobSettings.toBuilder();
      cancelImageImportJobOperationSettings =
          settings.cancelImageImportJobOperationSettings.toBuilder();
      createDiskMigrationJobSettings = settings.createDiskMigrationJobSettings.toBuilder();
      createDiskMigrationJobOperationSettings =
          settings.createDiskMigrationJobOperationSettings.toBuilder();
      listDiskMigrationJobsSettings = settings.listDiskMigrationJobsSettings.toBuilder();
      getDiskMigrationJobSettings = settings.getDiskMigrationJobSettings.toBuilder();
      updateDiskMigrationJobSettings = settings.updateDiskMigrationJobSettings.toBuilder();
      updateDiskMigrationJobOperationSettings =
          settings.updateDiskMigrationJobOperationSettings.toBuilder();
      deleteDiskMigrationJobSettings = settings.deleteDiskMigrationJobSettings.toBuilder();
      deleteDiskMigrationJobOperationSettings =
          settings.deleteDiskMigrationJobOperationSettings.toBuilder();
      runDiskMigrationJobSettings = settings.runDiskMigrationJobSettings.toBuilder();
      runDiskMigrationJobOperationSettings =
          settings.runDiskMigrationJobOperationSettings.toBuilder();
      cancelDiskMigrationJobSettings = settings.cancelDiskMigrationJobSettings.toBuilder();
      cancelDiskMigrationJobOperationSettings =
          settings.cancelDiskMigrationJobOperationSettings.toBuilder();
      listLocationsSettings = settings.listLocationsSettings.toBuilder();
      getLocationSettings = settings.getLocationSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listSourcesSettings,
              getSourceSettings,
              createSourceSettings,
              updateSourceSettings,
              deleteSourceSettings,
              fetchInventorySettings,
              fetchStorageInventorySettings,
              listUtilizationReportsSettings,
              getUtilizationReportSettings,
              createUtilizationReportSettings,
              deleteUtilizationReportSettings,
              listDatacenterConnectorsSettings,
              getDatacenterConnectorSettings,
              createDatacenterConnectorSettings,
              deleteDatacenterConnectorSettings,
              upgradeApplianceSettings,
              createMigratingVmSettings,
              listMigratingVmsSettings,
              getMigratingVmSettings,
              updateMigratingVmSettings,
              deleteMigratingVmSettings,
              startMigrationSettings,
              resumeMigrationSettings,
              pauseMigrationSettings,
              finalizeMigrationSettings,
              extendMigrationSettings,
              createCloneJobSettings,
              cancelCloneJobSettings,
              listCloneJobsSettings,
              getCloneJobSettings,
              createCutoverJobSettings,
              cancelCutoverJobSettings,
              listCutoverJobsSettings,
              getCutoverJobSettings,
              listGroupsSettings,
              getGroupSettings,
              createGroupSettings,
              updateGroupSettings,
              deleteGroupSettings,
              addGroupMigrationSettings,
              removeGroupMigrationSettings,
              listTargetProjectsSettings,
              getTargetProjectSettings,
              createTargetProjectSettings,
              updateTargetProjectSettings,
              deleteTargetProjectSettings,
              listReplicationCyclesSettings,
              getReplicationCycleSettings,
              listImageImportsSettings,
              getImageImportSettings,
              createImageImportSettings,
              deleteImageImportSettings,
              listImageImportJobsSettings,
              getImageImportJobSettings,
              cancelImageImportJobSettings,
              createDiskMigrationJobSettings,
              listDiskMigrationJobsSettings,
              getDiskMigrationJobSettings,
              updateDiskMigrationJobSettings,
              deleteDiskMigrationJobSettings,
              runDiskMigrationJobSettings,
              cancelDiskMigrationJobSettings,
              listLocationsSettings,
              getLocationSettings);
    }

    private static Builder createDefault() {
      Builder builder = new Builder(((ClientContext) null));

      builder.setTransportChannelProvider(defaultTransportChannelProvider());
      builder.setCredentialsProvider(defaultCredentialsProviderBuilder().build());
      builder.setInternalHeaderProvider(defaultApiClientHeaderProviderBuilder().build());
      builder.setMtlsEndpoint(getDefaultMtlsEndpoint());
      builder.setSwitchToMtlsEndpointAllowed(true);

      return initDefaults(builder);
    }

    private static Builder createHttpJsonDefault() {
      Builder builder = new Builder(((ClientContext) null));

      builder.setTransportChannelProvider(defaultHttpJsonTransportProviderBuilder().build());
      builder.setCredentialsProvider(defaultCredentialsProviderBuilder().build());
      builder.setInternalHeaderProvider(defaultHttpJsonApiClientHeaderProviderBuilder().build());
      builder.setMtlsEndpoint(getDefaultMtlsEndpoint());
      builder.setSwitchToMtlsEndpointAllowed(true);

      return initDefaults(builder);
    }

    private static Builder initDefaults(Builder builder) {
      builder
          .listSourcesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .getSourceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .createSourceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_2_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_2_params"));

      builder
          .updateSourceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .deleteSourceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .fetchInventorySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .fetchStorageInventorySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .listUtilizationReportsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .getUtilizationReportSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .createUtilizationReportSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .deleteUtilizationReportSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .listDatacenterConnectorsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .getDatacenterConnectorSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .createDatacenterConnectorSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .deleteDatacenterConnectorSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .upgradeApplianceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .createMigratingVmSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .listMigratingVmsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .getMigratingVmSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .updateMigratingVmSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .deleteMigratingVmSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .startMigrationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .resumeMigrationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .pauseMigrationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .finalizeMigrationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .extendMigrationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .createCloneJobSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .cancelCloneJobSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .listCloneJobsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .getCloneJobSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .createCutoverJobSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .cancelCutoverJobSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .listCutoverJobsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .getCutoverJobSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .listGroupsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .getGroupSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .createGroupSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .updateGroupSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .deleteGroupSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .addGroupMigrationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .removeGroupMigrationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .listTargetProjectsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .getTargetProjectSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .createTargetProjectSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .updateTargetProjectSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .deleteTargetProjectSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .listReplicationCyclesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .getReplicationCycleSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .listImageImportsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .getImageImportSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .createImageImportSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .deleteImageImportSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .listImageImportJobsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .getImageImportJobSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .cancelImageImportJobSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .createDiskMigrationJobSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .listDiskMigrationJobsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .getDiskMigrationJobSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .updateDiskMigrationJobSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .deleteDiskMigrationJobSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .runDiskMigrationJobSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .cancelDiskMigrationJobSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .listLocationsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .getLocationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .createSourceOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateSourceRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_2_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_2_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Source.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .updateSourceOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateSourceRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Source.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .deleteSourceOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteSourceRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .createUtilizationReportOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateUtilizationReportRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(UtilizationReport.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .deleteUtilizationReportOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteUtilizationReportRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .createDatacenterConnectorOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateDatacenterConnectorRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(DatacenterConnector.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .deleteDatacenterConnectorOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteDatacenterConnectorRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .upgradeApplianceOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpgradeApplianceRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(UpgradeApplianceResponse.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .createMigratingVmOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateMigratingVmRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(MigratingVm.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .updateMigratingVmOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateMigratingVmRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(MigratingVm.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .deleteMigratingVmOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteMigratingVmRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .startMigrationOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<StartMigrationRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(StartMigrationResponse.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .resumeMigrationOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<ResumeMigrationRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(ResumeMigrationResponse.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .pauseMigrationOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<PauseMigrationRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(PauseMigrationResponse.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .finalizeMigrationOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<FinalizeMigrationRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(
                  FinalizeMigrationResponse.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .extendMigrationOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<ExtendMigrationRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(ExtendMigrationResponse.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .createCloneJobOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateCloneJobRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(CloneJob.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .cancelCloneJobOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CancelCloneJobRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(CancelCloneJobResponse.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .createCutoverJobOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateCutoverJobRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(CutoverJob.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .cancelCutoverJobOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CancelCutoverJobRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(CancelCutoverJobResponse.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .createGroupOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings.<CreateGroupRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Group.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .updateGroupOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings.<UpdateGroupRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Group.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .deleteGroupOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings.<DeleteGroupRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .addGroupMigrationOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<AddGroupMigrationRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(
                  AddGroupMigrationResponse.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .removeGroupMigrationOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<RemoveGroupMigrationRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(
                  RemoveGroupMigrationResponse.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .createTargetProjectOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateTargetProjectRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(TargetProject.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .updateTargetProjectOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateTargetProjectRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(TargetProject.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .deleteTargetProjectOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteTargetProjectRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .createImageImportOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateImageImportRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(ImageImport.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .deleteImageImportOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteImageImportRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .cancelImageImportJobOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CancelImageImportJobRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(
                  CancelImageImportJobResponse.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .createDiskMigrationJobOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateDiskMigrationJobRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(DiskMigrationJob.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .updateDiskMigrationJobOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateDiskMigrationJobRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(DiskMigrationJob.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .deleteDiskMigrationJobOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteDiskMigrationJobRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .runDiskMigrationJobOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<RunDiskMigrationJobRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(
                  RunDiskMigrationJobResponse.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .cancelDiskMigrationJobOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CancelDiskMigrationJobRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(
                  CancelDiskMigrationJobResponse.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      return builder;
    }

    /**
     * Applies the given settings updater function to all of the unary API methods in this service.
     *
     * <p>Note: This method does not support applying settings to streaming methods.
     */
    public Builder applyToAllUnaryMethods(
        ApiFunction<UnaryCallSettings.Builder<?, ?>, Void> settingsUpdater) {
      super.applyToAllUnaryMethods(unaryMethodSettingsBuilders, settingsUpdater);
      return this;
    }

    public ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders() {
      return unaryMethodSettingsBuilders;
    }

    /** Returns the builder for the settings used for calls to listSources. */
    public PagedCallSettings.Builder<
            ListSourcesRequest, ListSourcesResponse, ListSourcesPagedResponse>
        listSourcesSettings() {
      return listSourcesSettings;
    }

    /** Returns the builder for the settings used for calls to getSource. */
    public UnaryCallSettings.Builder<GetSourceRequest, Source> getSourceSettings() {
      return getSourceSettings;
    }

    /** Returns the builder for the settings used for calls to createSource. */
    public UnaryCallSettings.Builder<CreateSourceRequest, Operation> createSourceSettings() {
      return createSourceSettings;
    }

    /** Returns the builder for the settings used for calls to createSource. */
    public OperationCallSettings.Builder<CreateSourceRequest, Source, OperationMetadata>
        createSourceOperationSettings() {
      return createSourceOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateSource. */
    public UnaryCallSettings.Builder<UpdateSourceRequest, Operation> updateSourceSettings() {
      return updateSourceSettings;
    }

    /** Returns the builder for the settings used for calls to updateSource. */
    public OperationCallSettings.Builder<UpdateSourceRequest, Source, OperationMetadata>
        updateSourceOperationSettings() {
      return updateSourceOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteSource. */
    public UnaryCallSettings.Builder<DeleteSourceRequest, Operation> deleteSourceSettings() {
      return deleteSourceSettings;
    }

    /** Returns the builder for the settings used for calls to deleteSource. */
    public OperationCallSettings.Builder<DeleteSourceRequest, Empty, OperationMetadata>
        deleteSourceOperationSettings() {
      return deleteSourceOperationSettings;
    }

    /** Returns the builder for the settings used for calls to fetchInventory. */
    public UnaryCallSettings.Builder<FetchInventoryRequest, FetchInventoryResponse>
        fetchInventorySettings() {
      return fetchInventorySettings;
    }

    /** Returns the builder for the settings used for calls to fetchStorageInventory. */
    public PagedCallSettings.Builder<
            FetchStorageInventoryRequest,
            FetchStorageInventoryResponse,
            FetchStorageInventoryPagedResponse>
        fetchStorageInventorySettings() {
      return fetchStorageInventorySettings;
    }

    /** Returns the builder for the settings used for calls to listUtilizationReports. */
    public PagedCallSettings.Builder<
            ListUtilizationReportsRequest,
            ListUtilizationReportsResponse,
            ListUtilizationReportsPagedResponse>
        listUtilizationReportsSettings() {
      return listUtilizationReportsSettings;
    }

    /** Returns the builder for the settings used for calls to getUtilizationReport. */
    public UnaryCallSettings.Builder<GetUtilizationReportRequest, UtilizationReport>
        getUtilizationReportSettings() {
      return getUtilizationReportSettings;
    }

    /** Returns the builder for the settings used for calls to createUtilizationReport. */
    public UnaryCallSettings.Builder<CreateUtilizationReportRequest, Operation>
        createUtilizationReportSettings() {
      return createUtilizationReportSettings;
    }

    /** Returns the builder for the settings used for calls to createUtilizationReport. */
    public OperationCallSettings.Builder<
            CreateUtilizationReportRequest, UtilizationReport, OperationMetadata>
        createUtilizationReportOperationSettings() {
      return createUtilizationReportOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteUtilizationReport. */
    public UnaryCallSettings.Builder<DeleteUtilizationReportRequest, Operation>
        deleteUtilizationReportSettings() {
      return deleteUtilizationReportSettings;
    }

    /** Returns the builder for the settings used for calls to deleteUtilizationReport. */
    public OperationCallSettings.Builder<DeleteUtilizationReportRequest, Empty, OperationMetadata>
        deleteUtilizationReportOperationSettings() {
      return deleteUtilizationReportOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listDatacenterConnectors. */
    public PagedCallSettings.Builder<
            ListDatacenterConnectorsRequest,
            ListDatacenterConnectorsResponse,
            ListDatacenterConnectorsPagedResponse>
        listDatacenterConnectorsSettings() {
      return listDatacenterConnectorsSettings;
    }

    /** Returns the builder for the settings used for calls to getDatacenterConnector. */
    public UnaryCallSettings.Builder<GetDatacenterConnectorRequest, DatacenterConnector>
        getDatacenterConnectorSettings() {
      return getDatacenterConnectorSettings;
    }

    /** Returns the builder for the settings used for calls to createDatacenterConnector. */
    public UnaryCallSettings.Builder<CreateDatacenterConnectorRequest, Operation>
        createDatacenterConnectorSettings() {
      return createDatacenterConnectorSettings;
    }

    /** Returns the builder for the settings used for calls to createDatacenterConnector. */
    public OperationCallSettings.Builder<
            CreateDatacenterConnectorRequest, DatacenterConnector, OperationMetadata>
        createDatacenterConnectorOperationSettings() {
      return createDatacenterConnectorOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteDatacenterConnector. */
    public UnaryCallSettings.Builder<DeleteDatacenterConnectorRequest, Operation>
        deleteDatacenterConnectorSettings() {
      return deleteDatacenterConnectorSettings;
    }

    /** Returns the builder for the settings used for calls to deleteDatacenterConnector. */
    public OperationCallSettings.Builder<DeleteDatacenterConnectorRequest, Empty, OperationMetadata>
        deleteDatacenterConnectorOperationSettings() {
      return deleteDatacenterConnectorOperationSettings;
    }

    /** Returns the builder for the settings used for calls to upgradeAppliance. */
    public UnaryCallSettings.Builder<UpgradeApplianceRequest, Operation>
        upgradeApplianceSettings() {
      return upgradeApplianceSettings;
    }

    /** Returns the builder for the settings used for calls to upgradeAppliance. */
    public OperationCallSettings.Builder<
            UpgradeApplianceRequest, UpgradeApplianceResponse, OperationMetadata>
        upgradeApplianceOperationSettings() {
      return upgradeApplianceOperationSettings;
    }

    /** Returns the builder for the settings used for calls to createMigratingVm. */
    public UnaryCallSettings.Builder<CreateMigratingVmRequest, Operation>
        createMigratingVmSettings() {
      return createMigratingVmSettings;
    }

    /** Returns the builder for the settings used for calls to createMigratingVm. */
    public OperationCallSettings.Builder<CreateMigratingVmRequest, MigratingVm, OperationMetadata>
        createMigratingVmOperationSettings() {
      return createMigratingVmOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listMigratingVms. */
    public PagedCallSettings.Builder<
            ListMigratingVmsRequest, ListMigratingVmsResponse, ListMigratingVmsPagedResponse>
        listMigratingVmsSettings() {
      return listMigratingVmsSettings;
    }

    /** Returns the builder for the settings used for calls to getMigratingVm. */
    public UnaryCallSettings.Builder<GetMigratingVmRequest, MigratingVm> getMigratingVmSettings() {
      return getMigratingVmSettings;
    }

    /** Returns the builder for the settings used for calls to updateMigratingVm. */
    public UnaryCallSettings.Builder<UpdateMigratingVmRequest, Operation>
        updateMigratingVmSettings() {
      return updateMigratingVmSettings;
    }

    /** Returns the builder for the settings used for calls to updateMigratingVm. */
    public OperationCallSettings.Builder<UpdateMigratingVmRequest, MigratingVm, OperationMetadata>
        updateMigratingVmOperationSettings() {
      return updateMigratingVmOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteMigratingVm. */
    public UnaryCallSettings.Builder<DeleteMigratingVmRequest, Operation>
        deleteMigratingVmSettings() {
      return deleteMigratingVmSettings;
    }

    /** Returns the builder for the settings used for calls to deleteMigratingVm. */
    public OperationCallSettings.Builder<DeleteMigratingVmRequest, Empty, OperationMetadata>
        deleteMigratingVmOperationSettings() {
      return deleteMigratingVmOperationSettings;
    }

    /** Returns the builder for the settings used for calls to startMigration. */
    public UnaryCallSettings.Builder<StartMigrationRequest, Operation> startMigrationSettings() {
      return startMigrationSettings;
    }

    /** Returns the builder for the settings used for calls to startMigration. */
    public OperationCallSettings.Builder<
            StartMigrationRequest, StartMigrationResponse, OperationMetadata>
        startMigrationOperationSettings() {
      return startMigrationOperationSettings;
    }

    /** Returns the builder for the settings used for calls to resumeMigration. */
    public UnaryCallSettings.Builder<ResumeMigrationRequest, Operation> resumeMigrationSettings() {
      return resumeMigrationSettings;
    }

    /** Returns the builder for the settings used for calls to resumeMigration. */
    public OperationCallSettings.Builder<
            ResumeMigrationRequest, ResumeMigrationResponse, OperationMetadata>
        resumeMigrationOperationSettings() {
      return resumeMigrationOperationSettings;
    }

    /** Returns the builder for the settings used for calls to pauseMigration. */
    public UnaryCallSettings.Builder<PauseMigrationRequest, Operation> pauseMigrationSettings() {
      return pauseMigrationSettings;
    }

    /** Returns the builder for the settings used for calls to pauseMigration. */
    public OperationCallSettings.Builder<
            PauseMigrationRequest, PauseMigrationResponse, OperationMetadata>
        pauseMigrationOperationSettings() {
      return pauseMigrationOperationSettings;
    }

    /** Returns the builder for the settings used for calls to finalizeMigration. */
    public UnaryCallSettings.Builder<FinalizeMigrationRequest, Operation>
        finalizeMigrationSettings() {
      return finalizeMigrationSettings;
    }

    /** Returns the builder for the settings used for calls to finalizeMigration. */
    public OperationCallSettings.Builder<
            FinalizeMigrationRequest, FinalizeMigrationResponse, OperationMetadata>
        finalizeMigrationOperationSettings() {
      return finalizeMigrationOperationSettings;
    }

    /** Returns the builder for the settings used for calls to extendMigration. */
    public UnaryCallSettings.Builder<ExtendMigrationRequest, Operation> extendMigrationSettings() {
      return extendMigrationSettings;
    }

    /** Returns the builder for the settings used for calls to extendMigration. */
    public OperationCallSettings.Builder<
            ExtendMigrationRequest, ExtendMigrationResponse, OperationMetadata>
        extendMigrationOperationSettings() {
      return extendMigrationOperationSettings;
    }

    /** Returns the builder for the settings used for calls to createCloneJob. */
    public UnaryCallSettings.Builder<CreateCloneJobRequest, Operation> createCloneJobSettings() {
      return createCloneJobSettings;
    }

    /** Returns the builder for the settings used for calls to createCloneJob. */
    public OperationCallSettings.Builder<CreateCloneJobRequest, CloneJob, OperationMetadata>
        createCloneJobOperationSettings() {
      return createCloneJobOperationSettings;
    }

    /** Returns the builder for the settings used for calls to cancelCloneJob. */
    public UnaryCallSettings.Builder<CancelCloneJobRequest, Operation> cancelCloneJobSettings() {
      return cancelCloneJobSettings;
    }

    /** Returns the builder for the settings used for calls to cancelCloneJob. */
    public OperationCallSettings.Builder<
            CancelCloneJobRequest, CancelCloneJobResponse, OperationMetadata>
        cancelCloneJobOperationSettings() {
      return cancelCloneJobOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listCloneJobs. */
    public PagedCallSettings.Builder<
            ListCloneJobsRequest, ListCloneJobsResponse, ListCloneJobsPagedResponse>
        listCloneJobsSettings() {
      return listCloneJobsSettings;
    }

    /** Returns the builder for the settings used for calls to getCloneJob. */
    public UnaryCallSettings.Builder<GetCloneJobRequest, CloneJob> getCloneJobSettings() {
      return getCloneJobSettings;
    }

    /** Returns the builder for the settings used for calls to createCutoverJob. */
    public UnaryCallSettings.Builder<CreateCutoverJobRequest, Operation>
        createCutoverJobSettings() {
      return createCutoverJobSettings;
    }

    /** Returns the builder for the settings used for calls to createCutoverJob. */
    public OperationCallSettings.Builder<CreateCutoverJobRequest, CutoverJob, OperationMetadata>
        createCutoverJobOperationSettings() {
      return createCutoverJobOperationSettings;
    }

    /** Returns the builder for the settings used for calls to cancelCutoverJob. */
    public UnaryCallSettings.Builder<CancelCutoverJobRequest, Operation>
        cancelCutoverJobSettings() {
      return cancelCutoverJobSettings;
    }

    /** Returns the builder for the settings used for calls to cancelCutoverJob. */
    public OperationCallSettings.Builder<
            CancelCutoverJobRequest, CancelCutoverJobResponse, OperationMetadata>
        cancelCutoverJobOperationSettings() {
      return cancelCutoverJobOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listCutoverJobs. */
    public PagedCallSettings.Builder<
            ListCutoverJobsRequest, ListCutoverJobsResponse, ListCutoverJobsPagedResponse>
        listCutoverJobsSettings() {
      return listCutoverJobsSettings;
    }

    /** Returns the builder for the settings used for calls to getCutoverJob. */
    public UnaryCallSettings.Builder<GetCutoverJobRequest, CutoverJob> getCutoverJobSettings() {
      return getCutoverJobSettings;
    }

    /** Returns the builder for the settings used for calls to listGroups. */
    public PagedCallSettings.Builder<ListGroupsRequest, ListGroupsResponse, ListGroupsPagedResponse>
        listGroupsSettings() {
      return listGroupsSettings;
    }

    /** Returns the builder for the settings used for calls to getGroup. */
    public UnaryCallSettings.Builder<GetGroupRequest, Group> getGroupSettings() {
      return getGroupSettings;
    }

    /** Returns the builder for the settings used for calls to createGroup. */
    public UnaryCallSettings.Builder<CreateGroupRequest, Operation> createGroupSettings() {
      return createGroupSettings;
    }

    /** Returns the builder for the settings used for calls to createGroup. */
    public OperationCallSettings.Builder<CreateGroupRequest, Group, OperationMetadata>
        createGroupOperationSettings() {
      return createGroupOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateGroup. */
    public UnaryCallSettings.Builder<UpdateGroupRequest, Operation> updateGroupSettings() {
      return updateGroupSettings;
    }

    /** Returns the builder for the settings used for calls to updateGroup. */
    public OperationCallSettings.Builder<UpdateGroupRequest, Group, OperationMetadata>
        updateGroupOperationSettings() {
      return updateGroupOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteGroup. */
    public UnaryCallSettings.Builder<DeleteGroupRequest, Operation> deleteGroupSettings() {
      return deleteGroupSettings;
    }

    /** Returns the builder for the settings used for calls to deleteGroup. */
    public OperationCallSettings.Builder<DeleteGroupRequest, Empty, OperationMetadata>
        deleteGroupOperationSettings() {
      return deleteGroupOperationSettings;
    }

    /** Returns the builder for the settings used for calls to addGroupMigration. */
    public UnaryCallSettings.Builder<AddGroupMigrationRequest, Operation>
        addGroupMigrationSettings() {
      return addGroupMigrationSettings;
    }

    /** Returns the builder for the settings used for calls to addGroupMigration. */
    public OperationCallSettings.Builder<
            AddGroupMigrationRequest, AddGroupMigrationResponse, OperationMetadata>
        addGroupMigrationOperationSettings() {
      return addGroupMigrationOperationSettings;
    }

    /** Returns the builder for the settings used for calls to removeGroupMigration. */
    public UnaryCallSettings.Builder<RemoveGroupMigrationRequest, Operation>
        removeGroupMigrationSettings() {
      return removeGroupMigrationSettings;
    }

    /** Returns the builder for the settings used for calls to removeGroupMigration. */
    public OperationCallSettings.Builder<
            RemoveGroupMigrationRequest, RemoveGroupMigrationResponse, OperationMetadata>
        removeGroupMigrationOperationSettings() {
      return removeGroupMigrationOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listTargetProjects. */
    public PagedCallSettings.Builder<
            ListTargetProjectsRequest, ListTargetProjectsResponse, ListTargetProjectsPagedResponse>
        listTargetProjectsSettings() {
      return listTargetProjectsSettings;
    }

    /** Returns the builder for the settings used for calls to getTargetProject. */
    public UnaryCallSettings.Builder<GetTargetProjectRequest, TargetProject>
        getTargetProjectSettings() {
      return getTargetProjectSettings;
    }

    /** Returns the builder for the settings used for calls to createTargetProject. */
    public UnaryCallSettings.Builder<CreateTargetProjectRequest, Operation>
        createTargetProjectSettings() {
      return createTargetProjectSettings;
    }

    /** Returns the builder for the settings used for calls to createTargetProject. */
    public OperationCallSettings.Builder<
            CreateTargetProjectRequest, TargetProject, OperationMetadata>
        createTargetProjectOperationSettings() {
      return createTargetProjectOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateTargetProject. */
    public UnaryCallSettings.Builder<UpdateTargetProjectRequest, Operation>
        updateTargetProjectSettings() {
      return updateTargetProjectSettings;
    }

    /** Returns the builder for the settings used for calls to updateTargetProject. */
    public OperationCallSettings.Builder<
            UpdateTargetProjectRequest, TargetProject, OperationMetadata>
        updateTargetProjectOperationSettings() {
      return updateTargetProjectOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteTargetProject. */
    public UnaryCallSettings.Builder<DeleteTargetProjectRequest, Operation>
        deleteTargetProjectSettings() {
      return deleteTargetProjectSettings;
    }

    /** Returns the builder for the settings used for calls to deleteTargetProject. */
    public OperationCallSettings.Builder<DeleteTargetProjectRequest, Empty, OperationMetadata>
        deleteTargetProjectOperationSettings() {
      return deleteTargetProjectOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listReplicationCycles. */
    public PagedCallSettings.Builder<
            ListReplicationCyclesRequest,
            ListReplicationCyclesResponse,
            ListReplicationCyclesPagedResponse>
        listReplicationCyclesSettings() {
      return listReplicationCyclesSettings;
    }

    /** Returns the builder for the settings used for calls to getReplicationCycle. */
    public UnaryCallSettings.Builder<GetReplicationCycleRequest, ReplicationCycle>
        getReplicationCycleSettings() {
      return getReplicationCycleSettings;
    }

    /** Returns the builder for the settings used for calls to listImageImports. */
    public PagedCallSettings.Builder<
            ListImageImportsRequest, ListImageImportsResponse, ListImageImportsPagedResponse>
        listImageImportsSettings() {
      return listImageImportsSettings;
    }

    /** Returns the builder for the settings used for calls to getImageImport. */
    public UnaryCallSettings.Builder<GetImageImportRequest, ImageImport> getImageImportSettings() {
      return getImageImportSettings;
    }

    /** Returns the builder for the settings used for calls to createImageImport. */
    public UnaryCallSettings.Builder<CreateImageImportRequest, Operation>
        createImageImportSettings() {
      return createImageImportSettings;
    }

    /** Returns the builder for the settings used for calls to createImageImport. */
    public OperationCallSettings.Builder<CreateImageImportRequest, ImageImport, OperationMetadata>
        createImageImportOperationSettings() {
      return createImageImportOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteImageImport. */
    public UnaryCallSettings.Builder<DeleteImageImportRequest, Operation>
        deleteImageImportSettings() {
      return deleteImageImportSettings;
    }

    /** Returns the builder for the settings used for calls to deleteImageImport. */
    public OperationCallSettings.Builder<DeleteImageImportRequest, Empty, OperationMetadata>
        deleteImageImportOperationSettings() {
      return deleteImageImportOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listImageImportJobs. */
    public PagedCallSettings.Builder<
            ListImageImportJobsRequest,
            ListImageImportJobsResponse,
            ListImageImportJobsPagedResponse>
        listImageImportJobsSettings() {
      return listImageImportJobsSettings;
    }

    /** Returns the builder for the settings used for calls to getImageImportJob. */
    public UnaryCallSettings.Builder<GetImageImportJobRequest, ImageImportJob>
        getImageImportJobSettings() {
      return getImageImportJobSettings;
    }

    /** Returns the builder for the settings used for calls to cancelImageImportJob. */
    public UnaryCallSettings.Builder<CancelImageImportJobRequest, Operation>
        cancelImageImportJobSettings() {
      return cancelImageImportJobSettings;
    }

    /** Returns the builder for the settings used for calls to cancelImageImportJob. */
    public OperationCallSettings.Builder<
            CancelImageImportJobRequest, CancelImageImportJobResponse, OperationMetadata>
        cancelImageImportJobOperationSettings() {
      return cancelImageImportJobOperationSettings;
    }

    /** Returns the builder for the settings used for calls to createDiskMigrationJob. */
    public UnaryCallSettings.Builder<CreateDiskMigrationJobRequest, Operation>
        createDiskMigrationJobSettings() {
      return createDiskMigrationJobSettings;
    }

    /** Returns the builder for the settings used for calls to createDiskMigrationJob. */
    public OperationCallSettings.Builder<
            CreateDiskMigrationJobRequest, DiskMigrationJob, OperationMetadata>
        createDiskMigrationJobOperationSettings() {
      return createDiskMigrationJobOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listDiskMigrationJobs. */
    public PagedCallSettings.Builder<
            ListDiskMigrationJobsRequest,
            ListDiskMigrationJobsResponse,
            ListDiskMigrationJobsPagedResponse>
        listDiskMigrationJobsSettings() {
      return listDiskMigrationJobsSettings;
    }

    /** Returns the builder for the settings used for calls to getDiskMigrationJob. */
    public UnaryCallSettings.Builder<GetDiskMigrationJobRequest, DiskMigrationJob>
        getDiskMigrationJobSettings() {
      return getDiskMigrationJobSettings;
    }

    /** Returns the builder for the settings used for calls to updateDiskMigrationJob. */
    public UnaryCallSettings.Builder<UpdateDiskMigrationJobRequest, Operation>
        updateDiskMigrationJobSettings() {
      return updateDiskMigrationJobSettings;
    }

    /** Returns the builder for the settings used for calls to updateDiskMigrationJob. */
    public OperationCallSettings.Builder<
            UpdateDiskMigrationJobRequest, DiskMigrationJob, OperationMetadata>
        updateDiskMigrationJobOperationSettings() {
      return updateDiskMigrationJobOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteDiskMigrationJob. */
    public UnaryCallSettings.Builder<DeleteDiskMigrationJobRequest, Operation>
        deleteDiskMigrationJobSettings() {
      return deleteDiskMigrationJobSettings;
    }

    /** Returns the builder for the settings used for calls to deleteDiskMigrationJob. */
    public OperationCallSettings.Builder<DeleteDiskMigrationJobRequest, Empty, OperationMetadata>
        deleteDiskMigrationJobOperationSettings() {
      return deleteDiskMigrationJobOperationSettings;
    }

    /** Returns the builder for the settings used for calls to runDiskMigrationJob. */
    public UnaryCallSettings.Builder<RunDiskMigrationJobRequest, Operation>
        runDiskMigrationJobSettings() {
      return runDiskMigrationJobSettings;
    }

    /** Returns the builder for the settings used for calls to runDiskMigrationJob. */
    public OperationCallSettings.Builder<
            RunDiskMigrationJobRequest, RunDiskMigrationJobResponse, OperationMetadata>
        runDiskMigrationJobOperationSettings() {
      return runDiskMigrationJobOperationSettings;
    }

    /** Returns the builder for the settings used for calls to cancelDiskMigrationJob. */
    public UnaryCallSettings.Builder<CancelDiskMigrationJobRequest, Operation>
        cancelDiskMigrationJobSettings() {
      return cancelDiskMigrationJobSettings;
    }

    /** Returns the builder for the settings used for calls to cancelDiskMigrationJob. */
    public OperationCallSettings.Builder<
            CancelDiskMigrationJobRequest, CancelDiskMigrationJobResponse, OperationMetadata>
        cancelDiskMigrationJobOperationSettings() {
      return cancelDiskMigrationJobOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listLocations. */
    public PagedCallSettings.Builder<
            ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
        listLocationsSettings() {
      return listLocationsSettings;
    }

    /** Returns the builder for the settings used for calls to getLocation. */
    public UnaryCallSettings.Builder<GetLocationRequest, Location> getLocationSettings() {
      return getLocationSettings;
    }

    @Override
    public VmMigrationStubSettings build() throws IOException {
      return new VmMigrationStubSettings(this);
    }
  }
}
