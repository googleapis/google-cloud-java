/*
 * Copyright 2018 Google LLC
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
package com.google.cloud.bigtable.admin.v2;

import static com.google.common.truth.Truth.assertThat;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.grpc.GrpcStatusCode;
import com.google.api.gax.longrunning.OperationFuture;
import com.google.api.gax.longrunning.OperationFutures;
import com.google.api.gax.longrunning.OperationSnapshot;
import com.google.api.gax.rpc.NotFoundException;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.api.gax.rpc.testing.FakeOperationSnapshot;
import com.google.bigtable.admin.v2.AuthorizedViewName;
import com.google.bigtable.admin.v2.Backup.State;
import com.google.bigtable.admin.v2.BackupInfo;
import com.google.bigtable.admin.v2.ChangeStreamConfig;
import com.google.bigtable.admin.v2.ColumnFamily;
import com.google.bigtable.admin.v2.CopyBackupMetadata;
import com.google.bigtable.admin.v2.CreateAuthorizedViewMetadata;
import com.google.bigtable.admin.v2.CreateBackupMetadata;
import com.google.bigtable.admin.v2.DeleteBackupRequest;
import com.google.bigtable.admin.v2.DeleteTableRequest;
import com.google.bigtable.admin.v2.DropRowRangeRequest;
import com.google.bigtable.admin.v2.GcRule;
import com.google.bigtable.admin.v2.GetBackupRequest;
import com.google.bigtable.admin.v2.GetTableRequest;
import com.google.bigtable.admin.v2.ListBackupsRequest;
import com.google.bigtable.admin.v2.ListTablesRequest;
import com.google.bigtable.admin.v2.ModifyColumnFamiliesRequest.Modification;
import com.google.bigtable.admin.v2.RestoreSourceType;
import com.google.bigtable.admin.v2.RestoreTableMetadata;
import com.google.bigtable.admin.v2.Table.ClusterState;
import com.google.bigtable.admin.v2.Table.View;
import com.google.bigtable.admin.v2.TableName;
import com.google.bigtable.admin.v2.UpdateAuthorizedViewMetadata;
import com.google.bigtable.admin.v2.UpdateTableMetadata;
import com.google.cloud.Identity;
import com.google.cloud.Policy;
import com.google.cloud.Role;
import com.google.cloud.bigtable.admin.v2.BaseBigtableTableAdminClient.ListAuthorizedViewsPage;
import com.google.cloud.bigtable.admin.v2.BaseBigtableTableAdminClient.ListAuthorizedViewsPagedResponse;
import com.google.cloud.bigtable.admin.v2.BaseBigtableTableAdminClient.ListBackupsPage;
import com.google.cloud.bigtable.admin.v2.BaseBigtableTableAdminClient.ListBackupsPagedResponse;
import com.google.cloud.bigtable.admin.v2.BaseBigtableTableAdminClient.ListTablesPage;
import com.google.cloud.bigtable.admin.v2.BaseBigtableTableAdminClient.ListTablesPagedResponse;
import com.google.cloud.bigtable.admin.v2.internal.NameUtil;
import com.google.cloud.bigtable.admin.v2.models.AuthorizedView;
import com.google.cloud.bigtable.admin.v2.models.Backup;
import com.google.cloud.bigtable.admin.v2.models.ConsistencyRequest;
import com.google.cloud.bigtable.admin.v2.models.CopyBackupRequest;
import com.google.cloud.bigtable.admin.v2.models.CreateAuthorizedViewRequest;
import com.google.cloud.bigtable.admin.v2.models.CreateBackupRequest;
import com.google.cloud.bigtable.admin.v2.models.CreateTableRequest;
import com.google.cloud.bigtable.admin.v2.models.EncryptionInfo;
import com.google.cloud.bigtable.admin.v2.models.ModifyColumnFamiliesRequest;
import com.google.cloud.bigtable.admin.v2.models.RestoreTableRequest;
import com.google.cloud.bigtable.admin.v2.models.RestoredTableResult;
import com.google.cloud.bigtable.admin.v2.models.SubsetView;
import com.google.cloud.bigtable.admin.v2.models.Table;
import com.google.cloud.bigtable.admin.v2.models.Type;
import com.google.cloud.bigtable.admin.v2.models.UpdateAuthorizedViewRequest;
import com.google.cloud.bigtable.admin.v2.models.UpdateBackupRequest;
import com.google.cloud.bigtable.admin.v2.stub.EnhancedBigtableTableAdminStub;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.io.BaseEncoding;
import com.google.longrunning.Operation;
import com.google.protobuf.ByteString;
import com.google.protobuf.Duration;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Timestamp;
import com.google.protobuf.util.Timestamps;
import io.grpc.Status;
import io.grpc.Status.Code;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicBoolean;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.mockito.stubbing.Answer;
import org.threeten.bp.Instant;

@RunWith(JUnit4.class)
/**
 * Tests for {@link BigtableTableAdminClient}. This test class uses Mockito so it has been
 * explicitly excluded from Native Image testing by not following the naming convention of (IT* and
 * *ClientTest).
 */
public class BigtableTableAdminClientTests {
  @Rule public final MockitoRule mockitoRule = MockitoJUnit.rule();

  private static final String PROJECT_ID = "my-project";
  private static final String INSTANCE_ID = "my-instance";
  private static final String TABLE_ID = "my-table";
  private static final String CLUSTER_ID = "my-cluster";
  private static final String BACKUP_ID = "my-backup";
  private static final String AUTHORIZED_VIEW_ID = "my-authorized-view";

  private static final String INSTANCE_NAME = NameUtil.formatInstanceName(PROJECT_ID, INSTANCE_ID);
  private static final String TABLE_NAME =
      NameUtil.formatTableName(PROJECT_ID, INSTANCE_ID, TABLE_ID);

  private BigtableTableAdminClient adminClient;
  @Mock private EnhancedBigtableTableAdminStub mockStub;

  @Mock
  private UnaryCallable<
          com.google.bigtable.admin.v2.CreateTableRequest, com.google.bigtable.admin.v2.Table>
      mockCreateTableCallable;

  @Mock
  private OperationCallable<
          com.google.bigtable.admin.v2.UpdateTableRequest,
          com.google.bigtable.admin.v2.Table,
          UpdateTableMetadata>
      mockUpdateTableOperationCallable;

  @Mock
  private UnaryCallable<
          com.google.bigtable.admin.v2.ModifyColumnFamiliesRequest,
          com.google.bigtable.admin.v2.Table>
      mockModifyTableCallable;

  @Mock private UnaryCallable<DeleteTableRequest, Empty> mockDeleteTableCallable;

  @Mock
  private UnaryCallable<GetTableRequest, com.google.bigtable.admin.v2.Table> mockGetTableCallable;

  @Mock private UnaryCallable<ListTablesRequest, ListTablesPagedResponse> mockListTableCallable;
  @Mock private UnaryCallable<DropRowRangeRequest, Empty> mockDropRowRangeCallable;
  @Mock private UnaryCallable<TableName, Void> mockAwaitReplicationCallable;

  @Mock private UnaryCallable<ConsistencyRequest, Void> mockAwaitConsistencyCallable;

  @Mock
  private OperationCallable<
          com.google.bigtable.admin.v2.CreateBackupRequest,
          com.google.bigtable.admin.v2.Backup,
          CreateBackupMetadata>
      mockCreateBackupOperationCallable;

  @Mock
  private UnaryCallable<GetBackupRequest, com.google.bigtable.admin.v2.Backup>
      mockGetBackupCallable;

  @Mock
  private UnaryCallable<
          com.google.bigtable.admin.v2.UpdateBackupRequest, com.google.bigtable.admin.v2.Backup>
      mockUpdateBackupCallable;

