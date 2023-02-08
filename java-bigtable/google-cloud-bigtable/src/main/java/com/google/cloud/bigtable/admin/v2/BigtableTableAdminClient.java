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
import com.google.api.gax.longrunning.OperationFuture;
import com.google.api.gax.rpc.ApiExceptions;
import com.google.api.gax.rpc.NotFoundException;
import com.google.bigtable.admin.v2.DeleteBackupRequest;
import com.google.bigtable.admin.v2.DeleteTableRequest;
import com.google.bigtable.admin.v2.DropRowRangeRequest;
import com.google.bigtable.admin.v2.GetBackupRequest;
import com.google.bigtable.admin.v2.GetTableRequest;
import com.google.bigtable.admin.v2.ListBackupsRequest;
import com.google.bigtable.admin.v2.ListTablesRequest;
import com.google.bigtable.admin.v2.RestoreTableMetadata;
import com.google.bigtable.admin.v2.Table.ClusterState;
import com.google.bigtable.admin.v2.Table.View;
import com.google.cloud.Policy;
import com.google.cloud.Policy.DefaultMarshaller;
import com.google.cloud.bigtable.admin.v2.BaseBigtableTableAdminClient.ListBackupsPage;
import com.google.cloud.bigtable.admin.v2.BaseBigtableTableAdminClient.ListBackupsPagedResponse;
import com.google.cloud.bigtable.admin.v2.BaseBigtableTableAdminClient.ListTablesPage;
import com.google.cloud.bigtable.admin.v2.BaseBigtableTableAdminClient.ListTablesPagedResponse;
import com.google.cloud.bigtable.admin.v2.internal.NameUtil;
import com.google.cloud.bigtable.admin.v2.models.Backup;
import com.google.cloud.bigtable.admin.v2.models.CreateBackupRequest;
import com.google.cloud.bigtable.admin.v2.models.CreateTableRequest;
import com.google.cloud.bigtable.admin.v2.models.EncryptionInfo;
import com.google.cloud.bigtable.admin.v2.models.GCRules;
import com.google.cloud.bigtable.admin.v2.models.ModifyColumnFamiliesRequest;
import com.google.cloud.bigtable.admin.v2.models.OptimizeRestoredTableOperationToken;
import com.google.cloud.bigtable.admin.v2.models.RestoreTableRequest;
import com.google.cloud.bigtable.admin.v2.models.RestoredTableResult;
import com.google.cloud.bigtable.admin.v2.models.Table;
import com.google.cloud.bigtable.admin.v2.models.UpdateBackupRequest;
import com.google.cloud.bigtable.admin.v2.stub.EnhancedBigtableTableAdminStub;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.protobuf.ByteString;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
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
 * // One instance per application.
 * BigtableTableAdminClient client =  BigtableTableAdminClient.create("[PROJECT]", "[INSTANCE]");
 *
 * CreateTableRequest request =
 *   CreateTableRequest.of("my-table")
 *     .addFamily("cf1")
 *     .addFamily("cf2", GCRULES.maxVersions(10))
 *     .addSplit(ByteString.copyFromUtf8("b"))
 *     .addSplit(ByteString.copyFromUtf8("q"));
 * client.createTable(request);
 *
 * // Cleanup during application shutdown.
 * client.close();
 * }</pre>
 *
 * <p>Creating a new client is a very expensive operation and should only be done once and shared in
 * an application. However, close() needs to be called on the client object to clean up resources
 * such as threads during application shutdown.
 *
 * <p>This class can be customized by passing in a custom instance of BigtableTableAdminSettings to
 * create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * BigtableTableAdminSettings settings = BigtableTableAdminSettings.newBuilder()
 *   .setProjectId("[PROJECT]")
 *   .setInstanceId("[INSTANCE]")
 *   .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *   .build();
 *
 * BigtableTableAdminClient client = BigtableTableAdminClient.create(settings);
 * }</pre>
 *
 * To customize the endpoint:
 *
 * <pre>{@code
 * BigtableTableAdminSettings.Builder settingsBuilder = BigtableTableAdminSettings.newBuilder()
 *   .setProjectId("[PROJECT]")
 *   .setInstanceId("[INSTANCE]");
 *
 * settingsBuilder.stubSettings()
 *   .setEndpoint(myEndpoint).build();
 *
 * BigtableTableAdminClient client = BigtableTableAdminClient.create(settingsBuilder.build());
 * }</pre>
 */
public final class BigtableTableAdminClient implements AutoCloseable {
  private final EnhancedBigtableTableAdminStub stub;
  private final String projectId;
  private final String instanceId;

  /** Constructs an instance of BigtableTableAdminClient with the given project and instance IDs. */
  public static BigtableTableAdminClient create(
      @Nonnull String projectId, @Nonnull String instanceId) throws IOException {
    return create(
        BigtableTableAdminSettings.newBuilder()
            .setProjectId(projectId)
            .setInstanceId(instanceId)
            .build());
  }

