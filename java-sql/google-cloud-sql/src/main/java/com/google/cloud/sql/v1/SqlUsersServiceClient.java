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

package com.google.cloud.sql.v1;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.sql.v1.stub.SqlUsersServiceStub;
import com.google.cloud.sql.v1.stub.SqlUsersServiceStubSettings;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Cloud SQL users service.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (SqlUsersServiceClient sqlUsersServiceClient = SqlUsersServiceClient.create()) {
 *   SqlUsersDeleteRequest request =
 *       SqlUsersDeleteRequest.newBuilder()
 *           .setHost("host3208616")
 *           .setInstance("instance555127957")
 *           .setName("name3373707")
 *           .setProject("project-309310695")
 *           .build();
 *   Operation response = sqlUsersServiceClient.delete(request);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the SqlUsersServiceClient object to clean up resources
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
 *      <td><p> Deletes a user from a Cloud SQL instance.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> delete(SqlUsersDeleteRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> Get</td>
 *      <td><p> Retrieves a resource containing information about a user.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> get(SqlUsersGetRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> Insert</td>
 *      <td><p> Creates a new user in a Cloud SQL instance.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> insert(SqlUsersInsertRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> insertCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> List</td>
 *      <td><p> Lists users in the specified Cloud SQL instance.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> list(SqlUsersListRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> Update</td>
 *      <td><p> Updates an existing user in a Cloud SQL instance.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> update(SqlUsersUpdateRequest request)
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
 * <p>This class can be customized by passing in a custom instance of SqlUsersServiceSettings to
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
 * SqlUsersServiceSettings sqlUsersServiceSettings =
 *     SqlUsersServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * SqlUsersServiceClient sqlUsersServiceClient =
 *     SqlUsersServiceClient.create(sqlUsersServiceSettings);
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
 * SqlUsersServiceSettings sqlUsersServiceSettings =
 *     SqlUsersServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * SqlUsersServiceClient sqlUsersServiceClient =
 *     SqlUsersServiceClient.create(sqlUsersServiceSettings);
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
 * SqlUsersServiceSettings sqlUsersServiceSettings =
 *     SqlUsersServiceSettings.newHttpJsonBuilder().build();
 * SqlUsersServiceClient sqlUsersServiceClient =
 *     SqlUsersServiceClient.create(sqlUsersServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@NullMarked
@Generated("by gapic-generator-java")
public class SqlUsersServiceClient implements BackgroundResource {
  private final @Nullable SqlUsersServiceSettings settings;
  private final SqlUsersServiceStub stub;

  /** Constructs an instance of SqlUsersServiceClient with default settings. */
  public static final SqlUsersServiceClient create() throws IOException {
    return create(SqlUsersServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of SqlUsersServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final SqlUsersServiceClient create(SqlUsersServiceSettings settings)
      throws IOException {
    return new SqlUsersServiceClient(settings);
  }

  /**
   * Constructs an instance of SqlUsersServiceClient, using the given stub for making calls. This is
   * for advanced usage - prefer using create(SqlUsersServiceSettings).
   */
  public static final SqlUsersServiceClient create(SqlUsersServiceStub stub) {
    return new SqlUsersServiceClient(stub);
  }

  /**
   * Constructs an instance of SqlUsersServiceClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected SqlUsersServiceClient(SqlUsersServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((SqlUsersServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected SqlUsersServiceClient(SqlUsersServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final @Nullable SqlUsersServiceSettings getSettings() {
    return settings;
  }

  public SqlUsersServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a user from a Cloud SQL instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SqlUsersServiceClient sqlUsersServiceClient = SqlUsersServiceClient.create()) {
   *   SqlUsersDeleteRequest request =
   *       SqlUsersDeleteRequest.newBuilder()
   *           .setHost("host3208616")
   *           .setInstance("instance555127957")
   *           .setName("name3373707")
   *           .setProject("project-309310695")
   *           .build();
   *   Operation response = sqlUsersServiceClient.delete(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation delete(SqlUsersDeleteRequest request) {
    return deleteCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a user from a Cloud SQL instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SqlUsersServiceClient sqlUsersServiceClient = SqlUsersServiceClient.create()) {
   *   SqlUsersDeleteRequest request =
   *       SqlUsersDeleteRequest.newBuilder()
   *           .setHost("host3208616")
   *           .setInstance("instance555127957")
   *           .setName("name3373707")
   *           .setProject("project-309310695")
   *           .build();
   *   ApiFuture<Operation> future = sqlUsersServiceClient.deleteCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SqlUsersDeleteRequest, Operation> deleteCallable() {
    return stub.deleteCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a resource containing information about a user.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SqlUsersServiceClient sqlUsersServiceClient = SqlUsersServiceClient.create()) {
   *   SqlUsersGetRequest request =
   *       SqlUsersGetRequest.newBuilder()
   *           .setInstance("instance555127957")
   *           .setName("name3373707")
   *           .setProject("project-309310695")
   *           .setHost("host3208616")
   *           .build();
   *   User response = sqlUsersServiceClient.get(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final User get(SqlUsersGetRequest request) {
    return getCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a resource containing information about a user.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SqlUsersServiceClient sqlUsersServiceClient = SqlUsersServiceClient.create()) {
   *   SqlUsersGetRequest request =
   *       SqlUsersGetRequest.newBuilder()
   *           .setInstance("instance555127957")
   *           .setName("name3373707")
   *           .setProject("project-309310695")
   *           .setHost("host3208616")
   *           .build();
   *   ApiFuture<User> future = sqlUsersServiceClient.getCallable().futureCall(request);
   *   // Do something.
   *   User response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SqlUsersGetRequest, User> getCallable() {
    return stub.getCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new user in a Cloud SQL instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SqlUsersServiceClient sqlUsersServiceClient = SqlUsersServiceClient.create()) {
   *   SqlUsersInsertRequest request =
   *       SqlUsersInsertRequest.newBuilder()
   *           .setInstance("instance555127957")
   *           .setProject("project-309310695")
   *           .setBody(User.newBuilder().build())
   *           .build();
   *   Operation response = sqlUsersServiceClient.insert(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation insert(SqlUsersInsertRequest request) {
    return insertCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new user in a Cloud SQL instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SqlUsersServiceClient sqlUsersServiceClient = SqlUsersServiceClient.create()) {
   *   SqlUsersInsertRequest request =
   *       SqlUsersInsertRequest.newBuilder()
   *           .setInstance("instance555127957")
   *           .setProject("project-309310695")
   *           .setBody(User.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future = sqlUsersServiceClient.insertCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SqlUsersInsertRequest, Operation> insertCallable() {
    return stub.insertCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists users in the specified Cloud SQL instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SqlUsersServiceClient sqlUsersServiceClient = SqlUsersServiceClient.create()) {
   *   SqlUsersListRequest request =
   *       SqlUsersListRequest.newBuilder()
   *           .setInstance("instance555127957")
   *           .setProject("project-309310695")
   *           .build();
   *   UsersListResponse response = sqlUsersServiceClient.list(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final UsersListResponse list(SqlUsersListRequest request) {
    return listCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists users in the specified Cloud SQL instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SqlUsersServiceClient sqlUsersServiceClient = SqlUsersServiceClient.create()) {
   *   SqlUsersListRequest request =
   *       SqlUsersListRequest.newBuilder()
   *           .setInstance("instance555127957")
   *           .setProject("project-309310695")
   *           .build();
   *   ApiFuture<UsersListResponse> future =
   *       sqlUsersServiceClient.listCallable().futureCall(request);
   *   // Do something.
   *   UsersListResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SqlUsersListRequest, UsersListResponse> listCallable() {
    return stub.listCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an existing user in a Cloud SQL instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SqlUsersServiceClient sqlUsersServiceClient = SqlUsersServiceClient.create()) {
   *   SqlUsersUpdateRequest request =
   *       SqlUsersUpdateRequest.newBuilder()
   *           .setHost("host3208616")
   *           .setInstance("instance555127957")
   *           .setName("name3373707")
   *           .setProject("project-309310695")
   *           .addAllDatabaseRoles(new ArrayList<String>())
   *           .setRevokeExistingRoles(true)
   *           .setBody(User.newBuilder().build())
   *           .build();
   *   Operation response = sqlUsersServiceClient.update(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation update(SqlUsersUpdateRequest request) {
    return updateCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an existing user in a Cloud SQL instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SqlUsersServiceClient sqlUsersServiceClient = SqlUsersServiceClient.create()) {
   *   SqlUsersUpdateRequest request =
   *       SqlUsersUpdateRequest.newBuilder()
   *           .setHost("host3208616")
   *           .setInstance("instance555127957")
   *           .setName("name3373707")
   *           .setProject("project-309310695")
   *           .addAllDatabaseRoles(new ArrayList<String>())
   *           .setRevokeExistingRoles(true)
   *           .setBody(User.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future = sqlUsersServiceClient.updateCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SqlUsersUpdateRequest, Operation> updateCallable() {
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
