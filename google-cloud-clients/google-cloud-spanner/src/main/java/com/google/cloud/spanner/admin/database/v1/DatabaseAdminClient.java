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
import com.google.spanner.admin.database.v1.CreateDatabaseMetadata;
import com.google.spanner.admin.database.v1.CreateDatabaseRequest;
import com.google.spanner.admin.database.v1.Database;
import com.google.spanner.admin.database.v1.DatabaseName;
import com.google.spanner.admin.database.v1.DropDatabaseRequest;
import com.google.spanner.admin.database.v1.GetDatabaseDdlRequest;
import com.google.spanner.admin.database.v1.GetDatabaseDdlResponse;
import com.google.spanner.admin.database.v1.GetDatabaseRequest;
import com.google.spanner.admin.database.v1.InstanceName;
import com.google.spanner.admin.database.v1.ListDatabasesRequest;
import com.google.spanner.admin.database.v1.ListDatabasesResponse;
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
}
