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
import com.google.cloud.compute.v1.stub.VpnTunnelsStub;
import com.google.cloud.compute.v1.stub.VpnTunnelsStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.util.List;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND SERVICE
/**
 * Service Description: The VpnTunnels API.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>
 * <code>
 * try (VpnTunnelsClient vpnTunnelsClient = VpnTunnelsClient.create()) {
 *   String project = "";
 *   String region = "";
 *   String vpnTunnel = "";
 *   Operation response = vpnTunnelsClient.delete(project, region, vpnTunnel);
 * }
 * </code>
 * </pre>
 *
 * <p>Note: close() needs to be called on the vpnTunnelsClient object to clean up resources such as
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
 * <p>This class can be customized by passing in a custom instance of VpnTunnelsSettings to
 * create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>
 * <code>
 * VpnTunnelsSettings vpnTunnelsSettings =
 *     VpnTunnelsSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * VpnTunnelsClient vpnTunnelsClient =
 *     VpnTunnelsClient.create(vpnTunnelsSettings);
 * </code>
 * </pre>
 *
 * To customize the endpoint:
 *
 * <pre>
 * <code>
 * VpnTunnelsSettings vpnTunnelsSettings =
 *     VpnTunnelsSettings.newBuilder().setEndpoint(myEndpoint).build();
 * VpnTunnelsClient vpnTunnelsClient =
 *     VpnTunnelsClient.create(vpnTunnelsSettings);
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class VpnTunnelsClient implements BackgroundResource {
  private final VpnTunnelsSettings settings;
  private final VpnTunnelsStub stub;

  /** Constructs an instance of VpnTunnelsClient with default settings. */
  public static final VpnTunnelsClient create() throws IOException {
    return create(VpnTunnelsSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of VpnTunnelsClient, using the given settings. The channels are created
   * based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final VpnTunnelsClient create(VpnTunnelsSettings settings) throws IOException {
    return new VpnTunnelsClient(settings);
  }

  /**
   * Constructs an instance of VpnTunnelsClient, using the given stub for making calls. This is for
   * advanced usage - prefer to use VpnTunnelsSettings}.
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final VpnTunnelsClient create(VpnTunnelsStub stub) {
    return new VpnTunnelsClient(stub);
  }

  /**
   * Constructs an instance of VpnTunnelsClient, using the given settings. This is protected so that
   * it is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected VpnTunnelsClient(VpnTunnelsSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((VpnTunnelsStubSettings) settings.getStubSettings()).createStub();
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected VpnTunnelsClient(VpnTunnelsStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final VpnTunnelsSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public VpnTunnelsStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves an aggregated list of VPN tunnels.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (VpnTunnelsClient vpnTunnelsClient = VpnTunnelsClient.create()) {
   *   String project = "";
   *   for (Entry&lt;String, VpnTunnelsScopedList&gt; element : vpnTunnelsClient.aggregatedList(project).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AggregatedListPagedResponse aggregatedList(String project) {
    AggregatedListVpnTunnelsRequest request =
        AggregatedListVpnTunnelsRequest.newBuilder().setProject(project).build();
    return aggregatedList(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves an aggregated list of VPN tunnels.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (VpnTunnelsClient vpnTunnelsClient = VpnTunnelsClient.create()) {
   *   String project = "";
   *   AggregatedListVpnTunnelsRequest request = AggregatedListVpnTunnelsRequest.newBuilder()
   *     .setProject(project)
   *     .build();
   *   for (Entry&lt;String, VpnTunnelsScopedList&gt; element : vpnTunnelsClient.aggregatedList(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AggregatedListPagedResponse aggregatedList(AggregatedListVpnTunnelsRequest request) {
    return aggregatedListPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves an aggregated list of VPN tunnels.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (VpnTunnelsClient vpnTunnelsClient = VpnTunnelsClient.create()) {
   *   String project = "";
   *   AggregatedListVpnTunnelsRequest request = AggregatedListVpnTunnelsRequest.newBuilder()
   *     .setProject(project)
   *     .build();
   *   ApiFuture&lt;AggregatedListPagedResponse&gt; future = vpnTunnelsClient.aggregatedListPagedCallable().futureCall(request);
   *   // Do something
   *   for (Entry&lt;String, VpnTunnelsScopedList&gt; element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  public final UnaryCallable<AggregatedListVpnTunnelsRequest, AggregatedListPagedResponse>
      aggregatedListPagedCallable() {
    return stub.aggregatedListPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves an aggregated list of VPN tunnels.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (VpnTunnelsClient vpnTunnelsClient = VpnTunnelsClient.create()) {
   *   String project = "";
   *   AggregatedListVpnTunnelsRequest request = AggregatedListVpnTunnelsRequest.newBuilder()
   *     .setProject(project)
   *     .build();
   *   while (true) {
   *     VpnTunnelAggregatedList response = vpnTunnelsClient.aggregatedListCallable().call(request);
   *     for (Entry&lt;String, VpnTunnelsScopedList&gt; element : response.getItemsMap()) {
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
  public final UnaryCallable<AggregatedListVpnTunnelsRequest, VpnTunnelAggregatedList>
      aggregatedListCallable() {
    return stub.aggregatedListCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified VpnTunnel resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (VpnTunnelsClient vpnTunnelsClient = VpnTunnelsClient.create()) {
   *   String project = "";
   *   String region = "";
   *   String vpnTunnel = "";
   *   Operation response = vpnTunnelsClient.delete(project, region, vpnTunnel);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region for this request.
   * @param vpnTunnel Name of the VpnTunnel resource to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation delete(String project, String region, String vpnTunnel) {
    DeleteVpnTunnelRequest request =
        DeleteVpnTunnelRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setVpnTunnel(vpnTunnel)
            .build();
    return delete(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified VpnTunnel resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (VpnTunnelsClient vpnTunnelsClient = VpnTunnelsClient.create()) {
   *   String project = "";
   *   String region = "";
   *   String vpnTunnel = "";
   *   DeleteVpnTunnelRequest request = DeleteVpnTunnelRequest.newBuilder()
   *     .setProject(project)
   *     .setRegion(region)
   *     .setVpnTunnel(vpnTunnel)
   *     .build();
   *   Operation response = vpnTunnelsClient.delete(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation delete(DeleteVpnTunnelRequest request) {
    return deleteCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified VpnTunnel resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (VpnTunnelsClient vpnTunnelsClient = VpnTunnelsClient.create()) {
   *   String project = "";
   *   String region = "";
   *   String vpnTunnel = "";
   *   DeleteVpnTunnelRequest request = DeleteVpnTunnelRequest.newBuilder()
   *     .setProject(project)
   *     .setRegion(region)
   *     .setVpnTunnel(vpnTunnel)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = vpnTunnelsClient.deleteCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<DeleteVpnTunnelRequest, Operation> deleteCallable() {
    return stub.deleteCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified VpnTunnel resource. Gets a list of available VPN tunnels by making a
   * list() request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (VpnTunnelsClient vpnTunnelsClient = VpnTunnelsClient.create()) {
   *   String project = "";
   *   String region = "";
   *   String vpnTunnel = "";
   *   VpnTunnel response = vpnTunnelsClient.get(project, region, vpnTunnel);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region for this request.
   * @param vpnTunnel Name of the VpnTunnel resource to return.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final VpnTunnel get(String project, String region, String vpnTunnel) {
    GetVpnTunnelRequest request =
        GetVpnTunnelRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setVpnTunnel(vpnTunnel)
            .build();
    return get(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified VpnTunnel resource. Gets a list of available VPN tunnels by making a
   * list() request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (VpnTunnelsClient vpnTunnelsClient = VpnTunnelsClient.create()) {
   *   String project = "";
   *   String region = "";
   *   String vpnTunnel = "";
   *   GetVpnTunnelRequest request = GetVpnTunnelRequest.newBuilder()
   *     .setProject(project)
   *     .setRegion(region)
   *     .setVpnTunnel(vpnTunnel)
   *     .build();
   *   VpnTunnel response = vpnTunnelsClient.get(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final VpnTunnel get(GetVpnTunnelRequest request) {
    return getCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified VpnTunnel resource. Gets a list of available VPN tunnels by making a
   * list() request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (VpnTunnelsClient vpnTunnelsClient = VpnTunnelsClient.create()) {
   *   String project = "";
   *   String region = "";
   *   String vpnTunnel = "";
   *   GetVpnTunnelRequest request = GetVpnTunnelRequest.newBuilder()
   *     .setProject(project)
   *     .setRegion(region)
   *     .setVpnTunnel(vpnTunnel)
   *     .build();
   *   ApiFuture&lt;VpnTunnel&gt; future = vpnTunnelsClient.getCallable().futureCall(request);
   *   // Do something
   *   VpnTunnel response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<GetVpnTunnelRequest, VpnTunnel> getCallable() {
    return stub.getCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a VpnTunnel resource in the specified project and region using the data included in the
   * request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (VpnTunnelsClient vpnTunnelsClient = VpnTunnelsClient.create()) {
   *   String project = "";
   *   String region = "";
   *   VpnTunnel vpnTunnelResource = VpnTunnel.newBuilder().build();
   *   Operation response = vpnTunnelsClient.insert(project, region, vpnTunnelResource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region for this request.
   * @param vpnTunnelResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation insert(String project, String region, VpnTunnel vpnTunnelResource) {
    InsertVpnTunnelRequest request =
        InsertVpnTunnelRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setVpnTunnelResource(vpnTunnelResource)
            .build();
    return insert(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a VpnTunnel resource in the specified project and region using the data included in the
   * request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (VpnTunnelsClient vpnTunnelsClient = VpnTunnelsClient.create()) {
   *   String project = "";
   *   String region = "";
   *   VpnTunnel vpnTunnelResource = VpnTunnel.newBuilder().build();
   *   InsertVpnTunnelRequest request = InsertVpnTunnelRequest.newBuilder()
   *     .setProject(project)
   *     .setRegion(region)
   *     .setVpnTunnelResource(vpnTunnelResource)
   *     .build();
   *   Operation response = vpnTunnelsClient.insert(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation insert(InsertVpnTunnelRequest request) {
    return insertCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a VpnTunnel resource in the specified project and region using the data included in the
   * request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (VpnTunnelsClient vpnTunnelsClient = VpnTunnelsClient.create()) {
   *   String project = "";
   *   String region = "";
   *   VpnTunnel vpnTunnelResource = VpnTunnel.newBuilder().build();
   *   InsertVpnTunnelRequest request = InsertVpnTunnelRequest.newBuilder()
   *     .setProject(project)
   *     .setRegion(region)
   *     .setVpnTunnelResource(vpnTunnelResource)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = vpnTunnelsClient.insertCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<InsertVpnTunnelRequest, Operation> insertCallable() {
    return stub.insertCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of VpnTunnel resources contained in the specified project and region.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (VpnTunnelsClient vpnTunnelsClient = VpnTunnelsClient.create()) {
   *   String project = "";
   *   String region = "";
   *   for (VpnTunnel element : vpnTunnelsClient.list(project, region).iterateAll()) {
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
    ListVpnTunnelsRequest request =
        ListVpnTunnelsRequest.newBuilder().setProject(project).setRegion(region).build();
    return list(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of VpnTunnel resources contained in the specified project and region.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (VpnTunnelsClient vpnTunnelsClient = VpnTunnelsClient.create()) {
   *   String project = "";
   *   String region = "";
   *   ListVpnTunnelsRequest request = ListVpnTunnelsRequest.newBuilder()
   *     .setProject(project)
   *     .setRegion(region)
   *     .build();
   *   for (VpnTunnel element : vpnTunnelsClient.list(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPagedResponse list(ListVpnTunnelsRequest request) {
    return listPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of VpnTunnel resources contained in the specified project and region.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (VpnTunnelsClient vpnTunnelsClient = VpnTunnelsClient.create()) {
   *   String project = "";
   *   String region = "";
   *   ListVpnTunnelsRequest request = ListVpnTunnelsRequest.newBuilder()
   *     .setProject(project)
   *     .setRegion(region)
   *     .build();
   *   ApiFuture&lt;ListPagedResponse&gt; future = vpnTunnelsClient.listPagedCallable().futureCall(request);
   *   // Do something
   *   for (VpnTunnel element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  public final UnaryCallable<ListVpnTunnelsRequest, ListPagedResponse> listPagedCallable() {
    return stub.listPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of VpnTunnel resources contained in the specified project and region.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (VpnTunnelsClient vpnTunnelsClient = VpnTunnelsClient.create()) {
   *   String project = "";
   *   String region = "";
   *   ListVpnTunnelsRequest request = ListVpnTunnelsRequest.newBuilder()
   *     .setProject(project)
   *     .setRegion(region)
   *     .build();
   *   while (true) {
   *     VpnTunnelList response = vpnTunnelsClient.listCallable().call(request);
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
  public final UnaryCallable<ListVpnTunnelsRequest, VpnTunnelList> listCallable() {
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

  public static class AggregatedListPagedResponse
      extends AbstractPagedListResponse<
          AggregatedListVpnTunnelsRequest,
          VpnTunnelAggregatedList,
          Entry<String, VpnTunnelsScopedList>,
          AggregatedListPage,
          AggregatedListFixedSizeCollection> {

    public static ApiFuture<AggregatedListPagedResponse> createAsync(
        PageContext<
                AggregatedListVpnTunnelsRequest,
                VpnTunnelAggregatedList,
                Entry<String, VpnTunnelsScopedList>>
            context,
        ApiFuture<VpnTunnelAggregatedList> futureResponse) {
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
          AggregatedListVpnTunnelsRequest,
          VpnTunnelAggregatedList,
          Entry<String, VpnTunnelsScopedList>,
          AggregatedListPage> {

    private AggregatedListPage(
        PageContext<
                AggregatedListVpnTunnelsRequest,
                VpnTunnelAggregatedList,
                Entry<String, VpnTunnelsScopedList>>
            context,
        VpnTunnelAggregatedList response) {
      super(context, response);
    }

    private static AggregatedListPage createEmptyPage() {
      return new AggregatedListPage(null, null);
    }

    @Override
    protected AggregatedListPage createPage(
        PageContext<
                AggregatedListVpnTunnelsRequest,
                VpnTunnelAggregatedList,
                Entry<String, VpnTunnelsScopedList>>
            context,
        VpnTunnelAggregatedList response) {
      return new AggregatedListPage(context, response);
    }

    @Override
    public ApiFuture<AggregatedListPage> createPageAsync(
        PageContext<
                AggregatedListVpnTunnelsRequest,
                VpnTunnelAggregatedList,
                Entry<String, VpnTunnelsScopedList>>
            context,
        ApiFuture<VpnTunnelAggregatedList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class AggregatedListFixedSizeCollection
      extends AbstractFixedSizeCollection<
          AggregatedListVpnTunnelsRequest,
          VpnTunnelAggregatedList,
          Entry<String, VpnTunnelsScopedList>,
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
          ListVpnTunnelsRequest, VpnTunnelList, VpnTunnel, ListPage, ListFixedSizeCollection> {

    public static ApiFuture<ListPagedResponse> createAsync(
        PageContext<ListVpnTunnelsRequest, VpnTunnelList, VpnTunnel> context,
        ApiFuture<VpnTunnelList> futureResponse) {
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
      extends AbstractPage<ListVpnTunnelsRequest, VpnTunnelList, VpnTunnel, ListPage> {

    private ListPage(
        PageContext<ListVpnTunnelsRequest, VpnTunnelList, VpnTunnel> context,
        VpnTunnelList response) {
      super(context, response);
    }

    private static ListPage createEmptyPage() {
      return new ListPage(null, null);
    }

    @Override
    protected ListPage createPage(
        PageContext<ListVpnTunnelsRequest, VpnTunnelList, VpnTunnel> context,
        VpnTunnelList response) {
      return new ListPage(context, response);
    }

    @Override
    public ApiFuture<ListPage> createPageAsync(
        PageContext<ListVpnTunnelsRequest, VpnTunnelList, VpnTunnel> context,
        ApiFuture<VpnTunnelList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListVpnTunnelsRequest, VpnTunnelList, VpnTunnel, ListPage, ListFixedSizeCollection> {

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
