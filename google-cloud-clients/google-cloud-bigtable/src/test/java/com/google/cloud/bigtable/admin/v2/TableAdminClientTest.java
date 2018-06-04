package com.google.cloud.bigtable.admin.v2;

import org.junit.Before;
import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
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
import com.google.cloud.bigtable.admin.v2.models.TableAdminRequests;
import com.google.cloud.bigtable.admin.v2.models.TableAdminRequests.CreateTable;
import com.google.cloud.bigtable.admin.v2.models.TableAdminRequests.ModifyFamilies;
import com.google.cloud.bigtable.admin.v2.stub.BigtableTableAdminStub;
import com.google.protobuf.ByteString;
import com.google.protobuf.Empty;

@RunWith(MockitoJUnitRunner.class)
public class TableAdminClientTest {
  private TableAdminClient adminClient;
  @Mock
  private BigtableTableAdminStub mockStub;

  @Mock
  private UnaryCallable<CreateTableRequest, Table> mockCreateTableCallable;
  @Mock
  private UnaryCallable<ModifyColumnFamiliesRequest, Table> mockModifyTableCallable;
  @Mock
  private UnaryCallable<DeleteTableRequest, Empty> mockDeleteTableCallable;
  @Mock
  private UnaryCallable<GetTableRequest, Table> mockGetTableCallable;
  @Mock
  private UnaryCallable<ListTablesRequest, ListTablesResponse> mockListTableCallable;
  @Mock
  private UnaryCallable<DropRowRangeRequest, Empty> mockDropRowRangeCallable;
  @Mock
  private UnaryCallable<GenerateConsistencyTokenRequest, GenerateConsistencyTokenResponse> mockGenerateConsistencyTokenCallable;
  @Mock
  private UnaryCallable<CheckConsistencyRequest, CheckConsistencyResponse> mockCheckConsistencyCallable;

  @Before
  public void setUp() throws Exception {
    adminClient = new TableAdminClient(InstanceName.of("[PROJECT]", "[INSTANCE]"), mockStub);

    Mockito.when(mockStub.createTableCallable()).thenReturn(mockCreateTableCallable);
    Mockito.when(mockStub.modifyColumnFamiliesCallable()).thenReturn(mockModifyTableCallable);
    Mockito.when(mockStub.deleteTableCallable()).thenReturn(mockDeleteTableCallable);
    Mockito.when(mockStub.getTableCallable()).thenReturn(mockGetTableCallable);
    Mockito.when(mockStub.listTablesCallable()).thenReturn(mockListTableCallable);
    Mockito.when(mockStub.dropRowRangeCallable()).thenReturn(mockDropRowRangeCallable);
    Mockito.when(mockStub.generateConsistencyTokenCallable())
           .thenReturn(mockGenerateConsistencyTokenCallable);
    Mockito.when(mockStub.checkConsistencyCallable()).thenReturn(mockCheckConsistencyCallable);
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
           .call(createTableReq.toProto(adminClient.getInstanceName().toString()));
  }

  @Test
  public void createTableAsync() {
    CreateTable createTableReq = TableAdminRequests.createTable("tableId");
    adminClient.createTableAsync(createTableReq);
    Mockito.verify(mockCreateTableCallable)
           .futureCall(createTableReq.toProto(adminClient.getInstanceName().toString()));
  }

  @Test
  public void modifyFamilies() {
    ModifyFamilies modifyFamReq = TableAdminRequests.modifyFamilies("tableId");
    adminClient.modifyFamilies(modifyFamReq);
    Mockito.verify(mockModifyTableCallable)
           .call(modifyFamReq.toProto(adminClient.getUniqueTableName("tableId")));
  }

  @Test
  public void modifyFamiliesAsync() {
    ModifyFamilies modifyFamReq = TableAdminRequests.modifyFamilies("tableId");
    adminClient.modifyFamiliesAsync(modifyFamReq);
    Mockito.verify(mockModifyTableCallable)
           .futureCall(modifyFamReq.toProto(adminClient.getUniqueTableName("tableId")));
  }

  @Test
  public void deleteTable() {
    adminClient.deleteTable("tableId");
    Mockito.verify(mockDeleteTableCallable).call(adminClient.getDeleteTableRequest("tableId"));
  }

  @Test
  public void deleteTableAsync() {
    adminClient.deleteTableAsync("tableId");
    Mockito.verify(mockDeleteTableCallable)
           .futureCall(adminClient.getDeleteTableRequest("tableId"));
  }

  @Test
  public void getTable() {
    adminClient.getTable("tableId");
    Mockito.verify(mockGetTableCallable).call(adminClient.getGetTableRequest("tableId"));
  }

  @Test
  public void getTableAsync() {
    adminClient.getTableAsync("tableId");
    Mockito.verify(mockGetTableCallable).futureCall(adminClient.getGetTableRequest("tableId"));
  }

