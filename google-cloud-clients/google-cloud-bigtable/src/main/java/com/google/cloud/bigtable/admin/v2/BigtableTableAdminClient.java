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

import com.google.api.core.ApiAsyncFunction;
import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.rpc.ApiExceptions;
import com.google.api.gax.rpc.NotFoundException;
import com.google.bigtable.admin.v2.DeleteTableRequest;
import com.google.bigtable.admin.v2.DropRowRangeRequest;
import com.google.bigtable.admin.v2.GetTableRequest;
import com.google.bigtable.admin.v2.ListTablesRequest;
import com.google.cloud.bigtable.admin.v2.BaseBigtableTableAdminClient.ListTablesPage;
import com.google.cloud.bigtable.admin.v2.BaseBigtableTableAdminClient.ListTablesPagedResponse;
import com.google.cloud.bigtable.admin.v2.internal.ArtifactDeprecationChecker;
import com.google.cloud.bigtable.admin.v2.internal.NameUtil;
import com.google.cloud.bigtable.admin.v2.models.CreateTableRequest;
import com.google.cloud.bigtable.admin.v2.models.ModifyColumnFamiliesRequest;
import com.google.cloud.bigtable.admin.v2.models.Table;
import com.google.cloud.bigtable.admin.v2.stub.EnhancedBigtableTableAdminStub;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.google.common.util.concurrent.MoreExecutors;
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
 * try(BigtableTableAdminClient client =  BigtableTableAdminClient.create("[PROJECT]", "[INSTANCE]")) {
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
 *   .setProjectId("[PROJECT]")
 *   .setInstanceId("[INSTANCE]")
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
 *   .setProjectId("[PROJECT]")
 *   .setInstanceId("[INSTANCE]")
 *   .setEndpoint(myEndpoint).build();
 *
 * BigtableTableAdminClient client = BigtableTableAdminClient.create(tableAdminSettings);
 * }</pre>
 */
public final class BigtableTableAdminClient implements AutoCloseable {

  static {
    ArtifactDeprecationChecker.checkDeprecatedArtifactUse();
  }

  private final EnhancedBigtableTableAdminStub stub;
  private final String projectId;
  private final String instanceId;

  /** Constructs an instance of BigtableTableAdminClient with the given project and instance ids. */
  public static BigtableTableAdminClient create(
      @Nonnull String projectId, @Nonnull String instanceId) throws IOException {
    return create(
        BigtableTableAdminSettings.newBuilder()
            .setProjectId(projectId)
            .setInstanceId(instanceId)
            .build());
  }

  /**
   * Constructs an instance of BigtableTableAdminClient with the given instanceName.
   *
   * @deprecated Please {@link #create(String, String)}.
   */
  @Deprecated
  public static BigtableTableAdminClient create(
      @Nonnull com.google.bigtable.admin.v2.InstanceName instanceName) throws IOException {
    return create(instanceName.getProject(), instanceName.getInstance());
  }

  /** Constructs an instance of BigtableTableAdminClient with the given settings. */
  public static BigtableTableAdminClient create(@Nonnull BigtableTableAdminSettings settings)
      throws IOException {
    EnhancedBigtableTableAdminStub stub =
        EnhancedBigtableTableAdminStub.createEnhanced(settings.getStubSettings());
    return create(settings.getProjectId(), settings.getInstanceId(), stub);
  }

  /** Constructs an instance of BigtableTableAdminClient with the given instanceName and stub. */
  public static BigtableTableAdminClient create(
      @Nonnull String projectId,
      @Nonnull String instanceId,
      @Nonnull EnhancedBigtableTableAdminStub stub) {
    return new BigtableTableAdminClient(projectId, instanceId, stub);
  }

  private BigtableTableAdminClient(
      @Nonnull String projectId,
      @Nonnull String instanceId,
      @Nonnull EnhancedBigtableTableAdminStub stub) {
    Preconditions.checkNotNull(projectId);
    Preconditions.checkNotNull(instanceId);
    Preconditions.checkNotNull(stub);
    this.projectId = projectId;
    this.instanceId = instanceId;
    this.stub = stub;
  }

  /** Gets the project id of the instance whose tables this client manages. */
  public String getProjectId() {
    return projectId;
  }

  /** Gets the id of the instance whose tables this client manages. */
  public String getInstanceId() {
    return instanceId;
  }

