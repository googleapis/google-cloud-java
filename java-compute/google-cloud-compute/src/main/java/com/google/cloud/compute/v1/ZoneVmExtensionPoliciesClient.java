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

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.longrunning.OperationFuture;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.compute.v1.stub.ZoneVmExtensionPoliciesStub;
import com.google.cloud.compute.v1.stub.ZoneVmExtensionPoliciesStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: The ZoneVmExtensionPolicies API.
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
 * try (ZoneVmExtensionPoliciesClient zoneVmExtensionPoliciesClient =
 *     ZoneVmExtensionPoliciesClient.create()) {
 *   String project = "project-309310695";
 *   String zone = "zone3744684";
 *   String vmExtensionPolicy = "vmExtensionPolicy1236125338";
 *   VmExtensionPolicy response =
 *       zoneVmExtensionPoliciesClient.get(project, zone, vmExtensionPolicy);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the ZoneVmExtensionPoliciesClient object to clean up
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
 *      <td><p> Delete</td>
 *      <td><p> Deletes a specified zone VM extension policy.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteAsync(DeleteZoneVmExtensionPolicyRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteAsync(String project, String zone, String vmExtensionPolicy)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteOperationCallable()
 *           <li><p> deleteCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> Get</td>
 *      <td><p> Retrieves details of a specific zone VM extension policy.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> get(GetZoneVmExtensionPolicyRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> get(String project, String zone, String vmExtensionPolicy)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> Insert</td>
 *      <td><p> Creates a new zone-level VM extension policy within a project.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> insertAsync(InsertZoneVmExtensionPolicyRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> insertAsync(String project, String zone, VmExtensionPolicy vmExtensionPolicyResource)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> insertOperationCallable()
 *           <li><p> insertCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> List</td>
 *      <td><p> Lists all VM extension policies within a specific zone for a project.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> list(ListZoneVmExtensionPoliciesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> list(String project, String zone)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listPagedCallable()
 *           <li><p> listCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> Update</td>
 *      <td><p> Modifies an existing zone VM extension policy.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateAsync(UpdateZoneVmExtensionPolicyRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updateAsync(String project, String zone, String vmExtensionPolicy, VmExtensionPolicy vmExtensionPolicyResource)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateOperationCallable()
 *           <li><p> updateCallable()
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
 * ZoneVmExtensionPoliciesSettings to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * ZoneVmExtensionPoliciesSettings zoneVmExtensionPoliciesSettings =
 *     ZoneVmExtensionPoliciesSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * ZoneVmExtensionPoliciesClient zoneVmExtensionPoliciesClient =
 *     ZoneVmExtensionPoliciesClient.create(zoneVmExtensionPoliciesSettings);
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
 * ZoneVmExtensionPoliciesSettings zoneVmExtensionPoliciesSettings =
 *     ZoneVmExtensionPoliciesSettings.newBuilder().setEndpoint(myEndpoint).build();
 * ZoneVmExtensionPoliciesClient zoneVmExtensionPoliciesClient =
 *     ZoneVmExtensionPoliciesClient.create(zoneVmExtensionPoliciesSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class ZoneVmExtensionPoliciesClient implements BackgroundResource {
  private final ZoneVmExtensionPoliciesSettings settings;
  private final ZoneVmExtensionPoliciesStub stub;

  /** Constructs an instance of ZoneVmExtensionPoliciesClient with default settings. */
  public static final ZoneVmExtensionPoliciesClient create() throws IOException {
    return create(ZoneVmExtensionPoliciesSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of ZoneVmExtensionPoliciesClient, using the given settings. The channels
   * are created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final ZoneVmExtensionPoliciesClient create(ZoneVmExtensionPoliciesSettings settings)
      throws IOException {
    return new ZoneVmExtensionPoliciesClient(settings);
  }

  /**
   * Constructs an instance of ZoneVmExtensionPoliciesClient, using the given stub for making calls.
   * This is for advanced usage - prefer using create(ZoneVmExtensionPoliciesSettings).
   */
  public static final ZoneVmExtensionPoliciesClient create(ZoneVmExtensionPoliciesStub stub) {
    return new ZoneVmExtensionPoliciesClient(stub);
  }

  /**
   * Constructs an instance of ZoneVmExtensionPoliciesClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected ZoneVmExtensionPoliciesClient(ZoneVmExtensionPoliciesSettings settings)
      throws IOException {
    this.settings = settings;
    this.stub = ((ZoneVmExtensionPoliciesStubSettings) settings.getStubSettings()).createStub();
  }

  protected ZoneVmExtensionPoliciesClient(ZoneVmExtensionPoliciesStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final ZoneVmExtensionPoliciesSettings getSettings() {
    return settings;
  }

  public ZoneVmExtensionPoliciesStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a specified zone VM extension policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ZoneVmExtensionPoliciesClient zoneVmExtensionPoliciesClient =
   *     ZoneVmExtensionPoliciesClient.create()) {
   *   String project = "project-309310695";
   *   String zone = "zone3744684";
   *   String vmExtensionPolicy = "vmExtensionPolicy1236125338";
   *   Operation response =
   *       zoneVmExtensionPoliciesClient.deleteAsync(project, zone, vmExtensionPolicy).get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param zone Name of the zone for this request.
   * @param vmExtensionPolicy Name of the zone VM extension policy to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> deleteAsync(
      String project, String zone, String vmExtensionPolicy) {
    DeleteZoneVmExtensionPolicyRequest request =
        DeleteZoneVmExtensionPolicyRequest.newBuilder()
            .setProject(project)
            .setZone(zone)
            .setVmExtensionPolicy(vmExtensionPolicy)
            .build();
    return deleteAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a specified zone VM extension policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ZoneVmExtensionPoliciesClient zoneVmExtensionPoliciesClient =
   *     ZoneVmExtensionPoliciesClient.create()) {
   *   DeleteZoneVmExtensionPolicyRequest request =
   *       DeleteZoneVmExtensionPolicyRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setVmExtensionPolicy("vmExtensionPolicy1236125338")
   *           .setZone("zone3744684")
   *           .build();
   *   Operation response = zoneVmExtensionPoliciesClient.deleteAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> deleteAsync(
      DeleteZoneVmExtensionPolicyRequest request) {
    return deleteOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a specified zone VM extension policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ZoneVmExtensionPoliciesClient zoneVmExtensionPoliciesClient =
   *     ZoneVmExtensionPoliciesClient.create()) {
   *   DeleteZoneVmExtensionPolicyRequest request =
   *       DeleteZoneVmExtensionPolicyRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setVmExtensionPolicy("vmExtensionPolicy1236125338")
   *           .setZone("zone3744684")
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       zoneVmExtensionPoliciesClient.deleteOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteZoneVmExtensionPolicyRequest, Operation, Operation>
      deleteOperationCallable() {
    return stub.deleteOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a specified zone VM extension policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ZoneVmExtensionPoliciesClient zoneVmExtensionPoliciesClient =
   *     ZoneVmExtensionPoliciesClient.create()) {
   *   DeleteZoneVmExtensionPolicyRequest request =
   *       DeleteZoneVmExtensionPolicyRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setVmExtensionPolicy("vmExtensionPolicy1236125338")
   *           .setZone("zone3744684")
   *           .build();
   *   ApiFuture<Operation> future =
   *       zoneVmExtensionPoliciesClient.deleteCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteZoneVmExtensionPolicyRequest, Operation> deleteCallable() {
    return stub.deleteCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves details of a specific zone VM extension policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ZoneVmExtensionPoliciesClient zoneVmExtensionPoliciesClient =
   *     ZoneVmExtensionPoliciesClient.create()) {
   *   String project = "project-309310695";
   *   String zone = "zone3744684";
   *   String vmExtensionPolicy = "vmExtensionPolicy1236125338";
   *   VmExtensionPolicy response =
   *       zoneVmExtensionPoliciesClient.get(project, zone, vmExtensionPolicy);
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param zone Name of the zone for this request.
   * @param vmExtensionPolicy Name of the VM extension policy resource to return.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final VmExtensionPolicy get(String project, String zone, String vmExtensionPolicy) {
    GetZoneVmExtensionPolicyRequest request =
        GetZoneVmExtensionPolicyRequest.newBuilder()
            .setProject(project)
            .setZone(zone)
            .setVmExtensionPolicy(vmExtensionPolicy)
            .build();
    return get(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves details of a specific zone VM extension policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ZoneVmExtensionPoliciesClient zoneVmExtensionPoliciesClient =
   *     ZoneVmExtensionPoliciesClient.create()) {
   *   GetZoneVmExtensionPolicyRequest request =
   *       GetZoneVmExtensionPolicyRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setVmExtensionPolicy("vmExtensionPolicy1236125338")
   *           .setZone("zone3744684")
   *           .build();
   *   VmExtensionPolicy response = zoneVmExtensionPoliciesClient.get(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final VmExtensionPolicy get(GetZoneVmExtensionPolicyRequest request) {
    return getCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves details of a specific zone VM extension policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ZoneVmExtensionPoliciesClient zoneVmExtensionPoliciesClient =
   *     ZoneVmExtensionPoliciesClient.create()) {
   *   GetZoneVmExtensionPolicyRequest request =
   *       GetZoneVmExtensionPolicyRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setVmExtensionPolicy("vmExtensionPolicy1236125338")
   *           .setZone("zone3744684")
   *           .build();
   *   ApiFuture<VmExtensionPolicy> future =
   *       zoneVmExtensionPoliciesClient.getCallable().futureCall(request);
   *   // Do something.
   *   VmExtensionPolicy response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetZoneVmExtensionPolicyRequest, VmExtensionPolicy> getCallable() {
    return stub.getCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new zone-level VM extension policy within a project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ZoneVmExtensionPoliciesClient zoneVmExtensionPoliciesClient =
   *     ZoneVmExtensionPoliciesClient.create()) {
   *   String project = "project-309310695";
   *   String zone = "zone3744684";
   *   VmExtensionPolicy vmExtensionPolicyResource = VmExtensionPolicy.newBuilder().build();
   *   Operation response =
   *       zoneVmExtensionPoliciesClient.insertAsync(project, zone, vmExtensionPolicyResource).get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param zone Name of the zone for this request.
   * @param vmExtensionPolicyResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> insertAsync(
      String project, String zone, VmExtensionPolicy vmExtensionPolicyResource) {
    InsertZoneVmExtensionPolicyRequest request =
        InsertZoneVmExtensionPolicyRequest.newBuilder()
            .setProject(project)
            .setZone(zone)
            .setVmExtensionPolicyResource(vmExtensionPolicyResource)
            .build();
    return insertAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new zone-level VM extension policy within a project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ZoneVmExtensionPoliciesClient zoneVmExtensionPoliciesClient =
   *     ZoneVmExtensionPoliciesClient.create()) {
   *   InsertZoneVmExtensionPolicyRequest request =
   *       InsertZoneVmExtensionPolicyRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setVmExtensionPolicyResource(VmExtensionPolicy.newBuilder().build())
   *           .setZone("zone3744684")
   *           .build();
   *   Operation response = zoneVmExtensionPoliciesClient.insertAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> insertAsync(
      InsertZoneVmExtensionPolicyRequest request) {
    return insertOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new zone-level VM extension policy within a project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ZoneVmExtensionPoliciesClient zoneVmExtensionPoliciesClient =
   *     ZoneVmExtensionPoliciesClient.create()) {
   *   InsertZoneVmExtensionPolicyRequest request =
   *       InsertZoneVmExtensionPolicyRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setVmExtensionPolicyResource(VmExtensionPolicy.newBuilder().build())
   *           .setZone("zone3744684")
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       zoneVmExtensionPoliciesClient.insertOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<InsertZoneVmExtensionPolicyRequest, Operation, Operation>
      insertOperationCallable() {
    return stub.insertOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new zone-level VM extension policy within a project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ZoneVmExtensionPoliciesClient zoneVmExtensionPoliciesClient =
   *     ZoneVmExtensionPoliciesClient.create()) {
   *   InsertZoneVmExtensionPolicyRequest request =
   *       InsertZoneVmExtensionPolicyRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setVmExtensionPolicyResource(VmExtensionPolicy.newBuilder().build())
   *           .setZone("zone3744684")
   *           .build();
   *   ApiFuture<Operation> future =
   *       zoneVmExtensionPoliciesClient.insertCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<InsertZoneVmExtensionPolicyRequest, Operation> insertCallable() {
    return stub.insertCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all VM extension policies within a specific zone for a project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ZoneVmExtensionPoliciesClient zoneVmExtensionPoliciesClient =
   *     ZoneVmExtensionPoliciesClient.create()) {
   *   String project = "project-309310695";
   *   String zone = "zone3744684";
   *   for (VmExtensionPolicy element :
   *       zoneVmExtensionPoliciesClient.list(project, zone).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param zone Name of the zone for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPagedResponse list(String project, String zone) {
    ListZoneVmExtensionPoliciesRequest request =
        ListZoneVmExtensionPoliciesRequest.newBuilder().setProject(project).setZone(zone).build();
    return list(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all VM extension policies within a specific zone for a project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ZoneVmExtensionPoliciesClient zoneVmExtensionPoliciesClient =
   *     ZoneVmExtensionPoliciesClient.create()) {
   *   ListZoneVmExtensionPoliciesRequest request =
   *       ListZoneVmExtensionPoliciesRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setReturnPartialSuccess(true)
   *           .setZone("zone3744684")
   *           .build();
   *   for (VmExtensionPolicy element : zoneVmExtensionPoliciesClient.list(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPagedResponse list(ListZoneVmExtensionPoliciesRequest request) {
    return listPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all VM extension policies within a specific zone for a project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ZoneVmExtensionPoliciesClient zoneVmExtensionPoliciesClient =
   *     ZoneVmExtensionPoliciesClient.create()) {
   *   ListZoneVmExtensionPoliciesRequest request =
   *       ListZoneVmExtensionPoliciesRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setReturnPartialSuccess(true)
   *           .setZone("zone3744684")
   *           .build();
   *   ApiFuture<VmExtensionPolicy> future =
   *       zoneVmExtensionPoliciesClient.listPagedCallable().futureCall(request);
   *   // Do something.
   *   for (VmExtensionPolicy element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListZoneVmExtensionPoliciesRequest, ListPagedResponse>
      listPagedCallable() {
    return stub.listPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all VM extension policies within a specific zone for a project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ZoneVmExtensionPoliciesClient zoneVmExtensionPoliciesClient =
   *     ZoneVmExtensionPoliciesClient.create()) {
   *   ListZoneVmExtensionPoliciesRequest request =
   *       ListZoneVmExtensionPoliciesRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setReturnPartialSuccess(true)
   *           .setZone("zone3744684")
   *           .build();
   *   while (true) {
   *     VmExtensionPolicyList response = zoneVmExtensionPoliciesClient.listCallable().call(request);
   *     for (VmExtensionPolicy element : response.getItemsList()) {
   *       // doThingsWith(element);
   *     }
   *     String nextPageToken = response.getNextPageToken();
   *     if (!Strings.isNullOrEmpty(nextPageToken)) {
   *       request = request.toBuilder().setPageToken(nextPageToken).build();
   *     } else {
   *       break;
   *     }
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListZoneVmExtensionPoliciesRequest, VmExtensionPolicyList>
      listCallable() {
    return stub.listCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Modifies an existing zone VM extension policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ZoneVmExtensionPoliciesClient zoneVmExtensionPoliciesClient =
   *     ZoneVmExtensionPoliciesClient.create()) {
   *   String project = "project-309310695";
   *   String zone = "zone3744684";
   *   String vmExtensionPolicy = "vmExtensionPolicy1236125338";
   *   VmExtensionPolicy vmExtensionPolicyResource = VmExtensionPolicy.newBuilder().build();
   *   Operation response =
   *       zoneVmExtensionPoliciesClient
   *           .updateAsync(project, zone, vmExtensionPolicy, vmExtensionPolicyResource)
   *           .get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param zone Name of the zone for this request.
   * @param vmExtensionPolicy Name of the zone VM extension policy to update.
   * @param vmExtensionPolicyResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> updateAsync(
      String project,
      String zone,
      String vmExtensionPolicy,
      VmExtensionPolicy vmExtensionPolicyResource) {
    UpdateZoneVmExtensionPolicyRequest request =
        UpdateZoneVmExtensionPolicyRequest.newBuilder()
            .setProject(project)
            .setZone(zone)
            .setVmExtensionPolicy(vmExtensionPolicy)
            .setVmExtensionPolicyResource(vmExtensionPolicyResource)
            .build();
    return updateAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Modifies an existing zone VM extension policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ZoneVmExtensionPoliciesClient zoneVmExtensionPoliciesClient =
   *     ZoneVmExtensionPoliciesClient.create()) {
   *   UpdateZoneVmExtensionPolicyRequest request =
   *       UpdateZoneVmExtensionPolicyRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setVmExtensionPolicy("vmExtensionPolicy1236125338")
   *           .setVmExtensionPolicyResource(VmExtensionPolicy.newBuilder().build())
   *           .setZone("zone3744684")
   *           .build();
   *   Operation response = zoneVmExtensionPoliciesClient.updateAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> updateAsync(
      UpdateZoneVmExtensionPolicyRequest request) {
    return updateOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Modifies an existing zone VM extension policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ZoneVmExtensionPoliciesClient zoneVmExtensionPoliciesClient =
   *     ZoneVmExtensionPoliciesClient.create()) {
   *   UpdateZoneVmExtensionPolicyRequest request =
   *       UpdateZoneVmExtensionPolicyRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setVmExtensionPolicy("vmExtensionPolicy1236125338")
   *           .setVmExtensionPolicyResource(VmExtensionPolicy.newBuilder().build())
   *           .setZone("zone3744684")
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       zoneVmExtensionPoliciesClient.updateOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateZoneVmExtensionPolicyRequest, Operation, Operation>
      updateOperationCallable() {
    return stub.updateOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Modifies an existing zone VM extension policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ZoneVmExtensionPoliciesClient zoneVmExtensionPoliciesClient =
   *     ZoneVmExtensionPoliciesClient.create()) {
   *   UpdateZoneVmExtensionPolicyRequest request =
   *       UpdateZoneVmExtensionPolicyRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setVmExtensionPolicy("vmExtensionPolicy1236125338")
   *           .setVmExtensionPolicyResource(VmExtensionPolicy.newBuilder().build())
   *           .setZone("zone3744684")
   *           .build();
   *   ApiFuture<Operation> future =
   *       zoneVmExtensionPoliciesClient.updateCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateZoneVmExtensionPolicyRequest, Operation> updateCallable() {
    return stub.updateCallable();
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

  public static class ListPagedResponse
      extends AbstractPagedListResponse<
          ListZoneVmExtensionPoliciesRequest,
          VmExtensionPolicyList,
          VmExtensionPolicy,
          ListPage,
          ListFixedSizeCollection> {

    public static ApiFuture<ListPagedResponse> createAsync(
        PageContext<ListZoneVmExtensionPoliciesRequest, VmExtensionPolicyList, VmExtensionPolicy>
            context,
        ApiFuture<VmExtensionPolicyList> futureResponse) {
      ApiFuture<ListPage> futurePage =
          ListPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage, input -> new ListPagedResponse(input), MoreExecutors.directExecutor());
    }

    private ListPagedResponse(ListPage page) {
      super(page, ListFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListPage
      extends AbstractPage<
          ListZoneVmExtensionPoliciesRequest, VmExtensionPolicyList, VmExtensionPolicy, ListPage> {

    private ListPage(
        PageContext<ListZoneVmExtensionPoliciesRequest, VmExtensionPolicyList, VmExtensionPolicy>
            context,
        VmExtensionPolicyList response) {
      super(context, response);
    }

    private static ListPage createEmptyPage() {
      return new ListPage(null, null);
    }

    @Override
    protected ListPage createPage(
        PageContext<ListZoneVmExtensionPoliciesRequest, VmExtensionPolicyList, VmExtensionPolicy>
            context,
        VmExtensionPolicyList response) {
      return new ListPage(context, response);
    }

    @Override
    public ApiFuture<ListPage> createPageAsync(
        PageContext<ListZoneVmExtensionPoliciesRequest, VmExtensionPolicyList, VmExtensionPolicy>
            context,
        ApiFuture<VmExtensionPolicyList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListZoneVmExtensionPoliciesRequest,
          VmExtensionPolicyList,
          VmExtensionPolicy,
          ListPage,
          ListFixedSizeCollection> {

    private ListFixedSizeCollection(List<ListPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListFixedSizeCollection createEmptyCollection() {
      return new ListFixedSizeCollection(null, 0);
    }

    @Override
    protected ListFixedSizeCollection createCollection(List<ListPage> pages, int collectionSize) {
      return new ListFixedSizeCollection(pages, collectionSize);
    }
  }
}
