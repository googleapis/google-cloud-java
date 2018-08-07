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

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
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
import com.google.bigtable.admin.v2.TableName;
import com.google.cloud.bigtable.admin.v2.models.TableAdminRequests.CreateTable;
import com.google.cloud.bigtable.admin.v2.models.TableAdminRequests.ModifyFamilies;
import com.google.cloud.bigtable.admin.v2.models.TableAdminResponses;
import com.google.cloud.bigtable.admin.v2.models.TableAdminResponses.ConsistencyToken;
import com.google.cloud.bigtable.admin.v2.models.TableAdminResponses.Table;
import com.google.cloud.bigtable.admin.v2.stub.BigtableTableAdminStub;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.protobuf.ByteString;
import com.google.protobuf.Empty;
import javax.annotation.Nonnull;

/**
 * Client for creating, configuring, and deleting Cloud Bigtable tables
 *
 * <p>Provides access to the table schemas only, not the data stored within the tables.
 *
 * <p>See the individual methods for example code.
 *
 * <p>Sample code to get started:
 *
 * <pre>{@code
 * try(TableAdminClient client =  TableAdminClient.create(InstanceName.of("[PROJECT]", "[INSTANCE]"))) {
 *   CreateTable createTableReq =
 *     TableAdminRequests.createTable("tableId")
 *       .addFamily("cf1")
 *       .addFamily("cf2", GCRULES.maxVersions(10))
 *       .addSplit(ByteString.copyFromUtf8("b"))
 *       .addSplit(ByteString.copyFromUtf8("q"));
 *   client.createTable(createTableReq);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the client object to clean up resources such as threads.
 * In the example above, try-with-resources is used, which automatically calls close().
 *
 * <p>This class can be customized by passing in a custom instance of TableAdminSettings to
 * create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * TableAdminSettings tableAdminSettings = TableAdminSettings.newBuilder()
 *   .setInstanceName(InstanceName.of("[PROJECT]", "[INSTANCE]"))
 *   .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *   .build();
 *
 * TableAdminClient client =
 *   TableAdminClient.create(tableAdminSettings);
 * }</pre>
 *
 * To customize the endpoint:
 *
 * <pre>{@code
 * TableAdminSettings tableAdminSettings = TableAdminSettings.newBuilder()
 *   .setInstanceName(InstanceName.of("[PROJECT]", "[INSTANCE]"))
 *   .setEndpoint(myEndpoint).build();
 *
 * TableAdminClient client = TableAdminClient.create(tableAdminSettings);
 * }</pre>
 */
public class TableAdminClient implements AutoCloseable {
  private final BigtableTableAdminStub stub;
  private final InstanceName instanceName;

  /** Constructs an instance of TableAdminClient with the given instanceName. */
  public static TableAdminClient create(@Nonnull InstanceName instanceName) throws IOException {
    return create(TableAdminSettings.newBuilder().setInstanceName(instanceName).build());
  }

  /** Constructs an instance of TableAdminClient with the given settings. */
  public static TableAdminClient create(@Nonnull TableAdminSettings settings) throws IOException {
    return create(settings.getInstanceName(), settings.getStubSettings().createStub());
  }

  /** Constructs an instance of TableAdminClient with the given instanceName and stub. */
  public static TableAdminClient create(@Nonnull InstanceName instanceName, @Nonnull BigtableTableAdminStub stub) {
    return new TableAdminClient(instanceName, stub);
  }

  private TableAdminClient(@Nonnull InstanceName instanceName, @Nonnull BigtableTableAdminStub stub) {
    Preconditions.checkNotNull(instanceName);
    Preconditions.checkNotNull(stub);
    this.instanceName = instanceName;
    this.stub = stub;
  }

  /** Gets the instanceName this client is associated with. */
  public InstanceName getInstanceName() {
    return instanceName;
  }

  @Override
  public void close() {
    stub.close();
  }

