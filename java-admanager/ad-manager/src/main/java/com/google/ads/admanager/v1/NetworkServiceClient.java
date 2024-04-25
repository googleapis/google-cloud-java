/*
 * Copyright 2024 Google LLC
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

import com.google.ads.admanager.v1.stub.NetworkServiceStub;
import com.google.ads.admanager.v1.stub.NetworkServiceStubSettings;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Provides methods for handling Network objects.
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
 * try (NetworkServiceClient networkServiceClient = NetworkServiceClient.create()) {
 *   NetworkName name = NetworkName.of("[NETWORK_CODE]");
 *   Network response = networkServiceClient.getNetwork(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the NetworkServiceClient object to clean up resources such
 * as threads. In the example above, try-with-resources is used, which automatically calls close().
 *
 * <table>
 *    <caption>Methods</caption>
 *    <tr>
 *      <th>Method</th>
 *      <th>Description</th>
 *      <th>Method Variants</th>
 *    </tr>
 *    <tr>
 *      <td><p> GetNetwork</td>
 *      <td><p> API to retrieve a Network object.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getNetwork(GetNetworkRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getNetwork(NetworkName name)
 *           <li><p> getNetwork(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getNetworkCallable()
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
 * <p>This class can be customized by passing in a custom instance of NetworkServiceSettings to
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
 * NetworkServiceSettings networkServiceSettings =
 *     NetworkServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * NetworkServiceClient networkServiceClient = NetworkServiceClient.create(networkServiceSettings);
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
 * NetworkServiceSettings networkServiceSettings =
 *     NetworkServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * NetworkServiceClient networkServiceClient = NetworkServiceClient.create(networkServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class NetworkServiceClient implements BackgroundResource {
  private final NetworkServiceSettings settings;
  private final NetworkServiceStub stub;

  /** Constructs an instance of NetworkServiceClient with default settings. */
  public static final NetworkServiceClient create() throws IOException {
    return create(NetworkServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of NetworkServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final NetworkServiceClient create(NetworkServiceSettings settings)
      throws IOException {
    return new NetworkServiceClient(settings);
  }

  /**
   * Constructs an instance of NetworkServiceClient, using the given stub for making calls. This is
   * for advanced usage - prefer using create(NetworkServiceSettings).
   */
  public static final NetworkServiceClient create(NetworkServiceStub stub) {
    return new NetworkServiceClient(stub);
  }

  /**
   * Constructs an instance of NetworkServiceClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected NetworkServiceClient(NetworkServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((NetworkServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected NetworkServiceClient(NetworkServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final NetworkServiceSettings getSettings() {
    return settings;
  }

  public NetworkServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a Network object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServiceClient networkServiceClient = NetworkServiceClient.create()) {
   *   NetworkName name = NetworkName.of("[NETWORK_CODE]");
   *   Network response = networkServiceClient.getNetwork(name);
   * }
   * }</pre>
   *
   * @param name Required. Resource name of Network. Format: networks/{network_code}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Network getNetwork(NetworkName name) {
    GetNetworkRequest request =
        GetNetworkRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getNetwork(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a Network object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServiceClient networkServiceClient = NetworkServiceClient.create()) {
   *   String name = NetworkName.of("[NETWORK_CODE]").toString();
   *   Network response = networkServiceClient.getNetwork(name);
   * }
   * }</pre>
   *
   * @param name Required. Resource name of Network. Format: networks/{network_code}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Network getNetwork(String name) {
    GetNetworkRequest request = GetNetworkRequest.newBuilder().setName(name).build();
    return getNetwork(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a Network object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServiceClient networkServiceClient = NetworkServiceClient.create()) {
   *   GetNetworkRequest request =
   *       GetNetworkRequest.newBuilder()
   *           .setName(NetworkName.of("[NETWORK_CODE]").toString())
   *           .build();
   *   Network response = networkServiceClient.getNetwork(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Network getNetwork(GetNetworkRequest request) {
    return getNetworkCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a Network object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServiceClient networkServiceClient = NetworkServiceClient.create()) {
   *   GetNetworkRequest request =
   *       GetNetworkRequest.newBuilder()
   *           .setName(NetworkName.of("[NETWORK_CODE]").toString())
   *           .build();
   *   ApiFuture<Network> future = networkServiceClient.getNetworkCallable().futureCall(request);
   *   // Do something.
   *   Network response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetNetworkRequest, Network> getNetworkCallable() {
    return stub.getNetworkCallable();
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
