/*
 * Copyright 2020 Google LLC
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

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.longrunning.OperationFuture;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.retail.v2.stub.ProductServiceStub;
import com.google.cloud.retail.v2.stub.ProductServiceStubSettings;
import com.google.longrunning.Operation;
import com.google.longrunning.OperationsClient;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import java.io.IOException;
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
 * ProductServiceSettings productServiceSettings =
 *     ProductServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * ProductServiceClient productServiceClient = ProductServiceClient.create(productServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator")
public class ProductServiceClient implements BackgroundResource {
  private final ProductServiceSettings settings;
  private final ProductServiceStub stub;
  private final OperationsClient operationsClient;

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
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
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
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected ProductServiceClient(ProductServiceStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  public final ProductServiceSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public ProductServiceStub getStub() {
    return stub;
  }

  /**
   * Returns the OperationsClient that can be used to query the status of a long-running operation
   * returned by another API method call.
   */
  public final OperationsClient getOperationsClient() {
    return operationsClient;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a [Product][google.cloud.retail.v2.Product].
   *
   * @param parent Required. The parent catalog resource name, such as
   *     "projects/&#42;/locations/global/catalogs/default_catalog/branches/default_branch".
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
   * @param parent Required. The parent catalog resource name, such as
   *     "projects/&#42;/locations/global/catalogs/default_catalog/branches/default_branch".
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
   */
  public final UnaryCallable<CreateProductRequest, Product> createProductCallable() {
    return stub.createProductCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a [Product][google.cloud.retail.v2.Product].
   *
   * @param name Required. Full resource name of [Product][google.cloud.retail.v2.Product], such as
   *     "projects/&#42;/locations/global/catalogs/default_catalog/branches/default_branch/products/some_product_id".
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
   * @param name Required. Full resource name of [Product][google.cloud.retail.v2.Product], such as
   *     "projects/&#42;/locations/global/catalogs/default_catalog/branches/default_branch/products/some_product_id".
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
   */
  public final UnaryCallable<GetProductRequest, Product> getProductCallable() {
    return stub.getProductCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a [Product][google.cloud.retail.v2.Product].
   *
   * @param product Required. The product to update/create.
   *     <p>If the caller does not have permission to update the
   *     [Product][google.cloud.retail.v2.Product], regardless of whether or not it exists, a
   *     PERMISSION_DENIED error is returned.
   *     <p>If the [Product][google.cloud.retail.v2.Product] to update does not exist, a NOT_FOUND
   *     error is returned.
   * @param updateMask Indicates which fields in the provided
   *     [Product][google.cloud.retail.v2.Product] to update. The immutable and output only fields
   *     are NOT supported. If not set, all supported fields (the fields that are neither immutable
   *     nor output only) are updated.
   *     <p>If an unsupported or unknown field is provided, an INVALID_ARGUMENT error is returned.
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
   */
  public final UnaryCallable<UpdateProductRequest, Product> updateProductCallable() {
    return stub.updateProductCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a [Product][google.cloud.retail.v2.Product].
   *
   * @param name Required. Full resource name of [Product][google.cloud.retail.v2.Product], such as
   *     "projects/&#42;/locations/global/catalogs/default_catalog/branches/default_branch/products/some_product_id".
   *     <p>If the caller does not have permission to delete the
   *     [Product][google.cloud.retail.v2.Product], regardless of whether or not it exists, a
   *     PERMISSION_DENIED error is returned.
   *     <p>If the [Product][google.cloud.retail.v2.Product] to delete does not exist, a NOT_FOUND
   *     error is returned.
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
   * @param name Required. Full resource name of [Product][google.cloud.retail.v2.Product], such as
   *     "projects/&#42;/locations/global/catalogs/default_catalog/branches/default_branch/products/some_product_id".
   *     <p>If the caller does not have permission to delete the
   *     [Product][google.cloud.retail.v2.Product], regardless of whether or not it exists, a
   *     PERMISSION_DENIED error is returned.
   *     <p>If the [Product][google.cloud.retail.v2.Product] to delete does not exist, a NOT_FOUND
   *     error is returned.
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
   */
  public final UnaryCallable<DeleteProductRequest, Empty> deleteProductCallable() {
    return stub.deleteProductCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Bulk import of multiple [Product][google.cloud.retail.v2.Product]s.
   *
   * <p>Request processing may be synchronous. No partial updating is supported. Non-existing items
   * are created.
   *
   * <p>Note that it is possible for a subset of the [Product][google.cloud.retail.v2.Product]s to
   * be successfully updated.
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
   * <p>Request processing may be synchronous. No partial updating is supported. Non-existing items
   * are created.
   *
   * <p>Note that it is possible for a subset of the [Product][google.cloud.retail.v2.Product]s to
   * be successfully updated.
   *
   * <p>Sample code:
   */
  public final OperationCallable<ImportProductsRequest, ImportProductsResponse, ImportMetadata>
      importProductsOperationCallable() {
    return stub.importProductsOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Bulk import of multiple [Product][google.cloud.retail.v2.Product]s.
   *
   * <p>Request processing may be synchronous. No partial updating is supported. Non-existing items
   * are created.
   *
   * <p>Note that it is possible for a subset of the [Product][google.cloud.retail.v2.Product]s to
   * be successfully updated.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<ImportProductsRequest, Operation> importProductsCallable() {
    return stub.importProductsCallable();
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
}
