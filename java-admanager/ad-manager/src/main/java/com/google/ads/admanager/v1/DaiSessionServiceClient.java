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

package com.google.ads.admanager.v1;

import com.google.ads.admanager.v1.stub.DaiSessionServiceStub;
import com.google.ads.admanager.v1.stub.DaiSessionServiceStubSettings;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Provides methods for handling `DaiSession` objects.
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
 * try (DaiSessionServiceClient daiSessionServiceClient = DaiSessionServiceClient.create()) {
 *   DaiSessionName name = DaiSessionName.of("[NETWORK_CODE]", "[DAI_SESSION]");
 *   DaiSession response = daiSessionServiceClient.getDaiSession(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the DaiSessionServiceClient object to clean up resources
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
 *      <td><p> GetDaiSession</td>
 *      <td><p> Retrieves a `DaiSession` object.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getDaiSession(GetDaiSessionRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getDaiSession(DaiSessionName name)
 *           <li><p> getDaiSession(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getDaiSessionCallable()
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
 * <p>This class can be customized by passing in a custom instance of DaiSessionServiceSettings to
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
 * DaiSessionServiceSettings daiSessionServiceSettings =
 *     DaiSessionServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * DaiSessionServiceClient daiSessionServiceClient =
 *     DaiSessionServiceClient.create(daiSessionServiceSettings);
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
 * DaiSessionServiceSettings daiSessionServiceSettings =
 *     DaiSessionServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * DaiSessionServiceClient daiSessionServiceClient =
 *     DaiSessionServiceClient.create(daiSessionServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@NullMarked
@Generated("by gapic-generator-java")
public class DaiSessionServiceClient implements BackgroundResource {
  private final @Nullable DaiSessionServiceSettings settings;
  private final DaiSessionServiceStub stub;

  /** Constructs an instance of DaiSessionServiceClient with default settings. */
  public static final DaiSessionServiceClient create() throws IOException {
    return create(DaiSessionServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of DaiSessionServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final DaiSessionServiceClient create(DaiSessionServiceSettings settings)
      throws IOException {
    return new DaiSessionServiceClient(settings);
  }

  /**
   * Constructs an instance of DaiSessionServiceClient, using the given stub for making calls. This
   * is for advanced usage - prefer using create(DaiSessionServiceSettings).
   */
  public static final DaiSessionServiceClient create(DaiSessionServiceStub stub) {
    return new DaiSessionServiceClient(stub);
  }

  /**
   * Constructs an instance of DaiSessionServiceClient, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected DaiSessionServiceClient(DaiSessionServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((DaiSessionServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected DaiSessionServiceClient(DaiSessionServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final @Nullable DaiSessionServiceSettings getSettings() {
    return settings;
  }

  public DaiSessionServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a `DaiSession` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DaiSessionServiceClient daiSessionServiceClient = DaiSessionServiceClient.create()) {
   *   DaiSessionName name = DaiSessionName.of("[NETWORK_CODE]", "[DAI_SESSION]");
   *   DaiSession response = daiSessionServiceClient.getDaiSession(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the DaiSession. The dai_session can be either the
   *     session ID or debug key, that DAI returns on stream create. For details, see [Locate a DAI
   *     session ID or debug key](https://support.google.com/admanager/answer/7257678).
   *     <p>Format: `networks/{network_code}/daiSessions/{dai_session}` Format:
   *     `networks/{network_code}/daiSessions/{session_id}` Format:
   *     `networks/{network_code}/daiSessions/{debug_key}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DaiSession getDaiSession(@Nullable DaiSessionName name) {
    GetDaiSessionRequest request =
        GetDaiSessionRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getDaiSession(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a `DaiSession` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DaiSessionServiceClient daiSessionServiceClient = DaiSessionServiceClient.create()) {
   *   String name = DaiSessionName.of("[NETWORK_CODE]", "[DAI_SESSION]").toString();
   *   DaiSession response = daiSessionServiceClient.getDaiSession(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the DaiSession. The dai_session can be either the
   *     session ID or debug key, that DAI returns on stream create. For details, see [Locate a DAI
   *     session ID or debug key](https://support.google.com/admanager/answer/7257678).
   *     <p>Format: `networks/{network_code}/daiSessions/{dai_session}` Format:
   *     `networks/{network_code}/daiSessions/{session_id}` Format:
   *     `networks/{network_code}/daiSessions/{debug_key}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DaiSession getDaiSession(String name) {
    GetDaiSessionRequest request = GetDaiSessionRequest.newBuilder().setName(name).build();
    return getDaiSession(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a `DaiSession` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DaiSessionServiceClient daiSessionServiceClient = DaiSessionServiceClient.create()) {
   *   GetDaiSessionRequest request =
   *       GetDaiSessionRequest.newBuilder()
   *           .setName(DaiSessionName.of("[NETWORK_CODE]", "[DAI_SESSION]").toString())
   *           .build();
   *   DaiSession response = daiSessionServiceClient.getDaiSession(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DaiSession getDaiSession(GetDaiSessionRequest request) {
    return getDaiSessionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a `DaiSession` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DaiSessionServiceClient daiSessionServiceClient = DaiSessionServiceClient.create()) {
   *   GetDaiSessionRequest request =
   *       GetDaiSessionRequest.newBuilder()
   *           .setName(DaiSessionName.of("[NETWORK_CODE]", "[DAI_SESSION]").toString())
   *           .build();
   *   ApiFuture<DaiSession> future =
   *       daiSessionServiceClient.getDaiSessionCallable().futureCall(request);
   *   // Do something.
   *   DaiSession response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetDaiSessionRequest, DaiSession> getDaiSessionCallable() {
    return stub.getDaiSessionCallable();
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