  @Mock private UnaryCallable<ListBackupsRequest, ListBackupsPagedResponse> mockListBackupCallable;
  @Mock private UnaryCallable<DeleteBackupRequest, Empty> mockDeleteBackupCallable;

  @Mock
  private UnaryCallable<com.google.bigtable.admin.v2.RestoreTableRequest, Operation>
      mockRestoreTableCallable;

  @Mock
  private OperationCallable<
          com.google.bigtable.admin.v2.RestoreTableRequest,
          com.google.bigtable.admin.v2.Table,
          RestoreTableMetadata>
      mockRestoreTableOperationCallable;

  @Mock
  private OperationCallable<
          com.google.bigtable.admin.v2.CopyBackupRequest,
          com.google.bigtable.admin.v2.Backup,
          CopyBackupMetadata>
      mockCopyBackupOperationCallable;

  @Mock
  private OperationCallable<
          com.google.bigtable.admin.v2.CreateAuthorizedViewRequest,
          com.google.bigtable.admin.v2.AuthorizedView,
          CreateAuthorizedViewMetadata>
      mockCreateAuthorizedViewOperationCallable;

  @Mock
  private OperationCallable<
          com.google.bigtable.admin.v2.UpdateAuthorizedViewRequest,
          com.google.bigtable.admin.v2.AuthorizedView,
          UpdateAuthorizedViewMetadata>
      mockUpdateAuthorizedViewOperationCallable;

  @Mock
  private UnaryCallable<
          com.google.bigtable.admin.v2.GetAuthorizedViewRequest,
          com.google.bigtable.admin.v2.AuthorizedView>
      mockGetAuthorizedViewCallable;

  @Mock
  private UnaryCallable<
          com.google.bigtable.admin.v2.ListAuthorizedViewsRequest, ListAuthorizedViewsPagedResponse>
      mockListAuthorizedViewsCallable;

  @Mock
  private UnaryCallable<com.google.bigtable.admin.v2.DeleteAuthorizedViewRequest, Empty>
      mockDeleteAuthorizedViewCallable;

  @Mock
  private UnaryCallable<com.google.iam.v1.GetIamPolicyRequest, com.google.iam.v1.Policy>
      mockGetIamPolicyCallable;

  @Mock
  private UnaryCallable<com.google.iam.v1.SetIamPolicyRequest, com.google.iam.v1.Policy>
      mockSetIamPolicyCallable;

  @Mock
  private UnaryCallable<
          com.google.iam.v1.TestIamPermissionsRequest, com.google.iam.v1.TestIamPermissionsResponse>
      mockTestIamPermissionsCallable;

  @Before
  public void setUp() {
    adminClient = BigtableTableAdminClient.create(PROJECT_ID, INSTANCE_ID, mockStub);
  }

  @Test
  public void testCreateTable() {
    // Setup
    Mockito.when(mockStub.createTableCallable()).thenReturn(mockCreateTableCallable);

    com.google.bigtable.admin.v2.CreateTableRequest expectedRequest =
        com.google.bigtable.admin.v2.CreateTableRequest.newBuilder()
            .setParent(INSTANCE_NAME)
            .setTableId(TABLE_ID)
            .setTable(
                com.google.bigtable.admin.v2.Table.newBuilder()
                    .putColumnFamilies(
                        "cf1",
                        ColumnFamily.newBuilder()
                            .setGcRule(GcRule.getDefaultInstance())
                            .setValueType(TypeProtos.intSumType())
                            .build())
                    .putColumnFamilies(
                        "cf2",
                        ColumnFamily.newBuilder()
                            .setGcRule(GcRule.getDefaultInstance())
                            .setValueType(TypeProtos.intMinType())
                            .build())
                    .putColumnFamilies(
                        "cf3",
                        ColumnFamily.newBuilder()
                            .setGcRule(GcRule.getDefaultInstance())
                            .setValueType(TypeProtos.intMaxType())
                            .build())
                    .putColumnFamilies(
                        "cf4",
                        ColumnFamily.newBuilder()
                            .setGcRule(GcRule.getDefaultInstance())
                            .setValueType(TypeProtos.intHllType())
                            .build()))
            .build();

    com.google.bigtable.admin.v2.Table expectedResponse =
        com.google.bigtable.admin.v2.Table.newBuilder().setName(TABLE_NAME).build();

    Mockito.when(mockCreateTableCallable.futureCall(expectedRequest))
        .thenReturn(ApiFutures.immediateFuture(expectedResponse));

    // Execute
    Table result =
        adminClient.createTable(
            CreateTableRequest.of(TABLE_ID)
                .addFamily("cf1", Type.int64Sum())
                .addFamily("cf2", Type.int64Min())
                .addFamily("cf3", Type.int64Max())
                .addFamily("cf4", Type.int64Hll()));

    // Verify
    assertThat(result).isEqualTo(Table.fromProto(expectedResponse));
  }

  @Test
  public void testCreateTableWithDeletionProtectionSet() {
    // Setup
    Mockito.when(mockStub.createTableCallable()).thenReturn(mockCreateTableCallable);

    com.google.bigtable.admin.v2.CreateTableRequest expectedRequest =
        com.google.bigtable.admin.v2.CreateTableRequest.newBuilder()
            .setParent(INSTANCE_NAME)
            .setTableId(TABLE_ID)
            .setTable(
                com.google.bigtable.admin.v2.Table.newBuilder()
                    .setDeletionProtection(true)
                    .putColumnFamilies(
                        "cf1",
                        ColumnFamily.newBuilder()
                            .setGcRule(GcRule.getDefaultInstance())
                            .setValueType(TypeProtos.intSumType())
                            .build()))
            .build();

    com.google.bigtable.admin.v2.Table expectedResponse =
        com.google.bigtable.admin.v2.Table.newBuilder().setName(TABLE_NAME).build();

    Mockito.when(mockCreateTableCallable.futureCall(expectedRequest))
        .thenReturn(ApiFutures.immediateFuture(expectedResponse));

    // Execute
    Table result =
        adminClient.createTable(
            CreateTableRequest.of(TABLE_ID)
                .addFamily("cf1", Type.int64Sum())
                .setDeletionProtection(true));

    // Verify
    assertThat(result).isEqualTo(Table.fromProto(expectedResponse));
  }

  @Test
  public void testUpdateTable() {
    // Setup
    Mockito.when(mockStub.updateTableOperationCallable())
        .thenReturn(mockUpdateTableOperationCallable);

    com.google.cloud.bigtable.admin.v2.models.UpdateTableRequest request =
        com.google.cloud.bigtable.admin.v2.models.UpdateTableRequest.of(TABLE_ID)
            .addChangeStreamRetention(org.threeten.bp.Duration.ofHours(24));

    com.google.bigtable.admin.v2.Table expectedResponse =
        com.google.bigtable.admin.v2.Table.newBuilder()
            .setName(TABLE_NAME)
            .setChangeStreamConfig(
                ChangeStreamConfig.newBuilder()
                    .setRetentionPeriod(Duration.newBuilder().setSeconds(86400).build())
                    .build())
            .build();

    mockOperationResult(
        mockUpdateTableOperationCallable,
        request.toProto(PROJECT_ID, INSTANCE_ID),
        expectedResponse,
        UpdateTableMetadata.newBuilder().setName(TABLE_NAME).build());

    // Execute
    Table actualResult = adminClient.updateTable(request);

    // Verify
    assertThat(actualResult.getId()).isEqualTo(TABLE_ID);
    assertThat(actualResult.getChangeStreamRetention())
        .isEqualTo(org.threeten.bp.Duration.ofHours(24));
    assertThat(actualResult.getChangeStreamRetention().toMillis())
        .isEqualTo(actualResult.getChangeStreamRetention().toMillis());
  }

