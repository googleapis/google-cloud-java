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

package com.google.cloud.memorystore.v1.stub;

import static com.google.cloud.memorystore.v1.MemorystoreClient.ListBackupCollectionsPagedResponse;
import static com.google.cloud.memorystore.v1.MemorystoreClient.ListBackupsPagedResponse;
import static com.google.cloud.memorystore.v1.MemorystoreClient.ListInstancesPagedResponse;
import static com.google.cloud.memorystore.v1.MemorystoreClient.ListLocationsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.httpjson.longrunning.stub.OperationsStub;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.cloud.memorystore.v1.Backup;
import com.google.cloud.memorystore.v1.BackupCollection;
import com.google.cloud.memorystore.v1.BackupInstanceRequest;
import com.google.cloud.memorystore.v1.CertificateAuthority;
import com.google.cloud.memorystore.v1.CreateInstanceRequest;
import com.google.cloud.memorystore.v1.DeleteBackupRequest;
import com.google.cloud.memorystore.v1.DeleteInstanceRequest;
import com.google.cloud.memorystore.v1.ExportBackupRequest;
import com.google.cloud.memorystore.v1.GetBackupCollectionRequest;
import com.google.cloud.memorystore.v1.GetBackupRequest;
import com.google.cloud.memorystore.v1.GetCertificateAuthorityRequest;
import com.google.cloud.memorystore.v1.GetInstanceRequest;
import com.google.cloud.memorystore.v1.Instance;
import com.google.cloud.memorystore.v1.ListBackupCollectionsRequest;
import com.google.cloud.memorystore.v1.ListBackupCollectionsResponse;
import com.google.cloud.memorystore.v1.ListBackupsRequest;
import com.google.cloud.memorystore.v1.ListBackupsResponse;
import com.google.cloud.memorystore.v1.ListInstancesRequest;
import com.google.cloud.memorystore.v1.ListInstancesResponse;
import com.google.cloud.memorystore.v1.OperationMetadata;
import com.google.cloud.memorystore.v1.RescheduleMaintenanceRequest;
import com.google.cloud.memorystore.v1.UpdateInstanceRequest;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the Memorystore service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class MemorystoreStub implements BackgroundResource {

  public OperationsStub getHttpJsonOperationsStub() {
    throw new UnsupportedOperationException("Not implemented: getHttpJsonOperationsStub()");
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

  public OperationCallable<DeleteInstanceRequest, Empty, OperationMetadata>
      deleteInstanceOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteInstanceOperationCallable()");
  }

  public UnaryCallable<DeleteInstanceRequest, Operation> deleteInstanceCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteInstanceCallable()");
  }

  public UnaryCallable<GetCertificateAuthorityRequest, CertificateAuthority>
      getCertificateAuthorityCallable() {
    throw new UnsupportedOperationException("Not implemented: getCertificateAuthorityCallable()");
  }

  public OperationCallable<RescheduleMaintenanceRequest, Instance, OperationMetadata>
      rescheduleMaintenanceOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: rescheduleMaintenanceOperationCallable()");
  }

  public UnaryCallable<RescheduleMaintenanceRequest, Operation> rescheduleMaintenanceCallable() {
    throw new UnsupportedOperationException("Not implemented: rescheduleMaintenanceCallable()");
  }

  public UnaryCallable<ListBackupCollectionsRequest, ListBackupCollectionsPagedResponse>
      listBackupCollectionsPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listBackupCollectionsPagedCallable()");
  }

  public UnaryCallable<ListBackupCollectionsRequest, ListBackupCollectionsResponse>
      listBackupCollectionsCallable() {
    throw new UnsupportedOperationException("Not implemented: listBackupCollectionsCallable()");
  }

  public UnaryCallable<GetBackupCollectionRequest, BackupCollection> getBackupCollectionCallable() {
    throw new UnsupportedOperationException("Not implemented: getBackupCollectionCallable()");
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

  public OperationCallable<DeleteBackupRequest, Empty, OperationMetadata>
      deleteBackupOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteBackupOperationCallable()");
  }

  public UnaryCallable<DeleteBackupRequest, Operation> deleteBackupCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteBackupCallable()");
  }

  public OperationCallable<ExportBackupRequest, Backup, OperationMetadata>
      exportBackupOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: exportBackupOperationCallable()");
  }

  public UnaryCallable<ExportBackupRequest, Operation> exportBackupCallable() {
    throw new UnsupportedOperationException("Not implemented: exportBackupCallable()");
  }

  public OperationCallable<BackupInstanceRequest, Instance, OperationMetadata>
      backupInstanceOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: backupInstanceOperationCallable()");
  }

  public UnaryCallable<BackupInstanceRequest, Operation> backupInstanceCallable() {
    throw new UnsupportedOperationException("Not implemented: backupInstanceCallable()");
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
