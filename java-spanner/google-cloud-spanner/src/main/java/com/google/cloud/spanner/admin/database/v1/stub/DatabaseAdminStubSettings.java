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

package com.google.cloud.spanner.admin.database.v1.stub;

import static com.google.cloud.spanner.admin.database.v1.DatabaseAdminClient.ListBackupOperationsPagedResponse;
import static com.google.cloud.spanner.admin.database.v1.DatabaseAdminClient.ListBackupSchedulesPagedResponse;
import static com.google.cloud.spanner.admin.database.v1.DatabaseAdminClient.ListBackupsPagedResponse;
import static com.google.cloud.spanner.admin.database.v1.DatabaseAdminClient.ListDatabaseOperationsPagedResponse;
import static com.google.cloud.spanner.admin.database.v1.DatabaseAdminClient.ListDatabaseRolesPagedResponse;
import static com.google.cloud.spanner.admin.database.v1.DatabaseAdminClient.ListDatabasesPagedResponse;

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
import com.google.api.gax.rpc.LibraryMetadata;
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
import com.google.spanner.admin.database.v1.DatabaseRole;
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
import java.time.Duration;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link DatabaseAdminStub}.
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
 * DatabaseAdminStubSettings.Builder databaseAdminSettingsBuilder =
 *     DatabaseAdminStubSettings.newBuilder();
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
 * DatabaseAdminStubSettings databaseAdminSettings = databaseAdminSettingsBuilder.build();
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
 * DatabaseAdminStubSettings.Builder databaseAdminSettingsBuilder =
 *     DatabaseAdminStubSettings.newBuilder();
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
@SuppressWarnings("CanonicalDuration")
public class DatabaseAdminStubSettings extends StubSettings<DatabaseAdminStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder()
          .add("https://www.googleapis.com/auth/cloud-platform")
          .add("https://www.googleapis.com/auth/spanner.admin")
          .build();

  private final PagedCallSettings<
          ListDatabasesRequest, ListDatabasesResponse, ListDatabasesPagedResponse>
      listDatabasesSettings;
  private final UnaryCallSettings<CreateDatabaseRequest, Operation> createDatabaseSettings;
  private final OperationCallSettings<CreateDatabaseRequest, Database, CreateDatabaseMetadata>
      createDatabaseOperationSettings;
  private final UnaryCallSettings<GetDatabaseRequest, Database> getDatabaseSettings;
  private final UnaryCallSettings<UpdateDatabaseRequest, Operation> updateDatabaseSettings;
  private final OperationCallSettings<UpdateDatabaseRequest, Database, UpdateDatabaseMetadata>
      updateDatabaseOperationSettings;
  private final UnaryCallSettings<UpdateDatabaseDdlRequest, Operation> updateDatabaseDdlSettings;
  private final OperationCallSettings<UpdateDatabaseDdlRequest, Empty, UpdateDatabaseDdlMetadata>
      updateDatabaseDdlOperationSettings;
  private final UnaryCallSettings<DropDatabaseRequest, Empty> dropDatabaseSettings;
  private final UnaryCallSettings<GetDatabaseDdlRequest, GetDatabaseDdlResponse>
      getDatabaseDdlSettings;
  private final UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings;
  private final UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings;
  private final UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings;
  private final UnaryCallSettings<CreateBackupRequest, Operation> createBackupSettings;
  private final OperationCallSettings<CreateBackupRequest, Backup, CreateBackupMetadata>
      createBackupOperationSettings;
  private final UnaryCallSettings<CopyBackupRequest, Operation> copyBackupSettings;
  private final OperationCallSettings<CopyBackupRequest, Backup, CopyBackupMetadata>
      copyBackupOperationSettings;
  private final UnaryCallSettings<GetBackupRequest, Backup> getBackupSettings;
  private final UnaryCallSettings<UpdateBackupRequest, Backup> updateBackupSettings;
  private final UnaryCallSettings<DeleteBackupRequest, Empty> deleteBackupSettings;
  private final PagedCallSettings<ListBackupsRequest, ListBackupsResponse, ListBackupsPagedResponse>
      listBackupsSettings;
  private final UnaryCallSettings<RestoreDatabaseRequest, Operation> restoreDatabaseSettings;
  private final OperationCallSettings<RestoreDatabaseRequest, Database, RestoreDatabaseMetadata>
      restoreDatabaseOperationSettings;
  private final PagedCallSettings<
          ListDatabaseOperationsRequest,
          ListDatabaseOperationsResponse,
          ListDatabaseOperationsPagedResponse>
      listDatabaseOperationsSettings;
  private final PagedCallSettings<
          ListBackupOperationsRequest,
          ListBackupOperationsResponse,
          ListBackupOperationsPagedResponse>
      listBackupOperationsSettings;
  private final PagedCallSettings<
          ListDatabaseRolesRequest, ListDatabaseRolesResponse, ListDatabaseRolesPagedResponse>
      listDatabaseRolesSettings;
  private final UnaryCallSettings<AddSplitPointsRequest, AddSplitPointsResponse>
      addSplitPointsSettings;
  private final UnaryCallSettings<CreateBackupScheduleRequest, BackupSchedule>
      createBackupScheduleSettings;
  private final UnaryCallSettings<GetBackupScheduleRequest, BackupSchedule>
      getBackupScheduleSettings;
  private final UnaryCallSettings<UpdateBackupScheduleRequest, BackupSchedule>
      updateBackupScheduleSettings;
  private final UnaryCallSettings<DeleteBackupScheduleRequest, Empty> deleteBackupScheduleSettings;
  private final PagedCallSettings<
          ListBackupSchedulesRequest, ListBackupSchedulesResponse, ListBackupSchedulesPagedResponse>
      listBackupSchedulesSettings;
  private final UnaryCallSettings<
          InternalUpdateGraphOperationRequest, InternalUpdateGraphOperationResponse>
      internalUpdateGraphOperationSettings;

  private static final PagedListDescriptor<ListDatabasesRequest, ListDatabasesResponse, Database>
      LIST_DATABASES_PAGE_STR_DESC =
          new PagedListDescriptor<ListDatabasesRequest, ListDatabasesResponse, Database>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListDatabasesRequest injectToken(ListDatabasesRequest payload, String token) {
              return ListDatabasesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListDatabasesRequest injectPageSize(ListDatabasesRequest payload, int pageSize) {
              return ListDatabasesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListDatabasesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListDatabasesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Database> extractResources(ListDatabasesResponse payload) {
              return payload.getDatabasesList();
            }
          };

  private static final PagedListDescriptor<ListBackupsRequest, ListBackupsResponse, Backup>
      LIST_BACKUPS_PAGE_STR_DESC =
          new PagedListDescriptor<ListBackupsRequest, ListBackupsResponse, Backup>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListBackupsRequest injectToken(ListBackupsRequest payload, String token) {
              return ListBackupsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListBackupsRequest injectPageSize(ListBackupsRequest payload, int pageSize) {
              return ListBackupsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListBackupsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListBackupsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Backup> extractResources(ListBackupsResponse payload) {
              return payload.getBackupsList();
            }
          };

  private static final PagedListDescriptor<
          ListDatabaseOperationsRequest, ListDatabaseOperationsResponse, Operation>
      LIST_DATABASE_OPERATIONS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListDatabaseOperationsRequest, ListDatabaseOperationsResponse, Operation>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListDatabaseOperationsRequest injectToken(
                ListDatabaseOperationsRequest payload, String token) {
              return ListDatabaseOperationsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListDatabaseOperationsRequest injectPageSize(
                ListDatabaseOperationsRequest payload, int pageSize) {
              return ListDatabaseOperationsRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListDatabaseOperationsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListDatabaseOperationsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Operation> extractResources(ListDatabaseOperationsResponse payload) {
              return payload.getOperationsList();
            }
          };

  private static final PagedListDescriptor<
          ListBackupOperationsRequest, ListBackupOperationsResponse, Operation>
      LIST_BACKUP_OPERATIONS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListBackupOperationsRequest, ListBackupOperationsResponse, Operation>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListBackupOperationsRequest injectToken(
                ListBackupOperationsRequest payload, String token) {
              return ListBackupOperationsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListBackupOperationsRequest injectPageSize(
                ListBackupOperationsRequest payload, int pageSize) {
              return ListBackupOperationsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListBackupOperationsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListBackupOperationsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Operation> extractResources(ListBackupOperationsResponse payload) {
              return payload.getOperationsList();
            }
          };

  private static final PagedListDescriptor<
          ListDatabaseRolesRequest, ListDatabaseRolesResponse, DatabaseRole>
      LIST_DATABASE_ROLES_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListDatabaseRolesRequest, ListDatabaseRolesResponse, DatabaseRole>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListDatabaseRolesRequest injectToken(
                ListDatabaseRolesRequest payload, String token) {
              return ListDatabaseRolesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListDatabaseRolesRequest injectPageSize(
                ListDatabaseRolesRequest payload, int pageSize) {
              return ListDatabaseRolesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListDatabaseRolesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListDatabaseRolesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<DatabaseRole> extractResources(ListDatabaseRolesResponse payload) {
              return payload.getDatabaseRolesList();
            }
          };

  private static final PagedListDescriptor<
          ListBackupSchedulesRequest, ListBackupSchedulesResponse, BackupSchedule>
      LIST_BACKUP_SCHEDULES_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListBackupSchedulesRequest, ListBackupSchedulesResponse, BackupSchedule>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListBackupSchedulesRequest injectToken(
                ListBackupSchedulesRequest payload, String token) {
              return ListBackupSchedulesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListBackupSchedulesRequest injectPageSize(
                ListBackupSchedulesRequest payload, int pageSize) {
              return ListBackupSchedulesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListBackupSchedulesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListBackupSchedulesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<BackupSchedule> extractResources(ListBackupSchedulesResponse payload) {
              return payload.getBackupSchedulesList();
            }
          };

  private static final PagedListResponseFactory<
          ListDatabasesRequest, ListDatabasesResponse, ListDatabasesPagedResponse>
      LIST_DATABASES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListDatabasesRequest, ListDatabasesResponse, ListDatabasesPagedResponse>() {
            @Override
            public ApiFuture<ListDatabasesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListDatabasesRequest, ListDatabasesResponse> callable,
                ListDatabasesRequest request,
                ApiCallContext context,
                ApiFuture<ListDatabasesResponse> futureResponse) {
              PageContext<ListDatabasesRequest, ListDatabasesResponse, Database> pageContext =
                  PageContext.create(callable, LIST_DATABASES_PAGE_STR_DESC, request, context);
              return ListDatabasesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListBackupsRequest, ListBackupsResponse, ListBackupsPagedResponse>
      LIST_BACKUPS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListBackupsRequest, ListBackupsResponse, ListBackupsPagedResponse>() {
            @Override
            public ApiFuture<ListBackupsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListBackupsRequest, ListBackupsResponse> callable,
                ListBackupsRequest request,
                ApiCallContext context,
                ApiFuture<ListBackupsResponse> futureResponse) {
              PageContext<ListBackupsRequest, ListBackupsResponse, Backup> pageContext =
                  PageContext.create(callable, LIST_BACKUPS_PAGE_STR_DESC, request, context);
              return ListBackupsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListDatabaseOperationsRequest,
          ListDatabaseOperationsResponse,
          ListDatabaseOperationsPagedResponse>
      LIST_DATABASE_OPERATIONS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListDatabaseOperationsRequest,
              ListDatabaseOperationsResponse,
              ListDatabaseOperationsPagedResponse>() {
            @Override
            public ApiFuture<ListDatabaseOperationsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListDatabaseOperationsRequest, ListDatabaseOperationsResponse>
                    callable,
                ListDatabaseOperationsRequest request,
                ApiCallContext context,
                ApiFuture<ListDatabaseOperationsResponse> futureResponse) {
              PageContext<ListDatabaseOperationsRequest, ListDatabaseOperationsResponse, Operation>
                  pageContext =
                      PageContext.create(
                          callable, LIST_DATABASE_OPERATIONS_PAGE_STR_DESC, request, context);
              return ListDatabaseOperationsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListBackupOperationsRequest,
          ListBackupOperationsResponse,
          ListBackupOperationsPagedResponse>
      LIST_BACKUP_OPERATIONS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListBackupOperationsRequest,
              ListBackupOperationsResponse,
              ListBackupOperationsPagedResponse>() {
            @Override
            public ApiFuture<ListBackupOperationsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListBackupOperationsRequest, ListBackupOperationsResponse> callable,
                ListBackupOperationsRequest request,
                ApiCallContext context,
                ApiFuture<ListBackupOperationsResponse> futureResponse) {
              PageContext<ListBackupOperationsRequest, ListBackupOperationsResponse, Operation>
                  pageContext =
                      PageContext.create(
                          callable, LIST_BACKUP_OPERATIONS_PAGE_STR_DESC, request, context);
              return ListBackupOperationsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListDatabaseRolesRequest, ListDatabaseRolesResponse, ListDatabaseRolesPagedResponse>
      LIST_DATABASE_ROLES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListDatabaseRolesRequest,
              ListDatabaseRolesResponse,
              ListDatabaseRolesPagedResponse>() {
            @Override
            public ApiFuture<ListDatabaseRolesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListDatabaseRolesRequest, ListDatabaseRolesResponse> callable,
                ListDatabaseRolesRequest request,
                ApiCallContext context,
                ApiFuture<ListDatabaseRolesResponse> futureResponse) {
              PageContext<ListDatabaseRolesRequest, ListDatabaseRolesResponse, DatabaseRole>
                  pageContext =
                      PageContext.create(
                          callable, LIST_DATABASE_ROLES_PAGE_STR_DESC, request, context);
              return ListDatabaseRolesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListBackupSchedulesRequest, ListBackupSchedulesResponse, ListBackupSchedulesPagedResponse>
      LIST_BACKUP_SCHEDULES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListBackupSchedulesRequest,
              ListBackupSchedulesResponse,
              ListBackupSchedulesPagedResponse>() {
            @Override
            public ApiFuture<ListBackupSchedulesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListBackupSchedulesRequest, ListBackupSchedulesResponse> callable,
                ListBackupSchedulesRequest request,
                ApiCallContext context,
                ApiFuture<ListBackupSchedulesResponse> futureResponse) {
              PageContext<ListBackupSchedulesRequest, ListBackupSchedulesResponse, BackupSchedule>
                  pageContext =
                      PageContext.create(
                          callable, LIST_BACKUP_SCHEDULES_PAGE_STR_DESC, request, context);
              return ListBackupSchedulesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to listDatabases. */
  public PagedCallSettings<ListDatabasesRequest, ListDatabasesResponse, ListDatabasesPagedResponse>
      listDatabasesSettings() {
    return listDatabasesSettings;
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

  /** Returns the object with the settings used for calls to updateDatabase. */
  public UnaryCallSettings<UpdateDatabaseRequest, Operation> updateDatabaseSettings() {
    return updateDatabaseSettings;
  }

  /** Returns the object with the settings used for calls to updateDatabase. */
  public OperationCallSettings<UpdateDatabaseRequest, Database, UpdateDatabaseMetadata>
      updateDatabaseOperationSettings() {
    return updateDatabaseOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateDatabaseDdl. */
  public UnaryCallSettings<UpdateDatabaseDdlRequest, Operation> updateDatabaseDdlSettings() {
    return updateDatabaseDdlSettings;
  }

  /** Returns the object with the settings used for calls to updateDatabaseDdl. */
  public OperationCallSettings<UpdateDatabaseDdlRequest, Empty, UpdateDatabaseDdlMetadata>
      updateDatabaseDdlOperationSettings() {
    return updateDatabaseDdlOperationSettings;
  }

  /** Returns the object with the settings used for calls to dropDatabase. */
  public UnaryCallSettings<DropDatabaseRequest, Empty> dropDatabaseSettings() {
    return dropDatabaseSettings;
  }

  /** Returns the object with the settings used for calls to getDatabaseDdl. */
  public UnaryCallSettings<GetDatabaseDdlRequest, GetDatabaseDdlResponse> getDatabaseDdlSettings() {
    return getDatabaseDdlSettings;
  }

  /** Returns the object with the settings used for calls to setIamPolicy. */
  public UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings() {
    return setIamPolicySettings;
  }

  /** Returns the object with the settings used for calls to getIamPolicy. */
  public UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings() {
    return getIamPolicySettings;
  }

  /** Returns the object with the settings used for calls to testIamPermissions. */
  public UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings() {
    return testIamPermissionsSettings;
  }

  /** Returns the object with the settings used for calls to createBackup. */
  public UnaryCallSettings<CreateBackupRequest, Operation> createBackupSettings() {
    return createBackupSettings;
  }

  /** Returns the object with the settings used for calls to createBackup. */
  public OperationCallSettings<CreateBackupRequest, Backup, CreateBackupMetadata>
      createBackupOperationSettings() {
    return createBackupOperationSettings;
  }

  /** Returns the object with the settings used for calls to copyBackup. */
  public UnaryCallSettings<CopyBackupRequest, Operation> copyBackupSettings() {
    return copyBackupSettings;
  }

  /** Returns the object with the settings used for calls to copyBackup. */
  public OperationCallSettings<CopyBackupRequest, Backup, CopyBackupMetadata>
      copyBackupOperationSettings() {
    return copyBackupOperationSettings;
  }

  /** Returns the object with the settings used for calls to getBackup. */
  public UnaryCallSettings<GetBackupRequest, Backup> getBackupSettings() {
    return getBackupSettings;
  }

  /** Returns the object with the settings used for calls to updateBackup. */
  public UnaryCallSettings<UpdateBackupRequest, Backup> updateBackupSettings() {
    return updateBackupSettings;
  }

  /** Returns the object with the settings used for calls to deleteBackup. */
  public UnaryCallSettings<DeleteBackupRequest, Empty> deleteBackupSettings() {
    return deleteBackupSettings;
  }

  /** Returns the object with the settings used for calls to listBackups. */
  public PagedCallSettings<ListBackupsRequest, ListBackupsResponse, ListBackupsPagedResponse>
      listBackupsSettings() {
    return listBackupsSettings;
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

  /** Returns the object with the settings used for calls to listDatabaseOperations. */
  public PagedCallSettings<
          ListDatabaseOperationsRequest,
          ListDatabaseOperationsResponse,
          ListDatabaseOperationsPagedResponse>
      listDatabaseOperationsSettings() {
    return listDatabaseOperationsSettings;
  }

  /** Returns the object with the settings used for calls to listBackupOperations. */
  public PagedCallSettings<
          ListBackupOperationsRequest,
          ListBackupOperationsResponse,
          ListBackupOperationsPagedResponse>
      listBackupOperationsSettings() {
    return listBackupOperationsSettings;
  }

  /** Returns the object with the settings used for calls to listDatabaseRoles. */
  public PagedCallSettings<
          ListDatabaseRolesRequest, ListDatabaseRolesResponse, ListDatabaseRolesPagedResponse>
      listDatabaseRolesSettings() {
    return listDatabaseRolesSettings;
  }

  /** Returns the object with the settings used for calls to addSplitPoints. */
  public UnaryCallSettings<AddSplitPointsRequest, AddSplitPointsResponse> addSplitPointsSettings() {
    return addSplitPointsSettings;
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

  /** Returns the object with the settings used for calls to updateBackupSchedule. */
  public UnaryCallSettings<UpdateBackupScheduleRequest, BackupSchedule>
      updateBackupScheduleSettings() {
    return updateBackupScheduleSettings;
  }

  /** Returns the object with the settings used for calls to deleteBackupSchedule. */
  public UnaryCallSettings<DeleteBackupScheduleRequest, Empty> deleteBackupScheduleSettings() {
    return deleteBackupScheduleSettings;
  }

  /** Returns the object with the settings used for calls to listBackupSchedules. */
  public PagedCallSettings<
          ListBackupSchedulesRequest, ListBackupSchedulesResponse, ListBackupSchedulesPagedResponse>
      listBackupSchedulesSettings() {
    return listBackupSchedulesSettings;
  }

  /** Returns the object with the settings used for calls to internalUpdateGraph. */
  public UnaryCallSettings<
          InternalUpdateGraphOperationRequest, InternalUpdateGraphOperationResponse>
      internalUpdateGraphOperationSettings() {
    return internalUpdateGraphOperationSettings;
  }

  public DatabaseAdminStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcDatabaseAdminStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonDatabaseAdminStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns the default service name. */
  @Override
  public String getServiceName() {
    return "spanner";
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  @ObsoleteApi("Use getEndpoint() instead")
  public static String getDefaultEndpoint() {
    return "spanner.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "spanner.mtls.googleapis.com:443";
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
            "gapic", GaxProperties.getLibraryVersion(DatabaseAdminStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(DatabaseAdminStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return DatabaseAdminStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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

  protected DatabaseAdminStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    listDatabasesSettings = settingsBuilder.listDatabasesSettings().build();
    createDatabaseSettings = settingsBuilder.createDatabaseSettings().build();
    createDatabaseOperationSettings = settingsBuilder.createDatabaseOperationSettings().build();
    getDatabaseSettings = settingsBuilder.getDatabaseSettings().build();
    updateDatabaseSettings = settingsBuilder.updateDatabaseSettings().build();
    updateDatabaseOperationSettings = settingsBuilder.updateDatabaseOperationSettings().build();
    updateDatabaseDdlSettings = settingsBuilder.updateDatabaseDdlSettings().build();
    updateDatabaseDdlOperationSettings =
        settingsBuilder.updateDatabaseDdlOperationSettings().build();
    dropDatabaseSettings = settingsBuilder.dropDatabaseSettings().build();
    getDatabaseDdlSettings = settingsBuilder.getDatabaseDdlSettings().build();
    setIamPolicySettings = settingsBuilder.setIamPolicySettings().build();
    getIamPolicySettings = settingsBuilder.getIamPolicySettings().build();
    testIamPermissionsSettings = settingsBuilder.testIamPermissionsSettings().build();
    createBackupSettings = settingsBuilder.createBackupSettings().build();
    createBackupOperationSettings = settingsBuilder.createBackupOperationSettings().build();
    copyBackupSettings = settingsBuilder.copyBackupSettings().build();
    copyBackupOperationSettings = settingsBuilder.copyBackupOperationSettings().build();
    getBackupSettings = settingsBuilder.getBackupSettings().build();
    updateBackupSettings = settingsBuilder.updateBackupSettings().build();
    deleteBackupSettings = settingsBuilder.deleteBackupSettings().build();
    listBackupsSettings = settingsBuilder.listBackupsSettings().build();
    restoreDatabaseSettings = settingsBuilder.restoreDatabaseSettings().build();
    restoreDatabaseOperationSettings = settingsBuilder.restoreDatabaseOperationSettings().build();
    listDatabaseOperationsSettings = settingsBuilder.listDatabaseOperationsSettings().build();
    listBackupOperationsSettings = settingsBuilder.listBackupOperationsSettings().build();
    listDatabaseRolesSettings = settingsBuilder.listDatabaseRolesSettings().build();
    addSplitPointsSettings = settingsBuilder.addSplitPointsSettings().build();
    createBackupScheduleSettings = settingsBuilder.createBackupScheduleSettings().build();
    getBackupScheduleSettings = settingsBuilder.getBackupScheduleSettings().build();
    updateBackupScheduleSettings = settingsBuilder.updateBackupScheduleSettings().build();
    deleteBackupScheduleSettings = settingsBuilder.deleteBackupScheduleSettings().build();
    listBackupSchedulesSettings = settingsBuilder.listBackupSchedulesSettings().build();
    internalUpdateGraphOperationSettings =
        settingsBuilder.internalUpdateGraphOperationSettings().build();
  }

  @Override
  protected LibraryMetadata getLibraryMetadata() {
    return LibraryMetadata.newBuilder()
        .setArtifactName("com.google.cloud:google-cloud-spanner")
        .setRepository("googleapis/google-cloud-java")
        .setVersion(Version.VERSION)
        .build();
  }

  /** Builder for DatabaseAdminStubSettings. */
  public static class Builder extends StubSettings.Builder<DatabaseAdminStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final PagedCallSettings.Builder<
            ListDatabasesRequest, ListDatabasesResponse, ListDatabasesPagedResponse>
        listDatabasesSettings;
    private final UnaryCallSettings.Builder<CreateDatabaseRequest, Operation>
        createDatabaseSettings;
    private final OperationCallSettings.Builder<
            CreateDatabaseRequest, Database, CreateDatabaseMetadata>
        createDatabaseOperationSettings;
    private final UnaryCallSettings.Builder<GetDatabaseRequest, Database> getDatabaseSettings;
    private final UnaryCallSettings.Builder<UpdateDatabaseRequest, Operation>
        updateDatabaseSettings;
    private final OperationCallSettings.Builder<
            UpdateDatabaseRequest, Database, UpdateDatabaseMetadata>
        updateDatabaseOperationSettings;
    private final UnaryCallSettings.Builder<UpdateDatabaseDdlRequest, Operation>
        updateDatabaseDdlSettings;
    private final OperationCallSettings.Builder<
            UpdateDatabaseDdlRequest, Empty, UpdateDatabaseDdlMetadata>
        updateDatabaseDdlOperationSettings;
    private final UnaryCallSettings.Builder<DropDatabaseRequest, Empty> dropDatabaseSettings;
    private final UnaryCallSettings.Builder<GetDatabaseDdlRequest, GetDatabaseDdlResponse>
        getDatabaseDdlSettings;
    private final UnaryCallSettings.Builder<SetIamPolicyRequest, Policy> setIamPolicySettings;
    private final UnaryCallSettings.Builder<GetIamPolicyRequest, Policy> getIamPolicySettings;
    private final UnaryCallSettings.Builder<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsSettings;
    private final UnaryCallSettings.Builder<CreateBackupRequest, Operation> createBackupSettings;
    private final OperationCallSettings.Builder<CreateBackupRequest, Backup, CreateBackupMetadata>
        createBackupOperationSettings;
    private final UnaryCallSettings.Builder<CopyBackupRequest, Operation> copyBackupSettings;
    private final OperationCallSettings.Builder<CopyBackupRequest, Backup, CopyBackupMetadata>
        copyBackupOperationSettings;
    private final UnaryCallSettings.Builder<GetBackupRequest, Backup> getBackupSettings;
    private final UnaryCallSettings.Builder<UpdateBackupRequest, Backup> updateBackupSettings;
    private final UnaryCallSettings.Builder<DeleteBackupRequest, Empty> deleteBackupSettings;
    private final PagedCallSettings.Builder<
            ListBackupsRequest, ListBackupsResponse, ListBackupsPagedResponse>
        listBackupsSettings;
    private final UnaryCallSettings.Builder<RestoreDatabaseRequest, Operation>
        restoreDatabaseSettings;
    private final OperationCallSettings.Builder<
            RestoreDatabaseRequest, Database, RestoreDatabaseMetadata>
        restoreDatabaseOperationSettings;
    private final PagedCallSettings.Builder<
            ListDatabaseOperationsRequest,
            ListDatabaseOperationsResponse,
            ListDatabaseOperationsPagedResponse>
        listDatabaseOperationsSettings;
    private final PagedCallSettings.Builder<
            ListBackupOperationsRequest,
            ListBackupOperationsResponse,
            ListBackupOperationsPagedResponse>
        listBackupOperationsSettings;
    private final PagedCallSettings.Builder<
            ListDatabaseRolesRequest, ListDatabaseRolesResponse, ListDatabaseRolesPagedResponse>
        listDatabaseRolesSettings;
    private final UnaryCallSettings.Builder<AddSplitPointsRequest, AddSplitPointsResponse>
        addSplitPointsSettings;
    private final UnaryCallSettings.Builder<CreateBackupScheduleRequest, BackupSchedule>
        createBackupScheduleSettings;
    private final UnaryCallSettings.Builder<GetBackupScheduleRequest, BackupSchedule>
        getBackupScheduleSettings;
    private final UnaryCallSettings.Builder<UpdateBackupScheduleRequest, BackupSchedule>
        updateBackupScheduleSettings;
    private final UnaryCallSettings.Builder<DeleteBackupScheduleRequest, Empty>
        deleteBackupScheduleSettings;
    private final PagedCallSettings.Builder<
            ListBackupSchedulesRequest,
            ListBackupSchedulesResponse,
            ListBackupSchedulesPagedResponse>
        listBackupSchedulesSettings;
    private final UnaryCallSettings.Builder<
            InternalUpdateGraphOperationRequest, InternalUpdateGraphOperationResponse>
        internalUpdateGraphOperationSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put(
          "retry_policy_0_codes",
          ImmutableSet.copyOf(
              Lists.<StatusCode.Code>newArrayList(
                  StatusCode.Code.UNAVAILABLE, StatusCode.Code.DEADLINE_EXCEEDED)));
      definitions.put(
          "no_retry_2_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      definitions.put(
          "no_retry_3_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      definitions.put(
          "retry_policy_1_codes",
          ImmutableSet.copyOf(
              Lists.<StatusCode.Code>newArrayList(
                  StatusCode.Code.UNAVAILABLE, StatusCode.Code.DEADLINE_EXCEEDED)));
      definitions.put("no_retry_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      RETRYABLE_CODE_DEFINITIONS = definitions.build();
    }

    private static final ImmutableMap<String, RetrySettings> RETRY_PARAM_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, RetrySettings> definitions = ImmutableMap.builder();
      RetrySettings settings = null;
      settings =
          RetrySettings.newBuilder()
              .setInitialRetryDelayDuration(Duration.ofMillis(1000L))
              .setRetryDelayMultiplier(1.3)
              .setMaxRetryDelayDuration(Duration.ofMillis(32000L))
              .setInitialRpcTimeoutDuration(Duration.ofMillis(3600000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeoutDuration(Duration.ofMillis(3600000L))
              .setTotalTimeoutDuration(Duration.ofMillis(3600000L))
              .build();
      definitions.put("retry_policy_0_params", settings);
      settings =
          RetrySettings.newBuilder()
              .setInitialRpcTimeoutDuration(Duration.ofMillis(3600000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeoutDuration(Duration.ofMillis(3600000L))
              .setTotalTimeoutDuration(Duration.ofMillis(3600000L))
              .build();
      definitions.put("no_retry_2_params", settings);
      settings =
          RetrySettings.newBuilder()
              .setInitialRpcTimeoutDuration(Duration.ofMillis(30000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeoutDuration(Duration.ofMillis(30000L))
              .setTotalTimeoutDuration(Duration.ofMillis(30000L))
              .build();
      definitions.put("no_retry_3_params", settings);
      settings =
          RetrySettings.newBuilder()
              .setInitialRetryDelayDuration(Duration.ofMillis(1000L))
              .setRetryDelayMultiplier(1.3)
              .setMaxRetryDelayDuration(Duration.ofMillis(32000L))
              .setInitialRpcTimeoutDuration(Duration.ofMillis(30000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeoutDuration(Duration.ofMillis(30000L))
              .setTotalTimeoutDuration(Duration.ofMillis(30000L))
              .build();
      definitions.put("retry_policy_1_params", settings);
      settings = RetrySettings.newBuilder().setRpcTimeoutMultiplier(1.0).build();
      definitions.put("no_retry_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      listDatabasesSettings = PagedCallSettings.newBuilder(LIST_DATABASES_PAGE_STR_FACT);
      createDatabaseSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createDatabaseOperationSettings = OperationCallSettings.newBuilder();
      getDatabaseSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateDatabaseSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateDatabaseOperationSettings = OperationCallSettings.newBuilder();
      updateDatabaseDdlSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateDatabaseDdlOperationSettings = OperationCallSettings.newBuilder();
      dropDatabaseSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getDatabaseDdlSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      setIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      testIamPermissionsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createBackupSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createBackupOperationSettings = OperationCallSettings.newBuilder();
      copyBackupSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      copyBackupOperationSettings = OperationCallSettings.newBuilder();
      getBackupSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateBackupSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteBackupSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listBackupsSettings = PagedCallSettings.newBuilder(LIST_BACKUPS_PAGE_STR_FACT);
      restoreDatabaseSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      restoreDatabaseOperationSettings = OperationCallSettings.newBuilder();
      listDatabaseOperationsSettings =
          PagedCallSettings.newBuilder(LIST_DATABASE_OPERATIONS_PAGE_STR_FACT);
      listBackupOperationsSettings =
          PagedCallSettings.newBuilder(LIST_BACKUP_OPERATIONS_PAGE_STR_FACT);
      listDatabaseRolesSettings = PagedCallSettings.newBuilder(LIST_DATABASE_ROLES_PAGE_STR_FACT);
      addSplitPointsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createBackupScheduleSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getBackupScheduleSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateBackupScheduleSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteBackupScheduleSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listBackupSchedulesSettings =
          PagedCallSettings.newBuilder(LIST_BACKUP_SCHEDULES_PAGE_STR_FACT);
      internalUpdateGraphOperationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listDatabasesSettings,
              createDatabaseSettings,
              getDatabaseSettings,
              updateDatabaseSettings,
              updateDatabaseDdlSettings,
              dropDatabaseSettings,
              getDatabaseDdlSettings,
              setIamPolicySettings,
              getIamPolicySettings,
              testIamPermissionsSettings,
              createBackupSettings,
              copyBackupSettings,
              getBackupSettings,
              updateBackupSettings,
              deleteBackupSettings,
              listBackupsSettings,
              restoreDatabaseSettings,
              listDatabaseOperationsSettings,
              listBackupOperationsSettings,
              listDatabaseRolesSettings,
              addSplitPointsSettings,
              createBackupScheduleSettings,
              getBackupScheduleSettings,
              updateBackupScheduleSettings,
              deleteBackupScheduleSettings,
              listBackupSchedulesSettings,
              internalUpdateGraphOperationSettings);
      initDefaults(this);
    }

    protected Builder(DatabaseAdminStubSettings settings) {
      super(settings);

      listDatabasesSettings = settings.listDatabasesSettings.toBuilder();
      createDatabaseSettings = settings.createDatabaseSettings.toBuilder();
      createDatabaseOperationSettings = settings.createDatabaseOperationSettings.toBuilder();
      getDatabaseSettings = settings.getDatabaseSettings.toBuilder();
      updateDatabaseSettings = settings.updateDatabaseSettings.toBuilder();
      updateDatabaseOperationSettings = settings.updateDatabaseOperationSettings.toBuilder();
      updateDatabaseDdlSettings = settings.updateDatabaseDdlSettings.toBuilder();
      updateDatabaseDdlOperationSettings = settings.updateDatabaseDdlOperationSettings.toBuilder();
      dropDatabaseSettings = settings.dropDatabaseSettings.toBuilder();
      getDatabaseDdlSettings = settings.getDatabaseDdlSettings.toBuilder();
      setIamPolicySettings = settings.setIamPolicySettings.toBuilder();
      getIamPolicySettings = settings.getIamPolicySettings.toBuilder();
      testIamPermissionsSettings = settings.testIamPermissionsSettings.toBuilder();
      createBackupSettings = settings.createBackupSettings.toBuilder();
      createBackupOperationSettings = settings.createBackupOperationSettings.toBuilder();
      copyBackupSettings = settings.copyBackupSettings.toBuilder();
      copyBackupOperationSettings = settings.copyBackupOperationSettings.toBuilder();
      getBackupSettings = settings.getBackupSettings.toBuilder();
      updateBackupSettings = settings.updateBackupSettings.toBuilder();
      deleteBackupSettings = settings.deleteBackupSettings.toBuilder();
      listBackupsSettings = settings.listBackupsSettings.toBuilder();
      restoreDatabaseSettings = settings.restoreDatabaseSettings.toBuilder();
      restoreDatabaseOperationSettings = settings.restoreDatabaseOperationSettings.toBuilder();
      listDatabaseOperationsSettings = settings.listDatabaseOperationsSettings.toBuilder();
      listBackupOperationsSettings = settings.listBackupOperationsSettings.toBuilder();
      listDatabaseRolesSettings = settings.listDatabaseRolesSettings.toBuilder();
      addSplitPointsSettings = settings.addSplitPointsSettings.toBuilder();
      createBackupScheduleSettings = settings.createBackupScheduleSettings.toBuilder();
      getBackupScheduleSettings = settings.getBackupScheduleSettings.toBuilder();
      updateBackupScheduleSettings = settings.updateBackupScheduleSettings.toBuilder();
      deleteBackupScheduleSettings = settings.deleteBackupScheduleSettings.toBuilder();
      listBackupSchedulesSettings = settings.listBackupSchedulesSettings.toBuilder();
      internalUpdateGraphOperationSettings =
          settings.internalUpdateGraphOperationSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listDatabasesSettings,
              createDatabaseSettings,
              getDatabaseSettings,
              updateDatabaseSettings,
              updateDatabaseDdlSettings,
              dropDatabaseSettings,
              getDatabaseDdlSettings,
              setIamPolicySettings,
              getIamPolicySettings,
              testIamPermissionsSettings,
              createBackupSettings,
              copyBackupSettings,
              getBackupSettings,
              updateBackupSettings,
              deleteBackupSettings,
              listBackupsSettings,
              restoreDatabaseSettings,
              listDatabaseOperationsSettings,
              listBackupOperationsSettings,
              listDatabaseRolesSettings,
              addSplitPointsSettings,
              createBackupScheduleSettings,
              getBackupScheduleSettings,
              updateBackupScheduleSettings,
              deleteBackupScheduleSettings,
              listBackupSchedulesSettings,
              internalUpdateGraphOperationSettings);
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
          .listDatabasesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createDatabaseSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_2_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_2_params"));

      builder
          .getDatabaseSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updateDatabaseSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updateDatabaseDdlSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .dropDatabaseSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getDatabaseDdlSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .setIamPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_3_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_3_params"));

      builder
          .getIamPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

      builder
          .testIamPermissionsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_3_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_3_params"));

      builder
          .createBackupSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_2_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_2_params"));

      builder
          .copyBackupSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_2_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_2_params"));

      builder
          .getBackupSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updateBackupSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deleteBackupSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listBackupsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .restoreDatabaseSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_2_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_2_params"));

      builder
          .listDatabaseOperationsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listBackupOperationsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listDatabaseRolesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .addSplitPointsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createBackupScheduleSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getBackupScheduleSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updateBackupScheduleSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deleteBackupScheduleSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listBackupSchedulesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .internalUpdateGraphOperationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

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
                      .setInitialRetryDelayDuration(Duration.ofMillis(1000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(86400000L))
                      .build()));

      builder
          .updateDatabaseOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateDatabaseRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
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
          .updateDatabaseDdlOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateDatabaseDdlRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(
                  UpdateDatabaseDdlMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(1000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(86400000L))
                      .build()));

      builder
          .createBackupOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateBackupRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_2_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_2_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Backup.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(CreateBackupMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(20000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(172800000L))
                      .build()));

      builder
          .copyBackupOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings.<CopyBackupRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_2_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_2_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Backup.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(CopyBackupMetadata.class))
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
                      .setInitialRetryDelayDuration(Duration.ofMillis(20000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(86400000L))
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

    /** Returns the builder for the settings used for calls to listDatabases. */
    public PagedCallSettings.Builder<
            ListDatabasesRequest, ListDatabasesResponse, ListDatabasesPagedResponse>
        listDatabasesSettings() {
      return listDatabasesSettings;
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

    /** Returns the builder for the settings used for calls to updateDatabase. */
    public UnaryCallSettings.Builder<UpdateDatabaseRequest, Operation> updateDatabaseSettings() {
      return updateDatabaseSettings;
    }

    /** Returns the builder for the settings used for calls to updateDatabase. */
    public OperationCallSettings.Builder<UpdateDatabaseRequest, Database, UpdateDatabaseMetadata>
        updateDatabaseOperationSettings() {
      return updateDatabaseOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateDatabaseDdl. */
    public UnaryCallSettings.Builder<UpdateDatabaseDdlRequest, Operation>
        updateDatabaseDdlSettings() {
      return updateDatabaseDdlSettings;
    }

    /** Returns the builder for the settings used for calls to updateDatabaseDdl. */
    public OperationCallSettings.Builder<UpdateDatabaseDdlRequest, Empty, UpdateDatabaseDdlMetadata>
        updateDatabaseDdlOperationSettings() {
      return updateDatabaseDdlOperationSettings;
    }

    /** Returns the builder for the settings used for calls to dropDatabase. */
    public UnaryCallSettings.Builder<DropDatabaseRequest, Empty> dropDatabaseSettings() {
      return dropDatabaseSettings;
    }

    /** Returns the builder for the settings used for calls to getDatabaseDdl. */
    public UnaryCallSettings.Builder<GetDatabaseDdlRequest, GetDatabaseDdlResponse>
        getDatabaseDdlSettings() {
      return getDatabaseDdlSettings;
    }

    /** Returns the builder for the settings used for calls to setIamPolicy. */
    public UnaryCallSettings.Builder<SetIamPolicyRequest, Policy> setIamPolicySettings() {
      return setIamPolicySettings;
    }

    /** Returns the builder for the settings used for calls to getIamPolicy. */
    public UnaryCallSettings.Builder<GetIamPolicyRequest, Policy> getIamPolicySettings() {
      return getIamPolicySettings;
    }

    /** Returns the builder for the settings used for calls to testIamPermissions. */
    public UnaryCallSettings.Builder<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsSettings() {
      return testIamPermissionsSettings;
    }

    /** Returns the builder for the settings used for calls to createBackup. */
    public UnaryCallSettings.Builder<CreateBackupRequest, Operation> createBackupSettings() {
      return createBackupSettings;
    }

    /** Returns the builder for the settings used for calls to createBackup. */
    public OperationCallSettings.Builder<CreateBackupRequest, Backup, CreateBackupMetadata>
        createBackupOperationSettings() {
      return createBackupOperationSettings;
    }

    /** Returns the builder for the settings used for calls to copyBackup. */
    public UnaryCallSettings.Builder<CopyBackupRequest, Operation> copyBackupSettings() {
      return copyBackupSettings;
    }

    /** Returns the builder for the settings used for calls to copyBackup. */
    public OperationCallSettings.Builder<CopyBackupRequest, Backup, CopyBackupMetadata>
        copyBackupOperationSettings() {
      return copyBackupOperationSettings;
    }

    /** Returns the builder for the settings used for calls to getBackup. */
    public UnaryCallSettings.Builder<GetBackupRequest, Backup> getBackupSettings() {
      return getBackupSettings;
    }

    /** Returns the builder for the settings used for calls to updateBackup. */
    public UnaryCallSettings.Builder<UpdateBackupRequest, Backup> updateBackupSettings() {
      return updateBackupSettings;
    }

    /** Returns the builder for the settings used for calls to deleteBackup. */
    public UnaryCallSettings.Builder<DeleteBackupRequest, Empty> deleteBackupSettings() {
      return deleteBackupSettings;
    }

    /** Returns the builder for the settings used for calls to listBackups. */
    public PagedCallSettings.Builder<
            ListBackupsRequest, ListBackupsResponse, ListBackupsPagedResponse>
        listBackupsSettings() {
      return listBackupsSettings;
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

    /** Returns the builder for the settings used for calls to listDatabaseOperations. */
    public PagedCallSettings.Builder<
            ListDatabaseOperationsRequest,
            ListDatabaseOperationsResponse,
            ListDatabaseOperationsPagedResponse>
        listDatabaseOperationsSettings() {
      return listDatabaseOperationsSettings;
    }

    /** Returns the builder for the settings used for calls to listBackupOperations. */
    public PagedCallSettings.Builder<
            ListBackupOperationsRequest,
            ListBackupOperationsResponse,
            ListBackupOperationsPagedResponse>
        listBackupOperationsSettings() {
      return listBackupOperationsSettings;
    }

    /** Returns the builder for the settings used for calls to listDatabaseRoles. */
    public PagedCallSettings.Builder<
            ListDatabaseRolesRequest, ListDatabaseRolesResponse, ListDatabaseRolesPagedResponse>
        listDatabaseRolesSettings() {
      return listDatabaseRolesSettings;
    }

    /** Returns the builder for the settings used for calls to addSplitPoints. */
    public UnaryCallSettings.Builder<AddSplitPointsRequest, AddSplitPointsResponse>
        addSplitPointsSettings() {
      return addSplitPointsSettings;
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

    /** Returns the builder for the settings used for calls to listBackupSchedules. */
    public PagedCallSettings.Builder<
            ListBackupSchedulesRequest,
            ListBackupSchedulesResponse,
            ListBackupSchedulesPagedResponse>
        listBackupSchedulesSettings() {
      return listBackupSchedulesSettings;
    }

    /** Returns the builder for the settings used for calls to internalUpdateGraph. */
    public UnaryCallSettings.Builder<
            InternalUpdateGraphOperationRequest, InternalUpdateGraphOperationResponse>
        internalUpdateGraphOperationSettings() {
      return internalUpdateGraphOperationSettings;
    }

    @Override
    public DatabaseAdminStubSettings build() throws IOException {
      return new DatabaseAdminStubSettings(this);
    }
  }
}
