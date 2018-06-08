/*
 * Copyright 2018 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
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
import com.google.cloud.bigtable.admin.v2.models.TableAdminResponses;
import com.google.cloud.bigtable.admin.v2.models.TableAdminResponses.TableResponse;
import com.google.cloud.bigtable.admin.v2.stub.BigtableTableAdminStub;
import com.google.cloud.bigtable.admin.v2.stub.BigtableTableAdminStubSettings;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.protobuf.ByteString;
import com.google.protobuf.Empty;

/** Table admin client for creating and configuring Bigtable tables. */
public class TableAdminClient implements AutoCloseable {
  private final BigtableTableAdminStub stub;
  private final InstanceName instanceName;

  public static TableAdminClient create(InstanceName instanceName) throws IOException {
    return new TableAdminClient(instanceName, BigtableTableAdminSettings.newBuilder().build());
  }

  public static TableAdminClient create(
      InstanceName instanceName, BigtableTableAdminSettings adminSettings) throws IOException {
    return new TableAdminClient(instanceName, adminSettings);
  }

  public static TableAdminClient create(InstanceName instanceName, BigtableTableAdminStub stub)
      throws IOException {
    return new TableAdminClient(instanceName, stub);
  }

  private TableAdminClient(InstanceName instanceName, BigtableTableAdminSettings adminSettings)
      throws IOException {
    this(
        instanceName,
        ((BigtableTableAdminStubSettings) adminSettings.getStubSettings()).createStub());
  }

  private TableAdminClient(InstanceName instanceName, BigtableTableAdminStub stub)
      throws IOException {
    Preconditions.checkNotNull(instanceName);
    Preconditions.checkNotNull(stub);
    this.instanceName = instanceName;
    this.stub = stub;
  }

  public InstanceName getInstanceName() {
    return instanceName;
  }

  @Override
  public void close() throws Exception {
    stub.close();
  }

  public TableResponse createTable(CreateTable createTable) {
    Table table = this.stub.createTableCallable().call(createTable.toProto(instanceName));
    return TableAdminResponses.convertTable(table);
  }

  public ApiFuture<TableResponse> createTableAsync(CreateTable createTable) {
    return transformToTableResponse(
        this.stub.createTableCallable().futureCall(createTable.toProto(instanceName)));
  }

  public TableResponse modifyFamilies(ModifyFamilies modifyFamily) {
    ModifyColumnFamiliesRequest modReq =
        modifyFamily.toProto(getTableName(modifyFamily.getTableId()));
    Table table = this.stub.modifyColumnFamiliesCallable().call(modReq);
    return TableAdminResponses.convertTable(table);
  }

  public ApiFuture<TableResponse> modifyFamiliesAsync(ModifyFamilies modifyFamily) {
    ModifyColumnFamiliesRequest modReq =
        modifyFamily.toProto(getTableName(modifyFamily.getTableId()));
    return transformToTableResponse(this.stub.modifyColumnFamiliesCallable().futureCall(modReq));
  }

  public void deleteTable(String tableId) {
    this.stub.deleteTableCallable().call(composeDeleteTableRequest(tableId));
  }

  public ApiFuture<Void> deleteTableAsync(String tableId) {
    return transformToVoid(
        this.stub.deleteTableCallable().futureCall(composeDeleteTableRequest(tableId)));
  }

  public TableResponse getTable(String tableId) {
    Table table = this.stub.getTableCallable().call(composeGetTableRequest(tableId));
    return TableAdminResponses.convertTable(table);
  }

  public ApiFuture<TableResponse> getTableAsync(String tableId) {
    return transformToTableResponse(
        this.stub.getTableCallable().futureCall(composeGetTableRequest(tableId)));
  }

  public List<TableName> listTables() {
    ListTablesResponse listResp = this.stub.listTablesCallable().call(composeListTableRequest());
    return convertToTableNames(listResp);
  }

  public ApiFuture<List<TableName>> listTablesAsync() {
    ApiFuture<ListTablesResponse> listResp =
        this.stub.listTablesCallable().futureCall(composeListTableRequest());

    return ApiFutures.transform(
        listResp,
        new ApiFunction<ListTablesResponse, List<TableName>>() {
          @Override
          public List<TableName> apply(ListTablesResponse input) {
            return convertToTableNames(input);
          }
        });
  }

  public void dropRowRange(String tableId, String rowKeyPrefix) {
    dropRowRange(tableId, ByteString.copyFromUtf8(rowKeyPrefix));
  }

  public ApiFuture<Void> dropRowRangeAsync(String tableId, String rowKeyPrefix) {
    return dropRowRangeAsync(tableId, ByteString.copyFromUtf8(rowKeyPrefix));
  }

  public void dropAllData(String tableId) {
    this.stub.dropRowRangeCallable().call(composeDropRowRangeRequest(tableId, null, true));
  }

