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

package com.google.cloud.visionai.v1;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.visionai.v1.stub.HealthCheckServiceStub;
import com.google.cloud.visionai.v1.stub.HealthCheckServiceStubSettings;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: HealthCheckService provides an interface for Vertex AI Vision Cluster Health
 * Check.
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
 * try (HealthCheckServiceClient healthCheckServiceClient = HealthCheckServiceClient.create()) {
 *   HealthCheckRequest request =
 *       HealthCheckRequest.newBuilder()
 *           .setCluster(ClusterName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]").toString())
 *           .build();
 *   HealthCheckResponse response = healthCheckServiceClient.healthCheck(request);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the HealthCheckServiceClient object to clean up resources
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
 *      <td><p> HealthCheck</td>
 *      <td><p> HealthCheck method checks the health status of the cluster.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> healthCheck(HealthCheckRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> healthCheckCallable()
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
 * <p>This class can be customized by passing in a custom instance of HealthCheckServiceSettings to
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
 * HealthCheckServiceSettings healthCheckServiceSettings =
 *     HealthCheckServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * HealthCheckServiceClient healthCheckServiceClient =
 *     HealthCheckServiceClient.create(healthCheckServiceSettings);
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
 * HealthCheckServiceSettings healthCheckServiceSettings =
 *     HealthCheckServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * HealthCheckServiceClient healthCheckServiceClient =
 *     HealthCheckServiceClient.create(healthCheckServiceSettings);
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
 * HealthCheckServiceSettings healthCheckServiceSettings =
 *     HealthCheckServiceSettings.newHttpJsonBuilder().build();
 * HealthCheckServiceClient healthCheckServiceClient =
 *     HealthCheckServiceClient.create(healthCheckServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class HealthCheckServiceClient implements BackgroundResource {
  private final HealthCheckServiceSettings settings;
  private final HealthCheckServiceStub stub;

  /** Constructs an instance of HealthCheckServiceClient with default settings. */
  public static final HealthCheckServiceClient create() throws IOException {
    return create(HealthCheckServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of HealthCheckServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final HealthCheckServiceClient create(HealthCheckServiceSettings settings)
      throws IOException {
    return new HealthCheckServiceClient(settings);
  }

  /**
   * Constructs an instance of HealthCheckServiceClient, using the given stub for making calls. This
   * is for advanced usage - prefer using create(HealthCheckServiceSettings).
   */
  public static final HealthCheckServiceClient create(HealthCheckServiceStub stub) {
    return new HealthCheckServiceClient(stub);
  }

  /**
   * Constructs an instance of HealthCheckServiceClient, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HealthCheckServiceClient(HealthCheckServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((HealthCheckServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected HealthCheckServiceClient(HealthCheckServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final HealthCheckServiceSettings getSettings() {
    return settings;
  }

  public HealthCheckServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * HealthCheck method checks the health status of the cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HealthCheckServiceClient healthCheckServiceClient = HealthCheckServiceClient.create()) {
   *   HealthCheckRequest request =
   *       HealthCheckRequest.newBuilder()
   *           .setCluster(ClusterName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]").toString())
   *           .build();
   *   HealthCheckResponse response = healthCheckServiceClient.healthCheck(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final HealthCheckResponse healthCheck(HealthCheckRequest request) {
    return healthCheckCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * HealthCheck method checks the health status of the cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HealthCheckServiceClient healthCheckServiceClient = HealthCheckServiceClient.create()) {
   *   HealthCheckRequest request =
   *       HealthCheckRequest.newBuilder()
   *           .setCluster(ClusterName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]").toString())
   *           .build();
   *   ApiFuture<HealthCheckResponse> future =
   *       healthCheckServiceClient.healthCheckCallable().futureCall(request);
   *   // Do something.
   *   HealthCheckResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<HealthCheckRequest, HealthCheckResponse> healthCheckCallable() {
    return stub.healthCheckCallable();
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
