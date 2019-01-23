/*
 * Copyright 2019 Google LLC
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
package com.google.cloud.spanner.admin.database.v1;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.longrunning.OperationFuture;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.spanner.admin.database.v1.stub.DatabaseAdminStub;
import com.google.cloud.spanner.admin.database.v1.stub.DatabaseAdminStubSettings;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.longrunning.Operation;
import com.google.longrunning.OperationsClient;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import com.google.spanner.admin.database.v1.Backup;
import com.google.spanner.admin.database.v1.CreateBackupMetadata;
import com.google.spanner.admin.database.v1.CreateBackupRequest;
import com.google.spanner.admin.database.v1.CreateDatabaseMetadata;
import com.google.spanner.admin.database.v1.CreateDatabaseRequest;
import com.google.spanner.admin.database.v1.Database;
import com.google.spanner.admin.database.v1.DatabaseName;
import com.google.spanner.admin.database.v1.DeleteBackupRequest;
import com.google.spanner.admin.database.v1.DropDatabaseRequest;
import com.google.spanner.admin.database.v1.GetBackupRequest;
import com.google.spanner.admin.database.v1.GetDatabaseDdlRequest;
import com.google.spanner.admin.database.v1.GetDatabaseDdlResponse;
import com.google.spanner.admin.database.v1.GetDatabaseRequest;
import com.google.spanner.admin.database.v1.InstanceName;
import com.google.spanner.admin.database.v1.ListBackupOperationsRequest;
import com.google.spanner.admin.database.v1.ListBackupOperationsResponse;
import com.google.spanner.admin.database.v1.ListBackupsRequest;
import com.google.spanner.admin.database.v1.ListBackupsResponse;
import com.google.spanner.admin.database.v1.ListDatabaseOperationsRequest;
import com.google.spanner.admin.database.v1.ListDatabaseOperationsResponse;
import com.google.spanner.admin.database.v1.ListDatabasesRequest;
import com.google.spanner.admin.database.v1.ListDatabasesResponse;
import com.google.spanner.admin.database.v1.RestoreDatabaseMetadata;
import com.google.spanner.admin.database.v1.RestoreDatabaseRequest;
import com.google.spanner.admin.database.v1.UpdateBackupRequest;
import com.google.spanner.admin.database.v1.UpdateDatabaseDdlMetadata;
import com.google.spanner.admin.database.v1.UpdateDatabaseDdlRequest;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND SERVICE
/**
 * Service Description: Cloud Spanner Database Admin API
 *
 * <p>The Cloud Spanner Database Admin API can be used to create, drop, and list databases. It also
 * enables updating the schema of pre-existing databases.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>
 * <code>
 * try (DatabaseAdminClient databaseAdminClient = DatabaseAdminClient.create()) {
 *   DatabaseName name = DatabaseName.of("[PROJECT]", "[INSTANCE]", "[DATABASE]");
 *   Database response = databaseAdminClient.getDatabase(name);
 * }
 * </code>
 * </pre>
 *
 * <p>Note: close() needs to be called on the databaseAdminClient object to clean up resources such
 * as threads. In the example above, try-with-resources is used, which automatically calls close().
 *
 * <p>The surface of this class includes several types of Java methods for each of the API's
 * methods:
 *
 * <ol>
 *   <li>A "flattened" method. With this type of method, the fields of the request type have been
 *       converted into function parameters. It may be the case that not all fields are available as
 *       parameters, and not every API method will have a flattened method entry point.
 *   <li>A "request object" method. This type of method only takes one parameter, a request object,
 *       which must be constructed before the call. Not every API method will have a request object
 *       method.
 *   <li>A "callable" method. This type of method takes no parameters and returns an immutable API
 *       callable object, which can be used to initiate calls to the service.
 * </ol>
 *
 * <p>See the individual methods for example code.
 *
 * <p>Many parameters require resource names to be formatted in a particular way. To assist with
 * these names, this class includes a format method for each type of name, and additionally a parse
 * method to extract the individual identifiers contained within names that are returned.
 *
 * <p>This class can be customized by passing in a custom instance of DatabaseAdminSettings to
 * create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>
 * <code>
 * DatabaseAdminSettings databaseAdminSettings =
 *     DatabaseAdminSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * DatabaseAdminClient databaseAdminClient =
 *     DatabaseAdminClient.create(databaseAdminSettings);
 * </code>
 * </pre>
 *
 * To customize the endpoint:
 *
 * <pre>
 * <code>
 * DatabaseAdminSettings databaseAdminSettings =
 *     DatabaseAdminSettings.newBuilder().setEndpoint(myEndpoint).build();
 * DatabaseAdminClient databaseAdminClient =
 *     DatabaseAdminClient.create(databaseAdminSettings);
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class DatabaseAdminClient implements BackgroundResource {
  private final DatabaseAdminSettings settings;
  private final DatabaseAdminStub stub;
  private final OperationsClient operationsClient;

  /** Constructs an instance of DatabaseAdminClient with default settings. */
  public static final DatabaseAdminClient create() throws IOException {
    return create(DatabaseAdminSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of DatabaseAdminClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final DatabaseAdminClient create(DatabaseAdminSettings settings)
      throws IOException {
    return new DatabaseAdminClient(settings);
  }

  /**
   * Constructs an instance of DatabaseAdminClient, using the given stub for making calls. This is
   * for advanced usage - prefer to use DatabaseAdminSettings}.
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final DatabaseAdminClient create(DatabaseAdminStub stub) {
    return new DatabaseAdminClient(stub);
  }

  /**
   * Constructs an instance of DatabaseAdminClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected DatabaseAdminClient(DatabaseAdminSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((DatabaseAdminStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected DatabaseAdminClient(DatabaseAdminStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  public final DatabaseAdminSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public DatabaseAdminStub getStub() {
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
   * Lists Cloud Spanner databases.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DatabaseAdminClient databaseAdminClient = DatabaseAdminClient.create()) {
   *   InstanceName parent = InstanceName.of("[PROJECT]", "[INSTANCE]");
   *   for (Database element : databaseAdminClient.listDatabases(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param parent Required. The instance whose databases should be listed. Values are of the form
   *     `projects/&lt;project&gt;/instances/&lt;instance&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDatabasesPagedResponse listDatabases(InstanceName parent) {
    ListDatabasesRequest request =
        ListDatabasesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listDatabases(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists Cloud Spanner databases.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DatabaseAdminClient databaseAdminClient = DatabaseAdminClient.create()) {
   *   InstanceName parent = InstanceName.of("[PROJECT]", "[INSTANCE]");
   *   for (Database element : databaseAdminClient.listDatabases(parent.toString()).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param parent Required. The instance whose databases should be listed. Values are of the form
   *     `projects/&lt;project&gt;/instances/&lt;instance&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDatabasesPagedResponse listDatabases(String parent) {
    ListDatabasesRequest request = ListDatabasesRequest.newBuilder().setParent(parent).build();
    return listDatabases(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists Cloud Spanner databases.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DatabaseAdminClient databaseAdminClient = DatabaseAdminClient.create()) {
   *   InstanceName parent = InstanceName.of("[PROJECT]", "[INSTANCE]");
   *   ListDatabasesRequest request = ListDatabasesRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .build();
   *   for (Database element : databaseAdminClient.listDatabases(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDatabasesPagedResponse listDatabases(ListDatabasesRequest request) {
    return listDatabasesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists Cloud Spanner databases.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DatabaseAdminClient databaseAdminClient = DatabaseAdminClient.create()) {
   *   InstanceName parent = InstanceName.of("[PROJECT]", "[INSTANCE]");
   *   ListDatabasesRequest request = ListDatabasesRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .build();
   *   ApiFuture&lt;ListDatabasesPagedResponse&gt; future = databaseAdminClient.listDatabasesPagedCallable().futureCall(request);
   *   // Do something
   *   for (Database element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  public final UnaryCallable<ListDatabasesRequest, ListDatabasesPagedResponse>
      listDatabasesPagedCallable() {
    return stub.listDatabasesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists Cloud Spanner databases.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DatabaseAdminClient databaseAdminClient = DatabaseAdminClient.create()) {
   *   InstanceName parent = InstanceName.of("[PROJECT]", "[INSTANCE]");
   *   ListDatabasesRequest request = ListDatabasesRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .build();
   *   while (true) {
   *     ListDatabasesResponse response = databaseAdminClient.listDatabasesCallable().call(request);
   *     for (Database element : response.getDatabasesList()) {
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
  public final UnaryCallable<ListDatabasesRequest, ListDatabasesResponse> listDatabasesCallable() {
    return stub.listDatabasesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a new Cloud Spanner database and starts to prepare it for serving. The returned
   * [long-running operation][google.longrunning.Operation] will have a name of the format
   * `&lt;database_name&gt;/operations/&lt;operation_id&gt;` and can be used to track preparation of
   * the database. The [metadata][google.longrunning.Operation.metadata] field type is
   * [CreateDatabaseMetadata][google.spanner.admin.database.v1.CreateDatabaseMetadata]. The
   * [response][google.longrunning.Operation.response] field type is
   * [Database][google.spanner.admin.database.v1.Database], if successful.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DatabaseAdminClient databaseAdminClient = DatabaseAdminClient.create()) {
   *   InstanceName parent = InstanceName.of("[PROJECT]", "[INSTANCE]");
   *   String createStatement = "";
   *   Database response = databaseAdminClient.createDatabaseAsync(parent, createStatement).get();
   * }
   * </code></pre>
   *
   * @param parent Required. The name of the instance that will serve the new database. Values are
   *     of the form `projects/&lt;project&gt;/instances/&lt;instance&gt;`.
   * @param createStatement Required. A `CREATE DATABASE` statement, which specifies the ID of the
   *     new database. The database ID must conform to the regular expression
   *     `[a-z][a-z0-9_\-]&#42;[a-z0-9]` and be between 2 and 30 characters in length. If the
   *     database ID is a reserved word or if it contains a hyphen, the database ID must be enclosed
   *     in backticks (`` ` ``).
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Database, CreateDatabaseMetadata> createDatabaseAsync(
      InstanceName parent, String createStatement) {

    CreateDatabaseRequest request =
        CreateDatabaseRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setCreateStatement(createStatement)
            .build();
    return createDatabaseAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a new Cloud Spanner database and starts to prepare it for serving. The returned
   * [long-running operation][google.longrunning.Operation] will have a name of the format
   * `&lt;database_name&gt;/operations/&lt;operation_id&gt;` and can be used to track preparation of
   * the database. The [metadata][google.longrunning.Operation.metadata] field type is
   * [CreateDatabaseMetadata][google.spanner.admin.database.v1.CreateDatabaseMetadata]. The
   * [response][google.longrunning.Operation.response] field type is
   * [Database][google.spanner.admin.database.v1.Database], if successful.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DatabaseAdminClient databaseAdminClient = DatabaseAdminClient.create()) {
   *   InstanceName parent = InstanceName.of("[PROJECT]", "[INSTANCE]");
   *   String createStatement = "";
   *   Database response = databaseAdminClient.createDatabaseAsync(parent.toString(), createStatement).get();
   * }
   * </code></pre>
   *
   * @param parent Required. The name of the instance that will serve the new database. Values are
   *     of the form `projects/&lt;project&gt;/instances/&lt;instance&gt;`.
   * @param createStatement Required. A `CREATE DATABASE` statement, which specifies the ID of the
   *     new database. The database ID must conform to the regular expression
   *     `[a-z][a-z0-9_\-]&#42;[a-z0-9]` and be between 2 and 30 characters in length. If the
   *     database ID is a reserved word or if it contains a hyphen, the database ID must be enclosed
   *     in backticks (`` ` ``).
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Database, CreateDatabaseMetadata> createDatabaseAsync(
      String parent, String createStatement) {

    CreateDatabaseRequest request =
        CreateDatabaseRequest.newBuilder()
            .setParent(parent)
            .setCreateStatement(createStatement)
            .build();
    return createDatabaseAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a new Cloud Spanner database and starts to prepare it for serving. The returned
   * [long-running operation][google.longrunning.Operation] will have a name of the format
   * `&lt;database_name&gt;/operations/&lt;operation_id&gt;` and can be used to track preparation of
   * the database. The [metadata][google.longrunning.Operation.metadata] field type is
   * [CreateDatabaseMetadata][google.spanner.admin.database.v1.CreateDatabaseMetadata]. The
   * [response][google.longrunning.Operation.response] field type is
   * [Database][google.spanner.admin.database.v1.Database], if successful.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DatabaseAdminClient databaseAdminClient = DatabaseAdminClient.create()) {
   *   InstanceName parent = InstanceName.of("[PROJECT]", "[INSTANCE]");
   *   String createStatement = "";
   *   CreateDatabaseRequest request = CreateDatabaseRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .setCreateStatement(createStatement)
   *     .build();
   *   Database response = databaseAdminClient.createDatabaseAsync(request).get();
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Database, CreateDatabaseMetadata> createDatabaseAsync(
      CreateDatabaseRequest request) {
    return createDatabaseOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a new Cloud Spanner database and starts to prepare it for serving. The returned
   * [long-running operation][google.longrunning.Operation] will have a name of the format
   * `&lt;database_name&gt;/operations/&lt;operation_id&gt;` and can be used to track preparation of
   * the database. The [metadata][google.longrunning.Operation.metadata] field type is
   * [CreateDatabaseMetadata][google.spanner.admin.database.v1.CreateDatabaseMetadata]. The
   * [response][google.longrunning.Operation.response] field type is
   * [Database][google.spanner.admin.database.v1.Database], if successful.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DatabaseAdminClient databaseAdminClient = DatabaseAdminClient.create()) {
   *   InstanceName parent = InstanceName.of("[PROJECT]", "[INSTANCE]");
   *   String createStatement = "";
   *   CreateDatabaseRequest request = CreateDatabaseRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .setCreateStatement(createStatement)
   *     .build();
   *   OperationFuture&lt;Operation&gt; future = databaseAdminClient.createDatabaseOperationCallable().futureCall(request);
   *   // Do something
   *   Database response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi("The surface for use by generated code is not stable yet and may change in the future.")
  public final OperationCallable<CreateDatabaseRequest, Database, CreateDatabaseMetadata>
      createDatabaseOperationCallable() {
    return stub.createDatabaseOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a new Cloud Spanner database and starts to prepare it for serving. The returned
   * [long-running operation][google.longrunning.Operation] will have a name of the format
   * `&lt;database_name&gt;/operations/&lt;operation_id&gt;` and can be used to track preparation of
   * the database. The [metadata][google.longrunning.Operation.metadata] field type is
   * [CreateDatabaseMetadata][google.spanner.admin.database.v1.CreateDatabaseMetadata]. The
   * [response][google.longrunning.Operation.response] field type is
   * [Database][google.spanner.admin.database.v1.Database], if successful.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DatabaseAdminClient databaseAdminClient = DatabaseAdminClient.create()) {
   *   InstanceName parent = InstanceName.of("[PROJECT]", "[INSTANCE]");
   *   String createStatement = "";
   *   CreateDatabaseRequest request = CreateDatabaseRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .setCreateStatement(createStatement)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = databaseAdminClient.createDatabaseCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<CreateDatabaseRequest, Operation> createDatabaseCallable() {
    return stub.createDatabaseCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets the state of a Cloud Spanner database.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DatabaseAdminClient databaseAdminClient = DatabaseAdminClient.create()) {
   *   DatabaseName name = DatabaseName.of("[PROJECT]", "[INSTANCE]", "[DATABASE]");
   *   Database response = databaseAdminClient.getDatabase(name);
   * }
   * </code></pre>
   *
   * @param name Required. The name of the requested database. Values are of the form
   *     `projects/&lt;project&gt;/instances/&lt;instance&gt;/databases/&lt;database&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Database getDatabase(DatabaseName name) {

    GetDatabaseRequest request =
        GetDatabaseRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getDatabase(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets the state of a Cloud Spanner database.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DatabaseAdminClient databaseAdminClient = DatabaseAdminClient.create()) {
   *   DatabaseName name = DatabaseName.of("[PROJECT]", "[INSTANCE]", "[DATABASE]");
   *   Database response = databaseAdminClient.getDatabase(name.toString());
   * }
   * </code></pre>
   *
   * @param name Required. The name of the requested database. Values are of the form
   *     `projects/&lt;project&gt;/instances/&lt;instance&gt;/databases/&lt;database&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Database getDatabase(String name) {

    GetDatabaseRequest request = GetDatabaseRequest.newBuilder().setName(name).build();
    return getDatabase(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets the state of a Cloud Spanner database.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DatabaseAdminClient databaseAdminClient = DatabaseAdminClient.create()) {
   *   DatabaseName name = DatabaseName.of("[PROJECT]", "[INSTANCE]", "[DATABASE]");
   *   GetDatabaseRequest request = GetDatabaseRequest.newBuilder()
   *     .setName(name.toString())
   *     .build();
   *   Database response = databaseAdminClient.getDatabase(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Database getDatabase(GetDatabaseRequest request) {
    return getDatabaseCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets the state of a Cloud Spanner database.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DatabaseAdminClient databaseAdminClient = DatabaseAdminClient.create()) {
   *   DatabaseName name = DatabaseName.of("[PROJECT]", "[INSTANCE]", "[DATABASE]");
   *   GetDatabaseRequest request = GetDatabaseRequest.newBuilder()
   *     .setName(name.toString())
   *     .build();
   *   ApiFuture&lt;Database&gt; future = databaseAdminClient.getDatabaseCallable().futureCall(request);
   *   // Do something
   *   Database response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<GetDatabaseRequest, Database> getDatabaseCallable() {
    return stub.getDatabaseCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates the schema of a Cloud Spanner database by creating/altering/dropping tables, columns,
   * indexes, etc. The returned [long-running operation][google.longrunning.Operation] will have a
   * name of the format `&lt;database_name&gt;/operations/&lt;operation_id&gt;` and can be used to
   * track execution of the schema change(s). The [metadata][google.longrunning.Operation.metadata]
   * field type is
   * [UpdateDatabaseDdlMetadata][google.spanner.admin.database.v1.UpdateDatabaseDdlMetadata]. The
   * operation has no response.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DatabaseAdminClient databaseAdminClient = DatabaseAdminClient.create()) {
   *   DatabaseName database = DatabaseName.of("[PROJECT]", "[INSTANCE]", "[DATABASE]");
   *   List&lt;String&gt; statements = new ArrayList&lt;&gt;();
   *   Empty response = databaseAdminClient.updateDatabaseDdlAsync(database, statements).get();
   * }
   * </code></pre>
   *
   * @param database Required. The database to update.
   * @param statements DDL statements to be applied to the database.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Empty, UpdateDatabaseDdlMetadata> updateDatabaseDdlAsync(
      DatabaseName database, List<String> statements) {

    UpdateDatabaseDdlRequest request =
        UpdateDatabaseDdlRequest.newBuilder()
            .setDatabase(database == null ? null : database.toString())
            .addAllStatements(statements)
            .build();
    return updateDatabaseDdlAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates the schema of a Cloud Spanner database by creating/altering/dropping tables, columns,
   * indexes, etc. The returned [long-running operation][google.longrunning.Operation] will have a
   * name of the format `&lt;database_name&gt;/operations/&lt;operation_id&gt;` and can be used to
   * track execution of the schema change(s). The [metadata][google.longrunning.Operation.metadata]
   * field type is
   * [UpdateDatabaseDdlMetadata][google.spanner.admin.database.v1.UpdateDatabaseDdlMetadata]. The
   * operation has no response.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DatabaseAdminClient databaseAdminClient = DatabaseAdminClient.create()) {
   *   DatabaseName database = DatabaseName.of("[PROJECT]", "[INSTANCE]", "[DATABASE]");
   *   List&lt;String&gt; statements = new ArrayList&lt;&gt;();
   *   Empty response = databaseAdminClient.updateDatabaseDdlAsync(database.toString(), statements).get();
   * }
   * </code></pre>
   *
   * @param database Required. The database to update.
   * @param statements DDL statements to be applied to the database.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Empty, UpdateDatabaseDdlMetadata> updateDatabaseDdlAsync(
      String database, List<String> statements) {

    UpdateDatabaseDdlRequest request =
        UpdateDatabaseDdlRequest.newBuilder()
            .setDatabase(database)
            .addAllStatements(statements)
            .build();
    return updateDatabaseDdlAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates the schema of a Cloud Spanner database by creating/altering/dropping tables, columns,
   * indexes, etc. The returned [long-running operation][google.longrunning.Operation] will have a
   * name of the format `&lt;database_name&gt;/operations/&lt;operation_id&gt;` and can be used to
   * track execution of the schema change(s). The [metadata][google.longrunning.Operation.metadata]
   * field type is
   * [UpdateDatabaseDdlMetadata][google.spanner.admin.database.v1.UpdateDatabaseDdlMetadata]. The
   * operation has no response.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DatabaseAdminClient databaseAdminClient = DatabaseAdminClient.create()) {
   *   DatabaseName database = DatabaseName.of("[PROJECT]", "[INSTANCE]", "[DATABASE]");
   *   List&lt;String&gt; statements = new ArrayList&lt;&gt;();
   *   UpdateDatabaseDdlRequest request = UpdateDatabaseDdlRequest.newBuilder()
   *     .setDatabase(database.toString())
   *     .addAllStatements(statements)
   *     .build();
   *   Empty response = databaseAdminClient.updateDatabaseDdlAsync(request).get();
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Empty, UpdateDatabaseDdlMetadata> updateDatabaseDdlAsync(
      UpdateDatabaseDdlRequest request) {
    return updateDatabaseDdlOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates the schema of a Cloud Spanner database by creating/altering/dropping tables, columns,
   * indexes, etc. The returned [long-running operation][google.longrunning.Operation] will have a
   * name of the format `&lt;database_name&gt;/operations/&lt;operation_id&gt;` and can be used to
   * track execution of the schema change(s). The [metadata][google.longrunning.Operation.metadata]
   * field type is
   * [UpdateDatabaseDdlMetadata][google.spanner.admin.database.v1.UpdateDatabaseDdlMetadata]. The
   * operation has no response.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DatabaseAdminClient databaseAdminClient = DatabaseAdminClient.create()) {
   *   DatabaseName database = DatabaseName.of("[PROJECT]", "[INSTANCE]", "[DATABASE]");
   *   List&lt;String&gt; statements = new ArrayList&lt;&gt;();
   *   UpdateDatabaseDdlRequest request = UpdateDatabaseDdlRequest.newBuilder()
   *     .setDatabase(database.toString())
   *     .addAllStatements(statements)
   *     .build();
   *   OperationFuture&lt;Operation&gt; future = databaseAdminClient.updateDatabaseDdlOperationCallable().futureCall(request);
   *   // Do something
   *   Empty response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi("The surface for use by generated code is not stable yet and may change in the future.")
  public final OperationCallable<UpdateDatabaseDdlRequest, Empty, UpdateDatabaseDdlMetadata>
      updateDatabaseDdlOperationCallable() {
    return stub.updateDatabaseDdlOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates the schema of a Cloud Spanner database by creating/altering/dropping tables, columns,
   * indexes, etc. The returned [long-running operation][google.longrunning.Operation] will have a
   * name of the format `&lt;database_name&gt;/operations/&lt;operation_id&gt;` and can be used to
   * track execution of the schema change(s). The [metadata][google.longrunning.Operation.metadata]
   * field type is
   * [UpdateDatabaseDdlMetadata][google.spanner.admin.database.v1.UpdateDatabaseDdlMetadata]. The
   * operation has no response.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DatabaseAdminClient databaseAdminClient = DatabaseAdminClient.create()) {
   *   DatabaseName database = DatabaseName.of("[PROJECT]", "[INSTANCE]", "[DATABASE]");
   *   List&lt;String&gt; statements = new ArrayList&lt;&gt;();
   *   UpdateDatabaseDdlRequest request = UpdateDatabaseDdlRequest.newBuilder()
   *     .setDatabase(database.toString())
   *     .addAllStatements(statements)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = databaseAdminClient.updateDatabaseDdlCallable().futureCall(request);
   *   // Do something
   *   future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<UpdateDatabaseDdlRequest, Operation> updateDatabaseDdlCallable() {
    return stub.updateDatabaseDdlCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Drops (aka deletes) a Cloud Spanner database.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DatabaseAdminClient databaseAdminClient = DatabaseAdminClient.create()) {
   *   DatabaseName database = DatabaseName.of("[PROJECT]", "[INSTANCE]", "[DATABASE]");
   *   databaseAdminClient.dropDatabase(database);
   * }
   * </code></pre>
   *
   * @param database Required. The database to be dropped.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void dropDatabase(DatabaseName database) {

    DropDatabaseRequest request =
        DropDatabaseRequest.newBuilder()
            .setDatabase(database == null ? null : database.toString())
            .build();
    dropDatabase(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Drops (aka deletes) a Cloud Spanner database.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DatabaseAdminClient databaseAdminClient = DatabaseAdminClient.create()) {
   *   DatabaseName database = DatabaseName.of("[PROJECT]", "[INSTANCE]", "[DATABASE]");
   *   databaseAdminClient.dropDatabase(database.toString());
   * }
   * </code></pre>
   *
   * @param database Required. The database to be dropped.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void dropDatabase(String database) {

    DropDatabaseRequest request = DropDatabaseRequest.newBuilder().setDatabase(database).build();
    dropDatabase(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Drops (aka deletes) a Cloud Spanner database.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DatabaseAdminClient databaseAdminClient = DatabaseAdminClient.create()) {
   *   DatabaseName database = DatabaseName.of("[PROJECT]", "[INSTANCE]", "[DATABASE]");
   *   DropDatabaseRequest request = DropDatabaseRequest.newBuilder()
   *     .setDatabase(database.toString())
   *     .build();
   *   databaseAdminClient.dropDatabase(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void dropDatabase(DropDatabaseRequest request) {
    dropDatabaseCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Drops (aka deletes) a Cloud Spanner database.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DatabaseAdminClient databaseAdminClient = DatabaseAdminClient.create()) {
   *   DatabaseName database = DatabaseName.of("[PROJECT]", "[INSTANCE]", "[DATABASE]");
   *   DropDatabaseRequest request = DropDatabaseRequest.newBuilder()
   *     .setDatabase(database.toString())
   *     .build();
   *   ApiFuture&lt;Void&gt; future = databaseAdminClient.dropDatabaseCallable().futureCall(request);
   *   // Do something
   *   future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<DropDatabaseRequest, Empty> dropDatabaseCallable() {
    return stub.dropDatabaseCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the schema of a Cloud Spanner database as a list of formatted DDL statements. This
   * method does not show pending schema updates, those may be queried using the
   * [Operations][google.longrunning.Operations] API.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DatabaseAdminClient databaseAdminClient = DatabaseAdminClient.create()) {
   *   DatabaseName database = DatabaseName.of("[PROJECT]", "[INSTANCE]", "[DATABASE]");
   *   GetDatabaseDdlResponse response = databaseAdminClient.getDatabaseDdl(database);
   * }
   * </code></pre>
   *
   * @param database Required. The database whose schema we wish to get.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GetDatabaseDdlResponse getDatabaseDdl(DatabaseName database) {

    GetDatabaseDdlRequest request =
        GetDatabaseDdlRequest.newBuilder()
            .setDatabase(database == null ? null : database.toString())
            .build();
    return getDatabaseDdl(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the schema of a Cloud Spanner database as a list of formatted DDL statements. This
   * method does not show pending schema updates, those may be queried using the
   * [Operations][google.longrunning.Operations] API.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DatabaseAdminClient databaseAdminClient = DatabaseAdminClient.create()) {
   *   DatabaseName database = DatabaseName.of("[PROJECT]", "[INSTANCE]", "[DATABASE]");
   *   GetDatabaseDdlResponse response = databaseAdminClient.getDatabaseDdl(database.toString());
   * }
   * </code></pre>
   *
   * @param database Required. The database whose schema we wish to get.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GetDatabaseDdlResponse getDatabaseDdl(String database) {

    GetDatabaseDdlRequest request =
        GetDatabaseDdlRequest.newBuilder().setDatabase(database).build();
    return getDatabaseDdl(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the schema of a Cloud Spanner database as a list of formatted DDL statements. This
   * method does not show pending schema updates, those may be queried using the
   * [Operations][google.longrunning.Operations] API.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DatabaseAdminClient databaseAdminClient = DatabaseAdminClient.create()) {
   *   DatabaseName database = DatabaseName.of("[PROJECT]", "[INSTANCE]", "[DATABASE]");
   *   GetDatabaseDdlRequest request = GetDatabaseDdlRequest.newBuilder()
   *     .setDatabase(database.toString())
   *     .build();
   *   GetDatabaseDdlResponse response = databaseAdminClient.getDatabaseDdl(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GetDatabaseDdlResponse getDatabaseDdl(GetDatabaseDdlRequest request) {
    return getDatabaseDdlCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the schema of a Cloud Spanner database as a list of formatted DDL statements. This
   * method does not show pending schema updates, those may be queried using the
   * [Operations][google.longrunning.Operations] API.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DatabaseAdminClient databaseAdminClient = DatabaseAdminClient.create()) {
   *   DatabaseName database = DatabaseName.of("[PROJECT]", "[INSTANCE]", "[DATABASE]");
   *   GetDatabaseDdlRequest request = GetDatabaseDdlRequest.newBuilder()
   *     .setDatabase(database.toString())
   *     .build();
   *   ApiFuture&lt;GetDatabaseDdlResponse&gt; future = databaseAdminClient.getDatabaseDdlCallable().futureCall(request);
   *   // Do something
   *   GetDatabaseDdlResponse response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<GetDatabaseDdlRequest, GetDatabaseDdlResponse>
      getDatabaseDdlCallable() {
    return stub.getDatabaseDdlCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets the access control policy on a database resource. Replaces any existing policy.
   *
   * <p>Authorization requires `spanner.databases.setIamPolicy` permission on
   * [resource][google.iam.v1.SetIamPolicyRequest.resource].
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DatabaseAdminClient databaseAdminClient = DatabaseAdminClient.create()) {
   *   String formattedResource = DatabaseName.format("[PROJECT]", "[INSTANCE]", "[DATABASE]");
   *   Policy policy = Policy.newBuilder().build();
   *   Policy response = databaseAdminClient.setIamPolicy(formattedResource, policy);
   * }
   * </code></pre>
   *
   * @param resource REQUIRED: The resource for which the policy is being specified. `resource` is
   *     usually specified as a path. For example, a Project resource is specified as
   *     `projects/{project}`.
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
   * Sets the access control policy on a database resource. Replaces any existing policy.
   *
   * <p>Authorization requires `spanner.databases.setIamPolicy` permission on
   * [resource][google.iam.v1.SetIamPolicyRequest.resource].
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DatabaseAdminClient databaseAdminClient = DatabaseAdminClient.create()) {
   *   String formattedResource = DatabaseName.format("[PROJECT]", "[INSTANCE]", "[DATABASE]");
   *   Policy policy = Policy.newBuilder().build();
   *   SetIamPolicyRequest request = SetIamPolicyRequest.newBuilder()
   *     .setResource(formattedResource)
   *     .setPolicy(policy)
   *     .build();
   *   Policy response = databaseAdminClient.setIamPolicy(request);
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
   * Sets the access control policy on a database resource. Replaces any existing policy.
   *
   * <p>Authorization requires `spanner.databases.setIamPolicy` permission on
   * [resource][google.iam.v1.SetIamPolicyRequest.resource].
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DatabaseAdminClient databaseAdminClient = DatabaseAdminClient.create()) {
   *   String formattedResource = DatabaseName.format("[PROJECT]", "[INSTANCE]", "[DATABASE]");
   *   Policy policy = Policy.newBuilder().build();
   *   SetIamPolicyRequest request = SetIamPolicyRequest.newBuilder()
   *     .setResource(formattedResource)
   *     .setPolicy(policy)
   *     .build();
   *   ApiFuture&lt;Policy&gt; future = databaseAdminClient.setIamPolicyCallable().futureCall(request);
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
   * Gets the access control policy for a database resource. Returns an empty policy if a database
   * exists but does not have a policy set.
   *
   * <p>Authorization requires `spanner.databases.getIamPolicy` permission on
   * [resource][google.iam.v1.GetIamPolicyRequest.resource].
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DatabaseAdminClient databaseAdminClient = DatabaseAdminClient.create()) {
   *   String formattedResource = DatabaseName.format("[PROJECT]", "[INSTANCE]", "[DATABASE]");
   *   Policy response = databaseAdminClient.getIamPolicy(formattedResource);
   * }
   * </code></pre>
   *
   * @param resource REQUIRED: The resource for which the policy is being requested. `resource` is
   *     usually specified as a path. For example, a Project resource is specified as
   *     `projects/{project}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy getIamPolicy(String resource) {

    GetIamPolicyRequest request = GetIamPolicyRequest.newBuilder().setResource(resource).build();
    return getIamPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets the access control policy for a database resource. Returns an empty policy if a database
   * exists but does not have a policy set.
   *
   * <p>Authorization requires `spanner.databases.getIamPolicy` permission on
   * [resource][google.iam.v1.GetIamPolicyRequest.resource].
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DatabaseAdminClient databaseAdminClient = DatabaseAdminClient.create()) {
   *   String formattedResource = DatabaseName.format("[PROJECT]", "[INSTANCE]", "[DATABASE]");
   *   GetIamPolicyRequest request = GetIamPolicyRequest.newBuilder()
   *     .setResource(formattedResource)
   *     .build();
   *   Policy response = databaseAdminClient.getIamPolicy(request);
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
   * Gets the access control policy for a database resource. Returns an empty policy if a database
   * exists but does not have a policy set.
   *
   * <p>Authorization requires `spanner.databases.getIamPolicy` permission on
   * [resource][google.iam.v1.GetIamPolicyRequest.resource].
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DatabaseAdminClient databaseAdminClient = DatabaseAdminClient.create()) {
   *   String formattedResource = DatabaseName.format("[PROJECT]", "[INSTANCE]", "[DATABASE]");
   *   GetIamPolicyRequest request = GetIamPolicyRequest.newBuilder()
   *     .setResource(formattedResource)
   *     .build();
   *   ApiFuture&lt;Policy&gt; future = databaseAdminClient.getIamPolicyCallable().futureCall(request);
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
   * Returns permissions that the caller has on the specified database resource.
   *
   * <p>Attempting this RPC on a non-existent Cloud Spanner database will result in a NOT_FOUND
   * error if the user has `spanner.databases.list` permission on the containing Cloud Spanner
   * instance. Otherwise returns an empty set of permissions.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DatabaseAdminClient databaseAdminClient = DatabaseAdminClient.create()) {
   *   String formattedResource = DatabaseName.format("[PROJECT]", "[INSTANCE]", "[DATABASE]");
   *   List&lt;String&gt; permissions = new ArrayList&lt;&gt;();
   *   TestIamPermissionsResponse response = databaseAdminClient.testIamPermissions(formattedResource, permissions);
   * }
   * </code></pre>
   *
   * @param resource REQUIRED: The resource for which the policy detail is being requested.
   *     `resource` is usually specified as a path. For example, a Project resource is specified as
   *     `projects/{project}`.
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
   * Returns permissions that the caller has on the specified database resource.
   *
   * <p>Attempting this RPC on a non-existent Cloud Spanner database will result in a NOT_FOUND
   * error if the user has `spanner.databases.list` permission on the containing Cloud Spanner
   * instance. Otherwise returns an empty set of permissions.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DatabaseAdminClient databaseAdminClient = DatabaseAdminClient.create()) {
   *   String formattedResource = DatabaseName.format("[PROJECT]", "[INSTANCE]", "[DATABASE]");
   *   List&lt;String&gt; permissions = new ArrayList&lt;&gt;();
   *   TestIamPermissionsRequest request = TestIamPermissionsRequest.newBuilder()
   *     .setResource(formattedResource)
   *     .addAllPermissions(permissions)
   *     .build();
   *   TestIamPermissionsResponse response = databaseAdminClient.testIamPermissions(request);
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
   * Returns permissions that the caller has on the specified database resource.
   *
   * <p>Attempting this RPC on a non-existent Cloud Spanner database will result in a NOT_FOUND
   * error if the user has `spanner.databases.list` permission on the containing Cloud Spanner
   * instance. Otherwise returns an empty set of permissions.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DatabaseAdminClient databaseAdminClient = DatabaseAdminClient.create()) {
   *   String formattedResource = DatabaseName.format("[PROJECT]", "[INSTANCE]", "[DATABASE]");
   *   List&lt;String&gt; permissions = new ArrayList&lt;&gt;();
   *   TestIamPermissionsRequest request = TestIamPermissionsRequest.newBuilder()
   *     .setResource(formattedResource)
   *     .addAllPermissions(permissions)
   *     .build();
   *   ApiFuture&lt;TestIamPermissionsResponse&gt; future = databaseAdminClient.testIamPermissionsCallable().futureCall(request);
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
   * Sample code:
   *
   * <pre><code>
   * try (DatabaseAdminClient databaseAdminClient = DatabaseAdminClient.create()) {
   *   String formattedParent = InstanceName.format("[PROJECT]", "[INSTANCE]");
   *   String backupId = "";
   *   Backup backup = Backup.newBuilder().build();
   *   Empty response = databaseAdminClient.createBackupAsync(formattedParent, backupId, backup).get();
   * }
   * </code></pre>
   *
   * @param parent Required. The name of the instance in which the backup will be created. This must
   *     be the same instance that contains the database the backup will be created from. The backup
   *     will be stored in the location(s) specified in the instance configuration of this instance.
   *     Values are of the form `projects/&lt;project&gt;/instances/&lt;instance&gt;`.
   * @param backupId Required. The id of the backup to be created. The `backup_id` appended to
   *     `parent` forms the full backup name of the form
   *     `projects/&lt;project&gt;/instances/&lt;instance&gt;/backups/&lt;backup_id&gt;`.
   * @param backup Required. The backup to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Empty, CreateBackupMetadata> createBackupAsync(
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
   * Sample code:
   *
   * <pre><code>
   * try (DatabaseAdminClient databaseAdminClient = DatabaseAdminClient.create()) {
   *   String formattedParent = InstanceName.format("[PROJECT]", "[INSTANCE]");
   *   String backupId = "";
   *   Backup backup = Backup.newBuilder().build();
   *   CreateBackupRequest request = CreateBackupRequest.newBuilder()
   *     .setParent(formattedParent)
   *     .setBackupId(backupId)
   *     .setBackup(backup)
   *     .build();
   *   Empty response = databaseAdminClient.createBackupAsync(request).get();
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Empty, CreateBackupMetadata> createBackupAsync(
      CreateBackupRequest request) {
    return createBackupOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sample code:
   *
   * <pre><code>
   * try (DatabaseAdminClient databaseAdminClient = DatabaseAdminClient.create()) {
   *   String formattedParent = InstanceName.format("[PROJECT]", "[INSTANCE]");
   *   String backupId = "";
   *   Backup backup = Backup.newBuilder().build();
   *   CreateBackupRequest request = CreateBackupRequest.newBuilder()
   *     .setParent(formattedParent)
   *     .setBackupId(backupId)
   *     .setBackup(backup)
   *     .build();
   *   OperationFuture&lt;Operation&gt; future = databaseAdminClient.createBackupOperationCallable().futureCall(request);
   *   // Do something
   *   Empty response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi("The surface for use by generated code is not stable yet and may change in the future.")
  public final OperationCallable<CreateBackupRequest, Empty, CreateBackupMetadata>
      createBackupOperationCallable() {
    return stub.createBackupOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sample code:
   *
   * <pre><code>
   * try (DatabaseAdminClient databaseAdminClient = DatabaseAdminClient.create()) {
   *   String formattedParent = InstanceName.format("[PROJECT]", "[INSTANCE]");
   *   String backupId = "";
   *   Backup backup = Backup.newBuilder().build();
   *   CreateBackupRequest request = CreateBackupRequest.newBuilder()
   *     .setParent(formattedParent)
   *     .setBackupId(backupId)
   *     .setBackup(backup)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = databaseAdminClient.createBackupCallable().futureCall(request);
   *   // Do something
   *   future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<CreateBackupRequest, Operation> createBackupCallable() {
    return stub.createBackupCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sample code:
   *
   * <pre><code>
   * try (DatabaseAdminClient databaseAdminClient = DatabaseAdminClient.create()) {
   *   String formattedName = BackupName.format("[PROJECT]", "[INSTANCE]", "[BACKUP]");
   *   Backup response = databaseAdminClient.getBackup(formattedName);
   * }
   * </code></pre>
   *
   * @param name Required. Name of the backup. Values are of the form
   *     `projects/&lt;project&gt;/instances/&lt;instance&gt;/backups/&lt;backup&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Backup getBackup(String name) {

    GetBackupRequest request = GetBackupRequest.newBuilder().setName(name).build();
    return getBackup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sample code:
   *
   * <pre><code>
   * try (DatabaseAdminClient databaseAdminClient = DatabaseAdminClient.create()) {
   *   String formattedName = BackupName.format("[PROJECT]", "[INSTANCE]", "[BACKUP]");
   *   GetBackupRequest request = GetBackupRequest.newBuilder()
   *     .setName(formattedName)
   *     .build();
   *   Backup response = databaseAdminClient.getBackup(request);
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
   * Sample code:
   *
   * <pre><code>
   * try (DatabaseAdminClient databaseAdminClient = DatabaseAdminClient.create()) {
   *   String formattedName = BackupName.format("[PROJECT]", "[INSTANCE]", "[BACKUP]");
   *   GetBackupRequest request = GetBackupRequest.newBuilder()
   *     .setName(formattedName)
   *     .build();
   *   ApiFuture&lt;Backup&gt; future = databaseAdminClient.getBackupCallable().futureCall(request);
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
   * Sample code:
   *
   * <pre><code>
   * try (DatabaseAdminClient databaseAdminClient = DatabaseAdminClient.create()) {
   *   Backup backup = Backup.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Backup response = databaseAdminClient.updateBackup(backup, updateMask);
   * }
   * </code></pre>
   *
   * @param backup Required. The backup to update. `backup.name`, and the fields to be updated as
   *     specified by `update_mask` are required. Other fields are ignored. Update is only supported
   *     for the following fields: &#42; `backup.expire_time`.
   * @param updateMask Required. A mask specifying which fields (e.g. `backup.expire_time`) in the
   *     Backup resource should be updated. This mask is relative to the Backup resource, not to the
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
   * Sample code:
   *
   * <pre><code>
   * try (DatabaseAdminClient databaseAdminClient = DatabaseAdminClient.create()) {
   *   Backup backup = Backup.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   UpdateBackupRequest request = UpdateBackupRequest.newBuilder()
   *     .setBackup(backup)
   *     .setUpdateMask(updateMask)
   *     .build();
   *   Backup response = databaseAdminClient.updateBackup(request);
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
   * Sample code:
   *
   * <pre><code>
   * try (DatabaseAdminClient databaseAdminClient = DatabaseAdminClient.create()) {
   *   Backup backup = Backup.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   UpdateBackupRequest request = UpdateBackupRequest.newBuilder()
   *     .setBackup(backup)
   *     .setUpdateMask(updateMask)
   *     .build();
   *   ApiFuture&lt;Backup&gt; future = databaseAdminClient.updateBackupCallable().futureCall(request);
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
   * Sample code:
   *
   * <pre><code>
   * try (DatabaseAdminClient databaseAdminClient = DatabaseAdminClient.create()) {
   *   String formattedName = BackupName.format("[PROJECT]", "[INSTANCE]", "[BACKUP]");
   *   databaseAdminClient.deleteBackup(formattedName);
   * }
   * </code></pre>
   *
   * @param name Required. Name of the backup to delete. Values are of the form
   *     `projects/&lt;project&gt;/instances/&lt;instance&gt;/backups/&lt;backup&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteBackup(String name) {

    DeleteBackupRequest request = DeleteBackupRequest.newBuilder().setName(name).build();
    deleteBackup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sample code:
   *
   * <pre><code>
   * try (DatabaseAdminClient databaseAdminClient = DatabaseAdminClient.create()) {
   *   String formattedName = BackupName.format("[PROJECT]", "[INSTANCE]", "[BACKUP]");
   *   DeleteBackupRequest request = DeleteBackupRequest.newBuilder()
   *     .setName(formattedName)
   *     .build();
   *   databaseAdminClient.deleteBackup(request);
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
   * Sample code:
   *
   * <pre><code>
   * try (DatabaseAdminClient databaseAdminClient = DatabaseAdminClient.create()) {
   *   String formattedName = BackupName.format("[PROJECT]", "[INSTANCE]", "[BACKUP]");
   *   DeleteBackupRequest request = DeleteBackupRequest.newBuilder()
   *     .setName(formattedName)
   *     .build();
   *   ApiFuture&lt;Void&gt; future = databaseAdminClient.deleteBackupCallable().futureCall(request);
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
   * Sample code:
   *
   * <pre><code>
   * try (DatabaseAdminClient databaseAdminClient = DatabaseAdminClient.create()) {
   *   String formattedParent = InstanceName.format("[PROJECT]", "[INSTANCE]");
   *   String filter = "";
   *   String orderBy = "";
   *   for (Backup element : databaseAdminClient.listBackups(formattedParent, filter, orderBy).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param parent Required. The instance to list backups from. Values are of the form
   *     `projects/&lt;project&gt;/instances/&lt;instance&gt;`.
   * @param filter A filter expression that filters backups listed in the response. The expression
   *     must specify the field name, a comparison operator, and the value that you want to use for
   *     filtering. The value must be a string, a number, or a boolean. The comparison operator must
   *     be &lt;, &gt;, &lt;=, &gt;=, !=, =, or :. Colon ‘:’ represents a HAS operator which is
   *     roughly synonymous with equality. Filter rules are case insensitive.
   *     <p>The fields eligible for filtering are: &#42; `name` &#42; `database` &#42; `state` &#42;
   *     `create_time` (and values are of the format YYYY-MM-DDTHH:MM:SSZ) &#42; `expire_time` (and
   *     values are of the format YYYY-MM-DDTHH:MM:SSZ) &#42; `size_bytes`
   *     <p>To filter on multiple expressions, provide each separate expression within parentheses.
   *     By default, each expression is an AND expression. However, you can include AND, OR, and NOT
   *     expressions explicitly.
   *     <p>Some examples of using filters are:
   *     <p>&#42; `name:Howl` --&gt; The backup's name contains the string "howl". &#42;
   *     `database:prod` --&gt; The database's name contains the string "prod". &#42;
   *     `state:CREATING` --&gt; The backup is pending creation. &#42; `state:READY` --&gt; The
   *     backup is fully created and ready for use. &#42; `(name:howl) AND (create_time &lt;
   *     \"2018-03-28T14:50:00Z\")` --&gt; The backup name contains the string "howl" and
   *     `create_time` of the backup is before 2018-03-28T14:50:00Z. &#42; `expire_time &lt;
   *     \"2018-03-28T14:50:00Z\"` --&gt; The backup `expire_time` is before 2018-03-28T14:50:00Z.
   *     &#42; `size_bytes &gt; 10000000000` --&gt; The backup's size is greater than 10GB
   * @param orderBy An expression for specifying the sort order of the results of the request. The
   *     string value should specify only one field in
   *     [Backup][google.spanner.admin.database.v1.Backup]. Fields supported are: &#42; name &#42;
   *     database &#42; expire_time &#42; create_time &#42; size_bytes &#42; state
   *     <p>For example, "create_time". The default sorting order is ascending. To specify
   *     descending order for the field, a suffix " desc" should be appended to the field name. For
   *     example, "create_time desc". Redundant space characters in the syntax are insigificant.
   *     <p>If order_by is empty, results will be sorted by `create_time` in descending order
   *     starting from the most recently created backup.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListBackupsPagedResponse listBackups(String parent, String filter, String orderBy) {
    ListBackupsRequest request =
        ListBackupsRequest.newBuilder()
            .setParent(parent)
            .setFilter(filter)
            .setOrderBy(orderBy)
            .build();
    return listBackups(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sample code:
   *
   * <pre><code>
   * try (DatabaseAdminClient databaseAdminClient = DatabaseAdminClient.create()) {
   *   String formattedParent = InstanceName.format("[PROJECT]", "[INSTANCE]");
   *   String filter = "";
   *   String orderBy = "";
   *   ListBackupsRequest request = ListBackupsRequest.newBuilder()
   *     .setParent(formattedParent)
   *     .setFilter(filter)
   *     .setOrderBy(orderBy)
   *     .build();
   *   for (Backup element : databaseAdminClient.listBackups(request).iterateAll()) {
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
   * Sample code:
   *
   * <pre><code>
   * try (DatabaseAdminClient databaseAdminClient = DatabaseAdminClient.create()) {
   *   String formattedParent = InstanceName.format("[PROJECT]", "[INSTANCE]");
   *   String filter = "";
   *   String orderBy = "";
   *   ListBackupsRequest request = ListBackupsRequest.newBuilder()
   *     .setParent(formattedParent)
   *     .setFilter(filter)
   *     .setOrderBy(orderBy)
   *     .build();
   *   ApiFuture&lt;ListBackupsPagedResponse&gt; future = databaseAdminClient.listBackupsPagedCallable().futureCall(request);
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
   * Sample code:
   *
   * <pre><code>
   * try (DatabaseAdminClient databaseAdminClient = DatabaseAdminClient.create()) {
   *   String formattedParent = InstanceName.format("[PROJECT]", "[INSTANCE]");
   *   String filter = "";
   *   String orderBy = "";
   *   ListBackupsRequest request = ListBackupsRequest.newBuilder()
   *     .setParent(formattedParent)
   *     .setFilter(filter)
   *     .setOrderBy(orderBy)
   *     .build();
   *   while (true) {
   *     ListBackupsResponse response = databaseAdminClient.listBackupsCallable().call(request);
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
   * Sample code:
   *
   * <pre><code>
   * try (DatabaseAdminClient databaseAdminClient = DatabaseAdminClient.create()) {
   *   String formattedParent = InstanceName.format("[PROJECT]", "[INSTANCE]");
   *   String databaseId = "";
   *   Empty response = databaseAdminClient.restoreDatabaseAsync(formattedParent, databaseId).get();
   * }
   * </code></pre>
   *
   * @param parent Required. The name of the instance in which to create the restored database. This
   *     instance must be in the same project and have the same instance configuration as the
   *     instance containing the source backup. Values are of the form
   *     `projects/&lt;project&gt;/instances/&lt;instance&gt;.
   * @param databaseId Required. The id of the database to create and restore to. This database must
   *     not already exist. The `database_id` appended to `parent` forms the full database name of
   *     the form
   *     `projects/&lt;project&gt;/instances/&lt;instance&gt;/databases/&lt;database_id&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Empty, RestoreDatabaseMetadata> restoreDatabaseAsync(
      String parent, String databaseId) {

    RestoreDatabaseRequest request =
        RestoreDatabaseRequest.newBuilder().setParent(parent).setDatabaseId(databaseId).build();
    return restoreDatabaseAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sample code:
   *
   * <pre><code>
   * try (DatabaseAdminClient databaseAdminClient = DatabaseAdminClient.create()) {
   *   String formattedParent = InstanceName.format("[PROJECT]", "[INSTANCE]");
   *   String databaseId = "";
   *   RestoreDatabaseRequest request = RestoreDatabaseRequest.newBuilder()
   *     .setParent(formattedParent)
   *     .setDatabaseId(databaseId)
   *     .build();
   *   Empty response = databaseAdminClient.restoreDatabaseAsync(request).get();
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Empty, RestoreDatabaseMetadata> restoreDatabaseAsync(
      RestoreDatabaseRequest request) {
    return restoreDatabaseOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sample code:
   *
   * <pre><code>
   * try (DatabaseAdminClient databaseAdminClient = DatabaseAdminClient.create()) {
   *   String formattedParent = InstanceName.format("[PROJECT]", "[INSTANCE]");
   *   String databaseId = "";
   *   RestoreDatabaseRequest request = RestoreDatabaseRequest.newBuilder()
   *     .setParent(formattedParent)
   *     .setDatabaseId(databaseId)
   *     .build();
   *   OperationFuture&lt;Operation&gt; future = databaseAdminClient.restoreDatabaseOperationCallable().futureCall(request);
   *   // Do something
   *   Empty response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi("The surface for use by generated code is not stable yet and may change in the future.")
  public final OperationCallable<RestoreDatabaseRequest, Empty, RestoreDatabaseMetadata>
      restoreDatabaseOperationCallable() {
    return stub.restoreDatabaseOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sample code:
   *
   * <pre><code>
   * try (DatabaseAdminClient databaseAdminClient = DatabaseAdminClient.create()) {
   *   String formattedParent = InstanceName.format("[PROJECT]", "[INSTANCE]");
   *   String databaseId = "";
   *   RestoreDatabaseRequest request = RestoreDatabaseRequest.newBuilder()
   *     .setParent(formattedParent)
   *     .setDatabaseId(databaseId)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = databaseAdminClient.restoreDatabaseCallable().futureCall(request);
   *   // Do something
   *   future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<RestoreDatabaseRequest, Operation> restoreDatabaseCallable() {
    return stub.restoreDatabaseCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sample code:
   *
   * <pre><code>
   * try (DatabaseAdminClient databaseAdminClient = DatabaseAdminClient.create()) {
   *   String formattedParent = InstanceName.format("[PROJECT]", "[INSTANCE]");
   *   String filter = "";
   *   for (Operation element : databaseAdminClient.listDatabaseOperations(formattedParent, filter).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param parent Required. The instance of the database operations. Values are of the form
   *     `projects/&lt;project&gt;/instances/&lt;instance&gt;`.
   * @param filter A filter expression that filters what operations are returned in the response.
   *     <p>The response returns a list of [long-running operations][google.longrunning.Operation]
   *     whose names are prefixed by a database name within the specified instance. The long-running
   *     operation [metadata][google.longrunning.Operation.metadata] field type `metadata.type_url`
   *     describes the type of the metadata.
   *     <p>The filter expression must specify the field name, a comparison operator, and the value
   *     that you want to use for filtering. The value must be a string, a number, or a boolean. The
   *     comparison operator must be &lt;, &gt;, &lt;=, &gt;=, !=, =, or :. Colon ‘:’ represents a
   *     HAS operator which is roughly synonymous with equality. Filter rules are case insensitive.
   *     <p>The long-running operation fields eligible for filtering are: &#42; `name` --&gt; The
   *     name of the long-running operation &#42; `done` --&gt; False if the operation is in
   *     progress, else true. &#42; `metadata.type_url` (using filter string
   *     `metadata.{@literal @}type`) and fields in `metadata.value` (using filter string
   *     `metadata.&lt;field_name&gt;`, where &lt;field_name&gt; is a field in metadata.value) are
   *     eligible for filtering.
   *     <p>To filter on multiple expressions, provide each separate expression within parentheses.
   *     By default, each expression is an AND expression. However, you can include AND, OR, and NOT
   *     expressions explicitly.
   *     <p>Some examples of using filters are:
   *     <p>&#42; `done:true` --&gt; The operation is complete. &#42;
   *     `(metadata.{@literal @}type:type.googleapis.com/google.spanner.admin.database.v1.RestoreDatabaseMetadata)
   *     AND (metadata.source_type:BACKUP) AND (metadata.backup_info.backup:backup_howl) AND
   *     (metadata.name:restored_howl) AND (metadata.progress.start_time &lt;
   *     \"2018-03-28T14:50:00Z\") AND (error:&#42;)` --&gt; Return RestoreDatabase operations from
   *     backups whose name contains "backup_howl", where the created database name contains the
   *     string "restored_howl", the start_time of the restore operation is before
   *     2018-03-28T14:50:00Z, and the operation returned an error.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDatabaseOperationsPagedResponse listDatabaseOperations(
      String parent, String filter) {
    ListDatabaseOperationsRequest request =
        ListDatabaseOperationsRequest.newBuilder().setParent(parent).setFilter(filter).build();
    return listDatabaseOperations(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sample code:
   *
   * <pre><code>
   * try (DatabaseAdminClient databaseAdminClient = DatabaseAdminClient.create()) {
   *   String formattedParent = InstanceName.format("[PROJECT]", "[INSTANCE]");
   *   String filter = "";
   *   ListDatabaseOperationsRequest request = ListDatabaseOperationsRequest.newBuilder()
   *     .setParent(formattedParent)
   *     .setFilter(filter)
   *     .build();
   *   for (Operation element : databaseAdminClient.listDatabaseOperations(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDatabaseOperationsPagedResponse listDatabaseOperations(
      ListDatabaseOperationsRequest request) {
    return listDatabaseOperationsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sample code:
   *
   * <pre><code>
   * try (DatabaseAdminClient databaseAdminClient = DatabaseAdminClient.create()) {
   *   String formattedParent = InstanceName.format("[PROJECT]", "[INSTANCE]");
   *   String filter = "";
   *   ListDatabaseOperationsRequest request = ListDatabaseOperationsRequest.newBuilder()
   *     .setParent(formattedParent)
   *     .setFilter(filter)
   *     .build();
   *   ApiFuture&lt;ListDatabaseOperationsPagedResponse&gt; future = databaseAdminClient.listDatabaseOperationsPagedCallable().futureCall(request);
   *   // Do something
   *   for (Operation element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  public final UnaryCallable<ListDatabaseOperationsRequest, ListDatabaseOperationsPagedResponse>
      listDatabaseOperationsPagedCallable() {
    return stub.listDatabaseOperationsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sample code:
   *
   * <pre><code>
   * try (DatabaseAdminClient databaseAdminClient = DatabaseAdminClient.create()) {
   *   String formattedParent = InstanceName.format("[PROJECT]", "[INSTANCE]");
   *   String filter = "";
   *   ListDatabaseOperationsRequest request = ListDatabaseOperationsRequest.newBuilder()
   *     .setParent(formattedParent)
   *     .setFilter(filter)
   *     .build();
   *   while (true) {
   *     ListDatabaseOperationsResponse response = databaseAdminClient.listDatabaseOperationsCallable().call(request);
   *     for (Operation element : response.getOperationsList()) {
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
  public final UnaryCallable<ListDatabaseOperationsRequest, ListDatabaseOperationsResponse>
      listDatabaseOperationsCallable() {
    return stub.listDatabaseOperationsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sample code:
   *
   * <pre><code>
   * try (DatabaseAdminClient databaseAdminClient = DatabaseAdminClient.create()) {
   *   String formattedParent = InstanceName.format("[PROJECT]", "[INSTANCE]");
   *   String filter = "";
   *   for (Operation element : databaseAdminClient.listBackupOperations(formattedParent, filter).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param parent Required. The instance of the backup operations. Values are of the form
   *     `projects/&lt;project&gt;/instances/&lt;instance&gt;`.
   * @param filter A filter expression that filters what operations are returned in the response.
   *     <p>The response returns a list of [long-running operations][google.longrunning.Operation]
   *     whose names are prefixed by a backup name within the specified instance. The long-running
   *     operation [metadata][google.longrunning.Operation.metadata] field type `metadata.type_url`
   *     describes the type of the metadata.
   *     <p>The filter expression must specify the field name of an operation, a comparison
   *     operator, and the value that you want to use for filtering. The value must be a string, a
   *     number, or a boolean. The comparison operator must be &lt;, &gt;, &lt;=, &gt;=, !=, =, or
   *     :. Colon ‘:’ represents a HAS operator which is roughly synonymous with equality. Filter
   *     rules are case insensitive.
   *     <p>The long-running operation fields eligible for filtering are: &#42; `name` --&gt; The
   *     name of the long-running operation &#42; `done` --&gt; False if the operation is in
   *     progress, else true. &#42; `metadata.type_url` (using filter string
   *     `metadata.{@literal @}type`) and fields in `metadata.value` (using filter string
   *     `metadata.&lt;field_name&gt;`, where &lt;field_name&gt; is a field in metadata.value) are
   *     eligible for filtering.
   *     <p>To filter on multiple expressions, provide each separate expression within parentheses.
   *     By default, each expression is an AND expression. However, you can include AND, OR, and NOT
   *     expressions explicitly.
   *     <p>Some examples of using filters are:
   *     <p>&#42; `done:true` --&gt; The operation is complete. &#42; `metadata.database:prod`
   *     --&gt; The database the backup was taken from has a name containing the string "prod".
   *     &#42;
   *     `(metadata.{@literal @}type:type.googleapis.com/google.spanner.admin.database.v1.CreateBackupMetadata)
   *     AND (metadata.name:howl) AND (metadata.progress.start_time &lt; \"2018-03-28T14:50:00Z\")
   *     AND (error:&#42;)` --&gt; Return CreateBackup operations where the created backup name
   *     contains the string "howl", the progress.start_time of the backup operation is before
   *     2018-03-28T14:50:00Z, and the operation returned an error.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListBackupOperationsPagedResponse listBackupOperations(
      String parent, String filter) {
    ListBackupOperationsRequest request =
        ListBackupOperationsRequest.newBuilder().setParent(parent).setFilter(filter).build();
    return listBackupOperations(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sample code:
   *
   * <pre><code>
   * try (DatabaseAdminClient databaseAdminClient = DatabaseAdminClient.create()) {
   *   String formattedParent = InstanceName.format("[PROJECT]", "[INSTANCE]");
   *   String filter = "";
   *   ListBackupOperationsRequest request = ListBackupOperationsRequest.newBuilder()
   *     .setParent(formattedParent)
   *     .setFilter(filter)
   *     .build();
   *   for (Operation element : databaseAdminClient.listBackupOperations(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListBackupOperationsPagedResponse listBackupOperations(
      ListBackupOperationsRequest request) {
    return listBackupOperationsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sample code:
   *
   * <pre><code>
   * try (DatabaseAdminClient databaseAdminClient = DatabaseAdminClient.create()) {
   *   String formattedParent = InstanceName.format("[PROJECT]", "[INSTANCE]");
   *   String filter = "";
   *   ListBackupOperationsRequest request = ListBackupOperationsRequest.newBuilder()
   *     .setParent(formattedParent)
   *     .setFilter(filter)
   *     .build();
   *   ApiFuture&lt;ListBackupOperationsPagedResponse&gt; future = databaseAdminClient.listBackupOperationsPagedCallable().futureCall(request);
   *   // Do something
   *   for (Operation element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  public final UnaryCallable<ListBackupOperationsRequest, ListBackupOperationsPagedResponse>
      listBackupOperationsPagedCallable() {
    return stub.listBackupOperationsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sample code:
   *
   * <pre><code>
   * try (DatabaseAdminClient databaseAdminClient = DatabaseAdminClient.create()) {
   *   String formattedParent = InstanceName.format("[PROJECT]", "[INSTANCE]");
   *   String filter = "";
   *   ListBackupOperationsRequest request = ListBackupOperationsRequest.newBuilder()
   *     .setParent(formattedParent)
   *     .setFilter(filter)
   *     .build();
   *   while (true) {
   *     ListBackupOperationsResponse response = databaseAdminClient.listBackupOperationsCallable().call(request);
   *     for (Operation element : response.getOperationsList()) {
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
  public final UnaryCallable<ListBackupOperationsRequest, ListBackupOperationsResponse>
      listBackupOperationsCallable() {
    return stub.listBackupOperationsCallable();
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

  public static class ListDatabasesPagedResponse
      extends AbstractPagedListResponse<
          ListDatabasesRequest,
          ListDatabasesResponse,
          Database,
          ListDatabasesPage,
          ListDatabasesFixedSizeCollection> {

    public static ApiFuture<ListDatabasesPagedResponse> createAsync(
        PageContext<ListDatabasesRequest, ListDatabasesResponse, Database> context,
        ApiFuture<ListDatabasesResponse> futureResponse) {
      ApiFuture<ListDatabasesPage> futurePage =
          ListDatabasesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListDatabasesPage, ListDatabasesPagedResponse>() {
            @Override
            public ListDatabasesPagedResponse apply(ListDatabasesPage input) {
              return new ListDatabasesPagedResponse(input);
            }
          });
    }

    private ListDatabasesPagedResponse(ListDatabasesPage page) {
      super(page, ListDatabasesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListDatabasesPage
      extends AbstractPage<
          ListDatabasesRequest, ListDatabasesResponse, Database, ListDatabasesPage> {

    private ListDatabasesPage(
        PageContext<ListDatabasesRequest, ListDatabasesResponse, Database> context,
        ListDatabasesResponse response) {
      super(context, response);
    }

    private static ListDatabasesPage createEmptyPage() {
      return new ListDatabasesPage(null, null);
    }

    @Override
    protected ListDatabasesPage createPage(
        PageContext<ListDatabasesRequest, ListDatabasesResponse, Database> context,
        ListDatabasesResponse response) {
      return new ListDatabasesPage(context, response);
    }

    @Override
    public ApiFuture<ListDatabasesPage> createPageAsync(
        PageContext<ListDatabasesRequest, ListDatabasesResponse, Database> context,
        ApiFuture<ListDatabasesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListDatabasesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListDatabasesRequest,
          ListDatabasesResponse,
          Database,
          ListDatabasesPage,
          ListDatabasesFixedSizeCollection> {

    private ListDatabasesFixedSizeCollection(List<ListDatabasesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListDatabasesFixedSizeCollection createEmptyCollection() {
      return new ListDatabasesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListDatabasesFixedSizeCollection createCollection(
        List<ListDatabasesPage> pages, int collectionSize) {
      return new ListDatabasesFixedSizeCollection(pages, collectionSize);
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
          });
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

  public static class ListDatabaseOperationsPagedResponse
      extends AbstractPagedListResponse<
          ListDatabaseOperationsRequest,
          ListDatabaseOperationsResponse,
          Operation,
          ListDatabaseOperationsPage,
          ListDatabaseOperationsFixedSizeCollection> {

    public static ApiFuture<ListDatabaseOperationsPagedResponse> createAsync(
        PageContext<ListDatabaseOperationsRequest, ListDatabaseOperationsResponse, Operation>
            context,
        ApiFuture<ListDatabaseOperationsResponse> futureResponse) {
      ApiFuture<ListDatabaseOperationsPage> futurePage =
          ListDatabaseOperationsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListDatabaseOperationsPage, ListDatabaseOperationsPagedResponse>() {
            @Override
            public ListDatabaseOperationsPagedResponse apply(ListDatabaseOperationsPage input) {
              return new ListDatabaseOperationsPagedResponse(input);
            }
          });
    }

    private ListDatabaseOperationsPagedResponse(ListDatabaseOperationsPage page) {
      super(page, ListDatabaseOperationsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListDatabaseOperationsPage
      extends AbstractPage<
          ListDatabaseOperationsRequest,
          ListDatabaseOperationsResponse,
          Operation,
          ListDatabaseOperationsPage> {

    private ListDatabaseOperationsPage(
        PageContext<ListDatabaseOperationsRequest, ListDatabaseOperationsResponse, Operation>
            context,
        ListDatabaseOperationsResponse response) {
      super(context, response);
    }

    private static ListDatabaseOperationsPage createEmptyPage() {
      return new ListDatabaseOperationsPage(null, null);
    }

    @Override
    protected ListDatabaseOperationsPage createPage(
        PageContext<ListDatabaseOperationsRequest, ListDatabaseOperationsResponse, Operation>
            context,
        ListDatabaseOperationsResponse response) {
      return new ListDatabaseOperationsPage(context, response);
    }

    @Override
    public ApiFuture<ListDatabaseOperationsPage> createPageAsync(
        PageContext<ListDatabaseOperationsRequest, ListDatabaseOperationsResponse, Operation>
            context,
        ApiFuture<ListDatabaseOperationsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListDatabaseOperationsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListDatabaseOperationsRequest,
          ListDatabaseOperationsResponse,
          Operation,
          ListDatabaseOperationsPage,
          ListDatabaseOperationsFixedSizeCollection> {

    private ListDatabaseOperationsFixedSizeCollection(
        List<ListDatabaseOperationsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListDatabaseOperationsFixedSizeCollection createEmptyCollection() {
      return new ListDatabaseOperationsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListDatabaseOperationsFixedSizeCollection createCollection(
        List<ListDatabaseOperationsPage> pages, int collectionSize) {
      return new ListDatabaseOperationsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListBackupOperationsPagedResponse
      extends AbstractPagedListResponse<
          ListBackupOperationsRequest,
          ListBackupOperationsResponse,
          Operation,
          ListBackupOperationsPage,
          ListBackupOperationsFixedSizeCollection> {

    public static ApiFuture<ListBackupOperationsPagedResponse> createAsync(
        PageContext<ListBackupOperationsRequest, ListBackupOperationsResponse, Operation> context,
        ApiFuture<ListBackupOperationsResponse> futureResponse) {
      ApiFuture<ListBackupOperationsPage> futurePage =
          ListBackupOperationsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListBackupOperationsPage, ListBackupOperationsPagedResponse>() {
            @Override
            public ListBackupOperationsPagedResponse apply(ListBackupOperationsPage input) {
              return new ListBackupOperationsPagedResponse(input);
            }
          });
    }

    private ListBackupOperationsPagedResponse(ListBackupOperationsPage page) {
      super(page, ListBackupOperationsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListBackupOperationsPage
      extends AbstractPage<
          ListBackupOperationsRequest,
          ListBackupOperationsResponse,
          Operation,
          ListBackupOperationsPage> {

    private ListBackupOperationsPage(
        PageContext<ListBackupOperationsRequest, ListBackupOperationsResponse, Operation> context,
        ListBackupOperationsResponse response) {
      super(context, response);
    }

    private static ListBackupOperationsPage createEmptyPage() {
      return new ListBackupOperationsPage(null, null);
    }

    @Override
    protected ListBackupOperationsPage createPage(
        PageContext<ListBackupOperationsRequest, ListBackupOperationsResponse, Operation> context,
        ListBackupOperationsResponse response) {
      return new ListBackupOperationsPage(context, response);
    }

    @Override
    public ApiFuture<ListBackupOperationsPage> createPageAsync(
        PageContext<ListBackupOperationsRequest, ListBackupOperationsResponse, Operation> context,
        ApiFuture<ListBackupOperationsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListBackupOperationsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListBackupOperationsRequest,
          ListBackupOperationsResponse,
          Operation,
          ListBackupOperationsPage,
          ListBackupOperationsFixedSizeCollection> {

    private ListBackupOperationsFixedSizeCollection(
        List<ListBackupOperationsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListBackupOperationsFixedSizeCollection createEmptyCollection() {
      return new ListBackupOperationsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListBackupOperationsFixedSizeCollection createCollection(
        List<ListBackupOperationsPage> pages, int collectionSize) {
      return new ListBackupOperationsFixedSizeCollection(pages, collectionSize);
    }
  }
}