  /** Constructs an instance of BigtableTableAdminClient with the given settings. */
  public static BigtableTableAdminClient create(@Nonnull BigtableTableAdminSettings settings)
      throws IOException {
    EnhancedBigtableTableAdminStub stub =
        EnhancedBigtableTableAdminStub.createEnhanced(settings.getStubSettings());
    return create(settings.getProjectId(), settings.getInstanceId(), stub);
  }

  /** Constructs an instance of BigtableTableAdminClient with the given instance name and stub. */
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

  /** Gets the project ID of the instance whose tables this client manages. */
  public String getProjectId() {
    return projectId;
  }

  /** Gets the ID of the instance whose tables this client manages. */
  public String getInstanceId() {
    return instanceId;
  }

  @Override
  public void close() {
    stub.close();
  }

  /**
   * Creates a new table with the specified configuration.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // A table with a single column family, which retains only the latest value.
   * Table table = client.createTable(
   *   CreateTableRequest.of("my-table")
   *     .addFamily("cf2", GCRULES.maxVersions(1))
   * );
   *
   * // Another table with more complex garbage collection rules.
   * Table table = client.createTable(
   *   CreateTableRequest.of("my-table")
   *     .addFamily("cf2", GCRULES.union()
   *       .rule(GCRULES.maxAge(Duration.ofDays(30)))
   *       .rule(GCRULES.maxVersions(5))
   *     )
   * );
   * }</pre>
   *
   * @see CreateTableRequest for available options.
   * @see GCRules for the documentation on available garbage collection rules.
   */
  public Table createTable(CreateTableRequest request) {
    return ApiExceptions.callAndTranslateApiException(createTableAsync(request));
  }

  /**
   * Asynchronously creates a new table with the specified configuration.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // A table with a single column family, which retains values up to 7 days.
   * ApiFuture<Table> tableFuture = client.createTableAsync(
   *   CreateTableRequest.of("my-table")
   *     .addFamily("cf", GCRULES.maxAge(Duration.ofDays(7)))
   * );
   *
   * // Another table with more complex garbage collection rules.
   * ApiFuture<Table> tableFuture = client.createTableAsync(
   *   CreateTableRequest.of("my-table")
   *     .addFamily("cf", GCRULES.intersection()
   *       .rule(GCRULES.maxAge(120, TimeUnit.HOURS))
   *       .rule(GCRULES.maxVersions(10))
   *     )
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
   * @see GCRules for the documentation on available garbage collection rules.
   */
  @SuppressWarnings("WeakerAccess")
  public ApiFuture<Table> createTableAsync(CreateTableRequest request) {
    return transformToTableResponse(
        this.stub.createTableCallable().futureCall(request.toProto(projectId, instanceId)));
  }

  /**
   * Creates, updates and drops column families as specified in the request.
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
  public Table modifyFamilies(ModifyColumnFamiliesRequest request) {
    return ApiExceptions.callAndTranslateApiException(modifyFamiliesAsync(request));
  }

  /**
   * Asynchronously creates, updates, and drops column families as specified in the request.
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
   * Deletes the table specified by the table ID.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * client.deleteTable("my-table");
   * }</pre>
   */
  public void deleteTable(String tableId) {
    ApiExceptions.callAndTranslateApiException(deleteTableAsync(tableId));
  }

  /**
   * Asynchronously deletes the table specified by the table ID.
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
   * Checks if the table specified by the table ID exists.
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
   * Asynchronously checks if the table specified by the table ID exists.
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
   * Gets the table metadata by table ID.
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
  public Table getTable(String tableId) {
    return ApiExceptions.callAndTranslateApiException(getTableAsync(tableId));
  }

  /**
   * Asynchronously gets the table metadata by table ID.
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
   * Gets the current encryption info for the table across all of the clusters.
   *
   * <p>The returned Map will be keyed by cluster id and contain a status for all of the keys in
   * use.
   */
  public Map<String, List<EncryptionInfo>> getEncryptionInfo(String tableId) {
    return ApiExceptions.callAndTranslateApiException(getEncryptionInfoAsync(tableId));
  }

  /**
   * Asynchronously gets the current encryption info for the table across all of the clusters.
   *
   * <p>The returned Map will be keyed by cluster id and contain a status for all of the keys in
   * use.
   */
  public ApiFuture<Map<String, List<EncryptionInfo>>> getEncryptionInfoAsync(String tableId) {
    GetTableRequest request =
        GetTableRequest.newBuilder()
            .setName(getTableName(tableId))
            .setView(View.ENCRYPTION_VIEW)
            .build();
    return ApiFutures.transform(
        this.stub.getTableCallable().futureCall(request),
        new ApiFunction<com.google.bigtable.admin.v2.Table, Map<String, List<EncryptionInfo>>>() {
          @Override
          public Map<String, List<EncryptionInfo>> apply(com.google.bigtable.admin.v2.Table table) {
            ImmutableMap.Builder<String, List<EncryptionInfo>> result = ImmutableMap.builder();

            for (Map.Entry<String, ClusterState> entry : table.getClusterStatesMap().entrySet()) {
              ImmutableList.Builder<EncryptionInfo> infos = ImmutableList.builder();

              for (com.google.bigtable.admin.v2.EncryptionInfo infoProto :
                  entry.getValue().getEncryptionInfoList()) {
                infos.add(EncryptionInfo.fromProto(infoProto));
              }

              result.put(entry.getKey(), infos.build());
            }

            return result.build();
          }
        },
        MoreExecutors.directExecutor());
  }

