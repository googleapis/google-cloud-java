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
import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.bigtable.admin.v2.CheckConsistencyRequest;
import com.google.bigtable.admin.v2.CheckConsistencyResponse;
import com.google.bigtable.admin.v2.CreateTableRequest;
import com.google.bigtable.admin.v2.DeleteTableRequest;
import com.google.bigtable.admin.v2.DropRowRangeRequest;
import com.google.bigtable.admin.v2.GenerateConsistencyTokenRequest;
import com.google.bigtable.admin.v2.GenerateConsistencyTokenResponse;
import com.google.bigtable.admin.v2.GetTableRequest;
import com.google.bigtable.admin.v2.InstanceName;
import com.google.bigtable.admin.v2.ListTablesRequest;
import com.google.bigtable.admin.v2.ListTablesResponse;
import com.google.bigtable.admin.v2.ModifyColumnFamiliesRequest;
import com.google.bigtable.admin.v2.Table;
import com.google.bigtable.admin.v2.TableName;
import com.google.cloud.bigtable.admin.v2.models.TableAdminRequests;
import com.google.cloud.bigtable.admin.v2.models.TableAdminRequests.CreateTable;
import com.google.cloud.bigtable.admin.v2.models.TableAdminRequests.ModifyFamilies;
import com.google.cloud.bigtable.admin.v2.models.TableAdminResponses.ConsistencyToken;
import com.google.cloud.bigtable.admin.v2.stub.BigtableTableAdminStub;
import com.google.protobuf.ByteString;
import com.google.protobuf.Empty;

@RunWith(MockitoJUnitRunner.class)
public class TableAdminClientTest {
  private TableAdminClient adminClient;
  @Mock private BigtableTableAdminStub mockStub;

  @Mock private UnaryCallable<CreateTableRequest, Table> mockCreateTableCallable;
  @Mock private UnaryCallable<ModifyColumnFamiliesRequest, Table> mockModifyTableCallable;
  @Mock private UnaryCallable<DeleteTableRequest, Empty> mockDeleteTableCallable;
  @Mock private UnaryCallable<GetTableRequest, Table> mockGetTableCallable;
  @Mock private UnaryCallable<ListTablesRequest, ListTablesResponse> mockListTableCallable;
  @Mock private UnaryCallable<DropRowRangeRequest, Empty> mockDropRowRangeCallable;

  @Mock
  private UnaryCallable<GenerateConsistencyTokenRequest, GenerateConsistencyTokenResponse>
      mockGenerateConsistencyTokenCallable;

  @Mock
  private UnaryCallable<CheckConsistencyRequest, CheckConsistencyResponse>
      mockCheckConsistencyCallable;

  @Before
  public void setUp() throws Exception {
    adminClient = TableAdminClient.create(InstanceName.of("[PROJECT]", "[INSTANCE]"), mockStub);

    Mockito.when(mockStub.createTableCallable()).thenReturn(mockCreateTableCallable);
    Mockito.when(mockStub.modifyColumnFamiliesCallable()).thenReturn(mockModifyTableCallable);
    Mockito.when(mockStub.deleteTableCallable()).thenReturn(mockDeleteTableCallable);
    Mockito.when(mockStub.getTableCallable()).thenReturn(mockGetTableCallable);
    Mockito.when(mockStub.listTablesCallable()).thenReturn(mockListTableCallable);
    Mockito.when(mockStub.dropRowRangeCallable()).thenReturn(mockDropRowRangeCallable);
    Mockito.when(mockStub.generateConsistencyTokenCallable())
        .thenReturn(mockGenerateConsistencyTokenCallable);
    Mockito.when(mockStub.checkConsistencyCallable()).thenReturn(mockCheckConsistencyCallable);

    Table table = Table.newBuilder().build();
    ApiFuture<Table> futureTable = ApiFutures.immediateFuture(table);
    Mockito.when(mockCreateTableCallable.call(any(CreateTableRequest.class))).thenReturn(table);
    Mockito.when(mockCreateTableCallable.futureCall(any(CreateTableRequest.class)))
        .thenReturn(futureTable);
    Mockito.when(mockModifyTableCallable.call(any(ModifyColumnFamiliesRequest.class)))
        .thenReturn(table);
    Mockito.when(mockModifyTableCallable.futureCall(any(ModifyColumnFamiliesRequest.class)))
        .thenReturn(futureTable);
    Mockito.when(mockGetTableCallable.call(any(GetTableRequest.class))).thenReturn(table);
    Mockito.when(mockGetTableCallable.futureCall(any(GetTableRequest.class)))
        .thenReturn(futureTable);
  }

