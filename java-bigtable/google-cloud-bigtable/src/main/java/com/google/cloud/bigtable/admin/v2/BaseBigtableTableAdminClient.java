/*
 * Copyright 2020 Google LLC
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
import com.google.api.core.BetaApi;
import com.google.api.core.InternalApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.longrunning.OperationFuture;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.bigtable.admin.v2.CheckConsistencyRequest;
import com.google.bigtable.admin.v2.CheckConsistencyResponse;
import com.google.bigtable.admin.v2.ClusterName;
import com.google.bigtable.admin.v2.CreateTableFromSnapshotMetadata;
import com.google.bigtable.admin.v2.CreateTableFromSnapshotRequest;
import com.google.bigtable.admin.v2.CreateTableRequest;
import com.google.bigtable.admin.v2.DeleteSnapshotRequest;
import com.google.bigtable.admin.v2.DeleteTableRequest;
import com.google.bigtable.admin.v2.DropRowRangeRequest;
import com.google.bigtable.admin.v2.GenerateConsistencyTokenRequest;
import com.google.bigtable.admin.v2.GenerateConsistencyTokenResponse;
import com.google.bigtable.admin.v2.GetSnapshotRequest;
import com.google.bigtable.admin.v2.GetTableRequest;
import com.google.bigtable.admin.v2.InstanceName;
import com.google.bigtable.admin.v2.ListSnapshotsRequest;
import com.google.bigtable.admin.v2.ListSnapshotsResponse;
import com.google.bigtable.admin.v2.ListTablesRequest;
import com.google.bigtable.admin.v2.ListTablesResponse;
import com.google.bigtable.admin.v2.ModifyColumnFamiliesRequest;
import com.google.bigtable.admin.v2.Snapshot;
import com.google.bigtable.admin.v2.SnapshotName;
import com.google.bigtable.admin.v2.SnapshotTableMetadata;
import com.google.bigtable.admin.v2.SnapshotTableRequest;
import com.google.bigtable.admin.v2.Table;
import com.google.bigtable.admin.v2.TableName;
import com.google.cloud.bigtable.admin.v2.stub.BigtableTableAdminStub;
import com.google.cloud.bigtable.admin.v2.stub.BigtableTableAdminStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.longrunning.Operation;
import com.google.longrunning.OperationsClient;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND SERVICE
/** For internal use only. */
@Generated("by gapic-generator")
@InternalApi
public class BaseBigtableTableAdminClient implements BackgroundResource {
  private final BaseBigtableTableAdminSettings settings;
  private final BigtableTableAdminStub stub;
  private final OperationsClient operationsClient;