  /**
   * Lists all table IDs in the instance.
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
  public List<String> listTables() {
    return ApiExceptions.callAndTranslateApiException(listTablesAsync());
  }

  /**
   * Asynchronously lists all table IDs in the instance.
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
  public ApiFuture<List<String>> listTablesAsync() {
    ListTablesRequest request =
        ListTablesRequest.newBuilder()
            .setParent(NameUtil.formatInstanceName(projectId, instanceId))
            .build();

    // TODO(igorbernstein2): try to upstream pagination spooling or figure out a way to expose the
    // paginated responses while maintaining the wrapper facade.

    // Fetches the first page.
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

    // Fetches the rest of the pages by chaining the futures.
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

    // Wraps all of the accumulated protos.
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
   * Drops rows by the specified row key prefix and table ID.
   *
   * <p>Please note that this method is considered part of the admin API and is rate limited.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * client.dropRowRange("my-table", "prefix");
   * }</pre>
   */
  public void dropRowRange(String tableId, String rowKeyPrefix) {
    ApiExceptions.callAndTranslateApiException(dropRowRangeAsync(tableId, rowKeyPrefix));
  }

  /**
   * Asynchronously drops rows by the specified row key prefix and table ID.
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
   * Drops rows by the specified row key prefix and table ID.
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
   * Asynchronously drops rows by the specified row key prefix and table ID.
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
   * Drops all data in the table.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * client.dropAllRows("my-table");
   * }</pre>
   */
  public void dropAllRows(String tableId) {
    ApiExceptions.callAndTranslateApiException(dropAllRowsAsync(tableId));
  }

  /**
   * Asynchronously drops all data in the table.
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
   * Blocks the current thread until replication has caught up to the point when this method was
   * called. This allows callers to make sure that their mutations have been replicated across all
   * of their clusters.
   *
   * <p>Sample code
   *
   * <pre>{@code
   * client.awaitReplication("my-table");
   * }</pre>
   *
   * @throws com.google.api.gax.retrying.PollException when polling exceeds the total timeout
   */
  public void awaitReplication(String tableId) {
    // TODO(igorbernstein2): remove usage of typesafe names
    com.google.bigtable.admin.v2.TableName tableName =
        com.google.bigtable.admin.v2.TableName.of(projectId, instanceId, tableId);

    ApiExceptions.callAndTranslateApiException(
        stub.awaitReplicationCallable().futureCall(tableName));
  }

  /**
   * Creates a backup with the specified configuration.
   *
   * <p>Sample code
   *
   * <pre>{@code
   * CreateBackupRequest request =
   *         CreateBackupRequest.of(clusterId, backupId)
   *             .setSourceTableId(tableId)
   *             .setExpireTime(expireTime);
   * Backup response = client.createBackup(request);
   * }</pre>
   */
  public Backup createBackup(CreateBackupRequest request) {
    return ApiExceptions.callAndTranslateApiException(createBackupAsync(request));
  }

  /**
   * Creates a backup with the specified configuration asynchronously.
   *
   * <p>Sample code
   *
   * <pre>{@code
   * CreateBackupRequest request =
   *         CreateBackupRequest.of(clusterId, backupId)
   *             .setSourceTableId(tableId)
   *             .setExpireTime(expireTime);
   * ApiFuture<Backup> future = client.createBackupAsync(request);
   *
   * ApiFutures.addCallback(
   *   future,
   *   new ApiFutureCallback<Backup>() {
   *     public void onSuccess(Backup backup) {
   *       System.out.println("Successfully create the backup " + backup.getId());
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
  public ApiFuture<Backup> createBackupAsync(CreateBackupRequest request) {
    return ApiFutures.transform(
        stub.createBackupOperationCallable().futureCall(request.toProto(projectId, instanceId)),
        new ApiFunction<com.google.bigtable.admin.v2.Backup, Backup>() {
          @Override
          public Backup apply(com.google.bigtable.admin.v2.Backup backupProto) {
            return Backup.fromProto(backupProto);
          }
        },
        MoreExecutors.directExecutor());
  }

  /**
   * Gets a backup with the specified backup ID in the specified cluster.
   *
   * <p>Sample code
   *
   * <pre>{@code
   * Backup backup = client.getBackup(clusterId, backupId);
   * }</pre>
   */
  public Backup getBackup(String clusterId, String backupId) {
    return ApiExceptions.callAndTranslateApiException(getBackupAsync(clusterId, backupId));
  }

