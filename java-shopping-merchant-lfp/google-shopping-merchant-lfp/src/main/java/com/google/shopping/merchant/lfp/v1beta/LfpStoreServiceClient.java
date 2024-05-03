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

package com.google.shopping.merchant.lfp.v1beta;

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
import com.google.shopping.merchant.lfp.v1beta.stub.LfpStoreServiceStub;
import com.google.shopping.merchant.lfp.v1beta.stub.LfpStoreServiceStubSettings;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Service for a [LFP
 * partner](https://support.google.com/merchants/answer/7676652) to submit local stores for a
 * merchant.
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
 * try (LfpStoreServiceClient lfpStoreServiceClient = LfpStoreServiceClient.create()) {
 *   LfpStoreName name = LfpStoreName.of("[ACCOUNT]", "[TARGET_MERCHANT]", "[STORE_CODE]");
 *   LfpStore response = lfpStoreServiceClient.getLfpStore(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the LfpStoreServiceClient object to clean up resources
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
 *      <td><p> GetLfpStore</td>
 *      <td><p> Retrieves information about a store.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getLfpStore(GetLfpStoreRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getLfpStore(LfpStoreName name)
 *           <li><p> getLfpStore(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getLfpStoreCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> InsertLfpStore</td>
 *      <td><p> Inserts a store for the target merchant. If the store with the same store code already exists, it will be replaced.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> insertLfpStore(InsertLfpStoreRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> insertLfpStore(AccountName parent, LfpStore lfpStore)
 *           <li><p> insertLfpStore(String parent, LfpStore lfpStore)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> insertLfpStoreCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteLfpStore</td>
 *      <td><p> Deletes a store for a target merchant.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteLfpStore(DeleteLfpStoreRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deleteLfpStore(LfpStoreName name)
 *           <li><p> deleteLfpStore(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteLfpStoreCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListLfpStores</td>
 *      <td><p> Lists the stores of the target merchant, specified by the filter in `ListLfpStoresRequest`.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listLfpStores(ListLfpStoresRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listLfpStores(AccountName parent)
 *           <li><p> listLfpStores(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listLfpStoresPagedCallable()
 *           <li><p> listLfpStoresCallable()
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
 * <p>This class can be customized by passing in a custom instance of LfpStoreServiceSettings to
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
 * LfpStoreServiceSettings lfpStoreServiceSettings =
 *     LfpStoreServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * LfpStoreServiceClient lfpStoreServiceClient =
 *     LfpStoreServiceClient.create(lfpStoreServiceSettings);
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
 * LfpStoreServiceSettings lfpStoreServiceSettings =
 *     LfpStoreServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * LfpStoreServiceClient lfpStoreServiceClient =
 *     LfpStoreServiceClient.create(lfpStoreServiceSettings);
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
 * LfpStoreServiceSettings lfpStoreServiceSettings =
 *     LfpStoreServiceSettings.newHttpJsonBuilder().build();
 * LfpStoreServiceClient lfpStoreServiceClient =
 *     LfpStoreServiceClient.create(lfpStoreServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class LfpStoreServiceClient implements BackgroundResource {
  private final LfpStoreServiceSettings settings;
  private final LfpStoreServiceStub stub;

  /** Constructs an instance of LfpStoreServiceClient with default settings. */
  public static final LfpStoreServiceClient create() throws IOException {
    return create(LfpStoreServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of LfpStoreServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final LfpStoreServiceClient create(LfpStoreServiceSettings settings)
      throws IOException {
    return new LfpStoreServiceClient(settings);
  }

  /**
   * Constructs an instance of LfpStoreServiceClient, using the given stub for making calls. This is
   * for advanced usage - prefer using create(LfpStoreServiceSettings).
   */
  public static final LfpStoreServiceClient create(LfpStoreServiceStub stub) {
    return new LfpStoreServiceClient(stub);
  }

  /**
   * Constructs an instance of LfpStoreServiceClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected LfpStoreServiceClient(LfpStoreServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((LfpStoreServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected LfpStoreServiceClient(LfpStoreServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final LfpStoreServiceSettings getSettings() {
    return settings;
  }

  public LfpStoreServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves information about a store.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LfpStoreServiceClient lfpStoreServiceClient = LfpStoreServiceClient.create()) {
   *   LfpStoreName name = LfpStoreName.of("[ACCOUNT]", "[TARGET_MERCHANT]", "[STORE_CODE]");
   *   LfpStore response = lfpStoreServiceClient.getLfpStore(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the store to retrieve. Format:
   *     `accounts/{account}/lfpStores/{target_merchant}~{store_code}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LfpStore getLfpStore(LfpStoreName name) {
    GetLfpStoreRequest request =
        GetLfpStoreRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getLfpStore(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves information about a store.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LfpStoreServiceClient lfpStoreServiceClient = LfpStoreServiceClient.create()) {
   *   String name = LfpStoreName.of("[ACCOUNT]", "[TARGET_MERCHANT]", "[STORE_CODE]").toString();
   *   LfpStore response = lfpStoreServiceClient.getLfpStore(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the store to retrieve. Format:
   *     `accounts/{account}/lfpStores/{target_merchant}~{store_code}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LfpStore getLfpStore(String name) {
    GetLfpStoreRequest request = GetLfpStoreRequest.newBuilder().setName(name).build();
    return getLfpStore(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves information about a store.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LfpStoreServiceClient lfpStoreServiceClient = LfpStoreServiceClient.create()) {
   *   GetLfpStoreRequest request =
   *       GetLfpStoreRequest.newBuilder()
   *           .setName(LfpStoreName.of("[ACCOUNT]", "[TARGET_MERCHANT]", "[STORE_CODE]").toString())
   *           .build();
   *   LfpStore response = lfpStoreServiceClient.getLfpStore(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LfpStore getLfpStore(GetLfpStoreRequest request) {
    return getLfpStoreCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves information about a store.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LfpStoreServiceClient lfpStoreServiceClient = LfpStoreServiceClient.create()) {
   *   GetLfpStoreRequest request =
   *       GetLfpStoreRequest.newBuilder()
   *           .setName(LfpStoreName.of("[ACCOUNT]", "[TARGET_MERCHANT]", "[STORE_CODE]").toString())
   *           .build();
   *   ApiFuture<LfpStore> future = lfpStoreServiceClient.getLfpStoreCallable().futureCall(request);
   *   // Do something.
   *   LfpStore response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetLfpStoreRequest, LfpStore> getLfpStoreCallable() {
    return stub.getLfpStoreCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Inserts a store for the target merchant. If the store with the same store code already exists,
   * it will be replaced.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LfpStoreServiceClient lfpStoreServiceClient = LfpStoreServiceClient.create()) {
   *   AccountName parent = AccountName.of("[ACCOUNT]");
   *   LfpStore lfpStore = LfpStore.newBuilder().build();
   *   LfpStore response = lfpStoreServiceClient.insertLfpStore(parent, lfpStore);
   * }
   * }</pre>
   *
   * @param parent Required. The LFP provider account Format: `accounts/{account}`
   * @param lfpStore Required. The store to insert.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LfpStore insertLfpStore(AccountName parent, LfpStore lfpStore) {
    InsertLfpStoreRequest request =
        InsertLfpStoreRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setLfpStore(lfpStore)
            .build();
    return insertLfpStore(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Inserts a store for the target merchant. If the store with the same store code already exists,
   * it will be replaced.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LfpStoreServiceClient lfpStoreServiceClient = LfpStoreServiceClient.create()) {
   *   String parent = AccountName.of("[ACCOUNT]").toString();
   *   LfpStore lfpStore = LfpStore.newBuilder().build();
   *   LfpStore response = lfpStoreServiceClient.insertLfpStore(parent, lfpStore);
   * }
   * }</pre>
   *
   * @param parent Required. The LFP provider account Format: `accounts/{account}`
   * @param lfpStore Required. The store to insert.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LfpStore insertLfpStore(String parent, LfpStore lfpStore) {
    InsertLfpStoreRequest request =
        InsertLfpStoreRequest.newBuilder().setParent(parent).setLfpStore(lfpStore).build();
    return insertLfpStore(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Inserts a store for the target merchant. If the store with the same store code already exists,
   * it will be replaced.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LfpStoreServiceClient lfpStoreServiceClient = LfpStoreServiceClient.create()) {
   *   InsertLfpStoreRequest request =
   *       InsertLfpStoreRequest.newBuilder()
   *           .setParent(AccountName.of("[ACCOUNT]").toString())
   *           .setLfpStore(LfpStore.newBuilder().build())
   *           .build();
   *   LfpStore response = lfpStoreServiceClient.insertLfpStore(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LfpStore insertLfpStore(InsertLfpStoreRequest request) {
    return insertLfpStoreCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Inserts a store for the target merchant. If the store with the same store code already exists,
   * it will be replaced.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LfpStoreServiceClient lfpStoreServiceClient = LfpStoreServiceClient.create()) {
   *   InsertLfpStoreRequest request =
   *       InsertLfpStoreRequest.newBuilder()
   *           .setParent(AccountName.of("[ACCOUNT]").toString())
   *           .setLfpStore(LfpStore.newBuilder().build())
   *           .build();
   *   ApiFuture<LfpStore> future =
   *       lfpStoreServiceClient.insertLfpStoreCallable().futureCall(request);
   *   // Do something.
   *   LfpStore response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<InsertLfpStoreRequest, LfpStore> insertLfpStoreCallable() {
    return stub.insertLfpStoreCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a store for a target merchant.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LfpStoreServiceClient lfpStoreServiceClient = LfpStoreServiceClient.create()) {
   *   LfpStoreName name = LfpStoreName.of("[ACCOUNT]", "[TARGET_MERCHANT]", "[STORE_CODE]");
   *   lfpStoreServiceClient.deleteLfpStore(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the store to delete for the target merchant account. Format:
   *     `accounts/{account}/lfpStores/{target_merchant}~{store_code}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteLfpStore(LfpStoreName name) {
    DeleteLfpStoreRequest request =
        DeleteLfpStoreRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    deleteLfpStore(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a store for a target merchant.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LfpStoreServiceClient lfpStoreServiceClient = LfpStoreServiceClient.create()) {
   *   String name = LfpStoreName.of("[ACCOUNT]", "[TARGET_MERCHANT]", "[STORE_CODE]").toString();
   *   lfpStoreServiceClient.deleteLfpStore(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the store to delete for the target merchant account. Format:
   *     `accounts/{account}/lfpStores/{target_merchant}~{store_code}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteLfpStore(String name) {
    DeleteLfpStoreRequest request = DeleteLfpStoreRequest.newBuilder().setName(name).build();
    deleteLfpStore(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a store for a target merchant.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LfpStoreServiceClient lfpStoreServiceClient = LfpStoreServiceClient.create()) {
   *   DeleteLfpStoreRequest request =
   *       DeleteLfpStoreRequest.newBuilder()
   *           .setName(LfpStoreName.of("[ACCOUNT]", "[TARGET_MERCHANT]", "[STORE_CODE]").toString())
   *           .build();
   *   lfpStoreServiceClient.deleteLfpStore(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteLfpStore(DeleteLfpStoreRequest request) {
    deleteLfpStoreCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a store for a target merchant.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LfpStoreServiceClient lfpStoreServiceClient = LfpStoreServiceClient.create()) {
   *   DeleteLfpStoreRequest request =
   *       DeleteLfpStoreRequest.newBuilder()
   *           .setName(LfpStoreName.of("[ACCOUNT]", "[TARGET_MERCHANT]", "[STORE_CODE]").toString())
   *           .build();
   *   ApiFuture<Empty> future = lfpStoreServiceClient.deleteLfpStoreCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteLfpStoreRequest, Empty> deleteLfpStoreCallable() {
    return stub.deleteLfpStoreCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the stores of the target merchant, specified by the filter in `ListLfpStoresRequest`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LfpStoreServiceClient lfpStoreServiceClient = LfpStoreServiceClient.create()) {
   *   AccountName parent = AccountName.of("[ACCOUNT]");
   *   for (LfpStore element : lfpStoreServiceClient.listLfpStores(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The LFP partner. Format: `accounts/{account}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListLfpStoresPagedResponse listLfpStores(AccountName parent) {
    ListLfpStoresRequest request =
        ListLfpStoresRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listLfpStores(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the stores of the target merchant, specified by the filter in `ListLfpStoresRequest`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LfpStoreServiceClient lfpStoreServiceClient = LfpStoreServiceClient.create()) {
   *   String parent = AccountName.of("[ACCOUNT]").toString();
   *   for (LfpStore element : lfpStoreServiceClient.listLfpStores(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The LFP partner. Format: `accounts/{account}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListLfpStoresPagedResponse listLfpStores(String parent) {
    ListLfpStoresRequest request = ListLfpStoresRequest.newBuilder().setParent(parent).build();
    return listLfpStores(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the stores of the target merchant, specified by the filter in `ListLfpStoresRequest`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LfpStoreServiceClient lfpStoreServiceClient = LfpStoreServiceClient.create()) {
   *   ListLfpStoresRequest request =
   *       ListLfpStoresRequest.newBuilder()
   *           .setParent(AccountName.of("[ACCOUNT]").toString())
   *           .setTargetAccount(-475823745)
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (LfpStore element : lfpStoreServiceClient.listLfpStores(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListLfpStoresPagedResponse listLfpStores(ListLfpStoresRequest request) {
    return listLfpStoresPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the stores of the target merchant, specified by the filter in `ListLfpStoresRequest`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LfpStoreServiceClient lfpStoreServiceClient = LfpStoreServiceClient.create()) {
   *   ListLfpStoresRequest request =
   *       ListLfpStoresRequest.newBuilder()
   *           .setParent(AccountName.of("[ACCOUNT]").toString())
   *           .setTargetAccount(-475823745)
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<LfpStore> future =
   *       lfpStoreServiceClient.listLfpStoresPagedCallable().futureCall(request);
   *   // Do something.
   *   for (LfpStore element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListLfpStoresRequest, ListLfpStoresPagedResponse>
      listLfpStoresPagedCallable() {
    return stub.listLfpStoresPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the stores of the target merchant, specified by the filter in `ListLfpStoresRequest`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LfpStoreServiceClient lfpStoreServiceClient = LfpStoreServiceClient.create()) {
   *   ListLfpStoresRequest request =
   *       ListLfpStoresRequest.newBuilder()
   *           .setParent(AccountName.of("[ACCOUNT]").toString())
   *           .setTargetAccount(-475823745)
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListLfpStoresResponse response =
   *         lfpStoreServiceClient.listLfpStoresCallable().call(request);
   *     for (LfpStore element : response.getLfpStoresList()) {
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
  public final UnaryCallable<ListLfpStoresRequest, ListLfpStoresResponse> listLfpStoresCallable() {
    return stub.listLfpStoresCallable();
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

  public static class ListLfpStoresPagedResponse
      extends AbstractPagedListResponse<
          ListLfpStoresRequest,
          ListLfpStoresResponse,
          LfpStore,
          ListLfpStoresPage,
          ListLfpStoresFixedSizeCollection> {

    public static ApiFuture<ListLfpStoresPagedResponse> createAsync(
        PageContext<ListLfpStoresRequest, ListLfpStoresResponse, LfpStore> context,
        ApiFuture<ListLfpStoresResponse> futureResponse) {
      ApiFuture<ListLfpStoresPage> futurePage =
          ListLfpStoresPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListLfpStoresPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListLfpStoresPagedResponse(ListLfpStoresPage page) {
      super(page, ListLfpStoresFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListLfpStoresPage
      extends AbstractPage<
          ListLfpStoresRequest, ListLfpStoresResponse, LfpStore, ListLfpStoresPage> {

    private ListLfpStoresPage(
        PageContext<ListLfpStoresRequest, ListLfpStoresResponse, LfpStore> context,
        ListLfpStoresResponse response) {
      super(context, response);
    }

    private static ListLfpStoresPage createEmptyPage() {
      return new ListLfpStoresPage(null, null);
    }

    @Override
    protected ListLfpStoresPage createPage(
        PageContext<ListLfpStoresRequest, ListLfpStoresResponse, LfpStore> context,
        ListLfpStoresResponse response) {
      return new ListLfpStoresPage(context, response);
    }

    @Override
    public ApiFuture<ListLfpStoresPage> createPageAsync(
        PageContext<ListLfpStoresRequest, ListLfpStoresResponse, LfpStore> context,
        ApiFuture<ListLfpStoresResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListLfpStoresFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListLfpStoresRequest,
          ListLfpStoresResponse,
          LfpStore,
          ListLfpStoresPage,
          ListLfpStoresFixedSizeCollection> {

    private ListLfpStoresFixedSizeCollection(List<ListLfpStoresPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListLfpStoresFixedSizeCollection createEmptyCollection() {
      return new ListLfpStoresFixedSizeCollection(null, 0);
    }

    @Override
    protected ListLfpStoresFixedSizeCollection createCollection(
        List<ListLfpStoresPage> pages, int collectionSize) {
      return new ListLfpStoresFixedSizeCollection(pages, collectionSize);
    }
  }
}
