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

package com.google.cloud.privatecatalog.v1beta1;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.privatecatalog.v1beta1.stub.PrivateCatalogStub;
import com.google.cloud.privatecatalog.v1beta1.stub.PrivateCatalogStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: `PrivateCatalog` allows catalog consumers to retrieve `Catalog`, `Product`
 * and `Version` resources under a target resource context.
 *
 * <p>`Catalog` is computed based on the [Association][]s linked to the target resource and its
 * ancestors. Each association's [google.cloud.privatecatalogproducer.v1beta.Catalog][] is
 * transformed into a `Catalog`. If multiple associations have the same parent
 * [google.cloud.privatecatalogproducer.v1beta.Catalog][], they are de-duplicated into one
 * `Catalog`. Users must have `cloudprivatecatalog.catalogTargets.get` IAM permission on the
 * resource context in order to access catalogs. `Catalog` contains the resource name and a subset
 * of data of the original [google.cloud.privatecatalogproducer.v1beta.Catalog][].
 *
 * <p>`Product` is child resource of the catalog. A `Product` contains the resource name and a
 * subset of the data of the original [google.cloud.privatecatalogproducer.v1beta.Product][].
 *
 * <p>`Version` is child resource of the product. A `Version` contains the resource name and a
 * subset of the data of the original [google.cloud.privatecatalogproducer.v1beta.Version][].
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
 * try (PrivateCatalogClient privateCatalogClient = PrivateCatalogClient.create()) {
 *   SearchCatalogsRequest request =
 *       SearchCatalogsRequest.newBuilder()
 *           .setResource("resource-341064690")
 *           .setQuery("query107944136")
 *           .setPageSize(883849137)
 *           .setPageToken("pageToken873572522")
 *           .build();
 *   for (Catalog element : privateCatalogClient.searchCatalogs(request).iterateAll()) {
 *     // doThingsWith(element);
 *   }
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the PrivateCatalogClient object to clean up resources such
 * as threads. In the example above, try-with-resources is used, which automatically calls close().
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
 * <p>This class can be customized by passing in a custom instance of PrivateCatalogSettings to
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
 * PrivateCatalogSettings privateCatalogSettings =
 *     PrivateCatalogSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * PrivateCatalogClient privateCatalogClient = PrivateCatalogClient.create(privateCatalogSettings);
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
 * PrivateCatalogSettings privateCatalogSettings =
 *     PrivateCatalogSettings.newBuilder().setEndpoint(myEndpoint).build();
 * PrivateCatalogClient privateCatalogClient = PrivateCatalogClient.create(privateCatalogSettings);
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
 * PrivateCatalogSettings privateCatalogSettings =
 *     PrivateCatalogSettings.newBuilder()
 *         .setTransportChannelProvider(
 *             PrivateCatalogSettings.defaultHttpJsonTransportProviderBuilder().build())
 *         .build();
 * PrivateCatalogClient privateCatalogClient = PrivateCatalogClient.create(privateCatalogSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class PrivateCatalogClient implements BackgroundResource {
  private final PrivateCatalogSettings settings;
  private final PrivateCatalogStub stub;

  /** Constructs an instance of PrivateCatalogClient with default settings. */
  public static final PrivateCatalogClient create() throws IOException {
    return create(PrivateCatalogSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of PrivateCatalogClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final PrivateCatalogClient create(PrivateCatalogSettings settings)
      throws IOException {
    return new PrivateCatalogClient(settings);
  }

  /**
   * Constructs an instance of PrivateCatalogClient, using the given stub for making calls. This is
   * for advanced usage - prefer using create(PrivateCatalogSettings).
   */
  public static final PrivateCatalogClient create(PrivateCatalogStub stub) {
    return new PrivateCatalogClient(stub);
  }

  /**
   * Constructs an instance of PrivateCatalogClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected PrivateCatalogClient(PrivateCatalogSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((PrivateCatalogStubSettings) settings.getStubSettings()).createStub();
  }

  protected PrivateCatalogClient(PrivateCatalogStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final PrivateCatalogSettings getSettings() {
    return settings;
  }

  public PrivateCatalogStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Search [Catalog][google.cloud.privatecatalog.v1beta1.Catalog] resources that consumers have
   * access to, within the scope of the consumer cloud resource hierarchy context.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PrivateCatalogClient privateCatalogClient = PrivateCatalogClient.create()) {
   *   SearchCatalogsRequest request =
   *       SearchCatalogsRequest.newBuilder()
   *           .setResource("resource-341064690")
   *           .setQuery("query107944136")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Catalog element : privateCatalogClient.searchCatalogs(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SearchCatalogsPagedResponse searchCatalogs(SearchCatalogsRequest request) {
    return searchCatalogsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Search [Catalog][google.cloud.privatecatalog.v1beta1.Catalog] resources that consumers have
   * access to, within the scope of the consumer cloud resource hierarchy context.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PrivateCatalogClient privateCatalogClient = PrivateCatalogClient.create()) {
   *   SearchCatalogsRequest request =
   *       SearchCatalogsRequest.newBuilder()
   *           .setResource("resource-341064690")
   *           .setQuery("query107944136")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Catalog> future =
   *       privateCatalogClient.searchCatalogsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Catalog element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<SearchCatalogsRequest, SearchCatalogsPagedResponse>
      searchCatalogsPagedCallable() {
    return stub.searchCatalogsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Search [Catalog][google.cloud.privatecatalog.v1beta1.Catalog] resources that consumers have
   * access to, within the scope of the consumer cloud resource hierarchy context.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PrivateCatalogClient privateCatalogClient = PrivateCatalogClient.create()) {
   *   SearchCatalogsRequest request =
   *       SearchCatalogsRequest.newBuilder()
   *           .setResource("resource-341064690")
   *           .setQuery("query107944136")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     SearchCatalogsResponse response =
   *         privateCatalogClient.searchCatalogsCallable().call(request);
   *     for (Catalog element : response.getCatalogsList()) {
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
  public final UnaryCallable<SearchCatalogsRequest, SearchCatalogsResponse>
      searchCatalogsCallable() {
    return stub.searchCatalogsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Search [Product][google.cloud.privatecatalog.v1beta1.Product] resources that consumers have
   * access to, within the scope of the consumer cloud resource hierarchy context.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PrivateCatalogClient privateCatalogClient = PrivateCatalogClient.create()) {
   *   SearchProductsRequest request =
   *       SearchProductsRequest.newBuilder()
   *           .setResource("resource-341064690")
   *           .setQuery("query107944136")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Product element : privateCatalogClient.searchProducts(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SearchProductsPagedResponse searchProducts(SearchProductsRequest request) {
    return searchProductsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Search [Product][google.cloud.privatecatalog.v1beta1.Product] resources that consumers have
   * access to, within the scope of the consumer cloud resource hierarchy context.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PrivateCatalogClient privateCatalogClient = PrivateCatalogClient.create()) {
   *   SearchProductsRequest request =
   *       SearchProductsRequest.newBuilder()
   *           .setResource("resource-341064690")
   *           .setQuery("query107944136")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Product> future =
   *       privateCatalogClient.searchProductsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Product element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<SearchProductsRequest, SearchProductsPagedResponse>
      searchProductsPagedCallable() {
    return stub.searchProductsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Search [Product][google.cloud.privatecatalog.v1beta1.Product] resources that consumers have
   * access to, within the scope of the consumer cloud resource hierarchy context.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PrivateCatalogClient privateCatalogClient = PrivateCatalogClient.create()) {
   *   SearchProductsRequest request =
   *       SearchProductsRequest.newBuilder()
   *           .setResource("resource-341064690")
   *           .setQuery("query107944136")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     SearchProductsResponse response =
   *         privateCatalogClient.searchProductsCallable().call(request);
   *     for (Product element : response.getProductsList()) {
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
  public final UnaryCallable<SearchProductsRequest, SearchProductsResponse>
      searchProductsCallable() {
    return stub.searchProductsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Search [Version][google.cloud.privatecatalog.v1beta1.Version] resources that consumers have
   * access to, within the scope of the consumer cloud resource hierarchy context.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PrivateCatalogClient privateCatalogClient = PrivateCatalogClient.create()) {
   *   SearchVersionsRequest request =
   *       SearchVersionsRequest.newBuilder()
   *           .setResource("resource-341064690")
   *           .setQuery("query107944136")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Version element : privateCatalogClient.searchVersions(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SearchVersionsPagedResponse searchVersions(SearchVersionsRequest request) {
    return searchVersionsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Search [Version][google.cloud.privatecatalog.v1beta1.Version] resources that consumers have
   * access to, within the scope of the consumer cloud resource hierarchy context.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PrivateCatalogClient privateCatalogClient = PrivateCatalogClient.create()) {
   *   SearchVersionsRequest request =
   *       SearchVersionsRequest.newBuilder()
   *           .setResource("resource-341064690")
   *           .setQuery("query107944136")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Version> future =
   *       privateCatalogClient.searchVersionsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Version element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<SearchVersionsRequest, SearchVersionsPagedResponse>
      searchVersionsPagedCallable() {
    return stub.searchVersionsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Search [Version][google.cloud.privatecatalog.v1beta1.Version] resources that consumers have
   * access to, within the scope of the consumer cloud resource hierarchy context.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PrivateCatalogClient privateCatalogClient = PrivateCatalogClient.create()) {
   *   SearchVersionsRequest request =
   *       SearchVersionsRequest.newBuilder()
   *           .setResource("resource-341064690")
   *           .setQuery("query107944136")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     SearchVersionsResponse response =
   *         privateCatalogClient.searchVersionsCallable().call(request);
   *     for (Version element : response.getVersionsList()) {
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
  public final UnaryCallable<SearchVersionsRequest, SearchVersionsResponse>
      searchVersionsCallable() {
    return stub.searchVersionsCallable();
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

  public static class SearchCatalogsPagedResponse
      extends AbstractPagedListResponse<
          SearchCatalogsRequest,
          SearchCatalogsResponse,
          Catalog,
          SearchCatalogsPage,
          SearchCatalogsFixedSizeCollection> {

    public static ApiFuture<SearchCatalogsPagedResponse> createAsync(
        PageContext<SearchCatalogsRequest, SearchCatalogsResponse, Catalog> context,
        ApiFuture<SearchCatalogsResponse> futureResponse) {
      ApiFuture<SearchCatalogsPage> futurePage =
          SearchCatalogsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new SearchCatalogsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private SearchCatalogsPagedResponse(SearchCatalogsPage page) {
      super(page, SearchCatalogsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class SearchCatalogsPage
      extends AbstractPage<
          SearchCatalogsRequest, SearchCatalogsResponse, Catalog, SearchCatalogsPage> {

    private SearchCatalogsPage(
        PageContext<SearchCatalogsRequest, SearchCatalogsResponse, Catalog> context,
        SearchCatalogsResponse response) {
      super(context, response);
    }

    private static SearchCatalogsPage createEmptyPage() {
      return new SearchCatalogsPage(null, null);
    }

    @Override
    protected SearchCatalogsPage createPage(
        PageContext<SearchCatalogsRequest, SearchCatalogsResponse, Catalog> context,
        SearchCatalogsResponse response) {
      return new SearchCatalogsPage(context, response);
    }

    @Override
    public ApiFuture<SearchCatalogsPage> createPageAsync(
        PageContext<SearchCatalogsRequest, SearchCatalogsResponse, Catalog> context,
        ApiFuture<SearchCatalogsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class SearchCatalogsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          SearchCatalogsRequest,
          SearchCatalogsResponse,
          Catalog,
          SearchCatalogsPage,
          SearchCatalogsFixedSizeCollection> {

    private SearchCatalogsFixedSizeCollection(List<SearchCatalogsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static SearchCatalogsFixedSizeCollection createEmptyCollection() {
      return new SearchCatalogsFixedSizeCollection(null, 0);
    }

    @Override
    protected SearchCatalogsFixedSizeCollection createCollection(
        List<SearchCatalogsPage> pages, int collectionSize) {
      return new SearchCatalogsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class SearchProductsPagedResponse
      extends AbstractPagedListResponse<
          SearchProductsRequest,
          SearchProductsResponse,
          Product,
          SearchProductsPage,
          SearchProductsFixedSizeCollection> {

    public static ApiFuture<SearchProductsPagedResponse> createAsync(
        PageContext<SearchProductsRequest, SearchProductsResponse, Product> context,
        ApiFuture<SearchProductsResponse> futureResponse) {
      ApiFuture<SearchProductsPage> futurePage =
          SearchProductsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new SearchProductsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private SearchProductsPagedResponse(SearchProductsPage page) {
      super(page, SearchProductsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class SearchProductsPage
      extends AbstractPage<
          SearchProductsRequest, SearchProductsResponse, Product, SearchProductsPage> {

    private SearchProductsPage(
        PageContext<SearchProductsRequest, SearchProductsResponse, Product> context,
        SearchProductsResponse response) {
      super(context, response);
    }

    private static SearchProductsPage createEmptyPage() {
      return new SearchProductsPage(null, null);
    }

    @Override
    protected SearchProductsPage createPage(
        PageContext<SearchProductsRequest, SearchProductsResponse, Product> context,
        SearchProductsResponse response) {
      return new SearchProductsPage(context, response);
    }

    @Override
    public ApiFuture<SearchProductsPage> createPageAsync(
        PageContext<SearchProductsRequest, SearchProductsResponse, Product> context,
        ApiFuture<SearchProductsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class SearchProductsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          SearchProductsRequest,
          SearchProductsResponse,
          Product,
          SearchProductsPage,
          SearchProductsFixedSizeCollection> {

    private SearchProductsFixedSizeCollection(List<SearchProductsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static SearchProductsFixedSizeCollection createEmptyCollection() {
      return new SearchProductsFixedSizeCollection(null, 0);
    }

    @Override
    protected SearchProductsFixedSizeCollection createCollection(
        List<SearchProductsPage> pages, int collectionSize) {
      return new SearchProductsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class SearchVersionsPagedResponse
      extends AbstractPagedListResponse<
          SearchVersionsRequest,
          SearchVersionsResponse,
          Version,
          SearchVersionsPage,
          SearchVersionsFixedSizeCollection> {

    public static ApiFuture<SearchVersionsPagedResponse> createAsync(
        PageContext<SearchVersionsRequest, SearchVersionsResponse, Version> context,
        ApiFuture<SearchVersionsResponse> futureResponse) {
      ApiFuture<SearchVersionsPage> futurePage =
          SearchVersionsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new SearchVersionsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private SearchVersionsPagedResponse(SearchVersionsPage page) {
      super(page, SearchVersionsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class SearchVersionsPage
      extends AbstractPage<
          SearchVersionsRequest, SearchVersionsResponse, Version, SearchVersionsPage> {

    private SearchVersionsPage(
        PageContext<SearchVersionsRequest, SearchVersionsResponse, Version> context,
        SearchVersionsResponse response) {
      super(context, response);
    }

    private static SearchVersionsPage createEmptyPage() {
      return new SearchVersionsPage(null, null);
    }

    @Override
    protected SearchVersionsPage createPage(
        PageContext<SearchVersionsRequest, SearchVersionsResponse, Version> context,
        SearchVersionsResponse response) {
      return new SearchVersionsPage(context, response);
    }

    @Override
    public ApiFuture<SearchVersionsPage> createPageAsync(
        PageContext<SearchVersionsRequest, SearchVersionsResponse, Version> context,
        ApiFuture<SearchVersionsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class SearchVersionsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          SearchVersionsRequest,
          SearchVersionsResponse,
          Version,
          SearchVersionsPage,
          SearchVersionsFixedSizeCollection> {

    private SearchVersionsFixedSizeCollection(List<SearchVersionsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static SearchVersionsFixedSizeCollection createEmptyCollection() {
      return new SearchVersionsFixedSizeCollection(null, 0);
    }

    @Override
    protected SearchVersionsFixedSizeCollection createCollection(
        List<SearchVersionsPage> pages, int collectionSize) {
      return new SearchVersionsFixedSizeCollection(pages, collectionSize);
    }
  }
}
