/*
 * Copyright 2026 Google LLC
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
import com.google.cloud.compute.v1.stub.ImageViewsStub;
import com.google.cloud.compute.v1.stub.ImageViewsStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: The ImageViews API.
 *
 * <p>This client uses ImageViews version 2026-09-01.
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
 * try (ImageViewsClient imageViewsClient = ImageViewsClient.create()) {
 *   String project = "project-309310695";
 *   String region = "region-934795532";
 *   String resourceId = "resourceId-1345650231";
 *   ImageView response = imageViewsClient.get(project, region, resourceId);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the ImageViewsClient object to clean up resources such as
 * threads. In the example above, try-with-resources is used, which automatically calls close().
 *
 * <table>
 *    <caption>Methods</caption>
 *    <tr>
 *      <th>Method</th>
 *      <th>Description</th>
 *      <th>Method Variants</th>
 *    </tr>
 *    <tr>
 *      <td><p> Get</td>
 *      <td><p> Returns the specified global ImageView resource, with a regional context.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> get(GetImageViewRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> get(String project, String region, String resourceId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> List</td>
 *      <td><p> Returns a list of global ImageView resources, with a regional context.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> list(ListImageViewsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> list(String project, String region)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listPagedCallable()
 *           <li><p> listCallable()
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
 * <p>This class can be customized by passing in a custom instance of ImageViewsSettings to
 * create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * ImageViewsSettings imageViewsSettings =
 *     ImageViewsSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * ImageViewsClient imageViewsClient = ImageViewsClient.create(imageViewsSettings);
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
 * ImageViewsSettings imageViewsSettings =
 *     ImageViewsSettings.newBuilder().setEndpoint(myEndpoint).build();
 * ImageViewsClient imageViewsClient = ImageViewsClient.create(imageViewsSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@NullMarked
@Generated("by gapic-generator-java")
public class ImageViewsClient implements BackgroundResource {
  private final @Nullable ImageViewsSettings settings;
  private final ImageViewsStub stub;

  /** Constructs an instance of ImageViewsClient with default settings. */
  public static final ImageViewsClient create() throws IOException {
    return create(ImageViewsSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of ImageViewsClient, using the given settings. The channels are created
   * based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final ImageViewsClient create(ImageViewsSettings settings) throws IOException {
    return new ImageViewsClient(settings);
  }

  /**
   * Constructs an instance of ImageViewsClient, using the given stub for making calls. This is for
   * advanced usage - prefer using create(ImageViewsSettings).
   */
  public static final ImageViewsClient create(ImageViewsStub stub) {
    return new ImageViewsClient(stub);
  }

  /**
   * Constructs an instance of ImageViewsClient, using the given settings. This is protected so that
   * it is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected ImageViewsClient(ImageViewsSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((ImageViewsStubSettings) settings.getStubSettings()).createStub();
  }

  protected ImageViewsClient(ImageViewsStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final @Nullable ImageViewsSettings getSettings() {
    return settings;
  }

  public ImageViewsStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified global ImageView resource, with a regional context.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ImageViewsClient imageViewsClient = ImageViewsClient.create()) {
   *   String project = "project-309310695";
   *   String region = "region-934795532";
   *   String resourceId = "resourceId-1345650231";
   *   ImageView response = imageViewsClient.get(project, region, resourceId);
   * }
   * }</pre>
   *
   * @param project Required. Project ID for this request.
   * @param region Required. Name of the region for this request.
   * @param resourceId Name of the image resource to return.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ImageView get(String project, String region, String resourceId) {
    GetImageViewRequest request =
        GetImageViewRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setResourceId(resourceId)
            .build();
    return get(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified global ImageView resource, with a regional context.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ImageViewsClient imageViewsClient = ImageViewsClient.create()) {
   *   GetImageViewRequest request =
   *       GetImageViewRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setResourceId("resourceId-1345650231")
   *           .build();
   *   ImageView response = imageViewsClient.get(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ImageView get(GetImageViewRequest request) {
    return getCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified global ImageView resource, with a regional context.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ImageViewsClient imageViewsClient = ImageViewsClient.create()) {
   *   GetImageViewRequest request =
   *       GetImageViewRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setResourceId("resourceId-1345650231")
   *           .build();
   *   ApiFuture<ImageView> future = imageViewsClient.getCallable().futureCall(request);
   *   // Do something.
   *   ImageView response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetImageViewRequest, ImageView> getCallable() {
    return stub.getCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a list of global ImageView resources, with a regional context.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ImageViewsClient imageViewsClient = ImageViewsClient.create()) {
   *   String project = "project-309310695";
   *   String region = "region-934795532";
   *   for (ImageView element : imageViewsClient.list(project, region).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param project Required. Project ID for this request.
   * @param region Required. Name of the region for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPagedResponse list(String project, String region) {
    ListImageViewsRequest request =
        ListImageViewsRequest.newBuilder().setProject(project).setRegion(region).build();
    return list(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a list of global ImageView resources, with a regional context.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ImageViewsClient imageViewsClient = ImageViewsClient.create()) {
   *   ListImageViewsRequest request =
   *       ListImageViewsRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .build();
   *   for (ImageView element : imageViewsClient.list(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPagedResponse list(ListImageViewsRequest request) {
    return listPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a list of global ImageView resources, with a regional context.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ImageViewsClient imageViewsClient = ImageViewsClient.create()) {
   *   ListImageViewsRequest request =
   *       ListImageViewsRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .build();
   *   ApiFuture<ImageView> future = imageViewsClient.listPagedCallable().futureCall(request);
   *   // Do something.
   *   for (ImageView element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListImageViewsRequest, ListPagedResponse> listPagedCallable() {
    return stub.listPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a list of global ImageView resources, with a regional context.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ImageViewsClient imageViewsClient = ImageViewsClient.create()) {
   *   ListImageViewsRequest request =
   *       ListImageViewsRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .build();
   *   while (true) {
   *     ImageViewsListResponse response = imageViewsClient.listCallable().call(request);
   *     for (ImageView element : response.getItemsList()) {
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
  public final UnaryCallable<ListImageViewsRequest, ImageViewsListResponse> listCallable() {
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
          ListImageViewsRequest,
          ImageViewsListResponse,
          ImageView,
          ListPage,
          ListFixedSizeCollection> {

    public static ApiFuture<ListPagedResponse> createAsync(
        PageContext<ListImageViewsRequest, ImageViewsListResponse, ImageView> context,
        ApiFuture<ImageViewsListResponse> futureResponse) {
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
      extends AbstractPage<ListImageViewsRequest, ImageViewsListResponse, ImageView, ListPage> {

    private ListPage(
        @Nullable PageContext<ListImageViewsRequest, ImageViewsListResponse, ImageView> context,
        @Nullable ImageViewsListResponse response) {
      super(context, response);
    }

    private static ListPage createEmptyPage() {
      return new ListPage(null, null);
    }

    @Override
    protected ListPage createPage(
        @Nullable PageContext<ListImageViewsRequest, ImageViewsListResponse, ImageView> context,
        @Nullable ImageViewsListResponse response) {
      return new ListPage(context, response);
    }

    @Override
    public ApiFuture<ListPage> createPageAsync(
        @Nullable PageContext<ListImageViewsRequest, ImageViewsListResponse, ImageView> context,
        ApiFuture<ImageViewsListResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListImageViewsRequest,
          ImageViewsListResponse,
          ImageView,
          ListPage,
          ListFixedSizeCollection> {

    private ListFixedSizeCollection(@Nullable List<ListPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListFixedSizeCollection createEmptyCollection() {
      return new ListFixedSizeCollection(null, 0);
    }

    @Override
    protected ListFixedSizeCollection createCollection(
        @Nullable List<ListPage> pages, int collectionSize) {
      return new ListFixedSizeCollection(pages, collectionSize);
    }
  }
}
