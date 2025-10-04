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

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
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
import com.google.longrunning.Operation;
import com.google.longrunning.stub.OperationsStub;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the VmMigration service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class VmMigrationStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    return null;
  }

  public com.google.api.gax.httpjson.longrunning.stub.OperationsStub getHttpJsonOperationsStub() {
    return null;
  }

  public UnaryCallable<ListSourcesRequest, ListSourcesPagedResponse> listSourcesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listSourcesPagedCallable()");
  }

  public UnaryCallable<ListSourcesRequest, ListSourcesResponse> listSourcesCallable() {
    throw new UnsupportedOperationException("Not implemented: listSourcesCallable()");
  }

  public UnaryCallable<GetSourceRequest, Source> getSourceCallable() {
    throw new UnsupportedOperationException("Not implemented: getSourceCallable()");
  }

  public OperationCallable<CreateSourceRequest, Source, OperationMetadata>
      createSourceOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createSourceOperationCallable()");
  }

  public UnaryCallable<CreateSourceRequest, Operation> createSourceCallable() {
    throw new UnsupportedOperationException("Not implemented: createSourceCallable()");
  }

  public OperationCallable<UpdateSourceRequest, Source, OperationMetadata>
      updateSourceOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: updateSourceOperationCallable()");
  }

  public UnaryCallable<UpdateSourceRequest, Operation> updateSourceCallable() {
    throw new UnsupportedOperationException("Not implemented: updateSourceCallable()");
  }

  public OperationCallable<DeleteSourceRequest, Empty, OperationMetadata>
      deleteSourceOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteSourceOperationCallable()");
  }

  public UnaryCallable<DeleteSourceRequest, Operation> deleteSourceCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteSourceCallable()");
  }

  public UnaryCallable<FetchInventoryRequest, FetchInventoryResponse> fetchInventoryCallable() {
    throw new UnsupportedOperationException("Not implemented: fetchInventoryCallable()");
  }

  public UnaryCallable<FetchStorageInventoryRequest, FetchStorageInventoryPagedResponse>
      fetchStorageInventoryPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: fetchStorageInventoryPagedCallable()");
  }

  public UnaryCallable<FetchStorageInventoryRequest, FetchStorageInventoryResponse>
      fetchStorageInventoryCallable() {
    throw new UnsupportedOperationException("Not implemented: fetchStorageInventoryCallable()");
  }

  public UnaryCallable<ListUtilizationReportsRequest, ListUtilizationReportsPagedResponse>
      listUtilizationReportsPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listUtilizationReportsPagedCallable()");
  }

  public UnaryCallable<ListUtilizationReportsRequest, ListUtilizationReportsResponse>
      listUtilizationReportsCallable() {
    throw new UnsupportedOperationException("Not implemented: listUtilizationReportsCallable()");
  }

  public UnaryCallable<GetUtilizationReportRequest, UtilizationReport>
      getUtilizationReportCallable() {
    throw new UnsupportedOperationException("Not implemented: getUtilizationReportCallable()");
  }

  public OperationCallable<CreateUtilizationReportRequest, UtilizationReport, OperationMetadata>
      createUtilizationReportOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createUtilizationReportOperationCallable()");
  }

  public UnaryCallable<CreateUtilizationReportRequest, Operation>
      createUtilizationReportCallable() {
    throw new UnsupportedOperationException("Not implemented: createUtilizationReportCallable()");
  }

  public OperationCallable<DeleteUtilizationReportRequest, Empty, OperationMetadata>
      deleteUtilizationReportOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteUtilizationReportOperationCallable()");
  }

  public UnaryCallable<DeleteUtilizationReportRequest, Operation>
      deleteUtilizationReportCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteUtilizationReportCallable()");
  }

  public UnaryCallable<ListDatacenterConnectorsRequest, ListDatacenterConnectorsPagedResponse>
      listDatacenterConnectorsPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listDatacenterConnectorsPagedCallable()");
  }

  public UnaryCallable<ListDatacenterConnectorsRequest, ListDatacenterConnectorsResponse>
      listDatacenterConnectorsCallable() {
    throw new UnsupportedOperationException("Not implemented: listDatacenterConnectorsCallable()");
  }

  public UnaryCallable<GetDatacenterConnectorRequest, DatacenterConnector>
      getDatacenterConnectorCallable() {
    throw new UnsupportedOperationException("Not implemented: getDatacenterConnectorCallable()");
  }

  public OperationCallable<CreateDatacenterConnectorRequest, DatacenterConnector, OperationMetadata>
      createDatacenterConnectorOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createDatacenterConnectorOperationCallable()");
  }

  public UnaryCallable<CreateDatacenterConnectorRequest, Operation>
      createDatacenterConnectorCallable() {
    throw new UnsupportedOperationException("Not implemented: createDatacenterConnectorCallable()");
  }

  public OperationCallable<DeleteDatacenterConnectorRequest, Empty, OperationMetadata>
      deleteDatacenterConnectorOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteDatacenterConnectorOperationCallable()");
  }

  public UnaryCallable<DeleteDatacenterConnectorRequest, Operation>
      deleteDatacenterConnectorCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteDatacenterConnectorCallable()");
  }

  public OperationCallable<UpgradeApplianceRequest, UpgradeApplianceResponse, OperationMetadata>
      upgradeApplianceOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: upgradeApplianceOperationCallable()");
  }

  public UnaryCallable<UpgradeApplianceRequest, Operation> upgradeApplianceCallable() {
    throw new UnsupportedOperationException("Not implemented: upgradeApplianceCallable()");
  }

  public OperationCallable<CreateMigratingVmRequest, MigratingVm, OperationMetadata>
      createMigratingVmOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createMigratingVmOperationCallable()");
  }

  public UnaryCallable<CreateMigratingVmRequest, Operation> createMigratingVmCallable() {
    throw new UnsupportedOperationException("Not implemented: createMigratingVmCallable()");
  }

  public UnaryCallable<ListMigratingVmsRequest, ListMigratingVmsPagedResponse>
      listMigratingVmsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listMigratingVmsPagedCallable()");
  }

  public UnaryCallable<ListMigratingVmsRequest, ListMigratingVmsResponse>
      listMigratingVmsCallable() {
    throw new UnsupportedOperationException("Not implemented: listMigratingVmsCallable()");
  }

  public UnaryCallable<GetMigratingVmRequest, MigratingVm> getMigratingVmCallable() {
    throw new UnsupportedOperationException("Not implemented: getMigratingVmCallable()");
  }

  public OperationCallable<UpdateMigratingVmRequest, MigratingVm, OperationMetadata>
      updateMigratingVmOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateMigratingVmOperationCallable()");
  }

  public UnaryCallable<UpdateMigratingVmRequest, Operation> updateMigratingVmCallable() {
    throw new UnsupportedOperationException("Not implemented: updateMigratingVmCallable()");
  }

  public OperationCallable<DeleteMigratingVmRequest, Empty, OperationMetadata>
      deleteMigratingVmOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteMigratingVmOperationCallable()");
  }

  public UnaryCallable<DeleteMigratingVmRequest, Operation> deleteMigratingVmCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteMigratingVmCallable()");
  }

  public OperationCallable<StartMigrationRequest, StartMigrationResponse, OperationMetadata>
      startMigrationOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: startMigrationOperationCallable()");
  }

  public UnaryCallable<StartMigrationRequest, Operation> startMigrationCallable() {
    throw new UnsupportedOperationException("Not implemented: startMigrationCallable()");
  }

  public OperationCallable<ResumeMigrationRequest, ResumeMigrationResponse, OperationMetadata>
      resumeMigrationOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: resumeMigrationOperationCallable()");
  }

  public UnaryCallable<ResumeMigrationRequest, Operation> resumeMigrationCallable() {
    throw new UnsupportedOperationException("Not implemented: resumeMigrationCallable()");
  }

  public OperationCallable<PauseMigrationRequest, PauseMigrationResponse, OperationMetadata>
      pauseMigrationOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: pauseMigrationOperationCallable()");
  }

  public UnaryCallable<PauseMigrationRequest, Operation> pauseMigrationCallable() {
    throw new UnsupportedOperationException("Not implemented: pauseMigrationCallable()");
  }

  public OperationCallable<FinalizeMigrationRequest, FinalizeMigrationResponse, OperationMetadata>
      finalizeMigrationOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: finalizeMigrationOperationCallable()");
  }

  public UnaryCallable<FinalizeMigrationRequest, Operation> finalizeMigrationCallable() {
    throw new UnsupportedOperationException("Not implemented: finalizeMigrationCallable()");
  }

  public OperationCallable<ExtendMigrationRequest, ExtendMigrationResponse, OperationMetadata>
      extendMigrationOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: extendMigrationOperationCallable()");
  }

  public UnaryCallable<ExtendMigrationRequest, Operation> extendMigrationCallable() {
    throw new UnsupportedOperationException("Not implemented: extendMigrationCallable()");
  }

  public OperationCallable<CreateCloneJobRequest, CloneJob, OperationMetadata>
      createCloneJobOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createCloneJobOperationCallable()");
  }

  public UnaryCallable<CreateCloneJobRequest, Operation> createCloneJobCallable() {
    throw new UnsupportedOperationException("Not implemented: createCloneJobCallable()");
  }

  public OperationCallable<CancelCloneJobRequest, CancelCloneJobResponse, OperationMetadata>
      cancelCloneJobOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: cancelCloneJobOperationCallable()");
  }

  public UnaryCallable<CancelCloneJobRequest, Operation> cancelCloneJobCallable() {
    throw new UnsupportedOperationException("Not implemented: cancelCloneJobCallable()");
  }

  public UnaryCallable<ListCloneJobsRequest, ListCloneJobsPagedResponse>
      listCloneJobsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listCloneJobsPagedCallable()");
  }

  public UnaryCallable<ListCloneJobsRequest, ListCloneJobsResponse> listCloneJobsCallable() {
    throw new UnsupportedOperationException("Not implemented: listCloneJobsCallable()");
  }

  public UnaryCallable<GetCloneJobRequest, CloneJob> getCloneJobCallable() {
    throw new UnsupportedOperationException("Not implemented: getCloneJobCallable()");
  }

  public OperationCallable<CreateCutoverJobRequest, CutoverJob, OperationMetadata>
      createCutoverJobOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createCutoverJobOperationCallable()");
  }

  public UnaryCallable<CreateCutoverJobRequest, Operation> createCutoverJobCallable() {
    throw new UnsupportedOperationException("Not implemented: createCutoverJobCallable()");
  }

  public OperationCallable<CancelCutoverJobRequest, CancelCutoverJobResponse, OperationMetadata>
      cancelCutoverJobOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: cancelCutoverJobOperationCallable()");
  }

  public UnaryCallable<CancelCutoverJobRequest, Operation> cancelCutoverJobCallable() {
    throw new UnsupportedOperationException("Not implemented: cancelCutoverJobCallable()");
  }

  public UnaryCallable<ListCutoverJobsRequest, ListCutoverJobsPagedResponse>
      listCutoverJobsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listCutoverJobsPagedCallable()");
  }

  public UnaryCallable<ListCutoverJobsRequest, ListCutoverJobsResponse> listCutoverJobsCallable() {
    throw new UnsupportedOperationException("Not implemented: listCutoverJobsCallable()");
  }

  public UnaryCallable<GetCutoverJobRequest, CutoverJob> getCutoverJobCallable() {
    throw new UnsupportedOperationException("Not implemented: getCutoverJobCallable()");
  }

  public UnaryCallable<ListGroupsRequest, ListGroupsPagedResponse> listGroupsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listGroupsPagedCallable()");
  }

  public UnaryCallable<ListGroupsRequest, ListGroupsResponse> listGroupsCallable() {
    throw new UnsupportedOperationException("Not implemented: listGroupsCallable()");
  }

  public UnaryCallable<GetGroupRequest, Group> getGroupCallable() {
    throw new UnsupportedOperationException("Not implemented: getGroupCallable()");
  }

  public OperationCallable<CreateGroupRequest, Group, OperationMetadata>
      createGroupOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createGroupOperationCallable()");
  }

  public UnaryCallable<CreateGroupRequest, Operation> createGroupCallable() {
    throw new UnsupportedOperationException("Not implemented: createGroupCallable()");
  }

  public OperationCallable<UpdateGroupRequest, Group, OperationMetadata>
      updateGroupOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: updateGroupOperationCallable()");
  }

  public UnaryCallable<UpdateGroupRequest, Operation> updateGroupCallable() {
    throw new UnsupportedOperationException("Not implemented: updateGroupCallable()");
  }

  public OperationCallable<DeleteGroupRequest, Empty, OperationMetadata>
      deleteGroupOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteGroupOperationCallable()");
  }

  public UnaryCallable<DeleteGroupRequest, Operation> deleteGroupCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteGroupCallable()");
  }

  public OperationCallable<AddGroupMigrationRequest, AddGroupMigrationResponse, OperationMetadata>
      addGroupMigrationOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: addGroupMigrationOperationCallable()");
  }

  public UnaryCallable<AddGroupMigrationRequest, Operation> addGroupMigrationCallable() {
    throw new UnsupportedOperationException("Not implemented: addGroupMigrationCallable()");
  }

  public OperationCallable<
          RemoveGroupMigrationRequest, RemoveGroupMigrationResponse, OperationMetadata>
      removeGroupMigrationOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: removeGroupMigrationOperationCallable()");
  }

  public UnaryCallable<RemoveGroupMigrationRequest, Operation> removeGroupMigrationCallable() {
    throw new UnsupportedOperationException("Not implemented: removeGroupMigrationCallable()");
  }

  public UnaryCallable<ListTargetProjectsRequest, ListTargetProjectsPagedResponse>
      listTargetProjectsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listTargetProjectsPagedCallable()");
  }

  public UnaryCallable<ListTargetProjectsRequest, ListTargetProjectsResponse>
      listTargetProjectsCallable() {
    throw new UnsupportedOperationException("Not implemented: listTargetProjectsCallable()");
  }

  public UnaryCallable<GetTargetProjectRequest, TargetProject> getTargetProjectCallable() {
    throw new UnsupportedOperationException("Not implemented: getTargetProjectCallable()");
  }

  public OperationCallable<CreateTargetProjectRequest, TargetProject, OperationMetadata>
      createTargetProjectOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createTargetProjectOperationCallable()");
  }

  public UnaryCallable<CreateTargetProjectRequest, Operation> createTargetProjectCallable() {
    throw new UnsupportedOperationException("Not implemented: createTargetProjectCallable()");
  }

  public OperationCallable<UpdateTargetProjectRequest, TargetProject, OperationMetadata>
      updateTargetProjectOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateTargetProjectOperationCallable()");
  }

  public UnaryCallable<UpdateTargetProjectRequest, Operation> updateTargetProjectCallable() {
    throw new UnsupportedOperationException("Not implemented: updateTargetProjectCallable()");
  }

  public OperationCallable<DeleteTargetProjectRequest, Empty, OperationMetadata>
      deleteTargetProjectOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteTargetProjectOperationCallable()");
  }

  public UnaryCallable<DeleteTargetProjectRequest, Operation> deleteTargetProjectCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteTargetProjectCallable()");
  }

  public UnaryCallable<ListReplicationCyclesRequest, ListReplicationCyclesPagedResponse>
      listReplicationCyclesPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listReplicationCyclesPagedCallable()");
  }

  public UnaryCallable<ListReplicationCyclesRequest, ListReplicationCyclesResponse>
      listReplicationCyclesCallable() {
    throw new UnsupportedOperationException("Not implemented: listReplicationCyclesCallable()");
  }

  public UnaryCallable<GetReplicationCycleRequest, ReplicationCycle> getReplicationCycleCallable() {
    throw new UnsupportedOperationException("Not implemented: getReplicationCycleCallable()");
  }

  public UnaryCallable<ListImageImportsRequest, ListImageImportsPagedResponse>
      listImageImportsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listImageImportsPagedCallable()");
  }

  public UnaryCallable<ListImageImportsRequest, ListImageImportsResponse>
      listImageImportsCallable() {
    throw new UnsupportedOperationException("Not implemented: listImageImportsCallable()");
  }

  public UnaryCallable<GetImageImportRequest, ImageImport> getImageImportCallable() {
    throw new UnsupportedOperationException("Not implemented: getImageImportCallable()");
  }

  public OperationCallable<CreateImageImportRequest, ImageImport, OperationMetadata>
      createImageImportOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createImageImportOperationCallable()");
  }

  public UnaryCallable<CreateImageImportRequest, Operation> createImageImportCallable() {
    throw new UnsupportedOperationException("Not implemented: createImageImportCallable()");
  }

  public OperationCallable<DeleteImageImportRequest, Empty, OperationMetadata>
      deleteImageImportOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteImageImportOperationCallable()");
  }

  public UnaryCallable<DeleteImageImportRequest, Operation> deleteImageImportCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteImageImportCallable()");
  }

  public UnaryCallable<ListImageImportJobsRequest, ListImageImportJobsPagedResponse>
      listImageImportJobsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listImageImportJobsPagedCallable()");
  }

  public UnaryCallable<ListImageImportJobsRequest, ListImageImportJobsResponse>
      listImageImportJobsCallable() {
    throw new UnsupportedOperationException("Not implemented: listImageImportJobsCallable()");
  }

  public UnaryCallable<GetImageImportJobRequest, ImageImportJob> getImageImportJobCallable() {
    throw new UnsupportedOperationException("Not implemented: getImageImportJobCallable()");
  }

  public OperationCallable<
          CancelImageImportJobRequest, CancelImageImportJobResponse, OperationMetadata>
      cancelImageImportJobOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: cancelImageImportJobOperationCallable()");
  }

  public UnaryCallable<CancelImageImportJobRequest, Operation> cancelImageImportJobCallable() {
    throw new UnsupportedOperationException("Not implemented: cancelImageImportJobCallable()");
  }

  public OperationCallable<CreateDiskMigrationJobRequest, DiskMigrationJob, OperationMetadata>
      createDiskMigrationJobOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createDiskMigrationJobOperationCallable()");
  }

  public UnaryCallable<CreateDiskMigrationJobRequest, Operation> createDiskMigrationJobCallable() {
    throw new UnsupportedOperationException("Not implemented: createDiskMigrationJobCallable()");
  }

  public UnaryCallable<ListDiskMigrationJobsRequest, ListDiskMigrationJobsPagedResponse>
      listDiskMigrationJobsPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listDiskMigrationJobsPagedCallable()");
  }

  public UnaryCallable<ListDiskMigrationJobsRequest, ListDiskMigrationJobsResponse>
      listDiskMigrationJobsCallable() {
    throw new UnsupportedOperationException("Not implemented: listDiskMigrationJobsCallable()");
  }

  public UnaryCallable<GetDiskMigrationJobRequest, DiskMigrationJob> getDiskMigrationJobCallable() {
    throw new UnsupportedOperationException("Not implemented: getDiskMigrationJobCallable()");
  }

  public OperationCallable<UpdateDiskMigrationJobRequest, DiskMigrationJob, OperationMetadata>
      updateDiskMigrationJobOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateDiskMigrationJobOperationCallable()");
  }

  public UnaryCallable<UpdateDiskMigrationJobRequest, Operation> updateDiskMigrationJobCallable() {
    throw new UnsupportedOperationException("Not implemented: updateDiskMigrationJobCallable()");
  }

  public OperationCallable<DeleteDiskMigrationJobRequest, Empty, OperationMetadata>
      deleteDiskMigrationJobOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteDiskMigrationJobOperationCallable()");
  }

  public UnaryCallable<DeleteDiskMigrationJobRequest, Operation> deleteDiskMigrationJobCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteDiskMigrationJobCallable()");
  }

  public OperationCallable<
          RunDiskMigrationJobRequest, RunDiskMigrationJobResponse, OperationMetadata>
      runDiskMigrationJobOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: runDiskMigrationJobOperationCallable()");
  }

  public UnaryCallable<RunDiskMigrationJobRequest, Operation> runDiskMigrationJobCallable() {
    throw new UnsupportedOperationException("Not implemented: runDiskMigrationJobCallable()");
  }

  public OperationCallable<
          CancelDiskMigrationJobRequest, CancelDiskMigrationJobResponse, OperationMetadata>
      cancelDiskMigrationJobOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: cancelDiskMigrationJobOperationCallable()");
  }

  public UnaryCallable<CancelDiskMigrationJobRequest, Operation> cancelDiskMigrationJobCallable() {
    throw new UnsupportedOperationException("Not implemented: cancelDiskMigrationJobCallable()");
  }

  public UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listLocationsPagedCallable()");
  }

  public UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable() {
    throw new UnsupportedOperationException("Not implemented: listLocationsCallable()");
  }

  public UnaryCallable<GetLocationRequest, Location> getLocationCallable() {
    throw new UnsupportedOperationException("Not implemented: getLocationCallable()");
  }

  @Override
  public abstract void close();
}
