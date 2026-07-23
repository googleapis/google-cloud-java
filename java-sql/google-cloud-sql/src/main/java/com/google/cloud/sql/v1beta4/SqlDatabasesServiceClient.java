/*
 * Copyright 2026 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.sql.v1beta4;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.sql.v1beta4.stub.SqlDatabasesServiceStub;
import com.google.cloud.sql.v1beta4.stub.SqlDatabasesServiceStubSettings;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * This class provides the ability to make remote calls to the backing service through method calls
 * that map to API methods. Sample code to get started:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (SqlDatabasesServiceClient sqlDatabasesServiceClient = SqlDatabasesServiceClient.create()) {
 *   SqlDatabasesDeleteRequest request =
 *       SqlDatabasesDeleteRequest.newBuilder()
 *           .setDatabase("database1789464955")
 *           .setInstance("instance555127957")
 *           .setProject("project-309310695")
 *           .build();
 *   Operation response = sqlDatabasesServiceClient.delete(request);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the SqlDatabasesServiceClient object to clean up resources
 * such as threads. In the example above, try-with-resources is used, which automatically calls
 * close().
 *
 * <table>
 *    <caption>Methods</caption>
 *    <tr>
 *      <th>Method</th>
 *      <th>Description</th>
 *      <th>Method Variants</th>
 *    </tr>
 *    <tr>
 *      <td><p> Delete</td>
 *      <td><p> Deletes a database from a Cloud SQL instance.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> delete(SqlDatabasesDeleteRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> Get</td>
 *      <td><p> Retrieves a resource containing information about a database inside a Cloud SQL instance.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> get(SqlDatabasesGetRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> Insert</td>
 *      <td><p> Inserts a resource containing information about a database inside a Cloud SQL instance.
 * <p>  &#42;&#42;Note:&#42;&#42; You can't modify the default character set and collation.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> insert(SqlDatabasesInsertRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> insertCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> List</td>
 *      <td><p> Lists databases in the specified Cloud SQL instance.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> list(SqlDatabasesListRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> Patch</td>
 *      <td><p> Partially updates a resource containing information about a database inside a Cloud SQL instance. This method supports patch semantics.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> patch(SqlDatabasesUpdateRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> patchCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> Update</td>
 *      <td><p> Updates a resource containing information about a database inside a Cloud SQL instance.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> update(SqlDatabasesUpdateRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *  </table>
 *
 * <p>See the individual methods for example code.
 *
 * <p>Many parameters require resource names to be formatted in a particular way. To assist with
 * these names, this class includes a format method for each type of name, and additionally a parse
 * method to extract the individual identifiers contained within names that are returned.
 *
 * <p>This class can be customized by passing in a custom instance of SqlDatabasesServiceSettings to
 * create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * SqlDatabasesServiceSettings sqlDatabasesServiceSettings =
 *     SqlDatabasesServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * SqlDatabasesServiceClient sqlDatabasesServiceClient =
 *     SqlDatabasesServiceClient.create(sqlDatabasesServiceSettings);
 * }</pre>
 *
 * <p>To customize the endpoint:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * SqlDatabasesServiceSettings sqlDatabasesServiceSettings =
 *     SqlDatabasesServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * SqlDatabasesServiceClient sqlDatabasesServiceClient =
 *     SqlDatabasesServiceClient.create(sqlDatabasesServiceSettings);
 * }</pre>
 *
 * <p>To use REST (HTTP1.1/JSON) transport (instead of gRPC) for sending and receiving requests over
 * the wire:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * SqlDatabasesServiceSettings sqlDatabasesServiceSettings =
 *     SqlDatabasesServiceSettings.newHttpJsonBuilder().build();
 * SqlDatabasesServiceClient sqlDatabasesServiceClient =
 *     SqlDatabasesServiceClient.create(sqlDatabasesServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@NullMarked
@BetaApi
@Generated("by gapic-generator-java")
public class SqlDatabasesServiceClient implements BackgroundResource {
  private final @Nullable SqlDatabasesServiceSettings settings;
  private final SqlDatabasesServiceStub stub;

  /** Constructs an instance of SqlDatabasesServiceClient with default settings. */
  public static final SqlDatabasesServiceClient create() throws IOException {
    return create(SqlDatabasesServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of SqlDatabasesServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final SqlDatabasesServiceClient create(SqlDatabasesServiceSettings settings)
      throws IOException {
    return new SqlDatabasesServiceClient(settings);
  }

  /**
   * Constructs an instance of SqlDatabasesServiceClient, using the given stub for making calls.
   * This is for advanced usage - prefer using create(SqlDatabasesServiceSettings).
   */
  public static final SqlDatabasesServiceClient create(SqlDatabasesServiceStub stub) {
    return new SqlDatabasesServiceClient(stub);
  }

  /**
   * Constructs an instance of SqlDatabasesServiceClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected SqlDatabasesServiceClient(SqlDatabasesServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((SqlDatabasesServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected SqlDatabasesServiceClient(SqlDatabasesServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final @Nullable SqlDatabasesServiceSettings getSettings() {
    return settings;
  }

  public SqlDatabasesServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a database from a Cloud SQL instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SqlDatabasesServiceClient sqlDatabasesServiceClient = SqlDatabasesServiceClient.create()) {
   *   SqlDatabasesDeleteRequest request =
   *       SqlDatabasesDeleteRequest.newBuilder()
   *           .setDatabase("database1789464955")
   *           .setInstance("instance555127957")
   *           .setProject("project-309310695")
   *           .build();
   *   Operation response = sqlDatabasesServiceClient.delete(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation delete(SqlDatabasesDeleteRequest request) {
    return deleteCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a database from a Cloud SQL instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SqlDatabasesServiceClient sqlDatabasesServiceClient = SqlDatabasesServiceClient.create()) {
   *   SqlDatabasesDeleteRequest request =
   *       SqlDatabasesDeleteRequest.newBuilder()
   *           .setDatabase("database1789464955")
   *           .setInstance("instance555127957")
   *           .setProject("project-309310695")
   *           .build();
   *   ApiFuture<Operation> future = sqlDatabasesServiceClient.deleteCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SqlDatabasesDeleteRequest, Operation> deleteCallable() {
    return stub.deleteCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a resource containing information about a database inside a Cloud SQL instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SqlDatabasesServiceClient sqlDatabasesServiceClient = SqlDatabasesServiceClient.create()) {
   *   SqlDatabasesGetRequest request =
   *       SqlDatabasesGetRequest.newBuilder()
   *           .setDatabase("database1789464955")
   *           .setInstance("instance555127957")
   *           .setProject("project-309310695")
   *           .build();
   *   Database response = sqlDatabasesServiceClient.get(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Database get(SqlDatabasesGetRequest request) {
    return getCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a resource containing information about a database inside a Cloud SQL instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SqlDatabasesServiceClient sqlDatabasesServiceClient = SqlDatabasesServiceClient.create()) {
   *   SqlDatabasesGetRequest request =
   *       SqlDatabasesGetRequest.newBuilder()
   *           .setDatabase("database1789464955")
   *           .setInstance("instance555127957")
   *           .setProject("project-309310695")
   *           .build();
   *   ApiFuture<Database> future = sqlDatabasesServiceClient.getCallable().futureCall(request);
   *   // Do something.
   *   Database response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SqlDatabasesGetRequest, Database> getCallable() {
    return stub.getCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Inserts a resource containing information about a database inside a Cloud SQL instance.
   *
   * <p>&#42;&#42;Note:&#42;&#42; You can't modify the default character set and collation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SqlDatabasesServiceClient sqlDatabasesServiceClient = SqlDatabasesServiceClient.create()) {
   *   SqlDatabasesInsertRequest request =
   *       SqlDatabasesInsertRequest.newBuilder()
   *           .setInstance("instance555127957")
   *           .setProject("project-309310695")
   *           .setBody(Database.newBuilder().build())
   *           .build();
   *   Operation response = sqlDatabasesServiceClient.insert(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation insert(SqlDatabasesInsertRequest request) {
    return insertCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Inserts a resource containing information about a database inside a Cloud SQL instance.
   *
   * <p>&#42;&#42;Note:&#42;&#42; You can't modify the default character set and collation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SqlDatabasesServiceClient sqlDatabasesServiceClient = SqlDatabasesServiceClient.create()) {
   *   SqlDatabasesInsertRequest request =
   *       SqlDatabasesInsertRequest.newBuilder()
   *           .setInstance("instance555127957")
   *           .setProject("project-309310695")
   *           .setBody(Database.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future = sqlDatabasesServiceClient.insertCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SqlDatabasesInsertRequest, Operation> insertCallable() {
    return stub.insertCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists databases in the specified Cloud SQL instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SqlDatabasesServiceClient sqlDatabasesServiceClient = SqlDatabasesServiceClient.create()) {
   *   SqlDatabasesListRequest request =
   *       SqlDatabasesListRequest.newBuilder()
   *           .setInstance("instance555127957")
   *           .setProject("project-309310695")
   *           .build();
   *   DatabasesListResponse response = sqlDatabasesServiceClient.list(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DatabasesListResponse list(SqlDatabasesListRequest request) {
    return listCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists databases in the specified Cloud SQL instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SqlDatabasesServiceClient sqlDatabasesServiceClient = SqlDatabasesServiceClient.create()) {
   *   SqlDatabasesListRequest request =
   *       SqlDatabasesListRequest.newBuilder()
   *           .setInstance("instance555127957")
   *           .setProject("project-309310695")
   *           .build();
   *   ApiFuture<DatabasesListResponse> future =
   *       sqlDatabasesServiceClient.listCallable().futureCall(request);
   *   // Do something.
   *   DatabasesListResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SqlDatabasesListRequest, DatabasesListResponse> listCallable() {
    return stub.listCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Partially updates a resource containing information about a database inside a Cloud SQL
   * instance. This method supports patch semantics.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SqlDatabasesServiceClient sqlDatabasesServiceClient = SqlDatabasesServiceClient.create()) {
   *   SqlDatabasesUpdateRequest request =
   *       SqlDatabasesUpdateRequest.newBuilder()
   *           .setDatabase("database1789464955")
   *           .setInstance("instance555127957")
   *           .setProject("project-309310695")
   *           .setBody(Database.newBuilder().build())
   *           .build();
   *   Operation response = sqlDatabasesServiceClient.patch(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation patch(SqlDatabasesUpdateRequest request) {
    return patchCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Partially updates a resource containing information about a database inside a Cloud SQL
   * instance. This method supports patch semantics.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SqlDatabasesServiceClient sqlDatabasesServiceClient = SqlDatabasesServiceClient.create()) {
   *   SqlDatabasesUpdateRequest request =
   *       SqlDatabasesUpdateRequest.newBuilder()
   *           .setDatabase("database1789464955")
   *           .setInstance("instance555127957")
   *           .setProject("project-309310695")
   *           .setBody(Database.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future = sqlDatabasesServiceClient.patchCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SqlDatabasesUpdateRequest, Operation> patchCallable() {
    return stub.patchCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a resource containing information about a database inside a Cloud SQL instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SqlDatabasesServiceClient sqlDatabasesServiceClient = SqlDatabasesServiceClient.create()) {
   *   SqlDatabasesUpdateRequest request =
   *       SqlDatabasesUpdateRequest.newBuilder()
   *           .setDatabase("database1789464955")
   *           .setInstance("instance555127957")
   *           .setProject("project-309310695")
   *           .setBody(Database.newBuilder().build())
   *           .build();
   *   Operation response = sqlDatabasesServiceClient.update(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation update(SqlDatabasesUpdateRequest request) {
    return updateCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a resource containing information about a database inside a Cloud SQL instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SqlDatabasesServiceClient sqlDatabasesServiceClient = SqlDatabasesServiceClient.create()) {
   *   SqlDatabasesUpdateRequest request =
   *       SqlDatabasesUpdateRequest.newBuilder()
   *           .setDatabase("database1789464955")
   *           .setInstance("instance555127957")
   *           .setProject("project-309310695")
   *           .setBody(Database.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future = sqlDatabasesServiceClient.updateCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SqlDatabasesUpdateRequest, Operation> updateCallable() {
    return stub.updateCallable();
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
}
