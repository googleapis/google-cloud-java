/*
 * Copyright 2022 Google LLC
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
import com.google.cloud.compute.v1.stub.NetworkEndpointGroupsStub;
import com.google.cloud.compute.v1.stub.NetworkEndpointGroupsStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: The NetworkEndpointGroups API.
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
 * try (NetworkEndpointGroupsClient networkEndpointGroupsClient =
 *     NetworkEndpointGroupsClient.create()) {
 *   String project = "project-309310695";
 *   String zone = "zone3744684";
 *   String networkEndpointGroup = "networkEndpointGroup-2120389028";
 *   NetworkEndpointGroup response =
 *       networkEndpointGroupsClient.get(project, zone, networkEndpointGroup);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the NetworkEndpointGroupsClient object to clean up
 * resources such as threads. In the example above, try-with-resources is used, which automatically
 * calls close().
 *
 * <p>The surface of this class includes several types of Java methods for each of the API's
 * methods:
 *
 * <ol>
 *   <li>A "flattened" method. With this type of method, the fields of the request type have been
 *       converted into function parameters. It may be the case that not all fields are available as
 *       parameters, and not every API method will have a flattened method entry point.
 *   <li>A "request object" method. This type of method only takes one parameter, a request object,
 *       which must be constructed before the call. Not every API method will have a request object
 *       method.
 *   <li>A "callable" method. This type of method takes no parameters and returns an immutable API
 *       callable object, which can be used to initiate calls to the service.
 * </ol>
 *
 * <p>See the individual methods for example code.
 *
 * <p>Many parameters require resource names to be formatted in a particular way. To assist with
 * these names, this class includes a format method for each type of name, and additionally a parse
 * method to extract the individual identifiers contained within names that are returned.
 *
 * <p>This class can be customized by passing in a custom instance of NetworkEndpointGroupsSettings
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
 * NetworkEndpointGroupsSettings networkEndpointGroupsSettings =
 *     NetworkEndpointGroupsSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * NetworkEndpointGroupsClient networkEndpointGroupsClient =
 *     NetworkEndpointGroupsClient.create(networkEndpointGroupsSettings);
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
 * NetworkEndpointGroupsSettings networkEndpointGroupsSettings =
 *     NetworkEndpointGroupsSettings.newBuilder().setEndpoint(myEndpoint).build();
 * NetworkEndpointGroupsClient networkEndpointGroupsClient =
 *     NetworkEndpointGroupsClient.create(networkEndpointGroupsSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class NetworkEndpointGroupsClient implements BackgroundResource {
  private final NetworkEndpointGroupsSettings settings;
  private final NetworkEndpointGroupsStub stub;

  /** Constructs an instance of NetworkEndpointGroupsClient with default settings. */
  public static final NetworkEndpointGroupsClient create() throws IOException {
    return create(NetworkEndpointGroupsSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of NetworkEndpointGroupsClient, using the given settings. The channels
   * are created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final NetworkEndpointGroupsClient create(NetworkEndpointGroupsSettings settings)
      throws IOException {
    return new NetworkEndpointGroupsClient(settings);
  }

  /**
   * Constructs an instance of NetworkEndpointGroupsClient, using the given stub for making calls.
   * This is for advanced usage - prefer using create(NetworkEndpointGroupsSettings).
   */
  public static final NetworkEndpointGroupsClient create(NetworkEndpointGroupsStub stub) {
    return new NetworkEndpointGroupsClient(stub);
  }

  /**
   * Constructs an instance of NetworkEndpointGroupsClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected NetworkEndpointGroupsClient(NetworkEndpointGroupsSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((NetworkEndpointGroupsStubSettings) settings.getStubSettings()).createStub();
  }

  protected NetworkEndpointGroupsClient(NetworkEndpointGroupsStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final NetworkEndpointGroupsSettings getSettings() {
    return settings;
  }

  public NetworkEndpointGroupsStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the list of network endpoint groups and sorts them by zone.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkEndpointGroupsClient networkEndpointGroupsClient =
   *     NetworkEndpointGroupsClient.create()) {
   *   String project = "project-309310695";
   *   for (Map.Entry<String, NetworkEndpointGroupsScopedList> element :
   *       networkEndpointGroupsClient.aggregatedList(project).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AggregatedListPagedResponse aggregatedList(String project) {
    AggregatedListNetworkEndpointGroupsRequest request =
        AggregatedListNetworkEndpointGroupsRequest.newBuilder().setProject(project).build();
    return aggregatedList(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the list of network endpoint groups and sorts them by zone.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkEndpointGroupsClient networkEndpointGroupsClient =
   *     NetworkEndpointGroupsClient.create()) {
   *   AggregatedListNetworkEndpointGroupsRequest request =
   *       AggregatedListNetworkEndpointGroupsRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setIncludeAllScopes(true)
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   for (Map.Entry<String, NetworkEndpointGroupsScopedList> element :
   *       networkEndpointGroupsClient.aggregatedList(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AggregatedListPagedResponse aggregatedList(
      AggregatedListNetworkEndpointGroupsRequest request) {
    return aggregatedListPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the list of network endpoint groups and sorts them by zone.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkEndpointGroupsClient networkEndpointGroupsClient =
   *     NetworkEndpointGroupsClient.create()) {
   *   AggregatedListNetworkEndpointGroupsRequest request =
   *       AggregatedListNetworkEndpointGroupsRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setIncludeAllScopes(true)
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   ApiFuture<Map.Entry<String, NetworkEndpointGroupsScopedList>> future =
   *       networkEndpointGroupsClient.aggregatedListPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Map.Entry<String, NetworkEndpointGroupsScopedList> element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<
          AggregatedListNetworkEndpointGroupsRequest, AggregatedListPagedResponse>
      aggregatedListPagedCallable() {
    return stub.aggregatedListPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the list of network endpoint groups and sorts them by zone.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkEndpointGroupsClient networkEndpointGroupsClient =
   *     NetworkEndpointGroupsClient.create()) {
   *   AggregatedListNetworkEndpointGroupsRequest request =
   *       AggregatedListNetworkEndpointGroupsRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setIncludeAllScopes(true)
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   while (true) {
   *     NetworkEndpointGroupAggregatedList response =
   *         networkEndpointGroupsClient.aggregatedListCallable().call(request);
   *     for (Map.Entry<String, NetworkEndpointGroupsScopedList> element : response.getItemsList()) {
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
          AggregatedListNetworkEndpointGroupsRequest, NetworkEndpointGroupAggregatedList>
      aggregatedListCallable() {
    return stub.aggregatedListCallable();
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
   * try (NetworkEndpointGroupsClient networkEndpointGroupsClient =
   *     NetworkEndpointGroupsClient.create()) {
   *   String project = "project-309310695";
   *   String zone = "zone3744684";
   *   String networkEndpointGroup = "networkEndpointGroup-2120389028";
   *   NetworkEndpointGroupsAttachEndpointsRequest
   *       networkEndpointGroupsAttachEndpointsRequestResource =
   *           NetworkEndpointGroupsAttachEndpointsRequest.newBuilder().build();
   *   Operation response =
   *       networkEndpointGroupsClient
   *           .attachNetworkEndpointsAsync(
   *               project,
   *               zone,
   *               networkEndpointGroup,
   *               networkEndpointGroupsAttachEndpointsRequestResource)
   *           .get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param zone The name of the zone where the network endpoint group is located. It should comply
   *     with RFC1035.
   * @param networkEndpointGroup The name of the network endpoint group where you are attaching
   *     network endpoints to. It should comply with RFC1035.
   * @param networkEndpointGroupsAttachEndpointsRequestResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> attachNetworkEndpointsAsync(
      String project,
      String zone,
      String networkEndpointGroup,
      NetworkEndpointGroupsAttachEndpointsRequest
          networkEndpointGroupsAttachEndpointsRequestResource) {
    AttachNetworkEndpointsNetworkEndpointGroupRequest request =
        AttachNetworkEndpointsNetworkEndpointGroupRequest.newBuilder()
            .setProject(project)
            .setZone(zone)
            .setNetworkEndpointGroup(networkEndpointGroup)
            .setNetworkEndpointGroupsAttachEndpointsRequestResource(
                networkEndpointGroupsAttachEndpointsRequestResource)
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
   * try (NetworkEndpointGroupsClient networkEndpointGroupsClient =
   *     NetworkEndpointGroupsClient.create()) {
   *   AttachNetworkEndpointsNetworkEndpointGroupRequest request =
   *       AttachNetworkEndpointsNetworkEndpointGroupRequest.newBuilder()
   *           .setNetworkEndpointGroup("networkEndpointGroup-2120389028")
   *           .setNetworkEndpointGroupsAttachEndpointsRequestResource(
   *               NetworkEndpointGroupsAttachEndpointsRequest.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setZone("zone3744684")
   *           .build();
   *   Operation response = networkEndpointGroupsClient.attachNetworkEndpointsAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Operation, Operation> attachNetworkEndpointsAsync(
      AttachNetworkEndpointsNetworkEndpointGroupRequest request) {
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
   * try (NetworkEndpointGroupsClient networkEndpointGroupsClient =
   *     NetworkEndpointGroupsClient.create()) {
   *   AttachNetworkEndpointsNetworkEndpointGroupRequest request =
   *       AttachNetworkEndpointsNetworkEndpointGroupRequest.newBuilder()
   *           .setNetworkEndpointGroup("networkEndpointGroup-2120389028")
   *           .setNetworkEndpointGroupsAttachEndpointsRequestResource(
   *               NetworkEndpointGroupsAttachEndpointsRequest.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setZone("zone3744684")
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       networkEndpointGroupsClient.attachNetworkEndpointsOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          AttachNetworkEndpointsNetworkEndpointGroupRequest, Operation, Operation>
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
   * try (NetworkEndpointGroupsClient networkEndpointGroupsClient =
   *     NetworkEndpointGroupsClient.create()) {
   *   AttachNetworkEndpointsNetworkEndpointGroupRequest request =
   *       AttachNetworkEndpointsNetworkEndpointGroupRequest.newBuilder()
   *           .setNetworkEndpointGroup("networkEndpointGroup-2120389028")
   *           .setNetworkEndpointGroupsAttachEndpointsRequestResource(
   *               NetworkEndpointGroupsAttachEndpointsRequest.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setZone("zone3744684")
   *           .build();
   *   ApiFuture<Operation> future =
   *       networkEndpointGroupsClient.attachNetworkEndpointsCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<AttachNetworkEndpointsNetworkEndpointGroupRequest, Operation>
      attachNetworkEndpointsCallable() {
    return stub.attachNetworkEndpointsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified network endpoint group. The network endpoints in the NEG and the VM
   * instances they belong to are not terminated when the NEG is deleted. Note that the NEG cannot
   * be deleted if there are backend services referencing it.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkEndpointGroupsClient networkEndpointGroupsClient =
   *     NetworkEndpointGroupsClient.create()) {
   *   String project = "project-309310695";
   *   String zone = "zone3744684";
   *   String networkEndpointGroup = "networkEndpointGroup-2120389028";
   *   Operation response =
   *       networkEndpointGroupsClient.deleteAsync(project, zone, networkEndpointGroup).get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param zone The name of the zone where the network endpoint group is located. It should comply
   *     with RFC1035.
   * @param networkEndpointGroup The name of the network endpoint group to delete. It should comply
   *     with RFC1035.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> deleteAsync(
      String project, String zone, String networkEndpointGroup) {
    DeleteNetworkEndpointGroupRequest request =
        DeleteNetworkEndpointGroupRequest.newBuilder()
            .setProject(project)
            .setZone(zone)
            .setNetworkEndpointGroup(networkEndpointGroup)
            .build();
    return deleteAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified network endpoint group. The network endpoints in the NEG and the VM
   * instances they belong to are not terminated when the NEG is deleted. Note that the NEG cannot
   * be deleted if there are backend services referencing it.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkEndpointGroupsClient networkEndpointGroupsClient =
   *     NetworkEndpointGroupsClient.create()) {
   *   DeleteNetworkEndpointGroupRequest request =
   *       DeleteNetworkEndpointGroupRequest.newBuilder()
   *           .setNetworkEndpointGroup("networkEndpointGroup-2120389028")
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setZone("zone3744684")
   *           .build();
   *   Operation response = networkEndpointGroupsClient.deleteAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Operation, Operation> deleteAsync(
      DeleteNetworkEndpointGroupRequest request) {
    return deleteOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified network endpoint group. The network endpoints in the NEG and the VM
   * instances they belong to are not terminated when the NEG is deleted. Note that the NEG cannot
   * be deleted if there are backend services referencing it.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkEndpointGroupsClient networkEndpointGroupsClient =
   *     NetworkEndpointGroupsClient.create()) {
   *   DeleteNetworkEndpointGroupRequest request =
   *       DeleteNetworkEndpointGroupRequest.newBuilder()
   *           .setNetworkEndpointGroup("networkEndpointGroup-2120389028")
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setZone("zone3744684")
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       networkEndpointGroupsClient.deleteOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteNetworkEndpointGroupRequest, Operation, Operation>
      deleteOperationCallable() {
    return stub.deleteOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified network endpoint group. The network endpoints in the NEG and the VM
   * instances they belong to are not terminated when the NEG is deleted. Note that the NEG cannot
   * be deleted if there are backend services referencing it.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkEndpointGroupsClient networkEndpointGroupsClient =
   *     NetworkEndpointGroupsClient.create()) {
   *   DeleteNetworkEndpointGroupRequest request =
   *       DeleteNetworkEndpointGroupRequest.newBuilder()
   *           .setNetworkEndpointGroup("networkEndpointGroup-2120389028")
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setZone("zone3744684")
   *           .build();
   *   ApiFuture<Operation> future =
   *       networkEndpointGroupsClient.deleteCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteNetworkEndpointGroupRequest, Operation> deleteCallable() {
    return stub.deleteCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Detach a list of network endpoints from the specified network endpoint group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkEndpointGroupsClient networkEndpointGroupsClient =
   *     NetworkEndpointGroupsClient.create()) {
   *   String project = "project-309310695";
   *   String zone = "zone3744684";
   *   String networkEndpointGroup = "networkEndpointGroup-2120389028";
   *   NetworkEndpointGroupsDetachEndpointsRequest
   *       networkEndpointGroupsDetachEndpointsRequestResource =
   *           NetworkEndpointGroupsDetachEndpointsRequest.newBuilder().build();
   *   Operation response =
   *       networkEndpointGroupsClient
   *           .detachNetworkEndpointsAsync(
   *               project,
   *               zone,
   *               networkEndpointGroup,
   *               networkEndpointGroupsDetachEndpointsRequestResource)
   *           .get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param zone The name of the zone where the network endpoint group is located. It should comply
   *     with RFC1035.
   * @param networkEndpointGroup The name of the network endpoint group where you are removing
   *     network endpoints. It should comply with RFC1035.
   * @param networkEndpointGroupsDetachEndpointsRequestResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> detachNetworkEndpointsAsync(
      String project,
      String zone,
      String networkEndpointGroup,
      NetworkEndpointGroupsDetachEndpointsRequest
          networkEndpointGroupsDetachEndpointsRequestResource) {
    DetachNetworkEndpointsNetworkEndpointGroupRequest request =
        DetachNetworkEndpointsNetworkEndpointGroupRequest.newBuilder()
            .setProject(project)
            .setZone(zone)
            .setNetworkEndpointGroup(networkEndpointGroup)
            .setNetworkEndpointGroupsDetachEndpointsRequestResource(
                networkEndpointGroupsDetachEndpointsRequestResource)
            .build();
    return detachNetworkEndpointsAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Detach a list of network endpoints from the specified network endpoint group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkEndpointGroupsClient networkEndpointGroupsClient =
   *     NetworkEndpointGroupsClient.create()) {
   *   DetachNetworkEndpointsNetworkEndpointGroupRequest request =
   *       DetachNetworkEndpointsNetworkEndpointGroupRequest.newBuilder()
   *           .setNetworkEndpointGroup("networkEndpointGroup-2120389028")
   *           .setNetworkEndpointGroupsDetachEndpointsRequestResource(
   *               NetworkEndpointGroupsDetachEndpointsRequest.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setZone("zone3744684")
   *           .build();
   *   Operation response = networkEndpointGroupsClient.detachNetworkEndpointsAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Operation, Operation> detachNetworkEndpointsAsync(
      DetachNetworkEndpointsNetworkEndpointGroupRequest request) {
    return detachNetworkEndpointsOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Detach a list of network endpoints from the specified network endpoint group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkEndpointGroupsClient networkEndpointGroupsClient =
   *     NetworkEndpointGroupsClient.create()) {
   *   DetachNetworkEndpointsNetworkEndpointGroupRequest request =
   *       DetachNetworkEndpointsNetworkEndpointGroupRequest.newBuilder()
   *           .setNetworkEndpointGroup("networkEndpointGroup-2120389028")
   *           .setNetworkEndpointGroupsDetachEndpointsRequestResource(
   *               NetworkEndpointGroupsDetachEndpointsRequest.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setZone("zone3744684")
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       networkEndpointGroupsClient.detachNetworkEndpointsOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          DetachNetworkEndpointsNetworkEndpointGroupRequest, Operation, Operation>
      detachNetworkEndpointsOperationCallable() {
    return stub.detachNetworkEndpointsOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Detach a list of network endpoints from the specified network endpoint group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkEndpointGroupsClient networkEndpointGroupsClient =
   *     NetworkEndpointGroupsClient.create()) {
   *   DetachNetworkEndpointsNetworkEndpointGroupRequest request =
   *       DetachNetworkEndpointsNetworkEndpointGroupRequest.newBuilder()
   *           .setNetworkEndpointGroup("networkEndpointGroup-2120389028")
   *           .setNetworkEndpointGroupsDetachEndpointsRequestResource(
   *               NetworkEndpointGroupsDetachEndpointsRequest.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setZone("zone3744684")
   *           .build();
   *   ApiFuture<Operation> future =
   *       networkEndpointGroupsClient.detachNetworkEndpointsCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DetachNetworkEndpointsNetworkEndpointGroupRequest, Operation>
      detachNetworkEndpointsCallable() {
    return stub.detachNetworkEndpointsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified network endpoint group. Gets a list of available network endpoint groups
   * by making a list() request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkEndpointGroupsClient networkEndpointGroupsClient =
   *     NetworkEndpointGroupsClient.create()) {
   *   String project = "project-309310695";
   *   String zone = "zone3744684";
   *   String networkEndpointGroup = "networkEndpointGroup-2120389028";
   *   NetworkEndpointGroup response =
   *       networkEndpointGroupsClient.get(project, zone, networkEndpointGroup);
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param zone The name of the zone where the network endpoint group is located. It should comply
   *     with RFC1035.
   * @param networkEndpointGroup The name of the network endpoint group. It should comply with
   *     RFC1035.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final NetworkEndpointGroup get(String project, String zone, String networkEndpointGroup) {
    GetNetworkEndpointGroupRequest request =
        GetNetworkEndpointGroupRequest.newBuilder()
            .setProject(project)
            .setZone(zone)
            .setNetworkEndpointGroup(networkEndpointGroup)
            .build();
    return get(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified network endpoint group. Gets a list of available network endpoint groups
   * by making a list() request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkEndpointGroupsClient networkEndpointGroupsClient =
   *     NetworkEndpointGroupsClient.create()) {
   *   GetNetworkEndpointGroupRequest request =
   *       GetNetworkEndpointGroupRequest.newBuilder()
   *           .setNetworkEndpointGroup("networkEndpointGroup-2120389028")
   *           .setProject("project-309310695")
   *           .setZone("zone3744684")
   *           .build();
   *   NetworkEndpointGroup response = networkEndpointGroupsClient.get(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final NetworkEndpointGroup get(GetNetworkEndpointGroupRequest request) {
    return getCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified network endpoint group. Gets a list of available network endpoint groups
   * by making a list() request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkEndpointGroupsClient networkEndpointGroupsClient =
   *     NetworkEndpointGroupsClient.create()) {
   *   GetNetworkEndpointGroupRequest request =
   *       GetNetworkEndpointGroupRequest.newBuilder()
   *           .setNetworkEndpointGroup("networkEndpointGroup-2120389028")
   *           .setProject("project-309310695")
   *           .setZone("zone3744684")
   *           .build();
   *   ApiFuture<NetworkEndpointGroup> future =
   *       networkEndpointGroupsClient.getCallable().futureCall(request);
   *   // Do something.
   *   NetworkEndpointGroup response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetNetworkEndpointGroupRequest, NetworkEndpointGroup> getCallable() {
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
   * try (NetworkEndpointGroupsClient networkEndpointGroupsClient =
   *     NetworkEndpointGroupsClient.create()) {
   *   String project = "project-309310695";
   *   String zone = "zone3744684";
   *   NetworkEndpointGroup networkEndpointGroupResource = NetworkEndpointGroup.newBuilder().build();
   *   Operation response =
   *       networkEndpointGroupsClient
   *           .insertAsync(project, zone, networkEndpointGroupResource)
   *           .get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param zone The name of the zone where you want to create the network endpoint group. It should
   *     comply with RFC1035.
   * @param networkEndpointGroupResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> insertAsync(
      String project, String zone, NetworkEndpointGroup networkEndpointGroupResource) {
    InsertNetworkEndpointGroupRequest request =
        InsertNetworkEndpointGroupRequest.newBuilder()
            .setProject(project)
            .setZone(zone)
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
   * try (NetworkEndpointGroupsClient networkEndpointGroupsClient =
   *     NetworkEndpointGroupsClient.create()) {
   *   InsertNetworkEndpointGroupRequest request =
   *       InsertNetworkEndpointGroupRequest.newBuilder()
   *           .setNetworkEndpointGroupResource(NetworkEndpointGroup.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setZone("zone3744684")
   *           .build();
   *   Operation response = networkEndpointGroupsClient.insertAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Operation, Operation> insertAsync(
      InsertNetworkEndpointGroupRequest request) {
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
   * try (NetworkEndpointGroupsClient networkEndpointGroupsClient =
   *     NetworkEndpointGroupsClient.create()) {
   *   InsertNetworkEndpointGroupRequest request =
   *       InsertNetworkEndpointGroupRequest.newBuilder()
   *           .setNetworkEndpointGroupResource(NetworkEndpointGroup.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setZone("zone3744684")
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       networkEndpointGroupsClient.insertOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<InsertNetworkEndpointGroupRequest, Operation, Operation>
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
   * try (NetworkEndpointGroupsClient networkEndpointGroupsClient =
   *     NetworkEndpointGroupsClient.create()) {
   *   InsertNetworkEndpointGroupRequest request =
   *       InsertNetworkEndpointGroupRequest.newBuilder()
   *           .setNetworkEndpointGroupResource(NetworkEndpointGroup.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setZone("zone3744684")
   *           .build();
   *   ApiFuture<Operation> future =
   *       networkEndpointGroupsClient.insertCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<InsertNetworkEndpointGroupRequest, Operation> insertCallable() {
    return stub.insertCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the list of network endpoint groups that are located in the specified project and
   * zone.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkEndpointGroupsClient networkEndpointGroupsClient =
   *     NetworkEndpointGroupsClient.create()) {
   *   String project = "project-309310695";
   *   String zone = "zone3744684";
   *   for (NetworkEndpointGroup element :
   *       networkEndpointGroupsClient.list(project, zone).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param zone The name of the zone where the network endpoint group is located. It should comply
   *     with RFC1035.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPagedResponse list(String project, String zone) {
    ListNetworkEndpointGroupsRequest request =
        ListNetworkEndpointGroupsRequest.newBuilder().setProject(project).setZone(zone).build();
    return list(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the list of network endpoint groups that are located in the specified project and
   * zone.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkEndpointGroupsClient networkEndpointGroupsClient =
   *     NetworkEndpointGroupsClient.create()) {
   *   ListNetworkEndpointGroupsRequest request =
   *       ListNetworkEndpointGroupsRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setReturnPartialSuccess(true)
   *           .setZone("zone3744684")
   *           .build();
   *   for (NetworkEndpointGroup element : networkEndpointGroupsClient.list(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPagedResponse list(ListNetworkEndpointGroupsRequest request) {
    return listPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the list of network endpoint groups that are located in the specified project and
   * zone.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkEndpointGroupsClient networkEndpointGroupsClient =
   *     NetworkEndpointGroupsClient.create()) {
   *   ListNetworkEndpointGroupsRequest request =
   *       ListNetworkEndpointGroupsRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setReturnPartialSuccess(true)
   *           .setZone("zone3744684")
   *           .build();
   *   ApiFuture<NetworkEndpointGroup> future =
   *       networkEndpointGroupsClient.listPagedCallable().futureCall(request);
   *   // Do something.
   *   for (NetworkEndpointGroup element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListNetworkEndpointGroupsRequest, ListPagedResponse>
      listPagedCallable() {
    return stub.listPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the list of network endpoint groups that are located in the specified project and
   * zone.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkEndpointGroupsClient networkEndpointGroupsClient =
   *     NetworkEndpointGroupsClient.create()) {
   *   ListNetworkEndpointGroupsRequest request =
   *       ListNetworkEndpointGroupsRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setReturnPartialSuccess(true)
   *           .setZone("zone3744684")
   *           .build();
   *   while (true) {
   *     NetworkEndpointGroupList response =
   *         networkEndpointGroupsClient.listCallable().call(request);
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
  public final UnaryCallable<ListNetworkEndpointGroupsRequest, NetworkEndpointGroupList>
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
   * try (NetworkEndpointGroupsClient networkEndpointGroupsClient =
   *     NetworkEndpointGroupsClient.create()) {
   *   String project = "project-309310695";
   *   String zone = "zone3744684";
   *   String networkEndpointGroup = "networkEndpointGroup-2120389028";
   *   NetworkEndpointGroupsListEndpointsRequest networkEndpointGroupsListEndpointsRequestResource =
   *       NetworkEndpointGroupsListEndpointsRequest.newBuilder().build();
   *   for (NetworkEndpointWithHealthStatus element :
   *       networkEndpointGroupsClient
   *           .listNetworkEndpoints(
   *               project,
   *               zone,
   *               networkEndpointGroup,
   *               networkEndpointGroupsListEndpointsRequestResource)
   *           .iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param zone The name of the zone where the network endpoint group is located. It should comply
   *     with RFC1035.
   * @param networkEndpointGroup The name of the network endpoint group from which you want to
   *     generate a list of included network endpoints. It should comply with RFC1035.
   * @param networkEndpointGroupsListEndpointsRequestResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListNetworkEndpointsPagedResponse listNetworkEndpoints(
      String project,
      String zone,
      String networkEndpointGroup,
      NetworkEndpointGroupsListEndpointsRequest networkEndpointGroupsListEndpointsRequestResource) {
    ListNetworkEndpointsNetworkEndpointGroupsRequest request =
        ListNetworkEndpointsNetworkEndpointGroupsRequest.newBuilder()
            .setProject(project)
            .setZone(zone)
            .setNetworkEndpointGroup(networkEndpointGroup)
            .setNetworkEndpointGroupsListEndpointsRequestResource(
                networkEndpointGroupsListEndpointsRequestResource)
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
   * try (NetworkEndpointGroupsClient networkEndpointGroupsClient =
   *     NetworkEndpointGroupsClient.create()) {
   *   ListNetworkEndpointsNetworkEndpointGroupsRequest request =
   *       ListNetworkEndpointsNetworkEndpointGroupsRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setNetworkEndpointGroup("networkEndpointGroup-2120389028")
   *           .setNetworkEndpointGroupsListEndpointsRequestResource(
   *               NetworkEndpointGroupsListEndpointsRequest.newBuilder().build())
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setReturnPartialSuccess(true)
   *           .setZone("zone3744684")
   *           .build();
   *   for (NetworkEndpointWithHealthStatus element :
   *       networkEndpointGroupsClient.listNetworkEndpoints(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListNetworkEndpointsPagedResponse listNetworkEndpoints(
      ListNetworkEndpointsNetworkEndpointGroupsRequest request) {
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
   * try (NetworkEndpointGroupsClient networkEndpointGroupsClient =
   *     NetworkEndpointGroupsClient.create()) {
   *   ListNetworkEndpointsNetworkEndpointGroupsRequest request =
   *       ListNetworkEndpointsNetworkEndpointGroupsRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setNetworkEndpointGroup("networkEndpointGroup-2120389028")
   *           .setNetworkEndpointGroupsListEndpointsRequestResource(
   *               NetworkEndpointGroupsListEndpointsRequest.newBuilder().build())
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setReturnPartialSuccess(true)
   *           .setZone("zone3744684")
   *           .build();
   *   ApiFuture<NetworkEndpointWithHealthStatus> future =
   *       networkEndpointGroupsClient.listNetworkEndpointsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (NetworkEndpointWithHealthStatus element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<
          ListNetworkEndpointsNetworkEndpointGroupsRequest, ListNetworkEndpointsPagedResponse>
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
   * try (NetworkEndpointGroupsClient networkEndpointGroupsClient =
   *     NetworkEndpointGroupsClient.create()) {
   *   ListNetworkEndpointsNetworkEndpointGroupsRequest request =
   *       ListNetworkEndpointsNetworkEndpointGroupsRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setNetworkEndpointGroup("networkEndpointGroup-2120389028")
   *           .setNetworkEndpointGroupsListEndpointsRequestResource(
   *               NetworkEndpointGroupsListEndpointsRequest.newBuilder().build())
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setReturnPartialSuccess(true)
   *           .setZone("zone3744684")
   *           .build();
   *   while (true) {
   *     NetworkEndpointGroupsListNetworkEndpoints response =
   *         networkEndpointGroupsClient.listNetworkEndpointsCallable().call(request);
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
          ListNetworkEndpointsNetworkEndpointGroupsRequest,
          NetworkEndpointGroupsListNetworkEndpoints>
      listNetworkEndpointsCallable() {
    return stub.listNetworkEndpointsCallable();
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
   * try (NetworkEndpointGroupsClient networkEndpointGroupsClient =
   *     NetworkEndpointGroupsClient.create()) {
   *   String project = "project-309310695";
   *   String zone = "zone3744684";
   *   String resource = "resource-341064690";
   *   TestPermissionsRequest testPermissionsRequestResource =
   *       TestPermissionsRequest.newBuilder().build();
   *   TestPermissionsResponse response =
   *       networkEndpointGroupsClient.testIamPermissions(
   *           project, zone, resource, testPermissionsRequestResource);
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param zone The name of the zone for this request.
   * @param resource Name or id of the resource for this request.
   * @param testPermissionsRequestResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TestPermissionsResponse testIamPermissions(
      String project,
      String zone,
      String resource,
      TestPermissionsRequest testPermissionsRequestResource) {
    TestIamPermissionsNetworkEndpointGroupRequest request =
        TestIamPermissionsNetworkEndpointGroupRequest.newBuilder()
            .setProject(project)
            .setZone(zone)
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
   * try (NetworkEndpointGroupsClient networkEndpointGroupsClient =
   *     NetworkEndpointGroupsClient.create()) {
   *   TestIamPermissionsNetworkEndpointGroupRequest request =
   *       TestIamPermissionsNetworkEndpointGroupRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setResource("resource-341064690")
   *           .setTestPermissionsRequestResource(TestPermissionsRequest.newBuilder().build())
   *           .setZone("zone3744684")
   *           .build();
   *   TestPermissionsResponse response = networkEndpointGroupsClient.testIamPermissions(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TestPermissionsResponse testIamPermissions(
      TestIamPermissionsNetworkEndpointGroupRequest request) {
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
   * try (NetworkEndpointGroupsClient networkEndpointGroupsClient =
   *     NetworkEndpointGroupsClient.create()) {
   *   TestIamPermissionsNetworkEndpointGroupRequest request =
   *       TestIamPermissionsNetworkEndpointGroupRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setResource("resource-341064690")
   *           .setTestPermissionsRequestResource(TestPermissionsRequest.newBuilder().build())
   *           .setZone("zone3744684")
   *           .build();
   *   ApiFuture<TestPermissionsResponse> future =
   *       networkEndpointGroupsClient.testIamPermissionsCallable().futureCall(request);
   *   // Do something.
   *   TestPermissionsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<TestIamPermissionsNetworkEndpointGroupRequest, TestPermissionsResponse>
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

  public static class AggregatedListPagedResponse
      extends AbstractPagedListResponse<
          AggregatedListNetworkEndpointGroupsRequest,
          NetworkEndpointGroupAggregatedList,
          Map.Entry<String, NetworkEndpointGroupsScopedList>,
          AggregatedListPage,
          AggregatedListFixedSizeCollection> {

    public static ApiFuture<AggregatedListPagedResponse> createAsync(
        PageContext<
                AggregatedListNetworkEndpointGroupsRequest,
                NetworkEndpointGroupAggregatedList,
                Map.Entry<String, NetworkEndpointGroupsScopedList>>
            context,
        ApiFuture<NetworkEndpointGroupAggregatedList> futureResponse) {
      ApiFuture<AggregatedListPage> futurePage =
          AggregatedListPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new AggregatedListPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private AggregatedListPagedResponse(AggregatedListPage page) {
      super(page, AggregatedListFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class AggregatedListPage
      extends AbstractPage<
          AggregatedListNetworkEndpointGroupsRequest,
          NetworkEndpointGroupAggregatedList,
          Map.Entry<String, NetworkEndpointGroupsScopedList>,
          AggregatedListPage> {

    private AggregatedListPage(
        PageContext<
                AggregatedListNetworkEndpointGroupsRequest,
                NetworkEndpointGroupAggregatedList,
                Map.Entry<String, NetworkEndpointGroupsScopedList>>
            context,
        NetworkEndpointGroupAggregatedList response) {
      super(context, response);
    }

    private static AggregatedListPage createEmptyPage() {
      return new AggregatedListPage(null, null);
    }

    @Override
    protected AggregatedListPage createPage(
        PageContext<
                AggregatedListNetworkEndpointGroupsRequest,
                NetworkEndpointGroupAggregatedList,
                Map.Entry<String, NetworkEndpointGroupsScopedList>>
            context,
        NetworkEndpointGroupAggregatedList response) {
      return new AggregatedListPage(context, response);
    }

    @Override
    public ApiFuture<AggregatedListPage> createPageAsync(
        PageContext<
                AggregatedListNetworkEndpointGroupsRequest,
                NetworkEndpointGroupAggregatedList,
                Map.Entry<String, NetworkEndpointGroupsScopedList>>
            context,
        ApiFuture<NetworkEndpointGroupAggregatedList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class AggregatedListFixedSizeCollection
      extends AbstractFixedSizeCollection<
          AggregatedListNetworkEndpointGroupsRequest,
          NetworkEndpointGroupAggregatedList,
          Map.Entry<String, NetworkEndpointGroupsScopedList>,
          AggregatedListPage,
          AggregatedListFixedSizeCollection> {

    private AggregatedListFixedSizeCollection(List<AggregatedListPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static AggregatedListFixedSizeCollection createEmptyCollection() {
      return new AggregatedListFixedSizeCollection(null, 0);
    }

    @Override
    protected AggregatedListFixedSizeCollection createCollection(
        List<AggregatedListPage> pages, int collectionSize) {
      return new AggregatedListFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListPagedResponse
      extends AbstractPagedListResponse<
          ListNetworkEndpointGroupsRequest,
          NetworkEndpointGroupList,
          NetworkEndpointGroup,
          ListPage,
          ListFixedSizeCollection> {

    public static ApiFuture<ListPagedResponse> createAsync(
        PageContext<
                ListNetworkEndpointGroupsRequest, NetworkEndpointGroupList, NetworkEndpointGroup>
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
          ListNetworkEndpointGroupsRequest,
          NetworkEndpointGroupList,
          NetworkEndpointGroup,
          ListPage> {

    private ListPage(
        PageContext<
                ListNetworkEndpointGroupsRequest, NetworkEndpointGroupList, NetworkEndpointGroup>
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
                ListNetworkEndpointGroupsRequest, NetworkEndpointGroupList, NetworkEndpointGroup>
            context,
        NetworkEndpointGroupList response) {
      return new ListPage(context, response);
    }

    @Override
    public ApiFuture<ListPage> createPageAsync(
        PageContext<
                ListNetworkEndpointGroupsRequest, NetworkEndpointGroupList, NetworkEndpointGroup>
            context,
        ApiFuture<NetworkEndpointGroupList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListNetworkEndpointGroupsRequest,
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
          ListNetworkEndpointsNetworkEndpointGroupsRequest,
          NetworkEndpointGroupsListNetworkEndpoints,
          NetworkEndpointWithHealthStatus,
          ListNetworkEndpointsPage,
          ListNetworkEndpointsFixedSizeCollection> {

    public static ApiFuture<ListNetworkEndpointsPagedResponse> createAsync(
        PageContext<
                ListNetworkEndpointsNetworkEndpointGroupsRequest,
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
          ListNetworkEndpointsNetworkEndpointGroupsRequest,
          NetworkEndpointGroupsListNetworkEndpoints,
          NetworkEndpointWithHealthStatus,
          ListNetworkEndpointsPage> {

    private ListNetworkEndpointsPage(
        PageContext<
                ListNetworkEndpointsNetworkEndpointGroupsRequest,
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
                ListNetworkEndpointsNetworkEndpointGroupsRequest,
                NetworkEndpointGroupsListNetworkEndpoints,
                NetworkEndpointWithHealthStatus>
            context,
        NetworkEndpointGroupsListNetworkEndpoints response) {
      return new ListNetworkEndpointsPage(context, response);
    }

    @Override
    public ApiFuture<ListNetworkEndpointsPage> createPageAsync(
        PageContext<
                ListNetworkEndpointsNetworkEndpointGroupsRequest,
                NetworkEndpointGroupsListNetworkEndpoints,
                NetworkEndpointWithHealthStatus>
            context,
        ApiFuture<NetworkEndpointGroupsListNetworkEndpoints> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListNetworkEndpointsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListNetworkEndpointsNetworkEndpointGroupsRequest,
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
