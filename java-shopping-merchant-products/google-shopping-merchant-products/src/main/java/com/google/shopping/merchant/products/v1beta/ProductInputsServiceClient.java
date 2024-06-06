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

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.protobuf.Empty;
import com.google.shopping.merchant.products.v1beta.stub.ProductInputsServiceStub;
import com.google.shopping.merchant.products.v1beta.stub.ProductInputsServiceStubSettings;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Service to use ProductInput resource. This service works for products with
 * online channel only.
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
 * try (ProductInputsServiceClient productInputsServiceClient =
 *     ProductInputsServiceClient.create()) {
 *   InsertProductInputRequest request =
 *       InsertProductInputRequest.newBuilder()
 *           .setParent(AccountName.of("[ACCOUNT]").toString())
 *           .setProductInput(ProductInput.newBuilder().build())
 *           .setDataSource("dataSource1272470629")
 *           .build();
 *   ProductInput response = productInputsServiceClient.insertProductInput(request);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the ProductInputsServiceClient object to clean up
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
 *      <td><p> InsertProductInput</td>
 *      <td><p> Uploads a product input to your Merchant Center account. If an input with the same contentLanguage, offerId, and dataSource already exists, this method replaces that entry.
 * <p>  After inserting, updating, or deleting a product input, it may take several minutes before the processed product can be retrieved.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> insertProductInput(InsertProductInputRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> insertProductInputCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteProductInput</td>
 *      <td><p> Deletes a product input from your Merchant Center account.
 * <p>  After inserting, updating, or deleting a product input, it may take several minutes before the processed product can be retrieved.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteProductInput(DeleteProductInputRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deleteProductInput(ProductInputName name)
 *           <li><p> deleteProductInput(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteProductInputCallable()
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
 * <p>This class can be customized by passing in a custom instance of ProductInputsServiceSettings
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
 * ProductInputsServiceSettings productInputsServiceSettings =
 *     ProductInputsServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * ProductInputsServiceClient productInputsServiceClient =
 *     ProductInputsServiceClient.create(productInputsServiceSettings);
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
 * ProductInputsServiceSettings productInputsServiceSettings =
 *     ProductInputsServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * ProductInputsServiceClient productInputsServiceClient =
 *     ProductInputsServiceClient.create(productInputsServiceSettings);
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
 * ProductInputsServiceSettings productInputsServiceSettings =
 *     ProductInputsServiceSettings.newHttpJsonBuilder().build();
 * ProductInputsServiceClient productInputsServiceClient =
 *     ProductInputsServiceClient.create(productInputsServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class ProductInputsServiceClient implements BackgroundResource {
  private final ProductInputsServiceSettings settings;
  private final ProductInputsServiceStub stub;

  /** Constructs an instance of ProductInputsServiceClient with default settings. */
  public static final ProductInputsServiceClient create() throws IOException {
    return create(ProductInputsServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of ProductInputsServiceClient, using the given settings. The channels
   * are created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final ProductInputsServiceClient create(ProductInputsServiceSettings settings)
      throws IOException {
    return new ProductInputsServiceClient(settings);
  }

  /**
   * Constructs an instance of ProductInputsServiceClient, using the given stub for making calls.
   * This is for advanced usage - prefer using create(ProductInputsServiceSettings).
   */
  public static final ProductInputsServiceClient create(ProductInputsServiceStub stub) {
    return new ProductInputsServiceClient(stub);
  }

  /**
   * Constructs an instance of ProductInputsServiceClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected ProductInputsServiceClient(ProductInputsServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((ProductInputsServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected ProductInputsServiceClient(ProductInputsServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final ProductInputsServiceSettings getSettings() {
    return settings;
  }

  public ProductInputsServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Uploads a product input to your Merchant Center account. If an input with the same
   * contentLanguage, offerId, and dataSource already exists, this method replaces that entry.
   *
   * <p>After inserting, updating, or deleting a product input, it may take several minutes before
   * the processed product can be retrieved.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProductInputsServiceClient productInputsServiceClient =
   *     ProductInputsServiceClient.create()) {
   *   InsertProductInputRequest request =
   *       InsertProductInputRequest.newBuilder()
   *           .setParent(AccountName.of("[ACCOUNT]").toString())
   *           .setProductInput(ProductInput.newBuilder().build())
   *           .setDataSource("dataSource1272470629")
   *           .build();
   *   ProductInput response = productInputsServiceClient.insertProductInput(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ProductInput insertProductInput(InsertProductInputRequest request) {
    return insertProductInputCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Uploads a product input to your Merchant Center account. If an input with the same
   * contentLanguage, offerId, and dataSource already exists, this method replaces that entry.
   *
   * <p>After inserting, updating, or deleting a product input, it may take several minutes before
   * the processed product can be retrieved.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProductInputsServiceClient productInputsServiceClient =
   *     ProductInputsServiceClient.create()) {
   *   InsertProductInputRequest request =
   *       InsertProductInputRequest.newBuilder()
   *           .setParent(AccountName.of("[ACCOUNT]").toString())
   *           .setProductInput(ProductInput.newBuilder().build())
   *           .setDataSource("dataSource1272470629")
   *           .build();
   *   ApiFuture<ProductInput> future =
   *       productInputsServiceClient.insertProductInputCallable().futureCall(request);
   *   // Do something.
   *   ProductInput response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<InsertProductInputRequest, ProductInput> insertProductInputCallable() {
    return stub.insertProductInputCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a product input from your Merchant Center account.
   *
   * <p>After inserting, updating, or deleting a product input, it may take several minutes before
   * the processed product can be retrieved.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProductInputsServiceClient productInputsServiceClient =
   *     ProductInputsServiceClient.create()) {
   *   ProductInputName name = ProductInputName.of("[ACCOUNT]", "[PRODUCTINPUT]");
   *   productInputsServiceClient.deleteProductInput(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the product input resource to delete. Format:
   *     accounts/{account}/productInputs/{product}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteProductInput(ProductInputName name) {
    DeleteProductInputRequest request =
        DeleteProductInputRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    deleteProductInput(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a product input from your Merchant Center account.
   *
   * <p>After inserting, updating, or deleting a product input, it may take several minutes before
   * the processed product can be retrieved.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProductInputsServiceClient productInputsServiceClient =
   *     ProductInputsServiceClient.create()) {
   *   String name = ProductInputName.of("[ACCOUNT]", "[PRODUCTINPUT]").toString();
   *   productInputsServiceClient.deleteProductInput(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the product input resource to delete. Format:
   *     accounts/{account}/productInputs/{product}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteProductInput(String name) {
    DeleteProductInputRequest request =
        DeleteProductInputRequest.newBuilder().setName(name).build();
    deleteProductInput(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a product input from your Merchant Center account.
   *
   * <p>After inserting, updating, or deleting a product input, it may take several minutes before
   * the processed product can be retrieved.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProductInputsServiceClient productInputsServiceClient =
   *     ProductInputsServiceClient.create()) {
   *   DeleteProductInputRequest request =
   *       DeleteProductInputRequest.newBuilder()
   *           .setName(ProductInputName.of("[ACCOUNT]", "[PRODUCTINPUT]").toString())
   *           .setDataSource("dataSource1272470629")
   *           .build();
   *   productInputsServiceClient.deleteProductInput(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteProductInput(DeleteProductInputRequest request) {
    deleteProductInputCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a product input from your Merchant Center account.
   *
   * <p>After inserting, updating, or deleting a product input, it may take several minutes before
   * the processed product can be retrieved.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProductInputsServiceClient productInputsServiceClient =
   *     ProductInputsServiceClient.create()) {
   *   DeleteProductInputRequest request =
   *       DeleteProductInputRequest.newBuilder()
   *           .setName(ProductInputName.of("[ACCOUNT]", "[PRODUCTINPUT]").toString())
   *           .setDataSource("dataSource1272470629")
   *           .build();
   *   ApiFuture<Empty> future =
   *       productInputsServiceClient.deleteProductInputCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteProductInputRequest, Empty> deleteProductInputCallable() {
    return stub.deleteProductInputCallable();
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
