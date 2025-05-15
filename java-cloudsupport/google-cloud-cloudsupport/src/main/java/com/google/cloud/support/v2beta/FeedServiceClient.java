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

package com.google.cloud.support.v2beta;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.support.v2beta.stub.FeedServiceStub;
import com.google.cloud.support.v2beta.stub.FeedServiceStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: A service to view case feed items.
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
 * try (FeedServiceClient feedServiceClient = FeedServiceClient.create()) {
 *   CaseName parent = CaseName.ofProjectCaseName("[PROJECT]", "[CASE]");
 *   for (FeedItem element : feedServiceClient.showFeed(parent).iterateAll()) {
 *     // doThingsWith(element);
 *   }
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the FeedServiceClient object to clean up resources such as
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
 *      <td><p> ShowFeed</td>
 *      <td><p> Show items in the feed of this case, including case emails, attachments, and comments.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> showFeed(ShowFeedRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> showFeed(CaseName parent)
 *           <li><p> showFeed(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> showFeedPagedCallable()
 *           <li><p> showFeedCallable()
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
 * <p>This class can be customized by passing in a custom instance of FeedServiceSettings to
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
 * FeedServiceSettings feedServiceSettings =
 *     FeedServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * FeedServiceClient feedServiceClient = FeedServiceClient.create(feedServiceSettings);
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
 * FeedServiceSettings feedServiceSettings =
 *     FeedServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * FeedServiceClient feedServiceClient = FeedServiceClient.create(feedServiceSettings);
 * }</pre>
 *
 * <p>To use REST (HTTP1.1/JSON) transport (instead of gRPC) for sending and receiving requests over
 * the wire:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * FeedServiceSettings feedServiceSettings = FeedServiceSettings.newHttpJsonBuilder().build();
 * FeedServiceClient feedServiceClient = FeedServiceClient.create(feedServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class FeedServiceClient implements BackgroundResource {
  private final FeedServiceSettings settings;
  private final FeedServiceStub stub;

  /** Constructs an instance of FeedServiceClient with default settings. */
  public static final FeedServiceClient create() throws IOException {
    return create(FeedServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of FeedServiceClient, using the given settings. The channels are created
   * based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final FeedServiceClient create(FeedServiceSettings settings) throws IOException {
    return new FeedServiceClient(settings);
  }

  /**
   * Constructs an instance of FeedServiceClient, using the given stub for making calls. This is for
   * advanced usage - prefer using create(FeedServiceSettings).
   */
  public static final FeedServiceClient create(FeedServiceStub stub) {
    return new FeedServiceClient(stub);
  }

  /**
   * Constructs an instance of FeedServiceClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected FeedServiceClient(FeedServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((FeedServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected FeedServiceClient(FeedServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final FeedServiceSettings getSettings() {
    return settings;
  }

  public FeedServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Show items in the feed of this case, including case emails, attachments, and comments.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FeedServiceClient feedServiceClient = FeedServiceClient.create()) {
   *   CaseName parent = CaseName.ofProjectCaseName("[PROJECT]", "[CASE]");
   *   for (FeedItem element : feedServiceClient.showFeed(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the case for which feed items should be listed.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ShowFeedPagedResponse showFeed(CaseName parent) {
    ShowFeedRequest request =
        ShowFeedRequest.newBuilder().setParent(parent == null ? null : parent.toString()).build();
    return showFeed(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Show items in the feed of this case, including case emails, attachments, and comments.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FeedServiceClient feedServiceClient = FeedServiceClient.create()) {
   *   String parent = CaseName.ofOrganizationCaseName("[ORGANIZATION]", "[CASE]").toString();
   *   for (FeedItem element : feedServiceClient.showFeed(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the case for which feed items should be listed.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ShowFeedPagedResponse showFeed(String parent) {
    ShowFeedRequest request = ShowFeedRequest.newBuilder().setParent(parent).build();
    return showFeed(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Show items in the feed of this case, including case emails, attachments, and comments.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FeedServiceClient feedServiceClient = FeedServiceClient.create()) {
   *   ShowFeedRequest request =
   *       ShowFeedRequest.newBuilder()
   *           .setParent(CaseName.ofProjectCaseName("[PROJECT]", "[CASE]").toString())
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (FeedItem element : feedServiceClient.showFeed(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ShowFeedPagedResponse showFeed(ShowFeedRequest request) {
    return showFeedPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Show items in the feed of this case, including case emails, attachments, and comments.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FeedServiceClient feedServiceClient = FeedServiceClient.create()) {
   *   ShowFeedRequest request =
   *       ShowFeedRequest.newBuilder()
   *           .setParent(CaseName.ofProjectCaseName("[PROJECT]", "[CASE]").toString())
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<FeedItem> future = feedServiceClient.showFeedPagedCallable().futureCall(request);
   *   // Do something.
   *   for (FeedItem element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ShowFeedRequest, ShowFeedPagedResponse> showFeedPagedCallable() {
    return stub.showFeedPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Show items in the feed of this case, including case emails, attachments, and comments.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FeedServiceClient feedServiceClient = FeedServiceClient.create()) {
   *   ShowFeedRequest request =
   *       ShowFeedRequest.newBuilder()
   *           .setParent(CaseName.ofProjectCaseName("[PROJECT]", "[CASE]").toString())
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ShowFeedResponse response = feedServiceClient.showFeedCallable().call(request);
   *     for (FeedItem element : response.getFeedItemsList()) {
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
  public final UnaryCallable<ShowFeedRequest, ShowFeedResponse> showFeedCallable() {
    return stub.showFeedCallable();
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

  public static class ShowFeedPagedResponse
      extends AbstractPagedListResponse<
          ShowFeedRequest, ShowFeedResponse, FeedItem, ShowFeedPage, ShowFeedFixedSizeCollection> {

    public static ApiFuture<ShowFeedPagedResponse> createAsync(
        PageContext<ShowFeedRequest, ShowFeedResponse, FeedItem> context,
        ApiFuture<ShowFeedResponse> futureResponse) {
      ApiFuture<ShowFeedPage> futurePage =
          ShowFeedPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage, input -> new ShowFeedPagedResponse(input), MoreExecutors.directExecutor());
    }

    private ShowFeedPagedResponse(ShowFeedPage page) {
      super(page, ShowFeedFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ShowFeedPage
      extends AbstractPage<ShowFeedRequest, ShowFeedResponse, FeedItem, ShowFeedPage> {

    private ShowFeedPage(
        PageContext<ShowFeedRequest, ShowFeedResponse, FeedItem> context,
        ShowFeedResponse response) {
      super(context, response);
    }

    private static ShowFeedPage createEmptyPage() {
      return new ShowFeedPage(null, null);
    }

    @Override
    protected ShowFeedPage createPage(
        PageContext<ShowFeedRequest, ShowFeedResponse, FeedItem> context,
        ShowFeedResponse response) {
      return new ShowFeedPage(context, response);
    }

    @Override
    public ApiFuture<ShowFeedPage> createPageAsync(
        PageContext<ShowFeedRequest, ShowFeedResponse, FeedItem> context,
        ApiFuture<ShowFeedResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ShowFeedFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ShowFeedRequest, ShowFeedResponse, FeedItem, ShowFeedPage, ShowFeedFixedSizeCollection> {

    private ShowFeedFixedSizeCollection(List<ShowFeedPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ShowFeedFixedSizeCollection createEmptyCollection() {
      return new ShowFeedFixedSizeCollection(null, 0);
    }

    @Override
    protected ShowFeedFixedSizeCollection createCollection(
        List<ShowFeedPage> pages, int collectionSize) {
      return new ShowFeedFixedSizeCollection(pages, collectionSize);
    }
  }
}
