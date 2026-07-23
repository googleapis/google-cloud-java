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

package com.google.cloud.sql.v1;

import com.google.api.core.ApiFunction;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ClientSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.sql.v1.stub.SqlInstancesServiceStubSettings;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link SqlInstancesServiceClient}.
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
 * SqlInstancesServiceSettings.Builder sqlInstancesServiceSettingsBuilder =
 *     SqlInstancesServiceSettings.newBuilder();
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
 * SqlInstancesServiceSettings sqlInstancesServiceSettings =
 *     sqlInstancesServiceSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://docs.cloud.google.com/java/docs/client-retries) for additional support in setting
 * retries.
 */
@NullMarked
@Generated("by gapic-generator-java")
public class SqlInstancesServiceSettings extends ClientSettings<SqlInstancesServiceSettings> {

  /** Returns the object with the settings used for calls to addServerCa. */
  public UnaryCallSettings<SqlInstancesAddServerCaRequest, Operation> addServerCaSettings() {
    return ((SqlInstancesServiceStubSettings) getStubSettings()).addServerCaSettings();
  }

  /** Returns the object with the settings used for calls to addServerCertificate. */
  public UnaryCallSettings<SqlInstancesAddServerCertificateRequest, Operation>
      addServerCertificateSettings() {
    return ((SqlInstancesServiceStubSettings) getStubSettings()).addServerCertificateSettings();
  }

  /** Returns the object with the settings used for calls to addEntraIdCertificate. */
  public UnaryCallSettings<SqlInstancesAddEntraIdCertificateRequest, Operation>
      addEntraIdCertificateSettings() {
    return ((SqlInstancesServiceStubSettings) getStubSettings()).addEntraIdCertificateSettings();
  }

  /** Returns the object with the settings used for calls to clone. */
  public UnaryCallSettings<SqlInstancesCloneRequest, Operation> cloneSettings() {
    return ((SqlInstancesServiceStubSettings) getStubSettings()).cloneSettings();
  }

  /** Returns the object with the settings used for calls to delete. */
  public UnaryCallSettings<SqlInstancesDeleteRequest, Operation> deleteSettings() {
    return ((SqlInstancesServiceStubSettings) getStubSettings()).deleteSettings();
  }

  /** Returns the object with the settings used for calls to demoteMaster. */
  public UnaryCallSettings<SqlInstancesDemoteMasterRequest, Operation> demoteMasterSettings() {
    return ((SqlInstancesServiceStubSettings) getStubSettings()).demoteMasterSettings();
  }

  /** Returns the object with the settings used for calls to demote. */
  public UnaryCallSettings<SqlInstancesDemoteRequest, Operation> demoteSettings() {
    return ((SqlInstancesServiceStubSettings) getStubSettings()).demoteSettings();
  }

  /** Returns the object with the settings used for calls to export. */
  public UnaryCallSettings<SqlInstancesExportRequest, Operation> exportSettings() {
    return ((SqlInstancesServiceStubSettings) getStubSettings()).exportSettings();
  }

  /** Returns the object with the settings used for calls to failover. */
  public UnaryCallSettings<SqlInstancesFailoverRequest, Operation> failoverSettings() {
    return ((SqlInstancesServiceStubSettings) getStubSettings()).failoverSettings();
  }

  /** Returns the object with the settings used for calls to reencrypt. */
  public UnaryCallSettings<SqlInstancesReencryptRequest, Operation> reencryptSettings() {
    return ((SqlInstancesServiceStubSettings) getStubSettings()).reencryptSettings();
  }

  /** Returns the object with the settings used for calls to get. */
  public UnaryCallSettings<SqlInstancesGetRequest, DatabaseInstance> getSettings() {
    return ((SqlInstancesServiceStubSettings) getStubSettings()).getSettings();
  }

  /** Returns the object with the settings used for calls to import_. */
  public UnaryCallSettings<SqlInstancesImportRequest, Operation> import_Settings() {
    return ((SqlInstancesServiceStubSettings) getStubSettings()).import_Settings();
  }

