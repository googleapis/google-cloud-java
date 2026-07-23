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
import com.google.cloud.sql.v1beta4.stub.SqlSslCertsServiceStub;
import com.google.cloud.sql.v1beta4.stub.SqlSslCertsServiceStubSettings;
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
 * try (SqlSslCertsServiceClient sqlSslCertsServiceClient = SqlSslCertsServiceClient.create()) {
 *   SqlSslCertsDeleteRequest request =
 *       SqlSslCertsDeleteRequest.newBuilder()
 *           .setInstance("instance555127957")
 *           .setProject("project-309310695")
 *           .setSha1Fingerprint("sha1Fingerprint163009183")
 *           .build();
 *   Operation response = sqlSslCertsServiceClient.delete(request);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the SqlSslCertsServiceClient object to clean up resources
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
 *      <td><p> Deletes the SSL certificate. For First Generation instances, the certificate remains valid until the instance is restarted.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> delete(SqlSslCertsDeleteRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> Get</td>
 *      <td><p> Retrieves a particular SSL certificate.  Does not include the private key (required for usage).  The private key must be saved from the response to initial creation.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> get(SqlSslCertsGetRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> Insert</td>
 *      <td><p> Creates an SSL certificate and returns it along with the private key and server certificate authority.  The new certificate will not be usable until the instance is restarted.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> insert(SqlSslCertsInsertRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> insertCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> List</td>
 *      <td><p> Lists all of the current SSL certificates for the instance.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> list(SqlSslCertsListRequest request)
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
 * <p>This class can be customized by passing in a custom instance of SqlSslCertsServiceSettings to
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
 * SqlSslCertsServiceSettings sqlSslCertsServiceSettings =
 *     SqlSslCertsServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * SqlSslCertsServiceClient sqlSslCertsServiceClient =
 *     SqlSslCertsServiceClient.create(sqlSslCertsServiceSettings);
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
 * SqlSslCertsServiceSettings sqlSslCertsServiceSettings =
 *     SqlSslCertsServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * SqlSslCertsServiceClient sqlSslCertsServiceClient =
 *     SqlSslCertsServiceClient.create(sqlSslCertsServiceSettings);
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
 * SqlSslCertsServiceSettings sqlSslCertsServiceSettings =
 *     SqlSslCertsServiceSettings.newHttpJsonBuilder().build();
 * SqlSslCertsServiceClient sqlSslCertsServiceClient =
 *     SqlSslCertsServiceClient.create(sqlSslCertsServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@NullMarked
@BetaApi
@Generated("by gapic-generator-java")
public class SqlSslCertsServiceClient implements BackgroundResource {
  private final @Nullable SqlSslCertsServiceSettings settings;
  private final SqlSslCertsServiceStub stub;

  /** Constructs an instance of SqlSslCertsServiceClient with default settings. */
  public static final SqlSslCertsServiceClient create() throws IOException {
    return create(SqlSslCertsServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of SqlSslCertsServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final SqlSslCertsServiceClient create(SqlSslCertsServiceSettings settings)
      throws IOException {
    return new SqlSslCertsServiceClient(settings);
  }

  /**
   * Constructs an instance of SqlSslCertsServiceClient, using the given stub for making calls. This
   * is for advanced usage - prefer using create(SqlSslCertsServiceSettings).
   */
  public static final SqlSslCertsServiceClient create(SqlSslCertsServiceStub stub) {
    return new SqlSslCertsServiceClient(stub);
  }

  /**
   * Constructs an instance of SqlSslCertsServiceClient, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected SqlSslCertsServiceClient(SqlSslCertsServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((SqlSslCertsServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected SqlSslCertsServiceClient(SqlSslCertsServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final @Nullable SqlSslCertsServiceSettings getSettings() {
    return settings;
  }

  public SqlSslCertsServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the SSL certificate. For First Generation instances, the certificate remains valid
   * until the instance is restarted.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SqlSslCertsServiceClient sqlSslCertsServiceClient = SqlSslCertsServiceClient.create()) {
   *   SqlSslCertsDeleteRequest request =
   *       SqlSslCertsDeleteRequest.newBuilder()
   *           .setInstance("instance555127957")
   *           .setProject("project-309310695")
   *           .setSha1Fingerprint("sha1Fingerprint163009183")
   *           .build();
   *   Operation response = sqlSslCertsServiceClient.delete(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation delete(SqlSslCertsDeleteRequest request) {
    return deleteCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the SSL certificate. For First Generation instances, the certificate remains valid
   * until the instance is restarted.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SqlSslCertsServiceClient sqlSslCertsServiceClient = SqlSslCertsServiceClient.create()) {
   *   SqlSslCertsDeleteRequest request =
   *       SqlSslCertsDeleteRequest.newBuilder()
   *           .setInstance("instance555127957")
   *           .setProject("project-309310695")
   *           .setSha1Fingerprint("sha1Fingerprint163009183")
   *           .build();
   *   ApiFuture<Operation> future = sqlSslCertsServiceClient.deleteCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SqlSslCertsDeleteRequest, Operation> deleteCallable() {
    return stub.deleteCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a particular SSL certificate. Does not include the private key (required for usage).
   * The private key must be saved from the response to initial creation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SqlSslCertsServiceClient sqlSslCertsServiceClient = SqlSslCertsServiceClient.create()) {
   *   SqlSslCertsGetRequest request =
   *       SqlSslCertsGetRequest.newBuilder()
   *           .setInstance("instance555127957")
   *           .setProject("project-309310695")
   *           .setSha1Fingerprint("sha1Fingerprint163009183")
   *           .build();
   *   SslCert response = sqlSslCertsServiceClient.get(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SslCert get(SqlSslCertsGetRequest request) {
    return getCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a particular SSL certificate. Does not include the private key (required for usage).
   * The private key must be saved from the response to initial creation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SqlSslCertsServiceClient sqlSslCertsServiceClient = SqlSslCertsServiceClient.create()) {
   *   SqlSslCertsGetRequest request =
   *       SqlSslCertsGetRequest.newBuilder()
   *           .setInstance("instance555127957")
   *           .setProject("project-309310695")
   *           .setSha1Fingerprint("sha1Fingerprint163009183")
   *           .build();
   *   ApiFuture<SslCert> future = sqlSslCertsServiceClient.getCallable().futureCall(request);
   *   // Do something.
   *   SslCert response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SqlSslCertsGetRequest, SslCert> getCallable() {
    return stub.getCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an SSL certificate and returns it along with the private key and server certificate
   * authority. The new certificate will not be usable until the instance is restarted.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SqlSslCertsServiceClient sqlSslCertsServiceClient = SqlSslCertsServiceClient.create()) {
   *   SqlSslCertsInsertRequest request =
   *       SqlSslCertsInsertRequest.newBuilder()
   *           .setInstance("instance555127957")
   *           .setProject("project-309310695")
   *           .setBody(SslCertsInsertRequest.newBuilder().build())
   *           .build();
   *   SslCertsInsertResponse response = sqlSslCertsServiceClient.insert(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SslCertsInsertResponse insert(SqlSslCertsInsertRequest request) {
    return insertCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an SSL certificate and returns it along with the private key and server certificate
   * authority. The new certificate will not be usable until the instance is restarted.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SqlSslCertsServiceClient sqlSslCertsServiceClient = SqlSslCertsServiceClient.create()) {
   *   SqlSslCertsInsertRequest request =
   *       SqlSslCertsInsertRequest.newBuilder()
   *           .setInstance("instance555127957")
   *           .setProject("project-309310695")
   *           .setBody(SslCertsInsertRequest.newBuilder().build())
   *           .build();
   *   ApiFuture<SslCertsInsertResponse> future =
   *       sqlSslCertsServiceClient.insertCallable().futureCall(request);
   *   // Do something.
   *   SslCertsInsertResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SqlSslCertsInsertRequest, SslCertsInsertResponse> insertCallable() {
    return stub.insertCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all of the current SSL certificates for the instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SqlSslCertsServiceClient sqlSslCertsServiceClient = SqlSslCertsServiceClient.create()) {
   *   SqlSslCertsListRequest request =
   *       SqlSslCertsListRequest.newBuilder()
   *           .setInstance("instance555127957")
   *           .setProject("project-309310695")
   *           .build();
   *   SslCertsListResponse response = sqlSslCertsServiceClient.list(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SslCertsListResponse list(SqlSslCertsListRequest request) {
    return listCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all of the current SSL certificates for the instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SqlSslCertsServiceClient sqlSslCertsServiceClient = SqlSslCertsServiceClient.create()) {
   *   SqlSslCertsListRequest request =
   *       SqlSslCertsListRequest.newBuilder()
   *           .setInstance("instance555127957")
   *           .setProject("project-309310695")
   *           .build();
   *   ApiFuture<SslCertsListResponse> future =
   *       sqlSslCertsServiceClient.listCallable().futureCall(request);
   *   // Do something.
   *   SslCertsListResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SqlSslCertsListRequest, SslCertsListResponse> listCallable() {
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
