/*
 * Copyright 2025 Google LLC
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

package com.google.ads.admanager.v1;

import com.google.ads.admanager.v1.stub.BandwidthGroupServiceStub;
import com.google.ads.admanager.v1.stub.BandwidthGroupServiceStubSettings;
import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Provides methods for handling `BandwidthGroup` objects.
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
 * try (BandwidthGroupServiceClient bandwidthGroupServiceClient =
 *     BandwidthGroupServiceClient.create()) {
 *   BandwidthGroupName name = BandwidthGroupName.of("[NETWORK_CODE]", "[BANDWIDTH_GROUP]");
 *   BandwidthGroup response = bandwidthGroupServiceClient.getBandwidthGroup(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the BandwidthGroupServiceClient object to clean up
 * resources such as threads. In the example above, try-with-resources is used, which automatically
 * calls close().
 *
 * <table>
 *    <caption>Methods</caption>
 *    <tr>
 *      <th>Method</th>
 *      <th>Description</th>
 *      <th>Method Variants</th>
 *    </tr>
 *    <tr>
 *      <td><p> GetBandwidthGroup</td>
 *      <td><p> API to retrieve a `BandwidthGroup` object.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getBandwidthGroup(GetBandwidthGroupRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getBandwidthGroup(BandwidthGroupName name)
 *           <li><p> getBandwidthGroup(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getBandwidthGroupCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListBandwidthGroups</td>
 *      <td><p> API to retrieve a list of `BandwidthGroup` objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listBandwidthGroups(ListBandwidthGroupsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listBandwidthGroups(NetworkName parent)
 *           <li><p> listBandwidthGroups(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listBandwidthGroupsPagedCallable()
 *           <li><p> listBandwidthGroupsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *  </table>
 *
 * <p>See the individual methods for example code.
 *
 * <p>Many parameters require resource names to be formatted in a particular way. To assist with
 * these names, this class includes a format method for each type of name, and additionally a parse
 * method to extract the individual identifiers contained within names that are returned.
 *
 * <p>This class can be customized by passing in a custom instance of BandwidthGroupServiceSettings
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
 * BandwidthGroupServiceSettings bandwidthGroupServiceSettings =
 *     BandwidthGroupServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * BandwidthGroupServiceClient bandwidthGroupServiceClient =
 *     BandwidthGroupServiceClient.create(bandwidthGroupServiceSettings);
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
 * BandwidthGroupServiceSettings bandwidthGroupServiceSettings =
 *     BandwidthGroupServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * BandwidthGroupServiceClient bandwidthGroupServiceClient =
 *     BandwidthGroupServiceClient.create(bandwidthGroupServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class BandwidthGroupServiceClient implements BackgroundResource {
  private final BandwidthGroupServiceSettings settings;
  private final BandwidthGroupServiceStub stub;

  /** Constructs an instance of BandwidthGroupServiceClient with default settings. */
  public static final BandwidthGroupServiceClient create() throws IOException {
    return create(BandwidthGroupServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of BandwidthGroupServiceClient, using the given settings. The channels
   * are created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final BandwidthGroupServiceClient create(BandwidthGroupServiceSettings settings)
      throws IOException {
    return new BandwidthGroupServiceClient(settings);
  }

  /**
   * Constructs an instance of BandwidthGroupServiceClient, using the given stub for making calls.
   * This is for advanced usage - prefer using create(BandwidthGroupServiceSettings).
   */
  public static final BandwidthGroupServiceClient create(BandwidthGroupServiceStub stub) {
    return new BandwidthGroupServiceClient(stub);
  }

  /**
   * Constructs an instance of BandwidthGroupServiceClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected BandwidthGroupServiceClient(BandwidthGroupServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((BandwidthGroupServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected BandwidthGroupServiceClient(BandwidthGroupServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final BandwidthGroupServiceSettings getSettings() {
    return settings;
  }

  public BandwidthGroupServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a `BandwidthGroup` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BandwidthGroupServiceClient bandwidthGroupServiceClient =
   *     BandwidthGroupServiceClient.create()) {
   *   BandwidthGroupName name = BandwidthGroupName.of("[NETWORK_CODE]", "[BANDWIDTH_GROUP]");
   *   BandwidthGroup response = bandwidthGroupServiceClient.getBandwidthGroup(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the BandwidthGroup. Format:
   *     `networks/{network_code}/bandwidthGroups/{bandwidth_group_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BandwidthGroup getBandwidthGroup(BandwidthGroupName name) {
    GetBandwidthGroupRequest request =
        GetBandwidthGroupRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getBandwidthGroup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a `BandwidthGroup` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BandwidthGroupServiceClient bandwidthGroupServiceClient =
   *     BandwidthGroupServiceClient.create()) {
   *   String name = BandwidthGroupName.of("[NETWORK_CODE]", "[BANDWIDTH_GROUP]").toString();
   *   BandwidthGroup response = bandwidthGroupServiceClient.getBandwidthGroup(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the BandwidthGroup. Format:
   *     `networks/{network_code}/bandwidthGroups/{bandwidth_group_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BandwidthGroup getBandwidthGroup(String name) {
    GetBandwidthGroupRequest request = GetBandwidthGroupRequest.newBuilder().setName(name).build();
    return getBandwidthGroup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a `BandwidthGroup` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BandwidthGroupServiceClient bandwidthGroupServiceClient =
   *     BandwidthGroupServiceClient.create()) {
   *   GetBandwidthGroupRequest request =
   *       GetBandwidthGroupRequest.newBuilder()
   *           .setName(BandwidthGroupName.of("[NETWORK_CODE]", "[BANDWIDTH_GROUP]").toString())
   *           .build();
   *   BandwidthGroup response = bandwidthGroupServiceClient.getBandwidthGroup(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BandwidthGroup getBandwidthGroup(GetBandwidthGroupRequest request) {
    return getBandwidthGroupCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a `BandwidthGroup` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BandwidthGroupServiceClient bandwidthGroupServiceClient =
   *     BandwidthGroupServiceClient.create()) {
   *   GetBandwidthGroupRequest request =
   *       GetBandwidthGroupRequest.newBuilder()
   *           .setName(BandwidthGroupName.of("[NETWORK_CODE]", "[BANDWIDTH_GROUP]").toString())
   *           .build();
   *   ApiFuture<BandwidthGroup> future =
   *       bandwidthGroupServiceClient.getBandwidthGroupCallable().futureCall(request);
   *   // Do something.
   *   BandwidthGroup response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetBandwidthGroupRequest, BandwidthGroup> getBandwidthGroupCallable() {
    return stub.getBandwidthGroupCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of `BandwidthGroup` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BandwidthGroupServiceClient bandwidthGroupServiceClient =
   *     BandwidthGroupServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   for (BandwidthGroup element :
   *       bandwidthGroupServiceClient.listBandwidthGroups(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of BandwidthGroups. Format:
   *     `networks/{network_code}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListBandwidthGroupsPagedResponse listBandwidthGroups(NetworkName parent) {
    ListBandwidthGroupsRequest request =
        ListBandwidthGroupsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listBandwidthGroups(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of `BandwidthGroup` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BandwidthGroupServiceClient bandwidthGroupServiceClient =
   *     BandwidthGroupServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   for (BandwidthGroup element :
   *       bandwidthGroupServiceClient.listBandwidthGroups(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of BandwidthGroups. Format:
   *     `networks/{network_code}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListBandwidthGroupsPagedResponse listBandwidthGroups(String parent) {
    ListBandwidthGroupsRequest request =
        ListBandwidthGroupsRequest.newBuilder().setParent(parent).build();
    return listBandwidthGroups(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of `BandwidthGroup` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BandwidthGroupServiceClient bandwidthGroupServiceClient =
   *     BandwidthGroupServiceClient.create()) {
   *   ListBandwidthGroupsRequest request =
   *       ListBandwidthGroupsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   for (BandwidthGroup element :
   *       bandwidthGroupServiceClient.listBandwidthGroups(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListBandwidthGroupsPagedResponse listBandwidthGroups(
      ListBandwidthGroupsRequest request) {
    return listBandwidthGroupsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of `BandwidthGroup` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BandwidthGroupServiceClient bandwidthGroupServiceClient =
   *     BandwidthGroupServiceClient.create()) {
   *   ListBandwidthGroupsRequest request =
   *       ListBandwidthGroupsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   ApiFuture<BandwidthGroup> future =
   *       bandwidthGroupServiceClient.listBandwidthGroupsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (BandwidthGroup element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListBandwidthGroupsRequest, ListBandwidthGroupsPagedResponse>
      listBandwidthGroupsPagedCallable() {
    return stub.listBandwidthGroupsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of `BandwidthGroup` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BandwidthGroupServiceClient bandwidthGroupServiceClient =
   *     BandwidthGroupServiceClient.create()) {
   *   ListBandwidthGroupsRequest request =
   *       ListBandwidthGroupsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   while (true) {
   *     ListBandwidthGroupsResponse response =
   *         bandwidthGroupServiceClient.listBandwidthGroupsCallable().call(request);
   *     for (BandwidthGroup element : response.getBandwidthGroupsList()) {
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
  public final UnaryCallable<ListBandwidthGroupsRequest, ListBandwidthGroupsResponse>
      listBandwidthGroupsCallable() {
    return stub.listBandwidthGroupsCallable();
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

  public static class ListBandwidthGroupsPagedResponse
      extends AbstractPagedListResponse<
          ListBandwidthGroupsRequest,
          ListBandwidthGroupsResponse,
          BandwidthGroup,
          ListBandwidthGroupsPage,
          ListBandwidthGroupsFixedSizeCollection> {

    public static ApiFuture<ListBandwidthGroupsPagedResponse> createAsync(
        PageContext<ListBandwidthGroupsRequest, ListBandwidthGroupsResponse, BandwidthGroup>
            context,
        ApiFuture<ListBandwidthGroupsResponse> futureResponse) {
      ApiFuture<ListBandwidthGroupsPage> futurePage =
          ListBandwidthGroupsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListBandwidthGroupsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListBandwidthGroupsPagedResponse(ListBandwidthGroupsPage page) {
      super(page, ListBandwidthGroupsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListBandwidthGroupsPage
      extends AbstractPage<
          ListBandwidthGroupsRequest,
          ListBandwidthGroupsResponse,
          BandwidthGroup,
          ListBandwidthGroupsPage> {

    private ListBandwidthGroupsPage(
        PageContext<ListBandwidthGroupsRequest, ListBandwidthGroupsResponse, BandwidthGroup>
            context,
        ListBandwidthGroupsResponse response) {
      super(context, response);
    }

    private static ListBandwidthGroupsPage createEmptyPage() {
      return new ListBandwidthGroupsPage(null, null);
    }

    @Override
    protected ListBandwidthGroupsPage createPage(
        PageContext<ListBandwidthGroupsRequest, ListBandwidthGroupsResponse, BandwidthGroup>
            context,
        ListBandwidthGroupsResponse response) {
      return new ListBandwidthGroupsPage(context, response);
    }

    @Override
    public ApiFuture<ListBandwidthGroupsPage> createPageAsync(
        PageContext<ListBandwidthGroupsRequest, ListBandwidthGroupsResponse, BandwidthGroup>
            context,
        ApiFuture<ListBandwidthGroupsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListBandwidthGroupsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListBandwidthGroupsRequest,
          ListBandwidthGroupsResponse,
          BandwidthGroup,
          ListBandwidthGroupsPage,
          ListBandwidthGroupsFixedSizeCollection> {

    private ListBandwidthGroupsFixedSizeCollection(
        List<ListBandwidthGroupsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListBandwidthGroupsFixedSizeCollection createEmptyCollection() {
      return new ListBandwidthGroupsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListBandwidthGroupsFixedSizeCollection createCollection(
        List<ListBandwidthGroupsPage> pages, int collectionSize) {
      return new ListBandwidthGroupsFixedSizeCollection(pages, collectionSize);
    }
  }
}
