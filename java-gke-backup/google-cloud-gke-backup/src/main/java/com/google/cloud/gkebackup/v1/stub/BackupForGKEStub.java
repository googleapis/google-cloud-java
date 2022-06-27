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

package com.google.cloud.gkebackup.v1.stub;

import static com.google.cloud.gkebackup.v1.BackupForGKEClient.ListBackupPlansPagedResponse;
import static com.google.cloud.gkebackup.v1.BackupForGKEClient.ListBackupsPagedResponse;
import static com.google.cloud.gkebackup.v1.BackupForGKEClient.ListRestorePlansPagedResponse;
import static com.google.cloud.gkebackup.v1.BackupForGKEClient.ListRestoresPagedResponse;
import static com.google.cloud.gkebackup.v1.BackupForGKEClient.ListVolumeBackupsPagedResponse;
import static com.google.cloud.gkebackup.v1.BackupForGKEClient.ListVolumeRestoresPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.gkebackup.v1.Backup;
import com.google.cloud.gkebackup.v1.BackupPlan;
import com.google.cloud.gkebackup.v1.CreateBackupPlanRequest;
import com.google.cloud.gkebackup.v1.CreateBackupRequest;
import com.google.cloud.gkebackup.v1.CreateRestorePlanRequest;
import com.google.cloud.gkebackup.v1.CreateRestoreRequest;
import com.google.cloud.gkebackup.v1.DeleteBackupPlanRequest;
import com.google.cloud.gkebackup.v1.DeleteBackupRequest;
import com.google.cloud.gkebackup.v1.DeleteRestorePlanRequest;
import com.google.cloud.gkebackup.v1.DeleteRestoreRequest;
import com.google.cloud.gkebackup.v1.GetBackupPlanRequest;
import com.google.cloud.gkebackup.v1.GetBackupRequest;
import com.google.cloud.gkebackup.v1.GetRestorePlanRequest;
import com.google.cloud.gkebackup.v1.GetRestoreRequest;
import com.google.cloud.gkebackup.v1.GetVolumeBackupRequest;
import com.google.cloud.gkebackup.v1.GetVolumeRestoreRequest;
import com.google.cloud.gkebackup.v1.ListBackupPlansRequest;
import com.google.cloud.gkebackup.v1.ListBackupPlansResponse;
import com.google.cloud.gkebackup.v1.ListBackupsRequest;
import com.google.cloud.gkebackup.v1.ListBackupsResponse;
import com.google.cloud.gkebackup.v1.ListRestorePlansRequest;
import com.google.cloud.gkebackup.v1.ListRestorePlansResponse;
import com.google.cloud.gkebackup.v1.ListRestoresRequest;
import com.google.cloud.gkebackup.v1.ListRestoresResponse;
import com.google.cloud.gkebackup.v1.ListVolumeBackupsRequest;
import com.google.cloud.gkebackup.v1.ListVolumeBackupsResponse;
import com.google.cloud.gkebackup.v1.ListVolumeRestoresRequest;
import com.google.cloud.gkebackup.v1.ListVolumeRestoresResponse;
import com.google.cloud.gkebackup.v1.OperationMetadata;
import com.google.cloud.gkebackup.v1.Restore;
import com.google.cloud.gkebackup.v1.RestorePlan;
import com.google.cloud.gkebackup.v1.UpdateBackupPlanRequest;
import com.google.cloud.gkebackup.v1.UpdateBackupRequest;
import com.google.cloud.gkebackup.v1.UpdateRestorePlanRequest;
import com.google.cloud.gkebackup.v1.UpdateRestoreRequest;
import com.google.cloud.gkebackup.v1.VolumeBackup;
import com.google.cloud.gkebackup.v1.VolumeRestore;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.OperationsStub;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the BackupForGKE service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class BackupForGKEStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    return null;
  }

  public com.google.api.gax.httpjson.longrunning.stub.OperationsStub getHttpJsonOperationsStub() {
    return null;
  }

  public OperationCallable<CreateBackupPlanRequest, BackupPlan, OperationMetadata>
      createBackupPlanOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createBackupPlanOperationCallable()");
  }

  public UnaryCallable<CreateBackupPlanRequest, Operation> createBackupPlanCallable() {
    throw new UnsupportedOperationException("Not implemented: createBackupPlanCallable()");
  }

  public UnaryCallable<ListBackupPlansRequest, ListBackupPlansPagedResponse>
      listBackupPlansPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listBackupPlansPagedCallable()");
  }

  public UnaryCallable<ListBackupPlansRequest, ListBackupPlansResponse> listBackupPlansCallable() {
    throw new UnsupportedOperationException("Not implemented: listBackupPlansCallable()");
  }

  public UnaryCallable<GetBackupPlanRequest, BackupPlan> getBackupPlanCallable() {
    throw new UnsupportedOperationException("Not implemented: getBackupPlanCallable()");
  }

  public OperationCallable<UpdateBackupPlanRequest, BackupPlan, OperationMetadata>
      updateBackupPlanOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: updateBackupPlanOperationCallable()");
  }

  public UnaryCallable<UpdateBackupPlanRequest, Operation> updateBackupPlanCallable() {
    throw new UnsupportedOperationException("Not implemented: updateBackupPlanCallable()");
  }

  public OperationCallable<DeleteBackupPlanRequest, Empty, OperationMetadata>
      deleteBackupPlanOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteBackupPlanOperationCallable()");
  }

  public UnaryCallable<DeleteBackupPlanRequest, Operation> deleteBackupPlanCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteBackupPlanCallable()");
  }

  public OperationCallable<CreateBackupRequest, Backup, OperationMetadata>
      createBackupOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createBackupOperationCallable()");
  }

  public UnaryCallable<CreateBackupRequest, Operation> createBackupCallable() {
    throw new UnsupportedOperationException("Not implemented: createBackupCallable()");
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

  public OperationCallable<DeleteBackupRequest, Empty, OperationMetadata>
      deleteBackupOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteBackupOperationCallable()");
  }

  public UnaryCallable<DeleteBackupRequest, Operation> deleteBackupCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteBackupCallable()");
  }

  public UnaryCallable<ListVolumeBackupsRequest, ListVolumeBackupsPagedResponse>
      listVolumeBackupsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listVolumeBackupsPagedCallable()");
  }

  public UnaryCallable<ListVolumeBackupsRequest, ListVolumeBackupsResponse>
      listVolumeBackupsCallable() {
    throw new UnsupportedOperationException("Not implemented: listVolumeBackupsCallable()");
  }

  public UnaryCallable<GetVolumeBackupRequest, VolumeBackup> getVolumeBackupCallable() {
    throw new UnsupportedOperationException("Not implemented: getVolumeBackupCallable()");
  }

  public OperationCallable<CreateRestorePlanRequest, RestorePlan, OperationMetadata>
      createRestorePlanOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createRestorePlanOperationCallable()");
  }

  public UnaryCallable<CreateRestorePlanRequest, Operation> createRestorePlanCallable() {
    throw new UnsupportedOperationException("Not implemented: createRestorePlanCallable()");
  }

  public UnaryCallable<ListRestorePlansRequest, ListRestorePlansPagedResponse>
      listRestorePlansPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listRestorePlansPagedCallable()");
  }

  public UnaryCallable<ListRestorePlansRequest, ListRestorePlansResponse>
      listRestorePlansCallable() {
    throw new UnsupportedOperationException("Not implemented: listRestorePlansCallable()");
  }

  public UnaryCallable<GetRestorePlanRequest, RestorePlan> getRestorePlanCallable() {
    throw new UnsupportedOperationException("Not implemented: getRestorePlanCallable()");
  }

  public OperationCallable<UpdateRestorePlanRequest, RestorePlan, OperationMetadata>
      updateRestorePlanOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateRestorePlanOperationCallable()");
  }

  public UnaryCallable<UpdateRestorePlanRequest, Operation> updateRestorePlanCallable() {
    throw new UnsupportedOperationException("Not implemented: updateRestorePlanCallable()");
  }

  public OperationCallable<DeleteRestorePlanRequest, Empty, OperationMetadata>
      deleteRestorePlanOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteRestorePlanOperationCallable()");
  }

  public UnaryCallable<DeleteRestorePlanRequest, Operation> deleteRestorePlanCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteRestorePlanCallable()");
  }

  public OperationCallable<CreateRestoreRequest, Restore, OperationMetadata>
      createRestoreOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createRestoreOperationCallable()");
  }

  public UnaryCallable<CreateRestoreRequest, Operation> createRestoreCallable() {
    throw new UnsupportedOperationException("Not implemented: createRestoreCallable()");
  }

  public UnaryCallable<ListRestoresRequest, ListRestoresPagedResponse> listRestoresPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listRestoresPagedCallable()");
  }

  public UnaryCallable<ListRestoresRequest, ListRestoresResponse> listRestoresCallable() {
    throw new UnsupportedOperationException("Not implemented: listRestoresCallable()");
  }

  public UnaryCallable<GetRestoreRequest, Restore> getRestoreCallable() {
    throw new UnsupportedOperationException("Not implemented: getRestoreCallable()");
  }

  public OperationCallable<UpdateRestoreRequest, Restore, OperationMetadata>
      updateRestoreOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: updateRestoreOperationCallable()");
  }

  public UnaryCallable<UpdateRestoreRequest, Operation> updateRestoreCallable() {
    throw new UnsupportedOperationException("Not implemented: updateRestoreCallable()");
  }

  public OperationCallable<DeleteRestoreRequest, Empty, OperationMetadata>
      deleteRestoreOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteRestoreOperationCallable()");
  }

  public UnaryCallable<DeleteRestoreRequest, Operation> deleteRestoreCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteRestoreCallable()");
  }

  public UnaryCallable<ListVolumeRestoresRequest, ListVolumeRestoresPagedResponse>
      listVolumeRestoresPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listVolumeRestoresPagedCallable()");
  }

  public UnaryCallable<ListVolumeRestoresRequest, ListVolumeRestoresResponse>
      listVolumeRestoresCallable() {
    throw new UnsupportedOperationException("Not implemented: listVolumeRestoresCallable()");
  }

  public UnaryCallable<GetVolumeRestoreRequest, VolumeRestore> getVolumeRestoreCallable() {
    throw new UnsupportedOperationException("Not implemented: getVolumeRestoreCallable()");
  }

  @Override
  public abstract void close();
}
