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
import com.google.shopping.merchant.inventories.v1beta.stub.LocalInventoryServiceStub;
import com.google.shopping.merchant.inventories.v1beta.stub.LocalInventoryServiceStubSettings;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Service to manage local inventory for products
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
 * try (LocalInventoryServiceClient localInventoryServiceClient =
 *     LocalInventoryServiceClient.create()) {
 *   InsertLocalInventoryRequest request =
 *       InsertLocalInventoryRequest.newBuilder()
 *           .setParent(ProductName.of("[ACCOUNT]", "[PRODUCT]").toString())
 *           .setLocalInventory(LocalInventory.newBuilder().build())
 *           .build();
 *   LocalInventory response = localInventoryServiceClient.insertLocalInventory(request);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the LocalInventoryServiceClient object to clean up
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
 *      <td><p> ListLocalInventories</td>
 *      <td><p> Lists the `LocalInventory` resources for the given product in your merchant account. The response might contain fewer items than specified by `pageSize`. If `pageToken` was returned in previous request, it can be used to obtain additional results.
 * <p>  `LocalInventory` resources are listed per product for a given account.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listLocalInventories(ListLocalInventoriesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listLocalInventories(ProductName parent)
 *           <li><p> listLocalInventories(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listLocalInventoriesPagedCallable()
 *           <li><p> listLocalInventoriesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> InsertLocalInventory</td>
 *      <td><p> Inserts a `LocalInventory` resource to a product in your merchant account.
 * <p>  Replaces the full `LocalInventory` resource if an entry with the same [`storeCode`][google.shopping.merchant.inventories.v1beta.LocalInventory.store_code] already exists for the product.
 * <p>  It might take up to 30 minutes for the new or updated `LocalInventory` resource to appear in products.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> insertLocalInventory(InsertLocalInventoryRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> insertLocalInventoryCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteLocalInventory</td>
 *      <td><p> Deletes the specified `LocalInventory` from the given product in your merchant account. It might take a up to an hour for the `LocalInventory` to be deleted from the specific product. Once you have received a successful delete response, wait for that period before attempting a delete again.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteLocalInventory(DeleteLocalInventoryRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deleteLocalInventory(LocalInventoryName name)
 *           <li><p> deleteLocalInventory(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteLocalInventoryCallable()
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
 * <p>This class can be customized by passing in a custom instance of LocalInventoryServiceSettings
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
 * LocalInventoryServiceSettings localInventoryServiceSettings =
 *     LocalInventoryServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * LocalInventoryServiceClient localInventoryServiceClient =
 *     LocalInventoryServiceClient.create(localInventoryServiceSettings);
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
 * LocalInventoryServiceSettings localInventoryServiceSettings =
 *     LocalInventoryServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * LocalInventoryServiceClient localInventoryServiceClient =
 *     LocalInventoryServiceClient.create(localInventoryServiceSettings);
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
 * LocalInventoryServiceSettings localInventoryServiceSettings =
 *     LocalInventoryServiceSettings.newHttpJsonBuilder().build();
 * LocalInventoryServiceClient localInventoryServiceClient =
 *     LocalInventoryServiceClient.create(localInventoryServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class LocalInventoryServiceClient implements BackgroundResource {
  private final LocalInventoryServiceSettings settings;
  private final LocalInventoryServiceStub stub;

  /** Constructs an instance of LocalInventoryServiceClient with default settings. */
  public static final LocalInventoryServiceClient create() throws IOException {
    return create(LocalInventoryServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of LocalInventoryServiceClient, using the given settings. The channels
   * are created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final LocalInventoryServiceClient create(LocalInventoryServiceSettings settings)
      throws IOException {
    return new LocalInventoryServiceClient(settings);
  }

  /**
   * Constructs an instance of LocalInventoryServiceClient, using the given stub for making calls.
   * This is for advanced usage - prefer using create(LocalInventoryServiceSettings).
   */
  public static final LocalInventoryServiceClient create(LocalInventoryServiceStub stub) {
    return new LocalInventoryServiceClient(stub);
  }

  /**
   * Constructs an instance of LocalInventoryServiceClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected LocalInventoryServiceClient(LocalInventoryServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((LocalInventoryServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected LocalInventoryServiceClient(LocalInventoryServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final LocalInventoryServiceSettings getSettings() {
    return settings;
  }

  public LocalInventoryServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the `LocalInventory` resources for the given product in your merchant account. The
   * response might contain fewer items than specified by `pageSize`. If `pageToken` was returned in
   * previous request, it can be used to obtain additional results.
   *
   * <p>`LocalInventory` resources are listed per product for a given account.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LocalInventoryServiceClient localInventoryServiceClient =
   *     LocalInventoryServiceClient.create()) {
   *   ProductName parent = ProductName.of("[ACCOUNT]", "[PRODUCT]");
   *   for (LocalInventory element :
   *       localInventoryServiceClient.listLocalInventories(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The `name` of the parent product to list local inventories for. Format:
   *     `accounts/{account}/products/{product}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListLocalInventoriesPagedResponse listLocalInventories(ProductName parent) {
    ListLocalInventoriesRequest request =
        ListLocalInventoriesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listLocalInventories(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the `LocalInventory` resources for the given product in your merchant account. The
   * response might contain fewer items than specified by `pageSize`. If `pageToken` was returned in
   * previous request, it can be used to obtain additional results.
   *
   * <p>`LocalInventory` resources are listed per product for a given account.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LocalInventoryServiceClient localInventoryServiceClient =
   *     LocalInventoryServiceClient.create()) {
   *   String parent = ProductName.of("[ACCOUNT]", "[PRODUCT]").toString();
   *   for (LocalInventory element :
   *       localInventoryServiceClient.listLocalInventories(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The `name` of the parent product to list local inventories for. Format:
   *     `accounts/{account}/products/{product}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListLocalInventoriesPagedResponse listLocalInventories(String parent) {
    ListLocalInventoriesRequest request =
        ListLocalInventoriesRequest.newBuilder().setParent(parent).build();
    return listLocalInventories(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the `LocalInventory` resources for the given product in your merchant account. The
   * response might contain fewer items than specified by `pageSize`. If `pageToken` was returned in
   * previous request, it can be used to obtain additional results.
   *
   * <p>`LocalInventory` resources are listed per product for a given account.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LocalInventoryServiceClient localInventoryServiceClient =
   *     LocalInventoryServiceClient.create()) {
   *   ListLocalInventoriesRequest request =
   *       ListLocalInventoriesRequest.newBuilder()
   *           .setParent(ProductName.of("[ACCOUNT]", "[PRODUCT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (LocalInventory element :
   *       localInventoryServiceClient.listLocalInventories(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListLocalInventoriesPagedResponse listLocalInventories(
      ListLocalInventoriesRequest request) {
    return listLocalInventoriesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the `LocalInventory` resources for the given product in your merchant account. The
   * response might contain fewer items than specified by `pageSize`. If `pageToken` was returned in
   * previous request, it can be used to obtain additional results.
   *
   * <p>`LocalInventory` resources are listed per product for a given account.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LocalInventoryServiceClient localInventoryServiceClient =
   *     LocalInventoryServiceClient.create()) {
   *   ListLocalInventoriesRequest request =
   *       ListLocalInventoriesRequest.newBuilder()
   *           .setParent(ProductName.of("[ACCOUNT]", "[PRODUCT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<LocalInventory> future =
   *       localInventoryServiceClient.listLocalInventoriesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (LocalInventory element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListLocalInventoriesRequest, ListLocalInventoriesPagedResponse>
      listLocalInventoriesPagedCallable() {
    return stub.listLocalInventoriesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the `LocalInventory` resources for the given product in your merchant account. The
   * response might contain fewer items than specified by `pageSize`. If `pageToken` was returned in
   * previous request, it can be used to obtain additional results.
   *
   * <p>`LocalInventory` resources are listed per product for a given account.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LocalInventoryServiceClient localInventoryServiceClient =
   *     LocalInventoryServiceClient.create()) {
   *   ListLocalInventoriesRequest request =
   *       ListLocalInventoriesRequest.newBuilder()
   *           .setParent(ProductName.of("[ACCOUNT]", "[PRODUCT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListLocalInventoriesResponse response =
   *         localInventoryServiceClient.listLocalInventoriesCallable().call(request);
   *     for (LocalInventory element : response.getLocalInventoriesList()) {
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
  public final UnaryCallable<ListLocalInventoriesRequest, ListLocalInventoriesResponse>
      listLocalInventoriesCallable() {
    return stub.listLocalInventoriesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Inserts a `LocalInventory` resource to a product in your merchant account.
   *
   * <p>Replaces the full `LocalInventory` resource if an entry with the same
   * [`storeCode`][google.shopping.merchant.inventories.v1beta.LocalInventory.store_code] already
   * exists for the product.
   *
   * <p>It might take up to 30 minutes for the new or updated `LocalInventory` resource to appear in
   * products.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LocalInventoryServiceClient localInventoryServiceClient =
   *     LocalInventoryServiceClient.create()) {
   *   InsertLocalInventoryRequest request =
   *       InsertLocalInventoryRequest.newBuilder()
   *           .setParent(ProductName.of("[ACCOUNT]", "[PRODUCT]").toString())
   *           .setLocalInventory(LocalInventory.newBuilder().build())
   *           .build();
   *   LocalInventory response = localInventoryServiceClient.insertLocalInventory(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LocalInventory insertLocalInventory(InsertLocalInventoryRequest request) {
    return insertLocalInventoryCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Inserts a `LocalInventory` resource to a product in your merchant account.
   *
   * <p>Replaces the full `LocalInventory` resource if an entry with the same
   * [`storeCode`][google.shopping.merchant.inventories.v1beta.LocalInventory.store_code] already
   * exists for the product.
   *
   * <p>It might take up to 30 minutes for the new or updated `LocalInventory` resource to appear in
   * products.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LocalInventoryServiceClient localInventoryServiceClient =
   *     LocalInventoryServiceClient.create()) {
   *   InsertLocalInventoryRequest request =
   *       InsertLocalInventoryRequest.newBuilder()
   *           .setParent(ProductName.of("[ACCOUNT]", "[PRODUCT]").toString())
   *           .setLocalInventory(LocalInventory.newBuilder().build())
   *           .build();
   *   ApiFuture<LocalInventory> future =
   *       localInventoryServiceClient.insertLocalInventoryCallable().futureCall(request);
   *   // Do something.
   *   LocalInventory response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<InsertLocalInventoryRequest, LocalInventory>
      insertLocalInventoryCallable() {
    return stub.insertLocalInventoryCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified `LocalInventory` from the given product in your merchant account. It
   * might take a up to an hour for the `LocalInventory` to be deleted from the specific product.
   * Once you have received a successful delete response, wait for that period before attempting a
   * delete again.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LocalInventoryServiceClient localInventoryServiceClient =
   *     LocalInventoryServiceClient.create()) {
   *   LocalInventoryName name = LocalInventoryName.of("[ACCOUNT]", "[PRODUCT]", "[STORE_CODE]");
   *   localInventoryServiceClient.deleteLocalInventory(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the local inventory for the given product to delete. Format:
   *     `accounts/{account}/products/{product}/localInventories/{store_code}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteLocalInventory(LocalInventoryName name) {
    DeleteLocalInventoryRequest request =
        DeleteLocalInventoryRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    deleteLocalInventory(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified `LocalInventory` from the given product in your merchant account. It
   * might take a up to an hour for the `LocalInventory` to be deleted from the specific product.
   * Once you have received a successful delete response, wait for that period before attempting a
   * delete again.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LocalInventoryServiceClient localInventoryServiceClient =
   *     LocalInventoryServiceClient.create()) {
   *   String name = LocalInventoryName.of("[ACCOUNT]", "[PRODUCT]", "[STORE_CODE]").toString();
   *   localInventoryServiceClient.deleteLocalInventory(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the local inventory for the given product to delete. Format:
   *     `accounts/{account}/products/{product}/localInventories/{store_code}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteLocalInventory(String name) {
    DeleteLocalInventoryRequest request =
        DeleteLocalInventoryRequest.newBuilder().setName(name).build();
    deleteLocalInventory(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified `LocalInventory` from the given product in your merchant account. It
   * might take a up to an hour for the `LocalInventory` to be deleted from the specific product.
   * Once you have received a successful delete response, wait for that period before attempting a
   * delete again.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LocalInventoryServiceClient localInventoryServiceClient =
   *     LocalInventoryServiceClient.create()) {
   *   DeleteLocalInventoryRequest request =
   *       DeleteLocalInventoryRequest.newBuilder()
   *           .setName(LocalInventoryName.of("[ACCOUNT]", "[PRODUCT]", "[STORE_CODE]").toString())
   *           .build();
   *   localInventoryServiceClient.deleteLocalInventory(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteLocalInventory(DeleteLocalInventoryRequest request) {
    deleteLocalInventoryCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified `LocalInventory` from the given product in your merchant account. It
   * might take a up to an hour for the `LocalInventory` to be deleted from the specific product.
   * Once you have received a successful delete response, wait for that period before attempting a
   * delete again.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LocalInventoryServiceClient localInventoryServiceClient =
   *     LocalInventoryServiceClient.create()) {
   *   DeleteLocalInventoryRequest request =
   *       DeleteLocalInventoryRequest.newBuilder()
   *           .setName(LocalInventoryName.of("[ACCOUNT]", "[PRODUCT]", "[STORE_CODE]").toString())
   *           .build();
   *   ApiFuture<Empty> future =
   *       localInventoryServiceClient.deleteLocalInventoryCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteLocalInventoryRequest, Empty> deleteLocalInventoryCallable() {
    return stub.deleteLocalInventoryCallable();
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

  public static class ListLocalInventoriesPagedResponse
      extends AbstractPagedListResponse<
          ListLocalInventoriesRequest,
          ListLocalInventoriesResponse,
          LocalInventory,
          ListLocalInventoriesPage,
          ListLocalInventoriesFixedSizeCollection> {

    public static ApiFuture<ListLocalInventoriesPagedResponse> createAsync(
        PageContext<ListLocalInventoriesRequest, ListLocalInventoriesResponse, LocalInventory>
            context,
        ApiFuture<ListLocalInventoriesResponse> futureResponse) {
      ApiFuture<ListLocalInventoriesPage> futurePage =
          ListLocalInventoriesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListLocalInventoriesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListLocalInventoriesPagedResponse(ListLocalInventoriesPage page) {
      super(page, ListLocalInventoriesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListLocalInventoriesPage
      extends AbstractPage<
          ListLocalInventoriesRequest,
          ListLocalInventoriesResponse,
          LocalInventory,
          ListLocalInventoriesPage> {

    private ListLocalInventoriesPage(
        PageContext<ListLocalInventoriesRequest, ListLocalInventoriesResponse, LocalInventory>
            context,
        ListLocalInventoriesResponse response) {
      super(context, response);
    }

    private static ListLocalInventoriesPage createEmptyPage() {
      return new ListLocalInventoriesPage(null, null);
    }

    @Override
    protected ListLocalInventoriesPage createPage(
        PageContext<ListLocalInventoriesRequest, ListLocalInventoriesResponse, LocalInventory>
            context,
        ListLocalInventoriesResponse response) {
      return new ListLocalInventoriesPage(context, response);
    }

    @Override
    public ApiFuture<ListLocalInventoriesPage> createPageAsync(
        PageContext<ListLocalInventoriesRequest, ListLocalInventoriesResponse, LocalInventory>
            context,
        ApiFuture<ListLocalInventoriesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListLocalInventoriesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListLocalInventoriesRequest,
          ListLocalInventoriesResponse,
          LocalInventory,
          ListLocalInventoriesPage,
          ListLocalInventoriesFixedSizeCollection> {

    private ListLocalInventoriesFixedSizeCollection(
        List<ListLocalInventoriesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListLocalInventoriesFixedSizeCollection createEmptyCollection() {
      return new ListLocalInventoriesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListLocalInventoriesFixedSizeCollection createCollection(
        List<ListLocalInventoriesPage> pages, int collectionSize) {
      return new ListLocalInventoriesFixedSizeCollection(pages, collectionSize);
    }
  }
}