  @Test
  public void close() throws Exception {
    adminClient.close();
    Mockito.verify(mockStub).close();
  }

  @Test
  public void createTable() {
    CreateTable createTableReq = TableAdminRequests.createTable("tableId");
    adminClient.createTable(createTableReq);
    Mockito.verify(mockCreateTableCallable)
        .call(createTableReq.toProto(adminClient.getInstanceName()));
  }

  @Test
  public void createTableAsync() {
    CreateTable createTableReq = TableAdminRequests.createTable("tableId");
    adminClient.createTableAsync(createTableReq);
    Mockito.verify(mockCreateTableCallable)
        .futureCall(createTableReq.toProto(adminClient.getInstanceName()));
  }

  @Test
  public void modifyFamilies() {
    ModifyFamilies modifyFamReq = TableAdminRequests.modifyFamilies("tableId");
    adminClient.modifyFamilies(modifyFamReq);
    Mockito.verify(mockModifyTableCallable)
        .call(modifyFamReq.toProto(adminClient.getInstanceName()));
  }

  @Test
  public void modifyFamiliesAsync() {
    ModifyFamilies modifyFamReq = TableAdminRequests.modifyFamilies("tableId");
    adminClient.modifyFamiliesAsync(modifyFamReq);
    Mockito.verify(mockModifyTableCallable)
        .futureCall(modifyFamReq.toProto(adminClient.getInstanceName()));
  }

  @Test
  public void deleteTable() {
    adminClient.deleteTable("tableId");
    Mockito.verify(mockDeleteTableCallable).call(adminClient.composeDeleteTableRequest("tableId"));
  }

  @Test
  public void deleteTableAsync() {
    ApiFuture<Empty> empty = ApiFutures.immediateFuture(Empty.newBuilder().build());
    Mockito.when(mockDeleteTableCallable.futureCall(any(DeleteTableRequest.class)))
        .thenReturn(empty);

    adminClient.deleteTableAsync("tableId");
    Mockito.verify(mockDeleteTableCallable)
        .futureCall(adminClient.composeDeleteTableRequest("tableId"));
  }

  @Test
  public void getTable() {
    adminClient.getTable("tableId");
    Mockito.verify(mockGetTableCallable).call(adminClient.composeGetTableRequest("tableId"));
  }

  @Test
  public void getTableAsync() {
    adminClient.getTableAsync("tableId");
    Mockito.verify(mockGetTableCallable).futureCall(adminClient.composeGetTableRequest("tableId"));
  }

  @Test
  public void listTables() {
    ListTablesResponse listTablesResponse = ListTablesResponse.newBuilder().build();
    Mockito.when(mockListTableCallable.call(adminClient.composeListTableRequest()))
        .thenReturn(listTablesResponse);

    adminClient.listTables();
    Mockito.verify(mockListTableCallable).call(adminClient.composeListTableRequest());
  }

  @Test
  public void listTablesAsync() {
    ApiFuture<ListTablesResponse> listTablesResponse =
        ApiFutures.immediateFuture(ListTablesResponse.newBuilder().build());
    Mockito.when(mockListTableCallable.futureCall(adminClient.composeListTableRequest()))
        .thenReturn(listTablesResponse);

    adminClient.listTablesAsync();
    Mockito.verify(mockListTableCallable).futureCall(adminClient.composeListTableRequest());
  }

  @Test
  public void dropRowRange() {
    adminClient.dropRowRange("tableId", "rowKeyPrefix");
    Mockito.verify(mockDropRowRangeCallable)
        .call(
            adminClient.composeDropRowRangeRequest(
                "tableId", ByteString.copyFromUtf8("rowKeyPrefix"), false));
  }

  @Test
  public void getDropRowRangeRequest() {
    DropRowRangeRequest actual =
        adminClient.composeDropRowRangeRequest(
            "tableId", ByteString.copyFromUtf8("rowKeyPrefix"), false);

    DropRowRangeRequest expected =
        DropRowRangeRequest.newBuilder()
            .setName(adminClient.getTableName("tableId"))
            .setRowKeyPrefix(ByteString.copyFromUtf8("rowKeyPrefix"))
            .build();

    assertThat(actual).isEqualTo(expected);
  }

