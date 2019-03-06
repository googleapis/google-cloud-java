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
import com.google.cloud.compute.v1.stub.NetworkStub;
import com.google.cloud.compute.v1.stub.NetworkStubSettings;
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
 * try (NetworkClient networkClient = NetworkClient.create()) {
 *   ProjectGlobalNetworkName network = ProjectGlobalNetworkName.of("[PROJECT]", "[NETWORK]");
 *   NetworksAddPeeringRequest networksAddPeeringRequestResource = NetworksAddPeeringRequest.newBuilder().build();
 *   Operation response = networkClient.addPeeringNetwork(network, networksAddPeeringRequestResource);
 * }
 * </code>
 * </pre>
 *
 * <p>Note: close() needs to be called on the networkClient object to clean up resources such as
 * threads. In the example above, try-with-resources is used, which automatically calls close().
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
 * <p>This class can be customized by passing in a custom instance of NetworkSettings to create().
 * For example:
 *
 * <p>To customize credentials:
 *
 * <pre>
 * <code>
 * NetworkSettings networkSettings =
 *     NetworkSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * NetworkClient networkClient =
 *     NetworkClient.create(networkSettings);
 * </code>
 * </pre>
 *
 * To customize the endpoint:
 *
 * <pre>
 * <code>
 * NetworkSettings networkSettings =
 *     NetworkSettings.newBuilder().setEndpoint(myEndpoint).build();
 * NetworkClient networkClient =
 *     NetworkClient.create(networkSettings);
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class NetworkClient implements BackgroundResource {
  private final NetworkSettings settings;
  private final NetworkStub stub;

  /** Constructs an instance of NetworkClient with default settings. */
  public static final NetworkClient create() throws IOException {
    return create(NetworkSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of NetworkClient, using the given settings. The channels are created
   * based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final NetworkClient create(NetworkSettings settings) throws IOException {
    return new NetworkClient(settings);
  }

  /**
   * Constructs an instance of NetworkClient, using the given stub for making calls. This is for
   * advanced usage - prefer to use NetworkSettings}.
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final NetworkClient create(NetworkStub stub) {
    return new NetworkClient(stub);
  }

  /**
   * Constructs an instance of NetworkClient, using the given settings. This is protected so that it
   * is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected NetworkClient(NetworkSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((NetworkStubSettings) settings.getStubSettings()).createStub();
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected NetworkClient(NetworkStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final NetworkSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public NetworkStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Adds a peering to the specified network.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NetworkClient networkClient = NetworkClient.create()) {
   *   ProjectGlobalNetworkName network = ProjectGlobalNetworkName.of("[PROJECT]", "[NETWORK]");
   *   NetworksAddPeeringRequest networksAddPeeringRequestResource = NetworksAddPeeringRequest.newBuilder().build();
   *   Operation response = networkClient.addPeeringNetwork(network, networksAddPeeringRequestResource);
   * }
   * </code></pre>
   *
   * @param network Name of the network resource to add peering to.
   * @param networksAddPeeringRequestResource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation addPeeringNetwork(
      ProjectGlobalNetworkName network,
      NetworksAddPeeringRequest networksAddPeeringRequestResource) {

    AddPeeringNetworkHttpRequest request =
        AddPeeringNetworkHttpRequest.newBuilder()
            .setNetwork(network == null ? null : network.toString())
            .setNetworksAddPeeringRequestResource(networksAddPeeringRequestResource)
            .build();
    return addPeeringNetwork(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Adds a peering to the specified network.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NetworkClient networkClient = NetworkClient.create()) {
   *   ProjectGlobalNetworkName network = ProjectGlobalNetworkName.of("[PROJECT]", "[NETWORK]");
   *   NetworksAddPeeringRequest networksAddPeeringRequestResource = NetworksAddPeeringRequest.newBuilder().build();
   *   Operation response = networkClient.addPeeringNetwork(network.toString(), networksAddPeeringRequestResource);
   * }
   * </code></pre>
   *
   * @param network Name of the network resource to add peering to.
   * @param networksAddPeeringRequestResource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation addPeeringNetwork(
      String network, NetworksAddPeeringRequest networksAddPeeringRequestResource) {

    AddPeeringNetworkHttpRequest request =
        AddPeeringNetworkHttpRequest.newBuilder()
            .setNetwork(network)
            .setNetworksAddPeeringRequestResource(networksAddPeeringRequestResource)
            .build();
    return addPeeringNetwork(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Adds a peering to the specified network.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NetworkClient networkClient = NetworkClient.create()) {
   *   ProjectGlobalNetworkName network = ProjectGlobalNetworkName.of("[PROJECT]", "[NETWORK]");
   *   NetworksAddPeeringRequest networksAddPeeringRequestResource = NetworksAddPeeringRequest.newBuilder().build();
   *   AddPeeringNetworkHttpRequest request = AddPeeringNetworkHttpRequest.newBuilder()
   *     .setNetwork(network.toString())
   *     .setNetworksAddPeeringRequestResource(networksAddPeeringRequestResource)
   *     .build();
   *   Operation response = networkClient.addPeeringNetwork(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation addPeeringNetwork(AddPeeringNetworkHttpRequest request) {
    return addPeeringNetworkCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Adds a peering to the specified network.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NetworkClient networkClient = NetworkClient.create()) {
   *   ProjectGlobalNetworkName network = ProjectGlobalNetworkName.of("[PROJECT]", "[NETWORK]");
   *   NetworksAddPeeringRequest networksAddPeeringRequestResource = NetworksAddPeeringRequest.newBuilder().build();
   *   AddPeeringNetworkHttpRequest request = AddPeeringNetworkHttpRequest.newBuilder()
   *     .setNetwork(network.toString())
   *     .setNetworksAddPeeringRequestResource(networksAddPeeringRequestResource)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = networkClient.addPeeringNetworkCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<AddPeeringNetworkHttpRequest, Operation> addPeeringNetworkCallable() {
    return stub.addPeeringNetworkCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified network.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NetworkClient networkClient = NetworkClient.create()) {
   *   ProjectGlobalNetworkName network = ProjectGlobalNetworkName.of("[PROJECT]", "[NETWORK]");
   *   Operation response = networkClient.deleteNetwork(network);
   * }
   * </code></pre>
   *
   * @param network Name of the network to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation deleteNetwork(ProjectGlobalNetworkName network) {

    DeleteNetworkHttpRequest request =
        DeleteNetworkHttpRequest.newBuilder()
            .setNetwork(network == null ? null : network.toString())
            .build();
    return deleteNetwork(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified network.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NetworkClient networkClient = NetworkClient.create()) {
   *   ProjectGlobalNetworkName network = ProjectGlobalNetworkName.of("[PROJECT]", "[NETWORK]");
   *   Operation response = networkClient.deleteNetwork(network.toString());
   * }
   * </code></pre>
   *
   * @param network Name of the network to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation deleteNetwork(String network) {

    DeleteNetworkHttpRequest request =
        DeleteNetworkHttpRequest.newBuilder().setNetwork(network).build();
    return deleteNetwork(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified network.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NetworkClient networkClient = NetworkClient.create()) {
   *   ProjectGlobalNetworkName network = ProjectGlobalNetworkName.of("[PROJECT]", "[NETWORK]");
   *   DeleteNetworkHttpRequest request = DeleteNetworkHttpRequest.newBuilder()
   *     .setNetwork(network.toString())
   *     .build();
   *   Operation response = networkClient.deleteNetwork(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation deleteNetwork(DeleteNetworkHttpRequest request) {
    return deleteNetworkCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified network.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NetworkClient networkClient = NetworkClient.create()) {
   *   ProjectGlobalNetworkName network = ProjectGlobalNetworkName.of("[PROJECT]", "[NETWORK]");
   *   DeleteNetworkHttpRequest request = DeleteNetworkHttpRequest.newBuilder()
   *     .setNetwork(network.toString())
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = networkClient.deleteNetworkCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<DeleteNetworkHttpRequest, Operation> deleteNetworkCallable() {
    return stub.deleteNetworkCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified network. Gets a list of available networks by making a list() request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NetworkClient networkClient = NetworkClient.create()) {
   *   ProjectGlobalNetworkName network = ProjectGlobalNetworkName.of("[PROJECT]", "[NETWORK]");
   *   Network response = networkClient.getNetwork(network);
   * }
   * </code></pre>
   *
   * @param network Name of the network to return.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Network getNetwork(ProjectGlobalNetworkName network) {

    GetNetworkHttpRequest request =
        GetNetworkHttpRequest.newBuilder()
            .setNetwork(network == null ? null : network.toString())
            .build();
    return getNetwork(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified network. Gets a list of available networks by making a list() request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NetworkClient networkClient = NetworkClient.create()) {
   *   ProjectGlobalNetworkName network = ProjectGlobalNetworkName.of("[PROJECT]", "[NETWORK]");
   *   Network response = networkClient.getNetwork(network.toString());
   * }
   * </code></pre>
   *
   * @param network Name of the network to return.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Network getNetwork(String network) {

    GetNetworkHttpRequest request = GetNetworkHttpRequest.newBuilder().setNetwork(network).build();
    return getNetwork(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified network. Gets a list of available networks by making a list() request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NetworkClient networkClient = NetworkClient.create()) {
   *   ProjectGlobalNetworkName network = ProjectGlobalNetworkName.of("[PROJECT]", "[NETWORK]");
   *   GetNetworkHttpRequest request = GetNetworkHttpRequest.newBuilder()
   *     .setNetwork(network.toString())
   *     .build();
   *   Network response = networkClient.getNetwork(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Network getNetwork(GetNetworkHttpRequest request) {
    return getNetworkCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified network. Gets a list of available networks by making a list() request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NetworkClient networkClient = NetworkClient.create()) {
   *   ProjectGlobalNetworkName network = ProjectGlobalNetworkName.of("[PROJECT]", "[NETWORK]");
   *   GetNetworkHttpRequest request = GetNetworkHttpRequest.newBuilder()
   *     .setNetwork(network.toString())
   *     .build();
   *   ApiFuture&lt;Network&gt; future = networkClient.getNetworkCallable().futureCall(request);
   *   // Do something
   *   Network response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<GetNetworkHttpRequest, Network> getNetworkCallable() {
    return stub.getNetworkCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a network in the specified project using the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NetworkClient networkClient = NetworkClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   Network networkResource = Network.newBuilder().build();
   *   Operation response = networkClient.insertNetwork(project, networkResource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param networkResource Represents a Network resource. Read Virtual Private Cloud (VPC) Network
   *     Overview for more information. (== resource_for v1.networks ==) (== resource_for
   *     beta.networks ==)
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation insertNetwork(ProjectName project, Network networkResource) {

    InsertNetworkHttpRequest request =
        InsertNetworkHttpRequest.newBuilder()
            .setProject(project == null ? null : project.toString())
            .setNetworkResource(networkResource)
            .build();
    return insertNetwork(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a network in the specified project using the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NetworkClient networkClient = NetworkClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   Network networkResource = Network.newBuilder().build();
   *   Operation response = networkClient.insertNetwork(project.toString(), networkResource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param networkResource Represents a Network resource. Read Virtual Private Cloud (VPC) Network
   *     Overview for more information. (== resource_for v1.networks ==) (== resource_for
   *     beta.networks ==)
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation insertNetwork(String project, Network networkResource) {

    InsertNetworkHttpRequest request =
        InsertNetworkHttpRequest.newBuilder()
            .setProject(project)
            .setNetworkResource(networkResource)
            .build();
    return insertNetwork(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a network in the specified project using the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NetworkClient networkClient = NetworkClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   Network networkResource = Network.newBuilder().build();
   *   InsertNetworkHttpRequest request = InsertNetworkHttpRequest.newBuilder()
   *     .setProject(project.toString())
   *     .setNetworkResource(networkResource)
   *     .build();
   *   Operation response = networkClient.insertNetwork(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation insertNetwork(InsertNetworkHttpRequest request) {
    return insertNetworkCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a network in the specified project using the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NetworkClient networkClient = NetworkClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   Network networkResource = Network.newBuilder().build();
   *   InsertNetworkHttpRequest request = InsertNetworkHttpRequest.newBuilder()
   *     .setProject(project.toString())
   *     .setNetworkResource(networkResource)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = networkClient.insertNetworkCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<InsertNetworkHttpRequest, Operation> insertNetworkCallable() {
    return stub.insertNetworkCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of networks available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NetworkClient networkClient = NetworkClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   for (Network element : networkClient.listNetworks(project).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListNetworksPagedResponse listNetworks(ProjectName project) {
    ListNetworksHttpRequest request =
        ListNetworksHttpRequest.newBuilder()
            .setProject(project == null ? null : project.toString())
            .build();
    return listNetworks(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of networks available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NetworkClient networkClient = NetworkClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   for (Network element : networkClient.listNetworks(project.toString()).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListNetworksPagedResponse listNetworks(String project) {
    ListNetworksHttpRequest request =
        ListNetworksHttpRequest.newBuilder().setProject(project).build();
    return listNetworks(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of networks available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NetworkClient networkClient = NetworkClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   ListNetworksHttpRequest request = ListNetworksHttpRequest.newBuilder()
   *     .setProject(project.toString())
   *     .build();
   *   for (Network element : networkClient.listNetworks(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListNetworksPagedResponse listNetworks(ListNetworksHttpRequest request) {
    return listNetworksPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of networks available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NetworkClient networkClient = NetworkClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   ListNetworksHttpRequest request = ListNetworksHttpRequest.newBuilder()
   *     .setProject(project.toString())
   *     .build();
   *   ApiFuture&lt;ListNetworksPagedResponse&gt; future = networkClient.listNetworksPagedCallable().futureCall(request);
   *   // Do something
   *   for (Network element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<ListNetworksHttpRequest, ListNetworksPagedResponse>
      listNetworksPagedCallable() {
    return stub.listNetworksPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of networks available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NetworkClient networkClient = NetworkClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   ListNetworksHttpRequest request = ListNetworksHttpRequest.newBuilder()
   *     .setProject(project.toString())
   *     .build();
   *   while (true) {
   *     NetworkList response = networkClient.listNetworksCallable().call(request);
   *     for (Network element : response.getItemsList()) {
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
  public final UnaryCallable<ListNetworksHttpRequest, NetworkList> listNetworksCallable() {
    return stub.listNetworksCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Patches the specified network with the data included in the request. Only the following fields
   * can be modified: routingConfig.routingMode.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NetworkClient networkClient = NetworkClient.create()) {
   *   ProjectGlobalNetworkName network = ProjectGlobalNetworkName.of("[PROJECT]", "[NETWORK]");
   *   Network networkResource = Network.newBuilder().build();
   *   List&lt;String&gt; fieldMask = new ArrayList&lt;&gt;();
   *   Operation response = networkClient.patchNetwork(network, networkResource, fieldMask);
   * }
   * </code></pre>
   *
   * @param network Name of the network to update.
   * @param networkResource Represents a Network resource. Read Virtual Private Cloud (VPC) Network
   *     Overview for more information. (== resource_for v1.networks ==) (== resource_for
   *     beta.networks ==)
   * @param fieldMask The fields that should be serialized (even if they have empty values). If the
   *     containing message object has a non-null fieldmask, then all the fields in the field mask
   *     (and only those fields in the field mask) will be serialized. If the containing object does
   *     not have a fieldmask, then only non-empty fields will be serialized.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation patchNetwork(
      ProjectGlobalNetworkName network, Network networkResource, List<String> fieldMask) {

    PatchNetworkHttpRequest request =
        PatchNetworkHttpRequest.newBuilder()
            .setNetwork(network == null ? null : network.toString())
            .setNetworkResource(networkResource)
            .addAllFieldMask(fieldMask)
            .build();
    return patchNetwork(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Patches the specified network with the data included in the request. Only the following fields
   * can be modified: routingConfig.routingMode.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NetworkClient networkClient = NetworkClient.create()) {
   *   ProjectGlobalNetworkName network = ProjectGlobalNetworkName.of("[PROJECT]", "[NETWORK]");
   *   Network networkResource = Network.newBuilder().build();
   *   List&lt;String&gt; fieldMask = new ArrayList&lt;&gt;();
   *   Operation response = networkClient.patchNetwork(network.toString(), networkResource, fieldMask);
   * }
   * </code></pre>
   *
   * @param network Name of the network to update.
   * @param networkResource Represents a Network resource. Read Virtual Private Cloud (VPC) Network
   *     Overview for more information. (== resource_for v1.networks ==) (== resource_for
   *     beta.networks ==)
   * @param fieldMask The fields that should be serialized (even if they have empty values). If the
   *     containing message object has a non-null fieldmask, then all the fields in the field mask
   *     (and only those fields in the field mask) will be serialized. If the containing object does
   *     not have a fieldmask, then only non-empty fields will be serialized.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation patchNetwork(
      String network, Network networkResource, List<String> fieldMask) {

    PatchNetworkHttpRequest request =
        PatchNetworkHttpRequest.newBuilder()
            .setNetwork(network)
            .setNetworkResource(networkResource)
            .addAllFieldMask(fieldMask)
            .build();
    return patchNetwork(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Patches the specified network with the data included in the request. Only the following fields
   * can be modified: routingConfig.routingMode.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NetworkClient networkClient = NetworkClient.create()) {
   *   ProjectGlobalNetworkName network = ProjectGlobalNetworkName.of("[PROJECT]", "[NETWORK]");
   *   Network networkResource = Network.newBuilder().build();
   *   List&lt;String&gt; fieldMask = new ArrayList&lt;&gt;();
   *   PatchNetworkHttpRequest request = PatchNetworkHttpRequest.newBuilder()
   *     .setNetwork(network.toString())
   *     .setNetworkResource(networkResource)
   *     .addAllFieldMask(fieldMask)
   *     .build();
   *   Operation response = networkClient.patchNetwork(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation patchNetwork(PatchNetworkHttpRequest request) {
    return patchNetworkCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Patches the specified network with the data included in the request. Only the following fields
   * can be modified: routingConfig.routingMode.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NetworkClient networkClient = NetworkClient.create()) {
   *   ProjectGlobalNetworkName network = ProjectGlobalNetworkName.of("[PROJECT]", "[NETWORK]");
   *   Network networkResource = Network.newBuilder().build();
   *   List&lt;String&gt; fieldMask = new ArrayList&lt;&gt;();
   *   PatchNetworkHttpRequest request = PatchNetworkHttpRequest.newBuilder()
   *     .setNetwork(network.toString())
   *     .setNetworkResource(networkResource)
   *     .addAllFieldMask(fieldMask)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = networkClient.patchNetworkCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<PatchNetworkHttpRequest, Operation> patchNetworkCallable() {
    return stub.patchNetworkCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Removes a peering from the specified network.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NetworkClient networkClient = NetworkClient.create()) {
   *   ProjectGlobalNetworkName network = ProjectGlobalNetworkName.of("[PROJECT]", "[NETWORK]");
   *   NetworksRemovePeeringRequest networksRemovePeeringRequestResource = NetworksRemovePeeringRequest.newBuilder().build();
   *   Operation response = networkClient.removePeeringNetwork(network, networksRemovePeeringRequestResource);
   * }
   * </code></pre>
   *
   * @param network Name of the network resource to remove peering from.
   * @param networksRemovePeeringRequestResource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation removePeeringNetwork(
      ProjectGlobalNetworkName network,
      NetworksRemovePeeringRequest networksRemovePeeringRequestResource) {

    RemovePeeringNetworkHttpRequest request =
        RemovePeeringNetworkHttpRequest.newBuilder()
            .setNetwork(network == null ? null : network.toString())
            .setNetworksRemovePeeringRequestResource(networksRemovePeeringRequestResource)
            .build();
    return removePeeringNetwork(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Removes a peering from the specified network.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NetworkClient networkClient = NetworkClient.create()) {
   *   ProjectGlobalNetworkName network = ProjectGlobalNetworkName.of("[PROJECT]", "[NETWORK]");
   *   NetworksRemovePeeringRequest networksRemovePeeringRequestResource = NetworksRemovePeeringRequest.newBuilder().build();
   *   Operation response = networkClient.removePeeringNetwork(network.toString(), networksRemovePeeringRequestResource);
   * }
   * </code></pre>
   *
   * @param network Name of the network resource to remove peering from.
   * @param networksRemovePeeringRequestResource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation removePeeringNetwork(
      String network, NetworksRemovePeeringRequest networksRemovePeeringRequestResource) {

    RemovePeeringNetworkHttpRequest request =
        RemovePeeringNetworkHttpRequest.newBuilder()
            .setNetwork(network)
            .setNetworksRemovePeeringRequestResource(networksRemovePeeringRequestResource)
            .build();
    return removePeeringNetwork(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Removes a peering from the specified network.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NetworkClient networkClient = NetworkClient.create()) {
   *   ProjectGlobalNetworkName network = ProjectGlobalNetworkName.of("[PROJECT]", "[NETWORK]");
   *   NetworksRemovePeeringRequest networksRemovePeeringRequestResource = NetworksRemovePeeringRequest.newBuilder().build();
   *   RemovePeeringNetworkHttpRequest request = RemovePeeringNetworkHttpRequest.newBuilder()
   *     .setNetwork(network.toString())
   *     .setNetworksRemovePeeringRequestResource(networksRemovePeeringRequestResource)
   *     .build();
   *   Operation response = networkClient.removePeeringNetwork(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation removePeeringNetwork(RemovePeeringNetworkHttpRequest request) {
    return removePeeringNetworkCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Removes a peering from the specified network.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NetworkClient networkClient = NetworkClient.create()) {
   *   ProjectGlobalNetworkName network = ProjectGlobalNetworkName.of("[PROJECT]", "[NETWORK]");
   *   NetworksRemovePeeringRequest networksRemovePeeringRequestResource = NetworksRemovePeeringRequest.newBuilder().build();
   *   RemovePeeringNetworkHttpRequest request = RemovePeeringNetworkHttpRequest.newBuilder()
   *     .setNetwork(network.toString())
   *     .setNetworksRemovePeeringRequestResource(networksRemovePeeringRequestResource)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = networkClient.removePeeringNetworkCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<RemovePeeringNetworkHttpRequest, Operation>
      removePeeringNetworkCallable() {
    return stub.removePeeringNetworkCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Switches the network mode from auto subnet mode to custom subnet mode.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NetworkClient networkClient = NetworkClient.create()) {
   *   ProjectGlobalNetworkName network = ProjectGlobalNetworkName.of("[PROJECT]", "[NETWORK]");
   *   Operation response = networkClient.switchToCustomModeNetwork(network);
   * }
   * </code></pre>
   *
   * @param network Name of the network to be updated.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation switchToCustomModeNetwork(ProjectGlobalNetworkName network) {

    SwitchToCustomModeNetworkHttpRequest request =
        SwitchToCustomModeNetworkHttpRequest.newBuilder()
            .setNetwork(network == null ? null : network.toString())
            .build();
    return switchToCustomModeNetwork(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Switches the network mode from auto subnet mode to custom subnet mode.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NetworkClient networkClient = NetworkClient.create()) {
   *   ProjectGlobalNetworkName network = ProjectGlobalNetworkName.of("[PROJECT]", "[NETWORK]");
   *   Operation response = networkClient.switchToCustomModeNetwork(network.toString());
   * }
   * </code></pre>
   *
   * @param network Name of the network to be updated.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation switchToCustomModeNetwork(String network) {

    SwitchToCustomModeNetworkHttpRequest request =
        SwitchToCustomModeNetworkHttpRequest.newBuilder().setNetwork(network).build();
    return switchToCustomModeNetwork(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Switches the network mode from auto subnet mode to custom subnet mode.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NetworkClient networkClient = NetworkClient.create()) {
   *   ProjectGlobalNetworkName network = ProjectGlobalNetworkName.of("[PROJECT]", "[NETWORK]");
   *   SwitchToCustomModeNetworkHttpRequest request = SwitchToCustomModeNetworkHttpRequest.newBuilder()
   *     .setNetwork(network.toString())
   *     .build();
   *   Operation response = networkClient.switchToCustomModeNetwork(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation switchToCustomModeNetwork(SwitchToCustomModeNetworkHttpRequest request) {
    return switchToCustomModeNetworkCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Switches the network mode from auto subnet mode to custom subnet mode.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NetworkClient networkClient = NetworkClient.create()) {
   *   ProjectGlobalNetworkName network = ProjectGlobalNetworkName.of("[PROJECT]", "[NETWORK]");
   *   SwitchToCustomModeNetworkHttpRequest request = SwitchToCustomModeNetworkHttpRequest.newBuilder()
   *     .setNetwork(network.toString())
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = networkClient.switchToCustomModeNetworkCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<SwitchToCustomModeNetworkHttpRequest, Operation>
      switchToCustomModeNetworkCallable() {
    return stub.switchToCustomModeNetworkCallable();
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

  public static class ListNetworksPagedResponse
      extends AbstractPagedListResponse<
          ListNetworksHttpRequest,
          NetworkList,
          Network,
          ListNetworksPage,
          ListNetworksFixedSizeCollection> {

    public static ApiFuture<ListNetworksPagedResponse> createAsync(
        PageContext<ListNetworksHttpRequest, NetworkList, Network> context,
        ApiFuture<NetworkList> futureResponse) {
      ApiFuture<ListNetworksPage> futurePage =
          ListNetworksPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListNetworksPage, ListNetworksPagedResponse>() {
            @Override
            public ListNetworksPagedResponse apply(ListNetworksPage input) {
              return new ListNetworksPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
    }

    private ListNetworksPagedResponse(ListNetworksPage page) {
      super(page, ListNetworksFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListNetworksPage
      extends AbstractPage<ListNetworksHttpRequest, NetworkList, Network, ListNetworksPage> {

    private ListNetworksPage(
        PageContext<ListNetworksHttpRequest, NetworkList, Network> context, NetworkList response) {
      super(context, response);
    }

    private static ListNetworksPage createEmptyPage() {
      return new ListNetworksPage(null, null);
    }

    @Override
    protected ListNetworksPage createPage(
        PageContext<ListNetworksHttpRequest, NetworkList, Network> context, NetworkList response) {
      return new ListNetworksPage(context, response);
    }

    @Override
    public ApiFuture<ListNetworksPage> createPageAsync(
        PageContext<ListNetworksHttpRequest, NetworkList, Network> context,
        ApiFuture<NetworkList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListNetworksFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListNetworksHttpRequest,
          NetworkList,
          Network,
          ListNetworksPage,
          ListNetworksFixedSizeCollection> {

    private ListNetworksFixedSizeCollection(List<ListNetworksPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListNetworksFixedSizeCollection createEmptyCollection() {
      return new ListNetworksFixedSizeCollection(null, 0);
    }

    @Override
    protected ListNetworksFixedSizeCollection createCollection(
        List<ListNetworksPage> pages, int collectionSize) {
      return new ListNetworksFixedSizeCollection(pages, collectionSize);
    }
  }
}