  /** Returns the object with the settings used for calls to insert. */
  public UnaryCallSettings<SqlInstancesInsertRequest, Operation> insertSettings() {
    return ((SqlInstancesServiceStubSettings) getStubSettings()).insertSettings();
  }

  /** Returns the object with the settings used for calls to list. */
  public UnaryCallSettings<SqlInstancesListRequest, InstancesListResponse> listSettings() {
    return ((SqlInstancesServiceStubSettings) getStubSettings()).listSettings();
  }

  /** Returns the object with the settings used for calls to listServerCas. */
  public UnaryCallSettings<SqlInstancesListServerCasRequest, InstancesListServerCasResponse>
      listServerCasSettings() {
    return ((SqlInstancesServiceStubSettings) getStubSettings()).listServerCasSettings();
  }

  /** Returns the object with the settings used for calls to listServerCertificates. */
  public UnaryCallSettings<
          SqlInstancesListServerCertificatesRequest, InstancesListServerCertificatesResponse>
      listServerCertificatesSettings() {
    return ((SqlInstancesServiceStubSettings) getStubSettings()).listServerCertificatesSettings();
  }

  /** Returns the object with the settings used for calls to listEntraIdCertificates. */
  public UnaryCallSettings<
          SqlInstancesListEntraIdCertificatesRequest, InstancesListEntraIdCertificatesResponse>
      listEntraIdCertificatesSettings() {
    return ((SqlInstancesServiceStubSettings) getStubSettings()).listEntraIdCertificatesSettings();
  }

  /** Returns the object with the settings used for calls to patch. */
  public UnaryCallSettings<SqlInstancesPatchRequest, Operation> patchSettings() {
    return ((SqlInstancesServiceStubSettings) getStubSettings()).patchSettings();
  }

  /** Returns the object with the settings used for calls to promoteReplica. */
  public UnaryCallSettings<SqlInstancesPromoteReplicaRequest, Operation> promoteReplicaSettings() {
    return ((SqlInstancesServiceStubSettings) getStubSettings()).promoteReplicaSettings();
  }

  /** Returns the object with the settings used for calls to switchover. */
  public UnaryCallSettings<SqlInstancesSwitchoverRequest, Operation> switchoverSettings() {
    return ((SqlInstancesServiceStubSettings) getStubSettings()).switchoverSettings();
  }

  /** Returns the object with the settings used for calls to resetSslConfig. */
  public UnaryCallSettings<SqlInstancesResetSslConfigRequest, Operation> resetSslConfigSettings() {
    return ((SqlInstancesServiceStubSettings) getStubSettings()).resetSslConfigSettings();
  }

  /** Returns the object with the settings used for calls to restart. */
  public UnaryCallSettings<SqlInstancesRestartRequest, Operation> restartSettings() {
    return ((SqlInstancesServiceStubSettings) getStubSettings()).restartSettings();
  }

  /** Returns the object with the settings used for calls to restoreBackup. */
  public UnaryCallSettings<SqlInstancesRestoreBackupRequest, Operation> restoreBackupSettings() {
    return ((SqlInstancesServiceStubSettings) getStubSettings()).restoreBackupSettings();
  }

  /** Returns the object with the settings used for calls to rotateServerCa. */
  public UnaryCallSettings<SqlInstancesRotateServerCaRequest, Operation> rotateServerCaSettings() {
    return ((SqlInstancesServiceStubSettings) getStubSettings()).rotateServerCaSettings();
  }

  /** Returns the object with the settings used for calls to rotateServerCertificate. */
  public UnaryCallSettings<SqlInstancesRotateServerCertificateRequest, Operation>
      rotateServerCertificateSettings() {
    return ((SqlInstancesServiceStubSettings) getStubSettings()).rotateServerCertificateSettings();
  }