  @Test
  public void testModifyFamilies() {
    // Setup
    Mockito.when(mockStub.modifyColumnFamiliesCallable()).thenReturn(mockModifyTableCallable);

    com.google.bigtable.admin.v2.ModifyColumnFamiliesRequest expectedRequest =
        com.google.bigtable.admin.v2.ModifyColumnFamiliesRequest.newBuilder()
            .setName(TABLE_NAME)
            .addModifications(
                Modification.newBuilder()
                    .setId("cf")
                    .setCreate(ColumnFamily.newBuilder().setGcRule(GcRule.getDefaultInstance())))
            .addModifications(
                Modification.newBuilder()
                    .setId("cf2")
                    .setCreate(
                        ColumnFamily.newBuilder()
                            .setGcRule(GcRule.getDefaultInstance())
                            .setValueType(TypeProtos.intSumType())))
            .build();

    com.google.bigtable.admin.v2.Table fakeResponse =
        com.google.bigtable.admin.v2.Table.newBuilder()
            .setName(TABLE_NAME)
            .putColumnFamilies(
                "cf", ColumnFamily.newBuilder().setGcRule(GcRule.getDefaultInstance()).build())
            .putColumnFamilies(
                "cf2",
                ColumnFamily.newBuilder()
                    .setGcRule(GcRule.getDefaultInstance())
                    .setValueType(TypeProtos.intSumType())
                    .build())
            .build();

    Mockito.when(mockModifyTableCallable.futureCall(expectedRequest))
        .thenReturn(ApiFutures.immediateFuture(fakeResponse));

    // Execute
    Table actualResult =
        adminClient.modifyFamilies(
            ModifyColumnFamiliesRequest.of(TABLE_ID)
                .addFamily("cf")
                .addFamily("cf2", Type.int64Sum()));

    // Verify
    assertThat(actualResult).isEqualTo(Table.fromProto(fakeResponse));
  }

  @Test
  public void testDeleteTable() {
    // Setup
    Mockito.when(mockStub.deleteTableCallable()).thenReturn(mockDeleteTableCallable);

    DeleteTableRequest expectedRequest =
        DeleteTableRequest.newBuilder().setName(TABLE_NAME).build();

    final AtomicBoolean wasCalled = new AtomicBoolean(false);

    Mockito.when(mockDeleteTableCallable.futureCall(expectedRequest))
        .thenAnswer(
            (Answer<ApiFuture<Empty>>)
                invocationOnMock -> {
                  wasCalled.set(true);
                  return ApiFutures.immediateFuture(Empty.getDefaultInstance());
                });

    // Execute
    adminClient.deleteTable(TABLE_ID);

    // Verify
    assertThat(wasCalled.get()).isTrue();
  }

  @Test
  public void testGetTable() {
    // Setup
    Mockito.when(mockStub.getTableCallable()).thenReturn(mockGetTableCallable);

    GetTableRequest expectedRequest =
        GetTableRequest.newBuilder().setName(TABLE_NAME).setView(View.SCHEMA_VIEW).build();

    com.google.bigtable.admin.v2.Table expectedResponse =
        com.google.bigtable.admin.v2.Table.newBuilder().setName(TABLE_NAME).build();

    Mockito.when(mockGetTableCallable.futureCall(expectedRequest))
        .thenReturn(ApiFutures.immediateFuture(expectedResponse));

    // Execute
    Table actualResult = adminClient.getTable(TABLE_ID);

    // Verify
    assertThat(actualResult).isEqualTo(Table.fromProto(expectedResponse));
  }

  @Test
  public void testGetEncryptionInfos() {
    // Setup
    Mockito.when(mockStub.getTableCallable()).thenReturn(mockGetTableCallable);

    GetTableRequest expectedRequest =
        GetTableRequest.newBuilder().setName(TABLE_NAME).setView(View.ENCRYPTION_VIEW).build();

    com.google.bigtable.admin.v2.EncryptionInfo expectedEncryptionInfo =
        com.google.bigtable.admin.v2.EncryptionInfo.newBuilder()
            .setKmsKeyVersion("some key")
            .setEncryptionType(
                com.google.bigtable.admin.v2.EncryptionInfo.EncryptionType
                    .CUSTOMER_MANAGED_ENCRYPTION)
            .setEncryptionStatus(
                com.google.rpc.Status.newBuilder()
                    .setCode(Code.FAILED_PRECONDITION.value())
                    .setMessage("something failed"))
            .build();

    com.google.bigtable.admin.v2.Table expectedResponse =
        com.google.bigtable.admin.v2.Table.newBuilder()
            .setName(TABLE_NAME)
            .putClusterStates(
                "cluster1",
                ClusterState.newBuilder().addEncryptionInfo(expectedEncryptionInfo).build())
            .build();

    Mockito.when(mockGetTableCallable.futureCall(expectedRequest))
        .thenReturn(ApiFutures.immediateFuture(expectedResponse));

    // Execute
    Map<String, List<com.google.cloud.bigtable.admin.v2.models.EncryptionInfo>> actualResult =
        adminClient.getEncryptionInfo(TABLE_ID);

    // Verify that the encryption info is transferred from the proto to the model.
    assertThat(actualResult)
        .containsExactly(
            "cluster1", ImmutableList.of(EncryptionInfo.fromProto(expectedEncryptionInfo)));
  }

  @Test
  public void testListTables() {
    // Setup
    Mockito.when(mockStub.listTablesPagedCallable()).thenReturn(mockListTableCallable);

    com.google.bigtable.admin.v2.ListTablesRequest expectedRequest =
        com.google.bigtable.admin.v2.ListTablesRequest.newBuilder()
            .setParent(INSTANCE_NAME)
            .build();

    // 3 Tables spread across 2 pages
    List<com.google.bigtable.admin.v2.Table> expectedProtos = Lists.newArrayList();
    for (int i = 0; i < 3; i++) {
      expectedProtos.add(
          com.google.bigtable.admin.v2.Table.newBuilder().setName(TABLE_NAME + i).build());
    }
    // 2 on the first page
    ListTablesPage page0 = Mockito.mock(ListTablesPage.class);
    Mockito.when(page0.getValues()).thenReturn(expectedProtos.subList(0, 2));
    Mockito.when(page0.hasNextPage()).thenReturn(true);

    // 1 on the last page
    ListTablesPage page1 = Mockito.mock(ListTablesPage.class);
    Mockito.when(page1.getValues()).thenReturn(expectedProtos.subList(2, 3));

    // Link page0 to page1
    Mockito.when(page0.getNextPageAsync()).thenReturn(ApiFutures.immediateFuture(page1));

    // Link page to the response
    ListTablesPagedResponse response0 = Mockito.mock(ListTablesPagedResponse.class);
    Mockito.when(response0.getPage()).thenReturn(page0);

    Mockito.when(mockListTableCallable.futureCall(expectedRequest))
        .thenReturn(ApiFutures.immediateFuture(response0));

    // Execute
    List<String> actualResults = adminClient.listTables();

    // Verify
    List<String> expectedResults = Lists.newArrayList();
    for (com.google.bigtable.admin.v2.Table expectedProto : expectedProtos) {
      expectedResults.add(TableName.parse(expectedProto.getName()).getTable());
    }

    assertThat(actualResults).containsExactlyElementsIn(expectedResults);
  }