  /**
   * Gets a backup with the specified backup ID in the specified cluster asynchronously.
   *
   * <p>Sample code
   *
   * <pre>{@code
   * ApiFuture<Backup> future = client.getBackupAsync(clusterId, backupId);
   *
   * ApiFutures.addCallback(
   *   future,
   *   new ApiFutureCallback<Backup>() {
   *     public void onSuccess(Backup backup) {
   *       System.out.println("Successfully get the backup " + backup.getId());
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
  public ApiFuture<Backup> getBackupAsync(String clusterId, String backupId) {
    GetBackupRequest request =
        GetBackupRequest.newBuilder()
            .setName(NameUtil.formatBackupName(projectId, instanceId, clusterId, backupId))
            .build();
    return ApiFutures.transform(
        this.stub.getBackupCallable().futureCall(request),
        new ApiFunction<com.google.bigtable.admin.v2.Backup, Backup>() {
          @Override
          public Backup apply(com.google.bigtable.admin.v2.Backup backup) {
            return Backup.fromProto(backup);
          }
        },
        MoreExecutors.directExecutor());
  }

  /**
   * Lists backups in the specified cluster.
   *
   * <p>Sample code
   *
   * <pre>{@code
   * List<String> backups = client.listBackups(clusterId);
   * }</pre>
   */
  public List<String> listBackups(String clusterId) {
    return ApiExceptions.callAndTranslateApiException(listBackupsAsync(clusterId));
  }

  /**
   * Lists backups in the specified cluster asynchronously.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * ApiFuture<List<String>> listFuture = client.listBackupsAsync(clusterId);
   *
   * ApiFutures.addCallback(
   *   listFuture,
   *   new ApiFutureCallback<List<String>>() {
   *     public void onSuccess(List<String> backupIds) {
   *       System.out.println("Got list of backups:");
   *       for (String backupId : backupIds) {
   *         System.out.println(backupId);
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
  public ApiFuture<List<String>> listBackupsAsync(String clusterId) {
    ListBackupsRequest request =
        ListBackupsRequest.newBuilder()
            .setParent(NameUtil.formatClusterName(projectId, instanceId, clusterId))
            .build();

    // TODO(igorbernstein2): try to upstream pagination spooling or figure out a way to expose the
    // paginated responses while maintaining the wrapper facade.

    // Fetches the first page.
    ApiFuture<ListBackupsPage> firstPageFuture =
        ApiFutures.transform(
            stub.listBackupsPagedCallable().futureCall(request),
            new ApiFunction<ListBackupsPagedResponse, ListBackupsPage>() {
              @Override
              public ListBackupsPage apply(ListBackupsPagedResponse response) {
                return response.getPage();
              }
            },
            MoreExecutors.directExecutor());

    // Fetches the rest of the pages by chaining the futures.
    ApiFuture<List<com.google.bigtable.admin.v2.Backup>> allProtos =
        ApiFutures.transformAsync(
            firstPageFuture,
            new ApiAsyncFunction<ListBackupsPage, List<com.google.bigtable.admin.v2.Backup>>() {
              List<com.google.bigtable.admin.v2.Backup> responseAccumulator = Lists.newArrayList();

              @Override
              public ApiFuture<List<com.google.bigtable.admin.v2.Backup>> apply(
                  ListBackupsPage page) {
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

    // Wraps all of the accumulated protos.
    return ApiFutures.transform(
        allProtos,
        new ApiFunction<List<com.google.bigtable.admin.v2.Backup>, List<String>>() {
          @Override
          public List<String> apply(List<com.google.bigtable.admin.v2.Backup> protos) {
            List<String> results = Lists.newArrayListWithCapacity(protos.size());
            for (com.google.bigtable.admin.v2.Backup proto : protos) {
              results.add(NameUtil.extractBackupIdFromBackupName(proto.getName()));
            }
            return results;
          }
        },
        MoreExecutors.directExecutor());
  }

  /**
   * Deletes a backup with the specified backup ID in the specified cluster.
   *
   * <p>Sample code
   *
   * <pre>{@code
   * client.deleteBackup(clusterId, backupId);
   * }</pre>
   */
  public void deleteBackup(String clusterId, String backupId) {
    ApiExceptions.callAndTranslateApiException(deleteBackupAsync(clusterId, backupId));
  }

  /**
   * Deletes a backup with the specified backup ID in the specified cluster asynchronously.
   *
   * <p>Sample code
   *
   * <pre>{@code
   * ApiFuture<Void> future = client.deleteBackupAsync(clusterId, backupId);
   *
   * ApiFutures.addCallback(
   *   future,
   *   new ApiFutureCallback<Backup>() {
   *     public void onSuccess(Void unused) {
   *       System.out.println("Successfully delete the backup.");
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
  public ApiFuture<Void> deleteBackupAsync(String clusterId, String backupId) {
    DeleteBackupRequest request =
        DeleteBackupRequest.newBuilder()
            .setName(NameUtil.formatBackupName(projectId, instanceId, clusterId, backupId))
            .build();

    return transformToVoid(this.stub.deleteBackupCallable().futureCall(request));
  }

  /**
   * Updates a backup with the specified configuration.
   *
   * <p>Sample code
   *
   * <pre>{@code
   * Backup backup = client.updateBackup(clusterId, backupId);
   * }</pre>
   */
  public Backup updateBackup(UpdateBackupRequest request) {
    return ApiExceptions.callAndTranslateApiException(updateBackupAsync(request));
  }

