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

package com.google.cloud.backupdr.v1.stub;

import static com.google.cloud.backupdr.v1.BackupDRClient.FetchUsableBackupVaultsPagedResponse;
import static com.google.cloud.backupdr.v1.BackupDRClient.ListBackupPlanAssociationsPagedResponse;
import static com.google.cloud.backupdr.v1.BackupDRClient.ListBackupPlansPagedResponse;
import static com.google.cloud.backupdr.v1.BackupDRClient.ListBackupVaultsPagedResponse;
import static com.google.cloud.backupdr.v1.BackupDRClient.ListBackupsPagedResponse;
import static com.google.cloud.backupdr.v1.BackupDRClient.ListDataSourcesPagedResponse;
import static com.google.cloud.backupdr.v1.BackupDRClient.ListLocationsPagedResponse;
import static com.google.cloud.backupdr.v1.BackupDRClient.ListManagementServersPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.backupdr.v1.Backup;
import com.google.cloud.backupdr.v1.BackupPlan;
import com.google.cloud.backupdr.v1.BackupPlanAssociation;
import com.google.cloud.backupdr.v1.BackupVault;
import com.google.cloud.backupdr.v1.CreateBackupPlanAssociationRequest;
import com.google.cloud.backupdr.v1.CreateBackupPlanRequest;
import com.google.cloud.backupdr.v1.CreateBackupVaultRequest;
import com.google.cloud.backupdr.v1.CreateManagementServerRequest;
import com.google.cloud.backupdr.v1.DataSource;
import com.google.cloud.backupdr.v1.DeleteBackupPlanAssociationRequest;
import com.google.cloud.backupdr.v1.DeleteBackupPlanRequest;
import com.google.cloud.backupdr.v1.DeleteBackupRequest;
import com.google.cloud.backupdr.v1.DeleteBackupVaultRequest;
import com.google.cloud.backupdr.v1.DeleteManagementServerRequest;
import com.google.cloud.backupdr.v1.FetchUsableBackupVaultsRequest;
import com.google.cloud.backupdr.v1.FetchUsableBackupVaultsResponse;
import com.google.cloud.backupdr.v1.GetBackupPlanAssociationRequest;
import com.google.cloud.backupdr.v1.GetBackupPlanRequest;
import com.google.cloud.backupdr.v1.GetBackupRequest;
import com.google.cloud.backupdr.v1.GetBackupVaultRequest;
import com.google.cloud.backupdr.v1.GetDataSourceRequest;
import com.google.cloud.backupdr.v1.GetManagementServerRequest;
import com.google.cloud.backupdr.v1.ListBackupPlanAssociationsRequest;
import com.google.cloud.backupdr.v1.ListBackupPlanAssociationsResponse;
import com.google.cloud.backupdr.v1.ListBackupPlansRequest;
import com.google.cloud.backupdr.v1.ListBackupPlansResponse;
import com.google.cloud.backupdr.v1.ListBackupVaultsRequest;
import com.google.cloud.backupdr.v1.ListBackupVaultsResponse;
import com.google.cloud.backupdr.v1.ListBackupsRequest;
import com.google.cloud.backupdr.v1.ListBackupsResponse;
import com.google.cloud.backupdr.v1.ListDataSourcesRequest;
import com.google.cloud.backupdr.v1.ListDataSourcesResponse;
import com.google.cloud.backupdr.v1.ListManagementServersRequest;
import com.google.cloud.backupdr.v1.ListManagementServersResponse;
import com.google.cloud.backupdr.v1.ManagementServer;
import com.google.cloud.backupdr.v1.OperationMetadata;
import com.google.cloud.backupdr.v1.RestoreBackupRequest;
import com.google.cloud.backupdr.v1.RestoreBackupResponse;
import com.google.cloud.backupdr.v1.TriggerBackupRequest;
import com.google.cloud.backupdr.v1.UpdateBackupRequest;
import com.google.cloud.backupdr.v1.UpdateBackupVaultRequest;
import com.google.cloud.backupdr.v1.UpdateDataSourceRequest;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.OperationsStub;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the BackupDR service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class BackupDRStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    return null;
  }

  public com.google.api.gax.httpjson.longrunning.stub.OperationsStub getHttpJsonOperationsStub() {
    return null;
  }

  public UnaryCallable<ListManagementServersRequest, ListManagementServersPagedResponse>
      listManagementServersPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listManagementServersPagedCallable()");
  }

  public UnaryCallable<ListManagementServersRequest, ListManagementServersResponse>
      listManagementServersCallable() {
    throw new UnsupportedOperationException("Not implemented: listManagementServersCallable()");
  }

  public UnaryCallable<GetManagementServerRequest, ManagementServer> getManagementServerCallable() {
    throw new UnsupportedOperationException("Not implemented: getManagementServerCallable()");
  }

  public OperationCallable<CreateManagementServerRequest, ManagementServer, OperationMetadata>
      createManagementServerOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createManagementServerOperationCallable()");
  }

  public UnaryCallable<CreateManagementServerRequest, Operation> createManagementServerCallable() {
    throw new UnsupportedOperationException("Not implemented: createManagementServerCallable()");
  }

  public OperationCallable<DeleteManagementServerRequest, Empty, OperationMetadata>
      deleteManagementServerOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteManagementServerOperationCallable()");
  }

  public UnaryCallable<DeleteManagementServerRequest, Operation> deleteManagementServerCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteManagementServerCallable()");
  }

  public OperationCallable<CreateBackupVaultRequest, BackupVault, OperationMetadata>
      createBackupVaultOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createBackupVaultOperationCallable()");
  }

  public UnaryCallable<CreateBackupVaultRequest, Operation> createBackupVaultCallable() {
    throw new UnsupportedOperationException("Not implemented: createBackupVaultCallable()");
  }

  public UnaryCallable<ListBackupVaultsRequest, ListBackupVaultsPagedResponse>
      listBackupVaultsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listBackupVaultsPagedCallable()");
  }

  public UnaryCallable<ListBackupVaultsRequest, ListBackupVaultsResponse>
      listBackupVaultsCallable() {
    throw new UnsupportedOperationException("Not implemented: listBackupVaultsCallable()");
  }

  public UnaryCallable<FetchUsableBackupVaultsRequest, FetchUsableBackupVaultsPagedResponse>
      fetchUsableBackupVaultsPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: fetchUsableBackupVaultsPagedCallable()");
  }

  public UnaryCallable<FetchUsableBackupVaultsRequest, FetchUsableBackupVaultsResponse>
      fetchUsableBackupVaultsCallable() {
    throw new UnsupportedOperationException("Not implemented: fetchUsableBackupVaultsCallable()");
  }

  public UnaryCallable<GetBackupVaultRequest, BackupVault> getBackupVaultCallable() {
    throw new UnsupportedOperationException("Not implemented: getBackupVaultCallable()");
  }

  public OperationCallable<UpdateBackupVaultRequest, BackupVault, OperationMetadata>
      updateBackupVaultOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateBackupVaultOperationCallable()");
  }

  public UnaryCallable<UpdateBackupVaultRequest, Operation> updateBackupVaultCallable() {
    throw new UnsupportedOperationException("Not implemented: updateBackupVaultCallable()");
  }

  public OperationCallable<DeleteBackupVaultRequest, Empty, OperationMetadata>
      deleteBackupVaultOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteBackupVaultOperationCallable()");
  }

  public UnaryCallable<DeleteBackupVaultRequest, Operation> deleteBackupVaultCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteBackupVaultCallable()");
  }

  public UnaryCallable<ListDataSourcesRequest, ListDataSourcesPagedResponse>
      listDataSourcesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listDataSourcesPagedCallable()");
  }

  public UnaryCallable<ListDataSourcesRequest, ListDataSourcesResponse> listDataSourcesCallable() {
    throw new UnsupportedOperationException("Not implemented: listDataSourcesCallable()");
  }

  public UnaryCallable<GetDataSourceRequest, DataSource> getDataSourceCallable() {
    throw new UnsupportedOperationException("Not implemented: getDataSourceCallable()");
  }

  public OperationCallable<UpdateDataSourceRequest, DataSource, OperationMetadata>
      updateDataSourceOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: updateDataSourceOperationCallable()");
  }

  public UnaryCallable<UpdateDataSourceRequest, Operation> updateDataSourceCallable() {
    throw new UnsupportedOperationException("Not implemented: updateDataSourceCallable()");
  }

  public UnaryCallable<ListBackupsRequest, ListBackupsPagedResponse> listBackupsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listBackupsPagedCallable()");
  }

  public UnaryCallable<ListBackupsRequest, ListBackupsResponse> listBackupsCallable() {
    throw new UnsupportedOperationException("Not implemented: listBackupsCallable()");
  }

  public UnaryCallable<GetBackupRequest, Backup> getBackupCallable() {
    throw new UnsupportedOperationException("Not implemented: getBackupCallable()");
  }

  public OperationCallable<UpdateBackupRequest, Backup, OperationMetadata>
      updateBackupOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: updateBackupOperationCallable()");
  }

  public UnaryCallable<UpdateBackupRequest, Operation> updateBackupCallable() {
    throw new UnsupportedOperationException("Not implemented: updateBackupCallable()");
  }

  public OperationCallable<DeleteBackupRequest, Backup, OperationMetadata>
      deleteBackupOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteBackupOperationCallable()");
  }

  public UnaryCallable<DeleteBackupRequest, Operation> deleteBackupCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteBackupCallable()");
  }

  public OperationCallable<RestoreBackupRequest, RestoreBackupResponse, OperationMetadata>
      restoreBackupOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: restoreBackupOperationCallable()");
  }

  public UnaryCallable<RestoreBackupRequest, Operation> restoreBackupCallable() {
    throw new UnsupportedOperationException("Not implemented: restoreBackupCallable()");
  }

  public OperationCallable<CreateBackupPlanRequest, BackupPlan, OperationMetadata>
      createBackupPlanOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createBackupPlanOperationCallable()");
  }

  public UnaryCallable<CreateBackupPlanRequest, Operation> createBackupPlanCallable() {
    throw new UnsupportedOperationException("Not implemented: createBackupPlanCallable()");
  }

  public UnaryCallable<GetBackupPlanRequest, BackupPlan> getBackupPlanCallable() {
    throw new UnsupportedOperationException("Not implemented: getBackupPlanCallable()");
  }

  public UnaryCallable<ListBackupPlansRequest, ListBackupPlansPagedResponse>
      listBackupPlansPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listBackupPlansPagedCallable()");
  }

  public UnaryCallable<ListBackupPlansRequest, ListBackupPlansResponse> listBackupPlansCallable() {
    throw new UnsupportedOperationException("Not implemented: listBackupPlansCallable()");
  }

  public OperationCallable<DeleteBackupPlanRequest, Empty, OperationMetadata>
      deleteBackupPlanOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteBackupPlanOperationCallable()");
  }

  public UnaryCallable<DeleteBackupPlanRequest, Operation> deleteBackupPlanCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteBackupPlanCallable()");
  }

  public OperationCallable<
          CreateBackupPlanAssociationRequest, BackupPlanAssociation, OperationMetadata>
      createBackupPlanAssociationOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createBackupPlanAssociationOperationCallable()");
  }

  public UnaryCallable<CreateBackupPlanAssociationRequest, Operation>
      createBackupPlanAssociationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createBackupPlanAssociationCallable()");
  }

  public UnaryCallable<GetBackupPlanAssociationRequest, BackupPlanAssociation>
      getBackupPlanAssociationCallable() {
    throw new UnsupportedOperationException("Not implemented: getBackupPlanAssociationCallable()");
  }

  public UnaryCallable<ListBackupPlanAssociationsRequest, ListBackupPlanAssociationsPagedResponse>
      listBackupPlanAssociationsPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listBackupPlanAssociationsPagedCallable()");
  }

  public UnaryCallable<ListBackupPlanAssociationsRequest, ListBackupPlanAssociationsResponse>
      listBackupPlanAssociationsCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listBackupPlanAssociationsCallable()");
  }

  public OperationCallable<DeleteBackupPlanAssociationRequest, Empty, OperationMetadata>
      deleteBackupPlanAssociationOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteBackupPlanAssociationOperationCallable()");
  }

  public UnaryCallable<DeleteBackupPlanAssociationRequest, Operation>
      deleteBackupPlanAssociationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteBackupPlanAssociationCallable()");
  }

  public OperationCallable<TriggerBackupRequest, BackupPlanAssociation, OperationMetadata>
      triggerBackupOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: triggerBackupOperationCallable()");
  }

  public UnaryCallable<TriggerBackupRequest, Operation> triggerBackupCallable() {
    throw new UnsupportedOperationException("Not implemented: triggerBackupCallable()");
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

  public UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: setIamPolicyCallable()");
  }

  public UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: getIamPolicyCallable()");
  }

  public UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable() {
    throw new UnsupportedOperationException("Not implemented: testIamPermissionsCallable()");
  }

  @Override
  public abstract void close();
}
