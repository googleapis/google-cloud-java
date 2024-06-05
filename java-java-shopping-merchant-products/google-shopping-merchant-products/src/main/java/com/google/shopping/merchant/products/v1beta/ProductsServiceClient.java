/*
 * Copyright 2024 Google LLC
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

package com.google.shopping.merchant.products.v1beta;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.shopping.merchant.products.v1beta.stub.ProductsServiceStub;
import com.google.shopping.merchant.products.v1beta.stub.ProductsServiceStubSettings;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Service to use Product resource. This service works for products with online
 * channel only.
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
 * try (ProductsServiceClient productsServiceClient = ProductsServiceClient.create()) {
 *   ProductName name = ProductName.of("[ACCOUNT]", "[PRODUCT]");
 *   Product response = productsServiceClient.getProduct(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the ProductsServiceClient object to clean up resources
 * such as threads. In the example above, try-with-resources is used, which automatically calls
 * close().
 *
 * <table>
 *    <caption>Methods</caption>
 *    <tr>
 *      <th>Method</th>
 *      <th>Description</th>
 *      <th>Method Variants</th>
 *    </tr>
 *    <tr>
 *      <td><p> GetProduct</td>
 *      <td><p> Retrieves the processed product from your Merchant Center account.
 * <p>  After inserting, updating, or deleting a product input, it may take several minutes before the updated final product can be retrieved.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getProduct(GetProductRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getProduct(ProductName name)
 *           <li><p> getProduct(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getProductCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListProducts</td>
 *      <td><p> Lists the processed products in your Merchant Center account. The response might contain fewer items than specified by pageSize. Rely on pageToken to determine if there are more items to be requested.
 * <p>  After inserting, updating, or deleting a product input, it may take several minutes before the updated processed product can be retrieved.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listProducts(ListProductsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listProducts(AccountName parent)
 *           <li><p> listProducts(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listProductsPagedCallable()
 *           <li><p> listProductsCallable()
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
 * <p>This class can be customized by passing in a custom instance of ProductsServiceSettings to
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
 * ProductsServiceSettings productsServiceSettings =
 *     ProductsServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * ProductsServiceClient productsServiceClient =
 *     ProductsServiceClient.create(productsServiceSettings);
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
 * ProductsServiceSettings productsServiceSettings =
 *     ProductsServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * ProductsServiceClient productsServiceClient =
 *     ProductsServiceClient.create(productsServiceSettings);
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
 * ProductsServiceSettings productsServiceSettings =
 *     ProductsServiceSettings.newHttpJsonBuilder().build();
 * ProductsServiceClient productsServiceClient =
 *     ProductsServiceClient.create(productsServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class ProductsServiceClient implements BackgroundResource {
  private final ProductsServiceSettings settings;
  private final ProductsServiceStub stub;

  /** Constructs an instance of ProductsServiceClient with default settings. */
  public static final ProductsServiceClient create() throws IOException {
    return create(ProductsServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of ProductsServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final ProductsServiceClient create(ProductsServiceSettings settings)
      throws IOException {
    return new ProductsServiceClient(settings);
  }

  /**
   * Constructs an instance of ProductsServiceClient, using the given stub for making calls. This is
   * for advanced usage - prefer using create(ProductsServiceSettings).
   */
  public static final ProductsServiceClient create(ProductsServiceStub stub) {
    return new ProductsServiceClient(stub);
  }

  /**
   * Constructs an instance of ProductsServiceClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected ProductsServiceClient(ProductsServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((ProductsServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected ProductsServiceClient(ProductsServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final ProductsServiceSettings getSettings() {
    return settings;
  }

  public ProductsServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the processed product from your Merchant Center account.
   *
   * <p>After inserting, updating, or deleting a product input, it may take several minutes before
   * the updated final product can be retrieved.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProductsServiceClient productsServiceClient = ProductsServiceClient.create()) {
   *   ProductName name = ProductName.of("[ACCOUNT]", "[PRODUCT]");
   *   Product response = productsServiceClient.getProduct(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the product to retrieve. Format:
   *     `accounts/{account}/products/{product}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Product getProduct(ProductName name) {
    GetProductRequest request =
        GetProductRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getProduct(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the processed product from your Merchant Center account.
   *
   * <p>After inserting, updating, or deleting a product input, it may take several minutes before
   * the updated final product can be retrieved.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProductsServiceClient productsServiceClient = ProductsServiceClient.create()) {
   *   String name = ProductName.of("[ACCOUNT]", "[PRODUCT]").toString();
   *   Product response = productsServiceClient.getProduct(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the product to retrieve. Format:
   *     `accounts/{account}/products/{product}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Product getProduct(String name) {
    GetProductRequest request = GetProductRequest.newBuilder().setName(name).build();
    return getProduct(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the processed product from your Merchant Center account.
   *
   * <p>After inserting, updating, or deleting a product input, it may take several minutes before
   * the updated final product can be retrieved.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProductsServiceClient productsServiceClient = ProductsServiceClient.create()) {
   *   GetProductRequest request =
   *       GetProductRequest.newBuilder()
   *           .setName(ProductName.of("[ACCOUNT]", "[PRODUCT]").toString())
   *           .build();
   *   Product response = productsServiceClient.getProduct(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Product getProduct(GetProductRequest request) {
    return getProductCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the processed product from your Merchant Center account.
   *
   * <p>After inserting, updating, or deleting a product input, it may take several minutes before
   * the updated final product can be retrieved.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProductsServiceClient productsServiceClient = ProductsServiceClient.create()) {
   *   GetProductRequest request =
   *       GetProductRequest.newBuilder()
   *           .setName(ProductName.of("[ACCOUNT]", "[PRODUCT]").toString())
   *           .build();
   *   ApiFuture<Product> future = productsServiceClient.getProductCallable().futureCall(request);
   *   // Do something.
   *   Product response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetProductRequest, Product> getProductCallable() {
    return stub.getProductCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the processed products in your Merchant Center account. The response might contain fewer
   * items than specified by pageSize. Rely on pageToken to determine if there are more items to be
   * requested.
   *
   * <p>After inserting, updating, or deleting a product input, it may take several minutes before
   * the updated processed product can be retrieved.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProductsServiceClient productsServiceClient = ProductsServiceClient.create()) {
   *   AccountName parent = AccountName.of("[ACCOUNT]");
   *   for (Product element : productsServiceClient.listProducts(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The account to list processed products for. Format: accounts/{account}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListProductsPagedResponse listProducts(AccountName parent) {
    ListProductsRequest request =
        ListProductsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listProducts(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the processed products in your Merchant Center account. The response might contain fewer
   * items than specified by pageSize. Rely on pageToken to determine if there are more items to be
   * requested.
   *
   * <p>After inserting, updating, or deleting a product input, it may take several minutes before
   * the updated processed product can be retrieved.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProductsServiceClient productsServiceClient = ProductsServiceClient.create()) {
   *   String parent = AccountName.of("[ACCOUNT]").toString();
   *   for (Product element : productsServiceClient.listProducts(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The account to list processed products for. Format: accounts/{account}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListProductsPagedResponse listProducts(String parent) {
    ListProductsRequest request = ListProductsRequest.newBuilder().setParent(parent).build();
    return listProducts(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the processed products in your Merchant Center account. The response might contain fewer
   * items than specified by pageSize. Rely on pageToken to determine if there are more items to be
   * requested.
   *
   * <p>After inserting, updating, or deleting a product input, it may take several minutes before
   * the updated processed product can be retrieved.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProductsServiceClient productsServiceClient = ProductsServiceClient.create()) {
   *   ListProductsRequest request =
   *       ListProductsRequest.newBuilder()
   *           .setParent(AccountName.of("[ACCOUNT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Product element : productsServiceClient.listProducts(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListProductsPagedResponse listProducts(ListProductsRequest request) {
    return listProductsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the processed products in your Merchant Center account. The response might contain fewer
   * items than specified by pageSize. Rely on pageToken to determine if there are more items to be
   * requested.
   *
   * <p>After inserting, updating, or deleting a product input, it may take several minutes before
   * the updated processed product can be retrieved.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProductsServiceClient productsServiceClient = ProductsServiceClient.create()) {
   *   ListProductsRequest request =
   *       ListProductsRequest.newBuilder()
   *           .setParent(AccountName.of("[ACCOUNT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Product> future =
   *       productsServiceClient.listProductsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Product element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListProductsRequest, ListProductsPagedResponse>
      listProductsPagedCallable() {
    return stub.listProductsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the processed products in your Merchant Center account. The response might contain fewer
   * items than specified by pageSize. Rely on pageToken to determine if there are more items to be
   * requested.
   *
   * <p>After inserting, updating, or deleting a product input, it may take several minutes before
   * the updated processed product can be retrieved.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProductsServiceClient productsServiceClient = ProductsServiceClient.create()) {
   *   ListProductsRequest request =
   *       ListProductsRequest.newBuilder()
   *           .setParent(AccountName.of("[ACCOUNT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListProductsResponse response = productsServiceClient.listProductsCallable().call(request);
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
  public final UnaryCallable<ListProductsRequest, ListProductsResponse> listProductsCallable() {
    return stub.listProductsCallable();
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

  public static class ListProductsPagedResponse
      extends AbstractPagedListResponse<
          ListProductsRequest,
          ListProductsResponse,
          Product,
          ListProductsPage,
          ListProductsFixedSizeCollection> {

    public static ApiFuture<ListProductsPagedResponse> createAsync(
        PageContext<ListProductsRequest, ListProductsResponse, Product> context,
        ApiFuture<ListProductsResponse> futureResponse) {
      ApiFuture<ListProductsPage> futurePage =
          ListProductsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListProductsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListProductsPagedResponse(ListProductsPage page) {
      super(page, ListProductsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListProductsPage
      extends AbstractPage<ListProductsRequest, ListProductsResponse, Product, ListProductsPage> {

    private ListProductsPage(
        PageContext<ListProductsRequest, ListProductsResponse, Product> context,
        ListProductsResponse response) {
      super(context, response);
    }

    private static ListProductsPage createEmptyPage() {
      return new ListProductsPage(null, null);
    }

    @Override
    protected ListProductsPage createPage(
        PageContext<ListProductsRequest, ListProductsResponse, Product> context,
        ListProductsResponse response) {
      return new ListProductsPage(context, response);
    }

    @Override
    public ApiFuture<ListProductsPage> createPageAsync(
        PageContext<ListProductsRequest, ListProductsResponse, Product> context,
        ApiFuture<ListProductsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListProductsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListProductsRequest,
          ListProductsResponse,
          Product,
          ListProductsPage,
          ListProductsFixedSizeCollection> {

    private ListProductsFixedSizeCollection(List<ListProductsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListProductsFixedSizeCollection createEmptyCollection() {
      return new ListProductsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListProductsFixedSizeCollection createCollection(
        List<ListProductsPage> pages, int collectionSize) {
      return new ListProductsFixedSizeCollection(pages, collectionSize);
    }
  }
}