  @Test
  public void testDropRowRange() {
    // Setup
    Mockito.when(mockStub.dropRowRangeCallable()).thenReturn(mockDropRowRangeCallable);

    DropRowRangeRequest expectedRequest =
        DropRowRangeRequest.newBuilder()
            .setName(TABLE_NAME)
            .setRowKeyPrefix(ByteString.copyFromUtf8("rowKeyPrefix"))
            .build();

    final Empty expectedResponse = Empty.getDefaultInstance();

    final AtomicBoolean wasCalled = new AtomicBoolean(false);

    Mockito.when(mockDropRowRangeCallable.futureCall(expectedRequest))
        .thenAnswer(
            (Answer<ApiFuture<Empty>>)
                invocationOnMock -> {
                  wasCalled.set(true);
                  return ApiFutures.immediateFuture(expectedResponse);
                });

    // Execute
    adminClient.dropRowRange(TABLE_ID, "rowKeyPrefix");

    // Verify
    assertThat(wasCalled.get()).isTrue();
  }

  @Test
  public void testAwaitReplication() {
    // Setup
    Mockito.when(mockStub.awaitReplicationCallable()).thenReturn(mockAwaitReplicationCallable);

    TableName expectedRequest = TableName.parse(TABLE_NAME);

    final AtomicBoolean wasCalled = new AtomicBoolean(false);

    Mockito.when(mockAwaitReplicationCallable.futureCall(expectedRequest))
        .thenAnswer(
            (Answer<ApiFuture<Void>>)
                invocationOnMock -> {
                  wasCalled.set(true);
                  return ApiFutures.immediateFuture(null);
                });

    // Execute
    adminClient.awaitReplication(TABLE_ID);

    // Verify
    assertThat(wasCalled.get()).isTrue();
  }

  @Test
  public void testAwaitConsistencyForDataBoost() {
    // Setup
    Mockito.when(mockStub.awaitConsistencyCallable()).thenReturn(mockAwaitConsistencyCallable);

    ConsistencyRequest consistencyRequest = ConsistencyRequest.forDataBoost(TABLE_ID);

    final AtomicBoolean wasCalled = new AtomicBoolean(false);

    Mockito.when(mockAwaitConsistencyCallable.futureCall(consistencyRequest))
        .thenAnswer(
            (Answer<ApiFuture<Void>>)
                invocationOnMock -> {
                  wasCalled.set(true);
                  return ApiFutures.immediateFuture(null);
                });

    // Execute
    adminClient.awaitConsistency(consistencyRequest);

    // Verify
    assertThat(wasCalled.get()).isTrue();
  }

  @Test
  public void testExistsTrue() {
    // Setup
    Mockito.when(mockStub.getTableCallable()).thenReturn(mockGetTableCallable);

    com.google.bigtable.admin.v2.Table expectedResponse =
        com.google.bigtable.admin.v2.Table.newBuilder().setName(TABLE_NAME).build();

    Mockito.when(mockGetTableCallable.futureCall(ArgumentMatchers.any(GetTableRequest.class)))
        .thenReturn(ApiFutures.immediateFuture(expectedResponse));

    // Execute
    boolean found = adminClient.exists(TABLE_ID);

    // Verify
    assertThat(found).isTrue();
  }

  @Test
  public void testExistsFalse() {
    // Setup
    Mockito.when(mockStub.getTableCallable()).thenReturn(mockGetTableCallable);

    NotFoundException exception =
        new NotFoundException("fake error", null, GrpcStatusCode.of(Status.Code.NOT_FOUND), false);

    Mockito.when(mockGetTableCallable.futureCall(ArgumentMatchers.any(GetTableRequest.class)))
        .thenReturn(
            ApiFutures.<com.google.bigtable.admin.v2.Table>immediateFailedFuture(exception));

    // Execute
    boolean found = adminClient.exists(TABLE_ID);

    // Verify
    assertThat(found).isFalse();
  }

  @Test
  public void testCreateBackup() {
    // Setup
    Mockito.when(mockStub.createBackupOperationCallable())
        .thenReturn(mockCreateBackupOperationCallable);

    String backupName = NameUtil.formatBackupName(PROJECT_ID, INSTANCE_ID, CLUSTER_ID, BACKUP_ID);
    Timestamp startTime = Timestamp.newBuilder().setSeconds(123).build();
    Timestamp endTime = Timestamp.newBuilder().setSeconds(456).build();
    Timestamp expireTime = Timestamp.newBuilder().setSeconds(789).build();
    long sizeBytes = 123456789;
    CreateBackupRequest req =
        CreateBackupRequest.of(CLUSTER_ID, BACKUP_ID)
            .setSourceTableId(TABLE_ID)
            .setExpireTime(Instant.ofEpochMilli(Timestamps.toMillis(expireTime)));
    mockOperationResult(
        mockCreateBackupOperationCallable,
        req.toProto(PROJECT_ID, INSTANCE_ID),
        com.google.bigtable.admin.v2.Backup.newBuilder()
            .setName(backupName)
            .setSourceTable(TABLE_NAME)
            .setStartTime(startTime)
            .setEndTime(endTime)
            .setExpireTime(expireTime)
            .setSizeBytes(sizeBytes)
            .build(),
        CreateBackupMetadata.newBuilder()
            .setName(backupName)
            .setStartTime(startTime)
            .setEndTime(endTime)
            .setSourceTable(TABLE_NAME)
            .build());
    // Execute
    Backup actualResult = adminClient.createBackup(req);

    // Verify
    assertThat(actualResult.getId()).isEqualTo(BACKUP_ID);
    assertThat(actualResult.getSourceTableId()).isEqualTo(TABLE_ID);
    assertThat(actualResult.getStartTime())
        .isEqualTo(Instant.ofEpochMilli(Timestamps.toMillis(startTime)));
    assertThat(actualResult.getEndTime())
        .isEqualTo(Instant.ofEpochMilli(Timestamps.toMillis(endTime)));
    assertThat(actualResult.getExpireTime())
        .isEqualTo(Instant.ofEpochMilli(Timestamps.toMillis(expireTime)));
    assertThat(actualResult.getSizeBytes()).isEqualTo(sizeBytes);
  }

  @Test
  public void testCreateHotBackup() {
    // Setup
    Mockito.when(mockStub.createBackupOperationCallable())
        .thenReturn(mockCreateBackupOperationCallable);

    String backupName = NameUtil.formatBackupName(PROJECT_ID, INSTANCE_ID, CLUSTER_ID, BACKUP_ID);
    Timestamp startTime = Timestamp.newBuilder().setSeconds(123).build();
    Timestamp endTime = Timestamp.newBuilder().setSeconds(456).build();
    Timestamp expireTime = Timestamp.newBuilder().setSeconds(789).build();
    Timestamp hotToStandardTime = Timestamp.newBuilder().setSeconds(500).build();
    long sizeBytes = 123456789;
    CreateBackupRequest req =
        CreateBackupRequest.of(CLUSTER_ID, BACKUP_ID)
            .setSourceTableId(TABLE_ID)
            .setExpireTime(Instant.ofEpochMilli(Timestamps.toMillis(expireTime)))
            .setBackupType(Backup.BackupType.HOT)
            .setHotToStandardTime(Instant.ofEpochMilli(Timestamps.toMillis(hotToStandardTime)));
    mockOperationResult(
        mockCreateBackupOperationCallable,
        req.toProto(PROJECT_ID, INSTANCE_ID),
        com.google.bigtable.admin.v2.Backup.newBuilder()
            .setName(backupName)
            .setSourceTable(TABLE_NAME)
            .setStartTime(startTime)
            .setEndTime(endTime)
            .setExpireTime(expireTime)
            .setSizeBytes(sizeBytes)
            .setBackupType(com.google.bigtable.admin.v2.Backup.BackupType.HOT)
            .setHotToStandardTime(hotToStandardTime)
            .build(),
        CreateBackupMetadata.newBuilder()
            .setName(backupName)
            .setStartTime(startTime)
            .setEndTime(endTime)
            .setSourceTable(TABLE_NAME)
            .build());
    // Execute
    Backup actualResult = adminClient.createBackup(req);

    // Verify
    assertThat(actualResult.getId()).isEqualTo(BACKUP_ID);
    assertThat(actualResult.getSourceTableId()).isEqualTo(TABLE_ID);
    assertThat(actualResult.getStartTime())
        .isEqualTo(Instant.ofEpochMilli(Timestamps.toMillis(startTime)));
    assertThat(actualResult.getEndTime())
        .isEqualTo(Instant.ofEpochMilli(Timestamps.toMillis(endTime)));
    assertThat(actualResult.getExpireTime())
        .isEqualTo(Instant.ofEpochMilli(Timestamps.toMillis(expireTime)));
    assertThat(actualResult.getBackupType()).isEqualTo(Backup.BackupType.HOT);
    assertThat(actualResult.getHotToStandardTime())
        .isEqualTo(Instant.ofEpochMilli(Timestamps.toMillis(hotToStandardTime)));
    assertThat(actualResult.getSizeBytes()).isEqualTo(sizeBytes);
  }

