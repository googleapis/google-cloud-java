/*
 * Copyright 2019 Google LLC
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
import com.google.cloud.compute.v1.stub.NetworkEndpointGroupStub;
import com.google.cloud.compute.v1.stub.NetworkEndpointGroupStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND SERVICE
/**
 * Service Description: Creates and runs virtual machines on Google Cloud Platform.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>
 * <code>
 * try (NetworkEndpointGroupClient networkEndpointGroupClient = NetworkEndpointGroupClient.create()) {
 *   ProjectZoneNetworkEndpointGroupName networkEndpointGroup = ProjectZoneNetworkEndpointGroupName.of("[PROJECT]", "[ZONE]", "[NETWORK_ENDPOINT_GROUP]");
 *   NetworkEndpointGroupsAttachEndpointsRequest networkEndpointGroupsAttachEndpointsRequestResource = NetworkEndpointGroupsAttachEndpointsRequest.newBuilder().build();
 *   Operation response = networkEndpointGroupClient.attachNetworkEndpointsNetworkEndpointGroup(networkEndpointGroup, networkEndpointGroupsAttachEndpointsRequestResource);
 * }
 * </code>
 * </pre>
 *
 * <p>Note: close() needs to be called on the networkEndpointGroupClient object to clean up
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
 * <p>This class can be customized by passing in a custom instance of NetworkEndpointGroupSettings
 * to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>
 * <code>
 * NetworkEndpointGroupSettings networkEndpointGroupSettings =
 *     NetworkEndpointGroupSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * NetworkEndpointGroupClient networkEndpointGroupClient =
 *     NetworkEndpointGroupClient.create(networkEndpointGroupSettings);
 * </code>
 * </pre>
 *
 * To customize the endpoint:
 *
 * <pre>
 * <code>
 * NetworkEndpointGroupSettings networkEndpointGroupSettings =
 *     NetworkEndpointGroupSettings.newBuilder().setEndpoint(myEndpoint).build();
 * NetworkEndpointGroupClient networkEndpointGroupClient =
 *     NetworkEndpointGroupClient.create(networkEndpointGroupSettings);
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class NetworkEndpointGroupClient implements BackgroundResource {
  private final NetworkEndpointGroupSettings settings;
  private final NetworkEndpointGroupStub stub;

  /** Constructs an instance of NetworkEndpointGroupClient with default settings. */
  public static final NetworkEndpointGroupClient create() throws IOException {
    return create(NetworkEndpointGroupSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of NetworkEndpointGroupClient, using the given settings. The channels
   * are created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final NetworkEndpointGroupClient create(NetworkEndpointGroupSettings settings)
      throws IOException {
    return new NetworkEndpointGroupClient(settings);
  }

  /**
   * Constructs an instance of NetworkEndpointGroupClient, using the given stub for making calls.
   * This is for advanced usage - prefer to use NetworkEndpointGroupSettings}.
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final NetworkEndpointGroupClient create(NetworkEndpointGroupStub stub) {
    return new NetworkEndpointGroupClient(stub);
  }

  /**
   * Constructs an instance of NetworkEndpointGroupClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected NetworkEndpointGroupClient(NetworkEndpointGroupSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((NetworkEndpointGroupStubSettings) settings.getStubSettings()).createStub();
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected NetworkEndpointGroupClient(NetworkEndpointGroupStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final NetworkEndpointGroupSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public NetworkEndpointGroupStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of network endpoint groups and sorts them by zone.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NetworkEndpointGroupClient networkEndpointGroupClient = NetworkEndpointGroupClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   for (NetworkEndpointGroupsScopedList element : networkEndpointGroupClient.aggregatedListNetworkEndpointGroups(project).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final AggregatedListNetworkEndpointGroupsPagedResponse aggregatedListNetworkEndpointGroups(
      ProjectName project) {
    AggregatedListNetworkEndpointGroupsHttpRequest request =
        AggregatedListNetworkEndpointGroupsHttpRequest.newBuilder()
            .setProject(project == null ? null : project.toString())
            .build();
    return aggregatedListNetworkEndpointGroups(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of network endpoint groups and sorts them by zone.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NetworkEndpointGroupClient networkEndpointGroupClient = NetworkEndpointGroupClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   for (NetworkEndpointGroupsScopedList element : networkEndpointGroupClient.aggregatedListNetworkEndpointGroups(project.toString()).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final AggregatedListNetworkEndpointGroupsPagedResponse aggregatedListNetworkEndpointGroups(
      String project) {
    AggregatedListNetworkEndpointGroupsHttpRequest request =
        AggregatedListNetworkEndpointGroupsHttpRequest.newBuilder().setProject(project).build();
    return aggregatedListNetworkEndpointGroups(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of network endpoint groups and sorts them by zone.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NetworkEndpointGroupClient networkEndpointGroupClient = NetworkEndpointGroupClient.create()) {
   *   String formattedProject = ProjectName.format("[PROJECT]");
   *   AggregatedListNetworkEndpointGroupsHttpRequest request = AggregatedListNetworkEndpointGroupsHttpRequest.newBuilder()
   *     .setProject(formattedProject)
   *     .build();
   *   for (NetworkEndpointGroupsScopedList element : networkEndpointGroupClient.aggregatedListNetworkEndpointGroups(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final AggregatedListNetworkEndpointGroupsPagedResponse aggregatedListNetworkEndpointGroups(
      AggregatedListNetworkEndpointGroupsHttpRequest request) {
    return aggregatedListNetworkEndpointGroupsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of network endpoint groups and sorts them by zone.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NetworkEndpointGroupClient networkEndpointGroupClient = NetworkEndpointGroupClient.create()) {
   *   String formattedProject = ProjectName.format("[PROJECT]");
   *   AggregatedListNetworkEndpointGroupsHttpRequest request = AggregatedListNetworkEndpointGroupsHttpRequest.newBuilder()
   *     .setProject(formattedProject)
   *     .build();
   *   ApiFuture&lt;AggregatedListNetworkEndpointGroupsPagedResponse&gt; future = networkEndpointGroupClient.aggregatedListNetworkEndpointGroupsPagedCallable().futureCall(request);
   *   // Do something
   *   for (NetworkEndpointGroupsScopedList element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<
          AggregatedListNetworkEndpointGroupsHttpRequest,
          AggregatedListNetworkEndpointGroupsPagedResponse>
      aggregatedListNetworkEndpointGroupsPagedCallable() {
    return stub.aggregatedListNetworkEndpointGroupsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of network endpoint groups and sorts them by zone.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NetworkEndpointGroupClient networkEndpointGroupClient = NetworkEndpointGroupClient.create()) {
   *   String formattedProject = ProjectName.format("[PROJECT]");
   *   AggregatedListNetworkEndpointGroupsHttpRequest request = AggregatedListNetworkEndpointGroupsHttpRequest.newBuilder()
   *     .setProject(formattedProject)
   *     .build();
   *   while (true) {
   *     NetworkEndpointGroupAggregatedList response = networkEndpointGroupClient.aggregatedListNetworkEndpointGroupsCallable().call(request);
   *     for (NetworkEndpointGroupsScopedList element : response.getItemsMap()) {
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
  @BetaApi
  public final UnaryCallable<
          AggregatedListNetworkEndpointGroupsHttpRequest, NetworkEndpointGroupAggregatedList>
      aggregatedListNetworkEndpointGroupsCallable() {
    return stub.aggregatedListNetworkEndpointGroupsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Attach a list of network endpoints to the specified network endpoint group.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NetworkEndpointGroupClient networkEndpointGroupClient = NetworkEndpointGroupClient.create()) {
   *   ProjectZoneNetworkEndpointGroupName networkEndpointGroup = ProjectZoneNetworkEndpointGroupName.of("[PROJECT]", "[ZONE]", "[NETWORK_ENDPOINT_GROUP]");
   *   NetworkEndpointGroupsAttachEndpointsRequest networkEndpointGroupsAttachEndpointsRequestResource = NetworkEndpointGroupsAttachEndpointsRequest.newBuilder().build();
   *   Operation response = networkEndpointGroupClient.attachNetworkEndpointsNetworkEndpointGroup(networkEndpointGroup, networkEndpointGroupsAttachEndpointsRequestResource);
   * }
   * </code></pre>
   *
   * @param networkEndpointGroup The name of the network endpoint group where you are attaching
   *     network endpoints to. It should comply with RFC1035.
   * @param networkEndpointGroupsAttachEndpointsRequestResource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation attachNetworkEndpointsNetworkEndpointGroup(
      ProjectZoneNetworkEndpointGroupName networkEndpointGroup,
      NetworkEndpointGroupsAttachEndpointsRequest
          networkEndpointGroupsAttachEndpointsRequestResource) {

    AttachNetworkEndpointsNetworkEndpointGroupHttpRequest request =
        AttachNetworkEndpointsNetworkEndpointGroupHttpRequest.newBuilder()
            .setNetworkEndpointGroup(
                networkEndpointGroup == null ? null : networkEndpointGroup.toString())
            .setNetworkEndpointGroupsAttachEndpointsRequestResource(
                networkEndpointGroupsAttachEndpointsRequestResource)
            .build();
    return attachNetworkEndpointsNetworkEndpointGroup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Attach a list of network endpoints to the specified network endpoint group.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NetworkEndpointGroupClient networkEndpointGroupClient = NetworkEndpointGroupClient.create()) {
   *   ProjectZoneNetworkEndpointGroupName networkEndpointGroup = ProjectZoneNetworkEndpointGroupName.of("[PROJECT]", "[ZONE]", "[NETWORK_ENDPOINT_GROUP]");
   *   NetworkEndpointGroupsAttachEndpointsRequest networkEndpointGroupsAttachEndpointsRequestResource = NetworkEndpointGroupsAttachEndpointsRequest.newBuilder().build();
   *   Operation response = networkEndpointGroupClient.attachNetworkEndpointsNetworkEndpointGroup(networkEndpointGroup.toString(), networkEndpointGroupsAttachEndpointsRequestResource);
   * }
   * </code></pre>
   *
   * @param networkEndpointGroup The name of the network endpoint group where you are attaching
   *     network endpoints to. It should comply with RFC1035.
   * @param networkEndpointGroupsAttachEndpointsRequestResource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation attachNetworkEndpointsNetworkEndpointGroup(
      String networkEndpointGroup,
      NetworkEndpointGroupsAttachEndpointsRequest
          networkEndpointGroupsAttachEndpointsRequestResource) {

    AttachNetworkEndpointsNetworkEndpointGroupHttpRequest request =
        AttachNetworkEndpointsNetworkEndpointGroupHttpRequest.newBuilder()
            .setNetworkEndpointGroup(networkEndpointGroup)
            .setNetworkEndpointGroupsAttachEndpointsRequestResource(
                networkEndpointGroupsAttachEndpointsRequestResource)
            .build();
    return attachNetworkEndpointsNetworkEndpointGroup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Attach a list of network endpoints to the specified network endpoint group.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NetworkEndpointGroupClient networkEndpointGroupClient = NetworkEndpointGroupClient.create()) {
   *   String formattedNetworkEndpointGroup = ProjectZoneNetworkEndpointGroupName.format("[PROJECT]", "[ZONE]", "[NETWORK_ENDPOINT_GROUP]");
   *   NetworkEndpointGroupsAttachEndpointsRequest networkEndpointGroupsAttachEndpointsRequestResource = NetworkEndpointGroupsAttachEndpointsRequest.newBuilder().build();
   *   AttachNetworkEndpointsNetworkEndpointGroupHttpRequest request = AttachNetworkEndpointsNetworkEndpointGroupHttpRequest.newBuilder()
   *     .setNetworkEndpointGroup(formattedNetworkEndpointGroup)
   *     .setNetworkEndpointGroupsAttachEndpointsRequestResource(networkEndpointGroupsAttachEndpointsRequestResource)
   *     .build();
   *   Operation response = networkEndpointGroupClient.attachNetworkEndpointsNetworkEndpointGroup(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation attachNetworkEndpointsNetworkEndpointGroup(
      AttachNetworkEndpointsNetworkEndpointGroupHttpRequest request) {
    return attachNetworkEndpointsNetworkEndpointGroupCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Attach a list of network endpoints to the specified network endpoint group.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NetworkEndpointGroupClient networkEndpointGroupClient = NetworkEndpointGroupClient.create()) {
   *   String formattedNetworkEndpointGroup = ProjectZoneNetworkEndpointGroupName.format("[PROJECT]", "[ZONE]", "[NETWORK_ENDPOINT_GROUP]");
   *   NetworkEndpointGroupsAttachEndpointsRequest networkEndpointGroupsAttachEndpointsRequestResource = NetworkEndpointGroupsAttachEndpointsRequest.newBuilder().build();
   *   AttachNetworkEndpointsNetworkEndpointGroupHttpRequest request = AttachNetworkEndpointsNetworkEndpointGroupHttpRequest.newBuilder()
   *     .setNetworkEndpointGroup(formattedNetworkEndpointGroup)
   *     .setNetworkEndpointGroupsAttachEndpointsRequestResource(networkEndpointGroupsAttachEndpointsRequestResource)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = networkEndpointGroupClient.attachNetworkEndpointsNetworkEndpointGroupCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<AttachNetworkEndpointsNetworkEndpointGroupHttpRequest, Operation>
      attachNetworkEndpointsNetworkEndpointGroupCallable() {
    return stub.attachNetworkEndpointsNetworkEndpointGroupCallable();
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
   * try (NetworkEndpointGroupClient networkEndpointGroupClient = NetworkEndpointGroupClient.create()) {
   *   ProjectZoneNetworkEndpointGroupName networkEndpointGroup = ProjectZoneNetworkEndpointGroupName.of("[PROJECT]", "[ZONE]", "[NETWORK_ENDPOINT_GROUP]");
   *   Operation response = networkEndpointGroupClient.deleteNetworkEndpointGroup(networkEndpointGroup);
   * }
   * </code></pre>
   *
   * @param networkEndpointGroup The name of the network endpoint group to delete. It should comply
   *     with RFC1035.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation deleteNetworkEndpointGroup(
      ProjectZoneNetworkEndpointGroupName networkEndpointGroup) {

    DeleteNetworkEndpointGroupHttpRequest request =
        DeleteNetworkEndpointGroupHttpRequest.newBuilder()
            .setNetworkEndpointGroup(
                networkEndpointGroup == null ? null : networkEndpointGroup.toString())
            .build();
    return deleteNetworkEndpointGroup(request);
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
   * try (NetworkEndpointGroupClient networkEndpointGroupClient = NetworkEndpointGroupClient.create()) {
   *   ProjectZoneNetworkEndpointGroupName networkEndpointGroup = ProjectZoneNetworkEndpointGroupName.of("[PROJECT]", "[ZONE]", "[NETWORK_ENDPOINT_GROUP]");
   *   Operation response = networkEndpointGroupClient.deleteNetworkEndpointGroup(networkEndpointGroup.toString());
   * }
   * </code></pre>
   *
   * @param networkEndpointGroup The name of the network endpoint group to delete. It should comply
   *     with RFC1035.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation deleteNetworkEndpointGroup(String networkEndpointGroup) {

    DeleteNetworkEndpointGroupHttpRequest request =
        DeleteNetworkEndpointGroupHttpRequest.newBuilder()
            .setNetworkEndpointGroup(networkEndpointGroup)
            .build();
    return deleteNetworkEndpointGroup(request);
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
   * try (NetworkEndpointGroupClient networkEndpointGroupClient = NetworkEndpointGroupClient.create()) {
   *   String formattedNetworkEndpointGroup = ProjectZoneNetworkEndpointGroupName.format("[PROJECT]", "[ZONE]", "[NETWORK_ENDPOINT_GROUP]");
   *   DeleteNetworkEndpointGroupHttpRequest request = DeleteNetworkEndpointGroupHttpRequest.newBuilder()
   *     .setNetworkEndpointGroup(formattedNetworkEndpointGroup)
   *     .build();
   *   Operation response = networkEndpointGroupClient.deleteNetworkEndpointGroup(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation deleteNetworkEndpointGroup(DeleteNetworkEndpointGroupHttpRequest request) {
    return deleteNetworkEndpointGroupCallable().call(request);
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
   * try (NetworkEndpointGroupClient networkEndpointGroupClient = NetworkEndpointGroupClient.create()) {
   *   String formattedNetworkEndpointGroup = ProjectZoneNetworkEndpointGroupName.format("[PROJECT]", "[ZONE]", "[NETWORK_ENDPOINT_GROUP]");
   *   DeleteNetworkEndpointGroupHttpRequest request = DeleteNetworkEndpointGroupHttpRequest.newBuilder()
   *     .setNetworkEndpointGroup(formattedNetworkEndpointGroup)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = networkEndpointGroupClient.deleteNetworkEndpointGroupCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<DeleteNetworkEndpointGroupHttpRequest, Operation>
      deleteNetworkEndpointGroupCallable() {
    return stub.deleteNetworkEndpointGroupCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Detach a list of network endpoints from the specified network endpoint group.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NetworkEndpointGroupClient networkEndpointGroupClient = NetworkEndpointGroupClient.create()) {
   *   ProjectZoneNetworkEndpointGroupName networkEndpointGroup = ProjectZoneNetworkEndpointGroupName.of("[PROJECT]", "[ZONE]", "[NETWORK_ENDPOINT_GROUP]");
   *   NetworkEndpointGroupsDetachEndpointsRequest networkEndpointGroupsDetachEndpointsRequestResource = NetworkEndpointGroupsDetachEndpointsRequest.newBuilder().build();
   *   Operation response = networkEndpointGroupClient.detachNetworkEndpointsNetworkEndpointGroup(networkEndpointGroup, networkEndpointGroupsDetachEndpointsRequestResource);
   * }
   * </code></pre>
   *
   * @param networkEndpointGroup The name of the network endpoint group where you are removing
   *     network endpoints. It should comply with RFC1035.
   * @param networkEndpointGroupsDetachEndpointsRequestResource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation detachNetworkEndpointsNetworkEndpointGroup(
      ProjectZoneNetworkEndpointGroupName networkEndpointGroup,
      NetworkEndpointGroupsDetachEndpointsRequest
          networkEndpointGroupsDetachEndpointsRequestResource) {

    DetachNetworkEndpointsNetworkEndpointGroupHttpRequest request =
        DetachNetworkEndpointsNetworkEndpointGroupHttpRequest.newBuilder()
            .setNetworkEndpointGroup(
                networkEndpointGroup == null ? null : networkEndpointGroup.toString())
            .setNetworkEndpointGroupsDetachEndpointsRequestResource(
                networkEndpointGroupsDetachEndpointsRequestResource)
            .build();
    return detachNetworkEndpointsNetworkEndpointGroup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Detach a list of network endpoints from the specified network endpoint group.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NetworkEndpointGroupClient networkEndpointGroupClient = NetworkEndpointGroupClient.create()) {
   *   ProjectZoneNetworkEndpointGroupName networkEndpointGroup = ProjectZoneNetworkEndpointGroupName.of("[PROJECT]", "[ZONE]", "[NETWORK_ENDPOINT_GROUP]");
   *   NetworkEndpointGroupsDetachEndpointsRequest networkEndpointGroupsDetachEndpointsRequestResource = NetworkEndpointGroupsDetachEndpointsRequest.newBuilder().build();
   *   Operation response = networkEndpointGroupClient.detachNetworkEndpointsNetworkEndpointGroup(networkEndpointGroup.toString(), networkEndpointGroupsDetachEndpointsRequestResource);
   * }
   * </code></pre>
   *
   * @param networkEndpointGroup The name of the network endpoint group where you are removing
   *     network endpoints. It should comply with RFC1035.
   * @param networkEndpointGroupsDetachEndpointsRequestResource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation detachNetworkEndpointsNetworkEndpointGroup(
      String networkEndpointGroup,
      NetworkEndpointGroupsDetachEndpointsRequest
          networkEndpointGroupsDetachEndpointsRequestResource) {

    DetachNetworkEndpointsNetworkEndpointGroupHttpRequest request =
        DetachNetworkEndpointsNetworkEndpointGroupHttpRequest.newBuilder()
            .setNetworkEndpointGroup(networkEndpointGroup)
            .setNetworkEndpointGroupsDetachEndpointsRequestResource(
                networkEndpointGroupsDetachEndpointsRequestResource)
            .build();
    return detachNetworkEndpointsNetworkEndpointGroup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Detach a list of network endpoints from the specified network endpoint group.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NetworkEndpointGroupClient networkEndpointGroupClient = NetworkEndpointGroupClient.create()) {
   *   String formattedNetworkEndpointGroup = ProjectZoneNetworkEndpointGroupName.format("[PROJECT]", "[ZONE]", "[NETWORK_ENDPOINT_GROUP]");
   *   NetworkEndpointGroupsDetachEndpointsRequest networkEndpointGroupsDetachEndpointsRequestResource = NetworkEndpointGroupsDetachEndpointsRequest.newBuilder().build();
   *   DetachNetworkEndpointsNetworkEndpointGroupHttpRequest request = DetachNetworkEndpointsNetworkEndpointGroupHttpRequest.newBuilder()
   *     .setNetworkEndpointGroup(formattedNetworkEndpointGroup)
   *     .setNetworkEndpointGroupsDetachEndpointsRequestResource(networkEndpointGroupsDetachEndpointsRequestResource)
   *     .build();
   *   Operation response = networkEndpointGroupClient.detachNetworkEndpointsNetworkEndpointGroup(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation detachNetworkEndpointsNetworkEndpointGroup(
      DetachNetworkEndpointsNetworkEndpointGroupHttpRequest request) {
    return detachNetworkEndpointsNetworkEndpointGroupCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Detach a list of network endpoints from the specified network endpoint group.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NetworkEndpointGroupClient networkEndpointGroupClient = NetworkEndpointGroupClient.create()) {
   *   String formattedNetworkEndpointGroup = ProjectZoneNetworkEndpointGroupName.format("[PROJECT]", "[ZONE]", "[NETWORK_ENDPOINT_GROUP]");
   *   NetworkEndpointGroupsDetachEndpointsRequest networkEndpointGroupsDetachEndpointsRequestResource = NetworkEndpointGroupsDetachEndpointsRequest.newBuilder().build();
   *   DetachNetworkEndpointsNetworkEndpointGroupHttpRequest request = DetachNetworkEndpointsNetworkEndpointGroupHttpRequest.newBuilder()
   *     .setNetworkEndpointGroup(formattedNetworkEndpointGroup)
   *     .setNetworkEndpointGroupsDetachEndpointsRequestResource(networkEndpointGroupsDetachEndpointsRequestResource)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = networkEndpointGroupClient.detachNetworkEndpointsNetworkEndpointGroupCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<DetachNetworkEndpointsNetworkEndpointGroupHttpRequest, Operation>
      detachNetworkEndpointsNetworkEndpointGroupCallable() {
    return stub.detachNetworkEndpointsNetworkEndpointGroupCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified network endpoint group. Gets a list of available network endpoint groups
   * by making a list() request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NetworkEndpointGroupClient networkEndpointGroupClient = NetworkEndpointGroupClient.create()) {
   *   ProjectZoneNetworkEndpointGroupName networkEndpointGroup = ProjectZoneNetworkEndpointGroupName.of("[PROJECT]", "[ZONE]", "[NETWORK_ENDPOINT_GROUP]");
   *   NetworkEndpointGroup response = networkEndpointGroupClient.getNetworkEndpointGroup(networkEndpointGroup);
   * }
   * </code></pre>
   *
   * @param networkEndpointGroup The name of the network endpoint group. It should comply with
   *     RFC1035.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final NetworkEndpointGroup getNetworkEndpointGroup(
      ProjectZoneNetworkEndpointGroupName networkEndpointGroup) {

    GetNetworkEndpointGroupHttpRequest request =
        GetNetworkEndpointGroupHttpRequest.newBuilder()
            .setNetworkEndpointGroup(
                networkEndpointGroup == null ? null : networkEndpointGroup.toString())
            .build();
    return getNetworkEndpointGroup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified network endpoint group. Gets a list of available network endpoint groups
   * by making a list() request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NetworkEndpointGroupClient networkEndpointGroupClient = NetworkEndpointGroupClient.create()) {
   *   ProjectZoneNetworkEndpointGroupName networkEndpointGroup = ProjectZoneNetworkEndpointGroupName.of("[PROJECT]", "[ZONE]", "[NETWORK_ENDPOINT_GROUP]");
   *   NetworkEndpointGroup response = networkEndpointGroupClient.getNetworkEndpointGroup(networkEndpointGroup.toString());
   * }
   * </code></pre>
   *
   * @param networkEndpointGroup The name of the network endpoint group. It should comply with
   *     RFC1035.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final NetworkEndpointGroup getNetworkEndpointGroup(String networkEndpointGroup) {

    GetNetworkEndpointGroupHttpRequest request =
        GetNetworkEndpointGroupHttpRequest.newBuilder()
            .setNetworkEndpointGroup(networkEndpointGroup)
            .build();
    return getNetworkEndpointGroup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified network endpoint group. Gets a list of available network endpoint groups
   * by making a list() request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NetworkEndpointGroupClient networkEndpointGroupClient = NetworkEndpointGroupClient.create()) {
   *   String formattedNetworkEndpointGroup = ProjectZoneNetworkEndpointGroupName.format("[PROJECT]", "[ZONE]", "[NETWORK_ENDPOINT_GROUP]");
   *   GetNetworkEndpointGroupHttpRequest request = GetNetworkEndpointGroupHttpRequest.newBuilder()
   *     .setNetworkEndpointGroup(formattedNetworkEndpointGroup)
   *     .build();
   *   NetworkEndpointGroup response = networkEndpointGroupClient.getNetworkEndpointGroup(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final NetworkEndpointGroup getNetworkEndpointGroup(
      GetNetworkEndpointGroupHttpRequest request) {
    return getNetworkEndpointGroupCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified network endpoint group. Gets a list of available network endpoint groups
   * by making a list() request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NetworkEndpointGroupClient networkEndpointGroupClient = NetworkEndpointGroupClient.create()) {
   *   String formattedNetworkEndpointGroup = ProjectZoneNetworkEndpointGroupName.format("[PROJECT]", "[ZONE]", "[NETWORK_ENDPOINT_GROUP]");
   *   GetNetworkEndpointGroupHttpRequest request = GetNetworkEndpointGroupHttpRequest.newBuilder()
   *     .setNetworkEndpointGroup(formattedNetworkEndpointGroup)
   *     .build();
   *   ApiFuture&lt;NetworkEndpointGroup&gt; future = networkEndpointGroupClient.getNetworkEndpointGroupCallable().futureCall(request);
   *   // Do something
   *   NetworkEndpointGroup response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<GetNetworkEndpointGroupHttpRequest, NetworkEndpointGroup>
      getNetworkEndpointGroupCallable() {
    return stub.getNetworkEndpointGroupCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a network endpoint group in the specified project using the parameters that are
   * included in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NetworkEndpointGroupClient networkEndpointGroupClient = NetworkEndpointGroupClient.create()) {
   *   ProjectZoneName zone = ProjectZoneName.of("[PROJECT]", "[ZONE]");
   *   NetworkEndpointGroup networkEndpointGroupResource = NetworkEndpointGroup.newBuilder().build();
   *   Operation response = networkEndpointGroupClient.insertNetworkEndpointGroup(zone, networkEndpointGroupResource);
   * }
   * </code></pre>
   *
   * @param zone The name of the zone where you want to create the network endpoint group. It should
   *     comply with RFC1035.
   * @param networkEndpointGroupResource Represents a collection of network endpoints.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation insertNetworkEndpointGroup(
      ProjectZoneName zone, NetworkEndpointGroup networkEndpointGroupResource) {

    InsertNetworkEndpointGroupHttpRequest request =
        InsertNetworkEndpointGroupHttpRequest.newBuilder()
            .setZone(zone == null ? null : zone.toString())
            .setNetworkEndpointGroupResource(networkEndpointGroupResource)
            .build();
    return insertNetworkEndpointGroup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a network endpoint group in the specified project using the parameters that are
   * included in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NetworkEndpointGroupClient networkEndpointGroupClient = NetworkEndpointGroupClient.create()) {
   *   ProjectZoneName zone = ProjectZoneName.of("[PROJECT]", "[ZONE]");
   *   NetworkEndpointGroup networkEndpointGroupResource = NetworkEndpointGroup.newBuilder().build();
   *   Operation response = networkEndpointGroupClient.insertNetworkEndpointGroup(zone.toString(), networkEndpointGroupResource);
   * }
   * </code></pre>
   *
   * @param zone The name of the zone where you want to create the network endpoint group. It should
   *     comply with RFC1035.
   * @param networkEndpointGroupResource Represents a collection of network endpoints.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation insertNetworkEndpointGroup(
      String zone, NetworkEndpointGroup networkEndpointGroupResource) {

    InsertNetworkEndpointGroupHttpRequest request =
        InsertNetworkEndpointGroupHttpRequest.newBuilder()
            .setZone(zone)
            .setNetworkEndpointGroupResource(networkEndpointGroupResource)
            .build();
    return insertNetworkEndpointGroup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a network endpoint group in the specified project using the parameters that are
   * included in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NetworkEndpointGroupClient networkEndpointGroupClient = NetworkEndpointGroupClient.create()) {
   *   String formattedZone = ProjectZoneName.format("[PROJECT]", "[ZONE]");
   *   NetworkEndpointGroup networkEndpointGroupResource = NetworkEndpointGroup.newBuilder().build();
   *   InsertNetworkEndpointGroupHttpRequest request = InsertNetworkEndpointGroupHttpRequest.newBuilder()
   *     .setZone(formattedZone)
   *     .setNetworkEndpointGroupResource(networkEndpointGroupResource)
   *     .build();
   *   Operation response = networkEndpointGroupClient.insertNetworkEndpointGroup(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation insertNetworkEndpointGroup(InsertNetworkEndpointGroupHttpRequest request) {
    return insertNetworkEndpointGroupCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a network endpoint group in the specified project using the parameters that are
   * included in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NetworkEndpointGroupClient networkEndpointGroupClient = NetworkEndpointGroupClient.create()) {
   *   String formattedZone = ProjectZoneName.format("[PROJECT]", "[ZONE]");
   *   NetworkEndpointGroup networkEndpointGroupResource = NetworkEndpointGroup.newBuilder().build();
   *   InsertNetworkEndpointGroupHttpRequest request = InsertNetworkEndpointGroupHttpRequest.newBuilder()
   *     .setZone(formattedZone)
   *     .setNetworkEndpointGroupResource(networkEndpointGroupResource)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = networkEndpointGroupClient.insertNetworkEndpointGroupCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<InsertNetworkEndpointGroupHttpRequest, Operation>
      insertNetworkEndpointGroupCallable() {
    return stub.insertNetworkEndpointGroupCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of network endpoint groups that are located in the specified project and
   * zone.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NetworkEndpointGroupClient networkEndpointGroupClient = NetworkEndpointGroupClient.create()) {
   *   ProjectZoneName zone = ProjectZoneName.of("[PROJECT]", "[ZONE]");
   *   for (NetworkEndpointGroup element : networkEndpointGroupClient.listNetworkEndpointGroups(zone).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param zone The name of the zone where the network endpoint group is located. It should comply
   *     with RFC1035.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListNetworkEndpointGroupsPagedResponse listNetworkEndpointGroups(
      ProjectZoneName zone) {
    ListNetworkEndpointGroupsHttpRequest request =
        ListNetworkEndpointGroupsHttpRequest.newBuilder()
            .setZone(zone == null ? null : zone.toString())
            .build();
    return listNetworkEndpointGroups(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of network endpoint groups that are located in the specified project and
   * zone.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NetworkEndpointGroupClient networkEndpointGroupClient = NetworkEndpointGroupClient.create()) {
   *   ProjectZoneName zone = ProjectZoneName.of("[PROJECT]", "[ZONE]");
   *   for (NetworkEndpointGroup element : networkEndpointGroupClient.listNetworkEndpointGroups(zone.toString()).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param zone The name of the zone where the network endpoint group is located. It should comply
   *     with RFC1035.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListNetworkEndpointGroupsPagedResponse listNetworkEndpointGroups(String zone) {
    ListNetworkEndpointGroupsHttpRequest request =
        ListNetworkEndpointGroupsHttpRequest.newBuilder().setZone(zone).build();
    return listNetworkEndpointGroups(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of network endpoint groups that are located in the specified project and
   * zone.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NetworkEndpointGroupClient networkEndpointGroupClient = NetworkEndpointGroupClient.create()) {
   *   String formattedZone = ProjectZoneName.format("[PROJECT]", "[ZONE]");
   *   ListNetworkEndpointGroupsHttpRequest request = ListNetworkEndpointGroupsHttpRequest.newBuilder()
   *     .setZone(formattedZone)
   *     .build();
   *   for (NetworkEndpointGroup element : networkEndpointGroupClient.listNetworkEndpointGroups(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListNetworkEndpointGroupsPagedResponse listNetworkEndpointGroups(
      ListNetworkEndpointGroupsHttpRequest request) {
    return listNetworkEndpointGroupsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of network endpoint groups that are located in the specified project and
   * zone.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NetworkEndpointGroupClient networkEndpointGroupClient = NetworkEndpointGroupClient.create()) {
   *   String formattedZone = ProjectZoneName.format("[PROJECT]", "[ZONE]");
   *   ListNetworkEndpointGroupsHttpRequest request = ListNetworkEndpointGroupsHttpRequest.newBuilder()
   *     .setZone(formattedZone)
   *     .build();
   *   ApiFuture&lt;ListNetworkEndpointGroupsPagedResponse&gt; future = networkEndpointGroupClient.listNetworkEndpointGroupsPagedCallable().futureCall(request);
   *   // Do something
   *   for (NetworkEndpointGroup element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<
          ListNetworkEndpointGroupsHttpRequest, ListNetworkEndpointGroupsPagedResponse>
      listNetworkEndpointGroupsPagedCallable() {
    return stub.listNetworkEndpointGroupsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of network endpoint groups that are located in the specified project and
   * zone.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NetworkEndpointGroupClient networkEndpointGroupClient = NetworkEndpointGroupClient.create()) {
   *   String formattedZone = ProjectZoneName.format("[PROJECT]", "[ZONE]");
   *   ListNetworkEndpointGroupsHttpRequest request = ListNetworkEndpointGroupsHttpRequest.newBuilder()
   *     .setZone(formattedZone)
   *     .build();
   *   while (true) {
   *     NetworkEndpointGroupList response = networkEndpointGroupClient.listNetworkEndpointGroupsCallable().call(request);
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
  @BetaApi
  public final UnaryCallable<ListNetworkEndpointGroupsHttpRequest, NetworkEndpointGroupList>
      listNetworkEndpointGroupsCallable() {
    return stub.listNetworkEndpointGroupsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists the network endpoints in the specified network endpoint group.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NetworkEndpointGroupClient networkEndpointGroupClient = NetworkEndpointGroupClient.create()) {
   *   ProjectZoneNetworkEndpointGroupName networkEndpointGroup = ProjectZoneNetworkEndpointGroupName.of("[PROJECT]", "[ZONE]", "[NETWORK_ENDPOINT_GROUP]");
   *   NetworkEndpointGroupsListEndpointsRequest networkEndpointGroupsListEndpointsRequestResource = NetworkEndpointGroupsListEndpointsRequest.newBuilder().build();
   *   for (NetworkEndpointWithHealthStatus element : networkEndpointGroupClient.listNetworkEndpointsNetworkEndpointGroups(networkEndpointGroup, networkEndpointGroupsListEndpointsRequestResource).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param networkEndpointGroup The name of the network endpoint group from which you want to
   *     generate a list of included network endpoints. It should comply with RFC1035.
   * @param networkEndpointGroupsListEndpointsRequestResource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListNetworkEndpointsNetworkEndpointGroupsPagedResponse
      listNetworkEndpointsNetworkEndpointGroups(
          ProjectZoneNetworkEndpointGroupName networkEndpointGroup,
          NetworkEndpointGroupsListEndpointsRequest
              networkEndpointGroupsListEndpointsRequestResource) {
    ListNetworkEndpointsNetworkEndpointGroupsHttpRequest request =
        ListNetworkEndpointsNetworkEndpointGroupsHttpRequest.newBuilder()
            .setNetworkEndpointGroup(
                networkEndpointGroup == null ? null : networkEndpointGroup.toString())
            .setNetworkEndpointGroupsListEndpointsRequestResource(
                networkEndpointGroupsListEndpointsRequestResource)
            .build();
    return listNetworkEndpointsNetworkEndpointGroups(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists the network endpoints in the specified network endpoint group.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NetworkEndpointGroupClient networkEndpointGroupClient = NetworkEndpointGroupClient.create()) {
   *   ProjectZoneNetworkEndpointGroupName networkEndpointGroup = ProjectZoneNetworkEndpointGroupName.of("[PROJECT]", "[ZONE]", "[NETWORK_ENDPOINT_GROUP]");
   *   NetworkEndpointGroupsListEndpointsRequest networkEndpointGroupsListEndpointsRequestResource = NetworkEndpointGroupsListEndpointsRequest.newBuilder().build();
   *   for (NetworkEndpointWithHealthStatus element : networkEndpointGroupClient.listNetworkEndpointsNetworkEndpointGroups(networkEndpointGroup.toString(), networkEndpointGroupsListEndpointsRequestResource).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param networkEndpointGroup The name of the network endpoint group from which you want to
   *     generate a list of included network endpoints. It should comply with RFC1035.
   * @param networkEndpointGroupsListEndpointsRequestResource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListNetworkEndpointsNetworkEndpointGroupsPagedResponse
      listNetworkEndpointsNetworkEndpointGroups(
          String networkEndpointGroup,
          NetworkEndpointGroupsListEndpointsRequest
              networkEndpointGroupsListEndpointsRequestResource) {
    ListNetworkEndpointsNetworkEndpointGroupsHttpRequest request =
        ListNetworkEndpointsNetworkEndpointGroupsHttpRequest.newBuilder()
            .setNetworkEndpointGroup(networkEndpointGroup)
            .setNetworkEndpointGroupsListEndpointsRequestResource(
                networkEndpointGroupsListEndpointsRequestResource)
            .build();
    return listNetworkEndpointsNetworkEndpointGroups(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists the network endpoints in the specified network endpoint group.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NetworkEndpointGroupClient networkEndpointGroupClient = NetworkEndpointGroupClient.create()) {
   *   String formattedNetworkEndpointGroup = ProjectZoneNetworkEndpointGroupName.format("[PROJECT]", "[ZONE]", "[NETWORK_ENDPOINT_GROUP]");
   *   NetworkEndpointGroupsListEndpointsRequest networkEndpointGroupsListEndpointsRequestResource = NetworkEndpointGroupsListEndpointsRequest.newBuilder().build();
   *   ListNetworkEndpointsNetworkEndpointGroupsHttpRequest request = ListNetworkEndpointsNetworkEndpointGroupsHttpRequest.newBuilder()
   *     .setNetworkEndpointGroup(formattedNetworkEndpointGroup)
   *     .setNetworkEndpointGroupsListEndpointsRequestResource(networkEndpointGroupsListEndpointsRequestResource)
   *     .build();
   *   for (NetworkEndpointWithHealthStatus element : networkEndpointGroupClient.listNetworkEndpointsNetworkEndpointGroups(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListNetworkEndpointsNetworkEndpointGroupsPagedResponse
      listNetworkEndpointsNetworkEndpointGroups(
          ListNetworkEndpointsNetworkEndpointGroupsHttpRequest request) {
    return listNetworkEndpointsNetworkEndpointGroupsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists the network endpoints in the specified network endpoint group.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NetworkEndpointGroupClient networkEndpointGroupClient = NetworkEndpointGroupClient.create()) {
   *   String formattedNetworkEndpointGroup = ProjectZoneNetworkEndpointGroupName.format("[PROJECT]", "[ZONE]", "[NETWORK_ENDPOINT_GROUP]");
   *   NetworkEndpointGroupsListEndpointsRequest networkEndpointGroupsListEndpointsRequestResource = NetworkEndpointGroupsListEndpointsRequest.newBuilder().build();
   *   ListNetworkEndpointsNetworkEndpointGroupsHttpRequest request = ListNetworkEndpointsNetworkEndpointGroupsHttpRequest.newBuilder()
   *     .setNetworkEndpointGroup(formattedNetworkEndpointGroup)
   *     .setNetworkEndpointGroupsListEndpointsRequestResource(networkEndpointGroupsListEndpointsRequestResource)
   *     .build();
   *   ApiFuture&lt;ListNetworkEndpointsNetworkEndpointGroupsPagedResponse&gt; future = networkEndpointGroupClient.listNetworkEndpointsNetworkEndpointGroupsPagedCallable().futureCall(request);
   *   // Do something
   *   for (NetworkEndpointWithHealthStatus element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<
          ListNetworkEndpointsNetworkEndpointGroupsHttpRequest,
          ListNetworkEndpointsNetworkEndpointGroupsPagedResponse>
      listNetworkEndpointsNetworkEndpointGroupsPagedCallable() {
    return stub.listNetworkEndpointsNetworkEndpointGroupsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists the network endpoints in the specified network endpoint group.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NetworkEndpointGroupClient networkEndpointGroupClient = NetworkEndpointGroupClient.create()) {
   *   String formattedNetworkEndpointGroup = ProjectZoneNetworkEndpointGroupName.format("[PROJECT]", "[ZONE]", "[NETWORK_ENDPOINT_GROUP]");
   *   NetworkEndpointGroupsListEndpointsRequest networkEndpointGroupsListEndpointsRequestResource = NetworkEndpointGroupsListEndpointsRequest.newBuilder().build();
   *   ListNetworkEndpointsNetworkEndpointGroupsHttpRequest request = ListNetworkEndpointsNetworkEndpointGroupsHttpRequest.newBuilder()
   *     .setNetworkEndpointGroup(formattedNetworkEndpointGroup)
   *     .setNetworkEndpointGroupsListEndpointsRequestResource(networkEndpointGroupsListEndpointsRequestResource)
   *     .build();
   *   while (true) {
   *     NetworkEndpointGroupsListNetworkEndpoints response = networkEndpointGroupClient.listNetworkEndpointsNetworkEndpointGroupsCallable().call(request);
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
  @BetaApi
  public final UnaryCallable<
          ListNetworkEndpointsNetworkEndpointGroupsHttpRequest,
          NetworkEndpointGroupsListNetworkEndpoints>
      listNetworkEndpointsNetworkEndpointGroupsCallable() {
    return stub.listNetworkEndpointsNetworkEndpointGroupsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns permissions that a caller has on the specified resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NetworkEndpointGroupClient networkEndpointGroupClient = NetworkEndpointGroupClient.create()) {
   *   ProjectZoneNetworkEndpointGroupResourceName resource = ProjectZoneNetworkEndpointGroupResourceName.of("[PROJECT]", "[ZONE]", "[RESOURCE]");
   *   TestPermissionsRequest testPermissionsRequestResource = TestPermissionsRequest.newBuilder().build();
   *   TestPermissionsResponse response = networkEndpointGroupClient.testIamPermissionsNetworkEndpointGroup(resource, testPermissionsRequestResource);
   * }
   * </code></pre>
   *
   * @param resource Name or id of the resource for this request.
   * @param testPermissionsRequestResource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final TestPermissionsResponse testIamPermissionsNetworkEndpointGroup(
      ProjectZoneNetworkEndpointGroupResourceName resource,
      TestPermissionsRequest testPermissionsRequestResource) {

    TestIamPermissionsNetworkEndpointGroupHttpRequest request =
        TestIamPermissionsNetworkEndpointGroupHttpRequest.newBuilder()
            .setResource(resource == null ? null : resource.toString())
            .setTestPermissionsRequestResource(testPermissionsRequestResource)
            .build();
    return testIamPermissionsNetworkEndpointGroup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns permissions that a caller has on the specified resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NetworkEndpointGroupClient networkEndpointGroupClient = NetworkEndpointGroupClient.create()) {
   *   ProjectZoneNetworkEndpointGroupResourceName resource = ProjectZoneNetworkEndpointGroupResourceName.of("[PROJECT]", "[ZONE]", "[RESOURCE]");
   *   TestPermissionsRequest testPermissionsRequestResource = TestPermissionsRequest.newBuilder().build();
   *   TestPermissionsResponse response = networkEndpointGroupClient.testIamPermissionsNetworkEndpointGroup(resource.toString(), testPermissionsRequestResource);
   * }
   * </code></pre>
   *
   * @param resource Name or id of the resource for this request.
   * @param testPermissionsRequestResource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final TestPermissionsResponse testIamPermissionsNetworkEndpointGroup(
      String resource, TestPermissionsRequest testPermissionsRequestResource) {

    TestIamPermissionsNetworkEndpointGroupHttpRequest request =
        TestIamPermissionsNetworkEndpointGroupHttpRequest.newBuilder()
            .setResource(resource)
            .setTestPermissionsRequestResource(testPermissionsRequestResource)
            .build();
    return testIamPermissionsNetworkEndpointGroup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns permissions that a caller has on the specified resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NetworkEndpointGroupClient networkEndpointGroupClient = NetworkEndpointGroupClient.create()) {
   *   String formattedResource = ProjectZoneNetworkEndpointGroupResourceName.format("[PROJECT]", "[ZONE]", "[RESOURCE]");
   *   TestPermissionsRequest testPermissionsRequestResource = TestPermissionsRequest.newBuilder().build();
   *   TestIamPermissionsNetworkEndpointGroupHttpRequest request = TestIamPermissionsNetworkEndpointGroupHttpRequest.newBuilder()
   *     .setResource(formattedResource)
   *     .setTestPermissionsRequestResource(testPermissionsRequestResource)
   *     .build();
   *   TestPermissionsResponse response = networkEndpointGroupClient.testIamPermissionsNetworkEndpointGroup(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final TestPermissionsResponse testIamPermissionsNetworkEndpointGroup(
      TestIamPermissionsNetworkEndpointGroupHttpRequest request) {
    return testIamPermissionsNetworkEndpointGroupCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns permissions that a caller has on the specified resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NetworkEndpointGroupClient networkEndpointGroupClient = NetworkEndpointGroupClient.create()) {
   *   String formattedResource = ProjectZoneNetworkEndpointGroupResourceName.format("[PROJECT]", "[ZONE]", "[RESOURCE]");
   *   TestPermissionsRequest testPermissionsRequestResource = TestPermissionsRequest.newBuilder().build();
   *   TestIamPermissionsNetworkEndpointGroupHttpRequest request = TestIamPermissionsNetworkEndpointGroupHttpRequest.newBuilder()
   *     .setResource(formattedResource)
   *     .setTestPermissionsRequestResource(testPermissionsRequestResource)
   *     .build();
   *   ApiFuture&lt;TestPermissionsResponse&gt; future = networkEndpointGroupClient.testIamPermissionsNetworkEndpointGroupCallable().futureCall(request);
   *   // Do something
   *   TestPermissionsResponse response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<
          TestIamPermissionsNetworkEndpointGroupHttpRequest, TestPermissionsResponse>
      testIamPermissionsNetworkEndpointGroupCallable() {
    return stub.testIamPermissionsNetworkEndpointGroupCallable();
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

  public static class AggregatedListNetworkEndpointGroupsPagedResponse
      extends AbstractPagedListResponse<
          AggregatedListNetworkEndpointGroupsHttpRequest,
          NetworkEndpointGroupAggregatedList,
          NetworkEndpointGroupsScopedList,
          AggregatedListNetworkEndpointGroupsPage,
          AggregatedListNetworkEndpointGroupsFixedSizeCollection> {

    public static ApiFuture<AggregatedListNetworkEndpointGroupsPagedResponse> createAsync(
        PageContext<
                AggregatedListNetworkEndpointGroupsHttpRequest,
                NetworkEndpointGroupAggregatedList,
                NetworkEndpointGroupsScopedList>
            context,
        ApiFuture<NetworkEndpointGroupAggregatedList> futureResponse) {
      ApiFuture<AggregatedListNetworkEndpointGroupsPage> futurePage =
          AggregatedListNetworkEndpointGroupsPage.createEmptyPage()
              .createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<
              AggregatedListNetworkEndpointGroupsPage,
              AggregatedListNetworkEndpointGroupsPagedResponse>() {
            @Override
            public AggregatedListNetworkEndpointGroupsPagedResponse apply(
                AggregatedListNetworkEndpointGroupsPage input) {
              return new AggregatedListNetworkEndpointGroupsPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
    }

    private AggregatedListNetworkEndpointGroupsPagedResponse(
        AggregatedListNetworkEndpointGroupsPage page) {
      super(page, AggregatedListNetworkEndpointGroupsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class AggregatedListNetworkEndpointGroupsPage
      extends AbstractPage<
          AggregatedListNetworkEndpointGroupsHttpRequest,
          NetworkEndpointGroupAggregatedList,
          NetworkEndpointGroupsScopedList,
          AggregatedListNetworkEndpointGroupsPage> {

    private AggregatedListNetworkEndpointGroupsPage(
        PageContext<
                AggregatedListNetworkEndpointGroupsHttpRequest,
                NetworkEndpointGroupAggregatedList,
                NetworkEndpointGroupsScopedList>
            context,
        NetworkEndpointGroupAggregatedList response) {
      super(context, response);
    }

    private static AggregatedListNetworkEndpointGroupsPage createEmptyPage() {
      return new AggregatedListNetworkEndpointGroupsPage(null, null);
    }

    @Override
    protected AggregatedListNetworkEndpointGroupsPage createPage(
        PageContext<
                AggregatedListNetworkEndpointGroupsHttpRequest,
                NetworkEndpointGroupAggregatedList,
                NetworkEndpointGroupsScopedList>
            context,
        NetworkEndpointGroupAggregatedList response) {
      return new AggregatedListNetworkEndpointGroupsPage(context, response);
    }

    @Override
    public ApiFuture<AggregatedListNetworkEndpointGroupsPage> createPageAsync(
        PageContext<
                AggregatedListNetworkEndpointGroupsHttpRequest,
                NetworkEndpointGroupAggregatedList,
                NetworkEndpointGroupsScopedList>
            context,
        ApiFuture<NetworkEndpointGroupAggregatedList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class AggregatedListNetworkEndpointGroupsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          AggregatedListNetworkEndpointGroupsHttpRequest,
          NetworkEndpointGroupAggregatedList,
          NetworkEndpointGroupsScopedList,
          AggregatedListNetworkEndpointGroupsPage,
          AggregatedListNetworkEndpointGroupsFixedSizeCollection> {

    private AggregatedListNetworkEndpointGroupsFixedSizeCollection(
        List<AggregatedListNetworkEndpointGroupsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static AggregatedListNetworkEndpointGroupsFixedSizeCollection createEmptyCollection() {
      return new AggregatedListNetworkEndpointGroupsFixedSizeCollection(null, 0);
    }

    @Override
    protected AggregatedListNetworkEndpointGroupsFixedSizeCollection createCollection(
        List<AggregatedListNetworkEndpointGroupsPage> pages, int collectionSize) {
      return new AggregatedListNetworkEndpointGroupsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListNetworkEndpointGroupsPagedResponse
      extends AbstractPagedListResponse<
          ListNetworkEndpointGroupsHttpRequest,
          NetworkEndpointGroupList,
          NetworkEndpointGroup,
          ListNetworkEndpointGroupsPage,
          ListNetworkEndpointGroupsFixedSizeCollection> {

    public static ApiFuture<ListNetworkEndpointGroupsPagedResponse> createAsync(
        PageContext<
                ListNetworkEndpointGroupsHttpRequest,
                NetworkEndpointGroupList,
                NetworkEndpointGroup>
            context,
        ApiFuture<NetworkEndpointGroupList> futureResponse) {
      ApiFuture<ListNetworkEndpointGroupsPage> futurePage =
          ListNetworkEndpointGroupsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListNetworkEndpointGroupsPage, ListNetworkEndpointGroupsPagedResponse>() {
            @Override
            public ListNetworkEndpointGroupsPagedResponse apply(
                ListNetworkEndpointGroupsPage input) {
              return new ListNetworkEndpointGroupsPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
    }

    private ListNetworkEndpointGroupsPagedResponse(ListNetworkEndpointGroupsPage page) {
      super(page, ListNetworkEndpointGroupsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListNetworkEndpointGroupsPage
      extends AbstractPage<
          ListNetworkEndpointGroupsHttpRequest,
          NetworkEndpointGroupList,
          NetworkEndpointGroup,
          ListNetworkEndpointGroupsPage> {

    private ListNetworkEndpointGroupsPage(
        PageContext<
                ListNetworkEndpointGroupsHttpRequest,
                NetworkEndpointGroupList,
                NetworkEndpointGroup>
            context,
        NetworkEndpointGroupList response) {
      super(context, response);
    }

    private static ListNetworkEndpointGroupsPage createEmptyPage() {
      return new ListNetworkEndpointGroupsPage(null, null);
    }

    @Override
    protected ListNetworkEndpointGroupsPage createPage(
        PageContext<
                ListNetworkEndpointGroupsHttpRequest,
                NetworkEndpointGroupList,
                NetworkEndpointGroup>
            context,
        NetworkEndpointGroupList response) {
      return new ListNetworkEndpointGroupsPage(context, response);
    }

    @Override
    public ApiFuture<ListNetworkEndpointGroupsPage> createPageAsync(
        PageContext<
                ListNetworkEndpointGroupsHttpRequest,
                NetworkEndpointGroupList,
                NetworkEndpointGroup>
            context,
        ApiFuture<NetworkEndpointGroupList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListNetworkEndpointGroupsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListNetworkEndpointGroupsHttpRequest,
          NetworkEndpointGroupList,
          NetworkEndpointGroup,
          ListNetworkEndpointGroupsPage,
          ListNetworkEndpointGroupsFixedSizeCollection> {

    private ListNetworkEndpointGroupsFixedSizeCollection(
        List<ListNetworkEndpointGroupsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListNetworkEndpointGroupsFixedSizeCollection createEmptyCollection() {
      return new ListNetworkEndpointGroupsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListNetworkEndpointGroupsFixedSizeCollection createCollection(
        List<ListNetworkEndpointGroupsPage> pages, int collectionSize) {
      return new ListNetworkEndpointGroupsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListNetworkEndpointsNetworkEndpointGroupsPagedResponse
      extends AbstractPagedListResponse<
          ListNetworkEndpointsNetworkEndpointGroupsHttpRequest,
          NetworkEndpointGroupsListNetworkEndpoints,
          NetworkEndpointWithHealthStatus,
          ListNetworkEndpointsNetworkEndpointGroupsPage,
          ListNetworkEndpointsNetworkEndpointGroupsFixedSizeCollection> {

    public static ApiFuture<ListNetworkEndpointsNetworkEndpointGroupsPagedResponse> createAsync(
        PageContext<
                ListNetworkEndpointsNetworkEndpointGroupsHttpRequest,
                NetworkEndpointGroupsListNetworkEndpoints,
                NetworkEndpointWithHealthStatus>
            context,
        ApiFuture<NetworkEndpointGroupsListNetworkEndpoints> futureResponse) {
      ApiFuture<ListNetworkEndpointsNetworkEndpointGroupsPage> futurePage =
          ListNetworkEndpointsNetworkEndpointGroupsPage.createEmptyPage()
              .createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<
              ListNetworkEndpointsNetworkEndpointGroupsPage,
              ListNetworkEndpointsNetworkEndpointGroupsPagedResponse>() {
            @Override
            public ListNetworkEndpointsNetworkEndpointGroupsPagedResponse apply(
                ListNetworkEndpointsNetworkEndpointGroupsPage input) {
              return new ListNetworkEndpointsNetworkEndpointGroupsPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
    }

    private ListNetworkEndpointsNetworkEndpointGroupsPagedResponse(
        ListNetworkEndpointsNetworkEndpointGroupsPage page) {
      super(
          page,
          ListNetworkEndpointsNetworkEndpointGroupsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListNetworkEndpointsNetworkEndpointGroupsPage
      extends AbstractPage<
          ListNetworkEndpointsNetworkEndpointGroupsHttpRequest,
          NetworkEndpointGroupsListNetworkEndpoints,
          NetworkEndpointWithHealthStatus,
          ListNetworkEndpointsNetworkEndpointGroupsPage> {

    private ListNetworkEndpointsNetworkEndpointGroupsPage(
        PageContext<
                ListNetworkEndpointsNetworkEndpointGroupsHttpRequest,
                NetworkEndpointGroupsListNetworkEndpoints,
                NetworkEndpointWithHealthStatus>
            context,
        NetworkEndpointGroupsListNetworkEndpoints response) {
      super(context, response);
    }

    private static ListNetworkEndpointsNetworkEndpointGroupsPage createEmptyPage() {
      return new ListNetworkEndpointsNetworkEndpointGroupsPage(null, null);
    }

    @Override
    protected ListNetworkEndpointsNetworkEndpointGroupsPage createPage(
        PageContext<
                ListNetworkEndpointsNetworkEndpointGroupsHttpRequest,
                NetworkEndpointGroupsListNetworkEndpoints,
                NetworkEndpointWithHealthStatus>
            context,
        NetworkEndpointGroupsListNetworkEndpoints response) {
      return new ListNetworkEndpointsNetworkEndpointGroupsPage(context, response);
    }

    @Override
    public ApiFuture<ListNetworkEndpointsNetworkEndpointGroupsPage> createPageAsync(
        PageContext<
                ListNetworkEndpointsNetworkEndpointGroupsHttpRequest,
                NetworkEndpointGroupsListNetworkEndpoints,
                NetworkEndpointWithHealthStatus>
            context,
        ApiFuture<NetworkEndpointGroupsListNetworkEndpoints> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListNetworkEndpointsNetworkEndpointGroupsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListNetworkEndpointsNetworkEndpointGroupsHttpRequest,
          NetworkEndpointGroupsListNetworkEndpoints,
          NetworkEndpointWithHealthStatus,
          ListNetworkEndpointsNetworkEndpointGroupsPage,
          ListNetworkEndpointsNetworkEndpointGroupsFixedSizeCollection> {

    private ListNetworkEndpointsNetworkEndpointGroupsFixedSizeCollection(
        List<ListNetworkEndpointsNetworkEndpointGroupsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListNetworkEndpointsNetworkEndpointGroupsFixedSizeCollection
        createEmptyCollection() {
      return new ListNetworkEndpointsNetworkEndpointGroupsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListNetworkEndpointsNetworkEndpointGroupsFixedSizeCollection createCollection(
        List<ListNetworkEndpointsNetworkEndpointGroupsPage> pages, int collectionSize) {
      return new ListNetworkEndpointsNetworkEndpointGroupsFixedSizeCollection(
          pages, collectionSize);
    }
  }
}