  public ApiFuture<Void> dropAllDataAsync(String tableId) {
    return transformToVoid(
        this.stub
            .dropRowRangeCallable()
            .futureCall(composeDropRowRangeRequest(tableId, null, true)));
  }

  public void dropRowRange(String tableId, ByteString rowKeyPrefix) {
    this.stub.dropRowRangeCallable().call(composeDropRowRangeRequest(tableId, rowKeyPrefix, false));
  }

  public ApiFuture<Void> dropRowRangeAsync(String tableId, ByteString rowKeyPrefix) {
    return transformToVoid(
        this.stub
            .dropRowRangeCallable()
            .futureCall(composeDropRowRangeRequest(tableId, rowKeyPrefix, false)));
  }

  public String generateConsistencyToken(String tableId) {
    return this.stub
        .generateConsistencyTokenCallable()
        .call(composeGenerateConsistencyTokenRequest(tableId))
        .getConsistencyToken();
  }

  public ApiFuture<String> generateConsistencyTokenAsync(String tableId) {
    ApiFuture<GenerateConsistencyTokenResponse> tokenResp =
        this.stub
            .generateConsistencyTokenCallable()
            .futureCall(composeGenerateConsistencyTokenRequest(tableId));

    return ApiFutures.transform(
        tokenResp,
        new ApiFunction<GenerateConsistencyTokenResponse, String>() {
          @Override
          public String apply(GenerateConsistencyTokenResponse input) {
            return input.getConsistencyToken();
          }
        });
  }

  public boolean isConsistent(String tableId, String token) {
    return stub.checkConsistencyCallable()
        .call(composeCheckConsistencyRequest(tableId, token))
        .getConsistent();
  }

  public ApiFuture<Boolean> isConsistentAsync(String tableId, String token) {
    ApiFuture<CheckConsistencyResponse> CheckConsResp =
        stub.checkConsistencyCallable().futureCall(composeCheckConsistencyRequest(tableId, token));

    return ApiFutures.transform(
        CheckConsResp,
        new ApiFunction<CheckConsistencyResponse, Boolean>() {
          @Override
          public Boolean apply(CheckConsistencyResponse input) {
            return input.getConsistent();
          }
        });
  }

  @VisibleForTesting
  String getTableName(String tableId) {
    return TableName.of(instanceName.getProject(), instanceName.getInstance(), tableId).toString();
  }

  @VisibleForTesting
  ListTablesRequest composeListTableRequest() {
    return ListTablesRequest.newBuilder().setParent(instanceName.toString()).build();
  }

  @VisibleForTesting
  GetTableRequest composeGetTableRequest(String tableId) {
    return GetTableRequest.newBuilder().setName(getTableName(tableId)).build();
  }

  @VisibleForTesting
  DeleteTableRequest composeDeleteTableRequest(String tableId) {
    return DeleteTableRequest.newBuilder().setName(getTableName(tableId)).build();
  }

  @VisibleForTesting
  DropRowRangeRequest composeDropRowRangeRequest(
      String tableId, ByteString rowKeyPrefix, boolean dropAll) {
    Builder dropRowReq = DropRowRangeRequest.newBuilder().setName(getTableName(tableId));

    if (dropAll) {
      dropRowReq.setDeleteAllDataFromTable(true);
    } else {
      dropRowReq.setRowKeyPrefix(rowKeyPrefix);
    }
    return dropRowReq.build();
  }

  @VisibleForTesting
  GenerateConsistencyTokenRequest composeGenerateConsistencyTokenRequest(String tableId) {
    return GenerateConsistencyTokenRequest.newBuilder().setName(getTableName(tableId)).build();
  }

  @VisibleForTesting
  CheckConsistencyRequest composeCheckConsistencyRequest(String tableId, String token) {
    return CheckConsistencyRequest.newBuilder()
        .setName(getTableName(tableId))
        .setConsistencyToken(token)
        .build();
  }

  @VisibleForTesting
  static List<TableName> convertToTableNames(ListTablesResponse listTablesResponse) {
    List<TableName> tableNames = new ArrayList<>();

    for (Table table : listTablesResponse.getTablesList()) {
      tableNames.add(TableName.parse(table.getName()));
    }
    return tableNames;
  }

  @VisibleForTesting
  static ApiFuture<TableResponse> transformToTableResponse(ApiFuture<Table> future) {
    return ApiFutures.transform(
        future,
        new ApiFunction<Table, TableResponse>() {
          @Override
          public TableResponse apply(Table table) {
            return TableAdminResponses.convertTable(table);
          }
        });
  }

  @VisibleForTesting
  static ApiFuture<Void> transformToVoid(ApiFuture<Empty> future) {
    return ApiFutures.transform(
        future,
        new ApiFunction<Empty, Void>() {
          @Override
          public Void apply(Empty empty) {
            return null;
          }
        });
  }
}
