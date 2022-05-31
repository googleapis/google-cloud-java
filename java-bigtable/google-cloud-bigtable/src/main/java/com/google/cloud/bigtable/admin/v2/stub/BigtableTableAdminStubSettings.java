/*
 * Copyright 2022 Google LLC
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

package com.google.cloud.bigtable.admin.v2.stub;

import static com.google.cloud.bigtable.admin.v2.BaseBigtableTableAdminClient.ListBackupsPagedResponse;
import static com.google.cloud.bigtable.admin.v2.BaseBigtableTableAdminClient.ListSnapshotsPagedResponse;
import static com.google.cloud.bigtable.admin.v2.BaseBigtableTableAdminClient.ListTablesPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GaxProperties;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.GrpcTransportChannel;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.grpc.ProtoOperationTransformers;
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
import com.google.bigtable.admin.v2.Backup;
import com.google.bigtable.admin.v2.CheckConsistencyRequest;
import com.google.bigtable.admin.v2.CheckConsistencyResponse;
import com.google.bigtable.admin.v2.CreateBackupMetadata;
import com.google.bigtable.admin.v2.CreateBackupRequest;
import com.google.bigtable.admin.v2.CreateTableFromSnapshotMetadata;
import com.google.bigtable.admin.v2.CreateTableFromSnapshotRequest;
import com.google.bigtable.admin.v2.CreateTableRequest;
import com.google.bigtable.admin.v2.DeleteBackupRequest;
import com.google.bigtable.admin.v2.DeleteSnapshotRequest;
import com.google.bigtable.admin.v2.DeleteTableRequest;
import com.google.bigtable.admin.v2.DropRowRangeRequest;
import com.google.bigtable.admin.v2.GenerateConsistencyTokenRequest;
import com.google.bigtable.admin.v2.GenerateConsistencyTokenResponse;
import com.google.bigtable.admin.v2.GetBackupRequest;
import com.google.bigtable.admin.v2.GetSnapshotRequest;
import com.google.bigtable.admin.v2.GetTableRequest;
import com.google.bigtable.admin.v2.ListBackupsRequest;
import com.google.bigtable.admin.v2.ListBackupsResponse;
import com.google.bigtable.admin.v2.ListSnapshotsRequest;
import com.google.bigtable.admin.v2.ListSnapshotsResponse;
import com.google.bigtable.admin.v2.ListTablesRequest;
import com.google.bigtable.admin.v2.ListTablesResponse;
import com.google.bigtable.admin.v2.ModifyColumnFamiliesRequest;
import com.google.bigtable.admin.v2.RestoreTableMetadata;
import com.google.bigtable.admin.v2.RestoreTableRequest;
import com.google.bigtable.admin.v2.Snapshot;
import com.google.bigtable.admin.v2.SnapshotTableMetadata;
import com.google.bigtable.admin.v2.SnapshotTableRequest;
import com.google.bigtable.admin.v2.Table;
import com.google.bigtable.admin.v2.UpdateBackupRequest;
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
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;
import org.threeten.bp.Duration;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link BigtableTableAdminStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (bigtableadmin.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of createTable to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated for illustrative purposes only.
 * // It may require modifications to work in your environment.
 * BigtableTableAdminStubSettings.Builder baseBigtableTableAdminSettingsBuilder =
 *     BigtableTableAdminStubSettings.newBuilder();
 * baseBigtableTableAdminSettingsBuilder
 *     .createTableSettings()
 *     .setRetrySettings(
 *         baseBigtableTableAdminSettingsBuilder
 *             .createTableSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * BigtableTableAdminStubSettings baseBigtableTableAdminSettings =
 *     baseBigtableTableAdminSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class BigtableTableAdminStubSettings extends StubSettings<BigtableTableAdminStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder()
          .add("https://www.googleapis.com/auth/bigtable.admin")
          .add("https://www.googleapis.com/auth/bigtable.admin.table")
          .add("https://www.googleapis.com/auth/cloud-bigtable.admin")
          .add("https://www.googleapis.com/auth/cloud-bigtable.admin.table")
          .add("https://www.googleapis.com/auth/cloud-platform")
          .add("https://www.googleapis.com/auth/cloud-platform.read-only")
          .build();

  private final UnaryCallSettings<CreateTableRequest, Table> createTableSettings;
  private final UnaryCallSettings<CreateTableFromSnapshotRequest, Operation>
      createTableFromSnapshotSettings;
  private final OperationCallSettings<
          CreateTableFromSnapshotRequest, Table, CreateTableFromSnapshotMetadata>
      createTableFromSnapshotOperationSettings;
  private final PagedCallSettings<ListTablesRequest, ListTablesResponse, ListTablesPagedResponse>
      listTablesSettings;
  private final UnaryCallSettings<GetTableRequest, Table> getTableSettings;
  private final UnaryCallSettings<DeleteTableRequest, Empty> deleteTableSettings;
  private final UnaryCallSettings<ModifyColumnFamiliesRequest, Table> modifyColumnFamiliesSettings;
  private final UnaryCallSettings<DropRowRangeRequest, Empty> dropRowRangeSettings;
  private final UnaryCallSettings<GenerateConsistencyTokenRequest, GenerateConsistencyTokenResponse>
      generateConsistencyTokenSettings;
  private final UnaryCallSettings<CheckConsistencyRequest, CheckConsistencyResponse>
      checkConsistencySettings;
  private final UnaryCallSettings<SnapshotTableRequest, Operation> snapshotTableSettings;
  private final OperationCallSettings<SnapshotTableRequest, Snapshot, SnapshotTableMetadata>
      snapshotTableOperationSettings;
  private final UnaryCallSettings<GetSnapshotRequest, Snapshot> getSnapshotSettings;
  private final PagedCallSettings<
          ListSnapshotsRequest, ListSnapshotsResponse, ListSnapshotsPagedResponse>
      listSnapshotsSettings;
  private final UnaryCallSettings<DeleteSnapshotRequest, Empty> deleteSnapshotSettings;
  private final UnaryCallSettings<CreateBackupRequest, Operation> createBackupSettings;
  private final OperationCallSettings<CreateBackupRequest, Backup, CreateBackupMetadata>
      createBackupOperationSettings;
  private final UnaryCallSettings<GetBackupRequest, Backup> getBackupSettings;
  private final UnaryCallSettings<UpdateBackupRequest, Backup> updateBackupSettings;
  private final UnaryCallSettings<DeleteBackupRequest, Empty> deleteBackupSettings;
  private final PagedCallSettings<ListBackupsRequest, ListBackupsResponse, ListBackupsPagedResponse>
      listBackupsSettings;
  private final UnaryCallSettings<RestoreTableRequest, Operation> restoreTableSettings;
  private final OperationCallSettings<RestoreTableRequest, Table, RestoreTableMetadata>
      restoreTableOperationSettings;
  private final UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings;
  private final UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings;
  private final UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings;

  private static final PagedListDescriptor<ListTablesRequest, ListTablesResponse, Table>
      LIST_TABLES_PAGE_STR_DESC =
          new PagedListDescriptor<ListTablesRequest, ListTablesResponse, Table>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListTablesRequest injectToken(ListTablesRequest payload, String token) {
              return ListTablesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListTablesRequest injectPageSize(ListTablesRequest payload, int pageSize) {
              return ListTablesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListTablesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListTablesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Table> extractResources(ListTablesResponse payload) {
              return payload.getTablesList() == null
                  ? ImmutableList.<Table>of()
                  : payload.getTablesList();
            }
          };

  private static final PagedListDescriptor<ListSnapshotsRequest, ListSnapshotsResponse, Snapshot>
      LIST_SNAPSHOTS_PAGE_STR_DESC =
          new PagedListDescriptor<ListSnapshotsRequest, ListSnapshotsResponse, Snapshot>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListSnapshotsRequest injectToken(ListSnapshotsRequest payload, String token) {
              return ListSnapshotsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListSnapshotsRequest injectPageSize(ListSnapshotsRequest payload, int pageSize) {
              return ListSnapshotsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListSnapshotsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListSnapshotsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Snapshot> extractResources(ListSnapshotsResponse payload) {
              return payload.getSnapshotsList() == null
                  ? ImmutableList.<Snapshot>of()
                  : payload.getSnapshotsList();
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
              return payload.getBackupsList() == null
                  ? ImmutableList.<Backup>of()
                  : payload.getBackupsList();
            }
          };

  private static final PagedListResponseFactory<
          ListTablesRequest, ListTablesResponse, ListTablesPagedResponse>
      LIST_TABLES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListTablesRequest, ListTablesResponse, ListTablesPagedResponse>() {
            @Override
            public ApiFuture<ListTablesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListTablesRequest, ListTablesResponse> callable,
                ListTablesRequest request,
                ApiCallContext context,
                ApiFuture<ListTablesResponse> futureResponse) {
              PageContext<ListTablesRequest, ListTablesResponse, Table> pageContext =
                  PageContext.create(callable, LIST_TABLES_PAGE_STR_DESC, request, context);
              return ListTablesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListSnapshotsRequest, ListSnapshotsResponse, ListSnapshotsPagedResponse>
      LIST_SNAPSHOTS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListSnapshotsRequest, ListSnapshotsResponse, ListSnapshotsPagedResponse>() {
            @Override
            public ApiFuture<ListSnapshotsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListSnapshotsRequest, ListSnapshotsResponse> callable,
                ListSnapshotsRequest request,
                ApiCallContext context,
                ApiFuture<ListSnapshotsResponse> futureResponse) {
              PageContext<ListSnapshotsRequest, ListSnapshotsResponse, Snapshot> pageContext =
                  PageContext.create(callable, LIST_SNAPSHOTS_PAGE_STR_DESC, request, context);
              return ListSnapshotsPagedResponse.createAsync(pageContext, futureResponse);
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

  /** Returns the object with the settings used for calls to createTable. */
  public UnaryCallSettings<CreateTableRequest, Table> createTableSettings() {
    return createTableSettings;
  }

  /** Returns the object with the settings used for calls to createTableFromSnapshot. */
  public UnaryCallSettings<CreateTableFromSnapshotRequest, Operation>
      createTableFromSnapshotSettings() {
    return createTableFromSnapshotSettings;
  }

  /** Returns the object with the settings used for calls to createTableFromSnapshot. */
  public OperationCallSettings<
          CreateTableFromSnapshotRequest, Table, CreateTableFromSnapshotMetadata>
      createTableFromSnapshotOperationSettings() {
    return createTableFromSnapshotOperationSettings;
  }

  /** Returns the object with the settings used for calls to listTables. */
  public PagedCallSettings<ListTablesRequest, ListTablesResponse, ListTablesPagedResponse>
      listTablesSettings() {
    return listTablesSettings;
  }

  /** Returns the object with the settings used for calls to getTable. */
  public UnaryCallSettings<GetTableRequest, Table> getTableSettings() {
    return getTableSettings;
  }

  /** Returns the object with the settings used for calls to deleteTable. */
  public UnaryCallSettings<DeleteTableRequest, Empty> deleteTableSettings() {
    return deleteTableSettings;
  }

  /** Returns the object with the settings used for calls to modifyColumnFamilies. */
  public UnaryCallSettings<ModifyColumnFamiliesRequest, Table> modifyColumnFamiliesSettings() {
    return modifyColumnFamiliesSettings;
  }

  /** Returns the object with the settings used for calls to dropRowRange. */
  public UnaryCallSettings<DropRowRangeRequest, Empty> dropRowRangeSettings() {
    return dropRowRangeSettings;
  }

  /** Returns the object with the settings used for calls to generateConsistencyToken. */
  public UnaryCallSettings<GenerateConsistencyTokenRequest, GenerateConsistencyTokenResponse>
      generateConsistencyTokenSettings() {
    return generateConsistencyTokenSettings;
  }

  /** Returns the object with the settings used for calls to checkConsistency. */
  public UnaryCallSettings<CheckConsistencyRequest, CheckConsistencyResponse>
      checkConsistencySettings() {
    return checkConsistencySettings;
  }

  /** Returns the object with the settings used for calls to snapshotTable. */
  public UnaryCallSettings<SnapshotTableRequest, Operation> snapshotTableSettings() {
    return snapshotTableSettings;
  }

  /** Returns the object with the settings used for calls to snapshotTable. */
  public OperationCallSettings<SnapshotTableRequest, Snapshot, SnapshotTableMetadata>
      snapshotTableOperationSettings() {
    return snapshotTableOperationSettings;
  }

  /** Returns the object with the settings used for calls to getSnapshot. */
  public UnaryCallSettings<GetSnapshotRequest, Snapshot> getSnapshotSettings() {
    return getSnapshotSettings;
  }

  /** Returns the object with the settings used for calls to listSnapshots. */
  public PagedCallSettings<ListSnapshotsRequest, ListSnapshotsResponse, ListSnapshotsPagedResponse>
      listSnapshotsSettings() {
    return listSnapshotsSettings;
  }

  /** Returns the object with the settings used for calls to deleteSnapshot. */
  public UnaryCallSettings<DeleteSnapshotRequest, Empty> deleteSnapshotSettings() {
    return deleteSnapshotSettings;
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

  /** Returns the object with the settings used for calls to restoreTable. */
  public UnaryCallSettings<RestoreTableRequest, Operation> restoreTableSettings() {
    return restoreTableSettings;
  }

  /** Returns the object with the settings used for calls to restoreTable. */
  public OperationCallSettings<RestoreTableRequest, Table, RestoreTableMetadata>
      restoreTableOperationSettings() {
    return restoreTableOperationSettings;
  }

  /** Returns the object with the settings used for calls to getIamPolicy. */
  public UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings() {
    return getIamPolicySettings;
  }

  /** Returns the object with the settings used for calls to setIamPolicy. */
  public UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings() {
    return setIamPolicySettings;
  }

  /** Returns the object with the settings used for calls to testIamPermissions. */
  public UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings() {
    return testIamPermissionsSettings;
  }

  public BigtableTableAdminStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcBigtableTableAdminStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return "bigtableadmin.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "bigtableadmin.mtls.googleapis.com:443";
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

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return InstantiatingGrpcChannelProvider.newBuilder()
        .setMaxInboundMessageSize(Integer.MAX_VALUE);
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return defaultGrpcTransportProviderBuilder().build();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(BigtableTableAdminStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  /** Returns a new builder for this class. */
  public static Builder newBuilder() {
    return Builder.createDefault();
  }

  /** Returns a new builder for this class. */
  public static Builder newBuilder(ClientContext clientContext) {
    return new Builder(clientContext);
  }

  /** Returns a builder containing all the values of this settings class. */
  public Builder toBuilder() {
    return new Builder(this);
  }

  protected BigtableTableAdminStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    createTableSettings = settingsBuilder.createTableSettings().build();
    createTableFromSnapshotSettings = settingsBuilder.createTableFromSnapshotSettings().build();
    createTableFromSnapshotOperationSettings =
        settingsBuilder.createTableFromSnapshotOperationSettings().build();
    listTablesSettings = settingsBuilder.listTablesSettings().build();
    getTableSettings = settingsBuilder.getTableSettings().build();
    deleteTableSettings = settingsBuilder.deleteTableSettings().build();
    modifyColumnFamiliesSettings = settingsBuilder.modifyColumnFamiliesSettings().build();
    dropRowRangeSettings = settingsBuilder.dropRowRangeSettings().build();
    generateConsistencyTokenSettings = settingsBuilder.generateConsistencyTokenSettings().build();
    checkConsistencySettings = settingsBuilder.checkConsistencySettings().build();
    snapshotTableSettings = settingsBuilder.snapshotTableSettings().build();
    snapshotTableOperationSettings = settingsBuilder.snapshotTableOperationSettings().build();
    getSnapshotSettings = settingsBuilder.getSnapshotSettings().build();
    listSnapshotsSettings = settingsBuilder.listSnapshotsSettings().build();
    deleteSnapshotSettings = settingsBuilder.deleteSnapshotSettings().build();
    createBackupSettings = settingsBuilder.createBackupSettings().build();
    createBackupOperationSettings = settingsBuilder.createBackupOperationSettings().build();
    getBackupSettings = settingsBuilder.getBackupSettings().build();
    updateBackupSettings = settingsBuilder.updateBackupSettings().build();
    deleteBackupSettings = settingsBuilder.deleteBackupSettings().build();
    listBackupsSettings = settingsBuilder.listBackupsSettings().build();
    restoreTableSettings = settingsBuilder.restoreTableSettings().build();
    restoreTableOperationSettings = settingsBuilder.restoreTableOperationSettings().build();
    getIamPolicySettings = settingsBuilder.getIamPolicySettings().build();
    setIamPolicySettings = settingsBuilder.setIamPolicySettings().build();
    testIamPermissionsSettings = settingsBuilder.testIamPermissionsSettings().build();
  }

  /** Builder for BigtableTableAdminStubSettings. */
  public static class Builder
      extends StubSettings.Builder<BigtableTableAdminStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<CreateTableRequest, Table> createTableSettings;
    private final UnaryCallSettings.Builder<CreateTableFromSnapshotRequest, Operation>
        createTableFromSnapshotSettings;
    private final OperationCallSettings.Builder<
            CreateTableFromSnapshotRequest, Table, CreateTableFromSnapshotMetadata>
        createTableFromSnapshotOperationSettings;
    private final PagedCallSettings.Builder<
            ListTablesRequest, ListTablesResponse, ListTablesPagedResponse>
        listTablesSettings;
    private final UnaryCallSettings.Builder<GetTableRequest, Table> getTableSettings;
    private final UnaryCallSettings.Builder<DeleteTableRequest, Empty> deleteTableSettings;
    private final UnaryCallSettings.Builder<ModifyColumnFamiliesRequest, Table>
        modifyColumnFamiliesSettings;
    private final UnaryCallSettings.Builder<DropRowRangeRequest, Empty> dropRowRangeSettings;
    private final UnaryCallSettings.Builder<
            GenerateConsistencyTokenRequest, GenerateConsistencyTokenResponse>
        generateConsistencyTokenSettings;
    private final UnaryCallSettings.Builder<CheckConsistencyRequest, CheckConsistencyResponse>
        checkConsistencySettings;
    private final UnaryCallSettings.Builder<SnapshotTableRequest, Operation> snapshotTableSettings;
    private final OperationCallSettings.Builder<
            SnapshotTableRequest, Snapshot, SnapshotTableMetadata>
        snapshotTableOperationSettings;
    private final UnaryCallSettings.Builder<GetSnapshotRequest, Snapshot> getSnapshotSettings;
    private final PagedCallSettings.Builder<
            ListSnapshotsRequest, ListSnapshotsResponse, ListSnapshotsPagedResponse>
        listSnapshotsSettings;
    private final UnaryCallSettings.Builder<DeleteSnapshotRequest, Empty> deleteSnapshotSettings;
    private final UnaryCallSettings.Builder<CreateBackupRequest, Operation> createBackupSettings;
    private final OperationCallSettings.Builder<CreateBackupRequest, Backup, CreateBackupMetadata>
        createBackupOperationSettings;
    private final UnaryCallSettings.Builder<GetBackupRequest, Backup> getBackupSettings;
    private final UnaryCallSettings.Builder<UpdateBackupRequest, Backup> updateBackupSettings;
    private final UnaryCallSettings.Builder<DeleteBackupRequest, Empty> deleteBackupSettings;
    private final PagedCallSettings.Builder<
            ListBackupsRequest, ListBackupsResponse, ListBackupsPagedResponse>
        listBackupsSettings;
    private final UnaryCallSettings.Builder<RestoreTableRequest, Operation> restoreTableSettings;
    private final OperationCallSettings.Builder<RestoreTableRequest, Table, RestoreTableMetadata>
        restoreTableOperationSettings;
    private final UnaryCallSettings.Builder<GetIamPolicyRequest, Policy> getIamPolicySettings;
    private final UnaryCallSettings.Builder<SetIamPolicyRequest, Policy> setIamPolicySettings;
    private final UnaryCallSettings.Builder<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put(
          "no_retry_0_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      definitions.put("no_retry_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      definitions.put(
          "retry_policy_2_codes",
          ImmutableSet.copyOf(
              Lists.<StatusCode.Code>newArrayList(
                  StatusCode.Code.UNAVAILABLE, StatusCode.Code.DEADLINE_EXCEEDED)));
      definitions.put(
          "no_retry_1_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      definitions.put(
          "no_retry_4_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      definitions.put(
          "retry_policy_3_codes",
          ImmutableSet.copyOf(
              Lists.<StatusCode.Code>newArrayList(
                  StatusCode.Code.UNAVAILABLE, StatusCode.Code.DEADLINE_EXCEEDED)));
      RETRYABLE_CODE_DEFINITIONS = definitions.build();
    }

    private static final ImmutableMap<String, RetrySettings> RETRY_PARAM_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, RetrySettings> definitions = ImmutableMap.builder();
      RetrySettings settings = null;
      settings =
          RetrySettings.newBuilder()
              .setInitialRpcTimeout(Duration.ofMillis(300000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(300000L))
              .setTotalTimeout(Duration.ofMillis(300000L))
              .build();
      definitions.put("no_retry_0_params", settings);
      settings = RetrySettings.newBuilder().setRpcTimeoutMultiplier(1.0).build();
      definitions.put("no_retry_params", settings);
      settings =
          RetrySettings.newBuilder()
              .setInitialRetryDelay(Duration.ofMillis(1000L))
              .setRetryDelayMultiplier(2.0)
              .setMaxRetryDelay(Duration.ofMillis(60000L))
              .setInitialRpcTimeout(Duration.ofMillis(60000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(60000L))
              .setTotalTimeout(Duration.ofMillis(60000L))
              .build();
      definitions.put("retry_policy_2_params", settings);
      settings =
          RetrySettings.newBuilder()
              .setInitialRpcTimeout(Duration.ofMillis(60000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(60000L))
              .setTotalTimeout(Duration.ofMillis(60000L))
              .build();
      definitions.put("no_retry_1_params", settings);
      settings =
          RetrySettings.newBuilder()
              .setInitialRpcTimeout(Duration.ofMillis(3600000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(3600000L))
              .setTotalTimeout(Duration.ofMillis(3600000L))
              .build();
      definitions.put("no_retry_4_params", settings);
      settings =
          RetrySettings.newBuilder()
              .setInitialRetryDelay(Duration.ofMillis(1000L))
              .setRetryDelayMultiplier(2.0)
              .setMaxRetryDelay(Duration.ofMillis(60000L))
              .setInitialRpcTimeout(Duration.ofMillis(60000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(60000L))
              .setTotalTimeout(Duration.ofMillis(60000L))
              .build();
      definitions.put("retry_policy_3_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      createTableSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createTableFromSnapshotSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createTableFromSnapshotOperationSettings = OperationCallSettings.newBuilder();
      listTablesSettings = PagedCallSettings.newBuilder(LIST_TABLES_PAGE_STR_FACT);
      getTableSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteTableSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      modifyColumnFamiliesSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      dropRowRangeSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      generateConsistencyTokenSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      checkConsistencySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      snapshotTableSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      snapshotTableOperationSettings = OperationCallSettings.newBuilder();
      getSnapshotSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listSnapshotsSettings = PagedCallSettings.newBuilder(LIST_SNAPSHOTS_PAGE_STR_FACT);
      deleteSnapshotSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createBackupSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createBackupOperationSettings = OperationCallSettings.newBuilder();
      getBackupSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateBackupSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteBackupSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listBackupsSettings = PagedCallSettings.newBuilder(LIST_BACKUPS_PAGE_STR_FACT);
      restoreTableSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      restoreTableOperationSettings = OperationCallSettings.newBuilder();
      getIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      setIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      testIamPermissionsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createTableSettings,
              createTableFromSnapshotSettings,
              listTablesSettings,
              getTableSettings,
              deleteTableSettings,
              modifyColumnFamiliesSettings,
              dropRowRangeSettings,
              generateConsistencyTokenSettings,
              checkConsistencySettings,
              snapshotTableSettings,
              getSnapshotSettings,
              listSnapshotsSettings,
              deleteSnapshotSettings,
              createBackupSettings,
              getBackupSettings,
              updateBackupSettings,
              deleteBackupSettings,
              listBackupsSettings,
              restoreTableSettings,
              getIamPolicySettings,
              setIamPolicySettings,
              testIamPermissionsSettings);
      initDefaults(this);
    }

    protected Builder(BigtableTableAdminStubSettings settings) {
      super(settings);

      createTableSettings = settings.createTableSettings.toBuilder();
      createTableFromSnapshotSettings = settings.createTableFromSnapshotSettings.toBuilder();
      createTableFromSnapshotOperationSettings =
          settings.createTableFromSnapshotOperationSettings.toBuilder();
      listTablesSettings = settings.listTablesSettings.toBuilder();
      getTableSettings = settings.getTableSettings.toBuilder();
      deleteTableSettings = settings.deleteTableSettings.toBuilder();
      modifyColumnFamiliesSettings = settings.modifyColumnFamiliesSettings.toBuilder();
      dropRowRangeSettings = settings.dropRowRangeSettings.toBuilder();
      generateConsistencyTokenSettings = settings.generateConsistencyTokenSettings.toBuilder();
      checkConsistencySettings = settings.checkConsistencySettings.toBuilder();
      snapshotTableSettings = settings.snapshotTableSettings.toBuilder();
      snapshotTableOperationSettings = settings.snapshotTableOperationSettings.toBuilder();
      getSnapshotSettings = settings.getSnapshotSettings.toBuilder();
      listSnapshotsSettings = settings.listSnapshotsSettings.toBuilder();
      deleteSnapshotSettings = settings.deleteSnapshotSettings.toBuilder();
      createBackupSettings = settings.createBackupSettings.toBuilder();
      createBackupOperationSettings = settings.createBackupOperationSettings.toBuilder();
      getBackupSettings = settings.getBackupSettings.toBuilder();
      updateBackupSettings = settings.updateBackupSettings.toBuilder();
      deleteBackupSettings = settings.deleteBackupSettings.toBuilder();
      listBackupsSettings = settings.listBackupsSettings.toBuilder();
      restoreTableSettings = settings.restoreTableSettings.toBuilder();
      restoreTableOperationSettings = settings.restoreTableOperationSettings.toBuilder();
      getIamPolicySettings = settings.getIamPolicySettings.toBuilder();
      setIamPolicySettings = settings.setIamPolicySettings.toBuilder();
      testIamPermissionsSettings = settings.testIamPermissionsSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createTableSettings,
              createTableFromSnapshotSettings,
              listTablesSettings,
              getTableSettings,
              deleteTableSettings,
              modifyColumnFamiliesSettings,
              dropRowRangeSettings,
              generateConsistencyTokenSettings,
              checkConsistencySettings,
              snapshotTableSettings,
              getSnapshotSettings,
              listSnapshotsSettings,
              deleteSnapshotSettings,
              createBackupSettings,
              getBackupSettings,
              updateBackupSettings,
              deleteBackupSettings,
              listBackupsSettings,
              restoreTableSettings,
              getIamPolicySettings,
              setIamPolicySettings,
              testIamPermissionsSettings);
    }

    private static Builder createDefault() {
      Builder builder = new Builder(((ClientContext) null));

      builder.setTransportChannelProvider(defaultTransportChannelProvider());
      builder.setCredentialsProvider(defaultCredentialsProviderBuilder().build());
      builder.setInternalHeaderProvider(defaultApiClientHeaderProviderBuilder().build());
      builder.setEndpoint(getDefaultEndpoint());
      builder.setMtlsEndpoint(getDefaultMtlsEndpoint());
      builder.setSwitchToMtlsEndpointAllowed(true);

      return initDefaults(builder);
    }

    private static Builder initDefaults(Builder builder) {
      builder
          .createTableSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .createTableFromSnapshotSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listTablesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_2_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_2_params"));

      builder
          .getTableSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_2_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_2_params"));

      builder
          .deleteTableSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .modifyColumnFamiliesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .dropRowRangeSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_4_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_4_params"));

      builder
          .generateConsistencyTokenSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_3_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_3_params"));

      builder
          .checkConsistencySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_3_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_3_params"));

      builder
          .snapshotTableSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getSnapshotSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_2_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_2_params"));

      builder
          .listSnapshotsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_3_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_3_params"));

      builder
          .deleteSnapshotSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .createBackupSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .getBackupSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_2_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_2_params"));

      builder
          .updateBackupSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .deleteBackupSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .listBackupsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_2_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_2_params"));

      builder
          .restoreTableSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .getIamPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_3_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_3_params"));

      builder
          .setIamPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .testIamPermissionsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_3_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_3_params"));

      builder
          .createTableFromSnapshotOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateTableFromSnapshotRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Table.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(
                  CreateTableFromSnapshotMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(60000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(3600000L))
                      .build()));

      builder
          .snapshotTableOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<SnapshotTableRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Snapshot.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(SnapshotTableMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(500L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(5000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(600000L))
                      .build()));

      builder
          .createBackupOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateBackupRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Backup.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(CreateBackupMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(500L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(5000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(600000L))
                      .build()));

      builder
          .restoreTableOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<RestoreTableRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Table.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(RestoreTableMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(500L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(5000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(600000L))
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

    /** Returns the builder for the settings used for calls to createTable. */
    public UnaryCallSettings.Builder<CreateTableRequest, Table> createTableSettings() {
      return createTableSettings;
    }

    /** Returns the builder for the settings used for calls to createTableFromSnapshot. */
    public UnaryCallSettings.Builder<CreateTableFromSnapshotRequest, Operation>
        createTableFromSnapshotSettings() {
      return createTableFromSnapshotSettings;
    }

    /** Returns the builder for the settings used for calls to createTableFromSnapshot. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            CreateTableFromSnapshotRequest, Table, CreateTableFromSnapshotMetadata>
        createTableFromSnapshotOperationSettings() {
      return createTableFromSnapshotOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listTables. */
    public PagedCallSettings.Builder<ListTablesRequest, ListTablesResponse, ListTablesPagedResponse>
        listTablesSettings() {
      return listTablesSettings;
    }

    /** Returns the builder for the settings used for calls to getTable. */
    public UnaryCallSettings.Builder<GetTableRequest, Table> getTableSettings() {
      return getTableSettings;
    }

    /** Returns the builder for the settings used for calls to deleteTable. */
    public UnaryCallSettings.Builder<DeleteTableRequest, Empty> deleteTableSettings() {
      return deleteTableSettings;
    }

    /** Returns the builder for the settings used for calls to modifyColumnFamilies. */
    public UnaryCallSettings.Builder<ModifyColumnFamiliesRequest, Table>
        modifyColumnFamiliesSettings() {
      return modifyColumnFamiliesSettings;
    }

    /** Returns the builder for the settings used for calls to dropRowRange. */
    public UnaryCallSettings.Builder<DropRowRangeRequest, Empty> dropRowRangeSettings() {
      return dropRowRangeSettings;
    }

    /** Returns the builder for the settings used for calls to generateConsistencyToken. */
    public UnaryCallSettings.Builder<
            GenerateConsistencyTokenRequest, GenerateConsistencyTokenResponse>
        generateConsistencyTokenSettings() {
      return generateConsistencyTokenSettings;
    }

    /** Returns the builder for the settings used for calls to checkConsistency. */
    public UnaryCallSettings.Builder<CheckConsistencyRequest, CheckConsistencyResponse>
        checkConsistencySettings() {
      return checkConsistencySettings;
    }

    /** Returns the builder for the settings used for calls to snapshotTable. */
    public UnaryCallSettings.Builder<SnapshotTableRequest, Operation> snapshotTableSettings() {
      return snapshotTableSettings;
    }

    /** Returns the builder for the settings used for calls to snapshotTable. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<SnapshotTableRequest, Snapshot, SnapshotTableMetadata>
        snapshotTableOperationSettings() {
      return snapshotTableOperationSettings;
    }

    /** Returns the builder for the settings used for calls to getSnapshot. */
    public UnaryCallSettings.Builder<GetSnapshotRequest, Snapshot> getSnapshotSettings() {
      return getSnapshotSettings;
    }

    /** Returns the builder for the settings used for calls to listSnapshots. */
    public PagedCallSettings.Builder<
            ListSnapshotsRequest, ListSnapshotsResponse, ListSnapshotsPagedResponse>
        listSnapshotsSettings() {
      return listSnapshotsSettings;
    }

    /** Returns the builder for the settings used for calls to deleteSnapshot. */
    public UnaryCallSettings.Builder<DeleteSnapshotRequest, Empty> deleteSnapshotSettings() {
      return deleteSnapshotSettings;
    }

    /** Returns the builder for the settings used for calls to createBackup. */
    public UnaryCallSettings.Builder<CreateBackupRequest, Operation> createBackupSettings() {
      return createBackupSettings;
    }

    /** Returns the builder for the settings used for calls to createBackup. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<CreateBackupRequest, Backup, CreateBackupMetadata>
        createBackupOperationSettings() {
      return createBackupOperationSettings;
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

    /** Returns the builder for the settings used for calls to restoreTable. */
    public UnaryCallSettings.Builder<RestoreTableRequest, Operation> restoreTableSettings() {
      return restoreTableSettings;
    }

    /** Returns the builder for the settings used for calls to restoreTable. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<RestoreTableRequest, Table, RestoreTableMetadata>
        restoreTableOperationSettings() {
      return restoreTableOperationSettings;
    }

    /** Returns the builder for the settings used for calls to getIamPolicy. */
    public UnaryCallSettings.Builder<GetIamPolicyRequest, Policy> getIamPolicySettings() {
      return getIamPolicySettings;
    }

    /** Returns the builder for the settings used for calls to setIamPolicy. */
    public UnaryCallSettings.Builder<SetIamPolicyRequest, Policy> setIamPolicySettings() {
      return setIamPolicySettings;
    }

    /** Returns the builder for the settings used for calls to testIamPermissions. */
    public UnaryCallSettings.Builder<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsSettings() {
      return testIamPermissionsSettings;
    }

    @Override
    public BigtableTableAdminStubSettings build() throws IOException {
      return new BigtableTableAdminStubSettings(this);
    }
  }
}
