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

import com.google.ads.admanager.v1.stub.ContentBundleServiceStub;
import com.google.ads.admanager.v1.stub.ContentBundleServiceStubSettings;
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
 * Service Description: Provides methods for handling `ContentBundle` objects.
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
 * try (ContentBundleServiceClient contentBundleServiceClient =
 *     ContentBundleServiceClient.create()) {
 *   ContentBundleName name = ContentBundleName.of("[NETWORK_CODE]", "[CONTENT_BUNDLE]");
 *   ContentBundle response = contentBundleServiceClient.getContentBundle(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the ContentBundleServiceClient object to clean up
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
 *      <td><p> GetContentBundle</td>
 *      <td><p> API to retrieve a `ContentBundle` object.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getContentBundle(GetContentBundleRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getContentBundle(ContentBundleName name)
 *           <li><p> getContentBundle(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getContentBundleCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListContentBundles</td>
 *      <td><p> API to retrieve a list of `ContentBundle` objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listContentBundles(ListContentBundlesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listContentBundles(NetworkName parent)
 *           <li><p> listContentBundles(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listContentBundlesPagedCallable()
 *           <li><p> listContentBundlesCallable()
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
 * <p>This class can be customized by passing in a custom instance of ContentBundleServiceSettings
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
 * ContentBundleServiceSettings contentBundleServiceSettings =
 *     ContentBundleServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * ContentBundleServiceClient contentBundleServiceClient =
 *     ContentBundleServiceClient.create(contentBundleServiceSettings);
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
 * ContentBundleServiceSettings contentBundleServiceSettings =
 *     ContentBundleServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * ContentBundleServiceClient contentBundleServiceClient =
 *     ContentBundleServiceClient.create(contentBundleServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class ContentBundleServiceClient implements BackgroundResource {
  private final ContentBundleServiceSettings settings;
  private final ContentBundleServiceStub stub;

  /** Constructs an instance of ContentBundleServiceClient with default settings. */
  public static final ContentBundleServiceClient create() throws IOException {
    return create(ContentBundleServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of ContentBundleServiceClient, using the given settings. The channels
   * are created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final ContentBundleServiceClient create(ContentBundleServiceSettings settings)
      throws IOException {
    return new ContentBundleServiceClient(settings);
  }

  /**
   * Constructs an instance of ContentBundleServiceClient, using the given stub for making calls.
   * This is for advanced usage - prefer using create(ContentBundleServiceSettings).
   */
  public static final ContentBundleServiceClient create(ContentBundleServiceStub stub) {
    return new ContentBundleServiceClient(stub);
  }

  /**
   * Constructs an instance of ContentBundleServiceClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected ContentBundleServiceClient(ContentBundleServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((ContentBundleServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected ContentBundleServiceClient(ContentBundleServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final ContentBundleServiceSettings getSettings() {
    return settings;
  }

  public ContentBundleServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a `ContentBundle` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContentBundleServiceClient contentBundleServiceClient =
   *     ContentBundleServiceClient.create()) {
   *   ContentBundleName name = ContentBundleName.of("[NETWORK_CODE]", "[CONTENT_BUNDLE]");
   *   ContentBundle response = contentBundleServiceClient.getContentBundle(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the ContentBundle. Format:
   *     `networks/{network_code}/contentBundles/{content_bundle_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ContentBundle getContentBundle(ContentBundleName name) {
    GetContentBundleRequest request =
        GetContentBundleRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getContentBundle(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a `ContentBundle` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContentBundleServiceClient contentBundleServiceClient =
   *     ContentBundleServiceClient.create()) {
   *   String name = ContentBundleName.of("[NETWORK_CODE]", "[CONTENT_BUNDLE]").toString();
   *   ContentBundle response = contentBundleServiceClient.getContentBundle(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the ContentBundle. Format:
   *     `networks/{network_code}/contentBundles/{content_bundle_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ContentBundle getContentBundle(String name) {
    GetContentBundleRequest request = GetContentBundleRequest.newBuilder().setName(name).build();
    return getContentBundle(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a `ContentBundle` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContentBundleServiceClient contentBundleServiceClient =
   *     ContentBundleServiceClient.create()) {
   *   GetContentBundleRequest request =
   *       GetContentBundleRequest.newBuilder()
   *           .setName(ContentBundleName.of("[NETWORK_CODE]", "[CONTENT_BUNDLE]").toString())
   *           .build();
   *   ContentBundle response = contentBundleServiceClient.getContentBundle(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ContentBundle getContentBundle(GetContentBundleRequest request) {
    return getContentBundleCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a `ContentBundle` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContentBundleServiceClient contentBundleServiceClient =
   *     ContentBundleServiceClient.create()) {
   *   GetContentBundleRequest request =
   *       GetContentBundleRequest.newBuilder()
   *           .setName(ContentBundleName.of("[NETWORK_CODE]", "[CONTENT_BUNDLE]").toString())
   *           .build();
   *   ApiFuture<ContentBundle> future =
   *       contentBundleServiceClient.getContentBundleCallable().futureCall(request);
   *   // Do something.
   *   ContentBundle response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetContentBundleRequest, ContentBundle> getContentBundleCallable() {
    return stub.getContentBundleCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of `ContentBundle` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContentBundleServiceClient contentBundleServiceClient =
   *     ContentBundleServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   for (ContentBundle element :
   *       contentBundleServiceClient.listContentBundles(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of ContentBundles. Format:
   *     `networks/{network_code}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListContentBundlesPagedResponse listContentBundles(NetworkName parent) {
    ListContentBundlesRequest request =
        ListContentBundlesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listContentBundles(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of `ContentBundle` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContentBundleServiceClient contentBundleServiceClient =
   *     ContentBundleServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   for (ContentBundle element :
   *       contentBundleServiceClient.listContentBundles(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of ContentBundles. Format:
   *     `networks/{network_code}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListContentBundlesPagedResponse listContentBundles(String parent) {
    ListContentBundlesRequest request =
        ListContentBundlesRequest.newBuilder().setParent(parent).build();
    return listContentBundles(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of `ContentBundle` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContentBundleServiceClient contentBundleServiceClient =
   *     ContentBundleServiceClient.create()) {
   *   ListContentBundlesRequest request =
   *       ListContentBundlesRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   for (ContentBundle element :
   *       contentBundleServiceClient.listContentBundles(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListContentBundlesPagedResponse listContentBundles(
      ListContentBundlesRequest request) {
    return listContentBundlesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of `ContentBundle` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContentBundleServiceClient contentBundleServiceClient =
   *     ContentBundleServiceClient.create()) {
   *   ListContentBundlesRequest request =
   *       ListContentBundlesRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   ApiFuture<ContentBundle> future =
   *       contentBundleServiceClient.listContentBundlesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (ContentBundle element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListContentBundlesRequest, ListContentBundlesPagedResponse>
      listContentBundlesPagedCallable() {
    return stub.listContentBundlesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of `ContentBundle` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContentBundleServiceClient contentBundleServiceClient =
   *     ContentBundleServiceClient.create()) {
   *   ListContentBundlesRequest request =
   *       ListContentBundlesRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   while (true) {
   *     ListContentBundlesResponse response =
   *         contentBundleServiceClient.listContentBundlesCallable().call(request);
   *     for (ContentBundle element : response.getContentBundlesList()) {
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
  public final UnaryCallable<ListContentBundlesRequest, ListContentBundlesResponse>
      listContentBundlesCallable() {
    return stub.listContentBundlesCallable();
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

  public static class ListContentBundlesPagedResponse
      extends AbstractPagedListResponse<
          ListContentBundlesRequest,
          ListContentBundlesResponse,
          ContentBundle,
          ListContentBundlesPage,
          ListContentBundlesFixedSizeCollection> {

    public static ApiFuture<ListContentBundlesPagedResponse> createAsync(
        PageContext<ListContentBundlesRequest, ListContentBundlesResponse, ContentBundle> context,
        ApiFuture<ListContentBundlesResponse> futureResponse) {
      ApiFuture<ListContentBundlesPage> futurePage =
          ListContentBundlesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListContentBundlesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListContentBundlesPagedResponse(ListContentBundlesPage page) {
      super(page, ListContentBundlesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListContentBundlesPage
      extends AbstractPage<
          ListContentBundlesRequest,
          ListContentBundlesResponse,
          ContentBundle,
          ListContentBundlesPage> {

    private ListContentBundlesPage(
        PageContext<ListContentBundlesRequest, ListContentBundlesResponse, ContentBundle> context,
        ListContentBundlesResponse response) {
      super(context, response);
    }

    private static ListContentBundlesPage createEmptyPage() {
      return new ListContentBundlesPage(null, null);
    }

    @Override
    protected ListContentBundlesPage createPage(
        PageContext<ListContentBundlesRequest, ListContentBundlesResponse, ContentBundle> context,
        ListContentBundlesResponse response) {
      return new ListContentBundlesPage(context, response);
    }

    @Override
    public ApiFuture<ListContentBundlesPage> createPageAsync(
        PageContext<ListContentBundlesRequest, ListContentBundlesResponse, ContentBundle> context,
        ApiFuture<ListContentBundlesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListContentBundlesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListContentBundlesRequest,
          ListContentBundlesResponse,
          ContentBundle,
          ListContentBundlesPage,
          ListContentBundlesFixedSizeCollection> {

    private ListContentBundlesFixedSizeCollection(
        List<ListContentBundlesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListContentBundlesFixedSizeCollection createEmptyCollection() {
      return new ListContentBundlesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListContentBundlesFixedSizeCollection createCollection(
        List<ListContentBundlesPage> pages, int collectionSize) {
      return new ListContentBundlesFixedSizeCollection(pages, collectionSize);
    }
  }
}