  @Test
  public void listTables() {
    ListTablesResponse listTablesResponse = ListTablesResponse.newBuilder().build();
    Mockito.when(mockListTableCallable.call(adminClient.getListTableRequest()))
           .thenReturn(listTablesResponse);

    adminClient.listTables();
    Mockito.verify(mockListTableCallable).call(adminClient.getListTableRequest());
  }

  @Test
  public void listTablesAsync() {
    ApiFuture<ListTablesResponse> listTablesResponse =
        ApiFutures.immediateFuture(ListTablesResponse.newBuilder().build());
    Mockito.when(mockListTableCallable.futureCall(adminClient.getListTableRequest()))
           .thenReturn(listTablesResponse);

    adminClient.listTablesAsync();
    Mockito.verify(mockListTableCallable).futureCall(adminClient.getListTableRequest());
  }

  @Test
  public void dropRowRange() {
    adminClient.dropRowRange("tableId", "rowKeyPrefix");
    Mockito.verify(mockDropRowRangeCallable)
           .call(adminClient.getDropRowRangeRequest("tableId", "rowKeyPrefix"));
  }

  @Test
  public void getDropRowRangeRequest() {
    DropRowRangeRequest actual = adminClient.getDropRowRangeRequest("tableId", "rowKeyPrefix");
        
    DropRowRangeRequest expected = DropRowRangeRequest.newBuilder()
      .setName(adminClient.getUniqueTableName("tableId"))
      .setRowKeyPrefix(ByteString.copyFromUtf8("rowKeyPrefix"))
      .build();
    
    assertThat(actual).isEqualTo(expected);
  }

  @Test
  public void getDropRowRangeRequest_dropAllData() {
    DropRowRangeRequest actual = adminClient.getDropRowRangeRequest("tableId", "*");
        
    DropRowRangeRequest expected = DropRowRangeRequest.newBuilder()
      .setName(adminClient.getUniqueTableName("tableId"))
      .setDeleteAllDataFromTable(true)
      .build();
    
    assertThat(actual).isEqualTo(expected);
  }

  @Test
  public void dropRowRangeAsync() {
    adminClient.dropRowRangeAsync("tableId", "rowKeyPrefix");
    Mockito.verify(mockDropRowRangeCallable)
           .futureCall(adminClient.getDropRowRangeRequest("tableId", "rowKeyPrefix"));
  }

  @Test
  public void GenerateConsistencyToken() {
    GenerateConsistencyTokenResponse genResp =
        GenerateConsistencyTokenResponse.newBuilder().build();
    Mockito.when(
        mockGenerateConsistencyTokenCallable.call(adminClient.getGenConsistencyToken("tableId")))
           .thenReturn(genResp);

    adminClient.GenerateConsistencyToken("tableId");
    Mockito.verify(mockGenerateConsistencyTokenCallable)
           .call(adminClient.getGenConsistencyToken("tableId"));
  }

  @Test
  public void GenerateConsistencyTokenAsync() {
    ApiFuture<GenerateConsistencyTokenResponse> genResp =
        ApiFutures.immediateFuture(GenerateConsistencyTokenResponse.newBuilder().build());
    Mockito.when(mockGenerateConsistencyTokenCallable.futureCall(
        adminClient.getGenConsistencyToken("tableId"))).thenReturn(genResp);

    adminClient.generateConsistencyTokenAsync("tableId");
    Mockito.verify(mockGenerateConsistencyTokenCallable)
           .futureCall(adminClient.getGenConsistencyToken("tableId"));

  }

  @Test
  public void isConsistent() {
    CheckConsistencyResponse consistencyResp = CheckConsistencyResponse.newBuilder().build();
    Mockito.when(mockCheckConsistencyCallable.call(
        adminClient.getCheckConsistencyRequest("tableId", "token"))).thenReturn(consistencyResp);

    adminClient.isConsistent("tableId", "token");
    Mockito.verify(mockCheckConsistencyCallable)
           .call(adminClient.getCheckConsistencyRequest("tableId", "token"));
  }

  @Test
  public void isConsistentAsync() {
    ApiFuture<CheckConsistencyResponse> consistencyResp =
        ApiFutures.immediateFuture(CheckConsistencyResponse.newBuilder().build());
    Mockito.when(mockCheckConsistencyCallable.futureCall(
        adminClient.getCheckConsistencyRequest("tableId", "token"))).thenReturn(consistencyResp);

    adminClient.isConsistentAsync("tableId", "token");
    Mockito.verify(mockCheckConsistencyCallable)
           .futureCall(adminClient.getCheckConsistencyRequest("tableId", "token"));
  }

  @Test
  public void convert() {
    ListTablesResponse listTablesResponse =
        ListTablesResponse.newBuilder()
                          .addTables(Table.newBuilder().setName("projects/p/instances/i/tables/t1"))
                          .addTables(Table.newBuilder().setName("projects/p/instances/i/tables/t2"))
                          .build();

    assertEquals(2, TableAdminClient.convert(listTablesResponse).size());

    listTablesResponse = ListTablesResponse.newBuilder().build();
    assertEquals(0, TableAdminClient.convert(listTablesResponse).size());
  }
}

