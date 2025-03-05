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

package com.google.cloud.filestore.v1.stub;

import static com.google.cloud.filestore.v1.CloudFilestoreManagerClient.ListBackupsPagedResponse;
import static com.google.cloud.filestore.v1.CloudFilestoreManagerClient.ListInstancesPagedResponse;
import static com.google.cloud.filestore.v1.CloudFilestoreManagerClient.ListSnapshotsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.common.OperationMetadata;
import com.google.cloud.filestore.v1.Backup;
import com.google.cloud.filestore.v1.CreateBackupRequest;
import com.google.cloud.filestore.v1.CreateInstanceRequest;
import com.google.cloud.filestore.v1.CreateSnapshotRequest;
import com.google.cloud.filestore.v1.DeleteBackupRequest;
import com.google.cloud.filestore.v1.DeleteInstanceRequest;
import com.google.cloud.filestore.v1.DeleteSnapshotRequest;
import com.google.cloud.filestore.v1.GetBackupRequest;
import com.google.cloud.filestore.v1.GetInstanceRequest;
import com.google.cloud.filestore.v1.GetSnapshotRequest;
import com.google.cloud.filestore.v1.Instance;
import com.google.cloud.filestore.v1.ListBackupsRequest;
import com.google.cloud.filestore.v1.ListBackupsResponse;
import com.google.cloud.filestore.v1.ListInstancesRequest;
import com.google.cloud.filestore.v1.ListInstancesResponse;
import com.google.cloud.filestore.v1.ListSnapshotsRequest;
import com.google.cloud.filestore.v1.ListSnapshotsResponse;
import com.google.cloud.filestore.v1.PromoteReplicaRequest;
import com.google.cloud.filestore.v1.RestoreInstanceRequest;
import com.google.cloud.filestore.v1.RevertInstanceRequest;
import com.google.cloud.filestore.v1.Snapshot;
import com.google.cloud.filestore.v1.UpdateBackupRequest;
import com.google.cloud.filestore.v1.UpdateInstanceRequest;
import com.google.cloud.filestore.v1.UpdateSnapshotRequest;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.OperationsStub;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the CloudFilestoreManager service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class CloudFilestoreManagerStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    return null;
  }

  public com.google.api.gax.httpjson.longrunning.stub.OperationsStub getHttpJsonOperationsStub() {
    return null;
  }

  public UnaryCallable<ListInstancesRequest, ListInstancesPagedResponse>
      listInstancesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listInstancesPagedCallable()");
  }

  public UnaryCallable<ListInstancesRequest, ListInstancesResponse> listInstancesCallable() {
    throw new UnsupportedOperationException("Not implemented: listInstancesCallable()");
  }

  public UnaryCallable<GetInstanceRequest, Instance> getInstanceCallable() {
    throw new UnsupportedOperationException("Not implemented: getInstanceCallable()");
  }

  public OperationCallable<CreateInstanceRequest, Instance, OperationMetadata>
      createInstanceOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createInstanceOperationCallable()");
  }

  public UnaryCallable<CreateInstanceRequest, Operation> createInstanceCallable() {
    throw new UnsupportedOperationException("Not implemented: createInstanceCallable()");
  }

  public OperationCallable<UpdateInstanceRequest, Instance, OperationMetadata>
      updateInstanceOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: updateInstanceOperationCallable()");
  }

  public UnaryCallable<UpdateInstanceRequest, Operation> updateInstanceCallable() {
    throw new UnsupportedOperationException("Not implemented: updateInstanceCallable()");
  }

  public OperationCallable<RestoreInstanceRequest, Instance, OperationMetadata>
      restoreInstanceOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: restoreInstanceOperationCallable()");
  }

  public UnaryCallable<RestoreInstanceRequest, Operation> restoreInstanceCallable() {
    throw new UnsupportedOperationException("Not implemented: restoreInstanceCallable()");
  }

  public OperationCallable<RevertInstanceRequest, Instance, OperationMetadata>
      revertInstanceOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: revertInstanceOperationCallable()");
  }

  public UnaryCallable<RevertInstanceRequest, Operation> revertInstanceCallable() {
    throw new UnsupportedOperationException("Not implemented: revertInstanceCallable()");
  }

  public OperationCallable<DeleteInstanceRequest, Empty, OperationMetadata>
      deleteInstanceOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteInstanceOperationCallable()");
  }

  public UnaryCallable<DeleteInstanceRequest, Operation> deleteInstanceCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteInstanceCallable()");
  }

  public UnaryCallable<ListSnapshotsRequest, ListSnapshotsPagedResponse>
      listSnapshotsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listSnapshotsPagedCallable()");
  }

  public UnaryCallable<ListSnapshotsRequest, ListSnapshotsResponse> listSnapshotsCallable() {
    throw new UnsupportedOperationException("Not implemented: listSnapshotsCallable()");
  }

  public UnaryCallable<GetSnapshotRequest, Snapshot> getSnapshotCallable() {
    throw new UnsupportedOperationException("Not implemented: getSnapshotCallable()");
  }

  public OperationCallable<CreateSnapshotRequest, Snapshot, OperationMetadata>
      createSnapshotOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createSnapshotOperationCallable()");
  }

  public UnaryCallable<CreateSnapshotRequest, Operation> createSnapshotCallable() {
    throw new UnsupportedOperationException("Not implemented: createSnapshotCallable()");
  }

  public OperationCallable<DeleteSnapshotRequest, Empty, OperationMetadata>
      deleteSnapshotOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteSnapshotOperationCallable()");
  }

  public UnaryCallable<DeleteSnapshotRequest, Operation> deleteSnapshotCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteSnapshotCallable()");
  }

  public OperationCallable<UpdateSnapshotRequest, Snapshot, OperationMetadata>
      updateSnapshotOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: updateSnapshotOperationCallable()");
  }

  public UnaryCallable<UpdateSnapshotRequest, Operation> updateSnapshotCallable() {
    throw new UnsupportedOperationException("Not implemented: updateSnapshotCallable()");
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

  public OperationCallable<CreateBackupRequest, Backup, OperationMetadata>
      createBackupOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createBackupOperationCallable()");
  }

  public UnaryCallable<CreateBackupRequest, Operation> createBackupCallable() {
    throw new UnsupportedOperationException("Not implemented: createBackupCallable()");
  }

  public OperationCallable<DeleteBackupRequest, Empty, OperationMetadata>
      deleteBackupOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteBackupOperationCallable()");
  }

  public UnaryCallable<DeleteBackupRequest, Operation> deleteBackupCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteBackupCallable()");
  }

  public OperationCallable<UpdateBackupRequest, Backup, OperationMetadata>
      updateBackupOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: updateBackupOperationCallable()");
  }

  public UnaryCallable<UpdateBackupRequest, Operation> updateBackupCallable() {
    throw new UnsupportedOperationException("Not implemented: updateBackupCallable()");
  }

  public OperationCallable<PromoteReplicaRequest, Instance, OperationMetadata>
      promoteReplicaOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: promoteReplicaOperationCallable()");
  }

  public UnaryCallable<PromoteReplicaRequest, Operation> promoteReplicaCallable() {
    throw new UnsupportedOperationException("Not implemented: promoteReplicaCallable()");
  }

  @Override
  public abstract void close();
}
