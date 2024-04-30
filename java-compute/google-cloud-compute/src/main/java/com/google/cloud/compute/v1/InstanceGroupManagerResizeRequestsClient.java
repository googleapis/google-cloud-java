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
import com.google.cloud.compute.v1.stub.InstanceGroupManagerResizeRequestsStub;
import com.google.cloud.compute.v1.stub.InstanceGroupManagerResizeRequestsStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: The InstanceGroupManagerResizeRequests API.
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
 * try (InstanceGroupManagerResizeRequestsClient instanceGroupManagerResizeRequestsClient =
 *     InstanceGroupManagerResizeRequestsClient.create()) {
 *   String project = "project-309310695";
 *   String zone = "zone3744684";
 *   String instanceGroupManager = "instanceGroupManager-388242077";
 *   String resizeRequest = "resizeRequest-1656358085";
 *   InstanceGroupManagerResizeRequest response =
 *       instanceGroupManagerResizeRequestsClient.get(
 *           project, zone, instanceGroupManager, resizeRequest);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the InstanceGroupManagerResizeRequestsClient object to
 * clean up resources such as threads. In the example above, try-with-resources is used, which
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
 *      <td><p> Cancels the specified resize request and removes it from the queue. Cancelled resize request does no longer wait for the resources to be provisioned. Cancel is only possible for requests that are accepted in the queue.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> cancelAsync(CancelInstanceGroupManagerResizeRequestRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> cancelAsync(String project, String zone, String instanceGroupManager, String resizeRequest)
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
 *           <li><p> deleteAsync(DeleteInstanceGroupManagerResizeRequestRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteAsync(String project, String zone, String instanceGroupManager, String resizeRequest)
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
 *           <li><p> get(GetInstanceGroupManagerResizeRequestRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> get(String project, String zone, String instanceGroupManager, String resizeRequest)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> Insert</td>
 *      <td><p> Creates a new resize request that starts provisioning VMs immediately or queues VM creation.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> insertAsync(InsertInstanceGroupManagerResizeRequestRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> insertAsync(String project, String zone, String instanceGroupManager, InstanceGroupManagerResizeRequest instanceGroupManagerResizeRequestResource)
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
 *      <td><p> Retrieves a list of resize requests that are contained in the managed instance group.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> list(ListInstanceGroupManagerResizeRequestsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> list(String project, String zone, String instanceGroupManager)
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
 * InstanceGroupManagerResizeRequestsSettings to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * InstanceGroupManagerResizeRequestsSettings instanceGroupManagerResizeRequestsSettings =
 *     InstanceGroupManagerResizeRequestsSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * InstanceGroupManagerResizeRequestsClient instanceGroupManagerResizeRequestsClient =
 *     InstanceGroupManagerResizeRequestsClient.create(instanceGroupManagerResizeRequestsSettings);
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
 * InstanceGroupManagerResizeRequestsSettings instanceGroupManagerResizeRequestsSettings =
 *     InstanceGroupManagerResizeRequestsSettings.newBuilder().setEndpoint(myEndpoint).build();
 * InstanceGroupManagerResizeRequestsClient instanceGroupManagerResizeRequestsClient =
 *     InstanceGroupManagerResizeRequestsClient.create(instanceGroupManagerResizeRequestsSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class InstanceGroupManagerResizeRequestsClient implements BackgroundResource {
  private final InstanceGroupManagerResizeRequestsSettings settings;
  private final InstanceGroupManagerResizeRequestsStub stub;

  /** Constructs an instance of InstanceGroupManagerResizeRequestsClient with default settings. */
  public static final InstanceGroupManagerResizeRequestsClient create() throws IOException {
    return create(InstanceGroupManagerResizeRequestsSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of InstanceGroupManagerResizeRequestsClient, using the given settings.
   * The channels are created based on the settings passed in, or defaults for any settings that are
   * not set.
   */
  public static final InstanceGroupManagerResizeRequestsClient create(
      InstanceGroupManagerResizeRequestsSettings settings) throws IOException {
    return new InstanceGroupManagerResizeRequestsClient(settings);
  }

  /**
   * Constructs an instance of InstanceGroupManagerResizeRequestsClient, using the given stub for
   * making calls. This is for advanced usage - prefer using
   * create(InstanceGroupManagerResizeRequestsSettings).
   */
  public static final InstanceGroupManagerResizeRequestsClient create(
      InstanceGroupManagerResizeRequestsStub stub) {
    return new InstanceGroupManagerResizeRequestsClient(stub);
  }

  /**
   * Constructs an instance of InstanceGroupManagerResizeRequestsClient, using the given settings.
   * This is protected so that it is easy to make a subclass, but otherwise, the static factory
   * methods should be preferred.
   */
  protected InstanceGroupManagerResizeRequestsClient(
      InstanceGroupManagerResizeRequestsSettings settings) throws IOException {
    this.settings = settings;
    this.stub =
        ((InstanceGroupManagerResizeRequestsStubSettings) settings.getStubSettings()).createStub();
  }

  protected InstanceGroupManagerResizeRequestsClient(InstanceGroupManagerResizeRequestsStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final InstanceGroupManagerResizeRequestsSettings getSettings() {
    return settings;
  }

  public InstanceGroupManagerResizeRequestsStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Cancels the specified resize request and removes it from the queue. Cancelled resize request
   * does no longer wait for the resources to be provisioned. Cancel is only possible for requests
   * that are accepted in the queue.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InstanceGroupManagerResizeRequestsClient instanceGroupManagerResizeRequestsClient =
   *     InstanceGroupManagerResizeRequestsClient.create()) {
   *   String project = "project-309310695";
   *   String zone = "zone3744684";
   *   String instanceGroupManager = "instanceGroupManager-388242077";
   *   String resizeRequest = "resizeRequest-1656358085";
   *   Operation response =
   *       instanceGroupManagerResizeRequestsClient
   *           .cancelAsync(project, zone, instanceGroupManager, resizeRequest)
   *           .get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param zone The name of the zone where the managed instance group is located. The name should
   *     conform to RFC1035.
   * @param instanceGroupManager The name of the managed instance group. The name should conform to
   *     RFC1035 or be a resource ID.
   * @param resizeRequest The name of the resize request to cancel. The name should conform to
   *     RFC1035 or be a resource ID.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> cancelAsync(
      String project, String zone, String instanceGroupManager, String resizeRequest) {
    CancelInstanceGroupManagerResizeRequestRequest request =
        CancelInstanceGroupManagerResizeRequestRequest.newBuilder()
            .setProject(project)
            .setZone(zone)
            .setInstanceGroupManager(instanceGroupManager)
            .setResizeRequest(resizeRequest)
            .build();
    return cancelAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Cancels the specified resize request and removes it from the queue. Cancelled resize request
   * does no longer wait for the resources to be provisioned. Cancel is only possible for requests
   * that are accepted in the queue.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InstanceGroupManagerResizeRequestsClient instanceGroupManagerResizeRequestsClient =
   *     InstanceGroupManagerResizeRequestsClient.create()) {
   *   CancelInstanceGroupManagerResizeRequestRequest request =
   *       CancelInstanceGroupManagerResizeRequestRequest.newBuilder()
   *           .setInstanceGroupManager("instanceGroupManager-388242077")
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setResizeRequest("resizeRequest-1656358085")
   *           .setZone("zone3744684")
   *           .build();
   *   Operation response = instanceGroupManagerResizeRequestsClient.cancelAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> cancelAsync(
      CancelInstanceGroupManagerResizeRequestRequest request) {
    return cancelOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Cancels the specified resize request and removes it from the queue. Cancelled resize request
   * does no longer wait for the resources to be provisioned. Cancel is only possible for requests
   * that are accepted in the queue.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InstanceGroupManagerResizeRequestsClient instanceGroupManagerResizeRequestsClient =
   *     InstanceGroupManagerResizeRequestsClient.create()) {
   *   CancelInstanceGroupManagerResizeRequestRequest request =
   *       CancelInstanceGroupManagerResizeRequestRequest.newBuilder()
   *           .setInstanceGroupManager("instanceGroupManager-388242077")
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setResizeRequest("resizeRequest-1656358085")
   *           .setZone("zone3744684")
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       instanceGroupManagerResizeRequestsClient.cancelOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          CancelInstanceGroupManagerResizeRequestRequest, Operation, Operation>
      cancelOperationCallable() {
    return stub.cancelOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Cancels the specified resize request and removes it from the queue. Cancelled resize request
   * does no longer wait for the resources to be provisioned. Cancel is only possible for requests
   * that are accepted in the queue.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InstanceGroupManagerResizeRequestsClient instanceGroupManagerResizeRequestsClient =
   *     InstanceGroupManagerResizeRequestsClient.create()) {
   *   CancelInstanceGroupManagerResizeRequestRequest request =
   *       CancelInstanceGroupManagerResizeRequestRequest.newBuilder()
   *           .setInstanceGroupManager("instanceGroupManager-388242077")
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setResizeRequest("resizeRequest-1656358085")
   *           .setZone("zone3744684")
   *           .build();
   *   ApiFuture<Operation> future =
   *       instanceGroupManagerResizeRequestsClient.cancelCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CancelInstanceGroupManagerResizeRequestRequest, Operation>
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
   * try (InstanceGroupManagerResizeRequestsClient instanceGroupManagerResizeRequestsClient =
   *     InstanceGroupManagerResizeRequestsClient.create()) {
   *   String project = "project-309310695";
   *   String zone = "zone3744684";
   *   String instanceGroupManager = "instanceGroupManager-388242077";
   *   String resizeRequest = "resizeRequest-1656358085";
   *   Operation response =
   *       instanceGroupManagerResizeRequestsClient
   *           .deleteAsync(project, zone, instanceGroupManager, resizeRequest)
   *           .get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param zone The name of the zone where the managed instance group is located. The name should
   *     conform to RFC1035.
   * @param instanceGroupManager The name of the managed instance group. The name should conform to
   *     RFC1035 or be a resource ID.
   * @param resizeRequest The name of the resize request to delete. The name should conform to
   *     RFC1035 or be a resource ID.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> deleteAsync(
      String project, String zone, String instanceGroupManager, String resizeRequest) {
    DeleteInstanceGroupManagerResizeRequestRequest request =
        DeleteInstanceGroupManagerResizeRequestRequest.newBuilder()
            .setProject(project)
            .setZone(zone)
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
   * try (InstanceGroupManagerResizeRequestsClient instanceGroupManagerResizeRequestsClient =
   *     InstanceGroupManagerResizeRequestsClient.create()) {
   *   DeleteInstanceGroupManagerResizeRequestRequest request =
   *       DeleteInstanceGroupManagerResizeRequestRequest.newBuilder()
   *           .setInstanceGroupManager("instanceGroupManager-388242077")
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setResizeRequest("resizeRequest-1656358085")
   *           .setZone("zone3744684")
   *           .build();
   *   Operation response = instanceGroupManagerResizeRequestsClient.deleteAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> deleteAsync(
      DeleteInstanceGroupManagerResizeRequestRequest request) {
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
   * try (InstanceGroupManagerResizeRequestsClient instanceGroupManagerResizeRequestsClient =
   *     InstanceGroupManagerResizeRequestsClient.create()) {
   *   DeleteInstanceGroupManagerResizeRequestRequest request =
   *       DeleteInstanceGroupManagerResizeRequestRequest.newBuilder()
   *           .setInstanceGroupManager("instanceGroupManager-388242077")
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setResizeRequest("resizeRequest-1656358085")
   *           .setZone("zone3744684")
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       instanceGroupManagerResizeRequestsClient.deleteOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          DeleteInstanceGroupManagerResizeRequestRequest, Operation, Operation>
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
   * try (InstanceGroupManagerResizeRequestsClient instanceGroupManagerResizeRequestsClient =
   *     InstanceGroupManagerResizeRequestsClient.create()) {
   *   DeleteInstanceGroupManagerResizeRequestRequest request =
   *       DeleteInstanceGroupManagerResizeRequestRequest.newBuilder()
   *           .setInstanceGroupManager("instanceGroupManager-388242077")
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setResizeRequest("resizeRequest-1656358085")
   *           .setZone("zone3744684")
   *           .build();
   *   ApiFuture<Operation> future =
   *       instanceGroupManagerResizeRequestsClient.deleteCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteInstanceGroupManagerResizeRequestRequest, Operation>
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
   * try (InstanceGroupManagerResizeRequestsClient instanceGroupManagerResizeRequestsClient =
   *     InstanceGroupManagerResizeRequestsClient.create()) {
   *   String project = "project-309310695";
   *   String zone = "zone3744684";
   *   String instanceGroupManager = "instanceGroupManager-388242077";
   *   String resizeRequest = "resizeRequest-1656358085";
   *   InstanceGroupManagerResizeRequest response =
   *       instanceGroupManagerResizeRequestsClient.get(
   *           project, zone, instanceGroupManager, resizeRequest);
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param zone Name of the href="/compute/docs/regions-zones/#available"&gt;zone scoping this
   *     request. Name should conform to RFC1035.
   * @param instanceGroupManager The name of the managed instance group. Name should conform to
   *     RFC1035 or be a resource ID.
   * @param resizeRequest The name of the resize request. Name should conform to RFC1035 or be a
   *     resource ID.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final InstanceGroupManagerResizeRequest get(
      String project, String zone, String instanceGroupManager, String resizeRequest) {
    GetInstanceGroupManagerResizeRequestRequest request =
        GetInstanceGroupManagerResizeRequestRequest.newBuilder()
            .setProject(project)
            .setZone(zone)
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
   * try (InstanceGroupManagerResizeRequestsClient instanceGroupManagerResizeRequestsClient =
   *     InstanceGroupManagerResizeRequestsClient.create()) {
   *   GetInstanceGroupManagerResizeRequestRequest request =
   *       GetInstanceGroupManagerResizeRequestRequest.newBuilder()
   *           .setInstanceGroupManager("instanceGroupManager-388242077")
   *           .setProject("project-309310695")
   *           .setResizeRequest("resizeRequest-1656358085")
   *           .setZone("zone3744684")
   *           .build();
   *   InstanceGroupManagerResizeRequest response =
   *       instanceGroupManagerResizeRequestsClient.get(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final InstanceGroupManagerResizeRequest get(
      GetInstanceGroupManagerResizeRequestRequest request) {
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
   * try (InstanceGroupManagerResizeRequestsClient instanceGroupManagerResizeRequestsClient =
   *     InstanceGroupManagerResizeRequestsClient.create()) {
   *   GetInstanceGroupManagerResizeRequestRequest request =
   *       GetInstanceGroupManagerResizeRequestRequest.newBuilder()
   *           .setInstanceGroupManager("instanceGroupManager-388242077")
   *           .setProject("project-309310695")
   *           .setResizeRequest("resizeRequest-1656358085")
   *           .setZone("zone3744684")
   *           .build();
   *   ApiFuture<InstanceGroupManagerResizeRequest> future =
   *       instanceGroupManagerResizeRequestsClient.getCallable().futureCall(request);
   *   // Do something.
   *   InstanceGroupManagerResizeRequest response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<
          GetInstanceGroupManagerResizeRequestRequest, InstanceGroupManagerResizeRequest>
      getCallable() {
    return stub.getCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new resize request that starts provisioning VMs immediately or queues VM creation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InstanceGroupManagerResizeRequestsClient instanceGroupManagerResizeRequestsClient =
   *     InstanceGroupManagerResizeRequestsClient.create()) {
   *   String project = "project-309310695";
   *   String zone = "zone3744684";
   *   String instanceGroupManager = "instanceGroupManager-388242077";
   *   InstanceGroupManagerResizeRequest instanceGroupManagerResizeRequestResource =
   *       InstanceGroupManagerResizeRequest.newBuilder().build();
   *   Operation response =
   *       instanceGroupManagerResizeRequestsClient
   *           .insertAsync(
   *               project, zone, instanceGroupManager, instanceGroupManagerResizeRequestResource)
   *           .get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param zone The name of the zone where the managed instance group is located and where the
   *     resize request will be created. Name should conform to RFC1035.
   * @param instanceGroupManager The name of the managed instance group to which the resize request
   *     will be added. Name should conform to RFC1035 or be a resource ID.
   * @param instanceGroupManagerResizeRequestResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> insertAsync(
      String project,
      String zone,
      String instanceGroupManager,
      InstanceGroupManagerResizeRequest instanceGroupManagerResizeRequestResource) {
    InsertInstanceGroupManagerResizeRequestRequest request =
        InsertInstanceGroupManagerResizeRequestRequest.newBuilder()
            .setProject(project)
            .setZone(zone)
            .setInstanceGroupManager(instanceGroupManager)
            .setInstanceGroupManagerResizeRequestResource(instanceGroupManagerResizeRequestResource)
            .build();
    return insertAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new resize request that starts provisioning VMs immediately or queues VM creation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InstanceGroupManagerResizeRequestsClient instanceGroupManagerResizeRequestsClient =
   *     InstanceGroupManagerResizeRequestsClient.create()) {
   *   InsertInstanceGroupManagerResizeRequestRequest request =
   *       InsertInstanceGroupManagerResizeRequestRequest.newBuilder()
   *           .setInstanceGroupManager("instanceGroupManager-388242077")
   *           .setInstanceGroupManagerResizeRequestResource(
   *               InstanceGroupManagerResizeRequest.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setZone("zone3744684")
   *           .build();
   *   Operation response = instanceGroupManagerResizeRequestsClient.insertAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> insertAsync(
      InsertInstanceGroupManagerResizeRequestRequest request) {
    return insertOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new resize request that starts provisioning VMs immediately or queues VM creation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InstanceGroupManagerResizeRequestsClient instanceGroupManagerResizeRequestsClient =
   *     InstanceGroupManagerResizeRequestsClient.create()) {
   *   InsertInstanceGroupManagerResizeRequestRequest request =
   *       InsertInstanceGroupManagerResizeRequestRequest.newBuilder()
   *           .setInstanceGroupManager("instanceGroupManager-388242077")
   *           .setInstanceGroupManagerResizeRequestResource(
   *               InstanceGroupManagerResizeRequest.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setZone("zone3744684")
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       instanceGroupManagerResizeRequestsClient.insertOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          InsertInstanceGroupManagerResizeRequestRequest, Operation, Operation>
      insertOperationCallable() {
    return stub.insertOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new resize request that starts provisioning VMs immediately or queues VM creation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InstanceGroupManagerResizeRequestsClient instanceGroupManagerResizeRequestsClient =
   *     InstanceGroupManagerResizeRequestsClient.create()) {
   *   InsertInstanceGroupManagerResizeRequestRequest request =
   *       InsertInstanceGroupManagerResizeRequestRequest.newBuilder()
   *           .setInstanceGroupManager("instanceGroupManager-388242077")
   *           .setInstanceGroupManagerResizeRequestResource(
   *               InstanceGroupManagerResizeRequest.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setZone("zone3744684")
   *           .build();
   *   ApiFuture<Operation> future =
   *       instanceGroupManagerResizeRequestsClient.insertCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<InsertInstanceGroupManagerResizeRequestRequest, Operation>
      insertCallable() {
    return stub.insertCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a list of resize requests that are contained in the managed instance group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InstanceGroupManagerResizeRequestsClient instanceGroupManagerResizeRequestsClient =
   *     InstanceGroupManagerResizeRequestsClient.create()) {
   *   String project = "project-309310695";
   *   String zone = "zone3744684";
   *   String instanceGroupManager = "instanceGroupManager-388242077";
   *   for (InstanceGroupManagerResizeRequest element :
   *       instanceGroupManagerResizeRequestsClient
   *           .list(project, zone, instanceGroupManager)
   *           .iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param zone The name of the zone where the managed instance group is located. The name should
   *     conform to RFC1035.
   * @param instanceGroupManager The name of the managed instance group. The name should conform to
   *     RFC1035.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPagedResponse list(String project, String zone, String instanceGroupManager) {
    ListInstanceGroupManagerResizeRequestsRequest request =
        ListInstanceGroupManagerResizeRequestsRequest.newBuilder()
            .setProject(project)
            .setZone(zone)
            .setInstanceGroupManager(instanceGroupManager)
            .build();
    return list(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a list of resize requests that are contained in the managed instance group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InstanceGroupManagerResizeRequestsClient instanceGroupManagerResizeRequestsClient =
   *     InstanceGroupManagerResizeRequestsClient.create()) {
   *   ListInstanceGroupManagerResizeRequestsRequest request =
   *       ListInstanceGroupManagerResizeRequestsRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setInstanceGroupManager("instanceGroupManager-388242077")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setReturnPartialSuccess(true)
   *           .setZone("zone3744684")
   *           .build();
   *   for (InstanceGroupManagerResizeRequest element :
   *       instanceGroupManagerResizeRequestsClient.list(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPagedResponse list(ListInstanceGroupManagerResizeRequestsRequest request) {
    return listPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a list of resize requests that are contained in the managed instance group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InstanceGroupManagerResizeRequestsClient instanceGroupManagerResizeRequestsClient =
   *     InstanceGroupManagerResizeRequestsClient.create()) {
   *   ListInstanceGroupManagerResizeRequestsRequest request =
   *       ListInstanceGroupManagerResizeRequestsRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setInstanceGroupManager("instanceGroupManager-388242077")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setReturnPartialSuccess(true)
   *           .setZone("zone3744684")
   *           .build();
   *   ApiFuture<InstanceGroupManagerResizeRequest> future =
   *       instanceGroupManagerResizeRequestsClient.listPagedCallable().futureCall(request);
   *   // Do something.
   *   for (InstanceGroupManagerResizeRequest element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListInstanceGroupManagerResizeRequestsRequest, ListPagedResponse>
      listPagedCallable() {
    return stub.listPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a list of resize requests that are contained in the managed instance group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InstanceGroupManagerResizeRequestsClient instanceGroupManagerResizeRequestsClient =
   *     InstanceGroupManagerResizeRequestsClient.create()) {
   *   ListInstanceGroupManagerResizeRequestsRequest request =
   *       ListInstanceGroupManagerResizeRequestsRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setInstanceGroupManager("instanceGroupManager-388242077")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setReturnPartialSuccess(true)
   *           .setZone("zone3744684")
   *           .build();
   *   while (true) {
   *     InstanceGroupManagerResizeRequestsListResponse response =
   *         instanceGroupManagerResizeRequestsClient.listCallable().call(request);
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
          ListInstanceGroupManagerResizeRequestsRequest,
          InstanceGroupManagerResizeRequestsListResponse>
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
          ListInstanceGroupManagerResizeRequestsRequest,
          InstanceGroupManagerResizeRequestsListResponse,
          InstanceGroupManagerResizeRequest,
          ListPage,
          ListFixedSizeCollection> {

    public static ApiFuture<ListPagedResponse> createAsync(
        PageContext<
                ListInstanceGroupManagerResizeRequestsRequest,
                InstanceGroupManagerResizeRequestsListResponse,
                InstanceGroupManagerResizeRequest>
            context,
        ApiFuture<InstanceGroupManagerResizeRequestsListResponse> futureResponse) {
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
          ListInstanceGroupManagerResizeRequestsRequest,
          InstanceGroupManagerResizeRequestsListResponse,
          InstanceGroupManagerResizeRequest,
          ListPage> {

    private ListPage(
        PageContext<
                ListInstanceGroupManagerResizeRequestsRequest,
                InstanceGroupManagerResizeRequestsListResponse,
                InstanceGroupManagerResizeRequest>
            context,
        InstanceGroupManagerResizeRequestsListResponse response) {
      super(context, response);
    }

    private static ListPage createEmptyPage() {
      return new ListPage(null, null);
    }

    @Override
    protected ListPage createPage(
        PageContext<
                ListInstanceGroupManagerResizeRequestsRequest,
                InstanceGroupManagerResizeRequestsListResponse,
                InstanceGroupManagerResizeRequest>
            context,
        InstanceGroupManagerResizeRequestsListResponse response) {
      return new ListPage(context, response);
    }

    @Override
    public ApiFuture<ListPage> createPageAsync(
        PageContext<
                ListInstanceGroupManagerResizeRequestsRequest,
                InstanceGroupManagerResizeRequestsListResponse,
                InstanceGroupManagerResizeRequest>
            context,
        ApiFuture<InstanceGroupManagerResizeRequestsListResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListInstanceGroupManagerResizeRequestsRequest,
          InstanceGroupManagerResizeRequestsListResponse,
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
