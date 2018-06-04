package com.google.cloud.bigtable.admin.v2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.bigtable.admin.v2.CheckConsistencyRequest;
import com.google.bigtable.admin.v2.CheckConsistencyResponse;
import com.google.bigtable.admin.v2.DeleteTableRequest;
import com.google.bigtable.admin.v2.DropRowRangeRequest;
import com.google.bigtable.admin.v2.DropRowRangeRequest.Builder;
import com.google.bigtable.admin.v2.GenerateConsistencyTokenRequest;
import com.google.bigtable.admin.v2.GenerateConsistencyTokenResponse;
import com.google.bigtable.admin.v2.GetTableRequest;
import com.google.bigtable.admin.v2.InstanceName;
import com.google.bigtable.admin.v2.ListTablesRequest;
import com.google.bigtable.admin.v2.ListTablesResponse;
import com.google.bigtable.admin.v2.ModifyColumnFamiliesRequest;
import com.google.bigtable.admin.v2.Table;
import com.google.bigtable.admin.v2.TableName;
import com.google.cloud.bigtable.admin.v2.models.TableAdminRequests.CreateTable;
import com.google.cloud.bigtable.admin.v2.models.TableAdminRequests.ModifyFamilies;
import com.google.cloud.bigtable.admin.v2.stub.BigtableTableAdminStub;
import com.google.cloud.bigtable.admin.v2.stub.BigtableTableAdminStubSettings;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.protobuf.ByteString;
import com.google.protobuf.Empty;

public class TableAdminClient implements AutoCloseable {
  private final BigtableTableAdminStub stub;
  private final InstanceName instanceName;

  public static TableAdminClient create(InstanceName instanceName) throws IOException {
    return new TableAdminClient(instanceName, BigtableTableAdminSettings.newBuilder().build());
  }

  public static TableAdminClient create(InstanceName instanceName,
      BigtableTableAdminSettings adminSettings) throws IOException {
    return new TableAdminClient(instanceName, adminSettings);
  }

  public static TableAdminClient create(InstanceName instanceName, BigtableTableAdminStub stub)
      throws IOException {
    return new TableAdminClient(instanceName, stub);
  }

  public TableAdminClient(InstanceName instanceName, BigtableTableAdminSettings adminSettings)
      throws IOException {
    this(instanceName,
         ((BigtableTableAdminStubSettings) adminSettings.getStubSettings()).createStub());
  }

  public TableAdminClient(InstanceName instanceName, BigtableTableAdminStub stub)
      throws IOException {
    Preconditions.checkNotNull(instanceName);
    Preconditions.checkNotNull(stub);
    this.instanceName = instanceName;
    this.stub = stub;
  }

  @SuppressWarnings("unused")
  private BigtableTableAdminStub getTableAdminStub() {
    return stub;
  }

  public InstanceName getInstanceName() {
    return instanceName;
  }

  @Override
  public void close() throws Exception {
    stub.close();
  }

  public Table createTable(CreateTable createTable) {
    return this.stub.createTableCallable().call(createTable.toProto(instanceName.toString()));
  }

  public ApiFuture<Table> createTableAsync(CreateTable createTable) {
    return this.stub.createTableCallable().futureCall(createTable.toProto(instanceName.toString()));
  }

  public Table modifyFamilies(ModifyFamilies modifyFamily) {
    ModifyColumnFamiliesRequest modReq =
        modifyFamily.toProto(getUniqueTableName(modifyFamily.getTableId()));
    return this.stub.modifyColumnFamiliesCallable().call(modReq);
  }

  public ApiFuture<Table> modifyFamiliesAsync(ModifyFamilies modifyFamily) {
    ModifyColumnFamiliesRequest modReq =
        modifyFamily.toProto(getUniqueTableName(modifyFamily.getTableId()));
    return this.stub.modifyColumnFamiliesCallable().futureCall(modReq);
  }

  public void deleteTable(String tableId) {
    this.stub.deleteTableCallable().call(getDeleteTableRequest(tableId));
  }

  public ApiFuture<Empty> deleteTableAsync(String tableId) {
    return this.stub.deleteTableCallable().futureCall(getDeleteTableRequest(tableId));
  }

  public Table getTable(String tableId) {
    return this.stub.getTableCallable().call(getGetTableRequest(tableId));
  }

  public ApiFuture<Table> getTableAsync(String tableId) {
    return this.stub.getTableCallable().futureCall(getGetTableRequest(tableId));
  }

  public List<TableName> listTables() {
    ListTablesResponse listResp = this.stub.listTablesCallable().call(getListTableRequest());
    return convert(listResp);
  }

