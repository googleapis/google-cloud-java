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
import com.google.cloud.sql.v1beta4.stub.SqlBackupRunsServiceStub;
import com.google.cloud.sql.v1beta4.stub.SqlBackupRunsServiceStubSettings;
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
 * try (SqlBackupRunsServiceClient sqlBackupRunsServiceClient =
 *     SqlBackupRunsServiceClient.create()) {
 *   SqlBackupRunsDeleteRequest request =
 *       SqlBackupRunsDeleteRequest.newBuilder()
 *           .setId(3355)
 *           .setInstance("instance555127957")
 *           .setProject("project-309310695")
 *           .build();
 *   Operation response = sqlBackupRunsServiceClient.delete(request);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the SqlBackupRunsServiceClient object to clean up
 * resources such as threads. In the example above, try-with-resources is used, which automatically
 * calls close().
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
 *      <td><p> Deletes the backup taken by a backup run.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> delete(SqlBackupRunsDeleteRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> Get</td>
 *      <td><p> Retrieves a resource containing information about a backup run.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> get(SqlBackupRunsGetRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> Insert</td>
 *      <td><p> Creates a new backup run on demand.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> insert(SqlBackupRunsInsertRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> insertCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> List</td>
 *      <td><p> Lists all backup runs associated with the project or a given instance and configuration in the reverse chronological order of the backup initiation time.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> list(SqlBackupRunsListRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listCallable()
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
 * <p>This class can be customized by passing in a custom instance of SqlBackupRunsServiceSettings
 * to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * SqlBackupRunsServiceSettings sqlBackupRunsServiceSettings =
 *     SqlBackupRunsServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * SqlBackupRunsServiceClient sqlBackupRunsServiceClient =
 *     SqlBackupRunsServiceClient.create(sqlBackupRunsServiceSettings);
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
 * SqlBackupRunsServiceSettings sqlBackupRunsServiceSettings =
 *     SqlBackupRunsServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * SqlBackupRunsServiceClient sqlBackupRunsServiceClient =
 *     SqlBackupRunsServiceClient.create(sqlBackupRunsServiceSettings);
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
 * SqlBackupRunsServiceSettings sqlBackupRunsServiceSettings =
 *     SqlBackupRunsServiceSettings.newHttpJsonBuilder().build();
 * SqlBackupRunsServiceClient sqlBackupRunsServiceClient =
 *     SqlBackupRunsServiceClient.create(sqlBackupRunsServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@NullMarked
@BetaApi
@Generated("by gapic-generator-java")
public class SqlBackupRunsServiceClient implements BackgroundResource {
  private final @Nullable SqlBackupRunsServiceSettings settings;
  private final SqlBackupRunsServiceStub stub;

  /** Constructs an instance of SqlBackupRunsServiceClient with default settings. */
  public static final SqlBackupRunsServiceClient create() throws IOException {
    return create(SqlBackupRunsServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of SqlBackupRunsServiceClient, using the given settings. The channels
   * are created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final SqlBackupRunsServiceClient create(SqlBackupRunsServiceSettings settings)
      throws IOException {
    return new SqlBackupRunsServiceClient(settings);
  }

  /**
   * Constructs an instance of SqlBackupRunsServiceClient, using the given stub for making calls.
   * This is for advanced usage - prefer using create(SqlBackupRunsServiceSettings).
   */
  public static final SqlBackupRunsServiceClient create(SqlBackupRunsServiceStub stub) {
    return new SqlBackupRunsServiceClient(stub);
  }

  /**
   * Constructs an instance of SqlBackupRunsServiceClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected SqlBackupRunsServiceClient(SqlBackupRunsServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((SqlBackupRunsServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected SqlBackupRunsServiceClient(SqlBackupRunsServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final @Nullable SqlBackupRunsServiceSettings getSettings() {
    return settings;
  }

  public SqlBackupRunsServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the backup taken by a backup run.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SqlBackupRunsServiceClient sqlBackupRunsServiceClient =
   *     SqlBackupRunsServiceClient.create()) {
   *   SqlBackupRunsDeleteRequest request =
   *       SqlBackupRunsDeleteRequest.newBuilder()
   *           .setId(3355)
   *           .setInstance("instance555127957")
   *           .setProject("project-309310695")
   *           .build();
   *   Operation response = sqlBackupRunsServiceClient.delete(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation delete(SqlBackupRunsDeleteRequest request) {
    return deleteCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the backup taken by a backup run.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SqlBackupRunsServiceClient sqlBackupRunsServiceClient =
   *     SqlBackupRunsServiceClient.create()) {
   *   SqlBackupRunsDeleteRequest request =
   *       SqlBackupRunsDeleteRequest.newBuilder()
   *           .setId(3355)
   *           .setInstance("instance555127957")
   *           .setProject("project-309310695")
   *           .build();
   *   ApiFuture<Operation> future = sqlBackupRunsServiceClient.deleteCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SqlBackupRunsDeleteRequest, Operation> deleteCallable() {
    return stub.deleteCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a resource containing information about a backup run.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SqlBackupRunsServiceClient sqlBackupRunsServiceClient =
   *     SqlBackupRunsServiceClient.create()) {
   *   SqlBackupRunsGetRequest request =
   *       SqlBackupRunsGetRequest.newBuilder()
   *           .setId(3355)
   *           .setInstance("instance555127957")
   *           .setProject("project-309310695")
   *           .build();
   *   BackupRun response = sqlBackupRunsServiceClient.get(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BackupRun get(SqlBackupRunsGetRequest request) {
    return getCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a resource containing information about a backup run.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SqlBackupRunsServiceClient sqlBackupRunsServiceClient =
   *     SqlBackupRunsServiceClient.create()) {
   *   SqlBackupRunsGetRequest request =
   *       SqlBackupRunsGetRequest.newBuilder()
   *           .setId(3355)
   *           .setInstance("instance555127957")
   *           .setProject("project-309310695")
   *           .build();
   *   ApiFuture<BackupRun> future = sqlBackupRunsServiceClient.getCallable().futureCall(request);
   *   // Do something.
   *   BackupRun response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SqlBackupRunsGetRequest, BackupRun> getCallable() {
    return stub.getCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new backup run on demand.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SqlBackupRunsServiceClient sqlBackupRunsServiceClient =
   *     SqlBackupRunsServiceClient.create()) {
   *   SqlBackupRunsInsertRequest request =
   *       SqlBackupRunsInsertRequest.newBuilder()
   *           .setInstance("instance555127957")
   *           .setProject("project-309310695")
   *           .setBody(BackupRun.newBuilder().build())
   *           .build();
   *   Operation response = sqlBackupRunsServiceClient.insert(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation insert(SqlBackupRunsInsertRequest request) {
    return insertCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new backup run on demand.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SqlBackupRunsServiceClient sqlBackupRunsServiceClient =
   *     SqlBackupRunsServiceClient.create()) {
   *   SqlBackupRunsInsertRequest request =
   *       SqlBackupRunsInsertRequest.newBuilder()
   *           .setInstance("instance555127957")
   *           .setProject("project-309310695")
   *           .setBody(BackupRun.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future = sqlBackupRunsServiceClient.insertCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SqlBackupRunsInsertRequest, Operation> insertCallable() {
    return stub.insertCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all backup runs associated with the project or a given instance and configuration in the
   * reverse chronological order of the backup initiation time.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SqlBackupRunsServiceClient sqlBackupRunsServiceClient =
   *     SqlBackupRunsServiceClient.create()) {
   *   SqlBackupRunsListRequest request =
   *       SqlBackupRunsListRequest.newBuilder()
   *           .setInstance("instance555127957")
   *           .setMaxResults(1128457243)
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .build();
   *   BackupRunsListResponse response = sqlBackupRunsServiceClient.list(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BackupRunsListResponse list(SqlBackupRunsListRequest request) {
    return listCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all backup runs associated with the project or a given instance and configuration in the
   * reverse chronological order of the backup initiation time.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SqlBackupRunsServiceClient sqlBackupRunsServiceClient =
   *     SqlBackupRunsServiceClient.create()) {
   *   SqlBackupRunsListRequest request =
   *       SqlBackupRunsListRequest.newBuilder()
   *           .setInstance("instance555127957")
   *           .setMaxResults(1128457243)
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .build();
   *   ApiFuture<BackupRunsListResponse> future =
   *       sqlBackupRunsServiceClient.listCallable().futureCall(request);
   *   // Do something.
   *   BackupRunsListResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SqlBackupRunsListRequest, BackupRunsListResponse> listCallable() {
    return stub.listCallable();
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