  /**
   * Updates a backup with the specified configuration asynchronously.
   *
   * <p>Sample code
   *
   * <pre>{@code
   * ApiFuture<Backup> future = client.updateBackupAsync(clusterId, backupId);
   *
   * ApiFutures.addCallback(
   *   future,
   *   new ApiFutureCallback<Backup>() {
   *     public void onSuccess(Backup backup) {
   *       System.out.println("Successfully update the backup " + backup.getId());
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
  public ApiFuture<Backup> updateBackupAsync(UpdateBackupRequest request) {
    return ApiFutures.transform(
        stub.updateBackupCallable().futureCall(request.toProto(projectId, instanceId)),
        new ApiFunction<com.google.bigtable.admin.v2.Backup, Backup>() {
          @Override
          public Backup apply(com.google.bigtable.admin.v2.Backup proto) {
            return Backup.fromProto(proto);
          }
        },
        MoreExecutors.directExecutor());
  }

  /**
   * Restores a backup to a new table with the specified configuration.
   *
   * <p>Sample code
   *
   * <pre>{@code
   * RestoredTableResult result =
   *     client.restoreTable(RestoreTableRequest.of(clusterId, backupId).setTableId(tableId));
   * }</pre>
   */
  public RestoredTableResult restoreTable(RestoreTableRequest request)
      throws ExecutionException, InterruptedException {
    return ApiExceptions.callAndTranslateApiException(restoreTableAsync(request));
  }

  /** Restores a backup to a new table with the specified configuration asynchronously.
   * <p>Sample code
   *
   * <pre>{@code
   * ApiFuture<RestoredTableResult> future = client.restoreTableAsync(
   *     RestoreTableRequest.of(clusterId, backupId).setTableId(tableId));
   *
   * ApiFutures.addCallback(
   *   future,
   *   new ApiFutureCallback<RestoredTableResult>() {
   *     public void onSuccess(RestoredTableResult result) {
   *       System.out.println("Successfully restore the table.");
   *     }
   *
   *     public void onFailure(Throwable t) {
   *       t.printStackTrace();
   *     }
   *   },
   *   MoreExecutors.directExecutor()
   * );
   * </pre>
   * */
  public ApiFuture<RestoredTableResult> restoreTableAsync(RestoreTableRequest request) {
    final OperationFuture<com.google.bigtable.admin.v2.Table, RestoreTableMetadata> future =
        this.stub
            .restoreTableOperationCallable()
            .futureCall(request.toProto(projectId, instanceId));
    return ApiFutures.transformAsync(
        future,
        new ApiAsyncFunction<com.google.bigtable.admin.v2.Table, RestoredTableResult>() {
          @Override
          public ApiFuture<RestoredTableResult> apply(com.google.bigtable.admin.v2.Table table)
              throws Exception {
            return ApiFutures.immediateFuture(
                // When apply is called, the future should have been resolved and it's safe to
                // pull the metadata.
                new RestoredTableResult(
                    Table.fromProto(table),
                    future.getMetadata().get().getOptimizeTableOperationName()));
          }
        },
        MoreExecutors.directExecutor());
  }

  /**
   * Awaits a restored table is fully optimized.
   *
   * <p>Sample code
   *
   * <pre>{@code
   * RestoredTableResult result =
   *     client.restoreTable(RestoreTableRequest.of(clusterId, backupId).setTableId(tableId));
   * client.awaitOptimizeRestoredTable(result.getOptimizeRestoredTableOperationToken());
   * }</pre>
   */
  public void awaitOptimizeRestoredTable(OptimizeRestoredTableOperationToken token)
      throws ExecutionException, InterruptedException {
    awaitOptimizeRestoredTableAsync(token).get();
  }

  /**
   * Awaits a restored table is fully optimized asynchronously.
   *
   * <p>Sample code
   *
   * <pre>{@code
   * RestoredTableResult result =
   *     client.restoreTable(RestoreTableRequest.of(clusterId, backupId).setTableId(tableId));
   * ApiFuture<Void> future = client.awaitOptimizeRestoredTableAsync(
   *     result.getOptimizeRestoredTableOperationToken());
   *
   * ApiFutures.addCallback(
   *   future,
   *   new ApiFutureCallback<Void>() {
   *     public void onSuccess(Void unused) {
   *       System.out.println("The optimization of the restored table is done.");
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
  public ApiFuture<Void> awaitOptimizeRestoredTableAsync(
      OptimizeRestoredTableOperationToken token) {
    return transformToVoid(
        stub.awaitOptimizeRestoredTableCallable().resumeFutureCall(token.getOperationName()));
  }

  /**
   * Returns a future that is resolved when replication has caught up to the point when this method
   * was called. This allows callers to make sure that their mutations have been replicated across
   * all of their clusters.
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
    // TODO(igorbernstein2): remove usage of typesafe names
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

  /**
   * Gets the IAM access control policy for the specified table.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * Policy policy = client.getIamPolicy("my-table");
   * for(Map.Entry<Role, Set<Identity>> entry : policy.getBindings().entrySet()) {
   *   System.out.printf("Role: %s Identities: %s\n", entry.getKey(), entry.getValue());
   * }
   * }</pre>
   *
   * @see <a
   *     href="https://cloud.google.com/bigtable/docs/access-control#iam-management-table">Table-level
   *     IAM management</a>
   */
  @SuppressWarnings("WeakerAccess")
  public Policy getIamPolicy(String tableId) {
    return ApiExceptions.callAndTranslateApiException(getIamPolicyAsync(tableId));
  }

