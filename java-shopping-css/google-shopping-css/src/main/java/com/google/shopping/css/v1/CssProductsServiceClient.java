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

package com.google.shopping.css.v1;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.shopping.css.v1.stub.CssProductsServiceStub;
import com.google.shopping.css.v1.stub.CssProductsServiceStubSettings;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Service for doing get and list on Css Products(a.k.a Aggregate Offers
 * internally).
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
 * try (CssProductsServiceClient cssProductsServiceClient = CssProductsServiceClient.create()) {
 *   CssProductName name = CssProductName.of("[ACCOUNT]", "[CSS_PRODUCT]");
 *   CssProduct response = cssProductsServiceClient.getCssProduct(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the CssProductsServiceClient object to clean up resources
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
 *      <td><p> GetCssProduct</td>
 *      <td><p> Retrieves the processed CSS Product from your CSS Center account. After inserting, updating, or deleting a product input, it may take several minutes before the updated final product can be retrieved.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getCssProduct(GetCssProductRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getCssProduct(CssProductName name)
 *           <li><p> getCssProduct(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getCssProductCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListCssProducts</td>
 *      <td><p> Lists the processed CSS Products in your CSS Center account. The response might contain fewer items than specified by pageSize. Rely on pageToken to determine if there are more items to be requested.
 * <p>  After inserting, updating, or deleting a CSS product input, it may take several minutes before the updated processed CSS product can be retrieved.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listCssProducts(ListCssProductsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listCssProducts(AccountName parent)
 *           <li><p> listCssProducts(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listCssProductsPagedCallable()
 *           <li><p> listCssProductsCallable()
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
 * <p>This class can be customized by passing in a custom instance of CssProductsServiceSettings to
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
 * CssProductsServiceSettings cssProductsServiceSettings =
 *     CssProductsServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * CssProductsServiceClient cssProductsServiceClient =
 *     CssProductsServiceClient.create(cssProductsServiceSettings);
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
 * CssProductsServiceSettings cssProductsServiceSettings =
 *     CssProductsServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * CssProductsServiceClient cssProductsServiceClient =
 *     CssProductsServiceClient.create(cssProductsServiceSettings);
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
 * CssProductsServiceSettings cssProductsServiceSettings =
 *     CssProductsServiceSettings.newHttpJsonBuilder().build();
 * CssProductsServiceClient cssProductsServiceClient =
 *     CssProductsServiceClient.create(cssProductsServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class CssProductsServiceClient implements BackgroundResource {
  private final CssProductsServiceSettings settings;
  private final CssProductsServiceStub stub;

  /** Constructs an instance of CssProductsServiceClient with default settings. */
  public static final CssProductsServiceClient create() throws IOException {
    return create(CssProductsServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of CssProductsServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final CssProductsServiceClient create(CssProductsServiceSettings settings)
      throws IOException {
    return new CssProductsServiceClient(settings);
  }

  /**
   * Constructs an instance of CssProductsServiceClient, using the given stub for making calls. This
   * is for advanced usage - prefer using create(CssProductsServiceSettings).
   */
  public static final CssProductsServiceClient create(CssProductsServiceStub stub) {
    return new CssProductsServiceClient(stub);
  }

  /**
   * Constructs an instance of CssProductsServiceClient, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected CssProductsServiceClient(CssProductsServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((CssProductsServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected CssProductsServiceClient(CssProductsServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final CssProductsServiceSettings getSettings() {
    return settings;
  }

  public CssProductsServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the processed CSS Product from your CSS Center account. After inserting, updating, or
   * deleting a product input, it may take several minutes before the updated final product can be
   * retrieved.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CssProductsServiceClient cssProductsServiceClient = CssProductsServiceClient.create()) {
   *   CssProductName name = CssProductName.of("[ACCOUNT]", "[CSS_PRODUCT]");
   *   CssProduct response = cssProductsServiceClient.getCssProduct(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the CSS product to retrieve.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CssProduct getCssProduct(CssProductName name) {
    GetCssProductRequest request =
        GetCssProductRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getCssProduct(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the processed CSS Product from your CSS Center account. After inserting, updating, or
   * deleting a product input, it may take several minutes before the updated final product can be
   * retrieved.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CssProductsServiceClient cssProductsServiceClient = CssProductsServiceClient.create()) {
   *   String name = CssProductName.of("[ACCOUNT]", "[CSS_PRODUCT]").toString();
   *   CssProduct response = cssProductsServiceClient.getCssProduct(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the CSS product to retrieve.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CssProduct getCssProduct(String name) {
    GetCssProductRequest request = GetCssProductRequest.newBuilder().setName(name).build();
    return getCssProduct(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the processed CSS Product from your CSS Center account. After inserting, updating, or
   * deleting a product input, it may take several minutes before the updated final product can be
   * retrieved.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CssProductsServiceClient cssProductsServiceClient = CssProductsServiceClient.create()) {
   *   GetCssProductRequest request =
   *       GetCssProductRequest.newBuilder()
   *           .setName(CssProductName.of("[ACCOUNT]", "[CSS_PRODUCT]").toString())
   *           .build();
   *   CssProduct response = cssProductsServiceClient.getCssProduct(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CssProduct getCssProduct(GetCssProductRequest request) {
    return getCssProductCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the processed CSS Product from your CSS Center account. After inserting, updating, or
   * deleting a product input, it may take several minutes before the updated final product can be
   * retrieved.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CssProductsServiceClient cssProductsServiceClient = CssProductsServiceClient.create()) {
   *   GetCssProductRequest request =
   *       GetCssProductRequest.newBuilder()
   *           .setName(CssProductName.of("[ACCOUNT]", "[CSS_PRODUCT]").toString())
   *           .build();
   *   ApiFuture<CssProduct> future =
   *       cssProductsServiceClient.getCssProductCallable().futureCall(request);
   *   // Do something.
   *   CssProduct response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetCssProductRequest, CssProduct> getCssProductCallable() {
    return stub.getCssProductCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the processed CSS Products in your CSS Center account. The response might contain fewer
   * items than specified by pageSize. Rely on pageToken to determine if there are more items to be
   * requested.
   *
   * <p>After inserting, updating, or deleting a CSS product input, it may take several minutes
   * before the updated processed CSS product can be retrieved.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CssProductsServiceClient cssProductsServiceClient = CssProductsServiceClient.create()) {
   *   AccountName parent = AccountName.of("[ACCOUNT]");
   *   for (CssProduct element : cssProductsServiceClient.listCssProducts(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The account/domain to list processed CSS Products for. Format:
   *     accounts/{account}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCssProductsPagedResponse listCssProducts(AccountName parent) {
    ListCssProductsRequest request =
        ListCssProductsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listCssProducts(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the processed CSS Products in your CSS Center account. The response might contain fewer
   * items than specified by pageSize. Rely on pageToken to determine if there are more items to be
   * requested.
   *
   * <p>After inserting, updating, or deleting a CSS product input, it may take several minutes
   * before the updated processed CSS product can be retrieved.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CssProductsServiceClient cssProductsServiceClient = CssProductsServiceClient.create()) {
   *   String parent = AccountName.of("[ACCOUNT]").toString();
   *   for (CssProduct element : cssProductsServiceClient.listCssProducts(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The account/domain to list processed CSS Products for. Format:
   *     accounts/{account}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCssProductsPagedResponse listCssProducts(String parent) {
    ListCssProductsRequest request = ListCssProductsRequest.newBuilder().setParent(parent).build();
    return listCssProducts(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the processed CSS Products in your CSS Center account. The response might contain fewer
   * items than specified by pageSize. Rely on pageToken to determine if there are more items to be
   * requested.
   *
   * <p>After inserting, updating, or deleting a CSS product input, it may take several minutes
   * before the updated processed CSS product can be retrieved.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CssProductsServiceClient cssProductsServiceClient = CssProductsServiceClient.create()) {
   *   ListCssProductsRequest request =
   *       ListCssProductsRequest.newBuilder()
   *           .setParent(AccountName.of("[ACCOUNT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (CssProduct element : cssProductsServiceClient.listCssProducts(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCssProductsPagedResponse listCssProducts(ListCssProductsRequest request) {
    return listCssProductsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the processed CSS Products in your CSS Center account. The response might contain fewer
   * items than specified by pageSize. Rely on pageToken to determine if there are more items to be
   * requested.
   *
   * <p>After inserting, updating, or deleting a CSS product input, it may take several minutes
   * before the updated processed CSS product can be retrieved.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CssProductsServiceClient cssProductsServiceClient = CssProductsServiceClient.create()) {
   *   ListCssProductsRequest request =
   *       ListCssProductsRequest.newBuilder()
   *           .setParent(AccountName.of("[ACCOUNT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<CssProduct> future =
   *       cssProductsServiceClient.listCssProductsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (CssProduct element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListCssProductsRequest, ListCssProductsPagedResponse>
      listCssProductsPagedCallable() {
    return stub.listCssProductsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the processed CSS Products in your CSS Center account. The response might contain fewer
   * items than specified by pageSize. Rely on pageToken to determine if there are more items to be
   * requested.
   *
   * <p>After inserting, updating, or deleting a CSS product input, it may take several minutes
   * before the updated processed CSS product can be retrieved.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CssProductsServiceClient cssProductsServiceClient = CssProductsServiceClient.create()) {
   *   ListCssProductsRequest request =
   *       ListCssProductsRequest.newBuilder()
   *           .setParent(AccountName.of("[ACCOUNT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListCssProductsResponse response =
   *         cssProductsServiceClient.listCssProductsCallable().call(request);
   *     for (CssProduct element : response.getCssProductsList()) {
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
  public final UnaryCallable<ListCssProductsRequest, ListCssProductsResponse>
      listCssProductsCallable() {
    return stub.listCssProductsCallable();
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

  public static class ListCssProductsPagedResponse
      extends AbstractPagedListResponse<
          ListCssProductsRequest,
          ListCssProductsResponse,
          CssProduct,
          ListCssProductsPage,
          ListCssProductsFixedSizeCollection> {

    public static ApiFuture<ListCssProductsPagedResponse> createAsync(
        PageContext<ListCssProductsRequest, ListCssProductsResponse, CssProduct> context,
        ApiFuture<ListCssProductsResponse> futureResponse) {
      ApiFuture<ListCssProductsPage> futurePage =
          ListCssProductsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListCssProductsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListCssProductsPagedResponse(ListCssProductsPage page) {
      super(page, ListCssProductsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListCssProductsPage
      extends AbstractPage<
          ListCssProductsRequest, ListCssProductsResponse, CssProduct, ListCssProductsPage> {

    private ListCssProductsPage(
        PageContext<ListCssProductsRequest, ListCssProductsResponse, CssProduct> context,
        ListCssProductsResponse response) {
      super(context, response);
    }

    private static ListCssProductsPage createEmptyPage() {
      return new ListCssProductsPage(null, null);
    }

    @Override
    protected ListCssProductsPage createPage(
        PageContext<ListCssProductsRequest, ListCssProductsResponse, CssProduct> context,
        ListCssProductsResponse response) {
      return new ListCssProductsPage(context, response);
    }

    @Override
    public ApiFuture<ListCssProductsPage> createPageAsync(
        PageContext<ListCssProductsRequest, ListCssProductsResponse, CssProduct> context,
        ApiFuture<ListCssProductsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListCssProductsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListCssProductsRequest,
          ListCssProductsResponse,
          CssProduct,
          ListCssProductsPage,
          ListCssProductsFixedSizeCollection> {

    private ListCssProductsFixedSizeCollection(
        List<ListCssProductsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListCssProductsFixedSizeCollection createEmptyCollection() {
      return new ListCssProductsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListCssProductsFixedSizeCollection createCollection(
        List<ListCssProductsPage> pages, int collectionSize) {
      return new ListCssProductsFixedSizeCollection(pages, collectionSize);
    }
  }
}
