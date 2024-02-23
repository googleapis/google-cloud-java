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

package com.google.shopping.css.v1;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.shopping.css.v1.stub.AccountsServiceStub;
import com.google.shopping.css.v1.stub.AccountsServiceStubSettings;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Service for managing CSS/MC account information.
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
 *      <td><p> ListChildAccounts</td>
 *      <td><p> Lists all the accounts under the specified CSS account ID, and optionally filters by label ID and account name.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listChildAccounts(ListChildAccountsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listChildAccounts(AccountName parent)
 *           <li><p> listChildAccounts(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listChildAccountsPagedCallable()
 *           <li><p> listChildAccountsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetAccount</td>
 *      <td><p> Retrieves a single CSS/MC account by ID.</td>
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
 *      <td><p> UpdateLabels</td>
 *      <td><p> Updates labels assigned to CSS/MC accounts by a CSS domain.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateLabels(UpdateAccountLabelsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateLabels(AccountName name)
 *           <li><p> updateLabels(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateLabelsCallable()
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
   * Lists all the accounts under the specified CSS account ID, and optionally filters by label ID
   * and account name.
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
   *   AccountName parent = AccountName.of("[ACCOUNT]");
   *   for (Account element : accountsServiceClient.listChildAccounts(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent account. Must be a CSS group or domain. Format:
   *     accounts/{account}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListChildAccountsPagedResponse listChildAccounts(AccountName parent) {
    ListChildAccountsRequest request =
        ListChildAccountsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listChildAccounts(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all the accounts under the specified CSS account ID, and optionally filters by label ID
   * and account name.
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
   *   String parent = AccountName.of("[ACCOUNT]").toString();
   *   for (Account element : accountsServiceClient.listChildAccounts(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent account. Must be a CSS group or domain. Format:
   *     accounts/{account}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListChildAccountsPagedResponse listChildAccounts(String parent) {
    ListChildAccountsRequest request =
        ListChildAccountsRequest.newBuilder().setParent(parent).build();
    return listChildAccounts(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all the accounts under the specified CSS account ID, and optionally filters by label ID
   * and account name.
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
   *   ListChildAccountsRequest request =
   *       ListChildAccountsRequest.newBuilder()
   *           .setParent(AccountName.of("[ACCOUNT]").toString())
   *           .setLabelId(-1959256506)
   *           .setFullName("fullName1330852282")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Account element : accountsServiceClient.listChildAccounts(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListChildAccountsPagedResponse listChildAccounts(ListChildAccountsRequest request) {
    return listChildAccountsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all the accounts under the specified CSS account ID, and optionally filters by label ID
   * and account name.
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
   *   ListChildAccountsRequest request =
   *       ListChildAccountsRequest.newBuilder()
   *           .setParent(AccountName.of("[ACCOUNT]").toString())
   *           .setLabelId(-1959256506)
   *           .setFullName("fullName1330852282")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Account> future =
   *       accountsServiceClient.listChildAccountsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Account element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListChildAccountsRequest, ListChildAccountsPagedResponse>
      listChildAccountsPagedCallable() {
    return stub.listChildAccountsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all the accounts under the specified CSS account ID, and optionally filters by label ID
   * and account name.
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
   *   ListChildAccountsRequest request =
   *       ListChildAccountsRequest.newBuilder()
   *           .setParent(AccountName.of("[ACCOUNT]").toString())
   *           .setLabelId(-1959256506)
   *           .setFullName("fullName1330852282")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListChildAccountsResponse response =
   *         accountsServiceClient.listChildAccountsCallable().call(request);
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
  public final UnaryCallable<ListChildAccountsRequest, ListChildAccountsResponse>
      listChildAccountsCallable() {
    return stub.listChildAccountsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a single CSS/MC account by ID.
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
   * @param name Required. The name of the managed CSS/MC account. Format: accounts/{account}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Account getAccount(AccountName name) {
    GetAccountRequest request =
        GetAccountRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getAccount(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a single CSS/MC account by ID.
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
   * @param name Required. The name of the managed CSS/MC account. Format: accounts/{account}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Account getAccount(String name) {
    GetAccountRequest request = GetAccountRequest.newBuilder().setName(name).build();
    return getAccount(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a single CSS/MC account by ID.
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
   *       GetAccountRequest.newBuilder()
   *           .setName(AccountName.of("[ACCOUNT]").toString())
   *           .setParent(AccountName.of("[ACCOUNT]").toString())
   *           .build();
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
   * Retrieves a single CSS/MC account by ID.
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
   *       GetAccountRequest.newBuilder()
   *           .setName(AccountName.of("[ACCOUNT]").toString())
   *           .setParent(AccountName.of("[ACCOUNT]").toString())
   *           .build();
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
   * Updates labels assigned to CSS/MC accounts by a CSS domain.
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
   *   Account response = accountsServiceClient.updateLabels(name);
   * }
   * }</pre>
   *
   * @param name Required. The label resource name. Format: accounts/{account}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Account updateLabels(AccountName name) {
    UpdateAccountLabelsRequest request =
        UpdateAccountLabelsRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return updateLabels(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates labels assigned to CSS/MC accounts by a CSS domain.
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
   *   Account response = accountsServiceClient.updateLabels(name);
   * }
   * }</pre>
   *
   * @param name Required. The label resource name. Format: accounts/{account}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Account updateLabels(String name) {
    UpdateAccountLabelsRequest request =
        UpdateAccountLabelsRequest.newBuilder().setName(name).build();
    return updateLabels(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates labels assigned to CSS/MC accounts by a CSS domain.
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
   *   UpdateAccountLabelsRequest request =
   *       UpdateAccountLabelsRequest.newBuilder()
   *           .setName(AccountName.of("[ACCOUNT]").toString())
   *           .addAllLabelIds(new ArrayList<Long>())
   *           .setParent(AccountName.of("[ACCOUNT]").toString())
   *           .build();
   *   Account response = accountsServiceClient.updateLabels(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Account updateLabels(UpdateAccountLabelsRequest request) {
    return updateLabelsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates labels assigned to CSS/MC accounts by a CSS domain.
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
   *   UpdateAccountLabelsRequest request =
   *       UpdateAccountLabelsRequest.newBuilder()
   *           .setName(AccountName.of("[ACCOUNT]").toString())
   *           .addAllLabelIds(new ArrayList<Long>())
   *           .setParent(AccountName.of("[ACCOUNT]").toString())
   *           .build();
   *   ApiFuture<Account> future = accountsServiceClient.updateLabelsCallable().futureCall(request);
   *   // Do something.
   *   Account response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateAccountLabelsRequest, Account> updateLabelsCallable() {
    return stub.updateLabelsCallable();
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

  public static class ListChildAccountsPagedResponse
      extends AbstractPagedListResponse<
          ListChildAccountsRequest,
          ListChildAccountsResponse,
          Account,
          ListChildAccountsPage,
          ListChildAccountsFixedSizeCollection> {

    public static ApiFuture<ListChildAccountsPagedResponse> createAsync(
        PageContext<ListChildAccountsRequest, ListChildAccountsResponse, Account> context,
        ApiFuture<ListChildAccountsResponse> futureResponse) {
      ApiFuture<ListChildAccountsPage> futurePage =
          ListChildAccountsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListChildAccountsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListChildAccountsPagedResponse(ListChildAccountsPage page) {
      super(page, ListChildAccountsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListChildAccountsPage
      extends AbstractPage<
          ListChildAccountsRequest, ListChildAccountsResponse, Account, ListChildAccountsPage> {

    private ListChildAccountsPage(
        PageContext<ListChildAccountsRequest, ListChildAccountsResponse, Account> context,
        ListChildAccountsResponse response) {
      super(context, response);
    }

    private static ListChildAccountsPage createEmptyPage() {
      return new ListChildAccountsPage(null, null);
    }

    @Override
    protected ListChildAccountsPage createPage(
        PageContext<ListChildAccountsRequest, ListChildAccountsResponse, Account> context,
        ListChildAccountsResponse response) {
      return new ListChildAccountsPage(context, response);
    }

    @Override
    public ApiFuture<ListChildAccountsPage> createPageAsync(
        PageContext<ListChildAccountsRequest, ListChildAccountsResponse, Account> context,
        ApiFuture<ListChildAccountsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListChildAccountsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListChildAccountsRequest,
          ListChildAccountsResponse,
          Account,
          ListChildAccountsPage,
          ListChildAccountsFixedSizeCollection> {

    private ListChildAccountsFixedSizeCollection(
        List<ListChildAccountsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListChildAccountsFixedSizeCollection createEmptyCollection() {
      return new ListChildAccountsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListChildAccountsFixedSizeCollection createCollection(
        List<ListChildAccountsPage> pages, int collectionSize) {
      return new ListChildAccountsFixedSizeCollection(pages, collectionSize);
    }
  }
}