  /** Returns the object with the settings used for calls to rotateEntraIdCertificate. */
  public UnaryCallSettings<SqlInstancesRotateEntraIdCertificateRequest, Operation>
      rotateEntraIdCertificateSettings() {
    return ((SqlInstancesServiceStubSettings) getStubSettings()).rotateEntraIdCertificateSettings();
  }

  /** Returns the object with the settings used for calls to startReplica. */
  public UnaryCallSettings<SqlInstancesStartReplicaRequest, Operation> startReplicaSettings() {
    return ((SqlInstancesServiceStubSettings) getStubSettings()).startReplicaSettings();
  }

  /** Returns the object with the settings used for calls to stopReplica. */
  public UnaryCallSettings<SqlInstancesStopReplicaRequest, Operation> stopReplicaSettings() {
    return ((SqlInstancesServiceStubSettings) getStubSettings()).stopReplicaSettings();
  }

  /** Returns the object with the settings used for calls to truncateLog. */
  public UnaryCallSettings<SqlInstancesTruncateLogRequest, Operation> truncateLogSettings() {
    return ((SqlInstancesServiceStubSettings) getStubSettings()).truncateLogSettings();
  }

  /** Returns the object with the settings used for calls to update. */
  public UnaryCallSettings<SqlInstancesUpdateRequest, Operation> updateSettings() {
    return ((SqlInstancesServiceStubSettings) getStubSettings()).updateSettings();
  }

  /** Returns the object with the settings used for calls to createEphemeral. */
  public UnaryCallSettings<SqlInstancesCreateEphemeralCertRequest, SslCert>
      createEphemeralSettings() {
    return ((SqlInstancesServiceStubSettings) getStubSettings()).createEphemeralSettings();
  }

  /** Returns the object with the settings used for calls to rescheduleMaintenance. */
  public UnaryCallSettings<SqlInstancesRescheduleMaintenanceRequest, Operation>
      rescheduleMaintenanceSettings() {
    return ((SqlInstancesServiceStubSettings) getStubSettings()).rescheduleMaintenanceSettings();
  }

  /** Returns the object with the settings used for calls to verifyExternalSyncSettings. */
  public UnaryCallSettings<
          SqlInstancesVerifyExternalSyncSettingsRequest,
          SqlInstancesVerifyExternalSyncSettingsResponse>
      verifyExternalSyncSettingsSettings() {
    return ((SqlInstancesServiceStubSettings) getStubSettings())
        .verifyExternalSyncSettingsSettings();
  }

  /** Returns the object with the settings used for calls to startExternalSync. */
  public UnaryCallSettings<SqlInstancesStartExternalSyncRequest, Operation>
      startExternalSyncSettings() {
    return ((SqlInstancesServiceStubSettings) getStubSettings()).startExternalSyncSettings();
  }

  /** Returns the object with the settings used for calls to performDiskShrink. */
  public UnaryCallSettings<SqlInstancesPerformDiskShrinkRequest, Operation>
      performDiskShrinkSettings() {
    return ((SqlInstancesServiceStubSettings) getStubSettings()).performDiskShrinkSettings();
  }

  /** Returns the object with the settings used for calls to getDiskShrinkConfig. */
  public UnaryCallSettings<
          SqlInstancesGetDiskShrinkConfigRequest, SqlInstancesGetDiskShrinkConfigResponse>
      getDiskShrinkConfigSettings() {
    return ((SqlInstancesServiceStubSettings) getStubSettings()).getDiskShrinkConfigSettings();
  }

  /** Returns the object with the settings used for calls to resetReplicaSize. */
  public UnaryCallSettings<SqlInstancesResetReplicaSizeRequest, Operation>
      resetReplicaSizeSettings() {
    return ((SqlInstancesServiceStubSettings) getStubSettings()).resetReplicaSizeSettings();
  }

  /** Returns the object with the settings used for calls to getLatestRecoveryTime. */
  public UnaryCallSettings<
          SqlInstancesGetLatestRecoveryTimeRequest, SqlInstancesGetLatestRecoveryTimeResponse>
      getLatestRecoveryTimeSettings() {
    return ((SqlInstancesServiceStubSettings) getStubSettings()).getLatestRecoveryTimeSettings();
  }

