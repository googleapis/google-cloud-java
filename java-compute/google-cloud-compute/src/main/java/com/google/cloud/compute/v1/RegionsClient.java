/*
 * Copyright 2022 Google LLC
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

package com.google.cloud.compute.v1;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.compute.v1.stub.RegionsStub;
import com.google.cloud.compute.v1.stub.RegionsStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: The Regions API.
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
 * try (RegionsClient regionsClient = RegionsClient.create()) {
 *   String project = "project-309310695";
 *   String region = "region-934795532";
 *   Region response = regionsClient.get(project, region);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the RegionsClient object to clean up resources such as
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
 * <p>This class can be customized by passing in a custom instance of RegionsSettings to create().
 * For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * RegionsSettings regionsSettings =
 *     RegionsSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * RegionsClient regionsClient = RegionsClient.create(regionsSettings);
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
 * RegionsSettings regionsSettings = RegionsSettings.newBuilder().setEndpoint(myEndpoint).build();
 * RegionsClient regionsClient = RegionsClient.create(regionsSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class RegionsClient implements BackgroundResource {
  private final RegionsSettings settings;
  private final RegionsStub stub;

  /** Constructs an instance of RegionsClient with default settings. */
  public static final RegionsClient create() throws IOException {
    return create(RegionsSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of RegionsClient, using the given settings. The channels are created
   * based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final RegionsClient create(RegionsSettings settings) throws IOException {
    return new RegionsClient(settings);
  }

  /**
   * Constructs an instance of RegionsClient, using the given stub for making calls. This is for
   * advanced usage - prefer using create(RegionsSettings).
   */
  public static final RegionsClient create(RegionsStub stub) {
    return new RegionsClient(stub);
  }

  /**
   * Constructs an instance of RegionsClient, using the given settings. This is protected so that it
   * is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected RegionsClient(RegionsSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((RegionsStubSettings) settings.getStubSettings()).createStub();
  }

  protected RegionsClient(RegionsStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final RegionsSettings getSettings() {
    return settings;
  }

  public RegionsStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified Region resource. Gets a list of available regions by making a list()
   * request. To decrease latency for this method, you can optionally omit any unneeded information
   * from the response by using a field mask. This practice is especially recommended for unused
   * quota information (the `quotas` field). To exclude one or more fields, set your request's
   * `fields` query parameter to only include the fields you need. For example, to only include the
   * `id` and `selfLink` fields, add the query parameter `?fields=id,selfLink` to your request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionsClient regionsClient = RegionsClient.create()) {
   *   String project = "project-309310695";
   *   String region = "region-934795532";
   *   Region response = regionsClient.get(project, region);
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region resource to return.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Region get(String project, String region) {
    GetRegionRequest request =
        GetRegionRequest.newBuilder().setProject(project).setRegion(region).build();
    return get(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified Region resource. Gets a list of available regions by making a list()
   * request. To decrease latency for this method, you can optionally omit any unneeded information
   * from the response by using a field mask. This practice is especially recommended for unused
   * quota information (the `quotas` field). To exclude one or more fields, set your request's
   * `fields` query parameter to only include the fields you need. For example, to only include the
   * `id` and `selfLink` fields, add the query parameter `?fields=id,selfLink` to your request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionsClient regionsClient = RegionsClient.create()) {
   *   GetRegionRequest request =
   *       GetRegionRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .build();
   *   Region response = regionsClient.get(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Region get(GetRegionRequest request) {
    return getCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified Region resource. Gets a list of available regions by making a list()
   * request. To decrease latency for this method, you can optionally omit any unneeded information
   * from the response by using a field mask. This practice is especially recommended for unused
   * quota information (the `quotas` field). To exclude one or more fields, set your request's
   * `fields` query parameter to only include the fields you need. For example, to only include the
   * `id` and `selfLink` fields, add the query parameter `?fields=id,selfLink` to your request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionsClient regionsClient = RegionsClient.create()) {
   *   GetRegionRequest request =
   *       GetRegionRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .build();
   *   ApiFuture<Region> future = regionsClient.getCallable().futureCall(request);
   *   // Do something.
   *   Region response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetRegionRequest, Region> getCallable() {
    return stub.getCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the list of region resources available to the specified project. To decrease latency
   * for this method, you can optionally omit any unneeded information from the response by using a
   * field mask. This practice is especially recommended for unused quota information (the
   * `items.quotas` field). To exclude one or more fields, set your request's `fields` query
   * parameter to only include the fields you need. For example, to only include the `id` and
   * `selfLink` fields, add the query parameter `?fields=id,selfLink` to your request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionsClient regionsClient = RegionsClient.create()) {
   *   String project = "project-309310695";
   *   for (Region element : regionsClient.list(project).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPagedResponse list(String project) {
    ListRegionsRequest request = ListRegionsRequest.newBuilder().setProject(project).build();
    return list(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the list of region resources available to the specified project. To decrease latency
   * for this method, you can optionally omit any unneeded information from the response by using a
   * field mask. This practice is especially recommended for unused quota information (the
   * `items.quotas` field). To exclude one or more fields, set your request's `fields` query
   * parameter to only include the fields you need. For example, to only include the `id` and
   * `selfLink` fields, add the query parameter `?fields=id,selfLink` to your request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionsClient regionsClient = RegionsClient.create()) {
   *   ListRegionsRequest request =
   *       ListRegionsRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   for (Region element : regionsClient.list(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPagedResponse list(ListRegionsRequest request) {
    return listPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the list of region resources available to the specified project. To decrease latency
   * for this method, you can optionally omit any unneeded information from the response by using a
   * field mask. This practice is especially recommended for unused quota information (the
   * `items.quotas` field). To exclude one or more fields, set your request's `fields` query
   * parameter to only include the fields you need. For example, to only include the `id` and
   * `selfLink` fields, add the query parameter `?fields=id,selfLink` to your request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionsClient regionsClient = RegionsClient.create()) {
   *   ListRegionsRequest request =
   *       ListRegionsRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   ApiFuture<Region> future = regionsClient.listPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Region element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListRegionsRequest, ListPagedResponse> listPagedCallable() {
    return stub.listPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the list of region resources available to the specified project. To decrease latency
   * for this method, you can optionally omit any unneeded information from the response by using a
   * field mask. This practice is especially recommended for unused quota information (the
   * `items.quotas` field). To exclude one or more fields, set your request's `fields` query
   * parameter to only include the fields you need. For example, to only include the `id` and
   * `selfLink` fields, add the query parameter `?fields=id,selfLink` to your request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionsClient regionsClient = RegionsClient.create()) {
   *   ListRegionsRequest request =
   *       ListRegionsRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   while (true) {
   *     RegionList response = regionsClient.listCallable().call(request);
   *     for (Region element : response.getItemsList()) {
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
  public final UnaryCallable<ListRegionsRequest, RegionList> listCallable() {
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

  public static class ListPagedResponse
      extends AbstractPagedListResponse<
          ListRegionsRequest, RegionList, Region, ListPage, ListFixedSizeCollection> {

    public static ApiFuture<ListPagedResponse> createAsync(
        PageContext<ListRegionsRequest, RegionList, Region> context,
        ApiFuture<RegionList> futureResponse) {
      ApiFuture<ListPage> futurePage =
          ListPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage, input -> new ListPagedResponse(input), MoreExecutors.directExecutor());
    }

    private ListPagedResponse(ListPage page) {
      super(page, ListFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListPage
      extends AbstractPage<ListRegionsRequest, RegionList, Region, ListPage> {

    private ListPage(
        PageContext<ListRegionsRequest, RegionList, Region> context, RegionList response) {
      super(context, response);
    }

    private static ListPage createEmptyPage() {
      return new ListPage(null, null);
    }

    @Override
    protected ListPage createPage(
        PageContext<ListRegionsRequest, RegionList, Region> context, RegionList response) {
      return new ListPage(context, response);
    }

    @Override
    public ApiFuture<ListPage> createPageAsync(
        PageContext<ListRegionsRequest, RegionList, Region> context,
        ApiFuture<RegionList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListRegionsRequest, RegionList, Region, ListPage, ListFixedSizeCollection> {

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
