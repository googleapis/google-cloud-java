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
import com.google.cloud.sql.v1beta4.stub.SqlConnectServiceStub;
import com.google.cloud.sql.v1beta4.stub.SqlConnectServiceStubSettings;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Cloud SQL connect service.
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
 * try (SqlConnectServiceClient sqlConnectServiceClient = SqlConnectServiceClient.create()) {
 *   GetConnectSettingsRequest request =
 *       GetConnectSettingsRequest.newBuilder()
 *           .setInstance("instance555127957")
 *           .setProject("project-309310695")
 *           .setReadTime(Timestamp.newBuilder().build())
 *           .build();
 *   ConnectSettings response = sqlConnectServiceClient.getConnectSettings(request);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the SqlConnectServiceClient object to clean up resources
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
 *      <td><p> GetConnectSettings</td>
 *      <td><p> Retrieves connect settings about a Cloud SQL instance.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getConnectSettings(GetConnectSettingsRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getConnectSettingsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ResolveConnectSettings</td>
 *      <td><p> Retrieves connect settings about a Cloud SQL instance using the instance DNS name.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> resolveConnectSettings(ResolveConnectSettingsRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> resolveConnectSettingsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GenerateEphemeralCert</td>
 *      <td><p> Generates a short-lived X509 certificate containing the provided public key and signed by a private key specific to the target instance. Users may use the certificate to authenticate as themselves when connecting to the database.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> generateEphemeralCert(GenerateEphemeralCertRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> generateEphemeralCertCallable()
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
 * <p>This class can be customized by passing in a custom instance of SqlConnectServiceSettings to
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
 * SqlConnectServiceSettings sqlConnectServiceSettings =
 *     SqlConnectServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * SqlConnectServiceClient sqlConnectServiceClient =
 *     SqlConnectServiceClient.create(sqlConnectServiceSettings);
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
 * SqlConnectServiceSettings sqlConnectServiceSettings =
 *     SqlConnectServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * SqlConnectServiceClient sqlConnectServiceClient =
 *     SqlConnectServiceClient.create(sqlConnectServiceSettings);
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
 * SqlConnectServiceSettings sqlConnectServiceSettings =
 *     SqlConnectServiceSettings.newHttpJsonBuilder().build();
 * SqlConnectServiceClient sqlConnectServiceClient =
 *     SqlConnectServiceClient.create(sqlConnectServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@NullMarked
@BetaApi
@Generated("by gapic-generator-java")
public class SqlConnectServiceClient implements BackgroundResource {
  private final @Nullable SqlConnectServiceSettings settings;
  private final SqlConnectServiceStub stub;

  /** Constructs an instance of SqlConnectServiceClient with default settings. */
  public static final SqlConnectServiceClient create() throws IOException {
    return create(SqlConnectServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of SqlConnectServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final SqlConnectServiceClient create(SqlConnectServiceSettings settings)
      throws IOException {
    return new SqlConnectServiceClient(settings);
  }

  /**
   * Constructs an instance of SqlConnectServiceClient, using the given stub for making calls. This
   * is for advanced usage - prefer using create(SqlConnectServiceSettings).
   */
  public static final SqlConnectServiceClient create(SqlConnectServiceStub stub) {
    return new SqlConnectServiceClient(stub);
  }

  /**
   * Constructs an instance of SqlConnectServiceClient, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected SqlConnectServiceClient(SqlConnectServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((SqlConnectServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected SqlConnectServiceClient(SqlConnectServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final @Nullable SqlConnectServiceSettings getSettings() {
    return settings;
  }

  public SqlConnectServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves connect settings about a Cloud SQL instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SqlConnectServiceClient sqlConnectServiceClient = SqlConnectServiceClient.create()) {
   *   GetConnectSettingsRequest request =
   *       GetConnectSettingsRequest.newBuilder()
   *           .setInstance("instance555127957")
   *           .setProject("project-309310695")
   *           .setReadTime(Timestamp.newBuilder().build())
   *           .build();
   *   ConnectSettings response = sqlConnectServiceClient.getConnectSettings(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ConnectSettings getConnectSettings(GetConnectSettingsRequest request) {
    return getConnectSettingsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves connect settings about a Cloud SQL instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SqlConnectServiceClient sqlConnectServiceClient = SqlConnectServiceClient.create()) {
   *   GetConnectSettingsRequest request =
   *       GetConnectSettingsRequest.newBuilder()
   *           .setInstance("instance555127957")
   *           .setProject("project-309310695")
   *           .setReadTime(Timestamp.newBuilder().build())
   *           .build();
   *   ApiFuture<ConnectSettings> future =
   *       sqlConnectServiceClient.getConnectSettingsCallable().futureCall(request);
   *   // Do something.
   *   ConnectSettings response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetConnectSettingsRequest, ConnectSettings>
      getConnectSettingsCallable() {
    return stub.getConnectSettingsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves connect settings about a Cloud SQL instance using the instance DNS name.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SqlConnectServiceClient sqlConnectServiceClient = SqlConnectServiceClient.create()) {
   *   ResolveConnectSettingsRequest request =
   *       ResolveConnectSettingsRequest.newBuilder()
   *           .setDnsName("dnsName1813886804")
   *           .setLocation("location1901043637")
   *           .build();
   *   ConnectSettings response = sqlConnectServiceClient.resolveConnectSettings(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ConnectSettings resolveConnectSettings(ResolveConnectSettingsRequest request) {
    return resolveConnectSettingsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves connect settings about a Cloud SQL instance using the instance DNS name.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SqlConnectServiceClient sqlConnectServiceClient = SqlConnectServiceClient.create()) {
   *   ResolveConnectSettingsRequest request =
   *       ResolveConnectSettingsRequest.newBuilder()
   *           .setDnsName("dnsName1813886804")
   *           .setLocation("location1901043637")
   *           .build();
   *   ApiFuture<ConnectSettings> future =
   *       sqlConnectServiceClient.resolveConnectSettingsCallable().futureCall(request);
   *   // Do something.
   *   ConnectSettings response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ResolveConnectSettingsRequest, ConnectSettings>
      resolveConnectSettingsCallable() {
    return stub.resolveConnectSettingsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Generates a short-lived X509 certificate containing the provided public key and signed by a
   * private key specific to the target instance. Users may use the certificate to authenticate as
   * themselves when connecting to the database.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SqlConnectServiceClient sqlConnectServiceClient = SqlConnectServiceClient.create()) {
   *   GenerateEphemeralCertRequest request =
   *       GenerateEphemeralCertRequest.newBuilder()
   *           .setInstance("instance555127957")
   *           .setProject("project-309310695")
   *           .setPublicKey("publicKey1446899510")
   *           .setAccessToken("accessToken-1042689291")
   *           .setReadTime(Timestamp.newBuilder().build())
   *           .setValidDuration(Duration.newBuilder().build())
   *           .build();
   *   GenerateEphemeralCertResponse response =
   *       sqlConnectServiceClient.generateEphemeralCert(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GenerateEphemeralCertResponse generateEphemeralCert(
      GenerateEphemeralCertRequest request) {
    return generateEphemeralCertCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Generates a short-lived X509 certificate containing the provided public key and signed by a
   * private key specific to the target instance. Users may use the certificate to authenticate as
   * themselves when connecting to the database.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SqlConnectServiceClient sqlConnectServiceClient = SqlConnectServiceClient.create()) {
   *   GenerateEphemeralCertRequest request =
   *       GenerateEphemeralCertRequest.newBuilder()
   *           .setInstance("instance555127957")
   *           .setProject("project-309310695")
   *           .setPublicKey("publicKey1446899510")
   *           .setAccessToken("accessToken-1042689291")
   *           .setReadTime(Timestamp.newBuilder().build())
   *           .setValidDuration(Duration.newBuilder().build())
   *           .build();
   *   ApiFuture<GenerateEphemeralCertResponse> future =
   *       sqlConnectServiceClient.generateEphemeralCertCallable().futureCall(request);
   *   // Do something.
   *   GenerateEphemeralCertResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GenerateEphemeralCertRequest, GenerateEphemeralCertResponse>
      generateEphemeralCertCallable() {
    return stub.generateEphemeralCertCallable();
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
