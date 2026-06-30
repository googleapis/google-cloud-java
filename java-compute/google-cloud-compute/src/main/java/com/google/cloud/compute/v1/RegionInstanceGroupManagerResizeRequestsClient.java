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
import com.google.cloud.compute.v1.stub.RegionInstanceGroupManagerResizeRequestsStub;
import com.google.cloud.compute.v1.stub.RegionInstanceGroupManagerResizeRequestsStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: The RegionInstanceGroupManagerResizeRequests API.
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
 * try (RegionInstanceGroupManagerResizeRequestsClient
 *     regionInstanceGroupManagerResizeRequestsClient =
 *         RegionInstanceGroupManagerResizeRequestsClient.create()) {
 *   String project = "project-309310695";
 *   String region = "region-934795532";
 *   String instanceGroupManager = "instanceGroupManager-388242077";
 *   String resizeRequest = "resizeRequest-1656358085";
 *   InstanceGroupManagerResizeRequest response =
 *       regionInstanceGroupManagerResizeRequestsClient.get(
 *           project, region, instanceGroupManager, resizeRequest);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the RegionInstanceGroupManagerResizeRequestsClient object
 * to clean up resources such as threads. In the example above, try-with-resources is used, which
 * automatically calls close().
 *
 * <table>
 *    <caption>Methods</caption>
 *    <tr>
 *      <th>Method</th>
 *      <th>Description</th>
 *      <th>Method Variants</th>
 *    </tr>
 *    <tr>
 *      <td><p> Cancel</td>
 *      <td><p> Cancels the specified resize request. Cancelled resize request no longer waits for the resources to be provisioned. Cancel is only possible for requests that are in accepted state.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> cancelAsync(CancelRegionInstanceGroupManagerResizeRequestRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> cancelAsync(String project, String region, String instanceGroupManager, String resizeRequest)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> cancelOperationCallable()
 *           <li><p> cancelCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> Delete</td>
 *      <td><p> Deletes the specified, inactive resize request. Requests that are still active cannot be deleted. Deleting request does not delete instances that were provisioned previously.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteAsync(DeleteRegionInstanceGroupManagerResizeRequestRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteAsync(String project, String region, String instanceGroupManager, String resizeRequest)
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
 *      <td><p> Returns all of the details about the specified resize request.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> get(GetRegionInstanceGroupManagerResizeRequestRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> get(String project, String region, String instanceGroupManager, String resizeRequest)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> Insert</td>
 *      <td><p> Creates a new Resize Request that starts provisioning VMs immediately or queues VM creation.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> insertAsync(InsertRegionInstanceGroupManagerResizeRequestRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> insertAsync(String project, String region, String instanceGroupManager, InstanceGroupManagerResizeRequest instanceGroupManagerResizeRequestResource)
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
 *      <td><p> Retrieves a list of Resize Requests that are contained in the managed instance group.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> list(ListRegionInstanceGroupManagerResizeRequestsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> list(String project, String region, String instanceGroupManager)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listPagedCallable()
 *           <li><p> listCallable()
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
 * RegionInstanceGroupManagerResizeRequestsSettings to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * RegionInstanceGroupManagerResizeRequestsSettings
 *     regionInstanceGroupManagerResizeRequestsSettings =
 *         RegionInstanceGroupManagerResizeRequestsSettings.newBuilder()
 *             .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *             .build();
 * RegionInstanceGroupManagerResizeRequestsClient regionInstanceGroupManagerResizeRequestsClient =
 *     RegionInstanceGroupManagerResizeRequestsClient.create(
 *         regionInstanceGroupManagerResizeRequestsSettings);
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
 * RegionInstanceGroupManagerResizeRequestsSettings
 *     regionInstanceGroupManagerResizeRequestsSettings =
 *         RegionInstanceGroupManagerResizeRequestsSettings.newBuilder()
 *             .setEndpoint(myEndpoint)
 *             .build();
 * RegionInstanceGroupManagerResizeRequestsClient regionInstanceGroupManagerResizeRequestsClient =
 *     RegionInstanceGroupManagerResizeRequestsClient.create(
 *         regionInstanceGroupManagerResizeRequestsSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class RegionInstanceGroupManagerResizeRequestsClient implements BackgroundResource {
  private final RegionInstanceGroupManagerResizeRequestsSettings settings;
  private final RegionInstanceGroupManagerResizeRequestsStub stub;

  /**
   * Constructs an instance of RegionInstanceGroupManagerResizeRequestsClient with default settings.
   */
  public static final RegionInstanceGroupManagerResizeRequestsClient create() throws IOException {
    return create(RegionInstanceGroupManagerResizeRequestsSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of RegionInstanceGroupManagerResizeRequestsClient, using the given
   * settings. The channels are created based on the settings passed in, or defaults for any
   * settings that are not set.
   */
  public static final RegionInstanceGroupManagerResizeRequestsClient create(
      RegionInstanceGroupManagerResizeRequestsSettings settings) throws IOException {
    return new RegionInstanceGroupManagerResizeRequestsClient(settings);
  }

  /**
   * Constructs an instance of RegionInstanceGroupManagerResizeRequestsClient, using the given stub
   * for making calls. This is for advanced usage - prefer using
   * create(RegionInstanceGroupManagerResizeRequestsSettings).
   */
  public static final RegionInstanceGroupManagerResizeRequestsClient create(
      RegionInstanceGroupManagerResizeRequestsStub stub) {
    return new RegionInstanceGroupManagerResizeRequestsClient(stub);
  }

  /**
   * Constructs an instance of RegionInstanceGroupManagerResizeRequestsClient, using the given
   * settings. This is protected so that it is easy to make a subclass, but otherwise, the static
   * factory methods should be preferred.
   */
  protected RegionInstanceGroupManagerResizeRequestsClient(
      RegionInstanceGroupManagerResizeRequestsSettings settings) throws IOException {
    this.settings = settings;
    this.stub =
        ((RegionInstanceGroupManagerResizeRequestsStubSettings) settings.getStubSettings())
            .createStub();
  }

  protected RegionInstanceGroupManagerResizeRequestsClient(
      RegionInstanceGroupManagerResizeRequestsStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final RegionInstanceGroupManagerResizeRequestsSettings getSettings() {
    return settings;
  }

  public RegionInstanceGroupManagerResizeRequestsStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Cancels the specified resize request. Cancelled resize request no longer waits for the
   * resources to be provisioned. Cancel is only possible for requests that are in accepted state.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionInstanceGroupManagerResizeRequestsClient
   *     regionInstanceGroupManagerResizeRequestsClient =
   *         RegionInstanceGroupManagerResizeRequestsClient.create()) {
   *   String project = "project-309310695";
   *   String region = "region-934795532";
   *   String instanceGroupManager = "instanceGroupManager-388242077";
   *   String resizeRequest = "resizeRequest-1656358085";
   *   Operation response =
   *       regionInstanceGroupManagerResizeRequestsClient
   *           .cancelAsync(project, region, instanceGroupManager, resizeRequest)
   *           .get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param region The name of the region scoping this request. Name should conform to RFC1035.
   * @param instanceGroupManager The name of the managed instance group. Name should conform to
   *     RFC1035 or be a resource ID.
   * @param resizeRequest The name of the resize request to cancel. Name should conform to RFC1035
   *     or be a resource ID.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> cancelAsync(
      String project, String region, String instanceGroupManager, String resizeRequest) {
    CancelRegionInstanceGroupManagerResizeRequestRequest request =
        CancelRegionInstanceGroupManagerResizeRequestRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setInstanceGroupManager(instanceGroupManager)
            .setResizeRequest(resizeRequest)
            .build();
    return cancelAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Cancels the specified resize request. Cancelled resize request no longer waits for the
   * resources to be provisioned. Cancel is only possible for requests that are in accepted state.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionInstanceGroupManagerResizeRequestsClient
   *     regionInstanceGroupManagerResizeRequestsClient =
   *         RegionInstanceGroupManagerResizeRequestsClient.create()) {
   *   CancelRegionInstanceGroupManagerResizeRequestRequest request =
   *       CancelRegionInstanceGroupManagerResizeRequestRequest.newBuilder()
   *           .setInstanceGroupManager("instanceGroupManager-388242077")
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .setResizeRequest("resizeRequest-1656358085")
   *           .build();
   *   Operation response =
   *       regionInstanceGroupManagerResizeRequestsClient.cancelAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> cancelAsync(
      CancelRegionInstanceGroupManagerResizeRequestRequest request) {
    return cancelOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Cancels the specified resize request. Cancelled resize request no longer waits for the
   * resources to be provisioned. Cancel is only possible for requests that are in accepted state.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionInstanceGroupManagerResizeRequestsClient
   *     regionInstanceGroupManagerResizeRequestsClient =
   *         RegionInstanceGroupManagerResizeRequestsClient.create()) {
   *   CancelRegionInstanceGroupManagerResizeRequestRequest request =
   *       CancelRegionInstanceGroupManagerResizeRequestRequest.newBuilder()
   *           .setInstanceGroupManager("instanceGroupManager-388242077")
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .setResizeRequest("resizeRequest-1656358085")
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       regionInstanceGroupManagerResizeRequestsClient
   *           .cancelOperationCallable()
   *           .futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          CancelRegionInstanceGroupManagerResizeRequestRequest, Operation, Operation>
      cancelOperationCallable() {
    return stub.cancelOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Cancels the specified resize request. Cancelled resize request no longer waits for the
   * resources to be provisioned. Cancel is only possible for requests that are in accepted state.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionInstanceGroupManagerResizeRequestsClient
   *     regionInstanceGroupManagerResizeRequestsClient =
   *         RegionInstanceGroupManagerResizeRequestsClient.create()) {
   *   CancelRegionInstanceGroupManagerResizeRequestRequest request =
   *       CancelRegionInstanceGroupManagerResizeRequestRequest.newBuilder()
   *           .setInstanceGroupManager("instanceGroupManager-388242077")
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .setResizeRequest("resizeRequest-1656358085")
   *           .build();
   *   ApiFuture<Operation> future =
   *       regionInstanceGroupManagerResizeRequestsClient.cancelCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CancelRegionInstanceGroupManagerResizeRequestRequest, Operation>
      cancelCallable() {
    return stub.cancelCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified, inactive resize request. Requests that are still active cannot be
   * deleted. Deleting request does not delete instances that were provisioned previously.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionInstanceGroupManagerResizeRequestsClient
   *     regionInstanceGroupManagerResizeRequestsClient =
   *         RegionInstanceGroupManagerResizeRequestsClient.create()) {
   *   String project = "project-309310695";
   *   String region = "region-934795532";
   *   String instanceGroupManager = "instanceGroupManager-388242077";
   *   String resizeRequest = "resizeRequest-1656358085";
   *   Operation response =
   *       regionInstanceGroupManagerResizeRequestsClient
   *           .deleteAsync(project, region, instanceGroupManager, resizeRequest)
   *           .get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param region The name of the region scoping this request. Name should conform to RFC1035.
   * @param instanceGroupManager The name of the managed instance group. Name should conform to
   *     RFC1035 or be a resource ID.
   * @param resizeRequest The name of the resize request to delete. Name should conform to RFC1035
   *     or be a resource ID.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> deleteAsync(
      String project, String region, String instanceGroupManager, String resizeRequest) {
    DeleteRegionInstanceGroupManagerResizeRequestRequest request =
        DeleteRegionInstanceGroupManagerResizeRequestRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setInstanceGroupManager(instanceGroupManager)
            .setResizeRequest(resizeRequest)
            .build();
    return deleteAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified, inactive resize request. Requests that are still active cannot be
   * deleted. Deleting request does not delete instances that were provisioned previously.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionInstanceGroupManagerResizeRequestsClient
   *     regionInstanceGroupManagerResizeRequestsClient =
   *         RegionInstanceGroupManagerResizeRequestsClient.create()) {
   *   DeleteRegionInstanceGroupManagerResizeRequestRequest request =
   *       DeleteRegionInstanceGroupManagerResizeRequestRequest.newBuilder()
   *           .setInstanceGroupManager("instanceGroupManager-388242077")
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .setResizeRequest("resizeRequest-1656358085")
   *           .build();
   *   Operation response =
   *       regionInstanceGroupManagerResizeRequestsClient.deleteAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> deleteAsync(
      DeleteRegionInstanceGroupManagerResizeRequestRequest request) {
    return deleteOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified, inactive resize request. Requests that are still active cannot be
   * deleted. Deleting request does not delete instances that were provisioned previously.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionInstanceGroupManagerResizeRequestsClient
   *     regionInstanceGroupManagerResizeRequestsClient =
   *         RegionInstanceGroupManagerResizeRequestsClient.create()) {
   *   DeleteRegionInstanceGroupManagerResizeRequestRequest request =
   *       DeleteRegionInstanceGroupManagerResizeRequestRequest.newBuilder()
   *           .setInstanceGroupManager("instanceGroupManager-388242077")
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .setResizeRequest("resizeRequest-1656358085")
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       regionInstanceGroupManagerResizeRequestsClient
   *           .deleteOperationCallable()
   *           .futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          DeleteRegionInstanceGroupManagerResizeRequestRequest, Operation, Operation>
      deleteOperationCallable() {
    return stub.deleteOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified, inactive resize request. Requests that are still active cannot be
   * deleted. Deleting request does not delete instances that were provisioned previously.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionInstanceGroupManagerResizeRequestsClient
   *     regionInstanceGroupManagerResizeRequestsClient =
   *         RegionInstanceGroupManagerResizeRequestsClient.create()) {
   *   DeleteRegionInstanceGroupManagerResizeRequestRequest request =
   *       DeleteRegionInstanceGroupManagerResizeRequestRequest.newBuilder()
   *           .setInstanceGroupManager("instanceGroupManager-388242077")
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .setResizeRequest("resizeRequest-1656358085")
   *           .build();
   *   ApiFuture<Operation> future =
   *       regionInstanceGroupManagerResizeRequestsClient.deleteCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteRegionInstanceGroupManagerResizeRequestRequest, Operation>
      deleteCallable() {
    return stub.deleteCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns all of the details about the specified resize request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionInstanceGroupManagerResizeRequestsClient
   *     regionInstanceGroupManagerResizeRequestsClient =
   *         RegionInstanceGroupManagerResizeRequestsClient.create()) {
   *   String project = "project-309310695";
   *   String region = "region-934795532";
   *   String instanceGroupManager = "instanceGroupManager-388242077";
   *   String resizeRequest = "resizeRequest-1656358085";
   *   InstanceGroupManagerResizeRequest response =
   *       regionInstanceGroupManagerResizeRequestsClient.get(
   *           project, region, instanceGroupManager, resizeRequest);
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param region The name of the region scoping this request. Name should conform to RFC1035.
   * @param instanceGroupManager The name of the managed instance group. Name should conform to
   *     RFC1035 or be a resource ID.
   * @param resizeRequest The name of the resize request. Name should conform to RFC1035 or be a
   *     resource ID.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final InstanceGroupManagerResizeRequest get(
      String project, String region, String instanceGroupManager, String resizeRequest) {
    GetRegionInstanceGroupManagerResizeRequestRequest request =
        GetRegionInstanceGroupManagerResizeRequestRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setInstanceGroupManager(instanceGroupManager)
            .setResizeRequest(resizeRequest)
            .build();
    return get(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns all of the details about the specified resize request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionInstanceGroupManagerResizeRequestsClient
   *     regionInstanceGroupManagerResizeRequestsClient =
   *         RegionInstanceGroupManagerResizeRequestsClient.create()) {
   *   GetRegionInstanceGroupManagerResizeRequestRequest request =
   *       GetRegionInstanceGroupManagerResizeRequestRequest.newBuilder()
   *           .setInstanceGroupManager("instanceGroupManager-388242077")
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setResizeRequest("resizeRequest-1656358085")
   *           .build();
   *   InstanceGroupManagerResizeRequest response =
   *       regionInstanceGroupManagerResizeRequestsClient.get(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final InstanceGroupManagerResizeRequest get(
      GetRegionInstanceGroupManagerResizeRequestRequest request) {
    return getCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns all of the details about the specified resize request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionInstanceGroupManagerResizeRequestsClient
   *     regionInstanceGroupManagerResizeRequestsClient =
   *         RegionInstanceGroupManagerResizeRequestsClient.create()) {
   *   GetRegionInstanceGroupManagerResizeRequestRequest request =
   *       GetRegionInstanceGroupManagerResizeRequestRequest.newBuilder()
   *           .setInstanceGroupManager("instanceGroupManager-388242077")
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setResizeRequest("resizeRequest-1656358085")
   *           .build();
   *   ApiFuture<InstanceGroupManagerResizeRequest> future =
   *       regionInstanceGroupManagerResizeRequestsClient.getCallable().futureCall(request);
   *   // Do something.
   *   InstanceGroupManagerResizeRequest response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<
          GetRegionInstanceGroupManagerResizeRequestRequest, InstanceGroupManagerResizeRequest>
      getCallable() {
    return stub.getCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Resize Request that starts provisioning VMs immediately or queues VM creation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionInstanceGroupManagerResizeRequestsClient
   *     regionInstanceGroupManagerResizeRequestsClient =
   *         RegionInstanceGroupManagerResizeRequestsClient.create()) {
   *   String project = "project-309310695";
   *   String region = "region-934795532";
   *   String instanceGroupManager = "instanceGroupManager-388242077";
   *   InstanceGroupManagerResizeRequest instanceGroupManagerResizeRequestResource =
   *       InstanceGroupManagerResizeRequest.newBuilder().build();
   *   Operation response =
   *       regionInstanceGroupManagerResizeRequestsClient
   *           .insertAsync(
   *               project, region, instanceGroupManager, instanceGroupManagerResizeRequestResource)
   *           .get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region scoping this request. Name should conform to RFC1035.
   * @param instanceGroupManager Name of the managed instance group to which the resize request is
   *     scoped. Name should conform to RFC1035 or be a resource ID.
   * @param instanceGroupManagerResizeRequestResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> insertAsync(
      String project,
      String region,
      String instanceGroupManager,
      InstanceGroupManagerResizeRequest instanceGroupManagerResizeRequestResource) {
    InsertRegionInstanceGroupManagerResizeRequestRequest request =
        InsertRegionInstanceGroupManagerResizeRequestRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setInstanceGroupManager(instanceGroupManager)
            .setInstanceGroupManagerResizeRequestResource(instanceGroupManagerResizeRequestResource)
            .build();
    return insertAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Resize Request that starts provisioning VMs immediately or queues VM creation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionInstanceGroupManagerResizeRequestsClient
   *     regionInstanceGroupManagerResizeRequestsClient =
   *         RegionInstanceGroupManagerResizeRequestsClient.create()) {
   *   InsertRegionInstanceGroupManagerResizeRequestRequest request =
   *       InsertRegionInstanceGroupManagerResizeRequestRequest.newBuilder()
   *           .setInstanceGroupManager("instanceGroupManager-388242077")
   *           .setInstanceGroupManagerResizeRequestResource(
   *               InstanceGroupManagerResizeRequest.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Operation response =
   *       regionInstanceGroupManagerResizeRequestsClient.insertAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> insertAsync(
      InsertRegionInstanceGroupManagerResizeRequestRequest request) {
    return insertOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Resize Request that starts provisioning VMs immediately or queues VM creation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionInstanceGroupManagerResizeRequestsClient
   *     regionInstanceGroupManagerResizeRequestsClient =
   *         RegionInstanceGroupManagerResizeRequestsClient.create()) {
   *   InsertRegionInstanceGroupManagerResizeRequestRequest request =
   *       InsertRegionInstanceGroupManagerResizeRequestRequest.newBuilder()
   *           .setInstanceGroupManager("instanceGroupManager-388242077")
   *           .setInstanceGroupManagerResizeRequestResource(
   *               InstanceGroupManagerResizeRequest.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       regionInstanceGroupManagerResizeRequestsClient
   *           .insertOperationCallable()
   *           .futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          InsertRegionInstanceGroupManagerResizeRequestRequest, Operation, Operation>
      insertOperationCallable() {
    return stub.insertOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Resize Request that starts provisioning VMs immediately or queues VM creation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionInstanceGroupManagerResizeRequestsClient
   *     regionInstanceGroupManagerResizeRequestsClient =
   *         RegionInstanceGroupManagerResizeRequestsClient.create()) {
   *   InsertRegionInstanceGroupManagerResizeRequestRequest request =
   *       InsertRegionInstanceGroupManagerResizeRequestRequest.newBuilder()
   *           .setInstanceGroupManager("instanceGroupManager-388242077")
   *           .setInstanceGroupManagerResizeRequestResource(
   *               InstanceGroupManagerResizeRequest.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       regionInstanceGroupManagerResizeRequestsClient.insertCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<InsertRegionInstanceGroupManagerResizeRequestRequest, Operation>
      insertCallable() {
    return stub.insertCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a list of Resize Requests that are contained in the managed instance group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionInstanceGroupManagerResizeRequestsClient
   *     regionInstanceGroupManagerResizeRequestsClient =
   *         RegionInstanceGroupManagerResizeRequestsClient.create()) {
   *   String project = "project-309310695";
   *   String region = "region-934795532";
   *   String instanceGroupManager = "instanceGroupManager-388242077";
   *   for (InstanceGroupManagerResizeRequest element :
   *       regionInstanceGroupManagerResizeRequestsClient
   *           .list(project, region, instanceGroupManager)
   *           .iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region scoping this request. Name should conform to RFC1035.
   * @param instanceGroupManager The name of the managed instance group. The name should conform to
   *     RFC1035.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPagedResponse list(String project, String region, String instanceGroupManager) {
    ListRegionInstanceGroupManagerResizeRequestsRequest request =
        ListRegionInstanceGroupManagerResizeRequestsRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setInstanceGroupManager(instanceGroupManager)
            .build();
    return list(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a list of Resize Requests that are contained in the managed instance group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionInstanceGroupManagerResizeRequestsClient
   *     regionInstanceGroupManagerResizeRequestsClient =
   *         RegionInstanceGroupManagerResizeRequestsClient.create()) {
   *   ListRegionInstanceGroupManagerResizeRequestsRequest request =
   *       ListRegionInstanceGroupManagerResizeRequestsRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setInstanceGroupManager("instanceGroupManager-388242077")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   for (InstanceGroupManagerResizeRequest element :
   *       regionInstanceGroupManagerResizeRequestsClient.list(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPagedResponse list(ListRegionInstanceGroupManagerResizeRequestsRequest request) {
    return listPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a list of Resize Requests that are contained in the managed instance group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionInstanceGroupManagerResizeRequestsClient
   *     regionInstanceGroupManagerResizeRequestsClient =
   *         RegionInstanceGroupManagerResizeRequestsClient.create()) {
   *   ListRegionInstanceGroupManagerResizeRequestsRequest request =
   *       ListRegionInstanceGroupManagerResizeRequestsRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setInstanceGroupManager("instanceGroupManager-388242077")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   ApiFuture<InstanceGroupManagerResizeRequest> future =
   *       regionInstanceGroupManagerResizeRequestsClient.listPagedCallable().futureCall(request);
   *   // Do something.
   *   for (InstanceGroupManagerResizeRequest element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListRegionInstanceGroupManagerResizeRequestsRequest, ListPagedResponse>
      listPagedCallable() {
    return stub.listPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a list of Resize Requests that are contained in the managed instance group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionInstanceGroupManagerResizeRequestsClient
   *     regionInstanceGroupManagerResizeRequestsClient =
   *         RegionInstanceGroupManagerResizeRequestsClient.create()) {
   *   ListRegionInstanceGroupManagerResizeRequestsRequest request =
   *       ListRegionInstanceGroupManagerResizeRequestsRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setInstanceGroupManager("instanceGroupManager-388242077")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   while (true) {
   *     RegionInstanceGroupManagerResizeRequestsListResponse response =
   *         regionInstanceGroupManagerResizeRequestsClient.listCallable().call(request);
   *     for (InstanceGroupManagerResizeRequest element : response.getItemsList()) {
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
          ListRegionInstanceGroupManagerResizeRequestsRequest,
          RegionInstanceGroupManagerResizeRequestsListResponse>
      listCallable() {
    return stub.listCallable();
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
          ListRegionInstanceGroupManagerResizeRequestsRequest,
          RegionInstanceGroupManagerResizeRequestsListResponse,
          InstanceGroupManagerResizeRequest,
          ListPage,
          ListFixedSizeCollection> {

    public static ApiFuture<ListPagedResponse> createAsync(
        PageContext<
                ListRegionInstanceGroupManagerResizeRequestsRequest,
                RegionInstanceGroupManagerResizeRequestsListResponse,
                InstanceGroupManagerResizeRequest>
            context,
        ApiFuture<RegionInstanceGroupManagerResizeRequestsListResponse> futureResponse) {
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
          ListRegionInstanceGroupManagerResizeRequestsRequest,
          RegionInstanceGroupManagerResizeRequestsListResponse,
          InstanceGroupManagerResizeRequest,
          ListPage> {

    private ListPage(
        PageContext<
                ListRegionInstanceGroupManagerResizeRequestsRequest,
                RegionInstanceGroupManagerResizeRequestsListResponse,
                InstanceGroupManagerResizeRequest>
            context,
        RegionInstanceGroupManagerResizeRequestsListResponse response) {
      super(context, response);
    }

    private static ListPage createEmptyPage() {
      return new ListPage(null, null);
    }

    @Override
    protected ListPage createPage(
        PageContext<
                ListRegionInstanceGroupManagerResizeRequestsRequest,
                RegionInstanceGroupManagerResizeRequestsListResponse,
                InstanceGroupManagerResizeRequest>
            context,
        RegionInstanceGroupManagerResizeRequestsListResponse response) {
      return new ListPage(context, response);
    }

    @Override
    public ApiFuture<ListPage> createPageAsync(
        PageContext<
                ListRegionInstanceGroupManagerResizeRequestsRequest,
                RegionInstanceGroupManagerResizeRequestsListResponse,
                InstanceGroupManagerResizeRequest>
            context,
        ApiFuture<RegionInstanceGroupManagerResizeRequestsListResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListRegionInstanceGroupManagerResizeRequestsRequest,
          RegionInstanceGroupManagerResizeRequestsListResponse,
          InstanceGroupManagerResizeRequest,
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
