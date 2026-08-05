/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.sql.v1beta4.stub;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.sql.v1beta4.DatabaseInstance;
import com.google.cloud.sql.v1beta4.InstancesListEntraIdCertificatesResponse;
import com.google.cloud.sql.v1beta4.InstancesListResponse;
import com.google.cloud.sql.v1beta4.InstancesListServerCasResponse;
import com.google.cloud.sql.v1beta4.InstancesListServerCertificatesResponse;
import com.google.cloud.sql.v1beta4.Operation;
import com.google.cloud.sql.v1beta4.SqlInstancesAcquireSsrsLeaseRequest;
import com.google.cloud.sql.v1beta4.SqlInstancesAcquireSsrsLeaseResponse;
import com.google.cloud.sql.v1beta4.SqlInstancesAddEntraIdCertificateRequest;
import com.google.cloud.sql.v1beta4.SqlInstancesAddServerCaRequest;
import com.google.cloud.sql.v1beta4.SqlInstancesAddServerCertificateRequest;
import com.google.cloud.sql.v1beta4.SqlInstancesCloneRequest;
import com.google.cloud.sql.v1beta4.SqlInstancesCreateEphemeralCertRequest;
import com.google.cloud.sql.v1beta4.SqlInstancesDeleteRequest;
import com.google.cloud.sql.v1beta4.SqlInstancesDemoteMasterRequest;
import com.google.cloud.sql.v1beta4.SqlInstancesDemoteRequest;
import com.google.cloud.sql.v1beta4.SqlInstancesExecuteSqlRequest;
import com.google.cloud.sql.v1beta4.SqlInstancesExecuteSqlResponse;
import com.google.cloud.sql.v1beta4.SqlInstancesExportRequest;
import com.google.cloud.sql.v1beta4.SqlInstancesFailoverRequest;
import com.google.cloud.sql.v1beta4.SqlInstancesGetDiskShrinkConfigRequest;
import com.google.cloud.sql.v1beta4.SqlInstancesGetDiskShrinkConfigResponse;
import com.google.cloud.sql.v1beta4.SqlInstancesGetLatestRecoveryTimeRequest;
import com.google.cloud.sql.v1beta4.SqlInstancesGetLatestRecoveryTimeResponse;
import com.google.cloud.sql.v1beta4.SqlInstancesGetRequest;
import com.google.cloud.sql.v1beta4.SqlInstancesImportRequest;
import com.google.cloud.sql.v1beta4.SqlInstancesInsertRequest;
import com.google.cloud.sql.v1beta4.SqlInstancesListEntraIdCertificatesRequest;
import com.google.cloud.sql.v1beta4.SqlInstancesListRequest;
import com.google.cloud.sql.v1beta4.SqlInstancesListServerCasRequest;
import com.google.cloud.sql.v1beta4.SqlInstancesListServerCertificatesRequest;
import com.google.cloud.sql.v1beta4.SqlInstancesPatchRequest;
import com.google.cloud.sql.v1beta4.SqlInstancesPerformDiskShrinkRequest;
import com.google.cloud.sql.v1beta4.SqlInstancesPointInTimeRestoreRequest;
import com.google.cloud.sql.v1beta4.SqlInstancesPreCheckMajorVersionUpgradeRequest;
import com.google.cloud.sql.v1beta4.SqlInstancesPromoteReplicaRequest;
import com.google.cloud.sql.v1beta4.SqlInstancesReencryptRequest;
import com.google.cloud.sql.v1beta4.SqlInstancesReleaseSsrsLeaseRequest;
import com.google.cloud.sql.v1beta4.SqlInstancesReleaseSsrsLeaseResponse;
import com.google.cloud.sql.v1beta4.SqlInstancesRescheduleMaintenanceRequest;
import com.google.cloud.sql.v1beta4.SqlInstancesResetReplicaSizeRequest;
import com.google.cloud.sql.v1beta4.SqlInstancesResetSslConfigRequest;
import com.google.cloud.sql.v1beta4.SqlInstancesRestartRequest;
import com.google.cloud.sql.v1beta4.SqlInstancesRestoreBackupRequest;
import com.google.cloud.sql.v1beta4.SqlInstancesRotateEntraIdCertificateRequest;
import com.google.cloud.sql.v1beta4.SqlInstancesRotateServerCaRequest;
import com.google.cloud.sql.v1beta4.SqlInstancesRotateServerCertificateRequest;
import com.google.cloud.sql.v1beta4.SqlInstancesStartExternalSyncRequest;
import com.google.cloud.sql.v1beta4.SqlInstancesStartReplicaRequest;
import com.google.cloud.sql.v1beta4.SqlInstancesStopReplicaRequest;
import com.google.cloud.sql.v1beta4.SqlInstancesSwitchoverRequest;
import com.google.cloud.sql.v1beta4.SqlInstancesTruncateLogRequest;
import com.google.cloud.sql.v1beta4.SqlInstancesUpdateRequest;
import com.google.cloud.sql.v1beta4.SqlInstancesVerifyExternalSyncSettingsRequest;
import com.google.cloud.sql.v1beta4.SqlInstancesVerifyExternalSyncSettingsResponse;
import com.google.cloud.sql.v1beta4.SslCert;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the SqlInstancesService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@NullMarked
@BetaApi
@Generated("by gapic-generator-java")
public abstract class SqlInstancesServiceStub implements BackgroundResource {

