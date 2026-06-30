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

package com.google.ads.admanager.v1;

import com.google.ads.admanager.v1.stub.ContentServiceStub;
import com.google.ads.admanager.v1.stub.ContentServiceStubSettings;
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
 * Service Description: Provides methods for handling `Content` objects.
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
 * try (ContentServiceClient contentServiceClient = ContentServiceClient.create()) {
 *   ContentName name = ContentName.of("[NETWORK_CODE]", "[CONTENT]");
 *   Content response = contentServiceClient.getContent(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the ContentServiceClient object to clean up resources such
 * as threads. In the example above, try-with-resources is used, which automatically calls close().
 *
 * <table>
 *    <caption>Methods</caption>
 *    <tr>
 *      <th>Method</th>
 *      <th>Description</th>
 *      <th>Method Variants</th>
 *    </tr>
 *    <tr>
 *      <td><p> GetContent</td>
 *      <td><p> API to retrieve a `Content` object.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getContent(GetContentRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getContent(ContentName name)
 *           <li><p> getContent(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getContentCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListContent</td>
 *      <td><p> API to retrieve a list of `Content` objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listContent(ListContentRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listContent(NetworkName parent)
 *           <li><p> listContent(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listContentPagedCallable()
 *           <li><p> listContentCallable()
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
 * <p>This class can be customized by passing in a custom instance of ContentServiceSettings to
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
 * ContentServiceSettings contentServiceSettings =
 *     ContentServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * ContentServiceClient contentServiceClient = ContentServiceClient.create(contentServiceSettings);
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
 * ContentServiceSettings contentServiceSettings =
 *     ContentServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * ContentServiceClient contentServiceClient = ContentServiceClient.create(contentServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class ContentServiceClient implements BackgroundResource {
  private final ContentServiceSettings settings;
  private final ContentServiceStub stub;

  /** Constructs an instance of ContentServiceClient with default settings. */
  public static final ContentServiceClient create() throws IOException {
    return create(ContentServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of ContentServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final ContentServiceClient create(ContentServiceSettings settings)
      throws IOException {
    return new ContentServiceClient(settings);
  }

  /**
   * Constructs an instance of ContentServiceClient, using the given stub for making calls. This is
   * for advanced usage - prefer using create(ContentServiceSettings).
   */
  public static final ContentServiceClient create(ContentServiceStub stub) {
    return new ContentServiceClient(stub);
  }

  /**
   * Constructs an instance of ContentServiceClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected ContentServiceClient(ContentServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((ContentServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected ContentServiceClient(ContentServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final ContentServiceSettings getSettings() {
    return settings;
  }

  public ContentServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a `Content` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContentServiceClient contentServiceClient = ContentServiceClient.create()) {
   *   ContentName name = ContentName.of("[NETWORK_CODE]", "[CONTENT]");
   *   Content response = contentServiceClient.getContent(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the Content. Format:
   *     `networks/{network_code}/content/{content_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Content getContent(ContentName name) {
    GetContentRequest request =
        GetContentRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getContent(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a `Content` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContentServiceClient contentServiceClient = ContentServiceClient.create()) {
   *   String name = ContentName.of("[NETWORK_CODE]", "[CONTENT]").toString();
   *   Content response = contentServiceClient.getContent(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the Content. Format:
   *     `networks/{network_code}/content/{content_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Content getContent(String name) {
    GetContentRequest request = GetContentRequest.newBuilder().setName(name).build();
    return getContent(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a `Content` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContentServiceClient contentServiceClient = ContentServiceClient.create()) {
   *   GetContentRequest request =
   *       GetContentRequest.newBuilder()
   *           .setName(ContentName.of("[NETWORK_CODE]", "[CONTENT]").toString())
   *           .build();
   *   Content response = contentServiceClient.getContent(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Content getContent(GetContentRequest request) {
    return getContentCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a `Content` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContentServiceClient contentServiceClient = ContentServiceClient.create()) {
   *   GetContentRequest request =
   *       GetContentRequest.newBuilder()
   *           .setName(ContentName.of("[NETWORK_CODE]", "[CONTENT]").toString())
   *           .build();
   *   ApiFuture<Content> future = contentServiceClient.getContentCallable().futureCall(request);
   *   // Do something.
   *   Content response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetContentRequest, Content> getContentCallable() {
    return stub.getContentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of `Content` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContentServiceClient contentServiceClient = ContentServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   for (Content element : contentServiceClient.listContent(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of Content. Format:
   *     `networks/{network_code}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListContentPagedResponse listContent(NetworkName parent) {
    ListContentRequest request =
        ListContentRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listContent(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of `Content` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContentServiceClient contentServiceClient = ContentServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   for (Content element : contentServiceClient.listContent(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of Content. Format:
   *     `networks/{network_code}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListContentPagedResponse listContent(String parent) {
    ListContentRequest request = ListContentRequest.newBuilder().setParent(parent).build();
    return listContent(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of `Content` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContentServiceClient contentServiceClient = ContentServiceClient.create()) {
   *   ListContentRequest request =
   *       ListContentRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   for (Content element : contentServiceClient.listContent(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListContentPagedResponse listContent(ListContentRequest request) {
    return listContentPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of `Content` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContentServiceClient contentServiceClient = ContentServiceClient.create()) {
   *   ListContentRequest request =
   *       ListContentRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   ApiFuture<Content> future =
   *       contentServiceClient.listContentPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Content element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListContentRequest, ListContentPagedResponse>
      listContentPagedCallable() {
    return stub.listContentPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of `Content` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContentServiceClient contentServiceClient = ContentServiceClient.create()) {
   *   ListContentRequest request =
   *       ListContentRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   while (true) {
   *     ListContentResponse response = contentServiceClient.listContentCallable().call(request);
   *     for (Content element : response.getContentList()) {
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
  public final UnaryCallable<ListContentRequest, ListContentResponse> listContentCallable() {
    return stub.listContentCallable();
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

  public static class ListContentPagedResponse
      extends AbstractPagedListResponse<
          ListContentRequest,
          ListContentResponse,
          Content,
          ListContentPage,
          ListContentFixedSizeCollection> {

    public static ApiFuture<ListContentPagedResponse> createAsync(
        PageContext<ListContentRequest, ListContentResponse, Content> context,
        ApiFuture<ListContentResponse> futureResponse) {
      ApiFuture<ListContentPage> futurePage =
          ListContentPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage, input -> new ListContentPagedResponse(input), MoreExecutors.directExecutor());
    }

    private ListContentPagedResponse(ListContentPage page) {
      super(page, ListContentFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListContentPage
      extends AbstractPage<ListContentRequest, ListContentResponse, Content, ListContentPage> {

    private ListContentPage(
        PageContext<ListContentRequest, ListContentResponse, Content> context,
        ListContentResponse response) {
      super(context, response);
    }

    private static ListContentPage createEmptyPage() {
      return new ListContentPage(null, null);
    }

    @Override
    protected ListContentPage createPage(
        PageContext<ListContentRequest, ListContentResponse, Content> context,
        ListContentResponse response) {
      return new ListContentPage(context, response);
    }

    @Override
    public ApiFuture<ListContentPage> createPageAsync(
        PageContext<ListContentRequest, ListContentResponse, Content> context,
        ApiFuture<ListContentResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListContentFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListContentRequest,
          ListContentResponse,
          Content,
          ListContentPage,
          ListContentFixedSizeCollection> {

    private ListContentFixedSizeCollection(List<ListContentPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListContentFixedSizeCollection createEmptyCollection() {
      return new ListContentFixedSizeCollection(null, 0);
    }

    @Override
    protected ListContentFixedSizeCollection createCollection(
        List<ListContentPage> pages, int collectionSize) {
      return new ListContentFixedSizeCollection(pages, collectionSize);
    }
  }
}
