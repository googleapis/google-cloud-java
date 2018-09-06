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

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.bigtable.admin.v2.CheckConsistencyResponse;
import com.google.bigtable.admin.v2.DeleteTableRequest;
import com.google.bigtable.admin.v2.DropRowRangeRequest;
import com.google.bigtable.admin.v2.GenerateConsistencyTokenRequest;
import com.google.bigtable.admin.v2.GenerateConsistencyTokenResponse;
import com.google.bigtable.admin.v2.GetTableRequest;
import com.google.bigtable.admin.v2.InstanceName;
import com.google.bigtable.admin.v2.ListTablesRequest;
import com.google.bigtable.admin.v2.TableName;
import com.google.cloud.bigtable.admin.v2.BaseBigtableTableAdminClient.ListTablesPagedResponse;
import com.google.cloud.bigtable.admin.v2.models.ConsistencyToken;
import com.google.cloud.bigtable.admin.v2.models.CreateTableRequest;
import com.google.cloud.bigtable.admin.v2.models.ModifyColumnFamiliesRequest;
import com.google.cloud.bigtable.admin.v2.models.Table;
import com.google.cloud.bigtable.admin.v2.stub.BigtableTableAdminStub;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.common.util.concurrent.UncheckedExecutionException;
import com.google.protobuf.ByteString;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
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
 * try(BigtableTableAdminClient client =  BigtableTableAdminClient.create(InstanceName.of("[PROJECT]", "[INSTANCE]"))) {
 *   CreateTable request =
 *     CreateTableRequest.of("my-table")
 *       .addFamily("cf1")
 *       .addFamily("cf2", GCRULES.maxVersions(10))
 *       .addSplit(ByteString.copyFromUtf8("b"))
 *       .addSplit(ByteString.copyFromUtf8("q"));
 *   client.createTable(request);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the client object to clean up resources such as threads.
 * In the example above, try-with-resources is used, which automatically calls close().
 *
 * <p>This class can be customized by passing in a custom instance of BigtableTableAdminSettings to
 * create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * BigtableTableAdminSettings tableAdminSettings = BigtableTableAdminSettings.newBuilder()
 *   .setInstanceName(InstanceName.of("[PROJECT]", "[INSTANCE]"))
 *   .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *   .build();
 *
 * BigtableTableAdminClient client =
 *   BigtableTableAdminClient.create(tableAdminSettings);
 * }</pre>
 *
 * To customize the endpoint:
 *
 * <pre>{@code
 * BigtableTableAdminSettings tableAdminSettings = BigtableTableAdminSettings.newBuilder()
 *   .setInstanceName(InstanceName.of("[PROJECT]", "[INSTANCE]"))
 *   .setEndpoint(myEndpoint).build();
 *
 * BigtableTableAdminClient client = BigtableTableAdminClient.create(tableAdminSettings);
 * }</pre>
 */
public final class BigtableTableAdminClient implements AutoCloseable {
  private final BigtableTableAdminStub stub;
  private final InstanceName instanceName;

  /** Constructs an instance of BigtableTableAdminClient with the given instanceName. */
  public static BigtableTableAdminClient create(@Nonnull InstanceName instanceName)
      throws IOException {
    return create(BigtableTableAdminSettings.newBuilder().setInstanceName(instanceName).build());
  }

  /** Constructs an instance of BigtableTableAdminClient with the given settings. */
  public static BigtableTableAdminClient create(@Nonnull BigtableTableAdminSettings settings)
      throws IOException {
    return create(settings.getInstanceName(), settings.getStubSettings().createStub());
  }

  /** Constructs an instance of BigtableTableAdminClient with the given instanceName and stub. */
  public static BigtableTableAdminClient create(@Nonnull InstanceName instanceName,
      @Nonnull BigtableTableAdminStub stub) {
    return new BigtableTableAdminClient(instanceName, stub);
  }

