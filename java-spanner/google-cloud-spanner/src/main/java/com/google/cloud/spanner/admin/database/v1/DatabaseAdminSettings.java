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

package com.google.cloud.spanner.admin.database.v1;

import static com.google.cloud.spanner.admin.database.v1.DatabaseAdminClient.ListBackupOperationsPagedResponse;
import static com.google.cloud.spanner.admin.database.v1.DatabaseAdminClient.ListBackupSchedulesPagedResponse;
import static com.google.cloud.spanner.admin.database.v1.DatabaseAdminClient.ListBackupsPagedResponse;
import static com.google.cloud.spanner.admin.database.v1.DatabaseAdminClient.ListDatabaseOperationsPagedResponse;
import static com.google.cloud.spanner.admin.database.v1.DatabaseAdminClient.ListDatabaseRolesPagedResponse;
import static com.google.cloud.spanner.admin.database.v1.DatabaseAdminClient.ListDatabasesPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ClientSettings;
import com.google.api.gax.rpc.OperationCallSettings;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.spanner.admin.database.v1.stub.DatabaseAdminStubSettings;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import com.google.spanner.admin.database.v1.AddSplitPointsRequest;
import com.google.spanner.admin.database.v1.AddSplitPointsResponse;
import com.google.spanner.admin.database.v1.Backup;
import com.google.spanner.admin.database.v1.BackupSchedule;
import com.google.spanner.admin.database.v1.CopyBackupMetadata;
import com.google.spanner.admin.database.v1.CopyBackupRequest;
import com.google.spanner.admin.database.v1.CreateBackupMetadata;
import com.google.spanner.admin.database.v1.CreateBackupRequest;
import com.google.spanner.admin.database.v1.CreateBackupScheduleRequest;
import com.google.spanner.admin.database.v1.CreateDatabaseMetadata;
import com.google.spanner.admin.database.v1.CreateDatabaseRequest;
import com.google.spanner.admin.database.v1.Database;
import com.google.spanner.admin.database.v1.DeleteBackupRequest;
import com.google.spanner.admin.database.v1.DeleteBackupScheduleRequest;
import com.google.spanner.admin.database.v1.DropDatabaseRequest;
import com.google.spanner.admin.database.v1.GetBackupRequest;
import com.google.spanner.admin.database.v1.GetBackupScheduleRequest;
import com.google.spanner.admin.database.v1.GetDatabaseDdlRequest;
import com.google.spanner.admin.database.v1.GetDatabaseDdlResponse;
import com.google.spanner.admin.database.v1.GetDatabaseRequest;
import com.google.spanner.admin.database.v1.InternalUpdateGraphOperationRequest;
import com.google.spanner.admin.database.v1.InternalUpdateGraphOperationResponse;
import com.google.spanner.admin.database.v1.ListBackupOperationsRequest;
import com.google.spanner.admin.database.v1.ListBackupOperationsResponse;
import com.google.spanner.admin.database.v1.ListBackupSchedulesRequest;
import com.google.spanner.admin.database.v1.ListBackupSchedulesResponse;
import com.google.spanner.admin.database.v1.ListBackupsRequest;
import com.google.spanner.admin.database.v1.ListBackupsResponse;
import com.google.spanner.admin.database.v1.ListDatabaseOperationsRequest;
import com.google.spanner.admin.database.v1.ListDatabaseOperationsResponse;
import com.google.spanner.admin.database.v1.ListDatabaseRolesRequest;
import com.google.spanner.admin.database.v1.ListDatabaseRolesResponse;
import com.google.spanner.admin.database.v1.ListDatabasesRequest;
import com.google.spanner.admin.database.v1.ListDatabasesResponse;
import com.google.spanner.admin.database.v1.RestoreDatabaseMetadata;
import com.google.spanner.admin.database.v1.RestoreDatabaseRequest;
import com.google.spanner.admin.database.v1.UpdateBackupRequest;
import com.google.spanner.admin.database.v1.UpdateBackupScheduleRequest;
import com.google.spanner.admin.database.v1.UpdateDatabaseDdlMetadata;
import com.google.spanner.admin.database.v1.UpdateDatabaseDdlRequest;
import com.google.spanner.admin.database.v1.UpdateDatabaseMetadata;
import com.google.spanner.admin.database.v1.UpdateDatabaseRequest;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link DatabaseAdminClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (spanner.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the
 * [RetrySettings](https://cloud.google.com/java/docs/reference/gax/latest/com.google.api.gax.retrying.RetrySettings)
 * of getDatabase:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * DatabaseAdminSettings.Builder databaseAdminSettingsBuilder = DatabaseAdminSettings.newBuilder();
 * databaseAdminSettingsBuilder
 *     .getDatabaseSettings()
 *     .setRetrySettings(
 *         databaseAdminSettingsBuilder
 *             .getDatabaseSettings()
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
 * DatabaseAdminSettings databaseAdminSettings = databaseAdminSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://docs.cloud.google.com/java/docs/client-retries) for additional support in setting
 * retries.
 *
 * <p>To configure the RetrySettings of a Long Running Operation method, create an
 * OperationTimedPollAlgorithm object and update the RPC's polling algorithm. For example, to
 * configure the RetrySettings for createDatabase:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * DatabaseAdminSettings.Builder databaseAdminSettingsBuilder = DatabaseAdminSettings.newBuilder();
 * TimedRetryAlgorithm timedRetryAlgorithm =
 *     OperationalTimedPollAlgorithm.create(
 *         RetrySettings.newBuilder()
 *             .setInitialRetryDelayDuration(Duration.ofMillis(500))
 *             .setRetryDelayMultiplier(1.5)
 *             .setMaxRetryDelayDuration(Duration.ofMillis(5000))
 *             .setTotalTimeoutDuration(Duration.ofHours(24))
 *             .build());
 * databaseAdminSettingsBuilder
 *     .createClusterOperationSettings()
 *     .setPollingAlgorithm(timedRetryAlgorithm)
 *     .build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class DatabaseAdminSettings extends ClientSettings<DatabaseAdminSettings> {

  /** Returns the object with the settings used for calls to listDatabases. */
  public PagedCallSettings<ListDatabasesRequest, ListDatabasesResponse, ListDatabasesPagedResponse>
      listDatabasesSettings() {
    return ((DatabaseAdminStubSettings) getStubSettings()).listDatabasesSettings();
  }

  /** Returns the object with the settings used for calls to createDatabase. */
  public UnaryCallSettings<CreateDatabaseRequest, Operation> createDatabaseSettings() {
    return ((DatabaseAdminStubSettings) getStubSettings()).createDatabaseSettings();
  }

  /** Returns the object with the settings used for calls to createDatabase. */
  public OperationCallSettings<CreateDatabaseRequest, Database, CreateDatabaseMetadata>
      createDatabaseOperationSettings() {
    return ((DatabaseAdminStubSettings) getStubSettings()).createDatabaseOperationSettings();
  }

  /** Returns the object with the settings used for calls to getDatabase. */
  public UnaryCallSettings<GetDatabaseRequest, Database> getDatabaseSettings() {
    return ((DatabaseAdminStubSettings) getStubSettings()).getDatabaseSettings();
  }

  /** Returns the object with the settings used for calls to updateDatabase. */
  public UnaryCallSettings<UpdateDatabaseRequest, Operation> updateDatabaseSettings() {
    return ((DatabaseAdminStubSettings) getStubSettings()).updateDatabaseSettings();
  }

  /** Returns the object with the settings used for calls to updateDatabase. */
  public OperationCallSettings<UpdateDatabaseRequest, Database, UpdateDatabaseMetadata>
      updateDatabaseOperationSettings() {
    return ((DatabaseAdminStubSettings) getStubSettings()).updateDatabaseOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateDatabaseDdl. */
  public UnaryCallSettings<UpdateDatabaseDdlRequest, Operation> updateDatabaseDdlSettings() {
    return ((DatabaseAdminStubSettings) getStubSettings()).updateDatabaseDdlSettings();
  }

  /** Returns the object with the settings used for calls to updateDatabaseDdl. */
  public OperationCallSettings<UpdateDatabaseDdlRequest, Empty, UpdateDatabaseDdlMetadata>
      updateDatabaseDdlOperationSettings() {
    return ((DatabaseAdminStubSettings) getStubSettings()).updateDatabaseDdlOperationSettings();
  }

  /** Returns the object with the settings used for calls to dropDatabase. */
  public UnaryCallSettings<DropDatabaseRequest, Empty> dropDatabaseSettings() {
    return ((DatabaseAdminStubSettings) getStubSettings()).dropDatabaseSettings();
  }

  /** Returns the object with the settings used for calls to getDatabaseDdl. */
  public UnaryCallSettings<GetDatabaseDdlRequest, GetDatabaseDdlResponse> getDatabaseDdlSettings() {
    return ((DatabaseAdminStubSettings) getStubSettings()).getDatabaseDdlSettings();
  }

  /** Returns the object with the settings used for calls to setIamPolicy. */
  public UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings() {
    return ((DatabaseAdminStubSettings) getStubSettings()).setIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to getIamPolicy. */
  public UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings() {
    return ((DatabaseAdminStubSettings) getStubSettings()).getIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to testIamPermissions. */
  public UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings() {
    return ((DatabaseAdminStubSettings) getStubSettings()).testIamPermissionsSettings();
  }

  /** Returns the object with the settings used for calls to createBackup. */
  public UnaryCallSettings<CreateBackupRequest, Operation> createBackupSettings() {
    return ((DatabaseAdminStubSettings) getStubSettings()).createBackupSettings();
  }

  /** Returns the object with the settings used for calls to createBackup. */
  public OperationCallSettings<CreateBackupRequest, Backup, CreateBackupMetadata>
      createBackupOperationSettings() {
    return ((DatabaseAdminStubSettings) getStubSettings()).createBackupOperationSettings();
  }

  /** Returns the object with the settings used for calls to copyBackup. */
  public UnaryCallSettings<CopyBackupRequest, Operation> copyBackupSettings() {
    return ((DatabaseAdminStubSettings) getStubSettings()).copyBackupSettings();
  }

  /** Returns the object with the settings used for calls to copyBackup. */
  public OperationCallSettings<CopyBackupRequest, Backup, CopyBackupMetadata>
      copyBackupOperationSettings() {
    return ((DatabaseAdminStubSettings) getStubSettings()).copyBackupOperationSettings();
  }

  /** Returns the object with the settings used for calls to getBackup. */
  public UnaryCallSettings<GetBackupRequest, Backup> getBackupSettings() {
    return ((DatabaseAdminStubSettings) getStubSettings()).getBackupSettings();
  }

  /** Returns the object with the settings used for calls to updateBackup. */
  public UnaryCallSettings<UpdateBackupRequest, Backup> updateBackupSettings() {
    return ((DatabaseAdminStubSettings) getStubSettings()).updateBackupSettings();
  }

  /** Returns the object with the settings used for calls to deleteBackup. */
  public UnaryCallSettings<DeleteBackupRequest, Empty> deleteBackupSettings() {
    return ((DatabaseAdminStubSettings) getStubSettings()).deleteBackupSettings();
  }

  /** Returns the object with the settings used for calls to listBackups. */
  public PagedCallSettings<ListBackupsRequest, ListBackupsResponse, ListBackupsPagedResponse>
      listBackupsSettings() {
    return ((DatabaseAdminStubSettings) getStubSettings()).listBackupsSettings();
  }

  /** Returns the object with the settings used for calls to restoreDatabase. */
  public UnaryCallSettings<RestoreDatabaseRequest, Operation> restoreDatabaseSettings() {
    return ((DatabaseAdminStubSettings) getStubSettings()).restoreDatabaseSettings();
  }

  /** Returns the object with the settings used for calls to restoreDatabase. */
  public OperationCallSettings<RestoreDatabaseRequest, Database, RestoreDatabaseMetadata>
      restoreDatabaseOperationSettings() {
    return ((DatabaseAdminStubSettings) getStubSettings()).restoreDatabaseOperationSettings();
  }

  /** Returns the object with the settings used for calls to listDatabaseOperations. */
  public PagedCallSettings<
          ListDatabaseOperationsRequest,
          ListDatabaseOperationsResponse,
          ListDatabaseOperationsPagedResponse>
      listDatabaseOperationsSettings() {
    return ((DatabaseAdminStubSettings) getStubSettings()).listDatabaseOperationsSettings();
  }

  /** Returns the object with the settings used for calls to listBackupOperations. */
  public PagedCallSettings<
          ListBackupOperationsRequest,
          ListBackupOperationsResponse,
          ListBackupOperationsPagedResponse>
      listBackupOperationsSettings() {
    return ((DatabaseAdminStubSettings) getStubSettings()).listBackupOperationsSettings();
  }

  /** Returns the object with the settings used for calls to listDatabaseRoles. */
  public PagedCallSettings<
          ListDatabaseRolesRequest, ListDatabaseRolesResponse, ListDatabaseRolesPagedResponse>
      listDatabaseRolesSettings() {
    return ((DatabaseAdminStubSettings) getStubSettings()).listDatabaseRolesSettings();
  }

  /** Returns the object with the settings used for calls to addSplitPoints. */
  public UnaryCallSettings<AddSplitPointsRequest, AddSplitPointsResponse> addSplitPointsSettings() {
    return ((DatabaseAdminStubSettings) getStubSettings()).addSplitPointsSettings();
  }

  /** Returns the object with the settings used for calls to createBackupSchedule. */
  public UnaryCallSettings<CreateBackupScheduleRequest, BackupSchedule>
      createBackupScheduleSettings() {
    return ((DatabaseAdminStubSettings) getStubSettings()).createBackupScheduleSettings();
  }

  /** Returns the object with the settings used for calls to getBackupSchedule. */
  public UnaryCallSettings<GetBackupScheduleRequest, BackupSchedule> getBackupScheduleSettings() {
    return ((DatabaseAdminStubSettings) getStubSettings()).getBackupScheduleSettings();
  }

  /** Returns the object with the settings used for calls to updateBackupSchedule. */
  public UnaryCallSettings<UpdateBackupScheduleRequest, BackupSchedule>
      updateBackupScheduleSettings() {
    return ((DatabaseAdminStubSettings) getStubSettings()).updateBackupScheduleSettings();
  }

  /** Returns the object with the settings used for calls to deleteBackupSchedule. */
  public UnaryCallSettings<DeleteBackupScheduleRequest, Empty> deleteBackupScheduleSettings() {
    return ((DatabaseAdminStubSettings) getStubSettings()).deleteBackupScheduleSettings();
  }

  /** Returns the object with the settings used for calls to listBackupSchedules. */
  public PagedCallSettings<
          ListBackupSchedulesRequest, ListBackupSchedulesResponse, ListBackupSchedulesPagedResponse>
      listBackupSchedulesSettings() {
    return ((DatabaseAdminStubSettings) getStubSettings()).listBackupSchedulesSettings();
  }

  /** Returns the object with the settings used for calls to internalUpdateGraph. */
  public UnaryCallSettings<
          InternalUpdateGraphOperationRequest, InternalUpdateGraphOperationResponse>
      internalUpdateGraphOperationSettings() {
    return ((DatabaseAdminStubSettings) getStubSettings()).internalUpdateGraphOperationSettings();
  }

  public static final DatabaseAdminSettings create(DatabaseAdminStubSettings stub)
      throws IOException {
    return new DatabaseAdminSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return DatabaseAdminStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return DatabaseAdminStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return DatabaseAdminStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return DatabaseAdminStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return DatabaseAdminStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return DatabaseAdminStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return DatabaseAdminStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return DatabaseAdminStubSettings.defaultApiClientHeaderProviderBuilder();
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
  public static Builder newBuilder(ClientContext clientContext) {
    return new Builder(clientContext);
  }

  /** Returns a builder containing all the values of this settings class. */
  public Builder toBuilder() {
    return new Builder(this);
  }

  protected DatabaseAdminSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for DatabaseAdminSettings. */
  public static class Builder extends ClientSettings.Builder<DatabaseAdminSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(DatabaseAdminStubSettings.newBuilder(clientContext));
    }

    protected Builder(DatabaseAdminSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(DatabaseAdminStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(DatabaseAdminStubSettings.newBuilder());
    }

    private static Builder createHttpJsonDefault() {
      return new Builder(DatabaseAdminStubSettings.newHttpJsonBuilder());
    }

    public DatabaseAdminStubSettings.Builder getStubSettingsBuilder() {
      return ((DatabaseAdminStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to listDatabases. */
    public PagedCallSettings.Builder<
            ListDatabasesRequest, ListDatabasesResponse, ListDatabasesPagedResponse>
        listDatabasesSettings() {
      return getStubSettingsBuilder().listDatabasesSettings();
    }

    /** Returns the builder for the settings used for calls to createDatabase. */
    public UnaryCallSettings.Builder<CreateDatabaseRequest, Operation> createDatabaseSettings() {
      return getStubSettingsBuilder().createDatabaseSettings();
    }

    /** Returns the builder for the settings used for calls to createDatabase. */
    public OperationCallSettings.Builder<CreateDatabaseRequest, Database, CreateDatabaseMetadata>
        createDatabaseOperationSettings() {
      return getStubSettingsBuilder().createDatabaseOperationSettings();
    }

    /** Returns the builder for the settings used for calls to getDatabase. */
    public UnaryCallSettings.Builder<GetDatabaseRequest, Database> getDatabaseSettings() {
      return getStubSettingsBuilder().getDatabaseSettings();
    }

    /** Returns the builder for the settings used for calls to updateDatabase. */
    public UnaryCallSettings.Builder<UpdateDatabaseRequest, Operation> updateDatabaseSettings() {
      return getStubSettingsBuilder().updateDatabaseSettings();
    }

    /** Returns the builder for the settings used for calls to updateDatabase. */
    public OperationCallSettings.Builder<UpdateDatabaseRequest, Database, UpdateDatabaseMetadata>
        updateDatabaseOperationSettings() {
      return getStubSettingsBuilder().updateDatabaseOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateDatabaseDdl. */
    public UnaryCallSettings.Builder<UpdateDatabaseDdlRequest, Operation>
        updateDatabaseDdlSettings() {
      return getStubSettingsBuilder().updateDatabaseDdlSettings();
    }

    /** Returns the builder for the settings used for calls to updateDatabaseDdl. */
    public OperationCallSettings.Builder<UpdateDatabaseDdlRequest, Empty, UpdateDatabaseDdlMetadata>
        updateDatabaseDdlOperationSettings() {
      return getStubSettingsBuilder().updateDatabaseDdlOperationSettings();
    }

    /** Returns the builder for the settings used for calls to dropDatabase. */
    public UnaryCallSettings.Builder<DropDatabaseRequest, Empty> dropDatabaseSettings() {
      return getStubSettingsBuilder().dropDatabaseSettings();
    }

    /** Returns the builder for the settings used for calls to getDatabaseDdl. */
    public UnaryCallSettings.Builder<GetDatabaseDdlRequest, GetDatabaseDdlResponse>
        getDatabaseDdlSettings() {
      return getStubSettingsBuilder().getDatabaseDdlSettings();
    }

    /** Returns the builder for the settings used for calls to setIamPolicy. */
    public UnaryCallSettings.Builder<SetIamPolicyRequest, Policy> setIamPolicySettings() {
      return getStubSettingsBuilder().setIamPolicySettings();
    }

    /** Returns the builder for the settings used for calls to getIamPolicy. */
    public UnaryCallSettings.Builder<GetIamPolicyRequest, Policy> getIamPolicySettings() {
      return getStubSettingsBuilder().getIamPolicySettings();
    }

    /** Returns the builder for the settings used for calls to testIamPermissions. */
    public UnaryCallSettings.Builder<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsSettings() {
      return getStubSettingsBuilder().testIamPermissionsSettings();
    }

    /** Returns the builder for the settings used for calls to createBackup. */
    public UnaryCallSettings.Builder<CreateBackupRequest, Operation> createBackupSettings() {
      return getStubSettingsBuilder().createBackupSettings();
    }

    /** Returns the builder for the settings used for calls to createBackup. */
    public OperationCallSettings.Builder<CreateBackupRequest, Backup, CreateBackupMetadata>
        createBackupOperationSettings() {
      return getStubSettingsBuilder().createBackupOperationSettings();
    }

    /** Returns the builder for the settings used for calls to copyBackup. */
    public UnaryCallSettings.Builder<CopyBackupRequest, Operation> copyBackupSettings() {
      return getStubSettingsBuilder().copyBackupSettings();
    }

    /** Returns the builder for the settings used for calls to copyBackup. */
    public OperationCallSettings.Builder<CopyBackupRequest, Backup, CopyBackupMetadata>
        copyBackupOperationSettings() {
      return getStubSettingsBuilder().copyBackupOperationSettings();
    }

    /** Returns the builder for the settings used for calls to getBackup. */
    public UnaryCallSettings.Builder<GetBackupRequest, Backup> getBackupSettings() {
      return getStubSettingsBuilder().getBackupSettings();
    }

    /** Returns the builder for the settings used for calls to updateBackup. */
    public UnaryCallSettings.Builder<UpdateBackupRequest, Backup> updateBackupSettings() {
      return getStubSettingsBuilder().updateBackupSettings();
    }

    /** Returns the builder for the settings used for calls to deleteBackup. */
    public UnaryCallSettings.Builder<DeleteBackupRequest, Empty> deleteBackupSettings() {
      return getStubSettingsBuilder().deleteBackupSettings();
    }

    /** Returns the builder for the settings used for calls to listBackups. */
    public PagedCallSettings.Builder<
            ListBackupsRequest, ListBackupsResponse, ListBackupsPagedResponse>
        listBackupsSettings() {
      return getStubSettingsBuilder().listBackupsSettings();
    }

    /** Returns the builder for the settings used for calls to restoreDatabase. */
    public UnaryCallSettings.Builder<RestoreDatabaseRequest, Operation> restoreDatabaseSettings() {
      return getStubSettingsBuilder().restoreDatabaseSettings();
    }

    /** Returns the builder for the settings used for calls to restoreDatabase. */
    public OperationCallSettings.Builder<RestoreDatabaseRequest, Database, RestoreDatabaseMetadata>
        restoreDatabaseOperationSettings() {
      return getStubSettingsBuilder().restoreDatabaseOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listDatabaseOperations. */
    public PagedCallSettings.Builder<
            ListDatabaseOperationsRequest,
            ListDatabaseOperationsResponse,
            ListDatabaseOperationsPagedResponse>
        listDatabaseOperationsSettings() {
      return getStubSettingsBuilder().listDatabaseOperationsSettings();
    }

    /** Returns the builder for the settings used for calls to listBackupOperations. */
    public PagedCallSettings.Builder<
            ListBackupOperationsRequest,
            ListBackupOperationsResponse,
            ListBackupOperationsPagedResponse>
        listBackupOperationsSettings() {
      return getStubSettingsBuilder().listBackupOperationsSettings();
    }

    /** Returns the builder for the settings used for calls to listDatabaseRoles. */
    public PagedCallSettings.Builder<
            ListDatabaseRolesRequest, ListDatabaseRolesResponse, ListDatabaseRolesPagedResponse>
        listDatabaseRolesSettings() {
      return getStubSettingsBuilder().listDatabaseRolesSettings();
    }

    /** Returns the builder for the settings used for calls to addSplitPoints. */
    public UnaryCallSettings.Builder<AddSplitPointsRequest, AddSplitPointsResponse>
        addSplitPointsSettings() {
      return getStubSettingsBuilder().addSplitPointsSettings();
    }

    /** Returns the builder for the settings used for calls to createBackupSchedule. */
    public UnaryCallSettings.Builder<CreateBackupScheduleRequest, BackupSchedule>
        createBackupScheduleSettings() {
      return getStubSettingsBuilder().createBackupScheduleSettings();
    }

    /** Returns the builder for the settings used for calls to getBackupSchedule. */
    public UnaryCallSettings.Builder<GetBackupScheduleRequest, BackupSchedule>
        getBackupScheduleSettings() {
      return getStubSettingsBuilder().getBackupScheduleSettings();
    }

    /** Returns the builder for the settings used for calls to updateBackupSchedule. */
    public UnaryCallSettings.Builder<UpdateBackupScheduleRequest, BackupSchedule>
        updateBackupScheduleSettings() {
      return getStubSettingsBuilder().updateBackupScheduleSettings();
    }

    /** Returns the builder for the settings used for calls to deleteBackupSchedule. */
    public UnaryCallSettings.Builder<DeleteBackupScheduleRequest, Empty>
        deleteBackupScheduleSettings() {
      return getStubSettingsBuilder().deleteBackupScheduleSettings();
    }

    /** Returns the builder for the settings used for calls to listBackupSchedules. */
    public PagedCallSettings.Builder<
            ListBackupSchedulesRequest,
            ListBackupSchedulesResponse,
            ListBackupSchedulesPagedResponse>
        listBackupSchedulesSettings() {
      return getStubSettingsBuilder().listBackupSchedulesSettings();
    }

    /** Returns the builder for the settings used for calls to internalUpdateGraph. */
    public UnaryCallSettings.Builder<
            InternalUpdateGraphOperationRequest, InternalUpdateGraphOperationResponse>
        internalUpdateGraphOperationSettings() {
      return getStubSettingsBuilder().internalUpdateGraphOperationSettings();
    }

    @Override
    public DatabaseAdminSettings build() throws IOException {
      return new DatabaseAdminSettings(this);
    }
  }
}
