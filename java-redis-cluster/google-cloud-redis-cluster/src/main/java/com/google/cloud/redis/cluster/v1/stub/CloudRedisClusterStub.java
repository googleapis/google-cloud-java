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

package com.google.cloud.redis.cluster.v1.stub;

import static com.google.cloud.redis.cluster.v1.CloudRedisClusterClient.ListBackupCollectionsPagedResponse;
import static com.google.cloud.redis.cluster.v1.CloudRedisClusterClient.ListBackupsPagedResponse;
import static com.google.cloud.redis.cluster.v1.CloudRedisClusterClient.ListClustersPagedResponse;
import static com.google.cloud.redis.cluster.v1.CloudRedisClusterClient.ListLocationsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.cloud.redis.cluster.v1.Backup;
import com.google.cloud.redis.cluster.v1.BackupClusterRequest;
import com.google.cloud.redis.cluster.v1.BackupCollection;
import com.google.cloud.redis.cluster.v1.CertificateAuthority;
import com.google.cloud.redis.cluster.v1.Cluster;
import com.google.cloud.redis.cluster.v1.CreateClusterRequest;
import com.google.cloud.redis.cluster.v1.DeleteBackupRequest;
import com.google.cloud.redis.cluster.v1.DeleteClusterRequest;
import com.google.cloud.redis.cluster.v1.ExportBackupRequest;
import com.google.cloud.redis.cluster.v1.GetBackupCollectionRequest;
import com.google.cloud.redis.cluster.v1.GetBackupRequest;
import com.google.cloud.redis.cluster.v1.GetClusterCertificateAuthorityRequest;
import com.google.cloud.redis.cluster.v1.GetClusterRequest;
import com.google.cloud.redis.cluster.v1.ListBackupCollectionsRequest;
import com.google.cloud.redis.cluster.v1.ListBackupCollectionsResponse;
import com.google.cloud.redis.cluster.v1.ListBackupsRequest;
import com.google.cloud.redis.cluster.v1.ListBackupsResponse;
import com.google.cloud.redis.cluster.v1.ListClustersRequest;
import com.google.cloud.redis.cluster.v1.ListClustersResponse;
import com.google.cloud.redis.cluster.v1.RescheduleClusterMaintenanceRequest;
import com.google.cloud.redis.cluster.v1.UpdateClusterRequest;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.OperationsStub;
import com.google.protobuf.Any;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the CloudRedisCluster service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class CloudRedisClusterStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    return null;
  }

  public com.google.api.gax.httpjson.longrunning.stub.OperationsStub getHttpJsonOperationsStub() {
    return null;
  }

  public UnaryCallable<ListClustersRequest, ListClustersPagedResponse> listClustersPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listClustersPagedCallable()");
  }

  public UnaryCallable<ListClustersRequest, ListClustersResponse> listClustersCallable() {
    throw new UnsupportedOperationException("Not implemented: listClustersCallable()");
  }

  public UnaryCallable<GetClusterRequest, Cluster> getClusterCallable() {
    throw new UnsupportedOperationException("Not implemented: getClusterCallable()");
  }

  public OperationCallable<UpdateClusterRequest, Cluster, Any> updateClusterOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: updateClusterOperationCallable()");
  }

  public UnaryCallable<UpdateClusterRequest, Operation> updateClusterCallable() {
    throw new UnsupportedOperationException("Not implemented: updateClusterCallable()");
  }

  public OperationCallable<DeleteClusterRequest, Empty, Any> deleteClusterOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteClusterOperationCallable()");
  }

  public UnaryCallable<DeleteClusterRequest, Operation> deleteClusterCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteClusterCallable()");
  }

  public OperationCallable<CreateClusterRequest, Cluster, Any> createClusterOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createClusterOperationCallable()");
  }

  public UnaryCallable<CreateClusterRequest, Operation> createClusterCallable() {
    throw new UnsupportedOperationException("Not implemented: createClusterCallable()");
  }

  public UnaryCallable<GetClusterCertificateAuthorityRequest, CertificateAuthority>
      getClusterCertificateAuthorityCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: getClusterCertificateAuthorityCallable()");
  }

  public OperationCallable<RescheduleClusterMaintenanceRequest, Cluster, Any>
      rescheduleClusterMaintenanceOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: rescheduleClusterMaintenanceOperationCallable()");
  }

  public UnaryCallable<RescheduleClusterMaintenanceRequest, Operation>
      rescheduleClusterMaintenanceCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: rescheduleClusterMaintenanceCallable()");
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

  public OperationCallable<DeleteBackupRequest, Empty, Any> deleteBackupOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteBackupOperationCallable()");
  }

  public UnaryCallable<DeleteBackupRequest, Operation> deleteBackupCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteBackupCallable()");
  }

  public OperationCallable<ExportBackupRequest, Backup, Any> exportBackupOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: exportBackupOperationCallable()");
  }

  public UnaryCallable<ExportBackupRequest, Operation> exportBackupCallable() {
    throw new UnsupportedOperationException("Not implemented: exportBackupCallable()");
  }

  public OperationCallable<BackupClusterRequest, Cluster, Any> backupClusterOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: backupClusterOperationCallable()");
  }

  public UnaryCallable<BackupClusterRequest, Operation> backupClusterCallable() {
    throw new UnsupportedOperationException("Not implemented: backupClusterCallable()");
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
