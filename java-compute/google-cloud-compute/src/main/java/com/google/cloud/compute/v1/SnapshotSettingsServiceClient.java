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

package com.google.cloud.compute.v1;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.longrunning.OperationFuture;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.compute.v1.stub.SnapshotSettingsServiceStub;
import com.google.cloud.compute.v1.stub.SnapshotSettingsServiceStubSettings;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: The SnapshotSettings API.
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
 * try (SnapshotSettingsServiceClient snapshotSettingsServiceClient =
 *     SnapshotSettingsServiceClient.create()) {
 *   String project = "project-309310695";
 *   SnapshotSettings response = snapshotSettingsServiceClient.get(project);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the SnapshotSettingsServiceClient object to clean up
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
 *      <td><p> Get snapshot settings.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> get(GetSnapshotSettingRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> get(String project)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> Patch</td>
 *      <td><p> Patch snapshot settings.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> patchAsync(PatchSnapshotSettingRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> patchAsync(String project, SnapshotSettings snapshotSettingsResource)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> patchOperationCallable()
 *           <li><p> patchCallable()
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
 * <p>This class can be customized by passing in a custom instance of
 * SnapshotSettingsServiceSettings to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * SnapshotSettingsServiceSettings snapshotSettingsServiceSettings =
 *     SnapshotSettingsServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * SnapshotSettingsServiceClient snapshotSettingsServiceClient =
 *     SnapshotSettingsServiceClient.create(snapshotSettingsServiceSettings);
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
 * SnapshotSettingsServiceSettings snapshotSettingsServiceSettings =
 *     SnapshotSettingsServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * SnapshotSettingsServiceClient snapshotSettingsServiceClient =
 *     SnapshotSettingsServiceClient.create(snapshotSettingsServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class SnapshotSettingsServiceClient implements BackgroundResource {
  private final SnapshotSettingsServiceSettings settings;
  private final SnapshotSettingsServiceStub stub;

  /** Constructs an instance of SnapshotSettingsServiceClient with default settings. */
  public static final SnapshotSettingsServiceClient create() throws IOException {
    return create(SnapshotSettingsServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of SnapshotSettingsServiceClient, using the given settings. The channels
   * are created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final SnapshotSettingsServiceClient create(SnapshotSettingsServiceSettings settings)
      throws IOException {
    return new SnapshotSettingsServiceClient(settings);
  }

  /**
   * Constructs an instance of SnapshotSettingsServiceClient, using the given stub for making calls.
   * This is for advanced usage - prefer using create(SnapshotSettingsServiceSettings).
   */
  public static final SnapshotSettingsServiceClient create(SnapshotSettingsServiceStub stub) {
    return new SnapshotSettingsServiceClient(stub);
  }

  /**
   * Constructs an instance of SnapshotSettingsServiceClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected SnapshotSettingsServiceClient(SnapshotSettingsServiceSettings settings)
      throws IOException {
    this.settings = settings;
    this.stub = ((SnapshotSettingsServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected SnapshotSettingsServiceClient(SnapshotSettingsServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final SnapshotSettingsServiceSettings getSettings() {
    return settings;
  }

  public SnapshotSettingsServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get snapshot settings.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SnapshotSettingsServiceClient snapshotSettingsServiceClient =
   *     SnapshotSettingsServiceClient.create()) {
   *   String project = "project-309310695";
   *   SnapshotSettings response = snapshotSettingsServiceClient.get(project);
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SnapshotSettings get(String project) {
    GetSnapshotSettingRequest request =
        GetSnapshotSettingRequest.newBuilder().setProject(project).build();
    return get(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get snapshot settings.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SnapshotSettingsServiceClient snapshotSettingsServiceClient =
   *     SnapshotSettingsServiceClient.create()) {
   *   GetSnapshotSettingRequest request =
   *       GetSnapshotSettingRequest.newBuilder().setProject("project-309310695").build();
   *   SnapshotSettings response = snapshotSettingsServiceClient.get(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SnapshotSettings get(GetSnapshotSettingRequest request) {
    return getCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get snapshot settings.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SnapshotSettingsServiceClient snapshotSettingsServiceClient =
   *     SnapshotSettingsServiceClient.create()) {
   *   GetSnapshotSettingRequest request =
   *       GetSnapshotSettingRequest.newBuilder().setProject("project-309310695").build();
   *   ApiFuture<SnapshotSettings> future =
   *       snapshotSettingsServiceClient.getCallable().futureCall(request);
   *   // Do something.
   *   SnapshotSettings response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetSnapshotSettingRequest, SnapshotSettings> getCallable() {
    return stub.getCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Patch snapshot settings.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SnapshotSettingsServiceClient snapshotSettingsServiceClient =
   *     SnapshotSettingsServiceClient.create()) {
   *   String project = "project-309310695";
   *   SnapshotSettings snapshotSettingsResource = SnapshotSettings.newBuilder().build();
   *   Operation response =
   *       snapshotSettingsServiceClient.patchAsync(project, snapshotSettingsResource).get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param snapshotSettingsResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> patchAsync(
      String project, SnapshotSettings snapshotSettingsResource) {
    PatchSnapshotSettingRequest request =
        PatchSnapshotSettingRequest.newBuilder()
            .setProject(project)
            .setSnapshotSettingsResource(snapshotSettingsResource)
            .build();
    return patchAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Patch snapshot settings.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SnapshotSettingsServiceClient snapshotSettingsServiceClient =
   *     SnapshotSettingsServiceClient.create()) {
   *   PatchSnapshotSettingRequest request =
   *       PatchSnapshotSettingRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setSnapshotSettingsResource(SnapshotSettings.newBuilder().build())
   *           .setUpdateMask("updateMask-296147115")
   *           .build();
   *   Operation response = snapshotSettingsServiceClient.patchAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Operation, Operation> patchAsync(
      PatchSnapshotSettingRequest request) {
    return patchOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Patch snapshot settings.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SnapshotSettingsServiceClient snapshotSettingsServiceClient =
   *     SnapshotSettingsServiceClient.create()) {
   *   PatchSnapshotSettingRequest request =
   *       PatchSnapshotSettingRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setSnapshotSettingsResource(SnapshotSettings.newBuilder().build())
   *           .setUpdateMask("updateMask-296147115")
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       snapshotSettingsServiceClient.patchOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<PatchSnapshotSettingRequest, Operation, Operation>
      patchOperationCallable() {
    return stub.patchOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Patch snapshot settings.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SnapshotSettingsServiceClient snapshotSettingsServiceClient =
   *     SnapshotSettingsServiceClient.create()) {
   *   PatchSnapshotSettingRequest request =
   *       PatchSnapshotSettingRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setSnapshotSettingsResource(SnapshotSettings.newBuilder().build())
   *           .setUpdateMask("updateMask-296147115")
   *           .build();
   *   ApiFuture<Operation> future =
   *       snapshotSettingsServiceClient.patchCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<PatchSnapshotSettingRequest, Operation> patchCallable() {
    return stub.patchCallable();
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
