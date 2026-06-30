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
import com.google.cloud.compute.v1.stub.RegionInstantSnapshotGroupsStub;
import com.google.cloud.compute.v1.stub.RegionInstantSnapshotGroupsStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: The RegionInstantSnapshotGroups API.
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
 * try (RegionInstantSnapshotGroupsClient regionInstantSnapshotGroupsClient =
 *     RegionInstantSnapshotGroupsClient.create()) {
 *   String project = "project-309310695";
 *   String region = "region-934795532";
 *   String instantSnapshotGroup = "instantSnapshotGroup500796090";
 *   InstantSnapshotGroup response =
 *       regionInstantSnapshotGroupsClient.get(project, region, instantSnapshotGroup);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the RegionInstantSnapshotGroupsClient object to clean up
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
 *      <td><p> deletes a Regional InstantSnapshotGroup resource</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteAsync(DeleteRegionInstantSnapshotGroupRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteAsync(String project, String region, String instantSnapshotGroup)
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
 *      <td><p> returns the specified InstantSnapshotGroup resource in the specified region.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> get(GetRegionInstantSnapshotGroupRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> get(String project, String region, String instantSnapshotGroup)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetIamPolicy</td>
 *      <td><p> Gets the access control policy for a resource. May be empty if no such policy or resource exists.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getIamPolicy(GetIamPolicyRegionInstantSnapshotGroupRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getIamPolicy(String project, String region, String resource)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getIamPolicyCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> Insert</td>
 *      <td><p> creates a Regional InstantSnapshotGroup resource</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> insertAsync(InsertRegionInstantSnapshotGroupRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> insertAsync(String project, String region, InstantSnapshotGroup instantSnapshotGroupResource)
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
 *      <td><p> retrieves the list of InstantSnapshotGroup resources contained within the specified region.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> list(ListRegionInstantSnapshotGroupsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> list(String project, String region)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listPagedCallable()
 *           <li><p> listCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> SetIamPolicy</td>
 *      <td><p> Sets the access control policy on the specified resource. Replaces any existing policy.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> setIamPolicy(SetIamPolicyRegionInstantSnapshotGroupRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> setIamPolicy(String project, String region, String resource, RegionSetPolicyRequest regionSetPolicyRequestResource)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> setIamPolicyCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> TestIamPermissions</td>
 *      <td><p> Returns permissions that a caller has on the specified resource.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> testIamPermissions(TestIamPermissionsRegionInstantSnapshotGroupRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> testIamPermissions(String project, String region, String resource, TestPermissionsRequest testPermissionsRequestResource)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> testIamPermissionsCallable()
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
 * RegionInstantSnapshotGroupsSettings to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * RegionInstantSnapshotGroupsSettings regionInstantSnapshotGroupsSettings =
 *     RegionInstantSnapshotGroupsSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * RegionInstantSnapshotGroupsClient regionInstantSnapshotGroupsClient =
 *     RegionInstantSnapshotGroupsClient.create(regionInstantSnapshotGroupsSettings);
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
 * RegionInstantSnapshotGroupsSettings regionInstantSnapshotGroupsSettings =
 *     RegionInstantSnapshotGroupsSettings.newBuilder().setEndpoint(myEndpoint).build();
 * RegionInstantSnapshotGroupsClient regionInstantSnapshotGroupsClient =
 *     RegionInstantSnapshotGroupsClient.create(regionInstantSnapshotGroupsSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class RegionInstantSnapshotGroupsClient implements BackgroundResource {
  private final RegionInstantSnapshotGroupsSettings settings;
  private final RegionInstantSnapshotGroupsStub stub;

  /** Constructs an instance of RegionInstantSnapshotGroupsClient with default settings. */
  public static final RegionInstantSnapshotGroupsClient create() throws IOException {
    return create(RegionInstantSnapshotGroupsSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of RegionInstantSnapshotGroupsClient, using the given settings. The
   * channels are created based on the settings passed in, or defaults for any settings that are not
   * set.
   */
  public static final RegionInstantSnapshotGroupsClient create(
      RegionInstantSnapshotGroupsSettings settings) throws IOException {
    return new RegionInstantSnapshotGroupsClient(settings);
  }

  /**
   * Constructs an instance of RegionInstantSnapshotGroupsClient, using the given stub for making
   * calls. This is for advanced usage - prefer using create(RegionInstantSnapshotGroupsSettings).
   */
  public static final RegionInstantSnapshotGroupsClient create(
      RegionInstantSnapshotGroupsStub stub) {
    return new RegionInstantSnapshotGroupsClient(stub);
  }

  /**
   * Constructs an instance of RegionInstantSnapshotGroupsClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected RegionInstantSnapshotGroupsClient(RegionInstantSnapshotGroupsSettings settings)
      throws IOException {
    this.settings = settings;
    this.stub = ((RegionInstantSnapshotGroupsStubSettings) settings.getStubSettings()).createStub();
  }

  protected RegionInstantSnapshotGroupsClient(RegionInstantSnapshotGroupsStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final RegionInstantSnapshotGroupsSettings getSettings() {
    return settings;
  }

  public RegionInstantSnapshotGroupsStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * deletes a Regional InstantSnapshotGroup resource
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionInstantSnapshotGroupsClient regionInstantSnapshotGroupsClient =
   *     RegionInstantSnapshotGroupsClient.create()) {
   *   String project = "project-309310695";
   *   String region = "region-934795532";
   *   String instantSnapshotGroup = "instantSnapshotGroup500796090";
   *   Operation response =
   *       regionInstantSnapshotGroupsClient
   *           .deleteAsync(project, region, instantSnapshotGroup)
   *           .get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param region The name of the region for this request.
   * @param instantSnapshotGroup Name of the InstantSnapshotGroup resource to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> deleteAsync(
      String project, String region, String instantSnapshotGroup) {
    DeleteRegionInstantSnapshotGroupRequest request =
        DeleteRegionInstantSnapshotGroupRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setInstantSnapshotGroup(instantSnapshotGroup)
            .build();
    return deleteAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * deletes a Regional InstantSnapshotGroup resource
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionInstantSnapshotGroupsClient regionInstantSnapshotGroupsClient =
   *     RegionInstantSnapshotGroupsClient.create()) {
   *   DeleteRegionInstantSnapshotGroupRequest request =
   *       DeleteRegionInstantSnapshotGroupRequest.newBuilder()
   *           .setInstantSnapshotGroup("instantSnapshotGroup500796090")
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Operation response = regionInstantSnapshotGroupsClient.deleteAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> deleteAsync(
      DeleteRegionInstantSnapshotGroupRequest request) {
    return deleteOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * deletes a Regional InstantSnapshotGroup resource
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionInstantSnapshotGroupsClient regionInstantSnapshotGroupsClient =
   *     RegionInstantSnapshotGroupsClient.create()) {
   *   DeleteRegionInstantSnapshotGroupRequest request =
   *       DeleteRegionInstantSnapshotGroupRequest.newBuilder()
   *           .setInstantSnapshotGroup("instantSnapshotGroup500796090")
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       regionInstantSnapshotGroupsClient.deleteOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteRegionInstantSnapshotGroupRequest, Operation, Operation>
      deleteOperationCallable() {
    return stub.deleteOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * deletes a Regional InstantSnapshotGroup resource
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionInstantSnapshotGroupsClient regionInstantSnapshotGroupsClient =
   *     RegionInstantSnapshotGroupsClient.create()) {
   *   DeleteRegionInstantSnapshotGroupRequest request =
   *       DeleteRegionInstantSnapshotGroupRequest.newBuilder()
   *           .setInstantSnapshotGroup("instantSnapshotGroup500796090")
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       regionInstantSnapshotGroupsClient.deleteCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteRegionInstantSnapshotGroupRequest, Operation> deleteCallable() {
    return stub.deleteCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * returns the specified InstantSnapshotGroup resource in the specified region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionInstantSnapshotGroupsClient regionInstantSnapshotGroupsClient =
   *     RegionInstantSnapshotGroupsClient.create()) {
   *   String project = "project-309310695";
   *   String region = "region-934795532";
   *   String instantSnapshotGroup = "instantSnapshotGroup500796090";
   *   InstantSnapshotGroup response =
   *       regionInstantSnapshotGroupsClient.get(project, region, instantSnapshotGroup);
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param region The name of the region for this request.
   * @param instantSnapshotGroup Name of the InstantSnapshotGroup resource to return.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final InstantSnapshotGroup get(
      String project, String region, String instantSnapshotGroup) {
    GetRegionInstantSnapshotGroupRequest request =
        GetRegionInstantSnapshotGroupRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setInstantSnapshotGroup(instantSnapshotGroup)
            .build();
    return get(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * returns the specified InstantSnapshotGroup resource in the specified region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionInstantSnapshotGroupsClient regionInstantSnapshotGroupsClient =
   *     RegionInstantSnapshotGroupsClient.create()) {
   *   GetRegionInstantSnapshotGroupRequest request =
   *       GetRegionInstantSnapshotGroupRequest.newBuilder()
   *           .setInstantSnapshotGroup("instantSnapshotGroup500796090")
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .build();
   *   InstantSnapshotGroup response = regionInstantSnapshotGroupsClient.get(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final InstantSnapshotGroup get(GetRegionInstantSnapshotGroupRequest request) {
    return getCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * returns the specified InstantSnapshotGroup resource in the specified region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionInstantSnapshotGroupsClient regionInstantSnapshotGroupsClient =
   *     RegionInstantSnapshotGroupsClient.create()) {
   *   GetRegionInstantSnapshotGroupRequest request =
   *       GetRegionInstantSnapshotGroupRequest.newBuilder()
   *           .setInstantSnapshotGroup("instantSnapshotGroup500796090")
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .build();
   *   ApiFuture<InstantSnapshotGroup> future =
   *       regionInstantSnapshotGroupsClient.getCallable().futureCall(request);
   *   // Do something.
   *   InstantSnapshotGroup response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetRegionInstantSnapshotGroupRequest, InstantSnapshotGroup>
      getCallable() {
    return stub.getCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the access control policy for a resource. May be empty if no such policy or resource
   * exists.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionInstantSnapshotGroupsClient regionInstantSnapshotGroupsClient =
   *     RegionInstantSnapshotGroupsClient.create()) {
   *   String project = "project-309310695";
   *   String region = "region-934795532";
   *   String resource = "resource-341064690";
   *   Policy response = regionInstantSnapshotGroupsClient.getIamPolicy(project, region, resource);
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param region The name of the region for this request.
   * @param resource Name or id of the resource for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy getIamPolicy(String project, String region, String resource) {
    GetIamPolicyRegionInstantSnapshotGroupRequest request =
        GetIamPolicyRegionInstantSnapshotGroupRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setResource(resource)
            .build();
    return getIamPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the access control policy for a resource. May be empty if no such policy or resource
   * exists.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionInstantSnapshotGroupsClient regionInstantSnapshotGroupsClient =
   *     RegionInstantSnapshotGroupsClient.create()) {
   *   GetIamPolicyRegionInstantSnapshotGroupRequest request =
   *       GetIamPolicyRegionInstantSnapshotGroupRequest.newBuilder()
   *           .setOptionsRequestedPolicyVersion(-574521795)
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setResource("resource-341064690")
   *           .build();
   *   Policy response = regionInstantSnapshotGroupsClient.getIamPolicy(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy getIamPolicy(GetIamPolicyRegionInstantSnapshotGroupRequest request) {
    return getIamPolicyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the access control policy for a resource. May be empty if no such policy or resource
   * exists.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionInstantSnapshotGroupsClient regionInstantSnapshotGroupsClient =
   *     RegionInstantSnapshotGroupsClient.create()) {
   *   GetIamPolicyRegionInstantSnapshotGroupRequest request =
   *       GetIamPolicyRegionInstantSnapshotGroupRequest.newBuilder()
   *           .setOptionsRequestedPolicyVersion(-574521795)
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setResource("resource-341064690")
   *           .build();
   *   ApiFuture<Policy> future =
   *       regionInstantSnapshotGroupsClient.getIamPolicyCallable().futureCall(request);
   *   // Do something.
   *   Policy response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetIamPolicyRegionInstantSnapshotGroupRequest, Policy>
      getIamPolicyCallable() {
    return stub.getIamPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * creates a Regional InstantSnapshotGroup resource
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionInstantSnapshotGroupsClient regionInstantSnapshotGroupsClient =
   *     RegionInstantSnapshotGroupsClient.create()) {
   *   String project = "project-309310695";
   *   String region = "region-934795532";
   *   InstantSnapshotGroup instantSnapshotGroupResource = InstantSnapshotGroup.newBuilder().build();
   *   Operation response =
   *       regionInstantSnapshotGroupsClient
   *           .insertAsync(project, region, instantSnapshotGroupResource)
   *           .get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region for this request.
   * @param instantSnapshotGroupResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> insertAsync(
      String project, String region, InstantSnapshotGroup instantSnapshotGroupResource) {
    InsertRegionInstantSnapshotGroupRequest request =
        InsertRegionInstantSnapshotGroupRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setInstantSnapshotGroupResource(instantSnapshotGroupResource)
            .build();
    return insertAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * creates a Regional InstantSnapshotGroup resource
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionInstantSnapshotGroupsClient regionInstantSnapshotGroupsClient =
   *     RegionInstantSnapshotGroupsClient.create()) {
   *   InsertRegionInstantSnapshotGroupRequest request =
   *       InsertRegionInstantSnapshotGroupRequest.newBuilder()
   *           .setInstantSnapshotGroupResource(InstantSnapshotGroup.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .setSourceConsistencyGroup("sourceConsistencyGroup-2056893054")
   *           .build();
   *   Operation response = regionInstantSnapshotGroupsClient.insertAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> insertAsync(
      InsertRegionInstantSnapshotGroupRequest request) {
    return insertOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * creates a Regional InstantSnapshotGroup resource
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionInstantSnapshotGroupsClient regionInstantSnapshotGroupsClient =
   *     RegionInstantSnapshotGroupsClient.create()) {
   *   InsertRegionInstantSnapshotGroupRequest request =
   *       InsertRegionInstantSnapshotGroupRequest.newBuilder()
   *           .setInstantSnapshotGroupResource(InstantSnapshotGroup.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .setSourceConsistencyGroup("sourceConsistencyGroup-2056893054")
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       regionInstantSnapshotGroupsClient.insertOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<InsertRegionInstantSnapshotGroupRequest, Operation, Operation>
      insertOperationCallable() {
    return stub.insertOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * creates a Regional InstantSnapshotGroup resource
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionInstantSnapshotGroupsClient regionInstantSnapshotGroupsClient =
   *     RegionInstantSnapshotGroupsClient.create()) {
   *   InsertRegionInstantSnapshotGroupRequest request =
   *       InsertRegionInstantSnapshotGroupRequest.newBuilder()
   *           .setInstantSnapshotGroupResource(InstantSnapshotGroup.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .setSourceConsistencyGroup("sourceConsistencyGroup-2056893054")
   *           .build();
   *   ApiFuture<Operation> future =
   *       regionInstantSnapshotGroupsClient.insertCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<InsertRegionInstantSnapshotGroupRequest, Operation> insertCallable() {
    return stub.insertCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * retrieves the list of InstantSnapshotGroup resources contained within the specified region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionInstantSnapshotGroupsClient regionInstantSnapshotGroupsClient =
   *     RegionInstantSnapshotGroupsClient.create()) {
   *   String project = "project-309310695";
   *   String region = "region-934795532";
   *   for (InstantSnapshotGroup element :
   *       regionInstantSnapshotGroupsClient.list(project, region).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param region The name of the region for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPagedResponse list(String project, String region) {
    ListRegionInstantSnapshotGroupsRequest request =
        ListRegionInstantSnapshotGroupsRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .build();
    return list(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * retrieves the list of InstantSnapshotGroup resources contained within the specified region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionInstantSnapshotGroupsClient regionInstantSnapshotGroupsClient =
   *     RegionInstantSnapshotGroupsClient.create()) {
   *   ListRegionInstantSnapshotGroupsRequest request =
   *       ListRegionInstantSnapshotGroupsRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   for (InstantSnapshotGroup element :
   *       regionInstantSnapshotGroupsClient.list(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPagedResponse list(ListRegionInstantSnapshotGroupsRequest request) {
    return listPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * retrieves the list of InstantSnapshotGroup resources contained within the specified region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionInstantSnapshotGroupsClient regionInstantSnapshotGroupsClient =
   *     RegionInstantSnapshotGroupsClient.create()) {
   *   ListRegionInstantSnapshotGroupsRequest request =
   *       ListRegionInstantSnapshotGroupsRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   ApiFuture<InstantSnapshotGroup> future =
   *       regionInstantSnapshotGroupsClient.listPagedCallable().futureCall(request);
   *   // Do something.
   *   for (InstantSnapshotGroup element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListRegionInstantSnapshotGroupsRequest, ListPagedResponse>
      listPagedCallable() {
    return stub.listPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * retrieves the list of InstantSnapshotGroup resources contained within the specified region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionInstantSnapshotGroupsClient regionInstantSnapshotGroupsClient =
   *     RegionInstantSnapshotGroupsClient.create()) {
   *   ListRegionInstantSnapshotGroupsRequest request =
   *       ListRegionInstantSnapshotGroupsRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   while (true) {
   *     ListInstantSnapshotGroups response =
   *         regionInstantSnapshotGroupsClient.listCallable().call(request);
   *     for (InstantSnapshotGroup element : response.getItemsList()) {
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
  public final UnaryCallable<ListRegionInstantSnapshotGroupsRequest, ListInstantSnapshotGroups>
      listCallable() {
    return stub.listCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the access control policy on the specified resource. Replaces any existing policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionInstantSnapshotGroupsClient regionInstantSnapshotGroupsClient =
   *     RegionInstantSnapshotGroupsClient.create()) {
   *   String project = "project-309310695";
   *   String region = "region-934795532";
   *   String resource = "resource-341064690";
   *   RegionSetPolicyRequest regionSetPolicyRequestResource =
   *       RegionSetPolicyRequest.newBuilder().build();
   *   Policy response =
   *       regionInstantSnapshotGroupsClient.setIamPolicy(
   *           project, region, resource, regionSetPolicyRequestResource);
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param region The name of the region for this request.
   * @param resource Name or id of the resource for this request.
   * @param regionSetPolicyRequestResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy setIamPolicy(
      String project,
      String region,
      String resource,
      RegionSetPolicyRequest regionSetPolicyRequestResource) {
    SetIamPolicyRegionInstantSnapshotGroupRequest request =
        SetIamPolicyRegionInstantSnapshotGroupRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setResource(resource)
            .setRegionSetPolicyRequestResource(regionSetPolicyRequestResource)
            .build();
    return setIamPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the access control policy on the specified resource. Replaces any existing policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionInstantSnapshotGroupsClient regionInstantSnapshotGroupsClient =
   *     RegionInstantSnapshotGroupsClient.create()) {
   *   SetIamPolicyRegionInstantSnapshotGroupRequest request =
   *       SetIamPolicyRegionInstantSnapshotGroupRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRegionSetPolicyRequestResource(RegionSetPolicyRequest.newBuilder().build())
   *           .setResource("resource-341064690")
   *           .build();
   *   Policy response = regionInstantSnapshotGroupsClient.setIamPolicy(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy setIamPolicy(SetIamPolicyRegionInstantSnapshotGroupRequest request) {
    return setIamPolicyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the access control policy on the specified resource. Replaces any existing policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionInstantSnapshotGroupsClient regionInstantSnapshotGroupsClient =
   *     RegionInstantSnapshotGroupsClient.create()) {
   *   SetIamPolicyRegionInstantSnapshotGroupRequest request =
   *       SetIamPolicyRegionInstantSnapshotGroupRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRegionSetPolicyRequestResource(RegionSetPolicyRequest.newBuilder().build())
   *           .setResource("resource-341064690")
   *           .build();
   *   ApiFuture<Policy> future =
   *       regionInstantSnapshotGroupsClient.setIamPolicyCallable().futureCall(request);
   *   // Do something.
   *   Policy response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SetIamPolicyRegionInstantSnapshotGroupRequest, Policy>
      setIamPolicyCallable() {
    return stub.setIamPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns permissions that a caller has on the specified resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionInstantSnapshotGroupsClient regionInstantSnapshotGroupsClient =
   *     RegionInstantSnapshotGroupsClient.create()) {
   *   String project = "project-309310695";
   *   String region = "region-934795532";
   *   String resource = "resource-341064690";
   *   TestPermissionsRequest testPermissionsRequestResource =
   *       TestPermissionsRequest.newBuilder().build();
   *   TestPermissionsResponse response =
   *       regionInstantSnapshotGroupsClient.testIamPermissions(
   *           project, region, resource, testPermissionsRequestResource);
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param region The name of the region for this request.
   * @param resource Name or id of the resource for this request.
   * @param testPermissionsRequestResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TestPermissionsResponse testIamPermissions(
      String project,
      String region,
      String resource,
      TestPermissionsRequest testPermissionsRequestResource) {
    TestIamPermissionsRegionInstantSnapshotGroupRequest request =
        TestIamPermissionsRegionInstantSnapshotGroupRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setResource(resource)
            .setTestPermissionsRequestResource(testPermissionsRequestResource)
            .build();
    return testIamPermissions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns permissions that a caller has on the specified resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionInstantSnapshotGroupsClient regionInstantSnapshotGroupsClient =
   *     RegionInstantSnapshotGroupsClient.create()) {
   *   TestIamPermissionsRegionInstantSnapshotGroupRequest request =
   *       TestIamPermissionsRegionInstantSnapshotGroupRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setResource("resource-341064690")
   *           .setTestPermissionsRequestResource(TestPermissionsRequest.newBuilder().build())
   *           .build();
   *   TestPermissionsResponse response =
   *       regionInstantSnapshotGroupsClient.testIamPermissions(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TestPermissionsResponse testIamPermissions(
      TestIamPermissionsRegionInstantSnapshotGroupRequest request) {
    return testIamPermissionsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns permissions that a caller has on the specified resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionInstantSnapshotGroupsClient regionInstantSnapshotGroupsClient =
   *     RegionInstantSnapshotGroupsClient.create()) {
   *   TestIamPermissionsRegionInstantSnapshotGroupRequest request =
   *       TestIamPermissionsRegionInstantSnapshotGroupRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setResource("resource-341064690")
   *           .setTestPermissionsRequestResource(TestPermissionsRequest.newBuilder().build())
   *           .build();
   *   ApiFuture<TestPermissionsResponse> future =
   *       regionInstantSnapshotGroupsClient.testIamPermissionsCallable().futureCall(request);
   *   // Do something.
   *   TestPermissionsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<
          TestIamPermissionsRegionInstantSnapshotGroupRequest, TestPermissionsResponse>
      testIamPermissionsCallable() {
    return stub.testIamPermissionsCallable();
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
          ListRegionInstantSnapshotGroupsRequest,
          ListInstantSnapshotGroups,
          InstantSnapshotGroup,
          ListPage,
          ListFixedSizeCollection> {

    public static ApiFuture<ListPagedResponse> createAsync(
        PageContext<
                ListRegionInstantSnapshotGroupsRequest,
                ListInstantSnapshotGroups,
                InstantSnapshotGroup>
            context,
        ApiFuture<ListInstantSnapshotGroups> futureResponse) {
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
          ListRegionInstantSnapshotGroupsRequest,
          ListInstantSnapshotGroups,
          InstantSnapshotGroup,
          ListPage> {

    private ListPage(
        PageContext<
                ListRegionInstantSnapshotGroupsRequest,
                ListInstantSnapshotGroups,
                InstantSnapshotGroup>
            context,
        ListInstantSnapshotGroups response) {
      super(context, response);
    }

    private static ListPage createEmptyPage() {
      return new ListPage(null, null);
    }

    @Override
    protected ListPage createPage(
        PageContext<
                ListRegionInstantSnapshotGroupsRequest,
                ListInstantSnapshotGroups,
                InstantSnapshotGroup>
            context,
        ListInstantSnapshotGroups response) {
      return new ListPage(context, response);
    }

    @Override
    public ApiFuture<ListPage> createPageAsync(
        PageContext<
                ListRegionInstantSnapshotGroupsRequest,
                ListInstantSnapshotGroups,
                InstantSnapshotGroup>
            context,
        ApiFuture<ListInstantSnapshotGroups> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListRegionInstantSnapshotGroupsRequest,
          ListInstantSnapshotGroups,
          InstantSnapshotGroup,
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
