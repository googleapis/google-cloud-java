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

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.longrunning.OperationFuture;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.compute.v1.stub.InstanceSettingsServiceStub;
import com.google.cloud.compute.v1.stub.InstanceSettingsServiceStubSettings;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: The InstanceSettings API.
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
 * try (InstanceSettingsServiceClient instanceSettingsServiceClient =
 *     InstanceSettingsServiceClient.create()) {
 *   String project = "project-309310695";
 *   String zone = "zone3744684";
 *   InstanceSettings response = instanceSettingsServiceClient.get(project, zone);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the InstanceSettingsServiceClient object to clean up
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
 *      <td><p> Get Instance settings.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> get(GetInstanceSettingRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> get(String project, String zone)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> Patch</td>
 *      <td><p> Patch Instance settings</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> patchAsync(PatchInstanceSettingRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> patchAsync(String project, String zone, InstanceSettings instanceSettingsResource)
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
 * InstanceSettingsServiceSettings to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * InstanceSettingsServiceSettings instanceSettingsServiceSettings =
 *     InstanceSettingsServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * InstanceSettingsServiceClient instanceSettingsServiceClient =
 *     InstanceSettingsServiceClient.create(instanceSettingsServiceSettings);
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
 * InstanceSettingsServiceSettings instanceSettingsServiceSettings =
 *     InstanceSettingsServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * InstanceSettingsServiceClient instanceSettingsServiceClient =
 *     InstanceSettingsServiceClient.create(instanceSettingsServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class InstanceSettingsServiceClient implements BackgroundResource {
  private final InstanceSettingsServiceSettings settings;
  private final InstanceSettingsServiceStub stub;

  /** Constructs an instance of InstanceSettingsServiceClient with default settings. */
  public static final InstanceSettingsServiceClient create() throws IOException {
    return create(InstanceSettingsServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of InstanceSettingsServiceClient, using the given settings. The channels
   * are created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final InstanceSettingsServiceClient create(InstanceSettingsServiceSettings settings)
      throws IOException {
    return new InstanceSettingsServiceClient(settings);
  }

  /**
   * Constructs an instance of InstanceSettingsServiceClient, using the given stub for making calls.
   * This is for advanced usage - prefer using create(InstanceSettingsServiceSettings).
   */
  public static final InstanceSettingsServiceClient create(InstanceSettingsServiceStub stub) {
    return new InstanceSettingsServiceClient(stub);
  }

  /**
   * Constructs an instance of InstanceSettingsServiceClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected InstanceSettingsServiceClient(InstanceSettingsServiceSettings settings)
      throws IOException {
    this.settings = settings;
    this.stub = ((InstanceSettingsServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected InstanceSettingsServiceClient(InstanceSettingsServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final InstanceSettingsServiceSettings getSettings() {
    return settings;
  }

  public InstanceSettingsServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get Instance settings.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InstanceSettingsServiceClient instanceSettingsServiceClient =
   *     InstanceSettingsServiceClient.create()) {
   *   String project = "project-309310695";
   *   String zone = "zone3744684";
   *   InstanceSettings response = instanceSettingsServiceClient.get(project, zone);
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param zone Name of the zone for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final InstanceSettings get(String project, String zone) {
    GetInstanceSettingRequest request =
        GetInstanceSettingRequest.newBuilder().setProject(project).setZone(zone).build();
    return get(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get Instance settings.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InstanceSettingsServiceClient instanceSettingsServiceClient =
   *     InstanceSettingsServiceClient.create()) {
   *   GetInstanceSettingRequest request =
   *       GetInstanceSettingRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setZone("zone3744684")
   *           .build();
   *   InstanceSettings response = instanceSettingsServiceClient.get(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final InstanceSettings get(GetInstanceSettingRequest request) {
    return getCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get Instance settings.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InstanceSettingsServiceClient instanceSettingsServiceClient =
   *     InstanceSettingsServiceClient.create()) {
   *   GetInstanceSettingRequest request =
   *       GetInstanceSettingRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setZone("zone3744684")
   *           .build();
   *   ApiFuture<InstanceSettings> future =
   *       instanceSettingsServiceClient.getCallable().futureCall(request);
   *   // Do something.
   *   InstanceSettings response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetInstanceSettingRequest, InstanceSettings> getCallable() {
    return stub.getCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Patch Instance settings
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InstanceSettingsServiceClient instanceSettingsServiceClient =
   *     InstanceSettingsServiceClient.create()) {
   *   String project = "project-309310695";
   *   String zone = "zone3744684";
   *   InstanceSettings instanceSettingsResource = InstanceSettings.newBuilder().build();
   *   Operation response =
   *       instanceSettingsServiceClient.patchAsync(project, zone, instanceSettingsResource).get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param zone The zone scoping this request. It should conform to RFC1035.
   * @param instanceSettingsResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> patchAsync(
      String project, String zone, InstanceSettings instanceSettingsResource) {
    PatchInstanceSettingRequest request =
        PatchInstanceSettingRequest.newBuilder()
            .setProject(project)
            .setZone(zone)
            .setInstanceSettingsResource(instanceSettingsResource)
            .build();
    return patchAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Patch Instance settings
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InstanceSettingsServiceClient instanceSettingsServiceClient =
   *     InstanceSettingsServiceClient.create()) {
   *   PatchInstanceSettingRequest request =
   *       PatchInstanceSettingRequest.newBuilder()
   *           .setInstanceSettingsResource(InstanceSettings.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setUpdateMask("updateMask-296147115")
   *           .setZone("zone3744684")
   *           .build();
   *   Operation response = instanceSettingsServiceClient.patchAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> patchAsync(
      PatchInstanceSettingRequest request) {
    return patchOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Patch Instance settings
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InstanceSettingsServiceClient instanceSettingsServiceClient =
   *     InstanceSettingsServiceClient.create()) {
   *   PatchInstanceSettingRequest request =
   *       PatchInstanceSettingRequest.newBuilder()
   *           .setInstanceSettingsResource(InstanceSettings.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setUpdateMask("updateMask-296147115")
   *           .setZone("zone3744684")
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       instanceSettingsServiceClient.patchOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<PatchInstanceSettingRequest, Operation, Operation>
      patchOperationCallable() {
    return stub.patchOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Patch Instance settings
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InstanceSettingsServiceClient instanceSettingsServiceClient =
   *     InstanceSettingsServiceClient.create()) {
   *   PatchInstanceSettingRequest request =
   *       PatchInstanceSettingRequest.newBuilder()
   *           .setInstanceSettingsResource(InstanceSettings.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setUpdateMask("updateMask-296147115")
   *           .setZone("zone3744684")
   *           .build();
   *   ApiFuture<Operation> future =
   *       instanceSettingsServiceClient.patchCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<PatchInstanceSettingRequest, Operation> patchCallable() {
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