  /** Returns the object with the settings used for calls to executeSql. */
  public UnaryCallSettings<SqlInstancesExecuteSqlRequest, SqlInstancesExecuteSqlResponse>
      executeSqlSettings() {
    return ((SqlInstancesServiceStubSettings) getStubSettings()).executeSqlSettings();
  }

  /** Returns the object with the settings used for calls to acquireSsrsLease. */
  public UnaryCallSettings<
          SqlInstancesAcquireSsrsLeaseRequest, SqlInstancesAcquireSsrsLeaseResponse>
      acquireSsrsLeaseSettings() {
    return ((SqlInstancesServiceStubSettings) getStubSettings()).acquireSsrsLeaseSettings();
  }

  /** Returns the object with the settings used for calls to releaseSsrsLease. */
  public UnaryCallSettings<
          SqlInstancesReleaseSsrsLeaseRequest, SqlInstancesReleaseSsrsLeaseResponse>
      releaseSsrsLeaseSettings() {
    return ((SqlInstancesServiceStubSettings) getStubSettings()).releaseSsrsLeaseSettings();
  }

  /** Returns the object with the settings used for calls to preCheckMajorVersionUpgrade. */
  public UnaryCallSettings<SqlInstancesPreCheckMajorVersionUpgradeRequest, Operation>
      preCheckMajorVersionUpgradeSettings() {
    return ((SqlInstancesServiceStubSettings) getStubSettings())
        .preCheckMajorVersionUpgradeSettings();
  }

  /** Returns the object with the settings used for calls to pointInTimeRestore. */
  public UnaryCallSettings<SqlInstancesPointInTimeRestoreRequest, Operation>
      pointInTimeRestoreSettings() {
    return ((SqlInstancesServiceStubSettings) getStubSettings()).pointInTimeRestoreSettings();
  }