  private BigtableTableAdminClient(@Nonnull InstanceName instanceName,
      @Nonnull BigtableTableAdminStub stub) {
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
   * Table table = client.createTable(
   *   CreateTableRequest.of("my-table")
   *     .addFamily("cf2", GCRULES.maxVersions(1)
   * );
   * }</pre>
   *
   * @see CreateTableRequest for available options.
   */
  @SuppressWarnings("WeakerAccess")
  public Table createTable(CreateTableRequest request) {
    return awaitFuture(createTableAsync(request));
  }

  /**
   * Creates a new table with the specified configuration asynchronously
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * ApiFuture<Table> tableFuture = client.createTableAsync(
   *   CreateTableRequest.of("my-table")
   *     .addFamily("cf", GCRules.GCRULES.maxVersions(1))
   * );
   *
   * ApiFutures.addCallback(
   *   tableFuture,
   *   new ApiFutureCallback<Table>() {
   *     public void onSuccess(Table table) {
   *       System.out.println("Created table: " + table.getTableName());
   *     }
   *
   *     public void onFailure(Throwable t) {
   *       t.printStackTrace();
   *     }
   *   },
   *   MoreExecutors.directExecutor()
   * );
   * }</pre>
   *
   * @see CreateTableRequest for available options.
   */
  @SuppressWarnings("WeakerAccess")
  public ApiFuture<Table> createTableAsync(CreateTableRequest request) {
    return transformToTableResponse(
        this.stub.createTableCallable().futureCall(request.toProto(instanceName)));
  }

  /**
   * Creates, Updates and drops ColumnFamilies as per the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * Table modifiedTable = client.modifyFamilies(
   *   ModifyColumnFamiliesRequest.of(tableId)
   *     .addFamily("cf1")
   *     .addFamily("cf2", GCRULES.maxAge(Duration.ofSeconds(1000, 20000)))
   *     .updateFamily(
   *       "cf3",
   *       GCRULES.union()
   *         .rule(GCRULES.maxAge(Duration.ofSeconds(100)))
   *         .rule(GCRULES.maxVersions(1))
   *       )
   *     .addFamily(
   *       "cf4",
   *       GCRULES.intersection()
   *         .rule(GCRULES.maxAge(Duration.ofSeconds(2000)))
   *         .rule(GCRULES.maxVersions(10))
   *     )
   *     .dropFamily("cf5")
   * );
   *
   * System.out.println("Resulting families:");
   *
   * for (ColumnFamily cf : modifiedTable.getColumnFamilies()) {
   *   System.out.println(cf.getId());
   * }
   * }</pre>
   *
   * @see ModifyColumnFamiliesRequest for available options.
   */
  @SuppressWarnings("WeakerAccess")
  public Table modifyFamilies(ModifyColumnFamiliesRequest request) {
    return awaitFuture(modifyFamiliesAsync(request));
  }

  /**
   * Asynchronously creates, updates and drops ColumnFamilies as per the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * ApiFuture<Table> modifiedTableFuture = client.modifyFamiliesAsync(
   *   ModifyColumnFamiliesRequest.of(tableId)
   *     .addFamily("cf1")
   *     .addFamily("cf2", GCRULES.maxAge(Duration.ofSeconds(1000, 20000)))
   *     .updateFamily(
   *       "cf3",
   *       GCRULES.union()
   *         .rule(GCRULES.maxAge(Duration.ofSeconds(100)))
   *         .rule(GCRULES.maxVersions(1))
   *       )
   *     .addFamily(
   *       "cf4",
   *       GCRULES.intersection()
   *         .rule(GCRULES.maxAge(Duration.ofSeconds(2000)))
   *         .rule(GCRULES.maxVersions(10))
   *     )
   *     .dropFamily("cf5")
   * );
   *
   * ApiFutures.addCallback(
   *   modifiedTableFuture,
   *   new ApiFutureCallback<Table>() {
   *     public void onSuccess(Table table) {
   *       System.out.println("Modified table: " + table.getTableName());
   *       System.out.println("Resulting families:");
   *
   *       for (ColumnFamily cf : modifiedTable.getColumnFamilies()) {
   *         System.out.println(cf.getId());
   *       }
   *     }
   *
   *     public void onFailure(Throwable t) {
   *       t.printStackTrace();
   *     }
   *   },
   *   MoreExecutors.directExecutor()
   * );
   * }</pre>
   *
   * @see ModifyColumnFamiliesRequest for available options.
   */
  @SuppressWarnings("WeakerAccess")
  public ApiFuture<Table> modifyFamiliesAsync(ModifyColumnFamiliesRequest request) {
    return transformToTableResponse(
        this.stub.modifyColumnFamiliesCallable().futureCall(request.toProto(instanceName)));
  }

  /**
   * Deletes the table specified by tableId
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * client.deleteTable("my-table");
   * }</pre>
   */
  @SuppressWarnings("WeakerAccess")
  public void deleteTable(String tableId) {
    awaitFuture(deleteTableAsync(tableId));
  }

  /**
   * Asynchronously deletes the table specified by tableId.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * ApiFuture<Void> future = client.deleteTableAsync("my-table");
   *
   * ApiFutures.addCallback(
   *   future,
   *   new ApiFutureCallback<Void>() {
   *     public void onSuccess(Void ignored) {
   *       System.out.println("Successfully deleted the table");
   *     }
   *
   *     public void onFailure(Throwable t) {
   *       t.printStackTrace();
   *     }
   *   },
   *   MoreExecutors.directExecutor()
   * );
   * }</pre>
   */
  @SuppressWarnings("WeakerAccess")
  public ApiFuture<Void> deleteTableAsync(String tableId) {
    DeleteTableRequest request = DeleteTableRequest.newBuilder()
        .setName(getTableName(tableId))
        .build();

    return transformToVoid(this.stub.deleteTableCallable().futureCall(request));
  }

  /**
   * Gets the table metadata by tableId.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * Table table = client.getTable("my-table");
   *
   * System.out.println("Got metadata for table: " + table.getId());
   * System.out.println("Column families:");
   *
   * for (ColumnFamily cf : table.getColumnFamilies()) {
   *   System.out.println(cf.getId());
   * }
   * }</pre>
   */
  @SuppressWarnings("WeakerAccess")
  public Table getTable(String tableId) {
    return awaitFuture(getTableAsync(tableId));
  }

  /**
   * Asynchronously gets the table metadata by tableId.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * ApiFuture<Table> tableFuture = client.getTableAsync("my-table");
   *
   * ApiFutures.addCallback(
   *   tableFuture,
   *   new ApiFutureCallback<Table>() {
   *     public void onSuccess(Table table) {
   *       System.out.println("Got metadata for table: " + table.getId());
   *       System.out.println("Column families:");
   *       for (ColumnFamily cf : table.getColumnFamilies()) {
   *         System.out.println(cf.getId());
   *       }
   *     }
   *
   *     public void onFailure(Throwable t) {
   *       t.printStackTrace();
   *     }
   *   },
   *   MoreExecutors.directExecutor()
   * );
   * }</pre>
   */
  @SuppressWarnings("WeakerAccess")
  public ApiFuture<Table> getTableAsync(String tableId) {
    GetTableRequest request = GetTableRequest.newBuilder()
        .setName(getTableName(tableId))
        .build();

    return transformToTableResponse(
        this.stub.getTableCallable().futureCall(request));
  }

  /**
   * Lists all TableNames in the instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * List<TableName> tableNames = client.listTables();
   * for(TableName name : tableNames) {
   *   System.out.println(name.getTable());
   * }
   * }</pre>
   */
  // TODO(igorbernstein2): consider changing this method to use relative table ids.
  @SuppressWarnings("WeakerAccess")
  public List<TableName> listTables() {
    return awaitFuture(listTablesAsync());
  }

  /**
   * Asynchronously lists all TableNames in the instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * ApiFuture<List<TableName>> listFuture = client.listTables();
   *
   * ApiFutures.addCallback(
   *   listFuture,
   *   new ApiFutureCallback<List<TableName>>() {
   *     public void onSuccess(List<TableName> tableNames) {
   *       System.out.println("Got list of tables:");
   *       for (TableName name : tableNames) {
   *         System.out.println(name.getTable());
   *       }
   *     }
   *
   *     public void onFailure(Throwable t) {
   *       t.printStackTrace();
   *     }
   *   },
   *   MoreExecutors.directExecutor()
   * );
   * }</pre>
   */
  // TODO(igorbernstein2): consider changing this method to use relative table ids.
  @SuppressWarnings("WeakerAccess")
  public ApiFuture<List<TableName>> listTablesAsync() {
    ListTablesRequest request = ListTablesRequest.newBuilder().setParent(instanceName.toString())
        .build();

    ApiFuture<ListTablesPagedResponse> listResp =
        this.stub.listTablesPagedCallable().futureCall(request);

    return ApiFutures.transform(
        listResp,
        new ApiFunction<ListTablesPagedResponse, List<TableName>>() {
          @Override
          public List<TableName> apply(ListTablesPagedResponse response) {
            List<TableName> results = Lists.newArrayList();
            for (com.google.bigtable.admin.v2.Table proto : response.iterateAll()) {
              results.add(TableName.parse(proto.getName()));
            }
            return results;
          }
        },
        MoreExecutors.directExecutor());
  }

  /**
   * Drops rows by the specified key prefix and tableId
   *
   * <p>Please note that this method is considered part of the admin API and is rate limited.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * client.dropRowRange("my-table", "prefix");
   * }</pre>
   */
  @SuppressWarnings("WeakerAccess")
  public void dropRowRange(String tableId, String rowKeyPrefix) {
    awaitFuture(dropRowRangeAsync(tableId, rowKeyPrefix));
  }

  /**
   * Drops rows by the specified key prefix and tableId asynchronously
   *
   * <p>Please note that this method is considered part of the admin API and is rate limited.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * ApiFuture<Void> dropFuture = client.dropRowRangeAsync("my-table", "prefix");
   *
   * ApiFutures.addCallback(
   *   dropFuture,
   *   new ApiFutureCallback<Void>() {
   *     public void onSuccess(Void tableNames) {
   *       System.out.println("Successfully dropped row range.");
   *     }
   *
   *     public void onFailure(Throwable t) {
   *       t.printStackTrace();
   *     }
   *   },
   *   MoreExecutors.directExecutor()
   * );
   * }</pre>
   */
  @SuppressWarnings("WeakerAccess")
  public ApiFuture<Void> dropRowRangeAsync(String tableId, String rowKeyPrefix) {
    return dropRowRangeAsync(tableId, ByteString.copyFromUtf8(rowKeyPrefix));
  }

  /**
   * Drops rows by the specified key prefix and tableId
   *
   * <p>Please note that this method is considered part of the admin API and is rate limited.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * client.dropRowRange("my-table", ByteString.copyFromUtf8("prefix"));
   * }</pre>
   */
  @SuppressWarnings("WeakerAccess")
  public void dropRowRange(String tableId, ByteString rowKeyPrefix) {
    awaitFuture(dropRowRangeAsync(tableId, rowKeyPrefix));
  }

  /**
   * Drops rows by the specified key prefix and tableId asynchronously
   *
   * <p>Please note that this method is considered part of the admin API and is rate limited.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * ApiFuture<Void> dropFuture = client.dropRowRangeAsync("my-table", ByteString.copyFromUtf8("prefix"));
   *
   * ApiFutures.addCallback(
   *   dropFuture,
   *   new ApiFutureCallback<Void>() {
   *     public void onSuccess(Void tableNames) {
   *       System.out.println("Successfully dropped row range.");
   *     }
   *
   *     public void onFailure(Throwable t) {
   *       t.printStackTrace();
   *     }
   *   },
   *   MoreExecutors.directExecutor()
   * );
   * }</pre>
   */
  @SuppressWarnings("WeakerAccess")
  public ApiFuture<Void> dropRowRangeAsync(String tableId, ByteString rowKeyPrefix) {
    DropRowRangeRequest request = DropRowRangeRequest.newBuilder()
        .setName(getTableName(tableId))
        .setRowKeyPrefix(rowKeyPrefix)
        .build();

    return transformToVoid(
        this.stub
            .dropRowRangeCallable()
            .futureCall(request));
  }

  /**
   * Drops all data in the table
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * client.dropAllRows("my-table");
   * }</pre>
   */
  @SuppressWarnings("WeakerAccess")
  public void dropAllRows(String tableId) {
    awaitFuture(dropAllRowsAsync(tableId));
  }

  /**
   * Asynchornously drops all data in the table.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * ApiFuture<Void> dropFuture = client.dropAllRowsAsync("my-table");
   *
   * ApiFutures.addCallback(
   *   dropFuture,
   *   new ApiFutureCallback<Void>() {
   *     public void onSuccess(Void tableNames) {
   *       System.out.println("Successfully dropped all data");
   *     }
   *
   *     public void onFailure(Throwable t) {
   *       t.printStackTrace();
   *     }
   *   },
   *   MoreExecutors.directExecutor()
   * );
   * }</pre>
   */
  @SuppressWarnings("WeakerAccess")
  public ApiFuture<Void> dropAllRowsAsync(String tableId) {
    DropRowRangeRequest request = DropRowRangeRequest.newBuilder()
        .setName(getTableName(tableId))
        .setDeleteAllDataFromTable(true)
        .build();

    return transformToVoid(
        this.stub
            .dropRowRangeCallable()
            .futureCall(request));
  }

  /**
   * Generates a token to verify the replication status of table mutations invoked before this call.
   * Token expires in 90 days
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * ConsistencyToken consistencyToken = client.generateConsistencyToken("my-table");
   * }</pre>
   */
  @SuppressWarnings("WeakerAccess")
  public ConsistencyToken generateConsistencyToken(String tableId) {
    return awaitFuture(generateConsistencyTokenAsync(tableId));
  }

  /**
   * Asynchornously generates a token to verify the replication status of table mutations invoked
   * before this call. Token expires in 90 days
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * ApiFuture<ConsistencyToken> consistencyTokenFuture = client.generateConsistencyToken("my-table");
   * }</pre>
   */
  // TODO(igorbernstein2): add sample code for waiting for the fetch consistency token
  @SuppressWarnings("WeakerAccess")
  public ApiFuture<ConsistencyToken> generateConsistencyTokenAsync(final String tableId) {
    GenerateConsistencyTokenRequest request = GenerateConsistencyTokenRequest.newBuilder()
        .setName(getTableName(tableId))
        .build();

    return ApiFutures.transform(
        stub.generateConsistencyTokenCallable().futureCall(request),
        new ApiFunction<GenerateConsistencyTokenResponse, ConsistencyToken>() {
          @Override
          public ConsistencyToken apply(GenerateConsistencyTokenResponse proto) {
            TableName tableName = TableName
                .of(instanceName.getProject(), instanceName.getInstance(), tableId);
            return ConsistencyToken.of(tableName, proto.getConsistencyToken());
          }
        },
        MoreExecutors.directExecutor());
  }

  /**
   * Checks replication consistency for the specified token consistency token
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try(BigtableTableAdminClient client =  BigtableTableAdminClient.create(InstanceName.of("[PROJECT]", "[INSTANCE]"))) {
   *   // Perform some mutations.
   *
   *   ConsistencyToken token = client.generateConsistencyToken("table-id");
   *   while(!client.isConsistent(token)) {
   *     Thread.sleep(100);
   *   }
   *
   *   // Now all clusters are consistent
   * }
   * }</pre>
   */
  @SuppressWarnings("WeakerAccess")
  public boolean isConsistent(ConsistencyToken token) {
    return awaitFuture(isConsistentAsync(token));
  }

  @VisibleForTesting
  ApiFuture<Boolean> isConsistentAsync(ConsistencyToken token) {
    ApiFuture<CheckConsistencyResponse> checkConsResp = stub.checkConsistencyCallable()
        .futureCall(token.toProto(instanceName));

    return ApiFutures.transform(
        checkConsResp,
        new ApiFunction<CheckConsistencyResponse, Boolean>() {
          @Override
          public Boolean apply(CheckConsistencyResponse input) {
            return input.getConsistent();
          }
        },
        MoreExecutors.directExecutor());
  }

  // TODO(igorbernstein2): add awaitConsist() & awaitConsistAsync() that generate & poll a token

  /**
   * Helper method to construct the table name in format: projects/{project}/instances/{instance}/tables/{tableId}
   */
  private String getTableName(String tableId) {
    return TableName.of(instanceName.getProject(), instanceName.getInstance(), tableId).toString();
  }

  // TODO(igorbernstein): rename methods to make clear that they deal with futures.

  /**
   * Helper method to transform ApiFuture<com.google.bigtable.admin.v2.Table> to ApiFuture<Table>
   */
  private static ApiFuture<Table> transformToTableResponse(
      ApiFuture<com.google.bigtable.admin.v2.Table> future) {
    return ApiFutures.transform(
        future,
        new ApiFunction<com.google.bigtable.admin.v2.Table, Table>() {
          @Override
          public Table apply(com.google.bigtable.admin.v2.Table table) {
            return Table.fromProto(table);
          }
        },
        MoreExecutors.directExecutor());
  }

  /**
   * Helper method to transform ApiFuture<Empty> to ApiFuture<Void>
   */
  private static ApiFuture<Void> transformToVoid(ApiFuture<Empty> future) {
    return ApiFutures.transform(
        future,
        new ApiFunction<Empty, Void>() {
          @Override
          public Void apply(Empty empty) {
            return null;
          }
        },
        MoreExecutors.directExecutor());
  }

  /**
   * Awaits the result of a future, taking care to propagate errors while maintaining the call site
   * in a suppressed exception. This allows semantic errors to be caught across threads, while
   * preserving the call site in the error. The caller's stacktrace will be made available as a
   * suppressed exception.
   */
  // TODO(igorbernstein2): try to move this into gax
  private <T> T awaitFuture(ApiFuture<T> future) {
    RuntimeException error;
    try {
      return Futures.getUnchecked(future);
    } catch (UncheckedExecutionException e) {
      if (e.getCause() instanceof RuntimeException) {
        error = (RuntimeException) e.getCause();
      } else {
        error = e;
      }
    } catch (RuntimeException e) {
      error = e;
    }
    // Add the caller's stack as a suppressed exception
    error.addSuppressed(new RuntimeException("Encountered error while awaiting future"));
    throw error;
  }
}