  /**
   * Asynchronously gets the IAM access control policy for the specified table.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * ApiFuture<Policy> policyFuture = client.getIamPolicyAsync("my-table");
   *
   * ApiFutures.addCallback(policyFuture,
   *   new ApiFutureCallback<Policy>() {
   *     public void onSuccess(Policy policy) {
   *       for (Entry<Role, Set<Identity>> entry : policy.getBindings().entrySet()) {
   *         System.out.printf("Role: %s Identities: %s\n", entry.getKey(), entry.getValue());
   *       }
   *     }
   *
   *     public void onFailure(Throwable t) {
   *       t.printStackTrace();
   *     }
   *   },
   *   MoreExecutors.directExecutor());
   * }</pre>
   *
   * @see <a
   *     href="https://cloud.google.com/bigtable/docs/access-control#iam-management-table">Table-level
   *     IAM management</a>
   */
  @SuppressWarnings("WeakerAccess")
  public ApiFuture<Policy> getIamPolicyAsync(String tableId) {
    String tableName = NameUtil.formatTableName(projectId, instanceId, tableId);
    return getResourceIamPolicy(tableName);
  }

  /**
   * Replaces the IAM policy associated with the specified table.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * Policy newPolicy = client.setIamPolicy("my-table",
   *   Policy.newBuilder()
   *     .addIdentity(Role.of("bigtable.user"), Identity.user("someone@example.com"))
   *     .addIdentity(Role.of("bigtable.admin"), Identity.group("admins@example.com"))
   *     .build());
   * }</pre>
   *
   * @see <a
   *     href="https://cloud.google.com/bigtable/docs/access-control#iam-management-table">Table-level
   *     IAM management</a>
   */
  @SuppressWarnings("WeakerAccess")
  public Policy setIamPolicy(String tableId, Policy policy) {
    return ApiExceptions.callAndTranslateApiException(setIamPolicyAsync(tableId, policy));
  }

  /**
   * Asynchronously replaces the IAM policy associated with the specified table.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * ApiFuture<Policy> newPolicyFuture = client.setIamPolicyAsync("my-table",
   *   Policy.newBuilder()
   *     .addIdentity(Role.of("bigtable.user"), Identity.user("someone@example.com"))
   *     .addIdentity(Role.of("bigtable.admin"), Identity.group("admins@example.com"))
   *     .build());
   *
   * ApiFutures.addCallback(policyFuture,
   *   new ApiFutureCallback<Policy>() {
   *     public void onSuccess(Policy policy) {
   *       for (Entry<Role, Set<Identity>> entry : policy.getBindings().entrySet()) {
   *         System.out.printf("Role: %s Identities: %s\n", entry.getKey(), entry.getValue());
   *       }
   *     }
   *
   *     public void onFailure(Throwable t) {
   *       t.printStackTrace();
   *     }
   *   },
   *   MoreExecutors.directExecutor());
   * }</pre>
   *
   * @see <a
   *     href="https://cloud.google.com/bigtable/docs/access-control#iam-management-table">Table-level
   *     IAM management</a>
   */
  @SuppressWarnings("WeakerAccess")
  public ApiFuture<Policy> setIamPolicyAsync(String tableId, Policy policy) {
    String tableName = NameUtil.formatTableName(projectId, instanceId, tableId);
    return setResourceIamPolicy(policy, tableName);
  }

  /**
   * Tests whether the caller has the given permissions for the specified table. Returns a subset of
   * the specified permissions that the caller has.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * List<String> grantedPermissions = client.testIamPermission("my-table",
   *   "bigtable.tables.readRows", "bigtable.tables.mutateRows");
   * }</pre>
   *
   * System.out.println("Has read access: " +
   * grantedPermissions.contains("bigtable.tables.readRows")); System.out.println("Has write access:
   * " + grantedPermissions.contains("bigtable.tables.mutateRows"));
   *
   * @see <a href="https://cloud.google.com/bigtable/docs/access-control#permissions">Cloud Bigtable
   *     permissions</a>
   */
  @SuppressWarnings({"WeakerAccess"})
  public List<String> testIamPermission(String tableId, String... permissions) {
    return ApiExceptions.callAndTranslateApiException(testIamPermissionAsync(tableId, permissions));
  }

