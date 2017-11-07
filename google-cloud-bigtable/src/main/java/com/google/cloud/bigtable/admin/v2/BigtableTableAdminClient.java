/*
 * Copyright 2017 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.bigtable.admin.v2;

import static com.google.cloud.bigtable.admin.v2.PagedResponseWrappers.ListTablesPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.bigtable.admin.v2.CreateTableRequest;
import com.google.bigtable.admin.v2.DeleteTableRequest;
import com.google.bigtable.admin.v2.DropRowRangeRequest;
import com.google.bigtable.admin.v2.GetTableRequest;
import com.google.bigtable.admin.v2.InstanceName;
import com.google.bigtable.admin.v2.ListTablesRequest;
import com.google.bigtable.admin.v2.ListTablesResponse;
import com.google.bigtable.admin.v2.ModifyColumnFamiliesRequest;
import com.google.bigtable.admin.v2.ModifyColumnFamiliesRequest.Modification;
import com.google.bigtable.admin.v2.Table;
import com.google.bigtable.admin.v2.TableName;
import com.google.cloud.bigtable.admin.v2.stub.BigtableTableAdminStub;
import com.google.protobuf.ByteString;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND SERVICE
/**
 * Service Description: Service for creating, configuring, and deleting Cloud Bigtable tables.
 *
 * <p>Provides access to the table schemas only, not the data stored within the tables.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>
 * <code>
 * try (BigtableTableAdminClient bigtableTableAdminClient = BigtableTableAdminClient.create()) {
 *   InstanceName parent = InstanceName.of("[PROJECT]", "[INSTANCE]");
 *   String tableId = "";
 *   Table table = Table.newBuilder().build();
 *   Table response = bigtableTableAdminClient.createTable(parent, tableId, table);
 * }
 * </code>
 * </pre>
 *
 * <p>Note: close() needs to be called on the bigtableTableAdminClient object to clean up resources
 * such as threads. In the example above, try-with-resources is used, which automatically calls
 * close().
 *
 * <p>The surface of this class includes several types of Java methods for each of the API's
 * methods:
 *
 * <ol>
 *   <li> A "flattened" method. With this type of method, the fields of the request type have been
 *       converted into function parameters. It may be the case that not all fields are available as
 *       parameters, and not every API method will have a flattened method entry point.
 *   <li> A "request object" method. This type of method only takes one parameter, a request object,
 *       which must be constructed before the call. Not every API method will have a request object
 *       method.
 *   <li> A "callable" method. This type of method takes no parameters and returns an immutable API
 *       callable object, which can be used to initiate calls to the service.
 * </ol>
 *
 * <p>See the individual methods for example code.
 *
 * <p>Many parameters require resource names to be formatted in a particular way. To assist with
 * these names, this class includes a format method for each type of name, and additionally a parse
 * method to extract the individual identifiers contained within names that are returned.
 *
 * <p>This class can be customized by passing in a custom instance of BigtableTableAdminSettings to
 * create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>
 * <code>
 * BigtableTableAdminSettings bigtableTableAdminSettings =
 *     BigtableTableAdminSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * BigtableTableAdminClient bigtableTableAdminClient =
 *     BigtableTableAdminClient.create(bigtableTableAdminSettings);
 * </code>
 * </pre>
 *
 * To customize the endpoint:
 *
 * <pre>
 * <code>
 * BigtableTableAdminSettings bigtableTableAdminSettings =
 *     BigtableTableAdminSettings.newBuilder()
 *         .setTransportChannelProvider(BigtableTableAdminSettings.defaultGrpcTransportProviderBuilder()
 *             .setEndpoint(myEndpoint)
 *             .build())
 *         .build();
 * BigtableTableAdminClient bigtableTableAdminClient =
 *     BigtableTableAdminClient.create(bigtableTableAdminSettings);
 * </code>
 * </pre>
 */
@Generated("by GAPIC v0.0.5")
@BetaApi
public class BigtableTableAdminClient implements BackgroundResource {
  private final BigtableTableAdminSettings settings;
  private final BigtableTableAdminStub stub;

