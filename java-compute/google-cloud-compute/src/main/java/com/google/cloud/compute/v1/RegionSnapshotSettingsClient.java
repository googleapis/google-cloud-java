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

package com.google.cloud.compute.v1;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.longrunning.OperationFuture;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.compute.v1.stub.RegionSnapshotSettingsStub;
import com.google.cloud.compute.v1.stub.RegionSnapshotSettingsStubSettings;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: The RegionSnapshotSettings API.
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
 * try (RegionSnapshotSettingsClient regionSnapshotSettingsClient =
 *     RegionSnapshotSettingsClient.create()) {
 *   String project = "project-309310695";
 *   String region = "region-934795532";
 *   SnapshotSettings response = regionSnapshotSettingsClient.get(project, region);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the RegionSnapshotSettingsClient object to clean up
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
 *      <td><p> Get region snapshot settings.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> get(GetRegionSnapshotSettingRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> get(String project, String region)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> Patch</td>
 *      <td><p> Patch region snapshot settings.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> patchAsync(PatchRegionSnapshotSettingRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> patchAsync(String project, String region, SnapshotSettings snapshotSettingsResource)
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
 * <p>This class can be customized by passing in a custom instance of RegionSnapshotSettingsSettings
 * to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * RegionSnapshotSettingsSettings regionSnapshotSettingsSettings =
 *     RegionSnapshotSettingsSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * RegionSnapshotSettingsClient regionSnapshotSettingsClient =
 *     RegionSnapshotSettingsClient.create(regionSnapshotSettingsSettings);
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
 * RegionSnapshotSettingsSettings regionSnapshotSettingsSettings =
 *     RegionSnapshotSettingsSettings.newBuilder().setEndpoint(myEndpoint).build();
 * RegionSnapshotSettingsClient regionSnapshotSettingsClient =
 *     RegionSnapshotSettingsClient.create(regionSnapshotSettingsSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class RegionSnapshotSettingsClient implements BackgroundResource {
  private final RegionSnapshotSettingsSettings settings;
  private final RegionSnapshotSettingsStub stub;

  /** Constructs an instance of RegionSnapshotSettingsClient with default settings. */
  public static final RegionSnapshotSettingsClient create() throws IOException {
    return create(RegionSnapshotSettingsSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of RegionSnapshotSettingsClient, using the given settings. The channels
   * are created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final RegionSnapshotSettingsClient create(RegionSnapshotSettingsSettings settings)
      throws IOException {
    return new RegionSnapshotSettingsClient(settings);
  }

  /**
   * Constructs an instance of RegionSnapshotSettingsClient, using the given stub for making calls.
   * This is for advanced usage - prefer using create(RegionSnapshotSettingsSettings).
   */
  public static final RegionSnapshotSettingsClient create(RegionSnapshotSettingsStub stub) {
    return new RegionSnapshotSettingsClient(stub);
  }

  /**
   * Constructs an instance of RegionSnapshotSettingsClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected RegionSnapshotSettingsClient(RegionSnapshotSettingsSettings settings)
      throws IOException {
    this.settings = settings;
    this.stub = ((RegionSnapshotSettingsStubSettings) settings.getStubSettings()).createStub();
  }

  protected RegionSnapshotSettingsClient(RegionSnapshotSettingsStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final RegionSnapshotSettingsSettings getSettings() {
    return settings;
  }

  public RegionSnapshotSettingsStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get region snapshot settings.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionSnapshotSettingsClient regionSnapshotSettingsClient =
   *     RegionSnapshotSettingsClient.create()) {
   *   String project = "project-309310695";
   *   String region = "region-934795532";
   *   SnapshotSettings response = regionSnapshotSettingsClient.get(project, region);
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SnapshotSettings get(String project, String region) {
    GetRegionSnapshotSettingRequest request =
        GetRegionSnapshotSettingRequest.newBuilder().setProject(project).setRegion(region).build();
    return get(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get region snapshot settings.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionSnapshotSettingsClient regionSnapshotSettingsClient =
   *     RegionSnapshotSettingsClient.create()) {
   *   GetRegionSnapshotSettingRequest request =
   *       GetRegionSnapshotSettingRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .build();
   *   SnapshotSettings response = regionSnapshotSettingsClient.get(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SnapshotSettings get(GetRegionSnapshotSettingRequest request) {
    return getCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get region snapshot settings.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionSnapshotSettingsClient regionSnapshotSettingsClient =
   *     RegionSnapshotSettingsClient.create()) {
   *   GetRegionSnapshotSettingRequest request =
   *       GetRegionSnapshotSettingRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .build();
   *   ApiFuture<SnapshotSettings> future =
   *       regionSnapshotSettingsClient.getCallable().futureCall(request);
   *   // Do something.
   *   SnapshotSettings response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetRegionSnapshotSettingRequest, SnapshotSettings> getCallable() {
    return stub.getCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Patch region snapshot settings.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionSnapshotSettingsClient regionSnapshotSettingsClient =
   *     RegionSnapshotSettingsClient.create()) {
   *   String project = "project-309310695";
   *   String region = "region-934795532";
   *   SnapshotSettings snapshotSettingsResource = SnapshotSettings.newBuilder().build();
   *   Operation response =
   *       regionSnapshotSettingsClient.patchAsync(project, region, snapshotSettingsResource).get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region for this request.
   * @param snapshotSettingsResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> patchAsync(
      String project, String region, SnapshotSettings snapshotSettingsResource) {
    PatchRegionSnapshotSettingRequest request =
        PatchRegionSnapshotSettingRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setSnapshotSettingsResource(snapshotSettingsResource)
            .build();
    return patchAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Patch region snapshot settings.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionSnapshotSettingsClient regionSnapshotSettingsClient =
   *     RegionSnapshotSettingsClient.create()) {
   *   PatchRegionSnapshotSettingRequest request =
   *       PatchRegionSnapshotSettingRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .setSnapshotSettingsResource(SnapshotSettings.newBuilder().build())
   *           .setUpdateMask("updateMask-296147115")
   *           .build();
   *   Operation response = regionSnapshotSettingsClient.patchAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> patchAsync(
      PatchRegionSnapshotSettingRequest request) {
    return patchOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Patch region snapshot settings.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionSnapshotSettingsClient regionSnapshotSettingsClient =
   *     RegionSnapshotSettingsClient.create()) {
   *   PatchRegionSnapshotSettingRequest request =
   *       PatchRegionSnapshotSettingRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .setSnapshotSettingsResource(SnapshotSettings.newBuilder().build())
   *           .setUpdateMask("updateMask-296147115")
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       regionSnapshotSettingsClient.patchOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<PatchRegionSnapshotSettingRequest, Operation, Operation>
      patchOperationCallable() {
    return stub.patchOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Patch region snapshot settings.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionSnapshotSettingsClient regionSnapshotSettingsClient =
   *     RegionSnapshotSettingsClient.create()) {
   *   PatchRegionSnapshotSettingRequest request =
   *       PatchRegionSnapshotSettingRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .setSnapshotSettingsResource(SnapshotSettings.newBuilder().build())
   *           .setUpdateMask("updateMask-296147115")
   *           .build();
   *   ApiFuture<Operation> future =
   *       regionSnapshotSettingsClient.patchCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<PatchRegionSnapshotSettingRequest, Operation> patchCallable() {
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
