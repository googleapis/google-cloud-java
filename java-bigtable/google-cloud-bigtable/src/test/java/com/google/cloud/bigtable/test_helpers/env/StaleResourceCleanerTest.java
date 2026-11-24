/*
 * Copyright 2026 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.bigtable.test_helpers.env;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.withSettings;

import com.google.api.core.ApiFutures;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.grpc.GrpcStatusCode;
import com.google.api.gax.longrunning.OperationFuture;
import com.google.api.gax.longrunning.OperationFutures;
import com.google.api.gax.longrunning.OperationSnapshot;
import com.google.api.gax.rpc.InternalException;
import com.google.api.gax.rpc.NotFoundException;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.api.gax.rpc.testing.FakeOperationSnapshot;
import com.google.bigtable.admin.v2.AppProfile;
import com.google.bigtable.admin.v2.AuthorizedView;
import com.google.bigtable.admin.v2.Backup;
import com.google.bigtable.admin.v2.ChangeStreamConfig;
import com.google.bigtable.admin.v2.Cluster;
import com.google.bigtable.admin.v2.DeleteAppProfileRequest;
import com.google.bigtable.admin.v2.DeleteAuthorizedViewRequest;
import com.google.bigtable.admin.v2.DeleteBackupRequest;
import com.google.bigtable.admin.v2.DeleteClusterRequest;
import com.google.bigtable.admin.v2.DeleteInstanceRequest;
import com.google.bigtable.admin.v2.DeleteLogicalViewRequest;
import com.google.bigtable.admin.v2.DeleteMaterializedViewRequest;
import com.google.bigtable.admin.v2.DeleteTableRequest;
import com.google.bigtable.admin.v2.GetTableRequest;
import com.google.bigtable.admin.v2.Instance;
import com.google.bigtable.admin.v2.ListAppProfilesRequest;
import com.google.bigtable.admin.v2.ListAuthorizedViewsRequest;
import com.google.bigtable.admin.v2.ListBackupsRequest;
import com.google.bigtable.admin.v2.ListClustersRequest;
import com.google.bigtable.admin.v2.ListClustersResponse;
import com.google.bigtable.admin.v2.ListInstancesRequest;
import com.google.bigtable.admin.v2.ListInstancesResponse;
import com.google.bigtable.admin.v2.ListLogicalViewsRequest;
import com.google.bigtable.admin.v2.ListMaterializedViewsRequest;
import com.google.bigtable.admin.v2.ListTablesRequest;
import com.google.bigtable.admin.v2.LogicalView;
import com.google.bigtable.admin.v2.MaterializedView;
import com.google.bigtable.admin.v2.Table;
import com.google.bigtable.admin.v2.Table.View;
import com.google.bigtable.admin.v2.UpdateAuthorizedViewMetadata;
import com.google.bigtable.admin.v2.UpdateAuthorizedViewRequest;
import com.google.bigtable.admin.v2.UpdateLogicalViewMetadata;
import com.google.bigtable.admin.v2.UpdateLogicalViewRequest;
import com.google.bigtable.admin.v2.UpdateMaterializedViewMetadata;
import com.google.bigtable.admin.v2.UpdateMaterializedViewRequest;
import com.google.bigtable.admin.v2.UpdateTableMetadata;
import com.google.bigtable.admin.v2.UpdateTableRequest;
import com.google.cloud.bigtable.admin.v2.BaseBigtableInstanceAdminClient.ListAppProfilesPage;
import com.google.cloud.bigtable.admin.v2.BaseBigtableInstanceAdminClient.ListAppProfilesPagedResponse;
import com.google.cloud.bigtable.admin.v2.BaseBigtableInstanceAdminClient.ListLogicalViewsPage;
import com.google.cloud.bigtable.admin.v2.BaseBigtableInstanceAdminClient.ListLogicalViewsPagedResponse;
import com.google.cloud.bigtable.admin.v2.BaseBigtableInstanceAdminClient.ListMaterializedViewsPage;
import com.google.cloud.bigtable.admin.v2.BaseBigtableInstanceAdminClient.ListMaterializedViewsPagedResponse;
import com.google.cloud.bigtable.admin.v2.BaseBigtableTableAdminClient.ListAuthorizedViewsPage;
import com.google.cloud.bigtable.admin.v2.BaseBigtableTableAdminClient.ListAuthorizedViewsPagedResponse;
import com.google.cloud.bigtable.admin.v2.BaseBigtableTableAdminClient.ListBackupsPage;
import com.google.cloud.bigtable.admin.v2.BaseBigtableTableAdminClient.ListBackupsPagedResponse;
import com.google.cloud.bigtable.admin.v2.BaseBigtableTableAdminClient.ListTablesPage;
import com.google.cloud.bigtable.admin.v2.BaseBigtableTableAdminClient.ListTablesPagedResponse;
import com.google.cloud.bigtable.admin.v2.BigtableInstanceAdminClient;
import com.google.cloud.bigtable.admin.v2.BigtableTableAdminClient;
import com.google.cloud.bigtable.admin.v2.internal.NameUtil;
import com.google.cloud.bigtable.admin.v2.stub.BigtableInstanceAdminStub;
import com.google.cloud.bigtable.admin.v2.stub.EnhancedBigtableTableAdminStub;
import com.google.cloud.bigtable.admin.v2.stub.GrpcBigtableTableAdminStub;
import com.google.common.collect.ImmutableList;
import com.google.protobuf.Duration;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import io.grpc.Status.Code;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;

class StaleResourceCleanerTest {

  private static final String PROJECT_ID = "test-project";
  private static final String SHARED_INSTANCE_ID = "google-cloud-bigtable";
  private static final String STALE_PREFIX = "temp-0850000000";
  private static final String STALE_ID_PREFIX = "temp-0800000001-";
  private static final String FRESH_ID_PREFIX = "temp-0899999999-";

  private BigtableInstanceAdminStub mockInstanceStub;
  private BigtableInstanceAdminClient instanceAdmin;
  private Map<String, EnhancedBigtableTableAdminStub> tableStubsByInstance;

  private UnaryCallable<ListMaterializedViewsRequest, ListMaterializedViewsPagedResponse>
      mockListMaterializedViewsCallable;
  private OperationCallable<
          UpdateMaterializedViewRequest, MaterializedView, UpdateMaterializedViewMetadata>
      mockUpdateMaterializedViewCallable;
  private UnaryCallable<DeleteMaterializedViewRequest, Empty> mockDeleteMaterializedViewCallable;

  private UnaryCallable<ListLogicalViewsRequest, ListLogicalViewsPagedResponse>
      mockListLogicalViewsCallable;
  private OperationCallable<UpdateLogicalViewRequest, LogicalView, UpdateLogicalViewMetadata>
      mockUpdateLogicalViewCallable;
  private UnaryCallable<DeleteLogicalViewRequest, Empty> mockDeleteLogicalViewCallable;

  private UnaryCallable<ListAppProfilesRequest, ListAppProfilesPagedResponse>
      mockListAppProfilesCallable;
  private UnaryCallable<DeleteAppProfileRequest, Empty> mockDeleteAppProfileCallable;

  private UnaryCallable<ListClustersRequest, ListClustersResponse> mockListClustersCallable;
  private UnaryCallable<DeleteClusterRequest, Empty> mockDeleteClusterCallable;

  private UnaryCallable<ListInstancesRequest, ListInstancesResponse> mockListInstancesCallable;
  private UnaryCallable<DeleteInstanceRequest, Empty> mockDeleteInstanceCallable;

  @SuppressWarnings("unchecked")
  @BeforeEach
  void setUp() {
    mockInstanceStub = mock(BigtableInstanceAdminStub.class, withSettings().withoutAnnotations());
    instanceAdmin = BigtableInstanceAdminClient.create(PROJECT_ID, mockInstanceStub);
    tableStubsByInstance = new HashMap<>();

    mockListMaterializedViewsCallable =
        mock(UnaryCallable.class, withSettings().withoutAnnotations());
    mockUpdateMaterializedViewCallable =
        mock(OperationCallable.class, withSettings().withoutAnnotations());
    mockDeleteMaterializedViewCallable =
        mock(UnaryCallable.class, withSettings().withoutAnnotations());

    mockListLogicalViewsCallable = mock(UnaryCallable.class, withSettings().withoutAnnotations());
    mockUpdateLogicalViewCallable =
        mock(OperationCallable.class, withSettings().withoutAnnotations());
    mockDeleteLogicalViewCallable = mock(UnaryCallable.class, withSettings().withoutAnnotations());

    mockListAppProfilesCallable = mock(UnaryCallable.class, withSettings().withoutAnnotations());
    mockDeleteAppProfileCallable = mock(UnaryCallable.class, withSettings().withoutAnnotations());

    mockListClustersCallable = mock(UnaryCallable.class, withSettings().withoutAnnotations());
    mockDeleteClusterCallable = mock(UnaryCallable.class, withSettings().withoutAnnotations());

    mockListInstancesCallable = mock(UnaryCallable.class, withSettings().withoutAnnotations());
    mockDeleteInstanceCallable = mock(UnaryCallable.class, withSettings().withoutAnnotations());

    when(mockInstanceStub.listMaterializedViewsPagedCallable())
        .thenReturn(mockListMaterializedViewsCallable);
    when(mockInstanceStub.updateMaterializedViewOperationCallable())
        .thenReturn(mockUpdateMaterializedViewCallable);
    when(mockInstanceStub.deleteMaterializedViewCallable())
        .thenReturn(mockDeleteMaterializedViewCallable);

    when(mockInstanceStub.listLogicalViewsPagedCallable()).thenReturn(mockListLogicalViewsCallable);
    when(mockInstanceStub.updateLogicalViewOperationCallable())
        .thenReturn(mockUpdateLogicalViewCallable);
    when(mockInstanceStub.deleteLogicalViewCallable()).thenReturn(mockDeleteLogicalViewCallable);

    when(mockInstanceStub.listAppProfilesPagedCallable()).thenReturn(mockListAppProfilesCallable);
    when(mockInstanceStub.deleteAppProfileCallable()).thenReturn(mockDeleteAppProfileCallable);

    when(mockInstanceStub.listClustersCallable()).thenReturn(mockListClustersCallable);
    when(mockInstanceStub.deleteClusterCallable()).thenReturn(mockDeleteClusterCallable);

    when(mockInstanceStub.listInstancesCallable()).thenReturn(mockListInstancesCallable);
    when(mockInstanceStub.deleteInstanceCallable()).thenReturn(mockDeleteInstanceCallable);

    when(mockDeleteMaterializedViewCallable.futureCall(any()))
        .thenReturn(ApiFutures.immediateFuture(Empty.getDefaultInstance()));
    when(mockDeleteLogicalViewCallable.futureCall(any()))
        .thenReturn(ApiFutures.immediateFuture(Empty.getDefaultInstance()));
    when(mockDeleteAppProfileCallable.futureCall(any()))
        .thenReturn(ApiFutures.immediateFuture(Empty.getDefaultInstance()));
    when(mockDeleteClusterCallable.futureCall(any()))
        .thenReturn(ApiFutures.immediateFuture(Empty.getDefaultInstance()));
    when(mockDeleteInstanceCallable.futureCall(any()))
        .thenReturn(ApiFutures.immediateFuture(Empty.getDefaultInstance()));
  }

  @Test
  @SuppressWarnings("unchecked")
  void testCleanUpSharedInstance_viewsTablesAndAuthorizedViews() throws Exception {
    EnhancedBigtableTableAdminStub tableStub = createTableStubForInstance(SHARED_INSTANCE_ID);

    String staleProtectedMv = STALE_ID_PREFIX + "mv-protected";
    String staleUnprotectedMv = STALE_ID_PREFIX + "mv-unprotected";
    String freshMv = FRESH_ID_PREFIX + "mv-fresh";
    String permMv = "permanent-mv";

    mockMaterializedViews(
        SHARED_INSTANCE_ID,
        ImmutableList.of(
            buildMaterializedView(SHARED_INSTANCE_ID, staleProtectedMv, true),
            buildMaterializedView(SHARED_INSTANCE_ID, staleUnprotectedMv, false),
            buildMaterializedView(SHARED_INSTANCE_ID, freshMv, true),
            buildMaterializedView(SHARED_INSTANCE_ID, permMv, false)));

    mockOperationFuture(
        mockUpdateMaterializedViewCallable,
        buildMaterializedView(SHARED_INSTANCE_ID, staleProtectedMv, false));

    String staleProtectedLv = STALE_ID_PREFIX + "lv-protected";
    String staleUnprotectedLv = STALE_ID_PREFIX + "lv-unprotected";
    String freshLv = FRESH_ID_PREFIX + "lv-fresh";

    mockLogicalViews(
        SHARED_INSTANCE_ID,
        ImmutableList.of(
            buildLogicalView(SHARED_INSTANCE_ID, staleProtectedLv, true),
            buildLogicalView(SHARED_INSTANCE_ID, staleUnprotectedLv, false),
            buildLogicalView(SHARED_INSTANCE_ID, freshLv, true)));

    mockOperationFuture(
        mockUpdateLogicalViewCallable,
        buildLogicalView(SHARED_INSTANCE_ID, staleProtectedLv, false));

    String staleTable = STALE_ID_PREFIX + "table";
    String freshTable = FRESH_ID_PREFIX + "table";
    String persistentTable = "integration-tests";

    mockListTables(
        tableStub, SHARED_INSTANCE_ID, ImmutableList.of(staleTable, freshTable, persistentTable));

    UnaryCallable<GetTableRequest, Table> mockGetTableCallable =
        mock(UnaryCallable.class, withSettings().withoutAnnotations());
    OperationCallable<UpdateTableRequest, Table, UpdateTableMetadata> mockUpdateTableCallable =
        mock(OperationCallable.class, withSettings().withoutAnnotations());
    UnaryCallable<DeleteTableRequest, Empty> mockDeleteTableCallable =
        mock(UnaryCallable.class, withSettings().withoutAnnotations());
    UnaryCallable<ListAuthorizedViewsRequest, ListAuthorizedViewsPagedResponse>
        mockListAuthorizedViewsCallable =
            mock(UnaryCallable.class, withSettings().withoutAnnotations());
    OperationCallable<UpdateAuthorizedViewRequest, AuthorizedView, UpdateAuthorizedViewMetadata>
        mockUpdateAuthorizedViewCallable =
            mock(OperationCallable.class, withSettings().withoutAnnotations());
    UnaryCallable<DeleteAuthorizedViewRequest, Empty> mockDeleteAuthorizedViewCallable =
        mock(UnaryCallable.class, withSettings().withoutAnnotations());

    when(tableStub.getTableCallable()).thenReturn(mockGetTableCallable);
    when(tableStub.updateTableOperationCallable()).thenReturn(mockUpdateTableCallable);
    when(tableStub.deleteTableCallable()).thenReturn(mockDeleteTableCallable);
    when(tableStub.listAuthorizedViewsPagedCallable()).thenReturn(mockListAuthorizedViewsCallable);
    when(tableStub.updateAuthorizedViewOperationCallable())
        .thenReturn(mockUpdateAuthorizedViewCallable);
    when(tableStub.deleteAuthorizedViewCallable()).thenReturn(mockDeleteAuthorizedViewCallable);

    Table staleTableProto =
        Table.newBuilder()
            .setName(NameUtil.formatTableName(PROJECT_ID, SHARED_INSTANCE_ID, staleTable))
            .setDeletionProtection(true)
            .setChangeStreamConfig(
                ChangeStreamConfig.newBuilder()
                    .setRetentionPeriod(Duration.newBuilder().setSeconds(86400)))
            .build();
    when(mockGetTableCallable.futureCall(
            GetTableRequest.newBuilder()
                .setName(NameUtil.formatTableName(PROJECT_ID, SHARED_INSTANCE_ID, staleTable))
                .setView(View.SCHEMA_VIEW)
                .build()))
        .thenReturn(ApiFutures.immediateFuture(staleTableProto));

    mockOperationFuture(
        mockUpdateTableCallable,
        Table.newBuilder()
            .setName(NameUtil.formatTableName(PROJECT_ID, SHARED_INSTANCE_ID, staleTable))
            .setDeletionProtection(false)
            .build());
    when(mockDeleteTableCallable.futureCall(any()))
        .thenReturn(ApiFutures.immediateFuture(Empty.getDefaultInstance()));

    String viewOnStaleTable = "av-on-stale-table";
    mockAuthorizedViews(
        mockListAuthorizedViewsCallable,
        SHARED_INSTANCE_ID,
        staleTable,
        ImmutableList.of(viewOnStaleTable));

    String staleAvOnPersistentTable = STALE_ID_PREFIX + "av-stale";
    String freshAvOnPersistentTable = FRESH_ID_PREFIX + "av-fresh";
    String permAvOnPersistentTable = "perm-av";
    mockAuthorizedViews(
        mockListAuthorizedViewsCallable,
        SHARED_INSTANCE_ID,
        persistentTable,
        ImmutableList.of(
            staleAvOnPersistentTable, freshAvOnPersistentTable, permAvOnPersistentTable));

    mockOperationFuture(
        mockUpdateAuthorizedViewCallable,
        AuthorizedView.newBuilder()
            .setName(
                NameUtil.formatAuthorizedViewName(
                    PROJECT_ID, SHARED_INSTANCE_ID, persistentTable, staleAvOnPersistentTable))
            .setSubsetView(AuthorizedView.SubsetView.getDefaultInstance())
            .setDeletionProtection(false)
            .build());
    when(mockDeleteAuthorizedViewCallable.futureCall(any()))
        .thenReturn(ApiFutures.immediateFuture(Empty.getDefaultInstance()));

    mockAppProfiles(SHARED_INSTANCE_ID, ImmutableList.of());
    mockClusters(SHARED_INSTANCE_ID, ImmutableList.of());
    mockInstances(ImmutableList.of());

    StaleResourceCleaner cleaner = createCleaner();
    cleaner.cleanUp(STALE_PREFIX);

    // MaterializedViews: stale ones deleted before table deletion; only protected one updated
    InOrder inOrder =
        inOrder(
            mockUpdateMaterializedViewCallable,
            mockDeleteMaterializedViewCallable,
            mockUpdateLogicalViewCallable,
            mockDeleteLogicalViewCallable,
            mockDeleteTableCallable);
    inOrder
        .verify(mockUpdateMaterializedViewCallable)
        .futureCall(
            UpdateMaterializedViewRequest.newBuilder()
                .setMaterializedView(
                    MaterializedView.newBuilder()
                        .setName(
                            NameUtil.formatMaterializedViewName(
                                PROJECT_ID, SHARED_INSTANCE_ID, staleProtectedMv))
                        .setDeletionProtection(false))
                .setUpdateMask(FieldMask.newBuilder().addPaths("deletion_protection"))
                .build());
    inOrder
        .verify(mockDeleteMaterializedViewCallable)
        .futureCall(
            DeleteMaterializedViewRequest.newBuilder()
                .setName(
                    NameUtil.formatMaterializedViewName(
                        PROJECT_ID, SHARED_INSTANCE_ID, staleProtectedMv))
                .build());
    inOrder
        .verify(mockDeleteMaterializedViewCallable)
        .futureCall(
            DeleteMaterializedViewRequest.newBuilder()
                .setName(
                    NameUtil.formatMaterializedViewName(
                        PROJECT_ID, SHARED_INSTANCE_ID, staleUnprotectedMv))
                .build());
    inOrder
        .verify(mockUpdateLogicalViewCallable)
        .futureCall(
            UpdateLogicalViewRequest.newBuilder()
                .setLogicalView(
                    LogicalView.newBuilder()
                        .setName(
                            NameUtil.formatLogicalViewName(
                                PROJECT_ID, SHARED_INSTANCE_ID, staleProtectedLv))
                        .setDeletionProtection(false))
                .setUpdateMask(FieldMask.newBuilder().addPaths("deletion_protection"))
                .build());
    inOrder
        .verify(mockDeleteLogicalViewCallable)
        .futureCall(
            DeleteLogicalViewRequest.newBuilder()
                .setName(
                    NameUtil.formatLogicalViewName(
                        PROJECT_ID, SHARED_INSTANCE_ID, staleProtectedLv))
                .build());
    inOrder
        .verify(mockDeleteLogicalViewCallable)
        .futureCall(
            DeleteLogicalViewRequest.newBuilder()
                .setName(
                    NameUtil.formatLogicalViewName(
                        PROJECT_ID, SHARED_INSTANCE_ID, staleUnprotectedLv))
                .build());
    inOrder
        .verify(mockDeleteTableCallable)
        .futureCall(
            DeleteTableRequest.newBuilder()
                .setName(NameUtil.formatTableName(PROJECT_ID, SHARED_INSTANCE_ID, staleTable))
                .build());

    verify(mockDeleteMaterializedViewCallable, never())
        .futureCall(
            DeleteMaterializedViewRequest.newBuilder()
                .setName(
                    NameUtil.formatMaterializedViewName(PROJECT_ID, SHARED_INSTANCE_ID, freshMv))
                .build());
    verify(mockDeleteMaterializedViewCallable, never())
        .futureCall(
            DeleteMaterializedViewRequest.newBuilder()
                .setName(
                    NameUtil.formatMaterializedViewName(PROJECT_ID, SHARED_INSTANCE_ID, permMv))
                .build());
    verify(mockDeleteLogicalViewCallable, never())
        .futureCall(
            DeleteLogicalViewRequest.newBuilder()
                .setName(NameUtil.formatLogicalViewName(PROJECT_ID, SHARED_INSTANCE_ID, freshLv))
                .build());

    // Persistent table is NOT deleted, but its stale AuthorizedView is unprotected and deleted
    verify(mockDeleteTableCallable, never())
        .futureCall(
            DeleteTableRequest.newBuilder()
                .setName(NameUtil.formatTableName(PROJECT_ID, SHARED_INSTANCE_ID, persistentTable))
                .build());
    verify(mockDeleteTableCallable, never())
        .futureCall(
            DeleteTableRequest.newBuilder()
                .setName(NameUtil.formatTableName(PROJECT_ID, SHARED_INSTANCE_ID, freshTable))
                .build());

    verify(mockDeleteAuthorizedViewCallable)
        .futureCall(
            DeleteAuthorizedViewRequest.newBuilder()
                .setName(
                    NameUtil.formatAuthorizedViewName(
                        PROJECT_ID, SHARED_INSTANCE_ID, persistentTable, staleAvOnPersistentTable))
                .build());
    verify(mockDeleteAuthorizedViewCallable, never())
        .futureCall(
            DeleteAuthorizedViewRequest.newBuilder()
                .setName(
                    NameUtil.formatAuthorizedViewName(
                        PROJECT_ID, SHARED_INSTANCE_ID, persistentTable, freshAvOnPersistentTable))
                .build());
    verify(mockDeleteAuthorizedViewCallable, never())
        .futureCall(
            DeleteAuthorizedViewRequest.newBuilder()
                .setName(
                    NameUtil.formatAuthorizedViewName(
                        PROJECT_ID, SHARED_INSTANCE_ID, persistentTable, permAvOnPersistentTable))
                .build());
  }

  @Test
  @SuppressWarnings("unchecked")
  void testCleanUpSharedInstance_appProfilesClustersAndBackups() throws Exception {
    EnhancedBigtableTableAdminStub tableStub = createTableStubForInstance(SHARED_INSTANCE_ID);

    mockMaterializedViews(SHARED_INSTANCE_ID, ImmutableList.of());
    mockLogicalViews(SHARED_INSTANCE_ID, ImmutableList.of());
    mockListTables(tableStub, SHARED_INSTANCE_ID, ImmutableList.of());

    String staleAp = STALE_ID_PREFIX + "ap";
    String freshAp = FRESH_ID_PREFIX + "ap";
    String defaultAp = "default";
    mockAppProfiles(SHARED_INSTANCE_ID, ImmutableList.of(staleAp, freshAp, defaultAp));

    String primaryCluster = "google-cloud-bigtable-c0";
    String staleCluster = STALE_ID_PREFIX + "cluster";
    String freshCluster = FRESH_ID_PREFIX + "cluster";
    mockClusters(SHARED_INSTANCE_ID, ImmutableList.of(primaryCluster, staleCluster, freshCluster));

    UnaryCallable<ListBackupsRequest, ListBackupsPagedResponse> mockListBackupsCallable =
        mock(UnaryCallable.class, withSettings().withoutAnnotations());
    UnaryCallable<DeleteBackupRequest, Empty> mockDeleteBackupCallable =
        mock(UnaryCallable.class, withSettings().withoutAnnotations());
    when(tableStub.listBackupsPagedCallable()).thenReturn(mockListBackupsCallable);
    when(tableStub.deleteBackupCallable()).thenReturn(mockDeleteBackupCallable);
    when(mockDeleteBackupCallable.futureCall(any()))
        .thenReturn(ApiFutures.immediateFuture(Empty.getDefaultInstance()));

    String staleBackupInPrimary = STALE_ID_PREFIX + "backup";
    String freshBackupInPrimary = FRESH_ID_PREFIX + "backup";
    String permBackupInPrimary = "perm-backup";
    mockBackups(
        mockListBackupsCallable,
        SHARED_INSTANCE_ID,
        primaryCluster,
        ImmutableList.of(staleBackupInPrimary, freshBackupInPrimary, permBackupInPrimary));

    String backupInStaleCluster = "any-backup-id";
    mockBackups(
        mockListBackupsCallable,
        SHARED_INSTANCE_ID,
        staleCluster,
        ImmutableList.of(backupInStaleCluster));

    mockInstances(ImmutableList.of());

    StaleResourceCleaner cleaner = createCleaner();
    cleaner.cleanUp(STALE_PREFIX);

    // AppProfiles: only staleAp deleted with ignoreWarnings=true
    verify(mockDeleteAppProfileCallable)
        .futureCall(
            DeleteAppProfileRequest.newBuilder()
                .setName(NameUtil.formatAppProfileName(PROJECT_ID, SHARED_INSTANCE_ID, staleAp))
                .setIgnoreWarnings(true)
                .build());
    verify(mockDeleteAppProfileCallable, never())
        .futureCall(
            DeleteAppProfileRequest.newBuilder()
                .setName(NameUtil.formatAppProfileName(PROJECT_ID, SHARED_INSTANCE_ID, freshAp))
                .setIgnoreWarnings(true)
                .build());

    // Primary cluster: not deleted, only stale backup in it is deleted
    verify(mockDeleteClusterCallable, never())
        .futureCall(
            DeleteClusterRequest.newBuilder()
                .setName(NameUtil.formatClusterName(PROJECT_ID, SHARED_INSTANCE_ID, primaryCluster))
                .build());
    verify(mockDeleteBackupCallable)
        .futureCall(
            DeleteBackupRequest.newBuilder()
                .setName(
                    NameUtil.formatBackupName(
                        PROJECT_ID, SHARED_INSTANCE_ID, primaryCluster, staleBackupInPrimary))
                .build());
    verify(mockDeleteBackupCallable, never())
        .futureCall(
            DeleteBackupRequest.newBuilder()
                .setName(
                    NameUtil.formatBackupName(
                        PROJECT_ID, SHARED_INSTANCE_ID, primaryCluster, freshBackupInPrimary))
                .build());
    verify(mockDeleteBackupCallable, never())
        .futureCall(
            DeleteBackupRequest.newBuilder()
                .setName(
                    NameUtil.formatBackupName(
                        PROJECT_ID, SHARED_INSTANCE_ID, primaryCluster, permBackupInPrimary))
                .build());

    // Stale cluster: all backups deleted, cluster deleted
    verify(mockDeleteBackupCallable)
        .futureCall(
            DeleteBackupRequest.newBuilder()
                .setName(
                    NameUtil.formatBackupName(
                        PROJECT_ID, SHARED_INSTANCE_ID, staleCluster, backupInStaleCluster))
                .build());
    verify(mockDeleteClusterCallable)
        .futureCall(
            DeleteClusterRequest.newBuilder()
                .setName(NameUtil.formatClusterName(PROJECT_ID, SHARED_INSTANCE_ID, staleCluster))
                .build());
  }

  @Test
  @SuppressWarnings("unchecked")
  void testCleanUpStaleInstances() throws Exception {
    String staleInstance = STALE_ID_PREFIX + "inst";
    String freshInstance = FRESH_ID_PREFIX + "inst";

    mockInstances(ImmutableList.of(SHARED_INSTANCE_ID, staleInstance, freshInstance));

    String mvOnStaleInst = "mv-1";
    String lvOnStaleInst = "lv-1";
    mockMaterializedViews(
        staleInstance, ImmutableList.of(buildMaterializedView(staleInstance, mvOnStaleInst, true)));
    mockLogicalViews(
        staleInstance, ImmutableList.of(buildLogicalView(staleInstance, lvOnStaleInst, true)));
    mockOperationFuture(
        mockUpdateMaterializedViewCallable,
        buildMaterializedView(staleInstance, mvOnStaleInst, false));
    mockOperationFuture(
        mockUpdateLogicalViewCallable, buildLogicalView(staleInstance, lvOnStaleInst, false));

    String cluster0 = "c0";
    String cluster1 = "c1";
    mockClusters(staleInstance, ImmutableList.of(cluster0, cluster1));

    EnhancedBigtableTableAdminStub staleInstTableStub = createTableStubForInstance(staleInstance);
    String tableOnStaleInst = "table-1";
    String avOnStaleInstTable = "av-1";
    mockListTables(staleInstTableStub, staleInstance, ImmutableList.of(tableOnStaleInst));

    UnaryCallable<GetTableRequest, Table> mockGetTableCallable =
        mock(UnaryCallable.class, withSettings().withoutAnnotations());
    OperationCallable<UpdateTableRequest, Table, UpdateTableMetadata> mockUpdateTableCallable =
        mock(OperationCallable.class, withSettings().withoutAnnotations());
    UnaryCallable<ListAuthorizedViewsRequest, ListAuthorizedViewsPagedResponse>
        mockListAuthorizedViewsCallable =
            mock(UnaryCallable.class, withSettings().withoutAnnotations());
    OperationCallable<UpdateAuthorizedViewRequest, AuthorizedView, UpdateAuthorizedViewMetadata>
        mockUpdateAuthorizedViewCallable =
            mock(OperationCallable.class, withSettings().withoutAnnotations());
    when(staleInstTableStub.getTableCallable()).thenReturn(mockGetTableCallable);
    when(staleInstTableStub.updateTableOperationCallable()).thenReturn(mockUpdateTableCallable);
    when(staleInstTableStub.listAuthorizedViewsPagedCallable())
        .thenReturn(mockListAuthorizedViewsCallable);
    when(staleInstTableStub.updateAuthorizedViewOperationCallable())
        .thenReturn(mockUpdateAuthorizedViewCallable);

    Table staleInstTableProto =
        Table.newBuilder()
            .setName(NameUtil.formatTableName(PROJECT_ID, staleInstance, tableOnStaleInst))
            .setDeletionProtection(true)
            .setChangeStreamConfig(
                ChangeStreamConfig.newBuilder()
                    .setRetentionPeriod(Duration.newBuilder().setSeconds(86400)))
            .build();
    when(mockGetTableCallable.futureCall(
            GetTableRequest.newBuilder()
                .setName(NameUtil.formatTableName(PROJECT_ID, staleInstance, tableOnStaleInst))
                .setView(View.SCHEMA_VIEW)
                .build()))
        .thenReturn(ApiFutures.immediateFuture(staleInstTableProto));
    mockOperationFuture(
        mockUpdateTableCallable,
        Table.newBuilder()
            .setName(NameUtil.formatTableName(PROJECT_ID, staleInstance, tableOnStaleInst))
            .setDeletionProtection(false)
            .build());
    mockAuthorizedViews(
        mockListAuthorizedViewsCallable,
        staleInstance,
        tableOnStaleInst,
        ImmutableList.of(avOnStaleInstTable));
    mockOperationFuture(
        mockUpdateAuthorizedViewCallable,
        AuthorizedView.newBuilder()
            .setName(
                NameUtil.formatAuthorizedViewName(
                    PROJECT_ID, staleInstance, tableOnStaleInst, avOnStaleInstTable))
            .setSubsetView(AuthorizedView.SubsetView.getDefaultInstance())
            .setDeletionProtection(false)
            .build());

    UnaryCallable<ListBackupsRequest, ListBackupsPagedResponse> mockListBackupsCallable =
        mock(UnaryCallable.class, withSettings().withoutAnnotations());
    UnaryCallable<DeleteBackupRequest, Empty> mockDeleteBackupCallable =
        mock(UnaryCallable.class, withSettings().withoutAnnotations());
    when(staleInstTableStub.listBackupsPagedCallable()).thenReturn(mockListBackupsCallable);
    when(staleInstTableStub.deleteBackupCallable()).thenReturn(mockDeleteBackupCallable);
    when(mockDeleteBackupCallable.futureCall(any()))
        .thenReturn(ApiFutures.immediateFuture(Empty.getDefaultInstance()));

    mockBackups(mockListBackupsCallable, staleInstance, cluster0, ImmutableList.of("b0"));
    mockBackups(mockListBackupsCallable, staleInstance, cluster1, ImmutableList.of("b1"));

    EnhancedBigtableTableAdminStub sharedTableStub = createTableStubForInstance(SHARED_INSTANCE_ID);
    mockMaterializedViews(SHARED_INSTANCE_ID, ImmutableList.of());
    mockLogicalViews(SHARED_INSTANCE_ID, ImmutableList.of());
    mockListTables(sharedTableStub, SHARED_INSTANCE_ID, ImmutableList.of());
    mockAppProfiles(SHARED_INSTANCE_ID, ImmutableList.of());
    mockClusters(SHARED_INSTANCE_ID, ImmutableList.of());

    StaleResourceCleaner cleaner = createCleaner();
    cleaner.cleanUp(STALE_PREFIX);

    verify(mockDeleteMaterializedViewCallable)
        .futureCall(
            DeleteMaterializedViewRequest.newBuilder()
                .setName(
                    NameUtil.formatMaterializedViewName(PROJECT_ID, staleInstance, mvOnStaleInst))
                .build());
    verify(mockDeleteLogicalViewCallable)
        .futureCall(
            DeleteLogicalViewRequest.newBuilder()
                .setName(NameUtil.formatLogicalViewName(PROJECT_ID, staleInstance, lvOnStaleInst))
                .build());

    // Tables inside stale instance are unprotected (including change streams and authorized views)
    // and backups in both clusters are deleted before deleteInstance; clusters are deleted by
    // deleteInstance rather than individual deleteCluster calls
    InOrder inOrder =
        inOrder(
            mockUpdateTableCallable,
            mockUpdateAuthorizedViewCallable,
            mockDeleteBackupCallable,
            mockDeleteInstanceCallable);
    inOrder
        .verify(mockUpdateTableCallable)
        .futureCall(
            UpdateTableRequest.newBuilder()
                .setTable(
                    Table.newBuilder()
                        .setName(
                            NameUtil.formatTableName(PROJECT_ID, staleInstance, tableOnStaleInst))
                        .setDeletionProtection(false))
                .setUpdateMask(
                    FieldMask.newBuilder()
                        .addPaths("deletion_protection")
                        .addPaths("change_stream_config"))
                .build());
    inOrder
        .verify(mockUpdateAuthorizedViewCallable)
        .futureCall(
            UpdateAuthorizedViewRequest.newBuilder()
                .setAuthorizedView(
                    AuthorizedView.newBuilder()
                        .setName(
                            NameUtil.formatAuthorizedViewName(
                                PROJECT_ID, staleInstance, tableOnStaleInst, avOnStaleInstTable))
                        .setDeletionProtection(false))
                .setUpdateMask(FieldMask.newBuilder().addPaths("deletion_protection"))
                .build());
    inOrder
        .verify(mockDeleteBackupCallable)
        .futureCall(
            DeleteBackupRequest.newBuilder()
                .setName(NameUtil.formatBackupName(PROJECT_ID, staleInstance, cluster0, "b0"))
                .build());
    inOrder
        .verify(mockDeleteBackupCallable)
        .futureCall(
            DeleteBackupRequest.newBuilder()
                .setName(NameUtil.formatBackupName(PROJECT_ID, staleInstance, cluster1, "b1"))
                .build());
    inOrder
        .verify(mockDeleteInstanceCallable)
        .futureCall(
            DeleteInstanceRequest.newBuilder()
                .setName(NameUtil.formatInstanceName(PROJECT_ID, staleInstance))
                .build());
    verify(mockDeleteClusterCallable, never()).futureCall(any());
    verify(mockDeleteInstanceCallable, never())
        .futureCall(
            DeleteInstanceRequest.newBuilder()
                .setName(NameUtil.formatInstanceName(PROJECT_ID, SHARED_INSTANCE_ID))
                .build());
    verify(mockDeleteInstanceCallable, never())
        .futureCall(
            DeleteInstanceRequest.newBuilder()
                .setName(NameUtil.formatInstanceName(PROJECT_ID, freshInstance))
                .build());
  }

  @Test
  @SuppressWarnings("unchecked")
  void testConcurrentNotFoundExceptionsAreIgnored() throws Exception {
    EnhancedBigtableTableAdminStub sharedTableStub = createTableStubForInstance(SHARED_INSTANCE_ID);
    mockMaterializedViews(SHARED_INSTANCE_ID, ImmutableList.of());
    mockLogicalViews(SHARED_INSTANCE_ID, ImmutableList.of());
    mockAppProfiles(SHARED_INSTANCE_ID, ImmutableList.of());
    mockClusters(SHARED_INSTANCE_ID, ImmutableList.of());

    String concurrentlyDeletedTable = "deleted-persistent-table";
    String survivingPersistentTable = "integration-tests";
    String staleAv = STALE_ID_PREFIX + "av";
    mockListTables(
        sharedTableStub,
        SHARED_INSTANCE_ID,
        ImmutableList.of(concurrentlyDeletedTable, survivingPersistentTable));

    UnaryCallable<ListAuthorizedViewsRequest, ListAuthorizedViewsPagedResponse>
        mockListAuthorizedViewsCallable =
            mock(UnaryCallable.class, withSettings().withoutAnnotations());
    OperationCallable<UpdateAuthorizedViewRequest, AuthorizedView, UpdateAuthorizedViewMetadata>
        mockUpdateAuthorizedViewCallable =
            mock(OperationCallable.class, withSettings().withoutAnnotations());
    UnaryCallable<DeleteAuthorizedViewRequest, Empty> mockDeleteAuthorizedViewCallable =
        mock(UnaryCallable.class, withSettings().withoutAnnotations());
    when(sharedTableStub.listAuthorizedViewsPagedCallable())
        .thenReturn(mockListAuthorizedViewsCallable);
    when(sharedTableStub.updateAuthorizedViewOperationCallable())
        .thenReturn(mockUpdateAuthorizedViewCallable);
    when(sharedTableStub.deleteAuthorizedViewCallable())
        .thenReturn(mockDeleteAuthorizedViewCallable);

    NotFoundException notFound =
        new NotFoundException(null, GrpcStatusCode.of(Code.NOT_FOUND), false);
    when(mockListAuthorizedViewsCallable.futureCall(
            ListAuthorizedViewsRequest.newBuilder()
                .setParent(
                    NameUtil.formatTableName(
                        PROJECT_ID, SHARED_INSTANCE_ID, concurrentlyDeletedTable))
                .build()))
        .thenReturn(ApiFutures.immediateFailedFuture(notFound));
    mockAuthorizedViews(
        mockListAuthorizedViewsCallable,
        SHARED_INSTANCE_ID,
        survivingPersistentTable,
        ImmutableList.of(staleAv));
    mockOperationFuture(
        mockUpdateAuthorizedViewCallable,
        AuthorizedView.newBuilder()
            .setName(
                NameUtil.formatAuthorizedViewName(
                    PROJECT_ID, SHARED_INSTANCE_ID, survivingPersistentTable, staleAv))
            .setSubsetView(AuthorizedView.SubsetView.getDefaultInstance())
            .setDeletionProtection(false)
            .build());
    when(mockDeleteAuthorizedViewCallable.futureCall(any()))
        .thenReturn(ApiFutures.immediateFuture(Empty.getDefaultInstance()));

    // Stale instances: first one throws NotFoundException in prepInstanceForDelete, second one
    // throws NotFoundException on listTables in deleteInstance, third one has cluster0 throw
    // NotFoundException in deleteAllBackups but continues to cluster1 and deletes
    String concurrentlyDeletedInst = STALE_ID_PREFIX + "deleted-inst";
    String deletedBeforeListTablesInst = STALE_ID_PREFIX + "deleted-before-list-tables-inst";
    String remainingStaleInst = STALE_ID_PREFIX + "remaining-inst";
    mockInstances(
        ImmutableList.of(concurrentlyDeletedInst, deletedBeforeListTablesInst, remainingStaleInst));

    when(mockListMaterializedViewsCallable.futureCall(
            ListMaterializedViewsRequest.newBuilder()
                .setParent(NameUtil.formatInstanceName(PROJECT_ID, concurrentlyDeletedInst))
                .build()))
        .thenReturn(ApiFutures.immediateFailedFuture(notFound));

    mockMaterializedViews(deletedBeforeListTablesInst, ImmutableList.of());
    mockLogicalViews(deletedBeforeListTablesInst, ImmutableList.of());
    EnhancedBigtableTableAdminStub deletedBeforeListTablesStub =
        createTableStubForInstance(deletedBeforeListTablesInst);
    UnaryCallable<ListTablesRequest, ListTablesPagedResponse> mockFailingListTablesCallable =
        mock(UnaryCallable.class, withSettings().withoutAnnotations());
    when(deletedBeforeListTablesStub.listTablesPagedCallable())
        .thenReturn(mockFailingListTablesCallable);
    when(mockFailingListTablesCallable.futureCall(
            ListTablesRequest.newBuilder()
                .setParent(NameUtil.formatInstanceName(PROJECT_ID, deletedBeforeListTablesInst))
                .build()))
        .thenReturn(ApiFutures.immediateFailedFuture(notFound));

    mockMaterializedViews(remainingStaleInst, ImmutableList.of());
    mockLogicalViews(remainingStaleInst, ImmutableList.of());
    mockClusters(remainingStaleInst, ImmutableList.of("c0", "c1"));

    EnhancedBigtableTableAdminStub remainingInstTableStub =
        createTableStubForInstance(remainingStaleInst);
    mockListTables(remainingInstTableStub, remainingStaleInst, ImmutableList.of());
    UnaryCallable<ListBackupsRequest, ListBackupsPagedResponse> mockListBackupsCallable =
        mock(UnaryCallable.class, withSettings().withoutAnnotations());
    UnaryCallable<DeleteBackupRequest, Empty> mockDeleteBackupCallable =
        mock(UnaryCallable.class, withSettings().withoutAnnotations());
    when(remainingInstTableStub.listBackupsPagedCallable()).thenReturn(mockListBackupsCallable);
    when(remainingInstTableStub.deleteBackupCallable()).thenReturn(mockDeleteBackupCallable);
    when(mockDeleteBackupCallable.futureCall(any()))
        .thenReturn(ApiFutures.immediateFuture(Empty.getDefaultInstance()));

    when(mockListBackupsCallable.futureCall(
            ListBackupsRequest.newBuilder()
                .setParent(NameUtil.formatClusterName(PROJECT_ID, remainingStaleInst, "c0"))
                .build()))
        .thenReturn(ApiFutures.immediateFailedFuture(notFound));
    mockBackups(mockListBackupsCallable, remainingStaleInst, "c1", ImmutableList.of("b1"));

    StaleResourceCleaner cleaner = createCleaner();
    cleaner.cleanUp(STALE_PREFIX);

    verify(mockDeleteAuthorizedViewCallable)
        .futureCall(
            DeleteAuthorizedViewRequest.newBuilder()
                .setName(
                    NameUtil.formatAuthorizedViewName(
                        PROJECT_ID, SHARED_INSTANCE_ID, survivingPersistentTable, staleAv))
                .build());
    verify(mockDeleteBackupCallable)
        .futureCall(
            DeleteBackupRequest.newBuilder()
                .setName(NameUtil.formatBackupName(PROJECT_ID, remainingStaleInst, "c1", "b1"))
                .build());
    verify(mockDeleteClusterCallable, never()).futureCall(any());
    verify(mockDeleteInstanceCallable, never())
        .futureCall(
            DeleteInstanceRequest.newBuilder()
                .setName(NameUtil.formatInstanceName(PROJECT_ID, deletedBeforeListTablesInst))
                .build());
    verify(mockDeleteInstanceCallable)
        .futureCall(
            DeleteInstanceRequest.newBuilder()
                .setName(NameUtil.formatInstanceName(PROJECT_ID, remainingStaleInst))
                .build());
  }

  @Test
  @SuppressWarnings("unchecked")
  void testNonNotFoundErrorsContinueCleanupAndThrowAtEnd() throws Exception {
    EnhancedBigtableTableAdminStub sharedTableStub = createTableStubForInstance(SHARED_INSTANCE_ID);
    InternalException internalError =
        new InternalException(null, GrpcStatusCode.of(Code.INTERNAL), false);

    // 1. Materialized views: first stale view throws InternalException on delete, second succeeds
    String failingMv = STALE_ID_PREFIX + "mv-fail";
    String succeedingMv = STALE_ID_PREFIX + "mv-ok";
    mockMaterializedViews(
        SHARED_INSTANCE_ID,
        ImmutableList.of(
            buildMaterializedView(SHARED_INSTANCE_ID, failingMv, false),
            buildMaterializedView(SHARED_INSTANCE_ID, succeedingMv, false)));
    when(mockDeleteMaterializedViewCallable.futureCall(
            DeleteMaterializedViewRequest.newBuilder()
                .setName(
                    NameUtil.formatMaterializedViewName(PROJECT_ID, SHARED_INSTANCE_ID, failingMv))
                .build()))
        .thenReturn(ApiFutures.immediateFailedFuture(internalError));

    mockLogicalViews(SHARED_INSTANCE_ID, ImmutableList.of());
    mockListTables(sharedTableStub, SHARED_INSTANCE_ID, ImmutableList.of());

    // 2. App profiles: first stale app profile throws InternalException on delete, second succeeds
    String failingAp = STALE_ID_PREFIX + "ap-fail";
    String succeedingAp = STALE_ID_PREFIX + "ap-ok";
    mockAppProfiles(SHARED_INSTANCE_ID, ImmutableList.of(failingAp, succeedingAp));
    when(mockDeleteAppProfileCallable.futureCall(
            DeleteAppProfileRequest.newBuilder()
                .setName(NameUtil.formatAppProfileName(PROJECT_ID, SHARED_INSTANCE_ID, failingAp))
                .setIgnoreWarnings(true)
                .build()))
        .thenReturn(ApiFutures.immediateFailedFuture(internalError));

    mockClusters(SHARED_INSTANCE_ID, ImmutableList.of());

    // 3. Stale instances: first stale instance fails to delete, second stale instance succeeds
    String failingInst = STALE_ID_PREFIX + "inst-fail";
    String succeedingInst = STALE_ID_PREFIX + "inst-ok";
    mockInstances(ImmutableList.of(failingInst, succeedingInst));

    mockMaterializedViews(failingInst, ImmutableList.of());
    mockLogicalViews(failingInst, ImmutableList.of());
    mockClusters(failingInst, ImmutableList.of());
    EnhancedBigtableTableAdminStub failingInstTableStub = createTableStubForInstance(failingInst);
    mockListTables(failingInstTableStub, failingInst, ImmutableList.of());
    when(mockDeleteInstanceCallable.futureCall(
            DeleteInstanceRequest.newBuilder()
                .setName(NameUtil.formatInstanceName(PROJECT_ID, failingInst))
                .build()))
        .thenReturn(ApiFutures.immediateFailedFuture(internalError));

    mockMaterializedViews(succeedingInst, ImmutableList.of());
    mockLogicalViews(succeedingInst, ImmutableList.of());
    mockClusters(succeedingInst, ImmutableList.of());
    EnhancedBigtableTableAdminStub succeedingInstTableStub =
        createTableStubForInstance(succeedingInst);
    mockListTables(succeedingInstTableStub, succeedingInst, ImmutableList.of());

    StaleResourceCleaner cleaner = createCleaner();
    RuntimeException thrown =
        assertThrows(RuntimeException.class, () -> cleaner.cleanUp(STALE_PREFIX));

    assertThat(thrown.getMessage()).contains("3 error(s)");
    assertThat(thrown.getCause()).isNotNull();
    assertThat(thrown.getSuppressed()).hasLength(2);

    // Subsequent resources in each phase were still cleaned up despite earlier failures
    verify(mockDeleteMaterializedViewCallable)
        .futureCall(
            DeleteMaterializedViewRequest.newBuilder()
                .setName(
                    NameUtil.formatMaterializedViewName(
                        PROJECT_ID, SHARED_INSTANCE_ID, succeedingMv))
                .build());
    verify(mockDeleteAppProfileCallable)
        .futureCall(
            DeleteAppProfileRequest.newBuilder()
                .setName(
                    NameUtil.formatAppProfileName(PROJECT_ID, SHARED_INSTANCE_ID, succeedingAp))
                .setIgnoreWarnings(true)
                .build());
    verify(mockDeleteInstanceCallable)
        .futureCall(
            DeleteInstanceRequest.newBuilder()
                .setName(NameUtil.formatInstanceName(PROJECT_ID, succeedingInst))
                .build());
  }

  private StaleResourceCleaner createCleaner() {
    return new StaleResourceCleaner(
        SHARED_INSTANCE_ID,
        instanceAdmin,
        instId ->
            BigtableTableAdminClient.create(PROJECT_ID, instId, tableStubsByInstance.get(instId)));
  }

  private EnhancedBigtableTableAdminStub createTableStubForInstance(String instanceId)
      throws Exception {
    EnhancedBigtableTableAdminStub stub =
        mock(EnhancedBigtableTableAdminStub.class, withSettings().withoutAnnotations());
    Field backgroundResourcesField =
        GrpcBigtableTableAdminStub.class.getDeclaredField("backgroundResources");
    backgroundResourcesField.setAccessible(true);
    backgroundResourcesField.set(
        stub, mock(BackgroundResource.class, withSettings().withoutAnnotations()));
    tableStubsByInstance.put(instanceId, stub);
    return stub;
  }

  private MaterializedView buildMaterializedView(
      String instanceId, String viewId, boolean deletionProtected) {
    return MaterializedView.newBuilder()
        .setName(NameUtil.formatMaterializedViewName(PROJECT_ID, instanceId, viewId))
        .setDeletionProtection(deletionProtected)
        .setQuery("SELECT 1 FROM table")
        .build();
  }

  private LogicalView buildLogicalView(
      String instanceId, String viewId, boolean deletionProtected) {
    return LogicalView.newBuilder()
        .setName(NameUtil.formatLogicalViewName(PROJECT_ID, instanceId, viewId))
        .setDeletionProtection(deletionProtected)
        .setQuery("SELECT 1 FROM table")
        .build();
  }

  private void mockMaterializedViews(String instanceId, List<MaterializedView> views) {
    ListMaterializedViewsPage page =
        mock(ListMaterializedViewsPage.class, withSettings().withoutAnnotations());
    when(page.getValues()).thenReturn(views);
    when(page.hasNextPage()).thenReturn(false);
    ListMaterializedViewsPagedResponse response =
        mock(ListMaterializedViewsPagedResponse.class, withSettings().withoutAnnotations());
    when(response.getPage()).thenReturn(page);
    when(mockListMaterializedViewsCallable.futureCall(
            ListMaterializedViewsRequest.newBuilder()
                .setParent(NameUtil.formatInstanceName(PROJECT_ID, instanceId))
                .build()))
        .thenReturn(ApiFutures.immediateFuture(response));
  }

  private void mockLogicalViews(String instanceId, List<LogicalView> views) {
    ListLogicalViewsPage page =
        mock(ListLogicalViewsPage.class, withSettings().withoutAnnotations());
    when(page.getValues()).thenReturn(views);
    when(page.hasNextPage()).thenReturn(false);
    ListLogicalViewsPagedResponse response =
        mock(ListLogicalViewsPagedResponse.class, withSettings().withoutAnnotations());
    when(response.getPage()).thenReturn(page);
    when(mockListLogicalViewsCallable.futureCall(
            ListLogicalViewsRequest.newBuilder()
                .setParent(NameUtil.formatInstanceName(PROJECT_ID, instanceId))
                .build()))
        .thenReturn(ApiFutures.immediateFuture(response));
  }

  @SuppressWarnings("unchecked")
  private void mockListTables(
      EnhancedBigtableTableAdminStub tableStub, String instanceId, List<String> tableIds) {
    UnaryCallable<ListTablesRequest, ListTablesPagedResponse> mockListTablesCallable =
        mock(UnaryCallable.class, withSettings().withoutAnnotations());
    when(tableStub.listTablesPagedCallable()).thenReturn(mockListTablesCallable);

    List<Table> tables = new ArrayList<>();
    for (String tableId : tableIds) {
      tables.add(
          Table.newBuilder()
              .setName(NameUtil.formatTableName(PROJECT_ID, instanceId, tableId))
              .build());
    }
    ListTablesPage page = mock(ListTablesPage.class, withSettings().withoutAnnotations());
    when(page.getValues()).thenReturn(tables);
    when(page.hasNextPage()).thenReturn(false);
    ListTablesPagedResponse response =
        mock(ListTablesPagedResponse.class, withSettings().withoutAnnotations());
    when(response.getPage()).thenReturn(page);
    when(mockListTablesCallable.futureCall(
            ListTablesRequest.newBuilder()
                .setParent(NameUtil.formatInstanceName(PROJECT_ID, instanceId))
                .build()))
        .thenReturn(ApiFutures.immediateFuture(response));
  }

  private void mockAuthorizedViews(
      UnaryCallable<ListAuthorizedViewsRequest, ListAuthorizedViewsPagedResponse> callable,
      String instanceId,
      String tableId,
      List<String> viewIds) {
    List<AuthorizedView> views = new ArrayList<>();
    for (String viewId : viewIds) {
      views.add(
          AuthorizedView.newBuilder()
              .setName(NameUtil.formatAuthorizedViewName(PROJECT_ID, instanceId, tableId, viewId))
              .build());
    }
    ListAuthorizedViewsPage page =
        mock(ListAuthorizedViewsPage.class, withSettings().withoutAnnotations());
    when(page.getValues()).thenReturn(views);
    when(page.hasNextPage()).thenReturn(false);
    ListAuthorizedViewsPagedResponse response =
        mock(ListAuthorizedViewsPagedResponse.class, withSettings().withoutAnnotations());
    when(response.getPage()).thenReturn(page);
    when(callable.futureCall(
            ListAuthorizedViewsRequest.newBuilder()
                .setParent(NameUtil.formatTableName(PROJECT_ID, instanceId, tableId))
                .build()))
        .thenReturn(ApiFutures.immediateFuture(response));
  }

  private void mockAppProfiles(String instanceId, List<String> appProfileIds) {
    List<AppProfile> profiles = new ArrayList<>();
    for (String id : appProfileIds) {
      profiles.add(
          AppProfile.newBuilder()
              .setName(NameUtil.formatAppProfileName(PROJECT_ID, instanceId, id))
              .setMultiClusterRoutingUseAny(
                  AppProfile.MultiClusterRoutingUseAny.getDefaultInstance())
              .build());
    }
    ListAppProfilesPage page = mock(ListAppProfilesPage.class, withSettings().withoutAnnotations());
    when(page.getValues()).thenReturn(profiles);
    when(page.hasNextPage()).thenReturn(false);
    ListAppProfilesPagedResponse response =
        mock(ListAppProfilesPagedResponse.class, withSettings().withoutAnnotations());
    when(response.getPage()).thenReturn(page);
    when(mockListAppProfilesCallable.futureCall(
            ListAppProfilesRequest.newBuilder()
                .setParent(NameUtil.formatInstanceName(PROJECT_ID, instanceId))
                .build()))
        .thenReturn(ApiFutures.immediateFuture(response));
  }

  private void mockClusters(String instanceId, List<String> clusterIds) {
    List<Cluster> clusters = new ArrayList<>();
    for (String clusterId : clusterIds) {
      clusters.add(
          Cluster.newBuilder()
              .setName(NameUtil.formatClusterName(PROJECT_ID, instanceId, clusterId))
              .setLocation(NameUtil.formatLocationName(PROJECT_ID, "us-central1-b"))
              .build());
    }
    when(mockListClustersCallable.futureCall(
            ListClustersRequest.newBuilder()
                .setParent(NameUtil.formatInstanceName(PROJECT_ID, instanceId))
                .build()))
        .thenReturn(
            ApiFutures.immediateFuture(
                ListClustersResponse.newBuilder().addAllClusters(clusters).build()));
  }

  private void mockBackups(
      UnaryCallable<ListBackupsRequest, ListBackupsPagedResponse> callable,
      String instanceId,
      String clusterId,
      List<String> backupIds) {
    List<Backup> backups = new ArrayList<>();
    for (String backupId : backupIds) {
      backups.add(
          Backup.newBuilder()
              .setName(NameUtil.formatBackupName(PROJECT_ID, instanceId, clusterId, backupId))
              .build());
    }
    ListBackupsPage page = mock(ListBackupsPage.class, withSettings().withoutAnnotations());
    when(page.getValues()).thenReturn(backups);
    when(page.hasNextPage()).thenReturn(false);
    ListBackupsPagedResponse response =
        mock(ListBackupsPagedResponse.class, withSettings().withoutAnnotations());
    when(response.getPage()).thenReturn(page);
    when(callable.futureCall(
            ListBackupsRequest.newBuilder()
                .setParent(NameUtil.formatClusterName(PROJECT_ID, instanceId, clusterId))
                .build()))
        .thenReturn(ApiFutures.immediateFuture(response));
  }

  private void mockInstances(List<String> instanceIds) {
    List<Instance> instances = new ArrayList<>();
    for (String instanceId : instanceIds) {
      instances.add(
          Instance.newBuilder()
              .setName(NameUtil.formatInstanceName(PROJECT_ID, instanceId))
              .setDisplayName(instanceId)
              .build());
    }
    when(mockListInstancesCallable.futureCall(
            ListInstancesRequest.newBuilder()
                .setParent(NameUtil.formatProjectName(PROJECT_ID))
                .build()))
        .thenReturn(
            ApiFutures.immediateFuture(
                ListInstancesResponse.newBuilder().addAllInstances(instances).build()));
  }

  private <ReqT, RespT, MetaT> void mockOperationFuture(
      OperationCallable<ReqT, RespT, MetaT> callable, RespT response) {
    OperationSnapshot snapshot =
        FakeOperationSnapshot.newBuilder()
            .setDone(true)
            .setErrorCode(GrpcStatusCode.of(Code.OK))
            .setName("fake-op")
            .setResponse(response)
            .build();
    OperationFuture<RespT, MetaT> future = OperationFutures.immediateOperationFuture(snapshot);
    when(callable.futureCall(any())).thenReturn(future);
  }
}
