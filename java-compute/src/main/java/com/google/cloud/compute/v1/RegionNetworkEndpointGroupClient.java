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
import com.google.cloud.compute.v1.stub.RegionNetworkEndpointGroupStub;
import com.google.cloud.compute.v1.stub.RegionNetworkEndpointGroupStubSettings;
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
 * try (RegionNetworkEndpointGroupClient regionNetworkEndpointGroupClient = RegionNetworkEndpointGroupClient.create()) {
 *   ProjectRegionNetworkEndpointGroupName networkEndpointGroup = ProjectRegionNetworkEndpointGroupName.of("[PROJECT]", "[REGION]", "[NETWORK_ENDPOINT_GROUP]");
 *   Operation response = regionNetworkEndpointGroupClient.deleteRegionNetworkEndpointGroup(networkEndpointGroup);
 * }
 * </code>
 * </pre>
 *
 * <p>Note: close() needs to be called on the regionNetworkEndpointGroupClient object to clean up
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
 * <p>This class can be customized by passing in a custom instance of
 * RegionNetworkEndpointGroupSettings to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>
 * <code>
 * RegionNetworkEndpointGroupSettings regionNetworkEndpointGroupSettings =
 *     RegionNetworkEndpointGroupSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * RegionNetworkEndpointGroupClient regionNetworkEndpointGroupClient =
 *     RegionNetworkEndpointGroupClient.create(regionNetworkEndpointGroupSettings);
 * </code>
 * </pre>
 *
 * To customize the endpoint:
 *
 * <pre>
 * <code>
 * RegionNetworkEndpointGroupSettings regionNetworkEndpointGroupSettings =
 *     RegionNetworkEndpointGroupSettings.newBuilder().setEndpoint(myEndpoint).build();
 * RegionNetworkEndpointGroupClient regionNetworkEndpointGroupClient =
 *     RegionNetworkEndpointGroupClient.create(regionNetworkEndpointGroupSettings);
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class RegionNetworkEndpointGroupClient implements BackgroundResource {
  private final RegionNetworkEndpointGroupSettings settings;
  private final RegionNetworkEndpointGroupStub stub;

  /** Constructs an instance of RegionNetworkEndpointGroupClient with default settings. */
  public static final RegionNetworkEndpointGroupClient create() throws IOException {
    return create(RegionNetworkEndpointGroupSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of RegionNetworkEndpointGroupClient, using the given settings. The
   * channels are created based on the settings passed in, or defaults for any settings that are not
   * set.
   */
  public static final RegionNetworkEndpointGroupClient create(
      RegionNetworkEndpointGroupSettings settings) throws IOException {
    return new RegionNetworkEndpointGroupClient(settings);
  }

  /**
   * Constructs an instance of RegionNetworkEndpointGroupClient, using the given stub for making
   * calls. This is for advanced usage - prefer to use RegionNetworkEndpointGroupSettings}.
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final RegionNetworkEndpointGroupClient create(RegionNetworkEndpointGroupStub stub) {
    return new RegionNetworkEndpointGroupClient(stub);
  }

  /**
   * Constructs an instance of RegionNetworkEndpointGroupClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected RegionNetworkEndpointGroupClient(RegionNetworkEndpointGroupSettings settings)
      throws IOException {
    this.settings = settings;
    this.stub = ((RegionNetworkEndpointGroupStubSettings) settings.getStubSettings()).createStub();
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected RegionNetworkEndpointGroupClient(RegionNetworkEndpointGroupStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final RegionNetworkEndpointGroupSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public RegionNetworkEndpointGroupStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified network endpoint group. Note that the NEG cannot be deleted if it is
   * configured as a backend of a backend service.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionNetworkEndpointGroupClient regionNetworkEndpointGroupClient = RegionNetworkEndpointGroupClient.create()) {
   *   ProjectRegionNetworkEndpointGroupName networkEndpointGroup = ProjectRegionNetworkEndpointGroupName.of("[PROJECT]", "[REGION]", "[NETWORK_ENDPOINT_GROUP]");
   *   Operation response = regionNetworkEndpointGroupClient.deleteRegionNetworkEndpointGroup(networkEndpointGroup);
   * }
   * </code></pre>
   *
   * @param networkEndpointGroup The name of the network endpoint group to delete. It should comply
   *     with RFC1035.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation deleteRegionNetworkEndpointGroup(
      ProjectRegionNetworkEndpointGroupName networkEndpointGroup) {
    DeleteRegionNetworkEndpointGroupHttpRequest request =
        DeleteRegionNetworkEndpointGroupHttpRequest.newBuilder()
            .setNetworkEndpointGroup(
                networkEndpointGroup == null ? null : networkEndpointGroup.toString())
            .build();
    return deleteRegionNetworkEndpointGroup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified network endpoint group. Note that the NEG cannot be deleted if it is
   * configured as a backend of a backend service.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionNetworkEndpointGroupClient regionNetworkEndpointGroupClient = RegionNetworkEndpointGroupClient.create()) {
   *   ProjectRegionNetworkEndpointGroupName networkEndpointGroup = ProjectRegionNetworkEndpointGroupName.of("[PROJECT]", "[REGION]", "[NETWORK_ENDPOINT_GROUP]");
   *   Operation response = regionNetworkEndpointGroupClient.deleteRegionNetworkEndpointGroup(networkEndpointGroup.toString());
   * }
   * </code></pre>
   *
   * @param networkEndpointGroup The name of the network endpoint group to delete. It should comply
   *     with RFC1035.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation deleteRegionNetworkEndpointGroup(String networkEndpointGroup) {
    DeleteRegionNetworkEndpointGroupHttpRequest request =
        DeleteRegionNetworkEndpointGroupHttpRequest.newBuilder()
            .setNetworkEndpointGroup(networkEndpointGroup)
            .build();
    return deleteRegionNetworkEndpointGroup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified network endpoint group. Note that the NEG cannot be deleted if it is
   * configured as a backend of a backend service.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionNetworkEndpointGroupClient regionNetworkEndpointGroupClient = RegionNetworkEndpointGroupClient.create()) {
   *   String formattedNetworkEndpointGroup = ProjectRegionNetworkEndpointGroupName.format("[PROJECT]", "[REGION]", "[NETWORK_ENDPOINT_GROUP]");
   *   DeleteRegionNetworkEndpointGroupHttpRequest request = DeleteRegionNetworkEndpointGroupHttpRequest.newBuilder()
   *     .setNetworkEndpointGroup(formattedNetworkEndpointGroup)
   *     .build();
   *   Operation response = regionNetworkEndpointGroupClient.deleteRegionNetworkEndpointGroup(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation deleteRegionNetworkEndpointGroup(
      DeleteRegionNetworkEndpointGroupHttpRequest request) {
    return deleteRegionNetworkEndpointGroupCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified network endpoint group. Note that the NEG cannot be deleted if it is
   * configured as a backend of a backend service.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionNetworkEndpointGroupClient regionNetworkEndpointGroupClient = RegionNetworkEndpointGroupClient.create()) {
   *   String formattedNetworkEndpointGroup = ProjectRegionNetworkEndpointGroupName.format("[PROJECT]", "[REGION]", "[NETWORK_ENDPOINT_GROUP]");
   *   DeleteRegionNetworkEndpointGroupHttpRequest request = DeleteRegionNetworkEndpointGroupHttpRequest.newBuilder()
   *     .setNetworkEndpointGroup(formattedNetworkEndpointGroup)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = regionNetworkEndpointGroupClient.deleteRegionNetworkEndpointGroupCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<DeleteRegionNetworkEndpointGroupHttpRequest, Operation>
      deleteRegionNetworkEndpointGroupCallable() {
    return stub.deleteRegionNetworkEndpointGroupCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified network endpoint group. Gets a list of available network endpoint groups
   * by making a list() request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionNetworkEndpointGroupClient regionNetworkEndpointGroupClient = RegionNetworkEndpointGroupClient.create()) {
   *   ProjectRegionNetworkEndpointGroupName networkEndpointGroup = ProjectRegionNetworkEndpointGroupName.of("[PROJECT]", "[REGION]", "[NETWORK_ENDPOINT_GROUP]");
   *   NetworkEndpointGroup response = regionNetworkEndpointGroupClient.getRegionNetworkEndpointGroup(networkEndpointGroup);
   * }
   * </code></pre>
   *
   * @param networkEndpointGroup The name of the network endpoint group. It should comply with
   *     RFC1035.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final NetworkEndpointGroup getRegionNetworkEndpointGroup(
      ProjectRegionNetworkEndpointGroupName networkEndpointGroup) {
    GetRegionNetworkEndpointGroupHttpRequest request =
        GetRegionNetworkEndpointGroupHttpRequest.newBuilder()
            .setNetworkEndpointGroup(
                networkEndpointGroup == null ? null : networkEndpointGroup.toString())
            .build();
    return getRegionNetworkEndpointGroup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified network endpoint group. Gets a list of available network endpoint groups
   * by making a list() request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionNetworkEndpointGroupClient regionNetworkEndpointGroupClient = RegionNetworkEndpointGroupClient.create()) {
   *   ProjectRegionNetworkEndpointGroupName networkEndpointGroup = ProjectRegionNetworkEndpointGroupName.of("[PROJECT]", "[REGION]", "[NETWORK_ENDPOINT_GROUP]");
   *   NetworkEndpointGroup response = regionNetworkEndpointGroupClient.getRegionNetworkEndpointGroup(networkEndpointGroup.toString());
   * }
   * </code></pre>
   *
   * @param networkEndpointGroup The name of the network endpoint group. It should comply with
   *     RFC1035.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final NetworkEndpointGroup getRegionNetworkEndpointGroup(String networkEndpointGroup) {
    GetRegionNetworkEndpointGroupHttpRequest request =
        GetRegionNetworkEndpointGroupHttpRequest.newBuilder()
            .setNetworkEndpointGroup(networkEndpointGroup)
            .build();
    return getRegionNetworkEndpointGroup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified network endpoint group. Gets a list of available network endpoint groups
   * by making a list() request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionNetworkEndpointGroupClient regionNetworkEndpointGroupClient = RegionNetworkEndpointGroupClient.create()) {
   *   String formattedNetworkEndpointGroup = ProjectRegionNetworkEndpointGroupName.format("[PROJECT]", "[REGION]", "[NETWORK_ENDPOINT_GROUP]");
   *   GetRegionNetworkEndpointGroupHttpRequest request = GetRegionNetworkEndpointGroupHttpRequest.newBuilder()
   *     .setNetworkEndpointGroup(formattedNetworkEndpointGroup)
   *     .build();
   *   NetworkEndpointGroup response = regionNetworkEndpointGroupClient.getRegionNetworkEndpointGroup(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final NetworkEndpointGroup getRegionNetworkEndpointGroup(
      GetRegionNetworkEndpointGroupHttpRequest request) {
    return getRegionNetworkEndpointGroupCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified network endpoint group. Gets a list of available network endpoint groups
   * by making a list() request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionNetworkEndpointGroupClient regionNetworkEndpointGroupClient = RegionNetworkEndpointGroupClient.create()) {
   *   String formattedNetworkEndpointGroup = ProjectRegionNetworkEndpointGroupName.format("[PROJECT]", "[REGION]", "[NETWORK_ENDPOINT_GROUP]");
   *   GetRegionNetworkEndpointGroupHttpRequest request = GetRegionNetworkEndpointGroupHttpRequest.newBuilder()
   *     .setNetworkEndpointGroup(formattedNetworkEndpointGroup)
   *     .build();
   *   ApiFuture&lt;NetworkEndpointGroup&gt; future = regionNetworkEndpointGroupClient.getRegionNetworkEndpointGroupCallable().futureCall(request);
   *   // Do something
   *   NetworkEndpointGroup response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<GetRegionNetworkEndpointGroupHttpRequest, NetworkEndpointGroup>
      getRegionNetworkEndpointGroupCallable() {
    return stub.getRegionNetworkEndpointGroupCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a network endpoint group in the specified project using the parameters that are
   * included in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionNetworkEndpointGroupClient regionNetworkEndpointGroupClient = RegionNetworkEndpointGroupClient.create()) {
   *   ProjectRegionName region = ProjectRegionName.of("[PROJECT]", "[REGION]");
   *   NetworkEndpointGroup networkEndpointGroupResource = NetworkEndpointGroup.newBuilder().build();
   *   Operation response = regionNetworkEndpointGroupClient.insertRegionNetworkEndpointGroup(region, networkEndpointGroupResource);
   * }
   * </code></pre>
   *
   * @param region The name of the region where you want to create the network endpoint group. It
   *     should comply with RFC1035.
   * @param networkEndpointGroupResource Represents a collection of network endpoints.
   *     <p>A network endpoint group (NEG) defines how a set of endpoints should be reached, whether
   *     they are reachable, and where they are located. For more information about using NEGs, see
   *     Setting up internet NEGs, Setting up zonal NEGs, or Setting up serverless NEGs. (==
   *     resource_for {$api_version}.networkEndpointGroups ==) (== resource_for
   *     {$api_version}.globalNetworkEndpointGroups ==) (== resource_for
   *     {$api_version}.regionNetworkEndpointGroups ==)
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation insertRegionNetworkEndpointGroup(
      ProjectRegionName region, NetworkEndpointGroup networkEndpointGroupResource) {
    InsertRegionNetworkEndpointGroupHttpRequest request =
        InsertRegionNetworkEndpointGroupHttpRequest.newBuilder()
            .setRegion(region == null ? null : region.toString())
            .setNetworkEndpointGroupResource(networkEndpointGroupResource)
            .build();
    return insertRegionNetworkEndpointGroup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a network endpoint group in the specified project using the parameters that are
   * included in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionNetworkEndpointGroupClient regionNetworkEndpointGroupClient = RegionNetworkEndpointGroupClient.create()) {
   *   ProjectRegionName region = ProjectRegionName.of("[PROJECT]", "[REGION]");
   *   NetworkEndpointGroup networkEndpointGroupResource = NetworkEndpointGroup.newBuilder().build();
   *   Operation response = regionNetworkEndpointGroupClient.insertRegionNetworkEndpointGroup(region.toString(), networkEndpointGroupResource);
   * }
   * </code></pre>
   *
   * @param region The name of the region where you want to create the network endpoint group. It
   *     should comply with RFC1035.
   * @param networkEndpointGroupResource Represents a collection of network endpoints.
   *     <p>A network endpoint group (NEG) defines how a set of endpoints should be reached, whether
   *     they are reachable, and where they are located. For more information about using NEGs, see
   *     Setting up internet NEGs, Setting up zonal NEGs, or Setting up serverless NEGs. (==
   *     resource_for {$api_version}.networkEndpointGroups ==) (== resource_for
   *     {$api_version}.globalNetworkEndpointGroups ==) (== resource_for
   *     {$api_version}.regionNetworkEndpointGroups ==)
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation insertRegionNetworkEndpointGroup(
      String region, NetworkEndpointGroup networkEndpointGroupResource) {
    InsertRegionNetworkEndpointGroupHttpRequest request =
        InsertRegionNetworkEndpointGroupHttpRequest.newBuilder()
            .setRegion(region)
            .setNetworkEndpointGroupResource(networkEndpointGroupResource)
            .build();
    return insertRegionNetworkEndpointGroup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a network endpoint group in the specified project using the parameters that are
   * included in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionNetworkEndpointGroupClient regionNetworkEndpointGroupClient = RegionNetworkEndpointGroupClient.create()) {
   *   String formattedRegion = ProjectRegionName.format("[PROJECT]", "[REGION]");
   *   NetworkEndpointGroup networkEndpointGroupResource = NetworkEndpointGroup.newBuilder().build();
   *   InsertRegionNetworkEndpointGroupHttpRequest request = InsertRegionNetworkEndpointGroupHttpRequest.newBuilder()
   *     .setRegion(formattedRegion)
   *     .setNetworkEndpointGroupResource(networkEndpointGroupResource)
   *     .build();
   *   Operation response = regionNetworkEndpointGroupClient.insertRegionNetworkEndpointGroup(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation insertRegionNetworkEndpointGroup(
      InsertRegionNetworkEndpointGroupHttpRequest request) {
    return insertRegionNetworkEndpointGroupCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a network endpoint group in the specified project using the parameters that are
   * included in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionNetworkEndpointGroupClient regionNetworkEndpointGroupClient = RegionNetworkEndpointGroupClient.create()) {
   *   String formattedRegion = ProjectRegionName.format("[PROJECT]", "[REGION]");
   *   NetworkEndpointGroup networkEndpointGroupResource = NetworkEndpointGroup.newBuilder().build();
   *   InsertRegionNetworkEndpointGroupHttpRequest request = InsertRegionNetworkEndpointGroupHttpRequest.newBuilder()
   *     .setRegion(formattedRegion)
   *     .setNetworkEndpointGroupResource(networkEndpointGroupResource)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = regionNetworkEndpointGroupClient.insertRegionNetworkEndpointGroupCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<InsertRegionNetworkEndpointGroupHttpRequest, Operation>
      insertRegionNetworkEndpointGroupCallable() {
    return stub.insertRegionNetworkEndpointGroupCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of regional network endpoint groups available to the specified project in
   * the given region.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionNetworkEndpointGroupClient regionNetworkEndpointGroupClient = RegionNetworkEndpointGroupClient.create()) {
   *   ProjectRegionName region = ProjectRegionName.of("[PROJECT]", "[REGION]");
   *   for (NetworkEndpointGroup element : regionNetworkEndpointGroupClient.listRegionNetworkEndpointGroups(region).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param region The name of the region where the network endpoint group is located. It should
   *     comply with RFC1035.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListRegionNetworkEndpointGroupsPagedResponse listRegionNetworkEndpointGroups(
      ProjectRegionName region) {
    ListRegionNetworkEndpointGroupsHttpRequest request =
        ListRegionNetworkEndpointGroupsHttpRequest.newBuilder()
            .setRegion(region == null ? null : region.toString())
            .build();
    return listRegionNetworkEndpointGroups(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of regional network endpoint groups available to the specified project in
   * the given region.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionNetworkEndpointGroupClient regionNetworkEndpointGroupClient = RegionNetworkEndpointGroupClient.create()) {
   *   ProjectRegionName region = ProjectRegionName.of("[PROJECT]", "[REGION]");
   *   for (NetworkEndpointGroup element : regionNetworkEndpointGroupClient.listRegionNetworkEndpointGroups(region.toString()).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param region The name of the region where the network endpoint group is located. It should
   *     comply with RFC1035.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListRegionNetworkEndpointGroupsPagedResponse listRegionNetworkEndpointGroups(
      String region) {
    ListRegionNetworkEndpointGroupsHttpRequest request =
        ListRegionNetworkEndpointGroupsHttpRequest.newBuilder().setRegion(region).build();
    return listRegionNetworkEndpointGroups(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of regional network endpoint groups available to the specified project in
   * the given region.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionNetworkEndpointGroupClient regionNetworkEndpointGroupClient = RegionNetworkEndpointGroupClient.create()) {
   *   String formattedRegion = ProjectRegionName.format("[PROJECT]", "[REGION]");
   *   ListRegionNetworkEndpointGroupsHttpRequest request = ListRegionNetworkEndpointGroupsHttpRequest.newBuilder()
   *     .setRegion(formattedRegion)
   *     .build();
   *   for (NetworkEndpointGroup element : regionNetworkEndpointGroupClient.listRegionNetworkEndpointGroups(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListRegionNetworkEndpointGroupsPagedResponse listRegionNetworkEndpointGroups(
      ListRegionNetworkEndpointGroupsHttpRequest request) {
    return listRegionNetworkEndpointGroupsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of regional network endpoint groups available to the specified project in
   * the given region.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionNetworkEndpointGroupClient regionNetworkEndpointGroupClient = RegionNetworkEndpointGroupClient.create()) {
   *   String formattedRegion = ProjectRegionName.format("[PROJECT]", "[REGION]");
   *   ListRegionNetworkEndpointGroupsHttpRequest request = ListRegionNetworkEndpointGroupsHttpRequest.newBuilder()
   *     .setRegion(formattedRegion)
   *     .build();
   *   ApiFuture&lt;ListRegionNetworkEndpointGroupsPagedResponse&gt; future = regionNetworkEndpointGroupClient.listRegionNetworkEndpointGroupsPagedCallable().futureCall(request);
   *   // Do something
   *   for (NetworkEndpointGroup element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<
          ListRegionNetworkEndpointGroupsHttpRequest, ListRegionNetworkEndpointGroupsPagedResponse>
      listRegionNetworkEndpointGroupsPagedCallable() {
    return stub.listRegionNetworkEndpointGroupsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of regional network endpoint groups available to the specified project in
   * the given region.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionNetworkEndpointGroupClient regionNetworkEndpointGroupClient = RegionNetworkEndpointGroupClient.create()) {
   *   String formattedRegion = ProjectRegionName.format("[PROJECT]", "[REGION]");
   *   ListRegionNetworkEndpointGroupsHttpRequest request = ListRegionNetworkEndpointGroupsHttpRequest.newBuilder()
   *     .setRegion(formattedRegion)
   *     .build();
   *   while (true) {
   *     NetworkEndpointGroupList response = regionNetworkEndpointGroupClient.listRegionNetworkEndpointGroupsCallable().call(request);
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
  public final UnaryCallable<ListRegionNetworkEndpointGroupsHttpRequest, NetworkEndpointGroupList>
      listRegionNetworkEndpointGroupsCallable() {
    return stub.listRegionNetworkEndpointGroupsCallable();
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

  public static class ListRegionNetworkEndpointGroupsPagedResponse
      extends AbstractPagedListResponse<
          ListRegionNetworkEndpointGroupsHttpRequest,
          NetworkEndpointGroupList,
          NetworkEndpointGroup,
          ListRegionNetworkEndpointGroupsPage,
          ListRegionNetworkEndpointGroupsFixedSizeCollection> {

    public static ApiFuture<ListRegionNetworkEndpointGroupsPagedResponse> createAsync(
        PageContext<
                ListRegionNetworkEndpointGroupsHttpRequest,
                NetworkEndpointGroupList,
                NetworkEndpointGroup>
            context,
        ApiFuture<NetworkEndpointGroupList> futureResponse) {
      ApiFuture<ListRegionNetworkEndpointGroupsPage> futurePage =
          ListRegionNetworkEndpointGroupsPage.createEmptyPage()
              .createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<
              ListRegionNetworkEndpointGroupsPage, ListRegionNetworkEndpointGroupsPagedResponse>() {
            @Override
            public ListRegionNetworkEndpointGroupsPagedResponse apply(
                ListRegionNetworkEndpointGroupsPage input) {
              return new ListRegionNetworkEndpointGroupsPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
    }

    private ListRegionNetworkEndpointGroupsPagedResponse(ListRegionNetworkEndpointGroupsPage page) {
      super(page, ListRegionNetworkEndpointGroupsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListRegionNetworkEndpointGroupsPage
      extends AbstractPage<
          ListRegionNetworkEndpointGroupsHttpRequest,
          NetworkEndpointGroupList,
          NetworkEndpointGroup,
          ListRegionNetworkEndpointGroupsPage> {

    private ListRegionNetworkEndpointGroupsPage(
        PageContext<
                ListRegionNetworkEndpointGroupsHttpRequest,
                NetworkEndpointGroupList,
                NetworkEndpointGroup>
            context,
        NetworkEndpointGroupList response) {
      super(context, response);
    }

    private static ListRegionNetworkEndpointGroupsPage createEmptyPage() {
      return new ListRegionNetworkEndpointGroupsPage(null, null);
    }

    @Override
    protected ListRegionNetworkEndpointGroupsPage createPage(
        PageContext<
                ListRegionNetworkEndpointGroupsHttpRequest,
                NetworkEndpointGroupList,
                NetworkEndpointGroup>
            context,
        NetworkEndpointGroupList response) {
      return new ListRegionNetworkEndpointGroupsPage(context, response);
    }

    @Override
    public ApiFuture<ListRegionNetworkEndpointGroupsPage> createPageAsync(
        PageContext<
                ListRegionNetworkEndpointGroupsHttpRequest,
                NetworkEndpointGroupList,
                NetworkEndpointGroup>
            context,
        ApiFuture<NetworkEndpointGroupList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListRegionNetworkEndpointGroupsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListRegionNetworkEndpointGroupsHttpRequest,
          NetworkEndpointGroupList,
          NetworkEndpointGroup,
          ListRegionNetworkEndpointGroupsPage,
          ListRegionNetworkEndpointGroupsFixedSizeCollection> {

    private ListRegionNetworkEndpointGroupsFixedSizeCollection(
        List<ListRegionNetworkEndpointGroupsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListRegionNetworkEndpointGroupsFixedSizeCollection createEmptyCollection() {
      return new ListRegionNetworkEndpointGroupsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListRegionNetworkEndpointGroupsFixedSizeCollection createCollection(
        List<ListRegionNetworkEndpointGroupsPage> pages, int collectionSize) {
      return new ListRegionNetworkEndpointGroupsFixedSizeCollection(pages, collectionSize);
    }
  }
}
