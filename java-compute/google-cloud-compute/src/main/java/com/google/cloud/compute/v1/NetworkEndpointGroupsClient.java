/*
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.compute.v1;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.compute.v1.stub.NetworkEndpointGroupsStub;
import com.google.cloud.compute.v1.stub.NetworkEndpointGroupsStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.util.List;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND SERVICE
/**
 * Service Description: The NetworkEndpointGroups API.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>
 * <code>
 * try (NetworkEndpointGroupsClient networkEndpointGroupsClient = NetworkEndpointGroupsClient.create()) {
 *   String project = "";
 *   String zone = "";
 *   String networkEndpointGroup = "";
 *   NetworkEndpointGroupsAttachEndpointsRequest networkEndpointGroupsAttachEndpointsRequestResource = NetworkEndpointGroupsAttachEndpointsRequest.newBuilder().build();
 *   Operation response = networkEndpointGroupsClient.attachNetworkEndpoints(project, zone, networkEndpointGroup, networkEndpointGroupsAttachEndpointsRequestResource);
 * }
 * </code>
 * </pre>
 *
 * <p>Note: close() needs to be called on the networkEndpointGroupsClient object to clean up
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
 * <pre>
 * <code>
 * NetworkEndpointGroupsSettings networkEndpointGroupsSettings =
 *     NetworkEndpointGroupsSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * NetworkEndpointGroupsClient networkEndpointGroupsClient =
 *     NetworkEndpointGroupsClient.create(networkEndpointGroupsSettings);
 * </code>
 * </pre>
 *
 * To customize the endpoint:
 *
 * <pre>
 * <code>
 * NetworkEndpointGroupsSettings networkEndpointGroupsSettings =
 *     NetworkEndpointGroupsSettings.newBuilder().setEndpoint(myEndpoint).build();
 * NetworkEndpointGroupsClient networkEndpointGroupsClient =
 *     NetworkEndpointGroupsClient.create(networkEndpointGroupsSettings);
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
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
   * This is for advanced usage - prefer to use NetworkEndpointGroupsSettings}.
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
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

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected NetworkEndpointGroupsClient(NetworkEndpointGroupsStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final NetworkEndpointGroupsSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public NetworkEndpointGroupsStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of network endpoint groups and sorts them by zone.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NetworkEndpointGroupsClient networkEndpointGroupsClient = NetworkEndpointGroupsClient.create()) {
   *   String project = "";
   *   for (Entry&lt;String, NetworkEndpointGroupsScopedList&gt; element : networkEndpointGroupsClient.aggregatedList(project).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AggregatedListPagedResponse aggregatedList(String project) {
    AggregatedListNetworkEndpointGroupsRequest request =
        AggregatedListNetworkEndpointGroupsRequest.newBuilder().setProject(project).build();
    return aggregatedList(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of network endpoint groups and sorts them by zone.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NetworkEndpointGroupsClient networkEndpointGroupsClient = NetworkEndpointGroupsClient.create()) {
   *   String project = "";
   *   AggregatedListNetworkEndpointGroupsRequest request = AggregatedListNetworkEndpointGroupsRequest.newBuilder()
   *     .setProject(project)
   *     .build();
   *   for (Entry&lt;String, NetworkEndpointGroupsScopedList&gt; element : networkEndpointGroupsClient.aggregatedList(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AggregatedListPagedResponse aggregatedList(
      AggregatedListNetworkEndpointGroupsRequest request) {
    return aggregatedListPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of network endpoint groups and sorts them by zone.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NetworkEndpointGroupsClient networkEndpointGroupsClient = NetworkEndpointGroupsClient.create()) {
   *   String project = "";
   *   AggregatedListNetworkEndpointGroupsRequest request = AggregatedListNetworkEndpointGroupsRequest.newBuilder()
   *     .setProject(project)
   *     .build();
   *   ApiFuture&lt;AggregatedListPagedResponse&gt; future = networkEndpointGroupsClient.aggregatedListPagedCallable().futureCall(request);
   *   // Do something
   *   for (Entry&lt;String, NetworkEndpointGroupsScopedList&gt; element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  public final UnaryCallable<
          AggregatedListNetworkEndpointGroupsRequest, AggregatedListPagedResponse>
      aggregatedListPagedCallable() {
    return stub.aggregatedListPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of network endpoint groups and sorts them by zone.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NetworkEndpointGroupsClient networkEndpointGroupsClient = NetworkEndpointGroupsClient.create()) {
   *   String project = "";
   *   AggregatedListNetworkEndpointGroupsRequest request = AggregatedListNetworkEndpointGroupsRequest.newBuilder()
   *     .setProject(project)
   *     .build();
   *   while (true) {
   *     NetworkEndpointGroupAggregatedList response = networkEndpointGroupsClient.aggregatedListCallable().call(request);
   *     for (Entry&lt;String, NetworkEndpointGroupsScopedList&gt; element : response.getItemsMap()) {
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
   * </code></pre>
   */
  public final UnaryCallable<
          AggregatedListNetworkEndpointGroupsRequest, NetworkEndpointGroupAggregatedList>
      aggregatedListCallable() {
    return stub.aggregatedListCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Attach a list of network endpoints to the specified network endpoint group.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NetworkEndpointGroupsClient networkEndpointGroupsClient = NetworkEndpointGroupsClient.create()) {
   *   String project = "";
   *   String zone = "";
   *   String networkEndpointGroup = "";
   *   NetworkEndpointGroupsAttachEndpointsRequest networkEndpointGroupsAttachEndpointsRequestResource = NetworkEndpointGroupsAttachEndpointsRequest.newBuilder().build();
   *   Operation response = networkEndpointGroupsClient.attachNetworkEndpoints(project, zone, networkEndpointGroup, networkEndpointGroupsAttachEndpointsRequestResource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param zone The name of the zone where the network endpoint group is located. It should comply
   *     with RFC1035.
   * @param networkEndpointGroup The name of the network endpoint group where you are attaching
   *     network endpoints to. It should comply with RFC1035.
   * @param networkEndpointGroupsAttachEndpointsRequestResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation attachNetworkEndpoints(
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
    return attachNetworkEndpoints(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Attach a list of network endpoints to the specified network endpoint group.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NetworkEndpointGroupsClient networkEndpointGroupsClient = NetworkEndpointGroupsClient.create()) {
   *   String networkEndpointGroup = "";
   *   NetworkEndpointGroupsAttachEndpointsRequest networkEndpointGroupsAttachEndpointsRequestResource = NetworkEndpointGroupsAttachEndpointsRequest.newBuilder().build();
   *   String project = "";
   *   String zone = "";
   *   AttachNetworkEndpointsNetworkEndpointGroupRequest request = AttachNetworkEndpointsNetworkEndpointGroupRequest.newBuilder()
   *     .setNetworkEndpointGroup(networkEndpointGroup)
   *     .setNetworkEndpointGroupsAttachEndpointsRequestResource(networkEndpointGroupsAttachEndpointsRequestResource)
   *     .setProject(project)
   *     .setZone(zone)
   *     .build();
   *   Operation response = networkEndpointGroupsClient.attachNetworkEndpoints(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation attachNetworkEndpoints(
      AttachNetworkEndpointsNetworkEndpointGroupRequest request) {
    return attachNetworkEndpointsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Attach a list of network endpoints to the specified network endpoint group.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NetworkEndpointGroupsClient networkEndpointGroupsClient = NetworkEndpointGroupsClient.create()) {
   *   String networkEndpointGroup = "";
   *   NetworkEndpointGroupsAttachEndpointsRequest networkEndpointGroupsAttachEndpointsRequestResource = NetworkEndpointGroupsAttachEndpointsRequest.newBuilder().build();
   *   String project = "";
   *   String zone = "";
   *   AttachNetworkEndpointsNetworkEndpointGroupRequest request = AttachNetworkEndpointsNetworkEndpointGroupRequest.newBuilder()
   *     .setNetworkEndpointGroup(networkEndpointGroup)
   *     .setNetworkEndpointGroupsAttachEndpointsRequestResource(networkEndpointGroupsAttachEndpointsRequestResource)
   *     .setProject(project)
   *     .setZone(zone)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = networkEndpointGroupsClient.attachNetworkEndpointsCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<AttachNetworkEndpointsNetworkEndpointGroupRequest, Operation>
      attachNetworkEndpointsCallable() {
    return stub.attachNetworkEndpointsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified network endpoint group. The network endpoints in the NEG and the VM
   * instances they belong to are not terminated when the NEG is deleted. Note that the NEG cannot
   * be deleted if there are backend services referencing it.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NetworkEndpointGroupsClient networkEndpointGroupsClient = NetworkEndpointGroupsClient.create()) {
   *   String project = "";
   *   String zone = "";
   *   String networkEndpointGroup = "";
   *   Operation response = networkEndpointGroupsClient.delete(project, zone, networkEndpointGroup);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param zone The name of the zone where the network endpoint group is located. It should comply
   *     with RFC1035.
   * @param networkEndpointGroup The name of the network endpoint group to delete. It should comply
   *     with RFC1035.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation delete(String project, String zone, String networkEndpointGroup) {
    DeleteNetworkEndpointGroupRequest request =
        DeleteNetworkEndpointGroupRequest.newBuilder()
            .setProject(project)
            .setZone(zone)
            .setNetworkEndpointGroup(networkEndpointGroup)
            .build();
    return delete(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified network endpoint group. The network endpoints in the NEG and the VM
   * instances they belong to are not terminated when the NEG is deleted. Note that the NEG cannot
   * be deleted if there are backend services referencing it.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NetworkEndpointGroupsClient networkEndpointGroupsClient = NetworkEndpointGroupsClient.create()) {
   *   String networkEndpointGroup = "";
   *   String project = "";
   *   String zone = "";
   *   DeleteNetworkEndpointGroupRequest request = DeleteNetworkEndpointGroupRequest.newBuilder()
   *     .setNetworkEndpointGroup(networkEndpointGroup)
   *     .setProject(project)
   *     .setZone(zone)
   *     .build();
   *   Operation response = networkEndpointGroupsClient.delete(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation delete(DeleteNetworkEndpointGroupRequest request) {
    return deleteCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified network endpoint group. The network endpoints in the NEG and the VM
   * instances they belong to are not terminated when the NEG is deleted. Note that the NEG cannot
   * be deleted if there are backend services referencing it.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NetworkEndpointGroupsClient networkEndpointGroupsClient = NetworkEndpointGroupsClient.create()) {
   *   String networkEndpointGroup = "";
   *   String project = "";
   *   String zone = "";
   *   DeleteNetworkEndpointGroupRequest request = DeleteNetworkEndpointGroupRequest.newBuilder()
   *     .setNetworkEndpointGroup(networkEndpointGroup)
   *     .setProject(project)
   *     .setZone(zone)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = networkEndpointGroupsClient.deleteCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<DeleteNetworkEndpointGroupRequest, Operation> deleteCallable() {
    return stub.deleteCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Detach a list of network endpoints from the specified network endpoint group.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NetworkEndpointGroupsClient networkEndpointGroupsClient = NetworkEndpointGroupsClient.create()) {
   *   String project = "";
   *   String zone = "";
   *   String networkEndpointGroup = "";
   *   NetworkEndpointGroupsDetachEndpointsRequest networkEndpointGroupsDetachEndpointsRequestResource = NetworkEndpointGroupsDetachEndpointsRequest.newBuilder().build();
   *   Operation response = networkEndpointGroupsClient.detachNetworkEndpoints(project, zone, networkEndpointGroup, networkEndpointGroupsDetachEndpointsRequestResource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param zone The name of the zone where the network endpoint group is located. It should comply
   *     with RFC1035.
   * @param networkEndpointGroup The name of the network endpoint group where you are removing
   *     network endpoints. It should comply with RFC1035.
   * @param networkEndpointGroupsDetachEndpointsRequestResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation detachNetworkEndpoints(
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
    return detachNetworkEndpoints(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Detach a list of network endpoints from the specified network endpoint group.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NetworkEndpointGroupsClient networkEndpointGroupsClient = NetworkEndpointGroupsClient.create()) {
   *   String networkEndpointGroup = "";
   *   NetworkEndpointGroupsDetachEndpointsRequest networkEndpointGroupsDetachEndpointsRequestResource = NetworkEndpointGroupsDetachEndpointsRequest.newBuilder().build();
   *   String project = "";
   *   String zone = "";
   *   DetachNetworkEndpointsNetworkEndpointGroupRequest request = DetachNetworkEndpointsNetworkEndpointGroupRequest.newBuilder()
   *     .setNetworkEndpointGroup(networkEndpointGroup)
   *     .setNetworkEndpointGroupsDetachEndpointsRequestResource(networkEndpointGroupsDetachEndpointsRequestResource)
   *     .setProject(project)
   *     .setZone(zone)
   *     .build();
   *   Operation response = networkEndpointGroupsClient.detachNetworkEndpoints(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation detachNetworkEndpoints(
      DetachNetworkEndpointsNetworkEndpointGroupRequest request) {
    return detachNetworkEndpointsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Detach a list of network endpoints from the specified network endpoint group.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NetworkEndpointGroupsClient networkEndpointGroupsClient = NetworkEndpointGroupsClient.create()) {
   *   String networkEndpointGroup = "";
   *   NetworkEndpointGroupsDetachEndpointsRequest networkEndpointGroupsDetachEndpointsRequestResource = NetworkEndpointGroupsDetachEndpointsRequest.newBuilder().build();
   *   String project = "";
   *   String zone = "";
   *   DetachNetworkEndpointsNetworkEndpointGroupRequest request = DetachNetworkEndpointsNetworkEndpointGroupRequest.newBuilder()
   *     .setNetworkEndpointGroup(networkEndpointGroup)
   *     .setNetworkEndpointGroupsDetachEndpointsRequestResource(networkEndpointGroupsDetachEndpointsRequestResource)
   *     .setProject(project)
   *     .setZone(zone)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = networkEndpointGroupsClient.detachNetworkEndpointsCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<DetachNetworkEndpointsNetworkEndpointGroupRequest, Operation>
      detachNetworkEndpointsCallable() {
    return stub.detachNetworkEndpointsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified network endpoint group. Gets a list of available network endpoint groups
   * by making a list() request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NetworkEndpointGroupsClient networkEndpointGroupsClient = NetworkEndpointGroupsClient.create()) {
   *   String project = "";
   *   String zone = "";
   *   String networkEndpointGroup = "";
   *   NetworkEndpointGroup response = networkEndpointGroupsClient.get(project, zone, networkEndpointGroup);
   * }
   * </code></pre>
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

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified network endpoint group. Gets a list of available network endpoint groups
   * by making a list() request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NetworkEndpointGroupsClient networkEndpointGroupsClient = NetworkEndpointGroupsClient.create()) {
   *   String networkEndpointGroup = "";
   *   String project = "";
   *   String zone = "";
   *   GetNetworkEndpointGroupRequest request = GetNetworkEndpointGroupRequest.newBuilder()
   *     .setNetworkEndpointGroup(networkEndpointGroup)
   *     .setProject(project)
   *     .setZone(zone)
   *     .build();
   *   NetworkEndpointGroup response = networkEndpointGroupsClient.get(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final NetworkEndpointGroup get(GetNetworkEndpointGroupRequest request) {
    return getCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified network endpoint group. Gets a list of available network endpoint groups
   * by making a list() request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NetworkEndpointGroupsClient networkEndpointGroupsClient = NetworkEndpointGroupsClient.create()) {
   *   String networkEndpointGroup = "";
   *   String project = "";
   *   String zone = "";
   *   GetNetworkEndpointGroupRequest request = GetNetworkEndpointGroupRequest.newBuilder()
   *     .setNetworkEndpointGroup(networkEndpointGroup)
   *     .setProject(project)
   *     .setZone(zone)
   *     .build();
   *   ApiFuture&lt;NetworkEndpointGroup&gt; future = networkEndpointGroupsClient.getCallable().futureCall(request);
   *   // Do something
   *   NetworkEndpointGroup response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<GetNetworkEndpointGroupRequest, NetworkEndpointGroup> getCallable() {
    return stub.getCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a network endpoint group in the specified project using the parameters that are
   * included in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NetworkEndpointGroupsClient networkEndpointGroupsClient = NetworkEndpointGroupsClient.create()) {
   *   String project = "";
   *   String zone = "";
   *   NetworkEndpointGroup networkEndpointGroupResource = NetworkEndpointGroup.newBuilder().build();
   *   Operation response = networkEndpointGroupsClient.insert(project, zone, networkEndpointGroupResource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param zone The name of the zone where you want to create the network endpoint group. It should
   *     comply with RFC1035.
   * @param networkEndpointGroupResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation insert(
      String project, String zone, NetworkEndpointGroup networkEndpointGroupResource) {
    InsertNetworkEndpointGroupRequest request =
        InsertNetworkEndpointGroupRequest.newBuilder()
            .setProject(project)
            .setZone(zone)
            .setNetworkEndpointGroupResource(networkEndpointGroupResource)
            .build();
    return insert(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a network endpoint group in the specified project using the parameters that are
   * included in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NetworkEndpointGroupsClient networkEndpointGroupsClient = NetworkEndpointGroupsClient.create()) {
   *   NetworkEndpointGroup networkEndpointGroupResource = NetworkEndpointGroup.newBuilder().build();
   *   String project = "";
   *   String zone = "";
   *   InsertNetworkEndpointGroupRequest request = InsertNetworkEndpointGroupRequest.newBuilder()
   *     .setNetworkEndpointGroupResource(networkEndpointGroupResource)
   *     .setProject(project)
   *     .setZone(zone)
   *     .build();
   *   Operation response = networkEndpointGroupsClient.insert(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation insert(InsertNetworkEndpointGroupRequest request) {
    return insertCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a network endpoint group in the specified project using the parameters that are
   * included in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NetworkEndpointGroupsClient networkEndpointGroupsClient = NetworkEndpointGroupsClient.create()) {
   *   NetworkEndpointGroup networkEndpointGroupResource = NetworkEndpointGroup.newBuilder().build();
   *   String project = "";
   *   String zone = "";
   *   InsertNetworkEndpointGroupRequest request = InsertNetworkEndpointGroupRequest.newBuilder()
   *     .setNetworkEndpointGroupResource(networkEndpointGroupResource)
   *     .setProject(project)
   *     .setZone(zone)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = networkEndpointGroupsClient.insertCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<InsertNetworkEndpointGroupRequest, Operation> insertCallable() {
    return stub.insertCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of network endpoint groups that are located in the specified project and
   * zone.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NetworkEndpointGroupsClient networkEndpointGroupsClient = NetworkEndpointGroupsClient.create()) {
   *   String project = "";
   *   String zone = "";
   *   for (NetworkEndpointGroup element : networkEndpointGroupsClient.list(project, zone).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
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

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of network endpoint groups that are located in the specified project and
   * zone.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NetworkEndpointGroupsClient networkEndpointGroupsClient = NetworkEndpointGroupsClient.create()) {
   *   String project = "";
   *   String zone = "";
   *   ListNetworkEndpointGroupsRequest request = ListNetworkEndpointGroupsRequest.newBuilder()
   *     .setProject(project)
   *     .setZone(zone)
   *     .build();
   *   for (NetworkEndpointGroup element : networkEndpointGroupsClient.list(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPagedResponse list(ListNetworkEndpointGroupsRequest request) {
    return listPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of network endpoint groups that are located in the specified project and
   * zone.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NetworkEndpointGroupsClient networkEndpointGroupsClient = NetworkEndpointGroupsClient.create()) {
   *   String project = "";
   *   String zone = "";
   *   ListNetworkEndpointGroupsRequest request = ListNetworkEndpointGroupsRequest.newBuilder()
   *     .setProject(project)
   *     .setZone(zone)
   *     .build();
   *   ApiFuture&lt;ListPagedResponse&gt; future = networkEndpointGroupsClient.listPagedCallable().futureCall(request);
   *   // Do something
   *   for (NetworkEndpointGroup element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  public final UnaryCallable<ListNetworkEndpointGroupsRequest, ListPagedResponse>
      listPagedCallable() {
    return stub.listPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of network endpoint groups that are located in the specified project and
   * zone.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NetworkEndpointGroupsClient networkEndpointGroupsClient = NetworkEndpointGroupsClient.create()) {
   *   String project = "";
   *   String zone = "";
   *   ListNetworkEndpointGroupsRequest request = ListNetworkEndpointGroupsRequest.newBuilder()
   *     .setProject(project)
   *     .setZone(zone)
   *     .build();
   *   while (true) {
   *     NetworkEndpointGroupList response = networkEndpointGroupsClient.listCallable().call(request);
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
   * </code></pre>
   */
  public final UnaryCallable<ListNetworkEndpointGroupsRequest, NetworkEndpointGroupList>
      listCallable() {
    return stub.listCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists the network endpoints in the specified network endpoint group.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NetworkEndpointGroupsClient networkEndpointGroupsClient = NetworkEndpointGroupsClient.create()) {
   *   String project = "";
   *   String zone = "";
   *   String networkEndpointGroup = "";
   *   NetworkEndpointGroupsListEndpointsRequest networkEndpointGroupsListEndpointsRequestResource = NetworkEndpointGroupsListEndpointsRequest.newBuilder().build();
   *   for (NetworkEndpointWithHealthStatus element : networkEndpointGroupsClient.listNetworkEndpoints(project, zone, networkEndpointGroup, networkEndpointGroupsListEndpointsRequestResource).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
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

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists the network endpoints in the specified network endpoint group.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NetworkEndpointGroupsClient networkEndpointGroupsClient = NetworkEndpointGroupsClient.create()) {
   *   String networkEndpointGroup = "";
   *   NetworkEndpointGroupsListEndpointsRequest networkEndpointGroupsListEndpointsRequestResource = NetworkEndpointGroupsListEndpointsRequest.newBuilder().build();
   *   String project = "";
   *   String zone = "";
   *   ListNetworkEndpointsNetworkEndpointGroupsRequest request = ListNetworkEndpointsNetworkEndpointGroupsRequest.newBuilder()
   *     .setNetworkEndpointGroup(networkEndpointGroup)
   *     .setNetworkEndpointGroupsListEndpointsRequestResource(networkEndpointGroupsListEndpointsRequestResource)
   *     .setProject(project)
   *     .setZone(zone)
   *     .build();
   *   for (NetworkEndpointWithHealthStatus element : networkEndpointGroupsClient.listNetworkEndpoints(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListNetworkEndpointsPagedResponse listNetworkEndpoints(
      ListNetworkEndpointsNetworkEndpointGroupsRequest request) {
    return listNetworkEndpointsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists the network endpoints in the specified network endpoint group.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NetworkEndpointGroupsClient networkEndpointGroupsClient = NetworkEndpointGroupsClient.create()) {
   *   String networkEndpointGroup = "";
   *   NetworkEndpointGroupsListEndpointsRequest networkEndpointGroupsListEndpointsRequestResource = NetworkEndpointGroupsListEndpointsRequest.newBuilder().build();
   *   String project = "";
   *   String zone = "";
   *   ListNetworkEndpointsNetworkEndpointGroupsRequest request = ListNetworkEndpointsNetworkEndpointGroupsRequest.newBuilder()
   *     .setNetworkEndpointGroup(networkEndpointGroup)
   *     .setNetworkEndpointGroupsListEndpointsRequestResource(networkEndpointGroupsListEndpointsRequestResource)
   *     .setProject(project)
   *     .setZone(zone)
   *     .build();
   *   ApiFuture&lt;ListNetworkEndpointsPagedResponse&gt; future = networkEndpointGroupsClient.listNetworkEndpointsPagedCallable().futureCall(request);
   *   // Do something
   *   for (NetworkEndpointWithHealthStatus element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  public final UnaryCallable<
          ListNetworkEndpointsNetworkEndpointGroupsRequest, ListNetworkEndpointsPagedResponse>
      listNetworkEndpointsPagedCallable() {
    return stub.listNetworkEndpointsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists the network endpoints in the specified network endpoint group.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NetworkEndpointGroupsClient networkEndpointGroupsClient = NetworkEndpointGroupsClient.create()) {
   *   String networkEndpointGroup = "";
   *   NetworkEndpointGroupsListEndpointsRequest networkEndpointGroupsListEndpointsRequestResource = NetworkEndpointGroupsListEndpointsRequest.newBuilder().build();
   *   String project = "";
   *   String zone = "";
   *   ListNetworkEndpointsNetworkEndpointGroupsRequest request = ListNetworkEndpointsNetworkEndpointGroupsRequest.newBuilder()
   *     .setNetworkEndpointGroup(networkEndpointGroup)
   *     .setNetworkEndpointGroupsListEndpointsRequestResource(networkEndpointGroupsListEndpointsRequestResource)
   *     .setProject(project)
   *     .setZone(zone)
   *     .build();
   *   while (true) {
   *     NetworkEndpointGroupsListNetworkEndpoints response = networkEndpointGroupsClient.listNetworkEndpointsCallable().call(request);
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
   * </code></pre>
   */
  public final UnaryCallable<
          ListNetworkEndpointsNetworkEndpointGroupsRequest,
          NetworkEndpointGroupsListNetworkEndpoints>
      listNetworkEndpointsCallable() {
    return stub.listNetworkEndpointsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns permissions that a caller has on the specified resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NetworkEndpointGroupsClient networkEndpointGroupsClient = NetworkEndpointGroupsClient.create()) {
   *   String project = "";
   *   String zone = "";
   *   String resource = "";
   *   TestPermissionsRequest testPermissionsRequestResource = TestPermissionsRequest.newBuilder().build();
   *   TestPermissionsResponse response = networkEndpointGroupsClient.testIamPermissions(project, zone, resource, testPermissionsRequestResource);
   * }
   * </code></pre>
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

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns permissions that a caller has on the specified resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NetworkEndpointGroupsClient networkEndpointGroupsClient = NetworkEndpointGroupsClient.create()) {
   *   String project = "";
   *   String resource = "";
   *   TestPermissionsRequest testPermissionsRequestResource = TestPermissionsRequest.newBuilder().build();
   *   String zone = "";
   *   TestIamPermissionsNetworkEndpointGroupRequest request = TestIamPermissionsNetworkEndpointGroupRequest.newBuilder()
   *     .setProject(project)
   *     .setResource(resource)
   *     .setTestPermissionsRequestResource(testPermissionsRequestResource)
   *     .setZone(zone)
   *     .build();
   *   TestPermissionsResponse response = networkEndpointGroupsClient.testIamPermissions(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TestPermissionsResponse testIamPermissions(
      TestIamPermissionsNetworkEndpointGroupRequest request) {
    return testIamPermissionsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns permissions that a caller has on the specified resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NetworkEndpointGroupsClient networkEndpointGroupsClient = NetworkEndpointGroupsClient.create()) {
   *   String project = "";
   *   String resource = "";
   *   TestPermissionsRequest testPermissionsRequestResource = TestPermissionsRequest.newBuilder().build();
   *   String zone = "";
   *   TestIamPermissionsNetworkEndpointGroupRequest request = TestIamPermissionsNetworkEndpointGroupRequest.newBuilder()
   *     .setProject(project)
   *     .setResource(resource)
   *     .setTestPermissionsRequestResource(testPermissionsRequestResource)
   *     .setZone(zone)
   *     .build();
   *   ApiFuture&lt;TestPermissionsResponse&gt; future = networkEndpointGroupsClient.testIamPermissionsCallable().futureCall(request);
   *   // Do something
   *   TestPermissionsResponse response = future.get();
   * }
   * </code></pre>
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
          Entry<String, NetworkEndpointGroupsScopedList>,
          AggregatedListPage,
          AggregatedListFixedSizeCollection> {

    public static ApiFuture<AggregatedListPagedResponse> createAsync(
        PageContext<
                AggregatedListNetworkEndpointGroupsRequest,
                NetworkEndpointGroupAggregatedList,
                Entry<String, NetworkEndpointGroupsScopedList>>
            context,
        ApiFuture<NetworkEndpointGroupAggregatedList> futureResponse) {
      ApiFuture<AggregatedListPage> futurePage =
          AggregatedListPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<AggregatedListPage, AggregatedListPagedResponse>() {
            @Override
            public AggregatedListPagedResponse apply(AggregatedListPage input) {
              return new AggregatedListPagedResponse(input);
            }
          },
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
          Entry<String, NetworkEndpointGroupsScopedList>,
          AggregatedListPage> {

    private AggregatedListPage(
        PageContext<
                AggregatedListNetworkEndpointGroupsRequest,
                NetworkEndpointGroupAggregatedList,
                Entry<String, NetworkEndpointGroupsScopedList>>
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
                Entry<String, NetworkEndpointGroupsScopedList>>
            context,
        NetworkEndpointGroupAggregatedList response) {
      return new AggregatedListPage(context, response);
    }

    @Override
    public ApiFuture<AggregatedListPage> createPageAsync(
        PageContext<
                AggregatedListNetworkEndpointGroupsRequest,
                NetworkEndpointGroupAggregatedList,
                Entry<String, NetworkEndpointGroupsScopedList>>
            context,
        ApiFuture<NetworkEndpointGroupAggregatedList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class AggregatedListFixedSizeCollection
      extends AbstractFixedSizeCollection<
          AggregatedListNetworkEndpointGroupsRequest,
          NetworkEndpointGroupAggregatedList,
          Entry<String, NetworkEndpointGroupsScopedList>,
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
          futurePage,
          new ApiFunction<ListPage, ListPagedResponse>() {
            @Override
            public ListPagedResponse apply(ListPage input) {
              return new ListPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
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
          new ApiFunction<ListNetworkEndpointsPage, ListNetworkEndpointsPagedResponse>() {
            @Override
            public ListNetworkEndpointsPagedResponse apply(ListNetworkEndpointsPage input) {
              return new ListNetworkEndpointsPagedResponse(input);
            }
          },
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