  public ApiFuture<List<TableName>> listTablesAsync() {
    ApiFuture<ListTablesResponse> listResp =
        this.stub.listTablesCallable().futureCall(getListTableRequest());

    return ApiFutures.transform(listResp, new ApiFunction<ListTablesResponse, List<TableName>>() {
      @Override
      public List<TableName> apply(ListTablesResponse input) {
        return convert(input);
      }
    });
  }

  /**
   * Drops rows by prefix. If prefix is "*" drops all data
   * 
   * @param tableId
   * @param rowKeyPrefix
   */
  public void dropRowRange(String tableId, String rowKeyPrefix) {
    this.stub.dropRowRangeCallable().call(getDropRowRangeRequest(tableId, rowKeyPrefix));
  }

  public ApiFuture<Empty> dropRowRangeAsync(String tableId, String rowKeyPrefix) {
    return this.stub.dropRowRangeCallable()
                    .futureCall(getDropRowRangeRequest(tableId, rowKeyPrefix));
  }

  public String GenerateConsistencyToken(String tableId) {
    return this.stub.generateConsistencyTokenCallable().call(getGenConsistencyToken(tableId))
                    .getConsistencyToken();
  }

  public ApiFuture<String> generateConsistencyTokenAsync(String tableId) {
    ApiFuture<GenerateConsistencyTokenResponse> tokenResp =
        this.stub.generateConsistencyTokenCallable().futureCall(getGenConsistencyToken(tableId));

    return ApiFutures.transform(tokenResp,
        new ApiFunction<GenerateConsistencyTokenResponse, String>() {
          @Override
          public String apply(GenerateConsistencyTokenResponse input) {
            return input.getConsistencyToken();
          }
        });
  }

  public boolean isConsistent(String tableId, String token) {
    return stub.checkConsistencyCallable().call(getCheckConsistencyRequest(tableId, token))
               .getConsistent();
  }

  public ApiFuture<Boolean> isConsistentAsync(String tableId, String token) {
    ApiFuture<CheckConsistencyResponse> CheckConsResp =
        stub.checkConsistencyCallable().futureCall(getCheckConsistencyRequest(tableId, token));

    return ApiFutures.transform(CheckConsResp,
        new ApiFunction<CheckConsistencyResponse, Boolean>() {
          @Override
          public Boolean apply(CheckConsistencyResponse input) {
            return input.getConsistent();
          }
        });
  }

  @VisibleForTesting
  String getUniqueTableName(String tableId) {
    return TableName.of(instanceName.getProject(), instanceName.getInstance(), tableId).toString();
  }

  @VisibleForTesting
  ListTablesRequest getListTableRequest() {
    return ListTablesRequest.newBuilder().setParent(instanceName.toString()).build();
  }

  @VisibleForTesting
  GetTableRequest getGetTableRequest(String tableId) {
    return GetTableRequest.newBuilder().setName(getUniqueTableName(tableId)).build();
  }

  @VisibleForTesting
  DeleteTableRequest getDeleteTableRequest(String tableId) {
    return DeleteTableRequest.newBuilder().setName(getUniqueTableName(tableId)).build();
  }

  @VisibleForTesting
  DropRowRangeRequest getDropRowRangeRequest(String tableId, String rowKeyPrefix) {
    Builder dropRowReq = DropRowRangeRequest.newBuilder().setName(getUniqueTableName(tableId));

    // TODO: verify if Utf8String and ByteString are equivalent
    // and if using "*" prefix as special case to invoke deletAll approach is reasonable
    if ("*".equals(rowKeyPrefix)) {
      dropRowReq.setDeleteAllDataFromTable(true);
    } else {
      dropRowReq.setRowKeyPrefix(ByteString.copyFromUtf8(rowKeyPrefix));
    }
    return dropRowReq.build();
  }

  @VisibleForTesting
  GenerateConsistencyTokenRequest getGenConsistencyToken(String tableId) {
    return GenerateConsistencyTokenRequest.newBuilder().setName(getUniqueTableName(tableId))
                                          .build();
  }

  @VisibleForTesting
  CheckConsistencyRequest getCheckConsistencyRequest(String tableId, String token) {
    return CheckConsistencyRequest.newBuilder().setName(getUniqueTableName(tableId))
                                  .setConsistencyToken(token).build();
  }

  @VisibleForTesting
  static List<TableName> convert(ListTablesResponse listTablesResponse) {
    List<TableName> tableNames = new ArrayList<>();

    for (Table table : listTablesResponse.getTablesList()) {
      tableNames.add(TableName.parse(table.getName()));
    }
    return tableNames;
  }
}
