/*
 * Copyright 2018 Google LLC
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
import com.google.cloud.compute.v1.stub.VpnTunnelStub;
import com.google.cloud.compute.v1.stub.VpnTunnelStubSettings;
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
 * try (VpnTunnelClient vpnTunnelClient = VpnTunnelClient.create()) {
 *   ProjectRegionVpnTunnelName vpnTunnel = ProjectRegionVpnTunnelName.of("[PROJECT]", "[REGION]", "[VPN_TUNNEL]");
 *   Operation response = vpnTunnelClient.deleteVpnTunnel(vpnTunnel);
 * }
 * </code>
 * </pre>
 *
 * <p>Note: close() needs to be called on the vpnTunnelClient object to clean up resources such as
 * threads. In the example above, try-with-resources is used, which automatically calls close().
 *
 * <p>The surface of this class includes several types of Java methods for each of the API's
 * methods:
 *
 * <ol>
 *   <li> A "flattened" method. With this type of method, the fields of the request type have been
 *       converted into function parameters. It may be the case that not all fields are available as
 *       parameters, and not every API method will have a flattened method entry point.
 *   <li> A "request object" method. This type of method only takes one parameter, a request object,
 *       which must be constructed before the call. Not every API method will have a request object
 *       method.
 *   <li> A "callable" method. This type of method takes no parameters and returns an immutable API
 *       callable object, which can be used to initiate calls to the service.
 * </ol>
 *
 * <p>See the individual methods for example code.
 *
 * <p>Many parameters require resource names to be formatted in a particular way. To assist with
 * these names, this class includes a format method for each type of name, and additionally a parse
 * method to extract the individual identifiers contained within names that are returned.
 *
 * <p>This class can be customized by passing in a custom instance of VpnTunnelSettings to create().
 * For example:
 *
 * <p>To customize credentials:
 *
 * <pre>
 * <code>
 * VpnTunnelSettings vpnTunnelSettings =
 *     VpnTunnelSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * VpnTunnelClient vpnTunnelClient =
 *     VpnTunnelClient.create(vpnTunnelSettings);
 * </code>
 * </pre>
 *
 * To customize the endpoint:
 *
 * <pre>
 * <code>
 * VpnTunnelSettings vpnTunnelSettings =
 *     VpnTunnelSettings.newBuilder().setEndpoint(myEndpoint).build();
 * VpnTunnelClient vpnTunnelClient =
 *     VpnTunnelClient.create(vpnTunnelSettings);
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class VpnTunnelClient implements BackgroundResource {
  private final VpnTunnelSettings settings;
  private final VpnTunnelStub stub;

  /** Constructs an instance of VpnTunnelClient with default settings. */
  public static final VpnTunnelClient create() throws IOException {
    return create(VpnTunnelSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of VpnTunnelClient, using the given settings. The channels are created
   * based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final VpnTunnelClient create(VpnTunnelSettings settings) throws IOException {
    return new VpnTunnelClient(settings);
  }

  /**
   * Constructs an instance of VpnTunnelClient, using the given stub for making calls. This is for
   * advanced usage - prefer to use VpnTunnelSettings}.
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final VpnTunnelClient create(VpnTunnelStub stub) {
    return new VpnTunnelClient(stub);
  }

  /**
   * Constructs an instance of VpnTunnelClient, using the given settings. This is protected so that
   * it is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected VpnTunnelClient(VpnTunnelSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((VpnTunnelStubSettings) settings.getStubSettings()).createStub();
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected VpnTunnelClient(VpnTunnelStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final VpnTunnelSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public VpnTunnelStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves an aggregated list of VPN tunnels.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (VpnTunnelClient vpnTunnelClient = VpnTunnelClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   for (VpnTunnelsScopedList element : vpnTunnelClient.aggregatedListVpnTunnels(project).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final AggregatedListVpnTunnelsPagedResponse aggregatedListVpnTunnels(ProjectName project) {
    AggregatedListVpnTunnelsHttpRequest request =
        AggregatedListVpnTunnelsHttpRequest.newBuilder()
            .setProject(project == null ? null : project.toString())
            .build();
    return aggregatedListVpnTunnels(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves an aggregated list of VPN tunnels.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (VpnTunnelClient vpnTunnelClient = VpnTunnelClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   for (VpnTunnelsScopedList element : vpnTunnelClient.aggregatedListVpnTunnels(project.toString()).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final AggregatedListVpnTunnelsPagedResponse aggregatedListVpnTunnels(String project) {
    AggregatedListVpnTunnelsHttpRequest request =
        AggregatedListVpnTunnelsHttpRequest.newBuilder().setProject(project).build();
    return aggregatedListVpnTunnels(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves an aggregated list of VPN tunnels.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (VpnTunnelClient vpnTunnelClient = VpnTunnelClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   AggregatedListVpnTunnelsHttpRequest request = AggregatedListVpnTunnelsHttpRequest.newBuilder()
   *     .setProject(project.toString())
   *     .build();
   *   for (VpnTunnelsScopedList element : vpnTunnelClient.aggregatedListVpnTunnels(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final AggregatedListVpnTunnelsPagedResponse aggregatedListVpnTunnels(
      AggregatedListVpnTunnelsHttpRequest request) {
    return aggregatedListVpnTunnelsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves an aggregated list of VPN tunnels.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (VpnTunnelClient vpnTunnelClient = VpnTunnelClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   AggregatedListVpnTunnelsHttpRequest request = AggregatedListVpnTunnelsHttpRequest.newBuilder()
   *     .setProject(project.toString())
   *     .build();
   *   ApiFuture&lt;AggregatedListVpnTunnelsPagedResponse&gt; future = vpnTunnelClient.aggregatedListVpnTunnelsPagedCallable().futureCall(request);
   *   // Do something
   *   for (VpnTunnelsScopedList element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<
          AggregatedListVpnTunnelsHttpRequest, AggregatedListVpnTunnelsPagedResponse>
      aggregatedListVpnTunnelsPagedCallable() {
    return stub.aggregatedListVpnTunnelsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves an aggregated list of VPN tunnels.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (VpnTunnelClient vpnTunnelClient = VpnTunnelClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   AggregatedListVpnTunnelsHttpRequest request = AggregatedListVpnTunnelsHttpRequest.newBuilder()
   *     .setProject(project.toString())
   *     .build();
   *   while (true) {
   *     VpnTunnelAggregatedList response = vpnTunnelClient.aggregatedListVpnTunnelsCallable().call(request);
   *     for (VpnTunnelsScopedList element : response.getItemsMap()) {
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
  public final UnaryCallable<AggregatedListVpnTunnelsHttpRequest, VpnTunnelAggregatedList>
      aggregatedListVpnTunnelsCallable() {
    return stub.aggregatedListVpnTunnelsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified VpnTunnel resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (VpnTunnelClient vpnTunnelClient = VpnTunnelClient.create()) {
   *   ProjectRegionVpnTunnelName vpnTunnel = ProjectRegionVpnTunnelName.of("[PROJECT]", "[REGION]", "[VPN_TUNNEL]");
   *   Operation response = vpnTunnelClient.deleteVpnTunnel(vpnTunnel);
   * }
   * </code></pre>
   *
   * @param vpnTunnel Name of the VpnTunnel resource to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation deleteVpnTunnel(ProjectRegionVpnTunnelName vpnTunnel) {

    DeleteVpnTunnelHttpRequest request =
        DeleteVpnTunnelHttpRequest.newBuilder()
            .setVpnTunnel(vpnTunnel == null ? null : vpnTunnel.toString())
            .build();
    return deleteVpnTunnel(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified VpnTunnel resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (VpnTunnelClient vpnTunnelClient = VpnTunnelClient.create()) {
   *   ProjectRegionVpnTunnelName vpnTunnel = ProjectRegionVpnTunnelName.of("[PROJECT]", "[REGION]", "[VPN_TUNNEL]");
   *   Operation response = vpnTunnelClient.deleteVpnTunnel(vpnTunnel.toString());
   * }
   * </code></pre>
   *
   * @param vpnTunnel Name of the VpnTunnel resource to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation deleteVpnTunnel(String vpnTunnel) {

    DeleteVpnTunnelHttpRequest request =
        DeleteVpnTunnelHttpRequest.newBuilder().setVpnTunnel(vpnTunnel).build();
    return deleteVpnTunnel(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified VpnTunnel resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (VpnTunnelClient vpnTunnelClient = VpnTunnelClient.create()) {
   *   ProjectRegionVpnTunnelName vpnTunnel = ProjectRegionVpnTunnelName.of("[PROJECT]", "[REGION]", "[VPN_TUNNEL]");
   *   DeleteVpnTunnelHttpRequest request = DeleteVpnTunnelHttpRequest.newBuilder()
   *     .setVpnTunnel(vpnTunnel.toString())
   *     .build();
   *   Operation response = vpnTunnelClient.deleteVpnTunnel(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation deleteVpnTunnel(DeleteVpnTunnelHttpRequest request) {
    return deleteVpnTunnelCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified VpnTunnel resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (VpnTunnelClient vpnTunnelClient = VpnTunnelClient.create()) {
   *   ProjectRegionVpnTunnelName vpnTunnel = ProjectRegionVpnTunnelName.of("[PROJECT]", "[REGION]", "[VPN_TUNNEL]");
   *   DeleteVpnTunnelHttpRequest request = DeleteVpnTunnelHttpRequest.newBuilder()
   *     .setVpnTunnel(vpnTunnel.toString())
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = vpnTunnelClient.deleteVpnTunnelCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<DeleteVpnTunnelHttpRequest, Operation> deleteVpnTunnelCallable() {
    return stub.deleteVpnTunnelCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified VpnTunnel resource. Gets a list of available VPN tunnels by making a
   * list() request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (VpnTunnelClient vpnTunnelClient = VpnTunnelClient.create()) {
   *   ProjectRegionVpnTunnelName vpnTunnel = ProjectRegionVpnTunnelName.of("[PROJECT]", "[REGION]", "[VPN_TUNNEL]");
   *   VpnTunnel response = vpnTunnelClient.getVpnTunnel(vpnTunnel);
   * }
   * </code></pre>
   *
   * @param vpnTunnel Name of the VpnTunnel resource to return.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final VpnTunnel getVpnTunnel(ProjectRegionVpnTunnelName vpnTunnel) {

    GetVpnTunnelHttpRequest request =
        GetVpnTunnelHttpRequest.newBuilder()
            .setVpnTunnel(vpnTunnel == null ? null : vpnTunnel.toString())
            .build();
    return getVpnTunnel(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified VpnTunnel resource. Gets a list of available VPN tunnels by making a
   * list() request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (VpnTunnelClient vpnTunnelClient = VpnTunnelClient.create()) {
   *   ProjectRegionVpnTunnelName vpnTunnel = ProjectRegionVpnTunnelName.of("[PROJECT]", "[REGION]", "[VPN_TUNNEL]");
   *   VpnTunnel response = vpnTunnelClient.getVpnTunnel(vpnTunnel.toString());
   * }
   * </code></pre>
   *
   * @param vpnTunnel Name of the VpnTunnel resource to return.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final VpnTunnel getVpnTunnel(String vpnTunnel) {

    GetVpnTunnelHttpRequest request =
        GetVpnTunnelHttpRequest.newBuilder().setVpnTunnel(vpnTunnel).build();
    return getVpnTunnel(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified VpnTunnel resource. Gets a list of available VPN tunnels by making a
   * list() request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (VpnTunnelClient vpnTunnelClient = VpnTunnelClient.create()) {
   *   ProjectRegionVpnTunnelName vpnTunnel = ProjectRegionVpnTunnelName.of("[PROJECT]", "[REGION]", "[VPN_TUNNEL]");
   *   GetVpnTunnelHttpRequest request = GetVpnTunnelHttpRequest.newBuilder()
   *     .setVpnTunnel(vpnTunnel.toString())
   *     .build();
   *   VpnTunnel response = vpnTunnelClient.getVpnTunnel(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final VpnTunnel getVpnTunnel(GetVpnTunnelHttpRequest request) {
    return getVpnTunnelCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified VpnTunnel resource. Gets a list of available VPN tunnels by making a
   * list() request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (VpnTunnelClient vpnTunnelClient = VpnTunnelClient.create()) {
   *   ProjectRegionVpnTunnelName vpnTunnel = ProjectRegionVpnTunnelName.of("[PROJECT]", "[REGION]", "[VPN_TUNNEL]");
   *   GetVpnTunnelHttpRequest request = GetVpnTunnelHttpRequest.newBuilder()
   *     .setVpnTunnel(vpnTunnel.toString())
   *     .build();
   *   ApiFuture&lt;VpnTunnel&gt; future = vpnTunnelClient.getVpnTunnelCallable().futureCall(request);
   *   // Do something
   *   VpnTunnel response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<GetVpnTunnelHttpRequest, VpnTunnel> getVpnTunnelCallable() {
    return stub.getVpnTunnelCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a VpnTunnel resource in the specified project and region using the data included in the
   * request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (VpnTunnelClient vpnTunnelClient = VpnTunnelClient.create()) {
   *   ProjectRegionName region = ProjectRegionName.of("[PROJECT]", "[REGION]");
   *   VpnTunnel vpnTunnelResource = VpnTunnel.newBuilder().build();
   *   Operation response = vpnTunnelClient.insertVpnTunnel(region, vpnTunnelResource);
   * }
   * </code></pre>
   *
   * @param region Name of the region for this request.
   * @param vpnTunnelResource VPN tunnel resource. (== resource_for beta.vpnTunnels ==) (==
   *     resource_for v1.vpnTunnels ==)
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation insertVpnTunnel(ProjectRegionName region, VpnTunnel vpnTunnelResource) {

    InsertVpnTunnelHttpRequest request =
        InsertVpnTunnelHttpRequest.newBuilder()
            .setRegion(region == null ? null : region.toString())
            .setVpnTunnelResource(vpnTunnelResource)
            .build();
    return insertVpnTunnel(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a VpnTunnel resource in the specified project and region using the data included in the
   * request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (VpnTunnelClient vpnTunnelClient = VpnTunnelClient.create()) {
   *   ProjectRegionName region = ProjectRegionName.of("[PROJECT]", "[REGION]");
   *   VpnTunnel vpnTunnelResource = VpnTunnel.newBuilder().build();
   *   Operation response = vpnTunnelClient.insertVpnTunnel(region.toString(), vpnTunnelResource);
   * }
   * </code></pre>
   *
   * @param region Name of the region for this request.
   * @param vpnTunnelResource VPN tunnel resource. (== resource_for beta.vpnTunnels ==) (==
   *     resource_for v1.vpnTunnels ==)
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation insertVpnTunnel(String region, VpnTunnel vpnTunnelResource) {

    InsertVpnTunnelHttpRequest request =
        InsertVpnTunnelHttpRequest.newBuilder()
            .setRegion(region)
            .setVpnTunnelResource(vpnTunnelResource)
            .build();
    return insertVpnTunnel(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a VpnTunnel resource in the specified project and region using the data included in the
   * request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (VpnTunnelClient vpnTunnelClient = VpnTunnelClient.create()) {
   *   ProjectRegionName region = ProjectRegionName.of("[PROJECT]", "[REGION]");
   *   VpnTunnel vpnTunnelResource = VpnTunnel.newBuilder().build();
   *   InsertVpnTunnelHttpRequest request = InsertVpnTunnelHttpRequest.newBuilder()
   *     .setRegion(region.toString())
   *     .setVpnTunnelResource(vpnTunnelResource)
   *     .build();
   *   Operation response = vpnTunnelClient.insertVpnTunnel(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation insertVpnTunnel(InsertVpnTunnelHttpRequest request) {
    return insertVpnTunnelCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a VpnTunnel resource in the specified project and region using the data included in the
   * request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (VpnTunnelClient vpnTunnelClient = VpnTunnelClient.create()) {
   *   ProjectRegionName region = ProjectRegionName.of("[PROJECT]", "[REGION]");
   *   VpnTunnel vpnTunnelResource = VpnTunnel.newBuilder().build();
   *   InsertVpnTunnelHttpRequest request = InsertVpnTunnelHttpRequest.newBuilder()
   *     .setRegion(region.toString())
   *     .setVpnTunnelResource(vpnTunnelResource)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = vpnTunnelClient.insertVpnTunnelCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<InsertVpnTunnelHttpRequest, Operation> insertVpnTunnelCallable() {
    return stub.insertVpnTunnelCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of VpnTunnel resources contained in the specified project and region.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (VpnTunnelClient vpnTunnelClient = VpnTunnelClient.create()) {
   *   ProjectRegionName region = ProjectRegionName.of("[PROJECT]", "[REGION]");
   *   for (VpnTunnel element : vpnTunnelClient.listVpnTunnels(region).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param region Name of the region for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListVpnTunnelsPagedResponse listVpnTunnels(ProjectRegionName region) {
    ListVpnTunnelsHttpRequest request =
        ListVpnTunnelsHttpRequest.newBuilder()
            .setRegion(region == null ? null : region.toString())
            .build();
    return listVpnTunnels(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of VpnTunnel resources contained in the specified project and region.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (VpnTunnelClient vpnTunnelClient = VpnTunnelClient.create()) {
   *   ProjectRegionName region = ProjectRegionName.of("[PROJECT]", "[REGION]");
   *   for (VpnTunnel element : vpnTunnelClient.listVpnTunnels(region.toString()).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param region Name of the region for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListVpnTunnelsPagedResponse listVpnTunnels(String region) {
    ListVpnTunnelsHttpRequest request =
        ListVpnTunnelsHttpRequest.newBuilder().setRegion(region).build();
    return listVpnTunnels(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of VpnTunnel resources contained in the specified project and region.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (VpnTunnelClient vpnTunnelClient = VpnTunnelClient.create()) {
   *   ProjectRegionName region = ProjectRegionName.of("[PROJECT]", "[REGION]");
   *   ListVpnTunnelsHttpRequest request = ListVpnTunnelsHttpRequest.newBuilder()
   *     .setRegion(region.toString())
   *     .build();
   *   for (VpnTunnel element : vpnTunnelClient.listVpnTunnels(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListVpnTunnelsPagedResponse listVpnTunnels(ListVpnTunnelsHttpRequest request) {
    return listVpnTunnelsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of VpnTunnel resources contained in the specified project and region.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (VpnTunnelClient vpnTunnelClient = VpnTunnelClient.create()) {
   *   ProjectRegionName region = ProjectRegionName.of("[PROJECT]", "[REGION]");
   *   ListVpnTunnelsHttpRequest request = ListVpnTunnelsHttpRequest.newBuilder()
   *     .setRegion(region.toString())
   *     .build();
   *   ApiFuture&lt;ListVpnTunnelsPagedResponse&gt; future = vpnTunnelClient.listVpnTunnelsPagedCallable().futureCall(request);
   *   // Do something
   *   for (VpnTunnel element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<ListVpnTunnelsHttpRequest, ListVpnTunnelsPagedResponse>
      listVpnTunnelsPagedCallable() {
    return stub.listVpnTunnelsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of VpnTunnel resources contained in the specified project and region.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (VpnTunnelClient vpnTunnelClient = VpnTunnelClient.create()) {
   *   ProjectRegionName region = ProjectRegionName.of("[PROJECT]", "[REGION]");
   *   ListVpnTunnelsHttpRequest request = ListVpnTunnelsHttpRequest.newBuilder()
   *     .setRegion(region.toString())
   *     .build();
   *   while (true) {
   *     VpnTunnelList response = vpnTunnelClient.listVpnTunnelsCallable().call(request);
   *     for (VpnTunnel element : response.getItemsList()) {
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
  public final UnaryCallable<ListVpnTunnelsHttpRequest, VpnTunnelList> listVpnTunnelsCallable() {
    return stub.listVpnTunnelsCallable();
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

  public static class AggregatedListVpnTunnelsPagedResponse
      extends AbstractPagedListResponse<
          AggregatedListVpnTunnelsHttpRequest, VpnTunnelAggregatedList, VpnTunnelsScopedList,
          AggregatedListVpnTunnelsPage, AggregatedListVpnTunnelsFixedSizeCollection> {

    public static ApiFuture<AggregatedListVpnTunnelsPagedResponse> createAsync(
        PageContext<
                AggregatedListVpnTunnelsHttpRequest, VpnTunnelAggregatedList, VpnTunnelsScopedList>
            context,
        ApiFuture<VpnTunnelAggregatedList> futureResponse) {
      ApiFuture<AggregatedListVpnTunnelsPage> futurePage =
          AggregatedListVpnTunnelsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<AggregatedListVpnTunnelsPage, AggregatedListVpnTunnelsPagedResponse>() {
            @Override
            public AggregatedListVpnTunnelsPagedResponse apply(AggregatedListVpnTunnelsPage input) {
              return new AggregatedListVpnTunnelsPagedResponse(input);
            }
          });
    }

    private AggregatedListVpnTunnelsPagedResponse(AggregatedListVpnTunnelsPage page) {
      super(page, AggregatedListVpnTunnelsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class AggregatedListVpnTunnelsPage
      extends AbstractPage<
          AggregatedListVpnTunnelsHttpRequest, VpnTunnelAggregatedList, VpnTunnelsScopedList,
          AggregatedListVpnTunnelsPage> {

    private AggregatedListVpnTunnelsPage(
        PageContext<
                AggregatedListVpnTunnelsHttpRequest, VpnTunnelAggregatedList, VpnTunnelsScopedList>
            context,
        VpnTunnelAggregatedList response) {
      super(context, response);
    }

    private static AggregatedListVpnTunnelsPage createEmptyPage() {
      return new AggregatedListVpnTunnelsPage(null, null);
    }

    @Override
    protected AggregatedListVpnTunnelsPage createPage(
        PageContext<
                AggregatedListVpnTunnelsHttpRequest, VpnTunnelAggregatedList, VpnTunnelsScopedList>
            context,
        VpnTunnelAggregatedList response) {
      return new AggregatedListVpnTunnelsPage(context, response);
    }

    @Override
    public ApiFuture<AggregatedListVpnTunnelsPage> createPageAsync(
        PageContext<
                AggregatedListVpnTunnelsHttpRequest, VpnTunnelAggregatedList, VpnTunnelsScopedList>
            context,
        ApiFuture<VpnTunnelAggregatedList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class AggregatedListVpnTunnelsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          AggregatedListVpnTunnelsHttpRequest, VpnTunnelAggregatedList, VpnTunnelsScopedList,
          AggregatedListVpnTunnelsPage, AggregatedListVpnTunnelsFixedSizeCollection> {

    private AggregatedListVpnTunnelsFixedSizeCollection(
        List<AggregatedListVpnTunnelsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static AggregatedListVpnTunnelsFixedSizeCollection createEmptyCollection() {
      return new AggregatedListVpnTunnelsFixedSizeCollection(null, 0);
    }

    @Override
    protected AggregatedListVpnTunnelsFixedSizeCollection createCollection(
        List<AggregatedListVpnTunnelsPage> pages, int collectionSize) {
      return new AggregatedListVpnTunnelsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListVpnTunnelsPagedResponse
      extends AbstractPagedListResponse<
          ListVpnTunnelsHttpRequest, VpnTunnelList, VpnTunnel, ListVpnTunnelsPage,
          ListVpnTunnelsFixedSizeCollection> {

    public static ApiFuture<ListVpnTunnelsPagedResponse> createAsync(
        PageContext<ListVpnTunnelsHttpRequest, VpnTunnelList, VpnTunnel> context,
        ApiFuture<VpnTunnelList> futureResponse) {
      ApiFuture<ListVpnTunnelsPage> futurePage =
          ListVpnTunnelsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListVpnTunnelsPage, ListVpnTunnelsPagedResponse>() {
            @Override
            public ListVpnTunnelsPagedResponse apply(ListVpnTunnelsPage input) {
              return new ListVpnTunnelsPagedResponse(input);
            }
          });
    }

    private ListVpnTunnelsPagedResponse(ListVpnTunnelsPage page) {
      super(page, ListVpnTunnelsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListVpnTunnelsPage
      extends AbstractPage<
          ListVpnTunnelsHttpRequest, VpnTunnelList, VpnTunnel, ListVpnTunnelsPage> {

    private ListVpnTunnelsPage(
        PageContext<ListVpnTunnelsHttpRequest, VpnTunnelList, VpnTunnel> context,
        VpnTunnelList response) {
      super(context, response);
    }

    private static ListVpnTunnelsPage createEmptyPage() {
      return new ListVpnTunnelsPage(null, null);
    }

    @Override
    protected ListVpnTunnelsPage createPage(
        PageContext<ListVpnTunnelsHttpRequest, VpnTunnelList, VpnTunnel> context,
        VpnTunnelList response) {
      return new ListVpnTunnelsPage(context, response);
    }

    @Override
    public ApiFuture<ListVpnTunnelsPage> createPageAsync(
        PageContext<ListVpnTunnelsHttpRequest, VpnTunnelList, VpnTunnel> context,
        ApiFuture<VpnTunnelList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListVpnTunnelsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListVpnTunnelsHttpRequest, VpnTunnelList, VpnTunnel, ListVpnTunnelsPage,
          ListVpnTunnelsFixedSizeCollection> {

    private ListVpnTunnelsFixedSizeCollection(List<ListVpnTunnelsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListVpnTunnelsFixedSizeCollection createEmptyCollection() {
      return new ListVpnTunnelsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListVpnTunnelsFixedSizeCollection createCollection(
        List<ListVpnTunnelsPage> pages, int collectionSize) {
      return new ListVpnTunnelsFixedSizeCollection(pages, collectionSize);
    }
  }
}