  /**
   * Asynchronously tests whether the caller has the given permissions for the specified table.
   * Returns a subset of the specified permissions that the caller has.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * ApiFuture<List<String>> grantedPermissionsFuture = client.testIamPermissionAsync("my-table",
   *   "bigtable.tables.readRows", "bigtable.tables.mutateRows");
   *
   * ApiFutures.addCallback(grantedPermissionsFuture,
   *   new ApiFutureCallback<List<String>>() {
   *     public void onSuccess(List<String> grantedPermissions) {
   *       System.out.println("Has read access: " + grantedPermissions.contains("bigtable.tables.readRows"));
   *       System.out.println("Has write access: " + grantedPermissions.contains("bigtable.tables.mutateRows"));
   *     }
   *
   *     public void onFailure(Throwable t) {
   *       t.printStackTrace();
   *     }
   *   },
   *   MoreExecutors.directExecutor());
   * }</pre>
   *
   * @see <a href="https://cloud.google.com/bigtable/docs/access-control#permissions">Cloud Bigtable
   *     permissions</a>
   */
  @SuppressWarnings({"WeakerAccess"})
  public ApiFuture<List<String>> testIamPermissionAsync(String tableId, String... permissions) {
    String tableName = NameUtil.formatTableName(projectId, instanceId, tableId);
    return testResourceIamPermissions(tableName, permissions);
  }

  /**
   * Gets the IAM access control policy for the specified backup.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * Policy policy = client.getBackupIamPolicy("my-cluster-id", "my-backup-id");
   * for(Map.Entry<Role, Set<Identity>> entry : policy.getBindings().entrySet()) {
   *   System.out.printf("Role: %s Identities: %s\n", entry.getKey(), entry.getValue());
   * }
   * }</pre>
   *
   * @see <a
   *     href="https://cloud.google.com/bigtable/docs/access-control#iam-management-table">Table-level
   *     IAM management</a>
   */
  @SuppressWarnings("WeakerAccess")
  public Policy getBackupIamPolicy(String clusterId, String backupId) {
    return ApiExceptions.callAndTranslateApiException(getBackupIamPolicyAsync(clusterId, backupId));
  }

  /**
   * Asynchronously gets the IAM access control policy for the specified backup.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * ApiFuture<Policy> policyFuture = client.getBackupIamPolicyAsync("my-cluster-id", "my-backup-id");
   *
   * ApiFutures.addCallback(policyFuture,
   *   new ApiFutureCallback<Policy>() {
   *     public void onSuccess(Policy policy) {
   *       for (Entry<Role, Set<Identity>> entry : policy.getBindings().entrySet()) {
   *         System.out.printf("Role: %s Identities: %s\n", entry.getKey(), entry.getValue());
   *       }
   *     }
   *
   *     public void onFailure(Throwable t) {
   *       t.printStackTrace();
   *     }
   *   },
   *   MoreExecutors.directExecutor());
   * }</pre>
   *
   * @see <a
   *     href="https://cloud.google.com/bigtable/docs/access-control#iam-management-table">Table-level
   *     IAM management</a>
   */
  @SuppressWarnings("WeakerAccess")
  public ApiFuture<Policy> getBackupIamPolicyAsync(String clusterId, String backupId) {
    String backupName = NameUtil.formatBackupName(projectId, instanceId, clusterId, backupId);
    return getResourceIamPolicy(backupName);
  }

  /**
   * Replaces the IAM policy associated with the specified backup.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * Policy newPolicy = client.setBackupIamPolicy("my-cluster-id", "my-backup-id",
   *   Policy.newBuilder()
   *     .addIdentity(Role.of("bigtable.user"), Identity.user("someone@example.com"))
   *     .addIdentity(Role.of("bigtable.admin"), Identity.group("admins@example.com"))
   *     .build());
   * }</pre>
   *
   * @see <a
   *     href="https://cloud.google.com/bigtable/docs/access-control#iam-management-table">Table-level
   *     IAM management</a>
   */
  @SuppressWarnings("WeakerAccess")
  public Policy setBackupIamPolicy(String clusterId, String backupId, Policy policy) {
    return ApiExceptions.callAndTranslateApiException(
        setBackupIamPolicyAsync(clusterId, backupId, policy));
  }

  /**
   * Asynchronously replaces the IAM policy associated with the specified backup.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * ApiFuture<Policy> newPolicyFuture = client.setBackupIamPolicyAsync("my-cluster-id", "my-backup-id",
   *   Policy.newBuilder()
   *     .addIdentity(Role.of("bigtable.user"), Identity.user("someone@example.com"))
   *     .addIdentity(Role.of("bigtable.admin"), Identity.group("admins@example.com"))
   *     .build());
   *
   * ApiFutures.addCallback(newPolicyFuture,
   *   new ApiFutureCallback<Policy>() {
   *     public void onSuccess(Policy policy) {
   *       for (Entry<Role, Set<Identity>> entry : policy.getBindings().entrySet()) {
   *         System.out.printf("Role: %s Identities: %s\n", entry.getKey(), entry.getValue());
   *       }
   *     }
   *
   *     public void onFailure(Throwable t) {
   *       t.printStackTrace();
   *     }
   *   },
   *   MoreExecutors.directExecutor());
   * }</pre>
   *
   * @see <a
   *     href="https://cloud.google.com/bigtable/docs/access-control#iam-management-table">Table-level
   *     IAM management</a>
   */
  @SuppressWarnings("WeakerAccess")
  public ApiFuture<Policy> setBackupIamPolicyAsync(
      String clusterId, String backupId, Policy policy) {
    String backupName = NameUtil.formatBackupName(projectId, instanceId, clusterId, backupId);
    return setResourceIamPolicy(policy, backupName);
  }

