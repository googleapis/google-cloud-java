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

package com.google.cloud.productregistry.v1;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.productregistry.v1.stub.CloudProductRegistryReadServiceStub;
import com.google.cloud.productregistry.v1.stub.CloudProductRegistryReadServiceStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Cloud Product Registry Read Service provides capabilities to access all
 * first and third party Google Cloud products.
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
 * try (CloudProductRegistryReadServiceClient cloudProductRegistryReadServiceClient =
 *     CloudProductRegistryReadServiceClient.create()) {
 *   ProductSuiteName name = ProductSuiteName.of("[PRODUCT_SUITE]");
 *   ProductSuite response = cloudProductRegistryReadServiceClient.getProductSuite(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the CloudProductRegistryReadServiceClient object to clean
 * up resources such as threads. In the example above, try-with-resources is used, which
 * automatically calls close().
 *
 * <table>
 *    <caption>Methods</caption>
 *    <tr>
 *      <th>Method</th>
 *      <th>Description</th>
 *      <th>Method Variants</th>
 *    </tr>
 *    <tr>
 *      <td><p> GetProductSuite</td>
 *      <td><p> Get details of a ProductSuite.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getProductSuite(GetProductSuiteRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getProductSuite(ProductSuiteName name)
 *           <li><p> getProductSuite(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getProductSuiteCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListProductSuites</td>
 *      <td><p> Lists ProductSuites.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listProductSuites(ListProductSuitesRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listProductSuitesPagedCallable()
 *           <li><p> listProductSuitesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetLogicalProduct</td>
 *      <td><p> Gets details of a LogicalProduct.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getLogicalProduct(GetLogicalProductRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getLogicalProduct(LogicalProductName name)
 *           <li><p> getLogicalProduct(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getLogicalProductCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListLogicalProducts</td>
 *      <td><p> Lists LogicalProducts matching given criteria.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listLogicalProducts(ListLogicalProductsRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listLogicalProductsPagedCallable()
 *           <li><p> listLogicalProductsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetLogicalProductVariant</td>
 *      <td><p> Get details of a LogicalProductVariant.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getLogicalProductVariant(GetLogicalProductVariantRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getLogicalProductVariant(LogicalProductVariantName name)
 *           <li><p> getLogicalProductVariant(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getLogicalProductVariantCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListLogicalProductVariants</td>
 *      <td><p> Lists LogicalProductVariants matching given criteria.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listLogicalProductVariants(ListLogicalProductVariantsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listLogicalProductVariants(LogicalProductName parent)
 *           <li><p> listLogicalProductVariants(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listLogicalProductVariantsPagedCallable()
 *           <li><p> listLogicalProductVariantsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> LookupEntity</td>
 *      <td><p> Look up entities.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> lookupEntity(LookupEntityRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> lookupEntityCallable()
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
 * CloudProductRegistryReadServiceSettings to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * CloudProductRegistryReadServiceSettings cloudProductRegistryReadServiceSettings =
 *     CloudProductRegistryReadServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * CloudProductRegistryReadServiceClient cloudProductRegistryReadServiceClient =
 *     CloudProductRegistryReadServiceClient.create(cloudProductRegistryReadServiceSettings);
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
 * CloudProductRegistryReadServiceSettings cloudProductRegistryReadServiceSettings =
 *     CloudProductRegistryReadServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * CloudProductRegistryReadServiceClient cloudProductRegistryReadServiceClient =
 *     CloudProductRegistryReadServiceClient.create(cloudProductRegistryReadServiceSettings);
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
 * CloudProductRegistryReadServiceSettings cloudProductRegistryReadServiceSettings =
 *     CloudProductRegistryReadServiceSettings.newHttpJsonBuilder().build();
 * CloudProductRegistryReadServiceClient cloudProductRegistryReadServiceClient =
 *     CloudProductRegistryReadServiceClient.create(cloudProductRegistryReadServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@NullMarked
@Generated("by gapic-generator-java")
public class CloudProductRegistryReadServiceClient implements BackgroundResource {
  private final @Nullable CloudProductRegistryReadServiceSettings settings;
  private final CloudProductRegistryReadServiceStub stub;

  /** Constructs an instance of CloudProductRegistryReadServiceClient with default settings. */
  public static final CloudProductRegistryReadServiceClient create() throws IOException {
    return create(CloudProductRegistryReadServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of CloudProductRegistryReadServiceClient, using the given settings. The
   * channels are created based on the settings passed in, or defaults for any settings that are not
   * set.
   */
  public static final CloudProductRegistryReadServiceClient create(
      CloudProductRegistryReadServiceSettings settings) throws IOException {
    return new CloudProductRegistryReadServiceClient(settings);
  }

  /**
   * Constructs an instance of CloudProductRegistryReadServiceClient, using the given stub for
   * making calls. This is for advanced usage - prefer using
   * create(CloudProductRegistryReadServiceSettings).
   */
  public static final CloudProductRegistryReadServiceClient create(
      CloudProductRegistryReadServiceStub stub) {
    return new CloudProductRegistryReadServiceClient(stub);
  }

  /**
   * Constructs an instance of CloudProductRegistryReadServiceClient, using the given settings. This
   * is protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected CloudProductRegistryReadServiceClient(CloudProductRegistryReadServiceSettings settings)
      throws IOException {
    this.settings = settings;
    this.stub =
        ((CloudProductRegistryReadServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected CloudProductRegistryReadServiceClient(CloudProductRegistryReadServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final @Nullable CloudProductRegistryReadServiceSettings getSettings() {
    return settings;
  }

  public CloudProductRegistryReadServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get details of a ProductSuite.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudProductRegistryReadServiceClient cloudProductRegistryReadServiceClient =
   *     CloudProductRegistryReadServiceClient.create()) {
   *   ProductSuiteName name = ProductSuiteName.of("[PRODUCT_SUITE]");
   *   ProductSuite response = cloudProductRegistryReadServiceClient.getProductSuite(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the ProductSuite to retrieve. Format:
   *     productSuites/{product_suite}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ProductSuite getProductSuite(@Nullable ProductSuiteName name) {
    GetProductSuiteRequest request =
        GetProductSuiteRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getProductSuite(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get details of a ProductSuite.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudProductRegistryReadServiceClient cloudProductRegistryReadServiceClient =
   *     CloudProductRegistryReadServiceClient.create()) {
   *   String name = ProductSuiteName.of("[PRODUCT_SUITE]").toString();
   *   ProductSuite response = cloudProductRegistryReadServiceClient.getProductSuite(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the ProductSuite to retrieve. Format:
   *     productSuites/{product_suite}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ProductSuite getProductSuite(String name) {
    GetProductSuiteRequest request = GetProductSuiteRequest.newBuilder().setName(name).build();
    return getProductSuite(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get details of a ProductSuite.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudProductRegistryReadServiceClient cloudProductRegistryReadServiceClient =
   *     CloudProductRegistryReadServiceClient.create()) {
   *   GetProductSuiteRequest request =
   *       GetProductSuiteRequest.newBuilder()
   *           .setName(ProductSuiteName.of("[PRODUCT_SUITE]").toString())
   *           .build();
   *   ProductSuite response = cloudProductRegistryReadServiceClient.getProductSuite(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ProductSuite getProductSuite(GetProductSuiteRequest request) {
    return getProductSuiteCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get details of a ProductSuite.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudProductRegistryReadServiceClient cloudProductRegistryReadServiceClient =
   *     CloudProductRegistryReadServiceClient.create()) {
   *   GetProductSuiteRequest request =
   *       GetProductSuiteRequest.newBuilder()
   *           .setName(ProductSuiteName.of("[PRODUCT_SUITE]").toString())
   *           .build();
   *   ApiFuture<ProductSuite> future =
   *       cloudProductRegistryReadServiceClient.getProductSuiteCallable().futureCall(request);
   *   // Do something.
   *   ProductSuite response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetProductSuiteRequest, ProductSuite> getProductSuiteCallable() {
    return stub.getProductSuiteCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists ProductSuites.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudProductRegistryReadServiceClient cloudProductRegistryReadServiceClient =
   *     CloudProductRegistryReadServiceClient.create()) {
   *   ListProductSuitesRequest request =
   *       ListProductSuitesRequest.newBuilder()
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (ProductSuite element :
   *       cloudProductRegistryReadServiceClient.listProductSuites(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListProductSuitesPagedResponse listProductSuites(ListProductSuitesRequest request) {
    return listProductSuitesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists ProductSuites.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudProductRegistryReadServiceClient cloudProductRegistryReadServiceClient =
   *     CloudProductRegistryReadServiceClient.create()) {
   *   ListProductSuitesRequest request =
   *       ListProductSuitesRequest.newBuilder()
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<ProductSuite> future =
   *       cloudProductRegistryReadServiceClient
   *           .listProductSuitesPagedCallable()
   *           .futureCall(request);
   *   // Do something.
   *   for (ProductSuite element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListProductSuitesRequest, ListProductSuitesPagedResponse>
      listProductSuitesPagedCallable() {
    return stub.listProductSuitesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists ProductSuites.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudProductRegistryReadServiceClient cloudProductRegistryReadServiceClient =
   *     CloudProductRegistryReadServiceClient.create()) {
   *   ListProductSuitesRequest request =
   *       ListProductSuitesRequest.newBuilder()
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListProductSuitesResponse response =
   *         cloudProductRegistryReadServiceClient.listProductSuitesCallable().call(request);
   *     for (ProductSuite element : response.getProductSuitesList()) {
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
  public final UnaryCallable<ListProductSuitesRequest, ListProductSuitesResponse>
      listProductSuitesCallable() {
    return stub.listProductSuitesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a LogicalProduct.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudProductRegistryReadServiceClient cloudProductRegistryReadServiceClient =
   *     CloudProductRegistryReadServiceClient.create()) {
   *   LogicalProductName name = LogicalProductName.of("[LOGICAL_PRODUCT]");
   *   LogicalProduct response = cloudProductRegistryReadServiceClient.getLogicalProduct(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the LogicalProduct to retrieve. Format:
   *     logicalProducts/{logical_product}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LogicalProduct getLogicalProduct(@Nullable LogicalProductName name) {
    GetLogicalProductRequest request =
        GetLogicalProductRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getLogicalProduct(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a LogicalProduct.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudProductRegistryReadServiceClient cloudProductRegistryReadServiceClient =
   *     CloudProductRegistryReadServiceClient.create()) {
   *   String name = LogicalProductName.of("[LOGICAL_PRODUCT]").toString();
   *   LogicalProduct response = cloudProductRegistryReadServiceClient.getLogicalProduct(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the LogicalProduct to retrieve. Format:
   *     logicalProducts/{logical_product}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LogicalProduct getLogicalProduct(String name) {
    GetLogicalProductRequest request = GetLogicalProductRequest.newBuilder().setName(name).build();
    return getLogicalProduct(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a LogicalProduct.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudProductRegistryReadServiceClient cloudProductRegistryReadServiceClient =
   *     CloudProductRegistryReadServiceClient.create()) {
   *   GetLogicalProductRequest request =
   *       GetLogicalProductRequest.newBuilder()
   *           .setName(LogicalProductName.of("[LOGICAL_PRODUCT]").toString())
   *           .build();
   *   LogicalProduct response = cloudProductRegistryReadServiceClient.getLogicalProduct(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LogicalProduct getLogicalProduct(GetLogicalProductRequest request) {
    return getLogicalProductCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a LogicalProduct.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudProductRegistryReadServiceClient cloudProductRegistryReadServiceClient =
   *     CloudProductRegistryReadServiceClient.create()) {
   *   GetLogicalProductRequest request =
   *       GetLogicalProductRequest.newBuilder()
   *           .setName(LogicalProductName.of("[LOGICAL_PRODUCT]").toString())
   *           .build();
   *   ApiFuture<LogicalProduct> future =
   *       cloudProductRegistryReadServiceClient.getLogicalProductCallable().futureCall(request);
   *   // Do something.
   *   LogicalProduct response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetLogicalProductRequest, LogicalProduct> getLogicalProductCallable() {
    return stub.getLogicalProductCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists LogicalProducts matching given criteria.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudProductRegistryReadServiceClient cloudProductRegistryReadServiceClient =
   *     CloudProductRegistryReadServiceClient.create()) {
   *   ListLogicalProductsRequest request =
   *       ListLogicalProductsRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (LogicalProduct element :
   *       cloudProductRegistryReadServiceClient.listLogicalProducts(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListLogicalProductsPagedResponse listLogicalProducts(
      ListLogicalProductsRequest request) {
    return listLogicalProductsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists LogicalProducts matching given criteria.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudProductRegistryReadServiceClient cloudProductRegistryReadServiceClient =
   *     CloudProductRegistryReadServiceClient.create()) {
   *   ListLogicalProductsRequest request =
   *       ListLogicalProductsRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<LogicalProduct> future =
   *       cloudProductRegistryReadServiceClient
   *           .listLogicalProductsPagedCallable()
   *           .futureCall(request);
   *   // Do something.
   *   for (LogicalProduct element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListLogicalProductsRequest, ListLogicalProductsPagedResponse>
      listLogicalProductsPagedCallable() {
    return stub.listLogicalProductsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists LogicalProducts matching given criteria.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudProductRegistryReadServiceClient cloudProductRegistryReadServiceClient =
   *     CloudProductRegistryReadServiceClient.create()) {
   *   ListLogicalProductsRequest request =
   *       ListLogicalProductsRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListLogicalProductsResponse response =
   *         cloudProductRegistryReadServiceClient.listLogicalProductsCallable().call(request);
   *     for (LogicalProduct element : response.getLogicalProductsList()) {
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
  public final UnaryCallable<ListLogicalProductsRequest, ListLogicalProductsResponse>
      listLogicalProductsCallable() {
    return stub.listLogicalProductsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get details of a LogicalProductVariant.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudProductRegistryReadServiceClient cloudProductRegistryReadServiceClient =
   *     CloudProductRegistryReadServiceClient.create()) {
   *   LogicalProductVariantName name =
   *       LogicalProductVariantName.of("[LOGICAL_PRODUCT]", "[VARIANT]");
   *   LogicalProductVariant response =
   *       cloudProductRegistryReadServiceClient.getLogicalProductVariant(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the LogicalProductVariant to retrieve. Format:
   *     logicalProducts/{logical_product}/variants/{variant}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LogicalProductVariant getLogicalProductVariant(
      @Nullable LogicalProductVariantName name) {
    GetLogicalProductVariantRequest request =
        GetLogicalProductVariantRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getLogicalProductVariant(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get details of a LogicalProductVariant.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudProductRegistryReadServiceClient cloudProductRegistryReadServiceClient =
   *     CloudProductRegistryReadServiceClient.create()) {
   *   String name = LogicalProductVariantName.of("[LOGICAL_PRODUCT]", "[VARIANT]").toString();
   *   LogicalProductVariant response =
   *       cloudProductRegistryReadServiceClient.getLogicalProductVariant(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the LogicalProductVariant to retrieve. Format:
   *     logicalProducts/{logical_product}/variants/{variant}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LogicalProductVariant getLogicalProductVariant(String name) {
    GetLogicalProductVariantRequest request =
        GetLogicalProductVariantRequest.newBuilder().setName(name).build();
    return getLogicalProductVariant(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get details of a LogicalProductVariant.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudProductRegistryReadServiceClient cloudProductRegistryReadServiceClient =
   *     CloudProductRegistryReadServiceClient.create()) {
   *   GetLogicalProductVariantRequest request =
   *       GetLogicalProductVariantRequest.newBuilder()
   *           .setName(LogicalProductVariantName.of("[LOGICAL_PRODUCT]", "[VARIANT]").toString())
   *           .build();
   *   LogicalProductVariant response =
   *       cloudProductRegistryReadServiceClient.getLogicalProductVariant(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LogicalProductVariant getLogicalProductVariant(
      GetLogicalProductVariantRequest request) {
    return getLogicalProductVariantCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get details of a LogicalProductVariant.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudProductRegistryReadServiceClient cloudProductRegistryReadServiceClient =
   *     CloudProductRegistryReadServiceClient.create()) {
   *   GetLogicalProductVariantRequest request =
   *       GetLogicalProductVariantRequest.newBuilder()
   *           .setName(LogicalProductVariantName.of("[LOGICAL_PRODUCT]", "[VARIANT]").toString())
   *           .build();
   *   ApiFuture<LogicalProductVariant> future =
   *       cloudProductRegistryReadServiceClient
   *           .getLogicalProductVariantCallable()
   *           .futureCall(request);
   *   // Do something.
   *   LogicalProductVariant response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetLogicalProductVariantRequest, LogicalProductVariant>
      getLogicalProductVariantCallable() {
    return stub.getLogicalProductVariantCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists LogicalProductVariants matching given criteria.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudProductRegistryReadServiceClient cloudProductRegistryReadServiceClient =
   *     CloudProductRegistryReadServiceClient.create()) {
   *   LogicalProductName parent = LogicalProductName.of("[LOGICAL_PRODUCT]");
   *   for (LogicalProductVariant element :
   *       cloudProductRegistryReadServiceClient.listLogicalProductVariants(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent logical product id. Format: logicalProducts/{logical_product}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListLogicalProductVariantsPagedResponse listLogicalProductVariants(
      @Nullable LogicalProductName parent) {
    ListLogicalProductVariantsRequest request =
        ListLogicalProductVariantsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listLogicalProductVariants(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists LogicalProductVariants matching given criteria.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudProductRegistryReadServiceClient cloudProductRegistryReadServiceClient =
   *     CloudProductRegistryReadServiceClient.create()) {
   *   String parent = LogicalProductName.of("[LOGICAL_PRODUCT]").toString();
   *   for (LogicalProductVariant element :
   *       cloudProductRegistryReadServiceClient.listLogicalProductVariants(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent logical product id. Format: logicalProducts/{logical_product}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListLogicalProductVariantsPagedResponse listLogicalProductVariants(String parent) {
    ListLogicalProductVariantsRequest request =
        ListLogicalProductVariantsRequest.newBuilder().setParent(parent).build();
    return listLogicalProductVariants(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists LogicalProductVariants matching given criteria.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudProductRegistryReadServiceClient cloudProductRegistryReadServiceClient =
   *     CloudProductRegistryReadServiceClient.create()) {
   *   ListLogicalProductVariantsRequest request =
   *       ListLogicalProductVariantsRequest.newBuilder()
   *           .setParent(LogicalProductName.of("[LOGICAL_PRODUCT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (LogicalProductVariant element :
   *       cloudProductRegistryReadServiceClient.listLogicalProductVariants(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListLogicalProductVariantsPagedResponse listLogicalProductVariants(
      ListLogicalProductVariantsRequest request) {
    return listLogicalProductVariantsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists LogicalProductVariants matching given criteria.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudProductRegistryReadServiceClient cloudProductRegistryReadServiceClient =
   *     CloudProductRegistryReadServiceClient.create()) {
   *   ListLogicalProductVariantsRequest request =
   *       ListLogicalProductVariantsRequest.newBuilder()
   *           .setParent(LogicalProductName.of("[LOGICAL_PRODUCT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<LogicalProductVariant> future =
   *       cloudProductRegistryReadServiceClient
   *           .listLogicalProductVariantsPagedCallable()
   *           .futureCall(request);
   *   // Do something.
   *   for (LogicalProductVariant element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<
          ListLogicalProductVariantsRequest, ListLogicalProductVariantsPagedResponse>
      listLogicalProductVariantsPagedCallable() {
    return stub.listLogicalProductVariantsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists LogicalProductVariants matching given criteria.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudProductRegistryReadServiceClient cloudProductRegistryReadServiceClient =
   *     CloudProductRegistryReadServiceClient.create()) {
   *   ListLogicalProductVariantsRequest request =
   *       ListLogicalProductVariantsRequest.newBuilder()
   *           .setParent(LogicalProductName.of("[LOGICAL_PRODUCT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListLogicalProductVariantsResponse response =
   *         cloudProductRegistryReadServiceClient
   *             .listLogicalProductVariantsCallable()
   *             .call(request);
   *     for (LogicalProductVariant element : response.getLogicalProductVariantsList()) {
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
  public final UnaryCallable<ListLogicalProductVariantsRequest, ListLogicalProductVariantsResponse>
      listLogicalProductVariantsCallable() {
    return stub.listLogicalProductVariantsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Look up entities.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudProductRegistryReadServiceClient cloudProductRegistryReadServiceClient =
   *     CloudProductRegistryReadServiceClient.create()) {
   *   LookupEntityRequest request =
   *       LookupEntityRequest.newBuilder().setLookupUri("lookupUri1150318994").build();
   *   LookupEntityResponse response = cloudProductRegistryReadServiceClient.lookupEntity(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LookupEntityResponse lookupEntity(LookupEntityRequest request) {
    return lookupEntityCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Look up entities.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudProductRegistryReadServiceClient cloudProductRegistryReadServiceClient =
   *     CloudProductRegistryReadServiceClient.create()) {
   *   LookupEntityRequest request =
   *       LookupEntityRequest.newBuilder().setLookupUri("lookupUri1150318994").build();
   *   ApiFuture<LookupEntityResponse> future =
   *       cloudProductRegistryReadServiceClient.lookupEntityCallable().futureCall(request);
   *   // Do something.
   *   LookupEntityResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<LookupEntityRequest, LookupEntityResponse> lookupEntityCallable() {
    return stub.lookupEntityCallable();
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

  public static class ListProductSuitesPagedResponse
      extends AbstractPagedListResponse<
          ListProductSuitesRequest,
          ListProductSuitesResponse,
          ProductSuite,
          ListProductSuitesPage,
          ListProductSuitesFixedSizeCollection> {

    public static ApiFuture<ListProductSuitesPagedResponse> createAsync(
        PageContext<ListProductSuitesRequest, ListProductSuitesResponse, ProductSuite> context,
        ApiFuture<ListProductSuitesResponse> futureResponse) {
      ApiFuture<ListProductSuitesPage> futurePage =
          ListProductSuitesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListProductSuitesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListProductSuitesPagedResponse(ListProductSuitesPage page) {
      super(page, ListProductSuitesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListProductSuitesPage
      extends AbstractPage<
          ListProductSuitesRequest,
          ListProductSuitesResponse,
          ProductSuite,
          ListProductSuitesPage> {

    private ListProductSuitesPage(
        @Nullable PageContext<ListProductSuitesRequest, ListProductSuitesResponse, ProductSuite>
            context,
        @Nullable ListProductSuitesResponse response) {
      super(context, response);
    }

    private static ListProductSuitesPage createEmptyPage() {
      return new ListProductSuitesPage(null, null);
    }

    @Override
    protected ListProductSuitesPage createPage(
        @Nullable PageContext<ListProductSuitesRequest, ListProductSuitesResponse, ProductSuite>
            context,
        @Nullable ListProductSuitesResponse response) {
      return new ListProductSuitesPage(context, response);
    }

    @Override
    public ApiFuture<ListProductSuitesPage> createPageAsync(
        @Nullable PageContext<ListProductSuitesRequest, ListProductSuitesResponse, ProductSuite>
            context,
        ApiFuture<ListProductSuitesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListProductSuitesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListProductSuitesRequest,
          ListProductSuitesResponse,
          ProductSuite,
          ListProductSuitesPage,
          ListProductSuitesFixedSizeCollection> {

    private ListProductSuitesFixedSizeCollection(
        @Nullable List<ListProductSuitesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListProductSuitesFixedSizeCollection createEmptyCollection() {
      return new ListProductSuitesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListProductSuitesFixedSizeCollection createCollection(
        @Nullable List<ListProductSuitesPage> pages, int collectionSize) {
      return new ListProductSuitesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListLogicalProductsPagedResponse
      extends AbstractPagedListResponse<
          ListLogicalProductsRequest,
          ListLogicalProductsResponse,
          LogicalProduct,
          ListLogicalProductsPage,
          ListLogicalProductsFixedSizeCollection> {

    public static ApiFuture<ListLogicalProductsPagedResponse> createAsync(
        PageContext<ListLogicalProductsRequest, ListLogicalProductsResponse, LogicalProduct>
            context,
        ApiFuture<ListLogicalProductsResponse> futureResponse) {
      ApiFuture<ListLogicalProductsPage> futurePage =
          ListLogicalProductsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListLogicalProductsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListLogicalProductsPagedResponse(ListLogicalProductsPage page) {
      super(page, ListLogicalProductsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListLogicalProductsPage
      extends AbstractPage<
          ListLogicalProductsRequest,
          ListLogicalProductsResponse,
          LogicalProduct,
          ListLogicalProductsPage> {

    private ListLogicalProductsPage(
        @Nullable
            PageContext<ListLogicalProductsRequest, ListLogicalProductsResponse, LogicalProduct>
            context,
        @Nullable ListLogicalProductsResponse response) {
      super(context, response);
    }

    private static ListLogicalProductsPage createEmptyPage() {
      return new ListLogicalProductsPage(null, null);
    }

    @Override
    protected ListLogicalProductsPage createPage(
        @Nullable
            PageContext<ListLogicalProductsRequest, ListLogicalProductsResponse, LogicalProduct>
            context,
        @Nullable ListLogicalProductsResponse response) {
      return new ListLogicalProductsPage(context, response);
    }

    @Override
    public ApiFuture<ListLogicalProductsPage> createPageAsync(
        @Nullable
            PageContext<ListLogicalProductsRequest, ListLogicalProductsResponse, LogicalProduct>
            context,
        ApiFuture<ListLogicalProductsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListLogicalProductsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListLogicalProductsRequest,
          ListLogicalProductsResponse,
          LogicalProduct,
          ListLogicalProductsPage,
          ListLogicalProductsFixedSizeCollection> {

    private ListLogicalProductsFixedSizeCollection(
        @Nullable List<ListLogicalProductsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListLogicalProductsFixedSizeCollection createEmptyCollection() {
      return new ListLogicalProductsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListLogicalProductsFixedSizeCollection createCollection(
        @Nullable List<ListLogicalProductsPage> pages, int collectionSize) {
      return new ListLogicalProductsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListLogicalProductVariantsPagedResponse
      extends AbstractPagedListResponse<
          ListLogicalProductVariantsRequest,
          ListLogicalProductVariantsResponse,
          LogicalProductVariant,
          ListLogicalProductVariantsPage,
          ListLogicalProductVariantsFixedSizeCollection> {

    public static ApiFuture<ListLogicalProductVariantsPagedResponse> createAsync(
        PageContext<
                ListLogicalProductVariantsRequest,
                ListLogicalProductVariantsResponse,
                LogicalProductVariant>
            context,
        ApiFuture<ListLogicalProductVariantsResponse> futureResponse) {
      ApiFuture<ListLogicalProductVariantsPage> futurePage =
          ListLogicalProductVariantsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListLogicalProductVariantsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListLogicalProductVariantsPagedResponse(ListLogicalProductVariantsPage page) {
      super(page, ListLogicalProductVariantsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListLogicalProductVariantsPage
      extends AbstractPage<
          ListLogicalProductVariantsRequest,
          ListLogicalProductVariantsResponse,
          LogicalProductVariant,
          ListLogicalProductVariantsPage> {

    private ListLogicalProductVariantsPage(
        @Nullable
            PageContext<
                ListLogicalProductVariantsRequest,
                ListLogicalProductVariantsResponse,
                LogicalProductVariant>
            context,
        @Nullable ListLogicalProductVariantsResponse response) {
      super(context, response);
    }

    private static ListLogicalProductVariantsPage createEmptyPage() {
      return new ListLogicalProductVariantsPage(null, null);
    }

    @Override
    protected ListLogicalProductVariantsPage createPage(
        @Nullable
            PageContext<
                ListLogicalProductVariantsRequest,
                ListLogicalProductVariantsResponse,
                LogicalProductVariant>
            context,
        @Nullable ListLogicalProductVariantsResponse response) {
      return new ListLogicalProductVariantsPage(context, response);
    }

    @Override
    public ApiFuture<ListLogicalProductVariantsPage> createPageAsync(
        @Nullable
            PageContext<
                ListLogicalProductVariantsRequest,
                ListLogicalProductVariantsResponse,
                LogicalProductVariant>
            context,
        ApiFuture<ListLogicalProductVariantsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListLogicalProductVariantsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListLogicalProductVariantsRequest,
          ListLogicalProductVariantsResponse,
          LogicalProductVariant,
          ListLogicalProductVariantsPage,
          ListLogicalProductVariantsFixedSizeCollection> {

    private ListLogicalProductVariantsFixedSizeCollection(
        @Nullable List<ListLogicalProductVariantsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListLogicalProductVariantsFixedSizeCollection createEmptyCollection() {
      return new ListLogicalProductVariantsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListLogicalProductVariantsFixedSizeCollection createCollection(
        @Nullable List<ListLogicalProductVariantsPage> pages, int collectionSize) {
      return new ListLogicalProductVariantsFixedSizeCollection(pages, collectionSize);
    }
  }
}
