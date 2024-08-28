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

package com.google.cloud.gkeconnect.gateway.v1;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.gkeconnect.gateway.v1.stub.GatewayControlStub;
import com.google.cloud.gkeconnect.gateway.v1.stub.GatewayControlStubSettings;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: GatewayControl is the control plane API for Connect Gateway.
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
 * try (GatewayControlClient gatewayControlClient = GatewayControlClient.create()) {
 *   GenerateCredentialsRequest request =
 *       GenerateCredentialsRequest.newBuilder()
 *           .setName("name3373707")
 *           .setForceUseAgent(true)
 *           .setVersion("version351608024")
 *           .setKubernetesNamespace("kubernetesNamespace-1862862667")
 *           .build();
 *   GenerateCredentialsResponse response = gatewayControlClient.generateCredentials(request);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the GatewayControlClient object to clean up resources such
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
 *      <td><p> GenerateCredentials</td>
 *      <td><p> GenerateCredentials provides connection information that allows a user to access the specified membership using Connect Gateway.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> generateCredentials(GenerateCredentialsRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> generateCredentialsCallable()
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
 * <p>This class can be customized by passing in a custom instance of GatewayControlSettings to
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
 * GatewayControlSettings gatewayControlSettings =
 *     GatewayControlSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * GatewayControlClient gatewayControlClient = GatewayControlClient.create(gatewayControlSettings);
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
 * GatewayControlSettings gatewayControlSettings =
 *     GatewayControlSettings.newBuilder().setEndpoint(myEndpoint).build();
 * GatewayControlClient gatewayControlClient = GatewayControlClient.create(gatewayControlSettings);
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
 * GatewayControlSettings gatewayControlSettings =
 *     GatewayControlSettings.newHttpJsonBuilder().build();
 * GatewayControlClient gatewayControlClient = GatewayControlClient.create(gatewayControlSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class GatewayControlClient implements BackgroundResource {
  private final GatewayControlSettings settings;
  private final GatewayControlStub stub;

  /** Constructs an instance of GatewayControlClient with default settings. */
  public static final GatewayControlClient create() throws IOException {
    return create(GatewayControlSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of GatewayControlClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final GatewayControlClient create(GatewayControlSettings settings)
      throws IOException {
    return new GatewayControlClient(settings);
  }

  /**
   * Constructs an instance of GatewayControlClient, using the given stub for making calls. This is
   * for advanced usage - prefer using create(GatewayControlSettings).
   */
  public static final GatewayControlClient create(GatewayControlStub stub) {
    return new GatewayControlClient(stub);
  }

  /**
   * Constructs an instance of GatewayControlClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GatewayControlClient(GatewayControlSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((GatewayControlStubSettings) settings.getStubSettings()).createStub();
  }

  protected GatewayControlClient(GatewayControlStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final GatewayControlSettings getSettings() {
    return settings;
  }

  public GatewayControlStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * GenerateCredentials provides connection information that allows a user to access the specified
   * membership using Connect Gateway.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GatewayControlClient gatewayControlClient = GatewayControlClient.create()) {
   *   GenerateCredentialsRequest request =
   *       GenerateCredentialsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setForceUseAgent(true)
   *           .setVersion("version351608024")
   *           .setKubernetesNamespace("kubernetesNamespace-1862862667")
   *           .build();
   *   GenerateCredentialsResponse response = gatewayControlClient.generateCredentials(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GenerateCredentialsResponse generateCredentials(GenerateCredentialsRequest request) {
    return generateCredentialsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * GenerateCredentials provides connection information that allows a user to access the specified
   * membership using Connect Gateway.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GatewayControlClient gatewayControlClient = GatewayControlClient.create()) {
   *   GenerateCredentialsRequest request =
   *       GenerateCredentialsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setForceUseAgent(true)
   *           .setVersion("version351608024")
   *           .setKubernetesNamespace("kubernetesNamespace-1862862667")
   *           .build();
   *   ApiFuture<GenerateCredentialsResponse> future =
   *       gatewayControlClient.generateCredentialsCallable().futureCall(request);
   *   // Do something.
   *   GenerateCredentialsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GenerateCredentialsRequest, GenerateCredentialsResponse>
      generateCredentialsCallable() {
    return stub.generateCredentialsCallable();
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