  @Test
  public void testGetBackup() {
    // Setup
    Mockito.when(mockStub.getBackupCallable()).thenReturn(mockGetBackupCallable);

    Timestamp expireTime = Timestamp.newBuilder().setSeconds(123456789).build();
    Timestamp startTime = Timestamp.newBuilder().setSeconds(1234).build();
    Timestamp endTime = Timestamp.newBuilder().setSeconds(5678).build();
    com.google.bigtable.admin.v2.Backup.State state = State.CREATING;
    long sizeBytes = 12345L;
    GetBackupRequest testRequest =
        GetBackupRequest.newBuilder()
            .setName(NameUtil.formatBackupName(PROJECT_ID, INSTANCE_ID, CLUSTER_ID, BACKUP_ID))
            .build();
    Mockito.when(mockGetBackupCallable.futureCall(testRequest))
        .thenReturn(
            ApiFutures.immediateFuture(
                com.google.bigtable.admin.v2.Backup.newBuilder()
                    .setName(
                        NameUtil.formatBackupName(PROJECT_ID, INSTANCE_ID, CLUSTER_ID, BACKUP_ID))
                    .setSourceTable(NameUtil.formatTableName(PROJECT_ID, INSTANCE_ID, TABLE_ID))
                    .setExpireTime(expireTime)
                    .setStartTime(startTime)
                    .setEndTime(endTime)
                    .setSizeBytes(sizeBytes)
                    .setState(state)
                    .setBackupType(com.google.bigtable.admin.v2.Backup.BackupType.STANDARD)
                    .build()));

    // Execute
    Backup actualResult = adminClient.getBackup(CLUSTER_ID, BACKUP_ID);

    // Verify
    assertThat(actualResult.getId()).isEqualTo(BACKUP_ID);
    assertThat(actualResult.getSourceTableId()).isEqualTo(TABLE_ID);
    assertThat(actualResult.getExpireTime())
        .isEqualTo(Instant.ofEpochMilli(Timestamps.toMillis(expireTime)));
    assertThat(actualResult.getStartTime())
        .isEqualTo(Instant.ofEpochMilli(Timestamps.toMillis(startTime)));
    assertThat(actualResult.getEndTime())
        .isEqualTo(Instant.ofEpochMilli(Timestamps.toMillis(endTime)));
    assertThat(actualResult.getSizeBytes()).isEqualTo(sizeBytes);
    assertThat(actualResult.getState()).isEqualTo(Backup.State.fromProto(state));
    assertThat(actualResult.getBackupType()).isEqualTo(Backup.BackupType.STANDARD);
  }

  @Test
  public void testUpdateBackup() {
    // Setup
    Mockito.when(mockStub.updateBackupCallable()).thenReturn(mockUpdateBackupCallable);

    Timestamp expireTime = Timestamp.newBuilder().setSeconds(123456789).build();
    Timestamp hotToStandardTime = Timestamp.newBuilder().setSeconds(123456789).build();
    long sizeBytes = 12345L;
    UpdateBackupRequest req = UpdateBackupRequest.of(CLUSTER_ID, BACKUP_ID);
    Mockito.when(mockUpdateBackupCallable.futureCall(req.toProto(PROJECT_ID, INSTANCE_ID)))
        .thenReturn(
            ApiFutures.immediateFuture(
                com.google.bigtable.admin.v2.Backup.newBuilder()
                    .setName(
                        NameUtil.formatBackupName(PROJECT_ID, INSTANCE_ID, CLUSTER_ID, BACKUP_ID))
                    .setSourceTable(NameUtil.formatTableName(PROJECT_ID, INSTANCE_ID, TABLE_ID))
                    .setExpireTime(expireTime)
                    .setSizeBytes(sizeBytes)
                    .setHotToStandardTime(hotToStandardTime)
                    .build()));

    // Execute
    Backup actualResult = adminClient.updateBackup(req);

    // Verify
    assertThat(actualResult.getId()).isEqualTo(BACKUP_ID);
    assertThat(actualResult.getSourceTableId()).isEqualTo(TABLE_ID);
    assertThat(actualResult.getExpireTime())
        .isEqualTo(Instant.ofEpochMilli(Timestamps.toMillis(expireTime)));
    assertThat(actualResult.getHotToStandardTime())
        .isEqualTo(Instant.ofEpochMilli(Timestamps.toMillis(hotToStandardTime)));
    assertThat(actualResult.getSizeBytes()).isEqualTo(sizeBytes);
  }

  @Test
  public void testRestoreTable() throws ExecutionException, InterruptedException {
    // Setup
    Mockito.when(mockStub.restoreTableOperationCallable())
        .thenReturn(mockRestoreTableOperationCallable);

    Timestamp startTime = Timestamp.newBuilder().setSeconds(1234).build();
    Timestamp endTime = Timestamp.newBuilder().setSeconds(5678).build();
    String operationName = "my-operation";
    RestoreTableRequest req = RestoreTableRequest.of(CLUSTER_ID, BACKUP_ID).setTableId(TABLE_ID);
    mockOperationResult(
        mockRestoreTableOperationCallable,
        req.toProto(PROJECT_ID, INSTANCE_ID),
        com.google.bigtable.admin.v2.Table.newBuilder().setName(TABLE_NAME).build(),
        RestoreTableMetadata.newBuilder()
            .setName(NameUtil.formatTableName(PROJECT_ID, INSTANCE_ID, TABLE_ID))
            .setOptimizeTableOperationName(operationName)
            .setSourceType(RestoreSourceType.BACKUP)
            .setBackupInfo(
                BackupInfo.newBuilder()
                    .setBackup(BACKUP_ID)
                    .setSourceTable(NameUtil.formatTableName(PROJECT_ID, INSTANCE_ID, TABLE_ID))
                    .setStartTime(startTime)
                    .setEndTime(endTime)
                    .build())
            .build());
    // Execute
    RestoredTableResult actualResult = adminClient.restoreTable(req);

    // Verify
    assertThat(actualResult.getTable().getId()).isEqualTo(TABLE_ID);
  }

