/*
 * Copyright 2023 Google LLC
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

package com.google.analytics.admin.v1alpha;

import com.google.analytics.admin.v1alpha.stub.AnalyticsAdminServiceStub;
import com.google.analytics.admin.v1alpha.stub.AnalyticsAdminServiceStubSettings;
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
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Service Interface for the Analytics Admin API (GA4).
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
 * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
 *     AnalyticsAdminServiceClient.create()) {
 *   AccountName name = AccountName.of("[ACCOUNT]");
 *   Account response = analyticsAdminServiceClient.getAccount(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the AnalyticsAdminServiceClient object to clean up
 * resources such as threads. In the example above, try-with-resources is used, which automatically
 * calls close().
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
 * <p>This class can be customized by passing in a custom instance of AnalyticsAdminServiceSettings
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
 * AnalyticsAdminServiceSettings analyticsAdminServiceSettings =
 *     AnalyticsAdminServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * AnalyticsAdminServiceClient analyticsAdminServiceClient =
 *     AnalyticsAdminServiceClient.create(analyticsAdminServiceSettings);
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
 * AnalyticsAdminServiceSettings analyticsAdminServiceSettings =
 *     AnalyticsAdminServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * AnalyticsAdminServiceClient analyticsAdminServiceClient =
 *     AnalyticsAdminServiceClient.create(analyticsAdminServiceSettings);
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
 * AnalyticsAdminServiceSettings analyticsAdminServiceSettings =
 *     AnalyticsAdminServiceSettings.newHttpJsonBuilder().build();
 * AnalyticsAdminServiceClient analyticsAdminServiceClient =
 *     AnalyticsAdminServiceClient.create(analyticsAdminServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class AnalyticsAdminServiceClient implements BackgroundResource {
  private final AnalyticsAdminServiceSettings settings;
  private final AnalyticsAdminServiceStub stub;

  /** Constructs an instance of AnalyticsAdminServiceClient with default settings. */
  public static final AnalyticsAdminServiceClient create() throws IOException {
    return create(AnalyticsAdminServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of AnalyticsAdminServiceClient, using the given settings. The channels
   * are created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final AnalyticsAdminServiceClient create(AnalyticsAdminServiceSettings settings)
      throws IOException {
    return new AnalyticsAdminServiceClient(settings);
  }

  /**
   * Constructs an instance of AnalyticsAdminServiceClient, using the given stub for making calls.
   * This is for advanced usage - prefer using create(AnalyticsAdminServiceSettings).
   */
  public static final AnalyticsAdminServiceClient create(AnalyticsAdminServiceStub stub) {
    return new AnalyticsAdminServiceClient(stub);
  }

  /**
   * Constructs an instance of AnalyticsAdminServiceClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected AnalyticsAdminServiceClient(AnalyticsAdminServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((AnalyticsAdminServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected AnalyticsAdminServiceClient(AnalyticsAdminServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final AnalyticsAdminServiceSettings getSettings() {
    return settings;
  }

  public AnalyticsAdminServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lookup for a single Account.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   AccountName name = AccountName.of("[ACCOUNT]");
   *   Account response = analyticsAdminServiceClient.getAccount(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the account to lookup. Format: accounts/{account} Example:
   *     "accounts/100"
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Account getAccount(AccountName name) {
    GetAccountRequest request =
        GetAccountRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getAccount(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lookup for a single Account.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   String name = AccountName.of("[ACCOUNT]").toString();
   *   Account response = analyticsAdminServiceClient.getAccount(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the account to lookup. Format: accounts/{account} Example:
   *     "accounts/100"
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Account getAccount(String name) {
    GetAccountRequest request = GetAccountRequest.newBuilder().setName(name).build();
    return getAccount(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lookup for a single Account.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   GetAccountRequest request =
   *       GetAccountRequest.newBuilder().setName(AccountName.of("[ACCOUNT]").toString()).build();
   *   Account response = analyticsAdminServiceClient.getAccount(request);
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
   * Lookup for a single Account.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   GetAccountRequest request =
   *       GetAccountRequest.newBuilder().setName(AccountName.of("[ACCOUNT]").toString()).build();
   *   ApiFuture<Account> future =
   *       analyticsAdminServiceClient.getAccountCallable().futureCall(request);
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
   * Returns all accounts accessible by the caller.
   *
   * <p>Note that these accounts might not currently have GA4 properties. Soft-deleted (ie:
   * "trashed") accounts are excluded by default. Returns an empty list if no relevant accounts are
   * found.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   ListAccountsRequest request =
   *       ListAccountsRequest.newBuilder()
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setShowDeleted(true)
   *           .build();
   *   for (Account element : analyticsAdminServiceClient.listAccounts(request).iterateAll()) {
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
   * Returns all accounts accessible by the caller.
   *
   * <p>Note that these accounts might not currently have GA4 properties. Soft-deleted (ie:
   * "trashed") accounts are excluded by default. Returns an empty list if no relevant accounts are
   * found.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   ListAccountsRequest request =
   *       ListAccountsRequest.newBuilder()
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setShowDeleted(true)
   *           .build();
   *   ApiFuture<Account> future =
   *       analyticsAdminServiceClient.listAccountsPagedCallable().futureCall(request);
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
   * Returns all accounts accessible by the caller.
   *
   * <p>Note that these accounts might not currently have GA4 properties. Soft-deleted (ie:
   * "trashed") accounts are excluded by default. Returns an empty list if no relevant accounts are
   * found.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   ListAccountsRequest request =
   *       ListAccountsRequest.newBuilder()
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setShowDeleted(true)
   *           .build();
   *   while (true) {
   *     ListAccountsResponse response =
   *         analyticsAdminServiceClient.listAccountsCallable().call(request);
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
   * Marks target Account as soft-deleted (ie: "trashed") and returns it.
   *
   * <p>This API does not have a method to restore soft-deleted accounts. However, they can be
   * restored using the Trash Can UI.
   *
   * <p>If the accounts are not restored before the expiration time, the account and all child
   * resources (eg: Properties, GoogleAdsLinks, Streams, AccessBindings) will be permanently purged.
   * https://support.google.com/analytics/answer/6154772
   *
   * <p>Returns an error if the target is not found.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   AccountName name = AccountName.of("[ACCOUNT]");
   *   analyticsAdminServiceClient.deleteAccount(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the Account to soft-delete. Format: accounts/{account}
   *     Example: "accounts/100"
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteAccount(AccountName name) {
    DeleteAccountRequest request =
        DeleteAccountRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    deleteAccount(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Marks target Account as soft-deleted (ie: "trashed") and returns it.
   *
   * <p>This API does not have a method to restore soft-deleted accounts. However, they can be
   * restored using the Trash Can UI.
   *
   * <p>If the accounts are not restored before the expiration time, the account and all child
   * resources (eg: Properties, GoogleAdsLinks, Streams, AccessBindings) will be permanently purged.
   * https://support.google.com/analytics/answer/6154772
   *
   * <p>Returns an error if the target is not found.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   String name = AccountName.of("[ACCOUNT]").toString();
   *   analyticsAdminServiceClient.deleteAccount(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the Account to soft-delete. Format: accounts/{account}
   *     Example: "accounts/100"
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteAccount(String name) {
    DeleteAccountRequest request = DeleteAccountRequest.newBuilder().setName(name).build();
    deleteAccount(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Marks target Account as soft-deleted (ie: "trashed") and returns it.
   *
   * <p>This API does not have a method to restore soft-deleted accounts. However, they can be
   * restored using the Trash Can UI.
   *
   * <p>If the accounts are not restored before the expiration time, the account and all child
   * resources (eg: Properties, GoogleAdsLinks, Streams, AccessBindings) will be permanently purged.
   * https://support.google.com/analytics/answer/6154772
   *
   * <p>Returns an error if the target is not found.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   DeleteAccountRequest request =
   *       DeleteAccountRequest.newBuilder().setName(AccountName.of("[ACCOUNT]").toString()).build();
   *   analyticsAdminServiceClient.deleteAccount(request);
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
   * Marks target Account as soft-deleted (ie: "trashed") and returns it.
   *
   * <p>This API does not have a method to restore soft-deleted accounts. However, they can be
   * restored using the Trash Can UI.
   *
   * <p>If the accounts are not restored before the expiration time, the account and all child
   * resources (eg: Properties, GoogleAdsLinks, Streams, AccessBindings) will be permanently purged.
   * https://support.google.com/analytics/answer/6154772
   *
   * <p>Returns an error if the target is not found.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   DeleteAccountRequest request =
   *       DeleteAccountRequest.newBuilder().setName(AccountName.of("[ACCOUNT]").toString()).build();
   *   ApiFuture<Empty> future =
   *       analyticsAdminServiceClient.deleteAccountCallable().futureCall(request);
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
   * Updates an account.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   Account account = Account.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Account response = analyticsAdminServiceClient.updateAccount(account, updateMask);
   * }
   * }</pre>
   *
   * @param account Required. The account to update. The account's `name` field is used to identify
   *     the account.
   * @param updateMask Required. The list of fields to be updated. Field names must be in snake case
   *     (for example, "field_to_update"). Omitted fields will not be updated. To replace the entire
   *     entity, use one path with the string "&#42;" to match all fields.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Account updateAccount(Account account, FieldMask updateMask) {
    UpdateAccountRequest request =
        UpdateAccountRequest.newBuilder().setAccount(account).setUpdateMask(updateMask).build();
    return updateAccount(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an account.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   UpdateAccountRequest request =
   *       UpdateAccountRequest.newBuilder()
   *           .setAccount(Account.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Account response = analyticsAdminServiceClient.updateAccount(request);
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
   * Updates an account.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   UpdateAccountRequest request =
   *       UpdateAccountRequest.newBuilder()
   *           .setAccount(Account.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Account> future =
   *       analyticsAdminServiceClient.updateAccountCallable().futureCall(request);
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
   * Requests a ticket for creating an account.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   ProvisionAccountTicketRequest request =
   *       ProvisionAccountTicketRequest.newBuilder()
   *           .setAccount(Account.newBuilder().build())
   *           .setRedirectUri("redirectUri1970337776")
   *           .build();
   *   ProvisionAccountTicketResponse response =
   *       analyticsAdminServiceClient.provisionAccountTicket(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ProvisionAccountTicketResponse provisionAccountTicket(
      ProvisionAccountTicketRequest request) {
    return provisionAccountTicketCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Requests a ticket for creating an account.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   ProvisionAccountTicketRequest request =
   *       ProvisionAccountTicketRequest.newBuilder()
   *           .setAccount(Account.newBuilder().build())
   *           .setRedirectUri("redirectUri1970337776")
   *           .build();
   *   ApiFuture<ProvisionAccountTicketResponse> future =
   *       analyticsAdminServiceClient.provisionAccountTicketCallable().futureCall(request);
   *   // Do something.
   *   ProvisionAccountTicketResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ProvisionAccountTicketRequest, ProvisionAccountTicketResponse>
      provisionAccountTicketCallable() {
    return stub.provisionAccountTicketCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns summaries of all accounts accessible by the caller.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   ListAccountSummariesRequest request =
   *       ListAccountSummariesRequest.newBuilder()
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (AccountSummary element :
   *       analyticsAdminServiceClient.listAccountSummaries(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAccountSummariesPagedResponse listAccountSummaries(
      ListAccountSummariesRequest request) {
    return listAccountSummariesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns summaries of all accounts accessible by the caller.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   ListAccountSummariesRequest request =
   *       ListAccountSummariesRequest.newBuilder()
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<AccountSummary> future =
   *       analyticsAdminServiceClient.listAccountSummariesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (AccountSummary element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListAccountSummariesRequest, ListAccountSummariesPagedResponse>
      listAccountSummariesPagedCallable() {
    return stub.listAccountSummariesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns summaries of all accounts accessible by the caller.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   ListAccountSummariesRequest request =
   *       ListAccountSummariesRequest.newBuilder()
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListAccountSummariesResponse response =
   *         analyticsAdminServiceClient.listAccountSummariesCallable().call(request);
   *     for (AccountSummary element : response.getAccountSummariesList()) {
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
  public final UnaryCallable<ListAccountSummariesRequest, ListAccountSummariesResponse>
      listAccountSummariesCallable() {
    return stub.listAccountSummariesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lookup for a single "GA4" Property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   PropertyName name = PropertyName.of("[PROPERTY]");
   *   Property response = analyticsAdminServiceClient.getProperty(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the property to lookup. Format: properties/{property_id}
   *     Example: "properties/1000"
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Property getProperty(PropertyName name) {
    GetPropertyRequest request =
        GetPropertyRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getProperty(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lookup for a single "GA4" Property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   String name = PropertyName.of("[PROPERTY]").toString();
   *   Property response = analyticsAdminServiceClient.getProperty(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the property to lookup. Format: properties/{property_id}
   *     Example: "properties/1000"
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Property getProperty(String name) {
    GetPropertyRequest request = GetPropertyRequest.newBuilder().setName(name).build();
    return getProperty(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lookup for a single "GA4" Property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   GetPropertyRequest request =
   *       GetPropertyRequest.newBuilder().setName(PropertyName.of("[PROPERTY]").toString()).build();
   *   Property response = analyticsAdminServiceClient.getProperty(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Property getProperty(GetPropertyRequest request) {
    return getPropertyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lookup for a single "GA4" Property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   GetPropertyRequest request =
   *       GetPropertyRequest.newBuilder().setName(PropertyName.of("[PROPERTY]").toString()).build();
   *   ApiFuture<Property> future =
   *       analyticsAdminServiceClient.getPropertyCallable().futureCall(request);
   *   // Do something.
   *   Property response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetPropertyRequest, Property> getPropertyCallable() {
    return stub.getPropertyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns child Properties under the specified parent Account.
   *
   * <p>Only "GA4" properties will be returned. Properties will be excluded if the caller does not
   * have access. Soft-deleted (ie: "trashed") properties are excluded by default. Returns an empty
   * list if no relevant properties are found.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   ListPropertiesRequest request =
   *       ListPropertiesRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setShowDeleted(true)
   *           .build();
   *   for (Property element : analyticsAdminServiceClient.listProperties(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPropertiesPagedResponse listProperties(ListPropertiesRequest request) {
    return listPropertiesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns child Properties under the specified parent Account.
   *
   * <p>Only "GA4" properties will be returned. Properties will be excluded if the caller does not
   * have access. Soft-deleted (ie: "trashed") properties are excluded by default. Returns an empty
   * list if no relevant properties are found.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   ListPropertiesRequest request =
   *       ListPropertiesRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setShowDeleted(true)
   *           .build();
   *   ApiFuture<Property> future =
   *       analyticsAdminServiceClient.listPropertiesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Property element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListPropertiesRequest, ListPropertiesPagedResponse>
      listPropertiesPagedCallable() {
    return stub.listPropertiesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns child Properties under the specified parent Account.
   *
   * <p>Only "GA4" properties will be returned. Properties will be excluded if the caller does not
   * have access. Soft-deleted (ie: "trashed") properties are excluded by default. Returns an empty
   * list if no relevant properties are found.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   ListPropertiesRequest request =
   *       ListPropertiesRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setShowDeleted(true)
   *           .build();
   *   while (true) {
   *     ListPropertiesResponse response =
   *         analyticsAdminServiceClient.listPropertiesCallable().call(request);
   *     for (Property element : response.getPropertiesList()) {
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
  public final UnaryCallable<ListPropertiesRequest, ListPropertiesResponse>
      listPropertiesCallable() {
    return stub.listPropertiesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an "GA4" property with the specified location and attributes.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   Property property = Property.newBuilder().build();
   *   Property response = analyticsAdminServiceClient.createProperty(property);
   * }
   * }</pre>
   *
   * @param property Required. The property to create. Note: the supplied property must specify its
   *     parent.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Property createProperty(Property property) {
    CreatePropertyRequest request =
        CreatePropertyRequest.newBuilder().setProperty(property).build();
    return createProperty(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an "GA4" property with the specified location and attributes.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   CreatePropertyRequest request =
   *       CreatePropertyRequest.newBuilder().setProperty(Property.newBuilder().build()).build();
   *   Property response = analyticsAdminServiceClient.createProperty(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Property createProperty(CreatePropertyRequest request) {
    return createPropertyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an "GA4" property with the specified location and attributes.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   CreatePropertyRequest request =
   *       CreatePropertyRequest.newBuilder().setProperty(Property.newBuilder().build()).build();
   *   ApiFuture<Property> future =
   *       analyticsAdminServiceClient.createPropertyCallable().futureCall(request);
   *   // Do something.
   *   Property response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreatePropertyRequest, Property> createPropertyCallable() {
    return stub.createPropertyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Marks target Property as soft-deleted (ie: "trashed") and returns it.
   *
   * <p>This API does not have a method to restore soft-deleted properties. However, they can be
   * restored using the Trash Can UI.
   *
   * <p>If the properties are not restored before the expiration time, the Property and all child
   * resources (eg: GoogleAdsLinks, Streams, AccessBindings) will be permanently purged.
   * https://support.google.com/analytics/answer/6154772
   *
   * <p>Returns an error if the target is not found, or is not a GA4 Property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   PropertyName name = PropertyName.of("[PROPERTY]");
   *   Property response = analyticsAdminServiceClient.deleteProperty(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the Property to soft-delete. Format: properties/{property_id}
   *     Example: "properties/1000"
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Property deleteProperty(PropertyName name) {
    DeletePropertyRequest request =
        DeletePropertyRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteProperty(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Marks target Property as soft-deleted (ie: "trashed") and returns it.
   *
   * <p>This API does not have a method to restore soft-deleted properties. However, they can be
   * restored using the Trash Can UI.
   *
   * <p>If the properties are not restored before the expiration time, the Property and all child
   * resources (eg: GoogleAdsLinks, Streams, AccessBindings) will be permanently purged.
   * https://support.google.com/analytics/answer/6154772
   *
   * <p>Returns an error if the target is not found, or is not a GA4 Property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   String name = PropertyName.of("[PROPERTY]").toString();
   *   Property response = analyticsAdminServiceClient.deleteProperty(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the Property to soft-delete. Format: properties/{property_id}
   *     Example: "properties/1000"
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Property deleteProperty(String name) {
    DeletePropertyRequest request = DeletePropertyRequest.newBuilder().setName(name).build();
    return deleteProperty(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Marks target Property as soft-deleted (ie: "trashed") and returns it.
   *
   * <p>This API does not have a method to restore soft-deleted properties. However, they can be
   * restored using the Trash Can UI.
   *
   * <p>If the properties are not restored before the expiration time, the Property and all child
   * resources (eg: GoogleAdsLinks, Streams, AccessBindings) will be permanently purged.
   * https://support.google.com/analytics/answer/6154772
   *
   * <p>Returns an error if the target is not found, or is not a GA4 Property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   DeletePropertyRequest request =
   *       DeletePropertyRequest.newBuilder()
   *           .setName(PropertyName.of("[PROPERTY]").toString())
   *           .build();
   *   Property response = analyticsAdminServiceClient.deleteProperty(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Property deleteProperty(DeletePropertyRequest request) {
    return deletePropertyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Marks target Property as soft-deleted (ie: "trashed") and returns it.
   *
   * <p>This API does not have a method to restore soft-deleted properties. However, they can be
   * restored using the Trash Can UI.
   *
   * <p>If the properties are not restored before the expiration time, the Property and all child
   * resources (eg: GoogleAdsLinks, Streams, AccessBindings) will be permanently purged.
   * https://support.google.com/analytics/answer/6154772
   *
   * <p>Returns an error if the target is not found, or is not a GA4 Property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   DeletePropertyRequest request =
   *       DeletePropertyRequest.newBuilder()
   *           .setName(PropertyName.of("[PROPERTY]").toString())
   *           .build();
   *   ApiFuture<Property> future =
   *       analyticsAdminServiceClient.deletePropertyCallable().futureCall(request);
   *   // Do something.
   *   Property response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeletePropertyRequest, Property> deletePropertyCallable() {
    return stub.deletePropertyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   Property property = Property.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Property response = analyticsAdminServiceClient.updateProperty(property, updateMask);
   * }
   * }</pre>
   *
   * @param property Required. The property to update. The property's `name` field is used to
   *     identify the property to be updated.
   * @param updateMask Required. The list of fields to be updated. Field names must be in snake case
   *     (e.g., "field_to_update"). Omitted fields will not be updated. To replace the entire
   *     entity, use one path with the string "&#42;" to match all fields.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Property updateProperty(Property property, FieldMask updateMask) {
    UpdatePropertyRequest request =
        UpdatePropertyRequest.newBuilder().setProperty(property).setUpdateMask(updateMask).build();
    return updateProperty(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   UpdatePropertyRequest request =
   *       UpdatePropertyRequest.newBuilder()
   *           .setProperty(Property.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Property response = analyticsAdminServiceClient.updateProperty(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Property updateProperty(UpdatePropertyRequest request) {
    return updatePropertyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   UpdatePropertyRequest request =
   *       UpdatePropertyRequest.newBuilder()
   *           .setProperty(Property.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Property> future =
   *       analyticsAdminServiceClient.updatePropertyCallable().futureCall(request);
   *   // Do something.
   *   Property response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdatePropertyRequest, Property> updatePropertyCallable() {
    return stub.updatePropertyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a FirebaseLink.
   *
   * <p>Properties can have at most one FirebaseLink.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   PropertyName parent = PropertyName.of("[PROPERTY]");
   *   FirebaseLink firebaseLink = FirebaseLink.newBuilder().build();
   *   FirebaseLink response = analyticsAdminServiceClient.createFirebaseLink(parent, firebaseLink);
   * }
   * }</pre>
   *
   * @param parent Required. Format: properties/{property_id} Example: properties/1234
   * @param firebaseLink Required. The Firebase link to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final FirebaseLink createFirebaseLink(PropertyName parent, FirebaseLink firebaseLink) {
    CreateFirebaseLinkRequest request =
        CreateFirebaseLinkRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setFirebaseLink(firebaseLink)
            .build();
    return createFirebaseLink(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a FirebaseLink.
   *
   * <p>Properties can have at most one FirebaseLink.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   String parent = PropertyName.of("[PROPERTY]").toString();
   *   FirebaseLink firebaseLink = FirebaseLink.newBuilder().build();
   *   FirebaseLink response = analyticsAdminServiceClient.createFirebaseLink(parent, firebaseLink);
   * }
   * }</pre>
   *
   * @param parent Required. Format: properties/{property_id} Example: properties/1234
   * @param firebaseLink Required. The Firebase link to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final FirebaseLink createFirebaseLink(String parent, FirebaseLink firebaseLink) {
    CreateFirebaseLinkRequest request =
        CreateFirebaseLinkRequest.newBuilder()
            .setParent(parent)
            .setFirebaseLink(firebaseLink)
            .build();
    return createFirebaseLink(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a FirebaseLink.
   *
   * <p>Properties can have at most one FirebaseLink.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   CreateFirebaseLinkRequest request =
   *       CreateFirebaseLinkRequest.newBuilder()
   *           .setParent(PropertyName.of("[PROPERTY]").toString())
   *           .setFirebaseLink(FirebaseLink.newBuilder().build())
   *           .build();
   *   FirebaseLink response = analyticsAdminServiceClient.createFirebaseLink(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final FirebaseLink createFirebaseLink(CreateFirebaseLinkRequest request) {
    return createFirebaseLinkCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a FirebaseLink.
   *
   * <p>Properties can have at most one FirebaseLink.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   CreateFirebaseLinkRequest request =
   *       CreateFirebaseLinkRequest.newBuilder()
   *           .setParent(PropertyName.of("[PROPERTY]").toString())
   *           .setFirebaseLink(FirebaseLink.newBuilder().build())
   *           .build();
   *   ApiFuture<FirebaseLink> future =
   *       analyticsAdminServiceClient.createFirebaseLinkCallable().futureCall(request);
   *   // Do something.
   *   FirebaseLink response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateFirebaseLinkRequest, FirebaseLink> createFirebaseLinkCallable() {
    return stub.createFirebaseLinkCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a FirebaseLink on a property
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   FirebaseLinkName name = FirebaseLinkName.of("[PROPERTY]", "[FIREBASE_LINK]");
   *   analyticsAdminServiceClient.deleteFirebaseLink(name);
   * }
   * }</pre>
   *
   * @param name Required. Format: properties/{property_id}/firebaseLinks/{firebase_link_id}
   *     Example: properties/1234/firebaseLinks/5678
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteFirebaseLink(FirebaseLinkName name) {
    DeleteFirebaseLinkRequest request =
        DeleteFirebaseLinkRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    deleteFirebaseLink(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a FirebaseLink on a property
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   String name = FirebaseLinkName.of("[PROPERTY]", "[FIREBASE_LINK]").toString();
   *   analyticsAdminServiceClient.deleteFirebaseLink(name);
   * }
   * }</pre>
   *
   * @param name Required. Format: properties/{property_id}/firebaseLinks/{firebase_link_id}
   *     Example: properties/1234/firebaseLinks/5678
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteFirebaseLink(String name) {
    DeleteFirebaseLinkRequest request =
        DeleteFirebaseLinkRequest.newBuilder().setName(name).build();
    deleteFirebaseLink(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a FirebaseLink on a property
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   DeleteFirebaseLinkRequest request =
   *       DeleteFirebaseLinkRequest.newBuilder()
   *           .setName(FirebaseLinkName.of("[PROPERTY]", "[FIREBASE_LINK]").toString())
   *           .build();
   *   analyticsAdminServiceClient.deleteFirebaseLink(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteFirebaseLink(DeleteFirebaseLinkRequest request) {
    deleteFirebaseLinkCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a FirebaseLink on a property
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   DeleteFirebaseLinkRequest request =
   *       DeleteFirebaseLinkRequest.newBuilder()
   *           .setName(FirebaseLinkName.of("[PROPERTY]", "[FIREBASE_LINK]").toString())
   *           .build();
   *   ApiFuture<Empty> future =
   *       analyticsAdminServiceClient.deleteFirebaseLinkCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteFirebaseLinkRequest, Empty> deleteFirebaseLinkCallable() {
    return stub.deleteFirebaseLinkCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists FirebaseLinks on a property. Properties can have at most one FirebaseLink.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   PropertyName parent = PropertyName.of("[PROPERTY]");
   *   for (FirebaseLink element :
   *       analyticsAdminServiceClient.listFirebaseLinks(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Format: properties/{property_id} Example: properties/1234
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListFirebaseLinksPagedResponse listFirebaseLinks(PropertyName parent) {
    ListFirebaseLinksRequest request =
        ListFirebaseLinksRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listFirebaseLinks(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists FirebaseLinks on a property. Properties can have at most one FirebaseLink.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   String parent = PropertyName.of("[PROPERTY]").toString();
   *   for (FirebaseLink element :
   *       analyticsAdminServiceClient.listFirebaseLinks(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Format: properties/{property_id} Example: properties/1234
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListFirebaseLinksPagedResponse listFirebaseLinks(String parent) {
    ListFirebaseLinksRequest request =
        ListFirebaseLinksRequest.newBuilder().setParent(parent).build();
    return listFirebaseLinks(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists FirebaseLinks on a property. Properties can have at most one FirebaseLink.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   ListFirebaseLinksRequest request =
   *       ListFirebaseLinksRequest.newBuilder()
   *           .setParent(PropertyName.of("[PROPERTY]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (FirebaseLink element :
   *       analyticsAdminServiceClient.listFirebaseLinks(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListFirebaseLinksPagedResponse listFirebaseLinks(ListFirebaseLinksRequest request) {
    return listFirebaseLinksPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists FirebaseLinks on a property. Properties can have at most one FirebaseLink.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   ListFirebaseLinksRequest request =
   *       ListFirebaseLinksRequest.newBuilder()
   *           .setParent(PropertyName.of("[PROPERTY]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<FirebaseLink> future =
   *       analyticsAdminServiceClient.listFirebaseLinksPagedCallable().futureCall(request);
   *   // Do something.
   *   for (FirebaseLink element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListFirebaseLinksRequest, ListFirebaseLinksPagedResponse>
      listFirebaseLinksPagedCallable() {
    return stub.listFirebaseLinksPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists FirebaseLinks on a property. Properties can have at most one FirebaseLink.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   ListFirebaseLinksRequest request =
   *       ListFirebaseLinksRequest.newBuilder()
   *           .setParent(PropertyName.of("[PROPERTY]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListFirebaseLinksResponse response =
   *         analyticsAdminServiceClient.listFirebaseLinksCallable().call(request);
   *     for (FirebaseLink element : response.getFirebaseLinksList()) {
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
  public final UnaryCallable<ListFirebaseLinksRequest, ListFirebaseLinksResponse>
      listFirebaseLinksCallable() {
    return stub.listFirebaseLinksCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the Site Tag for the specified web stream. Site Tags are immutable singletons.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   GlobalSiteTagName name = GlobalSiteTagName.of("[PROPERTY]", "[DATA_STREAM]");
   *   GlobalSiteTag response = analyticsAdminServiceClient.getGlobalSiteTag(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the site tag to lookup. Note that site tags are singletons
   *     and do not have unique IDs. Format:
   *     properties/{property_id}/dataStreams/{stream_id}/globalSiteTag Example:
   *     "properties/123/dataStreams/456/globalSiteTag"
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GlobalSiteTag getGlobalSiteTag(GlobalSiteTagName name) {
    GetGlobalSiteTagRequest request =
        GetGlobalSiteTagRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getGlobalSiteTag(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the Site Tag for the specified web stream. Site Tags are immutable singletons.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   String name = GlobalSiteTagName.of("[PROPERTY]", "[DATA_STREAM]").toString();
   *   GlobalSiteTag response = analyticsAdminServiceClient.getGlobalSiteTag(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the site tag to lookup. Note that site tags are singletons
   *     and do not have unique IDs. Format:
   *     properties/{property_id}/dataStreams/{stream_id}/globalSiteTag Example:
   *     "properties/123/dataStreams/456/globalSiteTag"
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GlobalSiteTag getGlobalSiteTag(String name) {
    GetGlobalSiteTagRequest request = GetGlobalSiteTagRequest.newBuilder().setName(name).build();
    return getGlobalSiteTag(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the Site Tag for the specified web stream. Site Tags are immutable singletons.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   GetGlobalSiteTagRequest request =
   *       GetGlobalSiteTagRequest.newBuilder()
   *           .setName(GlobalSiteTagName.of("[PROPERTY]", "[DATA_STREAM]").toString())
   *           .build();
   *   GlobalSiteTag response = analyticsAdminServiceClient.getGlobalSiteTag(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GlobalSiteTag getGlobalSiteTag(GetGlobalSiteTagRequest request) {
    return getGlobalSiteTagCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the Site Tag for the specified web stream. Site Tags are immutable singletons.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   GetGlobalSiteTagRequest request =
   *       GetGlobalSiteTagRequest.newBuilder()
   *           .setName(GlobalSiteTagName.of("[PROPERTY]", "[DATA_STREAM]").toString())
   *           .build();
   *   ApiFuture<GlobalSiteTag> future =
   *       analyticsAdminServiceClient.getGlobalSiteTagCallable().futureCall(request);
   *   // Do something.
   *   GlobalSiteTag response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetGlobalSiteTagRequest, GlobalSiteTag> getGlobalSiteTagCallable() {
    return stub.getGlobalSiteTagCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a GoogleAdsLink.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   PropertyName parent = PropertyName.of("[PROPERTY]");
   *   GoogleAdsLink googleAdsLink = GoogleAdsLink.newBuilder().build();
   *   GoogleAdsLink response =
   *       analyticsAdminServiceClient.createGoogleAdsLink(parent, googleAdsLink);
   * }
   * }</pre>
   *
   * @param parent Required. Example format: properties/1234
   * @param googleAdsLink Required. The GoogleAdsLink to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GoogleAdsLink createGoogleAdsLink(PropertyName parent, GoogleAdsLink googleAdsLink) {
    CreateGoogleAdsLinkRequest request =
        CreateGoogleAdsLinkRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setGoogleAdsLink(googleAdsLink)
            .build();
    return createGoogleAdsLink(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a GoogleAdsLink.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   String parent = PropertyName.of("[PROPERTY]").toString();
   *   GoogleAdsLink googleAdsLink = GoogleAdsLink.newBuilder().build();
   *   GoogleAdsLink response =
   *       analyticsAdminServiceClient.createGoogleAdsLink(parent, googleAdsLink);
   * }
   * }</pre>
   *
   * @param parent Required. Example format: properties/1234
   * @param googleAdsLink Required. The GoogleAdsLink to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GoogleAdsLink createGoogleAdsLink(String parent, GoogleAdsLink googleAdsLink) {
    CreateGoogleAdsLinkRequest request =
        CreateGoogleAdsLinkRequest.newBuilder()
            .setParent(parent)
            .setGoogleAdsLink(googleAdsLink)
            .build();
    return createGoogleAdsLink(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a GoogleAdsLink.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   CreateGoogleAdsLinkRequest request =
   *       CreateGoogleAdsLinkRequest.newBuilder()
   *           .setParent(PropertyName.of("[PROPERTY]").toString())
   *           .setGoogleAdsLink(GoogleAdsLink.newBuilder().build())
   *           .build();
   *   GoogleAdsLink response = analyticsAdminServiceClient.createGoogleAdsLink(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GoogleAdsLink createGoogleAdsLink(CreateGoogleAdsLinkRequest request) {
    return createGoogleAdsLinkCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a GoogleAdsLink.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   CreateGoogleAdsLinkRequest request =
   *       CreateGoogleAdsLinkRequest.newBuilder()
   *           .setParent(PropertyName.of("[PROPERTY]").toString())
   *           .setGoogleAdsLink(GoogleAdsLink.newBuilder().build())
   *           .build();
   *   ApiFuture<GoogleAdsLink> future =
   *       analyticsAdminServiceClient.createGoogleAdsLinkCallable().futureCall(request);
   *   // Do something.
   *   GoogleAdsLink response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateGoogleAdsLinkRequest, GoogleAdsLink>
      createGoogleAdsLinkCallable() {
    return stub.createGoogleAdsLinkCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a GoogleAdsLink on a property
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   GoogleAdsLink googleAdsLink = GoogleAdsLink.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   GoogleAdsLink response =
   *       analyticsAdminServiceClient.updateGoogleAdsLink(googleAdsLink, updateMask);
   * }
   * }</pre>
   *
   * @param googleAdsLink The GoogleAdsLink to update
   * @param updateMask Required. The list of fields to be updated. Field names must be in snake case
   *     (e.g., "field_to_update"). Omitted fields will not be updated. To replace the entire
   *     entity, use one path with the string "&#42;" to match all fields.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GoogleAdsLink updateGoogleAdsLink(
      GoogleAdsLink googleAdsLink, FieldMask updateMask) {
    UpdateGoogleAdsLinkRequest request =
        UpdateGoogleAdsLinkRequest.newBuilder()
            .setGoogleAdsLink(googleAdsLink)
            .setUpdateMask(updateMask)
            .build();
    return updateGoogleAdsLink(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a GoogleAdsLink on a property
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   UpdateGoogleAdsLinkRequest request =
   *       UpdateGoogleAdsLinkRequest.newBuilder()
   *           .setGoogleAdsLink(GoogleAdsLink.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   GoogleAdsLink response = analyticsAdminServiceClient.updateGoogleAdsLink(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GoogleAdsLink updateGoogleAdsLink(UpdateGoogleAdsLinkRequest request) {
    return updateGoogleAdsLinkCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a GoogleAdsLink on a property
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   UpdateGoogleAdsLinkRequest request =
   *       UpdateGoogleAdsLinkRequest.newBuilder()
   *           .setGoogleAdsLink(GoogleAdsLink.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<GoogleAdsLink> future =
   *       analyticsAdminServiceClient.updateGoogleAdsLinkCallable().futureCall(request);
   *   // Do something.
   *   GoogleAdsLink response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateGoogleAdsLinkRequest, GoogleAdsLink>
      updateGoogleAdsLinkCallable() {
    return stub.updateGoogleAdsLinkCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a GoogleAdsLink on a property
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   GoogleAdsLinkName name = GoogleAdsLinkName.of("[PROPERTY]", "[GOOGLE_ADS_LINK]");
   *   analyticsAdminServiceClient.deleteGoogleAdsLink(name);
   * }
   * }</pre>
   *
   * @param name Required. Example format: properties/1234/googleAdsLinks/5678
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteGoogleAdsLink(GoogleAdsLinkName name) {
    DeleteGoogleAdsLinkRequest request =
        DeleteGoogleAdsLinkRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    deleteGoogleAdsLink(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a GoogleAdsLink on a property
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   String name = GoogleAdsLinkName.of("[PROPERTY]", "[GOOGLE_ADS_LINK]").toString();
   *   analyticsAdminServiceClient.deleteGoogleAdsLink(name);
   * }
   * }</pre>
   *
   * @param name Required. Example format: properties/1234/googleAdsLinks/5678
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteGoogleAdsLink(String name) {
    DeleteGoogleAdsLinkRequest request =
        DeleteGoogleAdsLinkRequest.newBuilder().setName(name).build();
    deleteGoogleAdsLink(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a GoogleAdsLink on a property
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   DeleteGoogleAdsLinkRequest request =
   *       DeleteGoogleAdsLinkRequest.newBuilder()
   *           .setName(GoogleAdsLinkName.of("[PROPERTY]", "[GOOGLE_ADS_LINK]").toString())
   *           .build();
   *   analyticsAdminServiceClient.deleteGoogleAdsLink(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteGoogleAdsLink(DeleteGoogleAdsLinkRequest request) {
    deleteGoogleAdsLinkCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a GoogleAdsLink on a property
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   DeleteGoogleAdsLinkRequest request =
   *       DeleteGoogleAdsLinkRequest.newBuilder()
   *           .setName(GoogleAdsLinkName.of("[PROPERTY]", "[GOOGLE_ADS_LINK]").toString())
   *           .build();
   *   ApiFuture<Empty> future =
   *       analyticsAdminServiceClient.deleteGoogleAdsLinkCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteGoogleAdsLinkRequest, Empty> deleteGoogleAdsLinkCallable() {
    return stub.deleteGoogleAdsLinkCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists GoogleAdsLinks on a property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   PropertyName parent = PropertyName.of("[PROPERTY]");
   *   for (GoogleAdsLink element :
   *       analyticsAdminServiceClient.listGoogleAdsLinks(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Example format: properties/1234
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListGoogleAdsLinksPagedResponse listGoogleAdsLinks(PropertyName parent) {
    ListGoogleAdsLinksRequest request =
        ListGoogleAdsLinksRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listGoogleAdsLinks(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists GoogleAdsLinks on a property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   String parent = PropertyName.of("[PROPERTY]").toString();
   *   for (GoogleAdsLink element :
   *       analyticsAdminServiceClient.listGoogleAdsLinks(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Example format: properties/1234
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListGoogleAdsLinksPagedResponse listGoogleAdsLinks(String parent) {
    ListGoogleAdsLinksRequest request =
        ListGoogleAdsLinksRequest.newBuilder().setParent(parent).build();
    return listGoogleAdsLinks(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists GoogleAdsLinks on a property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   ListGoogleAdsLinksRequest request =
   *       ListGoogleAdsLinksRequest.newBuilder()
   *           .setParent(PropertyName.of("[PROPERTY]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (GoogleAdsLink element :
   *       analyticsAdminServiceClient.listGoogleAdsLinks(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListGoogleAdsLinksPagedResponse listGoogleAdsLinks(
      ListGoogleAdsLinksRequest request) {
    return listGoogleAdsLinksPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists GoogleAdsLinks on a property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   ListGoogleAdsLinksRequest request =
   *       ListGoogleAdsLinksRequest.newBuilder()
   *           .setParent(PropertyName.of("[PROPERTY]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<GoogleAdsLink> future =
   *       analyticsAdminServiceClient.listGoogleAdsLinksPagedCallable().futureCall(request);
   *   // Do something.
   *   for (GoogleAdsLink element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListGoogleAdsLinksRequest, ListGoogleAdsLinksPagedResponse>
      listGoogleAdsLinksPagedCallable() {
    return stub.listGoogleAdsLinksPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists GoogleAdsLinks on a property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   ListGoogleAdsLinksRequest request =
   *       ListGoogleAdsLinksRequest.newBuilder()
   *           .setParent(PropertyName.of("[PROPERTY]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListGoogleAdsLinksResponse response =
   *         analyticsAdminServiceClient.listGoogleAdsLinksCallable().call(request);
   *     for (GoogleAdsLink element : response.getGoogleAdsLinksList()) {
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
  public final UnaryCallable<ListGoogleAdsLinksRequest, ListGoogleAdsLinksResponse>
      listGoogleAdsLinksCallable() {
    return stub.listGoogleAdsLinksCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get data sharing settings on an account. Data sharing settings are singletons.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   DataSharingSettingsName name = DataSharingSettingsName.of("[ACCOUNT]");
   *   DataSharingSettings response = analyticsAdminServiceClient.getDataSharingSettings(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the settings to lookup. Format:
   *     accounts/{account}/dataSharingSettings Example: "accounts/1000/dataSharingSettings"
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DataSharingSettings getDataSharingSettings(DataSharingSettingsName name) {
    GetDataSharingSettingsRequest request =
        GetDataSharingSettingsRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getDataSharingSettings(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get data sharing settings on an account. Data sharing settings are singletons.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   String name = DataSharingSettingsName.of("[ACCOUNT]").toString();
   *   DataSharingSettings response = analyticsAdminServiceClient.getDataSharingSettings(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the settings to lookup. Format:
   *     accounts/{account}/dataSharingSettings Example: "accounts/1000/dataSharingSettings"
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DataSharingSettings getDataSharingSettings(String name) {
    GetDataSharingSettingsRequest request =
        GetDataSharingSettingsRequest.newBuilder().setName(name).build();
    return getDataSharingSettings(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get data sharing settings on an account. Data sharing settings are singletons.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   GetDataSharingSettingsRequest request =
   *       GetDataSharingSettingsRequest.newBuilder()
   *           .setName(DataSharingSettingsName.of("[ACCOUNT]").toString())
   *           .build();
   *   DataSharingSettings response = analyticsAdminServiceClient.getDataSharingSettings(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DataSharingSettings getDataSharingSettings(GetDataSharingSettingsRequest request) {
    return getDataSharingSettingsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get data sharing settings on an account. Data sharing settings are singletons.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   GetDataSharingSettingsRequest request =
   *       GetDataSharingSettingsRequest.newBuilder()
   *           .setName(DataSharingSettingsName.of("[ACCOUNT]").toString())
   *           .build();
   *   ApiFuture<DataSharingSettings> future =
   *       analyticsAdminServiceClient.getDataSharingSettingsCallable().futureCall(request);
   *   // Do something.
   *   DataSharingSettings response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetDataSharingSettingsRequest, DataSharingSettings>
      getDataSharingSettingsCallable() {
    return stub.getDataSharingSettingsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lookup for a single "GA4" MeasurementProtocolSecret.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   MeasurementProtocolSecretName name =
   *       MeasurementProtocolSecretName.of(
   *           "[PROPERTY]", "[DATA_STREAM]", "[MEASUREMENT_PROTOCOL_SECRET]");
   *   MeasurementProtocolSecret response =
   *       analyticsAdminServiceClient.getMeasurementProtocolSecret(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the measurement protocol secret to lookup. Format:
   *     properties/{property}/dataStreams/{dataStream}/measurementProtocolSecrets/{measurementProtocolSecret}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final MeasurementProtocolSecret getMeasurementProtocolSecret(
      MeasurementProtocolSecretName name) {
    GetMeasurementProtocolSecretRequest request =
        GetMeasurementProtocolSecretRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getMeasurementProtocolSecret(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lookup for a single "GA4" MeasurementProtocolSecret.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   String name =
   *       MeasurementProtocolSecretName.of(
   *               "[PROPERTY]", "[DATA_STREAM]", "[MEASUREMENT_PROTOCOL_SECRET]")
   *           .toString();
   *   MeasurementProtocolSecret response =
   *       analyticsAdminServiceClient.getMeasurementProtocolSecret(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the measurement protocol secret to lookup. Format:
   *     properties/{property}/dataStreams/{dataStream}/measurementProtocolSecrets/{measurementProtocolSecret}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final MeasurementProtocolSecret getMeasurementProtocolSecret(String name) {
    GetMeasurementProtocolSecretRequest request =
        GetMeasurementProtocolSecretRequest.newBuilder().setName(name).build();
    return getMeasurementProtocolSecret(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lookup for a single "GA4" MeasurementProtocolSecret.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   GetMeasurementProtocolSecretRequest request =
   *       GetMeasurementProtocolSecretRequest.newBuilder()
   *           .setName(
   *               MeasurementProtocolSecretName.of(
   *                       "[PROPERTY]", "[DATA_STREAM]", "[MEASUREMENT_PROTOCOL_SECRET]")
   *                   .toString())
   *           .build();
   *   MeasurementProtocolSecret response =
   *       analyticsAdminServiceClient.getMeasurementProtocolSecret(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final MeasurementProtocolSecret getMeasurementProtocolSecret(
      GetMeasurementProtocolSecretRequest request) {
    return getMeasurementProtocolSecretCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lookup for a single "GA4" MeasurementProtocolSecret.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   GetMeasurementProtocolSecretRequest request =
   *       GetMeasurementProtocolSecretRequest.newBuilder()
   *           .setName(
   *               MeasurementProtocolSecretName.of(
   *                       "[PROPERTY]", "[DATA_STREAM]", "[MEASUREMENT_PROTOCOL_SECRET]")
   *                   .toString())
   *           .build();
   *   ApiFuture<MeasurementProtocolSecret> future =
   *       analyticsAdminServiceClient.getMeasurementProtocolSecretCallable().futureCall(request);
   *   // Do something.
   *   MeasurementProtocolSecret response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetMeasurementProtocolSecretRequest, MeasurementProtocolSecret>
      getMeasurementProtocolSecretCallable() {
    return stub.getMeasurementProtocolSecretCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns child MeasurementProtocolSecrets under the specified parent Property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   DataStreamName parent = DataStreamName.of("[PROPERTY]", "[DATA_STREAM]");
   *   for (MeasurementProtocolSecret element :
   *       analyticsAdminServiceClient.listMeasurementProtocolSecrets(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the parent stream. Format:
   *     properties/{property}/dataStreams/{dataStream}/measurementProtocolSecrets
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListMeasurementProtocolSecretsPagedResponse listMeasurementProtocolSecrets(
      DataStreamName parent) {
    ListMeasurementProtocolSecretsRequest request =
        ListMeasurementProtocolSecretsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listMeasurementProtocolSecrets(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns child MeasurementProtocolSecrets under the specified parent Property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   String parent = DataStreamName.of("[PROPERTY]", "[DATA_STREAM]").toString();
   *   for (MeasurementProtocolSecret element :
   *       analyticsAdminServiceClient.listMeasurementProtocolSecrets(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the parent stream. Format:
   *     properties/{property}/dataStreams/{dataStream}/measurementProtocolSecrets
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListMeasurementProtocolSecretsPagedResponse listMeasurementProtocolSecrets(
      String parent) {
    ListMeasurementProtocolSecretsRequest request =
        ListMeasurementProtocolSecretsRequest.newBuilder().setParent(parent).build();
    return listMeasurementProtocolSecrets(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns child MeasurementProtocolSecrets under the specified parent Property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   ListMeasurementProtocolSecretsRequest request =
   *       ListMeasurementProtocolSecretsRequest.newBuilder()
   *           .setParent(DataStreamName.of("[PROPERTY]", "[DATA_STREAM]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (MeasurementProtocolSecret element :
   *       analyticsAdminServiceClient.listMeasurementProtocolSecrets(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListMeasurementProtocolSecretsPagedResponse listMeasurementProtocolSecrets(
      ListMeasurementProtocolSecretsRequest request) {
    return listMeasurementProtocolSecretsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns child MeasurementProtocolSecrets under the specified parent Property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   ListMeasurementProtocolSecretsRequest request =
   *       ListMeasurementProtocolSecretsRequest.newBuilder()
   *           .setParent(DataStreamName.of("[PROPERTY]", "[DATA_STREAM]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<MeasurementProtocolSecret> future =
   *       analyticsAdminServiceClient
   *           .listMeasurementProtocolSecretsPagedCallable()
   *           .futureCall(request);
   *   // Do something.
   *   for (MeasurementProtocolSecret element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<
          ListMeasurementProtocolSecretsRequest, ListMeasurementProtocolSecretsPagedResponse>
      listMeasurementProtocolSecretsPagedCallable() {
    return stub.listMeasurementProtocolSecretsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns child MeasurementProtocolSecrets under the specified parent Property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   ListMeasurementProtocolSecretsRequest request =
   *       ListMeasurementProtocolSecretsRequest.newBuilder()
   *           .setParent(DataStreamName.of("[PROPERTY]", "[DATA_STREAM]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListMeasurementProtocolSecretsResponse response =
   *         analyticsAdminServiceClient.listMeasurementProtocolSecretsCallable().call(request);
   *     for (MeasurementProtocolSecret element : response.getMeasurementProtocolSecretsList()) {
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
  public final UnaryCallable<
          ListMeasurementProtocolSecretsRequest, ListMeasurementProtocolSecretsResponse>
      listMeasurementProtocolSecretsCallable() {
    return stub.listMeasurementProtocolSecretsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a measurement protocol secret.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   DataStreamName parent = DataStreamName.of("[PROPERTY]", "[DATA_STREAM]");
   *   MeasurementProtocolSecret measurementProtocolSecret =
   *       MeasurementProtocolSecret.newBuilder().build();
   *   MeasurementProtocolSecret response =
   *       analyticsAdminServiceClient.createMeasurementProtocolSecret(
   *           parent, measurementProtocolSecret);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this secret will be created. Format:
   *     properties/{property}/dataStreams/{dataStream}
   * @param measurementProtocolSecret Required. The measurement protocol secret to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final MeasurementProtocolSecret createMeasurementProtocolSecret(
      DataStreamName parent, MeasurementProtocolSecret measurementProtocolSecret) {
    CreateMeasurementProtocolSecretRequest request =
        CreateMeasurementProtocolSecretRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setMeasurementProtocolSecret(measurementProtocolSecret)
            .build();
    return createMeasurementProtocolSecret(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a measurement protocol secret.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   String parent = DataStreamName.of("[PROPERTY]", "[DATA_STREAM]").toString();
   *   MeasurementProtocolSecret measurementProtocolSecret =
   *       MeasurementProtocolSecret.newBuilder().build();
   *   MeasurementProtocolSecret response =
   *       analyticsAdminServiceClient.createMeasurementProtocolSecret(
   *           parent, measurementProtocolSecret);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this secret will be created. Format:
   *     properties/{property}/dataStreams/{dataStream}
   * @param measurementProtocolSecret Required. The measurement protocol secret to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final MeasurementProtocolSecret createMeasurementProtocolSecret(
      String parent, MeasurementProtocolSecret measurementProtocolSecret) {
    CreateMeasurementProtocolSecretRequest request =
        CreateMeasurementProtocolSecretRequest.newBuilder()
            .setParent(parent)
            .setMeasurementProtocolSecret(measurementProtocolSecret)
            .build();
    return createMeasurementProtocolSecret(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a measurement protocol secret.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   CreateMeasurementProtocolSecretRequest request =
   *       CreateMeasurementProtocolSecretRequest.newBuilder()
   *           .setParent(DataStreamName.of("[PROPERTY]", "[DATA_STREAM]").toString())
   *           .setMeasurementProtocolSecret(MeasurementProtocolSecret.newBuilder().build())
   *           .build();
   *   MeasurementProtocolSecret response =
   *       analyticsAdminServiceClient.createMeasurementProtocolSecret(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final MeasurementProtocolSecret createMeasurementProtocolSecret(
      CreateMeasurementProtocolSecretRequest request) {
    return createMeasurementProtocolSecretCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a measurement protocol secret.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   CreateMeasurementProtocolSecretRequest request =
   *       CreateMeasurementProtocolSecretRequest.newBuilder()
   *           .setParent(DataStreamName.of("[PROPERTY]", "[DATA_STREAM]").toString())
   *           .setMeasurementProtocolSecret(MeasurementProtocolSecret.newBuilder().build())
   *           .build();
   *   ApiFuture<MeasurementProtocolSecret> future =
   *       analyticsAdminServiceClient.createMeasurementProtocolSecretCallable().futureCall(request);
   *   // Do something.
   *   MeasurementProtocolSecret response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateMeasurementProtocolSecretRequest, MeasurementProtocolSecret>
      createMeasurementProtocolSecretCallable() {
    return stub.createMeasurementProtocolSecretCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes target MeasurementProtocolSecret.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   MeasurementProtocolSecretName name =
   *       MeasurementProtocolSecretName.of(
   *           "[PROPERTY]", "[DATA_STREAM]", "[MEASUREMENT_PROTOCOL_SECRET]");
   *   analyticsAdminServiceClient.deleteMeasurementProtocolSecret(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the MeasurementProtocolSecret to delete. Format:
   *     properties/{property}/dataStreams/{dataStream}/measurementProtocolSecrets/{measurementProtocolSecret}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteMeasurementProtocolSecret(MeasurementProtocolSecretName name) {
    DeleteMeasurementProtocolSecretRequest request =
        DeleteMeasurementProtocolSecretRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    deleteMeasurementProtocolSecret(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes target MeasurementProtocolSecret.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   String name =
   *       MeasurementProtocolSecretName.of(
   *               "[PROPERTY]", "[DATA_STREAM]", "[MEASUREMENT_PROTOCOL_SECRET]")
   *           .toString();
   *   analyticsAdminServiceClient.deleteMeasurementProtocolSecret(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the MeasurementProtocolSecret to delete. Format:
   *     properties/{property}/dataStreams/{dataStream}/measurementProtocolSecrets/{measurementProtocolSecret}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteMeasurementProtocolSecret(String name) {
    DeleteMeasurementProtocolSecretRequest request =
        DeleteMeasurementProtocolSecretRequest.newBuilder().setName(name).build();
    deleteMeasurementProtocolSecret(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes target MeasurementProtocolSecret.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   DeleteMeasurementProtocolSecretRequest request =
   *       DeleteMeasurementProtocolSecretRequest.newBuilder()
   *           .setName(
   *               MeasurementProtocolSecretName.of(
   *                       "[PROPERTY]", "[DATA_STREAM]", "[MEASUREMENT_PROTOCOL_SECRET]")
   *                   .toString())
   *           .build();
   *   analyticsAdminServiceClient.deleteMeasurementProtocolSecret(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteMeasurementProtocolSecret(
      DeleteMeasurementProtocolSecretRequest request) {
    deleteMeasurementProtocolSecretCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes target MeasurementProtocolSecret.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   DeleteMeasurementProtocolSecretRequest request =
   *       DeleteMeasurementProtocolSecretRequest.newBuilder()
   *           .setName(
   *               MeasurementProtocolSecretName.of(
   *                       "[PROPERTY]", "[DATA_STREAM]", "[MEASUREMENT_PROTOCOL_SECRET]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Empty> future =
   *       analyticsAdminServiceClient.deleteMeasurementProtocolSecretCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteMeasurementProtocolSecretRequest, Empty>
      deleteMeasurementProtocolSecretCallable() {
    return stub.deleteMeasurementProtocolSecretCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a measurement protocol secret.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   MeasurementProtocolSecret measurementProtocolSecret =
   *       MeasurementProtocolSecret.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   MeasurementProtocolSecret response =
   *       analyticsAdminServiceClient.updateMeasurementProtocolSecret(
   *           measurementProtocolSecret, updateMask);
   * }
   * }</pre>
   *
   * @param measurementProtocolSecret Required. The measurement protocol secret to update.
   * @param updateMask Required. The list of fields to be updated. Omitted fields will not be
   *     updated.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final MeasurementProtocolSecret updateMeasurementProtocolSecret(
      MeasurementProtocolSecret measurementProtocolSecret, FieldMask updateMask) {
    UpdateMeasurementProtocolSecretRequest request =
        UpdateMeasurementProtocolSecretRequest.newBuilder()
            .setMeasurementProtocolSecret(measurementProtocolSecret)
            .setUpdateMask(updateMask)
            .build();
    return updateMeasurementProtocolSecret(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a measurement protocol secret.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   UpdateMeasurementProtocolSecretRequest request =
   *       UpdateMeasurementProtocolSecretRequest.newBuilder()
   *           .setMeasurementProtocolSecret(MeasurementProtocolSecret.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   MeasurementProtocolSecret response =
   *       analyticsAdminServiceClient.updateMeasurementProtocolSecret(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final MeasurementProtocolSecret updateMeasurementProtocolSecret(
      UpdateMeasurementProtocolSecretRequest request) {
    return updateMeasurementProtocolSecretCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a measurement protocol secret.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   UpdateMeasurementProtocolSecretRequest request =
   *       UpdateMeasurementProtocolSecretRequest.newBuilder()
   *           .setMeasurementProtocolSecret(MeasurementProtocolSecret.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<MeasurementProtocolSecret> future =
   *       analyticsAdminServiceClient.updateMeasurementProtocolSecretCallable().futureCall(request);
   *   // Do something.
   *   MeasurementProtocolSecret response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateMeasurementProtocolSecretRequest, MeasurementProtocolSecret>
      updateMeasurementProtocolSecretCallable() {
    return stub.updateMeasurementProtocolSecretCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Acknowledges the terms of user data collection for the specified property.
   *
   * <p>This acknowledgement must be completed (either in the Google Analytics UI or through this
   * API) before MeasurementProtocolSecret resources may be created.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   AcknowledgeUserDataCollectionRequest request =
   *       AcknowledgeUserDataCollectionRequest.newBuilder()
   *           .setProperty(PropertyName.of("[PROPERTY]").toString())
   *           .setAcknowledgement("acknowledgement1769490938")
   *           .build();
   *   AcknowledgeUserDataCollectionResponse response =
   *       analyticsAdminServiceClient.acknowledgeUserDataCollection(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AcknowledgeUserDataCollectionResponse acknowledgeUserDataCollection(
      AcknowledgeUserDataCollectionRequest request) {
    return acknowledgeUserDataCollectionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Acknowledges the terms of user data collection for the specified property.
   *
   * <p>This acknowledgement must be completed (either in the Google Analytics UI or through this
   * API) before MeasurementProtocolSecret resources may be created.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   AcknowledgeUserDataCollectionRequest request =
   *       AcknowledgeUserDataCollectionRequest.newBuilder()
   *           .setProperty(PropertyName.of("[PROPERTY]").toString())
   *           .setAcknowledgement("acknowledgement1769490938")
   *           .build();
   *   ApiFuture<AcknowledgeUserDataCollectionResponse> future =
   *       analyticsAdminServiceClient.acknowledgeUserDataCollectionCallable().futureCall(request);
   *   // Do something.
   *   AcknowledgeUserDataCollectionResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<
          AcknowledgeUserDataCollectionRequest, AcknowledgeUserDataCollectionResponse>
      acknowledgeUserDataCollectionCallable() {
    return stub.acknowledgeUserDataCollectionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Looks up a single SKAdNetworkConversionValueSchema.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   SKAdNetworkConversionValueSchemaName name =
   *       SKAdNetworkConversionValueSchemaName.of(
   *           "[PROPERTY]", "[DATA_STREAM]", "[SKADNETWORK_CONVERSION_VALUE_SCHEMA]");
   *   SKAdNetworkConversionValueSchema response =
   *       analyticsAdminServiceClient.getSKAdNetworkConversionValueSchema(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of SKAdNetwork conversion value schema to look up.
   *     Format:
   *     properties/{property}/dataStreams/{dataStream}/sKAdNetworkConversionValueSchema/{skadnetwork_conversion_value_schema}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SKAdNetworkConversionValueSchema getSKAdNetworkConversionValueSchema(
      SKAdNetworkConversionValueSchemaName name) {
    GetSKAdNetworkConversionValueSchemaRequest request =
        GetSKAdNetworkConversionValueSchemaRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getSKAdNetworkConversionValueSchema(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Looks up a single SKAdNetworkConversionValueSchema.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   String name =
   *       SKAdNetworkConversionValueSchemaName.of(
   *               "[PROPERTY]", "[DATA_STREAM]", "[SKADNETWORK_CONVERSION_VALUE_SCHEMA]")
   *           .toString();
   *   SKAdNetworkConversionValueSchema response =
   *       analyticsAdminServiceClient.getSKAdNetworkConversionValueSchema(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of SKAdNetwork conversion value schema to look up.
   *     Format:
   *     properties/{property}/dataStreams/{dataStream}/sKAdNetworkConversionValueSchema/{skadnetwork_conversion_value_schema}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SKAdNetworkConversionValueSchema getSKAdNetworkConversionValueSchema(String name) {
    GetSKAdNetworkConversionValueSchemaRequest request =
        GetSKAdNetworkConversionValueSchemaRequest.newBuilder().setName(name).build();
    return getSKAdNetworkConversionValueSchema(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Looks up a single SKAdNetworkConversionValueSchema.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   GetSKAdNetworkConversionValueSchemaRequest request =
   *       GetSKAdNetworkConversionValueSchemaRequest.newBuilder()
   *           .setName(
   *               SKAdNetworkConversionValueSchemaName.of(
   *                       "[PROPERTY]", "[DATA_STREAM]", "[SKADNETWORK_CONVERSION_VALUE_SCHEMA]")
   *                   .toString())
   *           .build();
   *   SKAdNetworkConversionValueSchema response =
   *       analyticsAdminServiceClient.getSKAdNetworkConversionValueSchema(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SKAdNetworkConversionValueSchema getSKAdNetworkConversionValueSchema(
      GetSKAdNetworkConversionValueSchemaRequest request) {
    return getSKAdNetworkConversionValueSchemaCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Looks up a single SKAdNetworkConversionValueSchema.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   GetSKAdNetworkConversionValueSchemaRequest request =
   *       GetSKAdNetworkConversionValueSchemaRequest.newBuilder()
   *           .setName(
   *               SKAdNetworkConversionValueSchemaName.of(
   *                       "[PROPERTY]", "[DATA_STREAM]", "[SKADNETWORK_CONVERSION_VALUE_SCHEMA]")
   *                   .toString())
   *           .build();
   *   ApiFuture<SKAdNetworkConversionValueSchema> future =
   *       analyticsAdminServiceClient
   *           .getSKAdNetworkConversionValueSchemaCallable()
   *           .futureCall(request);
   *   // Do something.
   *   SKAdNetworkConversionValueSchema response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<
          GetSKAdNetworkConversionValueSchemaRequest, SKAdNetworkConversionValueSchema>
      getSKAdNetworkConversionValueSchemaCallable() {
    return stub.getSKAdNetworkConversionValueSchemaCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a SKAdNetworkConversionValueSchema.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   DataStreamName parent = DataStreamName.of("[PROPERTY]", "[DATA_STREAM]");
   *   SKAdNetworkConversionValueSchema skadnetworkConversionValueSchema =
   *       SKAdNetworkConversionValueSchema.newBuilder().build();
   *   SKAdNetworkConversionValueSchema response =
   *       analyticsAdminServiceClient.createSKAdNetworkConversionValueSchema(
   *           parent, skadnetworkConversionValueSchema);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this schema will be created. Format:
   *     properties/{property}/dataStreams/{dataStream}
   * @param skadnetworkConversionValueSchema Required. SKAdNetwork conversion value schema to
   *     create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SKAdNetworkConversionValueSchema createSKAdNetworkConversionValueSchema(
      DataStreamName parent, SKAdNetworkConversionValueSchema skadnetworkConversionValueSchema) {
    CreateSKAdNetworkConversionValueSchemaRequest request =
        CreateSKAdNetworkConversionValueSchemaRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setSkadnetworkConversionValueSchema(skadnetworkConversionValueSchema)
            .build();
    return createSKAdNetworkConversionValueSchema(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a SKAdNetworkConversionValueSchema.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   String parent = DataStreamName.of("[PROPERTY]", "[DATA_STREAM]").toString();
   *   SKAdNetworkConversionValueSchema skadnetworkConversionValueSchema =
   *       SKAdNetworkConversionValueSchema.newBuilder().build();
   *   SKAdNetworkConversionValueSchema response =
   *       analyticsAdminServiceClient.createSKAdNetworkConversionValueSchema(
   *           parent, skadnetworkConversionValueSchema);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this schema will be created. Format:
   *     properties/{property}/dataStreams/{dataStream}
   * @param skadnetworkConversionValueSchema Required. SKAdNetwork conversion value schema to
   *     create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SKAdNetworkConversionValueSchema createSKAdNetworkConversionValueSchema(
      String parent, SKAdNetworkConversionValueSchema skadnetworkConversionValueSchema) {
    CreateSKAdNetworkConversionValueSchemaRequest request =
        CreateSKAdNetworkConversionValueSchemaRequest.newBuilder()
            .setParent(parent)
            .setSkadnetworkConversionValueSchema(skadnetworkConversionValueSchema)
            .build();
    return createSKAdNetworkConversionValueSchema(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a SKAdNetworkConversionValueSchema.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   CreateSKAdNetworkConversionValueSchemaRequest request =
   *       CreateSKAdNetworkConversionValueSchemaRequest.newBuilder()
   *           .setParent(DataStreamName.of("[PROPERTY]", "[DATA_STREAM]").toString())
   *           .setSkadnetworkConversionValueSchema(
   *               SKAdNetworkConversionValueSchema.newBuilder().build())
   *           .build();
   *   SKAdNetworkConversionValueSchema response =
   *       analyticsAdminServiceClient.createSKAdNetworkConversionValueSchema(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SKAdNetworkConversionValueSchema createSKAdNetworkConversionValueSchema(
      CreateSKAdNetworkConversionValueSchemaRequest request) {
    return createSKAdNetworkConversionValueSchemaCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a SKAdNetworkConversionValueSchema.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   CreateSKAdNetworkConversionValueSchemaRequest request =
   *       CreateSKAdNetworkConversionValueSchemaRequest.newBuilder()
   *           .setParent(DataStreamName.of("[PROPERTY]", "[DATA_STREAM]").toString())
   *           .setSkadnetworkConversionValueSchema(
   *               SKAdNetworkConversionValueSchema.newBuilder().build())
   *           .build();
   *   ApiFuture<SKAdNetworkConversionValueSchema> future =
   *       analyticsAdminServiceClient
   *           .createSKAdNetworkConversionValueSchemaCallable()
   *           .futureCall(request);
   *   // Do something.
   *   SKAdNetworkConversionValueSchema response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<
          CreateSKAdNetworkConversionValueSchemaRequest, SKAdNetworkConversionValueSchema>
      createSKAdNetworkConversionValueSchemaCallable() {
    return stub.createSKAdNetworkConversionValueSchemaCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes target SKAdNetworkConversionValueSchema.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   SKAdNetworkConversionValueSchemaName name =
   *       SKAdNetworkConversionValueSchemaName.of(
   *           "[PROPERTY]", "[DATA_STREAM]", "[SKADNETWORK_CONVERSION_VALUE_SCHEMA]");
   *   analyticsAdminServiceClient.deleteSKAdNetworkConversionValueSchema(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the SKAdNetworkConversionValueSchema to delete. Format:
   *     properties/{property}/dataStreams/{dataStream}/sKAdNetworkConversionValueSchema/{skadnetwork_conversion_value_schema}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteSKAdNetworkConversionValueSchema(
      SKAdNetworkConversionValueSchemaName name) {
    DeleteSKAdNetworkConversionValueSchemaRequest request =
        DeleteSKAdNetworkConversionValueSchemaRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    deleteSKAdNetworkConversionValueSchema(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes target SKAdNetworkConversionValueSchema.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   String name =
   *       SKAdNetworkConversionValueSchemaName.of(
   *               "[PROPERTY]", "[DATA_STREAM]", "[SKADNETWORK_CONVERSION_VALUE_SCHEMA]")
   *           .toString();
   *   analyticsAdminServiceClient.deleteSKAdNetworkConversionValueSchema(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the SKAdNetworkConversionValueSchema to delete. Format:
   *     properties/{property}/dataStreams/{dataStream}/sKAdNetworkConversionValueSchema/{skadnetwork_conversion_value_schema}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteSKAdNetworkConversionValueSchema(String name) {
    DeleteSKAdNetworkConversionValueSchemaRequest request =
        DeleteSKAdNetworkConversionValueSchemaRequest.newBuilder().setName(name).build();
    deleteSKAdNetworkConversionValueSchema(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes target SKAdNetworkConversionValueSchema.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   DeleteSKAdNetworkConversionValueSchemaRequest request =
   *       DeleteSKAdNetworkConversionValueSchemaRequest.newBuilder()
   *           .setName(
   *               SKAdNetworkConversionValueSchemaName.of(
   *                       "[PROPERTY]", "[DATA_STREAM]", "[SKADNETWORK_CONVERSION_VALUE_SCHEMA]")
   *                   .toString())
   *           .build();
   *   analyticsAdminServiceClient.deleteSKAdNetworkConversionValueSchema(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteSKAdNetworkConversionValueSchema(
      DeleteSKAdNetworkConversionValueSchemaRequest request) {
    deleteSKAdNetworkConversionValueSchemaCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes target SKAdNetworkConversionValueSchema.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   DeleteSKAdNetworkConversionValueSchemaRequest request =
   *       DeleteSKAdNetworkConversionValueSchemaRequest.newBuilder()
   *           .setName(
   *               SKAdNetworkConversionValueSchemaName.of(
   *                       "[PROPERTY]", "[DATA_STREAM]", "[SKADNETWORK_CONVERSION_VALUE_SCHEMA]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Empty> future =
   *       analyticsAdminServiceClient
   *           .deleteSKAdNetworkConversionValueSchemaCallable()
   *           .futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteSKAdNetworkConversionValueSchemaRequest, Empty>
      deleteSKAdNetworkConversionValueSchemaCallable() {
    return stub.deleteSKAdNetworkConversionValueSchemaCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a SKAdNetworkConversionValueSchema.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   SKAdNetworkConversionValueSchema skadnetworkConversionValueSchema =
   *       SKAdNetworkConversionValueSchema.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   SKAdNetworkConversionValueSchema response =
   *       analyticsAdminServiceClient.updateSKAdNetworkConversionValueSchema(
   *           skadnetworkConversionValueSchema, updateMask);
   * }
   * }</pre>
   *
   * @param skadnetworkConversionValueSchema Required. SKAdNetwork conversion value schema to
   *     update.
   * @param updateMask Required. The list of fields to be updated. Omitted fields will not be
   *     updated.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SKAdNetworkConversionValueSchema updateSKAdNetworkConversionValueSchema(
      SKAdNetworkConversionValueSchema skadnetworkConversionValueSchema, FieldMask updateMask) {
    UpdateSKAdNetworkConversionValueSchemaRequest request =
        UpdateSKAdNetworkConversionValueSchemaRequest.newBuilder()
            .setSkadnetworkConversionValueSchema(skadnetworkConversionValueSchema)
            .setUpdateMask(updateMask)
            .build();
    return updateSKAdNetworkConversionValueSchema(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a SKAdNetworkConversionValueSchema.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   UpdateSKAdNetworkConversionValueSchemaRequest request =
   *       UpdateSKAdNetworkConversionValueSchemaRequest.newBuilder()
   *           .setSkadnetworkConversionValueSchema(
   *               SKAdNetworkConversionValueSchema.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   SKAdNetworkConversionValueSchema response =
   *       analyticsAdminServiceClient.updateSKAdNetworkConversionValueSchema(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SKAdNetworkConversionValueSchema updateSKAdNetworkConversionValueSchema(
      UpdateSKAdNetworkConversionValueSchemaRequest request) {
    return updateSKAdNetworkConversionValueSchemaCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a SKAdNetworkConversionValueSchema.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   UpdateSKAdNetworkConversionValueSchemaRequest request =
   *       UpdateSKAdNetworkConversionValueSchemaRequest.newBuilder()
   *           .setSkadnetworkConversionValueSchema(
   *               SKAdNetworkConversionValueSchema.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<SKAdNetworkConversionValueSchema> future =
   *       analyticsAdminServiceClient
   *           .updateSKAdNetworkConversionValueSchemaCallable()
   *           .futureCall(request);
   *   // Do something.
   *   SKAdNetworkConversionValueSchema response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<
          UpdateSKAdNetworkConversionValueSchemaRequest, SKAdNetworkConversionValueSchema>
      updateSKAdNetworkConversionValueSchemaCallable() {
    return stub.updateSKAdNetworkConversionValueSchemaCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists SKAdNetworkConversionValueSchema on a stream. Properties can have at most one
   * SKAdNetworkConversionValueSchema.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   DataStreamName parent = DataStreamName.of("[PROPERTY]", "[DATA_STREAM]");
   *   for (SKAdNetworkConversionValueSchema element :
   *       analyticsAdminServiceClient.listSKAdNetworkConversionValueSchemas(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The DataStream resource to list schemas for. Format:
   *     properties/{property_id}/dataStreams/{dataStream} Example: properties/1234/dataStreams/5678
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSKAdNetworkConversionValueSchemasPagedResponse
      listSKAdNetworkConversionValueSchemas(DataStreamName parent) {
    ListSKAdNetworkConversionValueSchemasRequest request =
        ListSKAdNetworkConversionValueSchemasRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listSKAdNetworkConversionValueSchemas(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists SKAdNetworkConversionValueSchema on a stream. Properties can have at most one
   * SKAdNetworkConversionValueSchema.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   String parent = DataStreamName.of("[PROPERTY]", "[DATA_STREAM]").toString();
   *   for (SKAdNetworkConversionValueSchema element :
   *       analyticsAdminServiceClient.listSKAdNetworkConversionValueSchemas(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The DataStream resource to list schemas for. Format:
   *     properties/{property_id}/dataStreams/{dataStream} Example: properties/1234/dataStreams/5678
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSKAdNetworkConversionValueSchemasPagedResponse
      listSKAdNetworkConversionValueSchemas(String parent) {
    ListSKAdNetworkConversionValueSchemasRequest request =
        ListSKAdNetworkConversionValueSchemasRequest.newBuilder().setParent(parent).build();
    return listSKAdNetworkConversionValueSchemas(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists SKAdNetworkConversionValueSchema on a stream. Properties can have at most one
   * SKAdNetworkConversionValueSchema.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   ListSKAdNetworkConversionValueSchemasRequest request =
   *       ListSKAdNetworkConversionValueSchemasRequest.newBuilder()
   *           .setParent(DataStreamName.of("[PROPERTY]", "[DATA_STREAM]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (SKAdNetworkConversionValueSchema element :
   *       analyticsAdminServiceClient.listSKAdNetworkConversionValueSchemas(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSKAdNetworkConversionValueSchemasPagedResponse
      listSKAdNetworkConversionValueSchemas(ListSKAdNetworkConversionValueSchemasRequest request) {
    return listSKAdNetworkConversionValueSchemasPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists SKAdNetworkConversionValueSchema on a stream. Properties can have at most one
   * SKAdNetworkConversionValueSchema.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   ListSKAdNetworkConversionValueSchemasRequest request =
   *       ListSKAdNetworkConversionValueSchemasRequest.newBuilder()
   *           .setParent(DataStreamName.of("[PROPERTY]", "[DATA_STREAM]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<SKAdNetworkConversionValueSchema> future =
   *       analyticsAdminServiceClient
   *           .listSKAdNetworkConversionValueSchemasPagedCallable()
   *           .futureCall(request);
   *   // Do something.
   *   for (SKAdNetworkConversionValueSchema element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<
          ListSKAdNetworkConversionValueSchemasRequest,
          ListSKAdNetworkConversionValueSchemasPagedResponse>
      listSKAdNetworkConversionValueSchemasPagedCallable() {
    return stub.listSKAdNetworkConversionValueSchemasPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists SKAdNetworkConversionValueSchema on a stream. Properties can have at most one
   * SKAdNetworkConversionValueSchema.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   ListSKAdNetworkConversionValueSchemasRequest request =
   *       ListSKAdNetworkConversionValueSchemasRequest.newBuilder()
   *           .setParent(DataStreamName.of("[PROPERTY]", "[DATA_STREAM]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListSKAdNetworkConversionValueSchemasResponse response =
   *         analyticsAdminServiceClient
   *             .listSKAdNetworkConversionValueSchemasCallable()
   *             .call(request);
   *     for (SKAdNetworkConversionValueSchema element :
   *         response.getSkadnetworkConversionValueSchemasList()) {
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
  public final UnaryCallable<
          ListSKAdNetworkConversionValueSchemasRequest,
          ListSKAdNetworkConversionValueSchemasResponse>
      listSKAdNetworkConversionValueSchemasCallable() {
    return stub.listSKAdNetworkConversionValueSchemasCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Searches through all changes to an account or its children given the specified set of filters.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   SearchChangeHistoryEventsRequest request =
   *       SearchChangeHistoryEventsRequest.newBuilder()
   *           .setAccount(AccountName.of("[ACCOUNT]").toString())
   *           .setProperty(PropertyName.of("[PROPERTY]").toString())
   *           .addAllResourceType(new ArrayList<ChangeHistoryResourceType>())
   *           .addAllAction(new ArrayList<ActionType>())
   *           .addAllActorEmail(new ArrayList<String>())
   *           .setEarliestChangeTime(Timestamp.newBuilder().build())
   *           .setLatestChangeTime(Timestamp.newBuilder().build())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (ChangeHistoryEvent element :
   *       analyticsAdminServiceClient.searchChangeHistoryEvents(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SearchChangeHistoryEventsPagedResponse searchChangeHistoryEvents(
      SearchChangeHistoryEventsRequest request) {
    return searchChangeHistoryEventsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Searches through all changes to an account or its children given the specified set of filters.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   SearchChangeHistoryEventsRequest request =
   *       SearchChangeHistoryEventsRequest.newBuilder()
   *           .setAccount(AccountName.of("[ACCOUNT]").toString())
   *           .setProperty(PropertyName.of("[PROPERTY]").toString())
   *           .addAllResourceType(new ArrayList<ChangeHistoryResourceType>())
   *           .addAllAction(new ArrayList<ActionType>())
   *           .addAllActorEmail(new ArrayList<String>())
   *           .setEarliestChangeTime(Timestamp.newBuilder().build())
   *           .setLatestChangeTime(Timestamp.newBuilder().build())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<ChangeHistoryEvent> future =
   *       analyticsAdminServiceClient.searchChangeHistoryEventsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (ChangeHistoryEvent element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<
          SearchChangeHistoryEventsRequest, SearchChangeHistoryEventsPagedResponse>
      searchChangeHistoryEventsPagedCallable() {
    return stub.searchChangeHistoryEventsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Searches through all changes to an account or its children given the specified set of filters.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   SearchChangeHistoryEventsRequest request =
   *       SearchChangeHistoryEventsRequest.newBuilder()
   *           .setAccount(AccountName.of("[ACCOUNT]").toString())
   *           .setProperty(PropertyName.of("[PROPERTY]").toString())
   *           .addAllResourceType(new ArrayList<ChangeHistoryResourceType>())
   *           .addAllAction(new ArrayList<ActionType>())
   *           .addAllActorEmail(new ArrayList<String>())
   *           .setEarliestChangeTime(Timestamp.newBuilder().build())
   *           .setLatestChangeTime(Timestamp.newBuilder().build())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     SearchChangeHistoryEventsResponse response =
   *         analyticsAdminServiceClient.searchChangeHistoryEventsCallable().call(request);
   *     for (ChangeHistoryEvent element : response.getChangeHistoryEventsList()) {
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
  public final UnaryCallable<SearchChangeHistoryEventsRequest, SearchChangeHistoryEventsResponse>
      searchChangeHistoryEventsCallable() {
    return stub.searchChangeHistoryEventsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lookup for Google Signals settings for a property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   GoogleSignalsSettingsName name = GoogleSignalsSettingsName.of("[PROPERTY]");
   *   GoogleSignalsSettings response = analyticsAdminServiceClient.getGoogleSignalsSettings(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the google signals settings to retrieve. Format:
   *     properties/{property}/googleSignalsSettings
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GoogleSignalsSettings getGoogleSignalsSettings(GoogleSignalsSettingsName name) {
    GetGoogleSignalsSettingsRequest request =
        GetGoogleSignalsSettingsRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getGoogleSignalsSettings(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lookup for Google Signals settings for a property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   String name = GoogleSignalsSettingsName.of("[PROPERTY]").toString();
   *   GoogleSignalsSettings response = analyticsAdminServiceClient.getGoogleSignalsSettings(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the google signals settings to retrieve. Format:
   *     properties/{property}/googleSignalsSettings
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GoogleSignalsSettings getGoogleSignalsSettings(String name) {
    GetGoogleSignalsSettingsRequest request =
        GetGoogleSignalsSettingsRequest.newBuilder().setName(name).build();
    return getGoogleSignalsSettings(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lookup for Google Signals settings for a property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   GetGoogleSignalsSettingsRequest request =
   *       GetGoogleSignalsSettingsRequest.newBuilder()
   *           .setName(GoogleSignalsSettingsName.of("[PROPERTY]").toString())
   *           .build();
   *   GoogleSignalsSettings response =
   *       analyticsAdminServiceClient.getGoogleSignalsSettings(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GoogleSignalsSettings getGoogleSignalsSettings(
      GetGoogleSignalsSettingsRequest request) {
    return getGoogleSignalsSettingsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lookup for Google Signals settings for a property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   GetGoogleSignalsSettingsRequest request =
   *       GetGoogleSignalsSettingsRequest.newBuilder()
   *           .setName(GoogleSignalsSettingsName.of("[PROPERTY]").toString())
   *           .build();
   *   ApiFuture<GoogleSignalsSettings> future =
   *       analyticsAdminServiceClient.getGoogleSignalsSettingsCallable().futureCall(request);
   *   // Do something.
   *   GoogleSignalsSettings response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetGoogleSignalsSettingsRequest, GoogleSignalsSettings>
      getGoogleSignalsSettingsCallable() {
    return stub.getGoogleSignalsSettingsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates Google Signals settings for a property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   GoogleSignalsSettings googleSignalsSettings = GoogleSignalsSettings.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   GoogleSignalsSettings response =
   *       analyticsAdminServiceClient.updateGoogleSignalsSettings(
   *           googleSignalsSettings, updateMask);
   * }
   * }</pre>
   *
   * @param googleSignalsSettings Required. The settings to update. The `name` field is used to
   *     identify the settings to be updated.
   * @param updateMask Required. The list of fields to be updated. Field names must be in snake case
   *     (e.g., "field_to_update"). Omitted fields will not be updated. To replace the entire
   *     entity, use one path with the string "&#42;" to match all fields.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GoogleSignalsSettings updateGoogleSignalsSettings(
      GoogleSignalsSettings googleSignalsSettings, FieldMask updateMask) {
    UpdateGoogleSignalsSettingsRequest request =
        UpdateGoogleSignalsSettingsRequest.newBuilder()
            .setGoogleSignalsSettings(googleSignalsSettings)
            .setUpdateMask(updateMask)
            .build();
    return updateGoogleSignalsSettings(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates Google Signals settings for a property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   UpdateGoogleSignalsSettingsRequest request =
   *       UpdateGoogleSignalsSettingsRequest.newBuilder()
   *           .setGoogleSignalsSettings(GoogleSignalsSettings.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   GoogleSignalsSettings response =
   *       analyticsAdminServiceClient.updateGoogleSignalsSettings(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GoogleSignalsSettings updateGoogleSignalsSettings(
      UpdateGoogleSignalsSettingsRequest request) {
    return updateGoogleSignalsSettingsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates Google Signals settings for a property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   UpdateGoogleSignalsSettingsRequest request =
   *       UpdateGoogleSignalsSettingsRequest.newBuilder()
   *           .setGoogleSignalsSettings(GoogleSignalsSettings.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<GoogleSignalsSettings> future =
   *       analyticsAdminServiceClient.updateGoogleSignalsSettingsCallable().futureCall(request);
   *   // Do something.
   *   GoogleSignalsSettings response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateGoogleSignalsSettingsRequest, GoogleSignalsSettings>
      updateGoogleSignalsSettingsCallable() {
    return stub.updateGoogleSignalsSettingsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a conversion event with the specified attributes.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   PropertyName parent = PropertyName.of("[PROPERTY]");
   *   ConversionEvent conversionEvent = ConversionEvent.newBuilder().build();
   *   ConversionEvent response =
   *       analyticsAdminServiceClient.createConversionEvent(parent, conversionEvent);
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the parent property where this conversion event
   *     will be created. Format: properties/123
   * @param conversionEvent Required. The conversion event to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ConversionEvent createConversionEvent(
      PropertyName parent, ConversionEvent conversionEvent) {
    CreateConversionEventRequest request =
        CreateConversionEventRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setConversionEvent(conversionEvent)
            .build();
    return createConversionEvent(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a conversion event with the specified attributes.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   String parent = PropertyName.of("[PROPERTY]").toString();
   *   ConversionEvent conversionEvent = ConversionEvent.newBuilder().build();
   *   ConversionEvent response =
   *       analyticsAdminServiceClient.createConversionEvent(parent, conversionEvent);
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the parent property where this conversion event
   *     will be created. Format: properties/123
   * @param conversionEvent Required. The conversion event to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ConversionEvent createConversionEvent(
      String parent, ConversionEvent conversionEvent) {
    CreateConversionEventRequest request =
        CreateConversionEventRequest.newBuilder()
            .setParent(parent)
            .setConversionEvent(conversionEvent)
            .build();
    return createConversionEvent(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a conversion event with the specified attributes.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   CreateConversionEventRequest request =
   *       CreateConversionEventRequest.newBuilder()
   *           .setConversionEvent(ConversionEvent.newBuilder().build())
   *           .setParent(PropertyName.of("[PROPERTY]").toString())
   *           .build();
   *   ConversionEvent response = analyticsAdminServiceClient.createConversionEvent(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ConversionEvent createConversionEvent(CreateConversionEventRequest request) {
    return createConversionEventCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a conversion event with the specified attributes.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   CreateConversionEventRequest request =
   *       CreateConversionEventRequest.newBuilder()
   *           .setConversionEvent(ConversionEvent.newBuilder().build())
   *           .setParent(PropertyName.of("[PROPERTY]").toString())
   *           .build();
   *   ApiFuture<ConversionEvent> future =
   *       analyticsAdminServiceClient.createConversionEventCallable().futureCall(request);
   *   // Do something.
   *   ConversionEvent response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateConversionEventRequest, ConversionEvent>
      createConversionEventCallable() {
    return stub.createConversionEventCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a conversion event with the specified attributes.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   ConversionEvent conversionEvent = ConversionEvent.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   ConversionEvent response =
   *       analyticsAdminServiceClient.updateConversionEvent(conversionEvent, updateMask);
   * }
   * }</pre>
   *
   * @param conversionEvent Required. The conversion event to update. The `name` field is used to
   *     identify the settings to be updated.
   * @param updateMask Required. The list of fields to be updated. Field names must be in snake case
   *     (e.g., "field_to_update"). Omitted fields will not be updated. To replace the entire
   *     entity, use one path with the string "&#42;" to match all fields.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ConversionEvent updateConversionEvent(
      ConversionEvent conversionEvent, FieldMask updateMask) {
    UpdateConversionEventRequest request =
        UpdateConversionEventRequest.newBuilder()
            .setConversionEvent(conversionEvent)
            .setUpdateMask(updateMask)
            .build();
    return updateConversionEvent(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a conversion event with the specified attributes.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   UpdateConversionEventRequest request =
   *       UpdateConversionEventRequest.newBuilder()
   *           .setConversionEvent(ConversionEvent.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ConversionEvent response = analyticsAdminServiceClient.updateConversionEvent(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ConversionEvent updateConversionEvent(UpdateConversionEventRequest request) {
    return updateConversionEventCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a conversion event with the specified attributes.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   UpdateConversionEventRequest request =
   *       UpdateConversionEventRequest.newBuilder()
   *           .setConversionEvent(ConversionEvent.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<ConversionEvent> future =
   *       analyticsAdminServiceClient.updateConversionEventCallable().futureCall(request);
   *   // Do something.
   *   ConversionEvent response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateConversionEventRequest, ConversionEvent>
      updateConversionEventCallable() {
    return stub.updateConversionEventCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve a single conversion event.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   ConversionEventName name = ConversionEventName.of("[PROPERTY]", "[CONVERSION_EVENT]");
   *   ConversionEvent response = analyticsAdminServiceClient.getConversionEvent(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the conversion event to retrieve. Format:
   *     properties/{property}/conversionEvents/{conversion_event} Example:
   *     "properties/123/conversionEvents/456"
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ConversionEvent getConversionEvent(ConversionEventName name) {
    GetConversionEventRequest request =
        GetConversionEventRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getConversionEvent(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve a single conversion event.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   String name = ConversionEventName.of("[PROPERTY]", "[CONVERSION_EVENT]").toString();
   *   ConversionEvent response = analyticsAdminServiceClient.getConversionEvent(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the conversion event to retrieve. Format:
   *     properties/{property}/conversionEvents/{conversion_event} Example:
   *     "properties/123/conversionEvents/456"
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ConversionEvent getConversionEvent(String name) {
    GetConversionEventRequest request =
        GetConversionEventRequest.newBuilder().setName(name).build();
    return getConversionEvent(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve a single conversion event.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   GetConversionEventRequest request =
   *       GetConversionEventRequest.newBuilder()
   *           .setName(ConversionEventName.of("[PROPERTY]", "[CONVERSION_EVENT]").toString())
   *           .build();
   *   ConversionEvent response = analyticsAdminServiceClient.getConversionEvent(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ConversionEvent getConversionEvent(GetConversionEventRequest request) {
    return getConversionEventCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve a single conversion event.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   GetConversionEventRequest request =
   *       GetConversionEventRequest.newBuilder()
   *           .setName(ConversionEventName.of("[PROPERTY]", "[CONVERSION_EVENT]").toString())
   *           .build();
   *   ApiFuture<ConversionEvent> future =
   *       analyticsAdminServiceClient.getConversionEventCallable().futureCall(request);
   *   // Do something.
   *   ConversionEvent response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetConversionEventRequest, ConversionEvent>
      getConversionEventCallable() {
    return stub.getConversionEventCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a conversion event in a property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   ConversionEventName name = ConversionEventName.of("[PROPERTY]", "[CONVERSION_EVENT]");
   *   analyticsAdminServiceClient.deleteConversionEvent(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the conversion event to delete. Format:
   *     properties/{property}/conversionEvents/{conversion_event} Example:
   *     "properties/123/conversionEvents/456"
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteConversionEvent(ConversionEventName name) {
    DeleteConversionEventRequest request =
        DeleteConversionEventRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    deleteConversionEvent(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a conversion event in a property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   String name = ConversionEventName.of("[PROPERTY]", "[CONVERSION_EVENT]").toString();
   *   analyticsAdminServiceClient.deleteConversionEvent(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the conversion event to delete. Format:
   *     properties/{property}/conversionEvents/{conversion_event} Example:
   *     "properties/123/conversionEvents/456"
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteConversionEvent(String name) {
    DeleteConversionEventRequest request =
        DeleteConversionEventRequest.newBuilder().setName(name).build();
    deleteConversionEvent(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a conversion event in a property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   DeleteConversionEventRequest request =
   *       DeleteConversionEventRequest.newBuilder()
   *           .setName(ConversionEventName.of("[PROPERTY]", "[CONVERSION_EVENT]").toString())
   *           .build();
   *   analyticsAdminServiceClient.deleteConversionEvent(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteConversionEvent(DeleteConversionEventRequest request) {
    deleteConversionEventCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a conversion event in a property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   DeleteConversionEventRequest request =
   *       DeleteConversionEventRequest.newBuilder()
   *           .setName(ConversionEventName.of("[PROPERTY]", "[CONVERSION_EVENT]").toString())
   *           .build();
   *   ApiFuture<Empty> future =
   *       analyticsAdminServiceClient.deleteConversionEventCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteConversionEventRequest, Empty> deleteConversionEventCallable() {
    return stub.deleteConversionEventCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a list of conversion events in the specified parent property.
   *
   * <p>Returns an empty list if no conversion events are found.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   PropertyName parent = PropertyName.of("[PROPERTY]");
   *   for (ConversionEvent element :
   *       analyticsAdminServiceClient.listConversionEvents(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the parent property. Example: 'properties/123'
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListConversionEventsPagedResponse listConversionEvents(PropertyName parent) {
    ListConversionEventsRequest request =
        ListConversionEventsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listConversionEvents(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a list of conversion events in the specified parent property.
   *
   * <p>Returns an empty list if no conversion events are found.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   String parent = PropertyName.of("[PROPERTY]").toString();
   *   for (ConversionEvent element :
   *       analyticsAdminServiceClient.listConversionEvents(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the parent property. Example: 'properties/123'
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListConversionEventsPagedResponse listConversionEvents(String parent) {
    ListConversionEventsRequest request =
        ListConversionEventsRequest.newBuilder().setParent(parent).build();
    return listConversionEvents(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a list of conversion events in the specified parent property.
   *
   * <p>Returns an empty list if no conversion events are found.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   ListConversionEventsRequest request =
   *       ListConversionEventsRequest.newBuilder()
   *           .setParent(PropertyName.of("[PROPERTY]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (ConversionEvent element :
   *       analyticsAdminServiceClient.listConversionEvents(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListConversionEventsPagedResponse listConversionEvents(
      ListConversionEventsRequest request) {
    return listConversionEventsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a list of conversion events in the specified parent property.
   *
   * <p>Returns an empty list if no conversion events are found.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   ListConversionEventsRequest request =
   *       ListConversionEventsRequest.newBuilder()
   *           .setParent(PropertyName.of("[PROPERTY]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<ConversionEvent> future =
   *       analyticsAdminServiceClient.listConversionEventsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (ConversionEvent element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListConversionEventsRequest, ListConversionEventsPagedResponse>
      listConversionEventsPagedCallable() {
    return stub.listConversionEventsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a list of conversion events in the specified parent property.
   *
   * <p>Returns an empty list if no conversion events are found.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   ListConversionEventsRequest request =
   *       ListConversionEventsRequest.newBuilder()
   *           .setParent(PropertyName.of("[PROPERTY]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListConversionEventsResponse response =
   *         analyticsAdminServiceClient.listConversionEventsCallable().call(request);
   *     for (ConversionEvent element : response.getConversionEventsList()) {
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
  public final UnaryCallable<ListConversionEventsRequest, ListConversionEventsResponse>
      listConversionEventsCallable() {
    return stub.listConversionEventsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Look up a single DisplayVideo360AdvertiserLink
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   DisplayVideo360AdvertiserLinkName name =
   *       DisplayVideo360AdvertiserLinkName.of("[PROPERTY]", "[DISPLAY_VIDEO_360_ADVERTISER_LINK]");
   *   DisplayVideo360AdvertiserLink response =
   *       analyticsAdminServiceClient.getDisplayVideo360AdvertiserLink(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the DisplayVideo360AdvertiserLink to get. Example format:
   *     properties/1234/displayVideo360AdvertiserLink/5678
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DisplayVideo360AdvertiserLink getDisplayVideo360AdvertiserLink(
      DisplayVideo360AdvertiserLinkName name) {
    GetDisplayVideo360AdvertiserLinkRequest request =
        GetDisplayVideo360AdvertiserLinkRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getDisplayVideo360AdvertiserLink(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Look up a single DisplayVideo360AdvertiserLink
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   String name =
   *       DisplayVideo360AdvertiserLinkName.of("[PROPERTY]", "[DISPLAY_VIDEO_360_ADVERTISER_LINK]")
   *           .toString();
   *   DisplayVideo360AdvertiserLink response =
   *       analyticsAdminServiceClient.getDisplayVideo360AdvertiserLink(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the DisplayVideo360AdvertiserLink to get. Example format:
   *     properties/1234/displayVideo360AdvertiserLink/5678
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DisplayVideo360AdvertiserLink getDisplayVideo360AdvertiserLink(String name) {
    GetDisplayVideo360AdvertiserLinkRequest request =
        GetDisplayVideo360AdvertiserLinkRequest.newBuilder().setName(name).build();
    return getDisplayVideo360AdvertiserLink(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Look up a single DisplayVideo360AdvertiserLink
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   GetDisplayVideo360AdvertiserLinkRequest request =
   *       GetDisplayVideo360AdvertiserLinkRequest.newBuilder()
   *           .setName(
   *               DisplayVideo360AdvertiserLinkName.of(
   *                       "[PROPERTY]", "[DISPLAY_VIDEO_360_ADVERTISER_LINK]")
   *                   .toString())
   *           .build();
   *   DisplayVideo360AdvertiserLink response =
   *       analyticsAdminServiceClient.getDisplayVideo360AdvertiserLink(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DisplayVideo360AdvertiserLink getDisplayVideo360AdvertiserLink(
      GetDisplayVideo360AdvertiserLinkRequest request) {
    return getDisplayVideo360AdvertiserLinkCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Look up a single DisplayVideo360AdvertiserLink
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   GetDisplayVideo360AdvertiserLinkRequest request =
   *       GetDisplayVideo360AdvertiserLinkRequest.newBuilder()
   *           .setName(
   *               DisplayVideo360AdvertiserLinkName.of(
   *                       "[PROPERTY]", "[DISPLAY_VIDEO_360_ADVERTISER_LINK]")
   *                   .toString())
   *           .build();
   *   ApiFuture<DisplayVideo360AdvertiserLink> future =
   *       analyticsAdminServiceClient
   *           .getDisplayVideo360AdvertiserLinkCallable()
   *           .futureCall(request);
   *   // Do something.
   *   DisplayVideo360AdvertiserLink response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetDisplayVideo360AdvertiserLinkRequest, DisplayVideo360AdvertiserLink>
      getDisplayVideo360AdvertiserLinkCallable() {
    return stub.getDisplayVideo360AdvertiserLinkCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all DisplayVideo360AdvertiserLinks on a property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   PropertyName parent = PropertyName.of("[PROPERTY]");
   *   for (DisplayVideo360AdvertiserLink element :
   *       analyticsAdminServiceClient.listDisplayVideo360AdvertiserLinks(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Example format: properties/1234
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDisplayVideo360AdvertiserLinksPagedResponse listDisplayVideo360AdvertiserLinks(
      PropertyName parent) {
    ListDisplayVideo360AdvertiserLinksRequest request =
        ListDisplayVideo360AdvertiserLinksRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listDisplayVideo360AdvertiserLinks(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all DisplayVideo360AdvertiserLinks on a property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   String parent = PropertyName.of("[PROPERTY]").toString();
   *   for (DisplayVideo360AdvertiserLink element :
   *       analyticsAdminServiceClient.listDisplayVideo360AdvertiserLinks(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Example format: properties/1234
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDisplayVideo360AdvertiserLinksPagedResponse listDisplayVideo360AdvertiserLinks(
      String parent) {
    ListDisplayVideo360AdvertiserLinksRequest request =
        ListDisplayVideo360AdvertiserLinksRequest.newBuilder().setParent(parent).build();
    return listDisplayVideo360AdvertiserLinks(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all DisplayVideo360AdvertiserLinks on a property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   ListDisplayVideo360AdvertiserLinksRequest request =
   *       ListDisplayVideo360AdvertiserLinksRequest.newBuilder()
   *           .setParent(PropertyName.of("[PROPERTY]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (DisplayVideo360AdvertiserLink element :
   *       analyticsAdminServiceClient.listDisplayVideo360AdvertiserLinks(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDisplayVideo360AdvertiserLinksPagedResponse listDisplayVideo360AdvertiserLinks(
      ListDisplayVideo360AdvertiserLinksRequest request) {
    return listDisplayVideo360AdvertiserLinksPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all DisplayVideo360AdvertiserLinks on a property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   ListDisplayVideo360AdvertiserLinksRequest request =
   *       ListDisplayVideo360AdvertiserLinksRequest.newBuilder()
   *           .setParent(PropertyName.of("[PROPERTY]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<DisplayVideo360AdvertiserLink> future =
   *       analyticsAdminServiceClient
   *           .listDisplayVideo360AdvertiserLinksPagedCallable()
   *           .futureCall(request);
   *   // Do something.
   *   for (DisplayVideo360AdvertiserLink element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<
          ListDisplayVideo360AdvertiserLinksRequest,
          ListDisplayVideo360AdvertiserLinksPagedResponse>
      listDisplayVideo360AdvertiserLinksPagedCallable() {
    return stub.listDisplayVideo360AdvertiserLinksPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all DisplayVideo360AdvertiserLinks on a property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   ListDisplayVideo360AdvertiserLinksRequest request =
   *       ListDisplayVideo360AdvertiserLinksRequest.newBuilder()
   *           .setParent(PropertyName.of("[PROPERTY]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListDisplayVideo360AdvertiserLinksResponse response =
   *         analyticsAdminServiceClient.listDisplayVideo360AdvertiserLinksCallable().call(request);
   *     for (DisplayVideo360AdvertiserLink element :
   *         response.getDisplayVideo360AdvertiserLinksList()) {
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
  public final UnaryCallable<
          ListDisplayVideo360AdvertiserLinksRequest, ListDisplayVideo360AdvertiserLinksResponse>
      listDisplayVideo360AdvertiserLinksCallable() {
    return stub.listDisplayVideo360AdvertiserLinksCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a DisplayVideo360AdvertiserLink. This can only be utilized by users who have proper
   * authorization both on the Google Analytics property and on the Display &amp; Video 360
   * advertiser. Users who do not have access to the Display &amp; Video 360 advertiser should
   * instead seek to create a DisplayVideo360LinkProposal.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   PropertyName parent = PropertyName.of("[PROPERTY]");
   *   DisplayVideo360AdvertiserLink displayVideo360AdvertiserLink =
   *       DisplayVideo360AdvertiserLink.newBuilder().build();
   *   DisplayVideo360AdvertiserLink response =
   *       analyticsAdminServiceClient.createDisplayVideo360AdvertiserLink(
   *           parent, displayVideo360AdvertiserLink);
   * }
   * }</pre>
   *
   * @param parent Required. Example format: properties/1234
   * @param displayVideo360AdvertiserLink Required. The DisplayVideo360AdvertiserLink to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DisplayVideo360AdvertiserLink createDisplayVideo360AdvertiserLink(
      PropertyName parent, DisplayVideo360AdvertiserLink displayVideo360AdvertiserLink) {
    CreateDisplayVideo360AdvertiserLinkRequest request =
        CreateDisplayVideo360AdvertiserLinkRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setDisplayVideo360AdvertiserLink(displayVideo360AdvertiserLink)
            .build();
    return createDisplayVideo360AdvertiserLink(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a DisplayVideo360AdvertiserLink. This can only be utilized by users who have proper
   * authorization both on the Google Analytics property and on the Display &amp; Video 360
   * advertiser. Users who do not have access to the Display &amp; Video 360 advertiser should
   * instead seek to create a DisplayVideo360LinkProposal.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   String parent = PropertyName.of("[PROPERTY]").toString();
   *   DisplayVideo360AdvertiserLink displayVideo360AdvertiserLink =
   *       DisplayVideo360AdvertiserLink.newBuilder().build();
   *   DisplayVideo360AdvertiserLink response =
   *       analyticsAdminServiceClient.createDisplayVideo360AdvertiserLink(
   *           parent, displayVideo360AdvertiserLink);
   * }
   * }</pre>
   *
   * @param parent Required. Example format: properties/1234
   * @param displayVideo360AdvertiserLink Required. The DisplayVideo360AdvertiserLink to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DisplayVideo360AdvertiserLink createDisplayVideo360AdvertiserLink(
      String parent, DisplayVideo360AdvertiserLink displayVideo360AdvertiserLink) {
    CreateDisplayVideo360AdvertiserLinkRequest request =
        CreateDisplayVideo360AdvertiserLinkRequest.newBuilder()
            .setParent(parent)
            .setDisplayVideo360AdvertiserLink(displayVideo360AdvertiserLink)
            .build();
    return createDisplayVideo360AdvertiserLink(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a DisplayVideo360AdvertiserLink. This can only be utilized by users who have proper
   * authorization both on the Google Analytics property and on the Display &amp; Video 360
   * advertiser. Users who do not have access to the Display &amp; Video 360 advertiser should
   * instead seek to create a DisplayVideo360LinkProposal.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   CreateDisplayVideo360AdvertiserLinkRequest request =
   *       CreateDisplayVideo360AdvertiserLinkRequest.newBuilder()
   *           .setParent(PropertyName.of("[PROPERTY]").toString())
   *           .setDisplayVideo360AdvertiserLink(DisplayVideo360AdvertiserLink.newBuilder().build())
   *           .build();
   *   DisplayVideo360AdvertiserLink response =
   *       analyticsAdminServiceClient.createDisplayVideo360AdvertiserLink(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DisplayVideo360AdvertiserLink createDisplayVideo360AdvertiserLink(
      CreateDisplayVideo360AdvertiserLinkRequest request) {
    return createDisplayVideo360AdvertiserLinkCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a DisplayVideo360AdvertiserLink. This can only be utilized by users who have proper
   * authorization both on the Google Analytics property and on the Display &amp; Video 360
   * advertiser. Users who do not have access to the Display &amp; Video 360 advertiser should
   * instead seek to create a DisplayVideo360LinkProposal.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   CreateDisplayVideo360AdvertiserLinkRequest request =
   *       CreateDisplayVideo360AdvertiserLinkRequest.newBuilder()
   *           .setParent(PropertyName.of("[PROPERTY]").toString())
   *           .setDisplayVideo360AdvertiserLink(DisplayVideo360AdvertiserLink.newBuilder().build())
   *           .build();
   *   ApiFuture<DisplayVideo360AdvertiserLink> future =
   *       analyticsAdminServiceClient
   *           .createDisplayVideo360AdvertiserLinkCallable()
   *           .futureCall(request);
   *   // Do something.
   *   DisplayVideo360AdvertiserLink response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<
          CreateDisplayVideo360AdvertiserLinkRequest, DisplayVideo360AdvertiserLink>
      createDisplayVideo360AdvertiserLinkCallable() {
    return stub.createDisplayVideo360AdvertiserLinkCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a DisplayVideo360AdvertiserLink on a property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   DisplayVideo360AdvertiserLinkName name =
   *       DisplayVideo360AdvertiserLinkName.of("[PROPERTY]", "[DISPLAY_VIDEO_360_ADVERTISER_LINK]");
   *   analyticsAdminServiceClient.deleteDisplayVideo360AdvertiserLink(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the DisplayVideo360AdvertiserLink to delete. Example format:
   *     properties/1234/displayVideo360AdvertiserLinks/5678
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteDisplayVideo360AdvertiserLink(DisplayVideo360AdvertiserLinkName name) {
    DeleteDisplayVideo360AdvertiserLinkRequest request =
        DeleteDisplayVideo360AdvertiserLinkRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    deleteDisplayVideo360AdvertiserLink(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a DisplayVideo360AdvertiserLink on a property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   String name =
   *       DisplayVideo360AdvertiserLinkName.of("[PROPERTY]", "[DISPLAY_VIDEO_360_ADVERTISER_LINK]")
   *           .toString();
   *   analyticsAdminServiceClient.deleteDisplayVideo360AdvertiserLink(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the DisplayVideo360AdvertiserLink to delete. Example format:
   *     properties/1234/displayVideo360AdvertiserLinks/5678
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteDisplayVideo360AdvertiserLink(String name) {
    DeleteDisplayVideo360AdvertiserLinkRequest request =
        DeleteDisplayVideo360AdvertiserLinkRequest.newBuilder().setName(name).build();
    deleteDisplayVideo360AdvertiserLink(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a DisplayVideo360AdvertiserLink on a property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   DeleteDisplayVideo360AdvertiserLinkRequest request =
   *       DeleteDisplayVideo360AdvertiserLinkRequest.newBuilder()
   *           .setName(
   *               DisplayVideo360AdvertiserLinkName.of(
   *                       "[PROPERTY]", "[DISPLAY_VIDEO_360_ADVERTISER_LINK]")
   *                   .toString())
   *           .build();
   *   analyticsAdminServiceClient.deleteDisplayVideo360AdvertiserLink(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteDisplayVideo360AdvertiserLink(
      DeleteDisplayVideo360AdvertiserLinkRequest request) {
    deleteDisplayVideo360AdvertiserLinkCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a DisplayVideo360AdvertiserLink on a property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   DeleteDisplayVideo360AdvertiserLinkRequest request =
   *       DeleteDisplayVideo360AdvertiserLinkRequest.newBuilder()
   *           .setName(
   *               DisplayVideo360AdvertiserLinkName.of(
   *                       "[PROPERTY]", "[DISPLAY_VIDEO_360_ADVERTISER_LINK]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Empty> future =
   *       analyticsAdminServiceClient
   *           .deleteDisplayVideo360AdvertiserLinkCallable()
   *           .futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteDisplayVideo360AdvertiserLinkRequest, Empty>
      deleteDisplayVideo360AdvertiserLinkCallable() {
    return stub.deleteDisplayVideo360AdvertiserLinkCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a DisplayVideo360AdvertiserLink on a property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   DisplayVideo360AdvertiserLink displayVideo360AdvertiserLink =
   *       DisplayVideo360AdvertiserLink.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   DisplayVideo360AdvertiserLink response =
   *       analyticsAdminServiceClient.updateDisplayVideo360AdvertiserLink(
   *           displayVideo360AdvertiserLink, updateMask);
   * }
   * }</pre>
   *
   * @param displayVideo360AdvertiserLink The DisplayVideo360AdvertiserLink to update
   * @param updateMask Required. The list of fields to be updated. Omitted fields will not be
   *     updated. To replace the entire entity, use one path with the string "&#42;" to match all
   *     fields.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DisplayVideo360AdvertiserLink updateDisplayVideo360AdvertiserLink(
      DisplayVideo360AdvertiserLink displayVideo360AdvertiserLink, FieldMask updateMask) {
    UpdateDisplayVideo360AdvertiserLinkRequest request =
        UpdateDisplayVideo360AdvertiserLinkRequest.newBuilder()
            .setDisplayVideo360AdvertiserLink(displayVideo360AdvertiserLink)
            .setUpdateMask(updateMask)
            .build();
    return updateDisplayVideo360AdvertiserLink(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a DisplayVideo360AdvertiserLink on a property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   UpdateDisplayVideo360AdvertiserLinkRequest request =
   *       UpdateDisplayVideo360AdvertiserLinkRequest.newBuilder()
   *           .setDisplayVideo360AdvertiserLink(DisplayVideo360AdvertiserLink.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   DisplayVideo360AdvertiserLink response =
   *       analyticsAdminServiceClient.updateDisplayVideo360AdvertiserLink(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DisplayVideo360AdvertiserLink updateDisplayVideo360AdvertiserLink(
      UpdateDisplayVideo360AdvertiserLinkRequest request) {
    return updateDisplayVideo360AdvertiserLinkCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a DisplayVideo360AdvertiserLink on a property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   UpdateDisplayVideo360AdvertiserLinkRequest request =
   *       UpdateDisplayVideo360AdvertiserLinkRequest.newBuilder()
   *           .setDisplayVideo360AdvertiserLink(DisplayVideo360AdvertiserLink.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<DisplayVideo360AdvertiserLink> future =
   *       analyticsAdminServiceClient
   *           .updateDisplayVideo360AdvertiserLinkCallable()
   *           .futureCall(request);
   *   // Do something.
   *   DisplayVideo360AdvertiserLink response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<
          UpdateDisplayVideo360AdvertiserLinkRequest, DisplayVideo360AdvertiserLink>
      updateDisplayVideo360AdvertiserLinkCallable() {
    return stub.updateDisplayVideo360AdvertiserLinkCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lookup for a single DisplayVideo360AdvertiserLinkProposal.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   DisplayVideo360AdvertiserLinkProposalName name =
   *       DisplayVideo360AdvertiserLinkProposalName.of(
   *           "[PROPERTY]", "[DISPLAY_VIDEO_360_ADVERTISER_LINK_PROPOSAL]");
   *   DisplayVideo360AdvertiserLinkProposal response =
   *       analyticsAdminServiceClient.getDisplayVideo360AdvertiserLinkProposal(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the DisplayVideo360AdvertiserLinkProposal to get. Example
   *     format: properties/1234/displayVideo360AdvertiserLinkProposals/5678
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DisplayVideo360AdvertiserLinkProposal getDisplayVideo360AdvertiserLinkProposal(
      DisplayVideo360AdvertiserLinkProposalName name) {
    GetDisplayVideo360AdvertiserLinkProposalRequest request =
        GetDisplayVideo360AdvertiserLinkProposalRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getDisplayVideo360AdvertiserLinkProposal(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lookup for a single DisplayVideo360AdvertiserLinkProposal.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   String name =
   *       DisplayVideo360AdvertiserLinkProposalName.of(
   *               "[PROPERTY]", "[DISPLAY_VIDEO_360_ADVERTISER_LINK_PROPOSAL]")
   *           .toString();
   *   DisplayVideo360AdvertiserLinkProposal response =
   *       analyticsAdminServiceClient.getDisplayVideo360AdvertiserLinkProposal(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the DisplayVideo360AdvertiserLinkProposal to get. Example
   *     format: properties/1234/displayVideo360AdvertiserLinkProposals/5678
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DisplayVideo360AdvertiserLinkProposal getDisplayVideo360AdvertiserLinkProposal(
      String name) {
    GetDisplayVideo360AdvertiserLinkProposalRequest request =
        GetDisplayVideo360AdvertiserLinkProposalRequest.newBuilder().setName(name).build();
    return getDisplayVideo360AdvertiserLinkProposal(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lookup for a single DisplayVideo360AdvertiserLinkProposal.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   GetDisplayVideo360AdvertiserLinkProposalRequest request =
   *       GetDisplayVideo360AdvertiserLinkProposalRequest.newBuilder()
   *           .setName(
   *               DisplayVideo360AdvertiserLinkProposalName.of(
   *                       "[PROPERTY]", "[DISPLAY_VIDEO_360_ADVERTISER_LINK_PROPOSAL]")
   *                   .toString())
   *           .build();
   *   DisplayVideo360AdvertiserLinkProposal response =
   *       analyticsAdminServiceClient.getDisplayVideo360AdvertiserLinkProposal(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DisplayVideo360AdvertiserLinkProposal getDisplayVideo360AdvertiserLinkProposal(
      GetDisplayVideo360AdvertiserLinkProposalRequest request) {
    return getDisplayVideo360AdvertiserLinkProposalCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lookup for a single DisplayVideo360AdvertiserLinkProposal.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   GetDisplayVideo360AdvertiserLinkProposalRequest request =
   *       GetDisplayVideo360AdvertiserLinkProposalRequest.newBuilder()
   *           .setName(
   *               DisplayVideo360AdvertiserLinkProposalName.of(
   *                       "[PROPERTY]", "[DISPLAY_VIDEO_360_ADVERTISER_LINK_PROPOSAL]")
   *                   .toString())
   *           .build();
   *   ApiFuture<DisplayVideo360AdvertiserLinkProposal> future =
   *       analyticsAdminServiceClient
   *           .getDisplayVideo360AdvertiserLinkProposalCallable()
   *           .futureCall(request);
   *   // Do something.
   *   DisplayVideo360AdvertiserLinkProposal response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<
          GetDisplayVideo360AdvertiserLinkProposalRequest, DisplayVideo360AdvertiserLinkProposal>
      getDisplayVideo360AdvertiserLinkProposalCallable() {
    return stub.getDisplayVideo360AdvertiserLinkProposalCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists DisplayVideo360AdvertiserLinkProposals on a property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   PropertyName parent = PropertyName.of("[PROPERTY]");
   *   for (DisplayVideo360AdvertiserLinkProposal element :
   *       analyticsAdminServiceClient
   *           .listDisplayVideo360AdvertiserLinkProposals(parent)
   *           .iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Example format: properties/1234
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDisplayVideo360AdvertiserLinkProposalsPagedResponse
      listDisplayVideo360AdvertiserLinkProposals(PropertyName parent) {
    ListDisplayVideo360AdvertiserLinkProposalsRequest request =
        ListDisplayVideo360AdvertiserLinkProposalsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listDisplayVideo360AdvertiserLinkProposals(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists DisplayVideo360AdvertiserLinkProposals on a property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   String parent = PropertyName.of("[PROPERTY]").toString();
   *   for (DisplayVideo360AdvertiserLinkProposal element :
   *       analyticsAdminServiceClient
   *           .listDisplayVideo360AdvertiserLinkProposals(parent)
   *           .iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Example format: properties/1234
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDisplayVideo360AdvertiserLinkProposalsPagedResponse
      listDisplayVideo360AdvertiserLinkProposals(String parent) {
    ListDisplayVideo360AdvertiserLinkProposalsRequest request =
        ListDisplayVideo360AdvertiserLinkProposalsRequest.newBuilder().setParent(parent).build();
    return listDisplayVideo360AdvertiserLinkProposals(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists DisplayVideo360AdvertiserLinkProposals on a property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   ListDisplayVideo360AdvertiserLinkProposalsRequest request =
   *       ListDisplayVideo360AdvertiserLinkProposalsRequest.newBuilder()
   *           .setParent(PropertyName.of("[PROPERTY]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (DisplayVideo360AdvertiserLinkProposal element :
   *       analyticsAdminServiceClient
   *           .listDisplayVideo360AdvertiserLinkProposals(request)
   *           .iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDisplayVideo360AdvertiserLinkProposalsPagedResponse
      listDisplayVideo360AdvertiserLinkProposals(
          ListDisplayVideo360AdvertiserLinkProposalsRequest request) {
    return listDisplayVideo360AdvertiserLinkProposalsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists DisplayVideo360AdvertiserLinkProposals on a property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   ListDisplayVideo360AdvertiserLinkProposalsRequest request =
   *       ListDisplayVideo360AdvertiserLinkProposalsRequest.newBuilder()
   *           .setParent(PropertyName.of("[PROPERTY]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<DisplayVideo360AdvertiserLinkProposal> future =
   *       analyticsAdminServiceClient
   *           .listDisplayVideo360AdvertiserLinkProposalsPagedCallable()
   *           .futureCall(request);
   *   // Do something.
   *   for (DisplayVideo360AdvertiserLinkProposal element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<
          ListDisplayVideo360AdvertiserLinkProposalsRequest,
          ListDisplayVideo360AdvertiserLinkProposalsPagedResponse>
      listDisplayVideo360AdvertiserLinkProposalsPagedCallable() {
    return stub.listDisplayVideo360AdvertiserLinkProposalsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists DisplayVideo360AdvertiserLinkProposals on a property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   ListDisplayVideo360AdvertiserLinkProposalsRequest request =
   *       ListDisplayVideo360AdvertiserLinkProposalsRequest.newBuilder()
   *           .setParent(PropertyName.of("[PROPERTY]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListDisplayVideo360AdvertiserLinkProposalsResponse response =
   *         analyticsAdminServiceClient
   *             .listDisplayVideo360AdvertiserLinkProposalsCallable()
   *             .call(request);
   *     for (DisplayVideo360AdvertiserLinkProposal element :
   *         response.getDisplayVideo360AdvertiserLinkProposalsList()) {
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
  public final UnaryCallable<
          ListDisplayVideo360AdvertiserLinkProposalsRequest,
          ListDisplayVideo360AdvertiserLinkProposalsResponse>
      listDisplayVideo360AdvertiserLinkProposalsCallable() {
    return stub.listDisplayVideo360AdvertiserLinkProposalsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a DisplayVideo360AdvertiserLinkProposal.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   PropertyName parent = PropertyName.of("[PROPERTY]");
   *   DisplayVideo360AdvertiserLinkProposal displayVideo360AdvertiserLinkProposal =
   *       DisplayVideo360AdvertiserLinkProposal.newBuilder().build();
   *   DisplayVideo360AdvertiserLinkProposal response =
   *       analyticsAdminServiceClient.createDisplayVideo360AdvertiserLinkProposal(
   *           parent, displayVideo360AdvertiserLinkProposal);
   * }
   * }</pre>
   *
   * @param parent Required. Example format: properties/1234
   * @param displayVideo360AdvertiserLinkProposal Required. The
   *     DisplayVideo360AdvertiserLinkProposal to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DisplayVideo360AdvertiserLinkProposal createDisplayVideo360AdvertiserLinkProposal(
      PropertyName parent,
      DisplayVideo360AdvertiserLinkProposal displayVideo360AdvertiserLinkProposal) {
    CreateDisplayVideo360AdvertiserLinkProposalRequest request =
        CreateDisplayVideo360AdvertiserLinkProposalRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setDisplayVideo360AdvertiserLinkProposal(displayVideo360AdvertiserLinkProposal)
            .build();
    return createDisplayVideo360AdvertiserLinkProposal(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a DisplayVideo360AdvertiserLinkProposal.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   String parent = PropertyName.of("[PROPERTY]").toString();
   *   DisplayVideo360AdvertiserLinkProposal displayVideo360AdvertiserLinkProposal =
   *       DisplayVideo360AdvertiserLinkProposal.newBuilder().build();
   *   DisplayVideo360AdvertiserLinkProposal response =
   *       analyticsAdminServiceClient.createDisplayVideo360AdvertiserLinkProposal(
   *           parent, displayVideo360AdvertiserLinkProposal);
   * }
   * }</pre>
   *
   * @param parent Required. Example format: properties/1234
   * @param displayVideo360AdvertiserLinkProposal Required. The
   *     DisplayVideo360AdvertiserLinkProposal to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DisplayVideo360AdvertiserLinkProposal createDisplayVideo360AdvertiserLinkProposal(
      String parent, DisplayVideo360AdvertiserLinkProposal displayVideo360AdvertiserLinkProposal) {
    CreateDisplayVideo360AdvertiserLinkProposalRequest request =
        CreateDisplayVideo360AdvertiserLinkProposalRequest.newBuilder()
            .setParent(parent)
            .setDisplayVideo360AdvertiserLinkProposal(displayVideo360AdvertiserLinkProposal)
            .build();
    return createDisplayVideo360AdvertiserLinkProposal(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a DisplayVideo360AdvertiserLinkProposal.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   CreateDisplayVideo360AdvertiserLinkProposalRequest request =
   *       CreateDisplayVideo360AdvertiserLinkProposalRequest.newBuilder()
   *           .setParent(PropertyName.of("[PROPERTY]").toString())
   *           .setDisplayVideo360AdvertiserLinkProposal(
   *               DisplayVideo360AdvertiserLinkProposal.newBuilder().build())
   *           .build();
   *   DisplayVideo360AdvertiserLinkProposal response =
   *       analyticsAdminServiceClient.createDisplayVideo360AdvertiserLinkProposal(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DisplayVideo360AdvertiserLinkProposal createDisplayVideo360AdvertiserLinkProposal(
      CreateDisplayVideo360AdvertiserLinkProposalRequest request) {
    return createDisplayVideo360AdvertiserLinkProposalCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a DisplayVideo360AdvertiserLinkProposal.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   CreateDisplayVideo360AdvertiserLinkProposalRequest request =
   *       CreateDisplayVideo360AdvertiserLinkProposalRequest.newBuilder()
   *           .setParent(PropertyName.of("[PROPERTY]").toString())
   *           .setDisplayVideo360AdvertiserLinkProposal(
   *               DisplayVideo360AdvertiserLinkProposal.newBuilder().build())
   *           .build();
   *   ApiFuture<DisplayVideo360AdvertiserLinkProposal> future =
   *       analyticsAdminServiceClient
   *           .createDisplayVideo360AdvertiserLinkProposalCallable()
   *           .futureCall(request);
   *   // Do something.
   *   DisplayVideo360AdvertiserLinkProposal response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<
          CreateDisplayVideo360AdvertiserLinkProposalRequest, DisplayVideo360AdvertiserLinkProposal>
      createDisplayVideo360AdvertiserLinkProposalCallable() {
    return stub.createDisplayVideo360AdvertiserLinkProposalCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a DisplayVideo360AdvertiserLinkProposal on a property. This can only be used on
   * cancelled proposals.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   DisplayVideo360AdvertiserLinkProposalName name =
   *       DisplayVideo360AdvertiserLinkProposalName.of(
   *           "[PROPERTY]", "[DISPLAY_VIDEO_360_ADVERTISER_LINK_PROPOSAL]");
   *   analyticsAdminServiceClient.deleteDisplayVideo360AdvertiserLinkProposal(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the DisplayVideo360AdvertiserLinkProposal to delete. Example
   *     format: properties/1234/displayVideo360AdvertiserLinkProposals/5678
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteDisplayVideo360AdvertiserLinkProposal(
      DisplayVideo360AdvertiserLinkProposalName name) {
    DeleteDisplayVideo360AdvertiserLinkProposalRequest request =
        DeleteDisplayVideo360AdvertiserLinkProposalRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    deleteDisplayVideo360AdvertiserLinkProposal(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a DisplayVideo360AdvertiserLinkProposal on a property. This can only be used on
   * cancelled proposals.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   String name =
   *       DisplayVideo360AdvertiserLinkProposalName.of(
   *               "[PROPERTY]", "[DISPLAY_VIDEO_360_ADVERTISER_LINK_PROPOSAL]")
   *           .toString();
   *   analyticsAdminServiceClient.deleteDisplayVideo360AdvertiserLinkProposal(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the DisplayVideo360AdvertiserLinkProposal to delete. Example
   *     format: properties/1234/displayVideo360AdvertiserLinkProposals/5678
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteDisplayVideo360AdvertiserLinkProposal(String name) {
    DeleteDisplayVideo360AdvertiserLinkProposalRequest request =
        DeleteDisplayVideo360AdvertiserLinkProposalRequest.newBuilder().setName(name).build();
    deleteDisplayVideo360AdvertiserLinkProposal(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a DisplayVideo360AdvertiserLinkProposal on a property. This can only be used on
   * cancelled proposals.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   DeleteDisplayVideo360AdvertiserLinkProposalRequest request =
   *       DeleteDisplayVideo360AdvertiserLinkProposalRequest.newBuilder()
   *           .setName(
   *               DisplayVideo360AdvertiserLinkProposalName.of(
   *                       "[PROPERTY]", "[DISPLAY_VIDEO_360_ADVERTISER_LINK_PROPOSAL]")
   *                   .toString())
   *           .build();
   *   analyticsAdminServiceClient.deleteDisplayVideo360AdvertiserLinkProposal(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteDisplayVideo360AdvertiserLinkProposal(
      DeleteDisplayVideo360AdvertiserLinkProposalRequest request) {
    deleteDisplayVideo360AdvertiserLinkProposalCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a DisplayVideo360AdvertiserLinkProposal on a property. This can only be used on
   * cancelled proposals.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   DeleteDisplayVideo360AdvertiserLinkProposalRequest request =
   *       DeleteDisplayVideo360AdvertiserLinkProposalRequest.newBuilder()
   *           .setName(
   *               DisplayVideo360AdvertiserLinkProposalName.of(
   *                       "[PROPERTY]", "[DISPLAY_VIDEO_360_ADVERTISER_LINK_PROPOSAL]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Empty> future =
   *       analyticsAdminServiceClient
   *           .deleteDisplayVideo360AdvertiserLinkProposalCallable()
   *           .futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteDisplayVideo360AdvertiserLinkProposalRequest, Empty>
      deleteDisplayVideo360AdvertiserLinkProposalCallable() {
    return stub.deleteDisplayVideo360AdvertiserLinkProposalCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Approves a DisplayVideo360AdvertiserLinkProposal. The DisplayVideo360AdvertiserLinkProposal
   * will be deleted and a new DisplayVideo360AdvertiserLink will be created.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   ApproveDisplayVideo360AdvertiserLinkProposalRequest request =
   *       ApproveDisplayVideo360AdvertiserLinkProposalRequest.newBuilder()
   *           .setName(
   *               DisplayVideo360AdvertiserLinkProposalName.of(
   *                       "[PROPERTY]", "[DISPLAY_VIDEO_360_ADVERTISER_LINK_PROPOSAL]")
   *                   .toString())
   *           .build();
   *   ApproveDisplayVideo360AdvertiserLinkProposalResponse response =
   *       analyticsAdminServiceClient.approveDisplayVideo360AdvertiserLinkProposal(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ApproveDisplayVideo360AdvertiserLinkProposalResponse
      approveDisplayVideo360AdvertiserLinkProposal(
          ApproveDisplayVideo360AdvertiserLinkProposalRequest request) {
    return approveDisplayVideo360AdvertiserLinkProposalCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Approves a DisplayVideo360AdvertiserLinkProposal. The DisplayVideo360AdvertiserLinkProposal
   * will be deleted and a new DisplayVideo360AdvertiserLink will be created.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   ApproveDisplayVideo360AdvertiserLinkProposalRequest request =
   *       ApproveDisplayVideo360AdvertiserLinkProposalRequest.newBuilder()
   *           .setName(
   *               DisplayVideo360AdvertiserLinkProposalName.of(
   *                       "[PROPERTY]", "[DISPLAY_VIDEO_360_ADVERTISER_LINK_PROPOSAL]")
   *                   .toString())
   *           .build();
   *   ApiFuture<ApproveDisplayVideo360AdvertiserLinkProposalResponse> future =
   *       analyticsAdminServiceClient
   *           .approveDisplayVideo360AdvertiserLinkProposalCallable()
   *           .futureCall(request);
   *   // Do something.
   *   ApproveDisplayVideo360AdvertiserLinkProposalResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<
          ApproveDisplayVideo360AdvertiserLinkProposalRequest,
          ApproveDisplayVideo360AdvertiserLinkProposalResponse>
      approveDisplayVideo360AdvertiserLinkProposalCallable() {
    return stub.approveDisplayVideo360AdvertiserLinkProposalCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Cancels a DisplayVideo360AdvertiserLinkProposal. Cancelling can mean either: - Declining a
   * proposal initiated from Display &amp; Video 360 - Withdrawing a proposal initiated from Google
   * Analytics After being cancelled, a proposal will eventually be deleted automatically.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   CancelDisplayVideo360AdvertiserLinkProposalRequest request =
   *       CancelDisplayVideo360AdvertiserLinkProposalRequest.newBuilder()
   *           .setName(
   *               DisplayVideo360AdvertiserLinkProposalName.of(
   *                       "[PROPERTY]", "[DISPLAY_VIDEO_360_ADVERTISER_LINK_PROPOSAL]")
   *                   .toString())
   *           .build();
   *   DisplayVideo360AdvertiserLinkProposal response =
   *       analyticsAdminServiceClient.cancelDisplayVideo360AdvertiserLinkProposal(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DisplayVideo360AdvertiserLinkProposal cancelDisplayVideo360AdvertiserLinkProposal(
      CancelDisplayVideo360AdvertiserLinkProposalRequest request) {
    return cancelDisplayVideo360AdvertiserLinkProposalCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Cancels a DisplayVideo360AdvertiserLinkProposal. Cancelling can mean either: - Declining a
   * proposal initiated from Display &amp; Video 360 - Withdrawing a proposal initiated from Google
   * Analytics After being cancelled, a proposal will eventually be deleted automatically.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   CancelDisplayVideo360AdvertiserLinkProposalRequest request =
   *       CancelDisplayVideo360AdvertiserLinkProposalRequest.newBuilder()
   *           .setName(
   *               DisplayVideo360AdvertiserLinkProposalName.of(
   *                       "[PROPERTY]", "[DISPLAY_VIDEO_360_ADVERTISER_LINK_PROPOSAL]")
   *                   .toString())
   *           .build();
   *   ApiFuture<DisplayVideo360AdvertiserLinkProposal> future =
   *       analyticsAdminServiceClient
   *           .cancelDisplayVideo360AdvertiserLinkProposalCallable()
   *           .futureCall(request);
   *   // Do something.
   *   DisplayVideo360AdvertiserLinkProposal response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<
          CancelDisplayVideo360AdvertiserLinkProposalRequest, DisplayVideo360AdvertiserLinkProposal>
      cancelDisplayVideo360AdvertiserLinkProposalCallable() {
    return stub.cancelDisplayVideo360AdvertiserLinkProposalCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a CustomDimension.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   PropertyName parent = PropertyName.of("[PROPERTY]");
   *   CustomDimension customDimension = CustomDimension.newBuilder().build();
   *   CustomDimension response =
   *       analyticsAdminServiceClient.createCustomDimension(parent, customDimension);
   * }
   * }</pre>
   *
   * @param parent Required. Example format: properties/1234
   * @param customDimension Required. The CustomDimension to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CustomDimension createCustomDimension(
      PropertyName parent, CustomDimension customDimension) {
    CreateCustomDimensionRequest request =
        CreateCustomDimensionRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setCustomDimension(customDimension)
            .build();
    return createCustomDimension(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a CustomDimension.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   String parent = PropertyName.of("[PROPERTY]").toString();
   *   CustomDimension customDimension = CustomDimension.newBuilder().build();
   *   CustomDimension response =
   *       analyticsAdminServiceClient.createCustomDimension(parent, customDimension);
   * }
   * }</pre>
   *
   * @param parent Required. Example format: properties/1234
   * @param customDimension Required. The CustomDimension to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CustomDimension createCustomDimension(
      String parent, CustomDimension customDimension) {
    CreateCustomDimensionRequest request =
        CreateCustomDimensionRequest.newBuilder()
            .setParent(parent)
            .setCustomDimension(customDimension)
            .build();
    return createCustomDimension(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a CustomDimension.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   CreateCustomDimensionRequest request =
   *       CreateCustomDimensionRequest.newBuilder()
   *           .setParent(PropertyName.of("[PROPERTY]").toString())
   *           .setCustomDimension(CustomDimension.newBuilder().build())
   *           .build();
   *   CustomDimension response = analyticsAdminServiceClient.createCustomDimension(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CustomDimension createCustomDimension(CreateCustomDimensionRequest request) {
    return createCustomDimensionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a CustomDimension.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   CreateCustomDimensionRequest request =
   *       CreateCustomDimensionRequest.newBuilder()
   *           .setParent(PropertyName.of("[PROPERTY]").toString())
   *           .setCustomDimension(CustomDimension.newBuilder().build())
   *           .build();
   *   ApiFuture<CustomDimension> future =
   *       analyticsAdminServiceClient.createCustomDimensionCallable().futureCall(request);
   *   // Do something.
   *   CustomDimension response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateCustomDimensionRequest, CustomDimension>
      createCustomDimensionCallable() {
    return stub.createCustomDimensionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a CustomDimension on a property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   CustomDimension customDimension = CustomDimension.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   CustomDimension response =
   *       analyticsAdminServiceClient.updateCustomDimension(customDimension, updateMask);
   * }
   * }</pre>
   *
   * @param customDimension The CustomDimension to update
   * @param updateMask Required. The list of fields to be updated. Omitted fields will not be
   *     updated. To replace the entire entity, use one path with the string "&#42;" to match all
   *     fields.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CustomDimension updateCustomDimension(
      CustomDimension customDimension, FieldMask updateMask) {
    UpdateCustomDimensionRequest request =
        UpdateCustomDimensionRequest.newBuilder()
            .setCustomDimension(customDimension)
            .setUpdateMask(updateMask)
            .build();
    return updateCustomDimension(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a CustomDimension on a property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   UpdateCustomDimensionRequest request =
   *       UpdateCustomDimensionRequest.newBuilder()
   *           .setCustomDimension(CustomDimension.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   CustomDimension response = analyticsAdminServiceClient.updateCustomDimension(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CustomDimension updateCustomDimension(UpdateCustomDimensionRequest request) {
    return updateCustomDimensionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a CustomDimension on a property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   UpdateCustomDimensionRequest request =
   *       UpdateCustomDimensionRequest.newBuilder()
   *           .setCustomDimension(CustomDimension.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<CustomDimension> future =
   *       analyticsAdminServiceClient.updateCustomDimensionCallable().futureCall(request);
   *   // Do something.
   *   CustomDimension response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateCustomDimensionRequest, CustomDimension>
      updateCustomDimensionCallable() {
    return stub.updateCustomDimensionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists CustomDimensions on a property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   PropertyName parent = PropertyName.of("[PROPERTY]");
   *   for (CustomDimension element :
   *       analyticsAdminServiceClient.listCustomDimensions(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Example format: properties/1234
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCustomDimensionsPagedResponse listCustomDimensions(PropertyName parent) {
    ListCustomDimensionsRequest request =
        ListCustomDimensionsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listCustomDimensions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists CustomDimensions on a property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   String parent = PropertyName.of("[PROPERTY]").toString();
   *   for (CustomDimension element :
   *       analyticsAdminServiceClient.listCustomDimensions(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Example format: properties/1234
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCustomDimensionsPagedResponse listCustomDimensions(String parent) {
    ListCustomDimensionsRequest request =
        ListCustomDimensionsRequest.newBuilder().setParent(parent).build();
    return listCustomDimensions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists CustomDimensions on a property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   ListCustomDimensionsRequest request =
   *       ListCustomDimensionsRequest.newBuilder()
   *           .setParent(PropertyName.of("[PROPERTY]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (CustomDimension element :
   *       analyticsAdminServiceClient.listCustomDimensions(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCustomDimensionsPagedResponse listCustomDimensions(
      ListCustomDimensionsRequest request) {
    return listCustomDimensionsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists CustomDimensions on a property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   ListCustomDimensionsRequest request =
   *       ListCustomDimensionsRequest.newBuilder()
   *           .setParent(PropertyName.of("[PROPERTY]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<CustomDimension> future =
   *       analyticsAdminServiceClient.listCustomDimensionsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (CustomDimension element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListCustomDimensionsRequest, ListCustomDimensionsPagedResponse>
      listCustomDimensionsPagedCallable() {
    return stub.listCustomDimensionsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists CustomDimensions on a property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   ListCustomDimensionsRequest request =
   *       ListCustomDimensionsRequest.newBuilder()
   *           .setParent(PropertyName.of("[PROPERTY]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListCustomDimensionsResponse response =
   *         analyticsAdminServiceClient.listCustomDimensionsCallable().call(request);
   *     for (CustomDimension element : response.getCustomDimensionsList()) {
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
  public final UnaryCallable<ListCustomDimensionsRequest, ListCustomDimensionsResponse>
      listCustomDimensionsCallable() {
    return stub.listCustomDimensionsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Archives a CustomDimension on a property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   CustomDimensionName name = CustomDimensionName.of("[PROPERTY]", "[CUSTOM_DIMENSION]");
   *   analyticsAdminServiceClient.archiveCustomDimension(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the CustomDimension to archive. Example format:
   *     properties/1234/customDimensions/5678
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void archiveCustomDimension(CustomDimensionName name) {
    ArchiveCustomDimensionRequest request =
        ArchiveCustomDimensionRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    archiveCustomDimension(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Archives a CustomDimension on a property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   String name = CustomDimensionName.of("[PROPERTY]", "[CUSTOM_DIMENSION]").toString();
   *   analyticsAdminServiceClient.archiveCustomDimension(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the CustomDimension to archive. Example format:
   *     properties/1234/customDimensions/5678
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void archiveCustomDimension(String name) {
    ArchiveCustomDimensionRequest request =
        ArchiveCustomDimensionRequest.newBuilder().setName(name).build();
    archiveCustomDimension(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Archives a CustomDimension on a property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   ArchiveCustomDimensionRequest request =
   *       ArchiveCustomDimensionRequest.newBuilder()
   *           .setName(CustomDimensionName.of("[PROPERTY]", "[CUSTOM_DIMENSION]").toString())
   *           .build();
   *   analyticsAdminServiceClient.archiveCustomDimension(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void archiveCustomDimension(ArchiveCustomDimensionRequest request) {
    archiveCustomDimensionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Archives a CustomDimension on a property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   ArchiveCustomDimensionRequest request =
   *       ArchiveCustomDimensionRequest.newBuilder()
   *           .setName(CustomDimensionName.of("[PROPERTY]", "[CUSTOM_DIMENSION]").toString())
   *           .build();
   *   ApiFuture<Empty> future =
   *       analyticsAdminServiceClient.archiveCustomDimensionCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ArchiveCustomDimensionRequest, Empty>
      archiveCustomDimensionCallable() {
    return stub.archiveCustomDimensionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lookup for a single CustomDimension.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   CustomDimensionName name = CustomDimensionName.of("[PROPERTY]", "[CUSTOM_DIMENSION]");
   *   CustomDimension response = analyticsAdminServiceClient.getCustomDimension(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the CustomDimension to get. Example format:
   *     properties/1234/customDimensions/5678
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CustomDimension getCustomDimension(CustomDimensionName name) {
    GetCustomDimensionRequest request =
        GetCustomDimensionRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getCustomDimension(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lookup for a single CustomDimension.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   String name = CustomDimensionName.of("[PROPERTY]", "[CUSTOM_DIMENSION]").toString();
   *   CustomDimension response = analyticsAdminServiceClient.getCustomDimension(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the CustomDimension to get. Example format:
   *     properties/1234/customDimensions/5678
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CustomDimension getCustomDimension(String name) {
    GetCustomDimensionRequest request =
        GetCustomDimensionRequest.newBuilder().setName(name).build();
    return getCustomDimension(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lookup for a single CustomDimension.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   GetCustomDimensionRequest request =
   *       GetCustomDimensionRequest.newBuilder()
   *           .setName(CustomDimensionName.of("[PROPERTY]", "[CUSTOM_DIMENSION]").toString())
   *           .build();
   *   CustomDimension response = analyticsAdminServiceClient.getCustomDimension(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CustomDimension getCustomDimension(GetCustomDimensionRequest request) {
    return getCustomDimensionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lookup for a single CustomDimension.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   GetCustomDimensionRequest request =
   *       GetCustomDimensionRequest.newBuilder()
   *           .setName(CustomDimensionName.of("[PROPERTY]", "[CUSTOM_DIMENSION]").toString())
   *           .build();
   *   ApiFuture<CustomDimension> future =
   *       analyticsAdminServiceClient.getCustomDimensionCallable().futureCall(request);
   *   // Do something.
   *   CustomDimension response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetCustomDimensionRequest, CustomDimension>
      getCustomDimensionCallable() {
    return stub.getCustomDimensionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a CustomMetric.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   PropertyName parent = PropertyName.of("[PROPERTY]");
   *   CustomMetric customMetric = CustomMetric.newBuilder().build();
   *   CustomMetric response = analyticsAdminServiceClient.createCustomMetric(parent, customMetric);
   * }
   * }</pre>
   *
   * @param parent Required. Example format: properties/1234
   * @param customMetric Required. The CustomMetric to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CustomMetric createCustomMetric(PropertyName parent, CustomMetric customMetric) {
    CreateCustomMetricRequest request =
        CreateCustomMetricRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setCustomMetric(customMetric)
            .build();
    return createCustomMetric(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a CustomMetric.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   String parent = PropertyName.of("[PROPERTY]").toString();
   *   CustomMetric customMetric = CustomMetric.newBuilder().build();
   *   CustomMetric response = analyticsAdminServiceClient.createCustomMetric(parent, customMetric);
   * }
   * }</pre>
   *
   * @param parent Required. Example format: properties/1234
   * @param customMetric Required. The CustomMetric to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CustomMetric createCustomMetric(String parent, CustomMetric customMetric) {
    CreateCustomMetricRequest request =
        CreateCustomMetricRequest.newBuilder()
            .setParent(parent)
            .setCustomMetric(customMetric)
            .build();
    return createCustomMetric(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a CustomMetric.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   CreateCustomMetricRequest request =
   *       CreateCustomMetricRequest.newBuilder()
   *           .setParent(PropertyName.of("[PROPERTY]").toString())
   *           .setCustomMetric(CustomMetric.newBuilder().build())
   *           .build();
   *   CustomMetric response = analyticsAdminServiceClient.createCustomMetric(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CustomMetric createCustomMetric(CreateCustomMetricRequest request) {
    return createCustomMetricCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a CustomMetric.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   CreateCustomMetricRequest request =
   *       CreateCustomMetricRequest.newBuilder()
   *           .setParent(PropertyName.of("[PROPERTY]").toString())
   *           .setCustomMetric(CustomMetric.newBuilder().build())
   *           .build();
   *   ApiFuture<CustomMetric> future =
   *       analyticsAdminServiceClient.createCustomMetricCallable().futureCall(request);
   *   // Do something.
   *   CustomMetric response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateCustomMetricRequest, CustomMetric> createCustomMetricCallable() {
    return stub.createCustomMetricCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a CustomMetric on a property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   CustomMetric customMetric = CustomMetric.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   CustomMetric response =
   *       analyticsAdminServiceClient.updateCustomMetric(customMetric, updateMask);
   * }
   * }</pre>
   *
   * @param customMetric The CustomMetric to update
   * @param updateMask Required. The list of fields to be updated. Omitted fields will not be
   *     updated. To replace the entire entity, use one path with the string "&#42;" to match all
   *     fields.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CustomMetric updateCustomMetric(CustomMetric customMetric, FieldMask updateMask) {
    UpdateCustomMetricRequest request =
        UpdateCustomMetricRequest.newBuilder()
            .setCustomMetric(customMetric)
            .setUpdateMask(updateMask)
            .build();
    return updateCustomMetric(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a CustomMetric on a property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   UpdateCustomMetricRequest request =
   *       UpdateCustomMetricRequest.newBuilder()
   *           .setCustomMetric(CustomMetric.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   CustomMetric response = analyticsAdminServiceClient.updateCustomMetric(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CustomMetric updateCustomMetric(UpdateCustomMetricRequest request) {
    return updateCustomMetricCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a CustomMetric on a property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   UpdateCustomMetricRequest request =
   *       UpdateCustomMetricRequest.newBuilder()
   *           .setCustomMetric(CustomMetric.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<CustomMetric> future =
   *       analyticsAdminServiceClient.updateCustomMetricCallable().futureCall(request);
   *   // Do something.
   *   CustomMetric response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateCustomMetricRequest, CustomMetric> updateCustomMetricCallable() {
    return stub.updateCustomMetricCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists CustomMetrics on a property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   PropertyName parent = PropertyName.of("[PROPERTY]");
   *   for (CustomMetric element :
   *       analyticsAdminServiceClient.listCustomMetrics(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Example format: properties/1234
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCustomMetricsPagedResponse listCustomMetrics(PropertyName parent) {
    ListCustomMetricsRequest request =
        ListCustomMetricsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listCustomMetrics(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists CustomMetrics on a property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   String parent = PropertyName.of("[PROPERTY]").toString();
   *   for (CustomMetric element :
   *       analyticsAdminServiceClient.listCustomMetrics(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Example format: properties/1234
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCustomMetricsPagedResponse listCustomMetrics(String parent) {
    ListCustomMetricsRequest request =
        ListCustomMetricsRequest.newBuilder().setParent(parent).build();
    return listCustomMetrics(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists CustomMetrics on a property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   ListCustomMetricsRequest request =
   *       ListCustomMetricsRequest.newBuilder()
   *           .setParent(PropertyName.of("[PROPERTY]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (CustomMetric element :
   *       analyticsAdminServiceClient.listCustomMetrics(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCustomMetricsPagedResponse listCustomMetrics(ListCustomMetricsRequest request) {
    return listCustomMetricsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists CustomMetrics on a property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   ListCustomMetricsRequest request =
   *       ListCustomMetricsRequest.newBuilder()
   *           .setParent(PropertyName.of("[PROPERTY]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<CustomMetric> future =
   *       analyticsAdminServiceClient.listCustomMetricsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (CustomMetric element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListCustomMetricsRequest, ListCustomMetricsPagedResponse>
      listCustomMetricsPagedCallable() {
    return stub.listCustomMetricsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists CustomMetrics on a property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   ListCustomMetricsRequest request =
   *       ListCustomMetricsRequest.newBuilder()
   *           .setParent(PropertyName.of("[PROPERTY]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListCustomMetricsResponse response =
   *         analyticsAdminServiceClient.listCustomMetricsCallable().call(request);
   *     for (CustomMetric element : response.getCustomMetricsList()) {
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
  public final UnaryCallable<ListCustomMetricsRequest, ListCustomMetricsResponse>
      listCustomMetricsCallable() {
    return stub.listCustomMetricsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Archives a CustomMetric on a property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   CustomMetricName name = CustomMetricName.of("[PROPERTY]", "[CUSTOM_METRIC]");
   *   analyticsAdminServiceClient.archiveCustomMetric(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the CustomMetric to archive. Example format:
   *     properties/1234/customMetrics/5678
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void archiveCustomMetric(CustomMetricName name) {
    ArchiveCustomMetricRequest request =
        ArchiveCustomMetricRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    archiveCustomMetric(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Archives a CustomMetric on a property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   String name = CustomMetricName.of("[PROPERTY]", "[CUSTOM_METRIC]").toString();
   *   analyticsAdminServiceClient.archiveCustomMetric(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the CustomMetric to archive. Example format:
   *     properties/1234/customMetrics/5678
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void archiveCustomMetric(String name) {
    ArchiveCustomMetricRequest request =
        ArchiveCustomMetricRequest.newBuilder().setName(name).build();
    archiveCustomMetric(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Archives a CustomMetric on a property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   ArchiveCustomMetricRequest request =
   *       ArchiveCustomMetricRequest.newBuilder()
   *           .setName(CustomMetricName.of("[PROPERTY]", "[CUSTOM_METRIC]").toString())
   *           .build();
   *   analyticsAdminServiceClient.archiveCustomMetric(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void archiveCustomMetric(ArchiveCustomMetricRequest request) {
    archiveCustomMetricCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Archives a CustomMetric on a property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   ArchiveCustomMetricRequest request =
   *       ArchiveCustomMetricRequest.newBuilder()
   *           .setName(CustomMetricName.of("[PROPERTY]", "[CUSTOM_METRIC]").toString())
   *           .build();
   *   ApiFuture<Empty> future =
   *       analyticsAdminServiceClient.archiveCustomMetricCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ArchiveCustomMetricRequest, Empty> archiveCustomMetricCallable() {
    return stub.archiveCustomMetricCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lookup for a single CustomMetric.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   CustomMetricName name = CustomMetricName.of("[PROPERTY]", "[CUSTOM_METRIC]");
   *   CustomMetric response = analyticsAdminServiceClient.getCustomMetric(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the CustomMetric to get. Example format:
   *     properties/1234/customMetrics/5678
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CustomMetric getCustomMetric(CustomMetricName name) {
    GetCustomMetricRequest request =
        GetCustomMetricRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getCustomMetric(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lookup for a single CustomMetric.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   String name = CustomMetricName.of("[PROPERTY]", "[CUSTOM_METRIC]").toString();
   *   CustomMetric response = analyticsAdminServiceClient.getCustomMetric(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the CustomMetric to get. Example format:
   *     properties/1234/customMetrics/5678
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CustomMetric getCustomMetric(String name) {
    GetCustomMetricRequest request = GetCustomMetricRequest.newBuilder().setName(name).build();
    return getCustomMetric(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lookup for a single CustomMetric.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   GetCustomMetricRequest request =
   *       GetCustomMetricRequest.newBuilder()
   *           .setName(CustomMetricName.of("[PROPERTY]", "[CUSTOM_METRIC]").toString())
   *           .build();
   *   CustomMetric response = analyticsAdminServiceClient.getCustomMetric(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CustomMetric getCustomMetric(GetCustomMetricRequest request) {
    return getCustomMetricCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lookup for a single CustomMetric.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   GetCustomMetricRequest request =
   *       GetCustomMetricRequest.newBuilder()
   *           .setName(CustomMetricName.of("[PROPERTY]", "[CUSTOM_METRIC]").toString())
   *           .build();
   *   ApiFuture<CustomMetric> future =
   *       analyticsAdminServiceClient.getCustomMetricCallable().futureCall(request);
   *   // Do something.
   *   CustomMetric response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetCustomMetricRequest, CustomMetric> getCustomMetricCallable() {
    return stub.getCustomMetricCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the singleton data retention settings for this property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   DataRetentionSettingsName name = DataRetentionSettingsName.of("[PROPERTY]");
   *   DataRetentionSettings response = analyticsAdminServiceClient.getDataRetentionSettings(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the settings to lookup. Format:
   *     properties/{property}/dataRetentionSettings Example:
   *     "properties/1000/dataRetentionSettings"
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DataRetentionSettings getDataRetentionSettings(DataRetentionSettingsName name) {
    GetDataRetentionSettingsRequest request =
        GetDataRetentionSettingsRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getDataRetentionSettings(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the singleton data retention settings for this property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   String name = DataRetentionSettingsName.of("[PROPERTY]").toString();
   *   DataRetentionSettings response = analyticsAdminServiceClient.getDataRetentionSettings(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the settings to lookup. Format:
   *     properties/{property}/dataRetentionSettings Example:
   *     "properties/1000/dataRetentionSettings"
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DataRetentionSettings getDataRetentionSettings(String name) {
    GetDataRetentionSettingsRequest request =
        GetDataRetentionSettingsRequest.newBuilder().setName(name).build();
    return getDataRetentionSettings(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the singleton data retention settings for this property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   GetDataRetentionSettingsRequest request =
   *       GetDataRetentionSettingsRequest.newBuilder()
   *           .setName(DataRetentionSettingsName.of("[PROPERTY]").toString())
   *           .build();
   *   DataRetentionSettings response =
   *       analyticsAdminServiceClient.getDataRetentionSettings(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DataRetentionSettings getDataRetentionSettings(
      GetDataRetentionSettingsRequest request) {
    return getDataRetentionSettingsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the singleton data retention settings for this property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   GetDataRetentionSettingsRequest request =
   *       GetDataRetentionSettingsRequest.newBuilder()
   *           .setName(DataRetentionSettingsName.of("[PROPERTY]").toString())
   *           .build();
   *   ApiFuture<DataRetentionSettings> future =
   *       analyticsAdminServiceClient.getDataRetentionSettingsCallable().futureCall(request);
   *   // Do something.
   *   DataRetentionSettings response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetDataRetentionSettingsRequest, DataRetentionSettings>
      getDataRetentionSettingsCallable() {
    return stub.getDataRetentionSettingsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the singleton data retention settings for this property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   DataRetentionSettings dataRetentionSettings = DataRetentionSettings.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   DataRetentionSettings response =
   *       analyticsAdminServiceClient.updateDataRetentionSettings(
   *           dataRetentionSettings, updateMask);
   * }
   * }</pre>
   *
   * @param dataRetentionSettings Required. The settings to update. The `name` field is used to
   *     identify the settings to be updated.
   * @param updateMask Required. The list of fields to be updated. Field names must be in snake case
   *     (e.g., "field_to_update"). Omitted fields will not be updated. To replace the entire
   *     entity, use one path with the string "&#42;" to match all fields.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DataRetentionSettings updateDataRetentionSettings(
      DataRetentionSettings dataRetentionSettings, FieldMask updateMask) {
    UpdateDataRetentionSettingsRequest request =
        UpdateDataRetentionSettingsRequest.newBuilder()
            .setDataRetentionSettings(dataRetentionSettings)
            .setUpdateMask(updateMask)
            .build();
    return updateDataRetentionSettings(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the singleton data retention settings for this property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   UpdateDataRetentionSettingsRequest request =
   *       UpdateDataRetentionSettingsRequest.newBuilder()
   *           .setDataRetentionSettings(DataRetentionSettings.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   DataRetentionSettings response =
   *       analyticsAdminServiceClient.updateDataRetentionSettings(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DataRetentionSettings updateDataRetentionSettings(
      UpdateDataRetentionSettingsRequest request) {
    return updateDataRetentionSettingsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the singleton data retention settings for this property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   UpdateDataRetentionSettingsRequest request =
   *       UpdateDataRetentionSettingsRequest.newBuilder()
   *           .setDataRetentionSettings(DataRetentionSettings.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<DataRetentionSettings> future =
   *       analyticsAdminServiceClient.updateDataRetentionSettingsCallable().futureCall(request);
   *   // Do something.
   *   DataRetentionSettings response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateDataRetentionSettingsRequest, DataRetentionSettings>
      updateDataRetentionSettingsCallable() {
    return stub.updateDataRetentionSettingsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a DataStream.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   PropertyName parent = PropertyName.of("[PROPERTY]");
   *   DataStream dataStream = DataStream.newBuilder().build();
   *   DataStream response = analyticsAdminServiceClient.createDataStream(parent, dataStream);
   * }
   * }</pre>
   *
   * @param parent Required. Example format: properties/1234
   * @param dataStream Required. The DataStream to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DataStream createDataStream(PropertyName parent, DataStream dataStream) {
    CreateDataStreamRequest request =
        CreateDataStreamRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setDataStream(dataStream)
            .build();
    return createDataStream(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a DataStream.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   String parent = PropertyName.of("[PROPERTY]").toString();
   *   DataStream dataStream = DataStream.newBuilder().build();
   *   DataStream response = analyticsAdminServiceClient.createDataStream(parent, dataStream);
   * }
   * }</pre>
   *
   * @param parent Required. Example format: properties/1234
   * @param dataStream Required. The DataStream to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DataStream createDataStream(String parent, DataStream dataStream) {
    CreateDataStreamRequest request =
        CreateDataStreamRequest.newBuilder().setParent(parent).setDataStream(dataStream).build();
    return createDataStream(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a DataStream.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   CreateDataStreamRequest request =
   *       CreateDataStreamRequest.newBuilder()
   *           .setParent(PropertyName.of("[PROPERTY]").toString())
   *           .setDataStream(DataStream.newBuilder().build())
   *           .build();
   *   DataStream response = analyticsAdminServiceClient.createDataStream(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DataStream createDataStream(CreateDataStreamRequest request) {
    return createDataStreamCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a DataStream.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   CreateDataStreamRequest request =
   *       CreateDataStreamRequest.newBuilder()
   *           .setParent(PropertyName.of("[PROPERTY]").toString())
   *           .setDataStream(DataStream.newBuilder().build())
   *           .build();
   *   ApiFuture<DataStream> future =
   *       analyticsAdminServiceClient.createDataStreamCallable().futureCall(request);
   *   // Do something.
   *   DataStream response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateDataStreamRequest, DataStream> createDataStreamCallable() {
    return stub.createDataStreamCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a DataStream on a property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   DataStreamName name = DataStreamName.of("[PROPERTY]", "[DATA_STREAM]");
   *   analyticsAdminServiceClient.deleteDataStream(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the DataStream to delete. Example format:
   *     properties/1234/dataStreams/5678
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteDataStream(DataStreamName name) {
    DeleteDataStreamRequest request =
        DeleteDataStreamRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    deleteDataStream(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a DataStream on a property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   String name = DataStreamName.of("[PROPERTY]", "[DATA_STREAM]").toString();
   *   analyticsAdminServiceClient.deleteDataStream(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the DataStream to delete. Example format:
   *     properties/1234/dataStreams/5678
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteDataStream(String name) {
    DeleteDataStreamRequest request = DeleteDataStreamRequest.newBuilder().setName(name).build();
    deleteDataStream(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a DataStream on a property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   DeleteDataStreamRequest request =
   *       DeleteDataStreamRequest.newBuilder()
   *           .setName(DataStreamName.of("[PROPERTY]", "[DATA_STREAM]").toString())
   *           .build();
   *   analyticsAdminServiceClient.deleteDataStream(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteDataStream(DeleteDataStreamRequest request) {
    deleteDataStreamCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a DataStream on a property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   DeleteDataStreamRequest request =
   *       DeleteDataStreamRequest.newBuilder()
   *           .setName(DataStreamName.of("[PROPERTY]", "[DATA_STREAM]").toString())
   *           .build();
   *   ApiFuture<Empty> future =
   *       analyticsAdminServiceClient.deleteDataStreamCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteDataStreamRequest, Empty> deleteDataStreamCallable() {
    return stub.deleteDataStreamCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a DataStream on a property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   DataStream dataStream = DataStream.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   DataStream response = analyticsAdminServiceClient.updateDataStream(dataStream, updateMask);
   * }
   * }</pre>
   *
   * @param dataStream The DataStream to update
   * @param updateMask Required. The list of fields to be updated. Omitted fields will not be
   *     updated. To replace the entire entity, use one path with the string "&#42;" to match all
   *     fields.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DataStream updateDataStream(DataStream dataStream, FieldMask updateMask) {
    UpdateDataStreamRequest request =
        UpdateDataStreamRequest.newBuilder()
            .setDataStream(dataStream)
            .setUpdateMask(updateMask)
            .build();
    return updateDataStream(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a DataStream on a property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   UpdateDataStreamRequest request =
   *       UpdateDataStreamRequest.newBuilder()
   *           .setDataStream(DataStream.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   DataStream response = analyticsAdminServiceClient.updateDataStream(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DataStream updateDataStream(UpdateDataStreamRequest request) {
    return updateDataStreamCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a DataStream on a property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   UpdateDataStreamRequest request =
   *       UpdateDataStreamRequest.newBuilder()
   *           .setDataStream(DataStream.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<DataStream> future =
   *       analyticsAdminServiceClient.updateDataStreamCallable().futureCall(request);
   *   // Do something.
   *   DataStream response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateDataStreamRequest, DataStream> updateDataStreamCallable() {
    return stub.updateDataStreamCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists DataStreams on a property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   PropertyName parent = PropertyName.of("[PROPERTY]");
   *   for (DataStream element : analyticsAdminServiceClient.listDataStreams(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Example format: properties/1234
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDataStreamsPagedResponse listDataStreams(PropertyName parent) {
    ListDataStreamsRequest request =
        ListDataStreamsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listDataStreams(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists DataStreams on a property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   String parent = PropertyName.of("[PROPERTY]").toString();
   *   for (DataStream element : analyticsAdminServiceClient.listDataStreams(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Example format: properties/1234
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDataStreamsPagedResponse listDataStreams(String parent) {
    ListDataStreamsRequest request = ListDataStreamsRequest.newBuilder().setParent(parent).build();
    return listDataStreams(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists DataStreams on a property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   ListDataStreamsRequest request =
   *       ListDataStreamsRequest.newBuilder()
   *           .setParent(PropertyName.of("[PROPERTY]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (DataStream element : analyticsAdminServiceClient.listDataStreams(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDataStreamsPagedResponse listDataStreams(ListDataStreamsRequest request) {
    return listDataStreamsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists DataStreams on a property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   ListDataStreamsRequest request =
   *       ListDataStreamsRequest.newBuilder()
   *           .setParent(PropertyName.of("[PROPERTY]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<DataStream> future =
   *       analyticsAdminServiceClient.listDataStreamsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (DataStream element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListDataStreamsRequest, ListDataStreamsPagedResponse>
      listDataStreamsPagedCallable() {
    return stub.listDataStreamsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists DataStreams on a property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   ListDataStreamsRequest request =
   *       ListDataStreamsRequest.newBuilder()
   *           .setParent(PropertyName.of("[PROPERTY]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListDataStreamsResponse response =
   *         analyticsAdminServiceClient.listDataStreamsCallable().call(request);
   *     for (DataStream element : response.getDataStreamsList()) {
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
  public final UnaryCallable<ListDataStreamsRequest, ListDataStreamsResponse>
      listDataStreamsCallable() {
    return stub.listDataStreamsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lookup for a single DataStream.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   DataStreamName name = DataStreamName.of("[PROPERTY]", "[DATA_STREAM]");
   *   DataStream response = analyticsAdminServiceClient.getDataStream(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the DataStream to get. Example format:
   *     properties/1234/dataStreams/5678
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DataStream getDataStream(DataStreamName name) {
    GetDataStreamRequest request =
        GetDataStreamRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getDataStream(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lookup for a single DataStream.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   String name = DataStreamName.of("[PROPERTY]", "[DATA_STREAM]").toString();
   *   DataStream response = analyticsAdminServiceClient.getDataStream(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the DataStream to get. Example format:
   *     properties/1234/dataStreams/5678
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DataStream getDataStream(String name) {
    GetDataStreamRequest request = GetDataStreamRequest.newBuilder().setName(name).build();
    return getDataStream(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lookup for a single DataStream.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   GetDataStreamRequest request =
   *       GetDataStreamRequest.newBuilder()
   *           .setName(DataStreamName.of("[PROPERTY]", "[DATA_STREAM]").toString())
   *           .build();
   *   DataStream response = analyticsAdminServiceClient.getDataStream(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DataStream getDataStream(GetDataStreamRequest request) {
    return getDataStreamCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lookup for a single DataStream.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   GetDataStreamRequest request =
   *       GetDataStreamRequest.newBuilder()
   *           .setName(DataStreamName.of("[PROPERTY]", "[DATA_STREAM]").toString())
   *           .build();
   *   ApiFuture<DataStream> future =
   *       analyticsAdminServiceClient.getDataStreamCallable().futureCall(request);
   *   // Do something.
   *   DataStream response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetDataStreamRequest, DataStream> getDataStreamCallable() {
    return stub.getDataStreamCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lookup for a single Audience. Audiences created before 2020 may not be supported. Default
   * audiences will not show filter definitions.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   AudienceName name = AudienceName.of("[PROPERTY]", "[AUDIENCE]");
   *   Audience response = analyticsAdminServiceClient.getAudience(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the Audience to get. Example format:
   *     properties/1234/audiences/5678
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Audience getAudience(AudienceName name) {
    GetAudienceRequest request =
        GetAudienceRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getAudience(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lookup for a single Audience. Audiences created before 2020 may not be supported. Default
   * audiences will not show filter definitions.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   String name = AudienceName.of("[PROPERTY]", "[AUDIENCE]").toString();
   *   Audience response = analyticsAdminServiceClient.getAudience(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the Audience to get. Example format:
   *     properties/1234/audiences/5678
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Audience getAudience(String name) {
    GetAudienceRequest request = GetAudienceRequest.newBuilder().setName(name).build();
    return getAudience(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lookup for a single Audience. Audiences created before 2020 may not be supported. Default
   * audiences will not show filter definitions.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   GetAudienceRequest request =
   *       GetAudienceRequest.newBuilder()
   *           .setName(AudienceName.of("[PROPERTY]", "[AUDIENCE]").toString())
   *           .build();
   *   Audience response = analyticsAdminServiceClient.getAudience(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Audience getAudience(GetAudienceRequest request) {
    return getAudienceCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lookup for a single Audience. Audiences created before 2020 may not be supported. Default
   * audiences will not show filter definitions.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   GetAudienceRequest request =
   *       GetAudienceRequest.newBuilder()
   *           .setName(AudienceName.of("[PROPERTY]", "[AUDIENCE]").toString())
   *           .build();
   *   ApiFuture<Audience> future =
   *       analyticsAdminServiceClient.getAudienceCallable().futureCall(request);
   *   // Do something.
   *   Audience response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetAudienceRequest, Audience> getAudienceCallable() {
    return stub.getAudienceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Audiences on a property. Audiences created before 2020 may not be supported. Default
   * audiences will not show filter definitions.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   PropertyName parent = PropertyName.of("[PROPERTY]");
   *   for (Audience element : analyticsAdminServiceClient.listAudiences(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Example format: properties/1234
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAudiencesPagedResponse listAudiences(PropertyName parent) {
    ListAudiencesRequest request =
        ListAudiencesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listAudiences(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Audiences on a property. Audiences created before 2020 may not be supported. Default
   * audiences will not show filter definitions.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   String parent = PropertyName.of("[PROPERTY]").toString();
   *   for (Audience element : analyticsAdminServiceClient.listAudiences(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Example format: properties/1234
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAudiencesPagedResponse listAudiences(String parent) {
    ListAudiencesRequest request = ListAudiencesRequest.newBuilder().setParent(parent).build();
    return listAudiences(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Audiences on a property. Audiences created before 2020 may not be supported. Default
   * audiences will not show filter definitions.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   ListAudiencesRequest request =
   *       ListAudiencesRequest.newBuilder()
   *           .setParent(PropertyName.of("[PROPERTY]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Audience element : analyticsAdminServiceClient.listAudiences(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAudiencesPagedResponse listAudiences(ListAudiencesRequest request) {
    return listAudiencesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Audiences on a property. Audiences created before 2020 may not be supported. Default
   * audiences will not show filter definitions.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   ListAudiencesRequest request =
   *       ListAudiencesRequest.newBuilder()
   *           .setParent(PropertyName.of("[PROPERTY]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Audience> future =
   *       analyticsAdminServiceClient.listAudiencesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Audience element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListAudiencesRequest, ListAudiencesPagedResponse>
      listAudiencesPagedCallable() {
    return stub.listAudiencesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Audiences on a property. Audiences created before 2020 may not be supported. Default
   * audiences will not show filter definitions.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   ListAudiencesRequest request =
   *       ListAudiencesRequest.newBuilder()
   *           .setParent(PropertyName.of("[PROPERTY]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListAudiencesResponse response =
   *         analyticsAdminServiceClient.listAudiencesCallable().call(request);
   *     for (Audience element : response.getAudiencesList()) {
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
  public final UnaryCallable<ListAudiencesRequest, ListAudiencesResponse> listAudiencesCallable() {
    return stub.listAudiencesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an Audience.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   PropertyName parent = PropertyName.of("[PROPERTY]");
   *   Audience audience = Audience.newBuilder().build();
   *   Audience response = analyticsAdminServiceClient.createAudience(parent, audience);
   * }
   * }</pre>
   *
   * @param parent Required. Example format: properties/1234
   * @param audience Required. The audience to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Audience createAudience(PropertyName parent, Audience audience) {
    CreateAudienceRequest request =
        CreateAudienceRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setAudience(audience)
            .build();
    return createAudience(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an Audience.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   String parent = PropertyName.of("[PROPERTY]").toString();
   *   Audience audience = Audience.newBuilder().build();
   *   Audience response = analyticsAdminServiceClient.createAudience(parent, audience);
   * }
   * }</pre>
   *
   * @param parent Required. Example format: properties/1234
   * @param audience Required. The audience to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Audience createAudience(String parent, Audience audience) {
    CreateAudienceRequest request =
        CreateAudienceRequest.newBuilder().setParent(parent).setAudience(audience).build();
    return createAudience(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an Audience.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   CreateAudienceRequest request =
   *       CreateAudienceRequest.newBuilder()
   *           .setParent(PropertyName.of("[PROPERTY]").toString())
   *           .setAudience(Audience.newBuilder().build())
   *           .build();
   *   Audience response = analyticsAdminServiceClient.createAudience(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Audience createAudience(CreateAudienceRequest request) {
    return createAudienceCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an Audience.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   CreateAudienceRequest request =
   *       CreateAudienceRequest.newBuilder()
   *           .setParent(PropertyName.of("[PROPERTY]").toString())
   *           .setAudience(Audience.newBuilder().build())
   *           .build();
   *   ApiFuture<Audience> future =
   *       analyticsAdminServiceClient.createAudienceCallable().futureCall(request);
   *   // Do something.
   *   Audience response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateAudienceRequest, Audience> createAudienceCallable() {
    return stub.createAudienceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an Audience on a property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   Audience audience = Audience.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Audience response = analyticsAdminServiceClient.updateAudience(audience, updateMask);
   * }
   * }</pre>
   *
   * @param audience Required. The audience to update. The audience's `name` field is used to
   *     identify the audience to be updated.
   * @param updateMask Required. The list of fields to be updated. Field names must be in snake case
   *     (e.g., "field_to_update"). Omitted fields will not be updated. To replace the entire
   *     entity, use one path with the string "&#42;" to match all fields.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Audience updateAudience(Audience audience, FieldMask updateMask) {
    UpdateAudienceRequest request =
        UpdateAudienceRequest.newBuilder().setAudience(audience).setUpdateMask(updateMask).build();
    return updateAudience(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an Audience on a property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   UpdateAudienceRequest request =
   *       UpdateAudienceRequest.newBuilder()
   *           .setAudience(Audience.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Audience response = analyticsAdminServiceClient.updateAudience(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Audience updateAudience(UpdateAudienceRequest request) {
    return updateAudienceCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an Audience on a property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   UpdateAudienceRequest request =
   *       UpdateAudienceRequest.newBuilder()
   *           .setAudience(Audience.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Audience> future =
   *       analyticsAdminServiceClient.updateAudienceCallable().futureCall(request);
   *   // Do something.
   *   Audience response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateAudienceRequest, Audience> updateAudienceCallable() {
    return stub.updateAudienceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Archives an Audience on a property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   ArchiveAudienceRequest request =
   *       ArchiveAudienceRequest.newBuilder()
   *           .setName(PropertyName.of("[PROPERTY]").toString())
   *           .build();
   *   analyticsAdminServiceClient.archiveAudience(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void archiveAudience(ArchiveAudienceRequest request) {
    archiveAudienceCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Archives an Audience on a property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   ArchiveAudienceRequest request =
   *       ArchiveAudienceRequest.newBuilder()
   *           .setName(PropertyName.of("[PROPERTY]").toString())
   *           .build();
   *   ApiFuture<Empty> future =
   *       analyticsAdminServiceClient.archiveAudienceCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ArchiveAudienceRequest, Empty> archiveAudienceCallable() {
    return stub.archiveAudienceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Look up a single SearchAds360Link
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   SearchAds360LinkName name = SearchAds360LinkName.of("[PROPERTY]", "[SEARCH_ADS_360_LINK]");
   *   SearchAds360Link response = analyticsAdminServiceClient.getSearchAds360Link(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the SearchAds360Link to get. Example format:
   *     properties/1234/SearchAds360Link/5678
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SearchAds360Link getSearchAds360Link(SearchAds360LinkName name) {
    GetSearchAds360LinkRequest request =
        GetSearchAds360LinkRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getSearchAds360Link(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Look up a single SearchAds360Link
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   String name = SearchAds360LinkName.of("[PROPERTY]", "[SEARCH_ADS_360_LINK]").toString();
   *   SearchAds360Link response = analyticsAdminServiceClient.getSearchAds360Link(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the SearchAds360Link to get. Example format:
   *     properties/1234/SearchAds360Link/5678
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SearchAds360Link getSearchAds360Link(String name) {
    GetSearchAds360LinkRequest request =
        GetSearchAds360LinkRequest.newBuilder().setName(name).build();
    return getSearchAds360Link(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Look up a single SearchAds360Link
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   GetSearchAds360LinkRequest request =
   *       GetSearchAds360LinkRequest.newBuilder()
   *           .setName(SearchAds360LinkName.of("[PROPERTY]", "[SEARCH_ADS_360_LINK]").toString())
   *           .build();
   *   SearchAds360Link response = analyticsAdminServiceClient.getSearchAds360Link(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SearchAds360Link getSearchAds360Link(GetSearchAds360LinkRequest request) {
    return getSearchAds360LinkCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Look up a single SearchAds360Link
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   GetSearchAds360LinkRequest request =
   *       GetSearchAds360LinkRequest.newBuilder()
   *           .setName(SearchAds360LinkName.of("[PROPERTY]", "[SEARCH_ADS_360_LINK]").toString())
   *           .build();
   *   ApiFuture<SearchAds360Link> future =
   *       analyticsAdminServiceClient.getSearchAds360LinkCallable().futureCall(request);
   *   // Do something.
   *   SearchAds360Link response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetSearchAds360LinkRequest, SearchAds360Link>
      getSearchAds360LinkCallable() {
    return stub.getSearchAds360LinkCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all SearchAds360Links on a property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   PropertyName parent = PropertyName.of("[PROPERTY]");
   *   for (SearchAds360Link element :
   *       analyticsAdminServiceClient.listSearchAds360Links(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Example format: properties/1234
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSearchAds360LinksPagedResponse listSearchAds360Links(PropertyName parent) {
    ListSearchAds360LinksRequest request =
        ListSearchAds360LinksRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listSearchAds360Links(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all SearchAds360Links on a property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   String parent = PropertyName.of("[PROPERTY]").toString();
   *   for (SearchAds360Link element :
   *       analyticsAdminServiceClient.listSearchAds360Links(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Example format: properties/1234
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSearchAds360LinksPagedResponse listSearchAds360Links(String parent) {
    ListSearchAds360LinksRequest request =
        ListSearchAds360LinksRequest.newBuilder().setParent(parent).build();
    return listSearchAds360Links(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all SearchAds360Links on a property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   ListSearchAds360LinksRequest request =
   *       ListSearchAds360LinksRequest.newBuilder()
   *           .setParent(PropertyName.of("[PROPERTY]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (SearchAds360Link element :
   *       analyticsAdminServiceClient.listSearchAds360Links(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSearchAds360LinksPagedResponse listSearchAds360Links(
      ListSearchAds360LinksRequest request) {
    return listSearchAds360LinksPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all SearchAds360Links on a property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   ListSearchAds360LinksRequest request =
   *       ListSearchAds360LinksRequest.newBuilder()
   *           .setParent(PropertyName.of("[PROPERTY]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<SearchAds360Link> future =
   *       analyticsAdminServiceClient.listSearchAds360LinksPagedCallable().futureCall(request);
   *   // Do something.
   *   for (SearchAds360Link element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListSearchAds360LinksRequest, ListSearchAds360LinksPagedResponse>
      listSearchAds360LinksPagedCallable() {
    return stub.listSearchAds360LinksPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all SearchAds360Links on a property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   ListSearchAds360LinksRequest request =
   *       ListSearchAds360LinksRequest.newBuilder()
   *           .setParent(PropertyName.of("[PROPERTY]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListSearchAds360LinksResponse response =
   *         analyticsAdminServiceClient.listSearchAds360LinksCallable().call(request);
   *     for (SearchAds360Link element : response.getSearchAds360LinksList()) {
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
  public final UnaryCallable<ListSearchAds360LinksRequest, ListSearchAds360LinksResponse>
      listSearchAds360LinksCallable() {
    return stub.listSearchAds360LinksCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a SearchAds360Link.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   PropertyName parent = PropertyName.of("[PROPERTY]");
   *   SearchAds360Link searchAds360Link = SearchAds360Link.newBuilder().build();
   *   SearchAds360Link response =
   *       analyticsAdminServiceClient.createSearchAds360Link(parent, searchAds360Link);
   * }
   * }</pre>
   *
   * @param parent Required. Example format: properties/1234
   * @param searchAds360Link Required. The SearchAds360Link to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SearchAds360Link createSearchAds360Link(
      PropertyName parent, SearchAds360Link searchAds360Link) {
    CreateSearchAds360LinkRequest request =
        CreateSearchAds360LinkRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setSearchAds360Link(searchAds360Link)
            .build();
    return createSearchAds360Link(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a SearchAds360Link.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   String parent = PropertyName.of("[PROPERTY]").toString();
   *   SearchAds360Link searchAds360Link = SearchAds360Link.newBuilder().build();
   *   SearchAds360Link response =
   *       analyticsAdminServiceClient.createSearchAds360Link(parent, searchAds360Link);
   * }
   * }</pre>
   *
   * @param parent Required. Example format: properties/1234
   * @param searchAds360Link Required. The SearchAds360Link to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SearchAds360Link createSearchAds360Link(
      String parent, SearchAds360Link searchAds360Link) {
    CreateSearchAds360LinkRequest request =
        CreateSearchAds360LinkRequest.newBuilder()
            .setParent(parent)
            .setSearchAds360Link(searchAds360Link)
            .build();
    return createSearchAds360Link(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a SearchAds360Link.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   CreateSearchAds360LinkRequest request =
   *       CreateSearchAds360LinkRequest.newBuilder()
   *           .setParent(PropertyName.of("[PROPERTY]").toString())
   *           .setSearchAds360Link(SearchAds360Link.newBuilder().build())
   *           .build();
   *   SearchAds360Link response = analyticsAdminServiceClient.createSearchAds360Link(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SearchAds360Link createSearchAds360Link(CreateSearchAds360LinkRequest request) {
    return createSearchAds360LinkCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a SearchAds360Link.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   CreateSearchAds360LinkRequest request =
   *       CreateSearchAds360LinkRequest.newBuilder()
   *           .setParent(PropertyName.of("[PROPERTY]").toString())
   *           .setSearchAds360Link(SearchAds360Link.newBuilder().build())
   *           .build();
   *   ApiFuture<SearchAds360Link> future =
   *       analyticsAdminServiceClient.createSearchAds360LinkCallable().futureCall(request);
   *   // Do something.
   *   SearchAds360Link response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateSearchAds360LinkRequest, SearchAds360Link>
      createSearchAds360LinkCallable() {
    return stub.createSearchAds360LinkCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a SearchAds360Link on a property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   SearchAds360LinkName name = SearchAds360LinkName.of("[PROPERTY]", "[SEARCH_ADS_360_LINK]");
   *   analyticsAdminServiceClient.deleteSearchAds360Link(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the SearchAds360Link to delete. Example format:
   *     properties/1234/SearchAds360Links/5678
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteSearchAds360Link(SearchAds360LinkName name) {
    DeleteSearchAds360LinkRequest request =
        DeleteSearchAds360LinkRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    deleteSearchAds360Link(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a SearchAds360Link on a property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   String name = SearchAds360LinkName.of("[PROPERTY]", "[SEARCH_ADS_360_LINK]").toString();
   *   analyticsAdminServiceClient.deleteSearchAds360Link(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the SearchAds360Link to delete. Example format:
   *     properties/1234/SearchAds360Links/5678
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteSearchAds360Link(String name) {
    DeleteSearchAds360LinkRequest request =
        DeleteSearchAds360LinkRequest.newBuilder().setName(name).build();
    deleteSearchAds360Link(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a SearchAds360Link on a property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   DeleteSearchAds360LinkRequest request =
   *       DeleteSearchAds360LinkRequest.newBuilder()
   *           .setName(SearchAds360LinkName.of("[PROPERTY]", "[SEARCH_ADS_360_LINK]").toString())
   *           .build();
   *   analyticsAdminServiceClient.deleteSearchAds360Link(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteSearchAds360Link(DeleteSearchAds360LinkRequest request) {
    deleteSearchAds360LinkCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a SearchAds360Link on a property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   DeleteSearchAds360LinkRequest request =
   *       DeleteSearchAds360LinkRequest.newBuilder()
   *           .setName(SearchAds360LinkName.of("[PROPERTY]", "[SEARCH_ADS_360_LINK]").toString())
   *           .build();
   *   ApiFuture<Empty> future =
   *       analyticsAdminServiceClient.deleteSearchAds360LinkCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteSearchAds360LinkRequest, Empty>
      deleteSearchAds360LinkCallable() {
    return stub.deleteSearchAds360LinkCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a SearchAds360Link on a property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   SearchAds360Link searchAds360Link = SearchAds360Link.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   SearchAds360Link response =
   *       analyticsAdminServiceClient.updateSearchAds360Link(searchAds360Link, updateMask);
   * }
   * }</pre>
   *
   * @param searchAds360Link The SearchAds360Link to update
   * @param updateMask Required. The list of fields to be updated. Omitted fields will not be
   *     updated. To replace the entire entity, use one path with the string "&#42;" to match all
   *     fields.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SearchAds360Link updateSearchAds360Link(
      SearchAds360Link searchAds360Link, FieldMask updateMask) {
    UpdateSearchAds360LinkRequest request =
        UpdateSearchAds360LinkRequest.newBuilder()
            .setSearchAds360Link(searchAds360Link)
            .setUpdateMask(updateMask)
            .build();
    return updateSearchAds360Link(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a SearchAds360Link on a property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   UpdateSearchAds360LinkRequest request =
   *       UpdateSearchAds360LinkRequest.newBuilder()
   *           .setSearchAds360Link(SearchAds360Link.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   SearchAds360Link response = analyticsAdminServiceClient.updateSearchAds360Link(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SearchAds360Link updateSearchAds360Link(UpdateSearchAds360LinkRequest request) {
    return updateSearchAds360LinkCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a SearchAds360Link on a property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   UpdateSearchAds360LinkRequest request =
   *       UpdateSearchAds360LinkRequest.newBuilder()
   *           .setSearchAds360Link(SearchAds360Link.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<SearchAds360Link> future =
   *       analyticsAdminServiceClient.updateSearchAds360LinkCallable().futureCall(request);
   *   // Do something.
   *   SearchAds360Link response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateSearchAds360LinkRequest, SearchAds360Link>
      updateSearchAds360LinkCallable() {
    return stub.updateSearchAds360LinkCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lookup for a AttributionSettings singleton.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   AttributionSettingsName name = AttributionSettingsName.of("[PROPERTY]");
   *   AttributionSettings response = analyticsAdminServiceClient.getAttributionSettings(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the attribution settings to retrieve. Format:
   *     properties/{property}/attributionSettings
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AttributionSettings getAttributionSettings(AttributionSettingsName name) {
    GetAttributionSettingsRequest request =
        GetAttributionSettingsRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getAttributionSettings(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lookup for a AttributionSettings singleton.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   String name = AttributionSettingsName.of("[PROPERTY]").toString();
   *   AttributionSettings response = analyticsAdminServiceClient.getAttributionSettings(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the attribution settings to retrieve. Format:
   *     properties/{property}/attributionSettings
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AttributionSettings getAttributionSettings(String name) {
    GetAttributionSettingsRequest request =
        GetAttributionSettingsRequest.newBuilder().setName(name).build();
    return getAttributionSettings(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lookup for a AttributionSettings singleton.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   GetAttributionSettingsRequest request =
   *       GetAttributionSettingsRequest.newBuilder()
   *           .setName(AttributionSettingsName.of("[PROPERTY]").toString())
   *           .build();
   *   AttributionSettings response = analyticsAdminServiceClient.getAttributionSettings(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AttributionSettings getAttributionSettings(GetAttributionSettingsRequest request) {
    return getAttributionSettingsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lookup for a AttributionSettings singleton.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   GetAttributionSettingsRequest request =
   *       GetAttributionSettingsRequest.newBuilder()
   *           .setName(AttributionSettingsName.of("[PROPERTY]").toString())
   *           .build();
   *   ApiFuture<AttributionSettings> future =
   *       analyticsAdminServiceClient.getAttributionSettingsCallable().futureCall(request);
   *   // Do something.
   *   AttributionSettings response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetAttributionSettingsRequest, AttributionSettings>
      getAttributionSettingsCallable() {
    return stub.getAttributionSettingsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates attribution settings on a property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   AttributionSettings attributionSettings = AttributionSettings.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   AttributionSettings response =
   *       analyticsAdminServiceClient.updateAttributionSettings(attributionSettings, updateMask);
   * }
   * }</pre>
   *
   * @param attributionSettings Required. The attribution settings to update. The `name` field is
   *     used to identify the settings to be updated.
   * @param updateMask Required. The list of fields to be updated. Field names must be in snake case
   *     (e.g., "field_to_update"). Omitted fields will not be updated. To replace the entire
   *     entity, use one path with the string "&#42;" to match all fields.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AttributionSettings updateAttributionSettings(
      AttributionSettings attributionSettings, FieldMask updateMask) {
    UpdateAttributionSettingsRequest request =
        UpdateAttributionSettingsRequest.newBuilder()
            .setAttributionSettings(attributionSettings)
            .setUpdateMask(updateMask)
            .build();
    return updateAttributionSettings(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates attribution settings on a property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   UpdateAttributionSettingsRequest request =
   *       UpdateAttributionSettingsRequest.newBuilder()
   *           .setAttributionSettings(AttributionSettings.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   AttributionSettings response = analyticsAdminServiceClient.updateAttributionSettings(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AttributionSettings updateAttributionSettings(
      UpdateAttributionSettingsRequest request) {
    return updateAttributionSettingsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates attribution settings on a property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   UpdateAttributionSettingsRequest request =
   *       UpdateAttributionSettingsRequest.newBuilder()
   *           .setAttributionSettings(AttributionSettings.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<AttributionSettings> future =
   *       analyticsAdminServiceClient.updateAttributionSettingsCallable().futureCall(request);
   *   // Do something.
   *   AttributionSettings response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateAttributionSettingsRequest, AttributionSettings>
      updateAttributionSettingsCallable() {
    return stub.updateAttributionSettingsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a customized report of data access records. The report provides records of each time a
   * user reads Google Analytics reporting data. Access records are retained for up to 2 years.
   *
   * <p>Data Access Reports can be requested for a property. Reports may be requested for any
   * property, but dimensions that aren't related to quota can only be requested on Google Analytics
   * 360 properties. This method is only available to Administrators.
   *
   * <p>These data access records include GA4 UI Reporting, GA4 UI Explorations, GA4 Data API, and
   * other products like Firebase &amp; Admob that can retrieve data from Google Analytics through a
   * linkage. These records don't include property configuration changes like adding a stream or
   * changing a property's time zone. For configuration change history, see
   * [searchChangeHistoryEvents](https://developers.google.com/analytics/devguides/config/admin/v1/rest/v1alpha/accounts/searchChangeHistoryEvents).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   RunAccessReportRequest request =
   *       RunAccessReportRequest.newBuilder()
   *           .setEntity("entity-1298275357")
   *           .addAllDimensions(new ArrayList<AccessDimension>())
   *           .addAllMetrics(new ArrayList<AccessMetric>())
   *           .addAllDateRanges(new ArrayList<AccessDateRange>())
   *           .setDimensionFilter(AccessFilterExpression.newBuilder().build())
   *           .setMetricFilter(AccessFilterExpression.newBuilder().build())
   *           .setOffset(-1019779949)
   *           .setLimit(102976443)
   *           .setTimeZone("timeZone-2077180903")
   *           .addAllOrderBys(new ArrayList<AccessOrderBy>())
   *           .setReturnEntityQuota(true)
   *           .setIncludeAllUsers(true)
   *           .setExpandGroups(true)
   *           .build();
   *   RunAccessReportResponse response = analyticsAdminServiceClient.runAccessReport(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RunAccessReportResponse runAccessReport(RunAccessReportRequest request) {
    return runAccessReportCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a customized report of data access records. The report provides records of each time a
   * user reads Google Analytics reporting data. Access records are retained for up to 2 years.
   *
   * <p>Data Access Reports can be requested for a property. Reports may be requested for any
   * property, but dimensions that aren't related to quota can only be requested on Google Analytics
   * 360 properties. This method is only available to Administrators.
   *
   * <p>These data access records include GA4 UI Reporting, GA4 UI Explorations, GA4 Data API, and
   * other products like Firebase &amp; Admob that can retrieve data from Google Analytics through a
   * linkage. These records don't include property configuration changes like adding a stream or
   * changing a property's time zone. For configuration change history, see
   * [searchChangeHistoryEvents](https://developers.google.com/analytics/devguides/config/admin/v1/rest/v1alpha/accounts/searchChangeHistoryEvents).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   RunAccessReportRequest request =
   *       RunAccessReportRequest.newBuilder()
   *           .setEntity("entity-1298275357")
   *           .addAllDimensions(new ArrayList<AccessDimension>())
   *           .addAllMetrics(new ArrayList<AccessMetric>())
   *           .addAllDateRanges(new ArrayList<AccessDateRange>())
   *           .setDimensionFilter(AccessFilterExpression.newBuilder().build())
   *           .setMetricFilter(AccessFilterExpression.newBuilder().build())
   *           .setOffset(-1019779949)
   *           .setLimit(102976443)
   *           .setTimeZone("timeZone-2077180903")
   *           .addAllOrderBys(new ArrayList<AccessOrderBy>())
   *           .setReturnEntityQuota(true)
   *           .setIncludeAllUsers(true)
   *           .setExpandGroups(true)
   *           .build();
   *   ApiFuture<RunAccessReportResponse> future =
   *       analyticsAdminServiceClient.runAccessReportCallable().futureCall(request);
   *   // Do something.
   *   RunAccessReportResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<RunAccessReportRequest, RunAccessReportResponse>
      runAccessReportCallable() {
    return stub.runAccessReportCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an access binding on an account or property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   AccountName parent = AccountName.of("[ACCOUNT]");
   *   AccessBinding accessBinding = AccessBinding.newBuilder().build();
   *   AccessBinding response =
   *       analyticsAdminServiceClient.createAccessBinding(parent, accessBinding);
   * }
   * }</pre>
   *
   * @param parent Required. Formats: - accounts/{account} - properties/{property}
   * @param accessBinding Required. The access binding to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AccessBinding createAccessBinding(AccountName parent, AccessBinding accessBinding) {
    CreateAccessBindingRequest request =
        CreateAccessBindingRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setAccessBinding(accessBinding)
            .build();
    return createAccessBinding(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an access binding on an account or property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   PropertyName parent = PropertyName.of("[PROPERTY]");
   *   AccessBinding accessBinding = AccessBinding.newBuilder().build();
   *   AccessBinding response =
   *       analyticsAdminServiceClient.createAccessBinding(parent, accessBinding);
   * }
   * }</pre>
   *
   * @param parent Required. Formats: - accounts/{account} - properties/{property}
   * @param accessBinding Required. The access binding to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AccessBinding createAccessBinding(PropertyName parent, AccessBinding accessBinding) {
    CreateAccessBindingRequest request =
        CreateAccessBindingRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setAccessBinding(accessBinding)
            .build();
    return createAccessBinding(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an access binding on an account or property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   String parent = AccountName.of("[ACCOUNT]").toString();
   *   AccessBinding accessBinding = AccessBinding.newBuilder().build();
   *   AccessBinding response =
   *       analyticsAdminServiceClient.createAccessBinding(parent, accessBinding);
   * }
   * }</pre>
   *
   * @param parent Required. Formats: - accounts/{account} - properties/{property}
   * @param accessBinding Required. The access binding to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AccessBinding createAccessBinding(String parent, AccessBinding accessBinding) {
    CreateAccessBindingRequest request =
        CreateAccessBindingRequest.newBuilder()
            .setParent(parent)
            .setAccessBinding(accessBinding)
            .build();
    return createAccessBinding(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an access binding on an account or property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   CreateAccessBindingRequest request =
   *       CreateAccessBindingRequest.newBuilder()
   *           .setParent(AccountName.of("[ACCOUNT]").toString())
   *           .setAccessBinding(AccessBinding.newBuilder().build())
   *           .build();
   *   AccessBinding response = analyticsAdminServiceClient.createAccessBinding(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AccessBinding createAccessBinding(CreateAccessBindingRequest request) {
    return createAccessBindingCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an access binding on an account or property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   CreateAccessBindingRequest request =
   *       CreateAccessBindingRequest.newBuilder()
   *           .setParent(AccountName.of("[ACCOUNT]").toString())
   *           .setAccessBinding(AccessBinding.newBuilder().build())
   *           .build();
   *   ApiFuture<AccessBinding> future =
   *       analyticsAdminServiceClient.createAccessBindingCallable().futureCall(request);
   *   // Do something.
   *   AccessBinding response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateAccessBindingRequest, AccessBinding>
      createAccessBindingCallable() {
    return stub.createAccessBindingCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets information about an access binding.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   AccessBindingName name =
   *       AccessBindingName.ofAccountAccessBindingName("[ACCOUNT]", "[ACCESS_BINDING]");
   *   AccessBinding response = analyticsAdminServiceClient.getAccessBinding(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the access binding to retrieve. Formats: -
   *     accounts/{account}/accessBindings/{accessBinding} -
   *     properties/{property}/accessBindings/{accessBinding}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AccessBinding getAccessBinding(AccessBindingName name) {
    GetAccessBindingRequest request =
        GetAccessBindingRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getAccessBinding(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets information about an access binding.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   String name =
   *       AccessBindingName.ofAccountAccessBindingName("[ACCOUNT]", "[ACCESS_BINDING]").toString();
   *   AccessBinding response = analyticsAdminServiceClient.getAccessBinding(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the access binding to retrieve. Formats: -
   *     accounts/{account}/accessBindings/{accessBinding} -
   *     properties/{property}/accessBindings/{accessBinding}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AccessBinding getAccessBinding(String name) {
    GetAccessBindingRequest request = GetAccessBindingRequest.newBuilder().setName(name).build();
    return getAccessBinding(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets information about an access binding.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   GetAccessBindingRequest request =
   *       GetAccessBindingRequest.newBuilder()
   *           .setName(
   *               AccessBindingName.ofAccountAccessBindingName("[ACCOUNT]", "[ACCESS_BINDING]")
   *                   .toString())
   *           .build();
   *   AccessBinding response = analyticsAdminServiceClient.getAccessBinding(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AccessBinding getAccessBinding(GetAccessBindingRequest request) {
    return getAccessBindingCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets information about an access binding.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   GetAccessBindingRequest request =
   *       GetAccessBindingRequest.newBuilder()
   *           .setName(
   *               AccessBindingName.ofAccountAccessBindingName("[ACCOUNT]", "[ACCESS_BINDING]")
   *                   .toString())
   *           .build();
   *   ApiFuture<AccessBinding> future =
   *       analyticsAdminServiceClient.getAccessBindingCallable().futureCall(request);
   *   // Do something.
   *   AccessBinding response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetAccessBindingRequest, AccessBinding> getAccessBindingCallable() {
    return stub.getAccessBindingCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an access binding on an account or property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   AccessBinding accessBinding = AccessBinding.newBuilder().build();
   *   AccessBinding response = analyticsAdminServiceClient.updateAccessBinding(accessBinding);
   * }
   * }</pre>
   *
   * @param accessBinding Required. The access binding to update.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AccessBinding updateAccessBinding(AccessBinding accessBinding) {
    UpdateAccessBindingRequest request =
        UpdateAccessBindingRequest.newBuilder().setAccessBinding(accessBinding).build();
    return updateAccessBinding(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an access binding on an account or property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   UpdateAccessBindingRequest request =
   *       UpdateAccessBindingRequest.newBuilder()
   *           .setAccessBinding(AccessBinding.newBuilder().build())
   *           .build();
   *   AccessBinding response = analyticsAdminServiceClient.updateAccessBinding(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AccessBinding updateAccessBinding(UpdateAccessBindingRequest request) {
    return updateAccessBindingCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an access binding on an account or property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   UpdateAccessBindingRequest request =
   *       UpdateAccessBindingRequest.newBuilder()
   *           .setAccessBinding(AccessBinding.newBuilder().build())
   *           .build();
   *   ApiFuture<AccessBinding> future =
   *       analyticsAdminServiceClient.updateAccessBindingCallable().futureCall(request);
   *   // Do something.
   *   AccessBinding response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateAccessBindingRequest, AccessBinding>
      updateAccessBindingCallable() {
    return stub.updateAccessBindingCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an access binding on an account or property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   AccessBindingName name =
   *       AccessBindingName.ofAccountAccessBindingName("[ACCOUNT]", "[ACCESS_BINDING]");
   *   analyticsAdminServiceClient.deleteAccessBinding(name);
   * }
   * }</pre>
   *
   * @param name Required. Formats: - accounts/{account}/accessBindings/{accessBinding} -
   *     properties/{property}/accessBindings/{accessBinding}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteAccessBinding(AccessBindingName name) {
    DeleteAccessBindingRequest request =
        DeleteAccessBindingRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    deleteAccessBinding(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an access binding on an account or property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   String name =
   *       AccessBindingName.ofAccountAccessBindingName("[ACCOUNT]", "[ACCESS_BINDING]").toString();
   *   analyticsAdminServiceClient.deleteAccessBinding(name);
   * }
   * }</pre>
   *
   * @param name Required. Formats: - accounts/{account}/accessBindings/{accessBinding} -
   *     properties/{property}/accessBindings/{accessBinding}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteAccessBinding(String name) {
    DeleteAccessBindingRequest request =
        DeleteAccessBindingRequest.newBuilder().setName(name).build();
    deleteAccessBinding(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an access binding on an account or property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   DeleteAccessBindingRequest request =
   *       DeleteAccessBindingRequest.newBuilder()
   *           .setName(
   *               AccessBindingName.ofAccountAccessBindingName("[ACCOUNT]", "[ACCESS_BINDING]")
   *                   .toString())
   *           .build();
   *   analyticsAdminServiceClient.deleteAccessBinding(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteAccessBinding(DeleteAccessBindingRequest request) {
    deleteAccessBindingCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an access binding on an account or property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   DeleteAccessBindingRequest request =
   *       DeleteAccessBindingRequest.newBuilder()
   *           .setName(
   *               AccessBindingName.ofAccountAccessBindingName("[ACCOUNT]", "[ACCESS_BINDING]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Empty> future =
   *       analyticsAdminServiceClient.deleteAccessBindingCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteAccessBindingRequest, Empty> deleteAccessBindingCallable() {
    return stub.deleteAccessBindingCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all access bindings on an account or property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   AccountName parent = AccountName.of("[ACCOUNT]");
   *   for (AccessBinding element :
   *       analyticsAdminServiceClient.listAccessBindings(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Formats: - accounts/{account} - properties/{property}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAccessBindingsPagedResponse listAccessBindings(AccountName parent) {
    ListAccessBindingsRequest request =
        ListAccessBindingsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listAccessBindings(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all access bindings on an account or property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   PropertyName parent = PropertyName.of("[PROPERTY]");
   *   for (AccessBinding element :
   *       analyticsAdminServiceClient.listAccessBindings(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Formats: - accounts/{account} - properties/{property}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAccessBindingsPagedResponse listAccessBindings(PropertyName parent) {
    ListAccessBindingsRequest request =
        ListAccessBindingsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listAccessBindings(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all access bindings on an account or property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   String parent = AccountName.of("[ACCOUNT]").toString();
   *   for (AccessBinding element :
   *       analyticsAdminServiceClient.listAccessBindings(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Formats: - accounts/{account} - properties/{property}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAccessBindingsPagedResponse listAccessBindings(String parent) {
    ListAccessBindingsRequest request =
        ListAccessBindingsRequest.newBuilder().setParent(parent).build();
    return listAccessBindings(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all access bindings on an account or property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   ListAccessBindingsRequest request =
   *       ListAccessBindingsRequest.newBuilder()
   *           .setParent(AccountName.of("[ACCOUNT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (AccessBinding element :
   *       analyticsAdminServiceClient.listAccessBindings(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAccessBindingsPagedResponse listAccessBindings(
      ListAccessBindingsRequest request) {
    return listAccessBindingsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all access bindings on an account or property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   ListAccessBindingsRequest request =
   *       ListAccessBindingsRequest.newBuilder()
   *           .setParent(AccountName.of("[ACCOUNT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<AccessBinding> future =
   *       analyticsAdminServiceClient.listAccessBindingsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (AccessBinding element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListAccessBindingsRequest, ListAccessBindingsPagedResponse>
      listAccessBindingsPagedCallable() {
    return stub.listAccessBindingsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all access bindings on an account or property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   ListAccessBindingsRequest request =
   *       ListAccessBindingsRequest.newBuilder()
   *           .setParent(AccountName.of("[ACCOUNT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListAccessBindingsResponse response =
   *         analyticsAdminServiceClient.listAccessBindingsCallable().call(request);
   *     for (AccessBinding element : response.getAccessBindingsList()) {
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
  public final UnaryCallable<ListAccessBindingsRequest, ListAccessBindingsResponse>
      listAccessBindingsCallable() {
    return stub.listAccessBindingsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates information about multiple access bindings to an account or property.
   *
   * <p>This method is transactional. If any AccessBinding cannot be created, none of the
   * AccessBindings will be created.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   BatchCreateAccessBindingsRequest request =
   *       BatchCreateAccessBindingsRequest.newBuilder()
   *           .setParent(AccountName.of("[ACCOUNT]").toString())
   *           .addAllRequests(new ArrayList<CreateAccessBindingRequest>())
   *           .build();
   *   BatchCreateAccessBindingsResponse response =
   *       analyticsAdminServiceClient.batchCreateAccessBindings(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchCreateAccessBindingsResponse batchCreateAccessBindings(
      BatchCreateAccessBindingsRequest request) {
    return batchCreateAccessBindingsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates information about multiple access bindings to an account or property.
   *
   * <p>This method is transactional. If any AccessBinding cannot be created, none of the
   * AccessBindings will be created.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   BatchCreateAccessBindingsRequest request =
   *       BatchCreateAccessBindingsRequest.newBuilder()
   *           .setParent(AccountName.of("[ACCOUNT]").toString())
   *           .addAllRequests(new ArrayList<CreateAccessBindingRequest>())
   *           .build();
   *   ApiFuture<BatchCreateAccessBindingsResponse> future =
   *       analyticsAdminServiceClient.batchCreateAccessBindingsCallable().futureCall(request);
   *   // Do something.
   *   BatchCreateAccessBindingsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<BatchCreateAccessBindingsRequest, BatchCreateAccessBindingsResponse>
      batchCreateAccessBindingsCallable() {
    return stub.batchCreateAccessBindingsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets information about multiple access bindings to an account or property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   BatchGetAccessBindingsRequest request =
   *       BatchGetAccessBindingsRequest.newBuilder()
   *           .setParent(AccountName.of("[ACCOUNT]").toString())
   *           .addAllNames(new ArrayList<String>())
   *           .build();
   *   BatchGetAccessBindingsResponse response =
   *       analyticsAdminServiceClient.batchGetAccessBindings(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchGetAccessBindingsResponse batchGetAccessBindings(
      BatchGetAccessBindingsRequest request) {
    return batchGetAccessBindingsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets information about multiple access bindings to an account or property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   BatchGetAccessBindingsRequest request =
   *       BatchGetAccessBindingsRequest.newBuilder()
   *           .setParent(AccountName.of("[ACCOUNT]").toString())
   *           .addAllNames(new ArrayList<String>())
   *           .build();
   *   ApiFuture<BatchGetAccessBindingsResponse> future =
   *       analyticsAdminServiceClient.batchGetAccessBindingsCallable().futureCall(request);
   *   // Do something.
   *   BatchGetAccessBindingsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<BatchGetAccessBindingsRequest, BatchGetAccessBindingsResponse>
      batchGetAccessBindingsCallable() {
    return stub.batchGetAccessBindingsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates information about multiple access bindings to an account or property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   BatchUpdateAccessBindingsRequest request =
   *       BatchUpdateAccessBindingsRequest.newBuilder()
   *           .setParent(AccountName.of("[ACCOUNT]").toString())
   *           .addAllRequests(new ArrayList<UpdateAccessBindingRequest>())
   *           .build();
   *   BatchUpdateAccessBindingsResponse response =
   *       analyticsAdminServiceClient.batchUpdateAccessBindings(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchUpdateAccessBindingsResponse batchUpdateAccessBindings(
      BatchUpdateAccessBindingsRequest request) {
    return batchUpdateAccessBindingsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates information about multiple access bindings to an account or property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   BatchUpdateAccessBindingsRequest request =
   *       BatchUpdateAccessBindingsRequest.newBuilder()
   *           .setParent(AccountName.of("[ACCOUNT]").toString())
   *           .addAllRequests(new ArrayList<UpdateAccessBindingRequest>())
   *           .build();
   *   ApiFuture<BatchUpdateAccessBindingsResponse> future =
   *       analyticsAdminServiceClient.batchUpdateAccessBindingsCallable().futureCall(request);
   *   // Do something.
   *   BatchUpdateAccessBindingsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<BatchUpdateAccessBindingsRequest, BatchUpdateAccessBindingsResponse>
      batchUpdateAccessBindingsCallable() {
    return stub.batchUpdateAccessBindingsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes information about multiple users' links to an account or property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   BatchDeleteAccessBindingsRequest request =
   *       BatchDeleteAccessBindingsRequest.newBuilder()
   *           .setParent(AccountName.of("[ACCOUNT]").toString())
   *           .addAllRequests(new ArrayList<DeleteAccessBindingRequest>())
   *           .build();
   *   analyticsAdminServiceClient.batchDeleteAccessBindings(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void batchDeleteAccessBindings(BatchDeleteAccessBindingsRequest request) {
    batchDeleteAccessBindingsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes information about multiple users' links to an account or property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   BatchDeleteAccessBindingsRequest request =
   *       BatchDeleteAccessBindingsRequest.newBuilder()
   *           .setParent(AccountName.of("[ACCOUNT]").toString())
   *           .addAllRequests(new ArrayList<DeleteAccessBindingRequest>())
   *           .build();
   *   ApiFuture<Empty> future =
   *       analyticsAdminServiceClient.batchDeleteAccessBindingsCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<BatchDeleteAccessBindingsRequest, Empty>
      batchDeleteAccessBindingsCallable() {
    return stub.batchDeleteAccessBindingsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lookup for a single ExpandedDataSet.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   ExpandedDataSetName name = ExpandedDataSetName.of("[PROPERTY]", "[EXPANDED_DATA_SET]");
   *   ExpandedDataSet response = analyticsAdminServiceClient.getExpandedDataSet(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the ExpandedDataSet to get. Example format:
   *     properties/1234/expandedDataSets/5678
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ExpandedDataSet getExpandedDataSet(ExpandedDataSetName name) {
    GetExpandedDataSetRequest request =
        GetExpandedDataSetRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getExpandedDataSet(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lookup for a single ExpandedDataSet.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   String name = ExpandedDataSetName.of("[PROPERTY]", "[EXPANDED_DATA_SET]").toString();
   *   ExpandedDataSet response = analyticsAdminServiceClient.getExpandedDataSet(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the ExpandedDataSet to get. Example format:
   *     properties/1234/expandedDataSets/5678
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ExpandedDataSet getExpandedDataSet(String name) {
    GetExpandedDataSetRequest request =
        GetExpandedDataSetRequest.newBuilder().setName(name).build();
    return getExpandedDataSet(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lookup for a single ExpandedDataSet.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   GetExpandedDataSetRequest request =
   *       GetExpandedDataSetRequest.newBuilder()
   *           .setName(ExpandedDataSetName.of("[PROPERTY]", "[EXPANDED_DATA_SET]").toString())
   *           .build();
   *   ExpandedDataSet response = analyticsAdminServiceClient.getExpandedDataSet(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ExpandedDataSet getExpandedDataSet(GetExpandedDataSetRequest request) {
    return getExpandedDataSetCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lookup for a single ExpandedDataSet.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   GetExpandedDataSetRequest request =
   *       GetExpandedDataSetRequest.newBuilder()
   *           .setName(ExpandedDataSetName.of("[PROPERTY]", "[EXPANDED_DATA_SET]").toString())
   *           .build();
   *   ApiFuture<ExpandedDataSet> future =
   *       analyticsAdminServiceClient.getExpandedDataSetCallable().futureCall(request);
   *   // Do something.
   *   ExpandedDataSet response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetExpandedDataSetRequest, ExpandedDataSet>
      getExpandedDataSetCallable() {
    return stub.getExpandedDataSetCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists ExpandedDataSets on a property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   PropertyName parent = PropertyName.of("[PROPERTY]");
   *   for (ExpandedDataSet element :
   *       analyticsAdminServiceClient.listExpandedDataSets(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Example format: properties/1234
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListExpandedDataSetsPagedResponse listExpandedDataSets(PropertyName parent) {
    ListExpandedDataSetsRequest request =
        ListExpandedDataSetsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listExpandedDataSets(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists ExpandedDataSets on a property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   String parent = PropertyName.of("[PROPERTY]").toString();
   *   for (ExpandedDataSet element :
   *       analyticsAdminServiceClient.listExpandedDataSets(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Example format: properties/1234
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListExpandedDataSetsPagedResponse listExpandedDataSets(String parent) {
    ListExpandedDataSetsRequest request =
        ListExpandedDataSetsRequest.newBuilder().setParent(parent).build();
    return listExpandedDataSets(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists ExpandedDataSets on a property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   ListExpandedDataSetsRequest request =
   *       ListExpandedDataSetsRequest.newBuilder()
   *           .setParent(PropertyName.of("[PROPERTY]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (ExpandedDataSet element :
   *       analyticsAdminServiceClient.listExpandedDataSets(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListExpandedDataSetsPagedResponse listExpandedDataSets(
      ListExpandedDataSetsRequest request) {
    return listExpandedDataSetsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists ExpandedDataSets on a property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   ListExpandedDataSetsRequest request =
   *       ListExpandedDataSetsRequest.newBuilder()
   *           .setParent(PropertyName.of("[PROPERTY]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<ExpandedDataSet> future =
   *       analyticsAdminServiceClient.listExpandedDataSetsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (ExpandedDataSet element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListExpandedDataSetsRequest, ListExpandedDataSetsPagedResponse>
      listExpandedDataSetsPagedCallable() {
    return stub.listExpandedDataSetsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists ExpandedDataSets on a property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   ListExpandedDataSetsRequest request =
   *       ListExpandedDataSetsRequest.newBuilder()
   *           .setParent(PropertyName.of("[PROPERTY]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListExpandedDataSetsResponse response =
   *         analyticsAdminServiceClient.listExpandedDataSetsCallable().call(request);
   *     for (ExpandedDataSet element : response.getExpandedDataSetsList()) {
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
  public final UnaryCallable<ListExpandedDataSetsRequest, ListExpandedDataSetsResponse>
      listExpandedDataSetsCallable() {
    return stub.listExpandedDataSetsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a ExpandedDataSet.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   PropertyName parent = PropertyName.of("[PROPERTY]");
   *   ExpandedDataSet expandedDataSet = ExpandedDataSet.newBuilder().build();
   *   ExpandedDataSet response =
   *       analyticsAdminServiceClient.createExpandedDataSet(parent, expandedDataSet);
   * }
   * }</pre>
   *
   * @param parent Required. Example format: properties/1234
   * @param expandedDataSet Required. The ExpandedDataSet to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ExpandedDataSet createExpandedDataSet(
      PropertyName parent, ExpandedDataSet expandedDataSet) {
    CreateExpandedDataSetRequest request =
        CreateExpandedDataSetRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setExpandedDataSet(expandedDataSet)
            .build();
    return createExpandedDataSet(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a ExpandedDataSet.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   String parent = PropertyName.of("[PROPERTY]").toString();
   *   ExpandedDataSet expandedDataSet = ExpandedDataSet.newBuilder().build();
   *   ExpandedDataSet response =
   *       analyticsAdminServiceClient.createExpandedDataSet(parent, expandedDataSet);
   * }
   * }</pre>
   *
   * @param parent Required. Example format: properties/1234
   * @param expandedDataSet Required. The ExpandedDataSet to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ExpandedDataSet createExpandedDataSet(
      String parent, ExpandedDataSet expandedDataSet) {
    CreateExpandedDataSetRequest request =
        CreateExpandedDataSetRequest.newBuilder()
            .setParent(parent)
            .setExpandedDataSet(expandedDataSet)
            .build();
    return createExpandedDataSet(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a ExpandedDataSet.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   CreateExpandedDataSetRequest request =
   *       CreateExpandedDataSetRequest.newBuilder()
   *           .setParent(PropertyName.of("[PROPERTY]").toString())
   *           .setExpandedDataSet(ExpandedDataSet.newBuilder().build())
   *           .build();
   *   ExpandedDataSet response = analyticsAdminServiceClient.createExpandedDataSet(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ExpandedDataSet createExpandedDataSet(CreateExpandedDataSetRequest request) {
    return createExpandedDataSetCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a ExpandedDataSet.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   CreateExpandedDataSetRequest request =
   *       CreateExpandedDataSetRequest.newBuilder()
   *           .setParent(PropertyName.of("[PROPERTY]").toString())
   *           .setExpandedDataSet(ExpandedDataSet.newBuilder().build())
   *           .build();
   *   ApiFuture<ExpandedDataSet> future =
   *       analyticsAdminServiceClient.createExpandedDataSetCallable().futureCall(request);
   *   // Do something.
   *   ExpandedDataSet response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateExpandedDataSetRequest, ExpandedDataSet>
      createExpandedDataSetCallable() {
    return stub.createExpandedDataSetCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a ExpandedDataSet on a property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   ExpandedDataSet expandedDataSet = ExpandedDataSet.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   ExpandedDataSet response =
   *       analyticsAdminServiceClient.updateExpandedDataSet(expandedDataSet, updateMask);
   * }
   * }</pre>
   *
   * @param expandedDataSet Required. The ExpandedDataSet to update. The resource's `name` field is
   *     used to identify the ExpandedDataSet to be updated.
   * @param updateMask Required. The list of fields to be updated. Field names must be in snake case
   *     (e.g., "field_to_update"). Omitted fields will not be updated. To replace the entire
   *     entity, use one path with the string "&#42;" to match all fields.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ExpandedDataSet updateExpandedDataSet(
      ExpandedDataSet expandedDataSet, FieldMask updateMask) {
    UpdateExpandedDataSetRequest request =
        UpdateExpandedDataSetRequest.newBuilder()
            .setExpandedDataSet(expandedDataSet)
            .setUpdateMask(updateMask)
            .build();
    return updateExpandedDataSet(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a ExpandedDataSet on a property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   UpdateExpandedDataSetRequest request =
   *       UpdateExpandedDataSetRequest.newBuilder()
   *           .setExpandedDataSet(ExpandedDataSet.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ExpandedDataSet response = analyticsAdminServiceClient.updateExpandedDataSet(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ExpandedDataSet updateExpandedDataSet(UpdateExpandedDataSetRequest request) {
    return updateExpandedDataSetCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a ExpandedDataSet on a property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   UpdateExpandedDataSetRequest request =
   *       UpdateExpandedDataSetRequest.newBuilder()
   *           .setExpandedDataSet(ExpandedDataSet.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<ExpandedDataSet> future =
   *       analyticsAdminServiceClient.updateExpandedDataSetCallable().futureCall(request);
   *   // Do something.
   *   ExpandedDataSet response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateExpandedDataSetRequest, ExpandedDataSet>
      updateExpandedDataSetCallable() {
    return stub.updateExpandedDataSetCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a ExpandedDataSet on a property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   ExpandedDataSetName name = ExpandedDataSetName.of("[PROPERTY]", "[EXPANDED_DATA_SET]");
   *   analyticsAdminServiceClient.deleteExpandedDataSet(name);
   * }
   * }</pre>
   *
   * @param name Required. Example format: properties/1234/expandedDataSets/5678
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteExpandedDataSet(ExpandedDataSetName name) {
    DeleteExpandedDataSetRequest request =
        DeleteExpandedDataSetRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    deleteExpandedDataSet(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a ExpandedDataSet on a property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   String name = ExpandedDataSetName.of("[PROPERTY]", "[EXPANDED_DATA_SET]").toString();
   *   analyticsAdminServiceClient.deleteExpandedDataSet(name);
   * }
   * }</pre>
   *
   * @param name Required. Example format: properties/1234/expandedDataSets/5678
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteExpandedDataSet(String name) {
    DeleteExpandedDataSetRequest request =
        DeleteExpandedDataSetRequest.newBuilder().setName(name).build();
    deleteExpandedDataSet(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a ExpandedDataSet on a property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   DeleteExpandedDataSetRequest request =
   *       DeleteExpandedDataSetRequest.newBuilder()
   *           .setName(ExpandedDataSetName.of("[PROPERTY]", "[EXPANDED_DATA_SET]").toString())
   *           .build();
   *   analyticsAdminServiceClient.deleteExpandedDataSet(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteExpandedDataSet(DeleteExpandedDataSetRequest request) {
    deleteExpandedDataSetCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a ExpandedDataSet on a property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   DeleteExpandedDataSetRequest request =
   *       DeleteExpandedDataSetRequest.newBuilder()
   *           .setName(ExpandedDataSetName.of("[PROPERTY]", "[EXPANDED_DATA_SET]").toString())
   *           .build();
   *   ApiFuture<Empty> future =
   *       analyticsAdminServiceClient.deleteExpandedDataSetCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteExpandedDataSetRequest, Empty> deleteExpandedDataSetCallable() {
    return stub.deleteExpandedDataSetCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lookup for a single ChannelGroup.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   ChannelGroupName name = ChannelGroupName.of("[PROPERTY]", "[CHANNEL_GROUP]");
   *   ChannelGroup response = analyticsAdminServiceClient.getChannelGroup(name);
   * }
   * }</pre>
   *
   * @param name Required. The ChannelGroup to get. Example format:
   *     properties/1234/channelGroups/5678
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ChannelGroup getChannelGroup(ChannelGroupName name) {
    GetChannelGroupRequest request =
        GetChannelGroupRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getChannelGroup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lookup for a single ChannelGroup.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   String name = ChannelGroupName.of("[PROPERTY]", "[CHANNEL_GROUP]").toString();
   *   ChannelGroup response = analyticsAdminServiceClient.getChannelGroup(name);
   * }
   * }</pre>
   *
   * @param name Required. The ChannelGroup to get. Example format:
   *     properties/1234/channelGroups/5678
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ChannelGroup getChannelGroup(String name) {
    GetChannelGroupRequest request = GetChannelGroupRequest.newBuilder().setName(name).build();
    return getChannelGroup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lookup for a single ChannelGroup.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   GetChannelGroupRequest request =
   *       GetChannelGroupRequest.newBuilder()
   *           .setName(ChannelGroupName.of("[PROPERTY]", "[CHANNEL_GROUP]").toString())
   *           .build();
   *   ChannelGroup response = analyticsAdminServiceClient.getChannelGroup(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ChannelGroup getChannelGroup(GetChannelGroupRequest request) {
    return getChannelGroupCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lookup for a single ChannelGroup.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   GetChannelGroupRequest request =
   *       GetChannelGroupRequest.newBuilder()
   *           .setName(ChannelGroupName.of("[PROPERTY]", "[CHANNEL_GROUP]").toString())
   *           .build();
   *   ApiFuture<ChannelGroup> future =
   *       analyticsAdminServiceClient.getChannelGroupCallable().futureCall(request);
   *   // Do something.
   *   ChannelGroup response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetChannelGroupRequest, ChannelGroup> getChannelGroupCallable() {
    return stub.getChannelGroupCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists ChannelGroups on a property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   PropertyName parent = PropertyName.of("[PROPERTY]");
   *   for (ChannelGroup element :
   *       analyticsAdminServiceClient.listChannelGroups(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The property for which to list ChannelGroups. Example format:
   *     properties/1234
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListChannelGroupsPagedResponse listChannelGroups(PropertyName parent) {
    ListChannelGroupsRequest request =
        ListChannelGroupsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listChannelGroups(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists ChannelGroups on a property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   String parent = PropertyName.of("[PROPERTY]").toString();
   *   for (ChannelGroup element :
   *       analyticsAdminServiceClient.listChannelGroups(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The property for which to list ChannelGroups. Example format:
   *     properties/1234
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListChannelGroupsPagedResponse listChannelGroups(String parent) {
    ListChannelGroupsRequest request =
        ListChannelGroupsRequest.newBuilder().setParent(parent).build();
    return listChannelGroups(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists ChannelGroups on a property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   ListChannelGroupsRequest request =
   *       ListChannelGroupsRequest.newBuilder()
   *           .setParent(PropertyName.of("[PROPERTY]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (ChannelGroup element :
   *       analyticsAdminServiceClient.listChannelGroups(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListChannelGroupsPagedResponse listChannelGroups(ListChannelGroupsRequest request) {
    return listChannelGroupsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists ChannelGroups on a property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   ListChannelGroupsRequest request =
   *       ListChannelGroupsRequest.newBuilder()
   *           .setParent(PropertyName.of("[PROPERTY]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<ChannelGroup> future =
   *       analyticsAdminServiceClient.listChannelGroupsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (ChannelGroup element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListChannelGroupsRequest, ListChannelGroupsPagedResponse>
      listChannelGroupsPagedCallable() {
    return stub.listChannelGroupsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists ChannelGroups on a property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   ListChannelGroupsRequest request =
   *       ListChannelGroupsRequest.newBuilder()
   *           .setParent(PropertyName.of("[PROPERTY]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListChannelGroupsResponse response =
   *         analyticsAdminServiceClient.listChannelGroupsCallable().call(request);
   *     for (ChannelGroup element : response.getChannelGroupsList()) {
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
  public final UnaryCallable<ListChannelGroupsRequest, ListChannelGroupsResponse>
      listChannelGroupsCallable() {
    return stub.listChannelGroupsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a ChannelGroup.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   PropertyName parent = PropertyName.of("[PROPERTY]");
   *   ChannelGroup channelGroup = ChannelGroup.newBuilder().build();
   *   ChannelGroup response = analyticsAdminServiceClient.createChannelGroup(parent, channelGroup);
   * }
   * }</pre>
   *
   * @param parent Required. The property for which to create a ChannelGroup. Example format:
   *     properties/1234
   * @param channelGroup Required. The ChannelGroup to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ChannelGroup createChannelGroup(PropertyName parent, ChannelGroup channelGroup) {
    CreateChannelGroupRequest request =
        CreateChannelGroupRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setChannelGroup(channelGroup)
            .build();
    return createChannelGroup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a ChannelGroup.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   String parent = PropertyName.of("[PROPERTY]").toString();
   *   ChannelGroup channelGroup = ChannelGroup.newBuilder().build();
   *   ChannelGroup response = analyticsAdminServiceClient.createChannelGroup(parent, channelGroup);
   * }
   * }</pre>
   *
   * @param parent Required. The property for which to create a ChannelGroup. Example format:
   *     properties/1234
   * @param channelGroup Required. The ChannelGroup to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ChannelGroup createChannelGroup(String parent, ChannelGroup channelGroup) {
    CreateChannelGroupRequest request =
        CreateChannelGroupRequest.newBuilder()
            .setParent(parent)
            .setChannelGroup(channelGroup)
            .build();
    return createChannelGroup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a ChannelGroup.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   CreateChannelGroupRequest request =
   *       CreateChannelGroupRequest.newBuilder()
   *           .setParent(PropertyName.of("[PROPERTY]").toString())
   *           .setChannelGroup(ChannelGroup.newBuilder().build())
   *           .build();
   *   ChannelGroup response = analyticsAdminServiceClient.createChannelGroup(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ChannelGroup createChannelGroup(CreateChannelGroupRequest request) {
    return createChannelGroupCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a ChannelGroup.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   CreateChannelGroupRequest request =
   *       CreateChannelGroupRequest.newBuilder()
   *           .setParent(PropertyName.of("[PROPERTY]").toString())
   *           .setChannelGroup(ChannelGroup.newBuilder().build())
   *           .build();
   *   ApiFuture<ChannelGroup> future =
   *       analyticsAdminServiceClient.createChannelGroupCallable().futureCall(request);
   *   // Do something.
   *   ChannelGroup response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateChannelGroupRequest, ChannelGroup> createChannelGroupCallable() {
    return stub.createChannelGroupCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a ChannelGroup.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   ChannelGroup channelGroup = ChannelGroup.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   ChannelGroup response =
   *       analyticsAdminServiceClient.updateChannelGroup(channelGroup, updateMask);
   * }
   * }</pre>
   *
   * @param channelGroup Required. The ChannelGroup to update. The resource's `name` field is used
   *     to identify the ChannelGroup to be updated.
   * @param updateMask Required. The list of fields to be updated. Field names must be in snake case
   *     (e.g., "field_to_update"). Omitted fields will not be updated. To replace the entire
   *     entity, use one path with the string "&#42;" to match all fields.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ChannelGroup updateChannelGroup(ChannelGroup channelGroup, FieldMask updateMask) {
    UpdateChannelGroupRequest request =
        UpdateChannelGroupRequest.newBuilder()
            .setChannelGroup(channelGroup)
            .setUpdateMask(updateMask)
            .build();
    return updateChannelGroup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a ChannelGroup.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   UpdateChannelGroupRequest request =
   *       UpdateChannelGroupRequest.newBuilder()
   *           .setChannelGroup(ChannelGroup.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ChannelGroup response = analyticsAdminServiceClient.updateChannelGroup(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ChannelGroup updateChannelGroup(UpdateChannelGroupRequest request) {
    return updateChannelGroupCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a ChannelGroup.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   UpdateChannelGroupRequest request =
   *       UpdateChannelGroupRequest.newBuilder()
   *           .setChannelGroup(ChannelGroup.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<ChannelGroup> future =
   *       analyticsAdminServiceClient.updateChannelGroupCallable().futureCall(request);
   *   // Do something.
   *   ChannelGroup response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateChannelGroupRequest, ChannelGroup> updateChannelGroupCallable() {
    return stub.updateChannelGroupCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a ChannelGroup on a property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   ChannelGroupName name = ChannelGroupName.of("[PROPERTY]", "[CHANNEL_GROUP]");
   *   analyticsAdminServiceClient.deleteChannelGroup(name);
   * }
   * }</pre>
   *
   * @param name Required. The ChannelGroup to delete. Example format:
   *     properties/1234/channelGroups/5678
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteChannelGroup(ChannelGroupName name) {
    DeleteChannelGroupRequest request =
        DeleteChannelGroupRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    deleteChannelGroup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a ChannelGroup on a property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   String name = ChannelGroupName.of("[PROPERTY]", "[CHANNEL_GROUP]").toString();
   *   analyticsAdminServiceClient.deleteChannelGroup(name);
   * }
   * }</pre>
   *
   * @param name Required. The ChannelGroup to delete. Example format:
   *     properties/1234/channelGroups/5678
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteChannelGroup(String name) {
    DeleteChannelGroupRequest request =
        DeleteChannelGroupRequest.newBuilder().setName(name).build();
    deleteChannelGroup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a ChannelGroup on a property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   DeleteChannelGroupRequest request =
   *       DeleteChannelGroupRequest.newBuilder()
   *           .setName(ChannelGroupName.of("[PROPERTY]", "[CHANNEL_GROUP]").toString())
   *           .build();
   *   analyticsAdminServiceClient.deleteChannelGroup(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteChannelGroup(DeleteChannelGroupRequest request) {
    deleteChannelGroupCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a ChannelGroup on a property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   DeleteChannelGroupRequest request =
   *       DeleteChannelGroupRequest.newBuilder()
   *           .setName(ChannelGroupName.of("[PROPERTY]", "[CHANNEL_GROUP]").toString())
   *           .build();
   *   ApiFuture<Empty> future =
   *       analyticsAdminServiceClient.deleteChannelGroupCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteChannelGroupRequest, Empty> deleteChannelGroupCallable() {
    return stub.deleteChannelGroupCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the opt out status for the automated GA4 setup process for a UA property. Note: this has
   * no effect on GA4 property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   SetAutomatedGa4ConfigurationOptOutRequest request =
   *       SetAutomatedGa4ConfigurationOptOutRequest.newBuilder()
   *           .setProperty("property-993141291")
   *           .setOptOut(true)
   *           .build();
   *   SetAutomatedGa4ConfigurationOptOutResponse response =
   *       analyticsAdminServiceClient.setAutomatedGa4ConfigurationOptOut(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SetAutomatedGa4ConfigurationOptOutResponse setAutomatedGa4ConfigurationOptOut(
      SetAutomatedGa4ConfigurationOptOutRequest request) {
    return setAutomatedGa4ConfigurationOptOutCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the opt out status for the automated GA4 setup process for a UA property. Note: this has
   * no effect on GA4 property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   SetAutomatedGa4ConfigurationOptOutRequest request =
   *       SetAutomatedGa4ConfigurationOptOutRequest.newBuilder()
   *           .setProperty("property-993141291")
   *           .setOptOut(true)
   *           .build();
   *   ApiFuture<SetAutomatedGa4ConfigurationOptOutResponse> future =
   *       analyticsAdminServiceClient
   *           .setAutomatedGa4ConfigurationOptOutCallable()
   *           .futureCall(request);
   *   // Do something.
   *   SetAutomatedGa4ConfigurationOptOutResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<
          SetAutomatedGa4ConfigurationOptOutRequest, SetAutomatedGa4ConfigurationOptOutResponse>
      setAutomatedGa4ConfigurationOptOutCallable() {
    return stub.setAutomatedGa4ConfigurationOptOutCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Fetches the opt out status for the automated GA4 setup process for a UA property. Note: this
   * has no effect on GA4 property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   FetchAutomatedGa4ConfigurationOptOutRequest request =
   *       FetchAutomatedGa4ConfigurationOptOutRequest.newBuilder()
   *           .setProperty("property-993141291")
   *           .build();
   *   FetchAutomatedGa4ConfigurationOptOutResponse response =
   *       analyticsAdminServiceClient.fetchAutomatedGa4ConfigurationOptOut(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final FetchAutomatedGa4ConfigurationOptOutResponse fetchAutomatedGa4ConfigurationOptOut(
      FetchAutomatedGa4ConfigurationOptOutRequest request) {
    return fetchAutomatedGa4ConfigurationOptOutCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Fetches the opt out status for the automated GA4 setup process for a UA property. Note: this
   * has no effect on GA4 property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   FetchAutomatedGa4ConfigurationOptOutRequest request =
   *       FetchAutomatedGa4ConfigurationOptOutRequest.newBuilder()
   *           .setProperty("property-993141291")
   *           .build();
   *   ApiFuture<FetchAutomatedGa4ConfigurationOptOutResponse> future =
   *       analyticsAdminServiceClient
   *           .fetchAutomatedGa4ConfigurationOptOutCallable()
   *           .futureCall(request);
   *   // Do something.
   *   FetchAutomatedGa4ConfigurationOptOutResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<
          FetchAutomatedGa4ConfigurationOptOutRequest, FetchAutomatedGa4ConfigurationOptOutResponse>
      fetchAutomatedGa4ConfigurationOptOutCallable() {
    return stub.fetchAutomatedGa4ConfigurationOptOutCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lookup for a single BigQuery Link.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   BigQueryLinkName name = BigQueryLinkName.of("[PROPERTY]", "[BIGQUERY_LINK]");
   *   BigQueryLink response = analyticsAdminServiceClient.getBigQueryLink(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the BigQuery link to lookup. Format:
   *     properties/{property_id}/bigQueryLinks/{bigquery_link_id} Example:
   *     properties/123/bigQueryLinks/456
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BigQueryLink getBigQueryLink(BigQueryLinkName name) {
    GetBigQueryLinkRequest request =
        GetBigQueryLinkRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getBigQueryLink(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lookup for a single BigQuery Link.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   String name = BigQueryLinkName.of("[PROPERTY]", "[BIGQUERY_LINK]").toString();
   *   BigQueryLink response = analyticsAdminServiceClient.getBigQueryLink(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the BigQuery link to lookup. Format:
   *     properties/{property_id}/bigQueryLinks/{bigquery_link_id} Example:
   *     properties/123/bigQueryLinks/456
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BigQueryLink getBigQueryLink(String name) {
    GetBigQueryLinkRequest request = GetBigQueryLinkRequest.newBuilder().setName(name).build();
    return getBigQueryLink(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lookup for a single BigQuery Link.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   GetBigQueryLinkRequest request =
   *       GetBigQueryLinkRequest.newBuilder()
   *           .setName(BigQueryLinkName.of("[PROPERTY]", "[BIGQUERY_LINK]").toString())
   *           .build();
   *   BigQueryLink response = analyticsAdminServiceClient.getBigQueryLink(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BigQueryLink getBigQueryLink(GetBigQueryLinkRequest request) {
    return getBigQueryLinkCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lookup for a single BigQuery Link.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   GetBigQueryLinkRequest request =
   *       GetBigQueryLinkRequest.newBuilder()
   *           .setName(BigQueryLinkName.of("[PROPERTY]", "[BIGQUERY_LINK]").toString())
   *           .build();
   *   ApiFuture<BigQueryLink> future =
   *       analyticsAdminServiceClient.getBigQueryLinkCallable().futureCall(request);
   *   // Do something.
   *   BigQueryLink response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetBigQueryLinkRequest, BigQueryLink> getBigQueryLinkCallable() {
    return stub.getBigQueryLinkCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists BigQuery Links on a property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   PropertyName parent = PropertyName.of("[PROPERTY]");
   *   for (BigQueryLink element :
   *       analyticsAdminServiceClient.listBigQueryLinks(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The name of the property to list BigQuery links under. Format:
   *     properties/{property_id} Example: properties/1234
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListBigQueryLinksPagedResponse listBigQueryLinks(PropertyName parent) {
    ListBigQueryLinksRequest request =
        ListBigQueryLinksRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listBigQueryLinks(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists BigQuery Links on a property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   String parent = PropertyName.of("[PROPERTY]").toString();
   *   for (BigQueryLink element :
   *       analyticsAdminServiceClient.listBigQueryLinks(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The name of the property to list BigQuery links under. Format:
   *     properties/{property_id} Example: properties/1234
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListBigQueryLinksPagedResponse listBigQueryLinks(String parent) {
    ListBigQueryLinksRequest request =
        ListBigQueryLinksRequest.newBuilder().setParent(parent).build();
    return listBigQueryLinks(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists BigQuery Links on a property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   ListBigQueryLinksRequest request =
   *       ListBigQueryLinksRequest.newBuilder()
   *           .setParent(PropertyName.of("[PROPERTY]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (BigQueryLink element :
   *       analyticsAdminServiceClient.listBigQueryLinks(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListBigQueryLinksPagedResponse listBigQueryLinks(ListBigQueryLinksRequest request) {
    return listBigQueryLinksPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists BigQuery Links on a property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   ListBigQueryLinksRequest request =
   *       ListBigQueryLinksRequest.newBuilder()
   *           .setParent(PropertyName.of("[PROPERTY]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<BigQueryLink> future =
   *       analyticsAdminServiceClient.listBigQueryLinksPagedCallable().futureCall(request);
   *   // Do something.
   *   for (BigQueryLink element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListBigQueryLinksRequest, ListBigQueryLinksPagedResponse>
      listBigQueryLinksPagedCallable() {
    return stub.listBigQueryLinksPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists BigQuery Links on a property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   ListBigQueryLinksRequest request =
   *       ListBigQueryLinksRequest.newBuilder()
   *           .setParent(PropertyName.of("[PROPERTY]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListBigQueryLinksResponse response =
   *         analyticsAdminServiceClient.listBigQueryLinksCallable().call(request);
   *     for (BigQueryLink element : response.getBigqueryLinksList()) {
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
  public final UnaryCallable<ListBigQueryLinksRequest, ListBigQueryLinksResponse>
      listBigQueryLinksCallable() {
    return stub.listBigQueryLinksCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the enhanced measurement settings for this data stream. Note that the stream must
   * enable enhanced measurement for these settings to take effect.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   EnhancedMeasurementSettingsName name =
   *       EnhancedMeasurementSettingsName.of("[PROPERTY]", "[DATA_STREAM]");
   *   EnhancedMeasurementSettings response =
   *       analyticsAdminServiceClient.getEnhancedMeasurementSettings(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the settings to lookup. Format:
   *     properties/{property}/dataStreams/{data_stream}/enhancedMeasurementSettings Example:
   *     "properties/1000/dataStreams/2000/enhancedMeasurementSettings"
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final EnhancedMeasurementSettings getEnhancedMeasurementSettings(
      EnhancedMeasurementSettingsName name) {
    GetEnhancedMeasurementSettingsRequest request =
        GetEnhancedMeasurementSettingsRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getEnhancedMeasurementSettings(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the enhanced measurement settings for this data stream. Note that the stream must
   * enable enhanced measurement for these settings to take effect.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   String name = EnhancedMeasurementSettingsName.of("[PROPERTY]", "[DATA_STREAM]").toString();
   *   EnhancedMeasurementSettings response =
   *       analyticsAdminServiceClient.getEnhancedMeasurementSettings(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the settings to lookup. Format:
   *     properties/{property}/dataStreams/{data_stream}/enhancedMeasurementSettings Example:
   *     "properties/1000/dataStreams/2000/enhancedMeasurementSettings"
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final EnhancedMeasurementSettings getEnhancedMeasurementSettings(String name) {
    GetEnhancedMeasurementSettingsRequest request =
        GetEnhancedMeasurementSettingsRequest.newBuilder().setName(name).build();
    return getEnhancedMeasurementSettings(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the enhanced measurement settings for this data stream. Note that the stream must
   * enable enhanced measurement for these settings to take effect.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   GetEnhancedMeasurementSettingsRequest request =
   *       GetEnhancedMeasurementSettingsRequest.newBuilder()
   *           .setName(EnhancedMeasurementSettingsName.of("[PROPERTY]", "[DATA_STREAM]").toString())
   *           .build();
   *   EnhancedMeasurementSettings response =
   *       analyticsAdminServiceClient.getEnhancedMeasurementSettings(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final EnhancedMeasurementSettings getEnhancedMeasurementSettings(
      GetEnhancedMeasurementSettingsRequest request) {
    return getEnhancedMeasurementSettingsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the enhanced measurement settings for this data stream. Note that the stream must
   * enable enhanced measurement for these settings to take effect.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   GetEnhancedMeasurementSettingsRequest request =
   *       GetEnhancedMeasurementSettingsRequest.newBuilder()
   *           .setName(EnhancedMeasurementSettingsName.of("[PROPERTY]", "[DATA_STREAM]").toString())
   *           .build();
   *   ApiFuture<EnhancedMeasurementSettings> future =
   *       analyticsAdminServiceClient.getEnhancedMeasurementSettingsCallable().futureCall(request);
   *   // Do something.
   *   EnhancedMeasurementSettings response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetEnhancedMeasurementSettingsRequest, EnhancedMeasurementSettings>
      getEnhancedMeasurementSettingsCallable() {
    return stub.getEnhancedMeasurementSettingsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the enhanced measurement settings for this data stream. Note that the stream must
   * enable enhanced measurement for these settings to take effect.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   EnhancedMeasurementSettings enhancedMeasurementSettings =
   *       EnhancedMeasurementSettings.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   EnhancedMeasurementSettings response =
   *       analyticsAdminServiceClient.updateEnhancedMeasurementSettings(
   *           enhancedMeasurementSettings, updateMask);
   * }
   * }</pre>
   *
   * @param enhancedMeasurementSettings Required. The settings to update. The `name` field is used
   *     to identify the settings to be updated.
   * @param updateMask Required. The list of fields to be updated. Field names must be in snake case
   *     (e.g., "field_to_update"). Omitted fields will not be updated. To replace the entire
   *     entity, use one path with the string "&#42;" to match all fields.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final EnhancedMeasurementSettings updateEnhancedMeasurementSettings(
      EnhancedMeasurementSettings enhancedMeasurementSettings, FieldMask updateMask) {
    UpdateEnhancedMeasurementSettingsRequest request =
        UpdateEnhancedMeasurementSettingsRequest.newBuilder()
            .setEnhancedMeasurementSettings(enhancedMeasurementSettings)
            .setUpdateMask(updateMask)
            .build();
    return updateEnhancedMeasurementSettings(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the enhanced measurement settings for this data stream. Note that the stream must
   * enable enhanced measurement for these settings to take effect.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   UpdateEnhancedMeasurementSettingsRequest request =
   *       UpdateEnhancedMeasurementSettingsRequest.newBuilder()
   *           .setEnhancedMeasurementSettings(EnhancedMeasurementSettings.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   EnhancedMeasurementSettings response =
   *       analyticsAdminServiceClient.updateEnhancedMeasurementSettings(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final EnhancedMeasurementSettings updateEnhancedMeasurementSettings(
      UpdateEnhancedMeasurementSettingsRequest request) {
    return updateEnhancedMeasurementSettingsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the enhanced measurement settings for this data stream. Note that the stream must
   * enable enhanced measurement for these settings to take effect.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   UpdateEnhancedMeasurementSettingsRequest request =
   *       UpdateEnhancedMeasurementSettingsRequest.newBuilder()
   *           .setEnhancedMeasurementSettings(EnhancedMeasurementSettings.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<EnhancedMeasurementSettings> future =
   *       analyticsAdminServiceClient
   *           .updateEnhancedMeasurementSettingsCallable()
   *           .futureCall(request);
   *   // Do something.
   *   EnhancedMeasurementSettings response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateEnhancedMeasurementSettingsRequest, EnhancedMeasurementSettings>
      updateEnhancedMeasurementSettingsCallable() {
    return stub.updateEnhancedMeasurementSettingsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a connected site tag for a Universal Analytics property. You can create a maximum of 20
   * connected site tags per property. Note: This API cannot be used on GA4 properties.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   CreateConnectedSiteTagRequest request =
   *       CreateConnectedSiteTagRequest.newBuilder()
   *           .setProperty("property-993141291")
   *           .setConnectedSiteTag(ConnectedSiteTag.newBuilder().build())
   *           .build();
   *   CreateConnectedSiteTagResponse response =
   *       analyticsAdminServiceClient.createConnectedSiteTag(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CreateConnectedSiteTagResponse createConnectedSiteTag(
      CreateConnectedSiteTagRequest request) {
    return createConnectedSiteTagCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a connected site tag for a Universal Analytics property. You can create a maximum of 20
   * connected site tags per property. Note: This API cannot be used on GA4 properties.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   CreateConnectedSiteTagRequest request =
   *       CreateConnectedSiteTagRequest.newBuilder()
   *           .setProperty("property-993141291")
   *           .setConnectedSiteTag(ConnectedSiteTag.newBuilder().build())
   *           .build();
   *   ApiFuture<CreateConnectedSiteTagResponse> future =
   *       analyticsAdminServiceClient.createConnectedSiteTagCallable().futureCall(request);
   *   // Do something.
   *   CreateConnectedSiteTagResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateConnectedSiteTagRequest, CreateConnectedSiteTagResponse>
      createConnectedSiteTagCallable() {
    return stub.createConnectedSiteTagCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a connected site tag for a Universal Analytics property. Note: this has no effect on
   * GA4 properties.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   DeleteConnectedSiteTagRequest request =
   *       DeleteConnectedSiteTagRequest.newBuilder()
   *           .setProperty("property-993141291")
   *           .setTagId("tagId110119509")
   *           .build();
   *   analyticsAdminServiceClient.deleteConnectedSiteTag(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteConnectedSiteTag(DeleteConnectedSiteTagRequest request) {
    deleteConnectedSiteTagCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a connected site tag for a Universal Analytics property. Note: this has no effect on
   * GA4 properties.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   DeleteConnectedSiteTagRequest request =
   *       DeleteConnectedSiteTagRequest.newBuilder()
   *           .setProperty("property-993141291")
   *           .setTagId("tagId110119509")
   *           .build();
   *   ApiFuture<Empty> future =
   *       analyticsAdminServiceClient.deleteConnectedSiteTagCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteConnectedSiteTagRequest, Empty>
      deleteConnectedSiteTagCallable() {
    return stub.deleteConnectedSiteTagCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the connected site tags for a Universal Analytics property. A maximum of 20 connected
   * site tags will be returned. Note: this has no effect on GA4 property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   ListConnectedSiteTagsRequest request =
   *       ListConnectedSiteTagsRequest.newBuilder().setProperty("property-993141291").build();
   *   ListConnectedSiteTagsResponse response =
   *       analyticsAdminServiceClient.listConnectedSiteTags(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListConnectedSiteTagsResponse listConnectedSiteTags(
      ListConnectedSiteTagsRequest request) {
    return listConnectedSiteTagsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the connected site tags for a Universal Analytics property. A maximum of 20 connected
   * site tags will be returned. Note: this has no effect on GA4 property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   ListConnectedSiteTagsRequest request =
   *       ListConnectedSiteTagsRequest.newBuilder().setProperty("property-993141291").build();
   *   ApiFuture<ListConnectedSiteTagsResponse> future =
   *       analyticsAdminServiceClient.listConnectedSiteTagsCallable().futureCall(request);
   *   // Do something.
   *   ListConnectedSiteTagsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ListConnectedSiteTagsRequest, ListConnectedSiteTagsResponse>
      listConnectedSiteTagsCallable() {
    return stub.listConnectedSiteTagsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Given a specified UA property, looks up the GA4 property connected to it. Note: this cannot be
   * used with GA4 properties.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   FetchConnectedGa4PropertyRequest request =
   *       FetchConnectedGa4PropertyRequest.newBuilder()
   *           .setProperty(PropertyName.of("[PROPERTY]").toString())
   *           .build();
   *   FetchConnectedGa4PropertyResponse response =
   *       analyticsAdminServiceClient.fetchConnectedGa4Property(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final FetchConnectedGa4PropertyResponse fetchConnectedGa4Property(
      FetchConnectedGa4PropertyRequest request) {
    return fetchConnectedGa4PropertyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Given a specified UA property, looks up the GA4 property connected to it. Note: this cannot be
   * used with GA4 properties.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   FetchConnectedGa4PropertyRequest request =
   *       FetchConnectedGa4PropertyRequest.newBuilder()
   *           .setProperty(PropertyName.of("[PROPERTY]").toString())
   *           .build();
   *   ApiFuture<FetchConnectedGa4PropertyResponse> future =
   *       analyticsAdminServiceClient.fetchConnectedGa4PropertyCallable().futureCall(request);
   *   // Do something.
   *   FetchConnectedGa4PropertyResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<FetchConnectedGa4PropertyRequest, FetchConnectedGa4PropertyResponse>
      fetchConnectedGa4PropertyCallable() {
    return stub.fetchConnectedGa4PropertyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Looks up a single AdSenseLink.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   AdSenseLinkName name = AdSenseLinkName.of("[PROPERTY]", "[ADSENSE_LINK]");
   *   AdSenseLink response = analyticsAdminServiceClient.getAdSenseLink(name);
   * }
   * }</pre>
   *
   * @param name Required. Unique identifier for the AdSense Link requested. Format:
   *     properties/{propertyId}/adSenseLinks/{linkId} Example: properties/1234/adSenseLinks/5678
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AdSenseLink getAdSenseLink(AdSenseLinkName name) {
    GetAdSenseLinkRequest request =
        GetAdSenseLinkRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getAdSenseLink(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Looks up a single AdSenseLink.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   String name = AdSenseLinkName.of("[PROPERTY]", "[ADSENSE_LINK]").toString();
   *   AdSenseLink response = analyticsAdminServiceClient.getAdSenseLink(name);
   * }
   * }</pre>
   *
   * @param name Required. Unique identifier for the AdSense Link requested. Format:
   *     properties/{propertyId}/adSenseLinks/{linkId} Example: properties/1234/adSenseLinks/5678
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AdSenseLink getAdSenseLink(String name) {
    GetAdSenseLinkRequest request = GetAdSenseLinkRequest.newBuilder().setName(name).build();
    return getAdSenseLink(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Looks up a single AdSenseLink.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   GetAdSenseLinkRequest request =
   *       GetAdSenseLinkRequest.newBuilder()
   *           .setName(AdSenseLinkName.of("[PROPERTY]", "[ADSENSE_LINK]").toString())
   *           .build();
   *   AdSenseLink response = analyticsAdminServiceClient.getAdSenseLink(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AdSenseLink getAdSenseLink(GetAdSenseLinkRequest request) {
    return getAdSenseLinkCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Looks up a single AdSenseLink.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   GetAdSenseLinkRequest request =
   *       GetAdSenseLinkRequest.newBuilder()
   *           .setName(AdSenseLinkName.of("[PROPERTY]", "[ADSENSE_LINK]").toString())
   *           .build();
   *   ApiFuture<AdSenseLink> future =
   *       analyticsAdminServiceClient.getAdSenseLinkCallable().futureCall(request);
   *   // Do something.
   *   AdSenseLink response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetAdSenseLinkRequest, AdSenseLink> getAdSenseLinkCallable() {
    return stub.getAdSenseLinkCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an AdSenseLink.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   PropertyName parent = PropertyName.of("[PROPERTY]");
   *   AdSenseLink adsenseLink = AdSenseLink.newBuilder().build();
   *   AdSenseLink response = analyticsAdminServiceClient.createAdSenseLink(parent, adsenseLink);
   * }
   * }</pre>
   *
   * @param parent Required. The property for which to create an AdSense Link. Format:
   *     properties/{propertyId} Example: properties/1234
   * @param adsenseLink Required. The AdSense Link to create
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AdSenseLink createAdSenseLink(PropertyName parent, AdSenseLink adsenseLink) {
    CreateAdSenseLinkRequest request =
        CreateAdSenseLinkRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setAdsenseLink(adsenseLink)
            .build();
    return createAdSenseLink(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an AdSenseLink.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   String parent = PropertyName.of("[PROPERTY]").toString();
   *   AdSenseLink adsenseLink = AdSenseLink.newBuilder().build();
   *   AdSenseLink response = analyticsAdminServiceClient.createAdSenseLink(parent, adsenseLink);
   * }
   * }</pre>
   *
   * @param parent Required. The property for which to create an AdSense Link. Format:
   *     properties/{propertyId} Example: properties/1234
   * @param adsenseLink Required. The AdSense Link to create
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AdSenseLink createAdSenseLink(String parent, AdSenseLink adsenseLink) {
    CreateAdSenseLinkRequest request =
        CreateAdSenseLinkRequest.newBuilder().setParent(parent).setAdsenseLink(adsenseLink).build();
    return createAdSenseLink(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an AdSenseLink.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   CreateAdSenseLinkRequest request =
   *       CreateAdSenseLinkRequest.newBuilder()
   *           .setParent(PropertyName.of("[PROPERTY]").toString())
   *           .setAdsenseLink(AdSenseLink.newBuilder().build())
   *           .build();
   *   AdSenseLink response = analyticsAdminServiceClient.createAdSenseLink(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AdSenseLink createAdSenseLink(CreateAdSenseLinkRequest request) {
    return createAdSenseLinkCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an AdSenseLink.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   CreateAdSenseLinkRequest request =
   *       CreateAdSenseLinkRequest.newBuilder()
   *           .setParent(PropertyName.of("[PROPERTY]").toString())
   *           .setAdsenseLink(AdSenseLink.newBuilder().build())
   *           .build();
   *   ApiFuture<AdSenseLink> future =
   *       analyticsAdminServiceClient.createAdSenseLinkCallable().futureCall(request);
   *   // Do something.
   *   AdSenseLink response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateAdSenseLinkRequest, AdSenseLink> createAdSenseLinkCallable() {
    return stub.createAdSenseLinkCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an AdSenseLink.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   AdSenseLinkName name = AdSenseLinkName.of("[PROPERTY]", "[ADSENSE_LINK]");
   *   analyticsAdminServiceClient.deleteAdSenseLink(name);
   * }
   * }</pre>
   *
   * @param name Required. Unique identifier for the AdSense Link to be deleted. Format:
   *     properties/{propertyId}/adSenseLinks/{linkId} Example: properties/1234/adSenseLinks/5678
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteAdSenseLink(AdSenseLinkName name) {
    DeleteAdSenseLinkRequest request =
        DeleteAdSenseLinkRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    deleteAdSenseLink(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an AdSenseLink.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   String name = AdSenseLinkName.of("[PROPERTY]", "[ADSENSE_LINK]").toString();
   *   analyticsAdminServiceClient.deleteAdSenseLink(name);
   * }
   * }</pre>
   *
   * @param name Required. Unique identifier for the AdSense Link to be deleted. Format:
   *     properties/{propertyId}/adSenseLinks/{linkId} Example: properties/1234/adSenseLinks/5678
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteAdSenseLink(String name) {
    DeleteAdSenseLinkRequest request = DeleteAdSenseLinkRequest.newBuilder().setName(name).build();
    deleteAdSenseLink(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an AdSenseLink.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   DeleteAdSenseLinkRequest request =
   *       DeleteAdSenseLinkRequest.newBuilder()
   *           .setName(AdSenseLinkName.of("[PROPERTY]", "[ADSENSE_LINK]").toString())
   *           .build();
   *   analyticsAdminServiceClient.deleteAdSenseLink(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteAdSenseLink(DeleteAdSenseLinkRequest request) {
    deleteAdSenseLinkCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an AdSenseLink.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   DeleteAdSenseLinkRequest request =
   *       DeleteAdSenseLinkRequest.newBuilder()
   *           .setName(AdSenseLinkName.of("[PROPERTY]", "[ADSENSE_LINK]").toString())
   *           .build();
   *   ApiFuture<Empty> future =
   *       analyticsAdminServiceClient.deleteAdSenseLinkCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteAdSenseLinkRequest, Empty> deleteAdSenseLinkCallable() {
    return stub.deleteAdSenseLinkCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists AdSenseLinks on a property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   PropertyName parent = PropertyName.of("[PROPERTY]");
   *   for (AdSenseLink element :
   *       analyticsAdminServiceClient.listAdSenseLinks(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Resource name of the parent property. Format: properties/{propertyId}
   *     Example: properties/1234
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAdSenseLinksPagedResponse listAdSenseLinks(PropertyName parent) {
    ListAdSenseLinksRequest request =
        ListAdSenseLinksRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listAdSenseLinks(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists AdSenseLinks on a property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   String parent = PropertyName.of("[PROPERTY]").toString();
   *   for (AdSenseLink element :
   *       analyticsAdminServiceClient.listAdSenseLinks(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Resource name of the parent property. Format: properties/{propertyId}
   *     Example: properties/1234
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAdSenseLinksPagedResponse listAdSenseLinks(String parent) {
    ListAdSenseLinksRequest request =
        ListAdSenseLinksRequest.newBuilder().setParent(parent).build();
    return listAdSenseLinks(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists AdSenseLinks on a property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   ListAdSenseLinksRequest request =
   *       ListAdSenseLinksRequest.newBuilder()
   *           .setParent(PropertyName.of("[PROPERTY]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (AdSenseLink element :
   *       analyticsAdminServiceClient.listAdSenseLinks(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAdSenseLinksPagedResponse listAdSenseLinks(ListAdSenseLinksRequest request) {
    return listAdSenseLinksPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists AdSenseLinks on a property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   ListAdSenseLinksRequest request =
   *       ListAdSenseLinksRequest.newBuilder()
   *           .setParent(PropertyName.of("[PROPERTY]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<AdSenseLink> future =
   *       analyticsAdminServiceClient.listAdSenseLinksPagedCallable().futureCall(request);
   *   // Do something.
   *   for (AdSenseLink element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListAdSenseLinksRequest, ListAdSenseLinksPagedResponse>
      listAdSenseLinksPagedCallable() {
    return stub.listAdSenseLinksPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists AdSenseLinks on a property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   ListAdSenseLinksRequest request =
   *       ListAdSenseLinksRequest.newBuilder()
   *           .setParent(PropertyName.of("[PROPERTY]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListAdSenseLinksResponse response =
   *         analyticsAdminServiceClient.listAdSenseLinksCallable().call(request);
   *     for (AdSenseLink element : response.getAdsenseLinksList()) {
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
  public final UnaryCallable<ListAdSenseLinksRequest, ListAdSenseLinksResponse>
      listAdSenseLinksCallable() {
    return stub.listAdSenseLinksCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lookup for a single EventCreateRule.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   EventCreateRuleName name =
   *       EventCreateRuleName.of("[PROPERTY]", "[DATA_STREAM]", "[EVENT_CREATE_RULE]");
   *   EventCreateRule response = analyticsAdminServiceClient.getEventCreateRule(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the EventCreateRule to get. Example format:
   *     properties/123/dataStreams/456/eventCreateRules/789
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final EventCreateRule getEventCreateRule(EventCreateRuleName name) {
    GetEventCreateRuleRequest request =
        GetEventCreateRuleRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getEventCreateRule(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lookup for a single EventCreateRule.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   String name =
   *       EventCreateRuleName.of("[PROPERTY]", "[DATA_STREAM]", "[EVENT_CREATE_RULE]").toString();
   *   EventCreateRule response = analyticsAdminServiceClient.getEventCreateRule(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the EventCreateRule to get. Example format:
   *     properties/123/dataStreams/456/eventCreateRules/789
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final EventCreateRule getEventCreateRule(String name) {
    GetEventCreateRuleRequest request =
        GetEventCreateRuleRequest.newBuilder().setName(name).build();
    return getEventCreateRule(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lookup for a single EventCreateRule.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   GetEventCreateRuleRequest request =
   *       GetEventCreateRuleRequest.newBuilder()
   *           .setName(
   *               EventCreateRuleName.of("[PROPERTY]", "[DATA_STREAM]", "[EVENT_CREATE_RULE]")
   *                   .toString())
   *           .build();
   *   EventCreateRule response = analyticsAdminServiceClient.getEventCreateRule(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final EventCreateRule getEventCreateRule(GetEventCreateRuleRequest request) {
    return getEventCreateRuleCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lookup for a single EventCreateRule.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   GetEventCreateRuleRequest request =
   *       GetEventCreateRuleRequest.newBuilder()
   *           .setName(
   *               EventCreateRuleName.of("[PROPERTY]", "[DATA_STREAM]", "[EVENT_CREATE_RULE]")
   *                   .toString())
   *           .build();
   *   ApiFuture<EventCreateRule> future =
   *       analyticsAdminServiceClient.getEventCreateRuleCallable().futureCall(request);
   *   // Do something.
   *   EventCreateRule response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetEventCreateRuleRequest, EventCreateRule>
      getEventCreateRuleCallable() {
    return stub.getEventCreateRuleCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists EventCreateRules on a web data stream.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   DataStreamName parent = DataStreamName.of("[PROPERTY]", "[DATA_STREAM]");
   *   for (EventCreateRule element :
   *       analyticsAdminServiceClient.listEventCreateRules(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Example format: properties/123/dataStreams/456
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListEventCreateRulesPagedResponse listEventCreateRules(DataStreamName parent) {
    ListEventCreateRulesRequest request =
        ListEventCreateRulesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listEventCreateRules(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists EventCreateRules on a web data stream.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   String parent = DataStreamName.of("[PROPERTY]", "[DATA_STREAM]").toString();
   *   for (EventCreateRule element :
   *       analyticsAdminServiceClient.listEventCreateRules(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Example format: properties/123/dataStreams/456
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListEventCreateRulesPagedResponse listEventCreateRules(String parent) {
    ListEventCreateRulesRequest request =
        ListEventCreateRulesRequest.newBuilder().setParent(parent).build();
    return listEventCreateRules(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists EventCreateRules on a web data stream.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   ListEventCreateRulesRequest request =
   *       ListEventCreateRulesRequest.newBuilder()
   *           .setParent(DataStreamName.of("[PROPERTY]", "[DATA_STREAM]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (EventCreateRule element :
   *       analyticsAdminServiceClient.listEventCreateRules(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListEventCreateRulesPagedResponse listEventCreateRules(
      ListEventCreateRulesRequest request) {
    return listEventCreateRulesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists EventCreateRules on a web data stream.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   ListEventCreateRulesRequest request =
   *       ListEventCreateRulesRequest.newBuilder()
   *           .setParent(DataStreamName.of("[PROPERTY]", "[DATA_STREAM]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<EventCreateRule> future =
   *       analyticsAdminServiceClient.listEventCreateRulesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (EventCreateRule element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListEventCreateRulesRequest, ListEventCreateRulesPagedResponse>
      listEventCreateRulesPagedCallable() {
    return stub.listEventCreateRulesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists EventCreateRules on a web data stream.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   ListEventCreateRulesRequest request =
   *       ListEventCreateRulesRequest.newBuilder()
   *           .setParent(DataStreamName.of("[PROPERTY]", "[DATA_STREAM]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListEventCreateRulesResponse response =
   *         analyticsAdminServiceClient.listEventCreateRulesCallable().call(request);
   *     for (EventCreateRule element : response.getEventCreateRulesList()) {
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
  public final UnaryCallable<ListEventCreateRulesRequest, ListEventCreateRulesResponse>
      listEventCreateRulesCallable() {
    return stub.listEventCreateRulesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an EventCreateRule.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   DataStreamName parent = DataStreamName.of("[PROPERTY]", "[DATA_STREAM]");
   *   EventCreateRule eventCreateRule = EventCreateRule.newBuilder().build();
   *   EventCreateRule response =
   *       analyticsAdminServiceClient.createEventCreateRule(parent, eventCreateRule);
   * }
   * }</pre>
   *
   * @param parent Required. Example format: properties/123/dataStreams/456
   * @param eventCreateRule Required. The EventCreateRule to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final EventCreateRule createEventCreateRule(
      DataStreamName parent, EventCreateRule eventCreateRule) {
    CreateEventCreateRuleRequest request =
        CreateEventCreateRuleRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setEventCreateRule(eventCreateRule)
            .build();
    return createEventCreateRule(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an EventCreateRule.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   String parent = DataStreamName.of("[PROPERTY]", "[DATA_STREAM]").toString();
   *   EventCreateRule eventCreateRule = EventCreateRule.newBuilder().build();
   *   EventCreateRule response =
   *       analyticsAdminServiceClient.createEventCreateRule(parent, eventCreateRule);
   * }
   * }</pre>
   *
   * @param parent Required. Example format: properties/123/dataStreams/456
   * @param eventCreateRule Required. The EventCreateRule to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final EventCreateRule createEventCreateRule(
      String parent, EventCreateRule eventCreateRule) {
    CreateEventCreateRuleRequest request =
        CreateEventCreateRuleRequest.newBuilder()
            .setParent(parent)
            .setEventCreateRule(eventCreateRule)
            .build();
    return createEventCreateRule(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an EventCreateRule.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   CreateEventCreateRuleRequest request =
   *       CreateEventCreateRuleRequest.newBuilder()
   *           .setParent(DataStreamName.of("[PROPERTY]", "[DATA_STREAM]").toString())
   *           .setEventCreateRule(EventCreateRule.newBuilder().build())
   *           .build();
   *   EventCreateRule response = analyticsAdminServiceClient.createEventCreateRule(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final EventCreateRule createEventCreateRule(CreateEventCreateRuleRequest request) {
    return createEventCreateRuleCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an EventCreateRule.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   CreateEventCreateRuleRequest request =
   *       CreateEventCreateRuleRequest.newBuilder()
   *           .setParent(DataStreamName.of("[PROPERTY]", "[DATA_STREAM]").toString())
   *           .setEventCreateRule(EventCreateRule.newBuilder().build())
   *           .build();
   *   ApiFuture<EventCreateRule> future =
   *       analyticsAdminServiceClient.createEventCreateRuleCallable().futureCall(request);
   *   // Do something.
   *   EventCreateRule response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateEventCreateRuleRequest, EventCreateRule>
      createEventCreateRuleCallable() {
    return stub.createEventCreateRuleCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an EventCreateRule.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   EventCreateRule eventCreateRule = EventCreateRule.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   EventCreateRule response =
   *       analyticsAdminServiceClient.updateEventCreateRule(eventCreateRule, updateMask);
   * }
   * }</pre>
   *
   * @param eventCreateRule Required. The EventCreateRule to update. The resource's `name` field is
   *     used to identify the EventCreateRule to be updated.
   * @param updateMask Required. The list of fields to be updated. Field names must be in snake case
   *     (e.g., "field_to_update"). Omitted fields will not be updated. To replace the entire
   *     entity, use one path with the string "&#42;" to match all fields.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final EventCreateRule updateEventCreateRule(
      EventCreateRule eventCreateRule, FieldMask updateMask) {
    UpdateEventCreateRuleRequest request =
        UpdateEventCreateRuleRequest.newBuilder()
            .setEventCreateRule(eventCreateRule)
            .setUpdateMask(updateMask)
            .build();
    return updateEventCreateRule(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an EventCreateRule.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   UpdateEventCreateRuleRequest request =
   *       UpdateEventCreateRuleRequest.newBuilder()
   *           .setEventCreateRule(EventCreateRule.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   EventCreateRule response = analyticsAdminServiceClient.updateEventCreateRule(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final EventCreateRule updateEventCreateRule(UpdateEventCreateRuleRequest request) {
    return updateEventCreateRuleCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an EventCreateRule.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   UpdateEventCreateRuleRequest request =
   *       UpdateEventCreateRuleRequest.newBuilder()
   *           .setEventCreateRule(EventCreateRule.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<EventCreateRule> future =
   *       analyticsAdminServiceClient.updateEventCreateRuleCallable().futureCall(request);
   *   // Do something.
   *   EventCreateRule response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateEventCreateRuleRequest, EventCreateRule>
      updateEventCreateRuleCallable() {
    return stub.updateEventCreateRuleCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an EventCreateRule.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   EventCreateRuleName name =
   *       EventCreateRuleName.of("[PROPERTY]", "[DATA_STREAM]", "[EVENT_CREATE_RULE]");
   *   analyticsAdminServiceClient.deleteEventCreateRule(name);
   * }
   * }</pre>
   *
   * @param name Required. Example format: properties/123/dataStreams/456/eventCreateRules/789
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteEventCreateRule(EventCreateRuleName name) {
    DeleteEventCreateRuleRequest request =
        DeleteEventCreateRuleRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    deleteEventCreateRule(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an EventCreateRule.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   String name =
   *       EventCreateRuleName.of("[PROPERTY]", "[DATA_STREAM]", "[EVENT_CREATE_RULE]").toString();
   *   analyticsAdminServiceClient.deleteEventCreateRule(name);
   * }
   * }</pre>
   *
   * @param name Required. Example format: properties/123/dataStreams/456/eventCreateRules/789
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteEventCreateRule(String name) {
    DeleteEventCreateRuleRequest request =
        DeleteEventCreateRuleRequest.newBuilder().setName(name).build();
    deleteEventCreateRule(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an EventCreateRule.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   DeleteEventCreateRuleRequest request =
   *       DeleteEventCreateRuleRequest.newBuilder()
   *           .setName(
   *               EventCreateRuleName.of("[PROPERTY]", "[DATA_STREAM]", "[EVENT_CREATE_RULE]")
   *                   .toString())
   *           .build();
   *   analyticsAdminServiceClient.deleteEventCreateRule(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteEventCreateRule(DeleteEventCreateRuleRequest request) {
    deleteEventCreateRuleCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an EventCreateRule.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   DeleteEventCreateRuleRequest request =
   *       DeleteEventCreateRuleRequest.newBuilder()
   *           .setName(
   *               EventCreateRuleName.of("[PROPERTY]", "[DATA_STREAM]", "[EVENT_CREATE_RULE]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Empty> future =
   *       analyticsAdminServiceClient.deleteEventCreateRuleCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteEventCreateRuleRequest, Empty> deleteEventCreateRuleCallable() {
    return stub.deleteEventCreateRuleCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a DataRedactionSettings on a property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   DataRedactionSettings dataRedactionSettings = DataRedactionSettings.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   DataRedactionSettings response =
   *       analyticsAdminServiceClient.updateDataRedactionSettings(
   *           dataRedactionSettings, updateMask);
   * }
   * }</pre>
   *
   * @param dataRedactionSettings Required. The settings to update. The `name` field is used to
   *     identify the settings to be updated.
   * @param updateMask Required. The list of fields to be updated. Field names must be in snake case
   *     (e.g., "field_to_update"). Omitted fields will not be updated. To replace the entire
   *     entity, use one path with the string "&#42;" to match all fields.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DataRedactionSettings updateDataRedactionSettings(
      DataRedactionSettings dataRedactionSettings, FieldMask updateMask) {
    UpdateDataRedactionSettingsRequest request =
        UpdateDataRedactionSettingsRequest.newBuilder()
            .setDataRedactionSettings(dataRedactionSettings)
            .setUpdateMask(updateMask)
            .build();
    return updateDataRedactionSettings(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a DataRedactionSettings on a property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   UpdateDataRedactionSettingsRequest request =
   *       UpdateDataRedactionSettingsRequest.newBuilder()
   *           .setDataRedactionSettings(DataRedactionSettings.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   DataRedactionSettings response =
   *       analyticsAdminServiceClient.updateDataRedactionSettings(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DataRedactionSettings updateDataRedactionSettings(
      UpdateDataRedactionSettingsRequest request) {
    return updateDataRedactionSettingsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a DataRedactionSettings on a property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   UpdateDataRedactionSettingsRequest request =
   *       UpdateDataRedactionSettingsRequest.newBuilder()
   *           .setDataRedactionSettings(DataRedactionSettings.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<DataRedactionSettings> future =
   *       analyticsAdminServiceClient.updateDataRedactionSettingsCallable().futureCall(request);
   *   // Do something.
   *   DataRedactionSettings response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateDataRedactionSettingsRequest, DataRedactionSettings>
      updateDataRedactionSettingsCallable() {
    return stub.updateDataRedactionSettingsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lookup for a single DataRedactionSettings.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   DataRedactionSettingsName name = DataRedactionSettingsName.of("[PROPERTY]", "[DATA_STREAM]");
   *   DataRedactionSettings response = analyticsAdminServiceClient.getDataRedactionSettings(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the settings to lookup. Format:
   *     properties/{property}/dataStreams/{data_stream}/dataRedactionSettings Example:
   *     "properties/1000/dataStreams/2000/dataRedactionSettings"
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DataRedactionSettings getDataRedactionSettings(DataRedactionSettingsName name) {
    GetDataRedactionSettingsRequest request =
        GetDataRedactionSettingsRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getDataRedactionSettings(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lookup for a single DataRedactionSettings.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   String name = DataRedactionSettingsName.of("[PROPERTY]", "[DATA_STREAM]").toString();
   *   DataRedactionSettings response = analyticsAdminServiceClient.getDataRedactionSettings(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the settings to lookup. Format:
   *     properties/{property}/dataStreams/{data_stream}/dataRedactionSettings Example:
   *     "properties/1000/dataStreams/2000/dataRedactionSettings"
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DataRedactionSettings getDataRedactionSettings(String name) {
    GetDataRedactionSettingsRequest request =
        GetDataRedactionSettingsRequest.newBuilder().setName(name).build();
    return getDataRedactionSettings(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lookup for a single DataRedactionSettings.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   GetDataRedactionSettingsRequest request =
   *       GetDataRedactionSettingsRequest.newBuilder()
   *           .setName(DataRedactionSettingsName.of("[PROPERTY]", "[DATA_STREAM]").toString())
   *           .build();
   *   DataRedactionSettings response =
   *       analyticsAdminServiceClient.getDataRedactionSettings(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DataRedactionSettings getDataRedactionSettings(
      GetDataRedactionSettingsRequest request) {
    return getDataRedactionSettingsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lookup for a single DataRedactionSettings.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   GetDataRedactionSettingsRequest request =
   *       GetDataRedactionSettingsRequest.newBuilder()
   *           .setName(DataRedactionSettingsName.of("[PROPERTY]", "[DATA_STREAM]").toString())
   *           .build();
   *   ApiFuture<DataRedactionSettings> future =
   *       analyticsAdminServiceClient.getDataRedactionSettingsCallable().futureCall(request);
   *   // Do something.
   *   DataRedactionSettings response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetDataRedactionSettingsRequest, DataRedactionSettings>
      getDataRedactionSettingsCallable() {
    return stub.getDataRedactionSettingsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a roll-up property and all roll-up property source links.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   CreateRollupPropertyRequest request =
   *       CreateRollupPropertyRequest.newBuilder()
   *           .setRollupProperty(Property.newBuilder().build())
   *           .addAllSourceProperties(new ArrayList<String>())
   *           .build();
   *   CreateRollupPropertyResponse response =
   *       analyticsAdminServiceClient.createRollupProperty(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CreateRollupPropertyResponse createRollupProperty(
      CreateRollupPropertyRequest request) {
    return createRollupPropertyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a roll-up property and all roll-up property source links.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   CreateRollupPropertyRequest request =
   *       CreateRollupPropertyRequest.newBuilder()
   *           .setRollupProperty(Property.newBuilder().build())
   *           .addAllSourceProperties(new ArrayList<String>())
   *           .build();
   *   ApiFuture<CreateRollupPropertyResponse> future =
   *       analyticsAdminServiceClient.createRollupPropertyCallable().futureCall(request);
   *   // Do something.
   *   CreateRollupPropertyResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateRollupPropertyRequest, CreateRollupPropertyResponse>
      createRollupPropertyCallable() {
    return stub.createRollupPropertyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lookup for a single roll-up property source Link. Only roll-up properties can have source
   * links, so this method will throw an error if used on other types of properties.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   RollupPropertySourceLinkName name =
   *       RollupPropertySourceLinkName.of("[PROPERTY]", "[ROLLUP_PROPERTY_SOURCE_LINK]");
   *   RollupPropertySourceLink response =
   *       analyticsAdminServiceClient.getRollupPropertySourceLink(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the roll-up property source link to lookup. Format:
   *     properties/{property_id}/rollupPropertySourceLinks/{rollup_property_source_link_id}
   *     Example: properties/123/rollupPropertySourceLinks/456
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RollupPropertySourceLink getRollupPropertySourceLink(
      RollupPropertySourceLinkName name) {
    GetRollupPropertySourceLinkRequest request =
        GetRollupPropertySourceLinkRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getRollupPropertySourceLink(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lookup for a single roll-up property source Link. Only roll-up properties can have source
   * links, so this method will throw an error if used on other types of properties.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   String name =
   *       RollupPropertySourceLinkName.of("[PROPERTY]", "[ROLLUP_PROPERTY_SOURCE_LINK]").toString();
   *   RollupPropertySourceLink response =
   *       analyticsAdminServiceClient.getRollupPropertySourceLink(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the roll-up property source link to lookup. Format:
   *     properties/{property_id}/rollupPropertySourceLinks/{rollup_property_source_link_id}
   *     Example: properties/123/rollupPropertySourceLinks/456
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RollupPropertySourceLink getRollupPropertySourceLink(String name) {
    GetRollupPropertySourceLinkRequest request =
        GetRollupPropertySourceLinkRequest.newBuilder().setName(name).build();
    return getRollupPropertySourceLink(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lookup for a single roll-up property source Link. Only roll-up properties can have source
   * links, so this method will throw an error if used on other types of properties.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   GetRollupPropertySourceLinkRequest request =
   *       GetRollupPropertySourceLinkRequest.newBuilder()
   *           .setName(
   *               RollupPropertySourceLinkName.of("[PROPERTY]", "[ROLLUP_PROPERTY_SOURCE_LINK]")
   *                   .toString())
   *           .build();
   *   RollupPropertySourceLink response =
   *       analyticsAdminServiceClient.getRollupPropertySourceLink(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RollupPropertySourceLink getRollupPropertySourceLink(
      GetRollupPropertySourceLinkRequest request) {
    return getRollupPropertySourceLinkCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lookup for a single roll-up property source Link. Only roll-up properties can have source
   * links, so this method will throw an error if used on other types of properties.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   GetRollupPropertySourceLinkRequest request =
   *       GetRollupPropertySourceLinkRequest.newBuilder()
   *           .setName(
   *               RollupPropertySourceLinkName.of("[PROPERTY]", "[ROLLUP_PROPERTY_SOURCE_LINK]")
   *                   .toString())
   *           .build();
   *   ApiFuture<RollupPropertySourceLink> future =
   *       analyticsAdminServiceClient.getRollupPropertySourceLinkCallable().futureCall(request);
   *   // Do something.
   *   RollupPropertySourceLink response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetRollupPropertySourceLinkRequest, RollupPropertySourceLink>
      getRollupPropertySourceLinkCallable() {
    return stub.getRollupPropertySourceLinkCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists roll-up property source Links on a property. Only roll-up properties can have source
   * links, so this method will throw an error if used on other types of properties.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   PropertyName parent = PropertyName.of("[PROPERTY]");
   *   for (RollupPropertySourceLink element :
   *       analyticsAdminServiceClient.listRollupPropertySourceLinks(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The name of the roll-up property to list roll-up property source links
   *     under. Format: properties/{property_id} Example: properties/1234
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListRollupPropertySourceLinksPagedResponse listRollupPropertySourceLinks(
      PropertyName parent) {
    ListRollupPropertySourceLinksRequest request =
        ListRollupPropertySourceLinksRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listRollupPropertySourceLinks(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists roll-up property source Links on a property. Only roll-up properties can have source
   * links, so this method will throw an error if used on other types of properties.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   String parent = PropertyName.of("[PROPERTY]").toString();
   *   for (RollupPropertySourceLink element :
   *       analyticsAdminServiceClient.listRollupPropertySourceLinks(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The name of the roll-up property to list roll-up property source links
   *     under. Format: properties/{property_id} Example: properties/1234
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListRollupPropertySourceLinksPagedResponse listRollupPropertySourceLinks(
      String parent) {
    ListRollupPropertySourceLinksRequest request =
        ListRollupPropertySourceLinksRequest.newBuilder().setParent(parent).build();
    return listRollupPropertySourceLinks(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists roll-up property source Links on a property. Only roll-up properties can have source
   * links, so this method will throw an error if used on other types of properties.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   ListRollupPropertySourceLinksRequest request =
   *       ListRollupPropertySourceLinksRequest.newBuilder()
   *           .setParent(PropertyName.of("[PROPERTY]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (RollupPropertySourceLink element :
   *       analyticsAdminServiceClient.listRollupPropertySourceLinks(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListRollupPropertySourceLinksPagedResponse listRollupPropertySourceLinks(
      ListRollupPropertySourceLinksRequest request) {
    return listRollupPropertySourceLinksPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists roll-up property source Links on a property. Only roll-up properties can have source
   * links, so this method will throw an error if used on other types of properties.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   ListRollupPropertySourceLinksRequest request =
   *       ListRollupPropertySourceLinksRequest.newBuilder()
   *           .setParent(PropertyName.of("[PROPERTY]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<RollupPropertySourceLink> future =
   *       analyticsAdminServiceClient
   *           .listRollupPropertySourceLinksPagedCallable()
   *           .futureCall(request);
   *   // Do something.
   *   for (RollupPropertySourceLink element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<
          ListRollupPropertySourceLinksRequest, ListRollupPropertySourceLinksPagedResponse>
      listRollupPropertySourceLinksPagedCallable() {
    return stub.listRollupPropertySourceLinksPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists roll-up property source Links on a property. Only roll-up properties can have source
   * links, so this method will throw an error if used on other types of properties.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   ListRollupPropertySourceLinksRequest request =
   *       ListRollupPropertySourceLinksRequest.newBuilder()
   *           .setParent(PropertyName.of("[PROPERTY]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListRollupPropertySourceLinksResponse response =
   *         analyticsAdminServiceClient.listRollupPropertySourceLinksCallable().call(request);
   *     for (RollupPropertySourceLink element : response.getRollupPropertySourceLinksList()) {
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
  public final UnaryCallable<
          ListRollupPropertySourceLinksRequest, ListRollupPropertySourceLinksResponse>
      listRollupPropertySourceLinksCallable() {
    return stub.listRollupPropertySourceLinksCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a roll-up property source link. Only roll-up properties can have source links, so this
   * method will throw an error if used on other types of properties.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   PropertyName parent = PropertyName.of("[PROPERTY]");
   *   RollupPropertySourceLink rollupPropertySourceLink =
   *       RollupPropertySourceLink.newBuilder().build();
   *   RollupPropertySourceLink response =
   *       analyticsAdminServiceClient.createRollupPropertySourceLink(
   *           parent, rollupPropertySourceLink);
   * }
   * }</pre>
   *
   * @param parent Required. Format: properties/{property_id} Example: properties/1234
   * @param rollupPropertySourceLink Required. The roll-up property source link to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RollupPropertySourceLink createRollupPropertySourceLink(
      PropertyName parent, RollupPropertySourceLink rollupPropertySourceLink) {
    CreateRollupPropertySourceLinkRequest request =
        CreateRollupPropertySourceLinkRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setRollupPropertySourceLink(rollupPropertySourceLink)
            .build();
    return createRollupPropertySourceLink(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a roll-up property source link. Only roll-up properties can have source links, so this
   * method will throw an error if used on other types of properties.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   String parent = PropertyName.of("[PROPERTY]").toString();
   *   RollupPropertySourceLink rollupPropertySourceLink =
   *       RollupPropertySourceLink.newBuilder().build();
   *   RollupPropertySourceLink response =
   *       analyticsAdminServiceClient.createRollupPropertySourceLink(
   *           parent, rollupPropertySourceLink);
   * }
   * }</pre>
   *
   * @param parent Required. Format: properties/{property_id} Example: properties/1234
   * @param rollupPropertySourceLink Required. The roll-up property source link to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RollupPropertySourceLink createRollupPropertySourceLink(
      String parent, RollupPropertySourceLink rollupPropertySourceLink) {
    CreateRollupPropertySourceLinkRequest request =
        CreateRollupPropertySourceLinkRequest.newBuilder()
            .setParent(parent)
            .setRollupPropertySourceLink(rollupPropertySourceLink)
            .build();
    return createRollupPropertySourceLink(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a roll-up property source link. Only roll-up properties can have source links, so this
   * method will throw an error if used on other types of properties.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   CreateRollupPropertySourceLinkRequest request =
   *       CreateRollupPropertySourceLinkRequest.newBuilder()
   *           .setParent(PropertyName.of("[PROPERTY]").toString())
   *           .setRollupPropertySourceLink(RollupPropertySourceLink.newBuilder().build())
   *           .build();
   *   RollupPropertySourceLink response =
   *       analyticsAdminServiceClient.createRollupPropertySourceLink(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RollupPropertySourceLink createRollupPropertySourceLink(
      CreateRollupPropertySourceLinkRequest request) {
    return createRollupPropertySourceLinkCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a roll-up property source link. Only roll-up properties can have source links, so this
   * method will throw an error if used on other types of properties.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   CreateRollupPropertySourceLinkRequest request =
   *       CreateRollupPropertySourceLinkRequest.newBuilder()
   *           .setParent(PropertyName.of("[PROPERTY]").toString())
   *           .setRollupPropertySourceLink(RollupPropertySourceLink.newBuilder().build())
   *           .build();
   *   ApiFuture<RollupPropertySourceLink> future =
   *       analyticsAdminServiceClient.createRollupPropertySourceLinkCallable().futureCall(request);
   *   // Do something.
   *   RollupPropertySourceLink response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateRollupPropertySourceLinkRequest, RollupPropertySourceLink>
      createRollupPropertySourceLinkCallable() {
    return stub.createRollupPropertySourceLinkCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a roll-up property source link. Only roll-up properties can have source links, so this
   * method will throw an error if used on other types of properties.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   RollupPropertySourceLinkName name =
   *       RollupPropertySourceLinkName.of("[PROPERTY]", "[ROLLUP_PROPERTY_SOURCE_LINK]");
   *   analyticsAdminServiceClient.deleteRollupPropertySourceLink(name);
   * }
   * }</pre>
   *
   * @param name Required. Format:
   *     properties/{property_id}/rollupPropertySourceLinks/{rollup_property_source_link_id}
   *     Example: properties/1234/rollupPropertySourceLinks/5678
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteRollupPropertySourceLink(RollupPropertySourceLinkName name) {
    DeleteRollupPropertySourceLinkRequest request =
        DeleteRollupPropertySourceLinkRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    deleteRollupPropertySourceLink(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a roll-up property source link. Only roll-up properties can have source links, so this
   * method will throw an error if used on other types of properties.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   String name =
   *       RollupPropertySourceLinkName.of("[PROPERTY]", "[ROLLUP_PROPERTY_SOURCE_LINK]").toString();
   *   analyticsAdminServiceClient.deleteRollupPropertySourceLink(name);
   * }
   * }</pre>
   *
   * @param name Required. Format:
   *     properties/{property_id}/rollupPropertySourceLinks/{rollup_property_source_link_id}
   *     Example: properties/1234/rollupPropertySourceLinks/5678
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteRollupPropertySourceLink(String name) {
    DeleteRollupPropertySourceLinkRequest request =
        DeleteRollupPropertySourceLinkRequest.newBuilder().setName(name).build();
    deleteRollupPropertySourceLink(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a roll-up property source link. Only roll-up properties can have source links, so this
   * method will throw an error if used on other types of properties.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   DeleteRollupPropertySourceLinkRequest request =
   *       DeleteRollupPropertySourceLinkRequest.newBuilder()
   *           .setName(
   *               RollupPropertySourceLinkName.of("[PROPERTY]", "[ROLLUP_PROPERTY_SOURCE_LINK]")
   *                   .toString())
   *           .build();
   *   analyticsAdminServiceClient.deleteRollupPropertySourceLink(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteRollupPropertySourceLink(DeleteRollupPropertySourceLinkRequest request) {
    deleteRollupPropertySourceLinkCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a roll-up property source link. Only roll-up properties can have source links, so this
   * method will throw an error if used on other types of properties.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   DeleteRollupPropertySourceLinkRequest request =
   *       DeleteRollupPropertySourceLinkRequest.newBuilder()
   *           .setName(
   *               RollupPropertySourceLinkName.of("[PROPERTY]", "[ROLLUP_PROPERTY_SOURCE_LINK]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Empty> future =
   *       analyticsAdminServiceClient.deleteRollupPropertySourceLinkCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteRollupPropertySourceLinkRequest, Empty>
      deleteRollupPropertySourceLinkCallable() {
    return stub.deleteRollupPropertySourceLinkCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a subproperty and a subproperty event filter that applies to the created subproperty.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   CreateSubpropertyRequest request =
   *       CreateSubpropertyRequest.newBuilder()
   *           .setParent(PropertyName.of("[PROPERTY]").toString())
   *           .setSubproperty(Property.newBuilder().build())
   *           .setSubpropertyEventFilter(SubpropertyEventFilter.newBuilder().build())
   *           .build();
   *   CreateSubpropertyResponse response = analyticsAdminServiceClient.createSubproperty(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CreateSubpropertyResponse createSubproperty(CreateSubpropertyRequest request) {
    return createSubpropertyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a subproperty and a subproperty event filter that applies to the created subproperty.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   CreateSubpropertyRequest request =
   *       CreateSubpropertyRequest.newBuilder()
   *           .setParent(PropertyName.of("[PROPERTY]").toString())
   *           .setSubproperty(Property.newBuilder().build())
   *           .setSubpropertyEventFilter(SubpropertyEventFilter.newBuilder().build())
   *           .build();
   *   ApiFuture<CreateSubpropertyResponse> future =
   *       analyticsAdminServiceClient.createSubpropertyCallable().futureCall(request);
   *   // Do something.
   *   CreateSubpropertyResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateSubpropertyRequest, CreateSubpropertyResponse>
      createSubpropertyCallable() {
    return stub.createSubpropertyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a subproperty Event Filter.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   PropertyName parent = PropertyName.of("[PROPERTY]");
   *   SubpropertyEventFilter subpropertyEventFilter = SubpropertyEventFilter.newBuilder().build();
   *   SubpropertyEventFilter response =
   *       analyticsAdminServiceClient.createSubpropertyEventFilter(parent, subpropertyEventFilter);
   * }
   * }</pre>
   *
   * @param parent Required. The ordinary property for which to create a subproperty event filter.
   *     Format: properties/property_id Example: properties/123
   * @param subpropertyEventFilter Required. The subproperty event filter to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SubpropertyEventFilter createSubpropertyEventFilter(
      PropertyName parent, SubpropertyEventFilter subpropertyEventFilter) {
    CreateSubpropertyEventFilterRequest request =
        CreateSubpropertyEventFilterRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setSubpropertyEventFilter(subpropertyEventFilter)
            .build();
    return createSubpropertyEventFilter(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a subproperty Event Filter.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   String parent = PropertyName.of("[PROPERTY]").toString();
   *   SubpropertyEventFilter subpropertyEventFilter = SubpropertyEventFilter.newBuilder().build();
   *   SubpropertyEventFilter response =
   *       analyticsAdminServiceClient.createSubpropertyEventFilter(parent, subpropertyEventFilter);
   * }
   * }</pre>
   *
   * @param parent Required. The ordinary property for which to create a subproperty event filter.
   *     Format: properties/property_id Example: properties/123
   * @param subpropertyEventFilter Required. The subproperty event filter to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SubpropertyEventFilter createSubpropertyEventFilter(
      String parent, SubpropertyEventFilter subpropertyEventFilter) {
    CreateSubpropertyEventFilterRequest request =
        CreateSubpropertyEventFilterRequest.newBuilder()
            .setParent(parent)
            .setSubpropertyEventFilter(subpropertyEventFilter)
            .build();
    return createSubpropertyEventFilter(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a subproperty Event Filter.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   CreateSubpropertyEventFilterRequest request =
   *       CreateSubpropertyEventFilterRequest.newBuilder()
   *           .setParent(PropertyName.of("[PROPERTY]").toString())
   *           .setSubpropertyEventFilter(SubpropertyEventFilter.newBuilder().build())
   *           .build();
   *   SubpropertyEventFilter response =
   *       analyticsAdminServiceClient.createSubpropertyEventFilter(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SubpropertyEventFilter createSubpropertyEventFilter(
      CreateSubpropertyEventFilterRequest request) {
    return createSubpropertyEventFilterCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a subproperty Event Filter.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   CreateSubpropertyEventFilterRequest request =
   *       CreateSubpropertyEventFilterRequest.newBuilder()
   *           .setParent(PropertyName.of("[PROPERTY]").toString())
   *           .setSubpropertyEventFilter(SubpropertyEventFilter.newBuilder().build())
   *           .build();
   *   ApiFuture<SubpropertyEventFilter> future =
   *       analyticsAdminServiceClient.createSubpropertyEventFilterCallable().futureCall(request);
   *   // Do something.
   *   SubpropertyEventFilter response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateSubpropertyEventFilterRequest, SubpropertyEventFilter>
      createSubpropertyEventFilterCallable() {
    return stub.createSubpropertyEventFilterCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lookup for a single subproperty Event Filter.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   SubpropertyEventFilterName name =
   *       SubpropertyEventFilterName.of("[PROPERTY]", "[SUB_PROPERTY_EVENT_FILTER]");
   *   SubpropertyEventFilter response = analyticsAdminServiceClient.getSubpropertyEventFilter(name);
   * }
   * }</pre>
   *
   * @param name Required. Resource name of the subproperty event filter to lookup. Format:
   *     properties/property_id/subpropertyEventFilters/subproperty_event_filter Example:
   *     properties/123/subpropertyEventFilters/456
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SubpropertyEventFilter getSubpropertyEventFilter(SubpropertyEventFilterName name) {
    GetSubpropertyEventFilterRequest request =
        GetSubpropertyEventFilterRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getSubpropertyEventFilter(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lookup for a single subproperty Event Filter.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   String name =
   *       SubpropertyEventFilterName.of("[PROPERTY]", "[SUB_PROPERTY_EVENT_FILTER]").toString();
   *   SubpropertyEventFilter response = analyticsAdminServiceClient.getSubpropertyEventFilter(name);
   * }
   * }</pre>
   *
   * @param name Required. Resource name of the subproperty event filter to lookup. Format:
   *     properties/property_id/subpropertyEventFilters/subproperty_event_filter Example:
   *     properties/123/subpropertyEventFilters/456
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SubpropertyEventFilter getSubpropertyEventFilter(String name) {
    GetSubpropertyEventFilterRequest request =
        GetSubpropertyEventFilterRequest.newBuilder().setName(name).build();
    return getSubpropertyEventFilter(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lookup for a single subproperty Event Filter.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   GetSubpropertyEventFilterRequest request =
   *       GetSubpropertyEventFilterRequest.newBuilder()
   *           .setName(
   *               SubpropertyEventFilterName.of("[PROPERTY]", "[SUB_PROPERTY_EVENT_FILTER]")
   *                   .toString())
   *           .build();
   *   SubpropertyEventFilter response =
   *       analyticsAdminServiceClient.getSubpropertyEventFilter(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SubpropertyEventFilter getSubpropertyEventFilter(
      GetSubpropertyEventFilterRequest request) {
    return getSubpropertyEventFilterCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lookup for a single subproperty Event Filter.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   GetSubpropertyEventFilterRequest request =
   *       GetSubpropertyEventFilterRequest.newBuilder()
   *           .setName(
   *               SubpropertyEventFilterName.of("[PROPERTY]", "[SUB_PROPERTY_EVENT_FILTER]")
   *                   .toString())
   *           .build();
   *   ApiFuture<SubpropertyEventFilter> future =
   *       analyticsAdminServiceClient.getSubpropertyEventFilterCallable().futureCall(request);
   *   // Do something.
   *   SubpropertyEventFilter response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetSubpropertyEventFilterRequest, SubpropertyEventFilter>
      getSubpropertyEventFilterCallable() {
    return stub.getSubpropertyEventFilterCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List all subproperty Event Filters on a property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   PropertyName parent = PropertyName.of("[PROPERTY]");
   *   for (SubpropertyEventFilter element :
   *       analyticsAdminServiceClient.listSubpropertyEventFilters(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Resource name of the ordinary property. Format: properties/property_id
   *     Example: properties/123
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSubpropertyEventFiltersPagedResponse listSubpropertyEventFilters(
      PropertyName parent) {
    ListSubpropertyEventFiltersRequest request =
        ListSubpropertyEventFiltersRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listSubpropertyEventFilters(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List all subproperty Event Filters on a property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   String parent = PropertyName.of("[PROPERTY]").toString();
   *   for (SubpropertyEventFilter element :
   *       analyticsAdminServiceClient.listSubpropertyEventFilters(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Resource name of the ordinary property. Format: properties/property_id
   *     Example: properties/123
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSubpropertyEventFiltersPagedResponse listSubpropertyEventFilters(String parent) {
    ListSubpropertyEventFiltersRequest request =
        ListSubpropertyEventFiltersRequest.newBuilder().setParent(parent).build();
    return listSubpropertyEventFilters(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List all subproperty Event Filters on a property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   ListSubpropertyEventFiltersRequest request =
   *       ListSubpropertyEventFiltersRequest.newBuilder()
   *           .setParent(PropertyName.of("[PROPERTY]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (SubpropertyEventFilter element :
   *       analyticsAdminServiceClient.listSubpropertyEventFilters(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSubpropertyEventFiltersPagedResponse listSubpropertyEventFilters(
      ListSubpropertyEventFiltersRequest request) {
    return listSubpropertyEventFiltersPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List all subproperty Event Filters on a property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   ListSubpropertyEventFiltersRequest request =
   *       ListSubpropertyEventFiltersRequest.newBuilder()
   *           .setParent(PropertyName.of("[PROPERTY]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<SubpropertyEventFilter> future =
   *       analyticsAdminServiceClient
   *           .listSubpropertyEventFiltersPagedCallable()
   *           .futureCall(request);
   *   // Do something.
   *   for (SubpropertyEventFilter element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<
          ListSubpropertyEventFiltersRequest, ListSubpropertyEventFiltersPagedResponse>
      listSubpropertyEventFiltersPagedCallable() {
    return stub.listSubpropertyEventFiltersPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List all subproperty Event Filters on a property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   ListSubpropertyEventFiltersRequest request =
   *       ListSubpropertyEventFiltersRequest.newBuilder()
   *           .setParent(PropertyName.of("[PROPERTY]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListSubpropertyEventFiltersResponse response =
   *         analyticsAdminServiceClient.listSubpropertyEventFiltersCallable().call(request);
   *     for (SubpropertyEventFilter element : response.getSubpropertyEventFiltersList()) {
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
  public final UnaryCallable<
          ListSubpropertyEventFiltersRequest, ListSubpropertyEventFiltersResponse>
      listSubpropertyEventFiltersCallable() {
    return stub.listSubpropertyEventFiltersCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a subproperty Event Filter.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   SubpropertyEventFilter subpropertyEventFilter = SubpropertyEventFilter.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   SubpropertyEventFilter response =
   *       analyticsAdminServiceClient.updateSubpropertyEventFilter(
   *           subpropertyEventFilter, updateMask);
   * }
   * }</pre>
   *
   * @param subpropertyEventFilter Required. The subproperty event filter to update.
   * @param updateMask Required. The list of fields to update. Field names must be in snake case
   *     (for example, "field_to_update"). Omitted fields will not be updated. To replace the entire
   *     entity, use one path with the string "&#42;" to match all fields.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SubpropertyEventFilter updateSubpropertyEventFilter(
      SubpropertyEventFilter subpropertyEventFilter, FieldMask updateMask) {
    UpdateSubpropertyEventFilterRequest request =
        UpdateSubpropertyEventFilterRequest.newBuilder()
            .setSubpropertyEventFilter(subpropertyEventFilter)
            .setUpdateMask(updateMask)
            .build();
    return updateSubpropertyEventFilter(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a subproperty Event Filter.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   UpdateSubpropertyEventFilterRequest request =
   *       UpdateSubpropertyEventFilterRequest.newBuilder()
   *           .setSubpropertyEventFilter(SubpropertyEventFilter.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   SubpropertyEventFilter response =
   *       analyticsAdminServiceClient.updateSubpropertyEventFilter(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SubpropertyEventFilter updateSubpropertyEventFilter(
      UpdateSubpropertyEventFilterRequest request) {
    return updateSubpropertyEventFilterCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a subproperty Event Filter.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   UpdateSubpropertyEventFilterRequest request =
   *       UpdateSubpropertyEventFilterRequest.newBuilder()
   *           .setSubpropertyEventFilter(SubpropertyEventFilter.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<SubpropertyEventFilter> future =
   *       analyticsAdminServiceClient.updateSubpropertyEventFilterCallable().futureCall(request);
   *   // Do something.
   *   SubpropertyEventFilter response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateSubpropertyEventFilterRequest, SubpropertyEventFilter>
      updateSubpropertyEventFilterCallable() {
    return stub.updateSubpropertyEventFilterCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a subproperty event filter.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   SubpropertyEventFilterName name =
   *       SubpropertyEventFilterName.of("[PROPERTY]", "[SUB_PROPERTY_EVENT_FILTER]");
   *   analyticsAdminServiceClient.deleteSubpropertyEventFilter(name);
   * }
   * }</pre>
   *
   * @param name Required. Resource name of the subproperty event filter to delete. Format:
   *     properties/property_id/subpropertyEventFilters/subproperty_event_filter Example:
   *     properties/123/subpropertyEventFilters/456
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteSubpropertyEventFilter(SubpropertyEventFilterName name) {
    DeleteSubpropertyEventFilterRequest request =
        DeleteSubpropertyEventFilterRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    deleteSubpropertyEventFilter(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a subproperty event filter.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   String name =
   *       SubpropertyEventFilterName.of("[PROPERTY]", "[SUB_PROPERTY_EVENT_FILTER]").toString();
   *   analyticsAdminServiceClient.deleteSubpropertyEventFilter(name);
   * }
   * }</pre>
   *
   * @param name Required. Resource name of the subproperty event filter to delete. Format:
   *     properties/property_id/subpropertyEventFilters/subproperty_event_filter Example:
   *     properties/123/subpropertyEventFilters/456
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteSubpropertyEventFilter(String name) {
    DeleteSubpropertyEventFilterRequest request =
        DeleteSubpropertyEventFilterRequest.newBuilder().setName(name).build();
    deleteSubpropertyEventFilter(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a subproperty event filter.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   DeleteSubpropertyEventFilterRequest request =
   *       DeleteSubpropertyEventFilterRequest.newBuilder()
   *           .setName(
   *               SubpropertyEventFilterName.of("[PROPERTY]", "[SUB_PROPERTY_EVENT_FILTER]")
   *                   .toString())
   *           .build();
   *   analyticsAdminServiceClient.deleteSubpropertyEventFilter(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteSubpropertyEventFilter(DeleteSubpropertyEventFilterRequest request) {
    deleteSubpropertyEventFilterCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a subproperty event filter.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
   *     AnalyticsAdminServiceClient.create()) {
   *   DeleteSubpropertyEventFilterRequest request =
   *       DeleteSubpropertyEventFilterRequest.newBuilder()
   *           .setName(
   *               SubpropertyEventFilterName.of("[PROPERTY]", "[SUB_PROPERTY_EVENT_FILTER]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Empty> future =
   *       analyticsAdminServiceClient.deleteSubpropertyEventFilterCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteSubpropertyEventFilterRequest, Empty>
      deleteSubpropertyEventFilterCallable() {
    return stub.deleteSubpropertyEventFilterCallable();
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

  public static class ListAccountSummariesPagedResponse
      extends AbstractPagedListResponse<
          ListAccountSummariesRequest,
          ListAccountSummariesResponse,
          AccountSummary,
          ListAccountSummariesPage,
          ListAccountSummariesFixedSizeCollection> {

    public static ApiFuture<ListAccountSummariesPagedResponse> createAsync(
        PageContext<ListAccountSummariesRequest, ListAccountSummariesResponse, AccountSummary>
            context,
        ApiFuture<ListAccountSummariesResponse> futureResponse) {
      ApiFuture<ListAccountSummariesPage> futurePage =
          ListAccountSummariesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListAccountSummariesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListAccountSummariesPagedResponse(ListAccountSummariesPage page) {
      super(page, ListAccountSummariesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListAccountSummariesPage
      extends AbstractPage<
          ListAccountSummariesRequest,
          ListAccountSummariesResponse,
          AccountSummary,
          ListAccountSummariesPage> {

    private ListAccountSummariesPage(
        PageContext<ListAccountSummariesRequest, ListAccountSummariesResponse, AccountSummary>
            context,
        ListAccountSummariesResponse response) {
      super(context, response);
    }

    private static ListAccountSummariesPage createEmptyPage() {
      return new ListAccountSummariesPage(null, null);
    }

    @Override
    protected ListAccountSummariesPage createPage(
        PageContext<ListAccountSummariesRequest, ListAccountSummariesResponse, AccountSummary>
            context,
        ListAccountSummariesResponse response) {
      return new ListAccountSummariesPage(context, response);
    }

    @Override
    public ApiFuture<ListAccountSummariesPage> createPageAsync(
        PageContext<ListAccountSummariesRequest, ListAccountSummariesResponse, AccountSummary>
            context,
        ApiFuture<ListAccountSummariesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListAccountSummariesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListAccountSummariesRequest,
          ListAccountSummariesResponse,
          AccountSummary,
          ListAccountSummariesPage,
          ListAccountSummariesFixedSizeCollection> {

    private ListAccountSummariesFixedSizeCollection(
        List<ListAccountSummariesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListAccountSummariesFixedSizeCollection createEmptyCollection() {
      return new ListAccountSummariesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListAccountSummariesFixedSizeCollection createCollection(
        List<ListAccountSummariesPage> pages, int collectionSize) {
      return new ListAccountSummariesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListPropertiesPagedResponse
      extends AbstractPagedListResponse<
          ListPropertiesRequest,
          ListPropertiesResponse,
          Property,
          ListPropertiesPage,
          ListPropertiesFixedSizeCollection> {

    public static ApiFuture<ListPropertiesPagedResponse> createAsync(
        PageContext<ListPropertiesRequest, ListPropertiesResponse, Property> context,
        ApiFuture<ListPropertiesResponse> futureResponse) {
      ApiFuture<ListPropertiesPage> futurePage =
          ListPropertiesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListPropertiesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListPropertiesPagedResponse(ListPropertiesPage page) {
      super(page, ListPropertiesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListPropertiesPage
      extends AbstractPage<
          ListPropertiesRequest, ListPropertiesResponse, Property, ListPropertiesPage> {

    private ListPropertiesPage(
        PageContext<ListPropertiesRequest, ListPropertiesResponse, Property> context,
        ListPropertiesResponse response) {
      super(context, response);
    }

    private static ListPropertiesPage createEmptyPage() {
      return new ListPropertiesPage(null, null);
    }

    @Override
    protected ListPropertiesPage createPage(
        PageContext<ListPropertiesRequest, ListPropertiesResponse, Property> context,
        ListPropertiesResponse response) {
      return new ListPropertiesPage(context, response);
    }

    @Override
    public ApiFuture<ListPropertiesPage> createPageAsync(
        PageContext<ListPropertiesRequest, ListPropertiesResponse, Property> context,
        ApiFuture<ListPropertiesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListPropertiesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListPropertiesRequest,
          ListPropertiesResponse,
          Property,
          ListPropertiesPage,
          ListPropertiesFixedSizeCollection> {

    private ListPropertiesFixedSizeCollection(List<ListPropertiesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListPropertiesFixedSizeCollection createEmptyCollection() {
      return new ListPropertiesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListPropertiesFixedSizeCollection createCollection(
        List<ListPropertiesPage> pages, int collectionSize) {
      return new ListPropertiesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListFirebaseLinksPagedResponse
      extends AbstractPagedListResponse<
          ListFirebaseLinksRequest,
          ListFirebaseLinksResponse,
          FirebaseLink,
          ListFirebaseLinksPage,
          ListFirebaseLinksFixedSizeCollection> {

    public static ApiFuture<ListFirebaseLinksPagedResponse> createAsync(
        PageContext<ListFirebaseLinksRequest, ListFirebaseLinksResponse, FirebaseLink> context,
        ApiFuture<ListFirebaseLinksResponse> futureResponse) {
      ApiFuture<ListFirebaseLinksPage> futurePage =
          ListFirebaseLinksPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListFirebaseLinksPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListFirebaseLinksPagedResponse(ListFirebaseLinksPage page) {
      super(page, ListFirebaseLinksFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListFirebaseLinksPage
      extends AbstractPage<
          ListFirebaseLinksRequest,
          ListFirebaseLinksResponse,
          FirebaseLink,
          ListFirebaseLinksPage> {

    private ListFirebaseLinksPage(
        PageContext<ListFirebaseLinksRequest, ListFirebaseLinksResponse, FirebaseLink> context,
        ListFirebaseLinksResponse response) {
      super(context, response);
    }

    private static ListFirebaseLinksPage createEmptyPage() {
      return new ListFirebaseLinksPage(null, null);
    }

    @Override
    protected ListFirebaseLinksPage createPage(
        PageContext<ListFirebaseLinksRequest, ListFirebaseLinksResponse, FirebaseLink> context,
        ListFirebaseLinksResponse response) {
      return new ListFirebaseLinksPage(context, response);
    }

    @Override
    public ApiFuture<ListFirebaseLinksPage> createPageAsync(
        PageContext<ListFirebaseLinksRequest, ListFirebaseLinksResponse, FirebaseLink> context,
        ApiFuture<ListFirebaseLinksResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListFirebaseLinksFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListFirebaseLinksRequest,
          ListFirebaseLinksResponse,
          FirebaseLink,
          ListFirebaseLinksPage,
          ListFirebaseLinksFixedSizeCollection> {

    private ListFirebaseLinksFixedSizeCollection(
        List<ListFirebaseLinksPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListFirebaseLinksFixedSizeCollection createEmptyCollection() {
      return new ListFirebaseLinksFixedSizeCollection(null, 0);
    }

    @Override
    protected ListFirebaseLinksFixedSizeCollection createCollection(
        List<ListFirebaseLinksPage> pages, int collectionSize) {
      return new ListFirebaseLinksFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListGoogleAdsLinksPagedResponse
      extends AbstractPagedListResponse<
          ListGoogleAdsLinksRequest,
          ListGoogleAdsLinksResponse,
          GoogleAdsLink,
          ListGoogleAdsLinksPage,
          ListGoogleAdsLinksFixedSizeCollection> {

    public static ApiFuture<ListGoogleAdsLinksPagedResponse> createAsync(
        PageContext<ListGoogleAdsLinksRequest, ListGoogleAdsLinksResponse, GoogleAdsLink> context,
        ApiFuture<ListGoogleAdsLinksResponse> futureResponse) {
      ApiFuture<ListGoogleAdsLinksPage> futurePage =
          ListGoogleAdsLinksPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListGoogleAdsLinksPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListGoogleAdsLinksPagedResponse(ListGoogleAdsLinksPage page) {
      super(page, ListGoogleAdsLinksFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListGoogleAdsLinksPage
      extends AbstractPage<
          ListGoogleAdsLinksRequest,
          ListGoogleAdsLinksResponse,
          GoogleAdsLink,
          ListGoogleAdsLinksPage> {

    private ListGoogleAdsLinksPage(
        PageContext<ListGoogleAdsLinksRequest, ListGoogleAdsLinksResponse, GoogleAdsLink> context,
        ListGoogleAdsLinksResponse response) {
      super(context, response);
    }

    private static ListGoogleAdsLinksPage createEmptyPage() {
      return new ListGoogleAdsLinksPage(null, null);
    }

    @Override
    protected ListGoogleAdsLinksPage createPage(
        PageContext<ListGoogleAdsLinksRequest, ListGoogleAdsLinksResponse, GoogleAdsLink> context,
        ListGoogleAdsLinksResponse response) {
      return new ListGoogleAdsLinksPage(context, response);
    }

    @Override
    public ApiFuture<ListGoogleAdsLinksPage> createPageAsync(
        PageContext<ListGoogleAdsLinksRequest, ListGoogleAdsLinksResponse, GoogleAdsLink> context,
        ApiFuture<ListGoogleAdsLinksResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListGoogleAdsLinksFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListGoogleAdsLinksRequest,
          ListGoogleAdsLinksResponse,
          GoogleAdsLink,
          ListGoogleAdsLinksPage,
          ListGoogleAdsLinksFixedSizeCollection> {

    private ListGoogleAdsLinksFixedSizeCollection(
        List<ListGoogleAdsLinksPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListGoogleAdsLinksFixedSizeCollection createEmptyCollection() {
      return new ListGoogleAdsLinksFixedSizeCollection(null, 0);
    }

    @Override
    protected ListGoogleAdsLinksFixedSizeCollection createCollection(
        List<ListGoogleAdsLinksPage> pages, int collectionSize) {
      return new ListGoogleAdsLinksFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListMeasurementProtocolSecretsPagedResponse
      extends AbstractPagedListResponse<
          ListMeasurementProtocolSecretsRequest,
          ListMeasurementProtocolSecretsResponse,
          MeasurementProtocolSecret,
          ListMeasurementProtocolSecretsPage,
          ListMeasurementProtocolSecretsFixedSizeCollection> {

    public static ApiFuture<ListMeasurementProtocolSecretsPagedResponse> createAsync(
        PageContext<
                ListMeasurementProtocolSecretsRequest,
                ListMeasurementProtocolSecretsResponse,
                MeasurementProtocolSecret>
            context,
        ApiFuture<ListMeasurementProtocolSecretsResponse> futureResponse) {
      ApiFuture<ListMeasurementProtocolSecretsPage> futurePage =
          ListMeasurementProtocolSecretsPage.createEmptyPage()
              .createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListMeasurementProtocolSecretsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListMeasurementProtocolSecretsPagedResponse(ListMeasurementProtocolSecretsPage page) {
      super(page, ListMeasurementProtocolSecretsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListMeasurementProtocolSecretsPage
      extends AbstractPage<
          ListMeasurementProtocolSecretsRequest,
          ListMeasurementProtocolSecretsResponse,
          MeasurementProtocolSecret,
          ListMeasurementProtocolSecretsPage> {

    private ListMeasurementProtocolSecretsPage(
        PageContext<
                ListMeasurementProtocolSecretsRequest,
                ListMeasurementProtocolSecretsResponse,
                MeasurementProtocolSecret>
            context,
        ListMeasurementProtocolSecretsResponse response) {
      super(context, response);
    }

    private static ListMeasurementProtocolSecretsPage createEmptyPage() {
      return new ListMeasurementProtocolSecretsPage(null, null);
    }

    @Override
    protected ListMeasurementProtocolSecretsPage createPage(
        PageContext<
                ListMeasurementProtocolSecretsRequest,
                ListMeasurementProtocolSecretsResponse,
                MeasurementProtocolSecret>
            context,
        ListMeasurementProtocolSecretsResponse response) {
      return new ListMeasurementProtocolSecretsPage(context, response);
    }

    @Override
    public ApiFuture<ListMeasurementProtocolSecretsPage> createPageAsync(
        PageContext<
                ListMeasurementProtocolSecretsRequest,
                ListMeasurementProtocolSecretsResponse,
                MeasurementProtocolSecret>
            context,
        ApiFuture<ListMeasurementProtocolSecretsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListMeasurementProtocolSecretsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListMeasurementProtocolSecretsRequest,
          ListMeasurementProtocolSecretsResponse,
          MeasurementProtocolSecret,
          ListMeasurementProtocolSecretsPage,
          ListMeasurementProtocolSecretsFixedSizeCollection> {

    private ListMeasurementProtocolSecretsFixedSizeCollection(
        List<ListMeasurementProtocolSecretsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListMeasurementProtocolSecretsFixedSizeCollection createEmptyCollection() {
      return new ListMeasurementProtocolSecretsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListMeasurementProtocolSecretsFixedSizeCollection createCollection(
        List<ListMeasurementProtocolSecretsPage> pages, int collectionSize) {
      return new ListMeasurementProtocolSecretsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListSKAdNetworkConversionValueSchemasPagedResponse
      extends AbstractPagedListResponse<
          ListSKAdNetworkConversionValueSchemasRequest,
          ListSKAdNetworkConversionValueSchemasResponse,
          SKAdNetworkConversionValueSchema,
          ListSKAdNetworkConversionValueSchemasPage,
          ListSKAdNetworkConversionValueSchemasFixedSizeCollection> {

    public static ApiFuture<ListSKAdNetworkConversionValueSchemasPagedResponse> createAsync(
        PageContext<
                ListSKAdNetworkConversionValueSchemasRequest,
                ListSKAdNetworkConversionValueSchemasResponse,
                SKAdNetworkConversionValueSchema>
            context,
        ApiFuture<ListSKAdNetworkConversionValueSchemasResponse> futureResponse) {
      ApiFuture<ListSKAdNetworkConversionValueSchemasPage> futurePage =
          ListSKAdNetworkConversionValueSchemasPage.createEmptyPage()
              .createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListSKAdNetworkConversionValueSchemasPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListSKAdNetworkConversionValueSchemasPagedResponse(
        ListSKAdNetworkConversionValueSchemasPage page) {
      super(page, ListSKAdNetworkConversionValueSchemasFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListSKAdNetworkConversionValueSchemasPage
      extends AbstractPage<
          ListSKAdNetworkConversionValueSchemasRequest,
          ListSKAdNetworkConversionValueSchemasResponse,
          SKAdNetworkConversionValueSchema,
          ListSKAdNetworkConversionValueSchemasPage> {

    private ListSKAdNetworkConversionValueSchemasPage(
        PageContext<
                ListSKAdNetworkConversionValueSchemasRequest,
                ListSKAdNetworkConversionValueSchemasResponse,
                SKAdNetworkConversionValueSchema>
            context,
        ListSKAdNetworkConversionValueSchemasResponse response) {
      super(context, response);
    }

    private static ListSKAdNetworkConversionValueSchemasPage createEmptyPage() {
      return new ListSKAdNetworkConversionValueSchemasPage(null, null);
    }

    @Override
    protected ListSKAdNetworkConversionValueSchemasPage createPage(
        PageContext<
                ListSKAdNetworkConversionValueSchemasRequest,
                ListSKAdNetworkConversionValueSchemasResponse,
                SKAdNetworkConversionValueSchema>
            context,
        ListSKAdNetworkConversionValueSchemasResponse response) {
      return new ListSKAdNetworkConversionValueSchemasPage(context, response);
    }

    @Override
    public ApiFuture<ListSKAdNetworkConversionValueSchemasPage> createPageAsync(
        PageContext<
                ListSKAdNetworkConversionValueSchemasRequest,
                ListSKAdNetworkConversionValueSchemasResponse,
                SKAdNetworkConversionValueSchema>
            context,
        ApiFuture<ListSKAdNetworkConversionValueSchemasResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListSKAdNetworkConversionValueSchemasFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListSKAdNetworkConversionValueSchemasRequest,
          ListSKAdNetworkConversionValueSchemasResponse,
          SKAdNetworkConversionValueSchema,
          ListSKAdNetworkConversionValueSchemasPage,
          ListSKAdNetworkConversionValueSchemasFixedSizeCollection> {

    private ListSKAdNetworkConversionValueSchemasFixedSizeCollection(
        List<ListSKAdNetworkConversionValueSchemasPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListSKAdNetworkConversionValueSchemasFixedSizeCollection
        createEmptyCollection() {
      return new ListSKAdNetworkConversionValueSchemasFixedSizeCollection(null, 0);
    }

    @Override
    protected ListSKAdNetworkConversionValueSchemasFixedSizeCollection createCollection(
        List<ListSKAdNetworkConversionValueSchemasPage> pages, int collectionSize) {
      return new ListSKAdNetworkConversionValueSchemasFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class SearchChangeHistoryEventsPagedResponse
      extends AbstractPagedListResponse<
          SearchChangeHistoryEventsRequest,
          SearchChangeHistoryEventsResponse,
          ChangeHistoryEvent,
          SearchChangeHistoryEventsPage,
          SearchChangeHistoryEventsFixedSizeCollection> {

    public static ApiFuture<SearchChangeHistoryEventsPagedResponse> createAsync(
        PageContext<
                SearchChangeHistoryEventsRequest,
                SearchChangeHistoryEventsResponse,
                ChangeHistoryEvent>
            context,
        ApiFuture<SearchChangeHistoryEventsResponse> futureResponse) {
      ApiFuture<SearchChangeHistoryEventsPage> futurePage =
          SearchChangeHistoryEventsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new SearchChangeHistoryEventsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private SearchChangeHistoryEventsPagedResponse(SearchChangeHistoryEventsPage page) {
      super(page, SearchChangeHistoryEventsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class SearchChangeHistoryEventsPage
      extends AbstractPage<
          SearchChangeHistoryEventsRequest,
          SearchChangeHistoryEventsResponse,
          ChangeHistoryEvent,
          SearchChangeHistoryEventsPage> {

    private SearchChangeHistoryEventsPage(
        PageContext<
                SearchChangeHistoryEventsRequest,
                SearchChangeHistoryEventsResponse,
                ChangeHistoryEvent>
            context,
        SearchChangeHistoryEventsResponse response) {
      super(context, response);
    }

    private static SearchChangeHistoryEventsPage createEmptyPage() {
      return new SearchChangeHistoryEventsPage(null, null);
    }

    @Override
    protected SearchChangeHistoryEventsPage createPage(
        PageContext<
                SearchChangeHistoryEventsRequest,
                SearchChangeHistoryEventsResponse,
                ChangeHistoryEvent>
            context,
        SearchChangeHistoryEventsResponse response) {
      return new SearchChangeHistoryEventsPage(context, response);
    }

    @Override
    public ApiFuture<SearchChangeHistoryEventsPage> createPageAsync(
        PageContext<
                SearchChangeHistoryEventsRequest,
                SearchChangeHistoryEventsResponse,
                ChangeHistoryEvent>
            context,
        ApiFuture<SearchChangeHistoryEventsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class SearchChangeHistoryEventsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          SearchChangeHistoryEventsRequest,
          SearchChangeHistoryEventsResponse,
          ChangeHistoryEvent,
          SearchChangeHistoryEventsPage,
          SearchChangeHistoryEventsFixedSizeCollection> {

    private SearchChangeHistoryEventsFixedSizeCollection(
        List<SearchChangeHistoryEventsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static SearchChangeHistoryEventsFixedSizeCollection createEmptyCollection() {
      return new SearchChangeHistoryEventsFixedSizeCollection(null, 0);
    }

    @Override
    protected SearchChangeHistoryEventsFixedSizeCollection createCollection(
        List<SearchChangeHistoryEventsPage> pages, int collectionSize) {
      return new SearchChangeHistoryEventsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListConversionEventsPagedResponse
      extends AbstractPagedListResponse<
          ListConversionEventsRequest,
          ListConversionEventsResponse,
          ConversionEvent,
          ListConversionEventsPage,
          ListConversionEventsFixedSizeCollection> {

    public static ApiFuture<ListConversionEventsPagedResponse> createAsync(
        PageContext<ListConversionEventsRequest, ListConversionEventsResponse, ConversionEvent>
            context,
        ApiFuture<ListConversionEventsResponse> futureResponse) {
      ApiFuture<ListConversionEventsPage> futurePage =
          ListConversionEventsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListConversionEventsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListConversionEventsPagedResponse(ListConversionEventsPage page) {
      super(page, ListConversionEventsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListConversionEventsPage
      extends AbstractPage<
          ListConversionEventsRequest,
          ListConversionEventsResponse,
          ConversionEvent,
          ListConversionEventsPage> {

    private ListConversionEventsPage(
        PageContext<ListConversionEventsRequest, ListConversionEventsResponse, ConversionEvent>
            context,
        ListConversionEventsResponse response) {
      super(context, response);
    }

    private static ListConversionEventsPage createEmptyPage() {
      return new ListConversionEventsPage(null, null);
    }

    @Override
    protected ListConversionEventsPage createPage(
        PageContext<ListConversionEventsRequest, ListConversionEventsResponse, ConversionEvent>
            context,
        ListConversionEventsResponse response) {
      return new ListConversionEventsPage(context, response);
    }

    @Override
    public ApiFuture<ListConversionEventsPage> createPageAsync(
        PageContext<ListConversionEventsRequest, ListConversionEventsResponse, ConversionEvent>
            context,
        ApiFuture<ListConversionEventsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListConversionEventsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListConversionEventsRequest,
          ListConversionEventsResponse,
          ConversionEvent,
          ListConversionEventsPage,
          ListConversionEventsFixedSizeCollection> {

    private ListConversionEventsFixedSizeCollection(
        List<ListConversionEventsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListConversionEventsFixedSizeCollection createEmptyCollection() {
      return new ListConversionEventsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListConversionEventsFixedSizeCollection createCollection(
        List<ListConversionEventsPage> pages, int collectionSize) {
      return new ListConversionEventsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListDisplayVideo360AdvertiserLinksPagedResponse
      extends AbstractPagedListResponse<
          ListDisplayVideo360AdvertiserLinksRequest,
          ListDisplayVideo360AdvertiserLinksResponse,
          DisplayVideo360AdvertiserLink,
          ListDisplayVideo360AdvertiserLinksPage,
          ListDisplayVideo360AdvertiserLinksFixedSizeCollection> {

    public static ApiFuture<ListDisplayVideo360AdvertiserLinksPagedResponse> createAsync(
        PageContext<
                ListDisplayVideo360AdvertiserLinksRequest,
                ListDisplayVideo360AdvertiserLinksResponse,
                DisplayVideo360AdvertiserLink>
            context,
        ApiFuture<ListDisplayVideo360AdvertiserLinksResponse> futureResponse) {
      ApiFuture<ListDisplayVideo360AdvertiserLinksPage> futurePage =
          ListDisplayVideo360AdvertiserLinksPage.createEmptyPage()
              .createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListDisplayVideo360AdvertiserLinksPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListDisplayVideo360AdvertiserLinksPagedResponse(
        ListDisplayVideo360AdvertiserLinksPage page) {
      super(page, ListDisplayVideo360AdvertiserLinksFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListDisplayVideo360AdvertiserLinksPage
      extends AbstractPage<
          ListDisplayVideo360AdvertiserLinksRequest,
          ListDisplayVideo360AdvertiserLinksResponse,
          DisplayVideo360AdvertiserLink,
          ListDisplayVideo360AdvertiserLinksPage> {

    private ListDisplayVideo360AdvertiserLinksPage(
        PageContext<
                ListDisplayVideo360AdvertiserLinksRequest,
                ListDisplayVideo360AdvertiserLinksResponse,
                DisplayVideo360AdvertiserLink>
            context,
        ListDisplayVideo360AdvertiserLinksResponse response) {
      super(context, response);
    }

    private static ListDisplayVideo360AdvertiserLinksPage createEmptyPage() {
      return new ListDisplayVideo360AdvertiserLinksPage(null, null);
    }

    @Override
    protected ListDisplayVideo360AdvertiserLinksPage createPage(
        PageContext<
                ListDisplayVideo360AdvertiserLinksRequest,
                ListDisplayVideo360AdvertiserLinksResponse,
                DisplayVideo360AdvertiserLink>
            context,
        ListDisplayVideo360AdvertiserLinksResponse response) {
      return new ListDisplayVideo360AdvertiserLinksPage(context, response);
    }

    @Override
    public ApiFuture<ListDisplayVideo360AdvertiserLinksPage> createPageAsync(
        PageContext<
                ListDisplayVideo360AdvertiserLinksRequest,
                ListDisplayVideo360AdvertiserLinksResponse,
                DisplayVideo360AdvertiserLink>
            context,
        ApiFuture<ListDisplayVideo360AdvertiserLinksResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListDisplayVideo360AdvertiserLinksFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListDisplayVideo360AdvertiserLinksRequest,
          ListDisplayVideo360AdvertiserLinksResponse,
          DisplayVideo360AdvertiserLink,
          ListDisplayVideo360AdvertiserLinksPage,
          ListDisplayVideo360AdvertiserLinksFixedSizeCollection> {

    private ListDisplayVideo360AdvertiserLinksFixedSizeCollection(
        List<ListDisplayVideo360AdvertiserLinksPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListDisplayVideo360AdvertiserLinksFixedSizeCollection createEmptyCollection() {
      return new ListDisplayVideo360AdvertiserLinksFixedSizeCollection(null, 0);
    }

    @Override
    protected ListDisplayVideo360AdvertiserLinksFixedSizeCollection createCollection(
        List<ListDisplayVideo360AdvertiserLinksPage> pages, int collectionSize) {
      return new ListDisplayVideo360AdvertiserLinksFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListDisplayVideo360AdvertiserLinkProposalsPagedResponse
      extends AbstractPagedListResponse<
          ListDisplayVideo360AdvertiserLinkProposalsRequest,
          ListDisplayVideo360AdvertiserLinkProposalsResponse,
          DisplayVideo360AdvertiserLinkProposal,
          ListDisplayVideo360AdvertiserLinkProposalsPage,
          ListDisplayVideo360AdvertiserLinkProposalsFixedSizeCollection> {

    public static ApiFuture<ListDisplayVideo360AdvertiserLinkProposalsPagedResponse> createAsync(
        PageContext<
                ListDisplayVideo360AdvertiserLinkProposalsRequest,
                ListDisplayVideo360AdvertiserLinkProposalsResponse,
                DisplayVideo360AdvertiserLinkProposal>
            context,
        ApiFuture<ListDisplayVideo360AdvertiserLinkProposalsResponse> futureResponse) {
      ApiFuture<ListDisplayVideo360AdvertiserLinkProposalsPage> futurePage =
          ListDisplayVideo360AdvertiserLinkProposalsPage.createEmptyPage()
              .createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListDisplayVideo360AdvertiserLinkProposalsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListDisplayVideo360AdvertiserLinkProposalsPagedResponse(
        ListDisplayVideo360AdvertiserLinkProposalsPage page) {
      super(
          page,
          ListDisplayVideo360AdvertiserLinkProposalsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListDisplayVideo360AdvertiserLinkProposalsPage
      extends AbstractPage<
          ListDisplayVideo360AdvertiserLinkProposalsRequest,
          ListDisplayVideo360AdvertiserLinkProposalsResponse,
          DisplayVideo360AdvertiserLinkProposal,
          ListDisplayVideo360AdvertiserLinkProposalsPage> {

    private ListDisplayVideo360AdvertiserLinkProposalsPage(
        PageContext<
                ListDisplayVideo360AdvertiserLinkProposalsRequest,
                ListDisplayVideo360AdvertiserLinkProposalsResponse,
                DisplayVideo360AdvertiserLinkProposal>
            context,
        ListDisplayVideo360AdvertiserLinkProposalsResponse response) {
      super(context, response);
    }

    private static ListDisplayVideo360AdvertiserLinkProposalsPage createEmptyPage() {
      return new ListDisplayVideo360AdvertiserLinkProposalsPage(null, null);
    }

    @Override
    protected ListDisplayVideo360AdvertiserLinkProposalsPage createPage(
        PageContext<
                ListDisplayVideo360AdvertiserLinkProposalsRequest,
                ListDisplayVideo360AdvertiserLinkProposalsResponse,
                DisplayVideo360AdvertiserLinkProposal>
            context,
        ListDisplayVideo360AdvertiserLinkProposalsResponse response) {
      return new ListDisplayVideo360AdvertiserLinkProposalsPage(context, response);
    }

    @Override
    public ApiFuture<ListDisplayVideo360AdvertiserLinkProposalsPage> createPageAsync(
        PageContext<
                ListDisplayVideo360AdvertiserLinkProposalsRequest,
                ListDisplayVideo360AdvertiserLinkProposalsResponse,
                DisplayVideo360AdvertiserLinkProposal>
            context,
        ApiFuture<ListDisplayVideo360AdvertiserLinkProposalsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListDisplayVideo360AdvertiserLinkProposalsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListDisplayVideo360AdvertiserLinkProposalsRequest,
          ListDisplayVideo360AdvertiserLinkProposalsResponse,
          DisplayVideo360AdvertiserLinkProposal,
          ListDisplayVideo360AdvertiserLinkProposalsPage,
          ListDisplayVideo360AdvertiserLinkProposalsFixedSizeCollection> {

    private ListDisplayVideo360AdvertiserLinkProposalsFixedSizeCollection(
        List<ListDisplayVideo360AdvertiserLinkProposalsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListDisplayVideo360AdvertiserLinkProposalsFixedSizeCollection
        createEmptyCollection() {
      return new ListDisplayVideo360AdvertiserLinkProposalsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListDisplayVideo360AdvertiserLinkProposalsFixedSizeCollection createCollection(
        List<ListDisplayVideo360AdvertiserLinkProposalsPage> pages, int collectionSize) {
      return new ListDisplayVideo360AdvertiserLinkProposalsFixedSizeCollection(
          pages, collectionSize);
    }
  }

  public static class ListCustomDimensionsPagedResponse
      extends AbstractPagedListResponse<
          ListCustomDimensionsRequest,
          ListCustomDimensionsResponse,
          CustomDimension,
          ListCustomDimensionsPage,
          ListCustomDimensionsFixedSizeCollection> {

    public static ApiFuture<ListCustomDimensionsPagedResponse> createAsync(
        PageContext<ListCustomDimensionsRequest, ListCustomDimensionsResponse, CustomDimension>
            context,
        ApiFuture<ListCustomDimensionsResponse> futureResponse) {
      ApiFuture<ListCustomDimensionsPage> futurePage =
          ListCustomDimensionsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListCustomDimensionsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListCustomDimensionsPagedResponse(ListCustomDimensionsPage page) {
      super(page, ListCustomDimensionsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListCustomDimensionsPage
      extends AbstractPage<
          ListCustomDimensionsRequest,
          ListCustomDimensionsResponse,
          CustomDimension,
          ListCustomDimensionsPage> {

    private ListCustomDimensionsPage(
        PageContext<ListCustomDimensionsRequest, ListCustomDimensionsResponse, CustomDimension>
            context,
        ListCustomDimensionsResponse response) {
      super(context, response);
    }

    private static ListCustomDimensionsPage createEmptyPage() {
      return new ListCustomDimensionsPage(null, null);
    }

    @Override
    protected ListCustomDimensionsPage createPage(
        PageContext<ListCustomDimensionsRequest, ListCustomDimensionsResponse, CustomDimension>
            context,
        ListCustomDimensionsResponse response) {
      return new ListCustomDimensionsPage(context, response);
    }

    @Override
    public ApiFuture<ListCustomDimensionsPage> createPageAsync(
        PageContext<ListCustomDimensionsRequest, ListCustomDimensionsResponse, CustomDimension>
            context,
        ApiFuture<ListCustomDimensionsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListCustomDimensionsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListCustomDimensionsRequest,
          ListCustomDimensionsResponse,
          CustomDimension,
          ListCustomDimensionsPage,
          ListCustomDimensionsFixedSizeCollection> {

    private ListCustomDimensionsFixedSizeCollection(
        List<ListCustomDimensionsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListCustomDimensionsFixedSizeCollection createEmptyCollection() {
      return new ListCustomDimensionsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListCustomDimensionsFixedSizeCollection createCollection(
        List<ListCustomDimensionsPage> pages, int collectionSize) {
      return new ListCustomDimensionsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListCustomMetricsPagedResponse
      extends AbstractPagedListResponse<
          ListCustomMetricsRequest,
          ListCustomMetricsResponse,
          CustomMetric,
          ListCustomMetricsPage,
          ListCustomMetricsFixedSizeCollection> {

    public static ApiFuture<ListCustomMetricsPagedResponse> createAsync(
        PageContext<ListCustomMetricsRequest, ListCustomMetricsResponse, CustomMetric> context,
        ApiFuture<ListCustomMetricsResponse> futureResponse) {
      ApiFuture<ListCustomMetricsPage> futurePage =
          ListCustomMetricsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListCustomMetricsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListCustomMetricsPagedResponse(ListCustomMetricsPage page) {
      super(page, ListCustomMetricsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListCustomMetricsPage
      extends AbstractPage<
          ListCustomMetricsRequest,
          ListCustomMetricsResponse,
          CustomMetric,
          ListCustomMetricsPage> {

    private ListCustomMetricsPage(
        PageContext<ListCustomMetricsRequest, ListCustomMetricsResponse, CustomMetric> context,
        ListCustomMetricsResponse response) {
      super(context, response);
    }

    private static ListCustomMetricsPage createEmptyPage() {
      return new ListCustomMetricsPage(null, null);
    }

    @Override
    protected ListCustomMetricsPage createPage(
        PageContext<ListCustomMetricsRequest, ListCustomMetricsResponse, CustomMetric> context,
        ListCustomMetricsResponse response) {
      return new ListCustomMetricsPage(context, response);
    }

    @Override
    public ApiFuture<ListCustomMetricsPage> createPageAsync(
        PageContext<ListCustomMetricsRequest, ListCustomMetricsResponse, CustomMetric> context,
        ApiFuture<ListCustomMetricsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListCustomMetricsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListCustomMetricsRequest,
          ListCustomMetricsResponse,
          CustomMetric,
          ListCustomMetricsPage,
          ListCustomMetricsFixedSizeCollection> {

    private ListCustomMetricsFixedSizeCollection(
        List<ListCustomMetricsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListCustomMetricsFixedSizeCollection createEmptyCollection() {
      return new ListCustomMetricsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListCustomMetricsFixedSizeCollection createCollection(
        List<ListCustomMetricsPage> pages, int collectionSize) {
      return new ListCustomMetricsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListDataStreamsPagedResponse
      extends AbstractPagedListResponse<
          ListDataStreamsRequest,
          ListDataStreamsResponse,
          DataStream,
          ListDataStreamsPage,
          ListDataStreamsFixedSizeCollection> {

    public static ApiFuture<ListDataStreamsPagedResponse> createAsync(
        PageContext<ListDataStreamsRequest, ListDataStreamsResponse, DataStream> context,
        ApiFuture<ListDataStreamsResponse> futureResponse) {
      ApiFuture<ListDataStreamsPage> futurePage =
          ListDataStreamsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListDataStreamsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListDataStreamsPagedResponse(ListDataStreamsPage page) {
      super(page, ListDataStreamsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListDataStreamsPage
      extends AbstractPage<
          ListDataStreamsRequest, ListDataStreamsResponse, DataStream, ListDataStreamsPage> {

    private ListDataStreamsPage(
        PageContext<ListDataStreamsRequest, ListDataStreamsResponse, DataStream> context,
        ListDataStreamsResponse response) {
      super(context, response);
    }

    private static ListDataStreamsPage createEmptyPage() {
      return new ListDataStreamsPage(null, null);
    }

    @Override
    protected ListDataStreamsPage createPage(
        PageContext<ListDataStreamsRequest, ListDataStreamsResponse, DataStream> context,
        ListDataStreamsResponse response) {
      return new ListDataStreamsPage(context, response);
    }

    @Override
    public ApiFuture<ListDataStreamsPage> createPageAsync(
        PageContext<ListDataStreamsRequest, ListDataStreamsResponse, DataStream> context,
        ApiFuture<ListDataStreamsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListDataStreamsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListDataStreamsRequest,
          ListDataStreamsResponse,
          DataStream,
          ListDataStreamsPage,
          ListDataStreamsFixedSizeCollection> {

    private ListDataStreamsFixedSizeCollection(
        List<ListDataStreamsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListDataStreamsFixedSizeCollection createEmptyCollection() {
      return new ListDataStreamsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListDataStreamsFixedSizeCollection createCollection(
        List<ListDataStreamsPage> pages, int collectionSize) {
      return new ListDataStreamsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListAudiencesPagedResponse
      extends AbstractPagedListResponse<
          ListAudiencesRequest,
          ListAudiencesResponse,
          Audience,
          ListAudiencesPage,
          ListAudiencesFixedSizeCollection> {

    public static ApiFuture<ListAudiencesPagedResponse> createAsync(
        PageContext<ListAudiencesRequest, ListAudiencesResponse, Audience> context,
        ApiFuture<ListAudiencesResponse> futureResponse) {
      ApiFuture<ListAudiencesPage> futurePage =
          ListAudiencesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListAudiencesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListAudiencesPagedResponse(ListAudiencesPage page) {
      super(page, ListAudiencesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListAudiencesPage
      extends AbstractPage<
          ListAudiencesRequest, ListAudiencesResponse, Audience, ListAudiencesPage> {

    private ListAudiencesPage(
        PageContext<ListAudiencesRequest, ListAudiencesResponse, Audience> context,
        ListAudiencesResponse response) {
      super(context, response);
    }

    private static ListAudiencesPage createEmptyPage() {
      return new ListAudiencesPage(null, null);
    }

    @Override
    protected ListAudiencesPage createPage(
        PageContext<ListAudiencesRequest, ListAudiencesResponse, Audience> context,
        ListAudiencesResponse response) {
      return new ListAudiencesPage(context, response);
    }

    @Override
    public ApiFuture<ListAudiencesPage> createPageAsync(
        PageContext<ListAudiencesRequest, ListAudiencesResponse, Audience> context,
        ApiFuture<ListAudiencesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListAudiencesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListAudiencesRequest,
          ListAudiencesResponse,
          Audience,
          ListAudiencesPage,
          ListAudiencesFixedSizeCollection> {

    private ListAudiencesFixedSizeCollection(List<ListAudiencesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListAudiencesFixedSizeCollection createEmptyCollection() {
      return new ListAudiencesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListAudiencesFixedSizeCollection createCollection(
        List<ListAudiencesPage> pages, int collectionSize) {
      return new ListAudiencesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListSearchAds360LinksPagedResponse
      extends AbstractPagedListResponse<
          ListSearchAds360LinksRequest,
          ListSearchAds360LinksResponse,
          SearchAds360Link,
          ListSearchAds360LinksPage,
          ListSearchAds360LinksFixedSizeCollection> {

    public static ApiFuture<ListSearchAds360LinksPagedResponse> createAsync(
        PageContext<ListSearchAds360LinksRequest, ListSearchAds360LinksResponse, SearchAds360Link>
            context,
        ApiFuture<ListSearchAds360LinksResponse> futureResponse) {
      ApiFuture<ListSearchAds360LinksPage> futurePage =
          ListSearchAds360LinksPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListSearchAds360LinksPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListSearchAds360LinksPagedResponse(ListSearchAds360LinksPage page) {
      super(page, ListSearchAds360LinksFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListSearchAds360LinksPage
      extends AbstractPage<
          ListSearchAds360LinksRequest,
          ListSearchAds360LinksResponse,
          SearchAds360Link,
          ListSearchAds360LinksPage> {

    private ListSearchAds360LinksPage(
        PageContext<ListSearchAds360LinksRequest, ListSearchAds360LinksResponse, SearchAds360Link>
            context,
        ListSearchAds360LinksResponse response) {
      super(context, response);
    }

    private static ListSearchAds360LinksPage createEmptyPage() {
      return new ListSearchAds360LinksPage(null, null);
    }

    @Override
    protected ListSearchAds360LinksPage createPage(
        PageContext<ListSearchAds360LinksRequest, ListSearchAds360LinksResponse, SearchAds360Link>
            context,
        ListSearchAds360LinksResponse response) {
      return new ListSearchAds360LinksPage(context, response);
    }

    @Override
    public ApiFuture<ListSearchAds360LinksPage> createPageAsync(
        PageContext<ListSearchAds360LinksRequest, ListSearchAds360LinksResponse, SearchAds360Link>
            context,
        ApiFuture<ListSearchAds360LinksResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListSearchAds360LinksFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListSearchAds360LinksRequest,
          ListSearchAds360LinksResponse,
          SearchAds360Link,
          ListSearchAds360LinksPage,
          ListSearchAds360LinksFixedSizeCollection> {

    private ListSearchAds360LinksFixedSizeCollection(
        List<ListSearchAds360LinksPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListSearchAds360LinksFixedSizeCollection createEmptyCollection() {
      return new ListSearchAds360LinksFixedSizeCollection(null, 0);
    }

    @Override
    protected ListSearchAds360LinksFixedSizeCollection createCollection(
        List<ListSearchAds360LinksPage> pages, int collectionSize) {
      return new ListSearchAds360LinksFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListAccessBindingsPagedResponse
      extends AbstractPagedListResponse<
          ListAccessBindingsRequest,
          ListAccessBindingsResponse,
          AccessBinding,
          ListAccessBindingsPage,
          ListAccessBindingsFixedSizeCollection> {

    public static ApiFuture<ListAccessBindingsPagedResponse> createAsync(
        PageContext<ListAccessBindingsRequest, ListAccessBindingsResponse, AccessBinding> context,
        ApiFuture<ListAccessBindingsResponse> futureResponse) {
      ApiFuture<ListAccessBindingsPage> futurePage =
          ListAccessBindingsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListAccessBindingsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListAccessBindingsPagedResponse(ListAccessBindingsPage page) {
      super(page, ListAccessBindingsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListAccessBindingsPage
      extends AbstractPage<
          ListAccessBindingsRequest,
          ListAccessBindingsResponse,
          AccessBinding,
          ListAccessBindingsPage> {

    private ListAccessBindingsPage(
        PageContext<ListAccessBindingsRequest, ListAccessBindingsResponse, AccessBinding> context,
        ListAccessBindingsResponse response) {
      super(context, response);
    }

    private static ListAccessBindingsPage createEmptyPage() {
      return new ListAccessBindingsPage(null, null);
    }

    @Override
    protected ListAccessBindingsPage createPage(
        PageContext<ListAccessBindingsRequest, ListAccessBindingsResponse, AccessBinding> context,
        ListAccessBindingsResponse response) {
      return new ListAccessBindingsPage(context, response);
    }

    @Override
    public ApiFuture<ListAccessBindingsPage> createPageAsync(
        PageContext<ListAccessBindingsRequest, ListAccessBindingsResponse, AccessBinding> context,
        ApiFuture<ListAccessBindingsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListAccessBindingsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListAccessBindingsRequest,
          ListAccessBindingsResponse,
          AccessBinding,
          ListAccessBindingsPage,
          ListAccessBindingsFixedSizeCollection> {

    private ListAccessBindingsFixedSizeCollection(
        List<ListAccessBindingsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListAccessBindingsFixedSizeCollection createEmptyCollection() {
      return new ListAccessBindingsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListAccessBindingsFixedSizeCollection createCollection(
        List<ListAccessBindingsPage> pages, int collectionSize) {
      return new ListAccessBindingsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListExpandedDataSetsPagedResponse
      extends AbstractPagedListResponse<
          ListExpandedDataSetsRequest,
          ListExpandedDataSetsResponse,
          ExpandedDataSet,
          ListExpandedDataSetsPage,
          ListExpandedDataSetsFixedSizeCollection> {

    public static ApiFuture<ListExpandedDataSetsPagedResponse> createAsync(
        PageContext<ListExpandedDataSetsRequest, ListExpandedDataSetsResponse, ExpandedDataSet>
            context,
        ApiFuture<ListExpandedDataSetsResponse> futureResponse) {
      ApiFuture<ListExpandedDataSetsPage> futurePage =
          ListExpandedDataSetsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListExpandedDataSetsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListExpandedDataSetsPagedResponse(ListExpandedDataSetsPage page) {
      super(page, ListExpandedDataSetsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListExpandedDataSetsPage
      extends AbstractPage<
          ListExpandedDataSetsRequest,
          ListExpandedDataSetsResponse,
          ExpandedDataSet,
          ListExpandedDataSetsPage> {

    private ListExpandedDataSetsPage(
        PageContext<ListExpandedDataSetsRequest, ListExpandedDataSetsResponse, ExpandedDataSet>
            context,
        ListExpandedDataSetsResponse response) {
      super(context, response);
    }

    private static ListExpandedDataSetsPage createEmptyPage() {
      return new ListExpandedDataSetsPage(null, null);
    }

    @Override
    protected ListExpandedDataSetsPage createPage(
        PageContext<ListExpandedDataSetsRequest, ListExpandedDataSetsResponse, ExpandedDataSet>
            context,
        ListExpandedDataSetsResponse response) {
      return new ListExpandedDataSetsPage(context, response);
    }

    @Override
    public ApiFuture<ListExpandedDataSetsPage> createPageAsync(
        PageContext<ListExpandedDataSetsRequest, ListExpandedDataSetsResponse, ExpandedDataSet>
            context,
        ApiFuture<ListExpandedDataSetsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListExpandedDataSetsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListExpandedDataSetsRequest,
          ListExpandedDataSetsResponse,
          ExpandedDataSet,
          ListExpandedDataSetsPage,
          ListExpandedDataSetsFixedSizeCollection> {

    private ListExpandedDataSetsFixedSizeCollection(
        List<ListExpandedDataSetsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListExpandedDataSetsFixedSizeCollection createEmptyCollection() {
      return new ListExpandedDataSetsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListExpandedDataSetsFixedSizeCollection createCollection(
        List<ListExpandedDataSetsPage> pages, int collectionSize) {
      return new ListExpandedDataSetsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListChannelGroupsPagedResponse
      extends AbstractPagedListResponse<
          ListChannelGroupsRequest,
          ListChannelGroupsResponse,
          ChannelGroup,
          ListChannelGroupsPage,
          ListChannelGroupsFixedSizeCollection> {

    public static ApiFuture<ListChannelGroupsPagedResponse> createAsync(
        PageContext<ListChannelGroupsRequest, ListChannelGroupsResponse, ChannelGroup> context,
        ApiFuture<ListChannelGroupsResponse> futureResponse) {
      ApiFuture<ListChannelGroupsPage> futurePage =
          ListChannelGroupsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListChannelGroupsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListChannelGroupsPagedResponse(ListChannelGroupsPage page) {
      super(page, ListChannelGroupsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListChannelGroupsPage
      extends AbstractPage<
          ListChannelGroupsRequest,
          ListChannelGroupsResponse,
          ChannelGroup,
          ListChannelGroupsPage> {

    private ListChannelGroupsPage(
        PageContext<ListChannelGroupsRequest, ListChannelGroupsResponse, ChannelGroup> context,
        ListChannelGroupsResponse response) {
      super(context, response);
    }

    private static ListChannelGroupsPage createEmptyPage() {
      return new ListChannelGroupsPage(null, null);
    }

    @Override
    protected ListChannelGroupsPage createPage(
        PageContext<ListChannelGroupsRequest, ListChannelGroupsResponse, ChannelGroup> context,
        ListChannelGroupsResponse response) {
      return new ListChannelGroupsPage(context, response);
    }

    @Override
    public ApiFuture<ListChannelGroupsPage> createPageAsync(
        PageContext<ListChannelGroupsRequest, ListChannelGroupsResponse, ChannelGroup> context,
        ApiFuture<ListChannelGroupsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListChannelGroupsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListChannelGroupsRequest,
          ListChannelGroupsResponse,
          ChannelGroup,
          ListChannelGroupsPage,
          ListChannelGroupsFixedSizeCollection> {

    private ListChannelGroupsFixedSizeCollection(
        List<ListChannelGroupsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListChannelGroupsFixedSizeCollection createEmptyCollection() {
      return new ListChannelGroupsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListChannelGroupsFixedSizeCollection createCollection(
        List<ListChannelGroupsPage> pages, int collectionSize) {
      return new ListChannelGroupsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListBigQueryLinksPagedResponse
      extends AbstractPagedListResponse<
          ListBigQueryLinksRequest,
          ListBigQueryLinksResponse,
          BigQueryLink,
          ListBigQueryLinksPage,
          ListBigQueryLinksFixedSizeCollection> {

    public static ApiFuture<ListBigQueryLinksPagedResponse> createAsync(
        PageContext<ListBigQueryLinksRequest, ListBigQueryLinksResponse, BigQueryLink> context,
        ApiFuture<ListBigQueryLinksResponse> futureResponse) {
      ApiFuture<ListBigQueryLinksPage> futurePage =
          ListBigQueryLinksPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListBigQueryLinksPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListBigQueryLinksPagedResponse(ListBigQueryLinksPage page) {
      super(page, ListBigQueryLinksFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListBigQueryLinksPage
      extends AbstractPage<
          ListBigQueryLinksRequest,
          ListBigQueryLinksResponse,
          BigQueryLink,
          ListBigQueryLinksPage> {

    private ListBigQueryLinksPage(
        PageContext<ListBigQueryLinksRequest, ListBigQueryLinksResponse, BigQueryLink> context,
        ListBigQueryLinksResponse response) {
      super(context, response);
    }

    private static ListBigQueryLinksPage createEmptyPage() {
      return new ListBigQueryLinksPage(null, null);
    }

    @Override
    protected ListBigQueryLinksPage createPage(
        PageContext<ListBigQueryLinksRequest, ListBigQueryLinksResponse, BigQueryLink> context,
        ListBigQueryLinksResponse response) {
      return new ListBigQueryLinksPage(context, response);
    }

    @Override
    public ApiFuture<ListBigQueryLinksPage> createPageAsync(
        PageContext<ListBigQueryLinksRequest, ListBigQueryLinksResponse, BigQueryLink> context,
        ApiFuture<ListBigQueryLinksResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListBigQueryLinksFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListBigQueryLinksRequest,
          ListBigQueryLinksResponse,
          BigQueryLink,
          ListBigQueryLinksPage,
          ListBigQueryLinksFixedSizeCollection> {

    private ListBigQueryLinksFixedSizeCollection(
        List<ListBigQueryLinksPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListBigQueryLinksFixedSizeCollection createEmptyCollection() {
      return new ListBigQueryLinksFixedSizeCollection(null, 0);
    }

    @Override
    protected ListBigQueryLinksFixedSizeCollection createCollection(
        List<ListBigQueryLinksPage> pages, int collectionSize) {
      return new ListBigQueryLinksFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListAdSenseLinksPagedResponse
      extends AbstractPagedListResponse<
          ListAdSenseLinksRequest,
          ListAdSenseLinksResponse,
          AdSenseLink,
          ListAdSenseLinksPage,
          ListAdSenseLinksFixedSizeCollection> {

    public static ApiFuture<ListAdSenseLinksPagedResponse> createAsync(
        PageContext<ListAdSenseLinksRequest, ListAdSenseLinksResponse, AdSenseLink> context,
        ApiFuture<ListAdSenseLinksResponse> futureResponse) {
      ApiFuture<ListAdSenseLinksPage> futurePage =
          ListAdSenseLinksPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListAdSenseLinksPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListAdSenseLinksPagedResponse(ListAdSenseLinksPage page) {
      super(page, ListAdSenseLinksFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListAdSenseLinksPage
      extends AbstractPage<
          ListAdSenseLinksRequest, ListAdSenseLinksResponse, AdSenseLink, ListAdSenseLinksPage> {

    private ListAdSenseLinksPage(
        PageContext<ListAdSenseLinksRequest, ListAdSenseLinksResponse, AdSenseLink> context,
        ListAdSenseLinksResponse response) {
      super(context, response);
    }

    private static ListAdSenseLinksPage createEmptyPage() {
      return new ListAdSenseLinksPage(null, null);
    }

    @Override
    protected ListAdSenseLinksPage createPage(
        PageContext<ListAdSenseLinksRequest, ListAdSenseLinksResponse, AdSenseLink> context,
        ListAdSenseLinksResponse response) {
      return new ListAdSenseLinksPage(context, response);
    }

    @Override
    public ApiFuture<ListAdSenseLinksPage> createPageAsync(
        PageContext<ListAdSenseLinksRequest, ListAdSenseLinksResponse, AdSenseLink> context,
        ApiFuture<ListAdSenseLinksResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListAdSenseLinksFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListAdSenseLinksRequest,
          ListAdSenseLinksResponse,
          AdSenseLink,
          ListAdSenseLinksPage,
          ListAdSenseLinksFixedSizeCollection> {

    private ListAdSenseLinksFixedSizeCollection(
        List<ListAdSenseLinksPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListAdSenseLinksFixedSizeCollection createEmptyCollection() {
      return new ListAdSenseLinksFixedSizeCollection(null, 0);
    }

    @Override
    protected ListAdSenseLinksFixedSizeCollection createCollection(
        List<ListAdSenseLinksPage> pages, int collectionSize) {
      return new ListAdSenseLinksFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListEventCreateRulesPagedResponse
      extends AbstractPagedListResponse<
          ListEventCreateRulesRequest,
          ListEventCreateRulesResponse,
          EventCreateRule,
          ListEventCreateRulesPage,
          ListEventCreateRulesFixedSizeCollection> {

    public static ApiFuture<ListEventCreateRulesPagedResponse> createAsync(
        PageContext<ListEventCreateRulesRequest, ListEventCreateRulesResponse, EventCreateRule>
            context,
        ApiFuture<ListEventCreateRulesResponse> futureResponse) {
      ApiFuture<ListEventCreateRulesPage> futurePage =
          ListEventCreateRulesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListEventCreateRulesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListEventCreateRulesPagedResponse(ListEventCreateRulesPage page) {
      super(page, ListEventCreateRulesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListEventCreateRulesPage
      extends AbstractPage<
          ListEventCreateRulesRequest,
          ListEventCreateRulesResponse,
          EventCreateRule,
          ListEventCreateRulesPage> {

    private ListEventCreateRulesPage(
        PageContext<ListEventCreateRulesRequest, ListEventCreateRulesResponse, EventCreateRule>
            context,
        ListEventCreateRulesResponse response) {
      super(context, response);
    }

    private static ListEventCreateRulesPage createEmptyPage() {
      return new ListEventCreateRulesPage(null, null);
    }

    @Override
    protected ListEventCreateRulesPage createPage(
        PageContext<ListEventCreateRulesRequest, ListEventCreateRulesResponse, EventCreateRule>
            context,
        ListEventCreateRulesResponse response) {
      return new ListEventCreateRulesPage(context, response);
    }

    @Override
    public ApiFuture<ListEventCreateRulesPage> createPageAsync(
        PageContext<ListEventCreateRulesRequest, ListEventCreateRulesResponse, EventCreateRule>
            context,
        ApiFuture<ListEventCreateRulesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListEventCreateRulesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListEventCreateRulesRequest,
          ListEventCreateRulesResponse,
          EventCreateRule,
          ListEventCreateRulesPage,
          ListEventCreateRulesFixedSizeCollection> {

    private ListEventCreateRulesFixedSizeCollection(
        List<ListEventCreateRulesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListEventCreateRulesFixedSizeCollection createEmptyCollection() {
      return new ListEventCreateRulesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListEventCreateRulesFixedSizeCollection createCollection(
        List<ListEventCreateRulesPage> pages, int collectionSize) {
      return new ListEventCreateRulesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListRollupPropertySourceLinksPagedResponse
      extends AbstractPagedListResponse<
          ListRollupPropertySourceLinksRequest,
          ListRollupPropertySourceLinksResponse,
          RollupPropertySourceLink,
          ListRollupPropertySourceLinksPage,
          ListRollupPropertySourceLinksFixedSizeCollection> {

    public static ApiFuture<ListRollupPropertySourceLinksPagedResponse> createAsync(
        PageContext<
                ListRollupPropertySourceLinksRequest,
                ListRollupPropertySourceLinksResponse,
                RollupPropertySourceLink>
            context,
        ApiFuture<ListRollupPropertySourceLinksResponse> futureResponse) {
      ApiFuture<ListRollupPropertySourceLinksPage> futurePage =
          ListRollupPropertySourceLinksPage.createEmptyPage()
              .createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListRollupPropertySourceLinksPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListRollupPropertySourceLinksPagedResponse(ListRollupPropertySourceLinksPage page) {
      super(page, ListRollupPropertySourceLinksFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListRollupPropertySourceLinksPage
      extends AbstractPage<
          ListRollupPropertySourceLinksRequest,
          ListRollupPropertySourceLinksResponse,
          RollupPropertySourceLink,
          ListRollupPropertySourceLinksPage> {

    private ListRollupPropertySourceLinksPage(
        PageContext<
                ListRollupPropertySourceLinksRequest,
                ListRollupPropertySourceLinksResponse,
                RollupPropertySourceLink>
            context,
        ListRollupPropertySourceLinksResponse response) {
      super(context, response);
    }

    private static ListRollupPropertySourceLinksPage createEmptyPage() {
      return new ListRollupPropertySourceLinksPage(null, null);
    }

    @Override
    protected ListRollupPropertySourceLinksPage createPage(
        PageContext<
                ListRollupPropertySourceLinksRequest,
                ListRollupPropertySourceLinksResponse,
                RollupPropertySourceLink>
            context,
        ListRollupPropertySourceLinksResponse response) {
      return new ListRollupPropertySourceLinksPage(context, response);
    }

    @Override
    public ApiFuture<ListRollupPropertySourceLinksPage> createPageAsync(
        PageContext<
                ListRollupPropertySourceLinksRequest,
                ListRollupPropertySourceLinksResponse,
                RollupPropertySourceLink>
            context,
        ApiFuture<ListRollupPropertySourceLinksResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListRollupPropertySourceLinksFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListRollupPropertySourceLinksRequest,
          ListRollupPropertySourceLinksResponse,
          RollupPropertySourceLink,
          ListRollupPropertySourceLinksPage,
          ListRollupPropertySourceLinksFixedSizeCollection> {

    private ListRollupPropertySourceLinksFixedSizeCollection(
        List<ListRollupPropertySourceLinksPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListRollupPropertySourceLinksFixedSizeCollection createEmptyCollection() {
      return new ListRollupPropertySourceLinksFixedSizeCollection(null, 0);
    }

    @Override
    protected ListRollupPropertySourceLinksFixedSizeCollection createCollection(
        List<ListRollupPropertySourceLinksPage> pages, int collectionSize) {
      return new ListRollupPropertySourceLinksFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListSubpropertyEventFiltersPagedResponse
      extends AbstractPagedListResponse<
          ListSubpropertyEventFiltersRequest,
          ListSubpropertyEventFiltersResponse,
          SubpropertyEventFilter,
          ListSubpropertyEventFiltersPage,
          ListSubpropertyEventFiltersFixedSizeCollection> {

    public static ApiFuture<ListSubpropertyEventFiltersPagedResponse> createAsync(
        PageContext<
                ListSubpropertyEventFiltersRequest,
                ListSubpropertyEventFiltersResponse,
                SubpropertyEventFilter>
            context,
        ApiFuture<ListSubpropertyEventFiltersResponse> futureResponse) {
      ApiFuture<ListSubpropertyEventFiltersPage> futurePage =
          ListSubpropertyEventFiltersPage.createEmptyPage()
              .createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListSubpropertyEventFiltersPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListSubpropertyEventFiltersPagedResponse(ListSubpropertyEventFiltersPage page) {
      super(page, ListSubpropertyEventFiltersFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListSubpropertyEventFiltersPage
      extends AbstractPage<
          ListSubpropertyEventFiltersRequest,
          ListSubpropertyEventFiltersResponse,
          SubpropertyEventFilter,
          ListSubpropertyEventFiltersPage> {

    private ListSubpropertyEventFiltersPage(
        PageContext<
                ListSubpropertyEventFiltersRequest,
                ListSubpropertyEventFiltersResponse,
                SubpropertyEventFilter>
            context,
        ListSubpropertyEventFiltersResponse response) {
      super(context, response);
    }

    private static ListSubpropertyEventFiltersPage createEmptyPage() {
      return new ListSubpropertyEventFiltersPage(null, null);
    }

    @Override
    protected ListSubpropertyEventFiltersPage createPage(
        PageContext<
                ListSubpropertyEventFiltersRequest,
                ListSubpropertyEventFiltersResponse,
                SubpropertyEventFilter>
            context,
        ListSubpropertyEventFiltersResponse response) {
      return new ListSubpropertyEventFiltersPage(context, response);
    }

    @Override
    public ApiFuture<ListSubpropertyEventFiltersPage> createPageAsync(
        PageContext<
                ListSubpropertyEventFiltersRequest,
                ListSubpropertyEventFiltersResponse,
                SubpropertyEventFilter>
            context,
        ApiFuture<ListSubpropertyEventFiltersResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListSubpropertyEventFiltersFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListSubpropertyEventFiltersRequest,
          ListSubpropertyEventFiltersResponse,
          SubpropertyEventFilter,
          ListSubpropertyEventFiltersPage,
          ListSubpropertyEventFiltersFixedSizeCollection> {

    private ListSubpropertyEventFiltersFixedSizeCollection(
        List<ListSubpropertyEventFiltersPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListSubpropertyEventFiltersFixedSizeCollection createEmptyCollection() {
      return new ListSubpropertyEventFiltersFixedSizeCollection(null, 0);
    }

    @Override
    protected ListSubpropertyEventFiltersFixedSizeCollection createCollection(
        List<ListSubpropertyEventFiltersPage> pages, int collectionSize) {
      return new ListSubpropertyEventFiltersFixedSizeCollection(pages, collectionSize);
    }
  }
}