  public UnaryCallable<SqlInstancesAddServerCaRequest, Operation> addServerCaCallable() {
    throw new UnsupportedOperationException("Not implemented: addServerCaCallable()");
  }

  public UnaryCallable<SqlInstancesAddServerCertificateRequest, Operation>
      addServerCertificateCallable() {
    throw new UnsupportedOperationException("Not implemented: addServerCertificateCallable()");
  }

  public UnaryCallable<SqlInstancesAddEntraIdCertificateRequest, Operation>
      addEntraIdCertificateCallable() {
    throw new UnsupportedOperationException("Not implemented: addEntraIdCertificateCallable()");
  }

  public UnaryCallable<SqlInstancesCloneRequest, Operation> cloneCallable() {
    throw new UnsupportedOperationException("Not implemented: cloneCallable()");
  }

  public UnaryCallable<SqlInstancesDeleteRequest, Operation> deleteCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteCallable()");
  }

  public UnaryCallable<SqlInstancesDemoteMasterRequest, Operation> demoteMasterCallable() {
    throw new UnsupportedOperationException("Not implemented: demoteMasterCallable()");
  }

  public UnaryCallable<SqlInstancesDemoteRequest, Operation> demoteCallable() {
    throw new UnsupportedOperationException("Not implemented: demoteCallable()");
  }

  public UnaryCallable<SqlInstancesExportRequest, Operation> exportCallable() {
    throw new UnsupportedOperationException("Not implemented: exportCallable()");
  }

  public UnaryCallable<SqlInstancesFailoverRequest, Operation> failoverCallable() {
    throw new UnsupportedOperationException("Not implemented: failoverCallable()");
  }

  public UnaryCallable<SqlInstancesReencryptRequest, Operation> reencryptCallable() {
    throw new UnsupportedOperationException("Not implemented: reencryptCallable()");
  }

  public UnaryCallable<SqlInstancesGetRequest, DatabaseInstance> getCallable() {
    throw new UnsupportedOperationException("Not implemented: getCallable()");
  }

  public UnaryCallable<SqlInstancesImportRequest, Operation> import_Callable() {
    throw new UnsupportedOperationException("Not implemented: import_Callable()");
  }

  public UnaryCallable<SqlInstancesInsertRequest, Operation> insertCallable() {
    throw new UnsupportedOperationException("Not implemented: insertCallable()");
  }

  public UnaryCallable<SqlInstancesListRequest, InstancesListResponse> listCallable() {
    throw new UnsupportedOperationException("Not implemented: listCallable()");
  }

  public UnaryCallable<SqlInstancesListServerCasRequest, InstancesListServerCasResponse>
      listServerCasCallable() {
    throw new UnsupportedOperationException("Not implemented: listServerCasCallable()");
  }

  public UnaryCallable<
          SqlInstancesListServerCertificatesRequest, InstancesListServerCertificatesResponse>
      listServerCertificatesCallable() {
    throw new UnsupportedOperationException("Not implemented: listServerCertificatesCallable()");
  }

  public UnaryCallable<
          SqlInstancesListEntraIdCertificatesRequest, InstancesListEntraIdCertificatesResponse>
      listEntraIdCertificatesCallable() {
    throw new UnsupportedOperationException("Not implemented: listEntraIdCertificatesCallable()");
  }

  public UnaryCallable<SqlInstancesPatchRequest, Operation> patchCallable() {
    throw new UnsupportedOperationException("Not implemented: patchCallable()");
  }

  public UnaryCallable<SqlInstancesPromoteReplicaRequest, Operation> promoteReplicaCallable() {
    throw new UnsupportedOperationException("Not implemented: promoteReplicaCallable()");
  }

  public UnaryCallable<SqlInstancesSwitchoverRequest, Operation> switchoverCallable() {
    throw new UnsupportedOperationException("Not implemented: switchoverCallable()");
  }

  public UnaryCallable<SqlInstancesResetSslConfigRequest, Operation> resetSslConfigCallable() {
    throw new UnsupportedOperationException("Not implemented: resetSslConfigCallable()");
  }

  public UnaryCallable<SqlInstancesRestartRequest, Operation> restartCallable() {
    throw new UnsupportedOperationException("Not implemented: restartCallable()");
  }

  public UnaryCallable<SqlInstancesRestoreBackupRequest, Operation> restoreBackupCallable() {
    throw new UnsupportedOperationException("Not implemented: restoreBackupCallable()");
  }

  public UnaryCallable<SqlInstancesRotateServerCaRequest, Operation> rotateServerCaCallable() {
    throw new UnsupportedOperationException("Not implemented: rotateServerCaCallable()");
  }

  public UnaryCallable<SqlInstancesRotateServerCertificateRequest, Operation>
      rotateServerCertificateCallable() {
    throw new UnsupportedOperationException("Not implemented: rotateServerCertificateCallable()");
  }

  public UnaryCallable<SqlInstancesRotateEntraIdCertificateRequest, Operation>
      rotateEntraIdCertificateCallable() {
    throw new UnsupportedOperationException("Not implemented: rotateEntraIdCertificateCallable()");
  }

  public UnaryCallable<SqlInstancesStartReplicaRequest, Operation> startReplicaCallable() {
    throw new UnsupportedOperationException("Not implemented: startReplicaCallable()");
  }

  public UnaryCallable<SqlInstancesStopReplicaRequest, Operation> stopReplicaCallable() {
    throw new UnsupportedOperationException("Not implemented: stopReplicaCallable()");
  }

  public UnaryCallable<SqlInstancesTruncateLogRequest, Operation> truncateLogCallable() {
    throw new UnsupportedOperationException("Not implemented: truncateLogCallable()");
  }

  public UnaryCallable<SqlInstancesUpdateRequest, Operation> updateCallable() {
    throw new UnsupportedOperationException("Not implemented: updateCallable()");
  }

  public UnaryCallable<SqlInstancesCreateEphemeralCertRequest, SslCert> createEphemeralCallable() {
    throw new UnsupportedOperationException("Not implemented: createEphemeralCallable()");
  }

  public UnaryCallable<SqlInstancesRescheduleMaintenanceRequest, Operation>
      rescheduleMaintenanceCallable() {
    throw new UnsupportedOperationException("Not implemented: rescheduleMaintenanceCallable()");
  }

  public UnaryCallable<
          SqlInstancesVerifyExternalSyncSettingsRequest,
          SqlInstancesVerifyExternalSyncSettingsResponse>
      verifyExternalSyncSettingsCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: verifyExternalSyncSettingsCallable()");
  }

  public UnaryCallable<SqlInstancesStartExternalSyncRequest, Operation>
      startExternalSyncCallable() {
    throw new UnsupportedOperationException("Not implemented: startExternalSyncCallable()");
  }

  public UnaryCallable<SqlInstancesPerformDiskShrinkRequest, Operation>
      performDiskShrinkCallable() {
    throw new UnsupportedOperationException("Not implemented: performDiskShrinkCallable()");
  }

  public UnaryCallable<
          SqlInstancesGetDiskShrinkConfigRequest, SqlInstancesGetDiskShrinkConfigResponse>
      getDiskShrinkConfigCallable() {
    throw new UnsupportedOperationException("Not implemented: getDiskShrinkConfigCallable()");
  }

  public UnaryCallable<SqlInstancesResetReplicaSizeRequest, Operation> resetReplicaSizeCallable() {
    throw new UnsupportedOperationException("Not implemented: resetReplicaSizeCallable()");
  }

  public UnaryCallable<
          SqlInstancesGetLatestRecoveryTimeRequest, SqlInstancesGetLatestRecoveryTimeResponse>
      getLatestRecoveryTimeCallable() {
    throw new UnsupportedOperationException("Not implemented: getLatestRecoveryTimeCallable()");
  }

  public UnaryCallable<SqlInstancesExecuteSqlRequest, SqlInstancesExecuteSqlResponse>
      executeSqlCallable() {
    throw new UnsupportedOperationException("Not implemented: executeSqlCallable()");
  }

  public UnaryCallable<SqlInstancesAcquireSsrsLeaseRequest, SqlInstancesAcquireSsrsLeaseResponse>
      acquireSsrsLeaseCallable() {
    throw new UnsupportedOperationException("Not implemented: acquireSsrsLeaseCallable()");
  }

  public UnaryCallable<SqlInstancesReleaseSsrsLeaseRequest, SqlInstancesReleaseSsrsLeaseResponse>
      releaseSsrsLeaseCallable() {
    throw new UnsupportedOperationException("Not implemented: releaseSsrsLeaseCallable()");
  }

  public UnaryCallable<SqlInstancesPreCheckMajorVersionUpgradeRequest, Operation>
      preCheckMajorVersionUpgradeCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: preCheckMajorVersionUpgradeCallable()");
  }

  public UnaryCallable<SqlInstancesPointInTimeRestoreRequest, Operation>
      pointInTimeRestoreCallable() {
    throw new UnsupportedOperationException("Not implemented: pointInTimeRestoreCallable()");
  }

  @Override
  public abstract void close();
}
