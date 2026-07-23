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

package com.google.cloud.sql.v1.stub;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.api.pathtemplate.PathTemplate;
import com.google.cloud.sql.v1.DatabaseInstance;
import com.google.cloud.sql.v1.InstancesListEntraIdCertificatesResponse;
import com.google.cloud.sql.v1.InstancesListResponse;
import com.google.cloud.sql.v1.InstancesListServerCasResponse;
import com.google.cloud.sql.v1.InstancesListServerCertificatesResponse;
import com.google.cloud.sql.v1.Operation;
import com.google.cloud.sql.v1.SqlInstancesAcquireSsrsLeaseRequest;
import com.google.cloud.sql.v1.SqlInstancesAcquireSsrsLeaseResponse;
import com.google.cloud.sql.v1.SqlInstancesAddEntraIdCertificateRequest;
import com.google.cloud.sql.v1.SqlInstancesAddServerCaRequest;
import com.google.cloud.sql.v1.SqlInstancesAddServerCertificateRequest;
import com.google.cloud.sql.v1.SqlInstancesCloneRequest;
import com.google.cloud.sql.v1.SqlInstancesCreateEphemeralCertRequest;
import com.google.cloud.sql.v1.SqlInstancesDeleteRequest;
import com.google.cloud.sql.v1.SqlInstancesDemoteMasterRequest;
import com.google.cloud.sql.v1.SqlInstancesDemoteRequest;
import com.google.cloud.sql.v1.SqlInstancesExecuteSqlRequest;
import com.google.cloud.sql.v1.SqlInstancesExecuteSqlResponse;
import com.google.cloud.sql.v1.SqlInstancesExportRequest;
import com.google.cloud.sql.v1.SqlInstancesFailoverRequest;
import com.google.cloud.sql.v1.SqlInstancesGetDiskShrinkConfigRequest;
import com.google.cloud.sql.v1.SqlInstancesGetDiskShrinkConfigResponse;
import com.google.cloud.sql.v1.SqlInstancesGetLatestRecoveryTimeRequest;
import com.google.cloud.sql.v1.SqlInstancesGetLatestRecoveryTimeResponse;
import com.google.cloud.sql.v1.SqlInstancesGetRequest;
import com.google.cloud.sql.v1.SqlInstancesImportRequest;
import com.google.cloud.sql.v1.SqlInstancesInsertRequest;
import com.google.cloud.sql.v1.SqlInstancesListEntraIdCertificatesRequest;
import com.google.cloud.sql.v1.SqlInstancesListRequest;
import com.google.cloud.sql.v1.SqlInstancesListServerCasRequest;
import com.google.cloud.sql.v1.SqlInstancesListServerCertificatesRequest;
import com.google.cloud.sql.v1.SqlInstancesPatchRequest;
import com.google.cloud.sql.v1.SqlInstancesPerformDiskShrinkRequest;
import com.google.cloud.sql.v1.SqlInstancesPointInTimeRestoreRequest;
import com.google.cloud.sql.v1.SqlInstancesPreCheckMajorVersionUpgradeRequest;
import com.google.cloud.sql.v1.SqlInstancesPromoteReplicaRequest;
import com.google.cloud.sql.v1.SqlInstancesReencryptRequest;
import com.google.cloud.sql.v1.SqlInstancesReleaseSsrsLeaseRequest;
import com.google.cloud.sql.v1.SqlInstancesReleaseSsrsLeaseResponse;
import com.google.cloud.sql.v1.SqlInstancesRescheduleMaintenanceRequest;
import com.google.cloud.sql.v1.SqlInstancesResetReplicaSizeRequest;
import com.google.cloud.sql.v1.SqlInstancesResetSslConfigRequest;
import com.google.cloud.sql.v1.SqlInstancesRestartRequest;
import com.google.cloud.sql.v1.SqlInstancesRestoreBackupRequest;
import com.google.cloud.sql.v1.SqlInstancesRotateEntraIdCertificateRequest;
import com.google.cloud.sql.v1.SqlInstancesRotateServerCaRequest;
import com.google.cloud.sql.v1.SqlInstancesRotateServerCertificateRequest;
import com.google.cloud.sql.v1.SqlInstancesStartExternalSyncRequest;
import com.google.cloud.sql.v1.SqlInstancesStartReplicaRequest;
import com.google.cloud.sql.v1.SqlInstancesStopReplicaRequest;
import com.google.cloud.sql.v1.SqlInstancesSwitchoverRequest;
import com.google.cloud.sql.v1.SqlInstancesTruncateLogRequest;
import com.google.cloud.sql.v1.SqlInstancesUpdateRequest;
import com.google.cloud.sql.v1.SqlInstancesVerifyExternalSyncSettingsRequest;
import com.google.cloud.sql.v1.SqlInstancesVerifyExternalSyncSettingsResponse;
import com.google.cloud.sql.v1.SslCert;
import com.google.longrunning.stub.GrpcOperationsStub;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the SqlInstancesService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@NullMarked
@Generated("by gapic-generator-java")
public class GrpcSqlInstancesServiceStub extends SqlInstancesServiceStub {
  private static final MethodDescriptor<SqlInstancesAddServerCaRequest, Operation>
      addServerCaMethodDescriptor =
          MethodDescriptor.<SqlInstancesAddServerCaRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.sql.v1.SqlInstancesService/AddServerCa")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(SqlInstancesAddServerCaRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<SqlInstancesAddServerCertificateRequest, Operation>
      addServerCertificateMethodDescriptor =
          MethodDescriptor.<SqlInstancesAddServerCertificateRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.sql.v1.SqlInstancesService/AddServerCertificate")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      SqlInstancesAddServerCertificateRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<SqlInstancesAddEntraIdCertificateRequest, Operation>
      addEntraIdCertificateMethodDescriptor =
          MethodDescriptor.<SqlInstancesAddEntraIdCertificateRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.sql.v1.SqlInstancesService/AddEntraIdCertificate")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      SqlInstancesAddEntraIdCertificateRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<SqlInstancesCloneRequest, Operation> cloneMethodDescriptor =
      MethodDescriptor.<SqlInstancesCloneRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.sql.v1.SqlInstancesService/Clone")
          .setRequestMarshaller(
              ProtoUtils.marshaller(SqlInstancesCloneRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<SqlInstancesDeleteRequest, Operation>
      deleteMethodDescriptor =
          MethodDescriptor.<SqlInstancesDeleteRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.sql.v1.SqlInstancesService/Delete")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(SqlInstancesDeleteRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<SqlInstancesDemoteMasterRequest, Operation>
      demoteMasterMethodDescriptor =
          MethodDescriptor.<SqlInstancesDemoteMasterRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.sql.v1.SqlInstancesService/DemoteMaster")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(SqlInstancesDemoteMasterRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<SqlInstancesDemoteRequest, Operation>
      demoteMethodDescriptor =
          MethodDescriptor.<SqlInstancesDemoteRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.sql.v1.SqlInstancesService/Demote")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(SqlInstancesDemoteRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<SqlInstancesExportRequest, Operation>
      exportMethodDescriptor =
          MethodDescriptor.<SqlInstancesExportRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.sql.v1.SqlInstancesService/Export")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(SqlInstancesExportRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<SqlInstancesFailoverRequest, Operation>
      failoverMethodDescriptor =
          MethodDescriptor.<SqlInstancesFailoverRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.sql.v1.SqlInstancesService/Failover")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(SqlInstancesFailoverRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<SqlInstancesReencryptRequest, Operation>
      reencryptMethodDescriptor =
          MethodDescriptor.<SqlInstancesReencryptRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.sql.v1.SqlInstancesService/Reencrypt")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(SqlInstancesReencryptRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<SqlInstancesGetRequest, DatabaseInstance>
      getMethodDescriptor =
          MethodDescriptor.<SqlInstancesGetRequest, DatabaseInstance>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.sql.v1.SqlInstancesService/Get")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(SqlInstancesGetRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(DatabaseInstance.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<SqlInstancesImportRequest, Operation>
      import_MethodDescriptor =
          MethodDescriptor.<SqlInstancesImportRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.sql.v1.SqlInstancesService/Import")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(SqlInstancesImportRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<SqlInstancesInsertRequest, Operation>
      insertMethodDescriptor =
          MethodDescriptor.<SqlInstancesInsertRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.sql.v1.SqlInstancesService/Insert")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(SqlInstancesInsertRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<SqlInstancesListRequest, InstancesListResponse>
      listMethodDescriptor =
          MethodDescriptor.<SqlInstancesListRequest, InstancesListResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.sql.v1.SqlInstancesService/List")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(SqlInstancesListRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(InstancesListResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<
          SqlInstancesListServerCasRequest, InstancesListServerCasResponse>
      listServerCasMethodDescriptor =
          MethodDescriptor
              .<SqlInstancesListServerCasRequest, InstancesListServerCasResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.sql.v1.SqlInstancesService/ListServerCas")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(SqlInstancesListServerCasRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(InstancesListServerCasResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<
          SqlInstancesListServerCertificatesRequest, InstancesListServerCertificatesResponse>
      listServerCertificatesMethodDescriptor =
          MethodDescriptor
              .<SqlInstancesListServerCertificatesRequest, InstancesListServerCertificatesResponse>
                  newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.sql.v1.SqlInstancesService/ListServerCertificates")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      SqlInstancesListServerCertificatesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(
                      InstancesListServerCertificatesResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<
          SqlInstancesListEntraIdCertificatesRequest, InstancesListEntraIdCertificatesResponse>
      listEntraIdCertificatesMethodDescriptor =
          MethodDescriptor
              .<SqlInstancesListEntraIdCertificatesRequest,
                  InstancesListEntraIdCertificatesResponse>
                  newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.sql.v1.SqlInstancesService/ListEntraIdCertificates")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      SqlInstancesListEntraIdCertificatesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(
                      InstancesListEntraIdCertificatesResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<SqlInstancesPatchRequest, Operation> patchMethodDescriptor =
      MethodDescriptor.<SqlInstancesPatchRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.sql.v1.SqlInstancesService/Patch")
          .setRequestMarshaller(
              ProtoUtils.marshaller(SqlInstancesPatchRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<SqlInstancesPromoteReplicaRequest, Operation>
      promoteReplicaMethodDescriptor =
          MethodDescriptor.<SqlInstancesPromoteReplicaRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.sql.v1.SqlInstancesService/PromoteReplica")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(SqlInstancesPromoteReplicaRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<SqlInstancesSwitchoverRequest, Operation>
      switchoverMethodDescriptor =
          MethodDescriptor.<SqlInstancesSwitchoverRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.sql.v1.SqlInstancesService/Switchover")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(SqlInstancesSwitchoverRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<SqlInstancesResetSslConfigRequest, Operation>
      resetSslConfigMethodDescriptor =
          MethodDescriptor.<SqlInstancesResetSslConfigRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.sql.v1.SqlInstancesService/ResetSslConfig")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(SqlInstancesResetSslConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<SqlInstancesRestartRequest, Operation>
      restartMethodDescriptor =
          MethodDescriptor.<SqlInstancesRestartRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.sql.v1.SqlInstancesService/Restart")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(SqlInstancesRestartRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<SqlInstancesRestoreBackupRequest, Operation>
      restoreBackupMethodDescriptor =
          MethodDescriptor.<SqlInstancesRestoreBackupRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.sql.v1.SqlInstancesService/RestoreBackup")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(SqlInstancesRestoreBackupRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<SqlInstancesRotateServerCaRequest, Operation>
      rotateServerCaMethodDescriptor =
          MethodDescriptor.<SqlInstancesRotateServerCaRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.sql.v1.SqlInstancesService/RotateServerCa")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(SqlInstancesRotateServerCaRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<SqlInstancesRotateServerCertificateRequest, Operation>
      rotateServerCertificateMethodDescriptor =
          MethodDescriptor.<SqlInstancesRotateServerCertificateRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.sql.v1.SqlInstancesService/RotateServerCertificate")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      SqlInstancesRotateServerCertificateRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<SqlInstancesRotateEntraIdCertificateRequest, Operation>
      rotateEntraIdCertificateMethodDescriptor =
          MethodDescriptor.<SqlInstancesRotateEntraIdCertificateRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.sql.v1.SqlInstancesService/RotateEntraIdCertificate")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      SqlInstancesRotateEntraIdCertificateRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<SqlInstancesStartReplicaRequest, Operation>
      startReplicaMethodDescriptor =
          MethodDescriptor.<SqlInstancesStartReplicaRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.sql.v1.SqlInstancesService/StartReplica")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(SqlInstancesStartReplicaRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<SqlInstancesStopReplicaRequest, Operation>
      stopReplicaMethodDescriptor =
          MethodDescriptor.<SqlInstancesStopReplicaRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.sql.v1.SqlInstancesService/StopReplica")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(SqlInstancesStopReplicaRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<SqlInstancesTruncateLogRequest, Operation>
      truncateLogMethodDescriptor =
          MethodDescriptor.<SqlInstancesTruncateLogRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.sql.v1.SqlInstancesService/TruncateLog")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(SqlInstancesTruncateLogRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<SqlInstancesUpdateRequest, Operation>
      updateMethodDescriptor =
          MethodDescriptor.<SqlInstancesUpdateRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.sql.v1.SqlInstancesService/Update")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(SqlInstancesUpdateRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<SqlInstancesCreateEphemeralCertRequest, SslCert>
      createEphemeralMethodDescriptor =
          MethodDescriptor.<SqlInstancesCreateEphemeralCertRequest, SslCert>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.sql.v1.SqlInstancesService/CreateEphemeral")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      SqlInstancesCreateEphemeralCertRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(SslCert.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<SqlInstancesRescheduleMaintenanceRequest, Operation>
      rescheduleMaintenanceMethodDescriptor =
          MethodDescriptor.<SqlInstancesRescheduleMaintenanceRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.sql.v1.SqlInstancesService/RescheduleMaintenance")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      SqlInstancesRescheduleMaintenanceRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<
          SqlInstancesVerifyExternalSyncSettingsRequest,
          SqlInstancesVerifyExternalSyncSettingsResponse>
      verifyExternalSyncSettingsMethodDescriptor =
          MethodDescriptor
              .<SqlInstancesVerifyExternalSyncSettingsRequest,
                  SqlInstancesVerifyExternalSyncSettingsResponse>
                  newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.sql.v1.SqlInstancesService/VerifyExternalSyncSettings")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      SqlInstancesVerifyExternalSyncSettingsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(
                      SqlInstancesVerifyExternalSyncSettingsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<SqlInstancesStartExternalSyncRequest, Operation>
      startExternalSyncMethodDescriptor =
          MethodDescriptor.<SqlInstancesStartExternalSyncRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.sql.v1.SqlInstancesService/StartExternalSync")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(SqlInstancesStartExternalSyncRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<SqlInstancesPerformDiskShrinkRequest, Operation>
      performDiskShrinkMethodDescriptor =
          MethodDescriptor.<SqlInstancesPerformDiskShrinkRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.sql.v1.SqlInstancesService/PerformDiskShrink")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(SqlInstancesPerformDiskShrinkRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<
          SqlInstancesGetDiskShrinkConfigRequest, SqlInstancesGetDiskShrinkConfigResponse>
      getDiskShrinkConfigMethodDescriptor =
          MethodDescriptor
              .<SqlInstancesGetDiskShrinkConfigRequest, SqlInstancesGetDiskShrinkConfigResponse>
                  newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.sql.v1.SqlInstancesService/GetDiskShrinkConfig")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      SqlInstancesGetDiskShrinkConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(
                      SqlInstancesGetDiskShrinkConfigResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<SqlInstancesResetReplicaSizeRequest, Operation>
      resetReplicaSizeMethodDescriptor =
          MethodDescriptor.<SqlInstancesResetReplicaSizeRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.sql.v1.SqlInstancesService/ResetReplicaSize")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(SqlInstancesResetReplicaSizeRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<
          SqlInstancesGetLatestRecoveryTimeRequest, SqlInstancesGetLatestRecoveryTimeResponse>
      getLatestRecoveryTimeMethodDescriptor =
          MethodDescriptor
              .<SqlInstancesGetLatestRecoveryTimeRequest, SqlInstancesGetLatestRecoveryTimeResponse>
                  newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.sql.v1.SqlInstancesService/GetLatestRecoveryTime")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      SqlInstancesGetLatestRecoveryTimeRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(
                      SqlInstancesGetLatestRecoveryTimeResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<
          SqlInstancesExecuteSqlRequest, SqlInstancesExecuteSqlResponse>
      executeSqlMethodDescriptor =
          MethodDescriptor
              .<SqlInstancesExecuteSqlRequest, SqlInstancesExecuteSqlResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.sql.v1.SqlInstancesService/ExecuteSql")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(SqlInstancesExecuteSqlRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(SqlInstancesExecuteSqlResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<
          SqlInstancesAcquireSsrsLeaseRequest, SqlInstancesAcquireSsrsLeaseResponse>
      acquireSsrsLeaseMethodDescriptor =
          MethodDescriptor
              .<SqlInstancesAcquireSsrsLeaseRequest, SqlInstancesAcquireSsrsLeaseResponse>
                  newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.sql.v1.SqlInstancesService/AcquireSsrsLease")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(SqlInstancesAcquireSsrsLeaseRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(SqlInstancesAcquireSsrsLeaseResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<
          SqlInstancesReleaseSsrsLeaseRequest, SqlInstancesReleaseSsrsLeaseResponse>
      releaseSsrsLeaseMethodDescriptor =
          MethodDescriptor
              .<SqlInstancesReleaseSsrsLeaseRequest, SqlInstancesReleaseSsrsLeaseResponse>
                  newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.sql.v1.SqlInstancesService/ReleaseSsrsLease")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(SqlInstancesReleaseSsrsLeaseRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(SqlInstancesReleaseSsrsLeaseResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<SqlInstancesPreCheckMajorVersionUpgradeRequest, Operation>
      preCheckMajorVersionUpgradeMethodDescriptor =
          MethodDescriptor.<SqlInstancesPreCheckMajorVersionUpgradeRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.sql.v1.SqlInstancesService/PreCheckMajorVersionUpgrade")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      SqlInstancesPreCheckMajorVersionUpgradeRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<SqlInstancesPointInTimeRestoreRequest, Operation>
      pointInTimeRestoreMethodDescriptor =
          MethodDescriptor.<SqlInstancesPointInTimeRestoreRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.sql.v1.SqlInstancesService/PointInTimeRestore")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(SqlInstancesPointInTimeRestoreRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private final UnaryCallable<SqlInstancesAddServerCaRequest, Operation> addServerCaCallable;
  private final UnaryCallable<SqlInstancesAddServerCertificateRequest, Operation>
      addServerCertificateCallable;
  private final UnaryCallable<SqlInstancesAddEntraIdCertificateRequest, Operation>
      addEntraIdCertificateCallable;
  private final UnaryCallable<SqlInstancesCloneRequest, Operation> cloneCallable;
  private final UnaryCallable<SqlInstancesDeleteRequest, Operation> deleteCallable;
  private final UnaryCallable<SqlInstancesDemoteMasterRequest, Operation> demoteMasterCallable;
  private final UnaryCallable<SqlInstancesDemoteRequest, Operation> demoteCallable;
  private final UnaryCallable<SqlInstancesExportRequest, Operation> exportCallable;
  private final UnaryCallable<SqlInstancesFailoverRequest, Operation> failoverCallable;
  private final UnaryCallable<SqlInstancesReencryptRequest, Operation> reencryptCallable;
  private final UnaryCallable<SqlInstancesGetRequest, DatabaseInstance> getCallable;
  private final UnaryCallable<SqlInstancesImportRequest, Operation> import_Callable;
  private final UnaryCallable<SqlInstancesInsertRequest, Operation> insertCallable;
  private final UnaryCallable<SqlInstancesListRequest, InstancesListResponse> listCallable;
  private final UnaryCallable<SqlInstancesListServerCasRequest, InstancesListServerCasResponse>
      listServerCasCallable;
  private final UnaryCallable<
          SqlInstancesListServerCertificatesRequest, InstancesListServerCertificatesResponse>
      listServerCertificatesCallable;
  private final UnaryCallable<
          SqlInstancesListEntraIdCertificatesRequest, InstancesListEntraIdCertificatesResponse>
      listEntraIdCertificatesCallable;
  private final UnaryCallable<SqlInstancesPatchRequest, Operation> patchCallable;
  private final UnaryCallable<SqlInstancesPromoteReplicaRequest, Operation> promoteReplicaCallable;
  private final UnaryCallable<SqlInstancesSwitchoverRequest, Operation> switchoverCallable;
  private final UnaryCallable<SqlInstancesResetSslConfigRequest, Operation> resetSslConfigCallable;
  private final UnaryCallable<SqlInstancesRestartRequest, Operation> restartCallable;
  private final UnaryCallable<SqlInstancesRestoreBackupRequest, Operation> restoreBackupCallable;
  private final UnaryCallable<SqlInstancesRotateServerCaRequest, Operation> rotateServerCaCallable;
  private final UnaryCallable<SqlInstancesRotateServerCertificateRequest, Operation>
      rotateServerCertificateCallable;
  private final UnaryCallable<SqlInstancesRotateEntraIdCertificateRequest, Operation>
      rotateEntraIdCertificateCallable;
  private final UnaryCallable<SqlInstancesStartReplicaRequest, Operation> startReplicaCallable;
  private final UnaryCallable<SqlInstancesStopReplicaRequest, Operation> stopReplicaCallable;
  private final UnaryCallable<SqlInstancesTruncateLogRequest, Operation> truncateLogCallable;
  private final UnaryCallable<SqlInstancesUpdateRequest, Operation> updateCallable;
  private final UnaryCallable<SqlInstancesCreateEphemeralCertRequest, SslCert>
      createEphemeralCallable;
  private final UnaryCallable<SqlInstancesRescheduleMaintenanceRequest, Operation>
      rescheduleMaintenanceCallable;
  private final UnaryCallable<
          SqlInstancesVerifyExternalSyncSettingsRequest,
          SqlInstancesVerifyExternalSyncSettingsResponse>
      verifyExternalSyncSettingsCallable;
  private final UnaryCallable<SqlInstancesStartExternalSyncRequest, Operation>
      startExternalSyncCallable;
  private final UnaryCallable<SqlInstancesPerformDiskShrinkRequest, Operation>
      performDiskShrinkCallable;
  private final UnaryCallable<
          SqlInstancesGetDiskShrinkConfigRequest, SqlInstancesGetDiskShrinkConfigResponse>
      getDiskShrinkConfigCallable;
  private final UnaryCallable<SqlInstancesResetReplicaSizeRequest, Operation>
      resetReplicaSizeCallable;
  private final UnaryCallable<
          SqlInstancesGetLatestRecoveryTimeRequest, SqlInstancesGetLatestRecoveryTimeResponse>
      getLatestRecoveryTimeCallable;
  private final UnaryCallable<SqlInstancesExecuteSqlRequest, SqlInstancesExecuteSqlResponse>
      executeSqlCallable;
  private final UnaryCallable<
          SqlInstancesAcquireSsrsLeaseRequest, SqlInstancesAcquireSsrsLeaseResponse>
      acquireSsrsLeaseCallable;
  private final UnaryCallable<
          SqlInstancesReleaseSsrsLeaseRequest, SqlInstancesReleaseSsrsLeaseResponse>
      releaseSsrsLeaseCallable;
  private final UnaryCallable<SqlInstancesPreCheckMajorVersionUpgradeRequest, Operation>
      preCheckMajorVersionUpgradeCallable;
  private final UnaryCallable<SqlInstancesPointInTimeRestoreRequest, Operation>
      pointInTimeRestoreCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  private static final PathTemplate ADD_SERVER_CA_RESOURCE_NAME_TEMPLATE =
      PathTemplate.create("projects/{project}/instances/{instance}");
  private static final PathTemplate ADD_SERVER_CERTIFICATE_RESOURCE_NAME_TEMPLATE =
      PathTemplate.create("projects/{project}/instances/{instance}");
  private static final PathTemplate ADD_ENTRA_ID_CERTIFICATE_RESOURCE_NAME_TEMPLATE =
      PathTemplate.create("projects/{project}/instances/{instance}");
  private static final PathTemplate CLONE_RESOURCE_NAME_TEMPLATE =
      PathTemplate.create("projects/{project}/instances/{instance}");
  private static final PathTemplate DELETE_RESOURCE_NAME_TEMPLATE =
      PathTemplate.create("projects/{project}/instances/{instance}");
  private static final PathTemplate DEMOTE_MASTER_RESOURCE_NAME_TEMPLATE =
      PathTemplate.create("projects/{project}/instances/{instance}");
  private static final PathTemplate DEMOTE_RESOURCE_NAME_TEMPLATE =
      PathTemplate.create("projects/{project}/instances/{instance}");
  private static final PathTemplate EXPORT_RESOURCE_NAME_TEMPLATE =
      PathTemplate.create("projects/{project}/instances/{instance}");
  private static final PathTemplate FAILOVER_RESOURCE_NAME_TEMPLATE =
      PathTemplate.create("projects/{project}/instances/{instance}");
  private static final PathTemplate REENCRYPT_RESOURCE_NAME_TEMPLATE =
      PathTemplate.create("projects/{project}/instances/{instance}");
  private static final PathTemplate GET_RESOURCE_NAME_TEMPLATE =
      PathTemplate.create("projects/{project}/instances/{instance}");
  private static final PathTemplate IMPORT_RESOURCE_NAME_TEMPLATE =
      PathTemplate.create("projects/{project}/instances/{instance}");
  private static final PathTemplate INSERT_RESOURCE_NAME_TEMPLATE =
      PathTemplate.create("projects/{project}");
  private static final PathTemplate LIST_RESOURCE_NAME_TEMPLATE =
      PathTemplate.create("projects/{project}");
  private static final PathTemplate LIST_SERVER_CAS_RESOURCE_NAME_TEMPLATE =
      PathTemplate.create("projects/{project}/instances/{instance}");
  private static final PathTemplate LIST_SERVER_CERTIFICATES_RESOURCE_NAME_TEMPLATE =
      PathTemplate.create("projects/{project}/instances/{instance}");
  private static final PathTemplate LIST_ENTRA_ID_CERTIFICATES_RESOURCE_NAME_TEMPLATE =
      PathTemplate.create("projects/{project}/instances/{instance}");
  private static final PathTemplate PATCH_RESOURCE_NAME_TEMPLATE =
      PathTemplate.create("projects/{project}/instances/{instance}");
  private static final PathTemplate PROMOTE_REPLICA_RESOURCE_NAME_TEMPLATE =
      PathTemplate.create("projects/{project}/instances/{instance}");
  private static final PathTemplate SWITCHOVER_RESOURCE_NAME_TEMPLATE =
      PathTemplate.create("projects/{project}/instances/{instance}");
  private static final PathTemplate RESET_SSL_CONFIG_RESOURCE_NAME_TEMPLATE =
      PathTemplate.create("projects/{project}/instances/{instance}");
  private static final PathTemplate RESTART_RESOURCE_NAME_TEMPLATE =
      PathTemplate.create("projects/{project}/instances/{instance}");
  private static final PathTemplate RESTORE_BACKUP_RESOURCE_NAME_TEMPLATE =
      PathTemplate.create("projects/{project}/instances/{instance}");
  private static final PathTemplate ROTATE_SERVER_CA_RESOURCE_NAME_TEMPLATE =
      PathTemplate.create("projects/{project}/instances/{instance}");
  private static final PathTemplate ROTATE_SERVER_CERTIFICATE_RESOURCE_NAME_TEMPLATE =
      PathTemplate.create("projects/{project}/instances/{instance}");
  private static final PathTemplate ROTATE_ENTRA_ID_CERTIFICATE_RESOURCE_NAME_TEMPLATE =
      PathTemplate.create("projects/{project}/instances/{instance}");
  private static final PathTemplate START_REPLICA_RESOURCE_NAME_TEMPLATE =
      PathTemplate.create("projects/{project}/instances/{instance}");
  private static final PathTemplate STOP_REPLICA_RESOURCE_NAME_TEMPLATE =
      PathTemplate.create("projects/{project}/instances/{instance}");
  private static final PathTemplate TRUNCATE_LOG_RESOURCE_NAME_TEMPLATE =
      PathTemplate.create("projects/{project}/instances/{instance}");
  private static final PathTemplate UPDATE_RESOURCE_NAME_TEMPLATE =
      PathTemplate.create("projects/{project}/instances/{instance}");
  private static final PathTemplate CREATE_EPHEMERAL_RESOURCE_NAME_TEMPLATE =
      PathTemplate.create("projects/{project}/instances/{instance}");
  private static final PathTemplate RESCHEDULE_MAINTENANCE_RESOURCE_NAME_TEMPLATE =
      PathTemplate.create("projects/{project}/instances/{instance}");
  private static final PathTemplate VERIFY_EXTERNAL_SYNC_SETTINGS_RESOURCE_NAME_TEMPLATE =
      PathTemplate.create("projects/{project}/instances/{instance}");
  private static final PathTemplate START_EXTERNAL_SYNC_RESOURCE_NAME_TEMPLATE =
      PathTemplate.create("projects/{project}/instances/{instance}");
  private static final PathTemplate PERFORM_DISK_SHRINK_RESOURCE_NAME_TEMPLATE =
      PathTemplate.create("projects/{project}/instances/{instance}");
  private static final PathTemplate GET_DISK_SHRINK_CONFIG_RESOURCE_NAME_TEMPLATE =
      PathTemplate.create("projects/{project}/instances/{instance}");
  private static final PathTemplate RESET_REPLICA_SIZE_RESOURCE_NAME_TEMPLATE =
      PathTemplate.create("projects/{project}/instances/{instance}");
  private static final PathTemplate GET_LATEST_RECOVERY_TIME_RESOURCE_NAME_TEMPLATE =
      PathTemplate.create("projects/{project}/instances/{instance}");
  private static final PathTemplate EXECUTE_SQL_RESOURCE_NAME_TEMPLATE =
      PathTemplate.create("projects/{project}/instances/{instance}");
  private static final PathTemplate ACQUIRE_SSRS_LEASE_RESOURCE_NAME_TEMPLATE =
      PathTemplate.create("projects/{project}/instances/{instance}");
  private static final PathTemplate RELEASE_SSRS_LEASE_RESOURCE_NAME_TEMPLATE =
      PathTemplate.create("projects/{project}/instances/{instance}");
  private static final PathTemplate PRE_CHECK_MAJOR_VERSION_UPGRADE_RESOURCE_NAME_TEMPLATE =
      PathTemplate.create("projects/{project}/instances/{instance}");
  private static final PathTemplate POINT_IN_TIME_RESTORE_RESOURCE_NAME_TEMPLATE =
      PathTemplate.create("{parent=projects/*}");

  public static final GrpcSqlInstancesServiceStub create(SqlInstancesServiceStubSettings settings)
      throws IOException {
    return new GrpcSqlInstancesServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcSqlInstancesServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcSqlInstancesServiceStub(
        SqlInstancesServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcSqlInstancesServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcSqlInstancesServiceStub(
        SqlInstancesServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcSqlInstancesServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcSqlInstancesServiceStub(
      SqlInstancesServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcSqlInstancesServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcSqlInstancesServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcSqlInstancesServiceStub(
      SqlInstancesServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<SqlInstancesAddServerCaRequest, Operation> addServerCaTransportSettings =
        GrpcCallSettings.<SqlInstancesAddServerCaRequest, Operation>newBuilder()
            .setMethodDescriptor(addServerCaMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("instance", String.valueOf(request.getInstance()));
                  builder.add("project", String.valueOf(request.getProject()));
                  return builder.build();
                })
            .setResourceNameExtractor(
                request -> {
                  Map<String, String> resourceNameSegments = new HashMap<String, String>();
                  resourceNameSegments.put("instance", String.valueOf(request.getInstance()));
                  resourceNameSegments.put("project", String.valueOf(request.getProject()));
                  return ADD_SERVER_CA_RESOURCE_NAME_TEMPLATE.instantiate(resourceNameSegments);
                })
            .build();
    GrpcCallSettings<SqlInstancesAddServerCertificateRequest, Operation>
        addServerCertificateTransportSettings =
            GrpcCallSettings.<SqlInstancesAddServerCertificateRequest, Operation>newBuilder()
                .setMethodDescriptor(addServerCertificateMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("instance", String.valueOf(request.getInstance()));
                      builder.add("project", String.valueOf(request.getProject()));
                      return builder.build();
                    })
                .setResourceNameExtractor(
                    request -> {
                      Map<String, String> resourceNameSegments = new HashMap<String, String>();
                      resourceNameSegments.put("instance", String.valueOf(request.getInstance()));
                      resourceNameSegments.put("project", String.valueOf(request.getProject()));
                      return ADD_SERVER_CERTIFICATE_RESOURCE_NAME_TEMPLATE.instantiate(
                          resourceNameSegments);
                    })
                .build();
    GrpcCallSettings<SqlInstancesAddEntraIdCertificateRequest, Operation>
        addEntraIdCertificateTransportSettings =
            GrpcCallSettings.<SqlInstancesAddEntraIdCertificateRequest, Operation>newBuilder()
                .setMethodDescriptor(addEntraIdCertificateMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("instance", String.valueOf(request.getInstance()));
                      builder.add("project", String.valueOf(request.getProject()));
                      return builder.build();
                    })
                .setResourceNameExtractor(
                    request -> {
                      Map<String, String> resourceNameSegments = new HashMap<String, String>();
                      resourceNameSegments.put("instance", String.valueOf(request.getInstance()));
                      resourceNameSegments.put("project", String.valueOf(request.getProject()));
                      return ADD_ENTRA_ID_CERTIFICATE_RESOURCE_NAME_TEMPLATE.instantiate(
                          resourceNameSegments);
                    })
                .build();
    GrpcCallSettings<SqlInstancesCloneRequest, Operation> cloneTransportSettings =
        GrpcCallSettings.<SqlInstancesCloneRequest, Operation>newBuilder()
            .setMethodDescriptor(cloneMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("instance", String.valueOf(request.getInstance()));
                  builder.add("project", String.valueOf(request.getProject()));
                  return builder.build();
                })
            .setResourceNameExtractor(
                request -> {
                  Map<String, String> resourceNameSegments = new HashMap<String, String>();
                  resourceNameSegments.put("instance", String.valueOf(request.getInstance()));
                  resourceNameSegments.put("project", String.valueOf(request.getProject()));
                  return CLONE_RESOURCE_NAME_TEMPLATE.instantiate(resourceNameSegments);
                })
            .build();
    GrpcCallSettings<SqlInstancesDeleteRequest, Operation> deleteTransportSettings =
        GrpcCallSettings.<SqlInstancesDeleteRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("instance", String.valueOf(request.getInstance()));
                  builder.add("project", String.valueOf(request.getProject()));
                  return builder.build();
                })
            .setResourceNameExtractor(
                request -> {
                  Map<String, String> resourceNameSegments = new HashMap<String, String>();
                  resourceNameSegments.put("instance", String.valueOf(request.getInstance()));
                  resourceNameSegments.put("project", String.valueOf(request.getProject()));
                  return DELETE_RESOURCE_NAME_TEMPLATE.instantiate(resourceNameSegments);
                })
            .build();
    GrpcCallSettings<SqlInstancesDemoteMasterRequest, Operation> demoteMasterTransportSettings =
        GrpcCallSettings.<SqlInstancesDemoteMasterRequest, Operation>newBuilder()
            .setMethodDescriptor(demoteMasterMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("instance", String.valueOf(request.getInstance()));
                  builder.add("project", String.valueOf(request.getProject()));
                  return builder.build();
                })
            .setResourceNameExtractor(
                request -> {
                  Map<String, String> resourceNameSegments = new HashMap<String, String>();
                  resourceNameSegments.put("instance", String.valueOf(request.getInstance()));
                  resourceNameSegments.put("project", String.valueOf(request.getProject()));
                  return DEMOTE_MASTER_RESOURCE_NAME_TEMPLATE.instantiate(resourceNameSegments);
                })
            .build();
    GrpcCallSettings<SqlInstancesDemoteRequest, Operation> demoteTransportSettings =
        GrpcCallSettings.<SqlInstancesDemoteRequest, Operation>newBuilder()
            .setMethodDescriptor(demoteMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("instance", String.valueOf(request.getInstance()));
                  builder.add("project", String.valueOf(request.getProject()));
                  return builder.build();
                })
            .setResourceNameExtractor(
                request -> {
                  Map<String, String> resourceNameSegments = new HashMap<String, String>();
                  resourceNameSegments.put("instance", String.valueOf(request.getInstance()));
                  resourceNameSegments.put("project", String.valueOf(request.getProject()));
                  return DEMOTE_RESOURCE_NAME_TEMPLATE.instantiate(resourceNameSegments);
                })
            .build();
    GrpcCallSettings<SqlInstancesExportRequest, Operation> exportTransportSettings =
        GrpcCallSettings.<SqlInstancesExportRequest, Operation>newBuilder()
            .setMethodDescriptor(exportMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("instance", String.valueOf(request.getInstance()));
                  builder.add("project", String.valueOf(request.getProject()));
                  return builder.build();
                })
            .setResourceNameExtractor(
                request -> {
                  Map<String, String> resourceNameSegments = new HashMap<String, String>();
                  resourceNameSegments.put("instance", String.valueOf(request.getInstance()));
                  resourceNameSegments.put("project", String.valueOf(request.getProject()));
                  return EXPORT_RESOURCE_NAME_TEMPLATE.instantiate(resourceNameSegments);
                })
            .build();
    GrpcCallSettings<SqlInstancesFailoverRequest, Operation> failoverTransportSettings =
        GrpcCallSettings.<SqlInstancesFailoverRequest, Operation>newBuilder()
            .setMethodDescriptor(failoverMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("instance", String.valueOf(request.getInstance()));
                  builder.add("project", String.valueOf(request.getProject()));
                  return builder.build();
                })
            .setResourceNameExtractor(
                request -> {
                  Map<String, String> resourceNameSegments = new HashMap<String, String>();
                  resourceNameSegments.put("instance", String.valueOf(request.getInstance()));
                  resourceNameSegments.put("project", String.valueOf(request.getProject()));
                  return FAILOVER_RESOURCE_NAME_TEMPLATE.instantiate(resourceNameSegments);
                })
            .build();
    GrpcCallSettings<SqlInstancesReencryptRequest, Operation> reencryptTransportSettings =
        GrpcCallSettings.<SqlInstancesReencryptRequest, Operation>newBuilder()
            .setMethodDescriptor(reencryptMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("instance", String.valueOf(request.getInstance()));
                  builder.add("project", String.valueOf(request.getProject()));
                  return builder.build();
                })
            .setResourceNameExtractor(
                request -> {
                  Map<String, String> resourceNameSegments = new HashMap<String, String>();
                  resourceNameSegments.put("instance", String.valueOf(request.getInstance()));
                  resourceNameSegments.put("project", String.valueOf(request.getProject()));
                  return REENCRYPT_RESOURCE_NAME_TEMPLATE.instantiate(resourceNameSegments);
                })
            .build();
    GrpcCallSettings<SqlInstancesGetRequest, DatabaseInstance> getTransportSettings =
        GrpcCallSettings.<SqlInstancesGetRequest, DatabaseInstance>newBuilder()
            .setMethodDescriptor(getMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("instance", String.valueOf(request.getInstance()));
                  builder.add("project", String.valueOf(request.getProject()));
                  return builder.build();
                })
            .setResourceNameExtractor(
                request -> {
                  Map<String, String> resourceNameSegments = new HashMap<String, String>();
                  resourceNameSegments.put("instance", String.valueOf(request.getInstance()));
                  resourceNameSegments.put("project", String.valueOf(request.getProject()));
                  return GET_RESOURCE_NAME_TEMPLATE.instantiate(resourceNameSegments);
                })
            .build();
    GrpcCallSettings<SqlInstancesImportRequest, Operation> import_TransportSettings =
        GrpcCallSettings.<SqlInstancesImportRequest, Operation>newBuilder()
            .setMethodDescriptor(import_MethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("instance", String.valueOf(request.getInstance()));
                  builder.add("project", String.valueOf(request.getProject()));
                  return builder.build();
                })
            .setResourceNameExtractor(
                request -> {
                  Map<String, String> resourceNameSegments = new HashMap<String, String>();
                  resourceNameSegments.put("instance", String.valueOf(request.getInstance()));
                  resourceNameSegments.put("project", String.valueOf(request.getProject()));
                  return IMPORT_RESOURCE_NAME_TEMPLATE.instantiate(resourceNameSegments);
                })
            .build();
    GrpcCallSettings<SqlInstancesInsertRequest, Operation> insertTransportSettings =
        GrpcCallSettings.<SqlInstancesInsertRequest, Operation>newBuilder()
            .setMethodDescriptor(insertMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("project", String.valueOf(request.getProject()));
                  return builder.build();
                })
            .setResourceNameExtractor(
                request -> {
                  Map<String, String> resourceNameSegments = new HashMap<String, String>();
                  resourceNameSegments.put("project", String.valueOf(request.getProject()));
                  return INSERT_RESOURCE_NAME_TEMPLATE.instantiate(resourceNameSegments);
                })
            .build();
    GrpcCallSettings<SqlInstancesListRequest, InstancesListResponse> listTransportSettings =
        GrpcCallSettings.<SqlInstancesListRequest, InstancesListResponse>newBuilder()
            .setMethodDescriptor(listMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("project", String.valueOf(request.getProject()));
                  return builder.build();
                })
            .setResourceNameExtractor(
                request -> {
                  Map<String, String> resourceNameSegments = new HashMap<String, String>();
                  resourceNameSegments.put("project", String.valueOf(request.getProject()));
                  return LIST_RESOURCE_NAME_TEMPLATE.instantiate(resourceNameSegments);
                })
            .build();
    GrpcCallSettings<SqlInstancesListServerCasRequest, InstancesListServerCasResponse>
        listServerCasTransportSettings =
            GrpcCallSettings
                .<SqlInstancesListServerCasRequest, InstancesListServerCasResponse>newBuilder()
                .setMethodDescriptor(listServerCasMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("instance", String.valueOf(request.getInstance()));
                      builder.add("project", String.valueOf(request.getProject()));
                      return builder.build();
                    })
                .setResourceNameExtractor(
                    request -> {
                      Map<String, String> resourceNameSegments = new HashMap<String, String>();
                      resourceNameSegments.put("instance", String.valueOf(request.getInstance()));
                      resourceNameSegments.put("project", String.valueOf(request.getProject()));
                      return LIST_SERVER_CAS_RESOURCE_NAME_TEMPLATE.instantiate(
                          resourceNameSegments);
                    })
                .build();
    GrpcCallSettings<
            SqlInstancesListServerCertificatesRequest, InstancesListServerCertificatesResponse>
        listServerCertificatesTransportSettings =
            GrpcCallSettings
                .<SqlInstancesListServerCertificatesRequest,
                    InstancesListServerCertificatesResponse>
                    newBuilder()
                .setMethodDescriptor(listServerCertificatesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("instance", String.valueOf(request.getInstance()));
                      builder.add("project", String.valueOf(request.getProject()));
                      return builder.build();
                    })
                .setResourceNameExtractor(
                    request -> {
                      Map<String, String> resourceNameSegments = new HashMap<String, String>();
                      resourceNameSegments.put("instance", String.valueOf(request.getInstance()));
                      resourceNameSegments.put("project", String.valueOf(request.getProject()));
                      return LIST_SERVER_CERTIFICATES_RESOURCE_NAME_TEMPLATE.instantiate(
                          resourceNameSegments);
                    })
                .build();
    GrpcCallSettings<
            SqlInstancesListEntraIdCertificatesRequest, InstancesListEntraIdCertificatesResponse>
        listEntraIdCertificatesTransportSettings =
            GrpcCallSettings
                .<SqlInstancesListEntraIdCertificatesRequest,
                    InstancesListEntraIdCertificatesResponse>
                    newBuilder()
                .setMethodDescriptor(listEntraIdCertificatesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("instance", String.valueOf(request.getInstance()));
                      builder.add("project", String.valueOf(request.getProject()));
                      return builder.build();
                    })
                .setResourceNameExtractor(
                    request -> {
                      Map<String, String> resourceNameSegments = new HashMap<String, String>();
                      resourceNameSegments.put("instance", String.valueOf(request.getInstance()));
                      resourceNameSegments.put("project", String.valueOf(request.getProject()));
                      return LIST_ENTRA_ID_CERTIFICATES_RESOURCE_NAME_TEMPLATE.instantiate(
                          resourceNameSegments);
                    })
                .build();
    GrpcCallSettings<SqlInstancesPatchRequest, Operation> patchTransportSettings =
        GrpcCallSettings.<SqlInstancesPatchRequest, Operation>newBuilder()
            .setMethodDescriptor(patchMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("instance", String.valueOf(request.getInstance()));
                  builder.add("project", String.valueOf(request.getProject()));
                  return builder.build();
                })
            .setResourceNameExtractor(
                request -> {
                  Map<String, String> resourceNameSegments = new HashMap<String, String>();
                  resourceNameSegments.put("instance", String.valueOf(request.getInstance()));
                  resourceNameSegments.put("project", String.valueOf(request.getProject()));
                  return PATCH_RESOURCE_NAME_TEMPLATE.instantiate(resourceNameSegments);
                })
            .build();
    GrpcCallSettings<SqlInstancesPromoteReplicaRequest, Operation> promoteReplicaTransportSettings =
        GrpcCallSettings.<SqlInstancesPromoteReplicaRequest, Operation>newBuilder()
            .setMethodDescriptor(promoteReplicaMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("instance", String.valueOf(request.getInstance()));
                  builder.add("project", String.valueOf(request.getProject()));
                  return builder.build();
                })
            .setResourceNameExtractor(
                request -> {
                  Map<String, String> resourceNameSegments = new HashMap<String, String>();
                  resourceNameSegments.put("instance", String.valueOf(request.getInstance()));
                  resourceNameSegments.put("project", String.valueOf(request.getProject()));
                  return PROMOTE_REPLICA_RESOURCE_NAME_TEMPLATE.instantiate(resourceNameSegments);
                })
            .build();
    GrpcCallSettings<SqlInstancesSwitchoverRequest, Operation> switchoverTransportSettings =
        GrpcCallSettings.<SqlInstancesSwitchoverRequest, Operation>newBuilder()
            .setMethodDescriptor(switchoverMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("instance", String.valueOf(request.getInstance()));
                  builder.add("project", String.valueOf(request.getProject()));
                  return builder.build();
                })
            .setResourceNameExtractor(
                request -> {
                  Map<String, String> resourceNameSegments = new HashMap<String, String>();
                  resourceNameSegments.put("instance", String.valueOf(request.getInstance()));
                  resourceNameSegments.put("project", String.valueOf(request.getProject()));
                  return SWITCHOVER_RESOURCE_NAME_TEMPLATE.instantiate(resourceNameSegments);
                })
            .build();
    GrpcCallSettings<SqlInstancesResetSslConfigRequest, Operation> resetSslConfigTransportSettings =
        GrpcCallSettings.<SqlInstancesResetSslConfigRequest, Operation>newBuilder()
            .setMethodDescriptor(resetSslConfigMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("instance", String.valueOf(request.getInstance()));
                  builder.add("project", String.valueOf(request.getProject()));
                  return builder.build();
                })
            .setResourceNameExtractor(
                request -> {
                  Map<String, String> resourceNameSegments = new HashMap<String, String>();
                  resourceNameSegments.put("instance", String.valueOf(request.getInstance()));
                  resourceNameSegments.put("project", String.valueOf(request.getProject()));
                  return RESET_SSL_CONFIG_RESOURCE_NAME_TEMPLATE.instantiate(resourceNameSegments);
                })
            .build();
    GrpcCallSettings<SqlInstancesRestartRequest, Operation> restartTransportSettings =
        GrpcCallSettings.<SqlInstancesRestartRequest, Operation>newBuilder()
            .setMethodDescriptor(restartMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("instance", String.valueOf(request.getInstance()));
                  builder.add("project", String.valueOf(request.getProject()));
                  return builder.build();
                })
            .setResourceNameExtractor(
                request -> {
                  Map<String, String> resourceNameSegments = new HashMap<String, String>();
                  resourceNameSegments.put("instance", String.valueOf(request.getInstance()));
                  resourceNameSegments.put("project", String.valueOf(request.getProject()));
                  return RESTART_RESOURCE_NAME_TEMPLATE.instantiate(resourceNameSegments);
                })
            .build();
    GrpcCallSettings<SqlInstancesRestoreBackupRequest, Operation> restoreBackupTransportSettings =
        GrpcCallSettings.<SqlInstancesRestoreBackupRequest, Operation>newBuilder()
            .setMethodDescriptor(restoreBackupMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("instance", String.valueOf(request.getInstance()));
                  builder.add("project", String.valueOf(request.getProject()));
                  return builder.build();
                })
            .setResourceNameExtractor(
                request -> {
                  Map<String, String> resourceNameSegments = new HashMap<String, String>();
                  resourceNameSegments.put("instance", String.valueOf(request.getInstance()));
                  resourceNameSegments.put("project", String.valueOf(request.getProject()));
                  return RESTORE_BACKUP_RESOURCE_NAME_TEMPLATE.instantiate(resourceNameSegments);
                })
            .build();
    GrpcCallSettings<SqlInstancesRotateServerCaRequest, Operation> rotateServerCaTransportSettings =
        GrpcCallSettings.<SqlInstancesRotateServerCaRequest, Operation>newBuilder()
            .setMethodDescriptor(rotateServerCaMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("instance", String.valueOf(request.getInstance()));
                  builder.add("project", String.valueOf(request.getProject()));
                  return builder.build();
                })
            .setResourceNameExtractor(
                request -> {
                  Map<String, String> resourceNameSegments = new HashMap<String, String>();
                  resourceNameSegments.put("instance", String.valueOf(request.getInstance()));
                  resourceNameSegments.put("project", String.valueOf(request.getProject()));
                  return ROTATE_SERVER_CA_RESOURCE_NAME_TEMPLATE.instantiate(resourceNameSegments);
                })
            .build();
    GrpcCallSettings<SqlInstancesRotateServerCertificateRequest, Operation>
        rotateServerCertificateTransportSettings =
            GrpcCallSettings.<SqlInstancesRotateServerCertificateRequest, Operation>newBuilder()
                .setMethodDescriptor(rotateServerCertificateMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("instance", String.valueOf(request.getInstance()));
                      builder.add("project", String.valueOf(request.getProject()));
                      return builder.build();
                    })
                .setResourceNameExtractor(
                    request -> {
                      Map<String, String> resourceNameSegments = new HashMap<String, String>();
                      resourceNameSegments.put("instance", String.valueOf(request.getInstance()));
                      resourceNameSegments.put("project", String.valueOf(request.getProject()));
                      return ROTATE_SERVER_CERTIFICATE_RESOURCE_NAME_TEMPLATE.instantiate(
                          resourceNameSegments);
                    })
                .build();
    GrpcCallSettings<SqlInstancesRotateEntraIdCertificateRequest, Operation>
        rotateEntraIdCertificateTransportSettings =
            GrpcCallSettings.<SqlInstancesRotateEntraIdCertificateRequest, Operation>newBuilder()
                .setMethodDescriptor(rotateEntraIdCertificateMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("instance", String.valueOf(request.getInstance()));
                      builder.add("project", String.valueOf(request.getProject()));
                      return builder.build();
                    })
                .setResourceNameExtractor(
                    request -> {
                      Map<String, String> resourceNameSegments = new HashMap<String, String>();
                      resourceNameSegments.put("instance", String.valueOf(request.getInstance()));
                      resourceNameSegments.put("project", String.valueOf(request.getProject()));
                      return ROTATE_ENTRA_ID_CERTIFICATE_RESOURCE_NAME_TEMPLATE.instantiate(
                          resourceNameSegments);
                    })
                .build();
    GrpcCallSettings<SqlInstancesStartReplicaRequest, Operation> startReplicaTransportSettings =
        GrpcCallSettings.<SqlInstancesStartReplicaRequest, Operation>newBuilder()
            .setMethodDescriptor(startReplicaMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("instance", String.valueOf(request.getInstance()));
                  builder.add("project", String.valueOf(request.getProject()));
                  return builder.build();
                })
            .setResourceNameExtractor(
                request -> {
                  Map<String, String> resourceNameSegments = new HashMap<String, String>();
                  resourceNameSegments.put("instance", String.valueOf(request.getInstance()));
                  resourceNameSegments.put("project", String.valueOf(request.getProject()));
                  return START_REPLICA_RESOURCE_NAME_TEMPLATE.instantiate(resourceNameSegments);
                })
            .build();
    GrpcCallSettings<SqlInstancesStopReplicaRequest, Operation> stopReplicaTransportSettings =
        GrpcCallSettings.<SqlInstancesStopReplicaRequest, Operation>newBuilder()
            .setMethodDescriptor(stopReplicaMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("instance", String.valueOf(request.getInstance()));
                  builder.add("project", String.valueOf(request.getProject()));
                  return builder.build();
                })
            .setResourceNameExtractor(
                request -> {
                  Map<String, String> resourceNameSegments = new HashMap<String, String>();
                  resourceNameSegments.put("instance", String.valueOf(request.getInstance()));
                  resourceNameSegments.put("project", String.valueOf(request.getProject()));
                  return STOP_REPLICA_RESOURCE_NAME_TEMPLATE.instantiate(resourceNameSegments);
                })
            .build();
    GrpcCallSettings<SqlInstancesTruncateLogRequest, Operation> truncateLogTransportSettings =
        GrpcCallSettings.<SqlInstancesTruncateLogRequest, Operation>newBuilder()
            .setMethodDescriptor(truncateLogMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("instance", String.valueOf(request.getInstance()));
                  builder.add("project", String.valueOf(request.getProject()));
                  return builder.build();
                })
            .setResourceNameExtractor(
                request -> {
                  Map<String, String> resourceNameSegments = new HashMap<String, String>();
                  resourceNameSegments.put("instance", String.valueOf(request.getInstance()));
                  resourceNameSegments.put("project", String.valueOf(request.getProject()));
                  return TRUNCATE_LOG_RESOURCE_NAME_TEMPLATE.instantiate(resourceNameSegments);
                })
            .build();
    GrpcCallSettings<SqlInstancesUpdateRequest, Operation> updateTransportSettings =
        GrpcCallSettings.<SqlInstancesUpdateRequest, Operation>newBuilder()
            .setMethodDescriptor(updateMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("instance", String.valueOf(request.getInstance()));
                  builder.add("project", String.valueOf(request.getProject()));
                  return builder.build();
                })
            .setResourceNameExtractor(
                request -> {
                  Map<String, String> resourceNameSegments = new HashMap<String, String>();
                  resourceNameSegments.put("instance", String.valueOf(request.getInstance()));
                  resourceNameSegments.put("project", String.valueOf(request.getProject()));
                  return UPDATE_RESOURCE_NAME_TEMPLATE.instantiate(resourceNameSegments);
                })
            .build();
    GrpcCallSettings<SqlInstancesCreateEphemeralCertRequest, SslCert>
        createEphemeralTransportSettings =
            GrpcCallSettings.<SqlInstancesCreateEphemeralCertRequest, SslCert>newBuilder()
                .setMethodDescriptor(createEphemeralMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("instance", String.valueOf(request.getInstance()));
                      builder.add("project", String.valueOf(request.getProject()));
                      return builder.build();
                    })
                .setResourceNameExtractor(
                    request -> {
                      Map<String, String> resourceNameSegments = new HashMap<String, String>();
                      resourceNameSegments.put("instance", String.valueOf(request.getInstance()));
                      resourceNameSegments.put("project", String.valueOf(request.getProject()));
                      return CREATE_EPHEMERAL_RESOURCE_NAME_TEMPLATE.instantiate(
                          resourceNameSegments);
                    })
                .build();
    GrpcCallSettings<SqlInstancesRescheduleMaintenanceRequest, Operation>
        rescheduleMaintenanceTransportSettings =
            GrpcCallSettings.<SqlInstancesRescheduleMaintenanceRequest, Operation>newBuilder()
                .setMethodDescriptor(rescheduleMaintenanceMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("instance", String.valueOf(request.getInstance()));
                      builder.add("project", String.valueOf(request.getProject()));
                      return builder.build();
                    })
                .setResourceNameExtractor(
                    request -> {
                      Map<String, String> resourceNameSegments = new HashMap<String, String>();
                      resourceNameSegments.put("instance", String.valueOf(request.getInstance()));
                      resourceNameSegments.put("project", String.valueOf(request.getProject()));
                      return RESCHEDULE_MAINTENANCE_RESOURCE_NAME_TEMPLATE.instantiate(
                          resourceNameSegments);
                    })
                .build();
    GrpcCallSettings<
            SqlInstancesVerifyExternalSyncSettingsRequest,
            SqlInstancesVerifyExternalSyncSettingsResponse>
        verifyExternalSyncSettingsTransportSettings =
            GrpcCallSettings
                .<SqlInstancesVerifyExternalSyncSettingsRequest,
                    SqlInstancesVerifyExternalSyncSettingsResponse>
                    newBuilder()
                .setMethodDescriptor(verifyExternalSyncSettingsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("instance", String.valueOf(request.getInstance()));
                      builder.add("project", String.valueOf(request.getProject()));
                      return builder.build();
                    })
                .setResourceNameExtractor(
                    request -> {
                      Map<String, String> resourceNameSegments = new HashMap<String, String>();
                      resourceNameSegments.put("instance", String.valueOf(request.getInstance()));
                      resourceNameSegments.put("project", String.valueOf(request.getProject()));
                      return VERIFY_EXTERNAL_SYNC_SETTINGS_RESOURCE_NAME_TEMPLATE.instantiate(
                          resourceNameSegments);
                    })
                .build();
    GrpcCallSettings<SqlInstancesStartExternalSyncRequest, Operation>
        startExternalSyncTransportSettings =
            GrpcCallSettings.<SqlInstancesStartExternalSyncRequest, Operation>newBuilder()
                .setMethodDescriptor(startExternalSyncMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("instance", String.valueOf(request.getInstance()));
                      builder.add("project", String.valueOf(request.getProject()));
                      return builder.build();
                    })
                .setResourceNameExtractor(
                    request -> {
                      Map<String, String> resourceNameSegments = new HashMap<String, String>();
                      resourceNameSegments.put("instance", String.valueOf(request.getInstance()));
                      resourceNameSegments.put("project", String.valueOf(request.getProject()));
                      return START_EXTERNAL_SYNC_RESOURCE_NAME_TEMPLATE.instantiate(
                          resourceNameSegments);
                    })
                .build();
    GrpcCallSettings<SqlInstancesPerformDiskShrinkRequest, Operation>
        performDiskShrinkTransportSettings =
            GrpcCallSettings.<SqlInstancesPerformDiskShrinkRequest, Operation>newBuilder()
                .setMethodDescriptor(performDiskShrinkMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("instance", String.valueOf(request.getInstance()));
                      builder.add("project", String.valueOf(request.getProject()));
                      return builder.build();
                    })
                .setResourceNameExtractor(
                    request -> {
                      Map<String, String> resourceNameSegments = new HashMap<String, String>();
                      resourceNameSegments.put("instance", String.valueOf(request.getInstance()));
                      resourceNameSegments.put("project", String.valueOf(request.getProject()));
                      return PERFORM_DISK_SHRINK_RESOURCE_NAME_TEMPLATE.instantiate(
                          resourceNameSegments);
                    })
                .build();
    GrpcCallSettings<
            SqlInstancesGetDiskShrinkConfigRequest, SqlInstancesGetDiskShrinkConfigResponse>
        getDiskShrinkConfigTransportSettings =
            GrpcCallSettings
                .<SqlInstancesGetDiskShrinkConfigRequest, SqlInstancesGetDiskShrinkConfigResponse>
                    newBuilder()
                .setMethodDescriptor(getDiskShrinkConfigMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("instance", String.valueOf(request.getInstance()));
                      builder.add("project", String.valueOf(request.getProject()));
                      return builder.build();
                    })
                .setResourceNameExtractor(
                    request -> {
                      Map<String, String> resourceNameSegments = new HashMap<String, String>();
                      resourceNameSegments.put("instance", String.valueOf(request.getInstance()));
                      resourceNameSegments.put("project", String.valueOf(request.getProject()));
                      return GET_DISK_SHRINK_CONFIG_RESOURCE_NAME_TEMPLATE.instantiate(
                          resourceNameSegments);
                    })
                .build();
    GrpcCallSettings<SqlInstancesResetReplicaSizeRequest, Operation>
        resetReplicaSizeTransportSettings =
            GrpcCallSettings.<SqlInstancesResetReplicaSizeRequest, Operation>newBuilder()
                .setMethodDescriptor(resetReplicaSizeMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("instance", String.valueOf(request.getInstance()));
                      builder.add("project", String.valueOf(request.getProject()));
                      return builder.build();
                    })
                .setResourceNameExtractor(
                    request -> {
                      Map<String, String> resourceNameSegments = new HashMap<String, String>();
                      resourceNameSegments.put("instance", String.valueOf(request.getInstance()));
                      resourceNameSegments.put("project", String.valueOf(request.getProject()));
                      return RESET_REPLICA_SIZE_RESOURCE_NAME_TEMPLATE.instantiate(
                          resourceNameSegments);
                    })
                .build();
    GrpcCallSettings<
            SqlInstancesGetLatestRecoveryTimeRequest, SqlInstancesGetLatestRecoveryTimeResponse>
        getLatestRecoveryTimeTransportSettings =
            GrpcCallSettings
                .<SqlInstancesGetLatestRecoveryTimeRequest,
                    SqlInstancesGetLatestRecoveryTimeResponse>
                    newBuilder()
                .setMethodDescriptor(getLatestRecoveryTimeMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("instance", String.valueOf(request.getInstance()));
                      builder.add("project", String.valueOf(request.getProject()));
                      return builder.build();
                    })
                .setResourceNameExtractor(
                    request -> {
                      Map<String, String> resourceNameSegments = new HashMap<String, String>();
                      resourceNameSegments.put("instance", String.valueOf(request.getInstance()));
                      resourceNameSegments.put("project", String.valueOf(request.getProject()));
                      return GET_LATEST_RECOVERY_TIME_RESOURCE_NAME_TEMPLATE.instantiate(
                          resourceNameSegments);
                    })
                .build();
    GrpcCallSettings<SqlInstancesExecuteSqlRequest, SqlInstancesExecuteSqlResponse>
        executeSqlTransportSettings =
            GrpcCallSettings
                .<SqlInstancesExecuteSqlRequest, SqlInstancesExecuteSqlResponse>newBuilder()
                .setMethodDescriptor(executeSqlMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("instance", String.valueOf(request.getInstance()));
                      builder.add("project", String.valueOf(request.getProject()));
                      return builder.build();
                    })
                .setResourceNameExtractor(
                    request -> {
                      Map<String, String> resourceNameSegments = new HashMap<String, String>();
                      resourceNameSegments.put("instance", String.valueOf(request.getInstance()));
                      resourceNameSegments.put("project", String.valueOf(request.getProject()));
                      return EXECUTE_SQL_RESOURCE_NAME_TEMPLATE.instantiate(resourceNameSegments);
                    })
                .build();
    GrpcCallSettings<SqlInstancesAcquireSsrsLeaseRequest, SqlInstancesAcquireSsrsLeaseResponse>
        acquireSsrsLeaseTransportSettings =
            GrpcCallSettings
                .<SqlInstancesAcquireSsrsLeaseRequest, SqlInstancesAcquireSsrsLeaseResponse>
                    newBuilder()
                .setMethodDescriptor(acquireSsrsLeaseMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("instance", String.valueOf(request.getInstance()));
                      builder.add("project", String.valueOf(request.getProject()));
                      return builder.build();
                    })
                .setResourceNameExtractor(
                    request -> {
                      Map<String, String> resourceNameSegments = new HashMap<String, String>();
                      resourceNameSegments.put("instance", String.valueOf(request.getInstance()));
                      resourceNameSegments.put("project", String.valueOf(request.getProject()));
                      return ACQUIRE_SSRS_LEASE_RESOURCE_NAME_TEMPLATE.instantiate(
                          resourceNameSegments);
                    })
                .build();
    GrpcCallSettings<SqlInstancesReleaseSsrsLeaseRequest, SqlInstancesReleaseSsrsLeaseResponse>
        releaseSsrsLeaseTransportSettings =
            GrpcCallSettings
                .<SqlInstancesReleaseSsrsLeaseRequest, SqlInstancesReleaseSsrsLeaseResponse>
                    newBuilder()
                .setMethodDescriptor(releaseSsrsLeaseMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("instance", String.valueOf(request.getInstance()));
                      builder.add("project", String.valueOf(request.getProject()));
                      return builder.build();
                    })
                .setResourceNameExtractor(
                    request -> {
                      Map<String, String> resourceNameSegments = new HashMap<String, String>();
                      resourceNameSegments.put("instance", String.valueOf(request.getInstance()));
                      resourceNameSegments.put("project", String.valueOf(request.getProject()));
                      return RELEASE_SSRS_LEASE_RESOURCE_NAME_TEMPLATE.instantiate(
                          resourceNameSegments);
                    })
                .build();
    GrpcCallSettings<SqlInstancesPreCheckMajorVersionUpgradeRequest, Operation>
        preCheckMajorVersionUpgradeTransportSettings =
            GrpcCallSettings.<SqlInstancesPreCheckMajorVersionUpgradeRequest, Operation>newBuilder()
                .setMethodDescriptor(preCheckMajorVersionUpgradeMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("instance", String.valueOf(request.getInstance()));
                      builder.add("project", String.valueOf(request.getProject()));
                      return builder.build();
                    })
                .setResourceNameExtractor(
                    request -> {
                      Map<String, String> resourceNameSegments = new HashMap<String, String>();
                      resourceNameSegments.put("instance", String.valueOf(request.getInstance()));
                      resourceNameSegments.put("project", String.valueOf(request.getProject()));
                      return PRE_CHECK_MAJOR_VERSION_UPGRADE_RESOURCE_NAME_TEMPLATE.instantiate(
                          resourceNameSegments);
                    })
                .build();
    GrpcCallSettings<SqlInstancesPointInTimeRestoreRequest, Operation>
        pointInTimeRestoreTransportSettings =
            GrpcCallSettings.<SqlInstancesPointInTimeRestoreRequest, Operation>newBuilder()
                .setMethodDescriptor(pointInTimeRestoreMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(
                    request -> {
                      Map<String, String> resourceNameSegments = new HashMap<String, String>();
                      resourceNameSegments.put("parent", String.valueOf(request.getParent()));
                      return POINT_IN_TIME_RESTORE_RESOURCE_NAME_TEMPLATE.instantiate(
                          resourceNameSegments);
                    })
                .build();

    this.addServerCaCallable =
        callableFactory.createUnaryCallable(
            addServerCaTransportSettings, settings.addServerCaSettings(), clientContext);
    this.addServerCertificateCallable =
        callableFactory.createUnaryCallable(
            addServerCertificateTransportSettings,
            settings.addServerCertificateSettings(),
            clientContext);
    this.addEntraIdCertificateCallable =
        callableFactory.createUnaryCallable(
            addEntraIdCertificateTransportSettings,
            settings.addEntraIdCertificateSettings(),
            clientContext);
    this.cloneCallable =
        callableFactory.createUnaryCallable(
            cloneTransportSettings, settings.cloneSettings(), clientContext);
    this.deleteCallable =
        callableFactory.createUnaryCallable(
            deleteTransportSettings, settings.deleteSettings(), clientContext);
    this.demoteMasterCallable =
        callableFactory.createUnaryCallable(
            demoteMasterTransportSettings, settings.demoteMasterSettings(), clientContext);
    this.demoteCallable =
        callableFactory.createUnaryCallable(
            demoteTransportSettings, settings.demoteSettings(), clientContext);
    this.exportCallable =
        callableFactory.createUnaryCallable(
            exportTransportSettings, settings.exportSettings(), clientContext);
    this.failoverCallable =
        callableFactory.createUnaryCallable(
            failoverTransportSettings, settings.failoverSettings(), clientContext);
    this.reencryptCallable =
        callableFactory.createUnaryCallable(
            reencryptTransportSettings, settings.reencryptSettings(), clientContext);
    this.getCallable =
        callableFactory.createUnaryCallable(
            getTransportSettings, settings.getSettings(), clientContext);
    this.import_Callable =
        callableFactory.createUnaryCallable(
            import_TransportSettings, settings.import_Settings(), clientContext);
    this.insertCallable =
        callableFactory.createUnaryCallable(
            insertTransportSettings, settings.insertSettings(), clientContext);
    this.listCallable =
        callableFactory.createUnaryCallable(
            listTransportSettings, settings.listSettings(), clientContext);
    this.listServerCasCallable =
        callableFactory.createUnaryCallable(
            listServerCasTransportSettings, settings.listServerCasSettings(), clientContext);
    this.listServerCertificatesCallable =
        callableFactory.createUnaryCallable(
            listServerCertificatesTransportSettings,
            settings.listServerCertificatesSettings(),
            clientContext);
    this.listEntraIdCertificatesCallable =
        callableFactory.createUnaryCallable(
            listEntraIdCertificatesTransportSettings,
            settings.listEntraIdCertificatesSettings(),
            clientContext);
    this.patchCallable =
        callableFactory.createUnaryCallable(
            patchTransportSettings, settings.patchSettings(), clientContext);
    this.promoteReplicaCallable =
        callableFactory.createUnaryCallable(
            promoteReplicaTransportSettings, settings.promoteReplicaSettings(), clientContext);
    this.switchoverCallable =
        callableFactory.createUnaryCallable(
            switchoverTransportSettings, settings.switchoverSettings(), clientContext);
    this.resetSslConfigCallable =
        callableFactory.createUnaryCallable(
            resetSslConfigTransportSettings, settings.resetSslConfigSettings(), clientContext);
    this.restartCallable =
        callableFactory.createUnaryCallable(
            restartTransportSettings, settings.restartSettings(), clientContext);
    this.restoreBackupCallable =
        callableFactory.createUnaryCallable(
            restoreBackupTransportSettings, settings.restoreBackupSettings(), clientContext);
    this.rotateServerCaCallable =
        callableFactory.createUnaryCallable(
            rotateServerCaTransportSettings, settings.rotateServerCaSettings(), clientContext);
    this.rotateServerCertificateCallable =
        callableFactory.createUnaryCallable(
            rotateServerCertificateTransportSettings,
            settings.rotateServerCertificateSettings(),
            clientContext);
    this.rotateEntraIdCertificateCallable =
        callableFactory.createUnaryCallable(
            rotateEntraIdCertificateTransportSettings,
            settings.rotateEntraIdCertificateSettings(),
            clientContext);
    this.startReplicaCallable =
        callableFactory.createUnaryCallable(
            startReplicaTransportSettings, settings.startReplicaSettings(), clientContext);
    this.stopReplicaCallable =
        callableFactory.createUnaryCallable(
            stopReplicaTransportSettings, settings.stopReplicaSettings(), clientContext);
    this.truncateLogCallable =
        callableFactory.createUnaryCallable(
            truncateLogTransportSettings, settings.truncateLogSettings(), clientContext);
    this.updateCallable =
        callableFactory.createUnaryCallable(
            updateTransportSettings, settings.updateSettings(), clientContext);
    this.createEphemeralCallable =
        callableFactory.createUnaryCallable(
            createEphemeralTransportSettings, settings.createEphemeralSettings(), clientContext);
    this.rescheduleMaintenanceCallable =
        callableFactory.createUnaryCallable(
            rescheduleMaintenanceTransportSettings,
            settings.rescheduleMaintenanceSettings(),
            clientContext);
    this.verifyExternalSyncSettingsCallable =
        callableFactory.createUnaryCallable(
            verifyExternalSyncSettingsTransportSettings,
            settings.verifyExternalSyncSettingsSettings(),
            clientContext);
    this.startExternalSyncCallable =
        callableFactory.createUnaryCallable(
            startExternalSyncTransportSettings,
            settings.startExternalSyncSettings(),
            clientContext);
    this.performDiskShrinkCallable =
        callableFactory.createUnaryCallable(
            performDiskShrinkTransportSettings,
            settings.performDiskShrinkSettings(),
            clientContext);
    this.getDiskShrinkConfigCallable =
        callableFactory.createUnaryCallable(
            getDiskShrinkConfigTransportSettings,
            settings.getDiskShrinkConfigSettings(),
            clientContext);
    this.resetReplicaSizeCallable =
        callableFactory.createUnaryCallable(
            resetReplicaSizeTransportSettings, settings.resetReplicaSizeSettings(), clientContext);
    this.getLatestRecoveryTimeCallable =
        callableFactory.createUnaryCallable(
            getLatestRecoveryTimeTransportSettings,
            settings.getLatestRecoveryTimeSettings(),
            clientContext);
    this.executeSqlCallable =
        callableFactory.createUnaryCallable(
            executeSqlTransportSettings, settings.executeSqlSettings(), clientContext);
    this.acquireSsrsLeaseCallable =
        callableFactory.createUnaryCallable(
            acquireSsrsLeaseTransportSettings, settings.acquireSsrsLeaseSettings(), clientContext);
    this.releaseSsrsLeaseCallable =
        callableFactory.createUnaryCallable(
            releaseSsrsLeaseTransportSettings, settings.releaseSsrsLeaseSettings(), clientContext);
    this.preCheckMajorVersionUpgradeCallable =
        callableFactory.createUnaryCallable(
            preCheckMajorVersionUpgradeTransportSettings,
            settings.preCheckMajorVersionUpgradeSettings(),
            clientContext);
    this.pointInTimeRestoreCallable =
        callableFactory.createUnaryCallable(
            pointInTimeRestoreTransportSettings,
            settings.pointInTimeRestoreSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<SqlInstancesAddServerCaRequest, Operation> addServerCaCallable() {
    return addServerCaCallable;
  }

  @Override
  public UnaryCallable<SqlInstancesAddServerCertificateRequest, Operation>
      addServerCertificateCallable() {
    return addServerCertificateCallable;
  }

  @Override
  public UnaryCallable<SqlInstancesAddEntraIdCertificateRequest, Operation>
      addEntraIdCertificateCallable() {
    return addEntraIdCertificateCallable;
  }

  @Override
  public UnaryCallable<SqlInstancesCloneRequest, Operation> cloneCallable() {
    return cloneCallable;
  }

  @Override
  public UnaryCallable<SqlInstancesDeleteRequest, Operation> deleteCallable() {
    return deleteCallable;
  }

  @Override
  public UnaryCallable<SqlInstancesDemoteMasterRequest, Operation> demoteMasterCallable() {
    return demoteMasterCallable;
  }

  @Override
  public UnaryCallable<SqlInstancesDemoteRequest, Operation> demoteCallable() {
    return demoteCallable;
  }

  @Override
  public UnaryCallable<SqlInstancesExportRequest, Operation> exportCallable() {
    return exportCallable;
  }

  @Override
  public UnaryCallable<SqlInstancesFailoverRequest, Operation> failoverCallable() {
    return failoverCallable;
  }

  @Override
  public UnaryCallable<SqlInstancesReencryptRequest, Operation> reencryptCallable() {
    return reencryptCallable;
  }

  @Override
  public UnaryCallable<SqlInstancesGetRequest, DatabaseInstance> getCallable() {
    return getCallable;
  }

  @Override
  public UnaryCallable<SqlInstancesImportRequest, Operation> import_Callable() {
    return import_Callable;
  }

  @Override
  public UnaryCallable<SqlInstancesInsertRequest, Operation> insertCallable() {
    return insertCallable;
  }

  @Override
  public UnaryCallable<SqlInstancesListRequest, InstancesListResponse> listCallable() {
    return listCallable;
  }

  @Override
  public UnaryCallable<SqlInstancesListServerCasRequest, InstancesListServerCasResponse>
      listServerCasCallable() {
    return listServerCasCallable;
  }

  @Override
  public UnaryCallable<
          SqlInstancesListServerCertificatesRequest, InstancesListServerCertificatesResponse>
      listServerCertificatesCallable() {
    return listServerCertificatesCallable;
  }

  @Override
  public UnaryCallable<
          SqlInstancesListEntraIdCertificatesRequest, InstancesListEntraIdCertificatesResponse>
      listEntraIdCertificatesCallable() {
    return listEntraIdCertificatesCallable;
  }

  @Override
  public UnaryCallable<SqlInstancesPatchRequest, Operation> patchCallable() {
    return patchCallable;
  }

  @Override
  public UnaryCallable<SqlInstancesPromoteReplicaRequest, Operation> promoteReplicaCallable() {
    return promoteReplicaCallable;
  }

  @Override
  public UnaryCallable<SqlInstancesSwitchoverRequest, Operation> switchoverCallable() {
    return switchoverCallable;
  }

  @Override
  public UnaryCallable<SqlInstancesResetSslConfigRequest, Operation> resetSslConfigCallable() {
    return resetSslConfigCallable;
  }

  @Override
  public UnaryCallable<SqlInstancesRestartRequest, Operation> restartCallable() {
    return restartCallable;
  }

  @Override
  public UnaryCallable<SqlInstancesRestoreBackupRequest, Operation> restoreBackupCallable() {
    return restoreBackupCallable;
  }

  @Override
  public UnaryCallable<SqlInstancesRotateServerCaRequest, Operation> rotateServerCaCallable() {
    return rotateServerCaCallable;
  }

  @Override
  public UnaryCallable<SqlInstancesRotateServerCertificateRequest, Operation>
      rotateServerCertificateCallable() {
    return rotateServerCertificateCallable;
  }

  @Override
  public UnaryCallable<SqlInstancesRotateEntraIdCertificateRequest, Operation>
      rotateEntraIdCertificateCallable() {
    return rotateEntraIdCertificateCallable;
  }

  @Override
  public UnaryCallable<SqlInstancesStartReplicaRequest, Operation> startReplicaCallable() {
    return startReplicaCallable;
  }

  @Override
  public UnaryCallable<SqlInstancesStopReplicaRequest, Operation> stopReplicaCallable() {
    return stopReplicaCallable;
  }

  @Override
  public UnaryCallable<SqlInstancesTruncateLogRequest, Operation> truncateLogCallable() {
    return truncateLogCallable;
  }

  @Override
  public UnaryCallable<SqlInstancesUpdateRequest, Operation> updateCallable() {
    return updateCallable;
  }

  @Override
  public UnaryCallable<SqlInstancesCreateEphemeralCertRequest, SslCert> createEphemeralCallable() {
    return createEphemeralCallable;
  }

  @Override
  public UnaryCallable<SqlInstancesRescheduleMaintenanceRequest, Operation>
      rescheduleMaintenanceCallable() {
    return rescheduleMaintenanceCallable;
  }

  @Override
  public UnaryCallable<
          SqlInstancesVerifyExternalSyncSettingsRequest,
          SqlInstancesVerifyExternalSyncSettingsResponse>
      verifyExternalSyncSettingsCallable() {
    return verifyExternalSyncSettingsCallable;
  }

  @Override
  public UnaryCallable<SqlInstancesStartExternalSyncRequest, Operation>
      startExternalSyncCallable() {
    return startExternalSyncCallable;
  }

  @Override
  public UnaryCallable<SqlInstancesPerformDiskShrinkRequest, Operation>
      performDiskShrinkCallable() {
    return performDiskShrinkCallable;
  }

  @Override
  public UnaryCallable<
          SqlInstancesGetDiskShrinkConfigRequest, SqlInstancesGetDiskShrinkConfigResponse>
      getDiskShrinkConfigCallable() {
    return getDiskShrinkConfigCallable;
  }

  @Override
  public UnaryCallable<SqlInstancesResetReplicaSizeRequest, Operation> resetReplicaSizeCallable() {
    return resetReplicaSizeCallable;
  }

  @Override
  public UnaryCallable<
          SqlInstancesGetLatestRecoveryTimeRequest, SqlInstancesGetLatestRecoveryTimeResponse>
      getLatestRecoveryTimeCallable() {
    return getLatestRecoveryTimeCallable;
  }

  @Override
  public UnaryCallable<SqlInstancesExecuteSqlRequest, SqlInstancesExecuteSqlResponse>
      executeSqlCallable() {
    return executeSqlCallable;
  }

  @Override
  public UnaryCallable<SqlInstancesAcquireSsrsLeaseRequest, SqlInstancesAcquireSsrsLeaseResponse>
      acquireSsrsLeaseCallable() {
    return acquireSsrsLeaseCallable;
  }

  @Override
  public UnaryCallable<SqlInstancesReleaseSsrsLeaseRequest, SqlInstancesReleaseSsrsLeaseResponse>
      releaseSsrsLeaseCallable() {
    return releaseSsrsLeaseCallable;
  }

  @Override
  public UnaryCallable<SqlInstancesPreCheckMajorVersionUpgradeRequest, Operation>
      preCheckMajorVersionUpgradeCallable() {
    return preCheckMajorVersionUpgradeCallable;
  }

  @Override
  public UnaryCallable<SqlInstancesPointInTimeRestoreRequest, Operation>
      pointInTimeRestoreCallable() {
    return pointInTimeRestoreCallable;
  }

  @Override
  public final void close() {
    try {
      backgroundResources.close();
    } catch (RuntimeException e) {
      throw e;
    } catch (Exception e) {
      throw new IllegalStateException("Failed to close resource", e);
    }
  }

  @Override
  public void shutdown() {
    backgroundResources.shutdown();
  }

  @Override
  public boolean isShutdown() {
    return backgroundResources.isShutdown();
  }

  @Override
  public boolean isTerminated() {
    return backgroundResources.isTerminated();
  }

  @Override
  public void shutdownNow() {
    backgroundResources.shutdownNow();
  }

  @Override
  public boolean awaitTermination(long duration, TimeUnit unit) throws InterruptedException {
    return backgroundResources.awaitTermination(duration, unit);
  }
}