  /**
   * Creates a new table with the specified configuration
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try(TableAdminClient client =  TableAdminClient.create(InstanceName.of("[PROJECT]", "[INSTANCE]"))) {
   *   CreateTable createTableReq =
   *     TableAdminRequests.createTable("tableId")
   *       .addFamily("cf2", GCRULES.maxVersions(10))
   *   client.createTable(createTableReq);
   * }
   * }</pre>
   *
   * @param createTable
   * @return the newly created table
   * @see CreateTable for createTable configurations
   */
  public Table createTable(CreateTable createTable) {
    com.google.bigtable.admin.v2.Table table =
        this.stub.createTableCallable().call(createTable.toProto(instanceName));
    return TableAdminResponses.convertTable(table);
  }

  /**
   * Creates a new table with the specified configuration asynchronously
   *
   * <p>Sample code:
   *
   * <pre>{@code
   *  try(TableAdminClient client =  TableAdminClient.create(InstanceName.of("[PROJECT]", "[INSTANCE]"))) {
   *    CreateTable createTableReq =
   *      TableAdminRequests.createTable("tableId")
   *        .addFamily("cf2", GCRULES.maxVersions(10))
   *    client.createTableAsync(createTableReq);
   *  }
   *  }</pre>
   *
   * @param createTable
   * @return the newly created table
   * @see CreateTable for createTable configurations
   */
  public ApiFuture<Table> createTableAsync(CreateTable createTable) {
    return transformToTableResponse(
        this.stub.createTableCallable().futureCall(createTable.toProto(instanceName)));
  }

  /**
   * Creates, Updates and drops ColumnFamilies as per the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try(TableAdminClient client =  TableAdminClient.create(InstanceName.of("[PROJECT]", "[INSTANCE]"))) {
   *   ModifyFamilies modifyFamiliesReq = TableAdminRequests.modifyFamilies(tableId)
   *     .addFamily("mf1")
   *     .addFamily(
   *       "mf2", GCRULES.maxAge(Duration.ofSeconds(1000, 20000)))
   *     .updateFamily(
   *       "mf1",
   *          GCRULES
   *            .union()
   *              .rule(GCRULES.maxAge(Duration.ofSeconds(100)))
   *              .rule(GCRULES.maxVersions(1)))
   *     .addFamily(
   *       "mf3",
   *         GCRULES
   *           .intersection()
   *           .rule(GCRULES.maxAge(Duration.ofSeconds(2000)))
   *           .rule(GCRULES.maxVersions(10)))
   *     .dropFamily("mf1")
   *    client.modifyFamilies(modifyFamiliesReq);
   * }
   * }</pre>
   *
   * @param modifyFamily
   * @return the modified table
   * @see ModifyFamilies for modifyFamily options
   */
  public Table modifyFamilies(ModifyFamilies modifyFamily) {
    ModifyColumnFamiliesRequest modReq = modifyFamily.toProto(instanceName);
    com.google.bigtable.admin.v2.Table table =
        this.stub.modifyColumnFamiliesCallable().call(modReq);
    return TableAdminResponses.convertTable(table);
  }

  /**
   * Creates, Updates and drops ColumnFamilies as per the request asynchronously
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try(TableAdminClient client =  TableAdminClient.create(InstanceName.of("[PROJECT]", "[INSTANCE]"))) {
   *   ModifyFamilies modifyFamiliesReq = TableAdminRequests.modifyFamilies(tableId)
   *     .addFamily("mf1")
   *     .addFamily(
   *       "mf2", GCRULES.maxAge(Duration.ofSeconds(1000, 20000)))
   *     .updateFamily(
   *       "mf1",
   *          GCRULES
   *            .union()
   *              .rule(GCRULES.maxAge(Duration.ofSeconds(100)))
   *              .rule(GCRULES.maxVersions(1)))
   *     .addFamily(
   *       "mf3",
   *         GCRULES
   *           .intersection()
   *           .rule(GCRULES.maxAge(Duration.ofSeconds(2000)))
   *           .rule(GCRULES.maxVersions(10)))
   *     .dropFamily("mf1")
   *    client.modifyFamilies(modifyFamiliesReq);
   * }
   * }</pre>
   *
   * @param modifyFamily
   * @return Modified table
   * @see ModifyFamilies for modifyFamily options
   */
  public ApiFuture<Table> modifyFamiliesAsync(ModifyFamilies modifyFamily) {
    ModifyColumnFamiliesRequest modReq = modifyFamily.toProto(instanceName);
    return transformToTableResponse(this.stub.modifyColumnFamiliesCallable().futureCall(modReq));
  }