  /**
   * Tests whether the caller has the given permissions for the specified backup. Returns a subset
   * of the specified permissions that the caller has.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * List<String> grantedPermissions = client.testBackupIamPermission("my-cluster-id", "my-backup-id",
   *   "bigtable.backups.restore", "bigtable.backups.delete");
   * }</pre>
   *
   * System.out.println("Has restore access: " +
   * grantedPermissions.contains("bigtable.backups.restore"));
   *
   * <p>System.out.println("Has delete access: " +
   * grantedPermissions.contains("bigtable.backups.delete"));
   *
   * @see <a href="https://cloud.google.com/bigtable/docs/access-control#permissions">Cloud Bigtable
   *     permissions</a>
   */
  @SuppressWarnings({"WeakerAccess"})
  public List<String> testBackupIamPermission(
      String clusterId, String backupId, String... permissions) {
    return ApiExceptions.callAndTranslateApiException(
        testBackupIamPermissionAsync(clusterId, backupId, permissions));
  }

  /**
   * Asynchronously tests whether the caller has the given permissions for the specified backup.
   * Returns a subset of the specified permissions that the caller has.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * ApiFuture<List<String>> grantedPermissionsFuture = client.testBackupIamPermissionAsync("my-cluster-id", "my-backup-id",
   *   "bigtable.backups.restore", "bigtable.backups.delete");
   *
   * ApiFutures.addCallback(grantedPermissionsFuture,
   *   new ApiFutureCallback<List<String>>() {
   *     public void onSuccess(List<String> grantedPermissions) {
   *       System.out.println("Has restore access: " + grantedPermissions.contains("bigtable.backups.restore"));
   *       System.out.println("Has delete access: " + grantedPermissions.contains("bigtable.backups.delete"));
   *     }
   *
   *     public void onFailure(Throwable t) {
   *       t.printStackTrace();
   *     }
   *   },
   *   MoreExecutors.directExecutor());
   * }</pre>
   *
   * @see <a href="https://cloud.google.com/bigtable/docs/access-control#permissions">Cloud Bigtable
   *     permissions</a>
   */
  @SuppressWarnings({"WeakerAccess"})
  public ApiFuture<List<String>> testBackupIamPermissionAsync(
      String clusterId, String backupId, String... permissions) {
    String backupName = NameUtil.formatBackupName(projectId, instanceId, clusterId, backupId);
    return testResourceIamPermissions(backupName, permissions);
  }

  private ApiFuture<Policy> getResourceIamPolicy(String name) {
    GetIamPolicyRequest request = GetIamPolicyRequest.newBuilder().setResource(name).build();

    final IamPolicyMarshaller marshaller = new IamPolicyMarshaller();

    return ApiFutures.transform(
        stub.getIamPolicyCallable().futureCall(request),
        new ApiFunction<com.google.iam.v1.Policy, Policy>() {
          @Override
          public Policy apply(com.google.iam.v1.Policy proto) {
            return marshaller.fromPb(proto);
          }
        },
        MoreExecutors.directExecutor());
  }

  private ApiFuture<Policy> setResourceIamPolicy(Policy policy, String name) {
    final IamPolicyMarshaller marshaller = new IamPolicyMarshaller();

    SetIamPolicyRequest request =
        SetIamPolicyRequest.newBuilder()
            .setResource(name)
            .setPolicy(marshaller.toPb(policy))
            .build();

    return ApiFutures.transform(
        stub.setIamPolicyCallable().futureCall(request),
        new ApiFunction<com.google.iam.v1.Policy, Policy>() {
          @Override
          public Policy apply(com.google.iam.v1.Policy proto) {
            return marshaller.fromPb(proto);
          }
        },
        MoreExecutors.directExecutor());
  }

  private ApiFuture<List<String>> testResourceIamPermissions(
      String resourceName, String[] permissions) {
    TestIamPermissionsRequest request =
        TestIamPermissionsRequest.newBuilder()
            .setResource(resourceName)
            .addAllPermissions(Arrays.asList(permissions))
            .build();

    return ApiFutures.transform(
        stub.testIamPermissionsCallable().futureCall(request),
        new ApiFunction<TestIamPermissionsResponse, List<String>>() {
          @Override
          public List<String> apply(TestIamPermissionsResponse input) {
            return input.getPermissionsList();
          }
        },
        MoreExecutors.directExecutor());
  }

  /**
   * Simple adapter to expose {@link DefaultMarshaller} to this class. It enables this client to
   * convert to/from IAM wrappers and protobufs.
   */
  private static class IamPolicyMarshaller extends DefaultMarshaller {
    @Override
    public Policy fromPb(com.google.iam.v1.Policy policyPb) {
      return super.fromPb(policyPb);
    }

    @Override
    public com.google.iam.v1.Policy toPb(Policy policy) {
      return super.toPb(policy);
    }
  }
}