  /**
   * Gets the instanceName this client is associated with.
   *
   * @deprecated Please use {@link #getProjectId()} and {@link #getInstanceId()}.
   */
  @Deprecated
  public com.google.bigtable.admin.v2.InstanceName getInstanceName() {
    return com.google.bigtable.admin.v2.InstanceName.of(projectId, instanceId);
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
    return ApiExceptions.callAndTranslateApiException(createTableAsync(request));
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
        this.stub.createTableCallable().futureCall(request.toProto(projectId, instanceId)));
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
    return ApiExceptions.callAndTranslateApiException(modifyFamiliesAsync(request));
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
        this.stub
            .modifyColumnFamiliesCallable()
            .futureCall(request.toProto(projectId, instanceId)));
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
    ApiExceptions.callAndTranslateApiException(deleteTableAsync(tableId));
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
    DeleteTableRequest request =
        DeleteTableRequest.newBuilder().setName(getTableName(tableId)).build();

    return transformToVoid(this.stub.deleteTableCallable().futureCall(request));
  }

  /**
   * Checks if the table specified by the tableId exists
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * if(client.exists("my-table")) {
   *   System.out.println("Table exists");
   * }
   * }</pre>
   */
  public boolean exists(String tableId) {
    return ApiExceptions.callAndTranslateApiException(existsAsync(tableId));
  }

  /**
   * Asynchronously checks if the table specified by the tableId exists
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * ApiFuture<Boolean> found = client.existsAsync("my-table");
   *
   * ApiFutures.addCallback(
   *  found,
   *  new ApiFutureCallback<Boolean>() {
   *    public void onSuccess(Boolean found) {
   *      if (found) {
   *        System.out.println("Table exists");
   *      } else {
   *        System.out.println("Table not found");
   *      }
   *    }
   *
   *    public void onFailure(Throwable t) {
   *      t.printStackTrace();
   *    }
   *  },
   *  MoreExecutors.directExecutor()
   * );
   * }</pre>
   */
  public ApiFuture<Boolean> existsAsync(String tableId) {

    ApiFuture<Table> protoFuture =
        getTableAsync(tableId, com.google.bigtable.admin.v2.Table.View.NAME_ONLY);

    ApiFuture<Boolean> existsFuture =
        ApiFutures.transform(
            protoFuture,
            new ApiFunction<Table, Boolean>() {
              @Override
              public Boolean apply(Table ignored) {
                return true;
              }
            },
            MoreExecutors.directExecutor());

    return ApiFutures.catching(
        existsFuture,
        NotFoundException.class,
        new ApiFunction<NotFoundException, Boolean>() {
          @Override
          public Boolean apply(NotFoundException ignored) {
            return false;
          }
        },
        MoreExecutors.directExecutor());
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
    return ApiExceptions.callAndTranslateApiException(getTableAsync(tableId));
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
    return getTableAsync(tableId, com.google.bigtable.admin.v2.Table.View.SCHEMA_VIEW);
  }

  private ApiFuture<Table> getTableAsync(
      String tableId, com.google.bigtable.admin.v2.Table.View view) {
    GetTableRequest request =
        GetTableRequest.newBuilder().setName(getTableName(tableId)).setView(view).build();

    return transformToTableResponse(this.stub.getTableCallable().futureCall(request));
  }

  /**
   * Lists all table ids in the instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * List<String> tableIds = client.listTables();
   * for(String tableId: tableIds) {
   *   System.out.println(name.getTable());
   * }
   * }</pre>
   */
  @SuppressWarnings("WeakerAccess")
  public List<String> listTables() {
    return ApiExceptions.callAndTranslateApiException(listTablesAsync());
  }

  /**
   * Asynchronously lists all table ids in the instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * ApiFuture<List<String>> listFuture = client.listTables();
   *
   * ApiFutures.addCallback(
   *   listFuture,
   *   new ApiFutureCallback<List<String>>() {
   *     public void onSuccess(List<String> tableIds) {
   *       System.out.println("Got list of tables:");
   *       for (String tableId : tableIds) {
   *         System.out.println(tableId);
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
  public ApiFuture<List<String>> listTablesAsync() {
    ListTablesRequest request =
        ListTablesRequest.newBuilder()
            .setParent(NameUtil.formatInstanceName(projectId, instanceId))
            .build();

    // TODO(igorbernstein2): try to upstream pagination spooling or figure out a way to expose the
    // paginated responses while maintaining the wrapper facade.

    // Fetch the first page.
    ApiFuture<ListTablesPage> firstPageFuture =
        ApiFutures.transform(
            stub.listTablesPagedCallable().futureCall(request),
            new ApiFunction<ListTablesPagedResponse, ListTablesPage>() {
              @Override
              public ListTablesPage apply(ListTablesPagedResponse response) {
                return response.getPage();
              }
            },
            MoreExecutors.directExecutor());

    // Fetch the rest of the pages by chaining the futures.
    ApiFuture<List<com.google.bigtable.admin.v2.Table>> allProtos =
        ApiFutures.transformAsync(
            firstPageFuture,
            new ApiAsyncFunction<ListTablesPage, List<com.google.bigtable.admin.v2.Table>>() {
              List<com.google.bigtable.admin.v2.Table> responseAccumulator = Lists.newArrayList();

              @Override
              public ApiFuture<List<com.google.bigtable.admin.v2.Table>> apply(
                  ListTablesPage page) {
                // Add all entries from the page
                responseAccumulator.addAll(Lists.newArrayList(page.getValues()));

                // If this is the last page, just return the accumulated responses.
                if (!page.hasNextPage()) {
                  return ApiFutures.immediateFuture(responseAccumulator);
                }

                // Otherwise fetch the next page.
                return ApiFutures.transformAsync(
                    page.getNextPageAsync(), this, MoreExecutors.directExecutor());
              }
            },
            MoreExecutors.directExecutor());

    // Wrap all of the accumulated protos.
    return ApiFutures.transform(
        allProtos,
        new ApiFunction<List<com.google.bigtable.admin.v2.Table>, List<String>>() {
          @Override
          public List<String> apply(List<com.google.bigtable.admin.v2.Table> protos) {
            List<String> results = Lists.newArrayListWithCapacity(protos.size());
            for (com.google.bigtable.admin.v2.Table proto : protos) {
              results.add(NameUtil.extractTableIdFromTableName(proto.getName()));
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
    ApiExceptions.callAndTranslateApiException(dropRowRangeAsync(tableId, rowKeyPrefix));
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
    ApiExceptions.callAndTranslateApiException(dropRowRangeAsync(tableId, rowKeyPrefix));
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
    DropRowRangeRequest request =
        DropRowRangeRequest.newBuilder()
            .setName(getTableName(tableId))
            .setRowKeyPrefix(rowKeyPrefix)
            .build();

    return transformToVoid(this.stub.dropRowRangeCallable().futureCall(request));
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
    ApiExceptions.callAndTranslateApiException(dropAllRowsAsync(tableId));
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
    DropRowRangeRequest request =
        DropRowRangeRequest.newBuilder()
            .setName(getTableName(tableId))
            .setDeleteAllDataFromTable(true)
            .build();

    return transformToVoid(this.stub.dropRowRangeCallable().futureCall(request));
  }

  /**
   * Blocks until replication has caught up to the point this method was called. This allows callers
   * to make sure that their mutations have been replicated across all of their clusters.
   *
   * <p>Sample code
   *
   * <pre>{@code
   * client.awaitReplication("my-table");
   * }</pre>
   *
   * @throws com.google.api.gax.retrying.PollException when polling exceeds the total timeout
   */
  @SuppressWarnings("WeakerAccess")
  public void awaitReplication(String tableId) {
    // TODO(igorbernstein2): remove usage of typesafe names
    com.google.bigtable.admin.v2.TableName tableName =
        com.google.bigtable.admin.v2.TableName.of(projectId, instanceId, tableId);

    ApiExceptions.callAndTranslateApiException(
        stub.awaitReplicationCallable().futureCall(tableName));
  }

  /**
   * Returns a future that is resolved when replication has caught up to the point this method was
   * called. This allows callers to make sure that their mutations have been replicated across all
   * of their clusters.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * ApiFuture<Void> replicationFuture = client.awaitReplicationAsync("my-table");
   *
   * ApiFutures.addCallback(
   *   replicationFuture,
   *   new ApiFutureCallback<Void>() {
   *     public void onSuccess(Table table) {
   *       System.out.println("All clusters are now consistent");
   *     }
   *
   *     public void onFailure(Throwable t) {
   *       t.printStackTrace();
   *     }
   *   },
   *   MoreExecutors.directExecutor()
   * );
   *
   * }</pre>
   */
  @SuppressWarnings("WeakerAccess")
  public ApiFuture<Void> awaitReplicationAsync(final String tableId) {
    // TODO(igorbernstein2): remove usage of trypesafe names
    com.google.bigtable.admin.v2.TableName tableName =
        com.google.bigtable.admin.v2.TableName.of(projectId, instanceId, tableId);
    return stub.awaitReplicationCallable().futureCall(tableName);
  }

  /**
   * Helper method to construct the table name in format:
   * projects/{project}/instances/{instance}/tables/{tableId}
   */
  private String getTableName(String tableId) {
    return NameUtil.formatTableName(projectId, instanceId, tableId);
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

  /** Helper method to transform ApiFuture<Empty> to ApiFuture<Void> */
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
}
