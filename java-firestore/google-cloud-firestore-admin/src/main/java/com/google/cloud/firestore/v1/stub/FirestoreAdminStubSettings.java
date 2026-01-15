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

package com.google.cloud.firestore.v1.stub;

import static com.google.cloud.firestore.v1.FirestoreAdminClient.ListFieldsPagedResponse;
import static com.google.cloud.firestore.v1.FirestoreAdminClient.ListIndexesPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.BetaApi;
import com.google.api.core.ObsoleteApi;
import com.google.api.gax.core.GaxProperties;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.GrpcTransportChannel;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.grpc.ProtoOperationTransformers;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.HttpJsonTransportChannel;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
import com.google.api.gax.longrunning.OperationSnapshot;
import com.google.api.gax.longrunning.OperationTimedPollAlgorithm;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallSettings;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.PagedListDescriptor;
import com.google.api.gax.rpc.PagedListResponseFactory;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.StubSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.firestore.admin.v1.Backup;
import com.google.firestore.admin.v1.BackupSchedule;
import com.google.firestore.admin.v1.BulkDeleteDocumentsMetadata;
import com.google.firestore.admin.v1.BulkDeleteDocumentsRequest;
import com.google.firestore.admin.v1.BulkDeleteDocumentsResponse;
import com.google.firestore.admin.v1.CloneDatabaseMetadata;
import com.google.firestore.admin.v1.CloneDatabaseRequest;
import com.google.firestore.admin.v1.CreateBackupScheduleRequest;
import com.google.firestore.admin.v1.CreateDatabaseMetadata;
import com.google.firestore.admin.v1.CreateDatabaseRequest;
import com.google.firestore.admin.v1.CreateIndexRequest;
import com.google.firestore.admin.v1.CreateUserCredsRequest;
import com.google.firestore.admin.v1.Database;
import com.google.firestore.admin.v1.DeleteBackupRequest;
import com.google.firestore.admin.v1.DeleteBackupScheduleRequest;
import com.google.firestore.admin.v1.DeleteDatabaseMetadata;
import com.google.firestore.admin.v1.DeleteDatabaseRequest;
import com.google.firestore.admin.v1.DeleteIndexRequest;
import com.google.firestore.admin.v1.DeleteUserCredsRequest;
import com.google.firestore.admin.v1.DisableUserCredsRequest;
import com.google.firestore.admin.v1.EnableUserCredsRequest;
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
import com.google.firestore.admin.v1.GetUserCredsRequest;
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
import com.google.firestore.admin.v1.ListUserCredsRequest;
import com.google.firestore.admin.v1.ListUserCredsResponse;
import com.google.firestore.admin.v1.ResetUserPasswordRequest;
import com.google.firestore.admin.v1.RestoreDatabaseMetadata;
import com.google.firestore.admin.v1.RestoreDatabaseRequest;
import com.google.firestore.admin.v1.UpdateBackupScheduleRequest;
import com.google.firestore.admin.v1.UpdateDatabaseMetadata;
import com.google.firestore.admin.v1.UpdateDatabaseRequest;
import com.google.firestore.admin.v1.UpdateFieldRequest;
import com.google.firestore.admin.v1.UserCreds;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link FirestoreAdminStub}.
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
 * FirestoreAdminStubSettings.Builder firestoreAdminSettingsBuilder =
 *     FirestoreAdminStubSettings.newBuilder();
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
 * FirestoreAdminStubSettings firestoreAdminSettings = firestoreAdminSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://docs.cloud.google.com/java/docs/client-retries) for additional support in setting
 * retries.
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
 * FirestoreAdminStubSettings.Builder firestoreAdminSettingsBuilder =
 *     FirestoreAdminStubSettings.newBuilder();
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
public class FirestoreAdminStubSettings extends StubSettings<FirestoreAdminStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder()
          .add("https://www.googleapis.com/auth/cloud-platform")
          .add("https://www.googleapis.com/auth/datastore")
          .build();

  private final UnaryCallSettings<CreateIndexRequest, Operation> createIndexSettings;
  private final OperationCallSettings<CreateIndexRequest, Index, IndexOperationMetadata>
      createIndexOperationSettings;
  private final PagedCallSettings<ListIndexesRequest, ListIndexesResponse, ListIndexesPagedResponse>
      listIndexesSettings;
  private final UnaryCallSettings<GetIndexRequest, Index> getIndexSettings;
  private final UnaryCallSettings<DeleteIndexRequest, Empty> deleteIndexSettings;
  private final UnaryCallSettings<GetFieldRequest, Field> getFieldSettings;
  private final UnaryCallSettings<UpdateFieldRequest, Operation> updateFieldSettings;
  private final OperationCallSettings<UpdateFieldRequest, Field, FieldOperationMetadata>
      updateFieldOperationSettings;
  private final PagedCallSettings<ListFieldsRequest, ListFieldsResponse, ListFieldsPagedResponse>
      listFieldsSettings;
  private final UnaryCallSettings<ExportDocumentsRequest, Operation> exportDocumentsSettings;
  private final OperationCallSettings<
          ExportDocumentsRequest, ExportDocumentsResponse, ExportDocumentsMetadata>
      exportDocumentsOperationSettings;
  private final UnaryCallSettings<ImportDocumentsRequest, Operation> importDocumentsSettings;
  private final OperationCallSettings<ImportDocumentsRequest, Empty, ImportDocumentsMetadata>
      importDocumentsOperationSettings;
  private final UnaryCallSettings<BulkDeleteDocumentsRequest, Operation>
      bulkDeleteDocumentsSettings;
  private final OperationCallSettings<
          BulkDeleteDocumentsRequest, BulkDeleteDocumentsResponse, BulkDeleteDocumentsMetadata>
      bulkDeleteDocumentsOperationSettings;
  private final UnaryCallSettings<CreateDatabaseRequest, Operation> createDatabaseSettings;
  private final OperationCallSettings<CreateDatabaseRequest, Database, CreateDatabaseMetadata>
      createDatabaseOperationSettings;
  private final UnaryCallSettings<GetDatabaseRequest, Database> getDatabaseSettings;
  private final UnaryCallSettings<ListDatabasesRequest, ListDatabasesResponse>
      listDatabasesSettings;
  private final UnaryCallSettings<UpdateDatabaseRequest, Operation> updateDatabaseSettings;
  private final OperationCallSettings<UpdateDatabaseRequest, Database, UpdateDatabaseMetadata>
      updateDatabaseOperationSettings;
  private final UnaryCallSettings<DeleteDatabaseRequest, Operation> deleteDatabaseSettings;
  private final OperationCallSettings<DeleteDatabaseRequest, Database, DeleteDatabaseMetadata>
      deleteDatabaseOperationSettings;
  private final UnaryCallSettings<CreateUserCredsRequest, UserCreds> createUserCredsSettings;
  private final UnaryCallSettings<GetUserCredsRequest, UserCreds> getUserCredsSettings;
  private final UnaryCallSettings<ListUserCredsRequest, ListUserCredsResponse>
      listUserCredsSettings;
  private final UnaryCallSettings<EnableUserCredsRequest, UserCreds> enableUserCredsSettings;
  private final UnaryCallSettings<DisableUserCredsRequest, UserCreds> disableUserCredsSettings;
  private final UnaryCallSettings<ResetUserPasswordRequest, UserCreds> resetUserPasswordSettings;
  private final UnaryCallSettings<DeleteUserCredsRequest, Empty> deleteUserCredsSettings;
  private final UnaryCallSettings<GetBackupRequest, Backup> getBackupSettings;
  private final UnaryCallSettings<ListBackupsRequest, ListBackupsResponse> listBackupsSettings;
  private final UnaryCallSettings<DeleteBackupRequest, Empty> deleteBackupSettings;
  private final UnaryCallSettings<RestoreDatabaseRequest, Operation> restoreDatabaseSettings;
  private final OperationCallSettings<RestoreDatabaseRequest, Database, RestoreDatabaseMetadata>
      restoreDatabaseOperationSettings;
  private final UnaryCallSettings<CreateBackupScheduleRequest, BackupSchedule>
      createBackupScheduleSettings;
  private final UnaryCallSettings<GetBackupScheduleRequest, BackupSchedule>
      getBackupScheduleSettings;
  private final UnaryCallSettings<ListBackupSchedulesRequest, ListBackupSchedulesResponse>
      listBackupSchedulesSettings;
  private final UnaryCallSettings<UpdateBackupScheduleRequest, BackupSchedule>
      updateBackupScheduleSettings;
  private final UnaryCallSettings<DeleteBackupScheduleRequest, Empty> deleteBackupScheduleSettings;
  private final UnaryCallSettings<CloneDatabaseRequest, Operation> cloneDatabaseSettings;
  private final OperationCallSettings<CloneDatabaseRequest, Database, CloneDatabaseMetadata>
      cloneDatabaseOperationSettings;

  private static final PagedListDescriptor<ListIndexesRequest, ListIndexesResponse, Index>
      LIST_INDEXES_PAGE_STR_DESC =
          new PagedListDescriptor<ListIndexesRequest, ListIndexesResponse, Index>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListIndexesRequest injectToken(ListIndexesRequest payload, String token) {
              return ListIndexesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListIndexesRequest injectPageSize(ListIndexesRequest payload, int pageSize) {
              return ListIndexesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListIndexesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListIndexesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Index> extractResources(ListIndexesResponse payload) {
              return payload.getIndexesList();
            }
          };

  private static final PagedListDescriptor<ListFieldsRequest, ListFieldsResponse, Field>
      LIST_FIELDS_PAGE_STR_DESC =
          new PagedListDescriptor<ListFieldsRequest, ListFieldsResponse, Field>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListFieldsRequest injectToken(ListFieldsRequest payload, String token) {
              return ListFieldsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListFieldsRequest injectPageSize(ListFieldsRequest payload, int pageSize) {
              return ListFieldsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListFieldsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListFieldsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Field> extractResources(ListFieldsResponse payload) {
              return payload.getFieldsList();
            }
          };

  private static final PagedListResponseFactory<
          ListIndexesRequest, ListIndexesResponse, ListIndexesPagedResponse>
      LIST_INDEXES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListIndexesRequest, ListIndexesResponse, ListIndexesPagedResponse>() {
            @Override
            public ApiFuture<ListIndexesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListIndexesRequest, ListIndexesResponse> callable,
                ListIndexesRequest request,
                ApiCallContext context,
                ApiFuture<ListIndexesResponse> futureResponse) {
              PageContext<ListIndexesRequest, ListIndexesResponse, Index> pageContext =
                  PageContext.create(callable, LIST_INDEXES_PAGE_STR_DESC, request, context);
              return ListIndexesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListFieldsRequest, ListFieldsResponse, ListFieldsPagedResponse>
      LIST_FIELDS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListFieldsRequest, ListFieldsResponse, ListFieldsPagedResponse>() {
            @Override
            public ApiFuture<ListFieldsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListFieldsRequest, ListFieldsResponse> callable,
                ListFieldsRequest request,
                ApiCallContext context,
                ApiFuture<ListFieldsResponse> futureResponse) {
              PageContext<ListFieldsRequest, ListFieldsResponse, Field> pageContext =
                  PageContext.create(callable, LIST_FIELDS_PAGE_STR_DESC, request, context);
              return ListFieldsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to createIndex. */
  public UnaryCallSettings<CreateIndexRequest, Operation> createIndexSettings() {
    return createIndexSettings;
  }

  /** Returns the object with the settings used for calls to createIndex. */
  public OperationCallSettings<CreateIndexRequest, Index, IndexOperationMetadata>
      createIndexOperationSettings() {
    return createIndexOperationSettings;
  }

  /** Returns the object with the settings used for calls to listIndexes. */
  public PagedCallSettings<ListIndexesRequest, ListIndexesResponse, ListIndexesPagedResponse>
      listIndexesSettings() {
    return listIndexesSettings;
  }

  /** Returns the object with the settings used for calls to getIndex. */
  public UnaryCallSettings<GetIndexRequest, Index> getIndexSettings() {
    return getIndexSettings;
  }

  /** Returns the object with the settings used for calls to deleteIndex. */
  public UnaryCallSettings<DeleteIndexRequest, Empty> deleteIndexSettings() {
    return deleteIndexSettings;
  }

  /** Returns the object with the settings used for calls to getField. */
  public UnaryCallSettings<GetFieldRequest, Field> getFieldSettings() {
    return getFieldSettings;
  }

  /** Returns the object with the settings used for calls to updateField. */
  public UnaryCallSettings<UpdateFieldRequest, Operation> updateFieldSettings() {
    return updateFieldSettings;
  }

  /** Returns the object with the settings used for calls to updateField. */
  public OperationCallSettings<UpdateFieldRequest, Field, FieldOperationMetadata>
      updateFieldOperationSettings() {
    return updateFieldOperationSettings;
  }

  /** Returns the object with the settings used for calls to listFields. */
  public PagedCallSettings<ListFieldsRequest, ListFieldsResponse, ListFieldsPagedResponse>
      listFieldsSettings() {
    return listFieldsSettings;
  }

  /** Returns the object with the settings used for calls to exportDocuments. */
  public UnaryCallSettings<ExportDocumentsRequest, Operation> exportDocumentsSettings() {
    return exportDocumentsSettings;
  }

  /** Returns the object with the settings used for calls to exportDocuments. */
  public OperationCallSettings<
          ExportDocumentsRequest, ExportDocumentsResponse, ExportDocumentsMetadata>
      exportDocumentsOperationSettings() {
    return exportDocumentsOperationSettings;
  }

  /** Returns the object with the settings used for calls to importDocuments. */
  public UnaryCallSettings<ImportDocumentsRequest, Operation> importDocumentsSettings() {
    return importDocumentsSettings;
  }

  /** Returns the object with the settings used for calls to importDocuments. */
  public OperationCallSettings<ImportDocumentsRequest, Empty, ImportDocumentsMetadata>
      importDocumentsOperationSettings() {
    return importDocumentsOperationSettings;
  }

  /** Returns the object with the settings used for calls to bulkDeleteDocuments. */
  public UnaryCallSettings<BulkDeleteDocumentsRequest, Operation> bulkDeleteDocumentsSettings() {
    return bulkDeleteDocumentsSettings;
  }

  /** Returns the object with the settings used for calls to bulkDeleteDocuments. */
  public OperationCallSettings<
          BulkDeleteDocumentsRequest, BulkDeleteDocumentsResponse, BulkDeleteDocumentsMetadata>
      bulkDeleteDocumentsOperationSettings() {
    return bulkDeleteDocumentsOperationSettings;
  }

  /** Returns the object with the settings used for calls to createDatabase. */
  public UnaryCallSettings<CreateDatabaseRequest, Operation> createDatabaseSettings() {
    return createDatabaseSettings;
  }

  /** Returns the object with the settings used for calls to createDatabase. */
  public OperationCallSettings<CreateDatabaseRequest, Database, CreateDatabaseMetadata>
      createDatabaseOperationSettings() {
    return createDatabaseOperationSettings;
  }

  /** Returns the object with the settings used for calls to getDatabase. */
  public UnaryCallSettings<GetDatabaseRequest, Database> getDatabaseSettings() {
    return getDatabaseSettings;
  }

  /** Returns the object with the settings used for calls to listDatabases. */
  public UnaryCallSettings<ListDatabasesRequest, ListDatabasesResponse> listDatabasesSettings() {
    return listDatabasesSettings;
  }

  /** Returns the object with the settings used for calls to updateDatabase. */
  public UnaryCallSettings<UpdateDatabaseRequest, Operation> updateDatabaseSettings() {
    return updateDatabaseSettings;
  }

  /** Returns the object with the settings used for calls to updateDatabase. */
  public OperationCallSettings<UpdateDatabaseRequest, Database, UpdateDatabaseMetadata>
      updateDatabaseOperationSettings() {
    return updateDatabaseOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteDatabase. */
  public UnaryCallSettings<DeleteDatabaseRequest, Operation> deleteDatabaseSettings() {
    return deleteDatabaseSettings;
  }

  /** Returns the object with the settings used for calls to deleteDatabase. */
  public OperationCallSettings<DeleteDatabaseRequest, Database, DeleteDatabaseMetadata>
      deleteDatabaseOperationSettings() {
    return deleteDatabaseOperationSettings;
  }

  /** Returns the object with the settings used for calls to createUserCreds. */
  public UnaryCallSettings<CreateUserCredsRequest, UserCreds> createUserCredsSettings() {
    return createUserCredsSettings;
  }

  /** Returns the object with the settings used for calls to getUserCreds. */
  public UnaryCallSettings<GetUserCredsRequest, UserCreds> getUserCredsSettings() {
    return getUserCredsSettings;
  }

  /** Returns the object with the settings used for calls to listUserCreds. */
  public UnaryCallSettings<ListUserCredsRequest, ListUserCredsResponse> listUserCredsSettings() {
    return listUserCredsSettings;
  }

  /** Returns the object with the settings used for calls to enableUserCreds. */
  public UnaryCallSettings<EnableUserCredsRequest, UserCreds> enableUserCredsSettings() {
    return enableUserCredsSettings;
  }

  /** Returns the object with the settings used for calls to disableUserCreds. */
  public UnaryCallSettings<DisableUserCredsRequest, UserCreds> disableUserCredsSettings() {
    return disableUserCredsSettings;
  }

  /** Returns the object with the settings used for calls to resetUserPassword. */
  public UnaryCallSettings<ResetUserPasswordRequest, UserCreds> resetUserPasswordSettings() {
    return resetUserPasswordSettings;
  }

  /** Returns the object with the settings used for calls to deleteUserCreds. */
  public UnaryCallSettings<DeleteUserCredsRequest, Empty> deleteUserCredsSettings() {
    return deleteUserCredsSettings;
  }

  /** Returns the object with the settings used for calls to getBackup. */
  public UnaryCallSettings<GetBackupRequest, Backup> getBackupSettings() {
    return getBackupSettings;
  }

  /** Returns the object with the settings used for calls to listBackups. */
  public UnaryCallSettings<ListBackupsRequest, ListBackupsResponse> listBackupsSettings() {
    return listBackupsSettings;
  }

  /** Returns the object with the settings used for calls to deleteBackup. */
  public UnaryCallSettings<DeleteBackupRequest, Empty> deleteBackupSettings() {
    return deleteBackupSettings;
  }

  /** Returns the object with the settings used for calls to restoreDatabase. */
  public UnaryCallSettings<RestoreDatabaseRequest, Operation> restoreDatabaseSettings() {
    return restoreDatabaseSettings;
  }

  /** Returns the object with the settings used for calls to restoreDatabase. */
  public OperationCallSettings<RestoreDatabaseRequest, Database, RestoreDatabaseMetadata>
      restoreDatabaseOperationSettings() {
    return restoreDatabaseOperationSettings;
  }

  /** Returns the object with the settings used for calls to createBackupSchedule. */
  public UnaryCallSettings<CreateBackupScheduleRequest, BackupSchedule>
      createBackupScheduleSettings() {
    return createBackupScheduleSettings;
  }

  /** Returns the object with the settings used for calls to getBackupSchedule. */
  public UnaryCallSettings<GetBackupScheduleRequest, BackupSchedule> getBackupScheduleSettings() {
    return getBackupScheduleSettings;
  }

  /** Returns the object with the settings used for calls to listBackupSchedules. */
  public UnaryCallSettings<ListBackupSchedulesRequest, ListBackupSchedulesResponse>
      listBackupSchedulesSettings() {
    return listBackupSchedulesSettings;
  }

  /** Returns the object with the settings used for calls to updateBackupSchedule. */
  public UnaryCallSettings<UpdateBackupScheduleRequest, BackupSchedule>
      updateBackupScheduleSettings() {
    return updateBackupScheduleSettings;
  }

  /** Returns the object with the settings used for calls to deleteBackupSchedule. */
  public UnaryCallSettings<DeleteBackupScheduleRequest, Empty> deleteBackupScheduleSettings() {
    return deleteBackupScheduleSettings;
  }

  /** Returns the object with the settings used for calls to cloneDatabase. */
  public UnaryCallSettings<CloneDatabaseRequest, Operation> cloneDatabaseSettings() {
    return cloneDatabaseSettings;
  }

  /** Returns the object with the settings used for calls to cloneDatabase. */
  public OperationCallSettings<CloneDatabaseRequest, Database, CloneDatabaseMetadata>
      cloneDatabaseOperationSettings() {
    return cloneDatabaseOperationSettings;
  }

  public FirestoreAdminStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcFirestoreAdminStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonFirestoreAdminStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns the default service name. */
  @Override
  public String getServiceName() {
    return "firestore";
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  @ObsoleteApi("Use getEndpoint() instead")
  public static String getDefaultEndpoint() {
    return "firestore.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "firestore.mtls.googleapis.com:443";
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
            "gapic", GaxProperties.getLibraryVersion(FirestoreAdminStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(FirestoreAdminStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return FirestoreAdminStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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

  protected FirestoreAdminStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    createIndexSettings = settingsBuilder.createIndexSettings().build();
    createIndexOperationSettings = settingsBuilder.createIndexOperationSettings().build();
    listIndexesSettings = settingsBuilder.listIndexesSettings().build();
    getIndexSettings = settingsBuilder.getIndexSettings().build();
    deleteIndexSettings = settingsBuilder.deleteIndexSettings().build();
    getFieldSettings = settingsBuilder.getFieldSettings().build();
    updateFieldSettings = settingsBuilder.updateFieldSettings().build();
    updateFieldOperationSettings = settingsBuilder.updateFieldOperationSettings().build();
    listFieldsSettings = settingsBuilder.listFieldsSettings().build();
    exportDocumentsSettings = settingsBuilder.exportDocumentsSettings().build();
    exportDocumentsOperationSettings = settingsBuilder.exportDocumentsOperationSettings().build();
    importDocumentsSettings = settingsBuilder.importDocumentsSettings().build();
    importDocumentsOperationSettings = settingsBuilder.importDocumentsOperationSettings().build();
    bulkDeleteDocumentsSettings = settingsBuilder.bulkDeleteDocumentsSettings().build();
    bulkDeleteDocumentsOperationSettings =
        settingsBuilder.bulkDeleteDocumentsOperationSettings().build();
    createDatabaseSettings = settingsBuilder.createDatabaseSettings().build();
    createDatabaseOperationSettings = settingsBuilder.createDatabaseOperationSettings().build();
    getDatabaseSettings = settingsBuilder.getDatabaseSettings().build();
    listDatabasesSettings = settingsBuilder.listDatabasesSettings().build();
    updateDatabaseSettings = settingsBuilder.updateDatabaseSettings().build();
    updateDatabaseOperationSettings = settingsBuilder.updateDatabaseOperationSettings().build();
    deleteDatabaseSettings = settingsBuilder.deleteDatabaseSettings().build();
    deleteDatabaseOperationSettings = settingsBuilder.deleteDatabaseOperationSettings().build();
    createUserCredsSettings = settingsBuilder.createUserCredsSettings().build();
    getUserCredsSettings = settingsBuilder.getUserCredsSettings().build();
    listUserCredsSettings = settingsBuilder.listUserCredsSettings().build();
    enableUserCredsSettings = settingsBuilder.enableUserCredsSettings().build();
    disableUserCredsSettings = settingsBuilder.disableUserCredsSettings().build();
    resetUserPasswordSettings = settingsBuilder.resetUserPasswordSettings().build();
    deleteUserCredsSettings = settingsBuilder.deleteUserCredsSettings().build();
    getBackupSettings = settingsBuilder.getBackupSettings().build();
    listBackupsSettings = settingsBuilder.listBackupsSettings().build();
    deleteBackupSettings = settingsBuilder.deleteBackupSettings().build();
    restoreDatabaseSettings = settingsBuilder.restoreDatabaseSettings().build();
    restoreDatabaseOperationSettings = settingsBuilder.restoreDatabaseOperationSettings().build();
    createBackupScheduleSettings = settingsBuilder.createBackupScheduleSettings().build();
    getBackupScheduleSettings = settingsBuilder.getBackupScheduleSettings().build();
    listBackupSchedulesSettings = settingsBuilder.listBackupSchedulesSettings().build();
    updateBackupScheduleSettings = settingsBuilder.updateBackupScheduleSettings().build();
    deleteBackupScheduleSettings = settingsBuilder.deleteBackupScheduleSettings().build();
    cloneDatabaseSettings = settingsBuilder.cloneDatabaseSettings().build();
    cloneDatabaseOperationSettings = settingsBuilder.cloneDatabaseOperationSettings().build();
  }

  /** Builder for FirestoreAdminStubSettings. */
  public static class Builder extends StubSettings.Builder<FirestoreAdminStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<CreateIndexRequest, Operation> createIndexSettings;
    private final OperationCallSettings.Builder<CreateIndexRequest, Index, IndexOperationMetadata>
        createIndexOperationSettings;
    private final PagedCallSettings.Builder<
            ListIndexesRequest, ListIndexesResponse, ListIndexesPagedResponse>
        listIndexesSettings;
    private final UnaryCallSettings.Builder<GetIndexRequest, Index> getIndexSettings;
    private final UnaryCallSettings.Builder<DeleteIndexRequest, Empty> deleteIndexSettings;
    private final UnaryCallSettings.Builder<GetFieldRequest, Field> getFieldSettings;
    private final UnaryCallSettings.Builder<UpdateFieldRequest, Operation> updateFieldSettings;
    private final OperationCallSettings.Builder<UpdateFieldRequest, Field, FieldOperationMetadata>
        updateFieldOperationSettings;
    private final PagedCallSettings.Builder<
            ListFieldsRequest, ListFieldsResponse, ListFieldsPagedResponse>
        listFieldsSettings;
    private final UnaryCallSettings.Builder<ExportDocumentsRequest, Operation>
        exportDocumentsSettings;
    private final OperationCallSettings.Builder<
            ExportDocumentsRequest, ExportDocumentsResponse, ExportDocumentsMetadata>
        exportDocumentsOperationSettings;
    private final UnaryCallSettings.Builder<ImportDocumentsRequest, Operation>
        importDocumentsSettings;
    private final OperationCallSettings.Builder<
            ImportDocumentsRequest, Empty, ImportDocumentsMetadata>
        importDocumentsOperationSettings;
    private final UnaryCallSettings.Builder<BulkDeleteDocumentsRequest, Operation>
        bulkDeleteDocumentsSettings;
    private final OperationCallSettings.Builder<
            BulkDeleteDocumentsRequest, BulkDeleteDocumentsResponse, BulkDeleteDocumentsMetadata>
        bulkDeleteDocumentsOperationSettings;
    private final UnaryCallSettings.Builder<CreateDatabaseRequest, Operation>
        createDatabaseSettings;
    private final OperationCallSettings.Builder<
            CreateDatabaseRequest, Database, CreateDatabaseMetadata>
        createDatabaseOperationSettings;
    private final UnaryCallSettings.Builder<GetDatabaseRequest, Database> getDatabaseSettings;
    private final UnaryCallSettings.Builder<ListDatabasesRequest, ListDatabasesResponse>
        listDatabasesSettings;
    private final UnaryCallSettings.Builder<UpdateDatabaseRequest, Operation>
        updateDatabaseSettings;
    private final OperationCallSettings.Builder<
            UpdateDatabaseRequest, Database, UpdateDatabaseMetadata>
        updateDatabaseOperationSettings;
    private final UnaryCallSettings.Builder<DeleteDatabaseRequest, Operation>
        deleteDatabaseSettings;
    private final OperationCallSettings.Builder<
            DeleteDatabaseRequest, Database, DeleteDatabaseMetadata>
        deleteDatabaseOperationSettings;
    private final UnaryCallSettings.Builder<CreateUserCredsRequest, UserCreds>
        createUserCredsSettings;
    private final UnaryCallSettings.Builder<GetUserCredsRequest, UserCreds> getUserCredsSettings;
    private final UnaryCallSettings.Builder<ListUserCredsRequest, ListUserCredsResponse>
        listUserCredsSettings;
    private final UnaryCallSettings.Builder<EnableUserCredsRequest, UserCreds>
        enableUserCredsSettings;
    private final UnaryCallSettings.Builder<DisableUserCredsRequest, UserCreds>
        disableUserCredsSettings;
    private final UnaryCallSettings.Builder<ResetUserPasswordRequest, UserCreds>
        resetUserPasswordSettings;
    private final UnaryCallSettings.Builder<DeleteUserCredsRequest, Empty> deleteUserCredsSettings;
    private final UnaryCallSettings.Builder<GetBackupRequest, Backup> getBackupSettings;
    private final UnaryCallSettings.Builder<ListBackupsRequest, ListBackupsResponse>
        listBackupsSettings;
    private final UnaryCallSettings.Builder<DeleteBackupRequest, Empty> deleteBackupSettings;
    private final UnaryCallSettings.Builder<RestoreDatabaseRequest, Operation>
        restoreDatabaseSettings;
    private final OperationCallSettings.Builder<
            RestoreDatabaseRequest, Database, RestoreDatabaseMetadata>
        restoreDatabaseOperationSettings;
    private final UnaryCallSettings.Builder<CreateBackupScheduleRequest, BackupSchedule>
        createBackupScheduleSettings;
    private final UnaryCallSettings.Builder<GetBackupScheduleRequest, BackupSchedule>
        getBackupScheduleSettings;
    private final UnaryCallSettings.Builder<ListBackupSchedulesRequest, ListBackupSchedulesResponse>
        listBackupSchedulesSettings;
    private final UnaryCallSettings.Builder<UpdateBackupScheduleRequest, BackupSchedule>
        updateBackupScheduleSettings;
    private final UnaryCallSettings.Builder<DeleteBackupScheduleRequest, Empty>
        deleteBackupScheduleSettings;
    private final UnaryCallSettings.Builder<CloneDatabaseRequest, Operation> cloneDatabaseSettings;
    private final OperationCallSettings.Builder<
            CloneDatabaseRequest, Database, CloneDatabaseMetadata>
        cloneDatabaseOperationSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put(
          "no_retry_1_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      definitions.put(
          "retry_policy_0_codes",
          ImmutableSet.copyOf(
              Lists.<StatusCode.Code>newArrayList(
                  StatusCode.Code.UNAVAILABLE,
                  StatusCode.Code.INTERNAL,
                  StatusCode.Code.DEADLINE_EXCEEDED)));
      definitions.put(
          "no_retry_2_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      definitions.put("no_retry_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
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
      definitions.put("no_retry_1_params", settings);
      settings =
          RetrySettings.newBuilder()
              .setInitialRetryDelayDuration(Duration.ofMillis(100L))
              .setRetryDelayMultiplier(1.3)
              .setMaxRetryDelayDuration(Duration.ofMillis(60000L))
              .setInitialRpcTimeoutDuration(Duration.ofMillis(60000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeoutDuration(Duration.ofMillis(60000L))
              .setTotalTimeoutDuration(Duration.ofMillis(60000L))
              .build();
      definitions.put("retry_policy_0_params", settings);
      settings =
          RetrySettings.newBuilder()
              .setInitialRpcTimeoutDuration(Duration.ofMillis(120000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeoutDuration(Duration.ofMillis(120000L))
              .setTotalTimeoutDuration(Duration.ofMillis(120000L))
              .build();
      definitions.put("no_retry_2_params", settings);
      settings = RetrySettings.newBuilder().setRpcTimeoutMultiplier(1.0).build();
      definitions.put("no_retry_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      createIndexSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createIndexOperationSettings = OperationCallSettings.newBuilder();
      listIndexesSettings = PagedCallSettings.newBuilder(LIST_INDEXES_PAGE_STR_FACT);
      getIndexSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteIndexSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getFieldSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateFieldSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateFieldOperationSettings = OperationCallSettings.newBuilder();
      listFieldsSettings = PagedCallSettings.newBuilder(LIST_FIELDS_PAGE_STR_FACT);
      exportDocumentsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      exportDocumentsOperationSettings = OperationCallSettings.newBuilder();
      importDocumentsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      importDocumentsOperationSettings = OperationCallSettings.newBuilder();
      bulkDeleteDocumentsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      bulkDeleteDocumentsOperationSettings = OperationCallSettings.newBuilder();
      createDatabaseSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createDatabaseOperationSettings = OperationCallSettings.newBuilder();
      getDatabaseSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listDatabasesSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateDatabaseSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateDatabaseOperationSettings = OperationCallSettings.newBuilder();
      deleteDatabaseSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteDatabaseOperationSettings = OperationCallSettings.newBuilder();
      createUserCredsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getUserCredsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listUserCredsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      enableUserCredsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      disableUserCredsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      resetUserPasswordSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteUserCredsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getBackupSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listBackupsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteBackupSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      restoreDatabaseSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      restoreDatabaseOperationSettings = OperationCallSettings.newBuilder();
      createBackupScheduleSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getBackupScheduleSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listBackupSchedulesSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateBackupScheduleSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteBackupScheduleSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      cloneDatabaseSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      cloneDatabaseOperationSettings = OperationCallSettings.newBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createIndexSettings,
              listIndexesSettings,
              getIndexSettings,
              deleteIndexSettings,
              getFieldSettings,
              updateFieldSettings,
              listFieldsSettings,
              exportDocumentsSettings,
              importDocumentsSettings,
              bulkDeleteDocumentsSettings,
              createDatabaseSettings,
              getDatabaseSettings,
              listDatabasesSettings,
              updateDatabaseSettings,
              deleteDatabaseSettings,
              createUserCredsSettings,
              getUserCredsSettings,
              listUserCredsSettings,
              enableUserCredsSettings,
              disableUserCredsSettings,
              resetUserPasswordSettings,
              deleteUserCredsSettings,
              getBackupSettings,
              listBackupsSettings,
              deleteBackupSettings,
              restoreDatabaseSettings,
              createBackupScheduleSettings,
              getBackupScheduleSettings,
              listBackupSchedulesSettings,
              updateBackupScheduleSettings,
              deleteBackupScheduleSettings,
              cloneDatabaseSettings);
      initDefaults(this);
    }

    protected Builder(FirestoreAdminStubSettings settings) {
      super(settings);

      createIndexSettings = settings.createIndexSettings.toBuilder();
      createIndexOperationSettings = settings.createIndexOperationSettings.toBuilder();
      listIndexesSettings = settings.listIndexesSettings.toBuilder();
      getIndexSettings = settings.getIndexSettings.toBuilder();
      deleteIndexSettings = settings.deleteIndexSettings.toBuilder();
      getFieldSettings = settings.getFieldSettings.toBuilder();
      updateFieldSettings = settings.updateFieldSettings.toBuilder();
      updateFieldOperationSettings = settings.updateFieldOperationSettings.toBuilder();
      listFieldsSettings = settings.listFieldsSettings.toBuilder();
      exportDocumentsSettings = settings.exportDocumentsSettings.toBuilder();
      exportDocumentsOperationSettings = settings.exportDocumentsOperationSettings.toBuilder();
      importDocumentsSettings = settings.importDocumentsSettings.toBuilder();
      importDocumentsOperationSettings = settings.importDocumentsOperationSettings.toBuilder();
      bulkDeleteDocumentsSettings = settings.bulkDeleteDocumentsSettings.toBuilder();
      bulkDeleteDocumentsOperationSettings =
          settings.bulkDeleteDocumentsOperationSettings.toBuilder();
      createDatabaseSettings = settings.createDatabaseSettings.toBuilder();
      createDatabaseOperationSettings = settings.createDatabaseOperationSettings.toBuilder();
      getDatabaseSettings = settings.getDatabaseSettings.toBuilder();
      listDatabasesSettings = settings.listDatabasesSettings.toBuilder();
      updateDatabaseSettings = settings.updateDatabaseSettings.toBuilder();
      updateDatabaseOperationSettings = settings.updateDatabaseOperationSettings.toBuilder();
      deleteDatabaseSettings = settings.deleteDatabaseSettings.toBuilder();
      deleteDatabaseOperationSettings = settings.deleteDatabaseOperationSettings.toBuilder();
      createUserCredsSettings = settings.createUserCredsSettings.toBuilder();
      getUserCredsSettings = settings.getUserCredsSettings.toBuilder();
      listUserCredsSettings = settings.listUserCredsSettings.toBuilder();
      enableUserCredsSettings = settings.enableUserCredsSettings.toBuilder();
      disableUserCredsSettings = settings.disableUserCredsSettings.toBuilder();
      resetUserPasswordSettings = settings.resetUserPasswordSettings.toBuilder();
      deleteUserCredsSettings = settings.deleteUserCredsSettings.toBuilder();
      getBackupSettings = settings.getBackupSettings.toBuilder();
      listBackupsSettings = settings.listBackupsSettings.toBuilder();
      deleteBackupSettings = settings.deleteBackupSettings.toBuilder();
      restoreDatabaseSettings = settings.restoreDatabaseSettings.toBuilder();
      restoreDatabaseOperationSettings = settings.restoreDatabaseOperationSettings.toBuilder();
      createBackupScheduleSettings = settings.createBackupScheduleSettings.toBuilder();
      getBackupScheduleSettings = settings.getBackupScheduleSettings.toBuilder();
      listBackupSchedulesSettings = settings.listBackupSchedulesSettings.toBuilder();
      updateBackupScheduleSettings = settings.updateBackupScheduleSettings.toBuilder();
      deleteBackupScheduleSettings = settings.deleteBackupScheduleSettings.toBuilder();
      cloneDatabaseSettings = settings.cloneDatabaseSettings.toBuilder();
      cloneDatabaseOperationSettings = settings.cloneDatabaseOperationSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createIndexSettings,
              listIndexesSettings,
              getIndexSettings,
              deleteIndexSettings,
              getFieldSettings,
              updateFieldSettings,
              listFieldsSettings,
              exportDocumentsSettings,
              importDocumentsSettings,
              bulkDeleteDocumentsSettings,
              createDatabaseSettings,
              getDatabaseSettings,
              listDatabasesSettings,
              updateDatabaseSettings,
              deleteDatabaseSettings,
              createUserCredsSettings,
              getUserCredsSettings,
              listUserCredsSettings,
              enableUserCredsSettings,
              disableUserCredsSettings,
              resetUserPasswordSettings,
              deleteUserCredsSettings,
              getBackupSettings,
              listBackupsSettings,
              deleteBackupSettings,
              restoreDatabaseSettings,
              createBackupScheduleSettings,
              getBackupScheduleSettings,
              listBackupSchedulesSettings,
              updateBackupScheduleSettings,
              deleteBackupScheduleSettings,
              cloneDatabaseSettings);
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
          .createIndexSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .listIndexesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getIndexSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deleteIndexSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getFieldSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updateFieldSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .listFieldsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .exportDocumentsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .importDocumentsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .bulkDeleteDocumentsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .createDatabaseSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_2_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_2_params"));

      builder
          .getDatabaseSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listDatabasesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .updateDatabaseSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .deleteDatabaseSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .createUserCredsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getUserCredsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listUserCredsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .enableUserCredsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .disableUserCredsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .resetUserPasswordSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .deleteUserCredsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getBackupSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listBackupsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .deleteBackupSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .restoreDatabaseSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_2_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_2_params"));

      builder
          .createBackupScheduleSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getBackupScheduleSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listBackupSchedulesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .updateBackupScheduleSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .deleteBackupScheduleSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .cloneDatabaseSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_2_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_2_params"));

      builder
          .createIndexOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings.<CreateIndexRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Index.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(IndexOperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .updateFieldOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings.<UpdateFieldRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Field.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(FieldOperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .exportDocumentsOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<ExportDocumentsRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(ExportDocumentsResponse.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(ExportDocumentsMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .importDocumentsOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<ImportDocumentsRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(ImportDocumentsMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .bulkDeleteDocumentsOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<BulkDeleteDocumentsRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(
                  BulkDeleteDocumentsResponse.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(
                  BulkDeleteDocumentsMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .createDatabaseOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateDatabaseRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_2_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_2_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Database.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(CreateDatabaseMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .updateDatabaseOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateDatabaseRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Database.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(UpdateDatabaseMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .deleteDatabaseOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteDatabaseRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Database.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(DeleteDatabaseMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .restoreDatabaseOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<RestoreDatabaseRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_2_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_2_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Database.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(RestoreDatabaseMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .cloneDatabaseOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CloneDatabaseRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_2_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_2_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Database.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(CloneDatabaseMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

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

    /** Returns the builder for the settings used for calls to createIndex. */
    public UnaryCallSettings.Builder<CreateIndexRequest, Operation> createIndexSettings() {
      return createIndexSettings;
    }

    /** Returns the builder for the settings used for calls to createIndex. */
    public OperationCallSettings.Builder<CreateIndexRequest, Index, IndexOperationMetadata>
        createIndexOperationSettings() {
      return createIndexOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listIndexes. */
    public PagedCallSettings.Builder<
            ListIndexesRequest, ListIndexesResponse, ListIndexesPagedResponse>
        listIndexesSettings() {
      return listIndexesSettings;
    }

    /** Returns the builder for the settings used for calls to getIndex. */
    public UnaryCallSettings.Builder<GetIndexRequest, Index> getIndexSettings() {
      return getIndexSettings;
    }

    /** Returns the builder for the settings used for calls to deleteIndex. */
    public UnaryCallSettings.Builder<DeleteIndexRequest, Empty> deleteIndexSettings() {
      return deleteIndexSettings;
    }

    /** Returns the builder for the settings used for calls to getField. */
    public UnaryCallSettings.Builder<GetFieldRequest, Field> getFieldSettings() {
      return getFieldSettings;
    }

    /** Returns the builder for the settings used for calls to updateField. */
    public UnaryCallSettings.Builder<UpdateFieldRequest, Operation> updateFieldSettings() {
      return updateFieldSettings;
    }

    /** Returns the builder for the settings used for calls to updateField. */
    public OperationCallSettings.Builder<UpdateFieldRequest, Field, FieldOperationMetadata>
        updateFieldOperationSettings() {
      return updateFieldOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listFields. */
    public PagedCallSettings.Builder<ListFieldsRequest, ListFieldsResponse, ListFieldsPagedResponse>
        listFieldsSettings() {
      return listFieldsSettings;
    }

    /** Returns the builder for the settings used for calls to exportDocuments. */
    public UnaryCallSettings.Builder<ExportDocumentsRequest, Operation> exportDocumentsSettings() {
      return exportDocumentsSettings;
    }

    /** Returns the builder for the settings used for calls to exportDocuments. */
    public OperationCallSettings.Builder<
            ExportDocumentsRequest, ExportDocumentsResponse, ExportDocumentsMetadata>
        exportDocumentsOperationSettings() {
      return exportDocumentsOperationSettings;
    }

    /** Returns the builder for the settings used for calls to importDocuments. */
    public UnaryCallSettings.Builder<ImportDocumentsRequest, Operation> importDocumentsSettings() {
      return importDocumentsSettings;
    }

    /** Returns the builder for the settings used for calls to importDocuments. */
    public OperationCallSettings.Builder<ImportDocumentsRequest, Empty, ImportDocumentsMetadata>
        importDocumentsOperationSettings() {
      return importDocumentsOperationSettings;
    }

    /** Returns the builder for the settings used for calls to bulkDeleteDocuments. */
    public UnaryCallSettings.Builder<BulkDeleteDocumentsRequest, Operation>
        bulkDeleteDocumentsSettings() {
      return bulkDeleteDocumentsSettings;
    }

    /** Returns the builder for the settings used for calls to bulkDeleteDocuments. */
    public OperationCallSettings.Builder<
            BulkDeleteDocumentsRequest, BulkDeleteDocumentsResponse, BulkDeleteDocumentsMetadata>
        bulkDeleteDocumentsOperationSettings() {
      return bulkDeleteDocumentsOperationSettings;
    }

    /** Returns the builder for the settings used for calls to createDatabase. */
    public UnaryCallSettings.Builder<CreateDatabaseRequest, Operation> createDatabaseSettings() {
      return createDatabaseSettings;
    }

    /** Returns the builder for the settings used for calls to createDatabase. */
    public OperationCallSettings.Builder<CreateDatabaseRequest, Database, CreateDatabaseMetadata>
        createDatabaseOperationSettings() {
      return createDatabaseOperationSettings;
    }

    /** Returns the builder for the settings used for calls to getDatabase. */
    public UnaryCallSettings.Builder<GetDatabaseRequest, Database> getDatabaseSettings() {
      return getDatabaseSettings;
    }

    /** Returns the builder for the settings used for calls to listDatabases. */
    public UnaryCallSettings.Builder<ListDatabasesRequest, ListDatabasesResponse>
        listDatabasesSettings() {
      return listDatabasesSettings;
    }

    /** Returns the builder for the settings used for calls to updateDatabase. */
    public UnaryCallSettings.Builder<UpdateDatabaseRequest, Operation> updateDatabaseSettings() {
      return updateDatabaseSettings;
    }

    /** Returns the builder for the settings used for calls to updateDatabase. */
    public OperationCallSettings.Builder<UpdateDatabaseRequest, Database, UpdateDatabaseMetadata>
        updateDatabaseOperationSettings() {
      return updateDatabaseOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteDatabase. */
    public UnaryCallSettings.Builder<DeleteDatabaseRequest, Operation> deleteDatabaseSettings() {
      return deleteDatabaseSettings;
    }

    /** Returns the builder for the settings used for calls to deleteDatabase. */
    public OperationCallSettings.Builder<DeleteDatabaseRequest, Database, DeleteDatabaseMetadata>
        deleteDatabaseOperationSettings() {
      return deleteDatabaseOperationSettings;
    }

    /** Returns the builder for the settings used for calls to createUserCreds. */
    public UnaryCallSettings.Builder<CreateUserCredsRequest, UserCreds> createUserCredsSettings() {
      return createUserCredsSettings;
    }

    /** Returns the builder for the settings used for calls to getUserCreds. */
    public UnaryCallSettings.Builder<GetUserCredsRequest, UserCreds> getUserCredsSettings() {
      return getUserCredsSettings;
    }

    /** Returns the builder for the settings used for calls to listUserCreds. */
    public UnaryCallSettings.Builder<ListUserCredsRequest, ListUserCredsResponse>
        listUserCredsSettings() {
      return listUserCredsSettings;
    }

    /** Returns the builder for the settings used for calls to enableUserCreds. */
    public UnaryCallSettings.Builder<EnableUserCredsRequest, UserCreds> enableUserCredsSettings() {
      return enableUserCredsSettings;
    }

    /** Returns the builder for the settings used for calls to disableUserCreds. */
    public UnaryCallSettings.Builder<DisableUserCredsRequest, UserCreds>
        disableUserCredsSettings() {
      return disableUserCredsSettings;
    }

    /** Returns the builder for the settings used for calls to resetUserPassword. */
    public UnaryCallSettings.Builder<ResetUserPasswordRequest, UserCreds>
        resetUserPasswordSettings() {
      return resetUserPasswordSettings;
    }

    /** Returns the builder for the settings used for calls to deleteUserCreds. */
    public UnaryCallSettings.Builder<DeleteUserCredsRequest, Empty> deleteUserCredsSettings() {
      return deleteUserCredsSettings;
    }

    /** Returns the builder for the settings used for calls to getBackup. */
    public UnaryCallSettings.Builder<GetBackupRequest, Backup> getBackupSettings() {
      return getBackupSettings;
    }

    /** Returns the builder for the settings used for calls to listBackups. */
    public UnaryCallSettings.Builder<ListBackupsRequest, ListBackupsResponse>
        listBackupsSettings() {
      return listBackupsSettings;
    }

    /** Returns the builder for the settings used for calls to deleteBackup. */
    public UnaryCallSettings.Builder<DeleteBackupRequest, Empty> deleteBackupSettings() {
      return deleteBackupSettings;
    }

    /** Returns the builder for the settings used for calls to restoreDatabase. */
    public UnaryCallSettings.Builder<RestoreDatabaseRequest, Operation> restoreDatabaseSettings() {
      return restoreDatabaseSettings;
    }

    /** Returns the builder for the settings used for calls to restoreDatabase. */
    public OperationCallSettings.Builder<RestoreDatabaseRequest, Database, RestoreDatabaseMetadata>
        restoreDatabaseOperationSettings() {
      return restoreDatabaseOperationSettings;
    }

    /** Returns the builder for the settings used for calls to createBackupSchedule. */
    public UnaryCallSettings.Builder<CreateBackupScheduleRequest, BackupSchedule>
        createBackupScheduleSettings() {
      return createBackupScheduleSettings;
    }

    /** Returns the builder for the settings used for calls to getBackupSchedule. */
    public UnaryCallSettings.Builder<GetBackupScheduleRequest, BackupSchedule>
        getBackupScheduleSettings() {
      return getBackupScheduleSettings;
    }

    /** Returns the builder for the settings used for calls to listBackupSchedules. */
    public UnaryCallSettings.Builder<ListBackupSchedulesRequest, ListBackupSchedulesResponse>
        listBackupSchedulesSettings() {
      return listBackupSchedulesSettings;
    }

    /** Returns the builder for the settings used for calls to updateBackupSchedule. */
    public UnaryCallSettings.Builder<UpdateBackupScheduleRequest, BackupSchedule>
        updateBackupScheduleSettings() {
      return updateBackupScheduleSettings;
    }

    /** Returns the builder for the settings used for calls to deleteBackupSchedule. */
    public UnaryCallSettings.Builder<DeleteBackupScheduleRequest, Empty>
        deleteBackupScheduleSettings() {
      return deleteBackupScheduleSettings;
    }

    /** Returns the builder for the settings used for calls to cloneDatabase. */
    public UnaryCallSettings.Builder<CloneDatabaseRequest, Operation> cloneDatabaseSettings() {
      return cloneDatabaseSettings;
    }

    /** Returns the builder for the settings used for calls to cloneDatabase. */
    public OperationCallSettings.Builder<CloneDatabaseRequest, Database, CloneDatabaseMetadata>
        cloneDatabaseOperationSettings() {
      return cloneDatabaseOperationSettings;
    }

    @Override
    public FirestoreAdminStubSettings build() throws IOException {
      return new FirestoreAdminStubSettings(this);
    }
  }
}
