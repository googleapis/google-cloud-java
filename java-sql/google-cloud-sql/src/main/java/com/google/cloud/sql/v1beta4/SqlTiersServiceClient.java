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
import com.google.cloud.sql.v1beta4.stub.SqlTiersServiceStub;
import com.google.cloud.sql.v1beta4.stub.SqlTiersServiceStubSettings;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Service for providing machine types (tiers) for Cloud SQL.
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
 * try (SqlTiersServiceClient sqlTiersServiceClient = SqlTiersServiceClient.create()) {
 *   SqlTiersListRequest request =
 *       SqlTiersListRequest.newBuilder().setProject("project-309310695").build();
 *   TiersListResponse response = sqlTiersServiceClient.list(request);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the SqlTiersServiceClient object to clean up resources
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
 *      <td><p> List</td>
 *      <td><p> Lists all available machine types (tiers) for Cloud SQL, for example, `db-custom-1-3840`. For related information, see [Pricing](/sql/pricing).</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> list(SqlTiersListRequest request)
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
 * <p>This class can be customized by passing in a custom instance of SqlTiersServiceSettings to
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
 * SqlTiersServiceSettings sqlTiersServiceSettings =
 *     SqlTiersServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * SqlTiersServiceClient sqlTiersServiceClient =
 *     SqlTiersServiceClient.create(sqlTiersServiceSettings);
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
 * SqlTiersServiceSettings sqlTiersServiceSettings =
 *     SqlTiersServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * SqlTiersServiceClient sqlTiersServiceClient =
 *     SqlTiersServiceClient.create(sqlTiersServiceSettings);
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
 * SqlTiersServiceSettings sqlTiersServiceSettings =
 *     SqlTiersServiceSettings.newHttpJsonBuilder().build();
 * SqlTiersServiceClient sqlTiersServiceClient =
 *     SqlTiersServiceClient.create(sqlTiersServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@NullMarked
@BetaApi
@Generated("by gapic-generator-java")
public class SqlTiersServiceClient implements BackgroundResource {
  private final @Nullable SqlTiersServiceSettings settings;
  private final SqlTiersServiceStub stub;

  /** Constructs an instance of SqlTiersServiceClient with default settings. */
  public static final SqlTiersServiceClient create() throws IOException {
    return create(SqlTiersServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of SqlTiersServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final SqlTiersServiceClient create(SqlTiersServiceSettings settings)
      throws IOException {
    return new SqlTiersServiceClient(settings);
  }

  /**
   * Constructs an instance of SqlTiersServiceClient, using the given stub for making calls. This is
   * for advanced usage - prefer using create(SqlTiersServiceSettings).
   */
  public static final SqlTiersServiceClient create(SqlTiersServiceStub stub) {
    return new SqlTiersServiceClient(stub);
  }

  /**
   * Constructs an instance of SqlTiersServiceClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected SqlTiersServiceClient(SqlTiersServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((SqlTiersServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected SqlTiersServiceClient(SqlTiersServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final @Nullable SqlTiersServiceSettings getSettings() {
    return settings;
  }

  public SqlTiersServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all available machine types (tiers) for Cloud SQL, for example, `db-custom-1-3840`. For
   * related information, see [Pricing](/sql/pricing).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SqlTiersServiceClient sqlTiersServiceClient = SqlTiersServiceClient.create()) {
   *   SqlTiersListRequest request =
   *       SqlTiersListRequest.newBuilder().setProject("project-309310695").build();
   *   TiersListResponse response = sqlTiersServiceClient.list(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TiersListResponse list(SqlTiersListRequest request) {
    return listCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all available machine types (tiers) for Cloud SQL, for example, `db-custom-1-3840`. For
   * related information, see [Pricing](/sql/pricing).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SqlTiersServiceClient sqlTiersServiceClient = SqlTiersServiceClient.create()) {
   *   SqlTiersListRequest request =
   *       SqlTiersListRequest.newBuilder().setProject("project-309310695").build();
   *   ApiFuture<TiersListResponse> future =
   *       sqlTiersServiceClient.listCallable().futureCall(request);
   *   // Do something.
   *   TiersListResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SqlTiersListRequest, TiersListResponse> listCallable() {
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
