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
import com.google.cloud.sql.v1.stub.SqlOperationsServiceStub;
import com.google.cloud.sql.v1.stub.SqlOperationsServiceStubSettings;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Service to fetch operations for database instances.
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
 * try (SqlOperationsServiceClient sqlOperationsServiceClient =
 *     SqlOperationsServiceClient.create()) {
 *   SqlOperationsGetRequest request =
 *       SqlOperationsGetRequest.newBuilder()
 *           .setOperation("operation1662702951")
 *           .setProject("project-309310695")
 *           .setLocation("location1901043637")
 *           .build();
 *   Operation response = sqlOperationsServiceClient.get(request);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the SqlOperationsServiceClient object to clean up
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
 *      <td><p> Get</td>
 *      <td><p> Retrieves an instance operation that has been performed on an instance.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> get(SqlOperationsGetRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> List</td>
 *      <td><p> Lists all instance operations that have been performed on the given Cloud SQL instance in the reverse chronological order of the start time.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> list(SqlOperationsListRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> Cancel</td>
 *      <td><p> Cancels an instance operation that has been performed on an instance.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> cancel(SqlOperationsCancelRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> cancelCallable()
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
 * <p>This class can be customized by passing in a custom instance of SqlOperationsServiceSettings
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
 * SqlOperationsServiceSettings sqlOperationsServiceSettings =
 *     SqlOperationsServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * SqlOperationsServiceClient sqlOperationsServiceClient =
 *     SqlOperationsServiceClient.create(sqlOperationsServiceSettings);
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
 * SqlOperationsServiceSettings sqlOperationsServiceSettings =
 *     SqlOperationsServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * SqlOperationsServiceClient sqlOperationsServiceClient =
 *     SqlOperationsServiceClient.create(sqlOperationsServiceSettings);
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
 * SqlOperationsServiceSettings sqlOperationsServiceSettings =
 *     SqlOperationsServiceSettings.newHttpJsonBuilder().build();
 * SqlOperationsServiceClient sqlOperationsServiceClient =
 *     SqlOperationsServiceClient.create(sqlOperationsServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@NullMarked
@Generated("by gapic-generator-java")
public class SqlOperationsServiceClient implements BackgroundResource {
  private final @Nullable SqlOperationsServiceSettings settings;
  private final SqlOperationsServiceStub stub;

  /** Constructs an instance of SqlOperationsServiceClient with default settings. */
  public static final SqlOperationsServiceClient create() throws IOException {
    return create(SqlOperationsServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of SqlOperationsServiceClient, using the given settings. The channels
   * are created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final SqlOperationsServiceClient create(SqlOperationsServiceSettings settings)
      throws IOException {
    return new SqlOperationsServiceClient(settings);
  }

  /**
   * Constructs an instance of SqlOperationsServiceClient, using the given stub for making calls.
   * This is for advanced usage - prefer using create(SqlOperationsServiceSettings).
   */
  public static final SqlOperationsServiceClient create(SqlOperationsServiceStub stub) {
    return new SqlOperationsServiceClient(stub);
  }

  /**
   * Constructs an instance of SqlOperationsServiceClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected SqlOperationsServiceClient(SqlOperationsServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((SqlOperationsServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected SqlOperationsServiceClient(SqlOperationsServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final @Nullable SqlOperationsServiceSettings getSettings() {
    return settings;
  }

  public SqlOperationsServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves an instance operation that has been performed on an instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SqlOperationsServiceClient sqlOperationsServiceClient =
   *     SqlOperationsServiceClient.create()) {
   *   SqlOperationsGetRequest request =
   *       SqlOperationsGetRequest.newBuilder()
   *           .setOperation("operation1662702951")
   *           .setProject("project-309310695")
   *           .setLocation("location1901043637")
   *           .build();
   *   Operation response = sqlOperationsServiceClient.get(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation get(SqlOperationsGetRequest request) {
    return getCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves an instance operation that has been performed on an instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SqlOperationsServiceClient sqlOperationsServiceClient =
   *     SqlOperationsServiceClient.create()) {
   *   SqlOperationsGetRequest request =
   *       SqlOperationsGetRequest.newBuilder()
   *           .setOperation("operation1662702951")
   *           .setProject("project-309310695")
   *           .setLocation("location1901043637")
   *           .build();
   *   ApiFuture<Operation> future = sqlOperationsServiceClient.getCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SqlOperationsGetRequest, Operation> getCallable() {
    return stub.getCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all instance operations that have been performed on the given Cloud SQL instance in the
   * reverse chronological order of the start time.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SqlOperationsServiceClient sqlOperationsServiceClient =
   *     SqlOperationsServiceClient.create()) {
   *   SqlOperationsListRequest request =
   *       SqlOperationsListRequest.newBuilder()
   *           .setInstance("instance555127957")
   *           .setMaxResults(1128457243)
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setLocation("location1901043637")
   *           .build();
   *   OperationsListResponse response = sqlOperationsServiceClient.list(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationsListResponse list(SqlOperationsListRequest request) {
    return listCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all instance operations that have been performed on the given Cloud SQL instance in the
   * reverse chronological order of the start time.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SqlOperationsServiceClient sqlOperationsServiceClient =
   *     SqlOperationsServiceClient.create()) {
   *   SqlOperationsListRequest request =
   *       SqlOperationsListRequest.newBuilder()
   *           .setInstance("instance555127957")
   *           .setMaxResults(1128457243)
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setLocation("location1901043637")
   *           .build();
   *   ApiFuture<OperationsListResponse> future =
   *       sqlOperationsServiceClient.listCallable().futureCall(request);
   *   // Do something.
   *   OperationsListResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SqlOperationsListRequest, OperationsListResponse> listCallable() {
    return stub.listCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Cancels an instance operation that has been performed on an instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SqlOperationsServiceClient sqlOperationsServiceClient =
   *     SqlOperationsServiceClient.create()) {
   *   SqlOperationsCancelRequest request =
   *       SqlOperationsCancelRequest.newBuilder()
   *           .setOperation("operation1662702951")
   *           .setProject("project-309310695")
   *           .setLocation("location1901043637")
   *           .build();
   *   sqlOperationsServiceClient.cancel(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void cancel(SqlOperationsCancelRequest request) {
    cancelCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Cancels an instance operation that has been performed on an instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SqlOperationsServiceClient sqlOperationsServiceClient =
   *     SqlOperationsServiceClient.create()) {
   *   SqlOperationsCancelRequest request =
   *       SqlOperationsCancelRequest.newBuilder()
   *           .setOperation("operation1662702951")
   *           .setProject("project-309310695")
   *           .setLocation("location1901043637")
   *           .build();
   *   ApiFuture<Empty> future = sqlOperationsServiceClient.cancelCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SqlOperationsCancelRequest, Empty> cancelCallable() {
    return stub.cancelCallable();
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