  /**
   * Deletes the specified tableId
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try(TableAdminClient client =  TableAdminClient.create(InstanceName.of("[PROJECT]", "[INSTANCE]"))) {
   *   client.deleteTable("tableId");
   * }
   * }</pre>
   *
   * @param tableId
   */
  public void deleteTable(String tableId) {
    this.stub.deleteTableCallable().call(composeDeleteTableRequest(tableId));
  }

  /**
   * Deletes the specified tableId asynchronously
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try(TableAdminClient client =  TableAdminClient.create(InstanceName.of("[PROJECT]", "[INSTANCE]"))) {
   *   client.deleteTableAsync("tableId");
   * }
   * }</pre>
   *
   * @param tableId
   */
  public ApiFuture<Void> deleteTableAsync(String tableId) {
    return transformToVoid(
        this.stub.deleteTableCallable().futureCall(composeDeleteTableRequest(tableId)));
  }

  /**
   * Gets the Table by tableId
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try(TableAdminClient client =  TableAdminClient.create(InstanceName.of("[PROJECT]", "[INSTANCE]"))) {
   *   client.getTable("tableId");
   * }
   * }</pre>
   *
   * @param tableId
   */
  public Table getTable(String tableId) {
    com.google.bigtable.admin.v2.Table table =
        this.stub.getTableCallable().call(composeGetTableRequest(tableId));
    return TableAdminResponses.convertTable(table);
  }

  /**
   * Gets the Table by tableId
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try(TableAdminClient client =  TableAdminClient.create(InstanceName.of("[PROJECT]", "[INSTANCE]"))) {
   *   client.getTableAsync("tableId");
   * }
   * }</pre>
   *
   * @param tableId
   */
  public ApiFuture<Table> getTableAsync(String tableId) {
    return transformToTableResponse(
        this.stub.getTableCallable().futureCall(composeGetTableRequest(tableId)));
  }

  /**
   * Lists all TableNames in the instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try(TableAdminClient client =  TableAdminClient.create(InstanceName.of("[PROJECT]", "[INSTANCE]"))) {
   *   client.listTables();
   * }
   * }</pre>
   */
  public List<TableName> listTables() {
    ListTablesResponse listResp = this.stub.listTablesCallable().call(composeListTableRequest());
    return convertToTableNames(listResp);
  }

  /**
   * Lists all TableNames in the instance asynchronously
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try(TableAdminClient client =  TableAdminClient.create(InstanceName.of("[PROJECT]", "[INSTANCE]"))) {
   *   client.listTablesAsync();
   * }
   * }</pre>
   */
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

  /**
   * Drops rows by the specified key prefix and tableId
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try(TableAdminClient client =  TableAdminClient.create(InstanceName.of("[PROJECT]", "[INSTANCE]"))) {
   *   client.dropRowRange("tableId");
   * }
   * }</pre>
   *
   * @param tableId
   * @param rowKeyPrefix
   */
  public void dropRowRange(String tableId, String rowKeyPrefix) {
    dropRowRange(tableId, ByteString.copyFromUtf8(rowKeyPrefix));
  }

  /**
   * Drops rows by the specified key prefix and tableId asynchronously
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try(TableAdminClient client =  TableAdminClient.create(InstanceName.of("[PROJECT]", "[INSTANCE]"))) {
   *   client.dropRowRangeAsync("tableId");
   * }
   * }</pre>
   *
   * @param tableId
   * @param rowKeyPrefix
   */
  public ApiFuture<Void> dropRowRangeAsync(String tableId, String rowKeyPrefix) {
    return dropRowRangeAsync(tableId, ByteString.copyFromUtf8(rowKeyPrefix));
  }

