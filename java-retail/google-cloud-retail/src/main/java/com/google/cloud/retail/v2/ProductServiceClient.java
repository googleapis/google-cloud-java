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

package com.google.cloud.retail.v2;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.httpjson.longrunning.OperationsClient;
import com.google.api.gax.longrunning.OperationFuture;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.retail.v2.stub.ProductServiceStub;
import com.google.cloud.retail.v2.stub.ProductServiceStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Service for ingesting [Product][google.cloud.retail.v2.Product] information
 * of the customer's website.
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
 * try (ProductServiceClient productServiceClient = ProductServiceClient.create()) {
 *   BranchName parent = BranchName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[BRANCH]");
 *   Product product = Product.newBuilder().build();
 *   String productId = "productId-1051830678";
 *   Product response = productServiceClient.createProduct(parent, product, productId);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the ProductServiceClient object to clean up resources such
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
 * <p>This class can be customized by passing in a custom instance of ProductServiceSettings to
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
 * ProductServiceSettings productServiceSettings =
 *     ProductServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * ProductServiceClient productServiceClient = ProductServiceClient.create(productServiceSettings);
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
 * ProductServiceSettings productServiceSettings =
 *     ProductServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * ProductServiceClient productServiceClient = ProductServiceClient.create(productServiceSettings);
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
 * ProductServiceSettings productServiceSettings =
 *     ProductServiceSettings.newHttpJsonBuilder().build();
 * ProductServiceClient productServiceClient = ProductServiceClient.create(productServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class ProductServiceClient implements BackgroundResource {
  private final ProductServiceSettings settings;
  private final ProductServiceStub stub;
  private final OperationsClient httpJsonOperationsClient;
  private final com.google.longrunning.OperationsClient operationsClient;

  /** Constructs an instance of ProductServiceClient with default settings. */
  public static final ProductServiceClient create() throws IOException {
    return create(ProductServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of ProductServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final ProductServiceClient create(ProductServiceSettings settings)
      throws IOException {
    return new ProductServiceClient(settings);
  }

  /**
   * Constructs an instance of ProductServiceClient, using the given stub for making calls. This is
   * for advanced usage - prefer using create(ProductServiceSettings).
   */
  public static final ProductServiceClient create(ProductServiceStub stub) {
    return new ProductServiceClient(stub);
  }

  /**
   * Constructs an instance of ProductServiceClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected ProductServiceClient(ProductServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((ProductServiceStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  protected ProductServiceClient(ProductServiceStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  public final ProductServiceSettings getSettings() {
    return settings;
  }

  public ProductServiceStub getStub() {
    return stub;
  }

  /**
   * Returns the OperationsClient that can be used to query the status of a long-running operation
   * returned by another API method call.
   */
  public final com.google.longrunning.OperationsClient getOperationsClient() {
    return operationsClient;
  }

  /**
   * Returns the OperationsClient that can be used to query the status of a long-running operation
   * returned by another API method call.
   */
  @BetaApi
  public final OperationsClient getHttpJsonOperationsClient() {
    return httpJsonOperationsClient;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a [Product][google.cloud.retail.v2.Product].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProductServiceClient productServiceClient = ProductServiceClient.create()) {
   *   BranchName parent = BranchName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[BRANCH]");
   *   Product product = Product.newBuilder().build();
   *   String productId = "productId-1051830678";
   *   Product response = productServiceClient.createProduct(parent, product, productId);
   * }
   * }</pre>
   *
   * @param parent Required. The parent catalog resource name, such as
   *     `projects/&#42;/locations/global/catalogs/default_catalog/branches/default_branch`.
   * @param product Required. The [Product][google.cloud.retail.v2.Product] to create.
   * @param productId Required. The ID to use for the [Product][google.cloud.retail.v2.Product],
   *     which will become the final component of the
   *     [Product.name][google.cloud.retail.v2.Product.name].
   *     <p>If the caller does not have permission to create the
   *     [Product][google.cloud.retail.v2.Product], regardless of whether or not it exists, a
   *     PERMISSION_DENIED error is returned.
   *     <p>This field must be unique among all [Product][google.cloud.retail.v2.Product]s with the
   *     same [parent][google.cloud.retail.v2.CreateProductRequest.parent]. Otherwise, an
   *     ALREADY_EXISTS error is returned.
   *     <p>This field must be a UTF-8 encoded string with a length limit of 128 characters.
   *     Otherwise, an INVALID_ARGUMENT error is returned.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Product createProduct(BranchName parent, Product product, String productId) {
    CreateProductRequest request =
        CreateProductRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setProduct(product)
            .setProductId(productId)
            .build();
    return createProduct(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a [Product][google.cloud.retail.v2.Product].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProductServiceClient productServiceClient = ProductServiceClient.create()) {
   *   String parent = BranchName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[BRANCH]").toString();
   *   Product product = Product.newBuilder().build();
   *   String productId = "productId-1051830678";
   *   Product response = productServiceClient.createProduct(parent, product, productId);
   * }
   * }</pre>
   *
   * @param parent Required. The parent catalog resource name, such as
   *     `projects/&#42;/locations/global/catalogs/default_catalog/branches/default_branch`.
   * @param product Required. The [Product][google.cloud.retail.v2.Product] to create.
   * @param productId Required. The ID to use for the [Product][google.cloud.retail.v2.Product],
   *     which will become the final component of the
   *     [Product.name][google.cloud.retail.v2.Product.name].
   *     <p>If the caller does not have permission to create the
   *     [Product][google.cloud.retail.v2.Product], regardless of whether or not it exists, a
   *     PERMISSION_DENIED error is returned.
   *     <p>This field must be unique among all [Product][google.cloud.retail.v2.Product]s with the
   *     same [parent][google.cloud.retail.v2.CreateProductRequest.parent]. Otherwise, an
   *     ALREADY_EXISTS error is returned.
   *     <p>This field must be a UTF-8 encoded string with a length limit of 128 characters.
   *     Otherwise, an INVALID_ARGUMENT error is returned.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Product createProduct(String parent, Product product, String productId) {
    CreateProductRequest request =
        CreateProductRequest.newBuilder()
            .setParent(parent)
            .setProduct(product)
            .setProductId(productId)
            .build();
    return createProduct(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a [Product][google.cloud.retail.v2.Product].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProductServiceClient productServiceClient = ProductServiceClient.create()) {
   *   CreateProductRequest request =
   *       CreateProductRequest.newBuilder()
   *           .setParent(
   *               BranchName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[BRANCH]").toString())
   *           .setProduct(Product.newBuilder().build())
   *           .setProductId("productId-1051830678")
   *           .build();
   *   Product response = productServiceClient.createProduct(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Product createProduct(CreateProductRequest request) {
    return createProductCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a [Product][google.cloud.retail.v2.Product].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProductServiceClient productServiceClient = ProductServiceClient.create()) {
   *   CreateProductRequest request =
   *       CreateProductRequest.newBuilder()
   *           .setParent(
   *               BranchName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[BRANCH]").toString())
   *           .setProduct(Product.newBuilder().build())
   *           .setProductId("productId-1051830678")
   *           .build();
   *   ApiFuture<Product> future = productServiceClient.createProductCallable().futureCall(request);
   *   // Do something.
   *   Product response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateProductRequest, Product> createProductCallable() {
    return stub.createProductCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a [Product][google.cloud.retail.v2.Product].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProductServiceClient productServiceClient = ProductServiceClient.create()) {
   *   ProductName name =
   *       ProductName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[BRANCH]", "[PRODUCT]");
   *   Product response = productServiceClient.getProduct(name);
   * }
   * }</pre>
   *
   * @param name Required. Full resource name of [Product][google.cloud.retail.v2.Product], such as
   *     `projects/&#42;/locations/global/catalogs/default_catalog/branches/default_branch/products/some_product_id`.
   *     <p>If the caller does not have permission to access the
   *     [Product][google.cloud.retail.v2.Product], regardless of whether or not it exists, a
   *     PERMISSION_DENIED error is returned.
   *     <p>If the requested [Product][google.cloud.retail.v2.Product] does not exist, a NOT_FOUND
   *     error is returned.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Product getProduct(ProductName name) {
    GetProductRequest request =
        GetProductRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getProduct(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a [Product][google.cloud.retail.v2.Product].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProductServiceClient productServiceClient = ProductServiceClient.create()) {
   *   String name =
   *       ProductName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[BRANCH]", "[PRODUCT]")
   *           .toString();
   *   Product response = productServiceClient.getProduct(name);
   * }
   * }</pre>
   *
   * @param name Required. Full resource name of [Product][google.cloud.retail.v2.Product], such as
   *     `projects/&#42;/locations/global/catalogs/default_catalog/branches/default_branch/products/some_product_id`.
   *     <p>If the caller does not have permission to access the
   *     [Product][google.cloud.retail.v2.Product], regardless of whether or not it exists, a
   *     PERMISSION_DENIED error is returned.
   *     <p>If the requested [Product][google.cloud.retail.v2.Product] does not exist, a NOT_FOUND
   *     error is returned.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Product getProduct(String name) {
    GetProductRequest request = GetProductRequest.newBuilder().setName(name).build();
    return getProduct(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a [Product][google.cloud.retail.v2.Product].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProductServiceClient productServiceClient = ProductServiceClient.create()) {
   *   GetProductRequest request =
   *       GetProductRequest.newBuilder()
   *           .setName(
   *               ProductName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[BRANCH]", "[PRODUCT]")
   *                   .toString())
   *           .build();
   *   Product response = productServiceClient.getProduct(request);
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
   * Gets a [Product][google.cloud.retail.v2.Product].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProductServiceClient productServiceClient = ProductServiceClient.create()) {
   *   GetProductRequest request =
   *       GetProductRequest.newBuilder()
   *           .setName(
   *               ProductName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[BRANCH]", "[PRODUCT]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Product> future = productServiceClient.getProductCallable().futureCall(request);
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
   * Gets a list of [Product][google.cloud.retail.v2.Product]s.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProductServiceClient productServiceClient = ProductServiceClient.create()) {
   *   BranchName parent = BranchName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[BRANCH]");
   *   for (Product element : productServiceClient.listProducts(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent branch resource name, such as
   *     `projects/&#42;/locations/global/catalogs/default_catalog/branches/0`. Use `default_branch`
   *     as the branch ID, to list products under the default branch.
   *     <p>If the caller does not have permission to list
   *     [Product][google.cloud.retail.v2.Product]s under this branch, regardless of whether or not
   *     this branch exists, a PERMISSION_DENIED error is returned.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListProductsPagedResponse listProducts(BranchName parent) {
    ListProductsRequest request =
        ListProductsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listProducts(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a list of [Product][google.cloud.retail.v2.Product]s.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProductServiceClient productServiceClient = ProductServiceClient.create()) {
   *   String parent = BranchName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[BRANCH]").toString();
   *   for (Product element : productServiceClient.listProducts(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent branch resource name, such as
   *     `projects/&#42;/locations/global/catalogs/default_catalog/branches/0`. Use `default_branch`
   *     as the branch ID, to list products under the default branch.
   *     <p>If the caller does not have permission to list
   *     [Product][google.cloud.retail.v2.Product]s under this branch, regardless of whether or not
   *     this branch exists, a PERMISSION_DENIED error is returned.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListProductsPagedResponse listProducts(String parent) {
    ListProductsRequest request = ListProductsRequest.newBuilder().setParent(parent).build();
    return listProducts(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a list of [Product][google.cloud.retail.v2.Product]s.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProductServiceClient productServiceClient = ProductServiceClient.create()) {
   *   ListProductsRequest request =
   *       ListProductsRequest.newBuilder()
   *           .setParent(
   *               BranchName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[BRANCH]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setReadMask(FieldMask.newBuilder().build())
   *           .build();
   *   for (Product element : productServiceClient.listProducts(request).iterateAll()) {
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
   * Gets a list of [Product][google.cloud.retail.v2.Product]s.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProductServiceClient productServiceClient = ProductServiceClient.create()) {
   *   ListProductsRequest request =
   *       ListProductsRequest.newBuilder()
   *           .setParent(
   *               BranchName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[BRANCH]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setReadMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Product> future =
   *       productServiceClient.listProductsPagedCallable().futureCall(request);
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
   * Gets a list of [Product][google.cloud.retail.v2.Product]s.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProductServiceClient productServiceClient = ProductServiceClient.create()) {
   *   ListProductsRequest request =
   *       ListProductsRequest.newBuilder()
   *           .setParent(
   *               BranchName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[BRANCH]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setReadMask(FieldMask.newBuilder().build())
   *           .build();
   *   while (true) {
   *     ListProductsResponse response = productServiceClient.listProductsCallable().call(request);
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

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a [Product][google.cloud.retail.v2.Product].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProductServiceClient productServiceClient = ProductServiceClient.create()) {
   *   Product product = Product.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Product response = productServiceClient.updateProduct(product, updateMask);
   * }
   * }</pre>
   *
   * @param product Required. The product to update/create.
   *     <p>If the caller does not have permission to update the
   *     [Product][google.cloud.retail.v2.Product], regardless of whether or not it exists, a
   *     PERMISSION_DENIED error is returned.
   *     <p>If the [Product][google.cloud.retail.v2.Product] to update does not exist and
   *     [allow_missing][google.cloud.retail.v2.UpdateProductRequest.allow_missing] is not set, a
   *     NOT_FOUND error is returned.
   * @param updateMask Indicates which fields in the provided
   *     [Product][google.cloud.retail.v2.Product] to update. The immutable and output only fields
   *     are NOT supported. If not set, all supported fields (the fields that are neither immutable
   *     nor output only) are updated.
   *     <p>If an unsupported or unknown field is provided, an INVALID_ARGUMENT error is returned.
   *     <p>The attribute key can be updated by setting the mask path as "attributes.${key_name}".
   *     If a key name is present in the mask but not in the patching product from the request, this
   *     key will be deleted after the update.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Product updateProduct(Product product, FieldMask updateMask) {
    UpdateProductRequest request =
        UpdateProductRequest.newBuilder().setProduct(product).setUpdateMask(updateMask).build();
    return updateProduct(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a [Product][google.cloud.retail.v2.Product].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProductServiceClient productServiceClient = ProductServiceClient.create()) {
   *   UpdateProductRequest request =
   *       UpdateProductRequest.newBuilder()
   *           .setProduct(Product.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setAllowMissing(true)
   *           .build();
   *   Product response = productServiceClient.updateProduct(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Product updateProduct(UpdateProductRequest request) {
    return updateProductCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a [Product][google.cloud.retail.v2.Product].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProductServiceClient productServiceClient = ProductServiceClient.create()) {
   *   UpdateProductRequest request =
   *       UpdateProductRequest.newBuilder()
   *           .setProduct(Product.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setAllowMissing(true)
   *           .build();
   *   ApiFuture<Product> future = productServiceClient.updateProductCallable().futureCall(request);
   *   // Do something.
   *   Product response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateProductRequest, Product> updateProductCallable() {
    return stub.updateProductCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a [Product][google.cloud.retail.v2.Product].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProductServiceClient productServiceClient = ProductServiceClient.create()) {
   *   ProductName name =
   *       ProductName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[BRANCH]", "[PRODUCT]");
   *   productServiceClient.deleteProduct(name);
   * }
   * }</pre>
   *
   * @param name Required. Full resource name of [Product][google.cloud.retail.v2.Product], such as
   *     `projects/&#42;/locations/global/catalogs/default_catalog/branches/default_branch/products/some_product_id`.
   *     <p>If the caller does not have permission to delete the
   *     [Product][google.cloud.retail.v2.Product], regardless of whether or not it exists, a
   *     PERMISSION_DENIED error is returned.
   *     <p>If the [Product][google.cloud.retail.v2.Product] to delete does not exist, a NOT_FOUND
   *     error is returned.
   *     <p>The [Product][google.cloud.retail.v2.Product] to delete can neither be a
   *     [Product.Type.COLLECTION][google.cloud.retail.v2.Product.Type.COLLECTION]
   *     [Product][google.cloud.retail.v2.Product] member nor a
   *     [Product.Type.PRIMARY][google.cloud.retail.v2.Product.Type.PRIMARY]
   *     [Product][google.cloud.retail.v2.Product] with more than one
   *     [variants][google.cloud.retail.v2.Product.Type.VARIANT]. Otherwise, an INVALID_ARGUMENT
   *     error is returned.
   *     <p>All inventory information for the named [Product][google.cloud.retail.v2.Product] will
   *     be deleted.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteProduct(ProductName name) {
    DeleteProductRequest request =
        DeleteProductRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    deleteProduct(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a [Product][google.cloud.retail.v2.Product].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProductServiceClient productServiceClient = ProductServiceClient.create()) {
   *   String name =
   *       ProductName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[BRANCH]", "[PRODUCT]")
   *           .toString();
   *   productServiceClient.deleteProduct(name);
   * }
   * }</pre>
   *
   * @param name Required. Full resource name of [Product][google.cloud.retail.v2.Product], such as
   *     `projects/&#42;/locations/global/catalogs/default_catalog/branches/default_branch/products/some_product_id`.
   *     <p>If the caller does not have permission to delete the
   *     [Product][google.cloud.retail.v2.Product], regardless of whether or not it exists, a
   *     PERMISSION_DENIED error is returned.
   *     <p>If the [Product][google.cloud.retail.v2.Product] to delete does not exist, a NOT_FOUND
   *     error is returned.
   *     <p>The [Product][google.cloud.retail.v2.Product] to delete can neither be a
   *     [Product.Type.COLLECTION][google.cloud.retail.v2.Product.Type.COLLECTION]
   *     [Product][google.cloud.retail.v2.Product] member nor a
   *     [Product.Type.PRIMARY][google.cloud.retail.v2.Product.Type.PRIMARY]
   *     [Product][google.cloud.retail.v2.Product] with more than one
   *     [variants][google.cloud.retail.v2.Product.Type.VARIANT]. Otherwise, an INVALID_ARGUMENT
   *     error is returned.
   *     <p>All inventory information for the named [Product][google.cloud.retail.v2.Product] will
   *     be deleted.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteProduct(String name) {
    DeleteProductRequest request = DeleteProductRequest.newBuilder().setName(name).build();
    deleteProduct(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a [Product][google.cloud.retail.v2.Product].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProductServiceClient productServiceClient = ProductServiceClient.create()) {
   *   DeleteProductRequest request =
   *       DeleteProductRequest.newBuilder()
   *           .setName(
   *               ProductName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[BRANCH]", "[PRODUCT]")
   *                   .toString())
   *           .build();
   *   productServiceClient.deleteProduct(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteProduct(DeleteProductRequest request) {
    deleteProductCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a [Product][google.cloud.retail.v2.Product].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProductServiceClient productServiceClient = ProductServiceClient.create()) {
   *   DeleteProductRequest request =
   *       DeleteProductRequest.newBuilder()
   *           .setName(
   *               ProductName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[BRANCH]", "[PRODUCT]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Empty> future = productServiceClient.deleteProductCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteProductRequest, Empty> deleteProductCallable() {
    return stub.deleteProductCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Bulk import of multiple [Product][google.cloud.retail.v2.Product]s.
   *
   * <p>Request processing may be synchronous. Non-existing items are created.
   *
   * <p>Note that it is possible for a subset of the [Product][google.cloud.retail.v2.Product]s to
   * be successfully updated.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProductServiceClient productServiceClient = ProductServiceClient.create()) {
   *   ImportProductsRequest request =
   *       ImportProductsRequest.newBuilder()
   *           .setParent(
   *               BranchName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[BRANCH]").toString())
   *           .setRequestId("requestId693933066")
   *           .setInputConfig(ProductInputConfig.newBuilder().build())
   *           .setErrorsConfig(ImportErrorsConfig.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setNotificationPubsubTopic("notificationPubsubTopic-1361224991")
   *           .build();
   *   ImportProductsResponse response = productServiceClient.importProductsAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ImportProductsResponse, ImportMetadata> importProductsAsync(
      ImportProductsRequest request) {
    return importProductsOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Bulk import of multiple [Product][google.cloud.retail.v2.Product]s.
   *
   * <p>Request processing may be synchronous. Non-existing items are created.
   *
   * <p>Note that it is possible for a subset of the [Product][google.cloud.retail.v2.Product]s to
   * be successfully updated.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProductServiceClient productServiceClient = ProductServiceClient.create()) {
   *   ImportProductsRequest request =
   *       ImportProductsRequest.newBuilder()
   *           .setParent(
   *               BranchName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[BRANCH]").toString())
   *           .setRequestId("requestId693933066")
   *           .setInputConfig(ProductInputConfig.newBuilder().build())
   *           .setErrorsConfig(ImportErrorsConfig.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setNotificationPubsubTopic("notificationPubsubTopic-1361224991")
   *           .build();
   *   OperationFuture<ImportProductsResponse, ImportMetadata> future =
   *       productServiceClient.importProductsOperationCallable().futureCall(request);
   *   // Do something.
   *   ImportProductsResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<ImportProductsRequest, ImportProductsResponse, ImportMetadata>
      importProductsOperationCallable() {
    return stub.importProductsOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Bulk import of multiple [Product][google.cloud.retail.v2.Product]s.
   *
   * <p>Request processing may be synchronous. Non-existing items are created.
   *
   * <p>Note that it is possible for a subset of the [Product][google.cloud.retail.v2.Product]s to
   * be successfully updated.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProductServiceClient productServiceClient = ProductServiceClient.create()) {
   *   ImportProductsRequest request =
   *       ImportProductsRequest.newBuilder()
   *           .setParent(
   *               BranchName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[BRANCH]").toString())
   *           .setRequestId("requestId693933066")
   *           .setInputConfig(ProductInputConfig.newBuilder().build())
   *           .setErrorsConfig(ImportErrorsConfig.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setNotificationPubsubTopic("notificationPubsubTopic-1361224991")
   *           .build();
   *   ApiFuture<Operation> future =
   *       productServiceClient.importProductsCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ImportProductsRequest, Operation> importProductsCallable() {
    return stub.importProductsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates inventory information for a [Product][google.cloud.retail.v2.Product] while respecting
   * the last update timestamps of each inventory field.
   *
   * <p>This process is asynchronous and does not require the
   * [Product][google.cloud.retail.v2.Product] to exist before updating fulfillment information. If
   * the request is valid, the update is enqueued and processed downstream. As a consequence, when a
   * response is returned, updates are not immediately manifested in the
   * [Product][google.cloud.retail.v2.Product] queried by
   * [ProductService.GetProduct][google.cloud.retail.v2.ProductService.GetProduct] or
   * [ProductService.ListProducts][google.cloud.retail.v2.ProductService.ListProducts].
   *
   * <p>When inventory is updated with
   * [ProductService.CreateProduct][google.cloud.retail.v2.ProductService.CreateProduct] and
   * [ProductService.UpdateProduct][google.cloud.retail.v2.ProductService.UpdateProduct], the
   * specified inventory field value(s) overwrite any existing value(s) while ignoring the last
   * update time for this field. Furthermore, the last update times for the specified inventory
   * fields are overwritten by the times of the
   * [ProductService.CreateProduct][google.cloud.retail.v2.ProductService.CreateProduct] or
   * [ProductService.UpdateProduct][google.cloud.retail.v2.ProductService.UpdateProduct] request.
   *
   * <p>If no inventory fields are set in
   * [CreateProductRequest.product][google.cloud.retail.v2.CreateProductRequest.product], then any
   * pre-existing inventory information for this product is used.
   *
   * <p>If no inventory fields are set in
   * [SetInventoryRequest.set_mask][google.cloud.retail.v2.SetInventoryRequest.set_mask], then any
   * existing inventory information is preserved.
   *
   * <p>Pre-existing inventory information can only be updated with
   * [ProductService.SetInventory][google.cloud.retail.v2.ProductService.SetInventory],
   * [ProductService.AddFulfillmentPlaces][google.cloud.retail.v2.ProductService.AddFulfillmentPlaces],
   * and
   * [ProductService.RemoveFulfillmentPlaces][google.cloud.retail.v2.ProductService.RemoveFulfillmentPlaces].
   *
   * <p>The returned [Operation][google.longrunning.Operation]s is obsolete after one day, and the
   * [GetOperation][google.longrunning.Operations.GetOperation] API returns `NOT_FOUND` afterwards.
   *
   * <p>If conflicting updates are issued, the [Operation][google.longrunning.Operation]s associated
   * with the stale updates are not marked as [done][google.longrunning.Operation.done] until they
   * are obsolete.
   *
   * <p>This feature is only available for users who have Retail Search enabled. Enable Retail
   * Search on Cloud Console before using this feature.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProductServiceClient productServiceClient = ProductServiceClient.create()) {
   *   Product inventory = Product.newBuilder().build();
   *   FieldMask setMask = FieldMask.newBuilder().build();
   *   SetInventoryResponse response =
   *       productServiceClient.setInventoryAsync(inventory, setMask).get();
   * }
   * }</pre>
   *
   * @param inventory Required. The inventory information to update. The allowable fields to update
   *     are:
   *     <ul>
   *       <li>[Product.price_info][google.cloud.retail.v2.Product.price_info]
   *       <li>[Product.availability][google.cloud.retail.v2.Product.availability]
   *       <li>[Product.available_quantity][google.cloud.retail.v2.Product.available_quantity]
   *       <li>[Product.fulfillment_info][google.cloud.retail.v2.Product.fulfillment_info] The
   *           updated inventory fields must be specified in
   *           [SetInventoryRequest.set_mask][google.cloud.retail.v2.SetInventoryRequest.set_mask].
   *     </ul>
   *     <p>If [SetInventoryRequest.inventory.name][google.cloud.retail.v2.Product.name] is empty or
   *     invalid, an INVALID_ARGUMENT error is returned.
   *     <p>If the caller does not have permission to update the
   *     [Product][google.cloud.retail.v2.Product] named in
   *     [Product.name][google.cloud.retail.v2.Product.name], regardless of whether or not it
   *     exists, a PERMISSION_DENIED error is returned.
   *     <p>If the [Product][google.cloud.retail.v2.Product] to update does not have existing
   *     inventory information, the provided inventory information will be inserted.
   *     <p>If the [Product][google.cloud.retail.v2.Product] to update has existing inventory
   *     information, the provided inventory information will be merged while respecting the last
   *     update time for each inventory field, using the provided or default value for
   *     [SetInventoryRequest.set_time][google.cloud.retail.v2.SetInventoryRequest.set_time].
   *     <p>The caller can replace place IDs for a subset of fulfillment types in the following
   *     ways:
   *     <ul>
   *       <li>Adds "fulfillment_info" in
   *           [SetInventoryRequest.set_mask][google.cloud.retail.v2.SetInventoryRequest.set_mask]
   *       <li>Specifies only the desired fulfillment types and corresponding place IDs to update in
   *           [SetInventoryRequest.inventory.fulfillment_info][google.cloud.retail.v2.Product.fulfillment_info]
   *     </ul>
   *     <p>The caller can clear all place IDs from a subset of fulfillment types in the following
   *     ways:
   *     <ul>
   *       <li>Adds "fulfillment_info" in
   *           [SetInventoryRequest.set_mask][google.cloud.retail.v2.SetInventoryRequest.set_mask]
   *       <li>Specifies only the desired fulfillment types to clear in
   *           [SetInventoryRequest.inventory.fulfillment_info][google.cloud.retail.v2.Product.fulfillment_info]
   *       <li>Checks that only the desired fulfillment info types have empty
   *           [SetInventoryRequest.inventory.fulfillment_info.place_ids][google.cloud.retail.v2.FulfillmentInfo.place_ids]
   *     </ul>
   *     <p>The last update time is recorded for the following inventory fields:
   *     <ul>
   *       <li>[Product.price_info][google.cloud.retail.v2.Product.price_info]
   *       <li>[Product.availability][google.cloud.retail.v2.Product.availability]
   *       <li>[Product.available_quantity][google.cloud.retail.v2.Product.available_quantity]
   *       <li>[Product.fulfillment_info][google.cloud.retail.v2.Product.fulfillment_info]
   *     </ul>
   *     <p>If a full overwrite of inventory information while ignoring timestamps is needed,
   *     [ProductService.UpdateProduct][google.cloud.retail.v2.ProductService.UpdateProduct] should
   *     be invoked instead.
   * @param setMask Indicates which inventory fields in the provided
   *     [Product][google.cloud.retail.v2.Product] to update.
   *     <p>At least one field must be provided.
   *     <p>If an unsupported or unknown field is provided, an INVALID_ARGUMENT error is returned
   *     and the entire update will be ignored.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<SetInventoryResponse, SetInventoryMetadata> setInventoryAsync(
      Product inventory, FieldMask setMask) {
    SetInventoryRequest request =
        SetInventoryRequest.newBuilder().setInventory(inventory).setSetMask(setMask).build();
    return setInventoryAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates inventory information for a [Product][google.cloud.retail.v2.Product] while respecting
   * the last update timestamps of each inventory field.
   *
   * <p>This process is asynchronous and does not require the
   * [Product][google.cloud.retail.v2.Product] to exist before updating fulfillment information. If
   * the request is valid, the update is enqueued and processed downstream. As a consequence, when a
   * response is returned, updates are not immediately manifested in the
   * [Product][google.cloud.retail.v2.Product] queried by
   * [ProductService.GetProduct][google.cloud.retail.v2.ProductService.GetProduct] or
   * [ProductService.ListProducts][google.cloud.retail.v2.ProductService.ListProducts].
   *
   * <p>When inventory is updated with
   * [ProductService.CreateProduct][google.cloud.retail.v2.ProductService.CreateProduct] and
   * [ProductService.UpdateProduct][google.cloud.retail.v2.ProductService.UpdateProduct], the
   * specified inventory field value(s) overwrite any existing value(s) while ignoring the last
   * update time for this field. Furthermore, the last update times for the specified inventory
   * fields are overwritten by the times of the
   * [ProductService.CreateProduct][google.cloud.retail.v2.ProductService.CreateProduct] or
   * [ProductService.UpdateProduct][google.cloud.retail.v2.ProductService.UpdateProduct] request.
   *
   * <p>If no inventory fields are set in
   * [CreateProductRequest.product][google.cloud.retail.v2.CreateProductRequest.product], then any
   * pre-existing inventory information for this product is used.
   *
   * <p>If no inventory fields are set in
   * [SetInventoryRequest.set_mask][google.cloud.retail.v2.SetInventoryRequest.set_mask], then any
   * existing inventory information is preserved.
   *
   * <p>Pre-existing inventory information can only be updated with
   * [ProductService.SetInventory][google.cloud.retail.v2.ProductService.SetInventory],
   * [ProductService.AddFulfillmentPlaces][google.cloud.retail.v2.ProductService.AddFulfillmentPlaces],
   * and
   * [ProductService.RemoveFulfillmentPlaces][google.cloud.retail.v2.ProductService.RemoveFulfillmentPlaces].
   *
   * <p>The returned [Operation][google.longrunning.Operation]s is obsolete after one day, and the
   * [GetOperation][google.longrunning.Operations.GetOperation] API returns `NOT_FOUND` afterwards.
   *
   * <p>If conflicting updates are issued, the [Operation][google.longrunning.Operation]s associated
   * with the stale updates are not marked as [done][google.longrunning.Operation.done] until they
   * are obsolete.
   *
   * <p>This feature is only available for users who have Retail Search enabled. Enable Retail
   * Search on Cloud Console before using this feature.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProductServiceClient productServiceClient = ProductServiceClient.create()) {
   *   SetInventoryRequest request =
   *       SetInventoryRequest.newBuilder()
   *           .setInventory(Product.newBuilder().build())
   *           .setSetMask(FieldMask.newBuilder().build())
   *           .setSetTime(Timestamp.newBuilder().build())
   *           .setAllowMissing(true)
   *           .build();
   *   SetInventoryResponse response = productServiceClient.setInventoryAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<SetInventoryResponse, SetInventoryMetadata> setInventoryAsync(
      SetInventoryRequest request) {
    return setInventoryOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates inventory information for a [Product][google.cloud.retail.v2.Product] while respecting
   * the last update timestamps of each inventory field.
   *
   * <p>This process is asynchronous and does not require the
   * [Product][google.cloud.retail.v2.Product] to exist before updating fulfillment information. If
   * the request is valid, the update is enqueued and processed downstream. As a consequence, when a
   * response is returned, updates are not immediately manifested in the
   * [Product][google.cloud.retail.v2.Product] queried by
   * [ProductService.GetProduct][google.cloud.retail.v2.ProductService.GetProduct] or
   * [ProductService.ListProducts][google.cloud.retail.v2.ProductService.ListProducts].
   *
   * <p>When inventory is updated with
   * [ProductService.CreateProduct][google.cloud.retail.v2.ProductService.CreateProduct] and
   * [ProductService.UpdateProduct][google.cloud.retail.v2.ProductService.UpdateProduct], the
   * specified inventory field value(s) overwrite any existing value(s) while ignoring the last
   * update time for this field. Furthermore, the last update times for the specified inventory
   * fields are overwritten by the times of the
   * [ProductService.CreateProduct][google.cloud.retail.v2.ProductService.CreateProduct] or
   * [ProductService.UpdateProduct][google.cloud.retail.v2.ProductService.UpdateProduct] request.
   *
   * <p>If no inventory fields are set in
   * [CreateProductRequest.product][google.cloud.retail.v2.CreateProductRequest.product], then any
   * pre-existing inventory information for this product is used.
   *
   * <p>If no inventory fields are set in
   * [SetInventoryRequest.set_mask][google.cloud.retail.v2.SetInventoryRequest.set_mask], then any
   * existing inventory information is preserved.
   *
   * <p>Pre-existing inventory information can only be updated with
   * [ProductService.SetInventory][google.cloud.retail.v2.ProductService.SetInventory],
   * [ProductService.AddFulfillmentPlaces][google.cloud.retail.v2.ProductService.AddFulfillmentPlaces],
   * and
   * [ProductService.RemoveFulfillmentPlaces][google.cloud.retail.v2.ProductService.RemoveFulfillmentPlaces].
   *
   * <p>The returned [Operation][google.longrunning.Operation]s is obsolete after one day, and the
   * [GetOperation][google.longrunning.Operations.GetOperation] API returns `NOT_FOUND` afterwards.
   *
   * <p>If conflicting updates are issued, the [Operation][google.longrunning.Operation]s associated
   * with the stale updates are not marked as [done][google.longrunning.Operation.done] until they
   * are obsolete.
   *
   * <p>This feature is only available for users who have Retail Search enabled. Enable Retail
   * Search on Cloud Console before using this feature.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProductServiceClient productServiceClient = ProductServiceClient.create()) {
   *   SetInventoryRequest request =
   *       SetInventoryRequest.newBuilder()
   *           .setInventory(Product.newBuilder().build())
   *           .setSetMask(FieldMask.newBuilder().build())
   *           .setSetTime(Timestamp.newBuilder().build())
   *           .setAllowMissing(true)
   *           .build();
   *   OperationFuture<SetInventoryResponse, SetInventoryMetadata> future =
   *       productServiceClient.setInventoryOperationCallable().futureCall(request);
   *   // Do something.
   *   SetInventoryResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<SetInventoryRequest, SetInventoryResponse, SetInventoryMetadata>
      setInventoryOperationCallable() {
    return stub.setInventoryOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates inventory information for a [Product][google.cloud.retail.v2.Product] while respecting
   * the last update timestamps of each inventory field.
   *
   * <p>This process is asynchronous and does not require the
   * [Product][google.cloud.retail.v2.Product] to exist before updating fulfillment information. If
   * the request is valid, the update is enqueued and processed downstream. As a consequence, when a
   * response is returned, updates are not immediately manifested in the
   * [Product][google.cloud.retail.v2.Product] queried by
   * [ProductService.GetProduct][google.cloud.retail.v2.ProductService.GetProduct] or
   * [ProductService.ListProducts][google.cloud.retail.v2.ProductService.ListProducts].
   *
   * <p>When inventory is updated with
   * [ProductService.CreateProduct][google.cloud.retail.v2.ProductService.CreateProduct] and
   * [ProductService.UpdateProduct][google.cloud.retail.v2.ProductService.UpdateProduct], the
   * specified inventory field value(s) overwrite any existing value(s) while ignoring the last
   * update time for this field. Furthermore, the last update times for the specified inventory
   * fields are overwritten by the times of the
   * [ProductService.CreateProduct][google.cloud.retail.v2.ProductService.CreateProduct] or
   * [ProductService.UpdateProduct][google.cloud.retail.v2.ProductService.UpdateProduct] request.
   *
   * <p>If no inventory fields are set in
   * [CreateProductRequest.product][google.cloud.retail.v2.CreateProductRequest.product], then any
   * pre-existing inventory information for this product is used.
   *
   * <p>If no inventory fields are set in
   * [SetInventoryRequest.set_mask][google.cloud.retail.v2.SetInventoryRequest.set_mask], then any
   * existing inventory information is preserved.
   *
   * <p>Pre-existing inventory information can only be updated with
   * [ProductService.SetInventory][google.cloud.retail.v2.ProductService.SetInventory],
   * [ProductService.AddFulfillmentPlaces][google.cloud.retail.v2.ProductService.AddFulfillmentPlaces],
   * and
   * [ProductService.RemoveFulfillmentPlaces][google.cloud.retail.v2.ProductService.RemoveFulfillmentPlaces].
   *
   * <p>The returned [Operation][google.longrunning.Operation]s is obsolete after one day, and the
   * [GetOperation][google.longrunning.Operations.GetOperation] API returns `NOT_FOUND` afterwards.
   *
   * <p>If conflicting updates are issued, the [Operation][google.longrunning.Operation]s associated
   * with the stale updates are not marked as [done][google.longrunning.Operation.done] until they
   * are obsolete.
   *
   * <p>This feature is only available for users who have Retail Search enabled. Enable Retail
   * Search on Cloud Console before using this feature.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProductServiceClient productServiceClient = ProductServiceClient.create()) {
   *   SetInventoryRequest request =
   *       SetInventoryRequest.newBuilder()
   *           .setInventory(Product.newBuilder().build())
   *           .setSetMask(FieldMask.newBuilder().build())
   *           .setSetTime(Timestamp.newBuilder().build())
   *           .setAllowMissing(true)
   *           .build();
   *   ApiFuture<Operation> future = productServiceClient.setInventoryCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SetInventoryRequest, Operation> setInventoryCallable() {
    return stub.setInventoryCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Incrementally adds place IDs to
   * [Product.fulfillment_info.place_ids][google.cloud.retail.v2.FulfillmentInfo.place_ids].
   *
   * <p>This process is asynchronous and does not require the
   * [Product][google.cloud.retail.v2.Product] to exist before updating fulfillment information. If
   * the request is valid, the update will be enqueued and processed downstream. As a consequence,
   * when a response is returned, the added place IDs are not immediately manifested in the
   * [Product][google.cloud.retail.v2.Product] queried by
   * [ProductService.GetProduct][google.cloud.retail.v2.ProductService.GetProduct] or
   * [ProductService.ListProducts][google.cloud.retail.v2.ProductService.ListProducts].
   *
   * <p>The returned [Operation][google.longrunning.Operation]s will be obsolete after 1 day, and
   * [GetOperation][google.longrunning.Operations.GetOperation] API will return NOT_FOUND
   * afterwards.
   *
   * <p>If conflicting updates are issued, the [Operation][google.longrunning.Operation]s associated
   * with the stale updates will not be marked as [done][google.longrunning.Operation.done] until
   * being obsolete.
   *
   * <p>This feature is only available for users who have Retail Search enabled. Enable Retail
   * Search on Cloud Console before using this feature.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProductServiceClient productServiceClient = ProductServiceClient.create()) {
   *   ProductName product =
   *       ProductName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[BRANCH]", "[PRODUCT]");
   *   AddFulfillmentPlacesResponse response =
   *       productServiceClient.addFulfillmentPlacesAsync(product).get();
   * }
   * }</pre>
   *
   * @param product Required. Full resource name of [Product][google.cloud.retail.v2.Product], such
   *     as
   *     `projects/&#42;/locations/global/catalogs/default_catalog/branches/default_branch/products/some_product_id`.
   *     <p>If the caller does not have permission to access the
   *     [Product][google.cloud.retail.v2.Product], regardless of whether or not it exists, a
   *     PERMISSION_DENIED error is returned.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<AddFulfillmentPlacesResponse, AddFulfillmentPlacesMetadata>
      addFulfillmentPlacesAsync(ProductName product) {
    AddFulfillmentPlacesRequest request =
        AddFulfillmentPlacesRequest.newBuilder()
            .setProduct(product == null ? null : product.toString())
            .build();
    return addFulfillmentPlacesAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Incrementally adds place IDs to
   * [Product.fulfillment_info.place_ids][google.cloud.retail.v2.FulfillmentInfo.place_ids].
   *
   * <p>This process is asynchronous and does not require the
   * [Product][google.cloud.retail.v2.Product] to exist before updating fulfillment information. If
   * the request is valid, the update will be enqueued and processed downstream. As a consequence,
   * when a response is returned, the added place IDs are not immediately manifested in the
   * [Product][google.cloud.retail.v2.Product] queried by
   * [ProductService.GetProduct][google.cloud.retail.v2.ProductService.GetProduct] or
   * [ProductService.ListProducts][google.cloud.retail.v2.ProductService.ListProducts].
   *
   * <p>The returned [Operation][google.longrunning.Operation]s will be obsolete after 1 day, and
   * [GetOperation][google.longrunning.Operations.GetOperation] API will return NOT_FOUND
   * afterwards.
   *
   * <p>If conflicting updates are issued, the [Operation][google.longrunning.Operation]s associated
   * with the stale updates will not be marked as [done][google.longrunning.Operation.done] until
   * being obsolete.
   *
   * <p>This feature is only available for users who have Retail Search enabled. Enable Retail
   * Search on Cloud Console before using this feature.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProductServiceClient productServiceClient = ProductServiceClient.create()) {
   *   String product =
   *       ProductName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[BRANCH]", "[PRODUCT]")
   *           .toString();
   *   AddFulfillmentPlacesResponse response =
   *       productServiceClient.addFulfillmentPlacesAsync(product).get();
   * }
   * }</pre>
   *
   * @param product Required. Full resource name of [Product][google.cloud.retail.v2.Product], such
   *     as
   *     `projects/&#42;/locations/global/catalogs/default_catalog/branches/default_branch/products/some_product_id`.
   *     <p>If the caller does not have permission to access the
   *     [Product][google.cloud.retail.v2.Product], regardless of whether or not it exists, a
   *     PERMISSION_DENIED error is returned.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<AddFulfillmentPlacesResponse, AddFulfillmentPlacesMetadata>
      addFulfillmentPlacesAsync(String product) {
    AddFulfillmentPlacesRequest request =
        AddFulfillmentPlacesRequest.newBuilder().setProduct(product).build();
    return addFulfillmentPlacesAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Incrementally adds place IDs to
   * [Product.fulfillment_info.place_ids][google.cloud.retail.v2.FulfillmentInfo.place_ids].
   *
   * <p>This process is asynchronous and does not require the
   * [Product][google.cloud.retail.v2.Product] to exist before updating fulfillment information. If
   * the request is valid, the update will be enqueued and processed downstream. As a consequence,
   * when a response is returned, the added place IDs are not immediately manifested in the
   * [Product][google.cloud.retail.v2.Product] queried by
   * [ProductService.GetProduct][google.cloud.retail.v2.ProductService.GetProduct] or
   * [ProductService.ListProducts][google.cloud.retail.v2.ProductService.ListProducts].
   *
   * <p>The returned [Operation][google.longrunning.Operation]s will be obsolete after 1 day, and
   * [GetOperation][google.longrunning.Operations.GetOperation] API will return NOT_FOUND
   * afterwards.
   *
   * <p>If conflicting updates are issued, the [Operation][google.longrunning.Operation]s associated
   * with the stale updates will not be marked as [done][google.longrunning.Operation.done] until
   * being obsolete.
   *
   * <p>This feature is only available for users who have Retail Search enabled. Enable Retail
   * Search on Cloud Console before using this feature.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProductServiceClient productServiceClient = ProductServiceClient.create()) {
   *   AddFulfillmentPlacesRequest request =
   *       AddFulfillmentPlacesRequest.newBuilder()
   *           .setProduct(
   *               ProductName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[BRANCH]", "[PRODUCT]")
   *                   .toString())
   *           .setType("type3575610")
   *           .addAllPlaceIds(new ArrayList<String>())
   *           .setAddTime(Timestamp.newBuilder().build())
   *           .setAllowMissing(true)
   *           .build();
   *   AddFulfillmentPlacesResponse response =
   *       productServiceClient.addFulfillmentPlacesAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<AddFulfillmentPlacesResponse, AddFulfillmentPlacesMetadata>
      addFulfillmentPlacesAsync(AddFulfillmentPlacesRequest request) {
    return addFulfillmentPlacesOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Incrementally adds place IDs to
   * [Product.fulfillment_info.place_ids][google.cloud.retail.v2.FulfillmentInfo.place_ids].
   *
   * <p>This process is asynchronous and does not require the
   * [Product][google.cloud.retail.v2.Product] to exist before updating fulfillment information. If
   * the request is valid, the update will be enqueued and processed downstream. As a consequence,
   * when a response is returned, the added place IDs are not immediately manifested in the
   * [Product][google.cloud.retail.v2.Product] queried by
   * [ProductService.GetProduct][google.cloud.retail.v2.ProductService.GetProduct] or
   * [ProductService.ListProducts][google.cloud.retail.v2.ProductService.ListProducts].
   *
   * <p>The returned [Operation][google.longrunning.Operation]s will be obsolete after 1 day, and
   * [GetOperation][google.longrunning.Operations.GetOperation] API will return NOT_FOUND
   * afterwards.
   *
   * <p>If conflicting updates are issued, the [Operation][google.longrunning.Operation]s associated
   * with the stale updates will not be marked as [done][google.longrunning.Operation.done] until
   * being obsolete.
   *
   * <p>This feature is only available for users who have Retail Search enabled. Enable Retail
   * Search on Cloud Console before using this feature.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProductServiceClient productServiceClient = ProductServiceClient.create()) {
   *   AddFulfillmentPlacesRequest request =
   *       AddFulfillmentPlacesRequest.newBuilder()
   *           .setProduct(
   *               ProductName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[BRANCH]", "[PRODUCT]")
   *                   .toString())
   *           .setType("type3575610")
   *           .addAllPlaceIds(new ArrayList<String>())
   *           .setAddTime(Timestamp.newBuilder().build())
   *           .setAllowMissing(true)
   *           .build();
   *   OperationFuture<AddFulfillmentPlacesResponse, AddFulfillmentPlacesMetadata> future =
   *       productServiceClient.addFulfillmentPlacesOperationCallable().futureCall(request);
   *   // Do something.
   *   AddFulfillmentPlacesResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          AddFulfillmentPlacesRequest, AddFulfillmentPlacesResponse, AddFulfillmentPlacesMetadata>
      addFulfillmentPlacesOperationCallable() {
    return stub.addFulfillmentPlacesOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Incrementally adds place IDs to
   * [Product.fulfillment_info.place_ids][google.cloud.retail.v2.FulfillmentInfo.place_ids].
   *
   * <p>This process is asynchronous and does not require the
   * [Product][google.cloud.retail.v2.Product] to exist before updating fulfillment information. If
   * the request is valid, the update will be enqueued and processed downstream. As a consequence,
   * when a response is returned, the added place IDs are not immediately manifested in the
   * [Product][google.cloud.retail.v2.Product] queried by
   * [ProductService.GetProduct][google.cloud.retail.v2.ProductService.GetProduct] or
   * [ProductService.ListProducts][google.cloud.retail.v2.ProductService.ListProducts].
   *
   * <p>The returned [Operation][google.longrunning.Operation]s will be obsolete after 1 day, and
   * [GetOperation][google.longrunning.Operations.GetOperation] API will return NOT_FOUND
   * afterwards.
   *
   * <p>If conflicting updates are issued, the [Operation][google.longrunning.Operation]s associated
   * with the stale updates will not be marked as [done][google.longrunning.Operation.done] until
   * being obsolete.
   *
   * <p>This feature is only available for users who have Retail Search enabled. Enable Retail
   * Search on Cloud Console before using this feature.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProductServiceClient productServiceClient = ProductServiceClient.create()) {
   *   AddFulfillmentPlacesRequest request =
   *       AddFulfillmentPlacesRequest.newBuilder()
   *           .setProduct(
   *               ProductName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[BRANCH]", "[PRODUCT]")
   *                   .toString())
   *           .setType("type3575610")
   *           .addAllPlaceIds(new ArrayList<String>())
   *           .setAddTime(Timestamp.newBuilder().build())
   *           .setAllowMissing(true)
   *           .build();
   *   ApiFuture<Operation> future =
   *       productServiceClient.addFulfillmentPlacesCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<AddFulfillmentPlacesRequest, Operation>
      addFulfillmentPlacesCallable() {
    return stub.addFulfillmentPlacesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Incrementally removes place IDs from a
   * [Product.fulfillment_info.place_ids][google.cloud.retail.v2.FulfillmentInfo.place_ids].
   *
   * <p>This process is asynchronous and does not require the
   * [Product][google.cloud.retail.v2.Product] to exist before updating fulfillment information. If
   * the request is valid, the update will be enqueued and processed downstream. As a consequence,
   * when a response is returned, the removed place IDs are not immediately manifested in the
   * [Product][google.cloud.retail.v2.Product] queried by
   * [ProductService.GetProduct][google.cloud.retail.v2.ProductService.GetProduct] or
   * [ProductService.ListProducts][google.cloud.retail.v2.ProductService.ListProducts].
   *
   * <p>The returned [Operation][google.longrunning.Operation]s will be obsolete after 1 day, and
   * [GetOperation][google.longrunning.Operations.GetOperation] API will return NOT_FOUND
   * afterwards.
   *
   * <p>If conflicting updates are issued, the [Operation][google.longrunning.Operation]s associated
   * with the stale updates will not be marked as [done][google.longrunning.Operation.done] until
   * being obsolete.
   *
   * <p>This feature is only available for users who have Retail Search enabled. Enable Retail
   * Search on Cloud Console before using this feature.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProductServiceClient productServiceClient = ProductServiceClient.create()) {
   *   ProductName product =
   *       ProductName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[BRANCH]", "[PRODUCT]");
   *   RemoveFulfillmentPlacesResponse response =
   *       productServiceClient.removeFulfillmentPlacesAsync(product).get();
   * }
   * }</pre>
   *
   * @param product Required. Full resource name of [Product][google.cloud.retail.v2.Product], such
   *     as
   *     `projects/&#42;/locations/global/catalogs/default_catalog/branches/default_branch/products/some_product_id`.
   *     <p>If the caller does not have permission to access the
   *     [Product][google.cloud.retail.v2.Product], regardless of whether or not it exists, a
   *     PERMISSION_DENIED error is returned.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<RemoveFulfillmentPlacesResponse, RemoveFulfillmentPlacesMetadata>
      removeFulfillmentPlacesAsync(ProductName product) {
    RemoveFulfillmentPlacesRequest request =
        RemoveFulfillmentPlacesRequest.newBuilder()
            .setProduct(product == null ? null : product.toString())
            .build();
    return removeFulfillmentPlacesAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Incrementally removes place IDs from a
   * [Product.fulfillment_info.place_ids][google.cloud.retail.v2.FulfillmentInfo.place_ids].
   *
   * <p>This process is asynchronous and does not require the
   * [Product][google.cloud.retail.v2.Product] to exist before updating fulfillment information. If
   * the request is valid, the update will be enqueued and processed downstream. As a consequence,
   * when a response is returned, the removed place IDs are not immediately manifested in the
   * [Product][google.cloud.retail.v2.Product] queried by
   * [ProductService.GetProduct][google.cloud.retail.v2.ProductService.GetProduct] or
   * [ProductService.ListProducts][google.cloud.retail.v2.ProductService.ListProducts].
   *
   * <p>The returned [Operation][google.longrunning.Operation]s will be obsolete after 1 day, and
   * [GetOperation][google.longrunning.Operations.GetOperation] API will return NOT_FOUND
   * afterwards.
   *
   * <p>If conflicting updates are issued, the [Operation][google.longrunning.Operation]s associated
   * with the stale updates will not be marked as [done][google.longrunning.Operation.done] until
   * being obsolete.
   *
   * <p>This feature is only available for users who have Retail Search enabled. Enable Retail
   * Search on Cloud Console before using this feature.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProductServiceClient productServiceClient = ProductServiceClient.create()) {
   *   String product =
   *       ProductName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[BRANCH]", "[PRODUCT]")
   *           .toString();
   *   RemoveFulfillmentPlacesResponse response =
   *       productServiceClient.removeFulfillmentPlacesAsync(product).get();
   * }
   * }</pre>
   *
   * @param product Required. Full resource name of [Product][google.cloud.retail.v2.Product], such
   *     as
   *     `projects/&#42;/locations/global/catalogs/default_catalog/branches/default_branch/products/some_product_id`.
   *     <p>If the caller does not have permission to access the
   *     [Product][google.cloud.retail.v2.Product], regardless of whether or not it exists, a
   *     PERMISSION_DENIED error is returned.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<RemoveFulfillmentPlacesResponse, RemoveFulfillmentPlacesMetadata>
      removeFulfillmentPlacesAsync(String product) {
    RemoveFulfillmentPlacesRequest request =
        RemoveFulfillmentPlacesRequest.newBuilder().setProduct(product).build();
    return removeFulfillmentPlacesAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Incrementally removes place IDs from a
   * [Product.fulfillment_info.place_ids][google.cloud.retail.v2.FulfillmentInfo.place_ids].
   *
   * <p>This process is asynchronous and does not require the
   * [Product][google.cloud.retail.v2.Product] to exist before updating fulfillment information. If
   * the request is valid, the update will be enqueued and processed downstream. As a consequence,
   * when a response is returned, the removed place IDs are not immediately manifested in the
   * [Product][google.cloud.retail.v2.Product] queried by
   * [ProductService.GetProduct][google.cloud.retail.v2.ProductService.GetProduct] or
   * [ProductService.ListProducts][google.cloud.retail.v2.ProductService.ListProducts].
   *
   * <p>The returned [Operation][google.longrunning.Operation]s will be obsolete after 1 day, and
   * [GetOperation][google.longrunning.Operations.GetOperation] API will return NOT_FOUND
   * afterwards.
   *
   * <p>If conflicting updates are issued, the [Operation][google.longrunning.Operation]s associated
   * with the stale updates will not be marked as [done][google.longrunning.Operation.done] until
   * being obsolete.
   *
   * <p>This feature is only available for users who have Retail Search enabled. Enable Retail
   * Search on Cloud Console before using this feature.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProductServiceClient productServiceClient = ProductServiceClient.create()) {
   *   RemoveFulfillmentPlacesRequest request =
   *       RemoveFulfillmentPlacesRequest.newBuilder()
   *           .setProduct(
   *               ProductName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[BRANCH]", "[PRODUCT]")
   *                   .toString())
   *           .setType("type3575610")
   *           .addAllPlaceIds(new ArrayList<String>())
   *           .setRemoveTime(Timestamp.newBuilder().build())
   *           .setAllowMissing(true)
   *           .build();
   *   RemoveFulfillmentPlacesResponse response =
   *       productServiceClient.removeFulfillmentPlacesAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<RemoveFulfillmentPlacesResponse, RemoveFulfillmentPlacesMetadata>
      removeFulfillmentPlacesAsync(RemoveFulfillmentPlacesRequest request) {
    return removeFulfillmentPlacesOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Incrementally removes place IDs from a
   * [Product.fulfillment_info.place_ids][google.cloud.retail.v2.FulfillmentInfo.place_ids].
   *
   * <p>This process is asynchronous and does not require the
   * [Product][google.cloud.retail.v2.Product] to exist before updating fulfillment information. If
   * the request is valid, the update will be enqueued and processed downstream. As a consequence,
   * when a response is returned, the removed place IDs are not immediately manifested in the
   * [Product][google.cloud.retail.v2.Product] queried by
   * [ProductService.GetProduct][google.cloud.retail.v2.ProductService.GetProduct] or
   * [ProductService.ListProducts][google.cloud.retail.v2.ProductService.ListProducts].
   *
   * <p>The returned [Operation][google.longrunning.Operation]s will be obsolete after 1 day, and
   * [GetOperation][google.longrunning.Operations.GetOperation] API will return NOT_FOUND
   * afterwards.
   *
   * <p>If conflicting updates are issued, the [Operation][google.longrunning.Operation]s associated
   * with the stale updates will not be marked as [done][google.longrunning.Operation.done] until
   * being obsolete.
   *
   * <p>This feature is only available for users who have Retail Search enabled. Enable Retail
   * Search on Cloud Console before using this feature.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProductServiceClient productServiceClient = ProductServiceClient.create()) {
   *   RemoveFulfillmentPlacesRequest request =
   *       RemoveFulfillmentPlacesRequest.newBuilder()
   *           .setProduct(
   *               ProductName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[BRANCH]", "[PRODUCT]")
   *                   .toString())
   *           .setType("type3575610")
   *           .addAllPlaceIds(new ArrayList<String>())
   *           .setRemoveTime(Timestamp.newBuilder().build())
   *           .setAllowMissing(true)
   *           .build();
   *   OperationFuture<RemoveFulfillmentPlacesResponse, RemoveFulfillmentPlacesMetadata> future =
   *       productServiceClient.removeFulfillmentPlacesOperationCallable().futureCall(request);
   *   // Do something.
   *   RemoveFulfillmentPlacesResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          RemoveFulfillmentPlacesRequest,
          RemoveFulfillmentPlacesResponse,
          RemoveFulfillmentPlacesMetadata>
      removeFulfillmentPlacesOperationCallable() {
    return stub.removeFulfillmentPlacesOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Incrementally removes place IDs from a
   * [Product.fulfillment_info.place_ids][google.cloud.retail.v2.FulfillmentInfo.place_ids].
   *
   * <p>This process is asynchronous and does not require the
   * [Product][google.cloud.retail.v2.Product] to exist before updating fulfillment information. If
   * the request is valid, the update will be enqueued and processed downstream. As a consequence,
   * when a response is returned, the removed place IDs are not immediately manifested in the
   * [Product][google.cloud.retail.v2.Product] queried by
   * [ProductService.GetProduct][google.cloud.retail.v2.ProductService.GetProduct] or
   * [ProductService.ListProducts][google.cloud.retail.v2.ProductService.ListProducts].
   *
   * <p>The returned [Operation][google.longrunning.Operation]s will be obsolete after 1 day, and
   * [GetOperation][google.longrunning.Operations.GetOperation] API will return NOT_FOUND
   * afterwards.
   *
   * <p>If conflicting updates are issued, the [Operation][google.longrunning.Operation]s associated
   * with the stale updates will not be marked as [done][google.longrunning.Operation.done] until
   * being obsolete.
   *
   * <p>This feature is only available for users who have Retail Search enabled. Enable Retail
   * Search on Cloud Console before using this feature.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProductServiceClient productServiceClient = ProductServiceClient.create()) {
   *   RemoveFulfillmentPlacesRequest request =
   *       RemoveFulfillmentPlacesRequest.newBuilder()
   *           .setProduct(
   *               ProductName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[BRANCH]", "[PRODUCT]")
   *                   .toString())
   *           .setType("type3575610")
   *           .addAllPlaceIds(new ArrayList<String>())
   *           .setRemoveTime(Timestamp.newBuilder().build())
   *           .setAllowMissing(true)
   *           .build();
   *   ApiFuture<Operation> future =
   *       productServiceClient.removeFulfillmentPlacesCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<RemoveFulfillmentPlacesRequest, Operation>
      removeFulfillmentPlacesCallable() {
    return stub.removeFulfillmentPlacesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates local inventory information for a [Product][google.cloud.retail.v2.Product] at a list
   * of places, while respecting the last update timestamps of each inventory field.
   *
   * <p>This process is asynchronous and does not require the
   * [Product][google.cloud.retail.v2.Product] to exist before updating inventory information. If
   * the request is valid, the update will be enqueued and processed downstream. As a consequence,
   * when a response is returned, updates are not immediately manifested in the
   * [Product][google.cloud.retail.v2.Product] queried by
   * [ProductService.GetProduct][google.cloud.retail.v2.ProductService.GetProduct] or
   * [ProductService.ListProducts][google.cloud.retail.v2.ProductService.ListProducts].
   *
   * <p>Local inventory information can only be modified using this method.
   * [ProductService.CreateProduct][google.cloud.retail.v2.ProductService.CreateProduct] and
   * [ProductService.UpdateProduct][google.cloud.retail.v2.ProductService.UpdateProduct] has no
   * effect on local inventories.
   *
   * <p>The returned [Operation][google.longrunning.Operation]s will be obsolete after 1 day, and
   * [GetOperation][google.longrunning.Operations.GetOperation] API will return NOT_FOUND
   * afterwards.
   *
   * <p>If conflicting updates are issued, the [Operation][google.longrunning.Operation]s associated
   * with the stale updates will not be marked as [done][google.longrunning.Operation.done] until
   * being obsolete.
   *
   * <p>This feature is only available for users who have Retail Search enabled. Enable Retail
   * Search on Cloud Console before using this feature.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProductServiceClient productServiceClient = ProductServiceClient.create()) {
   *   ProductName product =
   *       ProductName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[BRANCH]", "[PRODUCT]");
   *   AddLocalInventoriesResponse response =
   *       productServiceClient.addLocalInventoriesAsync(product).get();
   * }
   * }</pre>
   *
   * @param product Required. Full resource name of [Product][google.cloud.retail.v2.Product], such
   *     as
   *     `projects/&#42;/locations/global/catalogs/default_catalog/branches/default_branch/products/some_product_id`.
   *     <p>If the caller does not have permission to access the
   *     [Product][google.cloud.retail.v2.Product], regardless of whether or not it exists, a
   *     PERMISSION_DENIED error is returned.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<AddLocalInventoriesResponse, AddLocalInventoriesMetadata>
      addLocalInventoriesAsync(ProductName product) {
    AddLocalInventoriesRequest request =
        AddLocalInventoriesRequest.newBuilder()
            .setProduct(product == null ? null : product.toString())
            .build();
    return addLocalInventoriesAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates local inventory information for a [Product][google.cloud.retail.v2.Product] at a list
   * of places, while respecting the last update timestamps of each inventory field.
   *
   * <p>This process is asynchronous and does not require the
   * [Product][google.cloud.retail.v2.Product] to exist before updating inventory information. If
   * the request is valid, the update will be enqueued and processed downstream. As a consequence,
   * when a response is returned, updates are not immediately manifested in the
   * [Product][google.cloud.retail.v2.Product] queried by
   * [ProductService.GetProduct][google.cloud.retail.v2.ProductService.GetProduct] or
   * [ProductService.ListProducts][google.cloud.retail.v2.ProductService.ListProducts].
   *
   * <p>Local inventory information can only be modified using this method.
   * [ProductService.CreateProduct][google.cloud.retail.v2.ProductService.CreateProduct] and
   * [ProductService.UpdateProduct][google.cloud.retail.v2.ProductService.UpdateProduct] has no
   * effect on local inventories.
   *
   * <p>The returned [Operation][google.longrunning.Operation]s will be obsolete after 1 day, and
   * [GetOperation][google.longrunning.Operations.GetOperation] API will return NOT_FOUND
   * afterwards.
   *
   * <p>If conflicting updates are issued, the [Operation][google.longrunning.Operation]s associated
   * with the stale updates will not be marked as [done][google.longrunning.Operation.done] until
   * being obsolete.
   *
   * <p>This feature is only available for users who have Retail Search enabled. Enable Retail
   * Search on Cloud Console before using this feature.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProductServiceClient productServiceClient = ProductServiceClient.create()) {
   *   String product =
   *       ProductName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[BRANCH]", "[PRODUCT]")
   *           .toString();
   *   AddLocalInventoriesResponse response =
   *       productServiceClient.addLocalInventoriesAsync(product).get();
   * }
   * }</pre>
   *
   * @param product Required. Full resource name of [Product][google.cloud.retail.v2.Product], such
   *     as
   *     `projects/&#42;/locations/global/catalogs/default_catalog/branches/default_branch/products/some_product_id`.
   *     <p>If the caller does not have permission to access the
   *     [Product][google.cloud.retail.v2.Product], regardless of whether or not it exists, a
   *     PERMISSION_DENIED error is returned.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<AddLocalInventoriesResponse, AddLocalInventoriesMetadata>
      addLocalInventoriesAsync(String product) {
    AddLocalInventoriesRequest request =
        AddLocalInventoriesRequest.newBuilder().setProduct(product).build();
    return addLocalInventoriesAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates local inventory information for a [Product][google.cloud.retail.v2.Product] at a list
   * of places, while respecting the last update timestamps of each inventory field.
   *
   * <p>This process is asynchronous and does not require the
   * [Product][google.cloud.retail.v2.Product] to exist before updating inventory information. If
   * the request is valid, the update will be enqueued and processed downstream. As a consequence,
   * when a response is returned, updates are not immediately manifested in the
   * [Product][google.cloud.retail.v2.Product] queried by
   * [ProductService.GetProduct][google.cloud.retail.v2.ProductService.GetProduct] or
   * [ProductService.ListProducts][google.cloud.retail.v2.ProductService.ListProducts].
   *
   * <p>Local inventory information can only be modified using this method.
   * [ProductService.CreateProduct][google.cloud.retail.v2.ProductService.CreateProduct] and
   * [ProductService.UpdateProduct][google.cloud.retail.v2.ProductService.UpdateProduct] has no
   * effect on local inventories.
   *
   * <p>The returned [Operation][google.longrunning.Operation]s will be obsolete after 1 day, and
   * [GetOperation][google.longrunning.Operations.GetOperation] API will return NOT_FOUND
   * afterwards.
   *
   * <p>If conflicting updates are issued, the [Operation][google.longrunning.Operation]s associated
   * with the stale updates will not be marked as [done][google.longrunning.Operation.done] until
   * being obsolete.
   *
   * <p>This feature is only available for users who have Retail Search enabled. Enable Retail
   * Search on Cloud Console before using this feature.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProductServiceClient productServiceClient = ProductServiceClient.create()) {
   *   AddLocalInventoriesRequest request =
   *       AddLocalInventoriesRequest.newBuilder()
   *           .setProduct(
   *               ProductName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[BRANCH]", "[PRODUCT]")
   *                   .toString())
   *           .addAllLocalInventories(new ArrayList<LocalInventory>())
   *           .setAddMask(FieldMask.newBuilder().build())
   *           .setAddTime(Timestamp.newBuilder().build())
   *           .setAllowMissing(true)
   *           .build();
   *   AddLocalInventoriesResponse response =
   *       productServiceClient.addLocalInventoriesAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<AddLocalInventoriesResponse, AddLocalInventoriesMetadata>
      addLocalInventoriesAsync(AddLocalInventoriesRequest request) {
    return addLocalInventoriesOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates local inventory information for a [Product][google.cloud.retail.v2.Product] at a list
   * of places, while respecting the last update timestamps of each inventory field.
   *
   * <p>This process is asynchronous and does not require the
   * [Product][google.cloud.retail.v2.Product] to exist before updating inventory information. If
   * the request is valid, the update will be enqueued and processed downstream. As a consequence,
   * when a response is returned, updates are not immediately manifested in the
   * [Product][google.cloud.retail.v2.Product] queried by
   * [ProductService.GetProduct][google.cloud.retail.v2.ProductService.GetProduct] or
   * [ProductService.ListProducts][google.cloud.retail.v2.ProductService.ListProducts].
   *
   * <p>Local inventory information can only be modified using this method.
   * [ProductService.CreateProduct][google.cloud.retail.v2.ProductService.CreateProduct] and
   * [ProductService.UpdateProduct][google.cloud.retail.v2.ProductService.UpdateProduct] has no
   * effect on local inventories.
   *
   * <p>The returned [Operation][google.longrunning.Operation]s will be obsolete after 1 day, and
   * [GetOperation][google.longrunning.Operations.GetOperation] API will return NOT_FOUND
   * afterwards.
   *
   * <p>If conflicting updates are issued, the [Operation][google.longrunning.Operation]s associated
   * with the stale updates will not be marked as [done][google.longrunning.Operation.done] until
   * being obsolete.
   *
   * <p>This feature is only available for users who have Retail Search enabled. Enable Retail
   * Search on Cloud Console before using this feature.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProductServiceClient productServiceClient = ProductServiceClient.create()) {
   *   AddLocalInventoriesRequest request =
   *       AddLocalInventoriesRequest.newBuilder()
   *           .setProduct(
   *               ProductName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[BRANCH]", "[PRODUCT]")
   *                   .toString())
   *           .addAllLocalInventories(new ArrayList<LocalInventory>())
   *           .setAddMask(FieldMask.newBuilder().build())
   *           .setAddTime(Timestamp.newBuilder().build())
   *           .setAllowMissing(true)
   *           .build();
   *   OperationFuture<AddLocalInventoriesResponse, AddLocalInventoriesMetadata> future =
   *       productServiceClient.addLocalInventoriesOperationCallable().futureCall(request);
   *   // Do something.
   *   AddLocalInventoriesResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          AddLocalInventoriesRequest, AddLocalInventoriesResponse, AddLocalInventoriesMetadata>
      addLocalInventoriesOperationCallable() {
    return stub.addLocalInventoriesOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates local inventory information for a [Product][google.cloud.retail.v2.Product] at a list
   * of places, while respecting the last update timestamps of each inventory field.
   *
   * <p>This process is asynchronous and does not require the
   * [Product][google.cloud.retail.v2.Product] to exist before updating inventory information. If
   * the request is valid, the update will be enqueued and processed downstream. As a consequence,
   * when a response is returned, updates are not immediately manifested in the
   * [Product][google.cloud.retail.v2.Product] queried by
   * [ProductService.GetProduct][google.cloud.retail.v2.ProductService.GetProduct] or
   * [ProductService.ListProducts][google.cloud.retail.v2.ProductService.ListProducts].
   *
   * <p>Local inventory information can only be modified using this method.
   * [ProductService.CreateProduct][google.cloud.retail.v2.ProductService.CreateProduct] and
   * [ProductService.UpdateProduct][google.cloud.retail.v2.ProductService.UpdateProduct] has no
   * effect on local inventories.
   *
   * <p>The returned [Operation][google.longrunning.Operation]s will be obsolete after 1 day, and
   * [GetOperation][google.longrunning.Operations.GetOperation] API will return NOT_FOUND
   * afterwards.
   *
   * <p>If conflicting updates are issued, the [Operation][google.longrunning.Operation]s associated
   * with the stale updates will not be marked as [done][google.longrunning.Operation.done] until
   * being obsolete.
   *
   * <p>This feature is only available for users who have Retail Search enabled. Enable Retail
   * Search on Cloud Console before using this feature.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProductServiceClient productServiceClient = ProductServiceClient.create()) {
   *   AddLocalInventoriesRequest request =
   *       AddLocalInventoriesRequest.newBuilder()
   *           .setProduct(
   *               ProductName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[BRANCH]", "[PRODUCT]")
   *                   .toString())
   *           .addAllLocalInventories(new ArrayList<LocalInventory>())
   *           .setAddMask(FieldMask.newBuilder().build())
   *           .setAddTime(Timestamp.newBuilder().build())
   *           .setAllowMissing(true)
   *           .build();
   *   ApiFuture<Operation> future =
   *       productServiceClient.addLocalInventoriesCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<AddLocalInventoriesRequest, Operation> addLocalInventoriesCallable() {
    return stub.addLocalInventoriesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Remove local inventory information for a [Product][google.cloud.retail.v2.Product] at a list of
   * places at a removal timestamp.
   *
   * <p>This process is asynchronous. If the request is valid, the removal will be enqueued and
   * processed downstream. As a consequence, when a response is returned, removals are not
   * immediately manifested in the [Product][google.cloud.retail.v2.Product] queried by
   * [ProductService.GetProduct][google.cloud.retail.v2.ProductService.GetProduct] or
   * [ProductService.ListProducts][google.cloud.retail.v2.ProductService.ListProducts].
   *
   * <p>Local inventory information can only be removed using this method.
   * [ProductService.CreateProduct][google.cloud.retail.v2.ProductService.CreateProduct] and
   * [ProductService.UpdateProduct][google.cloud.retail.v2.ProductService.UpdateProduct] has no
   * effect on local inventories.
   *
   * <p>The returned [Operation][google.longrunning.Operation]s will be obsolete after 1 day, and
   * [GetOperation][google.longrunning.Operations.GetOperation] API will return NOT_FOUND
   * afterwards.
   *
   * <p>If conflicting updates are issued, the [Operation][google.longrunning.Operation]s associated
   * with the stale updates will not be marked as [done][google.longrunning.Operation.done] until
   * being obsolete.
   *
   * <p>This feature is only available for users who have Retail Search enabled. Enable Retail
   * Search on Cloud Console before using this feature.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProductServiceClient productServiceClient = ProductServiceClient.create()) {
   *   ProductName product =
   *       ProductName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[BRANCH]", "[PRODUCT]");
   *   RemoveLocalInventoriesResponse response =
   *       productServiceClient.removeLocalInventoriesAsync(product).get();
   * }
   * }</pre>
   *
   * @param product Required. Full resource name of [Product][google.cloud.retail.v2.Product], such
   *     as
   *     `projects/&#42;/locations/global/catalogs/default_catalog/branches/default_branch/products/some_product_id`.
   *     <p>If the caller does not have permission to access the
   *     [Product][google.cloud.retail.v2.Product], regardless of whether or not it exists, a
   *     PERMISSION_DENIED error is returned.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<RemoveLocalInventoriesResponse, RemoveLocalInventoriesMetadata>
      removeLocalInventoriesAsync(ProductName product) {
    RemoveLocalInventoriesRequest request =
        RemoveLocalInventoriesRequest.newBuilder()
            .setProduct(product == null ? null : product.toString())
            .build();
    return removeLocalInventoriesAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Remove local inventory information for a [Product][google.cloud.retail.v2.Product] at a list of
   * places at a removal timestamp.
   *
   * <p>This process is asynchronous. If the request is valid, the removal will be enqueued and
   * processed downstream. As a consequence, when a response is returned, removals are not
   * immediately manifested in the [Product][google.cloud.retail.v2.Product] queried by
   * [ProductService.GetProduct][google.cloud.retail.v2.ProductService.GetProduct] or
   * [ProductService.ListProducts][google.cloud.retail.v2.ProductService.ListProducts].
   *
   * <p>Local inventory information can only be removed using this method.
   * [ProductService.CreateProduct][google.cloud.retail.v2.ProductService.CreateProduct] and
   * [ProductService.UpdateProduct][google.cloud.retail.v2.ProductService.UpdateProduct] has no
   * effect on local inventories.
   *
   * <p>The returned [Operation][google.longrunning.Operation]s will be obsolete after 1 day, and
   * [GetOperation][google.longrunning.Operations.GetOperation] API will return NOT_FOUND
   * afterwards.
   *
   * <p>If conflicting updates are issued, the [Operation][google.longrunning.Operation]s associated
   * with the stale updates will not be marked as [done][google.longrunning.Operation.done] until
   * being obsolete.
   *
   * <p>This feature is only available for users who have Retail Search enabled. Enable Retail
   * Search on Cloud Console before using this feature.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProductServiceClient productServiceClient = ProductServiceClient.create()) {
   *   String product =
   *       ProductName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[BRANCH]", "[PRODUCT]")
   *           .toString();
   *   RemoveLocalInventoriesResponse response =
   *       productServiceClient.removeLocalInventoriesAsync(product).get();
   * }
   * }</pre>
   *
   * @param product Required. Full resource name of [Product][google.cloud.retail.v2.Product], such
   *     as
   *     `projects/&#42;/locations/global/catalogs/default_catalog/branches/default_branch/products/some_product_id`.
   *     <p>If the caller does not have permission to access the
   *     [Product][google.cloud.retail.v2.Product], regardless of whether or not it exists, a
   *     PERMISSION_DENIED error is returned.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<RemoveLocalInventoriesResponse, RemoveLocalInventoriesMetadata>
      removeLocalInventoriesAsync(String product) {
    RemoveLocalInventoriesRequest request =
        RemoveLocalInventoriesRequest.newBuilder().setProduct(product).build();
    return removeLocalInventoriesAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Remove local inventory information for a [Product][google.cloud.retail.v2.Product] at a list of
   * places at a removal timestamp.
   *
   * <p>This process is asynchronous. If the request is valid, the removal will be enqueued and
   * processed downstream. As a consequence, when a response is returned, removals are not
   * immediately manifested in the [Product][google.cloud.retail.v2.Product] queried by
   * [ProductService.GetProduct][google.cloud.retail.v2.ProductService.GetProduct] or
   * [ProductService.ListProducts][google.cloud.retail.v2.ProductService.ListProducts].
   *
   * <p>Local inventory information can only be removed using this method.
   * [ProductService.CreateProduct][google.cloud.retail.v2.ProductService.CreateProduct] and
   * [ProductService.UpdateProduct][google.cloud.retail.v2.ProductService.UpdateProduct] has no
   * effect on local inventories.
   *
   * <p>The returned [Operation][google.longrunning.Operation]s will be obsolete after 1 day, and
   * [GetOperation][google.longrunning.Operations.GetOperation] API will return NOT_FOUND
   * afterwards.
   *
   * <p>If conflicting updates are issued, the [Operation][google.longrunning.Operation]s associated
   * with the stale updates will not be marked as [done][google.longrunning.Operation.done] until
   * being obsolete.
   *
   * <p>This feature is only available for users who have Retail Search enabled. Enable Retail
   * Search on Cloud Console before using this feature.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProductServiceClient productServiceClient = ProductServiceClient.create()) {
   *   RemoveLocalInventoriesRequest request =
   *       RemoveLocalInventoriesRequest.newBuilder()
   *           .setProduct(
   *               ProductName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[BRANCH]", "[PRODUCT]")
   *                   .toString())
   *           .addAllPlaceIds(new ArrayList<String>())
   *           .setRemoveTime(Timestamp.newBuilder().build())
   *           .setAllowMissing(true)
   *           .build();
   *   RemoveLocalInventoriesResponse response =
   *       productServiceClient.removeLocalInventoriesAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<RemoveLocalInventoriesResponse, RemoveLocalInventoriesMetadata>
      removeLocalInventoriesAsync(RemoveLocalInventoriesRequest request) {
    return removeLocalInventoriesOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Remove local inventory information for a [Product][google.cloud.retail.v2.Product] at a list of
   * places at a removal timestamp.
   *
   * <p>This process is asynchronous. If the request is valid, the removal will be enqueued and
   * processed downstream. As a consequence, when a response is returned, removals are not
   * immediately manifested in the [Product][google.cloud.retail.v2.Product] queried by
   * [ProductService.GetProduct][google.cloud.retail.v2.ProductService.GetProduct] or
   * [ProductService.ListProducts][google.cloud.retail.v2.ProductService.ListProducts].
   *
   * <p>Local inventory information can only be removed using this method.
   * [ProductService.CreateProduct][google.cloud.retail.v2.ProductService.CreateProduct] and
   * [ProductService.UpdateProduct][google.cloud.retail.v2.ProductService.UpdateProduct] has no
   * effect on local inventories.
   *
   * <p>The returned [Operation][google.longrunning.Operation]s will be obsolete after 1 day, and
   * [GetOperation][google.longrunning.Operations.GetOperation] API will return NOT_FOUND
   * afterwards.
   *
   * <p>If conflicting updates are issued, the [Operation][google.longrunning.Operation]s associated
   * with the stale updates will not be marked as [done][google.longrunning.Operation.done] until
   * being obsolete.
   *
   * <p>This feature is only available for users who have Retail Search enabled. Enable Retail
   * Search on Cloud Console before using this feature.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProductServiceClient productServiceClient = ProductServiceClient.create()) {
   *   RemoveLocalInventoriesRequest request =
   *       RemoveLocalInventoriesRequest.newBuilder()
   *           .setProduct(
   *               ProductName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[BRANCH]", "[PRODUCT]")
   *                   .toString())
   *           .addAllPlaceIds(new ArrayList<String>())
   *           .setRemoveTime(Timestamp.newBuilder().build())
   *           .setAllowMissing(true)
   *           .build();
   *   OperationFuture<RemoveLocalInventoriesResponse, RemoveLocalInventoriesMetadata> future =
   *       productServiceClient.removeLocalInventoriesOperationCallable().futureCall(request);
   *   // Do something.
   *   RemoveLocalInventoriesResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          RemoveLocalInventoriesRequest,
          RemoveLocalInventoriesResponse,
          RemoveLocalInventoriesMetadata>
      removeLocalInventoriesOperationCallable() {
    return stub.removeLocalInventoriesOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Remove local inventory information for a [Product][google.cloud.retail.v2.Product] at a list of
   * places at a removal timestamp.
   *
   * <p>This process is asynchronous. If the request is valid, the removal will be enqueued and
   * processed downstream. As a consequence, when a response is returned, removals are not
   * immediately manifested in the [Product][google.cloud.retail.v2.Product] queried by
   * [ProductService.GetProduct][google.cloud.retail.v2.ProductService.GetProduct] or
   * [ProductService.ListProducts][google.cloud.retail.v2.ProductService.ListProducts].
   *
   * <p>Local inventory information can only be removed using this method.
   * [ProductService.CreateProduct][google.cloud.retail.v2.ProductService.CreateProduct] and
   * [ProductService.UpdateProduct][google.cloud.retail.v2.ProductService.UpdateProduct] has no
   * effect on local inventories.
   *
   * <p>The returned [Operation][google.longrunning.Operation]s will be obsolete after 1 day, and
   * [GetOperation][google.longrunning.Operations.GetOperation] API will return NOT_FOUND
   * afterwards.
   *
   * <p>If conflicting updates are issued, the [Operation][google.longrunning.Operation]s associated
   * with the stale updates will not be marked as [done][google.longrunning.Operation.done] until
   * being obsolete.
   *
   * <p>This feature is only available for users who have Retail Search enabled. Enable Retail
   * Search on Cloud Console before using this feature.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProductServiceClient productServiceClient = ProductServiceClient.create()) {
   *   RemoveLocalInventoriesRequest request =
   *       RemoveLocalInventoriesRequest.newBuilder()
   *           .setProduct(
   *               ProductName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[BRANCH]", "[PRODUCT]")
   *                   .toString())
   *           .addAllPlaceIds(new ArrayList<String>())
   *           .setRemoveTime(Timestamp.newBuilder().build())
   *           .setAllowMissing(true)
   *           .build();
   *   ApiFuture<Operation> future =
   *       productServiceClient.removeLocalInventoriesCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<RemoveLocalInventoriesRequest, Operation>
      removeLocalInventoriesCallable() {
    return stub.removeLocalInventoriesCallable();
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
