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
import com.google.api.resourcenames.ResourceName;
import com.google.bigtable.admin.v2.Backup;
import com.google.bigtable.admin.v2.BackupName;
import com.google.bigtable.admin.v2.CheckConsistencyRequest;
import com.google.bigtable.admin.v2.CheckConsistencyResponse;
import com.google.bigtable.admin.v2.ClusterName;
import com.google.bigtable.admin.v2.CreateBackupMetadata;
import com.google.bigtable.admin.v2.CreateBackupRequest;
import com.google.bigtable.admin.v2.CreateTableFromSnapshotMetadata;
import com.google.bigtable.admin.v2.CreateTableFromSnapshotRequest;
import com.google.bigtable.admin.v2.CreateTableRequest;
import com.google.bigtable.admin.v2.DeleteBackupRequest;
import com.google.bigtable.admin.v2.DeleteSnapshotRequest;
import com.google.bigtable.admin.v2.DeleteTableRequest;
import com.google.bigtable.admin.v2.DropRowRangeRequest;
import com.google.bigtable.admin.v2.GenerateConsistencyTokenRequest;
import com.google.bigtable.admin.v2.GenerateConsistencyTokenResponse;
import com.google.bigtable.admin.v2.GetBackupRequest;
import com.google.bigtable.admin.v2.GetSnapshotRequest;
import com.google.bigtable.admin.v2.GetTableRequest;
import com.google.bigtable.admin.v2.InstanceName;
import com.google.bigtable.admin.v2.ListBackupsRequest;
import com.google.bigtable.admin.v2.ListBackupsResponse;
import com.google.bigtable.admin.v2.ListSnapshotsRequest;
import com.google.bigtable.admin.v2.ListSnapshotsResponse;
import com.google.bigtable.admin.v2.ListTablesRequest;
import com.google.bigtable.admin.v2.ListTablesResponse;
import com.google.bigtable.admin.v2.ModifyColumnFamiliesRequest;
import com.google.bigtable.admin.v2.RestoreTableMetadata;
import com.google.bigtable.admin.v2.RestoreTableRequest;
import com.google.bigtable.admin.v2.Snapshot;
import com.google.bigtable.admin.v2.SnapshotName;
import com.google.bigtable.admin.v2.SnapshotTableMetadata;
import com.google.bigtable.admin.v2.SnapshotTableRequest;
import com.google.bigtable.admin.v2.Table;
import com.google.bigtable.admin.v2.TableName;
import com.google.bigtable.admin.v2.UpdateBackupRequest;
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
import com.google.protobuf.FieldMask;
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
   * @param parent Required. The unique name of the instance in which to create the table. Values
   *     are of the form `projects/{project}/instances/{instance}`.
   * @param tableId Required. The name by which the new table should be referred to within the
   *     parent instance, e.g., `foobar` rather than `{parent}/tables/foobar`. Maximum 50
   *     characters.
   * @param table Required. The Table to create.
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
   * @param parent Required. The unique name of the instance in which to create the table. Values
   *     are of the form `projects/{project}/instances/{instance}`.
   * @param tableId Required. The name by which the new table should be referred to within the
   *     parent instance, e.g., `foobar` rather than `{parent}/tables/foobar`. Maximum 50
   *     characters.
   * @param table Required. The Table to create.
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
   * @param parent Required. The unique name of the instance in which to create the table. Values
   *     are of the form `projects/{project}/instances/{instance}`.
   * @param tableId Required. The name by which the new table should be referred to within the
   *     parent instance, e.g., `foobar` rather than `{parent}/tables/foobar`.
   * @param sourceSnapshot Required. The unique name of the snapshot from which to restore the
   *     table. The snapshot and the table must be in the same instance. Values are of the form
   *     `projects/{project}/instances/{instance}/clusters/{cluster}/snapshots/{snapshot}`.
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
   * @param parent Required. The unique name of the instance in which to create the table. Values
   *     are of the form `projects/{project}/instances/{instance}`.
   * @param tableId Required. The name by which the new table should be referred to within the
   *     parent instance, e.g., `foobar` rather than `{parent}/tables/foobar`.
   * @param sourceSnapshot Required. The unique name of the snapshot from which to restore the
   *     table. The snapshot and the table must be in the same instance. Values are of the form
   *     `projects/{project}/instances/{instance}/clusters/{cluster}/snapshots/{snapshot}`.
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
   * @param parent Required. The unique name of the instance for which tables should be listed.
   *     Values are of the form `projects/{project}/instances/{instance}`.
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
   * @param parent Required. The unique name of the instance for which tables should be listed.
   *     Values are of the form `projects/{project}/instances/{instance}`.
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
   * @param name Required. The unique name of the requested table. Values are of the form
   *     `projects/{project}/instances/{instance}/tables/{table}`.
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
   * @param name Required. The unique name of the requested table. Values are of the form
   *     `projects/{project}/instances/{instance}/tables/{table}`.
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
   * @param name Required. The unique name of the table to be deleted. Values are of the form
   *     `projects/{project}/instances/{instance}/tables/{table}`.
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
   * @param name Required. The unique name of the table to be deleted. Values are of the form
   *     `projects/{project}/instances/{instance}/tables/{table}`.
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
   * @param name Required. The unique name of the table whose families should be modified. Values
   *     are of the form `projects/{project}/instances/{instance}/tables/{table}`.
   * @param modifications Required. Modifications to be atomically applied to the specified table's
   *     families. Entries are applied in order, meaning that earlier modifications can be masked by
   *     later ones (in the case of repeated updates to the same family, for example).
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
   * @param name Required. The unique name of the table whose families should be modified. Values
   *     are of the form `projects/{project}/instances/{instance}/tables/{table}`.
   * @param modifications Required. Modifications to be atomically applied to the specified table's
   *     families. Entries are applied in order, meaning that earlier modifications can be masked by
   *     later ones (in the case of repeated updates to the same family, for example).
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
   * @param name Required. The unique name of the Table for which to create a consistency token.
   *     Values are of the form `projects/{project}/instances/{instance}/tables/{table}`.
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
   * @param name Required. The unique name of the Table for which to create a consistency token.
   *     Values are of the form `projects/{project}/instances/{instance}/tables/{table}`.
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
   * @param name Required. The unique name of the Table for which to check replication consistency.
   *     Values are of the form `projects/{project}/instances/{instance}/tables/{table}`.
   * @param consistencyToken Required. The token created using GenerateConsistencyToken for the
   *     Table.
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
   * @param name Required. The unique name of the Table for which to check replication consistency.
   *     Values are of the form `projects/{project}/instances/{instance}/tables/{table}`.
   * @param consistencyToken Required. The token created using GenerateConsistencyToken for the
   *     Table.
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
   * Gets the access control policy for a resource. Returns an empty policy if the resource exists
   * but does not have a policy set.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BaseBigtableTableAdminClient baseBigtableTableAdminClient = BaseBigtableTableAdminClient.create()) {
   *   ResourceName resource = AppProfileName.of("[PROJECT]", "[INSTANCE]", "[APP_PROFILE]");
   *   Policy response = baseBigtableTableAdminClient.getIamPolicy(resource);
   * }
   * </code></pre>
   *
   * @param resource REQUIRED: The resource for which the policy is being requested. See the
   *     operation documentation for the appropriate value for this field.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy getIamPolicy(ResourceName resource) {
    GetIamPolicyRequest request =
        GetIamPolicyRequest.newBuilder()
            .setResource(resource == null ? null : resource.toString())
            .build();
    return getIamPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets the access control policy for a resource. Returns an empty policy if the resource exists
   * but does not have a policy set.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BaseBigtableTableAdminClient baseBigtableTableAdminClient = BaseBigtableTableAdminClient.create()) {
   *   ResourceName resource = AppProfileName.of("[PROJECT]", "[INSTANCE]", "[APP_PROFILE]");
   *   Policy response = baseBigtableTableAdminClient.getIamPolicy(resource.toString());
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
   * Gets the access control policy for a resource. Returns an empty policy if the resource exists
   * but does not have a policy set.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BaseBigtableTableAdminClient baseBigtableTableAdminClient = BaseBigtableTableAdminClient.create()) {
   *   ResourceName resource = AppProfileName.of("[PROJECT]", "[INSTANCE]", "[APP_PROFILE]");
   *   GetIamPolicyRequest request = GetIamPolicyRequest.newBuilder()
   *     .setResource(resource.toString())
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
   * Gets the access control policy for a resource. Returns an empty policy if the resource exists
   * but does not have a policy set.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BaseBigtableTableAdminClient baseBigtableTableAdminClient = BaseBigtableTableAdminClient.create()) {
   *   ResourceName resource = AppProfileName.of("[PROJECT]", "[INSTANCE]", "[APP_PROFILE]");
   *   GetIamPolicyRequest request = GetIamPolicyRequest.newBuilder()
   *     .setResource(resource.toString())
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
   * Sets the access control policy on a Table or Backup resource. Replaces any existing policy.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BaseBigtableTableAdminClient baseBigtableTableAdminClient = BaseBigtableTableAdminClient.create()) {
   *   ResourceName resource = AppProfileName.of("[PROJECT]", "[INSTANCE]", "[APP_PROFILE]");
   *   Policy policy = Policy.newBuilder().build();
   *   Policy response = baseBigtableTableAdminClient.setIamPolicy(resource, policy);
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
  public final Policy setIamPolicy(ResourceName resource, Policy policy) {
    SetIamPolicyRequest request =
        SetIamPolicyRequest.newBuilder()
            .setResource(resource == null ? null : resource.toString())
            .setPolicy(policy)
            .build();
    return setIamPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets the access control policy on a Table or Backup resource. Replaces any existing policy.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BaseBigtableTableAdminClient baseBigtableTableAdminClient = BaseBigtableTableAdminClient.create()) {
   *   ResourceName resource = AppProfileName.of("[PROJECT]", "[INSTANCE]", "[APP_PROFILE]");
   *   Policy policy = Policy.newBuilder().build();
   *   Policy response = baseBigtableTableAdminClient.setIamPolicy(resource.toString(), policy);
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
   * Sets the access control policy on a Table or Backup resource. Replaces any existing policy.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BaseBigtableTableAdminClient baseBigtableTableAdminClient = BaseBigtableTableAdminClient.create()) {
   *   ResourceName resource = AppProfileName.of("[PROJECT]", "[INSTANCE]", "[APP_PROFILE]");
   *   Policy policy = Policy.newBuilder().build();
   *   SetIamPolicyRequest request = SetIamPolicyRequest.newBuilder()
   *     .setResource(resource.toString())
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
   * Sets the access control policy on a Table or Backup resource. Replaces any existing policy.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BaseBigtableTableAdminClient baseBigtableTableAdminClient = BaseBigtableTableAdminClient.create()) {
   *   ResourceName resource = AppProfileName.of("[PROJECT]", "[INSTANCE]", "[APP_PROFILE]");
   *   Policy policy = Policy.newBuilder().build();
   *   SetIamPolicyRequest request = SetIamPolicyRequest.newBuilder()
   *     .setResource(resource.toString())
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
   *   ResourceName resource = AppProfileName.of("[PROJECT]", "[INSTANCE]", "[APP_PROFILE]");
   *   List&lt;String&gt; permissions = new ArrayList&lt;&gt;();
   *   TestIamPermissionsResponse response = baseBigtableTableAdminClient.testIamPermissions(resource, permissions);
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
      ResourceName resource, List<String> permissions) {
    TestIamPermissionsRequest request =
        TestIamPermissionsRequest.newBuilder()
            .setResource(resource == null ? null : resource.toString())
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
   *   ResourceName resource = AppProfileName.of("[PROJECT]", "[INSTANCE]", "[APP_PROFILE]");
   *   List&lt;String&gt; permissions = new ArrayList&lt;&gt;();
   *   TestIamPermissionsResponse response = baseBigtableTableAdminClient.testIamPermissions(resource.toString(), permissions);
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
   *   ResourceName resource = AppProfileName.of("[PROJECT]", "[INSTANCE]", "[APP_PROFILE]");
   *   List&lt;String&gt; permissions = new ArrayList&lt;&gt;();
   *   TestIamPermissionsRequest request = TestIamPermissionsRequest.newBuilder()
   *     .setResource(resource.toString())
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
   *   ResourceName resource = AppProfileName.of("[PROJECT]", "[INSTANCE]", "[APP_PROFILE]");
   *   List&lt;String&gt; permissions = new ArrayList&lt;&gt;();
   *   TestIamPermissionsRequest request = TestIamPermissionsRequest.newBuilder()
   *     .setResource(resource.toString())
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
   *   String snapshotId = "";
   *   String description = "";
   *   Snapshot response = baseBigtableTableAdminClient.snapshotTableAsync(name, cluster, snapshotId, description).get();
   * }
   * </code></pre>
   *
   * @param name Required. The unique name of the table to have the snapshot taken. Values are of
   *     the form `projects/{project}/instances/{instance}/tables/{table}`.
   * @param cluster Required. The name of the cluster where the snapshot will be created in. Values
   *     are of the form `projects/{project}/instances/{instance}/clusters/{cluster}`.
   * @param snapshotId Required. The ID by which the new snapshot should be referred to within the
   *     parent cluster, e.g., `mysnapshot` of the form: `[_a-zA-Z0-9][-_.a-zA-Z0-9]&#42;` rather
   *     than `projects/{project}/instances/{instance}/clusters/{cluster}/snapshots/mysnapshot`.
   * @param description Description of the snapshot.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Snapshot, SnapshotTableMetadata> snapshotTableAsync(
      TableName name, ClusterName cluster, String snapshotId, String description) {
    SnapshotTableRequest request =
        SnapshotTableRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .setCluster(cluster == null ? null : cluster.toString())
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
   *   String snapshotId = "";
   *   String description = "";
   *   Snapshot response = baseBigtableTableAdminClient.snapshotTableAsync(name.toString(), cluster.toString(), snapshotId, description).get();
   * }
   * </code></pre>
   *
   * @param name Required. The unique name of the table to have the snapshot taken. Values are of
   *     the form `projects/{project}/instances/{instance}/tables/{table}`.
   * @param cluster Required. The name of the cluster where the snapshot will be created in. Values
   *     are of the form `projects/{project}/instances/{instance}/clusters/{cluster}`.
   * @param snapshotId Required. The ID by which the new snapshot should be referred to within the
   *     parent cluster, e.g., `mysnapshot` of the form: `[_a-zA-Z0-9][-_.a-zA-Z0-9]&#42;` rather
   *     than `projects/{project}/instances/{instance}/clusters/{cluster}/snapshots/mysnapshot`.
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
   *   String snapshotId = "";
   *   SnapshotTableRequest request = SnapshotTableRequest.newBuilder()
   *     .setName(name.toString())
   *     .setCluster(cluster.toString())
   *     .setSnapshotId(snapshotId)
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
   *   String snapshotId = "";
   *   SnapshotTableRequest request = SnapshotTableRequest.newBuilder()
   *     .setName(name.toString())
   *     .setCluster(cluster.toString())
   *     .setSnapshotId(snapshotId)
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
   *   String snapshotId = "";
   *   SnapshotTableRequest request = SnapshotTableRequest.newBuilder()
   *     .setName(name.toString())
   *     .setCluster(cluster.toString())
   *     .setSnapshotId(snapshotId)
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
   * @param name Required. The unique name of the requested snapshot. Values are of the form
   *     `projects/{project}/instances/{instance}/clusters/{cluster}/snapshots/{snapshot}`.
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
   * @param name Required. The unique name of the requested snapshot. Values are of the form
   *     `projects/{project}/instances/{instance}/clusters/{cluster}/snapshots/{snapshot}`.
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
   * @param parent Required. The unique name of the cluster for which snapshots should be listed.
   *     Values are of the form `projects/{project}/instances/{instance}/clusters/{cluster}`. Use
   *     `{cluster} = '-'` to list snapshots for all clusters in an instance, e.g.,
   *     `projects/{project}/instances/{instance}/clusters/-`.
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
   * @param parent Required. The unique name of the cluster for which snapshots should be listed.
   *     Values are of the form `projects/{project}/instances/{instance}/clusters/{cluster}`. Use
   *     `{cluster} = '-'` to list snapshots for all clusters in an instance, e.g.,
   *     `projects/{project}/instances/{instance}/clusters/-`.
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
   * @param name Required. The unique name of the snapshot to be deleted. Values are of the form
   *     `projects/{project}/instances/{instance}/clusters/{cluster}/snapshots/{snapshot}`.
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
   * @param name Required. The unique name of the snapshot to be deleted. Values are of the form
   *     `projects/{project}/instances/{instance}/clusters/{cluster}/snapshots/{snapshot}`.
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

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Starts creating a new Cloud Bigtable Backup. The returned backup [long-running
   * operation][google.longrunning.Operation] can be used to track creation of the backup. The
   * [metadata][google.longrunning.Operation.metadata] field type is
   * [CreateBackupMetadata][google.bigtable.admin.v2.CreateBackupMetadata]. The
   * [response][google.longrunning.Operation.response] field type is
   * [Backup][google.bigtable.admin.v2.Backup], if successful. Cancelling the returned operation
   * will stop the creation and delete the backup.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BaseBigtableTableAdminClient baseBigtableTableAdminClient = BaseBigtableTableAdminClient.create()) {
   *   ClusterName parent = ClusterName.of("[PROJECT]", "[INSTANCE]", "[CLUSTER]");
   *   String backupId = "";
   *   Backup backup = Backup.newBuilder().build();
   *   Backup response = baseBigtableTableAdminClient.createBackupAsync(parent, backupId, backup).get();
   * }
   * </code></pre>
   *
   * @param parent Required. This must be one of the clusters in the instance in which this table is
   *     located. The backup will be stored in this cluster. Values are of the form
   *     `projects/{project}/instances/{instance}/clusters/{cluster}`.
   * @param backupId Required. The id of the backup to be created. The `backup_id` along with the
   *     parent `parent` are combined as {parent}/backups/{backup_id} to create the full backup
   *     name, of the form:
   *     `projects/{project}/instances/{instance}/clusters/{cluster}/backups/{backup_id}`. This
   *     string must be between 1 and 50 characters in length and match the regex
   *     [_a-zA-Z0-9][-_.a-zA-Z0-9]&#42;.
   * @param backup Required. The backup to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Backup, CreateBackupMetadata> createBackupAsync(
      ClusterName parent, String backupId, Backup backup) {
    CreateBackupRequest request =
        CreateBackupRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setBackupId(backupId)
            .setBackup(backup)
            .build();
    return createBackupAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Starts creating a new Cloud Bigtable Backup. The returned backup [long-running
   * operation][google.longrunning.Operation] can be used to track creation of the backup. The
   * [metadata][google.longrunning.Operation.metadata] field type is
   * [CreateBackupMetadata][google.bigtable.admin.v2.CreateBackupMetadata]. The
   * [response][google.longrunning.Operation.response] field type is
   * [Backup][google.bigtable.admin.v2.Backup], if successful. Cancelling the returned operation
   * will stop the creation and delete the backup.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BaseBigtableTableAdminClient baseBigtableTableAdminClient = BaseBigtableTableAdminClient.create()) {
   *   ClusterName parent = ClusterName.of("[PROJECT]", "[INSTANCE]", "[CLUSTER]");
   *   String backupId = "";
   *   Backup backup = Backup.newBuilder().build();
   *   Backup response = baseBigtableTableAdminClient.createBackupAsync(parent.toString(), backupId, backup).get();
   * }
   * </code></pre>
   *
   * @param parent Required. This must be one of the clusters in the instance in which this table is
   *     located. The backup will be stored in this cluster. Values are of the form
   *     `projects/{project}/instances/{instance}/clusters/{cluster}`.
   * @param backupId Required. The id of the backup to be created. The `backup_id` along with the
   *     parent `parent` are combined as {parent}/backups/{backup_id} to create the full backup
   *     name, of the form:
   *     `projects/{project}/instances/{instance}/clusters/{cluster}/backups/{backup_id}`. This
   *     string must be between 1 and 50 characters in length and match the regex
   *     [_a-zA-Z0-9][-_.a-zA-Z0-9]&#42;.
   * @param backup Required. The backup to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Backup, CreateBackupMetadata> createBackupAsync(
      String parent, String backupId, Backup backup) {
    CreateBackupRequest request =
        CreateBackupRequest.newBuilder()
            .setParent(parent)
            .setBackupId(backupId)
            .setBackup(backup)
            .build();
    return createBackupAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Starts creating a new Cloud Bigtable Backup. The returned backup [long-running
   * operation][google.longrunning.Operation] can be used to track creation of the backup. The
   * [metadata][google.longrunning.Operation.metadata] field type is
   * [CreateBackupMetadata][google.bigtable.admin.v2.CreateBackupMetadata]. The
   * [response][google.longrunning.Operation.response] field type is
   * [Backup][google.bigtable.admin.v2.Backup], if successful. Cancelling the returned operation
   * will stop the creation and delete the backup.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BaseBigtableTableAdminClient baseBigtableTableAdminClient = BaseBigtableTableAdminClient.create()) {
   *   ClusterName parent = ClusterName.of("[PROJECT]", "[INSTANCE]", "[CLUSTER]");
   *   String backupId = "";
   *   Backup backup = Backup.newBuilder().build();
   *   CreateBackupRequest request = CreateBackupRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .setBackupId(backupId)
   *     .setBackup(backup)
   *     .build();
   *   Backup response = baseBigtableTableAdminClient.createBackupAsync(request).get();
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Backup, CreateBackupMetadata> createBackupAsync(
      CreateBackupRequest request) {
    return createBackupOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Starts creating a new Cloud Bigtable Backup. The returned backup [long-running
   * operation][google.longrunning.Operation] can be used to track creation of the backup. The
   * [metadata][google.longrunning.Operation.metadata] field type is
   * [CreateBackupMetadata][google.bigtable.admin.v2.CreateBackupMetadata]. The
   * [response][google.longrunning.Operation.response] field type is
   * [Backup][google.bigtable.admin.v2.Backup], if successful. Cancelling the returned operation
   * will stop the creation and delete the backup.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BaseBigtableTableAdminClient baseBigtableTableAdminClient = BaseBigtableTableAdminClient.create()) {
   *   ClusterName parent = ClusterName.of("[PROJECT]", "[INSTANCE]", "[CLUSTER]");
   *   String backupId = "";
   *   Backup backup = Backup.newBuilder().build();
   *   CreateBackupRequest request = CreateBackupRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .setBackupId(backupId)
   *     .setBackup(backup)
   *     .build();
   *   OperationFuture&lt;Backup, CreateBackupMetadata&gt; future = baseBigtableTableAdminClient.createBackupOperationCallable().futureCall(request);
   *   // Do something
   *   Backup response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi("The surface for use by generated code is not stable yet and may change in the future.")
  public final OperationCallable<CreateBackupRequest, Backup, CreateBackupMetadata>
      createBackupOperationCallable() {
    return stub.createBackupOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Starts creating a new Cloud Bigtable Backup. The returned backup [long-running
   * operation][google.longrunning.Operation] can be used to track creation of the backup. The
   * [metadata][google.longrunning.Operation.metadata] field type is
   * [CreateBackupMetadata][google.bigtable.admin.v2.CreateBackupMetadata]. The
   * [response][google.longrunning.Operation.response] field type is
   * [Backup][google.bigtable.admin.v2.Backup], if successful. Cancelling the returned operation
   * will stop the creation and delete the backup.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BaseBigtableTableAdminClient baseBigtableTableAdminClient = BaseBigtableTableAdminClient.create()) {
   *   ClusterName parent = ClusterName.of("[PROJECT]", "[INSTANCE]", "[CLUSTER]");
   *   String backupId = "";
   *   Backup backup = Backup.newBuilder().build();
   *   CreateBackupRequest request = CreateBackupRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .setBackupId(backupId)
   *     .setBackup(backup)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = baseBigtableTableAdminClient.createBackupCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<CreateBackupRequest, Operation> createBackupCallable() {
    return stub.createBackupCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets metadata on a pending or completed Cloud Bigtable Backup.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BaseBigtableTableAdminClient baseBigtableTableAdminClient = BaseBigtableTableAdminClient.create()) {
   *   BackupName name = BackupName.of("[PROJECT]", "[INSTANCE]", "[CLUSTER]", "[BACKUP]");
   *   Backup response = baseBigtableTableAdminClient.getBackup(name);
   * }
   * </code></pre>
   *
   * @param name Required. Name of the backup. Values are of the form
   *     `projects/{project}/instances/{instance}/clusters/{cluster}/backups/{backup}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Backup getBackup(BackupName name) {
    GetBackupRequest request =
        GetBackupRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getBackup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets metadata on a pending or completed Cloud Bigtable Backup.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BaseBigtableTableAdminClient baseBigtableTableAdminClient = BaseBigtableTableAdminClient.create()) {
   *   BackupName name = BackupName.of("[PROJECT]", "[INSTANCE]", "[CLUSTER]", "[BACKUP]");
   *   Backup response = baseBigtableTableAdminClient.getBackup(name.toString());
   * }
   * </code></pre>
   *
   * @param name Required. Name of the backup. Values are of the form
   *     `projects/{project}/instances/{instance}/clusters/{cluster}/backups/{backup}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Backup getBackup(String name) {
    GetBackupRequest request = GetBackupRequest.newBuilder().setName(name).build();
    return getBackup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets metadata on a pending or completed Cloud Bigtable Backup.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BaseBigtableTableAdminClient baseBigtableTableAdminClient = BaseBigtableTableAdminClient.create()) {
   *   BackupName name = BackupName.of("[PROJECT]", "[INSTANCE]", "[CLUSTER]", "[BACKUP]");
   *   GetBackupRequest request = GetBackupRequest.newBuilder()
   *     .setName(name.toString())
   *     .build();
   *   Backup response = baseBigtableTableAdminClient.getBackup(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Backup getBackup(GetBackupRequest request) {
    return getBackupCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets metadata on a pending or completed Cloud Bigtable Backup.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BaseBigtableTableAdminClient baseBigtableTableAdminClient = BaseBigtableTableAdminClient.create()) {
   *   BackupName name = BackupName.of("[PROJECT]", "[INSTANCE]", "[CLUSTER]", "[BACKUP]");
   *   GetBackupRequest request = GetBackupRequest.newBuilder()
   *     .setName(name.toString())
   *     .build();
   *   ApiFuture&lt;Backup&gt; future = baseBigtableTableAdminClient.getBackupCallable().futureCall(request);
   *   // Do something
   *   Backup response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<GetBackupRequest, Backup> getBackupCallable() {
    return stub.getBackupCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists Cloud Bigtable backups. Returns both completed and pending backups.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BaseBigtableTableAdminClient baseBigtableTableAdminClient = BaseBigtableTableAdminClient.create()) {
   *   ClusterName parent = ClusterName.of("[PROJECT]", "[INSTANCE]", "[CLUSTER]");
   *   for (Backup element : baseBigtableTableAdminClient.listBackups(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param parent Required. The cluster to list backups from. Values are of the form
   *     `projects/{project}/instances/{instance}/clusters/{cluster}`. Use `{cluster} = '-'` to list
   *     backups for all clusters in an instance, e.g.,
   *     `projects/{project}/instances/{instance}/clusters/-`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListBackupsPagedResponse listBackups(ClusterName parent) {
    ListBackupsRequest request =
        ListBackupsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listBackups(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists Cloud Bigtable backups. Returns both completed and pending backups.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BaseBigtableTableAdminClient baseBigtableTableAdminClient = BaseBigtableTableAdminClient.create()) {
   *   ClusterName parent = ClusterName.of("[PROJECT]", "[INSTANCE]", "[CLUSTER]");
   *   for (Backup element : baseBigtableTableAdminClient.listBackups(parent.toString()).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param parent Required. The cluster to list backups from. Values are of the form
   *     `projects/{project}/instances/{instance}/clusters/{cluster}`. Use `{cluster} = '-'` to list
   *     backups for all clusters in an instance, e.g.,
   *     `projects/{project}/instances/{instance}/clusters/-`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListBackupsPagedResponse listBackups(String parent) {
    ListBackupsRequest request = ListBackupsRequest.newBuilder().setParent(parent).build();
    return listBackups(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists Cloud Bigtable backups. Returns both completed and pending backups.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BaseBigtableTableAdminClient baseBigtableTableAdminClient = BaseBigtableTableAdminClient.create()) {
   *   ClusterName parent = ClusterName.of("[PROJECT]", "[INSTANCE]", "[CLUSTER]");
   *   ListBackupsRequest request = ListBackupsRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .build();
   *   for (Backup element : baseBigtableTableAdminClient.listBackups(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListBackupsPagedResponse listBackups(ListBackupsRequest request) {
    return listBackupsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists Cloud Bigtable backups. Returns both completed and pending backups.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BaseBigtableTableAdminClient baseBigtableTableAdminClient = BaseBigtableTableAdminClient.create()) {
   *   ClusterName parent = ClusterName.of("[PROJECT]", "[INSTANCE]", "[CLUSTER]");
   *   ListBackupsRequest request = ListBackupsRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .build();
   *   ApiFuture&lt;ListBackupsPagedResponse&gt; future = baseBigtableTableAdminClient.listBackupsPagedCallable().futureCall(request);
   *   // Do something
   *   for (Backup element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  public final UnaryCallable<ListBackupsRequest, ListBackupsPagedResponse>
      listBackupsPagedCallable() {
    return stub.listBackupsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists Cloud Bigtable backups. Returns both completed and pending backups.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BaseBigtableTableAdminClient baseBigtableTableAdminClient = BaseBigtableTableAdminClient.create()) {
   *   ClusterName parent = ClusterName.of("[PROJECT]", "[INSTANCE]", "[CLUSTER]");
   *   ListBackupsRequest request = ListBackupsRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .build();
   *   while (true) {
   *     ListBackupsResponse response = baseBigtableTableAdminClient.listBackupsCallable().call(request);
   *     for (Backup element : response.getBackupsList()) {
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
  public final UnaryCallable<ListBackupsRequest, ListBackupsResponse> listBackupsCallable() {
    return stub.listBackupsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates a pending or completed Cloud Bigtable Backup.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BaseBigtableTableAdminClient baseBigtableTableAdminClient = BaseBigtableTableAdminClient.create()) {
   *   Backup backup = Backup.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Backup response = baseBigtableTableAdminClient.updateBackup(backup, updateMask);
   * }
   * </code></pre>
   *
   * @param backup Required. The backup to update. `backup.name`, and the fields to be updated as
   *     specified by `update_mask` are required. Other fields are ignored. Update is only supported
   *     for the following fields: &#42; `backup.expire_time`.
   * @param updateMask Required. A mask specifying which fields (e.g. `expire_time`) in the Backup
   *     resource should be updated. This mask is relative to the Backup resource, not to the
   *     request message. The field mask must always be specified; this prevents any future fields
   *     from being erased accidentally by clients that do not know about them.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Backup updateBackup(Backup backup, FieldMask updateMask) {
    UpdateBackupRequest request =
        UpdateBackupRequest.newBuilder().setBackup(backup).setUpdateMask(updateMask).build();
    return updateBackup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates a pending or completed Cloud Bigtable Backup.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BaseBigtableTableAdminClient baseBigtableTableAdminClient = BaseBigtableTableAdminClient.create()) {
   *   Backup backup = Backup.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   UpdateBackupRequest request = UpdateBackupRequest.newBuilder()
   *     .setBackup(backup)
   *     .setUpdateMask(updateMask)
   *     .build();
   *   Backup response = baseBigtableTableAdminClient.updateBackup(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Backup updateBackup(UpdateBackupRequest request) {
    return updateBackupCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates a pending or completed Cloud Bigtable Backup.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BaseBigtableTableAdminClient baseBigtableTableAdminClient = BaseBigtableTableAdminClient.create()) {
   *   Backup backup = Backup.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   UpdateBackupRequest request = UpdateBackupRequest.newBuilder()
   *     .setBackup(backup)
   *     .setUpdateMask(updateMask)
   *     .build();
   *   ApiFuture&lt;Backup&gt; future = baseBigtableTableAdminClient.updateBackupCallable().futureCall(request);
   *   // Do something
   *   Backup response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<UpdateBackupRequest, Backup> updateBackupCallable() {
    return stub.updateBackupCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes a pending or completed Cloud Bigtable backup.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BaseBigtableTableAdminClient baseBigtableTableAdminClient = BaseBigtableTableAdminClient.create()) {
   *   BackupName name = BackupName.of("[PROJECT]", "[INSTANCE]", "[CLUSTER]", "[BACKUP]");
   *   baseBigtableTableAdminClient.deleteBackup(name);
   * }
   * </code></pre>
   *
   * @param name Required. Name of the backup to delete. Values are of the form
   *     `projects/{project}/instances/{instance}/clusters/{cluster}/backups/{backup}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteBackup(BackupName name) {
    DeleteBackupRequest request =
        DeleteBackupRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    deleteBackup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes a pending or completed Cloud Bigtable backup.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BaseBigtableTableAdminClient baseBigtableTableAdminClient = BaseBigtableTableAdminClient.create()) {
   *   BackupName name = BackupName.of("[PROJECT]", "[INSTANCE]", "[CLUSTER]", "[BACKUP]");
   *   baseBigtableTableAdminClient.deleteBackup(name.toString());
   * }
   * </code></pre>
   *
   * @param name Required. Name of the backup to delete. Values are of the form
   *     `projects/{project}/instances/{instance}/clusters/{cluster}/backups/{backup}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteBackup(String name) {
    DeleteBackupRequest request = DeleteBackupRequest.newBuilder().setName(name).build();
    deleteBackup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes a pending or completed Cloud Bigtable backup.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BaseBigtableTableAdminClient baseBigtableTableAdminClient = BaseBigtableTableAdminClient.create()) {
   *   BackupName name = BackupName.of("[PROJECT]", "[INSTANCE]", "[CLUSTER]", "[BACKUP]");
   *   DeleteBackupRequest request = DeleteBackupRequest.newBuilder()
   *     .setName(name.toString())
   *     .build();
   *   baseBigtableTableAdminClient.deleteBackup(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteBackup(DeleteBackupRequest request) {
    deleteBackupCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes a pending or completed Cloud Bigtable backup.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BaseBigtableTableAdminClient baseBigtableTableAdminClient = BaseBigtableTableAdminClient.create()) {
   *   BackupName name = BackupName.of("[PROJECT]", "[INSTANCE]", "[CLUSTER]", "[BACKUP]");
   *   DeleteBackupRequest request = DeleteBackupRequest.newBuilder()
   *     .setName(name.toString())
   *     .build();
   *   ApiFuture&lt;Void&gt; future = baseBigtableTableAdminClient.deleteBackupCallable().futureCall(request);
   *   // Do something
   *   future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<DeleteBackupRequest, Empty> deleteBackupCallable() {
    return stub.deleteBackupCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Create a new table by restoring from a completed backup. The new table must be in the same
   * instance as the instance containing the backup. The returned table [long-running
   * operation][google.longrunning.Operation] can be used to track the progress of the operation,
   * and to cancel it. The [metadata][google.longrunning.Operation.metadata] field type is
   * [RestoreTableMetadata][google.bigtable.admin.RestoreTableMetadata]. The
   * [response][google.longrunning.Operation.response] type is
   * [Table][google.bigtable.admin.v2.Table], if successful.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BaseBigtableTableAdminClient baseBigtableTableAdminClient = BaseBigtableTableAdminClient.create()) {
   *   RestoreTableRequest request = RestoreTableRequest.newBuilder().build();
   *   Table response = baseBigtableTableAdminClient.restoreTableAsync(request).get();
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Table, RestoreTableMetadata> restoreTableAsync(
      RestoreTableRequest request) {
    return restoreTableOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Create a new table by restoring from a completed backup. The new table must be in the same
   * instance as the instance containing the backup. The returned table [long-running
   * operation][google.longrunning.Operation] can be used to track the progress of the operation,
   * and to cancel it. The [metadata][google.longrunning.Operation.metadata] field type is
   * [RestoreTableMetadata][google.bigtable.admin.RestoreTableMetadata]. The
   * [response][google.longrunning.Operation.response] type is
   * [Table][google.bigtable.admin.v2.Table], if successful.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BaseBigtableTableAdminClient baseBigtableTableAdminClient = BaseBigtableTableAdminClient.create()) {
   *   RestoreTableRequest request = RestoreTableRequest.newBuilder().build();
   *   OperationFuture&lt;Table, RestoreTableMetadata&gt; future = baseBigtableTableAdminClient.restoreTableOperationCallable().futureCall(request);
   *   // Do something
   *   Table response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi("The surface for use by generated code is not stable yet and may change in the future.")
  public final OperationCallable<RestoreTableRequest, Table, RestoreTableMetadata>
      restoreTableOperationCallable() {
    return stub.restoreTableOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Create a new table by restoring from a completed backup. The new table must be in the same
   * instance as the instance containing the backup. The returned table [long-running
   * operation][google.longrunning.Operation] can be used to track the progress of the operation,
   * and to cancel it. The [metadata][google.longrunning.Operation.metadata] field type is
   * [RestoreTableMetadata][google.bigtable.admin.RestoreTableMetadata]. The
   * [response][google.longrunning.Operation.response] type is
   * [Table][google.bigtable.admin.v2.Table], if successful.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BaseBigtableTableAdminClient baseBigtableTableAdminClient = BaseBigtableTableAdminClient.create()) {
   *   RestoreTableRequest request = RestoreTableRequest.newBuilder().build();
   *   ApiFuture&lt;Operation&gt; future = baseBigtableTableAdminClient.restoreTableCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<RestoreTableRequest, Operation> restoreTableCallable() {
    return stub.restoreTableCallable();
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

  public static class ListBackupsPagedResponse
      extends AbstractPagedListResponse<
          ListBackupsRequest,
          ListBackupsResponse,
          Backup,
          ListBackupsPage,
          ListBackupsFixedSizeCollection> {

    public static ApiFuture<ListBackupsPagedResponse> createAsync(
        PageContext<ListBackupsRequest, ListBackupsResponse, Backup> context,
        ApiFuture<ListBackupsResponse> futureResponse) {
      ApiFuture<ListBackupsPage> futurePage =
          ListBackupsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListBackupsPage, ListBackupsPagedResponse>() {
            @Override
            public ListBackupsPagedResponse apply(ListBackupsPage input) {
              return new ListBackupsPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
    }

    private ListBackupsPagedResponse(ListBackupsPage page) {
      super(page, ListBackupsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListBackupsPage
      extends AbstractPage<ListBackupsRequest, ListBackupsResponse, Backup, ListBackupsPage> {

    private ListBackupsPage(
        PageContext<ListBackupsRequest, ListBackupsResponse, Backup> context,
        ListBackupsResponse response) {
      super(context, response);
    }

    private static ListBackupsPage createEmptyPage() {
      return new ListBackupsPage(null, null);
    }

    @Override
    protected ListBackupsPage createPage(
        PageContext<ListBackupsRequest, ListBackupsResponse, Backup> context,
        ListBackupsResponse response) {
      return new ListBackupsPage(context, response);
    }

    @Override
    public ApiFuture<ListBackupsPage> createPageAsync(
        PageContext<ListBackupsRequest, ListBackupsResponse, Backup> context,
        ApiFuture<ListBackupsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListBackupsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListBackupsRequest,
          ListBackupsResponse,
          Backup,
          ListBackupsPage,
          ListBackupsFixedSizeCollection> {

    private ListBackupsFixedSizeCollection(List<ListBackupsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListBackupsFixedSizeCollection createEmptyCollection() {
      return new ListBackupsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListBackupsFixedSizeCollection createCollection(
        List<ListBackupsPage> pages, int collectionSize) {
      return new ListBackupsFixedSizeCollection(pages, collectionSize);
    }
  }
}