  public static final SqlInstancesServiceSettings create(SqlInstancesServiceStubSettings stub)
      throws IOException {
    return new SqlInstancesServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return SqlInstancesServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return SqlInstancesServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return SqlInstancesServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return SqlInstancesServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return SqlInstancesServiceStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return SqlInstancesServiceStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return SqlInstancesServiceStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return SqlInstancesServiceStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected SqlInstancesServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for SqlInstancesServiceSettings. */
  public static class Builder extends ClientSettings.Builder<SqlInstancesServiceSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(@Nullable ClientContext clientContext) {
      super(SqlInstancesServiceStubSettings.newBuilder(clientContext));
    }

    protected Builder(SqlInstancesServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(SqlInstancesServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(SqlInstancesServiceStubSettings.newBuilder());
    }

    private static Builder createHttpJsonDefault() {
      return new Builder(SqlInstancesServiceStubSettings.newHttpJsonBuilder());
    }

    public SqlInstancesServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((SqlInstancesServiceStubSettings.Builder) getStubSettings());
    }

    /**
     * Applies the given settings updater function to all of the unary API methods in this service.
     *
     * <p>Note: This method does not support applying settings to streaming methods.
     */
    public Builder applyToAllUnaryMethods(
        ApiFunction<UnaryCallSettings.Builder<?, ?>, Void> settingsUpdater) {
      super.applyToAllUnaryMethods(
          getStubSettingsBuilder().unaryMethodSettingsBuilders(), settingsUpdater);
      return this;
    }

    /** Returns the builder for the settings used for calls to addServerCa. */
    public UnaryCallSettings.Builder<SqlInstancesAddServerCaRequest, Operation>
        addServerCaSettings() {
      return getStubSettingsBuilder().addServerCaSettings();
    }

    /** Returns the builder for the settings used for calls to addServerCertificate. */
    public UnaryCallSettings.Builder<SqlInstancesAddServerCertificateRequest, Operation>
        addServerCertificateSettings() {
      return getStubSettingsBuilder().addServerCertificateSettings();
    }

    /** Returns the builder for the settings used for calls to addEntraIdCertificate. */
    public UnaryCallSettings.Builder<SqlInstancesAddEntraIdCertificateRequest, Operation>
        addEntraIdCertificateSettings() {
      return getStubSettingsBuilder().addEntraIdCertificateSettings();
    }

    /** Returns the builder for the settings used for calls to clone. */
    public UnaryCallSettings.Builder<SqlInstancesCloneRequest, Operation> cloneSettings() {
      return getStubSettingsBuilder().cloneSettings();
    }

    /** Returns the builder for the settings used for calls to delete. */
    public UnaryCallSettings.Builder<SqlInstancesDeleteRequest, Operation> deleteSettings() {
      return getStubSettingsBuilder().deleteSettings();
    }

    /** Returns the builder for the settings used for calls to demoteMaster. */
    public UnaryCallSettings.Builder<SqlInstancesDemoteMasterRequest, Operation>
        demoteMasterSettings() {
      return getStubSettingsBuilder().demoteMasterSettings();
    }

    /** Returns the builder for the settings used for calls to demote. */
    public UnaryCallSettings.Builder<SqlInstancesDemoteRequest, Operation> demoteSettings() {
      return getStubSettingsBuilder().demoteSettings();
    }

    /** Returns the builder for the settings used for calls to export. */
    public UnaryCallSettings.Builder<SqlInstancesExportRequest, Operation> exportSettings() {
      return getStubSettingsBuilder().exportSettings();
    }

    /** Returns the builder for the settings used for calls to failover. */
    public UnaryCallSettings.Builder<SqlInstancesFailoverRequest, Operation> failoverSettings() {
      return getStubSettingsBuilder().failoverSettings();
    }

    /** Returns the builder for the settings used for calls to reencrypt. */
    public UnaryCallSettings.Builder<SqlInstancesReencryptRequest, Operation> reencryptSettings() {
      return getStubSettingsBuilder().reencryptSettings();
    }

    /** Returns the builder for the settings used for calls to get. */
    public UnaryCallSettings.Builder<SqlInstancesGetRequest, DatabaseInstance> getSettings() {
      return getStubSettingsBuilder().getSettings();
    }

    /** Returns the builder for the settings used for calls to import_. */
    public UnaryCallSettings.Builder<SqlInstancesImportRequest, Operation> import_Settings() {
      return getStubSettingsBuilder().import_Settings();
    }

    /** Returns the builder for the settings used for calls to insert. */
    public UnaryCallSettings.Builder<SqlInstancesInsertRequest, Operation> insertSettings() {
      return getStubSettingsBuilder().insertSettings();
    }

    /** Returns the builder for the settings used for calls to list. */
    public UnaryCallSettings.Builder<SqlInstancesListRequest, InstancesListResponse>
        listSettings() {
      return getStubSettingsBuilder().listSettings();
    }

    /** Returns the builder for the settings used for calls to listServerCas. */
    public UnaryCallSettings.Builder<
            SqlInstancesListServerCasRequest, InstancesListServerCasResponse>
        listServerCasSettings() {
      return getStubSettingsBuilder().listServerCasSettings();
    }

    /** Returns the builder for the settings used for calls to listServerCertificates. */
    public UnaryCallSettings.Builder<
            SqlInstancesListServerCertificatesRequest, InstancesListServerCertificatesResponse>
        listServerCertificatesSettings() {
      return getStubSettingsBuilder().listServerCertificatesSettings();
    }

    /** Returns the builder for the settings used for calls to listEntraIdCertificates. */
    public UnaryCallSettings.Builder<
            SqlInstancesListEntraIdCertificatesRequest, InstancesListEntraIdCertificatesResponse>
        listEntraIdCertificatesSettings() {
      return getStubSettingsBuilder().listEntraIdCertificatesSettings();
    }

    /** Returns the builder for the settings used for calls to patch. */
    public UnaryCallSettings.Builder<SqlInstancesPatchRequest, Operation> patchSettings() {
      return getStubSettingsBuilder().patchSettings();
    }

    /** Returns the builder for the settings used for calls to promoteReplica. */
    public UnaryCallSettings.Builder<SqlInstancesPromoteReplicaRequest, Operation>
        promoteReplicaSettings() {
      return getStubSettingsBuilder().promoteReplicaSettings();
    }

    /** Returns the builder for the settings used for calls to switchover. */
    public UnaryCallSettings.Builder<SqlInstancesSwitchoverRequest, Operation>
        switchoverSettings() {
      return getStubSettingsBuilder().switchoverSettings();
    }

    /** Returns the builder for the settings used for calls to resetSslConfig. */
    public UnaryCallSettings.Builder<SqlInstancesResetSslConfigRequest, Operation>
        resetSslConfigSettings() {
      return getStubSettingsBuilder().resetSslConfigSettings();
    }

    /** Returns the builder for the settings used for calls to restart. */
    public UnaryCallSettings.Builder<SqlInstancesRestartRequest, Operation> restartSettings() {
      return getStubSettingsBuilder().restartSettings();
    }

    /** Returns the builder for the settings used for calls to restoreBackup. */
    public UnaryCallSettings.Builder<SqlInstancesRestoreBackupRequest, Operation>
        restoreBackupSettings() {
      return getStubSettingsBuilder().restoreBackupSettings();
    }

    /** Returns the builder for the settings used for calls to rotateServerCa. */
    public UnaryCallSettings.Builder<SqlInstancesRotateServerCaRequest, Operation>
        rotateServerCaSettings() {
      return getStubSettingsBuilder().rotateServerCaSettings();
    }

    /** Returns the builder for the settings used for calls to rotateServerCertificate. */
    public UnaryCallSettings.Builder<SqlInstancesRotateServerCertificateRequest, Operation>
        rotateServerCertificateSettings() {
      return getStubSettingsBuilder().rotateServerCertificateSettings();
    }

    /** Returns the builder for the settings used for calls to rotateEntraIdCertificate. */
    public UnaryCallSettings.Builder<SqlInstancesRotateEntraIdCertificateRequest, Operation>
        rotateEntraIdCertificateSettings() {
      return getStubSettingsBuilder().rotateEntraIdCertificateSettings();
    }

    /** Returns the builder for the settings used for calls to startReplica. */
    public UnaryCallSettings.Builder<SqlInstancesStartReplicaRequest, Operation>
        startReplicaSettings() {
      return getStubSettingsBuilder().startReplicaSettings();
    }

    /** Returns the builder for the settings used for calls to stopReplica. */
    public UnaryCallSettings.Builder<SqlInstancesStopReplicaRequest, Operation>
        stopReplicaSettings() {
      return getStubSettingsBuilder().stopReplicaSettings();
    }

    /** Returns the builder for the settings used for calls to truncateLog. */
    public UnaryCallSettings.Builder<SqlInstancesTruncateLogRequest, Operation>
        truncateLogSettings() {
      return getStubSettingsBuilder().truncateLogSettings();
    }

    /** Returns the builder for the settings used for calls to update. */
    public UnaryCallSettings.Builder<SqlInstancesUpdateRequest, Operation> updateSettings() {
      return getStubSettingsBuilder().updateSettings();
    }

    /** Returns the builder for the settings used for calls to createEphemeral. */
    public UnaryCallSettings.Builder<SqlInstancesCreateEphemeralCertRequest, SslCert>
        createEphemeralSettings() {
      return getStubSettingsBuilder().createEphemeralSettings();
    }

    /** Returns the builder for the settings used for calls to rescheduleMaintenance. */
    public UnaryCallSettings.Builder<SqlInstancesRescheduleMaintenanceRequest, Operation>
        rescheduleMaintenanceSettings() {
      return getStubSettingsBuilder().rescheduleMaintenanceSettings();
    }

    /** Returns the builder for the settings used for calls to verifyExternalSyncSettings. */
    public UnaryCallSettings.Builder<
            SqlInstancesVerifyExternalSyncSettingsRequest,
            SqlInstancesVerifyExternalSyncSettingsResponse>
        verifyExternalSyncSettingsSettings() {
      return getStubSettingsBuilder().verifyExternalSyncSettingsSettings();
    }

    /** Returns the builder for the settings used for calls to startExternalSync. */
    public UnaryCallSettings.Builder<SqlInstancesStartExternalSyncRequest, Operation>
        startExternalSyncSettings() {
      return getStubSettingsBuilder().startExternalSyncSettings();
    }

    /** Returns the builder for the settings used for calls to performDiskShrink. */
    public UnaryCallSettings.Builder<SqlInstancesPerformDiskShrinkRequest, Operation>
        performDiskShrinkSettings() {
      return getStubSettingsBuilder().performDiskShrinkSettings();
    }

    /** Returns the builder for the settings used for calls to getDiskShrinkConfig. */
    public UnaryCallSettings.Builder<
            SqlInstancesGetDiskShrinkConfigRequest, SqlInstancesGetDiskShrinkConfigResponse>
        getDiskShrinkConfigSettings() {
      return getStubSettingsBuilder().getDiskShrinkConfigSettings();
    }

    /** Returns the builder for the settings used for calls to resetReplicaSize. */
    public UnaryCallSettings.Builder<SqlInstancesResetReplicaSizeRequest, Operation>
        resetReplicaSizeSettings() {
      return getStubSettingsBuilder().resetReplicaSizeSettings();
    }

    /** Returns the builder for the settings used for calls to getLatestRecoveryTime. */
    public UnaryCallSettings.Builder<
            SqlInstancesGetLatestRecoveryTimeRequest, SqlInstancesGetLatestRecoveryTimeResponse>
        getLatestRecoveryTimeSettings() {
      return getStubSettingsBuilder().getLatestRecoveryTimeSettings();
    }

    /** Returns the builder for the settings used for calls to executeSql. */
    public UnaryCallSettings.Builder<SqlInstancesExecuteSqlRequest, SqlInstancesExecuteSqlResponse>
        executeSqlSettings() {
      return getStubSettingsBuilder().executeSqlSettings();
    }

    /** Returns the builder for the settings used for calls to acquireSsrsLease. */
    public UnaryCallSettings.Builder<
            SqlInstancesAcquireSsrsLeaseRequest, SqlInstancesAcquireSsrsLeaseResponse>
        acquireSsrsLeaseSettings() {
      return getStubSettingsBuilder().acquireSsrsLeaseSettings();
    }

    /** Returns the builder for the settings used for calls to releaseSsrsLease. */
    public UnaryCallSettings.Builder<
            SqlInstancesReleaseSsrsLeaseRequest, SqlInstancesReleaseSsrsLeaseResponse>
        releaseSsrsLeaseSettings() {
      return getStubSettingsBuilder().releaseSsrsLeaseSettings();
    }

    /** Returns the builder for the settings used for calls to preCheckMajorVersionUpgrade. */
    public UnaryCallSettings.Builder<SqlInstancesPreCheckMajorVersionUpgradeRequest, Operation>
        preCheckMajorVersionUpgradeSettings() {
      return getStubSettingsBuilder().preCheckMajorVersionUpgradeSettings();
    }

    /** Returns the builder for the settings used for calls to pointInTimeRestore. */
    public UnaryCallSettings.Builder<SqlInstancesPointInTimeRestoreRequest, Operation>
        pointInTimeRestoreSettings() {
      return getStubSettingsBuilder().pointInTimeRestoreSettings();
    }

    @Override
    public SqlInstancesServiceSettings build() throws IOException {
      return new SqlInstancesServiceSettings(this);
    }
  }
}
