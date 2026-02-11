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

import com.google.ads.admanager.v1.stub.BrowserServiceStub;
import com.google.ads.admanager.v1.stub.BrowserServiceStubSettings;
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
 * Service Description: Provides methods for handling `Browser` objects.
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
 * try (BrowserServiceClient browserServiceClient = BrowserServiceClient.create()) {
 *   BrowserName name = BrowserName.of("[NETWORK_CODE]", "[BROWSER]");
 *   Browser response = browserServiceClient.getBrowser(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the BrowserServiceClient object to clean up resources such
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
 *      <td><p> GetBrowser</td>
 *      <td><p> API to retrieve a `Browser` object.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getBrowser(GetBrowserRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getBrowser(BrowserName name)
 *           <li><p> getBrowser(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getBrowserCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListBrowsers</td>
 *      <td><p> API to retrieve a list of `Browser` objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listBrowsers(ListBrowsersRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listBrowsers(NetworkName parent)
 *           <li><p> listBrowsers(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listBrowsersPagedCallable()
 *           <li><p> listBrowsersCallable()
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
 * <p>This class can be customized by passing in a custom instance of BrowserServiceSettings to
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
 * BrowserServiceSettings browserServiceSettings =
 *     BrowserServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * BrowserServiceClient browserServiceClient = BrowserServiceClient.create(browserServiceSettings);
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
 * BrowserServiceSettings browserServiceSettings =
 *     BrowserServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * BrowserServiceClient browserServiceClient = BrowserServiceClient.create(browserServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class BrowserServiceClient implements BackgroundResource {
  private final BrowserServiceSettings settings;
  private final BrowserServiceStub stub;

  /** Constructs an instance of BrowserServiceClient with default settings. */
  public static final BrowserServiceClient create() throws IOException {
    return create(BrowserServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of BrowserServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final BrowserServiceClient create(BrowserServiceSettings settings)
      throws IOException {
    return new BrowserServiceClient(settings);
  }

  /**
   * Constructs an instance of BrowserServiceClient, using the given stub for making calls. This is
   * for advanced usage - prefer using create(BrowserServiceSettings).
   */
  public static final BrowserServiceClient create(BrowserServiceStub stub) {
    return new BrowserServiceClient(stub);
  }

  /**
   * Constructs an instance of BrowserServiceClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected BrowserServiceClient(BrowserServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((BrowserServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected BrowserServiceClient(BrowserServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final BrowserServiceSettings getSettings() {
    return settings;
  }

  public BrowserServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a `Browser` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BrowserServiceClient browserServiceClient = BrowserServiceClient.create()) {
   *   BrowserName name = BrowserName.of("[NETWORK_CODE]", "[BROWSER]");
   *   Browser response = browserServiceClient.getBrowser(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the Browser. Format:
   *     `networks/{network_code}/browsers/{browser_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Browser getBrowser(BrowserName name) {
    GetBrowserRequest request =
        GetBrowserRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getBrowser(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a `Browser` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BrowserServiceClient browserServiceClient = BrowserServiceClient.create()) {
   *   String name = BrowserName.of("[NETWORK_CODE]", "[BROWSER]").toString();
   *   Browser response = browserServiceClient.getBrowser(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the Browser. Format:
   *     `networks/{network_code}/browsers/{browser_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Browser getBrowser(String name) {
    GetBrowserRequest request = GetBrowserRequest.newBuilder().setName(name).build();
    return getBrowser(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a `Browser` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BrowserServiceClient browserServiceClient = BrowserServiceClient.create()) {
   *   GetBrowserRequest request =
   *       GetBrowserRequest.newBuilder()
   *           .setName(BrowserName.of("[NETWORK_CODE]", "[BROWSER]").toString())
   *           .build();
   *   Browser response = browserServiceClient.getBrowser(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Browser getBrowser(GetBrowserRequest request) {
    return getBrowserCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a `Browser` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BrowserServiceClient browserServiceClient = BrowserServiceClient.create()) {
   *   GetBrowserRequest request =
   *       GetBrowserRequest.newBuilder()
   *           .setName(BrowserName.of("[NETWORK_CODE]", "[BROWSER]").toString())
   *           .build();
   *   ApiFuture<Browser> future = browserServiceClient.getBrowserCallable().futureCall(request);
   *   // Do something.
   *   Browser response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetBrowserRequest, Browser> getBrowserCallable() {
    return stub.getBrowserCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of `Browser` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BrowserServiceClient browserServiceClient = BrowserServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   for (Browser element : browserServiceClient.listBrowsers(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of Browsers. Format:
   *     `networks/{network_code}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListBrowsersPagedResponse listBrowsers(NetworkName parent) {
    ListBrowsersRequest request =
        ListBrowsersRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listBrowsers(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of `Browser` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BrowserServiceClient browserServiceClient = BrowserServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   for (Browser element : browserServiceClient.listBrowsers(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of Browsers. Format:
   *     `networks/{network_code}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListBrowsersPagedResponse listBrowsers(String parent) {
    ListBrowsersRequest request = ListBrowsersRequest.newBuilder().setParent(parent).build();
    return listBrowsers(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of `Browser` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BrowserServiceClient browserServiceClient = BrowserServiceClient.create()) {
   *   ListBrowsersRequest request =
   *       ListBrowsersRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   for (Browser element : browserServiceClient.listBrowsers(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListBrowsersPagedResponse listBrowsers(ListBrowsersRequest request) {
    return listBrowsersPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of `Browser` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BrowserServiceClient browserServiceClient = BrowserServiceClient.create()) {
   *   ListBrowsersRequest request =
   *       ListBrowsersRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   ApiFuture<Browser> future =
   *       browserServiceClient.listBrowsersPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Browser element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListBrowsersRequest, ListBrowsersPagedResponse>
      listBrowsersPagedCallable() {
    return stub.listBrowsersPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of `Browser` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BrowserServiceClient browserServiceClient = BrowserServiceClient.create()) {
   *   ListBrowsersRequest request =
   *       ListBrowsersRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   while (true) {
   *     ListBrowsersResponse response = browserServiceClient.listBrowsersCallable().call(request);
   *     for (Browser element : response.getBrowsersList()) {
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
  public final UnaryCallable<ListBrowsersRequest, ListBrowsersResponse> listBrowsersCallable() {
    return stub.listBrowsersCallable();
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

  public static class ListBrowsersPagedResponse
      extends AbstractPagedListResponse<
          ListBrowsersRequest,
          ListBrowsersResponse,
          Browser,
          ListBrowsersPage,
          ListBrowsersFixedSizeCollection> {

    public static ApiFuture<ListBrowsersPagedResponse> createAsync(
        PageContext<ListBrowsersRequest, ListBrowsersResponse, Browser> context,
        ApiFuture<ListBrowsersResponse> futureResponse) {
      ApiFuture<ListBrowsersPage> futurePage =
          ListBrowsersPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListBrowsersPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListBrowsersPagedResponse(ListBrowsersPage page) {
      super(page, ListBrowsersFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListBrowsersPage
      extends AbstractPage<ListBrowsersRequest, ListBrowsersResponse, Browser, ListBrowsersPage> {

    private ListBrowsersPage(
        PageContext<ListBrowsersRequest, ListBrowsersResponse, Browser> context,
        ListBrowsersResponse response) {
      super(context, response);
    }

    private static ListBrowsersPage createEmptyPage() {
      return new ListBrowsersPage(null, null);
    }

    @Override
    protected ListBrowsersPage createPage(
        PageContext<ListBrowsersRequest, ListBrowsersResponse, Browser> context,
        ListBrowsersResponse response) {
      return new ListBrowsersPage(context, response);
    }

    @Override
    public ApiFuture<ListBrowsersPage> createPageAsync(
        PageContext<ListBrowsersRequest, ListBrowsersResponse, Browser> context,
        ApiFuture<ListBrowsersResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListBrowsersFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListBrowsersRequest,
          ListBrowsersResponse,
          Browser,
          ListBrowsersPage,
          ListBrowsersFixedSizeCollection> {

    private ListBrowsersFixedSizeCollection(List<ListBrowsersPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListBrowsersFixedSizeCollection createEmptyCollection() {
      return new ListBrowsersFixedSizeCollection(null, 0);
    }

    @Override
    protected ListBrowsersFixedSizeCollection createCollection(
        List<ListBrowsersPage> pages, int collectionSize) {
      return new ListBrowsersFixedSizeCollection(pages, collectionSize);
    }
  }
}
