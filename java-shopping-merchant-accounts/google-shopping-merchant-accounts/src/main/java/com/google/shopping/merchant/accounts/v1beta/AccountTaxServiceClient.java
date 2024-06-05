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

package com.google.shopping.merchant.accounts.v1beta;

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
import com.google.protobuf.FieldMask;
import com.google.shopping.merchant.accounts.v1beta.stub.AccountTaxServiceStub;
import com.google.shopping.merchant.accounts.v1beta.stub.AccountTaxServiceStubSettings;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Manages account level tax setting data.
 *
 * <p>This API defines the following resource model:
 *
 * <p>- [AccountTax][google.shopping.merchant.accounts.v1main.AccountTax]
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
 * try (AccountTaxServiceClient accountTaxServiceClient = AccountTaxServiceClient.create()) {
 *   AccountTaxName name = AccountTaxName.of("[ACCOUNT]", "[TAX]");
 *   AccountTax response = accountTaxServiceClient.getAccountTax(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the AccountTaxServiceClient object to clean up resources
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
 *      <td><p> GetAccountTax</td>
 *      <td><p> Returns the tax rules that match the conditions of GetAccountTaxRequest</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getAccountTax(GetAccountTaxRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getAccountTax(AccountTaxName name)
 *           <li><p> getAccountTax(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getAccountTaxCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListAccountTax</td>
 *      <td><p> Lists the tax settings of the sub-accounts only in your Merchant Center account. This method can only be called on a multi-client account, otherwise it'll return an error.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listAccountTax(ListAccountTaxRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listAccountTax(AccountName parent)
 *           <li><p> listAccountTax(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listAccountTaxPagedCallable()
 *           <li><p> listAccountTaxCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateAccountTax</td>
 *      <td><p> Updates the tax settings of the account.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateAccountTax(UpdateAccountTaxRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateAccountTax(AccountTax accountTax)
 *           <li><p> updateAccountTax(AccountTax accountTax, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateAccountTaxCallable()
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
 * <p>This class can be customized by passing in a custom instance of AccountTaxServiceSettings to
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
 * AccountTaxServiceSettings accountTaxServiceSettings =
 *     AccountTaxServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * AccountTaxServiceClient accountTaxServiceClient =
 *     AccountTaxServiceClient.create(accountTaxServiceSettings);
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
 * AccountTaxServiceSettings accountTaxServiceSettings =
 *     AccountTaxServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * AccountTaxServiceClient accountTaxServiceClient =
 *     AccountTaxServiceClient.create(accountTaxServiceSettings);
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
 * AccountTaxServiceSettings accountTaxServiceSettings =
 *     AccountTaxServiceSettings.newHttpJsonBuilder().build();
 * AccountTaxServiceClient accountTaxServiceClient =
 *     AccountTaxServiceClient.create(accountTaxServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class AccountTaxServiceClient implements BackgroundResource {
  private final AccountTaxServiceSettings settings;
  private final AccountTaxServiceStub stub;

  /** Constructs an instance of AccountTaxServiceClient with default settings. */
  public static final AccountTaxServiceClient create() throws IOException {
    return create(AccountTaxServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of AccountTaxServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final AccountTaxServiceClient create(AccountTaxServiceSettings settings)
      throws IOException {
    return new AccountTaxServiceClient(settings);
  }

  /**
   * Constructs an instance of AccountTaxServiceClient, using the given stub for making calls. This
   * is for advanced usage - prefer using create(AccountTaxServiceSettings).
   */
  public static final AccountTaxServiceClient create(AccountTaxServiceStub stub) {
    return new AccountTaxServiceClient(stub);
  }

  /**
   * Constructs an instance of AccountTaxServiceClient, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected AccountTaxServiceClient(AccountTaxServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((AccountTaxServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected AccountTaxServiceClient(AccountTaxServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final AccountTaxServiceSettings getSettings() {
    return settings;
  }

  public AccountTaxServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the tax rules that match the conditions of GetAccountTaxRequest
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AccountTaxServiceClient accountTaxServiceClient = AccountTaxServiceClient.create()) {
   *   AccountTaxName name = AccountTaxName.of("[ACCOUNT]", "[TAX]");
   *   AccountTax response = accountTaxServiceClient.getAccountTax(name);
   * }
   * }</pre>
   *
   * @param name Required. The name from which tax settings will be retrieved
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AccountTax getAccountTax(AccountTaxName name) {
    GetAccountTaxRequest request =
        GetAccountTaxRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getAccountTax(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the tax rules that match the conditions of GetAccountTaxRequest
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AccountTaxServiceClient accountTaxServiceClient = AccountTaxServiceClient.create()) {
   *   String name = AccountTaxName.of("[ACCOUNT]", "[TAX]").toString();
   *   AccountTax response = accountTaxServiceClient.getAccountTax(name);
   * }
   * }</pre>
   *
   * @param name Required. The name from which tax settings will be retrieved
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AccountTax getAccountTax(String name) {
    GetAccountTaxRequest request = GetAccountTaxRequest.newBuilder().setName(name).build();
    return getAccountTax(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the tax rules that match the conditions of GetAccountTaxRequest
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AccountTaxServiceClient accountTaxServiceClient = AccountTaxServiceClient.create()) {
   *   GetAccountTaxRequest request =
   *       GetAccountTaxRequest.newBuilder()
   *           .setName(AccountTaxName.of("[ACCOUNT]", "[TAX]").toString())
   *           .build();
   *   AccountTax response = accountTaxServiceClient.getAccountTax(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AccountTax getAccountTax(GetAccountTaxRequest request) {
    return getAccountTaxCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the tax rules that match the conditions of GetAccountTaxRequest
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AccountTaxServiceClient accountTaxServiceClient = AccountTaxServiceClient.create()) {
   *   GetAccountTaxRequest request =
   *       GetAccountTaxRequest.newBuilder()
   *           .setName(AccountTaxName.of("[ACCOUNT]", "[TAX]").toString())
   *           .build();
   *   ApiFuture<AccountTax> future =
   *       accountTaxServiceClient.getAccountTaxCallable().futureCall(request);
   *   // Do something.
   *   AccountTax response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetAccountTaxRequest, AccountTax> getAccountTaxCallable() {
    return stub.getAccountTaxCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the tax settings of the sub-accounts only in your Merchant Center account. This method
   * can only be called on a multi-client account, otherwise it'll return an error.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AccountTaxServiceClient accountTaxServiceClient = AccountTaxServiceClient.create()) {
   *   AccountName parent = AccountName.of("[ACCOUNT]");
   *   for (AccountTax element : accountTaxServiceClient.listAccountTax(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of account tax. Format:
   *     accounts/{account}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAccountTaxPagedResponse listAccountTax(AccountName parent) {
    ListAccountTaxRequest request =
        ListAccountTaxRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listAccountTax(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the tax settings of the sub-accounts only in your Merchant Center account. This method
   * can only be called on a multi-client account, otherwise it'll return an error.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AccountTaxServiceClient accountTaxServiceClient = AccountTaxServiceClient.create()) {
   *   String parent = AccountName.of("[ACCOUNT]").toString();
   *   for (AccountTax element : accountTaxServiceClient.listAccountTax(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of account tax. Format:
   *     accounts/{account}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAccountTaxPagedResponse listAccountTax(String parent) {
    ListAccountTaxRequest request = ListAccountTaxRequest.newBuilder().setParent(parent).build();
    return listAccountTax(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the tax settings of the sub-accounts only in your Merchant Center account. This method
   * can only be called on a multi-client account, otherwise it'll return an error.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AccountTaxServiceClient accountTaxServiceClient = AccountTaxServiceClient.create()) {
   *   ListAccountTaxRequest request =
   *       ListAccountTaxRequest.newBuilder()
   *           .setParent(AccountName.of("[ACCOUNT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (AccountTax element : accountTaxServiceClient.listAccountTax(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAccountTaxPagedResponse listAccountTax(ListAccountTaxRequest request) {
    return listAccountTaxPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the tax settings of the sub-accounts only in your Merchant Center account. This method
   * can only be called on a multi-client account, otherwise it'll return an error.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AccountTaxServiceClient accountTaxServiceClient = AccountTaxServiceClient.create()) {
   *   ListAccountTaxRequest request =
   *       ListAccountTaxRequest.newBuilder()
   *           .setParent(AccountName.of("[ACCOUNT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<AccountTax> future =
   *       accountTaxServiceClient.listAccountTaxPagedCallable().futureCall(request);
   *   // Do something.
   *   for (AccountTax element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListAccountTaxRequest, ListAccountTaxPagedResponse>
      listAccountTaxPagedCallable() {
    return stub.listAccountTaxPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the tax settings of the sub-accounts only in your Merchant Center account. This method
   * can only be called on a multi-client account, otherwise it'll return an error.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AccountTaxServiceClient accountTaxServiceClient = AccountTaxServiceClient.create()) {
   *   ListAccountTaxRequest request =
   *       ListAccountTaxRequest.newBuilder()
   *           .setParent(AccountName.of("[ACCOUNT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListAccountTaxResponse response =
   *         accountTaxServiceClient.listAccountTaxCallable().call(request);
   *     for (AccountTax element : response.getAccountTaxesList()) {
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
  public final UnaryCallable<ListAccountTaxRequest, ListAccountTaxResponse>
      listAccountTaxCallable() {
    return stub.listAccountTaxCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the tax settings of the account.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AccountTaxServiceClient accountTaxServiceClient = AccountTaxServiceClient.create()) {
   *   AccountTax accountTax = AccountTax.newBuilder().build();
   *   AccountTax response = accountTaxServiceClient.updateAccountTax(accountTax);
   * }
   * }</pre>
   *
   * @param accountTax Required. The tax setting that will be updated
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AccountTax updateAccountTax(AccountTax accountTax) {
    UpdateAccountTaxRequest request =
        UpdateAccountTaxRequest.newBuilder().setAccountTax(accountTax).build();
    return updateAccountTax(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the tax settings of the account.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AccountTaxServiceClient accountTaxServiceClient = AccountTaxServiceClient.create()) {
   *   AccountTax accountTax = AccountTax.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   AccountTax response = accountTaxServiceClient.updateAccountTax(accountTax, updateMask);
   * }
   * }</pre>
   *
   * @param accountTax Required. The tax setting that will be updated
   * @param updateMask The list of fields to be updated
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AccountTax updateAccountTax(AccountTax accountTax, FieldMask updateMask) {
    UpdateAccountTaxRequest request =
        UpdateAccountTaxRequest.newBuilder()
            .setAccountTax(accountTax)
            .setUpdateMask(updateMask)
            .build();
    return updateAccountTax(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the tax settings of the account.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AccountTaxServiceClient accountTaxServiceClient = AccountTaxServiceClient.create()) {
   *   UpdateAccountTaxRequest request =
   *       UpdateAccountTaxRequest.newBuilder()
   *           .setAccountTax(AccountTax.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   AccountTax response = accountTaxServiceClient.updateAccountTax(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AccountTax updateAccountTax(UpdateAccountTaxRequest request) {
    return updateAccountTaxCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the tax settings of the account.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AccountTaxServiceClient accountTaxServiceClient = AccountTaxServiceClient.create()) {
   *   UpdateAccountTaxRequest request =
   *       UpdateAccountTaxRequest.newBuilder()
   *           .setAccountTax(AccountTax.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<AccountTax> future =
   *       accountTaxServiceClient.updateAccountTaxCallable().futureCall(request);
   *   // Do something.
   *   AccountTax response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateAccountTaxRequest, AccountTax> updateAccountTaxCallable() {
    return stub.updateAccountTaxCallable();
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

  public static class ListAccountTaxPagedResponse
      extends AbstractPagedListResponse<
          ListAccountTaxRequest,
          ListAccountTaxResponse,
          AccountTax,
          ListAccountTaxPage,
          ListAccountTaxFixedSizeCollection> {

    public static ApiFuture<ListAccountTaxPagedResponse> createAsync(
        PageContext<ListAccountTaxRequest, ListAccountTaxResponse, AccountTax> context,
        ApiFuture<ListAccountTaxResponse> futureResponse) {
      ApiFuture<ListAccountTaxPage> futurePage =
          ListAccountTaxPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListAccountTaxPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListAccountTaxPagedResponse(ListAccountTaxPage page) {
      super(page, ListAccountTaxFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListAccountTaxPage
      extends AbstractPage<
          ListAccountTaxRequest, ListAccountTaxResponse, AccountTax, ListAccountTaxPage> {

    private ListAccountTaxPage(
        PageContext<ListAccountTaxRequest, ListAccountTaxResponse, AccountTax> context,
        ListAccountTaxResponse response) {
      super(context, response);
    }

    private static ListAccountTaxPage createEmptyPage() {
      return new ListAccountTaxPage(null, null);
    }

    @Override
    protected ListAccountTaxPage createPage(
        PageContext<ListAccountTaxRequest, ListAccountTaxResponse, AccountTax> context,
        ListAccountTaxResponse response) {
      return new ListAccountTaxPage(context, response);
    }

    @Override
    public ApiFuture<ListAccountTaxPage> createPageAsync(
        PageContext<ListAccountTaxRequest, ListAccountTaxResponse, AccountTax> context,
        ApiFuture<ListAccountTaxResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListAccountTaxFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListAccountTaxRequest,
          ListAccountTaxResponse,
          AccountTax,
          ListAccountTaxPage,
          ListAccountTaxFixedSizeCollection> {

    private ListAccountTaxFixedSizeCollection(List<ListAccountTaxPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListAccountTaxFixedSizeCollection createEmptyCollection() {
      return new ListAccountTaxFixedSizeCollection(null, 0);
    }

    @Override
    protected ListAccountTaxFixedSizeCollection createCollection(
        List<ListAccountTaxPage> pages, int collectionSize) {
      return new ListAccountTaxFixedSizeCollection(pages, collectionSize);
    }
  }
}
