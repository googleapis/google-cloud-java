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

package com.google.shopping.merchant.inventories.v1beta;

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
import com.google.shopping.merchant.inventories.v1beta.stub.RegionalInventoryServiceStub;
import com.google.shopping.merchant.inventories.v1beta.stub.RegionalInventoryServiceStubSettings;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Service to manage regional inventory for products. There is also separate
 * `regions` resource and API to manage regions definitions.
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
 * try (RegionalInventoryServiceClient regionalInventoryServiceClient =
 *     RegionalInventoryServiceClient.create()) {
 *   InsertRegionalInventoryRequest request =
 *       InsertRegionalInventoryRequest.newBuilder()
 *           .setParent(ProductName.of("[ACCOUNT]", "[PRODUCT]").toString())
 *           .setRegionalInventory(RegionalInventory.newBuilder().build())
 *           .build();
 *   RegionalInventory response = regionalInventoryServiceClient.insertRegionalInventory(request);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the RegionalInventoryServiceClient object to clean up
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
 *      <td><p> ListRegionalInventories</td>
 *      <td><p> Lists the `RegionalInventory` resources for the given product in your merchant account. The response might contain fewer items than specified by `pageSize`.  If `pageToken` was returned in previous request, it can be used to obtain additional results.
 * <p>  `RegionalInventory` resources are listed per product for a given account.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listRegionalInventories(ListRegionalInventoriesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listRegionalInventories(ProductName parent)
 *           <li><p> listRegionalInventories(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listRegionalInventoriesPagedCallable()
 *           <li><p> listRegionalInventoriesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> InsertRegionalInventory</td>
 *      <td><p> Inserts a `RegionalInventory` to a given product in your merchant account.
 * <p>  Replaces the full `RegionalInventory` resource if an entry with the same [`region`][google.shopping.merchant.inventories.v1beta.RegionalInventory.region] already exists for the product.
 * <p>  It might take up to 30 minutes for the new or updated `RegionalInventory` resource to appear in products.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> insertRegionalInventory(InsertRegionalInventoryRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> insertRegionalInventoryCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteRegionalInventory</td>
 *      <td><p> Deletes the specified `RegionalInventory` resource from the given product in your merchant account.  It might take up to an hour for the `RegionalInventory` to be deleted from the specific product. Once you have received a successful delete response, wait for that period before attempting a delete again.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteRegionalInventory(DeleteRegionalInventoryRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deleteRegionalInventory(RegionalInventoryName name)
 *           <li><p> deleteRegionalInventory(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteRegionalInventoryCallable()
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
 * RegionalInventoryServiceSettings to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * RegionalInventoryServiceSettings regionalInventoryServiceSettings =
 *     RegionalInventoryServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * RegionalInventoryServiceClient regionalInventoryServiceClient =
 *     RegionalInventoryServiceClient.create(regionalInventoryServiceSettings);
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
 * RegionalInventoryServiceSettings regionalInventoryServiceSettings =
 *     RegionalInventoryServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * RegionalInventoryServiceClient regionalInventoryServiceClient =
 *     RegionalInventoryServiceClient.create(regionalInventoryServiceSettings);
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
 * RegionalInventoryServiceSettings regionalInventoryServiceSettings =
 *     RegionalInventoryServiceSettings.newHttpJsonBuilder().build();
 * RegionalInventoryServiceClient regionalInventoryServiceClient =
 *     RegionalInventoryServiceClient.create(regionalInventoryServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class RegionalInventoryServiceClient implements BackgroundResource {
  private final RegionalInventoryServiceSettings settings;
  private final RegionalInventoryServiceStub stub;

  /** Constructs an instance of RegionalInventoryServiceClient with default settings. */
  public static final RegionalInventoryServiceClient create() throws IOException {
    return create(RegionalInventoryServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of RegionalInventoryServiceClient, using the given settings. The
   * channels are created based on the settings passed in, or defaults for any settings that are not
   * set.
   */
  public static final RegionalInventoryServiceClient create(
      RegionalInventoryServiceSettings settings) throws IOException {
    return new RegionalInventoryServiceClient(settings);
  }

  /**
   * Constructs an instance of RegionalInventoryServiceClient, using the given stub for making
   * calls. This is for advanced usage - prefer using create(RegionalInventoryServiceSettings).
   */
  public static final RegionalInventoryServiceClient create(RegionalInventoryServiceStub stub) {
    return new RegionalInventoryServiceClient(stub);
  }

  /**
   * Constructs an instance of RegionalInventoryServiceClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected RegionalInventoryServiceClient(RegionalInventoryServiceSettings settings)
      throws IOException {
    this.settings = settings;
    this.stub = ((RegionalInventoryServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected RegionalInventoryServiceClient(RegionalInventoryServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final RegionalInventoryServiceSettings getSettings() {
    return settings;
  }

  public RegionalInventoryServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the `RegionalInventory` resources for the given product in your merchant account. The
   * response might contain fewer items than specified by `pageSize`. If `pageToken` was returned in
   * previous request, it can be used to obtain additional results.
   *
   * <p>`RegionalInventory` resources are listed per product for a given account.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionalInventoryServiceClient regionalInventoryServiceClient =
   *     RegionalInventoryServiceClient.create()) {
   *   ProductName parent = ProductName.of("[ACCOUNT]", "[PRODUCT]");
   *   for (RegionalInventory element :
   *       regionalInventoryServiceClient.listRegionalInventories(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The `name` of the parent product to list `RegionalInventory` resources
   *     for. Format: `accounts/{account}/products/{product}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListRegionalInventoriesPagedResponse listRegionalInventories(ProductName parent) {
    ListRegionalInventoriesRequest request =
        ListRegionalInventoriesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listRegionalInventories(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the `RegionalInventory` resources for the given product in your merchant account. The
   * response might contain fewer items than specified by `pageSize`. If `pageToken` was returned in
   * previous request, it can be used to obtain additional results.
   *
   * <p>`RegionalInventory` resources are listed per product for a given account.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionalInventoryServiceClient regionalInventoryServiceClient =
   *     RegionalInventoryServiceClient.create()) {
   *   String parent = ProductName.of("[ACCOUNT]", "[PRODUCT]").toString();
   *   for (RegionalInventory element :
   *       regionalInventoryServiceClient.listRegionalInventories(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The `name` of the parent product to list `RegionalInventory` resources
   *     for. Format: `accounts/{account}/products/{product}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListRegionalInventoriesPagedResponse listRegionalInventories(String parent) {
    ListRegionalInventoriesRequest request =
        ListRegionalInventoriesRequest.newBuilder().setParent(parent).build();
    return listRegionalInventories(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the `RegionalInventory` resources for the given product in your merchant account. The
   * response might contain fewer items than specified by `pageSize`. If `pageToken` was returned in
   * previous request, it can be used to obtain additional results.
   *
   * <p>`RegionalInventory` resources are listed per product for a given account.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionalInventoryServiceClient regionalInventoryServiceClient =
   *     RegionalInventoryServiceClient.create()) {
   *   ListRegionalInventoriesRequest request =
   *       ListRegionalInventoriesRequest.newBuilder()
   *           .setParent(ProductName.of("[ACCOUNT]", "[PRODUCT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (RegionalInventory element :
   *       regionalInventoryServiceClient.listRegionalInventories(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListRegionalInventoriesPagedResponse listRegionalInventories(
      ListRegionalInventoriesRequest request) {
    return listRegionalInventoriesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the `RegionalInventory` resources for the given product in your merchant account. The
   * response might contain fewer items than specified by `pageSize`. If `pageToken` was returned in
   * previous request, it can be used to obtain additional results.
   *
   * <p>`RegionalInventory` resources are listed per product for a given account.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionalInventoryServiceClient regionalInventoryServiceClient =
   *     RegionalInventoryServiceClient.create()) {
   *   ListRegionalInventoriesRequest request =
   *       ListRegionalInventoriesRequest.newBuilder()
   *           .setParent(ProductName.of("[ACCOUNT]", "[PRODUCT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<RegionalInventory> future =
   *       regionalInventoryServiceClient.listRegionalInventoriesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (RegionalInventory element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListRegionalInventoriesRequest, ListRegionalInventoriesPagedResponse>
      listRegionalInventoriesPagedCallable() {
    return stub.listRegionalInventoriesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the `RegionalInventory` resources for the given product in your merchant account. The
   * response might contain fewer items than specified by `pageSize`. If `pageToken` was returned in
   * previous request, it can be used to obtain additional results.
   *
   * <p>`RegionalInventory` resources are listed per product for a given account.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionalInventoryServiceClient regionalInventoryServiceClient =
   *     RegionalInventoryServiceClient.create()) {
   *   ListRegionalInventoriesRequest request =
   *       ListRegionalInventoriesRequest.newBuilder()
   *           .setParent(ProductName.of("[ACCOUNT]", "[PRODUCT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListRegionalInventoriesResponse response =
   *         regionalInventoryServiceClient.listRegionalInventoriesCallable().call(request);
   *     for (RegionalInventory element : response.getRegionalInventoriesList()) {
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
  public final UnaryCallable<ListRegionalInventoriesRequest, ListRegionalInventoriesResponse>
      listRegionalInventoriesCallable() {
    return stub.listRegionalInventoriesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Inserts a `RegionalInventory` to a given product in your merchant account.
   *
   * <p>Replaces the full `RegionalInventory` resource if an entry with the same
   * [`region`][google.shopping.merchant.inventories.v1beta.RegionalInventory.region] already exists
   * for the product.
   *
   * <p>It might take up to 30 minutes for the new or updated `RegionalInventory` resource to appear
   * in products.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionalInventoryServiceClient regionalInventoryServiceClient =
   *     RegionalInventoryServiceClient.create()) {
   *   InsertRegionalInventoryRequest request =
   *       InsertRegionalInventoryRequest.newBuilder()
   *           .setParent(ProductName.of("[ACCOUNT]", "[PRODUCT]").toString())
   *           .setRegionalInventory(RegionalInventory.newBuilder().build())
   *           .build();
   *   RegionalInventory response = regionalInventoryServiceClient.insertRegionalInventory(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RegionalInventory insertRegionalInventory(InsertRegionalInventoryRequest request) {
    return insertRegionalInventoryCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Inserts a `RegionalInventory` to a given product in your merchant account.
   *
   * <p>Replaces the full `RegionalInventory` resource if an entry with the same
   * [`region`][google.shopping.merchant.inventories.v1beta.RegionalInventory.region] already exists
   * for the product.
   *
   * <p>It might take up to 30 minutes for the new or updated `RegionalInventory` resource to appear
   * in products.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionalInventoryServiceClient regionalInventoryServiceClient =
   *     RegionalInventoryServiceClient.create()) {
   *   InsertRegionalInventoryRequest request =
   *       InsertRegionalInventoryRequest.newBuilder()
   *           .setParent(ProductName.of("[ACCOUNT]", "[PRODUCT]").toString())
   *           .setRegionalInventory(RegionalInventory.newBuilder().build())
   *           .build();
   *   ApiFuture<RegionalInventory> future =
   *       regionalInventoryServiceClient.insertRegionalInventoryCallable().futureCall(request);
   *   // Do something.
   *   RegionalInventory response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<InsertRegionalInventoryRequest, RegionalInventory>
      insertRegionalInventoryCallable() {
    return stub.insertRegionalInventoryCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified `RegionalInventory` resource from the given product in your merchant
   * account. It might take up to an hour for the `RegionalInventory` to be deleted from the
   * specific product. Once you have received a successful delete response, wait for that period
   * before attempting a delete again.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionalInventoryServiceClient regionalInventoryServiceClient =
   *     RegionalInventoryServiceClient.create()) {
   *   RegionalInventoryName name = RegionalInventoryName.of("[ACCOUNT]", "[PRODUCT]", "[REGION]");
   *   regionalInventoryServiceClient.deleteRegionalInventory(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the `RegionalInventory` resource to delete. Format:
   *     `accounts/{account}/products/{product}/regionalInventories/{region}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteRegionalInventory(RegionalInventoryName name) {
    DeleteRegionalInventoryRequest request =
        DeleteRegionalInventoryRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    deleteRegionalInventory(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified `RegionalInventory` resource from the given product in your merchant
   * account. It might take up to an hour for the `RegionalInventory` to be deleted from the
   * specific product. Once you have received a successful delete response, wait for that period
   * before attempting a delete again.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionalInventoryServiceClient regionalInventoryServiceClient =
   *     RegionalInventoryServiceClient.create()) {
   *   String name = RegionalInventoryName.of("[ACCOUNT]", "[PRODUCT]", "[REGION]").toString();
   *   regionalInventoryServiceClient.deleteRegionalInventory(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the `RegionalInventory` resource to delete. Format:
   *     `accounts/{account}/products/{product}/regionalInventories/{region}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteRegionalInventory(String name) {
    DeleteRegionalInventoryRequest request =
        DeleteRegionalInventoryRequest.newBuilder().setName(name).build();
    deleteRegionalInventory(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified `RegionalInventory` resource from the given product in your merchant
   * account. It might take up to an hour for the `RegionalInventory` to be deleted from the
   * specific product. Once you have received a successful delete response, wait for that period
   * before attempting a delete again.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionalInventoryServiceClient regionalInventoryServiceClient =
   *     RegionalInventoryServiceClient.create()) {
   *   DeleteRegionalInventoryRequest request =
   *       DeleteRegionalInventoryRequest.newBuilder()
   *           .setName(RegionalInventoryName.of("[ACCOUNT]", "[PRODUCT]", "[REGION]").toString())
   *           .build();
   *   regionalInventoryServiceClient.deleteRegionalInventory(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteRegionalInventory(DeleteRegionalInventoryRequest request) {
    deleteRegionalInventoryCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified `RegionalInventory` resource from the given product in your merchant
   * account. It might take up to an hour for the `RegionalInventory` to be deleted from the
   * specific product. Once you have received a successful delete response, wait for that period
   * before attempting a delete again.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionalInventoryServiceClient regionalInventoryServiceClient =
   *     RegionalInventoryServiceClient.create()) {
   *   DeleteRegionalInventoryRequest request =
   *       DeleteRegionalInventoryRequest.newBuilder()
   *           .setName(RegionalInventoryName.of("[ACCOUNT]", "[PRODUCT]", "[REGION]").toString())
   *           .build();
   *   ApiFuture<Empty> future =
   *       regionalInventoryServiceClient.deleteRegionalInventoryCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteRegionalInventoryRequest, Empty>
      deleteRegionalInventoryCallable() {
    return stub.deleteRegionalInventoryCallable();
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

  public static class ListRegionalInventoriesPagedResponse
      extends AbstractPagedListResponse<
          ListRegionalInventoriesRequest,
          ListRegionalInventoriesResponse,
          RegionalInventory,
          ListRegionalInventoriesPage,
          ListRegionalInventoriesFixedSizeCollection> {

    public static ApiFuture<ListRegionalInventoriesPagedResponse> createAsync(
        PageContext<
                ListRegionalInventoriesRequest, ListRegionalInventoriesResponse, RegionalInventory>
            context,
        ApiFuture<ListRegionalInventoriesResponse> futureResponse) {
      ApiFuture<ListRegionalInventoriesPage> futurePage =
          ListRegionalInventoriesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListRegionalInventoriesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListRegionalInventoriesPagedResponse(ListRegionalInventoriesPage page) {
      super(page, ListRegionalInventoriesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListRegionalInventoriesPage
      extends AbstractPage<
          ListRegionalInventoriesRequest,
          ListRegionalInventoriesResponse,
          RegionalInventory,
          ListRegionalInventoriesPage> {

    private ListRegionalInventoriesPage(
        PageContext<
                ListRegionalInventoriesRequest, ListRegionalInventoriesResponse, RegionalInventory>
            context,
        ListRegionalInventoriesResponse response) {
      super(context, response);
    }

    private static ListRegionalInventoriesPage createEmptyPage() {
      return new ListRegionalInventoriesPage(null, null);
    }

    @Override
    protected ListRegionalInventoriesPage createPage(
        PageContext<
                ListRegionalInventoriesRequest, ListRegionalInventoriesResponse, RegionalInventory>
            context,
        ListRegionalInventoriesResponse response) {
      return new ListRegionalInventoriesPage(context, response);
    }

    @Override
    public ApiFuture<ListRegionalInventoriesPage> createPageAsync(
        PageContext<
                ListRegionalInventoriesRequest, ListRegionalInventoriesResponse, RegionalInventory>
            context,
        ApiFuture<ListRegionalInventoriesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListRegionalInventoriesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListRegionalInventoriesRequest,
          ListRegionalInventoriesResponse,
          RegionalInventory,
          ListRegionalInventoriesPage,
          ListRegionalInventoriesFixedSizeCollection> {

    private ListRegionalInventoriesFixedSizeCollection(
        List<ListRegionalInventoriesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListRegionalInventoriesFixedSizeCollection createEmptyCollection() {
      return new ListRegionalInventoriesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListRegionalInventoriesFixedSizeCollection createCollection(
        List<ListRegionalInventoriesPage> pages, int collectionSize) {
      return new ListRegionalInventoriesFixedSizeCollection(pages, collectionSize);
    }
  }
}