  /**
   * Drops rows by the specified key prefix and tableId
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try(TableAdminClient client =  TableAdminClient.create(InstanceName.of("[PROJECT]", "[INSTANCE]"))) {
   *   client.dropRowRange("tableId");
   * }
   * }</pre>
   *
   * @param tableId
   * @param rowKeyPrefix
   */
  public void dropRowRange(String tableId, ByteString rowKeyPrefix) {
    this.stub.dropRowRangeCallable().call(composeDropRowRangeRequest(tableId, rowKeyPrefix, false));
  }

  /**
   * Drops rows by the specified key prefix and tableId
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try(TableAdminClient client =  TableAdminClient.create(InstanceName.of("[PROJECT]", "[INSTANCE]"))) {
   *   client.dropRowRangeAsync("tableId");
   * }
   * }</pre>
   *
   * @param tableId
   * @param rowKeyPrefix
   */
  public ApiFuture<Void> dropRowRangeAsync(String tableId, ByteString rowKeyPrefix) {
    return transformToVoid(
        this.stub
            .dropRowRangeCallable()
            .futureCall(composeDropRowRangeRequest(tableId, rowKeyPrefix, false)));
  }

  /**
   * Drops all data in the table
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try(TableAdminClient client =  TableAdminClient.create(InstanceName.of("[PROJECT]", "[INSTANCE]"))) {
   *   client.dropAllRows("tableId");
   * }
   * }</pre>
   *
   * @param tableId
   */
  public void dropAllRows(String tableId) {
    this.stub.dropRowRangeCallable().call(composeDropRowRangeRequest(tableId, null, true));
  }

  /**
   * Drops all data in the table asynchronously
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try(TableAdminClient client =  TableAdminClient.create(InstanceName.of("[PROJECT]", "[INSTANCE]"))) {
   *   client.dropAllRowsAsync("tableId");
   * }
   * }</pre>
   *
   * @param tableId
   */
  public ApiFuture<Void> dropAllRowsAsync(String tableId) {
    return transformToVoid(
        this.stub
            .dropRowRangeCallable()
            .futureCall(composeDropRowRangeRequest(tableId, null, true)));
  }

  /**
   * Generates a token to verify the replication status of table mutations invoked before this call.
   * Token expires in 90 days
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try(TableAdminClient client =  TableAdminClient.create(InstanceName.of("[PROJECT]", "[INSTANCE]"))) {
   *   ConsistencyToken consistencyToken = client.generateConsistencyToken("tableId");
   * }
   * }</pre>
   *
   * @param tableId
   */
  public ConsistencyToken generateConsistencyToken(String tableId) {
    return TableAdminResponses.convertTokenResponse(
        this.stub
            .generateConsistencyTokenCallable()
            .call(composeGenerateConsistencyTokenRequest(tableId)));
  }

  /**
   * Generates a token to verify the replication status of table mutations invoked before this call
   * asynchronously Token expires in 90 days
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try(TableAdminClient client =  TableAdminClient.create(InstanceName.of("[PROJECT]", "[INSTANCE]"))) {
   *   ConsistencyToken consistencyToken = client.generateConsistencyToken("tableId");
   * }
   * }</pre>
   *
   * @param tableId
   */
  public ApiFuture<ConsistencyToken> generateConsistencyTokenAsync(String tableId) {
    ApiFuture<GenerateConsistencyTokenResponse> tokenResp =
        this.stub
            .generateConsistencyTokenCallable()
            .futureCall(composeGenerateConsistencyTokenRequest(tableId));

    return ApiFutures.transform(
        tokenResp,
        new ApiFunction<GenerateConsistencyTokenResponse, ConsistencyToken>() {
          @Override
          public ConsistencyToken apply(GenerateConsistencyTokenResponse input) {
            return TableAdminResponses.convertTokenResponse(input);
          }
        });
  }

