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
import com.google.cloud.compute.v1.stub.VpnGatewaysStub;
import com.google.cloud.compute.v1.stub.VpnGatewaysStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.util.List;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND SERVICE
/**
 * Service Description: The VpnGateways API.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>
 * <code>
 * try (VpnGatewaysClient vpnGatewaysClient = VpnGatewaysClient.create()) {
 *   String project = "";
 *   String region = "";
 *   String vpnGateway = "";
 *   Operation response = vpnGatewaysClient.delete(project, region, vpnGateway);
 * }
 * </code>
 * </pre>
 *
 * <p>Note: close() needs to be called on the vpnGatewaysClient object to clean up resources such as
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
 * <p>This class can be customized by passing in a custom instance of VpnGatewaysSettings to
 * create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>
 * <code>
 * VpnGatewaysSettings vpnGatewaysSettings =
 *     VpnGatewaysSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * VpnGatewaysClient vpnGatewaysClient =
 *     VpnGatewaysClient.create(vpnGatewaysSettings);
 * </code>
 * </pre>
 *
 * To customize the endpoint:
 *
 * <pre>
 * <code>
 * VpnGatewaysSettings vpnGatewaysSettings =
 *     VpnGatewaysSettings.newBuilder().setEndpoint(myEndpoint).build();
 * VpnGatewaysClient vpnGatewaysClient =
 *     VpnGatewaysClient.create(vpnGatewaysSettings);
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class VpnGatewaysClient implements BackgroundResource {
  private final VpnGatewaysSettings settings;
  private final VpnGatewaysStub stub;

  /** Constructs an instance of VpnGatewaysClient with default settings. */
  public static final VpnGatewaysClient create() throws IOException {
    return create(VpnGatewaysSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of VpnGatewaysClient, using the given settings. The channels are created
   * based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final VpnGatewaysClient create(VpnGatewaysSettings settings) throws IOException {
    return new VpnGatewaysClient(settings);
  }

  /**
   * Constructs an instance of VpnGatewaysClient, using the given stub for making calls. This is for
   * advanced usage - prefer to use VpnGatewaysSettings}.
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final VpnGatewaysClient create(VpnGatewaysStub stub) {
    return new VpnGatewaysClient(stub);
  }

  /**
   * Constructs an instance of VpnGatewaysClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected VpnGatewaysClient(VpnGatewaysSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((VpnGatewaysStubSettings) settings.getStubSettings()).createStub();
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected VpnGatewaysClient(VpnGatewaysStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final VpnGatewaysSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public VpnGatewaysStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves an aggregated list of VPN gateways.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (VpnGatewaysClient vpnGatewaysClient = VpnGatewaysClient.create()) {
   *   String project = "";
   *   for (Entry&lt;String, VpnGatewaysScopedList&gt; element : vpnGatewaysClient.aggregatedList(project).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AggregatedListPagedResponse aggregatedList(String project) {
    AggregatedListVpnGatewaysRequest request =
        AggregatedListVpnGatewaysRequest.newBuilder().setProject(project).build();
    return aggregatedList(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves an aggregated list of VPN gateways.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (VpnGatewaysClient vpnGatewaysClient = VpnGatewaysClient.create()) {
   *   String project = "";
   *   AggregatedListVpnGatewaysRequest request = AggregatedListVpnGatewaysRequest.newBuilder()
   *     .setProject(project)
   *     .build();
   *   for (Entry&lt;String, VpnGatewaysScopedList&gt; element : vpnGatewaysClient.aggregatedList(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AggregatedListPagedResponse aggregatedList(
      AggregatedListVpnGatewaysRequest request) {
    return aggregatedListPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves an aggregated list of VPN gateways.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (VpnGatewaysClient vpnGatewaysClient = VpnGatewaysClient.create()) {
   *   String project = "";
   *   AggregatedListVpnGatewaysRequest request = AggregatedListVpnGatewaysRequest.newBuilder()
   *     .setProject(project)
   *     .build();
   *   ApiFuture&lt;AggregatedListPagedResponse&gt; future = vpnGatewaysClient.aggregatedListPagedCallable().futureCall(request);
   *   // Do something
   *   for (Entry&lt;String, VpnGatewaysScopedList&gt; element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  public final UnaryCallable<AggregatedListVpnGatewaysRequest, AggregatedListPagedResponse>
      aggregatedListPagedCallable() {
    return stub.aggregatedListPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves an aggregated list of VPN gateways.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (VpnGatewaysClient vpnGatewaysClient = VpnGatewaysClient.create()) {
   *   String project = "";
   *   AggregatedListVpnGatewaysRequest request = AggregatedListVpnGatewaysRequest.newBuilder()
   *     .setProject(project)
   *     .build();
   *   while (true) {
   *     VpnGatewayAggregatedList response = vpnGatewaysClient.aggregatedListCallable().call(request);
   *     for (Entry&lt;String, VpnGatewaysScopedList&gt; element : response.getItemsMap()) {
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
  public final UnaryCallable<AggregatedListVpnGatewaysRequest, VpnGatewayAggregatedList>
      aggregatedListCallable() {
    return stub.aggregatedListCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified VPN gateway.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (VpnGatewaysClient vpnGatewaysClient = VpnGatewaysClient.create()) {
   *   String project = "";
   *   String region = "";
   *   String vpnGateway = "";
   *   Operation response = vpnGatewaysClient.delete(project, region, vpnGateway);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region for this request.
   * @param vpnGateway Name of the VPN gateway to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation delete(String project, String region, String vpnGateway) {
    DeleteVpnGatewayRequest request =
        DeleteVpnGatewayRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setVpnGateway(vpnGateway)
            .build();
    return delete(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified VPN gateway.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (VpnGatewaysClient vpnGatewaysClient = VpnGatewaysClient.create()) {
   *   String project = "";
   *   String region = "";
   *   String vpnGateway = "";
   *   DeleteVpnGatewayRequest request = DeleteVpnGatewayRequest.newBuilder()
   *     .setProject(project)
   *     .setRegion(region)
   *     .setVpnGateway(vpnGateway)
   *     .build();
   *   Operation response = vpnGatewaysClient.delete(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation delete(DeleteVpnGatewayRequest request) {
    return deleteCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified VPN gateway.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (VpnGatewaysClient vpnGatewaysClient = VpnGatewaysClient.create()) {
   *   String project = "";
   *   String region = "";
   *   String vpnGateway = "";
   *   DeleteVpnGatewayRequest request = DeleteVpnGatewayRequest.newBuilder()
   *     .setProject(project)
   *     .setRegion(region)
   *     .setVpnGateway(vpnGateway)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = vpnGatewaysClient.deleteCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<DeleteVpnGatewayRequest, Operation> deleteCallable() {
    return stub.deleteCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified VPN gateway. Gets a list of available VPN gateways by making a list()
   * request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (VpnGatewaysClient vpnGatewaysClient = VpnGatewaysClient.create()) {
   *   String project = "";
   *   String region = "";
   *   String vpnGateway = "";
   *   VpnGateway response = vpnGatewaysClient.get(project, region, vpnGateway);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region for this request.
   * @param vpnGateway Name of the VPN gateway to return.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final VpnGateway get(String project, String region, String vpnGateway) {
    GetVpnGatewayRequest request =
        GetVpnGatewayRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setVpnGateway(vpnGateway)
            .build();
    return get(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified VPN gateway. Gets a list of available VPN gateways by making a list()
   * request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (VpnGatewaysClient vpnGatewaysClient = VpnGatewaysClient.create()) {
   *   String project = "";
   *   String region = "";
   *   String vpnGateway = "";
   *   GetVpnGatewayRequest request = GetVpnGatewayRequest.newBuilder()
   *     .setProject(project)
   *     .setRegion(region)
   *     .setVpnGateway(vpnGateway)
   *     .build();
   *   VpnGateway response = vpnGatewaysClient.get(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final VpnGateway get(GetVpnGatewayRequest request) {
    return getCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified VPN gateway. Gets a list of available VPN gateways by making a list()
   * request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (VpnGatewaysClient vpnGatewaysClient = VpnGatewaysClient.create()) {
   *   String project = "";
   *   String region = "";
   *   String vpnGateway = "";
   *   GetVpnGatewayRequest request = GetVpnGatewayRequest.newBuilder()
   *     .setProject(project)
   *     .setRegion(region)
   *     .setVpnGateway(vpnGateway)
   *     .build();
   *   ApiFuture&lt;VpnGateway&gt; future = vpnGatewaysClient.getCallable().futureCall(request);
   *   // Do something
   *   VpnGateway response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<GetVpnGatewayRequest, VpnGateway> getCallable() {
    return stub.getCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the status for the specified VPN gateway.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (VpnGatewaysClient vpnGatewaysClient = VpnGatewaysClient.create()) {
   *   String project = "";
   *   String region = "";
   *   String vpnGateway = "";
   *   VpnGatewaysGetStatusResponse response = vpnGatewaysClient.getStatus(project, region, vpnGateway);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region for this request.
   * @param vpnGateway Name of the VPN gateway to return.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final VpnGatewaysGetStatusResponse getStatus(
      String project, String region, String vpnGateway) {
    GetStatusVpnGatewayRequest request =
        GetStatusVpnGatewayRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setVpnGateway(vpnGateway)
            .build();
    return getStatus(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the status for the specified VPN gateway.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (VpnGatewaysClient vpnGatewaysClient = VpnGatewaysClient.create()) {
   *   String project = "";
   *   String region = "";
   *   String vpnGateway = "";
   *   GetStatusVpnGatewayRequest request = GetStatusVpnGatewayRequest.newBuilder()
   *     .setProject(project)
   *     .setRegion(region)
   *     .setVpnGateway(vpnGateway)
   *     .build();
   *   VpnGatewaysGetStatusResponse response = vpnGatewaysClient.getStatus(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final VpnGatewaysGetStatusResponse getStatus(GetStatusVpnGatewayRequest request) {
    return getStatusCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the status for the specified VPN gateway.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (VpnGatewaysClient vpnGatewaysClient = VpnGatewaysClient.create()) {
   *   String project = "";
   *   String region = "";
   *   String vpnGateway = "";
   *   GetStatusVpnGatewayRequest request = GetStatusVpnGatewayRequest.newBuilder()
   *     .setProject(project)
   *     .setRegion(region)
   *     .setVpnGateway(vpnGateway)
   *     .build();
   *   ApiFuture&lt;VpnGatewaysGetStatusResponse&gt; future = vpnGatewaysClient.getStatusCallable().futureCall(request);
   *   // Do something
   *   VpnGatewaysGetStatusResponse response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<GetStatusVpnGatewayRequest, VpnGatewaysGetStatusResponse>
      getStatusCallable() {
    return stub.getStatusCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a VPN gateway in the specified project and region using the data included in the
   * request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (VpnGatewaysClient vpnGatewaysClient = VpnGatewaysClient.create()) {
   *   String project = "";
   *   String region = "";
   *   VpnGateway vpnGatewayResource = VpnGateway.newBuilder().build();
   *   Operation response = vpnGatewaysClient.insert(project, region, vpnGatewayResource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region for this request.
   * @param vpnGatewayResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation insert(String project, String region, VpnGateway vpnGatewayResource) {
    InsertVpnGatewayRequest request =
        InsertVpnGatewayRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setVpnGatewayResource(vpnGatewayResource)
            .build();
    return insert(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a VPN gateway in the specified project and region using the data included in the
   * request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (VpnGatewaysClient vpnGatewaysClient = VpnGatewaysClient.create()) {
   *   String project = "";
   *   String region = "";
   *   VpnGateway vpnGatewayResource = VpnGateway.newBuilder().build();
   *   InsertVpnGatewayRequest request = InsertVpnGatewayRequest.newBuilder()
   *     .setProject(project)
   *     .setRegion(region)
   *     .setVpnGatewayResource(vpnGatewayResource)
   *     .build();
   *   Operation response = vpnGatewaysClient.insert(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation insert(InsertVpnGatewayRequest request) {
    return insertCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a VPN gateway in the specified project and region using the data included in the
   * request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (VpnGatewaysClient vpnGatewaysClient = VpnGatewaysClient.create()) {
   *   String project = "";
   *   String region = "";
   *   VpnGateway vpnGatewayResource = VpnGateway.newBuilder().build();
   *   InsertVpnGatewayRequest request = InsertVpnGatewayRequest.newBuilder()
   *     .setProject(project)
   *     .setRegion(region)
   *     .setVpnGatewayResource(vpnGatewayResource)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = vpnGatewaysClient.insertCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<InsertVpnGatewayRequest, Operation> insertCallable() {
    return stub.insertCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of VPN gateways available to the specified project and region.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (VpnGatewaysClient vpnGatewaysClient = VpnGatewaysClient.create()) {
   *   String project = "";
   *   String region = "";
   *   for (VpnGateway element : vpnGatewaysClient.list(project, region).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPagedResponse list(String project, String region) {
    ListVpnGatewaysRequest request =
        ListVpnGatewaysRequest.newBuilder().setProject(project).setRegion(region).build();
    return list(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of VPN gateways available to the specified project and region.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (VpnGatewaysClient vpnGatewaysClient = VpnGatewaysClient.create()) {
   *   String project = "";
   *   String region = "";
   *   ListVpnGatewaysRequest request = ListVpnGatewaysRequest.newBuilder()
   *     .setProject(project)
   *     .setRegion(region)
   *     .build();
   *   for (VpnGateway element : vpnGatewaysClient.list(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPagedResponse list(ListVpnGatewaysRequest request) {
    return listPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of VPN gateways available to the specified project and region.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (VpnGatewaysClient vpnGatewaysClient = VpnGatewaysClient.create()) {
   *   String project = "";
   *   String region = "";
   *   ListVpnGatewaysRequest request = ListVpnGatewaysRequest.newBuilder()
   *     .setProject(project)
   *     .setRegion(region)
   *     .build();
   *   ApiFuture&lt;ListPagedResponse&gt; future = vpnGatewaysClient.listPagedCallable().futureCall(request);
   *   // Do something
   *   for (VpnGateway element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  public final UnaryCallable<ListVpnGatewaysRequest, ListPagedResponse> listPagedCallable() {
    return stub.listPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of VPN gateways available to the specified project and region.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (VpnGatewaysClient vpnGatewaysClient = VpnGatewaysClient.create()) {
   *   String project = "";
   *   String region = "";
   *   ListVpnGatewaysRequest request = ListVpnGatewaysRequest.newBuilder()
   *     .setProject(project)
   *     .setRegion(region)
   *     .build();
   *   while (true) {
   *     VpnGatewayList response = vpnGatewaysClient.listCallable().call(request);
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
  public final UnaryCallable<ListVpnGatewaysRequest, VpnGatewayList> listCallable() {
    return stub.listCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets the labels on a VpnGateway. To learn more about labels, read the Labeling Resources
   * documentation.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (VpnGatewaysClient vpnGatewaysClient = VpnGatewaysClient.create()) {
   *   String project = "";
   *   String region = "";
   *   String resource = "";
   *   RegionSetLabelsRequest regionSetLabelsRequestResource = RegionSetLabelsRequest.newBuilder().build();
   *   Operation response = vpnGatewaysClient.setLabels(project, region, resource, regionSetLabelsRequestResource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param region The region for this request.
   * @param resource Name or id of the resource for this request.
   * @param regionSetLabelsRequestResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation setLabels(
      String project,
      String region,
      String resource,
      RegionSetLabelsRequest regionSetLabelsRequestResource) {
    SetLabelsVpnGatewayRequest request =
        SetLabelsVpnGatewayRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setResource(resource)
            .setRegionSetLabelsRequestResource(regionSetLabelsRequestResource)
            .build();
    return setLabels(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets the labels on a VpnGateway. To learn more about labels, read the Labeling Resources
   * documentation.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (VpnGatewaysClient vpnGatewaysClient = VpnGatewaysClient.create()) {
   *   String project = "";
   *   String region = "";
   *   RegionSetLabelsRequest regionSetLabelsRequestResource = RegionSetLabelsRequest.newBuilder().build();
   *   String resource = "";
   *   SetLabelsVpnGatewayRequest request = SetLabelsVpnGatewayRequest.newBuilder()
   *     .setProject(project)
   *     .setRegion(region)
   *     .setRegionSetLabelsRequestResource(regionSetLabelsRequestResource)
   *     .setResource(resource)
   *     .build();
   *   Operation response = vpnGatewaysClient.setLabels(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation setLabels(SetLabelsVpnGatewayRequest request) {
    return setLabelsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets the labels on a VpnGateway. To learn more about labels, read the Labeling Resources
   * documentation.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (VpnGatewaysClient vpnGatewaysClient = VpnGatewaysClient.create()) {
   *   String project = "";
   *   String region = "";
   *   RegionSetLabelsRequest regionSetLabelsRequestResource = RegionSetLabelsRequest.newBuilder().build();
   *   String resource = "";
   *   SetLabelsVpnGatewayRequest request = SetLabelsVpnGatewayRequest.newBuilder()
   *     .setProject(project)
   *     .setRegion(region)
   *     .setRegionSetLabelsRequestResource(regionSetLabelsRequestResource)
   *     .setResource(resource)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = vpnGatewaysClient.setLabelsCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<SetLabelsVpnGatewayRequest, Operation> setLabelsCallable() {
    return stub.setLabelsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns permissions that a caller has on the specified resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (VpnGatewaysClient vpnGatewaysClient = VpnGatewaysClient.create()) {
   *   String project = "";
   *   String region = "";
   *   String resource = "";
   *   TestPermissionsRequest testPermissionsRequestResource = TestPermissionsRequest.newBuilder().build();
   *   TestPermissionsResponse response = vpnGatewaysClient.testIamPermissions(project, region, resource, testPermissionsRequestResource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param region The name of the region for this request.
   * @param resource Name or id of the resource for this request.
   * @param testPermissionsRequestResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TestPermissionsResponse testIamPermissions(
      String project,
      String region,
      String resource,
      TestPermissionsRequest testPermissionsRequestResource) {
    TestIamPermissionsVpnGatewayRequest request =
        TestIamPermissionsVpnGatewayRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
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
   * try (VpnGatewaysClient vpnGatewaysClient = VpnGatewaysClient.create()) {
   *   String project = "";
   *   String region = "";
   *   String resource = "";
   *   TestPermissionsRequest testPermissionsRequestResource = TestPermissionsRequest.newBuilder().build();
   *   TestIamPermissionsVpnGatewayRequest request = TestIamPermissionsVpnGatewayRequest.newBuilder()
   *     .setProject(project)
   *     .setRegion(region)
   *     .setResource(resource)
   *     .setTestPermissionsRequestResource(testPermissionsRequestResource)
   *     .build();
   *   TestPermissionsResponse response = vpnGatewaysClient.testIamPermissions(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TestPermissionsResponse testIamPermissions(
      TestIamPermissionsVpnGatewayRequest request) {
    return testIamPermissionsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns permissions that a caller has on the specified resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (VpnGatewaysClient vpnGatewaysClient = VpnGatewaysClient.create()) {
   *   String project = "";
   *   String region = "";
   *   String resource = "";
   *   TestPermissionsRequest testPermissionsRequestResource = TestPermissionsRequest.newBuilder().build();
   *   TestIamPermissionsVpnGatewayRequest request = TestIamPermissionsVpnGatewayRequest.newBuilder()
   *     .setProject(project)
   *     .setRegion(region)
   *     .setResource(resource)
   *     .setTestPermissionsRequestResource(testPermissionsRequestResource)
   *     .build();
   *   ApiFuture&lt;TestPermissionsResponse&gt; future = vpnGatewaysClient.testIamPermissionsCallable().futureCall(request);
   *   // Do something
   *   TestPermissionsResponse response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<TestIamPermissionsVpnGatewayRequest, TestPermissionsResponse>
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
          AggregatedListVpnGatewaysRequest,
          VpnGatewayAggregatedList,
          Entry<String, VpnGatewaysScopedList>,
          AggregatedListPage,
          AggregatedListFixedSizeCollection> {

    public static ApiFuture<AggregatedListPagedResponse> createAsync(
        PageContext<
                AggregatedListVpnGatewaysRequest,
                VpnGatewayAggregatedList,
                Entry<String, VpnGatewaysScopedList>>
            context,
        ApiFuture<VpnGatewayAggregatedList> futureResponse) {
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
          AggregatedListVpnGatewaysRequest,
          VpnGatewayAggregatedList,
          Entry<String, VpnGatewaysScopedList>,
          AggregatedListPage> {

    private AggregatedListPage(
        PageContext<
                AggregatedListVpnGatewaysRequest,
                VpnGatewayAggregatedList,
                Entry<String, VpnGatewaysScopedList>>
            context,
        VpnGatewayAggregatedList response) {
      super(context, response);
    }

    private static AggregatedListPage createEmptyPage() {
      return new AggregatedListPage(null, null);
    }

    @Override
    protected AggregatedListPage createPage(
        PageContext<
                AggregatedListVpnGatewaysRequest,
                VpnGatewayAggregatedList,
                Entry<String, VpnGatewaysScopedList>>
            context,
        VpnGatewayAggregatedList response) {
      return new AggregatedListPage(context, response);
    }

    @Override
    public ApiFuture<AggregatedListPage> createPageAsync(
        PageContext<
                AggregatedListVpnGatewaysRequest,
                VpnGatewayAggregatedList,
                Entry<String, VpnGatewaysScopedList>>
            context,
        ApiFuture<VpnGatewayAggregatedList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class AggregatedListFixedSizeCollection
      extends AbstractFixedSizeCollection<
          AggregatedListVpnGatewaysRequest,
          VpnGatewayAggregatedList,
          Entry<String, VpnGatewaysScopedList>,
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
          ListVpnGatewaysRequest, VpnGatewayList, VpnGateway, ListPage, ListFixedSizeCollection> {

    public static ApiFuture<ListPagedResponse> createAsync(
        PageContext<ListVpnGatewaysRequest, VpnGatewayList, VpnGateway> context,
        ApiFuture<VpnGatewayList> futureResponse) {
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
      extends AbstractPage<ListVpnGatewaysRequest, VpnGatewayList, VpnGateway, ListPage> {

    private ListPage(
        PageContext<ListVpnGatewaysRequest, VpnGatewayList, VpnGateway> context,
        VpnGatewayList response) {
      super(context, response);
    }

    private static ListPage createEmptyPage() {
      return new ListPage(null, null);
    }

    @Override
    protected ListPage createPage(
        PageContext<ListVpnGatewaysRequest, VpnGatewayList, VpnGateway> context,
        VpnGatewayList response) {
      return new ListPage(context, response);
    }

    @Override
    public ApiFuture<ListPage> createPageAsync(
        PageContext<ListVpnGatewaysRequest, VpnGatewayList, VpnGateway> context,
        ApiFuture<VpnGatewayList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListVpnGatewaysRequest, VpnGatewayList, VpnGateway, ListPage, ListFixedSizeCollection> {

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