  /** Constructs an instance of BigtableTableAdminClient with default settings. */
  public static final BigtableTableAdminClient create() throws IOException {
    return create(BigtableTableAdminSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of BigtableTableAdminClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final BigtableTableAdminClient create(BigtableTableAdminSettings settings)
      throws IOException {
    return new BigtableTableAdminClient(settings);
  }

  /**
   * Constructs an instance of BigtableTableAdminClient, using the given stub for making calls. This
   * is for advanced usage - prefer to use BigtableTableAdminSettings}.
   */
  @BetaApi
  public static final BigtableTableAdminClient create(BigtableTableAdminStub stub) {
    return new BigtableTableAdminClient(stub);
  }

  /**
   * Constructs an instance of BigtableTableAdminClient, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected BigtableTableAdminClient(BigtableTableAdminSettings settings) throws IOException {
    this.settings = settings;
    this.stub = settings.createStub();
  }

  protected BigtableTableAdminClient(BigtableTableAdminStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final BigtableTableAdminSettings getSettings() {
    return settings;
  }

  @BetaApi
  public BigtableTableAdminStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a new table in the specified instance. The table can be created with a full set of
   * initial column families, specified in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BigtableTableAdminClient bigtableTableAdminClient = BigtableTableAdminClient.create()) {
   *   InstanceName parent = InstanceName.of("[PROJECT]", "[INSTANCE]");
   *   String tableId = "";
   *   Table table = Table.newBuilder().build();
   *   Table response = bigtableTableAdminClient.createTable(parent, tableId, table);
   * }
   * </code></pre>
   *
   * @param parent The unique name of the instance in which to create the table. Values are of the
   *     form `projects/&lt;project&gt;/instances/&lt;instance&gt;`.
   * @param tableId The name by which the new table should be referred to within the parent
   *     instance, e.g., `foobar` rather than `&lt;parent&gt;/tables/foobar`.
   * @param table The Table to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Table createTable(InstanceName parent, String tableId, Table table) {

    CreateTableRequest request =
        CreateTableRequest.newBuilder()
            .setParentWithInstanceName(parent)
            .setTableId(tableId)
            .setTable(table)
            .build();
    return createTable(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a new table in the specified instance. The table can be created with a full set of
   * initial column families, specified in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BigtableTableAdminClient bigtableTableAdminClient = BigtableTableAdminClient.create()) {
   *   InstanceName parent = InstanceName.of("[PROJECT]", "[INSTANCE]");
   *   String tableId = "";
   *   Table table = Table.newBuilder().build();
   *   CreateTableRequest request = CreateTableRequest.newBuilder()
   *     .setParentWithInstanceName(parent)
   *     .setTableId(tableId)
   *     .setTable(table)
   *     .build();
   *   Table response = bigtableTableAdminClient.createTable(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Table createTable(CreateTableRequest request) {
    return createTableCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a new table in the specified instance. The table can be created with a full set of
   * initial column families, specified in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BigtableTableAdminClient bigtableTableAdminClient = BigtableTableAdminClient.create()) {
   *   InstanceName parent = InstanceName.of("[PROJECT]", "[INSTANCE]");
   *   String tableId = "";
   *   Table table = Table.newBuilder().build();
   *   CreateTableRequest request = CreateTableRequest.newBuilder()
   *     .setParentWithInstanceName(parent)
   *     .setTableId(tableId)
   *     .setTable(table)
   *     .build();
   *   ApiFuture&lt;Table&gt; future = bigtableTableAdminClient.createTableCallable().futureCall(request);
   *   // Do something
   *   Table response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<CreateTableRequest, Table> createTableCallable() {
    return stub.createTableCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists all tables served from a specified instance.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BigtableTableAdminClient bigtableTableAdminClient = BigtableTableAdminClient.create()) {
   *   InstanceName parent = InstanceName.of("[PROJECT]", "[INSTANCE]");
   *   for (Table element : bigtableTableAdminClient.listTables(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param parent The unique name of the instance for which tables should be listed. Values are of
   *     the form `projects/&lt;project&gt;/instances/&lt;instance&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListTablesPagedResponse listTables(InstanceName parent) {
    ListTablesRequest request =
        ListTablesRequest.newBuilder().setParentWithInstanceName(parent).build();
    return listTables(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists all tables served from a specified instance.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BigtableTableAdminClient bigtableTableAdminClient = BigtableTableAdminClient.create()) {
   *   InstanceName parent = InstanceName.of("[PROJECT]", "[INSTANCE]");
   *   ListTablesRequest request = ListTablesRequest.newBuilder()
   *     .setParentWithInstanceName(parent)
   *     .build();
   *   for (Table element : bigtableTableAdminClient.listTables(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  private final ListTablesPagedResponse listTables(ListTablesRequest request) {
    return listTablesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists all tables served from a specified instance.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BigtableTableAdminClient bigtableTableAdminClient = BigtableTableAdminClient.create()) {
   *   InstanceName parent = InstanceName.of("[PROJECT]", "[INSTANCE]");
   *   ListTablesRequest request = ListTablesRequest.newBuilder()
   *     .setParentWithInstanceName(parent)
   *     .build();
   *   ApiFuture&lt;ListTablesPagedResponse&gt; future = bigtableTableAdminClient.listTablesPagedCallable().futureCall(request);
   *   // Do something
   *   for (Table element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  public final UnaryCallable<ListTablesRequest, ListTablesPagedResponse> listTablesPagedCallable() {
    return stub.listTablesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists all tables served from a specified instance.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BigtableTableAdminClient bigtableTableAdminClient = BigtableTableAdminClient.create()) {
   *   InstanceName parent = InstanceName.of("[PROJECT]", "[INSTANCE]");
   *   ListTablesRequest request = ListTablesRequest.newBuilder()
   *     .setParentWithInstanceName(parent)
   *     .build();
   *   while (true) {
   *     ListTablesResponse response = bigtableTableAdminClient.listTablesCallable().call(request);
   *     for (Table element : response.getTablesList()) {
   *       // doThingsWith(element);
   *     }
   *     String nextPageToken = response.getNextPageToken();
   *     if (!Strings.isNullOrEmpty(nextPageToken)) {
   *       request = request.toBuilder().setPageToken(nextPageToken).build();
   *     } else {
   *       break;
   *     }
   *   }
   * }
   * </code></pre>
   */
  public final UnaryCallable<ListTablesRequest, ListTablesResponse> listTablesCallable() {
    return stub.listTablesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets metadata information about the specified table.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BigtableTableAdminClient bigtableTableAdminClient = BigtableTableAdminClient.create()) {
   *   TableName name = TableName.of("[PROJECT]", "[INSTANCE]", "[TABLE]");
   *   Table response = bigtableTableAdminClient.getTable(name);
   * }
   * </code></pre>
   *
   * @param name The unique name of the requested table. Values are of the form
   *     `projects/&lt;project&gt;/instances/&lt;instance&gt;/tables/&lt;table&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Table getTable(TableName name) {

    GetTableRequest request = GetTableRequest.newBuilder().setNameWithTableName(name).build();
    return getTable(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets metadata information about the specified table.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BigtableTableAdminClient bigtableTableAdminClient = BigtableTableAdminClient.create()) {
   *   TableName name = TableName.of("[PROJECT]", "[INSTANCE]", "[TABLE]");
   *   GetTableRequest request = GetTableRequest.newBuilder()
   *     .setNameWithTableName(name)
   *     .build();
   *   Table response = bigtableTableAdminClient.getTable(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Table getTable(GetTableRequest request) {
    return getTableCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets metadata information about the specified table.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BigtableTableAdminClient bigtableTableAdminClient = BigtableTableAdminClient.create()) {
   *   TableName name = TableName.of("[PROJECT]", "[INSTANCE]", "[TABLE]");
   *   GetTableRequest request = GetTableRequest.newBuilder()
   *     .setNameWithTableName(name)
   *     .build();
   *   ApiFuture&lt;Table&gt; future = bigtableTableAdminClient.getTableCallable().futureCall(request);
   *   // Do something
   *   Table response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<GetTableRequest, Table> getTableCallable() {
    return stub.getTableCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Permanently deletes a specified table and all of its data.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BigtableTableAdminClient bigtableTableAdminClient = BigtableTableAdminClient.create()) {
   *   TableName name = TableName.of("[PROJECT]", "[INSTANCE]", "[TABLE]");
   *   bigtableTableAdminClient.deleteTable(name);
   * }
   * </code></pre>
   *
   * @param name The unique name of the table to be deleted. Values are of the form
   *     `projects/&lt;project&gt;/instances/&lt;instance&gt;/tables/&lt;table&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteTable(TableName name) {

    DeleteTableRequest request = DeleteTableRequest.newBuilder().setNameWithTableName(name).build();
    deleteTable(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Permanently deletes a specified table and all of its data.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BigtableTableAdminClient bigtableTableAdminClient = BigtableTableAdminClient.create()) {
   *   TableName name = TableName.of("[PROJECT]", "[INSTANCE]", "[TABLE]");
   *   DeleteTableRequest request = DeleteTableRequest.newBuilder()
   *     .setNameWithTableName(name)
   *     .build();
   *   bigtableTableAdminClient.deleteTable(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  private final void deleteTable(DeleteTableRequest request) {
    deleteTableCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Permanently deletes a specified table and all of its data.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BigtableTableAdminClient bigtableTableAdminClient = BigtableTableAdminClient.create()) {
   *   TableName name = TableName.of("[PROJECT]", "[INSTANCE]", "[TABLE]");
   *   DeleteTableRequest request = DeleteTableRequest.newBuilder()
   *     .setNameWithTableName(name)
   *     .build();
   *   ApiFuture&lt;Void&gt; future = bigtableTableAdminClient.deleteTableCallable().futureCall(request);
   *   // Do something
   *   future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<DeleteTableRequest, Empty> deleteTableCallable() {
    return stub.deleteTableCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Performs a series of column family modifications on the specified table. Either all or none of
   * the modifications will occur before this method returns, but data requests received prior to
   * that point may see a table where only some modifications have taken effect.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BigtableTableAdminClient bigtableTableAdminClient = BigtableTableAdminClient.create()) {
   *   TableName name = TableName.of("[PROJECT]", "[INSTANCE]", "[TABLE]");
   *   List&lt;ModifyColumnFamiliesRequest.Modification&gt; modifications = new ArrayList&lt;&gt;();
   *   Table response = bigtableTableAdminClient.modifyColumnFamilies(name, modifications);
   * }
   * </code></pre>
   *
   * @param name The unique name of the table whose families should be modified. Values are of the
   *     form `projects/&lt;project&gt;/instances/&lt;instance&gt;/tables/&lt;table&gt;`.
   * @param modifications Modifications to be atomically applied to the specified table's families.
   *     Entries are applied in order, meaning that earlier modifications can be masked by later
   *     ones (in the case of repeated updates to the same family, for example).
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Table modifyColumnFamilies(
      TableName name, List<ModifyColumnFamiliesRequest.Modification> modifications) {

    ModifyColumnFamiliesRequest request =
        ModifyColumnFamiliesRequest.newBuilder()
            .setNameWithTableName(name)
            .addAllModifications(modifications)
            .build();
    return modifyColumnFamilies(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Performs a series of column family modifications on the specified table. Either all or none of
   * the modifications will occur before this method returns, but data requests received prior to
   * that point may see a table where only some modifications have taken effect.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BigtableTableAdminClient bigtableTableAdminClient = BigtableTableAdminClient.create()) {
   *   TableName name = TableName.of("[PROJECT]", "[INSTANCE]", "[TABLE]");
   *   List&lt;ModifyColumnFamiliesRequest.Modification&gt; modifications = new ArrayList&lt;&gt;();
   *   ModifyColumnFamiliesRequest request = ModifyColumnFamiliesRequest.newBuilder()
   *     .setNameWithTableName(name)
   *     .addAllModifications(modifications)
   *     .build();
   *   Table response = bigtableTableAdminClient.modifyColumnFamilies(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Table modifyColumnFamilies(ModifyColumnFamiliesRequest request) {
    return modifyColumnFamiliesCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Performs a series of column family modifications on the specified table. Either all or none of
   * the modifications will occur before this method returns, but data requests received prior to
   * that point may see a table where only some modifications have taken effect.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BigtableTableAdminClient bigtableTableAdminClient = BigtableTableAdminClient.create()) {
   *   TableName name = TableName.of("[PROJECT]", "[INSTANCE]", "[TABLE]");
   *   List&lt;ModifyColumnFamiliesRequest.Modification&gt; modifications = new ArrayList&lt;&gt;();
   *   ModifyColumnFamiliesRequest request = ModifyColumnFamiliesRequest.newBuilder()
   *     .setNameWithTableName(name)
   *     .addAllModifications(modifications)
   *     .build();
   *   ApiFuture&lt;Table&gt; future = bigtableTableAdminClient.modifyColumnFamiliesCallable().futureCall(request);
   *   // Do something
   *   Table response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<ModifyColumnFamiliesRequest, Table> modifyColumnFamiliesCallable() {
    return stub.modifyColumnFamiliesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Permanently drop/delete a row range from a specified table. The request can specify whether to
   * delete all rows in a table, or only those that match a particular prefix.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BigtableTableAdminClient bigtableTableAdminClient = BigtableTableAdminClient.create()) {
   *   String formattedName = TableName.of("[PROJECT]", "[INSTANCE]", "[TABLE]").toString();
   *   ByteString rowKeyPrefix = ByteString.copyFromUtf8("");
   *   bigtableTableAdminClient.dropRowRange(formattedName, rowKeyPrefix);
   * }
   * </code></pre>
   *
   * @param name The unique name of the table on which to drop a range of rows. Values are of the
   *     form `projects/&lt;project&gt;/instances/&lt;instance&gt;/tables/&lt;table&gt;`.
   * @param rowKeyPrefix Delete all rows that start with this row key prefix. Prefix cannot be zero
   *     length.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void dropRowRange(String name, ByteString rowKeyPrefix) {

    DropRowRangeRequest request =
        DropRowRangeRequest.newBuilder().setName(name).setRowKeyPrefix(rowKeyPrefix).build();
    dropRowRange(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Permanently drop/delete a row range from a specified table. The request can specify whether to
   * delete all rows in a table, or only those that match a particular prefix.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BigtableTableAdminClient bigtableTableAdminClient = BigtableTableAdminClient.create()) {
   *   String formattedName = TableName.of("[PROJECT]", "[INSTANCE]", "[TABLE]").toString();
   *   DropRowRangeRequest request = DropRowRangeRequest.newBuilder()
   *     .setName(formattedName)
   *     .build();
   *   bigtableTableAdminClient.dropRowRange(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void dropRowRange(DropRowRangeRequest request) {
    dropRowRangeCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Permanently drop/delete a row range from a specified table. The request can specify whether to
   * delete all rows in a table, or only those that match a particular prefix.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BigtableTableAdminClient bigtableTableAdminClient = BigtableTableAdminClient.create()) {
   *   String formattedName = TableName.of("[PROJECT]", "[INSTANCE]", "[TABLE]").toString();
   *   DropRowRangeRequest request = DropRowRangeRequest.newBuilder()
   *     .setName(formattedName)
   *     .build();
   *   ApiFuture&lt;Void&gt; future = bigtableTableAdminClient.dropRowRangeCallable().futureCall(request);
   *   // Do something
   *   future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<DropRowRangeRequest, Empty> dropRowRangeCallable() {
    return stub.dropRowRangeCallable();
  }

  @Override
  public final void close() throws Exception {
    stub.close();
  }

  @Override
  public void shutdown() {
    stub.shutdown();
  }

  @Override
  public boolean isShutdown() {
    return stub.isShutdown();
  }

  @Override
  public boolean isTerminated() {
    return stub.isTerminated();
  }

  @Override
  public void shutdownNow() {
    stub.shutdownNow();
  }

  @Override
  public boolean awaitTermination(long duration, TimeUnit unit) throws InterruptedException {
    return stub.awaitTermination(duration, unit);
  }
}
