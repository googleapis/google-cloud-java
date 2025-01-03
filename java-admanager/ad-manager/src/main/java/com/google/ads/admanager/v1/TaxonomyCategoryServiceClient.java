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

import com.google.ads.admanager.v1.stub.TaxonomyCategoryServiceStub;
import com.google.ads.admanager.v1.stub.TaxonomyCategoryServiceStubSettings;
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
 * Service Description: Provides methods for handling `TaxonomyCategory` objects.
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
 * try (TaxonomyCategoryServiceClient taxonomyCategoryServiceClient =
 *     TaxonomyCategoryServiceClient.create()) {
 *   TaxonomyCategoryName name = TaxonomyCategoryName.of("[NETWORK_CODE]", "[TAXONOMY_CATEGORY]");
 *   TaxonomyCategory response = taxonomyCategoryServiceClient.getTaxonomyCategory(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the TaxonomyCategoryServiceClient object to clean up
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
 *      <td><p> GetTaxonomyCategory</td>
 *      <td><p> API to retrieve a `TaxonomyCategory` object.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getTaxonomyCategory(GetTaxonomyCategoryRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getTaxonomyCategory(TaxonomyCategoryName name)
 *           <li><p> getTaxonomyCategory(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getTaxonomyCategoryCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListTaxonomyCategories</td>
 *      <td><p> API to retrieve a list of `TaxonomyCategory` objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listTaxonomyCategories(ListTaxonomyCategoriesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listTaxonomyCategories(NetworkName parent)
 *           <li><p> listTaxonomyCategories(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listTaxonomyCategoriesPagedCallable()
 *           <li><p> listTaxonomyCategoriesCallable()
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
 * <p>This class can be customized by passing in a custom instance of
 * TaxonomyCategoryServiceSettings to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * TaxonomyCategoryServiceSettings taxonomyCategoryServiceSettings =
 *     TaxonomyCategoryServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * TaxonomyCategoryServiceClient taxonomyCategoryServiceClient =
 *     TaxonomyCategoryServiceClient.create(taxonomyCategoryServiceSettings);
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
 * TaxonomyCategoryServiceSettings taxonomyCategoryServiceSettings =
 *     TaxonomyCategoryServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * TaxonomyCategoryServiceClient taxonomyCategoryServiceClient =
 *     TaxonomyCategoryServiceClient.create(taxonomyCategoryServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class TaxonomyCategoryServiceClient implements BackgroundResource {
  private final TaxonomyCategoryServiceSettings settings;
  private final TaxonomyCategoryServiceStub stub;

  /** Constructs an instance of TaxonomyCategoryServiceClient with default settings. */
  public static final TaxonomyCategoryServiceClient create() throws IOException {
    return create(TaxonomyCategoryServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of TaxonomyCategoryServiceClient, using the given settings. The channels
   * are created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final TaxonomyCategoryServiceClient create(TaxonomyCategoryServiceSettings settings)
      throws IOException {
    return new TaxonomyCategoryServiceClient(settings);
  }

  /**
   * Constructs an instance of TaxonomyCategoryServiceClient, using the given stub for making calls.
   * This is for advanced usage - prefer using create(TaxonomyCategoryServiceSettings).
   */
  public static final TaxonomyCategoryServiceClient create(TaxonomyCategoryServiceStub stub) {
    return new TaxonomyCategoryServiceClient(stub);
  }

  /**
   * Constructs an instance of TaxonomyCategoryServiceClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected TaxonomyCategoryServiceClient(TaxonomyCategoryServiceSettings settings)
      throws IOException {
    this.settings = settings;
    this.stub = ((TaxonomyCategoryServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected TaxonomyCategoryServiceClient(TaxonomyCategoryServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final TaxonomyCategoryServiceSettings getSettings() {
    return settings;
  }

  public TaxonomyCategoryServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a `TaxonomyCategory` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TaxonomyCategoryServiceClient taxonomyCategoryServiceClient =
   *     TaxonomyCategoryServiceClient.create()) {
   *   TaxonomyCategoryName name = TaxonomyCategoryName.of("[NETWORK_CODE]", "[TAXONOMY_CATEGORY]");
   *   TaxonomyCategory response = taxonomyCategoryServiceClient.getTaxonomyCategory(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the TaxonomyCategory. Format:
   *     `networks/{network_code}/taxonomyCategories/{taxonomy_category_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TaxonomyCategory getTaxonomyCategory(TaxonomyCategoryName name) {
    GetTaxonomyCategoryRequest request =
        GetTaxonomyCategoryRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getTaxonomyCategory(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a `TaxonomyCategory` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TaxonomyCategoryServiceClient taxonomyCategoryServiceClient =
   *     TaxonomyCategoryServiceClient.create()) {
   *   String name = TaxonomyCategoryName.of("[NETWORK_CODE]", "[TAXONOMY_CATEGORY]").toString();
   *   TaxonomyCategory response = taxonomyCategoryServiceClient.getTaxonomyCategory(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the TaxonomyCategory. Format:
   *     `networks/{network_code}/taxonomyCategories/{taxonomy_category_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TaxonomyCategory getTaxonomyCategory(String name) {
    GetTaxonomyCategoryRequest request =
        GetTaxonomyCategoryRequest.newBuilder().setName(name).build();
    return getTaxonomyCategory(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a `TaxonomyCategory` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TaxonomyCategoryServiceClient taxonomyCategoryServiceClient =
   *     TaxonomyCategoryServiceClient.create()) {
   *   GetTaxonomyCategoryRequest request =
   *       GetTaxonomyCategoryRequest.newBuilder()
   *           .setName(TaxonomyCategoryName.of("[NETWORK_CODE]", "[TAXONOMY_CATEGORY]").toString())
   *           .build();
   *   TaxonomyCategory response = taxonomyCategoryServiceClient.getTaxonomyCategory(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TaxonomyCategory getTaxonomyCategory(GetTaxonomyCategoryRequest request) {
    return getTaxonomyCategoryCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a `TaxonomyCategory` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TaxonomyCategoryServiceClient taxonomyCategoryServiceClient =
   *     TaxonomyCategoryServiceClient.create()) {
   *   GetTaxonomyCategoryRequest request =
   *       GetTaxonomyCategoryRequest.newBuilder()
   *           .setName(TaxonomyCategoryName.of("[NETWORK_CODE]", "[TAXONOMY_CATEGORY]").toString())
   *           .build();
   *   ApiFuture<TaxonomyCategory> future =
   *       taxonomyCategoryServiceClient.getTaxonomyCategoryCallable().futureCall(request);
   *   // Do something.
   *   TaxonomyCategory response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetTaxonomyCategoryRequest, TaxonomyCategory>
      getTaxonomyCategoryCallable() {
    return stub.getTaxonomyCategoryCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of `TaxonomyCategory` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TaxonomyCategoryServiceClient taxonomyCategoryServiceClient =
   *     TaxonomyCategoryServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   for (TaxonomyCategory element :
   *       taxonomyCategoryServiceClient.listTaxonomyCategories(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of TaxonomyCategories. Format:
   *     `networks/{network_code}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListTaxonomyCategoriesPagedResponse listTaxonomyCategories(NetworkName parent) {
    ListTaxonomyCategoriesRequest request =
        ListTaxonomyCategoriesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listTaxonomyCategories(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of `TaxonomyCategory` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TaxonomyCategoryServiceClient taxonomyCategoryServiceClient =
   *     TaxonomyCategoryServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   for (TaxonomyCategory element :
   *       taxonomyCategoryServiceClient.listTaxonomyCategories(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of TaxonomyCategories. Format:
   *     `networks/{network_code}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListTaxonomyCategoriesPagedResponse listTaxonomyCategories(String parent) {
    ListTaxonomyCategoriesRequest request =
        ListTaxonomyCategoriesRequest.newBuilder().setParent(parent).build();
    return listTaxonomyCategories(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of `TaxonomyCategory` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TaxonomyCategoryServiceClient taxonomyCategoryServiceClient =
   *     TaxonomyCategoryServiceClient.create()) {
   *   ListTaxonomyCategoriesRequest request =
   *       ListTaxonomyCategoriesRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   for (TaxonomyCategory element :
   *       taxonomyCategoryServiceClient.listTaxonomyCategories(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListTaxonomyCategoriesPagedResponse listTaxonomyCategories(
      ListTaxonomyCategoriesRequest request) {
    return listTaxonomyCategoriesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of `TaxonomyCategory` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TaxonomyCategoryServiceClient taxonomyCategoryServiceClient =
   *     TaxonomyCategoryServiceClient.create()) {
   *   ListTaxonomyCategoriesRequest request =
   *       ListTaxonomyCategoriesRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   ApiFuture<TaxonomyCategory> future =
   *       taxonomyCategoryServiceClient.listTaxonomyCategoriesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (TaxonomyCategory element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListTaxonomyCategoriesRequest, ListTaxonomyCategoriesPagedResponse>
      listTaxonomyCategoriesPagedCallable() {
    return stub.listTaxonomyCategoriesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of `TaxonomyCategory` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TaxonomyCategoryServiceClient taxonomyCategoryServiceClient =
   *     TaxonomyCategoryServiceClient.create()) {
   *   ListTaxonomyCategoriesRequest request =
   *       ListTaxonomyCategoriesRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   while (true) {
   *     ListTaxonomyCategoriesResponse response =
   *         taxonomyCategoryServiceClient.listTaxonomyCategoriesCallable().call(request);
   *     for (TaxonomyCategory element : response.getTaxonomyCategoriesList()) {
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
  public final UnaryCallable<ListTaxonomyCategoriesRequest, ListTaxonomyCategoriesResponse>
      listTaxonomyCategoriesCallable() {
    return stub.listTaxonomyCategoriesCallable();
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

  public static class ListTaxonomyCategoriesPagedResponse
      extends AbstractPagedListResponse<
          ListTaxonomyCategoriesRequest,
          ListTaxonomyCategoriesResponse,
          TaxonomyCategory,
          ListTaxonomyCategoriesPage,
          ListTaxonomyCategoriesFixedSizeCollection> {

    public static ApiFuture<ListTaxonomyCategoriesPagedResponse> createAsync(
        PageContext<ListTaxonomyCategoriesRequest, ListTaxonomyCategoriesResponse, TaxonomyCategory>
            context,
        ApiFuture<ListTaxonomyCategoriesResponse> futureResponse) {
      ApiFuture<ListTaxonomyCategoriesPage> futurePage =
          ListTaxonomyCategoriesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListTaxonomyCategoriesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListTaxonomyCategoriesPagedResponse(ListTaxonomyCategoriesPage page) {
      super(page, ListTaxonomyCategoriesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListTaxonomyCategoriesPage
      extends AbstractPage<
          ListTaxonomyCategoriesRequest,
          ListTaxonomyCategoriesResponse,
          TaxonomyCategory,
          ListTaxonomyCategoriesPage> {

    private ListTaxonomyCategoriesPage(
        PageContext<ListTaxonomyCategoriesRequest, ListTaxonomyCategoriesResponse, TaxonomyCategory>
            context,
        ListTaxonomyCategoriesResponse response) {
      super(context, response);
    }

    private static ListTaxonomyCategoriesPage createEmptyPage() {
      return new ListTaxonomyCategoriesPage(null, null);
    }

    @Override
    protected ListTaxonomyCategoriesPage createPage(
        PageContext<ListTaxonomyCategoriesRequest, ListTaxonomyCategoriesResponse, TaxonomyCategory>
            context,
        ListTaxonomyCategoriesResponse response) {
      return new ListTaxonomyCategoriesPage(context, response);
    }

    @Override
    public ApiFuture<ListTaxonomyCategoriesPage> createPageAsync(
        PageContext<ListTaxonomyCategoriesRequest, ListTaxonomyCategoriesResponse, TaxonomyCategory>
            context,
        ApiFuture<ListTaxonomyCategoriesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListTaxonomyCategoriesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListTaxonomyCategoriesRequest,
          ListTaxonomyCategoriesResponse,
          TaxonomyCategory,
          ListTaxonomyCategoriesPage,
          ListTaxonomyCategoriesFixedSizeCollection> {

    private ListTaxonomyCategoriesFixedSizeCollection(
        List<ListTaxonomyCategoriesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListTaxonomyCategoriesFixedSizeCollection createEmptyCollection() {
      return new ListTaxonomyCategoriesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListTaxonomyCategoriesFixedSizeCollection createCollection(
        List<ListTaxonomyCategoriesPage> pages, int collectionSize) {
      return new ListTaxonomyCategoriesFixedSizeCollection(pages, collectionSize);
    }
  }
}
