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

package com.google.cloud.run.v2;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.run.v2.stub.BuildsStub;
import com.google.cloud.run.v2.stub.BuildsStubSettings;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Cloud Run Build Control Plane API
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
 * try (BuildsClient buildsClient = BuildsClient.create()) {
 *   SubmitBuildRequest request =
 *       SubmitBuildRequest.newBuilder()
 *           .setParent("parent-995424086")
 *           .setImageUri("imageUri-859610607")
 *           .setServiceAccount("serviceAccount1079137720")
 *           .setWorkerPool(
 *               WorkerPoolName.of("[PROJECT]", "[LOCATION]", "[WORKER_POOL]").toString())
 *           .addAllTags(new ArrayList<String>())
 *           .build();
 *   SubmitBuildResponse response = buildsClient.submitBuild(request);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the BuildsClient object to clean up resources such as
 * threads. In the example above, try-with-resources is used, which automatically calls close().
 *
 * <table>
 *    <caption>Methods</caption>
 *    <tr>
 *      <th>Method</th>
 *      <th>Description</th>
 *      <th>Method Variants</th>
 *    </tr>
 *    <tr>
 *      <td><p> SubmitBuild</td>
 *      <td><p> Submits a build in a given project.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> submitBuild(SubmitBuildRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> submitBuildCallable()
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
 * <p>This class can be customized by passing in a custom instance of BuildsSettings to create().
 * For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * BuildsSettings buildsSettings =
 *     BuildsSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * BuildsClient buildsClient = BuildsClient.create(buildsSettings);
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
 * BuildsSettings buildsSettings = BuildsSettings.newBuilder().setEndpoint(myEndpoint).build();
 * BuildsClient buildsClient = BuildsClient.create(buildsSettings);
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
 * BuildsSettings buildsSettings = BuildsSettings.newHttpJsonBuilder().build();
 * BuildsClient buildsClient = BuildsClient.create(buildsSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class BuildsClient implements BackgroundResource {
  private final BuildsSettings settings;
  private final BuildsStub stub;

  /** Constructs an instance of BuildsClient with default settings. */
  public static final BuildsClient create() throws IOException {
    return create(BuildsSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of BuildsClient, using the given settings. The channels are created
   * based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final BuildsClient create(BuildsSettings settings) throws IOException {
    return new BuildsClient(settings);
  }

  /**
   * Constructs an instance of BuildsClient, using the given stub for making calls. This is for
   * advanced usage - prefer using create(BuildsSettings).
   */
  public static final BuildsClient create(BuildsStub stub) {
    return new BuildsClient(stub);
  }

  /**
   * Constructs an instance of BuildsClient, using the given settings. This is protected so that it
   * is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected BuildsClient(BuildsSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((BuildsStubSettings) settings.getStubSettings()).createStub();
  }

  protected BuildsClient(BuildsStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final BuildsSettings getSettings() {
    return settings;
  }

  public BuildsStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Submits a build in a given project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BuildsClient buildsClient = BuildsClient.create()) {
   *   SubmitBuildRequest request =
   *       SubmitBuildRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setImageUri("imageUri-859610607")
   *           .setServiceAccount("serviceAccount1079137720")
   *           .setWorkerPool(
   *               WorkerPoolName.of("[PROJECT]", "[LOCATION]", "[WORKER_POOL]").toString())
   *           .addAllTags(new ArrayList<String>())
   *           .build();
   *   SubmitBuildResponse response = buildsClient.submitBuild(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SubmitBuildResponse submitBuild(SubmitBuildRequest request) {
    return submitBuildCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Submits a build in a given project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BuildsClient buildsClient = BuildsClient.create()) {
   *   SubmitBuildRequest request =
   *       SubmitBuildRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setImageUri("imageUri-859610607")
   *           .setServiceAccount("serviceAccount1079137720")
   *           .setWorkerPool(
   *               WorkerPoolName.of("[PROJECT]", "[LOCATION]", "[WORKER_POOL]").toString())
   *           .addAllTags(new ArrayList<String>())
   *           .build();
   *   ApiFuture<SubmitBuildResponse> future =
   *       buildsClient.submitBuildCallable().futureCall(request);
   *   // Do something.
   *   SubmitBuildResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SubmitBuildRequest, SubmitBuildResponse> submitBuildCallable() {
    return stub.submitBuildCallable();
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