  /** Constructs an instance of BaseBigtableTableAdminClient with default settings. */
  public static final BaseBigtableTableAdminClient create() throws IOException {
    return create(BaseBigtableTableAdminSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of BaseBigtableTableAdminClient, using the given settings. The channels
   * are created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final BaseBigtableTableAdminClient create(BaseBigtableTableAdminSettings settings)
      throws IOException {
    return new BaseBigtableTableAdminClient(settings);
  }

  /**
   * Constructs an instance of BaseBigtableTableAdminClient, using the given stub for making calls.
   * This is for advanced usage - prefer to use BaseBigtableTableAdminSettings}.
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final BaseBigtableTableAdminClient create(BigtableTableAdminStub stub) {
    return new BaseBigtableTableAdminClient(stub);
  }

  /**
   * Constructs an instance of BaseBigtableTableAdminClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected BaseBigtableTableAdminClient(BaseBigtableTableAdminSettings settings)
      throws IOException {
    this.settings = settings;
    this.stub = ((BigtableTableAdminStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected BaseBigtableTableAdminClient(BigtableTableAdminStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  public final BaseBigtableTableAdminSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public BigtableTableAdminStub getStub() {
    return stub;
  }

  /**
   * Returns the OperationsClient that can be used to query the status of a long-running operation
   * returned by another API method call.
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationsClient getOperationsClient() {
    return operationsClient;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a new table in the specified instance. The table can be created with a full set of
   * initial column families, specified in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BaseBigtableTableAdminClient baseBigtableTableAdminClient = BaseBigtableTableAdminClient.create()) {
   *   InstanceName parent = InstanceName.of("[PROJECT]", "[INSTANCE]");
   *   String tableId = "";
   *   Table table = Table.newBuilder().build();
   *   Table response = baseBigtableTableAdminClient.createTable(parent, tableId, table);
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
            .setParent(parent == null ? null : parent.toString())
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
   * try (BaseBigtableTableAdminClient baseBigtableTableAdminClient = BaseBigtableTableAdminClient.create()) {
   *   InstanceName parent = InstanceName.of("[PROJECT]", "[INSTANCE]");
   *   String tableId = "";
   *   Table table = Table.newBuilder().build();
   *   Table response = baseBigtableTableAdminClient.createTable(parent.toString(), tableId, table);
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
  public final Table createTable(String parent, String tableId, Table table) {
    CreateTableRequest request =
        CreateTableRequest.newBuilder()
            .setParent(parent)
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
   * try (BaseBigtableTableAdminClient baseBigtableTableAdminClient = BaseBigtableTableAdminClient.create()) {
   *   InstanceName parent = InstanceName.of("[PROJECT]", "[INSTANCE]");
   *   String tableId = "";
   *   Table table = Table.newBuilder().build();
   *   CreateTableRequest request = CreateTableRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .setTableId(tableId)
   *     .setTable(table)
   *     .build();
   *   Table response = baseBigtableTableAdminClient.createTable(request);
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
   * try (BaseBigtableTableAdminClient baseBigtableTableAdminClient = BaseBigtableTableAdminClient.create()) {
   *   InstanceName parent = InstanceName.of("[PROJECT]", "[INSTANCE]");
   *   String tableId = "";
   *   Table table = Table.newBuilder().build();
   *   CreateTableRequest request = CreateTableRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .setTableId(tableId)
   *     .setTable(table)
   *     .build();
   *   ApiFuture&lt;Table&gt; future = baseBigtableTableAdminClient.createTableCallable().futureCall(request);
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
   * Creates a new table from the specified snapshot. The target table must not exist. The snapshot
   * and the table must be in the same instance.
   *
   * <p>Note: This is a private alpha release of Cloud Bigtable snapshots. This feature is not
   * currently available to most Cloud Bigtable customers. This feature might be changed in
   * backward-incompatible ways and is not recommended for production use. It is not subject to any
   * SLA or deprecation policy.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BaseBigtableTableAdminClient baseBigtableTableAdminClient = BaseBigtableTableAdminClient.create()) {
   *   InstanceName parent = InstanceName.of("[PROJECT]", "[INSTANCE]");
   *   String tableId = "";
   *   SnapshotName sourceSnapshot = SnapshotName.of("[PROJECT]", "[INSTANCE]", "[CLUSTER]", "[SNAPSHOT]");
   *   Table response = baseBigtableTableAdminClient.createTableFromSnapshotAsync(parent, tableId, sourceSnapshot).get();
   * }
   * </code></pre>
   *
   * @param parent The unique name of the instance in which to create the table. Values are of the
   *     form `projects/&lt;project&gt;/instances/&lt;instance&gt;`.
   * @param tableId The name by which the new table should be referred to within the parent
   *     instance, e.g., `foobar` rather than `&lt;parent&gt;/tables/foobar`.
   * @param sourceSnapshot The unique name of the snapshot from which to restore the table. The
   *     snapshot and the table must be in the same instance. Values are of the form
   *     `projects/&lt;project&gt;/instances/&lt;instance&gt;/clusters/&lt;cluster&gt;/snapshots/&lt;snapshot&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Table, CreateTableFromSnapshotMetadata> createTableFromSnapshotAsync(
      InstanceName parent, String tableId, SnapshotName sourceSnapshot) {
    CreateTableFromSnapshotRequest request =
        CreateTableFromSnapshotRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setTableId(tableId)
            .setSourceSnapshot(sourceSnapshot == null ? null : sourceSnapshot.toString())
            .build();
    return createTableFromSnapshotAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a new table from the specified snapshot. The target table must not exist. The snapshot
   * and the table must be in the same instance.
   *
   * <p>Note: This is a private alpha release of Cloud Bigtable snapshots. This feature is not
   * currently available to most Cloud Bigtable customers. This feature might be changed in
   * backward-incompatible ways and is not recommended for production use. It is not subject to any
   * SLA or deprecation policy.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BaseBigtableTableAdminClient baseBigtableTableAdminClient = BaseBigtableTableAdminClient.create()) {
   *   InstanceName parent = InstanceName.of("[PROJECT]", "[INSTANCE]");
   *   String tableId = "";
   *   SnapshotName sourceSnapshot = SnapshotName.of("[PROJECT]", "[INSTANCE]", "[CLUSTER]", "[SNAPSHOT]");
   *   Table response = baseBigtableTableAdminClient.createTableFromSnapshotAsync(parent.toString(), tableId, sourceSnapshot.toString()).get();
   * }
   * </code></pre>
   *
   * @param parent The unique name of the instance in which to create the table. Values are of the
   *     form `projects/&lt;project&gt;/instances/&lt;instance&gt;`.
   * @param tableId The name by which the new table should be referred to within the parent
   *     instance, e.g., `foobar` rather than `&lt;parent&gt;/tables/foobar`.
   * @param sourceSnapshot The unique name of the snapshot from which to restore the table. The
   *     snapshot and the table must be in the same instance. Values are of the form
   *     `projects/&lt;project&gt;/instances/&lt;instance&gt;/clusters/&lt;cluster&gt;/snapshots/&lt;snapshot&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Table, CreateTableFromSnapshotMetadata> createTableFromSnapshotAsync(
      String parent, String tableId, String sourceSnapshot) {
    CreateTableFromSnapshotRequest request =
        CreateTableFromSnapshotRequest.newBuilder()
            .setParent(parent)
            .setTableId(tableId)
            .setSourceSnapshot(sourceSnapshot)
            .build();
    return createTableFromSnapshotAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a new table from the specified snapshot. The target table must not exist. The snapshot
   * and the table must be in the same instance.
   *
   * <p>Note: This is a private alpha release of Cloud Bigtable snapshots. This feature is not
   * currently available to most Cloud Bigtable customers. This feature might be changed in
   * backward-incompatible ways and is not recommended for production use. It is not subject to any
   * SLA or deprecation policy.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BaseBigtableTableAdminClient baseBigtableTableAdminClient = BaseBigtableTableAdminClient.create()) {
   *   InstanceName parent = InstanceName.of("[PROJECT]", "[INSTANCE]");
   *   String tableId = "";
   *   SnapshotName sourceSnapshot = SnapshotName.of("[PROJECT]", "[INSTANCE]", "[CLUSTER]", "[SNAPSHOT]");
   *   CreateTableFromSnapshotRequest request = CreateTableFromSnapshotRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .setTableId(tableId)
   *     .setSourceSnapshot(sourceSnapshot.toString())
   *     .build();
   *   Table response = baseBigtableTableAdminClient.createTableFromSnapshotAsync(request).get();
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Table, CreateTableFromSnapshotMetadata> createTableFromSnapshotAsync(
      CreateTableFromSnapshotRequest request) {
    return createTableFromSnapshotOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a new table from the specified snapshot. The target table must not exist. The snapshot
   * and the table must be in the same instance.
   *
   * <p>Note: This is a private alpha release of Cloud Bigtable snapshots. This feature is not
   * currently available to most Cloud Bigtable customers. This feature might be changed in
   * backward-incompatible ways and is not recommended for production use. It is not subject to any
   * SLA or deprecation policy.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BaseBigtableTableAdminClient baseBigtableTableAdminClient = BaseBigtableTableAdminClient.create()) {
   *   InstanceName parent = InstanceName.of("[PROJECT]", "[INSTANCE]");
   *   String tableId = "";
   *   SnapshotName sourceSnapshot = SnapshotName.of("[PROJECT]", "[INSTANCE]", "[CLUSTER]", "[SNAPSHOT]");
   *   CreateTableFromSnapshotRequest request = CreateTableFromSnapshotRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .setTableId(tableId)
   *     .setSourceSnapshot(sourceSnapshot.toString())
   *     .build();
   *   OperationFuture&lt;Table, CreateTableFromSnapshotMetadata&gt; future = baseBigtableTableAdminClient.createTableFromSnapshotOperationCallable().futureCall(request);
   *   // Do something
   *   Table response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi("The surface for use by generated code is not stable yet and may change in the future.")
  public final OperationCallable<
          CreateTableFromSnapshotRequest, Table, CreateTableFromSnapshotMetadata>
      createTableFromSnapshotOperationCallable() {
    return stub.createTableFromSnapshotOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a new table from the specified snapshot. The target table must not exist. The snapshot
   * and the table must be in the same instance.
   *
   * <p>Note: This is a private alpha release of Cloud Bigtable snapshots. This feature is not
   * currently available to most Cloud Bigtable customers. This feature might be changed in
   * backward-incompatible ways and is not recommended for production use. It is not subject to any
   * SLA or deprecation policy.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BaseBigtableTableAdminClient baseBigtableTableAdminClient = BaseBigtableTableAdminClient.create()) {
   *   InstanceName parent = InstanceName.of("[PROJECT]", "[INSTANCE]");
   *   String tableId = "";
   *   SnapshotName sourceSnapshot = SnapshotName.of("[PROJECT]", "[INSTANCE]", "[CLUSTER]", "[SNAPSHOT]");
   *   CreateTableFromSnapshotRequest request = CreateTableFromSnapshotRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .setTableId(tableId)
   *     .setSourceSnapshot(sourceSnapshot.toString())
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = baseBigtableTableAdminClient.createTableFromSnapshotCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<CreateTableFromSnapshotRequest, Operation>
      createTableFromSnapshotCallable() {
    return stub.createTableFromSnapshotCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists all tables served from a specified instance.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BaseBigtableTableAdminClient baseBigtableTableAdminClient = BaseBigtableTableAdminClient.create()) {
   *   InstanceName parent = InstanceName.of("[PROJECT]", "[INSTANCE]");
   *   for (Table element : baseBigtableTableAdminClient.listTables(parent).iterateAll()) {
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
        ListTablesRequest.newBuilder().setParent(parent == null ? null : parent.toString()).build();
    return listTables(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists all tables served from a specified instance.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BaseBigtableTableAdminClient baseBigtableTableAdminClient = BaseBigtableTableAdminClient.create()) {
   *   InstanceName parent = InstanceName.of("[PROJECT]", "[INSTANCE]");
   *   for (Table element : baseBigtableTableAdminClient.listTables(parent.toString()).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param parent The unique name of the instance for which tables should be listed. Values are of
   *     the form `projects/&lt;project&gt;/instances/&lt;instance&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListTablesPagedResponse listTables(String parent) {
    ListTablesRequest request = ListTablesRequest.newBuilder().setParent(parent).build();
    return listTables(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists all tables served from a specified instance.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BaseBigtableTableAdminClient baseBigtableTableAdminClient = BaseBigtableTableAdminClient.create()) {
   *   InstanceName parent = InstanceName.of("[PROJECT]", "[INSTANCE]");
   *   ListTablesRequest request = ListTablesRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .build();
   *   for (Table element : baseBigtableTableAdminClient.listTables(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListTablesPagedResponse listTables(ListTablesRequest request) {
    return listTablesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists all tables served from a specified instance.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BaseBigtableTableAdminClient baseBigtableTableAdminClient = BaseBigtableTableAdminClient.create()) {
   *   InstanceName parent = InstanceName.of("[PROJECT]", "[INSTANCE]");
   *   ListTablesRequest request = ListTablesRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .build();
   *   ApiFuture&lt;ListTablesPagedResponse&gt; future = baseBigtableTableAdminClient.listTablesPagedCallable().futureCall(request);
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
   * try (BaseBigtableTableAdminClient baseBigtableTableAdminClient = BaseBigtableTableAdminClient.create()) {
   *   InstanceName parent = InstanceName.of("[PROJECT]", "[INSTANCE]");
   *   ListTablesRequest request = ListTablesRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .build();
   *   while (true) {
   *     ListTablesResponse response = baseBigtableTableAdminClient.listTablesCallable().call(request);
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
   * try (BaseBigtableTableAdminClient baseBigtableTableAdminClient = BaseBigtableTableAdminClient.create()) {
   *   TableName name = TableName.of("[PROJECT]", "[INSTANCE]", "[TABLE]");
   *   Table response = baseBigtableTableAdminClient.getTable(name);
   * }
   * </code></pre>
   *
   * @param name The unique name of the requested table. Values are of the form
   *     `projects/&lt;project&gt;/instances/&lt;instance&gt;/tables/&lt;table&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Table getTable(TableName name) {
    GetTableRequest request =
        GetTableRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getTable(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets metadata information about the specified table.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BaseBigtableTableAdminClient baseBigtableTableAdminClient = BaseBigtableTableAdminClient.create()) {
   *   TableName name = TableName.of("[PROJECT]", "[INSTANCE]", "[TABLE]");
   *   Table response = baseBigtableTableAdminClient.getTable(name.toString());
   * }
   * </code></pre>
   *
   * @param name The unique name of the requested table. Values are of the form
   *     `projects/&lt;project&gt;/instances/&lt;instance&gt;/tables/&lt;table&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Table getTable(String name) {
    GetTableRequest request = GetTableRequest.newBuilder().setName(name).build();
    return getTable(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets metadata information about the specified table.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BaseBigtableTableAdminClient baseBigtableTableAdminClient = BaseBigtableTableAdminClient.create()) {
   *   TableName name = TableName.of("[PROJECT]", "[INSTANCE]", "[TABLE]");
   *   GetTableRequest request = GetTableRequest.newBuilder()
   *     .setName(name.toString())
   *     .build();
   *   Table response = baseBigtableTableAdminClient.getTable(request);
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
   * try (BaseBigtableTableAdminClient baseBigtableTableAdminClient = BaseBigtableTableAdminClient.create()) {
   *   TableName name = TableName.of("[PROJECT]", "[INSTANCE]", "[TABLE]");
   *   GetTableRequest request = GetTableRequest.newBuilder()
   *     .setName(name.toString())
   *     .build();
   *   ApiFuture&lt;Table&gt; future = baseBigtableTableAdminClient.getTableCallable().futureCall(request);
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
   * try (BaseBigtableTableAdminClient baseBigtableTableAdminClient = BaseBigtableTableAdminClient.create()) {
   *   TableName name = TableName.of("[PROJECT]", "[INSTANCE]", "[TABLE]");
   *   baseBigtableTableAdminClient.deleteTable(name);
   * }
   * </code></pre>
   *
   * @param name The unique name of the table to be deleted. Values are of the form
   *     `projects/&lt;project&gt;/instances/&lt;instance&gt;/tables/&lt;table&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteTable(TableName name) {
    DeleteTableRequest request =
        DeleteTableRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    deleteTable(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Permanently deletes a specified table and all of its data.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BaseBigtableTableAdminClient baseBigtableTableAdminClient = BaseBigtableTableAdminClient.create()) {
   *   TableName name = TableName.of("[PROJECT]", "[INSTANCE]", "[TABLE]");
   *   baseBigtableTableAdminClient.deleteTable(name.toString());
   * }
   * </code></pre>
   *
   * @param name The unique name of the table to be deleted. Values are of the form
   *     `projects/&lt;project&gt;/instances/&lt;instance&gt;/tables/&lt;table&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteTable(String name) {
    DeleteTableRequest request = DeleteTableRequest.newBuilder().setName(name).build();
    deleteTable(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Permanently deletes a specified table and all of its data.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BaseBigtableTableAdminClient baseBigtableTableAdminClient = BaseBigtableTableAdminClient.create()) {
   *   TableName name = TableName.of("[PROJECT]", "[INSTANCE]", "[TABLE]");
   *   DeleteTableRequest request = DeleteTableRequest.newBuilder()
   *     .setName(name.toString())
   *     .build();
   *   baseBigtableTableAdminClient.deleteTable(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteTable(DeleteTableRequest request) {
    deleteTableCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Permanently deletes a specified table and all of its data.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BaseBigtableTableAdminClient baseBigtableTableAdminClient = BaseBigtableTableAdminClient.create()) {
   *   TableName name = TableName.of("[PROJECT]", "[INSTANCE]", "[TABLE]");
   *   DeleteTableRequest request = DeleteTableRequest.newBuilder()
   *     .setName(name.toString())
   *     .build();
   *   ApiFuture&lt;Void&gt; future = baseBigtableTableAdminClient.deleteTableCallable().futureCall(request);
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
   * try (BaseBigtableTableAdminClient baseBigtableTableAdminClient = BaseBigtableTableAdminClient.create()) {
   *   TableName name = TableName.of("[PROJECT]", "[INSTANCE]", "[TABLE]");
   *   List&lt;ModifyColumnFamiliesRequest.Modification&gt; modifications = new ArrayList&lt;&gt;();
   *   Table response = baseBigtableTableAdminClient.modifyColumnFamilies(name, modifications);
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
            .setName(name == null ? null : name.toString())
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
   * try (BaseBigtableTableAdminClient baseBigtableTableAdminClient = BaseBigtableTableAdminClient.create()) {
   *   TableName name = TableName.of("[PROJECT]", "[INSTANCE]", "[TABLE]");
   *   List&lt;ModifyColumnFamiliesRequest.Modification&gt; modifications = new ArrayList&lt;&gt;();
   *   Table response = baseBigtableTableAdminClient.modifyColumnFamilies(name.toString(), modifications);
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
      String name, List<ModifyColumnFamiliesRequest.Modification> modifications) {
    ModifyColumnFamiliesRequest request =
        ModifyColumnFamiliesRequest.newBuilder()
            .setName(name)
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
   * try (BaseBigtableTableAdminClient baseBigtableTableAdminClient = BaseBigtableTableAdminClient.create()) {
   *   TableName name = TableName.of("[PROJECT]", "[INSTANCE]", "[TABLE]");
   *   List&lt;ModifyColumnFamiliesRequest.Modification&gt; modifications = new ArrayList&lt;&gt;();
   *   ModifyColumnFamiliesRequest request = ModifyColumnFamiliesRequest.newBuilder()
   *     .setName(name.toString())
   *     .addAllModifications(modifications)
   *     .build();
   *   Table response = baseBigtableTableAdminClient.modifyColumnFamilies(request);
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
   * try (BaseBigtableTableAdminClient baseBigtableTableAdminClient = BaseBigtableTableAdminClient.create()) {
   *   TableName name = TableName.of("[PROJECT]", "[INSTANCE]", "[TABLE]");
   *   List&lt;ModifyColumnFamiliesRequest.Modification&gt; modifications = new ArrayList&lt;&gt;();
   *   ModifyColumnFamiliesRequest request = ModifyColumnFamiliesRequest.newBuilder()
   *     .setName(name.toString())
   *     .addAllModifications(modifications)
   *     .build();
   *   ApiFuture&lt;Table&gt; future = baseBigtableTableAdminClient.modifyColumnFamiliesCallable().futureCall(request);
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
   * try (BaseBigtableTableAdminClient baseBigtableTableAdminClient = BaseBigtableTableAdminClient.create()) {
   *   TableName name = TableName.of("[PROJECT]", "[INSTANCE]", "[TABLE]");
   *   DropRowRangeRequest request = DropRowRangeRequest.newBuilder()
   *     .setName(name.toString())
   *     .build();
   *   baseBigtableTableAdminClient.dropRowRange(request);
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
   * try (BaseBigtableTableAdminClient baseBigtableTableAdminClient = BaseBigtableTableAdminClient.create()) {
   *   TableName name = TableName.of("[PROJECT]", "[INSTANCE]", "[TABLE]");
   *   DropRowRangeRequest request = DropRowRangeRequest.newBuilder()
   *     .setName(name.toString())
   *     .build();
   *   ApiFuture&lt;Void&gt; future = baseBigtableTableAdminClient.dropRowRangeCallable().futureCall(request);
   *   // Do something
   *   future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<DropRowRangeRequest, Empty> dropRowRangeCallable() {
    return stub.dropRowRangeCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Generates a consistency token for a Table, which can be used in CheckConsistency to check
   * whether mutations to the table that finished before this call started have been replicated. The
   * tokens will be available for 90 days.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BaseBigtableTableAdminClient baseBigtableTableAdminClient = BaseBigtableTableAdminClient.create()) {
   *   TableName name = TableName.of("[PROJECT]", "[INSTANCE]", "[TABLE]");
   *   GenerateConsistencyTokenResponse response = baseBigtableTableAdminClient.generateConsistencyToken(name);
   * }
   * </code></pre>
   *
   * @param name The unique name of the Table for which to create a consistency token. Values are of
   *     the form `projects/&lt;project&gt;/instances/&lt;instance&gt;/tables/&lt;table&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GenerateConsistencyTokenResponse generateConsistencyToken(TableName name) {
    GenerateConsistencyTokenRequest request =
        GenerateConsistencyTokenRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return generateConsistencyToken(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Generates a consistency token for a Table, which can be used in CheckConsistency to check
   * whether mutations to the table that finished before this call started have been replicated. The
   * tokens will be available for 90 days.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BaseBigtableTableAdminClient baseBigtableTableAdminClient = BaseBigtableTableAdminClient.create()) {
   *   TableName name = TableName.of("[PROJECT]", "[INSTANCE]", "[TABLE]");
   *   GenerateConsistencyTokenResponse response = baseBigtableTableAdminClient.generateConsistencyToken(name.toString());
   * }
   * </code></pre>
   *
   * @param name The unique name of the Table for which to create a consistency token. Values are of
   *     the form `projects/&lt;project&gt;/instances/&lt;instance&gt;/tables/&lt;table&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GenerateConsistencyTokenResponse generateConsistencyToken(String name) {
    GenerateConsistencyTokenRequest request =
        GenerateConsistencyTokenRequest.newBuilder().setName(name).build();
    return generateConsistencyToken(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Generates a consistency token for a Table, which can be used in CheckConsistency to check
   * whether mutations to the table that finished before this call started have been replicated. The
   * tokens will be available for 90 days.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BaseBigtableTableAdminClient baseBigtableTableAdminClient = BaseBigtableTableAdminClient.create()) {
   *   TableName name = TableName.of("[PROJECT]", "[INSTANCE]", "[TABLE]");
   *   GenerateConsistencyTokenRequest request = GenerateConsistencyTokenRequest.newBuilder()
   *     .setName(name.toString())
   *     .build();
   *   GenerateConsistencyTokenResponse response = baseBigtableTableAdminClient.generateConsistencyToken(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GenerateConsistencyTokenResponse generateConsistencyToken(
      GenerateConsistencyTokenRequest request) {
    return generateConsistencyTokenCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Generates a consistency token for a Table, which can be used in CheckConsistency to check
   * whether mutations to the table that finished before this call started have been replicated. The
   * tokens will be available for 90 days.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BaseBigtableTableAdminClient baseBigtableTableAdminClient = BaseBigtableTableAdminClient.create()) {
   *   TableName name = TableName.of("[PROJECT]", "[INSTANCE]", "[TABLE]");
   *   GenerateConsistencyTokenRequest request = GenerateConsistencyTokenRequest.newBuilder()
   *     .setName(name.toString())
   *     .build();
   *   ApiFuture&lt;GenerateConsistencyTokenResponse&gt; future = baseBigtableTableAdminClient.generateConsistencyTokenCallable().futureCall(request);
   *   // Do something
   *   GenerateConsistencyTokenResponse response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<GenerateConsistencyTokenRequest, GenerateConsistencyTokenResponse>
      generateConsistencyTokenCallable() {
    return stub.generateConsistencyTokenCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Checks replication consistency based on a consistency token, that is, if replication has caught
   * up based on the conditions specified in the token and the check request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BaseBigtableTableAdminClient baseBigtableTableAdminClient = BaseBigtableTableAdminClient.create()) {
   *   TableName name = TableName.of("[PROJECT]", "[INSTANCE]", "[TABLE]");
   *   String consistencyToken = "";
   *   CheckConsistencyResponse response = baseBigtableTableAdminClient.checkConsistency(name, consistencyToken);
   * }
   * </code></pre>
   *
   * @param name The unique name of the Table for which to check replication consistency. Values are
   *     of the form `projects/&lt;project&gt;/instances/&lt;instance&gt;/tables/&lt;table&gt;`.
   * @param consistencyToken The token created using GenerateConsistencyToken for the Table.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CheckConsistencyResponse checkConsistency(TableName name, String consistencyToken) {
    CheckConsistencyRequest request =
        CheckConsistencyRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .setConsistencyToken(consistencyToken)
            .build();
    return checkConsistency(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Checks replication consistency based on a consistency token, that is, if replication has caught
   * up based on the conditions specified in the token and the check request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BaseBigtableTableAdminClient baseBigtableTableAdminClient = BaseBigtableTableAdminClient.create()) {
   *   TableName name = TableName.of("[PROJECT]", "[INSTANCE]", "[TABLE]");
   *   String consistencyToken = "";
   *   CheckConsistencyResponse response = baseBigtableTableAdminClient.checkConsistency(name.toString(), consistencyToken);
   * }
   * </code></pre>
   *
   * @param name The unique name of the Table for which to check replication consistency. Values are
   *     of the form `projects/&lt;project&gt;/instances/&lt;instance&gt;/tables/&lt;table&gt;`.
   * @param consistencyToken The token created using GenerateConsistencyToken for the Table.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CheckConsistencyResponse checkConsistency(String name, String consistencyToken) {
    CheckConsistencyRequest request =
        CheckConsistencyRequest.newBuilder()
            .setName(name)
            .setConsistencyToken(consistencyToken)
            .build();
    return checkConsistency(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Checks replication consistency based on a consistency token, that is, if replication has caught
   * up based on the conditions specified in the token and the check request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BaseBigtableTableAdminClient baseBigtableTableAdminClient = BaseBigtableTableAdminClient.create()) {
   *   TableName name = TableName.of("[PROJECT]", "[INSTANCE]", "[TABLE]");
   *   String consistencyToken = "";
   *   CheckConsistencyRequest request = CheckConsistencyRequest.newBuilder()
   *     .setName(name.toString())
   *     .setConsistencyToken(consistencyToken)
   *     .build();
   *   CheckConsistencyResponse response = baseBigtableTableAdminClient.checkConsistency(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CheckConsistencyResponse checkConsistency(CheckConsistencyRequest request) {
    return checkConsistencyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Checks replication consistency based on a consistency token, that is, if replication has caught
   * up based on the conditions specified in the token and the check request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BaseBigtableTableAdminClient baseBigtableTableAdminClient = BaseBigtableTableAdminClient.create()) {
   *   TableName name = TableName.of("[PROJECT]", "[INSTANCE]", "[TABLE]");
   *   String consistencyToken = "";
   *   CheckConsistencyRequest request = CheckConsistencyRequest.newBuilder()
   *     .setName(name.toString())
   *     .setConsistencyToken(consistencyToken)
   *     .build();
   *   ApiFuture&lt;CheckConsistencyResponse&gt; future = baseBigtableTableAdminClient.checkConsistencyCallable().futureCall(request);
   *   // Do something
   *   CheckConsistencyResponse response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<CheckConsistencyRequest, CheckConsistencyResponse>
      checkConsistencyCallable() {
    return stub.checkConsistencyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets the access control policy for a table resource. Returns an empty policy if an table exists
   * but does not have a policy set.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BaseBigtableTableAdminClient baseBigtableTableAdminClient = BaseBigtableTableAdminClient.create()) {
   *   String formattedResource = TableName.format("[PROJECT]", "[INSTANCE]", "[TABLE]");
   *   Policy response = baseBigtableTableAdminClient.getIamPolicy(formattedResource);
   * }
   * </code></pre>
   *
   * @param resource REQUIRED: The resource for which the policy is being requested. See the
   *     operation documentation for the appropriate value for this field.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy getIamPolicy(String resource) {
    GetIamPolicyRequest request = GetIamPolicyRequest.newBuilder().setResource(resource).build();
    return getIamPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets the access control policy for a table resource. Returns an empty policy if an table exists
   * but does not have a policy set.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BaseBigtableTableAdminClient baseBigtableTableAdminClient = BaseBigtableTableAdminClient.create()) {
   *   String formattedResource = TableName.format("[PROJECT]", "[INSTANCE]", "[TABLE]");
   *   GetIamPolicyRequest request = GetIamPolicyRequest.newBuilder()
   *     .setResource(formattedResource)
   *     .build();
   *   Policy response = baseBigtableTableAdminClient.getIamPolicy(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy getIamPolicy(GetIamPolicyRequest request) {
    return getIamPolicyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets the access control policy for a table resource. Returns an empty policy if an table exists
   * but does not have a policy set.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BaseBigtableTableAdminClient baseBigtableTableAdminClient = BaseBigtableTableAdminClient.create()) {
   *   String formattedResource = TableName.format("[PROJECT]", "[INSTANCE]", "[TABLE]");
   *   GetIamPolicyRequest request = GetIamPolicyRequest.newBuilder()
   *     .setResource(formattedResource)
   *     .build();
   *   ApiFuture&lt;Policy&gt; future = baseBigtableTableAdminClient.getIamPolicyCallable().futureCall(request);
   *   // Do something
   *   Policy response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable() {
    return stub.getIamPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets the access control policy on a table resource. Replaces any existing policy.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BaseBigtableTableAdminClient baseBigtableTableAdminClient = BaseBigtableTableAdminClient.create()) {
   *   String formattedResource = TableName.format("[PROJECT]", "[INSTANCE]", "[TABLE]");
   *   Policy policy = Policy.newBuilder().build();
   *   Policy response = baseBigtableTableAdminClient.setIamPolicy(formattedResource, policy);
   * }
   * </code></pre>
   *
   * @param resource REQUIRED: The resource for which the policy is being specified. See the
   *     operation documentation for the appropriate value for this field.
   * @param policy REQUIRED: The complete policy to be applied to the `resource`. The size of the
   *     policy is limited to a few 10s of KB. An empty policy is a valid policy but certain Cloud
   *     Platform services (such as Projects) might reject them.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy setIamPolicy(String resource, Policy policy) {
    SetIamPolicyRequest request =
        SetIamPolicyRequest.newBuilder().setResource(resource).setPolicy(policy).build();
    return setIamPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets the access control policy on a table resource. Replaces any existing policy.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BaseBigtableTableAdminClient baseBigtableTableAdminClient = BaseBigtableTableAdminClient.create()) {
   *   String formattedResource = TableName.format("[PROJECT]", "[INSTANCE]", "[TABLE]");
   *   Policy policy = Policy.newBuilder().build();
   *   SetIamPolicyRequest request = SetIamPolicyRequest.newBuilder()
   *     .setResource(formattedResource)
   *     .setPolicy(policy)
   *     .build();
   *   Policy response = baseBigtableTableAdminClient.setIamPolicy(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy setIamPolicy(SetIamPolicyRequest request) {
    return setIamPolicyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets the access control policy on a table resource. Replaces any existing policy.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BaseBigtableTableAdminClient baseBigtableTableAdminClient = BaseBigtableTableAdminClient.create()) {
   *   String formattedResource = TableName.format("[PROJECT]", "[INSTANCE]", "[TABLE]");
   *   Policy policy = Policy.newBuilder().build();
   *   SetIamPolicyRequest request = SetIamPolicyRequest.newBuilder()
   *     .setResource(formattedResource)
   *     .setPolicy(policy)
   *     .build();
   *   ApiFuture&lt;Policy&gt; future = baseBigtableTableAdminClient.setIamPolicyCallable().futureCall(request);
   *   // Do something
   *   Policy response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable() {
    return stub.setIamPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns permissions that the caller has on the specified table resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BaseBigtableTableAdminClient baseBigtableTableAdminClient = BaseBigtableTableAdminClient.create()) {
   *   String formattedResource = TableName.format("[PROJECT]", "[INSTANCE]", "[TABLE]");
   *   List&lt;String&gt; permissions = new ArrayList&lt;&gt;();
   *   TestIamPermissionsResponse response = baseBigtableTableAdminClient.testIamPermissions(formattedResource, permissions);
   * }
   * </code></pre>
   *
   * @param resource REQUIRED: The resource for which the policy detail is being requested. See the
   *     operation documentation for the appropriate value for this field.
   * @param permissions The set of permissions to check for the `resource`. Permissions with
   *     wildcards (such as '&#42;' or 'storage.&#42;') are not allowed. For more information see
   *     [IAM Overview](https://cloud.google.com/iam/docs/overview#permissions).
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TestIamPermissionsResponse testIamPermissions(
      String resource, List<String> permissions) {
    TestIamPermissionsRequest request =
        TestIamPermissionsRequest.newBuilder()
            .setResource(resource)
            .addAllPermissions(permissions)
            .build();
    return testIamPermissions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns permissions that the caller has on the specified table resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BaseBigtableTableAdminClient baseBigtableTableAdminClient = BaseBigtableTableAdminClient.create()) {
   *   String formattedResource = TableName.format("[PROJECT]", "[INSTANCE]", "[TABLE]");
   *   List&lt;String&gt; permissions = new ArrayList&lt;&gt;();
   *   TestIamPermissionsRequest request = TestIamPermissionsRequest.newBuilder()
   *     .setResource(formattedResource)
   *     .addAllPermissions(permissions)
   *     .build();
   *   TestIamPermissionsResponse response = baseBigtableTableAdminClient.testIamPermissions(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TestIamPermissionsResponse testIamPermissions(TestIamPermissionsRequest request) {
    return testIamPermissionsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns permissions that the caller has on the specified table resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BaseBigtableTableAdminClient baseBigtableTableAdminClient = BaseBigtableTableAdminClient.create()) {
   *   String formattedResource = TableName.format("[PROJECT]", "[INSTANCE]", "[TABLE]");
   *   List&lt;String&gt; permissions = new ArrayList&lt;&gt;();
   *   TestIamPermissionsRequest request = TestIamPermissionsRequest.newBuilder()
   *     .setResource(formattedResource)
   *     .addAllPermissions(permissions)
   *     .build();
   *   ApiFuture&lt;TestIamPermissionsResponse&gt; future = baseBigtableTableAdminClient.testIamPermissionsCallable().futureCall(request);
   *   // Do something
   *   TestIamPermissionsResponse response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable() {
    return stub.testIamPermissionsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a new snapshot in the specified cluster from the specified source table. The cluster
   * and the table must be in the same instance.
   *
   * <p>Note: This is a private alpha release of Cloud Bigtable snapshots. This feature is not
   * currently available to most Cloud Bigtable customers. This feature might be changed in
   * backward-incompatible ways and is not recommended for production use. It is not subject to any
   * SLA or deprecation policy.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BaseBigtableTableAdminClient baseBigtableTableAdminClient = BaseBigtableTableAdminClient.create()) {
   *   TableName name = TableName.of("[PROJECT]", "[INSTANCE]", "[TABLE]");
   *   ClusterName cluster = ClusterName.of("[PROJECT]", "[INSTANCE]", "[CLUSTER]");
   *   SnapshotName snapshotId = SnapshotName.of("[PROJECT]", "[INSTANCE]", "[CLUSTER]", "[SNAPSHOT]");
   *   String description = "";
   *   Snapshot response = baseBigtableTableAdminClient.snapshotTableAsync(name, cluster, snapshotId, description).get();
   * }
   * </code></pre>
   *
   * @param name The unique name of the table to have the snapshot taken. Values are of the form
   *     `projects/&lt;project&gt;/instances/&lt;instance&gt;/tables/&lt;table&gt;`.
   * @param cluster The name of the cluster where the snapshot will be created in. Values are of the
   *     form `projects/&lt;project&gt;/instances/&lt;instance&gt;/clusters/&lt;cluster&gt;`.
   * @param snapshotId The ID by which the new snapshot should be referred to within the parent
   *     cluster, e.g., `mysnapshot` of the form: `[_a-zA-Z0-9][-_.a-zA-Z0-9]&#42;` rather than
   *     `projects/&lt;project&gt;/instances/&lt;instance&gt;/clusters/&lt;cluster&gt;/snapshots/mysnapshot`.
   * @param description Description of the snapshot.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Snapshot, SnapshotTableMetadata> snapshotTableAsync(
      TableName name, ClusterName cluster, SnapshotName snapshotId, String description) {
    SnapshotTableRequest request =
        SnapshotTableRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .setCluster(cluster == null ? null : cluster.toString())
            .setSnapshotId(snapshotId == null ? null : snapshotId.toString())
            .setDescription(description)
            .build();
    return snapshotTableAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a new snapshot in the specified cluster from the specified source table. The cluster
   * and the table must be in the same instance.
   *
   * <p>Note: This is a private alpha release of Cloud Bigtable snapshots. This feature is not
   * currently available to most Cloud Bigtable customers. This feature might be changed in
   * backward-incompatible ways and is not recommended for production use. It is not subject to any
   * SLA or deprecation policy.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BaseBigtableTableAdminClient baseBigtableTableAdminClient = BaseBigtableTableAdminClient.create()) {
   *   TableName name = TableName.of("[PROJECT]", "[INSTANCE]", "[TABLE]");
   *   ClusterName cluster = ClusterName.of("[PROJECT]", "[INSTANCE]", "[CLUSTER]");
   *   SnapshotName snapshotId = SnapshotName.of("[PROJECT]", "[INSTANCE]", "[CLUSTER]", "[SNAPSHOT]");
   *   String description = "";
   *   Snapshot response = baseBigtableTableAdminClient.snapshotTableAsync(name.toString(), cluster.toString(), snapshotId.toString(), description).get();
   * }
   * </code></pre>
   *
   * @param name The unique name of the table to have the snapshot taken. Values are of the form
   *     `projects/&lt;project&gt;/instances/&lt;instance&gt;/tables/&lt;table&gt;`.
   * @param cluster The name of the cluster where the snapshot will be created in. Values are of the
   *     form `projects/&lt;project&gt;/instances/&lt;instance&gt;/clusters/&lt;cluster&gt;`.
   * @param snapshotId The ID by which the new snapshot should be referred to within the parent
   *     cluster, e.g., `mysnapshot` of the form: `[_a-zA-Z0-9][-_.a-zA-Z0-9]&#42;` rather than
   *     `projects/&lt;project&gt;/instances/&lt;instance&gt;/clusters/&lt;cluster&gt;/snapshots/mysnapshot`.
   * @param description Description of the snapshot.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Snapshot, SnapshotTableMetadata> snapshotTableAsync(
      String name, String cluster, String snapshotId, String description) {
    SnapshotTableRequest request =
        SnapshotTableRequest.newBuilder()
            .setName(name)
            .setCluster(cluster)
            .setSnapshotId(snapshotId)
            .setDescription(description)
            .build();
    return snapshotTableAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a new snapshot in the specified cluster from the specified source table. The cluster
   * and the table must be in the same instance.
   *
   * <p>Note: This is a private alpha release of Cloud Bigtable snapshots. This feature is not
   * currently available to most Cloud Bigtable customers. This feature might be changed in
   * backward-incompatible ways and is not recommended for production use. It is not subject to any
   * SLA or deprecation policy.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BaseBigtableTableAdminClient baseBigtableTableAdminClient = BaseBigtableTableAdminClient.create()) {
   *   TableName name = TableName.of("[PROJECT]", "[INSTANCE]", "[TABLE]");
   *   ClusterName cluster = ClusterName.of("[PROJECT]", "[INSTANCE]", "[CLUSTER]");
   *   SnapshotName snapshotId = SnapshotName.of("[PROJECT]", "[INSTANCE]", "[CLUSTER]", "[SNAPSHOT]");
   *   String description = "";
   *   SnapshotTableRequest request = SnapshotTableRequest.newBuilder()
   *     .setName(name.toString())
   *     .setCluster(cluster.toString())
   *     .setSnapshotId(snapshotId.toString())
   *     .setDescription(description)
   *     .build();
   *   Snapshot response = baseBigtableTableAdminClient.snapshotTableAsync(request).get();
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Snapshot, SnapshotTableMetadata> snapshotTableAsync(
      SnapshotTableRequest request) {
    return snapshotTableOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a new snapshot in the specified cluster from the specified source table. The cluster
   * and the table must be in the same instance.
   *
   * <p>Note: This is a private alpha release of Cloud Bigtable snapshots. This feature is not
   * currently available to most Cloud Bigtable customers. This feature might be changed in
   * backward-incompatible ways and is not recommended for production use. It is not subject to any
   * SLA or deprecation policy.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BaseBigtableTableAdminClient baseBigtableTableAdminClient = BaseBigtableTableAdminClient.create()) {
   *   TableName name = TableName.of("[PROJECT]", "[INSTANCE]", "[TABLE]");
   *   ClusterName cluster = ClusterName.of("[PROJECT]", "[INSTANCE]", "[CLUSTER]");
   *   SnapshotName snapshotId = SnapshotName.of("[PROJECT]", "[INSTANCE]", "[CLUSTER]", "[SNAPSHOT]");
   *   String description = "";
   *   SnapshotTableRequest request = SnapshotTableRequest.newBuilder()
   *     .setName(name.toString())
   *     .setCluster(cluster.toString())
   *     .setSnapshotId(snapshotId.toString())
   *     .setDescription(description)
   *     .build();
   *   OperationFuture&lt;Snapshot, SnapshotTableMetadata&gt; future = baseBigtableTableAdminClient.snapshotTableOperationCallable().futureCall(request);
   *   // Do something
   *   Snapshot response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi("The surface for use by generated code is not stable yet and may change in the future.")
  public final OperationCallable<SnapshotTableRequest, Snapshot, SnapshotTableMetadata>
      snapshotTableOperationCallable() {
    return stub.snapshotTableOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a new snapshot in the specified cluster from the specified source table. The cluster
   * and the table must be in the same instance.
   *
   * <p>Note: This is a private alpha release of Cloud Bigtable snapshots. This feature is not
   * currently available to most Cloud Bigtable customers. This feature might be changed in
   * backward-incompatible ways and is not recommended for production use. It is not subject to any
   * SLA or deprecation policy.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BaseBigtableTableAdminClient baseBigtableTableAdminClient = BaseBigtableTableAdminClient.create()) {
   *   TableName name = TableName.of("[PROJECT]", "[INSTANCE]", "[TABLE]");
   *   ClusterName cluster = ClusterName.of("[PROJECT]", "[INSTANCE]", "[CLUSTER]");
   *   SnapshotName snapshotId = SnapshotName.of("[PROJECT]", "[INSTANCE]", "[CLUSTER]", "[SNAPSHOT]");
   *   String description = "";
   *   SnapshotTableRequest request = SnapshotTableRequest.newBuilder()
   *     .setName(name.toString())
   *     .setCluster(cluster.toString())
   *     .setSnapshotId(snapshotId.toString())
   *     .setDescription(description)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = baseBigtableTableAdminClient.snapshotTableCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<SnapshotTableRequest, Operation> snapshotTableCallable() {
    return stub.snapshotTableCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets metadata information about the specified snapshot.
   *
   * <p>Note: This is a private alpha release of Cloud Bigtable snapshots. This feature is not
   * currently available to most Cloud Bigtable customers. This feature might be changed in
   * backward-incompatible ways and is not recommended for production use. It is not subject to any
   * SLA or deprecation policy.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BaseBigtableTableAdminClient baseBigtableTableAdminClient = BaseBigtableTableAdminClient.create()) {
   *   SnapshotName name = SnapshotName.of("[PROJECT]", "[INSTANCE]", "[CLUSTER]", "[SNAPSHOT]");
   *   Snapshot response = baseBigtableTableAdminClient.getSnapshot(name);
   * }
   * </code></pre>
   *
   * @param name The unique name of the requested snapshot. Values are of the form
   *     `projects/&lt;project&gt;/instances/&lt;instance&gt;/clusters/&lt;cluster&gt;/snapshots/&lt;snapshot&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Snapshot getSnapshot(SnapshotName name) {
    GetSnapshotRequest request =
        GetSnapshotRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getSnapshot(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets metadata information about the specified snapshot.
   *
   * <p>Note: This is a private alpha release of Cloud Bigtable snapshots. This feature is not
   * currently available to most Cloud Bigtable customers. This feature might be changed in
   * backward-incompatible ways and is not recommended for production use. It is not subject to any
   * SLA or deprecation policy.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BaseBigtableTableAdminClient baseBigtableTableAdminClient = BaseBigtableTableAdminClient.create()) {
   *   SnapshotName name = SnapshotName.of("[PROJECT]", "[INSTANCE]", "[CLUSTER]", "[SNAPSHOT]");
   *   Snapshot response = baseBigtableTableAdminClient.getSnapshot(name.toString());
   * }
   * </code></pre>
   *
   * @param name The unique name of the requested snapshot. Values are of the form
   *     `projects/&lt;project&gt;/instances/&lt;instance&gt;/clusters/&lt;cluster&gt;/snapshots/&lt;snapshot&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Snapshot getSnapshot(String name) {
    GetSnapshotRequest request = GetSnapshotRequest.newBuilder().setName(name).build();
    return getSnapshot(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets metadata information about the specified snapshot.
   *
   * <p>Note: This is a private alpha release of Cloud Bigtable snapshots. This feature is not
   * currently available to most Cloud Bigtable customers. This feature might be changed in
   * backward-incompatible ways and is not recommended for production use. It is not subject to any
   * SLA or deprecation policy.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BaseBigtableTableAdminClient baseBigtableTableAdminClient = BaseBigtableTableAdminClient.create()) {
   *   SnapshotName name = SnapshotName.of("[PROJECT]", "[INSTANCE]", "[CLUSTER]", "[SNAPSHOT]");
   *   GetSnapshotRequest request = GetSnapshotRequest.newBuilder()
   *     .setName(name.toString())
   *     .build();
   *   Snapshot response = baseBigtableTableAdminClient.getSnapshot(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Snapshot getSnapshot(GetSnapshotRequest request) {
    return getSnapshotCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets metadata information about the specified snapshot.
   *
   * <p>Note: This is a private alpha release of Cloud Bigtable snapshots. This feature is not
   * currently available to most Cloud Bigtable customers. This feature might be changed in
   * backward-incompatible ways and is not recommended for production use. It is not subject to any
   * SLA or deprecation policy.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BaseBigtableTableAdminClient baseBigtableTableAdminClient = BaseBigtableTableAdminClient.create()) {
   *   SnapshotName name = SnapshotName.of("[PROJECT]", "[INSTANCE]", "[CLUSTER]", "[SNAPSHOT]");
   *   GetSnapshotRequest request = GetSnapshotRequest.newBuilder()
   *     .setName(name.toString())
   *     .build();
   *   ApiFuture&lt;Snapshot&gt; future = baseBigtableTableAdminClient.getSnapshotCallable().futureCall(request);
   *   // Do something
   *   Snapshot response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<GetSnapshotRequest, Snapshot> getSnapshotCallable() {
    return stub.getSnapshotCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists all snapshots associated with the specified cluster.
   *
   * <p>Note: This is a private alpha release of Cloud Bigtable snapshots. This feature is not
   * currently available to most Cloud Bigtable customers. This feature might be changed in
   * backward-incompatible ways and is not recommended for production use. It is not subject to any
   * SLA or deprecation policy.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BaseBigtableTableAdminClient baseBigtableTableAdminClient = BaseBigtableTableAdminClient.create()) {
   *   ClusterName parent = ClusterName.of("[PROJECT]", "[INSTANCE]", "[CLUSTER]");
   *   for (Snapshot element : baseBigtableTableAdminClient.listSnapshots(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param parent The unique name of the cluster for which snapshots should be listed. Values are
   *     of the form `projects/&lt;project&gt;/instances/&lt;instance&gt;/clusters/&lt;cluster&gt;`.
   *     Use `&lt;cluster&gt; = '-'` to list snapshots for all clusters in an instance, e.g.,
   *     `projects/&lt;project&gt;/instances/&lt;instance&gt;/clusters/-`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSnapshotsPagedResponse listSnapshots(ClusterName parent) {
    ListSnapshotsRequest request =
        ListSnapshotsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listSnapshots(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists all snapshots associated with the specified cluster.
   *
   * <p>Note: This is a private alpha release of Cloud Bigtable snapshots. This feature is not
   * currently available to most Cloud Bigtable customers. This feature might be changed in
   * backward-incompatible ways and is not recommended for production use. It is not subject to any
   * SLA or deprecation policy.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BaseBigtableTableAdminClient baseBigtableTableAdminClient = BaseBigtableTableAdminClient.create()) {
   *   ClusterName parent = ClusterName.of("[PROJECT]", "[INSTANCE]", "[CLUSTER]");
   *   for (Snapshot element : baseBigtableTableAdminClient.listSnapshots(parent.toString()).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param parent The unique name of the cluster for which snapshots should be listed. Values are
   *     of the form `projects/&lt;project&gt;/instances/&lt;instance&gt;/clusters/&lt;cluster&gt;`.
   *     Use `&lt;cluster&gt; = '-'` to list snapshots for all clusters in an instance, e.g.,
   *     `projects/&lt;project&gt;/instances/&lt;instance&gt;/clusters/-`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSnapshotsPagedResponse listSnapshots(String parent) {
    ListSnapshotsRequest request = ListSnapshotsRequest.newBuilder().setParent(parent).build();
    return listSnapshots(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists all snapshots associated with the specified cluster.
   *
   * <p>Note: This is a private alpha release of Cloud Bigtable snapshots. This feature is not
   * currently available to most Cloud Bigtable customers. This feature might be changed in
   * backward-incompatible ways and is not recommended for production use. It is not subject to any
   * SLA or deprecation policy.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BaseBigtableTableAdminClient baseBigtableTableAdminClient = BaseBigtableTableAdminClient.create()) {
   *   ClusterName parent = ClusterName.of("[PROJECT]", "[INSTANCE]", "[CLUSTER]");
   *   ListSnapshotsRequest request = ListSnapshotsRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .build();
   *   for (Snapshot element : baseBigtableTableAdminClient.listSnapshots(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSnapshotsPagedResponse listSnapshots(ListSnapshotsRequest request) {
    return listSnapshotsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists all snapshots associated with the specified cluster.
   *
   * <p>Note: This is a private alpha release of Cloud Bigtable snapshots. This feature is not
   * currently available to most Cloud Bigtable customers. This feature might be changed in
   * backward-incompatible ways and is not recommended for production use. It is not subject to any
   * SLA or deprecation policy.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BaseBigtableTableAdminClient baseBigtableTableAdminClient = BaseBigtableTableAdminClient.create()) {
   *   ClusterName parent = ClusterName.of("[PROJECT]", "[INSTANCE]", "[CLUSTER]");
   *   ListSnapshotsRequest request = ListSnapshotsRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .build();
   *   ApiFuture&lt;ListSnapshotsPagedResponse&gt; future = baseBigtableTableAdminClient.listSnapshotsPagedCallable().futureCall(request);
   *   // Do something
   *   for (Snapshot element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  public final UnaryCallable<ListSnapshotsRequest, ListSnapshotsPagedResponse>
      listSnapshotsPagedCallable() {
    return stub.listSnapshotsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists all snapshots associated with the specified cluster.
   *
   * <p>Note: This is a private alpha release of Cloud Bigtable snapshots. This feature is not
   * currently available to most Cloud Bigtable customers. This feature might be changed in
   * backward-incompatible ways and is not recommended for production use. It is not subject to any
   * SLA or deprecation policy.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BaseBigtableTableAdminClient baseBigtableTableAdminClient = BaseBigtableTableAdminClient.create()) {
   *   ClusterName parent = ClusterName.of("[PROJECT]", "[INSTANCE]", "[CLUSTER]");
   *   ListSnapshotsRequest request = ListSnapshotsRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .build();
   *   while (true) {
   *     ListSnapshotsResponse response = baseBigtableTableAdminClient.listSnapshotsCallable().call(request);
   *     for (Snapshot element : response.getSnapshotsList()) {
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
  public final UnaryCallable<ListSnapshotsRequest, ListSnapshotsResponse> listSnapshotsCallable() {
    return stub.listSnapshotsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Permanently deletes the specified snapshot.
   *
   * <p>Note: This is a private alpha release of Cloud Bigtable snapshots. This feature is not
   * currently available to most Cloud Bigtable customers. This feature might be changed in
   * backward-incompatible ways and is not recommended for production use. It is not subject to any
   * SLA or deprecation policy.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BaseBigtableTableAdminClient baseBigtableTableAdminClient = BaseBigtableTableAdminClient.create()) {
   *   SnapshotName name = SnapshotName.of("[PROJECT]", "[INSTANCE]", "[CLUSTER]", "[SNAPSHOT]");
   *   baseBigtableTableAdminClient.deleteSnapshot(name);
   * }
   * </code></pre>
   *
   * @param name The unique name of the snapshot to be deleted. Values are of the form
   *     `projects/&lt;project&gt;/instances/&lt;instance&gt;/clusters/&lt;cluster&gt;/snapshots/&lt;snapshot&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteSnapshot(SnapshotName name) {
    DeleteSnapshotRequest request =
        DeleteSnapshotRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    deleteSnapshot(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Permanently deletes the specified snapshot.
   *
   * <p>Note: This is a private alpha release of Cloud Bigtable snapshots. This feature is not
   * currently available to most Cloud Bigtable customers. This feature might be changed in
   * backward-incompatible ways and is not recommended for production use. It is not subject to any
   * SLA or deprecation policy.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BaseBigtableTableAdminClient baseBigtableTableAdminClient = BaseBigtableTableAdminClient.create()) {
   *   SnapshotName name = SnapshotName.of("[PROJECT]", "[INSTANCE]", "[CLUSTER]", "[SNAPSHOT]");
   *   baseBigtableTableAdminClient.deleteSnapshot(name.toString());
   * }
   * </code></pre>
   *
   * @param name The unique name of the snapshot to be deleted. Values are of the form
   *     `projects/&lt;project&gt;/instances/&lt;instance&gt;/clusters/&lt;cluster&gt;/snapshots/&lt;snapshot&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteSnapshot(String name) {
    DeleteSnapshotRequest request = DeleteSnapshotRequest.newBuilder().setName(name).build();
    deleteSnapshot(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Permanently deletes the specified snapshot.
   *
   * <p>Note: This is a private alpha release of Cloud Bigtable snapshots. This feature is not
   * currently available to most Cloud Bigtable customers. This feature might be changed in
   * backward-incompatible ways and is not recommended for production use. It is not subject to any
   * SLA or deprecation policy.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BaseBigtableTableAdminClient baseBigtableTableAdminClient = BaseBigtableTableAdminClient.create()) {
   *   SnapshotName name = SnapshotName.of("[PROJECT]", "[INSTANCE]", "[CLUSTER]", "[SNAPSHOT]");
   *   DeleteSnapshotRequest request = DeleteSnapshotRequest.newBuilder()
   *     .setName(name.toString())
   *     .build();
   *   baseBigtableTableAdminClient.deleteSnapshot(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteSnapshot(DeleteSnapshotRequest request) {
    deleteSnapshotCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Permanently deletes the specified snapshot.
   *
   * <p>Note: This is a private alpha release of Cloud Bigtable snapshots. This feature is not
   * currently available to most Cloud Bigtable customers. This feature might be changed in
   * backward-incompatible ways and is not recommended for production use. It is not subject to any
   * SLA or deprecation policy.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BaseBigtableTableAdminClient baseBigtableTableAdminClient = BaseBigtableTableAdminClient.create()) {
   *   SnapshotName name = SnapshotName.of("[PROJECT]", "[INSTANCE]", "[CLUSTER]", "[SNAPSHOT]");
   *   DeleteSnapshotRequest request = DeleteSnapshotRequest.newBuilder()
   *     .setName(name.toString())
   *     .build();
   *   ApiFuture&lt;Void&gt; future = baseBigtableTableAdminClient.deleteSnapshotCallable().futureCall(request);
   *   // Do something
   *   future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<DeleteSnapshotRequest, Empty> deleteSnapshotCallable() {
    return stub.deleteSnapshotCallable();
  }

  @Override
  public final void close() {
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

  public static class ListTablesPagedResponse
      extends AbstractPagedListResponse<
          ListTablesRequest,
          ListTablesResponse,
          Table,
          ListTablesPage,
          ListTablesFixedSizeCollection> {

    public static ApiFuture<ListTablesPagedResponse> createAsync(
        PageContext<ListTablesRequest, ListTablesResponse, Table> context,
        ApiFuture<ListTablesResponse> futureResponse) {
      ApiFuture<ListTablesPage> futurePage =
          ListTablesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListTablesPage, ListTablesPagedResponse>() {
            @Override
            public ListTablesPagedResponse apply(ListTablesPage input) {
              return new ListTablesPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
    }

    private ListTablesPagedResponse(ListTablesPage page) {
      super(page, ListTablesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListTablesPage
      extends AbstractPage<ListTablesRequest, ListTablesResponse, Table, ListTablesPage> {

    private ListTablesPage(
        PageContext<ListTablesRequest, ListTablesResponse, Table> context,
        ListTablesResponse response) {
      super(context, response);
    }

    private static ListTablesPage createEmptyPage() {
      return new ListTablesPage(null, null);
    }

    @Override
    protected ListTablesPage createPage(
        PageContext<ListTablesRequest, ListTablesResponse, Table> context,
        ListTablesResponse response) {
      return new ListTablesPage(context, response);
    }

    @Override
    public ApiFuture<ListTablesPage> createPageAsync(
        PageContext<ListTablesRequest, ListTablesResponse, Table> context,
        ApiFuture<ListTablesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListTablesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListTablesRequest,
          ListTablesResponse,
          Table,
          ListTablesPage,
          ListTablesFixedSizeCollection> {

    private ListTablesFixedSizeCollection(List<ListTablesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListTablesFixedSizeCollection createEmptyCollection() {
      return new ListTablesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListTablesFixedSizeCollection createCollection(
        List<ListTablesPage> pages, int collectionSize) {
      return new ListTablesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListSnapshotsPagedResponse
      extends AbstractPagedListResponse<
          ListSnapshotsRequest,
          ListSnapshotsResponse,
          Snapshot,
          ListSnapshotsPage,
          ListSnapshotsFixedSizeCollection> {

    public static ApiFuture<ListSnapshotsPagedResponse> createAsync(
        PageContext<ListSnapshotsRequest, ListSnapshotsResponse, Snapshot> context,
        ApiFuture<ListSnapshotsResponse> futureResponse) {
      ApiFuture<ListSnapshotsPage> futurePage =
          ListSnapshotsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListSnapshotsPage, ListSnapshotsPagedResponse>() {
            @Override
            public ListSnapshotsPagedResponse apply(ListSnapshotsPage input) {
              return new ListSnapshotsPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
    }

    private ListSnapshotsPagedResponse(ListSnapshotsPage page) {
      super(page, ListSnapshotsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListSnapshotsPage
      extends AbstractPage<
          ListSnapshotsRequest, ListSnapshotsResponse, Snapshot, ListSnapshotsPage> {

    private ListSnapshotsPage(
        PageContext<ListSnapshotsRequest, ListSnapshotsResponse, Snapshot> context,
        ListSnapshotsResponse response) {
      super(context, response);
    }

    private static ListSnapshotsPage createEmptyPage() {
      return new ListSnapshotsPage(null, null);
    }

    @Override
    protected ListSnapshotsPage createPage(
        PageContext<ListSnapshotsRequest, ListSnapshotsResponse, Snapshot> context,
        ListSnapshotsResponse response) {
      return new ListSnapshotsPage(context, response);
    }

    @Override
    public ApiFuture<ListSnapshotsPage> createPageAsync(
        PageContext<ListSnapshotsRequest, ListSnapshotsResponse, Snapshot> context,
        ApiFuture<ListSnapshotsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListSnapshotsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListSnapshotsRequest,
          ListSnapshotsResponse,
          Snapshot,
          ListSnapshotsPage,
          ListSnapshotsFixedSizeCollection> {

    private ListSnapshotsFixedSizeCollection(List<ListSnapshotsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListSnapshotsFixedSizeCollection createEmptyCollection() {
      return new ListSnapshotsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListSnapshotsFixedSizeCollection createCollection(
        List<ListSnapshotsPage> pages, int collectionSize) {
      return new ListSnapshotsFixedSizeCollection(pages, collectionSize);
    }
  }
}
