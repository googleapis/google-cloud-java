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

import com.google.api.core.ApiFunction;
import com.google.api.core.BetaApi;
import com.google.api.core.ObsoleteApi;
import com.google.api.gax.core.GaxProperties;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.GrpcTransportChannel;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.HttpJsonTransportChannel;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.LibraryMetadata;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.StubSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
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
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link SqlInstancesServiceStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (sqladmin.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the
 * [RetrySettings](https://cloud.google.com/java/docs/reference/gax/latest/com.google.api.gax.retrying.RetrySettings)
 * of addServerCa:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * SqlInstancesServiceStubSettings.Builder sqlInstancesServiceSettingsBuilder =
 *     SqlInstancesServiceStubSettings.newBuilder();
 * sqlInstancesServiceSettingsBuilder
 *     .addServerCaSettings()
 *     .setRetrySettings(
 *         sqlInstancesServiceSettingsBuilder
 *             .addServerCaSettings()
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
 * SqlInstancesServiceStubSettings sqlInstancesServiceSettings =
 *     sqlInstancesServiceSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://docs.cloud.google.com/java/docs/client-retries) for additional support in setting
 * retries.
 */
@NullMarked
@BetaApi
@Generated("by gapic-generator-java")
@SuppressWarnings("CanonicalDuration")
public class SqlInstancesServiceStubSettings extends StubSettings<SqlInstancesServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder()
          .add("https://www.googleapis.com/auth/cloud-platform")
          .add("https://www.googleapis.com/auth/sqlservice.admin")
          .build();

  private final UnaryCallSettings<SqlInstancesAddServerCaRequest, Operation> addServerCaSettings;
  private final UnaryCallSettings<SqlInstancesAddServerCertificateRequest, Operation>
      addServerCertificateSettings;
  private final UnaryCallSettings<SqlInstancesAddEntraIdCertificateRequest, Operation>
      addEntraIdCertificateSettings;
  private final UnaryCallSettings<SqlInstancesCloneRequest, Operation> cloneSettings;
  private final UnaryCallSettings<SqlInstancesDeleteRequest, Operation> deleteSettings;
  private final UnaryCallSettings<SqlInstancesDemoteMasterRequest, Operation> demoteMasterSettings;
  private final UnaryCallSettings<SqlInstancesDemoteRequest, Operation> demoteSettings;
  private final UnaryCallSettings<SqlInstancesExportRequest, Operation> exportSettings;
  private final UnaryCallSettings<SqlInstancesFailoverRequest, Operation> failoverSettings;
  private final UnaryCallSettings<SqlInstancesReencryptRequest, Operation> reencryptSettings;
  private final UnaryCallSettings<SqlInstancesGetRequest, DatabaseInstance> getSettings;
  private final UnaryCallSettings<SqlInstancesImportRequest, Operation> import_Settings;
  private final UnaryCallSettings<SqlInstancesInsertRequest, Operation> insertSettings;
  private final UnaryCallSettings<SqlInstancesListRequest, InstancesListResponse> listSettings;
  private final UnaryCallSettings<SqlInstancesListServerCasRequest, InstancesListServerCasResponse>
      listServerCasSettings;
  private final UnaryCallSettings<
          SqlInstancesListServerCertificatesRequest, InstancesListServerCertificatesResponse>
      listServerCertificatesSettings;
  private final UnaryCallSettings<
          SqlInstancesListEntraIdCertificatesRequest, InstancesListEntraIdCertificatesResponse>
      listEntraIdCertificatesSettings;
  private final UnaryCallSettings<SqlInstancesPatchRequest, Operation> patchSettings;
  private final UnaryCallSettings<SqlInstancesPromoteReplicaRequest, Operation>
      promoteReplicaSettings;
  private final UnaryCallSettings<SqlInstancesSwitchoverRequest, Operation> switchoverSettings;
  private final UnaryCallSettings<SqlInstancesResetSslConfigRequest, Operation>
      resetSslConfigSettings;
  private final UnaryCallSettings<SqlInstancesRestartRequest, Operation> restartSettings;
  private final UnaryCallSettings<SqlInstancesRestoreBackupRequest, Operation>
      restoreBackupSettings;
  private final UnaryCallSettings<SqlInstancesRotateServerCaRequest, Operation>
      rotateServerCaSettings;
  private final UnaryCallSettings<SqlInstancesRotateServerCertificateRequest, Operation>
      rotateServerCertificateSettings;
  private final UnaryCallSettings<SqlInstancesRotateEntraIdCertificateRequest, Operation>
      rotateEntraIdCertificateSettings;
  private final UnaryCallSettings<SqlInstancesStartReplicaRequest, Operation> startReplicaSettings;
  private final UnaryCallSettings<SqlInstancesStopReplicaRequest, Operation> stopReplicaSettings;
  private final UnaryCallSettings<SqlInstancesTruncateLogRequest, Operation> truncateLogSettings;
  private final UnaryCallSettings<SqlInstancesUpdateRequest, Operation> updateSettings;
  private final UnaryCallSettings<SqlInstancesCreateEphemeralCertRequest, SslCert>
      createEphemeralSettings;
  private final UnaryCallSettings<SqlInstancesRescheduleMaintenanceRequest, Operation>
      rescheduleMaintenanceSettings;
  private final UnaryCallSettings<
          SqlInstancesVerifyExternalSyncSettingsRequest,
          SqlInstancesVerifyExternalSyncSettingsResponse>
      verifyExternalSyncSettingsSettings;
  private final UnaryCallSettings<SqlInstancesStartExternalSyncRequest, Operation>
      startExternalSyncSettings;
  private final UnaryCallSettings<SqlInstancesPerformDiskShrinkRequest, Operation>
      performDiskShrinkSettings;
  private final UnaryCallSettings<
          SqlInstancesGetDiskShrinkConfigRequest, SqlInstancesGetDiskShrinkConfigResponse>
      getDiskShrinkConfigSettings;
  private final UnaryCallSettings<SqlInstancesResetReplicaSizeRequest, Operation>
      resetReplicaSizeSettings;
  private final UnaryCallSettings<
          SqlInstancesGetLatestRecoveryTimeRequest, SqlInstancesGetLatestRecoveryTimeResponse>
      getLatestRecoveryTimeSettings;
  private final UnaryCallSettings<SqlInstancesExecuteSqlRequest, SqlInstancesExecuteSqlResponse>
      executeSqlSettings;
  private final UnaryCallSettings<
          SqlInstancesAcquireSsrsLeaseRequest, SqlInstancesAcquireSsrsLeaseResponse>
      acquireSsrsLeaseSettings;
  private final UnaryCallSettings<
          SqlInstancesReleaseSsrsLeaseRequest, SqlInstancesReleaseSsrsLeaseResponse>
      releaseSsrsLeaseSettings;
  private final UnaryCallSettings<SqlInstancesPreCheckMajorVersionUpgradeRequest, Operation>
      preCheckMajorVersionUpgradeSettings;
  private final UnaryCallSettings<SqlInstancesPointInTimeRestoreRequest, Operation>
      pointInTimeRestoreSettings;

  /** Returns the object with the settings used for calls to addServerCa. */
  public UnaryCallSettings<SqlInstancesAddServerCaRequest, Operation> addServerCaSettings() {
    return addServerCaSettings;
  }

  /** Returns the object with the settings used for calls to addServerCertificate. */
  public UnaryCallSettings<SqlInstancesAddServerCertificateRequest, Operation>
      addServerCertificateSettings() {
    return addServerCertificateSettings;
  }

  /** Returns the object with the settings used for calls to addEntraIdCertificate. */
  public UnaryCallSettings<SqlInstancesAddEntraIdCertificateRequest, Operation>
      addEntraIdCertificateSettings() {
    return addEntraIdCertificateSettings;
  }

  /** Returns the object with the settings used for calls to clone. */
  public UnaryCallSettings<SqlInstancesCloneRequest, Operation> cloneSettings() {
    return cloneSettings;
  }

  /** Returns the object with the settings used for calls to delete. */
  public UnaryCallSettings<SqlInstancesDeleteRequest, Operation> deleteSettings() {
    return deleteSettings;
  }

  /** Returns the object with the settings used for calls to demoteMaster. */
  public UnaryCallSettings<SqlInstancesDemoteMasterRequest, Operation> demoteMasterSettings() {
    return demoteMasterSettings;
  }

  /** Returns the object with the settings used for calls to demote. */
  public UnaryCallSettings<SqlInstancesDemoteRequest, Operation> demoteSettings() {
    return demoteSettings;
  }

  /** Returns the object with the settings used for calls to export. */
  public UnaryCallSettings<SqlInstancesExportRequest, Operation> exportSettings() {
    return exportSettings;
  }

  /** Returns the object with the settings used for calls to failover. */
  public UnaryCallSettings<SqlInstancesFailoverRequest, Operation> failoverSettings() {
    return failoverSettings;
  }

  /** Returns the object with the settings used for calls to reencrypt. */
  public UnaryCallSettings<SqlInstancesReencryptRequest, Operation> reencryptSettings() {
    return reencryptSettings;
  }

  /** Returns the object with the settings used for calls to get. */
  public UnaryCallSettings<SqlInstancesGetRequest, DatabaseInstance> getSettings() {
    return getSettings;
  }

  /** Returns the object with the settings used for calls to import_. */
  public UnaryCallSettings<SqlInstancesImportRequest, Operation> import_Settings() {
    return import_Settings;
  }

  /** Returns the object with the settings used for calls to insert. */
  public UnaryCallSettings<SqlInstancesInsertRequest, Operation> insertSettings() {
    return insertSettings;
  }

  /** Returns the object with the settings used for calls to list. */
  public UnaryCallSettings<SqlInstancesListRequest, InstancesListResponse> listSettings() {
    return listSettings;
  }

  /** Returns the object with the settings used for calls to listServerCas. */
  public UnaryCallSettings<SqlInstancesListServerCasRequest, InstancesListServerCasResponse>
      listServerCasSettings() {
    return listServerCasSettings;
  }

  /** Returns the object with the settings used for calls to listServerCertificates. */
  public UnaryCallSettings<
          SqlInstancesListServerCertificatesRequest, InstancesListServerCertificatesResponse>
      listServerCertificatesSettings() {
    return listServerCertificatesSettings;
  }

  /** Returns the object with the settings used for calls to listEntraIdCertificates. */
  public UnaryCallSettings<
          SqlInstancesListEntraIdCertificatesRequest, InstancesListEntraIdCertificatesResponse>
      listEntraIdCertificatesSettings() {
    return listEntraIdCertificatesSettings;
  }

  /** Returns the object with the settings used for calls to patch. */
  public UnaryCallSettings<SqlInstancesPatchRequest, Operation> patchSettings() {
    return patchSettings;
  }

  /** Returns the object with the settings used for calls to promoteReplica. */
  public UnaryCallSettings<SqlInstancesPromoteReplicaRequest, Operation> promoteReplicaSettings() {
    return promoteReplicaSettings;
  }

  /** Returns the object with the settings used for calls to switchover. */
  public UnaryCallSettings<SqlInstancesSwitchoverRequest, Operation> switchoverSettings() {
    return switchoverSettings;
  }

  /** Returns the object with the settings used for calls to resetSslConfig. */
  public UnaryCallSettings<SqlInstancesResetSslConfigRequest, Operation> resetSslConfigSettings() {
    return resetSslConfigSettings;
  }

  /** Returns the object with the settings used for calls to restart. */
  public UnaryCallSettings<SqlInstancesRestartRequest, Operation> restartSettings() {
    return restartSettings;
  }

  /** Returns the object with the settings used for calls to restoreBackup. */
  public UnaryCallSettings<SqlInstancesRestoreBackupRequest, Operation> restoreBackupSettings() {
    return restoreBackupSettings;
  }

  /** Returns the object with the settings used for calls to rotateServerCa. */
  public UnaryCallSettings<SqlInstancesRotateServerCaRequest, Operation> rotateServerCaSettings() {
    return rotateServerCaSettings;
  }

  /** Returns the object with the settings used for calls to rotateServerCertificate. */
  public UnaryCallSettings<SqlInstancesRotateServerCertificateRequest, Operation>
      rotateServerCertificateSettings() {
    return rotateServerCertificateSettings;
  }

  /** Returns the object with the settings used for calls to rotateEntraIdCertificate. */
  public UnaryCallSettings<SqlInstancesRotateEntraIdCertificateRequest, Operation>
      rotateEntraIdCertificateSettings() {
    return rotateEntraIdCertificateSettings;
  }

  /** Returns the object with the settings used for calls to startReplica. */
  public UnaryCallSettings<SqlInstancesStartReplicaRequest, Operation> startReplicaSettings() {
    return startReplicaSettings;
  }

  /** Returns the object with the settings used for calls to stopReplica. */
  public UnaryCallSettings<SqlInstancesStopReplicaRequest, Operation> stopReplicaSettings() {
    return stopReplicaSettings;
  }

  /** Returns the object with the settings used for calls to truncateLog. */
  public UnaryCallSettings<SqlInstancesTruncateLogRequest, Operation> truncateLogSettings() {
    return truncateLogSettings;
  }

  /** Returns the object with the settings used for calls to update. */
  public UnaryCallSettings<SqlInstancesUpdateRequest, Operation> updateSettings() {
    return updateSettings;
  }

  /** Returns the object with the settings used for calls to createEphemeral. */
  public UnaryCallSettings<SqlInstancesCreateEphemeralCertRequest, SslCert>
      createEphemeralSettings() {
    return createEphemeralSettings;
  }

  /** Returns the object with the settings used for calls to rescheduleMaintenance. */
  public UnaryCallSettings<SqlInstancesRescheduleMaintenanceRequest, Operation>
      rescheduleMaintenanceSettings() {
    return rescheduleMaintenanceSettings;
  }

  /** Returns the object with the settings used for calls to verifyExternalSyncSettings. */
  public UnaryCallSettings<
          SqlInstancesVerifyExternalSyncSettingsRequest,
          SqlInstancesVerifyExternalSyncSettingsResponse>
      verifyExternalSyncSettingsSettings() {
    return verifyExternalSyncSettingsSettings;
  }

  /** Returns the object with the settings used for calls to startExternalSync. */
  public UnaryCallSettings<SqlInstancesStartExternalSyncRequest, Operation>
      startExternalSyncSettings() {
    return startExternalSyncSettings;
  }

  /** Returns the object with the settings used for calls to performDiskShrink. */
  public UnaryCallSettings<SqlInstancesPerformDiskShrinkRequest, Operation>
      performDiskShrinkSettings() {
    return performDiskShrinkSettings;
  }

  /** Returns the object with the settings used for calls to getDiskShrinkConfig. */
  public UnaryCallSettings<
          SqlInstancesGetDiskShrinkConfigRequest, SqlInstancesGetDiskShrinkConfigResponse>
      getDiskShrinkConfigSettings() {
    return getDiskShrinkConfigSettings;
  }

  /** Returns the object with the settings used for calls to resetReplicaSize. */
  public UnaryCallSettings<SqlInstancesResetReplicaSizeRequest, Operation>
      resetReplicaSizeSettings() {
    return resetReplicaSizeSettings;
  }

  /** Returns the object with the settings used for calls to getLatestRecoveryTime. */
  public UnaryCallSettings<
          SqlInstancesGetLatestRecoveryTimeRequest, SqlInstancesGetLatestRecoveryTimeResponse>
      getLatestRecoveryTimeSettings() {
    return getLatestRecoveryTimeSettings;
  }

  /** Returns the object with the settings used for calls to executeSql. */
  public UnaryCallSettings<SqlInstancesExecuteSqlRequest, SqlInstancesExecuteSqlResponse>
      executeSqlSettings() {
    return executeSqlSettings;
  }

  /** Returns the object with the settings used for calls to acquireSsrsLease. */
  public UnaryCallSettings<
          SqlInstancesAcquireSsrsLeaseRequest, SqlInstancesAcquireSsrsLeaseResponse>
      acquireSsrsLeaseSettings() {
    return acquireSsrsLeaseSettings;
  }

  /** Returns the object with the settings used for calls to releaseSsrsLease. */
  public UnaryCallSettings<
          SqlInstancesReleaseSsrsLeaseRequest, SqlInstancesReleaseSsrsLeaseResponse>
      releaseSsrsLeaseSettings() {
    return releaseSsrsLeaseSettings;
  }

  /** Returns the object with the settings used for calls to preCheckMajorVersionUpgrade. */
  public UnaryCallSettings<SqlInstancesPreCheckMajorVersionUpgradeRequest, Operation>
      preCheckMajorVersionUpgradeSettings() {
    return preCheckMajorVersionUpgradeSettings;
  }

  /** Returns the object with the settings used for calls to pointInTimeRestore. */
  public UnaryCallSettings<SqlInstancesPointInTimeRestoreRequest, Operation>
      pointInTimeRestoreSettings() {
    return pointInTimeRestoreSettings;
  }

  public SqlInstancesServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcSqlInstancesServiceStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonSqlInstancesServiceStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns the default service name. */
  @Override
  public String getServiceName() {
    return "sqladmin";
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  @ObsoleteApi("Use getEndpoint() instead")
  public static String getDefaultEndpoint() {
    return "sqladmin.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "sqladmin.mtls.googleapis.com:443";
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
            "gapic", GaxProperties.getLibraryVersion(SqlInstancesServiceStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(SqlInstancesServiceStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return SqlInstancesServiceStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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
  public static Builder newBuilder(@Nullable ClientContext clientContext) {
    return new Builder(clientContext);
  }

  /** Returns a builder containing all the values of this settings class. */
  public Builder toBuilder() {
    return new Builder(this);
  }

  protected SqlInstancesServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    addServerCaSettings = settingsBuilder.addServerCaSettings().build();
    addServerCertificateSettings = settingsBuilder.addServerCertificateSettings().build();
    addEntraIdCertificateSettings = settingsBuilder.addEntraIdCertificateSettings().build();
    cloneSettings = settingsBuilder.cloneSettings().build();
    deleteSettings = settingsBuilder.deleteSettings().build();
    demoteMasterSettings = settingsBuilder.demoteMasterSettings().build();
    demoteSettings = settingsBuilder.demoteSettings().build();
    exportSettings = settingsBuilder.exportSettings().build();
    failoverSettings = settingsBuilder.failoverSettings().build();
    reencryptSettings = settingsBuilder.reencryptSettings().build();
    getSettings = settingsBuilder.getSettings().build();
    import_Settings = settingsBuilder.import_Settings().build();
    insertSettings = settingsBuilder.insertSettings().build();
    listSettings = settingsBuilder.listSettings().build();
    listServerCasSettings = settingsBuilder.listServerCasSettings().build();
    listServerCertificatesSettings = settingsBuilder.listServerCertificatesSettings().build();
    listEntraIdCertificatesSettings = settingsBuilder.listEntraIdCertificatesSettings().build();
    patchSettings = settingsBuilder.patchSettings().build();
    promoteReplicaSettings = settingsBuilder.promoteReplicaSettings().build();
    switchoverSettings = settingsBuilder.switchoverSettings().build();
    resetSslConfigSettings = settingsBuilder.resetSslConfigSettings().build();
    restartSettings = settingsBuilder.restartSettings().build();
    restoreBackupSettings = settingsBuilder.restoreBackupSettings().build();
    rotateServerCaSettings = settingsBuilder.rotateServerCaSettings().build();
    rotateServerCertificateSettings = settingsBuilder.rotateServerCertificateSettings().build();
    rotateEntraIdCertificateSettings = settingsBuilder.rotateEntraIdCertificateSettings().build();
    startReplicaSettings = settingsBuilder.startReplicaSettings().build();
    stopReplicaSettings = settingsBuilder.stopReplicaSettings().build();
    truncateLogSettings = settingsBuilder.truncateLogSettings().build();
    updateSettings = settingsBuilder.updateSettings().build();
    createEphemeralSettings = settingsBuilder.createEphemeralSettings().build();
    rescheduleMaintenanceSettings = settingsBuilder.rescheduleMaintenanceSettings().build();
    verifyExternalSyncSettingsSettings =
        settingsBuilder.verifyExternalSyncSettingsSettings().build();
    startExternalSyncSettings = settingsBuilder.startExternalSyncSettings().build();
    performDiskShrinkSettings = settingsBuilder.performDiskShrinkSettings().build();
    getDiskShrinkConfigSettings = settingsBuilder.getDiskShrinkConfigSettings().build();
    resetReplicaSizeSettings = settingsBuilder.resetReplicaSizeSettings().build();
    getLatestRecoveryTimeSettings = settingsBuilder.getLatestRecoveryTimeSettings().build();
    executeSqlSettings = settingsBuilder.executeSqlSettings().build();
    acquireSsrsLeaseSettings = settingsBuilder.acquireSsrsLeaseSettings().build();
    releaseSsrsLeaseSettings = settingsBuilder.releaseSsrsLeaseSettings().build();
    preCheckMajorVersionUpgradeSettings =
        settingsBuilder.preCheckMajorVersionUpgradeSettings().build();
    pointInTimeRestoreSettings = settingsBuilder.pointInTimeRestoreSettings().build();
  }

  @Override
  protected LibraryMetadata getLibraryMetadata() {
    return LibraryMetadata.newBuilder()
        .setArtifactName("com.google.cloud:google-cloud-sql")
        .setRepository("googleapis/google-cloud-java")
        .setVersion(Version.VERSION)
        .build();
  }

  /** Builder for SqlInstancesServiceStubSettings. */
  public static class Builder
      extends StubSettings.Builder<SqlInstancesServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<SqlInstancesAddServerCaRequest, Operation>
        addServerCaSettings;
    private final UnaryCallSettings.Builder<SqlInstancesAddServerCertificateRequest, Operation>
        addServerCertificateSettings;
    private final UnaryCallSettings.Builder<SqlInstancesAddEntraIdCertificateRequest, Operation>
        addEntraIdCertificateSettings;
    private final UnaryCallSettings.Builder<SqlInstancesCloneRequest, Operation> cloneSettings;
    private final UnaryCallSettings.Builder<SqlInstancesDeleteRequest, Operation> deleteSettings;
    private final UnaryCallSettings.Builder<SqlInstancesDemoteMasterRequest, Operation>
        demoteMasterSettings;
    private final UnaryCallSettings.Builder<SqlInstancesDemoteRequest, Operation> demoteSettings;
    private final UnaryCallSettings.Builder<SqlInstancesExportRequest, Operation> exportSettings;
    private final UnaryCallSettings.Builder<SqlInstancesFailoverRequest, Operation>
        failoverSettings;
    private final UnaryCallSettings.Builder<SqlInstancesReencryptRequest, Operation>
        reencryptSettings;
    private final UnaryCallSettings.Builder<SqlInstancesGetRequest, DatabaseInstance> getSettings;
    private final UnaryCallSettings.Builder<SqlInstancesImportRequest, Operation> import_Settings;
    private final UnaryCallSettings.Builder<SqlInstancesInsertRequest, Operation> insertSettings;
    private final UnaryCallSettings.Builder<SqlInstancesListRequest, InstancesListResponse>
        listSettings;
    private final UnaryCallSettings.Builder<
            SqlInstancesListServerCasRequest, InstancesListServerCasResponse>
        listServerCasSettings;
    private final UnaryCallSettings.Builder<
            SqlInstancesListServerCertificatesRequest, InstancesListServerCertificatesResponse>
        listServerCertificatesSettings;
    private final UnaryCallSettings.Builder<
            SqlInstancesListEntraIdCertificatesRequest, InstancesListEntraIdCertificatesResponse>
        listEntraIdCertificatesSettings;
    private final UnaryCallSettings.Builder<SqlInstancesPatchRequest, Operation> patchSettings;
    private final UnaryCallSettings.Builder<SqlInstancesPromoteReplicaRequest, Operation>
        promoteReplicaSettings;
    private final UnaryCallSettings.Builder<SqlInstancesSwitchoverRequest, Operation>
        switchoverSettings;
    private final UnaryCallSettings.Builder<SqlInstancesResetSslConfigRequest, Operation>
        resetSslConfigSettings;
    private final UnaryCallSettings.Builder<SqlInstancesRestartRequest, Operation> restartSettings;
    private final UnaryCallSettings.Builder<SqlInstancesRestoreBackupRequest, Operation>
        restoreBackupSettings;
    private final UnaryCallSettings.Builder<SqlInstancesRotateServerCaRequest, Operation>
        rotateServerCaSettings;
    private final UnaryCallSettings.Builder<SqlInstancesRotateServerCertificateRequest, Operation>
        rotateServerCertificateSettings;
    private final UnaryCallSettings.Builder<SqlInstancesRotateEntraIdCertificateRequest, Operation>
        rotateEntraIdCertificateSettings;
    private final UnaryCallSettings.Builder<SqlInstancesStartReplicaRequest, Operation>
        startReplicaSettings;
    private final UnaryCallSettings.Builder<SqlInstancesStopReplicaRequest, Operation>
        stopReplicaSettings;
    private final UnaryCallSettings.Builder<SqlInstancesTruncateLogRequest, Operation>
        truncateLogSettings;
    private final UnaryCallSettings.Builder<SqlInstancesUpdateRequest, Operation> updateSettings;
    private final UnaryCallSettings.Builder<SqlInstancesCreateEphemeralCertRequest, SslCert>
        createEphemeralSettings;
    private final UnaryCallSettings.Builder<SqlInstancesRescheduleMaintenanceRequest, Operation>
        rescheduleMaintenanceSettings;
    private final UnaryCallSettings.Builder<
            SqlInstancesVerifyExternalSyncSettingsRequest,
            SqlInstancesVerifyExternalSyncSettingsResponse>
        verifyExternalSyncSettingsSettings;
    private final UnaryCallSettings.Builder<SqlInstancesStartExternalSyncRequest, Operation>
        startExternalSyncSettings;
    private final UnaryCallSettings.Builder<SqlInstancesPerformDiskShrinkRequest, Operation>
        performDiskShrinkSettings;
    private final UnaryCallSettings.Builder<
            SqlInstancesGetDiskShrinkConfigRequest, SqlInstancesGetDiskShrinkConfigResponse>
        getDiskShrinkConfigSettings;
    private final UnaryCallSettings.Builder<SqlInstancesResetReplicaSizeRequest, Operation>
        resetReplicaSizeSettings;
    private final UnaryCallSettings.Builder<
            SqlInstancesGetLatestRecoveryTimeRequest, SqlInstancesGetLatestRecoveryTimeResponse>
        getLatestRecoveryTimeSettings;
    private final UnaryCallSettings.Builder<
            SqlInstancesExecuteSqlRequest, SqlInstancesExecuteSqlResponse>
        executeSqlSettings;
    private final UnaryCallSettings.Builder<
            SqlInstancesAcquireSsrsLeaseRequest, SqlInstancesAcquireSsrsLeaseResponse>
        acquireSsrsLeaseSettings;
    private final UnaryCallSettings.Builder<
            SqlInstancesReleaseSsrsLeaseRequest, SqlInstancesReleaseSsrsLeaseResponse>
        releaseSsrsLeaseSettings;
    private final UnaryCallSettings.Builder<
            SqlInstancesPreCheckMajorVersionUpgradeRequest, Operation>
        preCheckMajorVersionUpgradeSettings;
    private final UnaryCallSettings.Builder<SqlInstancesPointInTimeRestoreRequest, Operation>
        pointInTimeRestoreSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put(
          "no_retry_0_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
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
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(@Nullable ClientContext clientContext) {
      super(clientContext);

      addServerCaSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      addServerCertificateSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      addEntraIdCertificateSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      cloneSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      demoteMasterSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      demoteSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      exportSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      failoverSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      reencryptSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      import_Settings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      insertSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listServerCasSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listServerCertificatesSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listEntraIdCertificatesSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      patchSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      promoteReplicaSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      switchoverSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      resetSslConfigSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      restartSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      restoreBackupSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      rotateServerCaSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      rotateServerCertificateSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      rotateEntraIdCertificateSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      startReplicaSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      stopReplicaSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      truncateLogSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createEphemeralSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      rescheduleMaintenanceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      verifyExternalSyncSettingsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      startExternalSyncSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      performDiskShrinkSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getDiskShrinkConfigSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      resetReplicaSizeSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getLatestRecoveryTimeSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      executeSqlSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      acquireSsrsLeaseSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      releaseSsrsLeaseSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      preCheckMajorVersionUpgradeSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      pointInTimeRestoreSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              addServerCaSettings,
              addServerCertificateSettings,
              addEntraIdCertificateSettings,
              cloneSettings,
              deleteSettings,
              demoteMasterSettings,
              demoteSettings,
              exportSettings,
              failoverSettings,
              reencryptSettings,
              getSettings,
              import_Settings,
              insertSettings,
              listSettings,
              listServerCasSettings,
              listServerCertificatesSettings,
              listEntraIdCertificatesSettings,
              patchSettings,
              promoteReplicaSettings,
              switchoverSettings,
              resetSslConfigSettings,
              restartSettings,
              restoreBackupSettings,
              rotateServerCaSettings,
              rotateServerCertificateSettings,
              rotateEntraIdCertificateSettings,
              startReplicaSettings,
              stopReplicaSettings,
              truncateLogSettings,
              updateSettings,
              createEphemeralSettings,
              rescheduleMaintenanceSettings,
              verifyExternalSyncSettingsSettings,
              startExternalSyncSettings,
              performDiskShrinkSettings,
              getDiskShrinkConfigSettings,
              resetReplicaSizeSettings,
              getLatestRecoveryTimeSettings,
              executeSqlSettings,
              acquireSsrsLeaseSettings,
              releaseSsrsLeaseSettings,
              preCheckMajorVersionUpgradeSettings,
              pointInTimeRestoreSettings);
      initDefaults(this);
    }

    protected Builder(SqlInstancesServiceStubSettings settings) {
      super(settings);

      addServerCaSettings = settings.addServerCaSettings.toBuilder();
      addServerCertificateSettings = settings.addServerCertificateSettings.toBuilder();
      addEntraIdCertificateSettings = settings.addEntraIdCertificateSettings.toBuilder();
      cloneSettings = settings.cloneSettings.toBuilder();
      deleteSettings = settings.deleteSettings.toBuilder();
      demoteMasterSettings = settings.demoteMasterSettings.toBuilder();
      demoteSettings = settings.demoteSettings.toBuilder();
      exportSettings = settings.exportSettings.toBuilder();
      failoverSettings = settings.failoverSettings.toBuilder();
      reencryptSettings = settings.reencryptSettings.toBuilder();
      getSettings = settings.getSettings.toBuilder();
      import_Settings = settings.import_Settings.toBuilder();
      insertSettings = settings.insertSettings.toBuilder();
      listSettings = settings.listSettings.toBuilder();
      listServerCasSettings = settings.listServerCasSettings.toBuilder();
      listServerCertificatesSettings = settings.listServerCertificatesSettings.toBuilder();
      listEntraIdCertificatesSettings = settings.listEntraIdCertificatesSettings.toBuilder();
      patchSettings = settings.patchSettings.toBuilder();
      promoteReplicaSettings = settings.promoteReplicaSettings.toBuilder();
      switchoverSettings = settings.switchoverSettings.toBuilder();
      resetSslConfigSettings = settings.resetSslConfigSettings.toBuilder();
      restartSettings = settings.restartSettings.toBuilder();
      restoreBackupSettings = settings.restoreBackupSettings.toBuilder();
      rotateServerCaSettings = settings.rotateServerCaSettings.toBuilder();
      rotateServerCertificateSettings = settings.rotateServerCertificateSettings.toBuilder();
      rotateEntraIdCertificateSettings = settings.rotateEntraIdCertificateSettings.toBuilder();
      startReplicaSettings = settings.startReplicaSettings.toBuilder();
      stopReplicaSettings = settings.stopReplicaSettings.toBuilder();
      truncateLogSettings = settings.truncateLogSettings.toBuilder();
      updateSettings = settings.updateSettings.toBuilder();
      createEphemeralSettings = settings.createEphemeralSettings.toBuilder();
      rescheduleMaintenanceSettings = settings.rescheduleMaintenanceSettings.toBuilder();
      verifyExternalSyncSettingsSettings = settings.verifyExternalSyncSettingsSettings.toBuilder();
      startExternalSyncSettings = settings.startExternalSyncSettings.toBuilder();
      performDiskShrinkSettings = settings.performDiskShrinkSettings.toBuilder();
      getDiskShrinkConfigSettings = settings.getDiskShrinkConfigSettings.toBuilder();
      resetReplicaSizeSettings = settings.resetReplicaSizeSettings.toBuilder();
      getLatestRecoveryTimeSettings = settings.getLatestRecoveryTimeSettings.toBuilder();
      executeSqlSettings = settings.executeSqlSettings.toBuilder();
      acquireSsrsLeaseSettings = settings.acquireSsrsLeaseSettings.toBuilder();
      releaseSsrsLeaseSettings = settings.releaseSsrsLeaseSettings.toBuilder();
      preCheckMajorVersionUpgradeSettings =
          settings.preCheckMajorVersionUpgradeSettings.toBuilder();
      pointInTimeRestoreSettings = settings.pointInTimeRestoreSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              addServerCaSettings,
              addServerCertificateSettings,
              addEntraIdCertificateSettings,
              cloneSettings,
              deleteSettings,
              demoteMasterSettings,
              demoteSettings,
              exportSettings,
              failoverSettings,
              reencryptSettings,
              getSettings,
              import_Settings,
              insertSettings,
              listSettings,
              listServerCasSettings,
              listServerCertificatesSettings,
              listEntraIdCertificatesSettings,
              patchSettings,
              promoteReplicaSettings,
              switchoverSettings,
              resetSslConfigSettings,
              restartSettings,
              restoreBackupSettings,
              rotateServerCaSettings,
              rotateServerCertificateSettings,
              rotateEntraIdCertificateSettings,
              startReplicaSettings,
              stopReplicaSettings,
              truncateLogSettings,
              updateSettings,
              createEphemeralSettings,
              rescheduleMaintenanceSettings,
              verifyExternalSyncSettingsSettings,
              startExternalSyncSettings,
              performDiskShrinkSettings,
              getDiskShrinkConfigSettings,
              resetReplicaSizeSettings,
              getLatestRecoveryTimeSettings,
              executeSqlSettings,
              acquireSsrsLeaseSettings,
              releaseSsrsLeaseSettings,
              preCheckMajorVersionUpgradeSettings,
              pointInTimeRestoreSettings);
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
          .addServerCaSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .addServerCertificateSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .addEntraIdCertificateSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .cloneSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .deleteSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .demoteMasterSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .demoteSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .exportSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .failoverSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .reencryptSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .getSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .import_Settings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .insertSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .listSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .listServerCasSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .listServerCertificatesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .listEntraIdCertificatesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .patchSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .promoteReplicaSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .switchoverSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .resetSslConfigSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .restartSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .restoreBackupSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .rotateServerCaSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .rotateServerCertificateSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .rotateEntraIdCertificateSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .startReplicaSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .stopReplicaSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .truncateLogSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .updateSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .createEphemeralSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .rescheduleMaintenanceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .verifyExternalSyncSettingsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .startExternalSyncSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .performDiskShrinkSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .getDiskShrinkConfigSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .resetReplicaSizeSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .getLatestRecoveryTimeSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .executeSqlSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .acquireSsrsLeaseSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .releaseSsrsLeaseSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .preCheckMajorVersionUpgradeSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .pointInTimeRestoreSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

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

    /** Returns the builder for the settings used for calls to addServerCa. */
    public UnaryCallSettings.Builder<SqlInstancesAddServerCaRequest, Operation>
        addServerCaSettings() {
      return addServerCaSettings;
    }

    /** Returns the builder for the settings used for calls to addServerCertificate. */
    public UnaryCallSettings.Builder<SqlInstancesAddServerCertificateRequest, Operation>
        addServerCertificateSettings() {
      return addServerCertificateSettings;
    }

    /** Returns the builder for the settings used for calls to addEntraIdCertificate. */
    public UnaryCallSettings.Builder<SqlInstancesAddEntraIdCertificateRequest, Operation>
        addEntraIdCertificateSettings() {
      return addEntraIdCertificateSettings;
    }

    /** Returns the builder for the settings used for calls to clone. */
    public UnaryCallSettings.Builder<SqlInstancesCloneRequest, Operation> cloneSettings() {
      return cloneSettings;
    }

    /** Returns the builder for the settings used for calls to delete. */
    public UnaryCallSettings.Builder<SqlInstancesDeleteRequest, Operation> deleteSettings() {
      return deleteSettings;
    }

    /** Returns the builder for the settings used for calls to demoteMaster. */
    public UnaryCallSettings.Builder<SqlInstancesDemoteMasterRequest, Operation>
        demoteMasterSettings() {
      return demoteMasterSettings;
    }

    /** Returns the builder for the settings used for calls to demote. */
    public UnaryCallSettings.Builder<SqlInstancesDemoteRequest, Operation> demoteSettings() {
      return demoteSettings;
    }

    /** Returns the builder for the settings used for calls to export. */
    public UnaryCallSettings.Builder<SqlInstancesExportRequest, Operation> exportSettings() {
      return exportSettings;
    }

    /** Returns the builder for the settings used for calls to failover. */
    public UnaryCallSettings.Builder<SqlInstancesFailoverRequest, Operation> failoverSettings() {
      return failoverSettings;
    }

    /** Returns the builder for the settings used for calls to reencrypt. */
    public UnaryCallSettings.Builder<SqlInstancesReencryptRequest, Operation> reencryptSettings() {
      return reencryptSettings;
    }

    /** Returns the builder for the settings used for calls to get. */
    public UnaryCallSettings.Builder<SqlInstancesGetRequest, DatabaseInstance> getSettings() {
      return getSettings;
    }

    /** Returns the builder for the settings used for calls to import_. */
    public UnaryCallSettings.Builder<SqlInstancesImportRequest, Operation> import_Settings() {
      return import_Settings;
    }

    /** Returns the builder for the settings used for calls to insert. */
    public UnaryCallSettings.Builder<SqlInstancesInsertRequest, Operation> insertSettings() {
      return insertSettings;
    }

    /** Returns the builder for the settings used for calls to list. */
    public UnaryCallSettings.Builder<SqlInstancesListRequest, InstancesListResponse>
        listSettings() {
      return listSettings;
    }

    /** Returns the builder for the settings used for calls to listServerCas. */
    public UnaryCallSettings.Builder<
            SqlInstancesListServerCasRequest, InstancesListServerCasResponse>
        listServerCasSettings() {
      return listServerCasSettings;
    }

    /** Returns the builder for the settings used for calls to listServerCertificates. */
    public UnaryCallSettings.Builder<
            SqlInstancesListServerCertificatesRequest, InstancesListServerCertificatesResponse>
        listServerCertificatesSettings() {
      return listServerCertificatesSettings;
    }

    /** Returns the builder for the settings used for calls to listEntraIdCertificates. */
    public UnaryCallSettings.Builder<
            SqlInstancesListEntraIdCertificatesRequest, InstancesListEntraIdCertificatesResponse>
        listEntraIdCertificatesSettings() {
      return listEntraIdCertificatesSettings;
    }

    /** Returns the builder for the settings used for calls to patch. */
    public UnaryCallSettings.Builder<SqlInstancesPatchRequest, Operation> patchSettings() {
      return patchSettings;
    }

    /** Returns the builder for the settings used for calls to promoteReplica. */
    public UnaryCallSettings.Builder<SqlInstancesPromoteReplicaRequest, Operation>
        promoteReplicaSettings() {
      return promoteReplicaSettings;
    }

    /** Returns the builder for the settings used for calls to switchover. */
    public UnaryCallSettings.Builder<SqlInstancesSwitchoverRequest, Operation>
        switchoverSettings() {
      return switchoverSettings;
    }

    /** Returns the builder for the settings used for calls to resetSslConfig. */
    public UnaryCallSettings.Builder<SqlInstancesResetSslConfigRequest, Operation>
        resetSslConfigSettings() {
      return resetSslConfigSettings;
    }

    /** Returns the builder for the settings used for calls to restart. */
    public UnaryCallSettings.Builder<SqlInstancesRestartRequest, Operation> restartSettings() {
      return restartSettings;
    }

    /** Returns the builder for the settings used for calls to restoreBackup. */
    public UnaryCallSettings.Builder<SqlInstancesRestoreBackupRequest, Operation>
        restoreBackupSettings() {
      return restoreBackupSettings;
    }

    /** Returns the builder for the settings used for calls to rotateServerCa. */
    public UnaryCallSettings.Builder<SqlInstancesRotateServerCaRequest, Operation>
        rotateServerCaSettings() {
      return rotateServerCaSettings;
    }

    /** Returns the builder for the settings used for calls to rotateServerCertificate. */
    public UnaryCallSettings.Builder<SqlInstancesRotateServerCertificateRequest, Operation>
        rotateServerCertificateSettings() {
      return rotateServerCertificateSettings;
    }

    /** Returns the builder for the settings used for calls to rotateEntraIdCertificate. */
    public UnaryCallSettings.Builder<SqlInstancesRotateEntraIdCertificateRequest, Operation>
        rotateEntraIdCertificateSettings() {
      return rotateEntraIdCertificateSettings;
    }

    /** Returns the builder for the settings used for calls to startReplica. */
    public UnaryCallSettings.Builder<SqlInstancesStartReplicaRequest, Operation>
        startReplicaSettings() {
      return startReplicaSettings;
    }

    /** Returns the builder for the settings used for calls to stopReplica. */
    public UnaryCallSettings.Builder<SqlInstancesStopReplicaRequest, Operation>
        stopReplicaSettings() {
      return stopReplicaSettings;
    }

    /** Returns the builder for the settings used for calls to truncateLog. */
    public UnaryCallSettings.Builder<SqlInstancesTruncateLogRequest, Operation>
        truncateLogSettings() {
      return truncateLogSettings;
    }

    /** Returns the builder for the settings used for calls to update. */
    public UnaryCallSettings.Builder<SqlInstancesUpdateRequest, Operation> updateSettings() {
      return updateSettings;
    }

    /** Returns the builder for the settings used for calls to createEphemeral. */
    public UnaryCallSettings.Builder<SqlInstancesCreateEphemeralCertRequest, SslCert>
        createEphemeralSettings() {
      return createEphemeralSettings;
    }

    /** Returns the builder for the settings used for calls to rescheduleMaintenance. */
    public UnaryCallSettings.Builder<SqlInstancesRescheduleMaintenanceRequest, Operation>
        rescheduleMaintenanceSettings() {
      return rescheduleMaintenanceSettings;
    }

    /** Returns the builder for the settings used for calls to verifyExternalSyncSettings. */
    public UnaryCallSettings.Builder<
            SqlInstancesVerifyExternalSyncSettingsRequest,
            SqlInstancesVerifyExternalSyncSettingsResponse>
        verifyExternalSyncSettingsSettings() {
      return verifyExternalSyncSettingsSettings;
    }

    /** Returns the builder for the settings used for calls to startExternalSync. */
    public UnaryCallSettings.Builder<SqlInstancesStartExternalSyncRequest, Operation>
        startExternalSyncSettings() {
      return startExternalSyncSettings;
    }

    /** Returns the builder for the settings used for calls to performDiskShrink. */
    public UnaryCallSettings.Builder<SqlInstancesPerformDiskShrinkRequest, Operation>
        performDiskShrinkSettings() {
      return performDiskShrinkSettings;
    }

    /** Returns the builder for the settings used for calls to getDiskShrinkConfig. */
    public UnaryCallSettings.Builder<
            SqlInstancesGetDiskShrinkConfigRequest, SqlInstancesGetDiskShrinkConfigResponse>
        getDiskShrinkConfigSettings() {
      return getDiskShrinkConfigSettings;
    }

    /** Returns the builder for the settings used for calls to resetReplicaSize. */
    public UnaryCallSettings.Builder<SqlInstancesResetReplicaSizeRequest, Operation>
        resetReplicaSizeSettings() {
      return resetReplicaSizeSettings;
    }

    /** Returns the builder for the settings used for calls to getLatestRecoveryTime. */
    public UnaryCallSettings.Builder<
            SqlInstancesGetLatestRecoveryTimeRequest, SqlInstancesGetLatestRecoveryTimeResponse>
        getLatestRecoveryTimeSettings() {
      return getLatestRecoveryTimeSettings;
    }

    /** Returns the builder for the settings used for calls to executeSql. */
    public UnaryCallSettings.Builder<SqlInstancesExecuteSqlRequest, SqlInstancesExecuteSqlResponse>
        executeSqlSettings() {
      return executeSqlSettings;
    }

    /** Returns the builder for the settings used for calls to acquireSsrsLease. */
    public UnaryCallSettings.Builder<
            SqlInstancesAcquireSsrsLeaseRequest, SqlInstancesAcquireSsrsLeaseResponse>
        acquireSsrsLeaseSettings() {
      return acquireSsrsLeaseSettings;
    }

    /** Returns the builder for the settings used for calls to releaseSsrsLease. */
    public UnaryCallSettings.Builder<
            SqlInstancesReleaseSsrsLeaseRequest, SqlInstancesReleaseSsrsLeaseResponse>
        releaseSsrsLeaseSettings() {
      return releaseSsrsLeaseSettings;
    }

    /** Returns the builder for the settings used for calls to preCheckMajorVersionUpgrade. */
    public UnaryCallSettings.Builder<SqlInstancesPreCheckMajorVersionUpgradeRequest, Operation>
        preCheckMajorVersionUpgradeSettings() {
      return preCheckMajorVersionUpgradeSettings;
    }

    /** Returns the builder for the settings used for calls to pointInTimeRestore. */
    public UnaryCallSettings.Builder<SqlInstancesPointInTimeRestoreRequest, Operation>
        pointInTimeRestoreSettings() {
      return pointInTimeRestoreSettings;
    }

    @Override
    public SqlInstancesServiceStubSettings build() throws IOException {
      return new SqlInstancesServiceStubSettings(this);
    }
  }
}