  /**
   * Checks replication consistency for the specified token consistency token
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try(TableAdminClient client =  TableAdminClient.create(InstanceName.of("[PROJECT]", "[INSTANCE]"))) {
   *   boolean consistent = client.isConsistent("tableId", token);
   * }
   * }</pre>
   *
   * @param tableId
   * @param token
   */
  public boolean isConsistent(String tableId, ConsistencyToken token) {
    return stub.checkConsistencyCallable()
        .call(token.toProto(getTableName(tableId)))
        .getConsistent();
  }

  /**
   * Checks replication consistency for the specified token consistency token asynchronously
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try(TableAdminClient client =  TableAdminClient.create(InstanceName.of("[PROJECT]", "[INSTANCE]"))) {
   *   boolean consistent = client.isConsistentAsync("tableId", token);
   * }
   * }</pre>
   *
   * @param tableId
   * @param token
   */
  public ApiFuture<Boolean> isConsistentAsync(String tableId, ConsistencyToken token) {
    ApiFuture<CheckConsistencyResponse> checkConsResp =
        stub.checkConsistencyCallable().futureCall(token.toProto(getTableName(tableId)));

    return ApiFutures.transform(
        checkConsResp,
        new ApiFunction<CheckConsistencyResponse, Boolean>() {
          @Override
          public Boolean apply(CheckConsistencyResponse input) {
            return input.getConsistent();
          }
        });
  }

  /**
   * Helper method to construct the table name in format:
   * projects/{project}/instances/{instance}/tables/{tableId}
   *
   * @param tableId
   * @return unique table name
   */
  @VisibleForTesting
  String getTableName(String tableId) {
    return TableName.of(instanceName.getProject(), instanceName.getInstance(), tableId).toString();
  }

  /**
   * Helper method to build an instance of ListTablesRequest
   */
  @VisibleForTesting
  ListTablesRequest composeListTableRequest() {
    return ListTablesRequest.newBuilder().setParent(instanceName.toString()).build();
  }

  /**
   * Helper method to build an instance of GetTableRequest
   *
   * @param tableId
   */
  @VisibleForTesting
  GetTableRequest composeGetTableRequest(String tableId) {
    return GetTableRequest.newBuilder().setName(getTableName(tableId)).build();
  }

  /**
   * Helper method to build an instance of DeleteTableRequest
   *
   * @param tableId
   */
  @VisibleForTesting
  DeleteTableRequest composeDeleteTableRequest(String tableId) {
    return DeleteTableRequest.newBuilder().setName(getTableName(tableId)).build();
  }

  /**
   * Helper method to build an instance of DropRowRangeRequest
   *
   * @param tableId
   * @param rowKeyPrefix
   * @param boolean dropAll
   */
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

  /**
   * Helper method to build an instance of GenerateConsistencyTokenRequest
   *
   * @param tableId
   */
  @VisibleForTesting
  GenerateConsistencyTokenRequest composeGenerateConsistencyTokenRequest(String tableId) {
    return GenerateConsistencyTokenRequest.newBuilder().setName(getTableName(tableId)).build();
  }

  /**
   * Helper method to convert ListTablesResponse to List<TableName>
   *
   * @param listTablesResponse
   */
  @VisibleForTesting
  static List<TableName> convertToTableNames(ListTablesResponse listTablesResponse) {
    List<TableName> tableNames = new ArrayList<>();

    for (com.google.bigtable.admin.v2.Table table : listTablesResponse.getTablesList()) {
      tableNames.add(TableName.parse(table.getName()));
    }
    return tableNames;
  }

  /**
   * Helper method to transform ApiFuture<com.google.bigtable.admin.v2.Table> to ApiFuture<Table>
   *
   * @param future
   */
  @VisibleForTesting
  static ApiFuture<Table> transformToTableResponse(
      ApiFuture<com.google.bigtable.admin.v2.Table> future) {
    return ApiFutures.transform(
        future,
        new ApiFunction<com.google.bigtable.admin.v2.Table, Table>() {
          @Override
          public Table apply(com.google.bigtable.admin.v2.Table table) {
            return TableAdminResponses.convertTable(table);
          }
        });
  }

  /**
   * Helper method to transform ApiFuture<Empty> to ApiFuture<Void>
   *
   * @param future
   */
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
