/*
 * Copyright 2023 Google LLC
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
import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.longrunning.OperationFuture;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.compute.v1.stub.RegionNetworkEndpointGroupsStub;
import com.google.cloud.compute.v1.stub.RegionNetworkEndpointGroupsStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: The RegionNetworkEndpointGroups API.
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
 * try (RegionNetworkEndpointGroupsClient regionNetworkEndpointGroupsClient =
 *     RegionNetworkEndpointGroupsClient.create()) {
 *   String project = "project-309310695";
 *   String region = "region-934795532";
 *   String networkEndpointGroup = "networkEndpointGroup-2120389028";
 *   NetworkEndpointGroup response =
 *       regionNetworkEndpointGroupsClient.get(project, region, networkEndpointGroup);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the RegionNetworkEndpointGroupsClient object to clean up
 * resources such as threads. In the example above, try-with-resources is used, which automatically
 * calls close().
 *
 * <table>
 *    <tr>
 *      <th>Method</th>
 *      <th>Description</th>
 *      <th>Method Variants</th>
 *    <tr>
 *      <td>AttachNetworkEndpoints</td>
 *      <td><p> Attach a list of network endpoints to the specified network endpoint group.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>attachNetworkEndpointsAsync(AttachNetworkEndpointsRegionNetworkEndpointGroupRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li>attachNetworkEndpointsAsync(String project, String region, String networkEndpointGroup, RegionNetworkEndpointGroupsAttachEndpointsRequest regionNetworkEndpointGroupsAttachEndpointsRequestResource)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>attachNetworkEndpointsOperationCallable()
 *           <li>attachNetworkEndpointsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>Delete</td>
 *      <td><p> Deletes the specified network endpoint group. Note that the NEG cannot be deleted if it is configured as a backend of a backend service.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>deleteAsync(DeleteRegionNetworkEndpointGroupRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li>deleteAsync(String project, String region, String networkEndpointGroup)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>deleteOperationCallable()
 *           <li>deleteCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>DetachNetworkEndpoints</td>
 *      <td><p> Detach the network endpoint from the specified network endpoint group.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>detachNetworkEndpointsAsync(DetachNetworkEndpointsRegionNetworkEndpointGroupRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li>detachNetworkEndpointsAsync(String project, String region, String networkEndpointGroup, RegionNetworkEndpointGroupsDetachEndpointsRequest regionNetworkEndpointGroupsDetachEndpointsRequestResource)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>detachNetworkEndpointsOperationCallable()
 *           <li>detachNetworkEndpointsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>Get</td>
 *      <td><p> Returns the specified network endpoint group.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>get(GetRegionNetworkEndpointGroupRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li>get(String project, String region, String networkEndpointGroup)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>getCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>Insert</td>
 *      <td><p> Creates a network endpoint group in the specified project using the parameters that are included in the request.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>insertAsync(InsertRegionNetworkEndpointGroupRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li>insertAsync(String project, String region, NetworkEndpointGroup networkEndpointGroupResource)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>insertOperationCallable()
 *           <li>insertCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>List</td>
 *      <td><p> Retrieves the list of regional network endpoint groups available to the specified project in the given region.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>list(ListRegionNetworkEndpointGroupsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li>list(String project, String region)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>listPagedCallable()
 *           <li>listCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>ListNetworkEndpoints</td>
 *      <td><p> Lists the network endpoints in the specified network endpoint group.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>listNetworkEndpoints(ListNetworkEndpointsRegionNetworkEndpointGroupsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li>listNetworkEndpoints(String project, String region, String networkEndpointGroup)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>listNetworkEndpointsPagedCallable()
 *           <li>listNetworkEndpointsCallable()
 *      </ul>
 *       </td>
 *    </tr>
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
 * RegionNetworkEndpointGroupsSettings to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * RegionNetworkEndpointGroupsSettings regionNetworkEndpointGroupsSettings =
 *     RegionNetworkEndpointGroupsSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * RegionNetworkEndpointGroupsClient regionNetworkEndpointGroupsClient =
 *     RegionNetworkEndpointGroupsClient.create(regionNetworkEndpointGroupsSettings);
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
 * RegionNetworkEndpointGroupsSettings regionNetworkEndpointGroupsSettings =
 *     RegionNetworkEndpointGroupsSettings.newBuilder().setEndpoint(myEndpoint).build();
 * RegionNetworkEndpointGroupsClient regionNetworkEndpointGroupsClient =
 *     RegionNetworkEndpointGroupsClient.create(regionNetworkEndpointGroupsSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class RegionNetworkEndpointGroupsClient implements BackgroundResource {
  private final RegionNetworkEndpointGroupsSettings settings;
  private final RegionNetworkEndpointGroupsStub stub;

  /** Constructs an instance of RegionNetworkEndpointGroupsClient with default settings. */
  public static final RegionNetworkEndpointGroupsClient create() throws IOException {
    return create(RegionNetworkEndpointGroupsSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of RegionNetworkEndpointGroupsClient, using the given settings. The
   * channels are created based on the settings passed in, or defaults for any settings that are not
   * set.
   */
  public static final RegionNetworkEndpointGroupsClient create(
      RegionNetworkEndpointGroupsSettings settings) throws IOException {
    return new RegionNetworkEndpointGroupsClient(settings);
  }

  /**
   * Constructs an instance of RegionNetworkEndpointGroupsClient, using the given stub for making
   * calls. This is for advanced usage - prefer using create(RegionNetworkEndpointGroupsSettings).
   */
  public static final RegionNetworkEndpointGroupsClient create(
      RegionNetworkEndpointGroupsStub stub) {
    return new RegionNetworkEndpointGroupsClient(stub);
  }

  /**
   * Constructs an instance of RegionNetworkEndpointGroupsClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected RegionNetworkEndpointGroupsClient(RegionNetworkEndpointGroupsSettings settings)
      throws IOException {
    this.settings = settings;
    this.stub = ((RegionNetworkEndpointGroupsStubSettings) settings.getStubSettings()).createStub();
  }

  protected RegionNetworkEndpointGroupsClient(RegionNetworkEndpointGroupsStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final RegionNetworkEndpointGroupsSettings getSettings() {
    return settings;
  }

  public RegionNetworkEndpointGroupsStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Attach a list of network endpoints to the specified network endpoint group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionNetworkEndpointGroupsClient regionNetworkEndpointGroupsClient =
   *     RegionNetworkEndpointGroupsClient.create()) {
   *   String project = "project-309310695";
   *   String region = "region-934795532";
   *   String networkEndpointGroup = "networkEndpointGroup-2120389028";
   *   RegionNetworkEndpointGroupsAttachEndpointsRequest
   *       regionNetworkEndpointGroupsAttachEndpointsRequestResource =
   *           RegionNetworkEndpointGroupsAttachEndpointsRequest.newBuilder().build();
   *   Operation response =
   *       regionNetworkEndpointGroupsClient
   *           .attachNetworkEndpointsAsync(
   *               project,
   *               region,
   *               networkEndpointGroup,
   *               regionNetworkEndpointGroupsAttachEndpointsRequestResource)
   *           .get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param region The name of the region where you want to create the network endpoint group. It
   *     should comply with RFC1035.
   * @param networkEndpointGroup The name of the network endpoint group where you are attaching
   *     network endpoints to. It should comply with RFC1035.
   * @param regionNetworkEndpointGroupsAttachEndpointsRequestResource The body resource for this
   *     request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> attachNetworkEndpointsAsync(
      String project,
      String region,
      String networkEndpointGroup,
      RegionNetworkEndpointGroupsAttachEndpointsRequest
          regionNetworkEndpointGroupsAttachEndpointsRequestResource) {
    AttachNetworkEndpointsRegionNetworkEndpointGroupRequest request =
        AttachNetworkEndpointsRegionNetworkEndpointGroupRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setNetworkEndpointGroup(networkEndpointGroup)
            .setRegionNetworkEndpointGroupsAttachEndpointsRequestResource(
                regionNetworkEndpointGroupsAttachEndpointsRequestResource)
            .build();
    return attachNetworkEndpointsAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Attach a list of network endpoints to the specified network endpoint group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionNetworkEndpointGroupsClient regionNetworkEndpointGroupsClient =
   *     RegionNetworkEndpointGroupsClient.create()) {
   *   AttachNetworkEndpointsRegionNetworkEndpointGroupRequest request =
   *       AttachNetworkEndpointsRegionNetworkEndpointGroupRequest.newBuilder()
   *           .setNetworkEndpointGroup("networkEndpointGroup-2120389028")
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRegionNetworkEndpointGroupsAttachEndpointsRequestResource(
   *               RegionNetworkEndpointGroupsAttachEndpointsRequest.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Operation response =
   *       regionNetworkEndpointGroupsClient.attachNetworkEndpointsAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Operation, Operation> attachNetworkEndpointsAsync(
      AttachNetworkEndpointsRegionNetworkEndpointGroupRequest request) {
    return attachNetworkEndpointsOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Attach a list of network endpoints to the specified network endpoint group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionNetworkEndpointGroupsClient regionNetworkEndpointGroupsClient =
   *     RegionNetworkEndpointGroupsClient.create()) {
   *   AttachNetworkEndpointsRegionNetworkEndpointGroupRequest request =
   *       AttachNetworkEndpointsRegionNetworkEndpointGroupRequest.newBuilder()
   *           .setNetworkEndpointGroup("networkEndpointGroup-2120389028")
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRegionNetworkEndpointGroupsAttachEndpointsRequestResource(
   *               RegionNetworkEndpointGroupsAttachEndpointsRequest.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       regionNetworkEndpointGroupsClient
   *           .attachNetworkEndpointsOperationCallable()
   *           .futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          AttachNetworkEndpointsRegionNetworkEndpointGroupRequest, Operation, Operation>
      attachNetworkEndpointsOperationCallable() {
    return stub.attachNetworkEndpointsOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Attach a list of network endpoints to the specified network endpoint group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionNetworkEndpointGroupsClient regionNetworkEndpointGroupsClient =
   *     RegionNetworkEndpointGroupsClient.create()) {
   *   AttachNetworkEndpointsRegionNetworkEndpointGroupRequest request =
   *       AttachNetworkEndpointsRegionNetworkEndpointGroupRequest.newBuilder()
   *           .setNetworkEndpointGroup("networkEndpointGroup-2120389028")
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRegionNetworkEndpointGroupsAttachEndpointsRequestResource(
   *               RegionNetworkEndpointGroupsAttachEndpointsRequest.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       regionNetworkEndpointGroupsClient.attachNetworkEndpointsCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<AttachNetworkEndpointsRegionNetworkEndpointGroupRequest, Operation>
      attachNetworkEndpointsCallable() {
    return stub.attachNetworkEndpointsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified network endpoint group. Note that the NEG cannot be deleted if it is
   * configured as a backend of a backend service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionNetworkEndpointGroupsClient regionNetworkEndpointGroupsClient =
   *     RegionNetworkEndpointGroupsClient.create()) {
   *   String project = "project-309310695";
   *   String region = "region-934795532";
   *   String networkEndpointGroup = "networkEndpointGroup-2120389028";
   *   Operation response =
   *       regionNetworkEndpointGroupsClient
   *           .deleteAsync(project, region, networkEndpointGroup)
   *           .get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param region The name of the region where the network endpoint group is located. It should
   *     comply with RFC1035.
   * @param networkEndpointGroup The name of the network endpoint group to delete. It should comply
   *     with RFC1035.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> deleteAsync(
      String project, String region, String networkEndpointGroup) {
    DeleteRegionNetworkEndpointGroupRequest request =
        DeleteRegionNetworkEndpointGroupRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setNetworkEndpointGroup(networkEndpointGroup)
            .build();
    return deleteAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified network endpoint group. Note that the NEG cannot be deleted if it is
   * configured as a backend of a backend service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionNetworkEndpointGroupsClient regionNetworkEndpointGroupsClient =
   *     RegionNetworkEndpointGroupsClient.create()) {
   *   DeleteRegionNetworkEndpointGroupRequest request =
   *       DeleteRegionNetworkEndpointGroupRequest.newBuilder()
   *           .setNetworkEndpointGroup("networkEndpointGroup-2120389028")
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Operation response = regionNetworkEndpointGroupsClient.deleteAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Operation, Operation> deleteAsync(
      DeleteRegionNetworkEndpointGroupRequest request) {
    return deleteOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified network endpoint group. Note that the NEG cannot be deleted if it is
   * configured as a backend of a backend service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionNetworkEndpointGroupsClient regionNetworkEndpointGroupsClient =
   *     RegionNetworkEndpointGroupsClient.create()) {
   *   DeleteRegionNetworkEndpointGroupRequest request =
   *       DeleteRegionNetworkEndpointGroupRequest.newBuilder()
   *           .setNetworkEndpointGroup("networkEndpointGroup-2120389028")
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       regionNetworkEndpointGroupsClient.deleteOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteRegionNetworkEndpointGroupRequest, Operation, Operation>
      deleteOperationCallable() {
    return stub.deleteOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified network endpoint group. Note that the NEG cannot be deleted if it is
   * configured as a backend of a backend service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionNetworkEndpointGroupsClient regionNetworkEndpointGroupsClient =
   *     RegionNetworkEndpointGroupsClient.create()) {
   *   DeleteRegionNetworkEndpointGroupRequest request =
   *       DeleteRegionNetworkEndpointGroupRequest.newBuilder()
   *           .setNetworkEndpointGroup("networkEndpointGroup-2120389028")
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       regionNetworkEndpointGroupsClient.deleteCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteRegionNetworkEndpointGroupRequest, Operation> deleteCallable() {
    return stub.deleteCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Detach the network endpoint from the specified network endpoint group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionNetworkEndpointGroupsClient regionNetworkEndpointGroupsClient =
   *     RegionNetworkEndpointGroupsClient.create()) {
   *   String project = "project-309310695";
   *   String region = "region-934795532";
   *   String networkEndpointGroup = "networkEndpointGroup-2120389028";
   *   RegionNetworkEndpointGroupsDetachEndpointsRequest
   *       regionNetworkEndpointGroupsDetachEndpointsRequestResource =
   *           RegionNetworkEndpointGroupsDetachEndpointsRequest.newBuilder().build();
   *   Operation response =
   *       regionNetworkEndpointGroupsClient
   *           .detachNetworkEndpointsAsync(
   *               project,
   *               region,
   *               networkEndpointGroup,
   *               regionNetworkEndpointGroupsDetachEndpointsRequestResource)
   *           .get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param region The name of the region where the network endpoint group is located. It should
   *     comply with RFC1035.
   * @param networkEndpointGroup The name of the network endpoint group you are detaching network
   *     endpoints from. It should comply with RFC1035.
   * @param regionNetworkEndpointGroupsDetachEndpointsRequestResource The body resource for this
   *     request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> detachNetworkEndpointsAsync(
      String project,
      String region,
      String networkEndpointGroup,
      RegionNetworkEndpointGroupsDetachEndpointsRequest
          regionNetworkEndpointGroupsDetachEndpointsRequestResource) {
    DetachNetworkEndpointsRegionNetworkEndpointGroupRequest request =
        DetachNetworkEndpointsRegionNetworkEndpointGroupRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setNetworkEndpointGroup(networkEndpointGroup)
            .setRegionNetworkEndpointGroupsDetachEndpointsRequestResource(
                regionNetworkEndpointGroupsDetachEndpointsRequestResource)
            .build();
    return detachNetworkEndpointsAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Detach the network endpoint from the specified network endpoint group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionNetworkEndpointGroupsClient regionNetworkEndpointGroupsClient =
   *     RegionNetworkEndpointGroupsClient.create()) {
   *   DetachNetworkEndpointsRegionNetworkEndpointGroupRequest request =
   *       DetachNetworkEndpointsRegionNetworkEndpointGroupRequest.newBuilder()
   *           .setNetworkEndpointGroup("networkEndpointGroup-2120389028")
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRegionNetworkEndpointGroupsDetachEndpointsRequestResource(
   *               RegionNetworkEndpointGroupsDetachEndpointsRequest.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Operation response =
   *       regionNetworkEndpointGroupsClient.detachNetworkEndpointsAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Operation, Operation> detachNetworkEndpointsAsync(
      DetachNetworkEndpointsRegionNetworkEndpointGroupRequest request) {
    return detachNetworkEndpointsOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Detach the network endpoint from the specified network endpoint group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionNetworkEndpointGroupsClient regionNetworkEndpointGroupsClient =
   *     RegionNetworkEndpointGroupsClient.create()) {
   *   DetachNetworkEndpointsRegionNetworkEndpointGroupRequest request =
   *       DetachNetworkEndpointsRegionNetworkEndpointGroupRequest.newBuilder()
   *           .setNetworkEndpointGroup("networkEndpointGroup-2120389028")
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRegionNetworkEndpointGroupsDetachEndpointsRequestResource(
   *               RegionNetworkEndpointGroupsDetachEndpointsRequest.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       regionNetworkEndpointGroupsClient
   *           .detachNetworkEndpointsOperationCallable()
   *           .futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          DetachNetworkEndpointsRegionNetworkEndpointGroupRequest, Operation, Operation>
      detachNetworkEndpointsOperationCallable() {
    return stub.detachNetworkEndpointsOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Detach the network endpoint from the specified network endpoint group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionNetworkEndpointGroupsClient regionNetworkEndpointGroupsClient =
   *     RegionNetworkEndpointGroupsClient.create()) {
   *   DetachNetworkEndpointsRegionNetworkEndpointGroupRequest request =
   *       DetachNetworkEndpointsRegionNetworkEndpointGroupRequest.newBuilder()
   *           .setNetworkEndpointGroup("networkEndpointGroup-2120389028")
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRegionNetworkEndpointGroupsDetachEndpointsRequestResource(
   *               RegionNetworkEndpointGroupsDetachEndpointsRequest.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       regionNetworkEndpointGroupsClient.detachNetworkEndpointsCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DetachNetworkEndpointsRegionNetworkEndpointGroupRequest, Operation>
      detachNetworkEndpointsCallable() {
    return stub.detachNetworkEndpointsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified network endpoint group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionNetworkEndpointGroupsClient regionNetworkEndpointGroupsClient =
   *     RegionNetworkEndpointGroupsClient.create()) {
   *   String project = "project-309310695";
   *   String region = "region-934795532";
   *   String networkEndpointGroup = "networkEndpointGroup-2120389028";
   *   NetworkEndpointGroup response =
   *       regionNetworkEndpointGroupsClient.get(project, region, networkEndpointGroup);
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param region The name of the region where the network endpoint group is located. It should
   *     comply with RFC1035.
   * @param networkEndpointGroup The name of the network endpoint group. It should comply with
   *     RFC1035.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final NetworkEndpointGroup get(
      String project, String region, String networkEndpointGroup) {
    GetRegionNetworkEndpointGroupRequest request =
        GetRegionNetworkEndpointGroupRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setNetworkEndpointGroup(networkEndpointGroup)
            .build();
    return get(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified network endpoint group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionNetworkEndpointGroupsClient regionNetworkEndpointGroupsClient =
   *     RegionNetworkEndpointGroupsClient.create()) {
   *   GetRegionNetworkEndpointGroupRequest request =
   *       GetRegionNetworkEndpointGroupRequest.newBuilder()
   *           .setNetworkEndpointGroup("networkEndpointGroup-2120389028")
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .build();
   *   NetworkEndpointGroup response = regionNetworkEndpointGroupsClient.get(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final NetworkEndpointGroup get(GetRegionNetworkEndpointGroupRequest request) {
    return getCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified network endpoint group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionNetworkEndpointGroupsClient regionNetworkEndpointGroupsClient =
   *     RegionNetworkEndpointGroupsClient.create()) {
   *   GetRegionNetworkEndpointGroupRequest request =
   *       GetRegionNetworkEndpointGroupRequest.newBuilder()
   *           .setNetworkEndpointGroup("networkEndpointGroup-2120389028")
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .build();
   *   ApiFuture<NetworkEndpointGroup> future =
   *       regionNetworkEndpointGroupsClient.getCallable().futureCall(request);
   *   // Do something.
   *   NetworkEndpointGroup response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetRegionNetworkEndpointGroupRequest, NetworkEndpointGroup>
      getCallable() {
    return stub.getCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a network endpoint group in the specified project using the parameters that are
   * included in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionNetworkEndpointGroupsClient regionNetworkEndpointGroupsClient =
   *     RegionNetworkEndpointGroupsClient.create()) {
   *   String project = "project-309310695";
   *   String region = "region-934795532";
   *   NetworkEndpointGroup networkEndpointGroupResource = NetworkEndpointGroup.newBuilder().build();
   *   Operation response =
   *       regionNetworkEndpointGroupsClient
   *           .insertAsync(project, region, networkEndpointGroupResource)
   *           .get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param region The name of the region where you want to create the network endpoint group. It
   *     should comply with RFC1035.
   * @param networkEndpointGroupResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> insertAsync(
      String project, String region, NetworkEndpointGroup networkEndpointGroupResource) {
    InsertRegionNetworkEndpointGroupRequest request =
        InsertRegionNetworkEndpointGroupRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setNetworkEndpointGroupResource(networkEndpointGroupResource)
            .build();
    return insertAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a network endpoint group in the specified project using the parameters that are
   * included in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionNetworkEndpointGroupsClient regionNetworkEndpointGroupsClient =
   *     RegionNetworkEndpointGroupsClient.create()) {
   *   InsertRegionNetworkEndpointGroupRequest request =
   *       InsertRegionNetworkEndpointGroupRequest.newBuilder()
   *           .setNetworkEndpointGroupResource(NetworkEndpointGroup.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Operation response = regionNetworkEndpointGroupsClient.insertAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Operation, Operation> insertAsync(
      InsertRegionNetworkEndpointGroupRequest request) {
    return insertOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a network endpoint group in the specified project using the parameters that are
   * included in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionNetworkEndpointGroupsClient regionNetworkEndpointGroupsClient =
   *     RegionNetworkEndpointGroupsClient.create()) {
   *   InsertRegionNetworkEndpointGroupRequest request =
   *       InsertRegionNetworkEndpointGroupRequest.newBuilder()
   *           .setNetworkEndpointGroupResource(NetworkEndpointGroup.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       regionNetworkEndpointGroupsClient.insertOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<InsertRegionNetworkEndpointGroupRequest, Operation, Operation>
      insertOperationCallable() {
    return stub.insertOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a network endpoint group in the specified project using the parameters that are
   * included in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionNetworkEndpointGroupsClient regionNetworkEndpointGroupsClient =
   *     RegionNetworkEndpointGroupsClient.create()) {
   *   InsertRegionNetworkEndpointGroupRequest request =
   *       InsertRegionNetworkEndpointGroupRequest.newBuilder()
   *           .setNetworkEndpointGroupResource(NetworkEndpointGroup.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       regionNetworkEndpointGroupsClient.insertCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<InsertRegionNetworkEndpointGroupRequest, Operation> insertCallable() {
    return stub.insertCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the list of regional network endpoint groups available to the specified project in
   * the given region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionNetworkEndpointGroupsClient regionNetworkEndpointGroupsClient =
   *     RegionNetworkEndpointGroupsClient.create()) {
   *   String project = "project-309310695";
   *   String region = "region-934795532";
   *   for (NetworkEndpointGroup element :
   *       regionNetworkEndpointGroupsClient.list(project, region).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param region The name of the region where the network endpoint group is located. It should
   *     comply with RFC1035.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPagedResponse list(String project, String region) {
    ListRegionNetworkEndpointGroupsRequest request =
        ListRegionNetworkEndpointGroupsRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .build();
    return list(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the list of regional network endpoint groups available to the specified project in
   * the given region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionNetworkEndpointGroupsClient regionNetworkEndpointGroupsClient =
   *     RegionNetworkEndpointGroupsClient.create()) {
   *   ListRegionNetworkEndpointGroupsRequest request =
   *       ListRegionNetworkEndpointGroupsRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   for (NetworkEndpointGroup element :
   *       regionNetworkEndpointGroupsClient.list(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPagedResponse list(ListRegionNetworkEndpointGroupsRequest request) {
    return listPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the list of regional network endpoint groups available to the specified project in
   * the given region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionNetworkEndpointGroupsClient regionNetworkEndpointGroupsClient =
   *     RegionNetworkEndpointGroupsClient.create()) {
   *   ListRegionNetworkEndpointGroupsRequest request =
   *       ListRegionNetworkEndpointGroupsRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   ApiFuture<NetworkEndpointGroup> future =
   *       regionNetworkEndpointGroupsClient.listPagedCallable().futureCall(request);
   *   // Do something.
   *   for (NetworkEndpointGroup element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListRegionNetworkEndpointGroupsRequest, ListPagedResponse>
      listPagedCallable() {
    return stub.listPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the list of regional network endpoint groups available to the specified project in
   * the given region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionNetworkEndpointGroupsClient regionNetworkEndpointGroupsClient =
   *     RegionNetworkEndpointGroupsClient.create()) {
   *   ListRegionNetworkEndpointGroupsRequest request =
   *       ListRegionNetworkEndpointGroupsRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   while (true) {
   *     NetworkEndpointGroupList response =
   *         regionNetworkEndpointGroupsClient.listCallable().call(request);
   *     for (NetworkEndpointGroup element : response.getItemsList()) {
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
  public final UnaryCallable<ListRegionNetworkEndpointGroupsRequest, NetworkEndpointGroupList>
      listCallable() {
    return stub.listCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the network endpoints in the specified network endpoint group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionNetworkEndpointGroupsClient regionNetworkEndpointGroupsClient =
   *     RegionNetworkEndpointGroupsClient.create()) {
   *   String project = "project-309310695";
   *   String region = "region-934795532";
   *   String networkEndpointGroup = "networkEndpointGroup-2120389028";
   *   for (NetworkEndpointWithHealthStatus element :
   *       regionNetworkEndpointGroupsClient
   *           .listNetworkEndpoints(project, region, networkEndpointGroup)
   *           .iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param region The name of the region where the network endpoint group is located. It should
   *     comply with RFC1035.
   * @param networkEndpointGroup The name of the network endpoint group from which you want to
   *     generate a list of included network endpoints. It should comply with RFC1035.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListNetworkEndpointsPagedResponse listNetworkEndpoints(
      String project, String region, String networkEndpointGroup) {
    ListNetworkEndpointsRegionNetworkEndpointGroupsRequest request =
        ListNetworkEndpointsRegionNetworkEndpointGroupsRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setNetworkEndpointGroup(networkEndpointGroup)
            .build();
    return listNetworkEndpoints(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the network endpoints in the specified network endpoint group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionNetworkEndpointGroupsClient regionNetworkEndpointGroupsClient =
   *     RegionNetworkEndpointGroupsClient.create()) {
   *   ListNetworkEndpointsRegionNetworkEndpointGroupsRequest request =
   *       ListNetworkEndpointsRegionNetworkEndpointGroupsRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setNetworkEndpointGroup("networkEndpointGroup-2120389028")
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   for (NetworkEndpointWithHealthStatus element :
   *       regionNetworkEndpointGroupsClient.listNetworkEndpoints(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListNetworkEndpointsPagedResponse listNetworkEndpoints(
      ListNetworkEndpointsRegionNetworkEndpointGroupsRequest request) {
    return listNetworkEndpointsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the network endpoints in the specified network endpoint group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionNetworkEndpointGroupsClient regionNetworkEndpointGroupsClient =
   *     RegionNetworkEndpointGroupsClient.create()) {
   *   ListNetworkEndpointsRegionNetworkEndpointGroupsRequest request =
   *       ListNetworkEndpointsRegionNetworkEndpointGroupsRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setNetworkEndpointGroup("networkEndpointGroup-2120389028")
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   ApiFuture<NetworkEndpointWithHealthStatus> future =
   *       regionNetworkEndpointGroupsClient.listNetworkEndpointsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (NetworkEndpointWithHealthStatus element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<
          ListNetworkEndpointsRegionNetworkEndpointGroupsRequest, ListNetworkEndpointsPagedResponse>
      listNetworkEndpointsPagedCallable() {
    return stub.listNetworkEndpointsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the network endpoints in the specified network endpoint group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionNetworkEndpointGroupsClient regionNetworkEndpointGroupsClient =
   *     RegionNetworkEndpointGroupsClient.create()) {
   *   ListNetworkEndpointsRegionNetworkEndpointGroupsRequest request =
   *       ListNetworkEndpointsRegionNetworkEndpointGroupsRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setNetworkEndpointGroup("networkEndpointGroup-2120389028")
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   while (true) {
   *     NetworkEndpointGroupsListNetworkEndpoints response =
   *         regionNetworkEndpointGroupsClient.listNetworkEndpointsCallable().call(request);
   *     for (NetworkEndpointWithHealthStatus element : response.getItemsList()) {
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
  public final UnaryCallable<
          ListNetworkEndpointsRegionNetworkEndpointGroupsRequest,
          NetworkEndpointGroupsListNetworkEndpoints>
      listNetworkEndpointsCallable() {
    return stub.listNetworkEndpointsCallable();
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
          ListRegionNetworkEndpointGroupsRequest,
          NetworkEndpointGroupList,
          NetworkEndpointGroup,
          ListPage,
          ListFixedSizeCollection> {

    public static ApiFuture<ListPagedResponse> createAsync(
        PageContext<
                ListRegionNetworkEndpointGroupsRequest,
                NetworkEndpointGroupList,
                NetworkEndpointGroup>
            context,
        ApiFuture<NetworkEndpointGroupList> futureResponse) {
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
          ListRegionNetworkEndpointGroupsRequest,
          NetworkEndpointGroupList,
          NetworkEndpointGroup,
          ListPage> {

    private ListPage(
        PageContext<
                ListRegionNetworkEndpointGroupsRequest,
                NetworkEndpointGroupList,
                NetworkEndpointGroup>
            context,
        NetworkEndpointGroupList response) {
      super(context, response);
    }

    private static ListPage createEmptyPage() {
      return new ListPage(null, null);
    }

    @Override
    protected ListPage createPage(
        PageContext<
                ListRegionNetworkEndpointGroupsRequest,
                NetworkEndpointGroupList,
                NetworkEndpointGroup>
            context,
        NetworkEndpointGroupList response) {
      return new ListPage(context, response);
    }

    @Override
    public ApiFuture<ListPage> createPageAsync(
        PageContext<
                ListRegionNetworkEndpointGroupsRequest,
                NetworkEndpointGroupList,
                NetworkEndpointGroup>
            context,
        ApiFuture<NetworkEndpointGroupList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListRegionNetworkEndpointGroupsRequest,
          NetworkEndpointGroupList,
          NetworkEndpointGroup,
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

  public static class ListNetworkEndpointsPagedResponse
      extends AbstractPagedListResponse<
          ListNetworkEndpointsRegionNetworkEndpointGroupsRequest,
          NetworkEndpointGroupsListNetworkEndpoints,
          NetworkEndpointWithHealthStatus,
          ListNetworkEndpointsPage,
          ListNetworkEndpointsFixedSizeCollection> {

    public static ApiFuture<ListNetworkEndpointsPagedResponse> createAsync(
        PageContext<
                ListNetworkEndpointsRegionNetworkEndpointGroupsRequest,
                NetworkEndpointGroupsListNetworkEndpoints,
                NetworkEndpointWithHealthStatus>
            context,
        ApiFuture<NetworkEndpointGroupsListNetworkEndpoints> futureResponse) {
      ApiFuture<ListNetworkEndpointsPage> futurePage =
          ListNetworkEndpointsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListNetworkEndpointsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListNetworkEndpointsPagedResponse(ListNetworkEndpointsPage page) {
      super(page, ListNetworkEndpointsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListNetworkEndpointsPage
      extends AbstractPage<
          ListNetworkEndpointsRegionNetworkEndpointGroupsRequest,
          NetworkEndpointGroupsListNetworkEndpoints,
          NetworkEndpointWithHealthStatus,
          ListNetworkEndpointsPage> {

    private ListNetworkEndpointsPage(
        PageContext<
                ListNetworkEndpointsRegionNetworkEndpointGroupsRequest,
                NetworkEndpointGroupsListNetworkEndpoints,
                NetworkEndpointWithHealthStatus>
            context,
        NetworkEndpointGroupsListNetworkEndpoints response) {
      super(context, response);
    }

    private static ListNetworkEndpointsPage createEmptyPage() {
      return new ListNetworkEndpointsPage(null, null);
    }

    @Override
    protected ListNetworkEndpointsPage createPage(
        PageContext<
                ListNetworkEndpointsRegionNetworkEndpointGroupsRequest,
                NetworkEndpointGroupsListNetworkEndpoints,
                NetworkEndpointWithHealthStatus>
            context,
        NetworkEndpointGroupsListNetworkEndpoints response) {
      return new ListNetworkEndpointsPage(context, response);
    }

    @Override
    public ApiFuture<ListNetworkEndpointsPage> createPageAsync(
        PageContext<
                ListNetworkEndpointsRegionNetworkEndpointGroupsRequest,
                NetworkEndpointGroupsListNetworkEndpoints,
                NetworkEndpointWithHealthStatus>
            context,
        ApiFuture<NetworkEndpointGroupsListNetworkEndpoints> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListNetworkEndpointsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListNetworkEndpointsRegionNetworkEndpointGroupsRequest,
          NetworkEndpointGroupsListNetworkEndpoints,
          NetworkEndpointWithHealthStatus,
          ListNetworkEndpointsPage,
          ListNetworkEndpointsFixedSizeCollection> {

    private ListNetworkEndpointsFixedSizeCollection(
        List<ListNetworkEndpointsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListNetworkEndpointsFixedSizeCollection createEmptyCollection() {
      return new ListNetworkEndpointsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListNetworkEndpointsFixedSizeCollection createCollection(
        List<ListNetworkEndpointsPage> pages, int collectionSize) {
      return new ListNetworkEndpointsFixedSizeCollection(pages, collectionSize);
    }
  }
}