  @Test
  public void getDropRowRangeRequestDropAllData() {
    DropRowRangeRequest actual = adminClient.composeDropRowRangeRequest("tableId", null, true);

    DropRowRangeRequest expected =
        DropRowRangeRequest.newBuilder()
            .setName(adminClient.getTableName("tableId"))
            .setDeleteAllDataFromTable(true)
            .build();

    assertThat(actual).isEqualTo(expected);
  }

  @Test
  public void dropRowRangeAsync() {
    ApiFuture<Empty> empty = ApiFutures.immediateFuture(Empty.newBuilder().build());
    Mockito.when(mockDropRowRangeCallable.futureCall(any(DropRowRangeRequest.class)))
        .thenReturn(empty);

    adminClient.dropRowRangeAsync("tableId", "rowKeyPrefix");
    Mockito.verify(mockDropRowRangeCallable)
        .futureCall(
            adminClient.composeDropRowRangeRequest(
                "tableId", ByteString.copyFromUtf8("rowKeyPrefix"), false));
  }

  @Test
  public void generateAndCheckConsistency() {
    GenerateConsistencyTokenResponse genResp =
        GenerateConsistencyTokenResponse.newBuilder().build();
    Mockito.when(
            mockGenerateConsistencyTokenCallable.call(
                adminClient.composeGenerateConsistencyTokenRequest("tableId")))
        .thenReturn(genResp);

    ConsistencyToken consistencyToken = adminClient.generateConsistencyToken("tableId");
    Mockito.verify(mockGenerateConsistencyTokenCallable)
        .call(adminClient.composeGenerateConsistencyTokenRequest("tableId"));

    ArgumentCaptor<CheckConsistencyRequest> requestCaptor =
        ArgumentCaptor.forClass(CheckConsistencyRequest.class);
    CheckConsistencyResponse consistencyResp = CheckConsistencyResponse.newBuilder().build();
    Mockito.when(mockCheckConsistencyCallable.call(any(CheckConsistencyRequest.class)))
        .thenReturn(consistencyResp);

    adminClient.isConsistent("tableId", consistencyToken);
    Mockito.verify(mockCheckConsistencyCallable).call(requestCaptor.capture());
  }

  @Test
  public void generateAndCheckConsistencyAsync() throws Exception {
    ApiFuture<GenerateConsistencyTokenResponse> genResp =
        ApiFutures.immediateFuture(GenerateConsistencyTokenResponse.newBuilder().build());
    Mockito.when(
            mockGenerateConsistencyTokenCallable.futureCall(
                adminClient.composeGenerateConsistencyTokenRequest("tableId")))
        .thenReturn(genResp);

    ApiFuture<ConsistencyToken> consistencyTokenFuture =
        adminClient.generateConsistencyTokenAsync("tableId");
    Mockito.verify(mockGenerateConsistencyTokenCallable)
        .futureCall(adminClient.composeGenerateConsistencyTokenRequest("tableId"));

    ArgumentCaptor<CheckConsistencyRequest> requestCaptor =
        ArgumentCaptor.forClass(CheckConsistencyRequest.class);
    ApiFuture<CheckConsistencyResponse> consistencyResp =
        ApiFutures.immediateFuture(CheckConsistencyResponse.newBuilder().build());
    Mockito.when(mockCheckConsistencyCallable.futureCall(any(CheckConsistencyRequest.class)))
        .thenReturn(consistencyResp);

    adminClient.isConsistentAsync("tableId", consistencyTokenFuture.get());
    Mockito.verify(mockCheckConsistencyCallable).futureCall(requestCaptor.capture());
  }

  @Test
  public void convertToTableNames() {
    ListTablesResponse listTablesResponse =
        ListTablesResponse.newBuilder()
            .addTables(Table.newBuilder().setName("projects/p/instances/i/tables/t1"))
            .addTables(Table.newBuilder().setName("projects/p/instances/i/tables/t2"))
            .build();

    List<TableName> tableNames = TableAdminClient.convertToTableNames(listTablesResponse);
    assertEquals(2, tableNames.size());
    assertEquals("projects/p/instances/i/tables/t1", tableNames.get(0).toString());
    assertEquals("projects/p/instances/i/tables/t2", tableNames.get(1).toString());

    listTablesResponse = ListTablesResponse.newBuilder().build();
    assertEquals(0, TableAdminClient.convertToTableNames(listTablesResponse).size());
  }
}
