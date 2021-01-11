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
import com.google.cloud.compute.v1.stub.NetworksStub;
import com.google.cloud.compute.v1.stub.NetworksStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND SERVICE
/**
 * Service Description: The Networks API.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>
 * <code>
 * try (NetworksClient networksClient = NetworksClient.create()) {
 *   String project = "";
 *   String network = "";
 *   NetworksAddPeeringRequest networksAddPeeringRequestResource = NetworksAddPeeringRequest.newBuilder().build();
 *   Operation response = networksClient.addPeering(project, network, networksAddPeeringRequestResource);
 * }
 * </code>
 * </pre>
 *
 * <p>Note: close() needs to be called on the networksClient object to clean up resources such as
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
 * <p>This class can be customized by passing in a custom instance of NetworksSettings to create().
 * For example:
 *
 * <p>To customize credentials:
 *
 * <pre>
 * <code>
 * NetworksSettings networksSettings =
 *     NetworksSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * NetworksClient networksClient =
 *     NetworksClient.create(networksSettings);
 * </code>
 * </pre>
 *
 * To customize the endpoint:
 *
 * <pre>
 * <code>
 * NetworksSettings networksSettings =
 *     NetworksSettings.newBuilder().setEndpoint(myEndpoint).build();
 * NetworksClient networksClient =
 *     NetworksClient.create(networksSettings);
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class NetworksClient implements BackgroundResource {
  private final NetworksSettings settings;
  private final NetworksStub stub;

  /** Constructs an instance of NetworksClient with default settings. */
  public static final NetworksClient create() throws IOException {
    return create(NetworksSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of NetworksClient, using the given settings. The channels are created
   * based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final NetworksClient create(NetworksSettings settings) throws IOException {
    return new NetworksClient(settings);
  }

  /**
   * Constructs an instance of NetworksClient, using the given stub for making calls. This is for
   * advanced usage - prefer to use NetworksSettings}.
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final NetworksClient create(NetworksStub stub) {
    return new NetworksClient(stub);
  }

  /**
   * Constructs an instance of NetworksClient, using the given settings. This is protected so that
   * it is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected NetworksClient(NetworksSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((NetworksStubSettings) settings.getStubSettings()).createStub();
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected NetworksClient(NetworksStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final NetworksSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public NetworksStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Adds a peering to the specified network.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NetworksClient networksClient = NetworksClient.create()) {
   *   String project = "";
   *   String network = "";
   *   NetworksAddPeeringRequest networksAddPeeringRequestResource = NetworksAddPeeringRequest.newBuilder().build();
   *   Operation response = networksClient.addPeering(project, network, networksAddPeeringRequestResource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param network Name of the network resource to add peering to.
   * @param networksAddPeeringRequestResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation addPeering(
      String project, String network, NetworksAddPeeringRequest networksAddPeeringRequestResource) {
    AddPeeringNetworkRequest request =
        AddPeeringNetworkRequest.newBuilder()
            .setProject(project)
            .setNetwork(network)
            .setNetworksAddPeeringRequestResource(networksAddPeeringRequestResource)
            .build();
    return addPeering(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Adds a peering to the specified network.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NetworksClient networksClient = NetworksClient.create()) {
   *   String network = "";
   *   NetworksAddPeeringRequest networksAddPeeringRequestResource = NetworksAddPeeringRequest.newBuilder().build();
   *   String project = "";
   *   AddPeeringNetworkRequest request = AddPeeringNetworkRequest.newBuilder()
   *     .setNetwork(network)
   *     .setNetworksAddPeeringRequestResource(networksAddPeeringRequestResource)
   *     .setProject(project)
   *     .build();
   *   Operation response = networksClient.addPeering(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation addPeering(AddPeeringNetworkRequest request) {
    return addPeeringCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Adds a peering to the specified network.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NetworksClient networksClient = NetworksClient.create()) {
   *   String network = "";
   *   NetworksAddPeeringRequest networksAddPeeringRequestResource = NetworksAddPeeringRequest.newBuilder().build();
   *   String project = "";
   *   AddPeeringNetworkRequest request = AddPeeringNetworkRequest.newBuilder()
   *     .setNetwork(network)
   *     .setNetworksAddPeeringRequestResource(networksAddPeeringRequestResource)
   *     .setProject(project)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = networksClient.addPeeringCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<AddPeeringNetworkRequest, Operation> addPeeringCallable() {
    return stub.addPeeringCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified network.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NetworksClient networksClient = NetworksClient.create()) {
   *   String project = "";
   *   String network = "";
   *   Operation response = networksClient.delete(project, network);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param network Name of the network to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation delete(String project, String network) {
    DeleteNetworkRequest request =
        DeleteNetworkRequest.newBuilder().setProject(project).setNetwork(network).build();
    return delete(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified network.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NetworksClient networksClient = NetworksClient.create()) {
   *   String network = "";
   *   String project = "";
   *   DeleteNetworkRequest request = DeleteNetworkRequest.newBuilder()
   *     .setNetwork(network)
   *     .setProject(project)
   *     .build();
   *   Operation response = networksClient.delete(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation delete(DeleteNetworkRequest request) {
    return deleteCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified network.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NetworksClient networksClient = NetworksClient.create()) {
   *   String network = "";
   *   String project = "";
   *   DeleteNetworkRequest request = DeleteNetworkRequest.newBuilder()
   *     .setNetwork(network)
   *     .setProject(project)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = networksClient.deleteCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<DeleteNetworkRequest, Operation> deleteCallable() {
    return stub.deleteCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified network. Gets a list of available networks by making a list() request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NetworksClient networksClient = NetworksClient.create()) {
   *   String project = "";
   *   String network = "";
   *   Network response = networksClient.get(project, network);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param network Name of the network to return.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Network get(String project, String network) {
    GetNetworkRequest request =
        GetNetworkRequest.newBuilder().setProject(project).setNetwork(network).build();
    return get(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified network. Gets a list of available networks by making a list() request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NetworksClient networksClient = NetworksClient.create()) {
   *   String network = "";
   *   String project = "";
   *   GetNetworkRequest request = GetNetworkRequest.newBuilder()
   *     .setNetwork(network)
   *     .setProject(project)
   *     .build();
   *   Network response = networksClient.get(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Network get(GetNetworkRequest request) {
    return getCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified network. Gets a list of available networks by making a list() request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NetworksClient networksClient = NetworksClient.create()) {
   *   String network = "";
   *   String project = "";
   *   GetNetworkRequest request = GetNetworkRequest.newBuilder()
   *     .setNetwork(network)
   *     .setProject(project)
   *     .build();
   *   ApiFuture&lt;Network&gt; future = networksClient.getCallable().futureCall(request);
   *   // Do something
   *   Network response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<GetNetworkRequest, Network> getCallable() {
    return stub.getCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a network in the specified project using the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NetworksClient networksClient = NetworksClient.create()) {
   *   String project = "";
   *   Network networkResource = Network.newBuilder().build();
   *   Operation response = networksClient.insert(project, networkResource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param networkResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation insert(String project, Network networkResource) {
    InsertNetworkRequest request =
        InsertNetworkRequest.newBuilder()
            .setProject(project)
            .setNetworkResource(networkResource)
            .build();
    return insert(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a network in the specified project using the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NetworksClient networksClient = NetworksClient.create()) {
   *   Network networkResource = Network.newBuilder().build();
   *   String project = "";
   *   InsertNetworkRequest request = InsertNetworkRequest.newBuilder()
   *     .setNetworkResource(networkResource)
   *     .setProject(project)
   *     .build();
   *   Operation response = networksClient.insert(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation insert(InsertNetworkRequest request) {
    return insertCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a network in the specified project using the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NetworksClient networksClient = NetworksClient.create()) {
   *   Network networkResource = Network.newBuilder().build();
   *   String project = "";
   *   InsertNetworkRequest request = InsertNetworkRequest.newBuilder()
   *     .setNetworkResource(networkResource)
   *     .setProject(project)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = networksClient.insertCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<InsertNetworkRequest, Operation> insertCallable() {
    return stub.insertCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of networks available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NetworksClient networksClient = NetworksClient.create()) {
   *   String project = "";
   *   for (Network element : networksClient.list(project).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPagedResponse list(String project) {
    ListNetworksRequest request = ListNetworksRequest.newBuilder().setProject(project).build();
    return list(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of networks available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NetworksClient networksClient = NetworksClient.create()) {
   *   String project = "";
   *   ListNetworksRequest request = ListNetworksRequest.newBuilder()
   *     .setProject(project)
   *     .build();
   *   for (Network element : networksClient.list(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPagedResponse list(ListNetworksRequest request) {
    return listPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of networks available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NetworksClient networksClient = NetworksClient.create()) {
   *   String project = "";
   *   ListNetworksRequest request = ListNetworksRequest.newBuilder()
   *     .setProject(project)
   *     .build();
   *   ApiFuture&lt;ListPagedResponse&gt; future = networksClient.listPagedCallable().futureCall(request);
   *   // Do something
   *   for (Network element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  public final UnaryCallable<ListNetworksRequest, ListPagedResponse> listPagedCallable() {
    return stub.listPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of networks available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NetworksClient networksClient = NetworksClient.create()) {
   *   String project = "";
   *   ListNetworksRequest request = ListNetworksRequest.newBuilder()
   *     .setProject(project)
   *     .build();
   *   while (true) {
   *     NetworkList response = networksClient.listCallable().call(request);
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
  public final UnaryCallable<ListNetworksRequest, NetworkList> listCallable() {
    return stub.listCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists the peering routes exchanged over peering connection.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NetworksClient networksClient = NetworksClient.create()) {
   *   String project = "";
   *   String network = "";
   *   for (ExchangedPeeringRoute element : networksClient.listPeeringRoutes(project, network).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param network Name of the network for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPeeringRoutesPagedResponse listPeeringRoutes(String project, String network) {
    ListPeeringRoutesNetworksRequest request =
        ListPeeringRoutesNetworksRequest.newBuilder()
            .setProject(project)
            .setNetwork(network)
            .build();
    return listPeeringRoutes(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists the peering routes exchanged over peering connection.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NetworksClient networksClient = NetworksClient.create()) {
   *   String network = "";
   *   String project = "";
   *   ListPeeringRoutesNetworksRequest request = ListPeeringRoutesNetworksRequest.newBuilder()
   *     .setNetwork(network)
   *     .setProject(project)
   *     .build();
   *   for (ExchangedPeeringRoute element : networksClient.listPeeringRoutes(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPeeringRoutesPagedResponse listPeeringRoutes(
      ListPeeringRoutesNetworksRequest request) {
    return listPeeringRoutesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists the peering routes exchanged over peering connection.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NetworksClient networksClient = NetworksClient.create()) {
   *   String network = "";
   *   String project = "";
   *   ListPeeringRoutesNetworksRequest request = ListPeeringRoutesNetworksRequest.newBuilder()
   *     .setNetwork(network)
   *     .setProject(project)
   *     .build();
   *   ApiFuture&lt;ListPeeringRoutesPagedResponse&gt; future = networksClient.listPeeringRoutesPagedCallable().futureCall(request);
   *   // Do something
   *   for (ExchangedPeeringRoute element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  public final UnaryCallable<ListPeeringRoutesNetworksRequest, ListPeeringRoutesPagedResponse>
      listPeeringRoutesPagedCallable() {
    return stub.listPeeringRoutesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists the peering routes exchanged over peering connection.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NetworksClient networksClient = NetworksClient.create()) {
   *   String network = "";
   *   String project = "";
   *   ListPeeringRoutesNetworksRequest request = ListPeeringRoutesNetworksRequest.newBuilder()
   *     .setNetwork(network)
   *     .setProject(project)
   *     .build();
   *   while (true) {
   *     ExchangedPeeringRoutesList response = networksClient.listPeeringRoutesCallable().call(request);
   *     for (ExchangedPeeringRoute element : response.getItemsList()) {
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
  public final UnaryCallable<ListPeeringRoutesNetworksRequest, ExchangedPeeringRoutesList>
      listPeeringRoutesCallable() {
    return stub.listPeeringRoutesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Patches the specified network with the data included in the request. Only the following fields
   * can be modified: routingConfig.routingMode.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NetworksClient networksClient = NetworksClient.create()) {
   *   String project = "";
   *   String network = "";
   *   Network networkResource = Network.newBuilder().build();
   *   Operation response = networksClient.patch(project, network, networkResource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param network Name of the network to update.
   * @param networkResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation patch(String project, String network, Network networkResource) {
    PatchNetworkRequest request =
        PatchNetworkRequest.newBuilder()
            .setProject(project)
            .setNetwork(network)
            .setNetworkResource(networkResource)
            .build();
    return patch(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Patches the specified network with the data included in the request. Only the following fields
   * can be modified: routingConfig.routingMode.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NetworksClient networksClient = NetworksClient.create()) {
   *   String network = "";
   *   Network networkResource = Network.newBuilder().build();
   *   String project = "";
   *   PatchNetworkRequest request = PatchNetworkRequest.newBuilder()
   *     .setNetwork(network)
   *     .setNetworkResource(networkResource)
   *     .setProject(project)
   *     .build();
   *   Operation response = networksClient.patch(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation patch(PatchNetworkRequest request) {
    return patchCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Patches the specified network with the data included in the request. Only the following fields
   * can be modified: routingConfig.routingMode.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NetworksClient networksClient = NetworksClient.create()) {
   *   String network = "";
   *   Network networkResource = Network.newBuilder().build();
   *   String project = "";
   *   PatchNetworkRequest request = PatchNetworkRequest.newBuilder()
   *     .setNetwork(network)
   *     .setNetworkResource(networkResource)
   *     .setProject(project)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = networksClient.patchCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<PatchNetworkRequest, Operation> patchCallable() {
    return stub.patchCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Removes a peering from the specified network.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NetworksClient networksClient = NetworksClient.create()) {
   *   String project = "";
   *   String network = "";
   *   NetworksRemovePeeringRequest networksRemovePeeringRequestResource = NetworksRemovePeeringRequest.newBuilder().build();
   *   Operation response = networksClient.removePeering(project, network, networksRemovePeeringRequestResource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param network Name of the network resource to remove peering from.
   * @param networksRemovePeeringRequestResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation removePeering(
      String project,
      String network,
      NetworksRemovePeeringRequest networksRemovePeeringRequestResource) {
    RemovePeeringNetworkRequest request =
        RemovePeeringNetworkRequest.newBuilder()
            .setProject(project)
            .setNetwork(network)
            .setNetworksRemovePeeringRequestResource(networksRemovePeeringRequestResource)
            .build();
    return removePeering(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Removes a peering from the specified network.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NetworksClient networksClient = NetworksClient.create()) {
   *   String network = "";
   *   NetworksRemovePeeringRequest networksRemovePeeringRequestResource = NetworksRemovePeeringRequest.newBuilder().build();
   *   String project = "";
   *   RemovePeeringNetworkRequest request = RemovePeeringNetworkRequest.newBuilder()
   *     .setNetwork(network)
   *     .setNetworksRemovePeeringRequestResource(networksRemovePeeringRequestResource)
   *     .setProject(project)
   *     .build();
   *   Operation response = networksClient.removePeering(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation removePeering(RemovePeeringNetworkRequest request) {
    return removePeeringCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Removes a peering from the specified network.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NetworksClient networksClient = NetworksClient.create()) {
   *   String network = "";
   *   NetworksRemovePeeringRequest networksRemovePeeringRequestResource = NetworksRemovePeeringRequest.newBuilder().build();
   *   String project = "";
   *   RemovePeeringNetworkRequest request = RemovePeeringNetworkRequest.newBuilder()
   *     .setNetwork(network)
   *     .setNetworksRemovePeeringRequestResource(networksRemovePeeringRequestResource)
   *     .setProject(project)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = networksClient.removePeeringCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<RemovePeeringNetworkRequest, Operation> removePeeringCallable() {
    return stub.removePeeringCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Switches the network mode from auto subnet mode to custom subnet mode.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NetworksClient networksClient = NetworksClient.create()) {
   *   String project = "";
   *   String network = "";
   *   Operation response = networksClient.switchToCustomMode(project, network);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param network Name of the network to be updated.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation switchToCustomMode(String project, String network) {
    SwitchToCustomModeNetworkRequest request =
        SwitchToCustomModeNetworkRequest.newBuilder()
            .setProject(project)
            .setNetwork(network)
            .build();
    return switchToCustomMode(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Switches the network mode from auto subnet mode to custom subnet mode.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NetworksClient networksClient = NetworksClient.create()) {
   *   String network = "";
   *   String project = "";
   *   SwitchToCustomModeNetworkRequest request = SwitchToCustomModeNetworkRequest.newBuilder()
   *     .setNetwork(network)
   *     .setProject(project)
   *     .build();
   *   Operation response = networksClient.switchToCustomMode(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation switchToCustomMode(SwitchToCustomModeNetworkRequest request) {
    return switchToCustomModeCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Switches the network mode from auto subnet mode to custom subnet mode.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NetworksClient networksClient = NetworksClient.create()) {
   *   String network = "";
   *   String project = "";
   *   SwitchToCustomModeNetworkRequest request = SwitchToCustomModeNetworkRequest.newBuilder()
   *     .setNetwork(network)
   *     .setProject(project)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = networksClient.switchToCustomModeCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<SwitchToCustomModeNetworkRequest, Operation>
      switchToCustomModeCallable() {
    return stub.switchToCustomModeCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates the specified network peering with the data included in the request Only the following
   * fields can be modified: NetworkPeering.export_custom_routes, and
   * NetworkPeering.import_custom_routes
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NetworksClient networksClient = NetworksClient.create()) {
   *   String project = "";
   *   String network = "";
   *   NetworksUpdatePeeringRequest networksUpdatePeeringRequestResource = NetworksUpdatePeeringRequest.newBuilder().build();
   *   Operation response = networksClient.updatePeering(project, network, networksUpdatePeeringRequestResource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param network Name of the network resource which the updated peering is belonging to.
   * @param networksUpdatePeeringRequestResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation updatePeering(
      String project,
      String network,
      NetworksUpdatePeeringRequest networksUpdatePeeringRequestResource) {
    UpdatePeeringNetworkRequest request =
        UpdatePeeringNetworkRequest.newBuilder()
            .setProject(project)
            .setNetwork(network)
            .setNetworksUpdatePeeringRequestResource(networksUpdatePeeringRequestResource)
            .build();
    return updatePeering(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates the specified network peering with the data included in the request Only the following
   * fields can be modified: NetworkPeering.export_custom_routes, and
   * NetworkPeering.import_custom_routes
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NetworksClient networksClient = NetworksClient.create()) {
   *   String network = "";
   *   NetworksUpdatePeeringRequest networksUpdatePeeringRequestResource = NetworksUpdatePeeringRequest.newBuilder().build();
   *   String project = "";
   *   UpdatePeeringNetworkRequest request = UpdatePeeringNetworkRequest.newBuilder()
   *     .setNetwork(network)
   *     .setNetworksUpdatePeeringRequestResource(networksUpdatePeeringRequestResource)
   *     .setProject(project)
   *     .build();
   *   Operation response = networksClient.updatePeering(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation updatePeering(UpdatePeeringNetworkRequest request) {
    return updatePeeringCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates the specified network peering with the data included in the request Only the following
   * fields can be modified: NetworkPeering.export_custom_routes, and
   * NetworkPeering.import_custom_routes
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NetworksClient networksClient = NetworksClient.create()) {
   *   String network = "";
   *   NetworksUpdatePeeringRequest networksUpdatePeeringRequestResource = NetworksUpdatePeeringRequest.newBuilder().build();
   *   String project = "";
   *   UpdatePeeringNetworkRequest request = UpdatePeeringNetworkRequest.newBuilder()
   *     .setNetwork(network)
   *     .setNetworksUpdatePeeringRequestResource(networksUpdatePeeringRequestResource)
   *     .setProject(project)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = networksClient.updatePeeringCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<UpdatePeeringNetworkRequest, Operation> updatePeeringCallable() {
    return stub.updatePeeringCallable();
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
          ListNetworksRequest, NetworkList, Network, ListPage, ListFixedSizeCollection> {

    public static ApiFuture<ListPagedResponse> createAsync(
        PageContext<ListNetworksRequest, NetworkList, Network> context,
        ApiFuture<NetworkList> futureResponse) {
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
      extends AbstractPage<ListNetworksRequest, NetworkList, Network, ListPage> {

    private ListPage(
        PageContext<ListNetworksRequest, NetworkList, Network> context, NetworkList response) {
      super(context, response);
    }

    private static ListPage createEmptyPage() {
      return new ListPage(null, null);
    }

    @Override
    protected ListPage createPage(
        PageContext<ListNetworksRequest, NetworkList, Network> context, NetworkList response) {
      return new ListPage(context, response);
    }

    @Override
    public ApiFuture<ListPage> createPageAsync(
        PageContext<ListNetworksRequest, NetworkList, Network> context,
        ApiFuture<NetworkList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListNetworksRequest, NetworkList, Network, ListPage, ListFixedSizeCollection> {

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

  public static class ListPeeringRoutesPagedResponse
      extends AbstractPagedListResponse<
          ListPeeringRoutesNetworksRequest,
          ExchangedPeeringRoutesList,
          ExchangedPeeringRoute,
          ListPeeringRoutesPage,
          ListPeeringRoutesFixedSizeCollection> {

    public static ApiFuture<ListPeeringRoutesPagedResponse> createAsync(
        PageContext<
                ListPeeringRoutesNetworksRequest, ExchangedPeeringRoutesList, ExchangedPeeringRoute>
            context,
        ApiFuture<ExchangedPeeringRoutesList> futureResponse) {
      ApiFuture<ListPeeringRoutesPage> futurePage =
          ListPeeringRoutesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListPeeringRoutesPage, ListPeeringRoutesPagedResponse>() {
            @Override
            public ListPeeringRoutesPagedResponse apply(ListPeeringRoutesPage input) {
              return new ListPeeringRoutesPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
    }

    private ListPeeringRoutesPagedResponse(ListPeeringRoutesPage page) {
      super(page, ListPeeringRoutesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListPeeringRoutesPage
      extends AbstractPage<
          ListPeeringRoutesNetworksRequest,
          ExchangedPeeringRoutesList,
          ExchangedPeeringRoute,
          ListPeeringRoutesPage> {

    private ListPeeringRoutesPage(
        PageContext<
                ListPeeringRoutesNetworksRequest, ExchangedPeeringRoutesList, ExchangedPeeringRoute>
            context,
        ExchangedPeeringRoutesList response) {
      super(context, response);
    }

    private static ListPeeringRoutesPage createEmptyPage() {
      return new ListPeeringRoutesPage(null, null);
    }

    @Override
    protected ListPeeringRoutesPage createPage(
        PageContext<
                ListPeeringRoutesNetworksRequest, ExchangedPeeringRoutesList, ExchangedPeeringRoute>
            context,
        ExchangedPeeringRoutesList response) {
      return new ListPeeringRoutesPage(context, response);
    }

    @Override
    public ApiFuture<ListPeeringRoutesPage> createPageAsync(
        PageContext<
                ListPeeringRoutesNetworksRequest, ExchangedPeeringRoutesList, ExchangedPeeringRoute>
            context,
        ApiFuture<ExchangedPeeringRoutesList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListPeeringRoutesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListPeeringRoutesNetworksRequest,
          ExchangedPeeringRoutesList,
          ExchangedPeeringRoute,
          ListPeeringRoutesPage,
          ListPeeringRoutesFixedSizeCollection> {

    private ListPeeringRoutesFixedSizeCollection(
        List<ListPeeringRoutesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListPeeringRoutesFixedSizeCollection createEmptyCollection() {
      return new ListPeeringRoutesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListPeeringRoutesFixedSizeCollection createCollection(
        List<ListPeeringRoutesPage> pages, int collectionSize) {
      return new ListPeeringRoutesFixedSizeCollection(pages, collectionSize);
    }
  }
}