  @Test
  public void testRestoreTableCrossProject() throws ExecutionException, InterruptedException {
    // Setup
    Mockito.when(mockStub.restoreTableOperationCallable())
        .thenReturn(mockRestoreTableOperationCallable);

    Timestamp startTime = Timestamp.newBuilder().setSeconds(1234).build();
    Timestamp endTime = Timestamp.newBuilder().setSeconds(5678).build();
    String operationName = "my-operation";

    // Use existing adminClient as destination project:
    String dstProjectId = PROJECT_ID;
    String dstInstanceId = INSTANCE_ID;
    String dstTableName = TABLE_NAME;

    // Create RestoreTableRequest from different source project:
    String srcProjectId = "src-project";
    String srcInstanceId = "src-instance";
    String srcClusterId = "src-cluster";

    RestoreTableRequest req =
        RestoreTableRequest.of(srcInstanceId, srcClusterId, BACKUP_ID, srcProjectId)
            .setTableId(TABLE_ID);
    mockOperationResult(
        mockRestoreTableOperationCallable,
        req.toProto(dstProjectId, dstInstanceId),
        com.google.bigtable.admin.v2.Table.newBuilder().setName(dstTableName).build(),
        RestoreTableMetadata.newBuilder()
            .setName(dstTableName)
            .setOptimizeTableOperationName(operationName)
            .setSourceType(RestoreSourceType.BACKUP)
            .setBackupInfo(
                BackupInfo.newBuilder()
                    .setBackup(BACKUP_ID)
                    .setSourceTable(NameUtil.formatTableName(srcProjectId, srcInstanceId, TABLE_ID))
                    .setStartTime(startTime)
                    .setEndTime(endTime)
                    .build())
            .build());

    // Execute
    RestoredTableResult actualResult = adminClient.restoreTable(req);

    // Verify
    assertThat(actualResult.getTable().getId()).isEqualTo(TABLE_ID);
    assertThat(actualResult.getTable().getInstanceId()).isEqualTo(dstInstanceId);
  }

  @Test
  public void testDeleteBackup() {
    // Setup
    Mockito.when(mockStub.deleteBackupCallable()).thenReturn(mockDeleteBackupCallable);

    DeleteBackupRequest testRequest =
        DeleteBackupRequest.newBuilder()
            .setName(NameUtil.formatBackupName(PROJECT_ID, INSTANCE_ID, CLUSTER_ID, BACKUP_ID))
            .build();
    Mockito.when(mockDeleteBackupCallable.futureCall(testRequest))
        .thenReturn(ApiFutures.immediateFuture(Empty.getDefaultInstance()));

    // Execute
    adminClient.deleteBackup(CLUSTER_ID, BACKUP_ID);

    // Verify
    Mockito.verify(mockDeleteBackupCallable, Mockito.times(1)).futureCall(testRequest);
  }

  @Test
  public void testListBackups() {
    // Setup
    Mockito.when(mockStub.listBackupsPagedCallable()).thenReturn(mockListBackupCallable);

    com.google.bigtable.admin.v2.ListBackupsRequest testRequest =
        com.google.bigtable.admin.v2.ListBackupsRequest.newBuilder()
            .setParent(NameUtil.formatClusterName(PROJECT_ID, INSTANCE_ID, CLUSTER_ID))
            .build();

    // 3 Backups spread across 2 pages
    List<com.google.bigtable.admin.v2.Backup> expectedProtos = Lists.newArrayList();
    for (int i = 0; i < 3; i++) {
      expectedProtos.add(
          com.google.bigtable.admin.v2.Backup.newBuilder()
              .setName(
                  NameUtil.formatBackupName(PROJECT_ID, INSTANCE_ID, CLUSTER_ID, BACKUP_ID + i))
              .build());
    }

    // 2 on the first page
    ListBackupsPage page0 = Mockito.mock(ListBackupsPage.class);
    Mockito.when(page0.getValues()).thenReturn(expectedProtos.subList(0, 2));
    Mockito.when(page0.hasNextPage()).thenReturn(true);

    // 1 on the last page
    ListBackupsPage page1 = Mockito.mock(ListBackupsPage.class);
    Mockito.when(page1.getValues()).thenReturn(expectedProtos.subList(2, 3));

    // Link page0 to page1
    Mockito.when(page0.getNextPageAsync()).thenReturn(ApiFutures.immediateFuture(page1));

    // Link page to the response
    ListBackupsPagedResponse response0 = Mockito.mock(ListBackupsPagedResponse.class);
    Mockito.when(response0.getPage()).thenReturn(page0);

    Mockito.when(mockListBackupCallable.futureCall(testRequest))
        .thenReturn(ApiFutures.immediateFuture(response0));

    // Execute
    List<String> actualResults = adminClient.listBackups(CLUSTER_ID);

    // Verify
    List<String> expectedResults = Lists.newArrayList();
    for (com.google.bigtable.admin.v2.Backup expectedProto : expectedProtos) {
      expectedResults.add(NameUtil.extractBackupIdFromBackupName(expectedProto.getName()));
    }

    assertThat(actualResults).containsExactlyElementsIn(expectedResults);
  }

  @Test
  public void testCopyBackup() {
    // Setup
    Mockito.when(mockStub.copyBackupOperationCallable())
        .thenReturn(mockCopyBackupOperationCallable);

    Timestamp startTime = Timestamp.newBuilder().setSeconds(1234).build();
    Timestamp endTime = Timestamp.newBuilder().setSeconds(5678).build();

    // Create CopyBackupRequest from different source project:
    String srcProjectId = "src-project";
    String srcInstanceId = "src-instance";
    String srcTableId = "src-table";
    String srcClusterId = "src-cluster";
    String srcBackupId = "src-backup";

    Instant expireTime = Instant.now().plus(org.threeten.bp.Duration.ofDays(15));
    long sizeBytes = 123456789;

    String dstBackupName =
        NameUtil.formatBackupName(PROJECT_ID, INSTANCE_ID, CLUSTER_ID, BACKUP_ID);
    String srcBackupName =
        NameUtil.formatBackupName(srcProjectId, srcProjectId, srcClusterId, srcBackupId);
    String srcTableName = NameUtil.formatTableName(srcProjectId, srcInstanceId, srcTableId);

    CopyBackupRequest req =
        CopyBackupRequest.of(srcClusterId, srcBackupId)
            .setSourceInstance(srcProjectId, srcInstanceId)
            .setDestination(CLUSTER_ID, BACKUP_ID)
            .setExpireTime(expireTime);
    mockOperationResult(
        mockCopyBackupOperationCallable,
        req.toProto(PROJECT_ID, INSTANCE_ID),
        com.google.bigtable.admin.v2.Backup.newBuilder()
            .setName(dstBackupName)
            .setSourceTable(srcTableName)
            .setSourceBackup(srcBackupName)
            .setStartTime(startTime)
            .setEndTime(endTime)
            .setExpireTime(Timestamps.fromMillis(expireTime.toEpochMilli()))
            .setSizeBytes(sizeBytes)
            .build(),
        CopyBackupMetadata.newBuilder()
            .setName(dstBackupName)
            .setSourceBackupInfo(
                BackupInfo.newBuilder()
                    .setBackup(srcBackupId)
                    .setSourceTable(srcTableName)
                    .setStartTime(startTime)
                    .setEndTime(endTime)
                    .build())
            .build());

    // Execute
    Backup actualResult = adminClient.copyBackup(req);

    // Verify
    assertThat(actualResult.getId()).isEqualTo(BACKUP_ID);
    assertThat(actualResult.getSourceTableId()).isEqualTo(srcTableId);
    assertThat(actualResult.getSourceBackupId()).isEqualTo(srcBackupId);
    assertThat(actualResult.getStartTime())
        .isEqualTo(Instant.ofEpochMilli(Timestamps.toMillis(startTime)));
    assertThat(actualResult.getEndTime())
        .isEqualTo(Instant.ofEpochMilli(Timestamps.toMillis(endTime)));
    assertThat(actualResult.getExpireTime()).isEqualTo(expireTime);
    assertThat(actualResult.getSizeBytes()).isEqualTo(sizeBytes);
  }

