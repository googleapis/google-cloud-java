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

package com.google.cloud.firestore.v1;

import static com.google.cloud.firestore.v1.FirestoreAdminClient.ListFieldsPagedResponse;
import static com.google.cloud.firestore.v1.FirestoreAdminClient.ListIndexesPagedResponse;

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
import com.google.cloud.firestore.v1.stub.FirestoreAdminStubSettings;
import com.google.firestore.admin.v1.Backup;
import com.google.firestore.admin.v1.BackupSchedule;
import com.google.firestore.admin.v1.BulkDeleteDocumentsMetadata;
import com.google.firestore.admin.v1.BulkDeleteDocumentsRequest;
import com.google.firestore.admin.v1.BulkDeleteDocumentsResponse;
import com.google.firestore.admin.v1.CreateBackupScheduleRequest;
import com.google.firestore.admin.v1.CreateDatabaseMetadata;
import com.google.firestore.admin.v1.CreateDatabaseRequest;
import com.google.firestore.admin.v1.CreateIndexRequest;
import com.google.firestore.admin.v1.Database;
import com.google.firestore.admin.v1.DeleteBackupRequest;
import com.google.firestore.admin.v1.DeleteBackupScheduleRequest;
import com.google.firestore.admin.v1.DeleteDatabaseMetadata;
import com.google.firestore.admin.v1.DeleteDatabaseRequest;
import com.google.firestore.admin.v1.DeleteIndexRequest;
import com.google.firestore.admin.v1.ExportDocumentsMetadata;
import com.google.firestore.admin.v1.ExportDocumentsRequest;
import com.google.firestore.admin.v1.ExportDocumentsResponse;
import com.google.firestore.admin.v1.Field;
import com.google.firestore.admin.v1.FieldOperationMetadata;
import com.google.firestore.admin.v1.GetBackupRequest;
import com.google.firestore.admin.v1.GetBackupScheduleRequest;
import com.google.firestore.admin.v1.GetDatabaseRequest;
import com.google.firestore.admin.v1.GetFieldRequest;
import com.google.firestore.admin.v1.GetIndexRequest;
import com.google.firestore.admin.v1.ImportDocumentsMetadata;
import com.google.firestore.admin.v1.ImportDocumentsRequest;
import com.google.firestore.admin.v1.Index;
import com.google.firestore.admin.v1.IndexOperationMetadata;
import com.google.firestore.admin.v1.ListBackupSchedulesRequest;
import com.google.firestore.admin.v1.ListBackupSchedulesResponse;
import com.google.firestore.admin.v1.ListBackupsRequest;
import com.google.firestore.admin.v1.ListBackupsResponse;
import com.google.firestore.admin.v1.ListDatabasesRequest;
import com.google.firestore.admin.v1.ListDatabasesResponse;
import com.google.firestore.admin.v1.ListFieldsRequest;
import com.google.firestore.admin.v1.ListFieldsResponse;
import com.google.firestore.admin.v1.ListIndexesRequest;
import com.google.firestore.admin.v1.ListIndexesResponse;
import com.google.firestore.admin.v1.RestoreDatabaseMetadata;
import com.google.firestore.admin.v1.RestoreDatabaseRequest;
import com.google.firestore.admin.v1.UpdateBackupScheduleRequest;
import com.google.firestore.admin.v1.UpdateDatabaseMetadata;
import com.google.firestore.admin.v1.UpdateDatabaseRequest;
import com.google.firestore.admin.v1.UpdateFieldRequest;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link FirestoreAdminClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (firestore.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the
 * [RetrySettings](https://cloud.google.com/java/docs/reference/gax/latest/com.google.api.gax.retrying.RetrySettings)
 * of getIndex:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * FirestoreAdminSettings.Builder firestoreAdminSettingsBuilder =
 *     FirestoreAdminSettings.newBuilder();
 * firestoreAdminSettingsBuilder
 *     .getIndexSettings()
 *     .setRetrySettings(
 *         firestoreAdminSettingsBuilder
 *             .getIndexSettings()
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
 * FirestoreAdminSettings firestoreAdminSettings = firestoreAdminSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://github.com/googleapis/google-cloud-java/blob/main/docs/client_retries.md) for
 * additional support in setting retries.
 *
 * <p>To configure the RetrySettings of a Long Running Operation method, create an
 * OperationTimedPollAlgorithm object and update the RPC's polling algorithm. For example, to
 * configure the RetrySettings for createIndex:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * FirestoreAdminSettings.Builder firestoreAdminSettingsBuilder =
 *     FirestoreAdminSettings.newBuilder();
 * TimedRetryAlgorithm timedRetryAlgorithm =
 *     OperationalTimedPollAlgorithm.create(
 *         RetrySettings.newBuilder()
 *             .setInitialRetryDelayDuration(Duration.ofMillis(500))
 *             .setRetryDelayMultiplier(1.5)
 *             .setMaxRetryDelayDuration(Duration.ofMillis(5000))
 *             .setTotalTimeoutDuration(Duration.ofHours(24))
 *             .build());
 * firestoreAdminSettingsBuilder
 *     .createClusterOperationSettings()
 *     .setPollingAlgorithm(timedRetryAlgorithm)
 *     .build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class FirestoreAdminSettings extends ClientSettings<FirestoreAdminSettings> {

  /** Returns the object with the settings used for calls to createIndex. */
  public UnaryCallSettings<CreateIndexRequest, Operation> createIndexSettings() {
    return ((FirestoreAdminStubSettings) getStubSettings()).createIndexSettings();
  }

  /** Returns the object with the settings used for calls to createIndex. */
  public OperationCallSettings<CreateIndexRequest, Index, IndexOperationMetadata>
      createIndexOperationSettings() {
    return ((FirestoreAdminStubSettings) getStubSettings()).createIndexOperationSettings();
  }

  /** Returns the object with the settings used for calls to listIndexes. */
  public PagedCallSettings<ListIndexesRequest, ListIndexesResponse, ListIndexesPagedResponse>
      listIndexesSettings() {
    return ((FirestoreAdminStubSettings) getStubSettings()).listIndexesSettings();
  }

  /** Returns the object with the settings used for calls to getIndex. */
  public UnaryCallSettings<GetIndexRequest, Index> getIndexSettings() {
    return ((FirestoreAdminStubSettings) getStubSettings()).getIndexSettings();
  }

  /** Returns the object with the settings used for calls to deleteIndex. */
  public UnaryCallSettings<DeleteIndexRequest, Empty> deleteIndexSettings() {
    return ((FirestoreAdminStubSettings) getStubSettings()).deleteIndexSettings();
  }

  /** Returns the object with the settings used for calls to getField. */
  public UnaryCallSettings<GetFieldRequest, Field> getFieldSettings() {
    return ((FirestoreAdminStubSettings) getStubSettings()).getFieldSettings();
  }

  /** Returns the object with the settings used for calls to updateField. */
  public UnaryCallSettings<UpdateFieldRequest, Operation> updateFieldSettings() {
    return ((FirestoreAdminStubSettings) getStubSettings()).updateFieldSettings();
  }

  /** Returns the object with the settings used for calls to updateField. */
  public OperationCallSettings<UpdateFieldRequest, Field, FieldOperationMetadata>
      updateFieldOperationSettings() {
    return ((FirestoreAdminStubSettings) getStubSettings()).updateFieldOperationSettings();
  }

  /** Returns the object with the settings used for calls to listFields. */
  public PagedCallSettings<ListFieldsRequest, ListFieldsResponse, ListFieldsPagedResponse>
      listFieldsSettings() {
    return ((FirestoreAdminStubSettings) getStubSettings()).listFieldsSettings();
  }

  /** Returns the object with the settings used for calls to exportDocuments. */
  public UnaryCallSettings<ExportDocumentsRequest, Operation> exportDocumentsSettings() {
    return ((FirestoreAdminStubSettings) getStubSettings()).exportDocumentsSettings();
  }

  /** Returns the object with the settings used for calls to exportDocuments. */
  public OperationCallSettings<
          ExportDocumentsRequest, ExportDocumentsResponse, ExportDocumentsMetadata>
      exportDocumentsOperationSettings() {
    return ((FirestoreAdminStubSettings) getStubSettings()).exportDocumentsOperationSettings();
  }

  /** Returns the object with the settings used for calls to importDocuments. */
  public UnaryCallSettings<ImportDocumentsRequest, Operation> importDocumentsSettings() {
    return ((FirestoreAdminStubSettings) getStubSettings()).importDocumentsSettings();
  }

  /** Returns the object with the settings used for calls to importDocuments. */
  public OperationCallSettings<ImportDocumentsRequest, Empty, ImportDocumentsMetadata>
      importDocumentsOperationSettings() {
    return ((FirestoreAdminStubSettings) getStubSettings()).importDocumentsOperationSettings();
  }

  /** Returns the object with the settings used for calls to bulkDeleteDocuments. */
  public UnaryCallSettings<BulkDeleteDocumentsRequest, Operation> bulkDeleteDocumentsSettings() {
    return ((FirestoreAdminStubSettings) getStubSettings()).bulkDeleteDocumentsSettings();
  }

  /** Returns the object with the settings used for calls to bulkDeleteDocuments. */
  public OperationCallSettings<
          BulkDeleteDocumentsRequest, BulkDeleteDocumentsResponse, BulkDeleteDocumentsMetadata>
      bulkDeleteDocumentsOperationSettings() {
    return ((FirestoreAdminStubSettings) getStubSettings()).bulkDeleteDocumentsOperationSettings();
  }

  /** Returns the object with the settings used for calls to createDatabase. */
  public UnaryCallSettings<CreateDatabaseRequest, Operation> createDatabaseSettings() {
    return ((FirestoreAdminStubSettings) getStubSettings()).createDatabaseSettings();
  }

  /** Returns the object with the settings used for calls to createDatabase. */
  public OperationCallSettings<CreateDatabaseRequest, Database, CreateDatabaseMetadata>
      createDatabaseOperationSettings() {
    return ((FirestoreAdminStubSettings) getStubSettings()).createDatabaseOperationSettings();
  }

  /** Returns the object with the settings used for calls to getDatabase. */
  public UnaryCallSettings<GetDatabaseRequest, Database> getDatabaseSettings() {
    return ((FirestoreAdminStubSettings) getStubSettings()).getDatabaseSettings();
  }

  /** Returns the object with the settings used for calls to listDatabases. */
  public UnaryCallSettings<ListDatabasesRequest, ListDatabasesResponse> listDatabasesSettings() {
    return ((FirestoreAdminStubSettings) getStubSettings()).listDatabasesSettings();
  }

  /** Returns the object with the settings used for calls to updateDatabase. */
  public UnaryCallSettings<UpdateDatabaseRequest, Operation> updateDatabaseSettings() {
    return ((FirestoreAdminStubSettings) getStubSettings()).updateDatabaseSettings();
  }

  /** Returns the object with the settings used for calls to updateDatabase. */
  public OperationCallSettings<UpdateDatabaseRequest, Database, UpdateDatabaseMetadata>
      updateDatabaseOperationSettings() {
    return ((FirestoreAdminStubSettings) getStubSettings()).updateDatabaseOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteDatabase. */
  public UnaryCallSettings<DeleteDatabaseRequest, Operation> deleteDatabaseSettings() {
    return ((FirestoreAdminStubSettings) getStubSettings()).deleteDatabaseSettings();
  }

  /** Returns the object with the settings used for calls to deleteDatabase. */
  public OperationCallSettings<DeleteDatabaseRequest, Database, DeleteDatabaseMetadata>
      deleteDatabaseOperationSettings() {
    return ((FirestoreAdminStubSettings) getStubSettings()).deleteDatabaseOperationSettings();
  }

  /** Returns the object with the settings used for calls to getBackup. */
  public UnaryCallSettings<GetBackupRequest, Backup> getBackupSettings() {
    return ((FirestoreAdminStubSettings) getStubSettings()).getBackupSettings();
  }

  /** Returns the object with the settings used for calls to listBackups. */
  public UnaryCallSettings<ListBackupsRequest, ListBackupsResponse> listBackupsSettings() {
    return ((FirestoreAdminStubSettings) getStubSettings()).listBackupsSettings();
  }

  /** Returns the object with the settings used for calls to deleteBackup. */
  public UnaryCallSettings<DeleteBackupRequest, Empty> deleteBackupSettings() {
    return ((FirestoreAdminStubSettings) getStubSettings()).deleteBackupSettings();
  }

  /** Returns the object with the settings used for calls to restoreDatabase. */
  public UnaryCallSettings<RestoreDatabaseRequest, Operation> restoreDatabaseSettings() {
    return ((FirestoreAdminStubSettings) getStubSettings()).restoreDatabaseSettings();
  }

  /** Returns the object with the settings used for calls to restoreDatabase. */
  public OperationCallSettings<RestoreDatabaseRequest, Database, RestoreDatabaseMetadata>
      restoreDatabaseOperationSettings() {
    return ((FirestoreAdminStubSettings) getStubSettings()).restoreDatabaseOperationSettings();
  }

  /** Returns the object with the settings used for calls to createBackupSchedule. */
  public UnaryCallSettings<CreateBackupScheduleRequest, BackupSchedule>
      createBackupScheduleSettings() {
    return ((FirestoreAdminStubSettings) getStubSettings()).createBackupScheduleSettings();
  }

  /** Returns the object with the settings used for calls to getBackupSchedule. */
  public UnaryCallSettings<GetBackupScheduleRequest, BackupSchedule> getBackupScheduleSettings() {
    return ((FirestoreAdminStubSettings) getStubSettings()).getBackupScheduleSettings();
  }

  /** Returns the object with the settings used for calls to listBackupSchedules. */
  public UnaryCallSettings<ListBackupSchedulesRequest, ListBackupSchedulesResponse>
      listBackupSchedulesSettings() {
    return ((FirestoreAdminStubSettings) getStubSettings()).listBackupSchedulesSettings();
  }

  /** Returns the object with the settings used for calls to updateBackupSchedule. */
  public UnaryCallSettings<UpdateBackupScheduleRequest, BackupSchedule>
      updateBackupScheduleSettings() {
    return ((FirestoreAdminStubSettings) getStubSettings()).updateBackupScheduleSettings();
  }

  /** Returns the object with the settings used for calls to deleteBackupSchedule. */
  public UnaryCallSettings<DeleteBackupScheduleRequest, Empty> deleteBackupScheduleSettings() {
    return ((FirestoreAdminStubSettings) getStubSettings()).deleteBackupScheduleSettings();
  }

  public static final FirestoreAdminSettings create(FirestoreAdminStubSettings stub)
      throws IOException {
    return new FirestoreAdminSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return FirestoreAdminStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return FirestoreAdminStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return FirestoreAdminStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return FirestoreAdminStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return FirestoreAdminStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return FirestoreAdminStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return FirestoreAdminStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return FirestoreAdminStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected FirestoreAdminSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for FirestoreAdminSettings. */
  public static class Builder extends ClientSettings.Builder<FirestoreAdminSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(FirestoreAdminStubSettings.newBuilder(clientContext));
    }

    protected Builder(FirestoreAdminSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(FirestoreAdminStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(FirestoreAdminStubSettings.newBuilder());
    }

    private static Builder createHttpJsonDefault() {
      return new Builder(FirestoreAdminStubSettings.newHttpJsonBuilder());
    }

    public FirestoreAdminStubSettings.Builder getStubSettingsBuilder() {
      return ((FirestoreAdminStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to createIndex. */
    public UnaryCallSettings.Builder<CreateIndexRequest, Operation> createIndexSettings() {
      return getStubSettingsBuilder().createIndexSettings();
    }

    /** Returns the builder for the settings used for calls to createIndex. */
    public OperationCallSettings.Builder<CreateIndexRequest, Index, IndexOperationMetadata>
        createIndexOperationSettings() {
      return getStubSettingsBuilder().createIndexOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listIndexes. */
    public PagedCallSettings.Builder<
            ListIndexesRequest, ListIndexesResponse, ListIndexesPagedResponse>
        listIndexesSettings() {
      return getStubSettingsBuilder().listIndexesSettings();
    }

    /** Returns the builder for the settings used for calls to getIndex. */
    public UnaryCallSettings.Builder<GetIndexRequest, Index> getIndexSettings() {
      return getStubSettingsBuilder().getIndexSettings();
    }

    /** Returns the builder for the settings used for calls to deleteIndex. */
    public UnaryCallSettings.Builder<DeleteIndexRequest, Empty> deleteIndexSettings() {
      return getStubSettingsBuilder().deleteIndexSettings();
    }

    /** Returns the builder for the settings used for calls to getField. */
    public UnaryCallSettings.Builder<GetFieldRequest, Field> getFieldSettings() {
      return getStubSettingsBuilder().getFieldSettings();
    }

    /** Returns the builder for the settings used for calls to updateField. */
    public UnaryCallSettings.Builder<UpdateFieldRequest, Operation> updateFieldSettings() {
      return getStubSettingsBuilder().updateFieldSettings();
    }

    /** Returns the builder for the settings used for calls to updateField. */
    public OperationCallSettings.Builder<UpdateFieldRequest, Field, FieldOperationMetadata>
        updateFieldOperationSettings() {
      return getStubSettingsBuilder().updateFieldOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listFields. */
    public PagedCallSettings.Builder<ListFieldsRequest, ListFieldsResponse, ListFieldsPagedResponse>
        listFieldsSettings() {
      return getStubSettingsBuilder().listFieldsSettings();
    }

    /** Returns the builder for the settings used for calls to exportDocuments. */
    public UnaryCallSettings.Builder<ExportDocumentsRequest, Operation> exportDocumentsSettings() {
      return getStubSettingsBuilder().exportDocumentsSettings();
    }

    /** Returns the builder for the settings used for calls to exportDocuments. */
    public OperationCallSettings.Builder<
            ExportDocumentsRequest, ExportDocumentsResponse, ExportDocumentsMetadata>
        exportDocumentsOperationSettings() {
      return getStubSettingsBuilder().exportDocumentsOperationSettings();
    }

    /** Returns the builder for the settings used for calls to importDocuments. */
    public UnaryCallSettings.Builder<ImportDocumentsRequest, Operation> importDocumentsSettings() {
      return getStubSettingsBuilder().importDocumentsSettings();
    }

    /** Returns the builder for the settings used for calls to importDocuments. */
    public OperationCallSettings.Builder<ImportDocumentsRequest, Empty, ImportDocumentsMetadata>
        importDocumentsOperationSettings() {
      return getStubSettingsBuilder().importDocumentsOperationSettings();
    }

    /** Returns the builder for the settings used for calls to bulkDeleteDocuments. */
    public UnaryCallSettings.Builder<BulkDeleteDocumentsRequest, Operation>
        bulkDeleteDocumentsSettings() {
      return getStubSettingsBuilder().bulkDeleteDocumentsSettings();
    }

    /** Returns the builder for the settings used for calls to bulkDeleteDocuments. */
    public OperationCallSettings.Builder<
            BulkDeleteDocumentsRequest, BulkDeleteDocumentsResponse, BulkDeleteDocumentsMetadata>
        bulkDeleteDocumentsOperationSettings() {
      return getStubSettingsBuilder().bulkDeleteDocumentsOperationSettings();
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

    /** Returns the builder for the settings used for calls to listDatabases. */
    public UnaryCallSettings.Builder<ListDatabasesRequest, ListDatabasesResponse>
        listDatabasesSettings() {
      return getStubSettingsBuilder().listDatabasesSettings();
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

    /** Returns the builder for the settings used for calls to deleteDatabase. */
    public UnaryCallSettings.Builder<DeleteDatabaseRequest, Operation> deleteDatabaseSettings() {
      return getStubSettingsBuilder().deleteDatabaseSettings();
    }

    /** Returns the builder for the settings used for calls to deleteDatabase. */
    public OperationCallSettings.Builder<DeleteDatabaseRequest, Database, DeleteDatabaseMetadata>
        deleteDatabaseOperationSettings() {
      return getStubSettingsBuilder().deleteDatabaseOperationSettings();
    }

    /** Returns the builder for the settings used for calls to getBackup. */
    public UnaryCallSettings.Builder<GetBackupRequest, Backup> getBackupSettings() {
      return getStubSettingsBuilder().getBackupSettings();
    }

    /** Returns the builder for the settings used for calls to listBackups. */
    public UnaryCallSettings.Builder<ListBackupsRequest, ListBackupsResponse>
        listBackupsSettings() {
      return getStubSettingsBuilder().listBackupsSettings();
    }

    /** Returns the builder for the settings used for calls to deleteBackup. */
    public UnaryCallSettings.Builder<DeleteBackupRequest, Empty> deleteBackupSettings() {
      return getStubSettingsBuilder().deleteBackupSettings();
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

    /** Returns the builder for the settings used for calls to listBackupSchedules. */
    public UnaryCallSettings.Builder<ListBackupSchedulesRequest, ListBackupSchedulesResponse>
        listBackupSchedulesSettings() {
      return getStubSettingsBuilder().listBackupSchedulesSettings();
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

    @Override
    public FirestoreAdminSettings build() throws IOException {
      return new FirestoreAdminSettings(this);
    }
  }
}
