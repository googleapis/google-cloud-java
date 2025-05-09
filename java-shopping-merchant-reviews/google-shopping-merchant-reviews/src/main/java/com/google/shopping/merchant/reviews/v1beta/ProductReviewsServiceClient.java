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

package com.google.shopping.merchant.reviews.v1beta;

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
import com.google.protobuf.Empty;
import com.google.shopping.merchant.reviews.v1beta.stub.ProductReviewsServiceStub;
import com.google.shopping.merchant.reviews.v1beta.stub.ProductReviewsServiceStubSettings;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Service to manage product reviews.
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
 * try (ProductReviewsServiceClient productReviewsServiceClient =
 *     ProductReviewsServiceClient.create()) {
 *   ProductReviewName name = ProductReviewName.of("[ACCOUNT]", "[PRODUCTREVIEW]");
 *   ProductReview response = productReviewsServiceClient.getProductReview(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the ProductReviewsServiceClient object to clean up
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
 *      <td><p> GetProductReview</td>
 *      <td><p> Gets a product review.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getProductReview(GetProductReviewRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getProductReview(ProductReviewName name)
 *           <li><p> getProductReview(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getProductReviewCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListProductReviews</td>
 *      <td><p> Lists product reviews.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listProductReviews(ListProductReviewsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listProductReviews(AccountName parent)
 *           <li><p> listProductReviews(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listProductReviewsPagedCallable()
 *           <li><p> listProductReviewsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> InsertProductReview</td>
 *      <td><p> Inserts a product review.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> insertProductReview(InsertProductReviewRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> insertProductReviewCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteProductReview</td>
 *      <td><p> Deletes a product review.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteProductReview(DeleteProductReviewRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deleteProductReview(ProductReviewName name)
 *           <li><p> deleteProductReview(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteProductReviewCallable()
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
 * <p>This class can be customized by passing in a custom instance of ProductReviewsServiceSettings
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
 * ProductReviewsServiceSettings productReviewsServiceSettings =
 *     ProductReviewsServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * ProductReviewsServiceClient productReviewsServiceClient =
 *     ProductReviewsServiceClient.create(productReviewsServiceSettings);
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
 * ProductReviewsServiceSettings productReviewsServiceSettings =
 *     ProductReviewsServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * ProductReviewsServiceClient productReviewsServiceClient =
 *     ProductReviewsServiceClient.create(productReviewsServiceSettings);
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
 * ProductReviewsServiceSettings productReviewsServiceSettings =
 *     ProductReviewsServiceSettings.newHttpJsonBuilder().build();
 * ProductReviewsServiceClient productReviewsServiceClient =
 *     ProductReviewsServiceClient.create(productReviewsServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class ProductReviewsServiceClient implements BackgroundResource {
  private final ProductReviewsServiceSettings settings;
  private final ProductReviewsServiceStub stub;

  /** Constructs an instance of ProductReviewsServiceClient with default settings. */
  public static final ProductReviewsServiceClient create() throws IOException {
    return create(ProductReviewsServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of ProductReviewsServiceClient, using the given settings. The channels
   * are created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final ProductReviewsServiceClient create(ProductReviewsServiceSettings settings)
      throws IOException {
    return new ProductReviewsServiceClient(settings);
  }

  /**
   * Constructs an instance of ProductReviewsServiceClient, using the given stub for making calls.
   * This is for advanced usage - prefer using create(ProductReviewsServiceSettings).
   */
  public static final ProductReviewsServiceClient create(ProductReviewsServiceStub stub) {
    return new ProductReviewsServiceClient(stub);
  }

  /**
   * Constructs an instance of ProductReviewsServiceClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected ProductReviewsServiceClient(ProductReviewsServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((ProductReviewsServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected ProductReviewsServiceClient(ProductReviewsServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final ProductReviewsServiceSettings getSettings() {
    return settings;
  }

  public ProductReviewsServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a product review.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProductReviewsServiceClient productReviewsServiceClient =
   *     ProductReviewsServiceClient.create()) {
   *   ProductReviewName name = ProductReviewName.of("[ACCOUNT]", "[PRODUCTREVIEW]");
   *   ProductReview response = productReviewsServiceClient.getProductReview(name);
   * }
   * }</pre>
   *
   * @param name Required. The ID of the merchant review. Format:
   *     accounts/{account}/productReviews/{productReview}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ProductReview getProductReview(ProductReviewName name) {
    GetProductReviewRequest request =
        GetProductReviewRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getProductReview(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a product review.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProductReviewsServiceClient productReviewsServiceClient =
   *     ProductReviewsServiceClient.create()) {
   *   String name = ProductReviewName.of("[ACCOUNT]", "[PRODUCTREVIEW]").toString();
   *   ProductReview response = productReviewsServiceClient.getProductReview(name);
   * }
   * }</pre>
   *
   * @param name Required. The ID of the merchant review. Format:
   *     accounts/{account}/productReviews/{productReview}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ProductReview getProductReview(String name) {
    GetProductReviewRequest request = GetProductReviewRequest.newBuilder().setName(name).build();
    return getProductReview(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a product review.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProductReviewsServiceClient productReviewsServiceClient =
   *     ProductReviewsServiceClient.create()) {
   *   GetProductReviewRequest request =
   *       GetProductReviewRequest.newBuilder()
   *           .setName(ProductReviewName.of("[ACCOUNT]", "[PRODUCTREVIEW]").toString())
   *           .build();
   *   ProductReview response = productReviewsServiceClient.getProductReview(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ProductReview getProductReview(GetProductReviewRequest request) {
    return getProductReviewCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a product review.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProductReviewsServiceClient productReviewsServiceClient =
   *     ProductReviewsServiceClient.create()) {
   *   GetProductReviewRequest request =
   *       GetProductReviewRequest.newBuilder()
   *           .setName(ProductReviewName.of("[ACCOUNT]", "[PRODUCTREVIEW]").toString())
   *           .build();
   *   ApiFuture<ProductReview> future =
   *       productReviewsServiceClient.getProductReviewCallable().futureCall(request);
   *   // Do something.
   *   ProductReview response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetProductReviewRequest, ProductReview> getProductReviewCallable() {
    return stub.getProductReviewCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists product reviews.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProductReviewsServiceClient productReviewsServiceClient =
   *     ProductReviewsServiceClient.create()) {
   *   AccountName parent = AccountName.of("[ACCOUNT]");
   *   for (ProductReview element :
   *       productReviewsServiceClient.listProductReviews(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The account to list product reviews for. Format: accounts/{account}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListProductReviewsPagedResponse listProductReviews(AccountName parent) {
    ListProductReviewsRequest request =
        ListProductReviewsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listProductReviews(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists product reviews.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProductReviewsServiceClient productReviewsServiceClient =
   *     ProductReviewsServiceClient.create()) {
   *   String parent = AccountName.of("[ACCOUNT]").toString();
   *   for (ProductReview element :
   *       productReviewsServiceClient.listProductReviews(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The account to list product reviews for. Format: accounts/{account}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListProductReviewsPagedResponse listProductReviews(String parent) {
    ListProductReviewsRequest request =
        ListProductReviewsRequest.newBuilder().setParent(parent).build();
    return listProductReviews(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists product reviews.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProductReviewsServiceClient productReviewsServiceClient =
   *     ProductReviewsServiceClient.create()) {
   *   ListProductReviewsRequest request =
   *       ListProductReviewsRequest.newBuilder()
   *           .setParent(AccountName.of("[ACCOUNT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (ProductReview element :
   *       productReviewsServiceClient.listProductReviews(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListProductReviewsPagedResponse listProductReviews(
      ListProductReviewsRequest request) {
    return listProductReviewsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists product reviews.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProductReviewsServiceClient productReviewsServiceClient =
   *     ProductReviewsServiceClient.create()) {
   *   ListProductReviewsRequest request =
   *       ListProductReviewsRequest.newBuilder()
   *           .setParent(AccountName.of("[ACCOUNT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<ProductReview> future =
   *       productReviewsServiceClient.listProductReviewsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (ProductReview element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListProductReviewsRequest, ListProductReviewsPagedResponse>
      listProductReviewsPagedCallable() {
    return stub.listProductReviewsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists product reviews.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProductReviewsServiceClient productReviewsServiceClient =
   *     ProductReviewsServiceClient.create()) {
   *   ListProductReviewsRequest request =
   *       ListProductReviewsRequest.newBuilder()
   *           .setParent(AccountName.of("[ACCOUNT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListProductReviewsResponse response =
   *         productReviewsServiceClient.listProductReviewsCallable().call(request);
   *     for (ProductReview element : response.getProductReviewsList()) {
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
  public final UnaryCallable<ListProductReviewsRequest, ListProductReviewsResponse>
      listProductReviewsCallable() {
    return stub.listProductReviewsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Inserts a product review.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProductReviewsServiceClient productReviewsServiceClient =
   *     ProductReviewsServiceClient.create()) {
   *   InsertProductReviewRequest request =
   *       InsertProductReviewRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setProductReview(ProductReview.newBuilder().build())
   *           .setDataSource("dataSource1272470629")
   *           .build();
   *   ProductReview response = productReviewsServiceClient.insertProductReview(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ProductReview insertProductReview(InsertProductReviewRequest request) {
    return insertProductReviewCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Inserts a product review.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProductReviewsServiceClient productReviewsServiceClient =
   *     ProductReviewsServiceClient.create()) {
   *   InsertProductReviewRequest request =
   *       InsertProductReviewRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setProductReview(ProductReview.newBuilder().build())
   *           .setDataSource("dataSource1272470629")
   *           .build();
   *   ApiFuture<ProductReview> future =
   *       productReviewsServiceClient.insertProductReviewCallable().futureCall(request);
   *   // Do something.
   *   ProductReview response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<InsertProductReviewRequest, ProductReview>
      insertProductReviewCallable() {
    return stub.insertProductReviewCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a product review.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProductReviewsServiceClient productReviewsServiceClient =
   *     ProductReviewsServiceClient.create()) {
   *   ProductReviewName name = ProductReviewName.of("[ACCOUNT]", "[PRODUCTREVIEW]");
   *   productReviewsServiceClient.deleteProductReview(name);
   * }
   * }</pre>
   *
   * @param name Required. The ID of the Product review. Format:
   *     accounts/{account}/productReviews/{productReview}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteProductReview(ProductReviewName name) {
    DeleteProductReviewRequest request =
        DeleteProductReviewRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    deleteProductReview(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a product review.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProductReviewsServiceClient productReviewsServiceClient =
   *     ProductReviewsServiceClient.create()) {
   *   String name = ProductReviewName.of("[ACCOUNT]", "[PRODUCTREVIEW]").toString();
   *   productReviewsServiceClient.deleteProductReview(name);
   * }
   * }</pre>
   *
   * @param name Required. The ID of the Product review. Format:
   *     accounts/{account}/productReviews/{productReview}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteProductReview(String name) {
    DeleteProductReviewRequest request =
        DeleteProductReviewRequest.newBuilder().setName(name).build();
    deleteProductReview(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a product review.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProductReviewsServiceClient productReviewsServiceClient =
   *     ProductReviewsServiceClient.create()) {
   *   DeleteProductReviewRequest request =
   *       DeleteProductReviewRequest.newBuilder()
   *           .setName(ProductReviewName.of("[ACCOUNT]", "[PRODUCTREVIEW]").toString())
   *           .build();
   *   productReviewsServiceClient.deleteProductReview(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteProductReview(DeleteProductReviewRequest request) {
    deleteProductReviewCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a product review.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProductReviewsServiceClient productReviewsServiceClient =
   *     ProductReviewsServiceClient.create()) {
   *   DeleteProductReviewRequest request =
   *       DeleteProductReviewRequest.newBuilder()
   *           .setName(ProductReviewName.of("[ACCOUNT]", "[PRODUCTREVIEW]").toString())
   *           .build();
   *   ApiFuture<Empty> future =
   *       productReviewsServiceClient.deleteProductReviewCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteProductReviewRequest, Empty> deleteProductReviewCallable() {
    return stub.deleteProductReviewCallable();
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

  public static class ListProductReviewsPagedResponse
      extends AbstractPagedListResponse<
          ListProductReviewsRequest,
          ListProductReviewsResponse,
          ProductReview,
          ListProductReviewsPage,
          ListProductReviewsFixedSizeCollection> {

    public static ApiFuture<ListProductReviewsPagedResponse> createAsync(
        PageContext<ListProductReviewsRequest, ListProductReviewsResponse, ProductReview> context,
        ApiFuture<ListProductReviewsResponse> futureResponse) {
      ApiFuture<ListProductReviewsPage> futurePage =
          ListProductReviewsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListProductReviewsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListProductReviewsPagedResponse(ListProductReviewsPage page) {
      super(page, ListProductReviewsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListProductReviewsPage
      extends AbstractPage<
          ListProductReviewsRequest,
          ListProductReviewsResponse,
          ProductReview,
          ListProductReviewsPage> {

    private ListProductReviewsPage(
        PageContext<ListProductReviewsRequest, ListProductReviewsResponse, ProductReview> context,
        ListProductReviewsResponse response) {
      super(context, response);
    }

    private static ListProductReviewsPage createEmptyPage() {
      return new ListProductReviewsPage(null, null);
    }

    @Override
    protected ListProductReviewsPage createPage(
        PageContext<ListProductReviewsRequest, ListProductReviewsResponse, ProductReview> context,
        ListProductReviewsResponse response) {
      return new ListProductReviewsPage(context, response);
    }

    @Override
    public ApiFuture<ListProductReviewsPage> createPageAsync(
        PageContext<ListProductReviewsRequest, ListProductReviewsResponse, ProductReview> context,
        ApiFuture<ListProductReviewsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListProductReviewsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListProductReviewsRequest,
          ListProductReviewsResponse,
          ProductReview,
          ListProductReviewsPage,
          ListProductReviewsFixedSizeCollection> {

    private ListProductReviewsFixedSizeCollection(
        List<ListProductReviewsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListProductReviewsFixedSizeCollection createEmptyCollection() {
      return new ListProductReviewsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListProductReviewsFixedSizeCollection createCollection(
        List<ListProductReviewsPage> pages, int collectionSize) {
      return new ListProductReviewsFixedSizeCollection(pages, collectionSize);
    }
  }
}