  @Test
  public void testCreateAuthorizedView() {
    // Setup
    Mockito.when(mockStub.createAuthorizedViewOperationCallable())
        .thenReturn(mockCreateAuthorizedViewOperationCallable);

    com.google.bigtable.admin.v2.CreateAuthorizedViewRequest expectedRequest =
        com.google.bigtable.admin.v2.CreateAuthorizedViewRequest.newBuilder()
            .setParent(NameUtil.formatTableName(PROJECT_ID, INSTANCE_ID, TABLE_ID))
            .setAuthorizedViewId(AUTHORIZED_VIEW_ID)
            .setAuthorizedView(
                com.google.bigtable.admin.v2.AuthorizedView.newBuilder()
                    .setSubsetView(
                        com.google.bigtable.admin.v2.AuthorizedView.SubsetView.newBuilder()
                            .addRowPrefixes(ByteString.copyFromUtf8("row#"))
                            .build())
                    .setDeletionProtection(true)
                    .build())
            .build();

    com.google.bigtable.admin.v2.AuthorizedView expectedResponse =
        com.google.bigtable.admin.v2.AuthorizedView.newBuilder()
            .setName(
                NameUtil.formatAuthorizedViewName(
                    PROJECT_ID, INSTANCE_ID, TABLE_ID, AUTHORIZED_VIEW_ID))
            .setSubsetView(
                com.google.bigtable.admin.v2.AuthorizedView.SubsetView.newBuilder()
                    .addRowPrefixes(ByteString.copyFromUtf8("row#"))
                    .build())
            .setDeletionProtection(true)
            .build();

    mockOperationResult(
        mockCreateAuthorizedViewOperationCallable,
        expectedRequest,
        expectedResponse,
        CreateAuthorizedViewMetadata.newBuilder().setOriginalRequest(expectedRequest).build());

    CreateAuthorizedViewRequest req =
        CreateAuthorizedViewRequest.of(TABLE_ID, AUTHORIZED_VIEW_ID)
            .setDeletionProtection(true)
            .setAuthorizedViewType(SubsetView.create().addRowPrefix("row#"));

    // Execute
    AuthorizedView actualResult = adminClient.createAuthorizedView(req);

    // Verify
    assertThat(actualResult).isEqualTo(AuthorizedView.fromProto(expectedResponse));
  }

  @Test
  public void testUpdateAuthorizedView() {
    // Setup
    Mockito.when(mockStub.updateAuthorizedViewOperationCallable())
        .thenReturn(mockUpdateAuthorizedViewOperationCallable);

    com.google.bigtable.admin.v2.UpdateAuthorizedViewRequest expectedRequest =
        com.google.bigtable.admin.v2.UpdateAuthorizedViewRequest.newBuilder()
            .setAuthorizedView(
                com.google.bigtable.admin.v2.AuthorizedView.newBuilder()
                    .setName(
                        NameUtil.formatAuthorizedViewName(
                            PROJECT_ID, INSTANCE_ID, TABLE_ID, AUTHORIZED_VIEW_ID))
                    .setSubsetView(
                        com.google.bigtable.admin.v2.AuthorizedView.SubsetView.newBuilder()
                            .addRowPrefixes(ByteString.copyFromUtf8("row#"))
                            .build())
                    .setDeletionProtection(true)
                    .build())
            .setUpdateMask(
                FieldMask.newBuilder().addPaths("deletion_protection").addPaths("subset_view"))
            .build();

    com.google.bigtable.admin.v2.AuthorizedView expectedResponse =
        com.google.bigtable.admin.v2.AuthorizedView.newBuilder()
            .setName(
                NameUtil.formatAuthorizedViewName(
                    PROJECT_ID, INSTANCE_ID, TABLE_ID, AUTHORIZED_VIEW_ID))
            .setSubsetView(
                com.google.bigtable.admin.v2.AuthorizedView.SubsetView.newBuilder()
                    .addRowPrefixes(ByteString.copyFromUtf8("row#"))
                    .build())
            .setDeletionProtection(true)
            .build();

    mockOperationResult(
        mockUpdateAuthorizedViewOperationCallable,
        expectedRequest,
        expectedResponse,
        UpdateAuthorizedViewMetadata.newBuilder().setOriginalRequest(expectedRequest).build());

    UpdateAuthorizedViewRequest req =
        UpdateAuthorizedViewRequest.of(TABLE_ID, AUTHORIZED_VIEW_ID)
            .setDeletionProtection(true)
            .setAuthorizedViewType(SubsetView.create().addRowPrefix("row#"));

    // Execute
    AuthorizedView actualResult = adminClient.updateAuthorizedView(req);

    // Verify
    assertThat(actualResult).isEqualTo(AuthorizedView.fromProto(expectedResponse));
  }

  @Test
  public void testGetAuthorizedView() {
    // Setup
    Mockito.when(mockStub.getAuthorizedViewCallable()).thenReturn(mockGetAuthorizedViewCallable);

    com.google.bigtable.admin.v2.GetAuthorizedViewRequest expectedRequest =
        com.google.bigtable.admin.v2.GetAuthorizedViewRequest.newBuilder()
            .setName(
                NameUtil.formatAuthorizedViewName(
                    PROJECT_ID, INSTANCE_ID, TABLE_ID, AUTHORIZED_VIEW_ID))
            .build();

    com.google.bigtable.admin.v2.AuthorizedView expectedResponse =
        com.google.bigtable.admin.v2.AuthorizedView.newBuilder()
            .setName(
                NameUtil.formatAuthorizedViewName(
                    PROJECT_ID, INSTANCE_ID, TABLE_ID, AUTHORIZED_VIEW_ID))
            .setSubsetView(
                com.google.bigtable.admin.v2.AuthorizedView.SubsetView.newBuilder()
                    .addRowPrefixes(ByteString.copyFromUtf8("row#"))
                    .build())
            .setDeletionProtection(true)
            .build();

    Mockito.when(mockGetAuthorizedViewCallable.futureCall(expectedRequest))
        .thenReturn(ApiFutures.immediateFuture(expectedResponse));

    // Execute
    AuthorizedView actualResult = adminClient.getAuthorizedView(TABLE_ID, AUTHORIZED_VIEW_ID);

    // Verify
    assertThat(actualResult).isEqualTo(AuthorizedView.fromProto(expectedResponse));
  }

