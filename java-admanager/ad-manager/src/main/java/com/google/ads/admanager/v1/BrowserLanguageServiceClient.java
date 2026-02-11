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

import com.google.ads.admanager.v1.stub.BrowserLanguageServiceStub;
import com.google.ads.admanager.v1.stub.BrowserLanguageServiceStubSettings;
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
 * Service Description: Provides methods for handling `BrowserLanguage` objects.
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
 * try (BrowserLanguageServiceClient browserLanguageServiceClient =
 *     BrowserLanguageServiceClient.create()) {
 *   BrowserLanguageName name = BrowserLanguageName.of("[NETWORK_CODE]", "[BROWSER_LANGUAGE]");
 *   BrowserLanguage response = browserLanguageServiceClient.getBrowserLanguage(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the BrowserLanguageServiceClient object to clean up
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
 *      <td><p> GetBrowserLanguage</td>
 *      <td><p> API to retrieve a `BrowserLanguage` object.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getBrowserLanguage(GetBrowserLanguageRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getBrowserLanguage(BrowserLanguageName name)
 *           <li><p> getBrowserLanguage(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getBrowserLanguageCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListBrowserLanguages</td>
 *      <td><p> API to retrieve a list of `BrowserLanguage` objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listBrowserLanguages(ListBrowserLanguagesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listBrowserLanguages(NetworkName parent)
 *           <li><p> listBrowserLanguages(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listBrowserLanguagesPagedCallable()
 *           <li><p> listBrowserLanguagesCallable()
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
 * <p>This class can be customized by passing in a custom instance of BrowserLanguageServiceSettings
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
 * BrowserLanguageServiceSettings browserLanguageServiceSettings =
 *     BrowserLanguageServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * BrowserLanguageServiceClient browserLanguageServiceClient =
 *     BrowserLanguageServiceClient.create(browserLanguageServiceSettings);
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
 * BrowserLanguageServiceSettings browserLanguageServiceSettings =
 *     BrowserLanguageServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * BrowserLanguageServiceClient browserLanguageServiceClient =
 *     BrowserLanguageServiceClient.create(browserLanguageServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class BrowserLanguageServiceClient implements BackgroundResource {
  private final BrowserLanguageServiceSettings settings;
  private final BrowserLanguageServiceStub stub;

  /** Constructs an instance of BrowserLanguageServiceClient with default settings. */
  public static final BrowserLanguageServiceClient create() throws IOException {
    return create(BrowserLanguageServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of BrowserLanguageServiceClient, using the given settings. The channels
   * are created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final BrowserLanguageServiceClient create(BrowserLanguageServiceSettings settings)
      throws IOException {
    return new BrowserLanguageServiceClient(settings);
  }

  /**
   * Constructs an instance of BrowserLanguageServiceClient, using the given stub for making calls.
   * This is for advanced usage - prefer using create(BrowserLanguageServiceSettings).
   */
  public static final BrowserLanguageServiceClient create(BrowserLanguageServiceStub stub) {
    return new BrowserLanguageServiceClient(stub);
  }

  /**
   * Constructs an instance of BrowserLanguageServiceClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected BrowserLanguageServiceClient(BrowserLanguageServiceSettings settings)
      throws IOException {
    this.settings = settings;
    this.stub = ((BrowserLanguageServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected BrowserLanguageServiceClient(BrowserLanguageServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final BrowserLanguageServiceSettings getSettings() {
    return settings;
  }

  public BrowserLanguageServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a `BrowserLanguage` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BrowserLanguageServiceClient browserLanguageServiceClient =
   *     BrowserLanguageServiceClient.create()) {
   *   BrowserLanguageName name = BrowserLanguageName.of("[NETWORK_CODE]", "[BROWSER_LANGUAGE]");
   *   BrowserLanguage response = browserLanguageServiceClient.getBrowserLanguage(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the BrowserLanguage. Format:
   *     `networks/{network_code}/browserLanguages/{browser_language_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BrowserLanguage getBrowserLanguage(BrowserLanguageName name) {
    GetBrowserLanguageRequest request =
        GetBrowserLanguageRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getBrowserLanguage(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a `BrowserLanguage` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BrowserLanguageServiceClient browserLanguageServiceClient =
   *     BrowserLanguageServiceClient.create()) {
   *   String name = BrowserLanguageName.of("[NETWORK_CODE]", "[BROWSER_LANGUAGE]").toString();
   *   BrowserLanguage response = browserLanguageServiceClient.getBrowserLanguage(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the BrowserLanguage. Format:
   *     `networks/{network_code}/browserLanguages/{browser_language_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BrowserLanguage getBrowserLanguage(String name) {
    GetBrowserLanguageRequest request =
        GetBrowserLanguageRequest.newBuilder().setName(name).build();
    return getBrowserLanguage(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a `BrowserLanguage` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BrowserLanguageServiceClient browserLanguageServiceClient =
   *     BrowserLanguageServiceClient.create()) {
   *   GetBrowserLanguageRequest request =
   *       GetBrowserLanguageRequest.newBuilder()
   *           .setName(BrowserLanguageName.of("[NETWORK_CODE]", "[BROWSER_LANGUAGE]").toString())
   *           .build();
   *   BrowserLanguage response = browserLanguageServiceClient.getBrowserLanguage(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BrowserLanguage getBrowserLanguage(GetBrowserLanguageRequest request) {
    return getBrowserLanguageCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a `BrowserLanguage` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BrowserLanguageServiceClient browserLanguageServiceClient =
   *     BrowserLanguageServiceClient.create()) {
   *   GetBrowserLanguageRequest request =
   *       GetBrowserLanguageRequest.newBuilder()
   *           .setName(BrowserLanguageName.of("[NETWORK_CODE]", "[BROWSER_LANGUAGE]").toString())
   *           .build();
   *   ApiFuture<BrowserLanguage> future =
   *       browserLanguageServiceClient.getBrowserLanguageCallable().futureCall(request);
   *   // Do something.
   *   BrowserLanguage response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetBrowserLanguageRequest, BrowserLanguage>
      getBrowserLanguageCallable() {
    return stub.getBrowserLanguageCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of `BrowserLanguage` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BrowserLanguageServiceClient browserLanguageServiceClient =
   *     BrowserLanguageServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   for (BrowserLanguage element :
   *       browserLanguageServiceClient.listBrowserLanguages(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of BrowserLanguages. Format:
   *     `networks/{network_code}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListBrowserLanguagesPagedResponse listBrowserLanguages(NetworkName parent) {
    ListBrowserLanguagesRequest request =
        ListBrowserLanguagesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listBrowserLanguages(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of `BrowserLanguage` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BrowserLanguageServiceClient browserLanguageServiceClient =
   *     BrowserLanguageServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   for (BrowserLanguage element :
   *       browserLanguageServiceClient.listBrowserLanguages(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of BrowserLanguages. Format:
   *     `networks/{network_code}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListBrowserLanguagesPagedResponse listBrowserLanguages(String parent) {
    ListBrowserLanguagesRequest request =
        ListBrowserLanguagesRequest.newBuilder().setParent(parent).build();
    return listBrowserLanguages(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of `BrowserLanguage` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BrowserLanguageServiceClient browserLanguageServiceClient =
   *     BrowserLanguageServiceClient.create()) {
   *   ListBrowserLanguagesRequest request =
   *       ListBrowserLanguagesRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   for (BrowserLanguage element :
   *       browserLanguageServiceClient.listBrowserLanguages(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListBrowserLanguagesPagedResponse listBrowserLanguages(
      ListBrowserLanguagesRequest request) {
    return listBrowserLanguagesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of `BrowserLanguage` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BrowserLanguageServiceClient browserLanguageServiceClient =
   *     BrowserLanguageServiceClient.create()) {
   *   ListBrowserLanguagesRequest request =
   *       ListBrowserLanguagesRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   ApiFuture<BrowserLanguage> future =
   *       browserLanguageServiceClient.listBrowserLanguagesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (BrowserLanguage element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListBrowserLanguagesRequest, ListBrowserLanguagesPagedResponse>
      listBrowserLanguagesPagedCallable() {
    return stub.listBrowserLanguagesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of `BrowserLanguage` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BrowserLanguageServiceClient browserLanguageServiceClient =
   *     BrowserLanguageServiceClient.create()) {
   *   ListBrowserLanguagesRequest request =
   *       ListBrowserLanguagesRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   while (true) {
   *     ListBrowserLanguagesResponse response =
   *         browserLanguageServiceClient.listBrowserLanguagesCallable().call(request);
   *     for (BrowserLanguage element : response.getBrowserLanguagesList()) {
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
  public final UnaryCallable<ListBrowserLanguagesRequest, ListBrowserLanguagesResponse>
      listBrowserLanguagesCallable() {
    return stub.listBrowserLanguagesCallable();
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

  public static class ListBrowserLanguagesPagedResponse
      extends AbstractPagedListResponse<
          ListBrowserLanguagesRequest,
          ListBrowserLanguagesResponse,
          BrowserLanguage,
          ListBrowserLanguagesPage,
          ListBrowserLanguagesFixedSizeCollection> {

    public static ApiFuture<ListBrowserLanguagesPagedResponse> createAsync(
        PageContext<ListBrowserLanguagesRequest, ListBrowserLanguagesResponse, BrowserLanguage>
            context,
        ApiFuture<ListBrowserLanguagesResponse> futureResponse) {
      ApiFuture<ListBrowserLanguagesPage> futurePage =
          ListBrowserLanguagesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListBrowserLanguagesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListBrowserLanguagesPagedResponse(ListBrowserLanguagesPage page) {
      super(page, ListBrowserLanguagesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListBrowserLanguagesPage
      extends AbstractPage<
          ListBrowserLanguagesRequest,
          ListBrowserLanguagesResponse,
          BrowserLanguage,
          ListBrowserLanguagesPage> {

    private ListBrowserLanguagesPage(
        PageContext<ListBrowserLanguagesRequest, ListBrowserLanguagesResponse, BrowserLanguage>
            context,
        ListBrowserLanguagesResponse response) {
      super(context, response);
    }

    private static ListBrowserLanguagesPage createEmptyPage() {
      return new ListBrowserLanguagesPage(null, null);
    }

    @Override
    protected ListBrowserLanguagesPage createPage(
        PageContext<ListBrowserLanguagesRequest, ListBrowserLanguagesResponse, BrowserLanguage>
            context,
        ListBrowserLanguagesResponse response) {
      return new ListBrowserLanguagesPage(context, response);
    }

    @Override
    public ApiFuture<ListBrowserLanguagesPage> createPageAsync(
        PageContext<ListBrowserLanguagesRequest, ListBrowserLanguagesResponse, BrowserLanguage>
            context,
        ApiFuture<ListBrowserLanguagesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListBrowserLanguagesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListBrowserLanguagesRequest,
          ListBrowserLanguagesResponse,
          BrowserLanguage,
          ListBrowserLanguagesPage,
          ListBrowserLanguagesFixedSizeCollection> {

    private ListBrowserLanguagesFixedSizeCollection(
        List<ListBrowserLanguagesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListBrowserLanguagesFixedSizeCollection createEmptyCollection() {
      return new ListBrowserLanguagesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListBrowserLanguagesFixedSizeCollection createCollection(
        List<ListBrowserLanguagesPage> pages, int collectionSize) {
      return new ListBrowserLanguagesFixedSizeCollection(pages, collectionSize);
    }
  }
}
