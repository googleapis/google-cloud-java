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
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import com.google.shopping.merchant.accounts.v1beta.stub.AccountsServiceStub;
import com.google.shopping.merchant.accounts.v1beta.stub.AccountsServiceStubSettings;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Service to support Accounts API.
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
 * try (AccountsServiceClient accountsServiceClient = AccountsServiceClient.create()) {
 *   AccountName name = AccountName.of("[ACCOUNT]");
 *   Account response = accountsServiceClient.getAccount(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the AccountsServiceClient object to clean up resources
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
 *      <td><p> GetAccount</td>
 *      <td><p> Retrieves an account from your Merchant Center account. After inserting, updating, or deleting an account, it may take several minutes before changes take effect.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getAccount(GetAccountRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getAccount(AccountName name)
 *           <li><p> getAccount(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getAccountCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateAndConfigureAccount</td>
 *      <td><p> Creates a standalone Merchant Center account with additional configuration. Adds the user that makes the request as an admin for the new account.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createAndConfigureAccount(CreateAndConfigureAccountRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createAndConfigureAccountCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteAccount</td>
 *      <td><p> Deletes the specified account regardless of its type: standalone, MCA or sub-account. Deleting an MCA leads to the deletion of all of its sub-accounts. Executing this method requires admin access.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteAccount(DeleteAccountRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deleteAccount(AccountName name)
 *           <li><p> deleteAccount(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteAccountCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateAccount</td>
 *      <td><p> Updates an account regardless of its type: standalone, MCA or sub-account. Executing this method requires admin access.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateAccount(UpdateAccountRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateAccount(Account account, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateAccountCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListAccounts</td>
 *      <td><p> Lists accounts accessible to the calling user and matching the constraints of the request such as page size or filters. This is not just listing the sub-accounts of an MCA, but all accounts the calling user has access to including other MCAs, linked accounts, standalone accounts and so on.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listAccounts(ListAccountsRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listAccountsPagedCallable()
 *           <li><p> listAccountsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListSubAccounts</td>
 *      <td><p> List all sub-accounts for a given multi client account. This is a convenience wrapper for the more powerful `ListAccounts` method. This method will produce the same results as calling `ListsAccounts` with the following filter: `relationship(providerId={parent} AND service(type="ACCOUNT_AGGREGATION"))`</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listSubAccounts(ListSubAccountsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listSubAccounts(AccountName provider)
 *           <li><p> listSubAccounts(String provider)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listSubAccountsPagedCallable()
 *           <li><p> listSubAccountsCallable()
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
 * <p>This class can be customized by passing in a custom instance of AccountsServiceSettings to
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
 * AccountsServiceSettings accountsServiceSettings =
 *     AccountsServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * AccountsServiceClient accountsServiceClient =
 *     AccountsServiceClient.create(accountsServiceSettings);
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
 * AccountsServiceSettings accountsServiceSettings =
 *     AccountsServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * AccountsServiceClient accountsServiceClient =
 *     AccountsServiceClient.create(accountsServiceSettings);
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
 * AccountsServiceSettings accountsServiceSettings =
 *     AccountsServiceSettings.newHttpJsonBuilder().build();
 * AccountsServiceClient accountsServiceClient =
 *     AccountsServiceClient.create(accountsServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class AccountsServiceClient implements BackgroundResource {
  private final AccountsServiceSettings settings;
  private final AccountsServiceStub stub;

  /** Constructs an instance of AccountsServiceClient with default settings. */
  public static final AccountsServiceClient create() throws IOException {
    return create(AccountsServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of AccountsServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final AccountsServiceClient create(AccountsServiceSettings settings)
      throws IOException {
    return new AccountsServiceClient(settings);
  }

  /**
   * Constructs an instance of AccountsServiceClient, using the given stub for making calls. This is
   * for advanced usage - prefer using create(AccountsServiceSettings).
   */
  public static final AccountsServiceClient create(AccountsServiceStub stub) {
    return new AccountsServiceClient(stub);
  }

  /**
   * Constructs an instance of AccountsServiceClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected AccountsServiceClient(AccountsServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((AccountsServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected AccountsServiceClient(AccountsServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final AccountsServiceSettings getSettings() {
    return settings;
  }

  public AccountsServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves an account from your Merchant Center account. After inserting, updating, or deleting
   * an account, it may take several minutes before changes take effect.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AccountsServiceClient accountsServiceClient = AccountsServiceClient.create()) {
   *   AccountName name = AccountName.of("[ACCOUNT]");
   *   Account response = accountsServiceClient.getAccount(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the account to retrieve. Format: `accounts/{account}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Account getAccount(AccountName name) {
    GetAccountRequest request =
        GetAccountRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getAccount(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves an account from your Merchant Center account. After inserting, updating, or deleting
   * an account, it may take several minutes before changes take effect.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AccountsServiceClient accountsServiceClient = AccountsServiceClient.create()) {
   *   String name = AccountName.of("[ACCOUNT]").toString();
   *   Account response = accountsServiceClient.getAccount(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the account to retrieve. Format: `accounts/{account}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Account getAccount(String name) {
    GetAccountRequest request = GetAccountRequest.newBuilder().setName(name).build();
    return getAccount(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves an account from your Merchant Center account. After inserting, updating, or deleting
   * an account, it may take several minutes before changes take effect.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AccountsServiceClient accountsServiceClient = AccountsServiceClient.create()) {
   *   GetAccountRequest request =
   *       GetAccountRequest.newBuilder().setName(AccountName.of("[ACCOUNT]").toString()).build();
   *   Account response = accountsServiceClient.getAccount(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Account getAccount(GetAccountRequest request) {
    return getAccountCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves an account from your Merchant Center account. After inserting, updating, or deleting
   * an account, it may take several minutes before changes take effect.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AccountsServiceClient accountsServiceClient = AccountsServiceClient.create()) {
   *   GetAccountRequest request =
   *       GetAccountRequest.newBuilder().setName(AccountName.of("[ACCOUNT]").toString()).build();
   *   ApiFuture<Account> future = accountsServiceClient.getAccountCallable().futureCall(request);
   *   // Do something.
   *   Account response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetAccountRequest, Account> getAccountCallable() {
    return stub.getAccountCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a standalone Merchant Center account with additional configuration. Adds the user that
   * makes the request as an admin for the new account.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AccountsServiceClient accountsServiceClient = AccountsServiceClient.create()) {
   *   CreateAndConfigureAccountRequest request =
   *       CreateAndConfigureAccountRequest.newBuilder()
   *           .setAccount(Account.newBuilder().build())
   *           .addAllUsers(new ArrayList<CreateUserRequest>())
   *           .setAcceptTermsOfService(
   *               CreateAndConfigureAccountRequest.AcceptTermsOfService.newBuilder().build())
   *           .addAllService(new ArrayList<CreateAndConfigureAccountRequest.AddAccountService>())
   *           .build();
   *   Account response = accountsServiceClient.createAndConfigureAccount(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Account createAndConfigureAccount(CreateAndConfigureAccountRequest request) {
    return createAndConfigureAccountCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a standalone Merchant Center account with additional configuration. Adds the user that
   * makes the request as an admin for the new account.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AccountsServiceClient accountsServiceClient = AccountsServiceClient.create()) {
   *   CreateAndConfigureAccountRequest request =
   *       CreateAndConfigureAccountRequest.newBuilder()
   *           .setAccount(Account.newBuilder().build())
   *           .addAllUsers(new ArrayList<CreateUserRequest>())
   *           .setAcceptTermsOfService(
   *               CreateAndConfigureAccountRequest.AcceptTermsOfService.newBuilder().build())
   *           .addAllService(new ArrayList<CreateAndConfigureAccountRequest.AddAccountService>())
   *           .build();
   *   ApiFuture<Account> future =
   *       accountsServiceClient.createAndConfigureAccountCallable().futureCall(request);
   *   // Do something.
   *   Account response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateAndConfigureAccountRequest, Account>
      createAndConfigureAccountCallable() {
    return stub.createAndConfigureAccountCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified account regardless of its type: standalone, MCA or sub-account. Deleting
   * an MCA leads to the deletion of all of its sub-accounts. Executing this method requires admin
   * access.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AccountsServiceClient accountsServiceClient = AccountsServiceClient.create()) {
   *   AccountName name = AccountName.of("[ACCOUNT]");
   *   accountsServiceClient.deleteAccount(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the account to delete. Format: `accounts/{account}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteAccount(AccountName name) {
    DeleteAccountRequest request =
        DeleteAccountRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    deleteAccount(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified account regardless of its type: standalone, MCA or sub-account. Deleting
   * an MCA leads to the deletion of all of its sub-accounts. Executing this method requires admin
   * access.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AccountsServiceClient accountsServiceClient = AccountsServiceClient.create()) {
   *   String name = AccountName.of("[ACCOUNT]").toString();
   *   accountsServiceClient.deleteAccount(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the account to delete. Format: `accounts/{account}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteAccount(String name) {
    DeleteAccountRequest request = DeleteAccountRequest.newBuilder().setName(name).build();
    deleteAccount(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified account regardless of its type: standalone, MCA or sub-account. Deleting
   * an MCA leads to the deletion of all of its sub-accounts. Executing this method requires admin
   * access.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AccountsServiceClient accountsServiceClient = AccountsServiceClient.create()) {
   *   DeleteAccountRequest request =
   *       DeleteAccountRequest.newBuilder().setName(AccountName.of("[ACCOUNT]").toString()).build();
   *   accountsServiceClient.deleteAccount(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteAccount(DeleteAccountRequest request) {
    deleteAccountCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified account regardless of its type: standalone, MCA or sub-account. Deleting
   * an MCA leads to the deletion of all of its sub-accounts. Executing this method requires admin
   * access.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AccountsServiceClient accountsServiceClient = AccountsServiceClient.create()) {
   *   DeleteAccountRequest request =
   *       DeleteAccountRequest.newBuilder().setName(AccountName.of("[ACCOUNT]").toString()).build();
   *   ApiFuture<Empty> future = accountsServiceClient.deleteAccountCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteAccountRequest, Empty> deleteAccountCallable() {
    return stub.deleteAccountCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an account regardless of its type: standalone, MCA or sub-account. Executing this
   * method requires admin access.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AccountsServiceClient accountsServiceClient = AccountsServiceClient.create()) {
   *   Account account = Account.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Account response = accountsServiceClient.updateAccount(account, updateMask);
   * }
   * }</pre>
   *
   * @param account Required. The new version of the account.
   * @param updateMask Required. List of fields being updated.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Account updateAccount(Account account, FieldMask updateMask) {
    UpdateAccountRequest request =
        UpdateAccountRequest.newBuilder().setAccount(account).setUpdateMask(updateMask).build();
    return updateAccount(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an account regardless of its type: standalone, MCA or sub-account. Executing this
   * method requires admin access.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AccountsServiceClient accountsServiceClient = AccountsServiceClient.create()) {
   *   UpdateAccountRequest request =
   *       UpdateAccountRequest.newBuilder()
   *           .setAccount(Account.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Account response = accountsServiceClient.updateAccount(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Account updateAccount(UpdateAccountRequest request) {
    return updateAccountCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an account regardless of its type: standalone, MCA or sub-account. Executing this
   * method requires admin access.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AccountsServiceClient accountsServiceClient = AccountsServiceClient.create()) {
   *   UpdateAccountRequest request =
   *       UpdateAccountRequest.newBuilder()
   *           .setAccount(Account.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Account> future = accountsServiceClient.updateAccountCallable().futureCall(request);
   *   // Do something.
   *   Account response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateAccountRequest, Account> updateAccountCallable() {
    return stub.updateAccountCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists accounts accessible to the calling user and matching the constraints of the request such
   * as page size or filters. This is not just listing the sub-accounts of an MCA, but all accounts
   * the calling user has access to including other MCAs, linked accounts, standalone accounts and
   * so on.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AccountsServiceClient accountsServiceClient = AccountsServiceClient.create()) {
   *   ListAccountsRequest request =
   *       ListAccountsRequest.newBuilder()
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   for (Account element : accountsServiceClient.listAccounts(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAccountsPagedResponse listAccounts(ListAccountsRequest request) {
    return listAccountsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists accounts accessible to the calling user and matching the constraints of the request such
   * as page size or filters. This is not just listing the sub-accounts of an MCA, but all accounts
   * the calling user has access to including other MCAs, linked accounts, standalone accounts and
   * so on.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AccountsServiceClient accountsServiceClient = AccountsServiceClient.create()) {
   *   ListAccountsRequest request =
   *       ListAccountsRequest.newBuilder()
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   ApiFuture<Account> future =
   *       accountsServiceClient.listAccountsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Account element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListAccountsRequest, ListAccountsPagedResponse>
      listAccountsPagedCallable() {
    return stub.listAccountsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists accounts accessible to the calling user and matching the constraints of the request such
   * as page size or filters. This is not just listing the sub-accounts of an MCA, but all accounts
   * the calling user has access to including other MCAs, linked accounts, standalone accounts and
   * so on.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AccountsServiceClient accountsServiceClient = AccountsServiceClient.create()) {
   *   ListAccountsRequest request =
   *       ListAccountsRequest.newBuilder()
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   while (true) {
   *     ListAccountsResponse response = accountsServiceClient.listAccountsCallable().call(request);
   *     for (Account element : response.getAccountsList()) {
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
  public final UnaryCallable<ListAccountsRequest, ListAccountsResponse> listAccountsCallable() {
    return stub.listAccountsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List all sub-accounts for a given multi client account. This is a convenience wrapper for the
   * more powerful `ListAccounts` method. This method will produce the same results as calling
   * `ListsAccounts` with the following filter: `relationship(providerId={parent} AND
   * service(type="ACCOUNT_AGGREGATION"))`
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AccountsServiceClient accountsServiceClient = AccountsServiceClient.create()) {
   *   AccountName provider = AccountName.of("[ACCOUNT]");
   *   for (Account element : accountsServiceClient.listSubAccounts(provider).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param provider Required. The parent account. Format: `accounts/{account}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSubAccountsPagedResponse listSubAccounts(AccountName provider) {
    ListSubAccountsRequest request =
        ListSubAccountsRequest.newBuilder()
            .setProvider(provider == null ? null : provider.toString())
            .build();
    return listSubAccounts(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List all sub-accounts for a given multi client account. This is a convenience wrapper for the
   * more powerful `ListAccounts` method. This method will produce the same results as calling
   * `ListsAccounts` with the following filter: `relationship(providerId={parent} AND
   * service(type="ACCOUNT_AGGREGATION"))`
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AccountsServiceClient accountsServiceClient = AccountsServiceClient.create()) {
   *   String provider = AccountName.of("[ACCOUNT]").toString();
   *   for (Account element : accountsServiceClient.listSubAccounts(provider).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param provider Required. The parent account. Format: `accounts/{account}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSubAccountsPagedResponse listSubAccounts(String provider) {
    ListSubAccountsRequest request =
        ListSubAccountsRequest.newBuilder().setProvider(provider).build();
    return listSubAccounts(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List all sub-accounts for a given multi client account. This is a convenience wrapper for the
   * more powerful `ListAccounts` method. This method will produce the same results as calling
   * `ListsAccounts` with the following filter: `relationship(providerId={parent} AND
   * service(type="ACCOUNT_AGGREGATION"))`
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AccountsServiceClient accountsServiceClient = AccountsServiceClient.create()) {
   *   ListSubAccountsRequest request =
   *       ListSubAccountsRequest.newBuilder()
   *           .setProvider(AccountName.of("[ACCOUNT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Account element : accountsServiceClient.listSubAccounts(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSubAccountsPagedResponse listSubAccounts(ListSubAccountsRequest request) {
    return listSubAccountsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List all sub-accounts for a given multi client account. This is a convenience wrapper for the
   * more powerful `ListAccounts` method. This method will produce the same results as calling
   * `ListsAccounts` with the following filter: `relationship(providerId={parent} AND
   * service(type="ACCOUNT_AGGREGATION"))`
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AccountsServiceClient accountsServiceClient = AccountsServiceClient.create()) {
   *   ListSubAccountsRequest request =
   *       ListSubAccountsRequest.newBuilder()
   *           .setProvider(AccountName.of("[ACCOUNT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Account> future =
   *       accountsServiceClient.listSubAccountsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Account element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListSubAccountsRequest, ListSubAccountsPagedResponse>
      listSubAccountsPagedCallable() {
    return stub.listSubAccountsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List all sub-accounts for a given multi client account. This is a convenience wrapper for the
   * more powerful `ListAccounts` method. This method will produce the same results as calling
   * `ListsAccounts` with the following filter: `relationship(providerId={parent} AND
   * service(type="ACCOUNT_AGGREGATION"))`
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AccountsServiceClient accountsServiceClient = AccountsServiceClient.create()) {
   *   ListSubAccountsRequest request =
   *       ListSubAccountsRequest.newBuilder()
   *           .setProvider(AccountName.of("[ACCOUNT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListSubAccountsResponse response =
   *         accountsServiceClient.listSubAccountsCallable().call(request);
   *     for (Account element : response.getAccountsList()) {
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
  public final UnaryCallable<ListSubAccountsRequest, ListSubAccountsResponse>
      listSubAccountsCallable() {
    return stub.listSubAccountsCallable();
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

  public static class ListAccountsPagedResponse
      extends AbstractPagedListResponse<
          ListAccountsRequest,
          ListAccountsResponse,
          Account,
          ListAccountsPage,
          ListAccountsFixedSizeCollection> {

    public static ApiFuture<ListAccountsPagedResponse> createAsync(
        PageContext<ListAccountsRequest, ListAccountsResponse, Account> context,
        ApiFuture<ListAccountsResponse> futureResponse) {
      ApiFuture<ListAccountsPage> futurePage =
          ListAccountsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListAccountsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListAccountsPagedResponse(ListAccountsPage page) {
      super(page, ListAccountsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListAccountsPage
      extends AbstractPage<ListAccountsRequest, ListAccountsResponse, Account, ListAccountsPage> {

    private ListAccountsPage(
        PageContext<ListAccountsRequest, ListAccountsResponse, Account> context,
        ListAccountsResponse response) {
      super(context, response);
    }

    private static ListAccountsPage createEmptyPage() {
      return new ListAccountsPage(null, null);
    }

    @Override
    protected ListAccountsPage createPage(
        PageContext<ListAccountsRequest, ListAccountsResponse, Account> context,
        ListAccountsResponse response) {
      return new ListAccountsPage(context, response);
    }

    @Override
    public ApiFuture<ListAccountsPage> createPageAsync(
        PageContext<ListAccountsRequest, ListAccountsResponse, Account> context,
        ApiFuture<ListAccountsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListAccountsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListAccountsRequest,
          ListAccountsResponse,
          Account,
          ListAccountsPage,
          ListAccountsFixedSizeCollection> {

    private ListAccountsFixedSizeCollection(List<ListAccountsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListAccountsFixedSizeCollection createEmptyCollection() {
      return new ListAccountsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListAccountsFixedSizeCollection createCollection(
        List<ListAccountsPage> pages, int collectionSize) {
      return new ListAccountsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListSubAccountsPagedResponse
      extends AbstractPagedListResponse<
          ListSubAccountsRequest,
          ListSubAccountsResponse,
          Account,
          ListSubAccountsPage,
          ListSubAccountsFixedSizeCollection> {

    public static ApiFuture<ListSubAccountsPagedResponse> createAsync(
        PageContext<ListSubAccountsRequest, ListSubAccountsResponse, Account> context,
        ApiFuture<ListSubAccountsResponse> futureResponse) {
      ApiFuture<ListSubAccountsPage> futurePage =
          ListSubAccountsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListSubAccountsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListSubAccountsPagedResponse(ListSubAccountsPage page) {
      super(page, ListSubAccountsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListSubAccountsPage
      extends AbstractPage<
          ListSubAccountsRequest, ListSubAccountsResponse, Account, ListSubAccountsPage> {

    private ListSubAccountsPage(
        PageContext<ListSubAccountsRequest, ListSubAccountsResponse, Account> context,
        ListSubAccountsResponse response) {
      super(context, response);
    }

    private static ListSubAccountsPage createEmptyPage() {
      return new ListSubAccountsPage(null, null);
    }

    @Override
    protected ListSubAccountsPage createPage(
        PageContext<ListSubAccountsRequest, ListSubAccountsResponse, Account> context,
        ListSubAccountsResponse response) {
      return new ListSubAccountsPage(context, response);
    }

    @Override
    public ApiFuture<ListSubAccountsPage> createPageAsync(
        PageContext<ListSubAccountsRequest, ListSubAccountsResponse, Account> context,
        ApiFuture<ListSubAccountsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListSubAccountsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListSubAccountsRequest,
          ListSubAccountsResponse,
          Account,
          ListSubAccountsPage,
          ListSubAccountsFixedSizeCollection> {

    private ListSubAccountsFixedSizeCollection(
        List<ListSubAccountsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListSubAccountsFixedSizeCollection createEmptyCollection() {
      return new ListSubAccountsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListSubAccountsFixedSizeCollection createCollection(
        List<ListSubAccountsPage> pages, int collectionSize) {
      return new ListSubAccountsFixedSizeCollection(pages, collectionSize);
    }
  }
}