  @Test
  public void testListAuthorizedViews() {
    // Setup
    Mockito.when(mockStub.listAuthorizedViewsPagedCallable())
        .thenReturn(mockListAuthorizedViewsCallable);

    com.google.bigtable.admin.v2.ListAuthorizedViewsRequest expectedRequest =
        com.google.bigtable.admin.v2.ListAuthorizedViewsRequest.newBuilder()
            .setParent(NameUtil.formatTableName(PROJECT_ID, INSTANCE_ID, TABLE_ID))
            .build();

    // 3 AuthorizedViews spread across 2 pages
    List<com.google.bigtable.admin.v2.AuthorizedView> expectedProtos = Lists.newArrayList();
    for (int i = 0; i < 3; i++) {
      expectedProtos.add(
          com.google.bigtable.admin.v2.AuthorizedView.newBuilder()
              .setName(
                  NameUtil.formatAuthorizedViewName(
                      PROJECT_ID, INSTANCE_ID, TABLE_ID, AUTHORIZED_VIEW_ID + i))
              .build());
    }

    // 2 on the first page
    ListAuthorizedViewsPage page0 = Mockito.mock(ListAuthorizedViewsPage.class);
    Mockito.when(page0.getValues()).thenReturn(expectedProtos.subList(0, 2));
    Mockito.when(page0.hasNextPage()).thenReturn(true);

    // 1 on the last page
    ListAuthorizedViewsPage page1 = Mockito.mock(ListAuthorizedViewsPage.class);
    Mockito.when(page1.getValues()).thenReturn(expectedProtos.subList(2, 3));

    // Link page0 to page1
    Mockito.when(page0.getNextPageAsync()).thenReturn(ApiFutures.immediateFuture(page1));

    // Link page to the response
    ListAuthorizedViewsPagedResponse response0 =
        Mockito.mock(ListAuthorizedViewsPagedResponse.class);
    Mockito.when(response0.getPage()).thenReturn(page0);

    Mockito.when(mockListAuthorizedViewsCallable.futureCall(expectedRequest))
        .thenReturn(ApiFutures.immediateFuture(response0));

    // Execute
    List<String> actualResults = adminClient.listAuthorizedViews(TABLE_ID);

    // Verify
    List<String> expectedResults = Lists.newArrayList();
    for (com.google.bigtable.admin.v2.AuthorizedView expectedProto : expectedProtos) {
      expectedResults.add(AuthorizedViewName.parse(expectedProto.getName()).getAuthorizedView());
    }

    assertThat(actualResults).containsExactlyElementsIn(expectedResults);
  }

  @Test
  public void testDeleteAuthorizedView() {
    // Setup
    Mockito.when(mockStub.deleteAuthorizedViewCallable())
        .thenReturn(mockDeleteAuthorizedViewCallable);

    com.google.bigtable.admin.v2.DeleteAuthorizedViewRequest expectedRequest =
        com.google.bigtable.admin.v2.DeleteAuthorizedViewRequest.newBuilder()
            .setName(
                NameUtil.formatAuthorizedViewName(
                    PROJECT_ID, INSTANCE_ID, TABLE_ID, AUTHORIZED_VIEW_ID))
            .build();

    final AtomicBoolean wasCalled = new AtomicBoolean(false);

    Mockito.when(mockDeleteAuthorizedViewCallable.futureCall(expectedRequest))
        .thenAnswer(
            (Answer<ApiFuture<Empty>>)
                invocationOnMock -> {
                  wasCalled.set(true);
                  return ApiFutures.immediateFuture(Empty.getDefaultInstance());
                });

    // Execute
    adminClient.deleteAuthorizedView(TABLE_ID, AUTHORIZED_VIEW_ID);

    // Verify
    assertThat(wasCalled.get()).isTrue();
  }

  @Test
  public void testGetBackupIamPolicy() {
    // Setup
    Mockito.when(mockStub.getIamPolicyCallable()).thenReturn(mockGetIamPolicyCallable);

    com.google.iam.v1.GetIamPolicyRequest expectedRequest =
        com.google.iam.v1.GetIamPolicyRequest.newBuilder()
            .setResource(NameUtil.formatBackupName(PROJECT_ID, INSTANCE_ID, CLUSTER_ID, BACKUP_ID))
            .build();

    com.google.iam.v1.Policy expectedResponse =
        com.google.iam.v1.Policy.newBuilder()
            .addBindings(
                com.google.iam.v1.Binding.newBuilder()
                    .setRole("roles/bigtable.viewer")
                    .addMembers("user:someone@example.com"))
            .setEtag(ByteString.copyFromUtf8("my-etag"))
            .build();

    Mockito.when(mockGetIamPolicyCallable.futureCall(expectedRequest))
        .thenReturn(ApiFutures.immediateFuture(expectedResponse));

    // Execute
    Policy actualResult = adminClient.getBackupIamPolicy(CLUSTER_ID, BACKUP_ID);

    // Verify
    assertThat(actualResult)
        .isEqualTo(
            Policy.newBuilder()
                .addIdentity(Role.of("bigtable.viewer"), Identity.user("someone@example.com"))
                .setEtag(BaseEncoding.base64().encode("my-etag".getBytes()))
                .build());
  }

  @Test
  public void testSetIamPolicy() {
    // Setup
    Mockito.when(mockStub.setIamPolicyCallable()).thenReturn(mockSetIamPolicyCallable);

    com.google.iam.v1.SetIamPolicyRequest expectedRequest =
        com.google.iam.v1.SetIamPolicyRequest.newBuilder()
            .setResource(NameUtil.formatBackupName(PROJECT_ID, INSTANCE_ID, CLUSTER_ID, BACKUP_ID))
            .setPolicy(
                com.google.iam.v1.Policy.newBuilder()
                    .addBindings(
                        com.google.iam.v1.Binding.newBuilder()
                            .setRole("roles/bigtable.viewer")
                            .addMembers("user:someone@example.com")))
            .build();

    com.google.iam.v1.Policy expectedResponse =
        com.google.iam.v1.Policy.newBuilder()
            .addBindings(
                com.google.iam.v1.Binding.newBuilder()
                    .setRole("roles/bigtable.viewer")
                    .addMembers("user:someone@example.com"))
            .setEtag(ByteString.copyFromUtf8("my-etag"))
            .build();

    Mockito.when(mockSetIamPolicyCallable.futureCall(expectedRequest))
        .thenReturn(ApiFutures.immediateFuture(expectedResponse));

    // Execute
    Policy actualResult =
        adminClient.setBackupIamPolicy(
            CLUSTER_ID,
            BACKUP_ID,
            Policy.newBuilder()
                .addIdentity(Role.of("bigtable.viewer"), Identity.user("someone@example.com"))
                .build());

    // Verify
    assertThat(actualResult)
        .isEqualTo(
            Policy.newBuilder()
                .addIdentity(Role.of("bigtable.viewer"), Identity.user("someone@example.com"))
                .setEtag(BaseEncoding.base64().encode("my-etag".getBytes()))
                .build());
  }

  @Test
  public void testTestIamPermissions() {
    // Setup
    Mockito.when(mockStub.testIamPermissionsCallable()).thenReturn(mockTestIamPermissionsCallable);

    com.google.iam.v1.TestIamPermissionsRequest expectedRequest =
        com.google.iam.v1.TestIamPermissionsRequest.newBuilder()
            .setResource(NameUtil.formatBackupName(PROJECT_ID, INSTANCE_ID, CLUSTER_ID, BACKUP_ID))
            .addPermissions("bigtable.backups.get")
            .build();

    com.google.iam.v1.TestIamPermissionsResponse expectedResponse =
        com.google.iam.v1.TestIamPermissionsResponse.newBuilder()
            .addPermissions("bigtable.backups.get")
            .build();

    Mockito.when(mockTestIamPermissionsCallable.futureCall(expectedRequest))
        .thenReturn(ApiFutures.immediateFuture(expectedResponse));

    // Execute
    List<String> actualResult =
        adminClient.testBackupIamPermission(CLUSTER_ID, BACKUP_ID, "bigtable.backups.get");

    // Verify
    assertThat(actualResult).containsExactly("bigtable.backups.get");
  }

  private <ReqT, RespT, MetaT> void mockOperationResult(
      OperationCallable<ReqT, RespT, MetaT> callable,
      ReqT request,
      RespT response,
      MetaT metadata) {
    OperationSnapshot operationSnapshot =
        FakeOperationSnapshot.newBuilder()
            .setDone(true)
            .setErrorCode(GrpcStatusCode.of(Code.OK))
            .setName("fake-name")
            .setResponse(response)
            .setMetadata(metadata)
            .build();
    OperationFuture<RespT, MetaT> operationFuture =
        OperationFutures.immediateOperationFuture(operationSnapshot);
    Mockito.when(callable.futureCall(request)).thenReturn(operationFuture);
  }
}
