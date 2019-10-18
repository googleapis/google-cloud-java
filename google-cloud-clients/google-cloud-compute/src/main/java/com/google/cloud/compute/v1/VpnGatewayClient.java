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
import com.google.cloud.compute.v1.stub.VpnGatewayStub;
import com.google.cloud.compute.v1.stub.VpnGatewayStubSettings;
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
 * try (VpnGatewayClient vpnGatewayClient = VpnGatewayClient.create()) {
 *   ProjectRegionVpnGatewayName vpnGateway = ProjectRegionVpnGatewayName.of("[PROJECT]", "[REGION]", "[VPN_GATEWAY]");
 *   Operation response = vpnGatewayClient.deleteVpnGateway(vpnGateway);
 * }
 * </code>
 * </pre>
 *
 * <p>Note: close() needs to be called on the vpnGatewayClient object to clean up resources such as
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
 * <p>This class can be customized by passing in a custom instance of VpnGatewaySettings to
 * create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>
 * <code>
 * VpnGatewaySettings vpnGatewaySettings =
 *     VpnGatewaySettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * VpnGatewayClient vpnGatewayClient =
 *     VpnGatewayClient.create(vpnGatewaySettings);
 * </code>
 * </pre>
 *
 * To customize the endpoint:
 *
 * <pre>
 * <code>
 * VpnGatewaySettings vpnGatewaySettings =
 *     VpnGatewaySettings.newBuilder().setEndpoint(myEndpoint).build();
 * VpnGatewayClient vpnGatewayClient =
 *     VpnGatewayClient.create(vpnGatewaySettings);
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class VpnGatewayClient implements BackgroundResource {
  private final VpnGatewaySettings settings;
  private final VpnGatewayStub stub;

  /** Constructs an instance of VpnGatewayClient with default settings. */
  public static final VpnGatewayClient create() throws IOException {
    return create(VpnGatewaySettings.newBuilder().build());
  }

  /**
   * Constructs an instance of VpnGatewayClient, using the given settings. The channels are created
   * based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final VpnGatewayClient create(VpnGatewaySettings settings) throws IOException {
    return new VpnGatewayClient(settings);
  }

  /**
   * Constructs an instance of VpnGatewayClient, using the given stub for making calls. This is for
   * advanced usage - prefer to use VpnGatewaySettings}.
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final VpnGatewayClient create(VpnGatewayStub stub) {
    return new VpnGatewayClient(stub);
  }

  /**
   * Constructs an instance of VpnGatewayClient, using the given settings. This is protected so that
   * it is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected VpnGatewayClient(VpnGatewaySettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((VpnGatewayStubSettings) settings.getStubSettings()).createStub();
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected VpnGatewayClient(VpnGatewayStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final VpnGatewaySettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public VpnGatewayStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves an aggregated list of VPN gateways.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (VpnGatewayClient vpnGatewayClient = VpnGatewayClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   for (VpnGatewaysScopedList element : vpnGatewayClient.aggregatedListVpnGateways(project).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final AggregatedListVpnGatewaysPagedResponse aggregatedListVpnGateways(
      ProjectName project) {
    AggregatedListVpnGatewaysHttpRequest request =
        AggregatedListVpnGatewaysHttpRequest.newBuilder()
            .setProject(project == null ? null : project.toString())
            .build();
    return aggregatedListVpnGateways(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves an aggregated list of VPN gateways.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (VpnGatewayClient vpnGatewayClient = VpnGatewayClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   for (VpnGatewaysScopedList element : vpnGatewayClient.aggregatedListVpnGateways(project.toString()).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final AggregatedListVpnGatewaysPagedResponse aggregatedListVpnGateways(String project) {
    AggregatedListVpnGatewaysHttpRequest request =
        AggregatedListVpnGatewaysHttpRequest.newBuilder().setProject(project).build();
    return aggregatedListVpnGateways(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves an aggregated list of VPN gateways.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (VpnGatewayClient vpnGatewayClient = VpnGatewayClient.create()) {
   *   String formattedProject = ProjectName.format("[PROJECT]");
   *   AggregatedListVpnGatewaysHttpRequest request = AggregatedListVpnGatewaysHttpRequest.newBuilder()
   *     .setProject(formattedProject)
   *     .build();
   *   for (VpnGatewaysScopedList element : vpnGatewayClient.aggregatedListVpnGateways(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final AggregatedListVpnGatewaysPagedResponse aggregatedListVpnGateways(
      AggregatedListVpnGatewaysHttpRequest request) {
    return aggregatedListVpnGatewaysPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves an aggregated list of VPN gateways.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (VpnGatewayClient vpnGatewayClient = VpnGatewayClient.create()) {
   *   String formattedProject = ProjectName.format("[PROJECT]");
   *   AggregatedListVpnGatewaysHttpRequest request = AggregatedListVpnGatewaysHttpRequest.newBuilder()
   *     .setProject(formattedProject)
   *     .build();
   *   ApiFuture&lt;AggregatedListVpnGatewaysPagedResponse&gt; future = vpnGatewayClient.aggregatedListVpnGatewaysPagedCallable().futureCall(request);
   *   // Do something
   *   for (VpnGatewaysScopedList element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<
          AggregatedListVpnGatewaysHttpRequest, AggregatedListVpnGatewaysPagedResponse>
      aggregatedListVpnGatewaysPagedCallable() {
    return stub.aggregatedListVpnGatewaysPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves an aggregated list of VPN gateways.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (VpnGatewayClient vpnGatewayClient = VpnGatewayClient.create()) {
   *   String formattedProject = ProjectName.format("[PROJECT]");
   *   AggregatedListVpnGatewaysHttpRequest request = AggregatedListVpnGatewaysHttpRequest.newBuilder()
   *     .setProject(formattedProject)
   *     .build();
   *   while (true) {
   *     VpnGatewayAggregatedList response = vpnGatewayClient.aggregatedListVpnGatewaysCallable().call(request);
   *     for (VpnGatewaysScopedList element : response.getItemsMap()) {
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
  public final UnaryCallable<AggregatedListVpnGatewaysHttpRequest, VpnGatewayAggregatedList>
      aggregatedListVpnGatewaysCallable() {
    return stub.aggregatedListVpnGatewaysCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified VPN gateway.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (VpnGatewayClient vpnGatewayClient = VpnGatewayClient.create()) {
   *   ProjectRegionVpnGatewayName vpnGateway = ProjectRegionVpnGatewayName.of("[PROJECT]", "[REGION]", "[VPN_GATEWAY]");
   *   Operation response = vpnGatewayClient.deleteVpnGateway(vpnGateway);
   * }
   * </code></pre>
   *
   * @param vpnGateway Name of the VPN gateway to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation deleteVpnGateway(ProjectRegionVpnGatewayName vpnGateway) {

    DeleteVpnGatewayHttpRequest request =
        DeleteVpnGatewayHttpRequest.newBuilder()
            .setVpnGateway(vpnGateway == null ? null : vpnGateway.toString())
            .build();
    return deleteVpnGateway(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified VPN gateway.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (VpnGatewayClient vpnGatewayClient = VpnGatewayClient.create()) {
   *   ProjectRegionVpnGatewayName vpnGateway = ProjectRegionVpnGatewayName.of("[PROJECT]", "[REGION]", "[VPN_GATEWAY]");
   *   Operation response = vpnGatewayClient.deleteVpnGateway(vpnGateway.toString());
   * }
   * </code></pre>
   *
   * @param vpnGateway Name of the VPN gateway to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation deleteVpnGateway(String vpnGateway) {

    DeleteVpnGatewayHttpRequest request =
        DeleteVpnGatewayHttpRequest.newBuilder().setVpnGateway(vpnGateway).build();
    return deleteVpnGateway(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified VPN gateway.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (VpnGatewayClient vpnGatewayClient = VpnGatewayClient.create()) {
   *   String formattedVpnGateway = ProjectRegionVpnGatewayName.format("[PROJECT]", "[REGION]", "[VPN_GATEWAY]");
   *   DeleteVpnGatewayHttpRequest request = DeleteVpnGatewayHttpRequest.newBuilder()
   *     .setVpnGateway(formattedVpnGateway)
   *     .build();
   *   Operation response = vpnGatewayClient.deleteVpnGateway(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation deleteVpnGateway(DeleteVpnGatewayHttpRequest request) {
    return deleteVpnGatewayCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified VPN gateway.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (VpnGatewayClient vpnGatewayClient = VpnGatewayClient.create()) {
   *   String formattedVpnGateway = ProjectRegionVpnGatewayName.format("[PROJECT]", "[REGION]", "[VPN_GATEWAY]");
   *   DeleteVpnGatewayHttpRequest request = DeleteVpnGatewayHttpRequest.newBuilder()
   *     .setVpnGateway(formattedVpnGateway)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = vpnGatewayClient.deleteVpnGatewayCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<DeleteVpnGatewayHttpRequest, Operation> deleteVpnGatewayCallable() {
    return stub.deleteVpnGatewayCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified VPN gateway. Gets a list of available VPN gateways by making a list()
   * request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (VpnGatewayClient vpnGatewayClient = VpnGatewayClient.create()) {
   *   ProjectRegionVpnGatewayName vpnGateway = ProjectRegionVpnGatewayName.of("[PROJECT]", "[REGION]", "[VPN_GATEWAY]");
   *   VpnGateway response = vpnGatewayClient.getVpnGateway(vpnGateway);
   * }
   * </code></pre>
   *
   * @param vpnGateway Name of the VPN gateway to return.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final VpnGateway getVpnGateway(ProjectRegionVpnGatewayName vpnGateway) {

    GetVpnGatewayHttpRequest request =
        GetVpnGatewayHttpRequest.newBuilder()
            .setVpnGateway(vpnGateway == null ? null : vpnGateway.toString())
            .build();
    return getVpnGateway(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified VPN gateway. Gets a list of available VPN gateways by making a list()
   * request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (VpnGatewayClient vpnGatewayClient = VpnGatewayClient.create()) {
   *   ProjectRegionVpnGatewayName vpnGateway = ProjectRegionVpnGatewayName.of("[PROJECT]", "[REGION]", "[VPN_GATEWAY]");
   *   VpnGateway response = vpnGatewayClient.getVpnGateway(vpnGateway.toString());
   * }
   * </code></pre>
   *
   * @param vpnGateway Name of the VPN gateway to return.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final VpnGateway getVpnGateway(String vpnGateway) {

    GetVpnGatewayHttpRequest request =
        GetVpnGatewayHttpRequest.newBuilder().setVpnGateway(vpnGateway).build();
    return getVpnGateway(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified VPN gateway. Gets a list of available VPN gateways by making a list()
   * request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (VpnGatewayClient vpnGatewayClient = VpnGatewayClient.create()) {
   *   String formattedVpnGateway = ProjectRegionVpnGatewayName.format("[PROJECT]", "[REGION]", "[VPN_GATEWAY]");
   *   GetVpnGatewayHttpRequest request = GetVpnGatewayHttpRequest.newBuilder()
   *     .setVpnGateway(formattedVpnGateway)
   *     .build();
   *   VpnGateway response = vpnGatewayClient.getVpnGateway(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final VpnGateway getVpnGateway(GetVpnGatewayHttpRequest request) {
    return getVpnGatewayCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified VPN gateway. Gets a list of available VPN gateways by making a list()
   * request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (VpnGatewayClient vpnGatewayClient = VpnGatewayClient.create()) {
   *   String formattedVpnGateway = ProjectRegionVpnGatewayName.format("[PROJECT]", "[REGION]", "[VPN_GATEWAY]");
   *   GetVpnGatewayHttpRequest request = GetVpnGatewayHttpRequest.newBuilder()
   *     .setVpnGateway(formattedVpnGateway)
   *     .build();
   *   ApiFuture&lt;VpnGateway&gt; future = vpnGatewayClient.getVpnGatewayCallable().futureCall(request);
   *   // Do something
   *   VpnGateway response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<GetVpnGatewayHttpRequest, VpnGateway> getVpnGatewayCallable() {
    return stub.getVpnGatewayCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the status for the specified VPN gateway.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (VpnGatewayClient vpnGatewayClient = VpnGatewayClient.create()) {
   *   ProjectRegionVpnGatewayName vpnGateway = ProjectRegionVpnGatewayName.of("[PROJECT]", "[REGION]", "[VPN_GATEWAY]");
   *   VpnGatewaysGetStatusResponse response = vpnGatewayClient.getStatusVpnGateway(vpnGateway);
   * }
   * </code></pre>
   *
   * @param vpnGateway Name of the VPN gateway to return.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final VpnGatewaysGetStatusResponse getStatusVpnGateway(
      ProjectRegionVpnGatewayName vpnGateway) {

    GetStatusVpnGatewayHttpRequest request =
        GetStatusVpnGatewayHttpRequest.newBuilder()
            .setVpnGateway(vpnGateway == null ? null : vpnGateway.toString())
            .build();
    return getStatusVpnGateway(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the status for the specified VPN gateway.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (VpnGatewayClient vpnGatewayClient = VpnGatewayClient.create()) {
   *   ProjectRegionVpnGatewayName vpnGateway = ProjectRegionVpnGatewayName.of("[PROJECT]", "[REGION]", "[VPN_GATEWAY]");
   *   VpnGatewaysGetStatusResponse response = vpnGatewayClient.getStatusVpnGateway(vpnGateway.toString());
   * }
   * </code></pre>
   *
   * @param vpnGateway Name of the VPN gateway to return.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final VpnGatewaysGetStatusResponse getStatusVpnGateway(String vpnGateway) {

    GetStatusVpnGatewayHttpRequest request =
        GetStatusVpnGatewayHttpRequest.newBuilder().setVpnGateway(vpnGateway).build();
    return getStatusVpnGateway(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the status for the specified VPN gateway.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (VpnGatewayClient vpnGatewayClient = VpnGatewayClient.create()) {
   *   String formattedVpnGateway = ProjectRegionVpnGatewayName.format("[PROJECT]", "[REGION]", "[VPN_GATEWAY]");
   *   GetStatusVpnGatewayHttpRequest request = GetStatusVpnGatewayHttpRequest.newBuilder()
   *     .setVpnGateway(formattedVpnGateway)
   *     .build();
   *   VpnGatewaysGetStatusResponse response = vpnGatewayClient.getStatusVpnGateway(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final VpnGatewaysGetStatusResponse getStatusVpnGateway(
      GetStatusVpnGatewayHttpRequest request) {
    return getStatusVpnGatewayCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the status for the specified VPN gateway.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (VpnGatewayClient vpnGatewayClient = VpnGatewayClient.create()) {
   *   String formattedVpnGateway = ProjectRegionVpnGatewayName.format("[PROJECT]", "[REGION]", "[VPN_GATEWAY]");
   *   GetStatusVpnGatewayHttpRequest request = GetStatusVpnGatewayHttpRequest.newBuilder()
   *     .setVpnGateway(formattedVpnGateway)
   *     .build();
   *   ApiFuture&lt;VpnGatewaysGetStatusResponse&gt; future = vpnGatewayClient.getStatusVpnGatewayCallable().futureCall(request);
   *   // Do something
   *   VpnGatewaysGetStatusResponse response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<GetStatusVpnGatewayHttpRequest, VpnGatewaysGetStatusResponse>
      getStatusVpnGatewayCallable() {
    return stub.getStatusVpnGatewayCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a VPN gateway in the specified project and region using the data included in the
   * request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (VpnGatewayClient vpnGatewayClient = VpnGatewayClient.create()) {
   *   ProjectRegionName region = ProjectRegionName.of("[PROJECT]", "[REGION]");
   *   VpnGateway vpnGatewayResource = VpnGateway.newBuilder().build();
   *   Operation response = vpnGatewayClient.insertVpnGateway(region, vpnGatewayResource);
   * }
   * </code></pre>
   *
   * @param region Name of the region for this request.
   * @param vpnGatewayResource Represents a VPN gateway resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation insertVpnGateway(ProjectRegionName region, VpnGateway vpnGatewayResource) {

    InsertVpnGatewayHttpRequest request =
        InsertVpnGatewayHttpRequest.newBuilder()
            .setRegion(region == null ? null : region.toString())
            .setVpnGatewayResource(vpnGatewayResource)
            .build();
    return insertVpnGateway(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a VPN gateway in the specified project and region using the data included in the
   * request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (VpnGatewayClient vpnGatewayClient = VpnGatewayClient.create()) {
   *   ProjectRegionName region = ProjectRegionName.of("[PROJECT]", "[REGION]");
   *   VpnGateway vpnGatewayResource = VpnGateway.newBuilder().build();
   *   Operation response = vpnGatewayClient.insertVpnGateway(region.toString(), vpnGatewayResource);
   * }
   * </code></pre>
   *
   * @param region Name of the region for this request.
   * @param vpnGatewayResource Represents a VPN gateway resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation insertVpnGateway(String region, VpnGateway vpnGatewayResource) {

    InsertVpnGatewayHttpRequest request =
        InsertVpnGatewayHttpRequest.newBuilder()
            .setRegion(region)
            .setVpnGatewayResource(vpnGatewayResource)
            .build();
    return insertVpnGateway(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a VPN gateway in the specified project and region using the data included in the
   * request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (VpnGatewayClient vpnGatewayClient = VpnGatewayClient.create()) {
   *   String formattedRegion = ProjectRegionName.format("[PROJECT]", "[REGION]");
   *   VpnGateway vpnGatewayResource = VpnGateway.newBuilder().build();
   *   InsertVpnGatewayHttpRequest request = InsertVpnGatewayHttpRequest.newBuilder()
   *     .setRegion(formattedRegion)
   *     .setVpnGatewayResource(vpnGatewayResource)
   *     .build();
   *   Operation response = vpnGatewayClient.insertVpnGateway(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation insertVpnGateway(InsertVpnGatewayHttpRequest request) {
    return insertVpnGatewayCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a VPN gateway in the specified project and region using the data included in the
   * request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (VpnGatewayClient vpnGatewayClient = VpnGatewayClient.create()) {
   *   String formattedRegion = ProjectRegionName.format("[PROJECT]", "[REGION]");
   *   VpnGateway vpnGatewayResource = VpnGateway.newBuilder().build();
   *   InsertVpnGatewayHttpRequest request = InsertVpnGatewayHttpRequest.newBuilder()
   *     .setRegion(formattedRegion)
   *     .setVpnGatewayResource(vpnGatewayResource)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = vpnGatewayClient.insertVpnGatewayCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<InsertVpnGatewayHttpRequest, Operation> insertVpnGatewayCallable() {
    return stub.insertVpnGatewayCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of VPN gateways available to the specified project and region.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (VpnGatewayClient vpnGatewayClient = VpnGatewayClient.create()) {
   *   ProjectRegionName region = ProjectRegionName.of("[PROJECT]", "[REGION]");
   *   for (VpnGateway element : vpnGatewayClient.listVpnGateways(region).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param region Name of the region for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListVpnGatewaysPagedResponse listVpnGateways(ProjectRegionName region) {
    ListVpnGatewaysHttpRequest request =
        ListVpnGatewaysHttpRequest.newBuilder()
            .setRegion(region == null ? null : region.toString())
            .build();
    return listVpnGateways(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of VPN gateways available to the specified project and region.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (VpnGatewayClient vpnGatewayClient = VpnGatewayClient.create()) {
   *   ProjectRegionName region = ProjectRegionName.of("[PROJECT]", "[REGION]");
   *   for (VpnGateway element : vpnGatewayClient.listVpnGateways(region.toString()).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param region Name of the region for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListVpnGatewaysPagedResponse listVpnGateways(String region) {
    ListVpnGatewaysHttpRequest request =
        ListVpnGatewaysHttpRequest.newBuilder().setRegion(region).build();
    return listVpnGateways(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of VPN gateways available to the specified project and region.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (VpnGatewayClient vpnGatewayClient = VpnGatewayClient.create()) {
   *   String formattedRegion = ProjectRegionName.format("[PROJECT]", "[REGION]");
   *   ListVpnGatewaysHttpRequest request = ListVpnGatewaysHttpRequest.newBuilder()
   *     .setRegion(formattedRegion)
   *     .build();
   *   for (VpnGateway element : vpnGatewayClient.listVpnGateways(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListVpnGatewaysPagedResponse listVpnGateways(ListVpnGatewaysHttpRequest request) {
    return listVpnGatewaysPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of VPN gateways available to the specified project and region.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (VpnGatewayClient vpnGatewayClient = VpnGatewayClient.create()) {
   *   String formattedRegion = ProjectRegionName.format("[PROJECT]", "[REGION]");
   *   ListVpnGatewaysHttpRequest request = ListVpnGatewaysHttpRequest.newBuilder()
   *     .setRegion(formattedRegion)
   *     .build();
   *   ApiFuture&lt;ListVpnGatewaysPagedResponse&gt; future = vpnGatewayClient.listVpnGatewaysPagedCallable().futureCall(request);
   *   // Do something
   *   for (VpnGateway element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<ListVpnGatewaysHttpRequest, ListVpnGatewaysPagedResponse>
      listVpnGatewaysPagedCallable() {
    return stub.listVpnGatewaysPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of VPN gateways available to the specified project and region.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (VpnGatewayClient vpnGatewayClient = VpnGatewayClient.create()) {
   *   String formattedRegion = ProjectRegionName.format("[PROJECT]", "[REGION]");
   *   ListVpnGatewaysHttpRequest request = ListVpnGatewaysHttpRequest.newBuilder()
   *     .setRegion(formattedRegion)
   *     .build();
   *   while (true) {
   *     VpnGatewayList response = vpnGatewayClient.listVpnGatewaysCallable().call(request);
   *     for (VpnGateway element : response.getItemsList()) {
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
  public final UnaryCallable<ListVpnGatewaysHttpRequest, VpnGatewayList> listVpnGatewaysCallable() {
    return stub.listVpnGatewaysCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets the labels on a VpnGateway. To learn more about labels, read the Labeling Resources
   * documentation.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (VpnGatewayClient vpnGatewayClient = VpnGatewayClient.create()) {
   *   ProjectRegionVpnGatewayResourceName resource = ProjectRegionVpnGatewayResourceName.of("[PROJECT]", "[REGION]", "[RESOURCE]");
   *   RegionSetLabelsRequest regionSetLabelsRequestResource = RegionSetLabelsRequest.newBuilder().build();
   *   Operation response = vpnGatewayClient.setLabelsVpnGateway(resource, regionSetLabelsRequestResource);
   * }
   * </code></pre>
   *
   * @param resource Name or id of the resource for this request.
   * @param regionSetLabelsRequestResource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation setLabelsVpnGateway(
      ProjectRegionVpnGatewayResourceName resource,
      RegionSetLabelsRequest regionSetLabelsRequestResource) {

    SetLabelsVpnGatewayHttpRequest request =
        SetLabelsVpnGatewayHttpRequest.newBuilder()
            .setResource(resource == null ? null : resource.toString())
            .setRegionSetLabelsRequestResource(regionSetLabelsRequestResource)
            .build();
    return setLabelsVpnGateway(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets the labels on a VpnGateway. To learn more about labels, read the Labeling Resources
   * documentation.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (VpnGatewayClient vpnGatewayClient = VpnGatewayClient.create()) {
   *   ProjectRegionVpnGatewayResourceName resource = ProjectRegionVpnGatewayResourceName.of("[PROJECT]", "[REGION]", "[RESOURCE]");
   *   RegionSetLabelsRequest regionSetLabelsRequestResource = RegionSetLabelsRequest.newBuilder().build();
   *   Operation response = vpnGatewayClient.setLabelsVpnGateway(resource.toString(), regionSetLabelsRequestResource);
   * }
   * </code></pre>
   *
   * @param resource Name or id of the resource for this request.
   * @param regionSetLabelsRequestResource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation setLabelsVpnGateway(
      String resource, RegionSetLabelsRequest regionSetLabelsRequestResource) {

    SetLabelsVpnGatewayHttpRequest request =
        SetLabelsVpnGatewayHttpRequest.newBuilder()
            .setResource(resource)
            .setRegionSetLabelsRequestResource(regionSetLabelsRequestResource)
            .build();
    return setLabelsVpnGateway(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets the labels on a VpnGateway. To learn more about labels, read the Labeling Resources
   * documentation.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (VpnGatewayClient vpnGatewayClient = VpnGatewayClient.create()) {
   *   String formattedResource = ProjectRegionVpnGatewayResourceName.format("[PROJECT]", "[REGION]", "[RESOURCE]");
   *   RegionSetLabelsRequest regionSetLabelsRequestResource = RegionSetLabelsRequest.newBuilder().build();
   *   SetLabelsVpnGatewayHttpRequest request = SetLabelsVpnGatewayHttpRequest.newBuilder()
   *     .setResource(formattedResource)
   *     .setRegionSetLabelsRequestResource(regionSetLabelsRequestResource)
   *     .build();
   *   Operation response = vpnGatewayClient.setLabelsVpnGateway(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation setLabelsVpnGateway(SetLabelsVpnGatewayHttpRequest request) {
    return setLabelsVpnGatewayCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets the labels on a VpnGateway. To learn more about labels, read the Labeling Resources
   * documentation.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (VpnGatewayClient vpnGatewayClient = VpnGatewayClient.create()) {
   *   String formattedResource = ProjectRegionVpnGatewayResourceName.format("[PROJECT]", "[REGION]", "[RESOURCE]");
   *   RegionSetLabelsRequest regionSetLabelsRequestResource = RegionSetLabelsRequest.newBuilder().build();
   *   SetLabelsVpnGatewayHttpRequest request = SetLabelsVpnGatewayHttpRequest.newBuilder()
   *     .setResource(formattedResource)
   *     .setRegionSetLabelsRequestResource(regionSetLabelsRequestResource)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = vpnGatewayClient.setLabelsVpnGatewayCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<SetLabelsVpnGatewayHttpRequest, Operation>
      setLabelsVpnGatewayCallable() {
    return stub.setLabelsVpnGatewayCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns permissions that a caller has on the specified resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (VpnGatewayClient vpnGatewayClient = VpnGatewayClient.create()) {
   *   ProjectRegionVpnGatewayResourceName resource = ProjectRegionVpnGatewayResourceName.of("[PROJECT]", "[REGION]", "[RESOURCE]");
   *   TestPermissionsRequest testPermissionsRequestResource = TestPermissionsRequest.newBuilder().build();
   *   TestPermissionsResponse response = vpnGatewayClient.testIamPermissionsVpnGateway(resource, testPermissionsRequestResource);
   * }
   * </code></pre>
   *
   * @param resource Name or id of the resource for this request.
   * @param testPermissionsRequestResource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final TestPermissionsResponse testIamPermissionsVpnGateway(
      ProjectRegionVpnGatewayResourceName resource,
      TestPermissionsRequest testPermissionsRequestResource) {

    TestIamPermissionsVpnGatewayHttpRequest request =
        TestIamPermissionsVpnGatewayHttpRequest.newBuilder()
            .setResource(resource == null ? null : resource.toString())
            .setTestPermissionsRequestResource(testPermissionsRequestResource)
            .build();
    return testIamPermissionsVpnGateway(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns permissions that a caller has on the specified resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (VpnGatewayClient vpnGatewayClient = VpnGatewayClient.create()) {
   *   ProjectRegionVpnGatewayResourceName resource = ProjectRegionVpnGatewayResourceName.of("[PROJECT]", "[REGION]", "[RESOURCE]");
   *   TestPermissionsRequest testPermissionsRequestResource = TestPermissionsRequest.newBuilder().build();
   *   TestPermissionsResponse response = vpnGatewayClient.testIamPermissionsVpnGateway(resource.toString(), testPermissionsRequestResource);
   * }
   * </code></pre>
   *
   * @param resource Name or id of the resource for this request.
   * @param testPermissionsRequestResource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final TestPermissionsResponse testIamPermissionsVpnGateway(
      String resource, TestPermissionsRequest testPermissionsRequestResource) {

    TestIamPermissionsVpnGatewayHttpRequest request =
        TestIamPermissionsVpnGatewayHttpRequest.newBuilder()
            .setResource(resource)
            .setTestPermissionsRequestResource(testPermissionsRequestResource)
            .build();
    return testIamPermissionsVpnGateway(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns permissions that a caller has on the specified resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (VpnGatewayClient vpnGatewayClient = VpnGatewayClient.create()) {
   *   String formattedResource = ProjectRegionVpnGatewayResourceName.format("[PROJECT]", "[REGION]", "[RESOURCE]");
   *   TestPermissionsRequest testPermissionsRequestResource = TestPermissionsRequest.newBuilder().build();
   *   TestIamPermissionsVpnGatewayHttpRequest request = TestIamPermissionsVpnGatewayHttpRequest.newBuilder()
   *     .setResource(formattedResource)
   *     .setTestPermissionsRequestResource(testPermissionsRequestResource)
   *     .build();
   *   TestPermissionsResponse response = vpnGatewayClient.testIamPermissionsVpnGateway(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final TestPermissionsResponse testIamPermissionsVpnGateway(
      TestIamPermissionsVpnGatewayHttpRequest request) {
    return testIamPermissionsVpnGatewayCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns permissions that a caller has on the specified resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (VpnGatewayClient vpnGatewayClient = VpnGatewayClient.create()) {
   *   String formattedResource = ProjectRegionVpnGatewayResourceName.format("[PROJECT]", "[REGION]", "[RESOURCE]");
   *   TestPermissionsRequest testPermissionsRequestResource = TestPermissionsRequest.newBuilder().build();
   *   TestIamPermissionsVpnGatewayHttpRequest request = TestIamPermissionsVpnGatewayHttpRequest.newBuilder()
   *     .setResource(formattedResource)
   *     .setTestPermissionsRequestResource(testPermissionsRequestResource)
   *     .build();
   *   ApiFuture&lt;TestPermissionsResponse&gt; future = vpnGatewayClient.testIamPermissionsVpnGatewayCallable().futureCall(request);
   *   // Do something
   *   TestPermissionsResponse response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<TestIamPermissionsVpnGatewayHttpRequest, TestPermissionsResponse>
      testIamPermissionsVpnGatewayCallable() {
    return stub.testIamPermissionsVpnGatewayCallable();
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

  public static class AggregatedListVpnGatewaysPagedResponse
      extends AbstractPagedListResponse<
          AggregatedListVpnGatewaysHttpRequest,
          VpnGatewayAggregatedList,
          VpnGatewaysScopedList,
          AggregatedListVpnGatewaysPage,
          AggregatedListVpnGatewaysFixedSizeCollection> {

    public static ApiFuture<AggregatedListVpnGatewaysPagedResponse> createAsync(
        PageContext<
                AggregatedListVpnGatewaysHttpRequest,
                VpnGatewayAggregatedList,
                VpnGatewaysScopedList>
            context,
        ApiFuture<VpnGatewayAggregatedList> futureResponse) {
      ApiFuture<AggregatedListVpnGatewaysPage> futurePage =
          AggregatedListVpnGatewaysPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<AggregatedListVpnGatewaysPage, AggregatedListVpnGatewaysPagedResponse>() {
            @Override
            public AggregatedListVpnGatewaysPagedResponse apply(
                AggregatedListVpnGatewaysPage input) {
              return new AggregatedListVpnGatewaysPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
    }

    private AggregatedListVpnGatewaysPagedResponse(AggregatedListVpnGatewaysPage page) {
      super(page, AggregatedListVpnGatewaysFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class AggregatedListVpnGatewaysPage
      extends AbstractPage<
          AggregatedListVpnGatewaysHttpRequest,
          VpnGatewayAggregatedList,
          VpnGatewaysScopedList,
          AggregatedListVpnGatewaysPage> {

    private AggregatedListVpnGatewaysPage(
        PageContext<
                AggregatedListVpnGatewaysHttpRequest,
                VpnGatewayAggregatedList,
                VpnGatewaysScopedList>
            context,
        VpnGatewayAggregatedList response) {
      super(context, response);
    }

    private static AggregatedListVpnGatewaysPage createEmptyPage() {
      return new AggregatedListVpnGatewaysPage(null, null);
    }

    @Override
    protected AggregatedListVpnGatewaysPage createPage(
        PageContext<
                AggregatedListVpnGatewaysHttpRequest,
                VpnGatewayAggregatedList,
                VpnGatewaysScopedList>
            context,
        VpnGatewayAggregatedList response) {
      return new AggregatedListVpnGatewaysPage(context, response);
    }

    @Override
    public ApiFuture<AggregatedListVpnGatewaysPage> createPageAsync(
        PageContext<
                AggregatedListVpnGatewaysHttpRequest,
                VpnGatewayAggregatedList,
                VpnGatewaysScopedList>
            context,
        ApiFuture<VpnGatewayAggregatedList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class AggregatedListVpnGatewaysFixedSizeCollection
      extends AbstractFixedSizeCollection<
          AggregatedListVpnGatewaysHttpRequest,
          VpnGatewayAggregatedList,
          VpnGatewaysScopedList,
          AggregatedListVpnGatewaysPage,
          AggregatedListVpnGatewaysFixedSizeCollection> {

    private AggregatedListVpnGatewaysFixedSizeCollection(
        List<AggregatedListVpnGatewaysPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static AggregatedListVpnGatewaysFixedSizeCollection createEmptyCollection() {
      return new AggregatedListVpnGatewaysFixedSizeCollection(null, 0);
    }

    @Override
    protected AggregatedListVpnGatewaysFixedSizeCollection createCollection(
        List<AggregatedListVpnGatewaysPage> pages, int collectionSize) {
      return new AggregatedListVpnGatewaysFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListVpnGatewaysPagedResponse
      extends AbstractPagedListResponse<
          ListVpnGatewaysHttpRequest,
          VpnGatewayList,
          VpnGateway,
          ListVpnGatewaysPage,
          ListVpnGatewaysFixedSizeCollection> {

    public static ApiFuture<ListVpnGatewaysPagedResponse> createAsync(
        PageContext<ListVpnGatewaysHttpRequest, VpnGatewayList, VpnGateway> context,
        ApiFuture<VpnGatewayList> futureResponse) {
      ApiFuture<ListVpnGatewaysPage> futurePage =
          ListVpnGatewaysPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListVpnGatewaysPage, ListVpnGatewaysPagedResponse>() {
            @Override
            public ListVpnGatewaysPagedResponse apply(ListVpnGatewaysPage input) {
              return new ListVpnGatewaysPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
    }

    private ListVpnGatewaysPagedResponse(ListVpnGatewaysPage page) {
      super(page, ListVpnGatewaysFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListVpnGatewaysPage
      extends AbstractPage<
          ListVpnGatewaysHttpRequest, VpnGatewayList, VpnGateway, ListVpnGatewaysPage> {

    private ListVpnGatewaysPage(
        PageContext<ListVpnGatewaysHttpRequest, VpnGatewayList, VpnGateway> context,
        VpnGatewayList response) {
      super(context, response);
    }

    private static ListVpnGatewaysPage createEmptyPage() {
      return new ListVpnGatewaysPage(null, null);
    }

    @Override
    protected ListVpnGatewaysPage createPage(
        PageContext<ListVpnGatewaysHttpRequest, VpnGatewayList, VpnGateway> context,
        VpnGatewayList response) {
      return new ListVpnGatewaysPage(context, response);
    }

    @Override
    public ApiFuture<ListVpnGatewaysPage> createPageAsync(
        PageContext<ListVpnGatewaysHttpRequest, VpnGatewayList, VpnGateway> context,
        ApiFuture<VpnGatewayList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListVpnGatewaysFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListVpnGatewaysHttpRequest,
          VpnGatewayList,
          VpnGateway,
          ListVpnGatewaysPage,
          ListVpnGatewaysFixedSizeCollection> {

    private ListVpnGatewaysFixedSizeCollection(
        List<ListVpnGatewaysPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListVpnGatewaysFixedSizeCollection createEmptyCollection() {
      return new ListVpnGatewaysFixedSizeCollection(null, 0);
    }

    @Override
    protected ListVpnGatewaysFixedSizeCollection createCollection(
        List<ListVpnGatewaysPage> pages, int collectionSize) {
      return new ListVpnGatewaysFixedSizeCollection(pages, collectionSize);
    }
  }
}
